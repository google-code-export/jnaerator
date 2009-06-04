package com.ochafik.lang.jnaerator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.rococoa.NSClass;
import org.rococoa.Rococoa;

import static com.ochafik.lang.SyntaxUtils.as;
import static com.ochafik.lang.jnaerator.parser.ElementsHelper.*;

import com.ochafik.lang.jnaerator.parser.Arg;
import com.ochafik.lang.jnaerator.parser.Declaration;
import com.ochafik.lang.jnaerator.parser.DeclarationsHolder;
import com.ochafik.lang.jnaerator.parser.Declarator;
import com.ochafik.lang.jnaerator.parser.Enum;
import com.ochafik.lang.jnaerator.parser.Expression;
import com.ochafik.lang.jnaerator.parser.Function;
import com.ochafik.lang.jnaerator.parser.Identifier;
import com.ochafik.lang.jnaerator.parser.Modifier;
import com.ochafik.lang.jnaerator.parser.Statement;
import com.ochafik.lang.jnaerator.parser.StoredDeclarations;
import com.ochafik.lang.jnaerator.parser.Struct;
import com.ochafik.lang.jnaerator.parser.TaggedTypeRefDeclaration;
import com.ochafik.lang.jnaerator.parser.TypeRef;
import com.ochafik.lang.jnaerator.parser.VariablesDeclaration;
import com.ochafik.lang.jnaerator.parser.Expression.Constant;
import com.ochafik.lang.jnaerator.parser.Expression.MemberRefStyle;
import com.ochafik.lang.jnaerator.parser.Identifier.SimpleIdentifier;
import com.ochafik.lang.jnaerator.parser.Statement.Block;
import com.ochafik.lang.jnaerator.parser.StoredDeclarations.TypeDef;
import com.ochafik.lang.jnaerator.parser.Struct.Type;
import com.ochafik.lang.jnaerator.parser.TypeRef.FunctionSignature;
import com.ochafik.lang.jnaerator.parser.TypeRef.TaggedTypeRef;
import com.ochafik.util.CompoundCollection;

public class ObjectiveCGenerator {
	String classClassName = "_class_", classInstanceName = "_CLASS_";
	boolean AUTO_RELEASE_IN_FACTORIES = false;

	public ObjectiveCGenerator(Result result) {
		this.result = result;
	}

	final Result result;

