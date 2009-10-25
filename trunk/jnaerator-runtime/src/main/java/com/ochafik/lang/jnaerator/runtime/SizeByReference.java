package com.ochafik.lang.jnaerator.runtime;

import com.sun.jna.ptr.ByReference;

public class SizeByReference extends ByReference {
    public SizeByReference() {
        this(new Size(0));
    }

    public SizeByReference(Size value) {
        super(Size.SIZE);
        setValue(value);
    }

    public void setValue(Size value) {
        if (Size.SIZE == 4)
			getPointer().setInt(0, value.intValue());
		else if (Size.SIZE == 8)
			getPointer().setLong(0, value.longValue());
		else
			throw new RuntimeException("GCCLong has to be either 4 or 8 bytes.");
    }

    public Size getValue() {
		if (Size.SIZE == 4)
			return new Size(getPointer().getInt(0));
		else if (Size.SIZE == 8)
			return new Size(getPointer().getLong(0));
		else
			throw new RuntimeException("GCCLong has to be either 4 or 8 bytes.");
    }
}
