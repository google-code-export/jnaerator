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
package com.ochafik.lang.jnaerator.parser;

public class Arg extends Declaration {
	String selector;
	boolean varArg;
	Expression defaultValue;

	public Arg(String name, TypeRef type) {
		this();
		setName(name);
		setValueType(type);
	}
	
	public Arg() {
	}
	
	@Override
	public Arg clone() {
		return (Arg)super.clone();
	}

	public Expression getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(Expression defaultValue) {
		this.defaultValue = changeValue(this, this.defaultValue, defaultValue);
	}
	
	public static Arg createVarArgs() {
		Arg a = new Arg(null, null);
		a.varArg = true;
		return a;
	}
	
	public String getSelector() {
		return selector;
	}

	public void setSelector(String selector) {
		this.selector = selector;
	}
	
	@Override
	public boolean replaceChild(Element child, Element by) {
		if (child == getDefaultValue()) {
			setDefaultValue((Expression) by);
			return true;
		}
		return super.replaceChild(child, by);
	}
	
	@Override
	public String toString(CharSequence indent) {
		//if (isVarArg())
		//	return "...";
		///else 
		if (getValueType() == null)
			return null;
		else if (getValueType() != null) {
			if (getName() != null)
				return getValueType().variableDeclarationToString(getName(), isVarArg());
			else
				return getValueType().toString() + (isVarArg() ? "..." : "");
		} else
			return "...";
	}

	public void accept(Visitor visitor) {
		visitor.visitArg(this);
	}

	public boolean isVarArg() {
		return varArg;
	}
	public void setVarArg(boolean v) {
		varArg = v;
	}
}
