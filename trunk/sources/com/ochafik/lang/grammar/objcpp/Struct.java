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
package com.ochafik.lang.grammar.objcpp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.ochafik.util.string.StringUtils;

public class Struct extends StoredDeclarations {
	boolean forwardDeclaration = false;
	Type type;
	MemberVisibility nextMemberVisibility = MemberVisibility.Public;
	final List<String> parents = new ArrayList<String>();
	final List<String> protocols = new ArrayList<String>();
	String categoryName;
	final List<Declaration> declarations = new ArrayList<Declaration>();
	
	public enum MemberVisibility {
		Public, Private, Protected
	}
	public enum Type {
		CStruct, CPPClass, ObjCClass, ObjCProtocol, CUnion, JavaClass, JavaInterface
	}

	@Override
	public Element getNextChild(Element child) {
		Element e = super.getNextChild(child);
		if (e != null)
			return e;
		return getNextSibling(declarations, child);
	}

	@Override
	public Element getPreviousChild(Element child) {
		Element e = super.getPreviousChild(child);
		if (e != null)
			return e;
		return getPreviousSibling(declarations, child);
	}

	@Override
	public boolean replaceChild(Element child, Element by) {
		if (super.replaceChild(child, by))
			return true;

		return replaceChild(declarations, Declaration.class, this, child, by);
	}

	
	public static Struct forwardDecl(String name, Type type) {
		Struct s = new Struct();
		s.setForwardDeclaration(true);
		s.setName(name);
		s.setType(type);
		return s;
	}
	
	public boolean isForwardDeclaration() {
		return forwardDeclaration;
	}
	public void setForwardDeclaration(boolean forwardDeclaration) {
		this.forwardDeclaration = forwardDeclaration;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	
	public List<String> getParents() {
		return unmodifiableList(parents);
	}
	public void addParent(String parent) {
		this.parents.add(parent);
	}
	public void setParents(List<String> parents) {
		this.parents.clear();
		this.parents.addAll(parents);
	}
	public List<String> getProtocols() {
		return unmodifiableList(protocols);
	}
	public void addProtocol(String protocol) {
		this.protocols.add(protocol);
	}
	public void setProtocols(List<String> parents) {
		this.protocols.clear();
		this.protocols.addAll(parents);
	}
	public void setType(Type type) {
		this.type = type;
		switch (type) {
		case ObjCClass:
		case ObjCProtocol:
			break;
		case CPPClass:
			setNextMemberVisibility(MemberVisibility.Private);
			break;
		case CStruct:
		case JavaClass:
		case JavaInterface:
			setNextMemberVisibility(MemberVisibility.Public);
			break;
		default:
			break;
		}
	}
	public Type getType() {
		return type;
	}
	public List<Declaration> getDeclarations() {
		return unmodifiableList(declarations);
	}
	public void addDeclaration(Declaration d) {
		if (d == null)
			return;
		
		d.setVisibility(getNextMemberVisibility());
		d.setParentElement(this);
		declarations.add(d);
	}
	public void addDeclarations(Collection<? extends Declaration> ds) {
		if (ds == null)
			return;
		
		for (Declaration d : ds)
			addDeclaration(d);
	}
	public void setDeclarations(List<Declaration> declarations) {
		changeValue(this, this.declarations, declarations);
	}
	
	public void setNextMemberVisibility(MemberVisibility nextVisibility) {
		this.nextMemberVisibility = nextVisibility;
	}
	public MemberVisibility getNextMemberVisibility() {
		return nextMemberVisibility;
	}
	
	public String toCoreString(CharSequence indent) {
		
		String lnind = "\n" + indent + "\t";
		String body = isForwardDeclaration() ? "" :
			" {" +
			(declarations.isEmpty() ? 
				"" :
				lnind + implode(declarations, "\n" + lnind, indent + "\t") + "\n" + indent  
			) + "}"
		;
		String pre = commentBefore == null ? "" : 
			formatComments(indent, false) + "\n" + indent;
			//commentBefore + "\n" + indent;//(indent, mergeCommentsBeforeAndAfter);
		
		String nameStr = (getName() == null ? "" : " " + getName());
		String javaPublicity = getModifiers().contains(Modifier.Public) ? "public " :
			getModifiers().contains(Modifier.Protected) ? "protected " :
			"";
		
		switch (getType()) {
			case CPPClass:
				return pre + "class" + nameStr + body;
			case CUnion:
				return pre + "union" + nameStr + body;
			case JavaClass:
				return pre + javaPublicity + "class" + nameStr + body;
			case JavaInterface:
				return pre + javaPublicity + "interface" + nameStr + body;
			case ObjCClass:
				return pre + "@class" + nameStr + body;
			case ObjCProtocol:
				return pre + "@protocol" + nameStr + body; // TODO check this ???
			case CStruct:
			default:
				return pre + "struct" + nameStr + body;
		}
		
	}
	@Override
	public String toString(CharSequence indent) {
		String coreStr = toCoreString(indent);
		String varststr = StringUtils.implode(variableStorages, ", ");
		return 
			coreStr + 
			(varststr.length() == 0 ? "" : " " + varststr) + 
		";" + (commentAfter == null ? "" : " " + commentAfter.trim());
	}
	public void accept(Visitor visitor) {
		visitor.visitStruct(this);
	}
}
