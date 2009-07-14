package com.ochafik.lang.jnaerator.runtime;

public class Union extends com.sun.jna.Union {
	protected <T extends Union> T setupClone(T clone) {
		write();
		clone.useMemory(getPointer());
		clone.read();
		return clone;
	}
}
