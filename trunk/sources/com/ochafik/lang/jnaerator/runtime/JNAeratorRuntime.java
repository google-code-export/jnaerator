package com.ochafik.lang.jnaerator.runtime;

import org.rococoa.AlreadyRetained;

public class JNAeratorRuntime {
	@SuppressWarnings("unused")
	private static final Class<?>[] dependencies = new Class<?>[] {
		LibraryExtractor.class,
		MangledFunctionMapper.class,
		Structure.class,
		Union.class,
		AlreadyRetained.class
	};
}
