package com.ochafik.lang.jnaerator.runtime.scala;
import org.rococoa._;
import org.rococoa.cocoa._;
class ScalaRococoaSupport {
	implicit def float2CGFloat(v: Float) = { new CGFloat(v); }
	implicit def float2CGFloat(v: Double) = { new CGFloat(v); }
}
