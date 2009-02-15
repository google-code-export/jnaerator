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
package com.ochafik.lang.grammar.objcpp;

import com.ochafik.lang.grammar.objcpp.Expression.Assignment;
import com.ochafik.lang.grammar.objcpp.Expression.BinaryOp;
import com.ochafik.lang.grammar.objcpp.Expression.Cast;
import com.ochafik.lang.grammar.objcpp.Expression.Constant;
import com.ochafik.lang.grammar.objcpp.Expression.EmptyArraySize;
import com.ochafik.lang.grammar.objcpp.Expression.FieldRef;
import com.ochafik.lang.grammar.objcpp.Expression.FunctionCall;
import com.ochafik.lang.grammar.objcpp.Expression.New;
import com.ochafik.lang.grammar.objcpp.Expression.TypeRefExpression;
import com.ochafik.lang.grammar.objcpp.Expression.UnaryOp;
import com.ochafik.lang.grammar.objcpp.Expression.VariableRef;
import com.ochafik.lang.grammar.objcpp.StoredDeclarations.TypeDef;
import com.ochafik.lang.grammar.objcpp.TypeRef.ArrayRef;
import com.ochafik.lang.grammar.objcpp.TypeRef.EnumTypeRef;
import com.ochafik.lang.grammar.objcpp.TypeRef.FunctionSignature;
import com.ochafik.lang.grammar.objcpp.TypeRef.Pointer;
import com.ochafik.lang.grammar.objcpp.TypeRef.Primitive;
import com.ochafik.lang.grammar.objcpp.TypeRef.SimpleTypeRef;
import com.ochafik.lang.grammar.objcpp.TypeRef.StructTypeRef;

public interface Visitor {

	void visitConstant(Constant constant);

	void visitArg(Arg arg);

	void visitEnum(Enum enum1);

	void visitFunction(Function function);

	void visitFunctionPointerDeclaration(
			FunctionPointerDeclaration functionPointerDeclaration);

	void visitStruct(Struct struct);

	void visitTypeDef(TypeDef typeDef);

	void visitSimpleTypeRef(SimpleTypeRef simpleTypeRef);

	void visitFunctionSignature(FunctionSignature functionSignature);

	void visitPrimitive(Primitive primitive);

	void visitPointer(Pointer pointer);

	void visitArray(ArrayRef array);

	void visitSourceFile(SourceFile sourceFile);

	void visitEnumItem(Enum.EnumItem enumItem);

	void visitUnaryOp(UnaryOp unaryOp);

	void visitVariableRef(VariableRef variableRef);

	void visitBinaryOp(BinaryOp binaryOp);

	void visitFunctionCall(FunctionCall functionCall);

	void visitAssignment(Assignment assignment);

	void visitFieldRef(FieldRef fieldRef);

	void visitCast(Cast cast);

	void visitVariableStorage(VariableStorage variableStorage);

	void visitVariablesDeclaration(VariablesDeclaration variablesDeclaration);

	void visitStructTypeRef(StructTypeRef structTypeRef);

	void visitEmptyArraySize(EmptyArraySize emptyArraySize);

	void visitDefine(Define define);

	void visitTypeRefExpression(TypeRefExpression typeRefExpression);

	void visitNew(New new1);

	void visitEnumTypeRef(EnumTypeRef enumTypeRef);

	void visitAnnotation(Annotation annotation);

	void visitEmptyDeclaration(EmptyDeclaration emptyDeclaration);
	
}
