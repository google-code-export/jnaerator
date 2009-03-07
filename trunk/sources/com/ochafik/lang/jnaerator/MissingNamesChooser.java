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
import com.ochafik.lang.jnaerator.parser.Struct;
import com.ochafik.lang.jnaerator.parser.TaggedTypeRefDeclaration;
import com.ochafik.lang.jnaerator.parser.TypeRef;
import com.ochafik.lang.jnaerator.parser.VariablesDeclaration;
import com.ochafik.lang.jnaerator.parser.Declarator.DirectDeclarator;
import com.ochafik.lang.jnaerator.parser.StoredDeclarations.TypeDef;
import com.ochafik.lang.jnaerator.parser.TypeRef.FunctionSignature;
import com.ochafik.lang.jnaerator.parser.TypeRef.TaggedTypeRef;
import com.ochafik.util.string.StringUtils;

public class MissingNamesChooser extends Scanner {
	int iNextStruct = 1, iNextUnion = 1, iNextCallback = 1;

	@Override
	public void visitFunctionSignature(FunctionSignature functionSignature) {
		super.visitFunctionSignature(functionSignature);

		//Struct s = structTypeRef.getStruct();
		DeclarationsHolder holder = functionSignature.findParentOfType(DeclarationsHolder.class);
		Function f = functionSignature.getFunction();
		if (holder != null && f != null && f.getName() != null) {
			//if (s.getName() != null) {
			/*VariablesDeclaration pd = as(functionSignature.getParentElement(), VariablesDeclaration.class);
				if (pd != null && pd.getVariableStorages().isEmpty())
					pd.replaceBy(null); // special case of C++-like struct sub-type definition 
				else
					structTypeRef.replaceBy(new TypeRef.SimpleTypeRef(s.getName()));
			 */
			functionSignature.replaceBy(new TypeRef.SimpleTypeRef(f.getName()));
			TypeDef td = new TypeDef();
			td.setValueType(functionSignature);
			td.addDeclarator(new DirectDeclarator(f.getName()));
			holder.addDeclaration(td);

		}

		/*
			String name = functionSignature.getFunction().getName();
			//if (name !)
			String ownerName = guessOwnerName(functionSignature);
			Element e = functionSignature.getParentElement();
			while (e != null) {
				if (e instanceof Declaration) {
					break;
				}
				e = e.getParentElement();
//				if (e instanceof Struct || 
//						((e instanceof Function) && !(e.getParentElement() instanceof FunctionSignature)) ||
//					e instanceof VariablesDeclaration	
			}

			if (e != null) {
				if (functionSignature.getParentElement() instanceof VariablesDeclaration) {
					VariablesDeclaration d = (VariablesDeclaration)functionSignature.getParentElement();
					d.getVariableStorages().get(0).setName(name);
				}

				TypeDef separateTypeDef = new TypeDef();
				FunctionSignature sigCopy = functionSignature.clone();
				separateTypeDef.setValueType(sigCopy);
				String chosenName = ownerName == null ? "Callback" + (iNextCallback++) : StringUtils.capitalize(ownerName) + "Callback";
				// TODO ensure this name is unique

				sigCopy.getFunction().setName(chosenName);
					separateTypeDef.setVariableStorages(Arrays.asList(new VariableStorage(chosenName)));
				e.insertSibling(separateTypeDef, true);

				SimpleTypeRef typeRef = new SimpleTypeRef(chosenName);
				functionSignature.replaceBy(typeRef);
//				separateTypeDef.accept(definitions);
				super.visitFunctionSignature(functionSignature);
			}*/
		//
	}
	@Override
	public void visitFunction(Function function) {
		super.visitFunction(function);
		FunctionSignature signature = as(function.getParentElement(), FunctionSignature.class);
		if (signature != null) {
			if (function.getName() == null) {
				TypeDef td = as(function.getParentElement(), TypeDef.class);
				String bestName = JNAeratorUtils.findBestPlainStorageName(td);
				if (bestName != null)
					function.setName(bestName);
			}

			Element parent = signature.getParentElement();
			if (function.getName() == null || parent instanceof VariablesDeclaration) {
				List<String> ownerNames = JNAeratorUtils.guessOwnerName(function);

				List<String> names = new ArrayList<String>();
				if (ownerNames != null)
					names.addAll(ownerNames);

				names.add("callback");
				function.setName(StringUtils.implode(names, "_"));
				//ownerName = StringUtils.capitalize(ownerNames, "_");

			}
		}

	}

