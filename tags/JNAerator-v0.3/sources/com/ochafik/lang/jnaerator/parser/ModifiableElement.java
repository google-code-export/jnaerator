/*
	Copyright (c) 2009 Olivier Chafik, All Rights Reserved
	
	This file is part of JNAerator (http://jnaerator.googlecode.com/).
	
	JNAerator is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.
	
	JNAerator is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.
	
	You should have received a copy of the GNU General Public License
	along with JNAerator.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.ochafik.lang.jnaerator.parser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class ModifiableElement extends Element {
	protected List<Modifier> modifiers = new ArrayList<Modifier>();
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visitModifiableElement(this);
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
