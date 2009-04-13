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


/**
	This grammar is by no mean complete.
	It is able to parse preprocessed C & Objective-C files and can tolerate some amount of C++. 
	It lacks serious expression support, which is being worked on.
	Complex variable declarations may not be supported, such as complex signatures of functions that return function pointers...
*/

grammar ObjCpp;
options {
	backtrack = true;
	output = AST;
	// memoize=true;
	k = 3;
}

scope Symbols {
	Set<String> typeIdentifiers;
}
scope IsTypeDef {
	boolean isTypeDef;
}

@header { 
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

package com.ochafik.lang.jnaerator.parser;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;
import java.util.HashSet;
import static com.ochafik.lang.jnaerator.parser.TypeRef.*;
import static com.ochafik.lang.jnaerator.parser.Expression.*;
import static com.ochafik.lang.jnaerator.parser.Declaration.*;
import static com.ochafik.lang.jnaerator.parser.Statement.*;
import static com.ochafik.lang.jnaerator.parser.Declarator.*;
import static com.ochafik.lang.jnaerator.parser.StoredDeclarations.*;
}

@members {
	public enum Language {
		C, CPlusPlus, ObjectiveC
	}
	public EnumSet<Language> possibleLanguages = EnumSet.allOf(Language.class);
	
	String lastComment;
	String file;
	int sourceLineDelta = 0; // line(token) = token.line - lastLineToken.line + lastLine; sourceLineDelta = lastLine - lastLineToken.line
	//String pack;
	
	public Set<String> topLevelTypeIdentifiers;// = new HashSet<String>();//java.util.Arrays.asList("CHAR"));
	boolean isPrimitiveType(String identifier) {
		return com.ochafik.lang.jnaerator.TypeConversion.isObjCppPrimitive(identifier);
	}
	boolean isTypeDef() {
		if (IsTypeDef_stack.isEmpty())
			return false;
		IsTypeDef_scope scope = (IsTypeDef_scope)IsTypeDef_stack.get(IsTypeDef_stack.size() - 1);
		return scope.isTypeDef;
	}
	void defineTypeIdentifierInParentScope(String name) {
		if (name == null || Symbols_stack.isEmpty())
			return;
		int s = Symbols_stack.size();
		Symbols_scope sp = (Symbols_scope)Symbols_stack.get(s - 2 >= 0 ? s - 2 : s - 1);
		sp.typeIdentifiers.add(name);
	}
	boolean isTypeIdentifier(String identifier) {
		for (Object oscope : Symbols_stack) {
			Symbols_scope scope = (Symbols_scope)oscope;
			if (scope.typeIdentifiers.contains(identifier))
				return true;
		}
		if (isPrimitiveType(identifier)) {
			//System.err.println("Found primitive : " + identifier);
			return true;
		}
		//System.err.println("Not a primitive : " + identifier);
		return topLevelTypeIdentifiers == null ? false : topLevelTypeIdentifiers.contains(identifier);
	}
	public void setFile(String file) {
		this.file = file;
		possibleLanguages = guessPossibleLanguages(file);
	}
	
	public EnumSet<Language> guessPossibleLanguages(String file) {
		int i = file.lastIndexOf(".");
		if (i > 0) {
			String ext = file.substring(i + 1).toLowerCase();
		
			if (ext.equals("h"))
				return EnumSet.allOf(Language.class);
			else if (ext.equals("c"))
				return EnumSet.of(Language.C);
			else if (ext.startsWith("c") || ext.startsWith("h")) // cxx, hxx
				return EnumSet.of(Language.C, Language.CPlusPlus);
			else if (ext.equals("m"))
				return EnumSet.of(Language.C, Language.ObjectiveC);
			else if (ext.equals("mm"))
				return EnumSet.allOf(Language.class);
		}
		return EnumSet.allOf(Language.class);
	}
	public String getFile() { 
		return file; 
	}
	
	public int getLine() {
		return getLine(getTokenStream().get(getTokenStream().index()));
	}
	
	public int getLine(Token token) {
		return token.getLine();// + sourceLineDelta;
	}
	
	protected <T extends Element> T mark(T element, int tokenLine) {
		element.setElementFile(getFile());
		if (tokenLine >= 0)
			element.setElementLine(tokenLine + sourceLineDelta);
		return element;
	}
	protected String getCommentBefore() {
		return getCommentBefore(getTokenStream().index());
	}
	protected String getCommentBefore(int index) {
		String comment = null;
		boolean toleratedNewLine = false;
		while (index > 0) {
			Token token = getTokenStream().get(--index);
			if (token.getType() == COMMENT || token.getType() == LINE_COMMENT) {
				//if (comment != null)
				//return comment;
				if (comment != null && comment.endsWith("\n") && toleratedNewLine)
    					return null;
				if (comment != null)
					return comment;
				comment = token.getText();
	  			if (comment != null && comment.endsWith("\n") && toleratedNewLine)
    					return null;
			} else if (token.getType() == WS) {
				if (token.getText().indexOf("\n") >= 0) {
					if (comment != null)
						return comment;
					else if (toleratedNewLine)
						return null;
					else
						toleratedNewLine = true;
				}
			} else
				return null;
		}
		return comment;
	}
	protected String getCommentAfterOnSameLine() {
		return getCommentAfterOnSameLine(getTokenStream().index() - 1);
	}	
	protected String getCommentAfterOnSameLine(int index) {
		int size = getTokenStream().size();
		while (index < size) {
			Token token = getTokenStream().get(index++);
			if (token.getType() == COMMENT || token.getType() == LINE_COMMENT)
				return token.getText();
			else if (token.getText().indexOf("\n") >= 0)
				break;
		}
		return null;
	}
	protected Declaration decl(TaggedTypeRef type) {
		return mark(new TaggedTypeRefDeclaration(type), type.getElementLine());
	} 
	
	protected String next() {
		return next(1);
	}
	protected String next(int i) {
		return input.LT(i).getText();
	}
	protected boolean next(Modifier.Kind... anyModKind) {
		return Modifier.parseModifier(next(), anyModKind) != null;
	} 
	protected boolean next(String... ss) {
		String n = next();
		for (String s : ss)
			if (s.equals(n))
				return true;
				
		return false;
	}
}

