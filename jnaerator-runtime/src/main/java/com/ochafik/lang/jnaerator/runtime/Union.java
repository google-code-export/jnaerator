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
package com.ochafik.lang.jnaerator.runtime;

import java.lang.ref.WeakReference;
import java.nio.Buffer;

import com.sun.jna.Native;
import com.sun.jna.Pointer;

public abstract class Union<S extends Union<S, V, R>, V extends S, R extends S> 
	extends com.sun.jna.Union
	implements
		StructureType,
		StructureTypeDependent
{	
	public interface ByReference extends com.sun.jna.Union.ByReference, StructureTypeDependent {}
	public interface ByValue extends com.sun.jna.Union.ByValue, StructureTypeDependent {}

	transient WeakReference<StructureType> dependency;
	@Override
	public void setDependency(StructureType type) {
		this.dependency = type == null ? null : new WeakReference<StructureType>(type);
	}
	protected void readDependency() {
		StructureType dep;
		if (dependency == null || (dep = dependency.get()) == null)
			return;
		dep.read();
	}
	@Override
	public void read() {
		super.read();
		readDependency();
	}
	@Override
	public void write() {
		super.write();
		readDependency();
	}
	@SuppressWarnings("unchecked")
	@Override
	public S[] toArray(int size) {
		return (S[])super.toArray(size);
	}
	public S[] toArray() {
		return toArray(1);
	}
	
	protected abstract S newInstance();
	protected abstract V newByValue();
	protected abstract R newByReference();
	
	public R byReference() { return setupClone(newByReference()); }
	public V byValue() { return setupClone(newByValue()); }
	public S clone() { return setupClone(newInstance()); }
	
	
	@SuppressWarnings("unchecked")
	@Override
	public S[] toArray(com.sun.jna.Structure[] array) {
		return (S[])super.toArray(array);
	}

	protected <T extends Union<?, ?, ?>> T setupClone(T clone) {
		write();
		clone.use(getPointer());
		return clone;
	}
	
	public Union<S, V, R> use(Pointer m) {
		return use(m, 0);
	}
	public Union<S, V, R> use(Pointer m, long byteOffset) {
		useMemory(m, (int)byteOffset);
		return this;
	}
	public Union<S, V, R> use(Buffer m) {
		return use(m, 0);
	}
	public Union<S, V, R> use(Buffer b, long byteOffset) {
		useMemory(Native.getDirectBufferPointer(b), (int)byteOffset);
		return this;
	}
	
}
