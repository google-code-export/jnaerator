package com.ochafik.lang.jnaerator.runtime;

import java.lang.reflect.Field;

public class Structure<S extends Structure<S>> 
	extends com.sun.jna.Structure
	implements Comparable<Structure<S>> 
{
	protected <T extends Structure<?>> T setupClone(T clone) {
		write();
		clone.useMemory(getPointer());
		clone.read();
		return clone;
	}
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
//	@Override
	protected Integer getBitsAnnotation(Field field) {
		Bits bits = field.getAnnotation(Bits.class);
		return bits == null ? null : bits.value();
	}
	/** Simply does a memcmp between the two memory blocks of the two structures
     */
	@Override
	public int compareTo(Structure<S> o) {
        if (o == this)
            return 0;
        if (!(o instanceof Structure<?>))
        	return 1;
        
        int size = size();
        int d = size - ((Structure<?>)o).size();
        if (d != 0)
        	return d;
        
        Structure<?> s = (Structure<?>)o;
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
