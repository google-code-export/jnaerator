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

import java.io.PrintStream;

import gnu.trove.TIntHashSet;
import gnu.trove.TIntObjectHashMap;

import com.ochafik.lang.jnaerator.parser.Element;
import com.ochafik.lang.jnaerator.parser.Scanner;
import com.ochafik.lang.jnaerator.parser.Expression.FieldRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.SimpleTypeRef;
import com.ochafik.lang.jnaerator.DefinitionsVisitor.Environment;

public class ResolutionScanner extends Scanner {
	public final TIntObjectHashMap<Element> resolutions = new TIntObjectHashMap<Element>();
	public final TIntHashSet unresolvedIds = new TIntHashSet();
	public final DefinitionsVisitor definitions;
	PrintStream verboseOut;
	
	public ResolutionScanner(DefinitionsVisitor definitions, PrintStream verboseOut) {
		this.definitions = definitions;
		this.verboseOut = verboseOut;
	}

	@Override
	public void visitFieldRef(FieldRef element) {
		super.visitFieldRef(element);
		Environment env = definitions.getEnvironment(element);
		if (element.getTarget() == null) {
			Element resolved = env.get(element.getName());
			if (resolved != null)
				resolutions.put(element.getId(), resolved);
			else
				unresolvedIds.add(element.getId());
		} else {
			if (verboseOut != null)
				verboseOut.println("Skipped Resolution: " + element);
		}
	}

	@Override
	public void visitSimpleTypeRef(SimpleTypeRef element) {
		super.visitSimpleTypeRef(element);
		Environment env = definitions.getEnvironment(element);
		String name = element.getName();
		if (TypeConversion.resolvesToPrimitive(name))
			return;
		
		Element resolved = env == null ? null : env.get(element.getName());
		if (resolved != null)
			resolutions.put(element.getId(), resolved);
		else {
			unresolvedIds.add(element.getId());
			if (verboseOut != null)
				verboseOut.println("Unresolved: " + element);
		}
	}
}
