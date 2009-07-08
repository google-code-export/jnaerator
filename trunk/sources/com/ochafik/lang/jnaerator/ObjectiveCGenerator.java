package com.ochafik.lang.jnaerator;

import java.io.IOException;
import java.io.InputStream;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import org.rococoa.cocoa.foundation.NSClass;
import org.rococoa.cocoa.foundation.NSObject;
import org.rococoa.cocoa.foundation.NSString;
import org.rococoa.Rococoa;

import static com.ochafik.lang.jnaerator.parser.ElementsHelper.*;

import com.ochafik.io.ReadText;
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
import com.ochafik.lang.jnaerator.parser.Expression.AssignmentOp;
import com.ochafik.lang.jnaerator.parser.Expression.AssignmentOperator;
import com.ochafik.lang.jnaerator.parser.Expression.BinaryOperator;
import com.ochafik.lang.jnaerator.parser.Expression.Constant;
import com.ochafik.lang.jnaerator.parser.Expression.MemberRefStyle;
import com.ochafik.lang.jnaerator.parser.Statement.Block;
import com.ochafik.lang.jnaerator.parser.StoredDeclarations.TypeDef;
import com.ochafik.lang.jnaerator.parser.Struct.Type;
import com.ochafik.lang.jnaerator.parser.TypeRef.FunctionSignature;
import com.ochafik.lang.jnaerator.parser.TypeRef.TaggedTypeRef;
import com.ochafik.util.CompoundCollection;

/*
include com/ochafik/lang/jnaerator/ObjectiveCStaticForwardsExcludeList.data
 */
public class ObjectiveCGenerator {
	String 
		classClassName = "_class_", 
		classInterfaceNameInCategoriesAndProtocols = "_static_", 
		classInstanceName = "_CLASS_", 
		classInstanceGetterName = "_getCLASS_";
	boolean AUTO_RELEASE_IN_FACTORIES = false;

