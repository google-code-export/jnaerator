package com.ochafik.lang.jnaerator.runtime;

public class Structure extends com.sun.jna.Structure {
	protected <T extends Structure> T setupClone(T clone) {
		write();
		clone.useMemory(getPointer());
		clone.read();
		return clone;
	}
}
