package com.ochafik.lang.jnaerator.runtime.globals;

import com.sun.jna.Library;
import com.sun.jna.ptr.LongByReference;

public class GlobalLong extends GlobalPrimitive<LongByReference> {
	public GlobalLong(Library library, String... symbols) {
		super(library, LongByReference.class, symbols);
	}
	public long get() {
		return getValue().getValue();
	}
	public void set(long v) {
		getValue().setValue(v);
	}
}
