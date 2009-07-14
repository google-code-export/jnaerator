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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ochafik.net.URLUtils;
import com.sun.jna.Platform;

/**
 * @see http://landonf.bikemonkey.org/static/soylatte/
 * @author ochafik
 *
 */
public class LibraryExtractor {
	public static String getCurrentOSAndArchString() {
		String os = System.getProperty("os.name"), arch = System.getProperty("os.arch");

		if (os.equals("Mac OS X")) {
			os = "darwin";
			arch = "fat";
			//arch = Platform.is64Bit() ? "64" : "32";
		} else if (os.startsWith("Windows")) {
			return "win" + (Platform.is64Bit() ? "64" : "32");
		} else if (os.matches("SunOS|Solaris"))
			os = "solaris";
		
		return os + "-" + arch;
	}
	public static String getLibraryPath(String libraryName, boolean extractAllLibraries, Class<?> cl) {
		try {
			//ClassLoader cl = LibraryExtractor.class.getClassLoader();
			String prefix = (Platform.isWindows() || Platform.isWindowsCE() ? libraryName : "lib" + libraryName).toLowerCase() + ".";
			URL sourceURL = null;
			List<URL> otherURLs = new ArrayList<URL>();
			

			String arch = getCurrentOSAndArchString();
			//System.out.println("libURL = " + libURL);
			List<URL> list = URLUtils.listFiles(URLUtils.getResource(cl, "libraries/" + arch), null);
			if (list.isEmpty()) {
				for (URL u : URLUtils.listFiles(URLUtils.getResource(cl, "libraries"), null)) {
					String f = u.getFile();
					int i = f.lastIndexOf('/');
					if (i >= 0)
						f = f.substring(i + 1);
					if (arch.startsWith(f)) {
						list = URLUtils.listFiles(u, null);
						break;
					}
				}
				
			}
			
			for (URL url : list) {
				String fileName = new File(url.toString()).getName();
				if (fileName.toLowerCase().startsWith(prefix))
					sourceURL = url;
				else
					otherURLs.add(url);
			}
			List<File> files = new ArrayList<File>();
			if (extractAllLibraries) {
				for (URL url : otherURLs)
					files.add(extract(url));
			}
			
			if (sourceURL == null)
				return libraryName;
			else {
				File file = extract(sourceURL);
				files.add(file);
				
				int lastSize;
				do {
					lastSize = files.size();
					for (Iterator<File> it = files.iterator(); it.hasNext();) {
						try {
							System.load(it.next().toString());
							it.remove();
						} catch (Exception ex) {
							System.err.println(ex);
						}
					}
				} while (files.size() < lastSize);
				
				return file.getAbsolutePath();
	        }
		} catch (Throwable ex) {
			System.err.println("ERROR: Failed to extract library " + libraryName);
			ex.printStackTrace();
			return libraryName;
		}
	}
	private static File extract(URL url) throws IOException {
		File localFile;
		if ("file".equals(url.getProtocol()))
			localFile = new File(url.getFile());
		else {
			File f = new File(System.getProperty("user.home"));
			f = new File(f, ".jnaerator");
			f = new File(f, "extractedLibraries");
			if (!f.exists())
				f.mkdirs();
			
			localFile = new File(f, new File(url.getFile()).getName());
			URLConnection c = url.openConnection();
			if (localFile.exists() && localFile.lastModified() > c.getLastModified()) {
				c.getInputStream().close();
			} else {
				System.out.println("Extracting " + url);
				InputStream in = c.getInputStream();
				OutputStream out = new FileOutputStream(localFile);
				int len;
				byte[] b = new byte[1024];
				while ((len = in.read(b)) > 0)
					out.write(b, 0, len);
				out.close();
				in.close();
			}
		}
		return localFile;
	}
	public static void loadLibrary(String libraryName, boolean extractAllLibraries, Class<?> cl) {
		System.loadLibrary(getLibraryPath(libraryName, extractAllLibraries, cl));
	}
}
