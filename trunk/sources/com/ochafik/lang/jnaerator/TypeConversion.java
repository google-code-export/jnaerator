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

import java.nio.Buffer;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.rococoa.cocoa.foundation.NSClass;
import org.rococoa.cocoa.foundation.NSObject;

import com.ochafik.lang.SyntaxUtils;
import static com.ochafik.lang.SyntaxUtils.*;

import com.ochafik.lang.jnaerator.JNAeratorConfig.GenFeatures;
import com.ochafik.lang.jnaerator.parser.Arg;
import com.ochafik.lang.jnaerator.parser.Declaration;
import com.ochafik.lang.jnaerator.parser.Define;
import com.ochafik.lang.jnaerator.parser.Element;
import com.ochafik.lang.jnaerator.parser.Enum;
import com.ochafik.lang.jnaerator.parser.Expression;
import com.ochafik.lang.jnaerator.parser.Function;
import com.ochafik.lang.jnaerator.parser.Identifier;
import com.ochafik.lang.jnaerator.parser.Modifier;
import com.ochafik.lang.jnaerator.parser.Scanner;
import com.ochafik.lang.jnaerator.parser.Struct;
import com.ochafik.lang.jnaerator.parser.TypeRef;
import com.ochafik.lang.jnaerator.parser.Declarator;
import com.ochafik.lang.jnaerator.parser.VariablesDeclaration;
import com.ochafik.lang.jnaerator.parser.Enum.EnumItem;
import com.ochafik.lang.jnaerator.parser.Expression.AssignmentOp;
import com.ochafik.lang.jnaerator.parser.Expression.AssignmentOperator;
import com.ochafik.lang.jnaerator.parser.Expression.BinaryOp;
import com.ochafik.lang.jnaerator.parser.Expression.Cast;
import com.ochafik.lang.jnaerator.parser.Expression.Constant;
import com.ochafik.lang.jnaerator.parser.Expression.FunctionCall;
import com.ochafik.lang.jnaerator.parser.Expression.MemberRef;
import com.ochafik.lang.jnaerator.parser.Expression.MemberRefStyle;
import com.ochafik.lang.jnaerator.parser.Expression.New;
import com.ochafik.lang.jnaerator.parser.Expression.TypeRefExpression;
import com.ochafik.lang.jnaerator.parser.Expression.UnaryOp;
import com.ochafik.lang.jnaerator.parser.Expression.UnaryOperator;
import com.ochafik.lang.jnaerator.parser.Expression.VariableRef;
import com.ochafik.lang.jnaerator.parser.Identifier.SimpleIdentifier;
import com.ochafik.lang.jnaerator.parser.StoredDeclarations.TypeDef;
import com.ochafik.lang.jnaerator.parser.TypeRef.ArrayRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.FunctionSignature;
import com.ochafik.lang.jnaerator.parser.TypeRef.Pointer;
import com.ochafik.lang.jnaerator.parser.TypeRef.Primitive;
import com.ochafik.lang.jnaerator.parser.TypeRef.SimpleTypeRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.TaggedTypeRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.TargettedTypeRef;
import com.ochafik.lang.jnaerator.parser.Declarator.ArrayDeclarator;
import com.ochafik.lang.jnaerator.parser.Declarator.PointerStyle;
import com.ochafik.lang.jnaerator.runtime.StringPointer;
import com.ochafik.lang.jnaerator.runtime.WStringPointer;
import com.ochafik.lang.jnaerator.runtime.globals.Global;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalByte;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalDouble;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalFloat;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalInt;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalLong;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalNativeLong;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalShort;
import com.ochafik.util.listenable.Pair;
import com.ochafik.util.string.StringUtils;
import com.sun.jna.NativeLong;
import com.sun.jna.WString;
import com.sun.jna.ptr.ByReference;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.DoubleByReference;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import com.sun.jna.ptr.NativeLongByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.ptr.ShortByReference;

import static com.ochafik.lang.jnaerator.parser.ElementsHelper.*;

public class TypeConversion {
	Result result;

	public boolean allowUnknownPointers = true, allowFakePointers = false;
	
	public TypeConversion(Result result) {
		super();
		this.result = result;
	}
	
	//public Set<Identifier> fakePointersSink;

	enum TypeConversionMode {
		PrimitiveParameter, 
		NativeParameter,
		BufferParameter,
		FieldType, 
		ReturnType, 
		ExpressionType, 
		StaticallySizedArrayField, 
		PrimitiveReturnType, PointedValue
	}
	static Map<JavaPrim, Class<? extends ByReference>> primToByReference = new HashMap<JavaPrim, Class<? extends ByReference>>();
	static Map<JavaPrim, Class<? extends Global>> primToGlobal = new HashMap<JavaPrim, Class<? extends Global>>();
	static Map<JavaPrim, Class<? extends Buffer>> primToBuffer = new HashMap<JavaPrim, Class<? extends Buffer>>();
	static final Set<String> byReferenceClassesNames = new HashSet<String>();
	
	static Map<String, JavaPrim> javaPrims = new TreeMap<String, JavaPrim>();
	static void prim(String from, JavaPrim to) {
		javaPrims.put(from, to);
	}
	
