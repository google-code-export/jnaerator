package com.ochafik.lang.jnaerator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;

import org.anarres.cpp.LexerException;
import org.antlr.runtime.RecognitionException;
import org.rococoa.cocoa.foundation.NSClass;

import com.ochafik.lang.compiler.CompilerUtils;
import com.ochafik.lang.compiler.MemoryFileManager;
import com.ochafik.lang.jnaerator.studio.JNAeratorStudio.SyntaxException;
import com.sun.jna.Pointer;

public class JNAerationUtils {

	public static MemoryFileManager jnaerateAndCompile(String cSource, Map<String, String> classNameToJavaSource, final String libraryName, DiagnosticCollector<JavaFileObject> diagnostics) throws SyntaxException, IOException, LexerException, RecognitionException {

		JNAeratorConfig config = new JNAeratorConfig();
		config.defaultLibrary = libraryName;
		config.libraryForElementsInNullFile = libraryName;
//		config.addFile(getFile(), "");
		config.preprocessorConfig.includeStrings.add(cSource);
		JNAeratorConfigUtils.autoConfigure(config);
		
		JNAerator jnaerator = new JNAerator(config);
		SourceFiles sourceFiles = jnaerator.parse();
		//final SourceFiles sourceFilesClone = sourceFiles;//.clone();
		
		JavaCompiler c = CompilerUtils.getJavaCompiler();
		//DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
		final MemoryFileManager mfm = new MemoryFileManager(c.getStandardFileManager(diagnostics, null, null));
		
		for (Map.Entry<String, String> e : classNameToJavaSource.entrySet())
			mfm.addSourceInput(e.getKey().replace('.', '/') + ".java", e.getValue());
		
		jnaerator.jnaerate(sourceFiles, new ClassOutputter() {
			@Override
			public PrintWriter getClassSourceWriter(String className) throws FileNotFoundException {
				return new PrintWriter(mfm.addSourceInput(className.replace('.', '/') + ".java", libraryName).openWriter());
			}
		});
		
		CompilerUtils.compile(c, mfm, diagnostics, "1.5", null, Pointer.class, JNAerator.class, NSClass.class, Mangling.class);
		return mfm;
		/*if (!diagnostics.getDiagnostics().isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
				//diagnostic.getKind()
				//System.out.format("Error on line %d in %d%n", diagnostic.getLineNumber(), diagnostic.getSource());//.toUri());
				sb.append("Error on line " + diagnostic.getLineNumber() + ":" + diagnostic.getLineNumber() + " in " + diagnostic.getSource() + "\n\t" + diagnostic.getMessage(Locale.getDefault()));//.toUri());
			}
			System.out.println(sb);
			throw new SyntaxException(sb.toString());
		}*/
	}
}
