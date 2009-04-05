package com.ochafik.lang.jnaerator.cplusplus;

import com.ochafik.lang.jnaerator.parser.TypeRef.SimpleTypeRef;
import com.ochafik.util.string.StringUtils;

public enum Primitive {
	Void,
	
	Bool, 
	
	Char, 
	UChar, 
	
	Short, 
	UShort, 
	
	Int, 
	UInt, 
	
	Long, 
	ULong, 
	
	Float, 
	
	Double;
	
//	LongDouble;
	
	//Pointer;
	//Reference;
	
	static Primitive parsePrimitive(SimpleTypeRef tr) {
		String name = tr.getName();
		name = StringUtils.capitalize(name);
		if (tr.isUnsigned())
			name = "U" + name;
		try {
			return Primitive.valueOf(name);
		} catch (Exception ex) {
			return null;
		}
	}
	
}
