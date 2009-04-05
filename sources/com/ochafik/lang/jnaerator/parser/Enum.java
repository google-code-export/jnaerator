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
import java.util.List;

import com.ochafik.lang.jnaerator.parser.TypeRef.TaggedTypeRef;
import com.ochafik.util.string.StringUtils;

public class Enum extends TaggedTypeRef {
	public static class EnumItem extends Element {
		String name;
		Expression value;
		
		public EnumItem() {
			super();
		}
		public EnumItem(String name, Expression value) {
			setName(name);
			setValue(value);
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public Expression getValue() {
			return value;
		}
		public void setValue(Expression value) {
			this.value = changeValue(this, this.value, value);
		}
		
		@Override
		public String toString(CharSequence indent) {
			return
				formatComments(indent, false, true, true) +
				getName() + 
				(getValue() == null ? "" : " = " + getValue()) + (getCommentAfter() == null ? "" : " " + getCommentAfter());
		}
		@Override
		public void accept(Visitor visitor) {
			visitor.visitEnumItem(this);
		}

		@Override
		public Element getNextChild(Element child) {
			return null;
		}

		@Override
		public Element getPreviousChild(Element child) {
			return null;
		}

		@Override
		public boolean replaceChild(Element child, Element by) {
			if (child == getValue()) {
				setValue((Expression) by);
				return true;
			}	
			return false;
		}
		
	}
	final List<EnumItem> items = new ArrayList<EnumItem>();
	//private LinkedHashMap<String, Expression> values = new LinkedHashMap<String, Expression>();
	//Integer lastValue = 0;
	
	public void addItem(EnumItem item) {
		if (item == null)
			return;
		
		item.setParentElement(this);
		items.add(item);
	}

	public void accept(Visitor visitor) {
		visitor.visitEnum(this);
	}
	
	public List<EnumItem> getItems() {
		return unmodifiableList(items);
	}
	public void setItems(List<EnumItem> items) {
		changeValue(this, this.items, items);
	}
	@Override
	public Element getNextChild(Element child) {
		Element e = super.getNextChild(child);
		if (e != null)
			return e;
		e = getNextSibling(items, child);
		if (e != null)
			return e;
		return super.getNextChild(child);
	}

	@Override
	public Element getPreviousChild(Element child) {
		Element e = super.getPreviousChild(child);
		if (e != null)
			return e;
		e = getPreviousSibling(items, child);
		if (e != null)
			return e;
		return super.getPreviousChild(child);
	}

	@Override
	public boolean replaceChild(Element child, Element by) {
		if (super.replaceChild(child, by))
			return true;
		
		if (replaceChild(items, EnumItem.class, this, child, by))
			return true;
		
		return super.replaceChild(child, by);
	}


	@Override
	public String toString(CharSequence indent) {
		String indentt = "\n" + indent + "\t";
		return 
			"enum " +
			(getTag() != null ? getTag() + " " : "")+ 
			"{" + 
			indentt + StringUtils.implode(items, indentt) + "\n" + indent + "}";
	}

}
