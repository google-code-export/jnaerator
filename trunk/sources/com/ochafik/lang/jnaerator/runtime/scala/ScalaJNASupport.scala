package com.ochafik.lang.jnaerator.runtime.scala;
import com.sun.jna._;
import com.sun.jna.ptr._;
class ScalaJNASupport {
	implicit def long2NativeLong(v: Long) = { new NativeLong(v); }
	implicit def int2NativeLong(v: Int) = { new NativeLong(v); }
}