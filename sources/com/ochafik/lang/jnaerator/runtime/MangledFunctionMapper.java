package com.ochafik.lang.jnaerator.runtime;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.ochafik.lang.jnaerator.Name;
import com.sun.jna.FunctionMapper;
import com.sun.jna.Library;
import com.sun.jna.NativeLibrary;

public class MangledFunctionMapper implements FunctionMapper {
	public static final Map<Object, Object> DEFAULT_OPTIONS;
	static {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put(Library.OPTION_FUNCTION_MAPPER, new MangledFunctionMapper(null));
		
		DEFAULT_OPTIONS = Collections.unmodifiableMap(m);
	}
	FunctionMapper linked;
	public MangledFunctionMapper(FunctionMapper linked ) {
		this.linked = linked;
	}
	@Override
	public String getFunctionName(NativeLibrary library, Method method) {
		Name name = method.getAnnotation(Name.class);
		if (name != null) {
			for (String n : name.value()) {
				try {
					if (library.getGlobalVariableAddress(n) != null)
						return n;
				} catch (Exception ex) {
					ex = null;
				}
			}
		}
		if (linked != null)
			return linked.getFunctionName(library, method);
		return method.getName();
	}
	
}
