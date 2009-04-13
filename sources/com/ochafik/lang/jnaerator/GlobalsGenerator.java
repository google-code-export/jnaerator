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
package com.ochafik.lang.jnaerator;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;

import com.ochafik.lang.jnaerator.TypeConversion.TypeConversionMode;
import com.ochafik.lang.jnaerator.parser.Arg;
import com.ochafik.lang.jnaerator.parser.DeclarationsHolder;
import com.ochafik.lang.jnaerator.parser.Declarator;
import com.ochafik.lang.jnaerator.parser.Expression;
import com.ochafik.lang.jnaerator.parser.Function;
import com.ochafik.lang.jnaerator.parser.Modifier;
import com.ochafik.lang.jnaerator.parser.Statement;
import com.ochafik.lang.jnaerator.parser.Struct;
import com.ochafik.lang.jnaerator.parser.TypeRef;
import com.ochafik.lang.jnaerator.parser.VariablesDeclaration;
import com.ochafik.lang.jnaerator.parser.Declarator.PointerStyle;
import com.ochafik.lang.jnaerator.parser.Expression.MemberRefStyle;
import com.ochafik.lang.jnaerator.parser.Expression.VariableRef;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import static com.ochafik.lang.jnaerator.parser.ElementsHelper.*;
public class GlobalsGenerator {
	public GlobalsGenerator(Result result) {
		this.result = result;
	}

	final Result result;
	
//	public static final class NAME {
//		private static NAME_holder NAME;
//		public static final class NAME_holder {
//			public String value;
//		}
//		public static synchronized NAME_holder get() {
//			if (NAME == null)
//				NAME = new NAME_holder((Pointer)null);
//			return NAME;
//		}
//		void test() {
//			GlobalsGenerator.NAME.get().value;
//		}
//	}
	
	public void convertGlobals(VariablesDeclaration globals, Signatures signatures, DeclarationsHolder out, String callerLibraryName) throws UnsupportedConversionException {
		for (Declarator d : globals.getDeclarators()) {
			String name = result.typeConverter.getValidJavaArgumentName(d.resolveName());
			TypeRef type = (TypeRef)d.mutateType(globals.getValueType());
			if (type == null || type.getModifiers().contains(Modifier.Const) && d.getDefaultValue() != null) {
				//result.declarationsConverter.convertCon
				continue;
			}
			
			if (!signatures.classSignatures.add(name))
				continue;
			
			Struct struct = result.declarationsConverter.publicStaticClass(name, null, Struct.Type.JavaClass, null);
			struct.addModifiers(Modifier.Final);
			struct.importDetails(globals, false);
			struct.moveAllCommentsBefore();
			
			/// We get a pointer to the global, not the global itself
			TypeRef pointerType = new TypeRef.Pointer(type, PointerStyle.Pointer);
			
			TypeRef convPointerType = result.typeConverter.convertTypeToJNA(pointerType, TypeConversionMode.FieldType, callerLibraryName);
			TypeRef instType;
			boolean hasOffset, isPtr = false, isByRef = false;
			String convPointerTypeStr = convPointerType.toString();
			if (convPointerTypeStr.equals(Pointer.class.getName())) {
				isPtr = true;
				instType = convPointerType;
				hasOffset = false;
			} else if (TypeConversion.byReferenceClassesNames.contains(convPointerTypeStr)) {
				isByRef = true;
				instType = convPointerType;
				hasOffset = false;
			} else if (convPointerTypeStr.endsWith(".ByReference") && result.structsByName.get(convPointerTypeStr.substring(0, convPointerTypeStr.length() - ".ByReference".length())) != null) {
				instType = result.typeConverter.convertTypeToJNA(type, TypeConversionMode.PointedValue, callerLibraryName);//convPointerType;
				hasOffset = true;
			} else {
				String instTypeName = name + "_holder";
				Struct holderStruct = result.declarationsConverter.publicStaticClass(instTypeName, Structure.class.getName(), Struct.Type.JavaClass, null);
				holderStruct.addModifiers(Modifier.Final);
				VariablesDeclaration vd = result.declarationsConverter.convertVariablesDeclaration("value", type, new int[1], callerLibraryName);
				if (vd.getValueType().toString().equals(Pointer.class.getName())) {
					isByRef = true;
					instType = convPointerType;
					hasOffset = false;	
				} else {
					holderStruct.addDeclaration(vd);
					Function pointerConstructor = new Function(Function.Type.JavaMethod, instTypeName, null, 
						new Arg("pointer", new TypeRef.SimpleTypeRef(Pointer.class.getName()))
					);
					hasOffset = false;
					pointerConstructor.setBody(new Statement.Block(
							new Statement.ExpressionStatement(methodCall("super")),
							new Statement.ExpressionStatement(methodCall("useMemory", varRef("pointer"), expr(Expression.Constant.Type.Int, 0))),
							new Statement.ExpressionStatement(methodCall("read"))
					));
					holderStruct.addDeclaration(pointerConstructor);
					
					//holderStruct.addDeclaration(new VariablesDeclaration(convType, new Declarator.DirectDeclarator("value")).addModifiers(Modifier.Public));
					instType = new TypeRef.SimpleTypeRef(instTypeName);
					struct.addDeclaration(decl(holderStruct));
				}
			}
			String instName = name;//"_";
			struct.addDeclaration(new VariablesDeclaration(instType, new Declarator.DirectDeclarator(instName)).addModifiers(Modifier.Private, Modifier.Static));
			VariableRef instRef = new VariableRef(instName);
			Expression ptrExpr = methodCall(
				cast(
					typeRef(NativeLibrary.class),
					memberRef(
						expr(typeRef(callerLibraryName)), 
						MemberRefStyle.Dot, 
						"INSTANCE"
					)
				).setParenthesis(true),
				MemberRefStyle.Dot,
				"getGlobalVariableAddress",
				expr(Expression.Constant.Type.String, name)
			);
			List<Statement> initStats = new ArrayList<Statement>();
			initStats.add(new Statement.ExpressionStatement(
				expr(
					instRef.clone(),
					Expression.AssignmentOperator.Equal,
					isPtr ? ptrExpr :
					isByRef ? new Expression.New(instType) :
					new Expression.New(instType, new Expression.FunctionCall(null, ptrExpr, hasOffset ? expr(Expression.Constant.Type.Int, 0) : null))
				)
			));
			if (isByRef)
				initStats.add(new Statement.ExpressionStatement(methodCall(instRef, MemberRefStyle.Dot, "setPointer", ptrExpr)));

			struct.addDeclaration(new Function(Function.Type.JavaMethod, "get", instType).setBody(new Statement.Block(
				new Statement.If(
					expr(instRef, Expression.BinaryOperator.IsEqual, nullExpr()),
					initStats.size() == 1 ? initStats.get(0) : new Statement.Block(initStats),
					null
				),
				new Statement.Return(instRef.clone())
			)).addModifiers(Modifier.Public, Modifier.Static, Modifier.Synchronized));
			out.addDeclaration(decl(struct));
		}
	}

	public void convertGlobals(List<VariablesDeclaration> list, Signatures signatures, DeclarationsHolder out, String libraryNameExpression) {		
		if (list == null)
			return;
		
		for (VariablesDeclaration v : list) {
			try {
				convertGlobals(v, signatures, out, libraryNameExpression);
			} catch (UnsupportedConversionException ex) {
				out.addDeclaration(result.declarationsConverter.skipDeclaration(v, ex.toString()));
			}
		}
	}
}
