package com.ochafik.lang.jnaerator.runtime.globals;

import com.sun.jna.Library;
import com.sun.jna.ptr.ByteByReference;

public class GlobalByte extends GlobalPointerType<ByteByReference> {
	public GlobalByte(Library library, String[] symbols) {
		super(library, ByteByReference.class, symbols);
	}
	public byte get() {
		return getValue().getValue();
	}
	public void set(byte v) {
		getValue().setValue(v);
	}
}
