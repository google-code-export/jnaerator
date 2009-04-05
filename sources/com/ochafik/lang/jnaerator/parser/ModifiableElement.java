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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class ModifiableElement extends Element {
	protected final List<Modifier> modifiers = new ArrayList<Modifier>();
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visitModifiableElement(this);
	}
	
	protected final List<Annotation> annotations = new ArrayList<Annotation>();
	public void addAnnotations(List<Annotation> as) {
		for (Annotation a : as)
			addAnnotation(a);
	}
	public void addAnnotation(Annotation a) {
		if (a != null) {
			annotations.add(a);
			a.setParentElement(this);
		}
	}

	public List<Annotation> getAnnotations() {
		return unmodifiableList(annotations);
	}
	public void setAnnotations(List<Annotation> annotations) {
		changeValue(this, this.annotations, annotations);
	}

	public boolean isUnsigned() {
		return (getModifiers().contains(Modifier.__unsigned) ||
		getModifiers().contains(Modifier.Unsigned));
 	}
	public boolean isConst() {
		return getModifiers().contains(Modifier.__const) ||
			getModifiers().contains(Modifier.Const);
 	}
	@Override
	public boolean replaceChild(Element child, Element by) {
		if (replaceChild(annotations, Annotation.class, this, child, by))
			return true;
		
		return false;
	}
	

	@Override
	public Element getNextChild(Element child) {
		return getNextSibling(annotations, child);
	}
	@Override
	public Element getPreviousChild(Element child) {
		return getPreviousSibling(annotations, child);
	}

	public ModifiableElement addModifiers(List<Modifier> mods) {
		if (mods != null)
			for (Modifier mod : mods) {
				if (mod != null)
					modifiers.add(mod);
			}
		return this;
	}

	public ModifiableElement addModifiers(Modifier... mds) {
		return addModifiers(Arrays.asList(mds));
	}

	public List<Modifier> getModifiers() {
		return Collections.unmodifiableList(modifiers);
	}
	public void setModifiers(List<Modifier> modifiers) {
		this.modifiers.clear();
		if (modifiers != null)
			this.modifiers.addAll(modifiers);
	}
	
}