	public Struct getStruct(Identifier className, Struct.Type type) {
		return Result.getMap(result.classes, type).get(className);
	}
	public Identifier getPackageName(Struct struct) {
		String library = result.getLibrary(struct);
		String pa = result.javaPackageByLibrary.get(library);
		if (pa != null && pa.trim().length() == 0)
			pa = null;
		Identifier javaPackage = ident(pa);
		
		if (struct.getType() == Type.ObjCProtocol)
			javaPackage = ident(javaPackage, "protocols");
		
		return javaPackage;
	}
	public Identifier getFullClassName(Struct struct) {
		Identifier javaPackage = getPackageName(struct);
		return ident(javaPackage, struct.getTag());
	}
	public void generateObjectiveCClasses() throws IOException {
		for (Struct in : Result.getMap(result.classes, Type.ObjCClass).values()) {
			outputObjectiveCClass(in);
		}
		for (Struct protocol : Result.getMap(result.classes, Type.ObjCProtocol).values()) {
			outputObjectiveCClass(protocol);
		}
	}
	public void outputObjectiveCClass(Struct in) throws IOException {
		Identifier javaPackage = getPackageName(in);
		PrintWriter out = result.classOutputter.getClassSourceWriter(getFullClassName(in).toString());
		if (javaPackage != null)
			out.println("package " + javaPackage + ";");
	
		out.println(generateObjectiveCClass(in));
		out.close();
	}
	static SimpleIdentifier NSObjectIdent = ident("NSObject");
	public Struct generateObjectiveCClass(Struct in) {
		boolean isProtocol = in.getType() == Type.ObjCProtocol;
		
		Struct instanceStruct = new Struct().addModifiers(Modifier.Public);
		instanceStruct.setTag(in.getTag().clone());
		if (isProtocol)
			instanceStruct.setType(Type.JavaInterface);
		else
			instanceStruct.addModifiers(Modifier.Abstract).setType(Type.JavaClass);
		
		Struct classStruct = new Struct();
		classStruct.setTag(ident(classClassName));
		classStruct.setType(Struct.Type.JavaInterface);
		classStruct.addModifiers(Modifier.Public);
		classStruct.addParent(ident(NSClass.class));
		
		List<Identifier> parents = new ArrayList<Identifier>(in.getParents());
		if (parents.isEmpty() && !isProtocol && !in.getTag().equals(NSObjectIdent))
			parents.add(NSObjectIdent);
				
		for (Identifier p : in.getParents()) {
			Identifier id = getFullClassName(getStruct(p, isProtocol ? Type.ObjCProtocol : Type.ObjCClass));
			instanceStruct.addParent(id);
		}
		
		for (Identifier p : in.getProtocols()) {
			Identifier id = getFullClassName(getStruct(p, Type.ObjCProtocol));
			if (isProtocol)
				instanceStruct.addParent(id);
			else
				instanceStruct.addProtocol(id);
		}
		
		CompoundCollection<Declaration> declarations = new CompoundCollection<Declaration>();
		declarations.addComponent(in.getDeclarations());
		for (Struct catIn : Result.getMap(result.objCCategoriesByTargetType, in.getTag()).values()) {
			declarations.addComponent(catIn.getDeclarations());
		}
		
		
		StoredDeclarations classHolder = new VariablesDeclaration();
		if (!isProtocol)
			classHolder.addModifiers(Modifier.Private, Modifier.Static);
		classHolder.setValueType(new TypeRef.SimpleTypeRef(classClassName));
		Expression.FunctionCall call = methodCall(expr(typeRef(Rococoa.class)), MemberRefStyle.Dot, "createClass");
		call.addArgument(expr(Constant.Type.String, in.getTag().toString()));
		call.addArgument(memberRef(expr(typeRef(classClassName)), MemberRefStyle.Dot, "class"));
		classHolder.addDeclarator(new Declarator.DirectDeclarator(classInstanceName, call));
		
		if (!isProtocol)
			addAllocIfMissing(in);
		outputMembers(in, instanceStruct, classStruct, declarations);
		
		if (!classStruct.getDeclarations().isEmpty()) {
			instanceStruct.addDeclaration(classHolder);
			instanceStruct.addDeclaration(new TaggedTypeRefDeclaration(classStruct));
		}
			
		return instanceStruct;
	}

