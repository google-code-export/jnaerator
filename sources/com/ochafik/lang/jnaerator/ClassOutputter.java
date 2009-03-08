package com.ochafik.lang.jnaerator;

import java.io.IOException;
import java.io.PrintWriter;

public interface ClassOutputter {
	public PrintWriter getClassSourceWriter(String className) throws IOException;
}
