package com.ochafik.lang.jnaerator.runtime.globals;

import com.ochafik.lang.jnaerator.runtime.Union;
import com.sun.jna.Library;

public class GlobalUnion<S extends Union<?, ?, ?>> extends Global {
	S value;
	Class<S> valueClass;
	public GlobalUnion(Library library, Class<S> valueClass, String... symbols) {
		super(library, symbols);
		this.valueClass = valueClass;
	}
	public S read() {
		if (value != null) {
			try {
				value = valueClass.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			value.useMemory(createPointer());
		}
		value.read();
		return value;
	}
}
