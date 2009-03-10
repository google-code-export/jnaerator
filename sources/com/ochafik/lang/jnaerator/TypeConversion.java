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
package com.ochafik.lang.jnaerator;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.rococoa.NSObject;

import com.ochafik.lang.SyntaxUtils;
import static com.ochafik.lang.SyntaxUtils.*;
import com.ochafik.lang.jnaerator.parser.Arg;
import com.ochafik.lang.jnaerator.parser.Declaration;
import com.ochafik.lang.jnaerator.parser.Define;
import com.ochafik.lang.jnaerator.parser.Element;
import com.ochafik.lang.jnaerator.parser.Enum;
import com.ochafik.lang.jnaerator.parser.Expression;
import com.ochafik.lang.jnaerator.parser.Function;
import com.ochafik.lang.jnaerator.parser.FunctionPointerDeclaration;
import com.ochafik.lang.jnaerator.parser.Modifier;
import com.ochafik.lang.jnaerator.parser.Struct;
import com.ochafik.lang.jnaerator.parser.TypeRef;
import com.ochafik.lang.jnaerator.parser.Declarator;
import com.ochafik.lang.jnaerator.parser.VariablesDeclaration;
import com.ochafik.lang.jnaerator.parser.Enum.EnumItem;
import com.ochafik.lang.jnaerator.parser.Expression.Assignment;
import com.ochafik.lang.jnaerator.parser.Expression.BinaryOp;
import com.ochafik.lang.jnaerator.parser.Expression.Cast;
import com.ochafik.lang.jnaerator.parser.Expression.Constant;
import com.ochafik.lang.jnaerator.parser.Expression.FieldRef;
import com.ochafik.lang.jnaerator.parser.Expression.FunctionCall;
import com.ochafik.lang.jnaerator.parser.Expression.MemberRef;
import com.ochafik.lang.jnaerator.parser.Expression.MemberRefStyle;
import com.ochafik.lang.jnaerator.parser.Expression.New;
import com.ochafik.lang.jnaerator.parser.Expression.TypeRefExpression;
import com.ochafik.lang.jnaerator.parser.Expression.UnaryOp;
import com.ochafik.lang.jnaerator.parser.Expression.VariableRef;
import com.ochafik.lang.jnaerator.parser.StoredDeclarations.TypeDef;
import com.ochafik.lang.jnaerator.parser.TypeRef.ArrayRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.FunctionSignature;
import com.ochafik.lang.jnaerator.parser.TypeRef.Pointer;
import com.ochafik.lang.jnaerator.parser.TypeRef.Primitive;
import com.ochafik.lang.jnaerator.parser.TypeRef.SimpleTypeRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.SubTypeRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.TargettedTypeRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.SubTypeRef.Style;
import com.ochafik.lang.jnaerator.parser.Declarator.ArrayDeclarator;
import com.ochafik.lang.jnaerator.parser.Declarator.PointerStyle;
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

public class TypeConversion {
	Result result;

	public boolean allowUnknownPointers = true;
	
	public TypeConversion(Result result) {
		super();
		this.result = result;
	}

	enum TypeConversionMode {
		PrimitiveParameter, 
		NativeParameter,
		BufferParameter,
		FieldType, 
		ReturnType, 
		ExpressionType, 
		StaticallySizedArrayField, 
		PrimitiveReturnType
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
//		prim("LONG_PTR", JavaPrim.NativeLong);
//		prim("ULONG_PTR", JavaPrim.NativeLong);
//		
		
		
		manualTypeDefs.put("LPCSTR", new TypeRef.Pointer(new TypeRef.Primitive("char").addModifiers(Modifier.Const), PointerStyle.Pointer));
		manualTypeDefs.put("LPSTR", new TypeRef.Pointer(new TypeRef.Primitive("char"), PointerStyle.Pointer));
		manualTypeDefs.put("PBYTE", new TypeRef.Pointer(new TypeRef.Primitive("char"), PointerStyle.Pointer));
		//manualTypeDefs.put("LONG_PTR", new TypeRef.Pointer(new TypeRef.Primitive("long", "long"), StorageModifier.Pointer));
		//manualTypeDefs.put("ULONG_PTR", new TypeRef.Pointer(new TypeRef.Primitive("long", "long", "unsigned"), StorageModifier.Pointer));
		
	}
	