	public static boolean isObjCppPrimitive(String s) {
		return javaPrims.containsKey(s);
	}
	enum JavaPrim {
		Void, 
		Char, 
		Long, 
		Int, 
		Short, 
		Byte, 
		Boolean, 
		Float, 
		Double, 
		NativeLong;
	}
	static {
		prim("void", JavaPrim.Void);
		
		prim("UTF32Char", JavaPrim.Char);
		prim("unichar", JavaPrim.Char);
		
		prim("int64_t", JavaPrim.Long);
		prim("uint64_t", JavaPrim.Long);
		prim("u_int64_t", JavaPrim.Long);
		prim("long long", JavaPrim.Long);
		prim("long long int", JavaPrim.Long);
		prim("long int", JavaPrim.Int);
		prim("LONGLONG", JavaPrim.Long);
		prim("ULONGLONG", JavaPrim.Long);
		prim("DWORD64", JavaPrim.Long);
		prim("LONG64", JavaPrim.Long);
		prim("UInt64", JavaPrim.Long);
		prim("SInt64", JavaPrim.Long);
		prim("__int64", JavaPrim.Long);
		prim("__int64_t", JavaPrim.Long);
		
		prim("int32_t", JavaPrim.Int);
		prim("uint32_t", JavaPrim.Int);
		prim("__int32_t", JavaPrim.Int);
		prim("__uint32_t", JavaPrim.Int);
		prim("u_int32_t", JavaPrim.Int);
		prim("uint32", JavaPrim.Int);
		prim("int32", JavaPrim.Int);
		prim("int", JavaPrim.Int);
		prim("NSUInteger", JavaPrim.Int);
		prim("NSInteger", JavaPrim.Int);
		prim("SInt32", JavaPrim.Int);
		prim("UInt32", JavaPrim.Int);
		prim("GLint", JavaPrim.Int);
		prim("GLuint", JavaPrim.Int);
		prim("GLenum", JavaPrim.Int);
		prim("GLsizei", JavaPrim.Int);
		prim("__darwin_size_t", JavaPrim.Int);
		
		prim("DWORD", JavaPrim.Int);
		prim("__int32", JavaPrim.Int);
		
		prim("long", JavaPrim.NativeLong);
		prim("LONG", JavaPrim.NativeLong);
		prim("size_t", JavaPrim.NativeLong);
		prim("ptrdiff_t", JavaPrim.NativeLong);
		
		prim("int16_t", JavaPrim.Short);
		prim("uint16_t", JavaPrim.Short);
		prim("__int16_t", JavaPrim.Short);
		prim("__uint16_t", JavaPrim.Short);
		prim("u_int16_t", JavaPrim.Short);
		prim("uint16", JavaPrim.Short);
		prim("int16", JavaPrim.Short);
		prim("SInt16", JavaPrim.Short);
		prim("UInt16", JavaPrim.Short);
		prim("short", JavaPrim.Short);
		prim("WCHAR", JavaPrim.Short);
		prim("wchar_t", JavaPrim.Short);
		
		prim("WORD", JavaPrim.Short);
		prim("__int16", JavaPrim.Short);
		
		
		prim("int8_t", JavaPrim.Byte);
		prim("uint8_t", JavaPrim.Byte);
		prim("u_int8_t", JavaPrim.Byte);
		prim("__uint8_t", JavaPrim.Byte);
		prim("__int8_t", JavaPrim.Byte);
		prim("SInt8", JavaPrim.Byte);
		prim("UInt8", JavaPrim.Byte);
		prim("char", JavaPrim.Byte);
		prim("unsigned char", JavaPrim.Byte);
		prim("__unsigned char", JavaPrim.Byte);
		prim("signed char", JavaPrim.Byte);
		prim("__signed char", JavaPrim.Byte);
		prim("SignedByte", JavaPrim.Byte);

		prim("BYTE", JavaPrim.Byte);
		prim("__int8", JavaPrim.Byte);
		
		prim("float", JavaPrim.Float);
		prim("NSFloat", JavaPrim.Float);
		prim("CGFloat", JavaPrim.Float);
		
		prim("double_t", JavaPrim.Double);
		prim("double", JavaPrim.Double);
		prim("NSDouble", JavaPrim.Double);
		prim("CGDouble", JavaPrim.Double);
		
		prim("BOOL", JavaPrim.Boolean);
		prim("bool", JavaPrim.Boolean);
		prim("Boolean", JavaPrim.Boolean);
		prim("boolean_t", JavaPrim.Boolean);
		
		
		
		primToByReference.put(JavaPrim.Int, IntByReference.class);
		primToByReference.put(JavaPrim.Short, ShortByReference.class);
		primToByReference.put(JavaPrim.Byte, ByteByReference.class);
		primToByReference.put(JavaPrim.Long, LongByReference.class);
		primToByReference.put(JavaPrim.Float, FloatByReference.class);
		primToByReference.put(JavaPrim.Double, DoubleByReference.class);
		primToByReference.put(JavaPrim.NativeLong, NativeLongByReference.class);
		//primsByReference.put(JavaPrim.Void, PointerByReference.class);
		for (Class<?> c : primToByReference.values())
			byReferenceClassesNames.add(c.getName());
//		byReferenceClassesNames.add(PointerByReference.class.getName());
		
		primToGlobal.put(JavaPrim.Int, GlobalInt.class);
		primToGlobal.put(JavaPrim.Short, GlobalShort.class);
		primToGlobal.put(JavaPrim.Byte, GlobalByte.class);
		primToGlobal.put(JavaPrim.Long, GlobalLong.class);
		primToGlobal.put(JavaPrim.Float, GlobalFloat.class);
		primToGlobal.put(JavaPrim.Double, GlobalDouble.class);
		primToGlobal.put(JavaPrim.NativeLong, GlobalNativeLong.class);
		
		primToBuffer.put(JavaPrim.Int, IntBuffer.class);
		primToBuffer.put(JavaPrim.Short, ShortBuffer.class);
		primToBuffer.put(JavaPrim.Byte, ByteBuffer.class);
		primToBuffer.put(JavaPrim.Long, LongBuffer.class);
		primToBuffer.put(JavaPrim.Float, FloatBuffer.class);
		primToBuffer.put(JavaPrim.Double, DoubleBuffer.class);
		//primToBuffer.put(JavaPrim.NativeLong, NativeLongByReference.class);
		
	}
	
	static Map<String, TypeRef> manualTypeDefs = new HashMap<String, TypeRef>();
	static {
		
		manualTypeDefs.put("DWORD_PTR", new TypeRef.Pointer(new TypeRef.Primitive("int"), PointerStyle.Pointer));
		manualTypeDefs.put("PDWORD", new TypeRef.Pointer(new TypeRef.Primitive("int"), PointerStyle.Pointer));
		manualTypeDefs.put("PWORD", new TypeRef.Pointer(new TypeRef.Primitive("short"), PointerStyle.Pointer));
		manualTypeDefs.put("intptr_t", new TypeRef.Pointer(new TypeRef.Primitive("int"), PointerStyle.Pointer));
		manualTypeDefs.put("uintptr_t", new TypeRef.Pointer(new TypeRef.Primitive("int").addModifiers(Modifier.Unsigned), PointerStyle.Pointer));
		manualTypeDefs.put("ptr_t", new TypeRef.Pointer(new TypeRef.Primitive("void"), PointerStyle.Pointer));
		manualTypeDefs.put("LONG_PTR", new TypeRef.Pointer(new TypeRef.Primitive("long"), PointerStyle.Pointer));
		manualTypeDefs.put("ULONG_PTR", new TypeRef.Pointer(new TypeRef.Primitive("long").addModifiers(Modifier.Unsigned), PointerStyle.Pointer));
		manualTypeDefs.put("INT_PTR", new TypeRef.Pointer(new TypeRef.Primitive("int"), PointerStyle.Pointer));
		manualTypeDefs.put("UINT_PTR", new TypeRef.Pointer(new TypeRef.Primitive("int").addModifiers(Modifier.Unsigned), PointerStyle.Pointer));
		manualTypeDefs.put("PVOID", new TypeRef.Pointer(new TypeRef.Primitive("void"), PointerStyle.Pointer));

		prim("LONG_PTR", JavaPrim.NativeLong);
		prim("ULONG_PTR", JavaPrim.NativeLong);
		
		manualTypeDefs.put("SIZE", new TypeRef.Primitive("size_t"));
		manualTypeDefs.put("CHAR", new TypeRef.Primitive("char"));
		manualTypeDefs.put("BOOL", new TypeRef.Primitive("bool"));
		manualTypeDefs.put("WCHAR", new TypeRef.Primitive("wchar_t"));
		manualTypeDefs.put("HRESULT", new TypeRef.Pointer(new TypeRef.Primitive("long"), PointerStyle.Pointer));		
		manualTypeDefs.put("LPCSTR", new TypeRef.Pointer(new TypeRef.Primitive("char").addModifiers(Modifier.Const), PointerStyle.Pointer));
		manualTypeDefs.put("LPCWSTR", new TypeRef.Pointer(new TypeRef.Primitive("wchar_t").addModifiers(Modifier.Const), PointerStyle.Pointer));
		manualTypeDefs.put("LPSTR", new TypeRef.Pointer(new TypeRef.Primitive("char"), PointerStyle.Pointer));
		manualTypeDefs.put("LPWSTR", new TypeRef.Pointer(new TypeRef.Primitive("wchar_t"), PointerStyle.Pointer));
		manualTypeDefs.put("PCSTR", new TypeRef.Pointer(new TypeRef.Primitive("char").addModifiers(Modifier.Const), PointerStyle.Pointer));
		manualTypeDefs.put("PCWSTR", new TypeRef.Pointer(new TypeRef.Primitive("wchar_t").addModifiers(Modifier.Const), PointerStyle.Pointer));
		manualTypeDefs.put("PSTR", new TypeRef.Pointer(new TypeRef.Primitive("char"), PointerStyle.Pointer));
		manualTypeDefs.put("PWSTR", new TypeRef.Pointer(new TypeRef.Primitive("wchar_t"), PointerStyle.Pointer));
		
//		manualTypeDefs.put("LPSTR", new TypeRef.Pointer(new TypeRef.Primitive("char"), PointerStyle.Pointer));
		manualTypeDefs.put("PBYTE", new TypeRef.Pointer(new TypeRef.Primitive("char"), PointerStyle.Pointer));
		//manualTypeDefs.put("LONG_PTR", new TypeRef.Pointer(new TypeRef.Primitive("long", "long"), StorageModifier.Pointer));
		//manualTypeDefs.put("ULONG_PTR", new TypeRef.Pointer(new TypeRef.Primitive("long", "long", "unsigned"), StorageModifier.Pointer));
		
	}
	
