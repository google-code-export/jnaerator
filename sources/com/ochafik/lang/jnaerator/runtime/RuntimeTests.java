package com.ochafik.lang.jnaerator.runtime;

import org.junit.Assert;
import org.junit.Test;


public class RuntimeTests {
	public static class TestStruct extends Structure<TestStruct> {
		@Bits(1) public int i0;
		@Bits(1) public int i1;
		public short s;
		@Bits(3) public int i2;
		@Bits(1) public int i3;
	}
	@Test
	public void bitFieldRead() {
		TestStruct s = new TestStruct();
		s.i0 = 3;
		s.s = -1;
		s.i2 = -1;
		s.write();
		s.read();
		
		Assert.assertEquals(1, s.i0); // 3 & 1
		Assert.assertEquals(0, s.i1);
		Assert.assertEquals(-1, s.s);
		Assert.assertEquals(7, s.i2); // -1 & (1 << 3)
		Assert.assertEquals(0, s.i3);
	}
}
