package com.ochafik.lang.jnaerator.runtime;

import java.lang.reflect.Field;

public class Structure extends com.sun.jna.Structure {
	protected <T extends Structure> T setupClone(T clone) {
		write();
		clone.useMemory(getPointer());
		clone.read();
		return clone;
	}
	@Override
	protected Integer getBitsAnnotation(Field field) {
		Bits bits = field.getAnnotation(Bits.class);
		return bits == null ? null : bits.value();
	}
}
