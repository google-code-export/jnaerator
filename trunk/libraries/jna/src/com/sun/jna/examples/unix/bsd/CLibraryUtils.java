package com.sun.jna.examples.unix.bsd;

import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;

public class CLibraryUtils {
	static Pointer pErrno;
	static {
		try {
			//pErrno = NativeLibrary.getInstance("libxc.dylib").getFunction("errno");
			pErrno = NativeLibrary.getInstance("c").getFunction("errno");
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	//System.out.println("errno=" + pErrno.getInt(0));

	public static int getErrno() throws NoSuchMethodException {
		if (pErrno == null) throw new NoSuchMethodException("couldn't bind errno !");
		return pErrno.getInt(0);
	}
}
