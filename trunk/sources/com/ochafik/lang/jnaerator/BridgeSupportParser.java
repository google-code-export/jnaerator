package com.ochafik.lang.jnaerator;

import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.ochafik.xml.XMLUtils;
import com.ochafik.xml.XPathUtils;

public class BridgeSupportParser {
	final Result result;
	public BridgeSupportParser(Result result) {
		this.result = result;
	}

	public void parseBridgeSupportFiles() {
		for (File bsf : result.config.bridgeSupportFiles) {
			try {
				String framework = bsf.getName();
				if (framework.toLowerCase().endsWith(".framework"))
					framework = framework.substring(0, framework.length() - ".framework".length());
				
				Document xml = XMLUtils.readXML(bsf);
				for (Node string_constant : XPathUtils.findNodesIterableByXPath("signatures/string_constant", xml)) {
					String name = XMLUtils.getAttribute(string_constant, "name");
					String value = XMLUtils.getAttribute(string_constant, "value");
					if (value != null) {
						Result.getMap(result.stringConstants, framework).put(name, value);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
