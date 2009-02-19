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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ochafik.util.listenable.Adapter;
import com.ochafik.util.listenable.ListenableCollections;
import com.ochafik.util.listenable.Pair;
import com.ochafik.util.string.StringUtils;

public abstract class Expression extends Element {
	
	boolean parenthesis;
	public void setParenthesis(boolean parenthesis) {
		this.parenthesis = parenthesis;
	}
	public boolean getParenthesis() {
		return parenthesis;
	}
	
	@Override
	public Expression clone() {
		return (Expression)super.clone();
	}
	
	public enum MemberRefStyle {
		Dot, SquareBrackets, Arrow, Colons
	}
	
	public static MemberRefStyle parseMemberRefStyle(String s) {
		if (s.equals("->"))
			return MemberRefStyle.Arrow;
		if (s.equals("."))
			return MemberRefStyle.Dot;
		if (s.equals("::"))
			return MemberRefStyle.Colons;
		return null;
	}
	
	public static class TypeRefExpression extends Expression {
		TypeRef type;
		
		public TypeRefExpression(TypeRef type) {
			this();
			setType(type);
		}
		public TypeRefExpression() {}
		
		public TypeRef getType() {
			return type;
		}
		public void setType(TypeRef type) {
			this.type = changeValue(this, this.type, type);
		}
		@Override
		public void accept(Visitor visitor) {
			visitor.visitTypeRefExpression(this);
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
			if (child == getType()) {
				setType((TypeRef) by);
				return true;
			}
			return false;
		}
		@Override
		public String toString(CharSequence indent) {
			return getType() == null ? "" : getType().toString();
		}
	}

	public static class EmptyArraySize extends Expression {

		@Override
		public void accept(Visitor visitor) {
			visitor.visitEmptyArraySize(this);
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
		@Override
		public String toString(CharSequence indent) {
			return "";
		}
	}
	
	public static abstract class MemberRef extends Expression {
		MemberRefStyle memberRefStyle;
		Expression target;
		
		public MemberRef() {
			
		}
		public void setTarget(Expression target) {
			this.target = changeValue(this, this.target, target);
		}
		public Expression getTarget() {
			return target;
		}
		
		public void setMemberRefStyle(MemberRefStyle memberRefStyle) {
			this.memberRefStyle = memberRefStyle;
		}
		public MemberRefStyle getMemberRefStyle() {
			return memberRefStyle;
		}
		
		@Override
		public boolean replaceChild(Element child, Element by) {
			if (child == getTarget())
				setTarget((Expression)by);
			return false;
		}
		
		protected String getTargetPrefix() {
			if (getTarget() == null || getMemberRefStyle() == null)
				return null;
			
			StringBuilder b = new StringBuilder();
			String sep;
			switch (getMemberRefStyle()) {
			case Arrow:
				sep = "->";
				break;
			case Dot:
				sep = ".";
				break;
			case Colons:
				sep = "::";
				break;
			default:
				assert false;
				sep = null;
			}
			if (sep != null) {
				b.append(getTarget());
				b.append(sep);
			}
			return b.toString();
		}
		
	}
	public static class NewArray extends Expression {
		TypeRef type;
		List<Expression> dimensions = new ArrayList<Expression>();
		
		public NewArray() {}
		
		public NewArray(TypeRef type, Expression... dimensions) {
			setType(type);
			setDimensions(Arrays.asList(dimensions));
		}
		public List<Expression> getDimensions() {
			return unmodifiableList(dimensions);
		}
		public void setDimensions(List<Expression> dimensions) {
			changeValue(this, this.dimensions, dimensions);
		}
		public TypeRef getType() {
			return type;
		}
		public void setType(TypeRef type) {
			this.type = changeValue(this, this.type, type);
		}
		@Override
		public void accept(Visitor visitor) {
			visitor.visitNewArray(this);
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
			if (child == getType()) {
				setType((TypeRef)by);
				return true;
			}
			return replaceChild(dimensions, Expression.class, this, child, by);
		}