@lexer::header { 
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

package com.ochafik.lang.jnaerator.parser;
import static com.ochafik.lang.jnaerator.parser.Expression.*;
}

lineDirective
	:	ln='#line' line=DECIMAL_NUMBER {
			try {
				sourceLineDelta = Integer.parseInt($line.text) - $ln.getLine() - 1;
			} catch (Exception ex) {
				System.err.println("ERROR: unparsable line in #line directive : " + $line.text);
				sourceLineDelta = 0;
			}
		}
		(
			unescapedString=STRING {
				String fileStr = $unescapedString.text.trim();
				if (fileStr.startsWith("\"")) {
					fileStr = fileStr.substring(1);
					if (fileStr.endsWith("\""))
						fileStr = fileStr.substring(0, fileStr.length() - 1);
				}				
				setFile(fileStr);
			} 
		)? 
		depth=DECIMAL_NUMBER?
	;
	
sourceFile returns [SourceFile sourceFile]
scope Symbols; 
@init {
	$Symbols::typeIdentifiers = new HashSet<String>();
}
	:	
		{ $sourceFile = new SourceFile(); }//mark(new SourceFile(), getLine()); }
		(
			declaration { 
				for (Declaration d : $declaration.declarations)
					$sourceFile.addDeclaration(d); 
			} |
			lineDirective {
				if ($sourceFile.getElementFile() == null)
					$sourceFile.setElementFile(getFile());
			}
		)* 
	 	EOF
	 ;

externDeclarations returns [ExternDeclarations declarations]
	:	{ next("extern") }? IDENTIFIER
		STRING {
			$declarations = mark(new ExternDeclarations(), getLine($STRING));
			$declarations.setLanguage($STRING.text);
		}
		'{' 
			(
				ed=declaration { 
					$declarations.addDeclarations($ed.declarations); 
				}
			)* 
		'}'
	;

declaration returns [List<Declaration> declarations, List<Modifier> modifiers, String preComment, int startTokenIndex]
scope IsTypeDef;
	:	
		{ $declarations = new ArrayList<Declaration>(); 
		  $modifiers = new ArrayList<Modifier>();
		  $startTokenIndex = getTokenStream().index();
		  $preComment = getCommentBefore($startTokenIndex);
		}
		(
			(
				//'#import' '<' 
				functionDeclaration {
					$declarations.add($functionDeclaration.function);
				} |
				externDeclarations {
					$declarations.add($externDeclarations.declarations); 
				} |
				varDecl ';' { 
					$declarations.add($varDecl.decl); 
				} |
				objCClassDef { 
					$declarations.add(decl($objCClassDef.struct)); 
				} |
				typeDef {
					$declarations.add($typeDef.typeDef); 
				} |
				forwardClassDecl {
					$declarations.addAll($forwardClassDecl.declarations); 
				} |
				'namespace' ns=IDENTIFIER '{' 
					(
						subD=declaration { 
							for (Declaration d : $subD.declarations) {
								d.addNameSpace($ns.text);
								$declarations.add(d);
							}
						}
					)*
				'}'// | 
				//';' */// allow isolated semi-colons
			)
			{
				String commentAfter = getCommentAfterOnSameLine($startTokenIndex);
				for (Declaration d  : $declarations) {
					if (d == null)
						continue;
					d.setCommentBefore($preComment);
					d.setCommentAfter(commentAfter);
					d.addModifiers($modifiers);
				}
				
			}
		)
	;
	
forwardClassDecl returns [List<Declaration> declarations]
	: 	{ $declarations = new ArrayList<Declaration>(); }
		'@class' 
		n1=IDENTIFIER { 
			$declarations.add(decl(Struct.forwardDecl($n1.text, Struct.Type.ObjCClass))); 
			defineTypeIdentifierInParentScope($n1.text);
		}
		(',' 
		nx=IDENTIFIER { 
			$declarations.add(decl(Struct.forwardDecl($nx.text, Struct.Type.ObjCClass))); 
			defineTypeIdentifierInParentScope($nx.text);
		}
		)*
		';' 
	;
	
functionPointerVarDecl  returns [List<? extends Declaration> declarations]
	:	mutableTypeRef {
			($mutableTypeRef.type instanceof FunctionSignature) && 
			((FunctionSignature)$mutableTypeRef.type).getFunction().getName() != null
		}? {
			$declarations = Arrays.asList(new FunctionPointerDeclaration(((FunctionSignature)$mutableTypeRef.type)));
		}
		';'
	;
	
enumItem returns [Enum.EnumItem item]
	:	n=IDENTIFIER ('=' v=expression)? {
			$item = mark(new Enum.EnumItem($n.text, $v.text == null ? null : $v.expr), getLine($n));
			$item.setCommentBefore(getCommentBefore($n.getTokenIndex()));
			$item.setCommentAfter(getCommentAfterOnSameLine($n.getTokenIndex() - 1));
		}
	;
	
enumBody returns [Enum e]
	:
		{ 
			$e = new Enum();
			$e.setForwardDeclaration(false); 
		}
		'{' 
			(  
				i1=enumItem { 
					if ($i1.text != null)
						$e.addItem($i1.item); 
				}
				(
					',' 
					(ix=enumItem { 
						if ($ix.text != null)
							$e.addItem($ix.item); 
					})?
				)*
			)?
		'}'
	;
