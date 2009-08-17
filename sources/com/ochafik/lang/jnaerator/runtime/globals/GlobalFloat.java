package com.ochafik.lang.jnaerator.runtime.globals;

import com.sun.jna.Library;
import com.sun.jna.ptr.FloatByReference;

public class GlobalFloat extends GlobalPrimitive<FloatByReference> {
	public GlobalFloat(Library library, String... symbols) {
		super(library, FloatByReference.class, symbols);
	}
	public float get() {
		return getValue().getValue();
	}
	public void set(float v) {
		getValue().setValue(v);
	}
}
