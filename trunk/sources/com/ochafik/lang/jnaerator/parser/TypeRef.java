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
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ochafik.lang.jnaerator.parser.Expression.EmptyArraySize;
import com.ochafik.lang.jnaerator.parser.Modifier.Kind;
import com.ochafik.util.string.StringUtils;

public abstract class TypeRef extends ModifiableElement implements Declarator.MutableByDeclarator {
	
	public static abstract class TaggedTypeRef extends TypeRef {
		String tag;
		public String getTag() {
			return tag;
		}
		public void setTag(String tag) {
			this.tag = tag;
		}
		
		public boolean isForwardDeclaration() {
			return forwardDeclaration;
		}
		public void setForwardDeclaration(boolean forwardDeclaration) {
			this.forwardDeclaration = forwardDeclaration;
		}
		
		boolean forwardDeclaration = false;
		
		@Override
		public void accept(Visitor visitor) {
			visitor.visitTaggedTypeRef(this);
		}
	}
	//protected final List<String> modifiers = new ArrayList<String>();
	
	@Override
	public TypeRef clone() {
		return (TypeRef) super.clone();
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
		return false;
	}
	
	public static class SimpleTypeRef extends TypeRef {
		protected String name;

		public SimpleTypeRef(String name) {
			this();
			setName(name);
		}
		public SimpleTypeRef() {
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		@Override
		public String toString(CharSequence indent) {
			return formatComments(indent, true, false, false) + getModifiersStringPrefix() + name;
		}
		
		@Override
		public void accept(Visitor visitor) {
			visitor.visitSimpleTypeRef(this);
		}
		
		
	}

	public String variableDeclarationToString(String varName, boolean isVarArg) {
		return toString() + (isVarArg ? "... " : " ") + varName;
	}
	public boolean acceptsModifier(Modifier modifier) {
		return modifier.isAnyOf(Kind.NumericTypeQualifier, Kind.TypeQualifier);
	}
	/*
	public TypeRef addModifier(String modifier) {
		if (modifier != null)
			modifiers.add(modifier);
		return this;
	}
	public void addModifier(String modifier, int i) {
		if (modifier != null)
			modifiers.add(i, modifier);
	}*/
	
	public String getModifiersStringPrefix() {
		return StringUtils.implode(modifiers, " ") + (modifiers.isEmpty() ? "" : " ");
	}
	public static class FunctionSignature extends TypeRef {
		protected Function function;
		
		public FunctionSignature(Function function) {
			this();
			setFunction(function);
		}

		@Override
		public FunctionSignature clone() {
			return (FunctionSignature) super.clone();
		}
		
		public FunctionSignature() {
		}

		public Function getFunction() {
			return function;
		}
		public void setFunction(Function function) {
			this.function = changeValue(this, this.function, function);
		}
		
		@Override
		public String toString(CharSequence indent) {
			if (function == null)
				return null;
			
			assert function.getBody() == null;
			String s = 
				(function.getValueType() == null ? "" : function.getValueType() + " ") +
				"(" + function.getModifiersStringPrefix() + "*" + (function.getName() == null ? "" : function.getName()) + ")(" +
				StringUtils.implode(function.getArgs(), ", ") +
				")" + (getModifiers().isEmpty() ? "" : " ") + StringUtils.implode(getModifiers(), " ");
			
			return getModifiersStringPrefix() + s;
		}

		@Override
		public void accept(Visitor visitor) {
			visitor.visitFunctionSignature(this);
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
			if (getFunction() == child) {
				setFunction((Function) by);
				return true;
			}
			return false;
		}
	}
	
	public static class Primitive extends TypeRef {
		protected String name;
		
