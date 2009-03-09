// $ANTLR 3.1.2 /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g 2009-03-09 20:39:50
 
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:178:1: lineDirective : ln= '#line' line= DECIMAL_NUMBER (unescapedString= STRING )? (depth= DECIMAL_NUMBER )? ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:179:2: (ln= '#line' line= DECIMAL_NUMBER (unescapedString= STRING )? (depth= DECIMAL_NUMBER )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:179:4: ln= '#line' line= DECIMAL_NUMBER (unescapedString= STRING )? (depth= DECIMAL_NUMBER )?
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:187:3: (unescapedString= STRING )?
            int alt1=2;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:188:4: unescapedString= STRING
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:198:8: (depth= DECIMAL_NUMBER )?
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:201:1: sourceFile returns [SourceFile sourceFile] : ( declaration | lineDirective )* EOF ;
    public final ObjCppParser.sourceFile_return sourceFile() throws RecognitionException {
        ObjCppParser.sourceFile_return retval = new ObjCppParser.sourceFile_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF3=null;
        ObjCppParser.declaration_return declaration1 = null;

        ObjCppParser.lineDirective_return lineDirective2 = null;


        Object EOF3_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:202:2: ( ( declaration | lineDirective )* EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:203:3: ( declaration | lineDirective )* EOF
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.sourceFile = mark(new SourceFile(), getLine()); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:204:3: ( declaration | lineDirective )*
            loop3:
            do {
                int alt3=3;
                alt3 = dfa3.predict(input);
                switch (alt3) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:205:4: declaration
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:209:4: lineDirective
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:214:1: externDeclarations returns [List<Declaration> declarations] : {...}? IDENTIFIER STRING '{' (ed= declaration )* '}' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:215:2: ({...}? IDENTIFIER STRING '{' (ed= declaration )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:215:4: {...}? IDENTIFIER STRING '{' (ed= declaration )* '}'
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:219:4: (ed= declaration )*
            loop4:
            do {
                int alt4=2;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:220:5: ed= declaration
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:227:1: declaration returns [List<Declaration> declarations, List<Modifier> modifiers, String preComment, int startTokenIndex] : ( ( functionDeclaration | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) ) ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:228:2: ( ( ( functionDeclaration | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:229:3: ( ( functionDeclaration | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.declarations = new ArrayList<Declaration>(); 
              		  retval.modifiers = new ArrayList<Modifier>();
              		  retval.startTokenIndex = getTokenStream().index();
              		  retval.preComment = getCommentBefore(retval.startTokenIndex);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:234:3: ( ( functionDeclaration | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:241:4: ( functionDeclaration | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:241:4: ( functionDeclaration | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )
            int alt6=6;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:243:5: functionDeclaration
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:246:5: varDecl
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:249:5: objCClassDef
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:252:5: typeDef
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:255:5: forwardClassDecl
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:258:5: 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}'
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:259:6: (subD= declaration )*
                    loop5:
                    do {
                        int alt5=2;
                        alt5 = dfa5.predict(input);
                        switch (alt5) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:260:7: subD= declaration
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:285:1: forwardClassDecl returns [List<Declaration> declarations] : '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:286:2: ( '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:286:5: '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';'
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:289:3: ( ',' nx= IDENTIFIER )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==27) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:289:4: ',' nx= IDENTIFIER
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:295:1: functionPointerVarDecl returns [List<? extends Declaration> declarations] : typeRef {...}? ';' ;
    public final ObjCppParser.functionPointerVarDecl_return functionPointerVarDecl() throws RecognitionException {
        ObjCppParser.functionPointerVarDecl_return retval = new ObjCppParser.functionPointerVarDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal20=null;
        ObjCppParser.typeRef_return typeRef19 = null;


        Object char_literal20_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:296:2: ( typeRef {...}? ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:296:4: typeRef {...}? ';'
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:305:1: enumItem returns [Enum.EnumItem item] : n= IDENTIFIER ( '=' v= expression )? ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:306:2: (n= IDENTIFIER ( '=' v= expression )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:306:4: n= IDENTIFIER ( '=' v= expression )?
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumItem453); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:306:17: ( '=' v= expression )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==29) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:306:18: '=' v= expression
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

    public static class enumCore_return extends ParserRuleReturnScope {
        public Enum e;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "enumCore"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:313:1: enumCore returns [Enum e] : t= 'enum' (n1= IDENTIFIER )? '{' i1= enumItem ( ',' (ix= enumItem )? )* '}' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:314:2: (t= 'enum' (n1= IDENTIFIER )? '{' i1= enumItem ( ',' (ix= enumItem )? )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:315:3: t= 'enum' (n1= IDENTIFIER )? '{' i1= enumItem ( ',' (ix= enumItem )? )* '}'
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:318:5: (n1= IDENTIFIER )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==IDENTIFIER) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:319:4: n1= IDENTIFIER
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:327:4: ( ',' (ix= enumItem )? )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==27) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:328:5: ',' (ix= enumItem )?
            	    {
            	    char_literal23=(Token)match(input,27,FOLLOW_27_in_enumCore527); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal23_tree = (Object)adaptor.create(char_literal23);
            	    adaptor.addChild(root_0, char_literal23_tree);
            	    }
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:329:5: (ix= enumItem )?
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( (LA10_0==IDENTIFIER) ) {
            	        alt10=1;
            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:329:6: ix= enumItem
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:344:1: objCClassDef returns [Struct struct] : octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl {...}?)* '@end' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:345:2: (octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl {...}?)* '@end' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:346:3: octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl {...}?)* '@end'
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:356:3: ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' )
            int alt13=2;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:357:4: ( ':' parentClass= IDENTIFIER )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:357:4: ( ':' parentClass= IDENTIFIER )?
                    int alt12=2;
                    alt12 = dfa12.predict(input);
                    switch (alt12) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:358:5: ':' parentClass= IDENTIFIER
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:363:4: '(' categoryName= IDENTIFIER ')'
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:367:3: ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )?
            int alt16=2;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:368:4: '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>'
                    {
                    char_literal28=(Token)match(input,36,FOLLOW_36_in_objCClassDef648); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal28_tree = (Object)adaptor.create(char_literal28);
                    adaptor.addChild(root_0, char_literal28_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:368:8: (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==IDENTIFIER) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:369:5: p1= IDENTIFIER ( ',' px= IDENTIFIER )*
                            {
                            p1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef658); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            p1_tree = (Object)adaptor.create(p1);
                            adaptor.addChild(root_0, p1_tree);
                            }
                            if ( state.backtracking==0 ) {
                               retval.struct.addProtocol((p1!=null?p1.getText():null)); 
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:370:5: ( ',' px= IDENTIFIER )*
                            loop14:
                            do {
                                int alt14=2;
                                int LA14_0 = input.LA(1);

                                if ( (LA14_0==27) ) {
                                    alt14=1;
                                }


                                switch (alt14) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:371:6: ',' px= IDENTIFIER
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:376:3: ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )?
            int alt19=2;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:377:4: '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}'
                    {
                    char_literal31=(Token)match(input,23,FOLLOW_23_in_objCClassDef714); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal31_tree = (Object)adaptor.create(char_literal31);
                    adaptor.addChild(root_0, char_literal31_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:378:4: ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )*
                    loop18:
                    do {
                        int alt18=5;
                        alt18 = dfa18.predict(input);
                        switch (alt18) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:379:5: '@public'
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
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:380:5: '@private'
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
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:381:5: '@protected'
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
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:382:5: ( (fv= varDecl | functionPointerVarDecl ) )
                    	    {
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:382:5: ( (fv= varDecl | functionPointerVarDecl ) )
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:383:6: (fv= varDecl | functionPointerVarDecl )
                    	    {
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:383:6: (fv= varDecl | functionPointerVarDecl )
                    	    int alt17=2;
                    	    alt17 = dfa17.predict(input);
                    	    switch (alt17) {
                    	        case 1 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:384:7: fv= varDecl
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
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:387:7: functionPointerVarDecl
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:396:3: ( objCMethodDecl | typeDef | vd= varDecl {...}?)*
            loop20:
            do {
                int alt20=4;
                alt20 = dfa20.predict(input);
                switch (alt20) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:397:4: objCMethodDecl
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:400:4: typeDef
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:403:4: vd= varDecl {...}?
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:410:1: objCMethodDecl returns [Function function] : tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= typeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:411:2: (tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= typeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:411:4: tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= typeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               	
              			retval.function = new Function(); 
              			retval.function.setType(Function.Type.ObjCMethod);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:415:6: (tp= '+' | tm= '-' )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:416:4: tp= '+'
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:421:4: tm= '-'
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:426:3: ( '(' (returnTypeRef= typeRef )? ')' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==34) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:428:4: '(' (returnTypeRef= typeRef )? ')'
                    {
                    char_literal40=(Token)match(input,34,FOLLOW_34_in_objCMethodDecl930); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal40_tree = (Object)adaptor.create(char_literal40);
                    adaptor.addChild(root_0, char_literal40_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:429:18: (returnTypeRef= typeRef )?
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:438:3: ( ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==33) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:439:4: ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )?
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:444:4: (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==IDENTIFIER) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:445:5: sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER
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

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:453:4: ( ',' '...' )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==27) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:454:5: ',' '...'
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:475:1: structCore returns [Struct struct, List<Modifier> modifiers] : t= ( 'struct' | 'class' | 'union' ) ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' ) ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:476:2: (t= ( 'struct' | 'class' | 'union' ) ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:478:3: t= ( 'struct' | 'class' | 'union' ) ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' )
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
              			retval.struct.setForwardDeclaration(true); // until proven wrong
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:487:3: ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' )
            int alt31=2;
            alt31 = dfa31.predict(input);
            switch (alt31) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:488:4: (n0= IDENTIFIER )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:488:4: (n0= IDENTIFIER )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:489:5: n0= IDENTIFIER
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:494:4: ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}'
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:494:4: ( ( exportationModifiers )? n1= IDENTIFIER )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==IDENTIFIER) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:495:5: ( exportationModifiers )? n1= IDENTIFIER
                            {
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:495:5: ( exportationModifiers )?
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
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:495:7: exportationModifiers
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
                    if ( state.backtracking==0 ) {
                       retval.struct.setForwardDeclaration(false); 
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:502:5: ( ( 'public' | 'private' | 'protected' ) ':' | declaration )*
                    loop30:
                    do {
                        int alt30=3;
                        alt30 = dfa30.predict(input);
                        switch (alt30) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:503:6: ( 'public' | 'private' | 'protected' ) ':'
                    	    {
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:503:6: ( 'public' | 'private' | 'protected' )
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
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:504:7: 'public'
                    	            {
                    	            string_literal53=(Token)match(input,48,FOLLOW_48_in_structCore1186); if (state.failed) return retval;
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
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:505:7: 'private'
                    	            {
                    	            string_literal54=(Token)match(input,49,FOLLOW_49_in_structCore1199); if (state.failed) return retval;
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
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:506:7: 'protected'
                    	            {
                    	            string_literal55=(Token)match(input,50,FOLLOW_50_in_structCore1212); if (state.failed) return retval;
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

                    	    char_literal56=(Token)match(input,33,FOLLOW_33_in_structCore1224); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal56_tree = (Object)adaptor.create(char_literal56);
                    	    adaptor.addChild(root_0, char_literal56_tree);
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:508:6: declaration
                    	    {
                    	    pushFollow(FOLLOW_declaration_in_structCore1233);
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

                    char_literal58=(Token)match(input,24,FOLLOW_24_in_structCore1247); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:517:1: functionDeclaration returns [Function function] : (returnTypeRef= typeRef )? preMods= exportationModifiers n= IDENTIFIER '(' argList ')' {...}? (ct= IDENTIFIER )? postMods= exportationModifiers ( ';' | statementsBlock ) ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:518:2: ( (returnTypeRef= typeRef )? preMods= exportationModifiers n= IDENTIFIER '(' argList ')' {...}? (ct= IDENTIFIER )? postMods= exportationModifiers ( ';' | statementsBlock ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:518:4: (returnTypeRef= typeRef )? preMods= exportationModifiers n= IDENTIFIER '(' argList ')' {...}? (ct= IDENTIFIER )? postMods= exportationModifiers ( ';' | statementsBlock )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               	
              			retval.function = new Function();
              			retval.function.setType(Function.Type.CFunction);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:525:16: (returnTypeRef= typeRef )?
            int alt32=2;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: returnTypeRef= typeRef
                    {
                    pushFollow(FOLLOW_typeRef_in_functionDeclaration1277);
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
            pushFollow(FOLLOW_exportationModifiers_in_functionDeclaration1286);
            preMods=exportationModifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, preMods.getTree());
            if ( state.backtracking==0 ) {

              			for (Modifier m : (preMods!=null?preMods.modifiers:null))
              				retval.function.addModifiers(m);
              		
            }
            n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionDeclaration1294); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.function.setName((n!=null?n.getText():null)); 
              			retval.function = mark(retval.function, getLine(n));
              		
            }
            char_literal59=(Token)match(input,34,FOLLOW_34_in_functionDeclaration1301); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal59_tree = (Object)adaptor.create(char_literal59);
            adaptor.addChild(root_0, char_literal59_tree);
            }
            pushFollow(FOLLOW_argList_in_functionDeclaration1307);
            argList60=argList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, argList60.getTree());
            if ( state.backtracking==0 ) {

              				retval.function.setArgs((argList60!=null?argList60.args:null));
              			
            }
            char_literal61=(Token)match(input,35,FOLLOW_35_in_functionDeclaration1313); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal61_tree = (Object)adaptor.create(char_literal61);
            adaptor.addChild(root_0, char_literal61_tree);
            }
            if ( !(( next("const", "__const") )) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "functionDeclaration", " next(\"const\", \"__const\") ");
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:541:35: (ct= IDENTIFIER )?
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
                    ct=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionDeclaration1322); if (state.failed) return retval;
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
            pushFollow(FOLLOW_exportationModifiers_in_functionDeclaration1331);
            postMods=exportationModifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, postMods.getTree());
            if ( state.backtracking==0 ) {

              			for (Modifier m : (postMods!=null?postMods.modifiers:null))
              				retval.function.addModifiers(m);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:549:3: ( ';' | statementsBlock )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:550:4: ';'
                    {
                    char_literal62=(Token)match(input,28,FOLLOW_28_in_functionDeclaration1343); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal62_tree = (Object)adaptor.create(char_literal62);
                    adaptor.addChild(root_0, char_literal62_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:551:4: statementsBlock
                    {
                    pushFollow(FOLLOW_statementsBlock_in_functionDeclaration1350);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:557:1: functionDefinition : functionDeclaration '{' '}' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:558:2: ( functionDeclaration '{' '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:558:4: functionDeclaration '{' '}'
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_functionDeclaration_in_functionDefinition1367);
            functionDeclaration64=functionDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, functionDeclaration64.getTree());
            char_literal65=(Token)match(input,23,FOLLOW_23_in_functionDefinition1369); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal65_tree = (Object)adaptor.create(char_literal65);
            adaptor.addChild(root_0, char_literal65_tree);
            }
            char_literal66=(Token)match(input,24,FOLLOW_24_in_functionDefinition1371); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:561:1: exportationModifiers returns [List<Modifier> modifiers] : ( exportationModifier )* ;
    public final ObjCppParser.exportationModifiers_return exportationModifiers() throws RecognitionException {
        ObjCppParser.exportationModifiers_return retval = new ObjCppParser.exportationModifiers_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.exportationModifier_return exportationModifier67 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:562:2: ( ( exportationModifier )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:562:5: ( exportationModifier )*
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:563:3: ( exportationModifier )*
            loop35:
            do {
                int alt35=2;
                alt35 = dfa35.predict(input);
                switch (alt35) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:564:4: exportationModifier
            	    {
            	    pushFollow(FOLLOW_exportationModifier_in_exportationModifiers1398);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:570:1: modifier returns [Modifier modifier] : {...}? IDENTIFIER ;
    public final ObjCppParser.modifier_return modifier() throws RecognitionException {
        ObjCppParser.modifier_return retval = new ObjCppParser.modifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER68=null;

        Object IDENTIFIER68_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:571:2: ({...}? IDENTIFIER )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:571:4: {...}? IDENTIFIER
            {
            root_0 = (Object)adaptor.nil();

            if ( !(( Modifier.parseModifier(next()) != null )) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "modifier", " Modifier.parseModifier(next()) != null ");
            }
            IDENTIFIER68=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier1425); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:584:1: exportationModifier returns [List<Modifier> modifiers] : ({...}? modifier | IDENTIFIER {...}? '(' extendedModifiers ')' ) ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:585:2: ( ({...}? modifier | IDENTIFIER {...}? '(' extendedModifiers ')' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:585:5: ({...}? modifier | IDENTIFIER {...}? '(' extendedModifiers ')' )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:586:3: ({...}? modifier | IDENTIFIER {...}? '(' extendedModifiers ')' )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:587:4: {...}? modifier
                    {
                    if ( !(( next(Modifier.Kind.Plain) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "exportationModifier", " next(Modifier.Kind.Plain) ");
                    }
                    pushFollow(FOLLOW_modifier_in_exportationModifier1457);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:590:4: IDENTIFIER {...}? '(' extendedModifiers ')'
                    {
                    IDENTIFIER70=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_exportationModifier1466); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER70_tree = (Object)adaptor.create(IDENTIFIER70);
                    adaptor.addChild(root_0, IDENTIFIER70_tree);
                    }
                    if ( !(( (IDENTIFIER70!=null?IDENTIFIER70.getText():null).equals("__declspec") || (IDENTIFIER70!=null?IDENTIFIER70.getText():null).equals("__attribute__") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "exportationModifier", " $IDENTIFIER.text.equals(\"__declspec\") || $IDENTIFIER.text.equals(\"__attribute__\") ");
                    }
                    char_literal71=(Token)match(input,34,FOLLOW_34_in_exportationModifier1474); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal71_tree = (Object)adaptor.create(char_literal71);
                    adaptor.addChild(root_0, char_literal71_tree);
                    }
                    pushFollow(FOLLOW_extendedModifiers_in_exportationModifier1476);
                    extendedModifiers72=extendedModifiers();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, extendedModifiers72.getTree());
                    char_literal73=(Token)match(input,35,FOLLOW_35_in_exportationModifier1478); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:598:1: extendedModifiers returns [List<Modifier> modifiers] : ({...}?m= modifier () )* ;
    public final ObjCppParser.extendedModifiers_return extendedModifiers() throws RecognitionException {
        ObjCppParser.extendedModifiers_return retval = new ObjCppParser.extendedModifiers_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.modifier_return m = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:599:2: ( ({...}?m= modifier () )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:599:4: ({...}?m= modifier () )*
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:600:3: ({...}?m= modifier () )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==IDENTIFIER) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:601:4: {...}?m= modifier ()
            	    {
            	    if ( !(( next(Modifier.Kind.Extended) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "extendedModifiers", " next(Modifier.Kind.Extended) ");
            	    }
            	    pushFollow(FOLLOW_modifier_in_extendedModifiers1513);
            	    m=modifier();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, m.getTree());
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:602:4: ()
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:603:5: 
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:613:1: argDef returns [Arg arg] : ( typeRef ( ( declarator )? ) ( '=' expression )? | '...' );
    public final ObjCppParser.argDef_return argDef() throws RecognitionException {
        ObjCppParser.argDef_return retval = new ObjCppParser.argDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal76=null;
        Token string_literal78=null;
        ObjCppParser.typeRef_return typeRef74 = null;

        ObjCppParser.declarator_return declarator75 = null;

        ObjCppParser.expression_return expression77 = null;


        Object char_literal76_tree=null;
        Object string_literal78_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:614:2: ( typeRef ( ( declarator )? ) ( '=' expression )? | '...' )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==IDENTIFIER||LA40_0==30||(LA40_0>=45 && LA40_0<=47)||(LA40_0>=59 && LA40_0<=73)) ) {
                alt40=1;
            }
            else if ( (LA40_0==44) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:615:3: typeRef ( ( declarator )? ) ( '=' expression )?
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( state.backtracking==0 ) {
                       retval.arg = new Arg(); 
                    }
                    pushFollow(FOLLOW_typeRef_in_argDef1556);
                    typeRef74=typeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRef74.getTree());
                    if ( state.backtracking==0 ) {
                       
                      			retval.arg.setValueType((typeRef74!=null?typeRef74.type:null)); 
                      		
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:619:3: ( ( declarator )? )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:620:4: ( declarator )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:620:4: ( declarator )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==IDENTIFIER||LA38_0==34||(LA38_0>=51 && LA38_0<=52)||LA38_0==57) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: declarator
                            {
                            pushFollow(FOLLOW_declarator_in_argDef1567);
                            declarator75=declarator();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, declarator75.getTree());

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       
                      				if ((declarator75!=null?declarator75.declarator:null) != null)
                      					retval.arg.setDeclarator((declarator75!=null?declarator75.declarator:null)); 
                      				else if (retval.arg.getValueType() instanceof FunctionSignature) {
                      					FunctionSignature fs = (FunctionSignature)retval.arg.getValueType();
                      					if (fs != null && fs.getFunction() != null) {
                      						retval.arg.setName(fs.getFunction().getName());
                      						fs.getFunction().setName(null);
                      					}
                      				}
                      			
                    }

                    }

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:651:3: ( '=' expression )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==29) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:651:4: '=' expression
                            {
                            char_literal76=(Token)match(input,29,FOLLOW_29_in_argDef1587); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal76_tree = (Object)adaptor.create(char_literal76);
                            adaptor.addChild(root_0, char_literal76_tree);
                            }
                            pushFollow(FOLLOW_expression_in_argDef1589);
                            expression77=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression77.getTree());
                            if ( state.backtracking==0 ) {

                              			retval.arg.setDefaultValue((expression77!=null?expression77.expr:null));
                              		
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:655:3: '...'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal78=(Token)match(input,44,FOLLOW_44_in_argDef1603); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal78_tree = (Object)adaptor.create(string_literal78);
                    adaptor.addChild(root_0, string_literal78_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:673:1: typeMutator returns [TypeMutator mutator] : ({...}? IDENTIFIER '*' | '*' | '&' | '[' ']' );
    public final ObjCppParser.typeMutator_return typeMutator() throws RecognitionException {
        ObjCppParser.typeMutator_return retval = new ObjCppParser.typeMutator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER79=null;
        Token char_literal80=null;
        Token char_literal81=null;
        Token char_literal82=null;
        Token char_literal83=null;
        Token char_literal84=null;

        Object IDENTIFIER79_tree=null;
        Object char_literal80_tree=null;
        Object char_literal81_tree=null;
        Object char_literal82_tree=null;
        Object char_literal83_tree=null;
        Object char_literal84_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:674:2: ({...}? IDENTIFIER '*' | '*' | '&' | '[' ']' )
            int alt41=4;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt41=1;
                }
                break;
            case 51:
                {
                alt41=2;
                }
                break;
            case 52:
                {
                alt41=3;
                }
                break;
            case 53:
                {
                alt41=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:674:4: {...}? IDENTIFIER '*'
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !(( next("const", "__const") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeMutator", " next(\"const\", \"__const\") ");
                    }
                    IDENTIFIER79=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_typeMutator1623); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER79_tree = (Object)adaptor.create(IDENTIFIER79);
                    adaptor.addChild(root_0, IDENTIFIER79_tree);
                    }
                    char_literal80=(Token)match(input,51,FOLLOW_51_in_typeMutator1625); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal80_tree = (Object)adaptor.create(char_literal80);
                    adaptor.addChild(root_0, char_literal80_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.mutator = TypeMutator.CONST_STAR; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:675:3: '*'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal81=(Token)match(input,51,FOLLOW_51_in_typeMutator1633); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal81_tree = (Object)adaptor.create(char_literal81);
                    adaptor.addChild(root_0, char_literal81_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.mutator = TypeMutator.STAR; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:676:3: '&'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal82=(Token)match(input,52,FOLLOW_52_in_typeMutator1641); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal82_tree = (Object)adaptor.create(char_literal82);
                    adaptor.addChild(root_0, char_literal82_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.mutator = TypeMutator.AMPERSTAND; 
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:677:3: '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal83=(Token)match(input,53,FOLLOW_53_in_typeMutator1650); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal83_tree = (Object)adaptor.create(char_literal83);
                    adaptor.addChild(root_0, char_literal83_tree);
                    }
                    char_literal84=(Token)match(input,54,FOLLOW_54_in_typeMutator1652); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal84_tree = (Object)adaptor.create(char_literal84);
                    adaptor.addChild(root_0, char_literal84_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:680:1: arrayTypeMutator returns [TypeMutator mutator] : '[' expression ']' ;
    public final ObjCppParser.arrayTypeMutator_return arrayTypeMutator() throws RecognitionException {
        ObjCppParser.arrayTypeMutator_return retval = new ObjCppParser.arrayTypeMutator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal85=null;
        Token char_literal87=null;
        ObjCppParser.expression_return expression86 = null;


        Object char_literal85_tree=null;
        Object char_literal87_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:681:2: ( '[' expression ']' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:681:4: '[' expression ']'
            {
            root_0 = (Object)adaptor.nil();

            char_literal85=(Token)match(input,53,FOLLOW_53_in_arrayTypeMutator1670); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal85_tree = (Object)adaptor.create(char_literal85);
            adaptor.addChild(root_0, char_literal85_tree);
            }
            pushFollow(FOLLOW_expression_in_arrayTypeMutator1676);
            expression86=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression86.getTree());
            if ( state.backtracking==0 ) {

              				retval.mutator = TypeMutator.array((expression86!=null?expression86.expr:null)); 
              			
            }
            char_literal87=(Token)match(input,54,FOLLOW_54_in_arrayTypeMutator1685); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal87_tree = (Object)adaptor.create(char_literal87);
            adaptor.addChild(root_0, char_literal87_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:688:1: typeRefCore returns [TypeRef type] : ({...}?m= modifier )? ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) ) ;
    public final ObjCppParser.typeRefCore_return typeRefCore() throws RecognitionException {
        ObjCppParser.typeRefCore_return retval = new ObjCppParser.typeRefCore_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ref=null;
        Token char_literal89=null;
        Token char_literal90=null;
        Token char_literal91=null;
        ObjCppParser.modifier_return m = null;

        ObjCppParser.modifier_return m1 = null;

        ObjCppParser.typeRef_return tr = null;

        ObjCppParser.typeRef_return t1 = null;

        ObjCppParser.typeRef_return tx = null;

        ObjCppParser.primitiveTypeRef_return primitiveTypeRef88 = null;


        Object ref_tree=null;
        Object char_literal89_tree=null;
        Object char_literal90_tree=null;
        Object char_literal91_tree=null;

         List<Modifier> mods = new ArrayList<Modifier>(); 
        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:690:2: ( ({...}?m= modifier )? ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:690:4: ({...}?m= modifier )? ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) )
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:690:4: ({...}?m= modifier )?
            int alt42=2;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:690:5: {...}?m= modifier
                    {
                    if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeRefCore", " next(Modifier.Kind.TypeQualifier) ");
                    }
                    pushFollow(FOLLOW_modifier_in_typeRefCore1712);
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:691:3: ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) )
            int alt47=2;
            alt47 = dfa47.predict(input);
            switch (alt47) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:692:4: {...}?m1= modifier tr= typeRef
                    {
                    if ( !(( next(Modifier.Kind.ReferenceQualifier) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeRefCore", " next(Modifier.Kind.ReferenceQualifier) ");
                    }
                    pushFollow(FOLLOW_modifier_in_typeRefCore1729);
                    m1=modifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, m1.getTree());
                    if ( state.backtracking==0 ) {
                       mods.add((m1!=null?m1.modifier:null)); 
                    }
                    pushFollow(FOLLOW_typeRef_in_typeRefCore1738);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:695:4: ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:695:4: ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) )
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( ((LA46_0>=59 && LA46_0<=73)) ) {
                        alt46=1;
                    }
                    else if ( (LA46_0==IDENTIFIER) ) {
                        alt46=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 0, input);

                        throw nvae;
                    }
                    switch (alt46) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:696:5: primitiveTypeRef
                            {
                            pushFollow(FOLLOW_primitiveTypeRef_in_typeRefCore1758);
                            primitiveTypeRef88=primitiveTypeRef();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveTypeRef88.getTree());
                            if ( state.backtracking==0 ) {
                               retval.type = (primitiveTypeRef88!=null?primitiveTypeRef88.type:null); 
                            }

                            }
                            break;
                        case 2 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:697:5: {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' )
                            {
                            if ( !(( Modifier.parseModifier(next()) == null )) ) {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                throw new FailedPredicateException(input, "typeRefCore", " Modifier.parseModifier(next()) == null ");
                            }
                            ref=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_typeRefCore1773); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ref_tree = (Object)adaptor.create(ref);
                            adaptor.addChild(root_0, ref_tree);
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:697:64: ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' )
                            int alt45=2;
                            alt45 = dfa45.predict(input);
                            switch (alt45) {
                                case 1 :
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:698:6: 
                                    {
                                    if ( state.backtracking==0 ) {
                                       retval.type = new SimpleTypeRef((ref!=null?ref.getText():null)); 
                                    }

                                    }
                                    break;
                                case 2 :
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:699:6: '<' (t1= typeRef ( ',' tx= typeRef )* )? '>'
                                    {
                                    char_literal89=(Token)match(input,36,FOLLOW_36_in_typeRefCore1791); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    char_literal89_tree = (Object)adaptor.create(char_literal89);
                                    adaptor.addChild(root_0, char_literal89_tree);
                                    }
                                    if ( state.backtracking==0 ) {
                                       retval.type = new TemplateRef((ref!=null?ref.getText():null)); 
                                    }
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:700:7: (t1= typeRef ( ',' tx= typeRef )* )?
                                    int alt44=2;
                                    int LA44_0 = input.LA(1);

                                    if ( (LA44_0==IDENTIFIER||LA44_0==30||(LA44_0>=45 && LA44_0<=47)||(LA44_0>=59 && LA44_0<=73)) ) {
                                        alt44=1;
                                    }
                                    switch (alt44) {
                                        case 1 :
                                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:701:8: t1= typeRef ( ',' tx= typeRef )*
                                            {
                                            pushFollow(FOLLOW_typeRef_in_typeRefCore1812);
                                            t1=typeRef();

                                            state._fsp--;
                                            if (state.failed) return retval;
                                            if ( state.backtracking==0 ) adaptor.addChild(root_0, t1.getTree());
                                            if ( state.backtracking==0 ) {
                                               ((TemplateRef)retval.type).addParameter((t1!=null?t1.type:null)); 
                                            }
                                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:702:8: ( ',' tx= typeRef )*
                                            loop43:
                                            do {
                                                int alt43=2;
                                                int LA43_0 = input.LA(1);

                                                if ( (LA43_0==27) ) {
                                                    alt43=1;
                                                }


                                                switch (alt43) {
                                            	case 1 :
                                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:703:9: ',' tx= typeRef
                                            	    {
                                            	    char_literal90=(Token)match(input,27,FOLLOW_27_in_typeRefCore1833); if (state.failed) return retval;
                                            	    if ( state.backtracking==0 ) {
                                            	    char_literal90_tree = (Object)adaptor.create(char_literal90);
                                            	    adaptor.addChild(root_0, char_literal90_tree);
                                            	    }
                                            	    pushFollow(FOLLOW_typeRef_in_typeRefCore1846);
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
                                            	    break loop43;
                                                }
                                            } while (true);


                                            }
                                            break;

                                    }

                                    char_literal91=(Token)match(input,37,FOLLOW_37_in_typeRefCore1874); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    char_literal91_tree = (Object)adaptor.create(char_literal91);
                                    adaptor.addChild(root_0, char_literal91_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:715:1: templateDef : ( 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' structCore | functionDefinition );
    public final ObjCppParser.templateDef_return templateDef() throws RecognitionException {
        ObjCppParser.templateDef_return retval = new ObjCppParser.templateDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal92=null;
        Token char_literal93=null;
        Token char_literal95=null;
        Token char_literal97=null;
        ObjCppParser.templateArgDecl_return templateArgDecl94 = null;

        ObjCppParser.templateArgDecl_return templateArgDecl96 = null;

        ObjCppParser.structCore_return structCore98 = null;

        ObjCppParser.functionDefinition_return functionDefinition99 = null;


        Object string_literal92_tree=null;
        Object char_literal93_tree=null;
        Object char_literal95_tree=null;
        Object char_literal97_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:716:2: ( 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' structCore | functionDefinition )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==55) ) {
                alt50=1;
            }
            else if ( (LA50_0==IDENTIFIER||LA50_0==30||(LA50_0>=45 && LA50_0<=47)||(LA50_0>=59 && LA50_0<=73)) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:716:4: 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' structCore
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal92=(Token)match(input,55,FOLLOW_55_in_templateDef1906); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal92_tree = (Object)adaptor.create(string_literal92);
                    adaptor.addChild(root_0, string_literal92_tree);
                    }
                    char_literal93=(Token)match(input,36,FOLLOW_36_in_templateDef1908); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal93_tree = (Object)adaptor.create(char_literal93);
                    adaptor.addChild(root_0, char_literal93_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:716:19: ( templateArgDecl ( ',' templateArgDecl )* )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==46||LA49_0==56||(LA49_0>=59 && LA49_0<=73)) ) {
                        alt49=1;
                    }
                    switch (alt49) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:716:20: templateArgDecl ( ',' templateArgDecl )*
                            {
                            pushFollow(FOLLOW_templateArgDecl_in_templateDef1911);
                            templateArgDecl94=templateArgDecl();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, templateArgDecl94.getTree());
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:716:36: ( ',' templateArgDecl )*
                            loop48:
                            do {
                                int alt48=2;
                                int LA48_0 = input.LA(1);

                                if ( (LA48_0==27) ) {
                                    alt48=1;
                                }


                                switch (alt48) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:716:37: ',' templateArgDecl
                            	    {
                            	    char_literal95=(Token)match(input,27,FOLLOW_27_in_templateDef1914); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    char_literal95_tree = (Object)adaptor.create(char_literal95);
                            	    adaptor.addChild(root_0, char_literal95_tree);
                            	    }
                            	    pushFollow(FOLLOW_templateArgDecl_in_templateDef1916);
                            	    templateArgDecl96=templateArgDecl();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, templateArgDecl96.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop48;
                                }
                            } while (true);


                            }
                            break;

                    }

                    char_literal97=(Token)match(input,37,FOLLOW_37_in_templateDef1923); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal97_tree = (Object)adaptor.create(char_literal97);
                    adaptor.addChild(root_0, char_literal97_tree);
                    }
                    pushFollow(FOLLOW_structCore_in_templateDef1927);
                    structCore98=structCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structCore98.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:717:16: functionDefinition
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_functionDefinition_in_templateDef1931);
                    functionDefinition99=functionDefinition();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionDefinition99.getTree());

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:720:1: templateArgDecl : ( primitiveTypeRef ( '=' constant ) | ( 'typename' | 'class' ) IDENTIFIER ( '=' typeRef ) );
    public final ObjCppParser.templateArgDecl_return templateArgDecl() throws RecognitionException {
        ObjCppParser.templateArgDecl_return retval = new ObjCppParser.templateArgDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal101=null;
        Token set103=null;
        Token IDENTIFIER104=null;
        Token char_literal105=null;
        ObjCppParser.primitiveTypeRef_return primitiveTypeRef100 = null;

        ObjCppParser.constant_return constant102 = null;

        ObjCppParser.typeRef_return typeRef106 = null;


        Object char_literal101_tree=null;
        Object set103_tree=null;
        Object IDENTIFIER104_tree=null;
        Object char_literal105_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:721:2: ( primitiveTypeRef ( '=' constant ) | ( 'typename' | 'class' ) IDENTIFIER ( '=' typeRef ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=59 && LA51_0<=73)) ) {
                alt51=1;
            }
            else if ( (LA51_0==46||LA51_0==56) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:721:4: primitiveTypeRef ( '=' constant )
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primitiveTypeRef_in_templateArgDecl1943);
                    primitiveTypeRef100=primitiveTypeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveTypeRef100.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:721:21: ( '=' constant )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:721:22: '=' constant
                    {
                    char_literal101=(Token)match(input,29,FOLLOW_29_in_templateArgDecl1946); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal101_tree = (Object)adaptor.create(char_literal101);
                    adaptor.addChild(root_0, char_literal101_tree);
                    }
                    pushFollow(FOLLOW_constant_in_templateArgDecl1948);
                    constant102=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant102.getTree());

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:722:3: ( 'typename' | 'class' ) IDENTIFIER ( '=' typeRef )
                    {
                    root_0 = (Object)adaptor.nil();

                    set103=(Token)input.LT(1);
                    if ( input.LA(1)==46||input.LA(1)==56 ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set103));
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    IDENTIFIER104=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_templateArgDecl1963); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER104_tree = (Object)adaptor.create(IDENTIFIER104);
                    adaptor.addChild(root_0, IDENTIFIER104_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:722:37: ( '=' typeRef )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:722:38: '=' typeRef
                    {
                    char_literal105=(Token)match(input,29,FOLLOW_29_in_templateArgDecl1966); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal105_tree = (Object)adaptor.create(char_literal105);
                    adaptor.addChild(root_0, char_literal105_tree);
                    }
                    pushFollow(FOLLOW_typeRef_in_templateArgDecl1968);
                    typeRef106=typeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRef106.getTree());

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:725:1: functionSignatureSuffix returns [FunctionSignature signature] : tk= '(' exportationModifiers '*' ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' ;
    public final ObjCppParser.functionSignatureSuffix_return functionSignatureSuffix() throws RecognitionException {
        ObjCppParser.functionSignatureSuffix_return retval = new ObjCppParser.functionSignatureSuffix_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token tk=null;
        Token char_literal108=null;
        Token IDENTIFIER109=null;
        Token char_literal110=null;
        Token char_literal111=null;
        Token char_literal112=null;
        Token char_literal113=null;
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;

        ObjCppParser.exportationModifiers_return exportationModifiers107 = null;


        Object tk_tree=null;
        Object char_literal108_tree=null;
        Object IDENTIFIER109_tree=null;
        Object char_literal110_tree=null;
        Object char_literal111_tree=null;
        Object char_literal112_tree=null;
        Object char_literal113_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:726:2: (tk= '(' exportationModifiers '*' ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:726:4: tk= '(' exportationModifiers '*' ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')'
            {
            root_0 = (Object)adaptor.nil();

            tk=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffix1987); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tk_tree = (Object)adaptor.create(tk);
            adaptor.addChild(root_0, tk_tree);
            }
            pushFollow(FOLLOW_exportationModifiers_in_functionSignatureSuffix1989);
            exportationModifiers107=exportationModifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exportationModifiers107.getTree());
            char_literal108=(Token)match(input,51,FOLLOW_51_in_functionSignatureSuffix1991); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal108_tree = (Object)adaptor.create(char_literal108);
            adaptor.addChild(root_0, char_literal108_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:726:36: ( IDENTIFIER )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==IDENTIFIER) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: IDENTIFIER
                    {
                    IDENTIFIER109=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionSignatureSuffix1993); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER109_tree = (Object)adaptor.create(IDENTIFIER109);
                    adaptor.addChild(root_0, IDENTIFIER109_tree);
                    }

                    }
                    break;

            }

            char_literal110=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffix1996); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal110_tree = (Object)adaptor.create(char_literal110);
            adaptor.addChild(root_0, char_literal110_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, (IDENTIFIER109!=null?IDENTIFIER109.getText():null), null)), getLine(tk));
              			retval.signature.getFunction().setType(Function.Type.CFunction);
              			retval.signature.getFunction().addModifiers((exportationModifiers107!=null?exportationModifiers107.modifiers:null));
              		
            }
            char_literal111=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffix2002); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal111_tree = (Object)adaptor.create(char_literal111);
            adaptor.addChild(root_0, char_literal111_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:731:7: (a1= argDef ( ',' ax= argDef )* )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==IDENTIFIER||LA54_0==30||(LA54_0>=44 && LA54_0<=47)||(LA54_0>=59 && LA54_0<=73)) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:732:4: a1= argDef ( ',' ax= argDef )*
                    {
                    pushFollow(FOLLOW_argDef_in_functionSignatureSuffix2011);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					((FunctionSignature)retval.signature).getFunction().addArg((a1!=null?a1.arg:null)); 
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:736:4: ( ',' ax= argDef )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==27) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:737:5: ',' ax= argDef
                    	    {
                    	    char_literal112=(Token)match(input,27,FOLLOW_27_in_functionSignatureSuffix2024); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal112_tree = (Object)adaptor.create(char_literal112);
                    	    adaptor.addChild(root_0, char_literal112_tree);
                    	    }
                    	    pushFollow(FOLLOW_argDef_in_functionSignatureSuffix2033);
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
                    	    break loop53;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal113=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffix2048); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal113_tree = (Object)adaptor.create(char_literal113);
            adaptor.addChild(root_0, char_literal113_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:745:1: functionSignatureSuffixNoName returns [FunctionSignature signature] : tk= '(' exportationModifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' ;
    public final ObjCppParser.functionSignatureSuffixNoName_return functionSignatureSuffixNoName() throws RecognitionException {
        ObjCppParser.functionSignatureSuffixNoName_return retval = new ObjCppParser.functionSignatureSuffixNoName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token tk=null;
        Token char_literal115=null;
        Token char_literal116=null;
        Token char_literal117=null;
        Token char_literal118=null;
        Token char_literal119=null;
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;

        ObjCppParser.exportationModifiers_return exportationModifiers114 = null;


        Object tk_tree=null;
        Object char_literal115_tree=null;
        Object char_literal116_tree=null;
        Object char_literal117_tree=null;
        Object char_literal118_tree=null;
        Object char_literal119_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:746:2: (tk= '(' exportationModifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:746:4: tk= '(' exportationModifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')'
            {
            root_0 = (Object)adaptor.nil();

            tk=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffixNoName2065); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tk_tree = (Object)adaptor.create(tk);
            adaptor.addChild(root_0, tk_tree);
            }
            pushFollow(FOLLOW_exportationModifiers_in_functionSignatureSuffixNoName2067);
            exportationModifiers114=exportationModifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exportationModifiers114.getTree());
            char_literal115=(Token)match(input,51,FOLLOW_51_in_functionSignatureSuffixNoName2069); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal115_tree = (Object)adaptor.create(char_literal115);
            adaptor.addChild(root_0, char_literal115_tree);
            }
            char_literal116=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffixNoName2071); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal116_tree = (Object)adaptor.create(char_literal116);
            adaptor.addChild(root_0, char_literal116_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, null, null)), getLine(tk));
              			retval.signature.getFunction().setType(Function.Type.CFunction);
              			retval.signature.getFunction().addModifiers((exportationModifiers114!=null?exportationModifiers114.modifiers:null));
              		
            }
            char_literal117=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffixNoName2077); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal117_tree = (Object)adaptor.create(char_literal117);
            adaptor.addChild(root_0, char_literal117_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:751:7: (a1= argDef ( ',' ax= argDef )* )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==IDENTIFIER||LA56_0==30||(LA56_0>=44 && LA56_0<=47)||(LA56_0>=59 && LA56_0<=73)) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:752:4: a1= argDef ( ',' ax= argDef )*
                    {
                    pushFollow(FOLLOW_argDef_in_functionSignatureSuffixNoName2086);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					((FunctionSignature)retval.signature).getFunction().addArg((a1!=null?a1.arg:null)); 
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:756:4: ( ',' ax= argDef )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==27) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:757:5: ',' ax= argDef
                    	    {
                    	    char_literal118=(Token)match(input,27,FOLLOW_27_in_functionSignatureSuffixNoName2099); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal118_tree = (Object)adaptor.create(char_literal118);
                    	    adaptor.addChild(root_0, char_literal118_tree);
                    	    }
                    	    pushFollow(FOLLOW_argDef_in_functionSignatureSuffixNoName2108);
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
                    	    break loop55;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal119=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffixNoName2123); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal119_tree = (Object)adaptor.create(char_literal119);
            adaptor.addChild(root_0, char_literal119_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:765:1: structOrEnum returns [TypeRef type] : ( structCore | enumCore );
    public final ObjCppParser.structOrEnum_return structOrEnum() throws RecognitionException {
        ObjCppParser.structOrEnum_return retval = new ObjCppParser.structOrEnum_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.structCore_return structCore120 = null;

        ObjCppParser.enumCore_return enumCore121 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:766:2: ( structCore | enumCore )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( ((LA57_0>=45 && LA57_0<=47)) ) {
                alt57=1;
            }
            else if ( (LA57_0==30) ) {
                alt57=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:3: structCore
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_structCore_in_structOrEnum2141);
                    structCore120=structCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structCore120.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (structCore120!=null?structCore120.struct:null); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:768:3: enumCore
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_enumCore_in_structOrEnum2149);
                    enumCore121=enumCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, enumCore121.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (enumCore121!=null?enumCore121.e:null); 
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:771:1: typeRefCoreOrFuncSig returns [TypeRef type] : typeRefCore ( ( typeMutator )* functionSignatureSuffix )? ;
    public final ObjCppParser.typeRefCoreOrFuncSig_return typeRefCoreOrFuncSig() throws RecognitionException {
        ObjCppParser.typeRefCoreOrFuncSig_return retval = new ObjCppParser.typeRefCoreOrFuncSig_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.typeRefCore_return typeRefCore122 = null;

        ObjCppParser.typeMutator_return typeMutator123 = null;

        ObjCppParser.functionSignatureSuffix_return functionSignatureSuffix124 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:772:2: ( typeRefCore ( ( typeMutator )* functionSignatureSuffix )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:772:4: typeRefCore ( ( typeMutator )* functionSignatureSuffix )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_typeRefCore_in_typeRefCoreOrFuncSig2167);
            typeRefCore122=typeRefCore();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRefCore122.getTree());
            if ( state.backtracking==0 ) {
               retval.type = (typeRefCore122!=null?typeRefCore122.type:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:773:3: ( ( typeMutator )* functionSignatureSuffix )?
            int alt59=2;
            alt59 = dfa59.predict(input);
            switch (alt59) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:774:4: ( typeMutator )* functionSignatureSuffix
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:774:4: ( typeMutator )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==IDENTIFIER||(LA58_0>=51 && LA58_0<=53)) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:775:5: typeMutator
                    	    {
                    	    pushFollow(FOLLOW_typeMutator_in_typeRefCoreOrFuncSig2184);
                    	    typeMutator123=typeMutator();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeMutator123.getTree());
                    	    if ( state.backtracking==0 ) {

                    	      					retval.type = (typeMutator123!=null?typeMutator123.mutator:null).mutateType(retval.type);
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);

                    pushFollow(FOLLOW_functionSignatureSuffix_in_typeRefCoreOrFuncSig2197);
                    functionSignatureSuffix124=functionSignatureSuffix();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionSignatureSuffix124.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				(functionSignatureSuffix124!=null?functionSignatureSuffix124.signature:null).getFunction().setValueType(retval.type); 
                      				retval.type = (functionSignatureSuffix124!=null?functionSignatureSuffix124.signature:null);
                      			
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:786:1: typeRefCoreOrAnonymousFuncSig returns [TypeRef type] : typeRefCore ( ( typeMutator )* functionSignatureSuffixNoName )? ;
    public final ObjCppParser.typeRefCoreOrAnonymousFuncSig_return typeRefCoreOrAnonymousFuncSig() throws RecognitionException {
        ObjCppParser.typeRefCoreOrAnonymousFuncSig_return retval = new ObjCppParser.typeRefCoreOrAnonymousFuncSig_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.typeRefCore_return typeRefCore125 = null;

        ObjCppParser.typeMutator_return typeMutator126 = null;

        ObjCppParser.functionSignatureSuffixNoName_return functionSignatureSuffixNoName127 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:787:2: ( typeRefCore ( ( typeMutator )* functionSignatureSuffixNoName )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:787:4: typeRefCore ( ( typeMutator )* functionSignatureSuffixNoName )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_typeRefCore_in_typeRefCoreOrAnonymousFuncSig2221);
            typeRefCore125=typeRefCore();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRefCore125.getTree());
            if ( state.backtracking==0 ) {
               retval.type = (typeRefCore125!=null?typeRefCore125.type:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:788:3: ( ( typeMutator )* functionSignatureSuffixNoName )?
            int alt61=2;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:789:4: ( typeMutator )* functionSignatureSuffixNoName
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:789:4: ( typeMutator )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==IDENTIFIER||(LA60_0>=51 && LA60_0<=53)) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:790:5: typeMutator
                    	    {
                    	    pushFollow(FOLLOW_typeMutator_in_typeRefCoreOrAnonymousFuncSig2238);
                    	    typeMutator126=typeMutator();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeMutator126.getTree());
                    	    if ( state.backtracking==0 ) {

                    	      					retval.type = (typeMutator126!=null?typeMutator126.mutator:null).mutateType(retval.type);
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop60;
                        }
                    } while (true);

                    pushFollow(FOLLOW_functionSignatureSuffixNoName_in_typeRefCoreOrAnonymousFuncSig2251);
                    functionSignatureSuffixNoName127=functionSignatureSuffixNoName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionSignatureSuffixNoName127.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				(functionSignatureSuffixNoName127!=null?functionSignatureSuffixNoName127.signature:null).getFunction().setValueType(retval.type); 
                      				retval.type = (functionSignatureSuffixNoName127!=null?functionSignatureSuffixNoName127.signature:null);
                      			
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:801:1: plainTypeRef returns [TypeRef type] : ( structOrEnum | typeRefCoreOrFuncSig );
    public final ObjCppParser.plainTypeRef_return plainTypeRef() throws RecognitionException {
        ObjCppParser.plainTypeRef_return retval = new ObjCppParser.plainTypeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.structOrEnum_return structOrEnum128 = null;

        ObjCppParser.typeRefCoreOrFuncSig_return typeRefCoreOrFuncSig129 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:802:2: ( structOrEnum | typeRefCoreOrFuncSig )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==30||(LA62_0>=45 && LA62_0<=47)) ) {
                alt62=1;
            }
            else if ( (LA62_0==IDENTIFIER||(LA62_0>=59 && LA62_0<=73)) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:803:3: structOrEnum
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_structOrEnum_in_plainTypeRef2278);
                    structOrEnum128=structOrEnum();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structOrEnum128.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (structOrEnum128!=null?structOrEnum128.type:null); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:804:3: typeRefCoreOrFuncSig
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_typeRefCoreOrFuncSig_in_plainTypeRef2286);
                    typeRefCoreOrFuncSig129=typeRefCoreOrFuncSig();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRefCoreOrFuncSig129.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (typeRefCoreOrFuncSig129!=null?typeRefCoreOrFuncSig129.type:null); 
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:807:1: declarator returns [Declarator declarator, List<Modifier> modifiers] : ({...}? modifier )* ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? ) ;
    public final ObjCppParser.declarator_return declarator() throws RecognitionException {
        ObjCppParser.declarator_return retval = new ObjCppParser.declarator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token pt=null;
        Token char_literal132=null;
        ObjCppParser.declarator_return inner = null;

        ObjCppParser.modifier_return modifier130 = null;

        ObjCppParser.directDeclarator_return directDeclarator131 = null;

        ObjCppParser.expression_return expression133 = null;


        Object pt_tree=null;
        Object char_literal132_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:808:2: ( ({...}? modifier )* ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:808:4: ({...}? modifier )* ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:809:3: ({...}? modifier )*
            loop63:
            do {
                int alt63=2;
                alt63 = dfa63.predict(input);
                switch (alt63) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:810:4: {...}? modifier
            	    {
            	    if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "declarator", " next(Modifier.Kind.TypeQualifier) ");
            	    }
            	    pushFollow(FOLLOW_modifier_in_declarator2315);
            	    modifier130=modifier();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, modifier130.getTree());
            	    if ( state.backtracking==0 ) {

            	      				retval.modifiers.add((modifier130!=null?modifier130.modifier:null));
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:817:3: ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:818:4: ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )?
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:818:4: ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( ((LA64_0>=51 && LA64_0<=52)||LA64_0==57) ) {
                alt64=1;
            }
            else if ( (LA64_0==IDENTIFIER||LA64_0==34) ) {
                alt64=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:819:5: (pt= ( '*' | '&' | '^' ) inner= declarator )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:819:5: (pt= ( '*' | '&' | '^' ) inner= declarator )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:820:6: pt= ( '*' | '&' | '^' ) inner= declarator
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

                    pushFollow(FOLLOW_declarator_in_declarator2371);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:825:5: directDeclarator
                    {
                    pushFollow(FOLLOW_directDeclarator_in_declarator2387);
                    directDeclarator131=directDeclarator();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, directDeclarator131.getTree());
                    if ( state.backtracking==0 ) {
                       
                      					retval.declarator = (directDeclarator131!=null?directDeclarator131.declarator:null); 
                      				
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:829:4: ( '=' expression )?
            int alt65=2;
            alt65 = dfa65.predict(input);
            switch (alt65) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:830:5: '=' expression
                    {
                    char_literal132=(Token)match(input,29,FOLLOW_29_in_declarator2406); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal132_tree = (Object)adaptor.create(char_literal132);
                    adaptor.addChild(root_0, char_literal132_tree);
                    }
                    pushFollow(FOLLOW_expression_in_declarator2413);
                    expression133=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression133.getTree());
                    if ( state.backtracking==0 ) {

                      					retval.declarator.setDefaultValue((expression133!=null?expression133.expr:null));
                      				
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:842:1: namedTypeRef returns [TaggedTypeRef type] : ( structCore {...}? | enumCore {...}?);
    public final ObjCppParser.namedTypeRef_return namedTypeRef() throws RecognitionException {
        ObjCppParser.namedTypeRef_return retval = new ObjCppParser.namedTypeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.structCore_return structCore134 = null;

        ObjCppParser.enumCore_return enumCore135 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:843:2: ( structCore {...}? | enumCore {...}?)
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( ((LA66_0>=45 && LA66_0<=47)) ) {
                alt66=1;
            }
            else if ( (LA66_0==30) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:844:3: structCore {...}?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_structCore_in_namedTypeRef2447);
                    structCore134=structCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structCore134.getTree());
                    if ( !(( (structCore134!=null?structCore134.struct:null).getTag() != null )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "namedTypeRef", " $structCore.struct.getTag() != null ");
                    }
                    if ( state.backtracking==0 ) {

                      			retval.type = (structCore134!=null?structCore134.struct:null);
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:847:3: enumCore {...}?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_enumCore_in_namedTypeRef2457);
                    enumCore135=enumCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, enumCore135.getTree());
                    if ( !(( (enumCore135!=null?enumCore135.e:null).getTag() != null )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "namedTypeRef", " $enumCore.e.getTag() != null ");
                    }
                    if ( state.backtracking==0 ) {

                      			retval.type = (enumCore135!=null?enumCore135.e:null);
                      		
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:852:1: typeDef returns [TypeDef typeDef] : 'typedef' varDecl {...}?;
    public final ObjCppParser.typeDef_return typeDef() throws RecognitionException {
        ObjCppParser.typeDef_return retval = new ObjCppParser.typeDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal136=null;
        ObjCppParser.varDecl_return varDecl137 = null;


        Object string_literal136_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:853:2: ( 'typedef' varDecl {...}?)
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:853:4: 'typedef' varDecl {...}?
            {
            root_0 = (Object)adaptor.nil();

            string_literal136=(Token)match(input,58,FOLLOW_58_in_typeDef2476); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal136_tree = (Object)adaptor.create(string_literal136);
            adaptor.addChild(root_0, string_literal136_tree);
            }
            pushFollow(FOLLOW_varDecl_in_typeDef2482);
            varDecl137=varDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl137.getTree());
            if ( !(( 
            			((varDecl137!=null?varDecl137.decl:null) instanceof VariablesDeclaration) 
            		)) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "typeDef", " \n\t\t\t($varDecl.decl instanceof VariablesDeclaration) \n\t\t");
            }
            if ( state.backtracking==0 ) {

              			VariablesDeclaration vd = (VariablesDeclaration)(varDecl137!=null?varDecl137.decl:null);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:862:1: varDeclEOF returns [Declaration decl] : varDecl EOF ;
    public final ObjCppParser.varDeclEOF_return varDeclEOF() throws RecognitionException {
        ObjCppParser.varDeclEOF_return retval = new ObjCppParser.varDeclEOF_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF139=null;
        ObjCppParser.varDecl_return varDecl138 = null;


        Object EOF139_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:863:2: ( varDecl EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:863:4: varDecl EOF
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_varDecl_in_varDeclEOF2502);
            varDecl138=varDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl138.getTree());
            EOF139=(Token)match(input,EOF,FOLLOW_EOF_in_varDeclEOF2504); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EOF139_tree = (Object)adaptor.create(EOF139);
            adaptor.addChild(root_0, EOF139_tree);
            }
            if ( state.backtracking==0 ) {
               retval.decl = (varDecl138!=null?varDecl138.decl:null); 
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:866:1: varDecl returns [Declaration decl, TypeRef type] : ({...}?sm= modifier | {...}?tm= modifier )* ( ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList ) ) ';' ;
    public final ObjCppParser.varDecl_return varDecl() throws RecognitionException {
        ObjCppParser.varDecl_return retval = new ObjCppParser.varDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal141=null;
        ObjCppParser.modifier_return sm = null;

        ObjCppParser.modifier_return tm = null;

        ObjCppParser.declaratorsList_return d1 = null;

        ObjCppParser.typeRefCoreOrAnonymousFuncSig_return tcfs = null;

        ObjCppParser.declaratorsList_return d2 = null;

        ObjCppParser.structOrEnum_return structOrEnum140 = null;


        Object char_literal141_tree=null;


        	List<Modifier> stoMods = new ArrayList<Modifier>(), typMods = new ArrayList<Modifier>();

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:870:2: ( ({...}?sm= modifier | {...}?tm= modifier )* ( ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList ) ) ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:870:4: ({...}?sm= modifier | {...}?tm= modifier )* ( ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList ) ) ';'
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:870:4: ({...}?sm= modifier | {...}?tm= modifier )*
            loop67:
            do {
                int alt67=3;
                alt67 = dfa67.predict(input);
                switch (alt67) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:871:4: {...}?sm= modifier
            	    {
            	    if ( !(( next(Modifier.Kind.StorageClassSpecifier) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "varDecl", " next(Modifier.Kind.StorageClassSpecifier) ");
            	    }
            	    pushFollow(FOLLOW_modifier_in_varDecl2541);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:873:4: {...}?tm= modifier
            	    {
            	    if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "varDecl", " next(Modifier.Kind.TypeQualifier) ");
            	    }
            	    pushFollow(FOLLOW_modifier_in_varDecl2558);
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
            	    break loop67;
                }
            } while (true);

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:876:3: ( ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:880:4: ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList )
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:880:4: ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==30||(LA69_0>=45 && LA69_0<=47)) ) {
                alt69=1;
            }
            else if ( (LA69_0==IDENTIFIER||(LA69_0>=59 && LA69_0<=73)) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:881:5: structOrEnum ( (d1= declaratorsList )? )
                    {
                    pushFollow(FOLLOW_structOrEnum_in_varDecl2585);
                    structOrEnum140=structOrEnum();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structOrEnum140.getTree());
                    if ( state.backtracking==0 ) {
                       
                      					retval.type = (structOrEnum140!=null?structOrEnum140.type:null);
                      					//retval.decl = new VariablesDeclaration(retval.type);
                      				
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:885:5: ( (d1= declaratorsList )? )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:886:6: (d1= declaratorsList )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:886:8: (d1= declaratorsList )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==IDENTIFIER||LA68_0==34||(LA68_0>=51 && LA68_0<=52)||LA68_0==57) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: d1= declaratorsList
                            {
                            pushFollow(FOLLOW_declaratorsList_in_varDecl2602);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:893:5: tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList
                    {
                    pushFollow(FOLLOW_typeRefCoreOrAnonymousFuncSig_in_varDecl2622);
                    tcfs=typeRefCoreOrAnonymousFuncSig();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tcfs.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (tcfs!=null?tcfs.type:null); 
                    }
                    pushFollow(FOLLOW_declaratorsList_in_varDecl2632);
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

            char_literal141=(Token)match(input,28,FOLLOW_28_in_varDecl2669); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal141_tree = (Object)adaptor.create(char_literal141);
            adaptor.addChild(root_0, char_literal141_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:921:1: objCProtocolRefList : '<' IDENTIFIER ( ',' IDENTIFIER )* '>' ;
    public final ObjCppParser.objCProtocolRefList_return objCProtocolRefList() throws RecognitionException {
        ObjCppParser.objCProtocolRefList_return retval = new ObjCppParser.objCProtocolRefList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal142=null;
        Token IDENTIFIER143=null;
        Token char_literal144=null;
        Token IDENTIFIER145=null;
        Token char_literal146=null;

        Object char_literal142_tree=null;
        Object IDENTIFIER143_tree=null;
        Object char_literal144_tree=null;
        Object IDENTIFIER145_tree=null;
        Object char_literal146_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:922:2: ( '<' IDENTIFIER ( ',' IDENTIFIER )* '>' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:922:4: '<' IDENTIFIER ( ',' IDENTIFIER )* '>'
            {
            root_0 = (Object)adaptor.nil();

            char_literal142=(Token)match(input,36,FOLLOW_36_in_objCProtocolRefList2683); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal142_tree = (Object)adaptor.create(char_literal142);
            adaptor.addChild(root_0, char_literal142_tree);
            }
            IDENTIFIER143=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCProtocolRefList2688); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER143_tree = (Object)adaptor.create(IDENTIFIER143);
            adaptor.addChild(root_0, IDENTIFIER143_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:924:3: ( ',' IDENTIFIER )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==27) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:925:4: ',' IDENTIFIER
            	    {
            	    char_literal144=(Token)match(input,27,FOLLOW_27_in_objCProtocolRefList2698); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal144_tree = (Object)adaptor.create(char_literal144);
            	    adaptor.addChild(root_0, char_literal144_tree);
            	    }
            	    IDENTIFIER145=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCProtocolRefList2704); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDENTIFIER145_tree = (Object)adaptor.create(IDENTIFIER145);
            	    adaptor.addChild(root_0, IDENTIFIER145_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop70;
                }
            } while (true);

            char_literal146=(Token)match(input,37,FOLLOW_37_in_objCProtocolRefList2714); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal146_tree = (Object)adaptor.create(char_literal146);
            adaptor.addChild(root_0, char_literal146_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:938:1: declaratorsList returns [List<Declarator> declarators] : (d= declarator ( ',' x= declarator )* ) ;
    public final ObjCppParser.declaratorsList_return declaratorsList() throws RecognitionException {
        ObjCppParser.declaratorsList_return retval = new ObjCppParser.declaratorsList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal147=null;
        ObjCppParser.declarator_return d = null;

        ObjCppParser.declarator_return x = null;


        Object char_literal147_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:939:2: ( (d= declarator ( ',' x= declarator )* ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:939:4: (d= declarator ( ',' x= declarator )* )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.declarators = new ArrayList<Declarator>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:940:3: (d= declarator ( ',' x= declarator )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:941:4: d= declarator ( ',' x= declarator )*
            {
            pushFollow(FOLLOW_declarator_in_declaratorsList2741);
            d=declarator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());
            if ( state.backtracking==0 ) {
               retval.declarators.add((d!=null?d.declarator:null)); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:942:4: ( ',' x= declarator )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==27) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:943:5: ',' x= declarator
            	    {
            	    char_literal147=(Token)match(input,27,FOLLOW_27_in_declaratorsList2754); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal147_tree = (Object)adaptor.create(char_literal147);
            	    adaptor.addChild(root_0, char_literal147_tree);
            	    }
            	    pushFollow(FOLLOW_declarator_in_declaratorsList2763);
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
            	    break loop71;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:949:1: directDeclarator returns [Declarator declarator] : ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' ) ( '[' ( expression | ) ']' | '(' argList ')' )* ;
    public final ObjCppParser.directDeclarator_return directDeclarator() throws RecognitionException {
        ObjCppParser.directDeclarator_return retval = new ObjCppParser.directDeclarator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER148=null;
        Token char_literal149=null;
        Token char_literal150=null;
        Token char_literal151=null;
        Token char_literal153=null;
        Token char_literal154=null;
        Token char_literal156=null;
        ObjCppParser.modifier_return im = null;

        ObjCppParser.declarator_return inner = null;

        ObjCppParser.expression_return expression152 = null;

        ObjCppParser.argList_return argList155 = null;


        Object IDENTIFIER148_tree=null;
        Object char_literal149_tree=null;
        Object char_literal150_tree=null;
        Object char_literal151_tree=null;
        Object char_literal153_tree=null;
        Object char_literal154_tree=null;
        Object char_literal156_tree=null;


        	List<Modifier> modifiers = new ArrayList<Modifier>();

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:953:2: ( ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' ) ( '[' ( expression | ) ']' | '(' argList ')' )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:953:4: ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' ) ( '[' ( expression | ) ']' | '(' argList ')' )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:953:4: ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==IDENTIFIER) ) {
                alt73=1;
            }
            else if ( (LA73_0==34) ) {
                alt73=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:955:4: IDENTIFIER
                    {
                    IDENTIFIER148=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_directDeclarator2806); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER148_tree = (Object)adaptor.create(IDENTIFIER148);
                    adaptor.addChild(root_0, IDENTIFIER148_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				retval.declarator = new DirectDeclarator((IDENTIFIER148!=null?IDENTIFIER148.getText():null));
                      			
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:958:4: '(' (im= modifier )* inner= declarator ')'
                    {
                    char_literal149=(Token)match(input,34,FOLLOW_34_in_directDeclarator2816); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal149_tree = (Object)adaptor.create(char_literal149);
                    adaptor.addChild(root_0, char_literal149_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:959:4: (im= modifier )*
                    loop72:
                    do {
                        int alt72=2;
                        alt72 = dfa72.predict(input);
                        switch (alt72) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:959:5: im= modifier
                    	    {
                    	    pushFollow(FOLLOW_modifier_in_directDeclarator2825);
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
                    	    break loop72;
                        }
                    } while (true);

                    pushFollow(FOLLOW_declarator_in_directDeclarator2836);
                    inner=declarator();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inner.getTree());
                    char_literal150=(Token)match(input,35,FOLLOW_35_in_directDeclarator2842); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal150_tree = (Object)adaptor.create(char_literal150);
                    adaptor.addChild(root_0, char_literal150_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				retval.declarator = (inner!=null?inner.declarator:null);
                      				retval.declarator.setParenthesized(true);
                      				retval.declarator.addModifiers(modifiers);
                      			
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:967:3: ( '[' ( expression | ) ']' | '(' argList ')' )*
            loop75:
            do {
                int alt75=3;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==53) ) {
                    alt75=1;
                }
                else if ( (LA75_0==34) ) {
                    alt75=2;
                }


                switch (alt75) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:968:4: '[' ( expression | ) ']'
            	    {
            	    char_literal151=(Token)match(input,53,FOLLOW_53_in_directDeclarator2857); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal151_tree = (Object)adaptor.create(char_literal151);
            	    adaptor.addChild(root_0, char_literal151_tree);
            	    }
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:969:4: ( expression | )
            	    int alt74=2;
            	    alt74 = dfa74.predict(input);
            	    switch (alt74) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:970:5: expression
            	            {
            	            pushFollow(FOLLOW_expression_in_directDeclarator2869);
            	            expression152=expression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression152.getTree());
            	            if ( state.backtracking==0 ) {

            	              					if (retval.declarator instanceof ArrayDeclarator)
            	              						((ArrayDeclarator)retval.declarator).addDimension((expression152!=null?expression152.expr:null));
            	              					else
            	              						retval.declarator = new ArrayDeclarator(retval.declarator, (expression152!=null?expression152.expr:null));
            	              				
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:975:9: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              					retval.declarator = new ArrayDeclarator(retval.declarator, new Expression.EmptyArraySize());
            	              				
            	            }

            	            }
            	            break;

            	    }

            	    char_literal153=(Token)match(input,54,FOLLOW_54_in_directDeclarator2885); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal153_tree = (Object)adaptor.create(char_literal153);
            	    adaptor.addChild(root_0, char_literal153_tree);
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:980:4: '(' argList ')'
            	    {
            	    char_literal154=(Token)match(input,34,FOLLOW_34_in_directDeclarator2893); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal154_tree = (Object)adaptor.create(char_literal154);
            	    adaptor.addChild(root_0, char_literal154_tree);
            	    }
            	    pushFollow(FOLLOW_argList_in_directDeclarator2895);
            	    argList155=argList();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, argList155.getTree());
            	    char_literal156=(Token)match(input,35,FOLLOW_35_in_directDeclarator2897); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal156_tree = (Object)adaptor.create(char_literal156);
            	    adaptor.addChild(root_0, char_literal156_tree);
            	    }
            	    if ( state.backtracking==0 ) {

            	      				retval.declarator = new FunctionDeclarator(retval.declarator, (argList155!=null?argList155.args:null));
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop75;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:986:1: argList returns [List<Arg> args, boolean isObjC] : (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? ;
    public final ObjCppParser.argList_return argList() throws RecognitionException {
        ObjCppParser.argList_return retval = new ObjCppParser.argList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal157=null;
        Token char_literal158=null;
        Token string_literal159=null;
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        Object char_literal157_tree=null;
        Object char_literal158_tree=null;
        Object string_literal159_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:987:2: ( (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:987:4: (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )?
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               
              			retval.isObjC = false; 
              			retval.args = new ArrayList<Arg>();
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:991:3: (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==IDENTIFIER||LA78_0==30||(LA78_0>=44 && LA78_0<=47)||(LA78_0>=59 && LA78_0<=73)) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:992:4: a1= argDef ( ',' ax= argDef )* ( ',' '...' )?
                    {
                    pushFollow(FOLLOW_argDef_in_argList2930);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {

                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					retval.args.add((a1!=null?a1.arg:null));
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:996:4: ( ',' ax= argDef )*
                    loop76:
                    do {
                        int alt76=2;
                        alt76 = dfa76.predict(input);
                        switch (alt76) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:997:5: ',' ax= argDef
                    	    {
                    	    char_literal157=(Token)match(input,27,FOLLOW_27_in_argList2943); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal157_tree = (Object)adaptor.create(char_literal157);
                    	    adaptor.addChild(root_0, char_literal157_tree);
                    	    }
                    	    pushFollow(FOLLOW_argDef_in_argList2952);
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
                    	    break loop76;
                        }
                    } while (true);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1002:4: ( ',' '...' )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==27) ) {
                        alt77=1;
                    }
                    switch (alt77) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1003:5: ',' '...'
                            {
                            char_literal158=(Token)match(input,27,FOLLOW_27_in_argList2972); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal158_tree = (Object)adaptor.create(char_literal158);
                            adaptor.addChild(root_0, char_literal158_tree);
                            }
                            string_literal159=(Token)match(input,44,FOLLOW_44_in_argList2974); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal159_tree = (Object)adaptor.create(string_literal159);
                            adaptor.addChild(root_0, string_literal159_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1012:1: typeRef returns [TypeRef type] : plainTypeRef ( typeMutator )* ;
    public final ObjCppParser.typeRef_return typeRef() throws RecognitionException {
        ObjCppParser.typeRef_return retval = new ObjCppParser.typeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.plainTypeRef_return plainTypeRef160 = null;

        ObjCppParser.typeMutator_return typeMutator161 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1013:2: ( plainTypeRef ( typeMutator )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1014:3: plainTypeRef ( typeMutator )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_plainTypeRef_in_typeRef3008);
            plainTypeRef160=plainTypeRef();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, plainTypeRef160.getTree());
            if ( state.backtracking==0 ) {

              			retval.type = (plainTypeRef160!=null?plainTypeRef160.type:null);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1017:3: ( typeMutator )*
            loop79:
            do {
                int alt79=2;
                alt79 = dfa79.predict(input);
                switch (alt79) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1018:4: typeMutator
            	    {
            	    pushFollow(FOLLOW_typeMutator_in_typeRef3019);
            	    typeMutator161=typeMutator();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeMutator161.getTree());
            	    if ( state.backtracking==0 ) {

            	      				retval.type = (typeMutator161!=null?typeMutator161.mutator:null).mutateType(retval.type);
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop79;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1024:1: primSignModifier : ( 'signed' | 'unsigned' | '__signed' | '__unsigned' );
    public final ObjCppParser.primSignModifier_return primSignModifier() throws RecognitionException {
        ObjCppParser.primSignModifier_return retval = new ObjCppParser.primSignModifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set162=null;

        Object set162_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1025:2: ( 'signed' | 'unsigned' | '__signed' | '__unsigned' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:
            {
            root_0 = (Object)adaptor.nil();

            set162=(Token)input.LT(1);
            if ( (input.LA(1)>=59 && input.LA(1)<=62) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set162));
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1027:1: primSizeModifier : ( 'long' | 'short' );
    public final ObjCppParser.primSizeModifier_return primSizeModifier() throws RecognitionException {
        ObjCppParser.primSizeModifier_return retval = new ObjCppParser.primSizeModifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set163=null;

        Object set163_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1028:2: ( 'long' | 'short' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:
            {
            root_0 = (Object)adaptor.nil();

            set163=(Token)input.LT(1);
            if ( (input.LA(1)>=63 && input.LA(1)<=64) ) {
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
    // $ANTLR end "primSizeModifier"

    public static class primitiveTypeName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primitiveTypeName"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1030:1: primitiveTypeName : ( 'long' | 'int' | 'short' | 'double' | 'float' | 'char' | 'void' | '__int8' | '__int16' | '__int32' | '__int64' );
    public final ObjCppParser.primitiveTypeName_return primitiveTypeName() throws RecognitionException {
        ObjCppParser.primitiveTypeName_return retval = new ObjCppParser.primitiveTypeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set164=null;

        Object set164_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1031:2: ( 'long' | 'int' | 'short' | 'double' | 'float' | 'char' | 'void' | '__int8' | '__int16' | '__int32' | '__int64' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:
            {
            root_0 = (Object)adaptor.nil();

            set164=(Token)input.LT(1);
            if ( (input.LA(1)>=63 && input.LA(1)<=73) ) {
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
    // $ANTLR end "primitiveTypeName"

    public static class primitiveTypeRef_return extends ParserRuleReturnScope {
        public TypeRef type;
        public int line;
        public List<Modifier> modifiers;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primitiveTypeRef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1043:1: primitiveTypeRef returns [TypeRef type, int line, List<Modifier> modifiers] : ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) ) ;
    public final ObjCppParser.primitiveTypeRef_return primitiveTypeRef() throws RecognitionException {
        ObjCppParser.primitiveTypeRef_return retval = new ObjCppParser.primitiveTypeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.primSignModifier_return mod1 = null;

        ObjCppParser.primSizeModifier_return mod2 = null;

        ObjCppParser.primSizeModifier_return mod3 = null;

        ObjCppParser.primitiveTypeName_return name = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1044:2: ( ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1044:4: ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               
              			retval.line = getLine(); 
              			retval.modifiers = new ArrayList<Modifier>();
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1048:3: ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1049:4: (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName )
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1049:8: (mod1= primSignModifier )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( ((LA80_0>=59 && LA80_0<=62)) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: mod1= primSignModifier
                    {
                    pushFollow(FOLLOW_primSignModifier_in_primitiveTypeRef3158);
                    mod1=primSignModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mod1.getTree());

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1050:4: (mod2= primSizeModifier (mod3= primSizeModifier )? )?
            int alt82=2;
            alt82 = dfa82.predict(input);
            switch (alt82) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1050:5: mod2= primSizeModifier (mod3= primSizeModifier )?
                    {
                    pushFollow(FOLLOW_primSizeModifier_in_primitiveTypeRef3169);
                    mod2=primSizeModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mod2.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1051:8: (mod3= primSizeModifier )?
                    int alt81=2;
                    alt81 = dfa81.predict(input);
                    switch (alt81) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: mod3= primSizeModifier
                            {
                            pushFollow(FOLLOW_primSizeModifier_in_primitiveTypeRef3176);
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1059:4: (name= primitiveTypeName )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1062:5: name= primitiveTypeName
            {
            pushFollow(FOLLOW_primitiveTypeName_in_primitiveTypeRef3219);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1091:1: objCMethodCall returns [FunctionCall expr] : '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']' ;
    public final ObjCppParser.objCMethodCall_return objCMethodCall() throws RecognitionException {
        ObjCppParser.objCMethodCall_return retval = new ObjCppParser.objCMethodCall_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token methodName=null;
        Token selx=null;
        Token char_literal165=null;
        Token char_literal166=null;
        Token char_literal167=null;
        Token char_literal168=null;
        ObjCppParser.expression_return target = null;

        ObjCppParser.expression_return arg1 = null;

        ObjCppParser.expression_return argx = null;


        Object methodName_tree=null;
        Object selx_tree=null;
        Object char_literal165_tree=null;
        Object char_literal166_tree=null;
        Object char_literal167_tree=null;
        Object char_literal168_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1092:2: ( '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1093:3: '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']'
            {
            root_0 = (Object)adaptor.nil();

            char_literal165=(Token)match(input,53,FOLLOW_53_in_objCMethodCall3258); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal165_tree = (Object)adaptor.create(char_literal165);
            adaptor.addChild(root_0, char_literal165_tree);
            }
            pushFollow(FOLLOW_expression_in_objCMethodCall3262);
            target=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, target.getTree());
            methodName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodCall3266); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            methodName_tree = (Object)adaptor.create(methodName);
            adaptor.addChild(root_0, methodName_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.expr = new FunctionCall((methodName!=null?methodName.getText():null));
              			retval.expr.setTarget((target!=null?target.expr:null));
              			retval.expr.setMemberRefStyle(MemberRefStyle.SquareBrackets);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1098:3: ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==33) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1099:4: ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )*
                    {
                    char_literal166=(Token)match(input,33,FOLLOW_33_in_objCMethodCall3277); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal166_tree = (Object)adaptor.create(char_literal166);
                    adaptor.addChild(root_0, char_literal166_tree);
                    }
                    pushFollow(FOLLOW_expression_in_objCMethodCall3281);
                    arg1=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arg1.getTree());
                    if ( state.backtracking==0 ) {

                      				retval.expr.addArgument(null, (arg1!=null?arg1.expr:null));
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1102:4: (selx= IDENTIFIER ':' argx= expression )*
                    loop83:
                    do {
                        int alt83=2;
                        int LA83_0 = input.LA(1);

                        if ( (LA83_0==IDENTIFIER) ) {
                            alt83=1;
                        }


                        switch (alt83) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1103:5: selx= IDENTIFIER ':' argx= expression
                    	    {
                    	    selx=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodCall3296); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    selx_tree = (Object)adaptor.create(selx);
                    	    adaptor.addChild(root_0, selx_tree);
                    	    }
                    	    char_literal167=(Token)match(input,33,FOLLOW_33_in_objCMethodCall3298); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal167_tree = (Object)adaptor.create(char_literal167);
                    	    adaptor.addChild(root_0, char_literal167_tree);
                    	    }
                    	    pushFollow(FOLLOW_expression_in_objCMethodCall3302);
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
                    	    break loop83;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal168=(Token)match(input,54,FOLLOW_54_in_objCMethodCall3319); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal168_tree = (Object)adaptor.create(char_literal168);
            adaptor.addChild(root_0, char_literal168_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1111:1: functionCall returns [FunctionCall expr] : ( 'sizeof' '(' typeRef ')' | IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')' );
    public final ObjCppParser.functionCall_return functionCall() throws RecognitionException {
        ObjCppParser.functionCall_return retval = new ObjCppParser.functionCall_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal169=null;
        Token char_literal170=null;
        Token char_literal172=null;
        Token IDENTIFIER173=null;
        Token char_literal174=null;
        Token char_literal175=null;
        Token char_literal176=null;
        ObjCppParser.expression_return a1 = null;

        ObjCppParser.expression_return ax = null;

        ObjCppParser.typeRef_return typeRef171 = null;


        Object string_literal169_tree=null;
        Object char_literal170_tree=null;
        Object char_literal172_tree=null;
        Object IDENTIFIER173_tree=null;
        Object char_literal174_tree=null;
        Object char_literal175_tree=null;
        Object char_literal176_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1112:2: ( 'sizeof' '(' typeRef ')' | IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')' )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==74) ) {
                alt87=1;
            }
            else if ( (LA87_0==IDENTIFIER) ) {
                alt87=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1113:3: 'sizeof' '(' typeRef ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal169=(Token)match(input,74,FOLLOW_74_in_functionCall3339); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal169_tree = (Object)adaptor.create(string_literal169);
                    adaptor.addChild(root_0, string_literal169_tree);
                    }
                    char_literal170=(Token)match(input,34,FOLLOW_34_in_functionCall3341); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal170_tree = (Object)adaptor.create(char_literal170);
                    adaptor.addChild(root_0, char_literal170_tree);
                    }
                    pushFollow(FOLLOW_typeRef_in_functionCall3343);
                    typeRef171=typeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRef171.getTree());
                    char_literal172=(Token)match(input,35,FOLLOW_35_in_functionCall3345); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal172_tree = (Object)adaptor.create(char_literal172);
                    adaptor.addChild(root_0, char_literal172_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			retval.expr = new FunctionCall("sizeof");
                      			retval.expr.addArgument(new TypeRefExpression((typeRef171!=null?typeRef171.type:null)));
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1117:3: IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    IDENTIFIER173=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionCall3353); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER173_tree = (Object)adaptor.create(IDENTIFIER173);
                    adaptor.addChild(root_0, IDENTIFIER173_tree);
                    }
                    char_literal174=(Token)match(input,34,FOLLOW_34_in_functionCall3355); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal174_tree = (Object)adaptor.create(char_literal174);
                    adaptor.addChild(root_0, char_literal174_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			retval.expr = new FunctionCall((IDENTIFIER173!=null?IDENTIFIER173.getText():null));
                      		
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1120:3: (a1= expression ( ',' ax= expression )* )?
                    int alt86=2;
                    alt86 = dfa86.predict(input);
                    switch (alt86) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1121:4: a1= expression ( ',' ax= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_functionCall3368);
                            a1=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                            if ( state.backtracking==0 ) {

                              				retval.expr.addArgument((a1!=null?a1.expr:null));
                              			
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1124:4: ( ',' ax= expression )*
                            loop85:
                            do {
                                int alt85=2;
                                int LA85_0 = input.LA(1);

                                if ( (LA85_0==27) ) {
                                    alt85=1;
                                }


                                switch (alt85) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1124:6: ',' ax= expression
                            	    {
                            	    char_literal175=(Token)match(input,27,FOLLOW_27_in_functionCall3377); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    char_literal175_tree = (Object)adaptor.create(char_literal175);
                            	    adaptor.addChild(root_0, char_literal175_tree);
                            	    }
                            	    pushFollow(FOLLOW_expression_in_functionCall3386);
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
                            	    break loop85;
                                }
                            } while (true);


                            }
                            break;

                    }

                    char_literal176=(Token)match(input,35,FOLLOW_35_in_functionCall3404); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal176_tree = (Object)adaptor.create(char_literal176);
                    adaptor.addChild(root_0, char_literal176_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1133:1: expression returns [Expression expr] : (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' ) (bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )* ;
    public final ObjCppParser.expression_return expression() throws RecognitionException {
        ObjCppParser.expression_return retval = new ObjCppParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token id=null;
        Token prefixOp=null;
        Token bop=null;
        Token fieldName=null;
        Token refStyle=null;
        Token char_literal178=null;
        Token char_literal179=null;
        Token char_literal181=null;
        Token char_literal183=null;
        Token char_literal185=null;
        Token char_literal186=null;
        Token char_literal187=null;
        Token char_literal188=null;
        Token char_literal189=null;
        Token char_literal190=null;
        Token char_literal191=null;
        Token char_literal192=null;
        Token char_literal193=null;
        Token char_literal194=null;
        ObjCppParser.functionCall_return fc1 = null;

        ObjCppParser.expression_return opd = null;

        ObjCppParser.expression_return par = null;

        ObjCppParser.expression_return casted = null;

        ObjCppParser.expression_return opd2 = null;

        ObjCppParser.expression_return val = null;

        ObjCppParser.functionCall_return fc2 = null;

        ObjCppParser.expression_return xif = null;

        ObjCppParser.expression_return xelse = null;

        ObjCppParser.objCMethodCall_return objCMethodCall177 = null;

        ObjCppParser.typeRef_return typeRef180 = null;

        ObjCppParser.constant_return constant182 = null;

        ObjCppParser.expression_return expression184 = null;


        Object id_tree=null;
        Object prefixOp_tree=null;
        Object bop_tree=null;
        Object fieldName_tree=null;
        Object refStyle_tree=null;
        Object char_literal178_tree=null;
        Object char_literal179_tree=null;
        Object char_literal181_tree=null;
        Object char_literal183_tree=null;
        Object char_literal185_tree=null;
        Object char_literal186_tree=null;
        Object char_literal187_tree=null;
        Object char_literal188_tree=null;
        Object char_literal189_tree=null;
        Object char_literal190_tree=null;
        Object char_literal191_tree=null;
        Object char_literal192_tree=null;
        Object char_literal193_tree=null;
        Object char_literal194_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1134:2: ( (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' ) (bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1134:4: (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' ) (bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1134:4: (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' )
            int alt89=7;
            alt89 = dfa89.predict(input);
            switch (alt89) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1135:4: id= IDENTIFIER
                    {
                    id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression3426); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1138:4: fc1= functionCall
                    {
                    pushFollow(FOLLOW_functionCall_in_expression3437);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1141:4: objCMethodCall
                    {
                    pushFollow(FOLLOW_objCMethodCall_in_expression3446);
                    objCMethodCall177=objCMethodCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, objCMethodCall177.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				retval.expr = (objCMethodCall177!=null?objCMethodCall177.expr:null); 
                      							
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1144:4: prefixOp= ( '!' | '~' ) opd= expression
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

                    pushFollow(FOLLOW_expression_in_expression3467);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1147:4: '(' (par= expression ')' | typeRef ')' casted= expression )
                    {
                    char_literal178=(Token)match(input,34,FOLLOW_34_in_expression3476); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal178_tree = (Object)adaptor.create(char_literal178);
                    adaptor.addChild(root_0, char_literal178_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1147:8: (par= expression ')' | typeRef ')' casted= expression )
                    int alt88=2;
                    alt88 = dfa88.predict(input);
                    switch (alt88) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1148:5: par= expression ')'
                            {
                            pushFollow(FOLLOW_expression_in_expression3486);
                            par=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, par.getTree());
                            char_literal179=(Token)match(input,35,FOLLOW_35_in_expression3488); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal179_tree = (Object)adaptor.create(char_literal179);
                            adaptor.addChild(root_0, char_literal179_tree);
                            }
                            if ( state.backtracking==0 ) {

                              					retval.expr = (par!=null?par.expr:null);
                              					if (retval.expr != null)
                              						retval.expr.setParenthesis(true);
                              				
                            }

                            }
                            break;
                        case 2 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1153:5: typeRef ')' casted= expression
                            {
                            pushFollow(FOLLOW_typeRef_in_expression3498);
                            typeRef180=typeRef();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRef180.getTree());
                            char_literal181=(Token)match(input,35,FOLLOW_35_in_expression3500); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal181_tree = (Object)adaptor.create(char_literal181);
                            adaptor.addChild(root_0, char_literal181_tree);
                            }
                            pushFollow(FOLLOW_expression_in_expression3504);
                            casted=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, casted.getTree());
                            if ( state.backtracking==0 ) {

                              					retval.expr = new Cast((typeRef180!=null?typeRef180.type:null), (casted!=null?casted.expr:null));
                              				
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1157:4: constant
                    {
                    pushFollow(FOLLOW_constant_in_expression3519);
                    constant182=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant182.getTree());
                    if ( state.backtracking==0 ) {
                       retval.expr = (constant182!=null?constant182.constant:null); 
                    }

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1158:4: '{' expression '}'
                    {
                    char_literal183=(Token)match(input,23,FOLLOW_23_in_expression3528); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal183_tree = (Object)adaptor.create(char_literal183);
                    adaptor.addChild(root_0, char_literal183_tree);
                    }
                    pushFollow(FOLLOW_expression_in_expression3530);
                    expression184=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression184.getTree());
                    char_literal185=(Token)match(input,24,FOLLOW_24_in_expression3532); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal185_tree = (Object)adaptor.create(char_literal185);
                    adaptor.addChild(root_0, char_literal185_tree);
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1160:3: (bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )*
            loop91:
            do {
                int alt91=6;
                alt91 = dfa91.predict(input);
                switch (alt91) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1161:4: bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression
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

            	    pushFollow(FOLLOW_expression_in_expression3642);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1168:4: '=' val= expression
            	    {
            	    char_literal186=(Token)match(input,29,FOLLOW_29_in_expression3651); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal186_tree = (Object)adaptor.create(char_literal186);
            	    adaptor.addChild(root_0, char_literal186_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression3655);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1171:4: '.' fieldName= IDENTIFIER
            	    {
            	    char_literal187=(Token)match(input,89,FOLLOW_89_in_expression3664); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal187_tree = (Object)adaptor.create(char_literal187);
            	    adaptor.addChild(root_0, char_literal187_tree);
            	    }
            	    fieldName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression3668); if (state.failed) return retval;
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1174:4: refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1174:13: ( ':' ':' | '-' '>' | '.' )
            	    int alt90=3;
            	    switch ( input.LA(1) ) {
            	    case 33:
            	        {
            	        alt90=1;
            	        }
            	        break;
            	    case 43:
            	        {
            	        alt90=2;
            	        }
            	        break;
            	    case 89:
            	        {
            	        alt90=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 90, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt90) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1174:14: ':' ':'
            	            {
            	            char_literal188=(Token)match(input,33,FOLLOW_33_in_expression3680); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal188_tree = (Object)adaptor.create(char_literal188);
            	            adaptor.addChild(root_0, char_literal188_tree);
            	            }
            	            char_literal189=(Token)match(input,33,FOLLOW_33_in_expression3682); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal189_tree = (Object)adaptor.create(char_literal189);
            	            adaptor.addChild(root_0, char_literal189_tree);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1174:24: '-' '>'
            	            {
            	            char_literal190=(Token)match(input,43,FOLLOW_43_in_expression3686); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal190_tree = (Object)adaptor.create(char_literal190);
            	            adaptor.addChild(root_0, char_literal190_tree);
            	            }
            	            char_literal191=(Token)match(input,37,FOLLOW_37_in_expression3688); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal191_tree = (Object)adaptor.create(char_literal191);
            	            adaptor.addChild(root_0, char_literal191_tree);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1174:34: '.'
            	            {
            	            char_literal192=(Token)match(input,89,FOLLOW_89_in_expression3692); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal192_tree = (Object)adaptor.create(char_literal192);
            	            adaptor.addChild(root_0, char_literal192_tree);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_functionCall_in_expression3697);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1181:4: '?' xif= expression ':' xelse= expression
            	    {
            	    char_literal193=(Token)match(input,90,FOLLOW_90_in_expression3706); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal193_tree = (Object)adaptor.create(char_literal193);
            	    adaptor.addChild(root_0, char_literal193_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression3710);
            	    xif=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, xif.getTree());
            	    char_literal194=(Token)match(input,33,FOLLOW_33_in_expression3712); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal194_tree = (Object)adaptor.create(char_literal194);
            	    adaptor.addChild(root_0, char_literal194_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression3716);
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
    // $ANTLR end "expression"

    public static class statementsBlock_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statementsBlock"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1188:1: statementsBlock : '{' ( statement )* '}' ;
    public final ObjCppParser.statementsBlock_return statementsBlock() throws RecognitionException {
        ObjCppParser.statementsBlock_return retval = new ObjCppParser.statementsBlock_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal195=null;
        Token char_literal197=null;
        ObjCppParser.statement_return statement196 = null;


        Object char_literal195_tree=null;
        Object char_literal197_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1189:2: ( '{' ( statement )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1189:4: '{' ( statement )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal195=(Token)match(input,23,FOLLOW_23_in_statementsBlock3737); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal195_tree = (Object)adaptor.create(char_literal195);
            adaptor.addChild(root_0, char_literal195_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1189:8: ( statement )*
            loop92:
            do {
                int alt92=2;
                alt92 = dfa92.predict(input);
                switch (alt92) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_statementsBlock3739);
            	    statement196=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement196.getTree());

            	    }
            	    break;

            	default :
            	    break loop92;
                }
            } while (true);

            char_literal197=(Token)match(input,24,FOLLOW_24_in_statementsBlock3742); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal197_tree = (Object)adaptor.create(char_literal197);
            adaptor.addChild(root_0, char_literal197_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1191:1: statement : ( statementsBlock | declaration | expression ( '=' expression )? ';' | 'return' expression ';' | 'if' '(' expression ')' statement ( 'else' statement )? | 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement );
    public final ObjCppParser.statement_return statement() throws RecognitionException {
        ObjCppParser.statement_return retval = new ObjCppParser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal201=null;
        Token char_literal203=null;
        Token string_literal204=null;
        Token char_literal206=null;
        Token string_literal207=null;
        Token char_literal208=null;
        Token char_literal210=null;
        Token string_literal212=null;
        Token string_literal214=null;
        Token char_literal215=null;
        Token char_literal217=null;
        Token string_literal219=null;
        Token string_literal221=null;
        Token char_literal222=null;
        Token char_literal224=null;
        Token char_literal225=null;
        Token string_literal226=null;
        Token char_literal227=null;
        Token char_literal229=null;
        Token char_literal231=null;
        Token char_literal233=null;
        Token string_literal235=null;
        Token char_literal236=null;
        Token char_literal238=null;
        Token char_literal239=null;
        Token string_literal240=null;
        Token char_literal242=null;
        Token char_literal244=null;
        Token char_literal245=null;
        Token IDENTIFIER246=null;
        Token char_literal247=null;
        Token char_literal249=null;
        Token char_literal251=null;
        ObjCppParser.statementsBlock_return statementsBlock198 = null;

        ObjCppParser.declaration_return declaration199 = null;

        ObjCppParser.expression_return expression200 = null;

        ObjCppParser.expression_return expression202 = null;

        ObjCppParser.expression_return expression205 = null;

        ObjCppParser.expression_return expression209 = null;

        ObjCppParser.statement_return statement211 = null;

        ObjCppParser.statement_return statement213 = null;

        ObjCppParser.expression_return expression216 = null;

        ObjCppParser.statement_return statement218 = null;

        ObjCppParser.statement_return statement220 = null;

        ObjCppParser.expression_return expression223 = null;

        ObjCppParser.statement_return statement228 = null;

        ObjCppParser.expression_return expression230 = null;

        ObjCppParser.statement_return statement232 = null;

        ObjCppParser.statement_return statement234 = null;

        ObjCppParser.expression_return expression237 = null;

        ObjCppParser.expression_return expression241 = null;

        ObjCppParser.statement_return statement243 = null;

        ObjCppParser.varDecl_return varDecl248 = null;

        ObjCppParser.expression_return expression250 = null;

        ObjCppParser.statement_return statement252 = null;


        Object char_literal201_tree=null;
        Object char_literal203_tree=null;
        Object string_literal204_tree=null;
        Object char_literal206_tree=null;
        Object string_literal207_tree=null;
        Object char_literal208_tree=null;
        Object char_literal210_tree=null;
        Object string_literal212_tree=null;
        Object string_literal214_tree=null;
        Object char_literal215_tree=null;
        Object char_literal217_tree=null;
        Object string_literal219_tree=null;
        Object string_literal221_tree=null;
        Object char_literal222_tree=null;
        Object char_literal224_tree=null;
        Object char_literal225_tree=null;
        Object string_literal226_tree=null;
        Object char_literal227_tree=null;
        Object char_literal229_tree=null;
        Object char_literal231_tree=null;
        Object char_literal233_tree=null;
        Object string_literal235_tree=null;
        Object char_literal236_tree=null;
        Object char_literal238_tree=null;
        Object char_literal239_tree=null;
        Object string_literal240_tree=null;
        Object char_literal242_tree=null;
        Object char_literal244_tree=null;
        Object char_literal245_tree=null;
        Object IDENTIFIER246_tree=null;
        Object char_literal247_tree=null;
        Object char_literal249_tree=null;
        Object char_literal251_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1192:2: ( statementsBlock | declaration | expression ( '=' expression )? ';' | 'return' expression ';' | 'if' '(' expression ')' statement ( 'else' statement )? | 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement )
            int alt99=11;
            alt99 = dfa99.predict(input);
            switch (alt99) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1193:3: statementsBlock
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_statementsBlock_in_statement3755);
                    statementsBlock198=statementsBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementsBlock198.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1194:3: declaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_declaration_in_statement3761);
                    declaration199=declaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration199.getTree());

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1195:3: expression ( '=' expression )? ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_expression_in_statement3767);
                    expression200=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression200.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1195:14: ( '=' expression )?
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==29) ) {
                        alt93=1;
                    }
                    switch (alt93) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1195:15: '=' expression
                            {
                            char_literal201=(Token)match(input,29,FOLLOW_29_in_statement3770); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal201_tree = (Object)adaptor.create(char_literal201);
                            adaptor.addChild(root_0, char_literal201_tree);
                            }
                            pushFollow(FOLLOW_expression_in_statement3772);
                            expression202=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression202.getTree());

                            }
                            break;

                    }

                    char_literal203=(Token)match(input,28,FOLLOW_28_in_statement3777); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal203_tree = (Object)adaptor.create(char_literal203);
                    adaptor.addChild(root_0, char_literal203_tree);
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1196:3: 'return' expression ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal204=(Token)match(input,91,FOLLOW_91_in_statement3783); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal204_tree = (Object)adaptor.create(string_literal204);
                    adaptor.addChild(root_0, string_literal204_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3785);
                    expression205=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression205.getTree());
                    char_literal206=(Token)match(input,28,FOLLOW_28_in_statement3787); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal206_tree = (Object)adaptor.create(char_literal206);
                    adaptor.addChild(root_0, char_literal206_tree);
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1197:3: 'if' '(' expression ')' statement ( 'else' statement )?
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal207=(Token)match(input,92,FOLLOW_92_in_statement3793); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal207_tree = (Object)adaptor.create(string_literal207);
                    adaptor.addChild(root_0, string_literal207_tree);
                    }
                    char_literal208=(Token)match(input,34,FOLLOW_34_in_statement3795); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal208_tree = (Object)adaptor.create(char_literal208);
                    adaptor.addChild(root_0, char_literal208_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3797);
                    expression209=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression209.getTree());
                    char_literal210=(Token)match(input,35,FOLLOW_35_in_statement3799); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal210_tree = (Object)adaptor.create(char_literal210);
                    adaptor.addChild(root_0, char_literal210_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement3801);
                    statement211=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement211.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1197:37: ( 'else' statement )?
                    int alt94=2;
                    alt94 = dfa94.predict(input);
                    switch (alt94) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1197:38: 'else' statement
                            {
                            string_literal212=(Token)match(input,93,FOLLOW_93_in_statement3804); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal212_tree = (Object)adaptor.create(string_literal212);
                            adaptor.addChild(root_0, string_literal212_tree);
                            }
                            pushFollow(FOLLOW_statement_in_statement3806);
                            statement213=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement213.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1198:3: 'while' '(' expression ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal214=(Token)match(input,94,FOLLOW_94_in_statement3814); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal214_tree = (Object)adaptor.create(string_literal214);
                    adaptor.addChild(root_0, string_literal214_tree);
                    }
                    char_literal215=(Token)match(input,34,FOLLOW_34_in_statement3816); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal215_tree = (Object)adaptor.create(char_literal215);
                    adaptor.addChild(root_0, char_literal215_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3818);
                    expression216=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression216.getTree());
                    char_literal217=(Token)match(input,35,FOLLOW_35_in_statement3820); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal217_tree = (Object)adaptor.create(char_literal217);
                    adaptor.addChild(root_0, char_literal217_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement3822);
                    statement218=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement218.getTree());

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1199:3: 'do' statement 'while' '(' expression ')' ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal219=(Token)match(input,95,FOLLOW_95_in_statement3828); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal219_tree = (Object)adaptor.create(string_literal219);
                    adaptor.addChild(root_0, string_literal219_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement3830);
                    statement220=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement220.getTree());
                    string_literal221=(Token)match(input,94,FOLLOW_94_in_statement3832); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal221_tree = (Object)adaptor.create(string_literal221);
                    adaptor.addChild(root_0, string_literal221_tree);
                    }
                    char_literal222=(Token)match(input,34,FOLLOW_34_in_statement3834); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal222_tree = (Object)adaptor.create(char_literal222);
                    adaptor.addChild(root_0, char_literal222_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3836);
                    expression223=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression223.getTree());
                    char_literal224=(Token)match(input,35,FOLLOW_35_in_statement3838); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal224_tree = (Object)adaptor.create(char_literal224);
                    adaptor.addChild(root_0, char_literal224_tree);
                    }
                    char_literal225=(Token)match(input,28,FOLLOW_28_in_statement3840); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal225_tree = (Object)adaptor.create(char_literal225);
                    adaptor.addChild(root_0, char_literal225_tree);
                    }

                    }
                    break;
                case 8 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1200:3: 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal226=(Token)match(input,96,FOLLOW_96_in_statement3846); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal226_tree = (Object)adaptor.create(string_literal226);
                    adaptor.addChild(root_0, string_literal226_tree);
                    }
                    char_literal227=(Token)match(input,34,FOLLOW_34_in_statement3848); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal227_tree = (Object)adaptor.create(char_literal227);
                    adaptor.addChild(root_0, char_literal227_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1200:13: ( statement )?
                    int alt95=2;
                    alt95 = dfa95.predict(input);
                    switch (alt95) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: statement
                            {
                            pushFollow(FOLLOW_statement_in_statement3850);
                            statement228=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement228.getTree());

                            }
                            break;

                    }

                    char_literal229=(Token)match(input,28,FOLLOW_28_in_statement3853); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal229_tree = (Object)adaptor.create(char_literal229);
                    adaptor.addChild(root_0, char_literal229_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1200:28: ( expression )?
                    int alt96=2;
                    alt96 = dfa96.predict(input);
                    switch (alt96) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement3855);
                            expression230=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression230.getTree());

                            }
                            break;

                    }

                    char_literal231=(Token)match(input,28,FOLLOW_28_in_statement3858); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal231_tree = (Object)adaptor.create(char_literal231);
                    adaptor.addChild(root_0, char_literal231_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1200:44: ( statement )?
                    int alt97=2;
                    alt97 = dfa97.predict(input);
                    switch (alt97) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: statement
                            {
                            pushFollow(FOLLOW_statement_in_statement3860);
                            statement232=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement232.getTree());

                            }
                            break;

                    }

                    char_literal233=(Token)match(input,35,FOLLOW_35_in_statement3863); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal233_tree = (Object)adaptor.create(char_literal233);
                    adaptor.addChild(root_0, char_literal233_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement3865);
                    statement234=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement234.getTree());

                    }
                    break;
                case 9 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1201:3: 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal235=(Token)match(input,97,FOLLOW_97_in_statement3871); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal235_tree = (Object)adaptor.create(string_literal235);
                    adaptor.addChild(root_0, string_literal235_tree);
                    }
                    char_literal236=(Token)match(input,34,FOLLOW_34_in_statement3873); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal236_tree = (Object)adaptor.create(char_literal236);
                    adaptor.addChild(root_0, char_literal236_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3875);
                    expression237=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression237.getTree());
                    char_literal238=(Token)match(input,35,FOLLOW_35_in_statement3877); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal238_tree = (Object)adaptor.create(char_literal238);
                    adaptor.addChild(root_0, char_literal238_tree);
                    }
                    char_literal239=(Token)match(input,23,FOLLOW_23_in_statement3879); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal239_tree = (Object)adaptor.create(char_literal239);
                    adaptor.addChild(root_0, char_literal239_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1202:3: ( 'case' expression ':' | statement )*
                    loop98:
                    do {
                        int alt98=3;
                        alt98 = dfa98.predict(input);
                        switch (alt98) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1202:5: 'case' expression ':'
                    	    {
                    	    string_literal240=(Token)match(input,98,FOLLOW_98_in_statement3885); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    string_literal240_tree = (Object)adaptor.create(string_literal240);
                    	    adaptor.addChild(root_0, string_literal240_tree);
                    	    }
                    	    pushFollow(FOLLOW_expression_in_statement3887);
                    	    expression241=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression241.getTree());
                    	    char_literal242=(Token)match(input,33,FOLLOW_33_in_statement3889); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal242_tree = (Object)adaptor.create(char_literal242);
                    	    adaptor.addChild(root_0, char_literal242_tree);
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1203:4: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement3896);
                    	    statement243=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement243.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop98;
                        }
                    } while (true);

                    char_literal244=(Token)match(input,24,FOLLOW_24_in_statement3905); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal244_tree = (Object)adaptor.create(char_literal244);
                    adaptor.addChild(root_0, char_literal244_tree);
                    }

                    }
                    break;
                case 10 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1206:3: ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal245=(Token)match(input,28,FOLLOW_28_in_statement3911); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal245_tree = (Object)adaptor.create(char_literal245);
                    adaptor.addChild(root_0, char_literal245_tree);
                    }

                    }
                    break;
                case 11 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1207:3: {...}? IDENTIFIER '(' varDecl ':' expression ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !(( next("foreach") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "statement", " next(\"foreach\") ");
                    }
                    IDENTIFIER246=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement3919); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER246_tree = (Object)adaptor.create(IDENTIFIER246);
                    adaptor.addChild(root_0, IDENTIFIER246_tree);
                    }
                    char_literal247=(Token)match(input,34,FOLLOW_34_in_statement3921); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal247_tree = (Object)adaptor.create(char_literal247);
                    adaptor.addChild(root_0, char_literal247_tree);
                    }
                    pushFollow(FOLLOW_varDecl_in_statement3923);
                    varDecl248=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl248.getTree());
                    char_literal249=(Token)match(input,33,FOLLOW_33_in_statement3925); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal249_tree = (Object)adaptor.create(char_literal249);
                    adaptor.addChild(root_0, char_literal249_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3927);
                    expression250=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression250.getTree());
                    char_literal251=(Token)match(input,35,FOLLOW_35_in_statement3929); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal251_tree = (Object)adaptor.create(char_literal251);
                    adaptor.addChild(root_0, char_literal251_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement3931);
                    statement252=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement252.getTree());

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1210:1: constant returns [Constant constant] : ( DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER | CHARACTER | FLOAT_NUMBER | STRING );
    public final ObjCppParser.constant_return constant() throws RecognitionException {
        ObjCppParser.constant_return retval = new ObjCppParser.constant_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DECIMAL_NUMBER253=null;
        Token HEXADECIMAL_NUMBER254=null;
        Token OCTAL_NUMBER255=null;
        Token CHARACTER256=null;
        Token FLOAT_NUMBER257=null;
        Token STRING258=null;

        Object DECIMAL_NUMBER253_tree=null;
        Object HEXADECIMAL_NUMBER254_tree=null;
        Object OCTAL_NUMBER255_tree=null;
        Object CHARACTER256_tree=null;
        Object FLOAT_NUMBER257_tree=null;
        Object STRING258_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1211:2: ( DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER | CHARACTER | FLOAT_NUMBER | STRING )
            int alt100=6;
            switch ( input.LA(1) ) {
            case DECIMAL_NUMBER:
                {
                alt100=1;
                }
                break;
            case HEXADECIMAL_NUMBER:
                {
                alt100=2;
                }
                break;
            case OCTAL_NUMBER:
                {
                alt100=3;
                }
                break;
            case CHARACTER:
                {
                alt100=4;
                }
                break;
            case FLOAT_NUMBER:
                {
                alt100=5;
                }
                break;
            case STRING:
                {
                alt100=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;
            }

            switch (alt100) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1211:4: DECIMAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    DECIMAL_NUMBER253=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_constant3947); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DECIMAL_NUMBER253_tree = (Object)adaptor.create(DECIMAL_NUMBER253);
                    adaptor.addChild(root_0, DECIMAL_NUMBER253_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant =  Constant.parseDecimal((DECIMAL_NUMBER253!=null?DECIMAL_NUMBER253.getText():null)); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1212:3: HEXADECIMAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    HEXADECIMAL_NUMBER254=(Token)match(input,HEXADECIMAL_NUMBER,FOLLOW_HEXADECIMAL_NUMBER_in_constant3955); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    HEXADECIMAL_NUMBER254_tree = (Object)adaptor.create(HEXADECIMAL_NUMBER254);
                    adaptor.addChild(root_0, HEXADECIMAL_NUMBER254_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant = Constant.parseHex((HEXADECIMAL_NUMBER254!=null?HEXADECIMAL_NUMBER254.getText():null)); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1213:3: OCTAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    OCTAL_NUMBER255=(Token)match(input,OCTAL_NUMBER,FOLLOW_OCTAL_NUMBER_in_constant3963); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OCTAL_NUMBER255_tree = (Object)adaptor.create(OCTAL_NUMBER255);
                    adaptor.addChild(root_0, OCTAL_NUMBER255_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant = Constant.parseOctal((OCTAL_NUMBER255!=null?OCTAL_NUMBER255.getText():null)); 
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1214:3: CHARACTER
                    {
                    root_0 = (Object)adaptor.nil();

                    CHARACTER256=(Token)match(input,CHARACTER,FOLLOW_CHARACTER_in_constant3971); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARACTER256_tree = (Object)adaptor.create(CHARACTER256);
                    adaptor.addChild(root_0, CHARACTER256_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant =  Constant.parseCharOrStringInteger((CHARACTER256!=null?CHARACTER256.getText():null)); 
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1215:3: FLOAT_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    FLOAT_NUMBER257=(Token)match(input,FLOAT_NUMBER,FOLLOW_FLOAT_NUMBER_in_constant3979); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT_NUMBER257_tree = (Object)adaptor.create(FLOAT_NUMBER257);
                    adaptor.addChild(root_0, FLOAT_NUMBER257_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant = Constant.parseFloat((FLOAT_NUMBER257!=null?FLOAT_NUMBER257.getText():null)); 
                    }

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1217:3: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING258=(Token)match(input,STRING,FOLLOW_STRING_in_constant3990); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING258_tree = (Object)adaptor.create(STRING258);
                    adaptor.addChild(root_0, STRING258_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant =  Constant.parseString((STRING258!=null?STRING258.getText():null)); 
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
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:243:5: ( functionDeclaration )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:243:5: functionDeclaration
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
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:246:5: ( varDecl )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:246:5: varDecl
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


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:384:7: (fv= varDecl )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:384:7: fv= varDecl
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

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:488:4: ( (n0= IDENTIFIER ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:488:4: (n0= IDENTIFIER )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:488:4: (n0= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:489:5: n0= IDENTIFIER
        {
        n0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred40_ObjCpp1113); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred40_ObjCpp

    // $ANTLR start synpred41_ObjCpp
    public final void synpred41_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:495:7: ( exportationModifiers )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:495:7: exportationModifiers
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


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:525:16: (returnTypeRef= typeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:525:16: returnTypeRef= typeRef
        {
        pushFollow(FOLLOW_typeRef_in_synpred47_ObjCpp1277);
        returnTypeRef=typeRef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_ObjCpp

    // $ANTLR start synpred48_ObjCpp
    public final void synpred48_ObjCpp_fragment() throws RecognitionException {   
        Token ct=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:541:35: (ct= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:541:35: ct= IDENTIFIER
        {
        ct=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred48_ObjCpp1322); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_ObjCpp

    // $ANTLR start synpred50_ObjCpp
    public final void synpred50_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:564:4: ( exportationModifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:564:4: exportationModifier
        {
        pushFollow(FOLLOW_exportationModifier_in_synpred50_ObjCpp1398);
        exportationModifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_ObjCpp

    // $ANTLR start synpred59_ObjCpp
    public final void synpred59_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return m = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:690:5: ({...}?m= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:690:5: {...}?m= modifier
        {
        if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred59_ObjCpp", " next(Modifier.Kind.TypeQualifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred59_ObjCpp1712);
        m=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_ObjCpp

    // $ANTLR start synpred60_ObjCpp
    public final void synpred60_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return m1 = null;

        ObjCppParser.typeRef_return tr = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:692:4: ({...}?m1= modifier tr= typeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:692:4: {...}?m1= modifier tr= typeRef
        {
        if ( !(( next(Modifier.Kind.ReferenceQualifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred60_ObjCpp", " next(Modifier.Kind.ReferenceQualifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred60_ObjCpp1729);
        m1=modifier();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_typeRef_in_synpred60_ObjCpp1738);
        tr=typeRef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred60_ObjCpp

    // $ANTLR start synpred77_ObjCpp
    public final void synpred77_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:774:4: ( ( typeMutator )* functionSignatureSuffix )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:774:4: ( typeMutator )* functionSignatureSuffix
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:774:4: ( typeMutator )*
        loop121:
        do {
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==IDENTIFIER||(LA121_0>=51 && LA121_0<=53)) ) {
                alt121=1;
            }


            switch (alt121) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:775:5: typeMutator
        	    {
        	    pushFollow(FOLLOW_typeMutator_in_synpred77_ObjCpp2184);
        	    typeMutator();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop121;
            }
        } while (true);

        pushFollow(FOLLOW_functionSignatureSuffix_in_synpred77_ObjCpp2197);
        functionSignatureSuffix();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred77_ObjCpp

    // $ANTLR start synpred79_ObjCpp
    public final void synpred79_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:789:4: ( ( typeMutator )* functionSignatureSuffixNoName )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:789:4: ( typeMutator )* functionSignatureSuffixNoName
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:789:4: ( typeMutator )*
        loop122:
        do {
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==IDENTIFIER||(LA122_0>=51 && LA122_0<=53)) ) {
                alt122=1;
            }


            switch (alt122) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:790:5: typeMutator
        	    {
        	    pushFollow(FOLLOW_typeMutator_in_synpred79_ObjCpp2238);
        	    typeMutator();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop122;
            }
        } while (true);

        pushFollow(FOLLOW_functionSignatureSuffixNoName_in_synpred79_ObjCpp2251);
        functionSignatureSuffixNoName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred79_ObjCpp

    // $ANTLR start synpred81_ObjCpp
    public final void synpred81_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:810:4: ({...}? modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:810:4: {...}? modifier
        {
        if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred81_ObjCpp", " next(Modifier.Kind.TypeQualifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred81_ObjCpp2315);
        modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred81_ObjCpp

    // $ANTLR start synpred85_ObjCpp
    public final void synpred85_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:830:5: ( '=' expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:830:5: '=' expression
        {
        match(input,29,FOLLOW_29_in_synpred85_ObjCpp2406); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred85_ObjCpp2413);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred85_ObjCpp

    // $ANTLR start synpred87_ObjCpp
    public final void synpred87_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return sm = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:871:4: ({...}?sm= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:871:4: {...}?sm= modifier
        {
        if ( !(( next(Modifier.Kind.StorageClassSpecifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred87_ObjCpp", " next(Modifier.Kind.StorageClassSpecifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred87_ObjCpp2541);
        sm=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred87_ObjCpp

    // $ANTLR start synpred88_ObjCpp
    public final void synpred88_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return tm = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:873:4: ({...}?tm= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:873:4: {...}?tm= modifier
        {
        if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred88_ObjCpp", " next(Modifier.Kind.TypeQualifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred88_ObjCpp2558);
        tm=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred88_ObjCpp

    // $ANTLR start synpred94_ObjCpp
    public final void synpred94_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return im = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:959:5: (im= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:959:5: im= modifier
        {
        pushFollow(FOLLOW_modifier_in_synpred94_ObjCpp2825);
        im=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred94_ObjCpp

    // $ANTLR start synpred98_ObjCpp
    public final void synpred98_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.argDef_return ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:997:5: ( ',' ax= argDef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:997:5: ',' ax= argDef
        {
        match(input,27,FOLLOW_27_in_synpred98_ObjCpp2943); if (state.failed) return ;
        pushFollow(FOLLOW_argDef_in_synpred98_ObjCpp2952);
        ax=argDef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred98_ObjCpp

    // $ANTLR start synpred101_ObjCpp
    public final void synpred101_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1018:4: ( typeMutator )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1018:4: typeMutator
        {
        pushFollow(FOLLOW_typeMutator_in_synpred101_ObjCpp3019);
        typeMutator();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred101_ObjCpp

    // $ANTLR start synpred129_ObjCpp
    public final void synpred129_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.expression_return par = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1148:5: (par= expression ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1148:5: par= expression ')'
        {
        pushFollow(FOLLOW_expression_in_synpred129_ObjCpp3486);
        par=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred129_ObjCpp3488); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred129_ObjCpp

    // $ANTLR start synpred150_ObjCpp
    public final void synpred150_ObjCpp_fragment() throws RecognitionException {   
        Token bop=null;
        ObjCppParser.expression_return opd2 = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1161:4: (bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1161:4: bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression
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

        pushFollow(FOLLOW_expression_in_synpred150_ObjCpp3642);
        opd2=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred150_ObjCpp

    // $ANTLR start synpred151_ObjCpp
    public final void synpred151_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.expression_return val = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1168:4: ( '=' val= expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1168:4: '=' val= expression
        {
        match(input,29,FOLLOW_29_in_synpred151_ObjCpp3651); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred151_ObjCpp3655);
        val=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred151_ObjCpp

    // $ANTLR start synpred152_ObjCpp
    public final void synpred152_ObjCpp_fragment() throws RecognitionException {   
        Token fieldName=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1171:4: ( '.' fieldName= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1171:4: '.' fieldName= IDENTIFIER
        {
        match(input,89,FOLLOW_89_in_synpred152_ObjCpp3664); if (state.failed) return ;
        fieldName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred152_ObjCpp3668); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred152_ObjCpp

    // $ANTLR start synpred155_ObjCpp
    public final void synpred155_ObjCpp_fragment() throws RecognitionException {   
        Token refStyle=null;
        ObjCppParser.functionCall_return fc2 = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1174:4: (refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1174:4: refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1174:13: ( ':' ':' | '-' '>' | '.' )
        int alt131=3;
        switch ( input.LA(1) ) {
        case 33:
            {
            alt131=1;
            }
            break;
        case 43:
            {
            alt131=2;
            }
            break;
        case 89:
            {
            alt131=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 131, 0, input);

            throw nvae;
        }

        switch (alt131) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1174:14: ':' ':'
                {
                match(input,33,FOLLOW_33_in_synpred155_ObjCpp3680); if (state.failed) return ;
                match(input,33,FOLLOW_33_in_synpred155_ObjCpp3682); if (state.failed) return ;

                }
                break;
            case 2 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1174:24: '-' '>'
                {
                match(input,43,FOLLOW_43_in_synpred155_ObjCpp3686); if (state.failed) return ;
                match(input,37,FOLLOW_37_in_synpred155_ObjCpp3688); if (state.failed) return ;

                }
                break;
            case 3 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1174:34: '.'
                {
                match(input,89,FOLLOW_89_in_synpred155_ObjCpp3692); if (state.failed) return ;

                }
                break;

        }

        pushFollow(FOLLOW_functionCall_in_synpred155_ObjCpp3697);
        fc2=functionCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred155_ObjCpp

    // $ANTLR start synpred156_ObjCpp
    public final void synpred156_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.expression_return xif = null;

        ObjCppParser.expression_return xelse = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1181:4: ( '?' xif= expression ':' xelse= expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1181:4: '?' xif= expression ':' xelse= expression
        {
        match(input,90,FOLLOW_90_in_synpred156_ObjCpp3706); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred156_ObjCpp3710);
        xif=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,33,FOLLOW_33_in_synpred156_ObjCpp3712); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred156_ObjCpp3716);
        xelse=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred156_ObjCpp

    // $ANTLR start synpred158_ObjCpp
    public final void synpred158_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1193:3: ( statementsBlock )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1193:3: statementsBlock
        {
        pushFollow(FOLLOW_statementsBlock_in_synpred158_ObjCpp3755);
        statementsBlock();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred158_ObjCpp

    // $ANTLR start synpred159_ObjCpp
    public final void synpred159_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1194:3: ( declaration )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1194:3: declaration
        {
        pushFollow(FOLLOW_declaration_in_synpred159_ObjCpp3761);
        declaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred159_ObjCpp

    // $ANTLR start synpred161_ObjCpp
    public final void synpred161_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1195:3: ( expression ( '=' expression )? ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1195:3: expression ( '=' expression )? ';'
        {
        pushFollow(FOLLOW_expression_in_synpred161_ObjCpp3767);
        expression();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1195:14: ( '=' expression )?
        int alt132=2;
        int LA132_0 = input.LA(1);

        if ( (LA132_0==29) ) {
            alt132=1;
        }
        switch (alt132) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1195:15: '=' expression
                {
                match(input,29,FOLLOW_29_in_synpred161_ObjCpp3770); if (state.failed) return ;
                pushFollow(FOLLOW_expression_in_synpred161_ObjCpp3772);
                expression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }

        match(input,28,FOLLOW_28_in_synpred161_ObjCpp3777); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred161_ObjCpp

    // $ANTLR start synpred163_ObjCpp
    public final void synpred163_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1197:38: ( 'else' statement )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1197:38: 'else' statement
        {
        match(input,93,FOLLOW_93_in_synpred163_ObjCpp3804); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred163_ObjCpp3806);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred163_ObjCpp

    // $ANTLR start synpred167_ObjCpp
    public final void synpred167_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1200:13: ( statement )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1200:13: statement
        {
        pushFollow(FOLLOW_statement_in_synpred167_ObjCpp3850);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred167_ObjCpp

    // Delegated rules

    public final boolean synpred79_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred79_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred150_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred150_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred158_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred158_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred129_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred129_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred87_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred101_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred101_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred161_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred161_ObjCpp_fragment(); // can never throw exception
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
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA47 dfa47 = new DFA47(this);
    protected DFA45 dfa45 = new DFA45(this);
    protected DFA59 dfa59 = new DFA59(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA63 dfa63 = new DFA63(this);
    protected DFA65 dfa65 = new DFA65(this);
    protected DFA67 dfa67 = new DFA67(this);
    protected DFA72 dfa72 = new DFA72(this);
    protected DFA74 dfa74 = new DFA74(this);
    protected DFA76 dfa76 = new DFA76(this);
    protected DFA79 dfa79 = new DFA79(this);
    protected DFA82 dfa82 = new DFA82(this);
    protected DFA81 dfa81 = new DFA81(this);
    protected DFA86 dfa86 = new DFA86(this);
    protected DFA89 dfa89 = new DFA89(this);
    protected DFA88 dfa88 = new DFA88(this);
    protected DFA91 dfa91 = new DFA91(this);
    protected DFA92 dfa92 = new DFA92(this);
    protected DFA99 dfa99 = new DFA99(this);
    protected DFA94 dfa94 = new DFA94(this);
    protected DFA95 dfa95 = new DFA95(this);
    protected DFA96 dfa96 = new DFA96(this);
    protected DFA97 dfa97 = new DFA97(this);
    protected DFA98 dfa98 = new DFA98(this);
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
            return "187:3: (unescapedString= STRING )?";
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
            return "198:8: (depth= DECIMAL_NUMBER )?";
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
            return "()* loopback of 204:3: ( declaration | lineDirective )*";
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
            return "()* loopback of 219:4: (ed= declaration )*";
        }
    }
    static final String DFA6_eotS =
        "\u00d2\uffff";
    static final String DFA6_eofS =
        "\u00d2\uffff";
    static final String DFA6_minS =
        "\4\6\1\77\2\6\4\uffff\2\6\1\27\4\6\1\66\1\6\1\uffff\1\6\1\77\11"+
        "\6\1\66\1\6\1\uffff\5\6\1\66\1\6\1\uffff\4\0\1\uffff\1\0\2\uffff"+
        "\27\0\1\uffff\4\0\3\uffff\4\0\1\uffff\6\0\1\uffff\2\0\7\uffff\1"+
        "\0\2\uffff\16\0\1\uffff\7\0\1\uffff\11\0\1\uffff\7\0\1\uffff\3\0"+
        "\5\uffff\4\0\1\uffff\6\0\1\uffff\3\0\2\uffff\5\0\1\uffff\6\0\1\uffff"+
        "\3\0\5\uffff\4\0\1\uffff\6\0\1\uffff\3\0\2\uffff";
    static final String DFA6_maxS =
        "\1\111\2\27\3\111\1\71\4\uffff\1\71\1\111\1\27\1\6\1\111\2\71\1"+
        "\66\1\111\1\uffff\3\111\1\71\2\27\1\111\4\71\1\66\1\71\1\uffff\1"+
        "\111\4\71\1\66\1\71\1\uffff\4\0\1\uffff\1\0\2\uffff\27\0\1\uffff"+
        "\4\0\3\uffff\4\0\1\uffff\6\0\1\uffff\2\0\7\uffff\1\0\2\uffff\16"+
        "\0\1\uffff\7\0\1\uffff\11\0\1\uffff\7\0\1\uffff\3\0\5\uffff\4\0"+
        "\1\uffff\6\0\1\uffff\3\0\2\uffff\5\0\1\uffff\6\0\1\uffff\3\0\5\uffff"+
        "\4\0\1\uffff\6\0\1\uffff\3\0\2\uffff";
    static final String DFA6_acceptS =
        "\7\uffff\1\3\1\4\1\5\1\6\11\uffff\1\2\32\uffff\1\1\u00a2\uffff";
    static final String DFA6_specialS =
        "\53\uffff\1\0\1\1\1\2\1\3\1\uffff\1\4\2\uffff\1\5\1\6\1\7\1\10\1"+
        "\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
        "\1\26\1\27\1\30\1\31\1\32\1\33\1\uffff\1\34\1\35\1\36\1\37\3\uffff"+
        "\1\40\1\41\1\42\1\43\1\uffff\1\44\1\45\1\46\1\47\1\50\1\51\1\uffff"+
        "\1\52\1\53\7\uffff\1\54\2\uffff\1\55\1\56\1\57\1\60\1\61\1\62\1"+
        "\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\uffff\1\73\1\74\1\75\1"+
        "\76\1\77\1\100\1\101\1\uffff\1\102\1\103\1\104\1\105\1\106\1\107"+
        "\1\110\1\111\1\112\1\uffff\1\113\1\114\1\115\1\116\1\117\1\120\1"+
        "\121\1\uffff\1\122\1\123\1\124\5\uffff\1\125\1\126\1\127\1\130\1"+
        "\uffff\1\131\1\132\1\133\1\134\1\135\1\136\1\uffff\1\137\1\140\1"+
        "\141\2\uffff\1\142\1\143\1\144\1\145\1\146\1\uffff\1\147\1\150\1"+
        "\151\1\152\1\153\1\154\1\uffff\1\155\1\156\1\157\5\uffff\1\160\1"+
        "\161\1\162\1\163\1\uffff\1\164\1\165\1\166\1\167\1\170\1\171\1\uffff"+
        "\1\172\1\173\1\174\2\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\3\22\uffff\1\12\1\11\3\uffff\1\2\2\7\14\uffff\3\1\12\uffff"+
            "\1\10\4\4\2\5\11\6",
            "\1\13\20\uffff\1\14",
            "\1\15\20\uffff\1\16",
            "\1\17\27\uffff\1\32\3\uffff\1\23\1\uffff\1\25\10\uffff\3\31"+
            "\3\uffff\1\20\1\21\1\22\3\uffff\1\24\1\uffff\4\26\2\27\11\30",
            "\2\33\11\34",
            "\1\35\33\uffff\1\41\20\uffff\1\36\1\37\1\40\3\uffff\1\24\5"+
            "\uffff\2\43\11\44",
            "\1\45\33\uffff\1\51\20\uffff\1\46\1\47\1\50\3\uffff\1\24",
            "",
            "",
            "",
            "",
            "\1\54\20\uffff\1\60\4\uffff\1\24\5\uffff\1\53\20\uffff\1\55"+
            "\1\56\1\57\3\uffff\1\24",
            "\1\70\21\uffff\1\100\1\77\1\76\3\uffff\1\67\2\74\14\uffff\3"+
            "\66\1\63\1\64\1\65\7\uffff\1\75\4\71\2\72\11\73",
            "\1\101",
            "\1\102",
            "\1\104\24\uffff\3\24\1\116\3\uffff\1\111\1\uffff\1\114\10\uffff"+
            "\3\115\3\uffff\1\103\1\110\1\113\3\uffff\1\24\1\uffff\4\105"+
            "\2\106\11\107",
            "\1\122\33\uffff\1\127\20\uffff\1\123\1\124\1\125\3\uffff\1"+
            "\24",
            "\1\131\33\uffff\1\130\20\uffff\1\132\1\133\1\134\3\uffff\1"+
            "\24",
            "\1\136",
            "\1\137\27\uffff\1\57\3\uffff\1\24\1\57\10\uffff\4\57\3\uffff"+
            "\1\147\1\24\4\uffff\1\24\1\uffff\17\57",
            "",
            "\1\154\27\uffff\1\153\6\uffff\1\160\7\uffff\3\152\13\uffff"+
            "\4\155\2\156\11\157",
            "\2\161\11\162",
            "\1\163\33\uffff\1\167\20\uffff\1\164\1\165\1\166\3\uffff\1"+
            "\24\5\uffff\2\171\11\172",
            "\1\173\33\uffff\1\177\20\uffff\1\174\1\175\1\176\3\uffff\1"+
            "\24",
            "\1\u0081\20\uffff\1\u0082",
            "\1\u0083\20\uffff\1\u0084",
            "\1\u0085\33\uffff\1\u0089\20\uffff\1\u0086\1\u0087\1\u0088"+
            "\3\uffff\1\24\5\uffff\2\u008b\11\u008c",
            "\1\u008d\33\uffff\1\u0091\20\uffff\1\u008e\1\u008f\1\u0090"+
            "\3\uffff\1\24",
            "\1\u0094\24\uffff\3\24\4\uffff\1\u0095\20\uffff\1\u0093\2\24"+
            "\3\uffff\1\24",
            "\1\u009b\33\uffff\1\u00a0\20\uffff\1\u009c\1\u009d\1\u009e"+
            "\3\uffff\1\24",
            "\1\u00a2\33\uffff\1\u00a1\20\uffff\1\u00a3\1\u00a4\1\u00a5"+
            "\3\uffff\1\24",
            "\1\u00a7",
            "\1\u00a8\33\uffff\1\24\20\uffff\1\u00a9\1\24\4\uffff\1\24",
            "",
            "\1\u00ac\33\uffff\1\u00b0\20\uffff\1\u00ad\1\u00ae\1\u00af"+
            "\3\uffff\1\24\5\uffff\13\u00b2",
            "\1\u00b3\33\uffff\1\u00b7\20\uffff\1\u00b4\1\u00b5\1\u00b6"+
            "\3\uffff\1\24",
            "\1\u00ba\24\uffff\3\24\4\uffff\1\u00bb\20\uffff\1\u00b9\2\24"+
            "\3\uffff\1\24",
            "\1\u00c1\33\uffff\1\u00c6\20\uffff\1\u00c2\1\u00c3\1\u00c4"+
            "\3\uffff\1\24",
            "\1\u00c8\33\uffff\1\u00c7\20\uffff\1\u00c9\1\u00ca\1\u00cb"+
            "\3\uffff\1\24",
            "\1\u00cd",
            "\1\u00ce\33\uffff\1\24\20\uffff\1\u00cf\1\24\4\uffff\1\24",
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
            "",
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
            return "241:4: ( functionDeclaration | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )";
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
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_43);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_44 = input.LA(1);

                         
                        int index6_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_44);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA6_45 = input.LA(1);

                         
                        int index6_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_45);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA6_46 = input.LA(1);

                         
                        int index6_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_46);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA6_48 = input.LA(1);

                         
                        int index6_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_48);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA6_51 = input.LA(1);

                         
                        int index6_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_51);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA6_52 = input.LA(1);

                         
                        int index6_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_52);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA6_53 = input.LA(1);

                         
                        int index6_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_53);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA6_54 = input.LA(1);

                         
                        int index6_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_54);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA6_55 = input.LA(1);

                         
                        int index6_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_55);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA6_56 = input.LA(1);

                         
                        int index6_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_56);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA6_57 = input.LA(1);

                         
                        int index6_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_57);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA6_58 = input.LA(1);

                         
                        int index6_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_58);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA6_59 = input.LA(1);

                         
                        int index6_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_59);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA6_60 = input.LA(1);

                         
                        int index6_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_60);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA6_61 = input.LA(1);

                         
                        int index6_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_61);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA6_62 = input.LA(1);

                         
                        int index6_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_62);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA6_63 = input.LA(1);

                         
                        int index6_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_63);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA6_64 = input.LA(1);

                         
                        int index6_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_64);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA6_65 = input.LA(1);

                         
                        int index6_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_65);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA6_66 = input.LA(1);

                         
                        int index6_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_66);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA6_67 = input.LA(1);

                         
                        int index6_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_67);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA6_68 = input.LA(1);

                         
                        int index6_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_68);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA6_69 = input.LA(1);

                         
                        int index6_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_69);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA6_70 = input.LA(1);

                         
                        int index6_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_70);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA6_71 = input.LA(1);

                         
                        int index6_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_71);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA6_72 = input.LA(1);

                         
                        int index6_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_72);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA6_73 = input.LA(1);

                         
                        int index6_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_73);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA6_75 = input.LA(1);

                         
                        int index6_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_75);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA6_76 = input.LA(1);

                         
                        int index6_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_76);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA6_77 = input.LA(1);

                         
                        int index6_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_77);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA6_78 = input.LA(1);

                         
                        int index6_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_78);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA6_82 = input.LA(1);

                         
                        int index6_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_82);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA6_83 = input.LA(1);

                         
                        int index6_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_83);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA6_84 = input.LA(1);

                         
                        int index6_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_84);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA6_85 = input.LA(1);

                         
                        int index6_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_85);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA6_87 = input.LA(1);

                         
                        int index6_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_87);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA6_88 = input.LA(1);

                         
                        int index6_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_88);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA6_89 = input.LA(1);

                         
                        int index6_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_89);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA6_90 = input.LA(1);

                         
                        int index6_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_90);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA6_91 = input.LA(1);

                         
                        int index6_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_91);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA6_92 = input.LA(1);

                         
                        int index6_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_92);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA6_94 = input.LA(1);

                         
                        int index6_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_94);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA6_95 = input.LA(1);

                         
                        int index6_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_95);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA6_103 = input.LA(1);

                         
                        int index6_103 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_103);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA6_106 = input.LA(1);

                         
                        int index6_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_106);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA6_107 = input.LA(1);

                         
                        int index6_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_107);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA6_108 = input.LA(1);

                         
                        int index6_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_108);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA6_109 = input.LA(1);

                         
                        int index6_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_109);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA6_110 = input.LA(1);

                         
                        int index6_110 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_110);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA6_111 = input.LA(1);

                         
                        int index6_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_111);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA6_112 = input.LA(1);

                         
                        int index6_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 20;}

                         
                        input.seek(index6_112);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA6_113 = input.LA(1);

                         
                        int index6_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_113);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA6_114 = input.LA(1);

                         
                        int index6_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_114);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA6_115 = input.LA(1);

                         
                        int index6_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_115);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA6_116 = input.LA(1);

                         
                        int index6_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_116);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA6_117 = input.LA(1);

                         
                        int index6_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_117);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA6_118 = input.LA(1);

                         
                        int index6_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_118);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA6_119 = input.LA(1);

                         
                        int index6_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_119);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA6_121 = input.LA(1);

                         
                        int index6_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_121);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA6_122 = input.LA(1);

                         
                        int index6_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_122);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA6_123 = input.LA(1);

                         
                        int index6_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_123);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA6_124 = input.LA(1);

                         
                        int index6_124 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_124);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA6_125 = input.LA(1);

                         
                        int index6_125 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_125);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA6_126 = input.LA(1);

                         
                        int index6_126 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_126);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA6_127 = input.LA(1);

                         
                        int index6_127 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_127);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA6_129 = input.LA(1);

                         
                        int index6_129 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_129);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA6_130 = input.LA(1);

                         
                        int index6_130 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_130);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA6_131 = input.LA(1);

                         
                        int index6_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_131);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA6_132 = input.LA(1);

                         
                        int index6_132 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 20;}

                         
                        input.seek(index6_132);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA6_133 = input.LA(1);

                         
                        int index6_133 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_133);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA6_134 = input.LA(1);

                         
                        int index6_134 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_134);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA6_135 = input.LA(1);

                         
                        int index6_135 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_135);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA6_136 = input.LA(1);

                         
                        int index6_136 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_136);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA6_137 = input.LA(1);

                         
                        int index6_137 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_137);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA6_139 = input.LA(1);

                         
                        int index6_139 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_139);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA6_140 = input.LA(1);

                         
                        int index6_140 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_140);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA6_141 = input.LA(1);

                         
                        int index6_141 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_141);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA6_142 = input.LA(1);

                         
                        int index6_142 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_142);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA6_143 = input.LA(1);

                         
                        int index6_143 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_143);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA6_144 = input.LA(1);

                         
                        int index6_144 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_144);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA6_145 = input.LA(1);

                         
                        int index6_145 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_145);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA6_147 = input.LA(1);

                         
                        int index6_147 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_147);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA6_148 = input.LA(1);

                         
                        int index6_148 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_148);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA6_149 = input.LA(1);

                         
                        int index6_149 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_149);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA6_155 = input.LA(1);

                         
                        int index6_155 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_155);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA6_156 = input.LA(1);

                         
                        int index6_156 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_156);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA6_157 = input.LA(1);

                         
                        int index6_157 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_157);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA6_158 = input.LA(1);

                         
                        int index6_158 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_158);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA6_160 = input.LA(1);

                         
                        int index6_160 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_160);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA6_161 = input.LA(1);

                         
                        int index6_161 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_161);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA6_162 = input.LA(1);

                         
                        int index6_162 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_162);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA6_163 = input.LA(1);

                         
                        int index6_163 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_163);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA6_164 = input.LA(1);

                         
                        int index6_164 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_164);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA6_165 = input.LA(1);

                         
                        int index6_165 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_165);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA6_167 = input.LA(1);

                         
                        int index6_167 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_167);
                        if ( s>=0 ) return s;
                        break;
                    case 96 : 
                        int LA6_168 = input.LA(1);

                         
                        int index6_168 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_168);
                        if ( s>=0 ) return s;
                        break;
                    case 97 : 
                        int LA6_169 = input.LA(1);

                         
                        int index6_169 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_169);
                        if ( s>=0 ) return s;
                        break;
                    case 98 : 
                        int LA6_172 = input.LA(1);

                         
                        int index6_172 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_172);
                        if ( s>=0 ) return s;
                        break;
                    case 99 : 
                        int LA6_173 = input.LA(1);

                         
                        int index6_173 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_173);
                        if ( s>=0 ) return s;
                        break;
                    case 100 : 
                        int LA6_174 = input.LA(1);

                         
                        int index6_174 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_174);
                        if ( s>=0 ) return s;
                        break;
                    case 101 : 
                        int LA6_175 = input.LA(1);

                         
                        int index6_175 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_175);
                        if ( s>=0 ) return s;
                        break;
                    case 102 : 
                        int LA6_176 = input.LA(1);

                         
                        int index6_176 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_176);
                        if ( s>=0 ) return s;
                        break;
                    case 103 : 
                        int LA6_178 = input.LA(1);

                         
                        int index6_178 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_178);
                        if ( s>=0 ) return s;
                        break;
                    case 104 : 
                        int LA6_179 = input.LA(1);

                         
                        int index6_179 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_179);
                        if ( s>=0 ) return s;
                        break;
                    case 105 : 
                        int LA6_180 = input.LA(1);

                         
                        int index6_180 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_180);
                        if ( s>=0 ) return s;
                        break;
                    case 106 : 
                        int LA6_181 = input.LA(1);

                         
                        int index6_181 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_181);
                        if ( s>=0 ) return s;
                        break;
                    case 107 : 
                        int LA6_182 = input.LA(1);

                         
                        int index6_182 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_182);
                        if ( s>=0 ) return s;
                        break;
                    case 108 : 
                        int LA6_183 = input.LA(1);

                         
                        int index6_183 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_183);
                        if ( s>=0 ) return s;
                        break;
                    case 109 : 
                        int LA6_185 = input.LA(1);

                         
                        int index6_185 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_185);
                        if ( s>=0 ) return s;
                        break;
                    case 110 : 
                        int LA6_186 = input.LA(1);

                         
                        int index6_186 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_186);
                        if ( s>=0 ) return s;
                        break;
                    case 111 : 
                        int LA6_187 = input.LA(1);

                         
                        int index6_187 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_187);
                        if ( s>=0 ) return s;
                        break;
                    case 112 : 
                        int LA6_193 = input.LA(1);

                         
                        int index6_193 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_193);
                        if ( s>=0 ) return s;
                        break;
                    case 113 : 
                        int LA6_194 = input.LA(1);

                         
                        int index6_194 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_194);
                        if ( s>=0 ) return s;
                        break;
                    case 114 : 
                        int LA6_195 = input.LA(1);

                         
                        int index6_195 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_195);
                        if ( s>=0 ) return s;
                        break;
                    case 115 : 
                        int LA6_196 = input.LA(1);

                         
                        int index6_196 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_196);
                        if ( s>=0 ) return s;
                        break;
                    case 116 : 
                        int LA6_198 = input.LA(1);

                         
                        int index6_198 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_198);
                        if ( s>=0 ) return s;
                        break;
                    case 117 : 
                        int LA6_199 = input.LA(1);

                         
                        int index6_199 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_199);
                        if ( s>=0 ) return s;
                        break;
                    case 118 : 
                        int LA6_200 = input.LA(1);

                         
                        int index6_200 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_200);
                        if ( s>=0 ) return s;
                        break;
                    case 119 : 
                        int LA6_201 = input.LA(1);

                         
                        int index6_201 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_201);
                        if ( s>=0 ) return s;
                        break;
                    case 120 : 
                        int LA6_202 = input.LA(1);

                         
                        int index6_202 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_202);
                        if ( s>=0 ) return s;
                        break;
                    case 121 : 
                        int LA6_203 = input.LA(1);

                         
                        int index6_203 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_203);
                        if ( s>=0 ) return s;
                        break;
                    case 122 : 
                        int LA6_205 = input.LA(1);

                         
                        int index6_205 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_205);
                        if ( s>=0 ) return s;
                        break;
                    case 123 : 
                        int LA6_206 = input.LA(1);

                         
                        int index6_206 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index6_206);
                        if ( s>=0 ) return s;
                        break;
                    case 124 : 
                        int LA6_207 = input.LA(1);

                         
                        int index6_207 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 47;}

                        else if ( (synpred7_ObjCpp()) ) {s = 20;}

                         
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
            return "()* loopback of 259:6: (subD= declaration )*";
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
            return "356:3: ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' )";
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
            return "357:4: ( ':' parentClass= IDENTIFIER )?";
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
            return "367:3: ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )?";
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
            return "376:3: ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )?";
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
            return "()* loopback of 378:4: ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )*";
        }
    }
    static final String DFA17_eotS =
        "\u00d6\uffff";
    static final String DFA17_eofS =
        "\u00d6\uffff";
    static final String DFA17_minS =
        "\4\6\1\77\5\6\1\66\1\6\1\uffff\3\6\1\77\2\6\1\uffff\2\6\1\27\6\6"+
        "\1\66\1\6\1\uffff\2\6\1\uffff\3\6\1\66\1\6\2\uffff\12\0\1\uffff"+
        "\1\0\2\uffff\6\0\2\uffff\3\0\1\uffff\1\0\1\uffff\4\0\2\uffff\22"+
        "\0\1\uffff\2\0\1\uffff\5\0\2\uffff\4\0\1\uffff\1\0\1\uffff\26\0"+
        "\1\uffff\2\0\1\uffff\5\0\2\uffff\1\0\7\uffff\5\0\2\uffff\3\0\1\uffff"+
        "\1\0\1\uffff\4\0\2\uffff\6\0\2\uffff\5\0\2\uffff\1\0\7\uffff\5\0"+
        "\2\uffff\3\0\1\uffff\1\0\1\uffff\4\0\2\uffff";
    static final String DFA17_maxS =
        "\2\111\2\27\2\111\1\71\1\111\2\71\1\66\1\71\1\uffff\1\111\2\27\2"+
        "\111\1\71\1\uffff\1\71\1\111\1\27\1\6\1\111\4\71\1\66\1\71\1\uffff"+
        "\1\111\1\71\1\uffff\3\71\1\66\1\71\2\uffff\12\0\1\uffff\1\0\2\uffff"+
        "\6\0\2\uffff\3\0\1\uffff\1\0\1\uffff\4\0\2\uffff\22\0\1\uffff\2"+
        "\0\1\uffff\5\0\2\uffff\4\0\1\uffff\1\0\1\uffff\26\0\1\uffff\2\0"+
        "\1\uffff\5\0\2\uffff\1\0\7\uffff\5\0\2\uffff\3\0\1\uffff\1\0\1\uffff"+
        "\4\0\2\uffff\6\0\2\uffff\5\0\2\uffff\1\0\7\uffff\5\0\2\uffff\3\0"+
        "\1\uffff\1\0\1\uffff\4\0\2\uffff";
    static final String DFA17_acceptS =
        "\14\uffff\1\1\6\uffff\1\2\u00c2\uffff";
    static final String DFA17_specialS =
        "\52\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff\1\12"+
        "\2\uffff\1\13\1\14\1\15\1\16\1\17\1\20\2\uffff\1\21\1\22\1\23\1"+
        "\uffff\1\24\1\uffff\1\25\1\26\1\27\1\30\2\uffff\1\31\1\32\1\33\1"+
        "\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50"+
        "\1\51\1\52\1\uffff\1\53\1\54\1\uffff\1\55\1\56\1\57\1\60\1\61\2"+
        "\uffff\1\62\1\63\1\64\1\65\1\uffff\1\66\1\uffff\1\67\1\70\1\71\1"+
        "\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1\104\1\105"+
        "\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1\uffff\1\115\1\116\1"+
        "\uffff\1\117\1\120\1\121\1\122\1\123\2\uffff\1\124\7\uffff\1\125"+
        "\1\126\1\127\1\130\1\131\2\uffff\1\132\1\133\1\134\1\uffff\1\135"+
        "\1\uffff\1\136\1\137\1\140\1\141\2\uffff\1\142\1\143\1\144\1\145"+
        "\1\146\1\147\2\uffff\1\150\1\151\1\152\1\153\1\154\2\uffff\1\155"+
        "\7\uffff\1\156\1\157\1\160\1\161\1\162\2\uffff\1\163\1\164\1\165"+
        "\1\uffff\1\166\1\uffff\1\167\1\170\1\171\1\172\2\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\1\27\uffff\1\3\16\uffff\3\2\13\uffff\4\4\2\5\11\6",
            "\1\7\25\uffff\1\23\1\uffff\1\17\3\uffff\1\13\1\uffff\1\15\10"+
            "\uffff\3\16\3\uffff\1\10\1\11\1\12\3\uffff\1\14\1\uffff\4\20"+
            "\2\21\11\22",
            "\1\24\20\uffff\1\25",
            "\1\26\20\uffff\1\27",
            "\2\30\11\31",
            "\1\32\25\uffff\1\23\5\uffff\1\36\20\uffff\1\33\1\34\1\35\3"+
            "\uffff\1\14\5\uffff\2\40\11\41",
            "\1\43\25\uffff\1\23\5\uffff\1\47\20\uffff\1\44\1\45\1\46\3"+
            "\uffff\1\14",
            "\1\53\24\uffff\1\14\1\70\1\14\1\60\3\uffff\1\63\1\uffff\1\65"+
            "\10\uffff\3\57\3\uffff\1\52\1\61\1\62\3\uffff\1\14\1\uffff\4"+
            "\54\2\55\11\56",
            "\1\72\25\uffff\1\23\5\uffff\1\71\20\uffff\1\73\1\74\1\75\3"+
            "\uffff\1\14",
            "\1\100\25\uffff\1\23\5\uffff\1\102\20\uffff\1\101\1\104\1\106"+
            "\3\uffff\1\14",
            "\1\107",
            "\1\110\33\uffff\1\14\20\uffff\1\111\1\14\4\uffff\1\14",
            "",
            "\1\116\27\uffff\1\115\6\uffff\1\122\7\uffff\3\114\13\uffff"+
            "\4\117\2\120\11\121",
            "\1\123\20\uffff\1\124",
            "\1\125\20\uffff\1\126",
            "\2\127\11\130",
            "\1\131\25\uffff\1\23\5\uffff\1\135\20\uffff\1\132\1\133\1\134"+
            "\3\uffff\1\14\5\uffff\2\137\11\140",
            "\1\142\25\uffff\1\23\5\uffff\1\146\20\uffff\1\143\1\144\1\145"+
            "\3\uffff\1\14",
            "",
            "\1\152\20\uffff\1\160\4\uffff\1\156\5\uffff\1\151\20\uffff"+
            "\1\153\1\154\1\23\3\uffff\1\14",
            "\1\166\21\uffff\1\176\1\175\1\174\3\uffff\1\165\2\172\14\uffff"+
            "\3\164\1\161\1\162\1\163\7\uffff\1\173\4\167\2\170\11\171",
            "\1\177",
            "\1\u0080",
            "\1\u0081\25\uffff\1\23\5\uffff\1\u0085\20\uffff\1\u0082\1\u0083"+
            "\1\u0084\3\uffff\1\14\5\uffff\2\u0087\11\u0088",
            "\1\u008a\25\uffff\1\23\5\uffff\1\u008e\20\uffff\1\u008b\1\u008c"+
            "\1\u008d\3\uffff\1\14",
            "\1\14\24\uffff\3\14\4\uffff\1\14\20\uffff\1\u0091\2\14\3\uffff"+
            "\1\14",
            "\1\u009a\25\uffff\1\23\5\uffff\1\u0099\20\uffff\1\u009b\1\u009c"+
            "\1\u009d\3\uffff\1\14",
            "\1\u00a0\25\uffff\1\23\5\uffff\1\u00a2\20\uffff\1\u00a1\1\u00a4"+
            "\1\u00a6\3\uffff\1\14",
            "\1\u00a7",
            "\1\u00a8\33\uffff\1\14\20\uffff\1\u00a9\1\14\4\uffff\1\14",
            "",
            "\1\u00ad\25\uffff\1\23\5\uffff\1\u00b1\20\uffff\1\u00ae\1\u00af"+
            "\1\u00b0\3\uffff\1\14\5\uffff\13\u00ac",
            "\1\u00b4\25\uffff\1\23\5\uffff\1\u00b8\20\uffff\1\u00b5\1\u00b6"+
            "\1\u00b7\3\uffff\1\14",
            "",
            "\1\14\24\uffff\3\14\4\uffff\1\14\20\uffff\1\u00bb\2\14\3\uffff"+
            "\1\14",
            "\1\u00c4\25\uffff\1\23\5\uffff\1\u00c3\20\uffff\1\u00c5\1\u00c6"+
            "\1\u00c7\3\uffff\1\14",
            "\1\u00ca\25\uffff\1\23\5\uffff\1\u00cc\20\uffff\1\u00cb\1\u00ce"+
            "\1\u00d0\3\uffff\1\14",
            "\1\u00d1",
            "\1\u00d2\33\uffff\1\14\20\uffff\1\u00d3\1\14\4\uffff\1\14",
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
            "",
            "\1\uffff",
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
            "",
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
            "",
            "\1\uffff",
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
            "\1\uffff",
            "",
            "\1\uffff",
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
            return "383:6: (fv= varDecl | functionPointerVarDecl )";
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
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                         
                        input.seek(index17_42);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_43 = input.LA(1);

                         
                        int index17_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_43);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA17_44 = input.LA(1);

                         
                        int index17_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_44);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA17_45 = input.LA(1);

                         
                        int index17_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_45);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA17_46 = input.LA(1);

                         
                        int index17_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_46);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA17_47 = input.LA(1);

                         
                        int index17_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_47);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA17_48 = input.LA(1);

                         
                        int index17_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_48);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA17_49 = input.LA(1);

                         
                        int index17_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_49);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA17_50 = input.LA(1);

                         
                        int index17_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_50);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA17_51 = input.LA(1);

                         
                        int index17_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_51);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA17_53 = input.LA(1);

                         
                        int index17_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_53);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA17_56 = input.LA(1);

                         
                        int index17_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_56);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA17_57 = input.LA(1);

                         
                        int index17_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 12;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index17_57);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA17_58 = input.LA(1);

                         
                        int index17_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 12;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index17_58);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA17_59 = input.LA(1);

                         
                        int index17_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 12;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index17_59);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA17_60 = input.LA(1);

                         
                        int index17_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 12;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index17_60);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA17_61 = input.LA(1);

                         
                        int index17_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 12;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index17_61);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA17_64 = input.LA(1);

                         
                        int index17_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 12;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index17_64);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA17_65 = input.LA(1);

                         
                        int index17_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 12;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index17_65);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA17_66 = input.LA(1);

                         
                        int index17_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 12;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index17_66);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA17_68 = input.LA(1);

                         
                        int index17_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 12;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index17_68);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA17_70 = input.LA(1);

                         
                        int index17_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 12;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index17_70);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA17_71 = input.LA(1);

                         
                        int index17_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 12;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index17_71);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA17_72 = input.LA(1);

                         
                        int index17_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 12;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index17_72);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA17_73 = input.LA(1);

                         
                        int index17_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 12;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index17_73);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA17_76 = input.LA(1);

                         
                        int index17_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 12;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index17_76);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA17_77 = input.LA(1);

                         
                        int index17_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 12;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index17_77);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA17_78 = input.LA(1);

                         
                        int index17_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 12;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index17_78);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA17_79 = input.LA(1);

                         
                        int index17_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 12;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index17_79);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA17_80 = input.LA(1);

                         
                        int index17_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 12;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index17_80);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA17_81 = input.LA(1);

                         
                        int index17_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 12;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index17_81);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA17_82 = input.LA(1);

                         
                        int index17_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 12;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index17_82);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA17_83 = input.LA(1);

                         
                        int index17_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 19;}

                         
                        input.seek(index17_83);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA17_84 = input.LA(1);

                         
                        int index17_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 19;}

                         
                        input.seek(index17_84);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA17_85 = input.LA(1);

                         
                        int index17_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 19;}

                         
                        input.seek(index17_85);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA17_86 = input.LA(1);

                         
                        int index17_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 19;}

                         
                        input.seek(index17_86);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA17_87 = input.LA(1);

                         
                        int index17_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_87);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA17_88 = input.LA(1);

                         
                        int index17_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_88);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA17_89 = input.LA(1);

                         
                        int index17_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_89);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA17_90 = input.LA(1);

                         
                        int index17_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_90);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA17_91 = input.LA(1);

                         
                        int index17_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_91);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA17_92 = input.LA(1);

                         
                        int index17_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_92);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA17_93 = input.LA(1);

                         
                        int index17_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_93);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA17_95 = input.LA(1);

                         
                        int index17_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_95);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA17_96 = input.LA(1);

                         
                        int index17_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_96);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA17_98 = input.LA(1);

                         
                        int index17_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_98);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA17_99 = input.LA(1);

                         
                        int index17_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_99);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA17_100 = input.LA(1);

                         
                        int index17_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_100);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA17_101 = input.LA(1);

                         
                        int index17_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_101);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA17_102 = input.LA(1);

                         
                        int index17_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index17_102);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA17_105 = input.LA(1);

                         
                        int index17_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_105);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA17_106 = input.LA(1);

                         
                        int index17_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_106);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA17_107 = input.LA(1);

                         
                        int index17_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_107);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA17_108 = input.LA(1);

                         
                        int index17_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_108);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA17_110 = input.LA(1);

                         
                        int index17_110 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_110);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA17_112 = input.LA(1);

                         
                        int index17_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_112);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA17_113 = input.LA(1);

                         
                        int index17_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_113);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA17_114 = input.LA(1);

                         
                        int index17_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_114);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA17_115 = input.LA(1);

                         
                        int index17_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_115);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA17_116 = input.LA(1);

                         
                        int index17_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_116);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA17_117 = input.LA(1);

                         
                        int index17_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_117);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA17_118 = input.LA(1);

                         
                        int index17_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_118);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA17_119 = input.LA(1);

                         
                        int index17_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_119);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA17_120 = input.LA(1);

                         
                        int index17_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_120);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA17_121 = input.LA(1);

                         
                        int index17_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_121);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA17_122 = input.LA(1);

                         
                        int index17_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_122);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA17_123 = input.LA(1);

                         
                        int index17_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_123);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA17_124 = input.LA(1);

                         
                        int index17_124 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_124);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA17_125 = input.LA(1);

                         
                        int index17_125 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_125);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA17_126 = input.LA(1);

                         
                        int index17_126 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_126);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA17_127 = input.LA(1);

                         
                        int index17_127 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_127);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA17_128 = input.LA(1);

                         
                        int index17_128 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_128);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA17_129 = input.LA(1);

                         
                        int index17_129 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_129);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA17_130 = input.LA(1);

                         
                        int index17_130 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_130);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA17_131 = input.LA(1);

                         
                        int index17_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_131);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA17_132 = input.LA(1);

                         
                        int index17_132 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_132);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA17_133 = input.LA(1);

                         
                        int index17_133 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_133);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA17_135 = input.LA(1);

                         
                        int index17_135 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_135);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA17_136 = input.LA(1);

                         
                        int index17_136 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_136);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA17_138 = input.LA(1);

                         
                        int index17_138 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_138);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA17_139 = input.LA(1);

                         
                        int index17_139 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_139);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA17_140 = input.LA(1);

                         
                        int index17_140 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_140);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA17_141 = input.LA(1);

                         
                        int index17_141 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_141);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA17_142 = input.LA(1);

                         
                        int index17_142 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_142);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA17_145 = input.LA(1);

                         
                        int index17_145 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_145);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA17_153 = input.LA(1);

                         
                        int index17_153 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_153);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA17_154 = input.LA(1);

                         
                        int index17_154 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_154);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA17_155 = input.LA(1);

                         
                        int index17_155 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_155);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA17_156 = input.LA(1);

                         
                        int index17_156 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_156);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA17_157 = input.LA(1);

                         
                        int index17_157 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_157);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA17_160 = input.LA(1);

                         
                        int index17_160 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_160);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA17_161 = input.LA(1);

                         
                        int index17_161 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_161);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA17_162 = input.LA(1);

                         
                        int index17_162 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_162);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA17_164 = input.LA(1);

                         
                        int index17_164 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_164);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA17_166 = input.LA(1);

                         
                        int index17_166 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_166);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA17_167 = input.LA(1);

                         
                        int index17_167 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_167);
                        if ( s>=0 ) return s;
                        break;
                    case 96 : 
                        int LA17_168 = input.LA(1);

                         
                        int index17_168 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_168);
                        if ( s>=0 ) return s;
                        break;
                    case 97 : 
                        int LA17_169 = input.LA(1);

                         
                        int index17_169 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_169);
                        if ( s>=0 ) return s;
                        break;
                    case 98 : 
                        int LA17_172 = input.LA(1);

                         
                        int index17_172 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_172);
                        if ( s>=0 ) return s;
                        break;
                    case 99 : 
                        int LA17_173 = input.LA(1);

                         
                        int index17_173 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_173);
                        if ( s>=0 ) return s;
                        break;
                    case 100 : 
                        int LA17_174 = input.LA(1);

                         
                        int index17_174 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_174);
                        if ( s>=0 ) return s;
                        break;
                    case 101 : 
                        int LA17_175 = input.LA(1);

                         
                        int index17_175 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_175);
                        if ( s>=0 ) return s;
                        break;
                    case 102 : 
                        int LA17_176 = input.LA(1);

                         
                        int index17_176 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_176);
                        if ( s>=0 ) return s;
                        break;
                    case 103 : 
                        int LA17_177 = input.LA(1);

                         
                        int index17_177 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_177);
                        if ( s>=0 ) return s;
                        break;
                    case 104 : 
                        int LA17_180 = input.LA(1);

                         
                        int index17_180 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_180);
                        if ( s>=0 ) return s;
                        break;
                    case 105 : 
                        int LA17_181 = input.LA(1);

                         
                        int index17_181 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_181);
                        if ( s>=0 ) return s;
                        break;
                    case 106 : 
                        int LA17_182 = input.LA(1);

                         
                        int index17_182 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_182);
                        if ( s>=0 ) return s;
                        break;
                    case 107 : 
                        int LA17_183 = input.LA(1);

                         
                        int index17_183 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_183);
                        if ( s>=0 ) return s;
                        break;
                    case 108 : 
                        int LA17_184 = input.LA(1);

                         
                        int index17_184 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_184);
                        if ( s>=0 ) return s;
                        break;
                    case 109 : 
                        int LA17_187 = input.LA(1);

                         
                        int index17_187 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_187);
                        if ( s>=0 ) return s;
                        break;
                    case 110 : 
                        int LA17_195 = input.LA(1);

                         
                        int index17_195 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_195);
                        if ( s>=0 ) return s;
                        break;
                    case 111 : 
                        int LA17_196 = input.LA(1);

                         
                        int index17_196 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_196);
                        if ( s>=0 ) return s;
                        break;
                    case 112 : 
                        int LA17_197 = input.LA(1);

                         
                        int index17_197 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_197);
                        if ( s>=0 ) return s;
                        break;
                    case 113 : 
                        int LA17_198 = input.LA(1);

                         
                        int index17_198 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_198);
                        if ( s>=0 ) return s;
                        break;
                    case 114 : 
                        int LA17_199 = input.LA(1);

                         
                        int index17_199 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_199);
                        if ( s>=0 ) return s;
                        break;
                    case 115 : 
                        int LA17_202 = input.LA(1);

                         
                        int index17_202 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_202);
                        if ( s>=0 ) return s;
                        break;
                    case 116 : 
                        int LA17_203 = input.LA(1);

                         
                        int index17_203 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_203);
                        if ( s>=0 ) return s;
                        break;
                    case 117 : 
                        int LA17_204 = input.LA(1);

                         
                        int index17_204 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_204);
                        if ( s>=0 ) return s;
                        break;
                    case 118 : 
                        int LA17_206 = input.LA(1);

                         
                        int index17_206 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_206);
                        if ( s>=0 ) return s;
                        break;
                    case 119 : 
                        int LA17_208 = input.LA(1);

                         
                        int index17_208 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_208);
                        if ( s>=0 ) return s;
                        break;
                    case 120 : 
                        int LA17_209 = input.LA(1);

                         
                        int index17_209 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_209);
                        if ( s>=0 ) return s;
                        break;
                    case 121 : 
                        int LA17_210 = input.LA(1);

                         
                        int index17_210 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index17_210);
                        if ( s>=0 ) return s;
                        break;
                    case 122 : 
                        int LA17_211 = input.LA(1);

                         
                        int index17_211 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 19;}

                         
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
            return "()* loopback of 396:3: ( objCMethodDecl | typeDef | vd= varDecl {...}?)*";
        }
    }
    static final String DFA31_eotS =
        "\40\uffff";
    static final String DFA31_eofS =
        "\1\uffff\1\3\2\uffff\1\3\33\uffff";
    static final String DFA31_minS =
        "\2\6\2\uffff\1\6\6\uffff\1\6\5\uffff\2\0\10\uffff\1\0\4\uffff";
    static final String DFA31_maxS =
        "\1\27\1\71\2\uffff\1\71\6\uffff\1\71\5\uffff\2\0\10\uffff\1\0\4"+
        "\uffff";
    static final String DFA31_acceptS =
        "\2\uffff\1\2\1\1\34\uffff";
    static final String DFA31_specialS =
        "\21\uffff\1\0\1\1\10\uffff\1\2\4\uffff}>";
    static final String[] DFA31_transitionS = {
            "\1\1\20\uffff\1\2",
            "\1\4\20\uffff\1\2\3\uffff\3\3\4\uffff\1\13\1\3\1\uffff\1\3"+
            "\15\uffff\3\3\3\uffff\1\3",
            "",
            "",
            "\1\21\20\uffff\1\2\3\uffff\3\3\4\uffff\1\22\1\3\17\uffff\3"+
            "\3\3\uffff\1\3",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\33\33\uffff\1\3\1\2\17\uffff\2\3\4\uffff\1\3",
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
            return "487:3: ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' )";
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
                        if ( (synpred40_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index31_17);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA31_18 = input.LA(1);

                         
                        int index31_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred40_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index31_18);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA31_27 = input.LA(1);

                         
                        int index31_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred40_ObjCpp()) ) {s = 3;}

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
            return "()* loopback of 502:5: ( ( 'public' | 'private' | 'protected' ) ':' | declaration )*";
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
            return "525:16: (returnTypeRef= typeRef )?";
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
                        if ( (((synpred47_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred47_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred47_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 1;}

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
            return "()* loopback of 563:3: ( exportationModifier )*";
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
    static final String DFA42_eotS =
        "\30\uffff";
    static final String DFA42_eofS =
        "\30\uffff";
    static final String DFA42_minS =
        "\1\6\1\0\26\uffff";
    static final String DFA42_maxS =
        "\1\111\1\0\26\uffff";
    static final String DFA42_acceptS =
        "\2\uffff\1\2\24\uffff\1\1";
    static final String DFA42_specialS =
        "\1\uffff\1\0\26\uffff}>";
    static final String[] DFA42_transitionS = {
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

    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;

    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "690:4: ({...}?m= modifier )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA42_1 = input.LA(1);

                         
                        int index42_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred59_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 23;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 2;}

                         
                        input.seek(index42_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 42, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA47_eotS =
        "\51\uffff";
    static final String DFA47_eofS =
        "\1\uffff\1\2\47\uffff";
    static final String DFA47_minS =
        "\2\6\3\uffff\1\0\43\uffff";
    static final String DFA47_maxS =
        "\2\111\3\uffff\1\0\43\uffff";
    static final String DFA47_acceptS =
        "\2\uffff\1\2\17\uffff\1\1\26\uffff";
    static final String DFA47_specialS =
        "\5\uffff\1\0\43\uffff}>";
    static final String[] DFA47_transitionS = {
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

    static final short[] DFA47_eot = DFA.unpackEncodedString(DFA47_eotS);
    static final short[] DFA47_eof = DFA.unpackEncodedString(DFA47_eofS);
    static final char[] DFA47_min = DFA.unpackEncodedStringToUnsignedChars(DFA47_minS);
    static final char[] DFA47_max = DFA.unpackEncodedStringToUnsignedChars(DFA47_maxS);
    static final short[] DFA47_accept = DFA.unpackEncodedString(DFA47_acceptS);
    static final short[] DFA47_special = DFA.unpackEncodedString(DFA47_specialS);
    static final short[][] DFA47_transition;

    static {
        int numStates = DFA47_transitionS.length;
        DFA47_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA47_transition[i] = DFA.unpackEncodedString(DFA47_transitionS[i]);
        }
    }

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = DFA47_eot;
            this.eof = DFA47_eof;
            this.min = DFA47_min;
            this.max = DFA47_max;
            this.accept = DFA47_accept;
            this.special = DFA47_special;
            this.transition = DFA47_transition;
        }
        public String getDescription() {
            return "691:3: ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA47_5 = input.LA(1);

                         
                        int index47_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred60_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 18;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 2;}

                         
                        input.seek(index47_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 47, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA45_eotS =
        "\16\uffff";
    static final String DFA45_eofS =
        "\1\1\15\uffff";
    static final String DFA45_minS =
        "\1\6\15\uffff";
    static final String DFA45_maxS =
        "\1\71\15\uffff";
    static final String DFA45_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA45_specialS =
        "\16\uffff}>";
    static final String[] DFA45_transitionS = {
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

    static final short[] DFA45_eot = DFA.unpackEncodedString(DFA45_eotS);
    static final short[] DFA45_eof = DFA.unpackEncodedString(DFA45_eofS);
    static final char[] DFA45_min = DFA.unpackEncodedStringToUnsignedChars(DFA45_minS);
    static final char[] DFA45_max = DFA.unpackEncodedStringToUnsignedChars(DFA45_maxS);
    static final short[] DFA45_accept = DFA.unpackEncodedString(DFA45_acceptS);
    static final short[] DFA45_special = DFA.unpackEncodedString(DFA45_specialS);
    static final short[][] DFA45_transition;

    static {
        int numStates = DFA45_transitionS.length;
        DFA45_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA45_transition[i] = DFA.unpackEncodedString(DFA45_transitionS[i]);
        }
    }

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = DFA45_eot;
            this.eof = DFA45_eof;
            this.min = DFA45_min;
            this.max = DFA45_max;
            this.accept = DFA45_accept;
            this.special = DFA45_special;
            this.transition = DFA45_transition;
        }
        public String getDescription() {
            return "697:64: ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' )";
        }
    }
    static final String DFA59_eotS =
        "\65\uffff";
    static final String DFA59_eofS =
        "\1\6\64\uffff";
    static final String DFA59_minS =
        "\1\6\5\0\57\uffff";
    static final String DFA59_maxS =
        "\1\71\5\0\57\uffff";
    static final String DFA59_acceptS =
        "\6\uffff\1\2\20\uffff\1\1\35\uffff";
    static final String DFA59_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\57\uffff}>";
    static final String[] DFA59_transitionS = {
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
            return "773:3: ( ( typeMutator )* functionSignatureSuffix )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA59_1 = input.LA(1);

                         
                        int index59_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred77_ObjCpp()&&( next("const", "__const") ))) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index59_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA59_2 = input.LA(1);

                         
                        int index59_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred77_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index59_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA59_3 = input.LA(1);

                         
                        int index59_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred77_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index59_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA59_4 = input.LA(1);

                         
                        int index59_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred77_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index59_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA59_5 = input.LA(1);

                         
                        int index59_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred77_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index59_5);
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
        "\140\uffff";
    static final String DFA61_eofS =
        "\140\uffff";
    static final String DFA61_minS =
        "\4\6\1\uffff\1\6\1\uffff\1\6\7\uffff\4\6\2\uffff\4\6\2\uffff\2\6"+
        "\2\uffff\4\0\2\uffff\1\0\7\uffff\4\0\2\uffff\2\0\2\uffff\4\0\2\uffff"+
        "\1\0\7\uffff\4\0\2\uffff\2\0\2\uffff\4\0\3\uffff\1\0\2\uffff\2\0"+
        "\5\uffff";
    static final String DFA61_maxS =
        "\4\71\1\uffff\1\71\1\uffff\1\71\7\uffff\4\71\2\uffff\4\71\2\uffff"+
        "\2\71\2\uffff\4\0\2\uffff\1\0\7\uffff\4\0\2\uffff\2\0\2\uffff\4"+
        "\0\2\uffff\1\0\7\uffff\4\0\2\uffff\2\0\2\uffff\4\0\3\uffff\1\0\2"+
        "\uffff\2\0\5\uffff";
    static final String DFA61_acceptS =
        "\4\uffff\1\1\1\uffff\1\2\131\uffff";
    static final String DFA61_specialS =
        "\37\uffff\1\0\1\1\1\2\1\3\2\uffff\1\4\7\uffff\1\5\1\6\1\7\1\10\2"+
        "\uffff\1\11\1\12\2\uffff\1\13\1\14\1\15\1\16\2\uffff\1\17\7\uffff"+
        "\1\20\1\21\1\22\1\23\2\uffff\1\24\1\25\2\uffff\1\26\1\27\1\30\1"+
        "\31\3\uffff\1\32\2\uffff\1\33\1\34\5\uffff}>";
    static final String[] DFA61_transitionS = {
            "\1\1\33\uffff\1\5\20\uffff\1\2\1\3\1\4\3\uffff\1\6",
            "\1\6\24\uffff\3\6\4\uffff\1\6\20\uffff\1\7\2\6\3\uffff\1\6",
            "\1\17\33\uffff\1\21\20\uffff\1\20\1\22\1\4\3\uffff\1\6",
            "\1\25\33\uffff\1\27\20\uffff\1\26\1\30\1\4\3\uffff\1\6",
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
            "\1\56\33\uffff\1\55\20\uffff\1\57\1\60\1\4\3\uffff\1\6",
            "\1\63\33\uffff\1\6\20\uffff\1\64\1\6\4\uffff\1\6",
            "\1\70\33\uffff\1\67\20\uffff\1\71\1\72\1\4\3\uffff\1\6",
            "",
            "",
            "\1\6\24\uffff\3\6\4\uffff\1\6\20\uffff\1\75\2\6\3\uffff\1\6",
            "\1\106\33\uffff\1\105\20\uffff\1\107\1\110\1\4\3\uffff\1\6",
            "\1\113\33\uffff\1\6\20\uffff\1\114\1\6\4\uffff\1\6",
            "\1\120\33\uffff\1\117\20\uffff\1\121\1\122\1\4\3\uffff\1\6",
            "",
            "",
            "\1\131\26\uffff\1\6\4\uffff\1\126\1\6\17\uffff\1\132\2\6\3"+
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
            return "788:3: ( ( typeMutator )* functionSignatureSuffixNoName )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA61_31 = input.LA(1);

                         
                        int index61_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred79_ObjCpp()&&( next("const", "__const") ))) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_31);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA61_32 = input.LA(1);

                         
                        int index61_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred79_ObjCpp()&&( next("const", "__const") ))) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_32);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA61_33 = input.LA(1);

                         
                        int index61_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred79_ObjCpp()&&( next("const", "__const") ))) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_33);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA61_34 = input.LA(1);

                         
                        int index61_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred79_ObjCpp()&&( next("const", "__const") ))) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_34);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA61_37 = input.LA(1);

                         
                        int index61_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_37);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA61_45 = input.LA(1);

                         
                        int index61_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_45);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA61_46 = input.LA(1);

                         
                        int index61_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_46);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA61_47 = input.LA(1);

                         
                        int index61_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_47);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA61_48 = input.LA(1);

                         
                        int index61_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_48);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA61_51 = input.LA(1);

                         
                        int index61_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_51);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA61_52 = input.LA(1);

                         
                        int index61_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_52);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA61_55 = input.LA(1);

                         
                        int index61_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_55);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA61_56 = input.LA(1);

                         
                        int index61_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_56);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA61_57 = input.LA(1);

                         
                        int index61_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_57);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA61_58 = input.LA(1);

                         
                        int index61_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_58);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA61_61 = input.LA(1);

                         
                        int index61_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_61);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA61_69 = input.LA(1);

                         
                        int index61_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_69);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA61_70 = input.LA(1);

                         
                        int index61_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_70);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA61_71 = input.LA(1);

                         
                        int index61_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_71);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA61_72 = input.LA(1);

                         
                        int index61_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_72);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA61_75 = input.LA(1);

                         
                        int index61_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_75);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA61_76 = input.LA(1);

                         
                        int index61_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_76);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA61_79 = input.LA(1);

                         
                        int index61_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_79);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA61_80 = input.LA(1);

                         
                        int index61_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_80);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA61_81 = input.LA(1);

                         
                        int index61_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_81);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA61_82 = input.LA(1);

                         
                        int index61_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_82);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA61_86 = input.LA(1);

                         
                        int index61_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_86);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA61_89 = input.LA(1);

                         
                        int index61_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_89);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA61_90 = input.LA(1);

                         
                        int index61_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred79_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_90);
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
        "\27\uffff";
    static final String DFA63_eofS =
        "\2\uffff\1\1\24\uffff";
    static final String DFA63_minS =
        "\1\6\1\uffff\1\6\2\uffff\1\6\11\uffff\1\0\7\uffff";
    static final String DFA63_maxS =
        "\1\71\1\uffff\1\71\2\uffff\1\111\11\uffff\1\0\7\uffff";
    static final String DFA63_acceptS =
        "\1\uffff\1\2\11\uffff\1\1\13\uffff";
    static final String DFA63_specialS =
        "\17\uffff\1\0\7\uffff}>";
    static final String[] DFA63_transitionS = {
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
            return "()* loopback of 809:3: ({...}? modifier )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA63_15 = input.LA(1);

                         
                        int index63_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred81_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index63_15);
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
    static final String DFA65_eotS =
        "\23\uffff";
    static final String DFA65_eofS =
        "\1\2\22\uffff";
    static final String DFA65_minS =
        "\1\33\1\0\21\uffff";
    static final String DFA65_maxS =
        "\1\43\1\0\21\uffff";
    static final String DFA65_acceptS =
        "\2\uffff\1\2\17\uffff\1\1";
    static final String DFA65_specialS =
        "\1\uffff\1\0\21\uffff}>";
    static final String[] DFA65_transitionS = {
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

    static final short[] DFA65_eot = DFA.unpackEncodedString(DFA65_eotS);
    static final short[] DFA65_eof = DFA.unpackEncodedString(DFA65_eofS);
    static final char[] DFA65_min = DFA.unpackEncodedStringToUnsignedChars(DFA65_minS);
    static final char[] DFA65_max = DFA.unpackEncodedStringToUnsignedChars(DFA65_maxS);
    static final short[] DFA65_accept = DFA.unpackEncodedString(DFA65_acceptS);
    static final short[] DFA65_special = DFA.unpackEncodedString(DFA65_specialS);
    static final short[][] DFA65_transition;

    static {
        int numStates = DFA65_transitionS.length;
        DFA65_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA65_transition[i] = DFA.unpackEncodedString(DFA65_transitionS[i]);
        }
    }

    class DFA65 extends DFA {

        public DFA65(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 65;
            this.eot = DFA65_eot;
            this.eof = DFA65_eof;
            this.min = DFA65_min;
            this.max = DFA65_max;
            this.accept = DFA65_accept;
            this.special = DFA65_special;
            this.transition = DFA65_transition;
        }
        public String getDescription() {
            return "829:4: ( '=' expression )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA65_1 = input.LA(1);

                         
                        int index65_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_ObjCpp()) ) {s = 18;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index65_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 65, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA67_eotS =
        "\25\uffff";
    static final String DFA67_eofS =
        "\25\uffff";
    static final String DFA67_minS =
        "\1\6\2\uffff\1\0\21\uffff";
    static final String DFA67_maxS =
        "\1\111\2\uffff\1\0\21\uffff";
    static final String DFA67_acceptS =
        "\1\uffff\1\3\21\uffff\1\1\1\2";
    static final String DFA67_specialS =
        "\3\uffff\1\0\21\uffff}>";
    static final String[] DFA67_transitionS = {
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
            return "()* loopback of 870:4: ({...}?sm= modifier | {...}?tm= modifier )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA67_3 = input.LA(1);

                         
                        int index67_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred87_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 19;}

                        else if ( (((synpred88_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 20;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 1;}

                         
                        input.seek(index67_3);
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
    static final String DFA72_eotS =
        "\13\uffff";
    static final String DFA72_eofS =
        "\13\uffff";
    static final String DFA72_minS =
        "\1\6\1\0\11\uffff";
    static final String DFA72_maxS =
        "\1\71\1\0\11\uffff";
    static final String DFA72_acceptS =
        "\2\uffff\1\2\7\uffff\1\1";
    static final String DFA72_specialS =
        "\1\uffff\1\0\11\uffff}>";
    static final String[] DFA72_transitionS = {
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

    static final short[] DFA72_eot = DFA.unpackEncodedString(DFA72_eotS);
    static final short[] DFA72_eof = DFA.unpackEncodedString(DFA72_eofS);
    static final char[] DFA72_min = DFA.unpackEncodedStringToUnsignedChars(DFA72_minS);
    static final char[] DFA72_max = DFA.unpackEncodedStringToUnsignedChars(DFA72_maxS);
    static final short[] DFA72_accept = DFA.unpackEncodedString(DFA72_acceptS);
    static final short[] DFA72_special = DFA.unpackEncodedString(DFA72_specialS);
    static final short[][] DFA72_transition;

    static {
        int numStates = DFA72_transitionS.length;
        DFA72_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA72_transition[i] = DFA.unpackEncodedString(DFA72_transitionS[i]);
        }
    }

    class DFA72 extends DFA {

        public DFA72(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 72;
            this.eot = DFA72_eot;
            this.eof = DFA72_eof;
            this.min = DFA72_min;
            this.max = DFA72_max;
            this.accept = DFA72_accept;
            this.special = DFA72_special;
            this.transition = DFA72_transition;
        }
        public String getDescription() {
            return "()* loopback of 959:4: (im= modifier )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA72_1 = input.LA(1);

                         
                        int index72_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred94_ObjCpp()&&( Modifier.parseModifier(next()) != null ))) ) {s = 10;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index72_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 72, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA74_eotS =
        "\16\uffff";
    static final String DFA74_eofS =
        "\16\uffff";
    static final String DFA74_minS =
        "\1\4\15\uffff";
    static final String DFA74_maxS =
        "\1\114\15\uffff";
    static final String DFA74_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA74_specialS =
        "\16\uffff}>";
    static final String[] DFA74_transitionS = {
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
            return "969:4: ( expression | )";
        }
    }
    static final String DFA76_eotS =
        "\14\uffff";
    static final String DFA76_eofS =
        "\14\uffff";
    static final String DFA76_minS =
        "\1\33\1\6\1\uffff\1\0\10\uffff";
    static final String DFA76_maxS =
        "\1\43\1\111\1\uffff\1\0\10\uffff";
    static final String DFA76_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\7\uffff";
    static final String DFA76_specialS =
        "\3\uffff\1\0\10\uffff}>";
    static final String[] DFA76_transitionS = {
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
            return "()* loopback of 996:4: ( ',' ax= argDef )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA76_3 = input.LA(1);

                         
                        int index76_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred98_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index76_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 76, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA79_eotS =
        "\61\uffff";
    static final String DFA79_eofS =
        "\1\1\60\uffff";
    static final String DFA79_minS =
        "\1\6\2\uffff\2\0\4\uffff\1\0\1\uffff\1\0\45\uffff";
    static final String DFA79_maxS =
        "\1\71\2\uffff\2\0\4\uffff\1\0\1\uffff\1\0\45\uffff";
    static final String DFA79_acceptS =
        "\1\uffff\1\2\25\uffff\1\1\31\uffff";
    static final String DFA79_specialS =
        "\3\uffff\1\0\1\1\4\uffff\1\2\1\uffff\1\3\45\uffff}>";
    static final String[] DFA79_transitionS = {
            "\1\3\24\uffff\3\1\4\uffff\2\1\1\uffff\1\1\15\uffff\1\4\1\11"+
            "\1\13\3\uffff\1\1",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
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
            ""
    };

    static final short[] DFA79_eot = DFA.unpackEncodedString(DFA79_eotS);
    static final short[] DFA79_eof = DFA.unpackEncodedString(DFA79_eofS);
    static final char[] DFA79_min = DFA.unpackEncodedStringToUnsignedChars(DFA79_minS);
    static final char[] DFA79_max = DFA.unpackEncodedStringToUnsignedChars(DFA79_maxS);
    static final short[] DFA79_accept = DFA.unpackEncodedString(DFA79_acceptS);
    static final short[] DFA79_special = DFA.unpackEncodedString(DFA79_specialS);
    static final short[][] DFA79_transition;

    static {
        int numStates = DFA79_transitionS.length;
        DFA79_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA79_transition[i] = DFA.unpackEncodedString(DFA79_transitionS[i]);
        }
    }

    class DFA79 extends DFA {

        public DFA79(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 79;
            this.eot = DFA79_eot;
            this.eof = DFA79_eof;
            this.min = DFA79_min;
            this.max = DFA79_max;
            this.accept = DFA79_accept;
            this.special = DFA79_special;
            this.transition = DFA79_transition;
        }
        public String getDescription() {
            return "()* loopback of 1017:3: ( typeMutator )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA79_3 = input.LA(1);

                         
                        int index79_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred101_ObjCpp()&&( next("const", "__const") ))) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index79_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA79_4 = input.LA(1);

                         
                        int index79_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred101_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index79_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA79_9 = input.LA(1);

                         
                        int index79_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred101_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index79_9);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA79_11 = input.LA(1);

                         
                        int index79_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred101_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index79_11);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 79, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA82_eotS =
        "\21\uffff";
    static final String DFA82_eofS =
        "\1\uffff\1\2\17\uffff";
    static final String DFA82_minS =
        "\1\77\1\6\17\uffff";
    static final String DFA82_maxS =
        "\2\111\17\uffff";
    static final String DFA82_acceptS =
        "\2\uffff\1\2\14\uffff\1\1\1\uffff";
    static final String DFA82_specialS =
        "\21\uffff}>";
    static final String[] DFA82_transitionS = {
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
            return "1050:4: (mod2= primSizeModifier (mod3= primSizeModifier )? )?";
        }
    }
    static final String DFA81_eotS =
        "\20\uffff";
    static final String DFA81_eofS =
        "\1\uffff\1\2\16\uffff";
    static final String DFA81_minS =
        "\1\77\1\6\16\uffff";
    static final String DFA81_maxS =
        "\2\111\16\uffff";
    static final String DFA81_acceptS =
        "\2\uffff\1\2\1\1\14\uffff";
    static final String DFA81_specialS =
        "\20\uffff}>";
    static final String[] DFA81_transitionS = {
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
            return "1051:8: (mod3= primSizeModifier )?";
        }
    }
    static final String DFA86_eotS =
        "\16\uffff";
    static final String DFA86_eofS =
        "\16\uffff";
    static final String DFA86_minS =
        "\1\4\15\uffff";
    static final String DFA86_maxS =
        "\1\114\15\uffff";
    static final String DFA86_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA86_specialS =
        "\16\uffff}>";
    static final String[] DFA86_transitionS = {
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
            return "1120:3: (a1= expression ( ',' ax= expression )* )?";
        }
    }
    static final String DFA89_eotS =
        "\33\uffff";
    static final String DFA89_eofS =
        "\1\uffff\1\16\31\uffff";
    static final String DFA89_minS =
        "\1\4\1\6\31\uffff";
    static final String DFA89_maxS =
        "\1\114\1\132\31\uffff";
    static final String DFA89_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\5\uffff\1\7\1\uffff\1\1\14\uffff";
    static final String DFA89_specialS =
        "\33\uffff}>";
    static final String[] DFA89_transitionS = {
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
            return "1134:4: (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' )";
        }
    }
    static final String DFA88_eotS =
        "\172\uffff";
    static final String DFA88_eofS =
        "\37\uffff\1\2\132\uffff";
    static final String DFA88_minS =
        "\1\4\1\6\20\uffff\1\4\12\uffff\1\4\1\uffff\3\4\2\uffff\1\0\16\uffff"+
        "\1\0\2\uffff\2\0\11\uffff\1\0\27\uffff\2\0\2\uffff\1\0\12\uffff"+
        "\1\0\21\uffff";
    static final String DFA88_maxS =
        "\1\114\1\132\20\uffff\1\114\12\uffff\1\114\1\uffff\1\132\2\114\2"+
        "\uffff\1\0\16\uffff\1\0\2\uffff\2\0\11\uffff\1\0\27\uffff\2\0\2"+
        "\uffff\1\0\12\uffff\1\0\21\uffff";
    static final String DFA88_acceptS =
        "\2\uffff\1\1\12\uffff\1\2\154\uffff";
    static final String DFA88_specialS =
        "\44\uffff\1\0\16\uffff\1\1\2\uffff\1\2\1\3\11\uffff\1\4\27\uffff"+
        "\1\5\1\6\2\uffff\1\7\12\uffff\1\10\21\uffff}>";
    static final String[] DFA88_transitionS = {
            "\2\2\1\1\4\2\14\uffff\1\2\6\uffff\1\15\3\uffff\1\2\12\uffff"+
            "\3\15\5\uffff\1\2\5\uffff\17\15\3\2",
            "\1\15\26\uffff\1\2\1\15\2\uffff\1\2\1\22\1\37\1\41\1\2\4\uffff"+
            "\2\2\1\uffff\3\15\3\uffff\1\35\1\40\1\15\3\uffff\1\2\1\uffff"+
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
            "",
            "",
            "\2\2\1\63\4\2\14\uffff\1\2\12\uffff\1\67\1\15\17\uffff\2\15"+
            "\1\66\24\uffff\3\2",
            "",
            "\2\15\1\101\4\15\14\uffff\1\15\1\2\2\uffff\3\2\3\uffff\1\2"+
            "\1\15\3\2\4\uffff\2\2\7\uffff\2\2\1\15\1\2\2\uffff\1\2\20\uffff"+
            "\3\15\16\2",
            "\2\2\1\132\4\2\14\uffff\1\2\12\uffff\1\131\1\15\17\uffff\2"+
            "\15\1\135\24\uffff\3\2",
            "\2\2\1\150\4\2\14\uffff\1\2\6\uffff\1\15\3\uffff\1\2\2\uffff"+
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
            ""
    };

    static final short[] DFA88_eot = DFA.unpackEncodedString(DFA88_eotS);
    static final short[] DFA88_eof = DFA.unpackEncodedString(DFA88_eofS);
    static final char[] DFA88_min = DFA.unpackEncodedStringToUnsignedChars(DFA88_minS);
    static final char[] DFA88_max = DFA.unpackEncodedStringToUnsignedChars(DFA88_maxS);
    static final short[] DFA88_accept = DFA.unpackEncodedString(DFA88_acceptS);
    static final short[] DFA88_special = DFA.unpackEncodedString(DFA88_specialS);
    static final short[][] DFA88_transition;

    static {
        int numStates = DFA88_transitionS.length;
        DFA88_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA88_transition[i] = DFA.unpackEncodedString(DFA88_transitionS[i]);
        }
    }

    class DFA88 extends DFA {

        public DFA88(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 88;
            this.eot = DFA88_eot;
            this.eof = DFA88_eof;
            this.min = DFA88_min;
            this.max = DFA88_max;
            this.accept = DFA88_accept;
            this.special = DFA88_special;
            this.transition = DFA88_transition;
        }
        public String getDescription() {
            return "1147:8: (par= expression ')' | typeRef ')' casted= expression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA88_36 = input.LA(1);

                         
                        int index88_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred129_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index88_36);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA88_51 = input.LA(1);

                         
                        int index88_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred129_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index88_51);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA88_54 = input.LA(1);

                         
                        int index88_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred129_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index88_54);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA88_55 = input.LA(1);

                         
                        int index88_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred129_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index88_55);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA88_65 = input.LA(1);

                         
                        int index88_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred129_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index88_65);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA88_89 = input.LA(1);

                         
                        int index88_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred129_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index88_89);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA88_90 = input.LA(1);

                         
                        int index88_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred129_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index88_90);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA88_93 = input.LA(1);

                         
                        int index88_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred129_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index88_93);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA88_104 = input.LA(1);

                         
                        int index88_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred129_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index88_104);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 88, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA91_eotS =
        "\146\uffff";
    static final String DFA91_eofS =
        "\1\1\145\uffff";
    static final String DFA91_minS =
        "\1\6\5\uffff\1\0\2\uffff\5\0\130\uffff";
    static final String DFA91_maxS =
        "\1\132\5\uffff\1\0\2\uffff\5\0\130\uffff";
    static final String DFA91_acceptS =
        "\1\uffff\1\6\30\uffff\1\2\15\uffff\1\1\1\4\2\uffff\1\3\70\uffff"+
        "\1\5";
    static final String DFA91_specialS =
        "\6\uffff\1\0\2\uffff\1\1\1\2\1\3\1\4\1\5\130\uffff}>";
    static final String[] DFA91_transitionS = {
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
            return "()* loopback of 1160:3: (bop= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA91_6 = input.LA(1);

                         
                        int index91_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_ObjCpp()) ) {s = 26;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index91_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA91_9 = input.LA(1);

                         
                        int index91_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_ObjCpp()) ) {s = 40;}

                        else if ( (synpred155_ObjCpp()) ) {s = 41;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index91_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA91_10 = input.LA(1);

                         
                        int index91_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 44;}

                        else if ( (synpred155_ObjCpp()) ) {s = 41;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index91_10);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA91_11 = input.LA(1);

                         
                        int index91_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 41;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index91_11);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA91_12 = input.LA(1);

                         
                        int index91_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_ObjCpp()) ) {s = 40;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index91_12);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA91_13 = input.LA(1);

                         
                        int index91_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred156_ObjCpp()) ) {s = 101;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index91_13);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 91, _s, input);
            error(nvae);
            throw nvae;
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
        "\1\uffff\1\2\1\1\33\uffff";
    static final String DFA92_specialS =
        "\36\uffff}>";
    static final String[] DFA92_transitionS = {
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
            return "()* loopback of 1189:8: ( statement )*";
        }
    }
    static final String DFA99_eotS =
        "\u012b\uffff";
    static final String DFA99_eofS =
        "\u012b\uffff";
    static final String DFA99_minS =
        "\2\4\2\uffff\1\6\30\uffff\1\6\1\42\3\4\6\30\1\4\21\uffff\1\4\6\uffff"+
        "\2\4\1\uffff\2\4\7\uffff\1\0\6\uffff\6\0\1\uffff\2\0\1\uffff\2\0"+
        "\1\uffff\60\0\2\uffff\6\0\2\uffff\6\0\2\uffff\6\0\2\uffff\6\0\2"+
        "\uffff\6\0\2\uffff\14\0\21\uffff\1\0\4\uffff\1\0\7\uffff\6\0\2\uffff"+
        "\2\0\2\uffff\1\0\12\uffff\1\0\1\uffff\1\0\1\uffff\1\0\12\uffff\1"+
        "\0\3\uffff\1\0\10\uffff\1\0\22\uffff";
    static final String DFA99_maxS =
        "\2\141\2\uffff\1\132\30\uffff\1\132\1\42\3\114\6\132\1\141\21\uffff"+
        "\1\114\6\uffff\2\114\1\uffff\2\114\7\uffff\1\0\6\uffff\6\0\1\uffff"+
        "\2\0\1\uffff\2\0\1\uffff\60\0\2\uffff\6\0\2\uffff\6\0\2\uffff\6"+
        "\0\2\uffff\6\0\2\uffff\6\0\2\uffff\14\0\21\uffff\1\0\4\uffff\1\0"+
        "\7\uffff\6\0\2\uffff\2\0\2\uffff\1\0\12\uffff\1\0\1\uffff\1\0\1"+
        "\uffff\1\0\12\uffff\1\0\3\uffff\1\0\10\uffff\1\0\22\uffff";
    static final String DFA99_acceptS =
        "\2\uffff\1\2\11\uffff\1\3\11\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
        "\14\uffff\1\1\u0100\uffff\1\13";
    static final String DFA99_specialS =
        "\115\uffff\1\0\6\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\7\1\10"+
        "\1\uffff\1\11\1\12\1\uffff\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1"+
        "\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36"+
        "\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53"+
        "\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70"+
        "\1\71\1\72\2\uffff\1\73\1\74\1\75\1\76\1\77\1\100\2\uffff\1\101"+
        "\1\102\1\103\1\104\1\105\1\106\2\uffff\1\107\1\110\1\111\1\112\1"+
        "\113\1\114\2\uffff\1\115\1\116\1\117\1\120\1\121\1\122\2\uffff\1"+
        "\123\1\124\1\125\1\126\1\127\1\130\2\uffff\1\131\1\132\1\133\1\134"+
        "\1\135\1\136\1\137\1\140\1\141\1\142\1\143\1\144\21\uffff\1\145"+
        "\4\uffff\1\146\7\uffff\1\147\1\150\1\151\1\152\1\153\1\154\2\uffff"+
        "\1\155\1\156\2\uffff\1\157\12\uffff\1\160\1\uffff\1\161\1\uffff"+
        "\1\162\12\uffff\1\163\3\uffff\1\164\10\uffff\1\165\22\uffff}>";
    static final String[] DFA99_transitionS = {
            "\2\14\1\4\4\14\14\uffff\1\1\1\uffff\2\2\1\uffff\1\34\1\uffff"+
            "\3\2\1\uffff\1\14\12\uffff\3\2\5\uffff\1\14\4\uffff\20\2\3\14"+
            "\16\uffff\1\26\1\27\1\uffff\1\30\1\31\1\32\1\33",
            "\1\42\1\47\1\35\1\43\1\44\1\45\1\46\14\uffff\1\50\3\51\1\uffff"+
            "\1\51\1\uffff\3\51\1\uffff\1\41\12\uffff\3\51\5\uffff\1\37\4"+
            "\uffff\20\51\1\36\2\40\16\uffff\2\51\1\uffff\4\51",
            "",
            "",
            "\1\2\25\uffff\2\14\1\2\2\uffff\1\14\1\72\1\uffff\1\105\1\14"+
            "\4\uffff\2\14\1\uffff\3\2\3\uffff\1\101\1\102\1\2\3\uffff\1"+
            "\104\1\uffff\17\2\3\uffff\16\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\51\21\uffff\1\14\3\uffff\1\51\1\125\1\51\2\uffff\1\127\1"+
            "\115\1\uffff\1\134\1\137\4\uffff\1\137\1\124\1\uffff\3\51\3"+
            "\uffff\1\130\1\133\1\51\3\uffff\1\136\1\uffff\17\51\3\uffff"+
            "\14\137\1\126\1\131",
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
            "\2\14\1\u00d8\4\14\14\uffff\1\14\6\uffff\1\u00e7\3\uffff\1"+
            "\u00dd\1\u00e5\10\uffff\1\2\3\u00e6\3\uffff\2\2\1\14\3\uffff"+
            "\1\2\1\uffff\4\u00e8\2\u00e9\11\u00ea\3\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "\2\14\1\u00ee\4\14\14\uffff\1\14\12\uffff\1\u00ed\20\uffff"+
            "\2\2\1\u00f1\3\uffff\1\2\20\uffff\3\14",
            "\2\14\1\u00fc\4\14\14\uffff\1\14\12\uffff\1\u0100\20\uffff"+
            "\2\2\1\u00fe\3\uffff\1\2\20\uffff\3\14",
            "",
            "\2\14\1\u010b\4\14\14\uffff\1\14\12\uffff\1\u010f\20\uffff"+
            "\2\2\1\14\3\uffff\1\2\20\uffff\3\14",
            "\2\14\1\u0118\4\14\14\uffff\1\14\6\uffff\1\2\3\uffff\1\14\2"+
            "\uffff\1\2\7\uffff\3\2\5\uffff\1\14\5\uffff\17\2\3\14",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            return "1191:1: statement : ( statementsBlock | declaration | expression ( '=' expression )? ';' | 'return' expression ';' | 'if' '(' expression ')' statement ( 'else' statement )? | 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA99_77 = input.LA(1);

                         
                        int index99_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_77);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA99_84 = input.LA(1);

                         
                        int index99_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_84);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA99_85 = input.LA(1);

                         
                        int index99_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_85);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA99_86 = input.LA(1);

                         
                        int index99_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_86);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA99_87 = input.LA(1);

                         
                        int index99_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_87);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA99_88 = input.LA(1);

                         
                        int index99_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_88);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA99_89 = input.LA(1);

                         
                        int index99_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_89);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA99_91 = input.LA(1);

                         
                        int index99_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_91);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA99_92 = input.LA(1);

                         
                        int index99_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_92);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA99_94 = input.LA(1);

                         
                        int index99_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_94);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA99_95 = input.LA(1);

                         
                        int index99_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_95);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA99_97 = input.LA(1);

                         
                        int index99_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_97);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA99_98 = input.LA(1);

                         
                        int index99_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_98);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA99_99 = input.LA(1);

                         
                        int index99_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_99);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA99_100 = input.LA(1);

                         
                        int index99_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_100);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA99_101 = input.LA(1);

                         
                        int index99_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_101);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA99_102 = input.LA(1);

                         
                        int index99_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_102);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA99_103 = input.LA(1);

                         
                        int index99_103 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_103);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA99_104 = input.LA(1);

                         
                        int index99_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_104);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA99_105 = input.LA(1);

                         
                        int index99_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_105);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA99_106 = input.LA(1);

                         
                        int index99_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_106);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA99_107 = input.LA(1);

                         
                        int index99_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_107);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA99_108 = input.LA(1);

                         
                        int index99_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_108);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA99_109 = input.LA(1);

                         
                        int index99_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_109);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA99_110 = input.LA(1);

                         
                        int index99_110 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_110);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA99_111 = input.LA(1);

                         
                        int index99_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_111);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA99_112 = input.LA(1);

                         
                        int index99_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_112);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA99_113 = input.LA(1);

                         
                        int index99_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_113);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA99_114 = input.LA(1);

                         
                        int index99_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_114);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA99_115 = input.LA(1);

                         
                        int index99_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_115);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA99_116 = input.LA(1);

                         
                        int index99_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_116);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA99_117 = input.LA(1);

                         
                        int index99_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_117);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA99_118 = input.LA(1);

                         
                        int index99_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_118);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA99_119 = input.LA(1);

                         
                        int index99_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_119);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA99_120 = input.LA(1);

                         
                        int index99_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_120);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA99_121 = input.LA(1);

                         
                        int index99_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_121);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA99_122 = input.LA(1);

                         
                        int index99_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_122);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA99_123 = input.LA(1);

                         
                        int index99_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_123);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA99_124 = input.LA(1);

                         
                        int index99_124 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_124);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA99_125 = input.LA(1);

                         
                        int index99_125 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_125);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA99_126 = input.LA(1);

                         
                        int index99_126 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_126);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA99_127 = input.LA(1);

                         
                        int index99_127 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_127);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA99_128 = input.LA(1);

                         
                        int index99_128 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_128);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA99_129 = input.LA(1);

                         
                        int index99_129 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_129);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA99_130 = input.LA(1);

                         
                        int index99_130 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_130);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA99_131 = input.LA(1);

                         
                        int index99_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_131);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA99_132 = input.LA(1);

                         
                        int index99_132 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_132);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA99_133 = input.LA(1);

                         
                        int index99_133 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_133);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA99_134 = input.LA(1);

                         
                        int index99_134 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_134);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA99_135 = input.LA(1);

                         
                        int index99_135 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_135);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA99_136 = input.LA(1);

                         
                        int index99_136 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_136);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA99_137 = input.LA(1);

                         
                        int index99_137 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_137);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA99_138 = input.LA(1);

                         
                        int index99_138 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_138);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA99_139 = input.LA(1);

                         
                        int index99_139 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_139);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA99_140 = input.LA(1);

                         
                        int index99_140 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_140);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA99_141 = input.LA(1);

                         
                        int index99_141 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_141);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA99_142 = input.LA(1);

                         
                        int index99_142 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_142);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA99_143 = input.LA(1);

                         
                        int index99_143 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_143);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA99_144 = input.LA(1);

                         
                        int index99_144 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_144);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA99_147 = input.LA(1);

                         
                        int index99_147 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_147);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA99_148 = input.LA(1);

                         
                        int index99_148 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_148);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA99_149 = input.LA(1);

                         
                        int index99_149 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_149);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA99_150 = input.LA(1);

                         
                        int index99_150 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_150);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA99_151 = input.LA(1);

                         
                        int index99_151 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_151);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA99_152 = input.LA(1);

                         
                        int index99_152 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_152);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA99_155 = input.LA(1);

                         
                        int index99_155 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_155);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA99_156 = input.LA(1);

                         
                        int index99_156 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_156);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA99_157 = input.LA(1);

                         
                        int index99_157 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_157);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA99_158 = input.LA(1);

                         
                        int index99_158 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_158);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA99_159 = input.LA(1);

                         
                        int index99_159 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_159);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA99_160 = input.LA(1);

                         
                        int index99_160 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_160);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA99_163 = input.LA(1);

                         
                        int index99_163 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_163);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA99_164 = input.LA(1);

                         
                        int index99_164 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_164);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA99_165 = input.LA(1);

                         
                        int index99_165 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_165);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA99_166 = input.LA(1);

                         
                        int index99_166 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_166);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA99_167 = input.LA(1);

                         
                        int index99_167 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_167);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA99_168 = input.LA(1);

                         
                        int index99_168 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_168);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA99_171 = input.LA(1);

                         
                        int index99_171 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_171);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA99_172 = input.LA(1);

                         
                        int index99_172 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_172);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA99_173 = input.LA(1);

                         
                        int index99_173 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_173);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA99_174 = input.LA(1);

                         
                        int index99_174 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_174);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA99_175 = input.LA(1);

                         
                        int index99_175 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_175);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA99_176 = input.LA(1);

                         
                        int index99_176 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_176);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA99_179 = input.LA(1);

                         
                        int index99_179 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_179);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA99_180 = input.LA(1);

                         
                        int index99_180 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_180);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA99_181 = input.LA(1);

                         
                        int index99_181 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_181);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA99_182 = input.LA(1);

                         
                        int index99_182 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_182);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA99_183 = input.LA(1);

                         
                        int index99_183 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_183);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA99_184 = input.LA(1);

                         
                        int index99_184 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_184);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA99_187 = input.LA(1);

                         
                        int index99_187 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_187);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA99_188 = input.LA(1);

                         
                        int index99_188 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_188);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA99_189 = input.LA(1);

                         
                        int index99_189 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_189);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA99_190 = input.LA(1);

                         
                        int index99_190 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_190);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA99_191 = input.LA(1);

                         
                        int index99_191 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_191);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA99_192 = input.LA(1);

                         
                        int index99_192 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_192);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA99_193 = input.LA(1);

                         
                        int index99_193 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_193);
                        if ( s>=0 ) return s;
                        break;
                    case 96 : 
                        int LA99_194 = input.LA(1);

                         
                        int index99_194 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_194);
                        if ( s>=0 ) return s;
                        break;
                    case 97 : 
                        int LA99_195 = input.LA(1);

                         
                        int index99_195 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_195);
                        if ( s>=0 ) return s;
                        break;
                    case 98 : 
                        int LA99_196 = input.LA(1);

                         
                        int index99_196 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_196);
                        if ( s>=0 ) return s;
                        break;
                    case 99 : 
                        int LA99_197 = input.LA(1);

                         
                        int index99_197 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_197);
                        if ( s>=0 ) return s;
                        break;
                    case 100 : 
                        int LA99_198 = input.LA(1);

                         
                        int index99_198 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_198);
                        if ( s>=0 ) return s;
                        break;
                    case 101 : 
                        int LA99_216 = input.LA(1);

                         
                        int index99_216 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 2;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                        else if ( (( next("foreach") )) ) {s = 298;}

                         
                        input.seek(index99_216);
                        if ( s>=0 ) return s;
                        break;
                    case 102 : 
                        int LA99_221 = input.LA(1);

                         
                        int index99_221 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 2;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_221);
                        if ( s>=0 ) return s;
                        break;
                    case 103 : 
                        int LA99_229 = input.LA(1);

                         
                        int index99_229 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 2;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_229);
                        if ( s>=0 ) return s;
                        break;
                    case 104 : 
                        int LA99_230 = input.LA(1);

                         
                        int index99_230 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 298;}

                         
                        input.seek(index99_230);
                        if ( s>=0 ) return s;
                        break;
                    case 105 : 
                        int LA99_231 = input.LA(1);

                         
                        int index99_231 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 298;}

                         
                        input.seek(index99_231);
                        if ( s>=0 ) return s;
                        break;
                    case 106 : 
                        int LA99_232 = input.LA(1);

                         
                        int index99_232 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 298;}

                         
                        input.seek(index99_232);
                        if ( s>=0 ) return s;
                        break;
                    case 107 : 
                        int LA99_233 = input.LA(1);

                         
                        int index99_233 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 298;}

                         
                        input.seek(index99_233);
                        if ( s>=0 ) return s;
                        break;
                    case 108 : 
                        int LA99_234 = input.LA(1);

                         
                        int index99_234 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 298;}

                         
                        input.seek(index99_234);
                        if ( s>=0 ) return s;
                        break;
                    case 109 : 
                        int LA99_237 = input.LA(1);

                         
                        int index99_237 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 2;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_237);
                        if ( s>=0 ) return s;
                        break;
                    case 110 : 
                        int LA99_238 = input.LA(1);

                         
                        int index99_238 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 2;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_238);
                        if ( s>=0 ) return s;
                        break;
                    case 111 : 
                        int LA99_241 = input.LA(1);

                         
                        int index99_241 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 2;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_241);
                        if ( s>=0 ) return s;
                        break;
                    case 112 : 
                        int LA99_252 = input.LA(1);

                         
                        int index99_252 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 2;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_252);
                        if ( s>=0 ) return s;
                        break;
                    case 113 : 
                        int LA99_254 = input.LA(1);

                         
                        int index99_254 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 2;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_254);
                        if ( s>=0 ) return s;
                        break;
                    case 114 : 
                        int LA99_256 = input.LA(1);

                         
                        int index99_256 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 2;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_256);
                        if ( s>=0 ) return s;
                        break;
                    case 115 : 
                        int LA99_267 = input.LA(1);

                         
                        int index99_267 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 2;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_267);
                        if ( s>=0 ) return s;
                        break;
                    case 116 : 
                        int LA99_271 = input.LA(1);

                         
                        int index99_271 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 2;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_271);
                        if ( s>=0 ) return s;
                        break;
                    case 117 : 
                        int LA99_280 = input.LA(1);

                         
                        int index99_280 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 2;}

                        else if ( (synpred161_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index99_280);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 99, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA94_eotS =
        "\77\uffff";
    static final String DFA94_eofS =
        "\1\2\76\uffff";
    static final String DFA94_minS =
        "\1\4\1\0\75\uffff";
    static final String DFA94_maxS =
        "\1\142\1\0\75\uffff";
    static final String DFA94_acceptS =
        "\2\uffff\1\2\73\uffff\1\1";
    static final String DFA94_specialS =
        "\1\uffff\1\0\75\uffff}>";
    static final String[] DFA94_transitionS = {
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
            return "1197:37: ( 'else' statement )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA94_1 = input.LA(1);

                         
                        int index94_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 62;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index94_1);
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
    static final String DFA95_eotS =
        "\107\uffff";
    static final String DFA95_eofS =
        "\107\uffff";
    static final String DFA95_minS =
        "\1\4\33\uffff\2\4\14\uffff\1\0\2\uffff\1\0\7\uffff\12\0\6\uffff"+
        "\1\0\1\uffff";
    static final String DFA95_maxS =
        "\1\141\33\uffff\1\114\1\141\14\uffff\1\0\2\uffff\1\0\7\uffff\12"+
        "\0\6\uffff\1\0\1\uffff";
    static final String DFA95_acceptS =
        "\1\uffff\1\1\34\uffff\1\2\50\uffff";
    static final String DFA95_specialS =
        "\52\uffff\1\0\2\uffff\1\1\7\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1"+
        "\11\1\12\1\13\6\uffff\1\14\1\uffff}>";
    static final String[] DFA95_transitionS = {
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
            "\7\36\14\uffff\1\36\4\uffff\1\35\5\uffff\1\36\22\uffff\1\36"+
            "\24\uffff\3\36",
            "\1\71\1\76\1\55\1\72\1\73\1\74\1\75\14\uffff\1\52\1\uffff\2"+
            "\36\1\uffff\1\105\1\uffff\3\36\1\uffff\1\70\1\36\11\uffff\3"+
            "\36\5\uffff\1\66\4\uffff\20\36\1\65\2\67\16\uffff\2\36\1\uffff"+
            "\4\36",
            "",
            "",
            "",
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
            return "1200:13: ( statement )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA95_42 = input.LA(1);

                         
                        int index95_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index95_42);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA95_45 = input.LA(1);

                         
                        int index95_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index95_45);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA95_53 = input.LA(1);

                         
                        int index95_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index95_53);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA95_54 = input.LA(1);

                         
                        int index95_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index95_54);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA95_55 = input.LA(1);

                         
                        int index95_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index95_55);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA95_56 = input.LA(1);

                         
                        int index95_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index95_56);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA95_57 = input.LA(1);

                         
                        int index95_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index95_57);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA95_58 = input.LA(1);

                         
                        int index95_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index95_58);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA95_59 = input.LA(1);

                         
                        int index95_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index95_59);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA95_60 = input.LA(1);

                         
                        int index95_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index95_60);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA95_61 = input.LA(1);

                         
                        int index95_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index95_61);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA95_62 = input.LA(1);

                         
                        int index95_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index95_62);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA95_69 = input.LA(1);

                         
                        int index95_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index95_69);
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
        "\16\uffff";
    static final String DFA96_eofS =
        "\16\uffff";
    static final String DFA96_minS =
        "\1\4\15\uffff";
    static final String DFA96_maxS =
        "\1\114\15\uffff";
    static final String DFA96_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA96_specialS =
        "\16\uffff}>";
    static final String[] DFA96_transitionS = {
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
            return "1200:28: ( expression )?";
        }
    }
    static final String DFA97_eotS =
        "\36\uffff";
    static final String DFA97_eofS =
        "\36\uffff";
    static final String DFA97_minS =
        "\1\4\35\uffff";
    static final String DFA97_maxS =
        "\1\141\35\uffff";
    static final String DFA97_acceptS =
        "\1\uffff\1\1\33\uffff\1\2";
    static final String DFA97_specialS =
        "\36\uffff}>";
    static final String[] DFA97_transitionS = {
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
            return "1200:44: ( statement )?";
        }
    }
    static final String DFA98_eotS =
        "\37\uffff";
    static final String DFA98_eofS =
        "\37\uffff";
    static final String DFA98_minS =
        "\1\4\36\uffff";
    static final String DFA98_maxS =
        "\1\142\36\uffff";
    static final String DFA98_acceptS =
        "\1\uffff\1\3\1\1\1\2\33\uffff";
    static final String DFA98_specialS =
        "\37\uffff}>";
    static final String[] DFA98_transitionS = {
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
            return "()* loopback of 1202:3: ( 'case' expression ':' | statement )*";
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
    public static final BitSet FOLLOW_48_in_structCore1186 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_49_in_structCore1199 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_50_in_structCore1212 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_structCore1224 = new BitSet(new long[]{0xFC07E001C7000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_declaration_in_structCore1233 = new BitSet(new long[]{0xFC07E001C7000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_24_in_structCore1247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRef_in_functionDeclaration1277 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_exportationModifiers_in_functionDeclaration1286 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionDeclaration1294 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionDeclaration1301 = new BitSet(new long[]{0xF800F00840000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_argList_in_functionDeclaration1307 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionDeclaration1313 = new BitSet(new long[]{0x0000000010800040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionDeclaration1322 = new BitSet(new long[]{0x0000000010800040L});
    public static final BitSet FOLLOW_exportationModifiers_in_functionDeclaration1331 = new BitSet(new long[]{0x0000000010800040L});
    public static final BitSet FOLLOW_28_in_functionDeclaration1343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_functionDeclaration1350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_functionDefinition1367 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_functionDefinition1369 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_functionDefinition1371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exportationModifier_in_exportationModifiers1398 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier1425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_exportationModifier1457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_exportationModifier1466 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_exportationModifier1474 = new BitSet(new long[]{0x0000000800000040L});
    public static final BitSet FOLLOW_extendedModifiers_in_exportationModifier1476 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_exportationModifier1478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_extendedModifiers1513 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_typeRef_in_argDef1556 = new BitSet(new long[]{0x0218000420000042L});
    public static final BitSet FOLLOW_declarator_in_argDef1567 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_argDef1587 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_argDef1589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_argDef1603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_typeMutator1623 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_typeMutator1625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_typeMutator1633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_typeMutator1641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_typeMutator1650 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_typeMutator1652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_arrayTypeMutator1670 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_arrayTypeMutator1676 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_arrayTypeMutator1685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_typeRefCore1712 = new BitSet(new long[]{0xF800000000000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_modifier_in_typeRefCore1729 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_typeRef_in_typeRefCore1738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveTypeRef_in_typeRefCore1758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_typeRefCore1773 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_typeRefCore1791 = new BitSet(new long[]{0xF800E02040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_typeRef_in_typeRefCore1812 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_27_in_typeRefCore1833 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_typeRef_in_typeRefCore1846 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_37_in_typeRefCore1874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_templateDef1906 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_templateDef1908 = new BitSet(new long[]{0xF900402000000000L,0x00000000000003FFL});
    public static final BitSet FOLLOW_templateArgDecl_in_templateDef1911 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_27_in_templateDef1914 = new BitSet(new long[]{0xF900400000000000L,0x00000000000003FFL});
    public static final BitSet FOLLOW_templateArgDecl_in_templateDef1916 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_37_in_templateDef1923 = new BitSet(new long[]{0x0000E00000000000L});
    public static final BitSet FOLLOW_structCore_in_templateDef1927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDefinition_in_templateDef1931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveTypeRef_in_templateArgDecl1943 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_templateArgDecl1946 = new BitSet(new long[]{0x00000000000007B0L});
    public static final BitSet FOLLOW_constant_in_templateArgDecl1948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_templateArgDecl1955 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_templateArgDecl1963 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_templateArgDecl1966 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_typeRef_in_templateArgDecl1968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffix1987 = new BitSet(new long[]{0x0008000000000040L});
    public static final BitSet FOLLOW_exportationModifiers_in_functionSignatureSuffix1989 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_functionSignatureSuffix1991 = new BitSet(new long[]{0x0000000800000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionSignatureSuffix1993 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffix1996 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffix2002 = new BitSet(new long[]{0xF800F00840000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffix2011 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_27_in_functionSignatureSuffix2024 = new BitSet(new long[]{0xF800F00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffix2033 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffix2048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffixNoName2065 = new BitSet(new long[]{0x0008000000000040L});
    public static final BitSet FOLLOW_exportationModifiers_in_functionSignatureSuffixNoName2067 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_functionSignatureSuffixNoName2069 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffixNoName2071 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffixNoName2077 = new BitSet(new long[]{0xF800F00840000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffixNoName2086 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_27_in_functionSignatureSuffixNoName2099 = new BitSet(new long[]{0xF800F00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffixNoName2108 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffixNoName2123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structCore_in_structOrEnum2141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumCore_in_structOrEnum2149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefCore_in_typeRefCoreOrFuncSig2167 = new BitSet(new long[]{0x0038000400000042L});
    public static final BitSet FOLLOW_typeMutator_in_typeRefCoreOrFuncSig2184 = new BitSet(new long[]{0x0038000400000040L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_typeRefCoreOrFuncSig2197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefCore_in_typeRefCoreOrAnonymousFuncSig2221 = new BitSet(new long[]{0x0038000400000042L});
    public static final BitSet FOLLOW_typeMutator_in_typeRefCoreOrAnonymousFuncSig2238 = new BitSet(new long[]{0x0038000400000040L});
    public static final BitSet FOLLOW_functionSignatureSuffixNoName_in_typeRefCoreOrAnonymousFuncSig2251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structOrEnum_in_plainTypeRef2278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefCoreOrFuncSig_in_plainTypeRef2286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_declarator2315 = new BitSet(new long[]{0x0218000400000040L});
    public static final BitSet FOLLOW_set_in_declarator2352 = new BitSet(new long[]{0x0218000400000040L});
    public static final BitSet FOLLOW_declarator_in_declarator2371 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_directDeclarator_in_declarator2387 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_declarator2406 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_declarator2413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structCore_in_namedTypeRef2447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumCore_in_namedTypeRef2457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_typeDef2476 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_varDecl_in_typeDef2482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_varDeclEOF2502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_varDeclEOF2504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_varDecl2541 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_modifier_in_varDecl2558 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_structOrEnum_in_varDecl2585 = new BitSet(new long[]{0x0218000410000040L});
    public static final BitSet FOLLOW_declaratorsList_in_varDecl2602 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_typeRefCoreOrAnonymousFuncSig_in_varDecl2622 = new BitSet(new long[]{0x0218000400000040L});
    public static final BitSet FOLLOW_declaratorsList_in_varDecl2632 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_varDecl2669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_objCProtocolRefList2683 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCProtocolRefList2688 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_27_in_objCProtocolRefList2698 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCProtocolRefList2704 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_37_in_objCProtocolRefList2714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarator_in_declaratorsList2741 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_declaratorsList2754 = new BitSet(new long[]{0x0218000400000040L});
    public static final BitSet FOLLOW_declarator_in_declaratorsList2763 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_directDeclarator2806 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_34_in_directDeclarator2816 = new BitSet(new long[]{0x0218000400000040L});
    public static final BitSet FOLLOW_modifier_in_directDeclarator2825 = new BitSet(new long[]{0x0218000400000040L});
    public static final BitSet FOLLOW_declarator_in_directDeclarator2836 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_directDeclarator2842 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_53_in_directDeclarator2857 = new BitSet(new long[]{0x00600004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_directDeclarator2869 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_directDeclarator2885 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_34_in_directDeclarator2893 = new BitSet(new long[]{0xF800F00840000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_argList_in_directDeclarator2895 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_directDeclarator2897 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_argDef_in_argList2930 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_argList2943 = new BitSet(new long[]{0xF800F00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_argDef_in_argList2952 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_argList2972 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_argList2974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plainTypeRef_in_typeRef3008 = new BitSet(new long[]{0x0038000000000042L});
    public static final BitSet FOLLOW_typeMutator_in_typeRef3019 = new BitSet(new long[]{0x0038000000000042L});
    public static final BitSet FOLLOW_set_in_primSignModifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_primSizeModifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_primitiveTypeName0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primSignModifier_in_primitiveTypeRef3158 = new BitSet(new long[]{0xF800000000000000L,0x00000000000003FFL});
    public static final BitSet FOLLOW_primSizeModifier_in_primitiveTypeRef3169 = new BitSet(new long[]{0xF800000000000000L,0x00000000000003FFL});
    public static final BitSet FOLLOW_primSizeModifier_in_primitiveTypeRef3176 = new BitSet(new long[]{0xF800000000000000L,0x00000000000003FFL});
    public static final BitSet FOLLOW_primitiveTypeName_in_primitiveTypeRef3219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_objCMethodCall3258 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3262 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodCall3266 = new BitSet(new long[]{0x0040000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodCall3277 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3281 = new BitSet(new long[]{0x0040000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodCall3296 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodCall3298 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3302 = new BitSet(new long[]{0x0040000000000040L});
    public static final BitSet FOLLOW_54_in_objCMethodCall3319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_functionCall3339 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionCall3341 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_typeRef_in_functionCall3343 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionCall3345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionCall3353 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionCall3355 = new BitSet(new long[]{0x0020000C008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_functionCall3368 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_27_in_functionCall3377 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_functionCall3386 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_35_in_functionCall3404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_expression3426 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_functionCall_in_expression3437 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_objCMethodCall_in_expression3446 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_set_in_expression3457 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_expression3467 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_34_in_expression3476 = new BitSet(new long[]{0xF820E004408007F0L,0x0000000000001FFFL});
    public static final BitSet FOLLOW_expression_in_expression3486 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_expression3488 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_typeRef_in_expression3498 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_expression3500 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_expression3504 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_constant_in_expression3519 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_23_in_expression3528 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_expression3530 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_expression3532 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_set_in_expression3548 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_expression3642 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_29_in_expression3651 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_expression3655 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_89_in_expression3664 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_expression3668 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_33_in_expression3680 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_expression3682 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_43_in_expression3686 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_expression3688 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_89_in_expression3692 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_functionCall_in_expression3697 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_90_in_expression3706 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_expression3710 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_expression3712 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_expression3716 = new BitSet(new long[]{0x02180C3220000002L,0x0000000007FFE000L});
    public static final BitSet FOLLOW_23_in_statementsBlock3737 = new BitSet(new long[]{0xFC20E005D78007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statementsBlock3739 = new BitSet(new long[]{0xFC20E005D78007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_24_in_statementsBlock3742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_statement3755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_statement3761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement3767 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_statement3770 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3772 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_statement3783 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3785 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_statement3793 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3795 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3797 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3799 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3801 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_statement3804 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_statement3814 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3816 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3818 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3820 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_statement3828 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3830 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_statement3832 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3834 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3836 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3838 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_statement3846 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3848 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3850 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3853 = new BitSet(new long[]{0x00200004108007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3855 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3858 = new BitSet(new long[]{0xFC20E00DD68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3860 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3863 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_statement3871 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3873 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3875 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3877 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_statement3879 = new BitSet(new long[]{0xFC20E005D78007F0L,0x00000007D8001FFFL});
    public static final BitSet FOLLOW_98_in_statement3885 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3887 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement3889 = new BitSet(new long[]{0xFC20E005D78007F0L,0x00000007D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3896 = new BitSet(new long[]{0xFC20E005D78007F0L,0x00000007D8001FFFL});
    public static final BitSet FOLLOW_24_in_statement3905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_statement3911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement3919 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3921 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_varDecl_in_statement3923 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement3925 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_statement3927 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3929 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_statement3931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_constant3947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEXADECIMAL_NUMBER_in_constant3955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OCTAL_NUMBER_in_constant3963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARACTER_in_constant3971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_NUMBER_in_constant3979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_constant3990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_synpred6_ObjCpp247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred7_ObjCpp257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred26_ObjCpp775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred40_ObjCpp1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exportationModifiers_in_synpred41_ObjCpp1136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRef_in_synpred47_ObjCpp1277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred48_ObjCpp1322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exportationModifier_in_synpred50_ObjCpp1398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred59_ObjCpp1712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred60_ObjCpp1729 = new BitSet(new long[]{0xF800E00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_typeRef_in_synpred60_ObjCpp1738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred77_ObjCpp2184 = new BitSet(new long[]{0x0038000400000040L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_synpred77_ObjCpp2197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred79_ObjCpp2238 = new BitSet(new long[]{0x0038000400000040L});
    public static final BitSet FOLLOW_functionSignatureSuffixNoName_in_synpred79_ObjCpp2251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred81_ObjCpp2315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred85_ObjCpp2406 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_synpred85_ObjCpp2413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred87_ObjCpp2541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred88_ObjCpp2558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred94_ObjCpp2825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_synpred98_ObjCpp2943 = new BitSet(new long[]{0xF800F00040000040L,0x00000000000003FFL});
    public static final BitSet FOLLOW_argDef_in_synpred98_ObjCpp2952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred101_ObjCpp3019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred129_ObjCpp3486 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred129_ObjCpp3488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred150_ObjCpp3548 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_synpred150_ObjCpp3642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred151_ObjCpp3651 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_synpred151_ObjCpp3655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_synpred152_ObjCpp3664 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred152_ObjCpp3668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_synpred155_ObjCpp3680 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_synpred155_ObjCpp3682 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_43_in_synpred155_ObjCpp3686 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_synpred155_ObjCpp3688 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_89_in_synpred155_ObjCpp3692 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_functionCall_in_synpred155_ObjCpp3697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_synpred156_ObjCpp3706 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_synpred156_ObjCpp3710 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_synpred156_ObjCpp3712 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_synpred156_ObjCpp3716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_synpred158_ObjCpp3755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_synpred159_ObjCpp3761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred161_ObjCpp3767 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_synpred161_ObjCpp3770 = new BitSet(new long[]{0x00200004008007F0L,0x0000000000001C00L});
    public static final BitSet FOLLOW_expression_in_synpred161_ObjCpp3772 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_synpred161_ObjCpp3777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_synpred163_ObjCpp3804 = new BitSet(new long[]{0xFC20E005D68007F0L,0x00000003D8001FFFL});
    public static final BitSet FOLLOW_statement_in_synpred163_ObjCpp3806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_synpred167_ObjCpp3850 = new BitSet(new long[]{0x0000000000000002L});

}