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
import java.util.Set;
import java.util.TreeSet;

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
import com.ochafik.util.listenable.Pair;
import com.ochafik.util.string.StringUtils;

public class MissingNamesChooser extends Scanner {
	public enum NameGenerationStyle {
		Java, PreserveCaseAndSeparateByUnderscores
	}
	NameGenerationStyle nameGenerationStyle = NameGenerationStyle.PreserveCaseAndSeparateByUnderscores;
	
	public void setNameGenerationStyle(NameGenerationStyle nameGenerationStyle) {
		this.nameGenerationStyle = nameGenerationStyle;
	}
	
	public String chooseArgNameFromType(TypeRef tr) throws UnsupportedConversionException {
		if (tr instanceof TypeRef.SimpleTypeRef) {
			return ((TypeRef.SimpleTypeRef)tr).getName();
		} else if (tr instanceof TypeRef.Pointer) {
			return chooseArgNameFromType(((TypeRef.Pointer)tr).getTarget()) + "Ptr";
		} else if (tr instanceof TypeRef.ArrayRef) {
			return chooseArgNameFromType(((TypeRef.ArrayRef)tr).getTarget()) + "Arr";
		}
		throw new UnsupportedConversionException(tr, String.valueOf(tr));
	}
	@Override
	public void visitFunction(Function function) {
		switch (function.getType()) {
			case CFunction:
			case CppMethod:
				Set<String> names = new TreeSet<String>();
				List<Pair<Arg, Integer>> missing = new ArrayList<Pair<Arg,Integer>>();
				int i = 0;//, n = function.getArgs().size();
				
				for (Arg arg : function.getArgs()) {
					if (arg.getName() == null) {
						missing.add(new Pair<Arg, Integer>(arg, i));
					} else
						names.add(arg.getName());
					i++;
				}
				for (Pair<Arg, Integer> p : missing) {
					i = 1;
					String base;
					try {
						base = chooseArgNameFromType(p.getFirst().getValueType());
					} catch (UnsupportedConversionException ex) {
						base = "arg";
					}
//					if (p.getFirst().getValueType() instanceof TypeRef.SimpleTypeRef)
//						base = ((TypeRef.SimpleTypeRef)p.getFirst().getValueType()).getName();
//					else
//						base = "arg";
					
					//(n == 1 ? "" : p.getValue())
					String name;
					while (names.contains(name = base + i))
						i++;
					names.add(name);
					p.getFirst().setName(name);
				}
				break;
		}
		
		super.visitFunction(function);
	}
	
	@Override
	public void visitFunctionSignature(FunctionSignature functionSignature) {
		if (chooseNameIfMissing(functionSignature))
			return;

		super.visitFunctionSignature(functionSignature);
		
		DeclarationsHolder holder = functionSignature.findParentOfType(DeclarationsHolder.class);
		Function f = functionSignature.getFunction();
		if (holder != null && f != null && f.getName() != null) {
			StoredDeclarations d = as(functionSignature.getParentElement(), StoredDeclarations.class);
			if (d instanceof TypeDef)
				return;
			
			if (d != null && d.getDeclarators().isEmpty())
				d.replaceBy(null); // special case of C++-like struct sub-type definition 
			else
				functionSignature.replaceBy(new TypeRef.SimpleTypeRef(f.getName()));
			TypeDef td = new TypeDef();
			td.importDetails(functionSignature, true);
			td.setValueType(functionSignature);
			td.addDeclarator(new DirectDeclarator(f.getName()));
			holder.addDeclaration(td);
			td.accept(this);
		}
	}
	
	@Override
	public void visitTaggedTypeRef(TaggedTypeRef taggedTypeRef) {
		super.visitTaggedTypeRef(taggedTypeRef);

		if (chooseNameIfMissing(taggedTypeRef))
			return;
		
		Element parent = taggedTypeRef.getParentElement(); 
		if (!(parent instanceof TaggedTypeRefDeclaration) && !(parent instanceof TypeDef)) {
			DeclarationsHolder holder = taggedTypeRef.findParentOfType(DeclarationsHolder.class);
			if (holder != null && holder != taggedTypeRef.getParentElement() && !(parent instanceof DeclarationsHolder)) {
				TaggedTypeRefDeclaration td = new TaggedTypeRefDeclaration();
				if (parent instanceof VariablesDeclaration && ((VariablesDeclaration)parent).getDeclarators().isEmpty()) {
					taggedTypeRef.importDetails(parent, false);
					parent.replaceBy(null);
				} else
					taggedTypeRef.replaceBy(new TypeRef.SimpleTypeRef(taggedTypeRef.getTag()));
				
		 		td.setTaggedTypeRef(taggedTypeRef);
		 		holder.addDeclaration(td);
				td.accept(this);
			}
		}
	}
	
	/**
	 * @return true if the functionSignature changed and triggerered revisitation
	 */
	private boolean chooseNameIfMissing(FunctionSignature functionSignature) {
		Function function = functionSignature.getFunction();
		if (function != null && function.getName() == null) {// || parent instanceof VariablesDeclaration) {
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
		switch (nameGenerationStyle) {
			case Java:
				return StringUtils.capitalize(ownerNames, "");
			case PreserveCaseAndSeparateByUnderscores:
				return StringUtils.implode(names, "_");
			default:
				throw new UnsupportedOperationException("Unknown name generation style " + nameGenerationStyle);
		}
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