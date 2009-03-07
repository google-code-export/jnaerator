// $ANTLR 3.1.2 /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g 2009-03-07 00:07:18
 
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

                if ( (LA36_1==34) ) {
                    alt36=2;
                }
                else if ( (LA36_1==EOF||LA36_1==IDENTIFIER||LA36_1==23||LA36_1==28||LA36_1==51) ) {
                    alt36=1;
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

    public static class plainTypeRef_return extends ParserRuleReturnScope {
        public TypeRef type;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "plainTypeRef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:708:1: plainTypeRef returns [TypeRef type] : ( structCore | enumCore | typeRefCore ( ( typeMutator )* functionSignatureSuffix )? );
    public final ObjCppParser.plainTypeRef_return plainTypeRef() throws RecognitionException {
        ObjCppParser.plainTypeRef_return retval = new ObjCppParser.plainTypeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.structCore_return structCore115 = null;

        ObjCppParser.enumCore_return enumCore116 = null;

        ObjCppParser.typeRefCore_return typeRefCore117 = null;

        ObjCppParser.typeMutator_return typeMutator118 = null;

        ObjCppParser.functionSignatureSuffix_return functionSignatureSuffix119 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:709:2: ( structCore | enumCore | typeRefCore ( ( typeMutator )* functionSignatureSuffix )? )
            int alt58=3;
            switch ( input.LA(1) ) {
            case 45:
            case 46:
            case 47:
                {
                alt58=1;
                }
                break;
            case 30:
                {
                alt58=2;
                }
                break;
            case IDENTIFIER:
            case 59:
            case 60:
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
            case 73:
                {
                alt58=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:710:3: structCore
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_structCore_in_plainTypeRef2042);
                    structCore115=structCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structCore115.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (structCore115!=null?structCore115.struct:null); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:711:3: enumCore
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_enumCore_in_plainTypeRef2050);
                    enumCore116=enumCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, enumCore116.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (enumCore116!=null?enumCore116.e:null); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:712:3: typeRefCore ( ( typeMutator )* functionSignatureSuffix )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_typeRefCore_in_plainTypeRef2058);
                    typeRefCore117=typeRefCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRefCore117.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (typeRefCore117!=null?typeRefCore117.type:null); 
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:713:3: ( ( typeMutator )* functionSignatureSuffix )?
                    int alt57=2;
                    alt57 = dfa57.predict(input);
                    switch (alt57) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:714:4: ( typeMutator )* functionSignatureSuffix
                            {
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:714:4: ( typeMutator )*
                            loop56:
                            do {
                                int alt56=2;
                                int LA56_0 = input.LA(1);

                                if ( (LA56_0==IDENTIFIER||(LA56_0>=51 && LA56_0<=53)) ) {
                                    alt56=1;
                                }


                                switch (alt56) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:715:5: typeMutator
                            	    {
                            	    pushFollow(FOLLOW_typeMutator_in_plainTypeRef2075);
                            	    typeMutator118=typeMutator();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeMutator118.getTree());
                            	    if ( state.backtracking==0 ) {

                            	      					retval.type = (typeMutator118!=null?typeMutator118.mutator:null).mutateType(retval.type);
                            	      				
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop56;
                                }
                            } while (true);

                            pushFollow(FOLLOW_functionSignatureSuffix_in_plainTypeRef2088);
                            functionSignatureSuffix119=functionSignatureSuffix();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, functionSignatureSuffix119.getTree());
                            if ( state.backtracking==0 ) {
                               
                              				(functionSignatureSuffix119!=null?functionSignatureSuffix119.signature:null).getFunction().setValueType(retval.type); 
                              				retval.type = (functionSignatureSuffix119!=null?functionSignatureSuffix119.signature:null);
                              			
                            }

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
    // $ANTLR end "plainTypeRef"

    public static class declarator_return extends ParserRuleReturnScope {
        public Declarator declarator;
        public List<Modifier> modifiers;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declarator"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:726:1: declarator returns [Declarator declarator, List<Modifier> modifiers] : ({...}? modifier )* ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? ) ;
    public final ObjCppParser.declarator_return declarator() throws RecognitionException {
        ObjCppParser.declarator_return retval = new ObjCppParser.declarator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token pt=null;
        Token char_literal122=null;
        ObjCppParser.declarator_return inner = null;

        ObjCppParser.modifier_return modifier120 = null;

        ObjCppParser.directDeclarator_return directDeclarator121 = null;

        ObjCppParser.expression_return expression123 = null;


        Object pt_tree=null;
        Object char_literal122_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:727:2: ( ({...}? modifier )* ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:727:4: ({...}? modifier )* ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:728:3: ({...}? modifier )*
            loop59:
            do {
                int alt59=2;
                alt59 = dfa59.predict(input);
                switch (alt59) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:729:4: {...}? modifier
            	    {
            	    if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "declarator", " next(Modifier.Kind.TypeQualifier) ");
            	    }
            	    pushFollow(FOLLOW_modifier_in_declarator2122);
            	    modifier120=modifier();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, modifier120.getTree());
            	    if ( state.backtracking==0 ) {

            	      				retval.modifiers.add((modifier120!=null?modifier120.modifier:null));
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:736:3: ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:737:4: ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )?
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:737:4: ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( ((LA60_0>=51 && LA60_0<=52)||LA60_0==57) ) {
                alt60=1;
            }
            else if ( (LA60_0==IDENTIFIER||LA60_0==34) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:738:5: (pt= ( '*' | '&' | '^' ) inner= declarator )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:738:5: (pt= ( '*' | '&' | '^' ) inner= declarator )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:739:6: pt= ( '*' | '&' | '^' ) inner= declarator
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

                    pushFollow(FOLLOW_declarator_in_declarator2178);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:744:5: directDeclarator
                    {
                    pushFollow(FOLLOW_directDeclarator_in_declarator2194);
                    directDeclarator121=directDeclarator();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, directDeclarator121.getTree());
                    if ( state.backtracking==0 ) {
                       
                      					retval.declarator = (directDeclarator121!=null?directDeclarator121.declarator:null); 
                      				
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:748:4: ( '=' expression )?
            int alt61=2;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:749:5: '=' expression
                    {
                    char_literal122=(Token)match(input,29,FOLLOW_29_in_declarator2213); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal122_tree = (Object)adaptor.create(char_literal122);
                    adaptor.addChild(root_0, char_literal122_tree);
                    }
                    pushFollow(FOLLOW_expression_in_declarator2220);
                    expression123=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression123.getTree());
                    if ( state.backtracking==0 ) {

                      					retval.declarator.setDefaultValue((expression123!=null?expression123.expr:null));
                      				
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:761:1: namedTypeRef returns [TaggedTypeRef type] : ( structCore {...}? | enumCore {...}?);
    public final ObjCppParser.namedTypeRef_return namedTypeRef() throws RecognitionException {
        ObjCppParser.namedTypeRef_return retval = new ObjCppParser.namedTypeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.structCore_return structCore124 = null;

        ObjCppParser.enumCore_return enumCore125 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:762:2: ( structCore {...}? | enumCore {...}?)
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( ((LA62_0>=45 && LA62_0<=47)) ) {
                alt62=1;
            }
            else if ( (LA62_0==30) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:763:3: structCore {...}?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_structCore_in_namedTypeRef2254);
                    structCore124=structCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structCore124.getTree());
                    if ( !(( (structCore124!=null?structCore124.struct:null).getTag() != null )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "namedTypeRef", " $structCore.struct.getTag() != null ");
                    }
                    if ( state.backtracking==0 ) {

                      			retval.type = (structCore124!=null?structCore124.struct:null);
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:766:3: enumCore {...}?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_enumCore_in_namedTypeRef2264);
                    enumCore125=enumCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, enumCore125.getTree());
                    if ( !(( (enumCore125!=null?enumCore125.e:null).getTag() != null )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "namedTypeRef", " $enumCore.e.getTag() != null ");
                    }
                    if ( state.backtracking==0 ) {

                      			retval.type = (enumCore125!=null?enumCore125.e:null);
                      		
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:771:1: typeDef returns [TypeDef typeDef] : 'typedef' varDecl {...}?;
    public final ObjCppParser.typeDef_return typeDef() throws RecognitionException {
        ObjCppParser.typeDef_return retval = new ObjCppParser.typeDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal126=null;
        ObjCppParser.varDecl_return varDecl127 = null;


        Object string_literal126_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:772:2: ( 'typedef' varDecl {...}?)
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:772:4: 'typedef' varDecl {...}?
            {
            root_0 = (Object)adaptor.nil();

            string_literal126=(Token)match(input,58,FOLLOW_58_in_typeDef2283); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal126_tree = (Object)adaptor.create(string_literal126);
            adaptor.addChild(root_0, string_literal126_tree);
            }
            pushFollow(FOLLOW_varDecl_in_typeDef2289);
            varDecl127=varDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl127.getTree());
            if ( !(( 
            			((varDecl127!=null?varDecl127.decl:null) instanceof VariablesDeclaration) 
            		)) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "typeDef", " \n\t\t\t($varDecl.decl instanceof VariablesDeclaration) \n\t\t");
            }
            if ( state.backtracking==0 ) {

              			VariablesDeclaration vd = (VariablesDeclaration)(varDecl127!=null?varDecl127.decl:null);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:781:1: varDeclEOF returns [Declaration decl] : varDecl EOF ;
    public final ObjCppParser.varDeclEOF_return varDeclEOF() throws RecognitionException {
        ObjCppParser.varDeclEOF_return retval = new ObjCppParser.varDeclEOF_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF129=null;
        ObjCppParser.varDecl_return varDecl128 = null;


        Object EOF129_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:782:2: ( varDecl EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:782:4: varDecl EOF
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_varDecl_in_varDeclEOF2309);
            varDecl128=varDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl128.getTree());
            EOF129=(Token)match(input,EOF,FOLLOW_EOF_in_varDeclEOF2311); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EOF129_tree = (Object)adaptor.create(EOF129);
            adaptor.addChild(root_0, EOF129_tree);
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

    public static class varDecl_return extends ParserRuleReturnScope {
        public Declaration decl;
        public TypeRef type;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "varDecl"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:785:1: varDecl returns [Declaration decl, TypeRef type] : ({...}?sm= modifier | {...}?tm= modifier )* ( ( plainTypeRef declaratorsList ) ) ';' ;
    public final ObjCppParser.varDecl_return varDecl() throws RecognitionException {
        ObjCppParser.varDecl_return retval = new ObjCppParser.varDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal132=null;
        ObjCppParser.modifier_return sm = null;

        ObjCppParser.modifier_return tm = null;

        ObjCppParser.plainTypeRef_return plainTypeRef130 = null;

        ObjCppParser.declaratorsList_return declaratorsList131 = null;


        Object char_literal132_tree=null;


        	List<Modifier> stoMods = new ArrayList<Modifier>(), typMods = new ArrayList<Modifier>();

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:789:2: ( ({...}?sm= modifier | {...}?tm= modifier )* ( ( plainTypeRef declaratorsList ) ) ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:789:4: ({...}?sm= modifier | {...}?tm= modifier )* ( ( plainTypeRef declaratorsList ) ) ';'
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:789:4: ({...}?sm= modifier | {...}?tm= modifier )*
            loop63:
            do {
                int alt63=3;
                alt63 = dfa63.predict(input);
                switch (alt63) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:790:4: {...}?sm= modifier
            	    {
            	    if ( !(( next(Modifier.Kind.StorageClassSpecifier) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "varDecl", " next(Modifier.Kind.StorageClassSpecifier) ");
            	    }
            	    pushFollow(FOLLOW_modifier_in_varDecl2348);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:792:4: {...}?tm= modifier
            	    {
            	    if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "varDecl", " next(Modifier.Kind.TypeQualifier) ");
            	    }
            	    pushFollow(FOLLOW_modifier_in_varDecl2365);
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
            	    break loop63;
                }
            } while (true);

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:795:3: ( ( plainTypeRef declaratorsList ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:799:4: ( plainTypeRef declaratorsList )
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:799:4: ( plainTypeRef declaratorsList )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:800:5: plainTypeRef declaratorsList
            {
            pushFollow(FOLLOW_plainTypeRef_in_varDecl2392);
            plainTypeRef130=plainTypeRef();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, plainTypeRef130.getTree());
            if ( state.backtracking==0 ) {
               retval.type = (plainTypeRef130!=null?plainTypeRef130.type:null); 
            }
            pushFollow(FOLLOW_declaratorsList_in_varDecl2406);
            declaratorsList131=declaratorsList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, declaratorsList131.getTree());
            if ( state.backtracking==0 ) {

              					retval.decl = new VariablesDeclaration(retval.type, (declaratorsList131!=null?declaratorsList131.declarators:null));
              				
            }

            }


            }

            char_literal132=(Token)match(input,28,FOLLOW_28_in_varDecl2421); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal132_tree = (Object)adaptor.create(char_literal132);
            adaptor.addChild(root_0, char_literal132_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:823:1: objCProtocolRefList : '<' IDENTIFIER ( ',' IDENTIFIER )* '>' ;
    public final ObjCppParser.objCProtocolRefList_return objCProtocolRefList() throws RecognitionException {
        ObjCppParser.objCProtocolRefList_return retval = new ObjCppParser.objCProtocolRefList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal133=null;
        Token IDENTIFIER134=null;
        Token char_literal135=null;
        Token IDENTIFIER136=null;
        Token char_literal137=null;

        Object char_literal133_tree=null;
        Object IDENTIFIER134_tree=null;
        Object char_literal135_tree=null;
        Object IDENTIFIER136_tree=null;
        Object char_literal137_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:824:2: ( '<' IDENTIFIER ( ',' IDENTIFIER )* '>' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:824:4: '<' IDENTIFIER ( ',' IDENTIFIER )* '>'
            {
            root_0 = (Object)adaptor.nil();

            char_literal133=(Token)match(input,36,FOLLOW_36_in_objCProtocolRefList2435); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal133_tree = (Object)adaptor.create(char_literal133);
            adaptor.addChild(root_0, char_literal133_tree);
            }
            IDENTIFIER134=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCProtocolRefList2440); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER134_tree = (Object)adaptor.create(IDENTIFIER134);
            adaptor.addChild(root_0, IDENTIFIER134_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:826:3: ( ',' IDENTIFIER )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==27) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:827:4: ',' IDENTIFIER
            	    {
            	    char_literal135=(Token)match(input,27,FOLLOW_27_in_objCProtocolRefList2450); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal135_tree = (Object)adaptor.create(char_literal135);
            	    adaptor.addChild(root_0, char_literal135_tree);
            	    }
            	    IDENTIFIER136=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCProtocolRefList2456); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDENTIFIER136_tree = (Object)adaptor.create(IDENTIFIER136);
            	    adaptor.addChild(root_0, IDENTIFIER136_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);

            char_literal137=(Token)match(input,37,FOLLOW_37_in_objCProtocolRefList2466); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal137_tree = (Object)adaptor.create(char_literal137);
            adaptor.addChild(root_0, char_literal137_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:840:1: declaratorsList returns [List<Declarator> declarators] : (d= declarator ( ',' x= declarator )* )? ;
    public final ObjCppParser.declaratorsList_return declaratorsList() throws RecognitionException {
        ObjCppParser.declaratorsList_return retval = new ObjCppParser.declaratorsList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal138=null;
        ObjCppParser.declarator_return d = null;

        ObjCppParser.declarator_return x = null;


        Object char_literal138_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:841:2: ( (d= declarator ( ',' x= declarator )* )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:841:4: (d= declarator ( ',' x= declarator )* )?
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.declarators = new ArrayList<Declarator>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:842:3: (d= declarator ( ',' x= declarator )* )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==IDENTIFIER||LA66_0==34||(LA66_0>=51 && LA66_0<=52)||LA66_0==57) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:843:4: d= declarator ( ',' x= declarator )*
                    {
                    pushFollow(FOLLOW_declarator_in_declaratorsList2493);
                    d=declarator();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());
                    if ( state.backtracking==0 ) {
                       retval.declarators.add((d!=null?d.declarator:null)); 
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:844:4: ( ',' x= declarator )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==27) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:845:5: ',' x= declarator
                    	    {
                    	    char_literal138=(Token)match(input,27,FOLLOW_27_in_declaratorsList2506); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal138_tree = (Object)adaptor.create(char_literal138);
                    	    adaptor.addChild(root_0, char_literal138_tree);
                    	    }
                    	    pushFollow(FOLLOW_declarator_in_declaratorsList2515);
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
                    	    break loop65;
                        }
                    } while (true);


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
    // $ANTLR end "declaratorsList"

    public static class directDeclarator_return extends ParserRuleReturnScope {
        public Declarator declarator;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "directDeclarator"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:851:1: directDeclarator returns [Declarator declarator] : ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' ) ( '[' ( expression | ) ']' | '(' argList ')' )* ;
    public final ObjCppParser.directDeclarator_return directDeclarator() throws RecognitionException {
        ObjCppParser.directDeclarator_return retval = new ObjCppParser.directDeclarator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER139=null;
        Token char_literal140=null;
        Token char_literal141=null;
        Token char_literal142=null;
        Token char_literal144=null;
        Token char_literal145=null;
        Token char_literal147=null;
        ObjCppParser.modifier_return im = null;

        ObjCppParser.declarator_return inner = null;

        ObjCppParser.expression_return expression143 = null;

        ObjCppParser.argList_return argList146 = null;


        Object IDENTIFIER139_tree=null;
        Object char_literal140_tree=null;
        Object char_literal141_tree=null;
        Object char_literal142_tree=null;
        Object char_literal144_tree=null;
        Object char_literal145_tree=null;
        Object char_literal147_tree=null;


        	List<Modifier> modifiers = new ArrayList<Modifier>();

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:855:2: ( ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' ) ( '[' ( expression | ) ']' | '(' argList ')' )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:855:4: ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' ) ( '[' ( expression | ) ']' | '(' argList ')' )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:855:4: ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==IDENTIFIER) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:857:4: IDENTIFIER
                    {
                    IDENTIFIER139=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_directDeclarator2559); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER139_tree = (Object)adaptor.create(IDENTIFIER139);
                    adaptor.addChild(root_0, IDENTIFIER139_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				retval.declarator = new DirectDeclarator((IDENTIFIER139!=null?IDENTIFIER139.getText():null));
                      			
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:860:4: '(' (im= modifier )* inner= declarator ')'
                    {
                    char_literal140=(Token)match(input,34,FOLLOW_34_in_directDeclarator2569); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal140_tree = (Object)adaptor.create(char_literal140);
                    adaptor.addChild(root_0, char_literal140_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:861:4: (im= modifier )*
                    loop67:
                    do {
                        int alt67=2;
                        alt67 = dfa67.predict(input);
                        switch (alt67) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:861:5: im= modifier
                    	    {
                    	    pushFollow(FOLLOW_modifier_in_directDeclarator2578);
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
                    	    break loop67;
                        }
                    } while (true);

                    pushFollow(FOLLOW_declarator_in_directDeclarator2589);
                    inner=declarator();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inner.getTree());
                    char_literal141=(Token)match(input,35,FOLLOW_35_in_directDeclarator2595); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal141_tree = (Object)adaptor.create(char_literal141);
                    adaptor.addChild(root_0, char_literal141_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				retval.declarator = (inner!=null?inner.declarator:null);
                      				retval.declarator.setParenthesized(true);
                      				retval.declarator.addModifiers(modifiers);
                      			
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:869:3: ( '[' ( expression | ) ']' | '(' argList ')' )*
            loop70:
            do {
                int alt70=3;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==53) ) {
                    alt70=1;
                }
                else if ( (LA70_0==34) ) {
                    alt70=2;
                }


                switch (alt70) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:870:4: '[' ( expression | ) ']'
            	    {
            	    char_literal142=(Token)match(input,53,FOLLOW_53_in_directDeclarator2610); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal142_tree = (Object)adaptor.create(char_literal142);
            	    adaptor.addChild(root_0, char_literal142_tree);
            	    }
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:871:4: ( expression | )
            	    int alt69=2;
            	    alt69 = dfa69.predict(input);
            	    switch (alt69) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:872:5: expression
            	            {
            	            pushFollow(FOLLOW_expression_in_directDeclarator2622);
            	            expression143=expression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression143.getTree());
            	            if ( state.backtracking==0 ) {

            	              					if (retval.declarator instanceof ArrayDeclarator)
            	              						((ArrayDeclarator)retval.declarator).addDimension((expression143!=null?expression143.expr:null));
            	              					else
            	              						retval.declarator = new ArrayDeclarator(retval.declarator, (expression143!=null?expression143.expr:null));
            	              				
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:877:9: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              					retval.declarator = new ArrayDeclarator(retval.declarator, new Expression.EmptyArraySize());
            	              				
            	            }

            	            }
            	            break;

            	    }

            	    char_literal144=(Token)match(input,54,FOLLOW_54_in_directDeclarator2638); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal144_tree = (Object)adaptor.create(char_literal144);
            	    adaptor.addChild(root_0, char_literal144_tree);
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:882:4: '(' argList ')'
            	    {
            	    char_literal145=(Token)match(input,34,FOLLOW_34_in_directDeclarator2646); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal145_tree = (Object)adaptor.create(char_literal145);
            	    adaptor.addChild(root_0, char_literal145_tree);
            	    }
            	    pushFollow(FOLLOW_argList_in_directDeclarator2648);
            	    argList146=argList();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, argList146.getTree());
            	    char_literal147=(Token)match(input,35,FOLLOW_35_in_directDeclarator2650); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal147_tree = (Object)adaptor.create(char_literal147);
            	    adaptor.addChild(root_0, char_literal147_tree);
            	    }
            	    if ( state.backtracking==0 ) {

            	      				retval.declarator = new FunctionDeclarator(retval.declarator, (argList146!=null?argList146.args:null));
            	      			
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:888:1: argList returns [List<Arg> args, boolean isObjC] : (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? ;
    public final ObjCppParser.argList_return argList() throws RecognitionException {
        ObjCppParser.argList_return retval = new ObjCppParser.argList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal148=null;
        Token char_literal149=null;
        Token string_literal150=null;
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        Object char_literal148_tree=null;
        Object char_literal149_tree=null;
        Object string_literal150_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:889:2: ( (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:889:4: (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )?
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               
              			retval.isObjC = false; 
              			retval.args = new ArrayList<Arg>();
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:893:3: (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==IDENTIFIER||LA73_0==30||(LA73_0>=44 && LA73_0<=47)||(LA73_0>=59 && LA73_0<=73)) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:894:4: a1= argDef ( ',' ax= argDef )* ( ',' '...' )?
                    {
                    pushFollow(FOLLOW_argDef_in_argList2683);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {

                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					retval.args.add((a1!=null?a1.arg:null));
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:898:4: ( ',' ax= argDef )*
                    loop71:
                    do {
                        int alt71=2;
                        alt71 = dfa71.predict(input);
                        switch (alt71) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:899:5: ',' ax= argDef
                    	    {
                    	    char_literal148=(Token)match(input,27,FOLLOW_27_in_argList2696); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal148_tree = (Object)adaptor.create(char_literal148);
                    	    adaptor.addChild(root_0, char_literal148_tree);
                    	    }
                    	    pushFollow(FOLLOW_argDef_in_argList2705);
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

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:904:4: ( ',' '...' )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==27) ) {
                        alt72=1;
                    }
                    switch (alt72) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:905:5: ',' '...'
                            {
                            char_literal149=(Token)match(input,27,FOLLOW_27_in_argList2725); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal149_tree = (Object)adaptor.create(char_literal149);
                            adaptor.addChild(root_0, char_literal149_tree);
                            }
                            string_literal150=(Token)match(input,44,FOLLOW_44_in_argList2727); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal150_tree = (Object)adaptor.create(string_literal150);
                            adaptor.addChild(root_0, string_literal150_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:914:1: typeRef returns [TypeRef type] : plainTypeRef ( typeMutator )* ;
    public final ObjCppParser.typeRef_return typeRef() throws RecognitionException {
        ObjCppParser.typeRef_return retval = new ObjCppParser.typeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.plainTypeRef_return plainTypeRef151 = null;

        ObjCppParser.typeMutator_return typeMutator152 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:915:2: ( plainTypeRef ( typeMutator )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:916:3: plainTypeRef ( typeMutator )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_plainTypeRef_in_typeRef2761);
            plainTypeRef151=plainTypeRef();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, plainTypeRef151.getTree());
            if ( state.backtracking==0 ) {

              			retval.type = (plainTypeRef151!=null?plainTypeRef151.type:null);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:919:3: ( typeMutator )*
            loop74:
            do {
                int alt74=2;
                alt74 = dfa74.predict(input);
                switch (alt74) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:920:4: typeMutator
            	    {
            	    pushFollow(FOLLOW_typeMutator_in_typeRef2772);
            	    typeMutator152=typeMutator();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeMutator152.getTree());
            	    if ( state.backtracking==0 ) {

            	      				retval.type = (typeMutator152!=null?typeMutator152.mutator:null).mutateType(retval.type);
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop74;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:926:1: primSignModifier : ( 'signed' | 'unsigned' | '__signed' | '__unsigned' );
    public final ObjCppParser.primSignModifier_return primSignModifier() throws RecognitionException {
        ObjCppParser.primSignModifier_return retval = new ObjCppParser.primSignModifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set153=null;

        Object set153_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:927:2: ( 'signed' | 'unsigned' | '__signed' | '__unsigned' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:
            {
            root_0 = (Object)adaptor.nil();

            set153=(Token)input.LT(1);
            if ( (input.LA(1)>=59 && input.LA(1)<=62) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set153));
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:929:1: primSizeModifier : ( 'long' | 'short' );
    public final ObjCppParser.primSizeModifier_return primSizeModifier() throws RecognitionException {
        ObjCppParser.primSizeModifier_return retval = new ObjCppParser.primSizeModifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set154=null;

        Object set154_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:930:2: ( 'long' | 'short' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:
            {
            root_0 = (Object)adaptor.nil();

            set154=(Token)input.LT(1);
            if ( (input.LA(1)>=63 && input.LA(1)<=64) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set154));
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:932:1: primitiveTypeName : ( 'long' | 'int' | 'short' | 'double' | 'float' | 'char' | 'void' | '__int8' | '__int16' | '__int32' | '__int64' );
    public final ObjCppParser.primitiveTypeName_return primitiveTypeName() throws RecognitionException {
        ObjCppParser.primitiveTypeName_return retval = new ObjCppParser.primitiveTypeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set155=null;

        Object set155_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:933:2: ( 'long' | 'int' | 'short' | 'double' | 'float' | 'char' | 'void' | '__int8' | '__int16' | '__int32' | '__int64' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:
            {
            root_0 = (Object)adaptor.nil();

            set155=(Token)input.LT(1);
            if ( (input.LA(1)>=63 && input.LA(1)<=73) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set155));
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:945:1: primitiveTypeRef returns [TypeRef type, int line, List<Modifier> modifiers] : ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) ) ;
    public final ObjCppParser.primitiveTypeRef_return primitiveTypeRef() throws RecognitionException {
        ObjCppParser.primitiveTypeRef_return retval = new ObjCppParser.primitiveTypeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.primSignModifier_return mod1 = null;

        ObjCppParser.primSizeModifier_return mod2 = null;

        ObjCppParser.primSizeModifier_return mod3 = null;

        ObjCppParser.primitiveTypeName_return name = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:946:2: ( ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:946:4: ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               
              			retval.line = getLine(); 
              			retval.modifiers = new ArrayList<Modifier>();
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:950:3: ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:951:4: (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName )
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:951:8: (mod1= primSignModifier )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( ((LA75_0>=59 && LA75_0<=62)) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: mod1= primSignModifier
                    {
                    pushFollow(FOLLOW_primSignModifier_in_primitiveTypeRef2911);
                    mod1=primSignModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mod1.getTree());

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:952:4: (mod2= primSizeModifier (mod3= primSizeModifier )? )?
            int alt77=2;
            alt77 = dfa77.predict(input);
            switch (alt77) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:952:5: mod2= primSizeModifier (mod3= primSizeModifier )?
                    {
                    pushFollow(FOLLOW_primSizeModifier_in_primitiveTypeRef2922);
                    mod2=primSizeModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mod2.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:953:8: (mod3= primSizeModifier )?
                    int alt76=2;
                    alt76 = dfa76.predict(input);
                    switch (alt76) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: mod3= primSizeModifier
                            {
                            pushFollow(FOLLOW_primSizeModifier_in_primitiveTypeRef2929);
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:961:4: (name= primitiveTypeName )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:964:5: name= primitiveTypeName
            {
            pushFollow(FOLLOW_primitiveTypeName_in_primitiveTypeRef2972);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:993:1: objCMethodCall returns [FunctionCall expr] : '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']' ;
    public final ObjCppParser.objCMethodCall_return objCMethodCall() throws RecognitionException {
        ObjCppParser.objCMethodCall_return retval = new ObjCppParser.objCMethodCall_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token methodName=null;
        Token selx=null;
        Token char_literal156=null;
        Token char_literal157=null;
        Token char_literal158=null;
        Token char_literal159=null;
        ObjCppParser.expression_return target = null;

        ObjCppParser.expression_return arg1 = null;

        ObjCppParser.expression_return argx = null;


        Object methodName_tree=null;
        Object selx_tree=null;
        Object char_literal156_tree=null;
        Object char_literal157_tree=null;
        Object char_literal158_tree=null;
        Object char_literal159_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:994:2: ( '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:995:3: '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']'
            {
            root_0 = (Object)adaptor.nil();

            char_literal156=(Token)match(input,53,FOLLOW_53_in_objCMethodCall3011); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal156_tree = (Object)adaptor.create(char_literal156);
            adaptor.addChild(root_0, char_literal156_tree);
            }
            pushFollow(FOLLOW_expression_in_objCMethodCall3015);
            target=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, target.getTree());
            methodName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodCall3019); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            methodName_tree = (Object)adaptor.create(methodName);
            adaptor.addChild(root_0, methodName_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.expr = new FunctionCall((methodName!=null?methodName.getText():null));
              			retval.expr.setTarget((target!=null?target.expr:null));
              			retval.expr.setMemberRefStyle(MemberRefStyle.SquareBrackets);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1000:3: ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==33) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1001:4: ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )*
                    {
                    char_literal157=(Token)match(input,33,FOLLOW_33_in_objCMethodCall3030); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal157_tree = (Object)adaptor.create(char_literal157);
                    adaptor.addChild(root_0, char_literal157_tree);
                    }
                    pushFollow(FOLLOW_expression_in_objCMethodCall3034);
                    arg1=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arg1.getTree());
                    if ( state.backtracking==0 ) {

                      				retval.expr.addArgument(null, (arg1!=null?arg1.expr:null));
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1004:4: (selx= IDENTIFIER ':' argx= expression )*
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==IDENTIFIER) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1005:5: selx= IDENTIFIER ':' argx= expression
                    	    {
                    	    selx=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodCall3049); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    selx_tree = (Object)adaptor.create(selx);
                    	    adaptor.addChild(root_0, selx_tree);
                    	    }
                    	    char_literal158=(Token)match(input,33,FOLLOW_33_in_objCMethodCall3051); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal158_tree = (Object)adaptor.create(char_literal158);
                    	    adaptor.addChild(root_0, char_literal158_tree);
                    	    }
                    	    pushFollow(FOLLOW_expression_in_objCMethodCall3055);
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

            char_literal159=(Token)match(input,54,FOLLOW_54_in_objCMethodCall3072); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal159_tree = (Object)adaptor.create(char_literal159);
            adaptor.addChild(root_0, char_literal159_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1013:1: functionCall returns [FunctionCall expr] : ( 'sizeof' '(' typeRef ')' | IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')' );
    public final ObjCppParser.functionCall_return functionCall() throws RecognitionException {
        ObjCppParser.functionCall_return retval = new ObjCppParser.functionCall_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal160=null;
        Token char_literal161=null;
        Token char_literal163=null;
        Token IDENTIFIER164=null;
        Token char_literal165=null;
        Token char_literal166=null;
        Token char_literal167=null;
        ObjCppParser.expression_return a1 = null;

        ObjCppParser.expression_return ax = null;

        ObjCppParser.typeRef_return typeRef162 = null;


        Object string_literal160_tree=null;
        Object char_literal161_tree=null;
        Object char_literal163_tree=null;
        Object IDENTIFIER164_tree=null;
        Object char_literal165_tree=null;
        Object char_literal166_tree=null;
        Object char_literal167_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1014:2: ( 'sizeof' '(' typeRef ')' | IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')' )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==74) ) {
                alt82=1;
            }
            else if ( (LA82_0==IDENTIFIER) ) {
                alt82=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1015:3: 'sizeof' '(' typeRef ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal160=(Token)match(input,74,FOLLOW_74_in_functionCall3092); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal160_tree = (Object)adaptor.create(string_literal160);
                    adaptor.addChild(root_0, string_literal160_tree);
                    }
                    char_literal161=(Token)match(input,34,FOLLOW_34_in_functionCall3094); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal161_tree = (Object)adaptor.create(char_literal161);
                    adaptor.addChild(root_0, char_literal161_tree);
                    }
                    pushFollow(FOLLOW_typeRef_in_functionCall3096);
                    typeRef162=typeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRef162.getTree());
                    char_literal163=(Token)match(input,35,FOLLOW_35_in_functionCall3098); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal163_tree = (Object)adaptor.create(char_literal163);
                    adaptor.addChild(root_0, char_literal163_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			retval.expr = new FunctionCall("sizeof");
                      			retval.expr.addArgument(new TypeRefExpression((typeRef162!=null?typeRef162.type:null)));
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1019:3: IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    IDENTIFIER164=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionCall3106); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER164_tree = (Object)adaptor.create(IDENTIFIER164);
                    adaptor.addChild(root_0, IDENTIFIER164_tree);
                    }
                    char_literal165=(Token)match(input,34,FOLLOW_34_in_functionCall3108); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal165_tree = (Object)adaptor.create(char_literal165);
                    adaptor.addChild(root_0, char_literal165_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			retval.expr = new FunctionCall((IDENTIFIER164!=null?IDENTIFIER164.getText():null));
                      		
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1022:3: (a1= expression ( ',' ax= expression )* )?
                    int alt81=2;
                    alt81 = dfa81.predict(input);
                    switch (alt81) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1023:4: a1= expression ( ',' ax= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_functionCall3121);
                            a1=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                            if ( state.backtracking==0 ) {

                              				retval.expr.addArgument((a1!=null?a1.expr:null));
                              			
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1026:4: ( ',' ax= expression )*
                            loop80:
                            do {
                                int alt80=2;
                                int LA80_0 = input.LA(1);

                                if ( (LA80_0==27) ) {
                                    alt80=1;
                                }


                                switch (alt80) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1026:6: ',' ax= expression
                            	    {
                            	    char_literal166=(Token)match(input,27,FOLLOW_27_in_functionCall3130); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    char_literal166_tree = (Object)adaptor.create(char_literal166);
                            	    adaptor.addChild(root_0, char_literal166_tree);
                            	    }
                            	    pushFollow(FOLLOW_expression_in_functionCall3139);
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

                    char_literal167=(Token)match(input,35,FOLLOW_35_in_functionCall3157); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal167_tree = (Object)adaptor.create(char_literal167);
                    adaptor.addChild(root_0, char_literal167_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1035:1: expression returns [Expression expr] : (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' ) (bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )* ;
    public final ObjCppParser.expression_return expression() throws RecognitionException {
        ObjCppParser.expression_return retval = new ObjCppParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token id=null;
        Token prefixOp=null;
        Token bop=null;
        Token fieldName=null;
        Token refStyle=null;
        Token char_literal169=null;
        Token char_literal170=null;
        Token char_literal172=null;
        Token char_literal174=null;
        Token char_literal176=null;
        Token char_literal177=null;
        Token char_literal178=null;
        Token char_literal179=null;
        Token char_literal180=null;
        Token char_literal181=null;
        Token char_literal182=null;
        Token char_literal183=null;
        Token char_literal184=null;
        Token char_literal185=null;
        ObjCppParser.functionCall_return fc1 = null;

        ObjCppParser.expression_return opd = null;

        ObjCppParser.expression_return par = null;

        ObjCppParser.expression_return casted = null;

        ObjCppParser.expression_return opd2 = null;

        ObjCppParser.expression_return val = null;

        ObjCppParser.functionCall_return fc2 = null;

        ObjCppParser.expression_return xif = null;

        ObjCppParser.expression_return xelse = null;

        ObjCppParser.objCMethodCall_return objCMethodCall168 = null;

        ObjCppParser.typeRef_return typeRef171 = null;

        ObjCppParser.constant_return constant173 = null;

        ObjCppParser.expression_return expression175 = null;


        Object id_tree=null;
        Object prefixOp_tree=null;
        Object bop_tree=null;
        Object fieldName_tree=null;
        Object refStyle_tree=null;
        Object char_literal169_tree=null;
        Object char_literal170_tree=null;
        Object char_literal172_tree=null;
        Object char_literal174_tree=null;
        Object char_literal176_tree=null;
        Object char_literal177_tree=null;
        Object char_literal178_tree=null;
        Object char_literal179_tree=null;
        Object char_literal180_tree=null;
        Object char_literal181_tree=null;
        Object char_literal182_tree=null;
        Object char_literal183_tree=null;
        Object char_literal184_tree=null;
        Object char_literal185_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1036:2: ( (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' ) (bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1036:4: (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' ) (bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1036:4: (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' )
            int alt84=7;
            alt84 = dfa84.predict(input);
            switch (alt84) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1037:4: id= IDENTIFIER
                    {
                    id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression3179); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1040:4: fc1= functionCall
                    {
                    pushFollow(FOLLOW_functionCall_in_expression3190);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1043:4: objCMethodCall
                    {
                    pushFollow(FOLLOW_objCMethodCall_in_expression3199);
                    objCMethodCall168=objCMethodCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, objCMethodCall168.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				retval.expr = (objCMethodCall168!=null?objCMethodCall168.expr:null); 
                      							
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1046:4: prefixOp= ( '!' | '~' ) opd= expression
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

                    pushFollow(FOLLOW_expression_in_expression3220);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1049:4: '(' (par= expression ')' | typeRef ')' casted= expression )
                    {
                    char_literal169=(Token)match(input,34,FOLLOW_34_in_expression3229); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal169_tree = (Object)adaptor.create(char_literal169);
                    adaptor.addChild(root_0, char_literal169_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1049:8: (par= expression ')' | typeRef ')' casted= expression )
                    int alt83=2;
                    alt83 = dfa83.predict(input);
                    switch (alt83) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1050:5: par= expression ')'
                            {
                            pushFollow(FOLLOW_expression_in_expression3239);
                            par=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, par.getTree());
                            char_literal170=(Token)match(input,35,FOLLOW_35_in_expression3241); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal170_tree = (Object)adaptor.create(char_literal170);
                            adaptor.addChild(root_0, char_literal170_tree);
                            }
                            if ( state.backtracking==0 ) {

                              					retval.expr = (par!=null?par.expr:null);
                              					if (retval.expr != null)
                              						retval.expr.setParenthesis(true);
                              				
                            }

                            }
                            break;
                        case 2 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1055:5: typeRef ')' casted= expression
                            {
                            pushFollow(FOLLOW_typeRef_in_expression3251);
                            typeRef171=typeRef();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRef171.getTree());
                            char_literal172=(Token)match(input,35,FOLLOW_35_in_expression3253); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal172_tree = (Object)adaptor.create(char_literal172);
                            adaptor.addChild(root_0, char_literal172_tree);
                            }
                            pushFollow(FOLLOW_expression_in_expression3257);
                            casted=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, casted.getTree());
                            if ( state.backtracking==0 ) {

                              					retval.expr = new Cast((typeRef171!=null?typeRef171.type:null), (casted!=null?casted.expr:null));
                              				
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1059:4: constant
                    {
                    pushFollow(FOLLOW_constant_in_expression3272);
                    constant173=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant173.getTree());
                    if ( state.backtracking==0 ) {
                       retval.expr = (constant173!=null?constant173.constant:null); 
                    }

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1060:4: '{' expression '}'
                    {
                    char_literal174=(Token)match(input,23,FOLLOW_23_in_expression3281); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal174_tree = (Object)adaptor.create(char_literal174);
                    adaptor.addChild(root_0, char_literal174_tree);
                    }
                    pushFollow(FOLLOW_expression_in_expression3283);
                    expression175=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression175.getTree());
                    char_literal176=(Token)match(input,24,FOLLOW_24_in_expression3285); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal176_tree = (Object)adaptor.create(char_literal176);
                    adaptor.addChild(root_0, char_literal176_tree);
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1062:3: (bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )*
            loop86:
            do {
                int alt86=6;
                alt86 = dfa86.predict(input);
                switch (alt86) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1063:4: bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression
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

            	    pushFollow(FOLLOW_expression_in_expression3395);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1070:4: '=' val= expression
            	    {
            	    char_literal177=(Token)match(input,29,FOLLOW_29_in_expression3404); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal177_tree = (Object)adaptor.create(char_literal177);
            	    adaptor.addChild(root_0, char_literal177_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression3408);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1073:4: '.' fieldName= IDENTIFIER
            	    {
            	    char_literal178=(Token)match(input,89,FOLLOW_89_in_expression3417); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal178_tree = (Object)adaptor.create(char_literal178);
            	    adaptor.addChild(root_0, char_literal178_tree);
            	    }
            	    fieldName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression3421); if (state.failed) return retval;
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1076:4: refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1076:13: ( ':' ':' | '-' '>' | '.' )
            	    int alt85=3;
            	    switch ( input.LA(1) ) {
            	    case 33:
            	        {
            	        alt85=1;
            	        }
            	        break;
            	    case 43:
            	        {
            	        alt85=2;
            	        }
            	        break;
            	    case 89:
            	        {
            	        alt85=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 85, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt85) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1076:14: ':' ':'
            	            {
            	            char_literal179=(Token)match(input,33,FOLLOW_33_in_expression3433); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal179_tree = (Object)adaptor.create(char_literal179);
            	            adaptor.addChild(root_0, char_literal179_tree);
            	            }
            	            char_literal180=(Token)match(input,33,FOLLOW_33_in_expression3435); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal180_tree = (Object)adaptor.create(char_literal180);
            	            adaptor.addChild(root_0, char_literal180_tree);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1076:24: '-' '>'
            	            {
            	            char_literal181=(Token)match(input,43,FOLLOW_43_in_expression3439); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal181_tree = (Object)adaptor.create(char_literal181);
            	            adaptor.addChild(root_0, char_literal181_tree);
            	            }
            	            char_literal182=(Token)match(input,37,FOLLOW_37_in_expression3441); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal182_tree = (Object)adaptor.create(char_literal182);
            	            adaptor.addChild(root_0, char_literal182_tree);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1076:34: '.'
            	            {
            	            char_literal183=(Token)match(input,89,FOLLOW_89_in_expression3445); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal183_tree = (Object)adaptor.create(char_literal183);
            	            adaptor.addChild(root_0, char_literal183_tree);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_functionCall_in_expression3450);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1083:4: '?' xif= expression ':' xelse= expression
            	    {
            	    char_literal184=(Token)match(input,90,FOLLOW_90_in_expression3459); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal184_tree = (Object)adaptor.create(char_literal184);
            	    adaptor.addChild(root_0, char_literal184_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression3463);
            	    xif=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, xif.getTree());
            	    char_literal185=(Token)match(input,33,FOLLOW_33_in_expression3465); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal185_tree = (Object)adaptor.create(char_literal185);
            	    adaptor.addChild(root_0, char_literal185_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression3469);
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
    // $ANTLR end "expression"

    public static class statementsBlock_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statementsBlock"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1090:1: statementsBlock : '{' ( statement )* '}' ;
    public final ObjCppParser.statementsBlock_return statementsBlock() throws RecognitionException {
        ObjCppParser.statementsBlock_return retval = new ObjCppParser.statementsBlock_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal186=null;
        Token char_literal188=null;
        ObjCppParser.statement_return statement187 = null;


        Object char_literal186_tree=null;
        Object char_literal188_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1091:2: ( '{' ( statement )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1091:4: '{' ( statement )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal186=(Token)match(input,23,FOLLOW_23_in_statementsBlock3490); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal186_tree = (Object)adaptor.create(char_literal186);
            adaptor.addChild(root_0, char_literal186_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1091:8: ( statement )*
            loop87:
            do {
                int alt87=2;
                alt87 = dfa87.predict(input);
                switch (alt87) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_statementsBlock3492);
            	    statement187=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement187.getTree());

            	    }
            	    break;

            	default :
            	    break loop87;
                }
            } while (true);

            char_literal188=(Token)match(input,24,FOLLOW_24_in_statementsBlock3495); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal188_tree = (Object)adaptor.create(char_literal188);
            adaptor.addChild(root_0, char_literal188_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1093:1: statement : ( statementsBlock | declaration | expression ( '=' expression )? ';' | 'return' expression ';' | 'if' '(' expression ')' statement ( 'else' statement )? | 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement );
    public final ObjCppParser.statement_return statement() throws RecognitionException {
        ObjCppParser.statement_return retval = new ObjCppParser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal192=null;
        Token char_literal194=null;
        Token string_literal195=null;
        Token char_literal197=null;
        Token string_literal198=null;
        Token char_literal199=null;
        Token char_literal201=null;
        Token string_literal203=null;
        Token string_literal205=null;
        Token char_literal206=null;
        Token char_literal208=null;
        Token string_literal210=null;
        Token string_literal212=null;
        Token char_literal213=null;
        Token char_literal215=null;
        Token char_literal216=null;
        Token string_literal217=null;
        Token char_literal218=null;
        Token char_literal220=null;
        Token char_literal222=null;
        Token char_literal224=null;
        Token string_literal226=null;
        Token char_literal227=null;
        Token char_literal229=null;
        Token char_literal230=null;
        Token string_literal231=null;
        Token char_literal233=null;
        Token char_literal235=null;
        Token char_literal236=null;
        Token IDENTIFIER237=null;
        Token char_literal238=null;
        Token char_literal240=null;
        Token char_literal242=null;
        ObjCppParser.statementsBlock_return statementsBlock189 = null;

        ObjCppParser.declaration_return declaration190 = null;

        ObjCppParser.expression_return expression191 = null;

        ObjCppParser.expression_return expression193 = null;

        ObjCppParser.expression_return expression196 = null;

        ObjCppParser.expression_return expression200 = null;

        ObjCppParser.statement_return statement202 = null;

        ObjCppParser.statement_return statement204 = null;

        ObjCppParser.expression_return expression207 = null;

        ObjCppParser.statement_return statement209 = null;

        ObjCppParser.statement_return statement211 = null;

        ObjCppParser.expression_return expression214 = null;

        ObjCppParser.statement_return statement219 = null;

        ObjCppParser.expression_return expression221 = null;

        ObjCppParser.statement_return statement223 = null;

        ObjCppParser.statement_return statement225 = null;

        ObjCppParser.expression_return expression228 = null;

        ObjCppParser.expression_return expression232 = null;

        ObjCppParser.statement_return statement234 = null;

        ObjCppParser.varDecl_return varDecl239 = null;

        ObjCppParser.expression_return expression241 = null;

        ObjCppParser.statement_return statement243 = null;


        Object char_literal192_tree=null;
        Object char_literal194_tree=null;
        Object string_literal195_tree=null;
        Object char_literal197_tree=null;
        Object string_literal198_tree=null;
        Object char_literal199_tree=null;
        Object char_literal201_tree=null;
        Object string_literal203_tree=null;
        Object string_literal205_tree=null;
        Object char_literal206_tree=null;
        Object char_literal208_tree=null;
        Object string_literal210_tree=null;
        Object string_literal212_tree=null;
        Object char_literal213_tree=null;
        Object char_literal215_tree=null;
        Object char_literal216_tree=null;
        Object string_literal217_tree=null;
        Object char_literal218_tree=null;
        Object char_literal220_tree=null;
        Object char_literal222_tree=null;
        Object char_literal224_tree=null;
        Object string_literal226_tree=null;
        Object char_literal227_tree=null;
        Object char_literal229_tree=null;
        Object char_literal230_tree=null;
        Object string_literal231_tree=null;
        Object char_literal233_tree=null;
        Object char_literal235_tree=null;
        Object char_literal236_tree=null;
        Object IDENTIFIER237_tree=null;
        Object char_literal238_tree=null;
        Object char_literal240_tree=null;
        Object char_literal242_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1094:2: ( statementsBlock | declaration | expression ( '=' expression )? ';' | 'return' expression ';' | 'if' '(' expression ')' statement ( 'else' statement )? | 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement )
            int alt94=11;
            alt94 = dfa94.predict(input);
            switch (alt94) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1095:3: statementsBlock
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_statementsBlock_in_statement3508);
                    statementsBlock189=statementsBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementsBlock189.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1096:3: declaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_declaration_in_statement3514);
                    declaration190=declaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration190.getTree());

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1097:3: expression ( '=' expression )? ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_expression_in_statement3520);
                    expression191=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression191.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1097:14: ( '=' expression )?
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==29) ) {
                        alt88=1;
                    }
                    switch (alt88) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1097:15: '=' expression
                            {
                            char_literal192=(Token)match(input,29,FOLLOW_29_in_statement3523); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal192_tree = (Object)adaptor.create(char_literal192);
                            adaptor.addChild(root_0, char_literal192_tree);
                            }
                            pushFollow(FOLLOW_expression_in_statement3525);
                            expression193=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression193.getTree());

                            }
                            break;

                    }

                    char_literal194=(Token)match(input,28,FOLLOW_28_in_statement3530); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal194_tree = (Object)adaptor.create(char_literal194);
                    adaptor.addChild(root_0, char_literal194_tree);
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1098:3: 'return' expression ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal195=(Token)match(input,91,FOLLOW_91_in_statement3536); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal195_tree = (Object)adaptor.create(string_literal195);
                    adaptor.addChild(root_0, string_literal195_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3538);
                    expression196=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression196.getTree());
                    char_literal197=(Token)match(input,28,FOLLOW_28_in_statement3540); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal197_tree = (Object)adaptor.create(char_literal197);
                    adaptor.addChild(root_0, char_literal197_tree);
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1099:3: 'if' '(' expression ')' statement ( 'else' statement )?
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal198=(Token)match(input,92,FOLLOW_92_in_statement3546); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal198_tree = (Object)adaptor.create(string_literal198);
                    adaptor.addChild(root_0, string_literal198_tree);
                    }
                    char_literal199=(Token)match(input,34,FOLLOW_34_in_statement3548); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal199_tree = (Object)adaptor.create(char_literal199);
                    adaptor.addChild(root_0, char_literal199_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3550);
                    expression200=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression200.getTree());
                    char_literal201=(Token)match(input,35,FOLLOW_35_in_statement3552); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal201_tree = (Object)adaptor.create(char_literal201);
                    adaptor.addChild(root_0, char_literal201_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement3554);
                    statement202=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement202.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1099:37: ( 'else' statement )?
                    int alt89=2;
                    alt89 = dfa89.predict(input);
                    switch (alt89) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1099:38: 'else' statement
                            {
                            string_literal203=(Token)match(input,93,FOLLOW_93_in_statement3557); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal203_tree = (Object)adaptor.create(string_literal203);
                            adaptor.addChild(root_0, string_literal203_tree);
                            }
                            pushFollow(FOLLOW_statement_in_statement3559);
                            statement204=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement204.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1100:3: 'while' '(' expression ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal205=(Token)match(input,94,FOLLOW_94_in_statement3567); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal205_tree = (Object)adaptor.create(string_literal205);
                    adaptor.addChild(root_0, string_literal205_tree);
                    }
                    char_literal206=(Token)match(input,34,FOLLOW_34_in_statement3569); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal206_tree = (Object)adaptor.create(char_literal206);
                    adaptor.addChild(root_0, char_literal206_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3571);
                    expression207=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression207.getTree());
                    char_literal208=(Token)match(input,35,FOLLOW_35_in_statement3573); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal208_tree = (Object)adaptor.create(char_literal208);
                    adaptor.addChild(root_0, char_literal208_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement3575);
                    statement209=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement209.getTree());

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1101:3: 'do' statement 'while' '(' expression ')' ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal210=(Token)match(input,95,FOLLOW_95_in_statement3581); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal210_tree = (Object)adaptor.create(string_literal210);
                    adaptor.addChild(root_0, string_literal210_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement3583);
                    statement211=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement211.getTree());
                    string_literal212=(Token)match(input,94,FOLLOW_94_in_statement3585); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal212_tree = (Object)adaptor.create(string_literal212);
                    adaptor.addChild(root_0, string_literal212_tree);
                    }
                    char_literal213=(Token)match(input,34,FOLLOW_34_in_statement3587); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal213_tree = (Object)adaptor.create(char_literal213);
                    adaptor.addChild(root_0, char_literal213_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3589);
                    expression214=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression214.getTree());
                    char_literal215=(Token)match(input,35,FOLLOW_35_in_statement3591); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal215_tree = (Object)adaptor.create(char_literal215);
                    adaptor.addChild(root_0, char_literal215_tree);
                    }
                    char_literal216=(Token)match(input,28,FOLLOW_28_in_statement3593); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal216_tree = (Object)adaptor.create(char_literal216);
                    adaptor.addChild(root_0, char_literal216_tree);
                    }

                    }
                    break;
                case 8 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1102:3: 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal217=(Token)match(input,96,FOLLOW_96_in_statement3599); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal217_tree = (Object)adaptor.create(string_literal217);
                    adaptor.addChild(root_0, string_literal217_tree);
                    }
                    char_literal218=(Token)match(input,34,FOLLOW_34_in_statement3601); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal218_tree = (Object)adaptor.create(char_literal218);
                    adaptor.addChild(root_0, char_literal218_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1102:13: ( statement )?
                    int alt90=2;
                    alt90 = dfa90.predict(input);
                    switch (alt90) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: statement
                            {
                            pushFollow(FOLLOW_statement_in_statement3603);
                            statement219=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement219.getTree());

                            }
                            break;

                    }

                    char_literal220=(Token)match(input,28,FOLLOW_28_in_statement3606); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal220_tree = (Object)adaptor.create(char_literal220);
                    adaptor.addChild(root_0, char_literal220_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1102:28: ( expression )?
                    int alt91=2;
                    alt91 = dfa91.predict(input);
                    switch (alt91) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement3608);
                            expression221=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression221.getTree());

                            }
                            break;

                    }

                    char_literal222=(Token)match(input,28,FOLLOW_28_in_statement3611); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal222_tree = (Object)adaptor.create(char_literal222);
                    adaptor.addChild(root_0, char_literal222_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1102:44: ( statement )?
                    int alt92=2;
                    alt92 = dfa92.predict(input);
                    switch (alt92) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: statement
                            {
                            pushFollow(FOLLOW_statement_in_statement3613);
                            statement223=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement223.getTree());

                            }
                            break;

                    }

                    char_literal224=(Token)match(input,35,FOLLOW_35_in_statement3616); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal224_tree = (Object)adaptor.create(char_literal224);
                    adaptor.addChild(root_0, char_literal224_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement3618);
                    statement225=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement225.getTree());

                    }
                    break;
                case 9 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1103:3: 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal226=(Token)match(input,97,FOLLOW_97_in_statement3624); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal226_tree = (Object)adaptor.create(string_literal226);
                    adaptor.addChild(root_0, string_literal226_tree);
                    }
                    char_literal227=(Token)match(input,34,FOLLOW_34_in_statement3626); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal227_tree = (Object)adaptor.create(char_literal227);
                    adaptor.addChild(root_0, char_literal227_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3628);
                    expression228=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression228.getTree());
                    char_literal229=(Token)match(input,35,FOLLOW_35_in_statement3630); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal229_tree = (Object)adaptor.create(char_literal229);
                    adaptor.addChild(root_0, char_literal229_tree);
                    }
                    char_literal230=(Token)match(input,23,FOLLOW_23_in_statement3632); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal230_tree = (Object)adaptor.create(char_literal230);
                    adaptor.addChild(root_0, char_literal230_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1104:3: ( 'case' expression ':' | statement )*
                    loop93:
                    do {
                        int alt93=3;
                        alt93 = dfa93.predict(input);
                        switch (alt93) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1104:5: 'case' expression ':'
                    	    {
                    	    string_literal231=(Token)match(input,98,FOLLOW_98_in_statement3638); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    string_literal231_tree = (Object)adaptor.create(string_literal231);
                    	    adaptor.addChild(root_0, string_literal231_tree);
                    	    }
                    	    pushFollow(FOLLOW_expression_in_statement3640);
                    	    expression232=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression232.getTree());
                    	    char_literal233=(Token)match(input,33,FOLLOW_33_in_statement3642); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal233_tree = (Object)adaptor.create(char_literal233);
                    	    adaptor.addChild(root_0, char_literal233_tree);
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1105:4: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement3649);
                    	    statement234=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement234.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop93;
                        }
                    } while (true);

                    char_literal235=(Token)match(input,24,FOLLOW_24_in_statement3658); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal235_tree = (Object)adaptor.create(char_literal235);
                    adaptor.addChild(root_0, char_literal235_tree);
                    }

                    }
                    break;
                case 10 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1108:3: ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal236=(Token)match(input,28,FOLLOW_28_in_statement3664); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal236_tree = (Object)adaptor.create(char_literal236);
                    adaptor.addChild(root_0, char_literal236_tree);
                    }

                    }
                    break;
                case 11 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1109:3: {...}? IDENTIFIER '(' varDecl ':' expression ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !(( next("foreach") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "statement", " next(\"foreach\") ");
                    }
                    IDENTIFIER237=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement3672); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER237_tree = (Object)adaptor.create(IDENTIFIER237);
                    adaptor.addChild(root_0, IDENTIFIER237_tree);
                    }
                    char_literal238=(Token)match(input,34,FOLLOW_34_in_statement3674); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal238_tree = (Object)adaptor.create(char_literal238);
                    adaptor.addChild(root_0, char_literal238_tree);
                    }
                    pushFollow(FOLLOW_varDecl_in_statement3676);
                    varDecl239=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl239.getTree());
                    char_literal240=(Token)match(input,33,FOLLOW_33_in_statement3678); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal240_tree = (Object)adaptor.create(char_literal240);
                    adaptor.addChild(root_0, char_literal240_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3680);
                    expression241=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression241.getTree());
                    char_literal242=(Token)match(input,35,FOLLOW_35_in_statement3682); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal242_tree = (Object)adaptor.create(char_literal242);
                    adaptor.addChild(root_0, char_literal242_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement3684);
                    statement243=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement243.getTree());

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1112:1: constant returns [Constant constant] : ( DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER | CHARACTER | FLOAT_NUMBER | STRING );
    public final ObjCppParser.constant_return constant() throws RecognitionException {
        ObjCppParser.constant_return retval = new ObjCppParser.constant_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DECIMAL_NUMBER244=null;
        Token HEXADECIMAL_NUMBER245=null;
        Token OCTAL_NUMBER246=null;
        Token CHARACTER247=null;
        Token FLOAT_NUMBER248=null;
        Token STRING249=null;

        Object DECIMAL_NUMBER244_tree=null;
        Object HEXADECIMAL_NUMBER245_tree=null;
        Object OCTAL_NUMBER246_tree=null;
        Object CHARACTER247_tree=null;
        Object FLOAT_NUMBER248_tree=null;
        Object STRING249_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1113:2: ( DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER | CHARACTER | FLOAT_NUMBER | STRING )
            int alt95=6;
            switch ( input.LA(1) ) {
            case DECIMAL_NUMBER:
                {
                alt95=1;
                }
                break;
            case HEXADECIMAL_NUMBER:
                {
                alt95=2;
                }
                break;
            case OCTAL_NUMBER:
                {
                alt95=3;
                }
                break;
            case CHARACTER:
                {
                alt95=4;
                }
                break;
            case FLOAT_NUMBER:
                {
                alt95=5;
                }
                break;
            case STRING:
                {
                alt95=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }

            switch (alt95) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1113:4: DECIMAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    DECIMAL_NUMBER244=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_constant3700); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DECIMAL_NUMBER244_tree = (Object)adaptor.create(DECIMAL_NUMBER244);
                    adaptor.addChild(root_0, DECIMAL_NUMBER244_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant =  Constant.parseDecimal((DECIMAL_NUMBER244!=null?DECIMAL_NUMBER244.getText():null)); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1114:3: HEXADECIMAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    HEXADECIMAL_NUMBER245=(Token)match(input,HEXADECIMAL_NUMBER,FOLLOW_HEXADECIMAL_NUMBER_in_constant3708); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    HEXADECIMAL_NUMBER245_tree = (Object)adaptor.create(HEXADECIMAL_NUMBER245);
                    adaptor.addChild(root_0, HEXADECIMAL_NUMBER245_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant = Constant.parseHex((HEXADECIMAL_NUMBER245!=null?HEXADECIMAL_NUMBER245.getText():null)); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1115:3: OCTAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    OCTAL_NUMBER246=(Token)match(input,OCTAL_NUMBER,FOLLOW_OCTAL_NUMBER_in_constant3716); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OCTAL_NUMBER246_tree = (Object)adaptor.create(OCTAL_NUMBER246);
                    adaptor.addChild(root_0, OCTAL_NUMBER246_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant = Constant.parseOctal((OCTAL_NUMBER246!=null?OCTAL_NUMBER246.getText():null)); 
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1116:3: CHARACTER
                    {
                    root_0 = (Object)adaptor.nil();

                    CHARACTER247=(Token)match(input,CHARACTER,FOLLOW_CHARACTER_in_constant3724); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARACTER247_tree = (Object)adaptor.create(CHARACTER247);
                    adaptor.addChild(root_0, CHARACTER247_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant =  Constant.parseCharOrStringInteger((CHARACTER247!=null?CHARACTER247.getText():null)); 
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1117:3: FLOAT_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    FLOAT_NUMBER248=(Token)match(input,FLOAT_NUMBER,FOLLOW_FLOAT_NUMBER_in_constant3732); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT_NUMBER248_tree = (Object)adaptor.create(FLOAT_NUMBER248);
                    adaptor.addChild(root_0, FLOAT_NUMBER248_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant = Constant.parseFloat((FLOAT_NUMBER248!=null?FLOAT_NUMBER248.getText():null)); 
                    }

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1119:3: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING249=(Token)match(input,STRING,FOLLOW_STRING_in_constant3743); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING249_tree = (Object)adaptor.create(STRING249);
                    adaptor.addChild(root_0, STRING249_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant =  Constant.parseString((STRING249!=null?STRING249.getText():null)); 
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

    // $ANTLR start synpred77_ObjCpp
    public final void synpred77_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:714:4: ( ( typeMutator )* functionSignatureSuffix )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:714:4: ( typeMutator )* functionSignatureSuffix
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:714:4: ( typeMutator )*
        loop117:
        do {
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==IDENTIFIER||(LA117_0>=51 && LA117_0<=53)) ) {
                alt117=1;
            }


            switch (alt117) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:715:5: typeMutator
        	    {
        	    pushFollow(FOLLOW_typeMutator_in_synpred77_ObjCpp2075);
        	    typeMutator();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop117;
            }
        } while (true);

        pushFollow(FOLLOW_functionSignatureSuffix_in_synpred77_ObjCpp2088);
        functionSignatureSuffix();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred77_ObjCpp

    // $ANTLR start synpred78_ObjCpp
    public final void synpred78_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:729:4: ({...}? modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:729:4: {...}? modifier
        {
        if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred78_ObjCpp", " next(Modifier.Kind.TypeQualifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred78_ObjCpp2122);
        modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred78_ObjCpp

    // $ANTLR start synpred82_ObjCpp
    public final void synpred82_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:749:5: ( '=' expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:749:5: '=' expression
        {
        match(input,29,FOLLOW_29_in_synpred82_ObjCpp2213); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred82_ObjCpp2220);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred82_ObjCpp

    // $ANTLR start synpred84_ObjCpp
    public final void synpred84_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return sm = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:790:4: ({...}?sm= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:790:4: {...}?sm= modifier
        {
        if ( !(( next(Modifier.Kind.StorageClassSpecifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred84_ObjCpp", " next(Modifier.Kind.StorageClassSpecifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred84_ObjCpp2348);
        sm=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred84_ObjCpp

    // $ANTLR start synpred85_ObjCpp
    public final void synpred85_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return tm = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:792:4: ({...}?tm= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:792:4: {...}?tm= modifier
        {
        if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred85_ObjCpp", " next(Modifier.Kind.TypeQualifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred85_ObjCpp2365);
        tm=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred85_ObjCpp

    // $ANTLR start synpred90_ObjCpp
    public final void synpred90_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return im = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:861:5: (im= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:861:5: im= modifier
        {
        pushFollow(FOLLOW_modifier_in_synpred90_ObjCpp2578);
        im=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred90_ObjCpp

    // $ANTLR start synpred94_ObjCpp
    public final void synpred94_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.argDef_return ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:899:5: ( ',' ax= argDef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:899:5: ',' ax= argDef
        {
        match(input,27,FOLLOW_27_in_synpred94_ObjCpp2696); if (state.failed) return ;
        pushFollow(FOLLOW_argDef_in_synpred94_ObjCpp2705);
        ax=argDef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred94_ObjCpp

    // $ANTLR start synpred97_ObjCpp
    public final void synpred97_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:920:4: ( typeMutator )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:920:4: typeMutator
        {
        pushFollow(FOLLOW_typeMutator_in_synpred97_ObjCpp2772);
        typeMutator();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred97_ObjCpp

    // $ANTLR start synpred125_ObjCpp
    public final void synpred125_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.expression_return par = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1050:5: (par= expression ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1050:5: par= expression ')'
        {
        pushFollow(FOLLOW_expression_in_synpred125_ObjCpp3239);
        par=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred125_ObjCpp3241); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred125_ObjCpp

    // $ANTLR start synpred146_ObjCpp
    public final void synpred146_ObjCpp_fragment() throws RecognitionException {   
        Token bop=null;
        ObjCppParser.expression_return opd2 = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1063:4: (bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1063:4: bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression
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

        pushFollow(FOLLOW_expression_in_synpred146_ObjCpp3395);
        opd2=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred146_ObjCpp

    // $ANTLR start synpred147_ObjCpp
    public final void synpred147_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.expression_return val = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1070:4: ( '=' val= expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1070:4: '=' val= expression
        {
        match(input,29,FOLLOW_29_in_synpred147_ObjCpp3404); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred147_ObjCpp3408);
        val=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred147_ObjCpp

    // $ANTLR start synpred148_ObjCpp
    public final void synpred148_ObjCpp_fragment() throws RecognitionException {   
        Token fieldName=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1073:4: ( '.' fieldName= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1073:4: '.' fieldName= IDENTIFIER
        {
        match(input,89,FOLLOW_89_in_synpred148_ObjCpp3417); if (state.failed) return ;
        fieldName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred148_ObjCpp3421); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred148_ObjCpp

    // $ANTLR start synpred151_ObjCpp
    public final void synpred151_ObjCpp_fragment() throws RecognitionException {   
        Token refStyle=null;
        ObjCppParser.functionCall_return fc2 = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1076:4: (refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1076:4: refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1076:13: ( ':' ':' | '-' '>' | '.' )
        int alt126=3;
        switch ( input.LA(1) ) {
        case 33:
            {
            alt126=1;
            }
            break;
        case 43:
            {
            alt126=2;
            }
            break;
        case 89:
            {
            alt126=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 126, 0, input);

            throw nvae;
        }

        switch (alt126) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1076:14: ':' ':'
                {
                match(input,33,FOLLOW_33_in_synpred151_ObjCpp3433); if (state.failed) return ;
                match(input,33,FOLLOW_33_in_synpred151_ObjCpp3435); if (state.failed) return ;

                }
                break;
            case 2 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1076:24: '-' '>'
                {
                match(input,43,FOLLOW_43_in_synpred151_ObjCpp3439); if (state.failed) return ;
                match(input,37,FOLLOW_37_in_synpred151_ObjCpp3441); if (state.failed) return ;

                }
                break;
            case 3 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1076:34: '.'
                {
                match(input,89,FOLLOW_89_in_synpred151_ObjCpp3445); if (state.failed) return ;

                }
                break;

        }

        pushFollow(FOLLOW_functionCall_in_synpred151_ObjCpp3450);
        fc2=functionCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred151_ObjCpp

    // $ANTLR start synpred152_ObjCpp
    public final void synpred152_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.expression_return xif = null;

        ObjCppParser.expression_return xelse = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1083:4: ( '?' xif= expression ':' xelse= expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1083:4: '?' xif= expression ':' xelse= expression
        {
        match(input,90,FOLLOW_90_in_synpred152_ObjCpp3459); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred152_ObjCpp3463);
        xif=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,33,FOLLOW_33_in_synpred152_ObjCpp3465); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred152_ObjCpp3469);
        xelse=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred152_ObjCpp

    // $ANTLR start synpred154_ObjCpp
    public final void synpred154_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1095:3: ( statementsBlock )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1095:3: statementsBlock
        {
        pushFollow(FOLLOW_statementsBlock_in_synpred154_ObjCpp3508);
        statementsBlock();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred154_ObjCpp

    // $ANTLR start synpred155_ObjCpp
    public final void synpred155_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1096:3: ( declaration )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1096:3: declaration
        {
        pushFollow(FOLLOW_declaration_in_synpred155_ObjCpp3514);
        declaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred155_ObjCpp

    // $ANTLR start synpred157_ObjCpp
    public final void synpred157_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1097:3: ( expression ( '=' expression )? ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1097:3: expression ( '=' expression )? ';'
        {
        pushFollow(FOLLOW_expression_in_synpred157_ObjCpp3520);
        expression();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1097:14: ( '=' expression )?
        int alt127=2;
        int LA127_0 = input.LA(1);

        if ( (LA127_0==29) ) {
            alt127=1;
        }
        switch (alt127) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1097:15: '=' expression
                {
                match(input,29,FOLLOW_29_in_synpred157_ObjCpp3523); if (state.failed) return ;
                pushFollow(FOLLOW_expression_in_synpred157_ObjCpp3525);
                expression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }

        match(input,28,FOLLOW_28_in_synpred157_ObjCpp3530); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred157_ObjCpp

    // $ANTLR start synpred159_ObjCpp
    public final void synpred159_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1099:38: ( 'else' statement )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1099:38: 'else' statement
        {
        match(input,93,FOLLOW_93_in_synpred159_ObjCpp3557); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred159_ObjCpp3559);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred159_ObjCpp

    // $ANTLR start synpred163_ObjCpp
    public final void synpred163_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1102:13: ( statement )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1102:13: statement
        {
        pushFollow(FOLLOW_statement_in_synpred163_ObjCpp3603);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred163_ObjCpp

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
    public final boolean synpred125_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred125_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred90_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred90_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred94_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred94_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred85_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred85_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred97_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred97_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred163_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred163_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred154_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred154_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred155_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred155_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred148_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred148_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred147_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred147_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred77_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred77_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred146_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred146_ObjCpp_fragment(); // can never throw exception
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
    protected DFA57 dfa57 = new DFA57(this);
    protected DFA59 dfa59 = new DFA59(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA63 dfa63 = new DFA63(this);
    protected DFA67 dfa67 = new DFA67(this);
    protected DFA69 dfa69 = new DFA69(this);
    protected DFA71 dfa71 = new DFA71(this);
    protected DFA74 dfa74 = new DFA74(this);
    protected DFA77 dfa77 = new DFA77(this);
    protected DFA76 dfa76 = new DFA76(this);
    protected DFA81 dfa81 = new DFA81(this);
    protected DFA84 dfa84 = new DFA84(this);
    protected DFA83 dfa83 = new DFA83(this);
    protected DFA86 dfa86 = new DFA86(this);
    protected DFA87 dfa87 = new DFA87(this);
    protected DFA94 dfa94 = new DFA94(this);
    protected DFA89 dfa89 = new DFA89(this);
    protected DFA90 dfa90 = new DFA90(this);
    protected DFA91 dfa91 = new DFA91(this);
    protected DFA92 dfa92 = new DFA92(this);
    protected DFA93 dfa93 = new DFA93(this);
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
        "\u00db\uffff";
    static final String DFA6_eofS =
        "\u00db\uffff";
    static final String DFA6_minS =
        "\4\6\1\77\2\6\4\uffff\2\6\1\27\4\6\1\66\1\6\2\uffff\1\6\1\77\13"+
        "\6\1\66\1\6\2\uffff\3\6\1\66\1\6\2\uffff\3\0\1\uffff\1\0\1\uffff"+
        "\1\0\1\uffff\27\0\1\uffff\1\0\1\uffff\3\0\2\uffff\5\0\1\uffff\5"+
        "\0\1\uffff\3\0\11\uffff\20\0\2\uffff\5\0\2\uffff\13\0\2\uffff\5"+
        "\0\2\uffff\5\0\2\uffff\6\0\2\uffff\1\0\1\uffff\2\0\4\uffff\5\0\1"+
        "\uffff\5\0\1\uffff\3\0\2\uffff\1\0\1\uffff\2\0\4\uffff\5\0\1\uffff"+
        "\5\0\1\uffff\3\0\2\uffff";
    static final String DFA6_maxS =
        "\1\111\2\27\3\111\1\71\4\uffff\1\71\1\111\1\27\1\6\1\111\2\71\1"+
        "\66\1\111\2\uffff\3\111\1\71\2\27\1\111\1\71\1\111\4\71\1\66\1\71"+
        "\2\uffff\3\71\1\66\1\71\2\uffff\3\0\1\uffff\1\0\1\uffff\1\0\1\uffff"+
        "\27\0\1\uffff\1\0\1\uffff\3\0\2\uffff\5\0\1\uffff\5\0\1\uffff\3"+
        "\0\11\uffff\20\0\2\uffff\5\0\2\uffff\13\0\2\uffff\5\0\2\uffff\5"+
        "\0\2\uffff\6\0\2\uffff\1\0\1\uffff\2\0\4\uffff\5\0\1\uffff\5\0\1"+
        "\uffff\3\0\2\uffff\1\0\1\uffff\2\0\4\uffff\5\0\1\uffff\5\0\1\uffff"+
        "\3\0\2\uffff";
    static final String DFA6_acceptS =
        "\7\uffff\1\3\1\4\1\5\1\6\11\uffff\1\2\34\uffff\1\1\u00a9\uffff";
    static final String DFA6_specialS =
        "\56\uffff\1\0\1\1\1\2\1\uffff\1\3\1\uffff\1\4\1\uffff\1\5\1\6\1"+
        "\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1"+
        "\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\uffff\1\34\1\uffff\1\35"+
        "\1\36\1\37\2\uffff\1\40\1\41\1\42\1\43\1\44\1\uffff\1\45\1\46\1"+
        "\47\1\50\1\51\1\uffff\1\52\1\53\1\54\11\uffff\1\55\1\56\1\57\1\60"+
        "\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\74\2\uffff"+
        "\1\75\1\76\1\77\1\100\1\101\2\uffff\1\102\1\103\1\104\1\105\1\106"+
        "\1\107\1\110\1\111\1\112\1\113\1\114\2\uffff\1\115\1\116\1\117\1"+
        "\120\1\121\2\uffff\1\122\1\123\1\124\1\125\1\126\2\uffff\1\127\1"+
        "\130\1\131\1\132\1\133\1\134\2\uffff\1\135\1\uffff\1\136\1\137\4"+
        "\uffff\1\140\1\141\1\142\1\143\1\144\1\uffff\1\145\1\146\1\147\1"+
        "\150\1\151\1\uffff\1\152\1\153\1\154\2\uffff\1\155\1\uffff\1\156"+
        "\1\157\4\uffff\1\160\1\161\1\162\1\163\1\164\1\uffff\1\165\1\166"+
        "\1\167\1\170\1\171\1\uffff\1\172\1\173\1\174\2\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\3\22\uffff\1\12\1\11\3\uffff\1\2\2\7\14\uffff\3\1\12\uffff"+
            "\1\10\4\4\2\5\11\6",
            "\1\13\20\uffff\1\14",
            "\1\15\20\uffff\1\16",
            "\1\17\25\uffff\1\24\1\uffff\1\33\3\uffff\1\23\1\uffff\1\26"+
            "\10\uffff\3\32\3\uffff\1\20\1\21\1\22\3\uffff\1\24\1\uffff\4"+
            "\27\2\30\11\31",
            "\2\34\11\35",
            "\1\40\25\uffff\1\24\5\uffff\1\44\20\uffff\1\41\1\42\1\43\3"+
            "\uffff\1\24\5\uffff\2\36\11\37",
            "\1\47\25\uffff\1\24\5\uffff\1\53\20\uffff\1\50\1\51\1\52\3"+
            "\uffff\1\24",
            "",
            "",
            "",
            "",
            "\1\56\20\uffff\1\62\4\uffff\1\24\5\uffff\1\64\20\uffff\1\57"+
            "\1\60\1\61\3\uffff\1\24",
            "\1\73\21\uffff\1\103\1\102\1\101\3\uffff\1\72\2\77\14\uffff"+
            "\3\71\1\66\1\67\1\70\7\uffff\1\100\4\74\2\75\11\76",
            "\1\104",
            "\1\105",
            "\1\107\24\uffff\3\24\1\122\3\uffff\1\114\1\uffff\1\120\10\uffff"+
            "\3\121\3\uffff\1\106\1\113\1\116\3\uffff\1\24\1\uffff\4\110"+
            "\2\111\11\112",
            "\1\126\33\uffff\1\125\20\uffff\1\127\1\130\1\131\3\uffff\1"+
            "\24",
            "\1\134\33\uffff\1\133\20\uffff\1\135\1\136\1\137\3\uffff\1"+
            "\24",
            "\1\141",
            "\1\142\27\uffff\1\61\3\uffff\1\24\1\61\10\uffff\4\61\3\uffff"+
            "\1\143\1\24\4\uffff\1\24\1\uffff\17\61",
            "",
            "",
            "\1\157\27\uffff\1\156\6\uffff\1\163\7\uffff\3\155\13\uffff"+
            "\4\160\2\161\11\162",
            "\2\164\11\165",
            "\1\170\25\uffff\1\24\5\uffff\1\174\20\uffff\1\171\1\172\1\173"+
            "\3\uffff\1\24\5\uffff\2\166\11\167",
            "\1\177\25\uffff\1\24\5\uffff\1\u0083\20\uffff\1\u0080\1\u0081"+
            "\1\u0082\3\uffff\1\24",
            "\1\u0086\20\uffff\1\u0087",
            "\1\u0088\20\uffff\1\u0089",
            "\1\u008c\25\uffff\1\24\5\uffff\1\u0090\20\uffff\1\u008d\1\u008e"+
            "\1\u008f\3\uffff\1\24\5\uffff\2\u008a\11\u008b",
            "\1\u0093\25\uffff\1\24\5\uffff\1\u0097\20\uffff\1\u0094\1\u0095"+
            "\1\u0096\3\uffff\1\24",
            "\1\u009a\25\uffff\1\24\5\uffff\1\u009e\20\uffff\1\u009b\1\u009c"+
            "\1\u009d\3\uffff\1\24\5\uffff\13\u00a1",
            "\1\u00a2\25\uffff\1\24\5\uffff\1\u00a6\20\uffff\1\u00a3\1\u00a4"+
            "\1\u00a5\3\uffff\1\24",
            "\1\u00ab\24\uffff\3\24\4\uffff\1\u00ac\20\uffff\1\u00a9\2\24"+
            "\3\uffff\1\24",
            "\1\u00b2\33\uffff\1\u00b1\20\uffff\1\u00b3\1\u00b4\1\u00b5"+
            "\3\uffff\1\24",
            "\1\u00b8\33\uffff\1\u00b7\20\uffff\1\u00b9\1\u00ba\1\u00bb"+
            "\3\uffff\1\24",
            "\1\u00bd",
            "\1\u00be\33\uffff\1\24\20\uffff\1\u00bf\1\24\4\uffff\1\24",
            "",
            "",
            "\1\u00c4\24\uffff\3\24\4\uffff\1\u00c5\20\uffff\1\u00c2\2\24"+
            "\3\uffff\1\24",
            "\1\u00cb\33\uffff\1\u00ca\20\uffff\1\u00cc\1\u00cd\1\u00ce"+
            "\3\uffff\1\24",
            "\1\u00d1\33\uffff\1\u00d0\20\uffff\1\u00d2\1\u00d3\1\u00d4"+
            "\3\uffff\1\24",
            "\1\u00d6",
            "\1\u00d7\33\uffff\1\24\20\uffff\1\u00d8\1\24\4\uffff\1\24",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
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
            "",
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
            "",
            "\1\uffff",
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
            "",
            "\1\uffff",
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
                        int LA6_46 = input.LA(1);

                         
                        int index6_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_46);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_47 = input.LA(1);

                         
                        int index6_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_47);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA6_48 = input.LA(1);

                         
                        int index6_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_48);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA6_50 = input.LA(1);

                         
                        int index6_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_50);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA6_52 = input.LA(1);

                         
                        int index6_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_52);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA6_54 = input.LA(1);

                         
                        int index6_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_54);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA6_55 = input.LA(1);

                         
                        int index6_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_55);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA6_56 = input.LA(1);

                         
                        int index6_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_56);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA6_57 = input.LA(1);

                         
                        int index6_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_57);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA6_58 = input.LA(1);

                         
                        int index6_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_58);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA6_59 = input.LA(1);

                         
                        int index6_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_59);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA6_60 = input.LA(1);

                         
                        int index6_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_60);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA6_61 = input.LA(1);

                         
                        int index6_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_61);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA6_62 = input.LA(1);

                         
                        int index6_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_62);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA6_63 = input.LA(1);

                         
                        int index6_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_63);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA6_64 = input.LA(1);

                         
                        int index6_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_64);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA6_65 = input.LA(1);

                         
                        int index6_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_65);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA6_66 = input.LA(1);

                         
                        int index6_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_66);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA6_67 = input.LA(1);

                         
                        int index6_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_67);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA6_68 = input.LA(1);

                         
                        int index6_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_68);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA6_69 = input.LA(1);

                         
                        int index6_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_69);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA6_70 = input.LA(1);

                         
                        int index6_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_70);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA6_71 = input.LA(1);

                         
                        int index6_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_71);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA6_72 = input.LA(1);

                         
                        int index6_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_72);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA6_73 = input.LA(1);

                         
                        int index6_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_73);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA6_74 = input.LA(1);

                         
                        int index6_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_74);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA6_75 = input.LA(1);

                         
                        int index6_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_75);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA6_76 = input.LA(1);

                         
                        int index6_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_76);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA6_78 = input.LA(1);

                         
                        int index6_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_78);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA6_80 = input.LA(1);

                         
                        int index6_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_80);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA6_81 = input.LA(1);

                         
                        int index6_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_81);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA6_82 = input.LA(1);

                         
                        int index6_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_82);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA6_85 = input.LA(1);

                         
                        int index6_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_85);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA6_86 = input.LA(1);

                         
                        int index6_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_86);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA6_87 = input.LA(1);

                         
                        int index6_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_87);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA6_88 = input.LA(1);

                         
                        int index6_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_88);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA6_89 = input.LA(1);

                         
                        int index6_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_89);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA6_91 = input.LA(1);

                         
                        int index6_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_91);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA6_92 = input.LA(1);

                         
                        int index6_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_92);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA6_93 = input.LA(1);

                         
                        int index6_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_93);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA6_94 = input.LA(1);

                         
                        int index6_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_94);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA6_95 = input.LA(1);

                         
                        int index6_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_95);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA6_97 = input.LA(1);

                         
                        int index6_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_97);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA6_98 = input.LA(1);

                         
                        int index6_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_98);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA6_99 = input.LA(1);

                         
                        int index6_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_99);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA6_109 = input.LA(1);

                         
                        int index6_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_109);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA6_110 = input.LA(1);

                         
                        int index6_110 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_110);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA6_111 = input.LA(1);

                         
                        int index6_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_111);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA6_112 = input.LA(1);

                         
                        int index6_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_112);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA6_113 = input.LA(1);

                         
                        int index6_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_113);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA6_114 = input.LA(1);

                         
                        int index6_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_114);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA6_115 = input.LA(1);

                         
                        int index6_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_115);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA6_116 = input.LA(1);

                         
                        int index6_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_116);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA6_117 = input.LA(1);

                         
                        int index6_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_117);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA6_118 = input.LA(1);

                         
                        int index6_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_118);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA6_119 = input.LA(1);

                         
                        int index6_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_119);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA6_120 = input.LA(1);

                         
                        int index6_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_120);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA6_121 = input.LA(1);

                         
                        int index6_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_121);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA6_122 = input.LA(1);

                         
                        int index6_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_122);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA6_123 = input.LA(1);

                         
                        int index6_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_123);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA6_124 = input.LA(1);

                         
                        int index6_124 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_124);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA6_127 = input.LA(1);

                         
                        int index6_127 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_127);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA6_128 = input.LA(1);

                         
                        int index6_128 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_128);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA6_129 = input.LA(1);

                         
                        int index6_129 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_129);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA6_130 = input.LA(1);

                         
                        int index6_130 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_130);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA6_131 = input.LA(1);

                         
                        int index6_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_131);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA6_134 = input.LA(1);

                         
                        int index6_134 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_134);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA6_135 = input.LA(1);

                         
                        int index6_135 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_135);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA6_136 = input.LA(1);

                         
                        int index6_136 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_136);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA6_137 = input.LA(1);

                         
                        int index6_137 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_137);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA6_138 = input.LA(1);

                         
                        int index6_138 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_138);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA6_139 = input.LA(1);

                         
                        int index6_139 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_139);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA6_140 = input.LA(1);

                         
                        int index6_140 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_140);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA6_141 = input.LA(1);

                         
                        int index6_141 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_141);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA6_142 = input.LA(1);

                         
                        int index6_142 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_142);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA6_143 = input.LA(1);

                         
                        int index6_143 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_143);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA6_144 = input.LA(1);

                         
                        int index6_144 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_144);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA6_147 = input.LA(1);

                         
                        int index6_147 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_147);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA6_148 = input.LA(1);

                         
                        int index6_148 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_148);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA6_149 = input.LA(1);

                         
                        int index6_149 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_149);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA6_150 = input.LA(1);

                         
                        int index6_150 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_150);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA6_151 = input.LA(1);

                         
                        int index6_151 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_151);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA6_154 = input.LA(1);

                         
                        int index6_154 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_154);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA6_155 = input.LA(1);

                         
                        int index6_155 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_155);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA6_156 = input.LA(1);

                         
                        int index6_156 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_156);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA6_157 = input.LA(1);

                         
                        int index6_157 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_157);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA6_158 = input.LA(1);

                         
                        int index6_158 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_158);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA6_161 = input.LA(1);

                         
                        int index6_161 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_161);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA6_162 = input.LA(1);

                         
                        int index6_162 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_162);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA6_163 = input.LA(1);

                         
                        int index6_163 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_163);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA6_164 = input.LA(1);

                         
                        int index6_164 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_164);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA6_165 = input.LA(1);

                         
                        int index6_165 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_165);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA6_166 = input.LA(1);

                         
                        int index6_166 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_166);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA6_169 = input.LA(1);

                         
                        int index6_169 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_169);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA6_171 = input.LA(1);

                         
                        int index6_171 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_171);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA6_172 = input.LA(1);

                         
                        int index6_172 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_172);
                        if ( s>=0 ) return s;
                        break;
                    case 96 : 
                        int LA6_177 = input.LA(1);

                         
                        int index6_177 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_177);
                        if ( s>=0 ) return s;
                        break;
                    case 97 : 
                        int LA6_178 = input.LA(1);

                         
                        int index6_178 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_178);
                        if ( s>=0 ) return s;
                        break;
                    case 98 : 
                        int LA6_179 = input.LA(1);

                         
                        int index6_179 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_179);
                        if ( s>=0 ) return s;
                        break;
                    case 99 : 
                        int LA6_180 = input.LA(1);

                         
                        int index6_180 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_180);
                        if ( s>=0 ) return s;
                        break;
                    case 100 : 
                        int LA6_181 = input.LA(1);

                         
                        int index6_181 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_181);
                        if ( s>=0 ) return s;
                        break;
                    case 101 : 
                        int LA6_183 = input.LA(1);

                         
                        int index6_183 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_183);
                        if ( s>=0 ) return s;
                        break;
                    case 102 : 
                        int LA6_184 = input.LA(1);

                         
                        int index6_184 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_184);
                        if ( s>=0 ) return s;
                        break;
                    case 103 : 
                        int LA6_185 = input.LA(1);

                         
                        int index6_185 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_185);
                        if ( s>=0 ) return s;
                        break;
                    case 104 : 
                        int LA6_186 = input.LA(1);

                         
                        int index6_186 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_186);
                        if ( s>=0 ) return s;
                        break;
                    case 105 : 
                        int LA6_187 = input.LA(1);

                         
                        int index6_187 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_187);
                        if ( s>=0 ) return s;
                        break;
                    case 106 : 
                        int LA6_189 = input.LA(1);

                         
                        int index6_189 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_189);
                        if ( s>=0 ) return s;
                        break;
                    case 107 : 
                        int LA6_190 = input.LA(1);

                         
                        int index6_190 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_190);
                        if ( s>=0 ) return s;
                        break;
                    case 108 : 
                        int LA6_191 = input.LA(1);

                         
                        int index6_191 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_191);
                        if ( s>=0 ) return s;
                        break;
                    case 109 : 
                        int LA6_194 = input.LA(1);

                         
                        int index6_194 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_194);
                        if ( s>=0 ) return s;
                        break;
                    case 110 : 
                        int LA6_196 = input.LA(1);

                         
                        int index6_196 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_196);
                        if ( s>=0 ) return s;
                        break;
                    case 111 : 
                        int LA6_197 = input.LA(1);

                         
                        int index6_197 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_197);
                        if ( s>=0 ) return s;
                        break;
                    case 112 : 
                        int LA6_202 = input.LA(1);

                         
                        int index6_202 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_202);
                        if ( s>=0 ) return s;
                        break;
                    case 113 : 
                        int LA6_203 = input.LA(1);

                         
                        int index6_203 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_203);
                        if ( s>=0 ) return s;
                        break;
                    case 114 : 
                        int LA6_204 = input.LA(1);

                         
                        int index6_204 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_204);
                        if ( s>=0 ) return s;
                        break;
                    case 115 : 
                        int LA6_205 = input.LA(1);

                         
                        int index6_205 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_205);
                        if ( s>=0 ) return s;
                        break;
                    case 116 : 
                        int LA6_206 = input.LA(1);

                         
                        int index6_206 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_206);
                        if ( s>=0 ) return s;
                        break;
                    case 117 : 
                        int LA6_208 = input.LA(1);

                         
                        int index6_208 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_208);
                        if ( s>=0 ) return s;
                        break;
                    case 118 : 
                        int LA6_209 = input.LA(1);

                         
                        int index6_209 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_209);
                        if ( s>=0 ) return s;
                        break;
                    case 119 : 
                        int LA6_210 = input.LA(1);

                         
                        int index6_210 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_210);
                        if ( s>=0 ) return s;
                        break;
                    case 120 : 
                        int LA6_211 = input.LA(1);

                         
                        int index6_211 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_211);
                        if ( s>=0 ) return s;
                        break;
                    case 121 : 
                        int LA6_212 = input.LA(1);

                         
                        int index6_212 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_212);
                        if ( s>=0 ) return s;
                        break;
                    case 122 : 
                        int LA6_214 = input.LA(1);

                         
                        int index6_214 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_214);
                        if ( s>=0 ) return s;
                        break;
                    case 123 : 
                        int LA6_215 = input.LA(1);

                         
                        int index6_215 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_215);
                        if ( s>=0 ) return s;
                        break;
                    case 124 : 
                        int LA6_216 = input.LA(1);

                         
                        int index6_216 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 49;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_216);
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
        "\u00f4\uffff";
    static final String DFA17_eofS =
        "\u00f4\uffff";
    static final String DFA17_minS =
        "\4\6\1\77\5\6\1\66\1\6\1\0\1\6\1\77\4\6\1\uffff\2\6\1\27\10\6\1"+
        "\66\1\6\1\0\1\uffff\3\6\1\66\1\6\1\0\1\uffff\12\0\2\uffff\1\0\1"+
        "\uffff\6\0\2\uffff\5\0\2\uffff\3\0\14\uffff\21\0\1\uffff\6\0\1\uffff"+
        "\12\0\2\uffff\30\0\1\uffff\6\0\1\uffff\7\0\1\uffff\6\0\1\uffff\1"+
        "\0\7\uffff\5\0\2\uffff\5\0\2\uffff\3\0\14\uffff\1\0\7\uffff\5\0"+
        "\2\uffff\5\0\2\uffff\3\0\14\uffff";
    static final String DFA17_maxS =
        "\2\111\2\27\2\111\1\71\1\111\2\71\1\66\1\71\1\0\3\111\1\71\2\27"+
        "\1\uffff\1\71\1\111\1\27\1\6\1\111\1\71\1\111\4\71\1\66\1\71\1\0"+
        "\1\uffff\3\71\1\66\1\71\1\0\1\uffff\12\0\2\uffff\1\0\1\uffff\6\0"+
        "\2\uffff\5\0\2\uffff\3\0\14\uffff\21\0\1\uffff\6\0\1\uffff\12\0"+
        "\2\uffff\30\0\1\uffff\6\0\1\uffff\7\0\1\uffff\6\0\1\uffff\1\0\7"+
        "\uffff\5\0\2\uffff\5\0\2\uffff\3\0\14\uffff\1\0\7\uffff\5\0\2\uffff"+
        "\5\0\2\uffff\3\0\14\uffff";
    static final String DFA17_acceptS =
        "\23\uffff\1\1\53\uffff\1\2\u00b4\uffff";
    static final String DFA17_specialS =
        "\14\uffff\1\0\24\uffff\1\1\6\uffff\1\2\1\uffff\1\3\1\4\1\5\1\6\1"+
        "\7\1\10\1\11\1\12\1\13\1\14\2\uffff\1\15\1\uffff\1\16\1\17\1\20"+
        "\1\21\1\22\1\23\2\uffff\1\24\1\25\1\26\1\27\1\30\2\uffff\1\31\1"+
        "\32\1\33\14\uffff\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1"+
        "\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\uffff\1\55\1\56\1\57\1"+
        "\60\1\61\1\62\1\uffff\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1"+
        "\73\1\74\2\uffff\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1\104\1"+
        "\105\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1\116\1\117"+
        "\1\120\1\121\1\122\1\123\1\124\1\uffff\1\125\1\126\1\127\1\130\1"+
        "\131\1\132\1\uffff\1\133\1\134\1\135\1\136\1\137\1\140\1\141\1\uffff"+
        "\1\142\1\143\1\144\1\145\1\146\1\147\1\uffff\1\150\7\uffff\1\151"+
        "\1\152\1\153\1\154\1\155\2\uffff\1\156\1\157\1\160\1\161\1\162\2"+
        "\uffff\1\163\1\164\1\165\14\uffff\1\166\7\uffff\1\167\1\170\1\171"+
        "\1\172\1\173\2\uffff\1\174\1\175\1\176\1\177\1\u0080\2\uffff\1\u0081"+
        "\1\u0082\1\u0083\14\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\1\27\uffff\1\3\16\uffff\3\2\13\uffff\4\4\2\5\11\6",
            "\1\7\25\uffff\1\14\1\uffff\1\22\3\uffff\1\13\1\uffff\1\15\10"+
            "\uffff\3\21\3\uffff\1\10\1\11\1\12\3\uffff\1\23\1\uffff\4\16"+
            "\2\17\11\20",
            "\1\24\20\uffff\1\25",
            "\1\26\20\uffff\1\27",
            "\2\30\11\31",
            "\1\34\25\uffff\1\41\5\uffff\1\40\20\uffff\1\35\1\36\1\37\3"+
            "\uffff\1\23\5\uffff\2\32\11\33",
            "\1\43\25\uffff\1\50\5\uffff\1\47\20\uffff\1\44\1\45\1\46\3"+
            "\uffff\1\23",
            "\1\53\24\uffff\1\23\1\66\1\23\1\62\3\uffff\1\60\1\uffff\1\70"+
            "\10\uffff\3\61\3\uffff\1\52\1\57\1\63\3\uffff\1\23\1\uffff\4"+
            "\54\2\55\11\56",
            "\1\72\25\uffff\1\77\5\uffff\1\71\20\uffff\1\73\1\74\1\75\3"+
            "\uffff\1\23",
            "\1\101\25\uffff\1\77\5\uffff\1\100\20\uffff\1\102\1\103\1\104"+
            "\3\uffff\1\23",
            "\1\107",
            "\1\110\33\uffff\1\23\20\uffff\1\111\1\23\4\uffff\1\23",
            "\1\uffff",
            "\1\130\27\uffff\1\127\6\uffff\1\134\7\uffff\3\126\13\uffff"+
            "\4\131\2\132\11\133",
            "\2\135\11\136",
            "\1\137\25\uffff\1\144\5\uffff\1\143\20\uffff\1\140\1\141\1"+
            "\142\3\uffff\1\23\5\uffff\2\145\11\146",
            "\1\150\25\uffff\1\155\5\uffff\1\154\20\uffff\1\151\1\152\1"+
            "\153\3\uffff\1\23",
            "\1\157\20\uffff\1\160",
            "\1\161\20\uffff\1\162",
            "",
            "\1\163\20\uffff\1\164\4\uffff\1\167\5\uffff\1\165\20\uffff"+
            "\1\166\1\170\1\77\3\uffff\1\23",
            "\1\u0080\21\uffff\1\u0088\1\u0087\1\u0086\3\uffff\1\177\2\u0084"+
            "\14\uffff\3\176\1\173\1\174\1\175\7\uffff\1\u0085\4\u0081\2"+
            "\u0082\11\u0083",
            "\1\u0089",
            "\1\u008a",
            "\1\u008d\25\uffff\1\u0092\5\uffff\1\u0091\20\uffff\1\u008e"+
            "\1\u008f\1\u0090\3\uffff\1\23\5\uffff\2\u008b\11\u008c",
            "\1\u0094\25\uffff\1\u0099\5\uffff\1\u0098\20\uffff\1\u0095"+
            "\1\u0096\1\u0097\3\uffff\1\23",
            "\1\u009c\25\uffff\1\u00a1\5\uffff\1\u00a0\20\uffff\1\u009d"+
            "\1\u009e\1\u009f\3\uffff\1\23\5\uffff\13\u009b",
            "\1\u00a3\25\uffff\1\u00a8\5\uffff\1\u00a7\20\uffff\1\u00a4"+
            "\1\u00a5\1\u00a6\3\uffff\1\23",
            "\1\23\24\uffff\3\23\4\uffff\1\23\20\uffff\1\u00aa\2\23\3\uffff"+
            "\1\23",
            "\1\u00b3\25\uffff\1\77\5\uffff\1\u00b2\20\uffff\1\u00b4\1\u00b5"+
            "\1\u00b6\3\uffff\1\23",
            "\1\u00ba\25\uffff\1\77\5\uffff\1\u00b9\20\uffff\1\u00bb\1\u00bc"+
            "\1\u00bd\3\uffff\1\23",
            "\1\u00c0",
            "\1\u00c1\33\uffff\1\23\20\uffff\1\u00c2\1\23\4\uffff\1\23",
            "\1\uffff",
            "",
            "\1\23\24\uffff\3\23\4\uffff\1\23\20\uffff\1\u00cf\2\23\3\uffff"+
            "\1\23",
            "\1\u00d8\25\uffff\1\77\5\uffff\1\u00d7\20\uffff\1\u00d9\1\u00da"+
            "\1\u00db\3\uffff\1\23",
            "\1\u00df\25\uffff\1\77\5\uffff\1\u00de\20\uffff\1\u00e0\1\u00e1"+
            "\1\u00e2\3\uffff\1\23",
            "\1\u00e5",
            "\1\u00e6\33\uffff\1\23\20\uffff\1\u00e7\1\23\4\uffff\1\23",
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
            "",
            "",
            "\1\uffff",
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
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            "",
            "",
            "",
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
            "",
            "",
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
                        int LA17_12 = input.LA(1);

                         
                        int index17_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 63;}

                         
                        input.seek(index17_12);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_33 = input.LA(1);

                         
                        int index17_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_33);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA17_40 = input.LA(1);

                         
                        int index17_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_40);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA17_42 = input.LA(1);

                         
                        int index17_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 63;}

                         
                        input.seek(index17_42);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA17_43 = input.LA(1);

                         
                        int index17_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_43);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA17_44 = input.LA(1);

                         
                        int index17_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_44);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA17_45 = input.LA(1);

                         
                        int index17_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_45);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA17_46 = input.LA(1);

                         
                        int index17_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_46);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA17_47 = input.LA(1);

                         
                        int index17_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_47);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA17_48 = input.LA(1);

                         
                        int index17_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_48);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA17_49 = input.LA(1);

                         
                        int index17_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_49);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA17_50 = input.LA(1);

                         
                        int index17_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_50);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA17_51 = input.LA(1);

                         
                        int index17_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_51);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA17_54 = input.LA(1);

                         
                        int index17_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_54);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA17_56 = input.LA(1);

                         
                        int index17_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_56);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA17_57 = input.LA(1);

                         
                        int index17_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 63;}

                         
                        input.seek(index17_57);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA17_58 = input.LA(1);

                         
                        int index17_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 63;}

                         
                        input.seek(index17_58);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA17_59 = input.LA(1);

                         
                        int index17_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 63;}

                         
                        input.seek(index17_59);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA17_60 = input.LA(1);

                         
                        int index17_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 63;}

                         
                        input.seek(index17_60);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA17_61 = input.LA(1);

                         
                        int index17_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 63;}

                         
                        input.seek(index17_61);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA17_64 = input.LA(1);

                         
                        int index17_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 63;}

                         
                        input.seek(index17_64);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA17_65 = input.LA(1);

                         
                        int index17_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 63;}

                         
                        input.seek(index17_65);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA17_66 = input.LA(1);

                         
                        int index17_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 63;}

                         
                        input.seek(index17_66);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA17_67 = input.LA(1);

                         
                        int index17_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 63;}

                         
                        input.seek(index17_67);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA17_68 = input.LA(1);

                         
                        int index17_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 63;}

                         
                        input.seek(index17_68);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA17_71 = input.LA(1);

                         
                        int index17_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 63;}

                         
                        input.seek(index17_71);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA17_72 = input.LA(1);

                         
                        int index17_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 63;}

                         
                        input.seek(index17_72);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA17_73 = input.LA(1);

                         
                        int index17_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 63;}

                         
                        input.seek(index17_73);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA17_86 = input.LA(1);

                         
                        int index17_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 63;}

                         
                        input.seek(index17_86);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA17_87 = input.LA(1);

                         
                        int index17_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 63;}

                         
                        input.seek(index17_87);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA17_88 = input.LA(1);

                         
                        int index17_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 63;}

                         
                        input.seek(index17_88);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA17_89 = input.LA(1);

                         
                        int index17_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 63;}

                         
                        input.seek(index17_89);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA17_90 = input.LA(1);

                         
                        int index17_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 63;}

                         
                        input.seek(index17_90);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA17_91 = input.LA(1);

                         
                        int index17_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 63;}

                         
                        input.seek(index17_91);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA17_92 = input.LA(1);

                         
                        int index17_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 63;}

                         
                        input.seek(index17_92);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA17_93 = input.LA(1);

                         
                        int index17_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_93);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA17_94 = input.LA(1);

                         
                        int index17_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_94);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA17_95 = input.LA(1);

                         
                        int index17_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_95);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA17_96 = input.LA(1);

                         
                        int index17_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_96);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA17_97 = input.LA(1);

                         
                        int index17_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_97);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA17_98 = input.LA(1);

                         
                        int index17_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_98);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA17_99 = input.LA(1);

                         
                        int index17_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_99);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA17_100 = input.LA(1);

                         
                        int index17_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_100);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA17_101 = input.LA(1);

                         
                        int index17_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_101);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA17_102 = input.LA(1);

                         
                        int index17_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_102);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA17_104 = input.LA(1);

                         
                        int index17_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_104);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA17_105 = input.LA(1);

                         
                        int index17_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_105);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA17_106 = input.LA(1);

                         
                        int index17_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_106);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA17_107 = input.LA(1);

                         
                        int index17_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_107);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA17_108 = input.LA(1);

                         
                        int index17_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_108);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA17_109 = input.LA(1);

                         
                        int index17_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 63;}

                         
                        input.seek(index17_109);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA17_111 = input.LA(1);

                         
                        int index17_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 63;}

                         
                        input.seek(index17_111);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA17_112 = input.LA(1);

                         
                        int index17_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 63;}

                         
                        input.seek(index17_112);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA17_113 = input.LA(1);

                         
                        int index17_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 63;}

                         
                        input.seek(index17_113);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA17_114 = input.LA(1);

                         
                        int index17_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 63;}

                         
                        input.seek(index17_114);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA17_115 = input.LA(1);

                         
                        int index17_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_115);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA17_116 = input.LA(1);

                         
                        int index17_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_116);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA17_117 = input.LA(1);

                         
                        int index17_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_117);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA17_118 = input.LA(1);

                         
                        int index17_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_118);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA17_119 = input.LA(1);

                         
                        int index17_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_119);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA17_120 = input.LA(1);

                         
                        int index17_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_120);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA17_123 = input.LA(1);

                         
                        int index17_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_123);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA17_124 = input.LA(1);

                         
                        int index17_124 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_124);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA17_125 = input.LA(1);

                         
                        int index17_125 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_125);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA17_126 = input.LA(1);

                         
                        int index17_126 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_126);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA17_127 = input.LA(1);

                         
                        int index17_127 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_127);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA17_128 = input.LA(1);

                         
                        int index17_128 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_128);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA17_129 = input.LA(1);

                         
                        int index17_129 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_129);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA17_130 = input.LA(1);

                         
                        int index17_130 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_130);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA17_131 = input.LA(1);

                         
                        int index17_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_131);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA17_132 = input.LA(1);

                         
                        int index17_132 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_132);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA17_133 = input.LA(1);

                         
                        int index17_133 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_133);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA17_134 = input.LA(1);

                         
                        int index17_134 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_134);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA17_135 = input.LA(1);

                         
                        int index17_135 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_135);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA17_136 = input.LA(1);

                         
                        int index17_136 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_136);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA17_137 = input.LA(1);

                         
                        int index17_137 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_137);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA17_138 = input.LA(1);

                         
                        int index17_138 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_138);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA17_139 = input.LA(1);

                         
                        int index17_139 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_139);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA17_140 = input.LA(1);

                         
                        int index17_140 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_140);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA17_141 = input.LA(1);

                         
                        int index17_141 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_141);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA17_142 = input.LA(1);

                         
                        int index17_142 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_142);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA17_143 = input.LA(1);

                         
                        int index17_143 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_143);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA17_144 = input.LA(1);

                         
                        int index17_144 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_144);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA17_145 = input.LA(1);

                         
                        int index17_145 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_145);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA17_146 = input.LA(1);

                         
                        int index17_146 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_146);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA17_148 = input.LA(1);

                         
                        int index17_148 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_148);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA17_149 = input.LA(1);

                         
                        int index17_149 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_149);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA17_150 = input.LA(1);

                         
                        int index17_150 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_150);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA17_151 = input.LA(1);

                         
                        int index17_151 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_151);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA17_152 = input.LA(1);

                         
                        int index17_152 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_152);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA17_153 = input.LA(1);

                         
                        int index17_153 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_153);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA17_155 = input.LA(1);

                         
                        int index17_155 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_155);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA17_156 = input.LA(1);

                         
                        int index17_156 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_156);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA17_157 = input.LA(1);

                         
                        int index17_157 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_157);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA17_158 = input.LA(1);

                         
                        int index17_158 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_158);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA17_159 = input.LA(1);

                         
                        int index17_159 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_159);
                        if ( s>=0 ) return s;
                        break;
                    case 96 : 
                        int LA17_160 = input.LA(1);

                         
                        int index17_160 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_160);
                        if ( s>=0 ) return s;
                        break;
                    case 97 : 
                        int LA17_161 = input.LA(1);

                         
                        int index17_161 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_161);
                        if ( s>=0 ) return s;
                        break;
                    case 98 : 
                        int LA17_163 = input.LA(1);

                         
                        int index17_163 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_163);
                        if ( s>=0 ) return s;
                        break;
                    case 99 : 
                        int LA17_164 = input.LA(1);

                         
                        int index17_164 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_164);
                        if ( s>=0 ) return s;
                        break;
                    case 100 : 
                        int LA17_165 = input.LA(1);

                         
                        int index17_165 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_165);
                        if ( s>=0 ) return s;
                        break;
                    case 101 : 
                        int LA17_166 = input.LA(1);

                         
                        int index17_166 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_166);
                        if ( s>=0 ) return s;
                        break;
                    case 102 : 
                        int LA17_167 = input.LA(1);

                         
                        int index17_167 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_167);
                        if ( s>=0 ) return s;
                        break;
                    case 103 : 
                        int LA17_168 = input.LA(1);

                         
                        int index17_168 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_168);
                        if ( s>=0 ) return s;
                        break;
                    case 104 : 
                        int LA17_170 = input.LA(1);

                         
                        int index17_170 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_170);
                        if ( s>=0 ) return s;
                        break;
                    case 105 : 
                        int LA17_178 = input.LA(1);

                         
                        int index17_178 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_178);
                        if ( s>=0 ) return s;
                        break;
                    case 106 : 
                        int LA17_179 = input.LA(1);

                         
                        int index17_179 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_179);
                        if ( s>=0 ) return s;
                        break;
                    case 107 : 
                        int LA17_180 = input.LA(1);

                         
                        int index17_180 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_180);
                        if ( s>=0 ) return s;
                        break;
                    case 108 : 
                        int LA17_181 = input.LA(1);

                         
                        int index17_181 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_181);
                        if ( s>=0 ) return s;
                        break;
                    case 109 : 
                        int LA17_182 = input.LA(1);

                         
                        int index17_182 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_182);
                        if ( s>=0 ) return s;
                        break;
                    case 110 : 
                        int LA17_185 = input.LA(1);

                         
                        int index17_185 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_185);
                        if ( s>=0 ) return s;
                        break;
                    case 111 : 
                        int LA17_186 = input.LA(1);

                         
                        int index17_186 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_186);
                        if ( s>=0 ) return s;
                        break;
                    case 112 : 
                        int LA17_187 = input.LA(1);

                         
                        int index17_187 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_187);
                        if ( s>=0 ) return s;
                        break;
                    case 113 : 
                        int LA17_188 = input.LA(1);

                         
                        int index17_188 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_188);
                        if ( s>=0 ) return s;
                        break;
                    case 114 : 
                        int LA17_189 = input.LA(1);

                         
                        int index17_189 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_189);
                        if ( s>=0 ) return s;
                        break;
                    case 115 : 
                        int LA17_192 = input.LA(1);

                         
                        int index17_192 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_192);
                        if ( s>=0 ) return s;
                        break;
                    case 116 : 
                        int LA17_193 = input.LA(1);

                         
                        int index17_193 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_193);
                        if ( s>=0 ) return s;
                        break;
                    case 117 : 
                        int LA17_194 = input.LA(1);

                         
                        int index17_194 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_194);
                        if ( s>=0 ) return s;
                        break;
                    case 118 : 
                        int LA17_207 = input.LA(1);

                         
                        int index17_207 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_207);
                        if ( s>=0 ) return s;
                        break;
                    case 119 : 
                        int LA17_215 = input.LA(1);

                         
                        int index17_215 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_215);
                        if ( s>=0 ) return s;
                        break;
                    case 120 : 
                        int LA17_216 = input.LA(1);

                         
                        int index17_216 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_216);
                        if ( s>=0 ) return s;
                        break;
                    case 121 : 
                        int LA17_217 = input.LA(1);

                         
                        int index17_217 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_217);
                        if ( s>=0 ) return s;
                        break;
                    case 122 : 
                        int LA17_218 = input.LA(1);

                         
                        int index17_218 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_218);
                        if ( s>=0 ) return s;
                        break;
                    case 123 : 
                        int LA17_219 = input.LA(1);

                         
                        int index17_219 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_219);
                        if ( s>=0 ) return s;
                        break;
                    case 124 : 
                        int LA17_222 = input.LA(1);

                         
                        int index17_222 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_222);
                        if ( s>=0 ) return s;
                        break;
                    case 125 : 
                        int LA17_223 = input.LA(1);

                         
                        int index17_223 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_223);
                        if ( s>=0 ) return s;
                        break;
                    case 126 : 
                        int LA17_224 = input.LA(1);

                         
                        int index17_224 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_224);
                        if ( s>=0 ) return s;
                        break;
                    case 127 : 
                        int LA17_225 = input.LA(1);

                         
                        int index17_225 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_225);
                        if ( s>=0 ) return s;
                        break;
                    case 128 : 
                        int LA17_226 = input.LA(1);

                         
                        int index17_226 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_226);
                        if ( s>=0 ) return s;
                        break;
                    case 129 : 
                        int LA17_229 = input.LA(1);

                         
                        int index17_229 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_229);
                        if ( s>=0 ) return s;
                        break;
                    case 130 : 
                        int LA17_230 = input.LA(1);

                         
                        int index17_230 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_230);
                        if ( s>=0 ) return s;
                        break;
                    case 131 : 
                        int LA17_231 = input.LA(1);

                         
                        int index17_231 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index17_231);
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
        "\1\uffff\1\6\1\uffff\1\6\34\uffff";
    static final String DFA31_minS =
        "\2\6\1\uffff\1\6\1\uffff\1\6\13\uffff\2\0\10\uffff\1\0\4\uffff";
    static final String DFA31_maxS =
        "\1\27\1\71\1\uffff\1\71\1\uffff\1\71\13\uffff\2\0\10\uffff\1\0\4"+
        "\uffff";
    static final String DFA31_acceptS =
        "\2\uffff\1\2\3\uffff\1\1\31\uffff";
    static final String DFA31_specialS =
        "\21\uffff\1\0\1\1\10\uffff\1\2\4\uffff}>";
    static final String[] DFA31_transitionS = {
            "\1\1\20\uffff\1\2",
            "\1\3\20\uffff\1\2\3\uffff\3\6\4\uffff\1\5\1\6\1\uffff\1\6\15"+
            "\uffff\3\6\3\uffff\1\6",
            "",
            "\1\22\20\uffff\1\2\3\uffff\3\6\4\uffff\1\21\1\6\17\uffff\3"+
            "\6\3\uffff\1\6",
            "",
            "\1\33\33\uffff\1\6\1\2\17\uffff\2\6\4\uffff\1\6",
            "",
            "",
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
            "",
            "",
            "",
            "\1\uffff",
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
                        int LA31_17 = input.LA(1);

                         
                        int index31_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred40_ObjCpp()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index31_17);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA31_18 = input.LA(1);

                         
                        int index31_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred40_ObjCpp()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index31_18);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA31_27 = input.LA(1);

                         
                        int index31_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred40_ObjCpp()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index31_27);
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
                        if ( (((synpred47_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred47_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred47_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 1;}

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
        "\2\6\6\uffff\1\4\2\uffff\1\6\3\uffff\13\0\24\uffff\1\0\4\uffff\1"+
        "\0";
    static final String DFA35_maxS =
        "\2\63\6\uffff\1\141\2\uffff\1\111\3\uffff\13\0\24\uffff\1\0\4\uffff"+
        "\1\0";
    static final String DFA35_acceptS =
        "\2\uffff\1\2\3\uffff\1\1\3\uffff\1\1\51\uffff";
    static final String DFA35_specialS =
        "\17\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\24\uffff"+
        "\1\13\4\uffff\1\14}>";
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
            "\1\56\27\uffff\1\2\4\uffff\1\63\10\uffff\4\2\13\uffff\17\2",
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
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "\1\uffff"
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
                        int LA35_46 = input.LA(1);

                         
                        int index35_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 10;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_46);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA35_51 = input.LA(1);

                         
                        int index35_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 10;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_51);
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
    static final String DFA57_eotS =
        "\65\uffff";
    static final String DFA57_eofS =
        "\1\6\64\uffff";
    static final String DFA57_minS =
        "\1\6\5\0\57\uffff";
    static final String DFA57_maxS =
        "\1\71\5\0\57\uffff";
    static final String DFA57_acceptS =
        "\6\uffff\1\2\20\uffff\1\1\35\uffff";
    static final String DFA57_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\57\uffff}>";
    static final String[] DFA57_transitionS = {
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

    static final short[] DFA57_eot = DFA.unpackEncodedString(DFA57_eotS);
    static final short[] DFA57_eof = DFA.unpackEncodedString(DFA57_eofS);
    static final char[] DFA57_min = DFA.unpackEncodedStringToUnsignedChars(DFA57_minS);
    static final char[] DFA57_max = DFA.unpackEncodedStringToUnsignedChars(DFA57_maxS);
    static final short[] DFA57_accept = DFA.unpackEncodedString(DFA57_acceptS);
    static final short[] DFA57_special = DFA.unpackEncodedString(DFA57_specialS);
    static final short[][] DFA57_transition;

    static {
        int numStates = DFA57_transitionS.length;
        DFA57_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA57_transition[i] = DFA.unpackEncodedString(DFA57_transitionS[i]);
        }
    }

    class DFA57 extends DFA {

        public DFA57(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 57;
            this.eot = DFA57_eot;
            this.eof = DFA57_eof;
            this.min = DFA57_min;
            this.max = DFA57_max;
            this.accept = DFA57_accept;
            this.special = DFA57_special;
            this.transition = DFA57_transition;
        }
        public String getDescription() {
            return "713:3: ( ( typeMutator )* functionSignatureSuffix )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA57_1 = input.LA(1);

                         
                        int index57_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred77_ObjCpp()&&( next("const", "__const") ))) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index57_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA57_2 = input.LA(1);

                         
                        int index57_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred77_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index57_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA57_3 = input.LA(1);

                         
                        int index57_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred77_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index57_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA57_4 = input.LA(1);

                         
                        int index57_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred77_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index57_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA57_5 = input.LA(1);

                         
                        int index57_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred77_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index57_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 57, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA59_eotS =
        "\27\uffff";
    static final String DFA59_eofS =
        "\2\uffff\1\1\24\uffff";
    static final String DFA59_minS =
        "\1\6\1\uffff\1\6\3\uffff\1\6\6\uffff\1\0\11\uffff";
    static final String DFA59_maxS =
        "\1\71\1\uffff\1\71\3\uffff\1\111\6\uffff\1\0\11\uffff";
    static final String DFA59_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\22\uffff";
    static final String DFA59_specialS =
        "\15\uffff\1\0\11\uffff}>";
    static final String[] DFA59_transitionS = {
            "\1\2\33\uffff\1\1\20\uffff\2\1\4\uffff\1\1",
            "",
            "\1\4\24\uffff\3\1\4\uffff\1\6\1\1\17\uffff\2\4\1\1\3\uffff"+
            "\1\4",
            "",
            "",
            "",
            "\1\15\27\uffff\1\1\3\uffff\1\4\1\1\10\uffff\4\1\3\uffff\2\4"+
            "\4\uffff\1\4\1\uffff\17\1",
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
            ""
    };

    static final short[] DFA59_eot = DFA.unpackEncodedString(DFA59_eotS);
    static final short[] DFA59_eof = DFA.unpackEncodedString(DFA59_eofS);
    static final char[] DFA59_min = DFA.unpackEncodedStringToUnsignedChars(DFA59_minS);
    static final char[] DFA59_max = DFA.unpackEncodedStringToUnsignedChars(DFA59_maxS);
    static final short[] DFA59_accept = DFA.unpackEncodedString(DFA59_acceptS);
    static final short[] DFA59_special = DFA.unpackEncodedString(DFA59_specialS);
    static final short[][] DFA59_transition;

    static {
        int numStates = DFA59_transitionS.length;
        DFA59_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA59_transition[i] = DFA.unpackEncodedString(DFA59_transitionS[i]);
        }
    }

    class DFA59 extends DFA {

        public DFA59(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 59;
            this.eot = DFA59_eot;
            this.eof = DFA59_eof;
            this.min = DFA59_min;
            this.max = DFA59_max;
            this.accept = DFA59_accept;
            this.special = DFA59_special;
            this.transition = DFA59_transition;
        }
        public String getDescription() {
            return "()* loopback of 728:3: ({...}? modifier )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA59_13 = input.LA(1);

                         
                        int index59_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred78_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 4;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_13);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 59, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA61_eotS =
        "\23\uffff";
    static final String DFA61_eofS =
        "\1\2\22\uffff";
    static final String DFA61_minS =
        "\1\33\1\0\21\uffff";
    static final String DFA61_maxS =
        "\1\43\1\0\21\uffff";
    static final String DFA61_acceptS =
        "\2\uffff\1\2\17\uffff\1\1";
    static final String DFA61_specialS =
        "\1\uffff\1\0\21\uffff}>";
    static final String[] DFA61_transitionS = {
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

    static final short[] DFA61_eot = DFA.unpackEncodedString(DFA61_eotS);
    static final short[] DFA61_eof = DFA.unpackEncodedString(DFA61_eofS);
    static final char[] DFA61_min = DFA.unpackEncodedStringToUnsignedChars(DFA61_minS);
    static final char[] DFA61_max = DFA.unpackEncodedStringToUnsignedChars(DFA61_maxS);
    static final short[] DFA61_accept = DFA.unpackEncodedString(DFA61_acceptS);
    static final short[] DFA61_special = DFA.unpackEncodedString(DFA61_specialS);
    static final short[][] DFA61_transition;

    static {
        int numStates = DFA61_transitionS.length;
        DFA61_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA61_transition[i] = DFA.unpackEncodedString(DFA61_transitionS[i]);
        }
    }

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = DFA61_eot;
            this.eof = DFA61_eof;
            this.min = DFA61_min;
            this.max = DFA61_max;
            this.accept = DFA61_accept;
            this.special = DFA61_special;
            this.transition = DFA61_transition;
        }
        public String getDescription() {
            return "748:4: ( '=' expression )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA61_1 = input.LA(1);

                         
                        int index61_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 18;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 61, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA63_eotS =
        "\26\uffff";
    static final String DFA63_eofS =
        "\26\uffff";
    static final String DFA63_minS =
        "\1\6\2\uffff\1\0\22\uffff";
    static final String DFA63_maxS =
        "\1\111\2\uffff\1\0\22\uffff";
    static final String DFA63_acceptS =
        "\1\uffff\1\3\22\uffff\1\1\1\2";
    static final String DFA63_specialS =
        "\3\uffff\1\0\22\uffff}>";
    static final String[] DFA63_transitionS = {
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
            "",
            ""
    };

    static final short[] DFA63_eot = DFA.unpackEncodedString(DFA63_eotS);
    static final short[] DFA63_eof = DFA.unpackEncodedString(DFA63_eofS);
    static final char[] DFA63_min = DFA.unpackEncodedStringToUnsignedChars(DFA63_minS);
    static final char[] DFA63_max = DFA.unpackEncodedStringToUnsignedChars(DFA63_maxS);
    static final short[] DFA63_accept = DFA.unpackEncodedString(DFA63_acceptS);
    static final short[] DFA63_special = DFA.unpackEncodedString(DFA63_specialS);
    static final short[][] DFA63_transition;

    static {
        int numStates = DFA63_transitionS.length;
        DFA63_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA63_transition[i] = DFA.unpackEncodedString(DFA63_transitionS[i]);
        }
    }

    class DFA63 extends DFA {

        public DFA63(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 63;
            this.eot = DFA63_eot;
            this.eof = DFA63_eof;
            this.min = DFA63_min;
            this.max = DFA63_max;
            this.accept = DFA63_accept;
            this.special = DFA63_special;
            this.transition = DFA63_transition;
        }
        public String getDescription() {
            return "()* loopback of 789:4: ({...}?sm= modifier | {...}?tm= modifier )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA63_3 = input.LA(1);

                         
                        int index63_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred84_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 20;}

                        else if ( (((synpred85_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 21;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 1;}

                         
                        input.seek(index63_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 63, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA67_eotS =
        "\13\uffff";
    static final String DFA67_eofS =
        "\13\uffff";
    static final String DFA67_minS =
        "\1\6\1\0\11\uffff";
    static final String DFA67_maxS =
        "\1\71\1\0\11\uffff";
    static final String DFA67_acceptS =
        "\2\uffff\1\2\7\uffff\1\1";
    static final String DFA67_specialS =
        "\1\uffff\1\0\11\uffff}>";
    static final String[] DFA67_transitionS = {
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

    static final short[] DFA67_eot = DFA.unpackEncodedString(DFA67_eotS);
    static final short[] DFA67_eof = DFA.unpackEncodedString(DFA67_eofS);
    static final char[] DFA67_min = DFA.unpackEncodedStringToUnsignedChars(DFA67_minS);
    static final char[] DFA67_max = DFA.unpackEncodedStringToUnsignedChars(DFA67_maxS);
    static final short[] DFA67_accept = DFA.unpackEncodedString(DFA67_acceptS);
    static final short[] DFA67_special = DFA.unpackEncodedString(DFA67_specialS);
    static final short[][] DFA67_transition;

    static {
        int numStates = DFA67_transitionS.length;
        DFA67_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA67_transition[i] = DFA.unpackEncodedString(DFA67_transitionS[i]);
        }
    }

    class DFA67 extends DFA {

        public DFA67(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 67;
            this.eot = DFA67_eot;
            this.eof = DFA67_eof;
            this.min = DFA67_min;
            this.max = DFA67_max;
            this.accept = DFA67_accept;
            this.special = DFA67_special;
            this.transition = DFA67_transition;
        }
        public String getDescription() {
            return "()* loopback of 861:4: (im= modifier )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA67_1 = input.LA(1);

                         
                        int index67_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred90_ObjCpp()&&( Modifier.parseModifier(next()) != null ))) ) {s = 10;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index67_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 67, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA69_eotS =
        "\16\uffff";
    static final String DFA69_eofS =
        "\16\uffff";
    static final String DFA69_minS =
        "\1\4\15\uffff";
    static final String DFA69_maxS =
        "\1\114\15\uffff";
    static final String DFA69_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA69_specialS =
        "\16\uffff}>";
    static final String[] DFA69_transitionS = {
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

    static final short[] DFA69_eot = DFA.unpackEncodedString(DFA69_eotS);
    static final short[] DFA69_eof = DFA.unpackEncodedString(DFA69_eofS);
    static final char[] DFA69_min = DFA.unpackEncodedStringToUnsignedChars(DFA69_minS);
    static final char[] DFA69_max = DFA.unpackEncodedStringToUnsignedChars(DFA69_maxS);
    static final short[] DFA69_accept = DFA.unpackEncodedString(DFA69_acceptS);
    static final short[] DFA69_special = DFA.unpackEncodedString(DFA69_specialS);
    static final short[][] DFA69_transition;

    static {
        int numStates = DFA69_transitionS.length;
        DFA69_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA69_transition[i] = DFA.unpackEncodedString(DFA69_transitionS[i]);
        }
    }

    class DFA69 extends DFA {

        public DFA69(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 69;
            this.eot = DFA69_eot;
            this.eof = DFA69_eof;
            this.min = DFA69_min;
            this.max = DFA69_max;
            this.accept = DFA69_accept;
            this.special = DFA69_special;
            this.transition = DFA69_transition;
        }
        public String getDescription() {
            return "871:4: ( expression | )";
        }
    }
    static final String DFA71_eotS =
        "\14\uffff";
    static final String DFA71_eofS =
        "\14\uffff";
    static final String DFA71_minS =
        "\1\33\1\6\1\uffff\1\0\10\uffff";
    static final String DFA71_maxS =
        "\1\43\1\111\1\uffff\1\0\10\uffff";
    static final String DFA71_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\7\uffff";
    static final String DFA71_specialS =
        "\3\uffff\1\0\10\uffff}>";
    static final String[] DFA71_transitionS = {
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

    static final short[] DFA71_eot = DFA.unpackEncodedString(DFA71_eotS);
    static final short[] DFA71_eof = DFA.unpackEncodedString(DFA71_eofS);
    static final char[] DFA71_min = DFA.unpackEncodedStringToUnsignedChars(DFA71_minS);
    static final char[] DFA71_max = DFA.unpackEncodedStringToUnsignedChars(DFA71_maxS);
    static final short[] DFA71_accept = DFA.unpackEncodedString(DFA71_acceptS);
    static final short[] DFA71_special = DFA.unpackEncodedString(DFA71_specialS);
    static final short[][] DFA71_transition;

    static {
        int numStates = DFA71_transitionS.length;
        DFA71_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA71_transition[i] = DFA.unpackEncodedString(DFA71_transitionS[i]);
        }
    }

    class DFA71 extends DFA {

        public DFA71(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 71;
            this.eot = DFA71_eot;
            this.eof = DFA71_eof;
            this.min = DFA71_min;
            this.max = DFA71_max;
            this.accept = DFA71_accept;
            this.special = DFA71_special;
            this.transition = DFA71_transition;
        }
        public String getDescription() {
            return "()* loopback of 898:4: ( ',' ax= argDef )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA71_3 = input.LA(1);

                         
                        int index71_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index71_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 71, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA74_eotS =
        "\61\uffff";
    static final String DFA74_eofS =
        "\1\1\60\uffff";
    static final String DFA74_minS =
        "\1\6\2\uffff\1\0\3\uffff\3\0\47\uffff";
    static final String DFA74_maxS =
        "\1\71\2\uffff\1\0\3\uffff\3\0\47\uffff";
    static final String DFA74_acceptS =
        "\1\uffff\1\2\25\uffff\1\1\31\uffff";
    static final String DFA74_specialS =
        "\3\uffff\1\0\3\uffff\1\1\1\2\1\3\47\uffff}>";
    static final String[] DFA74_transitionS = {
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

    static final short[] DFA74_eot = DFA.unpackEncodedString(DFA74_eotS);
    static final short[] DFA74_eof = DFA.unpackEncodedString(DFA74_eofS);
    static final char[] DFA74_min = DFA.unpackEncodedStringToUnsignedChars(DFA74_minS);
    static final char[] DFA74_max = DFA.unpackEncodedStringToUnsignedChars(DFA74_maxS);
    static final short[] DFA74_accept = DFA.unpackEncodedString(DFA74_acceptS);
    static final short[] DFA74_special = DFA.unpackEncodedString(DFA74_specialS);
    static final short[][] DFA74_transition;

    static {
        int numStates = DFA74_transitionS.length;
        DFA74_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA74_transition[i] = DFA.unpackEncodedString(DFA74_transitionS[i]);
        }
    }

    class DFA74 extends DFA {

        public DFA74(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 74;
            this.eot = DFA74_eot;
            this.eof = DFA74_eof;
            this.min = DFA74_min;
            this.max = DFA74_max;
            this.accept = DFA74_accept;
            this.special = DFA74_special;
            this.transition = DFA74_transition;
        }
        public String getDescription() {
            return "()* loopback of 919:3: ( typeMutator )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA74_3 = input.LA(1);

                         
                        int index74_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred97_ObjCpp()&&( next("const", "__const") ))) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index74_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA74_7 = input.LA(1);

                         
                        int index74_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred97_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index74_7);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA74_8 = input.LA(1);

                         
                        int index74_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred97_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index74_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA74_9 = input.LA(1);

                         
                        int index74_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred97_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index74_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 74, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA77_eotS =
        "\21\uffff";
    static final String DFA77_eofS =
        "\1\uffff\1\2\17\uffff";
    static final String DFA77_minS =
        "\1\77\1\6\17\uffff";
    static final String DFA77_maxS =
        "\2\111\17\uffff";
    static final String DFA77_acceptS =
        "\2\uffff\1\2\14\uffff\1\1\1\uffff";
    static final String DFA77_specialS =
        "\21\uffff}>";
    static final String[] DFA77_transitionS = {
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
            return "952:4: (mod2= primSizeModifier (mod3= primSizeModifier )? )?";
        }
    }
    static final String DFA76_eotS =
        "\20\uffff";
    static final String DFA76_eofS =
        "\1\uffff\1\2\16\uffff";
    static final String DFA76_minS =
        "\1\77\1\6\16\uffff";
    static final String DFA76_maxS =
        "\2\111\16\uffff";
    static final String DFA76_acceptS =
        "\2\uffff\1\2\1\1\14\uffff";
    static final String DFA76_specialS =
        "\20\uffff}>";
    static final String[] DFA76_transitionS = {
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

    static final short[] DFA76_eot = DFA.unpackEncodedString(DFA76_eotS);
    static final short[] DFA76_eof = DFA.unpackEncodedString(DFA76_eofS);
    static final char[] DFA76_min = DFA.unpackEncodedStringToUnsignedChars(DFA76_minS);
    static final char[] DFA76_max = DFA.unpackEncodedStringToUnsignedChars(DFA76_maxS);
    static final short[] DFA76_accept = DFA.unpackEncodedString(DFA76_acceptS);
    static final short[] DFA76_special = DFA.unpackEncodedString(DFA76_specialS);
    static final short[][] DFA76_transition;

    static {
        int numStates = DFA76_transitionS.length;
        DFA76_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA76_transition[i] = DFA.unpackEncodedString(DFA76_transitionS[i]);
        }
    }

    class DFA76 extends DFA {

        public DFA76(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 76;
            this.eot = DFA76_eot;
            this.eof = DFA76_eof;
            this.min = DFA76_min;
            this.max = DFA76_max;
            this.accept = DFA76_accept;
            this.special = DFA76_special;
            this.transition = DFA76_transition;
        }
        public String getDescription() {
            return "953:8: (mod3= primSizeModifier )?";
        }
    }
    static final String DFA81_eotS =
        "\16\uffff";
    static final String DFA81_eofS =
        "\16\uffff";
    static final String DFA81_minS =
        "\1\4\15\uffff";
    static final String DFA81_maxS =
        "\1\114\15\uffff";
    static final String DFA81_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA81_specialS =
        "\16\uffff}>";
    static final String[] DFA81_transitionS = {
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

    static final short[] DFA81_eot = DFA.unpackEncodedString(DFA81_eotS);
    static final short[] DFA81_eof = DFA.unpackEncodedString(DFA81_eofS);
    static final char[] DFA81_min = DFA.unpackEncodedStringToUnsignedChars(DFA81_minS);
    static final char[] DFA81_max = DFA.unpackEncodedStringToUnsignedChars(DFA81_maxS);
    static final short[] DFA81_accept = DFA.unpackEncodedString(DFA81_acceptS);
    static final short[] DFA81_special = DFA.unpackEncodedString(DFA81_specialS);
    static final short[][] DFA81_transition;

    static {
        int numStates = DFA81_transitionS.length;
        DFA81_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA81_transition[i] = DFA.unpackEncodedString(DFA81_transitionS[i]);
        }
    }

    class DFA81 extends DFA {

        public DFA81(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 81;
            this.eot = DFA81_eot;
            this.eof = DFA81_eof;
            this.min = DFA81_min;
            this.max = DFA81_max;
            this.accept = DFA81_accept;
            this.special = DFA81_special;
            this.transition = DFA81_transition;
        }
        public String getDescription() {
            return "1022:3: (a1= expression ( ',' ax= expression )* )?";
        }
    }
    static final String DFA84_eotS =
        "\33\uffff";
    static final String DFA84_eofS =
        "\1\uffff\1\16\31\uffff";
    static final String DFA84_minS =
        "\1\4\1\6\31\uffff";
    static final String DFA84_maxS =
        "\1\114\1\132\31\uffff";
    static final String DFA84_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\5\uffff\1\7\1\uffff\1\1\14\uffff";
    static final String DFA84_specialS =
        "\33\uffff}>";
    static final String[] DFA84_transitionS = {
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
            return "1036:4: (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' )";
        }
    }
    static final String DFA83_eotS =
        "\172\uffff";
    static final String DFA83_eofS =
        "\34\uffff\1\2\135\uffff";
    static final String DFA83_minS =
        "\1\4\1\6\20\uffff\1\4\6\uffff\2\4\1\uffff\2\4\6\uffff\1\0\16\uffff"+
        "\1\0\2\uffff\1\0\2\uffff\1\0\10\uffff\1\0\2\uffff\2\0\25\uffff\1"+
        "\0\15\uffff\1\0\17\uffff";
    static final String DFA83_maxS =
        "\1\114\1\132\20\uffff\1\114\6\uffff\2\114\1\uffff\1\132\1\114\6"+
        "\uffff\1\0\16\uffff\1\0\2\uffff\1\0\2\uffff\1\0\10\uffff\1\0\2\uffff"+
        "\2\0\25\uffff\1\0\15\uffff\1\0\17\uffff";
    static final String DFA83_acceptS =
        "\2\uffff\1\1\12\uffff\1\2\154\uffff";
    static final String DFA83_specialS =
        "\44\uffff\1\0\16\uffff\1\1\2\uffff\1\2\2\uffff\1\3\10\uffff\1\4"+
        "\2\uffff\1\5\1\6\25\uffff\1\7\15\uffff\1\10\17\uffff}>";
    static final String[] DFA83_transitionS = {
            "\2\2\1\1\4\2\14\uffff\1\2\6\uffff\1\15\3\uffff\1\2\12\uffff"+
            "\3\15\5\uffff\1\2\5\uffff\17\15\3\2",
            "\1\15\26\uffff\1\2\1\15\2\uffff\1\2\1\22\1\34\1\35\1\2\4\uffff"+
            "\2\2\1\uffff\3\15\3\uffff\1\31\1\32\1\15\3\uffff\1\2\1\uffff"+
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
            "\2\2\1\63\4\2\14\uffff\1\2\12\uffff\1\71\1\15\17\uffff\2\15"+
            "\1\66\24\uffff\3\2",
            "\2\2\1\102\4\2\14\uffff\1\2\12\uffff\1\106\1\15\17\uffff\2"+
            "\15\1\105\24\uffff\3\2",
            "",
            "\2\15\1\134\4\15\14\uffff\1\15\1\2\2\uffff\3\2\3\uffff\1\2"+
            "\1\15\3\2\4\uffff\2\2\7\uffff\2\2\1\15\1\2\2\uffff\1\2\20\uffff"+
            "\3\15\16\2",
            "\2\2\1\152\4\2\14\uffff\1\2\6\uffff\1\15\3\uffff\1\2\2\uffff"+
            "\1\15\7\uffff\3\15\5\uffff\1\2\5\uffff\17\15\3\2",
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
            "\1\uffff",
            "",
            "",
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
            "",
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
            return "1049:8: (par= expression ')' | typeRef ')' casted= expression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA83_36 = input.LA(1);

                         
                        int index83_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred125_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index83_36);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA83_51 = input.LA(1);

                         
                        int index83_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred125_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index83_51);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA83_54 = input.LA(1);

                         
                        int index83_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred125_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index83_54);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA83_57 = input.LA(1);

                         
                        int index83_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred125_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index83_57);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA83_66 = input.LA(1);

                         
                        int index83_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred125_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index83_66);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA83_69 = input.LA(1);

                         
                        int index83_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred125_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index83_69);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA83_70 = input.LA(1);

                         
                        int index83_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred125_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index83_70);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA83_92 = input.LA(1);

                         
                        int index83_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred125_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index83_92);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA83_106 = input.LA(1);

                         
                        int index83_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred125_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index83_106);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 83, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA86_eotS =
        "\146\uffff";
    static final String DFA86_eofS =
        "\1\1\145\uffff";
    static final String DFA86_minS =
        "\1\6\5\uffff\1\0\2\uffff\5\0\130\uffff";
    static final String DFA86_maxS =
        "\1\132\5\uffff\1\0\2\uffff\5\0\130\uffff";
    static final String DFA86_acceptS =
        "\1\uffff\1\6\30\uffff\1\2\15\uffff\1\1\1\4\2\uffff\1\3\70\uffff"+
        "\1\5";
    static final String DFA86_specialS =
        "\6\uffff\1\0\2\uffff\1\1\1\2\1\3\1\4\1\5\130\uffff}>";
    static final String[] DFA86_transitionS = {
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

    static final short[] DFA86_eot = DFA.unpackEncodedString(DFA86_eotS);
    static final short[] DFA86_eof = DFA.unpackEncodedString(DFA86_eofS);
    static final char[] DFA86_min = DFA.unpackEncodedStringToUnsignedChars(DFA86_minS);
    static final char[] DFA86_max = DFA.unpackEncodedStringToUnsignedChars(DFA86_maxS);
    static final short[] DFA86_accept = DFA.unpackEncodedString(DFA86_acceptS);
    static final short[] DFA86_special = DFA.unpackEncodedString(DFA86_specialS);
    static final short[][] DFA86_transition;

    static {
        int numStates = DFA86_transitionS.length;
        DFA86_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA86_transition[i] = DFA.unpackEncodedString(DFA86_transitionS[i]);
        }
    }

    class DFA86 extends DFA {

        public DFA86(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 86;
            this.eot = DFA86_eot;
            this.eof = DFA86_eof;
            this.min = DFA86_min;
            this.max = DFA86_max;
            this.accept = DFA86_accept;
            this.special = DFA86_special;
            this.transition = DFA86_transition;
        }
        public String getDescription() {
            return "()* loopback of 1062:3: (bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA86_6 = input.LA(1);

                         
                        int index86_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred147_ObjCpp()) ) {s = 26;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index86_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA86_9 = input.LA(1);

                         
                        int index86_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred146_ObjCpp()) ) {s = 40;}

                        else if ( (synpred151_ObjCpp()) ) {s = 41;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index86_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA86_10 = input.LA(1);

                         
                        int index86_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred148_ObjCpp()) ) {s = 44;}

                        else if ( (synpred151_ObjCpp()) ) {s = 41;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index86_10);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA86_11 = input.LA(1);

                         
                        int index86_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_ObjCpp()) ) {s = 41;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index86_11);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA86_12 = input.LA(1);

                         
                        int index86_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred146_ObjCpp()) ) {s = 40;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index86_12);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA86_13 = input.LA(1);

                         
                        int index86_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 101;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index86_13);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 86, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA87_eotS =
        "\36\uffff";
    static final String DFA87_eofS =
        "\36\uffff";
    static final String DFA87_minS =
        "\1\4\35\uffff";
    static final String DFA87_maxS =
        "\1\141\35\uffff";
    static final String DFA87_acceptS =
        "\1\uffff\1\2\1\1\33\uffff";
    static final String DFA87_specialS =
        "\36\uffff}>";
    static final String[] DFA87_transitionS = {
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
            return "()* loopback of 1091:8: ( statement )*";
        }
    }
    static final String DFA94_eotS =
        "\u014c\uffff";
    static final String DFA94_eofS =
        "\u014c\uffff";
    static final String DFA94_minS =
        "\2\4\2\uffff\1\6\30\uffff\1\4\2\uffff\1\6\7\uffff\1\42\3\4\6\30"+
        "\10\uffff\1\4\6\uffff\2\4\1\uffff\1\4\4\uffff\1\4\1\uffff\1\0\1"+
        "\uffff\1\0\2\uffff\1\0\7\uffff\12\0\10\uffff\1\0\6\uffff\2\0\1\uffff"+
        "\2\0\1\uffff\6\0\1\uffff\60\0\2\uffff\6\0\2\uffff\6\0\2\uffff\6"+
        "\0\2\uffff\6\0\2\uffff\6\0\2\uffff\1\0\1\uffff\6\0\2\uffff\1\0\12"+
        "\uffff\2\0\2\uffff\1\0\12\uffff\1\0\2\uffff\1\0\1\uffff\1\0\13\uffff"+
        "\1\0\17\uffff\1\0\1\uffff\1\0\54\uffff";
    static final String DFA94_maxS =
        "\2\141\2\uffff\1\132\30\uffff\1\141\2\uffff\1\132\7\uffff\1\42\3"+
        "\114\6\132\10\uffff\1\114\6\uffff\2\114\1\uffff\1\114\4\uffff\1"+
        "\114\1\uffff\1\0\1\uffff\1\0\2\uffff\1\0\7\uffff\12\0\10\uffff\1"+
        "\0\6\uffff\2\0\1\uffff\2\0\1\uffff\6\0\1\uffff\60\0\2\uffff\6\0"+
        "\2\uffff\6\0\2\uffff\6\0\2\uffff\6\0\2\uffff\6\0\2\uffff\1\0\1\uffff"+
        "\6\0\2\uffff\1\0\12\uffff\2\0\2\uffff\1\0\12\uffff\1\0\2\uffff\1"+
        "\0\1\uffff\1\0\13\uffff\1\0\17\uffff\1\0\1\uffff\1\0\54\uffff";
    static final String DFA94_acceptS =
        "\2\uffff\1\2\11\uffff\1\3\11\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
        "\1\uffff\1\1\u012c\uffff\1\13";
    static final String DFA94_specialS =
        "\113\uffff\1\0\1\uffff\1\1\2\uffff\1\2\7\uffff\1\3\1\4\1\5\1\6\1"+
        "\7\1\10\1\11\1\12\1\13\1\14\10\uffff\1\15\6\uffff\1\16\1\17\1\uffff"+
        "\1\20\1\21\1\uffff\1\22\1\23\1\24\1\25\1\26\1\27\1\uffff\1\30\1"+
        "\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45"+
        "\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62"+
        "\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77"+
        "\1\100\1\101\1\102\1\103\1\104\1\105\1\106\1\107\2\uffff\1\110\1"+
        "\111\1\112\1\113\1\114\1\115\2\uffff\1\116\1\117\1\120\1\121\1\122"+
        "\1\123\2\uffff\1\124\1\125\1\126\1\127\1\130\1\131\2\uffff\1\132"+
        "\1\133\1\134\1\135\1\136\1\137\2\uffff\1\140\1\141\1\142\1\143\1"+
        "\144\1\145\2\uffff\1\146\1\uffff\1\147\1\150\1\151\1\152\1\153\1"+
        "\154\2\uffff\1\155\12\uffff\1\156\1\157\2\uffff\1\160\12\uffff\1"+
        "\161\2\uffff\1\162\1\uffff\1\163\13\uffff\1\164\17\uffff\1\165\1"+
        "\uffff\1\166\54\uffff}>";
    static final String[] DFA94_transitionS = {
            "\2\14\1\4\4\14\14\uffff\1\1\1\uffff\2\2\1\uffff\1\34\1\uffff"+
            "\3\2\1\uffff\1\14\12\uffff\3\2\5\uffff\1\14\4\uffff\20\2\3\14"+
            "\16\uffff\1\26\1\27\1\uffff\1\30\1\31\1\32\1\33",
            "\1\54\1\61\1\40\1\55\1\56\1\57\1\60\14\uffff\1\35\3\36\1\uffff"+
            "\1\36\1\uffff\3\36\1\uffff\1\53\12\uffff\3\36\5\uffff\1\51\4"+
            "\uffff\20\36\1\50\2\52\16\uffff\2\36\1\uffff\4\36",
            "",
            "",
            "\1\2\25\uffff\1\113\1\14\1\2\2\uffff\1\14\1\72\1\uffff\1\104"+
            "\1\14\4\uffff\2\14\1\uffff\3\2\3\uffff\1\101\1\102\1\2\3\uffff"+
            "\1\111\1\uffff\17\2\3\uffff\16\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\134\1\141\1\120\1\135\1\136\1\137\1\140\14\uffff\1\115\3"+
            "\36\1\uffff\1\36\1\uffff\3\36\1\uffff\1\133\12\uffff\3\36\5"+
            "\uffff\1\131\4\uffff\20\36\1\130\2\132\16\uffff\2\36\1\uffff"+
            "\4\36",
            "",
            "",
            "\1\36\21\uffff\1\14\3\uffff\1\36\1\170\1\36\2\uffff\1\172\1"+
            "\152\1\uffff\1\164\1\173\4\uffff\1\173\1\167\1\uffff\3\36\3"+
            "\uffff\1\161\1\162\1\36\3\uffff\1\165\1\uffff\17\36\3\uffff"+
            "\14\173\1\171\1\174",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\176",
            "\1\u0084\1\u0089\1\177\1\u0085\1\u0086\1\u0087\1\u0088\14\uffff"+
            "\1\u008a\12\uffff\1\u0083\22\uffff\1\u0081\24\uffff\1\u0080"+
            "\2\u0082",
            "\1\u0090\1\u0095\1\u008b\1\u0091\1\u0092\1\u0093\1\u0094\14"+
            "\uffff\1\u0096\12\uffff\1\u008f\22\uffff\1\u008d\24\uffff\1"+
            "\u008c\2\u008e",
            "\1\u009c\1\u00a1\1\u0097\1\u009d\1\u009e\1\u009f\1\u00a0\14"+
            "\uffff\1\u00a2\6\uffff\1\u00a4\3\uffff\1\u009b\12\uffff\3\u00a3"+
            "\5\uffff\1\u0099\5\uffff\4\u00a5\2\u00a6\11\u00a7\1\u0098\2"+
            "\u009a",
            "\1\14\3\uffff\1\36\1\u00a9\3\uffff\1\u00ab\2\uffff\2\u00ac"+
            "\4\uffff\1\u00ac\1\u00a8\7\uffff\2\u00ac\4\uffff\1\u00ac\23"+
            "\uffff\14\u00ac\1\u00aa\1\u00ad",
            "\1\14\3\uffff\1\36\1\u00b1\3\uffff\1\u00b3\2\uffff\2\u00b4"+
            "\4\uffff\1\u00b4\1\u00b0\7\uffff\2\u00b4\4\uffff\1\u00b4\23"+
            "\uffff\14\u00b4\1\u00b2\1\u00b5",
            "\1\14\3\uffff\1\36\1\u00b9\3\uffff\1\u00bb\2\uffff\2\u00bc"+
            "\4\uffff\1\u00bc\1\u00b8\7\uffff\2\u00bc\4\uffff\1\u00bc\23"+
            "\uffff\14\u00bc\1\u00ba\1\u00bd",
            "\1\14\3\uffff\1\36\1\u00c1\3\uffff\1\u00c3\2\uffff\2\u00c4"+
            "\4\uffff\1\u00c4\1\u00c0\7\uffff\2\u00c4\4\uffff\1\u00c4\23"+
            "\uffff\14\u00c4\1\u00c2\1\u00c5",
            "\1\14\3\uffff\1\36\1\u00c9\3\uffff\1\u00cb\2\uffff\2\u00cc"+
            "\4\uffff\1\u00cc\1\u00c8\7\uffff\2\u00cc\4\uffff\1\u00cc\23"+
            "\uffff\14\u00cc\1\u00ca\1\u00cd",
            "\1\14\3\uffff\1\36\1\u00d1\3\uffff\1\u00d3\2\uffff\2\u00d4"+
            "\4\uffff\1\u00d4\1\u00d0\7\uffff\2\u00d4\4\uffff\1\u00d4\23"+
            "\uffff\14\u00d4\1\u00d2\1\u00d5",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\2\14\1\u00d8\4\14\14\uffff\1\14\6\uffff\1\u00dc\3\uffff\1"+
            "\u00da\1\u00e2\10\uffff\1\2\3\u00db\3\uffff\2\2\1\14\3\uffff"+
            "\1\2\1\uffff\4\u00dd\2\u00de\11\u00df\3\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "\2\14\1\u00ee\4\14\14\uffff\1\14\12\uffff\1\u00ed\20\uffff"+
            "\2\2\1\u00f1\3\uffff\1\2\20\uffff\3\14",
            "\2\14\1\u00fc\4\14\14\uffff\1\14\12\uffff\1\u0101\20\uffff"+
            "\2\2\1\u00ff\3\uffff\1\2\20\uffff\3\14",
            "",
            "\2\14\1\u010d\4\14\14\uffff\1\14\6\uffff\1\2\3\uffff\1\14\2"+
            "\uffff\1\2\7\uffff\3\2\5\uffff\1\14\5\uffff\17\2\3\14",
            "",
            "",
            "",
            "",
            "\2\14\1\u011d\4\14\14\uffff\1\14\12\uffff\1\u011f\20\uffff"+
            "\2\2\1\14\3\uffff\1\2\20\uffff\3\14",
            "",
            "\1\uffff",
            "",
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
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
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
            "",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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

    static final short[] DFA94_eot = DFA.unpackEncodedString(DFA94_eotS);
    static final short[] DFA94_eof = DFA.unpackEncodedString(DFA94_eofS);
    static final char[] DFA94_min = DFA.unpackEncodedStringToUnsignedChars(DFA94_minS);
    static final char[] DFA94_max = DFA.unpackEncodedStringToUnsignedChars(DFA94_maxS);
    static final short[] DFA94_accept = DFA.unpackEncodedString(DFA94_acceptS);
    static final short[] DFA94_special = DFA.unpackEncodedString(DFA94_specialS);
    static final short[][] DFA94_transition;

    static {
        int numStates = DFA94_transitionS.length;
        DFA94_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA94_transition[i] = DFA.unpackEncodedString(DFA94_transitionS[i]);
        }
    }

    class DFA94 extends DFA {

        public DFA94(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 94;
            this.eot = DFA94_eot;
            this.eof = DFA94_eof;
            this.min = DFA94_min;
            this.max = DFA94_max;
            this.accept = DFA94_accept;
            this.special = DFA94_special;
            this.transition = DFA94_transition;
        }
        public String getDescription() {
            return "1093:1: statement : ( statementsBlock | declaration | expression ( '=' expression )? ';' | 'return' expression ';' | 'if' '(' expression ')' statement ( 'else' statement )? | 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA94_75 = input.LA(1);

                         
                        int index94_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_75);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA94_77 = input.LA(1);

                         
                        int index94_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_77);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA94_80 = input.LA(1);

                         
                        int index94_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_80);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA94_88 = input.LA(1);

                         
                        int index94_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_88);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA94_89 = input.LA(1);

                         
                        int index94_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_89);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA94_90 = input.LA(1);

                         
                        int index94_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_90);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA94_91 = input.LA(1);

                         
                        int index94_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_91);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA94_92 = input.LA(1);

                         
                        int index94_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_92);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA94_93 = input.LA(1);

                         
                        int index94_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_93);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA94_94 = input.LA(1);

                         
                        int index94_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_94);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA94_95 = input.LA(1);

                         
                        int index94_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_95);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA94_96 = input.LA(1);

                         
                        int index94_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_96);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA94_97 = input.LA(1);

                         
                        int index94_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_97);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA94_106 = input.LA(1);

                         
                        int index94_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_106);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA94_113 = input.LA(1);

                         
                        int index94_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_113);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA94_114 = input.LA(1);

                         
                        int index94_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_114);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA94_116 = input.LA(1);

                         
                        int index94_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_116);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA94_117 = input.LA(1);

                         
                        int index94_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_117);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA94_119 = input.LA(1);

                         
                        int index94_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_119);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA94_120 = input.LA(1);

                         
                        int index94_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_120);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA94_121 = input.LA(1);

                         
                        int index94_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_121);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA94_122 = input.LA(1);

                         
                        int index94_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_122);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA94_123 = input.LA(1);

                         
                        int index94_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_123);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA94_124 = input.LA(1);

                         
                        int index94_124 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_124);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA94_126 = input.LA(1);

                         
                        int index94_126 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_126);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA94_127 = input.LA(1);

                         
                        int index94_127 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_127);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA94_128 = input.LA(1);

                         
                        int index94_128 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_128);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA94_129 = input.LA(1);

                         
                        int index94_129 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_129);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA94_130 = input.LA(1);

                         
                        int index94_130 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_130);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA94_131 = input.LA(1);

                         
                        int index94_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_131);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA94_132 = input.LA(1);

                         
                        int index94_132 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_132);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA94_133 = input.LA(1);

                         
                        int index94_133 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_133);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA94_134 = input.LA(1);

                         
                        int index94_134 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_134);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA94_135 = input.LA(1);

                         
                        int index94_135 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_135);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA94_136 = input.LA(1);

                         
                        int index94_136 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_136);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA94_137 = input.LA(1);

                         
                        int index94_137 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_137);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA94_138 = input.LA(1);

                         
                        int index94_138 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_138);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA94_139 = input.LA(1);

                         
                        int index94_139 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_139);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA94_140 = input.LA(1);

                         
                        int index94_140 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_140);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA94_141 = input.LA(1);

                         
                        int index94_141 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_141);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA94_142 = input.LA(1);

                         
                        int index94_142 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_142);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA94_143 = input.LA(1);

                         
                        int index94_143 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_143);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA94_144 = input.LA(1);

                         
                        int index94_144 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_144);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA94_145 = input.LA(1);

                         
                        int index94_145 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_145);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA94_146 = input.LA(1);

                         
                        int index94_146 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_146);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA94_147 = input.LA(1);

                         
                        int index94_147 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_147);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA94_148 = input.LA(1);

                         
                        int index94_148 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_148);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA94_149 = input.LA(1);

                         
                        int index94_149 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_149);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA94_150 = input.LA(1);

                         
                        int index94_150 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_150);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA94_151 = input.LA(1);

                         
                        int index94_151 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_151);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA94_152 = input.LA(1);

                         
                        int index94_152 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_152);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA94_153 = input.LA(1);

                         
                        int index94_153 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_153);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA94_154 = input.LA(1);

                         
                        int index94_154 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_154);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA94_155 = input.LA(1);

                         
                        int index94_155 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_155);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA94_156 = input.LA(1);

                         
                        int index94_156 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_156);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA94_157 = input.LA(1);

                         
                        int index94_157 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_157);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA94_158 = input.LA(1);

                         
                        int index94_158 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_158);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA94_159 = input.LA(1);

                         
                        int index94_159 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_159);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA94_160 = input.LA(1);

                         
                        int index94_160 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_160);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA94_161 = input.LA(1);

                         
                        int index94_161 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_161);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA94_162 = input.LA(1);

                         
                        int index94_162 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_162);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA94_163 = input.LA(1);

                         
                        int index94_163 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_163);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA94_164 = input.LA(1);

                         
                        int index94_164 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_164);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA94_165 = input.LA(1);

                         
                        int index94_165 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_165);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA94_166 = input.LA(1);

                         
                        int index94_166 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_166);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA94_167 = input.LA(1);

                         
                        int index94_167 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_167);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA94_168 = input.LA(1);

                         
                        int index94_168 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_168);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA94_169 = input.LA(1);

                         
                        int index94_169 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_169);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA94_170 = input.LA(1);

                         
                        int index94_170 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_170);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA94_171 = input.LA(1);

                         
                        int index94_171 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_171);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA94_172 = input.LA(1);

                         
                        int index94_172 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_172);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA94_173 = input.LA(1);

                         
                        int index94_173 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_173);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA94_176 = input.LA(1);

                         
                        int index94_176 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_176);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA94_177 = input.LA(1);

                         
                        int index94_177 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_177);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA94_178 = input.LA(1);

                         
                        int index94_178 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_178);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA94_179 = input.LA(1);

                         
                        int index94_179 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_179);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA94_180 = input.LA(1);

                         
                        int index94_180 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_180);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA94_181 = input.LA(1);

                         
                        int index94_181 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_181);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA94_184 = input.LA(1);

                         
                        int index94_184 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_184);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA94_185 = input.LA(1);

                         
                        int index94_185 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_185);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA94_186 = input.LA(1);

                         
                        int index94_186 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_186);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA94_187 = input.LA(1);

                         
                        int index94_187 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_187);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA94_188 = input.LA(1);

                         
                        int index94_188 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_188);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA94_189 = input.LA(1);

                         
                        int index94_189 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_189);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA94_192 = input.LA(1);

                         
                        int index94_192 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_192);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA94_193 = input.LA(1);

                         
                        int index94_193 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_193);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA94_194 = input.LA(1);

                         
                        int index94_194 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_194);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA94_195 = input.LA(1);

                         
                        int index94_195 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_195);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA94_196 = input.LA(1);

                         
                        int index94_196 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_196);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA94_197 = input.LA(1);

                         
                        int index94_197 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_197);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA94_200 = input.LA(1);

                         
                        int index94_200 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_200);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA94_201 = input.LA(1);

                         
                        int index94_201 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_201);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA94_202 = input.LA(1);

                         
                        int index94_202 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_202);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA94_203 = input.LA(1);

                         
                        int index94_203 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_203);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA94_204 = input.LA(1);

                         
                        int index94_204 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_204);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA94_205 = input.LA(1);

                         
                        int index94_205 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_205);
                        if ( s>=0 ) return s;
                        break;
                    case 96 : 
                        int LA94_208 = input.LA(1);

                         
                        int index94_208 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_208);
                        if ( s>=0 ) return s;
                        break;
                    case 97 : 
                        int LA94_209 = input.LA(1);

                         
                        int index94_209 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_209);
                        if ( s>=0 ) return s;
                        break;
                    case 98 : 
                        int LA94_210 = input.LA(1);

                         
                        int index94_210 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_210);
                        if ( s>=0 ) return s;
                        break;
                    case 99 : 
                        int LA94_211 = input.LA(1);

                         
                        int index94_211 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_211);
                        if ( s>=0 ) return s;
                        break;
                    case 100 : 
                        int LA94_212 = input.LA(1);

                         
                        int index94_212 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_212);
                        if ( s>=0 ) return s;
                        break;
                    case 101 : 
                        int LA94_213 = input.LA(1);

                         
                        int index94_213 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_ObjCpp()) ) {s = 30;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_213);
                        if ( s>=0 ) return s;
                        break;
                    case 102 : 
                        int LA94_216 = input.LA(1);

                         
                        int index94_216 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                        else if ( (( next("foreach") )) ) {s = 331;}

                         
                        input.seek(index94_216);
                        if ( s>=0 ) return s;
                        break;
                    case 103 : 
                        int LA94_218 = input.LA(1);

                         
                        int index94_218 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_218);
                        if ( s>=0 ) return s;
                        break;
                    case 104 : 
                        int LA94_219 = input.LA(1);

                         
                        int index94_219 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 331;}

                         
                        input.seek(index94_219);
                        if ( s>=0 ) return s;
                        break;
                    case 105 : 
                        int LA94_220 = input.LA(1);

                         
                        int index94_220 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 331;}

                         
                        input.seek(index94_220);
                        if ( s>=0 ) return s;
                        break;
                    case 106 : 
                        int LA94_221 = input.LA(1);

                         
                        int index94_221 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 331;}

                         
                        input.seek(index94_221);
                        if ( s>=0 ) return s;
                        break;
                    case 107 : 
                        int LA94_222 = input.LA(1);

                         
                        int index94_222 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 331;}

                         
                        input.seek(index94_222);
                        if ( s>=0 ) return s;
                        break;
                    case 108 : 
                        int LA94_223 = input.LA(1);

                         
                        int index94_223 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 331;}

                         
                        input.seek(index94_223);
                        if ( s>=0 ) return s;
                        break;
                    case 109 : 
                        int LA94_226 = input.LA(1);

                         
                        int index94_226 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_226);
                        if ( s>=0 ) return s;
                        break;
                    case 110 : 
                        int LA94_237 = input.LA(1);

                         
                        int index94_237 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_237);
                        if ( s>=0 ) return s;
                        break;
                    case 111 : 
                        int LA94_238 = input.LA(1);

                         
                        int index94_238 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_238);
                        if ( s>=0 ) return s;
                        break;
                    case 112 : 
                        int LA94_241 = input.LA(1);

                         
                        int index94_241 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_241);
                        if ( s>=0 ) return s;
                        break;
                    case 113 : 
                        int LA94_252 = input.LA(1);

                         
                        int index94_252 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_252);
                        if ( s>=0 ) return s;
                        break;
                    case 114 : 
                        int LA94_255 = input.LA(1);

                         
                        int index94_255 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_255);
                        if ( s>=0 ) return s;
                        break;
                    case 115 : 
                        int LA94_257 = input.LA(1);

                         
                        int index94_257 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_257);
                        if ( s>=0 ) return s;
                        break;
                    case 116 : 
                        int LA94_269 = input.LA(1);

                         
                        int index94_269 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_269);
                        if ( s>=0 ) return s;
                        break;
                    case 117 : 
                        int LA94_285 = input.LA(1);

                         
                        int index94_285 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_285);
                        if ( s>=0 ) return s;
                        break;
                    case 118 : 
                        int LA94_287 = input.LA(1);

                         
                        int index94_287 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (synpred157_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index94_287);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 94, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA89_eotS =
        "\77\uffff";
    static final String DFA89_eofS =
        "\1\2\76\uffff";
    static final String DFA89_minS =
        "\1\4\1\0\75\uffff";
    static final String DFA89_maxS =
        "\1\142\1\0\75\uffff";
    static final String DFA89_acceptS =
        "\2\uffff\1\2\73\uffff\1\1";
    static final String DFA89_specialS =
        "\1\uffff\1\0\75\uffff}>";
    static final String[] DFA89_transitionS = {
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
            return "1099:37: ( 'else' statement )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA89_1 = input.LA(1);

                         
                        int index89_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 62;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index89_1);
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
    static final String DFA90_eotS =
        "\107\uffff";
    static final String DFA90_eofS =
        "\107\uffff";
    static final String DFA90_minS =
        "\1\4\33\uffff\1\4\14\uffff\1\4\1\0\2\uffff\1\0\7\uffff\12\0\6\uffff"+
        "\1\0\1\uffff";
    static final String DFA90_maxS =
        "\1\141\33\uffff\1\114\14\uffff\1\141\1\0\2\uffff\1\0\7\uffff\12"+
        "\0\6\uffff\1\0\1\uffff";
    static final String DFA90_acceptS =
        "\1\uffff\1\1\33\uffff\1\2\51\uffff";
    static final String DFA90_specialS =
        "\52\uffff\1\0\2\uffff\1\1\7\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1"+
        "\11\1\12\1\13\6\uffff\1\14\1\uffff}>";
    static final String[] DFA90_transitionS = {
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
            return "1102:13: ( statement )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA90_42 = input.LA(1);

                         
                        int index90_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index90_42);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA90_45 = input.LA(1);

                         
                        int index90_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index90_45);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA90_53 = input.LA(1);

                         
                        int index90_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index90_53);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA90_54 = input.LA(1);

                         
                        int index90_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index90_54);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA90_55 = input.LA(1);

                         
                        int index90_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index90_55);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA90_56 = input.LA(1);

                         
                        int index90_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index90_56);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA90_57 = input.LA(1);

                         
                        int index90_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index90_57);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA90_58 = input.LA(1);

                         
                        int index90_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index90_58);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA90_59 = input.LA(1);

                         
                        int index90_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index90_59);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA90_60 = input.LA(1);

                         
                        int index90_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index90_60);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA90_61 = input.LA(1);

                         
                        int index90_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index90_61);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA90_62 = input.LA(1);

                         
                        int index90_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index90_62);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA90_69 = input.LA(1);

                         
                        int index90_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index90_69);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 90, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA91_eotS =
        "\16\uffff";
    static final String DFA91_eofS =
        "\16\uffff";
    static final String DFA91_minS =
        "\1\4\15\uffff";
    static final String DFA91_maxS =
        "\1\114\15\uffff";
    static final String DFA91_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA91_specialS =
        "\16\uffff}>";
    static final String[] DFA91_transitionS = {
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

    static final short[] DFA91_eot = DFA.unpackEncodedString(DFA91_eotS);
    static final short[] DFA91_eof = DFA.unpackEncodedString(DFA91_eofS);
    static final char[] DFA91_min = DFA.unpackEncodedStringToUnsignedChars(DFA91_minS);
    static final char[] DFA91_max = DFA.unpackEncodedStringToUnsignedChars(DFA91_maxS);
    static final short[] DFA91_accept = DFA.unpackEncodedString(DFA91_acceptS);
    static final short[] DFA91_special = DFA.unpackEncodedString(DFA91_specialS);
    static final short[][] DFA91_transition;

    static {
        int numStates = DFA91_transitionS.length;
        DFA91_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA91_transition[i] = DFA.unpackEncodedString(DFA91_transitionS[i]);
        }
    }

    class DFA91 extends DFA {

        public DFA91(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 91;
            this.eot = DFA91_eot;
            this.eof = DFA91_eof;
            this.min = DFA91_min;
            this.max = DFA91_max;
            this.accept = DFA91_accept;
            this.special = DFA91_special;
            this.transition = DFA91_transition;
        }
        public String getDescription() {
            return "1102:28: ( expression )?";
        }
    }
    static final String DFA92_eotS =
        "\36\uffff";
    static final String DFA92_eofS =
        "\36\uffff";
    static final String DFA92_minS =
        "\1\4\35\uffff";
    static final String DFA92_maxS =
        "\1\141\35\uffff";
    static final String DFA92_acceptS =
        "\1\uffff\1\1\33\uffff\1\2";
    static final String DFA92_specialS =
        "\36\uffff}>";
    static final String[] DFA92_transitionS = {
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
            return "1102:44: ( statement )?";
        }
    }
    static final String DFA93_eotS =
        "\37\uffff";
    static final String DFA93_eofS =
        "\37\uffff";
    static final String DFA93_minS =
        "\1\4\36\uffff";
    static final String DFA93_maxS =
        "\1\142\36\uffff";
    static final String DFA93_acceptS =
        "\1\uffff\1\3\1\1\1\2\33\uffff";
    static final String DFA93_specialS =
        "\37\uffff}>";
    static final String[] DFA93_transitionS = {
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
            return "()* loopback of 1104:3: ( 'case' expression ':' | statement )*";
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
    public static final BitSet FOLLOW_structCore_in_plainTypeRef2042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumCore_in_plainTypeRef2050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefCore_in_plainTypeRef2058 = new BitSet(new long[]{0x0038000400000042L});
    public static final BitSet FOLLOW_typeMutator_in_plainTypeRef2075 = new BitSet(new long[]{0x0038000400000040L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_plainTypeRef2088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_declarator2122 = new BitSet(new long[]{0x0218000400000040L});
    public static final BitSet FOLLOW_set_in_declarator2159 = new BitSet(new long[]{0x0218000400000040L});
    public static final BitSet FOLLOW_declarator_in_declarator2178 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_directDeclarator_in_declarator2194 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_declarator2213 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_declarator2220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structCore_in_namedTypeRef2254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumCore_in_namedTypeRef2264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_typeDef2283 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_varDecl_in_typeDef2289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_varDeclEOF2309 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_varDeclEOF2311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_varDecl2348 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_modifier_in_varDecl2365 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_plainTypeRef_in_varDecl2392 = new BitSet(new long[]{0x0218000410000040L});
    public static final BitSet FOLLOW_declaratorsList_in_varDecl2406 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_varDecl2421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_objCProtocolRefList2435 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCProtocolRefList2440 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_27_in_objCProtocolRefList2450 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCProtocolRefList2456 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_37_in_objCProtocolRefList2466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarator_in_declaratorsList2493 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_declaratorsList2506 = new BitSet(new long[]{0x0218000400000040L});
    public static final BitSet FOLLOW_declarator_in_declaratorsList2515 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_directDeclarator2559 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_34_in_directDeclarator2569 = new BitSet(new long[]{0x0218000400000040L});
    public static final BitSet FOLLOW_modifier_in_directDeclarator2578 = new BitSet(new long[]{0x0218000400000040L});
    public static final BitSet FOLLOW_declarator_in_directDeclarator2589 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_directDeclarator2595 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_53_in_directDeclarator2610 = new BitSet(new long[]{0x00600004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_directDeclarator2622 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_directDeclarator2638 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_34_in_directDeclarator2646 = new BitSet(new long[]{0xF800F00840000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_argList_in_directDeclarator2648 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_directDeclarator2650 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_argDef_in_argList2683 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_argList2696 = new BitSet(new long[]{0xF800F00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_argDef_in_argList2705 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_argList2725 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_argList2727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plainTypeRef_in_typeRef2761 = new BitSet(new long[]{0x0038000000000042L});
    public static final BitSet FOLLOW_typeMutator_in_typeRef2772 = new BitSet(new long[]{0x0038000000000042L});
    public static final BitSet FOLLOW_set_in_primSignModifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_primSizeModifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_primitiveTypeName0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primSignModifier_in_primitiveTypeRef2911 = new BitSet(new long[]{0xF800000000000000L,0x00000000000003FFL});
    public static final BitSet FOLLOW_primSizeModifier_in_primitiveTypeRef2922 = new BitSet(new long[]{0xF800000000000000L,0x00000000000003FFL});
    public static final BitSet FOLLOW_primSizeModifier_in_primitiveTypeRef2929 = new BitSet(new long[]{0xF800000000000000L,0x00000000000003FFL});
    public static final BitSet FOLLOW_primitiveTypeName_in_primitiveTypeRef2972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_objCMethodCall3011 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3015 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodCall3019 = new BitSet(new long[]{0x0040000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodCall3030 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3034 = new BitSet(new long[]{0x0040000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodCall3049 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodCall3051 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3055 = new BitSet(new long[]{0x0040000000000040L});
    public static final BitSet FOLLOW_54_in_objCMethodCall3072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_functionCall3092 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionCall3094 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_typeRef_in_functionCall3096 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionCall3098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionCall3106 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionCall3108 = new BitSet(new long[]{0x0020000C008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_functionCall3121 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_27_in_functionCall3130 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_functionCall3139 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_35_in_functionCall3157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_expression3179 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_functionCall_in_expression3190 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_objCMethodCall_in_expression3199 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_set_in_expression3210 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_expression3220 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_34_in_expression3229 = new BitSet(new long[]{0xF820E004408007F0L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expression_in_expression3239 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_expression3241 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_typeRef_in_expression3251 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_expression3253 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_expression3257 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_constant_in_expression3272 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_23_in_expression3281 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_expression3283 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_expression3285 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_set_in_expression3301 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_expression3395 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_29_in_expression3404 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_expression3408 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_89_in_expression3417 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_expression3421 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_33_in_expression3433 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_expression3435 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_43_in_expression3439 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_expression3441 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_89_in_expression3445 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_functionCall_in_expression3450 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_90_in_expression3459 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_expression3463 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_expression3465 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_expression3469 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_23_in_statementsBlock3490 = new BitSet(new long[]{0xFC20E005D78007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statementsBlock3492 = new BitSet(new long[]{0xFC20E005D78007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_24_in_statementsBlock3495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_statement3508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_statement3514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement3520 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_statement3523 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3525 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_statement3536 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3538 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_statement3546 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3548 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3550 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3552 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3554 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_statement3557 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_statement3567 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3569 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3571 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3573 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_statement3581 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3583 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_statement3585 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3587 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3589 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3591 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_statement3599 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3601 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3603 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3606 = new BitSet(new long[]{0x00200004108007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3608 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3611 = new BitSet(new long[]{0xFC20E00DD68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3613 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3616 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_statement3624 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3626 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3628 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3630 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_statement3632 = new BitSet(new long[]{0xFC20E005D78007F0L,0x00000007D8001FFFL});
    public static final BitSet FOLLOW_98_in_statement3638 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3640 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement3642 = new BitSet(new long[]{0xFC20E005D78007F0L,0x00000007D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3649 = new BitSet(new long[]{0xFC20E005D78007F0L,0x00000007D8001FFFL});
    public static final BitSet FOLLOW_24_in_statement3658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_statement3664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement3672 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3674 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_varDecl_in_statement3676 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement3678 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3680 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3682 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_constant3700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEXADECIMAL_NUMBER_in_constant3708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OCTAL_NUMBER_in_constant3716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARACTER_in_constant3724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_NUMBER_in_constant3732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_constant3743 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_typeMutator_in_synpred77_ObjCpp2075 = new BitSet(new long[]{0x0038000400000040L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_synpred77_ObjCpp2088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred78_ObjCpp2122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred82_ObjCpp2213 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_synpred82_ObjCpp2220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred84_ObjCpp2348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred85_ObjCpp2365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred90_ObjCpp2578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_synpred94_ObjCpp2696 = new BitSet(new long[]{0xF800F00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_argDef_in_synpred94_ObjCpp2705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred97_ObjCpp2772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred125_ObjCpp3239 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred125_ObjCpp3241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred146_ObjCpp3301 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_synpred146_ObjCpp3395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred147_ObjCpp3404 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_synpred147_ObjCpp3408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_synpred148_ObjCpp3417 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred148_ObjCpp3421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_synpred151_ObjCpp3433 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_synpred151_ObjCpp3435 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_43_in_synpred151_ObjCpp3439 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_synpred151_ObjCpp3441 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_89_in_synpred151_ObjCpp3445 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_functionCall_in_synpred151_ObjCpp3450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_synpred152_ObjCpp3459 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_synpred152_ObjCpp3463 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_synpred152_ObjCpp3465 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_synpred152_ObjCpp3469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_synpred154_ObjCpp3508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_synpred155_ObjCpp3514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred157_ObjCpp3520 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_synpred157_ObjCpp3523 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_synpred157_ObjCpp3525 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_synpred157_ObjCpp3530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_synpred159_ObjCpp3557 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_synpred159_ObjCpp3559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_synpred163_ObjCpp3603 = new BitSet(new long[]{0x0000000000000002L});

}