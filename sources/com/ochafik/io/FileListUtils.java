package com.ochafik.io;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;

public class FileListUtils {
	
	public static Collection<String> resolveShellLikeFileList(String d) {
		HashSet<String> v=new HashSet<String>();
		File f=new File(d);
		String name=f.getName();
		File par=f.getParentFile();
		if (par==null) {
			par=new File(".");
		}
		String fs[]=par.list();
		if (fs==null) return v;
		for (int i=0; i<fs.length;i++) {
			String fsi=fs[i];
			if (complies(fsi,name)) 
				v.add((new File(par,fsi)).toString());
		}
		return v;
	}
	public static boolean complies(String s, String model) {
		int len=model.length(),slen=s.length();
		if (len==0) {
			return slen==0;
		} else if (slen==0) {
			return model.equals("") || model.equals("*");
		} else {
			boolean star=true;
			char c=model.charAt(0);
			if (c=='*') {
				String smod=model.substring(1);
				for (int i=0;i<slen;i++) {
					if (complies(s.substring(i),smod)) return true;
				}
			} else if (c=='?') {
				String smod=model.substring(1);
				if (complies(s.substring(1),smod)) return true;
			} else {
				return s.charAt(0)==c && complies(s.substring(1),model.substring(1));
			}
		}
		return false;
	}
}