	public Pair<TypeDef,Declarator> getTypeDef(Identifier name) {
		if (name == null)
			return null;
		
		Pair<TypeDef,Declarator> p = result.typeDefs.get(name);
		if (p == null)
			return null;
		
		Declarator value = p.getValue();
		String rname = value == null ? null : value.resolveName();
		if (rname != null) {
			if (name.equals("id"))
				return null;
			
			if (name.equals("SEL"))
				return null;

			if (name.equals("IMP"))
				return null;
			
			if (name.equals("BOOL"))
				if (rname.equals("byte"))
					return null;
		}
		return p;
	}
	public TypeRef resolveTypeDef(TypeRef valueType, final Identifier libraryClassName, final boolean convertToJavaRef) {
		if (valueType == null)
			return null;
		
//		if (valueType.toString().equals("CGFunctionEvaluateCallback"))
//			valueType = valueType;
		
		final TypeRef valueTypeCl = valueType.clone();
		Arg holder = new Arg();
		holder.setValueType(valueTypeCl);
		valueTypeCl.accept(new Scanner() {
			java.util.Stack<String> names = new java.util.Stack<String>();
			int depth = 0;
			@Override
			public void visitSimpleTypeRef(SimpleTypeRef simpleTypeRef) {
				depth++;
				
				try {
					Identifier name = ((SimpleTypeRef) simpleTypeRef).getName();
					if (name == null)
						return;
					
					String nameStr = name.toString();
					if (nameStr == null)
						return;
					
					if (names.contains(nameStr))
						return;
					names.push(nameStr);
					
					try {
						if (resolvesToPrimitive(nameStr))
							return;
						
						super.visitSimpleTypeRef(simpleTypeRef);
						if (simpleTypeRef.isMarkedAsResolved())
							return;
						
	//					Identifier oc = findObjCClassIdent(name);
	//					if (oc != null) {
	//						name.replaceBy(oc);
	//					}
						
						Pair<TypeDef,Declarator> p = getTypeDef(name);
						if (p != null) {
							TypeRef tr = p.getFirst().getValueType();//as(p.getSecond().mutateType(p.getFirst().getValueType()), TypeRef.class);
							if (tr instanceof TaggedTypeRef) {
								Identifier name2 = result.declarationsConverter.getActualTaggedTypeName((TaggedTypeRef)tr);
								if (name2 != null)
									name = name2;
							}
							if (convertToJavaRef) {
								if (tr instanceof TaggedTypeRef) {
									TaggedTypeRef s = (TaggedTypeRef)tr;
									if (s.isForwardDeclaration())
										return;
									
									if (tr instanceof Enum) {
										tr = typeRef(s.getTag().clone());
									} else {
										Identifier ident = result.getTaggedTypeIdentifierInJava(s);
										if (ident != null)
											tr = typeRef(ident);//findRef(name, s, libraryClassName));
									}
								} else if (tr instanceof FunctionSignature) {
									tr = findCallbackRef((FunctionSignature)tr, libraryClassName);
								}
							}
							if (tr != null && !simpleTypeRef.toString().equals(tr.toString())) {
								simpleTypeRef.replaceBy(tr.clone());
								if (depth < 10) {
//									tr.accept(this);
								} else {
									System.err.println("Infinite loop in type conversion ? " + tr);
								}
							}
							return;
						}
						
						TypeRef manualTypeRef = manualTypeDefs.get(name);
						if (manualTypeRef != null) {
							if (!convertToJavaRef)
								return;
							simpleTypeRef.replaceBy(manualTypeRef);
							return;
						}
						
						TypeRef structRef = typeRef(result.typeConverter.findStructRef(name, libraryClassName));
						if (structRef != null) {
							if (!convertToJavaRef)
								return;
							simpleTypeRef.replaceBy(structRef);
						}
						
						Define define = result.defines.get(name);
						Expression expression = define == null ? null : define.getValue();
						if (expression != null) {
							if (!convertToJavaRef)
								return;
							Identifier fieldName = null;
							if (expression instanceof Expression.VariableRef) 
								fieldName = ((Expression.VariableRef) expression).getName();
							else if (expression instanceof MemberRef)
								fieldName = ((MemberRef) expression).getName();
							
							if (fieldName != null && !fieldName.equals(name)) {
								simpleTypeRef.replaceBy(resolveTypeDef(new TypeRef.SimpleTypeRef(fieldName), libraryClassName, true));
								return;
							}
						}
					} finally {
						names.pop();
					}
				} finally {
					depth--;
				}
			}
		});
		TypeRef tr = holder.getValueType();
//		tr.setParentElement(valueType.getParentElement());
		return tr;// == null ? null : tr.clone();
	}
	
	public static boolean resolvesToPrimitive(String name) {
		return javaPrims.containsKey(name);
	}
//	TypeRef getPrimitiveRef(TypeRef valueType, String callerLibraryClass) {
//		JavaPrim prim = getPrimitive(valueType, callerLibraryClass);
//		if (prim == null)
//			return null;
//		
//		TypeRef tr = typeRef(prim);
//		if (valueType.isUnsigned())
//			tr.addAnnotation(new Annotation(Unsigned.class));
//		if (valueType.isUnsigned())
//			tr.addAnnotation(new Annotation(Unsigned.class));
//		
//		return tr;
//	}
		
	public static class JavaPrimitive extends Primitive {
		JavaPrim javaPrim;
		public JavaPrimitive() {}
		public JavaPrimitive(JavaPrim javaPrim) {
			super(javaPrim.toString());
			this.javaPrim = javaPrim;
		}
		public JavaPrim getJavaPrim() {
			return javaPrim;
		}
		public void setJavaPrim(JavaPrim javaPrim) {
			this.javaPrim = javaPrim;
		}
		@Override
		public String toString(CharSequence indent) {
			return toPrimString(javaPrim);
		}
	}
	
	
	JavaPrim getPrimitive(TypeRef valueType, Identifier libraryClassName) {
		
		valueType = resolveTypeDef(valueType, libraryClassName, true);
		if (valueType == null)
			return null;
		Identifier name = null;
		List<Modifier> mods = valueType.getModifiers();
		int longCount = Modifier.Long.countIn(mods);
		if (valueType instanceof JavaPrimitive) {
			return ((JavaPrimitive)valueType).getJavaPrim();
		}
		if (valueType instanceof Primitive) {
			name = ((Primitive)valueType).getName();
			if (name == null) {
				if (longCount == 1)
					name = ident("long");
				else if (longCount > 1)
					name = ident("long long");
				else if (Modifier.Short.isContainedBy(mods))
					name = ident("short");
				else
					name = ident("int");
			}
		} else if (valueType instanceof SimpleTypeRef)
			name = ((SimpleTypeRef) valueType).getName();
		
		
		if (name == null)
			return null;
		
		if (name.equals(NativeLong.class.getName()))
			return JavaPrim.NativeLong;
		
		boolean isLong = false;
		String str;
		if ((isLong = valueType.getModifiers().contains("long")) || valueType.getModifiers().contains("short"))
			str = (isLong ? "long " : "short ") + name;
		else
			str = name.toString();
		
		JavaPrim type = javaPrims.get(str);
		if (type == JavaPrim.Int && longCount > 1)
			return JavaPrim.Long;
		
		return type;
	}
	
