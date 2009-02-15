/*
	Copyright (c) 2009 Olivier Chafik, All Rights Reserved
	
	This file is part of JNAerator (http://jnaerator.googlecode.com/).
	
	JNAerator is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.
	
	JNAerator is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.
	
	You should have received a copy of the GNU General Public License
	along with JNAerator.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.ochafik.lang.jnaerator;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ochafik.lang.jnaerator.parser.Element;
import com.ochafik.lang.jnaerator.parser.Function;
import com.ochafik.util.listenable.AdaptedCollection;
import com.ochafik.util.listenable.Adapter;
import com.ochafik.util.listenable.Filter;

public class JNAeratorConfig {

	public enum Compiler {
		GCC, MSVC
	}
	public enum Architecture {
		x86_64, i386, PowerPC
	}
	public enum Platform {
		Windows, Linux, MacOSX
	}
	
	public static class PreprocessorConfig {

		public boolean WORKAROUND_PP_BUGS = true;

		public final List<String> includes = new ArrayList<String>();
		public final Map<String, String> macros = new HashMap<String, String>();
		public final List<String> frameworksPath = new ArrayList<String>();
	}
	
	public final JNAeratorConfig.PreprocessorConfig preprocessorConfig = new JNAeratorConfig.PreprocessorConfig();
	public boolean followIncludes = false;
	
	//List<File> files = new ArrayList<File>();
	
	public FileFilter fileFilter = JNAeratorConfigUtils.HEADERS_FILE_FILTER;
	
	public Map<File, String> libraryByFile = new HashMap<File, String>();
	public void addFile(File file, String library) throws IOException {
		if (file.isFile()) {
			if (fileFilter.accept(file)) {
				libraryByFile.put(file.getCanonicalFile(), library);
			}
		} else {
			File[] fs = file.listFiles();
			if (fs != null) {
				for (File f : fs) {
					addFile(f, library);
				}
			}
		}
	}

	public boolean verbose = false;
	public File outputDir = new File(".");
	public List<String> rootDirectoriesPrefixesForSourceComments = new ArrayList<String>();
	public Adapter<Function, Boolean> functionsAccepter;
	public String packageName = null, rootPackageName = null;
	public String defaultLibrary;
	public Map<String, File> libraryProjectSources = new HashMap<String, File>();
	public Adapter<File, String> fileToLibrary = new Adapter<File, String>() {
		public String adapt(File value) {
			String libraryFile = null;
			try {
				//String canoFile = value.getCanonicalPath();
				//libraryFile = libraryByFile.get(canoFile);
				libraryFile = libraryByFile.get(value.getCanonicalFile());
				//if (value.toString().startsWith("\""))
				//	new Exception("Double quotes in file !").printStackTrace();
//				if (!canoFile.contains("Program Files")) {
//					System.out.println("libraryByFile = " + libraryByFile);
//					System.out.println("libraryByFile(" + canoFile + ") = " + libraryFile);
//					System.out.println("    value = " + value);
//					System.out.println("can value = " + value.getCanonicalFile());
//					System.out.println("abs value = " + value.getAbsoluteFile());
//				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			return libraryFile == null ? defaultLibrary : libraryFile;
		}
	};
	public void addRootDir(File dir) throws IOException {
		if (!dir.exists())
			return;
		String str = dir.getCanonicalPath();
		if (!str.endsWith(File.separator))
			str += File.separator;
		if (!rootDirectoriesPrefixesForSourceComments.contains(str))
			rootDirectoriesPrefixesForSourceComments.add(str);
	}
	public Filter<Element> symbolsAccepter = new Filter<Element>() {
		public boolean accept(Element value) {
			String s = Element.getFileOfAscendency(value);
			if (s == null)
				return false;
			
			File f = new File(s);
			try {
				f = f.getCanonicalFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return libraryByFile.containsKey(f);
		}
	};
	
	public String getLibrary(String elementFile) {
		if (elementFile == null)
			return null;
		
		return fileToLibrary == null ? 
				defaultLibrary : 
				fileToLibrary.adapt(new File(elementFile));
	}

	public Collection<File> getFiles() {
		/*return new AdaptedCollection<String, File>(libraryByFile.keySet(), new Adapter<String, File>() {
			@Override
			public File adapt(String value) {
				return new File(value);
			}
		});*/
		return libraryByFile.keySet();
	}

	public String relativizeFileForSourceComments(String path) {
		/*File file = new File(path);
		try {
			path = file.getCanonicalPath();
		} catch (Exception ex) {
			return path;
		}*/
		for (String pref : rootDirectoriesPrefixesForSourceComments) {
			if (path.startsWith(pref)) {
				path = path.substring(pref.length());
				break;
			}
		}
		return path;
	}
}