		@Override
		public String toString(CharSequence indent) {
			return "new " + getType() + "[" + implode(getDimensions(), "][", indent) + "]";
		}

	}

	public static class New extends Expression {
		TypeRef type;
		FunctionCall construction;
		public New(TypeRef type) {
			super();
			setType(type);
		}
		public New() {
			super();
		}
		public void setType(TypeRef type) {
			this.type = changeValue(this, this.type, type);
		}
		public TypeRef getType() {
			return type;
		}
		public void setConstruction(FunctionCall construction) {
			this.construction = changeValue(this, this.construction, construction);
		}
		public FunctionCall getConstruction() {
			return construction;
		}
		@Override
		public String toString(CharSequence indent) {
			return "new " + (type == null ? "" : type) + (construction == null ? "()" : construction.toString());
		}
		@Override
		public void accept(Visitor visitor) {
			visitor.visitNew(this);
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
			if (child == getType()) {
				setType((TypeRef) by);
				return true;
			}
			if (child == getConstruction()) {
				setConstruction((FunctionCall) by);
				return true;
			}
			return false;
		}
	}
	public static class FunctionCall extends MemberRef {
		String functionName;
		List<Pair<String, Expression>> arguments = new ArrayList<Pair<String, Expression>>(); 
		
		public List<Pair<String, Expression>> getArguments() {
			return unmodifiableList(arguments);
		}
		public void setArguments(List<Pair<String, Expression>> arguments) {
			for (Pair<String, Expression> p : this.arguments)
				p.getSecond().setParentElement(null);
			this.arguments.clear();
			for (Pair<String, Expression> p : arguments)
				addArgument(p.getFirst(), p.getSecond());
		}

		public FunctionCall(String functionName) {
			this();
			setFunctionName(functionName);
		}
		
		public FunctionCall(Expression target, String functionName, MemberRefStyle memberRefStyle) {
			this();
			setTarget(target);
			setFunctionName(functionName);
			setMemberRefStyle(memberRefStyle);
		}
		
		public FunctionCall() {
		}

		public void addArgument(Expression ex) {
			addArgument(null, ex);
		}
		public void addArgument(String argumentSelector, Expression ex) {
			if (ex == null)
				return;
			
			ex.setParentElement(this);
			arguments.add(new Pair<String, Expression>(argumentSelector, ex));
		}
		
		public String getFunctionName() {
			return functionName;
		}
		public void setFunctionName(String functionName) {
			this.functionName = functionName;
		}

		@Override
		public void accept(Visitor visitor) {
			visitor.visitFunctionCall(this);
		}

		protected int indexOf(Element x, List<Pair<String, Expression>> list) {
			int i = 0;
			for (Pair<String, Expression> p : list) {
				if (p.getValue() == x)
					return i;
				i++;
			}
			return -1;
		}
		
		@Override
		public Element getNextChild(Element child) {
			int i = indexOf(child, arguments);
			if (i >= 0) {
				return i < arguments.size() - 1 ? arguments.get(i + 1).getValue() : null;
			}
			return null;
		}

		@Override
		public Element getPreviousChild(Element child) {
			int i = indexOf(child, arguments);
			if (i >= 0) {
				return i > 0 ? arguments.get(i - 1).getValue() : null;
			}
			return null;
		}

		@Override
		public boolean replaceChild(Element child, Element by) {
			if (child == getTarget()) {
				setTarget((Expression) by);
				return true;
			}
			
			//return replaceChild(arguments, Expression.class, this, child, by);
			int i = indexOf(child, arguments);
			if (i >= 0) {
				Expression old;
				if (by == null)
					old = arguments.remove(i).getValue();
				else
					old = arguments.get(i).setValue((Expression)by);

				if (old != by) {
					if (old != null)
						old.setParentElement(null);
					
					if (by != null)
						by.setParentElement(this);
				}
				return true;
			}
			
			return false;
		}
		
