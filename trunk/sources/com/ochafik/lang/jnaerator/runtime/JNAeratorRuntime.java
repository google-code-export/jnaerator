package com.ochafik.lang.jnaerator.runtime;

import org.rococoa.AlreadyRetained;

import com.ochafik.lang.jnaerator.runtime.globals.GlobalByte;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalDouble;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalFloat;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalInt;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalLong;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalNativeLong;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalPointer;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalPointerType;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalShort;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalStruct;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalUnion;

public class JNAeratorRuntime {
	@SuppressWarnings("unused")
	private static final Class<?>[] dependencies = new Class<?>[] {
		LibraryExtractor.class,
		MangledFunctionMapper.class,
		Structure.class,
		Union.class,
		AlreadyRetained.class, 
		GlobalInt.class,
		GlobalShort.class,
		GlobalByte.class,
		GlobalLong.class,
		GlobalFloat.class,
		GlobalDouble.class,
		GlobalStruct.class,
		GlobalUnion.class,
		GlobalNativeLong.class,
		GlobalPointer.class,
		GlobalPointerType.class,
		Bits.class,
		ThisCall.class,
		FastCall.class,
		StringPointer.class,
		WStringPointer.class,
		VirtualTablePointer.class,
		Mangling.class
	};
}
