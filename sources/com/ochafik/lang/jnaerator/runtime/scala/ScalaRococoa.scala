
class ScalaRococoa {
	import org.rococoa._;
	import org.rococoa.cocoa._;
	
	implicit def Float2CGFloat(v: Float) = { new CGFloat(v) }
	implicit def Double2CGFloat(v: Double) = { new CGFloat(v) }
	

	implicit def CGFloat2Float(v: CGFloat) = { v.floatValue() }
	implicit def CGFloat2Double(v: CGFloat) = { v.doubleValue() }
}
