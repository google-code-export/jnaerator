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

import com.ochafik.lang.jnaerator.parser.Define;
import com.ochafik.lang.jnaerator.parser.Element;
import com.ochafik.lang.jnaerator.parser.Expression;
import com.ochafik.lang.jnaerator.parser.Scanner;
import com.ochafik.lang.jnaerator.parser.SourceFile;
import com.ochafik.lang.jnaerator.parser.Struct;
import com.ochafik.lang.jnaerator.parser.TypeRef;
import com.ochafik.lang.jnaerator.parser.Declarator;
import com.ochafik.lang.jnaerator.parser.Declarator.DirectDeclarator;
import com.ochafik.lang.jnaerator.parser.Expression.Constant;
import com.ochafik.lang.jnaerator.parser.Expression.MemberRef;
import com.ochafik.lang.jnaerator.parser.StoredDeclarations.TypeDef;
import com.ochafik.lang.jnaerator.parser.TypeRef.SimpleTypeRef;
import com.ochafik.lang.jnaerator.DefinitionsVisitor.Environment;
import com.ochafik.util.string.StringUtils;

import static com.ochafik.lang.jnaerator.parser.ElementsHelper.*;

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

		Element element = originalDefinitions.resolveElement(simpleTypeRef, name, null, Environment.Space.Types, Environment.Space.Enums, Environment.Space.Structs);
		if (element instanceof DirectDeclarator) {
			DirectDeclarator vs = (DirectDeclarator)element;
			Element parent = vs.getParentElement();
			if (parent != null) {
				if (parent instanceof TypeDef) {
					Declarator.MutableByDeclarator mut = vs.mutateType(((TypeDef) parent).getValueType());
					if (mut instanceof TypeRef) {
						simpleTypeRef.replaceBy((Element) mut);
						((Element)mut).accept(this);
					}
				} else if (parent instanceof Struct) {
					Struct s = (Struct) parent;
					String structName = s.getTag();
					// TODO ensure all structs have names !
					String library = getLibrary(s);
					if (library == null)
						throw new RuntimeException(new UnsupportedConversionException(simpleTypeRef, "struct " + structName + " is not bound to a library"));
					
					TypeRef tr = typeRef(getLibraryClassSimpleName(library) + "." + structName);
					simpleTypeRef.replaceBy(tr);
					tr.accept(this);
				}
			}
		} else if (element instanceof Define) {
			Define define = (Define) element;
			if (define.getValue() != null) {
				Expression expression = define.getValue().clone();
				if (expression instanceof MemberRef) {
					MemberRef fr = (MemberRef) expression;
					simpleTypeRef.replaceBy(typeRef(fr.getName()));
				} else
					throw new RuntimeException(new UnsupportedConversionException(simpleTypeRef, "no support for complex define expressions as of yet"));
			}
		}
		throw new RuntimeException(new UnsupportedConversionException(simpleTypeRef, null));
	}
	
	
	@Override
	public void visitConstant(Constant constant) {
		super.visitConstant(constant);
		
		String v  = ((Constant) constant).getValue().toString();
		if (v.endsWith("U"))
			throw new RuntimeException(new UnsupportedConversionException(constant, "no support for unsigned constants"));
	}
}
