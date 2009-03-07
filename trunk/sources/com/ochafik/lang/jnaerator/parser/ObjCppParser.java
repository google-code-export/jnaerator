// $ANTLR 3.1.2 /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g 2009-03-07 05:24:50
 
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DECIMAL_NUMBER", "STRING", "IDENTIFIER", "HEXADECIMAL_NUMBER", "OCTAL_NUMBER", "CHARACTER", "FLOAT_NUMBER", "Letter", "FloatingPointExponentSuffix", "FloatingPointConstantSuffix", "OctalEscape", "CharEscape", "HexDigit", "UnicodeEscape", "IntegerConstantSuffix", "WS", "COMMENT", "LINE_COMMENT", "'#line'", "'{'", "'}'", "'namespace'", "'@class'", "','", "';'", "'='", "'enum'", "'@protocol'", "'@interface'", "':'", "'('", "')'", "'<'", "'>'", "'@public'", "'@private'", "'@protected'", "'@end'", "'+'", "'-'", "'...'", "'struct'", "'class'", "'union'", "'public'", "'private'", "'protected'", "'*'", "'&'", "'['", "']'", "'template'", "'typename'", "'^'", "'typedef'", "'signed'", "'unsigned'", "'__signed'", "'__unsigned'", "'long'", "'short'", "'int'", "'double'", "'float'", "'char'", "'void'", "'__int8'", "'__int16'", "'__int32'", "'__int64'", "'sizeof'", "'!'", "'~'", "'/'", "'%'", "'<<'", "'>>>'", "'>>'", "'||'", "'|'", "'&&'", "'<='", "'>='", "'=='", "'!='", "'.'", "'?'", "'return'", "'if'", "'else'", "'while'", "'do'", "'for'", "'switch'", "'case'"
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


    public static class lineDirective_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "lineDirective"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:174:1: lineDirective : ln= '#line' line= DECIMAL_NUMBER (unescapedString= STRING )? (depth= DECIMAL_NUMBER )? ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:175:2: (ln= '#line' line= DECIMAL_NUMBER (unescapedString= STRING )? (depth= DECIMAL_NUMBER )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:175:4: ln= '#line' line= DECIMAL_NUMBER (unescapedString= STRING )? (depth= DECIMAL_NUMBER )?
            {
            root_0 = (Object)adaptor.nil();

            ln=(Token)match(input,22,FOLLOW_22_in_lineDirective65); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ln_tree = (Object)adaptor.create(ln);
            adaptor.addChild(root_0, ln_tree);
            }
            line=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_lineDirective69); if (state.failed) return retval;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:183:3: (unescapedString= STRING )?
            int alt1=2;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:184:4: unescapedString= STRING
                    {
                    unescapedString=(Token)match(input,STRING,FOLLOW_STRING_in_lineDirective82); if (state.failed) return retval;
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:194:8: (depth= DECIMAL_NUMBER )?
            int alt2=2;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: depth= DECIMAL_NUMBER
                    {
                    depth=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_lineDirective97); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:197:1: sourceFile returns [SourceFile sourceFile] : ( declaration | lineDirective )* EOF ;
    public final ObjCppParser.sourceFile_return sourceFile() throws RecognitionException {
        ObjCppParser.sourceFile_return retval = new ObjCppParser.sourceFile_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF3=null;
        ObjCppParser.declaration_return declaration1 = null;

        ObjCppParser.lineDirective_return lineDirective2 = null;


        Object EOF3_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:198:2: ( ( declaration | lineDirective )* EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:199:3: ( declaration | lineDirective )* EOF
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.sourceFile = mark(new SourceFile(), getLine()); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:200:3: ( declaration | lineDirective )*
            loop3:
            do {
                int alt3=3;
                alt3 = dfa3.predict(input);
                switch (alt3) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:201:4: declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_sourceFile126);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:205:4: lineDirective
            	    {
            	    pushFollow(FOLLOW_lineDirective_in_sourceFile135);
            	    lineDirective2=lineDirective();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, lineDirective2.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_sourceFile146); if (state.failed) return retval;
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
        }
        return retval;
    }
    // $ANTLR end "sourceFile"

    public static class externDeclarations_return extends ParserRuleReturnScope {
        public List<Declaration> declarations;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "externDeclarations"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:210:1: externDeclarations returns [List<Declaration> declarations] : {...}? IDENTIFIER STRING '{' (ed= declaration )* '}' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:211:2: ({...}? IDENTIFIER STRING '{' (ed= declaration )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:211:4: {...}? IDENTIFIER STRING '{' (ed= declaration )* '}'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.declarations = new ArrayList<Declaration>(); 
            }
            if ( !(( next("extern") )) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "externDeclarations", " next(\"extern\") ");
            }
            IDENTIFIER4=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_externDeclarations167); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER4_tree = (Object)adaptor.create(IDENTIFIER4);
            adaptor.addChild(root_0, IDENTIFIER4_tree);
            }
            STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_externDeclarations171); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING5_tree = (Object)adaptor.create(STRING5);
            adaptor.addChild(root_0, STRING5_tree);
            }
            char_literal6=(Token)match(input,23,FOLLOW_23_in_externDeclarations176); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal6_tree = (Object)adaptor.create(char_literal6);
            adaptor.addChild(root_0, char_literal6_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:215:4: (ed= declaration )*
            loop4:
            do {
                int alt4=2;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:216:5: ed= declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_externDeclarations190);
            	    ed=declaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ed.getTree());
            	    if ( state.backtracking==0 ) {
            	       
            	      					retval.declarations.addAll((ed!=null?ed.declarations:null)); 
            	      				
            	    }

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            char_literal7=(Token)match(input,24,FOLLOW_24_in_externDeclarations203); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:223:1: declaration returns [List<Declaration> declarations, List<Modifier> modifiers, String preComment, int startTokenIndex] : ( ( functionDeclaration | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) ) ;
    public final ObjCppParser.declaration_return declaration() throws RecognitionException {
        ObjCppParser.declaration_return retval = new ObjCppParser.declaration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ns=null;
        Token string_literal13=null;
        Token char_literal14=null;
        Token char_literal15=null;
        ObjCppParser.declaration_return subD = null;

        ObjCppParser.functionDeclaration_return functionDeclaration8 = null;

        ObjCppParser.varDecl_return varDecl9 = null;

        ObjCppParser.objCClassDef_return objCClassDef10 = null;

        ObjCppParser.typeDef_return typeDef11 = null;

        ObjCppParser.forwardClassDecl_return forwardClassDecl12 = null;


        Object ns_tree=null;
        Object string_literal13_tree=null;
        Object char_literal14_tree=null;
        Object char_literal15_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:224:2: ( ( ( functionDeclaration | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:225:3: ( ( functionDeclaration | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.declarations = new ArrayList<Declaration>(); 
              		  retval.modifiers = new ArrayList<Modifier>();
              		  retval.startTokenIndex = getTokenStream().index();
              		  retval.preComment = getCommentBefore(retval.startTokenIndex);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:230:3: ( ( functionDeclaration | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:237:4: ( functionDeclaration | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:237:4: ( functionDeclaration | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )
            int alt6=6;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:239:5: functionDeclaration
                    {
                    pushFollow(FOLLOW_functionDeclaration_in_declaration247);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:242:5: varDecl
                    {
                    pushFollow(FOLLOW_varDecl_in_declaration257);
                    varDecl9=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl9.getTree());
                    if ( state.backtracking==0 ) {
                       
                      					retval.declarations.add((varDecl9!=null?varDecl9.decl:null)); 
                      				
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:245:5: objCClassDef
                    {
                    pushFollow(FOLLOW_objCClassDef_in_declaration267);
                    objCClassDef10=objCClassDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, objCClassDef10.getTree());
                    if ( state.backtracking==0 ) {
                       
                      					retval.declarations.add(decl((objCClassDef10!=null?objCClassDef10.struct:null))); 
                      				
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:248:5: typeDef
                    {
                    pushFollow(FOLLOW_typeDef_in_declaration277);
                    typeDef11=typeDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeDef11.getTree());
                    if ( state.backtracking==0 ) {

                      					retval.declarations.add((typeDef11!=null?typeDef11.typeDef:null)); 
                      				
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:251:5: forwardClassDecl
                    {
                    pushFollow(FOLLOW_forwardClassDecl_in_declaration287);
                    forwardClassDecl12=forwardClassDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, forwardClassDecl12.getTree());
                    if ( state.backtracking==0 ) {

                      					retval.declarations.addAll((forwardClassDecl12!=null?forwardClassDecl12.declarations:null)); 
                      				
                    }

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:254:5: 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}'
                    {
                    string_literal13=(Token)match(input,25,FOLLOW_25_in_declaration297); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal13_tree = (Object)adaptor.create(string_literal13);
                    adaptor.addChild(root_0, string_literal13_tree);
                    }
                    ns=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration301); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ns_tree = (Object)adaptor.create(ns);
                    adaptor.addChild(root_0, ns_tree);
                    }
                    char_literal14=(Token)match(input,23,FOLLOW_23_in_declaration303); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal14_tree = (Object)adaptor.create(char_literal14);
                    adaptor.addChild(root_0, char_literal14_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:255:6: (subD= declaration )*
                    loop5:
                    do {
                        int alt5=2;
                        alt5 = dfa5.predict(input);
                        switch (alt5) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:256:7: subD= declaration
                    	    {
                    	    pushFollow(FOLLOW_declaration_in_declaration321);
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

                    char_literal15=(Token)match(input,24,FOLLOW_24_in_declaration337); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal15_tree = (Object)adaptor.create(char_literal15);
                    adaptor.addChild(root_0, char_literal15_tree);
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
              					for (Modifier modifier : retval.modifiers)
              						d.addModifiers(modifier);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:281:1: forwardClassDecl returns [List<Declaration> declarations] : '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';' ;
    public final ObjCppParser.forwardClassDecl_return forwardClassDecl() throws RecognitionException {
        ObjCppParser.forwardClassDecl_return retval = new ObjCppParser.forwardClassDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n1=null;
        Token nx=null;
        Token string_literal16=null;
        Token char_literal17=null;
        Token char_literal18=null;

        Object n1_tree=null;
        Object nx_tree=null;
        Object string_literal16_tree=null;
        Object char_literal17_tree=null;
        Object char_literal18_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:282:2: ( '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:282:5: '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.declarations = new ArrayList<Declaration>(); 
            }
            string_literal16=(Token)match(input,26,FOLLOW_26_in_forwardClassDecl377); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal16_tree = (Object)adaptor.create(string_literal16);
            adaptor.addChild(root_0, string_literal16_tree);
            }
            n1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_forwardClassDecl384); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n1_tree = (Object)adaptor.create(n1);
            adaptor.addChild(root_0, n1_tree);
            }
            if ( state.backtracking==0 ) {
               retval.declarations.add(decl(Struct.forwardDecl((n1!=null?n1.getText():null), Struct.Type.ObjCClass))); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:285:3: ( ',' nx= IDENTIFIER )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==27) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:285:4: ',' nx= IDENTIFIER
            	    {
            	    char_literal17=(Token)match(input,27,FOLLOW_27_in_forwardClassDecl391); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal17_tree = (Object)adaptor.create(char_literal17);
            	    adaptor.addChild(root_0, char_literal17_tree);
            	    }
            	    nx=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_forwardClassDecl398); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    nx_tree = (Object)adaptor.create(nx);
            	    adaptor.addChild(root_0, nx_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	       retval.declarations.add(decl(Struct.forwardDecl((nx!=null?nx.getText():null), Struct.Type.ObjCClass))); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            char_literal18=(Token)match(input,28,FOLLOW_28_in_forwardClassDecl409); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal18_tree = (Object)adaptor.create(char_literal18);
            adaptor.addChild(root_0, char_literal18_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:291:1: functionPointerVarDecl returns [List<? extends Declaration> declarations] : typeRef {...}? ';' ;
    public final ObjCppParser.functionPointerVarDecl_return functionPointerVarDecl() throws RecognitionException {
        ObjCppParser.functionPointerVarDecl_return retval = new ObjCppParser.functionPointerVarDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal20=null;
        ObjCppParser.typeRef_return typeRef19 = null;


        Object char_literal20_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:292:2: ( typeRef {...}? ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:292:4: typeRef {...}? ';'
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_typeRef_in_functionPointerVarDecl427);
            typeRef19=typeRef();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRef19.getTree());
            if ( !((
            			((typeRef19!=null?typeRef19.type:null) instanceof FunctionSignature) && 
            			((FunctionSignature)(typeRef19!=null?typeRef19.type:null)).getFunction().getName() != null
            		)) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "functionPointerVarDecl", "\n\t\t\t($typeRef.type instanceof FunctionSignature) && \n\t\t\t((FunctionSignature)$typeRef.type).getFunction().getName() != null\n\t\t");
            }
            if ( state.backtracking==0 ) {

              			retval.declarations = Arrays.asList(new FunctionPointerDeclaration(((FunctionSignature)(typeRef19!=null?typeRef19.type:null))));
              		
            }
            char_literal20=(Token)match(input,28,FOLLOW_28_in_functionPointerVarDecl435); if (state.failed) return retval;
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
    // $ANTLR end "functionPointerVarDecl"

    public static class enumItem_return extends ParserRuleReturnScope {
        public Enum.EnumItem item;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "enumItem"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:301:1: enumItem returns [Enum.EnumItem item] : n= IDENTIFIER ( '=' v= expression )? ;
    public final ObjCppParser.enumItem_return enumItem() throws RecognitionException {
        ObjCppParser.enumItem_return retval = new ObjCppParser.enumItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token char_literal21=null;
        ObjCppParser.expression_return v = null;


        Object n_tree=null;
        Object char_literal21_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:302:2: (n= IDENTIFIER ( '=' v= expression )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:302:4: n= IDENTIFIER ( '=' v= expression )?
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumItem453); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:302:17: ( '=' v= expression )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==29) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:302:18: '=' v= expression
                    {
                    char_literal21=(Token)match(input,29,FOLLOW_29_in_enumItem456); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal21_tree = (Object)adaptor.create(char_literal21);
                    adaptor.addChild(root_0, char_literal21_tree);
                    }
                    pushFollow(FOLLOW_expression_in_enumItem460);
                    v=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			retval.item = new Enum.EnumItem((n!=null?n.getText():null), (v!=null?input.toString(v.start,v.stop):null) == null ? null : (v!=null?v.expr:null));
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

    public static class enumCore_return extends ParserRuleReturnScope {
        public Enum e;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "enumCore"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:308:1: enumCore returns [Enum e] : t= 'enum' (n1= IDENTIFIER )? '{' i1= enumItem ( ',' (ix= enumItem )? )* '}' ;
    public final ObjCppParser.enumCore_return enumCore() throws RecognitionException {
        ObjCppParser.enumCore_return retval = new ObjCppParser.enumCore_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token t=null;
        Token n1=null;
        Token char_literal22=null;
        Token char_literal23=null;
        Token char_literal24=null;
        ObjCppParser.enumItem_return i1 = null;

        ObjCppParser.enumItem_return ix = null;


        Object t_tree=null;
        Object n1_tree=null;
        Object char_literal22_tree=null;
        Object char_literal23_tree=null;
        Object char_literal24_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:309:2: (t= 'enum' (n1= IDENTIFIER )? '{' i1= enumItem ( ',' (ix= enumItem )? )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:310:3: t= 'enum' (n1= IDENTIFIER )? '{' i1= enumItem ( ',' (ix= enumItem )? )* '}'
            {
            root_0 = (Object)adaptor.nil();

            t=(Token)match(input,30,FOLLOW_30_in_enumCore484); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            t_tree = (Object)adaptor.create(t);
            adaptor.addChild(root_0, t_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.e = mark(new Enum(), getLine(t));
              			retval.e.setCommentBefore(getCommentBefore(t.getTokenIndex()));
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:313:5: (n1= IDENTIFIER )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==IDENTIFIER) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:314:4: n1= IDENTIFIER
                    {
                    n1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumCore495); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    n1_tree = (Object)adaptor.create(n1);
                    adaptor.addChild(root_0, n1_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				retval.e.setTag((n1!=null?n1.getText():null));
                      			
                    }

                    }
                    break;

            }

            char_literal22=(Token)match(input,23,FOLLOW_23_in_enumCore507); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal22_tree = (Object)adaptor.create(char_literal22);
            adaptor.addChild(root_0, char_literal22_tree);
            }
            pushFollow(FOLLOW_enumItem_in_enumCore514);
            i1=enumItem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, i1.getTree());
            if ( state.backtracking==0 ) {
               
              				retval.e.addItem((i1!=null?i1.item:null)); 
              			
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:322:4: ( ',' (ix= enumItem )? )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==27) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:323:5: ',' (ix= enumItem )?
            	    {
            	    char_literal23=(Token)match(input,27,FOLLOW_27_in_enumCore527); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal23_tree = (Object)adaptor.create(char_literal23);
            	    adaptor.addChild(root_0, char_literal23_tree);
            	    }
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:324:5: (ix= enumItem )?
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( (LA10_0==IDENTIFIER) ) {
            	        alt10=1;
            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:324:6: ix= enumItem
            	            {
            	            pushFollow(FOLLOW_enumItem_in_enumCore537);
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
            	    break loop11;
                }
            } while (true);

            char_literal24=(Token)match(input,24,FOLLOW_24_in_enumCore551); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal24_tree = (Object)adaptor.create(char_literal24);
            adaptor.addChild(root_0, char_literal24_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:339:1: objCClassDef returns [Struct struct] : octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl {...}?)* '@end' ;
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
        Token char_literal25=null;
        Token char_literal26=null;
        Token char_literal27=null;
        Token char_literal28=null;
        Token char_literal29=null;
        Token char_literal30=null;
        Token char_literal31=null;
        Token string_literal32=null;
        Token string_literal33=null;
        Token string_literal34=null;
        Token char_literal36=null;
        Token string_literal39=null;
        ObjCppParser.varDecl_return fv = null;

        ObjCppParser.varDecl_return vd = null;

        ObjCppParser.functionPointerVarDecl_return functionPointerVarDecl35 = null;

        ObjCppParser.objCMethodDecl_return objCMethodDecl37 = null;

        ObjCppParser.typeDef_return typeDef38 = null;


        Object octype_tree=null;
        Object className_tree=null;
        Object parentClass_tree=null;
        Object categoryName_tree=null;
        Object p1_tree=null;
        Object px_tree=null;
        Object char_literal25_tree=null;
        Object char_literal26_tree=null;
        Object char_literal27_tree=null;
        Object char_literal28_tree=null;
        Object char_literal29_tree=null;
        Object char_literal30_tree=null;
        Object char_literal31_tree=null;
        Object string_literal32_tree=null;
        Object string_literal33_tree=null;
        Object string_literal34_tree=null;
        Object char_literal36_tree=null;
        Object string_literal39_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:340:2: (octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl {...}?)* '@end' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:341:3: octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl {...}?)* '@end'
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

            className=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef589); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            className_tree = (Object)adaptor.create(className);
            adaptor.addChild(root_0, className_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.struct = mark(new Struct(), getLine(octype));
              			retval.struct.setCommentBefore(getCommentBefore(octype.getTokenIndex()));
              			retval.struct.setType((octype!=null?octype.getText():null).equals("@interface") ?
              				Struct.Type.ObjCClass :
              				Struct.Type.ObjCProtocol
              			);
              			retval.struct.setTag((className!=null?className.getText():null));
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:351:3: ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' )
            int alt13=2;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:352:4: ( ':' parentClass= IDENTIFIER )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:352:4: ( ':' parentClass= IDENTIFIER )?
                    int alt12=2;
                    alt12 = dfa12.predict(input);
                    switch (alt12) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:353:5: ':' parentClass= IDENTIFIER
                            {
                            char_literal25=(Token)match(input,33,FOLLOW_33_in_objCClassDef607); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal25_tree = (Object)adaptor.create(char_literal25);
                            adaptor.addChild(root_0, char_literal25_tree);
                            }
                            parentClass=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef611); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:358:4: '(' categoryName= IDENTIFIER ')'
                    {
                    char_literal26=(Token)match(input,34,FOLLOW_34_in_objCClassDef626); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal26_tree = (Object)adaptor.create(char_literal26);
                    adaptor.addChild(root_0, char_literal26_tree);
                    }
                    categoryName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef630); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    categoryName_tree = (Object)adaptor.create(categoryName);
                    adaptor.addChild(root_0, categoryName_tree);
                    }
                    char_literal27=(Token)match(input,35,FOLLOW_35_in_objCClassDef632); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal27_tree = (Object)adaptor.create(char_literal27);
                    adaptor.addChild(root_0, char_literal27_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				retval.struct.setCategoryName((categoryName!=null?categoryName.getText():null));
                      			
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:362:3: ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )?
            int alt16=2;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:363:4: '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>'
                    {
                    char_literal28=(Token)match(input,36,FOLLOW_36_in_objCClassDef648); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal28_tree = (Object)adaptor.create(char_literal28);
                    adaptor.addChild(root_0, char_literal28_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:363:8: (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==IDENTIFIER) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:364:5: p1= IDENTIFIER ( ',' px= IDENTIFIER )*
                            {
                            p1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef658); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            p1_tree = (Object)adaptor.create(p1);
                            adaptor.addChild(root_0, p1_tree);
                            }
                            if ( state.backtracking==0 ) {
                               retval.struct.addProtocol((p1!=null?p1.getText():null)); 
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:365:5: ( ',' px= IDENTIFIER )*
                            loop14:
                            do {
                                int alt14=2;
                                int LA14_0 = input.LA(1);

                                if ( (LA14_0==27) ) {
                                    alt14=1;
                                }


                                switch (alt14) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:366:6: ',' px= IDENTIFIER
                            	    {
                            	    char_literal29=(Token)match(input,27,FOLLOW_27_in_objCClassDef673); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    char_literal29_tree = (Object)adaptor.create(char_literal29);
                            	    adaptor.addChild(root_0, char_literal29_tree);
                            	    }
                            	    px=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef683); if (state.failed) return retval;
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
                            	    break loop14;
                                }
                            } while (true);


                            }
                            break;

                    }

                    char_literal30=(Token)match(input,37,FOLLOW_37_in_objCClassDef700); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal30_tree = (Object)adaptor.create(char_literal30);
                    adaptor.addChild(root_0, char_literal30_tree);
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:371:3: ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )?
            int alt19=2;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:372:4: '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}'
                    {
                    char_literal31=(Token)match(input,23,FOLLOW_23_in_objCClassDef714); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal31_tree = (Object)adaptor.create(char_literal31);
                    adaptor.addChild(root_0, char_literal31_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:373:4: ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )*
                    loop18:
                    do {
                        int alt18=5;
                        alt18 = dfa18.predict(input);
                        switch (alt18) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:374:5: '@public'
                    	    {
                    	    string_literal32=(Token)match(input,38,FOLLOW_38_in_objCClassDef726); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    string_literal32_tree = (Object)adaptor.create(string_literal32);
                    	    adaptor.addChild(root_0, string_literal32_tree);
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Public); 
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:375:5: '@private'
                    	    {
                    	    string_literal33=(Token)match(input,39,FOLLOW_39_in_objCClassDef737); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    string_literal33_tree = (Object)adaptor.create(string_literal33);
                    	    adaptor.addChild(root_0, string_literal33_tree);
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Private); 
                    	    }

                    	    }
                    	    break;
                    	case 3 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:376:5: '@protected'
                    	    {
                    	    string_literal34=(Token)match(input,40,FOLLOW_40_in_objCClassDef748); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    string_literal34_tree = (Object)adaptor.create(string_literal34);
                    	    adaptor.addChild(root_0, string_literal34_tree);
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Protected); 
                    	    }

                    	    }
                    	    break;
                    	case 4 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:377:5: ( (fv= varDecl | functionPointerVarDecl ) )
                    	    {
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:377:5: ( (fv= varDecl | functionPointerVarDecl ) )
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:378:6: (fv= varDecl | functionPointerVarDecl )
                    	    {
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:378:6: (fv= varDecl | functionPointerVarDecl )
                    	    int alt17=2;
                    	    alt17 = dfa17.predict(input);
                    	    switch (alt17) {
                    	        case 1 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:379:7: fv= varDecl
                    	            {
                    	            pushFollow(FOLLOW_varDecl_in_objCClassDef775);
                    	            fv=varDecl();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) adaptor.addChild(root_0, fv.getTree());
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              							retval.struct.addDeclaration((fv!=null?fv.decl:null)); 
                    	              						
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:382:7: functionPointerVarDecl
                    	            {
                    	            pushFollow(FOLLOW_functionPointerVarDecl_in_objCClassDef787);
                    	            functionPointerVarDecl35=functionPointerVarDecl();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) adaptor.addChild(root_0, functionPointerVarDecl35.getTree());
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              							retval.struct.addDeclarations((functionPointerVarDecl35!=null?functionPointerVarDecl35.declarations:null)); 
                    	              						
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    char_literal36=(Token)match(input,24,FOLLOW_24_in_objCClassDef814); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal36_tree = (Object)adaptor.create(char_literal36);
                    adaptor.addChild(root_0, char_literal36_tree);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Public); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:391:3: ( objCMethodDecl | typeDef | vd= varDecl {...}?)*
            loop20:
            do {
                int alt20=4;
                alt20 = dfa20.predict(input);
                switch (alt20) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:392:4: objCMethodDecl
            	    {
            	    pushFollow(FOLLOW_objCMethodDecl_in_objCClassDef832);
            	    objCMethodDecl37=objCMethodDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, objCMethodDecl37.getTree());
            	    if ( state.backtracking==0 ) {
            	       
            	      				retval.struct.addDeclaration((objCMethodDecl37!=null?objCMethodDecl37.function:null)); 
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:395:4: typeDef
            	    {
            	    pushFollow(FOLLOW_typeDef_in_objCClassDef841);
            	    typeDef38=typeDef();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeDef38.getTree());
            	    if ( state.backtracking==0 ) {

            	      				retval.struct.addDeclaration((typeDef38!=null?typeDef38.typeDef:null)); 
            	      			
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:398:4: vd= varDecl {...}?
            	    {
            	    pushFollow(FOLLOW_varDecl_in_objCClassDef852);
            	    vd=varDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, vd.getTree());
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
            	    break loop20;
                }
            } while (true);

            string_literal39=(Token)match(input,41,FOLLOW_41_in_objCClassDef865); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal39_tree = (Object)adaptor.create(string_literal39);
            adaptor.addChild(root_0, string_literal39_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:405:1: objCMethodDecl returns [Function function] : tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= typeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';' ;
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
        Token char_literal40=null;
        Token char_literal41=null;
        Token char_literal42=null;
        Token char_literal43=null;
        Token char_literal44=null;
        Token char_literal45=null;
        Token char_literal46=null;
        Token char_literal47=null;
        Token char_literal48=null;
        Token string_literal49=null;
        Token char_literal50=null;
        ObjCppParser.typeRef_return returnTypeRef = null;

        ObjCppParser.typeRef_return argType1 = null;

        ObjCppParser.typeRef_return argType = null;


        Object tp_tree=null;
        Object tm_tree=null;
        Object tk_tree=null;
        Object methodName_tree=null;
        Object argName1_tree=null;
        Object sel_tree=null;
        Object argName_tree=null;
        Object char_literal40_tree=null;
        Object char_literal41_tree=null;
        Object char_literal42_tree=null;
        Object char_literal43_tree=null;
        Object char_literal44_tree=null;
        Object char_literal45_tree=null;
        Object char_literal46_tree=null;
        Object char_literal47_tree=null;
        Object char_literal48_tree=null;
        Object string_literal49_tree=null;
        Object char_literal50_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:406:2: (tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= typeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:406:4: tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= typeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               	
              			retval.function = new Function(); 
              			retval.function.setType(Function.Type.ObjCMethod);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:410:6: (tp= '+' | tm= '-' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==42) ) {
                alt21=1;
            }
            else if ( (LA21_0==43) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:411:4: tp= '+'
                    {
                    tp=(Token)match(input,42,FOLLOW_42_in_objCMethodDecl899); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:416:4: tm= '-'
                    {
                    tm=(Token)match(input,43,FOLLOW_43_in_objCMethodDecl911); if (state.failed) return retval;
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:421:3: ( '(' (returnTypeRef= typeRef )? ')' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==34) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:423:4: '(' (returnTypeRef= typeRef )? ')'
                    {
                    char_literal40=(Token)match(input,34,FOLLOW_34_in_objCMethodDecl930); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal40_tree = (Object)adaptor.create(char_literal40);
                    adaptor.addChild(root_0, char_literal40_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:424:18: (returnTypeRef= typeRef )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==IDENTIFIER||LA22_0==30||(LA22_0>=45 && LA22_0<=47)||(LA22_0>=59 && LA22_0<=73)) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: returnTypeRef= typeRef
                            {
                            pushFollow(FOLLOW_typeRef_in_objCMethodDecl938);
                            returnTypeRef=typeRef();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, returnTypeRef.getTree());

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       
                      					retval.function.setValueType((returnTypeRef!=null?returnTypeRef.type:null)); 
                      				
                    }
                    char_literal41=(Token)match(input,35,FOLLOW_35_in_objCMethodDecl946); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal41_tree = (Object)adaptor.create(char_literal41);
                    adaptor.addChild(root_0, char_literal41_tree);
                    }

                    }
                    break;

            }

            methodName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl957); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            methodName_tree = (Object)adaptor.create(methodName);
            adaptor.addChild(root_0, methodName_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.function.setName((methodName!=null?methodName.getText():null)); 
              			retval.function.setCommentAfter(getCommentAfterOnSameLine(methodName.getTokenIndex()));
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:433:3: ( ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==33) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:434:4: ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )?
                    {
                    char_literal42=(Token)match(input,33,FOLLOW_33_in_objCMethodDecl969); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal42_tree = (Object)adaptor.create(char_literal42);
                    adaptor.addChild(root_0, char_literal42_tree);
                    }
                    char_literal43=(Token)match(input,34,FOLLOW_34_in_objCMethodDecl971); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal43_tree = (Object)adaptor.create(char_literal43);
                    adaptor.addChild(root_0, char_literal43_tree);
                    }
                    pushFollow(FOLLOW_typeRef_in_objCMethodDecl975);
                    argType1=typeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, argType1.getTree());
                    char_literal44=(Token)match(input,35,FOLLOW_35_in_objCMethodDecl977); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal44_tree = (Object)adaptor.create(char_literal44);
                    adaptor.addChild(root_0, char_literal44_tree);
                    }
                    argName1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl981); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    argName1_tree = (Object)adaptor.create(argName1);
                    adaptor.addChild(root_0, argName1_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				Arg arg = new Arg((argName1!=null?argName1.getText():null), (argType1!=null?argType1.type:null));
                      				arg.setSelector((methodName!=null?methodName.getText():null));
                      				retval.function.addArg(arg);
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:439:4: (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==IDENTIFIER) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:440:5: sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER
                    	    {
                    	    sel=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl996); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    sel_tree = (Object)adaptor.create(sel);
                    	    adaptor.addChild(root_0, sel_tree);
                    	    }
                    	    char_literal45=(Token)match(input,33,FOLLOW_33_in_objCMethodDecl998); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal45_tree = (Object)adaptor.create(char_literal45);
                    	    adaptor.addChild(root_0, char_literal45_tree);
                    	    }
                    	    char_literal46=(Token)match(input,34,FOLLOW_34_in_objCMethodDecl1005); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal46_tree = (Object)adaptor.create(char_literal46);
                    	    adaptor.addChild(root_0, char_literal46_tree);
                    	    }
                    	    pushFollow(FOLLOW_typeRef_in_objCMethodDecl1009);
                    	    argType=typeRef();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, argType.getTree());
                    	    char_literal47=(Token)match(input,35,FOLLOW_35_in_objCMethodDecl1011); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal47_tree = (Object)adaptor.create(char_literal47);
                    	    adaptor.addChild(root_0, char_literal47_tree);
                    	    }
                    	    argName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1020); if (state.failed) return retval;
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
                    	    break loop24;
                        }
                    } while (true);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:448:4: ( ',' '...' )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==27) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:449:5: ',' '...'
                            {
                            char_literal48=(Token)match(input,27,FOLLOW_27_in_objCMethodDecl1039); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal48_tree = (Object)adaptor.create(char_literal48);
                            adaptor.addChild(root_0, char_literal48_tree);
                            }
                            string_literal49=(Token)match(input,44,FOLLOW_44_in_objCMethodDecl1041); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal49_tree = (Object)adaptor.create(string_literal49);
                            adaptor.addChild(root_0, string_literal49_tree);
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

            char_literal50=(Token)match(input,28,FOLLOW_28_in_objCMethodDecl1058); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal50_tree = (Object)adaptor.create(char_literal50);
            adaptor.addChild(root_0, char_literal50_tree);
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

    public static class structCore_return extends ParserRuleReturnScope {
        public Struct struct;
        public List<Modifier> modifiers;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "structCore"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:470:1: structCore returns [Struct struct, List<Modifier> modifiers] : t= ( 'struct' | 'class' | 'union' ) ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' ) ;
    public final ObjCppParser.structCore_return structCore() throws RecognitionException {
        ObjCppParser.structCore_return retval = new ObjCppParser.structCore_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token t=null;
        Token n0=null;
        Token n1=null;
        Token char_literal52=null;
        Token string_literal53=null;
        Token string_literal54=null;
        Token string_literal55=null;
        Token char_literal56=null;
        Token char_literal58=null;
        ObjCppParser.exportationModifiers_return exportationModifiers51 = null;

        ObjCppParser.declaration_return declaration57 = null;


        Object t_tree=null;
        Object n0_tree=null;
        Object n1_tree=null;
        Object char_literal52_tree=null;
        Object string_literal53_tree=null;
        Object string_literal54_tree=null;
        Object string_literal55_tree=null;
        Object char_literal56_tree=null;
        Object char_literal58_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:471:2: (t= ( 'struct' | 'class' | 'union' ) ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:473:3: t= ( 'struct' | 'class' | 'union' ) ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' )
            {
            root_0 = (Object)adaptor.nil();

            t=(Token)input.LT(1);
            if ( (input.LA(1)>=45 && input.LA(1)<=47) ) {
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
               
              			retval.struct = mark(new Struct(), getLine(t)); 
              			retval.struct.setType(
              				(t!=null?t.getText():null).equals("struct") ?	Struct.Type.CStruct :
              				(t!=null?t.getText():null).equals("union") ?	Struct.Type.CUnion :
              							Struct.Type.CPPClass
              			);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:481:3: ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' )
            int alt31=2;
            alt31 = dfa31.predict(input);
            switch (alt31) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:482:4: (n0= IDENTIFIER )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:482:4: (n0= IDENTIFIER )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:483:5: n0= IDENTIFIER
                    {
                    n0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_structCore1113); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    n0_tree = (Object)adaptor.create(n0);
                    adaptor.addChild(root_0, n0_tree);
                    }
                    if ( state.backtracking==0 ) {

                      					retval.struct.setTag((n0!=null?n0.getText():null));
                      					retval.struct.setForwardDeclaration(true);
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:488:4: ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}'
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:488:4: ( ( exportationModifiers )? n1= IDENTIFIER )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==IDENTIFIER) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:489:5: ( exportationModifiers )? n1= IDENTIFIER
                            {
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:489:5: ( exportationModifiers )?
                            int alt27=2;
                            int LA27_0 = input.LA(1);

                            if ( (LA27_0==IDENTIFIER) ) {
                                int LA27_1 = input.LA(2);

                                if ( (synpred41_ObjCpp()) ) {
                                    alt27=1;
                                }
                            }
                            switch (alt27) {
                                case 1 :
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:489:7: exportationModifiers
                                    {
                                    pushFollow(FOLLOW_exportationModifiers_in_structCore1136);
                                    exportationModifiers51=exportationModifiers();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) adaptor.addChild(root_0, exportationModifiers51.getTree());
                                    if ( state.backtracking==0 ) {

                                      					for (Modifier m : (exportationModifiers51!=null?exportationModifiers51.modifiers:null))
                                      						retval.struct.addModifiers(m);
                                      				
                                    }

                                    }
                                    break;

                            }

                            n1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_structCore1149); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            n1_tree = (Object)adaptor.create(n1);
                            adaptor.addChild(root_0, n1_tree);
                            }
                            if ( state.backtracking==0 ) {
                               retval.struct.setTag((n1!=null?n1.getText():null)); 
                            }

                            }
                            break;

                    }

                    char_literal52=(Token)match(input,23,FOLLOW_23_in_structCore1163); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal52_tree = (Object)adaptor.create(char_literal52);
                    adaptor.addChild(root_0, char_literal52_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:496:5: ( ( 'public' | 'private' | 'protected' ) ':' | declaration )*
                    loop30:
                    do {
                        int alt30=3;
                        alt30 = dfa30.predict(input);
                        switch (alt30) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:497:6: ( 'public' | 'private' | 'protected' ) ':'
                    	    {
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:497:6: ( 'public' | 'private' | 'protected' )
                    	    int alt29=3;
                    	    switch ( input.LA(1) ) {
                    	    case 48:
                    	        {
                    	        alt29=1;
                    	        }
                    	        break;
                    	    case 49:
                    	        {
                    	        alt29=2;
                    	        }
                    	        break;
                    	    case 50:
                    	        {
                    	        alt29=3;
                    	        }
                    	        break;
                    	    default:
                    	        if (state.backtracking>0) {state.failed=true; return retval;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 29, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt29) {
                    	        case 1 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:498:7: 'public'
                    	            {
                    	            string_literal53=(Token)match(input,48,FOLLOW_48_in_structCore1184); if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) {
                    	            string_literal53_tree = (Object)adaptor.create(string_literal53);
                    	            adaptor.addChild(root_0, string_literal53_tree);
                    	            }
                    	            if ( state.backtracking==0 ) {
                    	               retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Public); 
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:499:7: 'private'
                    	            {
                    	            string_literal54=(Token)match(input,49,FOLLOW_49_in_structCore1197); if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) {
                    	            string_literal54_tree = (Object)adaptor.create(string_literal54);
                    	            adaptor.addChild(root_0, string_literal54_tree);
                    	            }
                    	            if ( state.backtracking==0 ) {
                    	               retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Private); 
                    	            }

                    	            }
                    	            break;
                    	        case 3 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:500:7: 'protected'
                    	            {
                    	            string_literal55=(Token)match(input,50,FOLLOW_50_in_structCore1210); if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) {
                    	            string_literal55_tree = (Object)adaptor.create(string_literal55);
                    	            adaptor.addChild(root_0, string_literal55_tree);
                    	            }
                    	            if ( state.backtracking==0 ) {
                    	               retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Protected); 
                    	            }

                    	            }
                    	            break;

                    	    }

                    	    char_literal56=(Token)match(input,33,FOLLOW_33_in_structCore1222); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal56_tree = (Object)adaptor.create(char_literal56);
                    	    adaptor.addChild(root_0, char_literal56_tree);
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:502:6: declaration
                    	    {
                    	    pushFollow(FOLLOW_declaration_in_structCore1231);
                    	    declaration57=declaration();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration57.getTree());
                    	    if ( state.backtracking==0 ) {

                    	      						retval.struct.addDeclarations((declaration57!=null?declaration57.declarations:null));
                    	      					
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    char_literal58=(Token)match(input,24,FOLLOW_24_in_structCore1245); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal58_tree = (Object)adaptor.create(char_literal58);
                    adaptor.addChild(root_0, char_literal58_tree);
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
    // $ANTLR end "structCore"

    public static class functionDeclaration_return extends ParserRuleReturnScope {
        public Function function;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionDeclaration"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:511:1: functionDeclaration returns [Function function] : (returnTypeRef= typeRef )? preMods= exportationModifiers n= IDENTIFIER '(' argList ')' {...}? (ct= IDENTIFIER )? postMods= exportationModifiers ( ';' | statementsBlock ) ;
    public final ObjCppParser.functionDeclaration_return functionDeclaration() throws RecognitionException {
        ObjCppParser.functionDeclaration_return retval = new ObjCppParser.functionDeclaration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token ct=null;
        Token char_literal59=null;
        Token char_literal61=null;
        Token char_literal62=null;
        ObjCppParser.typeRef_return returnTypeRef = null;

        ObjCppParser.exportationModifiers_return preMods = null;

        ObjCppParser.exportationModifiers_return postMods = null;

        ObjCppParser.argList_return argList60 = null;

        ObjCppParser.statementsBlock_return statementsBlock63 = null;


        Object n_tree=null;
        Object ct_tree=null;
        Object char_literal59_tree=null;
        Object char_literal61_tree=null;
        Object char_literal62_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:512:2: ( (returnTypeRef= typeRef )? preMods= exportationModifiers n= IDENTIFIER '(' argList ')' {...}? (ct= IDENTIFIER )? postMods= exportationModifiers ( ';' | statementsBlock ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:512:4: (returnTypeRef= typeRef )? preMods= exportationModifiers n= IDENTIFIER '(' argList ')' {...}? (ct= IDENTIFIER )? postMods= exportationModifiers ( ';' | statementsBlock )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               	
              			retval.function = new Function();
              			retval.function.setType(Function.Type.CFunction);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:519:16: (returnTypeRef= typeRef )?
            int alt32=2;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: returnTypeRef= typeRef
                    {
                    pushFollow(FOLLOW_typeRef_in_functionDeclaration1275);
                    returnTypeRef=typeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnTypeRef.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               
              			retval.function.setValueType((returnTypeRef!=null?returnTypeRef.type:null)); 
              		
            }
            pushFollow(FOLLOW_exportationModifiers_in_functionDeclaration1284);
            preMods=exportationModifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, preMods.getTree());
            if ( state.backtracking==0 ) {

              			for (Modifier m : (preMods!=null?preMods.modifiers:null))
              				retval.function.addModifiers(m);
              		
            }
            n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionDeclaration1292); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.function.setName((n!=null?n.getText():null)); 
              			retval.function = mark(retval.function, getLine(n));
              		
            }
            char_literal59=(Token)match(input,34,FOLLOW_34_in_functionDeclaration1299); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal59_tree = (Object)adaptor.create(char_literal59);
            adaptor.addChild(root_0, char_literal59_tree);
            }
            pushFollow(FOLLOW_argList_in_functionDeclaration1305);
            argList60=argList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, argList60.getTree());
            if ( state.backtracking==0 ) {

              				retval.function.setArgs((argList60!=null?argList60.args:null));
              			
            }
            char_literal61=(Token)match(input,35,FOLLOW_35_in_functionDeclaration1311); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal61_tree = (Object)adaptor.create(char_literal61);
            adaptor.addChild(root_0, char_literal61_tree);
            }
            if ( !(( next("const", "__const") )) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "functionDeclaration", " next(\"const\", \"__const\") ");
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:535:35: (ct= IDENTIFIER )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==IDENTIFIER) ) {
                int LA33_1 = input.LA(2);

                if ( (synpred48_ObjCpp()) ) {
                    alt33=1;
                }
            }
            switch (alt33) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: ct= IDENTIFIER
                    {
                    ct=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionDeclaration1320); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ct_tree = (Object)adaptor.create(ct);
                    adaptor.addChild(root_0, ct_tree);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			if ((ct!=null?ct.getText():null) != null)
              				retval.function.addModifiers(Modifier.Const);
              		
            }
            pushFollow(FOLLOW_exportationModifiers_in_functionDeclaration1329);
            postMods=exportationModifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, postMods.getTree());
            if ( state.backtracking==0 ) {

              			for (Modifier m : (postMods!=null?postMods.modifiers:null))
              				retval.function.addModifiers(m);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:543:3: ( ';' | statementsBlock )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==28) ) {
                alt34=1;
            }
            else if ( (LA34_0==23) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:544:4: ';'
                    {
                    char_literal62=(Token)match(input,28,FOLLOW_28_in_functionDeclaration1341); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal62_tree = (Object)adaptor.create(char_literal62);
                    adaptor.addChild(root_0, char_literal62_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:545:4: statementsBlock
                    {
                    pushFollow(FOLLOW_statementsBlock_in_functionDeclaration1348);
                    statementsBlock63=statementsBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementsBlock63.getTree());
                    if ( state.backtracking==0 ) {

                      			
                      			
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
    // $ANTLR end "functionDeclaration"

    public static class functionDefinition_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionDefinition"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:551:1: functionDefinition : functionDeclaration '{' '}' ;
    public final ObjCppParser.functionDefinition_return functionDefinition() throws RecognitionException {
        ObjCppParser.functionDefinition_return retval = new ObjCppParser.functionDefinition_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal65=null;
        Token char_literal66=null;
        ObjCppParser.functionDeclaration_return functionDeclaration64 = null;


        Object char_literal65_tree=null;
        Object char_literal66_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:552:2: ( functionDeclaration '{' '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:552:4: functionDeclaration '{' '}'
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_functionDeclaration_in_functionDefinition1365);
            functionDeclaration64=functionDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, functionDeclaration64.getTree());
            char_literal65=(Token)match(input,23,FOLLOW_23_in_functionDefinition1367); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal65_tree = (Object)adaptor.create(char_literal65);
            adaptor.addChild(root_0, char_literal65_tree);
            }
            char_literal66=(Token)match(input,24,FOLLOW_24_in_functionDefinition1369); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal66_tree = (Object)adaptor.create(char_literal66);
            adaptor.addChild(root_0, char_literal66_tree);
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
    // $ANTLR end "functionDefinition"

    public static class exportationModifiers_return extends ParserRuleReturnScope {
        public List<Modifier> modifiers;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exportationModifiers"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:555:1: exportationModifiers returns [List<Modifier> modifiers] : ( exportationModifier )* ;
    public final ObjCppParser.exportationModifiers_return exportationModifiers() throws RecognitionException {
        ObjCppParser.exportationModifiers_return retval = new ObjCppParser.exportationModifiers_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.exportationModifier_return exportationModifier67 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:556:2: ( ( exportationModifier )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:556:5: ( exportationModifier )*
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:557:3: ( exportationModifier )*
            loop35:
            do {
                int alt35=2;
                alt35 = dfa35.predict(input);
                switch (alt35) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:558:4: exportationModifier
            	    {
            	    pushFollow(FOLLOW_exportationModifier_in_exportationModifiers1396);
            	    exportationModifier67=exportationModifier();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, exportationModifier67.getTree());
            	    if ( state.backtracking==0 ) {
            	       
            	      				retval.modifiers.addAll((exportationModifier67!=null?exportationModifier67.modifiers:null)); 
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop35;
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
    // $ANTLR end "exportationModifiers"

    public static class modifier_return extends ParserRuleReturnScope {
        public Modifier modifier;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "modifier"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:564:1: modifier returns [Modifier modifier] : {...}? IDENTIFIER ;
    public final ObjCppParser.modifier_return modifier() throws RecognitionException {
        ObjCppParser.modifier_return retval = new ObjCppParser.modifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER68=null;

        Object IDENTIFIER68_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:565:2: ({...}? IDENTIFIER )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:565:4: {...}? IDENTIFIER
            {
            root_0 = (Object)adaptor.nil();

            if ( !(( Modifier.parseModifier(next()) != null )) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "modifier", " Modifier.parseModifier(next()) != null ");
            }
            IDENTIFIER68=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier1423); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER68_tree = (Object)adaptor.create(IDENTIFIER68);
            adaptor.addChild(root_0, IDENTIFIER68_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.modifier = Modifier.parseModifier((IDENTIFIER68!=null?IDENTIFIER68.getText():null));
              		
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
    // $ANTLR end "modifier"

    public static class exportationModifier_return extends ParserRuleReturnScope {
        public List<Modifier> modifiers;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exportationModifier"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:578:1: exportationModifier returns [List<Modifier> modifiers] : ({...}? modifier | IDENTIFIER {...}? '(' extendedModifiers ')' ) ;
    public final ObjCppParser.exportationModifier_return exportationModifier() throws RecognitionException {
        ObjCppParser.exportationModifier_return retval = new ObjCppParser.exportationModifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER70=null;
        Token char_literal71=null;
        Token char_literal73=null;
        ObjCppParser.modifier_return modifier69 = null;

        ObjCppParser.extendedModifiers_return extendedModifiers72 = null;


        Object IDENTIFIER70_tree=null;
        Object char_literal71_tree=null;
        Object char_literal73_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:579:2: ( ({...}? modifier | IDENTIFIER {...}? '(' extendedModifiers ')' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:579:5: ({...}? modifier | IDENTIFIER {...}? '(' extendedModifiers ')' )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:580:3: ({...}? modifier | IDENTIFIER {...}? '(' extendedModifiers ')' )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==IDENTIFIER) ) {
                int LA36_1 = input.LA(2);

                if ( (LA36_1==EOF||LA36_1==IDENTIFIER||LA36_1==23||LA36_1==28||LA36_1==51) ) {
                    alt36=1;
                }
                else if ( (LA36_1==34) ) {
                    alt36=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:581:4: {...}? modifier
                    {
                    if ( !(( next(Modifier.Kind.Plain) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "exportationModifier", " next(Modifier.Kind.Plain) ");
                    }
                    pushFollow(FOLLOW_modifier_in_exportationModifier1455);
                    modifier69=modifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modifier69.getTree());
                    if ( state.backtracking==0 ) {

                      				retval.modifiers.add((modifier69!=null?modifier69.modifier:null));
                      			
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:584:4: IDENTIFIER {...}? '(' extendedModifiers ')'
                    {
                    IDENTIFIER70=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_exportationModifier1464); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER70_tree = (Object)adaptor.create(IDENTIFIER70);
                    adaptor.addChild(root_0, IDENTIFIER70_tree);
                    }
                    if ( !(( (IDENTIFIER70!=null?IDENTIFIER70.getText():null).equals("__declspec") || (IDENTIFIER70!=null?IDENTIFIER70.getText():null).equals("__attribute__") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "exportationModifier", " $IDENTIFIER.text.equals(\"__declspec\") || $IDENTIFIER.text.equals(\"__attribute__\") ");
                    }
                    char_literal71=(Token)match(input,34,FOLLOW_34_in_exportationModifier1472); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal71_tree = (Object)adaptor.create(char_literal71);
                    adaptor.addChild(root_0, char_literal71_tree);
                    }
                    pushFollow(FOLLOW_extendedModifiers_in_exportationModifier1474);
                    extendedModifiers72=extendedModifiers();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, extendedModifiers72.getTree());
                    char_literal73=(Token)match(input,35,FOLLOW_35_in_exportationModifier1476); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal73_tree = (Object)adaptor.create(char_literal73);
                    adaptor.addChild(root_0, char_literal73_tree);
                    }
                    if ( state.backtracking==0 ) {

                      					retval.modifiers.addAll((extendedModifiers72!=null?extendedModifiers72.modifiers:null));
                      			
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
    // $ANTLR end "exportationModifier"

    public static class extendedModifiers_return extends ParserRuleReturnScope {
        public List<Modifier> modifiers;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "extendedModifiers"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:592:1: extendedModifiers returns [List<Modifier> modifiers] : ({...}?m= modifier () )* ;
    public final ObjCppParser.extendedModifiers_return extendedModifiers() throws RecognitionException {
        ObjCppParser.extendedModifiers_return retval = new ObjCppParser.extendedModifiers_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.modifier_return m = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:593:2: ( ({...}?m= modifier () )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:593:4: ({...}?m= modifier () )*
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:594:3: ({...}?m= modifier () )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==IDENTIFIER) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:595:4: {...}?m= modifier ()
            	    {
            	    if ( !(( next(Modifier.Kind.Extended) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "extendedModifiers", " next(Modifier.Kind.Extended) ");
            	    }
            	    pushFollow(FOLLOW_modifier_in_extendedModifiers1511);
            	    m=modifier();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, m.getTree());
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:596:4: ()
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:597:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					retval.modifiers.add((m!=null?m.modifier:null));
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:607:1: argDef returns [Arg arg] : ( typeRef ( IDENTIFIER ( arrayTypeMutator )? )? ( '=' expression )? | '...' );
    public final ObjCppParser.argDef_return argDef() throws RecognitionException {
        ObjCppParser.argDef_return retval = new ObjCppParser.argDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER75=null;
        Token char_literal77=null;
        Token string_literal79=null;
        ObjCppParser.typeRef_return typeRef74 = null;

        ObjCppParser.arrayTypeMutator_return arrayTypeMutator76 = null;

        ObjCppParser.expression_return expression78 = null;


        Object IDENTIFIER75_tree=null;
        Object char_literal77_tree=null;
        Object string_literal79_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:608:2: ( typeRef ( IDENTIFIER ( arrayTypeMutator )? )? ( '=' expression )? | '...' )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==IDENTIFIER||LA41_0==30||(LA41_0>=45 && LA41_0<=47)||(LA41_0>=59 && LA41_0<=73)) ) {
                alt41=1;
            }
            else if ( (LA41_0==44) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:608:4: typeRef ( IDENTIFIER ( arrayTypeMutator )? )? ( '=' expression )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_typeRef_in_argDef1547);
                    typeRef74=typeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRef74.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:608:12: ( IDENTIFIER ( arrayTypeMutator )? )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==IDENTIFIER) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:608:13: IDENTIFIER ( arrayTypeMutator )?
                            {
                            IDENTIFIER75=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_argDef1550); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            IDENTIFIER75_tree = (Object)adaptor.create(IDENTIFIER75);
                            adaptor.addChild(root_0, IDENTIFIER75_tree);
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:608:24: ( arrayTypeMutator )?
                            int alt38=2;
                            int LA38_0 = input.LA(1);

                            if ( (LA38_0==53) ) {
                                alt38=1;
                            }
                            switch (alt38) {
                                case 1 :
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: arrayTypeMutator
                                    {
                                    pushFollow(FOLLOW_arrayTypeMutator_in_argDef1552);
                                    arrayTypeMutator76=arrayTypeMutator();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arrayTypeMutator76.getTree());

                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       
                      			TypeRef type = (arrayTypeMutator76!=null?input.toString(arrayTypeMutator76.start,arrayTypeMutator76.stop):null) == null ?
                      				(typeRef74!=null?typeRef74.type:null) :
                      				(arrayTypeMutator76!=null?arrayTypeMutator76.mutator:null).mutateType((typeRef74!=null?typeRef74.type:null));
                      			retval.arg = new Arg((IDENTIFIER75!=null?IDENTIFIER75.getText():null), type); 
                      		
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:614:3: ( '=' expression )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==29) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:614:4: '=' expression
                            {
                            char_literal77=(Token)match(input,29,FOLLOW_29_in_argDef1563); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal77_tree = (Object)adaptor.create(char_literal77);
                            adaptor.addChild(root_0, char_literal77_tree);
                            }
                            pushFollow(FOLLOW_expression_in_argDef1565);
                            expression78=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression78.getTree());
                            if ( state.backtracking==0 ) {

                              			retval.arg.setDefaultValue((expression78!=null?expression78.expr:null));
                              		
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:618:3: '...'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal79=(Token)match(input,44,FOLLOW_44_in_argDef1579); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal79_tree = (Object)adaptor.create(string_literal79);
                    adaptor.addChild(root_0, string_literal79_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:636:1: typeMutator returns [TypeMutator mutator] : ({...}? IDENTIFIER '*' | '*' | '&' | '[' ']' );
    public final ObjCppParser.typeMutator_return typeMutator() throws RecognitionException {
        ObjCppParser.typeMutator_return retval = new ObjCppParser.typeMutator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER80=null;
        Token char_literal81=null;
        Token char_literal82=null;
        Token char_literal83=null;
        Token char_literal84=null;
        Token char_literal85=null;

        Object IDENTIFIER80_tree=null;
        Object char_literal81_tree=null;
        Object char_literal82_tree=null;
        Object char_literal83_tree=null;
        Object char_literal84_tree=null;
        Object char_literal85_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:637:2: ({...}? IDENTIFIER '*' | '*' | '&' | '[' ']' )
            int alt42=4;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt42=1;
                }
                break;
            case 51:
                {
                alt42=2;
                }
                break;
            case 52:
                {
                alt42=3;
                }
                break;
            case 53:
                {
                alt42=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:637:4: {...}? IDENTIFIER '*'
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !(( next("const", "__const") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeMutator", " next(\"const\", \"__const\") ");
                    }
                    IDENTIFIER80=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_typeMutator1599); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER80_tree = (Object)adaptor.create(IDENTIFIER80);
                    adaptor.addChild(root_0, IDENTIFIER80_tree);
                    }
                    char_literal81=(Token)match(input,51,FOLLOW_51_in_typeMutator1601); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal81_tree = (Object)adaptor.create(char_literal81);
                    adaptor.addChild(root_0, char_literal81_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.mutator = TypeMutator.CONST_STAR; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:638:3: '*'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal82=(Token)match(input,51,FOLLOW_51_in_typeMutator1609); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal82_tree = (Object)adaptor.create(char_literal82);
                    adaptor.addChild(root_0, char_literal82_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.mutator = TypeMutator.STAR; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:639:3: '&'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal83=(Token)match(input,52,FOLLOW_52_in_typeMutator1617); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal83_tree = (Object)adaptor.create(char_literal83);
                    adaptor.addChild(root_0, char_literal83_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.mutator = TypeMutator.AMPERSTAND; 
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:640:3: '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal84=(Token)match(input,53,FOLLOW_53_in_typeMutator1626); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal84_tree = (Object)adaptor.create(char_literal84);
                    adaptor.addChild(root_0, char_literal84_tree);
                    }
                    char_literal85=(Token)match(input,54,FOLLOW_54_in_typeMutator1628); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal85_tree = (Object)adaptor.create(char_literal85);
                    adaptor.addChild(root_0, char_literal85_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:643:1: arrayTypeMutator returns [TypeMutator mutator] : '[' expression ']' ;
    public final ObjCppParser.arrayTypeMutator_return arrayTypeMutator() throws RecognitionException {
        ObjCppParser.arrayTypeMutator_return retval = new ObjCppParser.arrayTypeMutator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal86=null;
        Token char_literal88=null;
        ObjCppParser.expression_return expression87 = null;


        Object char_literal86_tree=null;
        Object char_literal88_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:644:2: ( '[' expression ']' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:644:4: '[' expression ']'
            {
            root_0 = (Object)adaptor.nil();

            char_literal86=(Token)match(input,53,FOLLOW_53_in_arrayTypeMutator1646); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal86_tree = (Object)adaptor.create(char_literal86);
            adaptor.addChild(root_0, char_literal86_tree);
            }
            pushFollow(FOLLOW_expression_in_arrayTypeMutator1652);
            expression87=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression87.getTree());
            if ( state.backtracking==0 ) {

              				retval.mutator = TypeMutator.array((expression87!=null?expression87.expr:null)); 
              			
            }
            char_literal88=(Token)match(input,54,FOLLOW_54_in_arrayTypeMutator1661); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal88_tree = (Object)adaptor.create(char_literal88);
            adaptor.addChild(root_0, char_literal88_tree);
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

    public static class typeRefCore_return extends ParserRuleReturnScope {
        public TypeRef type;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeRefCore"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:651:1: typeRefCore returns [TypeRef type] : ({...}?m= modifier )? ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) ) ;
    public final ObjCppParser.typeRefCore_return typeRefCore() throws RecognitionException {
        ObjCppParser.typeRefCore_return retval = new ObjCppParser.typeRefCore_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ref=null;
        Token char_literal90=null;
        Token char_literal91=null;
        Token char_literal92=null;
        ObjCppParser.modifier_return m = null;

        ObjCppParser.modifier_return m1 = null;

        ObjCppParser.typeRef_return tr = null;

        ObjCppParser.typeRef_return t1 = null;

        ObjCppParser.typeRef_return tx = null;

        ObjCppParser.primitiveTypeRef_return primitiveTypeRef89 = null;


        Object ref_tree=null;
        Object char_literal90_tree=null;
        Object char_literal91_tree=null;
        Object char_literal92_tree=null;

         List<Modifier> mods = new ArrayList<Modifier>(); 
        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:653:2: ( ({...}?m= modifier )? ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:653:4: ({...}?m= modifier )? ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) )
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:653:4: ({...}?m= modifier )?
            int alt43=2;
            alt43 = dfa43.predict(input);
            switch (alt43) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:653:5: {...}?m= modifier
                    {
                    if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeRefCore", " next(Modifier.Kind.TypeQualifier) ");
                    }
                    pushFollow(FOLLOW_modifier_in_typeRefCore1688);
                    m=modifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, m.getTree());
                    if ( state.backtracking==0 ) {
                       mods.add((m!=null?m.modifier:null)); 
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:654:3: ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) )
            int alt48=2;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:655:4: {...}?m1= modifier tr= typeRef
                    {
                    if ( !(( next(Modifier.Kind.ReferenceQualifier) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeRefCore", " next(Modifier.Kind.ReferenceQualifier) ");
                    }
                    pushFollow(FOLLOW_modifier_in_typeRefCore1705);
                    m1=modifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, m1.getTree());
                    if ( state.backtracking==0 ) {
                       mods.add((m1!=null?m1.modifier:null)); 
                    }
                    pushFollow(FOLLOW_typeRef_in_typeRefCore1714);
                    tr=typeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tr.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (tr!=null?tr.type:null); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:658:4: ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:658:4: ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) )
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( ((LA47_0>=59 && LA47_0<=73)) ) {
                        alt47=1;
                    }
                    else if ( (LA47_0==IDENTIFIER) ) {
                        alt47=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 47, 0, input);

                        throw nvae;
                    }
                    switch (alt47) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:659:5: primitiveTypeRef
                            {
                            pushFollow(FOLLOW_primitiveTypeRef_in_typeRefCore1734);
                            primitiveTypeRef89=primitiveTypeRef();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveTypeRef89.getTree());
                            if ( state.backtracking==0 ) {
                               retval.type = (primitiveTypeRef89!=null?primitiveTypeRef89.type:null); 
                            }

                            }
                            break;
                        case 2 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:660:5: {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' )
                            {
                            if ( !(( Modifier.parseModifier(next()) == null )) ) {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                throw new FailedPredicateException(input, "typeRefCore", " Modifier.parseModifier(next()) == null ");
                            }
                            ref=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_typeRefCore1749); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ref_tree = (Object)adaptor.create(ref);
                            adaptor.addChild(root_0, ref_tree);
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:660:64: ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' )
                            int alt46=2;
                            alt46 = dfa46.predict(input);
                            switch (alt46) {
                                case 1 :
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:661:6: 
                                    {
                                    if ( state.backtracking==0 ) {
                                       retval.type = new SimpleTypeRef((ref!=null?ref.getText():null)); 
                                    }

                                    }
                                    break;
                                case 2 :
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:662:6: '<' (t1= typeRef ( ',' tx= typeRef )* )? '>'
                                    {
                                    char_literal90=(Token)match(input,36,FOLLOW_36_in_typeRefCore1767); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    char_literal90_tree = (Object)adaptor.create(char_literal90);
                                    adaptor.addChild(root_0, char_literal90_tree);
                                    }
                                    if ( state.backtracking==0 ) {
                                       retval.type = new TemplateRef((ref!=null?ref.getText():null)); 
                                    }
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:663:7: (t1= typeRef ( ',' tx= typeRef )* )?
                                    int alt45=2;
                                    int LA45_0 = input.LA(1);

                                    if ( (LA45_0==IDENTIFIER||LA45_0==30||(LA45_0>=45 && LA45_0<=47)||(LA45_0>=59 && LA45_0<=73)) ) {
                                        alt45=1;
                                    }
                                    switch (alt45) {
                                        case 1 :
                                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:664:8: t1= typeRef ( ',' tx= typeRef )*
                                            {
                                            pushFollow(FOLLOW_typeRef_in_typeRefCore1788);
                                            t1=typeRef();

                                            state._fsp--;
                                            if (state.failed) return retval;
                                            if ( state.backtracking==0 ) adaptor.addChild(root_0, t1.getTree());
                                            if ( state.backtracking==0 ) {
                                               ((TemplateRef)retval.type).addParameter((t1!=null?t1.type:null)); 
                                            }
                                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:665:8: ( ',' tx= typeRef )*
                                            loop44:
                                            do {
                                                int alt44=2;
                                                int LA44_0 = input.LA(1);

                                                if ( (LA44_0==27) ) {
                                                    alt44=1;
                                                }


                                                switch (alt44) {
                                            	case 1 :
                                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:666:9: ',' tx= typeRef
                                            	    {
                                            	    char_literal91=(Token)match(input,27,FOLLOW_27_in_typeRefCore1809); if (state.failed) return retval;
                                            	    if ( state.backtracking==0 ) {
                                            	    char_literal91_tree = (Object)adaptor.create(char_literal91);
                                            	    adaptor.addChild(root_0, char_literal91_tree);
                                            	    }
                                            	    pushFollow(FOLLOW_typeRef_in_typeRefCore1822);
                                            	    tx=typeRef();

                                            	    state._fsp--;
                                            	    if (state.failed) return retval;
                                            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, tx.getTree());
                                            	    if ( state.backtracking==0 ) {
                                            	       ((TemplateRef)retval.type).addParameter((tx!=null?tx.type:null)); 
                                            	    }

                                            	    }
                                            	    break;

                                            	default :
                                            	    break loop44;
                                                }
                                            } while (true);


                                            }
                                            break;

                                    }

                                    char_literal92=(Token)match(input,37,FOLLOW_37_in_typeRefCore1850); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    char_literal92_tree = (Object)adaptor.create(char_literal92);
                                    adaptor.addChild(root_0, char_literal92_tree);
                                    }

                                    }
                                    break;

                            }

                            if ( state.backtracking==0 ) {

                              					retval.type = mark(retval.type, getLine(ref));
                              				
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               retval.type.addModifiers(mods); 
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
    // $ANTLR end "typeRefCore"

    public static class templateDef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "templateDef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:678:1: templateDef : ( 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' structCore | functionDefinition );
    public final ObjCppParser.templateDef_return templateDef() throws RecognitionException {
        ObjCppParser.templateDef_return retval = new ObjCppParser.templateDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal93=null;
        Token char_literal94=null;
        Token char_literal96=null;
        Token char_literal98=null;
        ObjCppParser.templateArgDecl_return templateArgDecl95 = null;

        ObjCppParser.templateArgDecl_return templateArgDecl97 = null;

        ObjCppParser.structCore_return structCore99 = null;

        ObjCppParser.functionDefinition_return functionDefinition100 = null;


        Object string_literal93_tree=null;
        Object char_literal94_tree=null;
        Object char_literal96_tree=null;
        Object char_literal98_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:679:2: ( 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' structCore | functionDefinition )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==55) ) {
                alt51=1;
            }
            else if ( (LA51_0==IDENTIFIER||LA51_0==30||(LA51_0>=45 && LA51_0<=47)||(LA51_0>=59 && LA51_0<=73)) ) {
                alt51=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:679:4: 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' structCore
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal93=(Token)match(input,55,FOLLOW_55_in_templateDef1882); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal93_tree = (Object)adaptor.create(string_literal93);
                    adaptor.addChild(root_0, string_literal93_tree);
                    }
                    char_literal94=(Token)match(input,36,FOLLOW_36_in_templateDef1884); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal94_tree = (Object)adaptor.create(char_literal94);
                    adaptor.addChild(root_0, char_literal94_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:679:19: ( templateArgDecl ( ',' templateArgDecl )* )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==46||LA50_0==56||(LA50_0>=59 && LA50_0<=73)) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:679:20: templateArgDecl ( ',' templateArgDecl )*
                            {
                            pushFollow(FOLLOW_templateArgDecl_in_templateDef1887);
                            templateArgDecl95=templateArgDecl();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, templateArgDecl95.getTree());
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:679:36: ( ',' templateArgDecl )*
                            loop49:
                            do {
                                int alt49=2;
                                int LA49_0 = input.LA(1);

                                if ( (LA49_0==27) ) {
                                    alt49=1;
                                }


                                switch (alt49) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:679:37: ',' templateArgDecl
                            	    {
                            	    char_literal96=(Token)match(input,27,FOLLOW_27_in_templateDef1890); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    char_literal96_tree = (Object)adaptor.create(char_literal96);
                            	    adaptor.addChild(root_0, char_literal96_tree);
                            	    }
                            	    pushFollow(FOLLOW_templateArgDecl_in_templateDef1892);
                            	    templateArgDecl97=templateArgDecl();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, templateArgDecl97.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop49;
                                }
                            } while (true);


                            }
                            break;

                    }

                    char_literal98=(Token)match(input,37,FOLLOW_37_in_templateDef1899); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal98_tree = (Object)adaptor.create(char_literal98);
                    adaptor.addChild(root_0, char_literal98_tree);
                    }
                    pushFollow(FOLLOW_structCore_in_templateDef1903);
                    structCore99=structCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structCore99.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:680:16: functionDefinition
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_functionDefinition_in_templateDef1907);
                    functionDefinition100=functionDefinition();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionDefinition100.getTree());

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:683:1: templateArgDecl : ( primitiveTypeRef ( '=' constant ) | ( 'typename' | 'class' ) IDENTIFIER ( '=' typeRef ) );
    public final ObjCppParser.templateArgDecl_return templateArgDecl() throws RecognitionException {
        ObjCppParser.templateArgDecl_return retval = new ObjCppParser.templateArgDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal102=null;
        Token set104=null;
        Token IDENTIFIER105=null;
        Token char_literal106=null;
        ObjCppParser.primitiveTypeRef_return primitiveTypeRef101 = null;

        ObjCppParser.constant_return constant103 = null;

        ObjCppParser.typeRef_return typeRef107 = null;


        Object char_literal102_tree=null;
        Object set104_tree=null;
        Object IDENTIFIER105_tree=null;
        Object char_literal106_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:684:2: ( primitiveTypeRef ( '=' constant ) | ( 'typename' | 'class' ) IDENTIFIER ( '=' typeRef ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0>=59 && LA52_0<=73)) ) {
                alt52=1;
            }
            else if ( (LA52_0==46||LA52_0==56) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:684:4: primitiveTypeRef ( '=' constant )
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primitiveTypeRef_in_templateArgDecl1919);
                    primitiveTypeRef101=primitiveTypeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveTypeRef101.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:684:21: ( '=' constant )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:684:22: '=' constant
                    {
                    char_literal102=(Token)match(input,29,FOLLOW_29_in_templateArgDecl1922); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal102_tree = (Object)adaptor.create(char_literal102);
                    adaptor.addChild(root_0, char_literal102_tree);
                    }
                    pushFollow(FOLLOW_constant_in_templateArgDecl1924);
                    constant103=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant103.getTree());

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:685:3: ( 'typename' | 'class' ) IDENTIFIER ( '=' typeRef )
                    {
                    root_0 = (Object)adaptor.nil();

                    set104=(Token)input.LT(1);
                    if ( input.LA(1)==46||input.LA(1)==56 ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set104));
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    IDENTIFIER105=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_templateArgDecl1939); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER105_tree = (Object)adaptor.create(IDENTIFIER105);
                    adaptor.addChild(root_0, IDENTIFIER105_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:685:37: ( '=' typeRef )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:685:38: '=' typeRef
                    {
                    char_literal106=(Token)match(input,29,FOLLOW_29_in_templateArgDecl1942); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal106_tree = (Object)adaptor.create(char_literal106);
                    adaptor.addChild(root_0, char_literal106_tree);
                    }
                    pushFollow(FOLLOW_typeRef_in_templateArgDecl1944);
                    typeRef107=typeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRef107.getTree());

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
    // $ANTLR end "templateArgDecl"

    public static class functionSignatureSuffix_return extends ParserRuleReturnScope {
        public FunctionSignature signature;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionSignatureSuffix"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:688:1: functionSignatureSuffix returns [FunctionSignature signature] : tk= '(' exportationModifiers '*' ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' ;
    public final ObjCppParser.functionSignatureSuffix_return functionSignatureSuffix() throws RecognitionException {
        ObjCppParser.functionSignatureSuffix_return retval = new ObjCppParser.functionSignatureSuffix_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token tk=null;
        Token char_literal109=null;
        Token IDENTIFIER110=null;
        Token char_literal111=null;
        Token char_literal112=null;
        Token char_literal113=null;
        Token char_literal114=null;
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;

        ObjCppParser.exportationModifiers_return exportationModifiers108 = null;


        Object tk_tree=null;
        Object char_literal109_tree=null;
        Object IDENTIFIER110_tree=null;
        Object char_literal111_tree=null;
        Object char_literal112_tree=null;
        Object char_literal113_tree=null;
        Object char_literal114_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:689:2: (tk= '(' exportationModifiers '*' ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:689:4: tk= '(' exportationModifiers '*' ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')'
            {
            root_0 = (Object)adaptor.nil();

            tk=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffix1963); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tk_tree = (Object)adaptor.create(tk);
            adaptor.addChild(root_0, tk_tree);
            }
            pushFollow(FOLLOW_exportationModifiers_in_functionSignatureSuffix1965);
            exportationModifiers108=exportationModifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exportationModifiers108.getTree());
            char_literal109=(Token)match(input,51,FOLLOW_51_in_functionSignatureSuffix1967); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal109_tree = (Object)adaptor.create(char_literal109);
            adaptor.addChild(root_0, char_literal109_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:689:36: ( IDENTIFIER )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==IDENTIFIER) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: IDENTIFIER
                    {
                    IDENTIFIER110=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionSignatureSuffix1969); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER110_tree = (Object)adaptor.create(IDENTIFIER110);
                    adaptor.addChild(root_0, IDENTIFIER110_tree);
                    }

                    }
                    break;

            }

            char_literal111=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffix1972); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal111_tree = (Object)adaptor.create(char_literal111);
            adaptor.addChild(root_0, char_literal111_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, (IDENTIFIER110!=null?IDENTIFIER110.getText():null), null)), getLine(tk));
              			retval.signature.getFunction().setType(Function.Type.CFunction);
              			retval.signature.getFunction().addModifiers((exportationModifiers108!=null?exportationModifiers108.modifiers:null));
              		
            }
            char_literal112=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffix1978); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal112_tree = (Object)adaptor.create(char_literal112);
            adaptor.addChild(root_0, char_literal112_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:694:7: (a1= argDef ( ',' ax= argDef )* )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==IDENTIFIER||LA55_0==30||(LA55_0>=44 && LA55_0<=47)||(LA55_0>=59 && LA55_0<=73)) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:695:4: a1= argDef ( ',' ax= argDef )*
                    {
                    pushFollow(FOLLOW_argDef_in_functionSignatureSuffix1987);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					((FunctionSignature)retval.signature).getFunction().addArg((a1!=null?a1.arg:null)); 
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:699:4: ( ',' ax= argDef )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==27) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:700:5: ',' ax= argDef
                    	    {
                    	    char_literal113=(Token)match(input,27,FOLLOW_27_in_functionSignatureSuffix2000); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal113_tree = (Object)adaptor.create(char_literal113);
                    	    adaptor.addChild(root_0, char_literal113_tree);
                    	    }
                    	    pushFollow(FOLLOW_argDef_in_functionSignatureSuffix2009);
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
                    	    break loop54;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal114=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffix2024); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal114_tree = (Object)adaptor.create(char_literal114);
            adaptor.addChild(root_0, char_literal114_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:708:1: functionSignatureSuffixNoName returns [FunctionSignature signature] : tk= '(' exportationModifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' ;
    public final ObjCppParser.functionSignatureSuffixNoName_return functionSignatureSuffixNoName() throws RecognitionException {
        ObjCppParser.functionSignatureSuffixNoName_return retval = new ObjCppParser.functionSignatureSuffixNoName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token tk=null;
        Token char_literal116=null;
        Token char_literal117=null;
        Token char_literal118=null;
        Token char_literal119=null;
        Token char_literal120=null;
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;

        ObjCppParser.exportationModifiers_return exportationModifiers115 = null;


        Object tk_tree=null;
        Object char_literal116_tree=null;
        Object char_literal117_tree=null;
        Object char_literal118_tree=null;
        Object char_literal119_tree=null;
        Object char_literal120_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:709:2: (tk= '(' exportationModifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:709:4: tk= '(' exportationModifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')'
            {
            root_0 = (Object)adaptor.nil();

            tk=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffixNoName2041); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tk_tree = (Object)adaptor.create(tk);
            adaptor.addChild(root_0, tk_tree);
            }
            pushFollow(FOLLOW_exportationModifiers_in_functionSignatureSuffixNoName2043);
            exportationModifiers115=exportationModifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exportationModifiers115.getTree());
            char_literal116=(Token)match(input,51,FOLLOW_51_in_functionSignatureSuffixNoName2045); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal116_tree = (Object)adaptor.create(char_literal116);
            adaptor.addChild(root_0, char_literal116_tree);
            }
            char_literal117=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffixNoName2047); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal117_tree = (Object)adaptor.create(char_literal117);
            adaptor.addChild(root_0, char_literal117_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, null, null)), getLine(tk));
              			retval.signature.getFunction().setType(Function.Type.CFunction);
              			retval.signature.getFunction().addModifiers((exportationModifiers115!=null?exportationModifiers115.modifiers:null));
              		
            }
            char_literal118=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffixNoName2053); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal118_tree = (Object)adaptor.create(char_literal118);
            adaptor.addChild(root_0, char_literal118_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:714:7: (a1= argDef ( ',' ax= argDef )* )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==IDENTIFIER||LA57_0==30||(LA57_0>=44 && LA57_0<=47)||(LA57_0>=59 && LA57_0<=73)) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:715:4: a1= argDef ( ',' ax= argDef )*
                    {
                    pushFollow(FOLLOW_argDef_in_functionSignatureSuffixNoName2062);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					((FunctionSignature)retval.signature).getFunction().addArg((a1!=null?a1.arg:null)); 
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:719:4: ( ',' ax= argDef )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==27) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:720:5: ',' ax= argDef
                    	    {
                    	    char_literal119=(Token)match(input,27,FOLLOW_27_in_functionSignatureSuffixNoName2075); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal119_tree = (Object)adaptor.create(char_literal119);
                    	    adaptor.addChild(root_0, char_literal119_tree);
                    	    }
                    	    pushFollow(FOLLOW_argDef_in_functionSignatureSuffixNoName2084);
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

            char_literal120=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffixNoName2099); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal120_tree = (Object)adaptor.create(char_literal120);
            adaptor.addChild(root_0, char_literal120_tree);
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

    public static class structOrEnum_return extends ParserRuleReturnScope {
        public TypeRef type;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "structOrEnum"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:728:1: structOrEnum returns [TypeRef type] : ( structCore | enumCore );
    public final ObjCppParser.structOrEnum_return structOrEnum() throws RecognitionException {
        ObjCppParser.structOrEnum_return retval = new ObjCppParser.structOrEnum_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.structCore_return structCore121 = null;

        ObjCppParser.enumCore_return enumCore122 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:729:2: ( structCore | enumCore )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( ((LA58_0>=45 && LA58_0<=47)) ) {
                alt58=1;
            }
            else if ( (LA58_0==30) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:730:3: structCore
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_structCore_in_structOrEnum2117);
                    structCore121=structCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structCore121.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (structCore121!=null?structCore121.struct:null); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:731:3: enumCore
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_enumCore_in_structOrEnum2125);
                    enumCore122=enumCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, enumCore122.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (enumCore122!=null?enumCore122.e:null); 
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
    // $ANTLR end "structOrEnum"

    public static class typeRefCoreOrFuncSig_return extends ParserRuleReturnScope {
        public TypeRef type;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeRefCoreOrFuncSig"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:734:1: typeRefCoreOrFuncSig returns [TypeRef type] : typeRefCore ( ( typeMutator )* functionSignatureSuffix )? ;
    public final ObjCppParser.typeRefCoreOrFuncSig_return typeRefCoreOrFuncSig() throws RecognitionException {
        ObjCppParser.typeRefCoreOrFuncSig_return retval = new ObjCppParser.typeRefCoreOrFuncSig_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.typeRefCore_return typeRefCore123 = null;

        ObjCppParser.typeMutator_return typeMutator124 = null;

        ObjCppParser.functionSignatureSuffix_return functionSignatureSuffix125 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:735:2: ( typeRefCore ( ( typeMutator )* functionSignatureSuffix )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:735:4: typeRefCore ( ( typeMutator )* functionSignatureSuffix )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_typeRefCore_in_typeRefCoreOrFuncSig2143);
            typeRefCore123=typeRefCore();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRefCore123.getTree());
            if ( state.backtracking==0 ) {
               retval.type = (typeRefCore123!=null?typeRefCore123.type:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:736:3: ( ( typeMutator )* functionSignatureSuffix )?
            int alt60=2;
            alt60 = dfa60.predict(input);
            switch (alt60) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:737:4: ( typeMutator )* functionSignatureSuffix
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:737:4: ( typeMutator )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==IDENTIFIER||(LA59_0>=51 && LA59_0<=53)) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:738:5: typeMutator
                    	    {
                    	    pushFollow(FOLLOW_typeMutator_in_typeRefCoreOrFuncSig2160);
                    	    typeMutator124=typeMutator();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeMutator124.getTree());
                    	    if ( state.backtracking==0 ) {

                    	      					retval.type = (typeMutator124!=null?typeMutator124.mutator:null).mutateType(retval.type);
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop59;
                        }
                    } while (true);

                    pushFollow(FOLLOW_functionSignatureSuffix_in_typeRefCoreOrFuncSig2173);
                    functionSignatureSuffix125=functionSignatureSuffix();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionSignatureSuffix125.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				(functionSignatureSuffix125!=null?functionSignatureSuffix125.signature:null).getFunction().setValueType(retval.type); 
                      				retval.type = (functionSignatureSuffix125!=null?functionSignatureSuffix125.signature:null);
                      			
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
    // $ANTLR end "typeRefCoreOrFuncSig"

    public static class typeRefCoreOrAnonymousFuncSig_return extends ParserRuleReturnScope {
        public TypeRef type;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeRefCoreOrAnonymousFuncSig"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:749:1: typeRefCoreOrAnonymousFuncSig returns [TypeRef type] : typeRefCore ( ( typeMutator )* functionSignatureSuffixNoName )? ;
    public final ObjCppParser.typeRefCoreOrAnonymousFuncSig_return typeRefCoreOrAnonymousFuncSig() throws RecognitionException {
        ObjCppParser.typeRefCoreOrAnonymousFuncSig_return retval = new ObjCppParser.typeRefCoreOrAnonymousFuncSig_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.typeRefCore_return typeRefCore126 = null;

        ObjCppParser.typeMutator_return typeMutator127 = null;

        ObjCppParser.functionSignatureSuffixNoName_return functionSignatureSuffixNoName128 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:750:2: ( typeRefCore ( ( typeMutator )* functionSignatureSuffixNoName )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:750:4: typeRefCore ( ( typeMutator )* functionSignatureSuffixNoName )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_typeRefCore_in_typeRefCoreOrAnonymousFuncSig2197);
            typeRefCore126=typeRefCore();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRefCore126.getTree());
            if ( state.backtracking==0 ) {
               retval.type = (typeRefCore126!=null?typeRefCore126.type:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:751:3: ( ( typeMutator )* functionSignatureSuffixNoName )?
            int alt62=2;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:752:4: ( typeMutator )* functionSignatureSuffixNoName
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:752:4: ( typeMutator )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==IDENTIFIER||(LA61_0>=51 && LA61_0<=53)) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:753:5: typeMutator
                    	    {
                    	    pushFollow(FOLLOW_typeMutator_in_typeRefCoreOrAnonymousFuncSig2214);
                    	    typeMutator127=typeMutator();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeMutator127.getTree());
                    	    if ( state.backtracking==0 ) {

                    	      					retval.type = (typeMutator127!=null?typeMutator127.mutator:null).mutateType(retval.type);
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop61;
                        }
                    } while (true);

                    pushFollow(FOLLOW_functionSignatureSuffixNoName_in_typeRefCoreOrAnonymousFuncSig2227);
                    functionSignatureSuffixNoName128=functionSignatureSuffixNoName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionSignatureSuffixNoName128.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				(functionSignatureSuffixNoName128!=null?functionSignatureSuffixNoName128.signature:null).getFunction().setValueType(retval.type); 
                      				retval.type = (functionSignatureSuffixNoName128!=null?functionSignatureSuffixNoName128.signature:null);
                      			
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
    // $ANTLR end "typeRefCoreOrAnonymousFuncSig"

    public static class plainTypeRef_return extends ParserRuleReturnScope {
        public TypeRef type;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "plainTypeRef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:764:1: plainTypeRef returns [TypeRef type] : ( structOrEnum | typeRefCoreOrFuncSig );
    public final ObjCppParser.plainTypeRef_return plainTypeRef() throws RecognitionException {
        ObjCppParser.plainTypeRef_return retval = new ObjCppParser.plainTypeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.structOrEnum_return structOrEnum129 = null;

        ObjCppParser.typeRefCoreOrFuncSig_return typeRefCoreOrFuncSig130 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:765:2: ( structOrEnum | typeRefCoreOrFuncSig )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==30||(LA63_0>=45 && LA63_0<=47)) ) {
                alt63=1;
            }
            else if ( (LA63_0==IDENTIFIER||(LA63_0>=59 && LA63_0<=73)) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:766:3: structOrEnum
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_structOrEnum_in_plainTypeRef2254);
                    structOrEnum129=structOrEnum();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structOrEnum129.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (structOrEnum129!=null?structOrEnum129.type:null); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:3: typeRefCoreOrFuncSig
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_typeRefCoreOrFuncSig_in_plainTypeRef2262);
                    typeRefCoreOrFuncSig130=typeRefCoreOrFuncSig();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRefCoreOrFuncSig130.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (typeRefCoreOrFuncSig130!=null?typeRefCoreOrFuncSig130.type:null); 
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
    // $ANTLR end "plainTypeRef"

    public static class declarator_return extends ParserRuleReturnScope {
        public Declarator declarator;
        public List<Modifier> modifiers;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declarator"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:770:1: declarator returns [Declarator declarator, List<Modifier> modifiers] : ({...}? modifier )* ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? ) ;
    public final ObjCppParser.declarator_return declarator() throws RecognitionException {
        ObjCppParser.declarator_return retval = new ObjCppParser.declarator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token pt=null;
        Token char_literal133=null;
        ObjCppParser.declarator_return inner = null;

        ObjCppParser.modifier_return modifier131 = null;

        ObjCppParser.directDeclarator_return directDeclarator132 = null;

        ObjCppParser.expression_return expression134 = null;


        Object pt_tree=null;
        Object char_literal133_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:771:2: ( ({...}? modifier )* ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:771:4: ({...}? modifier )* ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:772:3: ({...}? modifier )*
            loop64:
            do {
                int alt64=2;
                alt64 = dfa64.predict(input);
                switch (alt64) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:773:4: {...}? modifier
            	    {
            	    if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "declarator", " next(Modifier.Kind.TypeQualifier) ");
            	    }
            	    pushFollow(FOLLOW_modifier_in_declarator2291);
            	    modifier131=modifier();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, modifier131.getTree());
            	    if ( state.backtracking==0 ) {

            	      				retval.modifiers.add((modifier131!=null?modifier131.modifier:null));
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:780:3: ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:781:4: ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )?
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:781:4: ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( ((LA65_0>=51 && LA65_0<=52)||LA65_0==57) ) {
                alt65=1;
            }
            else if ( (LA65_0==IDENTIFIER||LA65_0==34) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:782:5: (pt= ( '*' | '&' | '^' ) inner= declarator )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:782:5: (pt= ( '*' | '&' | '^' ) inner= declarator )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:783:6: pt= ( '*' | '&' | '^' ) inner= declarator
                    {
                    pt=(Token)input.LT(1);
                    if ( (input.LA(1)>=51 && input.LA(1)<=52)||input.LA(1)==57 ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(pt));
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_declarator_in_declarator2347);
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
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:788:5: directDeclarator
                    {
                    pushFollow(FOLLOW_directDeclarator_in_declarator2363);
                    directDeclarator132=directDeclarator();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, directDeclarator132.getTree());
                    if ( state.backtracking==0 ) {
                       
                      					retval.declarator = (directDeclarator132!=null?directDeclarator132.declarator:null); 
                      				
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:792:4: ( '=' expression )?
            int alt66=2;
            alt66 = dfa66.predict(input);
            switch (alt66) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:793:5: '=' expression
                    {
                    char_literal133=(Token)match(input,29,FOLLOW_29_in_declarator2382); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal133_tree = (Object)adaptor.create(char_literal133);
                    adaptor.addChild(root_0, char_literal133_tree);
                    }
                    pushFollow(FOLLOW_expression_in_declarator2389);
                    expression134=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression134.getTree());
                    if ( state.backtracking==0 ) {

                      					retval.declarator.setDefaultValue((expression134!=null?expression134.expr:null));
                      				
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              			retval.declarator.setModifiers(retval.modifiers);
              		
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

    public static class namedTypeRef_return extends ParserRuleReturnScope {
        public TaggedTypeRef type;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "namedTypeRef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:805:1: namedTypeRef returns [TaggedTypeRef type] : ( structCore {...}? | enumCore {...}?);
    public final ObjCppParser.namedTypeRef_return namedTypeRef() throws RecognitionException {
        ObjCppParser.namedTypeRef_return retval = new ObjCppParser.namedTypeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.structCore_return structCore135 = null;

        ObjCppParser.enumCore_return enumCore136 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:806:2: ( structCore {...}? | enumCore {...}?)
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( ((LA67_0>=45 && LA67_0<=47)) ) {
                alt67=1;
            }
            else if ( (LA67_0==30) ) {
                alt67=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:807:3: structCore {...}?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_structCore_in_namedTypeRef2423);
                    structCore135=structCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structCore135.getTree());
                    if ( !(( (structCore135!=null?structCore135.struct:null).getTag() != null )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "namedTypeRef", " $structCore.struct.getTag() != null ");
                    }
                    if ( state.backtracking==0 ) {

                      			retval.type = (structCore135!=null?structCore135.struct:null);
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:810:3: enumCore {...}?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_enumCore_in_namedTypeRef2433);
                    enumCore136=enumCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, enumCore136.getTree());
                    if ( !(( (enumCore136!=null?enumCore136.e:null).getTag() != null )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "namedTypeRef", " $enumCore.e.getTag() != null ");
                    }
                    if ( state.backtracking==0 ) {

                      			retval.type = (enumCore136!=null?enumCore136.e:null);
                      		
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
    // $ANTLR end "namedTypeRef"

    public static class typeDef_return extends ParserRuleReturnScope {
        public TypeDef typeDef;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeDef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:815:1: typeDef returns [TypeDef typeDef] : 'typedef' varDecl {...}?;
    public final ObjCppParser.typeDef_return typeDef() throws RecognitionException {
        ObjCppParser.typeDef_return retval = new ObjCppParser.typeDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal137=null;
        ObjCppParser.varDecl_return varDecl138 = null;


        Object string_literal137_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:816:2: ( 'typedef' varDecl {...}?)
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:816:4: 'typedef' varDecl {...}?
            {
            root_0 = (Object)adaptor.nil();

            string_literal137=(Token)match(input,58,FOLLOW_58_in_typeDef2452); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal137_tree = (Object)adaptor.create(string_literal137);
            adaptor.addChild(root_0, string_literal137_tree);
            }
            pushFollow(FOLLOW_varDecl_in_typeDef2458);
            varDecl138=varDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl138.getTree());
            if ( !(( 
            			((varDecl138!=null?varDecl138.decl:null) instanceof VariablesDeclaration) 
            		)) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "typeDef", " \n\t\t\t($varDecl.decl instanceof VariablesDeclaration) \n\t\t");
            }
            if ( state.backtracking==0 ) {

              			VariablesDeclaration vd = (VariablesDeclaration)(varDecl138!=null?varDecl138.decl:null);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:825:1: varDeclEOF returns [Declaration decl] : varDecl EOF ;
    public final ObjCppParser.varDeclEOF_return varDeclEOF() throws RecognitionException {
        ObjCppParser.varDeclEOF_return retval = new ObjCppParser.varDeclEOF_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF140=null;
        ObjCppParser.varDecl_return varDecl139 = null;


        Object EOF140_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:826:2: ( varDecl EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:826:4: varDecl EOF
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_varDecl_in_varDeclEOF2478);
            varDecl139=varDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl139.getTree());
            EOF140=(Token)match(input,EOF,FOLLOW_EOF_in_varDeclEOF2480); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EOF140_tree = (Object)adaptor.create(EOF140);
            adaptor.addChild(root_0, EOF140_tree);
            }
            if ( state.backtracking==0 ) {
               retval.decl = (varDecl139!=null?varDecl139.decl:null); 
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

    public static class varDecl_return extends ParserRuleReturnScope {
        public Declaration decl;
        public TypeRef type;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "varDecl"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:829:1: varDecl returns [Declaration decl, TypeRef type] : ({...}?sm= modifier | {...}?tm= modifier )* ( ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList ) ) ';' ;
    public final ObjCppParser.varDecl_return varDecl() throws RecognitionException {
        ObjCppParser.varDecl_return retval = new ObjCppParser.varDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal142=null;
        ObjCppParser.modifier_return sm = null;

        ObjCppParser.modifier_return tm = null;

        ObjCppParser.declaratorsList_return d1 = null;

        ObjCppParser.typeRefCoreOrAnonymousFuncSig_return tcfs = null;

        ObjCppParser.declaratorsList_return d2 = null;

        ObjCppParser.structOrEnum_return structOrEnum141 = null;


        Object char_literal142_tree=null;


        	List<Modifier> stoMods = new ArrayList<Modifier>(), typMods = new ArrayList<Modifier>();

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:833:2: ( ({...}?sm= modifier | {...}?tm= modifier )* ( ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList ) ) ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:833:4: ({...}?sm= modifier | {...}?tm= modifier )* ( ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList ) ) ';'
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:833:4: ({...}?sm= modifier | {...}?tm= modifier )*
            loop68:
            do {
                int alt68=3;
                alt68 = dfa68.predict(input);
                switch (alt68) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:834:4: {...}?sm= modifier
            	    {
            	    if ( !(( next(Modifier.Kind.StorageClassSpecifier) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "varDecl", " next(Modifier.Kind.StorageClassSpecifier) ");
            	    }
            	    pushFollow(FOLLOW_modifier_in_varDecl2517);
            	    sm=modifier();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, sm.getTree());
            	    if ( state.backtracking==0 ) {
            	       stoMods.add((sm!=null?sm.modifier:null)); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:836:4: {...}?tm= modifier
            	    {
            	    if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "varDecl", " next(Modifier.Kind.TypeQualifier) ");
            	    }
            	    pushFollow(FOLLOW_modifier_in_varDecl2534);
            	    tm=modifier();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, tm.getTree());
            	    if ( state.backtracking==0 ) {
            	       typMods.add((tm!=null?tm.modifier:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop68;
                }
            } while (true);

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:839:3: ( ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:843:4: ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList )
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:843:4: ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==30||(LA70_0>=45 && LA70_0<=47)) ) {
                alt70=1;
            }
            else if ( (LA70_0==IDENTIFIER||(LA70_0>=59 && LA70_0<=73)) ) {
                alt70=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:844:5: structOrEnum ( (d1= declaratorsList )? )
                    {
                    pushFollow(FOLLOW_structOrEnum_in_varDecl2561);
                    structOrEnum141=structOrEnum();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structOrEnum141.getTree());
                    if ( state.backtracking==0 ) {
                       
                      					retval.type = (structOrEnum141!=null?structOrEnum141.type:null);
                      					//retval.decl = new VariablesDeclaration(retval.type);
                      				
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:848:5: ( (d1= declaratorsList )? )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:849:6: (d1= declaratorsList )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:849:8: (d1= declaratorsList )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==IDENTIFIER||LA69_0==34||(LA69_0>=51 && LA69_0<=52)||LA69_0==57) ) {
                        alt69=1;
                    }
                    switch (alt69) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: d1= declaratorsList
                            {
                            pushFollow(FOLLOW_declaratorsList_in_varDecl2578);
                            d1=declaratorsList();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, d1.getTree());

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      						if ((d1!=null?d1.declarators:null) != null)
                      							retval.decl = new VariablesDeclaration(retval.type, (d1!=null?d1.declarators:null));
                      						else
                      							retval.decl = new VariablesDeclaration(retval.type); //new TaggedTypeRefDeclaration((TaggedTypeRef)retval.type);
                      					
                    }

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:856:5: tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList
                    {
                    pushFollow(FOLLOW_typeRefCoreOrAnonymousFuncSig_in_varDecl2598);
                    tcfs=typeRefCoreOrAnonymousFuncSig();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tcfs.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (tcfs!=null?tcfs.type:null); 
                    }
                    pushFollow(FOLLOW_declaratorsList_in_varDecl2608);
                    d2=declaratorsList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, d2.getTree());
                    if ( state.backtracking==0 ) {

                      					retval.decl = new VariablesDeclaration(retval.type, (d2!=null?d2.declarators:null));
                      				
                    }

                    }
                    break;

            }


            }

            char_literal142=(Token)match(input,28,FOLLOW_28_in_varDecl2645); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal142_tree = (Object)adaptor.create(char_literal142);
            adaptor.addChild(root_0, char_literal142_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.decl.addModifiers(stoMods);
              			retval.type.addModifiers(typMods); 
              		
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:884:1: objCProtocolRefList : '<' IDENTIFIER ( ',' IDENTIFIER )* '>' ;
    public final ObjCppParser.objCProtocolRefList_return objCProtocolRefList() throws RecognitionException {
        ObjCppParser.objCProtocolRefList_return retval = new ObjCppParser.objCProtocolRefList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal143=null;
        Token IDENTIFIER144=null;
        Token char_literal145=null;
        Token IDENTIFIER146=null;
        Token char_literal147=null;

        Object char_literal143_tree=null;
        Object IDENTIFIER144_tree=null;
        Object char_literal145_tree=null;
        Object IDENTIFIER146_tree=null;
        Object char_literal147_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:885:2: ( '<' IDENTIFIER ( ',' IDENTIFIER )* '>' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:885:4: '<' IDENTIFIER ( ',' IDENTIFIER )* '>'
            {
            root_0 = (Object)adaptor.nil();

            char_literal143=(Token)match(input,36,FOLLOW_36_in_objCProtocolRefList2659); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal143_tree = (Object)adaptor.create(char_literal143);
            adaptor.addChild(root_0, char_literal143_tree);
            }
            IDENTIFIER144=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCProtocolRefList2664); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER144_tree = (Object)adaptor.create(IDENTIFIER144);
            adaptor.addChild(root_0, IDENTIFIER144_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:887:3: ( ',' IDENTIFIER )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==27) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:888:4: ',' IDENTIFIER
            	    {
            	    char_literal145=(Token)match(input,27,FOLLOW_27_in_objCProtocolRefList2674); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal145_tree = (Object)adaptor.create(char_literal145);
            	    adaptor.addChild(root_0, char_literal145_tree);
            	    }
            	    IDENTIFIER146=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCProtocolRefList2680); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDENTIFIER146_tree = (Object)adaptor.create(IDENTIFIER146);
            	    adaptor.addChild(root_0, IDENTIFIER146_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);

            char_literal147=(Token)match(input,37,FOLLOW_37_in_objCProtocolRefList2690); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal147_tree = (Object)adaptor.create(char_literal147);
            adaptor.addChild(root_0, char_literal147_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:901:1: declaratorsList returns [List<Declarator> declarators] : (d= declarator ( ',' x= declarator )* ) ;
    public final ObjCppParser.declaratorsList_return declaratorsList() throws RecognitionException {
        ObjCppParser.declaratorsList_return retval = new ObjCppParser.declaratorsList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal148=null;
        ObjCppParser.declarator_return d = null;

        ObjCppParser.declarator_return x = null;


        Object char_literal148_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:902:2: ( (d= declarator ( ',' x= declarator )* ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:902:4: (d= declarator ( ',' x= declarator )* )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.declarators = new ArrayList<Declarator>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:903:3: (d= declarator ( ',' x= declarator )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:904:4: d= declarator ( ',' x= declarator )*
            {
            pushFollow(FOLLOW_declarator_in_declaratorsList2717);
            d=declarator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());
            if ( state.backtracking==0 ) {
               retval.declarators.add((d!=null?d.declarator:null)); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:905:4: ( ',' x= declarator )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==27) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:906:5: ',' x= declarator
            	    {
            	    char_literal148=(Token)match(input,27,FOLLOW_27_in_declaratorsList2730); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal148_tree = (Object)adaptor.create(char_literal148);
            	    adaptor.addChild(root_0, char_literal148_tree);
            	    }
            	    pushFollow(FOLLOW_declarator_in_declaratorsList2739);
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
            	    break loop72;
                }
            } while (true);


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
    // $ANTLR end "declaratorsList"

    public static class directDeclarator_return extends ParserRuleReturnScope {
        public Declarator declarator;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "directDeclarator"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:912:1: directDeclarator returns [Declarator declarator] : ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' ) ( '[' ( expression | ) ']' | '(' argList ')' )* ;
    public final ObjCppParser.directDeclarator_return directDeclarator() throws RecognitionException {
        ObjCppParser.directDeclarator_return retval = new ObjCppParser.directDeclarator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER149=null;
        Token char_literal150=null;
        Token char_literal151=null;
        Token char_literal152=null;
        Token char_literal154=null;
        Token char_literal155=null;
        Token char_literal157=null;
        ObjCppParser.modifier_return im = null;

        ObjCppParser.declarator_return inner = null;

        ObjCppParser.expression_return expression153 = null;

        ObjCppParser.argList_return argList156 = null;


        Object IDENTIFIER149_tree=null;
        Object char_literal150_tree=null;
        Object char_literal151_tree=null;
        Object char_literal152_tree=null;
        Object char_literal154_tree=null;
        Object char_literal155_tree=null;
        Object char_literal157_tree=null;


        	List<Modifier> modifiers = new ArrayList<Modifier>();

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:916:2: ( ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' ) ( '[' ( expression | ) ']' | '(' argList ')' )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:916:4: ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' ) ( '[' ( expression | ) ']' | '(' argList ')' )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:916:4: ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==IDENTIFIER) ) {
                alt74=1;
            }
            else if ( (LA74_0==34) ) {
                alt74=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:918:4: IDENTIFIER
                    {
                    IDENTIFIER149=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_directDeclarator2782); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER149_tree = (Object)adaptor.create(IDENTIFIER149);
                    adaptor.addChild(root_0, IDENTIFIER149_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				retval.declarator = new DirectDeclarator((IDENTIFIER149!=null?IDENTIFIER149.getText():null));
                      			
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:921:4: '(' (im= modifier )* inner= declarator ')'
                    {
                    char_literal150=(Token)match(input,34,FOLLOW_34_in_directDeclarator2792); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal150_tree = (Object)adaptor.create(char_literal150);
                    adaptor.addChild(root_0, char_literal150_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:922:4: (im= modifier )*
                    loop73:
                    do {
                        int alt73=2;
                        alt73 = dfa73.predict(input);
                        switch (alt73) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:922:5: im= modifier
                    	    {
                    	    pushFollow(FOLLOW_modifier_in_directDeclarator2801);
                    	    im=modifier();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, im.getTree());
                    	    if ( state.backtracking==0 ) {
                    	       modifiers.add((im!=null?im.modifier:null)); 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop73;
                        }
                    } while (true);

                    pushFollow(FOLLOW_declarator_in_directDeclarator2812);
                    inner=declarator();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inner.getTree());
                    char_literal151=(Token)match(input,35,FOLLOW_35_in_directDeclarator2818); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal151_tree = (Object)adaptor.create(char_literal151);
                    adaptor.addChild(root_0, char_literal151_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				retval.declarator = (inner!=null?inner.declarator:null);
                      				retval.declarator.setParenthesized(true);
                      				retval.declarator.addModifiers(modifiers);
                      			
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:930:3: ( '[' ( expression | ) ']' | '(' argList ')' )*
            loop76:
            do {
                int alt76=3;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==53) ) {
                    alt76=1;
                }
                else if ( (LA76_0==34) ) {
                    alt76=2;
                }


                switch (alt76) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:931:4: '[' ( expression | ) ']'
            	    {
            	    char_literal152=(Token)match(input,53,FOLLOW_53_in_directDeclarator2833); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal152_tree = (Object)adaptor.create(char_literal152);
            	    adaptor.addChild(root_0, char_literal152_tree);
            	    }
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:932:4: ( expression | )
            	    int alt75=2;
            	    alt75 = dfa75.predict(input);
            	    switch (alt75) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:933:5: expression
            	            {
            	            pushFollow(FOLLOW_expression_in_directDeclarator2845);
            	            expression153=expression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression153.getTree());
            	            if ( state.backtracking==0 ) {

            	              					if (retval.declarator instanceof ArrayDeclarator)
            	              						((ArrayDeclarator)retval.declarator).addDimension((expression153!=null?expression153.expr:null));
            	              					else
            	              						retval.declarator = new ArrayDeclarator(retval.declarator, (expression153!=null?expression153.expr:null));
            	              				
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:938:9: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              					retval.declarator = new ArrayDeclarator(retval.declarator, new Expression.EmptyArraySize());
            	              				
            	            }

            	            }
            	            break;

            	    }

            	    char_literal154=(Token)match(input,54,FOLLOW_54_in_directDeclarator2861); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal154_tree = (Object)adaptor.create(char_literal154);
            	    adaptor.addChild(root_0, char_literal154_tree);
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:943:4: '(' argList ')'
            	    {
            	    char_literal155=(Token)match(input,34,FOLLOW_34_in_directDeclarator2869); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal155_tree = (Object)adaptor.create(char_literal155);
            	    adaptor.addChild(root_0, char_literal155_tree);
            	    }
            	    pushFollow(FOLLOW_argList_in_directDeclarator2871);
            	    argList156=argList();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, argList156.getTree());
            	    char_literal157=(Token)match(input,35,FOLLOW_35_in_directDeclarator2873); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal157_tree = (Object)adaptor.create(char_literal157);
            	    adaptor.addChild(root_0, char_literal157_tree);
            	    }
            	    if ( state.backtracking==0 ) {

            	      				retval.declarator = new FunctionDeclarator(retval.declarator, (argList156!=null?argList156.args:null));
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop76;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:949:1: argList returns [List<Arg> args, boolean isObjC] : (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? ;
    public final ObjCppParser.argList_return argList() throws RecognitionException {
        ObjCppParser.argList_return retval = new ObjCppParser.argList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal158=null;
        Token char_literal159=null;
        Token string_literal160=null;
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        Object char_literal158_tree=null;
        Object char_literal159_tree=null;
        Object string_literal160_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:950:2: ( (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:950:4: (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )?
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               
              			retval.isObjC = false; 
              			retval.args = new ArrayList<Arg>();
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:954:3: (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==IDENTIFIER||LA79_0==30||(LA79_0>=44 && LA79_0<=47)||(LA79_0>=59 && LA79_0<=73)) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:955:4: a1= argDef ( ',' ax= argDef )* ( ',' '...' )?
                    {
                    pushFollow(FOLLOW_argDef_in_argList2906);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {

                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					retval.args.add((a1!=null?a1.arg:null));
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:959:4: ( ',' ax= argDef )*
                    loop77:
                    do {
                        int alt77=2;
                        alt77 = dfa77.predict(input);
                        switch (alt77) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:960:5: ',' ax= argDef
                    	    {
                    	    char_literal158=(Token)match(input,27,FOLLOW_27_in_argList2919); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal158_tree = (Object)adaptor.create(char_literal158);
                    	    adaptor.addChild(root_0, char_literal158_tree);
                    	    }
                    	    pushFollow(FOLLOW_argDef_in_argList2928);
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
                    	    break loop77;
                        }
                    } while (true);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:965:4: ( ',' '...' )?
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==27) ) {
                        alt78=1;
                    }
                    switch (alt78) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:966:5: ',' '...'
                            {
                            char_literal159=(Token)match(input,27,FOLLOW_27_in_argList2948); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal159_tree = (Object)adaptor.create(char_literal159);
                            adaptor.addChild(root_0, char_literal159_tree);
                            }
                            string_literal160=(Token)match(input,44,FOLLOW_44_in_argList2950); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal160_tree = (Object)adaptor.create(string_literal160);
                            adaptor.addChild(root_0, string_literal160_tree);
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

    public static class typeRef_return extends ParserRuleReturnScope {
        public TypeRef type;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeRef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:975:1: typeRef returns [TypeRef type] : plainTypeRef ( typeMutator )* ;
    public final ObjCppParser.typeRef_return typeRef() throws RecognitionException {
        ObjCppParser.typeRef_return retval = new ObjCppParser.typeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.plainTypeRef_return plainTypeRef161 = null;

        ObjCppParser.typeMutator_return typeMutator162 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:976:2: ( plainTypeRef ( typeMutator )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:977:3: plainTypeRef ( typeMutator )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_plainTypeRef_in_typeRef2984);
            plainTypeRef161=plainTypeRef();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, plainTypeRef161.getTree());
            if ( state.backtracking==0 ) {

              			retval.type = (plainTypeRef161!=null?plainTypeRef161.type:null);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:980:3: ( typeMutator )*
            loop80:
            do {
                int alt80=2;
                alt80 = dfa80.predict(input);
                switch (alt80) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:981:4: typeMutator
            	    {
            	    pushFollow(FOLLOW_typeMutator_in_typeRef2995);
            	    typeMutator162=typeMutator();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeMutator162.getTree());
            	    if ( state.backtracking==0 ) {

            	      				retval.type = (typeMutator162!=null?typeMutator162.mutator:null).mutateType(retval.type);
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop80;
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
    // $ANTLR end "typeRef"

    public static class primSignModifier_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primSignModifier"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:987:1: primSignModifier : ( 'signed' | 'unsigned' | '__signed' | '__unsigned' );
    public final ObjCppParser.primSignModifier_return primSignModifier() throws RecognitionException {
        ObjCppParser.primSignModifier_return retval = new ObjCppParser.primSignModifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set163=null;

        Object set163_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:988:2: ( 'signed' | 'unsigned' | '__signed' | '__unsigned' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:
            {
            root_0 = (Object)adaptor.nil();

            set163=(Token)input.LT(1);
            if ( (input.LA(1)>=59 && input.LA(1)<=62) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set163));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "primSignModifier"

    public static class primSizeModifier_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primSizeModifier"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:990:1: primSizeModifier : ( 'long' | 'short' );
    public final ObjCppParser.primSizeModifier_return primSizeModifier() throws RecognitionException {
        ObjCppParser.primSizeModifier_return retval = new ObjCppParser.primSizeModifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set164=null;

        Object set164_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:991:2: ( 'long' | 'short' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:
            {
            root_0 = (Object)adaptor.nil();

            set164=(Token)input.LT(1);
            if ( (input.LA(1)>=63 && input.LA(1)<=64) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set164));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "primSizeModifier"

    public static class primitiveTypeName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primitiveTypeName"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:993:1: primitiveTypeName : ( 'long' | 'int' | 'short' | 'double' | 'float' | 'char' | 'void' | '__int8' | '__int16' | '__int32' | '__int64' );
    public final ObjCppParser.primitiveTypeName_return primitiveTypeName() throws RecognitionException {
        ObjCppParser.primitiveTypeName_return retval = new ObjCppParser.primitiveTypeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set165=null;

        Object set165_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:994:2: ( 'long' | 'int' | 'short' | 'double' | 'float' | 'char' | 'void' | '__int8' | '__int16' | '__int32' | '__int64' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:
            {
            root_0 = (Object)adaptor.nil();

            set165=(Token)input.LT(1);
            if ( (input.LA(1)>=63 && input.LA(1)<=73) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set165));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "primitiveTypeName"

    public static class primitiveTypeRef_return extends ParserRuleReturnScope {
        public TypeRef type;
        public int line;
        public List<Modifier> modifiers;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primitiveTypeRef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1006:1: primitiveTypeRef returns [TypeRef type, int line, List<Modifier> modifiers] : ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) ) ;
    public final ObjCppParser.primitiveTypeRef_return primitiveTypeRef() throws RecognitionException {
        ObjCppParser.primitiveTypeRef_return retval = new ObjCppParser.primitiveTypeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.primSignModifier_return mod1 = null;

        ObjCppParser.primSizeModifier_return mod2 = null;

        ObjCppParser.primSizeModifier_return mod3 = null;

        ObjCppParser.primitiveTypeName_return name = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1007:2: ( ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1007:4: ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               
              			retval.line = getLine(); 
              			retval.modifiers = new ArrayList<Modifier>();
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1011:3: ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1012:4: (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName )
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1012:8: (mod1= primSignModifier )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( ((LA81_0>=59 && LA81_0<=62)) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: mod1= primSignModifier
                    {
                    pushFollow(FOLLOW_primSignModifier_in_primitiveTypeRef3134);
                    mod1=primSignModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mod1.getTree());

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1013:4: (mod2= primSizeModifier (mod3= primSizeModifier )? )?
            int alt83=2;
            alt83 = dfa83.predict(input);
            switch (alt83) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1013:5: mod2= primSizeModifier (mod3= primSizeModifier )?
                    {
                    pushFollow(FOLLOW_primSizeModifier_in_primitiveTypeRef3145);
                    mod2=primSizeModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mod2.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1014:8: (mod3= primSizeModifier )?
                    int alt82=2;
                    alt82 = dfa82.predict(input);
                    switch (alt82) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: mod3= primSizeModifier
                            {
                            pushFollow(FOLLOW_primSizeModifier_in_primitiveTypeRef3152);
                            mod3=primSizeModifier();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, mod3.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1022:4: (name= primitiveTypeName )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1025:5: name= primitiveTypeName
            {
            pushFollow(FOLLOW_primitiveTypeName_in_primitiveTypeRef3195);
            name=primitiveTypeName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, name.getTree());
            if ( state.backtracking==0 ) {

              					retval.type = mark(new Primitive((name!=null?input.toString(name.start,name.stop):null)), retval.line);
              					//retval.type.addModifiers(retval.modifiers);
              					retval.type.addModifiers(Modifier.parseModifier((mod1!=null?input.toString(mod1.start,mod1.stop):null)));
              					retval.type.addModifiers(Modifier.parseModifier((mod2!=null?input.toString(mod2.start,mod2.stop):null)));
              					retval.type.addModifiers(Modifier.parseModifier((mod3!=null?input.toString(mod3.start,mod3.stop):null)));

              				
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
        }
        return retval;
    }
    // $ANTLR end "primitiveTypeRef"

    public static class objCMethodCall_return extends ParserRuleReturnScope {
        public FunctionCall expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "objCMethodCall"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1054:1: objCMethodCall returns [FunctionCall expr] : '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']' ;
    public final ObjCppParser.objCMethodCall_return objCMethodCall() throws RecognitionException {
        ObjCppParser.objCMethodCall_return retval = new ObjCppParser.objCMethodCall_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token methodName=null;
        Token selx=null;
        Token char_literal166=null;
        Token char_literal167=null;
        Token char_literal168=null;
        Token char_literal169=null;
        ObjCppParser.expression_return target = null;

        ObjCppParser.expression_return arg1 = null;

        ObjCppParser.expression_return argx = null;


        Object methodName_tree=null;
        Object selx_tree=null;
        Object char_literal166_tree=null;
        Object char_literal167_tree=null;
        Object char_literal168_tree=null;
        Object char_literal169_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1055:2: ( '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1056:3: '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']'
            {
            root_0 = (Object)adaptor.nil();

            char_literal166=(Token)match(input,53,FOLLOW_53_in_objCMethodCall3234); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal166_tree = (Object)adaptor.create(char_literal166);
            adaptor.addChild(root_0, char_literal166_tree);
            }
            pushFollow(FOLLOW_expression_in_objCMethodCall3238);
            target=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, target.getTree());
            methodName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodCall3242); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            methodName_tree = (Object)adaptor.create(methodName);
            adaptor.addChild(root_0, methodName_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.expr = new FunctionCall((methodName!=null?methodName.getText():null));
              			retval.expr.setTarget((target!=null?target.expr:null));
              			retval.expr.setMemberRefStyle(MemberRefStyle.SquareBrackets);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1061:3: ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==33) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1062:4: ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )*
                    {
                    char_literal167=(Token)match(input,33,FOLLOW_33_in_objCMethodCall3253); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal167_tree = (Object)adaptor.create(char_literal167);
                    adaptor.addChild(root_0, char_literal167_tree);
                    }
                    pushFollow(FOLLOW_expression_in_objCMethodCall3257);
                    arg1=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arg1.getTree());
                    if ( state.backtracking==0 ) {

                      				retval.expr.addArgument(null, (arg1!=null?arg1.expr:null));
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1065:4: (selx= IDENTIFIER ':' argx= expression )*
                    loop84:
                    do {
                        int alt84=2;
                        int LA84_0 = input.LA(1);

                        if ( (LA84_0==IDENTIFIER) ) {
                            alt84=1;
                        }


                        switch (alt84) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1066:5: selx= IDENTIFIER ':' argx= expression
                    	    {
                    	    selx=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodCall3272); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    selx_tree = (Object)adaptor.create(selx);
                    	    adaptor.addChild(root_0, selx_tree);
                    	    }
                    	    char_literal168=(Token)match(input,33,FOLLOW_33_in_objCMethodCall3274); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal168_tree = (Object)adaptor.create(char_literal168);
                    	    adaptor.addChild(root_0, char_literal168_tree);
                    	    }
                    	    pushFollow(FOLLOW_expression_in_objCMethodCall3278);
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
                    	    break loop84;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal169=(Token)match(input,54,FOLLOW_54_in_objCMethodCall3295); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal169_tree = (Object)adaptor.create(char_literal169);
            adaptor.addChild(root_0, char_literal169_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1074:1: functionCall returns [FunctionCall expr] : ( 'sizeof' '(' typeRef ')' | IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')' );
    public final ObjCppParser.functionCall_return functionCall() throws RecognitionException {
        ObjCppParser.functionCall_return retval = new ObjCppParser.functionCall_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal170=null;
        Token char_literal171=null;
        Token char_literal173=null;
        Token IDENTIFIER174=null;
        Token char_literal175=null;
        Token char_literal176=null;
        Token char_literal177=null;
        ObjCppParser.expression_return a1 = null;

        ObjCppParser.expression_return ax = null;

        ObjCppParser.typeRef_return typeRef172 = null;


        Object string_literal170_tree=null;
        Object char_literal171_tree=null;
        Object char_literal173_tree=null;
        Object IDENTIFIER174_tree=null;
        Object char_literal175_tree=null;
        Object char_literal176_tree=null;
        Object char_literal177_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1075:2: ( 'sizeof' '(' typeRef ')' | IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')' )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==74) ) {
                alt88=1;
            }
            else if ( (LA88_0==IDENTIFIER) ) {
                alt88=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1076:3: 'sizeof' '(' typeRef ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal170=(Token)match(input,74,FOLLOW_74_in_functionCall3315); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal170_tree = (Object)adaptor.create(string_literal170);
                    adaptor.addChild(root_0, string_literal170_tree);
                    }
                    char_literal171=(Token)match(input,34,FOLLOW_34_in_functionCall3317); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal171_tree = (Object)adaptor.create(char_literal171);
                    adaptor.addChild(root_0, char_literal171_tree);
                    }
                    pushFollow(FOLLOW_typeRef_in_functionCall3319);
                    typeRef172=typeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRef172.getTree());
                    char_literal173=(Token)match(input,35,FOLLOW_35_in_functionCall3321); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal173_tree = (Object)adaptor.create(char_literal173);
                    adaptor.addChild(root_0, char_literal173_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			retval.expr = new FunctionCall("sizeof");
                      			retval.expr.addArgument(new TypeRefExpression((typeRef172!=null?typeRef172.type:null)));
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1080:3: IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    IDENTIFIER174=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionCall3329); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER174_tree = (Object)adaptor.create(IDENTIFIER174);
                    adaptor.addChild(root_0, IDENTIFIER174_tree);
                    }
                    char_literal175=(Token)match(input,34,FOLLOW_34_in_functionCall3331); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal175_tree = (Object)adaptor.create(char_literal175);
                    adaptor.addChild(root_0, char_literal175_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			retval.expr = new FunctionCall((IDENTIFIER174!=null?IDENTIFIER174.getText():null));
                      		
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1083:3: (a1= expression ( ',' ax= expression )* )?
                    int alt87=2;
                    alt87 = dfa87.predict(input);
                    switch (alt87) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1084:4: a1= expression ( ',' ax= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_functionCall3344);
                            a1=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                            if ( state.backtracking==0 ) {

                              				retval.expr.addArgument((a1!=null?a1.expr:null));
                              			
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1087:4: ( ',' ax= expression )*
                            loop86:
                            do {
                                int alt86=2;
                                int LA86_0 = input.LA(1);

                                if ( (LA86_0==27) ) {
                                    alt86=1;
                                }


                                switch (alt86) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1087:6: ',' ax= expression
                            	    {
                            	    char_literal176=(Token)match(input,27,FOLLOW_27_in_functionCall3353); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    char_literal176_tree = (Object)adaptor.create(char_literal176);
                            	    adaptor.addChild(root_0, char_literal176_tree);
                            	    }
                            	    pushFollow(FOLLOW_expression_in_functionCall3362);
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
                            	    break loop86;
                                }
                            } while (true);


                            }
                            break;

                    }

                    char_literal177=(Token)match(input,35,FOLLOW_35_in_functionCall3380); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal177_tree = (Object)adaptor.create(char_literal177);
                    adaptor.addChild(root_0, char_literal177_tree);
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
    // $ANTLR end "functionCall"

    public static class expression_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1096:1: expression returns [Expression expr] : (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' ) (bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )* ;
    public final ObjCppParser.expression_return expression() throws RecognitionException {
        ObjCppParser.expression_return retval = new ObjCppParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token id=null;
        Token prefixOp=null;
        Token bop=null;
        Token fieldName=null;
        Token refStyle=null;
        Token char_literal179=null;
        Token char_literal180=null;
        Token char_literal182=null;
        Token char_literal184=null;
        Token char_literal186=null;
        Token char_literal187=null;
        Token char_literal188=null;
        Token char_literal189=null;
        Token char_literal190=null;
        Token char_literal191=null;
        Token char_literal192=null;
        Token char_literal193=null;
        Token char_literal194=null;
        Token char_literal195=null;
        ObjCppParser.functionCall_return fc1 = null;

        ObjCppParser.expression_return opd = null;

        ObjCppParser.expression_return par = null;

        ObjCppParser.expression_return casted = null;

        ObjCppParser.expression_return opd2 = null;

        ObjCppParser.expression_return val = null;

        ObjCppParser.functionCall_return fc2 = null;

        ObjCppParser.expression_return xif = null;

        ObjCppParser.expression_return xelse = null;

        ObjCppParser.objCMethodCall_return objCMethodCall178 = null;

        ObjCppParser.typeRef_return typeRef181 = null;

        ObjCppParser.constant_return constant183 = null;

        ObjCppParser.expression_return expression185 = null;


        Object id_tree=null;
        Object prefixOp_tree=null;
        Object bop_tree=null;
        Object fieldName_tree=null;
        Object refStyle_tree=null;
        Object char_literal179_tree=null;
        Object char_literal180_tree=null;
        Object char_literal182_tree=null;
        Object char_literal184_tree=null;
        Object char_literal186_tree=null;
        Object char_literal187_tree=null;
        Object char_literal188_tree=null;
        Object char_literal189_tree=null;
        Object char_literal190_tree=null;
        Object char_literal191_tree=null;
        Object char_literal192_tree=null;
        Object char_literal193_tree=null;
        Object char_literal194_tree=null;
        Object char_literal195_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1097:2: ( (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' ) (bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1097:4: (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' ) (bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1097:4: (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' )
            int alt90=7;
            alt90 = dfa90.predict(input);
            switch (alt90) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1098:4: id= IDENTIFIER
                    {
                    id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression3402); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    id_tree = (Object)adaptor.create(id);
                    adaptor.addChild(root_0, id_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				retval.expr = new VariableRef((id!=null?id.getText():null));
                      			
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1101:4: fc1= functionCall
                    {
                    pushFollow(FOLLOW_functionCall_in_expression3413);
                    fc1=functionCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fc1.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				retval.expr = (fc1!=null?fc1.expr:null); 
                      			
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1104:4: objCMethodCall
                    {
                    pushFollow(FOLLOW_objCMethodCall_in_expression3422);
                    objCMethodCall178=objCMethodCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, objCMethodCall178.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				retval.expr = (objCMethodCall178!=null?objCMethodCall178.expr:null); 
                      							
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1107:4: prefixOp= ( '!' | '~' ) opd= expression
                    {
                    prefixOp=(Token)input.LT(1);
                    if ( (input.LA(1)>=75 && input.LA(1)<=76) ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(prefixOp));
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_expression_in_expression3443);
                    opd=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, opd.getTree());
                    if ( state.backtracking==0 ) {

                      				retval.expr = new UnaryOp(Expression.getUnaryOperator((prefixOp!=null?prefixOp.getText():null)), (opd!=null?opd.expr:null));
                      			
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1110:4: '(' (par= expression ')' | typeRef ')' casted= expression )
                    {
                    char_literal179=(Token)match(input,34,FOLLOW_34_in_expression3452); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal179_tree = (Object)adaptor.create(char_literal179);
                    adaptor.addChild(root_0, char_literal179_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1110:8: (par= expression ')' | typeRef ')' casted= expression )
                    int alt89=2;
                    alt89 = dfa89.predict(input);
                    switch (alt89) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1111:5: par= expression ')'
                            {
                            pushFollow(FOLLOW_expression_in_expression3462);
                            par=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, par.getTree());
                            char_literal180=(Token)match(input,35,FOLLOW_35_in_expression3464); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal180_tree = (Object)adaptor.create(char_literal180);
                            adaptor.addChild(root_0, char_literal180_tree);
                            }
                            if ( state.backtracking==0 ) {

                              					retval.expr = (par!=null?par.expr:null);
                              					if (retval.expr != null)
                              						retval.expr.setParenthesis(true);
                              				
                            }

                            }
                            break;
                        case 2 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1116:5: typeRef ')' casted= expression
                            {
                            pushFollow(FOLLOW_typeRef_in_expression3474);
                            typeRef181=typeRef();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRef181.getTree());
                            char_literal182=(Token)match(input,35,FOLLOW_35_in_expression3476); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal182_tree = (Object)adaptor.create(char_literal182);
                            adaptor.addChild(root_0, char_literal182_tree);
                            }
                            pushFollow(FOLLOW_expression_in_expression3480);
                            casted=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, casted.getTree());
                            if ( state.backtracking==0 ) {

                              					retval.expr = new Cast((typeRef181!=null?typeRef181.type:null), (casted!=null?casted.expr:null));
                              				
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1120:4: constant
                    {
                    pushFollow(FOLLOW_constant_in_expression3495);
                    constant183=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant183.getTree());
                    if ( state.backtracking==0 ) {
                       retval.expr = (constant183!=null?constant183.constant:null); 
                    }

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1121:4: '{' expression '}'
                    {
                    char_literal184=(Token)match(input,23,FOLLOW_23_in_expression3504); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal184_tree = (Object)adaptor.create(char_literal184);
                    adaptor.addChild(root_0, char_literal184_tree);
                    }
                    pushFollow(FOLLOW_expression_in_expression3506);
                    expression185=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression185.getTree());
                    char_literal186=(Token)match(input,24,FOLLOW_24_in_expression3508); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal186_tree = (Object)adaptor.create(char_literal186);
                    adaptor.addChild(root_0, char_literal186_tree);
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1123:3: (bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )*
            loop92:
            do {
                int alt92=6;
                alt92 = dfa92.predict(input);
                switch (alt92) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1124:4: bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression
            	    {
            	    bop=(Token)input.LT(1);
            	    if ( (input.LA(1)>=36 && input.LA(1)<=37)||(input.LA(1)>=42 && input.LA(1)<=43)||(input.LA(1)>=51 && input.LA(1)<=52)||input.LA(1)==57||(input.LA(1)>=77 && input.LA(1)<=88) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(bop));
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_expression_in_expression3618);
            	    opd2=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, opd2.getTree());
            	    if ( state.backtracking==0 ) {

            	      				retval.expr = new BinaryOp(getBinaryOperator((bop!=null?bop.getText():null)), retval.expr, (opd2!=null?opd2.expr:null));
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1131:4: '=' val= expression
            	    {
            	    char_literal187=(Token)match(input,29,FOLLOW_29_in_expression3627); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal187_tree = (Object)adaptor.create(char_literal187);
            	    adaptor.addChild(root_0, char_literal187_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression3631);
            	    val=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, val.getTree());
            	    if ( state.backtracking==0 ) {

            	      				retval.expr = new Assignment(retval.expr, (val!=null?val.expr:null));
            	      			
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1134:4: '.' fieldName= IDENTIFIER
            	    {
            	    char_literal188=(Token)match(input,89,FOLLOW_89_in_expression3640); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal188_tree = (Object)adaptor.create(char_literal188);
            	    adaptor.addChild(root_0, char_literal188_tree);
            	    }
            	    fieldName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression3644); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    fieldName_tree = (Object)adaptor.create(fieldName);
            	    adaptor.addChild(root_0, fieldName_tree);
            	    }
            	    if ( state.backtracking==0 ) {

            	      				retval.expr = new FieldRef(retval.expr, (fieldName!=null?fieldName.getText():null), MemberRefStyle.Dot);
            	      			
            	    }

            	    }
            	    break;
            	case 4 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1137:4: refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1137:13: ( ':' ':' | '-' '>' | '.' )
            	    int alt91=3;
            	    switch ( input.LA(1) ) {
            	    case 33:
            	        {
            	        alt91=1;
            	        }
            	        break;
            	    case 43:
            	        {
            	        alt91=2;
            	        }
            	        break;
            	    case 89:
            	        {
            	        alt91=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 91, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt91) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1137:14: ':' ':'
            	            {
            	            char_literal189=(Token)match(input,33,FOLLOW_33_in_expression3656); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal189_tree = (Object)adaptor.create(char_literal189);
            	            adaptor.addChild(root_0, char_literal189_tree);
            	            }
            	            char_literal190=(Token)match(input,33,FOLLOW_33_in_expression3658); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal190_tree = (Object)adaptor.create(char_literal190);
            	            adaptor.addChild(root_0, char_literal190_tree);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1137:24: '-' '>'
            	            {
            	            char_literal191=(Token)match(input,43,FOLLOW_43_in_expression3662); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal191_tree = (Object)adaptor.create(char_literal191);
            	            adaptor.addChild(root_0, char_literal191_tree);
            	            }
            	            char_literal192=(Token)match(input,37,FOLLOW_37_in_expression3664); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal192_tree = (Object)adaptor.create(char_literal192);
            	            adaptor.addChild(root_0, char_literal192_tree);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1137:34: '.'
            	            {
            	            char_literal193=(Token)match(input,89,FOLLOW_89_in_expression3668); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal193_tree = (Object)adaptor.create(char_literal193);
            	            adaptor.addChild(root_0, char_literal193_tree);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_functionCall_in_expression3673);
            	    fc2=functionCall();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, fc2.getTree());
            	    if ( state.backtracking==0 ) {

            	      				if ((fc2!=null?fc2.expr:null) != null) {
            	      					(fc2!=null?fc2.expr:null).setTarget(retval.expr);
            	      					(fc2!=null?fc2.expr:null).setMemberRefStyle(parseMemberRefStyle((refStyle!=null?refStyle.getText():null)));
            	      					retval.expr = (fc2!=null?fc2.expr:null);
            	      				}
            	      			
            	    }

            	    }
            	    break;
            	case 5 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1144:4: '?' xif= expression ':' xelse= expression
            	    {
            	    char_literal194=(Token)match(input,90,FOLLOW_90_in_expression3682); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal194_tree = (Object)adaptor.create(char_literal194);
            	    adaptor.addChild(root_0, char_literal194_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression3686);
            	    xif=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, xif.getTree());
            	    char_literal195=(Token)match(input,33,FOLLOW_33_in_expression3688); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal195_tree = (Object)adaptor.create(char_literal195);
            	    adaptor.addChild(root_0, char_literal195_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression3692);
            	    xelse=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, xelse.getTree());
            	    if ( state.backtracking==0 ) {

            	      				//TODO
            	      			
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
    // $ANTLR end "expression"

    public static class statementsBlock_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statementsBlock"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1151:1: statementsBlock : '{' ( statement )* '}' ;
    public final ObjCppParser.statementsBlock_return statementsBlock() throws RecognitionException {
        ObjCppParser.statementsBlock_return retval = new ObjCppParser.statementsBlock_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal196=null;
        Token char_literal198=null;
        ObjCppParser.statement_return statement197 = null;


        Object char_literal196_tree=null;
        Object char_literal198_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1152:2: ( '{' ( statement )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1152:4: '{' ( statement )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal196=(Token)match(input,23,FOLLOW_23_in_statementsBlock3713); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal196_tree = (Object)adaptor.create(char_literal196);
            adaptor.addChild(root_0, char_literal196_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1152:8: ( statement )*
            loop93:
            do {
                int alt93=2;
                alt93 = dfa93.predict(input);
                switch (alt93) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_statementsBlock3715);
            	    statement197=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement197.getTree());

            	    }
            	    break;

            	default :
            	    break loop93;
                }
            } while (true);

            char_literal198=(Token)match(input,24,FOLLOW_24_in_statementsBlock3718); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal198_tree = (Object)adaptor.create(char_literal198);
            adaptor.addChild(root_0, char_literal198_tree);
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
    // $ANTLR end "statementsBlock"

    public static class statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1154:1: statement : ( statementsBlock | declaration | expression ( '=' expression )? ';' | 'return' expression ';' | 'if' '(' expression ')' statement ( 'else' statement )? | 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement );
    public final ObjCppParser.statement_return statement() throws RecognitionException {
        ObjCppParser.statement_return retval = new ObjCppParser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal202=null;
        Token char_literal204=null;
        Token string_literal205=null;
        Token char_literal207=null;
        Token string_literal208=null;
        Token char_literal209=null;
        Token char_literal211=null;
        Token string_literal213=null;
        Token string_literal215=null;
        Token char_literal216=null;
        Token char_literal218=null;
        Token string_literal220=null;
        Token string_literal222=null;
        Token char_literal223=null;
        Token char_literal225=null;
        Token char_literal226=null;
        Token string_literal227=null;
        Token char_literal228=null;
        Token char_literal230=null;
        Token char_literal232=null;
        Token char_literal234=null;
        Token string_literal236=null;
        Token char_literal237=null;
        Token char_literal239=null;
        Token char_literal240=null;
        Token string_literal241=null;
        Token char_literal243=null;
        Token char_literal245=null;
        Token char_literal246=null;
        Token IDENTIFIER247=null;
        Token char_literal248=null;
        Token char_literal250=null;
        Token char_literal252=null;
        ObjCppParser.statementsBlock_return statementsBlock199 = null;

        ObjCppParser.declaration_return declaration200 = null;

        ObjCppParser.expression_return expression201 = null;

        ObjCppParser.expression_return expression203 = null;

        ObjCppParser.expression_return expression206 = null;

        ObjCppParser.expression_return expression210 = null;

        ObjCppParser.statement_return statement212 = null;

        ObjCppParser.statement_return statement214 = null;

        ObjCppParser.expression_return expression217 = null;

        ObjCppParser.statement_return statement219 = null;

        ObjCppParser.statement_return statement221 = null;

        ObjCppParser.expression_return expression224 = null;

        ObjCppParser.statement_return statement229 = null;

        ObjCppParser.expression_return expression231 = null;

        ObjCppParser.statement_return statement233 = null;

        ObjCppParser.statement_return statement235 = null;

        ObjCppParser.expression_return expression238 = null;

        ObjCppParser.expression_return expression242 = null;

        ObjCppParser.statement_return statement244 = null;

        ObjCppParser.varDecl_return varDecl249 = null;

        ObjCppParser.expression_return expression251 = null;

        ObjCppParser.statement_return statement253 = null;


        Object char_literal202_tree=null;
        Object char_literal204_tree=null;
        Object string_literal205_tree=null;
        Object char_literal207_tree=null;
        Object string_literal208_tree=null;
        Object char_literal209_tree=null;
        Object char_literal211_tree=null;
        Object string_literal213_tree=null;
        Object string_literal215_tree=null;
        Object char_literal216_tree=null;
        Object char_literal218_tree=null;
        Object string_literal220_tree=null;
        Object string_literal222_tree=null;
        Object char_literal223_tree=null;
        Object char_literal225_tree=null;
        Object char_literal226_tree=null;
        Object string_literal227_tree=null;
        Object char_literal228_tree=null;
        Object char_literal230_tree=null;
        Object char_literal232_tree=null;
        Object char_literal234_tree=null;
        Object string_literal236_tree=null;
        Object char_literal237_tree=null;
        Object char_literal239_tree=null;
        Object char_literal240_tree=null;
        Object string_literal241_tree=null;
        Object char_literal243_tree=null;
        Object char_literal245_tree=null;
        Object char_literal246_tree=null;
        Object IDENTIFIER247_tree=null;
        Object char_literal248_tree=null;
        Object char_literal250_tree=null;
        Object char_literal252_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1155:2: ( statementsBlock | declaration | expression ( '=' expression )? ';' | 'return' expression ';' | 'if' '(' expression ')' statement ( 'else' statement )? | 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement )
            int alt100=11;
            alt100 = dfa100.predict(input);
            switch (alt100) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1156:3: statementsBlock
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_statementsBlock_in_statement3731);
                    statementsBlock199=statementsBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementsBlock199.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1157:3: declaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_declaration_in_statement3737);
                    declaration200=declaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration200.getTree());

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1158:3: expression ( '=' expression )? ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_expression_in_statement3743);
                    expression201=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression201.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1158:14: ( '=' expression )?
                    int alt94=2;
                    int LA94_0 = input.LA(1);

                    if ( (LA94_0==29) ) {
                        alt94=1;
                    }
                    switch (alt94) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1158:15: '=' expression
                            {
                            char_literal202=(Token)match(input,29,FOLLOW_29_in_statement3746); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal202_tree = (Object)adaptor.create(char_literal202);
                            adaptor.addChild(root_0, char_literal202_tree);
                            }
                            pushFollow(FOLLOW_expression_in_statement3748);
                            expression203=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression203.getTree());

                            }
                            break;

                    }

                    char_literal204=(Token)match(input,28,FOLLOW_28_in_statement3753); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal204_tree = (Object)adaptor.create(char_literal204);
                    adaptor.addChild(root_0, char_literal204_tree);
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1159:3: 'return' expression ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal205=(Token)match(input,91,FOLLOW_91_in_statement3759); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal205_tree = (Object)adaptor.create(string_literal205);
                    adaptor.addChild(root_0, string_literal205_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3761);
                    expression206=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression206.getTree());
                    char_literal207=(Token)match(input,28,FOLLOW_28_in_statement3763); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal207_tree = (Object)adaptor.create(char_literal207);
                    adaptor.addChild(root_0, char_literal207_tree);
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1160:3: 'if' '(' expression ')' statement ( 'else' statement )?
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal208=(Token)match(input,92,FOLLOW_92_in_statement3769); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal208_tree = (Object)adaptor.create(string_literal208);
                    adaptor.addChild(root_0, string_literal208_tree);
                    }
                    char_literal209=(Token)match(input,34,FOLLOW_34_in_statement3771); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal209_tree = (Object)adaptor.create(char_literal209);
                    adaptor.addChild(root_0, char_literal209_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3773);
                    expression210=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression210.getTree());
                    char_literal211=(Token)match(input,35,FOLLOW_35_in_statement3775); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal211_tree = (Object)adaptor.create(char_literal211);
                    adaptor.addChild(root_0, char_literal211_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement3777);
                    statement212=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement212.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1160:37: ( 'else' statement )?
                    int alt95=2;
                    alt95 = dfa95.predict(input);
                    switch (alt95) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1160:38: 'else' statement
                            {
                            string_literal213=(Token)match(input,93,FOLLOW_93_in_statement3780); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal213_tree = (Object)adaptor.create(string_literal213);
                            adaptor.addChild(root_0, string_literal213_tree);
                            }
                            pushFollow(FOLLOW_statement_in_statement3782);
                            statement214=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement214.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1161:3: 'while' '(' expression ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal215=(Token)match(input,94,FOLLOW_94_in_statement3790); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal215_tree = (Object)adaptor.create(string_literal215);
                    adaptor.addChild(root_0, string_literal215_tree);
                    }
                    char_literal216=(Token)match(input,34,FOLLOW_34_in_statement3792); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal216_tree = (Object)adaptor.create(char_literal216);
                    adaptor.addChild(root_0, char_literal216_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3794);
                    expression217=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression217.getTree());
                    char_literal218=(Token)match(input,35,FOLLOW_35_in_statement3796); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal218_tree = (Object)adaptor.create(char_literal218);
                    adaptor.addChild(root_0, char_literal218_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement3798);
                    statement219=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement219.getTree());

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1162:3: 'do' statement 'while' '(' expression ')' ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal220=(Token)match(input,95,FOLLOW_95_in_statement3804); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal220_tree = (Object)adaptor.create(string_literal220);
                    adaptor.addChild(root_0, string_literal220_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement3806);
                    statement221=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement221.getTree());
                    string_literal222=(Token)match(input,94,FOLLOW_94_in_statement3808); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal222_tree = (Object)adaptor.create(string_literal222);
                    adaptor.addChild(root_0, string_literal222_tree);
                    }
                    char_literal223=(Token)match(input,34,FOLLOW_34_in_statement3810); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal223_tree = (Object)adaptor.create(char_literal223);
                    adaptor.addChild(root_0, char_literal223_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3812);
                    expression224=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression224.getTree());
                    char_literal225=(Token)match(input,35,FOLLOW_35_in_statement3814); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal225_tree = (Object)adaptor.create(char_literal225);
                    adaptor.addChild(root_0, char_literal225_tree);
                    }
                    char_literal226=(Token)match(input,28,FOLLOW_28_in_statement3816); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal226_tree = (Object)adaptor.create(char_literal226);
                    adaptor.addChild(root_0, char_literal226_tree);
                    }

                    }
                    break;
                case 8 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1163:3: 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal227=(Token)match(input,96,FOLLOW_96_in_statement3822); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal227_tree = (Object)adaptor.create(string_literal227);
                    adaptor.addChild(root_0, string_literal227_tree);
                    }
                    char_literal228=(Token)match(input,34,FOLLOW_34_in_statement3824); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal228_tree = (Object)adaptor.create(char_literal228);
                    adaptor.addChild(root_0, char_literal228_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1163:13: ( statement )?
                    int alt96=2;
                    alt96 = dfa96.predict(input);
                    switch (alt96) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: statement
                            {
                            pushFollow(FOLLOW_statement_in_statement3826);
                            statement229=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement229.getTree());

                            }
                            break;

                    }

                    char_literal230=(Token)match(input,28,FOLLOW_28_in_statement3829); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal230_tree = (Object)adaptor.create(char_literal230);
                    adaptor.addChild(root_0, char_literal230_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1163:28: ( expression )?
                    int alt97=2;
                    alt97 = dfa97.predict(input);
                    switch (alt97) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement3831);
                            expression231=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression231.getTree());

                            }
                            break;

                    }

                    char_literal232=(Token)match(input,28,FOLLOW_28_in_statement3834); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal232_tree = (Object)adaptor.create(char_literal232);
                    adaptor.addChild(root_0, char_literal232_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1163:44: ( statement )?
                    int alt98=2;
                    alt98 = dfa98.predict(input);
                    switch (alt98) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: statement
                            {
                            pushFollow(FOLLOW_statement_in_statement3836);
                            statement233=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement233.getTree());

                            }
                            break;

                    }

                    char_literal234=(Token)match(input,35,FOLLOW_35_in_statement3839); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal234_tree = (Object)adaptor.create(char_literal234);
                    adaptor.addChild(root_0, char_literal234_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement3841);
                    statement235=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement235.getTree());

                    }
                    break;
                case 9 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1164:3: 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal236=(Token)match(input,97,FOLLOW_97_in_statement3847); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal236_tree = (Object)adaptor.create(string_literal236);
                    adaptor.addChild(root_0, string_literal236_tree);
                    }
                    char_literal237=(Token)match(input,34,FOLLOW_34_in_statement3849); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal237_tree = (Object)adaptor.create(char_literal237);
                    adaptor.addChild(root_0, char_literal237_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3851);
                    expression238=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression238.getTree());
                    char_literal239=(Token)match(input,35,FOLLOW_35_in_statement3853); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal239_tree = (Object)adaptor.create(char_literal239);
                    adaptor.addChild(root_0, char_literal239_tree);
                    }
                    char_literal240=(Token)match(input,23,FOLLOW_23_in_statement3855); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal240_tree = (Object)adaptor.create(char_literal240);
                    adaptor.addChild(root_0, char_literal240_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1165:3: ( 'case' expression ':' | statement )*
                    loop99:
                    do {
                        int alt99=3;
                        alt99 = dfa99.predict(input);
                        switch (alt99) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1165:5: 'case' expression ':'
                    	    {
                    	    string_literal241=(Token)match(input,98,FOLLOW_98_in_statement3861); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    string_literal241_tree = (Object)adaptor.create(string_literal241);
                    	    adaptor.addChild(root_0, string_literal241_tree);
                    	    }
                    	    pushFollow(FOLLOW_expression_in_statement3863);
                    	    expression242=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression242.getTree());
                    	    char_literal243=(Token)match(input,33,FOLLOW_33_in_statement3865); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal243_tree = (Object)adaptor.create(char_literal243);
                    	    adaptor.addChild(root_0, char_literal243_tree);
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1166:4: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement3872);
                    	    statement244=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement244.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop99;
                        }
                    } while (true);

                    char_literal245=(Token)match(input,24,FOLLOW_24_in_statement3881); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal245_tree = (Object)adaptor.create(char_literal245);
                    adaptor.addChild(root_0, char_literal245_tree);
                    }

                    }
                    break;
                case 10 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1169:3: ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal246=(Token)match(input,28,FOLLOW_28_in_statement3887); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal246_tree = (Object)adaptor.create(char_literal246);
                    adaptor.addChild(root_0, char_literal246_tree);
                    }

                    }
                    break;
                case 11 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1170:3: {...}? IDENTIFIER '(' varDecl ':' expression ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !(( next("foreach") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "statement", " next(\"foreach\") ");
                    }
                    IDENTIFIER247=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement3895); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER247_tree = (Object)adaptor.create(IDENTIFIER247);
                    adaptor.addChild(root_0, IDENTIFIER247_tree);
                    }
                    char_literal248=(Token)match(input,34,FOLLOW_34_in_statement3897); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal248_tree = (Object)adaptor.create(char_literal248);
                    adaptor.addChild(root_0, char_literal248_tree);
                    }
                    pushFollow(FOLLOW_varDecl_in_statement3899);
                    varDecl249=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl249.getTree());
                    char_literal250=(Token)match(input,33,FOLLOW_33_in_statement3901); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal250_tree = (Object)adaptor.create(char_literal250);
                    adaptor.addChild(root_0, char_literal250_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3903);
                    expression251=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression251.getTree());
                    char_literal252=(Token)match(input,35,FOLLOW_35_in_statement3905); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal252_tree = (Object)adaptor.create(char_literal252);
                    adaptor.addChild(root_0, char_literal252_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement3907);
                    statement253=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement253.getTree());

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1173:1: constant returns [Constant constant] : ( DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER | CHARACTER | FLOAT_NUMBER | STRING );
    public final ObjCppParser.constant_return constant() throws RecognitionException {
        ObjCppParser.constant_return retval = new ObjCppParser.constant_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DECIMAL_NUMBER254=null;
        Token HEXADECIMAL_NUMBER255=null;
        Token OCTAL_NUMBER256=null;
        Token CHARACTER257=null;
        Token FLOAT_NUMBER258=null;
        Token STRING259=null;

        Object DECIMAL_NUMBER254_tree=null;
        Object HEXADECIMAL_NUMBER255_tree=null;
        Object OCTAL_NUMBER256_tree=null;
        Object CHARACTER257_tree=null;
        Object FLOAT_NUMBER258_tree=null;
        Object STRING259_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1174:2: ( DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER | CHARACTER | FLOAT_NUMBER | STRING )
            int alt101=6;
            switch ( input.LA(1) ) {
            case DECIMAL_NUMBER:
                {
                alt101=1;
                }
                break;
            case HEXADECIMAL_NUMBER:
                {
                alt101=2;
                }
                break;
            case OCTAL_NUMBER:
                {
                alt101=3;
                }
                break;
            case CHARACTER:
                {
                alt101=4;
                }
                break;
            case FLOAT_NUMBER:
                {
                alt101=5;
                }
                break;
            case STRING:
                {
                alt101=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }

            switch (alt101) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1174:4: DECIMAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    DECIMAL_NUMBER254=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_constant3923); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DECIMAL_NUMBER254_tree = (Object)adaptor.create(DECIMAL_NUMBER254);
                    adaptor.addChild(root_0, DECIMAL_NUMBER254_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant =  Constant.parseDecimal((DECIMAL_NUMBER254!=null?DECIMAL_NUMBER254.getText():null)); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1175:3: HEXADECIMAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    HEXADECIMAL_NUMBER255=(Token)match(input,HEXADECIMAL_NUMBER,FOLLOW_HEXADECIMAL_NUMBER_in_constant3931); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    HEXADECIMAL_NUMBER255_tree = (Object)adaptor.create(HEXADECIMAL_NUMBER255);
                    adaptor.addChild(root_0, HEXADECIMAL_NUMBER255_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant = Constant.parseHex((HEXADECIMAL_NUMBER255!=null?HEXADECIMAL_NUMBER255.getText():null)); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1176:3: OCTAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    OCTAL_NUMBER256=(Token)match(input,OCTAL_NUMBER,FOLLOW_OCTAL_NUMBER_in_constant3939); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OCTAL_NUMBER256_tree = (Object)adaptor.create(OCTAL_NUMBER256);
                    adaptor.addChild(root_0, OCTAL_NUMBER256_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant = Constant.parseOctal((OCTAL_NUMBER256!=null?OCTAL_NUMBER256.getText():null)); 
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1177:3: CHARACTER
                    {
                    root_0 = (Object)adaptor.nil();

                    CHARACTER257=(Token)match(input,CHARACTER,FOLLOW_CHARACTER_in_constant3947); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARACTER257_tree = (Object)adaptor.create(CHARACTER257);
                    adaptor.addChild(root_0, CHARACTER257_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant =  Constant.parseCharOrStringInteger((CHARACTER257!=null?CHARACTER257.getText():null)); 
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1178:3: FLOAT_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    FLOAT_NUMBER258=(Token)match(input,FLOAT_NUMBER,FOLLOW_FLOAT_NUMBER_in_constant3955); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT_NUMBER258_tree = (Object)adaptor.create(FLOAT_NUMBER258);
                    adaptor.addChild(root_0, FLOAT_NUMBER258_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant = Constant.parseFloat((FLOAT_NUMBER258!=null?FLOAT_NUMBER258.getText():null)); 
                    }

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1180:3: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING259=(Token)match(input,STRING,FOLLOW_STRING_in_constant3966); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING259_tree = (Object)adaptor.create(STRING259);
                    adaptor.addChild(root_0, STRING259_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant =  Constant.parseString((STRING259!=null?STRING259.getText():null)); 
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
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:239:5: ( functionDeclaration )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:239:5: functionDeclaration
        {
        pushFollow(FOLLOW_functionDeclaration_in_synpred6_ObjCpp247);
        functionDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_ObjCpp

    // $ANTLR start synpred7_ObjCpp
    public final void synpred7_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:242:5: ( varDecl )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:242:5: varDecl
        {
        pushFollow(FOLLOW_varDecl_in_synpred7_ObjCpp257);
        varDecl();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_ObjCpp

    // $ANTLR start synpred26_ObjCpp
    public final void synpred26_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.varDecl_return fv = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:379:7: (fv= varDecl )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:379:7: fv= varDecl
        {
        pushFollow(FOLLOW_varDecl_in_synpred26_ObjCpp775);
        fv=varDecl();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_ObjCpp

    // $ANTLR start synpred40_ObjCpp
    public final void synpred40_ObjCpp_fragment() throws RecognitionException {   
        Token n0=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:482:4: ( (n0= IDENTIFIER ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:482:4: (n0= IDENTIFIER )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:482:4: (n0= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:483:5: n0= IDENTIFIER
        {
        n0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred40_ObjCpp1113); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred40_ObjCpp

    // $ANTLR start synpred41_ObjCpp
    public final void synpred41_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:489:7: ( exportationModifiers )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:489:7: exportationModifiers
        {
        pushFollow(FOLLOW_exportationModifiers_in_synpred41_ObjCpp1136);
        exportationModifiers();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred41_ObjCpp

    // $ANTLR start synpred47_ObjCpp
    public final void synpred47_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.typeRef_return returnTypeRef = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:519:16: (returnTypeRef= typeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:519:16: returnTypeRef= typeRef
        {
        pushFollow(FOLLOW_typeRef_in_synpred47_ObjCpp1275);
        returnTypeRef=typeRef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_ObjCpp

    // $ANTLR start synpred48_ObjCpp
    public final void synpred48_ObjCpp_fragment() throws RecognitionException {   
        Token ct=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:535:35: (ct= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:535:35: ct= IDENTIFIER
        {
        ct=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred48_ObjCpp1320); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_ObjCpp

    // $ANTLR start synpred50_ObjCpp
    public final void synpred50_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:558:4: ( exportationModifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:558:4: exportationModifier
        {
        pushFollow(FOLLOW_exportationModifier_in_synpred50_ObjCpp1396);
        exportationModifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_ObjCpp

    // $ANTLR start synpred60_ObjCpp
    public final void synpred60_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return m = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:653:5: ({...}?m= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:653:5: {...}?m= modifier
        {
        if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred60_ObjCpp", " next(Modifier.Kind.TypeQualifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred60_ObjCpp1688);
        m=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred60_ObjCpp

    // $ANTLR start synpred61_ObjCpp
    public final void synpred61_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return m1 = null;

        ObjCppParser.typeRef_return tr = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:655:4: ({...}?m1= modifier tr= typeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:655:4: {...}?m1= modifier tr= typeRef
        {
        if ( !(( next(Modifier.Kind.ReferenceQualifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred61_ObjCpp", " next(Modifier.Kind.ReferenceQualifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred61_ObjCpp1705);
        m1=modifier();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_typeRef_in_synpred61_ObjCpp1714);
        tr=typeRef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred61_ObjCpp

    // $ANTLR start synpred78_ObjCpp
    public final void synpred78_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:737:4: ( ( typeMutator )* functionSignatureSuffix )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:737:4: ( typeMutator )* functionSignatureSuffix
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:737:4: ( typeMutator )*
        loop124:
        do {
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==IDENTIFIER||(LA124_0>=51 && LA124_0<=53)) ) {
                alt124=1;
            }


            switch (alt124) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:738:5: typeMutator
        	    {
        	    pushFollow(FOLLOW_typeMutator_in_synpred78_ObjCpp2160);
        	    typeMutator();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop124;
            }
        } while (true);

        pushFollow(FOLLOW_functionSignatureSuffix_in_synpred78_ObjCpp2173);
        functionSignatureSuffix();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred78_ObjCpp

    // $ANTLR start synpred80_ObjCpp
    public final void synpred80_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:752:4: ( ( typeMutator )* functionSignatureSuffixNoName )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:752:4: ( typeMutator )* functionSignatureSuffixNoName
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:752:4: ( typeMutator )*
        loop125:
        do {
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==IDENTIFIER||(LA125_0>=51 && LA125_0<=53)) ) {
                alt125=1;
            }


            switch (alt125) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:753:5: typeMutator
        	    {
        	    pushFollow(FOLLOW_typeMutator_in_synpred80_ObjCpp2214);
        	    typeMutator();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop125;
            }
        } while (true);

        pushFollow(FOLLOW_functionSignatureSuffixNoName_in_synpred80_ObjCpp2227);
        functionSignatureSuffixNoName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred80_ObjCpp

    // $ANTLR start synpred82_ObjCpp
    public final void synpred82_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:773:4: ({...}? modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:773:4: {...}? modifier
        {
        if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred82_ObjCpp", " next(Modifier.Kind.TypeQualifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred82_ObjCpp2291);
        modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred82_ObjCpp

    // $ANTLR start synpred86_ObjCpp
    public final void synpred86_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:793:5: ( '=' expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:793:5: '=' expression
        {
        match(input,29,FOLLOW_29_in_synpred86_ObjCpp2382); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred86_ObjCpp2389);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred86_ObjCpp

    // $ANTLR start synpred88_ObjCpp
    public final void synpred88_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return sm = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:834:4: ({...}?sm= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:834:4: {...}?sm= modifier
        {
        if ( !(( next(Modifier.Kind.StorageClassSpecifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred88_ObjCpp", " next(Modifier.Kind.StorageClassSpecifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred88_ObjCpp2517);
        sm=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred88_ObjCpp

    // $ANTLR start synpred89_ObjCpp
    public final void synpred89_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return tm = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:836:4: ({...}?tm= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:836:4: {...}?tm= modifier
        {
        if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred89_ObjCpp", " next(Modifier.Kind.TypeQualifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred89_ObjCpp2534);
        tm=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred89_ObjCpp

    // $ANTLR start synpred95_ObjCpp
    public final void synpred95_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return im = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:922:5: (im= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:922:5: im= modifier
        {
        pushFollow(FOLLOW_modifier_in_synpred95_ObjCpp2801);
        im=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred95_ObjCpp

    // $ANTLR start synpred99_ObjCpp
    public final void synpred99_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.argDef_return ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:960:5: ( ',' ax= argDef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:960:5: ',' ax= argDef
        {
        match(input,27,FOLLOW_27_in_synpred99_ObjCpp2919); if (state.failed) return ;
        pushFollow(FOLLOW_argDef_in_synpred99_ObjCpp2928);
        ax=argDef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred99_ObjCpp

    // $ANTLR start synpred102_ObjCpp
    public final void synpred102_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:981:4: ( typeMutator )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:981:4: typeMutator
        {
        pushFollow(FOLLOW_typeMutator_in_synpred102_ObjCpp2995);
        typeMutator();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred102_ObjCpp

    // $ANTLR start synpred130_ObjCpp
    public final void synpred130_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.expression_return par = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1111:5: (par= expression ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1111:5: par= expression ')'
        {
        pushFollow(FOLLOW_expression_in_synpred130_ObjCpp3462);
        par=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred130_ObjCpp3464); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred130_ObjCpp

    // $ANTLR start synpred151_ObjCpp
    public final void synpred151_ObjCpp_fragment() throws RecognitionException {   
        Token bop=null;
        ObjCppParser.expression_return opd2 = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1124:4: (bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1124:4: bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression
        {
        bop=(Token)input.LT(1);
        if ( (input.LA(1)>=36 && input.LA(1)<=37)||(input.LA(1)>=42 && input.LA(1)<=43)||(input.LA(1)>=51 && input.LA(1)<=52)||input.LA(1)==57||(input.LA(1)>=77 && input.LA(1)<=88) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }

        pushFollow(FOLLOW_expression_in_synpred151_ObjCpp3618);
        opd2=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred151_ObjCpp

    // $ANTLR start synpred152_ObjCpp
    public final void synpred152_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.expression_return val = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1131:4: ( '=' val= expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1131:4: '=' val= expression
        {
        match(input,29,FOLLOW_29_in_synpred152_ObjCpp3627); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred152_ObjCpp3631);
        val=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred152_ObjCpp

    // $ANTLR start synpred153_ObjCpp
    public final void synpred153_ObjCpp_fragment() throws RecognitionException {   
        Token fieldName=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1134:4: ( '.' fieldName= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1134:4: '.' fieldName= IDENTIFIER
        {
        match(input,89,FOLLOW_89_in_synpred153_ObjCpp3640); if (state.failed) return ;
        fieldName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred153_ObjCpp3644); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred153_ObjCpp

    // $ANTLR start synpred156_ObjCpp
    public final void synpred156_ObjCpp_fragment() throws RecognitionException {   
        Token refStyle=null;
        ObjCppParser.functionCall_return fc2 = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1137:4: (refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1137:4: refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1137:13: ( ':' ':' | '-' '>' | '.' )
        int alt134=3;
        switch ( input.LA(1) ) {
        case 33:
            {
            alt134=1;
            }
            break;
        case 43:
            {
            alt134=2;
            }
            break;
        case 89:
            {
            alt134=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 134, 0, input);

            throw nvae;
        }

        switch (alt134) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1137:14: ':' ':'
                {
                match(input,33,FOLLOW_33_in_synpred156_ObjCpp3656); if (state.failed) return ;
                match(input,33,FOLLOW_33_in_synpred156_ObjCpp3658); if (state.failed) return ;

                }
                break;
            case 2 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1137:24: '-' '>'
                {
                match(input,43,FOLLOW_43_in_synpred156_ObjCpp3662); if (state.failed) return ;
                match(input,37,FOLLOW_37_in_synpred156_ObjCpp3664); if (state.failed) return ;

                }
                break;
            case 3 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1137:34: '.'
                {
                match(input,89,FOLLOW_89_in_synpred156_ObjCpp3668); if (state.failed) return ;

                }
                break;

        }

        pushFollow(FOLLOW_functionCall_in_synpred156_ObjCpp3673);
        fc2=functionCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred156_ObjCpp

    // $ANTLR start synpred157_ObjCpp
    public final void synpred157_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.expression_return xif = null;

        ObjCppParser.expression_return xelse = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1144:4: ( '?' xif= expression ':' xelse= expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1144:4: '?' xif= expression ':' xelse= expression
        {
        match(input,90,FOLLOW_90_in_synpred157_ObjCpp3682); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred157_ObjCpp3686);
        xif=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,33,FOLLOW_33_in_synpred157_ObjCpp3688); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred157_ObjCpp3692);
        xelse=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred157_ObjCpp

    // $ANTLR start synpred159_ObjCpp
    public final void synpred159_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1156:3: ( statementsBlock )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1156:3: statementsBlock
        {
        pushFollow(FOLLOW_statementsBlock_in_synpred159_ObjCpp3731);
        statementsBlock();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred159_ObjCpp

    // $ANTLR start synpred160_ObjCpp
    public final void synpred160_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1157:3: ( declaration )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1157:3: declaration
        {
        pushFollow(FOLLOW_declaration_in_synpred160_ObjCpp3737);
        declaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred160_ObjCpp

    // $ANTLR start synpred162_ObjCpp
    public final void synpred162_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1158:3: ( expression ( '=' expression )? ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1158:3: expression ( '=' expression )? ';'
        {
        pushFollow(FOLLOW_expression_in_synpred162_ObjCpp3743);
        expression();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1158:14: ( '=' expression )?
        int alt135=2;
        int LA135_0 = input.LA(1);

        if ( (LA135_0==29) ) {
            alt135=1;
        }
        switch (alt135) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1158:15: '=' expression
                {
                match(input,29,FOLLOW_29_in_synpred162_ObjCpp3746); if (state.failed) return ;
                pushFollow(FOLLOW_expression_in_synpred162_ObjCpp3748);
                expression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }

        match(input,28,FOLLOW_28_in_synpred162_ObjCpp3753); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred162_ObjCpp

    // $ANTLR start synpred164_ObjCpp
    public final void synpred164_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1160:38: ( 'else' statement )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1160:38: 'else' statement
        {
        match(input,93,FOLLOW_93_in_synpred164_ObjCpp3780); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred164_ObjCpp3782);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred164_ObjCpp

    // $ANTLR start synpred168_ObjCpp
    public final void synpred168_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1163:13: ( statement )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1163:13: statement
        {
        pushFollow(FOLLOW_statement_in_synpred168_ObjCpp3826);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred168_ObjCpp

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
    public final boolean synpred95_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred95_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred160_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred160_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred50_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred164_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred164_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred89_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred89_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred162_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred162_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred159_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred159_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred156_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred156_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred153_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred153_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred151_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred151_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred130_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred130_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred152_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred152_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred41_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred41_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred48_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred102_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred102_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred47_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred99_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred99_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred157_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred157_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred86_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred86_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA2 dfa2 = new DFA2(this);
    protected DFA3 dfa3 = new DFA3(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA16 dfa16 = new DFA16(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA43 dfa43 = new DFA43(this);
    protected DFA48 dfa48 = new DFA48(this);
    protected DFA46 dfa46 = new DFA46(this);
    protected DFA60 dfa60 = new DFA60(this);
    protected DFA62 dfa62 = new DFA62(this);
    protected DFA64 dfa64 = new DFA64(this);
    protected DFA66 dfa66 = new DFA66(this);
    protected DFA68 dfa68 = new DFA68(this);
    protected DFA73 dfa73 = new DFA73(this);
    protected DFA75 dfa75 = new DFA75(this);
    protected DFA77 dfa77 = new DFA77(this);
    protected DFA80 dfa80 = new DFA80(this);
    protected DFA83 dfa83 = new DFA83(this);
    protected DFA82 dfa82 = new DFA82(this);
    protected DFA87 dfa87 = new DFA87(this);
    protected DFA90 dfa90 = new DFA90(this);
    protected DFA89 dfa89 = new DFA89(this);
    protected DFA92 dfa92 = new DFA92(this);
    protected DFA93 dfa93 = new DFA93(this);
    protected DFA100 dfa100 = new DFA100(this);
    protected DFA95 dfa95 = new DFA95(this);
    protected DFA96 dfa96 = new DFA96(this);
    protected DFA97 dfa97 = new DFA97(this);
    protected DFA98 dfa98 = new DFA98(this);
    protected DFA99 dfa99 = new DFA99(this);
    static final String DFA1_eotS =
        "\17\uffff";
    static final String DFA1_eofS =
        "\1\2\16\uffff";
    static final String DFA1_minS =
        "\1\4\16\uffff";
    static final String DFA1_maxS =
        "\1\111\16\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\1\1\2\14\uffff";
    static final String DFA1_specialS =
        "\17\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\2\1\1\1\2\17\uffff\1\2\2\uffff\2\2\3\uffff\3\2\14\uffff\3"+
            "\2\12\uffff\20\2",
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

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "183:3: (unescapedString= STRING )?";
        }
    }
    static final String DFA2_eotS =
        "\16\uffff";
    static final String DFA2_eofS =
        "\1\2\15\uffff";
    static final String DFA2_minS =
        "\1\4\15\uffff";
    static final String DFA2_maxS =
        "\1\111\15\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\1\2\13\uffff";
    static final String DFA2_specialS =
        "\16\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\1\1\uffff\1\2\17\uffff\1\2\2\uffff\2\2\3\uffff\3\2\14\uffff"+
            "\3\2\12\uffff\20\2",
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

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "194:8: (depth= DECIMAL_NUMBER )?";
        }
    }
    static final String DFA3_eotS =
        "\15\uffff";
    static final String DFA3_eofS =
        "\1\1\14\uffff";
    static final String DFA3_minS =
        "\1\6\14\uffff";
    static final String DFA3_maxS =
        "\1\111\14\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\3\1\1\11\uffff\1\2";
    static final String DFA3_specialS =
        "\15\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\2\17\uffff\1\14\2\uffff\2\2\3\uffff\3\2\14\uffff\3\2\12\uffff"+
            "\20\2",
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

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "()* loopback of 200:3: ( declaration | lineDirective )*";
        }
    }
    static final String DFA4_eotS =
        "\14\uffff";
    static final String DFA4_eofS =
        "\14\uffff";
    static final String DFA4_minS =
        "\1\6\13\uffff";
    static final String DFA4_maxS =
        "\1\111\13\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\2\1\1\11\uffff";
    static final String DFA4_specialS =
        "\14\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\2\21\uffff\1\1\2\2\3\uffff\3\2\14\uffff\3\2\12\uffff\20\2",
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

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "()* loopback of 215:4: (ed= declaration )*";
        }
    }
    static final String DFA6_eotS =
        "\u00d2\uffff";
    static final String DFA6_eofS =
        "\u00d2\uffff";
    static final String DFA6_minS =
        "\4\6\1\77\2\6\4\uffff\2\6\1\27\4\6\1\77\5\6\1\66\1\6\1\uffff\5\6"+
        "\1\66\3\6\1\uffff\3\6\1\66\1\6\1\uffff\4\0\1\uffff\1\0\2\uffff\32"+
        "\0\1\uffff\5\0\3\uffff\11\0\1\uffff\5\0\1\uffff\2\0\11\uffff\5\0"+
        "\1\uffff\5\0\1\uffff\17\0\1\uffff\5\0\1\uffff\1\0\1\uffff\1\0\3"+
        "\uffff\1\0\1\uffff\5\0\1\uffff\5\0\1\uffff\3\0\2\uffff\6\0\1\uffff"+
        "\5\0\1\uffff\1\0\1\uffff\1\0\3\uffff\1\0\1\uffff\5\0\1\uffff\5\0"+
        "\1\uffff\3\0\2\uffff";
    static final String DFA6_maxS =
        "\1\111\2\27\3\111\1\71\4\uffff\1\71\1\111\1\27\1\6\2\27\3\111\1"+
        "\71\1\111\2\71\1\66\1\111\1\uffff\1\111\4\71\1\66\1\71\1\111\1\71"+
        "\1\uffff\3\71\1\66\1\71\1\uffff\4\0\1\uffff\1\0\2\uffff\32\0\1\uffff"+
        "\5\0\3\uffff\11\0\1\uffff\5\0\1\uffff\2\0\11\uffff\5\0\1\uffff\5"+
        "\0\1\uffff\17\0\1\uffff\5\0\1\uffff\1\0\1\uffff\1\0\3\uffff\1\0"+
        "\1\uffff\5\0\1\uffff\5\0\1\uffff\3\0\2\uffff\6\0\1\uffff\5\0\1\uffff"+
        "\1\0\1\uffff\1\0\3\uffff\1\0\1\uffff\5\0\1\uffff\5\0\1\uffff\3\0"+
        "\2\uffff";
    static final String DFA6_acceptS =
        "\7\uffff\1\3\1\4\1\5\1\6\17\uffff\1\2\27\uffff\1\1\u009f\uffff";
    static final String DFA6_specialS =
        "\53\uffff\1\0\1\1\1\2\1\3\1\uffff\1\4\2\uffff\1\5\1\6\1\7\1\10\1"+
        "\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
        "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\uffff\1\37\1\40"+
        "\1\41\1\42\1\43\3\uffff\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53"+
        "\1\54\1\uffff\1\55\1\56\1\57\1\60\1\61\1\uffff\1\62\1\63\11\uffff"+
        "\1\64\1\65\1\66\1\67\1\70\1\uffff\1\71\1\72\1\73\1\74\1\75\1\uffff"+
        "\1\76\1\77\1\100\1\101\1\102\1\103\1\104\1\105\1\106\1\107\1\110"+
        "\1\111\1\112\1\113\1\114\1\uffff\1\115\1\116\1\117\1\120\1\121\1"+
        "\uffff\1\122\1\uffff\1\123\3\uffff\1\124\1\uffff\1\125\1\126\1\127"+
        "\1\130\1\131\1\uffff\1\132\1\133\1\134\1\135\1\136\1\uffff\1\137"+
        "\1\140\1\141\2\uffff\1\142\1\143\1\144\1\145\1\146\1\147\1\uffff"+
        "\1\150\1\151\1\152\1\153\1\154\1\uffff\1\155\1\uffff\1\156\3\uffff"+
        "\1\157\1\uffff\1\160\1\161\1\162\1\163\1\164\1\uffff\1\165\1\166"+
        "\1\167\1\170\1\171\1\uffff\1\172\1\173\1\174\2\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\3\22\uffff\1\12\1\11\3\uffff\1\2\2\7\14\uffff\3\1\12\uffff"+
            "\1\10\4\4\2\5\11\6",
            "\1\13\20\uffff\1\14",
            "\1\15\20\uffff\1\16",
            "\1\21\27\uffff\1\20\3\uffff\1\25\1\uffff\1\31\10\uffff\3\17"+
            "\3\uffff\1\26\1\27\1\30\3\uffff\1\32\1\uffff\4\22\2\23\11\24",
            "\2\33\11\34",
            "\1\35\33\uffff\1\41\20\uffff\1\36\1\37\1\40\3\uffff\1\32\5"+
            "\uffff\2\42\11\43",
            "\1\45\33\uffff\1\51\20\uffff\1\46\1\47\1\50\3\uffff\1\32",
            "",
            "",
            "",
            "",
            "\1\54\20\uffff\1\53\4\uffff\1\32\5\uffff\1\56\20\uffff\1\55"+
            "\1\60\1\62\3\uffff\1\32",
            "\1\70\21\uffff\1\100\1\77\1\76\3\uffff\1\67\2\74\14\uffff\3"+
            "\66\1\63\1\64\1\65\7\uffff\1\75\4\71\2\72\11\73",
            "\1\101",
            "\1\102",
            "\1\103\20\uffff\1\104",
            "\1\105\20\uffff\1\106",
            "\1\110\24\uffff\3\32\1\117\3\uffff\1\113\1\uffff\1\114\10\uffff"+
            "\3\116\3\uffff\1\107\1\111\1\112\3\uffff\1\32\1\uffff\4\120"+
            "\2\121\11\122",
            "\2\126\11\127",
            "\1\130\33\uffff\1\134\20\uffff\1\131\1\132\1\133\3\uffff\1"+
            "\32\5\uffff\2\135\11\136",
            "\1\140\33\uffff\1\144\20\uffff\1\141\1\142\1\143\3\uffff\1"+
            "\32",
            "\1\146\27\uffff\1\62\3\uffff\1\32\1\62\10\uffff\4\62\3\uffff"+
            "\1\147\1\32\4\uffff\1\32\1\uffff\17\62",
            "\1\162\33\uffff\1\161\20\uffff\1\163\1\164\1\165\3\uffff\1"+
            "\32",
            "\1\170\33\uffff\1\167\20\uffff\1\171\1\172\1\173\3\uffff\1"+
            "\32",
            "\1\175",
            "\1\u0080\27\uffff\1\177\6\uffff\1\u0084\7\uffff\3\176\13\uffff"+
            "\4\u0081\2\u0082\11\u0083",
            "",
            "\1\u0085\33\uffff\1\u0089\20\uffff\1\u0086\1\u0087\1\u0088"+
            "\3\uffff\1\32\5\uffff\2\u008a\11\u008b",
            "\1\u008d\33\uffff\1\u0091\20\uffff\1\u008e\1\u008f\1\u0090"+
            "\3\uffff\1\32",
            "\1\u0099\24\uffff\3\32\4\uffff\1\u0095\20\uffff\1\u0093\2\32"+
            "\3\uffff\1\32",
            "\1\u009c\33\uffff\1\u009b\20\uffff\1\u009d\1\u009e\1\u009f"+
            "\3\uffff\1\32",
            "\1\u00a2\33\uffff\1\u00a1\20\uffff\1\u00a3\1\u00a4\1\u00a5"+
            "\3\uffff\1\32",
            "\1\u00a7",
            "\1\u00a8\33\uffff\1\32\20\uffff\1\u00a9\1\32\4\uffff\1\32",
            "\1\u00ac\33\uffff\1\u00b0\20\uffff\1\u00ad\1\u00ae\1\u00af"+
            "\3\uffff\1\32\5\uffff\13\u00b1",
            "\1\u00b3\33\uffff\1\u00b7\20\uffff\1\u00b4\1\u00b5\1\u00b6"+
            "\3\uffff\1\32",
            "",
            "\1\u00bf\24\uffff\3\32\4\uffff\1\u00bb\20\uffff\1\u00b9\2\32"+
            "\3\uffff\1\32",
            "\1\u00c2\33\uffff\1\u00c1\20\uffff\1\u00c3\1\u00c4\1\u00c5"+
            "\3\uffff\1\32",
            "\1\u00c8\33\uffff\1\u00c7\20\uffff\1\u00c9\1\u00ca\1\u00cb"+
            "\3\uffff\1\32",
            "\1\u00cd",
            "\1\u00ce\33\uffff\1\32\20\uffff\1\u00cf\1\32\4\uffff\1\32",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            return "237:4: ( functionDeclaration | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA6_43 = input.LA(1);

                         
                        int index6_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_43);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_44 = input.LA(1);

                         
                        int index6_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_44);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA6_45 = input.LA(1);

                         
                        int index6_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_45);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA6_46 = input.LA(1);

                         
                        int index6_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_46);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA6_48 = input.LA(1);

                         
                        int index6_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_48);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA6_51 = input.LA(1);

                         
                        int index6_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_51);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA6_52 = input.LA(1);

                         
                        int index6_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_52);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA6_53 = input.LA(1);

                         
                        int index6_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_53);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA6_54 = input.LA(1);

                         
                        int index6_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_54);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA6_55 = input.LA(1);

                         
                        int index6_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_55);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA6_56 = input.LA(1);

                         
                        int index6_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_56);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA6_57 = input.LA(1);

                         
                        int index6_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_57);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA6_58 = input.LA(1);

                         
                        int index6_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_58);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA6_59 = input.LA(1);

                         
                        int index6_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_59);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA6_60 = input.LA(1);

                         
                        int index6_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_60);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA6_61 = input.LA(1);

                         
                        int index6_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_61);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA6_62 = input.LA(1);

                         
                        int index6_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_62);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA6_63 = input.LA(1);

                         
                        int index6_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_63);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA6_64 = input.LA(1);

                         
                        int index6_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_64);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA6_65 = input.LA(1);

                         
                        int index6_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_65);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA6_66 = input.LA(1);

                         
                        int index6_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_66);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA6_67 = input.LA(1);

                         
                        int index6_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_67);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA6_68 = input.LA(1);

                         
                        int index6_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_68);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA6_69 = input.LA(1);

                         
                        int index6_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_69);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA6_70 = input.LA(1);

                         
                        int index6_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_70);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA6_71 = input.LA(1);

                         
                        int index6_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_71);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA6_72 = input.LA(1);

                         
                        int index6_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_72);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA6_73 = input.LA(1);

                         
                        int index6_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_73);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA6_74 = input.LA(1);

                         
                        int index6_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_74);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA6_75 = input.LA(1);

                         
                        int index6_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_75);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA6_76 = input.LA(1);

                         
                        int index6_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_76);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA6_78 = input.LA(1);

                         
                        int index6_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_78);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA6_79 = input.LA(1);

                         
                        int index6_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_79);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA6_80 = input.LA(1);

                         
                        int index6_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_80);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA6_81 = input.LA(1);

                         
                        int index6_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_81);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA6_82 = input.LA(1);

                         
                        int index6_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_82);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA6_86 = input.LA(1);

                         
                        int index6_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_86);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA6_87 = input.LA(1);

                         
                        int index6_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_87);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA6_88 = input.LA(1);

                         
                        int index6_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_88);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA6_89 = input.LA(1);

                         
                        int index6_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_89);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA6_90 = input.LA(1);

                         
                        int index6_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_90);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA6_91 = input.LA(1);

                         
                        int index6_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_91);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA6_92 = input.LA(1);

                         
                        int index6_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_92);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA6_93 = input.LA(1);

                         
                        int index6_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_93);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA6_94 = input.LA(1);

                         
                        int index6_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_94);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA6_96 = input.LA(1);

                         
                        int index6_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_96);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA6_97 = input.LA(1);

                         
                        int index6_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_97);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA6_98 = input.LA(1);

                         
                        int index6_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_98);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA6_99 = input.LA(1);

                         
                        int index6_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_99);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA6_100 = input.LA(1);

                         
                        int index6_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 26;}

                         
                        input.seek(index6_100);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA6_102 = input.LA(1);

                         
                        int index6_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 26;}

                         
                        input.seek(index6_102);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA6_103 = input.LA(1);

                         
                        int index6_103 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 26;}

                         
                        input.seek(index6_103);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA6_113 = input.LA(1);

                         
                        int index6_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 26;}

                         
                        input.seek(index6_113);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA6_114 = input.LA(1);

                         
                        int index6_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 26;}

                         
                        input.seek(index6_114);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA6_115 = input.LA(1);

                         
                        int index6_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 26;}

                         
                        input.seek(index6_115);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA6_116 = input.LA(1);

                         
                        int index6_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 26;}

                         
                        input.seek(index6_116);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA6_117 = input.LA(1);

                         
                        int index6_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 26;}

                         
                        input.seek(index6_117);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA6_119 = input.LA(1);

                         
                        int index6_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 26;}

                         
                        input.seek(index6_119);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA6_120 = input.LA(1);

                         
                        int index6_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 26;}

                         
                        input.seek(index6_120);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA6_121 = input.LA(1);

                         
                        int index6_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 26;}

                         
                        input.seek(index6_121);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA6_122 = input.LA(1);

                         
                        int index6_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 26;}

                         
                        input.seek(index6_122);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA6_123 = input.LA(1);

                         
                        int index6_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 26;}

                         
                        input.seek(index6_123);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA6_125 = input.LA(1);

                         
                        int index6_125 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 26;}

                         
                        input.seek(index6_125);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA6_126 = input.LA(1);

                         
                        int index6_126 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 26;}

                         
                        input.seek(index6_126);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA6_127 = input.LA(1);

                         
                        int index6_127 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 26;}

                         
                        input.seek(index6_127);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA6_128 = input.LA(1);

                         
                        int index6_128 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 26;}

                         
                        input.seek(index6_128);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA6_129 = input.LA(1);

                         
                        int index6_129 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 26;}

                         
                        input.seek(index6_129);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA6_130 = input.LA(1);

                         
                        int index6_130 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 26;}

                         
                        input.seek(index6_130);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA6_131 = input.LA(1);

                         
                        int index6_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 26;}

                         
                        input.seek(index6_131);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA6_132 = input.LA(1);

                         
                        int index6_132 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 26;}

                         
                        input.seek(index6_132);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA6_133 = input.LA(1);

                         
                        int index6_133 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_133);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA6_134 = input.LA(1);

                         
                        int index6_134 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_134);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA6_135 = input.LA(1);

                         
                        int index6_135 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_135);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA6_136 = input.LA(1);

                         
                        int index6_136 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_136);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA6_137 = input.LA(1);

                         
                        int index6_137 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_137);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA6_138 = input.LA(1);

                         
                        int index6_138 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_138);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA6_139 = input.LA(1);

                         
                        int index6_139 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_139);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA6_141 = input.LA(1);

                         
                        int index6_141 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_141);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA6_142 = input.LA(1);

                         
                        int index6_142 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_142);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA6_143 = input.LA(1);

                         
                        int index6_143 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_143);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA6_144 = input.LA(1);

                         
                        int index6_144 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_144);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA6_145 = input.LA(1);

                         
                        int index6_145 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_145);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA6_147 = input.LA(1);

                         
                        int index6_147 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_147);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA6_149 = input.LA(1);

                         
                        int index6_149 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_149);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA6_153 = input.LA(1);

                         
                        int index6_153 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_153);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA6_155 = input.LA(1);

                         
                        int index6_155 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_155);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA6_156 = input.LA(1);

                         
                        int index6_156 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_156);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA6_157 = input.LA(1);

                         
                        int index6_157 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_157);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA6_158 = input.LA(1);

                         
                        int index6_158 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_158);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA6_159 = input.LA(1);

                         
                        int index6_159 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_159);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA6_161 = input.LA(1);

                         
                        int index6_161 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_161);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA6_162 = input.LA(1);

                         
                        int index6_162 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_162);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA6_163 = input.LA(1);

                         
                        int index6_163 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_163);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA6_164 = input.LA(1);

                         
                        int index6_164 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_164);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA6_165 = input.LA(1);

                         
                        int index6_165 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_165);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA6_167 = input.LA(1);

                         
                        int index6_167 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_167);
                        if ( s>=0 ) return s;
                        break;
                    case 96 : 
                        int LA6_168 = input.LA(1);

                         
                        int index6_168 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_168);
                        if ( s>=0 ) return s;
                        break;
                    case 97 : 
                        int LA6_169 = input.LA(1);

                         
                        int index6_169 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_169);
                        if ( s>=0 ) return s;
                        break;
                    case 98 : 
                        int LA6_172 = input.LA(1);

                         
                        int index6_172 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_172);
                        if ( s>=0 ) return s;
                        break;
                    case 99 : 
                        int LA6_173 = input.LA(1);

                         
                        int index6_173 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_173);
                        if ( s>=0 ) return s;
                        break;
                    case 100 : 
                        int LA6_174 = input.LA(1);

                         
                        int index6_174 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_174);
                        if ( s>=0 ) return s;
                        break;
                    case 101 : 
                        int LA6_175 = input.LA(1);

                         
                        int index6_175 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_175);
                        if ( s>=0 ) return s;
                        break;
                    case 102 : 
                        int LA6_176 = input.LA(1);

                         
                        int index6_176 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_176);
                        if ( s>=0 ) return s;
                        break;
                    case 103 : 
                        int LA6_177 = input.LA(1);

                         
                        int index6_177 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_177);
                        if ( s>=0 ) return s;
                        break;
                    case 104 : 
                        int LA6_179 = input.LA(1);

                         
                        int index6_179 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_179);
                        if ( s>=0 ) return s;
                        break;
                    case 105 : 
                        int LA6_180 = input.LA(1);

                         
                        int index6_180 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_180);
                        if ( s>=0 ) return s;
                        break;
                    case 106 : 
                        int LA6_181 = input.LA(1);

                         
                        int index6_181 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_181);
                        if ( s>=0 ) return s;
                        break;
                    case 107 : 
                        int LA6_182 = input.LA(1);

                         
                        int index6_182 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_182);
                        if ( s>=0 ) return s;
                        break;
                    case 108 : 
                        int LA6_183 = input.LA(1);

                         
                        int index6_183 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_183);
                        if ( s>=0 ) return s;
                        break;
                    case 109 : 
                        int LA6_185 = input.LA(1);

                         
                        int index6_185 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_185);
                        if ( s>=0 ) return s;
                        break;
                    case 110 : 
                        int LA6_187 = input.LA(1);

                         
                        int index6_187 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_187);
                        if ( s>=0 ) return s;
                        break;
                    case 111 : 
                        int LA6_191 = input.LA(1);

                         
                        int index6_191 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_191);
                        if ( s>=0 ) return s;
                        break;
                    case 112 : 
                        int LA6_193 = input.LA(1);

                         
                        int index6_193 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_193);
                        if ( s>=0 ) return s;
                        break;
                    case 113 : 
                        int LA6_194 = input.LA(1);

                         
                        int index6_194 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_194);
                        if ( s>=0 ) return s;
                        break;
                    case 114 : 
                        int LA6_195 = input.LA(1);

                         
                        int index6_195 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_195);
                        if ( s>=0 ) return s;
                        break;
                    case 115 : 
                        int LA6_196 = input.LA(1);

                         
                        int index6_196 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_196);
                        if ( s>=0 ) return s;
                        break;
                    case 116 : 
                        int LA6_197 = input.LA(1);

                         
                        int index6_197 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_197);
                        if ( s>=0 ) return s;
                        break;
                    case 117 : 
                        int LA6_199 = input.LA(1);

                         
                        int index6_199 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_199);
                        if ( s>=0 ) return s;
                        break;
                    case 118 : 
                        int LA6_200 = input.LA(1);

                         
                        int index6_200 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_200);
                        if ( s>=0 ) return s;
                        break;
                    case 119 : 
                        int LA6_201 = input.LA(1);

                         
                        int index6_201 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_201);
                        if ( s>=0 ) return s;
                        break;
                    case 120 : 
                        int LA6_202 = input.LA(1);

                         
                        int index6_202 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_202);
                        if ( s>=0 ) return s;
                        break;
                    case 121 : 
                        int LA6_203 = input.LA(1);

                         
                        int index6_203 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_203);
                        if ( s>=0 ) return s;
                        break;
                    case 122 : 
                        int LA6_205 = input.LA(1);

                         
                        int index6_205 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_205);
                        if ( s>=0 ) return s;
                        break;
                    case 123 : 
                        int LA6_206 = input.LA(1);

                         
                        int index6_206 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_206);
                        if ( s>=0 ) return s;
                        break;
                    case 124 : 
                        int LA6_207 = input.LA(1);

                         
                        int index6_207 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 26;}

                         
                        input.seek(index6_207);
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
    static final String DFA5_eotS =
        "\14\uffff";
    static final String DFA5_eofS =
        "\14\uffff";
    static final String DFA5_minS =
        "\1\6\13\uffff";
    static final String DFA5_maxS =
        "\1\111\13\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\2\1\1\11\uffff";
    static final String DFA5_specialS =
        "\14\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\2\21\uffff\1\1\2\2\3\uffff\3\2\14\uffff\3\2\12\uffff\20\2",
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

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "()* loopback of 255:6: (subD= declaration )*";
        }
    }
    static final String DFA13_eotS =
        "\17\uffff";
    static final String DFA13_eofS =
        "\17\uffff";
    static final String DFA13_minS =
        "\1\6\16\uffff";
    static final String DFA13_maxS =
        "\1\111\16\uffff";
    static final String DFA13_acceptS =
        "\1\uffff\1\1\14\uffff\1\2";
    static final String DFA13_specialS =
        "\17\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\1\20\uffff\1\1\6\uffff\1\1\2\uffff\1\1\1\16\1\uffff\1\1\4"+
            "\uffff\3\1\1\uffff\3\1\12\uffff\20\1",
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

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "351:3: ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' )";
        }
    }
    static final String DFA12_eotS =
        "\16\uffff";
    static final String DFA12_eofS =
        "\16\uffff";
    static final String DFA12_minS =
        "\1\6\15\uffff";
    static final String DFA12_maxS =
        "\1\111\15\uffff";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\1\2\13\uffff";
    static final String DFA12_specialS =
        "\16\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\2\20\uffff\1\2\6\uffff\1\2\2\uffff\1\1\2\uffff\1\2\4\uffff"+
            "\3\2\1\uffff\3\2\12\uffff\20\2",
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
            return "352:4: ( ':' parentClass= IDENTIFIER )?";
        }
    }
    static final String DFA16_eotS =
        "\15\uffff";
    static final String DFA16_eofS =
        "\15\uffff";
    static final String DFA16_minS =
        "\1\6\14\uffff";
    static final String DFA16_maxS =
        "\1\111\14\uffff";
    static final String DFA16_acceptS =
        "\1\uffff\1\1\1\2\12\uffff";
    static final String DFA16_specialS =
        "\15\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\2\20\uffff\1\2\6\uffff\1\2\5\uffff\1\1\4\uffff\3\2\1\uffff"+
            "\3\2\12\uffff\20\2",
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

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "362:3: ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )?";
        }
    }
    static final String DFA19_eotS =
        "\14\uffff";
    static final String DFA19_eofS =
        "\14\uffff";
    static final String DFA19_minS =
        "\1\6\13\uffff";
    static final String DFA19_maxS =
        "\1\111\13\uffff";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\1\2\11\uffff";
    static final String DFA19_specialS =
        "\14\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\2\20\uffff\1\1\6\uffff\1\2\12\uffff\3\2\1\uffff\3\2\12\uffff"+
            "\20\2",
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

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "371:3: ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )?";
        }
    }
    static final String DFA18_eotS =
        "\13\uffff";
    static final String DFA18_eofS =
        "\13\uffff";
    static final String DFA18_minS =
        "\1\6\12\uffff";
    static final String DFA18_maxS =
        "\1\111\12\uffff";
    static final String DFA18_acceptS =
        "\1\uffff\1\5\1\1\1\2\1\3\1\4\5\uffff";
    static final String DFA18_specialS =
        "\13\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\5\21\uffff\1\1\5\uffff\1\5\7\uffff\1\2\1\3\1\4\4\uffff\3"+
            "\5\13\uffff\17\5",
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

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "()* loopback of 373:4: ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )*";
        }
    }
    static final String DFA17_eotS =
        "\u00d6\uffff";
    static final String DFA17_eofS =
        "\u00d6\uffff";
    static final String DFA17_minS =
        "\4\6\1\77\5\6\1\77\4\6\1\66\1\6\1\uffff\1\6\1\uffff\2\6\1\27\10"+
        "\6\1\66\1\6\2\uffff\3\6\1\66\1\6\2\uffff\11\0\1\uffff\7\0\2\uffff"+
        "\11\0\2\uffff\5\0\3\uffff\5\0\1\uffff\5\0\2\uffff\3\0\2\uffff\15"+
        "\0\2\uffff\27\0\2\uffff\5\0\2\uffff\6\0\2\uffff\5\0\2\uffff\1\0"+
        "\10\uffff\5\0\1\uffff\5\0\2\uffff\3\0\2\uffff\1\0\10\uffff\5\0\1"+
        "\uffff\5\0\2\uffff\3\0\2\uffff";
    static final String DFA17_maxS =
        "\2\111\2\27\2\111\1\71\2\27\3\111\3\71\1\66\1\71\1\uffff\1\111\1"+
        "\uffff\1\71\1\111\1\27\1\6\1\111\1\71\1\111\4\71\1\66\1\71\2\uffff"+
        "\3\71\1\66\1\71\2\uffff\11\0\1\uffff\7\0\2\uffff\11\0\2\uffff\5"+
        "\0\3\uffff\5\0\1\uffff\5\0\2\uffff\3\0\2\uffff\15\0\2\uffff\27\0"+
        "\2\uffff\5\0\2\uffff\6\0\2\uffff\5\0\2\uffff\1\0\10\uffff\5\0\1"+
        "\uffff\5\0\2\uffff\3\0\2\uffff\1\0\10\uffff\5\0\1\uffff\5\0\2\uffff"+
        "\3\0\2\uffff";
    static final String DFA17_acceptS =
        "\21\uffff\1\2\1\uffff\1\1\u00c2\uffff";
    static final String DFA17_specialS =
        "\52\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\11\1\12"+
        "\1\13\1\14\1\15\1\16\1\17\2\uffff\1\20\1\21\1\22\1\23\1\24\1\25"+
        "\1\26\1\27\1\30\2\uffff\1\31\1\32\1\33\1\34\1\35\3\uffff\1\36\1"+
        "\37\1\40\1\41\1\42\1\uffff\1\43\1\44\1\45\1\46\1\47\2\uffff\1\50"+
        "\1\51\1\52\2\uffff\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63"+
        "\1\64\1\65\1\66\1\67\2\uffff\1\70\1\71\1\72\1\73\1\74\1\75\1\76"+
        "\1\77\1\100\1\101\1\102\1\103\1\104\1\105\1\106\1\107\1\110\1\111"+
        "\1\112\1\113\1\114\1\115\1\116\2\uffff\1\117\1\120\1\121\1\122\1"+
        "\123\2\uffff\1\124\1\125\1\126\1\127\1\130\1\131\2\uffff\1\132\1"+
        "\133\1\134\1\135\1\136\2\uffff\1\137\10\uffff\1\140\1\141\1\142"+
        "\1\143\1\144\1\uffff\1\145\1\146\1\147\1\150\1\151\2\uffff\1\152"+
        "\1\153\1\154\2\uffff\1\155\10\uffff\1\156\1\157\1\160\1\161\1\162"+
        "\1\uffff\1\163\1\164\1\165\1\166\1\167\2\uffff\1\170\1\171\1\172"+
        "\2\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\1\27\uffff\1\3\16\uffff\3\2\13\uffff\4\4\2\5\11\6",
            "\1\11\25\uffff\1\21\1\uffff\1\10\3\uffff\1\20\1\uffff\1\22"+
            "\10\uffff\3\7\3\uffff\1\15\1\16\1\17\3\uffff\1\23\1\uffff\4"+
            "\12\2\13\11\14",
            "\1\24\20\uffff\1\25",
            "\1\26\20\uffff\1\27",
            "\2\30\11\31",
            "\1\34\25\uffff\1\21\5\uffff\1\40\20\uffff\1\35\1\36\1\37\3"+
            "\uffff\1\23\5\uffff\2\32\11\33",
            "\1\43\25\uffff\1\21\5\uffff\1\47\20\uffff\1\44\1\45\1\46\3"+
            "\uffff\1\23",
            "\1\52\20\uffff\1\53",
            "\1\54\20\uffff\1\55",
            "\1\57\24\uffff\1\23\1\72\1\23\1\71\3\uffff\1\62\1\uffff\1\64"+
            "\10\uffff\3\70\3\uffff\1\56\1\60\1\61\3\uffff\1\23\1\uffff\4"+
            "\65\2\66\11\67",
            "\2\75\11\76",
            "\1\101\25\uffff\1\21\5\uffff\1\105\20\uffff\1\102\1\103\1\104"+
            "\3\uffff\1\23\5\uffff\2\77\11\100",
            "\1\110\25\uffff\1\21\5\uffff\1\114\20\uffff\1\111\1\112\1\113"+
            "\3\uffff\1\23",
            "\1\120\25\uffff\1\21\5\uffff\1\124\20\uffff\1\121\1\122\1\123"+
            "\3\uffff\1\23",
            "\1\127\25\uffff\1\21\5\uffff\1\126\20\uffff\1\130\1\131\1\132"+
            "\3\uffff\1\23",
            "\1\135",
            "\1\136\33\uffff\1\23\20\uffff\1\137\1\23\4\uffff\1\23",
            "",
            "\1\144\27\uffff\1\143\6\uffff\1\150\7\uffff\3\142\13\uffff"+
            "\4\145\2\146\11\147",
            "",
            "\1\151\20\uffff\1\155\4\uffff\1\154\5\uffff\1\153\20\uffff"+
            "\1\152\1\156\1\21\3\uffff\1\23",
            "\1\166\21\uffff\1\176\1\175\1\174\3\uffff\1\165\2\172\14\uffff"+
            "\3\164\1\161\1\162\1\163\7\uffff\1\173\4\167\2\170\11\171",
            "\1\177",
            "\1\u0080",
            "\1\u0083\25\uffff\1\21\5\uffff\1\u0087\20\uffff\1\u0084\1\u0085"+
            "\1\u0086\3\uffff\1\23\5\uffff\2\u0081\11\u0082",
            "\1\u008a\25\uffff\1\21\5\uffff\1\u008e\20\uffff\1\u008b\1\u008c"+
            "\1\u008d\3\uffff\1\23",
            "\1\u0092\25\uffff\1\21\5\uffff\1\u0096\20\uffff\1\u0093\1\u0094"+
            "\1\u0095\3\uffff\1\23\5\uffff\13\u0091",
            "\1\u0099\25\uffff\1\21\5\uffff\1\u009d\20\uffff\1\u009a\1\u009b"+
            "\1\u009c\3\uffff\1\23",
            "\1\23\24\uffff\3\23\4\uffff\1\23\20\uffff\1\u00a0\2\23\3\uffff"+
            "\1\23",
            "\1\u00a9\25\uffff\1\21\5\uffff\1\u00ad\20\uffff\1\u00aa\1\u00ab"+
            "\1\u00ac\3\uffff\1\23",
            "\1\u00b0\25\uffff\1\21\5\uffff\1\u00af\20\uffff\1\u00b1\1\u00b2"+
            "\1\u00b3\3\uffff\1\23",
            "\1\u00b6",
            "\1\u00b7\33\uffff\1\23\20\uffff\1\u00b8\1\23\4\uffff\1\23",
            "",
            "",
            "\1\23\24\uffff\3\23\4\uffff\1\23\20\uffff\1\u00bb\2\23\3\uffff"+
            "\1\23",
            "\1\u00c4\25\uffff\1\21\5\uffff\1\u00c8\20\uffff\1\u00c5\1\u00c6"+
            "\1\u00c7\3\uffff\1\23",
            "\1\u00cb\25\uffff\1\21\5\uffff\1\u00ca\20\uffff\1\u00cc\1\u00cd"+
            "\1\u00ce\3\uffff\1\23",
            "\1\u00d1",
            "\1\u00d2\33\uffff\1\23\20\uffff\1\u00d3\1\23\4\uffff\1\23",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
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
            "\1\uffff",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "378:6: (fv= varDecl | functionPointerVarDecl )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA17_42 = input.LA(1);

                         
                        int index17_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 17;}

                         
                        input.seek(index17_42);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_43 = input.LA(1);

                         
                        int index17_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 17;}

                         
                        input.seek(index17_43);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA17_44 = input.LA(1);

                         
                        int index17_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 17;}

                         
                        input.seek(index17_44);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA17_45 = input.LA(1);

                         
                        int index17_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 17;}

                         
                        input.seek(index17_45);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA17_46 = input.LA(1);

                         
                        int index17_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 17;}

                         
                        input.seek(index17_46);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA17_47 = input.LA(1);

                         
                        int index17_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_47);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA17_48 = input.LA(1);

                         
                        int index17_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_48);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA17_49 = input.LA(1);

                         
                        int index17_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_49);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA17_50 = input.LA(1);

                         
                        int index17_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_50);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA17_52 = input.LA(1);

                         
                        int index17_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_52);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA17_53 = input.LA(1);

                         
                        int index17_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_53);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA17_54 = input.LA(1);

                         
                        int index17_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_54);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA17_55 = input.LA(1);

                         
                        int index17_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_55);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA17_56 = input.LA(1);

                         
                        int index17_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_56);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA17_57 = input.LA(1);

                         
                        int index17_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_57);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA17_58 = input.LA(1);

                         
                        int index17_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_58);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA17_61 = input.LA(1);

                         
                        int index17_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_61);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA17_62 = input.LA(1);

                         
                        int index17_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_62);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA17_63 = input.LA(1);

                         
                        int index17_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_63);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA17_64 = input.LA(1);

                         
                        int index17_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_64);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA17_65 = input.LA(1);

                         
                        int index17_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_65);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA17_66 = input.LA(1);

                         
                        int index17_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_66);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA17_67 = input.LA(1);

                         
                        int index17_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_67);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA17_68 = input.LA(1);

                         
                        int index17_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_68);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA17_69 = input.LA(1);

                         
                        int index17_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_69);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA17_72 = input.LA(1);

                         
                        int index17_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_72);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA17_73 = input.LA(1);

                         
                        int index17_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_73);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA17_74 = input.LA(1);

                         
                        int index17_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_74);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA17_75 = input.LA(1);

                         
                        int index17_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_75);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA17_76 = input.LA(1);

                         
                        int index17_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_76);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA17_80 = input.LA(1);

                         
                        int index17_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_80);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA17_81 = input.LA(1);

                         
                        int index17_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_81);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA17_82 = input.LA(1);

                         
                        int index17_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_82);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA17_83 = input.LA(1);

                         
                        int index17_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_83);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA17_84 = input.LA(1);

                         
                        int index17_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_84);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA17_86 = input.LA(1);

                         
                        int index17_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_86);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA17_87 = input.LA(1);

                         
                        int index17_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_87);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA17_88 = input.LA(1);

                         
                        int index17_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_88);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA17_89 = input.LA(1);

                         
                        int index17_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_89);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA17_90 = input.LA(1);

                         
                        int index17_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_90);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA17_93 = input.LA(1);

                         
                        int index17_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_93);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA17_94 = input.LA(1);

                         
                        int index17_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_94);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA17_95 = input.LA(1);

                         
                        int index17_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_95);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA17_98 = input.LA(1);

                         
                        int index17_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_98);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA17_99 = input.LA(1);

                         
                        int index17_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_99);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA17_100 = input.LA(1);

                         
                        int index17_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_100);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA17_101 = input.LA(1);

                         
                        int index17_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_101);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA17_102 = input.LA(1);

                         
                        int index17_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_102);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA17_103 = input.LA(1);

                         
                        int index17_103 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_103);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA17_104 = input.LA(1);

                         
                        int index17_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_104);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA17_105 = input.LA(1);

                         
                        int index17_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_105);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA17_106 = input.LA(1);

                         
                        int index17_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_106);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA17_107 = input.LA(1);

                         
                        int index17_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_107);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA17_108 = input.LA(1);

                         
                        int index17_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_108);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA17_109 = input.LA(1);

                         
                        int index17_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_109);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA17_110 = input.LA(1);

                         
                        int index17_110 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_110);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA17_113 = input.LA(1);

                         
                        int index17_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_113);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA17_114 = input.LA(1);

                         
                        int index17_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_114);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA17_115 = input.LA(1);

                         
                        int index17_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_115);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA17_116 = input.LA(1);

                         
                        int index17_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_116);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA17_117 = input.LA(1);

                         
                        int index17_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_117);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA17_118 = input.LA(1);

                         
                        int index17_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_118);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA17_119 = input.LA(1);

                         
                        int index17_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_119);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA17_120 = input.LA(1);

                         
                        int index17_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_120);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA17_121 = input.LA(1);

                         
                        int index17_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_121);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA17_122 = input.LA(1);

                         
                        int index17_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_122);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA17_123 = input.LA(1);

                         
                        int index17_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_123);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA17_124 = input.LA(1);

                         
                        int index17_124 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_124);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA17_125 = input.LA(1);

                         
                        int index17_125 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_125);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA17_126 = input.LA(1);

                         
                        int index17_126 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_126);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA17_127 = input.LA(1);

                         
                        int index17_127 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_127);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA17_128 = input.LA(1);

                         
                        int index17_128 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_128);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA17_129 = input.LA(1);

                         
                        int index17_129 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_129);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA17_130 = input.LA(1);

                         
                        int index17_130 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_130);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA17_131 = input.LA(1);

                         
                        int index17_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_131);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA17_132 = input.LA(1);

                         
                        int index17_132 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_132);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA17_133 = input.LA(1);

                         
                        int index17_133 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_133);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA17_134 = input.LA(1);

                         
                        int index17_134 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_134);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA17_135 = input.LA(1);

                         
                        int index17_135 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_135);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA17_138 = input.LA(1);

                         
                        int index17_138 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_138);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA17_139 = input.LA(1);

                         
                        int index17_139 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_139);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA17_140 = input.LA(1);

                         
                        int index17_140 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_140);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA17_141 = input.LA(1);

                         
                        int index17_141 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_141);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA17_142 = input.LA(1);

                         
                        int index17_142 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_142);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA17_145 = input.LA(1);

                         
                        int index17_145 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_145);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA17_146 = input.LA(1);

                         
                        int index17_146 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_146);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA17_147 = input.LA(1);

                         
                        int index17_147 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_147);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA17_148 = input.LA(1);

                         
                        int index17_148 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_148);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA17_149 = input.LA(1);

                         
                        int index17_149 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_149);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA17_150 = input.LA(1);

                         
                        int index17_150 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_150);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA17_153 = input.LA(1);

                         
                        int index17_153 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_153);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA17_154 = input.LA(1);

                         
                        int index17_154 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_154);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA17_155 = input.LA(1);

                         
                        int index17_155 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_155);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA17_156 = input.LA(1);

                         
                        int index17_156 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_156);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA17_157 = input.LA(1);

                         
                        int index17_157 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_157);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA17_160 = input.LA(1);

                         
                        int index17_160 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_160);
                        if ( s>=0 ) return s;
                        break;
                    case 96 : 
                        int LA17_169 = input.LA(1);

                         
                        int index17_169 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_169);
                        if ( s>=0 ) return s;
                        break;
                    case 97 : 
                        int LA17_170 = input.LA(1);

                         
                        int index17_170 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_170);
                        if ( s>=0 ) return s;
                        break;
                    case 98 : 
                        int LA17_171 = input.LA(1);

                         
                        int index17_171 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_171);
                        if ( s>=0 ) return s;
                        break;
                    case 99 : 
                        int LA17_172 = input.LA(1);

                         
                        int index17_172 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_172);
                        if ( s>=0 ) return s;
                        break;
                    case 100 : 
                        int LA17_173 = input.LA(1);

                         
                        int index17_173 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_173);
                        if ( s>=0 ) return s;
                        break;
                    case 101 : 
                        int LA17_175 = input.LA(1);

                         
                        int index17_175 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_175);
                        if ( s>=0 ) return s;
                        break;
                    case 102 : 
                        int LA17_176 = input.LA(1);

                         
                        int index17_176 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_176);
                        if ( s>=0 ) return s;
                        break;
                    case 103 : 
                        int LA17_177 = input.LA(1);

                         
                        int index17_177 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_177);
                        if ( s>=0 ) return s;
                        break;
                    case 104 : 
                        int LA17_178 = input.LA(1);

                         
                        int index17_178 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_178);
                        if ( s>=0 ) return s;
                        break;
                    case 105 : 
                        int LA17_179 = input.LA(1);

                         
                        int index17_179 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_179);
                        if ( s>=0 ) return s;
                        break;
                    case 106 : 
                        int LA17_182 = input.LA(1);

                         
                        int index17_182 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_182);
                        if ( s>=0 ) return s;
                        break;
                    case 107 : 
                        int LA17_183 = input.LA(1);

                         
                        int index17_183 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_183);
                        if ( s>=0 ) return s;
                        break;
                    case 108 : 
                        int LA17_184 = input.LA(1);

                         
                        int index17_184 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_184);
                        if ( s>=0 ) return s;
                        break;
                    case 109 : 
                        int LA17_187 = input.LA(1);

                         
                        int index17_187 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_187);
                        if ( s>=0 ) return s;
                        break;
                    case 110 : 
                        int LA17_196 = input.LA(1);

                         
                        int index17_196 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_196);
                        if ( s>=0 ) return s;
                        break;
                    case 111 : 
                        int LA17_197 = input.LA(1);

                         
                        int index17_197 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_197);
                        if ( s>=0 ) return s;
                        break;
                    case 112 : 
                        int LA17_198 = input.LA(1);

                         
                        int index17_198 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_198);
                        if ( s>=0 ) return s;
                        break;
                    case 113 : 
                        int LA17_199 = input.LA(1);

                         
                        int index17_199 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_199);
                        if ( s>=0 ) return s;
                        break;
                    case 114 : 
                        int LA17_200 = input.LA(1);

                         
                        int index17_200 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_200);
                        if ( s>=0 ) return s;
                        break;
                    case 115 : 
                        int LA17_202 = input.LA(1);

                         
                        int index17_202 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_202);
                        if ( s>=0 ) return s;
                        break;
                    case 116 : 
                        int LA17_203 = input.LA(1);

                         
                        int index17_203 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_203);
                        if ( s>=0 ) return s;
                        break;
                    case 117 : 
                        int LA17_204 = input.LA(1);

                         
                        int index17_204 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_204);
                        if ( s>=0 ) return s;
                        break;
                    case 118 : 
                        int LA17_205 = input.LA(1);

                         
                        int index17_205 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_205);
                        if ( s>=0 ) return s;
                        break;
                    case 119 : 
                        int LA17_206 = input.LA(1);

                         
                        int index17_206 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_206);
                        if ( s>=0 ) return s;
                        break;
                    case 120 : 
                        int LA17_209 = input.LA(1);

                         
                        int index17_209 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_209);
                        if ( s>=0 ) return s;
                        break;
                    case 121 : 
                        int LA17_210 = input.LA(1);

                         
                        int index17_210 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_210);
                        if ( s>=0 ) return s;
                        break;
                    case 122 : 
                        int LA17_211 = input.LA(1);

                         
                        int index17_211 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_211);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 17, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA20_eotS =
        "\13\uffff";
    static final String DFA20_eofS =
        "\13\uffff";
    static final String DFA20_minS =
        "\1\6\12\uffff";
    static final String DFA20_maxS =
        "\1\111\12\uffff";
    static final String DFA20_acceptS =
        "\1\uffff\1\4\1\1\1\uffff\1\2\1\3\5\uffff";
    static final String DFA20_specialS =
        "\13\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\5\27\uffff\1\5\12\uffff\1\1\2\2\1\uffff\3\5\12\uffff\1\4"+
            "\17\5",
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
            return "()* loopback of 391:3: ( objCMethodDecl | typeDef | vd= varDecl {...}?)*";
        }
    }
    static final String DFA31_eotS =
        "\40\uffff";
    static final String DFA31_eofS =
        "\1\uffff\1\5\4\uffff\1\5\31\uffff";
    static final String DFA31_minS =
        "\2\6\1\uffff\1\6\2\uffff\1\6\11\uffff\1\0\5\uffff\1\0\3\uffff\1"+
        "\0\5\uffff";
    static final String DFA31_maxS =
        "\1\27\1\71\1\uffff\1\71\2\uffff\1\71\11\uffff\1\0\5\uffff\1\0\3"+
        "\uffff\1\0\5\uffff";
    static final String DFA31_acceptS =
        "\2\uffff\1\2\2\uffff\1\1\32\uffff";
    static final String DFA31_specialS =
        "\20\uffff\1\0\5\uffff\1\1\3\uffff\1\2\5\uffff}>";
    static final String[] DFA31_transitionS = {
            "\1\1\20\uffff\1\2",
            "\1\6\20\uffff\1\2\3\uffff\3\5\4\uffff\1\3\1\5\1\uffff\1\5\15"+
            "\uffff\3\5\3\uffff\1\5",
            "",
            "\1\20\33\uffff\1\5\1\2\17\uffff\2\5\4\uffff\1\5",
            "",
            "",
            "\1\26\20\uffff\1\2\3\uffff\3\5\4\uffff\1\32\1\5\17\uffff\3"+
            "\5\3\uffff\1\5",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA31_eot = DFA.unpackEncodedString(DFA31_eotS);
    static final short[] DFA31_eof = DFA.unpackEncodedString(DFA31_eofS);
    static final char[] DFA31_min = DFA.unpackEncodedStringToUnsignedChars(DFA31_minS);
    static final char[] DFA31_max = DFA.unpackEncodedStringToUnsignedChars(DFA31_maxS);
    static final short[] DFA31_accept = DFA.unpackEncodedString(DFA31_acceptS);
    static final short[] DFA31_special = DFA.unpackEncodedString(DFA31_specialS);
    static final short[][] DFA31_transition;

    static {
        int numStates = DFA31_transitionS.length;
        DFA31_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA31_transition[i] = DFA.unpackEncodedString(DFA31_transitionS[i]);
        }
    }

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = DFA31_eot;
            this.eof = DFA31_eof;
            this.min = DFA31_min;
            this.max = DFA31_max;
            this.accept = DFA31_accept;
            this.special = DFA31_special;
            this.transition = DFA31_transition;
        }
        public String getDescription() {
            return "481:3: ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA31_16 = input.LA(1);

                         
                        int index31_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred40_ObjCpp()) ) {s = 5;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index31_16);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA31_22 = input.LA(1);

                         
                        int index31_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred40_ObjCpp()) ) {s = 5;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index31_22);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA31_26 = input.LA(1);

                         
                        int index31_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred40_ObjCpp()) ) {s = 5;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index31_26);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 31, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA30_eotS =
        "\17\uffff";
    static final String DFA30_eofS =
        "\17\uffff";
    static final String DFA30_minS =
        "\1\6\16\uffff";
    static final String DFA30_maxS =
        "\1\111\16\uffff";
    static final String DFA30_acceptS =
        "\1\uffff\1\3\1\1\2\uffff\1\2\11\uffff";
    static final String DFA30_specialS =
        "\17\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\5\21\uffff\1\1\2\5\3\uffff\3\5\14\uffff\3\5\3\2\7\uffff\20"+
            "\5",
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

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "()* loopback of 496:5: ( ( 'public' | 'private' | 'protected' ) ':' | declaration )*";
        }
    }
    static final String DFA32_eotS =
        "\23\uffff";
    static final String DFA32_eofS =
        "\23\uffff";
    static final String DFA32_minS =
        "\1\6\2\uffff\1\0\17\uffff";
    static final String DFA32_maxS =
        "\1\111\2\uffff\1\0\17\uffff";
    static final String DFA32_acceptS =
        "\1\uffff\1\1\20\uffff\1\2";
    static final String DFA32_specialS =
        "\3\uffff\1\0\17\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\3\27\uffff\1\1\16\uffff\3\1\13\uffff\17\1",
            "",
            "",
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
            ""
    };

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "519:16: (returnTypeRef= typeRef )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_3 = input.LA(1);

                         
                        int index32_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred47_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred47_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred47_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 1;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index32_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 32, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA35_eotS =
        "\64\uffff";
    static final String DFA35_eofS =
        "\1\2\1\12\62\uffff";
    static final String DFA35_minS =
        "\2\6\6\uffff\1\4\2\uffff\1\6\3\uffff\13\0\22\uffff\2\0\6\uffff";
    static final String DFA35_maxS =
        "\2\63\6\uffff\1\141\2\uffff\1\111\3\uffff\13\0\22\uffff\2\0\6\uffff";
    static final String DFA35_acceptS =
        "\2\uffff\1\2\3\uffff\1\1\3\uffff\1\1\51\uffff";
    static final String DFA35_specialS =
        "\17\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\22\uffff"+
        "\1\13\1\14\6\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\1\20\uffff\1\2\4\uffff\1\2\26\uffff\1\2",
            "\1\6\20\uffff\1\10\4\uffff\1\6\5\uffff\1\13\20\uffff\1\6",
            "",
            "",
            "",
            "",
            "",
            "",
            "\2\6\1\21\4\6\14\uffff\1\6\1\31\1\30\1\27\1\uffff\1\6\1\uffff"+
            "\1\20\2\25\1\uffff\1\6\12\uffff\3\17\3\2\2\uffff\1\6\4\uffff"+
            "\1\26\4\22\2\23\11\24\3\6\16\uffff\2\6\1\uffff\4\6",
            "",
            "",
            "\1\54\27\uffff\1\2\4\uffff\1\55\10\uffff\4\2\13\uffff\17\2",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA35_eot = DFA.unpackEncodedString(DFA35_eotS);
    static final short[] DFA35_eof = DFA.unpackEncodedString(DFA35_eofS);
    static final char[] DFA35_min = DFA.unpackEncodedStringToUnsignedChars(DFA35_minS);
    static final char[] DFA35_max = DFA.unpackEncodedStringToUnsignedChars(DFA35_maxS);
    static final short[] DFA35_accept = DFA.unpackEncodedString(DFA35_acceptS);
    static final short[] DFA35_special = DFA.unpackEncodedString(DFA35_specialS);
    static final short[][] DFA35_transition;

    static {
        int numStates = DFA35_transitionS.length;
        DFA35_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA35_transition[i] = DFA.unpackEncodedString(DFA35_transitionS[i]);
        }
    }

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = DFA35_eot;
            this.eof = DFA35_eof;
            this.min = DFA35_min;
            this.max = DFA35_max;
            this.accept = DFA35_accept;
            this.special = DFA35_special;
            this.transition = DFA35_transition;
        }
        public String getDescription() {
            return "()* loopback of 557:3: ( exportationModifier )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA35_15 = input.LA(1);

                         
                        int index35_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 10;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_15);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA35_16 = input.LA(1);

                         
                        int index35_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 10;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_16);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA35_17 = input.LA(1);

                         
                        int index35_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 10;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_17);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA35_18 = input.LA(1);

                         
                        int index35_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 10;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_18);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA35_19 = input.LA(1);

                         
                        int index35_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 10;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_19);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA35_20 = input.LA(1);

                         
                        int index35_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 10;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_20);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA35_21 = input.LA(1);

                         
                        int index35_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 10;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_21);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA35_22 = input.LA(1);

                         
                        int index35_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 10;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_22);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA35_23 = input.LA(1);

                         
                        int index35_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 10;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_23);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA35_24 = input.LA(1);

                         
                        int index35_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 10;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_24);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA35_25 = input.LA(1);

                         
                        int index35_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 10;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_25);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA35_44 = input.LA(1);

                         
                        int index35_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 10;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_44);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA35_45 = input.LA(1);

                         
                        int index35_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 10;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_45);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 35, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA43_eotS =
        "\30\uffff";
    static final String DFA43_eofS =
        "\30\uffff";
    static final String DFA43_minS =
        "\1\6\1\0\26\uffff";
    static final String DFA43_maxS =
        "\1\111\1\0\26\uffff";
    static final String DFA43_acceptS =
        "\2\uffff\1\2\24\uffff\1\1";
    static final String DFA43_specialS =
        "\1\uffff\1\0\26\uffff}>";
    static final String[] DFA43_transitionS = {
            "\1\1\64\uffff\17\2",
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
            ""
    };

    static final short[] DFA43_eot = DFA.unpackEncodedString(DFA43_eotS);
    static final short[] DFA43_eof = DFA.unpackEncodedString(DFA43_eofS);
    static final char[] DFA43_min = DFA.unpackEncodedStringToUnsignedChars(DFA43_minS);
    static final char[] DFA43_max = DFA.unpackEncodedStringToUnsignedChars(DFA43_maxS);
    static final short[] DFA43_accept = DFA.unpackEncodedString(DFA43_acceptS);
    static final short[] DFA43_special = DFA.unpackEncodedString(DFA43_specialS);
    static final short[][] DFA43_transition;

    static {
        int numStates = DFA43_transitionS.length;
        DFA43_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA43_transition[i] = DFA.unpackEncodedString(DFA43_transitionS[i]);
        }
    }

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = DFA43_eot;
            this.eof = DFA43_eof;
            this.min = DFA43_min;
            this.max = DFA43_max;
            this.accept = DFA43_accept;
            this.special = DFA43_special;
            this.transition = DFA43_transition;
        }
        public String getDescription() {
            return "653:4: ({...}?m= modifier )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA43_1 = input.LA(1);

                         
                        int index43_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred60_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 23;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 2;}

                         
                        input.seek(index43_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 43, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA48_eotS =
        "\51\uffff";
    static final String DFA48_eofS =
        "\1\uffff\1\2\47\uffff";
    static final String DFA48_minS =
        "\2\6\3\uffff\1\0\43\uffff";
    static final String DFA48_maxS =
        "\2\111\3\uffff\1\0\43\uffff";
    static final String DFA48_acceptS =
        "\2\uffff\1\2\17\uffff\1\1\26\uffff";
    static final String DFA48_specialS =
        "\5\uffff\1\0\43\uffff}>";
    static final String[] DFA48_transitionS = {
            "\1\1\64\uffff\17\2",
            "\1\5\24\uffff\3\2\1\22\3\uffff\4\2\7\uffff\3\22\3\uffff\3\2"+
            "\3\uffff\1\2\1\uffff\17\22",
            "",
            "",
            "",
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

    static final short[] DFA48_eot = DFA.unpackEncodedString(DFA48_eotS);
    static final short[] DFA48_eof = DFA.unpackEncodedString(DFA48_eofS);
    static final char[] DFA48_min = DFA.unpackEncodedStringToUnsignedChars(DFA48_minS);
    static final char[] DFA48_max = DFA.unpackEncodedStringToUnsignedChars(DFA48_maxS);
    static final short[] DFA48_accept = DFA.unpackEncodedString(DFA48_acceptS);
    static final short[] DFA48_special = DFA.unpackEncodedString(DFA48_specialS);
    static final short[][] DFA48_transition;

    static {
        int numStates = DFA48_transitionS.length;
        DFA48_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA48_transition[i] = DFA.unpackEncodedString(DFA48_transitionS[i]);
        }
    }

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = DFA48_eot;
            this.eof = DFA48_eof;
            this.min = DFA48_min;
            this.max = DFA48_max;
            this.accept = DFA48_accept;
            this.special = DFA48_special;
            this.transition = DFA48_transition;
        }
        public String getDescription() {
            return "654:3: ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA48_5 = input.LA(1);

                         
                        int index48_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred61_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 18;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 2;}

                         
                        input.seek(index48_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 48, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA46_eotS =
        "\16\uffff";
    static final String DFA46_eofS =
        "\1\1\15\uffff";
    static final String DFA46_minS =
        "\1\6\15\uffff";
    static final String DFA46_maxS =
        "\1\71\15\uffff";
    static final String DFA46_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA46_specialS =
        "\16\uffff}>";
    static final String[] DFA46_transitionS = {
            "\1\1\24\uffff\3\1\4\uffff\2\1\1\15\1\1\15\uffff\3\1\3\uffff"+
            "\1\1",
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

    static final short[] DFA46_eot = DFA.unpackEncodedString(DFA46_eotS);
    static final short[] DFA46_eof = DFA.unpackEncodedString(DFA46_eofS);
    static final char[] DFA46_min = DFA.unpackEncodedStringToUnsignedChars(DFA46_minS);
    static final char[] DFA46_max = DFA.unpackEncodedStringToUnsignedChars(DFA46_maxS);
    static final short[] DFA46_accept = DFA.unpackEncodedString(DFA46_acceptS);
    static final short[] DFA46_special = DFA.unpackEncodedString(DFA46_specialS);
    static final short[][] DFA46_transition;

    static {
        int numStates = DFA46_transitionS.length;
        DFA46_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA46_transition[i] = DFA.unpackEncodedString(DFA46_transitionS[i]);
        }
    }

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = DFA46_eot;
            this.eof = DFA46_eof;
            this.min = DFA46_min;
            this.max = DFA46_max;
            this.accept = DFA46_accept;
            this.special = DFA46_special;
            this.transition = DFA46_transition;
        }
        public String getDescription() {
            return "660:64: ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' )";
        }
    }
    static final String DFA60_eotS =
        "\65\uffff";
    static final String DFA60_eofS =
        "\1\6\64\uffff";
    static final String DFA60_minS =
        "\1\6\5\0\57\uffff";
    static final String DFA60_maxS =
        "\1\71\5\0\57\uffff";
    static final String DFA60_acceptS =
        "\6\uffff\1\2\20\uffff\1\1\35\uffff";
    static final String DFA60_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\57\uffff}>";
    static final String[] DFA60_transitionS = {
            "\1\1\24\uffff\3\6\4\uffff\1\5\1\6\1\uffff\1\6\15\uffff\1\2\1"+
            "\3\1\4\3\uffff\1\6",
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
            return "736:3: ( ( typeMutator )* functionSignatureSuffix )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA60_1 = input.LA(1);

                         
                        int index60_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred78_ObjCpp()&&( next("const", "__const") ))) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index60_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA60_2 = input.LA(1);

                         
                        int index60_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index60_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA60_3 = input.LA(1);

                         
                        int index60_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index60_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA60_4 = input.LA(1);

                         
                        int index60_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index60_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA60_5 = input.LA(1);

                         
                        int index60_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index60_5);
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
    static final String DFA62_eotS =
        "\140\uffff";
    static final String DFA62_eofS =
        "\140\uffff";
    static final String DFA62_minS =
        "\4\6\1\uffff\1\6\1\uffff\1\6\7\uffff\4\6\2\uffff\4\6\2\uffff\2\6"+
        "\2\uffff\4\0\2\uffff\1\0\7\uffff\4\0\2\uffff\2\0\2\uffff\4\0\2\uffff"+
        "\2\0\2\uffff\1\0\7\uffff\4\0\2\uffff\4\0\2\uffff\3\0\10\uffff";
    static final String DFA62_maxS =
        "\4\71\1\uffff\1\71\1\uffff\1\71\7\uffff\4\71\2\uffff\4\71\2\uffff"+
        "\2\71\2\uffff\4\0\2\uffff\1\0\7\uffff\4\0\2\uffff\2\0\2\uffff\4"+
        "\0\2\uffff\2\0\2\uffff\1\0\7\uffff\4\0\2\uffff\4\0\2\uffff\3\0\10"+
        "\uffff";
    static final String DFA62_acceptS =
        "\4\uffff\1\1\1\uffff\1\2\131\uffff";
    static final String DFA62_specialS =
        "\37\uffff\1\0\1\1\1\2\1\3\2\uffff\1\4\7\uffff\1\5\1\6\1\7\1\10\2"+
        "\uffff\1\11\1\12\2\uffff\1\13\1\14\1\15\1\16\2\uffff\1\17\1\20\2"+
        "\uffff\1\21\7\uffff\1\22\1\23\1\24\1\25\2\uffff\1\26\1\27\1\30\1"+
        "\31\2\uffff\1\32\1\33\1\34\10\uffff}>";
    static final String[] DFA62_transitionS = {
            "\1\1\33\uffff\1\5\20\uffff\1\2\1\3\1\4\3\uffff\1\6",
            "\1\6\24\uffff\3\6\4\uffff\1\6\20\uffff\1\7\2\6\3\uffff\1\6",
            "\1\17\33\uffff\1\21\20\uffff\1\20\1\22\1\4\3\uffff\1\6",
            "\1\26\33\uffff\1\25\20\uffff\1\27\1\30\1\4\3\uffff\1\6",
            "",
            "\1\33\33\uffff\1\6\20\uffff\1\34\1\6\4\uffff\1\6",
            "",
            "\1\40\33\uffff\1\37\20\uffff\1\41\1\42\1\4\3\uffff\1\6",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\6\24\uffff\3\6\4\uffff\1\6\20\uffff\1\45\2\6\3\uffff\1\6",
            "\1\55\33\uffff\1\57\20\uffff\1\56\1\60\1\4\3\uffff\1\6",
            "\1\63\33\uffff\1\6\20\uffff\1\64\1\6\4\uffff\1\6",
            "\1\70\33\uffff\1\67\20\uffff\1\71\1\72\1\4\3\uffff\1\6",
            "",
            "",
            "\1\75\33\uffff\1\6\20\uffff\1\76\1\6\4\uffff\1\6",
            "\1\6\24\uffff\3\6\4\uffff\1\6\20\uffff\1\101\2\6\3\uffff\1"+
            "\6",
            "\1\111\33\uffff\1\113\20\uffff\1\112\1\114\1\4\3\uffff\1\6",
            "\1\120\33\uffff\1\117\20\uffff\1\121\1\122\1\4\3\uffff\1\6",
            "",
            "",
            "\1\126\26\uffff\1\6\4\uffff\1\127\1\6\17\uffff\1\125\2\6\3"+
            "\uffff\1\6",
            "\1\6\33\uffff\1\6\1\4\17\uffff\2\6\4\uffff\1\6",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
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

    static final short[] DFA62_eot = DFA.unpackEncodedString(DFA62_eotS);
    static final short[] DFA62_eof = DFA.unpackEncodedString(DFA62_eofS);
    static final char[] DFA62_min = DFA.unpackEncodedStringToUnsignedChars(DFA62_minS);
    static final char[] DFA62_max = DFA.unpackEncodedStringToUnsignedChars(DFA62_maxS);
    static final short[] DFA62_accept = DFA.unpackEncodedString(DFA62_acceptS);
    static final short[] DFA62_special = DFA.unpackEncodedString(DFA62_specialS);
    static final short[][] DFA62_transition;

    static {
        int numStates = DFA62_transitionS.length;
        DFA62_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA62_transition[i] = DFA.unpackEncodedString(DFA62_transitionS[i]);
        }
    }

    class DFA62 extends DFA {

        public DFA62(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 62;
            this.eot = DFA62_eot;
            this.eof = DFA62_eof;
            this.min = DFA62_min;
            this.max = DFA62_max;
            this.accept = DFA62_accept;
            this.special = DFA62_special;
            this.transition = DFA62_transition;
        }
        public String getDescription() {
            return "751:3: ( ( typeMutator )* functionSignatureSuffixNoName )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA62_31 = input.LA(1);

                         
                        int index62_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred80_ObjCpp()&&( next("const", "__const") ))) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_31);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA62_32 = input.LA(1);

                         
                        int index62_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred80_ObjCpp()&&( next("const", "__const") ))) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_32);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA62_33 = input.LA(1);

                         
                        int index62_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred80_ObjCpp()&&( next("const", "__const") ))) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_33);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA62_34 = input.LA(1);

                         
                        int index62_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred80_ObjCpp()&&( next("const", "__const") ))) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_34);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA62_37 = input.LA(1);

                         
                        int index62_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_37);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA62_45 = input.LA(1);

                         
                        int index62_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_45);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA62_46 = input.LA(1);

                         
                        int index62_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_46);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA62_47 = input.LA(1);

                         
                        int index62_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_47);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA62_48 = input.LA(1);

                         
                        int index62_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_48);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA62_51 = input.LA(1);

                         
                        int index62_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_51);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA62_52 = input.LA(1);

                         
                        int index62_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_52);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA62_55 = input.LA(1);

                         
                        int index62_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_55);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA62_56 = input.LA(1);

                         
                        int index62_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_56);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA62_57 = input.LA(1);

                         
                        int index62_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_57);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA62_58 = input.LA(1);

                         
                        int index62_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_58);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA62_61 = input.LA(1);

                         
                        int index62_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_61);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA62_62 = input.LA(1);

                         
                        int index62_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_62);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA62_65 = input.LA(1);

                         
                        int index62_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_65);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA62_73 = input.LA(1);

                         
                        int index62_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_73);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA62_74 = input.LA(1);

                         
                        int index62_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_74);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA62_75 = input.LA(1);

                         
                        int index62_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_75);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA62_76 = input.LA(1);

                         
                        int index62_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_76);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA62_79 = input.LA(1);

                         
                        int index62_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_79);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA62_80 = input.LA(1);

                         
                        int index62_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_80);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA62_81 = input.LA(1);

                         
                        int index62_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_81);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA62_82 = input.LA(1);

                         
                        int index62_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_82);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA62_85 = input.LA(1);

                         
                        int index62_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_85);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA62_86 = input.LA(1);

                         
                        int index62_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_86);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA62_87 = input.LA(1);

                         
                        int index62_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_87);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 62, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA64_eotS =
        "\27\uffff";
    static final String DFA64_eofS =
        "\2\uffff\1\1\24\uffff";
    static final String DFA64_minS =
        "\1\6\1\uffff\1\6\2\uffff\1\6\11\uffff\1\0\7\uffff";
    static final String DFA64_maxS =
        "\1\71\1\uffff\1\71\2\uffff\1\111\11\uffff\1\0\7\uffff";
    static final String DFA64_acceptS =
        "\1\uffff\1\2\11\uffff\1\1\13\uffff";
    static final String DFA64_specialS =
        "\17\uffff\1\0\7\uffff}>";
    static final String[] DFA64_transitionS = {
            "\1\2\33\uffff\1\1\20\uffff\2\1\4\uffff\1\1",
            "",
            "\1\13\24\uffff\3\1\4\uffff\1\5\1\1\17\uffff\2\13\1\1\3\uffff"+
            "\1\13",
            "",
            "",
            "\1\17\27\uffff\1\1\3\uffff\1\13\1\1\10\uffff\4\1\3\uffff\2"+
            "\13\4\uffff\1\13\1\uffff\17\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA64_eot = DFA.unpackEncodedString(DFA64_eotS);
    static final short[] DFA64_eof = DFA.unpackEncodedString(DFA64_eofS);
    static final char[] DFA64_min = DFA.unpackEncodedStringToUnsignedChars(DFA64_minS);
    static final char[] DFA64_max = DFA.unpackEncodedStringToUnsignedChars(DFA64_maxS);
    static final short[] DFA64_accept = DFA.unpackEncodedString(DFA64_acceptS);
    static final short[] DFA64_special = DFA.unpackEncodedString(DFA64_specialS);
    static final short[][] DFA64_transition;

    static {
        int numStates = DFA64_transitionS.length;
        DFA64_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA64_transition[i] = DFA.unpackEncodedString(DFA64_transitionS[i]);
        }
    }

    class DFA64 extends DFA {

        public DFA64(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 64;
            this.eot = DFA64_eot;
            this.eof = DFA64_eof;
            this.min = DFA64_min;
            this.max = DFA64_max;
            this.accept = DFA64_accept;
            this.special = DFA64_special;
            this.transition = DFA64_transition;
        }
        public String getDescription() {
            return "()* loopback of 772:3: ({...}? modifier )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA64_15 = input.LA(1);

                         
                        int index64_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred82_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 64, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA66_eotS =
        "\23\uffff";
    static final String DFA66_eofS =
        "\1\2\22\uffff";
    static final String DFA66_minS =
        "\1\33\1\0\21\uffff";
    static final String DFA66_maxS =
        "\1\43\1\0\21\uffff";
    static final String DFA66_acceptS =
        "\2\uffff\1\2\17\uffff\1\1";
    static final String DFA66_specialS =
        "\1\uffff\1\0\21\uffff}>";
    static final String[] DFA66_transitionS = {
            "\2\2\1\1\5\uffff\1\2",
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
            ""
    };

    static final short[] DFA66_eot = DFA.unpackEncodedString(DFA66_eotS);
    static final short[] DFA66_eof = DFA.unpackEncodedString(DFA66_eofS);
    static final char[] DFA66_min = DFA.unpackEncodedStringToUnsignedChars(DFA66_minS);
    static final char[] DFA66_max = DFA.unpackEncodedStringToUnsignedChars(DFA66_maxS);
    static final short[] DFA66_accept = DFA.unpackEncodedString(DFA66_acceptS);
    static final short[] DFA66_special = DFA.unpackEncodedString(DFA66_specialS);
    static final short[][] DFA66_transition;

    static {
        int numStates = DFA66_transitionS.length;
        DFA66_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA66_transition[i] = DFA.unpackEncodedString(DFA66_transitionS[i]);
        }
    }

    class DFA66 extends DFA {

        public DFA66(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 66;
            this.eot = DFA66_eot;
            this.eof = DFA66_eof;
            this.min = DFA66_min;
            this.max = DFA66_max;
            this.accept = DFA66_accept;
            this.special = DFA66_special;
            this.transition = DFA66_transition;
        }
        public String getDescription() {
            return "792:4: ( '=' expression )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA66_1 = input.LA(1);

                         
                        int index66_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_ObjCpp()) ) {s = 18;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index66_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 66, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA68_eotS =
        "\25\uffff";
    static final String DFA68_eofS =
        "\25\uffff";
    static final String DFA68_minS =
        "\1\6\2\uffff\1\0\21\uffff";
    static final String DFA68_maxS =
        "\1\111\2\uffff\1\0\21\uffff";
    static final String DFA68_acceptS =
        "\1\uffff\1\3\21\uffff\1\1\1\2";
    static final String DFA68_specialS =
        "\3\uffff\1\0\21\uffff}>";
    static final String[] DFA68_transitionS = {
            "\1\3\27\uffff\1\1\16\uffff\3\1\13\uffff\17\1",
            "",
            "",
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
            ""
    };

    static final short[] DFA68_eot = DFA.unpackEncodedString(DFA68_eotS);
    static final short[] DFA68_eof = DFA.unpackEncodedString(DFA68_eofS);
    static final char[] DFA68_min = DFA.unpackEncodedStringToUnsignedChars(DFA68_minS);
    static final char[] DFA68_max = DFA.unpackEncodedStringToUnsignedChars(DFA68_maxS);
    static final short[] DFA68_accept = DFA.unpackEncodedString(DFA68_acceptS);
    static final short[] DFA68_special = DFA.unpackEncodedString(DFA68_specialS);
    static final short[][] DFA68_transition;

    static {
        int numStates = DFA68_transitionS.length;
        DFA68_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA68_transition[i] = DFA.unpackEncodedString(DFA68_transitionS[i]);
        }
    }

    class DFA68 extends DFA {

        public DFA68(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 68;
            this.eot = DFA68_eot;
            this.eof = DFA68_eof;
            this.min = DFA68_min;
            this.max = DFA68_max;
            this.accept = DFA68_accept;
            this.special = DFA68_special;
            this.transition = DFA68_transition;
        }
        public String getDescription() {
            return "()* loopback of 833:4: ({...}?sm= modifier | {...}?tm= modifier )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA68_3 = input.LA(1);

                         
                        int index68_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred88_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 19;}

                        else if ( (((synpred89_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 20;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 1;}

                         
                        input.seek(index68_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 68, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA73_eotS =
        "\13\uffff";
    static final String DFA73_eofS =
        "\13\uffff";
    static final String DFA73_minS =
        "\1\6\1\0\11\uffff";
    static final String DFA73_maxS =
        "\1\71\1\0\11\uffff";
    static final String DFA73_acceptS =
        "\2\uffff\1\2\7\uffff\1\1";
    static final String DFA73_specialS =
        "\1\uffff\1\0\11\uffff}>";
    static final String[] DFA73_transitionS = {
            "\1\1\33\uffff\1\2\20\uffff\2\2\4\uffff\1\2",
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

    static final short[] DFA73_eot = DFA.unpackEncodedString(DFA73_eotS);
    static final short[] DFA73_eof = DFA.unpackEncodedString(DFA73_eofS);
    static final char[] DFA73_min = DFA.unpackEncodedStringToUnsignedChars(DFA73_minS);
    static final char[] DFA73_max = DFA.unpackEncodedStringToUnsignedChars(DFA73_maxS);
    static final short[] DFA73_accept = DFA.unpackEncodedString(DFA73_acceptS);
    static final short[] DFA73_special = DFA.unpackEncodedString(DFA73_specialS);
    static final short[][] DFA73_transition;

    static {
        int numStates = DFA73_transitionS.length;
        DFA73_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA73_transition[i] = DFA.unpackEncodedString(DFA73_transitionS[i]);
        }
    }

    class DFA73 extends DFA {

        public DFA73(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 73;
            this.eot = DFA73_eot;
            this.eof = DFA73_eof;
            this.min = DFA73_min;
            this.max = DFA73_max;
            this.accept = DFA73_accept;
            this.special = DFA73_special;
            this.transition = DFA73_transition;
        }
        public String getDescription() {
            return "()* loopback of 922:4: (im= modifier )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA73_1 = input.LA(1);

                         
                        int index73_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred95_ObjCpp()&&( Modifier.parseModifier(next()) != null ))) ) {s = 10;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index73_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 73, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA75_eotS =
        "\16\uffff";
    static final String DFA75_eofS =
        "\16\uffff";
    static final String DFA75_minS =
        "\1\4\15\uffff";
    static final String DFA75_maxS =
        "\1\114\15\uffff";
    static final String DFA75_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA75_specialS =
        "\16\uffff}>";
    static final String[] DFA75_transitionS = {
            "\7\1\14\uffff\1\1\12\uffff\1\1\22\uffff\1\1\1\15\23\uffff\3"+
            "\1",
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

    static final short[] DFA75_eot = DFA.unpackEncodedString(DFA75_eotS);
    static final short[] DFA75_eof = DFA.unpackEncodedString(DFA75_eofS);
    static final char[] DFA75_min = DFA.unpackEncodedStringToUnsignedChars(DFA75_minS);
    static final char[] DFA75_max = DFA.unpackEncodedStringToUnsignedChars(DFA75_maxS);
    static final short[] DFA75_accept = DFA.unpackEncodedString(DFA75_acceptS);
    static final short[] DFA75_special = DFA.unpackEncodedString(DFA75_specialS);
    static final short[][] DFA75_transition;

    static {
        int numStates = DFA75_transitionS.length;
        DFA75_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA75_transition[i] = DFA.unpackEncodedString(DFA75_transitionS[i]);
        }
    }

    class DFA75 extends DFA {

        public DFA75(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 75;
            this.eot = DFA75_eot;
            this.eof = DFA75_eof;
            this.min = DFA75_min;
            this.max = DFA75_max;
            this.accept = DFA75_accept;
            this.special = DFA75_special;
            this.transition = DFA75_transition;
        }
        public String getDescription() {
            return "932:4: ( expression | )";
        }
    }
    static final String DFA77_eotS =
        "\14\uffff";
    static final String DFA77_eofS =
        "\14\uffff";
    static final String DFA77_minS =
        "\1\33\1\6\1\uffff\1\0\10\uffff";
    static final String DFA77_maxS =
        "\1\43\1\111\1\uffff\1\0\10\uffff";
    static final String DFA77_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\7\uffff";
    static final String DFA77_specialS =
        "\3\uffff\1\0\10\uffff}>";
    static final String[] DFA77_transitionS = {
            "\1\1\7\uffff\1\2",
            "\1\4\27\uffff\1\4\15\uffff\1\3\3\4\13\uffff\17\4",
            "",
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

    static final short[] DFA77_eot = DFA.unpackEncodedString(DFA77_eotS);
    static final short[] DFA77_eof = DFA.unpackEncodedString(DFA77_eofS);
    static final char[] DFA77_min = DFA.unpackEncodedStringToUnsignedChars(DFA77_minS);
    static final char[] DFA77_max = DFA.unpackEncodedStringToUnsignedChars(DFA77_maxS);
    static final short[] DFA77_accept = DFA.unpackEncodedString(DFA77_acceptS);
    static final short[] DFA77_special = DFA.unpackEncodedString(DFA77_specialS);
    static final short[][] DFA77_transition;

    static {
        int numStates = DFA77_transitionS.length;
        DFA77_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA77_transition[i] = DFA.unpackEncodedString(DFA77_transitionS[i]);
        }
    }

    class DFA77 extends DFA {

        public DFA77(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 77;
            this.eot = DFA77_eot;
            this.eof = DFA77_eof;
            this.min = DFA77_min;
            this.max = DFA77_max;
            this.accept = DFA77_accept;
            this.special = DFA77_special;
            this.transition = DFA77_transition;
        }
        public String getDescription() {
            return "()* loopback of 959:4: ( ',' ax= argDef )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA77_3 = input.LA(1);

                         
                        int index77_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred99_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index77_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 77, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA80_eotS =
        "\61\uffff";
    static final String DFA80_eofS =
        "\1\1\60\uffff";
    static final String DFA80_minS =
        "\1\6\2\uffff\1\0\3\uffff\3\0\47\uffff";
    static final String DFA80_maxS =
        "\1\71\2\uffff\1\0\3\uffff\3\0\47\uffff";
    static final String DFA80_acceptS =
        "\1\uffff\1\2\25\uffff\1\1\31\uffff";
    static final String DFA80_specialS =
        "\3\uffff\1\0\3\uffff\1\1\1\2\1\3\47\uffff}>";
    static final String[] DFA80_transitionS = {
            "\1\3\24\uffff\3\1\4\uffff\2\1\1\uffff\1\1\15\uffff\1\7\1\10"+
            "\1\11\3\uffff\1\1",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
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
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA80_eot = DFA.unpackEncodedString(DFA80_eotS);
    static final short[] DFA80_eof = DFA.unpackEncodedString(DFA80_eofS);
    static final char[] DFA80_min = DFA.unpackEncodedStringToUnsignedChars(DFA80_minS);
    static final char[] DFA80_max = DFA.unpackEncodedStringToUnsignedChars(DFA80_maxS);
    static final short[] DFA80_accept = DFA.unpackEncodedString(DFA80_acceptS);
    static final short[] DFA80_special = DFA.unpackEncodedString(DFA80_specialS);
    static final short[][] DFA80_transition;

    static {
        int numStates = DFA80_transitionS.length;
        DFA80_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA80_transition[i] = DFA.unpackEncodedString(DFA80_transitionS[i]);
        }
    }

    class DFA80 extends DFA {

        public DFA80(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 80;
            this.eot = DFA80_eot;
            this.eof = DFA80_eof;
            this.min = DFA80_min;
            this.max = DFA80_max;
            this.accept = DFA80_accept;
            this.special = DFA80_special;
            this.transition = DFA80_transition;
        }
        public String getDescription() {
            return "()* loopback of 980:3: ( typeMutator )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA80_3 = input.LA(1);

                         
                        int index80_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred102_ObjCpp()&&( next("const", "__const") ))) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index80_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA80_7 = input.LA(1);

                         
                        int index80_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred102_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index80_7);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA80_8 = input.LA(1);

                         
                        int index80_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred102_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index80_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA80_9 = input.LA(1);

                         
                        int index80_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred102_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index80_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 80, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA83_eotS =
        "\21\uffff";
    static final String DFA83_eofS =
        "\1\uffff\1\2\17\uffff";
    static final String DFA83_minS =
        "\1\77\1\6\17\uffff";
    static final String DFA83_maxS =
        "\2\111\17\uffff";
    static final String DFA83_acceptS =
        "\2\uffff\1\2\14\uffff\1\1\1\uffff";
    static final String DFA83_specialS =
        "\21\uffff}>";
    static final String[] DFA83_transitionS = {
            "\2\1\11\2",
            "\1\2\24\uffff\3\2\4\uffff\2\2\1\uffff\1\2\15\uffff\3\2\3\uffff"+
            "\1\2\5\uffff\13\17",
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

    static final short[] DFA83_eot = DFA.unpackEncodedString(DFA83_eotS);
    static final short[] DFA83_eof = DFA.unpackEncodedString(DFA83_eofS);
    static final char[] DFA83_min = DFA.unpackEncodedStringToUnsignedChars(DFA83_minS);
    static final char[] DFA83_max = DFA.unpackEncodedStringToUnsignedChars(DFA83_maxS);
    static final short[] DFA83_accept = DFA.unpackEncodedString(DFA83_acceptS);
    static final short[] DFA83_special = DFA.unpackEncodedString(DFA83_specialS);
    static final short[][] DFA83_transition;

    static {
        int numStates = DFA83_transitionS.length;
        DFA83_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA83_transition[i] = DFA.unpackEncodedString(DFA83_transitionS[i]);
        }
    }

    class DFA83 extends DFA {

        public DFA83(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 83;
            this.eot = DFA83_eot;
            this.eof = DFA83_eof;
            this.min = DFA83_min;
            this.max = DFA83_max;
            this.accept = DFA83_accept;
            this.special = DFA83_special;
            this.transition = DFA83_transition;
        }
        public String getDescription() {
            return "1013:4: (mod2= primSizeModifier (mod3= primSizeModifier )? )?";
        }
    }
    static final String DFA82_eotS =
        "\20\uffff";
    static final String DFA82_eofS =
        "\1\uffff\1\2\16\uffff";
    static final String DFA82_minS =
        "\1\77\1\6\16\uffff";
    static final String DFA82_maxS =
        "\2\111\16\uffff";
    static final String DFA82_acceptS =
        "\2\uffff\1\2\1\1\14\uffff";
    static final String DFA82_specialS =
        "\20\uffff}>";
    static final String[] DFA82_transitionS = {
            "\2\1\11\2",
            "\1\2\24\uffff\3\2\4\uffff\2\2\1\uffff\1\2\15\uffff\3\2\3\uffff"+
            "\1\2\5\uffff\13\3",
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

    static final short[] DFA82_eot = DFA.unpackEncodedString(DFA82_eotS);
    static final short[] DFA82_eof = DFA.unpackEncodedString(DFA82_eofS);
    static final char[] DFA82_min = DFA.unpackEncodedStringToUnsignedChars(DFA82_minS);
    static final char[] DFA82_max = DFA.unpackEncodedStringToUnsignedChars(DFA82_maxS);
    static final short[] DFA82_accept = DFA.unpackEncodedString(DFA82_acceptS);
    static final short[] DFA82_special = DFA.unpackEncodedString(DFA82_specialS);
    static final short[][] DFA82_transition;

    static {
        int numStates = DFA82_transitionS.length;
        DFA82_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA82_transition[i] = DFA.unpackEncodedString(DFA82_transitionS[i]);
        }
    }

    class DFA82 extends DFA {

        public DFA82(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 82;
            this.eot = DFA82_eot;
            this.eof = DFA82_eof;
            this.min = DFA82_min;
            this.max = DFA82_max;
            this.accept = DFA82_accept;
            this.special = DFA82_special;
            this.transition = DFA82_transition;
        }
        public String getDescription() {
            return "1014:8: (mod3= primSizeModifier )?";
        }
    }
    static final String DFA87_eotS =
        "\16\uffff";
    static final String DFA87_eofS =
        "\16\uffff";
    static final String DFA87_minS =
        "\1\4\15\uffff";
    static final String DFA87_maxS =
        "\1\114\15\uffff";
    static final String DFA87_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA87_specialS =
        "\16\uffff}>";
    static final String[] DFA87_transitionS = {
            "\7\1\14\uffff\1\1\12\uffff\1\1\1\15\21\uffff\1\1\24\uffff\3"+
            "\1",
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

    static final short[] DFA87_eot = DFA.unpackEncodedString(DFA87_eotS);
    static final short[] DFA87_eof = DFA.unpackEncodedString(DFA87_eofS);
    static final char[] DFA87_min = DFA.unpackEncodedStringToUnsignedChars(DFA87_minS);
    static final char[] DFA87_max = DFA.unpackEncodedStringToUnsignedChars(DFA87_maxS);
    static final short[] DFA87_accept = DFA.unpackEncodedString(DFA87_acceptS);
    static final short[] DFA87_special = DFA.unpackEncodedString(DFA87_specialS);
    static final short[][] DFA87_transition;

    static {
        int numStates = DFA87_transitionS.length;
        DFA87_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA87_transition[i] = DFA.unpackEncodedString(DFA87_transitionS[i]);
        }
    }

    class DFA87 extends DFA {

        public DFA87(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 87;
            this.eot = DFA87_eot;
            this.eof = DFA87_eof;
            this.min = DFA87_min;
            this.max = DFA87_max;
            this.accept = DFA87_accept;
            this.special = DFA87_special;
            this.transition = DFA87_transition;
        }
        public String getDescription() {
            return "1083:3: (a1= expression ( ',' ax= expression )* )?";
        }
    }
    static final String DFA90_eotS =
        "\33\uffff";
    static final String DFA90_eofS =
        "\1\uffff\1\16\31\uffff";
    static final String DFA90_minS =
        "\1\4\1\6\31\uffff";
    static final String DFA90_maxS =
        "\1\114\1\132\31\uffff";
    static final String DFA90_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\5\uffff\1\7\1\uffff\1\1\14\uffff";
    static final String DFA90_specialS =
        "\33\uffff}>";
    static final String[] DFA90_transitionS = {
            "\2\6\1\1\4\6\14\uffff\1\14\12\uffff\1\5\22\uffff\1\3\24\uffff"+
            "\1\2\2\4",
            "\1\16\21\uffff\1\16\2\uffff\3\16\3\uffff\1\16\1\2\3\16\4\uffff"+
            "\2\16\7\uffff\2\16\1\uffff\1\16\2\uffff\1\16\23\uffff\16\16",
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

    static final short[] DFA90_eot = DFA.unpackEncodedString(DFA90_eotS);
    static final short[] DFA90_eof = DFA.unpackEncodedString(DFA90_eofS);
    static final char[] DFA90_min = DFA.unpackEncodedStringToUnsignedChars(DFA90_minS);
    static final char[] DFA90_max = DFA.unpackEncodedStringToUnsignedChars(DFA90_maxS);
    static final short[] DFA90_accept = DFA.unpackEncodedString(DFA90_acceptS);
    static final short[] DFA90_special = DFA.unpackEncodedString(DFA90_specialS);
    static final short[][] DFA90_transition;

    static {
        int numStates = DFA90_transitionS.length;
        DFA90_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA90_transition[i] = DFA.unpackEncodedString(DFA90_transitionS[i]);
        }
    }

    class DFA90 extends DFA {

        public DFA90(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 90;
            this.eot = DFA90_eot;
            this.eof = DFA90_eof;
            this.min = DFA90_min;
            this.max = DFA90_max;
            this.accept = DFA90_accept;
            this.special = DFA90_special;
            this.transition = DFA90_transition;
        }
        public String getDescription() {
            return "1097:4: (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' )";
        }
    }
    static final String DFA89_eotS =
        "\172\uffff";
    static final String DFA89_eofS =
        "\35\uffff\1\2\134\uffff";
    static final String DFA89_minS =
        "\1\4\1\6\20\uffff\1\4\10\uffff\1\4\1\uffff\1\4\2\uffff\2\4\2\uffff"+
        "\1\0\16\uffff\1\0\2\uffff\2\0\11\uffff\1\0\30\uffff\1\0\2\uffff"+
        "\2\0\13\uffff\1\0\17\uffff";
    static final String DFA89_maxS =
        "\1\114\1\132\20\uffff\1\114\10\uffff\1\114\1\uffff\1\132\2\uffff"+
        "\2\114\2\uffff\1\0\16\uffff\1\0\2\uffff\2\0\11\uffff\1\0\30\uffff"+
        "\1\0\2\uffff\2\0\13\uffff\1\0\17\uffff";
    static final String DFA89_acceptS =
        "\2\uffff\1\1\12\uffff\1\2\154\uffff";
    static final String DFA89_specialS =
        "\44\uffff\1\0\16\uffff\1\1\2\uffff\1\2\1\3\11\uffff\1\4\30\uffff"+
        "\1\5\2\uffff\1\6\1\7\13\uffff\1\10\17\uffff}>";
    static final String[] DFA89_transitionS = {
            "\2\2\1\1\4\2\14\uffff\1\2\6\uffff\1\15\3\uffff\1\2\12\uffff"+
            "\3\15\5\uffff\1\2\5\uffff\17\15\3\2",
            "\1\15\26\uffff\1\2\1\15\2\uffff\1\2\1\22\1\35\1\41\1\2\4\uffff"+
            "\2\2\1\uffff\3\15\3\uffff\1\33\1\40\1\15\3\uffff\1\2\1\uffff"+
            "\17\15\3\uffff\16\2",
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
            "\2\2\1\44\4\2\14\uffff\1\2\12\uffff\2\2\17\uffff\1\15\1\uffff"+
            "\1\2\24\uffff\3\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\2\2\1\63\4\2\14\uffff\1\2\12\uffff\1\67\1\15\17\uffff\2\15"+
            "\1\66\24\uffff\3\2",
            "",
            "\2\15\1\101\4\15\14\uffff\1\15\1\2\2\uffff\3\2\3\uffff\1\2"+
            "\1\15\3\2\4\uffff\2\2\7\uffff\2\2\1\15\1\2\2\uffff\1\2\20\uffff"+
            "\3\15\16\2",
            "",
            "",
            "\2\2\1\132\4\2\14\uffff\1\2\12\uffff\1\136\1\15\17\uffff\2"+
            "\15\1\135\24\uffff\3\2",
            "\2\2\1\152\4\2\14\uffff\1\2\6\uffff\1\15\3\uffff\1\2\2\uffff"+
            "\1\15\7\uffff\3\15\5\uffff\1\2\5\uffff\17\15\3\2",
            "",
            "",
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
            "\1\uffff",
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
            "",
            "",
            "",
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
            "\1\uffff",
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
            "",
            "",
            "",
            "",
            "",
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
            ""
    };

    static final short[] DFA89_eot = DFA.unpackEncodedString(DFA89_eotS);
    static final short[] DFA89_eof = DFA.unpackEncodedString(DFA89_eofS);
    static final char[] DFA89_min = DFA.unpackEncodedStringToUnsignedChars(DFA89_minS);
    static final char[] DFA89_max = DFA.unpackEncodedStringToUnsignedChars(DFA89_maxS);
    static final short[] DFA89_accept = DFA.unpackEncodedString(DFA89_acceptS);
    static final short[] DFA89_special = DFA.unpackEncodedString(DFA89_specialS);
    static final short[][] DFA89_transition;

    static {
        int numStates = DFA89_transitionS.length;
        DFA89_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA89_transition[i] = DFA.unpackEncodedString(DFA89_transitionS[i]);
        }
    }

    class DFA89 extends DFA {

        public DFA89(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 89;
            this.eot = DFA89_eot;
            this.eof = DFA89_eof;
            this.min = DFA89_min;
            this.max = DFA89_max;
            this.accept = DFA89_accept;
            this.special = DFA89_special;
            this.transition = DFA89_transition;
        }
        public String getDescription() {
            return "1110:8: (par= expression ')' | typeRef ')' casted= expression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA89_36 = input.LA(1);

                         
                        int index89_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred130_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index89_36);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA89_51 = input.LA(1);

                         
                        int index89_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred130_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index89_51);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA89_54 = input.LA(1);

                         
                        int index89_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred130_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index89_54);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA89_55 = input.LA(1);

                         
                        int index89_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred130_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index89_55);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA89_65 = input.LA(1);

                         
                        int index89_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred130_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index89_65);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA89_90 = input.LA(1);

                         
                        int index89_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred130_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index89_90);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA89_93 = input.LA(1);

                         
                        int index89_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred130_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index89_93);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA89_94 = input.LA(1);

                         
                        int index89_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred130_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index89_94);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA89_106 = input.LA(1);

                         
                        int index89_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred130_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index89_106);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 89, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA92_eotS =
        "\146\uffff";
    static final String DFA92_eofS =
        "\1\1\145\uffff";
    static final String DFA92_minS =
        "\1\6\5\uffff\1\0\2\uffff\5\0\130\uffff";
    static final String DFA92_maxS =
        "\1\132\5\uffff\1\0\2\uffff\5\0\130\uffff";
    static final String DFA92_acceptS =
        "\1\uffff\1\6\30\uffff\1\2\15\uffff\1\1\1\4\2\uffff\1\3\70\uffff"+
        "\1\5";
    static final String DFA92_specialS =
        "\6\uffff\1\0\2\uffff\1\1\1\2\1\3\1\4\1\5\130\uffff}>";
    static final String[] DFA92_transitionS = {
            "\1\1\21\uffff\1\1\2\uffff\2\1\1\6\3\uffff\1\13\1\uffff\1\1\2"+
            "\14\4\uffff\1\14\1\11\7\uffff\2\14\1\uffff\1\1\2\uffff\1\14"+
            "\23\uffff\14\14\1\12\1\15",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
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
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA92_eot = DFA.unpackEncodedString(DFA92_eotS);
    static final short[] DFA92_eof = DFA.unpackEncodedString(DFA92_eofS);
    static final char[] DFA92_min = DFA.unpackEncodedStringToUnsignedChars(DFA92_minS);
    static final char[] DFA92_max = DFA.unpackEncodedStringToUnsignedChars(DFA92_maxS);
    static final short[] DFA92_accept = DFA.unpackEncodedString(DFA92_acceptS);
    static final short[] DFA92_special = DFA.unpackEncodedString(DFA92_specialS);
    static final short[][] DFA92_transition;

    static {
        int numStates = DFA92_transitionS.length;
        DFA92_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA92_transition[i] = DFA.unpackEncodedString(DFA92_transitionS[i]);
        }
    }

    class DFA92 extends DFA {

        public DFA92(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 92;
            this.eot = DFA92_eot;
            this.eof = DFA92_eof;
            this.min = DFA92_min;
            this.max = DFA92_max;
            this.accept = DFA92_accept;
            this.special = DFA92_special;
            this.transition = DFA92_transition;
        }
        public String getDescription() {
            return "()* loopback of 1123:3: (bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA92_6 = input.LA(1);

                         
                        int index92_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 26;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index92_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA92_9 = input.LA(1);

                         
                        int index92_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_ObjCpp()) ) {s = 40;}

                        else if ( (synpred156_ObjCpp()) ) {s = 41;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index92_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA92_10 = input.LA(1);

                         
                        int index92_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred153_ObjCpp()) ) {s = 44;}

                        else if ( (synpred156_ObjCpp()) ) {s = 41;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index92_10);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA92_11 = input.LA(1);

                         
                        int index92_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred156_ObjCpp()) ) {s = 41;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index92_11);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA92_12 = input.LA(1);

                         
                        int index92_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_ObjCpp()) ) {s = 40;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index92_12);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA92_13 = input.LA(1);

                         
                        int index92_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred157_ObjCpp()) ) {s = 101;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index92_13);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 92, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA93_eotS =
        "\36\uffff";
    static final String DFA93_eofS =
        "\36\uffff";
    static final String DFA93_minS =
        "\1\4\35\uffff";
    static final String DFA93_maxS =
        "\1\141\35\uffff";
    static final String DFA93_acceptS =
        "\1\uffff\1\2\1\1\33\uffff";
    static final String DFA93_specialS =
        "\36\uffff}>";
    static final String[] DFA93_transitionS = {
            "\7\2\14\uffff\1\2\1\1\2\2\1\uffff\1\2\1\uffff\3\2\1\uffff\1"+
            "\2\12\uffff\3\2\5\uffff\1\2\4\uffff\23\2\16\uffff\2\2\1\uffff"+
            "\4\2",
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
            "",
            "",
            "",
            ""
    };

    static final short[] DFA93_eot = DFA.unpackEncodedString(DFA93_eotS);
    static final short[] DFA93_eof = DFA.unpackEncodedString(DFA93_eofS);
    static final char[] DFA93_min = DFA.unpackEncodedStringToUnsignedChars(DFA93_minS);
    static final char[] DFA93_max = DFA.unpackEncodedStringToUnsignedChars(DFA93_maxS);
    static final short[] DFA93_accept = DFA.unpackEncodedString(DFA93_acceptS);
    static final short[] DFA93_special = DFA.unpackEncodedString(DFA93_specialS);
    static final short[][] DFA93_transition;

    static {
        int numStates = DFA93_transitionS.length;
        DFA93_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA93_transition[i] = DFA.unpackEncodedString(DFA93_transitionS[i]);
        }
    }

    class DFA93 extends DFA {

        public DFA93(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 93;
            this.eot = DFA93_eot;
            this.eof = DFA93_eof;
            this.min = DFA93_min;
            this.max = DFA93_max;
            this.accept = DFA93_accept;
            this.special = DFA93_special;
            this.transition = DFA93_transition;
        }
        public String getDescription() {
            return "()* loopback of 1152:8: ( statement )*";
        }
    }
    static final String DFA100_eotS =
        "\u012b\uffff";
    static final String DFA100_eofS =
        "\u012b\uffff";
    static final String DFA100_minS =
        "\2\4\2\uffff\1\6\30\uffff\1\6\1\42\3\4\6\30\1\4\21\uffff\1\4\6\uffff"+
        "\2\4\1\uffff\2\4\7\uffff\1\0\4\uffff\6\0\4\uffff\2\0\1\uffff\62"+
        "\0\2\uffff\6\0\2\uffff\6\0\2\uffff\6\0\2\uffff\6\0\2\uffff\6\0\2"+
        "\uffff\14\0\21\uffff\1\0\1\uffff\5\0\1\uffff\1\0\1\uffff\1\0\12"+
        "\uffff\1\0\1\uffff\1\0\1\uffff\1\0\12\uffff\2\0\2\uffff\1\0\12\uffff"+
        "\1\0\21\uffff\1\0\3\uffff\1\0\11\uffff";
    static final String DFA100_maxS =
        "\2\141\2\uffff\1\132\30\uffff\1\132\1\42\3\114\6\132\1\141\21\uffff"+
        "\1\114\6\uffff\2\114\1\uffff\2\114\7\uffff\1\0\4\uffff\6\0\4\uffff"+
        "\2\0\1\uffff\62\0\2\uffff\6\0\2\uffff\6\0\2\uffff\6\0\2\uffff\6"+
        "\0\2\uffff\6\0\2\uffff\14\0\21\uffff\1\0\1\uffff\5\0\1\uffff\1\0"+
        "\1\uffff\1\0\12\uffff\1\0\1\uffff\1\0\1\uffff\1\0\12\uffff\2\0\2"+
        "\uffff\1\0\12\uffff\1\0\21\uffff\1\0\3\uffff\1\0\11\uffff";
    static final String DFA100_acceptS =
        "\2\uffff\1\2\11\uffff\1\3\11\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
        "\14\uffff\1\1\u0100\uffff\1\13";
    static final String DFA100_specialS =
        "\115\uffff\1\0\4\uffff\1\1\1\2\1\3\1\4\1\5\1\6\4\uffff\1\7\1\10"+
        "\1\uffff\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23"+
        "\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40"+
        "\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55"+
        "\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72"+
        "\2\uffff\1\73\1\74\1\75\1\76\1\77\1\100\2\uffff\1\101\1\102\1\103"+
        "\1\104\1\105\1\106\2\uffff\1\107\1\110\1\111\1\112\1\113\1\114\2"+
        "\uffff\1\115\1\116\1\117\1\120\1\121\1\122\2\uffff\1\123\1\124\1"+
        "\125\1\126\1\127\1\130\2\uffff\1\131\1\132\1\133\1\134\1\135\1\136"+
        "\1\137\1\140\1\141\1\142\1\143\1\144\21\uffff\1\145\1\uffff\1\146"+
        "\1\147\1\150\1\151\1\152\1\uffff\1\153\1\uffff\1\154\12\uffff\1"+
        "\155\1\uffff\1\156\1\uffff\1\157\12\uffff\1\160\1\161\2\uffff\1"+
        "\162\12\uffff\1\163\21\uffff\1\164\3\uffff\1\165\11\uffff}>";
    static final String[] DFA100_transitionS = {
            "\2\14\1\4\4\14\14\uffff\1\1\1\uffff\2\2\1\uffff\1\34\1\uffff"+
            "\3\2\1\uffff\1\14\12\uffff\3\2\5\uffff\1\14\4\uffff\20\2\3\14"+
            "\16\uffff\1\26\1\27\1\uffff\1\30\1\31\1\32\1\33",
            "\1\42\1\47\1\35\1\43\1\44\1\45\1\46\14\uffff\1\50\3\51\1\uffff"+
            "\1\51\1\uffff\3\51\1\uffff\1\41\12\uffff\3\51\5\uffff\1\37\4"+
            "\uffff\20\51\1\36\2\40\16\uffff\2\51\1\uffff\4\51",
            "",
            "",
            "\1\2\25\uffff\2\14\1\2\2\uffff\1\14\1\72\1\uffff\1\104\1\14"+
            "\4\uffff\2\14\1\uffff\3\2\3\uffff\1\101\1\102\1\2\3\uffff\1"+
            "\105\1\uffff\17\2\3\uffff\16\14",
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
            "\1\51\21\uffff\1\14\3\uffff\1\51\1\123\1\51\2\uffff\1\125\1"+
            "\115\1\uffff\1\137\1\140\4\uffff\1\140\1\122\1\uffff\3\51\3"+
            "\uffff\1\126\1\134\1\51\3\uffff\1\135\1\uffff\17\51\3\uffff"+
            "\14\140\1\124\1\127",
            "\1\141",
            "\1\147\1\154\1\142\1\150\1\151\1\152\1\153\14\uffff\1\155\12"+
            "\uffff\1\146\22\uffff\1\144\24\uffff\1\143\2\145",
            "\1\163\1\170\1\156\1\164\1\165\1\166\1\167\14\uffff\1\171\12"+
            "\uffff\1\162\22\uffff\1\160\24\uffff\1\157\2\161",
            "\1\177\1\u0084\1\172\1\u0080\1\u0081\1\u0082\1\u0083\14\uffff"+
            "\1\u0085\6\uffff\1\u0087\3\uffff\1\176\12\uffff\3\u0086\5\uffff"+
            "\1\174\5\uffff\4\u0088\2\u0089\11\u008a\1\173\2\175",
            "\1\14\3\uffff\1\51\1\u008c\3\uffff\1\u008e\2\uffff\2\u008f"+
            "\4\uffff\1\u008f\1\u008b\7\uffff\2\u008f\4\uffff\1\u008f\23"+
            "\uffff\14\u008f\1\u008d\1\u0090",
            "\1\14\3\uffff\1\51\1\u0094\3\uffff\1\u0096\2\uffff\2\u0097"+
            "\4\uffff\1\u0097\1\u0093\7\uffff\2\u0097\4\uffff\1\u0097\23"+
            "\uffff\14\u0097\1\u0095\1\u0098",
            "\1\14\3\uffff\1\51\1\u009c\3\uffff\1\u009e\2\uffff\2\u009f"+
            "\4\uffff\1\u009f\1\u009b\7\uffff\2\u009f\4\uffff\1\u009f\23"+
            "\uffff\14\u009f\1\u009d\1\u00a0",
            "\1\14\3\uffff\1\51\1\u00a4\3\uffff\1\u00a6\2\uffff\2\u00a7"+
            "\4\uffff\1\u00a7\1\u00a3\7\uffff\2\u00a7\4\uffff\1\u00a7\23"+
            "\uffff\14\u00a7\1\u00a5\1\u00a8",
            "\1\14\3\uffff\1\51\1\u00ac\3\uffff\1\u00ae\2\uffff\2\u00af"+
            "\4\uffff\1\u00af\1\u00ab\7\uffff\2\u00af\4\uffff\1\u00af\23"+
            "\uffff\14\u00af\1\u00ad\1\u00b0",
            "\1\14\3\uffff\1\51\1\u00b4\3\uffff\1\u00b6\2\uffff\2\u00b7"+
            "\4\uffff\1\u00b7\1\u00b3\7\uffff\2\u00b7\4\uffff\1\u00b7\23"+
            "\uffff\14\u00b7\1\u00b5\1\u00b8",
            "\1\u00c0\1\u00c5\1\u00bb\1\u00c1\1\u00c2\1\u00c3\1\u00c4\14"+
            "\uffff\1\u00c6\3\51\1\uffff\1\51\1\uffff\3\51\1\uffff\1\u00bf"+
            "\12\uffff\3\51\5\uffff\1\u00bd\4\uffff\20\51\1\u00bc\2\u00be"+
            "\16\uffff\2\51\1\uffff\4\51",
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
            "\2\14\1\u00d8\4\14\14\uffff\1\14\6\uffff\1\u00db\3\uffff\1"+
            "\u00e2\1\u00e0\10\uffff\1\2\3\u00da\3\uffff\2\2\1\14\3\uffff"+
            "\1\2\1\uffff\4\u00dc\2\u00dd\11\u00de\3\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "\2\14\1\u00ed\4\14\14\uffff\1\14\12\uffff\1\u00f1\20\uffff"+
            "\2\2\1\u00ef\3\uffff\1\2\20\uffff\3\14",
            "\2\14\1\u00fd\4\14\14\uffff\1\14\12\uffff\1\u00fc\20\uffff"+
            "\2\2\1\u0100\3\uffff\1\2\20\uffff\3\14",
            "",
            "\2\14\1\u010b\4\14\14\uffff\1\14\6\uffff\1\2\3\uffff\1\14\2"+
            "\uffff\1\2\7\uffff\3\2\5\uffff\1\14\5\uffff\17\2\3\14",
            "\2\14\1\u011d\4\14\14\uffff\1\14\12\uffff\1\u0121\20\uffff"+
            "\2\2\1\14\3\uffff\1\2\20\uffff\3\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
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
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
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
            "\1\uffff",
            "",
            "\1\uffff",
            "",
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
            "\1\uffff",
            "\1\uffff",
            "",
            "",
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
            "\1\uffff",
            "",
            "",
            "",
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

    static final short[] DFA100_eot = DFA.unpackEncodedString(DFA100_eotS);
    static final short[] DFA100_eof = DFA.unpackEncodedString(DFA100_eofS);
    static final char[] DFA100_min = DFA.unpackEncodedStringToUnsignedChars(DFA100_minS);
    static final char[] DFA100_max = DFA.unpackEncodedStringToUnsignedChars(DFA100_maxS);
    static final short[] DFA100_accept = DFA.unpackEncodedString(DFA100_acceptS);
    static final short[] DFA100_special = DFA.unpackEncodedString(DFA100_specialS);
    static final short[][] DFA100_transition;

    static {
        int numStates = DFA100_transitionS.length;
        DFA100_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA100_transition[i] = DFA.unpackEncodedString(DFA100_transitionS[i]);
        }
    }

    class DFA100 extends DFA {

        public DFA100(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 100;
            this.eot = DFA100_eot;
            this.eof = DFA100_eof;
            this.min = DFA100_min;
            this.max = DFA100_max;
            this.accept = DFA100_accept;
            this.special = DFA100_special;
            this.transition = DFA100_transition;
        }
        public String getDescription() {
            return "1154:1: statement : ( statementsBlock | declaration | expression ( '=' expression )? ';' | 'return' expression ';' | 'if' '(' expression ')' statement ( 'else' statement )? | 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA100_77 = input.LA(1);

                         
                        int index100_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_77);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA100_82 = input.LA(1);

                         
                        int index100_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_82);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA100_83 = input.LA(1);

                         
                        int index100_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_83);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA100_84 = input.LA(1);

                         
                        int index100_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_84);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA100_85 = input.LA(1);

                         
                        int index100_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_85);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA100_86 = input.LA(1);

                         
                        int index100_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_86);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA100_87 = input.LA(1);

                         
                        int index100_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_87);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA100_92 = input.LA(1);

                         
                        int index100_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_92);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA100_93 = input.LA(1);

                         
                        int index100_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_93);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA100_95 = input.LA(1);

                         
                        int index100_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_95);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA100_96 = input.LA(1);

                         
                        int index100_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_96);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA100_97 = input.LA(1);

                         
                        int index100_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_97);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA100_98 = input.LA(1);

                         
                        int index100_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_98);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA100_99 = input.LA(1);

                         
                        int index100_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_99);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA100_100 = input.LA(1);

                         
                        int index100_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_100);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA100_101 = input.LA(1);

                         
                        int index100_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_101);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA100_102 = input.LA(1);

                         
                        int index100_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_102);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA100_103 = input.LA(1);

                         
                        int index100_103 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_103);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA100_104 = input.LA(1);

                         
                        int index100_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_104);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA100_105 = input.LA(1);

                         
                        int index100_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_105);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA100_106 = input.LA(1);

                         
                        int index100_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_106);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA100_107 = input.LA(1);

                         
                        int index100_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_107);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA100_108 = input.LA(1);

                         
                        int index100_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_108);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA100_109 = input.LA(1);

                         
                        int index100_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_109);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA100_110 = input.LA(1);

                         
                        int index100_110 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_110);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA100_111 = input.LA(1);

                         
                        int index100_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_111);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA100_112 = input.LA(1);

                         
                        int index100_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_112);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA100_113 = input.LA(1);

                         
                        int index100_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_113);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA100_114 = input.LA(1);

                         
                        int index100_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_114);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA100_115 = input.LA(1);

                         
                        int index100_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_115);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA100_116 = input.LA(1);

                         
                        int index100_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_116);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA100_117 = input.LA(1);

                         
                        int index100_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_117);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA100_118 = input.LA(1);

                         
                        int index100_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_118);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA100_119 = input.LA(1);

                         
                        int index100_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_119);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA100_120 = input.LA(1);

                         
                        int index100_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_120);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA100_121 = input.LA(1);

                         
                        int index100_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_121);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA100_122 = input.LA(1);

                         
                        int index100_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_122);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA100_123 = input.LA(1);

                         
                        int index100_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_123);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA100_124 = input.LA(1);

                         
                        int index100_124 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_124);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA100_125 = input.LA(1);

                         
                        int index100_125 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_125);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA100_126 = input.LA(1);

                         
                        int index100_126 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_126);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA100_127 = input.LA(1);

                         
                        int index100_127 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_127);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA100_128 = input.LA(1);

                         
                        int index100_128 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_128);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA100_129 = input.LA(1);

                         
                        int index100_129 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_129);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA100_130 = input.LA(1);

                         
                        int index100_130 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_130);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA100_131 = input.LA(1);

                         
                        int index100_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_131);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA100_132 = input.LA(1);

                         
                        int index100_132 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_132);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA100_133 = input.LA(1);

                         
                        int index100_133 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_133);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA100_134 = input.LA(1);

                         
                        int index100_134 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_134);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA100_135 = input.LA(1);

                         
                        int index100_135 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_135);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA100_136 = input.LA(1);

                         
                        int index100_136 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_136);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA100_137 = input.LA(1);

                         
                        int index100_137 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_137);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA100_138 = input.LA(1);

                         
                        int index100_138 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_138);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA100_139 = input.LA(1);

                         
                        int index100_139 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_139);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA100_140 = input.LA(1);

                         
                        int index100_140 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_140);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA100_141 = input.LA(1);

                         
                        int index100_141 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_141);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA100_142 = input.LA(1);

                         
                        int index100_142 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_142);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA100_143 = input.LA(1);

                         
                        int index100_143 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_143);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA100_144 = input.LA(1);

                         
                        int index100_144 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_144);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA100_147 = input.LA(1);

                         
                        int index100_147 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_147);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA100_148 = input.LA(1);

                         
                        int index100_148 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_148);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA100_149 = input.LA(1);

                         
                        int index100_149 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_149);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA100_150 = input.LA(1);

                         
                        int index100_150 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_150);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA100_151 = input.LA(1);

                         
                        int index100_151 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_151);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA100_152 = input.LA(1);

                         
                        int index100_152 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_152);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA100_155 = input.LA(1);

                         
                        int index100_155 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_155);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA100_156 = input.LA(1);

                         
                        int index100_156 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_156);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA100_157 = input.LA(1);

                         
                        int index100_157 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_157);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA100_158 = input.LA(1);

                         
                        int index100_158 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_158);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA100_159 = input.LA(1);

                         
                        int index100_159 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_159);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA100_160 = input.LA(1);

                         
                        int index100_160 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_160);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA100_163 = input.LA(1);

                         
                        int index100_163 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_163);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA100_164 = input.LA(1);

                         
                        int index100_164 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_164);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA100_165 = input.LA(1);

                         
                        int index100_165 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_165);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA100_166 = input.LA(1);

                         
                        int index100_166 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_166);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA100_167 = input.LA(1);

                         
                        int index100_167 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_167);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA100_168 = input.LA(1);

                         
                        int index100_168 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_168);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA100_171 = input.LA(1);

                         
                        int index100_171 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_171);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA100_172 = input.LA(1);

                         
                        int index100_172 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_172);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA100_173 = input.LA(1);

                         
                        int index100_173 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_173);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA100_174 = input.LA(1);

                         
                        int index100_174 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_174);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA100_175 = input.LA(1);

                         
                        int index100_175 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_175);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA100_176 = input.LA(1);

                         
                        int index100_176 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_176);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA100_179 = input.LA(1);

                         
                        int index100_179 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_179);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA100_180 = input.LA(1);

                         
                        int index100_180 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_180);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA100_181 = input.LA(1);

                         
                        int index100_181 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_181);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA100_182 = input.LA(1);

                         
                        int index100_182 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_182);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA100_183 = input.LA(1);

                         
                        int index100_183 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_183);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA100_184 = input.LA(1);

                         
                        int index100_184 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_184);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA100_187 = input.LA(1);

                         
                        int index100_187 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_187);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA100_188 = input.LA(1);

                         
                        int index100_188 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_188);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA100_189 = input.LA(1);

                         
                        int index100_189 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_189);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA100_190 = input.LA(1);

                         
                        int index100_190 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_190);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA100_191 = input.LA(1);

                         
                        int index100_191 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_191);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA100_192 = input.LA(1);

                         
                        int index100_192 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_192);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA100_193 = input.LA(1);

                         
                        int index100_193 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_193);
                        if ( s>=0 ) return s;
                        break;
                    case 96 : 
                        int LA100_194 = input.LA(1);

                         
                        int index100_194 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_194);
                        if ( s>=0 ) return s;
                        break;
                    case 97 : 
                        int LA100_195 = input.LA(1);

                         
                        int index100_195 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_195);
                        if ( s>=0 ) return s;
                        break;
                    case 98 : 
                        int LA100_196 = input.LA(1);

                         
                        int index100_196 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_196);
                        if ( s>=0 ) return s;
                        break;
                    case 99 : 
                        int LA100_197 = input.LA(1);

                         
                        int index100_197 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_197);
                        if ( s>=0 ) return s;
                        break;
                    case 100 : 
                        int LA100_198 = input.LA(1);

                         
                        int index100_198 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 41;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_198);
                        if ( s>=0 ) return s;
                        break;
                    case 101 : 
                        int LA100_216 = input.LA(1);

                         
                        int index100_216 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_ObjCpp()) ) {s = 2;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                        else if ( (( next("foreach") )) ) {s = 298;}

                         
                        input.seek(index100_216);
                        if ( s>=0 ) return s;
                        break;
                    case 102 : 
                        int LA100_218 = input.LA(1);

                         
                        int index100_218 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 298;}

                         
                        input.seek(index100_218);
                        if ( s>=0 ) return s;
                        break;
                    case 103 : 
                        int LA100_219 = input.LA(1);

                         
                        int index100_219 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 298;}

                         
                        input.seek(index100_219);
                        if ( s>=0 ) return s;
                        break;
                    case 104 : 
                        int LA100_220 = input.LA(1);

                         
                        int index100_220 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 298;}

                         
                        input.seek(index100_220);
                        if ( s>=0 ) return s;
                        break;
                    case 105 : 
                        int LA100_221 = input.LA(1);

                         
                        int index100_221 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 298;}

                         
                        input.seek(index100_221);
                        if ( s>=0 ) return s;
                        break;
                    case 106 : 
                        int LA100_222 = input.LA(1);

                         
                        int index100_222 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 298;}

                         
                        input.seek(index100_222);
                        if ( s>=0 ) return s;
                        break;
                    case 107 : 
                        int LA100_224 = input.LA(1);

                         
                        int index100_224 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_ObjCpp()) ) {s = 2;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_224);
                        if ( s>=0 ) return s;
                        break;
                    case 108 : 
                        int LA100_226 = input.LA(1);

                         
                        int index100_226 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_ObjCpp()) ) {s = 2;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_226);
                        if ( s>=0 ) return s;
                        break;
                    case 109 : 
                        int LA100_237 = input.LA(1);

                         
                        int index100_237 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_ObjCpp()) ) {s = 2;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_237);
                        if ( s>=0 ) return s;
                        break;
                    case 110 : 
                        int LA100_239 = input.LA(1);

                         
                        int index100_239 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_ObjCpp()) ) {s = 2;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_239);
                        if ( s>=0 ) return s;
                        break;
                    case 111 : 
                        int LA100_241 = input.LA(1);

                         
                        int index100_241 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_ObjCpp()) ) {s = 2;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_241);
                        if ( s>=0 ) return s;
                        break;
                    case 112 : 
                        int LA100_252 = input.LA(1);

                         
                        int index100_252 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_ObjCpp()) ) {s = 2;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_252);
                        if ( s>=0 ) return s;
                        break;
                    case 113 : 
                        int LA100_253 = input.LA(1);

                         
                        int index100_253 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_ObjCpp()) ) {s = 2;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_253);
                        if ( s>=0 ) return s;
                        break;
                    case 114 : 
                        int LA100_256 = input.LA(1);

                         
                        int index100_256 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_ObjCpp()) ) {s = 2;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_256);
                        if ( s>=0 ) return s;
                        break;
                    case 115 : 
                        int LA100_267 = input.LA(1);

                         
                        int index100_267 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_ObjCpp()) ) {s = 2;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_267);
                        if ( s>=0 ) return s;
                        break;
                    case 116 : 
                        int LA100_285 = input.LA(1);

                         
                        int index100_285 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_ObjCpp()) ) {s = 2;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_285);
                        if ( s>=0 ) return s;
                        break;
                    case 117 : 
                        int LA100_289 = input.LA(1);

                         
                        int index100_289 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_ObjCpp()) ) {s = 2;}

                        else if ( (synpred162_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_289);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 100, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA95_eotS =
        "\77\uffff";
    static final String DFA95_eofS =
        "\1\2\76\uffff";
    static final String DFA95_minS =
        "\1\4\1\0\75\uffff";
    static final String DFA95_maxS =
        "\1\142\1\0\75\uffff";
    static final String DFA95_acceptS =
        "\2\uffff\1\2\73\uffff\1\1";
    static final String DFA95_specialS =
        "\1\uffff\1\0\75\uffff}>";
    static final String[] DFA95_transitionS = {
            "\7\2\14\uffff\4\2\1\uffff\1\2\1\uffff\3\2\1\uffff\2\2\11\uffff"+
            "\3\2\5\uffff\1\2\4\uffff\23\2\16\uffff\2\2\1\1\5\2",
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

    static final short[] DFA95_eot = DFA.unpackEncodedString(DFA95_eotS);
    static final short[] DFA95_eof = DFA.unpackEncodedString(DFA95_eofS);
    static final char[] DFA95_min = DFA.unpackEncodedStringToUnsignedChars(DFA95_minS);
    static final char[] DFA95_max = DFA.unpackEncodedStringToUnsignedChars(DFA95_maxS);
    static final short[] DFA95_accept = DFA.unpackEncodedString(DFA95_acceptS);
    static final short[] DFA95_special = DFA.unpackEncodedString(DFA95_specialS);
    static final short[][] DFA95_transition;

    static {
        int numStates = DFA95_transitionS.length;
        DFA95_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA95_transition[i] = DFA.unpackEncodedString(DFA95_transitionS[i]);
        }
    }

    class DFA95 extends DFA {

        public DFA95(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 95;
            this.eot = DFA95_eot;
            this.eof = DFA95_eof;
            this.min = DFA95_min;
            this.max = DFA95_max;
            this.accept = DFA95_accept;
            this.special = DFA95_special;
            this.transition = DFA95_transition;
        }
        public String getDescription() {
            return "1160:37: ( 'else' statement )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA95_1 = input.LA(1);

                         
                        int index95_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 62;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index95_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 95, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA96_eotS =
        "\107\uffff";
    static final String DFA96_eofS =
        "\107\uffff";
    static final String DFA96_minS =
        "\1\4\33\uffff\1\4\14\uffff\1\4\1\0\2\uffff\1\0\7\uffff\12\0\6\uffff"+
        "\1\0\1\uffff";
    static final String DFA96_maxS =
        "\1\141\33\uffff\1\114\14\uffff\1\141\1\0\2\uffff\1\0\7\uffff\12"+
        "\0\6\uffff\1\0\1\uffff";
    static final String DFA96_acceptS =
        "\1\uffff\1\1\33\uffff\1\2\51\uffff";
    static final String DFA96_specialS =
        "\52\uffff\1\0\2\uffff\1\1\7\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1"+
        "\11\1\12\1\13\6\uffff\1\14\1\uffff}>";
    static final String[] DFA96_transitionS = {
            "\7\1\14\uffff\1\1\1\uffff\2\1\1\uffff\1\34\1\uffff\3\1\1\uffff"+
            "\1\1\12\uffff\3\1\5\uffff\1\1\4\uffff\23\1\16\uffff\2\1\1\uffff"+
            "\4\1",
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
            "",
            "",
            "\7\35\14\uffff\1\35\4\uffff\1\51\5\uffff\1\35\22\uffff\1\35"+
            "\24\uffff\3\35",
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
            "\1\71\1\76\1\55\1\72\1\73\1\74\1\75\14\uffff\1\52\1\uffff\2"+
            "\35\1\uffff\1\105\1\uffff\3\35\1\uffff\1\70\1\35\11\uffff\3"+
            "\35\5\uffff\1\66\4\uffff\20\35\1\65\2\67\16\uffff\2\35\1\uffff"+
            "\4\35",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            "\1\uffff",
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
            return "1163:13: ( statement )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA96_42 = input.LA(1);

                         
                        int index96_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred168_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_42);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA96_45 = input.LA(1);

                         
                        int index96_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred168_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_45);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA96_53 = input.LA(1);

                         
                        int index96_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred168_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_53);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA96_54 = input.LA(1);

                         
                        int index96_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred168_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_54);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA96_55 = input.LA(1);

                         
                        int index96_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred168_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_55);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA96_56 = input.LA(1);

                         
                        int index96_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred168_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_56);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA96_57 = input.LA(1);

                         
                        int index96_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred168_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_57);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA96_58 = input.LA(1);

                         
                        int index96_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred168_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_58);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA96_59 = input.LA(1);

                         
                        int index96_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred168_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_59);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA96_60 = input.LA(1);

                         
                        int index96_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred168_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_60);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA96_61 = input.LA(1);

                         
                        int index96_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred168_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_61);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA96_62 = input.LA(1);

                         
                        int index96_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred168_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_62);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA96_69 = input.LA(1);

                         
                        int index96_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred168_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_69);
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
        "\16\uffff";
    static final String DFA97_eofS =
        "\16\uffff";
    static final String DFA97_minS =
        "\1\4\15\uffff";
    static final String DFA97_maxS =
        "\1\114\15\uffff";
    static final String DFA97_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA97_specialS =
        "\16\uffff}>";
    static final String[] DFA97_transitionS = {
            "\7\1\14\uffff\1\1\4\uffff\1\15\5\uffff\1\1\22\uffff\1\1\24\uffff"+
            "\3\1",
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
            return "1163:28: ( expression )?";
        }
    }
    static final String DFA98_eotS =
        "\36\uffff";
    static final String DFA98_eofS =
        "\36\uffff";
    static final String DFA98_minS =
        "\1\4\35\uffff";
    static final String DFA98_maxS =
        "\1\141\35\uffff";
    static final String DFA98_acceptS =
        "\1\uffff\1\1\33\uffff\1\2";
    static final String DFA98_specialS =
        "\36\uffff}>";
    static final String[] DFA98_transitionS = {
            "\7\1\14\uffff\1\1\1\uffff\2\1\1\uffff\1\1\1\uffff\3\1\1\uffff"+
            "\1\1\1\35\11\uffff\3\1\5\uffff\1\1\4\uffff\23\1\16\uffff\2\1"+
            "\1\uffff\4\1",
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
            "",
            "",
            "",
            ""
    };

    static final short[] DFA98_eot = DFA.unpackEncodedString(DFA98_eotS);
    static final short[] DFA98_eof = DFA.unpackEncodedString(DFA98_eofS);
    static final char[] DFA98_min = DFA.unpackEncodedStringToUnsignedChars(DFA98_minS);
    static final char[] DFA98_max = DFA.unpackEncodedStringToUnsignedChars(DFA98_maxS);
    static final short[] DFA98_accept = DFA.unpackEncodedString(DFA98_acceptS);
    static final short[] DFA98_special = DFA.unpackEncodedString(DFA98_specialS);
    static final short[][] DFA98_transition;

    static {
        int numStates = DFA98_transitionS.length;
        DFA98_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA98_transition[i] = DFA.unpackEncodedString(DFA98_transitionS[i]);
        }
    }

    class DFA98 extends DFA {

        public DFA98(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 98;
            this.eot = DFA98_eot;
            this.eof = DFA98_eof;
            this.min = DFA98_min;
            this.max = DFA98_max;
            this.accept = DFA98_accept;
            this.special = DFA98_special;
            this.transition = DFA98_transition;
        }
        public String getDescription() {
            return "1163:44: ( statement )?";
        }
    }
    static final String DFA99_eotS =
        "\37\uffff";
    static final String DFA99_eofS =
        "\37\uffff";
    static final String DFA99_minS =
        "\1\4\36\uffff";
    static final String DFA99_maxS =
        "\1\142\36\uffff";
    static final String DFA99_acceptS =
        "\1\uffff\1\3\1\1\1\2\33\uffff";
    static final String DFA99_specialS =
        "\37\uffff}>";
    static final String[] DFA99_transitionS = {
            "\7\3\14\uffff\1\3\1\1\2\3\1\uffff\1\3\1\uffff\3\3\1\uffff\1"+
            "\3\12\uffff\3\3\5\uffff\1\3\4\uffff\23\3\16\uffff\2\3\1\uffff"+
            "\4\3\1\2",
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
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA99_eot = DFA.unpackEncodedString(DFA99_eotS);
    static final short[] DFA99_eof = DFA.unpackEncodedString(DFA99_eofS);
    static final char[] DFA99_min = DFA.unpackEncodedStringToUnsignedChars(DFA99_minS);
    static final char[] DFA99_max = DFA.unpackEncodedStringToUnsignedChars(DFA99_maxS);
    static final short[] DFA99_accept = DFA.unpackEncodedString(DFA99_acceptS);
    static final short[] DFA99_special = DFA.unpackEncodedString(DFA99_specialS);
    static final short[][] DFA99_transition;

    static {
        int numStates = DFA99_transitionS.length;
        DFA99_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA99_transition[i] = DFA.unpackEncodedString(DFA99_transitionS[i]);
        }
    }

    class DFA99 extends DFA {

        public DFA99(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 99;
            this.eot = DFA99_eot;
            this.eof = DFA99_eof;
            this.min = DFA99_min;
            this.max = DFA99_max;
            this.accept = DFA99_accept;
            this.special = DFA99_special;
            this.transition = DFA99_transition;
        }
        public String getDescription() {
            return "()* loopback of 1165:3: ( 'case' expression ':' | statement )*";
        }
    }
 

    public static final BitSet FOLLOW_22_in_lineDirective65 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_lineDirective69 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_STRING_in_lineDirective82 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_lineDirective97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_sourceFile126 = new BitSet(new long[]{0xFC00E001C6400040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_lineDirective_in_sourceFile135 = new BitSet(new long[]{0xFC00E001C6400040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_EOF_in_sourceFile146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_externDeclarations167 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_externDeclarations171 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_externDeclarations176 = new BitSet(new long[]{0xFC00E001C7000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_declaration_in_externDeclarations190 = new BitSet(new long[]{0xFC00E001C7000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_24_in_externDeclarations203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_declaration247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_declaration257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objCClassDef_in_declaration267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeDef_in_declaration277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forwardClassDecl_in_declaration287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_declaration297 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration301 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_declaration303 = new BitSet(new long[]{0xFC00E001C7000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_declaration_in_declaration321 = new BitSet(new long[]{0xFC00E001C7000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_24_in_declaration337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_forwardClassDecl377 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_forwardClassDecl384 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_forwardClassDecl391 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_forwardClassDecl398 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_28_in_forwardClassDecl409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRef_in_functionPointerVarDecl427 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_functionPointerVarDecl435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enumItem453 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_enumItem456 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_enumItem460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_enumCore484 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enumCore495 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_enumCore507 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_enumItem_in_enumCore514 = new BitSet(new long[]{0x0000000009000000L});
    public static final BitSet FOLLOW_27_in_enumCore527 = new BitSet(new long[]{0x0000000009000040L});
    public static final BitSet FOLLOW_enumItem_in_enumCore537 = new BitSet(new long[]{0x0000000009000000L});
    public static final BitSet FOLLOW_24_in_enumCore551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_objCClassDef578 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef589 = new BitSet(new long[]{0xFC00EE1640800040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_33_in_objCClassDef607 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef611 = new BitSet(new long[]{0xFC00EE1040800040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_34_in_objCClassDef626 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef630 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCClassDef632 = new BitSet(new long[]{0xFC00EE1040800040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_36_in_objCClassDef648 = new BitSet(new long[]{0x0000002000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef658 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_27_in_objCClassDef673 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef683 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_37_in_objCClassDef700 = new BitSet(new long[]{0xFC00EE0040800040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_23_in_objCClassDef714 = new BitSet(new long[]{0xF800E1C041000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_38_in_objCClassDef726 = new BitSet(new long[]{0xF800E1C041000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_39_in_objCClassDef737 = new BitSet(new long[]{0xF800E1C041000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_40_in_objCClassDef748 = new BitSet(new long[]{0xF800E1C041000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_varDecl_in_objCClassDef775 = new BitSet(new long[]{0xF800E1C041000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_functionPointerVarDecl_in_objCClassDef787 = new BitSet(new long[]{0xF800E1C041000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_24_in_objCClassDef814 = new BitSet(new long[]{0xFC00EE0040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_objCMethodDecl_in_objCClassDef832 = new BitSet(new long[]{0xFC00EE0040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_typeDef_in_objCClassDef841 = new BitSet(new long[]{0xFC00EE0040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_varDecl_in_objCClassDef852 = new BitSet(new long[]{0xFC00EE0040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_41_in_objCClassDef865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_objCMethodDecl899 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_43_in_objCMethodDecl911 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl930 = new BitSet(new long[]{0xF800E00840000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_typeRef_in_objCMethodDecl938 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl946 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl957 = new BitSet(new long[]{0x0000000210000000L});
    public static final BitSet FOLLOW_33_in_objCMethodDecl969 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl971 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_typeRef_in_objCMethodDecl975 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl977 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl981 = new BitSet(new long[]{0x0000000018000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl996 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodDecl998 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl1005 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_typeRef_in_objCMethodDecl1009 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl1011 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1020 = new BitSet(new long[]{0x0000000018000040L});
    public static final BitSet FOLLOW_27_in_objCMethodDecl1039 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_objCMethodDecl1041 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_objCMethodDecl1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_structCore1084 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_structCore1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exportationModifiers_in_structCore1136 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_structCore1149 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_structCore1163 = new BitSet(new long[]{0xFC07E001C7000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_48_in_structCore1184 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_49_in_structCore1197 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_50_in_structCore1210 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_structCore1222 = new BitSet(new long[]{0xFC07E001C7000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_declaration_in_structCore1231 = new BitSet(new long[]{0xFC07E001C7000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_24_in_structCore1245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRef_in_functionDeclaration1275 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_exportationModifiers_in_functionDeclaration1284 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionDeclaration1292 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionDeclaration1299 = new BitSet(new long[]{0xF800F00840000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_argList_in_functionDeclaration1305 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionDeclaration1311 = new BitSet(new long[]{0x0000000010800040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionDeclaration1320 = new BitSet(new long[]{0x0000000010800040L});
    public static final BitSet FOLLOW_exportationModifiers_in_functionDeclaration1329 = new BitSet(new long[]{0x0000000010800040L});
    public static final BitSet FOLLOW_28_in_functionDeclaration1341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_functionDeclaration1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_functionDefinition1365 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_functionDefinition1367 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_functionDefinition1369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exportationModifier_in_exportationModifiers1396 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier1423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_exportationModifier1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_exportationModifier1464 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_exportationModifier1472 = new BitSet(new long[]{0x0000000800000040L});
    public static final BitSet FOLLOW_extendedModifiers_in_exportationModifier1474 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_exportationModifier1476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_extendedModifiers1511 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_typeRef_in_argDef1547 = new BitSet(new long[]{0x0000000020000042L});
    public static final BitSet FOLLOW_IDENTIFIER_in_argDef1550 = new BitSet(new long[]{0x0020000020000002L});
    public static final BitSet FOLLOW_arrayTypeMutator_in_argDef1552 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_argDef1563 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_argDef1565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_argDef1579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_typeMutator1599 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_typeMutator1601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_typeMutator1609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_typeMutator1617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_typeMutator1626 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_typeMutator1628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_arrayTypeMutator1646 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_arrayTypeMutator1652 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_arrayTypeMutator1661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_typeRefCore1688 = new BitSet(new long[]{0xF800000000000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_modifier_in_typeRefCore1705 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_typeRef_in_typeRefCore1714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveTypeRef_in_typeRefCore1734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_typeRefCore1749 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_typeRefCore1767 = new BitSet(new long[]{0xF800E02040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_typeRef_in_typeRefCore1788 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_27_in_typeRefCore1809 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_typeRef_in_typeRefCore1822 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_37_in_typeRefCore1850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_templateDef1882 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_templateDef1884 = new BitSet(new long[]{0xF900402000000000L,0x00000000000003FFL});
    public static final BitSet FOLLOW_templateArgDecl_in_templateDef1887 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_27_in_templateDef1890 = new BitSet(new long[]{0xF900400000000000L,0x00000000000003FFL});
    public static final BitSet FOLLOW_templateArgDecl_in_templateDef1892 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_37_in_templateDef1899 = new BitSet(new long[]{0x0000E00000000000L});
    public static final BitSet FOLLOW_structCore_in_templateDef1903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDefinition_in_templateDef1907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveTypeRef_in_templateArgDecl1919 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_templateArgDecl1922 = new BitSet(new long[]{0x00000000000007B0L});
    public static final BitSet FOLLOW_constant_in_templateArgDecl1924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_templateArgDecl1931 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_templateArgDecl1939 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_templateArgDecl1942 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_typeRef_in_templateArgDecl1944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffix1963 = new BitSet(new long[]{0x0008000000000040L});
    public static final BitSet FOLLOW_exportationModifiers_in_functionSignatureSuffix1965 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_functionSignatureSuffix1967 = new BitSet(new long[]{0x0000000800000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionSignatureSuffix1969 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffix1972 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffix1978 = new BitSet(new long[]{0xF800F00840000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffix1987 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_27_in_functionSignatureSuffix2000 = new BitSet(new long[]{0xF800F00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffix2009 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffix2024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffixNoName2041 = new BitSet(new long[]{0x0008000000000040L});
    public static final BitSet FOLLOW_exportationModifiers_in_functionSignatureSuffixNoName2043 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_functionSignatureSuffixNoName2045 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffixNoName2047 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffixNoName2053 = new BitSet(new long[]{0xF800F00840000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffixNoName2062 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_27_in_functionSignatureSuffixNoName2075 = new BitSet(new long[]{0xF800F00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffixNoName2084 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffixNoName2099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structCore_in_structOrEnum2117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumCore_in_structOrEnum2125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefCore_in_typeRefCoreOrFuncSig2143 = new BitSet(new long[]{0x0038000400000042L});
    public static final BitSet FOLLOW_typeMutator_in_typeRefCoreOrFuncSig2160 = new BitSet(new long[]{0x0038000400000040L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_typeRefCoreOrFuncSig2173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefCore_in_typeRefCoreOrAnonymousFuncSig2197 = new BitSet(new long[]{0x0038000400000042L});
    public static final BitSet FOLLOW_typeMutator_in_typeRefCoreOrAnonymousFuncSig2214 = new BitSet(new long[]{0x0038000400000040L});
    public static final BitSet FOLLOW_functionSignatureSuffixNoName_in_typeRefCoreOrAnonymousFuncSig2227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structOrEnum_in_plainTypeRef2254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefCoreOrFuncSig_in_plainTypeRef2262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_declarator2291 = new BitSet(new long[]{0x0218000400000040L});
    public static final BitSet FOLLOW_set_in_declarator2328 = new BitSet(new long[]{0x0218000400000040L});
    public static final BitSet FOLLOW_declarator_in_declarator2347 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_directDeclarator_in_declarator2363 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_declarator2382 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_declarator2389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structCore_in_namedTypeRef2423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumCore_in_namedTypeRef2433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_typeDef2452 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_varDecl_in_typeDef2458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_varDeclEOF2478 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_varDeclEOF2480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_varDecl2517 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_modifier_in_varDecl2534 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_structOrEnum_in_varDecl2561 = new BitSet(new long[]{0x0218000410000040L});
    public static final BitSet FOLLOW_declaratorsList_in_varDecl2578 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_typeRefCoreOrAnonymousFuncSig_in_varDecl2598 = new BitSet(new long[]{0x0218000400000040L});
    public static final BitSet FOLLOW_declaratorsList_in_varDecl2608 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_varDecl2645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_objCProtocolRefList2659 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCProtocolRefList2664 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_27_in_objCProtocolRefList2674 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCProtocolRefList2680 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_37_in_objCProtocolRefList2690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarator_in_declaratorsList2717 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_declaratorsList2730 = new BitSet(new long[]{0x0218000400000040L});
    public static final BitSet FOLLOW_declarator_in_declaratorsList2739 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_directDeclarator2782 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_34_in_directDeclarator2792 = new BitSet(new long[]{0x0218000400000040L});
    public static final BitSet FOLLOW_modifier_in_directDeclarator2801 = new BitSet(new long[]{0x0218000400000040L});
    public static final BitSet FOLLOW_declarator_in_directDeclarator2812 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_directDeclarator2818 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_53_in_directDeclarator2833 = new BitSet(new long[]{0x00600004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_directDeclarator2845 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_directDeclarator2861 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_34_in_directDeclarator2869 = new BitSet(new long[]{0xF800F00840000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_argList_in_directDeclarator2871 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_directDeclarator2873 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_argDef_in_argList2906 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_argList2919 = new BitSet(new long[]{0xF800F00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_argDef_in_argList2928 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_argList2948 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_argList2950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plainTypeRef_in_typeRef2984 = new BitSet(new long[]{0x0038000000000042L});
    public static final BitSet FOLLOW_typeMutator_in_typeRef2995 = new BitSet(new long[]{0x0038000000000042L});
    public static final BitSet FOLLOW_set_in_primSignModifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_primSizeModifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_primitiveTypeName0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primSignModifier_in_primitiveTypeRef3134 = new BitSet(new long[]{0xF800000000000000L,0x00000000000003FFL});
    public static final BitSet FOLLOW_primSizeModifier_in_primitiveTypeRef3145 = new BitSet(new long[]{0xF800000000000000L,0x00000000000003FFL});
    public static final BitSet FOLLOW_primSizeModifier_in_primitiveTypeRef3152 = new BitSet(new long[]{0xF800000000000000L,0x00000000000003FFL});
    public static final BitSet FOLLOW_primitiveTypeName_in_primitiveTypeRef3195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_objCMethodCall3234 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3238 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodCall3242 = new BitSet(new long[]{0x0040000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodCall3253 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3257 = new BitSet(new long[]{0x0040000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodCall3272 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodCall3274 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3278 = new BitSet(new long[]{0x0040000000000040L});
    public static final BitSet FOLLOW_54_in_objCMethodCall3295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_functionCall3315 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionCall3317 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_typeRef_in_functionCall3319 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionCall3321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionCall3329 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionCall3331 = new BitSet(new long[]{0x0020000C008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_functionCall3344 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_27_in_functionCall3353 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_functionCall3362 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_35_in_functionCall3380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_expression3402 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_functionCall_in_expression3413 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_objCMethodCall_in_expression3422 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_set_in_expression3433 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_expression3443 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_34_in_expression3452 = new BitSet(new long[]{0xF820E004408007F0L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expression_in_expression3462 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_expression3464 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_typeRef_in_expression3474 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_expression3476 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_expression3480 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_constant_in_expression3495 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_23_in_expression3504 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_expression3506 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_expression3508 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_set_in_expression3524 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_expression3618 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_29_in_expression3627 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_expression3631 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_89_in_expression3640 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_expression3644 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_33_in_expression3656 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_expression3658 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_43_in_expression3662 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_expression3664 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_89_in_expression3668 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_functionCall_in_expression3673 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_90_in_expression3682 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_expression3686 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_expression3688 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_expression3692 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_23_in_statementsBlock3713 = new BitSet(new long[]{0xFC20E005D78007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statementsBlock3715 = new BitSet(new long[]{0xFC20E005D78007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_24_in_statementsBlock3718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_statement3731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_statement3737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement3743 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_statement3746 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3748 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_statement3759 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3761 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_statement3769 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3771 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3773 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3775 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3777 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_statement3780 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_statement3790 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3792 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3794 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3796 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_statement3804 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3806 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_statement3808 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3810 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3812 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3814 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_statement3822 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3824 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3826 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3829 = new BitSet(new long[]{0x00200004108007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3831 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3834 = new BitSet(new long[]{0xFC20E00DD68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3836 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3839 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_statement3847 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3849 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3851 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3853 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_statement3855 = new BitSet(new long[]{0xFC20E005D78007F0L,0x00000007D8001FFFL});
    public static final BitSet FOLLOW_98_in_statement3861 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3863 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement3865 = new BitSet(new long[]{0xFC20E005D78007F0L,0x00000007D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3872 = new BitSet(new long[]{0xFC20E005D78007F0L,0x00000007D8001FFFL});
    public static final BitSet FOLLOW_24_in_statement3881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_statement3887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement3895 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3897 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_varDecl_in_statement3899 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement3901 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3903 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3905 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_constant3923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEXADECIMAL_NUMBER_in_constant3931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OCTAL_NUMBER_in_constant3939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARACTER_in_constant3947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_NUMBER_in_constant3955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_constant3966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_synpred6_ObjCpp247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred7_ObjCpp257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred26_ObjCpp775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred40_ObjCpp1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exportationModifiers_in_synpred41_ObjCpp1136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRef_in_synpred47_ObjCpp1275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred48_ObjCpp1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exportationModifier_in_synpred50_ObjCpp1396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred60_ObjCpp1688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred61_ObjCpp1705 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_typeRef_in_synpred61_ObjCpp1714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred78_ObjCpp2160 = new BitSet(new long[]{0x0038000400000040L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_synpred78_ObjCpp2173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred80_ObjCpp2214 = new BitSet(new long[]{0x0038000400000040L});
    public static final BitSet FOLLOW_functionSignatureSuffixNoName_in_synpred80_ObjCpp2227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred82_ObjCpp2291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred86_ObjCpp2382 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_synpred86_ObjCpp2389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred88_ObjCpp2517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred89_ObjCpp2534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred95_ObjCpp2801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_synpred99_ObjCpp2919 = new BitSet(new long[]{0xF800F00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_argDef_in_synpred99_ObjCpp2928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred102_ObjCpp2995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred130_ObjCpp3462 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred130_ObjCpp3464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred151_ObjCpp3524 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_synpred151_ObjCpp3618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred152_ObjCpp3627 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_synpred152_ObjCpp3631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_synpred153_ObjCpp3640 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred153_ObjCpp3644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_synpred156_ObjCpp3656 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_synpred156_ObjCpp3658 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_43_in_synpred156_ObjCpp3662 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_synpred156_ObjCpp3664 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_89_in_synpred156_ObjCpp3668 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_functionCall_in_synpred156_ObjCpp3673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_synpred157_ObjCpp3682 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_synpred157_ObjCpp3686 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_synpred157_ObjCpp3688 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_synpred157_ObjCpp3692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_synpred159_ObjCpp3731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_synpred160_ObjCpp3737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred162_ObjCpp3743 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_synpred162_ObjCpp3746 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_synpred162_ObjCpp3748 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_synpred162_ObjCpp3753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_synpred164_ObjCpp3780 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_synpred164_ObjCpp3782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_synpred168_ObjCpp3826 = new BitSet(new long[]{0x0000000000000002L});

}