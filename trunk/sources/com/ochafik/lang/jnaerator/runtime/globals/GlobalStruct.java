package com.ochafik.lang.jnaerator.runtime.globals;

import com.ochafik.lang.jnaerator.runtime.Structure;
import com.sun.jna.Library;

public class GlobalStruct<S extends Structure<?, ?, ?>> extends Global {
	S value;
	Class<S> valueClass;
	public GlobalStruct(Library library, Class<S> valueClass, String... symbols) {
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
