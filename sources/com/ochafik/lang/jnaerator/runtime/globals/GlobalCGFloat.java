package com.ochafik.lang.jnaerator.runtime.globals;

import org.rococoa.cocoa.CGFloat;

import com.ochafik.lang.jnaerator.runtime.CGFloatByReference;
import com.sun.jna.Library;

public class GlobalCGFloat extends GlobalPrimitive<CGFloatByReference> {
	public GlobalCGFloat(Library library, String... symbols) {
		super(library, CGFloatByReference.class, symbols);
	}
	public CGFloat get() {
		return getValue().get();
	}
	public void set(CGFloat v) {
		getValue().set(v);
	}
}
