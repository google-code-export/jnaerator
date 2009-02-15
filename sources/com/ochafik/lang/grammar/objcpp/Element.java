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
package com.ochafik.lang.grammar.objcpp;

import static org.junit.Assert.assertNull;
import static com.ochafik.util.string.StringUtils.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.WeakHashMap;

import com.ochafik.lang.reflect.GettersAndSettersHelper;
import com.ochafik.lang.reflect.GettersAndSettersHelper.GetterAndSetterInfo;
import com.ochafik.util.listenable.Pair;
import com.ochafik.util.string.StringUtils;

public abstract class Element {
	//List<Element> parentElements = new ArrayList<Element>(); 
	Element parentElement;
	String elementFile;
	int elementLine = -1;
	String commentBefore, commentAfter;
	static int nextId = 1;
	private int id = nextId++;
	
	public int getId() {
		return id;
	}
	
	protected <T> List<T> unmodifiableList(List<T> list) {
		return new SemiUnmodifiableList(list);
	}

	public static String getFileOfAscendency(Element decl) {
		Element e = decl;
		String file = null;
		while (e != null && (file = e.getElementFile()) == null) {
			e = e.getParentElement();
		}
		return file;
	}
	
	static String cleanComment(String s) {
		s = s.trim();
		if (s.startsWith("//"))
			s = s.replaceAll("^//+", "");
		else if (s.startsWith("/*")) {
			s = s.replaceAll("^/\\*++!?", "").replaceAll("\\*/$", "");
			s = s.replaceAll("\n\\s+", "\n").replaceAll("\n\\*\\s?+", "\n");
		}
		return s.trim();
	}
	public void addToCommentBefore(List<String> s) {
		String b = getCommentBefore();
		List<String> ss = new ArrayList<String>();
		if (b != null && (b = b.trim()).length() > 0)
			ss.add(b);
		for (String a : s)
			if (a != null && (a = a.trim()).length() > 0)
				ss.add(a);
		//s);
		//if (b != null && b.trim().length() > 0)
		//	ss.add(0, b);
		
		setCommentBefore(StringUtils.implode(ss, "\n"));
	}
	public static final <T extends Element> String implode(Iterable<T> elements, Object separator, CharSequence indent) {
		String sepStr = separator.toString();
		StringBuilder out = new StringBuilder();
		boolean first = true;
		for (T s : elements) {
			if (s == null)
				continue;
			
			if (first) 
				first = false;
			else 
				out.append(sepStr);
			out.append(s.toString(indent));
		}
		return out.toString();
	}
	public void addToCommentBefore(String... s) {
		addToCommentBefore(Arrays.asList(s));
	}
	public String formatComments(CharSequence indent, boolean mergeCommentsAfter, String... otherComments) {
		return formatComments(indent, commentBefore, commentAfter, mergeCommentsAfter, otherComments);
	}
	public static String formatComments(CharSequence indent, String commentBefore, String commentAfter, boolean mergeCommentsAfter, String... otherComments) {
		List<String> nakedComments = new ArrayList<String>();
		List<String> src = new ArrayList<String>();
		if (commentBefore != null)
			src.add(commentBefore);
		if (mergeCommentsAfter && commentAfter != null)
			src.add(commentAfter);
		src.addAll(Arrays.asList(otherComments));
		
		if (src.isEmpty())
			return "";
		
		for (String c : src) {
			if (c == null)
				continue;
			
			c = cleanComment(c).trim();
			//c = c.replaceAll("\n\\s*+(\\*\\s?)?", "<br/>\n" + indent + " * ");
			nakedComments.add(c);
		}
		
		//return "/**\n" + indent + " * " + StringUtils.implode(nakedComments, "\n").replaceAll("\n", "<br/>\n" + indent + " * ") + "\n" + indent + " */";
		String uniqueLine = null;
		if (nakedComments.size() == 1 && !nakedComments.get(0).contains("\n"))
			uniqueLine = nakedComments.get(0);
			
		if (uniqueLine != null && allowSingleLineDoc)
			return "/// " + uniqueLine;
			
		
		String content = beginEachCommentLineWithStar ?
			" * " + StringUtils.implode(nakedComments, "\n").replaceAll("\n", "<br/>\n" + indent + " * ") + "\n" + indent : 
			"\t" + StringUtils.implode(nakedComments, "\n").replaceAll("\n", "<br/>" + LINE_SEPARATOR + indent + "\t");
		
		return "/**" + LINE_SEPARATOR + indent + content + " */";
	}
	static final boolean allowSingleLineDoc = true, beginEachCommentLineWithStar = true;
	

	public void setCommentBefore(String text) {
		commentBefore = text;
	}
	public String getCommentBefore() {
		return commentBefore;
	}
	
