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
import java.util.Collection;

import com.ochafik.lang.jnaerator.parser.Declarator.ArrayDeclarator;
import com.ochafik.lang.jnaerator.parser.Declarator.DirectDeclarator;
import com.ochafik.lang.jnaerator.parser.Declarator.FunctionDeclarator;
import com.ochafik.lang.jnaerator.parser.Declarator.PointerDeclarator;
import com.ochafik.lang.jnaerator.parser.Declarator.TargettedDeclarator;
import com.ochafik.lang.jnaerator.parser.Enum.EnumItem;
import com.ochafik.lang.jnaerator.parser.Expression.ArrayAccess;
import com.ochafik.lang.jnaerator.parser.Expression.AssignmentOp;
import com.ochafik.lang.jnaerator.parser.Expression.BinaryOp;
import com.ochafik.lang.jnaerator.parser.Expression.Cast;
import com.ochafik.lang.jnaerator.parser.Expression.ConditionalExpression;
import com.ochafik.lang.jnaerator.parser.Expression.Constant;
import com.ochafik.lang.jnaerator.parser.Expression.EmptyArraySize;
import com.ochafik.lang.jnaerator.parser.Expression.ExpressionSequence;
import com.ochafik.lang.jnaerator.parser.Expression.FunctionCall;
import com.ochafik.lang.jnaerator.parser.Expression.MemberRef;
import com.ochafik.lang.jnaerator.parser.Expression.New;
import com.ochafik.lang.jnaerator.parser.Expression.NewArray;
import com.ochafik.lang.jnaerator.parser.Expression.NullExpression;
import com.ochafik.lang.jnaerator.parser.Expression.OpaqueExpression;
import com.ochafik.lang.jnaerator.parser.Expression.TypeRefExpression;
import com.ochafik.lang.jnaerator.parser.Expression.UnaryOp;
import com.ochafik.lang.jnaerator.parser.Expression.VariableRef;
import com.ochafik.lang.jnaerator.parser.Identifier.QualifiedIdentifier;
import com.ochafik.lang.jnaerator.parser.Identifier.SimpleIdentifier;
import com.ochafik.lang.jnaerator.parser.Statement.Block;
import com.ochafik.lang.jnaerator.parser.Statement.ExpressionStatement;
import com.ochafik.lang.jnaerator.parser.Statement.If;
import com.ochafik.lang.jnaerator.parser.Statement.Return;
import com.ochafik.lang.jnaerator.parser.StoredDeclarations.TypeDef;
import com.ochafik.lang.jnaerator.parser.TypeRef.ArrayRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.FunctionSignature;
import com.ochafik.lang.jnaerator.parser.TypeRef.Pointer;
import com.ochafik.lang.jnaerator.parser.TypeRef.Primitive;
import com.ochafik.lang.jnaerator.parser.TypeRef.SimpleTypeRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.TaggedTypeRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.TargettedTypeRef;
import com.ochafik.util.listenable.Pair;

public class Scanner implements Visitor {

	public void visitArg(Arg arg) {
		visitDeclaration(arg);
		
		if (arg.getDefaultValue() != null)
			arg.getDefaultValue().accept(this);
		
		if (arg.getDeclarator() != null)
			arg.getDeclarator().accept(this);
	}

	public void visitConstant(Constant constant) {
		visitExpression(constant);
	}

	protected void visitExpression(Expression expression) {
		visitElement(expression);
	}

	public void visitEnum(Enum enum1) {
		visitTaggedTypeRef(enum1);
		for (EnumItem item : copy(enum1.getItems()))
			if (item != null)
				item.accept(this);
	}

	public void visitFunction(Function function) {
		visitDeclaration(function);
		for (Arg arg : copy(function.getArgs()))
			if (arg != null)
				arg.accept(this);
		
		for (FunctionCall fc : function.getInitializers())
			if (fc != null)
				fc.accept(this);
		
		if (function.getBody() != null)
			function.getBody().accept(this);
		if (function.getName() != null)
			function.getName().accept(this);
	}

	public void visitFunctionPointerDeclaration(FunctionPointerDeclaration f) {
		visitDeclaration(f);
		if (f.getDefaultValue() != null)
			f.getDefaultValue().accept(this);
	}
	
