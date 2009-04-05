/*
	Copyright (c) 2009 Olivier Chafik, All Rights Reserved
	
	This file is part of JNAerator (http://jnaerator.googlecode.com/).
	
	JNAerator is free software: you can redistribute it and/or modify
	it under the terms of the GNU Lesser General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.
	
	JNAerator is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU Lesser General Public License for more details.
	
	You should have received a copy of the GNU Lesser General Public License
	along with JNAerator.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.ochafik.lang.jnaerator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.ochafik.lang.jnaerator.parser.Define;
import com.ochafik.lang.jnaerator.parser.Element;
import com.ochafik.lang.jnaerator.parser.Enum;
import com.ochafik.lang.jnaerator.parser.Function;
import com.ochafik.lang.jnaerator.parser.Scanner;
import com.ochafik.lang.jnaerator.parser.SourceFile;
import com.ochafik.lang.jnaerator.parser.Struct;
import com.ochafik.lang.jnaerator.parser.TypeRef;
import com.ochafik.lang.jnaerator.parser.Declarator;
import com.ochafik.lang.jnaerator.parser.VariablesDeclaration;
import com.ochafik.lang.jnaerator.parser.Declarator.DirectDeclarator;
import com.ochafik.lang.jnaerator.parser.Enum.EnumItem;
import com.ochafik.lang.jnaerator.parser.StoredDeclarations.TypeDef;
import com.ochafik.lang.jnaerator.parser.TypeRef.FunctionSignature;
import com.ochafik.util.listenable.Pair;
import com.ochafik.util.string.StringUtils;
import com.sun.jna.Platform;

public class Result extends Scanner {

	public final JNAeratorConfig config;
	public final ClassOutputter classOutputter;
	public final TypeConversion typeConverter = new TypeConversion(this);
	public final DeclarationsConverter declarationsConverter = new DeclarationsConverter(this);
	public final GlobalsGenerator globalsGenerator = new GlobalsGenerator(this);
	
	/**
	 * @param aerator
	 */
	public Result(JNAeratorConfig config, ClassOutputter classOutputter) {
		this.config = config;
		this.classOutputter = classOutputter;
	}

	Set<String> javaPackages = new TreeSet<String>();
	
	Map<String, ObjCClass> objCClasses = new HashMap<String, ObjCClass>();
	//Set<String> 
		//cStructNames = new HashSet<String>(), 
		//enumNames = new HashSet<String>();
	
	Map<String, List<String>> missingPointersByUsingLibrary = new HashMap<String, List<String>>();
 	Map<String, List<Struct>> structsByLibrary = new HashMap<String, List<Struct>>();
	Map<String, List<FunctionSignature>> callbacksByLibrary = new HashMap<String, List<FunctionSignature>>();
	
	Map<String, List<VariablesDeclaration>> globalsByLibrary = new HashMap<String, List<VariablesDeclaration>>();
	
	Map<String, Struct> structsByName = new HashMap<String, Struct>();
	Map<String, FunctionSignature> callbacksByName = new HashMap<String, FunctionSignature>();
	
	Map<String, List<Enum>> enumsByLibrary = new HashMap<String, List<Enum>>();
	Map<String, Enum> enumsByName = new HashMap<String, Enum>();
	Map<String, EnumItem> enumItems = new HashMap<String, EnumItem>();
	Map<String, Define> defines = new HashMap<String, Define>();
	Map<String, List<Define>> definesByLibrary = new HashMap<String, List<Define>>();
	
	Map<String, List<Function>> functionsByLibrary = new HashMap<String, List<Function>>();
	//Map<String, Expression> defines = new LinkedHashMap<String, Expression>();
	Map<String, Set<String>> signaturesByOutputClass = new HashMap<String, Set<String>>();
	
	Map<String, Pair<TypeDef, Declarator>> typeDefs = new HashMap<String, Pair<TypeDef, Declarator>>();
	
	static <T> List<T> getList(Map<String, List<T>> m, String key) {
		List<T> list = m.get(key);
		if (list == null)
			m.put(key, list = new ArrayList<T>());
		return list;
	}
	
	public Set<String> getSignaturesForOutputClass(String name) {
		Set<String> s = signaturesByOutputClass.get(name);
		if (s == null)
			signaturesByOutputClass.put(name, s = new HashSet<String>());
		return s;
	}
	/*
	public void addDefine(String name, Expression ex) {
		defines.put(name, ex);
		String library = getLibrary(ex);
		if (library.equals(""))
			library = library.toString();

		getList(definesByLibrary, getLibrary(ex)).add(new Pair<String, Expression>(name, ex));
	}*/
	
	@Override
	public void visitDefine(Define define) {
		super.visitDefine(define);
		defines.put(define.getName(), define);
		getList(definesByLibrary, getLibrary(define)).add(define);
	}
	
	ObjCClass getObjCClass(String name) {
		ObjCClass c = objCClasses.get(name);
		if (c == null)
			objCClasses.put(name, c = new ObjCClass(this));
		return c;
	}
	public void addObjCClass(Struct c) {
		if (c.isForwardDeclaration())
			return;
		
		ObjCClass cc = getObjCClass(c.getTag());
		if (c.getCategoryName() != null)
			cc.categories.add(c);
//		else if (!c.getProtocols().isEmpty())
//			cc.protocols.add(c);
		else {
			if (cc.type != null) {
				SourceFile sourceFile = c.findParentOfType(SourceFile.class);
				String f = sourceFile.getElementFile();
				if (f != null) {
					String fileName = new File(f).getName();
					SourceFile sourceFile2 = cc.type.findParentOfType(SourceFile.class);
					String fileName2 = new File(sourceFile2.getElementFile()).getName();
					System.err.println("Class " + c.getTag() + " defined more than once (in " + fileName + " and " + fileName2 +")");
				} else {
					System.err.println("Class " + c.getTag() + " defined more than once");
				}
			} else {
				//cc.javaPackage = aerator.getOutputJavaPackage(c);
				cc.type = c;
			}
		}
	}
	
	@Override
	public void visitEnum(Enum e) {
		super.visitEnum(e);
		if (e.getTag() == null) {
			// Hack to infer the enum name from the next typedef NSUInteger NSSomethingThatLooksLikeTheEnumsIdentifiers
			Element nextDeclaration = e.getNextSibling();
			if (nextDeclaration != null && (nextDeclaration instanceof TypeDef)) {
				TypeDef typeDef = (TypeDef) nextDeclaration;
				TypeRef type = typeDef.getValueType();
				if (type instanceof TypeRef.SimpleTypeRef) {
					String simpleType = ((TypeRef.SimpleTypeRef)type).getName();
					if (simpleType.equals("NSUInteger") || 
							simpleType.equals("NSInteger") ||
							simpleType.equals("CFIndex")) 
					{
						Declarator bestPlainStorage = null;
						for (Declarator st : typeDef.getDeclarators()) {
							if (st instanceof DirectDeclarator) {
								boolean niceName = !st.resolveName().startsWith("_");
								if (bestPlainStorage == null || niceName) {
									bestPlainStorage = st;
									if (niceName)
										break;
								}
							}
						}
						if (bestPlainStorage != null) {
							String name = bestPlainStorage.resolveName();
							System.err.println("Automatic struct name matching : " + name);
							e.setTag(name);
						}
					}
				}
			}
		}
		
		if (e.getTag() != null) {
			enumsByName.put(e.getTag(), e);
		}
		
		getList(enumsByLibrary, getLibrary(e)).add(e);
	}
	
	@Override
	public void visitEnumItem(EnumItem enumItem) {
		super.visitEnumItem(enumItem);
		enumItems.put(enumItem.getName(), enumItem);
	}
	

	@Override
	public void visitVariablesDeclaration(VariablesDeclaration v) {
		super.visitVariablesDeclaration(v);
		if (v.findParentOfTypes(Struct.class, Function.class, Enum.class) != null)
			return;

		getList(globalsByLibrary, getLibrary(v)).add(v);
	}
	@Override
	public void visitTypeDef(TypeDef typeDef) {
		super.visitTypeDef(typeDef);
		for (Declarator vs : typeDef.getDeclarators())
			typeDefs.put(vs.resolveName(), new Pair<TypeDef, Declarator>(typeDef, vs));
	}
	
	String getLibrary(Element decl) {
		String library = null;
		SourceFile f = decl.findParentOfType(SourceFile.class);
		if (f != null) {
			library = f.guessFramework();
			if (library == null)
				library = f.getLibrary();
		}
		if (library == null) {
			Element e = decl;
			String file = null;
			while (e != null && (file = e.getElementFile()) == null) {
				e = e.getParentElement();
			}
			if (decl instanceof Define) {
				e = decl;
			}
			library = config.getLibrary(file);
		}
		return library;
	}
	
	@Override
	public void visitFunction(Function function) {
		super.visitFunction(function);
		Element parent = function.getParentElement();
		if (parent != null) {
			if (parent instanceof FunctionSignature)
				return;
			if (parent instanceof Struct) {
				Struct parentStruct = (Struct)parent;
				switch (parentStruct.getType()) {
					case CPPClass:
					case JavaClass:
					case JavaInterface:
					case ObjCClass:
					case ObjCProtocol:
					case CStruct:
						return;
				}
			}
		}
		
		getList(functionsByLibrary, getLibrary(function)).add(function);
	}
	
	@Override
	public void visitStruct(Struct struct) {
		super.visitStruct(struct);
		
		String name = struct.getTag();
		if (name != null) {
			switch (struct.getType()) {
			case CStruct:
			case CUnion:
				Struct oldStruct = structsByName.get(name);
				if (oldStruct == null || oldStruct.isForwardDeclaration())
					structsByName.put(name, struct);
				
				getList(structsByLibrary, getLibrary(struct)).add(struct);
				break;
			case ObjCClass:
			case ObjCProtocol:
				addObjCClass(struct);
				break;
			default:
				struct = null;
			}
		}
	}
	
	@Override
	public void visitFunctionSignature(FunctionSignature functionSignature) {
		super.visitFunctionSignature(functionSignature);
		Function function = functionSignature.getFunction();
		if (function != null) {
			getList(callbacksByLibrary, getLibrary(functionSignature)).add(functionSignature);
			String name = typeConverter.inferCallBackName(functionSignature, false);
			if (name != null)
				callbacksByName.put(name, functionSignature);
		}
	}

	public String getLibraryClassSimpleName(String library) {
		return StringUtils.capitalize(library) + "Library";
	}
	public String getLibraryFileExpression(String library) {
		if (library.equals("c"))
			return "(" + Platform.class.getName() + ".isWindows() ? \"msvcrt\" : \"c\")";
		
		return "\"" + library + "\"";
	}

	Set<String> libraries = new HashSet<String>();
	Map<String, String> javaPackageByLibrary = new HashMap<String, String>();
	
	public void chooseLibraryClasses(String packageName, String rootPackageName) {
		libraries.clear();
		javaPackages.clear();
		javaPackageByLibrary.clear();
		
		libraries.addAll(structsByLibrary.keySet());
		libraries.addAll(callbacksByLibrary.keySet());
		libraries.addAll(functionsByLibrary.keySet());
		libraries.addAll(enumsByLibrary.keySet());
		libraries.addAll(globalsByLibrary.keySet());
		libraries.addAll(definesByLibrary.keySet());
		
		for (String library : libraries) {
			if (library == null || library.length() == 0)
				continue;
			
			String javaPackage = packageName == null ? (rootPackageName == null ? "" : rootPackageName + ".") + library.toLowerCase() : packageName;
			javaPackageByLibrary.put(library, javaPackage);
		}
		javaPackages.addAll(javaPackageByLibrary.values());
		
	}
}