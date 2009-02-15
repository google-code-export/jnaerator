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

import com.ochafik.lang.grammar.objcpp.Define;
import com.ochafik.lang.grammar.objcpp.Element;
import com.ochafik.lang.grammar.objcpp.Expression;
import com.ochafik.lang.grammar.objcpp.Scanner;
import com.ochafik.lang.grammar.objcpp.SourceFile;
import com.ochafik.lang.grammar.objcpp.Struct;
import com.ochafik.lang.grammar.objcpp.TypeRef;
import com.ochafik.lang.grammar.objcpp.VariableStorage;
import com.ochafik.lang.grammar.objcpp.Expression.Constant;
import com.ochafik.lang.grammar.objcpp.Expression.FieldRef;
import com.ochafik.lang.grammar.objcpp.StoredDeclarations.TypeDef;
import com.ochafik.lang.grammar.objcpp.TypeRef.SimpleTypeRef;
import com.ochafik.lang.jnaerator.TypeConversion.UnsupportedTypeConversion;
import com.ochafik.util.string.StringUtils;

public class ObjCppToJavaScanner extends Scanner {
	DefinitionsVisitor originalDefinitions = new DefinitionsVisitor();
	
	public void setOriginalDefinitions(DefinitionsVisitor originalDefinitions) {
		this.originalDefinitions = originalDefinitions;
	}
	public DefinitionsVisitor getOriginalDefinitions() {
		return originalDefinitions;
	}
	
//	public ObjCppToJavaScanner(SourceFiles sourceFiles) {
//		SourceFiles clone = new SourceFiles();
//		for (SourceFile sourceFile : sourceFiles)
//			clone.add(sourceFile.clone());
//	}
	
	public String getLibraryClassSimpleName(String library) {
		return StringUtils.capitalize(library) + "Library";
	}
	
	static String getLibrary(Element decl) {
		SourceFile f = decl.findParentOfType(SourceFile.class);
		if (f == null)
			return "";
		String library = f.guessFramework();
		if (library == null)
			library = f.getLibrary();
		if (library == null)
			library = "";
		return library;
	}
	
	@Override
	protected void visitTypeRef(TypeRef array) {
		// TODO Auto-generated method stub
		super.visitTypeRef(array);
	}
	@Override
	public void visitSimpleTypeRef(SimpleTypeRef simpleTypeRef) {
		String name = simpleTypeRef.getName();
		TypeRef manualTypeRef = TypeConversion.manualTypeDefs.get(name);
		if (manualTypeRef != null) {
			simpleTypeRef.replaceBy(manualTypeRef);
			manualTypeRef.accept(this);
			return;
		}
		
		// TODO add defines to top level environment
		/*
		Expression expression = result.defines.get(name);
		if (expression != null) {
			String fieldName = null;
			if (expression instanceof Expression.VariableRef) 
				fieldName = ((Expression.VariableRef) expression).getName();
			else if (expression instanceof Expression.FieldRef)
				fieldName = ((FieldRef) expression).getName();
			
			if (fieldName != null && !fieldName.equals(name))
				return resolveTypeDef(new TypeRef.SimpleTypeRef(fieldName));
		}*/

		Element element = originalDefinitions.resolveElement(simpleTypeRef, name, null);
		if (element instanceof VariableStorage) {
			VariableStorage vs = (VariableStorage)element;
			Element parent = vs.getParentElement();
			if (parent != null) {
				if (parent instanceof TypeDef) {
					TypeRef tr = vs.mutateType(((TypeDef) parent).getValueType());
					simpleTypeRef.replaceBy(tr);
					tr.accept(this);
				} else if (parent instanceof Struct) {
					Struct s = (Struct) parent;
					String structName = s.getName();
					// TODO ensure all structs have names !
					String library = getLibrary(s);
					if (library == null)
						throw new UnsupportedTypeConversion(simpleTypeRef);
					
					TypeRef tr = new SimpleTypeRef(getLibraryClassSimpleName(library) + "." + structName);
					simpleTypeRef.replaceBy(tr);
					tr.accept(this);
				}
			}
		} else if (element instanceof Define) {
			Define define = (Define) element;
			if (define.getValue() != null) {
				Expression expression = define.getValue().clone();
				if (expression instanceof FieldRef) {
					FieldRef fr = (FieldRef) expression;
					TypeRef tr = new SimpleTypeRef(fr.getName());
					simpleTypeRef.replaceBy(tr);
				} else
					throw new UnsupportedTypeConversion(simpleTypeRef);
			}
		}
		throw new UnsupportedTypeConversion(simpleTypeRef);
	}
	
	
	@Override
	public void visitConstant(Constant constant) {
		super.visitConstant(constant);
		
		String v  = ((Constant) constant).getValue().toString();
		if (v.endsWith("U"))
			throw new UnsupportedTypeConversion(constant);
	}
}
