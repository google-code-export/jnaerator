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
import static com.ochafik.lang.jnaerator.parser.VariableStorage.*;
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
		IDENTIFIER { $IDENTIFIER.text.equals("extern") }? 
		STRING 
		'{' 
			(
				ed=declaration { 
					$declarations.addAll($ed.declarations); 
				}
			)* 
		'}' 
	;

declaration returns [List<Declaration> declarations, List<Declaration.Modifier> modifiers, String preComment, int startTokenIndex]
	:	
		{ $declarations = new ArrayList<Declaration>(); 
		  $modifiers = new ArrayList<Declaration.Modifier>();
		  $startTokenIndex = getTokenStream().index();
		  $preComment = getCommentBefore($startTokenIndex);
		}
		(
			externDeclarations {
				$declarations.addAll($externDeclarations.declarations); 
			} |
			exportationModifiers {
				$modifiers.addAll($exportationModifiers.modifiers); 
			}
			(
				//'#import' '<' 
				functionDeclaration {
					$declarations.add($functionDeclaration.function);
				} |
				varDecl { 
					$declarations.add($varDecl.decl); 
				} |
				objCClassDef { 
					$declarations.add($objCClassDef.struct); 
				} |
				typeDef {
					$declarations.add($typeDef.declarations); 
				} |
				forwardClassDecl {
					$declarations.addAll($forwardClassDecl.declarations); 
				} |
				enumDecl {
					$declarations.add($enumDecl.e); 
				} |
				structDef { 
					$declarations.add($structDef.struct); 
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
					d.setCommentBefore($preComment);
					d.setCommentAfter(commentAfter);
					for (Declaration.Modifier modifier : $modifiers)
						d.addModifier(modifier);
				}
				
			}
		)
	;
	
