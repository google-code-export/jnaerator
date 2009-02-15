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
import java.util.Collection;

import com.ochafik.lang.jnaerator.parser.Enum.EnumItem;
import com.ochafik.lang.jnaerator.parser.Expression.Assignment;
import com.ochafik.lang.jnaerator.parser.Expression.BinaryOp;
import com.ochafik.lang.jnaerator.parser.Expression.Cast;
import com.ochafik.lang.jnaerator.parser.Expression.Constant;
import com.ochafik.lang.jnaerator.parser.Expression.EmptyArraySize;
import com.ochafik.lang.jnaerator.parser.Expression.FieldRef;
import com.ochafik.lang.jnaerator.parser.Expression.FunctionCall;
import com.ochafik.lang.jnaerator.parser.Expression.MemberRef;
import com.ochafik.lang.jnaerator.parser.Expression.New;
import com.ochafik.lang.jnaerator.parser.Expression.TypeRefExpression;
import com.ochafik.lang.jnaerator.parser.Expression.UnaryOp;
import com.ochafik.lang.jnaerator.parser.Expression.VariableRef;
import com.ochafik.lang.jnaerator.parser.StoredDeclarations.TypeDef;
import com.ochafik.lang.jnaerator.parser.TypeRef.ArrayRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.EnumTypeRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.FunctionSignature;
import com.ochafik.lang.jnaerator.parser.TypeRef.Pointer;
import com.ochafik.lang.jnaerator.parser.TypeRef.Primitive;
import com.ochafik.lang.jnaerator.parser.TypeRef.SimpleTypeRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.StructTypeRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.TargettedTypeRef;
import com.ochafik.util.listenable.Pair;

public class Scanner implements Visitor {

	public void visitArg(Arg arg) {
		visitDeclaration(arg);
		
		if (arg.getDefaultValue() != null)
			arg.getDefaultValue().accept(this);
	}

	public void visitConstant(Constant constant) {
		visitExpression(constant);
	}

	protected void visitExpression(Expression expression) {
		visitElement(expression);
	}

	public void visitEnum(Enum enum1) {
		visitDeclaration(enum1);
		for (EnumItem item : copy(enum1.getItems())) {
			item.accept(this);
		}
	}

	public void visitFunction(Function function) {
		visitDeclaration(function);
		for (Arg arg : copy(function.getArgs()))
			arg.accept(this);
		
		if (function.getBody() != null)
			function.getBody().accept(this);
	}

	public void visitFunctionPointerDeclaration(FunctionPointerDeclaration f) {
		visitDeclaration(f);
		if (f.getDefaultValue() != null)
			f.getDefaultValue().accept(this);
	}
	
	protected void visitDeclaration(Declaration d) {
		visitElement(d);
		
		if (d.getValueType() != null)
			d.getValueType().accept(this);
		
		for (Annotation a : d.getAnnotations())
			if (a != null)
				a.accept(this);
		
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
		for (VariableStorage s : copy(d.getVariableStorages()))
			s.accept(this);
	}

	protected void visitCPPClass(Struct struct) {
		doVisitStruct(struct);
	}

	protected void doVisitStruct(Struct struct) {
		visitStoredDeclarations(struct);
		for (Declaration m : copy(struct.getDeclarations()))
			m.accept(this);
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
		for (Expression x : copy(array.getDimensions())) {
			if (x != null)
				x.accept(this);
		}
	}

	protected void visitTypeRef(TypeRef array) {
		visitElement(array);
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
		visitTypeRef(primitive);
	}

	public void visitSimpleTypeRef(SimpleTypeRef simpleTypeRef) {
		visitTypeRef(simpleTypeRef);
	}

	static <T> Collection<T> copy(Collection<T> col) {
		return new ArrayList<T>(col);
	}
	public void visitSourceFile(SourceFile header) {
		visitElement(header);
		for (Declaration d : copy(header.getDeclarations()))
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
		
		for (Pair<String, Expression> x : copy(functionCall.getArguments())) {
			x.getSecond().accept(this);
		}
	}

	public void visitAssignment(Assignment assignment) {
		visitExpression(assignment);
		visitExpression(assignment.getTarget());
		visitExpression(assignment.getValue());
	}

	public void visitFieldRef(FieldRef fieldRef) {
		visitMemberRef(fieldRef);
	}

	public void visitMemberRef(MemberRef memberRef) {
		visitExpression(memberRef);

		if (memberRef.getTarget() != null)
			memberRef.getTarget().accept(this);
	}

	public void visitCast(Cast cast) {
		visitExpression(cast);
		if (cast.getType() != null)
			cast.getType().accept(this);
		if (cast.getTarget() != null)
			cast.getTarget().accept(this);
	}
	
	public void visitVariableStorage(VariableStorage variableStorage) {
		visitElement(variableStorage);
		
		if (variableStorage.getDefaultValue() != null)
			variableStorage.getDefaultValue().accept(this);
		
		for (Expression x : copy(variableStorage.getDimensions()))
			x.accept(this);
	}

	public void visitVariablesDeclaration(VariablesDeclaration v) {
		visitDeclaration(v);
		for (VariableStorage vs : copy(v.getVariableStorages()))
			vs.accept(this);
	}

	public void visitStructTypeRef(StructTypeRef structTypeRef) {
		visitTypeRef(structTypeRef);
		if (structTypeRef.getStruct() != null)
			structTypeRef.getStruct().accept(this);
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

	public void visitEnumTypeRef(EnumTypeRef enumTypeRef) {
		visitTypeRef(enumTypeRef);
		if (enumTypeRef.getEnumeration() != null)
			enumTypeRef.getEnumeration().accept(this);
	}

	@Override
	public void visitAnnotation(Annotation annotation) {
		visitElement(annotation);
	}

	@Override
	public void visitEmptyDeclaration(EmptyDeclaration emptyDeclaration) {
		visitDeclaration(emptyDeclaration);
	}

}