enumCore returns [Enum e]
@init {
	List<Modifier> modifiers = new ArrayList<Modifier>();
}
	:
		t='enum'
		(
			m1=modifiers { modifiers.addAll($m1.modifiers); }
			(
				ab=enumBody {
					$e = $ab.e;
					$e.setForwardDeclaration(false);
				} |
				tag=IDENTIFIER 
				(
					m2=modifiers { modifiers.addAll($m2.modifiers); }
					nb=enumBody {
						$e = $nb.e;
						$e.setForwardDeclaration(false);
					} | {
						$e = new Enum();
						$e.setForwardDeclaration(true);
					}
				) {
					$e.setTag($tag.text);
				}
			)
		) {
			//$e.setCommentBefore(getCommentBefore($t.getTokenIndex()));
			$e = mark($e, getLine($t));
			$e.addModifiers(modifiers);
			defineTypeIdentifierInParentScope($e.getTag());
		}
	;
		
/*
BINARY_OPERATOR
	:	'+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' |
		'<=' | '>=' | '<' | '>' | '==' | '!='
	;
*/
		
objCClassDef returns [Struct struct]
	:	
		octype=('@protocol'|'@interface') 
		className=IDENTIFIER {
			defineTypeIdentifierInParentScope($className.text);
			$struct = mark(new Struct(), getLine($octype));
			//$struct.setCommentBefore(getCommentBefore($octype.getTokenIndex()));
			$struct.setType($octype.text.equals("@interface") ?
				Struct.Type.ObjCClass :
				Struct.Type.ObjCProtocol
			);
			$struct.setTag($className.text);
		}
		(
			(	
				':' parentClass=IDENTIFIER {
				if ($parentClass.text != null)
					$struct.addParent($parentClass.text);
				}
			)? |
			'(' categoryName=IDENTIFIER ')' {
				$struct.setCategoryName($categoryName.text);
			}
		)
		(	
			'<' (
				p1=IDENTIFIER { $struct.addProtocol($p1.text); }
				(
					',' 
					px=IDENTIFIER { $struct.addProtocol($px.text); }
				)*
			)? '>'
		)?
		(
			'{' 
			(
				'@public' { $struct.setNextMemberVisibility(Struct.MemberVisibility.Public); } | 
				'@private' { $struct.setNextMemberVisibility(Struct.MemberVisibility.Private); } | 
				'@protected' { $struct.setNextMemberVisibility(Struct.MemberVisibility.Protected); } |
				(
					(
						fv=varDecl ( ':' bits=DECIMAL_NUMBER )? ';' { 
							//if ($bit.text != null) $fv.decl.setBits(Integer.parseInt($bits.text));
							$struct.addDeclaration($fv.decl);
						} |
						functionPointerVarDecl { 
							$struct.addDeclarations($functionPointerVarDecl.declarations); 
						}
					)
				)
			)* 
			'}'
		)?
		{ $struct.setNextMemberVisibility(Struct.MemberVisibility.Public); }
		(
			objCMethodDecl { 
				$struct.addDeclaration($objCMethodDecl.function); 
			} |
			typeDef {
				$struct.addDeclaration($typeDef.typeDef); 
			} |
			vd=varDecl ';' { !($vd.decl instanceof VariablesDeclaration) }? {
				$struct.addDeclaration($vd.decl);
			}
		)*
		'@end'
	;						

objCMethodDecl returns [Function function]
	:	{ 	
			$function = new Function(); 
			$function.setType(Function.Type.ObjCMethod);
		}
		tk=(
			tp='+' { 
				$function.addModifiers(Modifier.Static); 
				$function = mark($function, getLine($tp)); 
				$function.setCommentBefore(getCommentBefore($tp.getTokenIndex()));
			} | 
			tm='-' {
				$function = mark($function, getLine($tm)); 
				$function.setCommentBefore(getCommentBefore($tm.getTokenIndex()));
			}
		)
		(
			// Optional return type
			'('
				returnTypeRef=mutableTypeRef? { 
					$function.setValueType($returnTypeRef.type); 
				}
			')'
		)?
		methodName=IDENTIFIER { 
			$function.setName($methodName.text); 
			$function.setCommentAfter(getCommentAfterOnSameLine($methodName.getTokenIndex()));
		} 
		(
			':' '(' argType1=mutableTypeRef ')' argName1=IDENTIFIER {
				Arg arg = new Arg($argName1.text, $argType1.type);
				arg.setSelector($methodName.text);
				$function.addArg(arg);
			}
			(
				sel=IDENTIFIER ':' 
				'(' argType=mutableTypeRef ')' 
				argName=IDENTIFIER {
					Arg arg = new Arg($argName.text, $argType.type);
					arg.setSelector($sel.text);
					$function.addArg(arg);
				}
			)*
			(
				',' '...' {
					$function.addArg(Arg.createVarArgs());
				}
			)?
		)?
		';'
	;

structBody returns [Struct struct]
	:
		{ 
			$struct = new Struct();
			$struct.setForwardDeclaration(false); 
		}
		'{'
			(
				(
					'public' { $struct.setNextMemberVisibility(Struct.MemberVisibility.Public); } | 
					'private' { $struct.setNextMemberVisibility(Struct.MemberVisibility.Private); } | 
					'protected' { $struct.setNextMemberVisibility(Struct.MemberVisibility.Protected); } 
				) ':' |
				declaration {
					$struct.addDeclarations($declaration.declarations);
				}
			)*
		'}'
	;

