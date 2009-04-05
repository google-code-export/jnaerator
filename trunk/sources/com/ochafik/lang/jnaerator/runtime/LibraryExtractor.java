package com.ochafik.lang.jnaerator.runtime;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import com.ochafik.net.URLUtils;
import com.sun.jna.Platform;

public class LibraryExtractor {
	
	public static void loadLibrary(String libraryName) {
		try {
			ClassLoader cl = LibraryExtractor.class.getClassLoader();
			String prefix = (Platform.isWindows() || Platform.isWindowsCE() ? libraryName : "lib" + libraryName).toLowerCase() + ".";
			URL sourceURL = null;
			for (URL url : URLUtils.listFiles(cl.getResource("libraries"), null)) {
				String fileName = new File(url.toString()).getName();
				if (fileName.toLowerCase().startsWith(prefix))
					sourceURL = url;
			}
			if (sourceURL == null)
				System.loadLibrary(libraryName);
			else {
				File localFile;
				if ("file".equals(sourceURL.getProtocol()))
					localFile = new File(sourceURL.getFile());
				else {
					localFile = File.createTempFile(libraryName, null);
					localFile.deleteOnExit();
			        //Runtime.getRuntime().addShutdownHook(new DeleteNativeLibrary(lib));
					InputStream in = sourceURL.openStream();
					OutputStream out = new FileOutputStream(localFile);
					int len;
					byte[] b = new byte[1024];
					while ((len = in.read(b)) > 0)
						out.write(b, 0, len);
					out.close();
					in.close();
				}
				System.load(localFile.getAbsolutePath());
	        }
		} catch (Exception ex) {
			System.err.println("ERROR: Failed to extract library " + libraryName);
			ex.printStackTrace();
		}
	}
}
