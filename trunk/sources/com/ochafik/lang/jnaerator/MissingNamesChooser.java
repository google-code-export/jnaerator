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

import java.util.ArrayList;
import java.util.List;

import com.ochafik.lang.jnaerator.parser.Arg;
import com.ochafik.lang.jnaerator.parser.DeclarationsHolder;
import com.ochafik.lang.jnaerator.parser.Element;
import com.ochafik.lang.jnaerator.parser.Enum;
import com.ochafik.lang.jnaerator.parser.Function;
import com.ochafik.lang.jnaerator.parser.Scanner;
import com.ochafik.lang.jnaerator.parser.StoredDeclarations;
import com.ochafik.lang.jnaerator.parser.Struct;
import com.ochafik.lang.jnaerator.parser.TaggedTypeRefDeclaration;
import com.ochafik.lang.jnaerator.parser.TypeRef;
import com.ochafik.lang.jnaerator.parser.VariablesDeclaration;
import com.ochafik.lang.jnaerator.parser.Declarator.DirectDeclarator;
import com.ochafik.lang.jnaerator.parser.StoredDeclarations.TypeDef;
import com.ochafik.lang.jnaerator.parser.TypeRef.FunctionSignature;
import com.ochafik.lang.jnaerator.parser.TypeRef.TaggedTypeRef;
import com.ochafik.util.Adapter;
import com.ochafik.util.string.StringUtils;

public class MissingNamesChooser extends Scanner {
	@Override
	public void visitFunctionSignature(FunctionSignature functionSignature) {
		super.visitFunctionSignature(functionSignature);
		
		if (chooseNameIfMissing(functionSignature))
			return;

		//Struct s = structTypeRef.getStruct();
		DeclarationsHolder holder = functionSignature.findParentOfType(DeclarationsHolder.class);
		Function f = functionSignature.getFunction();
		if (holder != null && f != null && f.getName() != null) {
			//if (s.getName() != null) {
			StoredDeclarations d = as(functionSignature.getParentElement(), StoredDeclarations.class);
			if (d instanceof TypeDef)
				return;
			
			if (d != null && d.getDeclarators().isEmpty())
				d.replaceBy(null); // special case of C++-like struct sub-type definition 
			else
				//structTypeRef.replaceBy(new TypeRef.SimpleTypeRef(s.getName()));
				functionSignature.replaceBy(new TypeRef.SimpleTypeRef(f.getName()));
			TypeDef td = new TypeDef();
			//td.importDetails(d, false);
			td.importDetails(functionSignature, true);
			td.setValueType(functionSignature);
			td.addDeclarator(new DirectDeclarator(f.getName()));
			holder.addDeclaration(td);
		}
	}
	
	@Override
	public void visitTaggedTypeRef(TaggedTypeRef taggedTypeRef) {
		super.visitTaggedTypeRef(taggedTypeRef);

		if (chooseNameIfMissing(taggedTypeRef))
			return;
		
		Element parent = taggedTypeRef.getParentElement(); 
		if (!(parent instanceof TaggedTypeRefDeclaration)) {
			DeclarationsHolder holder = taggedTypeRef.findParentOfType(DeclarationsHolder.class);
			if (holder != null && holder != taggedTypeRef.getParentElement() && !(parent instanceof DeclarationsHolder)) {
				//if (s.getName() != null) {
//				if (taggedTypeRef instanceof Enum)
//					taggedTypeRef.replaceBy(new TypeRef.SimpleTypeRef("int"));//taggedTypeRef.getTag()));
//				else
					taggedTypeRef.replaceBy(new TypeRef.SimpleTypeRef(taggedTypeRef.getTag()));
				
		 		TaggedTypeRefDeclaration td = new TaggedTypeRefDeclaration(taggedTypeRef);
		 		holder.addDeclaration(td);
				td.accept(this);
				//VariablesDeclaration pd = as(taggedTypeRef.getParentElement(), VariablesDeclaration.class);
				//if (pd != null && pd.getDeclarators().isEmpty())
				//	pd.replaceBy(null); // special case of C++-like struct sub-type definition
			}
		}
	}
	
	/**
	 * @return true if the functionSignature changed and triggerered revisitation
	 */
	private boolean chooseNameIfMissing(FunctionSignature functionSignature) {
		Function function = functionSignature.getFunction();
		if (function == null)
			return false;
		
//		if (function.getName() == null) {
//			StoredDeclarations td = as(function.getParentElement(), StoredDeclarations.class);
//			String bestName = JNAeratorUtils.findBestPlainStorageName(td);
//			if (bestName != null) {
//				function.setName(bestName);
//				function.accept(this);
//				return true;
//			}
//		}

		Element parent = functionSignature.getParentElement();
		if (function.getName() == null) {// || parent instanceof VariablesDeclaration) {
			List<String> ownerNames = JNAeratorUtils.guessOwnerName(function);
			String name = chooseName(functionSignature, ownerNames);
			if (name != null) {
				function.setName(name);
				function.accept(this);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return true if changed and revisited on change results (caller can give up)
	 */
	private boolean chooseNameIfMissing(TaggedTypeRef taggedTypeRef) {
//		if (taggedTypeRef.getTag() == null) {
//			StoredDeclarations td = as(taggedTypeRef.getParentElement(), StoredDeclarations.class);
//			String bestName = JNAeratorUtils.findBestPlainStorageName(td);
//			if (bestName != null) {
//				taggedTypeRef.setTag(bestName);
//				taggedTypeRef.accept(this);
//				return true;
//			}
//		}
		if (taggedTypeRef.getTag() == null) {
			List<String> ownerNames = JNAeratorUtils.guessOwnerName(taggedTypeRef);//.getParentElement() instanceof StructTypeRef ? struct.getParentElement() : struct);
			String tag = chooseName(taggedTypeRef, ownerNames);
			if (tag != null) {
				taggedTypeRef.setTag(tag);
				taggedTypeRef.accept(this);
				return true;
			}
		}
		return false;
	}
	
	public String chooseName(Element e, List<String> ownerNames) {
		String s = chooseNameSuffix(e);
		if (s == null)
			return null;
		
		List<String> names = new ArrayList<String>();
		if (ownerNames != null)
			names.addAll(ownerNames);
		if (ownerNames.isEmpty())
			return null;
		
		names.add(s);
		return StringUtils.implode(names, "_");
		//return StringUtils.capitalize(ownerNames, "_");
	}
	public String chooseNameSuffix(Element e) {
		if (e instanceof Struct) {
			Struct struct = (Struct)e;
			if (struct.getType() == Struct.Type.CStruct) {
				return "struct";
			} else if (struct.getType() == Struct.Type.CUnion) {
				return "union";
			}
		} else if (e instanceof Enum) {
			return "enum";
		} else if (e instanceof FunctionSignature)
			return "callback";
		return null;
	}

	static <T extends Element> T importDetails(T t, Element e, boolean move) {
		t.importDetails(e, move);
		return t;
	}
	
}