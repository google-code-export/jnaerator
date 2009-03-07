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

import static com.ochafik.lang.SyntaxUtils.as;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

import org.anarres.cpp.LexerException;
import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.junit.runner.JUnitCore;

import com.ochafik.io.WriteText;
import com.ochafik.lang.jnaerator.TypeConversion.JavaPrim;
import com.ochafik.lang.jnaerator.TypeConversion.TypeConversionMode;
import com.ochafik.lang.jnaerator.TypeConversion.UnsupportedTypeConversion;
import com.ochafik.lang.jnaerator.parser.Annotation;
import com.ochafik.lang.jnaerator.parser.Arg;
import com.ochafik.lang.jnaerator.parser.Declaration;
import com.ochafik.lang.jnaerator.parser.Define;
import com.ochafik.lang.jnaerator.parser.Element;
import com.ochafik.lang.jnaerator.parser.EmptyDeclaration;
import com.ochafik.lang.jnaerator.parser.Enum;
import com.ochafik.lang.jnaerator.parser.Expression;
import com.ochafik.lang.jnaerator.parser.Function;
import com.ochafik.lang.jnaerator.parser.Modifier;
import com.ochafik.lang.jnaerator.parser.ObjCppElementsTests;
import com.ochafik.lang.jnaerator.parser.ObjCppLexer;
import com.ochafik.lang.jnaerator.parser.ObjCppParser;
import com.ochafik.lang.jnaerator.parser.ObjCppParsingTests;
import com.ochafik.lang.jnaerator.parser.ObjCppTests;
import com.ochafik.lang.jnaerator.parser.Scanner;
import com.ochafik.lang.jnaerator.parser.SourceFile;
import com.ochafik.lang.jnaerator.parser.Statement;
import com.ochafik.lang.jnaerator.parser.Struct;
import com.ochafik.lang.jnaerator.parser.TaggedTypeRefDeclaration;
import com.ochafik.lang.jnaerator.parser.TypeRef;
import com.ochafik.lang.jnaerator.parser.Declarator;
import com.ochafik.lang.jnaerator.parser.VariablesDeclaration;
import com.ochafik.lang.jnaerator.parser.Declarator.ArrayDeclarator;
import com.ochafik.lang.jnaerator.parser.Declarator.DirectDeclarator;
import com.ochafik.lang.jnaerator.parser.Expression.BinaryOperator;
import com.ochafik.lang.jnaerator.parser.Expression.Constant;
import com.ochafik.lang.jnaerator.parser.Function.Type;
import com.ochafik.lang.jnaerator.parser.StoredDeclarations.TypeDef;
import com.ochafik.lang.jnaerator.parser.TypeRef.FunctionSignature;
import com.ochafik.lang.jnaerator.parser.TypeRef.SimpleTypeRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.TaggedTypeRef;
import com.ochafik.lang.jnaerator.studio.JNAeratorStudio;
import com.ochafik.lang.reflect.DebugUtils;
import com.ochafik.util.listenable.Pair;
import com.ochafik.util.string.RegexUtils;
import com.ochafik.util.string.StringUtils;
import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;

/*
//include com/ochafik/lang/jnaerator/parser/*.mm
//include com/ochafik/lang/jnaerator/parser/ObjCpp.g
 */

public class JNAerator {
	
	static final Pattern definePattern = Pattern.compile("#\\s*define\\s+(\\w+)\\s+(.*)");
	static final boolean fullFilePathInComments = true;
	
	final JNAeratorConfig config;
	Result result = new Result(this);
	SourceFiles sourceFiles = new SourceFiles();
	
	static final Class<?>[] includeClassesHack = new Class<?>[] {
		ObjCppParsingTests.class,
		ObjCppElementsTests.class,
		JNAeratorStudio.class
	};

	public JNAerator(JNAeratorConfig config) {
		this.config = config;
	}

	public SourceFiles getSourceFiles() {
		return sourceFiles;
	}
	