structCore returns [Struct struct]					
scope Symbols; 
@init {
	$Symbols::typeIdentifiers = new HashSet<String>();
	List<Modifier> modifiers = new ArrayList<Modifier>();
}
	:	
		typeToken=('struct' | 'class' | 'union')
		(
			m1=modifiers { modifiers.addAll($m1.modifiers); }
			(
				ab=structBody {
					$struct = $ab.struct;
					$struct.setForwardDeclaration(false);
				} |
				tag=IDENTIFIER 
				(
					(
						m2=modifiers { modifiers.addAll($m2.modifiers); }
						(
							':'
							'public'?//m3=modifiers
							parent=IDENTIFIER
						)? 
						nb=structBody {
							$struct = $nb.struct;
							$struct.setForwardDeclaration(false);
							if ($parent.text != null)
								$struct.addParent($parent.text);
						} 
					) | {
						$struct = new Struct();
						$struct.setForwardDeclaration(true);
					}
				) {
					$struct.setTag($tag.text);
				}
			)
		)  {
			//$struct.setCommentBefore(getCommentBefore($typeToken.getTokenIndex()));
			$struct = mark($struct, getLine($typeToken)); 
			$struct.setType(
				$typeToken.text.equals("struct") ?	Struct.Type.CStruct :
				$typeToken.text.equals("union") ?	Struct.Type.CUnion :
								Struct.Type.CPPClass
			);
			//$struct.setForwardDeclaration(true); // until proven wrong
			
			Function.Type forcedType = null;
			if ($struct.getType() == Struct.Type.CPPClass)
				forcedType = Function.Type.CppMethod;
			
			if (forcedType != null)
			for (Declaration d : $struct.getDeclarations()) {
				if (d instanceof Function)
					((Function)d).setType(forcedType);
			}
			defineTypeIdentifierInParentScope($struct.getTag());
		}
	;

functionName returns [String name, String file, int line]
	:
		pre='~'? n=IDENTIFIER post=(binaryOp | unaryOp | assignmentOp)? { 
			$name = $n.text;
			$file = getFile();
			$line = getLine($n);
		} 
		/*(
			{ $IDENTIFIER.text.equals("operator") }? 
			(
				op=(binaryOp | unaryOp) { $name += $op.text; } | 
				assignmentOp { $name += $assignmentOp.op.toString(); } 
				'(' ')' { $name += "()"; } |
				'[' ']' { $name += "[]"; } |
				'->' { $name += "->"; }
			) | 
		)*/
	;
	
//structInsides returns [List<Declaration> declarations, Struct.MemberVisibility
functionDeclaration returns [Function function]
scope Symbols;
@init {
	$Symbols::typeIdentifiers = new HashSet<String>();
}
	:	{ 	
			$function = mark(new Function(), -1);
			$function.setType(Function.Type.CFunction);
		}
		/*( 
			{ next("extern") }? IDENTIFIER STRING { 
				$function.addModifiers(Modifier.Extern); 
			} |
		)?*/
		preMods1=modifiers { $function.addModifiers($preMods1.modifiers); }
		returnTypeRef=mutableTypeRef? { 
			$function.setValueType($returnTypeRef.type); 
		}
		preMods2=modifiers { $function.addModifiers($preMods2.modifiers); }
		functionName {
			$function.setName($functionName.name); 
			$function.setElementFile($functionName.file);
			$function.setElementLine($functionName.line);
		}
		argList {
			$function.setArgs($argList.args);
		}
		({ next("const", "__const") }? ct=IDENTIFIER {
			if ($ct.text != null)
				$function.addModifiers(Modifier.Const);
		} |)
		postMods=modifiers {
			for (Modifier m : $postMods.modifiers)
				$function.addModifiers(m);
		}
		(	
			';' |
			statementsBlock {
				$function.setBody($statementsBlock.stat);
			}
		)
	;

modifier returns [Modifier modifier]
	:	{ Modifier.parseModifier(next()) != null }? m=IDENTIFIER {
			$modifier = Modifier.parseModifier($m.text);
		}/* |
		t=(
			'signed' | 'unsigned' | '__signed' | '__unsigned' |
			'long' | 'short'
		) {
			$modifier = Modifier.parseModifier($t.text);
		}*/
	;
	
modifiers returns [List<Modifier> modifiers]
	: 	anyModifier {
			$modifiers = $anyModifier.modifiers;
		} |
		{
			$modifiers = new ArrayList<Modifier>();
		}
	;

anyModifier returns [List<Modifier> modifiers, String asmName]
	:
		{ $modifiers = new ArrayList<Modifier>(); }
		(
			{ next("extern") }? IDENTIFIER ex=STRING {
				$modifiers.add(Modifier.Extern); // TODO
			} |
			modifier {
				$modifiers.add($modifier.modifier);
			} |
			{ next("__success") }? 
			IDENTIFIER '(' 'return' binaryOp expression  ')' |
			
			// TODO handle it properly @see http://blogs.msdn.com/staticdrivertools/archive/2008/11/06/annotating-for-success.aspx
			{ next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) }?  
			IDENTIFIER '(' expression ')' |
			
			{ next("__declspec", "__attribute__", "__asm") }?
			IDENTIFIER
			'(' (
				( an=STRING { 
					String s = String.valueOf(Constant.parseString($an.text).getValue());
					if ($asmName == null) 
						$asmName = s; 
					else 
						$asmName += s; 
				} )* |
				extendedModifiers {
					$modifiers.addAll($extendedModifiers.modifiers);
				}
			) ')'
		)
	;

