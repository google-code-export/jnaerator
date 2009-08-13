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
	
//	@SuppressWarnings("unchecked")
//	public static <L extends Library> L getLibraryInstance(Class<L> libType) {
//		Class<?> holderType = libType;
//		LibraryHolder lh = libType.getAnnotation(LibraryHolder.class);
//		if (lh != null && lh.value() != null)
//			holderType = lh.value();
//		for (Field f : holderType.getFields())
//			if ((f.getModifiers() & (Modifier.STATIC | Modifier.PUBLIC)) != 0 && libType.isAssignableFrom(f.getType()))
//			{
//				try {
//					return (L)f.get(null);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//	
//		return null;
//	}
}