	protected void visitDeclaration(Declaration d) {
		visitModifiableElement(d);
		
		if (d.getValueType() != null)
			d.getValueType().accept(this);
		
		/*visitModifiers(d.getModifiers(), d);
		
		visitNameSpace(d.getNameSpace(), d);
		
		visitPostComment(d.getPostComment(), d);
		visitPreComment(d.getPreComment(), d);
		visitDeclarationVisibility(d.getVisibility(), d);*/
		
	}

	protected void visitElement(Element d) {
		
	}

	public void visitStruct(Struct struct) {
		if (struct.getType() != null) {
			switch (struct.getType()) {
			case CPPClass:
				visitCPPClass(struct);
				break;
			case CStruct:
				visitCStruct(struct);
				break;
			case ObjCClass:
				visitObjCClass(struct);
				break;
			case ObjCProtocol:
				visitObjCProtocol(struct);
				break;
			case JavaClass:
				visitJavaClass(struct);
				break;
			case JavaInterface:
				visitJavaInterface(struct);
				break;
			default:
				doVisitStruct(struct);
			}
		} else {
			doVisitStruct(struct);
		}
		
	}

	public void visitJavaClass(Struct struct) {
		doVisitStruct(struct);
	}

	public void visitJavaInterface(Struct struct) {
		doVisitStruct(struct);
	}

	protected void visitStoredDeclarations(StoredDeclarations d) {
		visitDeclaration(d);
		for (Declarator s : copy(d.getDeclarators()))
			if (s != null)
				s.accept(this);
	}

	protected void visitCPPClass(Struct struct) {
		doVisitStruct(struct);
	}

	protected void doVisitStruct(Struct struct) {
		visitTaggedTypeRef(struct);
		for (Declaration m : copy(struct.getDeclarations()))
			if (m != null)
				m.accept(this);
		for (Identifier i : struct.getProtocols())
			if (i != null)
				i.accept(this);
	}

	protected void visitCStruct(Struct struct) {
		doVisitStruct(struct);
	}

	protected void visitObjCClass(Struct struct) {
		doVisitStruct(struct);
	}

	protected void visitObjCProtocol(Struct struct) {
		doVisitStruct(struct);
	}

	public void visitTypeDef(TypeDef typeDef) {
		visitStoredDeclarations(typeDef);
	}

	public void visitArray(ArrayRef array) {
		visitTargettedTypeRef(array);
		for (Expression x : copy(array.getDimensions()))
			if (x != null)
				x.accept(this);
	}

	protected void visitTypeRef(TypeRef array) {
		visitModifiableElement(array);
	}

	protected void visitTargettedTypeRef(TargettedTypeRef targettedTypeRef) {
		visitTypeRef(targettedTypeRef);
		if (targettedTypeRef.getTarget() != null)
			targettedTypeRef.getTarget().accept(this);
	}

	public void visitFunctionSignature(FunctionSignature functionSignature) {
		visitTypeRef(functionSignature);
		if (functionSignature != null  && functionSignature.getFunction() != null)
			functionSignature.getFunction().accept(this);
	}

	public void visitPointer(Pointer pointer) {
		visitTargettedTypeRef(pointer);
	}

	public void visitPrimitive(Primitive primitive) {
		visitSimpleTypeRef(primitive);
	}

	public void visitSimpleTypeRef(SimpleTypeRef simpleTypeRef) {
		visitTypeRef(simpleTypeRef);

		if (simpleTypeRef.getName() != null)
			simpleTypeRef.getName().accept(this);
	}

	static <T> Collection<T> copy(Collection<T> col) {
		return new ArrayList<T>(col);
	}
	public void visitSourceFile(SourceFile header) {
		visitElement(header);
		for (Declaration d : copy(header.getDeclarations()))
			if (d != null)
				d.accept(this);
	}

	public void visitEnumItem(EnumItem enumItem) {
		visitElement(enumItem);
		if (enumItem.getValue() != null)
			enumItem.getValue().accept(this);
	}

	public void visitUnaryOp(UnaryOp unaryOp) {
		visitExpression(unaryOp);
		if (unaryOp.getOperand() != null)
			unaryOp.getOperand().accept(this);
	}

	public void visitVariableRef(VariableRef variableRef) {
		visitExpression(variableRef);
		if (variableRef.getName() != null)
			variableRef.getName().accept(this);
	}