	TypeRef resolveTypeDef(TypeRef valueType) {
		if (valueType == null)
			return null;
		
		if (valueType instanceof SimpleTypeRef) {
			String name = ((SimpleTypeRef) valueType).getName();
			
			Pair<TypeDef,Declarator> p = result.typeDefs.get(name);
			if (p != null) {
				TypeRef tr = as(p.getSecond().mutateType(p.getFirst().getValueType()), TypeRef.class);
				if (tr instanceof Struct && ((Struct)tr).isForwardDeclaration())
					return valueType;
				else 
					return tr;
			}
			
			TypeRef manualTypeRef = manualTypeDefs.get(name);
			if (manualTypeRef != null)
				return manualTypeRef;
			
			Define define = result.defines.get(name);
			Expression expression = define == null ? null : define.getValue();
			if (expression != null) {
				String fieldName = null;
				if (expression instanceof Expression.VariableRef) 
					fieldName = ((Expression.VariableRef) expression).getName();
				else if (expression instanceof Expression.FieldRef)
					fieldName = ((FieldRef) expression).getName();
				
				if (fieldName != null && !fieldName.equals(name))
					return resolveTypeDef(new TypeRef.SimpleTypeRef(fieldName));
			}
		}
		if (valueType instanceof Pointer) {
			Pointer pt = (Pointer)valueType;
			return new Pointer(resolveTypeDef(pt.getTarget()), pt.getPointerStyle());
		}
		return valueType;
	}
	
	public static boolean resolvesToPrimitive(String name) {
		return javaPrims.containsKey(name);
	}
	
	JavaPrim getPrimitive(TypeRef valueType) {
		
		valueType = resolveTypeDef(valueType);
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
		return findRef(name, result.structsByName.get(name), callerLibraryClass);
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
	public SimpleTypeRef findEnum(String name) {
		Enum s = result.enumsByName.get(name);
		if (s == null)
			return null;
		
		SimpleTypeRef tr = new SimpleTypeRef("int");
//		if (s.getTag() != null)
//			tr.setCommentBefore("@see enums in " + s.getTag());
		return tr;
	}
	public static FieldRef javaStaticFieldRef(String javaClass, String fieldName) {
		return new FieldRef(
				new Expression.TypeRefExpression(new TypeRef.SimpleTypeRef(javaClass)),
				fieldName, 
				MemberRefStyle.Dot
			);
	}
	public FieldRef findDefine(String name) {
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
				String structName = ((Struct) parent).getTag();
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
			return //result.result.getObjCClass(parentStruct.getName()).
				typeRef(typeRef(parentStruct.getTag()), inferCallBackName(s, true));
		}
		return typeRef(libTypeRef(result.getLibraryClassSimpleName(library), callerLibraryClass), inferCallBackName(s, true));
	}
	
	public TypeRef findCallbackRef(FunctionSignature s, String callerLibraryClass) {
		String library = result.getLibrary(s);
		if (library == null)
			return null;
	
		Struct parentStruct = s.findParentOfType(Struct.class);
		if (parentStruct != null && (parentStruct.getType() == Struct.Type.ObjCClass || parentStruct.getType() == Struct.Type.ObjCProtocol)) {
			return
				typeRef(typeRef(parentStruct.getTag()), inferCallBackName(s, true));
		}
		return typeRef(libTypeRef(result.getLibraryClassSimpleName(library), callerLibraryClass), inferCallBackName(s, true));	
	}
	
	static TypeRef typeRef(Class<?> jc) {
		return new SimpleTypeRef(jc.getName());
	}
	static TypeRef typeRef(String s) {
		return new SimpleTypeRef(s);
	}
	static TypeRef typeRef(JavaPrim p) {
		return new SimpleTypeRef(toString(p));
	}
	private TypeRef typeRef(TypeRef parentTypeRef, Style style, String subName) {
		if (parentTypeRef == null)
			return typeRef(subName);
		return new SubTypeRef(parentTypeRef, style, subName);
	}
	private TypeRef typeRef(TypeRef parentTypeRef, String subName) {
		return typeRef(parentTypeRef, Style.Dot, subName);
	}
	
