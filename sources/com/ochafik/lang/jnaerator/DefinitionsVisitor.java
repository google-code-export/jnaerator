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

import gnu.trove.TIntObjectHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.ochafik.lang.jnaerator.parser.Arg;
import com.ochafik.lang.jnaerator.parser.Declarator;
import com.ochafik.lang.jnaerator.parser.Define;
import com.ochafik.lang.jnaerator.parser.Element;
import com.ochafik.lang.jnaerator.parser.Enum;
import com.ochafik.lang.jnaerator.parser.Function;
import com.ochafik.lang.jnaerator.parser.Scanner;
import com.ochafik.lang.jnaerator.parser.Struct;
import com.ochafik.lang.jnaerator.parser.VariablesDeclaration;
import com.ochafik.lang.jnaerator.parser.Enum.EnumItem;
import com.ochafik.lang.jnaerator.parser.StoredDeclarations.TypeDef;
import com.ochafik.math.graph.BinaryEdgeSet;
import com.ochafik.math.graph.impl.FastSparseBinaryEdgeSet;
import com.ochafik.util.SortedIntArray;
public class DefinitionsVisitor extends Scanner {
	BinaryEdgeSet elementsToChildren = new FastSparseBinaryEdgeSet(true);
	TIntObjectHashMap<Element> elementsById = new TIntObjectHashMap<Element>();
	//Map<Integer, Element> elementsById = new HashMap<Integer, Element>();
	TIntObjectHashMap<Environment> environmentById = new TIntObjectHashMap<Environment>();
	//Map<Integer, Environment> environmentById = new HashMap<Integer, Environment>();
	
	public static class Environment {
		Environment parent;
		public enum Space {
			Structs, Enums, Types, Variables, Constants, Functions
		}
		public Environment(Environment parent) {
			super();
			this.parent = parent;
		}
		Map<Space, Map<String, Element>> elementsBySpace = new TreeMap<Space, Map<String, Element>>();
		//Map<String, Element> elements = new HashMap<String, Element>();
		public Element get(String name, Space namespace) {
			Map<String, Element> elements = elementsBySpace == null ? null : elementsBySpace.get(namespace);
			if (elements == null)
				return parent == null ? null : parent.get(name, namespace);
			
			Element element = elements.get(name);
			if (element == null && parent != null)
				element = parent.get(name, namespace);
			return element;
		}
		public Element get(String name, Space... namespaces) {
			for (Environment.Space s : namespaces) {
				Element element = get(name, s);
				if (element != null)
					return element;
			}
			return null;
		}
		
		public void set(String name, Element element, Space namespace) {
			if (elementsBySpace == null)
				elementsBySpace = new TreeMap<Space, Map<String, Element>>();
			Map<String, Element> elements = elementsBySpace.get(namespace);
			if (elements == null)
				elements = new HashMap<String, Element>();
			
			elements.put(name, element);
		}
	}
	
	protected static boolean deservesItsOwnEnvironment(Element element) {
		return 
			element instanceof Struct ||
			element instanceof SourceFiles ||
			element instanceof Function;
	}
	public Environment getEnvironment(Element element) {
		if (element == null)
			return null;
		
		int id = element.getId();
		Environment env = environmentById.get(id);
		if (env == null) {
			Environment parentEnv = element.getParentElement() == null ? null : getEnvironment(element.getParentElement());
			if (deservesItsOwnEnvironment(element) || parentEnv == null)
				env = new Environment(parentEnv);
			else
				env = parentEnv;
			environmentById.put(id, env);
		}
		return env;
	}
	public Element resolveElement(Element context, String name, Set<String> namespacePrefixesUsedAndImported, Environment.Space... namespaces) {
		for (Environment.Space s : namespaces) {
			Element element = resolveElement(context, name, namespacePrefixesUsedAndImported, s);
			if (element != null)
				return element;
		}
		return null;
	}
	public Element resolveElement(Element context, String name, Set<String> namespacePrefixesUsedAndImported, Environment.Space namespace) {
		Environment env = getEnvironment(context);
		Element e = env.get(name, namespace);
		if (e != null)
			return e;
		
		if (namespacePrefixesUsedAndImported != null)
			for (String prefix : namespacePrefixesUsedAndImported) {
				e = env.get(prefix + name, namespace);
				if (e != null)
					return e;
			}
		return null;
	}
	
	@Override
	public void visitArg(Arg arg) {
		Environment env = getEnvironment(arg.getParentElement());
		if (env != null && arg.getName() != null)
			env.set(arg.getName(), arg, Environment.Space.Variables);
		
		super.visitArg(arg);
	}
	@Override
	public void visitDefine(Define define) {
		Environment env = getEnvironment(define.getParentElement());
		if (env != null && define.getName() != null)
			env.set(define.getName(), define, Environment.Space.Constants);
		
		super.visitDefine(define);
	}
	
	@Override
	public void visitFunction(Function function) {
		Environment env = getEnvironment(function.getParentElement());
		if (env != null && function.getName() != null)
			env.set(function.getName().toString(), function, Environment.Space.Functions);
		
		super.visitFunction(function);
	}
	
	@Override
	public void visitTypeDef(TypeDef d) {
		Environment env = getEnvironment(d.getParentElement());
		if (env != null)
			for (Declarator sto : d.getDeclarators())
				env.set(sto.resolveName(), sto, Environment.Space.Types);
		
		super.visitTypeDef(d);
	}
	@Override
	public void visitVariablesDeclaration(VariablesDeclaration d) {
		Environment env = getEnvironment(d.getParentElement());
		if (env != null)
			for (Declarator sto : d.getDeclarators())
				env.set(sto.resolveName(), sto, Environment.Space.Variables);
		
		super.visitVariablesDeclaration(d);
	}
	
	@Override
	public void visitEnum(Enum e) {
		Environment env = getEnvironment(e.getParentElement());
		if (env != null) {
			if (e.getTag() != null)
				env.set(e.getTag().toString(), e, Environment.Space.Enums);
		
			for (EnumItem ei : e.getItems())
				env.set(ei.getName(), ei, Environment.Space.Constants);
		}
		
		super.visitEnum(e);
	}
	
	@Override
	protected void visitElement(Element element) {
		if (element != null) {
			Element parent = element.getParentElement();
			if (parent != null) {
				elementsToChildren.set(parent.getId(), element.getId());
			}
			elementsById.put(element.getId(), element);
		}
		super.visitElement(element);
	}
	
	public List<Element> getDirectChildren(Element e) {
		SortedIntArray childrenIds = elementsToChildren.getEnds(e.getId());
		List<Element> children = new ArrayList<Element>(childrenIds.size());
		for (int id : childrenIds) {
			children.add(elementsById.get(id));
		}
		return children;
	}
}