		@Override
		public String toString(CharSequence indent) {
			StringBuilder b = new StringBuilder();
			if (getMemberRefStyle() == MemberRefStyle.SquareBrackets) {
				/// Objective-C method call
				b.append('[');
				b.append(getTarget());
				if (getFunctionName() != null) {
					b.append(' ');
					b.append(getFunctionName());
				}
				List<Pair<String, Expression>> args = getArguments();
				for (int i = 0, len = args.size(); i < len; i++) {
					Pair<String, Expression> arg = args.get(i);
					if (i > 0) {
						b.append(' ');
						b.append(arg.getFirst());
					}
					b.append(':');
					b.append(arg.getSecond());
				}
				b.append(']');
			} else {
				String pref = getTargetPrefix();
				if (pref != null)
					b.append(pref);
				b.append(getFunctionName() + "(" + StringUtils.implode(ListenableCollections.adapt(arguments, new Adapter<Pair<String, Expression>, Expression>() {
	
					public Expression adapt(Pair<String, Expression> value) {
						return value.getValue();
					} 
					
				}), ", ") + ")");
			}
			return b.toString();
		}
	}
	
	public static class FieldRef extends MemberRef {
		String name;
		
		public FieldRef(String name) {
			this();
			setName(name);
		}
		public FieldRef(Expression target, String name, MemberRefStyle memberRefStyle) {
			this();
			setTarget(target);
			setName(name);
			setMemberRefStyle(memberRefStyle);
		}

		public FieldRef() {
		}

		public void setName(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}

		@Override
		public void accept(Visitor visitor) {
			visitor.visitFieldRef(this);
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
		public String toString(CharSequence indent) {
			String pref = getTargetPrefix();
			return (pref == null ? "" : pref) + getName();
		}
	}
	public static class VariableRef extends Expression {
		String name;
		
		
		public VariableRef(String name) {
			this();
			this.name = name;
		}
		
		public VariableRef() {
		}

		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}

		@Override
		public void accept(Visitor visitor) {
			visitor.visitVariableRef(this);
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

		@Override
		public String toString(CharSequence indent) {
			return 
				(getParenthesis() ? "(" : "") + 
				getName() + 
				(getParenthesis() ? ")" : "");
		}
	}

	public enum BinaryOperator {
		Plus, Minus, Divide, Multiply, Modulo, LeftShift, RightShift, SignedRightShift, XOR, 
		LessEqual, GreaterEqual, Less, Greater, IsEqual, IsDifferent, BitOr, Or, BitAnd, And
	};
	public enum UnaryOperator {
		Not, Complement
	};
	
	private static final Map<String, BinaryOperator> binOps = new HashMap<String, BinaryOperator>();
	private static final Map<String, UnaryOperator> unOps = new HashMap<String, UnaryOperator>();
	private static final Map<BinaryOperator, String> binOpsRev = new HashMap<BinaryOperator, String>();
	private static final Map<UnaryOperator, String> unOpsRev = new HashMap<UnaryOperator, String>();
	public static final Expression EMPTY_EXPRESSION = new Constant(null, null, "");
	static {
		map(unOps, unOpsRev, "!", UnaryOperator.Not);
		map(unOps, unOpsRev, "~", UnaryOperator.Complement);

		map(binOps, binOpsRev,"+", BinaryOperator.Plus            );
		map(binOps, binOpsRev,"-", BinaryOperator.Minus           );
		map(binOps, binOpsRev,"/", BinaryOperator.Divide          );
		map(binOps, binOpsRev,"*", BinaryOperator.Multiply        );
		map(binOps, binOpsRev,"%", BinaryOperator.Modulo          );
		map(binOps, binOpsRev,"|", BinaryOperator.BitOr           );
		map(binOps, binOpsRev,"||", BinaryOperator.Or             );
		map(binOps, binOpsRev,"&", BinaryOperator.BitAnd          );
		map(binOps, binOpsRev,"&&", BinaryOperator.And            );
		map(binOps, binOpsRev,"<<", BinaryOperator.LeftShift       );
		map(binOps, binOpsRev,">>", BinaryOperator.RightShift      );
		map(binOps, binOpsRev,">>>", BinaryOperator.SignedRightShift);
		map(binOps, binOpsRev,"^", BinaryOperator.XOR             );
		map(binOps, binOpsRev,"<=", BinaryOperator.LessEqual       );
		map(binOps, binOpsRev,">=", BinaryOperator.GreaterEqual    );
		map(binOps, binOpsRev,"<", BinaryOperator.Less            );
		map(binOps, binOpsRev,">", BinaryOperator.Greater         );
		map(binOps, binOpsRev,"==", BinaryOperator.IsEqual         );
		map(binOps, binOpsRev,"!=", BinaryOperator.IsDifferent     );
	}
	static <K, V> void map(Map<K, V> m, Map<V, K> r, K k, V v) {
		m.put(k, v);
		r.put(v, k);
	}
	public static BinaryOperator getBinaryOperator(String s) {
		return binOps.get(s);
	}
	
