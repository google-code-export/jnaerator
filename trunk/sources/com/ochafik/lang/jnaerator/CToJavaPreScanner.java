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

import java.util.Arrays;

import com.ochafik.lang.grammar.objcpp.Element;
import com.ochafik.lang.grammar.objcpp.Scanner;
import com.ochafik.lang.grammar.objcpp.TypeRef;
import com.ochafik.lang.grammar.objcpp.VariableStorage;
import com.ochafik.lang.grammar.objcpp.VariablesDeclaration;
import com.ochafik.lang.grammar.objcpp.StoredDeclarations.TypeDef;

public class CToJavaPreScanner extends Scanner {
	@Override
	public void visitVariablesDeclaration(VariablesDeclaration v) {
		TypeRef valueType = v.getValueType();
		
		Element toAddAfter = v;
		
		/// Explode comma-separated variables declarations
		for (VariableStorage vs : v.getVariableStorages()) {
			TypeRef type = vs.mutateType(valueType);
			
			VariablesDeclaration decl = new VariablesDeclaration();
			decl.setCommentAfter(v.getCommentAfter());
			decl.setCommentBefore(v.getCommentBefore());
			decl.setValueType(type);
			
			vs.setDimensions(null);
			vs.setStorageModifiers(null);
			decl.setVariableStorages(Arrays.asList(vs));
			
			toAddAfter.insertSibling(decl, false);
			toAddAfter = decl;

			super.visitVariablesDeclaration(decl);
		}
		v.replaceBy(null);
	}
	
}