	public Identifier findStructRef(Identifier name, Identifier libraryClassName) {
		return findStructRef(result.structsByName.get(name), name, libraryClassName);
	}
	
	public Identifier findStructRef(Struct s, Identifier name, Identifier libraryClassName) {
		if (s == null || s.isForwardDeclaration()) {
			Pair<TypeDef, Declarator> pair = getTypeDef(name);
			if (pair == null)
				return null;
			if (pair.getFirst() == null || pair.getSecond() == null)
				return null;
			Object td = pair.getSecond().mutateType(pair.getFirst().getValueType());
			if (!(td instanceof Struct))
				return null;
			s = (Struct)td;
			name = result.declarationsConverter.getActualTaggedTypeName((TaggedTypeRef)pair.getFirst().getValueType());
			
			return findRef(name, s, libraryClassName, !result.config.putTopStructsInSeparateFiles);
		} else {
			return result.getTaggedTypeIdentifierInJava(s);
			//name = result.declarationsConverter.getActualTaggedTypeName(s);
		}
	}
	public Identifier findStructRef(Struct s, Identifier libraryClassName) {
		return findStructRef(s, result.declarationsConverter.getActualTaggedTypeName(s), libraryClassName);	
	}
//	public String find(String name, Element e, String callerLibraryClass) {
//		if (e == null)
//			return null;
//		String library = result.getLibrary(e);
//		if (library == null)
//			return null;
//		SimpleIdentifier libClass = result.getLibraryClassFullName(library);
//		return SyntaxUtils.equal(libClass, callerLibraryClass) ? name : libClass + "." + name;
//	}
	public Identifier libMember(Identifier libClass, Identifier libraryClassName, Identifier member) {
		//return ident(SyntaxUtils.equal(libClass, libraryClassName) ? null : libClass, member);
		return ident(libClass, member);
		//return member; //TODODODODODODODODOoOOOOO
	}
	public Identifier findRef(Identifier name, Element e, Identifier libraryClassName, boolean inLibClass) {
		if (e == null || !name.isPlain())
			return null;
		String library = result.getLibrary(e);
		if (library == null)
			return null;
		
//		e = e.getParentElement();
		Struct parentStruct = e instanceof Struct ? (Struct)e : e.findParentOfType(Struct.class);
		if (!inLibClass && parentStruct != null) {
			if (parentStruct == e)
				return ident(result.getLibraryPackage(library), name);
			
			return ident(result.getTaggedTypeIdentifierInJava(parentStruct), name);
		}
		return libMember(result.getLibraryClassFullName(library), libraryClassName, name);
	}
	public SimpleTypeRef findEnum(Identifier name, Identifier libraryClassName) {
		Enum s = result.enumsByName.get(name);
		if (s == null)
			return null;
		
		name = result.declarationsConverter.getActualTaggedTypeName(s);
		
		String library = result.getLibrary(s);
		if (library == null)
			return null;
		Identifier libClass = result.getLibraryClassFullName(library);
		//return new SimpleTypeRef(SyntaxUtils.equal(libClass, callerLibraryClass) ? name : libClass + "." + name);
		
		SimpleTypeRef tr = new SimpleTypeRef("int");
		if (result.config.features.contains(JNAeratorConfig.GenFeatures.EnumTypeLocationComments))
			tr.setCommentBefore("@see " + (SyntaxUtils.equal(libClass, libraryClassName) ? name : libClass + "#" + name));
//		if (s.getTag() != null)
//			tr.setCommentBefore("@see enums in " + s.getTag());
		return tr;
	}
	public static Expression javaStaticFieldRef(Identifier javaClass, Identifier fieldName) {
		return memberRef(
				expr(typeRef(javaClass)),
				MemberRefStyle.Dot,
				fieldName
			);
	}
	public Expression findDefine(Identifier name) {
		Define s = result.defines.get(name);
		String library = s == null ? null : result.getLibrary(s);
		return library == null ? null : javaStaticFieldRef(result.getLibraryClassFullName(library), name);
	}
	
	public Identifier inferCallBackName(FunctionSignature functionSignature, boolean prependNamespaces, boolean qualify) {
		List<String> nameElements = new ArrayList<String>();
		Identifier name = functionSignature.getFunction().getName();
		if (name != null)
			name = name.clone();
		
		Identifier parentIdent = null;
		
		Element parent = functionSignature.getParentElement();
		//if (parent == null) {
		//	nameElements.add("Callback");
		//}
		boolean firstParent = true;
		while (parent != null) {
			if (parent instanceof Struct) {
				parentIdent = findStructRef((Struct)parent, null);
				break;
//				Identifier structName = result.declarationsConverter.getActualTaggedTypeName((Struct) parent);
//				if (structName != null) {
////					if (firstParent) {
//						parentIdent = findStructRef(structName, null); 
//						break;
////					} else
////						nameElements.add(0, structName.toString());
//				}
			} else if (firstParent) {
				if (name == null && parent instanceof TypeDef) {
					Declarator simpleSto = null;
					for (Declarator sto : ((TypeDef)parent).getDeclarators()) {
						String stoName = sto.resolveName();
						if (stoName == null)
							continue;
						
						if (!(sto instanceof ArrayDeclarator)) {
						//TODO check if properly refactored : if (sto.getDimensions().isEmpty() && sto.getStorageModifiers().isEmpty()) {
							boolean weirdName = stoName.startsWith("_");
							if (simpleSto == null || simpleSto.resolveName().startsWith("_") && !weirdName)
								simpleSto = sto;
							
							if (!weirdName)
								break;
						}
						if (stoName != null)
							name = new SimpleIdentifier(stoName);
					}
				} else if (name == null && parent instanceof Arg) {
					Arg arg = (Arg) parent;
					Function f = SyntaxUtils.as(arg.getParentElement(), Function.class);
					if (f != null) {
						name = new SimpleIdentifier(f.getName() + "_" + arg.getName());
						break;
					}
				} else if (firstParent) {
//					if (//parent instanceof VariablesDeclaration || 
//							parent instanceof FunctionPointerDeclaration
//							//|| parent instanceof TypeDef
//					) {
//						nameElements.add("Callback");
//					}
				}
			}
			parent = parent.getParentElement();
			firstParent = false;
		}
		
		if (qualify && parentIdent == null) {
			String library = result.getLibrary(functionSignature);
			if (library != null)
				parentIdent = result.getLibraryClassFullName(library);
		}
		
		if (prependNamespaces) {
			if (name == null)
				name = new SimpleIdentifier("callback");
			
			nameElements.add(name.toString());
			return ident(qualify ? parentIdent : null, StringUtils.implode(nameElements, "_"));
		} else {
			return ident(qualify ? parentIdent : null, name);
		}
	}
	
	public TypeRef findCallbackRef(Identifier name, Identifier libraryClassName) {
		FunctionSignature s = result.callbacksByName.get(name);
		if (s == null)
			return null;
		
		String library = result.getLibrary(s);
		if (library == null)
			return null;
	
//		Struct parentStruct = s.findParentOfType(Struct.class);
//		if (parentStruct != null && (parentStruct.getType() == Struct.Type.ObjCClass || parentStruct.getType() == Struct.Type.ObjCProtocol)) {
//			//Identifier structName = result.declarationsConverter.getActualTaggedTypeName(parentStruct);
//			return //result.result.getObjCClass(parentStruct.getName()).
//				typeRef(//libMember(structName, libraryClassName, 
//						inferCallBackName(s, true, true)//)
//						);
//		}
		return typeRef(//libMember(result.getLibraryClassFullName(library), libraryClassName, 
				inferCallBackName(s, true, true)//)
				);
	}
	
