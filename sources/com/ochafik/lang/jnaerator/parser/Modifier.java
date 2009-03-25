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

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @see http://msdn.microsoft.com/en-us/library/dabb5z75.aspx
 */
public enum Modifier {
	_cdecl(Kind.CallingConvention),
	__cdecl(Kind.CallingConvention),
	_stdcall(Kind.CallingConvention),
	__stdcall(Kind.CallingConvention),
	
	/// VC++ annotations 
	/// @see http://msdn.microsoft.com/en-us/library/cc264104.aspx
	
	__pre(Kind.VCAnnotationNoArg),
	__valid(Kind.VCAnnotationNoArg),
	__reserved(Kind.VCAnnotationNoArg),
	__checkReturn(Kind.VCAnnotationNoArg),
	__fallthrough(Kind.VCAnnotationNoArg),
	__readonly(Kind.VCAnnotationNoArg),
	__null(Kind.VCAnnotationNoArg),
	__in(Kind.VCAnnotationNoArg),
	__out(Kind.VCAnnotationNoArg),
	__inout(Kind.VCAnnotationNoArg),
	__refparam(Kind.VCAnnotationNoArg),
	__exceptthat(Kind.VCAnnotationNoArg),
	
	_opt(Kind.VCAnnotationNoArg),
	_deref(Kind.VCAnnotationNoArg),
	_deref_opt(Kind.VCAnnotationNoArg),
	_ecount(Kind.VCAnnotation1Arg),
	_bcount(Kind.VCAnnotation1Arg),
	_full(Kind.VCAnnotation1Arg),
	_part(Kind.VCAnnotation2Args),
	
	__ptr64(Kind.TypeQualifier), // TODO find better kind 
	__maybenull(Kind.TypeQualifier),
	__nullterminated(Kind.TypeQualifier, Kind.StringAnnotation),
	__nullnullterminated(Kind.TypeQualifier, Kind.StringAnnotation),
	__possibly_notnullterminated(Kind.TypeQualifier, Kind.StringAnnotation),
	//__success,
	
	Auto(Kind.StorageClassSpecifier),
	Register(Kind.StorageClassSpecifier),
	Static(Kind.StorageClassSpecifier), 
	Extern(Kind.StorageClassSpecifier),
	Pascal(Kind.StorageClassSpecifier),
	//TypeDef(Kind.StorageClassSpecifier), // TODO propagate this to everywhere : need to remove TypeDef class
	
	Const(Kind.TypeQualifier), 
	__const(Kind.TypeQualifier), 
	Volatile(Kind.TypeQualifier), 
	Mutable(Kind.TypeQualifier),
	
	Unsigned(Kind.NumericTypeQualifier, Kind.SignModifier),
	Signed(Kind.NumericTypeQualifier, Kind.SignModifier),
	__Unsigned(Kind.NumericTypeQualifier, Kind.SignModifier),
	__Signed(Kind.NumericTypeQualifier, Kind.SignModifier),
	Long(Kind.NumericTypeQualifier, Kind.SizeModifier),
	Short(Kind.NumericTypeQualifier, Kind.SizeModifier),
	
	Typename(Kind.ReferenceQualifier),
	Struct(Kind.ReferenceQualifier),
	Class(Kind.ReferenceQualifier),

	/*primSignModifier
		:	'signed' | 'unsigned' | '__signed' | '__unsigned';
		*/	
	
	//Transient(Kind.TypeQualifier, Kind.Java), 
	
	Public(Kind.Publicity),
	Final(Kind.Publicity),
	Private(Kind.Publicity), 
	Protected(Kind.Publicity),
	
	Inline,
	__inline,
	__inline__,

	Align(Kind.Declspec, Kind.HasArguments),
	Allocate(Kind.Declspec, Kind.HasArguments),
	AppDomain(Kind.Declspec),
	Deprecated(Kind.Declspec, Kind.Attribute),
	DllExport(Kind.Declspec, Kind.StorageClassSpecifier),
	DllImport(Kind.Declspec, Kind.StorageClassSpecifier),
	JITIntrinsic(Kind.Declspec),
	Naked(Kind.Declspec, Kind.StorageClassSpecifier, Kind.Attribute),
	NoAlias(Kind.Declspec, Kind.StorageClassSpecifier),
	NoInline(Kind.Declspec),
	NoReturn(Kind.Declspec),
	NoThrow(Kind.Declspec, Kind.StorageClassSpecifier),
	NoVTable(Kind.Declspec),
	Process(Kind.Declspec),
	Property(Kind.Declspec, Kind.HasArguments, Kind.StorageClassSpecifier, Kind.COMSpecific), //TODO handle args
	Restrict(Kind.Declspec, Kind.StorageClassSpecifier),
	SelectAny(Kind.Declspec, Kind.StorageClassSpecifier, Kind.COMSpecific),
	Thread(Kind.Declspec),
	UUID(Kind.Declspec, Kind.HasArguments, Kind.StorageClassSpecifier, Kind.COMSpecific),
	
