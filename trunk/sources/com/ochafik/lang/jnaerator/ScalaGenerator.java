package com.ochafik.lang.jnaerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.ochafik.lang.jnaerator.Result.ClassWritingNotifiable;
import com.ochafik.lang.jnaerator.parser.Arg;
import com.ochafik.lang.jnaerator.parser.Declaration;
import com.ochafik.lang.jnaerator.parser.Element;
import com.ochafik.lang.jnaerator.parser.Function;
import com.ochafik.lang.jnaerator.parser.Identifier;
import com.ochafik.lang.jnaerator.parser.Scanner;
import com.ochafik.lang.jnaerator.parser.Struct;
import com.ochafik.lang.jnaerator.parser.TypeRef;
import com.ochafik.util.string.StringUtils;
import com.sun.jna.Callback;
import static com.ochafik.lang.jnaerator.parser.ElementsHelper.*;

public class ScalaGenerator implements ClassWritingNotifiable {

	Map<String, PrintWriter> outByLib = new HashMap<String, PrintWriter>();
	Result result;
	public ScalaGenerator(Result result) throws FileNotFoundException {
		this.result = result;
		result.classWritingNotifiables.add(this);
	}
	
	@Override
	public Struct writingClass(Identifier fullClassName, Struct interf,
			Signatures signatures) {
		
		try {
			visit(fullClassName, interf);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return interf;
	}

	PrintWriter getLibOut(String pack, String lib) throws FileNotFoundException {
		PrintWriter out = outByLib.get(lib);
		if (out == null) {
			File f = new File(result.config.scalaOut, pack.replace('.', '/').replace('\\', '/') + '/' + StringUtils.capitalize(lib) + "Support.scala");
			File p = f.getParentFile();
			if (!p.exists())
				p.mkdirs();
			
			result.feedback.setStatus("Generating " + f);
			out = new PrintWriter(f);
			outByLib.put(lib, out);
		}
		return out;
	}
	private void visit(final Identifier fullClassName, Element interf) throws FileNotFoundException {
		final Identifier pack = fullClassName.resolveAllButLastIdentifier();
		String spack, lib;
		if (pack == null) {
			spack = "";
			lib = "Lib";
		} else {
			spack = pack.toString();
			lib = pack.resolveLastSimpleIdentifier().toString();
		}
		final PrintWriter out = getLibOut(spack, lib);
		interf.accept(new Scanner() {
			Stack<Identifier> path = new Stack<Identifier>();
			{
				path.add(pack);
			}
			@Override
			public void visitStruct(Struct struct) {
				path.push(ident(path.peek(), struct.getTag()));
				super.visitStruct(struct);
				path.pop();
			}
			@Override
			public void visitJavaInterface(Struct struct) {
				super.visitJavaInterface(struct);
				
				if (struct.getParents().contains(ident(Callback.class))) {
					Function f = null;
					for (Declaration d : struct.getDeclarations()) {
						if (d instanceof Function) {
							f = (Function) d;
							break;
						}
					}
					if (f != null) {
						List<Arg> args = f.getArgs();
						List<String> argTypes = new ArrayList<String>(),
							argNames = new ArrayList<String>(),
							argDefs = new ArrayList<String>();
						String rt = getScalaType(f.getValueType());
						for (Arg a : args) {
							String vt = getScalaType(a.getValueType());
							String n = a.getName();
							argTypes.add(vt);
							argNames.add(n);
							argDefs.add(n + ": " + vt);
						}
						String cbClassName = struct.getTag().toString(), scbClassName = cbClassName + "_scala";
						String cbClassPath = path.peek().toString();
						int ac = argTypes.size();
						String fsig = (ac == 0 ? "" : ac == 1 ? argTypes.get(0)  : "(" + StringUtils.implode(argTypes, ", ") + ")") + " => " + rt;
						out.println("class " + scbClassName + "(scala_func: " + fsig + ") extends " + cbClassPath + " {");
						out.println("\tdef callback(" + StringUtils.implode(argDefs, ", ") + "): " + rt + " {");
						out.println("\t\tscala_func(" + StringUtils.implode(argNames, ", ") + ")");
						out.println("\t}");
						out.println("}");
						out.println("implicit def scala_func2" + scbClassName + "(scala_func: " + fsig + ") = {");
						out.println("\t" + scbClassName + "(scala_func)");
						out.println("}");
						
						/*
						 * 
class ScalaJNAeratorSupport {
	implicit def long2NativeLong(v: Long) = { new NativeLong(v); }
	implicit def int2NativeLong(v: Int) = { new NativeLong(v); }
}

class MyLibSupport {
	class MyCallback_scala(var fptr:(Pointer, NativeLong)=>Int) extends MyCallback {
		def callback(p: Pointer, l:com.sun.jna.NativeLong) : Int = fptr(p, l)
	}

	implicit def fun2MyCallback_scala(fun: MyCallback_scala) : MyCallback_scala = {
		return null;
	}
}
						 */
					}
				}
			}

			
		});
	}
	protected String getScalaType(TypeRef valueType) {
		String vt = valueType.toString();
		if (vt.equals("void"))
			vt = "Unit";
		return vt;
	}
	public void jnaerationCompleted() {
		for (PrintWriter out : outByLib.values())
			out.close();
	}
}