//http://msdn.microsoft.com/en-us/library/dabb5z75.aspx
extendedModifiers returns [List<Modifier> modifiers]
	:	{ $modifiers = new ArrayList<Modifier>(); }
		(
			{ next(Modifier.Kind.Extended) }? m=modifier
			(
				{
					$modifiers.add($m.modifier);
				}/* |
				{ $IDENTIFIER.text.equals("align") }? DECIMAL_NUMBER |
				{ $IDENTIFIER.text.equals("allocate") }?  '(' STRING ')' |
//				{ $IDENTIFIER.text.equals("property") }?  '(' getSet=IDENTIFIER { $getSet.text.equals("get") || $getSet.text.equals("set") }? '=' func_name=IDENTIFIER ')' |
				{ $IDENTIFIER.text.equals("uuid") }?  '(' ComObjectGUID=STRING ')'*/
			)
		)*
	;
argDef	returns [Arg arg]
@init {
	List<Modifier> stoMods = new ArrayList<Modifier>(), typMods = new ArrayList<Modifier>();
}	
	:	{ 
			$arg = new Arg(); 
			int i = getTokenStream().index() + 1;
			$arg.setCommentBefore(getCommentBefore(i));
			$arg.setCommentAfter(getCommentAfterOnSameLine(i));
		}
		(
			{ next(Modifier.Kind.StorageClassSpecifier) }? 
			sm=modifier { stoMods.add($sm.modifier); } |
			{ next(Modifier.Kind.TypeQualifier) }? 
			tm=modifier { typMods.add($tm.modifier); }
		)*
		(
			tr=mutableTypeRef { 
				if ($tr.type != null) {
					$tr.type.addModifiers(typMods);
					$tr.type.addModifiers(stoMods);
					$arg.setValueType($tr.type); 
				}
			}
		)
		(
			declarator? { 
				if ($declarator.declarator != null)
					$arg.setDeclarator($declarator.declarator); 
				else if ($arg.getValueType() instanceof FunctionSignature) {
					FunctionSignature fs = (FunctionSignature)$arg.getValueType();
					if (fs != null && fs.getFunction() != null) {
						$arg.setName(fs.getFunction().getName());
						fs.getFunction().setName(null);
					}
				}
			}
		)
		('=' expression {
			$arg.setDefaultValue($expression.expr);
		})? 
		| 
		'...' { 
			$arg = Arg.createVarArgs(); 
		}
	;

typeMutator returns [TypeMutator mutator]
	:	//{ next("const", "__const") }? IDENTIFIER '*' { $mutator = TypeMutator.CONST_STAR; } |
		t=('*' | '&') { 
			$mutator = $t.text.equals("*") ? TypeMutator.STAR : TypeMutator.AMPERSTAND; 
		} |
		'[' ']'  { $mutator = TypeMutator.BRACKETS; }
	;

arrayTypeMutator returns [TypeMutator mutator]
	:	'[' 
			expression {
				$mutator = TypeMutator.array($expression.expr); 
			}			
		']' 
	;

templateDef
	:	'template' '<' (templateArgDecl (',' templateArgDecl)* )? '>'
		structCore | functionDeclaration
	;
	
templateArgDecl
	:	mutableTypeRef ('=' constant)?
	;
	
functionSignatureSuffix returns [FunctionSignature signature]
	:	tk='(' m1=modifiers '*' m2=modifiers IDENTIFIER? ')' { 
			$signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, $IDENTIFIER.text, null)), getLine($tk));
			$signature.getFunction().setType(Function.Type.CFunction);
			$signature.getFunction().addModifiers($m1.modifiers);
			$signature.getFunction().addModifiers($m2.modifiers);
		}
		'(' (
			a1=argDef { 
				if (!$a1.text.equals("void"))
					((FunctionSignature)$signature).getFunction().addArg($a1.arg); 
			}
			(
				',' 
				ax=argDef { 
					((FunctionSignature)$signature).getFunction().addArg($ax.arg); 
				}
			)*
		)? ')'
	;

functionSignatureSuffixNoName returns [FunctionSignature signature]
	:	tk='(' modifiers '*' ')' { 
			$signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, null, null)), getLine($tk));
			$signature.getFunction().setType(Function.Type.CFunction);
			$signature.getFunction().addModifiers($modifiers.modifiers);
		}
		'(' (
			a1=argDef { 
				if (!$a1.text.equals("void"))
					((FunctionSignature)$signature).getFunction().addArg($a1.arg); 
			}
			(
				',' 
				ax=argDef { 
					((FunctionSignature)$signature).getFunction().addArg($ax.arg); 
				}
			)*
		)? ')'
	;

mutableTypeRef returns [TypeRef type]
options { k = 4; }
	:	
		( typeRefCore { 
			$type = $typeRefCore.type; 
		} )
		(
			(
				typeMutator {
					$type = $typeMutator.mutator.mutateType($type);
				}
			) |
			(
				functionSignatureSuffix { 
					$functionSignatureSuffix.signature.getFunction().setValueType($type); 
					$type = $functionSignatureSuffix.signature;
				}
			)
		)*
	;
	
nonMutableTypeRef returns [TypeRef type]
//options { k = 4; }
	:	
		typeRefCore { 
			$type = $typeRefCore.type; 
		}
		(
			(
				typeMutator {
					$type = $typeMutator.mutator.mutateType($type);
				}
			)*
			(
				functionSignatureSuffix { 
					$functionSignatureSuffix.signature.getFunction().setValueType($type); 
					$type = $functionSignatureSuffix.signature;
				}
			)
		)*
	;
	
declarator  returns [Declarator declarator]
	:	
		modifiers
		(
			( 
				directDeclarator { 
					$declarator = $directDeclarator.declarator; 
				} 
			) |
			( 
				pt=('*' | '&' | '^')
				inner=declarator {
					$declarator = new PointerDeclarator($inner.declarator, PointerStyle.parsePointerStyle($pt.text));
				} 
			)
		)
		(
			'=' 
			dv=topLevelExpr {
				$declarator.setDefaultValue($dv.expr);
			}
		)?
		{
			$declarator.setModifiers($modifiers.modifiers);
		}
	;

