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
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.anarres.cpp.CppReader;
import org.anarres.cpp.Feature;
import org.anarres.cpp.FileLexerSource;
import org.anarres.cpp.LexerException;
import org.anarres.cpp.Macro;
import org.anarres.cpp.Preprocessor;
import org.anarres.cpp.PreprocessorListener;
import org.anarres.cpp.Source;
import org.anarres.cpp.Token;

import com.ochafik.io.ReadText;
import com.ochafik.io.WriteText;
import com.ochafik.lang.jnaerator.parser.Define;
import com.ochafik.lang.jnaerator.parser.Expression;
import com.ochafik.util.listenable.Adapter;
import com.ochafik.util.string.RegexUtils;
import com.ochafik.util.string.StringUtils;

public class PreprocessorUtils {
	
	public static String preprocessSources(JNAeratorConfig config, List<Define> defines) throws IOException, LexerException {

		Preprocessor preProcessor = PreprocessorUtils.createPreProcessor(config.preprocessorConfig);
		for (File file : config.getFiles())
			preProcessor.addInput(file);
		
		String sourceContent = ReadText.readText(new CppReader(preProcessor));
		
		if (config.preprocessorConfig.WORKAROUND_PP_BUGS) {
			WriteText.writeText(sourceContent, new File("_jnaerator_debug.raw.c"));
			
			sourceContent = PreprocessorUtils.removePreprocessorDirectives(sourceContent);
			File cleanedFile = new File("_jnaerator_debug.clean.cpp");
			
			WriteText.writeText(StringUtils.implode(preProcessor.getMacros().entrySet(), "\n"), new File("_jnaerator_debug.macros.cpp"));
			
			sourceContent = "\n" + sourceContent;
			sourceContent = RegexUtils.regexReplace(Pattern.compile("(?s)\\n#line\\s+(\\d+)\\s+\"([^\"]+)\""), sourceContent, new Adapter<String[], String>() {
				public String adapt(String[] value) {
					//return "\n//##line " + value[1] + " \"" + value[2].replace("\\", "\\\\") + "\"";
					return "\n//##line " + value[1] + " \"" + value[2].replace('\\', '/') + "\"";
				}
				
			});
			sourceContent = sourceContent.replaceAll("(?s)\n#line", "\n//##line");
			WriteText.writeText(sourceContent, cleanedFile);
			
			Preprocessor preProcessor2 = PreprocessorUtils.createPreProcessor(new JNAeratorConfig.PreprocessorConfig());
			preProcessor2.getMacros().putAll(preProcessor.getMacros());
			//File temp = File.createTempFile("temp", ".h");
			
			preProcessor2.addInput(new FileLexerSource(cleanedFile));
			sourceContent = ReadText.readText(new CppReader(preProcessor2));
			sourceContent = "\n" + sourceContent;
			sourceContent = sourceContent.replaceAll("(?s)\n#line.*?\n", "\n");
			sourceContent = sourceContent.replaceAll("(?s)\n//##line", "\n#line").trim();
			sourceContent = PreprocessorUtils.removeNastyDefines(sourceContent);
			sourceContent = sourceContent.replaceAll("__attribute__[^;]*;", ";");
			WriteText.writeText(sourceContent, new File("_jnaerator_debug.preprocessed.c"));
		}
		
		PreprocessorUtils.addDefines(preProcessor, defines);
		
		return sourceContent;
	}
	
	public static Preprocessor createPreProcessor(File file, JNAeratorConfig.PreprocessorConfig config) throws IOException, LexerException {
		Preprocessor preprocessor = new Preprocessor(file) {
			Set<String> pragmaOnces = new HashSet<String>();
			@Override
			protected void pragma(Token name, List<Token> value)
					throws IOException, LexerException {
				if ("once".equals(name.getText())) {
					if (!pragmaOnces.add(getSource().toString()))
						pop_source();
				} 
				//else
					//super.pragma(name, value);
			}
			
			Set<String> openedSources = new HashSet<String>();
			@Override
			protected void push_source(Source source, boolean autopop) {
				//System.out.println("push_source(" + source + ")");
				if (source instanceof FileLexerSource) {
					if (!openedSources.add(source.toString()))
						return;
				}
				super.push_source(source, autopop);
			}
			@Override
			protected void pop_source() throws IOException {
				if (getSource() instanceof FileLexerSource) {
					//openedSources.remove(getSource().toString());
				}
				
				super.pop_source();
			}
		};
		preprocessor.addFeature(Feature.KEEPCOMMENTS);
		preprocessor.addFeature(Feature.DIGRAPHS);
		preprocessor.addFeature(Feature.TRIGRAPHS);
		//preprocessor.addFeature(Feature.CSYNTAX);
		preprocessor.addFeature(Feature.LINEMARKERS);
		preprocessor.addFeature(Feature.DEBUG);
		
		preprocessor.setListener(new PreprocessorListener() {
			@Override
			public void handleWarning(Source source, int line, int column,
					String msg) throws LexerException {
				// TODO Auto-generated method stub
				super.handleWarning(source, line, column, msg);
			}
		});
		
		preprocessor.getSystemIncludePath().addAll(config.includes);
		preprocessor.getQuoteIncludePath().addAll(config.includes);
		preprocessor.getFrameworksPath().addAll(config.frameworksPath);
		for (Map.Entry<String, String> e : config.macros.entrySet()) {
			if (e.getValue() != null)
				preprocessor.addMacro(e.getKey(), e.getValue());
			else
				preprocessor.addMacro(e.getKey());
		}
		return preprocessor;
	}

