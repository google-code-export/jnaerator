/*
	Copyright (c) 2009 Olivier Chafik, All Rights Reserved
	
	This file is part of JNAerator (http://jnaerator.googlecode.com/).
	
	JNAerator is free software: you can redistribute it and/or modify
	it under the terms of the GNU Lesser General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.
	
	JNAerator is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU Lesser General Public License for more details.
	
	You should have received a copy of the GNU Lesser General Public License
	along with JNAerator.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.ochafik.lang.jnaerator;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.xpath.XPathExpressionException;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.ochafik.lang.jnaerator.parser.Arg;
import com.ochafik.lang.jnaerator.parser.Declarator;
import com.ochafik.lang.jnaerator.parser.Function;
import com.ochafik.lang.jnaerator.parser.ObjCDemanglingLexer;
import com.ochafik.lang.jnaerator.parser.ObjCDemanglingParser;
import com.ochafik.lang.jnaerator.parser.ObjCppParser;
import com.ochafik.lang.jnaerator.parser.StoredDeclarations;
import com.ochafik.lang.jnaerator.parser.Struct;
import com.ochafik.lang.jnaerator.parser.TypeRef;
import com.ochafik.lang.jnaerator.parser.Function.Type;
import com.ochafik.xml.XMLUtils;
import com.ochafik.xml.XPathUtils;

import static com.ochafik.lang.jnaerator.parser.ElementsHelper.*;

public class BridgeSupportParser {
	final Result result;
	SourceFiles sourceFiles;
	public BridgeSupportParser(Result result, SourceFiles sourceFiles) {
		this.result = result;
		this.sourceFiles = sourceFiles;
	}

	public static void main(String[] args) {
		try {
			JNAeratorConfig config = new JNAeratorConfig();
			config.verbose = true;
			Result result = new Result(config, null);
			SourceFiles sourceFiles = new SourceFiles();
			File file = new File("/System/Library/Frameworks/Foundation.framework/Resources/BridgeSupport/FoundationFull.bridgesupport");
			new BridgeSupportParser(result, sourceFiles).parseBridgeSupportFile(file);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void parseBridgeSupportFiles() {
		for (File bsf : result.config.bridgeSupportFiles) {
			try {
				parseBridgeSupportFile(bsf);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void parseBridgeSupportFile(File bsf) throws Exception {

		String framework = bsf.getName();
		if (framework.toLowerCase().endsWith(".bridgesupport"))
			framework = framework.substring(0, framework.length() - ".bridgesupport".length());
		
		Document xml = XMLUtils.readXML(bsf);
		
		String sourceFilePath = bsf.toString();
		Node signatures = XMLUtils.getFirstNamedNode(xml, "signatures");
		if (signatures == null)
			return;
		
		parseStructs(framework, signatures, sourceFilePath);
		parseStringConstants(framework, signatures);
		parseFunctions(framework, signatures, sourceFilePath);
		parseClasses(framework, signatures, sourceFilePath);
	}

	private void parseClasses(String framework, Node signatures, String sourceFilePath) throws XPathExpressionException {
		for (Node classe : XMLUtils.getChildrenByName(signatures, "class")) {
			Struct cs = parseClasse(classe, Struct.Type.ObjCClass, sourceFilePath);
			if (cs == null)
				continue;
			cs.accept(result);
		}
		for (Node classe : XMLUtils.getChildrenByName(signatures, "informal_protocol")) {
			Struct cs = parseClasse(classe, Struct.Type.ObjCClass, sourceFilePath);
			if (cs == null)
				continue;
			cs.setCategoryName(cs.getTag() == null ? null : cs.getTag().toString());
			cs.setTag(ident("NSObject"));
			cs.accept(result);
		}
	}
	private Struct parseClasse(Node classe,
			com.ochafik.lang.jnaerator.parser.Struct.Type type,
			String sourceFilePath) throws XPathExpressionException {
		
		Struct cs = new Struct();
		cs.setType(type);
		String name = XMLUtils.getAttribute(classe, "name");
		if (result.config.verbose)
			System.out.println("Parsing class " + name);
		cs.setTag(ident(name));
		
		for (Node method : XPathUtils.findNodesIterableByXPath("method", classe)) {
			
			try {
				cs.addDeclaration(parseFunction(Type.ObjCMethod, method, sourceFilePath));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return cs;
	}

	private void parseFunctions(String framework, Node signatures, String sourceFilePath) throws XPathExpressionException {
		for (Node function : XMLUtils.getChildrenByName(signatures, "function")) {
			String name = XMLUtils.getAttribute(function, "name");
			Node retval = XMLUtils.getFirstNamedNode(function, "retval");
			String already_retained = retval != null ? XMLUtils.getAttribute(retval, "already_retained") : null;
			if (already_retained != null && (already_retained = already_retained.trim()).length() > 0)
			{
				boolean alreadyRetained = "true".equals(already_retained);
				Result.getMap(result.retainedRetValFunctions, framework).put(name, alreadyRetained);
			}
			if ("true".equals(XMLUtils.getAttribute(function, "inline")))
				continue; // TODO handle inline functions : link to BridgeSupport auxiliary library
			
			try {
				Function f = parseFunction(Type.CFunction, function, sourceFilePath);
				if (f == null)
					continue;
				f.accept(result);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	public TypeRef parseType(Node node) throws XPathExpressionException, RecognitionException, IOException {
		if (node == null)
			return null;
		try {
			String dt = XMLUtils.getAttribute(node, "declared_type");
			if (dt != null) {
				ObjCppParser parser = JNAeratorParser.newObjCppParser(result.typeConverter, dt, false);
				parser.setupSymbolsStack();
				TypeRef tr = parser.mutableTypeRef();
				if (tr != null)
					return tr;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return parseAndReconciliateType(XMLUtils.getAttribute(node, "type"), XMLUtils.getAttribute(node, "type64"));
	}
	private Function parseFunction(Type cfunction, Node function, String sourceFilePath) throws XPathExpressionException, RecognitionException, IOException {
		TypeRef tr = parseType(XMLUtils.getFirstNamedNode(function, "retval"));
//		if (tr == null)
//			tr = typeRef("id");
		
		String selector = XMLUtils.getAttribute(function, "selector");
		String[] splitSelector = selector == null ? null : selector.split(":");
		String name = XMLUtils.getAttribute(function, "name");
		if (name == null && splitSelector != null && splitSelector.length > 0)
			name = splitSelector[0];
		Function f = new Function(Type.CFunction, ident(name), tr);
		f.setElementFile(sourceFilePath);
		int iArg = 0;
		for (Node arg : XMLUtils.getChildrenByName(function, "arg")) {//XPathUtils.findNodesIterableByXPath("arg", function)) {
			TypeRef at = parseType(arg);
			if (at == null)
				return null;
			Arg a = new Arg();
			a.setName(XMLUtils.getAttribute(arg, "name"));
			a.setValueType(at);
			a.setSelector(splitSelector == null || iArg >= splitSelector.length ? null : splitSelector[iArg]);
			f.addArg(a);
			iArg++;
		}
		return f;
	}

	TypeRef parseType(String mangled) throws RecognitionException, IOException {
		return newObjCDemangler(mangled, true).mangledTypeEOF();
	}
	TypeRef parseAndReconciliateType(String mangled32, String mangled64) throws RecognitionException, IOException {
//		System.out.println("Parsing \"" + mangled32 + "\":");
		if (mangled32 == null)
			return null;
		
		TypeRef tr32 = parseType(mangled32);
		if (mangled64 != null  && mangled64.trim().length() > 0 && !mangled32.equals(mangled64)) {
//			System.out.println("Parsing \"" + mangled64 + "\":");
			TypeRef tr64 = parseType(mangled64);
		
			try {
				return result.universalReconciliator.reconciliate32bitsAnd64bits(tr32, tr64);
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
		} else
			return tr32;
		
	}
	private void parseStructs(String framework, Node signatures, String sourceFilePath) throws XPathExpressionException {
		for (Node function : XMLUtils.getChildrenByName(signatures, "struct")) {//PathUtils.findNodesIterableByXPath("signatures/struct", xml)) {
			String name = XMLUtils.getAttribute(function, "name");
			String type32 = XMLUtils.getAttribute(function, "type"), type64 = XMLUtils.getAttribute(function, "type64");
			try {
				try {
					TypeRef tr = parseAndReconciliateType(type32, type64);
					StoredDeclarations.TypeDef td = new StoredDeclarations.TypeDef(tr, new Declarator.DirectDeclarator(name));
					//td.addToCommentBefore("Original signature : " + type32);
					td.setElementFile(sourceFilePath);
					
//					System.out.println(td);
//					System.out.println();
					
					td.accept(result);
				} catch (Exception ex) {
					ex.printStackTrace();
					continue;
				}
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			//Result.getMap(result.retainedRetValFunctions, framework).put(name, alreadyRetained);
			//}
		}
	}
	static ObjCDemanglingParser newObjCDemangler(String s, final boolean verbose) throws IOException {
		return new ObjCDemanglingParser(
				new CommonTokenStream(
						new ObjCDemanglingLexer(
								new ANTLRReaderStream(new StringReader(s))
						)
				)
//				, new DummyDebugEventListener()
		) {
			@Override
			public void reportError(RecognitionException arg0) {
				if (verbose)
					super.reportError(arg0);
			}
		};
	}

	private void parseStringConstants(String framework, Node signatures) throws XPathExpressionException {
		for (Node string_constant : XMLUtils.getChildrenByName(signatures, "string_constant")) {
			String name = XMLUtils.getAttribute(string_constant, "name");
			String value = XMLUtils.getAttribute(string_constant, "value");
			if (value != null) {
				Result.getMap(result.stringConstants, framework).put(name, value);
			}
		}
	}
}
