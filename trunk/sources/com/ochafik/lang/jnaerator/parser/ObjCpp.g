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

/**
	This grammar is by no mean complete.
	It is able to parse preprocessed C & Objective-C files and can tolerate some amount of C++. 
	It lacks serious expression support, which is being worked on.
	Complex variable declarations may not be supported, such as complex signatures of functions that return function pointers...
*/

grammar ObjCpp;
options {
  backtrack=true;
  output=AST;
  k=3;
}

@header { 
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

package com.ochafik.lang.jnaerator.parser;
import java.util.Arrays;
import static com.ochafik.lang.jnaerator.parser.TypeRef.*;
import static com.ochafik.lang.jnaerator.parser.Expression.*;
import static com.ochafik.lang.jnaerator.parser.Declaration.*;
import static com.ochafik.lang.jnaerator.parser.Declarator.*;
import static com.ochafik.lang.jnaerator.parser.StoredDeclarations.*;
}

@members {
	String lastComment;
	String file;
	int sourceLineDelta = 0; // line(token) = token.line - lastLineToken.line + lastLine; sourceLineDelta = lastLine - lastLineToken.line
	//String pack;
	public void setFile(String file) { 
		this.file = file; 
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
				if (comment != null)
					return comment;
				comment = token.getText();
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
		return input.LT(1).getText();
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
	:	
		{ $sourceFile = mark(new SourceFile(), getLine()); }
		(
			declaration { 
				for (Declaration d : $declaration.declarations)
					$sourceFile.addDeclaration(d); 
			} |
			lineDirective
		)* 
	 	EOF
	;

externDeclarations returns [List<Declaration> declarations]
	:	{ $declarations = new ArrayList<Declaration>(); }
		{ next("extern") }? IDENTIFIER
		STRING 
		'{' 
			(
				ed=declaration { 
					$declarations.addAll($ed.declarations); 
				}
			)* 
		'}' 
	;

declaration returns [List<Declaration> declarations, List<Modifier> modifiers, String preComment, int startTokenIndex]
	:	
		{ $declarations = new ArrayList<Declaration>(); 
		  $modifiers = new ArrayList<Modifier>();
		  $startTokenIndex = getTokenStream().index();
		  $preComment = getCommentBefore($startTokenIndex);
		}
		(
			/*externDeclarations {
				$declarations.addAll($externDeclarations.declarations); 
			} |
			exportationModifiers {
				$modifiers.addAll($exportationModifiers.modifiers); 
			}*/
			(
				//'#import' '<' 
				functionDeclaration {
					$declarations.add($functionDeclaration.function);
				} |
				varDecl { 
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
					for (Modifier modifier : $modifiers)
						d.addModifiers(modifier);
				}
				
			}
		)
	;
	
forwardClassDecl returns [List<Declaration> declarations]
	: 	{ $declarations = new ArrayList<Declaration>(); }
		'@class' 
		n1=IDENTIFIER { $declarations.add(decl(Struct.forwardDecl($n1.text, Struct.Type.ObjCClass))); }
		(',' 
		nx=IDENTIFIER { $declarations.add(decl(Struct.forwardDecl($nx.text, Struct.Type.ObjCClass))); }
		)*
		';' 
	;
	
functionPointerVarDecl  returns [List<? extends Declaration> declarations]
	:	typeRef {
			($typeRef.type instanceof FunctionSignature) && 
			((FunctionSignature)$typeRef.type).getFunction().getName() != null
		}? {
			$declarations = Arrays.asList(new FunctionPointerDeclaration(((FunctionSignature)$typeRef.type)));
		}
		';'
	;
	
enumItem returns [Enum.EnumItem item]
	:	n=IDENTIFIER ('=' v=expression)? {
			$item = new Enum.EnumItem($n.text, $v.text == null ? null : $v.expr);
			$item.setCommentBefore(getCommentBefore($n.getTokenIndex()));
			$item.setCommentAfter(getCommentAfterOnSameLine($n.getTokenIndex() - 1));
		}
	;
	
enumCore returns [Enum e]
	:
		t='enum' { 
			$e = mark(new Enum(), getLine($t));
			$e.setCommentBefore(getCommentBefore($t.getTokenIndex()));
		} (
			n1=IDENTIFIER {
				$e.setTag($n1.text);
			}
		)? 
		'{'
			i1=enumItem { 
				$e.addItem($i1.item); 
			}
			(
				',' 
				(ix=enumItem { 
					if ($ix.text != null)
						$e.addItem($ix.item); 
				})?
			)*
		'}'
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
			$struct = mark(new Struct(), getLine($octype));
			$struct.setCommentBefore(getCommentBefore($octype.getTokenIndex()));
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
						fv=varDecl { 
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
			vd=varDecl { !($vd.decl instanceof VariablesDeclaration) }? {
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
				returnTypeRef=typeRef? { 
					$function.setValueType($returnTypeRef.type); 
				}
			')'
		)?
		methodName=IDENTIFIER { 
			$function.setName($methodName.text); 
			$function.setCommentAfter(getCommentAfterOnSameLine($methodName.getTokenIndex()));
		} 
		(
			':' '(' argType1=typeRef ')' argName1=IDENTIFIER {
				Arg arg = new Arg($argName1.text, $argType1.type);
				arg.setSelector($methodName.text);
				$function.addArg(arg);
			}
			(
				sel=IDENTIFIER ':' 
				'(' argType=typeRef ')' 
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

/*
structDef	returns [Struct struct]
	:	
		structCore { $struct = $structCore.struct; }
		(
			varStoragesWithInit {
				for (Declarator s : $varStoragesWithInit.storages)
					$struct.addDeclarator(s);
			}
		)*
		';'
	;
*/	
structCore	returns [Struct struct, List<Modifier> modifiers]
	:	
		//(rc=IDENTIFIER { $rc.text.equals("ref") }?)? // TODO: managed c++ ref class
		t=('struct' | 'class' | 'union') { 
			$struct = mark(new Struct(), getLine($t)); 
			$struct.setType(
				$t.text.equals("struct") ?	Struct.Type.CStruct :
				$t.text.equals("union") ?	Struct.Type.CUnion :
							Struct.Type.CPPClass
			);
			$struct.setForwardDeclaration(true); // until proven wrong
		}
		(
			(
				n0=IDENTIFIER {
					$struct.setTag($n0.text);
					$struct.setForwardDeclaration(true);
				}
			) |
			( 
				( exportationModifiers {
					for (Modifier m : $exportationModifiers.modifiers)
						$struct.addModifiers(m);
				} )?
				n1=IDENTIFIER { $struct.setTag($n1.text); } 
			)?
			'{'	{ $struct.setForwardDeclaration(false); }
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
		)
	;

//structInsides returns [List<Declaration> declarations, Struct.MemberVisibility
functionDeclaration returns [Function function]
	:	{ 	
			$function = new Function();
			$function.setType(Function.Type.CFunction);
		}
		/* functionPreModifier? { 
			$function.addModifiers($functionPreModifier.modifier); 
		}*/
		returnTypeRef=typeRef? { 
			$function.setValueType($typeRef.type); 
		}
		preMods=exportationModifiers {
			for (Modifier m : $preMods.modifiers)
				$function.addModifiers(m);
		}
		n=IDENTIFIER { 
			$function.setName($n.text); 
			$function = mark($function, getLine($n));
		} 
		'(' 
			argList {
				$function.setArgs($argList.args);
			}
		')' 
		{ next("const", "__const") }? ct=IDENTIFIER?{
			if ($ct.text != null)
				$function.addModifiers(Modifier.Const);
		} 
		postMods=exportationModifiers {
			for (Modifier m : $postMods.modifiers)
				$function.addModifiers(m);
		}
		(	
			';' |
			statementsBlock {
			
			}
		)
	;

functionDefinition
	:	functionDeclaration '{' '}'
	;
	
exportationModifiers returns [List<Modifier> modifiers]
	: 	{ $modifiers = new ArrayList<Modifier>(); }
		( 
			exportationModifier { 
				$modifiers.addAll($exportationModifier.modifiers); 
			} 
		)*
	;

modifier returns [Modifier modifier]
	:	{ Modifier.parseModifier(next()) != null }?
		IDENTIFIER {
			$modifier = Modifier.parseModifier($IDENTIFIER.text);
		}
	;
	/*
plainModifier returns [Modifier modifier]
	:	IDENTIFIER
		{ 	Modifier.parseModifier($IDENTIFIER.text, Modifier.Kind.Plain) != null }? {
			$modifier = Modifier.parseModifier($IDENTIFIER.text, Modifier.Kind.Plain);
		}
	;
	*/	
exportationModifier returns [List<Modifier> modifiers]
	: 	{ $modifiers = new ArrayList<Modifier>(); }
		(
			{ next(Modifier.Kind.Plain) }? modifier {
				$modifiers.add($modifier.modifier);
			} |
			IDENTIFIER { $IDENTIFIER.text.equals("__declspec") || $IDENTIFIER.text.equals("__attribute__") }? 
			'(' extendedModifiers ')' {
					$modifiers.addAll($extendedModifiers.modifiers);
			}
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
	:	typeRef (IDENTIFIER arrayTypeMutator?)? { 
			TypeRef type = $arrayTypeMutator.text == null ?
				$typeRef.type :
				$arrayTypeMutator.mutator.mutateType($typeRef.type);
			$arg = new Arg($IDENTIFIER.text, type); 
		} 
		('=' expression {
			$arg.setDefaultValue($expression.expr);
		})? 
		| 
		'...' { 
			$arg = Arg.createVarArgs(); 
		}
	;
/*	
typeDef 	returns [TypeDef declarations]
	:
		t='typedef' 
		plainTypeRef {
			$declarations = mark(new TypeDef(), getLine($t));
			$declarations.setCommentBefore(getCommentBefore($t.getTokenIndex()));
			$declarations.setValueType($plainTypeRef.type);
		}
		v1=varStorage { $declarations.addDeclarator($v1.storage); }
		(',' vx=varStorage { $declarations.addDeclarator($vx.storage); })*
		';'
	;
*/
typeMutator returns [TypeMutator mutator]
	:	{ next("const", "__const") }? IDENTIFIER '*' { $mutator = TypeMutator.CONST_STAR; } |
		'*' { $mutator = TypeMutator.STAR; } |
		'&' { $mutator = TypeMutator.AMPERSTAND; }  |
		'[' ']'  { $mutator = TypeMutator.BRACKETS; }
	;

arrayTypeMutator returns [TypeMutator mutator]
	:	'[' 
			expression {
				$mutator = TypeMutator.array($expression.expr); 
			}			
		']' 
	;
	
typeRefCore returns [TypeRef type]
@init { List<Modifier> mods = new ArrayList<Modifier>(); }
	:	({ next(Modifier.Kind.TypeQualifier) }? m=modifier { mods.add($m.modifier); })?
		(
			{ next(Modifier.Kind.ReferenceQualifier) }? m1=modifier { mods.add($m1.modifier); }
			tr=typeRef { $type = $tr.type; } | 
			//({ next(Modifier.Kind.ReferenceQualifier, Modifier.Kind.StorageClassSpecifier) }? m2=modifier { mods.add($m2.modifier); })*
			(
				primitiveTypeRef { $type = $primitiveTypeRef.type; } | 
				{ Modifier.parseModifier(next()) == null }? ref=IDENTIFIER (
					{ $type = new SimpleTypeRef($ref.text); } |
					'<' { $type = new TemplateRef($ref.text); }
						(
							t1=typeRef { ((TemplateRef)$type).addParameter($t1.type); }
							(
								',' 
								tx=typeRef { ((TemplateRef)$type).addParameter($tx.type); }
							)*
						)?
					'>'
				) {
					$type = mark($type, getLine($ref));
				}
			) 
		) { $type.addModifiers(mods); }	
	;

templateDef
	:	'template' '<' (templateArgDecl (',' templateArgDecl)* )? '>'
		structCore | functionDefinition
	;
	
templateArgDecl
	:	primitiveTypeRef ('=' constant) |
		('typename' | 'class') IDENTIFIER ('=' typeRef)
	;
	
functionSignatureSuffix returns [FunctionSignature signature]
	:	tk='(' exportationModifiers '*' IDENTIFIER? ')' { 
			$signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, $IDENTIFIER.text, null)), getLine($tk));
			$signature.getFunction().setType(Function.Type.CFunction);
			$signature.getFunction().addModifiers($exportationModifiers.modifiers);
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
	:	tk='(' exportationModifiers '*' ')' { 
			$signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, null, null)), getLine($tk));
			$signature.getFunction().setType(Function.Type.CFunction);
			$signature.getFunction().addModifiers($exportationModifiers.modifiers);
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

structOrEnum returns [TypeRef type]
	:	
		structCore { $type = $structCore.struct; } |
		enumCore { $type = $enumCore.e; }
	;
	
typeRefCoreOrFuncSig returns [TypeRef type]
	:	typeRefCore { $type = $typeRefCore.type; }
		(
			(
				typeMutator {
					$type = $typeMutator.mutator.mutateType($type);
				}
			)*
			functionSignatureSuffix { 
				$functionSignatureSuffix.signature.getFunction().setValueType($type); 
				$type = $functionSignatureSuffix.signature;
			}
		)?
	;
		
typeRefCoreOrAnonymousFuncSig returns [TypeRef type]
	:	typeRefCore { $type = $typeRefCore.type; }
		(
			(
				typeMutator {
					$type = $typeMutator.mutator.mutateType($type);
				}
			)*
			functionSignatureSuffixNoName { 
				$functionSignatureSuffixNoName.signature.getFunction().setValueType($type); 
				$type = $functionSignatureSuffixNoName.signature;
			}
		)?
	;
		
plainTypeRef returns [TypeRef type]
	:	
		structOrEnum { $type = $structOrEnum.type; } |
		typeRefCoreOrFuncSig { $type = $typeRefCoreOrFuncSig.type; }
	;

declarator  returns [Declarator declarator, List<Modifier> modifiers]
	:	{ $modifiers = new ArrayList<Modifier>(); }
		(
			{ next(Modifier.Kind.TypeQualifier) }? modifier {
				$modifiers.add($modifier.modifier);
			}
			/* | protocolQualifier {
			
			}*/
		)*
		(
			(
				(	
					pt=('*' | '&' | '^')
					inner=declarator {
						$declarator = new PointerDeclarator($inner.declarator, PointerStyle.parsePointerStyle($pt.text));
					}
				) |
				directDeclarator { 
					$declarator = $directDeclarator.declarator; 
				}
			)
			(	
				'=' 
				expression {
					$declarator.setDefaultValue($expression.expr);
				}
			)?
		) {
			$declarator.setModifiers($modifiers);
		}
	;

//varDecl:	declarationSpecifiers declaratorsList*;

namedTypeRef returns [TaggedTypeRef type]
	:	
		structCore { $structCore.struct.getTag() != null }? {
			$type = $structCore.struct;
		} |
		enumCore { $enumCore.e.getTag() != null }? {
			$type = $enumCore.e;
		}
	;

typeDef returns [TypeDef typeDef]
	:	'typedef' 
	 	varDecl { 
			($varDecl.decl instanceof VariablesDeclaration) 
		}? {
			VariablesDeclaration vd = (VariablesDeclaration)$varDecl.decl;
			$typeDef = new TypeDef(vd.getValueType(), vd.getDeclarators());
		}
	;
	
varDeclEOF returns [Declaration decl]
	: varDecl EOF { $decl = $varDecl.decl; }
	;
	
varDecl returns [Declaration decl, TypeRef type]
@init {
	List<Modifier> stoMods = new ArrayList<Modifier>(), typMods = new ArrayList<Modifier>();
}	
	:	(
			{ next(Modifier.Kind.StorageClassSpecifier) }? 
			sm=modifier { stoMods.add($sm.modifier); } |
			{ next(Modifier.Kind.TypeQualifier) }? 
			tm=modifier { typMods.add($tm.modifier); }
		)*
		(
			/*namedTypeRef {
				$decl = new TaggedTypeRefDeclaration($namedTypeRef.type);
			} |*/
			(
				structOrEnum { 
					$type = $structOrEnum.type;
					//$decl = new VariablesDeclaration($type);
				}
				(
					d1=declaratorsList? {
						if ($d1.declarators != null)
							$decl = new VariablesDeclaration($type, $d1.declarators);
						else
							$decl = new VariablesDeclaration($type); //new TaggedTypeRefDeclaration((TaggedTypeRef)$type);
					}	
				) |
				tcfs=typeRefCoreOrAnonymousFuncSig { $type = $tcfs.type; }
				d2=declaratorsList {
					$decl = new VariablesDeclaration($type, $d2.declarators);
				}
				
				//plainTypeRef { $type = $plainTypeRef.type; }
				/*(
					structCore { 
						$type = $structCore.struct; 
					} |
					enumCore { 
						$type = $enumCore.e; 
					} |
					typeRefCore { 
						$type = $typeRefCore.type; 
					}
				)*/
				/*declaratorsList { 
					$decl = new VariablesDeclaration($type, $declaratorsList.declarators);
				}*/
			)
		)
		';' { 
			$decl.addModifiers(stoMods);
			$type.addModifiers(typMods); 
		}
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
/*
type_specifier:
'void' | 'char' | 'short' | 'int' | 'long' | 'float' | 'double' | 'signed' | 'unsigned' 
	|	IDENTIFIER objCProtocolRefList?
	|	struct_or_union_specifier
	|	enum_specifier 
	|	IDENTIFIER;
*/
declaratorsList returns [List<Declarator> declarators]
	:	{ $declarators = new ArrayList<Declarator>(); }
		(
			d=declarator { $declarators.add($d.declarator); }
			(
				',' 
				x=declarator { $declarators.add($x.declarator); }
			)*
		)
	;

directDeclarator  returns [Declarator declarator]
@init {
	List<Modifier> modifiers = new ArrayList<Modifier>();
} 
	:	(
			//primitiveTypeRef |
			IDENTIFIER {
				$declarator = new DirectDeclarator($IDENTIFIER.text);
			} | 
			'(' 
			(im=modifier { modifiers.add($im.modifier); })*
			inner=declarator 
			')' {
				$declarator = $inner.declarator;
				$declarator.setParenthesized(true);
				$declarator.addModifiers(modifiers);
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
			'(' argList ')' {
				$declarator = new FunctionDeclarator($declarator, $argList.args);
			}
		)*
	;

argList returns [List<Arg> args, boolean isObjC]
	:	{ 
			$isObjC = false; 
			$args = new ArrayList<Arg>();
		}
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
		
	;

typeRef	returns [TypeRef type]
	:	
		plainTypeRef {
			$type = $plainTypeRef.type;
		}
		(
			typeMutator {
				$type = $typeMutator.mutator.mutateType($type);
			}
		)*
	;

primSignModifier
	:	'signed' | 'unsigned' | '__signed' | '__unsigned';
	
primSizeModifier
	:	'long' | 'short';
	
primitiveTypeName
	:	'long' |
		'int' |
		'short' |
		'double' |
		'float' |
		'char' |
		'void' |
		'__int8' | '__int16' | '__int32' | '__int64'
		/* |
		'size_t'*/
	;

primitiveTypeRef returns [TypeRef type, int line, List<Modifier> modifiers]
	:	{ 
			$line = getLine(); 
			$modifiers = new ArrayList<Modifier>();
		}
		(	
			mod1=primSignModifier?		
			(mod2=primSizeModifier
			mod3=primSizeModifier?)?
			//({ next(Modifier.Kind.SignModifier) }? m1=modifier { $modifiers.add($m1.modifier); })?				
			//(({ next(Modifier.Kind.SizeModifier) }? m2=modifier { $modifiers.add($m2.modifier); })
			// ({ next(Modifier.Kind.SizeModifier) }? m3=modifier { $modifiers.add($m3.modifier); })?)?
			/*(
				{ next(Modifier.Kind.SizeModifier, Modifier.Kind.SignModifier) }? 
				m=modifier { $modifiers.add($m.modifier); }
			)**/
			(
				//{ TypeRef.Primitive.isACPrimitive(next()) }?
				//name=IDENTIFIER
				name=primitiveTypeName
				{
					$type = mark(new Primitive($name.text), $line);
					//$type.addModifiers($modifiers);
					$type.addModifiers(Modifier.parseModifier($mod1.text));
					$type.addModifiers(Modifier.parseModifier($mod2.text));
					$type.addModifiers(Modifier.parseModifier($mod3.text));

				}/* |
				//{ !$modifiers.isEmpty() }? 
				{
					if (!$modifiers.isEmpty() && ($modifiers.get($modifiers.size() - 1).isA(Modifier.Kind.SizeModifier))) {
						$type = mark(new Primitive($modifiers.get($modifiers.size() - 1).toString()), $line);
						$modifiers.remove($modifiers.size() - 1);
					} else
						$type = mark(new Primitive("int"), $line);
					$type.addModifiers($modifiers);
				}*/
			)
				/*
			{ next(Modifier.Kind.SignModifier) }? 
			//{ next("long", "short", "signed", "unsigned", "__signed", "__unsigned") }? 
			mod=modifier {
				$type = mark(new Primitive("int"), $line);
				$type.addModifiers($mod.modifier);
			}*/
		)
	;

objCMethodCall returns [FunctionCall expr]
	:
		'[' target=expression methodName=IDENTIFIER {
			$expr = new FunctionCall($methodName.text);
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
		'sizeof' '(' typeRef ')' {
			$expr = new FunctionCall("sizeof");
			$expr.addArgument(new TypeRefExpression($typeRef.type));
		} |
		IDENTIFIER '(' {
			$expr = new FunctionCall($IDENTIFIER.text);
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

expression returns [Expression expr]
	:	(
			id=IDENTIFIER {
				$expr = new VariableRef($id.text);
			} |
			fc1=functionCall { 
				$expr = $fc1.expr; 
			} |
			objCMethodCall { 
				$expr = $objCMethodCall.expr; 
							} |
			prefixOp=('!' | '~') opd=expression {
				$expr = new UnaryOp(Expression.getUnaryOperator($prefixOp.text), $opd.expr);
			} |
			'(' (
				par=expression ')' {
					$expr = $par.expr;
					if ($expr != null)
						$expr.setParenthesis(true);
				} |
				typeRef ')' casted=expression {
					$expr = new Cast($typeRef.type, $casted.expr);
				} 
			) |
			constant { $expr = $constant.constant; } |
			'{' expression '}' // TODO in some union initializers, for instance : union{ float __f; unsigned int __u; }__u = {__x};
		)
		(
			bop=(
				'+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' |
				'<=' | '>=' | '<' | '>' | '==' | '!='
			)
			opd2=expression {
				$expr = new BinaryOp(getBinaryOperator($bop.text), $expr, $opd2.expr);
			} |
			'=' val=expression {
				$expr = new Assignment($expr, $val.expr);
			} |
			'.' fieldName=IDENTIFIER {
				$expr = new FieldRef($expr, $fieldName.text, MemberRefStyle.Dot);
			} |
			refStyle=(':' ':' | '-' '>' | '.') fc2=functionCall {
				if ($fc2.expr != null) {
					$fc2.expr.setTarget($expr);
					$fc2.expr.setMemberRefStyle(parseMemberRefStyle($refStyle.text));
					$expr = $fc2.expr;
				}
			} |
			'?' xif=expression ':' xelse=expression {
				//TODO
			}
		
		)*
	;

statementsBlock
	:	'{' statement* '}'
	;
statement	
	:
		statementsBlock |
		declaration |
		expression ('=' expression )? ';' |
		'return' expression ';' |
		'if' '(' expression ')' statement ('else' statement)? |
		'while' '(' expression ')' statement |
		'do' statement 'while' '(' expression ')' ';' |
		'for' '(' statement? ';' expression? ';' statement? ')' statement |
		'switch' '(' expression ')' '{'
		(	'case' expression ':' |
			statement
		)*
		'}' |
		';' |
		{ next("foreach") }? IDENTIFIER '(' varDecl ':' expression ')' statement
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