	public static UnaryOperator getUnaryOperator(String s) {
		return unOps.get(s);
	}
	
	public static class Cast extends Expression {
		TypeRef type;
		Expression target;
		
		public Cast(TypeRef type, Expression target) {
			this();
			setTarget(target);
			setType(type);
		}
		
		public Cast() {
		}

		public void setTarget(Expression target) {
			this.target = changeValue(this, this.target, target);
		}
		public void setType(TypeRef type) {
			this.type = changeValue(this, this.type, type);
		}
		public Expression getTarget() {
			return target;
		}
		public TypeRef getType() {
			return type;
		}
		@Override
		public void accept(Visitor visitor) {
			visitor.visitCast(this);
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
			if (child == getTarget()) {
				setTarget((Expression)by);
				return true;
			}
			if (child == getType()) {
				setType((TypeRef)by);
				return true;
			}
			return false;
		}
		
		@Override
		public String toString(CharSequence indent) {
			return "(" + type + ")" + target;
		}
	}
	public static class Assignment extends Expression {
		Expression target, value;
		
		public Assignment() {
		}
		public Assignment(Expression target, Expression value) {
			this();
			setValue(value);
			setTarget(target);
		}

		public Expression getValue() {
			return value;
		}
		public Expression getTarget() {
			return target;
		}
		public void setValue(Expression value) {
			this.value = changeValue(this, this.value, value);
		}
		public void setTarget(Expression target) {
			this.target = changeValue(this, this.target, target);
		}
		
		@Override
		public void accept(Visitor visitor) {
			visitor.visitAssignment(this);
		}

		@Override
		public Element getNextChild(Element child) {
			if (child == getTarget())
				return getValue();

			return null;
		}

		@Override
		public Element getPreviousChild(Element child) {
			if (child == getValue())
				return getTarget();

			return null;
		}

		@Override
		public boolean replaceChild(Element child, Element by) {
			if (child == getTarget()) {
				setTarget((Expression) by);
				return true;
			}
			if (child == getValue()) {
				setValue((Expression) by);
				return true;
			}
			return false;
		}

		@Override
		public String toString(CharSequence indent) {
			return getTarget() + " = " + getValue();
		}
	}
	
	public static class BinaryOp extends Expression {
		BinaryOperator operator;
		Expression firstOperand, secondOperand;
		
		public BinaryOp(BinaryOperator operator, Expression firstOperand,
				Expression secondOperand) {
			this();
			if (operator == null)
				throw new NullPointerException();
			
			setOperator(operator);
			setFirstOperand(firstOperand);
			setSecondOperand(secondOperand);
		}

		public BinaryOp() {
		}
		public void setOperator(BinaryOperator operator) {
			this.operator = operator;
		}
		public Expression getSecondOperand() {
			return secondOperand;
		}
		public Expression getFirstOperand() {
			return firstOperand;
		}
		public void setSecondOperand(Expression secondOperand) {
			this.secondOperand = changeValue(this, this.secondOperand, secondOperand);
		}
		public void setFirstOperand(Expression firstOperand) {
			this.firstOperand = changeValue(this, this.firstOperand, firstOperand);
		}
		
		public BinaryOperator getOperator() {
			return operator;
		}
		
		@Override
		public void accept(Visitor visitor) {
			visitor.visitBinaryOp(this);
		}