	private void addAllocIfMissing(Struct in) {
		boolean hasAlloc = false;
		for (Declaration d : in.getDeclarations()) {
			if (d instanceof Function) {
				Function f = (Function)d;
				if (f.getArgs().isEmpty() && "alloc".equals(f.getName())) {
					hasAlloc = true;
					break;
				}
			}
		}
		if (!hasAlloc)
			in.addDeclaration(new Function(Function.Type.ObjCMethod, ident("alloc"), typeRef(in.getTag())).addModifiers(Modifier.Static));
		
	}
	private void outputMembers(Struct in, Struct instanceStruct,
			Struct classStruct, CompoundCollection<Declaration> declarations) {
		
		Signatures signatures = new Signatures();
		Identifier fullClassName = getFullClassName(in);
		
		int[] iChild = new int[1];
		for (Declaration d : declarations) {
			if (d instanceof Function) {
				Function f = (Function)d;
				List<Declaration> decls = new ArrayList<Declaration>();
				result.declarationsConverter.convertFunction(f, signatures, false, new DeclarationsHolder.ListWrapper(decls), fullClassName);
				
				if (f.getModifiers().contains(Modifier.Static)) {
					for (Declaration decl : decls) {
						classStruct.addDeclaration(decl);
						
						if (decl instanceof Function) {
							Function meth = (Function)decl;
							//String name = meth.getName().toString();
//							
							Function proxyCopy = meth.clone();
							proxyCopy.addModifiers(Modifier.Public, Modifier.Static);
							Expression[] args = new Expression[meth.getArgs().size()];
							int i = 0;
							for (Arg arg : meth.getArgs())
								args[i++] = varRef(arg.getName());
							
							Expression val = methodCall(varRef(classInstanceName), Expression.MemberRefStyle.Dot, meth.getName().toString(), args);
							proxyCopy.setBody(new Block(
								meth.getValueType() == null ? stat(val) : new Statement.Return(val)
							));
							instanceStruct.addDeclaration(proxyCopy);
						}
					}
				} else {
					for (Declaration decl : decls) {
						instanceStruct.addDeclaration(decl);
						
						if (decl instanceof Function) {
							Function meth = (Function)decl;
							if (instanceStruct.getType() == Type.JavaClass)
								decl.addModifiers(Modifier.Public, Modifier.Abstract);
							
							String name = meth.getName().toString();
							if (name.matches("^init([A-Z].*|)$"))
							//if (name.startsWith("init") && (name.equals("init") || !Character.isUpperCase(name.charAt("init".length())))) 
							{
								
								// add createXXXWithYYY factories
								Function createCopy = meth.clone();
								createCopy.setCommentBefore("Factory method");
								createCopy.addToCommentBefore("@see #" + meth.computeSignature(false));
								createCopy.setName(ident("create" + name.substring("init".length())));
								createCopy.addModifiers(Modifier.Public, Modifier.Final, Modifier.Static);
								Expression[] args = new Expression[meth.getArgs().size()];
								int i = 0;
								for (Arg arg : meth.getArgs())
									args[i++] = varRef(arg.getName());
								
								Expression val = methodCall(
									methodCall(
										varRef(classInstanceName), 
										Expression.MemberRefStyle.Dot, 
										"alloc"
									), 
									Expression.MemberRefStyle.Dot, 
									meth.getName().toString(), 
									args
								);
								
								if (AUTO_RELEASE_IN_FACTORIES) {
									val = methodCall(val, MemberRefStyle.Dot, "autorelease");
									val =
										methodCall(expr(typeRef(Rococoa.class)), MemberRefStyle.Dot, "cast",
											val,
											memberRef(expr(typeRef(instanceStruct.getTag())), MemberRefStyle.Dot, "class")
										)
									;
								}
								createCopy.setBody(new Block(new Statement.Return(val)));
								instanceStruct.addDeclaration(createCopy);
								
								//methCopy = meth.clone();
							}
						}
					}
				}
//			} else if (d instanceof VariablesDeclaration) {
//				result.declarationsConverter.convertVariablesDeclaration((VariablesDeclaration)d, instanceStruct, iChild, fullClassName);
			} else if (d instanceof TaggedTypeRefDeclaration) {
				TaggedTypeRef tr = ((TaggedTypeRefDeclaration) d).getTaggedTypeRef();
				if (tr instanceof Struct) {
					result.declarationsConverter.convertStruct((Struct)tr, signatures, instanceStruct, fullClassName);
				} else if (tr instanceof Enum) {
					result.declarationsConverter.convertEnum((Enum)tr, signatures, instanceStruct, fullClassName);
				}
			} else if (d instanceof TypeDef) {
				TypeDef td = (TypeDef)d;
				TypeRef tr = td.getValueType();
				if (tr instanceof Struct) {
					result.declarationsConverter.convertStruct((Struct)tr, signatures, instanceStruct, fullClassName);
				} else if (tr instanceof FunctionSignature) {
					result.declarationsConverter.convertCallback((FunctionSignature)tr, signatures, instanceStruct, fullClassName);
				}
			}
			iChild[0]++;
		}

	}
	
}