typeDef returns [TypeDef typeDef]
@init {
	$IsTypeDef::isTypeDef = true;
}
	:	'typedef'
	 	varDecl ';' {
		 	VariablesDeclaration vd = $varDecl.decl;
			$typeDef = new TypeDef(vd.getValueType(), vd.getDeclarators());
		}
	;
	
varDeclEOF returns [Declaration decl]
	: varDecl ';' EOF { $decl = $varDecl.decl; }
	;

declarationEOF returns [List<Declaration> declarations]
	: 	d=declaration EOF { $declarations = $d.declarations; }
	;

varDecl returns [VariablesDeclaration decl]
	:	
		tr=nonMutableTypeRef { 
			$decl = new VariablesDeclaration($tr.type); 
		}
		(
			d1=declaratorsList {
				$decl.setDeclarators($d1.declarators);
			}
		)?
	;
	
objCProtocolRefList
	:	'<' 
		IDENTIFIER 
		(
			',' 
			IDENTIFIER
		)* 
		'>'
	;

declaratorsList returns [List<Declarator> declarators]
	:	{ $declarators = new ArrayList<Declarator>(); }
		d=declarator { $declarators.add($d.declarator); }
		(
			',' 
			x=declarator { $declarators.add($x.declarator); }
		)*
	;

directDeclarator  returns [Declarator declarator]
	:	
		(
			IDENTIFIER {
				$declarator = mark(new DirectDeclarator($IDENTIFIER.text), getLine($IDENTIFIER));
				if (isTypeDef()) {
					$Symbols::typeIdentifiers.add($IDENTIFIER.text);
				}
			} | 
			'(' inner=declarator ')' {
				$declarator = $inner.declarator;
				if ($declarator != null) {
					$declarator.setParenthesized(true);
				}
			} 
		)
		(
			'[' 
			(
				expression {
					if ($declarator instanceof ArrayDeclarator)
						((ArrayDeclarator)$declarator).addDimension($expression.expr);
					else
						$declarator = new ArrayDeclarator($declarator, $expression.expr);
				} | {
					$declarator = new ArrayDeclarator($declarator, new Expression.EmptyArraySize());
				}
			)
			']' | 
			argList {
				$declarator = new FunctionDeclarator($declarator, $argList.args);
			}
		)*
	;

argList returns [List<Arg> args, boolean isObjC]
	:	{ 
			$isObjC = false; 
			$args = new ArrayList<Arg>();
		}
		op='(' 
		(
			a1=argDef {
				if (!$a1.text.equals("void"))
					$args.add($a1.arg);
			}
			(
				',' 
				ax=argDef {
					$args.add($ax.arg);
				}
			)*
			( 
				',' '...' {
					$isObjC = true;
					$args.add(Arg.createVarArgs());
				}
			)?
		)?
		cp=')'
	;

/*
primitiveTypeName returns [String name, int line]
	:	
		t=(
			'long' |
			'int' |
			'short' |
			'double' |
			'float' |
			'char' |
			'bool' |
			'void' |
			'__int8' | '__int16' | '__int32' | '__int64'
		) {
			$name = $t.text;
			$line = getLine($t);
		}
	;
//*/
typeRefCore returns [TypeRef type]
@init {
	List<Modifier> modifiers = new ArrayList<Modifier>();
	//TypeRef ref = null;
	int line = -1;
}
	:	
		(
			mods=anyModifier { modifiers.addAll($mods.modifiers); } |
			(
				(
					('typename' | { isTypeIdentifier(next()) }? ) i=IDENTIFIER {
						$type = mark(isPrimitiveType($i.text) ? new Primitive($i.text) : new SimpleTypeRef($i.text), getLine($i));
						$Symbols::typeIdentifiers.add($i.text);
					} /* |
					p=primitiveTypeName {
						$type = mark(new Primitive($p.text), $p.line);
					}//*/
				)
				( 
					'<' { $type = new TemplateRef($i.text); }
						(
							t1=mutableTypeRef { ((TemplateRef)$type).addParameter($t1.type); }
							(
								',' 
								tx=mutableTypeRef { ((TemplateRef)$type).addParameter($tx.type); }
							)*
						)?
					'>'
				)? 
			) |
			structCore { $type = $structCore.struct; } |
			enumCore { $type = $enumCore.e; }
		)+ 
		{
			if ($type == null && !modifiers.isEmpty()) {
				$type = new Primitive(null);
			}
			if ($type != null) {
				$type.addModifiers(modifiers);
				mark($type, line);
			}
		}
	;
	
objCMethodCall returns [FunctionCall expr]
	:
		'[' target=expression methodName=IDENTIFIER {
			$expr = new FunctionCall();
			$expr.setFunction(new VariableRef($methodName.text));
			$expr.setTarget($target.expr);
			$expr.setMemberRefStyle(MemberRefStyle.SquareBrackets);
		}
		(
			':' arg1=expression {
				$expr.addArgument(null, $arg1.expr);
			}
			(
				selx=IDENTIFIER ':' argx=expression {
					$expr.addArgument($selx.text, $argx.expr);
				}
			)*
		)?
		']'
	;
		
functionCall returns [FunctionCall expr]
	:	
		IDENTIFIER '(' {
			FunctionCall fc = new FunctionCall();
			fc.setFunction(new VariableRef($IDENTIFIER.text));
			$expr = fc;
		}
		(
			a1=expression {
				$expr.addArgument($a1.expr);
			}
			(	',' 
				ax=expression {
					$expr.addArgument($ax.expr);
				}
			)* 
		)?
		')'
	;

