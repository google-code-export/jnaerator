package com.ochafik.lang.jnaerator.runtime.globals;

import com.ochafik.util.string.StringUtils;
import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

public abstract class GlobalPrimitive<T extends PointerType> extends Global {
	protected final Class<T> type;
	protected boolean indirected = false;
	public GlobalPrimitive(Library library, Class<T> type, String... symbols) {
		super(library, symbols);
		this.type = type;
	}
	protected Pointer getPointer() {
		return createPointer();
	}
	protected T value;
	protected T getValue() {
		if (value != null) {
			try {
				value = type.newInstance();
			} catch (Exception e) {
				throw new RuntimeException("Failed to instantiate pointer to " + StringUtils.implode(symbols, "/"), e);
			}
			Pointer pointer = getPointer();
			if (indirected) {
				pointer = pointer.getPointer(0);
			}
			value.setPointer(pointer);
		}
		return value;
	}
}
