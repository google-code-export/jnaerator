package com.ochafik.lang.jnaerator.runtime.globals;

import com.sun.jna.Library;
import com.sun.jna.Pointer;

public class GlobalPointer extends Global {
	public GlobalPointer(Library library, String[] symbols) {
		super(library, symbols);
	}
	Pointer value;
	public Pointer getPointer() {
		if (value != null) {
			value = createPointer();
		}
		return value;
	}
}
