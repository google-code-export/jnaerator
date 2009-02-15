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
package com.ochafik.lang.grammar.objcpp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ochafik.lang.grammar.objcpp.Struct.MemberVisibility;
import com.ochafik.util.string.StringUtils;

public abstract class Declaration extends Element {
	protected List<String> nameSpace = new ArrayList<String>();
	protected String name;
	protected TypeRef valueType;
	public MemberVisibility visibility;
	protected Set<Modifier> modifiers = new LinkedHashSet<Modifier>();
	final List<Annotation> annotations = new ArrayList<Annotation>();
	
	public enum Modifier {
		__cdecl,
		__stdcall,
		__pre,
		__valid,
		__deref,
		__readonly,
		__null,
		__refparam,
		__exceptthat,
		
		Public, 
		Private, 
		Protected, 
		Const, 
		Extern, 
		Static, 
		Volatile, 
		Inline,
		__inline__,
	
		// declspec
		//Align { @Override public String toString() { return "__declspec(" + super.toString() + ")"; } },
		//Allocate { @Override public String toString() { return "__declspec(" + super.toString() + ")"; } },
		AppDomain { 	@Override public String toString() { return "__declspec(" + super.toString() + ")"; } },
		Deprecated { 	@Override public String toString() { return "__declspec(" + super.toString() + ")"; } },
		DllExport { 	@Override public String toString() { return "__declspec(" + super.toString() + ")"; } },
		DllImport { 	@Override public String toString() { return "__declspec(" + super.toString() + ")"; } },
		JITIntrinsic { 	@Override public String toString() { return "__declspec(" + super.toString() + ")"; } },
		Naked { 		@Override public String toString() { return "__declspec(" + super.toString() + ")"; } },
		NoAlias { 		@Override public String toString() { return "__declspec(" + super.toString() + ")"; } },
		NoInline { 		@Override public String toString() { return "__declspec(" + super.toString() + ")"; } },
		NoReturn { 		@Override public String toString() { return "__declspec(" + super.toString() + ")"; } },
		NoThrow { 		@Override public String toString() { return "__declspec(" + super.toString() + ")"; } },
		NoVTable { 		@Override public String toString() { return "__declspec(" + super.toString() + ")"; } },
		Process { 		@Override public String toString() { return "__declspec(" + super.toString() + ")"; } },
		Property { 		@Override public String toString() { return "__declspec(" + super.toString() + ")"; } },
		Restrict { 		@Override public String toString() { return "__declspec(" + super.toString() + ")"; } },
		SelectAny { 	@Override public String toString() { return "__declspec(" + super.toString() + ")"; } },
		Thread { 		@Override public String toString() { return "__declspec(" + super.toString() + ")"; } },
		UUID { 			@Override public String toString() { return "__declspec(" + super.toString() + ")"; } };
		
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
	public static Modifier getExtendedModifier(String name) {
		return extMods.get(name);
	}
	public static Modifier getModifier(String name) {
		return mods.get(name);
	}
	static Map<String, Modifier> mods = new HashMap<String, Modifier>();
	static Map<String, Modifier> extMods = new HashMap<String, Modifier>();
	static {
		//extMods.put("align", Modifier.Align);
//		extMods.put("allocate", Modifier.Allocate);
		mods.put("__cdecl", Modifier.__cdecl); 
		mods.put("public", Modifier.Public);
		mods.put("private", Modifier.Private);
		mods.put("protected", Modifier.Protected);
		mods.put("const", Modifier.Const);
		mods.put("extern", Modifier.Extern);
		mods.put("static", Modifier.Static);
		mods.put("volatile", Modifier.Volatile);
		mods.put("inline", Modifier.Inline);
		mods.put("__inline__", Modifier.Inline);
		
		extMods.put("appdomain", Modifier.AppDomain);
		extMods.put("deprecated", Modifier.Deprecated);
		extMods.put("dllimport", Modifier.DllExport);
		extMods.put("dllexport", Modifier.DllImport);
		extMods.put("jitintrinsic", Modifier.JITIntrinsic);
		extMods.put("naked", Modifier.Naked);
		extMods.put("noalias", Modifier.NoAlias);
		extMods.put("noinline", Modifier.NoInline);
		extMods.put("noreturn", Modifier.NoReturn);
		extMods.put("nothrow", Modifier.NoThrow);
		extMods.put("novtable", Modifier.NoVTable);
		extMods.put("process", Modifier.Process);
		extMods.put("property", Modifier.Property);
		extMods.put("restrict", Modifier.Restrict);
		extMods.put("selectany", Modifier.SelectAny);
		extMods.put("thread", Modifier.Thread);
		extMods.put("uuid", Modifier.UUID);
	}
	
	public void addModifier(Modifier mod) {
		if (mod != null)
			modifiers.add(mod);
	}
	public void addModifiers(List<Modifier> mods) {
		if (mods != null)
			for (Modifier mod : mods)
				addModifier(mod);
	}
	@Override
	public Element getNextChild(Element child) {
		return getNextSibling(annotations, child);
	}
	@Override
	public Element getPreviousChild(Element child) {
		return getPreviousSibling(annotations, child);
	}

	@Override
	public Declaration clone() {
		return (Declaration) super.clone();
	}
	public Set<Modifier> getModifiers() {
		return Collections.unmodifiableSet(modifiers);
	}
	public void setModifiers(Set<Modifier> modifiers) {
		this.modifiers.clear();
		if (modifiers != null)
			this.modifiers.addAll(modifiers);
	}
	
	public static Modifier getExportationModifier(String identifier) {
		if (identifier.matches("^[A-Z_]+_EXPORTS?$"))
			return Modifier.DllExport;
		if (identifier.equals("extern"))
			return Modifier.Extern;
		return null;
	}
	
	public TypeRef getValueType() {
		return valueType;
	}
	public void setValueType(TypeRef valueType) {
		this.valueType = changeValue(this, this.valueType, valueType);
	}
	
	@Override
	public boolean replaceChild(Element child, Element by) {
		if (child == getValueType()) {
			setValueType((TypeRef) by);
			return true;
		}
		if (replaceChild(annotations, Annotation.class, this, child, by))
			return true;
		
		return false;
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

	
	public String getModifiersStringPrefix() {
		return StringUtils.implode(modifiers, " ") + (modifiers.isEmpty() ? "" : " ");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addNameSpace(String nameSpace) {
		this.nameSpace.add(0, nameSpace);
	}
	public List<String> getNameSpace() {
		return unmodifiableList(nameSpace);
	}
	public void setNameSpace(List<String> nameSpace) {
		this.nameSpace.clear();
		this.nameSpace.addAll(nameSpace);
	}
	public void setVisibility(MemberVisibility visibility) {
		this.visibility = visibility;
	}
	public MemberVisibility getVisibility() {
		return visibility;
	}
	
}
