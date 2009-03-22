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
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import gnu.trove.TIntHashSet;
import gnu.trove.TIntObjectHashMap;
import gnu.trove.TIntObjectProcedure;
import gnu.trove.TIntProcedure;

import com.ochafik.lang.jnaerator.parser.Define;
import com.ochafik.lang.jnaerator.parser.Element;
import com.ochafik.lang.jnaerator.parser.Enum;
import com.ochafik.lang.jnaerator.parser.Function;
import com.ochafik.lang.jnaerator.parser.Scanner;
import com.ochafik.lang.jnaerator.parser.SourceFile;
import com.ochafik.lang.jnaerator.parser.Struct;
import com.ochafik.util.listenable.Filter;

public class UnusedScanner extends Scanner {
	public final ResolutionScanner resolutions;
	public final Filter<Element> usageRootnessPredicate;
	public final TIntHashSet usageRootIds = new TIntHashSet();
	public final List<Element> usageRootElements = new ArrayList<Element>();
	public final TIntObjectHashMap<Element> allElements = new TIntObjectHashMap<Element>();
	public final PrintStream verboseOut;
	
	public UnusedScanner(ResolutionScanner resolutions, Filter<Element> usageRootnessPredicate, PrintStream verboseOut) {
		this.resolutions = resolutions;
		this.usageRootnessPredicate = usageRootnessPredicate;
		this.verboseOut = verboseOut;
	}

	@Override
	protected void visitElement(Element d) {
		super.visitElement(d);
		allElements.put(d.getId(), d);
		if (usageRootnessPredicate.accept(d)) {
			usageRootIds.add(d.getId());
			usageRootElements.add(d);
		}
	}
	
	
	void propagateUsage(Element localRoot,//int localRootId, 
			final TIntHashSet usedIds) {
		if (!usedIds.add(localRoot.getId()))
			return;
		
		//Element localRoot = allElements.get(localRootId);
//		if (verboseOut != null)
//			verboseOut.println("  Used: " + String.valueOf(localRoot).replace('\n', ' '));
		
		localRoot.accept(new Scanner() {
			@Override
			protected void visitElement(Element d) {
				super.visitElement(d);
				
				Element linked = resolutions.resolutions.get(d.getId());
				if (linked != null)
					propagateUsage(linked, usedIds);
				else {
					if (resolutions.unresolvedIds.contains(d.getId())) {
						if (verboseOut != null)
							verboseOut.println("Unresolved: " + String.valueOf(d).replace('\n', ' '));
					}
				}
			}
		});
		
	}
	public void removeUnused(final Filter<Element> elementSaviour) {
		final TIntHashSet usedIds = new TIntHashSet(allElements.size());
		for (Element d : usageRootElements)
			propagateUsage(d, usedIds);
//		usageRootIds.forEach(new TIntProcedure() { 
//			public boolean execute(int id) {
//				propagateUsage(id, usedIds);
//				return true;
//			}		
//		});
		
		final TIntHashSet implicitelyUsedIds = new TIntHashSet(usedIds);
		usedIds.forEach(new TIntProcedure() { 
			public boolean execute(int id) {
				implicitelyUsedIds.add(id);
				
				Element element = allElements.get(id);
				Element e = element;
				while (e != null) {
					if (e instanceof Enum || 
							e instanceof Struct || 
							e instanceof Function || 
							e instanceof Define ||
							e instanceof SourceFile) 
					{
						e.accept(new Scanner() {
							@Override
							protected void visitElement(Element d) {
								super.visitElement(d);
								implicitelyUsedIds.add(d.getId());
							}
						});
					}
					if (implicitelyUsedIds.contains(e.getId()))
						return true;
					e = e.getParentElement();
				}
				return true;
			}
		});
		final TIntHashSet removedIds = new TIntHashSet(allElements.size());
		
		/// Build list of unused elements as allElements.keySet() - usedIds
		allElements.forEachEntry(new TIntObjectProcedure<Element>() {
			public boolean execute(int id, Element element) {
				/*Element e = element;
				while (e != null) {
					if (implicitelyUsedIds.contains(e.getId()))
						return true;
					e = e.getParentElement();
				}*/
				if (implicitelyUsedIds.contains(id))
					return true;
				
				if (elementSaviour == null || !elementSaviour.accept(element)) {
					if (verboseOut != null) {
						String s = String.valueOf(element);
						if (s != null)
							verboseOut.println("Unused: " + s.replace('\n', ' '));
					}
					element.replaceBy(null);
					removedIds.add(id);
				}
				return true;
			}
		});
		
		removedIds.forEach(new TIntProcedure() {
			public boolean execute(int id) {
				allElements.remove(id);
				return true;
			}		
		});
	}
}