	public void visitBinaryOp(BinaryOp binaryOp) {
		visitExpression(binaryOp);
		if (binaryOp.getFirstOperand() != null)
			binaryOp.getFirstOperand().accept(this);
		
		if (binaryOp.getSecondOperand() != null)
			binaryOp.getSecondOperand().accept(this);
	}

	public void visitFunctionCall(FunctionCall functionCall) {
		visitMemberRef(functionCall);
		if (functionCall.getTarget() != null)
			functionCall.getTarget().accept(this);
		if (functionCall.getFunction() != null)
			functionCall.getFunction().accept(this);
		
		for (Pair<String, Expression> x : copy(functionCall.getArguments())) {
			if (x != null && x.getSecond() != null)
				x.getSecond().accept(this);
		}
	}

	/*public void visitAssignment(Assignment assignment) {
		visitExpression(assignment);
		visitExpression(assignment.getTarget());
		visitExpression(assignment.getValue());
	}*/
	@Override
	public void visitMemberRef(MemberRef memberRef) {
		visitExpression(memberRef);

		if (memberRef.getTarget() != null)
			memberRef.getTarget().accept(this);
		if (memberRef.getName() != null)
			memberRef.getName().accept(this);
		
	}

	public void visitCast(Cast cast) {
		visitExpression(cast);
		if (cast.getType() != null)
			cast.getType().accept(this);
		if (cast.getTarget() != null)
			cast.getTarget().accept(this);
	}
	
	public void visitDeclarator(Declarator declarator) {
		visitModifiableElement(declarator);
		
		if (declarator.getDefaultValue() != null)
			declarator.getDefaultValue().accept(this);
	}

	public void visitVariablesDeclaration(VariablesDeclaration v) {
		visitDeclaration(v);
		for (Declarator vs : copy(v.getDeclarators()))
			if (vs != null)
				vs.accept(this);
	}

	public void visitTaggedTypeRefDeclaration(TaggedTypeRefDeclaration taggedTypeRefDeclaration) {
		visitDeclaration(taggedTypeRefDeclaration);
		if (taggedTypeRefDeclaration.getTaggedTypeRef() != null)
			taggedTypeRefDeclaration.getTaggedTypeRef().accept(this);
	}

	public void visitEmptyArraySize(EmptyArraySize emptyArraySize) {
		visitExpression(emptyArraySize);
	}

	public void visitDefine(Define define) {
		visitDeclaration(define);
		if (define.getValue() != null)
			define.getValue().accept(this);
	}

	public void visitTypeRefExpression(TypeRefExpression typeRefExpression) {
		visitExpression(typeRefExpression);
		if (typeRefExpression.getType() != null)
			typeRefExpression.getType().accept(this);
	}

	public void visitNew(New new1) {
		visitExpression(new1);
		if (new1.getType() != null)
			new1.getType().accept(this);
		
		if (new1.getConstruction() != null)
			new1.getConstruction().accept(this);
	}

	@Override
	public void visitAnnotation(Annotation annotation) {
		visitElement(annotation);
		for (Expression x : annotation.getArguments())
			if (x != null)
				x.accept(this);
	}

	@Override
	public void visitEmptyDeclaration(EmptyDeclaration emptyDeclaration) {
		visitDeclaration(emptyDeclaration);
	}

	@Override
	public void visitNewArray(NewArray newArray) {
		visitExpression(newArray);
		if (newArray.getType() != null)
			newArray.getType().accept(this);
		for (Expression x : newArray.getDimensions())
			if (x != null)
				x.accept(this);
	}

	@Override
	public void visitArrayDeclarator(ArrayDeclarator arrayDeclarator) {
		visitTargettedDeclarator(arrayDeclarator);
		for (Expression x : arrayDeclarator.getDimensions())
			if (x != null)
				x.accept(this);
	}

	@Override
	public void visitDirectDeclarator(DirectDeclarator directDeclarator) {
		visitDeclarator(directDeclarator);
	}

	@Override
	public void visitFunctionDeclarator(FunctionDeclarator functionDeclarator) {
		visitTargettedDeclarator(functionDeclarator);
		for (Arg arg : functionDeclarator.getArgs())
			if (arg != null)
				arg.accept(this);
	}

	@Override
	public void visitPointerDeclarator(PointerDeclarator pointerDeclarator) {
		visitTargettedDeclarator(pointerDeclarator);
	}

