/**
 * 
 */
package com.ochafik.lang.compiler;

import javax.lang.model.element.Modifier;
import javax.lang.model.element.NestingKind;
import javax.tools.JavaFileObject;

public class MemoryJavaFile extends MemoryFileObject implements JavaFileObject {
	JavaFileObject.Kind kind;
	public MemoryJavaFile(String path, String content, JavaFileObject.Kind kind) {
		super(path, content);
		this.kind = kind;
	}
	public Modifier getAccessLevel() {
		return Modifier.PUBLIC;
	}
	public JavaFileObject.Kind getKind() {
		return kind;
	}
	public NestingKind getNestingKind() {
		return null;
	}
	public boolean isNameCompatible(String simpleName, JavaFileObject.Kind kind) {
		return true; // TODO
	}
}