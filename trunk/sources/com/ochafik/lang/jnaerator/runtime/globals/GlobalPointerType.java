package com.ochafik.lang.jnaerator.runtime.globals;

import com.ochafik.util.string.StringUtils;
import com.sun.jna.Library;
import com.sun.jna.PointerType;

public abstract class GlobalPointerType<T extends PointerType> extends Global {
	protected Class<T> type;
	public GlobalPointerType(Library library, Class<T> type, String[] symbols) {
		super(library, symbols);
		this.type = type;
	}
	protected T value;
	protected T getValue() {
		if (value != null) {
			try {
				value = type.newInstance();
			} catch (Exception e) {
				throw new RuntimeException("Failed to instantiate pointer to " + StringUtils.implode(symbols, "/"), e);
			}
			value.setPointer(createPointer());
		}
		return value;
	}
}