	/*public String formatCommentAfter() {
		return commentAfter == null ? "" : commentAfter;
	}
	public String formatCommentBefore() {
		return commentBefore == null ? "" : commentBefore;
	}*/
	public void setCommentAfter(String commentAfter) {
		this.commentAfter = commentAfter;
	}
	public String getCommentAfter() {
		return commentAfter;
	}
	public String getElementFile() {
		return elementFile;
	}
	public void setElementFile(String elementFile) {
		this.elementFile = elementFile;
	}
	public void setElementLine(int elementLine) {
		this.elementLine = elementLine;
	}
	public int getElementLine() {
		return elementLine;
	}
	
	public Element getParentElement() {
		return parentElement;
	}
	public void setParentElement(Element parentElement) {
		if (this.parentElement != null)
			this.parentElement = null;
		
		if (parentElement == null)
			this.parentElement = null; // break here
		else
			this.parentElement = parentElement;
	}
	
	private static WeakHashMap<Class<?>, GettersAndSettersHelper> elementClassesGettersAndSetters = new WeakHashMap<Class<?>, GettersAndSettersHelper>();
	private static final GettersAndSettersHelper.FieldGetter fieldGetter = new GettersAndSettersHelper.FieldGetter() {

		public Field getField(Class<?> c, String name) throws SecurityException, NoSuchFieldException {
			return c.getField(name);
		}
		
	};
	public GettersAndSettersHelper getGettersAndSetters() {
		Class<? extends Element> type = getClass();
		GettersAndSettersHelper helper = elementClassesGettersAndSetters.get(type);
		if (helper == null)
			elementClassesGettersAndSetters.put(type, helper = new GettersAndSettersHelper(type, fieldGetter));
		
		return helper;
	}
	public static <T extends Element> List<T> deepClone(List<T> list) {
		List<T> clone = new ArrayList<T>(list.size());
		for (T e : list)
			clone.add((T)e.clone());
		
		return clone;
	}
	public Element clone() {
		String fieldName = null;
		try {
			Element clone = getClass().newInstance();
			for (Map.Entry<String, GetterAndSetterInfo> e : getGettersAndSetters().gettersAndSetters.entrySet()) {
				fieldName = e.getKey();
				if (fieldName.equals("parentElement"))
					continue;
				
				GetterAndSetterInfo p = e.getValue();
				if (p.getter == null || p.setter == null)
					continue;
				
				Object value = p.getter.invoke(this);
				Object clonedValue = cloneObject(value);
				p.setter.invoke(clone, clonedValue);
			}
			return clone;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected static Object cloneObject(Object value) throws CloneNotSupportedException {
		if (value == null)
			return null;
		
		Class<?> type = value.getClass();
		if (Element.class.isAssignableFrom(type))
			return ((Element)value).clone();
		else if (Collection.class.isAssignableFrom(type))
			return cloneElements((Collection<?>) value);
		else if (Map.class.isAssignableFrom(type))
			return cloneElements((Map<?, ?>) value);
		else if (Pair.class.isAssignableFrom(type)) {
			Pair<?, ?> pair = (Pair<?, ?>)value;
			return new Pair<Object, Object>(cloneObject(pair.getFirst()), cloneObject(pair.getSecond()));
		}
		//else if (value instanceof String || type.isPrimitive())
		return value;
		
		//throw new CloneNotSupportedException();	
	}
	public static Collection<?> cloneElements(Collection<?> col) throws CloneNotSupportedException {
		Collection<Object> colClone;
		if (col instanceof List)
			colClone = new ArrayList<Object>(col.size());
		else if (col instanceof LinkedHashSet)
			colClone = new LinkedHashSet<Object>(col.size());
		else if (col instanceof HashSet)
			colClone = new HashSet<Object>(col.size());
		else if (col instanceof TreeSet)
			colClone = new TreeSet<Object>();
		else if (col instanceof Set)
			colClone = new LinkedHashSet<Object>(col.size());
		else
			throw new CloneNotSupportedException();
		
		for (Object o : col) {
			o = cloneObject(o);
			colClone.add(o);
		}
		return colClone;
	}
	
	public static Map<?, ?> cloneElements(Map<?, ?> col) throws CloneNotSupportedException {
		Map<Object, Object> colClone;
		if (col instanceof LinkedHashMap)
			colClone = new LinkedHashMap<Object, Object>(col.size());
		else if (col instanceof HashMap)
			colClone = new HashMap<Object, Object>(col.size());
		else if (col instanceof TreeMap)
			colClone = new TreeMap<Object, Object>();
		else if (col instanceof Map)
			colClone = new LinkedHashMap<Object, Object>();
		else
			throw new CloneNotSupportedException();
		
		for (Map.Entry<?, ?> entry : col.entrySet())
			colClone.put(cloneObject(entry.getKey()), cloneObject(entry.getValue()));

		return colClone;
	}
	/*
	public void addParentElement(Element e) {
		parentElements.add(e);
	}
	public void removeParentElement(Element e) {
		parentElements.remove(e);
	}*/
	
	public abstract boolean replaceChild(Element child, Element by);
	public abstract Element getNextChild(Element child);
	public abstract Element getPreviousChild(Element child);
	
	public Element getNextSibling() {
		Element pe = getParentElement();
		if (pe != null)
			return pe.getNextChild(this);
		return null;
	}
	
	public Element getPreviousSibling() {
		Element pe = getParentElement();
		if (pe != null)
			return pe.getPreviousChild(this);
		return null;
	}

	public static <T extends Element> boolean replaceChild(List<T> list, Class<T> type, Element parent, Element child, Element by) {
		int i = list.indexOf(child);
		if (i >= 0) {
			T old;
			if (by == null)
				old = list.remove(i);
			else
				old = list.set(i, type == null ? (T)by : type.cast(by));

			if (old != by) {
				if (old != null)
					old.setParentElement(null);
				
				if (by != null)
					by.setParentElement(parent);
			}
			return true;
		}
		
		return false;
	}
	
	public static <T extends Element> Element getNextSibling(List<T> list, Element child) {
		int i = list.indexOf(child);
		if (i >= 0) {
			return i < list.size() - 1 ? list.get(i + 1) : null;
		}
		return null;
	}

	public static <T extends Element> Element getPreviousSibling(List<T> list, Element child) {
		int i = list.indexOf(child);
		if (i >= 0) {
			return i > 0 ? list.get(i - 1) : null;
		}
		return null;
	}
	public static <T extends Element> void changeValue(Element parent, List<T> oldValue, List<T> newValue) {
		for (T t : oldValue)
			t.setParentElement(null);
	
		oldValue.clear();
		
		if (newValue != null) {
			for (T t : newValue) {
				if (t != null)
					t.setParentElement(parent);
				oldValue.add(t);
			}
		}
	}
	public static <T extends Element> T changeValue(Element parent, T oldValue, T newValue) {
		if (oldValue != newValue) {
			if (oldValue != null)
				oldValue.setParentElement(null);
			
			if (newValue != null)
				newValue.setParentElement(parent);
		}
		return newValue;
	}
	
	List<GetterAndSetterInfo> elementListGettersAndSetters;

	public boolean insertSibling(Element siblingToInsert, boolean before) {
		Element parent = getParentElement();
		if (parent == null)
			return false;
		
		return parent.insertChild(this, siblingToInsert, before);
	}
	public boolean insertChild(Element existingChild, Element childToInsert, boolean before) {
		if (elementListGettersAndSetters == null) {
			elementListGettersAndSetters = new ArrayList<GetterAndSetterInfo>();
			GettersAndSettersHelper gettersAndSetters = getGettersAndSetters();
			
			for (Map.Entry<String, GetterAndSetterInfo> e : gettersAndSetters.gettersAndSetters.entrySet()) {
				GetterAndSetterInfo p = e.getValue();
				if (!p.isFull())
					continue;
				
				Type returnType = p.getter.getGenericReturnType();
				if (returnType instanceof ParameterizedType) {
					ParameterizedType paramReturnType = (ParameterizedType) returnType;
					Type rawType = paramReturnType.getRawType();
					Type[] typeArguments = paramReturnType.getActualTypeArguments();
					Type typeArgument = typeArguments.length == 1 ? typeArguments[0] : null;
					if (typeArgument != null && typeArgument instanceof Class && rawType instanceof Class) {
						Class<?> typeClass = (Class<?>) typeArgument;
						Class<?> rawClass = (Class<?>) rawType; 
						if (Element.class.isAssignableFrom(typeClass) && List.class.isAssignableFrom(rawClass)) {
							p.elementType = (Class<Element>)typeClass;
							elementListGettersAndSetters.add(p);//new ListGetterAndSetterInfo(e.getKey(), (Class<Element>)typeClass, p.getter, p.setter));
						}	
					}
				}
			}
		}
		Class<?> t = existingChild.getClass(), t2 = childToInsert.getClass();
		for (GetterAndSetterInfo info : elementListGettersAndSetters) {
			if (!info.elementType.isAssignableFrom(t) || !info.elementType.isAssignableFrom(t2))
				continue;
			
			try {
				List<Element> list = (List<Element>)info.getter.invoke(this);
				if (list instanceof SemiUnmodifiableList)
					list = ((SemiUnmodifiableList<Element>)list).getList();
				int i = list.indexOf(existingChild);
				if (i < 0)
					continue;
				
				list.add(before ? i : i + 1, childToInsert);
				childToInsert.setParentElement(this);
				return true;
			} catch (Exception e) {
				throw new RuntimeException("Implementation bug in " + Element.class + ".insertChild !", e);
			}
		}
		return false;
	}
	public boolean replaceBy(Element element) {
		Element pe = getParentElement();
		if (pe != null)
			return pe.replaceChild(this, element);
		
		return false;
	}
	
	public <T> T findParentOfType(Class<T> type) {
		Element e = this;
		for (;;) {
			if (type.isAssignableFrom(e.getClass()))
				return type.cast(e);
		
			e = e.getParentElement();
			if (e == null)
				return null;
		}
	}
	

	@Override
	public final String toString() {
		return toString("");
	}
	
	public abstract String toString(CharSequence indent);
	
	public abstract void accept(Visitor visitor);

}
