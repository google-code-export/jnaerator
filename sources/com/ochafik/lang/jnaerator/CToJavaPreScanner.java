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

import com.ochafik.lang.jnaerator.parser.Declaration;
import com.ochafik.lang.jnaerator.parser.Element;
import com.ochafik.lang.jnaerator.parser.Scanner;
import com.ochafik.lang.jnaerator.parser.TypeRef;
import com.ochafik.lang.jnaerator.parser.Declarator;
import com.ochafik.lang.jnaerator.parser.VariablesDeclaration;
import com.ochafik.lang.jnaerator.parser.Declarator.DirectDeclarator;

public class CToJavaPreScanner extends Scanner {
	public CToJavaPreScanner() {
	}
	@Override
	public void visitVariablesDeclaration(VariablesDeclaration v) {
		TypeRef valueType = v.getValueType();
		
		Element toAddAfter = v;
		
		/// Explode comma-separated variables declarations
		for (Declarator vs : v.getDeclarators()) {
			if (vs instanceof DirectDeclarator)
				continue;
			
			Declaration decl = null;
		
			Element type = vs.mutateType(valueType);
			if (type instanceof TypeRef) {
				
				decl = new VariablesDeclaration((TypeRef)type, Arrays.asList(vs));
				decl.importDetails(v);
				//TODO vs.setDimensions(null);
				//TODO vs.setStorageModifiers(null);
			} else if (type instanceof Declaration) {
				decl = (Declaration)type;
			} else {
				continue;
			}
			
			toAddAfter.insertSibling(decl, false);
			toAddAfter = decl;

			decl.accept(this);//super.visitVariablesDeclaration(decl);
		}
		if (toAddAfter != v)
			v.replaceBy(null);
	}
	
}