	TypeRef convertTypeToJNA(TypeRef valueType, TypeConversionMode conversionMode, String callerLibraryClass) throws UnsupportedConversionException {
		
		TypeRef original = valueType; 
		valueType =  resolveTypeDef(valueType);
		
		String valueTypeString = String.valueOf(valueType);
		if (valueTypeString.equals("void*"))
			valueType = (TypeRef)valueType;
		else {
			if (conversionMode == TypeConversionMode.BufferParameter ||
					conversionMode == TypeConversionMode.PrimitiveParameter) 
			{
				if (valueTypeString.matches("(__)?const char\\*"))
					return typeRef(String.class);
				else if (valueTypeString.matches("(__)?const wchar_t\\*"))
					return typeRef(WString.class);
				else if (valueTypeString.matches("(__)?const char\\*\\*"))
					return new ArrayRef(typeRef(String.class));
				else if (valueTypeString.matches("(__)?const wchar_t\\*\\*"))
					return new ArrayRef(typeRef(WString.class));
			}
		}
		
		if (valueType instanceof Primitive) {
			JavaPrim prim = getPrimitive(valueType);
			if (prim != null)
				return typeRef(prim);
			
//			if (!valueType.getModifiers().contains("long"))
//				return valueType.toString();
		} 
		if (valueType instanceof Struct) {
			String name = ((Struct) valueType).getTag();
			if (name != null)
				return typeRef(findStructRef(name, callerLibraryClass), SubTypeRef.Style.Dot, "ByValue");
		}
		
		if (valueType instanceof FunctionSignature) {
			TypeRef tr = findCallbackRef((FunctionSignature)valueType, callerLibraryClass);
			if (tr != null)
				return tr;
			else
				return typeRef(((FunctionSignature)valueType).getFunction().getName());
		}
		if (valueType instanceof TargettedTypeRef) {
			TypeRef target = resolveTypeDef(((TargettedTypeRef) valueType).getTarget());
			
			boolean staticallySized = valueType instanceof ArrayRef && ((ArrayRef)valueType).hasStaticStorageSize();
			
			TypeRef convTargType;
			JavaPrim prim = getPrimitive(target);
			if (prim != null) {
				if (prim == JavaPrim.Void)
					return typeRef(com.sun.jna.Pointer.class);
				else
					convTargType = typeRef(prim);
			} else {
				String name = null;
				if (target instanceof SimpleTypeRef)
					name = ((SimpleTypeRef) target).getName();
				else if (target instanceof Struct) {
					Struct struct = (Struct)target;
					if (struct == null) {
						valueType =  resolveTypeDef(original);
						struct = null;
					} else
//					if (struct != null)
						name = struct.getTag();
				}
				if (name != null) {
					/// Pointer to Objective-C class
					if (result.objCClasses.containsKey(name))
						convTargType = typeRef(name);
					else {
						/// Pointer to C structure
						TypeRef structRef = findStructRef(name, callerLibraryClass);
						if (structRef != null) {//result.cStructNames.contains(name)) {
			 				switch (conversionMode) {
								case NativeParameter:
								case PrimitiveParameter:
								case FieldType:
									convTargType = typeRef(structRef, SubTypeRef.Style.Dot, "ByReference");
									if (valueType instanceof Pointer)
										return convTargType;
									break;
								default:
									convTargType = structRef;
									if (valueType instanceof Pointer)
										return convTargType;
									break;
							}
						} else
							convTargType = convertTypeToJNA(target, conversionMode, callerLibraryClass);
					}
				} else
					convTargType = convertTypeToJNA(target, conversionMode, callerLibraryClass);
			}	
			
			switch (conversionMode) {
				case StaticallySizedArrayField:
					return new ArrayRef(convTargType);
				case PrimitiveParameter:
					List<Modifier> modifiers = target.getModifiers();
					if (modifiers.contains(Modifier.Const))
						return new ArrayRef(convTargType);
				case BufferParameter:
					Class<? extends Buffer> bc = primToBuffer.get(prim);
					if (bc != null) {
						return typeRef(bc);
					}
				case FieldType:
					if (staticallySized)
						return new ArrayRef(convTargType);
				default:
					if (prim != null) {
						Class<? extends ByReference> byRefClass = primToByReference.get(prim);
						if (byRefClass != null)
							return typeRef(byRefClass);
					}
					
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
			if (structRef != null)
				return typeRef(structRef, SubTypeRef.Style.Dot, "ByValue");
			
			TypeRef callbackRef = findCallbackRef(name, callerLibraryClass);
			if (callbackRef != null)
				return callbackRef;
			
			SimpleTypeRef enumTypeRef = findEnum(name);
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
		
		JavaPrim prim = getPrimitive(valueType);
		if (prim != null)
			return typeRef(prim);
		
		unknownTypes.add(String.valueOf(valueType));
		throw new UnsupportedConversionException(valueType, null);
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
		if (x instanceof Assignment)
			res = new Assignment(convertExpressionToJava(((Assignment) x).getTarget(), callerLibraryClass), ((Assignment) x).getValue());
		else if (x instanceof BinaryOp) {
			res = new Expression.BinaryOp(((BinaryOp) x).getOperator(), 
				convertExpressionToJava(((BinaryOp) x).getFirstOperand(), callerLibraryClass),
				convertExpressionToJava(((BinaryOp) x).getSecondOperand(), callerLibraryClass)
			);
		} else if (x instanceof UnaryOp) {
			res = new Expression.UnaryOp(((UnaryOp) x).getOperator(), 
				convertExpressionToJava(((UnaryOp) x).getOperand(), callerLibraryClass)
			);
		} else if (x instanceof Cast) {
			TypeRef tr = convertTypeToJNA(((Cast) x).getType(), TypeConversionMode.ExpressionType, callerLibraryClass);
			JavaPrim prim = getPrimitive(tr);
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
			if (x instanceof FieldRef) {
				FieldRef fr = (FieldRef) x;
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
				if ("sizeof".equals(fc.getFunctionName()) && fc.getArguments().size() == 1) {
					TypeRefExpression typeEx =  SyntaxUtils.as(fc.getArguments().get(0).getValue(), TypeRefExpression.class);
					if (typeEx != null) {
						res = sizeofToJava(typeEx.getType(), callerLibraryClass);
					}
				}
			}
		} else if (x instanceof VariableRef) {
			res = new VariableRef(((VariableRef) x).getName());
		}
		if (res == null) {
//			return convertExpressionToJava(x);
			throw new UnsupportedConversionException(x, null);
		}

		return res;
	}

	private Expression sizeofToJava(TypeRef type, String callerLibraryClass) throws UnsupportedConversionException {
		type = resolveTypeDef(type);
//		type = type;
		
		Expression res = null;
		if (type instanceof Pointer) 
			res = new Expression.FieldRef(com.sun.jna.Pointer.class.getName() + ".SIZE");
		else if (type instanceof ArrayRef) {
			res = sizeofToJava(((ArrayRef) type).getTarget(), callerLibraryClass);
			if (res == null)
				return null;
			
			ArrayRef ar = (ArrayRef) type;
			for (Expression x : ar.getDimensions()) {
				Expression c = convertExpressionToJava(x, callerLibraryClass);
				res = new Expression.BinaryOp(Expression.BinaryOperator.Multiply, res, c);
			}
		} else if (type instanceof SimpleTypeRef || type instanceof Primitive) {
			JavaPrim prim = getPrimitive(type);
			if (prim != null) {
				res = sizeof(prim);
			} else {
				TypeRef structRef = findStructRef(((SimpleTypeRef) type).getName(), callerLibraryClass);
				if (structRef != null)
					return new Expression.FunctionCall(new New(structRef), "size", MemberRefStyle.Dot);
			}
		} else if (type instanceof Struct) {
			Struct s = (Struct)type;
			if (s != null) {
				TypeRef structRef = findStructRef(s.getTag(), callerLibraryClass);
				if (structRef != null)
					return new Expression.FunctionCall(new New(structRef), "size", MemberRefStyle.Dot);
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
									res = new Expression.BinaryOp(Expression.BinaryOperator.Plus, res, so);
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
			return new FieldRef(NativeLong.class.getName() + ".SIZE");
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
		return new Expression.FieldRef(result.getLibraryClassSimpleName(library) + "." +
			(e.getTag() == null ? "" : e.getTag() + ".") +
			enumItem.getName()
		);
	}
	static String keywords = " true false double float wait new null boolean return class public protected private ";
	public String getValidJavaArgumentName(String name) {
		return getValidJavaIdentifier(name);
	}
	public String getValidJavaMethodName(String name) {
		return getValidJavaIdentifier(name);
	}
	public static boolean isValidJavaIdentifier(String name) {
		return !keywords.contains(" " + name + " ");
	}
	public static String getValidJavaIdentifier(String name) {
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
