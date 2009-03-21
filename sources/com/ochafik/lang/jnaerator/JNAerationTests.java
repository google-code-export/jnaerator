package com.ochafik.lang.jnaerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;

import junit.framework.Assert;

import org.anarres.cpp.LexerException;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import com.ochafik.io.ReadText;
import com.ochafik.junit.ParameterizedWithDescription;
import com.ochafik.lang.compiler.CompilerUtils;
import com.ochafik.lang.compiler.MemoryFileManager;
import com.ochafik.lang.compiler.MemoryFileObject;
import com.ochafik.lang.jnaerator.studio.JNAeratorStudio;
import com.ochafik.lang.jnaerator.studio.JNAeratorStudio.SyntaxException;
import com.ochafik.net.URLUtils;
import com.ochafik.util.listenable.Adapter;
import com.ochafik.util.listenable.Filter;
import com.ochafik.util.string.StringUtils;
import com.sun.jna.Pointer;

@RunWith(ParameterizedWithDescription.class)
public class JNAerationTests {
	String title;
	TestDesc test;
	public JNAerationTests(String title, TestDesc test) {
		this.title = title;
		this.test = test;
	}
	
	static class TestDesc {
		String cSource;
		String libraryName = "test";
		Map<String, String> classNameToJavaContent = new HashMap<String, String>();
		public TestDesc(String cSource) {
			this.cSource = cSource;
		}
		public TestDesc addSource(String className, String javaContent) {
			classNameToJavaContent.put(className, javaContent);
			return this;
		}
		public TestDesc addMainContentSource(String className, String javaContent) {
			Set<String> imports = new TreeSet<String>();
			List<String> content = new ArrayList<String>();
			String lib = libraryName + "." + StringUtils.capitalize(libraryName) + "Library";
			imports.add("import " + lib + ";");
			imports.add("import static " + lib + ".*;");
			imports.add("import com.sun.jna.*;");
			imports.add("import com.sun.jna.ptr.*;");
			imports.add("import java.nio.*;");

			for (String line : javaContent.split("\r?\n")) {
				if (line.matches("^\\s*import[^\\w].*"))
					imports.add(line);
				else
					content.add(line);
			}
			String simpleName = new File(className.replace('.', File.separatorChar)).getName();
			String transformedContent = StringUtils.implode(imports, "\n") + "\n" +
				"public class " + simpleName + " {\n" +
				"\tpublic static void main(String[] args) {\n\t\t" + 
				StringUtils.implode(content, "\n\t\t").trim() + "\n" +
				"\t}\n}";
			System.out.println(transformedContent);
			classNameToJavaContent.put(className, transformedContent);
			return this;
		}
	}
	
	@Test
	public void test() throws SyntaxException, IOException, LexerException, RecognitionException {
		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
		MemoryFileManager mfm = JNAerationUtils.jnaerateAndCompile(test.cSource, test.classNameToJavaContent, test.libraryName, diagnostics);
		boolean hasErrors = false;
		for (Diagnostic<? extends JavaFileObject> d : diagnostics.getDiagnostics()) {
			if (d.getKind() == Diagnostic.Kind.ERROR) {
				hasErrors = true;
			}
		}
		if (!diagnostics.getDiagnostics().isEmpty()) {
			if (hasErrors) {
				for (MemoryFileObject content : mfm.inputs.values())
					System.out.println(new String(content.getContent()));
				
				Assert.assertEquals("Errors occurred during compilation : \n" +
						//new String(mfm.inputs.get("Test.java").getContent()) + "\n" +
						StringUtils.implode(diagnostics.getDiagnostics(), "\n"), 
						0, diagnostics.getDiagnostics().size());
			}
		}
	}
	
	@Parameters
	public static List<Object[]> readParameters() throws IOException {
		//List<String> lines = ReadText.readLines(ObjCppParsingTests.class.getClassLoader().getResource(TEST_FILE));
		//List<String> lines = ReadText.readLines(TEST_FILE);
		//TestOption testOption = TestOption.ParseAndPrettyPrint;
		//List<URL> list = URLUtils.listFiles(new URL("jar:file:/Users/ochafik/Prog/Java/bin/jnaerator.jar!/com/ochafik/lang/jnaerator"), null);
		List<Object[]> data = new ArrayList<Object[]>();
		
		URL dir = JNAerationTests.class.getClassLoader().getResource("tests");
		File debugLocalDir = new File("/Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/tests");
		if (debugLocalDir.exists())
			dir = debugLocalDir.toURI().toURL();
		
		for (URL testURL : URLUtils.listFiles(dir, new Filter<String>() {
			@Override
			public boolean accept(String path) {
				return path.toLowerCase().endsWith(".test");
			}
		})) {
			String t = ReadText.readText(testURL);
			String[] tt = t.split("\n--\n");
			data.add(new Object[] { 
				//testURL.toString(), //
				new File(URLDecoder.decode(testURL.toString(), "utf-8")).getName(), 
				new TestDesc(tt[0]).addMainContentSource("Test", tt[1]) 
			});
		}
		return data;
	}

}
