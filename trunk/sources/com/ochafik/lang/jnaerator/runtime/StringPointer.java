package com.ochafik.lang.jnaerator.runtime;

public class StringPointer extends Structure<StringPointer> {
	public String value;
	public String toString() {
		return value;
	}
	public StringPointer() {}
	public StringPointer(String value) {
		super();
		this.value = value;
	}
	public static class ByValue extends StringPointer implements com.sun.jna.Structure.ByValue {}
	public static class ByReference extends StringPointer implements com.sun.jna.Structure.ByReference {} 
}