	public TypeRef findCallbackRef(FunctionSignature s, Identifier callerLibraryClass) {
		String library = result.getLibrary(s);
		if (library == null)
			return null;
	
//		Struct parentStruct = s.findParentOfType(Struct.class);
//		if (parentStruct != null && (parentStruct.getType() == Struct.Type.ObjCClass || parentStruct.getType() == Struct.Type.ObjCProtocol)) {
//			Identifier structName = result.declarationsConverter.getActualTaggedTypeName(parentStruct);
//			return
//				typeRef(ident(structName, inferCallBackName(s, true, true)));
//		}
		return typeRef(inferCallBackName(s, true, true));
//		return typeRef(libMember(result.getLibraryClassFullName(library), callerLibraryClass, inferCallBackName(s, true, true)));
		//typeRef(ident(result.getLibraryClassFullName(library), inferCallBackName(s, true)));	
	}
	static TypeRef primRef(JavaPrim p) {
		return new JavaPrimitive(p);
//		return new SimpleTypeRef(toString(p));
	}
	boolean isResolved(SimpleTypeRef tr) {
		return tr.isMarkedAsResolved() || isResolved(tr.getName());
	}
	boolean isResolved(Identifier i) {
		if (i.isPlain())
			return false;
		return (i instanceof Identifier.QualifiedIdentifier) && 
			Identifier.QualificationSeparator.Dot.equals(((Identifier.QualifiedIdentifier)i).getSeparator());
	}
	TypeRef convertTypeToJNA(TypeRef valueType, TypeConversionMode conversionMode, Identifier libraryClassName) throws UnsupportedConversionException {
		
//		if (String.valueOf(valueType).contains("PDWORD"))
//			valueType = valueType;
		
		TypeRef original = valueType; 
		valueType =  resolveTypeDef(valueType, libraryClassName, true);
		
		String valueTypeString = String.valueOf(valueType);
		
		if (valueTypeString.matches("void\\s*\\*") || valueTypeString.matches("const\\s*void\\s*\\*")) {
			//valueType = (TypeRef)valueType;
			if (original instanceof Pointer && result.config.features.contains(GenFeatures.TypedPointersForForwardDeclarations) && allowFakePointers) {
				Pointer p = (Pointer) original;
				if (p.getTarget() instanceof SimpleTypeRef) {
					if (isResolved((SimpleTypeRef)p.getTarget()))
							return p.getTarget();
					
					Identifier name = ((SimpleTypeRef)p.getTarget()).getName();
					if (!"void".equals(name.toString()) && name.isPlain()) {
//						int i = name.lastIndexOf('.');
//						if (i >= 0)
//							name = name.substring(i + 1);
						return typeRef(result.getFakePointer(libraryClassName, name));
					}
				}
			}
		} else {
			if (conversionMode == TypeConversionMode.BufferParameter ||
					conversionMode == TypeConversionMode.PrimitiveParameter) 
			{
				if (valueTypeString.matches("(__)?const char\\*"))
					return typeRef(String.class);
				else if (valueTypeString.matches("(__)?const wchar_t\\*"))
					return typeRef(WString.class);
				else if (valueTypeString.matches("(__)?const char\\*\\*"))
					return arrayRef(typeRef(String.class));
				else if (valueTypeString.matches("(__)?const wchar_t\\*\\*"))
					return arrayRef(typeRef(WString.class));
				else if (conversionMode == TypeConversionMode.PrimitiveParameter) {
					if (valueTypeString.matches("char\\*"))
						return typeRef(StringPointer.ByValue.class);
					else if (valueTypeString.matches("wchar_t\\*"))
						return typeRef(WStringPointer.ByValue.class);
				}
			}
		}
		
		if (valueType instanceof Primitive) {
			JavaPrim prim = getPrimitive(valueType, libraryClassName);
			if (prim != null)
				return primRef(prim);
			
//			if (!valueType.getModifiers().contains("long"))
//				return valueType.toString();
		} 
		if (valueType instanceof TaggedTypeRef) {
			Identifier name = result.declarationsConverter.getActualTaggedTypeName((TaggedTypeRef) valueType);
			if (name != null) {
				if (valueType instanceof Enum) {
					TypeRef tr = findEnum(name, libraryClassName);
					if (tr != null) {
						TypeRef intRef = primRef(JavaPrim.Int);
						intRef.setCommentBefore(tr.getCommentBefore());
						return intRef;
					}
				} else if (valueType instanceof Struct) {
					Identifier tr = findStructRef(name, libraryClassName);
					if (tr != null) {
						switch (conversionMode) {
						case PointedValue:
						case BufferParameter:
						case NativeParameter:
						case PrimitiveParameter:
						case ReturnType:
						case PrimitiveReturnType:
						case FieldType:
							return typeRef(tr);
						case StaticallySizedArrayField:
						case ExpressionType:
						default:
							return typeRef(ident(tr, ident("ByValue")));
						}
					}
				}
			}
		}
		
		if (valueType instanceof FunctionSignature) {
			TypeRef tr = findCallbackRef((FunctionSignature)valueType, libraryClassName);
			if (tr != null)
				return tr;
			else
				return typeRef(((FunctionSignature)valueType).getFunction().getName().clone());
		}
		if (valueType instanceof TargettedTypeRef) {
			//TypeRef target = resolveTypeDef(((TargettedTypeRef) valueType).getTarget(), callerLibraryClass);
			TypeRef target = ((TargettedTypeRef) valueType).getTarget();
			
			boolean staticallySized = valueType instanceof ArrayRef && ((ArrayRef)valueType).hasStaticStorageSize();
			
			TypeRef convArgType = null;
			JavaPrim prim = getPrimitive(target, libraryClassName);
			if (prim != null) {
				if (prim == JavaPrim.Void)
					return typeRef(com.sun.jna.Pointer.class);
				else
					convArgType = primRef(prim);
			} else {
				Identifier name = null;
				if (target instanceof SimpleTypeRef)
					name = ((SimpleTypeRef) target).getName();
				else if (target instanceof Struct) {
					Struct struct = (Struct)target;
					if (struct == null) {
						valueType =  resolveTypeDef(original, libraryClassName, true);
						struct = null;
					} else {
						name = result.declarationsConverter.getActualTaggedTypeName(struct);
					}
				} else if (target instanceof FunctionSignature) {
					TypeRef tr = findCallbackRef((FunctionSignature)target, libraryClassName);
					if (tr != null) {
						if (valueType instanceof TypeRef.ArrayRef) {
							return new TypeRef.ArrayRef(tr);
						} else {
							return tr;
						}
					}
					//else
					//	return typeRef(((FunctionSignature)valueType).getFunction().getName());
				} else if (target instanceof Pointer) {
					Pointer pt = ((Pointer)target);
					TypeRef ptarget = pt.getTarget();
					if (ptarget instanceof SimpleTypeRef) {
						SimpleTypeRef ptargett = (SimpleTypeRef) ptarget;
						if (result.structsFullNames.contains(ptargett.getName())) {
							return new ArrayRef(typeRef(ident(ptargett.getName(), "ByReference")));
						}
					}
				}
				if (name != null) {
					/// Pointer to Objective-C class ?
					convArgType = findObjCClass(name);
					boolean isQualStruct = result.structsFullNames.contains(name);
					if (convArgType == null || isQualStruct) {
						/// Pointer to C structure
						Identifier structRef = isQualStruct ? name : findStructRef(name, libraryClassName);
						if (structRef != null) {//result.cStructNames.contains(name)) {
			 				switch (conversionMode) {
								case ExpressionType:
								case FieldType:
									convArgType = valueType instanceof TypeRef.ArrayRef ?
											typeRef(structRef) :
											typeRef(ident(structRef, ident("ByReference")));
									if (valueType instanceof Pointer)
										return convArgType;
									break;
								default:
									convArgType = typeRef(structRef);
									if (valueType instanceof Pointer)
										return convArgType;
									break;
							}
						} else {
							try {
								convArgType = convertTypeToJNA(target, conversionMode, libraryClassName);
							} catch (UnsupportedConversionException ex) {
								//convArgType = null;//return typeRef(com.sun.jna.Pointer.class);
								if (valueType instanceof TypeRef.Pointer && 
										target instanceof TypeRef.SimpleTypeRef &&
										result.config.features.contains(JNAeratorConfig.GenFeatures.TypedPointersForForwardDeclarations) &&
										allowFakePointers
										) {

									if (isResolved((SimpleTypeRef)target))
										return target;
//									int i = name.lastIndexOf('.');
//									if (i >= 0) {
//										name = name.substring(i + 1);
//									}
									return typeRef(result.getFakePointer(libraryClassName, name));
								} else {
									return typeRef(com.sun.jna.Pointer.class);
								}
							}
						}
					}
				} else {
					try {
						convArgType = convertTypeToJNA(target, conversionMode, libraryClassName);
					} catch (UnsupportedConversionException ex) {
						//convArgType = null;//
						return typeRef(com.sun.jna.Pointer.class);
					}
				}
			}	
			switch (conversionMode) {
				case StaticallySizedArrayField:
					return new ArrayRef(convArgType);
				case PrimitiveParameter:
					if (target.getModifiers().contains(Modifier.Const) ||
							valueType.getModifiers().contains(Modifier.Const))
						return new ArrayRef(convArgType);
				case BufferParameter:
					Class<? extends Buffer> bc = primToBuffer.get(prim);
					if (bc != null) {
						return typeRef(bc);
					}
				case FieldType:
					if (staticallySized) {
						return arrayRef(convArgType);
					}
				default:
					if (prim != null) {
						Class<? extends ByReference> byRefClass = primToByReference.get(prim);
						if (byRefClass != null)
							return typeRef(byRefClass);
					}
					if (convArgType != null && !convArgType.toString().equals(com.sun.jna.Pointer.class.getName()) && valueType instanceof TypeRef.Pointer && target instanceof TypeRef.SimpleTypeRef)
						return convArgType;
					
			}
			if (target instanceof Pointer) {
				return typeRef(PointerByReference.class);
			}
			
			if (allowUnknownPointers)
				return typeRef(com.sun.jna.Pointer.class);
		}
		if (valueType instanceof SimpleTypeRef) {
			Identifier name = ((SimpleTypeRef) valueType).getName();
			if (name == null)
				throw new UnsupportedConversionException(valueType, null);
			
			boolean isQualStruct = result.structsFullNames.contains(name);
				//isQualCallback = result.callbacksFullNames.contains(name);
			if (!isQualStruct && isResolved((SimpleTypeRef) valueType))
				return valueType;
			
			if (name instanceof SimpleIdentifier) {
				SimpleIdentifier sname = (SimpleIdentifier)name;
				String n = sname.getName();
				TypeRef objCClass = null;
				TypeRef tr = findObjCClass(sname);
				if (tr != null)
					return tr;
				
				if (n.equals("id") && sname.getTemplateArguments().size() == 1 && conversionMode != TypeConversionMode.NativeParameter) {
					Expression x = sname.getTemplateArguments().get(0);
					TypeRefExpression trx = x instanceof TypeRefExpression ? (TypeRefExpression)x : null;
					SimpleTypeRef str = trx.getType() instanceof SimpleTypeRef ? (SimpleTypeRef)trx.getType() : null;
					objCClass = findObjCClass(str.getName());
				}

				if (objCClass == null)
					objCClass = findObjCClass(new SimpleIdentifier(n));

				if (objCClass != null)
					return objCClass;
			}
			Identifier structRef = isQualStruct ? name : findStructRef(name, libraryClassName);
			if (structRef != null) {
				switch (conversionMode) {
				case PointedValue:
				case FieldType:
					return typeRef(structRef);
				default:
					return typeRef(ident(structRef, "ByValue"));
				}
			}
			
			TypeRef callbackRef = findCallbackRef(name, libraryClassName);
			if (callbackRef != null)
				return callbackRef;
			
			SimpleTypeRef enumTypeRef = findEnum(name, libraryClassName);
			//FieldRef enumQualifiedName = findEnum(name);
			if (enumTypeRef != null)
				return enumTypeRef;
			
			TypeRef objCClassRef = findObjCClass(name);
			if (objCClassRef != null)
				return objCClassRef;
		}
		
		JavaPrim prim = getPrimitive(valueType, libraryClassName);
		if (prim != null)
			return primRef(prim);
		
		unknownTypes.add(String.valueOf(valueType));
		throw new UnsupportedConversionException(valueType, null);
	}
	static Map<String, Class<?>> predefObjCClasses = new HashMap<String, Class<?>>();
	static {
		predefObjCClasses.put("id", org.rococoa.ID.class);
		predefObjCClasses.put("SEL",org.rococoa.Selector.class);
		predefObjCClasses.put("Class", NSClass.class);
		predefObjCClasses.put("Protocol", NSClass.class);
		predefObjCClasses.put("NSObject", NSObject.class);
		predefObjCClasses.put("NSClass", NSClass.class);
	}
	public Identifier findObjCClassIdent(Identifier name) {
		Class<?> class1 = predefObjCClasses.get(name.toString());
		if (class1 != null)
			return ident(class1);
		
		Struct s = result.getObjcCClassOrProtocol(name);
		if (s != null)
			return result.objectiveCGenerator.getFullClassName(s);
		return null;
	}
	public TypeRef findObjCClass(Identifier name) {
		return typeRef(findObjCClassIdent(name));
	}

