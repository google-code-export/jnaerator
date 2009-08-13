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

import java.lang.reflect.Field;

import com.sun.jna.Pointer;

public abstract class Structure<S extends Structure<S, V, R>, V extends S, R extends S> 
	extends com.sun.jna.Structure
	implements Comparable<Structure<S, V, R>> 
{
//	protected void jnaRead() {
//		super.read();
//	}
//	
//	protected void jnaWrite() {
//		super.write();
//	}
//	
//	protected abstract StructIO getStructIO();
//	
//	public void read() {
//		getStructIO().read(this);
//	}
//	public void write() {
//		getStructIO().write(this);
//	}
//	
//	/// Class responsible for the read/write operations of a struct.
//	public interface StructIO  {
//		void read(Structure<?, ?, ?> s);
//		void write(Structure<?, ?, ?> s);
//	}
//	public static StructIO getStructIO(Class<? extends Structure<?, ?, ?>> structClass) {
//		// TODO generate bytecode with specialized read/write methods for the class
//		return new StructIO() {
//			public void read(Structure<?, ?, ?> s) {
//				s.jnaRead();
//			}
//			public void write(Structure<?, ?, ?> s) {
//				s.jnaWrite();
//			}
//		};
//	}
	
	protected <T extends Structure<?, ?, ?>> T setupClone(T clone) {
		write();
		clone.useMemory(getPointer());
		clone.read();
		return clone;
	}
	
	@Override
	public void useMemory(Pointer m) {
		super.useMemory(m);
		read();
	}
	//getFieldOffset(String fieldName);
	
	protected abstract S newInstance();
	protected abstract V newByValue();
	protected abstract R newByReference();
	
	public R byReference() { return setupClone(newByReference()); }
	public V byValue() { return setupClone(newByValue()); }
	public S clone() { return setupClone(newInstance()); }
	
	@SuppressWarnings("unchecked")
	@Override
	public S[] toArray(int size) {
		return (S[])super.toArray(size);
	}
	public S[] toArray() {
		return toArray(1);
	}
	@SuppressWarnings("unchecked")
	@Override
	public S[] toArray(com.sun.jna.Structure[] array) {
		return (S[])super.toArray(array);
	}
	@Override
	protected Integer getBitsAnnotation(Field field) {
		Bits bits = field.getAnnotation(Bits.class);
		return bits == null ? null : bits.value();
	}
	/** Simply does a memcmp between the two memory blocks of the two structures
     */
	@Override
	public int compareTo(Structure<S, V, R> o) {
        if (o == this)
            return 0;
        if (!(o instanceof Structure<?, ?, ?>))
        	return 1;
        
        int size = size();
        int d = size - ((Structure<?, ?, ?>)o).size();
        if (d != 0)
        	return d;
        
        Structure<?, ?, ?> s = (Structure<?, ?, ?>)o;
        if (getPointer().equals(s.getPointer()))
        	return 0;
        
        write();
        s.write();
        
        byte[] bytes1 = getPointer().getByteArray(0, size);
        byte[] bytes2 = s.getPointer().getByteArray(0, size);
        
        for (int i = 0; i < size; i++) {
        	byte b1 = bytes1[i], b2 = bytes2[i];
        	if (b1 != b2)
        		return b1 < b2 ? -1 : 1;
        }
        return 0;
//        try {
//	        for (Field f : getClass().getFields()) {
//	        	Object v1 = f.get(this), v2 = f.get(o);
//	        	if (v1 == null) {
//	        		if (v2 != null)
//	        			return -1;
//	        	} else if (v2 == null)
//	        		return 1;
//	        	
//	        	d = ((Comparable)v1).compareTo(v2);
//	        	if (d != 0)
//	        		return d;
//	        }
//	        return 0;
//        } catch (Exception ex) {
//        	throw new RuntimeException("Failed to compare structures of type " + getClass().getName(), ex);
//        }
    }
}
