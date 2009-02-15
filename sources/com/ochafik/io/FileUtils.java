/*
	Copyright (c) 2009 Olivier Chafik, All Rights Reserved
	
	This file is part of JNAerator (http://jnaerator.googlecode.com/).
	
	JNAerator is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.
	
	JNAerator is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.
	
	You should have received a copy of the GNU General Public License
	along with JNAerator.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.ochafik.io;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import com.ochafik.util.progress.ProgressModel;

public class FileUtils {
	public static Collection<File> getFilesCollection(File files[], FileFilter ff, boolean recursive) {
		Collection<File> col=new ArrayList<File>();
		for (int i=0,len=files.length;i<len;i++) {
			File fi=files[i];
			if (fi.isDirectory()) {
				if (recursive) {
					Collection<File> c=new HashSet<File>(getFilesCollection(fi.listFiles(),ff,true));
					if (c!=null) col.addAll(c);
				} else {
					File ffs[]=fi.listFiles();
					for (int j=0,len2=ffs.length;j<len2;j++) {
						File ffj=ffs[j];
						if (!ffj.isDirectory()&&!(ff!=null&&!ff.accept(ffj))) col.add(ffj);
					}
				}
			} else if (!(ff!=null&&!ff.accept(fi))) {
				col.add(fi);
				//System.out.print("#");
			}
		}
		return col;
	}
	public static final File getUniqueFile(String name,File rep) {
		return getNonExistingFile(name,rep);
	}
	public static final File getNonExistingFile(String name,File rep) {
		File tmp;
		if (name==null||name.equals("")) name=" ";
		else {
			tmp=new File(rep,name);
			if (!tmp.exists()) return tmp;
		}
		int i=1,k=name.lastIndexOf(".");
		if (k<0) {
			do {
				tmp=new File(rep,name+String.valueOf(i++));
			} while (tmp.exists());
			return tmp;
		} else {
			String deb=name.substring(0,k),fin=name.substring(k);
			do {
				tmp=new File(rep,deb+String.valueOf(i++)+fin);
			} while (tmp.exists());
			return tmp;
		}
	}
	public static final File getNextAlphabetSameTypeFile(File f) {
		File rep=f.getParentFile();
		
		final String n=f.getName();
		int k=n.lastIndexOf(".");
		String[] sn;
		if (k<0)
			sn=rep.list(new FilenameFilter() {
				public boolean accept(File fi,String na) {
					return true;
				}
			});
		else {
			final String ext=n.substring(k);
			sn=rep.list(new FilenameFilter() {
				public boolean accept(File fi,String na) {
					return na.endsWith(ext);
				}
			});
		}
		String min=null;
		for (int i=0;i<sn.length;i++) {
			String a=sn[i];
			if (n.compareTo(a)<0) {
				if (min==null||min.compareTo(a)>0) min=a;
			}
		}
		return new File(rep,min);
	}
	public void moveFile(File src,File dest,ProgressModel pv) throws IOException {
		try {
			//BufferedInputStream in=new BufferedInputStream(new ProgressModel(new FileInputStream(src),pv));
			InputStream in = new FileInputStream(src);
			pv.setTitle("Déplacement de fichier");
			pv.setComment(src.toString()+" -> "+dest.toString());
			File papa=dest.getParentFile();
			if (!papa.exists()) papa.mkdirs();
			BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(dest));
			byte b[]=new byte[2048];
			int l;
			while ((l=in.read(b))>0) out.write(b,0,l);
			out.close();
			in.close();
			src.delete();
		} catch (IOException ex) {
			throw new IOException("Incapable de déplacer "+src.toString()+" vers "+dest.toString()+"\nCause :"+ex.toString());
		}
	 }
	 public static void copyFile(File src,File dest,ProgressModel pv) throws IOException {
		try {
			//BufferedInputStream in=new BufferedInputStream(new ProgressModelInputStream(new FileInputStream(src),pv));
			InputStream in = new FileInputStream(src);
			//pv.setTitle("Copie de fichier");
			//pv.setComment(src.toString()+" -> "+dest.toString());
			File papa=dest.getParentFile();
			if (papa!=null&&!papa.exists()) papa.mkdirs();
			BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(dest));
			byte b[]=new byte[2048];
			int l;
			while ((l=in.read(b))>0) out.write(b,0,l);
			out.close();
			in.close();
		} catch (IOException ex) {
			throw new IOException("Incapable de copier "+src.toString()+" vers "+dest.toString()+"\nCause :"+ex.toString());
		}
	 }
	 /**
	 v Vector de File  : contient tous les fichiers enfants de ceux de départ : les répertoires sont fouillés récursivement, les fichiers sont ajoutés.
	 stringDest : Vector de String : contiendra les noms de fichier relatifs, s'il est non nul.
	 */
	public static final Vector<File> getFilesAndRelativeNames(Vector<File> v,String ext[],Vector<String> stringsDest) {
		Vector<File> ret=new Vector<File>();
		
		for (File f : v) {
			if (f.isDirectory()) {
				if (stringsDest==null) ret.addAll(getFilesAndRelativeNames(f,ext,null));
				else {
					Vector<String> rel=new Vector<String>();
					Vector<File> r=getFilesAndRelativeNames(f,ext,rel);
					String prefix=f.getName()+File.separator;
					int rs=rel.size();
					for (int j=0;j<rs;j++) {
						stringsDest.addElement(prefix+((String)rel.elementAt(j)));
						ret.addElement(r.elementAt(j));
					}
				}
			} else  {
				if (ext==null) {
					ret.addElement(f);
					if (stringsDest!=null) stringsDest.addElement(f.getName());
				} else {
					ret.addElement(f);
					if (stringsDest!=null) stringsDest.addElement(f.getName());
				}
			}
		}
		return ret;
	}
	public static final Vector<File> getFilesAndRelativeNames(File fi,String ext[],Vector<String> stringsDest) {
		File fs[]=fi.listFiles();
		Vector<File> ret=new Vector<File>();
		for (int i=fs.length-1;i!=-1;i--) {
			File f=fs[i];
			if (f.isDirectory())  {
				if (stringsDest==null) ret.addAll(getFilesAndRelativeNames(f,ext,null));
				else {
					Vector<String> rel=new Vector<String>();
					Vector<File> r=getFilesAndRelativeNames(f,ext,rel);
					String prefix=f.getName()+File.separator;
					int rs=rel.size();
					for (int j=0;j<rs;j++) {
						stringsDest.addElement(prefix+((String)rel.elementAt(j)));
						ret.addElement(r.elementAt(j));
					}
				}
			} else {
				if (ext==null) {
					ret.addElement(f);
					if (stringsDest!=null) stringsDest.addElement(f.getName());
				} else {
					String name=f.getName();//,nameLow=name.toLowerCase();
					for (int j=ext.length-1;j!=-1;j--) {
						if (name.endsWith(ext[j])) {
							ret.addElement(f);
							if (stringsDest!=null) stringsDest.addElement(f.getName());
							break;
						}
					}
				}
			}
		}
		return ret;
	}
	public static final long totalFilesLength(Collection v) throws IOException {
		long l=0;
		for (Iterator it=v.iterator();it.hasNext();) //int i=v.size()-1;i!=-1;i--) 
			l+=((File)it.next()).length();
		return l;
	}
	static final String currentDirPrefix="."+File.separator;
	/**
	Renvoie les associations 'fichier de départ'=>'fichier changé de hiérarchie'
	*/
	public static final HashMap<File,File> relativiseFileStringsThenMapFilesToNewFiles(
			Collection sourceFileStrings,
			File sourceBase,
			File sourceDest) {
		
		HashMap<File,File> ret=new HashMap<File,File>();
		String absSrcBase=sourceBase.getAbsolutePath();
			//absDestBase=destBase.getAbsolutePath();
		int asbl=absSrcBase.length();
		if (absSrcBase.endsWith(".")) absSrcBase=absSrcBase.substring(0,--asbl);			

		for (Iterator it=sourceFileStrings.iterator();it.hasNext();) {
			String st=it.next().toString();
			String absSrcFile=(new File(st)).getAbsolutePath();
			if (absSrcFile.startsWith(absSrcBase)) {
				String cut=absSrcFile.substring(asbl);
				if (cut.startsWith(currentDirPrefix)) cut=cut.substring(2);
				ret.put(new File(st),new File(sourceDest,cut));
			} else throw new IllegalArgumentException("file \""+absSrcFile+"\" is not based upon \""+absSrcBase+"\" !!!");
		}
		return ret;
	}
	/**
	Renvoie les associations 'fichier de départ'=>'fichier relatif'
	*/
	public static final HashMap<File,String> mapFilesToRelativeFilePaths(
			Collection sourceFiles,
			File sourceBase) {
		
		HashMap<File,String> ret=new HashMap<File,String>();
		String absSrcBase=sourceBase.getAbsolutePath();
			//absDestBase=destBase.getAbsolutePath();
		int asbl=absSrcBase.length();
		if (absSrcBase.endsWith(".")) absSrcBase=absSrcBase.substring(0,--asbl);			
		if (!absSrcBase.endsWith(File.separator)) {
			absSrcBase+=File.separator;
			asbl++;
		}
		
		for (Iterator it=sourceFiles.iterator();it.hasNext();) {
			File stFile=(File)it.next();
			String absSrcFile=(stFile).getAbsolutePath();
			if (absSrcFile.startsWith(absSrcBase)) {
				String cut=absSrcFile.substring(asbl);
				ret.put(stFile,cut);
			} else throw new IllegalArgumentException("file \""+absSrcFile+"\" is not based upon \""+absSrcBase+"\" !!!");
		}
		return ret;
	}
	/**
	Renvoie les associations 'fichier relatif'=>'fichier de départ'
	*/
	public static final Map mapRelativeFilePathsToFiles(
			Collection sourceFiles,
			File sourceBase,
			Map<String,File> ret) {
			
		if (ret==null) ret=new HashMap<String,File>();
		String absSrcBase=sourceBase.getAbsolutePath();
			//absDestBase=destBase.getAbsolutePath();
		int asbl=absSrcBase.length();
		if (absSrcBase.endsWith(".")) absSrcBase=absSrcBase.substring(0,--asbl);			
		if (!absSrcBase.endsWith(File.separator)) {
			absSrcBase+=File.separator;
			asbl++;
		}
		
		for (Iterator it=sourceFiles.iterator();it.hasNext();) {
			File stFile=(File)it.next();
			String absSrcFile=(stFile).getAbsolutePath();
			if (absSrcFile.startsWith(absSrcBase)) {
				String cut=absSrcFile.substring(asbl);
				ret.put(cut,stFile);
			} else throw new IllegalArgumentException("file \""+absSrcFile+"\" is not based upon \""+absSrcBase+"\" !!!");
		}
		return ret;
	}
	public static final Collection relativizeThenAnchor(
			Collection sourceFiles,
			File sourceBase,
			File destBase) {
		
		Vector<File> ret=new Vector<File>();
		String absSrcBase=sourceBase.getAbsolutePath();
			//absDestBase=destBase.getAbsolutePath();
		int asbl=absSrcBase.length();
		if (absSrcBase.endsWith(".")) absSrcBase=absSrcBase.substring(0,--asbl);			
		if (!absSrcBase.endsWith(File.separator)) {
			absSrcBase+=File.separator;
			asbl++;
		}
		for (Iterator it=sourceFiles.iterator();it.hasNext();) {
			File stFile=(File)it.next();
			//System.out.println(stFile);
			String absSrcFile=(stFile).getAbsolutePath();
			if (absSrcFile.startsWith(absSrcBase)) {
				String cut=absSrcFile.substring(asbl);
				if (cut.startsWith(File.separator)) {
					System.out.println(absSrcBase+" et "+cut);
					cut=cut.substring(1);
				}
				ret.add(destBase==null ? new File(cut) : new File(destBase,cut));
			} else throw new IllegalArgumentException("file \""+absSrcFile+"\" is not based upon \""+absSrcBase+"\" !!!");
		}
		return ret;
	}
	public static final void copyFiles(Vector<File> ifilesV,File repDest,String[] exts,ProgressModel pv) throws IOException {
		Vector<String> relV=new Vector<String>();
		Vector<File> filesV=getFilesAndRelativeNames(ifilesV,exts,relV);
		long length=totalFilesLength(filesV);
		pv.setMaximum(length-1);
		int nfiles=filesV.size();
		pv.setTitle("Copie de fichiers");			
		
		byte b[]=new byte[4096];
		int l;
		for (Iterator fit=filesV.iterator(),rit=relV.iterator();fit.hasNext();) {//int i=0;i<nfiles;i++) {
			File src=(File)fit.next();//filesV.elementAt(i);
			File dest=new File(repDest,(String)rit.next());//(String)relV.elementAt(i));
			//BufferedInputStream in=new BufferedInputStream(new ProgressModelInputStream(new FileInputStream(src),pv));
			InputStream in = new FileInputStream(src);
			pv.setComment(src.toString()+" -> "+dest.toString());
			File papa=dest.getParentFile();
			if (!papa.exists()) papa.mkdirs();
			BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(dest));
			while ((l=in.read(b))>0) out.write(b,0,l);
			out.close();
			in.close();
		}
		pv.setComment(nfiles+(nfiles>1 ? " fichiers, total=" : " fichier, total=")+length);
	 }
	
}