	private TypeRef arrayRef(TypeRef tr) {
		ArrayRef arrayRef;
		if (tr instanceof ArrayRef) {
			arrayRef = (ArrayRef)tr;
			arrayRef.addDimension(new Expression.EmptyArraySize());
		} else 
			arrayRef = new ArrayRef(tr);
		return arrayRef;
	}

	Set<String> unknownTypes = new HashSet<String>();

	/*public TypeRef inferJavaType(Expression x) throws UnsupportedTypeConversion {
		if (x instanceof Assignment)
			return inferJavaType(((Assignment)x).getTarget());
		if (x instanceof BinaryOp) {
			TypeRef i1 = inferJavaType(((BinaryOp) x).getFirstOperand()), i2 = inferJavaType(((BinaryOp) x).getSecondOperand());
			String s1 = String.valueOf(i1), s2 = String.valueOf(i2);
			if (s1.equals(s2))
				return i1;
			//TODO implement me ?
			return null;
		}
		if (x instanceof UnaryOp) {
			return inferJavaType(((UnaryOp) x).getOperand());
		}
		if (x instanceof Cast) {
			return new SimpleTypeRef(typeToJNA(((Cast) x).getType(), TypeConversionMode.ReturnType));
		}
		if (x instanceof Constant) {
			String v = ((Constant) x).getValue();
			Class<?> c = null;
			if (v.startsWith("\""))
				c = String.class;
			else if (v.startsWith("'"))
				c = Character.TYPE;
			else if (v.contains("."))
				c = Double.TYPE;
			else
				c = Integer.TYPE;
			
			return new SimpleTypeRef(c.getName());
		}
		if (x instanceof MemberRef) {
			
		}
		if (x instanceof VariableRef) {
			
		}
		return null;
	}*/
	
