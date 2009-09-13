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
package com.ochafik.lang.jnaerator.runtime;

import org.rococoa.AlreadyRetained;

import com.ochafik.lang.jnaerator.runtime.globals.GlobalByte;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalDouble;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalFloat;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalInt;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalLong;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalNativeLong;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalPointer;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalPrimitive;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalShort;
import com.ochafik.lang.jnaerator.runtime.globals.GlobalStruct;

public class JNAeratorRuntime {
	@SuppressWarnings("unused")
	private static final Class<?>[] dependencies = new Class<?>[] {
		LibraryExtractor.class,
		MangledFunctionMapper.class,
		Structure.class,
		ScalaRuntime.class,
		Union.class,
		AlreadyRetained.class, 
		GlobalInt.class,
		GlobalShort.class,
		GlobalByte.class,
		GlobalLong.class,
		GlobalFloat.class,
		GlobalDouble.class,
		GlobalStruct.class,
		GlobalNativeLong.class,
		GlobalPointer.class,
		GlobalPrimitive.class,
		Bits.class,
		StructureType.class,
		StructureTypeDependent.class,
		CGFloatByReference.class,
		CharByReference.class,
		This.class,
		ThisCall.class,
		FastCall.class,
		StringPointer.class,
		WStringPointer.class,
		VirtualTablePointer.class,
		Mangling.class
	};
}
