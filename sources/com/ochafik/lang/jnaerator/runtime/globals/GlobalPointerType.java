package com.ochafik.lang.jnaerator.runtime.globals;

import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

public class GlobalPointerType<T extends PointerType> extends GlobalPrimitive<T> {
	public GlobalPointerType(Library library, Class<T> type, String... symbols) {
		super(library, type, symbols);
		indirected = true;
	}
	Pointer pointer;
	protected Pointer getPointer() {
		if (pointer == null)
			pointer = createPointer();
		
		return pointer;
	}
	public T get() {
		return getValue();
	}
	public void set(T value) {
		this.value = value;
		getPointer().setPointer(0, value.getPointer());
	}
}
