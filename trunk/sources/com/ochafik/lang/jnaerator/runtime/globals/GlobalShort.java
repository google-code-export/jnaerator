package com.ochafik.lang.jnaerator.runtime.globals;

import com.sun.jna.Library;
import com.sun.jna.ptr.ShortByReference;

public class GlobalShort extends GlobalPrimitive<ShortByReference> {
	public GlobalShort(Library library, String... symbols) {
		super(library, ShortByReference.class, symbols);
	}
	public short get() {
		return getValue().getValue();
	}
	public void set(short v) {
		getValue().setValue(v);
	}
}
