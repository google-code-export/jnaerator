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

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.ochafik.lang.jnaerator.parser.Declaration;
import com.ochafik.lang.jnaerator.parser.Expression;
import com.ochafik.lang.jnaerator.parser.Function;
import com.ochafik.lang.jnaerator.parser.Modifier;
import com.ochafik.lang.jnaerator.parser.PrintScanner;
import com.ochafik.lang.jnaerator.parser.StoredDeclarations;
import com.ochafik.lang.jnaerator.parser.Struct;
import com.ochafik.lang.jnaerator.parser.TaggedTypeRefDeclaration;
import com.ochafik.lang.jnaerator.parser.TypeRef;
import com.ochafik.lang.jnaerator.parser.Declarator;
import com.ochafik.lang.jnaerator.parser.VariablesDeclaration;
import com.ochafik.lang.jnaerator.parser.Expression.Constant;
import com.ochafik.lang.jnaerator.parser.Expression.MemberRefStyle;
import com.ochafik.lang.jnaerator.parser.TypeRef.FunctionSignature;
import com.ochafik.util.CompoundCollection;

class ObjCClass {
	/**
	 * 
	 */
	private final Result result;

	/**
	 * @param result
	 */
	ObjCClass(Result result) {
		this.result = result;
	}
	
	static TypeRef ROCOCOA_ID_TYPEREF = new TypeRef.SimpleTypeRef("id");
	

	Struct type;
	//String javaPackage;
	List<Struct> categories = new ArrayList<Struct>(), protocols = new ArrayList<Struct>();
	
	public void generateWrapperFile() throws IOException {
		if (type == null)
			return;
		
		String library = result.getLibrary(type);
		String javaPackage = result.javaPackageByLibrary.get(library);
		//String libraryClassName = result.getLibraryClassSimpleName(library);
		
		PrintWriter out = result.classOutputter.getClassSourceWriter(javaPackage + "." + type.getTag());
		//this.result.javaPackages.add(javaPackage);
		
		String fullClassName = type.getTag();
		if (javaPackage != null && javaPackage.length() > 0) {
			out.println("package " + javaPackage + ";");
			//fullClassName = javaPackage + "." + type.getName();
		}
		
		for (String pn : this.result.javaPackages) {
			if (this.result.javaPackages.equals(javaPackage))
				continue;
			out.println("import " + pn + ".*;");
		}
		out.println("import org.rococoa.ID;");
		out.println(toRococoaHeaderDOMWithCategories(fullClassName));
		//out.println(toRococoaHeaderWithCategories());
		out.close();
	}