	public TypeRef inferJavaType(Expression x) throws UnsupportedConversionException {
		if (x instanceof AssignmentOp)
			return inferJavaType(((AssignmentOp)x).getTarget());
		if (x instanceof BinaryOp) {
			TypeRef i1 = inferJavaType(((BinaryOp) x).getFirstOperand()), i2 = inferJavaType(((BinaryOp) x).getSecondOperand());
			String s1 = String.valueOf(i1), s2 = String.valueOf(i2);
			if (s1.equals(s2))
				return i1;
			//TODO implement me ?
			return null;
		}
		if (x instanceof New) {
			return ((New) x).getType();
		}
		if (x instanceof UnaryOp) {
			return inferJavaType(((UnaryOp) x).getOperand());
		}
		if (x instanceof Cast) {
			//TypeRef tr = inferJavaType(((Cast) x).getTarget());
			return ((Cast) x).getType();
		}
		if (x instanceof Constant) {
			Class<?> c = null;
			/*Constant ct = (Constant) x;
			switch (ct.getType()) {
			case Float:
				c = Float.TYPE;
				break;
			case Char:
				c = Character.TYPE;
				break;
			case Integer:
			case IntegerString:
				c = Integer.TYPE;
				break;
			case String:
				c = String.class;
				break;
			}*/
			Constant jc = ((Constant)x).asJava();
			switch (jc.getType()) {
			case Byte:
				c = Byte.TYPE;
				break;
			case Char:
				c = Character.TYPE;
				break;
			case Double:
				c = Double.TYPE;
				break;
			case Float:
				c = Float.TYPE;
				break;
			case Int:
			case UInt:
			case IntegerString:
				c = Integer.TYPE;
				break;
			case ULong:
			case Long:
			case LongString:
				c = Long.TYPE;
				break;
			case Short:
				c = Short.TYPE;
				break;
			case String:
				c = String.class;
				break;
			}
			/*String v = ((Constant) x).getValue().toString().toUpperCase();
			if (v.startsWith("\""))
				c = String.class;
			else if (v.startsWith("'"))
				c = Character.TYPE;
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
			}*/
			if (c != null)
				return new SimpleTypeRef(c.getName());
		}
		if (x instanceof VariableRef) {
			VariableRef vr = (VariableRef)x;
			Identifier n = vr.getName();
			if (n != null && (n.equals("true") || n.equals("false")))
				return primRef(JavaPrim.Boolean);
		}
//		if (x instanceof MemberRef) {
//			return null;
//			//if (x instanceof FieldRef) {
//			//	return new SimpleTypeRef(Integer.TYPE.getName());
//			//}	
//		} else 
		if (x instanceof MemberRef) {
			Identifier name = ((MemberRef)x).getName();
			if (name != null) {
				String sname = name.toString();
				if ("True".equals(sname) || "False".equals(sname))
					return primRef(JavaPrim.Boolean);
			}
			EnumItem enumItem = result.enumItems.get(name);
			if (enumItem != null)
				return typeRef(Integer.TYPE);
		}
		if (x instanceof TypeRefExpression) {
			TypeRefExpression tre = (TypeRefExpression)x;
			TypeRef tr = tre.getType();
			if (tr instanceof SimpleTypeRef) {
				SimpleTypeRef str = (SimpleTypeRef)tr;
				Identifier ident = str.getName();
				if (ident != null) {
					if (result.enumItemsFullName.contains(ident)) {
						return typeRef(Integer.TYPE);
					}
				}
			}
		}
		return null;
	}
	
	public Expression convertExpressionToJava(Expression x, Identifier libraryClassName) throws UnsupportedConversionException {
		Expression res = null;
		if (x instanceof AssignmentOp)
			res = expr(convertExpressionToJava(((AssignmentOp) x).getTarget(), libraryClassName), AssignmentOperator.Equal, ((AssignmentOp) x).getValue());
		else if (x instanceof BinaryOp) {
			res = expr(
				convertExpressionToJava(((BinaryOp) x).getFirstOperand(), libraryClassName),
				((BinaryOp) x).getOperator(),
				convertExpressionToJava(((BinaryOp) x).getSecondOperand(), libraryClassName)
			);
		} else if (x instanceof UnaryOp) {
			UnaryOperator op = ((UnaryOp) x).getOperator();
			if (op == UnaryOperator.Not) {
				throw new UnsupportedConversionException(x, null); // TODO handle this properly ?
			}
			res = expr(op, 
				convertExpressionToJava(((UnaryOp) x).getOperand(), libraryClassName)
			);
		} else if (x instanceof Cast) {
			TypeRef tr = convertTypeToJNA(((Cast) x).getType(), TypeConversionMode.ExpressionType, libraryClassName);
			JavaPrim prim = getPrimitive(tr, libraryClassName);
			Expression casted = convertExpressionToJava(((Cast) x).getTarget(), libraryClassName);
			if (prim == JavaPrim.NativeLong) {
				/*Element parent = x.getParentElement();
				if (parent != null && !(parent instanceof Expression)) {
					/// prevent bug of new com.sun.jna.NativeLong(1 << 16) >> new com.sun.jna.NativeLong(6); by restricting this conversion to top-level (long)casts
					New n = new New(tr);//NativeLong.class.getName());
					FunctionCall constuctor = new FunctionCall("");
					constuctor.addArgument(casted);
					n.setConstruction(constuctor);
					res = n;
				}*/
			} else {
				res = new Expression.Cast(tr, casted);
			}
		} else if (x instanceof Constant) {
			res = ((Constant)x).asJava();
			/*String v  = ((Constant) x).getValue().toString();
			if (!v.endsWith("U")) {
				res = new Expression.Constant(((Constant) x).getType(), v);
			}*/
		} else if (x instanceof MemberRef) {
			MemberRef fr = (MemberRef) x;
			Identifier name = fr.getName();
			Define define = result.defines.get(name);
			if (define != null && define.getValue() != null) {
				if (x.toString().equals(define.getValue().toString()))
					res = null; // avoid some nasty loops
				else {
					Expression defineValue = define.getValue();
					if (defineValue instanceof Constant)
						res = findDefine(name);
					
					if (res == null)
						res = convertExpressionToJava(defineValue, libraryClassName);
				}
			} else {
				
				EnumItem enumItem = result.enumItems.get(name);
				if (enumItem != null)
					res = findEnumItem(enumItem);
			}
		} else if (x instanceof FunctionCall) {
			FunctionCall fc = (FunctionCall) x;
			if ("sizeof".equals(String.valueOf(fc.getFunction())) && fc.getArguments().size() == 1) {
				TypeRefExpression typeEx =  SyntaxUtils.as(fc.getArguments().get(0).getValue(), TypeRefExpression.class);
				if (typeEx != null) {
					res = sizeofToJava(typeEx.getType(), libraryClassName);
				}
			}
		} else if (x instanceof VariableRef) {
			Identifier name = ((VariableRef) x).getName();
			if (name != null) {
				String sname = name.toString();
				if ("True".equals(sname))
					res = new Constant(Constant.Type.Bool, true);
				else if ("False".equals(sname))
					res = new Constant(Constant.Type.Bool, false);
				else {
					EnumItem enumItem = result.enumItems.get(name);
					if (enumItem != null)
						res = findEnumItem(enumItem);
					else
						res = new VariableRef(name);
				}	
			} else
				res = new VariableRef(name);
		}
		if (x instanceof TypeRefExpression) {
			if (((TypeRefExpression)x).getType().isMarkedAsResolved())
				return x;
		}
		if (res == null) {
//			return convertExpressionToJava(x);
			throw new UnsupportedConversionException(x, null);
		}
		res.setParenthesis(x.getParenthesis());
		return res;
	}