		@Override
		public Element getNextChild(Element child) {
			if (child == getFirstOperand())
				return getSecondOperand();

			return null;
		}

		@Override
		public Element getPreviousChild(Element child) {
			if (child == getSecondOperand())
				return getFirstOperand();

			return null;
		}

		@Override
		public boolean replaceChild(Element child, Element by) {
			if (child == getFirstOperand()) {
				setFirstOperand((Expression) by);
				return true;
			}
			if (child == getSecondOperand()) {
				setSecondOperand((Expression) by);
				return true;
			}
			return false;
		}

		@Override
		public String toString(CharSequence indent) {
			String opStr = binOpsRev.get(getOperator());
			return 
				(getParenthesis() ? "(" : "") + 
				getFirstOperand() + " " + opStr + " " + getSecondOperand() +
				(getParenthesis() ? ")" : "");
		}
	}

	public static class UnaryOp extends Expression {
		UnaryOperator operator;
		Expression operand;

		public UnaryOp(UnaryOperator operator, Expression operand) {
			this();
			this.operator = operator;
			this.operand = operand;
		}

		public UnaryOp() {
		}

		public Expression getOperand() {
			return operand;
		}
		
		public void setOperator(UnaryOperator operator) {
			this.operator = operator;
		}
		public void setOperand(Expression operand) {
			this.operand = changeValue(this, this.operand, operand);
		}
		public UnaryOperator getOperator() {
			return operator;
		}
		
		@Override
		public void accept(Visitor visitor) {
			visitor.visitUnaryOp(this);
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
			if (child == getOperand()) {
				setOperand((Expression) by);
				return true;
			}
			return false;
		}
		
		@Override
		public String toString(CharSequence indent) {
			return 
				(getParenthesis() ? "(" : "") + 
				unOpsRev.get(getOperator()) + getOperand() +
				(getParenthesis() ? ")" : "");
		}

	}

	public static class Constant extends Expression {
		public enum Type {
			Int, String, Char, IntegerString, Float, Short, Byte, Long, UInt, Double, LongString, ULong
		}
		public enum IntForm {
			Hex, Octal, String
		}
		Type type;
		IntForm intForm;
		Object value;

		
		public Constant(Type type, IntForm intForm, Object value) {
			this();
			setType(type);
			setIntForm(intForm);
			setValue(value);
			
			checkType();
		}
		void checkType() {
			if (type == null)
				return;
			
			Object value = getValue();
			switch (type) {
			case Int:
			case UInt:
			case IntegerString:
				value = (Integer)value;
				break;
			case ULong:
			case Long:
			case LongString:
				value = (Long)value;
				break;
			case Char:
				value = (Character)value;
				break;
			case Double:
				value = (Double)value;
				break;
			case Float:
				value = (Float)value;
				break;
			case String:
				value = (String)value;
				break;
			}
		}
		
		public Constant(Type type, Object value) {
			this();
			setType(type);
			setValue(value);
			
			checkType();
		}
		
		public void setIntForm(IntForm intForm) {
			this.intForm = intForm;
		}
		public IntForm getIntForm() {
			return intForm;
		}
		public Type getType() {
			return type;
		}
		public void setType(Type type) {
			this.type = type;
		}

		public Constant() {
		}
		/*
		public Constant fromString(String s) {
			String v = s.toUpperCase();
			Type type = null;
			if (v.startsWith("\""))
				type = Type.String;
			else if (v.startsWith("'"))
				type = v.length()Type.String;
			else if (v.contains(".")) {
				if (v.endsWith("L"))
					c = Float.TYPE;
				else
					c = Double.TYPE;
			} else if (v.endsWith("L"))
				c = Long.TYPE;
			else if (v.endsWith("F"))
				c = Float.TYPE;
			else if (v.endsWith("D"))
				c = Double.TYPE;
			else {
				//TODO try to parse as long and if it fails as integer, use Long.TYPE
				c = Integer.TYPE;
			}
		}*/
		public Object getValue() {
			return value;
		}
		public void setValue(Object value) {
			this.value = value;
		}
		
