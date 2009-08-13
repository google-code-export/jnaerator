package com.ochafik.lang.jnaerator.runtime.globals;

import com.sun.jna.Library;
import com.sun.jna.NativeLong;
import com.sun.jna.ptr.NativeLongByReference;

public class GlobalNativeLong extends GlobalPointerType<NativeLongByReference> {
	public GlobalNativeLong(Library library, String[] symbols) {
		super(library, NativeLongByReference.class, symbols);
	}
	public NativeLong get() {
		return getValue().getValue();
	}
	public void set(int v) {
		getValue().setValue(new NativeLong(v));
	}
	public void set(long v) {
		getValue().setValue(new NativeLong(v));
	}
	public void set(NativeLong v) {
		getValue().setValue(v);
	}
}