	private void visitTargettedDeclarator(TargettedDeclarator targettedDeclarator) {
		visitDeclarator(targettedDeclarator);
		if (targettedDeclarator.getTarget() != null) {
			targettedDeclarator.getTarget().accept(this);
		}
	}

	@Override
	public void visitModifiableElement(ModifiableElement modifiableElement) {
		visitElement(modifiableElement);
		for (Annotation a : modifiableElement.getAnnotations())
			if (a != null)
				a.accept(this);
	}

	@Override
	public void visitTaggedTypeRef(TaggedTypeRef taggedTypeRef) {
		visitTypeRef(taggedTypeRef);
		if (taggedTypeRef.getTag() != null)
			taggedTypeRef.getTag().accept(this);
		if (taggedTypeRef.getOriginalTag() != null)
			taggedTypeRef.getOriginalTag().accept(this);
		
	}

	@Override
	public void visitBlock(Block block) {
		visitStatement(block);
		for (Statement x : copy(block.getStatements()))
			if (x != null)
				x.accept(this);
	}

	@Override
	public void visitExpressionStatement(ExpressionStatement expressionStatement) {
		visitStatement(expressionStatement);
		if (expressionStatement.getExpression() != null)
			expressionStatement.getExpression().accept(this);
	}

	public void visitStatement(Statement statement) {
		visitElement(statement);
	}

	@Override
	public void visitIf(If if1) {
		visitStatement(if1);
		if (if1.getCondition() != null)
			if1.getCondition().accept(this);
		if (if1.getThenBranch() != null)
			if1.getThenBranch().accept(this);
		if (if1.getElseBranch() != null)
			if1.getElseBranch().accept(this);
	}

	@Override
	public void visitNullExpression(NullExpression nullExpression) {
		visitExpression(nullExpression);
	}

	@Override
	public void visitReturn(Return return1) {
		visitStatement(return1);
		if (return1.getValue() != null)
			return1.getValue().accept(this);
	}

	@Override
	public void visitExternDeclarations(ExternDeclarations externDeclarations) {
		visitDeclaration(externDeclarations);
		for (Declaration d : new ArrayList<Declaration>(externDeclarations.getDeclarations()))
			if (d != null)
				d.accept(this);
	}

	@Override
	public void visitOpaqueExpression(OpaqueExpression opaqueExpression) {
		visitExpression(opaqueExpression);
	}

	@Override
	public void visitArrayAccess(ArrayAccess arrayAccess) {
		visitExpression(arrayAccess);
		if (arrayAccess.getTarget() != null)
			arrayAccess.getTarget().accept(this);
		if (arrayAccess.getIndex() != null)
			arrayAccess.getIndex().accept(this);
	}

	@Override
	public void visitAssignmentOp(AssignmentOp assignment) {
		visitExpression(assignment);
		if (assignment.getTarget() != null)
			assignment.getTarget().accept(this);
		
		if (assignment.getValue() != null)
			assignment.getValue().accept(this);
	}

	@Override
	public void visitConditionalExpression(
			ConditionalExpression conditionalExpression) {
		visitExpression(conditionalExpression);
		if (conditionalExpression.getTest() != null)
			conditionalExpression.getTest().accept(this);
		if (conditionalExpression.getThenValue() != null)
			conditionalExpression.getThenValue().accept(this);
		if (conditionalExpression.getElseValue() != null)
			conditionalExpression.getElseValue().accept(this);
		
	}

	@Override
	public void visitExpressionSequence(ExpressionSequence expressionSequence) {
		visitExpression(expressionSequence);
		for (Expression x : expressionSequence.getSequence())
			if (x != null)
				x.accept(this);
	}

	@Override
	public void visitSimpleIdentifier(SimpleIdentifier simpleIdentifier) {
		visitIdentifier(simpleIdentifier);
		for (Expression x : simpleIdentifier.getTemplateArguments())
			if (x != null)
				x.accept(this);
	}

	private void visitIdentifier(Identifier identifier) {
		visitElement(identifier);
	}

	@Override
	public void visitQualifiedIdentifier(QualifiedIdentifier qualifiedIdentifier) {
		visitIdentifier(qualifiedIdentifier);
		for (SimpleIdentifier i : qualifiedIdentifier.getIdentifiers())
			if (i != null)
				i.accept(this);
	}

}