		static Set<String> cPrimitiveTypes = new HashSet<String>();
		static {
			cPrimitiveTypes.add("long");
			cPrimitiveTypes.add("int");
			cPrimitiveTypes.add("short");
			cPrimitiveTypes.add("char");
			cPrimitiveTypes.add("void");
			cPrimitiveTypes.add("double");
			cPrimitiveTypes.add("float");
			cPrimitiveTypes.add("size_t");
			cPrimitiveTypes.add("__int8");
			cPrimitiveTypes.add("__int16");
			cPrimitiveTypes.add("__int32");
			cPrimitiveTypes.add("__int64");
			cPrimitiveTypes.add("__uint8");
			cPrimitiveTypes.add("__uint16");
			cPrimitiveTypes.add("__uint32");
			cPrimitiveTypes.add("__uint64");
			
		}
		
		public static boolean isACPrimitive(String s) {
			return cPrimitiveTypes.contains(s);
		}
		public Primitive(String name) {//, String... modifiers) {
			//this();
			setName(name);
//			for (String modifier : modifiers)
//				addModifier(modifier);
		}

		public Primitive() {
		}
		
		@Override
		public Primitive addModifiers(Modifier... mds) {
			return (Primitive)super.addModifiers(mds);
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString(CharSequence indent) {
			return getModifiersStringPrefix() + name;
		}

		@Override
		public void accept(Visitor visitor) {
			visitor.visitPrimitive(this);
		}
	}
	
	/*public static class StructTypeRef extends TypeRef {
		protected Struct struct;
		
		public StructTypeRef(Struct struct) {
			this();
			setStruct(struct);
		}
		public StructTypeRef() {
		}
		public Struct getStruct() {
			return struct;
		}
		public void setStruct(Struct struct) {
			this.struct = changeValue(this, this.struct, struct);
		}
		@Override
		public boolean replaceChild(Element child, Element by) {
			if (child == getStruct()) {
				setStruct((Struct) by);
				return true;
			}
			return super.replaceChild(child, by);
		}
		@Override
		public String toString(CharSequence indent) {
			return getStruct() == null ? null : getStruct().toCoreString("");
		}
		@Override
		public void accept(Visitor visitor) {
			visitor.visitStructTypeRef(this);
		}
	}*/
	/*public static class EnumTypeRef extends TypeRef {
		protected Enum enumeration;
		
		
		public EnumTypeRef(Enum enumeration) {
			this();
			setEnumeration(enumeration);
		}
		public EnumTypeRef() {}
		
		public void setEnumeration(Enum enumeration) {
			this.enumeration = changeValue(this, this.enumeration, enumeration);
		}
		public Enum getEnumeration() {
			return enumeration;
		}
		@Override
		public boolean replaceChild(Element child, Element by) {
			if (child == getEnumeration()) {
				setEnumeration((Enum) by);
				return true;
			}
			return super.replaceChild(child, by);
		}
		@Override
		public String toString(CharSequence indent) {
			return getEnumeration() == null ? null : getEnumeration().toCoreString("");
		}
		@Override
		public void accept(Visitor visitor) {
			visitor.visitEnumTypeRef(this);
		}
	}*/
	public static class SubTypeRef extends TargettedTypeRef {
		public enum Style { 
			Dot { public String toString() { return "."; } }, 
			Colons { public String toString() { return "::"; } } 
		}
		public SubTypeRef() {}
		public SubTypeRef(TypeRef target, Style style, String subName) {
			setTarget(target);
			setStyle(style);
			setSubName(subName);
		}

		Style style;
		String subName;
		
		public void setStyle(Style style) {
			this.style = style;
		}
		public Style getStyle() {
			return style;
		}
		public String getSubName() {
			return subName;
		}
		public void setSubName(String subName) {
			this.subName = subName;
		}
		
		@Override
		public String toString(CharSequence indent) {
			return getTarget().toString(indent) + getStyle() + getSubName();
		}
		@Override
		public void accept(Visitor visitor) {
			visitor.visitSubTypeRef(this);
		}
	}
	public static class Pointer extends TargettedTypeRef {
		Declarator.PointerStyle pointerStyle;
		