	private Expression sizeofToJava(TypeRef type, Identifier libraryClassName) throws UnsupportedConversionException {
		type = resolveTypeDef(type, libraryClassName, true);
//		type = type;
		
		Expression res = null;
		if (type instanceof Pointer) 
			res = memberRef(expr(typeRef(Pointer.class)), MemberRefStyle.Dot, "SIZE");
		else if (type instanceof ArrayRef) {
			res = sizeofToJava(((ArrayRef) type).getTarget(), libraryClassName);
			if (res == null)
				return null;
			
			ArrayRef ar = (ArrayRef) type;
			for (Expression x : ar.getDimensions()) {
				Expression c = convertExpressionToJava(x, libraryClassName);
				res = expr(res, Expression.BinaryOperator.Multiply, c);
			}
		} else if (type instanceof SimpleTypeRef || type instanceof Primitive) {
			JavaPrim prim = getPrimitive(type, libraryClassName);
			if (prim != null) {
				res = sizeof(prim);
			} else {
				Identifier structRef = findStructRef(((SimpleTypeRef) type).getName(), libraryClassName);
				if (structRef != null)
					return methodCall(new New(typeRef(structRef)), MemberRefStyle.Dot, "size");
			}
		} else if (type instanceof Struct) {
			Struct s = (Struct)type;
			if (s != null) {
				Identifier structName = result.declarationsConverter.getActualTaggedTypeName(s);
				Identifier structRef = findStructRef(structName, libraryClassName);
				if (structRef != null)
					return methodCall(new New(typeRef(structRef)), MemberRefStyle.Dot, "size");
				else
					for (Declaration d : s.getDeclarations()) {
						if (d instanceof VariablesDeclaration) {
							TypeRef varsType = d.getValueType();
							for (Declarator sto : ((VariablesDeclaration) d).getDeclarators()) {
								Expression so = sizeofToJava(as(sto.mutateType(varsType), TypeRef.class), libraryClassName);
								if (so == null)
									return null;
									
								if (res == null)
									res = so;
								else
									res = expr(res, Expression.BinaryOperator.Plus, so);
							}
						}
					}
			}
		}
		return res;
	}

	private Expression sizeof(JavaPrim prim) {
		switch (prim) {
		case NativeLong:
			return memberRef(expr(typeRef(NativeLong.class)), MemberRefStyle.Dot, "SIZE");
		case Boolean:
		case Byte:
			return new Constant(Constant.Type.Int, 1);
		case Char:
		case Short:
			return new Constant(Constant.Type.Int, 2);
		case Double:
		case Long:
			return new Constant(Constant.Type.Int, 8);
		case Float:
		case Int:
			return new Constant(Constant.Type.Int, 4);
		}
		return null;
	}

	private Expression findEnumItem(EnumItem enumItem) {
		String library = result.getLibrary(enumItem);
		if (library == null)
			return null;
		
		Element parent = enumItem.getParentElement();
		if (parent == null || !(parent instanceof Enum))
			return null;
		
		Enum e = (Enum)parent;
		Identifier ident = ident(result.getLibraryClassFullName(library), result.declarationsConverter.getActualTaggedTypeName(e), ident(enumItem.getName()));
		return expr(typeRef(ident).setMarkedAsResolved(true));
	}
	/// @see http://java.sun.com/docs/books/tutorial/java/nutsandbolts/_keywords.html
	public static Set<String> JAVA_KEYWORDS = new HashSet<String>(Arrays.asList(
			"null",
			"true",
			"false",
			
			"abstract",
			"continue",
			"for",
			"new",
			"switch",
			"assert",
			"default",
			"goto",
			"package",
			"synchronized",
			"boolean",
			"do",
			"if",
			"private",
			"this",
			"break",
			"double",
			"implements",
			"protected",
			"throw",
			"byte",
			"else",
			"import",
			"public",
			"throws",
			"case",
			"enum",
			"instanceof",
			"return",
			"transient",
			"catch",
			"extends",
			"int",
			"short",
			"try",
			"char",
			"final",
			"interface",
			"static",
			"void",
			"class",
			"finally",
			"long",
			"strictfp",
			"volatile",
			"const",
			"float",
			"native",
			"super",
			"while",
			
			"wait" // not allowed for function names
	));
	//static String keywords = " true false double float wait new null boolean return class public protected private ";
	public Identifier getValidJavaArgumentName(Identifier name) {
		return getValidJavaIdentifier(name);
	}
	public Identifier getValidJavaMethodName(Identifier name) {
		String nameStr = name.toString();
		if (nameStr.matches("operator[^\\w]+")) {
			String op = nameStr.substring("operator".length());
			//int nArgs = method.getArgs().size();
			String suffix = null;
			java.lang.Enum<?> e = Expression.getAnyOperator(op);
			if (e == null) {
				if (op.equals("()"))
					suffix = "parenthesis";
				else if (op.equals("[]"))
					suffix = "brackets";
				else if (op.equals("->"))
					suffix = "arrow";
			} else
				suffix = e.name();
			
			if (suffix != null)
				return ident("operator" + StringUtils.capitalize(suffix));
		} else if (nameStr.startsWith("~")) {
			return ident(getValidJavaIdentifier(ident(nameStr.substring(1))) + "Destructor"); 
		}
		return getValidJavaIdentifier(name);
	}
	public static boolean isJavaKeyword(String name) {
		return JAVA_KEYWORDS.contains(name);
	}
	public static Identifier getValidJavaIdentifier(Identifier name) {
		if (name == null)
			return null;
		
		if (isJavaKeyword(name.toString()))
			return ident(name + "_");
		else {
			return ident(name.toString().replaceAll("[^\\w]", "\\$"));
		}
	}

	public static String toPrimString(JavaPrim prim) {
		if (prim == JavaPrim.NativeLong)
			return NativeLong.class.getName();
		return prim.toString().toLowerCase();
	}

	public Expression getJavaClassLitteralExpression(TypeRef tr) {
		JavaPrim prim = result.typeConverter.getPrimitive(tr, null);
		if (prim != null) {
			switch (prim) {
			case Boolean:
			case Byte:
			case Double:
			case Long:
			case Short:
			case Float:
				return memberRef(expr(typeRef(ident(prim.toString()))), MemberRefStyle.Dot, ident("TYPE"));
			case Char:
				return memberRef(expr(typeRef(ident(Character.class.getSimpleName()))), MemberRefStyle.Dot, ident("TYPE"));
			case Int:
				return memberRef(expr(typeRef(ident(Integer.class.getSimpleName()))), MemberRefStyle.Dot, ident("TYPE"));
			case NativeLong:
				return memberRef(expr(typeRef(ident(Long.class.getSimpleName()))), MemberRefStyle.Dot, ident("TYPE"));
			case Void:
				return null;
			}
		}
		return memberRef(expr(tr.clone()), MemberRefStyle.Dot, ident("class"));
	}


	public Expression getJavaClassLitteralExpression() {
		throw new UnsupportedOperationException(getClass().getName() + "." + toString() + " not handled !");
	}
}