	/*
	@Deprecated
	private String toRococoaHeaderWithCategories() {
		StringBuilder s = new StringBuilder();
		if (type.getCategoryName() != null)
			s.append("/// @Protocol");
		
		List<String> extensions = new ArrayList<String>(), missingExtensions = new ArrayList<String>();
		
		String superType = null;
		if (type.getParents().isEmpty()) {
			if (!type.getName().equals("NSObject"))
				superType = "NSObject";
		} else
			superType = type.getParents().iterator().next();
			
		if (!result.objCClasses.containsKey(superType)) {
			missingExtensions.add(superType);
			if (!type.getName().equals("NSObject"))
				superType = "NSObject";
		}
		if (!extensions.contains(superType) && superType != null)
			extensions.add(superType);
		
		//extensions.add(superType == null ? "NSObject" : superType);
		for (String prot : type.getProtocols()) {
			if (prot.equals(type.getName()))
				continue;
			List<String> c = result.objCClasses.containsKey(prot) ? extensions : missingExtensions;
			if (!c.contains(prot))
				c.add(prot);
		}
		
		List<String> otherComments = new ArrayList<String>();
		otherComments.add(result.jnaerator.getFileCommentContent(type));
		
		for (Struct ss : protocols)
			if (ss.getCommentBefore() != null) {
				otherComments.add("");
				otherComments.add("Imported " + ss.getCategoryName() + " " + result.jnaerator.getFileCommentContent(ss));
				otherComments.add(ss.getCommentBefore());
			}
		
		for (Struct ss : categories)
			if (ss.getCommentBefore() != null) {
				otherComments.add("");
				otherComments.add("Imported " + ss.getCategoryName() + " " + result.jnaerator.getFileCommentContent(ss));
				otherComments.add(ss.getCommentBefore());
			}
		
		s.append("\n");
		s.append(type.formatComments("", true, otherComments.toArray(new String[0])));
		s.append("\n");
		s.append("public interface " + type.getName() + 
				(extensions.isEmpty() ? "" : " extends " + implode(extensions, ", ")) + 
				(missingExtensions.isEmpty() ? "" : " /*, " + implode(missingExtensions, ", ") + "*" + "/") +  " {\n");
		
			PrintScanner callbackScanner = new PrintScanner("") {
				Set<String> signatures = new TreeSet<String>();
				@Override
				public void visitFunctionSignature(FunctionSignature functionSignature) {
					super.visitFunctionSignature(functionSignature);
					result.jnaerator.outputCallback(result, out, functionSignature, null, signatures, "\t");
				}
			};
			for (Struct c : categories)
				c.accept(callbackScanner);
			for (Struct c : protocols)
				c.accept(callbackScanner);
			
			s.append(callbackScanner.toString());
			
			s.append("\n");
			s.append("\tpublic static final _Class CLASS = org.rococoa.Rococoa.createClass(\"" + type.getName() + "\", _Class.class);\n");
		
			MethodScanner ms = new MethodScanner(s, true);
			s.append("\tpublic interface _Class extends org.rococoa.NSClass {\n");
				type.accept(ms);
				for (Struct c : categories)
					c.accept(ms);
				for (Struct c : protocols)
					c.accept(ms);
				
			s.append("\n\t}\n");
		
			ms.setOnlyStatic(false);
			ms.existingSignatures.clear();
			type.accept(ms);
			for (Struct c : categories)
				c.accept(ms);
			for (Struct c : protocols)
				c.accept(ms);
		
		s.append("\n}\n");
		return s.toString();
	}*/
	
	
	private Struct toRococoaHeaderDOMWithCategories(final String callerLibraryClass) {
//		StringBuilder s = new StringBuilder();
//		if (type.getCategoryName() != null)
//			s.append("/// @Protocol");
		
		List<String> extensions = new ArrayList<String>(), missingExtensions = new ArrayList<String>();
		
		String superType = null;
		if (type.getParents().isEmpty()) {
			if (!type.getTag().equals("NSObject"))
				superType = "NSObject";
		} else
			superType = type.getParents().iterator().next();
			
		if (!result.objCClasses.containsKey(superType)) {
			missingExtensions.add(superType);
			if (!type.getTag().equals("NSObject"))
				superType = "NSObject";
		}
		if (!extensions.contains(superType) && superType != null)
			extensions.add(superType);
		
		//extensions.add(superType == null ? "NSObject" : superType);
		for (String prot : type.getProtocols()) {
			if (prot.equals(type.getTag()))
				continue;
			List<String> c = result.objCClasses.containsKey(prot) ? extensions : missingExtensions;
			if (!c.contains(prot))
				c.add(prot);
		}
		
		List<String> otherComments = new ArrayList<String>();
		otherComments.add(result.declarationsConverter.getFileCommentContent(type));
		
		for (Struct ss : protocols)
			if (ss.getCommentBefore() != null) {
				otherComments.add("");
				otherComments.add("Imported " + ss.getCategoryName() + " " + result.declarationsConverter.getFileCommentContent(ss));
				otherComments.add(ss.getCommentBefore());
			}
		
		for (Struct ss : categories)
			if (ss.getCommentBefore() != null) {
				otherComments.add("");
				otherComments.add("Imported " + ss.getCategoryName() + " " + result.declarationsConverter.getFileCommentContent(ss));
				otherComments.add(ss.getCommentBefore());
			}
		
		final Struct instanceStruct = new Struct();
		instanceStruct.setType(Struct.Type.JavaInterface);
		instanceStruct.addModifiers(Modifier.Public);
		instanceStruct.setTag(type.getTag());
		instanceStruct.setParents(extensions);
		
		instanceStruct.addToCommentBefore(otherComments);
		
		PrintScanner callbackScanner = new PrintScanner("") {
			Set<String> signatures = new TreeSet<String>();
			@Override
			public void visitFunctionSignature(FunctionSignature functionSignature) {
				super.visitFunctionSignature(functionSignature);
				List<Declaration> decls = new ArrayList<Declaration>();
				result.declarationsConverter.convertCallback(functionSignature, signatures, decls, callerLibraryClass);
				instanceStruct.addDeclarations(decls);
			}
		};
		for (Struct c : categories)
			c.accept(callbackScanner);
		for (Struct c : protocols)
			c.accept(callbackScanner);
		
		//s.append(callbackScanner.toString());
		
		//s.append("\n");
		
		//Struct classStruct = new Struct();
		//classStruct.setName(superType)
		StoredDeclarations classHolder = new VariablesDeclaration();
		classHolder.setValueType(new TypeRef.SimpleTypeRef("_Class"));
		Expression.FunctionCall call = new Expression.FunctionCall(new Expression.TypeRefExpression(new TypeRef.SimpleTypeRef("org.rococoa.Rococoa")), "createClass", MemberRefStyle.Dot);
		call.addArgument(new Expression.Constant(Constant.Type.String, type.getTag()));
		call.addArgument(new Expression.FieldRef(new Expression.TypeRefExpression(new TypeRef.SimpleTypeRef("_Class")), "class", MemberRefStyle.Dot));
		classHolder.addDeclarator(new Declarator.DirectDeclarator("CLASS", call));
		
		instanceStruct.addDeclaration(classHolder);
		//s.append("\tpublic static final _Class CLASS = org.rococoa.Rococoa.createClass(\"" + type.getName() + "\", _Class.class);\n");
	
		Struct classStruct = new Struct();
		classStruct.setTag("_Class");
		classStruct.setType(Struct.Type.JavaInterface);
		classStruct.addParent("org.rococoa.NSClass");
		classStruct.addModifiers(Modifier.Public);
		
		instanceStruct.addDeclaration(new TaggedTypeRefDeclaration(classStruct));
		
		CompoundCollection<Declaration> declarations = new CompoundCollection<Declaration>();
		declarations.addComponent(type.getDeclarations());
		for (Struct c : categories)
			declarations.addComponent(c.getDeclarations());
		for (Struct c : protocols)
			declarations.addComponent(c.getDeclarations());
	
		Set<String> signatures = new HashSet<String>();
		
		for (Declaration d : declarations) {
			if (d instanceof Function) {
				Function f = (Function)d;//as(d, Function.class);
				List<Declaration> conv = new ArrayList<Declaration>();
				result.declarationsConverter.convertFunction(f, signatures, false, conv, callerLibraryClass);
				if (f.getModifiers().contains(Modifier.Static)) {
					classStruct.addDeclarations(conv);
				} else {
					instanceStruct.addDeclarations(conv);
				}
			}
		}
		
		return instanceStruct;
	}
}