binaryOp	:	'+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' |
		'<=' | '>=' | '<' | '>' | '==' | '!='
	;

baseExpression returns [Expression expr]
	:
		IDENTIFIER { $expr = new VariableRef($IDENTIFIER.text); } |
		constant { $expr = $constant.constant; } |
		'(' expression ')' { 
			$expr = $expression.expr; 
			if ($expr != null)
				$expr.setParenthesis(true);
		} |
		objCMethodCall { $expr = $objCMethodCall.expr; } |
		selectorExpr |
		protocolExpr |
		encodingExpr//|
	;
	
selectorExpr returns [Expression expr]
	:	'@selector' 
		'(' 
		selectorName 
		')'
	;

selectorName
	:	IDENTIFIER (IDENTIFIER ':')*
	;

protocolExpr
	:	'@protocol'
		'('
		IDENTIFIER
		')'
	;

encodingExpr
	:	'@encode' 
		'('
		IDENTIFIER 
		')'
	;

assignmentExpr returns [Expression expr]
	:	e=inlineCondExpr  { $expr = $e.expr; } 
		( 
			op=assignmentOp f=assignmentExpr { $expr = new AssignmentOp($expr, $op.op, $f.expr); }
		)?
	;
	
assignmentOp returns [Expression.AssignmentOperator op]
	: 	o=('=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=') {
			$op = getAssignmentOperator($o.text);
		}
	;

inlineCondExpr returns [Expression expr]
	:	e=logOrExpr { $expr = $e.expr; } 
		(
			'?'
			logOrExpr 
			':'
			logOrExpr
		)*
	;

addExpr returns [Expression expr]
	:	e=multExpr { $expr = $e.expr; }
		(
			op=('+' | '-')
			f=multExpr { $expr = new BinaryOp($expr, getBinaryOperator($op.text), $f.expr); }
		)*
	;

multExpr returns [Expression expr]
	:	e=castExpr  { $expr = $e.expr; }
		(
			op=('%' | '*' | '/') 
			f=castExpr { $expr = new BinaryOp($expr, getBinaryOperator($op.text), $f.expr); }
		)*
	;

bitOrExpr returns [Expression expr]
	:	e=xorExpr  { $expr = $e.expr; }
		(
			op='|'
			f=xorExpr { $expr = new BinaryOp($expr, getBinaryOperator($op.text), $f.expr); }
		)*
	;

bitAndExpr returns [Expression expr]
	:	e=equalExpr { $expr = $e.expr; }
		(
			op='&'
			f=equalExpr { $expr = new BinaryOp($expr, getBinaryOperator($op.text), $f.expr); }
		)*
	;


shiftExpr returns [Expression expr]
	:	e=addExpr { $expr = $e.expr; }
		(
			op=('>>' | '<<')
			f=addExpr { $expr = new BinaryOp($expr, getBinaryOperator($op.text), $f.expr); }
		)*
	;

xorExpr returns [Expression expr]
	:	e=bitAndExpr { $expr = $e.expr; }
		(
			op='^'
			f=bitAndExpr { $expr = new BinaryOp($expr, getBinaryOperator($op.text), $f.expr); }
		)*
	;

logOrExpr returns [Expression expr]
	:	e=logAndExpr { $expr = $e.expr; }
		(
			op='||'
			f=logAndExpr { $expr = new BinaryOp($expr, getBinaryOperator($op.text), $f.expr); }
		)*
	;

logAndExpr returns [Expression expr]
	:	e=bitOrExpr { $expr = $e.expr; }
		(
			op='&&'
			f=bitOrExpr { $expr = new BinaryOp($expr, getBinaryOperator($op.text), $f.expr); }
		)*
	;

equalExpr returns [Expression expr]
	:	e=compareExpr { $expr = $e.expr; }
		(
			op=('!=' | '==')
			f=compareExpr { $expr = new BinaryOp($expr, getBinaryOperator($op.text), $f.expr); }
		)*
	;

compareExpr returns [Expression expr]
	:	e=shiftExpr { $expr = $e.expr; }
		(
			op=('<' | '<=' | '>' | '>=') 
			f=shiftExpr { $expr = new BinaryOp($expr, getBinaryOperator($op.text), $f.expr); }
		)*
	;

castExpr returns [Expression expr]
	:	'(' tr=mutableTypeRef ')' inner=castExpr { $expr = new Cast($tr.type, $inner.expr); } | 
		e=unaryExpr { $expr = $e.expr; }
	;

unaryExpr returns [Expression expr] 
	:
		p=postfixExpr { $expr = $p.expr; } |
		unaryOp castExpr { $expr = new UnaryOp($castExpr.expr, Expression.getUnaryOperator($unaryOp.text)); } |
		'sizeof' (
			'(' tr=mutableTypeRef ')' | 
			unaryExpr // TODO check this !!!
		)
	;

unaryOp : '++' | '--' | '&' | '*' | '-' | '~' | '!' ;

postfixExpr returns [Expression expr] 
	: 
		baseExpression { $expr = $baseExpression.expr; }
		(
			'[' expression ']' { 
				$expr = new ArrayAccess($expr, $expression.expr); 
			} |
			'(' topLevelExprList? ')' {
				FunctionCall fc = new FunctionCall($expr);
				if ($topLevelExprList.exprs != null)
					for (Expression x : $topLevelExprList.exprs)
						fc.addArgument(x);
				$expr = fc;
			} |
			'.' di=IDENTIFIER { 
				$expr = new MemberRef($expr, MemberRefStyle.Dot, $di.text); 
			} |
			'->' ai=IDENTIFIER { 
				$expr = new MemberRef($expr, MemberRefStyle.Arrow, $ai.text); 
			} |
			'++' { 
				$expr = new UnaryOp($expr, UnaryOperator.PostIncr); 
			} |
			'--' { 
				$expr = new UnaryOp($expr, UnaryOperator.PostDecr); 
			}
		)*
	;

