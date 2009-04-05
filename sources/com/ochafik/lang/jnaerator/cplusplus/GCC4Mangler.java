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
package com.ochafik.lang.jnaerator.cplusplus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ochafik.lang.jnaerator.Result;
import com.ochafik.lang.jnaerator.parser.Arg;
import com.ochafik.lang.jnaerator.parser.Element;
import com.ochafik.lang.jnaerator.parser.Function;
import com.ochafik.lang.jnaerator.parser.Struct;
import com.ochafik.lang.jnaerator.parser.TypeRef;
import com.ochafik.lang.jnaerator.parser.Declarator.PointerStyle;
import com.ochafik.lang.jnaerator.parser.TypeRef.SimpleTypeRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.TaggedTypeRef;

public class GCC4Mangler implements CPlusPlusMangler {
	
	/*
	public String mangle(Method method) {
		StringBuilder b = new StringBuilder();
		Name n = method.getAnnotation(Name.class);
		//Namespace ns = method.getAnnotation(Namespace.class);
		
		String name = n == null ? method.getName() : n.value();
		b.append("__Z");
		if (n.namespace() != null) {
			b.append("N");
			for (String e : n.namespace())
				b.append(e.length() + e);
			b.append(name.length() + name);
			if (n.classMember())
				b.append("E");
		} else {
			b.append(name.length() + name);
		}
		Type[] types = method.getGenericParameterTypes();
		if (types.length == 0) {
			b.append("v");
		} else {
			
			Annotation[][] parameterAnnotations = method.getParameterAnnotations();
			for (int iParam = 0; iParam < types.length; iParam++) {
				Type type = types[iParam];
				final Annotation[] annotations = parameterAnnotations[iParam];
				
				Info info = new Info(annotations);
				if (type instanceof Class<?> && Pointer.class.isAssignableFrom((Class<?>)type)) {
					
				}
				//if (Pointer.class.isAssignableFrom(type))
			}
		}
		return b.toString();
	}
	static class Info {
		public boolean isConst, isUnsigned, isReference;
		Info(Annotation[] as) {
			isConst = false;
			isUnsigned = false;
			isReference = false;
			for (Annotation a : as) {
				if (Unsigned.class.isAssignableFrom(a.getClass()))
					isUnsigned = true;
				else if (Const.class.isAssignableFrom(a.getClass()))
					isConst = true;
				else if (Reference.class.isAssignableFrom(a.getClass()))
					isReference = true;
			}
		}
	};
	enum CPPPrim {
		Void("v", false, null),
		Char("c", false, Character.TYPE), 
		UChar("h", true, Character.TYPE), 
		Long("l", false, NativeLong.class), 
		ULong("m", true, NativeLong.class), 
		Int("i", false, Integer.TYPE), 
		UInt("j", true, Integer.TYPE), 
		Short("s", false, java.lang.Short.TYPE), 
		UShort("t", true, java.lang.Short.TYPE), 
		Bool("b", false, Boolean.TYPE), 
		Float("f", false, java.lang.Float.TYPE), 
		Double("d", false, java.lang.Double.TYPE);
		//Pointer("P", false, com.sun.jna.Pointer.class,),
		//Reference("R");
		
		final Set<Class<?>> types;
		final boolean unsigned;
		CPPPrim(String argMangling, boolean unsigned, Class<?>... types) {
			this.argMangling = argMangling;
			this.unsigned = unsigned;
			this.types = new HashSet<Class<?>>(Arrays.asList(types));
		}
		
		public Set<Class<?>> getTypes() {
			return types;
		}
		public boolean isUnsigned() {
			return unsigned;
		}
		String argMangling;
		public String getArgMangling() {
			return argMangling;
		}
	}*/

	static void mangleArgType(TypeRef tr, StringBuilder b, Result result) {
		if (tr instanceof TypeRef.TargettedTypeRef) {
			if (tr instanceof TypeRef.Pointer && ((TypeRef.Pointer)tr).getPointerStyle() == PointerStyle.Reference)
				b.append("R");
			else
				b.append("P");
			if (tr.isConst())
				b.append("K");
			mangleArgType(((TypeRef.TargettedTypeRef)tr).getTarget(), b, result);
		} else if (tr instanceof TypeRef.SimpleTypeRef) {
			SimpleTypeRef str = (SimpleTypeRef) tr;
			TypeRef resolved = result.typeConverter.resolveTypeDef(str, null, false);
			if (resolved != null && !resolved.toString().equals(str.toString())) {
				mangleArgType(resolved, b, result);
				return;
			}
			Primitive p = Primitive.parsePrimitive(str);
			String s = signatures.get(p);
			if (s != null)
				b.append(s);
			else {
				lenghtedName(str.getName(), b);
			}
		} else if (tr instanceof TaggedTypeRef) {
			lenghtedName(((TaggedTypeRef)tr).getOriginalTag(), b);
		} else {
			throw new UnsupportedOperationException("Cannot mangle type references of class " + tr.getClass().getName() + " : '" + tr + "'");
		}
	}
	static void lenghtedName(String name, StringBuilder out) {
		out.append(name.length() + name);
	}
	public String mangle(Function function, Result result) {
		String name = function.getName();
		if (name == null)
			return null;
		
		StringBuilder b = new StringBuilder("__Z");
		
		Element parent = function.getParentElement();
		List<String> ns = new ArrayList<String>(function.getNameSpace());
		boolean isMethod = parent instanceof Struct;
		if (isMethod) {
			ns.clear();
			ns.addAll(parent.getNameSpace());
			ns.add(((Struct)parent).getTag());
		}
		if (ns.isEmpty()) {
			lenghtedName(name, b);
		} else {
			b.append("N");
			for (String n : ns)
				lenghtedName(n, b);
			lenghtedName(name, b);
			if (isMethod)
				b.append("E");
		}
		
		if (function.getArgs().isEmpty())
			b.append("v");
		else {
			for (Arg arg : function.getArgs()) {
				TypeRef tr = arg.createMutatedType();
				mangleArgType(tr, b, result);
			}
		}
		return b.toString();
	}
	static Map<Primitive, String> signatures = new HashMap<Primitive, String>();
	static {
		signatures.put(Primitive.Void, "v");
		signatures.put(Primitive.Char, "c"); 
		signatures.put(Primitive.UChar, "h"); 
		signatures.put(Primitive.Long, "l"); 
		signatures.put(Primitive.ULong, "m"); 
		signatures.put(Primitive.Int, "i"); 
		signatures.put(Primitive.UInt, "j"); 
		signatures.put(Primitive.Short, "s"); 
		signatures.put(Primitive.UShort, "t"); 
		signatures.put(Primitive.Bool, "b"); 
		signatures.put(Primitive.Float, "f"); 
		signatures.put(Primitive.Double, "d");
	}
}