	private static void displayHelp() {
		System.out.println("Credits:   JNAerator is Copyright (c) 2008-2009 Olivier Chafik");
		System.out.println("           Includes Anarres JCPP (Apache 2.0 license), Copyright (c) 2007-2008, Shevek");
		System.out.println("           Includes Java Native Access (JNA) (LGPL license), Copyright (c) 2006-2009 Todd Fast, Timothy Wall, Wayne Meissner & others");
		//System.out.println("           Includes the library GNU Trove (LGPL 2.1 license)");
		System.out.println("           Includes ANTLR's runtime (BSD license), Copyright (c) 2003-2008, Terence Parr");
		System.out.println("           Licensing & Copyright details : http://code.google.com/p/jnaerator/wiki/CreditsAndLicense");
		System.out.println("   Syntax: " + JNAerator.class.getSimpleName() + " options (-framework framework)* files-or-directories*");
		System.out.println("  Options:");
		System.out.println("\t-Iinclude-path");
		System.out.println("\t\tAdd include path.");
		System.out.println("\t-v");
		System.out.println("\t\tVerbose mode.");
		System.out.println("\t-Dsymbol[=value]");
		System.out.println("\t\tDefine a preprocessor symbol.");
		System.out.println("\t-library name");
		System.out.println("\t\tGives name of the library in which definitions will end up. \"c\" library will be generated as CLibrary class.");
		System.out.println("\t-o outputDir");
		System.out.println("\t\tRoot directory where all generated sources go");
		System.out.println("\t-project SolutionFile configString");
		System.out.println("\t\tRead Visual Studio 2008 project or solution file and use the configuration specified (e.g. \"Release|Win32\").");
		System.out.println("\t-package forcedPackageName");
		System.out.println("\t\tPackage name that is to be used for all generated classes.");
		System.out.println("\t\tIt is better to choose a root package name and let the program infer intermediate names (it will add the framework name, if recognized)");
		System.out.println("\t-root rootPackageName");
		System.out.println("\t\tPackage name to be prepended package names for any generated classes");
		System.out.println("\t-frameworksPath");
		System.out.println("\t\tBy default: " + JNAeratorConfigUtils.DEFAULT_FRAMEWORKS_PATH);
	}
	public static void main(String[] args) {
		if (args.length == 0) {
			if (new File("/Users/ochafik").exists()) {
				args = new String[] {
						//"/Developer/Platforms/iPhoneSimulator.platform/Developer/SDKs/iPhoneSimulator2.0.sdk/System/Library/Frameworks/Foundation.framework/Versions/C/Headers/NSURL.h",
						//"/Developer/Platforms/iPhoneSimulator.platform/Developer/SDKs/iPhoneSimulator2.0.sdk/System/Library/Frameworks/Foundation.framework/Versions/C/Headers",
						
	//					"-library", "gc", "/Users/ochafik/src/gc6.8/include/",
//						"-I/Developer/SDKs/MacOSX10.5.sdk/usr/include",
//						"/Developer/SDKs/MacOSX10.4u.sdk/usr/include/sys/event.h",
//						"/Developer/SDKs/MacOSX10.4u.sdk/usr/include/machine/types.h",
	//					"/Developer/SDKs/MacOSX10.4u.sdk/usr/include/sys/cdefs.h",
//						"/Developer/SDKs/MacOSX10.4u.sdk/usr/include/sys/_types.h",
//						"/Developer/SDKs/MacOSX10.4u.sdk/usr/include/stdint.h",
	//					
//						"-autoConf",
						//"-library", "c",
//						"-root", "org.rococoa",
						
//						"/Developer/SDKs/MacOSX10.4u.sdk/usr/include/sys/types.h", 
//						"/Developer/SDKs/MacOSX10.4u.sdk/usr/include/architecture/i386/math.h",
//						"/System/Library/Frameworks/Foundation.framework/Headers/NSObjCRuntime.h",
	//					"/System/Library/Frameworks/ApplicationServices.framework/Versions/Current/Frameworks/CoreGraphics.framework/Headers/CGBase.h",
	//					"/System/Library/Frameworks/ApplicationServices.framework/Versions/Current/Frameworks/CoreGraphics.framework/Headers/CGShading.h",
//						"/Developer/SDKs/MacOSX10.4u.sdk/usr/include/AvailabilityMacros.h",
//						"/Users/ochafik/Prog/Java/testxp/test.h",
//						"/Users/ochafik/Prog/Java/test/Test2.h",
//						"-framework", "Foundation", 
//						"/System/Library/Frameworks/Foundation.framework/Headers/NSArray.h",
//						"-framework", "CoreFoundation",
//						"-framework", "CoreGraphics", 
//						"-framework", "CarbonCore", 
						//"-f", "QTKit", 
//						"-o", "/Users/ochafik/Prog/Java/test/objc",
//						"-o", "/Users/ochafik/Prog/Java/testxp",
						"/Users/ochafik/Prog/Java/test/Test.h",
//						"/Users/ochafik/Prog/Java/test/JNATest.h",
						"-o", "/Users/ochafik/Prog/Java",
						"-v"
				};
			} else {
				displayHelp();
				return;
			}
		}
		try {
			JNAeratorConfig config = new JNAeratorConfig();
			
			List<String> frameworks = new ArrayList<String>();
			config.preprocessorConfig.frameworksPath.addAll(JNAeratorConfigUtils.DEFAULT_FRAMEWORKS_PATH);
			//boolean autoconf = false;
			for (int iArg = 0, len = args.length; iArg < len; iArg++) {
				String arg = args[iArg];
				if (arg.startsWith("-I")) {
					config.preprocessorConfig.includes.add(arg.substring("-I".length()));
				} else if (arg.startsWith("-D")) {
					int k = arg.indexOf('=');
					String key = arg.substring("-D".length(), k > 0 ? k : arg.length()),
						value = k > 0 ? arg.substring(k) : "";
					config.preprocessorConfig.macros.put(key, value);
//				} else if (arg.equals("-autoConf")) {
//					JNAeratorConfigUtils.autoConfigure(config);
				} else if (arg.equals("-root"))
					config.rootPackageName = args[++iArg];
				else if (arg.equals("-frameworksPath")) {
					config.preprocessorConfig.frameworksPath.clear();
					config.preprocessorConfig.frameworksPath.addAll(Arrays.asList(args[++iArg].split(":")));
				} else if (arg.equals("-v"))
					config.verbose = true;
				else if (arg.equals("-package"))
					config.packageName = args[++iArg];
				else if (arg.equals("-test")) {
					try {
						JUnitCore.main(ObjCppTests.class.getName());
						System.exit(0);
					} catch (Exception ex) {
						ex.printStackTrace();
						System.exit(1);
					}
				}
				else if (arg.equals("-studio")) {
					try {
						JNAeratorStudio.main(new String[0]);
						return;
					} catch (Exception ex) {
						ex.printStackTrace();
						System.exit(1);
					}
				}
				else if (arg.equals("-project")) {
					File projectFile = new File(args[++iArg]);
					String configName = null;
					if (iArg < len)
						configName = args[++iArg];
					
					JNAeratorConfigUtils.readProjectConfig(projectFile, configName, config);
				}
				else if (arg.equals("-library"))
					config.defaultLibrary = args[++iArg];
				else if (arg.equals("-framework"))
					frameworks.add(args[++iArg]);
				else if (arg.equals("-o"))
					config.outputDir = new File(args[++iArg]);
				else if (arg.equals("-h") || arg.equals("-help") || arg.equals("--h")) {
					displayHelp();
					System.exit(0);
				} else if (arg.endsWith(".framework"))
					frameworks.add(arg);
				else
					config.addFile(new File(arg), config.defaultLibrary);
			}
			
			if (config.defaultLibrary == null) {
				for (File f : config.getFiles()) {
					String name = f.getName();
					int i = name.indexOf('.');
					if (i >= 0)
						name = name.substring(0, i).trim();
					if (name.length() > 0)
						config.defaultLibrary = name;
					else
						config.defaultLibrary = "default";
					
					System.out.println("Warning: no -library option, using \"" + config.defaultLibrary + "\".");
					break;
				}
			}
//			config.symbolsAccepter = null;
			
			//System.out.println("FILES:\n" + StringUtils.implode(config.libraryByFile.keySet(), "\n"));
			
			
			for (String framework : frameworks)
				JNAeratorConfigUtils.addFramework(config, framework);
			
			config.addRootDir(new File("."));
			for (String i : config.preprocessorConfig.includes) {
				try {
					config.addRootDir(new File(i));
				} catch (Exception ex) {}
			}
			
			JNAerator test = new JNAerator(config);
			test.run();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static ObjCppParser newObjCppParser(String s) throws IOException {
		return new ObjCppParser(
				new CommonTokenStream(
						new ObjCppLexer(
								new ANTLRReaderStream(new StringReader(s))
						)
				)
//				, new DummyDebugEventListener()
		);
	}
	
			
	public void addFile(File file, List<File> out) throws IOException {
		if (file.isFile()) {
			out.add(file);
		} else {
			File[] fs = file.listFiles();
			if (fs != null) {
				for (File f : fs) {
					addFile(f, out);
				}
			}
		}
	}

	private String chooseJavaArg(String name, int iArg, Set<String> names) {
		String baseArgName = result.typeConverter.getValidJavaArgumentName(name);
		int i = 1;
		if (baseArgName == null)
			baseArgName = "arg";
		
		String argName;
		do {
			argName = "arg" + iArg + (i == 1 ? "" : i + "");
			i++;
		} while (names.contains(argName));
		return argName;
	}

	private void generateLibraryFiles(final Result result) throws FileNotFoundException {
		
		for (String library : result.libraries) {
			if (library == null)
				continue; // to handle code defined in macro-expanded expressions
//				library = "";
			
			String javaPackage = result.javaPackageByLibrary.get(library);
			String libraryClassName = result.getLibraryClassSimpleName(library);
			
			final PrintWriter out = getClassSourceWriter((javaPackage == null ? "" : javaPackage + ".") + libraryClassName);
			
			if (javaPackage != null)
				out.println("package " + javaPackage + ";");
			
			for (String pn : result.javaPackages) {
				if (pn.equals(""))
					continue;
				
				if (pn.equals(javaPackage))
					continue;
				out.println("import " + pn + ".*;");
			}
			if (!result.objCClasses.isEmpty())
				out.println("import org.rococoa.ID;");
			
			out.println();
			out.println(Element.formatComments("", null, null, false, true, true, "JNA Wrapper for library <b>" + library + "</b>", 
					getFileCommentContent(config.libraryProjectSources.get(library), null)));
			out.println("public interface " + libraryClassName + " extends " + Library.class.getName() + "\n{");
			
			String libraryNameExpression = result.getLibraryFileExpression(library);
			out.println("\tpublic " + libraryClassName + " INSTANCE = (" + libraryClassName + ")" + Native.class.getName() + ".loadLibrary(" + libraryNameExpression  + ", " + libraryClassName + ".class);");
			out.println();
			
			Set<String> signatures = result.getSignaturesForOutputClass(libraryClassName);
			
			List<Declaration> children = new ArrayList<Declaration>();
			
			convertEnums(result.enumsByLibrary.get(library), signatures, children, libraryClassName);
			convertConstants(result.definesByLibrary.get(library), signatures, children, libraryClassName);
			convertStructs(result.structsByLibrary.get(library), signatures, children, libraryClassName);
			convertCallbacks(result.callbacksByLibrary.get(library), signatures, children, libraryClassName);
			convertFunctions(result.functionsByLibrary.get(library), signatures, children, libraryClassName);

			for (Declaration d : children) {
				out.println();
				out.println("\t" + d.toString("\t"));
			}
			
			out.println("}");
			out.close();
		}
	}

	public PrintWriter getClassSourceWriter(String className) throws FileNotFoundException {
		File file = new File(config.outputDir, className.replace('.', File.separatorChar) + ".java");
		File parent = file.getParentFile();
		if (!parent.exists())
			parent.mkdirs();

		//if (config.verbose)
			System.err.println("Generating: " + file.getAbsolutePath());

		return new PrintWriter(file) {
			@Override
			public void print(String s) {
				super.print(s.replace("\r", "").replace("\n", StringUtils.LINE_SEPARATOR));
			}
		};
	}

	String getFileCommentContent(Element e) {
		String f = Element.getFileOfAscendency(e);
		return f == null ? null : getFileCommentContent(new File(f), e);
	}
	
	String getFileCommentContent(File file, Element e) {
		if (file != null) {
			String path = config.relativizeFileForSourceComments(file.getAbsolutePath());
			String inCategoryStr = "";
			if (e instanceof Function) {
				Function fc = (Function)e;
				Struct parent;
				if (fc.getType() == Type.ObjCMethod && ((parent = as(fc.getParentElement(), Struct.class)) != null) && (parent.getCategoryName() != null)) {
					inCategoryStr = "from " + parent.getCategoryName() + " ";
				}
			}
			return "<i>" + inCategoryStr + "native declaration : " + path + (e == null || e.getElementLine() < 0 ? "" : ":" + e.getElementLine()) + "</i>";
		}
		return null;
	}
	
	void convertCallback(FunctionSignature functionSignature, Set<String> signatures, List<Declaration> out, String callerLibraryName) {
		String name = result.typeConverter.inferCallBackName(functionSignature, false);
		if (name == null)
			return;
		
		name = result.typeConverter.getValidJavaArgumentName(name);
		
		Function function = functionSignature.getFunction();
		
		int i = 1;
		String chosenName = name;
		while (!(signatures.add(chosenName))) {
			chosenName = name + (++i);
		}
		
		Element parent = functionSignature.getParentElement();
		Element comel = parent != null && parent instanceof TypeDef ? parent : functionSignature;
		
		Struct callbackStruct = new Struct();
		callbackStruct.setType(Struct.Type.JavaInterface);
		callbackStruct.addModifiers(Modifier.Public);
		callbackStruct.setParents(Arrays.asList(Callback.class.getName()));
		callbackStruct.setTag(chosenName);
		callbackStruct.addToCommentBefore(comel.getCommentBefore(), comel.getCommentAfter(), getFileCommentContent(comel));
		//out.setCommentBefore(Element.formatComments(chosenName, name, chosenName, fullFilePathInComments, null))
		List<Declaration> children = new ArrayList<Declaration>();
		convertFunction(function, new TreeSet<String>(), true, children, callerLibraryName);
		callbackStruct.addDeclarations(children);
		out.add(new TaggedTypeRefDeclaration(callbackStruct));
	}
	
	private void convertCallbacks(List<FunctionSignature> functionSignatures, Set<String> signatures, List<Declaration> out, String callerLibraryClass) {
		if (functionSignatures != null) {
			for (FunctionSignature functionSignature : functionSignatures) {
				if (functionSignature.findParentOfType(Struct.class) != null)
					continue;
					
				convertCallback(functionSignature, signatures, out, callerLibraryClass);
			}
		}
		
	}
	
	@SuppressWarnings("static-access")
	private Declaration outputConstant(String name, Expression x, Set<String> signatures, Element element, String elementTypeDescription, String callerLibraryClass) throws UnsupportedTypeConversion {
		//out.println();
		//String comments = element.formatComments(indent, true);
		//if (comments.length() > 0)
		//	out.println(indent + comments);
		boolean done = false;
		try {
			if (!result.typeConverter.isValidJavaIdentifier(name))
				throw new UnsupportedTypeConversion(element);//"Name of constant " + name + " is invalid in Java.");
			
			Expression converted = result.typeConverter.convertExpressionToJava(x, callerLibraryClass);
			TypeRef tr = result.typeConverter.inferJavaType(converted);
			JavaPrim prim = result.typeConverter.getPrimitive(tr);
			if (prim == null) {
				return new EmptyDeclaration("Failed to infer type of " + converted);
			} else if (prim != JavaPrim.Void) {
				if (signatures.add(name)) {
					String t = converted.toString();
					if (t.contains("sizeof")) {
						converted = result.typeConverter.convertExpressionToJava(x, callerLibraryClass);
					}

					//TypeRef tr = new TypeRef.SimpleTypeRef(result.typeConverter.typeToJNA(type, vs, TypeConversion.TypeConversionMode.FieldType, callerLibraryClass));
					Declaration declaration = new VariablesDeclaration(tr, new DirectDeclarator(name, converted));
					declaration.addModifiers(Modifier.Public, Modifier.Static, Modifier.Final);
					declaration.importDetails(element);
					declaration.moveAllCommentsBefore();
					declaration.addToCommentBefore(getFileCommentContent(element));
					return declaration;
				}
			}
			return new EmptyDeclaration("SKIPPED " + elementTypeDescription + ": " + element);
		} catch (UnsupportedTypeConversion e) {
			return new EmptyDeclaration(e.toString());//.replace('\n', ' '));
		}	
		
	} 

	private void convertConstants(List<Define> defines, Set<String> signatures, final List<Declaration> out, final String callerLibraryClass) {
		sourceFiles.accept(new Scanner() {
			@Override
			public void visitVariablesDeclaration(VariablesDeclaration v) {
				if (v.findParentOfType(Struct.class) != null)
					return;
				
				if (v.getValueType() instanceof FunctionSignature)
					return;
					
				if (!v.getModifiers().contains(Modifier.Const))
					return;
				
				TypeRef type = v.getValueType();
				JavaPrim prim = result.typeConverter.getPrimitive(type);
				if (prim == null)
					return;
				
				for (Declarator vs : v.getDeclarators()) {
					try {
						if (vs.getDefaultValue() == null || !(vs instanceof DirectDeclarator))
							continue; // TODO provide a mapping of exported values
						
						DirectDeclarator dd = (DirectDeclarator)vs;
						Expression val = result.typeConverter.convertExpressionToJava(vs.getDefaultValue(), callerLibraryClass);
						
						TypeRef tr = new TypeRef.SimpleTypeRef(result.typeConverter.typeToJNA(type, vs, TypeConversion.TypeConversionMode.FieldType, callerLibraryClass));
						VariablesDeclaration vd = new VariablesDeclaration(tr, new DirectDeclarator(dd.getName(), val));
						vd.setCommentBefore(v.getCommentBefore());
						vd.addToCommentBefore(vs.getCommentBefore());
						vd.addToCommentBefore(vs.getCommentAfter());
						vd.addToCommentBefore(v.getCommentAfter());
						
						out.add(vd);
						
						//if (vs.getStorageModifiers().isEmpty() && prim != null && !vs.getDimensions().isEmpty())
						//	print("[(" + StringUtils.implode(vs.getDimensions(), ") * (") + ")]");
						
					} catch (UnsupportedTypeConversion e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		
		if (defines != null) {
			for (Define define : reorderDefines(defines)) {
				if (define.getValue() == null)
					continue;
				
				out.add(outputConstant(define.getName(), define.getValue(), signatures, define.getValue(), "define", callerLibraryClass));
			}
		}
	}
	public List<Define> reorderDefines(Collection<Define> defines) {
		List<Define> reordered = new ArrayList<Define>(defines.size());
		HashSet<String> added = new HashSet<String>(), all = new HashSet<String>();
		
		
		Map<String, Pair<Define, Set<String>>> pending = new HashMap<String, Pair<Define, Set<String>>>();
		for (Define define : defines) {
			Set<String> dependencies = new TreeSet<String>();
			computeVariablesDependencies(define.getValue(), dependencies);
			all.add(define.getName());
			if (dependencies.isEmpty()) {
				reordered.add(define);
				added.add(define.getName());
			} else {
				pending.put(define.getName(), new Pair<Define, Set<String>>(define, dependencies));
			}	
		}
		
		for (int i = 3; i-- != 0 && !pending.isEmpty();) {
			for (Iterator<Map.Entry<String, Pair<Define, Set<String>>>> it = pending.entrySet().iterator(); it.hasNext();) {
				Map.Entry<String, Pair<Define, Set<String>>> e = it.next(); 
				Set<String> dependencies = e.getValue().getSecond();
				String name = e.getKey();
				boolean missesDep = false;
				for (String dependency : dependencies) {
					if (!added.contains(dependency)) {
						missesDep = true;
						if (!all.contains(dependency)) {
							it.remove();
							all.remove(name);
						}
						
						break;
					}
				}
				if (missesDep)
					continue;
				
				it.remove();
				reordered.add(e.getValue().getFirst());
			}
		}
		
		return reordered;
	}
	public void computeVariablesDependencies(Element e, final Set<String> names) {
		e.accept(new Scanner() {
			@Override
			public void visitSimpleTypeRef(SimpleTypeRef simpleTypeRef) {
				names.add(simpleTypeRef.getName());
			}
		});
	}
	private void convertEnums(List<Enum> enums, Set<String> signatures, List<Declaration> out, String callerLibraryClass) {
		if (enums != null) {
			//out.println("public static class ENUMS {");
			for (com.ochafik.lang.jnaerator.parser.Enum e : enums) {
				if (e.findParentOfType(Struct.class) != null)
					continue;
				
				convertEnum(e, signatures, out, callerLibraryClass);
			}
			//out.println("}");
		}
	}
	
	private void convertEnum(Enum e, Set<String> signatures, List<Declaration> out, String callerLibraryClass) {
		List<Declaration> localOut = out;
		Set<String> localSignatures = signatures;
		
		Struct enumInterf = null;
		if (e.getTag() != null) {
			
			enumInterf = publicStaticClass(e.getTag(), null, Struct.Type.JavaInterface, e);
			enumInterf.addToCommentBefore("enum values");
			out.add(new TaggedTypeRefDeclaration(enumInterf));
			
			localSignatures = new HashSet<String>();
			localOut = new ArrayList<Declaration>();
		}
		Integer lastAdditiveValue = null;
		Expression lastRefValue = null;
		boolean failedOnceForThisEnum = false;
		for (com.ochafik.lang.jnaerator.parser.Enum.EnumItem item : e.getItems()) {
			Expression resultingExpression;
			try {
				if (item.getValue() == null) {
					// no explicit value
					if (lastRefValue == null) {
						if (lastAdditiveValue != null) {
							lastAdditiveValue++;
							resultingExpression = new Expression.Constant(Constant.Type.Int, lastAdditiveValue);
						} else {
							if (item == e.getItems().get(0)) {
								lastAdditiveValue = 0;
								resultingExpression = new Expression.Constant(Constant.Type.Int, lastAdditiveValue);
							} else
								resultingExpression = null;
						}
					} else {
						// has a last reference value
						if (lastAdditiveValue != null)
							lastAdditiveValue++;
						else
							lastAdditiveValue = 1;
						
						resultingExpression = //result.typeConverter.convertExpressionToJava(
							new Expression.BinaryOp(
								Expression.BinaryOperator.Plus, 
								lastRefValue.clone(), 
								new Expression.Constant(Constant.Type.Int, lastAdditiveValue)
							//)
						);
					}
				} else {
					// has an explicit value
					failedOnceForThisEnum = false;// reset skipping
					lastAdditiveValue = null;
					lastRefValue = item.getValue();
					resultingExpression = lastRefValue;
					if (lastRefValue instanceof Expression.Constant) {
						try {
							lastAdditiveValue = ((Expression.Constant)lastRefValue).asInteger();
							lastRefValue = null;
						} catch (Exception ex) {}
					}	
				}
			} catch (Exception ex) {
				//ex.printStackTrace();
				resultingExpression = null;
			}
			if (failedOnceForThisEnum || (failedOnceForThisEnum = resultingExpression == null))
				localOut.add(new EmptyDeclaration("SKIPPED enum item: " + item));
			else {
				try {
					localOut.add(outputConstant(item.getName(), result.typeConverter.convertExpressionToJava(resultingExpression, callerLibraryClass), localSignatures, item, "enum item", callerLibraryClass));
				} catch (Exception ex) {
					localOut.add(new EmptyDeclaration("SKIPPED enum item: " + item));
				}
			}
		}
		if (enumInterf != null)
			enumInterf.addDeclarations(localOut);
	}

	void convertFunction(Function function, Set<String> signatures, boolean isCallback, List<Declaration> out, String callerLibraryClass) {
		if (config.functionsAccepter != null && !config.functionsAccepter.adapt(function))
			return;
		
		String functionName = function.getName();
		if (functionName == null)
			functionName = "callback";
		
		if (functionName.contains("<")) {
			return;
		}
		
		if (" new null class void public package extends boolean ".contains(" " + functionName + " "))
			return;
		
		Function convertedNat = new Function();
		convertedNat.setType(Function.Type.JavaMethod);
		try {
			//StringBuilder outPrefix = new StringBuilder();
			TypeRef returnType = null;
			
			boolean isObjectiveC = function.getType() == Type.ObjCMethod;
			if (!isObjectiveC) {
				returnType = function.getValueType();
				if (returnType == null)
					returnType = new TypeRef.Primitive("int");
			} else {
				returnType = RococoaUtils.fixReturnType(function);
				functionName = RococoaUtils.getMethodName(function);
			}
			
			String modifiedMethodName;
			if (isCallback) {
				modifiedMethodName = "callback";
			} else {
				modifiedMethodName = result.typeConverter.getValidJavaMethodName(functionName);
				if (!modifiedMethodName.equals(functionName))
					convertedNat.addAnnotation(new Annotation("@" + RenameSymbol.class.getName() + "(name=\"" + functionName + "\")"));
			}
			
			convertedNat.setName(modifiedMethodName);
			convertedNat.setValueType(result.typeConverter.convertTypeToJNA(returnType, TypeConversionMode.ReturnType, callerLibraryClass));
			convertedNat.importDetails(function);
			if (!isCallback)
				convertedNat.addToCommentBefore(getFileCommentContent(function));
			//convertedNat.addToCommentBefore("SIGNATURE: " + function.computeSignature());
			Function convertedPrim = convertedNat.clone();
			
			Set<String> names = new TreeSet<String>();
			for (Arg arg : function.getArgs())
				if (arg.getName() != null) 
					names.add(arg.getName());
				
			int iArg = 1;
			for (Arg arg : function.getArgs()) {
				if (arg.isVarArg() && arg.getValueType() == null) {
					//TODO choose vaname dynamically !
					String vaType = isObjectiveC ? "NSObject" : "Object";
					String argName = chooseJavaArg("varargs", iArg, names);
					convertedNat.addArg(new Arg(argName, new TypeRef.SimpleTypeRef(vaType))).setVarArg(true);
					convertedPrim.addArg(new Arg(argName, new TypeRef.SimpleTypeRef(vaType))).setVarArg(true);
					
					//convertedNat.addArg(Arg.createVarArgs());
					//convertedPrim.addArg(Arg.createVarArgs());
				} else {
					String argName = arg.getName();
					if (argName == null)
						argName = chooseJavaArg(arg.getName(), iArg, names);
					TypeRef typeStrNat = result.typeConverter.convertTypeToJNA(arg.getValueType(), TypeConversionMode.NativeParameter, callerLibraryClass),
						typeStrPrim = result.typeConverter.convertTypeToJNA(arg.getValueType(), TypeConversionMode.PrimitiveParameter, callerLibraryClass);
					
					convertedNat.addArg(new Arg(argName, typeStrNat));
					convertedPrim.addArg(new Arg(argName, typeStrPrim));
				}
				iArg++;
			}
			
			//boolean outputtedSourceString = false;
			boolean nativeSignatureDifferentFromPrimitiveSignature = !convertedNat.toString().equals(convertedPrim.toString());
			String nativeSignature = convertedNat.computeSignature();
			if (signatures.add(nativeSignature)) {
				if (!isCallback && nativeSignatureDifferentFromPrimitiveSignature) {
					convertedNat.addToCommentBefore(Arrays.asList("@deprecated use the safer and easier to use {@link #" + convertedPrim.computeSignature() + "} instead"));
					convertedNat.setAnnotations(Arrays.asList(new Annotation("@Deprecated")));
				}
				out.add(convertedNat);
			}
			
			if (!isCallback && nativeSignatureDifferentFromPrimitiveSignature) {
				if (signatures.add(convertedPrim.computeSignature())) {
					out.add(convertedPrim);
				}
			}
		} catch (TypeConversion.UnsupportedTypeConversion ex) {
			out.add(new EmptyDeclaration(getFileCommentContent(function), ex.toString().replace('\n', ' ')));
		}
	}

	private void convertFunctions(List<Function> functions, Set<String> signatures, List<Declaration> out, String callerLibraryClass) {
		if (functions != null) {
			//System.err.println("FUNCTIONS " + functions);
			for (Function function : functions) {
				convertFunction(function, signatures, false, out, callerLibraryClass);
			}
		}
	}
	TaggedTypeRefDeclaration publicStaticClassDecl(String name, String parentName, Struct.Type type, Element toCloneCommentsFrom, String... interfaces) {
		return decl(publicStaticClass(name, parentName, type, toCloneCommentsFrom, interfaces));
	}
	TaggedTypeRefDeclaration decl(TaggedTypeRef tr) {
		return new TaggedTypeRefDeclaration(tr);
	}
	Struct publicStaticClass(String name, String parentName, Struct.Type type, Element toCloneCommentsFrom, String... interfaces) {
		Struct cl = new Struct();
		cl.setType(type);
		cl.setTag(name);
		if (parentName != null)
			cl.setParents(parentName);
		if (type == Struct.Type.JavaInterface)
			for (String inter : interfaces)
				cl.addParent(inter);
		else
		cl.setProtocols(Arrays.asList(interfaces));
		if (toCloneCommentsFrom != null ) {
			cl.importDetails(toCloneCommentsFrom);
			cl.moveAllCommentsBefore();
			cl.addToCommentBefore(getFileCommentContent(toCloneCommentsFrom));
		}
		cl.addModifiers(Modifier.Public, Modifier.Static);
		return cl;
	}
	public void convertStructs(List<Struct> structs, Set<String> signatures, List<Declaration> out, String libraryClassName) {
		if (structs != null) {
			List<Declaration> children = new ArrayList<Declaration>();
			for (Struct struct : structs) {
				if (struct.findParentOfType(Struct.class) != null)
					continue;
					
				convertStruct(struct, signatures, out, libraryClassName);
			}
		}
	}
	void convertStruct(Struct struct, Set<String> signatures, List<Declaration> out, String callerLibraryClass) {
		if (struct.getTag() == null)
			return;
		
		if (struct.isForwardDeclaration() && !result.structsByName.get(struct.getTag()).isForwardDeclaration())
			return;
		
		String signature = "struct " + struct.getTag();
		if (!signatures.add(signature))
			return;
		
		String baseClass = (struct.getType() == Struct.Type.CUnion ? Union.class : Structure.class).getName();
		
		String indent = "\t";
		
		final Struct structJavaClass = publicStaticClass(struct.getTag(), baseClass, Struct.Type.JavaClass, struct);
		structJavaClass.addDeclaration(publicStaticClassDecl("ByReference", struct.getTag(), Struct.Type.JavaClass, null, Structure.class.getName() + ".ByReference"));
		structJavaClass.addDeclaration(publicStaticClassDecl("ByValue", struct.getTag(), Struct.Type.JavaClass, null, Structure.class.getName() + ".ByValue").addModifiers(Modifier.Final));
		
		Function constructor = new Function(Function.Type.JavaMethod, struct.getTag(), null);
		constructor.setBody(new Statement.Block());
		structJavaClass.addDeclaration(constructor);
		
		constructor = new Function(Function.Type.JavaMethod, struct.getTag(), null, 
			Arrays.asList(
				new Arg("pointer", new TypeRef.SimpleTypeRef(Pointer.class.getName())),
				new Arg("offset", new TypeRef.Primitive("int"))
			)
		);
		constructor.setBody(new Statement.Block(
				new Statement.ExpressionStatement(new Expression.FunctionCall("super")),
				new Statement.ExpressionStatement(new Expression.FunctionCall("useMemory", new Expression.VariableRef("pointer"), new Expression.VariableRef("offset"))),
				new Statement.ExpressionStatement(new Expression.FunctionCall("read"))
		));
		structJavaClass.addDeclaration(constructor);
		
		final int iChild[] = new int[] {0};
		
		//cl.addDeclaration(new EmptyDeclaration())
		Set<String> childSignatures = new TreeSet<String>();
		List<Declaration> children = new ArrayList<Declaration>();
		for (Declaration d : struct.getDeclarations()) {
			if (d instanceof VariablesDeclaration) {
				convertVariablesDeclaration((VariablesDeclaration)d, children, iChild, callerLibraryClass);
			} else if (d instanceof TaggedTypeRefDeclaration) {
				TaggedTypeRef tr = ((TaggedTypeRefDeclaration) d).getTaggedTypeRef();
				if (tr instanceof Struct) {
					convertStruct((Struct)tr, childSignatures, children, callerLibraryClass);
				} else if (tr instanceof Enum) {
					convertEnum((Enum)tr, childSignatures, children, callerLibraryClass);
				}
			} else if (d instanceof TypeDef) {
				TypeDef td = (TypeDef)d;
				TypeRef tr = td.getValueType();
				if (tr instanceof Struct) {
					convertStruct((Struct)tr, childSignatures, children, callerLibraryClass);
				} else if (tr instanceof FunctionSignature) {
					convertCallback((FunctionSignature)tr, childSignatures, children, callerLibraryClass);
				}
			}
		}
		structJavaClass.addDeclarations(children);
		out.add(decl(structJavaClass));
	}
	
	private void convertVariablesDeclaration(VariablesDeclaration v, List<Declaration> out, int[] iChild, String callerLibraryName) {
		//List<Declaration> out = new ArrayList<Declaration>();
		try {
			JavaPrim prim = result.typeConverter.getPrimitive(v.getValueType());
			TypeRef valueType = v.getValueType();
			for (Declarator vs : v.getDeclarators()) {
				String name = vs.resolveName();
				if (name == null || name.length() == 0)
					continue;
					//name = "u" + (iChild[0] + 1);
				name = result.typeConverter.getValidJavaArgumentName(name);
				
				Expression initVal = null;
				boolean hasFixedSizeStorage = false;
				String javaTypeStr = null;
				if (vs instanceof ArrayDeclarator) {
					ArrayDeclarator ad = (ArrayDeclarator) vs;
					if (!ad.getDimensions().isEmpty()) {
						javaTypeStr = result.typeConverter.typeToJNA(valueType, vs, 
							TypeConversion.TypeConversionMode.StaticallySizedArrayField, 
							callerLibraryName
						);
							
						//if (prim != null) {
							hasFixedSizeStorage = true;
							TypeRef arrayType = new TypeRef.SimpleTypeRef(result.typeConverter.toString(prim));
							Expression mul = null;
							List<Expression> dims = ad.getDimensions();
							for (Expression x : dims) {
								Expression c = result.typeConverter.convertExpressionToJava(x, callerLibraryName);
								c.setParenthesis(dims.size() == 1);
								if (mul == null)
									mul = c;
								else
									mul = new Expression.BinaryOp(BinaryOperator.Multiply, mul, c);
							}
							initVal = new Expression.NewArray(arrayType, mul);
						//}
					}
				}
				if (javaTypeStr == null) {
					javaTypeStr = result.typeConverter.typeToJNA((TypeRef)vs.mutateType(valueType), vs, 
						TypeConversion.TypeConversionMode.FieldType,
						callerLibraryName
					);
				}
				if (javaTypeStr == null || javaTypeStr.equals("void")) {
					out.add(new EmptyDeclaration("SKIPPED:", v.formatComments("", true, true, false), v.toString()));
					//println(indent + v.formatComments(indent, true));
					//print("//SKIPPED: ");
				}
				
				//boolean hasFixedSizeStorage = vs.getStorageModifiers().isEmpty() && prim != null && !vs.getDimensions().isEmpty();
				
				VariablesDeclaration convDecl = new VariablesDeclaration();
				convDecl.importDetails(v);
				convDecl.importDetails(valueType);
				valueType.stripDetails();
				convDecl.moveAllCommentsBefore();
				convDecl.setValueType(new TypeRef.SimpleTypeRef(javaTypeStr));
				convDecl.addDeclarator(new DirectDeclarator(name, initVal));
				convDecl.addModifiers(Modifier.Public);
				if (hasFixedSizeStorage)
					convDecl.addModifiers(Modifier.Final);
				
				out.add(convDecl);
				
				iChild[0]++;
			}
		} catch (UnsupportedTypeConversion e) {
		//	addException(e);
			out.add(new EmptyDeclaration(e.toString()));
		}
	}

	class Slice {
		public String file;
		public int line;
		public String text;
		public Slice(String file, int line, String text) {
			super();
			this.file = file;
			this.line = line;
			this.text = text;
		}
	}
	
	ThreadFactory daemonThreadFactory = new ThreadFactory() {
		public Thread newThread(Runnable r) {
			Thread t = new Thread(r);
			t.setDaemon(true);
			return t;
		}
	};
	
	public void run() throws IOException, LexerException, RecognitionException {
	
		JNAeratorConfigUtils.autoConfigure(config);
		
		String sourceContent = PreprocessorUtils.preprocessSources(config, sourceFiles.defines);
		
		PrintStream originalOut = System.out, originalErr = System.err;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		PrintStream pout = new PrintStream(bout);
		System.setOut(pout);
		System.setErr(pout);
		try {
			if (false) {
				// easier to debug
				try {
					ObjCppParser parser = newObjCppParser(sourceContent);
					SourceFile sourceFile = parser.sourceFile().sourceFile;
					sourceFiles.add(sourceFile);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else {
				// faster on multiprocessor architectures
				List<Slice> slices = cutSourceContentInSlices(sourceContent, originalOut);
				if (config.verbose)
					originalOut.println("Now parsing " + slices.size() + " text blocks");
				parseSlices(slices, originalOut, originalErr);
			} 
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			pout.flush();
			System.setOut(originalOut);
			System.setErr(originalErr);
			String errs = new String(bout.toByteArray());
			WriteText.writeText(errs, new File("out.errors.txt"));
		}
		
		/// Perform Objective-C-specific pre-transformation (javadoc conversion for enums + find name of enums based on next sibling integer typedefs)
		if (config.verbose)
			originalOut.println("Resolving symbols");
		
		sourceFiles.accept(new ObjectiveCToJavaPreScanner());
		sourceFiles.accept(new CToJavaPreScanner());

		if (config.verbose)
			originalOut.println("Defining missing names");
		sourceFiles.accept(new MissingNamesChooser());
		
		//TODO resolve variables in visual studio projects
		/**
		 * - choose arbitrary names where missing (use DefinitionsVisitor to find unused names)
		 * - resolve references of variables and types (map id -> type)
		 */
		
		//TODO - explode variable storages (mutate types, create new variablesdeclarations, map to comments model)
		 
		/// Resolution's first pass : define relevant chained environment for each element
//		if (config.verbose)
//			originalOut.println("Scanning environments");
//		final DefinitionsVisitor definitions = new DefinitionsVisitor();
//		sourceFiles.accept(definitions);
		
		/// Choose arbitrary names where missing (use DefinitionsVisitor to find unused names)
		// - function signatures
		// - structs
		
		
		/// Resolve references of variables and types (map id -> type)
//		originalOut.println("Resolving symbols");
//		ResolutionScanner resolutions = new ResolutionScanner(definitions, originalOut);
//		sourceFiles.accept(resolutions);
		

		/// Filter unused symbols from implicitely included files
//		if (config.symbolsAccepter != null) {
//			originalOut.println("Filtering unused symbols");
//			UnusedScanner unused = new UnusedScanner(resolutions, config.symbolsAccepter, null);//originalOut);
//			sourceFiles.accept(unused);
//			unused.removeUnused(null);	
//		}
		
		/// Convert all expressions. Propagate unconvertible expressions, mark corresponding elements / trees as "to be commented out"
		/// Clone comments, fix missing comments, parse Obj-C doc and spit out Javadoc (handle case of enum items, for instance).
		/// Build Obj-C classes, libraries, functions, enums, structs... Result has methods getResultingFunction(Function)... Map source element to returned element's id. Resulting element may depend on parent element, which it will create if it is missing.
		/// Factorize imports, spit out classes to files or straight to Java Compiler API (w/ sources as resources in JAR)
		/// Embed referenced libraries, generate self-extraction code for them, include in generated JAR.
		
		
		/// Gather Objective-C classes
		if (config.verbose)
			originalOut.println("Gathering Objective-C classes");
		
		sourceFiles.accept(result);
		
		result.chooseLibraryClasses(config.packageName, config.rootPackageName);
		
		/// Spit Objective-C classes out
		if (config.verbose)
			originalOut.println("Generating Objective-C classes");
		for (ObjCClass type : result.objCClasses.values()) {
			type.generateWrapperFile();
		}
		
		if (config.verbose)
			originalOut.println("Generating libraries");
		
		if (result.libraries.size() == 1) {
			List<Define> list = result.definesByLibrary.get(null);
			if (list != null) {
				String lib = result.libraries.iterator().next();
				Result.getList(result.definesByLibrary, lib).addAll(list);
			}
		}
		generateLibraryFiles(result);

		//if (config.verbose)
			for (String unknownType : result.typeConverter.unknownTypes) 
				System.out.println("Unknown Type: " + unknownType);
		
		//System.out.println("typedef: " + e.getKey() + " = " + e.getValue());
		
	}

	
	private void parseSlices(List<Slice> slices, PrintStream originalOut, PrintStream originalErr) throws InterruptedException {

		class ResultCountHolder {
			volatile int nSlicesParsed = 0;
		};
		
		final ResultCountHolder resultCountHolder = new ResultCountHolder();
		
		List<Pair<Slice, Future<SourceFile>>> sourceFileFutures = new ArrayList<Pair<Slice, Future<SourceFile>>>(slices.size());
		
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);//, daemonThreadFactory );//Executors.newCachedThreadPool();
		for (final Slice slice : slices) {
			sourceFileFutures.add(new Pair<Slice, Future<SourceFile>>(slice, executorService.submit(new Callable<SourceFile>() {

				public SourceFile call() throws Exception {
					try {
						ObjCppParser parser = newObjCppParser(slice.text);
						SourceFile sourceFile = parser.sourceFile().sourceFile;
						//sourceFile.setElementFile(slice.file);
						return sourceFile;
					} catch (Exception ex) {
						ex.printStackTrace();
						throw ex;
					} finally {
						resultCountHolder.nSlicesParsed++;
					}
				}
				
			})));
//				sourceFiles.add(newObjCppParser(slice).sourceFile().sourceFile);
		}
		if (slices.isEmpty()) {
			originalOut.println("Slices are empty with the following config : \n" + DebugUtils.toString(config));
		} else {
			//boolean waitIndefinitely = true;
			//if (waitIndefinitely) {
				executorService.shutdown();
				executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
			/*} else {
				for (int i = 4; i-- != 0;) {
					if (executorService.awaitTermination(1000, TimeUnit.MILLISECONDS))
						break;
					if (executorService.isTerminated())
						break;
					originalOut.println("Parsed " + resultCountHolder.nSlicesParsed + " / " + (slices.isEmpty() ? "0" : slices.size() +"") + "\t(" + ((resultCountHolder.nSlicesParsed * 100/ slices.size())) + " %)");
					if (resultCountHolder.nSlicesParsed == slices.size())
						break;
				}
			}*/
			
			for (Pair<Slice, Future<SourceFile>> p : sourceFileFutures) {
				try {
					sourceFiles.add(p.getSecond().get(1000, TimeUnit.MILLISECONDS));
				} catch (ExecutionException e) {
					originalErr.println("Exception for " + p.getFirst().file + " at line " + p.getFirst().line + ":" + e);
					e.printStackTrace();
					//e.getCause().printStackTrace();
				} catch (TimeoutException e) {
					originalErr.println("TIMEOUT for " + p.getFirst().file + " at line " + p.getFirst().line + ".");
				}
			}
		}
	}

	private List<Slice> cutSourceContentInSlices(String sourceContent, PrintStream originalOut) {
		StringBuffer currentEmptyLines = new StringBuffer();
		StringBuffer currentBuffer = new StringBuffer();
		
		boolean sliceGotContent = false;
		
		String[] lines = sourceContent.split("\n");
		int iLine = 0, nLines = lines.length, lastStart = 0;
		String lastFile = null;
		//int lastPercent = 0;
		

		Pattern fileInLinePattern = Pattern.compile("\"([^\"]+)\"");
		List<Slice> slices = new ArrayList<Slice>(nLines / 10);
		for (String line : lines) {
			/*int percent = (iLine + 1) * 100 / nLines;
			if (lastPercent != percent) {
				//originalOut.print("\b\b\b\b\b");
				originalOut.println(percent + "%");
				lastPercent = percent;
			}*/
			if (line.startsWith("#line")) {
				lastStart = iLine;
				lastFile = RegexUtils.findFirst(line, fileInLinePattern, 1);
				if (sliceGotContent) {
					//originalOut.println("Split: " + line.substring("#line".length()).trim());
					String content = currentBuffer.toString();
					slices.add(new Slice(lastFile, lastStart, content));
					//sourceFiles.add(newObjCppParser(content).sourceFile().sourceFile);
				}
				currentBuffer.setLength(0);
				//currentBuffer.append(currentEmptyLines);
				sliceGotContent = false;
			}
		
			if (!sliceGotContent)
				sliceGotContent = line.trim().length() > 0;
			currentBuffer.append(line);
			currentBuffer.append('\n');
			currentEmptyLines.append('\n');
			//deltaLines++;

			iLine++;
		}
		
		if (sliceGotContent) {
			String content = currentBuffer.toString();
			slices.add(new Slice(lastFile, lastStart, content));
			//sourceFiles.add(newObjCppParser(content).sourceFile().sourceFile);
		}
		return slices;
	}

}
