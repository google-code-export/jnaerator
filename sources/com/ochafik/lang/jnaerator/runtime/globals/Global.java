package com.ochafik.lang.jnaerator.runtime.globals;

import com.sun.jna.Library;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;

public abstract class Global {
	protected String[] symbols;
	protected NativeLibrary library;
	public Global(Library library, String... symbols) {
		this.symbols = symbols;
		this.library = (NativeLibrary) library;
	}
	protected Pointer createPointer() {
		for (String symbol : symbols) {
			Pointer pointer = library.getGlobalVariableAddress(symbol);
			if (pointer != null)
				return pointer;
		}
		return null;
	}
}