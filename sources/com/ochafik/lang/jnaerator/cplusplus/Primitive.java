package com.ochafik.lang.jnaerator.cplusplus;

import com.ochafik.lang.jnaerator.parser.Modifier;
import com.ochafik.lang.jnaerator.parser.TypeRef.SimpleTypeRef;
import com.ochafik.util.string.StringUtils;

public enum Primitive {
	Void,
	
	Bool, 
	
	Char, 
	SChar, 
	UChar, 
	
	Short, 
	UShort, 
	
	Int, 
	UInt, 
	
	Long, 
	ULong, 
	
	Float, 
	
	Double, 

	LongDouble, 
	
	LongLong,
	ULongLong;
	
//	LongDouble;
	
	//Pointer;
	//Reference;
	
	static Primitive parsePrimitive(SimpleTypeRef tr) {
		String name = tr.getName();
		String basis = StringUtils.capitalize(name);
		if (Modifier.Long.isContainedBy(tr.getModifiers()))
			basis = "Long" + basis;
		if (Modifier.Unsigned.isContainedBy(tr.getModifiers()))
			name = "U" + basis;
		if (Modifier.Signed.isContainedBy(tr.getModifiers()))
			name = "S" + basis;
		try {
			return Primitive.valueOf(name);
		} catch (Exception ex) {
			try {
				return Primitive.valueOf(basis);
			} catch (Exception ex2) {
				return null;
			}
		}
	}
	
}
