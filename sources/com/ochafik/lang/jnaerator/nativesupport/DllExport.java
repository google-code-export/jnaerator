package com.ochafik.lang.jnaerator.nativesupport;

import static com.ochafik.lang.jnaerator.nativesupport.dllexport.DbgHelpLibrary.IMAGE_DIRECTORY_ENTRY_EXPORT;
import static com.ochafik.lang.jnaerator.nativesupport.dllexport.DbgHelpLibrary.IMAGE_DOS_SIGNATURE;
import static com.ochafik.lang.jnaerator.nativesupport.dllexport.DbgHelpLibrary.IMAGE_NT_SIGNATURE;
import static com.ochafik.lang.jnaerator.nativesupport.dllexport.DbgHelpLibrary.INSTANCE;
import static com.ochafik.lang.jnaerator.nativesupport.dllexport.DbgHelpLibrary.UNDNAME_COMPLETE;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.ochafik.lang.jnaerator.nativesupport.dllexport.IMAGE_DOS_HEADER;
import com.ochafik.lang.jnaerator.nativesupport.dllexport.IMAGE_EXPORT_DIRECTORY;
import com.ochafik.lang.jnaerator.nativesupport.dllexport.IMAGE_NT_HEADERS;
import com.ochafik.lang.jnaerator.nativesupport.dllexport.IMAGE_SECTION_HEADER;
import com.ochafik.util.string.RegexUtils;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.PointerUtils;
import com.sun.jna.Structure;
public class DllExport {
	private static final Pattern libraryFileNamePattern = Pattern.compile("^([^.]+)\\.dll");
	public static byte[] GetFileBytes(RandomAccessFile raf, long offset, int size) throws IOException {
	   raf.seek(offset);
	   if (size < 0) {
		   ByteArrayOutputStream out = new ByteArrayOutputStream();
		   byte[] b = new byte[1];
		   while (raf.read(b) != 0 && b[0] != 0)
			   out.write(b);
		   return out.toByteArray();
	   }
	   byte[] bytes = new byte[size];
	   raf.readFully(bytes);
	   return bytes;
	}
	public static <S extends Structure> S deserializeStruct(S struct, RandomAccessFile raf, long offset) throws IOException {
	   byte[] bytes = GetFileBytes(raf, offset, struct.size());
	   struct.getPointer().write(0, bytes, 0, bytes.length);
	   struct.read();
	   return struct;
	}
	public static String createSourceFile(File sourceFile, List<ParsedExport> dllExports) {
		if (dllExports == null)
			return null;
		
		StringBuilder b = new StringBuilder();
		b.append("#line \"" + sourceFile + "\"\n");
		for (ParsedExport ex : dllExports) {
			b.append("// @mangling " + ex.mangling + "\n");
			b.append(ex.demangled + ";\n");
			b.append("\n");
		}
		return b.toString();
	}
	public static void main(String[] args) {
		try {
			File f = new File("C:\\Prog\\C++\\DllExportTest\\Release\\DllTest.dll");
			System.out.println(createSourceFile(f, parseDllExports(f)));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static class ParsedExport {
		public String mangling, demangled, library;
	}
	public static List<ParsedExport> parseDllExports(File f) throws IOException {
		List<ParsedExport> ret = new ArrayList<ParsedExport>();
		List<String> list = OutputDllFunctions(f);
		if (list == null)
			return null;
		
		String library = RegexUtils.findFirst(f.getName(), libraryFileNamePattern, 1);
		
		int outSize = 8196;
		byte[] bytes = new byte[outSize];
		Memory m = new Memory(outSize);
		for (String symbol : list) {
			INSTANCE.UnDecorateSymbolName(symbol, m.getByteBuffer(0, outSize), outSize, UNDNAME_COMPLETE);
			m.read(0, bytes, 0, outSize);	
			int len = 0;
			while (len < outSize && bytes[len] != 0)
				len++;
			ParsedExport ex = new ParsedExport();
			ex.mangling = symbol;
			ex.demangled = new String(bytes, 0, len);
			ex.library = library ;
			ret.add(ex);
		}
		return ret;
	}
	private static List<String> OutputDllFunctions(File f) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(f, "r");
		IMAGE_DOS_HEADER dosHeader = deserializeStruct(new IMAGE_DOS_HEADER(), raf, 0);
		if (dosHeader.e_magic != IMAGE_DOS_SIGNATURE)
			return null;
		
		long ntHeaderBase = dosHeader.e_lfanew.longValue();
		IMAGE_NT_HEADERS ntHeader = deserializeStruct(new IMAGE_NT_HEADERS(), raf, ntHeaderBase);
        if (ntHeader.Signature != IMAGE_NT_SIGNATURE)
        	return null;
        
    	int exportsStartRVA = ntHeader.OptionalHeader.DataDirectory[IMAGE_DIRECTORY_ENTRY_EXPORT].VirtualAddress;
    	IMAGE_SECTION_HEADER header = GetExportsSectionHeader(raf, exportsStartRVA, ntHeaderBase, ntHeader );
        if (header == null)
        	return null;

        int delta = header.VirtualAddress - header.PointerToRawData;
        IMAGE_EXPORT_DIRECTORY exportDir = deserializeStruct(new IMAGE_EXPORT_DIRECTORY(), raf, exportsStartRVA - delta);
        
        List<String> ret = new ArrayList<String>(exportDir.NumberOfNames);
		//IntBuffer functions = ByteBuffer.wrap(GetFileBytes(raf, PointerUtils.getAddress(exportDir.AddressOfFunctions) - delta, exportDir.NumberOfFunctions * 4)).asIntBuffer();
        //ShortBuffer ordinals = ByteBuffer.wrap(GetFileBytes(raf, PointerUtils.getAddress(exportDir.AddressOfNameOrdinals) - delta, exportDir.NumberOfNames * 2)).asShortBuffer();
        for (int i = 0; i < exportDir.NumberOfNames; i++ ) {
            int pstr = readLittleEndianInt(raf, PointerUtils.getAddress(exportDir.AddressOfNames) - delta + i * Pointer.SIZE);
            String name = new String(GetFileBytes(raf, pstr - delta, -1));
            ret.add(name);
        }
        return ret;
	}
	public static int readLittleEndianInt(RandomAccessFile raf, long l) throws IOException {
        raf.seek(l);
        byte[] bytes = new byte[4];
        raf.read(bytes);
        return ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().get(0);
	}
	private static IMAGE_SECTION_HEADER GetExportsSectionHeader(RandomAccessFile raf, int exportsStartRVA, long ntHeaderBase, IMAGE_NT_HEADERS ntHeader) throws IOException {
		IMAGE_SECTION_HEADER firstSection = new IMAGE_SECTION_HEADER();
		byte[] bytes = GetFileBytes(
			raf, 
			ntHeaderBase +
			PointerUtils.getAddress(ntHeader.OptionalHeader.getPointer()) - 
			PointerUtils.getAddress(ntHeader.getPointer()) + 
			ntHeader.FileHeader.SizeOfOptionalHeader,
			firstSection.size() * ntHeader.FileHeader.NumberOfSections
		);
		IMAGE_SECTION_HEADER[] sections = firstSection.toArray(ntHeader.FileHeader.NumberOfSections);
		sections[0].getPointer().write(0, bytes, 0, bytes.length);
		for (IMAGE_SECTION_HEADER section : sections) {
			section.read();
			if (exportsStartRVA >= section.VirtualAddress && exportsStartRVA < (section.VirtualAddress + section.Misc.VirtualSize))
				return section;
		}
		return null;
	}
}
