package com.ochafik.lang.jnaerator.runtime;

import com.sun.jna.WString;

public class WStringPointer extends Structure<WStringPointer> {
	public WString value;
	public String toString() {
		return value.toString();
	}

	public WStringPointer() {}
	public WStringPointer(WString value) {
		super();
		this.value = value;
	}
	public WStringPointer(String value) {
		super();
		this.value = new WString(value);
	}
	public static class ByValue extends StringPointer implements com.sun.jna.Structure.ByValue {}
	public static class ByReference extends StringPointer implements com.sun.jna.Structure.ByReference {} 
}