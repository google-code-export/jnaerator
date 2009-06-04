package com.ochafik.lang.jnaerator.parser;

import static com.ochafik.lang.jnaerator.parser.Expression.*;

import java.util.Arrays;

import static com.ochafik.lang.jnaerator.parser.Identifier.*;
import static com.ochafik.lang.jnaerator.parser.Statement.*;

import com.ochafik.lang.jnaerator.parser.Expression.MemberRefStyle;
import com.ochafik.lang.jnaerator.parser.TypeRef.SimpleTypeRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.TaggedTypeRef;
public class ElementsHelper {
	public static Expression memberRef(Expression x, MemberRefStyle style, String name) {
		return new Expression.MemberRef(x, style, new SimpleIdentifier(name));
	}
	public static Expression memberRef(Expression x, MemberRefStyle style, Identifier name) {
		return new Expression.MemberRef(x, style, name);
	}
	public static Expression varRef(String name) {
		return new Expression.VariableRef(new SimpleIdentifier(name));
	}
	public static Expression varRef(SimpleIdentifier name) {
		return new Expression.VariableRef(name);
	}
	public static SimpleIdentifier ident(String name) {
		return name == null ? null : new SimpleIdentifier(name);
	}
	public static Identifier ident(Class<?> cl) {
		if (cl.getPackage() == null)
			return ident(cl.getName());
		else
			return ident(ident(cl.getPackage().getName()), ident(cl.getSimpleName()));
	}
	public static Identifier ident(Identifier ident, String name) {
		return ident(ident, ident(name));
	}
	public static Identifier ident(Identifier ident, Identifier... others) {
		if (ident == null) {
			if (others.length > 0)
				return ident(others[0], Arrays.copyOfRange(others, 1, others.length));
			return null;
		}
		return ident.derive(Identifier.QualificationSeparator.Dot, others);
	}
	public static Expression opaqueExpr(String s) {
		return new OpaqueExpression(s);
	}
	public static Expression cast(TypeRef t, Expression s) {
		return new Cast(t, s);
	}
	public static Expression nullExpr() {
		return new NullExpression();
	}
	public static Expression expr(TypeRef tr) {
		return new TypeRefExpression(tr);
	}
	public static Expression expr(Constant.Type type, Object value) {
		return new Constant(type, value);
	}
	public static Expression expr(UnaryOperator op, Expression b) {
		return new UnaryOp(b, op);
	}
	public static Expression expr(Expression a, BinaryOperator op, Expression b) {
		return new BinaryOp(a, op, b);
	}
	public static Expression expr(Expression a, AssignmentOperator op, Expression b) {
		return new AssignmentOp(a, op, b);
	}
	public static FunctionCall methodCall(Expression x, MemberRefStyle style, String name, Expression... exprs) {
		return new FunctionCall(memberRef(x, style, name), exprs);
	}
	public static Expression methodCall(String name, Expression... exprs) {
		return new FunctionCall(memberRef(null, null, name), exprs);
	}
	public static TypeRef typeRef(Class<?> cl) {
		return new SimpleTypeRef(cl.getName());
	}

	public static TypeRef typeRef(String name) {
		return new SimpleTypeRef(name);
	}
	public static TypeRef typeRef(Identifier name) {
		return name == null ? null : new SimpleTypeRef(name);
	}
	public static Statement stat(Expression x) {
		return new ExpressionStatement(x);
	}
	public static Block block(Statement... x) {
		return new Block(x);
	}
	
	public static TaggedTypeRefDeclaration decl(TaggedTypeRef tr) {
		return new TaggedTypeRefDeclaration(tr);
	}
/*

	public static TypeRef typeRef(TypeRef parentTypeRef, Style style, Identifier subName) {
		if (parentTypeRef == null)
			return typeRef(subName);
		return new SubTypeRef(parentTypeRef, style, subName);
	}*/
//	public static TypeRef typeRef(TypeRef parentTypeRef, String subName) {
//		return typeRef(parentTypeRef, Style.Dot, subName);
//	}
	
	
}
