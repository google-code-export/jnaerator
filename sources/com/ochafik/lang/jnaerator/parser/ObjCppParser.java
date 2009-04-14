// $ANTLR 3.1.2 /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g 2009-04-14 03:06:41
 
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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

/**
	This grammar is by no mean complete.
	It is able to parse preprocessed C & Objective-C files and can tolerate some amount of C++. 
	It lacks serious expression support, which is being worked on.
	Complex variable declarations may not be supported, such as complex signatures of functions that return function pointers...
*/
public class ObjCppParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DECIMAL_NUMBER", "STRING", "IDENTIFIER", "HEXADECIMAL_NUMBER", "OCTAL_NUMBER", "CHARACTER", "FLOAT_NUMBER", "Letter", "FloatingPointExponentSuffix", "FloatingPointConstantSuffix", "OctalEscape", "CharEscape", "HexDigit", "UnicodeEscape", "IntegerConstantSuffix", "WS", "COMMENT", "LINE_COMMENT", "'#line'", "'{'", "'}'", "';'", "'namespace'", "'@class'", "','", "'='", "'enum'", "'@protocol'", "'@interface'", "':'", "'('", "')'", "'<'", "'>'", "'@public'", "'@private'", "'@protected'", "'@end'", "'+'", "'-'", "'...'", "'public'", "'private'", "'protected'", "'struct'", "'class'", "'union'", "'~'", "'return'", "'*'", "'&'", "'['", "']'", "'template'", "'^'", "'typedef'", "'typename'", "'/'", "'%'", "'<<'", "'>>>'", "'>>'", "'||'", "'|'", "'&&'", "'<='", "'>='", "'=='", "'!='", "'@selector'", "'@encode'", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'?'", "'sizeof'", "'++'", "'--'", "'!'", "'.'", "'->'", "'break'", "'if'", "'else'", "'while'", "'do'", "'for'", "'switch'", "'case'"
    };
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int EOF=-1;
    public static final int CHARACTER=9;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__90=90;
    public static final int COMMENT=20;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int OCTAL_NUMBER=8;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int DECIMAL_NUMBER=4;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int LINE_COMMENT=21;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int WS=19;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int FloatingPointConstantSuffix=13;
    public static final int IntegerConstantSuffix=18;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int Letter=11;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int HEXADECIMAL_NUMBER=7;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int HexDigit=16;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int IDENTIFIER=6;
    public static final int CharEscape=15;
    public static final int T__59=59;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int FLOAT_NUMBER=10;
    public static final int FloatingPointExponentSuffix=12;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int UnicodeEscape=17;
    public static final int OctalEscape=14;
    public static final int STRING=5;

    // delegates
    // delegators

    protected static class Symbols_scope {
        Set<String> typeIdentifiers;
    }
    protected Stack Symbols_stack = new Stack();
    protected static class IsTypeDef_scope {
        boolean isTypeDef;
    }
    protected Stack IsTypeDef_stack = new Stack();


        public ObjCppParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ObjCppParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return ObjCppParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g"; }


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
    		return token.getLine(); //+ sourceLineDelta;
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
    		return next(1, ss);
    	}
    	protected boolean next(int i, String... ss) {
    		String n = next(i);
    		for (String s : ss)
    			if (s.equals(n))
    				return true;
    				
    		return false;
    	}
    	
    	String getSurroundings(Token t, int width) {
    		if (t == null)
    			return null;
    		int x = t.getTokenIndex();
    		List<String> strs = new ArrayList<String>();
    		int size = getTokenStream().size();
    		for (int i = x - width; i < x + width + 1; i++) {
    			if (i < 0 || i >= size)
    				continue;

    			strs.add(getTokenStream().get(i).getText());
    		}
    		return com.ochafik.util.string.StringUtils.implode(strs, " ");
    	}
    	@Override
    	public String getErrorMessage(RecognitionException e, String[] tokenNames) {
    		if (e instanceof NoViableAltException) {
    			NoViableAltException ne = (NoViableAltException)e;
    			return "Failed to match any alternative with token " + ne.token + "\n\t" +
    				" File: " + getFile() + ":" + (ne.line + sourceLineDelta) + "\n\t" +
    				"Input: " + getSurroundings(ne.token, 5).replace('\n', ' ') + "\n\t" +
    				" Rule: " + ne.grammarDecisionDescription + "\n\t" +
    				"Stack: " + getRuleInvocationStack(e, getClass().getName()) + "\n";
    		} else
    			return super.getErrorMessage(e, tokenNames);
    	}
    	@Override
    	public String getTokenErrorDisplay(Token t) {
    		return t.toString();	
    	}


    public static class lineDirective_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "lineDirective"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:285:1: lineDirective : ln= '#line' line= DECIMAL_NUMBER (unescapedString= STRING )? (depth= DECIMAL_NUMBER )? ;
    public final ObjCppParser.lineDirective_return lineDirective() throws RecognitionException {
        ObjCppParser.lineDirective_return retval = new ObjCppParser.lineDirective_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ln=null;
        Token line=null;
        Token unescapedString=null;
        Token depth=null;

        Object ln_tree=null;
        Object line_tree=null;
        Object unescapedString_tree=null;
        Object depth_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:286:2: (ln= '#line' line= DECIMAL_NUMBER (unescapedString= STRING )? (depth= DECIMAL_NUMBER )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:286:4: ln= '#line' line= DECIMAL_NUMBER (unescapedString= STRING )? (depth= DECIMAL_NUMBER )?
            {
            root_0 = (Object)adaptor.nil();

            ln=(Token)match(input,22,FOLLOW_22_in_lineDirective78); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ln_tree = (Object)adaptor.create(ln);
            adaptor.addChild(root_0, ln_tree);
            }
            line=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_lineDirective82); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            line_tree = (Object)adaptor.create(line);
            adaptor.addChild(root_0, line_tree);
            }
            if ( state.backtracking==0 ) {

              			try {
              				sourceLineDelta = Integer.parseInt((line!=null?line.getText():null)) - ln.getLine() - 1;
              			} catch (Exception ex) {
              				System.err.println("ERROR: unparsable line in #line directive : " + (line!=null?line.getText():null));
              				sourceLineDelta = 0;
              			}
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:294:3: (unescapedString= STRING )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==STRING) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:295:4: unescapedString= STRING
                    {
                    unescapedString=(Token)match(input,STRING,FOLLOW_STRING_in_lineDirective95); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    unescapedString_tree = (Object)adaptor.create(unescapedString);
                    adaptor.addChild(root_0, unescapedString_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				String fileStr = (unescapedString!=null?unescapedString.getText():null).trim();
                      				if (fileStr.startsWith("\"")) {
                      					fileStr = fileStr.substring(1);
                      					if (fileStr.endsWith("\""))
                      						fileStr = fileStr.substring(0, fileStr.length() - 1);
                      				}				
                      				setFile(fileStr);
                      			
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:305:8: (depth= DECIMAL_NUMBER )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==DECIMAL_NUMBER) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: depth= DECIMAL_NUMBER
                    {
                    depth=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_lineDirective110); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    depth_tree = (Object)adaptor.create(depth);
                    adaptor.addChild(root_0, depth_tree);
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "lineDirective"

    public static class sourceFile_return extends ParserRuleReturnScope {
        public SourceFile sourceFile;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sourceFile"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:308:1: sourceFile returns [SourceFile sourceFile] : ( declaration | lineDirective )* EOF ;
    public final ObjCppParser.sourceFile_return sourceFile() throws RecognitionException {
        Symbols_stack.push(new Symbols_scope());

        ObjCppParser.sourceFile_return retval = new ObjCppParser.sourceFile_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF3=null;
        ObjCppParser.declaration_return declaration1 = null;

        ObjCppParser.lineDirective_return lineDirective2 = null;


        Object EOF3_tree=null;


        	((Symbols_scope)Symbols_stack.peek()).typeIdentifiers = new HashSet<String>();

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:313:2: ( ( declaration | lineDirective )* EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:314:3: ( declaration | lineDirective )* EOF
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.sourceFile = new SourceFile(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:315:3: ( declaration | lineDirective )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==IDENTIFIER||(LA3_0>=25 && LA3_0<=27)||(LA3_0>=30 && LA3_0<=32)||LA3_0==34||(LA3_0>=48 && LA3_0<=51)||(LA3_0>=53 && LA3_0<=55)||(LA3_0>=58 && LA3_0<=60)) ) {
                    alt3=1;
                }
                else if ( (LA3_0==22) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:316:4: declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_sourceFile150);
            	    declaration1=declaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration1.getTree());
            	    if ( state.backtracking==0 ) {
            	       
            	      				for (Declaration d : (declaration1!=null?declaration1.declarations:null))
            	      					retval.sourceFile.addDeclaration(d); 
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:320:4: lineDirective
            	    {
            	    pushFollow(FOLLOW_lineDirective_in_sourceFile159);
            	    lineDirective2=lineDirective();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, lineDirective2.getTree());
            	    if ( state.backtracking==0 ) {

            	      				if (retval.sourceFile.getElementFile() == null)
            	      					retval.sourceFile.setElementFile(getFile());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_sourceFile172); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EOF3_tree = (Object)adaptor.create(EOF3);
            adaptor.addChild(root_0, EOF3_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            Symbols_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "sourceFile"

    public static class externDeclarations_return extends ParserRuleReturnScope {
        public ExternDeclarations declarations;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "externDeclarations"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:328:1: externDeclarations returns [ExternDeclarations declarations] : {...}? => IDENTIFIER STRING '{' (ed= declaration )* '}' ;
    public final ObjCppParser.externDeclarations_return externDeclarations() throws RecognitionException {
        ObjCppParser.externDeclarations_return retval = new ObjCppParser.externDeclarations_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER4=null;
        Token STRING5=null;
        Token char_literal6=null;
        Token char_literal7=null;
        ObjCppParser.declaration_return ed = null;


        Object IDENTIFIER4_tree=null;
        Object STRING5_tree=null;
        Object char_literal6_tree=null;
        Object char_literal7_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:329:2: ({...}? => IDENTIFIER STRING '{' (ed= declaration )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:329:4: {...}? => IDENTIFIER STRING '{' (ed= declaration )* '}'
            {
            root_0 = (Object)adaptor.nil();

            if ( !(( next("extern") )) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "externDeclarations", " next(\"extern\") ");
            }
            IDENTIFIER4=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_externDeclarations191); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER4_tree = (Object)adaptor.create(IDENTIFIER4);
            adaptor.addChild(root_0, IDENTIFIER4_tree);
            }
            STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_externDeclarations195); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING5_tree = (Object)adaptor.create(STRING5);
            adaptor.addChild(root_0, STRING5_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.declarations = mark(new ExternDeclarations(), getLine(STRING5));
              			retval.declarations.setLanguage((STRING5!=null?STRING5.getText():null));
              		
            }
            char_literal6=(Token)match(input,23,FOLLOW_23_in_externDeclarations201); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal6_tree = (Object)adaptor.create(char_literal6);
            adaptor.addChild(root_0, char_literal6_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:335:4: (ed= declaration )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==IDENTIFIER||(LA4_0>=25 && LA4_0<=27)||(LA4_0>=30 && LA4_0<=32)||LA4_0==34||(LA4_0>=48 && LA4_0<=51)||(LA4_0>=53 && LA4_0<=55)||(LA4_0>=58 && LA4_0<=60)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:336:5: ed= declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_externDeclarations215);
            	    ed=declaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ed.getTree());
            	    if ( state.backtracking==0 ) {
            	       
            	      					retval.declarations.addDeclarations((ed!=null?ed.declarations:null)); 
            	      				
            	    }

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            char_literal7=(Token)match(input,24,FOLLOW_24_in_externDeclarations228); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal7_tree = (Object)adaptor.create(char_literal7);
            adaptor.addChild(root_0, char_literal7_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "externDeclarations"

    public static class declaration_return extends ParserRuleReturnScope {
        public List<Declaration> declarations;
        public List<Modifier> modifiers;
        public String preComment;
        public int startTokenIndex;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declaration"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:343:1: declaration returns [List<Declaration> declarations, List<Modifier> modifiers, String preComment, int startTokenIndex] : ( ( functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) ) ;
    public final ObjCppParser.declaration_return declaration() throws RecognitionException {
        IsTypeDef_stack.push(new IsTypeDef_scope());

        ObjCppParser.declaration_return retval = new ObjCppParser.declaration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ns=null;
        Token char_literal11=null;
        Token string_literal15=null;
        Token char_literal16=null;
        Token char_literal17=null;
        ObjCppParser.declaration_return subD = null;

        ObjCppParser.functionDeclaration_return functionDeclaration8 = null;

        ObjCppParser.externDeclarations_return externDeclarations9 = null;

        ObjCppParser.varDecl_return varDecl10 = null;

        ObjCppParser.objCClassDef_return objCClassDef12 = null;

        ObjCppParser.typeDef_return typeDef13 = null;

        ObjCppParser.forwardClassDecl_return forwardClassDecl14 = null;


        Object ns_tree=null;
        Object char_literal11_tree=null;
        Object string_literal15_tree=null;
        Object char_literal16_tree=null;
        Object char_literal17_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:345:2: ( ( ( functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:346:3: ( ( functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.declarations = new ArrayList<Declaration>(); 
              		  retval.modifiers = new ArrayList<Modifier>();
              		  retval.startTokenIndex = getTokenStream().index();
              		  retval.preComment = getCommentBefore(retval.startTokenIndex);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:351:3: ( ( functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:352:4: ( functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:352:4: ( functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )
            int alt6=7;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:354:5: functionDeclaration
                    {
                    pushFollow(FOLLOW_functionDeclaration_in_declaration271);
                    functionDeclaration8=functionDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionDeclaration8.getTree());
                    if ( state.backtracking==0 ) {

                      					retval.declarations.add((functionDeclaration8!=null?functionDeclaration8.function:null));
                      				
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:357:5: externDeclarations
                    {
                    pushFollow(FOLLOW_externDeclarations_in_declaration281);
                    externDeclarations9=externDeclarations();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, externDeclarations9.getTree());
                    if ( state.backtracking==0 ) {

                      					retval.declarations.add((externDeclarations9!=null?externDeclarations9.declarations:null)); 
                      				
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:360:5: varDecl ';'
                    {
                    pushFollow(FOLLOW_varDecl_in_declaration291);
                    varDecl10=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl10.getTree());
                    char_literal11=(Token)match(input,25,FOLLOW_25_in_declaration293); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal11_tree = (Object)adaptor.create(char_literal11);
                    adaptor.addChild(root_0, char_literal11_tree);
                    }
                    if ( state.backtracking==0 ) {
                       
                      					retval.declarations.add((varDecl10!=null?varDecl10.decl:null)); 
                      				
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:363:5: objCClassDef
                    {
                    pushFollow(FOLLOW_objCClassDef_in_declaration303);
                    objCClassDef12=objCClassDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, objCClassDef12.getTree());
                    if ( state.backtracking==0 ) {
                       
                      					retval.declarations.add(decl((objCClassDef12!=null?objCClassDef12.struct:null))); 
                      				
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:366:5: typeDef
                    {
                    pushFollow(FOLLOW_typeDef_in_declaration313);
                    typeDef13=typeDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeDef13.getTree());
                    if ( state.backtracking==0 ) {

                      					retval.declarations.add((typeDef13!=null?typeDef13.typeDef:null)); 
                      				
                    }

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:369:5: forwardClassDecl
                    {
                    pushFollow(FOLLOW_forwardClassDecl_in_declaration323);
                    forwardClassDecl14=forwardClassDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, forwardClassDecl14.getTree());
                    if ( state.backtracking==0 ) {

                      					retval.declarations.addAll((forwardClassDecl14!=null?forwardClassDecl14.declarations:null)); 
                      				
                    }

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:372:5: 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}'
                    {
                    string_literal15=(Token)match(input,26,FOLLOW_26_in_declaration333); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal15_tree = (Object)adaptor.create(string_literal15);
                    adaptor.addChild(root_0, string_literal15_tree);
                    }
                    ns=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration337); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ns_tree = (Object)adaptor.create(ns);
                    adaptor.addChild(root_0, ns_tree);
                    }
                    char_literal16=(Token)match(input,23,FOLLOW_23_in_declaration339); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal16_tree = (Object)adaptor.create(char_literal16);
                    adaptor.addChild(root_0, char_literal16_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:373:6: (subD= declaration )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==IDENTIFIER||(LA5_0>=25 && LA5_0<=27)||(LA5_0>=30 && LA5_0<=32)||LA5_0==34||(LA5_0>=48 && LA5_0<=51)||(LA5_0>=53 && LA5_0<=55)||(LA5_0>=58 && LA5_0<=60)) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:374:7: subD= declaration
                    	    {
                    	    pushFollow(FOLLOW_declaration_in_declaration357);
                    	    subD=declaration();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, subD.getTree());
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      							for (Declaration d : (subD!=null?subD.declarations:null)) {
                    	      								d.addNameSpace((ns!=null?ns.getText():null));
                    	      								retval.declarations.add(d);
                    	      							}
                    	      						
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    char_literal17=(Token)match(input,24,FOLLOW_24_in_declaration373); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal17_tree = (Object)adaptor.create(char_literal17);
                    adaptor.addChild(root_0, char_literal17_tree);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              				String commentAfter = getCommentAfterOnSameLine(retval.startTokenIndex);
              				for (Declaration d  : retval.declarations) {
              					if (d == null)
              						continue;
              					d.setCommentBefore(retval.preComment);
              					d.setCommentAfter(commentAfter);
              					d.addModifiers(retval.modifiers);
              				}
              				
              			
            }

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            IsTypeDef_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "declaration"

    public static class forwardClassDecl_return extends ParserRuleReturnScope {
        public List<Declaration> declarations;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "forwardClassDecl"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:398:1: forwardClassDecl returns [List<Declaration> declarations] : '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';' ;
    public final ObjCppParser.forwardClassDecl_return forwardClassDecl() throws RecognitionException {
        ObjCppParser.forwardClassDecl_return retval = new ObjCppParser.forwardClassDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n1=null;
        Token nx=null;
        Token string_literal18=null;
        Token char_literal19=null;
        Token char_literal20=null;

        Object n1_tree=null;
        Object nx_tree=null;
        Object string_literal18_tree=null;
        Object char_literal19_tree=null;
        Object char_literal20_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:399:2: ( '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:399:5: '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.declarations = new ArrayList<Declaration>(); 
            }
            string_literal18=(Token)match(input,27,FOLLOW_27_in_forwardClassDecl413); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal18_tree = (Object)adaptor.create(string_literal18);
            adaptor.addChild(root_0, string_literal18_tree);
            }
            n1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_forwardClassDecl420); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n1_tree = (Object)adaptor.create(n1);
            adaptor.addChild(root_0, n1_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.declarations.add(decl(Struct.forwardDecl((n1!=null?n1.getText():null), Struct.Type.ObjCClass))); 
              			defineTypeIdentifierInParentScope((n1!=null?n1.getText():null));
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:405:3: ( ',' nx= IDENTIFIER )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==28) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:405:4: ',' nx= IDENTIFIER
            	    {
            	    char_literal19=(Token)match(input,28,FOLLOW_28_in_forwardClassDecl427); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal19_tree = (Object)adaptor.create(char_literal19);
            	    adaptor.addChild(root_0, char_literal19_tree);
            	    }
            	    nx=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_forwardClassDecl434); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    nx_tree = (Object)adaptor.create(nx);
            	    adaptor.addChild(root_0, nx_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      			retval.declarations.add(decl(Struct.forwardDecl((nx!=null?nx.getText():null), Struct.Type.ObjCClass))); 
            	      			defineTypeIdentifierInParentScope((nx!=null?nx.getText():null));
            	      		
            	    }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            char_literal20=(Token)match(input,25,FOLLOW_25_in_forwardClassDecl445); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal20_tree = (Object)adaptor.create(char_literal20);
            adaptor.addChild(root_0, char_literal20_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "forwardClassDecl"

    public static class functionPointerVarDecl_return extends ParserRuleReturnScope {
        public List<? extends Declaration> declarations;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionPointerVarDecl"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:414:1: functionPointerVarDecl returns [List<? extends Declaration> declarations] : tr= mutableTypeRef {...}? ';' ;
    public final ObjCppParser.functionPointerVarDecl_return functionPointerVarDecl() throws RecognitionException {
        ObjCppParser.functionPointerVarDecl_return retval = new ObjCppParser.functionPointerVarDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal21=null;
        ObjCppParser.mutableTypeRef_return tr = null;


        Object char_literal21_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:415:2: (tr= mutableTypeRef {...}? ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:415:4: tr= mutableTypeRef {...}? ';'
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_mutableTypeRef_in_functionPointerVarDecl465);
            tr=mutableTypeRef();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, tr.getTree());
            if ( !((
            			((tr!=null?tr.type:null) instanceof FunctionSignature) && 
            			((FunctionSignature)(tr!=null?tr.type:null)).getFunction().getName() != null
            		)) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "functionPointerVarDecl", "\n\t\t\t($tr.type instanceof FunctionSignature) && \n\t\t\t((FunctionSignature)$tr.type).getFunction().getName() != null\n\t\t");
            }
            if ( state.backtracking==0 ) {

              			retval.declarations = Arrays.asList(new FunctionPointerDeclaration(((FunctionSignature)(tr!=null?tr.type:null))));
              		
            }
            char_literal21=(Token)match(input,25,FOLLOW_25_in_functionPointerVarDecl473); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal21_tree = (Object)adaptor.create(char_literal21);
            adaptor.addChild(root_0, char_literal21_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionPointerVarDecl"

    public static class enumItem_return extends ParserRuleReturnScope {
        public Enum.EnumItem item;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "enumItem"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:424:1: enumItem returns [Enum.EnumItem item] : n= IDENTIFIER ( '=' v= topLevelExpr )? ;
    public final ObjCppParser.enumItem_return enumItem() throws RecognitionException {
        ObjCppParser.enumItem_return retval = new ObjCppParser.enumItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token char_literal22=null;
        ObjCppParser.topLevelExpr_return v = null;


        Object n_tree=null;
        Object char_literal22_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:425:2: (n= IDENTIFIER ( '=' v= topLevelExpr )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:425:4: n= IDENTIFIER ( '=' v= topLevelExpr )?
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumItem491); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:425:17: ( '=' v= topLevelExpr )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==29) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:425:18: '=' v= topLevelExpr
                    {
                    char_literal22=(Token)match(input,29,FOLLOW_29_in_enumItem494); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal22_tree = (Object)adaptor.create(char_literal22);
                    adaptor.addChild(root_0, char_literal22_tree);
                    }
                    pushFollow(FOLLOW_topLevelExpr_in_enumItem498);
                    v=topLevelExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			retval.item = mark(new Enum.EnumItem((n!=null?n.getText():null), (v!=null?input.toString(v.start,v.stop):null) == null ? null : (v!=null?v.expr:null)), getLine(n));
              			retval.item.setCommentBefore(getCommentBefore(n.getTokenIndex()));
              			retval.item.setCommentAfter(getCommentAfterOnSameLine(n.getTokenIndex() - 1));
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "enumItem"

    public static class enumBody_return extends ParserRuleReturnScope {
        public Enum e;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "enumBody"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:432:1: enumBody returns [Enum e] : '{' (i1= enumItem ( ',' (ix= enumItem )? )* )? '}' ;
    public final ObjCppParser.enumBody_return enumBody() throws RecognitionException {
        ObjCppParser.enumBody_return retval = new ObjCppParser.enumBody_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal23=null;
        Token char_literal24=null;
        Token char_literal25=null;
        ObjCppParser.enumItem_return i1 = null;

        ObjCppParser.enumItem_return ix = null;


        Object char_literal23_tree=null;
        Object char_literal24_tree=null;
        Object char_literal25_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:433:2: ( '{' (i1= enumItem ( ',' (ix= enumItem )? )* )? '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:434:3: '{' (i1= enumItem ( ',' (ix= enumItem )? )* )? '}'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               
              			retval.e = new Enum();
              			retval.e.setForwardDeclaration(false); 
              		
            }
            char_literal23=(Token)match(input,23,FOLLOW_23_in_enumBody524); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal23_tree = (Object)adaptor.create(char_literal23);
            adaptor.addChild(root_0, char_literal23_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:439:4: (i1= enumItem ( ',' (ix= enumItem )? )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==IDENTIFIER) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:440:5: i1= enumItem ( ',' (ix= enumItem )? )*
                    {
                    pushFollow(FOLLOW_enumItem_in_enumBody540);
                    i1=enumItem();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, i1.getTree());
                    if ( state.backtracking==0 ) {
                       
                      					if ((i1!=null?input.toString(i1.start,i1.stop):null) != null)
                      						retval.e.addItem((i1!=null?i1.item:null)); 
                      				
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:444:5: ( ',' (ix= enumItem )? )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==28) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:445:6: ',' (ix= enumItem )?
                    	    {
                    	    char_literal24=(Token)match(input,28,FOLLOW_28_in_enumBody555); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal24_tree = (Object)adaptor.create(char_literal24);
                    	    adaptor.addChild(root_0, char_literal24_tree);
                    	    }
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:446:6: (ix= enumItem )?
                    	    int alt9=2;
                    	    int LA9_0 = input.LA(1);

                    	    if ( (LA9_0==IDENTIFIER) ) {
                    	        alt9=1;
                    	    }
                    	    switch (alt9) {
                    	        case 1 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:446:7: ix= enumItem
                    	            {
                    	            pushFollow(FOLLOW_enumItem_in_enumBody566);
                    	            ix=enumItem();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) adaptor.addChild(root_0, ix.getTree());
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              						if ((ix!=null?input.toString(ix.start,ix.stop):null) != null)
                    	              							retval.e.addItem((ix!=null?ix.item:null)); 
                    	              					
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal25=(Token)match(input,24,FOLLOW_24_in_enumBody587); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal25_tree = (Object)adaptor.create(char_literal25);
            adaptor.addChild(root_0, char_literal25_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "enumBody"

    public static class enumCore_return extends ParserRuleReturnScope {
        public Enum e;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "enumCore"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:454:1: enumCore returns [Enum e] : t= 'enum' (m1= modifiers (ab= enumBody | tag= IDENTIFIER (m2= modifiers nb= enumBody | ) ) ) ;
    public final ObjCppParser.enumCore_return enumCore() throws RecognitionException {
        ObjCppParser.enumCore_return retval = new ObjCppParser.enumCore_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token t=null;
        Token tag=null;
        ObjCppParser.modifiers_return m1 = null;

        ObjCppParser.enumBody_return ab = null;

        ObjCppParser.modifiers_return m2 = null;

        ObjCppParser.enumBody_return nb = null;


        Object t_tree=null;
        Object tag_tree=null;


        	List<Modifier> modifiers = new ArrayList<Modifier>();

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:458:2: (t= 'enum' (m1= modifiers (ab= enumBody | tag= IDENTIFIER (m2= modifiers nb= enumBody | ) ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:459:3: t= 'enum' (m1= modifiers (ab= enumBody | tag= IDENTIFIER (m2= modifiers nb= enumBody | ) ) )
            {
            root_0 = (Object)adaptor.nil();

            t=(Token)match(input,30,FOLLOW_30_in_enumCore610); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            t_tree = (Object)adaptor.create(t);
            adaptor.addChild(root_0, t_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:460:3: (m1= modifiers (ab= enumBody | tag= IDENTIFIER (m2= modifiers nb= enumBody | ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:461:4: m1= modifiers (ab= enumBody | tag= IDENTIFIER (m2= modifiers nb= enumBody | ) )
            {
            pushFollow(FOLLOW_modifiers_in_enumCore621);
            m1=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, m1.getTree());
            if ( state.backtracking==0 ) {
               modifiers.addAll((m1!=null?m1.modifiers:null)); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:462:4: (ab= enumBody | tag= IDENTIFIER (m2= modifiers nb= enumBody | ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==23) ) {
                alt13=1;
            }
            else if ( (LA13_0==IDENTIFIER) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:463:5: ab= enumBody
                    {
                    pushFollow(FOLLOW_enumBody_in_enumCore636);
                    ab=enumBody();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ab.getTree());
                    if ( state.backtracking==0 ) {

                      					retval.e = (ab!=null?ab.e:null);
                      					retval.e.setForwardDeclaration(false);
                      				
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:467:5: tag= IDENTIFIER (m2= modifiers nb= enumBody | )
                    {
                    tag=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumCore648); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    tag_tree = (Object)adaptor.create(tag);
                    adaptor.addChild(root_0, tag_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:468:5: (m2= modifiers nb= enumBody | )
                    int alt12=2;
                    alt12 = dfa12.predict(input);
                    switch (alt12) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:469:6: m2= modifiers nb= enumBody
                            {
                            pushFollow(FOLLOW_modifiers_in_enumCore664);
                            m2=modifiers();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, m2.getTree());
                            if ( state.backtracking==0 ) {
                               modifiers.addAll((m2!=null?m2.modifiers:null)); 
                            }
                            pushFollow(FOLLOW_enumBody_in_enumCore675);
                            nb=enumBody();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, nb.getTree());
                            if ( state.backtracking==0 ) {

                              						retval.e = (nb!=null?nb.e:null);
                              						retval.e.setForwardDeclaration(false);
                              					
                            }

                            }
                            break;
                        case 2 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:473:10: 
                            {
                            if ( state.backtracking==0 ) {

                              						retval.e = new Enum();
                              						retval.e.setForwardDeclaration(true);
                              					
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      					retval.e.setTag((tag!=null?tag.getText():null));
                      				
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              			//retval.e.setCommentBefore(getCommentBefore(t.getTokenIndex()));
              			retval.e = mark(retval.e, getLine(t));
              			retval.e.addModifiers(modifiers);
              			defineTypeIdentifierInParentScope(retval.e.getTag());
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "enumCore"

    public static class objCClassDef_return extends ParserRuleReturnScope {
        public Struct struct;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "objCClassDef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:496:1: objCClassDef returns [Struct struct] : octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl ';' {...}?)* '@end' ;
    public final ObjCppParser.objCClassDef_return objCClassDef() throws RecognitionException {
        ObjCppParser.objCClassDef_return retval = new ObjCppParser.objCClassDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token octype=null;
        Token className=null;
        Token parentClass=null;
        Token categoryName=null;
        Token p1=null;
        Token px=null;
        Token bits=null;
        Token char_literal26=null;
        Token char_literal27=null;
        Token char_literal28=null;
        Token char_literal29=null;
        Token char_literal30=null;
        Token char_literal31=null;
        Token char_literal32=null;
        Token string_literal33=null;
        Token string_literal34=null;
        Token string_literal35=null;
        Token char_literal36=null;
        Token char_literal37=null;
        Token char_literal39=null;
        Token char_literal42=null;
        Token string_literal43=null;
        ObjCppParser.varDecl_return fv = null;

        ObjCppParser.varDecl_return vd = null;

        ObjCppParser.functionPointerVarDecl_return functionPointerVarDecl38 = null;

        ObjCppParser.objCMethodDecl_return objCMethodDecl40 = null;

        ObjCppParser.typeDef_return typeDef41 = null;


        Object octype_tree=null;
        Object className_tree=null;
        Object parentClass_tree=null;
        Object categoryName_tree=null;
        Object p1_tree=null;
        Object px_tree=null;
        Object bits_tree=null;
        Object char_literal26_tree=null;
        Object char_literal27_tree=null;
        Object char_literal28_tree=null;
        Object char_literal29_tree=null;
        Object char_literal30_tree=null;
        Object char_literal31_tree=null;
        Object char_literal32_tree=null;
        Object string_literal33_tree=null;
        Object string_literal34_tree=null;
        Object string_literal35_tree=null;
        Object char_literal36_tree=null;
        Object char_literal37_tree=null;
        Object char_literal39_tree=null;
        Object char_literal42_tree=null;
        Object string_literal43_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:497:2: (octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl ';' {...}?)* '@end' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:498:3: octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl ';' {...}?)* '@end'
            {
            root_0 = (Object)adaptor.nil();

            octype=(Token)input.LT(1);
            if ( (input.LA(1)>=31 && input.LA(1)<=32) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(octype));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            className=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef738); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            className_tree = (Object)adaptor.create(className);
            adaptor.addChild(root_0, className_tree);
            }
            if ( state.backtracking==0 ) {

              			defineTypeIdentifierInParentScope((className!=null?className.getText():null));
              			retval.struct = mark(new Struct(), getLine(octype));
              			//retval.struct.setCommentBefore(getCommentBefore(octype.getTokenIndex()));
              			retval.struct.setType((octype!=null?octype.getText():null).equals("@interface") ?
              				Struct.Type.ObjCClass :
              				Struct.Type.ObjCProtocol
              			);
              			retval.struct.setTag((className!=null?className.getText():null));
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:509:3: ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==IDENTIFIER||LA15_0==23||LA15_0==25||LA15_0==30||LA15_0==33||LA15_0==36||(LA15_0>=41 && LA15_0<=43)||(LA15_0>=48 && LA15_0<=50)||(LA15_0>=53 && LA15_0<=55)||(LA15_0>=58 && LA15_0<=60)) ) {
                alt15=1;
            }
            else if ( (LA15_0==34) ) {
                int LA15_2 = input.LA(2);

                if ( (LA15_2==IDENTIFIER) ) {
                    int LA15_3 = input.LA(3);

                    if ( (LA15_3==35) ) {
                        int LA15_4 = input.LA(4);

                        if ( (synpred22_ObjCpp()) ) {
                            alt15=1;
                        }
                        else if ( (true) ) {
                            alt15=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 15, 4, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA15_3>=STRING && LA15_3<=IDENTIFIER)||LA15_3==29||LA15_3==34||(LA15_3>=53 && LA15_3<=55)||LA15_3==58) ) {
                        alt15=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA15_2==34||(LA15_2>=53 && LA15_2<=54)||LA15_2==58) ) {
                    alt15=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:510:4: ( ':' parentClass= IDENTIFIER )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:510:4: ( ':' parentClass= IDENTIFIER )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==33) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:511:5: ':' parentClass= IDENTIFIER
                            {
                            char_literal26=(Token)match(input,33,FOLLOW_33_in_objCClassDef756); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal26_tree = (Object)adaptor.create(char_literal26);
                            adaptor.addChild(root_0, char_literal26_tree);
                            }
                            parentClass=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef760); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            parentClass_tree = (Object)adaptor.create(parentClass);
                            adaptor.addChild(root_0, parentClass_tree);
                            }
                            if ( state.backtracking==0 ) {

                              				if ((parentClass!=null?parentClass.getText():null) != null)
                              					retval.struct.addParent((parentClass!=null?parentClass.getText():null));
                              				
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:516:4: '(' categoryName= IDENTIFIER ')'
                    {
                    char_literal27=(Token)match(input,34,FOLLOW_34_in_objCClassDef775); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal27_tree = (Object)adaptor.create(char_literal27);
                    adaptor.addChild(root_0, char_literal27_tree);
                    }
                    categoryName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef779); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    categoryName_tree = (Object)adaptor.create(categoryName);
                    adaptor.addChild(root_0, categoryName_tree);
                    }
                    char_literal28=(Token)match(input,35,FOLLOW_35_in_objCClassDef781); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal28_tree = (Object)adaptor.create(char_literal28);
                    adaptor.addChild(root_0, char_literal28_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				retval.struct.setCategoryName((categoryName!=null?categoryName.getText():null));
                      			
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:520:3: ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==36) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:521:4: '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>'
                    {
                    char_literal29=(Token)match(input,36,FOLLOW_36_in_objCClassDef797); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal29_tree = (Object)adaptor.create(char_literal29);
                    adaptor.addChild(root_0, char_literal29_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:521:8: (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==IDENTIFIER) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:522:5: p1= IDENTIFIER ( ',' px= IDENTIFIER )*
                            {
                            p1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef807); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            p1_tree = (Object)adaptor.create(p1);
                            adaptor.addChild(root_0, p1_tree);
                            }
                            if ( state.backtracking==0 ) {
                               retval.struct.addProtocol((p1!=null?p1.getText():null)); 
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:523:5: ( ',' px= IDENTIFIER )*
                            loop16:
                            do {
                                int alt16=2;
                                int LA16_0 = input.LA(1);

                                if ( (LA16_0==28) ) {
                                    alt16=1;
                                }


                                switch (alt16) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:524:6: ',' px= IDENTIFIER
                            	    {
                            	    char_literal30=(Token)match(input,28,FOLLOW_28_in_objCClassDef822); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    char_literal30_tree = (Object)adaptor.create(char_literal30);
                            	    adaptor.addChild(root_0, char_literal30_tree);
                            	    }
                            	    px=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef832); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    px_tree = (Object)adaptor.create(px);
                            	    adaptor.addChild(root_0, px_tree);
                            	    }
                            	    if ( state.backtracking==0 ) {
                            	       retval.struct.addProtocol((px!=null?px.getText():null)); 
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop16;
                                }
                            } while (true);


                            }
                            break;

                    }

                    char_literal31=(Token)match(input,37,FOLLOW_37_in_objCClassDef849); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal31_tree = (Object)adaptor.create(char_literal31);
                    adaptor.addChild(root_0, char_literal31_tree);
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:529:3: ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) ) )* '}' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==23) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:530:4: '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) ) )* '}'
                    {
                    char_literal32=(Token)match(input,23,FOLLOW_23_in_objCClassDef863); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal32_tree = (Object)adaptor.create(char_literal32);
                    adaptor.addChild(root_0, char_literal32_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:531:4: ( '@public' | '@private' | '@protected' | ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) ) )*
                    loop21:
                    do {
                        int alt21=5;
                        switch ( input.LA(1) ) {
                        case 38:
                            {
                            alt21=1;
                            }
                            break;
                        case 39:
                            {
                            alt21=2;
                            }
                            break;
                        case 40:
                            {
                            alt21=3;
                            }
                            break;
                        case IDENTIFIER:
                        case 25:
                        case 30:
                        case 33:
                        case 34:
                        case 48:
                        case 49:
                        case 50:
                        case 53:
                        case 54:
                        case 55:
                        case 58:
                        case 60:
                            {
                            alt21=4;
                            }
                            break;

                        }

                        switch (alt21) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:532:5: '@public'
                    	    {
                    	    string_literal33=(Token)match(input,38,FOLLOW_38_in_objCClassDef875); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    string_literal33_tree = (Object)adaptor.create(string_literal33);
                    	    adaptor.addChild(root_0, string_literal33_tree);
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Public); 
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:533:5: '@private'
                    	    {
                    	    string_literal34=(Token)match(input,39,FOLLOW_39_in_objCClassDef886); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    string_literal34_tree = (Object)adaptor.create(string_literal34);
                    	    adaptor.addChild(root_0, string_literal34_tree);
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Private); 
                    	    }

                    	    }
                    	    break;
                    	case 3 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:534:5: '@protected'
                    	    {
                    	    string_literal35=(Token)match(input,40,FOLLOW_40_in_objCClassDef897); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    string_literal35_tree = (Object)adaptor.create(string_literal35);
                    	    adaptor.addChild(root_0, string_literal35_tree);
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Protected); 
                    	    }

                    	    }
                    	    break;
                    	case 4 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:535:5: ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) )
                    	    {
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:535:5: ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) )
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:536:6: (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl )
                    	    {
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:536:6: (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl )
                    	    int alt20=2;
                    	    alt20 = dfa20.predict(input);
                    	    switch (alt20) {
                    	        case 1 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:537:7: fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';'
                    	            {
                    	            pushFollow(FOLLOW_varDecl_in_objCClassDef924);
                    	            fv=varDecl();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) adaptor.addChild(root_0, fv.getTree());
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:537:18: ( ':' bits= DECIMAL_NUMBER )?
                    	            int alt19=2;
                    	            int LA19_0 = input.LA(1);

                    	            if ( (LA19_0==33) ) {
                    	                alt19=1;
                    	            }
                    	            switch (alt19) {
                    	                case 1 :
                    	                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:537:20: ':' bits= DECIMAL_NUMBER
                    	                    {
                    	                    char_literal36=(Token)match(input,33,FOLLOW_33_in_objCClassDef928); if (state.failed) return retval;
                    	                    if ( state.backtracking==0 ) {
                    	                    char_literal36_tree = (Object)adaptor.create(char_literal36);
                    	                    adaptor.addChild(root_0, char_literal36_tree);
                    	                    }
                    	                    bits=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_objCClassDef932); if (state.failed) return retval;
                    	                    if ( state.backtracking==0 ) {
                    	                    bits_tree = (Object)adaptor.create(bits);
                    	                    adaptor.addChild(root_0, bits_tree);
                    	                    }

                    	                    }
                    	                    break;

                    	            }

                    	            char_literal37=(Token)match(input,25,FOLLOW_25_in_objCClassDef937); if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) {
                    	            char_literal37_tree = (Object)adaptor.create(char_literal37);
                    	            adaptor.addChild(root_0, char_literal37_tree);
                    	            }
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              							//if ($bit.text != null) (fv!=null?fv.decl:null).setBits(Integer.parseInt((bits!=null?bits.getText():null)));
                    	              							retval.struct.addDeclaration((fv!=null?fv.decl:null));
                    	              						
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:541:7: functionPointerVarDecl
                    	            {
                    	            pushFollow(FOLLOW_functionPointerVarDecl_in_objCClassDef949);
                    	            functionPointerVarDecl38=functionPointerVarDecl();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) adaptor.addChild(root_0, functionPointerVarDecl38.getTree());
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              							retval.struct.addDeclarations((functionPointerVarDecl38!=null?functionPointerVarDecl38.declarations:null)); 
                    	              						
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    char_literal39=(Token)match(input,24,FOLLOW_24_in_objCClassDef976); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal39_tree = (Object)adaptor.create(char_literal39);
                    adaptor.addChild(root_0, char_literal39_tree);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Public); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:550:3: ( objCMethodDecl | typeDef | vd= varDecl ';' {...}?)*
            loop23:
            do {
                int alt23=4;
                switch ( input.LA(1) ) {
                case 42:
                case 43:
                    {
                    alt23=1;
                    }
                    break;
                case 59:
                    {
                    alt23=2;
                    }
                    break;
                case IDENTIFIER:
                case 25:
                case 30:
                case 34:
                case 48:
                case 49:
                case 50:
                case 53:
                case 54:
                case 55:
                case 58:
                case 60:
                    {
                    alt23=3;
                    }
                    break;

                }

                switch (alt23) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:551:4: objCMethodDecl
            	    {
            	    pushFollow(FOLLOW_objCMethodDecl_in_objCClassDef994);
            	    objCMethodDecl40=objCMethodDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, objCMethodDecl40.getTree());
            	    if ( state.backtracking==0 ) {
            	       
            	      				retval.struct.addDeclaration((objCMethodDecl40!=null?objCMethodDecl40.function:null)); 
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:554:4: typeDef
            	    {
            	    pushFollow(FOLLOW_typeDef_in_objCClassDef1003);
            	    typeDef41=typeDef();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeDef41.getTree());
            	    if ( state.backtracking==0 ) {

            	      				retval.struct.addDeclaration((typeDef41!=null?typeDef41.typeDef:null)); 
            	      			
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:557:4: vd= varDecl ';' {...}?
            	    {
            	    pushFollow(FOLLOW_varDecl_in_objCClassDef1014);
            	    vd=varDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, vd.getTree());
            	    char_literal42=(Token)match(input,25,FOLLOW_25_in_objCClassDef1016); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal42_tree = (Object)adaptor.create(char_literal42);
            	    adaptor.addChild(root_0, char_literal42_tree);
            	    }
            	    if ( !(( !((vd!=null?vd.decl:null) instanceof VariablesDeclaration) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "objCClassDef", " !($vd.decl instanceof VariablesDeclaration) ");
            	    }
            	    if ( state.backtracking==0 ) {

            	      				retval.struct.addDeclaration((vd!=null?vd.decl:null));
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            string_literal43=(Token)match(input,41,FOLLOW_41_in_objCClassDef1029); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal43_tree = (Object)adaptor.create(string_literal43);
            adaptor.addChild(root_0, string_literal43_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "objCClassDef"

    public static class objCMethodDecl_return extends ParserRuleReturnScope {
        public Function function;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "objCMethodDecl"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:564:1: objCMethodDecl returns [Function function] : tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= mutableTypeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= mutableTypeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';' ;
    public final ObjCppParser.objCMethodDecl_return objCMethodDecl() throws RecognitionException {
        ObjCppParser.objCMethodDecl_return retval = new ObjCppParser.objCMethodDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token tp=null;
        Token tm=null;
        Token tk=null;
        Token methodName=null;
        Token argName1=null;
        Token sel=null;
        Token argName=null;
        Token char_literal44=null;
        Token char_literal45=null;
        Token char_literal46=null;
        Token char_literal47=null;
        Token char_literal48=null;
        Token char_literal49=null;
        Token char_literal50=null;
        Token char_literal51=null;
        Token char_literal52=null;
        Token string_literal53=null;
        Token char_literal54=null;
        ObjCppParser.mutableTypeRef_return returnTypeRef = null;

        ObjCppParser.mutableTypeRef_return argType1 = null;

        ObjCppParser.mutableTypeRef_return argType = null;


        Object tp_tree=null;
        Object tm_tree=null;
        Object tk_tree=null;
        Object methodName_tree=null;
        Object argName1_tree=null;
        Object sel_tree=null;
        Object argName_tree=null;
        Object char_literal44_tree=null;
        Object char_literal45_tree=null;
        Object char_literal46_tree=null;
        Object char_literal47_tree=null;
        Object char_literal48_tree=null;
        Object char_literal49_tree=null;
        Object char_literal50_tree=null;
        Object char_literal51_tree=null;
        Object char_literal52_tree=null;
        Object string_literal53_tree=null;
        Object char_literal54_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:565:2: (tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= mutableTypeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= mutableTypeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:565:4: tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= mutableTypeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= mutableTypeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               	
              			retval.function = new Function(); 
              			retval.function.setType(Function.Type.ObjCMethod);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:569:6: (tp= '+' | tm= '-' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==42) ) {
                alt24=1;
            }
            else if ( (LA24_0==43) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:570:4: tp= '+'
                    {
                    tp=(Token)match(input,42,FOLLOW_42_in_objCMethodDecl1063); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    tp_tree = (Object)adaptor.create(tp);
                    adaptor.addChild(root_0, tp_tree);
                    }
                    if ( state.backtracking==0 ) {
                       
                      				retval.function.addModifiers(Modifier.Static); 
                      				retval.function = mark(retval.function, getLine(tp)); 
                      				retval.function.setCommentBefore(getCommentBefore(tp.getTokenIndex()));
                      			
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:575:4: tm= '-'
                    {
                    tm=(Token)match(input,43,FOLLOW_43_in_objCMethodDecl1075); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    tm_tree = (Object)adaptor.create(tm);
                    adaptor.addChild(root_0, tm_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				retval.function = mark(retval.function, getLine(tm)); 
                      				retval.function.setCommentBefore(getCommentBefore(tm.getTokenIndex()));
                      			
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:580:3: ( '(' (returnTypeRef= mutableTypeRef )? ')' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==34) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:582:4: '(' (returnTypeRef= mutableTypeRef )? ')'
                    {
                    char_literal44=(Token)match(input,34,FOLLOW_34_in_objCMethodDecl1094); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal44_tree = (Object)adaptor.create(char_literal44);
                    adaptor.addChild(root_0, char_literal44_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:583:18: (returnTypeRef= mutableTypeRef )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==IDENTIFIER||LA25_0==30||LA25_0==34||(LA25_0>=48 && LA25_0<=50)||(LA25_0>=53 && LA25_0<=55)||LA25_0==60) ) {
                        alt25=1;
                    }
                    else if ( (LA25_0==35) ) {
                        int LA25_2 = input.LA(2);

                        if ( (synpred37_ObjCpp()) ) {
                            alt25=1;
                        }
                    }
                    switch (alt25) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: returnTypeRef= mutableTypeRef
                            {
                            pushFollow(FOLLOW_mutableTypeRef_in_objCMethodDecl1102);
                            returnTypeRef=mutableTypeRef();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, returnTypeRef.getTree());

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       
                      					retval.function.setValueType((returnTypeRef!=null?returnTypeRef.type:null)); 
                      				
                    }
                    char_literal45=(Token)match(input,35,FOLLOW_35_in_objCMethodDecl1110); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal45_tree = (Object)adaptor.create(char_literal45);
                    adaptor.addChild(root_0, char_literal45_tree);
                    }

                    }
                    break;

            }

            methodName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1121); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            methodName_tree = (Object)adaptor.create(methodName);
            adaptor.addChild(root_0, methodName_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.function.setName((methodName!=null?methodName.getText():null)); 
              			retval.function.setCommentAfter(getCommentAfterOnSameLine(methodName.getTokenIndex()));
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:592:3: ( ':' '(' argType1= mutableTypeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==33) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:593:4: ':' '(' argType1= mutableTypeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )* ( ',' '...' )?
                    {
                    char_literal46=(Token)match(input,33,FOLLOW_33_in_objCMethodDecl1133); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal46_tree = (Object)adaptor.create(char_literal46);
                    adaptor.addChild(root_0, char_literal46_tree);
                    }
                    char_literal47=(Token)match(input,34,FOLLOW_34_in_objCMethodDecl1135); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal47_tree = (Object)adaptor.create(char_literal47);
                    adaptor.addChild(root_0, char_literal47_tree);
                    }
                    pushFollow(FOLLOW_mutableTypeRef_in_objCMethodDecl1139);
                    argType1=mutableTypeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, argType1.getTree());
                    char_literal48=(Token)match(input,35,FOLLOW_35_in_objCMethodDecl1141); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal48_tree = (Object)adaptor.create(char_literal48);
                    adaptor.addChild(root_0, char_literal48_tree);
                    }
                    argName1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1145); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    argName1_tree = (Object)adaptor.create(argName1);
                    adaptor.addChild(root_0, argName1_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				Arg arg = new Arg((argName1!=null?argName1.getText():null), (argType1!=null?argType1.type:null));
                      				arg.setSelector((methodName!=null?methodName.getText():null));
                      				retval.function.addArg(arg);
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:598:4: (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==IDENTIFIER) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:599:5: sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER
                    	    {
                    	    sel=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1160); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    sel_tree = (Object)adaptor.create(sel);
                    	    adaptor.addChild(root_0, sel_tree);
                    	    }
                    	    char_literal49=(Token)match(input,33,FOLLOW_33_in_objCMethodDecl1162); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal49_tree = (Object)adaptor.create(char_literal49);
                    	    adaptor.addChild(root_0, char_literal49_tree);
                    	    }
                    	    char_literal50=(Token)match(input,34,FOLLOW_34_in_objCMethodDecl1169); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal50_tree = (Object)adaptor.create(char_literal50);
                    	    adaptor.addChild(root_0, char_literal50_tree);
                    	    }
                    	    pushFollow(FOLLOW_mutableTypeRef_in_objCMethodDecl1173);
                    	    argType=mutableTypeRef();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, argType.getTree());
                    	    char_literal51=(Token)match(input,35,FOLLOW_35_in_objCMethodDecl1175); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal51_tree = (Object)adaptor.create(char_literal51);
                    	    adaptor.addChild(root_0, char_literal51_tree);
                    	    }
                    	    argName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1184); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    argName_tree = (Object)adaptor.create(argName);
                    	    adaptor.addChild(root_0, argName_tree);
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					Arg arg = new Arg((argName!=null?argName.getText():null), (argType!=null?argType.type:null));
                    	      					arg.setSelector((sel!=null?sel.getText():null));
                    	      					retval.function.addArg(arg);
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:607:4: ( ',' '...' )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==28) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:608:5: ',' '...'
                            {
                            char_literal52=(Token)match(input,28,FOLLOW_28_in_objCMethodDecl1203); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal52_tree = (Object)adaptor.create(char_literal52);
                            adaptor.addChild(root_0, char_literal52_tree);
                            }
                            string_literal53=(Token)match(input,44,FOLLOW_44_in_objCMethodDecl1205); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal53_tree = (Object)adaptor.create(string_literal53);
                            adaptor.addChild(root_0, string_literal53_tree);
                            }
                            if ( state.backtracking==0 ) {

                              					retval.function.addArg(Arg.createVarArgs());
                              				
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            char_literal54=(Token)match(input,25,FOLLOW_25_in_objCMethodDecl1222); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal54_tree = (Object)adaptor.create(char_literal54);
            adaptor.addChild(root_0, char_literal54_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "objCMethodDecl"

    public static class structBody_return extends ParserRuleReturnScope {
        public Struct struct;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "structBody"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:616:1: structBody returns [Struct struct] : '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' ;
    public final ObjCppParser.structBody_return structBody() throws RecognitionException {
        ObjCppParser.structBody_return retval = new ObjCppParser.structBody_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal55=null;
        Token string_literal56=null;
        Token string_literal57=null;
        Token string_literal58=null;
        Token char_literal59=null;
        Token char_literal61=null;
        ObjCppParser.declaration_return declaration60 = null;


        Object char_literal55_tree=null;
        Object string_literal56_tree=null;
        Object string_literal57_tree=null;
        Object string_literal58_tree=null;
        Object char_literal59_tree=null;
        Object char_literal61_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:617:2: ( '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:618:3: '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               
              			retval.struct = new Struct();
              			retval.struct.setForwardDeclaration(false); 
              		
            }
            char_literal55=(Token)match(input,23,FOLLOW_23_in_structBody1243); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal55_tree = (Object)adaptor.create(char_literal55);
            adaptor.addChild(root_0, char_literal55_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:623:4: ( ( 'public' | 'private' | 'protected' ) ':' | declaration )*
            loop31:
            do {
                int alt31=3;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=45 && LA31_0<=47)) ) {
                    alt31=1;
                }
                else if ( (LA31_0==IDENTIFIER||(LA31_0>=25 && LA31_0<=27)||(LA31_0>=30 && LA31_0<=32)||LA31_0==34||(LA31_0>=48 && LA31_0<=51)||(LA31_0>=53 && LA31_0<=55)||(LA31_0>=58 && LA31_0<=60)) ) {
                    alt31=2;
                }


                switch (alt31) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:624:5: ( 'public' | 'private' | 'protected' ) ':'
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:624:5: ( 'public' | 'private' | 'protected' )
            	    int alt30=3;
            	    switch ( input.LA(1) ) {
            	    case 45:
            	        {
            	        alt30=1;
            	        }
            	        break;
            	    case 46:
            	        {
            	        alt30=2;
            	        }
            	        break;
            	    case 47:
            	        {
            	        alt30=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 30, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt30) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:625:6: 'public'
            	            {
            	            string_literal56=(Token)match(input,45,FOLLOW_45_in_structBody1261); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal56_tree = (Object)adaptor.create(string_literal56);
            	            adaptor.addChild(root_0, string_literal56_tree);
            	            }
            	            if ( state.backtracking==0 ) {
            	               retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Public); 
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:626:6: 'private'
            	            {
            	            string_literal57=(Token)match(input,46,FOLLOW_46_in_structBody1273); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal57_tree = (Object)adaptor.create(string_literal57);
            	            adaptor.addChild(root_0, string_literal57_tree);
            	            }
            	            if ( state.backtracking==0 ) {
            	               retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Private); 
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:627:6: 'protected'
            	            {
            	            string_literal58=(Token)match(input,47,FOLLOW_47_in_structBody1285); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal58_tree = (Object)adaptor.create(string_literal58);
            	            adaptor.addChild(root_0, string_literal58_tree);
            	            }
            	            if ( state.backtracking==0 ) {
            	               retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Protected); 
            	            }

            	            }
            	            break;

            	    }

            	    char_literal59=(Token)match(input,33,FOLLOW_33_in_structBody1296); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal59_tree = (Object)adaptor.create(char_literal59);
            	    adaptor.addChild(root_0, char_literal59_tree);
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:629:5: declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_structBody1304);
            	    declaration60=declaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration60.getTree());
            	    if ( state.backtracking==0 ) {

            	      					retval.struct.addDeclarations((declaration60!=null?declaration60.declarations:null));
            	      				
            	    }

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            char_literal61=(Token)match(input,24,FOLLOW_24_in_structBody1316); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal61_tree = (Object)adaptor.create(char_literal61);
            adaptor.addChild(root_0, char_literal61_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "structBody"

    public static class structCore_return extends ParserRuleReturnScope {
        public Struct struct;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "structCore"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:636:1: structCore returns [Struct struct] : typeToken= ( 'struct' | 'class' | 'union' ) (m1= modifiers (ab= structBody | tag= IDENTIFIER ( (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody ) | ) ) ) ;
    public final ObjCppParser.structCore_return structCore() throws RecognitionException {
        Symbols_stack.push(new Symbols_scope());

        ObjCppParser.structCore_return retval = new ObjCppParser.structCore_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token typeToken=null;
        Token tag=null;
        Token parent=null;
        Token char_literal62=null;
        Token string_literal63=null;
        ObjCppParser.modifiers_return m1 = null;

        ObjCppParser.structBody_return ab = null;

        ObjCppParser.modifiers_return m2 = null;

        ObjCppParser.structBody_return nb = null;


        Object typeToken_tree=null;
        Object tag_tree=null;
        Object parent_tree=null;
        Object char_literal62_tree=null;
        Object string_literal63_tree=null;


        	((Symbols_scope)Symbols_stack.peek()).typeIdentifiers = new HashSet<String>();
        	List<Modifier> modifiers = new ArrayList<Modifier>();

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:642:2: (typeToken= ( 'struct' | 'class' | 'union' ) (m1= modifiers (ab= structBody | tag= IDENTIFIER ( (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody ) | ) ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:643:3: typeToken= ( 'struct' | 'class' | 'union' ) (m1= modifiers (ab= structBody | tag= IDENTIFIER ( (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody ) | ) ) )
            {
            root_0 = (Object)adaptor.nil();

            typeToken=(Token)input.LT(1);
            if ( (input.LA(1)>=48 && input.LA(1)<=50) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(typeToken));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:644:3: (m1= modifiers (ab= structBody | tag= IDENTIFIER ( (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody ) | ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:645:4: m1= modifiers (ab= structBody | tag= IDENTIFIER ( (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody ) | ) )
            {
            pushFollow(FOLLOW_modifiers_in_structCore1373);
            m1=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, m1.getTree());
            if ( state.backtracking==0 ) {
               modifiers.addAll((m1!=null?m1.modifiers:null)); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:646:4: (ab= structBody | tag= IDENTIFIER ( (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody ) | ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==23) ) {
                alt35=1;
            }
            else if ( (LA35_0==IDENTIFIER) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:647:5: ab= structBody
                    {
                    pushFollow(FOLLOW_structBody_in_structCore1388);
                    ab=structBody();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ab.getTree());
                    if ( state.backtracking==0 ) {

                      					retval.struct = (ab!=null?ab.struct:null);
                      					retval.struct.setForwardDeclaration(false);
                      				
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:651:5: tag= IDENTIFIER ( (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody ) | )
                    {
                    tag=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_structCore1400); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    tag_tree = (Object)adaptor.create(tag);
                    adaptor.addChild(root_0, tag_tree);
                    }
                    if ( state.backtracking==0 ) {

                      					defineTypeIdentifierInParentScope((tag!=null?tag.getText():null));
                      				
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:654:5: ( (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody ) | )
                    int alt34=2;
                    alt34 = dfa34.predict(input);
                    switch (alt34) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:655:6: (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody )
                            {
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:655:6: (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody )
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:656:7: m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody
                            {
                            pushFollow(FOLLOW_modifiers_in_structCore1425);
                            m2=modifiers();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, m2.getTree());
                            if ( state.backtracking==0 ) {
                               modifiers.addAll((m2!=null?m2.modifiers:null)); 
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:657:7: ( ':' ( 'public' )? parent= IDENTIFIER )?
                            int alt33=2;
                            int LA33_0 = input.LA(1);

                            if ( (LA33_0==33) ) {
                                alt33=1;
                            }
                            switch (alt33) {
                                case 1 :
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:658:8: ':' ( 'public' )? parent= IDENTIFIER
                                    {
                                    char_literal62=(Token)match(input,33,FOLLOW_33_in_structCore1444); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    char_literal62_tree = (Object)adaptor.create(char_literal62);
                                    adaptor.addChild(root_0, char_literal62_tree);
                                    }
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:659:8: ( 'public' )?
                                    int alt32=2;
                                    int LA32_0 = input.LA(1);

                                    if ( (LA32_0==45) ) {
                                        alt32=1;
                                    }
                                    switch (alt32) {
                                        case 1 :
                                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: 'public'
                                            {
                                            string_literal63=(Token)match(input,45,FOLLOW_45_in_structCore1453); if (state.failed) return retval;
                                            if ( state.backtracking==0 ) {
                                            string_literal63_tree = (Object)adaptor.create(string_literal63);
                                            adaptor.addChild(root_0, string_literal63_tree);
                                            }

                                            }
                                            break;

                                    }

                                    parent=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_structCore1465); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    parent_tree = (Object)adaptor.create(parent);
                                    adaptor.addChild(root_0, parent_tree);
                                    }

                                    }
                                    break;

                            }

                            pushFollow(FOLLOW_structBody_in_structCore1485);
                            nb=structBody();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, nb.getTree());
                            if ( state.backtracking==0 ) {

                              							retval.struct = (nb!=null?nb.struct:null);
                              							retval.struct.setForwardDeclaration(false);
                              							if ((parent!=null?parent.getText():null) != null)
                              								retval.struct.addParent((parent!=null?parent.getText():null));
                              						
                            }

                            }


                            }
                            break;
                        case 2 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:668:10: 
                            {
                            if ( state.backtracking==0 ) {

                              						retval.struct = new Struct();
                              						retval.struct.setForwardDeclaration(true);
                              					
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      					retval.struct.setTag((tag!=null?tag.getText():null));
                      				
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              			//retval.struct.setCommentBefore(getCommentBefore(typeToken.getTokenIndex()));
              			retval.struct = mark(retval.struct, getLine(typeToken)); 
              			retval.struct.setType(
              				(typeToken!=null?typeToken.getText():null).equals("struct") ?	Struct.Type.CStruct :
              				(typeToken!=null?typeToken.getText():null).equals("union") ?	Struct.Type.CUnion :
              								Struct.Type.CPPClass
              			);
              			//retval.struct.setForwardDeclaration(true); // until proven wrong
              			
              			Function.Type forcedType = null;
              			if (retval.struct.getType() == Struct.Type.CPPClass)
              				forcedType = Function.Type.CppMethod;
              			
              			if (forcedType != null)
              			for (Declaration d : retval.struct.getDeclarations()) {
              				if (d instanceof Function)
              					((Function)d).setType(forcedType);
              			}
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            Symbols_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "structCore"

    public static class anyOp_return extends ParserRuleReturnScope {
        public java.lang.Enum<?> op;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "anyOp"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:698:1: anyOp returns [java.lang.Enum<?> op] : ( binaryOp | unaryOp | assignmentOp );
    public final ObjCppParser.anyOp_return anyOp() throws RecognitionException {
        ObjCppParser.anyOp_return retval = new ObjCppParser.anyOp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.binaryOp_return binaryOp64 = null;

        ObjCppParser.unaryOp_return unaryOp65 = null;

        ObjCppParser.assignmentOp_return assignmentOp66 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:699:2: ( binaryOp | unaryOp | assignmentOp )
            int alt36=3;
            switch ( input.LA(1) ) {
            case 43:
            case 53:
            case 54:
                {
                int LA36_1 = input.LA(2);

                if ( (synpred52_ObjCpp()) ) {
                    alt36=1;
                }
                else if ( (synpred53_ObjCpp()) ) {
                    alt36=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 1, input);

                    throw nvae;
                }
                }
                break;
            case 36:
            case 37:
            case 42:
            case 58:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
                {
                alt36=1;
                }
                break;
            case 51:
            case 87:
            case 88:
            case 89:
                {
                alt36=2;
                }
                break;
            case 29:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
                {
                alt36=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:699:4: binaryOp
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_binaryOp_in_anyOp1534);
                    binaryOp64=binaryOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, binaryOp64.getTree());
                    if ( state.backtracking==0 ) {
                       retval.op = (binaryOp64!=null?binaryOp64.op:null); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:700:3: unaryOp
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_unaryOp_in_anyOp1543);
                    unaryOp65=unaryOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryOp65.getTree());
                    if ( state.backtracking==0 ) {
                       retval.op = (unaryOp65!=null?unaryOp65.op:null); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:701:3: assignmentOp
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_assignmentOp_in_anyOp1552);
                    assignmentOp66=assignmentOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentOp66.getTree());
                    if ( state.backtracking==0 ) {
                       retval.op = (assignmentOp66!=null?assignmentOp66.op:null); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "anyOp"

    public static class functionName_return extends ParserRuleReturnScope {
        public String name;
        public String file;
        public int line;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionName"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:704:1: functionName returns [String name, String file, int line] : (pre= '~' )? n= IDENTIFIER ( anyOp )? ;
    public final ObjCppParser.functionName_return functionName() throws RecognitionException {
        ObjCppParser.functionName_return retval = new ObjCppParser.functionName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token pre=null;
        Token n=null;
        ObjCppParser.anyOp_return anyOp67 = null;


        Object pre_tree=null;
        Object n_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:705:2: ( (pre= '~' )? n= IDENTIFIER ( anyOp )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:706:3: (pre= '~' )? n= IDENTIFIER ( anyOp )?
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:706:6: (pre= '~' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==51) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: pre= '~'
                    {
                    pre=(Token)match(input,51,FOLLOW_51_in_functionName1574); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    pre_tree = (Object)adaptor.create(pre);
                    adaptor.addChild(root_0, pre_tree);
                    }

                    }
                    break;

            }

            n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionName1579); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:706:25: ( anyOp )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==29||(LA38_0>=36 && LA38_0<=37)||(LA38_0>=42 && LA38_0<=43)||LA38_0==51||(LA38_0>=53 && LA38_0<=54)||LA38_0==58||(LA38_0>=61 && LA38_0<=72)||(LA38_0>=75 && LA38_0<=84)||(LA38_0>=87 && LA38_0<=89)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: anyOp
                    {
                    pushFollow(FOLLOW_anyOp_in_functionName1581);
                    anyOp67=anyOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, anyOp67.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               
              			retval.name = (n!=null?n.getText():null);
              			if ((pre!=null?pre.getText():null) != null)
              				retval.name = (pre!=null?pre.getText():null) + retval.name;
              			if ((anyOp67!=null?input.toString(anyOp67.start,anyOp67.stop):null) != null)
              				retval.name += (anyOp67!=null?input.toString(anyOp67.start,anyOp67.stop):null);
              			retval.file = getFile();
              			retval.line = getLine(n);
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionName"

    public static class functionDeclaration_return extends ParserRuleReturnScope {
        public Function function;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionDeclaration"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:728:1: functionDeclaration returns [Function function] : preMods1= modifiers (returnTypeRef= mutableTypeRef )? preMods2= modifiers functionName argList ({...}? => (ct= IDENTIFIER ) | ) postMods= modifiers ( ';' | statementsBlock ) ;
    public final ObjCppParser.functionDeclaration_return functionDeclaration() throws RecognitionException {
        Symbols_stack.push(new Symbols_scope());

        ObjCppParser.functionDeclaration_return retval = new ObjCppParser.functionDeclaration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ct=null;
        Token char_literal70=null;
        ObjCppParser.modifiers_return preMods1 = null;

        ObjCppParser.mutableTypeRef_return returnTypeRef = null;

        ObjCppParser.modifiers_return preMods2 = null;

        ObjCppParser.modifiers_return postMods = null;

        ObjCppParser.functionName_return functionName68 = null;

        ObjCppParser.argList_return argList69 = null;

        ObjCppParser.statementsBlock_return statementsBlock71 = null;


        Object ct_tree=null;
        Object char_literal70_tree=null;


        	((Symbols_scope)Symbols_stack.peek()).typeIdentifiers = new HashSet<String>();

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:733:2: (preMods1= modifiers (returnTypeRef= mutableTypeRef )? preMods2= modifiers functionName argList ({...}? => (ct= IDENTIFIER ) | ) postMods= modifiers ( ';' | statementsBlock ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:733:4: preMods1= modifiers (returnTypeRef= mutableTypeRef )? preMods2= modifiers functionName argList ({...}? => (ct= IDENTIFIER ) | ) postMods= modifiers ( ';' | statementsBlock )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               	
              			retval.function = mark(new Function(), -1);
              			retval.function.setType(Function.Type.CFunction);
              		
            }
            pushFollow(FOLLOW_modifiers_in_functionDeclaration1622);
            preMods1=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, preMods1.getTree());
            if ( state.backtracking==0 ) {
               retval.function.addModifiers((preMods1!=null?preMods1.modifiers:null)); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:738:16: (returnTypeRef= mutableTypeRef )?
            int alt39=2;
            switch ( input.LA(1) ) {
                case IDENTIFIER:
                    {
                    int LA39_1 = input.LA(2);

                    if ( (((synpred56_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||synpred56_ObjCpp()||(synpred56_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred56_ObjCpp()&&( next("extern") ))||(synpred56_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred56_ObjCpp()&&( next("__success") )))) ) {
                        alt39=1;
                    }
                    }
                    break;
                case 30:
                case 34:
                case 48:
                case 49:
                case 50:
                case 53:
                case 54:
                case 55:
                case 60:
                    {
                    alt39=1;
                    }
                    break;
                case 51:
                    {
                    int LA39_3 = input.LA(2);

                    if ( (synpred56_ObjCpp()) ) {
                        alt39=1;
                    }
                    }
                    break;
            }

            switch (alt39) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: returnTypeRef= mutableTypeRef
                    {
                    pushFollow(FOLLOW_mutableTypeRef_in_functionDeclaration1630);
                    returnTypeRef=mutableTypeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnTypeRef.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               
              			retval.function.setValueType((returnTypeRef!=null?returnTypeRef.type:null)); 
              		
            }
            pushFollow(FOLLOW_modifiers_in_functionDeclaration1639);
            preMods2=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, preMods2.getTree());
            if ( state.backtracking==0 ) {
               retval.function.addModifiers((preMods2!=null?preMods2.modifiers:null)); 
            }
            pushFollow(FOLLOW_functionName_in_functionDeclaration1645);
            functionName68=functionName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, functionName68.getTree());
            if ( state.backtracking==0 ) {

              			retval.function.setName((functionName68!=null?functionName68.name:null)); 
              			retval.function.setElementFile((functionName68!=null?functionName68.file:null));
              			retval.function.setElementLine((functionName68!=null?functionName68.line:0));
              		
            }
            pushFollow(FOLLOW_argList_in_functionDeclaration1651);
            argList69=argList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, argList69.getTree());
            if ( state.backtracking==0 ) {

              			retval.function.setArgs((argList69!=null?argList69.args:null));
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:750:3: ({...}? => (ct= IDENTIFIER ) | )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==IDENTIFIER) ) {
                int LA40_1 = input.LA(2);

                if ( ((synpred57_ObjCpp()&&( next("const", "__const") ))) ) {
                    alt40=1;
                }
                else if ( ((( Modifier.parseModifier(next()) != null )||( next("extern") )||( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) )||( next("__success") )||( next("__declspec", "__attribute__", "__asm") ))) ) {
                    alt40=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA40_0==23||LA40_0==25) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:750:4: {...}? => (ct= IDENTIFIER )
                    {
                    if ( !(( next("const", "__const") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "functionDeclaration", " next(\"const\", \"__const\") ");
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:750:36: (ct= IDENTIFIER )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:750:37: ct= IDENTIFIER
                    {
                    ct=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionDeclaration1664); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ct_tree = (Object)adaptor.create(ct);
                    adaptor.addChild(root_0, ct_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			if ((ct!=null?ct.getText():null) != null)
                      				retval.function.addModifiers(Modifier.Const);
                      		
                    }

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:753:8: 
                    {
                    }
                    break;

            }

            pushFollow(FOLLOW_modifiers_in_functionDeclaration1677);
            postMods=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, postMods.getTree());
            if ( state.backtracking==0 ) {

              			for (Modifier m : (postMods!=null?postMods.modifiers:null))
              				retval.function.addModifiers(m);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:758:3: ( ';' | statementsBlock )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==25) ) {
                alt41=1;
            }
            else if ( (LA41_0==23) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:759:4: ';'
                    {
                    char_literal70=(Token)match(input,25,FOLLOW_25_in_functionDeclaration1689); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal70_tree = (Object)adaptor.create(char_literal70);
                    adaptor.addChild(root_0, char_literal70_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:760:4: statementsBlock
                    {
                    pushFollow(FOLLOW_statementsBlock_in_functionDeclaration1696);
                    statementsBlock71=statementsBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementsBlock71.getTree());
                    if ( state.backtracking==0 ) {

                      				retval.function.setBody((statementsBlock71!=null?statementsBlock71.stat:null));
                      			
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            Symbols_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "functionDeclaration"

    public static class modifiers_return extends ParserRuleReturnScope {
        public List<Modifier> modifiers;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "modifiers"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:766:1: modifiers returns [List<Modifier> modifiers] : ( modifier )* ;
    public final ObjCppParser.modifiers_return modifiers() throws RecognitionException {
        ObjCppParser.modifiers_return retval = new ObjCppParser.modifiers_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.modifier_return modifier72 = null;



         retval.modifiers = new ArrayList<Modifier>(); 
        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:768:2: ( ( modifier )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:768:5: ( modifier )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:768:5: ( modifier )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==IDENTIFIER) ) {
                    int LA42_2 = input.LA(2);

                    if ( (((synpred59_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred59_ObjCpp()&&( next("extern") ))||(synpred59_ObjCpp()&&( next("__success") ))||(synpred59_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred59_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") )))) ) {
                        alt42=1;
                    }


                }


                switch (alt42) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:768:7: modifier
            	    {
            	    pushFollow(FOLLOW_modifier_in_modifiers1725);
            	    modifier72=modifier();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, modifier72.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.modifiers.addAll((modifier72!=null?modifier72.modifiers:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "modifiers"

    public static class modifier_return extends ParserRuleReturnScope {
        public List<Modifier> modifiers;
        public String asmName;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "modifier"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:771:1: modifier returns [List<Modifier> modifiers, String asmName] : ({...}? => IDENTIFIER ex= STRING | {...}?m= IDENTIFIER | {...}? => IDENTIFIER '(' 'return' binaryOp expression ')' | {...}? => IDENTIFIER '(' expression ')' | {...}? => IDENTIFIER '(' ( (an= STRING )* | extendedModifiers ) ')' );
    public final ObjCppParser.modifier_return modifier() throws RecognitionException {
        ObjCppParser.modifier_return retval = new ObjCppParser.modifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ex=null;
        Token m=null;
        Token an=null;
        Token IDENTIFIER73=null;
        Token IDENTIFIER74=null;
        Token char_literal75=null;
        Token string_literal76=null;
        Token char_literal79=null;
        Token IDENTIFIER80=null;
        Token char_literal81=null;
        Token char_literal83=null;
        Token IDENTIFIER84=null;
        Token char_literal85=null;
        Token char_literal87=null;
        ObjCppParser.binaryOp_return binaryOp77 = null;

        ObjCppParser.expression_return expression78 = null;

        ObjCppParser.expression_return expression82 = null;

        ObjCppParser.extendedModifiers_return extendedModifiers86 = null;


        Object ex_tree=null;
        Object m_tree=null;
        Object an_tree=null;
        Object IDENTIFIER73_tree=null;
        Object IDENTIFIER74_tree=null;
        Object char_literal75_tree=null;
        Object string_literal76_tree=null;
        Object char_literal79_tree=null;
        Object IDENTIFIER80_tree=null;
        Object char_literal81_tree=null;
        Object char_literal83_tree=null;
        Object IDENTIFIER84_tree=null;
        Object char_literal85_tree=null;
        Object char_literal87_tree=null;

         retval.modifiers = new ArrayList<Modifier>(); 
        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:773:2: ({...}? => IDENTIFIER ex= STRING | {...}?m= IDENTIFIER | {...}? => IDENTIFIER '(' 'return' binaryOp expression ')' | {...}? => IDENTIFIER '(' expression ')' | {...}? => IDENTIFIER '(' ( (an= STRING )* | extendedModifiers ) ')' )
            int alt45=5;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==IDENTIFIER) ) {
                int LA45_1 = input.LA(2);

                if ( ((synpred60_ObjCpp()&&( next("extern") ))) ) {
                    alt45=1;
                }
                else if ( ((synpred61_ObjCpp()&&( Modifier.parseModifier(next()) != null ))) ) {
                    alt45=2;
                }
                else if ( ((synpred62_ObjCpp()&&( next("__success") ))) ) {
                    alt45=3;
                }
                else if ( ((synpred63_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))) ) {
                    alt45=4;
                }
                else if ( (( next("__declspec", "__attribute__", "__asm") )) ) {
                    alt45=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:774:3: {...}? => IDENTIFIER ex= STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !(( next("extern") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "modifier", " next(\"extern\") ");
                    }
                    IDENTIFIER73=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier1755); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER73_tree = (Object)adaptor.create(IDENTIFIER73);
                    adaptor.addChild(root_0, IDENTIFIER73_tree);
                    }
                    ex=(Token)match(input,STRING,FOLLOW_STRING_in_modifier1759); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ex_tree = (Object)adaptor.create(ex);
                    adaptor.addChild(root_0, ex_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			retval.modifiers.add(Modifier.Extern); // TODO
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:777:3: {...}?m= IDENTIFIER
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !(( Modifier.parseModifier(next()) != null )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "modifier", " Modifier.parseModifier(next()) != null ");
                    }
                    m=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier1771); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    m_tree = (Object)adaptor.create(m);
                    adaptor.addChild(root_0, m_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			retval.modifiers.add(Modifier.parseModifier((m!=null?m.getText():null)));
                      		
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:780:3: {...}? => IDENTIFIER '(' 'return' binaryOp expression ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !(( next("__success") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "modifier", " next(\"__success\") ");
                    }
                    IDENTIFIER74=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier1784); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER74_tree = (Object)adaptor.create(IDENTIFIER74);
                    adaptor.addChild(root_0, IDENTIFIER74_tree);
                    }
                    char_literal75=(Token)match(input,34,FOLLOW_34_in_modifier1786); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal75_tree = (Object)adaptor.create(char_literal75);
                    adaptor.addChild(root_0, char_literal75_tree);
                    }
                    string_literal76=(Token)match(input,52,FOLLOW_52_in_modifier1788); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal76_tree = (Object)adaptor.create(string_literal76);
                    adaptor.addChild(root_0, string_literal76_tree);
                    }
                    pushFollow(FOLLOW_binaryOp_in_modifier1790);
                    binaryOp77=binaryOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, binaryOp77.getTree());
                    pushFollow(FOLLOW_expression_in_modifier1792);
                    expression78=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression78.getTree());
                    char_literal79=(Token)match(input,35,FOLLOW_35_in_modifier1795); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal79_tree = (Object)adaptor.create(char_literal79);
                    adaptor.addChild(root_0, char_literal79_tree);
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:784:3: {...}? => IDENTIFIER '(' expression ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !(( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "modifier", " next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ");
                    }
                    IDENTIFIER80=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier1812); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER80_tree = (Object)adaptor.create(IDENTIFIER80);
                    adaptor.addChild(root_0, IDENTIFIER80_tree);
                    }
                    char_literal81=(Token)match(input,34,FOLLOW_34_in_modifier1814); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal81_tree = (Object)adaptor.create(char_literal81);
                    adaptor.addChild(root_0, char_literal81_tree);
                    }
                    pushFollow(FOLLOW_expression_in_modifier1816);
                    expression82=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression82.getTree());
                    char_literal83=(Token)match(input,35,FOLLOW_35_in_modifier1818); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal83_tree = (Object)adaptor.create(char_literal83);
                    adaptor.addChild(root_0, char_literal83_tree);
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:787:3: {...}? => IDENTIFIER '(' ( (an= STRING )* | extendedModifiers ) ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !(( next("__declspec", "__attribute__", "__asm") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "modifier", " next(\"__declspec\", \"__attribute__\", \"__asm\") ");
                    }
                    IDENTIFIER84=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier1832); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER84_tree = (Object)adaptor.create(IDENTIFIER84);
                    adaptor.addChild(root_0, IDENTIFIER84_tree);
                    }
                    char_literal85=(Token)match(input,34,FOLLOW_34_in_modifier1836); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal85_tree = (Object)adaptor.create(char_literal85);
                    adaptor.addChild(root_0, char_literal85_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:789:7: ( (an= STRING )* | extendedModifiers )
                    int alt44=2;
                    switch ( input.LA(1) ) {
                    case STRING:
                        {
                        alt44=1;
                        }
                        break;
                    case 35:
                        {
                        int LA44_2 = input.LA(2);

                        if ( (synpred65_ObjCpp()) ) {
                            alt44=1;
                        }
                        else if ( (true) ) {
                            alt44=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 44, 2, input);

                            throw nvae;
                        }
                        }
                        break;
                    case IDENTIFIER:
                        {
                        alt44=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 0, input);

                        throw nvae;
                    }

                    switch (alt44) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:790:4: (an= STRING )*
                            {
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:790:4: (an= STRING )*
                            loop43:
                            do {
                                int alt43=2;
                                int LA43_0 = input.LA(1);

                                if ( (LA43_0==STRING) ) {
                                    alt43=1;
                                }


                                switch (alt43) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:790:6: an= STRING
                            	    {
                            	    an=(Token)match(input,STRING,FOLLOW_STRING_in_modifier1847); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    an_tree = (Object)adaptor.create(an);
                            	    adaptor.addChild(root_0, an_tree);
                            	    }
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      				String s = String.valueOf(Constant.parseString((an!=null?an.getText():null)).getValue());
                            	      				if (retval.asmName == null) 
                            	      					retval.asmName = s; 
                            	      				else 
                            	      					retval.asmName += s; 
                            	      			
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop43;
                                }
                            } while (true);


                            }
                            break;
                        case 2 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:797:4: extendedModifiers
                            {
                            pushFollow(FOLLOW_extendedModifiers_in_modifier1859);
                            extendedModifiers86=extendedModifiers();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, extendedModifiers86.getTree());
                            if ( state.backtracking==0 ) {

                              				retval.modifiers.addAll((extendedModifiers86!=null?extendedModifiers86.modifiers:null));
                              			
                            }

                            }
                            break;

                    }

                    char_literal87=(Token)match(input,35,FOLLOW_35_in_modifier1867); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal87_tree = (Object)adaptor.create(char_literal87);
                    adaptor.addChild(root_0, char_literal87_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "modifier"

    public static class extendedModifiers_return extends ParserRuleReturnScope {
        public List<Modifier> modifiers;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "extendedModifiers"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:804:1: extendedModifiers returns [List<Modifier> modifiers] : ({...}?m= IDENTIFIER () )* ;
    public final ObjCppParser.extendedModifiers_return extendedModifiers() throws RecognitionException {
        ObjCppParser.extendedModifiers_return retval = new ObjCppParser.extendedModifiers_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token m=null;

        Object m_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:805:2: ( ({...}?m= IDENTIFIER () )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:805:4: ({...}?m= IDENTIFIER () )*
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:806:3: ({...}?m= IDENTIFIER () )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==IDENTIFIER) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:807:4: {...}?m= IDENTIFIER ()
            	    {
            	    if ( !(( next(Modifier.Kind.Extended) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "extendedModifiers", " next(Modifier.Kind.Extended) ");
            	    }
            	    m=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_extendedModifiers1896); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    m_tree = (Object)adaptor.create(m);
            	    adaptor.addChild(root_0, m_tree);
            	    }
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:808:4: ()
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:809:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					retval.modifiers.add(Modifier.parseModifier((m!=null?m.getText():null)));
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "extendedModifiers"

    public static class argDef_return extends ParserRuleReturnScope {
        public Arg arg;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argDef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:819:1: argDef returns [Arg arg] : ( (tr= mutableTypeRef ) ( ( declarator )? ) ( '=' dv= topLevelExpr )? | '...' );
    public final ObjCppParser.argDef_return argDef() throws RecognitionException {
        ObjCppParser.argDef_return retval = new ObjCppParser.argDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal89=null;
        Token string_literal90=null;
        ObjCppParser.mutableTypeRef_return tr = null;

        ObjCppParser.topLevelExpr_return dv = null;

        ObjCppParser.declarator_return declarator88 = null;


        Object char_literal89_tree=null;
        Object string_literal90_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:820:2: ( (tr= mutableTypeRef ) ( ( declarator )? ) ( '=' dv= topLevelExpr )? | '...' )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==EOF||LA49_0==IDENTIFIER||(LA49_0>=28 && LA49_0<=30)||(LA49_0>=34 && LA49_0<=35)||(LA49_0>=48 && LA49_0<=50)||(LA49_0>=53 && LA49_0<=55)||LA49_0==58||LA49_0==60) ) {
                alt49=1;
            }
            else if ( (LA49_0==44) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:820:4: (tr= mutableTypeRef ) ( ( declarator )? ) ( '=' dv= topLevelExpr )?
                    {
                    root_0 = (Object)adaptor.nil();

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:820:4: (tr= mutableTypeRef )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:821:4: tr= mutableTypeRef
                    {
                    pushFollow(FOLLOW_mutableTypeRef_in_argDef1939);
                    tr=mutableTypeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tr.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				if ((tr!=null?tr.type:null) != null) {
                      					retval.arg = new Arg(); 
                      					retval.arg.setValueType((tr!=null?tr.type:null)); 
                      					int i = getTokenStream().index() + 1;
                      					retval.arg.setCommentBefore(getCommentBefore(i));
                      					retval.arg.setCommentAfter(getCommentAfterOnSameLine(i));
                      				}
                      			
                    }

                    }

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:831:3: ( ( declarator )? )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:832:4: ( declarator )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:832:4: ( declarator )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==IDENTIFIER||LA47_0==34||(LA47_0>=53 && LA47_0<=54)||LA47_0==58) ) {
                        alt47=1;
                    }
                    switch (alt47) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: declarator
                            {
                            pushFollow(FOLLOW_declarator_in_argDef1954);
                            declarator88=declarator();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, declarator88.getTree());

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       
                      				if (retval.arg != null) {
                      					if ((declarator88!=null?declarator88.declarator:null) != null)
                      						retval.arg.setDeclarator((declarator88!=null?declarator88.declarator:null)); 
                      					/*else if (retval.arg.getValueType() instanceof FunctionSignature) {
                      						FunctionSignature fs = (FunctionSignature)retval.arg.getValueType();
                      						if (fs != null && fs.getFunction() != null) {
                      							//retval.arg.setName(fs.getFunction().getName());
                      							//fs.getFunction().setName(null);
                      						}
                      					}*/
                      				}
                      			
                    }

                    }

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:846:3: ( '=' dv= topLevelExpr )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==29) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:846:4: '=' dv= topLevelExpr
                            {
                            char_literal89=(Token)match(input,29,FOLLOW_29_in_argDef1966); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal89_tree = (Object)adaptor.create(char_literal89);
                            adaptor.addChild(root_0, char_literal89_tree);
                            }
                            pushFollow(FOLLOW_topLevelExpr_in_argDef1970);
                            dv=topLevelExpr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, dv.getTree());
                            if ( state.backtracking==0 ) {

                              			if (retval.arg != null)
                              				retval.arg.setDefaultValue((dv!=null?dv.expr:null));
                              		
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:851:3: '...'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal90=(Token)match(input,44,FOLLOW_44_in_argDef1984); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal90_tree = (Object)adaptor.create(string_literal90);
                    adaptor.addChild(root_0, string_literal90_tree);
                    }
                    if ( state.backtracking==0 ) {
                       
                      			retval.arg = Arg.createVarArgs(); 
                      		
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "argDef"

    public static class typeMutator_return extends ParserRuleReturnScope {
        public TypeMutator mutator;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeMutator"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:856:1: typeMutator returns [TypeMutator mutator] : (t= ( '*' | '&' ) | '[' ']' );
    public final ObjCppParser.typeMutator_return typeMutator() throws RecognitionException {
        ObjCppParser.typeMutator_return retval = new ObjCppParser.typeMutator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token t=null;
        Token char_literal91=null;
        Token char_literal92=null;

        Object t_tree=null;
        Object char_literal91_tree=null;
        Object char_literal92_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:857:2: (t= ( '*' | '&' ) | '[' ']' )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=53 && LA50_0<=54)) ) {
                alt50=1;
            }
            else if ( (LA50_0==55) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:858:3: t= ( '*' | '&' )
                    {
                    root_0 = (Object)adaptor.nil();

                    t=(Token)input.LT(1);
                    if ( (input.LA(1)>=53 && input.LA(1)<=54) ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(t));
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    if ( state.backtracking==0 ) {
                       
                      			retval.mutator = (t!=null?t.getText():null).equals("*") ? TypeMutator.STAR : TypeMutator.AMPERSTAND; 
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:861:3: '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal91=(Token)match(input,55,FOLLOW_55_in_typeMutator2020); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal91_tree = (Object)adaptor.create(char_literal91);
                    adaptor.addChild(root_0, char_literal91_tree);
                    }
                    char_literal92=(Token)match(input,56,FOLLOW_56_in_typeMutator2022); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal92_tree = (Object)adaptor.create(char_literal92);
                    adaptor.addChild(root_0, char_literal92_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.mutator = TypeMutator.BRACKETS; 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "typeMutator"

    public static class arrayTypeMutator_return extends ParserRuleReturnScope {
        public TypeMutator mutator;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayTypeMutator"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:864:1: arrayTypeMutator returns [TypeMutator mutator] : '[' expression ']' ;
    public final ObjCppParser.arrayTypeMutator_return arrayTypeMutator() throws RecognitionException {
        ObjCppParser.arrayTypeMutator_return retval = new ObjCppParser.arrayTypeMutator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal93=null;
        Token char_literal95=null;
        ObjCppParser.expression_return expression94 = null;


        Object char_literal93_tree=null;
        Object char_literal95_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:865:2: ( '[' expression ']' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:865:4: '[' expression ']'
            {
            root_0 = (Object)adaptor.nil();

            char_literal93=(Token)match(input,55,FOLLOW_55_in_arrayTypeMutator2040); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal93_tree = (Object)adaptor.create(char_literal93);
            adaptor.addChild(root_0, char_literal93_tree);
            }
            pushFollow(FOLLOW_expression_in_arrayTypeMutator2046);
            expression94=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression94.getTree());
            if ( state.backtracking==0 ) {

              				retval.mutator = TypeMutator.array((expression94!=null?expression94.expr:null)); 
              			
            }
            char_literal95=(Token)match(input,56,FOLLOW_56_in_arrayTypeMutator2055); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal95_tree = (Object)adaptor.create(char_literal95);
            adaptor.addChild(root_0, char_literal95_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arrayTypeMutator"

    public static class templateDef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "templateDef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:872:1: templateDef : ( 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' structCore | functionDeclaration );
    public final ObjCppParser.templateDef_return templateDef() throws RecognitionException {
        ObjCppParser.templateDef_return retval = new ObjCppParser.templateDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal96=null;
        Token char_literal97=null;
        Token char_literal99=null;
        Token char_literal101=null;
        ObjCppParser.templateArgDecl_return templateArgDecl98 = null;

        ObjCppParser.templateArgDecl_return templateArgDecl100 = null;

        ObjCppParser.structCore_return structCore102 = null;

        ObjCppParser.functionDeclaration_return functionDeclaration103 = null;


        Object string_literal96_tree=null;
        Object char_literal97_tree=null;
        Object char_literal99_tree=null;
        Object char_literal101_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:873:2: ( 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' structCore | functionDeclaration )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==57) ) {
                alt53=1;
            }
            else if ( (LA53_0==IDENTIFIER||LA53_0==30||LA53_0==34||(LA53_0>=48 && LA53_0<=51)||(LA53_0>=53 && LA53_0<=55)||LA53_0==60) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:873:4: 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' structCore
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal96=(Token)match(input,57,FOLLOW_57_in_templateDef2067); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal96_tree = (Object)adaptor.create(string_literal96);
                    adaptor.addChild(root_0, string_literal96_tree);
                    }
                    char_literal97=(Token)match(input,36,FOLLOW_36_in_templateDef2069); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal97_tree = (Object)adaptor.create(char_literal97);
                    adaptor.addChild(root_0, char_literal97_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:873:19: ( templateArgDecl ( ',' templateArgDecl )* )?
                    int alt52=2;
                    int LA52_0 = input.LA(1);

                    if ( (LA52_0==IDENTIFIER||(LA52_0>=28 && LA52_0<=30)||LA52_0==34||(LA52_0>=48 && LA52_0<=50)||(LA52_0>=53 && LA52_0<=55)||LA52_0==60) ) {
                        alt52=1;
                    }
                    else if ( (LA52_0==37) ) {
                        int LA52_2 = input.LA(2);

                        if ( (synpred73_ObjCpp()) ) {
                            alt52=1;
                        }
                    }
                    switch (alt52) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:873:20: templateArgDecl ( ',' templateArgDecl )*
                            {
                            pushFollow(FOLLOW_templateArgDecl_in_templateDef2072);
                            templateArgDecl98=templateArgDecl();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, templateArgDecl98.getTree());
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:873:36: ( ',' templateArgDecl )*
                            loop51:
                            do {
                                int alt51=2;
                                int LA51_0 = input.LA(1);

                                if ( (LA51_0==28) ) {
                                    alt51=1;
                                }


                                switch (alt51) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:873:37: ',' templateArgDecl
                            	    {
                            	    char_literal99=(Token)match(input,28,FOLLOW_28_in_templateDef2075); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    char_literal99_tree = (Object)adaptor.create(char_literal99);
                            	    adaptor.addChild(root_0, char_literal99_tree);
                            	    }
                            	    pushFollow(FOLLOW_templateArgDecl_in_templateDef2077);
                            	    templateArgDecl100=templateArgDecl();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, templateArgDecl100.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop51;
                                }
                            } while (true);


                            }
                            break;

                    }

                    char_literal101=(Token)match(input,37,FOLLOW_37_in_templateDef2084); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal101_tree = (Object)adaptor.create(char_literal101);
                    adaptor.addChild(root_0, char_literal101_tree);
                    }
                    pushFollow(FOLLOW_structCore_in_templateDef2088);
                    structCore102=structCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structCore102.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:874:16: functionDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_functionDeclaration_in_templateDef2092);
                    functionDeclaration103=functionDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionDeclaration103.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "templateDef"

    public static class templateArgDecl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "templateArgDecl"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:877:1: templateArgDecl : mutableTypeRef ( '=' constant )? ;
    public final ObjCppParser.templateArgDecl_return templateArgDecl() throws RecognitionException {
        ObjCppParser.templateArgDecl_return retval = new ObjCppParser.templateArgDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal105=null;
        ObjCppParser.mutableTypeRef_return mutableTypeRef104 = null;

        ObjCppParser.constant_return constant106 = null;


        Object char_literal105_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:878:2: ( mutableTypeRef ( '=' constant )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:878:4: mutableTypeRef ( '=' constant )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_mutableTypeRef_in_templateArgDecl2104);
            mutableTypeRef104=mutableTypeRef();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mutableTypeRef104.getTree());
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:878:19: ( '=' constant )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==29) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:878:20: '=' constant
                    {
                    char_literal105=(Token)match(input,29,FOLLOW_29_in_templateArgDecl2107); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal105_tree = (Object)adaptor.create(char_literal105);
                    adaptor.addChild(root_0, char_literal105_tree);
                    }
                    pushFollow(FOLLOW_constant_in_templateArgDecl2109);
                    constant106=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant106.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "templateArgDecl"

    public static class functionSignatureSuffix_return extends ParserRuleReturnScope {
        public FunctionSignature signature;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionSignatureSuffix"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:881:1: functionSignatureSuffix returns [FunctionSignature signature] : tk= '(' m1= modifiers '*' m2= modifiers ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' ;
    public final ObjCppParser.functionSignatureSuffix_return functionSignatureSuffix() throws RecognitionException {
        ObjCppParser.functionSignatureSuffix_return retval = new ObjCppParser.functionSignatureSuffix_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token tk=null;
        Token char_literal107=null;
        Token IDENTIFIER108=null;
        Token char_literal109=null;
        Token char_literal110=null;
        Token char_literal111=null;
        Token char_literal112=null;
        ObjCppParser.modifiers_return m1 = null;

        ObjCppParser.modifiers_return m2 = null;

        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        Object tk_tree=null;
        Object char_literal107_tree=null;
        Object IDENTIFIER108_tree=null;
        Object char_literal109_tree=null;
        Object char_literal110_tree=null;
        Object char_literal111_tree=null;
        Object char_literal112_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:882:2: (tk= '(' m1= modifiers '*' m2= modifiers ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:882:4: tk= '(' m1= modifiers '*' m2= modifiers ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')'
            {
            root_0 = (Object)adaptor.nil();

            tk=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffix2129); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tk_tree = (Object)adaptor.create(tk);
            adaptor.addChild(root_0, tk_tree);
            }
            pushFollow(FOLLOW_modifiers_in_functionSignatureSuffix2133);
            m1=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, m1.getTree());
            char_literal107=(Token)match(input,53,FOLLOW_53_in_functionSignatureSuffix2135); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal107_tree = (Object)adaptor.create(char_literal107);
            adaptor.addChild(root_0, char_literal107_tree);
            }
            pushFollow(FOLLOW_modifiers_in_functionSignatureSuffix2139);
            m2=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, m2.getTree());
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:882:41: ( IDENTIFIER )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==IDENTIFIER) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: IDENTIFIER
                    {
                    IDENTIFIER108=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionSignatureSuffix2141); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER108_tree = (Object)adaptor.create(IDENTIFIER108);
                    adaptor.addChild(root_0, IDENTIFIER108_tree);
                    }

                    }
                    break;

            }

            char_literal109=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffix2144); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal109_tree = (Object)adaptor.create(char_literal109);
            adaptor.addChild(root_0, char_literal109_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, (IDENTIFIER108!=null?IDENTIFIER108.getText():null), null)), getLine(tk));
              			retval.signature.getFunction().setType(Function.Type.CFunction);
              			retval.signature.getFunction().addModifiers((m1!=null?m1.modifiers:null));
              			retval.signature.getFunction().addModifiers((m2!=null?m2.modifiers:null));
              		
            }
            char_literal110=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffix2150); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal110_tree = (Object)adaptor.create(char_literal110);
            adaptor.addChild(root_0, char_literal110_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:888:7: (a1= argDef ( ',' ax= argDef )* )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==IDENTIFIER||(LA57_0>=28 && LA57_0<=30)||LA57_0==34||LA57_0==44||(LA57_0>=48 && LA57_0<=50)||(LA57_0>=53 && LA57_0<=55)||LA57_0==58||LA57_0==60) ) {
                alt57=1;
            }
            else if ( (LA57_0==35) ) {
                int LA57_2 = input.LA(2);

                if ( (synpred78_ObjCpp()) ) {
                    alt57=1;
                }
            }
            switch (alt57) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:889:4: a1= argDef ( ',' ax= argDef )*
                    {
                    pushFollow(FOLLOW_argDef_in_functionSignatureSuffix2159);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					((FunctionSignature)retval.signature).getFunction().addArg((a1!=null?a1.arg:null)); 
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:893:4: ( ',' ax= argDef )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==28) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:894:5: ',' ax= argDef
                    	    {
                    	    char_literal111=(Token)match(input,28,FOLLOW_28_in_functionSignatureSuffix2172); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal111_tree = (Object)adaptor.create(char_literal111);
                    	    adaptor.addChild(root_0, char_literal111_tree);
                    	    }
                    	    pushFollow(FOLLOW_argDef_in_functionSignatureSuffix2181);
                    	    ax=argDef();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ax.getTree());
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      					((FunctionSignature)retval.signature).getFunction().addArg((ax!=null?ax.arg:null)); 
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop56;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal112=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffix2196); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal112_tree = (Object)adaptor.create(char_literal112);
            adaptor.addChild(root_0, char_literal112_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionSignatureSuffix"

    public static class functionSignatureSuffixNoName_return extends ParserRuleReturnScope {
        public FunctionSignature signature;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionSignatureSuffixNoName"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:902:1: functionSignatureSuffixNoName returns [FunctionSignature signature] : tk= '(' modifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' ;
    public final ObjCppParser.functionSignatureSuffixNoName_return functionSignatureSuffixNoName() throws RecognitionException {
        ObjCppParser.functionSignatureSuffixNoName_return retval = new ObjCppParser.functionSignatureSuffixNoName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token tk=null;
        Token char_literal114=null;
        Token char_literal115=null;
        Token char_literal116=null;
        Token char_literal117=null;
        Token char_literal118=null;
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;

        ObjCppParser.modifiers_return modifiers113 = null;


        Object tk_tree=null;
        Object char_literal114_tree=null;
        Object char_literal115_tree=null;
        Object char_literal116_tree=null;
        Object char_literal117_tree=null;
        Object char_literal118_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:903:2: (tk= '(' modifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:903:4: tk= '(' modifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')'
            {
            root_0 = (Object)adaptor.nil();

            tk=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffixNoName2213); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tk_tree = (Object)adaptor.create(tk);
            adaptor.addChild(root_0, tk_tree);
            }
            pushFollow(FOLLOW_modifiers_in_functionSignatureSuffixNoName2215);
            modifiers113=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, modifiers113.getTree());
            char_literal114=(Token)match(input,53,FOLLOW_53_in_functionSignatureSuffixNoName2217); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal114_tree = (Object)adaptor.create(char_literal114);
            adaptor.addChild(root_0, char_literal114_tree);
            }
            char_literal115=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffixNoName2219); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal115_tree = (Object)adaptor.create(char_literal115);
            adaptor.addChild(root_0, char_literal115_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, null, null)), getLine(tk));
              			retval.signature.getFunction().setType(Function.Type.CFunction);
              			retval.signature.getFunction().addModifiers((modifiers113!=null?modifiers113.modifiers:null));
              		
            }
            char_literal116=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffixNoName2225); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal116_tree = (Object)adaptor.create(char_literal116);
            adaptor.addChild(root_0, char_literal116_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:908:7: (a1= argDef ( ',' ax= argDef )* )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==IDENTIFIER||(LA59_0>=28 && LA59_0<=30)||LA59_0==34||LA59_0==44||(LA59_0>=48 && LA59_0<=50)||(LA59_0>=53 && LA59_0<=55)||LA59_0==58||LA59_0==60) ) {
                alt59=1;
            }
            else if ( (LA59_0==35) ) {
                int LA59_2 = input.LA(2);

                if ( (synpred80_ObjCpp()) ) {
                    alt59=1;
                }
            }
            switch (alt59) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:909:4: a1= argDef ( ',' ax= argDef )*
                    {
                    pushFollow(FOLLOW_argDef_in_functionSignatureSuffixNoName2234);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					((FunctionSignature)retval.signature).getFunction().addArg((a1!=null?a1.arg:null)); 
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:913:4: ( ',' ax= argDef )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==28) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:914:5: ',' ax= argDef
                    	    {
                    	    char_literal117=(Token)match(input,28,FOLLOW_28_in_functionSignatureSuffixNoName2247); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal117_tree = (Object)adaptor.create(char_literal117);
                    	    adaptor.addChild(root_0, char_literal117_tree);
                    	    }
                    	    pushFollow(FOLLOW_argDef_in_functionSignatureSuffixNoName2256);
                    	    ax=argDef();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ax.getTree());
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      					((FunctionSignature)retval.signature).getFunction().addArg((ax!=null?ax.arg:null)); 
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal118=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffixNoName2271); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal118_tree = (Object)adaptor.create(char_literal118);
            adaptor.addChild(root_0, char_literal118_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionSignatureSuffixNoName"

    public static class mutableTypeRef_return extends ParserRuleReturnScope {
        public TypeRef type;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mutableTypeRef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:922:1: mutableTypeRef returns [TypeRef type] : ( typeRefCore ) ( (m1= typeMutator ) | (f1= functionSignatureSuffix ) )* ;
    public final ObjCppParser.mutableTypeRef_return mutableTypeRef() throws RecognitionException {
        ObjCppParser.mutableTypeRef_return retval = new ObjCppParser.mutableTypeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.typeMutator_return m1 = null;

        ObjCppParser.functionSignatureSuffix_return f1 = null;

        ObjCppParser.typeRefCore_return typeRefCore119 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:923:2: ( ( typeRefCore ) ( (m1= typeMutator ) | (f1= functionSignatureSuffix ) )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:924:3: ( typeRefCore ) ( (m1= typeMutator ) | (f1= functionSignatureSuffix ) )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:924:3: ( typeRefCore )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:924:5: typeRefCore
            {
            pushFollow(FOLLOW_typeRefCore_in_mutableTypeRef2291);
            typeRefCore119=typeRefCore();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRefCore119.getTree());
            if ( state.backtracking==0 ) {
               
              			retval.type = (typeRefCore119!=null?typeRefCore119.type:null); 
              		
            }

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:927:3: ( (m1= typeMutator ) | (f1= functionSignatureSuffix ) )*
            loop60:
            do {
                int alt60=3;
                alt60 = dfa60.predict(input);
                switch (alt60) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:928:4: (m1= typeMutator )
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:928:4: (m1= typeMutator )
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:929:5: m1= typeMutator
            	    {
            	    pushFollow(FOLLOW_typeMutator_in_mutableTypeRef2312);
            	    m1=typeMutator();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, m1.getTree());
            	    if ( state.backtracking==0 ) {

            	      					retval.type = (m1!=null?m1.mutator:null).mutateType(retval.type);
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:933:4: (f1= functionSignatureSuffix )
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:933:4: (f1= functionSignatureSuffix )
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:934:5: f1= functionSignatureSuffix
            	    {
            	    pushFollow(FOLLOW_functionSignatureSuffix_in_mutableTypeRef2334);
            	    f1=functionSignatureSuffix();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, f1.getTree());
            	    if ( state.backtracking==0 ) {
            	       
            	      					assert (f1!=null?f1.signature:null) != null && (f1!=null?f1.signature:null).getFunction() != null;
            	      					if ((f1!=null?f1.signature:null) != null && (f1!=null?f1.signature:null).getFunction() != null) {
            	      						(f1!=null?f1.signature:null).getFunction().setValueType(retval.type); 
            	      						retval.type = (f1!=null?f1.signature:null);
            	      					}
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "mutableTypeRef"

    public static class nonMutableTypeRef_return extends ParserRuleReturnScope {
        public TypeRef type;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nonMutableTypeRef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:945:1: nonMutableTypeRef returns [TypeRef type] : typeRefCore ( ( typeMutator )* (fs= functionSignatureSuffix ) )* ;
    public final ObjCppParser.nonMutableTypeRef_return nonMutableTypeRef() throws RecognitionException {
        ObjCppParser.nonMutableTypeRef_return retval = new ObjCppParser.nonMutableTypeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.functionSignatureSuffix_return fs = null;

        ObjCppParser.typeRefCore_return typeRefCore120 = null;

        ObjCppParser.typeMutator_return typeMutator121 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:946:2: ( typeRefCore ( ( typeMutator )* (fs= functionSignatureSuffix ) )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:947:3: typeRefCore ( ( typeMutator )* (fs= functionSignatureSuffix ) )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_typeRefCore_in_nonMutableTypeRef2363);
            typeRefCore120=typeRefCore();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRefCore120.getTree());
            if ( state.backtracking==0 ) {
               
              			retval.type = (typeRefCore120!=null?typeRefCore120.type:null); 
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:950:3: ( ( typeMutator )* (fs= functionSignatureSuffix ) )*
            loop62:
            do {
                int alt62=2;
                switch ( input.LA(1) ) {
                case 34:
                    {
                    int LA62_2 = input.LA(2);

                    if ( (synpred84_ObjCpp()) ) {
                        alt62=1;
                    }


                    }
                    break;
                case 53:
                case 54:
                    {
                    int LA62_3 = input.LA(2);

                    if ( (synpred84_ObjCpp()) ) {
                        alt62=1;
                    }


                    }
                    break;
                case 55:
                    {
                    alt62=1;
                    }
                    break;

                }

                switch (alt62) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:951:4: ( typeMutator )* (fs= functionSignatureSuffix )
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:951:4: ( typeMutator )*
            	    loop61:
            	    do {
            	        int alt61=2;
            	        int LA61_0 = input.LA(1);

            	        if ( ((LA61_0>=53 && LA61_0<=55)) ) {
            	            alt61=1;
            	        }


            	        switch (alt61) {
            	    	case 1 :
            	    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:952:5: typeMutator
            	    	    {
            	    	    pushFollow(FOLLOW_typeMutator_in_nonMutableTypeRef2380);
            	    	    typeMutator121=typeMutator();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeMutator121.getTree());
            	    	    if ( state.backtracking==0 ) {

            	    	      					retval.type = (typeMutator121!=null?typeMutator121.mutator:null).mutateType(retval.type);
            	    	      				
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop61;
            	        }
            	    } while (true);

            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:956:4: (fs= functionSignatureSuffix )
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:957:5: fs= functionSignatureSuffix
            	    {
            	    pushFollow(FOLLOW_functionSignatureSuffix_in_nonMutableTypeRef2401);
            	    fs=functionSignatureSuffix();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, fs.getTree());
            	    if ( state.backtracking==0 ) {
            	       
            	      					assert (fs!=null?fs.signature:null) != null && (fs!=null?fs.signature:null).getFunction() != null;
            	      					if ((fs!=null?fs.signature:null) != null && (fs!=null?fs.signature:null).getFunction() != null) {
            	      						(fs!=null?fs.signature:null).getFunction().setValueType(retval.type); 
            	      						retval.type = (fs!=null?fs.signature:null);
            	      					}
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nonMutableTypeRef"

    public static class declarator_return extends ParserRuleReturnScope {
        public Declarator declarator;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declarator"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:968:1: declarator returns [Declarator declarator] : modifiers ( ( directDeclarator ) | (pt= ( '*' | '&' | '^' ) inner= declarator ) ) ( '=' dv= topLevelExpr )? ;
    public final ObjCppParser.declarator_return declarator() throws RecognitionException {
        ObjCppParser.declarator_return retval = new ObjCppParser.declarator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token pt=null;
        Token char_literal124=null;
        ObjCppParser.declarator_return inner = null;

        ObjCppParser.topLevelExpr_return dv = null;

        ObjCppParser.modifiers_return modifiers122 = null;

        ObjCppParser.directDeclarator_return directDeclarator123 = null;


        Object pt_tree=null;
        Object char_literal124_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:969:2: ( modifiers ( ( directDeclarator ) | (pt= ( '*' | '&' | '^' ) inner= declarator ) ) ( '=' dv= topLevelExpr )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:970:3: modifiers ( ( directDeclarator ) | (pt= ( '*' | '&' | '^' ) inner= declarator ) ) ( '=' dv= topLevelExpr )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_modifiers_in_declarator2432);
            modifiers122=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, modifiers122.getTree());
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:971:3: ( ( directDeclarator ) | (pt= ( '*' | '&' | '^' ) inner= declarator ) )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==IDENTIFIER) && (( Modifier.parseModifier(next()) == null ))) {
                alt63=1;
            }
            else if ( (LA63_0==34) ) {
                alt63=1;
            }
            else if ( ((LA63_0>=53 && LA63_0<=54)||LA63_0==58) ) {
                alt63=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:972:4: ( directDeclarator )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:972:4: ( directDeclarator )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:973:5: directDeclarator
                    {
                    pushFollow(FOLLOW_directDeclarator_in_declarator2448);
                    directDeclarator123=directDeclarator();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, directDeclarator123.getTree());
                    if ( state.backtracking==0 ) {
                       
                      					retval.declarator = (directDeclarator123!=null?directDeclarator123.declarator:null); 
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:977:4: (pt= ( '*' | '&' | '^' ) inner= declarator )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:977:4: (pt= ( '*' | '&' | '^' ) inner= declarator )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:978:5: pt= ( '*' | '&' | '^' ) inner= declarator
                    {
                    pt=(Token)input.LT(1);
                    if ( (input.LA(1)>=53 && input.LA(1)<=54)||input.LA(1)==58 ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(pt));
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_declarator_in_declarator2490);
                    inner=declarator();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inner.getTree());
                    if ( state.backtracking==0 ) {

                      					retval.declarator = new PointerDeclarator((inner!=null?inner.declarator:null), PointerStyle.parsePointerStyle((pt!=null?pt.getText():null)));
                      				
                    }

                    }


                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:984:3: ( '=' dv= topLevelExpr )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==29) ) {
                int LA64_1 = input.LA(2);

                if ( (synpred88_ObjCpp()) ) {
                    alt64=1;
                }
            }
            switch (alt64) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:985:4: '=' dv= topLevelExpr
                    {
                    char_literal124=(Token)match(input,29,FOLLOW_29_in_declarator2511); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal124_tree = (Object)adaptor.create(char_literal124);
                    adaptor.addChild(root_0, char_literal124_tree);
                    }
                    pushFollow(FOLLOW_topLevelExpr_in_declarator2519);
                    dv=topLevelExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dv.getTree());
                    if ( state.backtracking==0 ) {

                      				retval.declarator.setDefaultValue((dv!=null?dv.expr:null));
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			retval.declarator.setModifiers((modifiers122!=null?modifiers122.modifiers:null));
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "declarator"

    public static class typeDef_return extends ParserRuleReturnScope {
        public TypeDef typeDef;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeDef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:995:1: typeDef returns [TypeDef typeDef] : 'typedef' varDecl ';' ;
    public final ObjCppParser.typeDef_return typeDef() throws RecognitionException {
        ObjCppParser.typeDef_return retval = new ObjCppParser.typeDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal125=null;
        Token char_literal127=null;
        ObjCppParser.varDecl_return varDecl126 = null;


        Object string_literal125_tree=null;
        Object char_literal127_tree=null;


        	((IsTypeDef_scope)IsTypeDef_stack.peek()).isTypeDef = true;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:999:2: ( 'typedef' varDecl ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:999:4: 'typedef' varDecl ';'
            {
            root_0 = (Object)adaptor.nil();

            string_literal125=(Token)match(input,59,FOLLOW_59_in_typeDef2550); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal125_tree = (Object)adaptor.create(string_literal125);
            adaptor.addChild(root_0, string_literal125_tree);
            }
            pushFollow(FOLLOW_varDecl_in_typeDef2555);
            varDecl126=varDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl126.getTree());
            char_literal127=(Token)match(input,25,FOLLOW_25_in_typeDef2557); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal127_tree = (Object)adaptor.create(char_literal127);
            adaptor.addChild(root_0, char_literal127_tree);
            }
            if ( state.backtracking==0 ) {

              		 	VariablesDeclaration vd = (varDecl126!=null?varDecl126.decl:null);
              			retval.typeDef = new TypeDef(vd.getValueType(), vd.getDeclarators());
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "typeDef"

    public static class varDeclEOF_return extends ParserRuleReturnScope {
        public Declaration decl;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "varDeclEOF"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1006:1: varDeclEOF returns [Declaration decl] : varDecl ';' EOF ;
    public final ObjCppParser.varDeclEOF_return varDeclEOF() throws RecognitionException {
        ObjCppParser.varDeclEOF_return retval = new ObjCppParser.varDeclEOF_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal129=null;
        Token EOF130=null;
        ObjCppParser.varDecl_return varDecl128 = null;


        Object char_literal129_tree=null;
        Object EOF130_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1007:2: ( varDecl ';' EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1007:4: varDecl ';' EOF
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_varDecl_in_varDeclEOF2575);
            varDecl128=varDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl128.getTree());
            char_literal129=(Token)match(input,25,FOLLOW_25_in_varDeclEOF2577); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal129_tree = (Object)adaptor.create(char_literal129);
            adaptor.addChild(root_0, char_literal129_tree);
            }
            EOF130=(Token)match(input,EOF,FOLLOW_EOF_in_varDeclEOF2579); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EOF130_tree = (Object)adaptor.create(EOF130);
            adaptor.addChild(root_0, EOF130_tree);
            }
            if ( state.backtracking==0 ) {
               retval.decl = (varDecl128!=null?varDecl128.decl:null); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "varDeclEOF"

    public static class declarationEOF_return extends ParserRuleReturnScope {
        public List<Declaration> declarations;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declarationEOF"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1010:1: declarationEOF returns [List<Declaration> declarations] : d= declaration EOF ;
    public final ObjCppParser.declarationEOF_return declarationEOF() throws RecognitionException {
        ObjCppParser.declarationEOF_return retval = new ObjCppParser.declarationEOF_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF131=null;
        ObjCppParser.declaration_return d = null;


        Object EOF131_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1011:2: (d= declaration EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1011:5: d= declaration EOF
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_declaration_in_declarationEOF2599);
            d=declaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());
            EOF131=(Token)match(input,EOF,FOLLOW_EOF_in_declarationEOF2601); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EOF131_tree = (Object)adaptor.create(EOF131);
            adaptor.addChild(root_0, EOF131_tree);
            }
            if ( state.backtracking==0 ) {
               retval.declarations = (d!=null?d.declarations:null); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "declarationEOF"

    public static class varDecl_return extends ParserRuleReturnScope {
        public VariablesDeclaration decl;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "varDecl"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1014:1: varDecl returns [VariablesDeclaration decl] : tr= nonMutableTypeRef (d1= declaratorsList )? ;
    public final ObjCppParser.varDecl_return varDecl() throws RecognitionException {
        ObjCppParser.varDecl_return retval = new ObjCppParser.varDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.nonMutableTypeRef_return tr = null;

        ObjCppParser.declaratorsList_return d1 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1015:2: (tr= nonMutableTypeRef (d1= declaratorsList )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1016:3: tr= nonMutableTypeRef (d1= declaratorsList )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_nonMutableTypeRef_in_varDecl2623);
            tr=nonMutableTypeRef();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, tr.getTree());
            if ( state.backtracking==0 ) {
               
              			retval.decl = new VariablesDeclaration((tr!=null?tr.type:null)); 
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1019:3: (d1= declaratorsList )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==IDENTIFIER||LA65_0==34||(LA65_0>=53 && LA65_0<=54)||LA65_0==58) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1020:4: d1= declaratorsList
                    {
                    pushFollow(FOLLOW_declaratorsList_in_varDecl2636);
                    d1=declaratorsList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, d1.getTree());
                    if ( state.backtracking==0 ) {

                      				retval.decl.setDeclarators((d1!=null?d1.declarators:null));
                      			
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "varDecl"

    public static class objCProtocolRefList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "objCProtocolRefList"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1026:1: objCProtocolRefList : '<' IDENTIFIER ( ',' IDENTIFIER )* '>' ;
    public final ObjCppParser.objCProtocolRefList_return objCProtocolRefList() throws RecognitionException {
        ObjCppParser.objCProtocolRefList_return retval = new ObjCppParser.objCProtocolRefList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal132=null;
        Token IDENTIFIER133=null;
        Token char_literal134=null;
        Token IDENTIFIER135=null;
        Token char_literal136=null;

        Object char_literal132_tree=null;
        Object IDENTIFIER133_tree=null;
        Object char_literal134_tree=null;
        Object IDENTIFIER135_tree=null;
        Object char_literal136_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1027:2: ( '<' IDENTIFIER ( ',' IDENTIFIER )* '>' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1027:4: '<' IDENTIFIER ( ',' IDENTIFIER )* '>'
            {
            root_0 = (Object)adaptor.nil();

            char_literal132=(Token)match(input,36,FOLLOW_36_in_objCProtocolRefList2655); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal132_tree = (Object)adaptor.create(char_literal132);
            adaptor.addChild(root_0, char_literal132_tree);
            }
            IDENTIFIER133=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCProtocolRefList2660); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER133_tree = (Object)adaptor.create(IDENTIFIER133);
            adaptor.addChild(root_0, IDENTIFIER133_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1029:3: ( ',' IDENTIFIER )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==28) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1030:4: ',' IDENTIFIER
            	    {
            	    char_literal134=(Token)match(input,28,FOLLOW_28_in_objCProtocolRefList2670); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal134_tree = (Object)adaptor.create(char_literal134);
            	    adaptor.addChild(root_0, char_literal134_tree);
            	    }
            	    IDENTIFIER135=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCProtocolRefList2676); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDENTIFIER135_tree = (Object)adaptor.create(IDENTIFIER135);
            	    adaptor.addChild(root_0, IDENTIFIER135_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);

            char_literal136=(Token)match(input,37,FOLLOW_37_in_objCProtocolRefList2686); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal136_tree = (Object)adaptor.create(char_literal136);
            adaptor.addChild(root_0, char_literal136_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "objCProtocolRefList"

    public static class declaratorsList_return extends ParserRuleReturnScope {
        public List<Declarator> declarators;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declaratorsList"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1036:1: declaratorsList returns [List<Declarator> declarators] : d= declarator ( ',' x= declarator )* ;
    public final ObjCppParser.declaratorsList_return declaratorsList() throws RecognitionException {
        ObjCppParser.declaratorsList_return retval = new ObjCppParser.declaratorsList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal137=null;
        ObjCppParser.declarator_return d = null;

        ObjCppParser.declarator_return x = null;


        Object char_literal137_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1037:2: (d= declarator ( ',' x= declarator )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1037:4: d= declarator ( ',' x= declarator )*
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.declarators = new ArrayList<Declarator>(); 
            }
            pushFollow(FOLLOW_declarator_in_declaratorsList2707);
            d=declarator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());
            if ( state.backtracking==0 ) {
               retval.declarators.add((d!=null?d.declarator:null)); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1039:3: ( ',' x= declarator )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==28) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1040:4: ',' x= declarator
            	    {
            	    char_literal137=(Token)match(input,28,FOLLOW_28_in_declaratorsList2718); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal137_tree = (Object)adaptor.create(char_literal137);
            	    adaptor.addChild(root_0, char_literal137_tree);
            	    }
            	    pushFollow(FOLLOW_declarator_in_declaratorsList2726);
            	    x=declarator();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.declarators.add((x!=null?x.declarator:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "declaratorsList"

    public static class directDeclarator_return extends ParserRuleReturnScope {
        public Declarator declarator;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "directDeclarator"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1045:1: directDeclarator returns [Declarator declarator] : ({...}? => IDENTIFIER | '(' inner= declarator ')' ) ( '[' ( expression | ) ']' | argList )* ;
    public final ObjCppParser.directDeclarator_return directDeclarator() throws RecognitionException {
        ObjCppParser.directDeclarator_return retval = new ObjCppParser.directDeclarator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER138=null;
        Token char_literal139=null;
        Token char_literal140=null;
        Token char_literal141=null;
        Token char_literal143=null;
        ObjCppParser.declarator_return inner = null;

        ObjCppParser.expression_return expression142 = null;

        ObjCppParser.argList_return argList144 = null;


        Object IDENTIFIER138_tree=null;
        Object char_literal139_tree=null;
        Object char_literal140_tree=null;
        Object char_literal141_tree=null;
        Object char_literal143_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1046:2: ( ({...}? => IDENTIFIER | '(' inner= declarator ')' ) ( '[' ( expression | ) ']' | argList )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1047:3: ({...}? => IDENTIFIER | '(' inner= declarator ')' ) ( '[' ( expression | ) ']' | argList )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1047:3: ({...}? => IDENTIFIER | '(' inner= declarator ')' )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==IDENTIFIER) && (( Modifier.parseModifier(next()) == null ))) {
                alt68=1;
            }
            else if ( (LA68_0==34) ) {
                alt68=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1048:4: {...}? => IDENTIFIER
                    {
                    if ( !(( Modifier.parseModifier(next()) == null )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "directDeclarator", " Modifier.parseModifier(next()) == null ");
                    }
                    IDENTIFIER138=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_directDeclarator2760); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER138_tree = (Object)adaptor.create(IDENTIFIER138);
                    adaptor.addChild(root_0, IDENTIFIER138_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				retval.declarator = mark(new DirectDeclarator((IDENTIFIER138!=null?IDENTIFIER138.getText():null)), getLine(IDENTIFIER138));
                      				if (isTypeDef()) {
                      					((Symbols_scope)Symbols_stack.peek()).typeIdentifiers.add((IDENTIFIER138!=null?IDENTIFIER138.getText():null));
                      				}
                      			
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1054:4: '(' inner= declarator ')'
                    {
                    char_literal139=(Token)match(input,34,FOLLOW_34_in_directDeclarator2770); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal139_tree = (Object)adaptor.create(char_literal139);
                    adaptor.addChild(root_0, char_literal139_tree);
                    }
                    pushFollow(FOLLOW_declarator_in_directDeclarator2774);
                    inner=declarator();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inner.getTree());
                    char_literal140=(Token)match(input,35,FOLLOW_35_in_directDeclarator2776); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal140_tree = (Object)adaptor.create(char_literal140);
                    adaptor.addChild(root_0, char_literal140_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				retval.declarator = (inner!=null?inner.declarator:null);
                      				if (retval.declarator != null) {
                      					retval.declarator.setParenthesized(true);
                      				}
                      			
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1061:3: ( '[' ( expression | ) ']' | argList )*
            loop70:
            do {
                int alt70=3;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==55) ) {
                    alt70=1;
                }
                else if ( (LA70_0==34) ) {
                    alt70=2;
                }


                switch (alt70) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1062:4: '[' ( expression | ) ']'
            	    {
            	    char_literal141=(Token)match(input,55,FOLLOW_55_in_directDeclarator2792); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal141_tree = (Object)adaptor.create(char_literal141);
            	    adaptor.addChild(root_0, char_literal141_tree);
            	    }
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1063:4: ( expression | )
            	    int alt69=2;
            	    int LA69_0 = input.LA(1);

            	    if ( ((LA69_0>=DECIMAL_NUMBER && LA69_0<=FLOAT_NUMBER)||LA69_0==31||LA69_0==34||(LA69_0>=42 && LA69_0<=43)||LA69_0==51||(LA69_0>=53 && LA69_0<=55)||(LA69_0>=73 && LA69_0<=74)||(LA69_0>=86 && LA69_0<=89)) ) {
            	        alt69=1;
            	    }
            	    else if ( (LA69_0==56) ) {
            	        alt69=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 69, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt69) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1064:5: expression
            	            {
            	            pushFollow(FOLLOW_expression_in_directDeclarator2804);
            	            expression142=expression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression142.getTree());
            	            if ( state.backtracking==0 ) {

            	              					if (retval.declarator instanceof ArrayDeclarator)
            	              						((ArrayDeclarator)retval.declarator).addDimension((expression142!=null?expression142.expr:null));
            	              					else
            	              						retval.declarator = new ArrayDeclarator(retval.declarator, (expression142!=null?expression142.expr:null));
            	              				
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1069:9: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              					retval.declarator = new ArrayDeclarator(retval.declarator, new Expression.EmptyArraySize());
            	              				
            	            }

            	            }
            	            break;

            	    }

            	    char_literal143=(Token)match(input,56,FOLLOW_56_in_directDeclarator2820); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal143_tree = (Object)adaptor.create(char_literal143);
            	    adaptor.addChild(root_0, char_literal143_tree);
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1074:4: argList
            	    {
            	    pushFollow(FOLLOW_argList_in_directDeclarator2828);
            	    argList144=argList();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, argList144.getTree());
            	    if ( state.backtracking==0 ) {

            	      				retval.declarator = new FunctionDeclarator(retval.declarator, (argList144!=null?argList144.args:null));
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop70;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "directDeclarator"

    public static class argList_return extends ParserRuleReturnScope {
        public List<Arg> args;
        public boolean isObjC;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argList"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1080:1: argList returns [List<Arg> args, boolean isObjC] : op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')' ;
    public final ObjCppParser.argList_return argList() throws RecognitionException {
        ObjCppParser.argList_return retval = new ObjCppParser.argList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        Token cp=null;
        Token char_literal145=null;
        Token char_literal146=null;
        Token string_literal147=null;
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        Object op_tree=null;
        Object cp_tree=null;
        Object char_literal145_tree=null;
        Object char_literal146_tree=null;
        Object string_literal147_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1081:2: (op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1081:4: op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               
              			retval.isObjC = false; 
              			retval.args = new ArrayList<Arg>();
              		
            }
            op=(Token)match(input,34,FOLLOW_34_in_argList2856); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            op_tree = (Object)adaptor.create(op);
            adaptor.addChild(root_0, op_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1086:3: (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==IDENTIFIER||(LA73_0>=28 && LA73_0<=30)||LA73_0==34||LA73_0==44||(LA73_0>=48 && LA73_0<=50)||(LA73_0>=53 && LA73_0<=55)||LA73_0==58||LA73_0==60) ) {
                alt73=1;
            }
            else if ( (LA73_0==35) ) {
                int LA73_2 = input.LA(2);

                if ( (synpred98_ObjCpp()) ) {
                    alt73=1;
                }
            }
            switch (alt73) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1087:4: a1= argDef ( ',' ax= argDef )* ( ',' '...' )?
                    {
                    pushFollow(FOLLOW_argDef_in_argList2868);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {

                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					retval.args.add((a1!=null?a1.arg:null));
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1091:4: ( ',' ax= argDef )*
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==28) ) {
                            int LA71_1 = input.LA(2);

                            if ( (LA71_1==44) ) {
                                int LA71_3 = input.LA(3);

                                if ( (synpred96_ObjCpp()) ) {
                                    alt71=1;
                                }


                            }
                            else if ( (LA71_1==IDENTIFIER||(LA71_1>=28 && LA71_1<=30)||(LA71_1>=34 && LA71_1<=35)||(LA71_1>=48 && LA71_1<=50)||(LA71_1>=53 && LA71_1<=55)||LA71_1==58||LA71_1==60) ) {
                                alt71=1;
                            }


                        }


                        switch (alt71) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1092:5: ',' ax= argDef
                    	    {
                    	    char_literal145=(Token)match(input,28,FOLLOW_28_in_argList2881); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal145_tree = (Object)adaptor.create(char_literal145);
                    	    adaptor.addChild(root_0, char_literal145_tree);
                    	    }
                    	    pushFollow(FOLLOW_argDef_in_argList2890);
                    	    ax=argDef();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ax.getTree());
                    	    if ( state.backtracking==0 ) {

                    	      					retval.args.add((ax!=null?ax.arg:null));
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop71;
                        }
                    } while (true);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1097:4: ( ',' '...' )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==28) ) {
                        alt72=1;
                    }
                    switch (alt72) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1098:5: ',' '...'
                            {
                            char_literal146=(Token)match(input,28,FOLLOW_28_in_argList2910); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal146_tree = (Object)adaptor.create(char_literal146);
                            adaptor.addChild(root_0, char_literal146_tree);
                            }
                            string_literal147=(Token)match(input,44,FOLLOW_44_in_argList2912); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal147_tree = (Object)adaptor.create(string_literal147);
                            adaptor.addChild(root_0, string_literal147_tree);
                            }
                            if ( state.backtracking==0 ) {

                              					retval.isObjC = true;
                              					retval.args.add(Arg.createVarArgs());
                              				
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            cp=(Token)match(input,35,FOLLOW_35_in_argList2931); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            cp_tree = (Object)adaptor.create(cp);
            adaptor.addChild(root_0, cp_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "argList"

    public static class typeRefCore_return extends ParserRuleReturnScope {
        public TypeRef type;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeRefCore"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1127:1: typeRefCore returns [TypeRef type] : preMods= modifiers ( 'typename' pn= typeName | {...}? =>an= typeName | structCore | enumCore )? postMods= modifiers ;
    public final ObjCppParser.typeRefCore_return typeRefCore() throws RecognitionException {
        ObjCppParser.typeRefCore_return retval = new ObjCppParser.typeRefCore_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal148=null;
        ObjCppParser.modifiers_return preMods = null;

        ObjCppParser.typeName_return pn = null;

        ObjCppParser.typeName_return an = null;

        ObjCppParser.modifiers_return postMods = null;

        ObjCppParser.structCore_return structCore149 = null;

        ObjCppParser.enumCore_return enumCore150 = null;


        Object string_literal148_tree=null;


        	List<Modifier> modifiers = new ArrayList<Modifier>();
        	//TypeRef ref = null;
        	int line = -1;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1142:2: (preMods= modifiers ( 'typename' pn= typeName | {...}? =>an= typeName | structCore | enumCore )? postMods= modifiers )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1143:3: preMods= modifiers ( 'typename' pn= typeName | {...}? =>an= typeName | structCore | enumCore )? postMods= modifiers
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_modifiers_in_typeRefCore2964);
            preMods=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, preMods.getTree());
            if ( state.backtracking==0 ) {
               modifiers.addAll((preMods!=null?preMods.modifiers:null)); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1144:3: ( 'typename' pn= typeName | {...}? =>an= typeName | structCore | enumCore )?
            int alt74=5;
            switch ( input.LA(1) ) {
                case 60:
                    {
                    alt74=1;
                    }
                    break;
                case IDENTIFIER:
                    {
                    int LA74_2 = input.LA(2);

                    if ( ((synpred100_ObjCpp()&&( 
                    				isTypeIdentifier(next()) || 
                    				(
                    					Modifier.parseModifier(next(1)) == null && 
                    					!next(2, "=", ",", ";", ":", "[", "(")
                    				) 
                    			))) ) {
                        alt74=2;
                    }
                    }
                    break;
                case 48:
                case 49:
                case 50:
                    {
                    alt74=3;
                    }
                    break;
                case 30:
                    {
                    alt74=4;
                    }
                    break;
            }

            switch (alt74) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1145:4: 'typename' pn= typeName
                    {
                    string_literal148=(Token)match(input,60,FOLLOW_60_in_typeRefCore2975); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal148_tree = (Object)adaptor.create(string_literal148);
                    adaptor.addChild(root_0, string_literal148_tree);
                    }
                    pushFollow(FOLLOW_typeName_in_typeRefCore2979);
                    pn=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pn.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (pn!=null?pn.type:null); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1146:4: {...}? =>an= typeName
                    {
                    if ( !(( 
                    				isTypeIdentifier(next()) || 
                    				(
                    					Modifier.parseModifier(next(1)) == null && 
                    					!next(2, "=", ",", ";", ":", "[", "(")
                    				) 
                    			)) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeRefCore", " \n\t\t\t\tisTypeIdentifier(next()) || \n\t\t\t\t(\n\t\t\t\t\tModifier.parseModifier(next(1)) == null && \n\t\t\t\t\t!next(2, \"=\", \",\", \";\", \":\", \"[\", \"(\")\n\t\t\t\t) \n\t\t\t");
                    }
                    pushFollow(FOLLOW_typeName_in_typeRefCore2993);
                    an=typeName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, an.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (an!=null?an.type:null); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1153:4: structCore
                    {
                    pushFollow(FOLLOW_structCore_in_typeRefCore3002);
                    structCore149=structCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structCore149.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (structCore149!=null?structCore149.struct:null); 
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1154:4: enumCore
                    {
                    pushFollow(FOLLOW_enumCore_in_typeRefCore3011);
                    enumCore150=enumCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, enumCore150.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (enumCore150!=null?enumCore150.e:null); 
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_modifiers_in_typeRefCore3024);
            postMods=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, postMods.getTree());
            if ( state.backtracking==0 ) {
               modifiers.addAll((postMods!=null?postMods.modifiers:null)); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

              	if (retval.type == null && !modifiers.isEmpty()) {
              		retval.type = new Primitive(null);
              	}
              	if (retval.type != null) {
              		retval.type.addModifiers(modifiers);
              		mark(retval.type, line);
              	}

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "typeRefCore"

    public static class typeName_return extends ParserRuleReturnScope {
        public TypeRef type;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeName"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1159:1: typeName returns [TypeRef type] : i= IDENTIFIER ( '<' (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )? '>' )? ;
    public final ObjCppParser.typeName_return typeName() throws RecognitionException {
        ObjCppParser.typeName_return retval = new ObjCppParser.typeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token i=null;
        Token char_literal151=null;
        Token char_literal152=null;
        Token char_literal153=null;
        ObjCppParser.mutableTypeRef_return t1 = null;

        ObjCppParser.mutableTypeRef_return tx = null;


        Object i_tree=null;
        Object char_literal151_tree=null;
        Object char_literal152_tree=null;
        Object char_literal153_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1160:2: (i= IDENTIFIER ( '<' (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )? '>' )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1161:3: i= IDENTIFIER ( '<' (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )? '>' )?
            {
            root_0 = (Object)adaptor.nil();

            i=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_typeName3046); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            i_tree = (Object)adaptor.create(i);
            adaptor.addChild(root_0, i_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.type = mark(isPrimitiveType((i!=null?i.getText():null)) ? new Primitive((i!=null?i.getText():null)) : new SimpleTypeRef((i!=null?i.getText():null)), getLine(i));
              			((Symbols_scope)Symbols_stack.peek()).typeIdentifiers.add((i!=null?i.getText():null));
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1165:3: ( '<' (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )? '>' )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==36) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1166:4: '<' (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )? '>'
                    {
                    char_literal151=(Token)match(input,36,FOLLOW_36_in_typeName3058); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal151_tree = (Object)adaptor.create(char_literal151);
                    adaptor.addChild(root_0, char_literal151_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.type = new TemplateRef((i!=null?i.getText():null)); 
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1167:5: (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )?
                    int alt76=2;
                    int LA76_0 = input.LA(1);

                    if ( (LA76_0==IDENTIFIER||LA76_0==28||LA76_0==30||LA76_0==34||(LA76_0>=48 && LA76_0<=50)||(LA76_0>=53 && LA76_0<=55)||LA76_0==60) ) {
                        alt76=1;
                    }
                    else if ( (LA76_0==37) ) {
                        int LA76_2 = input.LA(2);

                        if ( (synpred104_ObjCpp()) ) {
                            alt76=1;
                        }
                    }
                    switch (alt76) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1168:6: t1= mutableTypeRef ( ',' tx= mutableTypeRef )*
                            {
                            pushFollow(FOLLOW_mutableTypeRef_in_typeName3075);
                            t1=mutableTypeRef();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, t1.getTree());
                            if ( state.backtracking==0 ) {
                               ((TemplateRef)retval.type).addParameter((t1!=null?t1.type:null)); 
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1169:6: ( ',' tx= mutableTypeRef )*
                            loop75:
                            do {
                                int alt75=2;
                                int LA75_0 = input.LA(1);

                                if ( (LA75_0==28) ) {
                                    alt75=1;
                                }


                                switch (alt75) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1170:7: ',' tx= mutableTypeRef
                            	    {
                            	    char_literal152=(Token)match(input,28,FOLLOW_28_in_typeName3092); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    char_literal152_tree = (Object)adaptor.create(char_literal152);
                            	    adaptor.addChild(root_0, char_literal152_tree);
                            	    }
                            	    pushFollow(FOLLOW_mutableTypeRef_in_typeName3103);
                            	    tx=mutableTypeRef();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, tx.getTree());
                            	    if ( state.backtracking==0 ) {
                            	       ((TemplateRef)retval.type).addParameter((tx!=null?tx.type:null)); 
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop75;
                                }
                            } while (true);


                            }
                            break;

                    }

                    char_literal153=(Token)match(input,37,FOLLOW_37_in_typeName3125); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal153_tree = (Object)adaptor.create(char_literal153);
                    adaptor.addChild(root_0, char_literal153_tree);
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "typeName"

    public static class objCMethodCall_return extends ParserRuleReturnScope {
        public FunctionCall expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "objCMethodCall"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1178:1: objCMethodCall returns [FunctionCall expr] : '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']' ;
    public final ObjCppParser.objCMethodCall_return objCMethodCall() throws RecognitionException {
        ObjCppParser.objCMethodCall_return retval = new ObjCppParser.objCMethodCall_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token methodName=null;
        Token selx=null;
        Token char_literal154=null;
        Token char_literal155=null;
        Token char_literal156=null;
        Token char_literal157=null;
        ObjCppParser.expression_return target = null;

        ObjCppParser.expression_return arg1 = null;

        ObjCppParser.expression_return argx = null;


        Object methodName_tree=null;
        Object selx_tree=null;
        Object char_literal154_tree=null;
        Object char_literal155_tree=null;
        Object char_literal156_tree=null;
        Object char_literal157_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1179:2: ( '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1180:3: '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']'
            {
            root_0 = (Object)adaptor.nil();

            char_literal154=(Token)match(input,55,FOLLOW_55_in_objCMethodCall3149); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal154_tree = (Object)adaptor.create(char_literal154);
            adaptor.addChild(root_0, char_literal154_tree);
            }
            pushFollow(FOLLOW_expression_in_objCMethodCall3153);
            target=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, target.getTree());
            methodName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodCall3157); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            methodName_tree = (Object)adaptor.create(methodName);
            adaptor.addChild(root_0, methodName_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.expr = new FunctionCall();
              			retval.expr.setFunction(new VariableRef((methodName!=null?methodName.getText():null)));
              			retval.expr.setTarget((target!=null?target.expr:null));
              			retval.expr.setMemberRefStyle(MemberRefStyle.SquareBrackets);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1186:3: ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==33) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1187:4: ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )*
                    {
                    char_literal155=(Token)match(input,33,FOLLOW_33_in_objCMethodCall3168); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal155_tree = (Object)adaptor.create(char_literal155);
                    adaptor.addChild(root_0, char_literal155_tree);
                    }
                    pushFollow(FOLLOW_expression_in_objCMethodCall3172);
                    arg1=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arg1.getTree());
                    if ( state.backtracking==0 ) {

                      				retval.expr.addArgument(null, (arg1!=null?arg1.expr:null));
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1190:4: (selx= IDENTIFIER ':' argx= expression )*
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==IDENTIFIER) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1191:5: selx= IDENTIFIER ':' argx= expression
                    	    {
                    	    selx=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodCall3187); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    selx_tree = (Object)adaptor.create(selx);
                    	    adaptor.addChild(root_0, selx_tree);
                    	    }
                    	    char_literal156=(Token)match(input,33,FOLLOW_33_in_objCMethodCall3189); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal156_tree = (Object)adaptor.create(char_literal156);
                    	    adaptor.addChild(root_0, char_literal156_tree);
                    	    }
                    	    pushFollow(FOLLOW_expression_in_objCMethodCall3193);
                    	    argx=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, argx.getTree());
                    	    if ( state.backtracking==0 ) {

                    	      					retval.expr.addArgument((selx!=null?selx.getText():null), (argx!=null?argx.expr:null));
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop78;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal157=(Token)match(input,56,FOLLOW_56_in_objCMethodCall3210); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal157_tree = (Object)adaptor.create(char_literal157);
            adaptor.addChild(root_0, char_literal157_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "objCMethodCall"

    public static class functionCall_return extends ParserRuleReturnScope {
        public FunctionCall expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionCall"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1199:1: functionCall returns [FunctionCall expr] : IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')' ;
    public final ObjCppParser.functionCall_return functionCall() throws RecognitionException {
        ObjCppParser.functionCall_return retval = new ObjCppParser.functionCall_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER158=null;
        Token char_literal159=null;
        Token char_literal160=null;
        Token char_literal161=null;
        ObjCppParser.expression_return a1 = null;

        ObjCppParser.expression_return ax = null;


        Object IDENTIFIER158_tree=null;
        Object char_literal159_tree=null;
        Object char_literal160_tree=null;
        Object char_literal161_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1200:2: ( IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1201:3: IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')'
            {
            root_0 = (Object)adaptor.nil();

            IDENTIFIER158=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionCall3230); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER158_tree = (Object)adaptor.create(IDENTIFIER158);
            adaptor.addChild(root_0, IDENTIFIER158_tree);
            }
            char_literal159=(Token)match(input,34,FOLLOW_34_in_functionCall3232); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal159_tree = (Object)adaptor.create(char_literal159);
            adaptor.addChild(root_0, char_literal159_tree);
            }
            if ( state.backtracking==0 ) {

              			FunctionCall fc = new FunctionCall();
              			fc.setFunction(new VariableRef((IDENTIFIER158!=null?IDENTIFIER158.getText():null)));
              			retval.expr = fc;
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1206:3: (a1= expression ( ',' ax= expression )* )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( ((LA81_0>=DECIMAL_NUMBER && LA81_0<=FLOAT_NUMBER)||LA81_0==31||LA81_0==34||(LA81_0>=42 && LA81_0<=43)||LA81_0==51||(LA81_0>=53 && LA81_0<=55)||(LA81_0>=73 && LA81_0<=74)||(LA81_0>=86 && LA81_0<=89)) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1207:4: a1= expression ( ',' ax= expression )*
                    {
                    pushFollow(FOLLOW_expression_in_functionCall3245);
                    a1=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {

                      				retval.expr.addArgument((a1!=null?a1.expr:null));
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1210:4: ( ',' ax= expression )*
                    loop80:
                    do {
                        int alt80=2;
                        int LA80_0 = input.LA(1);

                        if ( (LA80_0==28) ) {
                            alt80=1;
                        }


                        switch (alt80) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1210:6: ',' ax= expression
                    	    {
                    	    char_literal160=(Token)match(input,28,FOLLOW_28_in_functionCall3254); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal160_tree = (Object)adaptor.create(char_literal160);
                    	    adaptor.addChild(root_0, char_literal160_tree);
                    	    }
                    	    pushFollow(FOLLOW_expression_in_functionCall3263);
                    	    ax=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ax.getTree());
                    	    if ( state.backtracking==0 ) {

                    	      					retval.expr.addArgument((ax!=null?ax.expr:null));
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop80;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal161=(Token)match(input,35,FOLLOW_35_in_functionCall3281); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal161_tree = (Object)adaptor.create(char_literal161);
            adaptor.addChild(root_0, char_literal161_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionCall"

    public static class binaryOp_return extends ParserRuleReturnScope {
        public Expression.BinaryOperator op;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "binaryOp"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1220:1: binaryOp returns [Expression.BinaryOperator op] : t= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) ;
    public final ObjCppParser.binaryOp_return binaryOp() throws RecognitionException {
        ObjCppParser.binaryOp_return retval = new ObjCppParser.binaryOp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token t=null;

        Object t_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1221:2: (t= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1221:5: t= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' )
            {
            root_0 = (Object)adaptor.nil();

            t=(Token)input.LT(1);
            if ( (input.LA(1)>=36 && input.LA(1)<=37)||(input.LA(1)>=42 && input.LA(1)<=43)||(input.LA(1)>=53 && input.LA(1)<=54)||input.LA(1)==58||(input.LA(1)>=61 && input.LA(1)<=72) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(t));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {

              			retval.op = Expression.getBinaryOperator((t!=null?t.getText():null));
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "binaryOp"

    public static class baseExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "baseExpression"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1231:1: baseExpression returns [Expression expr] : ( IDENTIFIER | constant | '(' expression ')' | objCMethodCall | selectorExpr | protocolExpr | encodingExpr );
    public final ObjCppParser.baseExpression_return baseExpression() throws RecognitionException {
        ObjCppParser.baseExpression_return retval = new ObjCppParser.baseExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER162=null;
        Token char_literal164=null;
        Token char_literal166=null;
        ObjCppParser.constant_return constant163 = null;

        ObjCppParser.expression_return expression165 = null;

        ObjCppParser.objCMethodCall_return objCMethodCall167 = null;

        ObjCppParser.selectorExpr_return selectorExpr168 = null;

        ObjCppParser.protocolExpr_return protocolExpr169 = null;

        ObjCppParser.encodingExpr_return encodingExpr170 = null;


        Object IDENTIFIER162_tree=null;
        Object char_literal164_tree=null;
        Object char_literal166_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1232:2: ( IDENTIFIER | constant | '(' expression ')' | objCMethodCall | selectorExpr | protocolExpr | encodingExpr )
            int alt82=7;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt82=1;
                }
                break;
            case DECIMAL_NUMBER:
            case STRING:
            case HEXADECIMAL_NUMBER:
            case OCTAL_NUMBER:
            case CHARACTER:
            case FLOAT_NUMBER:
            case 42:
            case 43:
                {
                alt82=2;
                }
                break;
            case 34:
                {
                alt82=3;
                }
                break;
            case 55:
                {
                alt82=4;
                }
                break;
            case 73:
                {
                alt82=5;
                }
                break;
            case 31:
                {
                alt82=6;
                }
                break;
            case 74:
                {
                alt82=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }

            switch (alt82) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1233:3: IDENTIFIER
                    {
                    root_0 = (Object)adaptor.nil();

                    IDENTIFIER162=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_baseExpression3407); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER162_tree = (Object)adaptor.create(IDENTIFIER162);
                    adaptor.addChild(root_0, IDENTIFIER162_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.expr = new VariableRef((IDENTIFIER162!=null?IDENTIFIER162.getText():null)); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1234:3: constant
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_constant_in_baseExpression3415);
                    constant163=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant163.getTree());
                    if ( state.backtracking==0 ) {
                       retval.expr = (constant163!=null?constant163.constant:null); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1235:3: '(' expression ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal164=(Token)match(input,34,FOLLOW_34_in_baseExpression3423); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal164_tree = (Object)adaptor.create(char_literal164);
                    adaptor.addChild(root_0, char_literal164_tree);
                    }
                    pushFollow(FOLLOW_expression_in_baseExpression3425);
                    expression165=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression165.getTree());
                    char_literal166=(Token)match(input,35,FOLLOW_35_in_baseExpression3427); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal166_tree = (Object)adaptor.create(char_literal166);
                    adaptor.addChild(root_0, char_literal166_tree);
                    }
                    if ( state.backtracking==0 ) {
                       
                      			retval.expr = (expression165!=null?expression165.expr:null); 
                      			if (retval.expr != null)
                      				retval.expr.setParenthesis(true);
                      		
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1240:3: objCMethodCall
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_objCMethodCall_in_baseExpression3435);
                    objCMethodCall167=objCMethodCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, objCMethodCall167.getTree());
                    if ( state.backtracking==0 ) {
                       retval.expr = (objCMethodCall167!=null?objCMethodCall167.expr:null); 
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1241:3: selectorExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_selectorExpr_in_baseExpression3443);
                    selectorExpr168=selectorExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, selectorExpr168.getTree());

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1242:3: protocolExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_protocolExpr_in_baseExpression3449);
                    protocolExpr169=protocolExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, protocolExpr169.getTree());

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1243:3: encodingExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_encodingExpr_in_baseExpression3455);
                    encodingExpr170=encodingExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, encodingExpr170.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "baseExpression"

    public static class selectorExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "selectorExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1246:1: selectorExpr returns [Expression expr] : '@selector' '(' selectorName ')' ;
    public final ObjCppParser.selectorExpr_return selectorExpr() throws RecognitionException {
        ObjCppParser.selectorExpr_return retval = new ObjCppParser.selectorExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal171=null;
        Token char_literal172=null;
        Token char_literal174=null;
        ObjCppParser.selectorName_return selectorName173 = null;


        Object string_literal171_tree=null;
        Object char_literal172_tree=null;
        Object char_literal174_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1247:2: ( '@selector' '(' selectorName ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1247:4: '@selector' '(' selectorName ')'
            {
            root_0 = (Object)adaptor.nil();

            string_literal171=(Token)match(input,73,FOLLOW_73_in_selectorExpr3471); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal171_tree = (Object)adaptor.create(string_literal171);
            adaptor.addChild(root_0, string_literal171_tree);
            }
            char_literal172=(Token)match(input,34,FOLLOW_34_in_selectorExpr3476); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal172_tree = (Object)adaptor.create(char_literal172);
            adaptor.addChild(root_0, char_literal172_tree);
            }
            pushFollow(FOLLOW_selectorName_in_selectorExpr3481);
            selectorName173=selectorName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, selectorName173.getTree());
            char_literal174=(Token)match(input,35,FOLLOW_35_in_selectorExpr3486); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal174_tree = (Object)adaptor.create(char_literal174);
            adaptor.addChild(root_0, char_literal174_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "selectorExpr"

    public static class selectorName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "selectorName"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1253:1: selectorName : IDENTIFIER ( IDENTIFIER ':' )* ;
    public final ObjCppParser.selectorName_return selectorName() throws RecognitionException {
        ObjCppParser.selectorName_return retval = new ObjCppParser.selectorName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER175=null;
        Token IDENTIFIER176=null;
        Token char_literal177=null;

        Object IDENTIFIER175_tree=null;
        Object IDENTIFIER176_tree=null;
        Object char_literal177_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1254:2: ( IDENTIFIER ( IDENTIFIER ':' )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1254:4: IDENTIFIER ( IDENTIFIER ':' )*
            {
            root_0 = (Object)adaptor.nil();

            IDENTIFIER175=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_selectorName3497); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER175_tree = (Object)adaptor.create(IDENTIFIER175);
            adaptor.addChild(root_0, IDENTIFIER175_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1254:15: ( IDENTIFIER ':' )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==IDENTIFIER) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1254:16: IDENTIFIER ':'
            	    {
            	    IDENTIFIER176=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_selectorName3500); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDENTIFIER176_tree = (Object)adaptor.create(IDENTIFIER176);
            	    adaptor.addChild(root_0, IDENTIFIER176_tree);
            	    }
            	    char_literal177=(Token)match(input,33,FOLLOW_33_in_selectorName3502); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal177_tree = (Object)adaptor.create(char_literal177);
            	    adaptor.addChild(root_0, char_literal177_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop83;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "selectorName"

    public static class protocolExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "protocolExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1257:1: protocolExpr : '@protocol' '(' IDENTIFIER ')' ;
    public final ObjCppParser.protocolExpr_return protocolExpr() throws RecognitionException {
        ObjCppParser.protocolExpr_return retval = new ObjCppParser.protocolExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal178=null;
        Token char_literal179=null;
        Token IDENTIFIER180=null;
        Token char_literal181=null;

        Object string_literal178_tree=null;
        Object char_literal179_tree=null;
        Object IDENTIFIER180_tree=null;
        Object char_literal181_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1258:2: ( '@protocol' '(' IDENTIFIER ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1258:4: '@protocol' '(' IDENTIFIER ')'
            {
            root_0 = (Object)adaptor.nil();

            string_literal178=(Token)match(input,31,FOLLOW_31_in_protocolExpr3515); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal178_tree = (Object)adaptor.create(string_literal178);
            adaptor.addChild(root_0, string_literal178_tree);
            }
            char_literal179=(Token)match(input,34,FOLLOW_34_in_protocolExpr3519); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal179_tree = (Object)adaptor.create(char_literal179);
            adaptor.addChild(root_0, char_literal179_tree);
            }
            IDENTIFIER180=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_protocolExpr3523); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER180_tree = (Object)adaptor.create(IDENTIFIER180);
            adaptor.addChild(root_0, IDENTIFIER180_tree);
            }
            char_literal181=(Token)match(input,35,FOLLOW_35_in_protocolExpr3527); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal181_tree = (Object)adaptor.create(char_literal181);
            adaptor.addChild(root_0, char_literal181_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "protocolExpr"

    public static class encodingExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "encodingExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1264:1: encodingExpr : '@encode' '(' IDENTIFIER ')' ;
    public final ObjCppParser.encodingExpr_return encodingExpr() throws RecognitionException {
        ObjCppParser.encodingExpr_return retval = new ObjCppParser.encodingExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal182=null;
        Token char_literal183=null;
        Token IDENTIFIER184=null;
        Token char_literal185=null;

        Object string_literal182_tree=null;
        Object char_literal183_tree=null;
        Object IDENTIFIER184_tree=null;
        Object char_literal185_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1265:2: ( '@encode' '(' IDENTIFIER ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1265:4: '@encode' '(' IDENTIFIER ')'
            {
            root_0 = (Object)adaptor.nil();

            string_literal182=(Token)match(input,74,FOLLOW_74_in_encodingExpr3538); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal182_tree = (Object)adaptor.create(string_literal182);
            adaptor.addChild(root_0, string_literal182_tree);
            }
            char_literal183=(Token)match(input,34,FOLLOW_34_in_encodingExpr3543); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal183_tree = (Object)adaptor.create(char_literal183);
            adaptor.addChild(root_0, char_literal183_tree);
            }
            IDENTIFIER184=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_encodingExpr3547); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER184_tree = (Object)adaptor.create(IDENTIFIER184);
            adaptor.addChild(root_0, IDENTIFIER184_tree);
            }
            char_literal185=(Token)match(input,35,FOLLOW_35_in_encodingExpr3552); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal185_tree = (Object)adaptor.create(char_literal185);
            adaptor.addChild(root_0, char_literal185_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "encodingExpr"

    public static class assignmentExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignmentExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1271:1: assignmentExpr returns [Expression expr] : e= inlineCondExpr (op= assignmentOp f= assignmentExpr )? ;
    public final ObjCppParser.assignmentExpr_return assignmentExpr() throws RecognitionException {
        ObjCppParser.assignmentExpr_return retval = new ObjCppParser.assignmentExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.inlineCondExpr_return e = null;

        ObjCppParser.assignmentOp_return op = null;

        ObjCppParser.assignmentExpr_return f = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1272:2: (e= inlineCondExpr (op= assignmentOp f= assignmentExpr )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1272:4: e= inlineCondExpr (op= assignmentOp f= assignmentExpr )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_inlineCondExpr_in_assignmentExpr3569);
            e=inlineCondExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1273:3: (op= assignmentOp f= assignmentExpr )?
            int alt84=2;
            alt84 = dfa84.predict(input);
            switch (alt84) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1274:4: op= assignmentOp f= assignmentExpr
                    {
                    pushFollow(FOLLOW_assignmentOp_in_assignmentExpr3585);
                    op=assignmentOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, op.getTree());
                    pushFollow(FOLLOW_assignmentExpr_in_assignmentExpr3589);
                    f=assignmentExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( state.backtracking==0 ) {
                       retval.expr = new AssignmentOp(retval.expr, getAssignmentOperator((op!=null?input.toString(op.start,op.stop):null)), (f!=null?f.expr:null)); 
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assignmentExpr"

    public static class assignmentOp_return extends ParserRuleReturnScope {
        public Expression.AssignmentOperator op;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignmentOp"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1278:1: assignmentOp returns [Expression.AssignmentOperator op] : t= ( '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=' ) ;
    public final ObjCppParser.assignmentOp_return assignmentOp() throws RecognitionException {
        ObjCppParser.assignmentOp_return retval = new ObjCppParser.assignmentOp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token t=null;

        Object t_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1279:2: (t= ( '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1279:5: t= ( '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=' )
            {
            root_0 = (Object)adaptor.nil();

            t=(Token)input.LT(1);
            if ( input.LA(1)==29||(input.LA(1)>=75 && input.LA(1)<=84) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(t));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {

              			retval.op = getAssignmentOperator((t!=null?t.getText():null));
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assignmentOp"

    public static class inlineCondExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inlineCondExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1284:1: inlineCondExpr returns [Expression expr] : e= logOrExpr ( '?' logOrExpr ':' logOrExpr )* ;
    public final ObjCppParser.inlineCondExpr_return inlineCondExpr() throws RecognitionException {
        ObjCppParser.inlineCondExpr_return retval = new ObjCppParser.inlineCondExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal186=null;
        Token char_literal188=null;
        ObjCppParser.logOrExpr_return e = null;

        ObjCppParser.logOrExpr_return logOrExpr187 = null;

        ObjCppParser.logOrExpr_return logOrExpr189 = null;


        Object char_literal186_tree=null;
        Object char_literal188_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1285:2: (e= logOrExpr ( '?' logOrExpr ':' logOrExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1285:4: e= logOrExpr ( '?' logOrExpr ':' logOrExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_logOrExpr_in_inlineCondExpr3676);
            e=logOrExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1286:3: ( '?' logOrExpr ':' logOrExpr )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==85) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1287:4: '?' logOrExpr ':' logOrExpr
            	    {
            	    char_literal186=(Token)match(input,85,FOLLOW_85_in_inlineCondExpr3688); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal186_tree = (Object)adaptor.create(char_literal186);
            	    adaptor.addChild(root_0, char_literal186_tree);
            	    }
            	    pushFollow(FOLLOW_logOrExpr_in_inlineCondExpr3693);
            	    logOrExpr187=logOrExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logOrExpr187.getTree());
            	    char_literal188=(Token)match(input,33,FOLLOW_33_in_inlineCondExpr3699); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal188_tree = (Object)adaptor.create(char_literal188);
            	    adaptor.addChild(root_0, char_literal188_tree);
            	    }
            	    pushFollow(FOLLOW_logOrExpr_in_inlineCondExpr3704);
            	    logOrExpr189=logOrExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logOrExpr189.getTree());

            	    }
            	    break;

            	default :
            	    break loop85;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "inlineCondExpr"

    public static class addExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "addExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1294:1: addExpr returns [Expression expr] : e= multExpr (op= ( '+' | '-' ) f= multExpr )* ;
    public final ObjCppParser.addExpr_return addExpr() throws RecognitionException {
        ObjCppParser.addExpr_return retval = new ObjCppParser.addExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ObjCppParser.multExpr_return e = null;

        ObjCppParser.multExpr_return f = null;


        Object op_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1295:2: (e= multExpr (op= ( '+' | '-' ) f= multExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1295:4: e= multExpr (op= ( '+' | '-' ) f= multExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_multExpr_in_addExpr3726);
            e=multExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1296:3: (op= ( '+' | '-' ) f= multExpr )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( ((LA86_0>=42 && LA86_0<=43)) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1297:4: op= ( '+' | '-' ) f= multExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=42 && input.LA(1)<=43) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(op));
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_multExpr_in_addExpr3752);
            	    f=multExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.expr = new BinaryOp(retval.expr, getBinaryOperator((op!=null?op.getText():null)), (f!=null?f.expr:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop86;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "addExpr"

    public static class multExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1302:1: multExpr returns [Expression expr] : e= castExpr (op= ( '%' | '*' | '/' ) f= castExpr )* ;
    public final ObjCppParser.multExpr_return multExpr() throws RecognitionException {
        ObjCppParser.multExpr_return retval = new ObjCppParser.multExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ObjCppParser.castExpr_return e = null;

        ObjCppParser.castExpr_return f = null;


        Object op_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1303:2: (e= castExpr (op= ( '%' | '*' | '/' ) f= castExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1303:4: e= castExpr (op= ( '%' | '*' | '/' ) f= castExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_castExpr_in_multExpr3776);
            e=castExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1304:3: (op= ( '%' | '*' | '/' ) f= castExpr )*
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==53||(LA87_0>=61 && LA87_0<=62)) ) {
                    alt87=1;
                }


                switch (alt87) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1305:4: op= ( '%' | '*' | '/' ) f= castExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( input.LA(1)==53||(input.LA(1)>=61 && input.LA(1)<=62) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(op));
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_castExpr_in_multExpr3808);
            	    f=castExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.expr = new BinaryOp(retval.expr, getBinaryOperator((op!=null?op.getText():null)), (f!=null?f.expr:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop87;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "multExpr"

    public static class bitOrExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bitOrExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1310:1: bitOrExpr returns [Expression expr] : e= xorExpr (op= '|' f= xorExpr )* ;
    public final ObjCppParser.bitOrExpr_return bitOrExpr() throws RecognitionException {
        ObjCppParser.bitOrExpr_return retval = new ObjCppParser.bitOrExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ObjCppParser.xorExpr_return e = null;

        ObjCppParser.xorExpr_return f = null;


        Object op_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1311:2: (e= xorExpr (op= '|' f= xorExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1311:4: e= xorExpr (op= '|' f= xorExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_xorExpr_in_bitOrExpr3832);
            e=xorExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1312:3: (op= '|' f= xorExpr )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==67) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1313:4: op= '|' f= xorExpr
            	    {
            	    op=(Token)match(input,67,FOLLOW_67_in_bitOrExpr3846); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    adaptor.addChild(root_0, op_tree);
            	    }
            	    pushFollow(FOLLOW_xorExpr_in_bitOrExpr3853);
            	    f=xorExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.expr = new BinaryOp(retval.expr, getBinaryOperator((op!=null?op.getText():null)), (f!=null?f.expr:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop88;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bitOrExpr"

    public static class bitAndExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bitAndExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1318:1: bitAndExpr returns [Expression expr] : e= equalExpr (op= '&' f= equalExpr )* ;
    public final ObjCppParser.bitAndExpr_return bitAndExpr() throws RecognitionException {
        ObjCppParser.bitAndExpr_return retval = new ObjCppParser.bitAndExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ObjCppParser.equalExpr_return e = null;

        ObjCppParser.equalExpr_return f = null;


        Object op_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1319:2: (e= equalExpr (op= '&' f= equalExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1319:4: e= equalExpr (op= '&' f= equalExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_equalExpr_in_bitAndExpr3877);
            e=equalExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1320:3: (op= '&' f= equalExpr )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==54) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1321:4: op= '&' f= equalExpr
            	    {
            	    op=(Token)match(input,54,FOLLOW_54_in_bitAndExpr3890); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    adaptor.addChild(root_0, op_tree);
            	    }
            	    pushFollow(FOLLOW_equalExpr_in_bitAndExpr3897);
            	    f=equalExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.expr = new BinaryOp(retval.expr, getBinaryOperator((op!=null?op.getText():null)), (f!=null?f.expr:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop89;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bitAndExpr"

    public static class shiftExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "shiftExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1327:1: shiftExpr returns [Expression expr] : e= addExpr (op= ( '>>' | '<<' ) f= addExpr )* ;
    public final ObjCppParser.shiftExpr_return shiftExpr() throws RecognitionException {
        ObjCppParser.shiftExpr_return retval = new ObjCppParser.shiftExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ObjCppParser.addExpr_return e = null;

        ObjCppParser.addExpr_return f = null;


        Object op_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1328:2: (e= addExpr (op= ( '>>' | '<<' ) f= addExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1328:4: e= addExpr (op= ( '>>' | '<<' ) f= addExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_addExpr_in_shiftExpr3922);
            e=addExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1329:3: (op= ( '>>' | '<<' ) f= addExpr )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==63||LA90_0==65) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1330:4: op= ( '>>' | '<<' ) f= addExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( input.LA(1)==63||input.LA(1)==65 ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(op));
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_addExpr_in_shiftExpr3948);
            	    f=addExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.expr = new BinaryOp(retval.expr, getBinaryOperator((op!=null?op.getText():null)), (f!=null?f.expr:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop90;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "shiftExpr"

    public static class xorExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "xorExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1335:1: xorExpr returns [Expression expr] : e= bitAndExpr (op= '^' f= bitAndExpr )* ;
    public final ObjCppParser.xorExpr_return xorExpr() throws RecognitionException {
        ObjCppParser.xorExpr_return retval = new ObjCppParser.xorExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ObjCppParser.bitAndExpr_return e = null;

        ObjCppParser.bitAndExpr_return f = null;


        Object op_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1336:2: (e= bitAndExpr (op= '^' f= bitAndExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1336:4: e= bitAndExpr (op= '^' f= bitAndExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_bitAndExpr_in_xorExpr3972);
            e=bitAndExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1337:3: (op= '^' f= bitAndExpr )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==58) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1338:4: op= '^' f= bitAndExpr
            	    {
            	    op=(Token)match(input,58,FOLLOW_58_in_xorExpr3985); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    adaptor.addChild(root_0, op_tree);
            	    }
            	    pushFollow(FOLLOW_bitAndExpr_in_xorExpr3992);
            	    f=bitAndExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.expr = new BinaryOp(retval.expr, getBinaryOperator((op!=null?op.getText():null)), (f!=null?f.expr:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop91;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "xorExpr"

    public static class logOrExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logOrExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1343:1: logOrExpr returns [Expression expr] : e= logAndExpr (op= '||' f= logAndExpr )* ;
    public final ObjCppParser.logOrExpr_return logOrExpr() throws RecognitionException {
        ObjCppParser.logOrExpr_return retval = new ObjCppParser.logOrExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ObjCppParser.logAndExpr_return e = null;

        ObjCppParser.logAndExpr_return f = null;


        Object op_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1344:2: (e= logAndExpr (op= '||' f= logAndExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1344:4: e= logAndExpr (op= '||' f= logAndExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_logAndExpr_in_logOrExpr4016);
            e=logAndExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1345:3: (op= '||' f= logAndExpr )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==66) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1346:4: op= '||' f= logAndExpr
            	    {
            	    op=(Token)match(input,66,FOLLOW_66_in_logOrExpr4029); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    adaptor.addChild(root_0, op_tree);
            	    }
            	    pushFollow(FOLLOW_logAndExpr_in_logOrExpr4036);
            	    f=logAndExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.expr = new BinaryOp(retval.expr, getBinaryOperator((op!=null?op.getText():null)), (f!=null?f.expr:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop92;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "logOrExpr"

    public static class logAndExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logAndExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1351:1: logAndExpr returns [Expression expr] : e= bitOrExpr (op= '&&' f= bitOrExpr )* ;
    public final ObjCppParser.logAndExpr_return logAndExpr() throws RecognitionException {
        ObjCppParser.logAndExpr_return retval = new ObjCppParser.logAndExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ObjCppParser.bitOrExpr_return e = null;

        ObjCppParser.bitOrExpr_return f = null;


        Object op_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1352:2: (e= bitOrExpr (op= '&&' f= bitOrExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1352:4: e= bitOrExpr (op= '&&' f= bitOrExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_bitOrExpr_in_logAndExpr4060);
            e=bitOrExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1353:3: (op= '&&' f= bitOrExpr )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==68) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1354:4: op= '&&' f= bitOrExpr
            	    {
            	    op=(Token)match(input,68,FOLLOW_68_in_logAndExpr4073); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    adaptor.addChild(root_0, op_tree);
            	    }
            	    pushFollow(FOLLOW_bitOrExpr_in_logAndExpr4080);
            	    f=bitOrExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.expr = new BinaryOp(retval.expr, getBinaryOperator((op!=null?op.getText():null)), (f!=null?f.expr:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop93;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "logAndExpr"

    public static class equalExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "equalExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1359:1: equalExpr returns [Expression expr] : e= compareExpr (op= ( '!=' | '==' ) f= compareExpr )* ;
    public final ObjCppParser.equalExpr_return equalExpr() throws RecognitionException {
        ObjCppParser.equalExpr_return retval = new ObjCppParser.equalExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ObjCppParser.compareExpr_return e = null;

        ObjCppParser.compareExpr_return f = null;


        Object op_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1360:2: (e= compareExpr (op= ( '!=' | '==' ) f= compareExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1360:4: e= compareExpr (op= ( '!=' | '==' ) f= compareExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_compareExpr_in_equalExpr4104);
            e=compareExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1361:3: (op= ( '!=' | '==' ) f= compareExpr )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( ((LA94_0>=71 && LA94_0<=72)) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1362:4: op= ( '!=' | '==' ) f= compareExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=71 && input.LA(1)<=72) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(op));
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_compareExpr_in_equalExpr4130);
            	    f=compareExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.expr = new BinaryOp(retval.expr, getBinaryOperator((op!=null?op.getText():null)), (f!=null?f.expr:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop94;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "equalExpr"

    public static class compareExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compareExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1367:1: compareExpr returns [Expression expr] : e= shiftExpr (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )* ;
    public final ObjCppParser.compareExpr_return compareExpr() throws RecognitionException {
        ObjCppParser.compareExpr_return retval = new ObjCppParser.compareExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ObjCppParser.shiftExpr_return e = null;

        ObjCppParser.shiftExpr_return f = null;


        Object op_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1368:2: (e= shiftExpr (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1368:4: e= shiftExpr (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_shiftExpr_in_compareExpr4154);
            e=shiftExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1369:3: (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( ((LA95_0>=36 && LA95_0<=37)||(LA95_0>=69 && LA95_0<=70)) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1370:4: op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=36 && input.LA(1)<=37)||(input.LA(1)>=69 && input.LA(1)<=70) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(op));
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_shiftExpr_in_compareExpr4189);
            	    f=shiftExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.expr = new BinaryOp(retval.expr, getBinaryOperator((op!=null?op.getText():null)), (f!=null?f.expr:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop95;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "compareExpr"

    public static class castExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "castExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1375:1: castExpr returns [Expression expr] : ( '(' tr= mutableTypeRef ')' inner= castExpr | e= unaryExpr );
    public final ObjCppParser.castExpr_return castExpr() throws RecognitionException {
        ObjCppParser.castExpr_return retval = new ObjCppParser.castExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal190=null;
        Token char_literal191=null;
        ObjCppParser.mutableTypeRef_return tr = null;

        ObjCppParser.castExpr_return inner = null;

        ObjCppParser.unaryExpr_return e = null;


        Object char_literal190_tree=null;
        Object char_literal191_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1376:2: ( '(' tr= mutableTypeRef ')' inner= castExpr | e= unaryExpr )
            int alt96=2;
            alt96 = dfa96.predict(input);
            switch (alt96) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1376:4: '(' tr= mutableTypeRef ')' inner= castExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal190=(Token)match(input,34,FOLLOW_34_in_castExpr4211); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal190_tree = (Object)adaptor.create(char_literal190);
                    adaptor.addChild(root_0, char_literal190_tree);
                    }
                    pushFollow(FOLLOW_mutableTypeRef_in_castExpr4215);
                    tr=mutableTypeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tr.getTree());
                    char_literal191=(Token)match(input,35,FOLLOW_35_in_castExpr4217); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal191_tree = (Object)adaptor.create(char_literal191);
                    adaptor.addChild(root_0, char_literal191_tree);
                    }
                    pushFollow(FOLLOW_castExpr_in_castExpr4221);
                    inner=castExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inner.getTree());
                    if ( state.backtracking==0 ) {
                       retval.expr = new Cast((tr!=null?tr.type:null), (inner!=null?inner.expr:null)); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1377:3: e= unaryExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_unaryExpr_in_castExpr4232);
                    e=unaryExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
                    if ( state.backtracking==0 ) {
                       retval.expr = (e!=null?e.expr:null); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "castExpr"

    public static class unaryExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unaryExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1380:1: unaryExpr returns [Expression expr] : (p= postfixExpr | uo= unaryOp castExpr | 'sizeof' ( '(' tr= mutableTypeRef ')' | unaryExpr ) );
    public final ObjCppParser.unaryExpr_return unaryExpr() throws RecognitionException {
        ObjCppParser.unaryExpr_return retval = new ObjCppParser.unaryExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal193=null;
        Token char_literal194=null;
        Token char_literal195=null;
        ObjCppParser.postfixExpr_return p = null;

        ObjCppParser.unaryOp_return uo = null;

        ObjCppParser.mutableTypeRef_return tr = null;

        ObjCppParser.castExpr_return castExpr192 = null;

        ObjCppParser.unaryExpr_return unaryExpr196 = null;


        Object string_literal193_tree=null;
        Object char_literal194_tree=null;
        Object char_literal195_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1381:2: (p= postfixExpr | uo= unaryOp castExpr | 'sizeof' ( '(' tr= mutableTypeRef ')' | unaryExpr ) )
            int alt98=3;
            switch ( input.LA(1) ) {
            case DECIMAL_NUMBER:
            case STRING:
            case IDENTIFIER:
            case HEXADECIMAL_NUMBER:
            case OCTAL_NUMBER:
            case CHARACTER:
            case FLOAT_NUMBER:
            case 31:
            case 34:
            case 42:
            case 55:
            case 73:
            case 74:
                {
                alt98=1;
                }
                break;
            case 43:
                {
                int LA98_2 = input.LA(2);

                if ( (synpred166_ObjCpp()) ) {
                    alt98=1;
                }
                else if ( (synpred167_ObjCpp()) ) {
                    alt98=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 98, 2, input);

                    throw nvae;
                }
                }
                break;
            case 51:
            case 53:
            case 54:
            case 87:
            case 88:
            case 89:
                {
                alt98=2;
                }
                break;
            case 86:
                {
                alt98=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }

            switch (alt98) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1382:3: p= postfixExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_postfixExpr_in_unaryExpr4254);
                    p=postfixExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, p.getTree());
                    if ( state.backtracking==0 ) {
                       retval.expr = (p!=null?p.expr:null); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1383:3: uo= unaryOp castExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_unaryOp_in_unaryExpr4264);
                    uo=unaryOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, uo.getTree());
                    pushFollow(FOLLOW_castExpr_in_unaryExpr4266);
                    castExpr192=castExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, castExpr192.getTree());
                    if ( state.backtracking==0 ) {
                       retval.expr = new UnaryOp((castExpr192!=null?castExpr192.expr:null), (uo!=null?uo.op:null)); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1384:3: 'sizeof' ( '(' tr= mutableTypeRef ')' | unaryExpr )
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal193=(Token)match(input,86,FOLLOW_86_in_unaryExpr4274); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal193_tree = (Object)adaptor.create(string_literal193);
                    adaptor.addChild(root_0, string_literal193_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1384:12: ( '(' tr= mutableTypeRef ')' | unaryExpr )
                    int alt97=2;
                    alt97 = dfa97.predict(input);
                    switch (alt97) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1385:4: '(' tr= mutableTypeRef ')'
                            {
                            char_literal194=(Token)match(input,34,FOLLOW_34_in_unaryExpr4281); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal194_tree = (Object)adaptor.create(char_literal194);
                            adaptor.addChild(root_0, char_literal194_tree);
                            }
                            pushFollow(FOLLOW_mutableTypeRef_in_unaryExpr4285);
                            tr=mutableTypeRef();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, tr.getTree());
                            char_literal195=(Token)match(input,35,FOLLOW_35_in_unaryExpr4287); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal195_tree = (Object)adaptor.create(char_literal195);
                            adaptor.addChild(root_0, char_literal195_tree);
                            }

                            }
                            break;
                        case 2 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1386:4: unaryExpr
                            {
                            pushFollow(FOLLOW_unaryExpr_in_unaryExpr4295);
                            unaryExpr196=unaryExpr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpr196.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "unaryExpr"

    public static class unaryOp_return extends ParserRuleReturnScope {
        public Expression.UnaryOperator op;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unaryOp"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1390:1: unaryOp returns [Expression.UnaryOperator op] : t= ( '++' | '--' | '&' | '*' | '-' | '~' | '!' ) ;
    public final ObjCppParser.unaryOp_return unaryOp() throws RecognitionException {
        ObjCppParser.unaryOp_return retval = new ObjCppParser.unaryOp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token t=null;

        Object t_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1391:2: (t= ( '++' | '--' | '&' | '*' | '-' | '~' | '!' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1391:5: t= ( '++' | '--' | '&' | '*' | '-' | '~' | '!' )
            {
            root_0 = (Object)adaptor.nil();

            t=(Token)input.LT(1);
            if ( input.LA(1)==43||input.LA(1)==51||(input.LA(1)>=53 && input.LA(1)<=54)||(input.LA(1)>=87 && input.LA(1)<=89) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(t));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {

              			retval.op = Expression.getUnaryOperator((t!=null?t.getText():null));
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "unaryOp"

    public static class postfixExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "postfixExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1396:1: postfixExpr returns [Expression expr] : baseExpression ( '[' expression ']' | '(' ( topLevelExprList )? ')' | '.' di= IDENTIFIER | '->' ai= IDENTIFIER | '++' | '--' )* ;
    public final ObjCppParser.postfixExpr_return postfixExpr() throws RecognitionException {
        ObjCppParser.postfixExpr_return retval = new ObjCppParser.postfixExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token di=null;
        Token ai=null;
        Token char_literal198=null;
        Token char_literal200=null;
        Token char_literal201=null;
        Token char_literal203=null;
        Token char_literal204=null;
        Token string_literal205=null;
        Token string_literal206=null;
        Token string_literal207=null;
        ObjCppParser.baseExpression_return baseExpression197 = null;

        ObjCppParser.expression_return expression199 = null;

        ObjCppParser.topLevelExprList_return topLevelExprList202 = null;


        Object di_tree=null;
        Object ai_tree=null;
        Object char_literal198_tree=null;
        Object char_literal200_tree=null;
        Object char_literal201_tree=null;
        Object char_literal203_tree=null;
        Object char_literal204_tree=null;
        Object string_literal205_tree=null;
        Object string_literal206_tree=null;
        Object string_literal207_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1397:2: ( baseExpression ( '[' expression ']' | '(' ( topLevelExprList )? ')' | '.' di= IDENTIFIER | '->' ai= IDENTIFIER | '++' | '--' )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1398:3: baseExpression ( '[' expression ']' | '(' ( topLevelExprList )? ')' | '.' di= IDENTIFIER | '->' ai= IDENTIFIER | '++' | '--' )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_baseExpression_in_postfixExpr4365);
            baseExpression197=baseExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, baseExpression197.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (baseExpression197!=null?baseExpression197.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1399:3: ( '[' expression ']' | '(' ( topLevelExprList )? ')' | '.' di= IDENTIFIER | '->' ai= IDENTIFIER | '++' | '--' )*
            loop100:
            do {
                int alt100=7;
                switch ( input.LA(1) ) {
                case 55:
                    {
                    alt100=1;
                    }
                    break;
                case 34:
                    {
                    alt100=2;
                    }
                    break;
                case 90:
                    {
                    alt100=3;
                    }
                    break;
                case 91:
                    {
                    alt100=4;
                    }
                    break;
                case 87:
                    {
                    alt100=5;
                    }
                    break;
                case 88:
                    {
                    alt100=6;
                    }
                    break;

                }

                switch (alt100) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1400:4: '[' expression ']'
            	    {
            	    char_literal198=(Token)match(input,55,FOLLOW_55_in_postfixExpr4376); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal198_tree = (Object)adaptor.create(char_literal198);
            	    adaptor.addChild(root_0, char_literal198_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_postfixExpr4378);
            	    expression199=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression199.getTree());
            	    char_literal200=(Token)match(input,56,FOLLOW_56_in_postfixExpr4380); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal200_tree = (Object)adaptor.create(char_literal200);
            	    adaptor.addChild(root_0, char_literal200_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      				retval.expr = new ArrayAccess(retval.expr, (expression199!=null?expression199.expr:null)); 
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1403:4: '(' ( topLevelExprList )? ')'
            	    {
            	    char_literal201=(Token)match(input,34,FOLLOW_34_in_postfixExpr4389); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal201_tree = (Object)adaptor.create(char_literal201);
            	    adaptor.addChild(root_0, char_literal201_tree);
            	    }
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1403:8: ( topLevelExprList )?
            	    int alt99=2;
            	    int LA99_0 = input.LA(1);

            	    if ( ((LA99_0>=DECIMAL_NUMBER && LA99_0<=FLOAT_NUMBER)||LA99_0==31||LA99_0==34||(LA99_0>=42 && LA99_0<=43)||LA99_0==51||(LA99_0>=53 && LA99_0<=55)||(LA99_0>=73 && LA99_0<=74)||(LA99_0>=86 && LA99_0<=89)) ) {
            	        alt99=1;
            	    }
            	    switch (alt99) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: topLevelExprList
            	            {
            	            pushFollow(FOLLOW_topLevelExprList_in_postfixExpr4391);
            	            topLevelExprList202=topLevelExprList();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, topLevelExprList202.getTree());

            	            }
            	            break;

            	    }

            	    char_literal203=(Token)match(input,35,FOLLOW_35_in_postfixExpr4394); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal203_tree = (Object)adaptor.create(char_literal203);
            	    adaptor.addChild(root_0, char_literal203_tree);
            	    }
            	    if ( state.backtracking==0 ) {

            	      				FunctionCall fc = new FunctionCall(retval.expr);
            	      				if ((topLevelExprList202!=null?topLevelExprList202.exprs:null) != null)
            	      					for (Expression x : (topLevelExprList202!=null?topLevelExprList202.exprs:null))
            	      						fc.addArgument(x);
            	      				retval.expr = fc;
            	      			
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1410:4: '.' di= IDENTIFIER
            	    {
            	    char_literal204=(Token)match(input,90,FOLLOW_90_in_postfixExpr4403); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal204_tree = (Object)adaptor.create(char_literal204);
            	    adaptor.addChild(root_0, char_literal204_tree);
            	    }
            	    di=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_postfixExpr4407); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    di_tree = (Object)adaptor.create(di);
            	    adaptor.addChild(root_0, di_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      				retval.expr = new MemberRef(retval.expr, MemberRefStyle.Dot, (di!=null?di.getText():null)); 
            	      			
            	    }

            	    }
            	    break;
            	case 4 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1413:4: '->' ai= IDENTIFIER
            	    {
            	    string_literal205=(Token)match(input,91,FOLLOW_91_in_postfixExpr4416); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal205_tree = (Object)adaptor.create(string_literal205);
            	    adaptor.addChild(root_0, string_literal205_tree);
            	    }
            	    ai=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_postfixExpr4420); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    ai_tree = (Object)adaptor.create(ai);
            	    adaptor.addChild(root_0, ai_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      				retval.expr = new MemberRef(retval.expr, MemberRefStyle.Arrow, (ai!=null?ai.getText():null)); 
            	      			
            	    }

            	    }
            	    break;
            	case 5 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1416:4: '++'
            	    {
            	    string_literal206=(Token)match(input,87,FOLLOW_87_in_postfixExpr4429); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal206_tree = (Object)adaptor.create(string_literal206);
            	    adaptor.addChild(root_0, string_literal206_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      				retval.expr = new UnaryOp(retval.expr, UnaryOperator.PostIncr); 
            	      			
            	    }

            	    }
            	    break;
            	case 6 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1419:4: '--'
            	    {
            	    string_literal207=(Token)match(input,88,FOLLOW_88_in_postfixExpr4438); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal207_tree = (Object)adaptor.create(string_literal207);
            	    adaptor.addChild(root_0, string_literal207_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      				retval.expr = new UnaryOp(retval.expr, UnaryOperator.PostDecr); 
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop100;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "postfixExpr"

    public static class topLevelExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "topLevelExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1425:1: topLevelExpr returns [Expression expr] : e= assignmentExpr ;
    public final ObjCppParser.topLevelExpr_return topLevelExpr() throws RecognitionException {
        ObjCppParser.topLevelExpr_return retval = new ObjCppParser.topLevelExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.assignmentExpr_return e = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1426:2: (e= assignmentExpr )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1426:4: e= assignmentExpr
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_assignmentExpr_in_topLevelExpr4462);
            e=assignmentExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "topLevelExpr"

    public static class topLevelExprList_return extends ParserRuleReturnScope {
        public List<Expression> exprs;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "topLevelExprList"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1428:1: topLevelExprList returns [List<Expression> exprs] : e= topLevelExpr ( ',' f= topLevelExpr )* ;
    public final ObjCppParser.topLevelExprList_return topLevelExprList() throws RecognitionException {
        ObjCppParser.topLevelExprList_return retval = new ObjCppParser.topLevelExprList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal208=null;
        ObjCppParser.topLevelExpr_return e = null;

        ObjCppParser.topLevelExpr_return f = null;


        Object char_literal208_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1429:2: (e= topLevelExpr ( ',' f= topLevelExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1430:3: e= topLevelExpr ( ',' f= topLevelExpr )*
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.exprs = new ArrayList<Expression>(); 
            }
            pushFollow(FOLLOW_topLevelExpr_in_topLevelExprList4487);
            e=topLevelExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.exprs.add((e!=null?e.expr:null)); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1432:3: ( ',' f= topLevelExpr )*
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( (LA101_0==28) ) {
                    int LA101_4 = input.LA(2);

                    if ( (synpred182_ObjCpp()) ) {
                        alt101=1;
                    }


                }


                switch (alt101) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1433:4: ',' f= topLevelExpr
            	    {
            	    char_literal208=(Token)match(input,28,FOLLOW_28_in_topLevelExprList4498); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal208_tree = (Object)adaptor.create(char_literal208);
            	    adaptor.addChild(root_0, char_literal208_tree);
            	    }
            	    pushFollow(FOLLOW_topLevelExpr_in_topLevelExprList4505);
            	    f=topLevelExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.exprs.add((f!=null?f.expr:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop101;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "topLevelExprList"

    public static class expression_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1438:1: expression returns [Expression expr] : l= topLevelExprList ;
    public final ObjCppParser.expression_return expression() throws RecognitionException {
        ObjCppParser.expression_return retval = new ObjCppParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.topLevelExprList_return l = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1439:2: (l= topLevelExprList )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1439:4: l= topLevelExprList
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_topLevelExprList_in_expression4529);
            l=topLevelExprList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, l.getTree());
            if ( state.backtracking==0 ) {

              			if ((l!=null?l.exprs:null) != null) {
              				if ((l!=null?l.exprs:null).size() == 1)
              					retval.expr = (l!=null?l.exprs:null).get(0);
              				else
              					retval.expr = new ExpressionSequence((l!=null?l.exprs:null));
              			}
              		
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class statementsBlock_return extends ParserRuleReturnScope {
        public Block stat;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statementsBlock"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1450:1: statementsBlock returns [Block stat] : '{' ( statement )* '}' ;
    public final ObjCppParser.statementsBlock_return statementsBlock() throws RecognitionException {
        Symbols_stack.push(new Symbols_scope());

        ObjCppParser.statementsBlock_return retval = new ObjCppParser.statementsBlock_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal209=null;
        Token char_literal211=null;
        ObjCppParser.statement_return statement210 = null;


        Object char_literal209_tree=null;
        Object char_literal211_tree=null;


        	((Symbols_scope)Symbols_stack.peek()).typeIdentifiers = new HashSet<String>();

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1455:2: ( '{' ( statement )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1455:4: '{' ( statement )* '}'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.stat = new Block(); 
            }
            char_literal209=(Token)match(input,23,FOLLOW_23_in_statementsBlock4563); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal209_tree = (Object)adaptor.create(char_literal209);
            adaptor.addChild(root_0, char_literal209_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1457:3: ( statement )*
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( ((LA102_0>=DECIMAL_NUMBER && LA102_0<=FLOAT_NUMBER)||LA102_0==23||(LA102_0>=25 && LA102_0<=27)||(LA102_0>=30 && LA102_0<=32)||LA102_0==34||(LA102_0>=42 && LA102_0<=43)||(LA102_0>=48 && LA102_0<=55)||(LA102_0>=58 && LA102_0<=60)||(LA102_0>=73 && LA102_0<=74)||(LA102_0>=86 && LA102_0<=89)||(LA102_0>=92 && LA102_0<=93)||(LA102_0>=95 && LA102_0<=98)) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1458:4: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_statementsBlock4573);
            	    statement210=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement210.getTree());
            	    if ( state.backtracking==0 ) {

            	      				retval.stat.addStatement((statement210!=null?statement210.stat:null));
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop102;
                }
            } while (true);

            char_literal211=(Token)match(input,24,FOLLOW_24_in_statementsBlock4585); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal211_tree = (Object)adaptor.create(char_literal211);
            adaptor.addChild(root_0, char_literal211_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            Symbols_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "statementsBlock"

    public static class statement_return extends ParserRuleReturnScope {
        public Statement stat;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1464:1: statement returns [Statement stat] : (b= statementsBlock | declaration | es= expression ';' | rt= 'return' rex= expression ';' | IDENTIFIER ':' | 'break' ';' | 'if' '(' topLevelExpr ')' statement ( 'else' statement )? | 'while' '(' topLevelExpr ')' statement | 'do' statement 'while' '(' topLevelExpr ')' ';' | 'for' '(' ( expression )? ';' ( expression )? ';' ( expression )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' topLevelExpr ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement );
    public final ObjCppParser.statement_return statement() throws RecognitionException {
        ObjCppParser.statement_return retval = new ObjCppParser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token rt=null;
        Token char_literal213=null;
        Token char_literal214=null;
        Token IDENTIFIER215=null;
        Token char_literal216=null;
        Token string_literal217=null;
        Token char_literal218=null;
        Token string_literal219=null;
        Token char_literal220=null;
        Token char_literal222=null;
        Token string_literal224=null;
        Token string_literal226=null;
        Token char_literal227=null;
        Token char_literal229=null;
        Token string_literal231=null;
        Token string_literal233=null;
        Token char_literal234=null;
        Token char_literal236=null;
        Token char_literal237=null;
        Token string_literal238=null;
        Token char_literal239=null;
        Token char_literal241=null;
        Token char_literal243=null;
        Token char_literal245=null;
        Token string_literal247=null;
        Token char_literal248=null;
        Token char_literal250=null;
        Token char_literal251=null;
        Token string_literal252=null;
        Token char_literal254=null;
        Token char_literal256=null;
        Token char_literal257=null;
        Token IDENTIFIER258=null;
        Token char_literal259=null;
        Token char_literal261=null;
        Token char_literal263=null;
        ObjCppParser.statementsBlock_return b = null;

        ObjCppParser.expression_return es = null;

        ObjCppParser.expression_return rex = null;

        ObjCppParser.declaration_return declaration212 = null;

        ObjCppParser.topLevelExpr_return topLevelExpr221 = null;

        ObjCppParser.statement_return statement223 = null;

        ObjCppParser.statement_return statement225 = null;

        ObjCppParser.topLevelExpr_return topLevelExpr228 = null;

        ObjCppParser.statement_return statement230 = null;

        ObjCppParser.statement_return statement232 = null;

        ObjCppParser.topLevelExpr_return topLevelExpr235 = null;

        ObjCppParser.expression_return expression240 = null;

        ObjCppParser.expression_return expression242 = null;

        ObjCppParser.expression_return expression244 = null;

        ObjCppParser.statement_return statement246 = null;

        ObjCppParser.expression_return expression249 = null;

        ObjCppParser.topLevelExpr_return topLevelExpr253 = null;

        ObjCppParser.statement_return statement255 = null;

        ObjCppParser.varDecl_return varDecl260 = null;

        ObjCppParser.expression_return expression262 = null;

        ObjCppParser.statement_return statement264 = null;


        Object rt_tree=null;
        Object char_literal213_tree=null;
        Object char_literal214_tree=null;
        Object IDENTIFIER215_tree=null;
        Object char_literal216_tree=null;
        Object string_literal217_tree=null;
        Object char_literal218_tree=null;
        Object string_literal219_tree=null;
        Object char_literal220_tree=null;
        Object char_literal222_tree=null;
        Object string_literal224_tree=null;
        Object string_literal226_tree=null;
        Object char_literal227_tree=null;
        Object char_literal229_tree=null;
        Object string_literal231_tree=null;
        Object string_literal233_tree=null;
        Object char_literal234_tree=null;
        Object char_literal236_tree=null;
        Object char_literal237_tree=null;
        Object string_literal238_tree=null;
        Object char_literal239_tree=null;
        Object char_literal241_tree=null;
        Object char_literal243_tree=null;
        Object char_literal245_tree=null;
        Object string_literal247_tree=null;
        Object char_literal248_tree=null;
        Object char_literal250_tree=null;
        Object char_literal251_tree=null;
        Object string_literal252_tree=null;
        Object char_literal254_tree=null;
        Object char_literal256_tree=null;
        Object char_literal257_tree=null;
        Object IDENTIFIER258_tree=null;
        Object char_literal259_tree=null;
        Object char_literal261_tree=null;
        Object char_literal263_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1465:2: (b= statementsBlock | declaration | es= expression ';' | rt= 'return' rex= expression ';' | IDENTIFIER ':' | 'break' ';' | 'if' '(' topLevelExpr ')' statement ( 'else' statement )? | 'while' '(' topLevelExpr ')' statement | 'do' statement 'while' '(' topLevelExpr ')' ';' | 'for' '(' ( expression )? ';' ( expression )? ';' ( expression )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' topLevelExpr ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement )
            int alt108=13;
            alt108 = dfa108.predict(input);
            switch (alt108) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1466:3: b= statementsBlock
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_statementsBlock_in_statement4604);
                    b=statementsBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, b.getTree());
                    if ( state.backtracking==0 ) {
                       retval.stat = (b!=null?b.stat:null); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1467:3: declaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_declaration_in_statement4612);
                    declaration212=declaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration212.getTree());

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1468:3: es= expression ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_expression_in_statement4621);
                    es=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, es.getTree());
                    char_literal213=(Token)match(input,25,FOLLOW_25_in_statement4623); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal213_tree = (Object)adaptor.create(char_literal213);
                    adaptor.addChild(root_0, char_literal213_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.stat = new ExpressionStatement((es!=null?es.expr:null)); 
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1469:3: rt= 'return' rex= expression ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    rt=(Token)match(input,52,FOLLOW_52_in_statement4633); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    rt_tree = (Object)adaptor.create(rt);
                    adaptor.addChild(root_0, rt_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement4637);
                    rex=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rex.getTree());
                    char_literal214=(Token)match(input,25,FOLLOW_25_in_statement4639); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal214_tree = (Object)adaptor.create(char_literal214);
                    adaptor.addChild(root_0, char_literal214_tree);
                    }
                    if ( state.backtracking==0 ) {
                       
                      			retval.stat = mark(new Return((rex!=null?rex.expr:null)), getLine(rt));
                      		
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1472:3: IDENTIFIER ':'
                    {
                    root_0 = (Object)adaptor.nil();

                    IDENTIFIER215=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement4647); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER215_tree = (Object)adaptor.create(IDENTIFIER215);
                    adaptor.addChild(root_0, IDENTIFIER215_tree);
                    }
                    char_literal216=(Token)match(input,33,FOLLOW_33_in_statement4649); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal216_tree = (Object)adaptor.create(char_literal216);
                    adaptor.addChild(root_0, char_literal216_tree);
                    }

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1473:3: 'break' ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal217=(Token)match(input,92,FOLLOW_92_in_statement4656); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal217_tree = (Object)adaptor.create(string_literal217);
                    adaptor.addChild(root_0, string_literal217_tree);
                    }
                    char_literal218=(Token)match(input,25,FOLLOW_25_in_statement4658); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal218_tree = (Object)adaptor.create(char_literal218);
                    adaptor.addChild(root_0, char_literal218_tree);
                    }

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1474:3: 'if' '(' topLevelExpr ')' statement ( 'else' statement )?
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal219=(Token)match(input,93,FOLLOW_93_in_statement4664); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal219_tree = (Object)adaptor.create(string_literal219);
                    adaptor.addChild(root_0, string_literal219_tree);
                    }
                    char_literal220=(Token)match(input,34,FOLLOW_34_in_statement4666); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal220_tree = (Object)adaptor.create(char_literal220);
                    adaptor.addChild(root_0, char_literal220_tree);
                    }
                    pushFollow(FOLLOW_topLevelExpr_in_statement4668);
                    topLevelExpr221=topLevelExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, topLevelExpr221.getTree());
                    char_literal222=(Token)match(input,35,FOLLOW_35_in_statement4670); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal222_tree = (Object)adaptor.create(char_literal222);
                    adaptor.addChild(root_0, char_literal222_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement4672);
                    statement223=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement223.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1474:39: ( 'else' statement )?
                    int alt103=2;
                    int LA103_0 = input.LA(1);

                    if ( (LA103_0==94) ) {
                        int LA103_1 = input.LA(2);

                        if ( (synpred190_ObjCpp()) ) {
                            alt103=1;
                        }
                    }
                    switch (alt103) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1474:40: 'else' statement
                            {
                            string_literal224=(Token)match(input,94,FOLLOW_94_in_statement4675); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal224_tree = (Object)adaptor.create(string_literal224);
                            adaptor.addChild(root_0, string_literal224_tree);
                            }
                            pushFollow(FOLLOW_statement_in_statement4677);
                            statement225=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement225.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 8 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1475:3: 'while' '(' topLevelExpr ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal226=(Token)match(input,95,FOLLOW_95_in_statement4686); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal226_tree = (Object)adaptor.create(string_literal226);
                    adaptor.addChild(root_0, string_literal226_tree);
                    }
                    char_literal227=(Token)match(input,34,FOLLOW_34_in_statement4688); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal227_tree = (Object)adaptor.create(char_literal227);
                    adaptor.addChild(root_0, char_literal227_tree);
                    }
                    pushFollow(FOLLOW_topLevelExpr_in_statement4690);
                    topLevelExpr228=topLevelExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, topLevelExpr228.getTree());
                    char_literal229=(Token)match(input,35,FOLLOW_35_in_statement4692); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal229_tree = (Object)adaptor.create(char_literal229);
                    adaptor.addChild(root_0, char_literal229_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement4694);
                    statement230=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement230.getTree());

                    }
                    break;
                case 9 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1476:3: 'do' statement 'while' '(' topLevelExpr ')' ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal231=(Token)match(input,96,FOLLOW_96_in_statement4701); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal231_tree = (Object)adaptor.create(string_literal231);
                    adaptor.addChild(root_0, string_literal231_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement4703);
                    statement232=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement232.getTree());
                    string_literal233=(Token)match(input,95,FOLLOW_95_in_statement4705); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal233_tree = (Object)adaptor.create(string_literal233);
                    adaptor.addChild(root_0, string_literal233_tree);
                    }
                    char_literal234=(Token)match(input,34,FOLLOW_34_in_statement4707); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal234_tree = (Object)adaptor.create(char_literal234);
                    adaptor.addChild(root_0, char_literal234_tree);
                    }
                    pushFollow(FOLLOW_topLevelExpr_in_statement4709);
                    topLevelExpr235=topLevelExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, topLevelExpr235.getTree());
                    char_literal236=(Token)match(input,35,FOLLOW_35_in_statement4711); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal236_tree = (Object)adaptor.create(char_literal236);
                    adaptor.addChild(root_0, char_literal236_tree);
                    }
                    char_literal237=(Token)match(input,25,FOLLOW_25_in_statement4713); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal237_tree = (Object)adaptor.create(char_literal237);
                    adaptor.addChild(root_0, char_literal237_tree);
                    }

                    }
                    break;
                case 10 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1477:3: 'for' '(' ( expression )? ';' ( expression )? ';' ( expression )? ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal238=(Token)match(input,97,FOLLOW_97_in_statement4720); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal238_tree = (Object)adaptor.create(string_literal238);
                    adaptor.addChild(root_0, string_literal238_tree);
                    }
                    char_literal239=(Token)match(input,34,FOLLOW_34_in_statement4722); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal239_tree = (Object)adaptor.create(char_literal239);
                    adaptor.addChild(root_0, char_literal239_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1477:13: ( expression )?
                    int alt104=2;
                    int LA104_0 = input.LA(1);

                    if ( ((LA104_0>=DECIMAL_NUMBER && LA104_0<=FLOAT_NUMBER)||LA104_0==31||LA104_0==34||(LA104_0>=42 && LA104_0<=43)||LA104_0==51||(LA104_0>=53 && LA104_0<=55)||(LA104_0>=73 && LA104_0<=74)||(LA104_0>=86 && LA104_0<=89)) ) {
                        alt104=1;
                    }
                    switch (alt104) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement4724);
                            expression240=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression240.getTree());

                            }
                            break;

                    }

                    char_literal241=(Token)match(input,25,FOLLOW_25_in_statement4727); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal241_tree = (Object)adaptor.create(char_literal241);
                    adaptor.addChild(root_0, char_literal241_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1477:29: ( expression )?
                    int alt105=2;
                    int LA105_0 = input.LA(1);

                    if ( ((LA105_0>=DECIMAL_NUMBER && LA105_0<=FLOAT_NUMBER)||LA105_0==31||LA105_0==34||(LA105_0>=42 && LA105_0<=43)||LA105_0==51||(LA105_0>=53 && LA105_0<=55)||(LA105_0>=73 && LA105_0<=74)||(LA105_0>=86 && LA105_0<=89)) ) {
                        alt105=1;
                    }
                    switch (alt105) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement4729);
                            expression242=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression242.getTree());

                            }
                            break;

                    }

                    char_literal243=(Token)match(input,25,FOLLOW_25_in_statement4732); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal243_tree = (Object)adaptor.create(char_literal243);
                    adaptor.addChild(root_0, char_literal243_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1477:45: ( expression )?
                    int alt106=2;
                    int LA106_0 = input.LA(1);

                    if ( ((LA106_0>=DECIMAL_NUMBER && LA106_0<=FLOAT_NUMBER)||LA106_0==31||LA106_0==34||(LA106_0>=42 && LA106_0<=43)||LA106_0==51||(LA106_0>=53 && LA106_0<=55)||(LA106_0>=73 && LA106_0<=74)||(LA106_0>=86 && LA106_0<=89)) ) {
                        alt106=1;
                    }
                    switch (alt106) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement4734);
                            expression244=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression244.getTree());

                            }
                            break;

                    }

                    char_literal245=(Token)match(input,35,FOLLOW_35_in_statement4737); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal245_tree = (Object)adaptor.create(char_literal245);
                    adaptor.addChild(root_0, char_literal245_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement4739);
                    statement246=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement246.getTree());

                    }
                    break;
                case 11 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1478:3: 'switch' '(' expression ')' '{' ( 'case' topLevelExpr ':' | statement )* '}'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal247=(Token)match(input,98,FOLLOW_98_in_statement4746); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal247_tree = (Object)adaptor.create(string_literal247);
                    adaptor.addChild(root_0, string_literal247_tree);
                    }
                    char_literal248=(Token)match(input,34,FOLLOW_34_in_statement4748); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal248_tree = (Object)adaptor.create(char_literal248);
                    adaptor.addChild(root_0, char_literal248_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement4750);
                    expression249=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression249.getTree());
                    char_literal250=(Token)match(input,35,FOLLOW_35_in_statement4752); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal250_tree = (Object)adaptor.create(char_literal250);
                    adaptor.addChild(root_0, char_literal250_tree);
                    }
                    char_literal251=(Token)match(input,23,FOLLOW_23_in_statement4754); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal251_tree = (Object)adaptor.create(char_literal251);
                    adaptor.addChild(root_0, char_literal251_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1479:4: ( 'case' topLevelExpr ':' | statement )*
                    loop107:
                    do {
                        int alt107=3;
                        int LA107_0 = input.LA(1);

                        if ( (LA107_0==99) ) {
                            alt107=1;
                        }
                        else if ( ((LA107_0>=DECIMAL_NUMBER && LA107_0<=FLOAT_NUMBER)||LA107_0==23||(LA107_0>=25 && LA107_0<=27)||(LA107_0>=30 && LA107_0<=32)||LA107_0==34||(LA107_0>=42 && LA107_0<=43)||(LA107_0>=48 && LA107_0<=55)||(LA107_0>=58 && LA107_0<=60)||(LA107_0>=73 && LA107_0<=74)||(LA107_0>=86 && LA107_0<=89)||(LA107_0>=92 && LA107_0<=93)||(LA107_0>=95 && LA107_0<=98)) ) {
                            alt107=2;
                        }


                        switch (alt107) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1480:5: 'case' topLevelExpr ':'
                    	    {
                    	    string_literal252=(Token)match(input,99,FOLLOW_99_in_statement4767); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    string_literal252_tree = (Object)adaptor.create(string_literal252);
                    	    adaptor.addChild(root_0, string_literal252_tree);
                    	    }
                    	    pushFollow(FOLLOW_topLevelExpr_in_statement4769);
                    	    topLevelExpr253=topLevelExpr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, topLevelExpr253.getTree());
                    	    char_literal254=(Token)match(input,33,FOLLOW_33_in_statement4771); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal254_tree = (Object)adaptor.create(char_literal254);
                    	    adaptor.addChild(root_0, char_literal254_tree);
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1481:5: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement4779);
                    	    statement255=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement255.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop107;
                        }
                    } while (true);

                    char_literal256=(Token)match(input,24,FOLLOW_24_in_statement4789); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal256_tree = (Object)adaptor.create(char_literal256);
                    adaptor.addChild(root_0, char_literal256_tree);
                    }

                    }
                    break;
                case 12 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1484:3: ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal257=(Token)match(input,25,FOLLOW_25_in_statement4795); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal257_tree = (Object)adaptor.create(char_literal257);
                    adaptor.addChild(root_0, char_literal257_tree);
                    }

                    }
                    break;
                case 13 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1485:3: {...}? IDENTIFIER '(' varDecl ':' expression ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !(( next("foreach") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "statement", " next(\"foreach\") ");
                    }
                    IDENTIFIER258=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement4803); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER258_tree = (Object)adaptor.create(IDENTIFIER258);
                    adaptor.addChild(root_0, IDENTIFIER258_tree);
                    }
                    char_literal259=(Token)match(input,34,FOLLOW_34_in_statement4805); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal259_tree = (Object)adaptor.create(char_literal259);
                    adaptor.addChild(root_0, char_literal259_tree);
                    }
                    pushFollow(FOLLOW_varDecl_in_statement4807);
                    varDecl260=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl260.getTree());
                    char_literal261=(Token)match(input,33,FOLLOW_33_in_statement4809); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal261_tree = (Object)adaptor.create(char_literal261);
                    adaptor.addChild(root_0, char_literal261_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement4811);
                    expression262=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression262.getTree());
                    char_literal263=(Token)match(input,35,FOLLOW_35_in_statement4813); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal263_tree = (Object)adaptor.create(char_literal263);
                    adaptor.addChild(root_0, char_literal263_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement4815);
                    statement264=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement264.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class constant_return extends ParserRuleReturnScope {
        public Constant constant;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constant"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1488:1: constant returns [Constant constant] : ( (s= ( '-' | '+' ) )? DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER | CHARACTER | (s2= ( '-' | '+' ) )? FLOAT_NUMBER | STRING );
    public final ObjCppParser.constant_return constant() throws RecognitionException {
        ObjCppParser.constant_return retval = new ObjCppParser.constant_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token s=null;
        Token s2=null;
        Token DECIMAL_NUMBER265=null;
        Token HEXADECIMAL_NUMBER266=null;
        Token OCTAL_NUMBER267=null;
        Token CHARACTER268=null;
        Token FLOAT_NUMBER269=null;
        Token STRING270=null;

        Object s_tree=null;
        Object s2_tree=null;
        Object DECIMAL_NUMBER265_tree=null;
        Object HEXADECIMAL_NUMBER266_tree=null;
        Object OCTAL_NUMBER267_tree=null;
        Object CHARACTER268_tree=null;
        Object FLOAT_NUMBER269_tree=null;
        Object STRING270_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1489:2: ( (s= ( '-' | '+' ) )? DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER | CHARACTER | (s2= ( '-' | '+' ) )? FLOAT_NUMBER | STRING )
            int alt111=6;
            switch ( input.LA(1) ) {
            case 42:
            case 43:
                {
                int LA111_1 = input.LA(2);

                if ( (LA111_1==FLOAT_NUMBER) ) {
                    alt111=5;
                }
                else if ( (LA111_1==DECIMAL_NUMBER) ) {
                    alt111=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 111, 1, input);

                    throw nvae;
                }
                }
                break;
            case DECIMAL_NUMBER:
                {
                alt111=1;
                }
                break;
            case HEXADECIMAL_NUMBER:
                {
                alt111=2;
                }
                break;
            case OCTAL_NUMBER:
                {
                alt111=3;
                }
                break;
            case CHARACTER:
                {
                alt111=4;
                }
                break;
            case FLOAT_NUMBER:
                {
                alt111=5;
                }
                break;
            case STRING:
                {
                alt111=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;
            }

            switch (alt111) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1489:4: (s= ( '-' | '+' ) )? DECIMAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1489:5: (s= ( '-' | '+' ) )?
                    int alt109=2;
                    int LA109_0 = input.LA(1);

                    if ( ((LA109_0>=42 && LA109_0<=43)) ) {
                        alt109=1;
                    }
                    switch (alt109) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: s= ( '-' | '+' )
                            {
                            s=(Token)input.LT(1);
                            if ( (input.LA(1)>=42 && input.LA(1)<=43) ) {
                                input.consume();
                                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(s));
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }

                    DECIMAL_NUMBER265=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_constant4843); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DECIMAL_NUMBER265_tree = (Object)adaptor.create(DECIMAL_NUMBER265);
                    adaptor.addChild(root_0, DECIMAL_NUMBER265_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant =  Constant.parseDecimal(((s!=null?s.getText():null) == null ? "" : (s!=null?s.getText():null)) + (DECIMAL_NUMBER265!=null?DECIMAL_NUMBER265.getText():null)); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1490:3: HEXADECIMAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    HEXADECIMAL_NUMBER266=(Token)match(input,HEXADECIMAL_NUMBER,FOLLOW_HEXADECIMAL_NUMBER_in_constant4851); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    HEXADECIMAL_NUMBER266_tree = (Object)adaptor.create(HEXADECIMAL_NUMBER266);
                    adaptor.addChild(root_0, HEXADECIMAL_NUMBER266_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant = Constant.parseHex((HEXADECIMAL_NUMBER266!=null?HEXADECIMAL_NUMBER266.getText():null)); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1491:3: OCTAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    OCTAL_NUMBER267=(Token)match(input,OCTAL_NUMBER,FOLLOW_OCTAL_NUMBER_in_constant4859); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OCTAL_NUMBER267_tree = (Object)adaptor.create(OCTAL_NUMBER267);
                    adaptor.addChild(root_0, OCTAL_NUMBER267_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant = Constant.parseOctal((OCTAL_NUMBER267!=null?OCTAL_NUMBER267.getText():null)); 
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1492:3: CHARACTER
                    {
                    root_0 = (Object)adaptor.nil();

                    CHARACTER268=(Token)match(input,CHARACTER,FOLLOW_CHARACTER_in_constant4867); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARACTER268_tree = (Object)adaptor.create(CHARACTER268);
                    adaptor.addChild(root_0, CHARACTER268_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant =  Constant.parseCharOrStringInteger((CHARACTER268!=null?CHARACTER268.getText():null)); 
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1493:3: (s2= ( '-' | '+' ) )? FLOAT_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1493:5: (s2= ( '-' | '+' ) )?
                    int alt110=2;
                    int LA110_0 = input.LA(1);

                    if ( ((LA110_0>=42 && LA110_0<=43)) ) {
                        alt110=1;
                    }
                    switch (alt110) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: s2= ( '-' | '+' )
                            {
                            s2=(Token)input.LT(1);
                            if ( (input.LA(1)>=42 && input.LA(1)<=43) ) {
                                input.consume();
                                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(s2));
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }

                    FLOAT_NUMBER269=(Token)match(input,FLOAT_NUMBER,FOLLOW_FLOAT_NUMBER_in_constant4886); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT_NUMBER269_tree = (Object)adaptor.create(FLOAT_NUMBER269);
                    adaptor.addChild(root_0, FLOAT_NUMBER269_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant = Constant.parseFloat(((s2!=null?s2.getText():null) == null ? "" : (s2!=null?s2.getText():null)) + (FLOAT_NUMBER269!=null?FLOAT_NUMBER269.getText():null)); 
                    }

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1495:3: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING270=(Token)match(input,STRING,FOLLOW_STRING_in_constant4897); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING270_tree = (Object)adaptor.create(STRING270);
                    adaptor.addChild(root_0, STRING270_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant =  Constant.parseString((STRING270!=null?STRING270.getText():null)); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "constant"

    // $ANTLR start synpred6_ObjCpp
    public final void synpred6_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:354:5: ( functionDeclaration )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:354:5: functionDeclaration
        {
        pushFollow(FOLLOW_functionDeclaration_in_synpred6_ObjCpp271);
        functionDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_ObjCpp

    // $ANTLR start synpred7_ObjCpp
    public final void synpred7_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:357:5: ( externDeclarations )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:357:5: externDeclarations
        {
        pushFollow(FOLLOW_externDeclarations_in_synpred7_ObjCpp281);
        externDeclarations();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_ObjCpp

    // $ANTLR start synpred8_ObjCpp
    public final void synpred8_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:360:5: ( varDecl ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:360:5: varDecl ';'
        {
        pushFollow(FOLLOW_varDecl_in_synpred8_ObjCpp291);
        varDecl();

        state._fsp--;
        if (state.failed) return ;
        match(input,25,FOLLOW_25_in_synpred8_ObjCpp293); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_ObjCpp

    // $ANTLR start synpred19_ObjCpp
    public final void synpred19_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifiers_return m2 = null;

        ObjCppParser.enumBody_return nb = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:469:6: (m2= modifiers nb= enumBody )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:469:6: m2= modifiers nb= enumBody
        {
        pushFollow(FOLLOW_modifiers_in_synpred19_ObjCpp664);
        m2=modifiers();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_enumBody_in_synpred19_ObjCpp675);
        nb=enumBody();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_ObjCpp

    // $ANTLR start synpred22_ObjCpp
    public final void synpred22_ObjCpp_fragment() throws RecognitionException {   
        Token parentClass=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:510:4: ( ( ':' parentClass= IDENTIFIER )? )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:510:4: ( ':' parentClass= IDENTIFIER )?
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:510:4: ( ':' parentClass= IDENTIFIER )?
        int alt115=2;
        int LA115_0 = input.LA(1);

        if ( (LA115_0==33) ) {
            alt115=1;
        }
        switch (alt115) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:511:5: ':' parentClass= IDENTIFIER
                {
                match(input,33,FOLLOW_33_in_synpred22_ObjCpp756); if (state.failed) return ;
                parentClass=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred22_ObjCpp760); if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred22_ObjCpp

    // $ANTLR start synpred30_ObjCpp
    public final void synpred30_ObjCpp_fragment() throws RecognitionException {   
        Token bits=null;
        ObjCppParser.varDecl_return fv = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:537:7: (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:537:7: fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';'
        {
        pushFollow(FOLLOW_varDecl_in_synpred30_ObjCpp924);
        fv=varDecl();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:537:18: ( ':' bits= DECIMAL_NUMBER )?
        int alt119=2;
        int LA119_0 = input.LA(1);

        if ( (LA119_0==33) ) {
            alt119=1;
        }
        switch (alt119) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:537:20: ':' bits= DECIMAL_NUMBER
                {
                match(input,33,FOLLOW_33_in_synpred30_ObjCpp928); if (state.failed) return ;
                bits=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_synpred30_ObjCpp932); if (state.failed) return ;

                }
                break;

        }

        match(input,25,FOLLOW_25_in_synpred30_ObjCpp937); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_ObjCpp

    // $ANTLR start synpred31_ObjCpp
    public final void synpred31_ObjCpp_fragment() throws RecognitionException {   
        Token bits=null;
        ObjCppParser.varDecl_return fv = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:535:5: ( ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:535:5: ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:535:5: ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:536:6: (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:536:6: (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl )
        int alt121=2;
        alt121 = dfa121.predict(input);
        switch (alt121) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:537:7: fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';'
                {
                pushFollow(FOLLOW_varDecl_in_synpred31_ObjCpp924);
                fv=varDecl();

                state._fsp--;
                if (state.failed) return ;
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:537:18: ( ':' bits= DECIMAL_NUMBER )?
                int alt120=2;
                int LA120_0 = input.LA(1);

                if ( (LA120_0==33) ) {
                    alt120=1;
                }
                switch (alt120) {
                    case 1 :
                        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:537:20: ':' bits= DECIMAL_NUMBER
                        {
                        match(input,33,FOLLOW_33_in_synpred31_ObjCpp928); if (state.failed) return ;
                        bits=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_synpred31_ObjCpp932); if (state.failed) return ;

                        }
                        break;

                }

                match(input,25,FOLLOW_25_in_synpred31_ObjCpp937); if (state.failed) return ;

                }
                break;
            case 2 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:541:7: functionPointerVarDecl
                {
                pushFollow(FOLLOW_functionPointerVarDecl_in_synpred31_ObjCpp949);
                functionPointerVarDecl();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred31_ObjCpp

    // $ANTLR start synpred35_ObjCpp
    public final void synpred35_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.varDecl_return vd = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:557:4: (vd= varDecl ';' {...}?)
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:557:4: vd= varDecl ';' {...}?
        {
        pushFollow(FOLLOW_varDecl_in_synpred35_ObjCpp1014);
        vd=varDecl();

        state._fsp--;
        if (state.failed) return ;
        match(input,25,FOLLOW_25_in_synpred35_ObjCpp1016); if (state.failed) return ;
        if ( !(( !((vd!=null?vd.decl:null) instanceof VariablesDeclaration) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred35_ObjCpp", " !($vd.decl instanceof VariablesDeclaration) ");
        }

        }
    }
    // $ANTLR end synpred35_ObjCpp

    // $ANTLR start synpred37_ObjCpp
    public final void synpred37_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.mutableTypeRef_return returnTypeRef = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:583:18: (returnTypeRef= mutableTypeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:583:18: returnTypeRef= mutableTypeRef
        {
        pushFollow(FOLLOW_mutableTypeRef_in_synpred37_ObjCpp1102);
        returnTypeRef=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_ObjCpp

    // $ANTLR start synpred51_ObjCpp
    public final void synpred51_ObjCpp_fragment() throws RecognitionException {   
        Token parent=null;
        ObjCppParser.modifiers_return m2 = null;

        ObjCppParser.structBody_return nb = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:655:6: ( (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:655:6: (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:655:6: (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:656:7: m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody
        {
        pushFollow(FOLLOW_modifiers_in_synpred51_ObjCpp1425);
        m2=modifiers();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:657:7: ( ':' ( 'public' )? parent= IDENTIFIER )?
        int alt130=2;
        int LA130_0 = input.LA(1);

        if ( (LA130_0==33) ) {
            alt130=1;
        }
        switch (alt130) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:658:8: ':' ( 'public' )? parent= IDENTIFIER
                {
                match(input,33,FOLLOW_33_in_synpred51_ObjCpp1444); if (state.failed) return ;
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:659:8: ( 'public' )?
                int alt129=2;
                int LA129_0 = input.LA(1);

                if ( (LA129_0==45) ) {
                    alt129=1;
                }
                switch (alt129) {
                    case 1 :
                        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: 'public'
                        {
                        match(input,45,FOLLOW_45_in_synpred51_ObjCpp1453); if (state.failed) return ;

                        }
                        break;

                }

                parent=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred51_ObjCpp1465); if (state.failed) return ;

                }
                break;

        }

        pushFollow(FOLLOW_structBody_in_synpred51_ObjCpp1485);
        nb=structBody();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred51_ObjCpp

    // $ANTLR start synpred52_ObjCpp
    public final void synpred52_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:699:4: ( binaryOp )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:699:4: binaryOp
        {
        pushFollow(FOLLOW_binaryOp_in_synpred52_ObjCpp1534);
        binaryOp();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred52_ObjCpp

    // $ANTLR start synpred53_ObjCpp
    public final void synpred53_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:700:3: ( unaryOp )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:700:3: unaryOp
        {
        pushFollow(FOLLOW_unaryOp_in_synpred53_ObjCpp1543);
        unaryOp();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_ObjCpp

    // $ANTLR start synpred56_ObjCpp
    public final void synpred56_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.mutableTypeRef_return returnTypeRef = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:738:16: (returnTypeRef= mutableTypeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:738:16: returnTypeRef= mutableTypeRef
        {
        pushFollow(FOLLOW_mutableTypeRef_in_synpred56_ObjCpp1630);
        returnTypeRef=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_ObjCpp

    // $ANTLR start synpred57_ObjCpp
    public final void synpred57_ObjCpp_fragment() throws RecognitionException {   
        Token ct=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:750:4: ({...}? => (ct= IDENTIFIER ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:750:4: {...}? => (ct= IDENTIFIER )
        {
        if ( !(( next("const", "__const") )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred57_ObjCpp", " next(\"const\", \"__const\") ");
        }
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:750:36: (ct= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:750:37: ct= IDENTIFIER
        {
        ct=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred57_ObjCpp1664); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred57_ObjCpp

    // $ANTLR start synpred59_ObjCpp
    public final void synpred59_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:768:7: ( modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:768:7: modifier
        {
        pushFollow(FOLLOW_modifier_in_synpred59_ObjCpp1725);
        modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_ObjCpp

    // $ANTLR start synpred60_ObjCpp
    public final void synpred60_ObjCpp_fragment() throws RecognitionException {   
        Token ex=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:774:3: ({...}? => IDENTIFIER ex= STRING )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:774:3: {...}? => IDENTIFIER ex= STRING
        {
        if ( !(( next("extern") )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred60_ObjCpp", " next(\"extern\") ");
        }
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred60_ObjCpp1755); if (state.failed) return ;
        ex=(Token)match(input,STRING,FOLLOW_STRING_in_synpred60_ObjCpp1759); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred60_ObjCpp

    // $ANTLR start synpred61_ObjCpp
    public final void synpred61_ObjCpp_fragment() throws RecognitionException {   
        Token m=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:777:3: ({...}?m= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:777:3: {...}?m= IDENTIFIER
        {
        if ( !(( Modifier.parseModifier(next()) != null )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred61_ObjCpp", " Modifier.parseModifier(next()) != null ");
        }
        m=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred61_ObjCpp1771); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred61_ObjCpp

    // $ANTLR start synpred62_ObjCpp
    public final void synpred62_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:780:3: ({...}? => IDENTIFIER '(' 'return' binaryOp expression ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:780:3: {...}? => IDENTIFIER '(' 'return' binaryOp expression ')'
        {
        if ( !(( next("__success") )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred62_ObjCpp", " next(\"__success\") ");
        }
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred62_ObjCpp1784); if (state.failed) return ;
        match(input,34,FOLLOW_34_in_synpred62_ObjCpp1786); if (state.failed) return ;
        match(input,52,FOLLOW_52_in_synpred62_ObjCpp1788); if (state.failed) return ;
        pushFollow(FOLLOW_binaryOp_in_synpred62_ObjCpp1790);
        binaryOp();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred62_ObjCpp1792);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred62_ObjCpp1795); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred62_ObjCpp

    // $ANTLR start synpred63_ObjCpp
    public final void synpred63_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:784:3: ({...}? => IDENTIFIER '(' expression ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:784:3: {...}? => IDENTIFIER '(' expression ')'
        {
        if ( !(( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred63_ObjCpp", " next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ");
        }
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred63_ObjCpp1812); if (state.failed) return ;
        match(input,34,FOLLOW_34_in_synpred63_ObjCpp1814); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred63_ObjCpp1816);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred63_ObjCpp1818); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred63_ObjCpp

    // $ANTLR start synpred65_ObjCpp
    public final void synpred65_ObjCpp_fragment() throws RecognitionException {   
        Token an=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:790:4: ( (an= STRING )* )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:790:4: (an= STRING )*
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:790:4: (an= STRING )*
        loop131:
        do {
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==STRING) ) {
                alt131=1;
            }


            switch (alt131) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:790:6: an= STRING
        	    {
        	    an=(Token)match(input,STRING,FOLLOW_STRING_in_synpred65_ObjCpp1847); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop131;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred65_ObjCpp

    // $ANTLR start synpred67_ObjCpp
    public final void synpred67_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:832:4: ( declarator )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:832:4: declarator
        {
        pushFollow(FOLLOW_declarator_in_synpred67_ObjCpp1954);
        declarator();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred67_ObjCpp

    // $ANTLR start synpred69_ObjCpp
    public final void synpred69_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.mutableTypeRef_return tr = null;

        ObjCppParser.topLevelExpr_return dv = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:820:4: ( (tr= mutableTypeRef ) ( ( declarator )? ) ( '=' dv= topLevelExpr )? )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:820:4: (tr= mutableTypeRef ) ( ( declarator )? ) ( '=' dv= topLevelExpr )?
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:820:4: (tr= mutableTypeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:821:4: tr= mutableTypeRef
        {
        pushFollow(FOLLOW_mutableTypeRef_in_synpred69_ObjCpp1939);
        tr=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;

        }

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:831:3: ( ( declarator )? )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:832:4: ( declarator )?
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:832:4: ( declarator )?
        int alt132=2;
        int LA132_0 = input.LA(1);

        if ( (LA132_0==IDENTIFIER||LA132_0==34||(LA132_0>=53 && LA132_0<=54)||LA132_0==58) ) {
            alt132=1;
        }
        switch (alt132) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: declarator
                {
                pushFollow(FOLLOW_declarator_in_synpred69_ObjCpp1954);
                declarator();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:846:3: ( '=' dv= topLevelExpr )?
        int alt133=2;
        int LA133_0 = input.LA(1);

        if ( (LA133_0==29) ) {
            alt133=1;
        }
        switch (alt133) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:846:4: '=' dv= topLevelExpr
                {
                match(input,29,FOLLOW_29_in_synpred69_ObjCpp1966); if (state.failed) return ;
                pushFollow(FOLLOW_topLevelExpr_in_synpred69_ObjCpp1970);
                dv=topLevelExpr();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred69_ObjCpp

    // $ANTLR start synpred73_ObjCpp
    public final void synpred73_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:873:20: ( templateArgDecl ( ',' templateArgDecl )* )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:873:20: templateArgDecl ( ',' templateArgDecl )*
        {
        pushFollow(FOLLOW_templateArgDecl_in_synpred73_ObjCpp2072);
        templateArgDecl();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:873:36: ( ',' templateArgDecl )*
        loop134:
        do {
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==28) ) {
                alt134=1;
            }


            switch (alt134) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:873:37: ',' templateArgDecl
        	    {
        	    match(input,28,FOLLOW_28_in_synpred73_ObjCpp2075); if (state.failed) return ;
        	    pushFollow(FOLLOW_templateArgDecl_in_synpred73_ObjCpp2077);
        	    templateArgDecl();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop134;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred73_ObjCpp

    // $ANTLR start synpred78_ObjCpp
    public final void synpred78_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:889:4: (a1= argDef ( ',' ax= argDef )* )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:889:4: a1= argDef ( ',' ax= argDef )*
        {
        pushFollow(FOLLOW_argDef_in_synpred78_ObjCpp2159);
        a1=argDef();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:893:4: ( ',' ax= argDef )*
        loop137:
        do {
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==28) ) {
                alt137=1;
            }


            switch (alt137) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:894:5: ',' ax= argDef
        	    {
        	    match(input,28,FOLLOW_28_in_synpred78_ObjCpp2172); if (state.failed) return ;
        	    pushFollow(FOLLOW_argDef_in_synpred78_ObjCpp2181);
        	    ax=argDef();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop137;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred78_ObjCpp

    // $ANTLR start synpred80_ObjCpp
    public final void synpred80_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:909:4: (a1= argDef ( ',' ax= argDef )* )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:909:4: a1= argDef ( ',' ax= argDef )*
        {
        pushFollow(FOLLOW_argDef_in_synpred80_ObjCpp2234);
        a1=argDef();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:913:4: ( ',' ax= argDef )*
        loop138:
        do {
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==28) ) {
                alt138=1;
            }


            switch (alt138) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:914:5: ',' ax= argDef
        	    {
        	    match(input,28,FOLLOW_28_in_synpred80_ObjCpp2247); if (state.failed) return ;
        	    pushFollow(FOLLOW_argDef_in_synpred80_ObjCpp2256);
        	    ax=argDef();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop138;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred80_ObjCpp

    // $ANTLR start synpred81_ObjCpp
    public final void synpred81_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.typeMutator_return m1 = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:928:4: ( (m1= typeMutator ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:928:4: (m1= typeMutator )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:928:4: (m1= typeMutator )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:929:5: m1= typeMutator
        {
        pushFollow(FOLLOW_typeMutator_in_synpred81_ObjCpp2312);
        m1=typeMutator();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred81_ObjCpp

    // $ANTLR start synpred82_ObjCpp
    public final void synpred82_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.functionSignatureSuffix_return f1 = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:933:4: ( (f1= functionSignatureSuffix ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:933:4: (f1= functionSignatureSuffix )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:933:4: (f1= functionSignatureSuffix )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:934:5: f1= functionSignatureSuffix
        {
        pushFollow(FOLLOW_functionSignatureSuffix_in_synpred82_ObjCpp2334);
        f1=functionSignatureSuffix();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred82_ObjCpp

    // $ANTLR start synpred84_ObjCpp
    public final void synpred84_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.functionSignatureSuffix_return fs = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:951:4: ( ( typeMutator )* (fs= functionSignatureSuffix ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:951:4: ( typeMutator )* (fs= functionSignatureSuffix )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:951:4: ( typeMutator )*
        loop139:
        do {
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( ((LA139_0>=53 && LA139_0<=55)) ) {
                alt139=1;
            }


            switch (alt139) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:952:5: typeMutator
        	    {
        	    pushFollow(FOLLOW_typeMutator_in_synpred84_ObjCpp2380);
        	    typeMutator();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop139;
            }
        } while (true);

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:956:4: (fs= functionSignatureSuffix )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:957:5: fs= functionSignatureSuffix
        {
        pushFollow(FOLLOW_functionSignatureSuffix_in_synpred84_ObjCpp2401);
        fs=functionSignatureSuffix();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred84_ObjCpp

    // $ANTLR start synpred88_ObjCpp
    public final void synpred88_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.topLevelExpr_return dv = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:985:4: ( '=' dv= topLevelExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:985:4: '=' dv= topLevelExpr
        {
        match(input,29,FOLLOW_29_in_synpred88_ObjCpp2511); if (state.failed) return ;
        pushFollow(FOLLOW_topLevelExpr_in_synpred88_ObjCpp2519);
        dv=topLevelExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred88_ObjCpp

    // $ANTLR start synpred92_ObjCpp
    public final void synpred92_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1048:4: ({...}? => IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1048:4: {...}? => IDENTIFIER
        {
        if ( !(( Modifier.parseModifier(next()) == null )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred92_ObjCpp", " Modifier.parseModifier(next()) == null ");
        }
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred92_ObjCpp2760); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred92_ObjCpp

    // $ANTLR start synpred96_ObjCpp
    public final void synpred96_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.argDef_return ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1092:5: ( ',' ax= argDef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1092:5: ',' ax= argDef
        {
        match(input,28,FOLLOW_28_in_synpred96_ObjCpp2881); if (state.failed) return ;
        pushFollow(FOLLOW_argDef_in_synpred96_ObjCpp2890);
        ax=argDef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred96_ObjCpp

    // $ANTLR start synpred98_ObjCpp
    public final void synpred98_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1087:4: (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1087:4: a1= argDef ( ',' ax= argDef )* ( ',' '...' )?
        {
        pushFollow(FOLLOW_argDef_in_synpred98_ObjCpp2868);
        a1=argDef();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1091:4: ( ',' ax= argDef )*
        loop141:
        do {
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==28) ) {
                int LA141_1 = input.LA(2);

                if ( (LA141_1==44) ) {
                    int LA141_3 = input.LA(3);

                    if ( (synpred96_ObjCpp()) ) {
                        alt141=1;
                    }


                }
                else if ( (LA141_1==EOF||LA141_1==IDENTIFIER||(LA141_1>=28 && LA141_1<=30)||LA141_1==34||(LA141_1>=48 && LA141_1<=50)||(LA141_1>=53 && LA141_1<=55)||LA141_1==58||LA141_1==60) ) {
                    alt141=1;
                }


            }


            switch (alt141) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1092:5: ',' ax= argDef
        	    {
        	    match(input,28,FOLLOW_28_in_synpred98_ObjCpp2881); if (state.failed) return ;
        	    pushFollow(FOLLOW_argDef_in_synpred98_ObjCpp2890);
        	    ax=argDef();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop141;
            }
        } while (true);

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1097:4: ( ',' '...' )?
        int alt142=2;
        int LA142_0 = input.LA(1);

        if ( (LA142_0==28) ) {
            alt142=1;
        }
        switch (alt142) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1098:5: ',' '...'
                {
                match(input,28,FOLLOW_28_in_synpred98_ObjCpp2910); if (state.failed) return ;
                match(input,44,FOLLOW_44_in_synpred98_ObjCpp2912); if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred98_ObjCpp

    // $ANTLR start synpred100_ObjCpp
    public final void synpred100_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.typeName_return an = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1146:4: ({...}? =>an= typeName )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1146:4: {...}? =>an= typeName
        {
        if ( !(( 
        				isTypeIdentifier(next()) || 
        				(
        					Modifier.parseModifier(next(1)) == null && 
        					!next(2, "=", ",", ";", ":", "[", "(")
        				) 
        			)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred100_ObjCpp", " \n\t\t\t\tisTypeIdentifier(next()) || \n\t\t\t\t(\n\t\t\t\t\tModifier.parseModifier(next(1)) == null && \n\t\t\t\t\t!next(2, \"=\", \",\", \";\", \":\", \"[\", \"(\")\n\t\t\t\t) \n\t\t\t");
        }
        pushFollow(FOLLOW_typeName_in_synpred100_ObjCpp2993);
        an=typeName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred100_ObjCpp

    // $ANTLR start synpred104_ObjCpp
    public final void synpred104_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.mutableTypeRef_return t1 = null;

        ObjCppParser.mutableTypeRef_return tx = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1168:6: (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1168:6: t1= mutableTypeRef ( ',' tx= mutableTypeRef )*
        {
        pushFollow(FOLLOW_mutableTypeRef_in_synpred104_ObjCpp3075);
        t1=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1169:6: ( ',' tx= mutableTypeRef )*
        loop143:
        do {
            int alt143=2;
            int LA143_0 = input.LA(1);

            if ( (LA143_0==28) ) {
                alt143=1;
            }


            switch (alt143) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1170:7: ',' tx= mutableTypeRef
        	    {
        	    match(input,28,FOLLOW_28_in_synpred104_ObjCpp3092); if (state.failed) return ;
        	    pushFollow(FOLLOW_mutableTypeRef_in_synpred104_ObjCpp3103);
        	    tx=mutableTypeRef();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop143;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred104_ObjCpp

    // $ANTLR start synpred135_ObjCpp
    public final void synpred135_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.assignmentOp_return op = null;

        ObjCppParser.assignmentExpr_return f = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1274:4: (op= assignmentOp f= assignmentExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1274:4: op= assignmentOp f= assignmentExpr
        {
        pushFollow(FOLLOW_assignmentOp_in_synpred135_ObjCpp3585);
        op=assignmentOp();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_assignmentExpr_in_synpred135_ObjCpp3589);
        f=assignmentExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred135_ObjCpp

    // $ANTLR start synpred165_ObjCpp
    public final void synpred165_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.mutableTypeRef_return tr = null;

        ObjCppParser.castExpr_return inner = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1376:4: ( '(' tr= mutableTypeRef ')' inner= castExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1376:4: '(' tr= mutableTypeRef ')' inner= castExpr
        {
        match(input,34,FOLLOW_34_in_synpred165_ObjCpp4211); if (state.failed) return ;
        pushFollow(FOLLOW_mutableTypeRef_in_synpred165_ObjCpp4215);
        tr=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred165_ObjCpp4217); if (state.failed) return ;
        pushFollow(FOLLOW_castExpr_in_synpred165_ObjCpp4221);
        inner=castExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred165_ObjCpp

    // $ANTLR start synpred166_ObjCpp
    public final void synpred166_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.postfixExpr_return p = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1382:3: (p= postfixExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1382:3: p= postfixExpr
        {
        pushFollow(FOLLOW_postfixExpr_in_synpred166_ObjCpp4254);
        p=postfixExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred166_ObjCpp

    // $ANTLR start synpred167_ObjCpp
    public final void synpred167_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.unaryOp_return uo = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1383:3: (uo= unaryOp castExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1383:3: uo= unaryOp castExpr
        {
        pushFollow(FOLLOW_unaryOp_in_synpred167_ObjCpp4264);
        uo=unaryOp();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_castExpr_in_synpred167_ObjCpp4266);
        castExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred167_ObjCpp

    // $ANTLR start synpred168_ObjCpp
    public final void synpred168_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.mutableTypeRef_return tr = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1385:4: ( '(' tr= mutableTypeRef ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1385:4: '(' tr= mutableTypeRef ')'
        {
        match(input,34,FOLLOW_34_in_synpred168_ObjCpp4281); if (state.failed) return ;
        pushFollow(FOLLOW_mutableTypeRef_in_synpred168_ObjCpp4285);
        tr=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred168_ObjCpp4287); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred168_ObjCpp

    // $ANTLR start synpred182_ObjCpp
    public final void synpred182_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.topLevelExpr_return f = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1433:4: ( ',' f= topLevelExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1433:4: ',' f= topLevelExpr
        {
        match(input,28,FOLLOW_28_in_synpred182_ObjCpp4498); if (state.failed) return ;
        pushFollow(FOLLOW_topLevelExpr_in_synpred182_ObjCpp4505);
        f=topLevelExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred182_ObjCpp

    // $ANTLR start synpred185_ObjCpp
    public final void synpred185_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1467:3: ( declaration )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1467:3: declaration
        {
        pushFollow(FOLLOW_declaration_in_synpred185_ObjCpp4612);
        declaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred185_ObjCpp

    // $ANTLR start synpred186_ObjCpp
    public final void synpred186_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.expression_return es = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1468:3: (es= expression ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1468:3: es= expression ';'
        {
        pushFollow(FOLLOW_expression_in_synpred186_ObjCpp4621);
        es=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,25,FOLLOW_25_in_synpred186_ObjCpp4623); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred186_ObjCpp

    // $ANTLR start synpred188_ObjCpp
    public final void synpred188_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1472:3: ( IDENTIFIER ':' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1472:3: IDENTIFIER ':'
        {
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred188_ObjCpp4647); if (state.failed) return ;
        match(input,33,FOLLOW_33_in_synpred188_ObjCpp4649); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred188_ObjCpp

    // $ANTLR start synpred190_ObjCpp
    public final void synpred190_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1474:40: ( 'else' statement )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1474:40: 'else' statement
        {
        match(input,94,FOLLOW_94_in_synpred190_ObjCpp4675); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred190_ObjCpp4677);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred190_ObjCpp

    // $ANTLR start synpred201_ObjCpp
    public final void synpred201_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1484:3: ( ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1484:3: ';'
        {
        match(input,25,FOLLOW_25_in_synpred201_ObjCpp4795); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred201_ObjCpp

    // Delegated rules

    public final boolean synpred78_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred78_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred104_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred104_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred56_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred65_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred65_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred62_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred62_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred63_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred63_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred60_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred60_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred88_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred88_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred135_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred135_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred59_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred82_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred82_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred81_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred81_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred57_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred168_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred168_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred69_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred69_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred96_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred96_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred51_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred61_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred61_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred80_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred80_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred186_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred186_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred98_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred98_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred188_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred188_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred73_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred73_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred201_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred201_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred166_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred166_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred100_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred100_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred182_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred182_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred167_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred167_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred67_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred67_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred185_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred185_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred84_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred84_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred92_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred92_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred165_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred165_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred190_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred190_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA6 dfa6 = new DFA6(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA60 dfa60 = new DFA60(this);
    protected DFA84 dfa84 = new DFA84(this);
    protected DFA96 dfa96 = new DFA96(this);
    protected DFA97 dfa97 = new DFA97(this);
    protected DFA108 dfa108 = new DFA108(this);
    protected DFA121 dfa121 = new DFA121(this);
    static final String DFA6_eotS =
        "\20\uffff";
    static final String DFA6_eofS =
        "\20\uffff";
    static final String DFA6_minS =
        "\1\6\7\0\10\uffff";
    static final String DFA6_maxS =
        "\1\74\7\0\10\uffff";
    static final String DFA6_acceptS =
        "\10\uffff\1\1\1\3\1\uffff\1\4\1\5\1\6\1\7\1\2";
    static final String DFA6_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\10\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1\22\uffff\1\11\1\16\1\15\2\uffff\1\4\2\13\1\uffff\1\7\15"+
            "\uffff\3\3\1\10\1\uffff\2\5\1\6\2\uffff\1\11\1\14\1\2",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "352:4: ( functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA6_1 = input.LA(1);

                         
                        int index6_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 8;}

                        else if ( ((synpred7_ObjCpp()&&( next("extern") ))) ) {s = 15;}

                        else if ( (((synpred8_ObjCpp()&&( next("__success") ))||(synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred8_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||synpred8_ObjCpp()||(synpred8_ObjCpp()&&( next("extern") ))||(synpred8_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") )))) ) {s = 9;}

                         
                        input.seek(index6_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_2 = input.LA(1);

                         
                        int index6_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 8;}

                        else if ( (synpred8_ObjCpp()) ) {s = 9;}

                         
                        input.seek(index6_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA6_3 = input.LA(1);

                         
                        int index6_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 8;}

                        else if ( (synpred8_ObjCpp()) ) {s = 9;}

                         
                        input.seek(index6_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA6_4 = input.LA(1);

                         
                        int index6_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 8;}

                        else if ( (synpred8_ObjCpp()) ) {s = 9;}

                         
                        input.seek(index6_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA6_5 = input.LA(1);

                         
                        int index6_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 8;}

                        else if ( (synpred8_ObjCpp()) ) {s = 9;}

                         
                        input.seek(index6_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA6_6 = input.LA(1);

                         
                        int index6_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 8;}

                        else if ( (synpred8_ObjCpp()) ) {s = 9;}

                         
                        input.seek(index6_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA6_7 = input.LA(1);

                         
                        int index6_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 8;}

                        else if ( (synpred8_ObjCpp()) ) {s = 9;}

                         
                        input.seek(index6_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 6, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA12_eotS =
        "\17\uffff";
    static final String DFA12_eofS =
        "\1\3\16\uffff";
    static final String DFA12_minS =
        "\1\6\1\0\15\uffff";
    static final String DFA12_maxS =
        "\1\72\1\0\15\uffff";
    static final String DFA12_acceptS =
        "\2\uffff\1\1\1\2\13\uffff";
    static final String DFA12_specialS =
        "\1\uffff\1\0\15\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\1\20\uffff\1\2\1\uffff\1\3\2\uffff\2\3\3\uffff\3\3\1\uffff"+
            "\1\3\15\uffff\1\3\1\uffff\3\3\2\uffff\1\3",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "468:5: (m2= modifiers nb= enumBody | )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_1 = input.LA(1);

                         
                        int index12_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred19_ObjCpp()&&( next("__success") ))||(synpred19_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred19_ObjCpp()&&( next("extern") ))||(synpred19_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred19_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") )))) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index12_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA20_eotS =
        "\14\uffff";
    static final String DFA20_eofS =
        "\14\uffff";
    static final String DFA20_minS =
        "\1\6\7\0\2\uffff\1\0\1\uffff";
    static final String DFA20_maxS =
        "\1\74\7\0\2\uffff\1\0\1\uffff";
    static final String DFA20_acceptS =
        "\10\uffff\1\1\2\uffff\1\2";
    static final String DFA20_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\2\uffff\1\7\1\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\1\22\uffff\1\12\4\uffff\1\4\2\uffff\1\10\1\7\15\uffff\3\3"+
            "\2\uffff\2\5\1\6\2\uffff\1\10\1\uffff\1\2",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "536:6: (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA20_1 = input.LA(1);

                         
                        int index20_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred30_ObjCpp()&&( next("__success") ))||(synpred30_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred30_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||synpred30_ObjCpp()||(synpred30_ObjCpp()&&( next("extern") ))||(synpred30_ObjCpp()&&( Modifier.parseModifier(next()) != null )))) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index20_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA20_2 = input.LA(1);

                         
                        int index20_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index20_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA20_3 = input.LA(1);

                         
                        int index20_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index20_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA20_4 = input.LA(1);

                         
                        int index20_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index20_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA20_5 = input.LA(1);

                         
                        int index20_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index20_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA20_6 = input.LA(1);

                         
                        int index20_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index20_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA20_7 = input.LA(1);

                         
                        int index20_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index20_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA20_10 = input.LA(1);

                         
                        int index20_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index20_10);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 20, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA34_eotS =
        "\17\uffff";
    static final String DFA34_eofS =
        "\1\4\16\uffff";
    static final String DFA34_minS =
        "\1\6\2\0\14\uffff";
    static final String DFA34_maxS =
        "\1\72\2\0\14\uffff";
    static final String DFA34_acceptS =
        "\3\uffff\1\1\1\2\12\uffff";
    static final String DFA34_specialS =
        "\1\uffff\1\0\1\1\14\uffff}>";
    static final String[] DFA34_transitionS = {
            "\1\1\20\uffff\1\3\1\uffff\1\4\2\uffff\2\4\3\uffff\1\2\2\4\1"+
            "\uffff\1\4\15\uffff\1\4\1\uffff\3\4\2\uffff\1\4",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA34_eot = DFA.unpackEncodedString(DFA34_eotS);
    static final short[] DFA34_eof = DFA.unpackEncodedString(DFA34_eofS);
    static final char[] DFA34_min = DFA.unpackEncodedStringToUnsignedChars(DFA34_minS);
    static final char[] DFA34_max = DFA.unpackEncodedStringToUnsignedChars(DFA34_maxS);
    static final short[] DFA34_accept = DFA.unpackEncodedString(DFA34_acceptS);
    static final short[] DFA34_special = DFA.unpackEncodedString(DFA34_specialS);
    static final short[][] DFA34_transition;

    static {
        int numStates = DFA34_transitionS.length;
        DFA34_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA34_transition[i] = DFA.unpackEncodedString(DFA34_transitionS[i]);
        }
    }

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = DFA34_eot;
            this.eof = DFA34_eof;
            this.min = DFA34_min;
            this.max = DFA34_max;
            this.accept = DFA34_accept;
            this.special = DFA34_special;
            this.transition = DFA34_transition;
        }
        public String getDescription() {
            return "654:5: ( (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody ) | )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA34_1 = input.LA(1);

                         
                        int index34_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred51_ObjCpp()&&( next("extern") ))||(synpred51_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred51_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||(synpred51_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred51_ObjCpp()&&( next("__success") )))) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index34_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA34_2 = input.LA(1);

                         
                        int index34_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index34_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 34, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA60_eotS =
        "\16\uffff";
    static final String DFA60_eofS =
        "\1\1\15\uffff";
    static final String DFA60_minS =
        "\1\6\4\uffff\2\0\7\uffff";
    static final String DFA60_maxS =
        "\1\72\4\uffff\2\0\7\uffff";
    static final String DFA60_acceptS =
        "\1\uffff\1\3\12\uffff\1\1\1\2";
    static final String DFA60_specialS =
        "\5\uffff\1\0\1\1\7\uffff}>";
    static final String[] DFA60_transitionS = {
            "\1\1\22\uffff\1\1\2\uffff\2\1\4\uffff\1\5\1\1\1\uffff\1\1\15"+
            "\uffff\1\1\1\uffff\2\6\1\14\2\uffff\1\1",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA60_eot = DFA.unpackEncodedString(DFA60_eotS);
    static final short[] DFA60_eof = DFA.unpackEncodedString(DFA60_eofS);
    static final char[] DFA60_min = DFA.unpackEncodedStringToUnsignedChars(DFA60_minS);
    static final char[] DFA60_max = DFA.unpackEncodedStringToUnsignedChars(DFA60_maxS);
    static final short[] DFA60_accept = DFA.unpackEncodedString(DFA60_acceptS);
    static final short[] DFA60_special = DFA.unpackEncodedString(DFA60_specialS);
    static final short[][] DFA60_transition;

    static {
        int numStates = DFA60_transitionS.length;
        DFA60_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA60_transition[i] = DFA.unpackEncodedString(DFA60_transitionS[i]);
        }
    }

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = DFA60_eot;
            this.eof = DFA60_eof;
            this.min = DFA60_min;
            this.max = DFA60_max;
            this.accept = DFA60_accept;
            this.special = DFA60_special;
            this.transition = DFA60_transition;
        }
        public String getDescription() {
            return "()* loopback of 927:3: ( (m1= typeMutator ) | (f1= functionSignatureSuffix ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA60_5 = input.LA(1);

                         
                        int index60_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 13;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index60_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA60_6 = input.LA(1);

                         
                        int index60_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred81_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index60_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 60, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA84_eotS =
        "\13\uffff";
    static final String DFA84_eofS =
        "\1\2\12\uffff";
    static final String DFA84_minS =
        "\1\6\1\0\11\uffff";
    static final String DFA84_maxS =
        "\1\124\1\0\11\uffff";
    static final String DFA84_acceptS =
        "\2\uffff\1\2\3\uffff\1\1\4\uffff";
    static final String DFA84_specialS =
        "\1\uffff\1\0\11\uffff}>";
    static final String[] DFA84_transitionS = {
            "\1\2\21\uffff\2\2\2\uffff\1\2\1\1\3\uffff\1\2\1\uffff\1\2\24"+
            "\uffff\1\2\22\uffff\12\6",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA84_eot = DFA.unpackEncodedString(DFA84_eotS);
    static final short[] DFA84_eof = DFA.unpackEncodedString(DFA84_eofS);
    static final char[] DFA84_min = DFA.unpackEncodedStringToUnsignedChars(DFA84_minS);
    static final char[] DFA84_max = DFA.unpackEncodedStringToUnsignedChars(DFA84_maxS);
    static final short[] DFA84_accept = DFA.unpackEncodedString(DFA84_acceptS);
    static final short[] DFA84_special = DFA.unpackEncodedString(DFA84_specialS);
    static final short[][] DFA84_transition;

    static {
        int numStates = DFA84_transitionS.length;
        DFA84_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA84_transition[i] = DFA.unpackEncodedString(DFA84_transitionS[i]);
        }
    }

    class DFA84 extends DFA {

        public DFA84(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 84;
            this.eot = DFA84_eot;
            this.eof = DFA84_eof;
            this.min = DFA84_min;
            this.max = DFA84_max;
            this.accept = DFA84_accept;
            this.special = DFA84_special;
            this.transition = DFA84_transition;
        }
        public String getDescription() {
            return "1273:3: (op= assignmentOp f= assignmentExpr )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA84_1 = input.LA(1);

                         
                        int index84_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_ObjCpp()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index84_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 84, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA96_eotS =
        "\22\uffff";
    static final String DFA96_eofS =
        "\22\uffff";
    static final String DFA96_minS =
        "\1\4\1\0\20\uffff";
    static final String DFA96_maxS =
        "\1\131\1\0\20\uffff";
    static final String DFA96_acceptS =
        "\2\uffff\1\2\16\uffff\1\1";
    static final String DFA96_specialS =
        "\1\uffff\1\0\20\uffff}>";
    static final String[] DFA96_transitionS = {
            "\7\2\24\uffff\1\2\2\uffff\1\1\7\uffff\2\2\7\uffff\1\2\1\uffff"+
            "\3\2\21\uffff\2\2\13\uffff\4\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA96_eot = DFA.unpackEncodedString(DFA96_eotS);
    static final short[] DFA96_eof = DFA.unpackEncodedString(DFA96_eofS);
    static final char[] DFA96_min = DFA.unpackEncodedStringToUnsignedChars(DFA96_minS);
    static final char[] DFA96_max = DFA.unpackEncodedStringToUnsignedChars(DFA96_maxS);
    static final short[] DFA96_accept = DFA.unpackEncodedString(DFA96_acceptS);
    static final short[] DFA96_special = DFA.unpackEncodedString(DFA96_specialS);
    static final short[][] DFA96_transition;

    static {
        int numStates = DFA96_transitionS.length;
        DFA96_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA96_transition[i] = DFA.unpackEncodedString(DFA96_transitionS[i]);
        }
    }

    class DFA96 extends DFA {

        public DFA96(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 96;
            this.eot = DFA96_eot;
            this.eof = DFA96_eof;
            this.min = DFA96_min;
            this.max = DFA96_max;
            this.accept = DFA96_accept;
            this.special = DFA96_special;
            this.transition = DFA96_transition;
        }
        public String getDescription() {
            return "1375:1: castExpr returns [Expression expr] : ( '(' tr= mutableTypeRef ')' inner= castExpr | e= unaryExpr );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA96_1 = input.LA(1);

                         
                        int index96_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred165_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index96_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 96, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA97_eotS =
        "\22\uffff";
    static final String DFA97_eofS =
        "\22\uffff";
    static final String DFA97_minS =
        "\1\4\1\0\20\uffff";
    static final String DFA97_maxS =
        "\1\131\1\0\20\uffff";
    static final String DFA97_acceptS =
        "\2\uffff\1\2\16\uffff\1\1";
    static final String DFA97_specialS =
        "\1\uffff\1\0\20\uffff}>";
    static final String[] DFA97_transitionS = {
            "\7\2\24\uffff\1\2\2\uffff\1\1\7\uffff\2\2\7\uffff\1\2\1\uffff"+
            "\3\2\21\uffff\2\2\13\uffff\4\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA97_eot = DFA.unpackEncodedString(DFA97_eotS);
    static final short[] DFA97_eof = DFA.unpackEncodedString(DFA97_eofS);
    static final char[] DFA97_min = DFA.unpackEncodedStringToUnsignedChars(DFA97_minS);
    static final char[] DFA97_max = DFA.unpackEncodedStringToUnsignedChars(DFA97_maxS);
    static final short[] DFA97_accept = DFA.unpackEncodedString(DFA97_acceptS);
    static final short[] DFA97_special = DFA.unpackEncodedString(DFA97_specialS);
    static final short[][] DFA97_transition;

    static {
        int numStates = DFA97_transitionS.length;
        DFA97_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA97_transition[i] = DFA.unpackEncodedString(DFA97_transitionS[i]);
        }
    }

    class DFA97 extends DFA {

        public DFA97(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 97;
            this.eot = DFA97_eot;
            this.eof = DFA97_eof;
            this.min = DFA97_min;
            this.max = DFA97_max;
            this.accept = DFA97_accept;
            this.special = DFA97_special;
            this.transition = DFA97_transition;
        }
        public String getDescription() {
            return "1384:12: ( '(' tr= mutableTypeRef ')' | unaryExpr )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA97_1 = input.LA(1);

                         
                        int index97_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred168_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index97_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 97, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA108_eotS =
        "\47\uffff";
    static final String DFA108_eofS =
        "\47\uffff";
    static final String DFA108_minS =
        "\1\4\1\uffff\1\0\3\uffff\4\0\1\uffff\2\0\32\uffff";
    static final String DFA108_maxS =
        "\1\142\1\uffff\1\0\3\uffff\4\0\1\uffff\2\0\32\uffff";
    static final String DFA108_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\14\uffff\1\3\14\uffff\1\4\1\6\1\7\1\10"+
        "\1\11\1\12\1\13\1\5\1\15\1\14";
    static final String DFA108_specialS =
        "\2\uffff\1\0\3\uffff\1\1\1\2\1\3\1\4\1\uffff\1\5\1\6\32\uffff}>";
    static final String[] DFA108_transitionS = {
            "\2\20\1\2\4\20\14\uffff\1\1\1\uffff\1\13\2\3\2\uffff\1\3\1\14"+
            "\1\3\1\uffff\1\10\7\uffff\2\20\4\uffff\3\3\1\11\1\35\2\6\1\7"+
            "\2\uffff\3\3\14\uffff\2\20\13\uffff\4\20\2\uffff\1\36\1\37\1"+
            "\uffff\1\40\1\41\1\42\1\43",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA108_eot = DFA.unpackEncodedString(DFA108_eotS);
    static final short[] DFA108_eof = DFA.unpackEncodedString(DFA108_eofS);
    static final char[] DFA108_min = DFA.unpackEncodedStringToUnsignedChars(DFA108_minS);
    static final char[] DFA108_max = DFA.unpackEncodedStringToUnsignedChars(DFA108_maxS);
    static final short[] DFA108_accept = DFA.unpackEncodedString(DFA108_acceptS);
    static final short[] DFA108_special = DFA.unpackEncodedString(DFA108_specialS);
    static final short[][] DFA108_transition;

    static {
        int numStates = DFA108_transitionS.length;
        DFA108_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA108_transition[i] = DFA.unpackEncodedString(DFA108_transitionS[i]);
        }
    }

    class DFA108 extends DFA {

        public DFA108(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 108;
            this.eot = DFA108_eot;
            this.eof = DFA108_eof;
            this.min = DFA108_min;
            this.max = DFA108_max;
            this.accept = DFA108_accept;
            this.special = DFA108_special;
            this.transition = DFA108_transition;
        }
        public String getDescription() {
            return "1464:1: statement returns [Statement stat] : (b= statementsBlock | declaration | es= expression ';' | rt= 'return' rex= expression ';' | IDENTIFIER ':' | 'break' ';' | 'if' '(' topLevelExpr ')' statement ( 'else' statement )? | 'while' '(' topLevelExpr ')' statement | 'do' statement 'while' '(' topLevelExpr ')' ';' | 'for' '(' ( expression )? ';' ( expression )? ';' ( expression )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' topLevelExpr ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA108_2 = input.LA(1);

                         
                        int index108_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred185_ObjCpp()) ) {s = 3;}

                        else if ( (synpred186_ObjCpp()) ) {s = 16;}

                        else if ( (synpred188_ObjCpp()) ) {s = 36;}

                        else if ( (( next("foreach") )) ) {s = 37;}

                         
                        input.seek(index108_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA108_6 = input.LA(1);

                         
                        int index108_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred185_ObjCpp()) ) {s = 3;}

                        else if ( (synpred186_ObjCpp()) ) {s = 16;}

                         
                        input.seek(index108_6);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA108_7 = input.LA(1);

                         
                        int index108_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred185_ObjCpp()) ) {s = 3;}

                        else if ( (synpred186_ObjCpp()) ) {s = 16;}

                         
                        input.seek(index108_7);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA108_8 = input.LA(1);

                         
                        int index108_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred185_ObjCpp()) ) {s = 3;}

                        else if ( (synpred186_ObjCpp()) ) {s = 16;}

                         
                        input.seek(index108_8);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA108_9 = input.LA(1);

                         
                        int index108_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred185_ObjCpp()) ) {s = 3;}

                        else if ( (synpred186_ObjCpp()) ) {s = 16;}

                         
                        input.seek(index108_9);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA108_11 = input.LA(1);

                         
                        int index108_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred185_ObjCpp()) ) {s = 3;}

                        else if ( (synpred201_ObjCpp()) ) {s = 38;}

                         
                        input.seek(index108_11);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA108_12 = input.LA(1);

                         
                        int index108_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred185_ObjCpp()) ) {s = 3;}

                        else if ( (synpred186_ObjCpp()) ) {s = 16;}

                         
                        input.seek(index108_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 108, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA121_eotS =
        "\14\uffff";
    static final String DFA121_eofS =
        "\14\uffff";
    static final String DFA121_minS =
        "\1\6\7\0\2\uffff\1\0\1\uffff";
    static final String DFA121_maxS =
        "\1\74\7\0\2\uffff\1\0\1\uffff";
    static final String DFA121_acceptS =
        "\10\uffff\1\1\2\uffff\1\2";
    static final String DFA121_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\2\uffff\1\7\1\uffff}>";
    static final String[] DFA121_transitionS = {
            "\1\1\22\uffff\1\12\4\uffff\1\4\2\uffff\1\10\1\7\15\uffff\3\3"+
            "\2\uffff\2\5\1\6\2\uffff\1\10\1\uffff\1\2",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            ""
    };

    static final short[] DFA121_eot = DFA.unpackEncodedString(DFA121_eotS);
    static final short[] DFA121_eof = DFA.unpackEncodedString(DFA121_eofS);
    static final char[] DFA121_min = DFA.unpackEncodedStringToUnsignedChars(DFA121_minS);
    static final char[] DFA121_max = DFA.unpackEncodedStringToUnsignedChars(DFA121_maxS);
    static final short[] DFA121_accept = DFA.unpackEncodedString(DFA121_acceptS);
    static final short[] DFA121_special = DFA.unpackEncodedString(DFA121_specialS);
    static final short[][] DFA121_transition;

    static {
        int numStates = DFA121_transitionS.length;
        DFA121_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA121_transition[i] = DFA.unpackEncodedString(DFA121_transitionS[i]);
        }
    }

    class DFA121 extends DFA {

        public DFA121(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 121;
            this.eot = DFA121_eot;
            this.eof = DFA121_eof;
            this.min = DFA121_min;
            this.max = DFA121_max;
            this.accept = DFA121_accept;
            this.special = DFA121_special;
            this.transition = DFA121_transition;
        }
        public String getDescription() {
            return "536:6: (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA121_1 = input.LA(1);

                         
                        int index121_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred30_ObjCpp()&&( next("__success") ))||(synpred30_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred30_ObjCpp()&&( next("extern") ))||(synpred30_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||(synpred30_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||synpred30_ObjCpp())) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index121_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA121_2 = input.LA(1);

                         
                        int index121_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index121_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA121_3 = input.LA(1);

                         
                        int index121_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index121_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA121_4 = input.LA(1);

                         
                        int index121_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index121_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA121_5 = input.LA(1);

                         
                        int index121_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index121_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA121_6 = input.LA(1);

                         
                        int index121_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index121_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA121_7 = input.LA(1);

                         
                        int index121_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index121_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA121_10 = input.LA(1);

                         
                        int index121_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index121_10);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 121, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_22_in_lineDirective78 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_lineDirective82 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_STRING_in_lineDirective95 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_lineDirective110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_sourceFile150 = new BitSet(new long[]{0x180F0001CC400040L});
    public static final BitSet FOLLOW_lineDirective_in_sourceFile159 = new BitSet(new long[]{0x180F0001CC400040L});
    public static final BitSet FOLLOW_EOF_in_sourceFile172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_externDeclarations191 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_externDeclarations195 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_externDeclarations201 = new BitSet(new long[]{0x180F0001CD000040L});
    public static final BitSet FOLLOW_declaration_in_externDeclarations215 = new BitSet(new long[]{0x180F0001CD000040L});
    public static final BitSet FOLLOW_24_in_externDeclarations228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_declaration271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_externDeclarations_in_declaration281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_declaration291 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_declaration293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objCClassDef_in_declaration303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeDef_in_declaration313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forwardClassDecl_in_declaration323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_declaration333 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration337 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_declaration339 = new BitSet(new long[]{0x180F0001CD000040L});
    public static final BitSet FOLLOW_declaration_in_declaration357 = new BitSet(new long[]{0x180F0001CD000040L});
    public static final BitSet FOLLOW_24_in_declaration373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_forwardClassDecl413 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_forwardClassDecl420 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_28_in_forwardClassDecl427 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_forwardClassDecl434 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_25_in_forwardClassDecl445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_functionPointerVarDecl465 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_functionPointerVarDecl473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enumItem491 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_enumItem494 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_topLevelExpr_in_enumItem498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_enumBody524 = new BitSet(new long[]{0x0000000001000040L});
    public static final BitSet FOLLOW_enumItem_in_enumBody540 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_28_in_enumBody555 = new BitSet(new long[]{0x0000000011000040L});
    public static final BitSet FOLLOW_enumItem_in_enumBody566 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_24_in_enumBody587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_enumCore610 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_modifiers_in_enumCore621 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_enumBody_in_enumCore636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enumCore648 = new BitSet(new long[]{0x0000000000800042L});
    public static final BitSet FOLLOW_modifiers_in_enumCore664 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_enumBody_in_enumCore675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_objCClassDef727 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef738 = new BitSet(new long[]{0x18070E1640800040L});
    public static final BitSet FOLLOW_33_in_objCClassDef756 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef760 = new BitSet(new long[]{0x18070E1040800040L});
    public static final BitSet FOLLOW_34_in_objCClassDef775 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef779 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCClassDef781 = new BitSet(new long[]{0x18070E1040800040L});
    public static final BitSet FOLLOW_36_in_objCClassDef797 = new BitSet(new long[]{0x0000002000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef807 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_objCClassDef822 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef832 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_objCClassDef849 = new BitSet(new long[]{0x18070E0040800040L});
    public static final BitSet FOLLOW_23_in_objCClassDef863 = new BitSet(new long[]{0x100701C041000040L});
    public static final BitSet FOLLOW_38_in_objCClassDef875 = new BitSet(new long[]{0x100701C041000040L});
    public static final BitSet FOLLOW_39_in_objCClassDef886 = new BitSet(new long[]{0x100701C041000040L});
    public static final BitSet FOLLOW_40_in_objCClassDef897 = new BitSet(new long[]{0x100701C041000040L});
    public static final BitSet FOLLOW_varDecl_in_objCClassDef924 = new BitSet(new long[]{0x0000000202000000L});
    public static final BitSet FOLLOW_33_in_objCClassDef928 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_objCClassDef932 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_objCClassDef937 = new BitSet(new long[]{0x100701C041000040L});
    public static final BitSet FOLLOW_functionPointerVarDecl_in_objCClassDef949 = new BitSet(new long[]{0x100701C041000040L});
    public static final BitSet FOLLOW_24_in_objCClassDef976 = new BitSet(new long[]{0x18070E0040000040L});
    public static final BitSet FOLLOW_objCMethodDecl_in_objCClassDef994 = new BitSet(new long[]{0x18070E0040000040L});
    public static final BitSet FOLLOW_typeDef_in_objCClassDef1003 = new BitSet(new long[]{0x18070E0040000040L});
    public static final BitSet FOLLOW_varDecl_in_objCClassDef1014 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_objCClassDef1016 = new BitSet(new long[]{0x18070E0040000040L});
    public static final BitSet FOLLOW_41_in_objCClassDef1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_objCMethodDecl1063 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_43_in_objCMethodDecl1075 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl1094 = new BitSet(new long[]{0x1007000840000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_objCMethodDecl1102 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl1110 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1121 = new BitSet(new long[]{0x0000000202000000L});
    public static final BitSet FOLLOW_33_in_objCMethodDecl1133 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl1135 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_objCMethodDecl1139 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl1141 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1145 = new BitSet(new long[]{0x0000000012000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1160 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodDecl1162 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl1169 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_objCMethodDecl1173 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl1175 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1184 = new BitSet(new long[]{0x0000000012000040L});
    public static final BitSet FOLLOW_28_in_objCMethodDecl1203 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_objCMethodDecl1205 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_objCMethodDecl1222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_structBody1243 = new BitSet(new long[]{0x180FE001CD000040L});
    public static final BitSet FOLLOW_45_in_structBody1261 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_46_in_structBody1273 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_47_in_structBody1285 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_structBody1296 = new BitSet(new long[]{0x180FE001CD000040L});
    public static final BitSet FOLLOW_declaration_in_structBody1304 = new BitSet(new long[]{0x180FE001CD000040L});
    public static final BitSet FOLLOW_24_in_structBody1316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_structCore1352 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_modifiers_in_structCore1373 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_structBody_in_structCore1388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_structCore1400 = new BitSet(new long[]{0x0000000200800042L});
    public static final BitSet FOLLOW_modifiers_in_structCore1425 = new BitSet(new long[]{0x0000000200800000L});
    public static final BitSet FOLLOW_33_in_structCore1444 = new BitSet(new long[]{0x0000200000000040L});
    public static final BitSet FOLLOW_45_in_structCore1453 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_structCore1465 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_structBody_in_structCore1485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binaryOp_in_anyOp1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryOp_in_anyOp1543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentOp_in_anyOp1552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_functionName1574 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionName1579 = new BitSet(new long[]{0xE4680C3020000002L,0x00000000039FF9FFL});
    public static final BitSet FOLLOW_anyOp_in_functionName1581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_functionDeclaration1622 = new BitSet(new long[]{0x100F000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_functionDeclaration1630 = new BitSet(new long[]{0x100F000040000040L});
    public static final BitSet FOLLOW_modifiers_in_functionDeclaration1639 = new BitSet(new long[]{0x100F000040000040L});
    public static final BitSet FOLLOW_functionName_in_functionDeclaration1645 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_argList_in_functionDeclaration1651 = new BitSet(new long[]{0x0000000002800040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionDeclaration1664 = new BitSet(new long[]{0x0000000002800040L});
    public static final BitSet FOLLOW_modifiers_in_functionDeclaration1677 = new BitSet(new long[]{0x0000000002800040L});
    public static final BitSet FOLLOW_25_in_functionDeclaration1689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_functionDeclaration1696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_modifiers1725 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier1755 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_modifier1759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier1771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier1784 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_modifier1786 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_modifier1788 = new BitSet(new long[]{0xE4600C3000000000L,0x00000000000001FFL});
    public static final BitSet FOLLOW_binaryOp_in_modifier1790 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_modifier1792 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_modifier1795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier1812 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_modifier1814 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_modifier1816 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_modifier1818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier1832 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_modifier1836 = new BitSet(new long[]{0x0000000800000060L});
    public static final BitSet FOLLOW_STRING_in_modifier1847 = new BitSet(new long[]{0x0000000800000020L});
    public static final BitSet FOLLOW_extendedModifiers_in_modifier1859 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_modifier1867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_extendedModifiers1896 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_mutableTypeRef_in_argDef1939 = new BitSet(new long[]{0x0460000420000042L});
    public static final BitSet FOLLOW_declarator_in_argDef1954 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_argDef1966 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_topLevelExpr_in_argDef1970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_argDef1984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_typeMutator2006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_typeMutator2020 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_typeMutator2022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_arrayTypeMutator2040 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_arrayTypeMutator2046 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_arrayTypeMutator2055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_templateDef2067 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_templateDef2069 = new BitSet(new long[]{0x1007002040000040L});
    public static final BitSet FOLLOW_templateArgDecl_in_templateDef2072 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_templateDef2075 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_templateArgDecl_in_templateDef2077 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_templateDef2084 = new BitSet(new long[]{0x0007000000000000L});
    public static final BitSet FOLLOW_structCore_in_templateDef2088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_templateDef2092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_templateArgDecl2104 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_templateArgDecl2107 = new BitSet(new long[]{0x00000C00000007B0L});
    public static final BitSet FOLLOW_constant_in_templateArgDecl2109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffix2129 = new BitSet(new long[]{0x0020000000000040L});
    public static final BitSet FOLLOW_modifiers_in_functionSignatureSuffix2133 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_functionSignatureSuffix2135 = new BitSet(new long[]{0x0000000800000040L});
    public static final BitSet FOLLOW_modifiers_in_functionSignatureSuffix2139 = new BitSet(new long[]{0x0000000800000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionSignatureSuffix2141 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffix2144 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffix2150 = new BitSet(new long[]{0x1007100840000040L});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffix2159 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_functionSignatureSuffix2172 = new BitSet(new long[]{0x1007100040000040L});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffix2181 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffix2196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffixNoName2213 = new BitSet(new long[]{0x0020000000000040L});
    public static final BitSet FOLLOW_modifiers_in_functionSignatureSuffixNoName2215 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_functionSignatureSuffixNoName2217 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffixNoName2219 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffixNoName2225 = new BitSet(new long[]{0x1007100840000040L});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffixNoName2234 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_functionSignatureSuffixNoName2247 = new BitSet(new long[]{0x1007100040000040L});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffixNoName2256 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffixNoName2271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefCore_in_mutableTypeRef2291 = new BitSet(new long[]{0x00E0000400000002L});
    public static final BitSet FOLLOW_typeMutator_in_mutableTypeRef2312 = new BitSet(new long[]{0x00E0000400000002L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_mutableTypeRef2334 = new BitSet(new long[]{0x00E0000400000002L});
    public static final BitSet FOLLOW_typeRefCore_in_nonMutableTypeRef2363 = new BitSet(new long[]{0x00E0000400000002L});
    public static final BitSet FOLLOW_typeMutator_in_nonMutableTypeRef2380 = new BitSet(new long[]{0x00E0000400000000L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_nonMutableTypeRef2401 = new BitSet(new long[]{0x00E0000400000002L});
    public static final BitSet FOLLOW_modifiers_in_declarator2432 = new BitSet(new long[]{0x0460000400000040L});
    public static final BitSet FOLLOW_directDeclarator_in_declarator2448 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_set_in_declarator2472 = new BitSet(new long[]{0x0460000400000040L});
    public static final BitSet FOLLOW_declarator_in_declarator2490 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_declarator2511 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_topLevelExpr_in_declarator2519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_typeDef2550 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_varDecl_in_typeDef2555 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_typeDef2557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_varDeclEOF2575 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_varDeclEOF2577 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_varDeclEOF2579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_declarationEOF2599 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_declarationEOF2601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nonMutableTypeRef_in_varDecl2623 = new BitSet(new long[]{0x0460000400000042L});
    public static final BitSet FOLLOW_declaratorsList_in_varDecl2636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_objCProtocolRefList2655 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCProtocolRefList2660 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_objCProtocolRefList2670 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCProtocolRefList2676 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_objCProtocolRefList2686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarator_in_declaratorsList2707 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_declaratorsList2718 = new BitSet(new long[]{0x0460000400000040L});
    public static final BitSet FOLLOW_declarator_in_declaratorsList2726 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_directDeclarator2760 = new BitSet(new long[]{0x0080000400000002L});
    public static final BitSet FOLLOW_34_in_directDeclarator2770 = new BitSet(new long[]{0x0460000400000040L});
    public static final BitSet FOLLOW_declarator_in_directDeclarator2774 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_directDeclarator2776 = new BitSet(new long[]{0x0080000400000002L});
    public static final BitSet FOLLOW_55_in_directDeclarator2792 = new BitSet(new long[]{0x01E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_directDeclarator2804 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_directDeclarator2820 = new BitSet(new long[]{0x0080000400000002L});
    public static final BitSet FOLLOW_argList_in_directDeclarator2828 = new BitSet(new long[]{0x0080000400000002L});
    public static final BitSet FOLLOW_34_in_argList2856 = new BitSet(new long[]{0x1007100840000040L});
    public static final BitSet FOLLOW_argDef_in_argList2868 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_argList2881 = new BitSet(new long[]{0x1007100040000040L});
    public static final BitSet FOLLOW_argDef_in_argList2890 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_argList2910 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_argList2912 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_argList2931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_typeRefCore2964 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_60_in_typeRefCore2975 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_typeName_in_typeRefCore2979 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_typeName_in_typeRefCore2993 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_structCore_in_typeRefCore3002 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_enumCore_in_typeRefCore3011 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_modifiers_in_typeRefCore3024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_typeName3046 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_typeName3058 = new BitSet(new long[]{0x1007002040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_typeName3075 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_typeName3092 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_typeName3103 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_typeName3125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_objCMethodCall3149 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3153 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodCall3157 = new BitSet(new long[]{0x0100000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodCall3168 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3172 = new BitSet(new long[]{0x0100000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodCall3187 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodCall3189 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3193 = new BitSet(new long[]{0x0100000000000040L});
    public static final BitSet FOLLOW_56_in_objCMethodCall3210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionCall3230 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionCall3232 = new BitSet(new long[]{0x00E80C0C800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_functionCall3245 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_functionCall3254 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_functionCall3263 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_35_in_functionCall3281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_binaryOp3300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_baseExpression3407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_baseExpression3415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_baseExpression3423 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_baseExpression3425 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_baseExpression3427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objCMethodCall_in_baseExpression3435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selectorExpr_in_baseExpression3443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_protocolExpr_in_baseExpression3449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_encodingExpr_in_baseExpression3455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_selectorExpr3471 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_selectorExpr3476 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_selectorName_in_selectorExpr3481 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_selectorExpr3486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_selectorName3497 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_IDENTIFIER_in_selectorName3500 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_selectorName3502 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_31_in_protocolExpr3515 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_protocolExpr3519 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_protocolExpr3523 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_protocolExpr3527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_encodingExpr3538 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_encodingExpr3543 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_encodingExpr3547 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_encodingExpr3552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inlineCondExpr_in_assignmentExpr3569 = new BitSet(new long[]{0xE4680C3020000002L,0x00000000039FF9FFL});
    public static final BitSet FOLLOW_assignmentOp_in_assignmentExpr3585 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_assignmentExpr_in_assignmentExpr3589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_assignmentOp3615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logOrExpr_in_inlineCondExpr3676 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_inlineCondExpr3688 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_logOrExpr_in_inlineCondExpr3693 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_inlineCondExpr3699 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_logOrExpr_in_inlineCondExpr3704 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_multExpr_in_addExpr3726 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_set_in_addExpr3739 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_multExpr_in_addExpr3752 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_castExpr_in_multExpr3776 = new BitSet(new long[]{0x6020000000000002L});
    public static final BitSet FOLLOW_set_in_multExpr3790 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_castExpr_in_multExpr3808 = new BitSet(new long[]{0x6020000000000002L});
    public static final BitSet FOLLOW_xorExpr_in_bitOrExpr3832 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_bitOrExpr3846 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_xorExpr_in_bitOrExpr3853 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_equalExpr_in_bitAndExpr3877 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_54_in_bitAndExpr3890 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_equalExpr_in_bitAndExpr3897 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_addExpr_in_shiftExpr3922 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_shiftExpr3935 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_addExpr_in_shiftExpr3948 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_bitAndExpr_in_xorExpr3972 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_58_in_xorExpr3985 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_bitAndExpr_in_xorExpr3992 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_logAndExpr_in_logOrExpr4016 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_logOrExpr4029 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_logAndExpr_in_logOrExpr4036 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_bitOrExpr_in_logAndExpr4060 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_logAndExpr4073 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_bitOrExpr_in_logAndExpr4080 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_compareExpr_in_equalExpr4104 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_set_in_equalExpr4117 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_compareExpr_in_equalExpr4130 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_shiftExpr_in_compareExpr4154 = new BitSet(new long[]{0x0000003000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_set_in_compareExpr4167 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_shiftExpr_in_compareExpr4189 = new BitSet(new long[]{0x0000003000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_34_in_castExpr4211 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_castExpr4215 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_castExpr4217 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_castExpr_in_castExpr4221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpr_in_castExpr4232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpr_in_unaryExpr4254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryOp_in_unaryExpr4264 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_castExpr_in_unaryExpr4266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_unaryExpr4274 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_34_in_unaryExpr4281 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_unaryExpr4285 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_unaryExpr4287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpr_in_unaryExpr4295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_unaryOp4318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_baseExpression_in_postfixExpr4365 = new BitSet(new long[]{0x0080000400000002L,0x000000000D800000L});
    public static final BitSet FOLLOW_55_in_postfixExpr4376 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_postfixExpr4378 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_postfixExpr4380 = new BitSet(new long[]{0x0080000400000002L,0x000000000D800000L});
    public static final BitSet FOLLOW_34_in_postfixExpr4389 = new BitSet(new long[]{0x00E80C0C800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_topLevelExprList_in_postfixExpr4391 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_postfixExpr4394 = new BitSet(new long[]{0x0080000400000002L,0x000000000D800000L});
    public static final BitSet FOLLOW_90_in_postfixExpr4403 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_postfixExpr4407 = new BitSet(new long[]{0x0080000400000002L,0x000000000D800000L});
    public static final BitSet FOLLOW_91_in_postfixExpr4416 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_postfixExpr4420 = new BitSet(new long[]{0x0080000400000002L,0x000000000D800000L});
    public static final BitSet FOLLOW_87_in_postfixExpr4429 = new BitSet(new long[]{0x0080000400000002L,0x000000000D800000L});
    public static final BitSet FOLLOW_88_in_postfixExpr4438 = new BitSet(new long[]{0x0080000400000002L,0x000000000D800000L});
    public static final BitSet FOLLOW_assignmentExpr_in_topLevelExpr4462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_topLevelExpr_in_topLevelExprList4487 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_topLevelExprList4498 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_topLevelExpr_in_topLevelExprList4505 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_topLevelExprList_in_expression4529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_statementsBlock4563 = new BitSet(new long[]{0x18FF0C05CF8007F0L,0x00000007B3C00600L});
    public static final BitSet FOLLOW_statement_in_statementsBlock4573 = new BitSet(new long[]{0x18FF0C05CF8007F0L,0x00000007B3C00600L});
    public static final BitSet FOLLOW_24_in_statementsBlock4585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_statement4604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_statement4612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement4621 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_statement4633 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_statement4637 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement4647 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement4649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_statement4656 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_statement4664 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4666 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_topLevelExpr_in_statement4668 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4670 = new BitSet(new long[]{0x18FF0C05CE8007F0L,0x00000007B3C00600L});
    public static final BitSet FOLLOW_statement_in_statement4672 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_statement4675 = new BitSet(new long[]{0x18FF0C05CE8007F0L,0x00000007B3C00600L});
    public static final BitSet FOLLOW_statement_in_statement4677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_statement4686 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4688 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_topLevelExpr_in_statement4690 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4692 = new BitSet(new long[]{0x18FF0C05CE8007F0L,0x00000007B3C00600L});
    public static final BitSet FOLLOW_statement_in_statement4694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_statement4701 = new BitSet(new long[]{0x18FF0C05CE8007F0L,0x00000007B3C00600L});
    public static final BitSet FOLLOW_statement_in_statement4703 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_statement4705 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4707 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_topLevelExpr_in_statement4709 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4711 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_statement4720 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4722 = new BitSet(new long[]{0x00E80C04820007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_statement4724 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4727 = new BitSet(new long[]{0x00E80C04820007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_statement4729 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4732 = new BitSet(new long[]{0x00E80C0C800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_statement4734 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4737 = new BitSet(new long[]{0x18FF0C05CE8007F0L,0x00000007B3C00600L});
    public static final BitSet FOLLOW_statement_in_statement4739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_statement4746 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4748 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_statement4750 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4752 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_statement4754 = new BitSet(new long[]{0x18FF0C05CF8007F0L,0x0000000FB3C00600L});
    public static final BitSet FOLLOW_99_in_statement4767 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_topLevelExpr_in_statement4769 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement4771 = new BitSet(new long[]{0x18FF0C05CF8007F0L,0x0000000FB3C00600L});
    public static final BitSet FOLLOW_statement_in_statement4779 = new BitSet(new long[]{0x18FF0C05CF8007F0L,0x0000000FB3C00600L});
    public static final BitSet FOLLOW_24_in_statement4789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_statement4795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement4803 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4805 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_varDecl_in_statement4807 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement4809 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_statement4811 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4813 = new BitSet(new long[]{0x18FF0C05CE8007F0L,0x00000007B3C00600L});
    public static final BitSet FOLLOW_statement_in_statement4815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_constant4834 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_constant4843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEXADECIMAL_NUMBER_in_constant4851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OCTAL_NUMBER_in_constant4859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARACTER_in_constant4867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_constant4877 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_FLOAT_NUMBER_in_constant4886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_constant4897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_synpred6_ObjCpp271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_externDeclarations_in_synpred7_ObjCpp281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred8_ObjCpp291 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred8_ObjCpp293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_synpred19_ObjCpp664 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_enumBody_in_synpred19_ObjCpp675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_synpred22_ObjCpp756 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred22_ObjCpp760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred30_ObjCpp924 = new BitSet(new long[]{0x0000000202000000L});
    public static final BitSet FOLLOW_33_in_synpred30_ObjCpp928 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_synpred30_ObjCpp932 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred30_ObjCpp937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred31_ObjCpp924 = new BitSet(new long[]{0x0000000202000000L});
    public static final BitSet FOLLOW_33_in_synpred31_ObjCpp928 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_synpred31_ObjCpp932 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred31_ObjCpp937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionPointerVarDecl_in_synpred31_ObjCpp949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred35_ObjCpp1014 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred35_ObjCpp1016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred37_ObjCpp1102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_synpred51_ObjCpp1425 = new BitSet(new long[]{0x0000000200800000L});
    public static final BitSet FOLLOW_33_in_synpred51_ObjCpp1444 = new BitSet(new long[]{0x0000200000000040L});
    public static final BitSet FOLLOW_45_in_synpred51_ObjCpp1453 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred51_ObjCpp1465 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_structBody_in_synpred51_ObjCpp1485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binaryOp_in_synpred52_ObjCpp1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryOp_in_synpred53_ObjCpp1543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred56_ObjCpp1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred57_ObjCpp1664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred59_ObjCpp1725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred60_ObjCpp1755 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_synpred60_ObjCpp1759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred61_ObjCpp1771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred62_ObjCpp1784 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_synpred62_ObjCpp1786 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_synpred62_ObjCpp1788 = new BitSet(new long[]{0xE4600C3000000000L,0x00000000000001FFL});
    public static final BitSet FOLLOW_binaryOp_in_synpred62_ObjCpp1790 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_synpred62_ObjCpp1792 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred62_ObjCpp1795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred63_ObjCpp1812 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_synpred63_ObjCpp1814 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_synpred63_ObjCpp1816 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred63_ObjCpp1818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_synpred65_ObjCpp1847 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_declarator_in_synpred67_ObjCpp1954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred69_ObjCpp1939 = new BitSet(new long[]{0x0460000420000042L});
    public static final BitSet FOLLOW_declarator_in_synpred69_ObjCpp1954 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_synpred69_ObjCpp1966 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_topLevelExpr_in_synpred69_ObjCpp1970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_templateArgDecl_in_synpred73_ObjCpp2072 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred73_ObjCpp2075 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_templateArgDecl_in_synpred73_ObjCpp2077 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_argDef_in_synpred78_ObjCpp2159 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred78_ObjCpp2172 = new BitSet(new long[]{0x1007100040000040L});
    public static final BitSet FOLLOW_argDef_in_synpred78_ObjCpp2181 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_argDef_in_synpred80_ObjCpp2234 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred80_ObjCpp2247 = new BitSet(new long[]{0x1007100040000040L});
    public static final BitSet FOLLOW_argDef_in_synpred80_ObjCpp2256 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred81_ObjCpp2312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_synpred82_ObjCpp2334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred84_ObjCpp2380 = new BitSet(new long[]{0x00E0000400000000L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_synpred84_ObjCpp2401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred88_ObjCpp2511 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_topLevelExpr_in_synpred88_ObjCpp2519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred92_ObjCpp2760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_synpred96_ObjCpp2881 = new BitSet(new long[]{0x1007100040000040L});
    public static final BitSet FOLLOW_argDef_in_synpred96_ObjCpp2890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argDef_in_synpred98_ObjCpp2868 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred98_ObjCpp2881 = new BitSet(new long[]{0x1007100040000040L});
    public static final BitSet FOLLOW_argDef_in_synpred98_ObjCpp2890 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred98_ObjCpp2910 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_synpred98_ObjCpp2912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeName_in_synpred100_ObjCpp2993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred104_ObjCpp3075 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred104_ObjCpp3092 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred104_ObjCpp3103 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_assignmentOp_in_synpred135_ObjCpp3585 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_assignmentExpr_in_synpred135_ObjCpp3589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred165_ObjCpp4211 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred165_ObjCpp4215 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred165_ObjCpp4217 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_castExpr_in_synpred165_ObjCpp4221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpr_in_synpred166_ObjCpp4254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryOp_in_synpred167_ObjCpp4264 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_castExpr_in_synpred167_ObjCpp4266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred168_ObjCpp4281 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred168_ObjCpp4285 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred168_ObjCpp4287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_synpred182_ObjCpp4498 = new BitSet(new long[]{0x00E80C04800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_topLevelExpr_in_synpred182_ObjCpp4505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_synpred185_ObjCpp4612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred186_ObjCpp4621 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred186_ObjCpp4623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred188_ObjCpp4647 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_synpred188_ObjCpp4649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_synpred190_ObjCpp4675 = new BitSet(new long[]{0x18FF0C05CE8007F0L,0x00000007B3C00600L});
    public static final BitSet FOLLOW_statement_in_synpred190_ObjCpp4677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_synpred201_ObjCpp4795 = new BitSet(new long[]{0x0000000000000002L});

}