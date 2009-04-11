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

import org.rococoa.NSObject;

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
import com.ochafik.lang.jnaerator.parser.FunctionPointerDeclaration;
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
import com.ochafik.lang.jnaerator.parser.Expression.BinaryOperator;
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
import com.ochafik.lang.jnaerator.parser.StoredDeclarations.TypeDef;
import com.ochafik.lang.jnaerator.parser.TypeRef.ArrayRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.FunctionSignature;
import com.ochafik.lang.jnaerator.parser.TypeRef.Pointer;
import com.ochafik.lang.jnaerator.parser.TypeRef.Primitive;
import com.ochafik.lang.jnaerator.parser.TypeRef.SimpleTypeRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.SubTypeRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.TaggedTypeRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.TargettedTypeRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.SubTypeRef.Style;
import com.ochafik.lang.jnaerator.parser.Declarator.ArrayDeclarator;
import com.ochafik.lang.jnaerator.parser.Declarator.PointerStyle;
import com.ochafik.util.CompoundCollection;
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

	public boolean allowUnknownPointers = true;
	
	public TypeConversion(Result result) {
		super();
		this.result = result;
	}
	
	public Set<String> fakePointersSink;

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
	static Map<JavaPrim, Class<? extends Buffer>> primToBuffer = new HashMap<JavaPrim, Class<? extends Buffer>>();
	static final Set<String> byReferenceClassesNames = new HashSet<String>();
	
	static Map<String, JavaPrim> javaPrims = new TreeMap<String, JavaPrim>();
	static void prim(String from, JavaPrim to) {
		javaPrims.put(from, to);
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
		NativeLong
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
		manualTypeDefs.put("intptr_t", new TypeRef.Pointer(new TypeRef.Primitive("int"), PointerStyle.Pointer));
		manualTypeDefs.put("uintptr_t", new TypeRef.Pointer(new TypeRef.Primitive("int").addModifiers(Modifier.Unsigned), PointerStyle.Pointer));
		manualTypeDefs.put("ptr_t", new TypeRef.Pointer(new TypeRef.Primitive("void"), PointerStyle.Pointer));
		manualTypeDefs.put("LONG_PTR", new TypeRef.Pointer(new TypeRef.Primitive("long"), PointerStyle.Pointer));
		manualTypeDefs.put("ULONG_PTR", new TypeRef.Pointer(new TypeRef.Primitive("long").addModifiers(Modifier.Unsigned), PointerStyle.Pointer));
		manualTypeDefs.put("INT_PTR", new TypeRef.Pointer(new TypeRef.Primitive("int"), PointerStyle.Pointer));
		manualTypeDefs.put("UINT_PTR", new TypeRef.Pointer(new TypeRef.Primitive("int").addModifiers(Modifier.Unsigned), PointerStyle.Pointer));
		manualTypeDefs.put("PVOID", new TypeRef.Pointer(new TypeRef.Primitive("void"), PointerStyle.Pointer));
		
		prim("LONG_PTR", JavaPrim.NativeLong);
//		prim("ULONG_PTR", JavaPrim.NativeLong);
//		
		manualTypeDefs.put("SIZE", new TypeRef.Primitive("size_t"));
		manualTypeDefs.put("CHAR", new TypeRef.Primitive("char"));
		manualTypeDefs.put("WCHAR", new TypeRef.Primitive("wchar_t"));
		manualTypeDefs.put("HRESULT", new TypeRef.Pointer(new TypeRef.Primitive("long"), PointerStyle.Pointer));
		
		
		
		manualTypeDefs.put("LPCSTR", new TypeRef.Pointer(new TypeRef.Primitive("char").addModifiers(Modifier.Const), PointerStyle.Pointer));
		manualTypeDefs.put("LPCWSTR", new TypeRef.Pointer(new TypeRef.Primitive("wchar_t").addModifiers(Modifier.Const), PointerStyle.Pointer));
		manualTypeDefs.put("LPSTR", new TypeRef.Pointer(new TypeRef.Primitive("char"), PointerStyle.Pointer));
		manualTypeDefs.put("LPWSTR", new TypeRef.Pointer(new TypeRef.Primitive("wchar_t"), PointerStyle.Pointer));
		
//		manualTypeDefs.put("LPSTR", new TypeRef.Pointer(new TypeRef.Primitive("char"), PointerStyle.Pointer));
		manualTypeDefs.put("PBYTE", new TypeRef.Pointer(new TypeRef.Primitive("char"), PointerStyle.Pointer));
		//manualTypeDefs.put("LONG_PTR", new TypeRef.Pointer(new TypeRef.Primitive("long", "long"), StorageModifier.Pointer));
		//manualTypeDefs.put("ULONG_PTR", new TypeRef.Pointer(new TypeRef.Primitive("long", "long", "unsigned"), StorageModifier.Pointer));
		
	}
	
	public TypeRef resolveTypeDef(TypeRef valueType, final String callerLibraryClass, final boolean convertToJavaRef) {
		if (valueType == null)
			return null;
		
		valueType = valueType.clone();
		Arg holder = new Arg();
		holder.setValueType(valueType);
		valueType.accept(new Scanner() {
			@Override
			public void visitSimpleTypeRef(SimpleTypeRef simpleTypeRef) {
				super.visitSimpleTypeRef(simpleTypeRef);
				String name = ((SimpleTypeRef) simpleTypeRef).getName();
				
				Pair<TypeDef,Declarator> p = result.typeDefs.get(name);
				if (p != null) {
					TypeRef tr = as(p.getSecond().mutateType(p.getFirst().getValueType()), TypeRef.class);
					
					if (convertToJavaRef && tr instanceof Struct) {
						Struct s = (Struct)tr;
						if (s.isForwardDeclaration())
							return;
						
						tr = findRef(name, s, callerLibraryClass);
						
					}
					if (tr != null && !simpleTypeRef.toString().equals(tr.toString())) {
						simpleTypeRef.replaceBy(tr);
						tr.accept(this);
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
				
				TypeRef structRef = result.typeConverter.findStructRef(name, callerLibraryClass);
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
					String fieldName = null;
					if (expression instanceof Expression.VariableRef) 
						fieldName = ((Expression.VariableRef) expression).getName();
					else if (expression instanceof MemberRef)
						fieldName = ((MemberRef) expression).getName();
					
					if (fieldName != null && !fieldName.equals(name)) {
						simpleTypeRef.replaceBy(resolveTypeDef(new TypeRef.SimpleTypeRef(fieldName), callerLibraryClass, true));
						return;
					}
				}
			}
		});
		return holder.getValueType();
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
		
	JavaPrim getPrimitive(TypeRef valueType, String callerLibraryClass) {
		
		valueType = resolveTypeDef(valueType, callerLibraryClass, true);
		String name = null;
		if (valueType instanceof SimpleTypeRef)
			name = ((SimpleTypeRef) valueType).getName();
		else if (valueType instanceof Primitive)
			name = ((Primitive)valueType).getName();
		
		if (name == null)
			return null;
		
		if (name.equals(NativeLong.class.getName()))
			return JavaPrim.NativeLong;
		
		boolean isLong = false;
		if ((isLong = valueType.getModifiers().contains("long")) || valueType.getModifiers().contains("short"))
			name = (isLong ? "long " : "short ") + name;
		
		JavaPrim type = javaPrims.get(name);
		return type;
	}
	
	public TypeRef findStructRef(String name, String callerLibraryClass) {
		Struct s = result.structsByName.get(name);
		if (s == null) {
			Pair<TypeDef, Declarator> pair = result.typeDefs.get(name);
			if (pair == null)
				return null;
			if (pair.getFirst() == null || pair.getSecond() == null)
				return null;
			Object td = pair.getSecond().mutateType(pair.getFirst().getValueType());
			if (!(td instanceof Struct))
				return null;
			s = (Struct)td;
			name = result.declarationsConverter.getActualTaggedTypeName((TaggedTypeRef)pair.getFirst().getValueType());
		} else {
			name = result.declarationsConverter.getActualTaggedTypeName(s);
		}
		return findRef(name, s, callerLibraryClass);
	}
	public String find(String name, Element e, String callerLibraryClass) {
		if (e == null)
			return null;
		String library = result.getLibrary(e);
		if (library == null)
			return null;
		String libClass = result.getLibraryClassSimpleName(library);
		return SyntaxUtils.equal(libClass, callerLibraryClass) ? name : libClass + "." + name;
	}
	
	public TypeRef findRef(String name, Element e, String callerLibraryClass) {
		if (e == null)
			return null;
		String library = result.getLibrary(e);
		if (library == null)
			return null;
		String libClass = result.getLibraryClassSimpleName(library);
		return new SimpleTypeRef(SyntaxUtils.equal(libClass, callerLibraryClass) ? name : libClass + "." + name);
	}
	public SimpleTypeRef findEnum(String name, String callerLibraryClass) {
		Enum s = result.enumsByName.get(name);
		if (s == null)
			return null;
		
		name = result.declarationsConverter.getActualTaggedTypeName(s);
		
		String library = result.getLibrary(s);
		if (library == null)
			return null;
		String libClass = result.getLibraryClassSimpleName(library);
		//return new SimpleTypeRef(SyntaxUtils.equal(libClass, callerLibraryClass) ? name : libClass + "." + name);
		
		SimpleTypeRef tr = new SimpleTypeRef("int");
		if (result.config.features.contains(JNAeratorConfig.GenFeatures.EnumTypeLocationComments))
			tr.setCommentBefore("@see " + (SyntaxUtils.equal(libClass, callerLibraryClass) ? name : libClass + "#" + name));
//		if (s.getTag() != null)
//			tr.setCommentBefore("@see enums in " + s.getTag());
		return tr;
	}
	public static Expression javaStaticFieldRef(String javaClass, String fieldName) {
		return memberRef(
				expr(typeRef(javaClass)),
				MemberRefStyle.Dot,
				fieldName
			);
	}
	public Expression findDefine(String name) {
		Define s = result.defines.get(name);
		String library = s == null ? null : result.getLibrary(s);
		return library == null ? null : javaStaticFieldRef(result.getLibraryClassSimpleName(library), name);
	}
	
	public String inferCallBackName(FunctionSignature functionSignature, boolean prependNamespaces) {
		List<String> nameElements = new ArrayList<String>();
		String name = functionSignature.getFunction().getName();
		
		if (name != null && name.equals("ChangeKeyOwner"))
			name = (String)name;
		
		Element parent = functionSignature.getParentElement();
		//if (parent == null) {
		//	nameElements.add("Callback");
		//}
		boolean firstParent = true;
		while (parent != null) {
			if (parent instanceof Struct) {
				String structName = result.declarationsConverter.getActualTaggedTypeName((Struct) parent);
				if (structName != null)
					nameElements.add(0, structName);
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
							name = stoName;
					}
				} else if (name == null && parent instanceof Arg) {
					Arg arg = (Arg) parent;
					Function f = SyntaxUtils.as(arg.getParentElement(), Function.class);
					if (f != null) {
						name = f.getName() + "_" + arg.getName();
						break;
					}
				} else if (firstParent) {
					if (parent instanceof VariablesDeclaration || parent instanceof FunctionPointerDeclaration) {
						nameElements.add("Callback");
					}
				}
			}
			parent = parent.getParentElement();
			firstParent = false;
		}
		
		if (prependNamespaces) {
			if (name == null)
				name = "callback";
			
			nameElements.add(name);
			return StringUtils.implode(nameElements, "_");
		} else {
			return name;
		}
	}
	
	TypeRef libTypeRef(String libraryClassSimpleName, String callerLibraryClass) {
		if (SyntaxUtils.equal(libraryClassSimpleName, callerLibraryClass))
			return null;
		return typeRef(libraryClassSimpleName);
	}
	public TypeRef findCallbackRef(String name, String callerLibraryClass) {
		FunctionSignature s = result.callbacksByName.get(name);
		if (s == null)
			return null;
		
		String library = result.getLibrary(s);
		if (library == null)
			return null;
	
		Struct parentStruct = s.findParentOfType(Struct.class);
		if (parentStruct != null && (parentStruct.getType() == Struct.Type.ObjCClass || parentStruct.getType() == Struct.Type.ObjCProtocol)) {
			String structName = result.declarationsConverter.getActualTaggedTypeName(parentStruct);
			return //result.result.getObjCClass(parentStruct.getName()).
				typeRef(typeRef(structName), inferCallBackName(s, true));
		}
		return typeRef(libTypeRef(result.getLibraryClassSimpleName(library), callerLibraryClass), inferCallBackName(s, true));
	}
	
	public TypeRef findCallbackRef(FunctionSignature s, String callerLibraryClass) {
		String library = result.getLibrary(s);
		if (library == null)
			return null;
	
		Struct parentStruct = s.findParentOfType(Struct.class);
		if (parentStruct != null && (parentStruct.getType() == Struct.Type.ObjCClass || parentStruct.getType() == Struct.Type.ObjCProtocol)) {
			String structName = result.declarationsConverter.getActualTaggedTypeName(parentStruct);
			return
				typeRef(typeRef(structName), inferCallBackName(s, true));
		}
		return typeRef(libTypeRef(result.getLibraryClassSimpleName(library), callerLibraryClass), inferCallBackName(s, true));	
	}
	static TypeRef primRef(JavaPrim p) {
		return new SimpleTypeRef(toString(p));
	}
	TypeRef convertTypeToJNA(TypeRef valueType, TypeConversionMode conversionMode, String callerLibraryClass) throws UnsupportedConversionException {
		
		TypeRef original = valueType; 
		valueType =  resolveTypeDef(valueType, callerLibraryClass, true);
		
//		if (original.toString().contains("CvArr"))
//			original = original;
		String valueTypeString = String.valueOf(valueType);
		if (valueTypeString.matches("void\\s*\\*") || valueTypeString.matches("const\\s*void\\s*\\*")) {
			//valueType = (TypeRef)valueType;
			if (original instanceof Pointer && result.config.features.contains(GenFeatures.TypedPointersForForwardDeclarations) && fakePointersSink != null) {
				Pointer p = (Pointer) original;
				if (p.getTarget() instanceof SimpleTypeRef) {
					String name = ((SimpleTypeRef)p.getTarget()).getName();
					if (!"void".equals(name)) {
						int i = name.lastIndexOf('.');
						if (i >= 0)
							name = name.substring(i + 1);
						fakePointersSink.add(name);
						return typeRef(name);
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
			}
		}
		
		if (valueType instanceof Primitive) {
			JavaPrim prim = getPrimitive(valueType, callerLibraryClass);
			if (prim != null)
				return primRef(prim);
			
//			if (!valueType.getModifiers().contains("long"))
//				return valueType.toString();
		} 
		if (valueType instanceof TaggedTypeRef) {
			String name = result.declarationsConverter.getActualTaggedTypeName((TaggedTypeRef) valueType);
			if (name != null) {
				if (valueType instanceof Enum) {
					TypeRef tr = findEnum(name, callerLibraryClass);
					if (tr != null) {
						TypeRef intRef = primRef(JavaPrim.Int);
						intRef.setCommentBefore(tr.getCommentBefore());
						return intRef;
					}
				} else if (valueType instanceof Struct) {
					TypeRef tr = findStructRef(name, callerLibraryClass);
					if (tr != null) {
						switch (conversionMode) {
						case PointedValue:
						case BufferParameter:
						case NativeParameter:
						case PrimitiveParameter:
						case ReturnType:
						case PrimitiveReturnType:
							return tr;
						case FieldType:
						case StaticallySizedArrayField:
						case ExpressionType:
						default:
							return typeRef(tr, SubTypeRef.Style.Dot, "ByValue");
						}
					}
				}
			}
		}
		
		if (valueType instanceof FunctionSignature) {
			TypeRef tr = findCallbackRef((FunctionSignature)valueType, callerLibraryClass);
			if (tr != null)
				return tr;
			else
				return typeRef(((FunctionSignature)valueType).getFunction().getName());
		}
		if (valueType instanceof TargettedTypeRef) {
			//TypeRef target = resolveTypeDef(((TargettedTypeRef) valueType).getTarget(), callerLibraryClass);
			TypeRef target = ((TargettedTypeRef) valueType).getTarget();
			
			boolean staticallySized = valueType instanceof ArrayRef && ((ArrayRef)valueType).hasStaticStorageSize();
			
			TypeRef convArgType = null;
			JavaPrim prim = getPrimitive(target, callerLibraryClass);
			if (prim != null) {
				if (prim == JavaPrim.Void)
					return typeRef(com.sun.jna.Pointer.class);
				else
					convArgType = primRef(prim);
			} else {
				String name = null;
				if (target instanceof SimpleTypeRef)
					name = ((SimpleTypeRef) target).getName();
				else if (target instanceof Struct) {
					Struct struct = (Struct)target;
					if (struct == null) {
						valueType =  resolveTypeDef(original, callerLibraryClass, true);
						struct = null;
					} else {
						name = result.declarationsConverter.getActualTaggedTypeName(struct);
					}
				} else if (target instanceof FunctionSignature) {
					TypeRef tr = findCallbackRef((FunctionSignature)target, callerLibraryClass);
					if (tr != null) {
						if (valueType instanceof TypeRef.ArrayRef) {
							return new TypeRef.ArrayRef(tr);
						} else {
							return tr;
						}
					}
					//else
					//	return typeRef(((FunctionSignature)valueType).getFunction().getName());
				}
				if (name != null) {
					/// Pointer to Objective-C class
					if (result.objCClasses.containsKey(name))
						convArgType = typeRef(name);
					else {
						/// Pointer to C structure
						TypeRef structRef = findStructRef(name, callerLibraryClass);
						if (structRef != null) {//result.cStructNames.contains(name)) {
			 				switch (conversionMode) {
								case ExpressionType:
								case FieldType:
									convArgType = typeRef(structRef, SubTypeRef.Style.Dot, "ByReference");
									if (valueType instanceof Pointer)
										return convArgType;
									break;
								default:
									convArgType = structRef;
									if (valueType instanceof Pointer)
										return convArgType;
									break;
							}
						} else {
							try {
								convArgType = convertTypeToJNA(target, conversionMode, callerLibraryClass);
							} catch (UnsupportedConversionException ex) {
								//convArgType = null;//return typeRef(com.sun.jna.Pointer.class);
								if (valueType instanceof TypeRef.Pointer && 
										target instanceof TypeRef.SimpleTypeRef &&
										result.config.features.contains(JNAeratorConfig.GenFeatures.TypedPointersForForwardDeclarations) &&
										fakePointersSink != null) {

									int i = name.lastIndexOf('.');
									if (i >= 0)
										name = name.substring(i + 1);
									fakePointersSink.add(name);
									return typeRef(name);
								} else {
									return typeRef(com.sun.jna.Pointer.class);
								}
							}
						}
					}
				} else {
					try {
						convArgType = convertTypeToJNA(target, conversionMode, callerLibraryClass);
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
			String name = ((SimpleTypeRef) valueType).getName();
			if (name == null)
				throw new UnsupportedConversionException(valueType, null);
			
			TypeRef structRef = findStructRef(name, callerLibraryClass);
			if (structRef != null) {
				switch (conversionMode) {
				case PointedValue:
					return structRef;
				default:
					return typeRef(structRef, SubTypeRef.Style.Dot, "ByValue");
				}
			}
			
			TypeRef callbackRef = findCallbackRef(name, callerLibraryClass);
			if (callbackRef != null)
				return callbackRef;
			
			SimpleTypeRef enumTypeRef = findEnum(name, callerLibraryClass);
			//FieldRef enumQualifiedName = findEnum(name);
			if (enumTypeRef != null)
				return enumTypeRef;
			
			if (name.equals("id"))
				return typeRef(NSObject.class);
		
			if (name.equals("SEL"))
				return typeRef(org.rococoa.Selector.class);
			
			if (name.equals("Class"))
				return typeRef(org.rococoa.NSClass.class);
			
			if (name.equals("Protocol"))
				return typeRef(org.rococoa.NSClass.class);
		}
		
		JavaPrim prim = getPrimitive(valueType, callerLibraryClass);
		if (prim != null)
			return primRef(prim);
		
		unknownTypes.add(String.valueOf(valueType));
		throw new UnsupportedConversionException(valueType, null);
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
		if (x instanceof MemberRef) {
			return null;
			//if (x instanceof FieldRef) {
			//	return new SimpleTypeRef(Integer.TYPE.getName());
			//}	
		} else if (x instanceof VariableRef) {
			String name = ((VariableRef)x).getName();
			EnumItem enumItem = result.enumItems.get(name);
			if (enumItem != null)
				return typeRef(Integer.TYPE);
		}
		return null;
	}
	
	public Expression convertExpressionToJava(Expression x, String callerLibraryClass) throws UnsupportedConversionException {
		Expression res = null;
		if (x instanceof AssignmentOp)
			res = expr(convertExpressionToJava(((AssignmentOp) x).getTarget(), callerLibraryClass), AssignmentOperator.Equal, ((AssignmentOp) x).getValue());
		else if (x instanceof BinaryOp) {
			res = expr(
				convertExpressionToJava(((BinaryOp) x).getFirstOperand(), callerLibraryClass),
				((BinaryOp) x).getOperator(),
				convertExpressionToJava(((BinaryOp) x).getSecondOperand(), callerLibraryClass)
			);
		} else if (x instanceof UnaryOp) {
			res = expr(((UnaryOp) x).getOperator(), 
				convertExpressionToJava(((UnaryOp) x).getOperand(), callerLibraryClass)
			);
		} else if (x instanceof Cast) {
			TypeRef tr = convertTypeToJNA(((Cast) x).getType(), TypeConversionMode.ExpressionType, callerLibraryClass);
			JavaPrim prim = getPrimitive(tr, callerLibraryClass);
			Expression casted = convertExpressionToJava(((Cast) x).getTarget(), callerLibraryClass);
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
			String name = fr.getName();
			Define define = result.defines.get(name);
			if (define != null && define.getValue() != null) {
				if (x.toString().equals(define.getValue().toString()))
					res = null; // avoid some nasty loops
				else {
					Expression defineValue = define.getValue();
					if (defineValue instanceof Constant)
						res = findDefine(name);
					
					if (res == null)
						res = convertExpressionToJava(defineValue, callerLibraryClass);
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
					res = sizeofToJava(typeEx.getType(), callerLibraryClass);
				}
			}
		} else if (x instanceof VariableRef) {
			res = new VariableRef(((VariableRef) x).getName());
		}
		if (res == null) {
//			return convertExpressionToJava(x);
			throw new UnsupportedConversionException(x, null);
		}
		res.setParenthesis(x.getParenthesis());
		return res;
	}

	private Expression sizeofToJava(TypeRef type, String callerLibraryClass) throws UnsupportedConversionException {
		type = resolveTypeDef(type, callerLibraryClass, true);
//		type = type;
		
		Expression res = null;
		if (type instanceof Pointer) 
			res = memberRef(expr(typeRef(Pointer.class)), MemberRefStyle.Dot, "SIZE");
		else if (type instanceof ArrayRef) {
			res = sizeofToJava(((ArrayRef) type).getTarget(), callerLibraryClass);
			if (res == null)
				return null;
			
			ArrayRef ar = (ArrayRef) type;
			for (Expression x : ar.getDimensions()) {
				Expression c = convertExpressionToJava(x, callerLibraryClass);
				res = expr(res, Expression.BinaryOperator.Multiply, c);
			}
		} else if (type instanceof SimpleTypeRef || type instanceof Primitive) {
			JavaPrim prim = getPrimitive(type, callerLibraryClass);
			if (prim != null) {
				res = sizeof(prim);
			} else {
				TypeRef structRef = findStructRef(((SimpleTypeRef) type).getName(), callerLibraryClass);
				if (structRef != null)
					return methodCall(new New(structRef), MemberRefStyle.Dot, "size");
			}
		} else if (type instanceof Struct) {
			Struct s = (Struct)type;
			if (s != null) {
				String structName = result.declarationsConverter.getActualTaggedTypeName(s);
				TypeRef structRef = findStructRef(structName, callerLibraryClass);
				if (structRef != null)
					return methodCall(new New(structRef), MemberRefStyle.Dot, "size");
				else
					for (Declaration d : s.getDeclarations()) {
						if (d instanceof VariablesDeclaration) {
							TypeRef varsType = d.getValueType();
							for (Declarator sto : ((VariablesDeclaration) d).getDeclarators()) {
								Expression so = sizeofToJava(as(sto.mutateType(varsType), TypeRef.class), callerLibraryClass);
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
		Expression cl = expr(typeRef(result.getLibraryClassSimpleName(library)));
		if (e.getTag() != null)
			cl = memberRef(cl, MemberRefStyle.Dot, e.getTag());
		return memberRef(cl, MemberRefStyle.Dot, enumItem.getName());
	}
	/// @see http://java.sun.com/docs/books/tutorial/java/nutsandbolts/_keywords.html
	public static Set<String> INVALID_JAVA_IDENTIFIERS = new HashSet<String>(Arrays.asList(
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
	public String getValidJavaArgumentName(String name) {
		return getValidJavaIdentifier(name);
	}
	public String getValidJavaMethodName(String name) {
		if (name.matches("operator[^\\w]+")) {
			String op = name.substring("operator".length());
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
				return "operator" + StringUtils.capitalize(suffix);
		}
		return getValidJavaIdentifier(name);
	}
	public static boolean isValidJavaIdentifier(String name) {
		return !INVALID_JAVA_IDENTIFIERS.contains(name);
	}
	public static String getValidJavaIdentifier(String name) {
		if (name == null)
			return null;
		
		if (!isValidJavaIdentifier(name))
			name += "_";
		
		return name;
	}

	public static String toString(JavaPrim prim) {
		if (prim == JavaPrim.NativeLong)
			return NativeLong.class.getName();
		return prim.toString().toLowerCase();
	}

	
}
