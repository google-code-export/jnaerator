package com.ochafik.lang.compiler;

import java.util.*;
import java.io.*;
import javax.tools.*;

public class CompilerUtils {
	

	public static void compile(MemoryFileManager fileManager, DiagnosticCollector<JavaFileObject> diagnostics, String sourceCompatibility) {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		System.out.println("compiler = " + compiler	);

		Iterable<? extends JavaFileObject> fileObjects = fileManager.getJavaFileObjects();  
		List<String> options = sourceCompatibility == null ? null : Arrays.asList(
				"-target", sourceCompatibility, 
				"-source", sourceCompatibility);  
		compiler.getTask(null, fileManager, diagnostics, options, null, fileObjects).call();
		
		for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
			//diagnostic.getKind()
			//System.out.format("Error on line %d in %d%n", diagnostic.getLineNumber(), diagnostic.getSource());//.toUri());
			System.out.format("Error on line " + diagnostic.getLineNumber() + ":" + diagnostic.getLineNumber() + " in " + diagnostic.getSource());//.toUri());
		}
	}
	
	public static JavaCompiler getJavaCompiler() throws FileNotFoundException {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		if (compiler == null) {
			try {
				compiler = (JavaCompiler)Class.forName("org.eclipse.jdt.internal.compiler.tool.EclipseCompiler").newInstance();
			} catch (Exception e) {
				throw new FileNotFoundException("No Java compiler found (not run from JDK, no Eclipse Compiler in classpath)");
			}
		}
		return compiler;
	}
	public static void main2(String[] args) {
		try {
			String jarOut = args.length == 0 ? "out.jar" : args[0];

			JavaCompiler compiler = getJavaCompiler();
			
			DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
			MemoryFileManager fileManager = new MemoryFileManager(compiler.getStandardFileManager(diagnostics, null, null));
			fileManager.addSourceInput("test/Main.java", "package test; public class Main { }");
			fileManager.close();

			compile(fileManager, diagnostics, null);
			for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
				//diagnostic.getKind()
				//System.out.format("Error on line %d in %d%n", diagnostic.getLineNumber(), diagnostic.getSource());//.toUri());
				System.out.format("Error on line " + diagnostic.getLineNumber() + ":" + diagnostic.getLineNumber() + " in " + diagnostic.getSource());//.toUri());
			}

			boolean outputSources = true;
			System.out.println("Writing " + jarOut + (outputSources ? " with" : " without") + " sources");
			fileManager.writeJar(new FileOutputStream(jarOut), outputSources);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