	// TODO rewrite this :
	/*
		@Override
		public void visitStructTypeRef(StructTypeRef structTypeRef) {
			// TODO Auto-generated method stub
			super.visitStructTypeRef(structTypeRef);

			Struct s = structTypeRef.getStruct();
			DeclarationsHolder holder = structTypeRef.findParentOfType(DeclarationsHolder.class);
			if (holder != null && s != null) {
				//if (s.getName() != null) {
				holder.addDeclaration(s);
				VariablesDeclaration pd = as(structTypeRef.getParentElement(), VariablesDeclaration.class);
				if (pd != null && pd.getDeclarators().isEmpty())
					pd.replaceBy(null); // special case of C++-like struct sub-type definition 
				else
					structTypeRef.replaceBy(new TypeRef.SimpleTypeRef(s.getName()));
			}
		}*/
	@Override
	public void visitTaggedTypeRef(TaggedTypeRef taggedTypeRef) {
		super.visitTaggedTypeRef(taggedTypeRef);

		boolean changed = false;
		if (taggedTypeRef.getTag() == null) {
			// TODO needs much better lookup, handles very little cases : 
			Arg sr = as(taggedTypeRef.getParentElement(), Arg.class);
			if (sr != null) {
				TypeDef td = as(sr.getParentElement(), TypeDef.class);
				String bestName = JNAeratorUtils.findBestPlainStorageName(td);
				if (bestName != null)
					taggedTypeRef.setTag(bestName);
			}
		}
		if (taggedTypeRef.getTag() == null) {
			List<String> ownerNames = JNAeratorUtils.guessOwnerName(taggedTypeRef);//.getParentElement() instanceof StructTypeRef ? struct.getParentElement() : struct);
			List<String> names = new ArrayList<String>();
			if (ownerNames != null)
				names.addAll(ownerNames);

			if (taggedTypeRef instanceof Struct) {
				Struct struct = (Struct)taggedTypeRef;
				if (struct.getType() == Struct.Type.CStruct) {
					names.add("struct");
					//struct.setName(ownerName == null ? "Struct" + (iNextStruct++) : ownerName + "Struct");
					changed = true;
				} else if (struct.getType() == Struct.Type.CUnion) {
					names.add("union");
					//struct.setName(ownerName == null ? "Union" + (iNextUnion++) : ownerName + "Union");
					changed = true;
				}
			} else if (taggedTypeRef instanceof Enum) {
				names.add("enum");
				//struct.setName(ownerName == null ? "Enum" + (iNextEnum++) : ownerName + "Enum");
				changed = true;
			}

			if (changed)
				taggedTypeRef.setTag(StringUtils.implode(names, "_"));

			//ownerName = StringUtils.capitalize(ownerNames, "_");

		}

		if (changed)
			taggedTypeRef.accept(this);//super.visitStruct(struct);
		//			if (changed)
		//				struct.accept(definitions);

		if (!(taggedTypeRef.getParentElement() instanceof TaggedTypeRefDeclaration)) {
			DeclarationsHolder holder = taggedTypeRef.findParentOfType(DeclarationsHolder.class);
			if (holder != null && holder != taggedTypeRef.getParentElement()) {
				//if (s.getName() != null) {
				if (taggedTypeRef instanceof Enum)
					taggedTypeRef.replaceBy(new TypeRef.SimpleTypeRef("int"));//taggedTypeRef.getTag()));
				else
					taggedTypeRef.replaceBy(new TypeRef.SimpleTypeRef(taggedTypeRef.getTag()));
				holder.addDeclaration(new TaggedTypeRefDeclaration(taggedTypeRef));
				//VariablesDeclaration pd = as(taggedTypeRef.getParentElement(), VariablesDeclaration.class);
				//if (pd != null && pd.getDeclarators().isEmpty())
				//	pd.replaceBy(null); // special case of C++-like struct sub-type definition 

			}
		}
	}
	
	
}