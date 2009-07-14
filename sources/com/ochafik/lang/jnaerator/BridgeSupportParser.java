package com.ochafik.lang.jnaerator;

import java.io.File;

import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.ochafik.xml.XMLUtils;
import com.ochafik.xml.XPathUtils;

public class BridgeSupportParser {
	final Result result;
	SourceFiles sourceFiles;
	public BridgeSupportParser(Result result, SourceFiles sourceFiles) {
		this.result = result;
		this.sourceFiles = sourceFiles;
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
		
		parseStringConstants(framework, xml);
		parseFunctions(framework, xml);
		//TODO parse all the rest !!!
	}

	private void parseFunctions(String framework, Document xml) throws XPathExpressionException {
		for (Node function : XPathUtils.findNodesIterableByXPath("signatures/function", xml)) {
			String name = XMLUtils.getAttribute(function, "name");
			String already_retained = XPathUtils.findStringByXPath("retval/@already_retained", function);
			if (already_retained != null && (already_retained = already_retained.trim()).length() > 0)
			{
				boolean alreadyRetained = "true".equals(already_retained);
				Result.getMap(result.retainedRetValFunctions, framework).put(name, alreadyRetained);
			}
		}
	}

	private void parseStringConstants(String framework, Document xml) throws XPathExpressionException {
		for (Node string_constant : XPathUtils.findNodesIterableByXPath("signatures/string_constant", xml)) {
			String name = XMLUtils.getAttribute(string_constant, "name");
			String value = XMLUtils.getAttribute(string_constant, "value");
			if (value != null) {
				Result.getMap(result.stringConstants, framework).put(name, value);
			}
		}
	}
}