		static String intStr(int intVal) {
			return String.valueOf((char)(0xff & (intVal >> 24))) +
				((char)(0xff & (intVal >> 16)))+
				((char)(0xff & (intVal >> 8)))+
				((char)(0xff & (intVal)))
				;
		}
		@Override
		public String toString(CharSequence indent) {
			StringBuffer b = new StringBuffer();
			if (getParenthesis())
				b.append('(');
			
			if (getType() == null)
				b.append("");
			else {
				switch (getType()) {
				case Byte:
				case Double:
				case Int:
				case Short:
				case UInt:
					b.append(value);
					break;
				case Float:
					b.append(value);
					b.append('f');
					break;
				case ULong:
				case Long:
					b.append(value);
					b.append('L');
					break;
				case String:
					b.append('"');
					b.append(StringUtils.javaEscape((String)value));
					b.append('"');
					break;
				case Char:
					b.append('\'');
					b.append(StringUtils.javaEscape(((Character)value).toString()));
					b.append('\'');
					break;
				case IntegerString:
					b.append('\'');
					int intVal = ((Integer)value).intValue();
					b.append(intStr(intVal));
					b.append('\'');
					break;
				case LongString:
					b.append('\'');
					long longVal = ((Long)value).intValue();
					b.append(intStr((int)(longVal & 0xffffffffL)));
					b.append(intStr((int)((longVal >>> 32) & 0xffffffffL)));
					b.append('\'');
					break;
				}
			}
			if (getParenthesis())
				b.append(')');
			return b.toString();
		}
		