	Alias(Kind.Attribute),
	Always_inline(Kind.Attribute),
	Cdecl(Kind.Attribute),
	//Const(Kind.Attribute),
	Constructor(Kind.Attribute),
	Destructor(Kind.Attribute),
	Dllexport(Kind.Attribute),
	Dllimport(Kind.Attribute),
	Eightbit_data(Kind.Attribute),
	Exception(Kind.Attribute),
	Far(Kind.Attribute),
	Fastcall(Kind.Attribute),
	Format(Kind.Attribute),
	Format_arg(Kind.Attribute),
	Function_vector(Kind.Attribute),
	Interrupt(Kind.Attribute),
	Interrupt_handler(Kind.Attribute),
	Long_call(Kind.Attribute),
	Short_call(Kind.Attribute),
	Longcall(Kind.Attribute),
	Shortcall(Kind.Attribute),
	Malloc(Kind.Attribute),
	Model(Kind.Attribute),
	Near(Kind.Attribute),
	No_check_memory_usage(Kind.Attribute),
	No_instrument_function(Kind.Attribute),
	Noinline(Kind.Attribute),
	Nonnull(Kind.Attribute),
	Noreturn(Kind.Attribute),
	Nothrow(Kind.Attribute),
	Pure(Kind.Attribute),
	Regparm(Kind.Attribute),
	Saveall(Kind.Attribute),
	Section(Kind.Attribute),
	Signal(Kind.Attribute),
	Sp_switch(Kind.Attribute),
	Stdcall(Kind.Attribute),
	Tiny_data(Kind.Attribute),
	Trap_exit(Kind.Attribute),
	Unused(Kind.Attribute),
	Used(Kind.Attribute),
	Visibility(Kind.Attribute),
	Warn_unused_result(Kind.Attribute),
	Weak(Kind.Attribute), 
	
	Synchronized;
	
	EnumSet<Modifier.Kind> kinds = EnumSet.noneOf(Modifier.Kind.class);
	Modifier alias;
	
	Modifier(Modifier.Kind... kinds) {
		for (Modifier.Kind kind : kinds)
			this.kinds.add(kind);
	}
	Modifier(Modifier alias, Modifier.Kind... kinds) {
		this(kinds);
		this.alias = alias;
	}
	public Modifier getAlias() {
		return alias;
	}
	
	public enum Kind {
		StorageClassSpecifier, 
		TypeQualifier, 
		Declspec, /// VC++ __declspec
		Attribute, /// GCC __attribute__ 
		Publicity, 
		CallingConvention,
		HasArguments,
		COMSpecific,
		MSSpecific,
		
		Java, Cpp, C, ObjC, 
		
		Plain, Extended, 
		
		NumericTypeQualifier, ReferenceQualifier, SizeModifier, SignModifier, 
		
		///http://msdn.microsoft.com/en-us/library/cc264105.aspx
		StringAnnotation, VCAnnotationNoArg
	, VCAnnotation2Args, VCAnnotation1Arg};
	
	static Map<String, Modifier> mods = new 
	HashMap<String, Modifier>();
	static {
		for (Modifier m : values()) {
			mods.put(m.toString(), m);
		}
	}
	/**
	 * @param name modifier name to parse
	 * @param kinds if not empty, returns only a modifier that matches all of the kinds
	 * @return Modifier that matches any of the kinds constraints
	 */
	public static Modifier parseModifier(String name, Modifier.Kind... kinds) {
		try {
			//Modifier modifier = Modifier.valueOf(name);
			Modifier modifier = mods.get(name);
			if (kinds.length == 0 || modifier == null)
				return modifier;
			for (Modifier.Kind kind : kinds)
				if (modifier.isA(kind))
					return modifier;
			return kinds.length > 0 ? null : modifier;
		} catch (IllegalArgumentException ex) {
			return null;
		}
	}
	
	/**
	 * Try to be smart about Kind inheritance (C => C++ or Objective-C)
	 */
	public boolean isA(Kind k) {
		if (k == Kind.Plain && !(kinds.contains(Kind.Attribute) || kinds.contains(Kind.Declspec)))
			return true;
		if (k == Kind.Extended && (kinds.contains(Kind.Attribute) || kinds.contains(Kind.Declspec)))
			return true;
		if (k == Kind.Cpp && kinds.contains(Kind.C))
			return true;
		if (k == Kind.ObjC && kinds.contains(Kind.C))
			return true;
		
		return kinds.contains(k);
	}
	
	public boolean isAnyOf(Kind...kinds) {
		for (Kind kind : kinds)
			if (isA(kind))
				return true;
		
		return false;
	}
	
	public boolean isAllOf(Kind...kinds) {
		for (Kind kind : kinds)
			if (!isA(kind))
				return false;
		
		return true;
	}
	
	public enum Compiler {
		GCC, MSVC, Other, Any
	}

	@Override
	public String toString() {
		return toString(Compiler.Any);
	}
	public String toString(Modifier.Compiler compiler) {
		String low = super.toString().toLowerCase();
		if (kinds.contains(Kind.Declspec) && (compiler == Compiler.Any || compiler == Compiler.MSVC))
			return "__declspec(" + low + ")";
		
		if (kinds.contains(Kind.Attribute) && (compiler == Compiler.Any || compiler == Compiler.GCC))
			return "__attribute__((" + low + "))";
		
		return low;
	}
}