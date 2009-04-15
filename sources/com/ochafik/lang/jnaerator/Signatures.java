package com.ochafik.lang.jnaerator;

import java.util.HashSet;
import java.util.Set;

import com.ochafik.lang.jnaerator.parser.Identifier;

public class Signatures {
	public Set<Identifier> 
		classSignatures = new HashSet<Identifier>();

	public Set<String> 
		variablesSignatures = new HashSet<String>(),
		methodsSignatures = new HashSet<String>();
	
}