	public static Preprocessor createPreProcessor(JNAeratorConfig.PreprocessorConfig config) throws IOException, LexerException {
		Preprocessor preprocessor = new Preprocessor() {
			Set<String> pragmaOnces = new HashSet<String>();
			@Override
			protected void pragma(Token name, List<Token> value)
					throws IOException, LexerException {
				if ("once".equals(name.getText())) {
					if (!pragmaOnces.add(getSource().toString()))
						pop_source();
				} else
					super.pragma(name, value);
			}
		};
		//preprocessor.addFeatures(EnumSet.allOf(Feature.class));
		preprocessor.addFeature(Feature.KEEPCOMMENTS);
		preprocessor.addFeature(Feature.DIGRAPHS);
		preprocessor.addFeature(Feature.TRIGRAPHS);
		//preprocessor.addFeature(Feature.CSYNTAX);
		preprocessor.addFeature(Feature.LINEMARKERS);
		//preprocessor.addFeature(Feature.DEBUG);
		
		preprocessor.setListener(new PreprocessorListener() {
			@Override
			public void handleWarning(Source source, int line, int column,
					String msg) throws LexerException {
				if (!msg.contains("#pragma"))
					super.handleWarning(source, line, column, msg);
			}
		});
		
		preprocessor.getSystemIncludePath().addAll(config.includes);
		//preprocessor.getSystemIncludePath().addAll(Arrays.asList(DEFAULT_INCLUDE_PATH.split(":")));
		preprocessor.getQuoteIncludePath().addAll(config.includes);
		//preprocessor.getFrameworksPath().addAll(Arrays.asList(DEFAULT_FRAMEWORKS_PATH.split(":")));
		preprocessor.getFrameworksPath().addAll(config.frameworksPath);
		for (Map.Entry<String, String> e : config.macros.entrySet()) {
			if (e.getValue() != null)
				preprocessor.addMacro(e.getKey(), e.getValue());
			else
				preprocessor.addMacro(e.getKey());
		}
		return preprocessor;
	}

	public static String removePreprocessorDirectives(String s) {
		s = s.replaceAll(";#line", ";\n#line"); /// hack !
		
		s = s.replaceAll("(?s)#\\s*(pragma|if|endif|error|ifdef|ifndef|else|elif|define|undef).*?\n", "\n");
		s = s.replaceAll("(?s)#\\s*(import|include).*?\n", "\n");
		return s;
	}

	public static String removeNastyDefines(String s) {
		/// Mac OS X
		s = s.replaceAll("DEPRECATED_IN_MAC_OS_X_VERSION_[A-Z0-9_]+_AND_LATER", " ");
		s = s.replaceAll("AVAILABLE_MAC_OS_X_VERSION_[A-Z0-9_]+_AND_LATER(_BUT_DEPRECATED_IN_MAC_OS_X_VERSION_[A-Z0-9_]+)?", " ");
		s = s.replaceAll("NS_REQUIRES_NIL_TERMINATION", " ");
		s = s.replaceAll("__MATH_H_ALWAYS_INLINE__", " ");
		s = s.replace("CSEXTERN", "extern");
		
		/// Windows
		s = s.replace("__inner_fallthrough_dec", " ");
		
		/// Others
		//s = s.replaceAll("__strong", " ");
		return s;
	}

	static void addDefines(Preprocessor preProcessor, List<Define> defines) {
		for (Map.Entry<String, Macro> e : preProcessor.getMacros().entrySet()) {
			Macro macro = e.getValue();
			if (macro.getText() == null)
				continue;
		
			if (macro.isFunctionLike() && macro.getArgs() > 0)
				continue;
			
			if (macro.getFile() == null)
				continue;
			
			try {
				Expression expression = JNAerator.newObjCppParser(macro.getText()).expression().expr;
				if (expression == null)
					continue;
			
				Define define = new Define(e.getKey(), expression);
				define.setElementFile(macro.getFile());
				defines.add(define);
			} catch (Exception ex) {
				
			}
		}
	}

}
