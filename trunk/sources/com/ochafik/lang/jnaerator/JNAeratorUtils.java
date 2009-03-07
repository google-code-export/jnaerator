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
import java.util.Arrays;
import java.util.List;

import com.ochafik.lang.jnaerator.parser.Arg;
import com.ochafik.lang.jnaerator.parser.Declaration;
import com.ochafik.lang.jnaerator.parser.DeclarationsHolder;
import com.ochafik.lang.jnaerator.parser.Declarator;
import com.ochafik.lang.jnaerator.parser.Element;
import com.ochafik.lang.jnaerator.parser.Expression;
import com.ochafik.lang.jnaerator.parser.Function;
import com.ochafik.lang.jnaerator.parser.StoredDeclarations;
import com.ochafik.lang.jnaerator.parser.Declarator.DirectDeclarator;

public class JNAeratorUtils {
	static List<String> guessOwnerName(Element e) {
		Element parent = e.getParentElement();
		if (parent == null)
			return null;
		
//		StoredDeclarations td = as(parent, StoredDeclarations.class);
//		String bestName = JNAeratorUtils.findBestPlainStorageName(td);
//		if (bestName != null)
//			return Arrays.asList(bestName);
		
		List<String> ns = new ArrayList<String>();
		
		while (parent != null && !(parent instanceof DeclarationsHolder)) {
			if (parent instanceof Arg) {
				Arg arg = (Arg)parent;
				ns.add(arg.getName());
			} else if (parent instanceof Function) {
				Function f = (Function)parent;
				if (f.getName() != null)
					ns.add(0, f.getName());
				return ns;
			} else if (parent instanceof StoredDeclarations) {
				StoredDeclarations sd = (StoredDeclarations)parent;
				String bestName = findBestPlainStorageName(sd);
				if (bestName != null) {
					ns.add(0, bestName);
				}
			} else if (parent instanceof Expression) {
				if (!ns.contains("expression"))
					ns.add("expression");
			} else if (parent instanceof Declaration) {
				Declaration d = (Declaration)parent;
				if (d.getName() != null) {
					ns.add(0, d.getName());
					//return ns;
				}
			}
			parent = parent.getParentElement();
		}
		return ns;
		/*
		
		Arg arg = e.findParentOfType(Arg.class);
		if (arg != null) {
			Function f = as(arg.getParentElement(), Function.class);
			if (f != null && f.getName() != null)
				return Arrays.asList(f.getName(), arg.getName());
			else
				return Arrays.asList(arg.getName());
		} 
		
		StoredDeclarations sd = e.findParentOfType(StoredDeclarations.class);
		String bestName = findBestPlainStorageName(sd);
		if (bestName != null)
				return Arrays.asList(bestName);
		
		return null;*/
	}
	
	public static String findBestPlainStorageName(StoredDeclarations sd) {
		if (sd == null)
			return null;
		
		Declarator bestPlainStorage = null;
		for (Declarator st : sd.getDeclarators()) {
			if (st instanceof DirectDeclarator) {
				boolean niceName = !((DirectDeclarator)st).getName().startsWith("_");
				if (bestPlainStorage == null || niceName) {
					bestPlainStorage = st;
					if (niceName)
						break;
				}
			}
			// TODO play with other names ("pointed_by", "returned_by"...)
		}
		return bestPlainStorage != null ? bestPlainStorage.resolveName() : null;
	}
}
