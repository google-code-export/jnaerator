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

import com.ochafik.lang.jnaerator.parser.TypeRef.FunctionSignature;
import com.ochafik.util.string.StringUtils;

public abstract class StoredDeclarations extends Declaration {
	final List<VariableStorage> variableStorages = new ArrayList<VariableStorage>();

	public static class TypeDef extends StoredDeclarations {

		@Override
		public void accept(Visitor visitor) {
			visitor.visitTypeDef(this);
		}
		
		@Override
		public String toString(CharSequence indent) {
			return formatComments(indent, false) + getModifiersStringPrefix() +
				"typedef " + getValueTypeAndStorageSuffix();
		}
	}
	
	protected String getValueTypeAndStorageSuffix() {
		if (getValueType() instanceof FunctionSignature) {
			FunctionSignature sig = (FunctionSignature) getValueType();
			if (sig.getFunction() != null) {
				String name = sig.getFunction().getName();
				if (name != null && variableStorages.size() == 1) {
					String stoName = variableStorages.get(0).getName();
					if (name.equals(stoName) || stoName == null)
						return sig.toString() + ";";
				}
			}
		}
		String stoStr = StringUtils.implode(variableStorages, ", ").trim();
		return 
			getValueType() + 
			(stoStr.length() == 0 ? "" : " " + stoStr) + 
		";" + (commentAfter == null ? "" : " " + commentAfter.trim());
	}
	@Override
	public String toString(CharSequence indent) {
		return (commentBefore == null || commentBefore.length() == 0 ? "" : formatComments(indent, false) + "\n" + indent) +
			getModifiersStringPrefix() + getValueTypeAndStorageSuffix() +
			(commentAfter == null ? "" : " " + commentAfter.trim());
	}
	
	public List<VariableStorage> getVariableStorages() {
		return unmodifiableList(variableStorages);
	}
	
	public void setVariableStorages(List<VariableStorage> variableStorages) {
		changeValue(this, this.variableStorages, variableStorages);
	}
	
	public void addVariableStorage(VariableStorage variableStorage) {
		if (variableStorage == null)
			return;
		variableStorages.add(variableStorage);
		variableStorage.setParentElement(this);
	}
	@Override
	public Element getNextChild(Element child) {
		Element e = super.getNextChild(child);
		if (e != null)
			return e;
		return getNextSibling(variableStorages, child);
	}

	@Override
	public Element getPreviousChild(Element child) {
		Element e = super.getPreviousChild(child);
		if (e != null)
			return e;
		return getPreviousSibling(variableStorages, child);
	}
	
	
	@Override
	public boolean replaceChild(Element child, Element by) {
		if (super.replaceChild(child, by))
			return true;
		
		return replaceChild(variableStorages, VariableStorage.class, this, child, by);
	}
}
