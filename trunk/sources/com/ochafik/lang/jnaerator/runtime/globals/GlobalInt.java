package com.ochafik.lang.jnaerator.runtime.globals;

import com.sun.jna.Library;
import com.sun.jna.ptr.IntByReference;

public class GlobalInt extends GlobalPointerType<IntByReference> {
	public GlobalInt(Library library, String[] symbols) {
		super(library, IntByReference.class, symbols);
	}
	public int get() {
		return getValue().getValue();
	}
	public void set(int v) {
		getValue().setValue(v);
	}
}
