package com.ochafik.lang.jnaerator.runtime.globals;

import com.sun.jna.Library;
import com.sun.jna.ptr.DoubleByReference;

public class GlobalDouble extends GlobalPointerType<DoubleByReference> {
	public GlobalDouble(Library library, String[] symbols) {
		super(library, DoubleByReference.class, symbols);
	}
	public double get() {
		return getValue().getValue();
	}
	public void set(double v) {
		getValue().setValue(v);
	}
}
