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

import com.ochafik.lang.jnaerator.parser.Element;
import com.ochafik.lang.jnaerator.parser.Enum;
import com.ochafik.lang.jnaerator.parser.Identifier;
import com.ochafik.lang.jnaerator.parser.Scanner;
import com.ochafik.lang.jnaerator.parser.TypeRef;
import com.ochafik.lang.jnaerator.parser.Declarator;
import com.ochafik.lang.jnaerator.parser.StoredDeclarations.TypeDef;

import static com.ochafik.lang.jnaerator.parser.ElementsHelper.*;

/**
 * <ul>
 * <li>Cocoa enums usually don't have names, but they are followed by a typedef that maps an enum-like name to integer. This scanner removes this fake typedef and imports back the name of the enum.
 * </li>
 * </ul> 
 * @author ochafik
 */
public class ObjectiveCToJavaPreScanner extends Scanner {
//	@Override
//	public void visitStruct(Struct struct) {
//		if (struct.isForwardDeclaration())
//			struct.replaceBy(null);
//		else
//			super.visitStruct(struct);
//	}
	@Override
	public void visitEnum(Enum e) {
		if (e.getTag() == null) {
			// Hack to infer the enum name from the next typedef NSUInteger NSSomethingThatLooksLikeTheEnumsIdentifiers
			Element nextDeclaration = e.getNextSibling();
			if (nextDeclaration != null && (nextDeclaration instanceof TypeDef)) {
				TypeDef typeDef = (TypeDef) nextDeclaration;
				TypeRef type = typeDef.getValueType();
				if (type instanceof TypeRef.SimpleTypeRef) {
					Identifier simpleType = ((TypeRef.SimpleTypeRef)type).getName();
					if (simpleType.equals("NSUInteger") || 
							simpleType.equals("NSInteger") ||
							simpleType.equals("CFIndex")) 
					{
						Declarator bestPlainStorage = null;
						for (Declarator st : typeDef.getDeclarators()) {
							if (st instanceof Declarator.DirectDeclarator) {
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
							e.setTag(ident(name));
							bestPlainStorage.replaceBy(null);
							if (typeDef.getDeclarators().isEmpty())
								typeDef.replaceBy(null);
						}
					}
				}
			}
		}
		String comment = e.getCommentBefore();
		if (comment != null) {
			// TODO parse cocoa comments here
		}
		super.visitEnum(e);
	}
}