		public Pointer(TypeRef target, Declarator.PointerStyle pointerStyle) {
			this();
			setTarget(target);
			setPointerStyle(pointerStyle);
		}
		public Pointer() {
		}
		public void setPointerStyle(Declarator.PointerStyle pointerStyle) {
			this.pointerStyle = pointerStyle;
		}
		public Declarator.PointerStyle getPointerStyle() {
			return pointerStyle;
		}
		@Override
		public String toString(CharSequence indent) {
			String s = getModifiersStringPrefix();
			//return getTarget() + (s.length() == 0 ? "" : " " + s.trim()) + VariableStorage.toString(getPointerStyle());
			return s + getTarget() + getPointerStyle();
		}
		@Override
		public void accept(Visitor visitor) {
			visitor.visitPointer(this);
		}
	}
	
	public static class TemplateRef extends SimpleTypeRef {
		protected final List<TypeRef> parameters = new ArrayList<TypeRef>();
		public TemplateRef(String name) {
			this();
			setName(name);
		}
		public TemplateRef() {
		}
		public List<TypeRef> getParameters() {
			return unmodifiableList(parameters);
		}
		public void setParameters(List<TypeRef> parameters) {
			changeValue(this, this.parameters, parameters);
		}
		
		@Override
		public Element getNextChild(Element child) {
			return getNextSibling(parameters, child);
		}

		@Override
		public Element getPreviousChild(Element child) {
			return getPreviousSibling(parameters, child);
		}

		@Override
		public boolean replaceChild(Element child, Element by) {
			if (super.replaceChild(child, by))
				return true;
			
			return replaceChild(parameters, TypeRef.class, this, child, by);
		}
		
		public void addParameter(TypeRef type) {
			if (type == null)
				return;
				
			parameters.add(type);
			type.setParentElement(this);
		}
		@Override
		public String toString(CharSequence indent) {
			String s = super.toString(indent) + "<" + StringUtils.implode(parameters, ", ");
			return s + (s.endsWith(">") ? " >" : ">");
		}
	}
	
	public static abstract class TargettedTypeRef extends TypeRef {
		protected TypeRef target;
		public TypeRef getTarget() {
			return target;
		}
		public void setTarget(TypeRef target) {
			this.target = changeValue(this, this.target, target);
		}
		
		@Override
		public boolean replaceChild(Element child, Element by) {
			if (getTarget() == child) {
				setTarget((TypeRef) by);
				return true;
			}
			return false;
		}

			
	}
	public static class ArrayRef extends TargettedTypeRef {
		final List<Expression> dimensions = new ArrayList<Expression>();
		
		public ArrayRef(TypeRef target, Expression... dimensions) {
			this(target, Arrays.asList(dimensions));
		}
		public ArrayRef(TypeRef target, List<Expression> dimensions) {
			this();
			setDimensions(dimensions);
			setTarget(target);
		}
		
		public boolean hasStaticStorageSize() {
			if (dimensions.isEmpty())
				return false;
			
			Expression x = dimensions.get(dimensions.size() - 1);
			return x != null && !(x instanceof EmptyArraySize);
		}
		
		public ArrayRef() {
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
			if (super.replaceChild(child, by))
				return true;
			
			return replaceChild(dimensions, Expression.class, this, child, by);
		}
		
		public List<Expression> getDimensions() {
			return unmodifiableList(dimensions);
		}
		public void setDimensions(List<Expression> dimensions) {
			changeValue(this, this.dimensions, dimensions);
		}
		public String bracketsToString() {
			return "[" + StringUtils.implode(dimensions, "][") + "]";
		}
		@Override
		public String toString(CharSequence indent) {
			return getModifiersStringPrefix() + getTarget() + bracketsToString();
		}
	
		@Override
		public String variableDeclarationToString(String varName, boolean isVarArg) {
			return getTarget() + (isVarArg ? "... " : " ") + varName + bracketsToString();
		}
		@Override
		public void accept(Visitor visitor) {
			visitor.visitArray(this);
		}
	}

	

}
