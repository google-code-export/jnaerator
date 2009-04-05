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
package com.ochafik.lang.jnaerator.parser;

public class Annotation extends Element {

	Class<? extends java.lang.annotation.Annotation> annotationClass;
	String arguments;
	
	public Annotation() {
		
	}
	
	public Annotation(Class<? extends java.lang.annotation.Annotation> annotationClass, String arguments) {
		setAnnotationClass(annotationClass);
		setArguments(arguments);
	}
	public Annotation(Class<? extends java.lang.annotation.Annotation> annotationClass) {
		setAnnotationClass(annotationClass);
	}

	public void setArguments(String arguments) {
		this.arguments = arguments;
	}
	public String getArguments() {
		return arguments;
	}
	
	public Class<? extends java.lang.annotation.Annotation> getAnnotationClass() {
		return annotationClass;
	}
	public void setAnnotationClass(
			Class<? extends java.lang.annotation.Annotation> annotationClass) {
		this.annotationClass = annotationClass;
	}
	
	@Override
	public String toString(CharSequence indent) {
		return indent + "@" + getAnnotationClass().getName() + (getArguments() != null ? getArguments() : "");
	}
	
	/*public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}*/
	
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visitAnnotation(this);
	}
	
	@Override
	public Element getNextChild(Element child) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element getPreviousChild(Element child) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean replaceChild(Element child, Element by) {
		// TODO Auto-generated method stub
		return false;
	}

}
