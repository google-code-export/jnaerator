/**
 * 
 */
package com.ochafik.lang.compiler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileManager.Location;


public class MemoryFileManager extends ForwardingJavaFileManager<JavaFileManager> {
	public final Map<String, MemoryJavaFile> inputs = new HashMap<String, MemoryJavaFile>();
	public final Map<String, MemoryFileObject> outputs = new HashMap<String, MemoryFileObject>();

	public void writeJar(OutputStream out, boolean outputSources) throws IOException {
		JarOutputStream jout = new JarOutputStream(out);
		if (outputSources)
			for (MemoryFileObject o : inputs.values())
				writeEntry(o, jout);
		for (MemoryFileObject o : outputs.values())
			writeEntry(o, jout);
		jout.close();
	}
	protected void writeEntry(MemoryFileObject o, JarOutputStream jout) throws IOException {
		byte[] c = o.getContent();
		if (c == null)
			return;

		JarEntry e = new JarEntry(o.getPath());
		jout.putNextEntry(e);
		jout.write(c);
		jout.closeEntry();
	}
	public MemoryFileManager(JavaFileManager fm) {
		super(fm);
	}

	public void addSourceInput(String path, String content) {
		inputs.put(path, new MemoryJavaFile(path, content, JavaFileObject.Kind.SOURCE));
	}
	public Iterable<? extends JavaFileObject> getJavaFileObjects() {
		return new ArrayList<JavaFileObject>(inputs.values());
	}

	@Override
	public JavaFileObject getJavaFileForInput(Location location, String className, JavaFileObject.Kind kind) throws IOException {
		if (kind == JavaFileObject.Kind.SOURCE) {
			System.out.println("getJavaFileForInput(className = " + className + ")");
			return inputs.get(className);
		}
		return super.getJavaFileForInput(location, className, kind);
	}

	@Override
	public JavaFileObject getJavaFileForOutput(Location location, String className, JavaFileObject.Kind kind, FileObject sibling) throws IOException {
		MemoryJavaFile jo = null;
		if (kind == JavaFileObject.Kind.CLASS) {
			String path = className.replace('.', '/') + ".class";
			outputs.put(path, jo = new MemoryJavaFile(path, null, kind));
			System.out.println("getJavaFileForOutput(path = " + path + ")");
		} else if (kind == JavaFileObject.Kind.SOURCE) {
			String path = className.replace('.', '/') + ".class";
			inputs.put(path, jo = new MemoryJavaFile(path, null, kind));
			System.out.println("getJavaFileForOutput(path = " + path + ")");
		}

		return jo == null ? super.getJavaFileForInput(location, className, kind) : jo;
	}
	@Override
	public FileObject getFileForOutput(Location location, String packageName, String relativeName, FileObject sibling) throws IOException {
		System.out.println("getFileForOutput(relativeName = " + relativeName + ")");
		MemoryFileObject out = outputs.get(relativeName);
		if (out == null) {
			out = new MemoryFileObject(relativeName, (String)null);
			outputs.put(relativeName, out);
		}
		return out;
	}
}