topLevelExpr returns [Expression expr]
	:	e=assignmentExpr { $expr = $e.expr; }
	;
topLevelExprList returns [List<Expression> exprs]
	:	
		{ $exprs = new ArrayList<Expression>(); }
		e=topLevelExpr { $exprs.add($e.expr); }
		(
			','
			f=topLevelExpr { $exprs.add($f.expr); }
		)*
	;

expression returns [Expression expr]
	:	l=topLevelExprList {
			if ($l.exprs != null) {
				if ($l.exprs.size() == 1)
					$expr = $l.exprs.get(0);
				else
					$expr = new ExpressionSequence($l.exprs);
			}
		}
	;

	
statementsBlock returns [Block stat]
scope Symbols; 
@init {
	$Symbols::typeIdentifiers = new HashSet<String>();
}
	:	{ $stat = new Block(); }
		'{' 
		(
					statement {
				$stat.addStatement($statement.stat);
			}
		)* 
		'}' 
	;
statement	returns [Statement stat]
	:
		b=statementsBlock { $stat = $b.stat; } |
		declaration | // TODO
		es=expression ';' { $stat = new ExpressionStatement($es.expr); } |
		rt='return' rex=expression ';' { 
			$stat = mark(new Return($rex.expr), getLine($rt));
		} |
		'if' '(' expression ')' statement ('else' statement)? | // TODO
		'while' '(' expression ')' statement | // TODO
		'do' statement 'while' '(' expression ')' ';' | // TODO
		'for' '(' statement? ';' expression? ';' statement? ')' statement | // TODO
		'switch' '(' expression ')' '{' // TODO
		(	'case' expression ':' |
			statement
		)*
		'}' |
		';' |
		{ next("foreach") }? IDENTIFIER '(' varDecl ':' expression ')' statement // TODO
	;
	
constant returns [Constant constant]
	:	DECIMAL_NUMBER { $constant =  Constant.parseDecimal($DECIMAL_NUMBER.text); } |
		HEXADECIMAL_NUMBER { $constant = Constant.parseHex($HEXADECIMAL_NUMBER.text); } |
		OCTAL_NUMBER { $constant = Constant.parseOctal($OCTAL_NUMBER.text); } |
		CHARACTER { $constant =  Constant.parseCharOrStringInteger($CHARACTER.text); } |
		FLOAT_NUMBER { $constant = Constant.parseFloat($FLOAT_NUMBER.text); } |
		//CHARACTER { $constant =  Constant.parseChar($CHARACTER.text); } |
		STRING { $constant =  Constant.parseString($STRING.text); }
	;
	
	
fragment
Letter
	:	'$' |
		'_' |
		'A'..'Z' |
		'a'..'z'
	;

IDENTIFIER
	:	Letter 
		(
			Letter |
			'0'..'9'
		)*
	;

fragment
FloatingPointExponentSuffix
	:	('e' | 'E')
		('+' | '-')?
		('0'..'9')+
	;

fragment
FloatingPointConstantSuffix
	:	'f' |
		'F' |
		'd' |
		'D'
	;

fragment
CharEscape
	:	'\\'
		(
			'b' | 
			't' | 
			'n' | 
			'f' | 
			'r' | 
			'\"' | 
			'\'' | 
			'\\' 
		) |
		OctalEscape 
	;

fragment
OctalEscape
	:	'\\' (
			('0'..'3') ('0'..'7') ('0'..'7') |
			('0'..'7') ('0'..'7') |
			('0'..'7')
		)
	;

fragment
UnicodeEscape
	:	'\\'
		'u'
		HexDigit HexDigit HexDigit HexDigit
	;


CHARACTER
	:	'\'' 
		(
			CharEscape |
			~(
				'\\' |
				'\''
			)
		)+
		'\''
	;

STRING
	:	'"'
		(
			CharEscape |
			~(
				'\\' |
				'"'
			)
		)*
		'"'
	;


fragment
HexDigit
	:	'0'..'9' |
		'a'..'f' |
		'A'..'F'
	;

fragment
IntegerConstantSuffix
	:	('u' | 'U') |
		(
			('l' | 'L')
			('l' | 'L')?
		)
	;

HEXADECIMAL_NUMBER
	:	'0' ('x'|'X') 
		HexDigit+
		IntegerConstantSuffix?
	;

DECIMAL_NUMBER
	:	('-' | '+')?
		('0' | '1'..'9' '0'..'9'*)
		IntegerConstantSuffix?
	;

OCTAL_NUMBER
	: 	'0'
		('0'..'7')+
		IntegerConstantSuffix?
	;

FLOAT_NUMBER
	:	('-' | '+')?
		('0'..'9')+
		(
			'.'
			('0'..'9')*
		)?
		FloatingPointExponentSuffix?
		FloatingPointConstantSuffix?
	;

WS
	:	(
			' ' |
			'\r' |
			'\t' |
			'\u000C' |
			'\n'
		) {
			$channel=HIDDEN;
		}
    ;

COMMENT
	:	(
			'/*' 
			( options {greedy=false;} : . )* 
			'*/'
		)  { 
			$channel=HIDDEN; 
		}
	;

LINE_COMMENT
	:	(
			'//'
			~('\n'|'\r')*
			('\r'? '\n' | { input.LT(1) == EOF }? )
		) { 
			$channel=HIDDEN;
		}
    ;

