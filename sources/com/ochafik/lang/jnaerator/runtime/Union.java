package com.ochafik.lang.jnaerator.runtime;

public class Union<S extends Union<S>> extends com.sun.jna.Union {
	protected <T extends Union<?>> T setupClone(T clone) {
		write();
		clone.useMemory(getPointer());
		clone.read();
		return clone;
	}
	@SuppressWarnings("unchecked")
	@Override
	public S[] toArray(int size) {
		return (S[])super.toArray(size);
	}
	public S[] toArray() {
		return toArray(1);
	}
	@SuppressWarnings("unchecked")
	@Override
	public S[] toArray(com.sun.jna.Structure[] array) {
		return (S[])super.toArray(array);
	}
}