	static Map<String, Set<String>> methodsExcludedFromStaticForwarding;
	public static boolean isMethodExcludedFromStaticForwarding(Function m) {
		if (methodsExcludedFromStaticForwarding == null) {
			methodsExcludedFromStaticForwarding = new HashMap<String, Set<String>>();
			try {
				InputStream in = ObjectiveCGenerator.class.getClassLoader().getResourceAsStream("com/ochafik/lang/jnaerator/ObjectiveCStaticForwardsExcludeList.data");
//				InputStream in = new FileInputStream("/Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/ObjectiveCStaticForwardsExcludeList.data");
				List<String> lines = ReadText.readLines(in);
				for (String line : lines) {
					line = line.trim();
					if (line.startsWith("//") || line.startsWith("#"))
						continue;
					String[] tks = line.split("\\|");
					String className = tks[0].trim(), methodSignature = tks[1].trim();
					Set<String> set = methodsExcludedFromStaticForwarding.get(className);
					if (set == null)
						methodsExcludedFromStaticForwarding.put(className, set = new HashSet<String>());
					set.add(methodSignature);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		if (!(m.getParentElement() instanceof Struct))
			return false;
		
		Struct s = (Struct)m.getParentElement();
		Identifier n = s.getTag();
		if (n != null && n.equals("NSObject") || n.equals("NSClass"))
			return true;
		
		String sig = m.computeSignature(false);
		if (DeclarationsConverter.getMethodsAndTheirSignatures(NSObject.class).getSecond().contains(sig))
			return true;
		
		String cn = s.getTag() == null ? "" : s.getTag().toString();
		Set<String> set = methodsExcludedFromStaticForwarding.get(cn);
		return set != null && set.contains(sig);
	}
	public ObjectiveCGenerator(Result result) {
		this.result = result;
	}

	final Result result;

	public Struct getStruct(Identifier className, Struct.Type type) {
		return Result.getMap(result.classes, type).get(className);
	}
	public Identifier getPackageName(Struct struct) {
		if (struct == null)
			return null;
		
		String library = result.getLibrary(struct);
		Identifier javaPackage = result.getLibraryPackage(library);
		
		if (struct.getType() == Struct.Type.ObjCClass) {
			String name = String.valueOf(struct.getTag());
			if (name.equals("NSObject"))
				javaPackage = ident(NSObject.class.getPackage().getName().split("\\."));
			else if (name.equals("NSClass"))
				javaPackage = ident(NSClass.class.getPackage().getName().split("\\."));
			else if (name.equals("NSString"))
				javaPackage = ident(NSString.class.getPackage().getName().split("\\."));
		}
		
		if (struct.getType() == Type.ObjCProtocol)
			javaPackage = ident(javaPackage, "protocols");
		else if (struct.getCategoryName() != null)
			javaPackage = ident(javaPackage, "categories");
		return javaPackage;
	}
	public Identifier getFullClassName(Struct struct) {
		if (struct == null)
			return null;
		Identifier javaPackage = getPackageName(struct);
		return ident(javaPackage, struct.getCategoryName() == null ? struct.getTag().clone() : ident(struct.getCategoryName()));
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
		Identifier fullClassName = getFullClassName(in);
		
		PrintWriter out = result.classOutputter.getClassSourceWriter(fullClassName.toString());
		result.printJavaHeader(getPackageName(in), out);
		
		Signatures signatures = new Signatures();

		Struct s = generateObjectiveCClass(in, signatures);
		result.notifyBeforeWritingClass(fullClassName, s, signatures);
		
		out.println(s);
		out.close();
	}
	static Identifier 
		NSObjectIdent = ident(NSObject.class), 
		NSClassIdent = ident(NSClass.class);
	public Struct generateObjectiveCClass(Struct in, Signatures signatures) throws IOException {
		boolean isProtocol = in.getType() == Type.ObjCProtocol, isCategory = in.getCategoryName() != null;
		
		Struct instanceStruct = new Struct().addModifiers(Modifier.Public);
		
		instanceStruct.setCommentBefore(in.getCommentBefore());
		instanceStruct.addToCommentBefore(in.getCommentAfter());
		instanceStruct.setTag(isCategory ? ident(in.getCategoryName()) : in.getTag().clone());
		if (isProtocol || isCategory)
			instanceStruct.setType(Type.JavaInterface);
		else
			instanceStruct.addModifiers(Modifier.Abstract).setType(Type.JavaClass);
		
		Struct classStruct = new Struct();
		classStruct.setTag(ident(classClassName));
		classStruct.setType(Struct.Type.JavaClass);
		classStruct.addModifiers(Modifier.Public, Modifier.Abstract);
		
		List<Identifier> 
			interfacesForInstance = new ArrayList<Identifier>(), 
			interfacesForClass = new ArrayList<Identifier>();

		List<Identifier> 
			parentsForInstance = new ArrayList<Identifier>(in.getParents()),
			parentsForClass = new ArrayList<Identifier>();

		if (parentsForInstance.isEmpty() && !(isProtocol || isCategory) && !in.getTag().equals(NSObjectIdent))
			parentsForInstance.add(NSObjectIdent);
		
		parentsForClass.add(NSClassIdent);
		
		if (!isCategory)
			for (Struct catIn : Result.getMap(result.objCCategoriesByTargetType, in.getTag()).values()) {
				Identifier catId = getFullClassName(catIn);
				interfacesForInstance.add(catId);
				interfacesForClass.add(ident(catId, classInterfaceNameInCategoriesAndProtocols));
				outputObjectiveCClass(catIn);
			}	
				
		for (Identifier p : parentsForInstance) {
			Identifier id = result.typeConverter.findObjCClassIdent(p);
			if (id != null)
				instanceStruct.addParent(id.clone());
		}
		for (Identifier p : parentsForClass) {
			Identifier id = p == NSClassIdent ? p : result.typeConverter.findObjCClassIdent(p);
			if (id != null)
				classStruct.addParent(id.clone());
		}
		for (Identifier id : interfacesForClass) {
			classStruct.addProtocol(id);
		}
		
		for (Identifier p : in.getProtocols()) {
			Identifier id = getFullClassName(getStruct(p, Type.ObjCProtocol));
			if (id != null)
				interfacesForInstance.add(id);
		}
		for (Identifier id : interfacesForInstance) {
			if (isProtocol || isCategory)
				instanceStruct.addParent(id);
			else
				instanceStruct.addProtocol(id);
		}
		
//		CompoundCollection<Declaration> declarations = new CompoundCollection<Declaration>();
//		declarations.addComponent(in.getDeclarations());
//		for (Struct catIn : Result.getMap(result.objCCategoriesByTargetType, in.getTag()).values()) {
//			for (Declaration d : catIn.getDeclarations())
//				d.addToCommentBefore("From category " + catIn.getCategoryName());
//			declarations.addComponent(catIn.getDeclarations());
//			
//			if (catIn.getCommentBefore() != null)
//				instanceStruct.addToCommentBefore("<p>Category " + catIn.getTag()+ " : " + catIn.getCommentBefore() +"</p>");
//		}
		
		
		StoredDeclarations classHolder = new VariablesDeclaration();
		if (!(isProtocol || isCategory))
			classHolder.addModifiers(Modifier.Private, Modifier.Static);
		
		classHolder.setValueType(typeRef(classClassName));
		
		Expression.FunctionCall call = methodCall(expr(typeRef(Rococoa.class)), MemberRefStyle.Dot, "createClass");
		call.addArgument(expr(Constant.Type.String, in.getTag().toString()));
		call.addArgument(memberRef(expr(typeRef(classClassName)), MemberRefStyle.Dot, "class"));
		
		Function classGetter;
		if (isProtocol || isCategory) {
			classGetter = null;
			classHolder.addDeclarator(new Declarator.DirectDeclarator(classInstanceName, call));
		} else {
			classHolder.addDeclarator(new Declarator.DirectDeclarator(classInstanceName));
			
			classGetter = new Function(Function.Type.JavaMethod, ident(classInstanceGetterName), typeRef(classClassName));
			classGetter.addModifiers(Modifier.Private, Modifier.Static);
			classGetter.setBody(new Block(
				new Statement.If(
					expr(
						varRef(classInstanceName), 
						BinaryOperator.IsEqual, 
						new Constant(Constant.Type.Null, null)
					),
					new Statement.ExpressionStatement(
						new AssignmentOp(
							varRef(classInstanceName), 
							AssignmentOperator.Equal, 
							call
						)
					),
					null
				),
				new Statement.Return(varRef(classInstanceName))
			));
		}
		
		Struct classInterfaceStruct = null, structThatReceivesStaticMethods;
		if (isProtocol || isCategory) {
			structThatReceivesStaticMethods = classInterfaceStruct = new Struct();
			classInterfaceStruct.setType(Struct.Type.JavaInterface);
			classInterfaceStruct.setTag(ident(classInterfaceNameInCategoriesAndProtocols));
			classStruct.addProtocol(ident(classInterfaceNameInCategoriesAndProtocols));
		} else
			structThatReceivesStaticMethods = classStruct;
		
		if (!(isProtocol || isCategory))
			addAllocIfMissing(in);
		
		outputMembers(signatures, in, instanceStruct, structThatReceivesStaticMethods, in.getDeclarations(), isProtocol || isCategory);
		
		instanceStruct.addDeclaration(decl(classInterfaceStruct));
		if (!isCategory) {// && !structThatReceivesStaticMethods.getDeclarations().isEmpty()) {
			instanceStruct.addDeclaration(new TaggedTypeRefDeclaration(classStruct));
			instanceStruct.addDeclaration(classGetter);
			instanceStruct.addDeclaration(classHolder);
		}	
		return instanceStruct;
	}

	private void addAllocIfMissing(Struct in) {
		Identifier n = in.getTag();
		if (n.equals("NSObject") || n.equals("NSClass"))
			return;
		
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
	
	private void outputMembers(Signatures signatures, Struct in, Struct instanceStruct,
			Struct classStruct, List<Declaration> declarations, boolean isProtocol) throws IOException {
		
		Identifier fullClassName = getFullClassName(in);
		
		Set<String> objSigs = DeclarationsConverter.getMethodsAndTheirSignatures(NSObject.class).getSecond(),
			clasSigs = DeclarationsConverter.getMethodsAndTheirSignatures(NSClass.class).getSecond();
		
		int[] iChild = new int[1];
		for (Declaration d : declarations) {
			if (d instanceof Function) {
				Function f = (Function)d;
				List<Declaration> decls = new ArrayList<Declaration>();
				result.declarationsConverter.convertFunction(f, signatures, false, new DeclarationsHolder.ListWrapper(decls), fullClassName);
				
				if (f.getModifiers().contains(Modifier.Static)) {
					for (Declaration decl : decls) {
						if (!add(classStruct, decl, signatures, objSigs, clasSigs))
							continue;
						
						if (!isProtocol && decl instanceof Function)
							instanceStruct.addDeclaration(createProxyCopy(f, (Function)decl));

						if (classStruct.getType() == Type.JavaClass)
							decl.addModifiers(Modifier.Public, Modifier.Abstract);
					}
				} else {
					for (Declaration decl : decls) {
						if (!add(instanceStruct, decl, signatures, objSigs))
							continue;
						
						if (!isProtocol && decl instanceof Function) {
							instanceStruct.addDeclaration(createCreateCopyFromInit((Function)decl, instanceStruct));
							if (instanceStruct.getType() == Type.JavaClass)
								decl.addModifiers(Modifier.Public, Modifier.Abstract);
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
	
	private boolean add(Struct classStruct, Declaration decl, Signatures signatures, Set<?>... additionalMethodSignatures) {
		if (decl instanceof Function) {
			String sig = ((Function)decl).computeSignature(false);
			for (Set<?> sigs : additionalMethodSignatures)
				if (sigs.contains(sig))
					return false;
			return signatures.methodsSignatures.add(sig);
		}
		classStruct.addDeclaration(decl);
		return true;
	}
	/**
	 * Create a createXXXWithYYY factory
	 * @param meth
	 * @param instanceStruct 
	 * @return
	 */
	private Declaration createCreateCopyFromInit(Function meth, TaggedTypeRef instanceStruct) {
		String name = meth.getName().toString();
		if (!name.matches("^init([A-Z].*|)$"))
			return null;
		//if (name.startsWith("init") && (name.equals("init") || !Character.isUpperCase(name.charAt("init".length())))) 
			
		Function createCopy = meth.clone();
		createCopy.setCommentBefore("Factory method");
		createCopy.addToCommentBefore("@see #" + meth.computeSignature(false));
		createCopy.setName(ident("create" + name.substring("init".length())));
		createCopy.addModifiers(Modifier.Public, Modifier.Static);
		createCopy.reorganizeModifiers();
		
		Expression[] args = new Expression[meth.getArgs().size()];
		int i = 0;
		for (Arg arg : meth.getArgs())
			args[i++] = varRef(arg.getName());
		
		Expression val = methodCall(
			methodCall(
				methodCall(null, null, classInstanceGetterName), 
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
		return createCopy;
	}
	private Function createProxyCopy(Function originalMethod, Function meth) {
		if (isMethodExcludedFromStaticForwarding(originalMethod))
			return null;
		
		Function proxyCopy = meth.clone();
		proxyCopy.addModifiers(Modifier.Public, Modifier.Static);
		proxyCopy.reorganizeModifiers();
		
		Expression[] args = new Expression[meth.getArgs().size()];
		int i = 0;
		for (Arg arg : meth.getArgs())
			args[i++] = varRef(arg.getName());
		
		Expression val = methodCall(methodCall(null, null, classInstanceGetterName), Expression.MemberRefStyle.Dot, meth.getName().toString(), args);
		proxyCopy.setBody(new Block(
			meth.getValueType() == null || "void".equals(meth.getValueType().toString()) ? stat(val) : new Statement.Return(val)
		));
		return proxyCopy;
	}
	
//	protected static _class_ _CLASS_ = org.rococoa.Rococoa.createClass("NSURL", _class_.class);
//	public abstract class _class_ extends 
//		org.rococoa.NSClass {
//		//org.rococoa.NSObject._class_ {
//	}
	
}
