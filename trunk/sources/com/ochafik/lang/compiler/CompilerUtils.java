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
package com.ochafik.lang.compiler;

import java.util.*;
import java.io.*;
import java.net.URL;

import javax.tools.*;

import com.ochafik.util.string.StringUtils;

public class CompilerUtils {
	
	public static String getClassPath(Class<?> c) {

		URL resource = c.getResource(c.getSimpleName() + ".class");
		if (resource != null) {
			String resstr = resource.toString();
			if (resstr.matches("jar:file:.*!.*"))
				return resstr.substring("jar:file:".length(), resstr.indexOf("!"));
			else {
				String p = c.getName().replace('.', '/') + ".class";
				if (resstr.endsWith(p))
					return resstr.substring(0, resstr.length() - p.length());
			}
		}
		return null;
	}
	public static Set<String> getClassPaths(Class<?>... cs) {
		Set<String> ret = new TreeSet<String>();
		for (Class<?> c : cs) {
			String cp ;
			if (c == null || (cp = getClassPath(c)) == null)
				continue;
			ret.add(cp);
		}
		return ret;
	}
	public static void compile(JavaCompiler compiler, MemoryFileManager fileManager, DiagnosticCollector<JavaFileObject> diagnostics, String sourceCompatibility, Class<?>...classpathHints) {
		//JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		System.out.println("compiler = " + (compiler == null ? "<none found>" : compiler.getClass().getName()));
		Set<String> bootclasspaths = getClassPaths(classpathHints);
		bootclasspaths.addAll(getClassPaths(String.class));
		String bootclasspath = StringUtils.implode(bootclasspaths, File.pathSeparator);
		System.out.println("bootclasspath = " + bootclasspath);
		Iterable<? extends JavaFileObject> fileObjects = fileManager.getJavaFileObjects();  
		List<String> options = sourceCompatibility == null ? null : Arrays.asList(
			"-target", sourceCompatibility, 
			"-source", sourceCompatibility,
			"-bootclasspath", bootclasspath,
			"-classpath", bootclasspath
		);  
		compiler.getTask(null, fileManager, diagnostics, options, null, fileObjects).call();
		
		for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
			//diagnostic.getKind()
			//System.out.format("Error on line %d in %d%n", diagnostic.getLineNumber(), diagnostic.getSource());//.toUri());
			System.out.format("Error on line " + diagnostic.getLineNumber() + ":" + diagnostic.getLineNumber() + " in " + diagnostic.getSource());//.toUri());
		}
	}
	
	public static JavaCompiler getJavaCompiler() throws FileNotFoundException {
//		JavaCompiler compiler = null;
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

			compile(compiler, fileManager, diagnostics, null);
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

