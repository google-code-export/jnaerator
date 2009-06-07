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
package com.ochafik.lang.jnaerator.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import com.ochafik.lang.jnaerator.parser.Expression.FunctionCall;
import com.ochafik.util.string.StringUtils;

public class Function extends Declaration implements Declarator.MutableByDeclarator {
	//private Struct owner;

	final List<Arg> args = new ArrayList<Arg>();
	final List<FunctionCall> initializers = new ArrayList<FunctionCall>();
	Statement.Block body;
	Type type;

	Identifier name;
	
	public void setName(Identifier name) {
		this.name = changeValue(this, this.name, name);
	}
	public Identifier getName() {
		return name;
	}
	public enum Type {
		CFunction, ObjCMethod, CppMethod, JavaMethod
	}

	public void setInitializers(List<FunctionCall> initializers) {
		changeValue(this, this.initializers, initializers);
	}
	public void addInitializer(FunctionCall i) {
		if (i == null)
			return;
		
		i.setParentElement(this);
		initializers.add(i);
	}
	public List<FunctionCall> getInitializers() {
		return unmodifiableList(initializers);
	}
	String asmName;
	public void setAsmName(String asmName) {
		this.asmName = asmName;
	}
	public String getAsmName() {
		return asmName;
	}
	@Override
	public Element getNextChild(Element child) {
		Element e = super.getNextChild(child);
		if (e != null)
			return e;
		e = getNextSibling(initializers, child);
		if (e != null)
			return e;
		return getNextSibling(args, child);
	}
	
	@Override
	public Function clone() {
		return (Function) super.clone();
	}
	
	@Override
	public Element getPreviousChild(Element child) {
		Element e = super.getPreviousChild(child);
		if (e != null)
			return e;
		e = getPreviousSibling(initializers, child);
		if (e != null)
			return e;
		return getPreviousSibling(args, child);
	}

	@Override
	public boolean replaceChild(Element child, Element by) {
		if (child == getBody()) {
			setBody((Statement.Block)by);
			return true;
		}
		if (child == getName()) {
			setName((Identifier)by);
			return true;
		}
		if (replaceChild(args, Arg.class, this, child, by))
			return true;
		
		if (replaceChild(initializers, FunctionCall.class, this, child, by))
			return true;
		
		return super.replaceChild(child, by);
	}
	
	
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Arg addArg(Arg a) {
		if (a != null) {
			args.add(a);
			a.setParentElement(this);
		}
		return a;
	}
	public List<Arg> getArgs() {
		return unmodifiableList(args);
	}
	public void setArgs(List<Arg> args) {
		changeValue(this, this.args, args);
	}
	
	public Function setBody(Statement.Block body) {
		this.body = changeValue(this, this.body, body);
		return this;
	}

	//public static class CFunction extends Function {
	public Function() {}

	public Function(Type type, Identifier name, TypeRef returnType) {
		setType(type);
		setName(name);
		setValueType(returnType);
	}
	public Function(Type type, Identifier name, TypeRef returnType, Arg... args) {
		this(type, name, returnType, Arrays.asList(args));
	}
		
	public Function(Type type, Identifier name, TypeRef returnType, List<Arg> args) {
		setType(type);
		setName(name);
		setValueType(returnType);
		setArgs(args);
	}


	@Override
	public Function addModifiers(Modifier... mds) {
		return (Function) super.addModifiers(mds);
	}
	@Override
	public String toString(CharSequence indent) {
		String s = "";
		TypeRef valueType = getValueType();
		Identifier name = getName();
		List<Modifier> modifiers = getModifiers();
		
		if (type == null)
			return "<no function type>";
		
		String pre = formatComments(indent, false, true, true);
		String post = (asmName == null ? "" : "__asm(\"" + asmName + "\") ") +
			(initializers.isEmpty() ? "" : " : " + implode(initializers, ", ", indent)) +
			(commentAfter == null ? "" : " " + commentAfter);//" /*" + commentAfter + " */";
		
		if (!getAnnotations().isEmpty())
			pre += StringUtils.implode(getAnnotations(), "\n" + indent) + "\n" + indent;
		
		switch (type) {
		case CFunction:
		case CppMethod:
		case JavaMethod:
			String preMods = StringUtils.implode(modifiers, " ") + (modifiers.isEmpty() ? "" : " ");
			s = preMods + 
				(valueType == null ? "" : valueType + " ") +
				name + "(" +
				StringUtils.implode(args, ", ") +
				")";

			return pre + s + (body == null ? ";" : " " + body.toString(indent)) + post;
		case ObjCMethod:
			s = modifiers.contains(Modifier.Static) ? "+" : "-";
			StringBuilder argsStr = new StringBuilder();
			for (Arg arg : args) {
				if (arg.isVarArg()) {
					if (argsStr.length() > 0)
						argsStr.append(", ");
					argsStr.append("...");
				} else {
					if (argsStr.length() > 0)
					{
						argsStr.append(' ');
						argsStr.append(arg.getSelector());
					}
					argsStr.append(":(");
					argsStr.append(arg.createMutatedType());
					argsStr.append(')');
					argsStr.append(arg.getName());
				}
			}
			return pre + s + " " + "(" + getValueType() + ")" + name + argsStr + ";" + post;
		default:
			throw new NoSuchElementException(type.toString());
		}
	}

	public void accept(Visitor visitor) {
		visitor.visitFunction(this);
	}
	public Statement.Block getBody() {
		return body;
	}

	public String computeSignature(boolean addReturnType) {
		StringBuilder b = new StringBuilder();
		if (addReturnType && getValueType() != null) {
			TypeRef t = getValueType().clone();
			t.stripDetails();
			b.append(t);
			b.append(' ');
		}
		b.append(getName());
		boolean first = true;
		b.append('(');
		for (Arg arg : getArgs()) {
			if (first) {
				first = false;
			} else 
				b.append(", ");
			TypeRef t = arg.createMutatedType();
			if (t != null)
				t.stripDetails();
			b.append(t);
		}
		b.append(')');
		return b.toString();
	}


}
