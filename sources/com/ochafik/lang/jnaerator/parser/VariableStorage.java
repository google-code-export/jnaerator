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

import java.util.ArrayList;
import java.util.List;

import com.ochafik.util.string.StringUtils;


public class VariableStorage extends Element {
	protected String name;
	protected final List<StorageModifier> storageModifiers = new ArrayList<StorageModifier>();
	protected final List<Expression> dimensions = new ArrayList<Expression>();
	protected Expression defaultValue;
	
	public enum StorageModifier
	{
		Pointer, Reference, DotNetPointer, Const
	}

	public VariableStorage() {}
	public VariableStorage(String name) {
		setName(name);
	}
	public VariableStorage(String name, Expression defaultValue) {
		setName(name);
		setDefaultValue(defaultValue);
	}
	public TypeRef mutateType(TypeRef type) {
		if (type == null)
			return null;
		
		type = type.clone();
		for (StorageModifier m : getStorageModifiers()) {
			if (m == StorageModifier.Const)
				continue;
			type = new TypeRef.Pointer(type, m);
		}
		if (!dimensions.isEmpty()) {
			TypeRef.ArrayRef array = new TypeRef.ArrayRef(type);
			array.setDimensions(deepClone(dimensions));
			type = array;
		}
		
		return type;
	}
		
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setDefaultValue(Expression defaultValue) {
		this.defaultValue = changeValue(this, this.defaultValue, defaultValue);
	}
	public Expression getDefaultValue() {
		return defaultValue;
	}
	public List<Expression> getDimensions() {
		return unmodifiableList(dimensions);
	}
	public void setDimensions(List<Expression> dimensions) {
		changeValue(this, this.dimensions, dimensions);
	}
	public List<StorageModifier> getStorageModifiers() {
		return unmodifiableList(storageModifiers);
	}
	public void setStorageModifiers(List<StorageModifier> storageModifiers) {
		this.storageModifiers.clear();
		if (storageModifiers != null)
			this.storageModifiers.addAll(storageModifiers);
	}
	public void addStorageModifier(StorageModifier m) {
		storageModifiers.add(m);
	}
	public void addDimension(Expression ex) {
		if (ex == null)
			return;
		dimensions.add(ex);
		ex.setParentElement(this);
	}
	
		public static String toString(StorageModifier storageModifier) {
		if (storageModifier != null) {
			switch (storageModifier) {
			case DotNetPointer:
				return "^";
			case Pointer:
				return "*";
			case Reference:
				return "&";
			case Const:
				return "const ";
			}
		} 
		return null;
	}
	
	@Override
	public String toString(CharSequence indent) {
		StringBuilder b = new StringBuilder();
		for (StorageModifier m : getStorageModifiers())
			b.append(toString(m));
		if (getName() != null)
			b.append(getName());
		if (!getDimensions().isEmpty())
			b.append("[" + StringUtils.implode(getDimensions(), "][") + "]");
		if (getDefaultValue() != null)
			b.append(" = " + getDefaultValue());
		return b.toString();
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visitVariableStorage(this);
	}


	@Override
	public Element getNextChild(Element child) {
		return getNextSibling(dimensions, child);
	}
	
	@Override
	public Element getPreviousChild(Element child) {
		return getPreviousSibling(dimensions, child);
	}
	
	@Override
	public boolean replaceChild(Element child, Element by) {
		if (child == getDefaultValue()) {
			setDefaultValue((Expression) by);
			return true;
		}
			
		return replaceChild(dimensions, Expression.class, this, child, by);
	}

	public boolean isPlainStorage() {
		return getDimensions().isEmpty() && getName() != null && getStorageModifiers().isEmpty();
	}
}