		public void accept(Visitor visitor) {
			visitor.visitConstant(this);
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

		public Integer asInteger() {
			switch (getType()) {
			case Int:
			case IntegerString:
				return (Integer)value;
			}
			throw new ClassCastException("Constant " + getValue() + " is not an integer, but a " + getType());
		}


		public static Constant parseCharOrStringInteger(String string) {
			int len = string.length();
			if (len <= 2 || string.charAt(0) != '\'' || string.charAt(len - 1) != '\'')
				throw new IllegalArgumentException("Expecting char or integer string, got " + string);
			
			string = string.substring(1, len - 1);
			len -= 2;
			if (len == 4) {
				boolean isIntegerString = true;
				for (int i = len; i-- != 0;) {
					if (string.charAt(i) == '\\') {
						isIntegerString = false;
						break;
					}
				}
				if (isIntegerString) {
					long result = 0;
					for (int i = 0; i < len; i++) {
						result = result << 8 | (int)string.charAt(i);
					}
					if (len == 4)
						return new Constant(Type.IntegerString, IntForm.String, (int)result);
					else
						return new Constant(Type.LongString, IntForm.String, result);
				}
			}
			return new Constant(Type.Char, parseNakedString(string).charAt(0));
			
		}
		
		public static Constant parseChar(String string) {
			int len = string.length();
			if (len <= 2 || string.charAt(0) != '\'' || string.charAt(len - 1) != '\'')
				throw new IllegalArgumentException("Expecting char, got " + string);
			
			string = string.substring(1, len - 1);
			return new Constant(Type.Char, parseNakedString(string).charAt(0));
		}

		private static String parseNakedString(String string) {
			//return StringUtils.javaUnEscape(string)
			int len = string.length();
			StringBuffer b = new StringBuffer(len);
			for (int i = 0; i < len;) {
				char c = string.charAt(i++);
				if (c == '\\') {
					c = string.charAt(i++);
					switch (c) {
					case 't':
						b.append('\t');
						break;
					case 'n':
						b.append('\n');
						break;
					case 'r':
						b.append('\r');
						break;
					case 'f':
						b.append('\f');
						break;
					case 'b':
						b.append('\b');
						break;
					case '\\':
						b.append('\\');
						break;
					case '"':
						b.append('"');
						break;
					case '\'':
						b.append('\'');
						break;
					case 'u':
						if (i < (len - 3)) {
							b.append((char)Integer.parseInt(string.substring(i, i + 4), 16));
							i += 4;
						}
						break;
					default:
						if (Character.isDigit(c)) {
							int start = i - 1;
							int end = i;
							while (Character.isDigit(string.charAt(end))) {
								end++;
							}
							b.append((char)Integer.parseInt(string.substring(start, end), 8));
							i = end;
						}
					}
				} else {
					b.append(c);
				}
			}
			return b.toString();
		}

		public static Constant parseStringInteger(String string) {
			int len = string.length();
			if (len <= 2 || string.charAt(0) != '\'' || string.charAt(len - 1) != '\'' || ((len -= 2) != 4 && len != 8))
				throw new IllegalArgumentException("Expecting 'xxxx' or 'xxxxxxxx', got " + string);
			
			string = string.substring(1, len - 1);
			long result = 0;
			for (int i = len; i-- != 0;) {
				result = result << 8 | (int)string.charAt(i);
			}
			if (len == 4)
				return new Constant(Type.Int, IntForm.String, (int)result);
			else
				return new Constant(Type.Long, IntForm.String, result);
		}
		
		public static Constant parseString(String string) {
			int len = string.length();
			if (len <= 2 || string.charAt(0) != '"' || string.charAt(len - 1) != '"')
				throw new IllegalArgumentException("Expecting string, got " + string);

			string = string.substring(1, len - 1);
			return new Constant(Type.String, parseNakedString(string));
		}

		public static Constant parseDecimal(String string) {
			return parseDecimal(string, 10);
		}
		
		public static Constant parseDecimal(String string, int radix) {
			string = string.trim().toLowerCase();
			int len = string.length();
			boolean unsigned = false;
			if (string.endsWith("ll") || string.endsWith("li"))
				return new Constant(Type.Long, Long.parseLong(string.substring(0, len - 2), radix));
			else if (string.endsWith("l"))
				string = string.substring(0, len - 1);
			else if (string.endsWith("s"))
				return new Constant(Type.Short, Long.parseLong(string.substring(0, len - 1), radix));
			//else if (string.endsWith("b"))
			//	return new Constant(Type.Byte, Long.parseLong(string.substring(0, len - 1), radix));
			else if (string.endsWith("u")) {
				string = string.substring(0, len - 1);
				unsigned = true;
			}
			
			long val;
			if (string.equals("ffffffffffffffff"))
				val = 0xffffffffffffffffL;
			else
				val = Long.parseLong(string, radix);
			
			//TODO handle unsigned properly !
			if (val > Integer.MIN_VALUE && val < Integer.MAX_VALUE)
				return new Constant(unsigned ? Type.UInt : Type.Int, (int)val);
			else
				return new Constant(unsigned ? Type.ULong : Type.Long, val);
			
		}

		public static Constant parseHex(String string) {
			string = string.trim().toLowerCase();
			if (!string.startsWith("0x"))
				throw new IllegalArgumentException("Expected hex literal, got " + string);
			
			try {
				return parseDecimal(string.substring(2), 16);
			} catch (NumberFormatException ex) {
				throw new NumberFormatException("Parsing hex : \"" + string +"\"");
			}
		}

		public static Constant parseOctal(String string) {
			string = string.trim().toLowerCase();
			if (!string.startsWith("\\"))
				throw new IllegalArgumentException("Expected octal literal, got " + string);
			
			return parseDecimal(string.substring(2), 8);
		}

		public static Constant parseFloat(String string) {
			string = string.trim().toLowerCase();
			if (string.length() > 0) {
				int lm1 = string.length() - 1;
				char c = string.charAt(lm1);
				if (Character.isLetter(c)) {
					String beg = string.substring(0, lm1);
					if (c == 'f')
						return new Constant(Type.Float, Float.parseFloat(beg));
					
				}
			}
			return new Constant(Type.Double, Double.parseDouble(string));
		}
		public Constant asJava() {
			Type type = getType();
			switch (type) {
			case ULong:
			case LongString:
				type = Type.Long;
				break;
			case IntegerString:
			case UInt:
				type = Type.Int;
				break;
			}
			return new Constant(type, getValue());
		}

		
	}
}