forwardClassDecl returns [List<Declaration> declarations]
	: 	{ $declarations = new ArrayList<Declaration>(); }
		'@class' 
		n1=IDENTIFIER { $declarations.add(Struct.forwardDecl($n1.text, Struct.Type.ObjCClass)); }
		(',' 
		nx=IDENTIFIER { $declarations.add(Struct.forwardDecl($nx.text, Struct.Type.ObjCClass)); }
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
				$e.setName($n1.text);
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
		
enumDecl returns [Enum e]
	:
		t='enum' { 
			$e = mark(new Enum(), getLine($t));
			$e.setCommentBefore(getCommentBefore($t.getTokenIndex()));
		} (
			n1=IDENTIFIER {
				$e.setName($n1.text);
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
		(
			n2=IDENTIFIER {
				$e.setName($n2.text);
			}
		)?
		';'
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
			$struct.setName($className.text);
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
						varDecl { 
							$struct.addDeclaration($varDecl.decl); 
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
				$struct.addDeclaration($typeDef.declarations); 
			} |
			enumDecl {
				$struct.addDeclaration($enumDecl.e); 
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
				$function.addModifier(Declaration.Modifier.Static); 
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

structDef	returns [Struct struct]
	:	
		structCore { $struct = $structCore.struct; }
		(
			varStoragesWithInit {
				for (VariableStorage s : $varStoragesWithInit.storages)
					$struct.addVariableStorage(s);
			}
		)*
		';'
	;
	
structCore	returns [Struct struct]
	:	
		t=('struct' | 'class' | 'union') { 
			$struct = mark(new Struct(), getLine($t)); 
			$struct.setType(
				$t.text.equals("struct") ?	Struct.Type.CStruct :
				$t.text.equals("union") ?	Struct.Type.CUnion :
							Struct.Type.CPPClass
			);
		}
		( 
			( exportationModifiers {
				for (Modifier m : $exportationModifiers.modifiers)
					$struct.addModifier(m);
			} )?
			n1=IDENTIFIER { $struct.setName($n1.text); } 
		)?
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

functionDeclaration returns [Function function]
	:	{ 	
			$function = new Function();
			$function.setType(Function.Type.CFunction);
		}
		/*functionPreModifier? { 
			$function.addModifier($functionPreModifier.modifier); 
		}*/
		returnTypeRef=typeRef? { 
			$function.setValueType($typeRef.type); 
		}
		preMods=exportationModifiers {
			for (Modifier m : $preMods.modifiers)
				$function.addModifier(m);
		}
		IDENTIFIER { 
			$function.setName($IDENTIFIER.text); 
			$function = mark($function, getLine($IDENTIFIER));
		} 
		'(' 
			(
				(
					a1=argDef {
						if (!$a1.text.equals("void"))
							$function.addArg($a1.arg);
					}
					(
						',' 
						ax=argDef {
							$function.addArg($ax.arg);
						}
					)* 
				)
			)? 
		')' 
		ct=('const' | '__const')? {
			if ($ct.text != null)
				$function.addModifier(Declaration.Modifier.Const);
		} 
		postMods=exportationModifiers {
			for (Modifier m : $postMods.modifiers)
				$function.addModifier(m);
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
	: 	{ $modifiers = new ArrayList<Declaration.Modifier>(); }
		( 
			exportationModifier { 
				$modifiers.addAll($exportationModifier.modifiers); 
			} 
		)*
	;
	
exportationModifier returns [List<Modifier> modifiers]
	: 	{ $modifiers = new ArrayList<Declaration.Modifier>(); }
		IDENTIFIER (
			{ 	Declaration.getModifier($IDENTIFIER.text) != null ||
				Declaration.getExportationModifier($IDENTIFIER.text) != null
			}? {
				Modifier mod = Declaration.getModifier($IDENTIFIER.text);
				if (mod == null)
					mod = Declaration.getExportationModifier($IDENTIFIER.text);
				$modifiers.add(mod);
			} |
			{ $IDENTIFIER.text.equals("__declspec") || $IDENTIFIER.text.equals("__attribute__") }? 
			'(' extendedDeclModifiers ')' {
				$modifiers.addAll($extendedDeclModifiers.modifiers);
			}
		)
	;

//http://msdn.microsoft.com/en-us/library/dabb5z75.aspx
extendedDeclModifiers returns [List<Function.Modifier> modifiers]
	:	{ $modifiers = new ArrayList<Declaration.Modifier>(); }
		(
			i=IDENTIFIER 
			(
				{ Declaration.getExtendedModifier($IDENTIFIER.text) != null }? {
					$modifiers.add(Declaration.getExtendedModifier($IDENTIFIER.text));
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

varStorage returns [VariableStorage storage]
	:	{
			$storage = new VariableStorage();
		}
		(
			('const' | '__const') { $storage.addStorageModifier(StorageModifier.Const); } | 
			'*' { $storage.addStorageModifier(StorageModifier.Pointer); } | 
			'&' { $storage.addStorageModifier(StorageModifier.Reference); } | 
			'^' { $storage.addStorageModifier(StorageModifier.DotNetPointer); } 
		)*
		IDENTIFIER? {
			$storage.setName($IDENTIFIER.text); 
		}
		(	
			'[' expression? ']' {
				if ($expression.text == null)
					$storage.addDimension(new EmptyArraySize());//storage.addStorageModifier(StorageModifier.Pointer);
				else 
					$storage.addDimension($expression.expr);//$expression.text != null ? $expression.expr : null);
			}
		)*
	;

varDecl 	returns [StoredDeclarations decl]
	:
		tr=plainTypeRef {
			$decl = mark(new VariablesDeclaration(), $tr.type.getElementLine());
			$decl.setValueType($tr.type);
		}
		varStoragesWithInit {
			if ($varStoragesWithInit.storages.size() == 1) {
				VariableStorage first = $varStoragesWithInit.storages.get(0);
				if (first.toString().length() == 0 && ($tr.type instanceof FunctionSignature)) {
					FunctionSignature fs = (FunctionSignature)$tr.type;
					first.setName(fs.getFunction().getName());
				}
			}
			for (VariableStorage s : $varStoragesWithInit.storages)
				$decl.addVariableStorage(s);
		}
		';'
	;

varStoragesWithInit returns [List<VariableStorage> storages]
	:	{ $storages = new ArrayList<VariableStorage>(); }
		v1=varStorage ('=' e1=expression { $v1.storage.setDefaultValue($e1.expr); })? {
			$storages.add($v1.storage);
		}
		(
			',' vx=varStorage ('=' ex=expression { $vx.storage.setDefaultValue($ex.expr); })? {
				$storages.add($vx.storage);
			}
		)*
	;
	
typeDef 	returns [TypeDef declarations]
	:
		t='typedef' 
		plainTypeRef {
			$declarations = mark(new TypeDef(), getLine($t));
			$declarations.setCommentBefore(getCommentBefore($t.getTokenIndex()));
			$declarations.setValueType($plainTypeRef.type);
		}
		v1=varStorage { $declarations.addVariableStorage($v1.storage); }
		(',' vx=varStorage { $declarations.addVariableStorage($vx.storage); })*
		';'
	;
	
typeMutator returns [TypeMutator mutator]
	:	('const' | '__const') '*' { $mutator = TypeMutator.CONST_STAR; } |
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
	:	ct=('const' | '__const')?
		(
			mod=('typename' | 'struct' | 'class') tr=typeRef { 
				($type = $tr.type).addModifier($mod.text); 
			} | 
			 (
				primitiveTypeRef { $type = $primitiveTypeRef.type; } | 
				IDENTIFIER (
					{ $type = new SimpleTypeRef($IDENTIFIER.text); } |
					'<' { $type = new TemplateRef($IDENTIFIER.text); }
						(
							t1=typeRef { ((TemplateRef)$type).addParameter($t1.type); }
							(
								',' 
								tx=typeRef { ((TemplateRef)$type).addParameter($tx.type); }
							)*
						)?
					'>'
				) {
					$type = mark($type, getLine($IDENTIFIER));
				}
			) 
		) { 
			if ($ct.text != null) 
				$type.addModifier("const", 0); 
		}	
	;

templateDef
	:	'template' '<' (templateArgDecl (',' templateArgDecl)* )? '>'
		structDef | functionDefinition
	;
	
templateArgDecl
	:	primitiveTypeRef ('=' constant) |
		('typename' | 'class') IDENTIFIER ('=' typeRef)
	;
	
functionSignatureSuffix returns [FunctionSignature signature]
	:	tk='(' exportationModifiers '*' IDENTIFIER? ')' { 
			$signature = mark(new FunctionSignature(new Function($IDENTIFIER.text, null)), getLine($tk));
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

plainTypeRef returns [TypeRef type]
	:	
		structCore { $type = mark(new StructTypeRef($structCore.struct), $structCore.struct.getElementLine()); } |
		enumCore { $type = mark(new EnumTypeRef($enumCore.e), $enumCore.e.getElementLine()); } |
		typeRefCore { $type = $typeRefCore.type; }
		(
			functionSignatureSuffix { 
				$functionSignatureSuffix.signature.getFunction().setValueType($type); 
				$type = $functionSignatureSuffix.signature;
			}
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

LONG	:	'long';

primitiveTypeRef returns [TypeRef type, int line]
	:	{ $line = getLine(); }
		(	mod1=primSignModifier?
			
			(mod2=primSizeModifier
			mod3=primSizeModifier?)?
			name=primitiveTypeName
			{
				$type = mark(new Primitive($name.text), $line);
				$type.addModifier($mod1.text);
				$type.addModifier($mod2.text);
				$type.addModifier($mod3.text);
			} |
			mod=primSignModifier {
				$type = mark(new Primitive("int"), $line);
				$type.addModifier($mod.text);
			}
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
		IDENTIFIER { $IDENTIFIER.text.equals("foreach") }? '(' varDecl ':' expression ')' statement
	;
	
constant returns [Constant constant]
	:	DECIMAL_NUMBER { $constant =  Constant.parseDecimal($DECIMAL_NUMBER.text); } |
		HEXADECIMAL_NUMBER { $constant = Constant.parseHex($HEXADECIMAL_NUMBER.text); } |
		OCTAL_NUMBER { $constant = Constant.parseOctal($OCTAL_NUMBER.text); } |
		CHARACTER { $constant =  Constant.parseCharOrStringInteger($CHARACTER.text); } |
		FLOAT_NUMBER { $constant = Constant.parseFloat($FLOAT_NUMBER.text); } |
		CHARACTER { $constant =  Constant.parseChar($CHARACTER.text); } |
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
			'\r'?
			'\n'
		) { 
			$channel=HIDDEN;
		}
    ;

