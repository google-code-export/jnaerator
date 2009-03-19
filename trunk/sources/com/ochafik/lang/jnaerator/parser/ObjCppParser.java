// $ANTLR 3.1.2 /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g 2009-03-19 02:40:30
 
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DECIMAL_NUMBER", "STRING", "IDENTIFIER", "HEXADECIMAL_NUMBER", "OCTAL_NUMBER", "CHARACTER", "FLOAT_NUMBER", "Letter", "FloatingPointExponentSuffix", "FloatingPointConstantSuffix", "OctalEscape", "CharEscape", "HexDigit", "UnicodeEscape", "IntegerConstantSuffix", "WS", "COMMENT", "LINE_COMMENT", "'#line'", "'{'", "'}'", "'namespace'", "'@class'", "','", "';'", "'='", "'enum'", "'@protocol'", "'@interface'", "':'", "'('", "')'", "'<'", "'>'", "'@public'", "'@private'", "'@protected'", "'@end'", "'+'", "'-'", "'...'", "'struct'", "'class'", "'union'", "'public'", "'private'", "'protected'", "'*'", "'&'", "'['", "']'", "'return'", "'template'", "'typename'", "'^'", "'typedef'", "'signed'", "'unsigned'", "'__signed'", "'__unsigned'", "'long'", "'short'", "'int'", "'double'", "'float'", "'char'", "'void'", "'__int8'", "'__int16'", "'__int32'", "'__int64'", "'sizeof'", "'/'", "'%'", "'<<'", "'>>>'", "'>>'", "'||'", "'|'", "'&&'", "'<='", "'>='", "'=='", "'!='", "'!'", "'~'", "'.'", "'?'", "'if'", "'else'", "'while'", "'do'", "'for'", "'switch'", "'case'"
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
               retval.sourceFile = new SourceFile(); 
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

            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_sourceFile148); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:217:1: externDeclarations returns [List<Declaration> declarations] : {...}? IDENTIFIER STRING '{' (ed= declaration )* '}' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:218:2: ({...}? IDENTIFIER STRING '{' (ed= declaration )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:218:4: {...}? IDENTIFIER STRING '{' (ed= declaration )* '}'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.declarations = new ArrayList<Declaration>(); 
            }
            if ( !(( next("extern") )) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "externDeclarations", " next(\"extern\") ");
            }
            IDENTIFIER4=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_externDeclarations169); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER4_tree = (Object)adaptor.create(IDENTIFIER4);
            adaptor.addChild(root_0, IDENTIFIER4_tree);
            }
            STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_externDeclarations173); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING5_tree = (Object)adaptor.create(STRING5);
            adaptor.addChild(root_0, STRING5_tree);
            }
            char_literal6=(Token)match(input,23,FOLLOW_23_in_externDeclarations178); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal6_tree = (Object)adaptor.create(char_literal6);
            adaptor.addChild(root_0, char_literal6_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:222:4: (ed= declaration )*
            loop4:
            do {
                int alt4=2;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:223:5: ed= declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_externDeclarations192);
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

            char_literal7=(Token)match(input,24,FOLLOW_24_in_externDeclarations205); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:230:1: declaration returns [List<Declaration> declarations, List<Modifier> modifiers, String preComment, int startTokenIndex] : ( ( functionDeclaration | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) ) ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:231:2: ( ( ( functionDeclaration | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:232:3: ( ( functionDeclaration | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.declarations = new ArrayList<Declaration>(); 
              		  retval.modifiers = new ArrayList<Modifier>();
              		  retval.startTokenIndex = getTokenStream().index();
              		  retval.preComment = getCommentBefore(retval.startTokenIndex);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:237:3: ( ( functionDeclaration | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:244:4: ( functionDeclaration | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:244:4: ( functionDeclaration | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )
            int alt6=6;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:246:5: functionDeclaration
                    {
                    pushFollow(FOLLOW_functionDeclaration_in_declaration249);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:249:5: varDecl
                    {
                    pushFollow(FOLLOW_varDecl_in_declaration259);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:252:5: objCClassDef
                    {
                    pushFollow(FOLLOW_objCClassDef_in_declaration269);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:255:5: typeDef
                    {
                    pushFollow(FOLLOW_typeDef_in_declaration279);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:258:5: forwardClassDecl
                    {
                    pushFollow(FOLLOW_forwardClassDecl_in_declaration289);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:261:5: 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}'
                    {
                    string_literal13=(Token)match(input,25,FOLLOW_25_in_declaration299); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal13_tree = (Object)adaptor.create(string_literal13);
                    adaptor.addChild(root_0, string_literal13_tree);
                    }
                    ns=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration303); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ns_tree = (Object)adaptor.create(ns);
                    adaptor.addChild(root_0, ns_tree);
                    }
                    char_literal14=(Token)match(input,23,FOLLOW_23_in_declaration305); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal14_tree = (Object)adaptor.create(char_literal14);
                    adaptor.addChild(root_0, char_literal14_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:262:6: (subD= declaration )*
                    loop5:
                    do {
                        int alt5=2;
                        alt5 = dfa5.predict(input);
                        switch (alt5) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:263:7: subD= declaration
                    	    {
                    	    pushFollow(FOLLOW_declaration_in_declaration323);
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

                    char_literal15=(Token)match(input,24,FOLLOW_24_in_declaration339); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:288:1: forwardClassDecl returns [List<Declaration> declarations] : '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:289:2: ( '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:289:5: '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.declarations = new ArrayList<Declaration>(); 
            }
            string_literal16=(Token)match(input,26,FOLLOW_26_in_forwardClassDecl379); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal16_tree = (Object)adaptor.create(string_literal16);
            adaptor.addChild(root_0, string_literal16_tree);
            }
            n1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_forwardClassDecl386); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n1_tree = (Object)adaptor.create(n1);
            adaptor.addChild(root_0, n1_tree);
            }
            if ( state.backtracking==0 ) {
               retval.declarations.add(decl(Struct.forwardDecl((n1!=null?n1.getText():null), Struct.Type.ObjCClass))); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:292:3: ( ',' nx= IDENTIFIER )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==27) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:292:4: ',' nx= IDENTIFIER
            	    {
            	    char_literal17=(Token)match(input,27,FOLLOW_27_in_forwardClassDecl393); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal17_tree = (Object)adaptor.create(char_literal17);
            	    adaptor.addChild(root_0, char_literal17_tree);
            	    }
            	    nx=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_forwardClassDecl400); if (state.failed) return retval;
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

            char_literal18=(Token)match(input,28,FOLLOW_28_in_forwardClassDecl411); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:298:1: functionPointerVarDecl returns [List<? extends Declaration> declarations] : typeRef {...}? ';' ;
    public final ObjCppParser.functionPointerVarDecl_return functionPointerVarDecl() throws RecognitionException {
        ObjCppParser.functionPointerVarDecl_return retval = new ObjCppParser.functionPointerVarDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal20=null;
        ObjCppParser.typeRef_return typeRef19 = null;


        Object char_literal20_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:299:2: ( typeRef {...}? ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:299:4: typeRef {...}? ';'
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_typeRef_in_functionPointerVarDecl429);
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
            char_literal20=(Token)match(input,28,FOLLOW_28_in_functionPointerVarDecl437); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:308:1: enumItem returns [Enum.EnumItem item] : n= IDENTIFIER ( '=' v= expression )? ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:309:2: (n= IDENTIFIER ( '=' v= expression )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:309:4: n= IDENTIFIER ( '=' v= expression )?
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumItem455); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:309:17: ( '=' v= expression )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==29) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:309:18: '=' v= expression
                    {
                    char_literal21=(Token)match(input,29,FOLLOW_29_in_enumItem458); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal21_tree = (Object)adaptor.create(char_literal21);
                    adaptor.addChild(root_0, char_literal21_tree);
                    }
                    pushFollow(FOLLOW_expression_in_enumItem462);
                    v=expression();

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

    public static class enumCore_return extends ParserRuleReturnScope {
        public Enum e;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "enumCore"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:316:1: enumCore returns [Enum e] : t= 'enum' (n1= IDENTIFIER )? '{' i1= enumItem ( ',' (ix= enumItem )? )* '}' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:317:2: (t= 'enum' (n1= IDENTIFIER )? '{' i1= enumItem ( ',' (ix= enumItem )? )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:318:3: t= 'enum' (n1= IDENTIFIER )? '{' i1= enumItem ( ',' (ix= enumItem )? )* '}'
            {
            root_0 = (Object)adaptor.nil();

            t=(Token)match(input,30,FOLLOW_30_in_enumCore486); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            t_tree = (Object)adaptor.create(t);
            adaptor.addChild(root_0, t_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.e = mark(new Enum(), getLine(t));
              			retval.e.setCommentBefore(getCommentBefore(t.getTokenIndex()));
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:321:5: (n1= IDENTIFIER )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==IDENTIFIER) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:322:4: n1= IDENTIFIER
                    {
                    n1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumCore497); if (state.failed) return retval;
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

            char_literal22=(Token)match(input,23,FOLLOW_23_in_enumCore509); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal22_tree = (Object)adaptor.create(char_literal22);
            adaptor.addChild(root_0, char_literal22_tree);
            }
            pushFollow(FOLLOW_enumItem_in_enumCore516);
            i1=enumItem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, i1.getTree());
            if ( state.backtracking==0 ) {
               
              				retval.e.addItem((i1!=null?i1.item:null)); 
              			
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:330:4: ( ',' (ix= enumItem )? )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==27) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:331:5: ',' (ix= enumItem )?
            	    {
            	    char_literal23=(Token)match(input,27,FOLLOW_27_in_enumCore529); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal23_tree = (Object)adaptor.create(char_literal23);
            	    adaptor.addChild(root_0, char_literal23_tree);
            	    }
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:332:5: (ix= enumItem )?
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( (LA10_0==IDENTIFIER) ) {
            	        alt10=1;
            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:332:6: ix= enumItem
            	            {
            	            pushFollow(FOLLOW_enumItem_in_enumCore539);
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

            char_literal24=(Token)match(input,24,FOLLOW_24_in_enumCore553); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:347:1: objCClassDef returns [Struct struct] : octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl {...}?)* '@end' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:348:2: (octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl {...}?)* '@end' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:349:3: octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl {...}?)* '@end'
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

            className=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef591); if (state.failed) return retval;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:359:3: ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' )
            int alt13=2;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:360:4: ( ':' parentClass= IDENTIFIER )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:360:4: ( ':' parentClass= IDENTIFIER )?
                    int alt12=2;
                    alt12 = dfa12.predict(input);
                    switch (alt12) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:361:5: ':' parentClass= IDENTIFIER
                            {
                            char_literal25=(Token)match(input,33,FOLLOW_33_in_objCClassDef609); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal25_tree = (Object)adaptor.create(char_literal25);
                            adaptor.addChild(root_0, char_literal25_tree);
                            }
                            parentClass=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef613); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:366:4: '(' categoryName= IDENTIFIER ')'
                    {
                    char_literal26=(Token)match(input,34,FOLLOW_34_in_objCClassDef628); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal26_tree = (Object)adaptor.create(char_literal26);
                    adaptor.addChild(root_0, char_literal26_tree);
                    }
                    categoryName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef632); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    categoryName_tree = (Object)adaptor.create(categoryName);
                    adaptor.addChild(root_0, categoryName_tree);
                    }
                    char_literal27=(Token)match(input,35,FOLLOW_35_in_objCClassDef634); if (state.failed) return retval;
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:370:3: ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )?
            int alt16=2;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:371:4: '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>'
                    {
                    char_literal28=(Token)match(input,36,FOLLOW_36_in_objCClassDef650); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal28_tree = (Object)adaptor.create(char_literal28);
                    adaptor.addChild(root_0, char_literal28_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:371:8: (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==IDENTIFIER) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:372:5: p1= IDENTIFIER ( ',' px= IDENTIFIER )*
                            {
                            p1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef660); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            p1_tree = (Object)adaptor.create(p1);
                            adaptor.addChild(root_0, p1_tree);
                            }
                            if ( state.backtracking==0 ) {
                               retval.struct.addProtocol((p1!=null?p1.getText():null)); 
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:373:5: ( ',' px= IDENTIFIER )*
                            loop14:
                            do {
                                int alt14=2;
                                int LA14_0 = input.LA(1);

                                if ( (LA14_0==27) ) {
                                    alt14=1;
                                }


                                switch (alt14) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:374:6: ',' px= IDENTIFIER
                            	    {
                            	    char_literal29=(Token)match(input,27,FOLLOW_27_in_objCClassDef675); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    char_literal29_tree = (Object)adaptor.create(char_literal29);
                            	    adaptor.addChild(root_0, char_literal29_tree);
                            	    }
                            	    px=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef685); if (state.failed) return retval;
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

                    char_literal30=(Token)match(input,37,FOLLOW_37_in_objCClassDef702); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal30_tree = (Object)adaptor.create(char_literal30);
                    adaptor.addChild(root_0, char_literal30_tree);
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:379:3: ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )?
            int alt19=2;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:380:4: '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}'
                    {
                    char_literal31=(Token)match(input,23,FOLLOW_23_in_objCClassDef716); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal31_tree = (Object)adaptor.create(char_literal31);
                    adaptor.addChild(root_0, char_literal31_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:381:4: ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )*
                    loop18:
                    do {
                        int alt18=5;
                        alt18 = dfa18.predict(input);
                        switch (alt18) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:382:5: '@public'
                    	    {
                    	    string_literal32=(Token)match(input,38,FOLLOW_38_in_objCClassDef728); if (state.failed) return retval;
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
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:383:5: '@private'
                    	    {
                    	    string_literal33=(Token)match(input,39,FOLLOW_39_in_objCClassDef739); if (state.failed) return retval;
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
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:384:5: '@protected'
                    	    {
                    	    string_literal34=(Token)match(input,40,FOLLOW_40_in_objCClassDef750); if (state.failed) return retval;
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
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:385:5: ( (fv= varDecl | functionPointerVarDecl ) )
                    	    {
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:385:5: ( (fv= varDecl | functionPointerVarDecl ) )
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:386:6: (fv= varDecl | functionPointerVarDecl )
                    	    {
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:386:6: (fv= varDecl | functionPointerVarDecl )
                    	    int alt17=2;
                    	    alt17 = dfa17.predict(input);
                    	    switch (alt17) {
                    	        case 1 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:387:7: fv= varDecl
                    	            {
                    	            pushFollow(FOLLOW_varDecl_in_objCClassDef777);
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
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:390:7: functionPointerVarDecl
                    	            {
                    	            pushFollow(FOLLOW_functionPointerVarDecl_in_objCClassDef789);
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

                    char_literal36=(Token)match(input,24,FOLLOW_24_in_objCClassDef816); if (state.failed) return retval;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:399:3: ( objCMethodDecl | typeDef | vd= varDecl {...}?)*
            loop20:
            do {
                int alt20=4;
                alt20 = dfa20.predict(input);
                switch (alt20) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:400:4: objCMethodDecl
            	    {
            	    pushFollow(FOLLOW_objCMethodDecl_in_objCClassDef834);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:403:4: typeDef
            	    {
            	    pushFollow(FOLLOW_typeDef_in_objCClassDef843);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:406:4: vd= varDecl {...}?
            	    {
            	    pushFollow(FOLLOW_varDecl_in_objCClassDef854);
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

            string_literal39=(Token)match(input,41,FOLLOW_41_in_objCClassDef867); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:413:1: objCMethodDecl returns [Function function] : tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= typeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:414:2: (tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= typeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:414:4: tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= typeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               	
              			retval.function = new Function(); 
              			retval.function.setType(Function.Type.ObjCMethod);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:418:6: (tp= '+' | tm= '-' )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:419:4: tp= '+'
                    {
                    tp=(Token)match(input,42,FOLLOW_42_in_objCMethodDecl901); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:424:4: tm= '-'
                    {
                    tm=(Token)match(input,43,FOLLOW_43_in_objCMethodDecl913); if (state.failed) return retval;
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:429:3: ( '(' (returnTypeRef= typeRef )? ')' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==34) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:431:4: '(' (returnTypeRef= typeRef )? ')'
                    {
                    char_literal40=(Token)match(input,34,FOLLOW_34_in_objCMethodDecl932); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal40_tree = (Object)adaptor.create(char_literal40);
                    adaptor.addChild(root_0, char_literal40_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:432:18: (returnTypeRef= typeRef )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==IDENTIFIER||LA22_0==30||(LA22_0>=45 && LA22_0<=47)||(LA22_0>=60 && LA22_0<=74)) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: returnTypeRef= typeRef
                            {
                            pushFollow(FOLLOW_typeRef_in_objCMethodDecl940);
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
                    char_literal41=(Token)match(input,35,FOLLOW_35_in_objCMethodDecl948); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal41_tree = (Object)adaptor.create(char_literal41);
                    adaptor.addChild(root_0, char_literal41_tree);
                    }

                    }
                    break;

            }

            methodName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl959); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            methodName_tree = (Object)adaptor.create(methodName);
            adaptor.addChild(root_0, methodName_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.function.setName((methodName!=null?methodName.getText():null)); 
              			retval.function.setCommentAfter(getCommentAfterOnSameLine(methodName.getTokenIndex()));
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:441:3: ( ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==33) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:442:4: ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )?
                    {
                    char_literal42=(Token)match(input,33,FOLLOW_33_in_objCMethodDecl971); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal42_tree = (Object)adaptor.create(char_literal42);
                    adaptor.addChild(root_0, char_literal42_tree);
                    }
                    char_literal43=(Token)match(input,34,FOLLOW_34_in_objCMethodDecl973); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal43_tree = (Object)adaptor.create(char_literal43);
                    adaptor.addChild(root_0, char_literal43_tree);
                    }
                    pushFollow(FOLLOW_typeRef_in_objCMethodDecl977);
                    argType1=typeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, argType1.getTree());
                    char_literal44=(Token)match(input,35,FOLLOW_35_in_objCMethodDecl979); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal44_tree = (Object)adaptor.create(char_literal44);
                    adaptor.addChild(root_0, char_literal44_tree);
                    }
                    argName1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl983); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    argName1_tree = (Object)adaptor.create(argName1);
                    adaptor.addChild(root_0, argName1_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				Arg arg = new Arg((argName1!=null?argName1.getText():null), (argType1!=null?argType1.type:null));
                      				arg.setSelector((methodName!=null?methodName.getText():null));
                      				retval.function.addArg(arg);
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:447:4: (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==IDENTIFIER) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:448:5: sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER
                    	    {
                    	    sel=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl998); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    sel_tree = (Object)adaptor.create(sel);
                    	    adaptor.addChild(root_0, sel_tree);
                    	    }
                    	    char_literal45=(Token)match(input,33,FOLLOW_33_in_objCMethodDecl1000); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal45_tree = (Object)adaptor.create(char_literal45);
                    	    adaptor.addChild(root_0, char_literal45_tree);
                    	    }
                    	    char_literal46=(Token)match(input,34,FOLLOW_34_in_objCMethodDecl1007); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal46_tree = (Object)adaptor.create(char_literal46);
                    	    adaptor.addChild(root_0, char_literal46_tree);
                    	    }
                    	    pushFollow(FOLLOW_typeRef_in_objCMethodDecl1011);
                    	    argType=typeRef();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, argType.getTree());
                    	    char_literal47=(Token)match(input,35,FOLLOW_35_in_objCMethodDecl1013); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal47_tree = (Object)adaptor.create(char_literal47);
                    	    adaptor.addChild(root_0, char_literal47_tree);
                    	    }
                    	    argName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1022); if (state.failed) return retval;
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

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:456:4: ( ',' '...' )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==27) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:457:5: ',' '...'
                            {
                            char_literal48=(Token)match(input,27,FOLLOW_27_in_objCMethodDecl1041); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal48_tree = (Object)adaptor.create(char_literal48);
                            adaptor.addChild(root_0, char_literal48_tree);
                            }
                            string_literal49=(Token)match(input,44,FOLLOW_44_in_objCMethodDecl1043); if (state.failed) return retval;
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

            char_literal50=(Token)match(input,28,FOLLOW_28_in_objCMethodDecl1060); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:478:1: structCore returns [Struct struct, List<Modifier> modifiers] : t= ( 'struct' | 'class' | 'union' ) ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' ) ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:479:2: (t= ( 'struct' | 'class' | 'union' ) ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:481:3: t= ( 'struct' | 'class' | 'union' ) ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' )
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:490:3: ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' )
            int alt31=2;
            alt31 = dfa31.predict(input);
            switch (alt31) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:491:4: (n0= IDENTIFIER )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:491:4: (n0= IDENTIFIER )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:492:5: n0= IDENTIFIER
                    {
                    n0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_structCore1115); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:497:4: ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}'
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:497:4: ( ( exportationModifiers )? n1= IDENTIFIER )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==IDENTIFIER) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:498:5: ( exportationModifiers )? n1= IDENTIFIER
                            {
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:498:5: ( exportationModifiers )?
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
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:498:7: exportationModifiers
                                    {
                                    pushFollow(FOLLOW_exportationModifiers_in_structCore1138);
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

                            n1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_structCore1151); if (state.failed) return retval;
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

                    char_literal52=(Token)match(input,23,FOLLOW_23_in_structCore1165); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal52_tree = (Object)adaptor.create(char_literal52);
                    adaptor.addChild(root_0, char_literal52_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.struct.setForwardDeclaration(false); 
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:505:5: ( ( 'public' | 'private' | 'protected' ) ':' | declaration )*
                    loop30:
                    do {
                        int alt30=3;
                        alt30 = dfa30.predict(input);
                        switch (alt30) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:506:6: ( 'public' | 'private' | 'protected' ) ':'
                    	    {
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:506:6: ( 'public' | 'private' | 'protected' )
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
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:507:7: 'public'
                    	            {
                    	            string_literal53=(Token)match(input,48,FOLLOW_48_in_structCore1188); if (state.failed) return retval;
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
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:508:7: 'private'
                    	            {
                    	            string_literal54=(Token)match(input,49,FOLLOW_49_in_structCore1201); if (state.failed) return retval;
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
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:509:7: 'protected'
                    	            {
                    	            string_literal55=(Token)match(input,50,FOLLOW_50_in_structCore1214); if (state.failed) return retval;
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

                    	    char_literal56=(Token)match(input,33,FOLLOW_33_in_structCore1226); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal56_tree = (Object)adaptor.create(char_literal56);
                    	    adaptor.addChild(root_0, char_literal56_tree);
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:511:6: declaration
                    	    {
                    	    pushFollow(FOLLOW_declaration_in_structCore1235);
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

                    char_literal58=(Token)match(input,24,FOLLOW_24_in_structCore1249); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:520:1: functionDeclaration returns [Function function] : (returnTypeRef= typeRef )? preMods= exportationModifiers n= IDENTIFIER argList {...}? (ct= IDENTIFIER )? postMods= exportationModifiers ( ';' | statementsBlock ) ;
    public final ObjCppParser.functionDeclaration_return functionDeclaration() throws RecognitionException {
        ObjCppParser.functionDeclaration_return retval = new ObjCppParser.functionDeclaration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token ct=null;
        Token char_literal60=null;
        ObjCppParser.typeRef_return returnTypeRef = null;

        ObjCppParser.exportationModifiers_return preMods = null;

        ObjCppParser.exportationModifiers_return postMods = null;

        ObjCppParser.argList_return argList59 = null;

        ObjCppParser.statementsBlock_return statementsBlock61 = null;


        Object n_tree=null;
        Object ct_tree=null;
        Object char_literal60_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:521:2: ( (returnTypeRef= typeRef )? preMods= exportationModifiers n= IDENTIFIER argList {...}? (ct= IDENTIFIER )? postMods= exportationModifiers ( ';' | statementsBlock ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:521:4: (returnTypeRef= typeRef )? preMods= exportationModifiers n= IDENTIFIER argList {...}? (ct= IDENTIFIER )? postMods= exportationModifiers ( ';' | statementsBlock )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               	
              			retval.function = new Function();
              			retval.function.setType(Function.Type.CFunction);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:528:16: (returnTypeRef= typeRef )?
            int alt32=2;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: returnTypeRef= typeRef
                    {
                    pushFollow(FOLLOW_typeRef_in_functionDeclaration1279);
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
            pushFollow(FOLLOW_exportationModifiers_in_functionDeclaration1288);
            preMods=exportationModifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, preMods.getTree());
            if ( state.backtracking==0 ) {

              			for (Modifier m : (preMods!=null?preMods.modifiers:null))
              				retval.function.addModifiers(m);
              		
            }
            n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionDeclaration1296); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.function.setName((n!=null?n.getText():null)); 
              			retval.function = mark(retval.function, getLine(n));
              		
            }
            pushFollow(FOLLOW_argList_in_functionDeclaration1303);
            argList59=argList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, argList59.getTree());
            if ( state.backtracking==0 ) {

              			retval.function.setArgs((argList59!=null?argList59.args:null));
              		
            }
            if ( !(( next("const", "__const") )) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "functionDeclaration", " next(\"const\", \"__const\") ");
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:542:35: (ct= IDENTIFIER )?
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
                    ct=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionDeclaration1313); if (state.failed) return retval;
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
            pushFollow(FOLLOW_exportationModifiers_in_functionDeclaration1322);
            postMods=exportationModifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, postMods.getTree());
            if ( state.backtracking==0 ) {

              			for (Modifier m : (postMods!=null?postMods.modifiers:null))
              				retval.function.addModifiers(m);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:550:3: ( ';' | statementsBlock )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:551:4: ';'
                    {
                    char_literal60=(Token)match(input,28,FOLLOW_28_in_functionDeclaration1334); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal60_tree = (Object)adaptor.create(char_literal60);
                    adaptor.addChild(root_0, char_literal60_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:552:4: statementsBlock
                    {
                    pushFollow(FOLLOW_statementsBlock_in_functionDeclaration1341);
                    statementsBlock61=statementsBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementsBlock61.getTree());
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:558:1: functionDefinition : functionDeclaration '{' '}' ;
    public final ObjCppParser.functionDefinition_return functionDefinition() throws RecognitionException {
        ObjCppParser.functionDefinition_return retval = new ObjCppParser.functionDefinition_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal63=null;
        Token char_literal64=null;
        ObjCppParser.functionDeclaration_return functionDeclaration62 = null;


        Object char_literal63_tree=null;
        Object char_literal64_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:559:2: ( functionDeclaration '{' '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:559:4: functionDeclaration '{' '}'
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_functionDeclaration_in_functionDefinition1358);
            functionDeclaration62=functionDeclaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, functionDeclaration62.getTree());
            char_literal63=(Token)match(input,23,FOLLOW_23_in_functionDefinition1360); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal63_tree = (Object)adaptor.create(char_literal63);
            adaptor.addChild(root_0, char_literal63_tree);
            }
            char_literal64=(Token)match(input,24,FOLLOW_24_in_functionDefinition1362); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal64_tree = (Object)adaptor.create(char_literal64);
            adaptor.addChild(root_0, char_literal64_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:562:1: exportationModifiers returns [List<Modifier> modifiers] : ( exportationModifier )* ;
    public final ObjCppParser.exportationModifiers_return exportationModifiers() throws RecognitionException {
        ObjCppParser.exportationModifiers_return retval = new ObjCppParser.exportationModifiers_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.exportationModifier_return exportationModifier65 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:563:2: ( ( exportationModifier )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:563:5: ( exportationModifier )*
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:564:3: ( exportationModifier )*
            loop35:
            do {
                int alt35=2;
                alt35 = dfa35.predict(input);
                switch (alt35) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:565:4: exportationModifier
            	    {
            	    pushFollow(FOLLOW_exportationModifier_in_exportationModifiers1389);
            	    exportationModifier65=exportationModifier();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, exportationModifier65.getTree());
            	    if ( state.backtracking==0 ) {
            	       
            	      				retval.modifiers.addAll((exportationModifier65!=null?exportationModifier65.modifiers:null)); 
            	      			
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:571:1: modifier returns [Modifier modifier] : {...}? IDENTIFIER ;
    public final ObjCppParser.modifier_return modifier() throws RecognitionException {
        ObjCppParser.modifier_return retval = new ObjCppParser.modifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER66=null;

        Object IDENTIFIER66_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:572:2: ({...}? IDENTIFIER )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:572:4: {...}? IDENTIFIER
            {
            root_0 = (Object)adaptor.nil();

            if ( !(( Modifier.parseModifier(next()) != null )) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "modifier", " Modifier.parseModifier(next()) != null ");
            }
            IDENTIFIER66=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier1416); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER66_tree = (Object)adaptor.create(IDENTIFIER66);
            adaptor.addChild(root_0, IDENTIFIER66_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.modifier = Modifier.parseModifier((IDENTIFIER66!=null?IDENTIFIER66.getText():null));
              		
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:585:1: exportationModifier returns [List<Modifier> modifiers] : ({...}? modifier | IDENTIFIER {...}? '(' extendedModifiers ')' ) ;
    public final ObjCppParser.exportationModifier_return exportationModifier() throws RecognitionException {
        ObjCppParser.exportationModifier_return retval = new ObjCppParser.exportationModifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER68=null;
        Token char_literal69=null;
        Token char_literal71=null;
        ObjCppParser.modifier_return modifier67 = null;

        ObjCppParser.extendedModifiers_return extendedModifiers70 = null;


        Object IDENTIFIER68_tree=null;
        Object char_literal69_tree=null;
        Object char_literal71_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:586:2: ( ({...}? modifier | IDENTIFIER {...}? '(' extendedModifiers ')' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:586:5: ({...}? modifier | IDENTIFIER {...}? '(' extendedModifiers ')' )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:587:3: ({...}? modifier | IDENTIFIER {...}? '(' extendedModifiers ')' )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:588:4: {...}? modifier
                    {
                    if ( !(( next(Modifier.Kind.Plain) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "exportationModifier", " next(Modifier.Kind.Plain) ");
                    }
                    pushFollow(FOLLOW_modifier_in_exportationModifier1448);
                    modifier67=modifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modifier67.getTree());
                    if ( state.backtracking==0 ) {

                      				retval.modifiers.add((modifier67!=null?modifier67.modifier:null));
                      			
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:591:4: IDENTIFIER {...}? '(' extendedModifiers ')'
                    {
                    IDENTIFIER68=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_exportationModifier1457); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER68_tree = (Object)adaptor.create(IDENTIFIER68);
                    adaptor.addChild(root_0, IDENTIFIER68_tree);
                    }
                    if ( !(( (IDENTIFIER68!=null?IDENTIFIER68.getText():null).equals("__declspec") || (IDENTIFIER68!=null?IDENTIFIER68.getText():null).equals("__attribute__") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "exportationModifier", " $IDENTIFIER.text.equals(\"__declspec\") || $IDENTIFIER.text.equals(\"__attribute__\") ");
                    }
                    char_literal69=(Token)match(input,34,FOLLOW_34_in_exportationModifier1465); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal69_tree = (Object)adaptor.create(char_literal69);
                    adaptor.addChild(root_0, char_literal69_tree);
                    }
                    pushFollow(FOLLOW_extendedModifiers_in_exportationModifier1467);
                    extendedModifiers70=extendedModifiers();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, extendedModifiers70.getTree());
                    char_literal71=(Token)match(input,35,FOLLOW_35_in_exportationModifier1469); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal71_tree = (Object)adaptor.create(char_literal71);
                    adaptor.addChild(root_0, char_literal71_tree);
                    }
                    if ( state.backtracking==0 ) {

                      					retval.modifiers.addAll((extendedModifiers70!=null?extendedModifiers70.modifiers:null));
                      			
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:599:1: extendedModifiers returns [List<Modifier> modifiers] : ({...}?m= modifier () )* ;
    public final ObjCppParser.extendedModifiers_return extendedModifiers() throws RecognitionException {
        ObjCppParser.extendedModifiers_return retval = new ObjCppParser.extendedModifiers_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.modifier_return m = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:600:2: ( ({...}?m= modifier () )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:600:4: ({...}?m= modifier () )*
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:601:3: ({...}?m= modifier () )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==IDENTIFIER) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:602:4: {...}?m= modifier ()
            	    {
            	    if ( !(( next(Modifier.Kind.Extended) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "extendedModifiers", " next(Modifier.Kind.Extended) ");
            	    }
            	    pushFollow(FOLLOW_modifier_in_extendedModifiers1504);
            	    m=modifier();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, m.getTree());
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:603:4: ()
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:604:5: 
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:614:1: argDef returns [Arg arg] : ( typeRef ( ( declarator )? ) ( '=' expression )? | '...' );
    public final ObjCppParser.argDef_return argDef() throws RecognitionException {
        ObjCppParser.argDef_return retval = new ObjCppParser.argDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal74=null;
        Token string_literal76=null;
        ObjCppParser.typeRef_return typeRef72 = null;

        ObjCppParser.declarator_return declarator73 = null;

        ObjCppParser.expression_return expression75 = null;


        Object char_literal74_tree=null;
        Object string_literal76_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:615:2: ( typeRef ( ( declarator )? ) ( '=' expression )? | '...' )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==IDENTIFIER||LA40_0==30||(LA40_0>=45 && LA40_0<=47)||(LA40_0>=60 && LA40_0<=74)) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:616:3: typeRef ( ( declarator )? ) ( '=' expression )?
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( state.backtracking==0 ) {
                       
                      			retval.arg = new Arg(); 
                      			int i = getTokenStream().index() + 1;
                      			retval.arg.setCommentBefore(getCommentBefore(i));
                      			retval.arg.setCommentAfter(getCommentAfterOnSameLine(i));
                      		
                    }
                    pushFollow(FOLLOW_typeRef_in_argDef1547);
                    typeRef72=typeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRef72.getTree());
                    if ( state.backtracking==0 ) {
                       
                      			retval.arg.setValueType((typeRef72!=null?typeRef72.type:null)); 
                      		
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:625:3: ( ( declarator )? )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:626:4: ( declarator )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:626:4: ( declarator )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==IDENTIFIER||LA38_0==34||(LA38_0>=51 && LA38_0<=52)||LA38_0==58) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: declarator
                            {
                            pushFollow(FOLLOW_declarator_in_argDef1558);
                            declarator73=declarator();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, declarator73.getTree());

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       
                      				if ((declarator73!=null?declarator73.declarator:null) != null)
                      					retval.arg.setDeclarator((declarator73!=null?declarator73.declarator:null)); 
                      				else if (retval.arg.getValueType() instanceof FunctionSignature) {
                      					FunctionSignature fs = (FunctionSignature)retval.arg.getValueType();
                      					if (fs != null && fs.getFunction() != null) {
                      						retval.arg.setName(fs.getFunction().getName());
                      						fs.getFunction().setName(null);
                      					}
                      				}
                      			
                    }

                    }

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:657:3: ( '=' expression )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==29) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:657:4: '=' expression
                            {
                            char_literal74=(Token)match(input,29,FOLLOW_29_in_argDef1578); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal74_tree = (Object)adaptor.create(char_literal74);
                            adaptor.addChild(root_0, char_literal74_tree);
                            }
                            pushFollow(FOLLOW_expression_in_argDef1580);
                            expression75=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression75.getTree());
                            if ( state.backtracking==0 ) {

                              			retval.arg.setDefaultValue((expression75!=null?expression75.expr:null));
                              		
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:661:3: '...'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal76=(Token)match(input,44,FOLLOW_44_in_argDef1594); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal76_tree = (Object)adaptor.create(string_literal76);
                    adaptor.addChild(root_0, string_literal76_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:679:1: typeMutator returns [TypeMutator mutator] : ({...}? IDENTIFIER '*' | '*' | '&' | '[' ']' );
    public final ObjCppParser.typeMutator_return typeMutator() throws RecognitionException {
        ObjCppParser.typeMutator_return retval = new ObjCppParser.typeMutator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER77=null;
        Token char_literal78=null;
        Token char_literal79=null;
        Token char_literal80=null;
        Token char_literal81=null;
        Token char_literal82=null;

        Object IDENTIFIER77_tree=null;
        Object char_literal78_tree=null;
        Object char_literal79_tree=null;
        Object char_literal80_tree=null;
        Object char_literal81_tree=null;
        Object char_literal82_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:680:2: ({...}? IDENTIFIER '*' | '*' | '&' | '[' ']' )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:680:4: {...}? IDENTIFIER '*'
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !(( next("const", "__const") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeMutator", " next(\"const\", \"__const\") ");
                    }
                    IDENTIFIER77=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_typeMutator1614); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER77_tree = (Object)adaptor.create(IDENTIFIER77);
                    adaptor.addChild(root_0, IDENTIFIER77_tree);
                    }
                    char_literal78=(Token)match(input,51,FOLLOW_51_in_typeMutator1616); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal78_tree = (Object)adaptor.create(char_literal78);
                    adaptor.addChild(root_0, char_literal78_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.mutator = TypeMutator.CONST_STAR; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:681:3: '*'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal79=(Token)match(input,51,FOLLOW_51_in_typeMutator1624); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal79_tree = (Object)adaptor.create(char_literal79);
                    adaptor.addChild(root_0, char_literal79_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.mutator = TypeMutator.STAR; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:682:3: '&'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal80=(Token)match(input,52,FOLLOW_52_in_typeMutator1632); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal80_tree = (Object)adaptor.create(char_literal80);
                    adaptor.addChild(root_0, char_literal80_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.mutator = TypeMutator.AMPERSTAND; 
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:683:3: '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal81=(Token)match(input,53,FOLLOW_53_in_typeMutator1641); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal81_tree = (Object)adaptor.create(char_literal81);
                    adaptor.addChild(root_0, char_literal81_tree);
                    }
                    char_literal82=(Token)match(input,54,FOLLOW_54_in_typeMutator1643); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal82_tree = (Object)adaptor.create(char_literal82);
                    adaptor.addChild(root_0, char_literal82_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:686:1: arrayTypeMutator returns [TypeMutator mutator] : '[' expression ']' ;
    public final ObjCppParser.arrayTypeMutator_return arrayTypeMutator() throws RecognitionException {
        ObjCppParser.arrayTypeMutator_return retval = new ObjCppParser.arrayTypeMutator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal83=null;
        Token char_literal85=null;
        ObjCppParser.expression_return expression84 = null;


        Object char_literal83_tree=null;
        Object char_literal85_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:687:2: ( '[' expression ']' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:687:4: '[' expression ']'
            {
            root_0 = (Object)adaptor.nil();

            char_literal83=(Token)match(input,53,FOLLOW_53_in_arrayTypeMutator1661); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal83_tree = (Object)adaptor.create(char_literal83);
            adaptor.addChild(root_0, char_literal83_tree);
            }
            pushFollow(FOLLOW_expression_in_arrayTypeMutator1667);
            expression84=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression84.getTree());
            if ( state.backtracking==0 ) {

              				retval.mutator = TypeMutator.array((expression84!=null?expression84.expr:null)); 
              			
            }
            char_literal85=(Token)match(input,54,FOLLOW_54_in_arrayTypeMutator1676); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal85_tree = (Object)adaptor.create(char_literal85);
            adaptor.addChild(root_0, char_literal85_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:694:1: typeRefCore returns [TypeRef type] : ({...}? IDENTIFIER '(' 'return' binaryOp expression ')' | {...}?m1a= modifier '(' expression ')' | {...}?m2a= modifier '(' expression ',' expression ')' )? ({...}?m= modifier )? ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) ) ;
    public final ObjCppParser.typeRefCore_return typeRefCore() throws RecognitionException {
        ObjCppParser.typeRefCore_return retval = new ObjCppParser.typeRefCore_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ref=null;
        Token IDENTIFIER86=null;
        Token char_literal87=null;
        Token string_literal88=null;
        Token char_literal91=null;
        Token char_literal92=null;
        Token char_literal94=null;
        Token char_literal95=null;
        Token char_literal97=null;
        Token char_literal99=null;
        Token char_literal101=null;
        Token char_literal102=null;
        Token char_literal103=null;
        ObjCppParser.modifier_return m1a = null;

        ObjCppParser.modifier_return m2a = null;

        ObjCppParser.modifier_return m = null;

        ObjCppParser.modifier_return m1 = null;

        ObjCppParser.typeRef_return tr = null;

        ObjCppParser.typeRef_return t1 = null;

        ObjCppParser.typeRef_return tx = null;

        ObjCppParser.binaryOp_return binaryOp89 = null;

        ObjCppParser.expression_return expression90 = null;

        ObjCppParser.expression_return expression93 = null;

        ObjCppParser.expression_return expression96 = null;

        ObjCppParser.expression_return expression98 = null;

        ObjCppParser.primitiveTypeRef_return primitiveTypeRef100 = null;


        Object ref_tree=null;
        Object IDENTIFIER86_tree=null;
        Object char_literal87_tree=null;
        Object string_literal88_tree=null;
        Object char_literal91_tree=null;
        Object char_literal92_tree=null;
        Object char_literal94_tree=null;
        Object char_literal95_tree=null;
        Object char_literal97_tree=null;
        Object char_literal99_tree=null;
        Object char_literal101_tree=null;
        Object char_literal102_tree=null;
        Object char_literal103_tree=null;

         List<Modifier> mods = new ArrayList<Modifier>(); 
        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:696:2: ( ({...}? IDENTIFIER '(' 'return' binaryOp expression ')' | {...}?m1a= modifier '(' expression ')' | {...}?m2a= modifier '(' expression ',' expression ')' )? ({...}?m= modifier )? ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:697:3: ({...}? IDENTIFIER '(' 'return' binaryOp expression ')' | {...}?m1a= modifier '(' expression ')' | {...}?m2a= modifier '(' expression ',' expression ')' )? ({...}?m= modifier )? ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) )
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:697:3: ({...}? IDENTIFIER '(' 'return' binaryOp expression ')' | {...}?m1a= modifier '(' expression ')' | {...}?m2a= modifier '(' expression ',' expression ')' )?
            int alt42=4;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:700:4: {...}? IDENTIFIER '(' 'return' binaryOp expression ')'
                    {
                    if ( !(( "__success".equals(next()) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeRefCore", " \"__success\".equals(next()) ");
                    }
                    IDENTIFIER86=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_typeRefCore1716); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER86_tree = (Object)adaptor.create(IDENTIFIER86);
                    adaptor.addChild(root_0, IDENTIFIER86_tree);
                    }
                    char_literal87=(Token)match(input,34,FOLLOW_34_in_typeRefCore1719); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal87_tree = (Object)adaptor.create(char_literal87);
                    adaptor.addChild(root_0, char_literal87_tree);
                    }
                    string_literal88=(Token)match(input,55,FOLLOW_55_in_typeRefCore1721); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal88_tree = (Object)adaptor.create(string_literal88);
                    adaptor.addChild(root_0, string_literal88_tree);
                    }
                    pushFollow(FOLLOW_binaryOp_in_typeRefCore1723);
                    binaryOp89=binaryOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, binaryOp89.getTree());
                    pushFollow(FOLLOW_expression_in_typeRefCore1725);
                    expression90=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression90.getTree());
                    char_literal91=(Token)match(input,35,FOLLOW_35_in_typeRefCore1727); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal91_tree = (Object)adaptor.create(char_literal91);
                    adaptor.addChild(root_0, char_literal91_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:701:4: {...}?m1a= modifier '(' expression ')'
                    {
                    if ( !(( next(Modifier.Kind.VCAnnotation1Arg) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeRefCore", " next(Modifier.Kind.VCAnnotation1Arg) ");
                    }
                    pushFollow(FOLLOW_modifier_in_typeRefCore1738);
                    m1a=modifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, m1a.getTree());
                    char_literal92=(Token)match(input,34,FOLLOW_34_in_typeRefCore1741); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal92_tree = (Object)adaptor.create(char_literal92);
                    adaptor.addChild(root_0, char_literal92_tree);
                    }
                    pushFollow(FOLLOW_expression_in_typeRefCore1743);
                    expression93=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression93.getTree());
                    char_literal94=(Token)match(input,35,FOLLOW_35_in_typeRefCore1745); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal94_tree = (Object)adaptor.create(char_literal94);
                    adaptor.addChild(root_0, char_literal94_tree);
                    }
                    if ( state.backtracking==0 ) {
                       mods.add((m1a!=null?m1a.modifier:null)); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:702:4: {...}?m2a= modifier '(' expression ',' expression ')'
                    {
                    if ( !(( next(Modifier.Kind.VCAnnotation2Args) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeRefCore", " next(Modifier.Kind.VCAnnotation2Args) ");
                    }
                    pushFollow(FOLLOW_modifier_in_typeRefCore1758);
                    m2a=modifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, m2a.getTree());
                    char_literal95=(Token)match(input,34,FOLLOW_34_in_typeRefCore1761); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal95_tree = (Object)adaptor.create(char_literal95);
                    adaptor.addChild(root_0, char_literal95_tree);
                    }
                    pushFollow(FOLLOW_expression_in_typeRefCore1763);
                    expression96=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression96.getTree());
                    char_literal97=(Token)match(input,27,FOLLOW_27_in_typeRefCore1765); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal97_tree = (Object)adaptor.create(char_literal97);
                    adaptor.addChild(root_0, char_literal97_tree);
                    }
                    pushFollow(FOLLOW_expression_in_typeRefCore1767);
                    expression98=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression98.getTree());
                    char_literal99=(Token)match(input,35,FOLLOW_35_in_typeRefCore1769); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal99_tree = (Object)adaptor.create(char_literal99);
                    adaptor.addChild(root_0, char_literal99_tree);
                    }
                    if ( state.backtracking==0 ) {
                       mods.add((m2a!=null?m2a.modifier:null)); 
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:704:3: ({...}?m= modifier )?
            int alt43=2;
            alt43 = dfa43.predict(input);
            switch (alt43) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:704:4: {...}?m= modifier
                    {
                    if ( !(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeRefCore", " next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ");
                    }
                    pushFollow(FOLLOW_modifier_in_typeRefCore1786);
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:705:3: ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) )
            int alt48=2;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:706:4: {...}?m1= modifier tr= typeRef
                    {
                    if ( !(( next(Modifier.Kind.ReferenceQualifier) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeRefCore", " next(Modifier.Kind.ReferenceQualifier) ");
                    }
                    pushFollow(FOLLOW_modifier_in_typeRefCore1803);
                    m1=modifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, m1.getTree());
                    if ( state.backtracking==0 ) {
                       mods.add((m1!=null?m1.modifier:null)); 
                    }
                    pushFollow(FOLLOW_typeRef_in_typeRefCore1812);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:709:4: ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:709:4: ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) )
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( ((LA47_0>=60 && LA47_0<=74)) ) {
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
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:710:5: primitiveTypeRef
                            {
                            pushFollow(FOLLOW_primitiveTypeRef_in_typeRefCore1832);
                            primitiveTypeRef100=primitiveTypeRef();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveTypeRef100.getTree());
                            if ( state.backtracking==0 ) {
                               retval.type = (primitiveTypeRef100!=null?primitiveTypeRef100.type:null); 
                            }

                            }
                            break;
                        case 2 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:711:5: {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' )
                            {
                            if ( !(( Modifier.parseModifier(next()) == null )) ) {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                throw new FailedPredicateException(input, "typeRefCore", " Modifier.parseModifier(next()) == null ");
                            }
                            ref=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_typeRefCore1847); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ref_tree = (Object)adaptor.create(ref);
                            adaptor.addChild(root_0, ref_tree);
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:711:64: ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' )
                            int alt46=2;
                            alt46 = dfa46.predict(input);
                            switch (alt46) {
                                case 1 :
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:712:6: 
                                    {
                                    if ( state.backtracking==0 ) {
                                       retval.type = new SimpleTypeRef((ref!=null?ref.getText():null)); 
                                    }

                                    }
                                    break;
                                case 2 :
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:713:6: '<' (t1= typeRef ( ',' tx= typeRef )* )? '>'
                                    {
                                    char_literal101=(Token)match(input,36,FOLLOW_36_in_typeRefCore1865); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    char_literal101_tree = (Object)adaptor.create(char_literal101);
                                    adaptor.addChild(root_0, char_literal101_tree);
                                    }
                                    if ( state.backtracking==0 ) {
                                       retval.type = new TemplateRef((ref!=null?ref.getText():null)); 
                                    }
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:714:7: (t1= typeRef ( ',' tx= typeRef )* )?
                                    int alt45=2;
                                    int LA45_0 = input.LA(1);

                                    if ( (LA45_0==IDENTIFIER||LA45_0==30||(LA45_0>=45 && LA45_0<=47)||(LA45_0>=60 && LA45_0<=74)) ) {
                                        alt45=1;
                                    }
                                    switch (alt45) {
                                        case 1 :
                                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:715:8: t1= typeRef ( ',' tx= typeRef )*
                                            {
                                            pushFollow(FOLLOW_typeRef_in_typeRefCore1886);
                                            t1=typeRef();

                                            state._fsp--;
                                            if (state.failed) return retval;
                                            if ( state.backtracking==0 ) adaptor.addChild(root_0, t1.getTree());
                                            if ( state.backtracking==0 ) {
                                               ((TemplateRef)retval.type).addParameter((t1!=null?t1.type:null)); 
                                            }
                                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:716:8: ( ',' tx= typeRef )*
                                            loop44:
                                            do {
                                                int alt44=2;
                                                int LA44_0 = input.LA(1);

                                                if ( (LA44_0==27) ) {
                                                    alt44=1;
                                                }


                                                switch (alt44) {
                                            	case 1 :
                                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:717:9: ',' tx= typeRef
                                            	    {
                                            	    char_literal102=(Token)match(input,27,FOLLOW_27_in_typeRefCore1907); if (state.failed) return retval;
                                            	    if ( state.backtracking==0 ) {
                                            	    char_literal102_tree = (Object)adaptor.create(char_literal102);
                                            	    adaptor.addChild(root_0, char_literal102_tree);
                                            	    }
                                            	    pushFollow(FOLLOW_typeRef_in_typeRefCore1920);
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

                                    char_literal103=(Token)match(input,37,FOLLOW_37_in_typeRefCore1948); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    char_literal103_tree = (Object)adaptor.create(char_literal103);
                                    adaptor.addChild(root_0, char_literal103_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:729:1: templateDef : ( 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' structCore | functionDefinition );
    public final ObjCppParser.templateDef_return templateDef() throws RecognitionException {
        ObjCppParser.templateDef_return retval = new ObjCppParser.templateDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal104=null;
        Token char_literal105=null;
        Token char_literal107=null;
        Token char_literal109=null;
        ObjCppParser.templateArgDecl_return templateArgDecl106 = null;

        ObjCppParser.templateArgDecl_return templateArgDecl108 = null;

        ObjCppParser.structCore_return structCore110 = null;

        ObjCppParser.functionDefinition_return functionDefinition111 = null;


        Object string_literal104_tree=null;
        Object char_literal105_tree=null;
        Object char_literal107_tree=null;
        Object char_literal109_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:730:2: ( 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' structCore | functionDefinition )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==56) ) {
                alt51=1;
            }
            else if ( (LA51_0==IDENTIFIER||LA51_0==30||(LA51_0>=45 && LA51_0<=47)||(LA51_0>=60 && LA51_0<=74)) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:730:4: 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' structCore
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal104=(Token)match(input,56,FOLLOW_56_in_templateDef1980); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal104_tree = (Object)adaptor.create(string_literal104);
                    adaptor.addChild(root_0, string_literal104_tree);
                    }
                    char_literal105=(Token)match(input,36,FOLLOW_36_in_templateDef1982); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal105_tree = (Object)adaptor.create(char_literal105);
                    adaptor.addChild(root_0, char_literal105_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:730:19: ( templateArgDecl ( ',' templateArgDecl )* )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==46||LA50_0==57||(LA50_0>=60 && LA50_0<=74)) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:730:20: templateArgDecl ( ',' templateArgDecl )*
                            {
                            pushFollow(FOLLOW_templateArgDecl_in_templateDef1985);
                            templateArgDecl106=templateArgDecl();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, templateArgDecl106.getTree());
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:730:36: ( ',' templateArgDecl )*
                            loop49:
                            do {
                                int alt49=2;
                                int LA49_0 = input.LA(1);

                                if ( (LA49_0==27) ) {
                                    alt49=1;
                                }


                                switch (alt49) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:730:37: ',' templateArgDecl
                            	    {
                            	    char_literal107=(Token)match(input,27,FOLLOW_27_in_templateDef1988); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    char_literal107_tree = (Object)adaptor.create(char_literal107);
                            	    adaptor.addChild(root_0, char_literal107_tree);
                            	    }
                            	    pushFollow(FOLLOW_templateArgDecl_in_templateDef1990);
                            	    templateArgDecl108=templateArgDecl();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, templateArgDecl108.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop49;
                                }
                            } while (true);


                            }
                            break;

                    }

                    char_literal109=(Token)match(input,37,FOLLOW_37_in_templateDef1997); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal109_tree = (Object)adaptor.create(char_literal109);
                    adaptor.addChild(root_0, char_literal109_tree);
                    }
                    pushFollow(FOLLOW_structCore_in_templateDef2001);
                    structCore110=structCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structCore110.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:731:16: functionDefinition
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_functionDefinition_in_templateDef2005);
                    functionDefinition111=functionDefinition();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionDefinition111.getTree());

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:734:1: templateArgDecl : ( primitiveTypeRef ( '=' constant ) | ( 'typename' | 'class' ) IDENTIFIER ( '=' typeRef ) );
    public final ObjCppParser.templateArgDecl_return templateArgDecl() throws RecognitionException {
        ObjCppParser.templateArgDecl_return retval = new ObjCppParser.templateArgDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal113=null;
        Token set115=null;
        Token IDENTIFIER116=null;
        Token char_literal117=null;
        ObjCppParser.primitiveTypeRef_return primitiveTypeRef112 = null;

        ObjCppParser.constant_return constant114 = null;

        ObjCppParser.typeRef_return typeRef118 = null;


        Object char_literal113_tree=null;
        Object set115_tree=null;
        Object IDENTIFIER116_tree=null;
        Object char_literal117_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:735:2: ( primitiveTypeRef ( '=' constant ) | ( 'typename' | 'class' ) IDENTIFIER ( '=' typeRef ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0>=60 && LA52_0<=74)) ) {
                alt52=1;
            }
            else if ( (LA52_0==46||LA52_0==57) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:735:4: primitiveTypeRef ( '=' constant )
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primitiveTypeRef_in_templateArgDecl2017);
                    primitiveTypeRef112=primitiveTypeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveTypeRef112.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:735:21: ( '=' constant )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:735:22: '=' constant
                    {
                    char_literal113=(Token)match(input,29,FOLLOW_29_in_templateArgDecl2020); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal113_tree = (Object)adaptor.create(char_literal113);
                    adaptor.addChild(root_0, char_literal113_tree);
                    }
                    pushFollow(FOLLOW_constant_in_templateArgDecl2022);
                    constant114=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant114.getTree());

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:736:3: ( 'typename' | 'class' ) IDENTIFIER ( '=' typeRef )
                    {
                    root_0 = (Object)adaptor.nil();

                    set115=(Token)input.LT(1);
                    if ( input.LA(1)==46||input.LA(1)==57 ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set115));
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    IDENTIFIER116=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_templateArgDecl2037); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER116_tree = (Object)adaptor.create(IDENTIFIER116);
                    adaptor.addChild(root_0, IDENTIFIER116_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:736:37: ( '=' typeRef )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:736:38: '=' typeRef
                    {
                    char_literal117=(Token)match(input,29,FOLLOW_29_in_templateArgDecl2040); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal117_tree = (Object)adaptor.create(char_literal117);
                    adaptor.addChild(root_0, char_literal117_tree);
                    }
                    pushFollow(FOLLOW_typeRef_in_templateArgDecl2042);
                    typeRef118=typeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRef118.getTree());

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:739:1: functionSignatureSuffix returns [FunctionSignature signature] : tk= '(' exportationModifiers '*' ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' ;
    public final ObjCppParser.functionSignatureSuffix_return functionSignatureSuffix() throws RecognitionException {
        ObjCppParser.functionSignatureSuffix_return retval = new ObjCppParser.functionSignatureSuffix_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token tk=null;
        Token char_literal120=null;
        Token IDENTIFIER121=null;
        Token char_literal122=null;
        Token char_literal123=null;
        Token char_literal124=null;
        Token char_literal125=null;
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;

        ObjCppParser.exportationModifiers_return exportationModifiers119 = null;


        Object tk_tree=null;
        Object char_literal120_tree=null;
        Object IDENTIFIER121_tree=null;
        Object char_literal122_tree=null;
        Object char_literal123_tree=null;
        Object char_literal124_tree=null;
        Object char_literal125_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:740:2: (tk= '(' exportationModifiers '*' ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:740:4: tk= '(' exportationModifiers '*' ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')'
            {
            root_0 = (Object)adaptor.nil();

            tk=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffix2061); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tk_tree = (Object)adaptor.create(tk);
            adaptor.addChild(root_0, tk_tree);
            }
            pushFollow(FOLLOW_exportationModifiers_in_functionSignatureSuffix2063);
            exportationModifiers119=exportationModifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exportationModifiers119.getTree());
            char_literal120=(Token)match(input,51,FOLLOW_51_in_functionSignatureSuffix2065); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal120_tree = (Object)adaptor.create(char_literal120);
            adaptor.addChild(root_0, char_literal120_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:740:36: ( IDENTIFIER )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==IDENTIFIER) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: IDENTIFIER
                    {
                    IDENTIFIER121=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionSignatureSuffix2067); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER121_tree = (Object)adaptor.create(IDENTIFIER121);
                    adaptor.addChild(root_0, IDENTIFIER121_tree);
                    }

                    }
                    break;

            }

            char_literal122=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffix2070); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal122_tree = (Object)adaptor.create(char_literal122);
            adaptor.addChild(root_0, char_literal122_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, (IDENTIFIER121!=null?IDENTIFIER121.getText():null), null)), getLine(tk));
              			retval.signature.getFunction().setType(Function.Type.CFunction);
              			retval.signature.getFunction().addModifiers((exportationModifiers119!=null?exportationModifiers119.modifiers:null));
              		
            }
            char_literal123=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffix2076); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal123_tree = (Object)adaptor.create(char_literal123);
            adaptor.addChild(root_0, char_literal123_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:745:7: (a1= argDef ( ',' ax= argDef )* )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==IDENTIFIER||LA55_0==30||(LA55_0>=44 && LA55_0<=47)||(LA55_0>=60 && LA55_0<=74)) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:746:4: a1= argDef ( ',' ax= argDef )*
                    {
                    pushFollow(FOLLOW_argDef_in_functionSignatureSuffix2085);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					((FunctionSignature)retval.signature).getFunction().addArg((a1!=null?a1.arg:null)); 
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:750:4: ( ',' ax= argDef )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==27) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:751:5: ',' ax= argDef
                    	    {
                    	    char_literal124=(Token)match(input,27,FOLLOW_27_in_functionSignatureSuffix2098); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal124_tree = (Object)adaptor.create(char_literal124);
                    	    adaptor.addChild(root_0, char_literal124_tree);
                    	    }
                    	    pushFollow(FOLLOW_argDef_in_functionSignatureSuffix2107);
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

            char_literal125=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffix2122); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal125_tree = (Object)adaptor.create(char_literal125);
            adaptor.addChild(root_0, char_literal125_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:759:1: functionSignatureSuffixNoName returns [FunctionSignature signature] : tk= '(' exportationModifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' ;
    public final ObjCppParser.functionSignatureSuffixNoName_return functionSignatureSuffixNoName() throws RecognitionException {
        ObjCppParser.functionSignatureSuffixNoName_return retval = new ObjCppParser.functionSignatureSuffixNoName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token tk=null;
        Token char_literal127=null;
        Token char_literal128=null;
        Token char_literal129=null;
        Token char_literal130=null;
        Token char_literal131=null;
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;

        ObjCppParser.exportationModifiers_return exportationModifiers126 = null;


        Object tk_tree=null;
        Object char_literal127_tree=null;
        Object char_literal128_tree=null;
        Object char_literal129_tree=null;
        Object char_literal130_tree=null;
        Object char_literal131_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:760:2: (tk= '(' exportationModifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:760:4: tk= '(' exportationModifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')'
            {
            root_0 = (Object)adaptor.nil();

            tk=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffixNoName2139); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tk_tree = (Object)adaptor.create(tk);
            adaptor.addChild(root_0, tk_tree);
            }
            pushFollow(FOLLOW_exportationModifiers_in_functionSignatureSuffixNoName2141);
            exportationModifiers126=exportationModifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exportationModifiers126.getTree());
            char_literal127=(Token)match(input,51,FOLLOW_51_in_functionSignatureSuffixNoName2143); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal127_tree = (Object)adaptor.create(char_literal127);
            adaptor.addChild(root_0, char_literal127_tree);
            }
            char_literal128=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffixNoName2145); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal128_tree = (Object)adaptor.create(char_literal128);
            adaptor.addChild(root_0, char_literal128_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, null, null)), getLine(tk));
              			retval.signature.getFunction().setType(Function.Type.CFunction);
              			retval.signature.getFunction().addModifiers((exportationModifiers126!=null?exportationModifiers126.modifiers:null));
              		
            }
            char_literal129=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffixNoName2151); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal129_tree = (Object)adaptor.create(char_literal129);
            adaptor.addChild(root_0, char_literal129_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:765:7: (a1= argDef ( ',' ax= argDef )* )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==IDENTIFIER||LA57_0==30||(LA57_0>=44 && LA57_0<=47)||(LA57_0>=60 && LA57_0<=74)) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:766:4: a1= argDef ( ',' ax= argDef )*
                    {
                    pushFollow(FOLLOW_argDef_in_functionSignatureSuffixNoName2160);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					((FunctionSignature)retval.signature).getFunction().addArg((a1!=null?a1.arg:null)); 
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:770:4: ( ',' ax= argDef )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==27) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:771:5: ',' ax= argDef
                    	    {
                    	    char_literal130=(Token)match(input,27,FOLLOW_27_in_functionSignatureSuffixNoName2173); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal130_tree = (Object)adaptor.create(char_literal130);
                    	    adaptor.addChild(root_0, char_literal130_tree);
                    	    }
                    	    pushFollow(FOLLOW_argDef_in_functionSignatureSuffixNoName2182);
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

            char_literal131=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffixNoName2197); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal131_tree = (Object)adaptor.create(char_literal131);
            adaptor.addChild(root_0, char_literal131_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:779:1: structOrEnum returns [TypeRef type] : ( structCore | enumCore );
    public final ObjCppParser.structOrEnum_return structOrEnum() throws RecognitionException {
        ObjCppParser.structOrEnum_return retval = new ObjCppParser.structOrEnum_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.structCore_return structCore132 = null;

        ObjCppParser.enumCore_return enumCore133 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:780:2: ( structCore | enumCore )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:781:3: structCore
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_structCore_in_structOrEnum2215);
                    structCore132=structCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structCore132.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (structCore132!=null?structCore132.struct:null); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:782:3: enumCore
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_enumCore_in_structOrEnum2223);
                    enumCore133=enumCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, enumCore133.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (enumCore133!=null?enumCore133.e:null); 
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:785:1: typeRefCoreOrFuncSig returns [TypeRef type] : typeRefCore ( ( typeMutator )* functionSignatureSuffix )? ;
    public final ObjCppParser.typeRefCoreOrFuncSig_return typeRefCoreOrFuncSig() throws RecognitionException {
        ObjCppParser.typeRefCoreOrFuncSig_return retval = new ObjCppParser.typeRefCoreOrFuncSig_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.typeRefCore_return typeRefCore134 = null;

        ObjCppParser.typeMutator_return typeMutator135 = null;

        ObjCppParser.functionSignatureSuffix_return functionSignatureSuffix136 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:786:2: ( typeRefCore ( ( typeMutator )* functionSignatureSuffix )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:786:4: typeRefCore ( ( typeMutator )* functionSignatureSuffix )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_typeRefCore_in_typeRefCoreOrFuncSig2241);
            typeRefCore134=typeRefCore();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRefCore134.getTree());
            if ( state.backtracking==0 ) {
               retval.type = (typeRefCore134!=null?typeRefCore134.type:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:787:3: ( ( typeMutator )* functionSignatureSuffix )?
            int alt60=2;
            alt60 = dfa60.predict(input);
            switch (alt60) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:788:4: ( typeMutator )* functionSignatureSuffix
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:788:4: ( typeMutator )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==IDENTIFIER||(LA59_0>=51 && LA59_0<=53)) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:789:5: typeMutator
                    	    {
                    	    pushFollow(FOLLOW_typeMutator_in_typeRefCoreOrFuncSig2258);
                    	    typeMutator135=typeMutator();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeMutator135.getTree());
                    	    if ( state.backtracking==0 ) {

                    	      					retval.type = (typeMutator135!=null?typeMutator135.mutator:null).mutateType(retval.type);
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop59;
                        }
                    } while (true);

                    pushFollow(FOLLOW_functionSignatureSuffix_in_typeRefCoreOrFuncSig2271);
                    functionSignatureSuffix136=functionSignatureSuffix();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionSignatureSuffix136.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				(functionSignatureSuffix136!=null?functionSignatureSuffix136.signature:null).getFunction().setValueType(retval.type); 
                      				retval.type = (functionSignatureSuffix136!=null?functionSignatureSuffix136.signature:null);
                      			
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:800:1: typeRefCoreOrAnonymousFuncSig returns [TypeRef type] : typeRefCore ( ( typeMutator )* functionSignatureSuffixNoName )? ;
    public final ObjCppParser.typeRefCoreOrAnonymousFuncSig_return typeRefCoreOrAnonymousFuncSig() throws RecognitionException {
        ObjCppParser.typeRefCoreOrAnonymousFuncSig_return retval = new ObjCppParser.typeRefCoreOrAnonymousFuncSig_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.typeRefCore_return typeRefCore137 = null;

        ObjCppParser.typeMutator_return typeMutator138 = null;

        ObjCppParser.functionSignatureSuffixNoName_return functionSignatureSuffixNoName139 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:801:2: ( typeRefCore ( ( typeMutator )* functionSignatureSuffixNoName )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:801:4: typeRefCore ( ( typeMutator )* functionSignatureSuffixNoName )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_typeRefCore_in_typeRefCoreOrAnonymousFuncSig2295);
            typeRefCore137=typeRefCore();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRefCore137.getTree());
            if ( state.backtracking==0 ) {
               retval.type = (typeRefCore137!=null?typeRefCore137.type:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:802:3: ( ( typeMutator )* functionSignatureSuffixNoName )?
            int alt62=2;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:803:4: ( typeMutator )* functionSignatureSuffixNoName
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:803:4: ( typeMutator )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==IDENTIFIER||(LA61_0>=51 && LA61_0<=53)) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:804:5: typeMutator
                    	    {
                    	    pushFollow(FOLLOW_typeMutator_in_typeRefCoreOrAnonymousFuncSig2312);
                    	    typeMutator138=typeMutator();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeMutator138.getTree());
                    	    if ( state.backtracking==0 ) {

                    	      					retval.type = (typeMutator138!=null?typeMutator138.mutator:null).mutateType(retval.type);
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop61;
                        }
                    } while (true);

                    pushFollow(FOLLOW_functionSignatureSuffixNoName_in_typeRefCoreOrAnonymousFuncSig2325);
                    functionSignatureSuffixNoName139=functionSignatureSuffixNoName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionSignatureSuffixNoName139.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				(functionSignatureSuffixNoName139!=null?functionSignatureSuffixNoName139.signature:null).getFunction().setValueType(retval.type); 
                      				retval.type = (functionSignatureSuffixNoName139!=null?functionSignatureSuffixNoName139.signature:null);
                      			
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:815:1: plainTypeRef returns [TypeRef type] : ( structOrEnum | typeRefCoreOrFuncSig );
    public final ObjCppParser.plainTypeRef_return plainTypeRef() throws RecognitionException {
        ObjCppParser.plainTypeRef_return retval = new ObjCppParser.plainTypeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.structOrEnum_return structOrEnum140 = null;

        ObjCppParser.typeRefCoreOrFuncSig_return typeRefCoreOrFuncSig141 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:816:2: ( structOrEnum | typeRefCoreOrFuncSig )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==30||(LA63_0>=45 && LA63_0<=47)) ) {
                alt63=1;
            }
            else if ( (LA63_0==IDENTIFIER||(LA63_0>=60 && LA63_0<=74)) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:817:3: structOrEnum
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_structOrEnum_in_plainTypeRef2352);
                    structOrEnum140=structOrEnum();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structOrEnum140.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (structOrEnum140!=null?structOrEnum140.type:null); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:818:3: typeRefCoreOrFuncSig
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_typeRefCoreOrFuncSig_in_plainTypeRef2360);
                    typeRefCoreOrFuncSig141=typeRefCoreOrFuncSig();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRefCoreOrFuncSig141.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (typeRefCoreOrFuncSig141!=null?typeRefCoreOrFuncSig141.type:null); 
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:821:1: declarator returns [Declarator declarator, List<Modifier> modifiers] : ({...}? modifier )* ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? ) ;
    public final ObjCppParser.declarator_return declarator() throws RecognitionException {
        ObjCppParser.declarator_return retval = new ObjCppParser.declarator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token pt=null;
        Token char_literal144=null;
        ObjCppParser.declarator_return inner = null;

        ObjCppParser.modifier_return modifier142 = null;

        ObjCppParser.directDeclarator_return directDeclarator143 = null;

        ObjCppParser.expression_return expression145 = null;


        Object pt_tree=null;
        Object char_literal144_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:822:2: ( ({...}? modifier )* ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:822:4: ({...}? modifier )* ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:823:3: ({...}? modifier )*
            loop64:
            do {
                int alt64=2;
                alt64 = dfa64.predict(input);
                switch (alt64) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:824:4: {...}? modifier
            	    {
            	    if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "declarator", " next(Modifier.Kind.TypeQualifier) ");
            	    }
            	    pushFollow(FOLLOW_modifier_in_declarator2389);
            	    modifier142=modifier();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, modifier142.getTree());
            	    if ( state.backtracking==0 ) {

            	      				retval.modifiers.add((modifier142!=null?modifier142.modifier:null));
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:831:3: ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:832:4: ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )?
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:832:4: ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( ((LA65_0>=51 && LA65_0<=52)||LA65_0==58) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:833:5: (pt= ( '*' | '&' | '^' ) inner= declarator )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:833:5: (pt= ( '*' | '&' | '^' ) inner= declarator )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:834:6: pt= ( '*' | '&' | '^' ) inner= declarator
                    {
                    pt=(Token)input.LT(1);
                    if ( (input.LA(1)>=51 && input.LA(1)<=52)||input.LA(1)==58 ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(pt));
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_declarator_in_declarator2445);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:839:5: directDeclarator
                    {
                    pushFollow(FOLLOW_directDeclarator_in_declarator2461);
                    directDeclarator143=directDeclarator();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, directDeclarator143.getTree());
                    if ( state.backtracking==0 ) {
                       
                      					retval.declarator = (directDeclarator143!=null?directDeclarator143.declarator:null); 
                      				
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:843:4: ( '=' expression )?
            int alt66=2;
            alt66 = dfa66.predict(input);
            switch (alt66) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:844:5: '=' expression
                    {
                    char_literal144=(Token)match(input,29,FOLLOW_29_in_declarator2480); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal144_tree = (Object)adaptor.create(char_literal144);
                    adaptor.addChild(root_0, char_literal144_tree);
                    }
                    pushFollow(FOLLOW_expression_in_declarator2487);
                    expression145=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression145.getTree());
                    if ( state.backtracking==0 ) {

                      					retval.declarator.setDefaultValue((expression145!=null?expression145.expr:null));
                      				
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              			if (retval.declarator != null)
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:857:1: namedTypeRef returns [TaggedTypeRef type] : ( structCore {...}? | enumCore {...}?);
    public final ObjCppParser.namedTypeRef_return namedTypeRef() throws RecognitionException {
        ObjCppParser.namedTypeRef_return retval = new ObjCppParser.namedTypeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.structCore_return structCore146 = null;

        ObjCppParser.enumCore_return enumCore147 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:858:2: ( structCore {...}? | enumCore {...}?)
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:859:3: structCore {...}?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_structCore_in_namedTypeRef2521);
                    structCore146=structCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structCore146.getTree());
                    if ( !(( (structCore146!=null?structCore146.struct:null).getTag() != null )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "namedTypeRef", " $structCore.struct.getTag() != null ");
                    }
                    if ( state.backtracking==0 ) {

                      			retval.type = (structCore146!=null?structCore146.struct:null);
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:862:3: enumCore {...}?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_enumCore_in_namedTypeRef2531);
                    enumCore147=enumCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, enumCore147.getTree());
                    if ( !(( (enumCore147!=null?enumCore147.e:null).getTag() != null )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "namedTypeRef", " $enumCore.e.getTag() != null ");
                    }
                    if ( state.backtracking==0 ) {

                      			retval.type = (enumCore147!=null?enumCore147.e:null);
                      		
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:867:1: typeDef returns [TypeDef typeDef] : 'typedef' varDecl {...}?;
    public final ObjCppParser.typeDef_return typeDef() throws RecognitionException {
        ObjCppParser.typeDef_return retval = new ObjCppParser.typeDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal148=null;
        ObjCppParser.varDecl_return varDecl149 = null;


        Object string_literal148_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:868:2: ( 'typedef' varDecl {...}?)
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:868:4: 'typedef' varDecl {...}?
            {
            root_0 = (Object)adaptor.nil();

            string_literal148=(Token)match(input,59,FOLLOW_59_in_typeDef2550); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal148_tree = (Object)adaptor.create(string_literal148);
            adaptor.addChild(root_0, string_literal148_tree);
            }
            pushFollow(FOLLOW_varDecl_in_typeDef2556);
            varDecl149=varDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl149.getTree());
            if ( !(( 
            			((varDecl149!=null?varDecl149.decl:null) instanceof VariablesDeclaration) 
            		)) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "typeDef", " \n\t\t\t($varDecl.decl instanceof VariablesDeclaration) \n\t\t");
            }
            if ( state.backtracking==0 ) {

              			VariablesDeclaration vd = (VariablesDeclaration)(varDecl149!=null?varDecl149.decl:null);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:877:1: varDeclEOF returns [Declaration decl] : varDecl EOF ;
    public final ObjCppParser.varDeclEOF_return varDeclEOF() throws RecognitionException {
        ObjCppParser.varDeclEOF_return retval = new ObjCppParser.varDeclEOF_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF151=null;
        ObjCppParser.varDecl_return varDecl150 = null;


        Object EOF151_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:878:2: ( varDecl EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:878:4: varDecl EOF
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_varDecl_in_varDeclEOF2576);
            varDecl150=varDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl150.getTree());
            EOF151=(Token)match(input,EOF,FOLLOW_EOF_in_varDeclEOF2578); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EOF151_tree = (Object)adaptor.create(EOF151);
            adaptor.addChild(root_0, EOF151_tree);
            }
            if ( state.backtracking==0 ) {
               retval.decl = (varDecl150!=null?varDecl150.decl:null); 
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:881:1: varDecl returns [Declaration decl, TypeRef type] : ({...}?sm= modifier | {...}?tm= modifier )* ( ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList ) ) ';' ;
    public final ObjCppParser.varDecl_return varDecl() throws RecognitionException {
        ObjCppParser.varDecl_return retval = new ObjCppParser.varDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal153=null;
        ObjCppParser.modifier_return sm = null;

        ObjCppParser.modifier_return tm = null;

        ObjCppParser.declaratorsList_return d1 = null;

        ObjCppParser.typeRefCoreOrAnonymousFuncSig_return tcfs = null;

        ObjCppParser.declaratorsList_return d2 = null;

        ObjCppParser.structOrEnum_return structOrEnum152 = null;


        Object char_literal153_tree=null;


        	List<Modifier> stoMods = new ArrayList<Modifier>(), typMods = new ArrayList<Modifier>();

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:885:2: ( ({...}?sm= modifier | {...}?tm= modifier )* ( ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList ) ) ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:885:4: ({...}?sm= modifier | {...}?tm= modifier )* ( ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList ) ) ';'
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:885:4: ({...}?sm= modifier | {...}?tm= modifier )*
            loop68:
            do {
                int alt68=3;
                alt68 = dfa68.predict(input);
                switch (alt68) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:886:4: {...}?sm= modifier
            	    {
            	    if ( !(( next(Modifier.Kind.StorageClassSpecifier) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "varDecl", " next(Modifier.Kind.StorageClassSpecifier) ");
            	    }
            	    pushFollow(FOLLOW_modifier_in_varDecl2615);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:888:4: {...}?tm= modifier
            	    {
            	    if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "varDecl", " next(Modifier.Kind.TypeQualifier) ");
            	    }
            	    pushFollow(FOLLOW_modifier_in_varDecl2632);
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:891:3: ( ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:895:4: ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList )
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:895:4: ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==30||(LA70_0>=45 && LA70_0<=47)) ) {
                alt70=1;
            }
            else if ( (LA70_0==IDENTIFIER||(LA70_0>=60 && LA70_0<=74)) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:896:5: structOrEnum ( (d1= declaratorsList )? )
                    {
                    pushFollow(FOLLOW_structOrEnum_in_varDecl2659);
                    structOrEnum152=structOrEnum();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structOrEnum152.getTree());
                    if ( state.backtracking==0 ) {
                       
                      					retval.type = (structOrEnum152!=null?structOrEnum152.type:null);
                      					//retval.decl = new VariablesDeclaration(retval.type);
                      				
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:900:5: ( (d1= declaratorsList )? )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:901:6: (d1= declaratorsList )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:901:8: (d1= declaratorsList )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==IDENTIFIER||LA69_0==34||(LA69_0>=51 && LA69_0<=52)||LA69_0==58) ) {
                        alt69=1;
                    }
                    switch (alt69) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: d1= declaratorsList
                            {
                            pushFollow(FOLLOW_declaratorsList_in_varDecl2676);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:908:5: tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList
                    {
                    pushFollow(FOLLOW_typeRefCoreOrAnonymousFuncSig_in_varDecl2696);
                    tcfs=typeRefCoreOrAnonymousFuncSig();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tcfs.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (tcfs!=null?tcfs.type:null); 
                    }
                    pushFollow(FOLLOW_declaratorsList_in_varDecl2706);
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

            char_literal153=(Token)match(input,28,FOLLOW_28_in_varDecl2743); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal153_tree = (Object)adaptor.create(char_literal153);
            adaptor.addChild(root_0, char_literal153_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.decl.addModifiers(stoMods);
              			if (retval.type != null)
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:937:1: objCProtocolRefList : '<' IDENTIFIER ( ',' IDENTIFIER )* '>' ;
    public final ObjCppParser.objCProtocolRefList_return objCProtocolRefList() throws RecognitionException {
        ObjCppParser.objCProtocolRefList_return retval = new ObjCppParser.objCProtocolRefList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal154=null;
        Token IDENTIFIER155=null;
        Token char_literal156=null;
        Token IDENTIFIER157=null;
        Token char_literal158=null;

        Object char_literal154_tree=null;
        Object IDENTIFIER155_tree=null;
        Object char_literal156_tree=null;
        Object IDENTIFIER157_tree=null;
        Object char_literal158_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:938:2: ( '<' IDENTIFIER ( ',' IDENTIFIER )* '>' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:938:4: '<' IDENTIFIER ( ',' IDENTIFIER )* '>'
            {
            root_0 = (Object)adaptor.nil();

            char_literal154=(Token)match(input,36,FOLLOW_36_in_objCProtocolRefList2757); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal154_tree = (Object)adaptor.create(char_literal154);
            adaptor.addChild(root_0, char_literal154_tree);
            }
            IDENTIFIER155=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCProtocolRefList2762); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER155_tree = (Object)adaptor.create(IDENTIFIER155);
            adaptor.addChild(root_0, IDENTIFIER155_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:940:3: ( ',' IDENTIFIER )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==27) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:941:4: ',' IDENTIFIER
            	    {
            	    char_literal156=(Token)match(input,27,FOLLOW_27_in_objCProtocolRefList2772); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal156_tree = (Object)adaptor.create(char_literal156);
            	    adaptor.addChild(root_0, char_literal156_tree);
            	    }
            	    IDENTIFIER157=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCProtocolRefList2778); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDENTIFIER157_tree = (Object)adaptor.create(IDENTIFIER157);
            	    adaptor.addChild(root_0, IDENTIFIER157_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);

            char_literal158=(Token)match(input,37,FOLLOW_37_in_objCProtocolRefList2788); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal158_tree = (Object)adaptor.create(char_literal158);
            adaptor.addChild(root_0, char_literal158_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:954:1: declaratorsList returns [List<Declarator> declarators] : (d= declarator ( ',' x= declarator )* ) ;
    public final ObjCppParser.declaratorsList_return declaratorsList() throws RecognitionException {
        ObjCppParser.declaratorsList_return retval = new ObjCppParser.declaratorsList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal159=null;
        ObjCppParser.declarator_return d = null;

        ObjCppParser.declarator_return x = null;


        Object char_literal159_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:955:2: ( (d= declarator ( ',' x= declarator )* ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:955:4: (d= declarator ( ',' x= declarator )* )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.declarators = new ArrayList<Declarator>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:956:3: (d= declarator ( ',' x= declarator )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:957:4: d= declarator ( ',' x= declarator )*
            {
            pushFollow(FOLLOW_declarator_in_declaratorsList2815);
            d=declarator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());
            if ( state.backtracking==0 ) {
               retval.declarators.add((d!=null?d.declarator:null)); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:958:4: ( ',' x= declarator )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==27) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:959:5: ',' x= declarator
            	    {
            	    char_literal159=(Token)match(input,27,FOLLOW_27_in_declaratorsList2828); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal159_tree = (Object)adaptor.create(char_literal159);
            	    adaptor.addChild(root_0, char_literal159_tree);
            	    }
            	    pushFollow(FOLLOW_declarator_in_declaratorsList2837);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:965:1: directDeclarator returns [Declarator declarator] : ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' ) ( '[' ( expression | ) ']' | argList )* ;
    public final ObjCppParser.directDeclarator_return directDeclarator() throws RecognitionException {
        ObjCppParser.directDeclarator_return retval = new ObjCppParser.directDeclarator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER160=null;
        Token char_literal161=null;
        Token char_literal162=null;
        Token char_literal163=null;
        Token char_literal165=null;
        ObjCppParser.modifier_return im = null;

        ObjCppParser.declarator_return inner = null;

        ObjCppParser.expression_return expression164 = null;

        ObjCppParser.argList_return argList166 = null;


        Object IDENTIFIER160_tree=null;
        Object char_literal161_tree=null;
        Object char_literal162_tree=null;
        Object char_literal163_tree=null;
        Object char_literal165_tree=null;


        	List<Modifier> modifiers = new ArrayList<Modifier>();

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:969:2: ( ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' ) ( '[' ( expression | ) ']' | argList )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:969:4: ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' ) ( '[' ( expression | ) ']' | argList )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:969:4: ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:971:4: IDENTIFIER
                    {
                    IDENTIFIER160=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_directDeclarator2880); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER160_tree = (Object)adaptor.create(IDENTIFIER160);
                    adaptor.addChild(root_0, IDENTIFIER160_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				retval.declarator = new DirectDeclarator((IDENTIFIER160!=null?IDENTIFIER160.getText():null));
                      			
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:974:4: '(' (im= modifier )* inner= declarator ')'
                    {
                    char_literal161=(Token)match(input,34,FOLLOW_34_in_directDeclarator2890); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal161_tree = (Object)adaptor.create(char_literal161);
                    adaptor.addChild(root_0, char_literal161_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:975:4: (im= modifier )*
                    loop73:
                    do {
                        int alt73=2;
                        alt73 = dfa73.predict(input);
                        switch (alt73) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:975:5: im= modifier
                    	    {
                    	    pushFollow(FOLLOW_modifier_in_directDeclarator2899);
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

                    pushFollow(FOLLOW_declarator_in_directDeclarator2910);
                    inner=declarator();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inner.getTree());
                    char_literal162=(Token)match(input,35,FOLLOW_35_in_directDeclarator2916); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal162_tree = (Object)adaptor.create(char_literal162);
                    adaptor.addChild(root_0, char_literal162_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				retval.declarator = (inner!=null?inner.declarator:null);
                      				retval.declarator.setParenthesized(true);
                      				retval.declarator.addModifiers(modifiers);
                      			
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:983:3: ( '[' ( expression | ) ']' | argList )*
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:984:4: '[' ( expression | ) ']'
            	    {
            	    char_literal163=(Token)match(input,53,FOLLOW_53_in_directDeclarator2931); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal163_tree = (Object)adaptor.create(char_literal163);
            	    adaptor.addChild(root_0, char_literal163_tree);
            	    }
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:985:4: ( expression | )
            	    int alt75=2;
            	    alt75 = dfa75.predict(input);
            	    switch (alt75) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:986:5: expression
            	            {
            	            pushFollow(FOLLOW_expression_in_directDeclarator2943);
            	            expression164=expression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression164.getTree());
            	            if ( state.backtracking==0 ) {

            	              					if (retval.declarator instanceof ArrayDeclarator)
            	              						((ArrayDeclarator)retval.declarator).addDimension((expression164!=null?expression164.expr:null));
            	              					else
            	              						retval.declarator = new ArrayDeclarator(retval.declarator, (expression164!=null?expression164.expr:null));
            	              				
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:991:9: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              					retval.declarator = new ArrayDeclarator(retval.declarator, new Expression.EmptyArraySize());
            	              				
            	            }

            	            }
            	            break;

            	    }

            	    char_literal165=(Token)match(input,54,FOLLOW_54_in_directDeclarator2959); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal165_tree = (Object)adaptor.create(char_literal165);
            	    adaptor.addChild(root_0, char_literal165_tree);
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:996:4: argList
            	    {
            	    pushFollow(FOLLOW_argList_in_directDeclarator2967);
            	    argList166=argList();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, argList166.getTree());
            	    if ( state.backtracking==0 ) {

            	      				retval.declarator = new FunctionDeclarator(retval.declarator, (argList166!=null?argList166.args:null));
            	      			
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1002:1: argList returns [List<Arg> args, boolean isObjC] : op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')' ;
    public final ObjCppParser.argList_return argList() throws RecognitionException {
        ObjCppParser.argList_return retval = new ObjCppParser.argList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        Token cp=null;
        Token char_literal167=null;
        Token char_literal168=null;
        Token string_literal169=null;
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        Object op_tree=null;
        Object cp_tree=null;
        Object char_literal167_tree=null;
        Object char_literal168_tree=null;
        Object string_literal169_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1003:2: (op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1003:4: op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               
              			retval.isObjC = false; 
              			retval.args = new ArrayList<Arg>();
              		
            }
            op=(Token)match(input,34,FOLLOW_34_in_argList2995); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            op_tree = (Object)adaptor.create(op);
            adaptor.addChild(root_0, op_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1008:3: (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==IDENTIFIER||LA79_0==30||(LA79_0>=44 && LA79_0<=47)||(LA79_0>=60 && LA79_0<=74)) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1009:4: a1= argDef ( ',' ax= argDef )* ( ',' '...' )?
                    {
                    pushFollow(FOLLOW_argDef_in_argList3007);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {

                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					retval.args.add((a1!=null?a1.arg:null));
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1013:4: ( ',' ax= argDef )*
                    loop77:
                    do {
                        int alt77=2;
                        alt77 = dfa77.predict(input);
                        switch (alt77) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1014:5: ',' ax= argDef
                    	    {
                    	    char_literal167=(Token)match(input,27,FOLLOW_27_in_argList3020); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal167_tree = (Object)adaptor.create(char_literal167);
                    	    adaptor.addChild(root_0, char_literal167_tree);
                    	    }
                    	    pushFollow(FOLLOW_argDef_in_argList3029);
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

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1019:4: ( ',' '...' )?
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==27) ) {
                        alt78=1;
                    }
                    switch (alt78) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1020:5: ',' '...'
                            {
                            char_literal168=(Token)match(input,27,FOLLOW_27_in_argList3049); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal168_tree = (Object)adaptor.create(char_literal168);
                            adaptor.addChild(root_0, char_literal168_tree);
                            }
                            string_literal169=(Token)match(input,44,FOLLOW_44_in_argList3051); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal169_tree = (Object)adaptor.create(string_literal169);
                            adaptor.addChild(root_0, string_literal169_tree);
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

            cp=(Token)match(input,35,FOLLOW_35_in_argList3070); if (state.failed) return retval;
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

    public static class typeRef_return extends ParserRuleReturnScope {
        public TypeRef type;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeRef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1029:1: typeRef returns [TypeRef type] : plainTypeRef ( typeMutator )* ;
    public final ObjCppParser.typeRef_return typeRef() throws RecognitionException {
        ObjCppParser.typeRef_return retval = new ObjCppParser.typeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.plainTypeRef_return plainTypeRef170 = null;

        ObjCppParser.typeMutator_return typeMutator171 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1030:2: ( plainTypeRef ( typeMutator )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1031:3: plainTypeRef ( typeMutator )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_plainTypeRef_in_typeRef3088);
            plainTypeRef170=plainTypeRef();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, plainTypeRef170.getTree());
            if ( state.backtracking==0 ) {

              			retval.type = (plainTypeRef170!=null?plainTypeRef170.type:null);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1034:3: ( typeMutator )*
            loop80:
            do {
                int alt80=2;
                alt80 = dfa80.predict(input);
                switch (alt80) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1035:4: typeMutator
            	    {
            	    pushFollow(FOLLOW_typeMutator_in_typeRef3099);
            	    typeMutator171=typeMutator();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeMutator171.getTree());
            	    if ( state.backtracking==0 ) {

            	      				retval.type = (typeMutator171!=null?typeMutator171.mutator:null).mutateType(retval.type);
            	      			
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1041:1: primSignModifier : ( 'signed' | 'unsigned' | '__signed' | '__unsigned' );
    public final ObjCppParser.primSignModifier_return primSignModifier() throws RecognitionException {
        ObjCppParser.primSignModifier_return retval = new ObjCppParser.primSignModifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set172=null;

        Object set172_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1042:2: ( 'signed' | 'unsigned' | '__signed' | '__unsigned' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:
            {
            root_0 = (Object)adaptor.nil();

            set172=(Token)input.LT(1);
            if ( (input.LA(1)>=60 && input.LA(1)<=63) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set172));
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1044:1: primSizeModifier : ( 'long' | 'short' );
    public final ObjCppParser.primSizeModifier_return primSizeModifier() throws RecognitionException {
        ObjCppParser.primSizeModifier_return retval = new ObjCppParser.primSizeModifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set173=null;

        Object set173_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1045:2: ( 'long' | 'short' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:
            {
            root_0 = (Object)adaptor.nil();

            set173=(Token)input.LT(1);
            if ( (input.LA(1)>=64 && input.LA(1)<=65) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set173));
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1047:1: primitiveTypeName : ( 'long' | 'int' | 'short' | 'double' | 'float' | 'char' | 'void' | '__int8' | '__int16' | '__int32' | '__int64' );
    public final ObjCppParser.primitiveTypeName_return primitiveTypeName() throws RecognitionException {
        ObjCppParser.primitiveTypeName_return retval = new ObjCppParser.primitiveTypeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set174=null;

        Object set174_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1048:2: ( 'long' | 'int' | 'short' | 'double' | 'float' | 'char' | 'void' | '__int8' | '__int16' | '__int32' | '__int64' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:
            {
            root_0 = (Object)adaptor.nil();

            set174=(Token)input.LT(1);
            if ( (input.LA(1)>=64 && input.LA(1)<=74) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set174));
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1060:1: primitiveTypeRef returns [TypeRef type, int line, List<Modifier> modifiers] : ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) ) ;
    public final ObjCppParser.primitiveTypeRef_return primitiveTypeRef() throws RecognitionException {
        ObjCppParser.primitiveTypeRef_return retval = new ObjCppParser.primitiveTypeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.primSignModifier_return mod1 = null;

        ObjCppParser.primSizeModifier_return mod2 = null;

        ObjCppParser.primSizeModifier_return mod3 = null;

        ObjCppParser.primitiveTypeName_return name = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1061:2: ( ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1061:4: ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               
              			retval.line = getLine(); 
              			retval.modifiers = new ArrayList<Modifier>();
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1065:3: ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1066:4: (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName )
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1066:8: (mod1= primSignModifier )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( ((LA81_0>=60 && LA81_0<=63)) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: mod1= primSignModifier
                    {
                    pushFollow(FOLLOW_primSignModifier_in_primitiveTypeRef3238);
                    mod1=primSignModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mod1.getTree());

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1067:4: (mod2= primSizeModifier (mod3= primSizeModifier )? )?
            int alt83=2;
            alt83 = dfa83.predict(input);
            switch (alt83) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1067:5: mod2= primSizeModifier (mod3= primSizeModifier )?
                    {
                    pushFollow(FOLLOW_primSizeModifier_in_primitiveTypeRef3249);
                    mod2=primSizeModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mod2.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1068:8: (mod3= primSizeModifier )?
                    int alt82=2;
                    alt82 = dfa82.predict(input);
                    switch (alt82) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: mod3= primSizeModifier
                            {
                            pushFollow(FOLLOW_primSizeModifier_in_primitiveTypeRef3256);
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1076:4: (name= primitiveTypeName )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1079:5: name= primitiveTypeName
            {
            pushFollow(FOLLOW_primitiveTypeName_in_primitiveTypeRef3299);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1108:1: objCMethodCall returns [FunctionCall expr] : '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']' ;
    public final ObjCppParser.objCMethodCall_return objCMethodCall() throws RecognitionException {
        ObjCppParser.objCMethodCall_return retval = new ObjCppParser.objCMethodCall_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token methodName=null;
        Token selx=null;
        Token char_literal175=null;
        Token char_literal176=null;
        Token char_literal177=null;
        Token char_literal178=null;
        ObjCppParser.expression_return target = null;

        ObjCppParser.expression_return arg1 = null;

        ObjCppParser.expression_return argx = null;


        Object methodName_tree=null;
        Object selx_tree=null;
        Object char_literal175_tree=null;
        Object char_literal176_tree=null;
        Object char_literal177_tree=null;
        Object char_literal178_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1109:2: ( '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1110:3: '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']'
            {
            root_0 = (Object)adaptor.nil();

            char_literal175=(Token)match(input,53,FOLLOW_53_in_objCMethodCall3338); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal175_tree = (Object)adaptor.create(char_literal175);
            adaptor.addChild(root_0, char_literal175_tree);
            }
            pushFollow(FOLLOW_expression_in_objCMethodCall3342);
            target=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, target.getTree());
            methodName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodCall3346); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            methodName_tree = (Object)adaptor.create(methodName);
            adaptor.addChild(root_0, methodName_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.expr = new FunctionCall((methodName!=null?methodName.getText():null));
              			retval.expr.setTarget((target!=null?target.expr:null));
              			retval.expr.setMemberRefStyle(MemberRefStyle.SquareBrackets);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1115:3: ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==33) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1116:4: ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )*
                    {
                    char_literal176=(Token)match(input,33,FOLLOW_33_in_objCMethodCall3357); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal176_tree = (Object)adaptor.create(char_literal176);
                    adaptor.addChild(root_0, char_literal176_tree);
                    }
                    pushFollow(FOLLOW_expression_in_objCMethodCall3361);
                    arg1=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arg1.getTree());
                    if ( state.backtracking==0 ) {

                      				retval.expr.addArgument(null, (arg1!=null?arg1.expr:null));
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1119:4: (selx= IDENTIFIER ':' argx= expression )*
                    loop84:
                    do {
                        int alt84=2;
                        int LA84_0 = input.LA(1);

                        if ( (LA84_0==IDENTIFIER) ) {
                            alt84=1;
                        }


                        switch (alt84) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1120:5: selx= IDENTIFIER ':' argx= expression
                    	    {
                    	    selx=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodCall3376); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    selx_tree = (Object)adaptor.create(selx);
                    	    adaptor.addChild(root_0, selx_tree);
                    	    }
                    	    char_literal177=(Token)match(input,33,FOLLOW_33_in_objCMethodCall3378); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal177_tree = (Object)adaptor.create(char_literal177);
                    	    adaptor.addChild(root_0, char_literal177_tree);
                    	    }
                    	    pushFollow(FOLLOW_expression_in_objCMethodCall3382);
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

            char_literal178=(Token)match(input,54,FOLLOW_54_in_objCMethodCall3399); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal178_tree = (Object)adaptor.create(char_literal178);
            adaptor.addChild(root_0, char_literal178_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1128:1: functionCall returns [FunctionCall expr] : ( 'sizeof' '(' typeRef ')' | IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')' );
    public final ObjCppParser.functionCall_return functionCall() throws RecognitionException {
        ObjCppParser.functionCall_return retval = new ObjCppParser.functionCall_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal179=null;
        Token char_literal180=null;
        Token char_literal182=null;
        Token IDENTIFIER183=null;
        Token char_literal184=null;
        Token char_literal185=null;
        Token char_literal186=null;
        ObjCppParser.expression_return a1 = null;

        ObjCppParser.expression_return ax = null;

        ObjCppParser.typeRef_return typeRef181 = null;


        Object string_literal179_tree=null;
        Object char_literal180_tree=null;
        Object char_literal182_tree=null;
        Object IDENTIFIER183_tree=null;
        Object char_literal184_tree=null;
        Object char_literal185_tree=null;
        Object char_literal186_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1129:2: ( 'sizeof' '(' typeRef ')' | IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')' )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==75) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1130:3: 'sizeof' '(' typeRef ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal179=(Token)match(input,75,FOLLOW_75_in_functionCall3419); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal179_tree = (Object)adaptor.create(string_literal179);
                    adaptor.addChild(root_0, string_literal179_tree);
                    }
                    char_literal180=(Token)match(input,34,FOLLOW_34_in_functionCall3421); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal180_tree = (Object)adaptor.create(char_literal180);
                    adaptor.addChild(root_0, char_literal180_tree);
                    }
                    pushFollow(FOLLOW_typeRef_in_functionCall3423);
                    typeRef181=typeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRef181.getTree());
                    char_literal182=(Token)match(input,35,FOLLOW_35_in_functionCall3425); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal182_tree = (Object)adaptor.create(char_literal182);
                    adaptor.addChild(root_0, char_literal182_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			retval.expr = new FunctionCall("sizeof");
                      			retval.expr.addArgument(new TypeRefExpression((typeRef181!=null?typeRef181.type:null)));
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1134:3: IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    IDENTIFIER183=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionCall3433); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER183_tree = (Object)adaptor.create(IDENTIFIER183);
                    adaptor.addChild(root_0, IDENTIFIER183_tree);
                    }
                    char_literal184=(Token)match(input,34,FOLLOW_34_in_functionCall3435); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal184_tree = (Object)adaptor.create(char_literal184);
                    adaptor.addChild(root_0, char_literal184_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			retval.expr = new FunctionCall((IDENTIFIER183!=null?IDENTIFIER183.getText():null));
                      		
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1137:3: (a1= expression ( ',' ax= expression )* )?
                    int alt87=2;
                    alt87 = dfa87.predict(input);
                    switch (alt87) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1138:4: a1= expression ( ',' ax= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_functionCall3448);
                            a1=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                            if ( state.backtracking==0 ) {

                              				retval.expr.addArgument((a1!=null?a1.expr:null));
                              			
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1141:4: ( ',' ax= expression )*
                            loop86:
                            do {
                                int alt86=2;
                                int LA86_0 = input.LA(1);

                                if ( (LA86_0==27) ) {
                                    alt86=1;
                                }


                                switch (alt86) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1141:6: ',' ax= expression
                            	    {
                            	    char_literal185=(Token)match(input,27,FOLLOW_27_in_functionCall3457); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    char_literal185_tree = (Object)adaptor.create(char_literal185);
                            	    adaptor.addChild(root_0, char_literal185_tree);
                            	    }
                            	    pushFollow(FOLLOW_expression_in_functionCall3466);
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

                    char_literal186=(Token)match(input,35,FOLLOW_35_in_functionCall3484); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal186_tree = (Object)adaptor.create(char_literal186);
                    adaptor.addChild(root_0, char_literal186_tree);
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

    public static class binaryOp_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "binaryOp"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1150:1: binaryOp : ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' );
    public final ObjCppParser.binaryOp_return binaryOp() throws RecognitionException {
        ObjCppParser.binaryOp_return retval = new ObjCppParser.binaryOp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set187=null;

        Object set187_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1150:10: ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:
            {
            root_0 = (Object)adaptor.nil();

            set187=(Token)input.LT(1);
            if ( (input.LA(1)>=36 && input.LA(1)<=37)||(input.LA(1)>=42 && input.LA(1)<=43)||(input.LA(1)>=51 && input.LA(1)<=52)||input.LA(1)==58||(input.LA(1)>=76 && input.LA(1)<=87) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set187));
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
    // $ANTLR end "binaryOp"

    public static class expression_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1154:1: expression returns [Expression expr] : (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' ) (bop= binaryOp opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )* ;
    public final ObjCppParser.expression_return expression() throws RecognitionException {
        ObjCppParser.expression_return retval = new ObjCppParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token id=null;
        Token prefixOp=null;
        Token fieldName=null;
        Token refStyle=null;
        Token char_literal189=null;
        Token char_literal190=null;
        Token char_literal192=null;
        Token char_literal194=null;
        Token char_literal196=null;
        Token char_literal197=null;
        Token char_literal198=null;
        Token char_literal199=null;
        Token char_literal200=null;
        Token char_literal201=null;
        Token char_literal202=null;
        Token char_literal203=null;
        Token char_literal204=null;
        Token char_literal205=null;
        ObjCppParser.functionCall_return fc1 = null;

        ObjCppParser.expression_return opd = null;

        ObjCppParser.expression_return par = null;

        ObjCppParser.expression_return casted = null;

        ObjCppParser.binaryOp_return bop = null;

        ObjCppParser.expression_return opd2 = null;

        ObjCppParser.expression_return val = null;

        ObjCppParser.functionCall_return fc2 = null;

        ObjCppParser.expression_return xif = null;

        ObjCppParser.expression_return xelse = null;

        ObjCppParser.objCMethodCall_return objCMethodCall188 = null;

        ObjCppParser.typeRef_return typeRef191 = null;

        ObjCppParser.constant_return constant193 = null;

        ObjCppParser.expression_return expression195 = null;


        Object id_tree=null;
        Object prefixOp_tree=null;
        Object fieldName_tree=null;
        Object refStyle_tree=null;
        Object char_literal189_tree=null;
        Object char_literal190_tree=null;
        Object char_literal192_tree=null;
        Object char_literal194_tree=null;
        Object char_literal196_tree=null;
        Object char_literal197_tree=null;
        Object char_literal198_tree=null;
        Object char_literal199_tree=null;
        Object char_literal200_tree=null;
        Object char_literal201_tree=null;
        Object char_literal202_tree=null;
        Object char_literal203_tree=null;
        Object char_literal204_tree=null;
        Object char_literal205_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1155:2: ( (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' ) (bop= binaryOp opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1155:4: (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' ) (bop= binaryOp opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1155:4: (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' )
            int alt90=7;
            alt90 = dfa90.predict(input);
            switch (alt90) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1156:4: id= IDENTIFIER
                    {
                    id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression3590); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1159:4: fc1= functionCall
                    {
                    pushFollow(FOLLOW_functionCall_in_expression3601);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1162:4: objCMethodCall
                    {
                    pushFollow(FOLLOW_objCMethodCall_in_expression3610);
                    objCMethodCall188=objCMethodCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, objCMethodCall188.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				retval.expr = (objCMethodCall188!=null?objCMethodCall188.expr:null); 
                      							
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1165:4: prefixOp= ( '!' | '~' ) opd= expression
                    {
                    prefixOp=(Token)input.LT(1);
                    if ( (input.LA(1)>=88 && input.LA(1)<=89) ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(prefixOp));
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_expression_in_expression3631);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1168:4: '(' (par= expression ')' | typeRef ')' casted= expression )
                    {
                    char_literal189=(Token)match(input,34,FOLLOW_34_in_expression3640); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal189_tree = (Object)adaptor.create(char_literal189);
                    adaptor.addChild(root_0, char_literal189_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1168:8: (par= expression ')' | typeRef ')' casted= expression )
                    int alt89=2;
                    alt89 = dfa89.predict(input);
                    switch (alt89) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1169:5: par= expression ')'
                            {
                            pushFollow(FOLLOW_expression_in_expression3650);
                            par=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, par.getTree());
                            char_literal190=(Token)match(input,35,FOLLOW_35_in_expression3652); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal190_tree = (Object)adaptor.create(char_literal190);
                            adaptor.addChild(root_0, char_literal190_tree);
                            }
                            if ( state.backtracking==0 ) {

                              					retval.expr = (par!=null?par.expr:null);
                              					if (retval.expr != null)
                              						retval.expr.setParenthesis(true);
                              				
                            }

                            }
                            break;
                        case 2 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1174:5: typeRef ')' casted= expression
                            {
                            pushFollow(FOLLOW_typeRef_in_expression3662);
                            typeRef191=typeRef();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRef191.getTree());
                            char_literal192=(Token)match(input,35,FOLLOW_35_in_expression3664); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal192_tree = (Object)adaptor.create(char_literal192);
                            adaptor.addChild(root_0, char_literal192_tree);
                            }
                            pushFollow(FOLLOW_expression_in_expression3668);
                            casted=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, casted.getTree());
                            if ( state.backtracking==0 ) {

                              					retval.expr = new Cast((typeRef191!=null?typeRef191.type:null), (casted!=null?casted.expr:null));
                              				
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1178:4: constant
                    {
                    pushFollow(FOLLOW_constant_in_expression3683);
                    constant193=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant193.getTree());
                    if ( state.backtracking==0 ) {
                       retval.expr = (constant193!=null?constant193.constant:null); 
                    }

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1179:4: '{' expression '}'
                    {
                    char_literal194=(Token)match(input,23,FOLLOW_23_in_expression3692); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal194_tree = (Object)adaptor.create(char_literal194);
                    adaptor.addChild(root_0, char_literal194_tree);
                    }
                    pushFollow(FOLLOW_expression_in_expression3694);
                    expression195=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression195.getTree());
                    char_literal196=(Token)match(input,24,FOLLOW_24_in_expression3696); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal196_tree = (Object)adaptor.create(char_literal196);
                    adaptor.addChild(root_0, char_literal196_tree);
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1181:3: (bop= binaryOp opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )*
            loop92:
            do {
                int alt92=6;
                alt92 = dfa92.predict(input);
                switch (alt92) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1182:4: bop= binaryOp opd2= expression
            	    {
            	    pushFollow(FOLLOW_binaryOp_in_expression3712);
            	    bop=binaryOp();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, bop.getTree());
            	    pushFollow(FOLLOW_expression_in_expression3719);
            	    opd2=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, opd2.getTree());
            	    if ( state.backtracking==0 ) {

            	      				retval.expr = new BinaryOp(getBinaryOperator((bop!=null?input.toString(bop.start,bop.stop):null)), retval.expr, (opd2!=null?opd2.expr:null));
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1186:4: '=' val= expression
            	    {
            	    char_literal197=(Token)match(input,29,FOLLOW_29_in_expression3728); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal197_tree = (Object)adaptor.create(char_literal197);
            	    adaptor.addChild(root_0, char_literal197_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression3732);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1189:4: '.' fieldName= IDENTIFIER
            	    {
            	    char_literal198=(Token)match(input,90,FOLLOW_90_in_expression3741); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal198_tree = (Object)adaptor.create(char_literal198);
            	    adaptor.addChild(root_0, char_literal198_tree);
            	    }
            	    fieldName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression3745); if (state.failed) return retval;
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1192:4: refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1192:13: ( ':' ':' | '-' '>' | '.' )
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
            	    case 90:
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
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1192:14: ':' ':'
            	            {
            	            char_literal199=(Token)match(input,33,FOLLOW_33_in_expression3757); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal199_tree = (Object)adaptor.create(char_literal199);
            	            adaptor.addChild(root_0, char_literal199_tree);
            	            }
            	            char_literal200=(Token)match(input,33,FOLLOW_33_in_expression3759); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal200_tree = (Object)adaptor.create(char_literal200);
            	            adaptor.addChild(root_0, char_literal200_tree);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1192:24: '-' '>'
            	            {
            	            char_literal201=(Token)match(input,43,FOLLOW_43_in_expression3763); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal201_tree = (Object)adaptor.create(char_literal201);
            	            adaptor.addChild(root_0, char_literal201_tree);
            	            }
            	            char_literal202=(Token)match(input,37,FOLLOW_37_in_expression3765); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal202_tree = (Object)adaptor.create(char_literal202);
            	            adaptor.addChild(root_0, char_literal202_tree);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1192:34: '.'
            	            {
            	            char_literal203=(Token)match(input,90,FOLLOW_90_in_expression3769); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal203_tree = (Object)adaptor.create(char_literal203);
            	            adaptor.addChild(root_0, char_literal203_tree);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_functionCall_in_expression3774);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1199:4: '?' xif= expression ':' xelse= expression
            	    {
            	    char_literal204=(Token)match(input,91,FOLLOW_91_in_expression3783); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal204_tree = (Object)adaptor.create(char_literal204);
            	    adaptor.addChild(root_0, char_literal204_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression3787);
            	    xif=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, xif.getTree());
            	    char_literal205=(Token)match(input,33,FOLLOW_33_in_expression3789); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal205_tree = (Object)adaptor.create(char_literal205);
            	    adaptor.addChild(root_0, char_literal205_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression3793);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1206:1: statementsBlock : '{' ( statement )* '}' ;
    public final ObjCppParser.statementsBlock_return statementsBlock() throws RecognitionException {
        ObjCppParser.statementsBlock_return retval = new ObjCppParser.statementsBlock_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal206=null;
        Token char_literal208=null;
        ObjCppParser.statement_return statement207 = null;


        Object char_literal206_tree=null;
        Object char_literal208_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1207:2: ( '{' ( statement )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1207:4: '{' ( statement )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal206=(Token)match(input,23,FOLLOW_23_in_statementsBlock3814); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal206_tree = (Object)adaptor.create(char_literal206);
            adaptor.addChild(root_0, char_literal206_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1207:8: ( statement )*
            loop93:
            do {
                int alt93=2;
                alt93 = dfa93.predict(input);
                switch (alt93) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_statementsBlock3816);
            	    statement207=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement207.getTree());

            	    }
            	    break;

            	default :
            	    break loop93;
                }
            } while (true);

            char_literal208=(Token)match(input,24,FOLLOW_24_in_statementsBlock3819); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal208_tree = (Object)adaptor.create(char_literal208);
            adaptor.addChild(root_0, char_literal208_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1209:1: statement : ( statementsBlock | declaration | expression ( '=' expression )? ';' | 'return' expression ';' | 'if' '(' expression ')' statement ( 'else' statement )? | 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement );
    public final ObjCppParser.statement_return statement() throws RecognitionException {
        ObjCppParser.statement_return retval = new ObjCppParser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal212=null;
        Token char_literal214=null;
        Token string_literal215=null;
        Token char_literal217=null;
        Token string_literal218=null;
        Token char_literal219=null;
        Token char_literal221=null;
        Token string_literal223=null;
        Token string_literal225=null;
        Token char_literal226=null;
        Token char_literal228=null;
        Token string_literal230=null;
        Token string_literal232=null;
        Token char_literal233=null;
        Token char_literal235=null;
        Token char_literal236=null;
        Token string_literal237=null;
        Token char_literal238=null;
        Token char_literal240=null;
        Token char_literal242=null;
        Token char_literal244=null;
        Token string_literal246=null;
        Token char_literal247=null;
        Token char_literal249=null;
        Token char_literal250=null;
        Token string_literal251=null;
        Token char_literal253=null;
        Token char_literal255=null;
        Token char_literal256=null;
        Token IDENTIFIER257=null;
        Token char_literal258=null;
        Token char_literal260=null;
        Token char_literal262=null;
        ObjCppParser.statementsBlock_return statementsBlock209 = null;

        ObjCppParser.declaration_return declaration210 = null;

        ObjCppParser.expression_return expression211 = null;

        ObjCppParser.expression_return expression213 = null;

        ObjCppParser.expression_return expression216 = null;

        ObjCppParser.expression_return expression220 = null;

        ObjCppParser.statement_return statement222 = null;

        ObjCppParser.statement_return statement224 = null;

        ObjCppParser.expression_return expression227 = null;

        ObjCppParser.statement_return statement229 = null;

        ObjCppParser.statement_return statement231 = null;

        ObjCppParser.expression_return expression234 = null;

        ObjCppParser.statement_return statement239 = null;

        ObjCppParser.expression_return expression241 = null;

        ObjCppParser.statement_return statement243 = null;

        ObjCppParser.statement_return statement245 = null;

        ObjCppParser.expression_return expression248 = null;

        ObjCppParser.expression_return expression252 = null;

        ObjCppParser.statement_return statement254 = null;

        ObjCppParser.varDecl_return varDecl259 = null;

        ObjCppParser.expression_return expression261 = null;

        ObjCppParser.statement_return statement263 = null;


        Object char_literal212_tree=null;
        Object char_literal214_tree=null;
        Object string_literal215_tree=null;
        Object char_literal217_tree=null;
        Object string_literal218_tree=null;
        Object char_literal219_tree=null;
        Object char_literal221_tree=null;
        Object string_literal223_tree=null;
        Object string_literal225_tree=null;
        Object char_literal226_tree=null;
        Object char_literal228_tree=null;
        Object string_literal230_tree=null;
        Object string_literal232_tree=null;
        Object char_literal233_tree=null;
        Object char_literal235_tree=null;
        Object char_literal236_tree=null;
        Object string_literal237_tree=null;
        Object char_literal238_tree=null;
        Object char_literal240_tree=null;
        Object char_literal242_tree=null;
        Object char_literal244_tree=null;
        Object string_literal246_tree=null;
        Object char_literal247_tree=null;
        Object char_literal249_tree=null;
        Object char_literal250_tree=null;
        Object string_literal251_tree=null;
        Object char_literal253_tree=null;
        Object char_literal255_tree=null;
        Object char_literal256_tree=null;
        Object IDENTIFIER257_tree=null;
        Object char_literal258_tree=null;
        Object char_literal260_tree=null;
        Object char_literal262_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1210:2: ( statementsBlock | declaration | expression ( '=' expression )? ';' | 'return' expression ';' | 'if' '(' expression ')' statement ( 'else' statement )? | 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement )
            int alt100=11;
            alt100 = dfa100.predict(input);
            switch (alt100) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1211:3: statementsBlock
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_statementsBlock_in_statement3832);
                    statementsBlock209=statementsBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementsBlock209.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1212:3: declaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_declaration_in_statement3838);
                    declaration210=declaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration210.getTree());

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1213:3: expression ( '=' expression )? ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_expression_in_statement3844);
                    expression211=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression211.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1213:14: ( '=' expression )?
                    int alt94=2;
                    int LA94_0 = input.LA(1);

                    if ( (LA94_0==29) ) {
                        alt94=1;
                    }
                    switch (alt94) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1213:15: '=' expression
                            {
                            char_literal212=(Token)match(input,29,FOLLOW_29_in_statement3847); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal212_tree = (Object)adaptor.create(char_literal212);
                            adaptor.addChild(root_0, char_literal212_tree);
                            }
                            pushFollow(FOLLOW_expression_in_statement3849);
                            expression213=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression213.getTree());

                            }
                            break;

                    }

                    char_literal214=(Token)match(input,28,FOLLOW_28_in_statement3854); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal214_tree = (Object)adaptor.create(char_literal214);
                    adaptor.addChild(root_0, char_literal214_tree);
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1214:3: 'return' expression ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal215=(Token)match(input,55,FOLLOW_55_in_statement3860); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal215_tree = (Object)adaptor.create(string_literal215);
                    adaptor.addChild(root_0, string_literal215_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3862);
                    expression216=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression216.getTree());
                    char_literal217=(Token)match(input,28,FOLLOW_28_in_statement3864); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal217_tree = (Object)adaptor.create(char_literal217);
                    adaptor.addChild(root_0, char_literal217_tree);
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1215:3: 'if' '(' expression ')' statement ( 'else' statement )?
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal218=(Token)match(input,92,FOLLOW_92_in_statement3870); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal218_tree = (Object)adaptor.create(string_literal218);
                    adaptor.addChild(root_0, string_literal218_tree);
                    }
                    char_literal219=(Token)match(input,34,FOLLOW_34_in_statement3872); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal219_tree = (Object)adaptor.create(char_literal219);
                    adaptor.addChild(root_0, char_literal219_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3874);
                    expression220=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression220.getTree());
                    char_literal221=(Token)match(input,35,FOLLOW_35_in_statement3876); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal221_tree = (Object)adaptor.create(char_literal221);
                    adaptor.addChild(root_0, char_literal221_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement3878);
                    statement222=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement222.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1215:37: ( 'else' statement )?
                    int alt95=2;
                    alt95 = dfa95.predict(input);
                    switch (alt95) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1215:38: 'else' statement
                            {
                            string_literal223=(Token)match(input,93,FOLLOW_93_in_statement3881); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal223_tree = (Object)adaptor.create(string_literal223);
                            adaptor.addChild(root_0, string_literal223_tree);
                            }
                            pushFollow(FOLLOW_statement_in_statement3883);
                            statement224=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement224.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1216:3: 'while' '(' expression ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal225=(Token)match(input,94,FOLLOW_94_in_statement3891); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal225_tree = (Object)adaptor.create(string_literal225);
                    adaptor.addChild(root_0, string_literal225_tree);
                    }
                    char_literal226=(Token)match(input,34,FOLLOW_34_in_statement3893); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal226_tree = (Object)adaptor.create(char_literal226);
                    adaptor.addChild(root_0, char_literal226_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3895);
                    expression227=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression227.getTree());
                    char_literal228=(Token)match(input,35,FOLLOW_35_in_statement3897); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal228_tree = (Object)adaptor.create(char_literal228);
                    adaptor.addChild(root_0, char_literal228_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement3899);
                    statement229=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement229.getTree());

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1217:3: 'do' statement 'while' '(' expression ')' ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal230=(Token)match(input,95,FOLLOW_95_in_statement3905); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal230_tree = (Object)adaptor.create(string_literal230);
                    adaptor.addChild(root_0, string_literal230_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement3907);
                    statement231=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement231.getTree());
                    string_literal232=(Token)match(input,94,FOLLOW_94_in_statement3909); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal232_tree = (Object)adaptor.create(string_literal232);
                    adaptor.addChild(root_0, string_literal232_tree);
                    }
                    char_literal233=(Token)match(input,34,FOLLOW_34_in_statement3911); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal233_tree = (Object)adaptor.create(char_literal233);
                    adaptor.addChild(root_0, char_literal233_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3913);
                    expression234=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression234.getTree());
                    char_literal235=(Token)match(input,35,FOLLOW_35_in_statement3915); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal235_tree = (Object)adaptor.create(char_literal235);
                    adaptor.addChild(root_0, char_literal235_tree);
                    }
                    char_literal236=(Token)match(input,28,FOLLOW_28_in_statement3917); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal236_tree = (Object)adaptor.create(char_literal236);
                    adaptor.addChild(root_0, char_literal236_tree);
                    }

                    }
                    break;
                case 8 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1218:3: 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal237=(Token)match(input,96,FOLLOW_96_in_statement3923); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal237_tree = (Object)adaptor.create(string_literal237);
                    adaptor.addChild(root_0, string_literal237_tree);
                    }
                    char_literal238=(Token)match(input,34,FOLLOW_34_in_statement3925); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal238_tree = (Object)adaptor.create(char_literal238);
                    adaptor.addChild(root_0, char_literal238_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1218:13: ( statement )?
                    int alt96=2;
                    alt96 = dfa96.predict(input);
                    switch (alt96) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: statement
                            {
                            pushFollow(FOLLOW_statement_in_statement3927);
                            statement239=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement239.getTree());

                            }
                            break;

                    }

                    char_literal240=(Token)match(input,28,FOLLOW_28_in_statement3930); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal240_tree = (Object)adaptor.create(char_literal240);
                    adaptor.addChild(root_0, char_literal240_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1218:28: ( expression )?
                    int alt97=2;
                    alt97 = dfa97.predict(input);
                    switch (alt97) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement3932);
                            expression241=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression241.getTree());

                            }
                            break;

                    }

                    char_literal242=(Token)match(input,28,FOLLOW_28_in_statement3935); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal242_tree = (Object)adaptor.create(char_literal242);
                    adaptor.addChild(root_0, char_literal242_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1218:44: ( statement )?
                    int alt98=2;
                    alt98 = dfa98.predict(input);
                    switch (alt98) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: statement
                            {
                            pushFollow(FOLLOW_statement_in_statement3937);
                            statement243=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement243.getTree());

                            }
                            break;

                    }

                    char_literal244=(Token)match(input,35,FOLLOW_35_in_statement3940); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal244_tree = (Object)adaptor.create(char_literal244);
                    adaptor.addChild(root_0, char_literal244_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement3942);
                    statement245=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement245.getTree());

                    }
                    break;
                case 9 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1219:3: 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal246=(Token)match(input,97,FOLLOW_97_in_statement3948); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal246_tree = (Object)adaptor.create(string_literal246);
                    adaptor.addChild(root_0, string_literal246_tree);
                    }
                    char_literal247=(Token)match(input,34,FOLLOW_34_in_statement3950); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal247_tree = (Object)adaptor.create(char_literal247);
                    adaptor.addChild(root_0, char_literal247_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3952);
                    expression248=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression248.getTree());
                    char_literal249=(Token)match(input,35,FOLLOW_35_in_statement3954); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal249_tree = (Object)adaptor.create(char_literal249);
                    adaptor.addChild(root_0, char_literal249_tree);
                    }
                    char_literal250=(Token)match(input,23,FOLLOW_23_in_statement3956); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal250_tree = (Object)adaptor.create(char_literal250);
                    adaptor.addChild(root_0, char_literal250_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1220:3: ( 'case' expression ':' | statement )*
                    loop99:
                    do {
                        int alt99=3;
                        alt99 = dfa99.predict(input);
                        switch (alt99) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1220:5: 'case' expression ':'
                    	    {
                    	    string_literal251=(Token)match(input,98,FOLLOW_98_in_statement3962); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    string_literal251_tree = (Object)adaptor.create(string_literal251);
                    	    adaptor.addChild(root_0, string_literal251_tree);
                    	    }
                    	    pushFollow(FOLLOW_expression_in_statement3964);
                    	    expression252=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression252.getTree());
                    	    char_literal253=(Token)match(input,33,FOLLOW_33_in_statement3966); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal253_tree = (Object)adaptor.create(char_literal253);
                    	    adaptor.addChild(root_0, char_literal253_tree);
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1221:4: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement3973);
                    	    statement254=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement254.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop99;
                        }
                    } while (true);

                    char_literal255=(Token)match(input,24,FOLLOW_24_in_statement3982); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal255_tree = (Object)adaptor.create(char_literal255);
                    adaptor.addChild(root_0, char_literal255_tree);
                    }

                    }
                    break;
                case 10 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1224:3: ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal256=(Token)match(input,28,FOLLOW_28_in_statement3988); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal256_tree = (Object)adaptor.create(char_literal256);
                    adaptor.addChild(root_0, char_literal256_tree);
                    }

                    }
                    break;
                case 11 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1225:3: {...}? IDENTIFIER '(' varDecl ':' expression ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !(( next("foreach") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "statement", " next(\"foreach\") ");
                    }
                    IDENTIFIER257=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement3996); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER257_tree = (Object)adaptor.create(IDENTIFIER257);
                    adaptor.addChild(root_0, IDENTIFIER257_tree);
                    }
                    char_literal258=(Token)match(input,34,FOLLOW_34_in_statement3998); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal258_tree = (Object)adaptor.create(char_literal258);
                    adaptor.addChild(root_0, char_literal258_tree);
                    }
                    pushFollow(FOLLOW_varDecl_in_statement4000);
                    varDecl259=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl259.getTree());
                    char_literal260=(Token)match(input,33,FOLLOW_33_in_statement4002); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal260_tree = (Object)adaptor.create(char_literal260);
                    adaptor.addChild(root_0, char_literal260_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement4004);
                    expression261=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression261.getTree());
                    char_literal262=(Token)match(input,35,FOLLOW_35_in_statement4006); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal262_tree = (Object)adaptor.create(char_literal262);
                    adaptor.addChild(root_0, char_literal262_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement4008);
                    statement263=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement263.getTree());

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1228:1: constant returns [Constant constant] : ( DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER | CHARACTER | FLOAT_NUMBER | STRING );
    public final ObjCppParser.constant_return constant() throws RecognitionException {
        ObjCppParser.constant_return retval = new ObjCppParser.constant_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DECIMAL_NUMBER264=null;
        Token HEXADECIMAL_NUMBER265=null;
        Token OCTAL_NUMBER266=null;
        Token CHARACTER267=null;
        Token FLOAT_NUMBER268=null;
        Token STRING269=null;

        Object DECIMAL_NUMBER264_tree=null;
        Object HEXADECIMAL_NUMBER265_tree=null;
        Object OCTAL_NUMBER266_tree=null;
        Object CHARACTER267_tree=null;
        Object FLOAT_NUMBER268_tree=null;
        Object STRING269_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1229:2: ( DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER | CHARACTER | FLOAT_NUMBER | STRING )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1229:4: DECIMAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    DECIMAL_NUMBER264=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_constant4024); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DECIMAL_NUMBER264_tree = (Object)adaptor.create(DECIMAL_NUMBER264);
                    adaptor.addChild(root_0, DECIMAL_NUMBER264_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant =  Constant.parseDecimal((DECIMAL_NUMBER264!=null?DECIMAL_NUMBER264.getText():null)); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1230:3: HEXADECIMAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    HEXADECIMAL_NUMBER265=(Token)match(input,HEXADECIMAL_NUMBER,FOLLOW_HEXADECIMAL_NUMBER_in_constant4032); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    HEXADECIMAL_NUMBER265_tree = (Object)adaptor.create(HEXADECIMAL_NUMBER265);
                    adaptor.addChild(root_0, HEXADECIMAL_NUMBER265_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant = Constant.parseHex((HEXADECIMAL_NUMBER265!=null?HEXADECIMAL_NUMBER265.getText():null)); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1231:3: OCTAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    OCTAL_NUMBER266=(Token)match(input,OCTAL_NUMBER,FOLLOW_OCTAL_NUMBER_in_constant4040); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OCTAL_NUMBER266_tree = (Object)adaptor.create(OCTAL_NUMBER266);
                    adaptor.addChild(root_0, OCTAL_NUMBER266_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant = Constant.parseOctal((OCTAL_NUMBER266!=null?OCTAL_NUMBER266.getText():null)); 
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1232:3: CHARACTER
                    {
                    root_0 = (Object)adaptor.nil();

                    CHARACTER267=(Token)match(input,CHARACTER,FOLLOW_CHARACTER_in_constant4048); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARACTER267_tree = (Object)adaptor.create(CHARACTER267);
                    adaptor.addChild(root_0, CHARACTER267_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant =  Constant.parseCharOrStringInteger((CHARACTER267!=null?CHARACTER267.getText():null)); 
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1233:3: FLOAT_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    FLOAT_NUMBER268=(Token)match(input,FLOAT_NUMBER,FOLLOW_FLOAT_NUMBER_in_constant4056); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT_NUMBER268_tree = (Object)adaptor.create(FLOAT_NUMBER268);
                    adaptor.addChild(root_0, FLOAT_NUMBER268_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant = Constant.parseFloat((FLOAT_NUMBER268!=null?FLOAT_NUMBER268.getText():null)); 
                    }

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1235:3: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING269=(Token)match(input,STRING,FOLLOW_STRING_in_constant4067); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING269_tree = (Object)adaptor.create(STRING269);
                    adaptor.addChild(root_0, STRING269_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant =  Constant.parseString((STRING269!=null?STRING269.getText():null)); 
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
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:246:5: ( functionDeclaration )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:246:5: functionDeclaration
        {
        pushFollow(FOLLOW_functionDeclaration_in_synpred6_ObjCpp249);
        functionDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_ObjCpp

    // $ANTLR start synpred7_ObjCpp
    public final void synpred7_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:249:5: ( varDecl )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:249:5: varDecl
        {
        pushFollow(FOLLOW_varDecl_in_synpred7_ObjCpp259);
        varDecl();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_ObjCpp

    // $ANTLR start synpred26_ObjCpp
    public final void synpred26_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.varDecl_return fv = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:387:7: (fv= varDecl )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:387:7: fv= varDecl
        {
        pushFollow(FOLLOW_varDecl_in_synpred26_ObjCpp777);
        fv=varDecl();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_ObjCpp

    // $ANTLR start synpred40_ObjCpp
    public final void synpred40_ObjCpp_fragment() throws RecognitionException {   
        Token n0=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:491:4: ( (n0= IDENTIFIER ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:491:4: (n0= IDENTIFIER )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:491:4: (n0= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:492:5: n0= IDENTIFIER
        {
        n0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred40_ObjCpp1115); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred40_ObjCpp

    // $ANTLR start synpred41_ObjCpp
    public final void synpred41_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:498:7: ( exportationModifiers )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:498:7: exportationModifiers
        {
        pushFollow(FOLLOW_exportationModifiers_in_synpred41_ObjCpp1138);
        exportationModifiers();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred41_ObjCpp

    // $ANTLR start synpred47_ObjCpp
    public final void synpred47_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.typeRef_return returnTypeRef = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:528:16: (returnTypeRef= typeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:528:16: returnTypeRef= typeRef
        {
        pushFollow(FOLLOW_typeRef_in_synpred47_ObjCpp1279);
        returnTypeRef=typeRef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_ObjCpp

    // $ANTLR start synpred48_ObjCpp
    public final void synpred48_ObjCpp_fragment() throws RecognitionException {   
        Token ct=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:542:35: (ct= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:542:35: ct= IDENTIFIER
        {
        ct=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred48_ObjCpp1313); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_ObjCpp

    // $ANTLR start synpred50_ObjCpp
    public final void synpred50_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:565:4: ( exportationModifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:565:4: exportationModifier
        {
        pushFollow(FOLLOW_exportationModifier_in_synpred50_ObjCpp1389);
        exportationModifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_ObjCpp

    // $ANTLR start synpred60_ObjCpp
    public final void synpred60_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return m1a = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:701:4: ({...}?m1a= modifier '(' expression ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:701:4: {...}?m1a= modifier '(' expression ')'
        {
        if ( !(( next(Modifier.Kind.VCAnnotation1Arg) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred60_ObjCpp", " next(Modifier.Kind.VCAnnotation1Arg) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred60_ObjCpp1738);
        m1a=modifier();

        state._fsp--;
        if (state.failed) return ;
        match(input,34,FOLLOW_34_in_synpred60_ObjCpp1741); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred60_ObjCpp1743);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred60_ObjCpp1745); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred60_ObjCpp

    // $ANTLR start synpred61_ObjCpp
    public final void synpred61_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return m2a = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:702:4: ({...}?m2a= modifier '(' expression ',' expression ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:702:4: {...}?m2a= modifier '(' expression ',' expression ')'
        {
        if ( !(( next(Modifier.Kind.VCAnnotation2Args) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred61_ObjCpp", " next(Modifier.Kind.VCAnnotation2Args) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred61_ObjCpp1758);
        m2a=modifier();

        state._fsp--;
        if (state.failed) return ;
        match(input,34,FOLLOW_34_in_synpred61_ObjCpp1761); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred61_ObjCpp1763);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,27,FOLLOW_27_in_synpred61_ObjCpp1765); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred61_ObjCpp1767);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred61_ObjCpp1769); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred61_ObjCpp

    // $ANTLR start synpred62_ObjCpp
    public final void synpred62_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return m = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:704:4: ({...}?m= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:704:4: {...}?m= modifier
        {
        if ( !(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred62_ObjCpp", " next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred62_ObjCpp1786);
        m=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred62_ObjCpp

    // $ANTLR start synpred63_ObjCpp
    public final void synpred63_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return m1 = null;

        ObjCppParser.typeRef_return tr = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:706:4: ({...}?m1= modifier tr= typeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:706:4: {...}?m1= modifier tr= typeRef
        {
        if ( !(( next(Modifier.Kind.ReferenceQualifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred63_ObjCpp", " next(Modifier.Kind.ReferenceQualifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred63_ObjCpp1803);
        m1=modifier();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_typeRef_in_synpred63_ObjCpp1812);
        tr=typeRef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred63_ObjCpp

    // $ANTLR start synpred80_ObjCpp
    public final void synpred80_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:788:4: ( ( typeMutator )* functionSignatureSuffix )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:788:4: ( typeMutator )* functionSignatureSuffix
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:788:4: ( typeMutator )*
        loop122:
        do {
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==IDENTIFIER||(LA122_0>=51 && LA122_0<=53)) ) {
                alt122=1;
            }


            switch (alt122) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:789:5: typeMutator
        	    {
        	    pushFollow(FOLLOW_typeMutator_in_synpred80_ObjCpp2258);
        	    typeMutator();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop122;
            }
        } while (true);

        pushFollow(FOLLOW_functionSignatureSuffix_in_synpred80_ObjCpp2271);
        functionSignatureSuffix();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred80_ObjCpp

    // $ANTLR start synpred82_ObjCpp
    public final void synpred82_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:803:4: ( ( typeMutator )* functionSignatureSuffixNoName )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:803:4: ( typeMutator )* functionSignatureSuffixNoName
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:803:4: ( typeMutator )*
        loop123:
        do {
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==IDENTIFIER||(LA123_0>=51 && LA123_0<=53)) ) {
                alt123=1;
            }


            switch (alt123) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:804:5: typeMutator
        	    {
        	    pushFollow(FOLLOW_typeMutator_in_synpred82_ObjCpp2312);
        	    typeMutator();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop123;
            }
        } while (true);

        pushFollow(FOLLOW_functionSignatureSuffixNoName_in_synpred82_ObjCpp2325);
        functionSignatureSuffixNoName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred82_ObjCpp

    // $ANTLR start synpred84_ObjCpp
    public final void synpred84_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:824:4: ({...}? modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:824:4: {...}? modifier
        {
        if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred84_ObjCpp", " next(Modifier.Kind.TypeQualifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred84_ObjCpp2389);
        modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred84_ObjCpp

    // $ANTLR start synpred88_ObjCpp
    public final void synpred88_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:844:5: ( '=' expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:844:5: '=' expression
        {
        match(input,29,FOLLOW_29_in_synpred88_ObjCpp2480); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred88_ObjCpp2487);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred88_ObjCpp

    // $ANTLR start synpred90_ObjCpp
    public final void synpred90_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return sm = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:886:4: ({...}?sm= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:886:4: {...}?sm= modifier
        {
        if ( !(( next(Modifier.Kind.StorageClassSpecifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred90_ObjCpp", " next(Modifier.Kind.StorageClassSpecifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred90_ObjCpp2615);
        sm=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred90_ObjCpp

    // $ANTLR start synpred91_ObjCpp
    public final void synpred91_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return tm = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:888:4: ({...}?tm= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:888:4: {...}?tm= modifier
        {
        if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred91_ObjCpp", " next(Modifier.Kind.TypeQualifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred91_ObjCpp2632);
        tm=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred91_ObjCpp

    // $ANTLR start synpred97_ObjCpp
    public final void synpred97_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return im = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:975:5: (im= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:975:5: im= modifier
        {
        pushFollow(FOLLOW_modifier_in_synpred97_ObjCpp2899);
        im=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred97_ObjCpp

    // $ANTLR start synpred101_ObjCpp
    public final void synpred101_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.argDef_return ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1014:5: ( ',' ax= argDef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1014:5: ',' ax= argDef
        {
        match(input,27,FOLLOW_27_in_synpred101_ObjCpp3020); if (state.failed) return ;
        pushFollow(FOLLOW_argDef_in_synpred101_ObjCpp3029);
        ax=argDef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred101_ObjCpp

    // $ANTLR start synpred104_ObjCpp
    public final void synpred104_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1035:4: ( typeMutator )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1035:4: typeMutator
        {
        pushFollow(FOLLOW_typeMutator_in_synpred104_ObjCpp3099);
        typeMutator();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred104_ObjCpp

    // $ANTLR start synpred150_ObjCpp
    public final void synpred150_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.expression_return par = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1169:5: (par= expression ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1169:5: par= expression ')'
        {
        pushFollow(FOLLOW_expression_in_synpred150_ObjCpp3650);
        par=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred150_ObjCpp3652); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred150_ObjCpp

    // $ANTLR start synpred153_ObjCpp
    public final void synpred153_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.binaryOp_return bop = null;

        ObjCppParser.expression_return opd2 = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1182:4: (bop= binaryOp opd2= expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1182:4: bop= binaryOp opd2= expression
        {
        pushFollow(FOLLOW_binaryOp_in_synpred153_ObjCpp3712);
        bop=binaryOp();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred153_ObjCpp3719);
        opd2=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred153_ObjCpp

    // $ANTLR start synpred154_ObjCpp
    public final void synpred154_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.expression_return val = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1186:4: ( '=' val= expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1186:4: '=' val= expression
        {
        match(input,29,FOLLOW_29_in_synpred154_ObjCpp3728); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred154_ObjCpp3732);
        val=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred154_ObjCpp

    // $ANTLR start synpred155_ObjCpp
    public final void synpred155_ObjCpp_fragment() throws RecognitionException {   
        Token fieldName=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1189:4: ( '.' fieldName= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1189:4: '.' fieldName= IDENTIFIER
        {
        match(input,90,FOLLOW_90_in_synpred155_ObjCpp3741); if (state.failed) return ;
        fieldName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred155_ObjCpp3745); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred155_ObjCpp

    // $ANTLR start synpred158_ObjCpp
    public final void synpred158_ObjCpp_fragment() throws RecognitionException {   
        Token refStyle=null;
        ObjCppParser.functionCall_return fc2 = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1192:4: (refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1192:4: refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1192:13: ( ':' ':' | '-' '>' | '.' )
        int alt132=3;
        switch ( input.LA(1) ) {
        case 33:
            {
            alt132=1;
            }
            break;
        case 43:
            {
            alt132=2;
            }
            break;
        case 90:
            {
            alt132=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 132, 0, input);

            throw nvae;
        }

        switch (alt132) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1192:14: ':' ':'
                {
                match(input,33,FOLLOW_33_in_synpred158_ObjCpp3757); if (state.failed) return ;
                match(input,33,FOLLOW_33_in_synpred158_ObjCpp3759); if (state.failed) return ;

                }
                break;
            case 2 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1192:24: '-' '>'
                {
                match(input,43,FOLLOW_43_in_synpred158_ObjCpp3763); if (state.failed) return ;
                match(input,37,FOLLOW_37_in_synpred158_ObjCpp3765); if (state.failed) return ;

                }
                break;
            case 3 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1192:34: '.'
                {
                match(input,90,FOLLOW_90_in_synpred158_ObjCpp3769); if (state.failed) return ;

                }
                break;

        }

        pushFollow(FOLLOW_functionCall_in_synpred158_ObjCpp3774);
        fc2=functionCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred158_ObjCpp

    // $ANTLR start synpred159_ObjCpp
    public final void synpred159_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.expression_return xif = null;

        ObjCppParser.expression_return xelse = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1199:4: ( '?' xif= expression ':' xelse= expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1199:4: '?' xif= expression ':' xelse= expression
        {
        match(input,91,FOLLOW_91_in_synpred159_ObjCpp3783); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred159_ObjCpp3787);
        xif=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,33,FOLLOW_33_in_synpred159_ObjCpp3789); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred159_ObjCpp3793);
        xelse=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred159_ObjCpp

    // $ANTLR start synpred161_ObjCpp
    public final void synpred161_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1211:3: ( statementsBlock )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1211:3: statementsBlock
        {
        pushFollow(FOLLOW_statementsBlock_in_synpred161_ObjCpp3832);
        statementsBlock();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred161_ObjCpp

    // $ANTLR start synpred162_ObjCpp
    public final void synpred162_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1212:3: ( declaration )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1212:3: declaration
        {
        pushFollow(FOLLOW_declaration_in_synpred162_ObjCpp3838);
        declaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred162_ObjCpp

    // $ANTLR start synpred164_ObjCpp
    public final void synpred164_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1213:3: ( expression ( '=' expression )? ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1213:3: expression ( '=' expression )? ';'
        {
        pushFollow(FOLLOW_expression_in_synpred164_ObjCpp3844);
        expression();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1213:14: ( '=' expression )?
        int alt133=2;
        int LA133_0 = input.LA(1);

        if ( (LA133_0==29) ) {
            alt133=1;
        }
        switch (alt133) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1213:15: '=' expression
                {
                match(input,29,FOLLOW_29_in_synpred164_ObjCpp3847); if (state.failed) return ;
                pushFollow(FOLLOW_expression_in_synpred164_ObjCpp3849);
                expression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }

        match(input,28,FOLLOW_28_in_synpred164_ObjCpp3854); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred164_ObjCpp

    // $ANTLR start synpred166_ObjCpp
    public final void synpred166_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1215:38: ( 'else' statement )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1215:38: 'else' statement
        {
        match(input,93,FOLLOW_93_in_synpred166_ObjCpp3881); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred166_ObjCpp3883);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred166_ObjCpp

    // $ANTLR start synpred170_ObjCpp
    public final void synpred170_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1218:13: ( statement )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1218:13: statement
        {
        pushFollow(FOLLOW_statement_in_synpred170_ObjCpp3927);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred170_ObjCpp

    // Delegated rules

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
    public final boolean synpred170_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred170_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred91_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred91_ObjCpp_fragment(); // can never throw exception
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
        "\1\112\16\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\1\1\2\14\uffff";
    static final String DFA1_specialS =
        "\17\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\2\1\1\1\2\17\uffff\1\2\2\uffff\2\2\3\uffff\3\2\14\uffff\3"+
            "\2\13\uffff\20\2",
            "",
            "",
            "",
            "",
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
        "\1\112\15\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\1\2\13\uffff";
    static final String DFA2_specialS =
        "\16\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\1\1\uffff\1\2\17\uffff\1\2\2\uffff\2\2\3\uffff\3\2\14\uffff"+
            "\3\2\13\uffff\20\2",
            "",
            "",
            "",
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
        "\1\112\14\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\3\1\1\11\uffff\1\2";
    static final String DFA3_specialS =
        "\15\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\2\17\uffff\1\14\2\uffff\2\2\3\uffff\3\2\14\uffff\3\2\13\uffff"+
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
        "\1\112\13\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\2\1\1\11\uffff";
    static final String DFA4_specialS =
        "\14\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\2\21\uffff\1\1\2\2\3\uffff\3\2\14\uffff\3\2\13\uffff\20\2",
            "",
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
            return "()* loopback of 222:4: (ed= declaration )*";
        }
    }
    static final String DFA6_eotS =
        "\u00dd\uffff";
    static final String DFA6_eofS =
        "\u00dd\uffff";
    static final String DFA6_minS =
        "\4\6\1\100\2\6\4\uffff\2\6\1\27\1\6\1\4\1\6\1\100\6\6\1\66\1\uffff"+
        "\6\6\1\66\1\6\1\uffff\5\6\1\66\1\6\1\uffff\4\0\1\uffff\1\0\2\uffff"+
        "\23\0\1\uffff\13\0\7\uffff\11\0\3\uffff\2\0\1\uffff\7\0\1\uffff"+
        "\7\0\1\uffff\11\0\1\uffff\5\0\1\uffff\15\0\1\uffff\7\0\1\uffff\2"+
        "\0\1\uffff\1\0\4\uffff\5\0\1\uffff\5\0\1\uffff\3\0\2\uffff\5\0\1"+
        "\uffff\6\0\1\uffff\2\0\1\uffff\1\0\4\uffff\5\0\1\uffff\5\0\1\uffff"+
        "\3\0\2\uffff";
    static final String DFA6_maxS =
        "\1\112\2\27\3\112\1\72\4\uffff\1\72\1\112\1\27\1\6\1\131\3\112\1"+
        "\72\2\27\2\72\1\66\1\uffff\2\112\4\72\1\66\1\72\1\uffff\1\112\4"+
        "\72\1\66\1\72\1\uffff\4\0\1\uffff\1\0\2\uffff\23\0\1\uffff\13\0"+
        "\7\uffff\11\0\3\uffff\2\0\1\uffff\7\0\1\uffff\7\0\1\uffff\11\0\1"+
        "\uffff\5\0\1\uffff\15\0\1\uffff\7\0\1\uffff\2\0\1\uffff\1\0\4\uffff"+
        "\5\0\1\uffff\5\0\1\uffff\3\0\2\uffff\5\0\1\uffff\6\0\1\uffff\2\0"+
        "\1\uffff\1\0\4\uffff\5\0\1\uffff\5\0\1\uffff\3\0\2\uffff";
    static final String DFA6_acceptS =
        "\7\uffff\1\3\1\4\1\5\1\6\16\uffff\1\2\30\uffff\1\1\u00aa\uffff";
    static final String DFA6_specialS =
        "\53\uffff\1\0\1\1\1\2\1\3\1\uffff\1\4\2\uffff\1\5\1\6\1\7\1\10\1"+
        "\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
        "\1\26\1\27\1\uffff\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40"+
        "\1\41\1\42\7\uffff\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53"+
        "\3\uffff\1\54\1\55\1\uffff\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1"+
        "\uffff\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\uffff\1\74\1\75\1\76"+
        "\1\77\1\100\1\101\1\102\1\103\1\104\1\uffff\1\105\1\106\1\107\1"+
        "\110\1\111\1\uffff\1\112\1\113\1\114\1\115\1\116\1\117\1\120\1\121"+
        "\1\122\1\123\1\124\1\125\1\126\1\uffff\1\127\1\130\1\131\1\132\1"+
        "\133\1\134\1\135\1\uffff\1\136\1\137\1\uffff\1\140\4\uffff\1\141"+
        "\1\142\1\143\1\144\1\145\1\uffff\1\146\1\147\1\150\1\151\1\152\1"+
        "\uffff\1\153\1\154\1\155\2\uffff\1\156\1\157\1\160\1\161\1\162\1"+
        "\uffff\1\163\1\164\1\165\1\166\1\167\1\170\1\uffff\1\171\1\172\1"+
        "\uffff\1\173\4\uffff\1\174\1\175\1\176\1\177\1\u0080\1\uffff\1\u0081"+
        "\1\u0082\1\u0083\1\u0084\1\u0085\1\uffff\1\u0086\1\u0087\1\u0088"+
        "\2\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\3\22\uffff\1\12\1\11\3\uffff\1\2\2\7\14\uffff\3\1\13\uffff"+
            "\1\10\4\4\2\5\11\6",
            "\1\13\20\uffff\1\14",
            "\1\15\20\uffff\1\16",
            "\1\20\27\uffff\1\25\3\uffff\1\17\1\uffff\1\32\10\uffff\3\24"+
            "\3\uffff\1\26\1\27\1\30\4\uffff\1\31\1\uffff\4\21\2\22\11\23",
            "\2\33\11\34",
            "\1\35\33\uffff\1\41\20\uffff\1\36\1\37\1\40\4\uffff\1\31\5"+
            "\uffff\2\43\11\44",
            "\1\45\33\uffff\1\51\20\uffff\1\46\1\47\1\50\4\uffff\1\31",
            "",
            "",
            "",
            "",
            "\1\55\20\uffff\1\54\4\uffff\1\31\5\uffff\1\53\20\uffff\1\56"+
            "\1\60\1\62\4\uffff\1\31",
            "\1\70\21\uffff\1\100\1\77\1\76\3\uffff\1\67\2\74\14\uffff\3"+
            "\66\1\63\1\64\1\65\10\uffff\1\75\4\71\2\72\11\73",
            "\1\101",
            "\1\102",
            "\1\113\1\120\1\104\1\114\1\115\1\116\1\117\14\uffff\1\121\6"+
            "\uffff\1\62\3\uffff\1\107\1\62\10\uffff\4\62\3\uffff\1\105\1"+
            "\31\1\111\1\uffff\1\103\2\uffff\1\31\1\uffff\17\62\1\110\14"+
            "\uffff\2\112",
            "\1\133\24\uffff\3\31\1\146\3\uffff\1\131\1\uffff\1\141\10\uffff"+
            "\3\145\3\uffff\1\132\1\137\1\140\4\uffff\1\31\1\uffff\4\134"+
            "\2\135\11\136",
            "\2\150\11\151",
            "\1\152\33\uffff\1\156\20\uffff\1\153\1\154\1\155\4\uffff\1"+
            "\31\5\uffff\2\160\11\161",
            "\1\162\33\uffff\1\166\20\uffff\1\163\1\164\1\165\4\uffff\1"+
            "\31",
            "\1\170\20\uffff\1\171",
            "\1\172\20\uffff\1\173",
            "\1\174\33\uffff\1\u0080\20\uffff\1\175\1\176\1\177\4\uffff"+
            "\1\31",
            "\1\u0083\33\uffff\1\u0082\20\uffff\1\u0084\1\u0085\1\u0086"+
            "\4\uffff\1\31",
            "\1\u0088",
            "",
            "\1\u008b\27\uffff\1\u008a\6\uffff\1\u008f\7\uffff\3\u0089\14"+
            "\uffff\4\u008c\2\u008d\11\u008e",
            "\1\u0090\33\uffff\1\u0094\20\uffff\1\u0091\1\u0092\1\u0093"+
            "\4\uffff\1\31\5\uffff\2\u0096\11\u0097",
            "\1\u0098\33\uffff\1\u009c\20\uffff\1\u0099\1\u009a\1\u009b"+
            "\4\uffff\1\31",
            "\1\u009f\24\uffff\3\31\4\uffff\1\u00a1\20\uffff\1\u009e\2\31"+
            "\4\uffff\1\31",
            "\1\u00a6\33\uffff\1\u00aa\20\uffff\1\u00a7\1\u00a8\1\u00a9"+
            "\4\uffff\1\31",
            "\1\u00ad\33\uffff\1\u00ac\20\uffff\1\u00ae\1\u00af\1\u00b0"+
            "\4\uffff\1\31",
            "\1\u00b2",
            "\1\u00b3\33\uffff\1\31\20\uffff\1\u00b4\1\31\5\uffff\1\31",
            "",
            "\1\u00b7\33\uffff\1\u00bb\20\uffff\1\u00b8\1\u00b9\1\u00ba"+
            "\4\uffff\1\31\5\uffff\13\u00bd",
            "\1\u00be\33\uffff\1\u00c2\20\uffff\1\u00bf\1\u00c0\1\u00c1"+
            "\4\uffff\1\31",
            "\1\u00c5\24\uffff\3\31\4\uffff\1\u00c7\20\uffff\1\u00c4\2\31"+
            "\4\uffff\1\31",
            "\1\u00cc\33\uffff\1\u00d0\20\uffff\1\u00cd\1\u00ce\1\u00cf"+
            "\4\uffff\1\31",
            "\1\u00d3\33\uffff\1\u00d2\20\uffff\1\u00d4\1\u00d5\1\u00d6"+
            "\4\uffff\1\31",
            "\1\u00d8",
            "\1\u00d9\33\uffff\1\31\20\uffff\1\u00da\1\31\5\uffff\1\31",
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
            "\1\uffff",
            "\1\uffff",
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
            return "244:4: ( functionDeclaration | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )";
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

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_43);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_44 = input.LA(1);

                         
                        int index6_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_44);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA6_45 = input.LA(1);

                         
                        int index6_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_45);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA6_46 = input.LA(1);

                         
                        int index6_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_46);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA6_48 = input.LA(1);

                         
                        int index6_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_48);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA6_51 = input.LA(1);

                         
                        int index6_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_51);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA6_52 = input.LA(1);

                         
                        int index6_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_52);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA6_53 = input.LA(1);

                         
                        int index6_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_53);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA6_54 = input.LA(1);

                         
                        int index6_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_54);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA6_55 = input.LA(1);

                         
                        int index6_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_55);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA6_56 = input.LA(1);

                         
                        int index6_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_56);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA6_57 = input.LA(1);

                         
                        int index6_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_57);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA6_58 = input.LA(1);

                         
                        int index6_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_58);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA6_59 = input.LA(1);

                         
                        int index6_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_59);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA6_60 = input.LA(1);

                         
                        int index6_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_60);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA6_61 = input.LA(1);

                         
                        int index6_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_61);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA6_62 = input.LA(1);

                         
                        int index6_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_62);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA6_63 = input.LA(1);

                         
                        int index6_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_63);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA6_64 = input.LA(1);

                         
                        int index6_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_64);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA6_65 = input.LA(1);

                         
                        int index6_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_65);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA6_66 = input.LA(1);

                         
                        int index6_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_66);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA6_67 = input.LA(1);

                         
                        int index6_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( "__success".equals(next()) ))) ) {s = 25;}

                         
                        input.seek(index6_67);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA6_68 = input.LA(1);

                         
                        int index6_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||(synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null )))) ) {s = 25;}

                         
                        input.seek(index6_68);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA6_69 = input.LA(1);

                         
                        int index6_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 25;}

                         
                        input.seek(index6_69);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA6_71 = input.LA(1);

                         
                        int index6_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||(synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null )))) ) {s = 25;}

                         
                        input.seek(index6_71);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA6_72 = input.LA(1);

                         
                        int index6_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_72);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA6_73 = input.LA(1);

                         
                        int index6_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_73);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA6_74 = input.LA(1);

                         
                        int index6_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_74);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA6_75 = input.LA(1);

                         
                        int index6_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_75);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA6_76 = input.LA(1);

                         
                        int index6_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_76);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA6_77 = input.LA(1);

                         
                        int index6_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_77);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA6_78 = input.LA(1);

                         
                        int index6_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_78);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA6_79 = input.LA(1);

                         
                        int index6_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_79);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA6_80 = input.LA(1);

                         
                        int index6_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_80);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA6_81 = input.LA(1);

                         
                        int index6_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_81);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA6_89 = input.LA(1);

                         
                        int index6_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null )))) ) {s = 25;}

                         
                        input.seek(index6_89);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA6_90 = input.LA(1);

                         
                        int index6_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null )))) ) {s = 25;}

                         
                        input.seek(index6_90);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA6_91 = input.LA(1);

                         
                        int index6_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null )))) ) {s = 25;}

                         
                        input.seek(index6_91);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA6_92 = input.LA(1);

                         
                        int index6_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_92);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA6_93 = input.LA(1);

                         
                        int index6_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_93);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA6_94 = input.LA(1);

                         
                        int index6_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_94);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA6_95 = input.LA(1);

                         
                        int index6_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null )))) ) {s = 25;}

                         
                        input.seek(index6_95);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA6_96 = input.LA(1);

                         
                        int index6_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null )))) ) {s = 25;}

                         
                        input.seek(index6_96);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA6_97 = input.LA(1);

                         
                        int index6_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_97);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA6_101 = input.LA(1);

                         
                        int index6_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_101);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA6_102 = input.LA(1);

                         
                        int index6_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_102);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA6_104 = input.LA(1);

                         
                        int index6_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_104);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA6_105 = input.LA(1);

                         
                        int index6_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_105);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA6_106 = input.LA(1);

                         
                        int index6_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_106);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA6_107 = input.LA(1);

                         
                        int index6_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_107);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA6_108 = input.LA(1);

                         
                        int index6_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_108);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA6_109 = input.LA(1);

                         
                        int index6_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_109);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA6_110 = input.LA(1);

                         
                        int index6_110 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_110);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA6_112 = input.LA(1);

                         
                        int index6_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_112);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA6_113 = input.LA(1);

                         
                        int index6_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_113);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA6_114 = input.LA(1);

                         
                        int index6_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_114);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA6_115 = input.LA(1);

                         
                        int index6_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_115);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA6_116 = input.LA(1);

                         
                        int index6_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_116);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA6_117 = input.LA(1);

                         
                        int index6_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_117);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA6_118 = input.LA(1);

                         
                        int index6_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_118);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA6_120 = input.LA(1);

                         
                        int index6_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_120);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA6_121 = input.LA(1);

                         
                        int index6_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_121);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA6_122 = input.LA(1);

                         
                        int index6_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_122);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA6_123 = input.LA(1);

                         
                        int index6_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_123);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA6_124 = input.LA(1);

                         
                        int index6_124 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 25;}

                         
                        input.seek(index6_124);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA6_125 = input.LA(1);

                         
                        int index6_125 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 25;}

                         
                        input.seek(index6_125);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA6_126 = input.LA(1);

                         
                        int index6_126 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 25;}

                         
                        input.seek(index6_126);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA6_127 = input.LA(1);

                         
                        int index6_127 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 25;}

                         
                        input.seek(index6_127);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA6_128 = input.LA(1);

                         
                        int index6_128 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 25;}

                         
                        input.seek(index6_128);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA6_130 = input.LA(1);

                         
                        int index6_130 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 25;}

                         
                        input.seek(index6_130);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA6_131 = input.LA(1);

                         
                        int index6_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 25;}

                         
                        input.seek(index6_131);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA6_132 = input.LA(1);

                         
                        int index6_132 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 25;}

                         
                        input.seek(index6_132);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA6_133 = input.LA(1);

                         
                        int index6_133 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 25;}

                         
                        input.seek(index6_133);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA6_134 = input.LA(1);

                         
                        int index6_134 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 25;}

                         
                        input.seek(index6_134);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA6_136 = input.LA(1);

                         
                        int index6_136 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 25;}

                         
                        input.seek(index6_136);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA6_137 = input.LA(1);

                         
                        int index6_137 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 25;}

                         
                        input.seek(index6_137);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA6_138 = input.LA(1);

                         
                        int index6_138 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 25;}

                         
                        input.seek(index6_138);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA6_139 = input.LA(1);

                         
                        int index6_139 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 25;}

                         
                        input.seek(index6_139);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA6_140 = input.LA(1);

                         
                        int index6_140 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 25;}

                         
                        input.seek(index6_140);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA6_141 = input.LA(1);

                         
                        int index6_141 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 25;}

                         
                        input.seek(index6_141);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA6_142 = input.LA(1);

                         
                        int index6_142 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 25;}

                         
                        input.seek(index6_142);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA6_143 = input.LA(1);

                         
                        int index6_143 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 25;}

                         
                        input.seek(index6_143);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA6_144 = input.LA(1);

                         
                        int index6_144 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_144);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA6_145 = input.LA(1);

                         
                        int index6_145 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_145);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA6_146 = input.LA(1);

                         
                        int index6_146 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_146);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA6_147 = input.LA(1);

                         
                        int index6_147 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_147);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA6_148 = input.LA(1);

                         
                        int index6_148 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_148);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA6_150 = input.LA(1);

                         
                        int index6_150 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_150);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA6_151 = input.LA(1);

                         
                        int index6_151 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_151);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA6_152 = input.LA(1);

                         
                        int index6_152 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_152);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA6_153 = input.LA(1);

                         
                        int index6_153 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_153);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA6_154 = input.LA(1);

                         
                        int index6_154 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_154);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA6_155 = input.LA(1);

                         
                        int index6_155 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_155);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA6_156 = input.LA(1);

                         
                        int index6_156 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_156);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA6_158 = input.LA(1);

                         
                        int index6_158 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_158);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA6_159 = input.LA(1);

                         
                        int index6_159 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_159);
                        if ( s>=0 ) return s;
                        break;
                    case 96 : 
                        int LA6_161 = input.LA(1);

                         
                        int index6_161 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_161);
                        if ( s>=0 ) return s;
                        break;
                    case 97 : 
                        int LA6_166 = input.LA(1);

                         
                        int index6_166 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_166);
                        if ( s>=0 ) return s;
                        break;
                    case 98 : 
                        int LA6_167 = input.LA(1);

                         
                        int index6_167 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_167);
                        if ( s>=0 ) return s;
                        break;
                    case 99 : 
                        int LA6_168 = input.LA(1);

                         
                        int index6_168 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_168);
                        if ( s>=0 ) return s;
                        break;
                    case 100 : 
                        int LA6_169 = input.LA(1);

                         
                        int index6_169 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_169);
                        if ( s>=0 ) return s;
                        break;
                    case 101 : 
                        int LA6_170 = input.LA(1);

                         
                        int index6_170 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_170);
                        if ( s>=0 ) return s;
                        break;
                    case 102 : 
                        int LA6_172 = input.LA(1);

                         
                        int index6_172 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_172);
                        if ( s>=0 ) return s;
                        break;
                    case 103 : 
                        int LA6_173 = input.LA(1);

                         
                        int index6_173 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_173);
                        if ( s>=0 ) return s;
                        break;
                    case 104 : 
                        int LA6_174 = input.LA(1);

                         
                        int index6_174 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_174);
                        if ( s>=0 ) return s;
                        break;
                    case 105 : 
                        int LA6_175 = input.LA(1);

                         
                        int index6_175 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_175);
                        if ( s>=0 ) return s;
                        break;
                    case 106 : 
                        int LA6_176 = input.LA(1);

                         
                        int index6_176 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_176);
                        if ( s>=0 ) return s;
                        break;
                    case 107 : 
                        int LA6_178 = input.LA(1);

                         
                        int index6_178 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_178);
                        if ( s>=0 ) return s;
                        break;
                    case 108 : 
                        int LA6_179 = input.LA(1);

                         
                        int index6_179 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_179);
                        if ( s>=0 ) return s;
                        break;
                    case 109 : 
                        int LA6_180 = input.LA(1);

                         
                        int index6_180 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_180);
                        if ( s>=0 ) return s;
                        break;
                    case 110 : 
                        int LA6_183 = input.LA(1);

                         
                        int index6_183 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_183);
                        if ( s>=0 ) return s;
                        break;
                    case 111 : 
                        int LA6_184 = input.LA(1);

                         
                        int index6_184 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_184);
                        if ( s>=0 ) return s;
                        break;
                    case 112 : 
                        int LA6_185 = input.LA(1);

                         
                        int index6_185 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_185);
                        if ( s>=0 ) return s;
                        break;
                    case 113 : 
                        int LA6_186 = input.LA(1);

                         
                        int index6_186 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_186);
                        if ( s>=0 ) return s;
                        break;
                    case 114 : 
                        int LA6_187 = input.LA(1);

                         
                        int index6_187 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_187);
                        if ( s>=0 ) return s;
                        break;
                    case 115 : 
                        int LA6_189 = input.LA(1);

                         
                        int index6_189 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_189);
                        if ( s>=0 ) return s;
                        break;
                    case 116 : 
                        int LA6_190 = input.LA(1);

                         
                        int index6_190 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_190);
                        if ( s>=0 ) return s;
                        break;
                    case 117 : 
                        int LA6_191 = input.LA(1);

                         
                        int index6_191 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_191);
                        if ( s>=0 ) return s;
                        break;
                    case 118 : 
                        int LA6_192 = input.LA(1);

                         
                        int index6_192 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_192);
                        if ( s>=0 ) return s;
                        break;
                    case 119 : 
                        int LA6_193 = input.LA(1);

                         
                        int index6_193 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_193);
                        if ( s>=0 ) return s;
                        break;
                    case 120 : 
                        int LA6_194 = input.LA(1);

                         
                        int index6_194 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_194);
                        if ( s>=0 ) return s;
                        break;
                    case 121 : 
                        int LA6_196 = input.LA(1);

                         
                        int index6_196 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_196);
                        if ( s>=0 ) return s;
                        break;
                    case 122 : 
                        int LA6_197 = input.LA(1);

                         
                        int index6_197 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_197);
                        if ( s>=0 ) return s;
                        break;
                    case 123 : 
                        int LA6_199 = input.LA(1);

                         
                        int index6_199 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_199);
                        if ( s>=0 ) return s;
                        break;
                    case 124 : 
                        int LA6_204 = input.LA(1);

                         
                        int index6_204 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_204);
                        if ( s>=0 ) return s;
                        break;
                    case 125 : 
                        int LA6_205 = input.LA(1);

                         
                        int index6_205 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_205);
                        if ( s>=0 ) return s;
                        break;
                    case 126 : 
                        int LA6_206 = input.LA(1);

                         
                        int index6_206 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_206);
                        if ( s>=0 ) return s;
                        break;
                    case 127 : 
                        int LA6_207 = input.LA(1);

                         
                        int index6_207 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_207);
                        if ( s>=0 ) return s;
                        break;
                    case 128 : 
                        int LA6_208 = input.LA(1);

                         
                        int index6_208 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_208);
                        if ( s>=0 ) return s;
                        break;
                    case 129 : 
                        int LA6_210 = input.LA(1);

                         
                        int index6_210 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_210);
                        if ( s>=0 ) return s;
                        break;
                    case 130 : 
                        int LA6_211 = input.LA(1);

                         
                        int index6_211 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_211);
                        if ( s>=0 ) return s;
                        break;
                    case 131 : 
                        int LA6_212 = input.LA(1);

                         
                        int index6_212 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_212);
                        if ( s>=0 ) return s;
                        break;
                    case 132 : 
                        int LA6_213 = input.LA(1);

                         
                        int index6_213 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_213);
                        if ( s>=0 ) return s;
                        break;
                    case 133 : 
                        int LA6_214 = input.LA(1);

                         
                        int index6_214 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_214);
                        if ( s>=0 ) return s;
                        break;
                    case 134 : 
                        int LA6_216 = input.LA(1);

                         
                        int index6_216 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_216);
                        if ( s>=0 ) return s;
                        break;
                    case 135 : 
                        int LA6_217 = input.LA(1);

                         
                        int index6_217 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_217);
                        if ( s>=0 ) return s;
                        break;
                    case 136 : 
                        int LA6_218 = input.LA(1);

                         
                        int index6_218 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_218);
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
        "\1\112\13\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\2\1\1\11\uffff";
    static final String DFA5_specialS =
        "\14\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\2\21\uffff\1\1\2\2\3\uffff\3\2\14\uffff\3\2\13\uffff\20\2",
            "",
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
            return "()* loopback of 262:6: (subD= declaration )*";
        }
    }
    static final String DFA13_eotS =
        "\17\uffff";
    static final String DFA13_eofS =
        "\17\uffff";
    static final String DFA13_minS =
        "\1\6\16\uffff";
    static final String DFA13_maxS =
        "\1\112\16\uffff";
    static final String DFA13_acceptS =
        "\1\uffff\1\1\14\uffff\1\2";
    static final String DFA13_specialS =
        "\17\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\1\20\uffff\1\1\6\uffff\1\1\2\uffff\1\1\1\16\1\uffff\1\1\4"+
            "\uffff\3\1\1\uffff\3\1\13\uffff\20\1",
            "",
            "",
            "",
            "",
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
            return "359:3: ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' )";
        }
    }
    static final String DFA12_eotS =
        "\16\uffff";
    static final String DFA12_eofS =
        "\16\uffff";
    static final String DFA12_minS =
        "\1\6\15\uffff";
    static final String DFA12_maxS =
        "\1\112\15\uffff";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\1\2\13\uffff";
    static final String DFA12_specialS =
        "\16\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\2\20\uffff\1\2\6\uffff\1\2\2\uffff\1\1\2\uffff\1\2\4\uffff"+
            "\3\2\1\uffff\3\2\13\uffff\20\2",
            "",
            "",
            "",
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
            return "360:4: ( ':' parentClass= IDENTIFIER )?";
        }
    }
    static final String DFA16_eotS =
        "\15\uffff";
    static final String DFA16_eofS =
        "\15\uffff";
    static final String DFA16_minS =
        "\1\6\14\uffff";
    static final String DFA16_maxS =
        "\1\112\14\uffff";
    static final String DFA16_acceptS =
        "\1\uffff\1\1\1\2\12\uffff";
    static final String DFA16_specialS =
        "\15\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\2\20\uffff\1\2\6\uffff\1\2\5\uffff\1\1\4\uffff\3\2\1\uffff"+
            "\3\2\13\uffff\20\2",
            "",
            "",
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
            return "370:3: ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )?";
        }
    }
    static final String DFA19_eotS =
        "\14\uffff";
    static final String DFA19_eofS =
        "\14\uffff";
    static final String DFA19_minS =
        "\1\6\13\uffff";
    static final String DFA19_maxS =
        "\1\112\13\uffff";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\1\2\11\uffff";
    static final String DFA19_specialS =
        "\14\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\2\20\uffff\1\1\6\uffff\1\2\12\uffff\3\2\1\uffff\3\2\13\uffff"+
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
            return "379:3: ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )?";
        }
    }
    static final String DFA18_eotS =
        "\13\uffff";
    static final String DFA18_eofS =
        "\13\uffff";
    static final String DFA18_minS =
        "\1\6\12\uffff";
    static final String DFA18_maxS =
        "\1\112\12\uffff";
    static final String DFA18_acceptS =
        "\1\uffff\1\5\1\1\1\2\1\3\1\4\5\uffff";
    static final String DFA18_specialS =
        "\13\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\5\21\uffff\1\1\5\uffff\1\5\7\uffff\1\2\1\3\1\4\4\uffff\3"+
            "\5\14\uffff\17\5",
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
            return "()* loopback of 381:4: ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )*";
        }
    }
    static final String DFA17_eotS =
        "\u00e1\uffff";
    static final String DFA17_eofS =
        "\u00e1\uffff";
    static final String DFA17_minS =
        "\4\6\1\100\2\6\1\4\3\6\1\66\1\uffff\3\6\1\100\2\6\1\uffff\2\6\1"+
        "\27\6\6\1\66\1\6\1\uffff\2\6\1\uffff\3\6\1\66\1\6\2\uffff\16\0\1"+
        "\uffff\14\0\3\uffff\4\0\1\uffff\1\0\2\uffff\5\0\1\uffff\23\0\1\uffff"+
        "\2\0\1\uffff\5\0\2\uffff\4\0\1\uffff\1\0\1\uffff\26\0\1\uffff\2"+
        "\0\1\uffff\5\0\2\uffff\1\0\7\uffff\5\0\3\uffff\5\0\1\uffff\3\0\2"+
        "\uffff\5\0\1\uffff\1\0\1\uffff\5\0\2\uffff\1\0\7\uffff\5\0\3\uffff"+
        "\5\0\1\uffff\3\0\2\uffff";
    static final String DFA17_maxS =
        "\2\112\2\27\2\112\1\72\1\131\1\112\2\72\1\66\1\uffff\1\112\2\27"+
        "\2\112\1\72\1\uffff\1\72\1\112\1\27\1\6\1\112\4\72\1\66\1\72\1\uffff"+
        "\1\112\1\72\1\uffff\3\72\1\66\1\72\2\uffff\16\0\1\uffff\14\0\3\uffff"+
        "\4\0\1\uffff\1\0\2\uffff\5\0\1\uffff\23\0\1\uffff\2\0\1\uffff\5"+
        "\0\2\uffff\4\0\1\uffff\1\0\1\uffff\26\0\1\uffff\2\0\1\uffff\5\0"+
        "\2\uffff\1\0\7\uffff\5\0\3\uffff\5\0\1\uffff\3\0\2\uffff\5\0\1\uffff"+
        "\1\0\1\uffff\5\0\2\uffff\1\0\7\uffff\5\0\3\uffff\5\0\1\uffff\3\0"+
        "\2\uffff";
    static final String DFA17_acceptS =
        "\14\uffff\1\2\6\uffff\1\1\u00cd\uffff";
    static final String DFA17_specialS =
        "\52\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\uffff\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1"+
        "\27\1\30\1\31\3\uffff\1\32\1\33\1\34\1\35\1\uffff\1\36\2\uffff\1"+
        "\37\1\40\1\41\1\42\1\43\1\uffff\1\44\1\45\1\46\1\47\1\50\1\51\1"+
        "\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66"+
        "\1\uffff\1\67\1\70\1\uffff\1\71\1\72\1\73\1\74\1\75\2\uffff\1\76"+
        "\1\77\1\100\1\101\1\uffff\1\102\1\uffff\1\103\1\104\1\105\1\106"+
        "\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1\116\1\117\1\120\1\121"+
        "\1\122\1\123\1\124\1\125\1\126\1\127\1\130\1\uffff\1\131\1\132\1"+
        "\uffff\1\133\1\134\1\135\1\136\1\137\2\uffff\1\140\7\uffff\1\141"+
        "\1\142\1\143\1\144\1\145\3\uffff\1\146\1\147\1\150\1\151\1\152\1"+
        "\uffff\1\153\1\154\1\155\2\uffff\1\156\1\157\1\160\1\161\1\162\1"+
        "\uffff\1\163\1\uffff\1\164\1\165\1\166\1\167\1\170\2\uffff\1\171"+
        "\7\uffff\1\172\1\173\1\174\1\175\1\176\3\uffff\1\177\1\u0080\1\u0081"+
        "\1\u0082\1\u0083\1\uffff\1\u0084\1\u0085\1\u0086\2\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\1\27\uffff\1\3\16\uffff\3\2\14\uffff\4\4\2\5\11\6",
            "\1\10\25\uffff\1\14\1\uffff\1\17\3\uffff\1\7\1\uffff\1\15\10"+
            "\uffff\3\16\3\uffff\1\11\1\12\1\13\4\uffff\1\23\1\uffff\4\20"+
            "\2\21\11\22",
            "\1\24\20\uffff\1\25",
            "\1\26\20\uffff\1\27",
            "\2\30\11\31",
            "\1\32\25\uffff\1\14\5\uffff\1\36\20\uffff\1\33\1\34\1\35\4"+
            "\uffff\1\23\5\uffff\2\40\11\41",
            "\1\43\25\uffff\1\14\5\uffff\1\47\20\uffff\1\44\1\45\1\46\4"+
            "\uffff\1\23",
            "\1\60\1\65\1\53\1\61\1\62\1\63\1\64\14\uffff\1\66\12\uffff"+
            "\1\57\20\uffff\1\67\1\23\1\55\1\uffff\1\52\2\uffff\1\23\20\uffff"+
            "\1\54\14\uffff\2\56",
            "\1\73\24\uffff\1\23\1\76\1\23\1\101\3\uffff\1\72\1\uffff\1"+
            "\77\10\uffff\3\100\3\uffff\1\71\1\74\1\75\4\uffff\1\23\1\uffff"+
            "\4\102\2\103\11\104",
            "\1\110\25\uffff\1\14\5\uffff\1\112\20\uffff\1\111\1\113\1\115"+
            "\4\uffff\1\23",
            "\1\120\25\uffff\1\14\5\uffff\1\124\20\uffff\1\121\1\122\1\123"+
            "\4\uffff\1\23",
            "\1\126",
            "",
            "\1\131\27\uffff\1\130\6\uffff\1\135\7\uffff\3\127\14\uffff"+
            "\4\132\2\133\11\134",
            "\1\136\20\uffff\1\137",
            "\1\140\20\uffff\1\141",
            "\2\142\11\143",
            "\1\144\25\uffff\1\14\5\uffff\1\150\20\uffff\1\145\1\146\1\147"+
            "\4\uffff\1\23\5\uffff\2\152\11\153",
            "\1\155\25\uffff\1\14\5\uffff\1\161\20\uffff\1\156\1\157\1\160"+
            "\4\uffff\1\23",
            "",
            "\1\165\20\uffff\1\164\4\uffff\1\171\5\uffff\1\173\20\uffff"+
            "\1\166\1\167\1\14\4\uffff\1\23",
            "\1\u0081\21\uffff\1\u0089\1\u0088\1\u0087\3\uffff\1\u0080\2"+
            "\u0085\14\uffff\3\177\1\174\1\175\1\176\10\uffff\1\u0086\4\u0082"+
            "\2\u0083\11\u0084",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c\25\uffff\1\14\5\uffff\1\u0090\20\uffff\1\u008d\1\u008e"+
            "\1\u008f\4\uffff\1\23\5\uffff\2\u0092\11\u0093",
            "\1\u0095\25\uffff\1\14\5\uffff\1\u0099\20\uffff\1\u0096\1\u0097"+
            "\1\u0098\4\uffff\1\23",
            "\1\23\24\uffff\3\23\4\uffff\1\23\20\uffff\1\u009c\2\23\4\uffff"+
            "\1\23",
            "\1\u00a5\25\uffff\1\14\5\uffff\1\u00a4\20\uffff\1\u00a6\1\u00a7"+
            "\1\u00a8\4\uffff\1\23",
            "\1\u00ac\25\uffff\1\14\5\uffff\1\u00b0\20\uffff\1\u00ad\1\u00ae"+
            "\1\u00af\4\uffff\1\23",
            "\1\u00b2",
            "\1\u00b3\33\uffff\1\23\20\uffff\1\u00b4\1\23\5\uffff\1\23",
            "",
            "\1\u00b7\25\uffff\1\14\5\uffff\1\u00bb\20\uffff\1\u00b8\1\u00b9"+
            "\1\u00ba\4\uffff\1\23\5\uffff\13\u00bd",
            "\1\u00bf\25\uffff\1\14\5\uffff\1\u00c3\20\uffff\1\u00c0\1\u00c1"+
            "\1\u00c2\4\uffff\1\23",
            "",
            "\1\23\24\uffff\3\23\4\uffff\1\23\20\uffff\1\u00c6\2\23\4\uffff"+
            "\1\23",
            "\1\u00cf\25\uffff\1\14\5\uffff\1\u00ce\20\uffff\1\u00d0\1\u00d1"+
            "\1\u00d2\4\uffff\1\23",
            "\1\u00d6\25\uffff\1\14\5\uffff\1\u00da\20\uffff\1\u00d7\1\u00d8"+
            "\1\u00d9\4\uffff\1\23",
            "\1\u00dc",
            "\1\u00dd\33\uffff\1\23\20\uffff\1\u00de\1\23\5\uffff\1\23",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            "",
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
            return "386:6: (fv= varDecl | functionPointerVarDecl )";
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
                        if ( ((synpred26_ObjCpp()&&( "__success".equals(next()) ))) ) {s = 19;}

                        else if ( (( "__success".equals(next()) )) ) {s = 12;}

                         
                        input.seek(index17_42);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_43 = input.LA(1);

                         
                        int index17_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 12;}

                         
                        input.seek(index17_43);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA17_44 = input.LA(1);

                         
                        int index17_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_44);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA17_45 = input.LA(1);

                         
                        int index17_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_45);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA17_46 = input.LA(1);

                         
                        int index17_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_46);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA17_47 = input.LA(1);

                         
                        int index17_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_47);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA17_48 = input.LA(1);

                         
                        int index17_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_48);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA17_49 = input.LA(1);

                         
                        int index17_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_49);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA17_50 = input.LA(1);

                         
                        int index17_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_50);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA17_51 = input.LA(1);

                         
                        int index17_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_51);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA17_52 = input.LA(1);

                         
                        int index17_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_52);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA17_53 = input.LA(1);

                         
                        int index17_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_53);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA17_54 = input.LA(1);

                         
                        int index17_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_54);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA17_55 = input.LA(1);

                         
                        int index17_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 12;}

                         
                        input.seek(index17_55);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA17_57 = input.LA(1);

                         
                        int index17_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 12;}

                         
                        input.seek(index17_57);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA17_58 = input.LA(1);

                         
                        int index17_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_58);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA17_59 = input.LA(1);

                         
                        int index17_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_59);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA17_60 = input.LA(1);

                         
                        int index17_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_60);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA17_61 = input.LA(1);

                         
                        int index17_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_61);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA17_62 = input.LA(1);

                         
                        int index17_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_62);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA17_63 = input.LA(1);

                         
                        int index17_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_63);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA17_64 = input.LA(1);

                         
                        int index17_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_64);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA17_65 = input.LA(1);

                         
                        int index17_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_65);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA17_66 = input.LA(1);

                         
                        int index17_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_66);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA17_67 = input.LA(1);

                         
                        int index17_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_67);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA17_68 = input.LA(1);

                         
                        int index17_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_68);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA17_72 = input.LA(1);

                         
                        int index17_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 12;}

                         
                        input.seek(index17_72);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA17_73 = input.LA(1);

                         
                        int index17_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 12;}

                         
                        input.seek(index17_73);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA17_74 = input.LA(1);

                         
                        int index17_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 12;}

                         
                        input.seek(index17_74);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA17_75 = input.LA(1);

                         
                        int index17_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 12;}

                         
                        input.seek(index17_75);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA17_77 = input.LA(1);

                         
                        int index17_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 12;}

                         
                        input.seek(index17_77);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA17_80 = input.LA(1);

                         
                        int index17_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 12;}

                         
                        input.seek(index17_80);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA17_81 = input.LA(1);

                         
                        int index17_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 12;}

                         
                        input.seek(index17_81);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA17_82 = input.LA(1);

                         
                        int index17_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 12;}

                         
                        input.seek(index17_82);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA17_83 = input.LA(1);

                         
                        int index17_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 12;}

                         
                        input.seek(index17_83);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA17_84 = input.LA(1);

                         
                        int index17_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 12;}

                         
                        input.seek(index17_84);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA17_86 = input.LA(1);

                         
                        int index17_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 12;}

                         
                        input.seek(index17_86);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA17_87 = input.LA(1);

                         
                        int index17_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 12;}

                         
                        input.seek(index17_87);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA17_88 = input.LA(1);

                         
                        int index17_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 12;}

                         
                        input.seek(index17_88);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA17_89 = input.LA(1);

                         
                        int index17_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 12;}

                         
                        input.seek(index17_89);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA17_90 = input.LA(1);

                         
                        int index17_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 12;}

                         
                        input.seek(index17_90);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA17_91 = input.LA(1);

                         
                        int index17_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 12;}

                         
                        input.seek(index17_91);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA17_92 = input.LA(1);

                         
                        int index17_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 12;}

                         
                        input.seek(index17_92);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA17_93 = input.LA(1);

                         
                        int index17_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 12;}

                         
                        input.seek(index17_93);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA17_94 = input.LA(1);

                         
                        int index17_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 12;}

                         
                        input.seek(index17_94);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA17_95 = input.LA(1);

                         
                        int index17_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 12;}

                         
                        input.seek(index17_95);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA17_96 = input.LA(1);

                         
                        int index17_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 12;}

                         
                        input.seek(index17_96);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA17_97 = input.LA(1);

                         
                        int index17_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 12;}

                         
                        input.seek(index17_97);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA17_98 = input.LA(1);

                         
                        int index17_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_98);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA17_99 = input.LA(1);

                         
                        int index17_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_99);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA17_100 = input.LA(1);

                         
                        int index17_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_100);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA17_101 = input.LA(1);

                         
                        int index17_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_101);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA17_102 = input.LA(1);

                         
                        int index17_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_102);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA17_103 = input.LA(1);

                         
                        int index17_103 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_103);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA17_104 = input.LA(1);

                         
                        int index17_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_104);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA17_106 = input.LA(1);

                         
                        int index17_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_106);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA17_107 = input.LA(1);

                         
                        int index17_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_107);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA17_109 = input.LA(1);

                         
                        int index17_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_109);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA17_110 = input.LA(1);

                         
                        int index17_110 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_110);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA17_111 = input.LA(1);

                         
                        int index17_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_111);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA17_112 = input.LA(1);

                         
                        int index17_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_112);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA17_113 = input.LA(1);

                         
                        int index17_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 12;}

                         
                        input.seek(index17_113);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA17_116 = input.LA(1);

                         
                        int index17_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_116);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA17_117 = input.LA(1);

                         
                        int index17_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_117);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA17_118 = input.LA(1);

                         
                        int index17_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_118);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA17_119 = input.LA(1);

                         
                        int index17_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_119);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA17_121 = input.LA(1);

                         
                        int index17_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_121);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA17_123 = input.LA(1);

                         
                        int index17_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_123);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA17_124 = input.LA(1);

                         
                        int index17_124 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_124);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA17_125 = input.LA(1);

                         
                        int index17_125 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_125);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA17_126 = input.LA(1);

                         
                        int index17_126 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_126);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA17_127 = input.LA(1);

                         
                        int index17_127 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_127);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA17_128 = input.LA(1);

                         
                        int index17_128 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_128);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA17_129 = input.LA(1);

                         
                        int index17_129 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_129);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA17_130 = input.LA(1);

                         
                        int index17_130 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_130);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA17_131 = input.LA(1);

                         
                        int index17_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_131);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA17_132 = input.LA(1);

                         
                        int index17_132 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_132);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA17_133 = input.LA(1);

                         
                        int index17_133 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_133);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA17_134 = input.LA(1);

                         
                        int index17_134 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_134);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA17_135 = input.LA(1);

                         
                        int index17_135 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_135);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA17_136 = input.LA(1);

                         
                        int index17_136 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_136);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA17_137 = input.LA(1);

                         
                        int index17_137 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_137);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA17_138 = input.LA(1);

                         
                        int index17_138 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_138);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA17_139 = input.LA(1);

                         
                        int index17_139 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_139);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA17_140 = input.LA(1);

                         
                        int index17_140 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_140);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA17_141 = input.LA(1);

                         
                        int index17_141 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_141);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA17_142 = input.LA(1);

                         
                        int index17_142 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_142);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA17_143 = input.LA(1);

                         
                        int index17_143 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_143);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA17_144 = input.LA(1);

                         
                        int index17_144 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_144);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA17_146 = input.LA(1);

                         
                        int index17_146 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_146);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA17_147 = input.LA(1);

                         
                        int index17_147 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_147);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA17_149 = input.LA(1);

                         
                        int index17_149 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_149);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA17_150 = input.LA(1);

                         
                        int index17_150 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_150);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA17_151 = input.LA(1);

                         
                        int index17_151 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_151);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA17_152 = input.LA(1);

                         
                        int index17_152 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_152);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA17_153 = input.LA(1);

                         
                        int index17_153 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_153);
                        if ( s>=0 ) return s;
                        break;
                    case 96 : 
                        int LA17_156 = input.LA(1);

                         
                        int index17_156 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_156);
                        if ( s>=0 ) return s;
                        break;
                    case 97 : 
                        int LA17_164 = input.LA(1);

                         
                        int index17_164 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_164);
                        if ( s>=0 ) return s;
                        break;
                    case 98 : 
                        int LA17_165 = input.LA(1);

                         
                        int index17_165 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_165);
                        if ( s>=0 ) return s;
                        break;
                    case 99 : 
                        int LA17_166 = input.LA(1);

                         
                        int index17_166 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_166);
                        if ( s>=0 ) return s;
                        break;
                    case 100 : 
                        int LA17_167 = input.LA(1);

                         
                        int index17_167 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_167);
                        if ( s>=0 ) return s;
                        break;
                    case 101 : 
                        int LA17_168 = input.LA(1);

                         
                        int index17_168 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_168);
                        if ( s>=0 ) return s;
                        break;
                    case 102 : 
                        int LA17_172 = input.LA(1);

                         
                        int index17_172 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_172);
                        if ( s>=0 ) return s;
                        break;
                    case 103 : 
                        int LA17_173 = input.LA(1);

                         
                        int index17_173 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_173);
                        if ( s>=0 ) return s;
                        break;
                    case 104 : 
                        int LA17_174 = input.LA(1);

                         
                        int index17_174 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_174);
                        if ( s>=0 ) return s;
                        break;
                    case 105 : 
                        int LA17_175 = input.LA(1);

                         
                        int index17_175 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_175);
                        if ( s>=0 ) return s;
                        break;
                    case 106 : 
                        int LA17_176 = input.LA(1);

                         
                        int index17_176 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_176);
                        if ( s>=0 ) return s;
                        break;
                    case 107 : 
                        int LA17_178 = input.LA(1);

                         
                        int index17_178 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_178);
                        if ( s>=0 ) return s;
                        break;
                    case 108 : 
                        int LA17_179 = input.LA(1);

                         
                        int index17_179 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_179);
                        if ( s>=0 ) return s;
                        break;
                    case 109 : 
                        int LA17_180 = input.LA(1);

                         
                        int index17_180 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_180);
                        if ( s>=0 ) return s;
                        break;
                    case 110 : 
                        int LA17_183 = input.LA(1);

                         
                        int index17_183 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_183);
                        if ( s>=0 ) return s;
                        break;
                    case 111 : 
                        int LA17_184 = input.LA(1);

                         
                        int index17_184 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_184);
                        if ( s>=0 ) return s;
                        break;
                    case 112 : 
                        int LA17_185 = input.LA(1);

                         
                        int index17_185 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_185);
                        if ( s>=0 ) return s;
                        break;
                    case 113 : 
                        int LA17_186 = input.LA(1);

                         
                        int index17_186 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_186);
                        if ( s>=0 ) return s;
                        break;
                    case 114 : 
                        int LA17_187 = input.LA(1);

                         
                        int index17_187 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_187);
                        if ( s>=0 ) return s;
                        break;
                    case 115 : 
                        int LA17_189 = input.LA(1);

                         
                        int index17_189 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_189);
                        if ( s>=0 ) return s;
                        break;
                    case 116 : 
                        int LA17_191 = input.LA(1);

                         
                        int index17_191 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_191);
                        if ( s>=0 ) return s;
                        break;
                    case 117 : 
                        int LA17_192 = input.LA(1);

                         
                        int index17_192 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_192);
                        if ( s>=0 ) return s;
                        break;
                    case 118 : 
                        int LA17_193 = input.LA(1);

                         
                        int index17_193 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_193);
                        if ( s>=0 ) return s;
                        break;
                    case 119 : 
                        int LA17_194 = input.LA(1);

                         
                        int index17_194 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_194);
                        if ( s>=0 ) return s;
                        break;
                    case 120 : 
                        int LA17_195 = input.LA(1);

                         
                        int index17_195 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_195);
                        if ( s>=0 ) return s;
                        break;
                    case 121 : 
                        int LA17_198 = input.LA(1);

                         
                        int index17_198 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_198);
                        if ( s>=0 ) return s;
                        break;
                    case 122 : 
                        int LA17_206 = input.LA(1);

                         
                        int index17_206 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_206);
                        if ( s>=0 ) return s;
                        break;
                    case 123 : 
                        int LA17_207 = input.LA(1);

                         
                        int index17_207 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_207);
                        if ( s>=0 ) return s;
                        break;
                    case 124 : 
                        int LA17_208 = input.LA(1);

                         
                        int index17_208 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_208);
                        if ( s>=0 ) return s;
                        break;
                    case 125 : 
                        int LA17_209 = input.LA(1);

                         
                        int index17_209 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_209);
                        if ( s>=0 ) return s;
                        break;
                    case 126 : 
                        int LA17_210 = input.LA(1);

                         
                        int index17_210 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_210);
                        if ( s>=0 ) return s;
                        break;
                    case 127 : 
                        int LA17_214 = input.LA(1);

                         
                        int index17_214 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_214);
                        if ( s>=0 ) return s;
                        break;
                    case 128 : 
                        int LA17_215 = input.LA(1);

                         
                        int index17_215 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_215);
                        if ( s>=0 ) return s;
                        break;
                    case 129 : 
                        int LA17_216 = input.LA(1);

                         
                        int index17_216 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_216);
                        if ( s>=0 ) return s;
                        break;
                    case 130 : 
                        int LA17_217 = input.LA(1);

                         
                        int index17_217 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_217);
                        if ( s>=0 ) return s;
                        break;
                    case 131 : 
                        int LA17_218 = input.LA(1);

                         
                        int index17_218 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_218);
                        if ( s>=0 ) return s;
                        break;
                    case 132 : 
                        int LA17_220 = input.LA(1);

                         
                        int index17_220 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_220);
                        if ( s>=0 ) return s;
                        break;
                    case 133 : 
                        int LA17_221 = input.LA(1);

                         
                        int index17_221 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_221);
                        if ( s>=0 ) return s;
                        break;
                    case 134 : 
                        int LA17_222 = input.LA(1);

                         
                        int index17_222 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 12;}

                         
                        input.seek(index17_222);
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
        "\1\112\12\uffff";
    static final String DFA20_acceptS =
        "\1\uffff\1\4\1\1\1\uffff\1\2\1\3\5\uffff";
    static final String DFA20_specialS =
        "\13\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\5\27\uffff\1\5\12\uffff\1\1\2\2\1\uffff\3\5\13\uffff\1\4"+
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
            return "()* loopback of 399:3: ( objCMethodDecl | typeDef | vd= varDecl {...}?)*";
        }
    }
    static final String DFA31_eotS =
        "\40\uffff";
    static final String DFA31_eofS =
        "\1\uffff\1\6\2\uffff\1\6\33\uffff";
    static final String DFA31_minS =
        "\2\6\1\uffff\2\6\13\uffff\1\0\6\uffff\2\0\7\uffff";
    static final String DFA31_maxS =
        "\1\27\1\72\1\uffff\2\72\13\uffff\1\0\6\uffff\2\0\7\uffff";
    static final String DFA31_acceptS =
        "\2\uffff\1\2\3\uffff\1\1\31\uffff";
    static final String DFA31_specialS =
        "\20\uffff\1\0\6\uffff\1\1\1\2\7\uffff}>";
    static final String[] DFA31_transitionS = {
            "\1\1\20\uffff\1\2",
            "\1\4\20\uffff\1\2\3\uffff\3\6\4\uffff\1\3\1\6\1\uffff\1\6\15"+
            "\uffff\3\6\4\uffff\1\6",
            "",
            "\1\20\33\uffff\1\6\1\2\17\uffff\2\6\5\uffff\1\6",
            "\1\27\20\uffff\1\2\3\uffff\3\6\4\uffff\1\30\1\6\17\uffff\3"+
            "\6\4\uffff\1\6",
            "",
            "",
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
            return "490:3: ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' )";
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
                        if ( (synpred40_ObjCpp()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index31_16);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA31_23 = input.LA(1);

                         
                        int index31_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred40_ObjCpp()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index31_23);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA31_24 = input.LA(1);

                         
                        int index31_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred40_ObjCpp()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index31_24);
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
        "\1\112\16\uffff";
    static final String DFA30_acceptS =
        "\1\uffff\1\3\1\1\2\uffff\1\2\11\uffff";
    static final String DFA30_specialS =
        "\17\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\5\21\uffff\1\1\2\5\3\uffff\3\5\14\uffff\3\5\3\2\10\uffff"+
            "\20\5",
            "",
            "",
            "",
            "",
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
            return "()* loopback of 505:5: ( ( 'public' | 'private' | 'protected' ) ':' | declaration )*";
        }
    }
    static final String DFA32_eotS =
        "\23\uffff";
    static final String DFA32_eofS =
        "\23\uffff";
    static final String DFA32_minS =
        "\1\6\2\uffff\1\0\17\uffff";
    static final String DFA32_maxS =
        "\1\112\2\uffff\1\0\17\uffff";
    static final String DFA32_acceptS =
        "\1\uffff\1\1\20\uffff\1\2";
    static final String DFA32_specialS =
        "\3\uffff\1\0\17\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\3\27\uffff\1\1\16\uffff\3\1\14\uffff\17\1",
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
            return "528:16: (returnTypeRef= typeRef )?";
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
                        if ( ((((synpred47_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred47_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred47_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred47_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred47_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||(synpred47_ObjCpp()&&( "__success".equals(next()) )))) ) {s = 1;}

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
        "\2\63\6\uffff\1\141\2\uffff\1\112\3\uffff\13\0\22\uffff\2\0\6\uffff";
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
            "\1\20\2\25\1\uffff\1\6\12\uffff\3\17\3\2\2\uffff\1\6\1\uffff"+
            "\1\6\3\uffff\1\26\4\22\2\23\11\24\1\6\14\uffff\2\6\2\uffff\1"+
            "\6\1\uffff\4\6",
            "",
            "",
            "\1\54\27\uffff\1\2\4\uffff\1\55\10\uffff\4\2\14\uffff\17\2",
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
            return "()* loopback of 564:3: ( exportationModifier )*";
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
        "\50\uffff";
    static final String DFA42_eofS =
        "\1\uffff\1\2\46\uffff";
    static final String DFA42_minS =
        "\2\6\3\uffff\1\4\22\uffff\1\0\1\uffff\1\0\1\uffff\12\0\2\uffff";
    static final String DFA42_maxS =
        "\2\112\3\uffff\1\131\22\uffff\1\0\1\uffff\1\0\1\uffff\12\0\2\uffff";
    static final String DFA42_acceptS =
        "\2\uffff\1\4\24\uffff\1\1\16\uffff\1\2\1\3";
    static final String DFA42_specialS =
        "\30\uffff\1\0\1\uffff\1\1\1\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1"+
        "\11\1\12\1\13\2\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\1\65\uffff\17\2",
            "\1\2\24\uffff\4\2\3\uffff\1\5\3\2\7\uffff\3\2\3\uffff\3\2\4"+
            "\uffff\1\2\1\uffff\17\2",
            "",
            "",
            "",
            "\1\37\1\44\1\30\1\40\1\41\1\42\1\43\14\uffff\1\45\12\uffff"+
            "\1\32\20\uffff\2\2\1\35\1\uffff\1\27\2\uffff\1\2\20\uffff\1"+
            "\34\14\uffff\2\36",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "697:3: ({...}? IDENTIFIER '(' 'return' binaryOp expression ')' | {...}?m1a= modifier '(' expression ')' | {...}?m2a= modifier '(' expression ',' expression ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA42_24 = input.LA(1);

                         
                        int index42_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred60_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred61_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 2;}

                         
                        input.seek(index42_24);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA42_26 = input.LA(1);

                         
                        int index42_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred60_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred61_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 2;}

                         
                        input.seek(index42_26);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA42_28 = input.LA(1);

                         
                        int index42_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred60_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred61_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index42_28);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA42_29 = input.LA(1);

                         
                        int index42_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred60_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred61_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index42_29);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA42_30 = input.LA(1);

                         
                        int index42_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred60_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred61_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index42_30);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA42_31 = input.LA(1);

                         
                        int index42_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred60_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred61_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index42_31);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA42_32 = input.LA(1);

                         
                        int index42_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred60_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred61_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index42_32);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA42_33 = input.LA(1);

                         
                        int index42_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred60_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred61_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index42_33);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA42_34 = input.LA(1);

                         
                        int index42_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred60_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred61_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index42_34);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA42_35 = input.LA(1);

                         
                        int index42_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred60_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred61_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index42_35);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA42_36 = input.LA(1);

                         
                        int index42_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred60_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred61_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index42_36);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA42_37 = input.LA(1);

                         
                        int index42_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred60_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred61_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index42_37);
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
    static final String DFA43_eotS =
        "\30\uffff";
    static final String DFA43_eofS =
        "\30\uffff";
    static final String DFA43_minS =
        "\1\6\1\0\26\uffff";
    static final String DFA43_maxS =
        "\1\112\1\0\26\uffff";
    static final String DFA43_acceptS =
        "\2\uffff\1\2\24\uffff\1\1";
    static final String DFA43_specialS =
        "\1\uffff\1\0\26\uffff}>";
    static final String[] DFA43_transitionS = {
            "\1\1\65\uffff\17\2",
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
            return "704:3: ({...}?m= modifier )?";
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
                        if ( (((synpred62_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 23;}

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
        "\2\112\3\uffff\1\0\43\uffff";
    static final String DFA48_acceptS =
        "\2\uffff\1\2\17\uffff\1\1\26\uffff";
    static final String DFA48_specialS =
        "\5\uffff\1\0\43\uffff}>";
    static final String[] DFA48_transitionS = {
            "\1\1\65\uffff\17\2",
            "\1\5\24\uffff\3\2\1\22\3\uffff\4\2\7\uffff\3\22\3\uffff\3\2"+
            "\4\uffff\1\2\1\uffff\17\22",
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
            return "705:3: ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) )";
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
                        if ( (((synpred63_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 18;}

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
        "\1\72\15\uffff";
    static final String DFA46_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA46_specialS =
        "\16\uffff}>";
    static final String[] DFA46_transitionS = {
            "\1\1\24\uffff\3\1\4\uffff\2\1\1\15\1\1\15\uffff\3\1\4\uffff"+
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
            return "711:64: ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' )";
        }
    }
    static final String DFA60_eotS =
        "\65\uffff";
    static final String DFA60_eofS =
        "\1\6\64\uffff";
    static final String DFA60_minS =
        "\1\6\5\0\57\uffff";
    static final String DFA60_maxS =
        "\1\72\5\0\57\uffff";
    static final String DFA60_acceptS =
        "\6\uffff\1\2\20\uffff\1\1\35\uffff";
    static final String DFA60_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\57\uffff}>";
    static final String[] DFA60_transitionS = {
            "\1\1\24\uffff\3\6\4\uffff\1\5\1\6\1\uffff\1\6\15\uffff\1\2\1"+
            "\3\1\4\4\uffff\1\6",
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
            return "787:3: ( ( typeMutator )* functionSignatureSuffix )?";
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
                        if ( ((synpred80_ObjCpp()&&( next("const", "__const") ))) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index60_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA60_2 = input.LA(1);

                         
                        int index60_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index60_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA60_3 = input.LA(1);

                         
                        int index60_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index60_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA60_4 = input.LA(1);

                         
                        int index60_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index60_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA60_5 = input.LA(1);

                         
                        int index60_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_ObjCpp()) ) {s = 23;}

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
        "\2\uffff\4\0\2\uffff\2\0\2\uffff\1\0\7\uffff\4\0\2\uffff\4\0\2\uffff"+
        "\1\0\7\uffff\4\0\2\uffff\2\0\2\uffff\4\0\3\uffff\1\0\2\uffff\2\0"+
        "\5\uffff";
    static final String DFA62_maxS =
        "\4\72\1\uffff\1\72\1\uffff\1\72\7\uffff\4\72\2\uffff\4\72\2\uffff"+
        "\2\72\2\uffff\4\0\2\uffff\2\0\2\uffff\1\0\7\uffff\4\0\2\uffff\4"+
        "\0\2\uffff\1\0\7\uffff\4\0\2\uffff\2\0\2\uffff\4\0\3\uffff\1\0\2"+
        "\uffff\2\0\5\uffff";
    static final String DFA62_acceptS =
        "\4\uffff\1\1\1\uffff\1\2\131\uffff";
    static final String DFA62_specialS =
        "\37\uffff\1\0\1\1\1\2\1\3\2\uffff\1\4\1\5\2\uffff\1\6\7\uffff\1"+
        "\7\1\10\1\11\1\12\2\uffff\1\13\1\14\1\15\1\16\2\uffff\1\17\7\uffff"+
        "\1\20\1\21\1\22\1\23\2\uffff\1\24\1\25\2\uffff\1\26\1\27\1\30\1"+
        "\31\3\uffff\1\32\2\uffff\1\33\1\34\5\uffff}>";
    static final String[] DFA62_transitionS = {
            "\1\1\33\uffff\1\5\20\uffff\1\2\1\3\1\4\4\uffff\1\6",
            "\1\6\24\uffff\3\6\4\uffff\1\6\20\uffff\1\7\2\6\4\uffff\1\6",
            "\1\20\33\uffff\1\17\20\uffff\1\21\1\22\1\4\4\uffff\1\6",
            "\1\25\33\uffff\1\27\20\uffff\1\26\1\30\1\4\4\uffff\1\6",
            "",
            "\1\33\33\uffff\1\6\20\uffff\1\34\1\6\5\uffff\1\6",
            "",
            "\1\40\33\uffff\1\37\20\uffff\1\41\1\42\1\4\4\uffff\1\6",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\45\33\uffff\1\6\20\uffff\1\46\1\6\5\uffff\1\6",
            "\1\6\24\uffff\3\6\4\uffff\1\6\20\uffff\1\51\2\6\4\uffff\1\6",
            "\1\62\33\uffff\1\61\20\uffff\1\63\1\64\1\4\4\uffff\1\6",
            "\1\67\33\uffff\1\71\20\uffff\1\70\1\72\1\4\4\uffff\1\6",
            "",
            "",
            "\1\6\24\uffff\3\6\4\uffff\1\6\20\uffff\1\75\2\6\4\uffff\1\6",
            "\1\106\33\uffff\1\105\20\uffff\1\107\1\110\1\4\4\uffff\1\6",
            "\1\113\33\uffff\1\6\20\uffff\1\114\1\6\5\uffff\1\6",
            "\1\117\33\uffff\1\121\20\uffff\1\120\1\122\1\4\4\uffff\1\6",
            "",
            "",
            "\1\131\26\uffff\1\6\4\uffff\1\126\1\6\17\uffff\1\132\2\6\4"+
            "\uffff\1\6",
            "\1\6\33\uffff\1\6\1\4\17\uffff\2\6\5\uffff\1\6",
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
            return "802:3: ( ( typeMutator )* functionSignatureSuffixNoName )?";
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
                        if ( ((synpred82_ObjCpp()&&( next("const", "__const") ))) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_31);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA62_32 = input.LA(1);

                         
                        int index62_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred82_ObjCpp()&&( next("const", "__const") ))) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_32);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA62_33 = input.LA(1);

                         
                        int index62_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred82_ObjCpp()&&( next("const", "__const") ))) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_33);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA62_34 = input.LA(1);

                         
                        int index62_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred82_ObjCpp()&&( next("const", "__const") ))) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_34);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA62_37 = input.LA(1);

                         
                        int index62_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_37);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA62_38 = input.LA(1);

                         
                        int index62_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_38);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA62_41 = input.LA(1);

                         
                        int index62_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_41);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA62_49 = input.LA(1);

                         
                        int index62_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_49);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA62_50 = input.LA(1);

                         
                        int index62_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_50);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA62_51 = input.LA(1);

                         
                        int index62_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_51);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA62_52 = input.LA(1);

                         
                        int index62_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_52);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA62_55 = input.LA(1);

                         
                        int index62_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_55);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA62_56 = input.LA(1);

                         
                        int index62_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_56);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA62_57 = input.LA(1);

                         
                        int index62_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_57);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA62_58 = input.LA(1);

                         
                        int index62_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_58);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA62_61 = input.LA(1);

                         
                        int index62_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_61);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA62_69 = input.LA(1);

                         
                        int index62_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_69);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA62_70 = input.LA(1);

                         
                        int index62_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_70);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA62_71 = input.LA(1);

                         
                        int index62_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_71);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA62_72 = input.LA(1);

                         
                        int index62_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_72);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA62_75 = input.LA(1);

                         
                        int index62_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_75);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA62_76 = input.LA(1);

                         
                        int index62_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_76);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA62_79 = input.LA(1);

                         
                        int index62_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_79);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA62_80 = input.LA(1);

                         
                        int index62_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_80);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA62_81 = input.LA(1);

                         
                        int index62_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_81);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA62_82 = input.LA(1);

                         
                        int index62_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_82);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA62_86 = input.LA(1);

                         
                        int index62_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_86);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA62_89 = input.LA(1);

                         
                        int index62_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_89);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA62_90 = input.LA(1);

                         
                        int index62_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index62_90);
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
        "\1\6\1\uffff\1\6\3\uffff\1\6\6\uffff\1\0\11\uffff";
    static final String DFA64_maxS =
        "\1\72\1\uffff\1\72\3\uffff\1\112\6\uffff\1\0\11\uffff";
    static final String DFA64_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\22\uffff";
    static final String DFA64_specialS =
        "\15\uffff\1\0\11\uffff}>";
    static final String[] DFA64_transitionS = {
            "\1\2\33\uffff\1\1\20\uffff\2\1\5\uffff\1\1",
            "",
            "\1\4\24\uffff\3\1\4\uffff\1\6\1\1\17\uffff\2\4\1\1\4\uffff"+
            "\1\4",
            "",
            "",
            "",
            "\1\15\27\uffff\1\1\3\uffff\1\4\1\1\10\uffff\4\1\3\uffff\2\4"+
            "\5\uffff\1\4\1\uffff\17\1",
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
            return "()* loopback of 823:3: ({...}? modifier )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA64_13 = input.LA(1);

                         
                        int index64_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred84_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 4;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index64_13);
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
            return "843:4: ( '=' expression )?";
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
                        if ( (synpred88_ObjCpp()) ) {s = 18;}

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
        "\1\112\2\uffff\1\0\21\uffff";
    static final String DFA68_acceptS =
        "\1\uffff\1\3\21\uffff\1\1\1\2";
    static final String DFA68_specialS =
        "\3\uffff\1\0\21\uffff}>";
    static final String[] DFA68_transitionS = {
            "\1\3\27\uffff\1\1\16\uffff\3\1\14\uffff\17\1",
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
            return "()* loopback of 885:4: ({...}?sm= modifier | {...}?tm= modifier )*";
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
                        if ( (((synpred90_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 19;}

                        else if ( (((synpred91_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 20;}

                        else if ( ((( "__success".equals(next()) )||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 1;}

                         
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
        "\1\72\1\0\11\uffff";
    static final String DFA73_acceptS =
        "\2\uffff\1\2\7\uffff\1\1";
    static final String DFA73_specialS =
        "\1\uffff\1\0\11\uffff}>";
    static final String[] DFA73_transitionS = {
            "\1\1\33\uffff\1\2\20\uffff\2\2\5\uffff\1\2",
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
            return "()* loopback of 975:4: (im= modifier )*";
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
                        if ( ((synpred97_ObjCpp()&&( Modifier.parseModifier(next()) != null ))) ) {s = 10;}

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
        "\1\131\15\uffff";
    static final String DFA75_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA75_specialS =
        "\16\uffff}>";
    static final String[] DFA75_transitionS = {
            "\7\1\14\uffff\1\1\12\uffff\1\1\22\uffff\1\1\1\15\24\uffff\1"+
            "\1\14\uffff\2\1",
            "",
            "",
            "",
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
            return "985:4: ( expression | )";
        }
    }
    static final String DFA77_eotS =
        "\14\uffff";
    static final String DFA77_eofS =
        "\14\uffff";
    static final String DFA77_minS =
        "\1\33\1\6\1\uffff\1\0\10\uffff";
    static final String DFA77_maxS =
        "\1\43\1\112\1\uffff\1\0\10\uffff";
    static final String DFA77_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\7\uffff";
    static final String DFA77_specialS =
        "\3\uffff\1\0\10\uffff}>";
    static final String[] DFA77_transitionS = {
            "\1\1\7\uffff\1\2",
            "\1\4\27\uffff\1\4\15\uffff\1\3\3\4\14\uffff\17\4",
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
            return "()* loopback of 1013:4: ( ',' ax= argDef )*";
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
                        if ( (synpred101_ObjCpp()) ) {s = 4;}

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
        "\1\6\2\uffff\2\0\4\uffff\1\0\1\uffff\1\0\45\uffff";
    static final String DFA80_maxS =
        "\1\72\2\uffff\2\0\4\uffff\1\0\1\uffff\1\0\45\uffff";
    static final String DFA80_acceptS =
        "\1\uffff\1\2\25\uffff\1\1\31\uffff";
    static final String DFA80_specialS =
        "\3\uffff\1\0\1\1\4\uffff\1\2\1\uffff\1\3\45\uffff}>";
    static final String[] DFA80_transitionS = {
            "\1\3\24\uffff\3\1\4\uffff\2\1\1\uffff\1\1\15\uffff\1\4\1\11"+
            "\1\13\4\uffff\1\1",
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
            return "()* loopback of 1034:3: ( typeMutator )*";
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
                        if ( ((synpred104_ObjCpp()&&( next("const", "__const") ))) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index80_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA80_4 = input.LA(1);

                         
                        int index80_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index80_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA80_9 = input.LA(1);

                         
                        int index80_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index80_9);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA80_11 = input.LA(1);

                         
                        int index80_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred104_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index80_11);
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
        "\1\100\1\6\17\uffff";
    static final String DFA83_maxS =
        "\2\112\17\uffff";
    static final String DFA83_acceptS =
        "\2\uffff\1\2\14\uffff\1\1\1\uffff";
    static final String DFA83_specialS =
        "\21\uffff}>";
    static final String[] DFA83_transitionS = {
            "\2\1\11\2",
            "\1\2\24\uffff\3\2\4\uffff\2\2\1\uffff\1\2\15\uffff\3\2\4\uffff"+
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
            return "1067:4: (mod2= primSizeModifier (mod3= primSizeModifier )? )?";
        }
    }
    static final String DFA82_eotS =
        "\20\uffff";
    static final String DFA82_eofS =
        "\1\uffff\1\2\16\uffff";
    static final String DFA82_minS =
        "\1\100\1\6\16\uffff";
    static final String DFA82_maxS =
        "\2\112\16\uffff";
    static final String DFA82_acceptS =
        "\2\uffff\1\2\1\1\14\uffff";
    static final String DFA82_specialS =
        "\20\uffff}>";
    static final String[] DFA82_transitionS = {
            "\2\1\11\2",
            "\1\2\24\uffff\3\2\4\uffff\2\2\1\uffff\1\2\15\uffff\3\2\4\uffff"+
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
            return "1068:8: (mod3= primSizeModifier )?";
        }
    }
    static final String DFA87_eotS =
        "\16\uffff";
    static final String DFA87_eofS =
        "\16\uffff";
    static final String DFA87_minS =
        "\1\4\15\uffff";
    static final String DFA87_maxS =
        "\1\131\15\uffff";
    static final String DFA87_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA87_specialS =
        "\16\uffff}>";
    static final String[] DFA87_transitionS = {
            "\7\1\14\uffff\1\1\12\uffff\1\1\1\15\21\uffff\1\1\25\uffff\1"+
            "\1\14\uffff\2\1",
            "",
            "",
            "",
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
            return "1137:3: (a1= expression ( ',' ax= expression )* )?";
        }
    }
    static final String DFA90_eotS =
        "\33\uffff";
    static final String DFA90_eofS =
        "\1\uffff\1\16\31\uffff";
    static final String DFA90_minS =
        "\1\4\1\6\31\uffff";
    static final String DFA90_maxS =
        "\1\131\1\133\31\uffff";
    static final String DFA90_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\5\uffff\1\7\1\uffff\1\1\14\uffff";
    static final String DFA90_specialS =
        "\33\uffff}>";
    static final String[] DFA90_transitionS = {
            "\2\6\1\1\4\6\14\uffff\1\14\12\uffff\1\5\22\uffff\1\3\25\uffff"+
            "\1\2\14\uffff\2\4",
            "\1\16\21\uffff\1\16\2\uffff\3\16\3\uffff\1\16\1\2\3\16\4\uffff"+
            "\2\16\7\uffff\2\16\1\uffff\1\16\3\uffff\1\16\21\uffff\14\16"+
            "\2\uffff\2\16",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "1155:4: (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' )";
        }
    }
    static final String DFA89_eotS =
        "\173\uffff";
    static final String DFA89_eofS =
        "\37\uffff\1\2\133\uffff";
    static final String DFA89_minS =
        "\1\4\1\6\20\uffff\1\4\12\uffff\1\4\1\uffff\3\4\3\uffff\14\0\3\uffff"+
        "\1\0\2\uffff\1\0\2\uffff\1\0\7\uffff\1\0\27\uffff\1\0\1\uffff\1"+
        "\0\1\uffff\1\0\14\uffff\1\0\17\uffff";
    static final String DFA89_maxS =
        "\1\131\1\133\20\uffff\1\131\12\uffff\1\131\1\uffff\1\133\2\131\3"+
        "\uffff\14\0\3\uffff\1\0\2\uffff\1\0\2\uffff\1\0\7\uffff\1\0\27\uffff"+
        "\1\0\1\uffff\1\0\1\uffff\1\0\14\uffff\1\0\17\uffff";
    static final String DFA89_acceptS =
        "\2\uffff\1\1\12\uffff\1\2\155\uffff";
    static final String DFA89_specialS =
        "\45\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\3"+
        "\uffff\1\14\2\uffff\1\15\2\uffff\1\16\7\uffff\1\17\27\uffff\1\20"+
        "\1\uffff\1\21\1\uffff\1\22\14\uffff\1\23\17\uffff}>";
    static final String[] DFA89_transitionS = {
            "\2\2\1\1\4\2\14\uffff\1\2\6\uffff\1\15\3\uffff\1\2\12\uffff"+
            "\3\15\5\uffff\1\2\6\uffff\17\15\1\2\14\uffff\2\2",
            "\1\15\26\uffff\1\2\1\15\2\uffff\1\2\1\22\1\37\1\41\1\2\4\uffff"+
            "\2\2\1\uffff\3\15\3\uffff\1\35\1\40\1\15\4\uffff\1\2\1\uffff"+
            "\17\15\1\uffff\14\2\2\uffff\2\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\52\1\57\1\45\1\53\1\54\1\55\1\56\14\uffff\1\60\12\uffff"+
            "\1\51\1\2\17\uffff\1\15\1\uffff\1\47\1\uffff\1\15\23\uffff\1"+
            "\46\14\uffff\2\50",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\2\2\1\64\4\2\14\uffff\1\2\12\uffff\1\72\1\15\17\uffff\2\15"+
            "\1\67\25\uffff\1\2\14\uffff\2\2",
            "",
            "\2\15\1\102\4\15\14\uffff\1\15\1\2\2\uffff\3\2\3\uffff\1\2"+
            "\1\15\3\2\4\uffff\2\2\7\uffff\2\2\1\15\1\2\3\uffff\1\2\20\uffff"+
            "\1\15\14\2\2\15\2\2",
            "\2\2\1\132\4\2\14\uffff\1\2\12\uffff\1\136\1\15\17\uffff\2"+
            "\15\1\134\25\uffff\1\2\14\uffff\2\2",
            "\2\2\1\153\4\2\14\uffff\1\2\6\uffff\1\15\3\uffff\1\2\2\uffff"+
            "\1\15\7\uffff\3\15\5\uffff\1\2\6\uffff\17\15\1\2\14\uffff\2"+
            "\2",
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
            return "1168:8: (par= expression ')' | typeRef ')' casted= expression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA89_37 = input.LA(1);

                         
                        int index89_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 13;}

                         
                        input.seek(index89_37);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA89_38 = input.LA(1);

                         
                        int index89_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index89_38);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA89_39 = input.LA(1);

                         
                        int index89_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index89_39);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA89_40 = input.LA(1);

                         
                        int index89_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index89_40);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA89_41 = input.LA(1);

                         
                        int index89_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index89_41);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA89_42 = input.LA(1);

                         
                        int index89_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index89_42);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA89_43 = input.LA(1);

                         
                        int index89_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index89_43);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA89_44 = input.LA(1);

                         
                        int index89_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index89_44);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA89_45 = input.LA(1);

                         
                        int index89_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index89_45);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA89_46 = input.LA(1);

                         
                        int index89_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index89_46);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA89_47 = input.LA(1);

                         
                        int index89_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index89_47);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA89_48 = input.LA(1);

                         
                        int index89_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index89_48);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA89_52 = input.LA(1);

                         
                        int index89_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index89_52);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA89_55 = input.LA(1);

                         
                        int index89_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index89_55);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA89_58 = input.LA(1);

                         
                        int index89_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index89_58);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA89_66 = input.LA(1);

                         
                        int index89_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index89_66);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA89_90 = input.LA(1);

                         
                        int index89_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index89_90);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA89_92 = input.LA(1);

                         
                        int index89_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index89_92);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA89_94 = input.LA(1);

                         
                        int index89_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index89_94);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA89_107 = input.LA(1);

                         
                        int index89_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index89_107);
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
        "\1\133\5\uffff\1\0\2\uffff\5\0\130\uffff";
    static final String DFA92_acceptS =
        "\1\uffff\1\6\30\uffff\1\2\15\uffff\1\1\1\4\2\uffff\1\3\70\uffff"+
        "\1\5";
    static final String DFA92_specialS =
        "\6\uffff\1\0\2\uffff\1\1\1\2\1\3\1\4\1\5\130\uffff}>";
    static final String[] DFA92_transitionS = {
            "\1\1\21\uffff\1\1\2\uffff\2\1\1\6\3\uffff\1\13\1\uffff\1\1\2"+
            "\14\4\uffff\1\14\1\11\7\uffff\2\14\1\uffff\1\1\3\uffff\1\14"+
            "\21\uffff\14\14\2\uffff\1\12\1\15",
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
            return "()* loopback of 1181:3: (bop= binaryOp opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )*";
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
                        if ( (synpred154_ObjCpp()) ) {s = 26;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index92_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA92_9 = input.LA(1);

                         
                        int index92_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred153_ObjCpp()) ) {s = 40;}

                        else if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index92_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA92_10 = input.LA(1);

                         
                        int index92_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 44;}

                        else if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index92_10);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA92_11 = input.LA(1);

                         
                        int index92_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 41;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index92_11);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA92_12 = input.LA(1);

                         
                        int index92_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred153_ObjCpp()) ) {s = 40;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index92_12);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA92_13 = input.LA(1);

                         
                        int index92_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 101;}

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
            "\2\12\uffff\3\2\5\uffff\1\2\1\uffff\1\2\3\uffff\21\2\14\uffff"+
            "\2\2\2\uffff\1\2\1\uffff\4\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "()* loopback of 1207:8: ( statement )*";
        }
    }
    static final String DFA100_eotS =
        "\u012c\uffff";
    static final String DFA100_eofS =
        "\u012c\uffff";
    static final String DFA100_minS =
        "\2\4\2\uffff\1\6\30\uffff\1\4\2\uffff\1\6\7\uffff\1\42\3\4\6\30"+
        "\10\uffff\1\4\12\uffff\1\4\2\uffff\2\4\1\uffff\1\4\1\uffff\14\0"+
        "\21\uffff\1\0\1\uffff\2\0\1\uffff\2\0\5\uffff\6\0\2\uffff\60\0\2"+
        "\uffff\6\0\2\uffff\6\0\2\uffff\6\0\2\uffff\6\0\2\uffff\6\0\3\uffff"+
        "\7\0\1\uffff\13\0\2\uffff\1\0\1\uffff\1\0\2\uffff\1\0\11\uffff\1"+
        "\0\1\uffff\1\0\2\uffff\1\0\13\uffff\1\0\17\uffff\1\0\1\uffff\1\0"+
        "\13\uffff";
    static final String DFA100_maxS =
        "\2\141\2\uffff\1\133\30\uffff\1\141\2\uffff\1\133\7\uffff\1\42\3"+
        "\131\6\133\10\uffff\1\131\12\uffff\1\131\2\uffff\2\131\1\uffff\1"+
        "\131\1\uffff\14\0\21\uffff\1\0\1\uffff\2\0\1\uffff\2\0\5\uffff\6"+
        "\0\2\uffff\60\0\2\uffff\6\0\2\uffff\6\0\2\uffff\6\0\2\uffff\6\0"+
        "\2\uffff\6\0\3\uffff\7\0\1\uffff\13\0\2\uffff\1\0\1\uffff\1\0\2"+
        "\uffff\1\0\11\uffff\1\0\1\uffff\1\0\2\uffff\1\0\13\uffff\1\0\17"+
        "\uffff\1\0\1\uffff\1\0\13\uffff";
    static final String DFA100_acceptS =
        "\2\uffff\1\2\11\uffff\1\3\11\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
        "\1\uffff\1\1\u010c\uffff\1\13";
    static final String DFA100_specialS =
        "\115\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\21"+
        "\uffff\1\14\1\uffff\1\15\1\16\1\uffff\1\17\1\20\5\uffff\1\21\1\22"+
        "\1\23\1\24\1\25\1\26\2\uffff\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
        "\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52"+
        "\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67"+
        "\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103"+
        "\1\104\1\105\1\106\2\uffff\1\107\1\110\1\111\1\112\1\113\1\114\2"+
        "\uffff\1\115\1\116\1\117\1\120\1\121\1\122\2\uffff\1\123\1\124\1"+
        "\125\1\126\1\127\1\130\2\uffff\1\131\1\132\1\133\1\134\1\135\1\136"+
        "\2\uffff\1\137\1\140\1\141\1\142\1\143\1\144\3\uffff\1\145\1\146"+
        "\1\147\1\150\1\151\1\152\1\153\1\uffff\1\154\1\155\1\156\1\157\1"+
        "\160\1\161\1\162\1\163\1\164\1\165\1\166\2\uffff\1\167\1\uffff\1"+
        "\170\2\uffff\1\171\11\uffff\1\172\1\uffff\1\173\2\uffff\1\174\13"+
        "\uffff\1\175\17\uffff\1\176\1\uffff\1\177\13\uffff}>";
    static final String[] DFA100_transitionS = {
            "\2\14\1\4\4\14\14\uffff\1\1\1\uffff\2\2\1\uffff\1\34\1\uffff"+
            "\3\2\1\uffff\1\14\12\uffff\3\2\5\uffff\1\14\1\uffff\1\26\3\uffff"+
            "\20\2\1\14\14\uffff\2\14\2\uffff\1\27\1\uffff\1\30\1\31\1\32"+
            "\1\33",
            "\1\54\1\61\1\40\1\55\1\56\1\57\1\60\14\uffff\1\35\3\36\1\uffff"+
            "\1\36\1\uffff\3\36\1\uffff\1\53\12\uffff\3\36\5\uffff\1\51\1"+
            "\uffff\1\36\3\uffff\20\36\1\50\14\uffff\2\52\2\uffff\1\36\1"+
            "\uffff\4\36",
            "",
            "",
            "\1\2\25\uffff\2\14\1\2\2\uffff\1\14\1\72\1\uffff\1\111\1\14"+
            "\4\uffff\2\14\1\uffff\3\2\3\uffff\1\105\1\110\1\2\4\uffff\1"+
            "\113\1\uffff\17\2\1\uffff\14\14\2\uffff\2\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\122\1\127\1\115\1\123\1\124\1\125\1\126\14\uffff\1\130\3"+
            "\36\1\uffff\1\36\1\uffff\3\36\1\uffff\1\121\12\uffff\3\36\5"+
            "\uffff\1\117\1\uffff\1\36\3\uffff\20\36\1\116\14\uffff\2\120"+
            "\2\uffff\1\36\1\uffff\4\36",
            "",
            "",
            "\1\36\21\uffff\1\14\3\uffff\1\36\1\167\1\36\2\uffff\1\171\1"+
            "\152\1\uffff\1\160\1\172\4\uffff\1\172\1\166\1\uffff\3\36\3"+
            "\uffff\1\154\1\155\1\36\4\uffff\1\157\1\uffff\17\36\1\uffff"+
            "\14\172\2\uffff\1\170\1\173",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\176",
            "\1\u0084\1\u0089\1\177\1\u0085\1\u0086\1\u0087\1\u0088\14\uffff"+
            "\1\u008a\12\uffff\1\u0083\22\uffff\1\u0081\25\uffff\1\u0080"+
            "\14\uffff\2\u0082",
            "\1\u0090\1\u0095\1\u008b\1\u0091\1\u0092\1\u0093\1\u0094\14"+
            "\uffff\1\u0096\12\uffff\1\u008f\22\uffff\1\u008d\25\uffff\1"+
            "\u008c\14\uffff\2\u008e",
            "\1\u009c\1\u00a1\1\u0097\1\u009d\1\u009e\1\u009f\1\u00a0\14"+
            "\uffff\1\u00a2\6\uffff\1\u00a4\3\uffff\1\u009b\12\uffff\3\u00a3"+
            "\5\uffff\1\u0099\6\uffff\4\u00a5\2\u00a6\11\u00a7\1\u0098\14"+
            "\uffff\2\u009a",
            "\1\14\3\uffff\1\36\1\u00a9\3\uffff\1\u00ab\2\uffff\2\u00ac"+
            "\4\uffff\1\u00ac\1\u00a8\7\uffff\2\u00ac\5\uffff\1\u00ac\21"+
            "\uffff\14\u00ac\2\uffff\1\u00aa\1\u00ad",
            "\1\14\3\uffff\1\36\1\u00b1\3\uffff\1\u00b3\2\uffff\2\u00b4"+
            "\4\uffff\1\u00b4\1\u00b0\7\uffff\2\u00b4\5\uffff\1\u00b4\21"+
            "\uffff\14\u00b4\2\uffff\1\u00b2\1\u00b5",
            "\1\14\3\uffff\1\36\1\u00b9\3\uffff\1\u00bb\2\uffff\2\u00bc"+
            "\4\uffff\1\u00bc\1\u00b8\7\uffff\2\u00bc\5\uffff\1\u00bc\21"+
            "\uffff\14\u00bc\2\uffff\1\u00ba\1\u00bd",
            "\1\14\3\uffff\1\36\1\u00c1\3\uffff\1\u00c3\2\uffff\2\u00c4"+
            "\4\uffff\1\u00c4\1\u00c0\7\uffff\2\u00c4\5\uffff\1\u00c4\21"+
            "\uffff\14\u00c4\2\uffff\1\u00c2\1\u00c5",
            "\1\14\3\uffff\1\36\1\u00c9\3\uffff\1\u00cb\2\uffff\2\u00cc"+
            "\4\uffff\1\u00cc\1\u00c8\7\uffff\2\u00cc\5\uffff\1\u00cc\21"+
            "\uffff\14\u00cc\2\uffff\1\u00ca\1\u00cd",
            "\1\14\3\uffff\1\36\1\u00d1\3\uffff\1\u00d3\2\uffff\2\u00d4"+
            "\4\uffff\1\u00d4\1\u00d0\7\uffff\2\u00d4\5\uffff\1\u00d4\21"+
            "\uffff\14\u00d4\2\uffff\1\u00d2\1\u00d5",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00e5\1\u00ea\1\u00d9\1\u00e6\1\u00e7\1\u00e8\1\u00e9\14"+
            "\uffff\1\u00eb\6\uffff\1\u00dc\3\uffff\1\u00e4\1\u00da\10\uffff"+
            "\1\2\3\u00db\3\uffff\2\2\1\u00e2\1\uffff\1\2\2\uffff\1\2\1\uffff"+
            "\4\u00dd\2\u00de\11\u00df\1\u00e1\14\uffff\2\u00e3",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\2\14\1\u00ee\4\14\14\uffff\1\14\12\uffff\1\u00f0\20\uffff"+
            "\2\2\1\u00f3\4\uffff\1\2\20\uffff\1\14\14\uffff\2\14",
            "",
            "",
            "\2\14\1\u00fd\4\14\14\uffff\1\14\12\uffff\1\u00ff\20\uffff"+
            "\2\2\1\u0102\4\uffff\1\2\20\uffff\1\14\14\uffff\2\14",
            "\2\14\1\u010e\4\14\14\uffff\1\14\6\uffff\1\2\3\uffff\1\14\2"+
            "\uffff\1\2\7\uffff\3\2\5\uffff\1\14\6\uffff\17\2\1\14\14\uffff"+
            "\2\14",
            "",
            "\2\14\1\u011e\4\14\14\uffff\1\14\12\uffff\1\u0120\20\uffff"+
            "\2\2\1\14\4\uffff\1\2\20\uffff\1\14\14\uffff\2\14",
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
            "",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            "\1\uffff",
            "\1\uffff",
            "",
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
            "",
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
            return "1209:1: statement : ( statementsBlock | declaration | expression ( '=' expression )? ';' | 'return' expression ';' | 'if' '(' expression ')' statement ( 'else' statement )? | 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement );";
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
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_77);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA100_78 = input.LA(1);

                         
                        int index100_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_78);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA100_79 = input.LA(1);

                         
                        int index100_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_79);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA100_80 = input.LA(1);

                         
                        int index100_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_80);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA100_81 = input.LA(1);

                         
                        int index100_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_81);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA100_82 = input.LA(1);

                         
                        int index100_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_82);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA100_83 = input.LA(1);

                         
                        int index100_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_83);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA100_84 = input.LA(1);

                         
                        int index100_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_84);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA100_85 = input.LA(1);

                         
                        int index100_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_85);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA100_86 = input.LA(1);

                         
                        int index100_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_86);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA100_87 = input.LA(1);

                         
                        int index100_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_87);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA100_88 = input.LA(1);

                         
                        int index100_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_88);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA100_106 = input.LA(1);

                         
                        int index100_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_106);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA100_108 = input.LA(1);

                         
                        int index100_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_108);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA100_109 = input.LA(1);

                         
                        int index100_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_109);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA100_111 = input.LA(1);

                         
                        int index100_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_111);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA100_112 = input.LA(1);

                         
                        int index100_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_112);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA100_118 = input.LA(1);

                         
                        int index100_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_118);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA100_119 = input.LA(1);

                         
                        int index100_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_119);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA100_120 = input.LA(1);

                         
                        int index100_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_120);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA100_121 = input.LA(1);

                         
                        int index100_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_121);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA100_122 = input.LA(1);

                         
                        int index100_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_122);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA100_123 = input.LA(1);

                         
                        int index100_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_123);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA100_126 = input.LA(1);

                         
                        int index100_126 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_126);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA100_127 = input.LA(1);

                         
                        int index100_127 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_127);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA100_128 = input.LA(1);

                         
                        int index100_128 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_128);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA100_129 = input.LA(1);

                         
                        int index100_129 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_129);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA100_130 = input.LA(1);

                         
                        int index100_130 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_130);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA100_131 = input.LA(1);

                         
                        int index100_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_131);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA100_132 = input.LA(1);

                         
                        int index100_132 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_132);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA100_133 = input.LA(1);

                         
                        int index100_133 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_133);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA100_134 = input.LA(1);

                         
                        int index100_134 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_134);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA100_135 = input.LA(1);

                         
                        int index100_135 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_135);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA100_136 = input.LA(1);

                         
                        int index100_136 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_136);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA100_137 = input.LA(1);

                         
                        int index100_137 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_137);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA100_138 = input.LA(1);

                         
                        int index100_138 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_138);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA100_139 = input.LA(1);

                         
                        int index100_139 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_139);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA100_140 = input.LA(1);

                         
                        int index100_140 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_140);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA100_141 = input.LA(1);

                         
                        int index100_141 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_141);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA100_142 = input.LA(1);

                         
                        int index100_142 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_142);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA100_143 = input.LA(1);

                         
                        int index100_143 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_143);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA100_144 = input.LA(1);

                         
                        int index100_144 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_144);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA100_145 = input.LA(1);

                         
                        int index100_145 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_145);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA100_146 = input.LA(1);

                         
                        int index100_146 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_146);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA100_147 = input.LA(1);

                         
                        int index100_147 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_147);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA100_148 = input.LA(1);

                         
                        int index100_148 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_148);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA100_149 = input.LA(1);

                         
                        int index100_149 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_149);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA100_150 = input.LA(1);

                         
                        int index100_150 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_150);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA100_151 = input.LA(1);

                         
                        int index100_151 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_151);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA100_152 = input.LA(1);

                         
                        int index100_152 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_152);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA100_153 = input.LA(1);

                         
                        int index100_153 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_153);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA100_154 = input.LA(1);

                         
                        int index100_154 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_154);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA100_155 = input.LA(1);

                         
                        int index100_155 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_155);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA100_156 = input.LA(1);

                         
                        int index100_156 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_156);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA100_157 = input.LA(1);

                         
                        int index100_157 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_157);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA100_158 = input.LA(1);

                         
                        int index100_158 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_158);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA100_159 = input.LA(1);

                         
                        int index100_159 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_159);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA100_160 = input.LA(1);

                         
                        int index100_160 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_160);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA100_161 = input.LA(1);

                         
                        int index100_161 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_161);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA100_162 = input.LA(1);

                         
                        int index100_162 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_162);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA100_163 = input.LA(1);

                         
                        int index100_163 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_163);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA100_164 = input.LA(1);

                         
                        int index100_164 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_164);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA100_165 = input.LA(1);

                         
                        int index100_165 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_165);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA100_166 = input.LA(1);

                         
                        int index100_166 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_166);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA100_167 = input.LA(1);

                         
                        int index100_167 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_167);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA100_168 = input.LA(1);

                         
                        int index100_168 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_168);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA100_169 = input.LA(1);

                         
                        int index100_169 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_169);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA100_170 = input.LA(1);

                         
                        int index100_170 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_170);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA100_171 = input.LA(1);

                         
                        int index100_171 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_171);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA100_172 = input.LA(1);

                         
                        int index100_172 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_172);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA100_173 = input.LA(1);

                         
                        int index100_173 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_173);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA100_176 = input.LA(1);

                         
                        int index100_176 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_176);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA100_177 = input.LA(1);

                         
                        int index100_177 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_177);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA100_178 = input.LA(1);

                         
                        int index100_178 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_178);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA100_179 = input.LA(1);

                         
                        int index100_179 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_179);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA100_180 = input.LA(1);

                         
                        int index100_180 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_180);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA100_181 = input.LA(1);

                         
                        int index100_181 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_181);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA100_184 = input.LA(1);

                         
                        int index100_184 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_184);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA100_185 = input.LA(1);

                         
                        int index100_185 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_185);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA100_186 = input.LA(1);

                         
                        int index100_186 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_186);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA100_187 = input.LA(1);

                         
                        int index100_187 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_187);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA100_188 = input.LA(1);

                         
                        int index100_188 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_188);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA100_189 = input.LA(1);

                         
                        int index100_189 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_189);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA100_192 = input.LA(1);

                         
                        int index100_192 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_192);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA100_193 = input.LA(1);

                         
                        int index100_193 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_193);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA100_194 = input.LA(1);

                         
                        int index100_194 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_194);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA100_195 = input.LA(1);

                         
                        int index100_195 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_195);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA100_196 = input.LA(1);

                         
                        int index100_196 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_196);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA100_197 = input.LA(1);

                         
                        int index100_197 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_197);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA100_200 = input.LA(1);

                         
                        int index100_200 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_200);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA100_201 = input.LA(1);

                         
                        int index100_201 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_201);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA100_202 = input.LA(1);

                         
                        int index100_202 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_202);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA100_203 = input.LA(1);

                         
                        int index100_203 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_203);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA100_204 = input.LA(1);

                         
                        int index100_204 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_204);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA100_205 = input.LA(1);

                         
                        int index100_205 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_205);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA100_208 = input.LA(1);

                         
                        int index100_208 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_208);
                        if ( s>=0 ) return s;
                        break;
                    case 96 : 
                        int LA100_209 = input.LA(1);

                         
                        int index100_209 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_209);
                        if ( s>=0 ) return s;
                        break;
                    case 97 : 
                        int LA100_210 = input.LA(1);

                         
                        int index100_210 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_210);
                        if ( s>=0 ) return s;
                        break;
                    case 98 : 
                        int LA100_211 = input.LA(1);

                         
                        int index100_211 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_211);
                        if ( s>=0 ) return s;
                        break;
                    case 99 : 
                        int LA100_212 = input.LA(1);

                         
                        int index100_212 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_212);
                        if ( s>=0 ) return s;
                        break;
                    case 100 : 
                        int LA100_213 = input.LA(1);

                         
                        int index100_213 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 30;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_213);
                        if ( s>=0 ) return s;
                        break;
                    case 101 : 
                        int LA100_217 = input.LA(1);

                         
                        int index100_217 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                        else if ( (( next("foreach") )) ) {s = 299;}

                         
                        input.seek(index100_217);
                        if ( s>=0 ) return s;
                        break;
                    case 102 : 
                        int LA100_218 = input.LA(1);

                         
                        int index100_218 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_218);
                        if ( s>=0 ) return s;
                        break;
                    case 103 : 
                        int LA100_219 = input.LA(1);

                         
                        int index100_219 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 299;}

                         
                        input.seek(index100_219);
                        if ( s>=0 ) return s;
                        break;
                    case 104 : 
                        int LA100_220 = input.LA(1);

                         
                        int index100_220 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 299;}

                         
                        input.seek(index100_220);
                        if ( s>=0 ) return s;
                        break;
                    case 105 : 
                        int LA100_221 = input.LA(1);

                         
                        int index100_221 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 299;}

                         
                        input.seek(index100_221);
                        if ( s>=0 ) return s;
                        break;
                    case 106 : 
                        int LA100_222 = input.LA(1);

                         
                        int index100_222 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 299;}

                         
                        input.seek(index100_222);
                        if ( s>=0 ) return s;
                        break;
                    case 107 : 
                        int LA100_223 = input.LA(1);

                         
                        int index100_223 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 299;}

                         
                        input.seek(index100_223);
                        if ( s>=0 ) return s;
                        break;
                    case 108 : 
                        int LA100_225 = input.LA(1);

                         
                        int index100_225 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_225);
                        if ( s>=0 ) return s;
                        break;
                    case 109 : 
                        int LA100_226 = input.LA(1);

                         
                        int index100_226 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_226);
                        if ( s>=0 ) return s;
                        break;
                    case 110 : 
                        int LA100_227 = input.LA(1);

                         
                        int index100_227 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_227);
                        if ( s>=0 ) return s;
                        break;
                    case 111 : 
                        int LA100_228 = input.LA(1);

                         
                        int index100_228 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_228);
                        if ( s>=0 ) return s;
                        break;
                    case 112 : 
                        int LA100_229 = input.LA(1);

                         
                        int index100_229 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_229);
                        if ( s>=0 ) return s;
                        break;
                    case 113 : 
                        int LA100_230 = input.LA(1);

                         
                        int index100_230 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_230);
                        if ( s>=0 ) return s;
                        break;
                    case 114 : 
                        int LA100_231 = input.LA(1);

                         
                        int index100_231 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_231);
                        if ( s>=0 ) return s;
                        break;
                    case 115 : 
                        int LA100_232 = input.LA(1);

                         
                        int index100_232 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_232);
                        if ( s>=0 ) return s;
                        break;
                    case 116 : 
                        int LA100_233 = input.LA(1);

                         
                        int index100_233 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_233);
                        if ( s>=0 ) return s;
                        break;
                    case 117 : 
                        int LA100_234 = input.LA(1);

                         
                        int index100_234 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_234);
                        if ( s>=0 ) return s;
                        break;
                    case 118 : 
                        int LA100_235 = input.LA(1);

                         
                        int index100_235 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_235);
                        if ( s>=0 ) return s;
                        break;
                    case 119 : 
                        int LA100_238 = input.LA(1);

                         
                        int index100_238 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_238);
                        if ( s>=0 ) return s;
                        break;
                    case 120 : 
                        int LA100_240 = input.LA(1);

                         
                        int index100_240 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_240);
                        if ( s>=0 ) return s;
                        break;
                    case 121 : 
                        int LA100_243 = input.LA(1);

                         
                        int index100_243 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_243);
                        if ( s>=0 ) return s;
                        break;
                    case 122 : 
                        int LA100_253 = input.LA(1);

                         
                        int index100_253 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_253);
                        if ( s>=0 ) return s;
                        break;
                    case 123 : 
                        int LA100_255 = input.LA(1);

                         
                        int index100_255 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_255);
                        if ( s>=0 ) return s;
                        break;
                    case 124 : 
                        int LA100_258 = input.LA(1);

                         
                        int index100_258 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_258);
                        if ( s>=0 ) return s;
                        break;
                    case 125 : 
                        int LA100_270 = input.LA(1);

                         
                        int index100_270 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_270);
                        if ( s>=0 ) return s;
                        break;
                    case 126 : 
                        int LA100_286 = input.LA(1);

                         
                        int index100_286 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_286);
                        if ( s>=0 ) return s;
                        break;
                    case 127 : 
                        int LA100_288 = input.LA(1);

                         
                        int index100_288 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred162_ObjCpp()) ) {s = 2;}

                        else if ( (synpred164_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index100_288);
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
            "\3\2\5\uffff\1\2\1\uffff\1\2\3\uffff\21\2\14\uffff\2\2\2\uffff"+
            "\1\2\1\1\5\2",
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
            return "1215:37: ( 'else' statement )?";
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
                        if ( (synpred166_ObjCpp()) ) {s = 62;}

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
        "\1\4\33\uffff\1\4\14\uffff\1\4\15\0\20\uffff";
    static final String DFA96_maxS =
        "\1\141\33\uffff\1\131\14\uffff\1\141\15\0\20\uffff";
    static final String DFA96_acceptS =
        "\1\uffff\1\1\33\uffff\1\2\51\uffff";
    static final String DFA96_specialS =
        "\52\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\20\uffff}>";
    static final String[] DFA96_transitionS = {
            "\7\1\14\uffff\1\1\1\uffff\2\1\1\uffff\1\34\1\uffff\3\1\1\uffff"+
            "\1\1\12\uffff\3\1\5\uffff\1\1\1\uffff\1\1\3\uffff\21\1\14\uffff"+
            "\2\1\2\uffff\1\1\1\uffff\4\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            "\25\uffff\1\35\14\uffff\2\35",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\57\1\64\1\52\1\60\1\61\1\62\1\63\14\uffff\1\65\1\uffff\2"+
            "\35\1\uffff\1\66\1\uffff\3\35\1\uffff\1\56\1\35\11\uffff\3\35"+
            "\5\uffff\1\54\1\uffff\1\35\3\uffff\20\35\1\53\14\uffff\2\55"+
            "\2\uffff\1\35\1\uffff\4\35",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            return "1218:13: ( statement )?";
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
                        if ( (synpred170_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_42);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA96_43 = input.LA(1);

                         
                        int index96_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred170_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_43);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA96_44 = input.LA(1);

                         
                        int index96_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred170_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_44);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA96_45 = input.LA(1);

                         
                        int index96_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred170_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_45);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA96_46 = input.LA(1);

                         
                        int index96_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred170_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_46);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA96_47 = input.LA(1);

                         
                        int index96_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred170_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_47);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA96_48 = input.LA(1);

                         
                        int index96_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred170_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_48);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA96_49 = input.LA(1);

                         
                        int index96_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred170_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_49);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA96_50 = input.LA(1);

                         
                        int index96_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred170_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_50);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA96_51 = input.LA(1);

                         
                        int index96_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred170_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_51);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA96_52 = input.LA(1);

                         
                        int index96_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred170_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_52);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA96_53 = input.LA(1);

                         
                        int index96_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred170_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_53);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA96_54 = input.LA(1);

                         
                        int index96_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred170_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index96_54);
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
        "\1\131\15\uffff";
    static final String DFA97_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA97_specialS =
        "\16\uffff}>";
    static final String[] DFA97_transitionS = {
            "\7\1\14\uffff\1\1\4\uffff\1\15\5\uffff\1\1\22\uffff\1\1\25\uffff"+
            "\1\1\14\uffff\2\1",
            "",
            "",
            "",
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
            return "1218:28: ( expression )?";
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
            "\1\1\1\35\11\uffff\3\1\5\uffff\1\1\1\uffff\1\1\3\uffff\21\1"+
            "\14\uffff\2\1\2\uffff\1\1\1\uffff\4\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "1218:44: ( statement )?";
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
            "\3\12\uffff\3\3\5\uffff\1\3\1\uffff\1\3\3\uffff\21\3\14\uffff"+
            "\2\3\2\uffff\1\3\1\uffff\4\3\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "()* loopback of 1220:3: ( 'case' expression ':' | statement )*";
        }
    }
 

    public static final BitSet FOLLOW_22_in_lineDirective65 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_lineDirective69 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_STRING_in_lineDirective82 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_lineDirective97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_sourceFile126 = new BitSet(new long[]{0xF800E001C6400040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_lineDirective_in_sourceFile135 = new BitSet(new long[]{0xF800E001C6400040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_EOF_in_sourceFile148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_externDeclarations169 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_externDeclarations173 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_externDeclarations178 = new BitSet(new long[]{0xF800E001C7000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_declaration_in_externDeclarations192 = new BitSet(new long[]{0xF800E001C7000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_24_in_externDeclarations205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_declaration249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_declaration259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objCClassDef_in_declaration269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeDef_in_declaration279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forwardClassDecl_in_declaration289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_declaration299 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration303 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_declaration305 = new BitSet(new long[]{0xF800E001C7000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_declaration_in_declaration323 = new BitSet(new long[]{0xF800E001C7000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_24_in_declaration339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_forwardClassDecl379 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_forwardClassDecl386 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_forwardClassDecl393 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_forwardClassDecl400 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_28_in_forwardClassDecl411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRef_in_functionPointerVarDecl429 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_functionPointerVarDecl437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enumItem455 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_enumItem458 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_enumItem462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_enumCore486 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enumCore497 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_enumCore509 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_enumItem_in_enumCore516 = new BitSet(new long[]{0x0000000009000000L});
    public static final BitSet FOLLOW_27_in_enumCore529 = new BitSet(new long[]{0x0000000009000040L});
    public static final BitSet FOLLOW_enumItem_in_enumCore539 = new BitSet(new long[]{0x0000000009000000L});
    public static final BitSet FOLLOW_24_in_enumCore553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_objCClassDef580 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef591 = new BitSet(new long[]{0xF800EE1640800040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_33_in_objCClassDef609 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef613 = new BitSet(new long[]{0xF800EE1040800040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_34_in_objCClassDef628 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef632 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCClassDef634 = new BitSet(new long[]{0xF800EE1040800040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_36_in_objCClassDef650 = new BitSet(new long[]{0x0000002000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef660 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_27_in_objCClassDef675 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef685 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_37_in_objCClassDef702 = new BitSet(new long[]{0xF800EE0040800040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_23_in_objCClassDef716 = new BitSet(new long[]{0xF000E1C041000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_38_in_objCClassDef728 = new BitSet(new long[]{0xF000E1C041000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_39_in_objCClassDef739 = new BitSet(new long[]{0xF000E1C041000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_40_in_objCClassDef750 = new BitSet(new long[]{0xF000E1C041000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_varDecl_in_objCClassDef777 = new BitSet(new long[]{0xF000E1C041000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_functionPointerVarDecl_in_objCClassDef789 = new BitSet(new long[]{0xF000E1C041000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_24_in_objCClassDef816 = new BitSet(new long[]{0xF800EE0040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_objCMethodDecl_in_objCClassDef834 = new BitSet(new long[]{0xF800EE0040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeDef_in_objCClassDef843 = new BitSet(new long[]{0xF800EE0040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_varDecl_in_objCClassDef854 = new BitSet(new long[]{0xF800EE0040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_41_in_objCClassDef867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_objCMethodDecl901 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_43_in_objCMethodDecl913 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl932 = new BitSet(new long[]{0xF000E00840000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_objCMethodDecl940 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl948 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl959 = new BitSet(new long[]{0x0000000210000000L});
    public static final BitSet FOLLOW_33_in_objCMethodDecl971 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl973 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_objCMethodDecl977 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl979 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl983 = new BitSet(new long[]{0x0000000018000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl998 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodDecl1000 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl1007 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_objCMethodDecl1011 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl1013 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1022 = new BitSet(new long[]{0x0000000018000040L});
    public static final BitSet FOLLOW_27_in_objCMethodDecl1041 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_objCMethodDecl1043 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_objCMethodDecl1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_structCore1086 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_structCore1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exportationModifiers_in_structCore1138 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_structCore1151 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_structCore1165 = new BitSet(new long[]{0xF807E001C7000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_48_in_structCore1188 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_49_in_structCore1201 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_50_in_structCore1214 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_structCore1226 = new BitSet(new long[]{0xF807E001C7000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_declaration_in_structCore1235 = new BitSet(new long[]{0xF807E001C7000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_24_in_structCore1249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRef_in_functionDeclaration1279 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_exportationModifiers_in_functionDeclaration1288 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionDeclaration1296 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_argList_in_functionDeclaration1303 = new BitSet(new long[]{0x0000000010800040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionDeclaration1313 = new BitSet(new long[]{0x0000000010800040L});
    public static final BitSet FOLLOW_exportationModifiers_in_functionDeclaration1322 = new BitSet(new long[]{0x0000000010800040L});
    public static final BitSet FOLLOW_28_in_functionDeclaration1334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_functionDeclaration1341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_functionDefinition1358 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_functionDefinition1360 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_functionDefinition1362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exportationModifier_in_exportationModifiers1389 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier1416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_exportationModifier1448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_exportationModifier1457 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_exportationModifier1465 = new BitSet(new long[]{0x0000000800000040L});
    public static final BitSet FOLLOW_extendedModifiers_in_exportationModifier1467 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_exportationModifier1469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_extendedModifiers1504 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_typeRef_in_argDef1547 = new BitSet(new long[]{0x0418000420000042L});
    public static final BitSet FOLLOW_declarator_in_argDef1558 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_argDef1578 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_argDef1580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_argDef1594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_typeMutator1614 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_typeMutator1616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_typeMutator1624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_typeMutator1632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_typeMutator1641 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_typeMutator1643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_arrayTypeMutator1661 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_arrayTypeMutator1667 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_arrayTypeMutator1676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_typeRefCore1716 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_typeRefCore1719 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_typeRefCore1721 = new BitSet(new long[]{0x04180C3000000000L,0x0000000000FFF000L});
    public static final BitSet FOLLOW_binaryOp_in_typeRefCore1723 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_typeRefCore1725 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_typeRefCore1727 = new BitSet(new long[]{0xF000000000000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_modifier_in_typeRefCore1738 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_typeRefCore1741 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_typeRefCore1743 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_typeRefCore1745 = new BitSet(new long[]{0xF000000000000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_modifier_in_typeRefCore1758 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_typeRefCore1761 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_typeRefCore1763 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_typeRefCore1765 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_typeRefCore1767 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_typeRefCore1769 = new BitSet(new long[]{0xF000000000000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_modifier_in_typeRefCore1786 = new BitSet(new long[]{0xF000000000000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_modifier_in_typeRefCore1803 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_typeRefCore1812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveTypeRef_in_typeRefCore1832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_typeRefCore1847 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_typeRefCore1865 = new BitSet(new long[]{0xF000E02040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_typeRefCore1886 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_27_in_typeRefCore1907 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_typeRefCore1920 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_37_in_typeRefCore1948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_templateDef1980 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_templateDef1982 = new BitSet(new long[]{0xF200402000000000L,0x00000000000007FFL});
    public static final BitSet FOLLOW_templateArgDecl_in_templateDef1985 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_27_in_templateDef1988 = new BitSet(new long[]{0xF200400000000000L,0x00000000000007FFL});
    public static final BitSet FOLLOW_templateArgDecl_in_templateDef1990 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_37_in_templateDef1997 = new BitSet(new long[]{0x0000E00000000000L});
    public static final BitSet FOLLOW_structCore_in_templateDef2001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDefinition_in_templateDef2005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveTypeRef_in_templateArgDecl2017 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_templateArgDecl2020 = new BitSet(new long[]{0x00000000000007B0L});
    public static final BitSet FOLLOW_constant_in_templateArgDecl2022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_templateArgDecl2029 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_templateArgDecl2037 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_templateArgDecl2040 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_templateArgDecl2042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffix2061 = new BitSet(new long[]{0x0008000000000040L});
    public static final BitSet FOLLOW_exportationModifiers_in_functionSignatureSuffix2063 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_functionSignatureSuffix2065 = new BitSet(new long[]{0x0000000800000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionSignatureSuffix2067 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffix2070 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffix2076 = new BitSet(new long[]{0xF000F00840000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffix2085 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_27_in_functionSignatureSuffix2098 = new BitSet(new long[]{0xF000F00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffix2107 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffix2122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffixNoName2139 = new BitSet(new long[]{0x0008000000000040L});
    public static final BitSet FOLLOW_exportationModifiers_in_functionSignatureSuffixNoName2141 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_functionSignatureSuffixNoName2143 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffixNoName2145 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffixNoName2151 = new BitSet(new long[]{0xF000F00840000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffixNoName2160 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_27_in_functionSignatureSuffixNoName2173 = new BitSet(new long[]{0xF000F00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffixNoName2182 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffixNoName2197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structCore_in_structOrEnum2215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumCore_in_structOrEnum2223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefCore_in_typeRefCoreOrFuncSig2241 = new BitSet(new long[]{0x0038000400000042L});
    public static final BitSet FOLLOW_typeMutator_in_typeRefCoreOrFuncSig2258 = new BitSet(new long[]{0x0038000400000040L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_typeRefCoreOrFuncSig2271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefCore_in_typeRefCoreOrAnonymousFuncSig2295 = new BitSet(new long[]{0x0038000400000042L});
    public static final BitSet FOLLOW_typeMutator_in_typeRefCoreOrAnonymousFuncSig2312 = new BitSet(new long[]{0x0038000400000040L});
    public static final BitSet FOLLOW_functionSignatureSuffixNoName_in_typeRefCoreOrAnonymousFuncSig2325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structOrEnum_in_plainTypeRef2352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefCoreOrFuncSig_in_plainTypeRef2360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_declarator2389 = new BitSet(new long[]{0x0418000400000040L});
    public static final BitSet FOLLOW_set_in_declarator2426 = new BitSet(new long[]{0x0418000400000040L});
    public static final BitSet FOLLOW_declarator_in_declarator2445 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_directDeclarator_in_declarator2461 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_declarator2480 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_declarator2487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structCore_in_namedTypeRef2521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumCore_in_namedTypeRef2531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_typeDef2550 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_varDecl_in_typeDef2556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_varDeclEOF2576 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_varDeclEOF2578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_varDecl2615 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_modifier_in_varDecl2632 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_structOrEnum_in_varDecl2659 = new BitSet(new long[]{0x0418000410000040L});
    public static final BitSet FOLLOW_declaratorsList_in_varDecl2676 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_typeRefCoreOrAnonymousFuncSig_in_varDecl2696 = new BitSet(new long[]{0x0418000400000040L});
    public static final BitSet FOLLOW_declaratorsList_in_varDecl2706 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_varDecl2743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_objCProtocolRefList2757 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCProtocolRefList2762 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_27_in_objCProtocolRefList2772 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCProtocolRefList2778 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_37_in_objCProtocolRefList2788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarator_in_declaratorsList2815 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_declaratorsList2828 = new BitSet(new long[]{0x0418000400000040L});
    public static final BitSet FOLLOW_declarator_in_declaratorsList2837 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_directDeclarator2880 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_34_in_directDeclarator2890 = new BitSet(new long[]{0x0418000400000040L});
    public static final BitSet FOLLOW_modifier_in_directDeclarator2899 = new BitSet(new long[]{0x0418000400000040L});
    public static final BitSet FOLLOW_declarator_in_directDeclarator2910 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_directDeclarator2916 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_53_in_directDeclarator2931 = new BitSet(new long[]{0x00600004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_directDeclarator2943 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_directDeclarator2959 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_argList_in_directDeclarator2967 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_34_in_argList2995 = new BitSet(new long[]{0xF000F00840000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_argDef_in_argList3007 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_27_in_argList3020 = new BitSet(new long[]{0xF000F00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_argDef_in_argList3029 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_27_in_argList3049 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_argList3051 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_argList3070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plainTypeRef_in_typeRef3088 = new BitSet(new long[]{0x0038000000000042L});
    public static final BitSet FOLLOW_typeMutator_in_typeRef3099 = new BitSet(new long[]{0x0038000000000042L});
    public static final BitSet FOLLOW_set_in_primSignModifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_primSizeModifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_primitiveTypeName0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primSignModifier_in_primitiveTypeRef3238 = new BitSet(new long[]{0xF000000000000000L,0x00000000000007FFL});
    public static final BitSet FOLLOW_primSizeModifier_in_primitiveTypeRef3249 = new BitSet(new long[]{0xF000000000000000L,0x00000000000007FFL});
    public static final BitSet FOLLOW_primSizeModifier_in_primitiveTypeRef3256 = new BitSet(new long[]{0xF000000000000000L,0x00000000000007FFL});
    public static final BitSet FOLLOW_primitiveTypeName_in_primitiveTypeRef3299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_objCMethodCall3338 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3342 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodCall3346 = new BitSet(new long[]{0x0040000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodCall3357 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3361 = new BitSet(new long[]{0x0040000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodCall3376 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodCall3378 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3382 = new BitSet(new long[]{0x0040000000000040L});
    public static final BitSet FOLLOW_54_in_objCMethodCall3399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_functionCall3419 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionCall3421 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_functionCall3423 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionCall3425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionCall3433 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionCall3435 = new BitSet(new long[]{0x0020000C008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_functionCall3448 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_27_in_functionCall3457 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_functionCall3466 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_35_in_functionCall3484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_binaryOp0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_expression3590 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_functionCall_in_expression3601 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_objCMethodCall_in_expression3610 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_set_in_expression3621 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_expression3631 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_34_in_expression3640 = new BitSet(new long[]{0xF020E004408007F0L,0x0000000003000FFFL});
    public static final BitSet FOLLOW_expression_in_expression3650 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_expression3652 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_typeRef_in_expression3662 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_expression3664 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_expression3668 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_constant_in_expression3683 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_23_in_expression3692 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_expression3694 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_expression3696 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_binaryOp_in_expression3712 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_expression3719 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_29_in_expression3728 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_expression3732 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_90_in_expression3741 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_expression3745 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_33_in_expression3757 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_expression3759 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000800L});
    public static final BitSet FOLLOW_43_in_expression3763 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_expression3765 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000800L});
    public static final BitSet FOLLOW_90_in_expression3769 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000800L});
    public static final BitSet FOLLOW_functionCall_in_expression3774 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_91_in_expression3783 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_expression3787 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_expression3789 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_expression3793 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_23_in_statementsBlock3814 = new BitSet(new long[]{0xF8A0E005D78007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statementsBlock3816 = new BitSet(new long[]{0xF8A0E005D78007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_24_in_statementsBlock3819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_statement3832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_statement3838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement3844 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_statement3847 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement3849 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_statement3860 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement3862 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_statement3870 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3872 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement3874 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3876 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement3878 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_statement3881 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement3883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_statement3891 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3893 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement3895 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3897 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement3899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_statement3905 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement3907 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_statement3909 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3911 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement3913 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3915 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_statement3923 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3925 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement3927 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3930 = new BitSet(new long[]{0x00200004108007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement3932 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3935 = new BitSet(new long[]{0xF8A0E00DD68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement3937 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3940 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement3942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_statement3948 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3950 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement3952 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3954 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_statement3956 = new BitSet(new long[]{0xF8A0E005D78007F0L,0x00000007D3000FFFL});
    public static final BitSet FOLLOW_98_in_statement3962 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement3964 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement3966 = new BitSet(new long[]{0xF8A0E005D78007F0L,0x00000007D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement3973 = new BitSet(new long[]{0xF8A0E005D78007F0L,0x00000007D3000FFFL});
    public static final BitSet FOLLOW_24_in_statement3982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_statement3988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement3996 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3998 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_varDecl_in_statement4000 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement4002 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement4004 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4006 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement4008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_constant4024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEXADECIMAL_NUMBER_in_constant4032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OCTAL_NUMBER_in_constant4040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARACTER_in_constant4048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_NUMBER_in_constant4056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_constant4067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_synpred6_ObjCpp249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred7_ObjCpp259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred26_ObjCpp777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred40_ObjCpp1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exportationModifiers_in_synpred41_ObjCpp1138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRef_in_synpred47_ObjCpp1279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred48_ObjCpp1313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exportationModifier_in_synpred50_ObjCpp1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred60_ObjCpp1738 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_synpred60_ObjCpp1741 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred60_ObjCpp1743 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred60_ObjCpp1745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred61_ObjCpp1758 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_synpred61_ObjCpp1761 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred61_ObjCpp1763 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_synpred61_ObjCpp1765 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred61_ObjCpp1767 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred61_ObjCpp1769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred62_ObjCpp1786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred63_ObjCpp1803 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_synpred63_ObjCpp1812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred80_ObjCpp2258 = new BitSet(new long[]{0x0038000400000040L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_synpred80_ObjCpp2271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred82_ObjCpp2312 = new BitSet(new long[]{0x0038000400000040L});
    public static final BitSet FOLLOW_functionSignatureSuffixNoName_in_synpred82_ObjCpp2325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred84_ObjCpp2389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred88_ObjCpp2480 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred88_ObjCpp2487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred90_ObjCpp2615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred91_ObjCpp2632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred97_ObjCpp2899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_synpred101_ObjCpp3020 = new BitSet(new long[]{0xF000F00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_argDef_in_synpred101_ObjCpp3029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred104_ObjCpp3099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred150_ObjCpp3650 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred150_ObjCpp3652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binaryOp_in_synpred153_ObjCpp3712 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred153_ObjCpp3719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred154_ObjCpp3728 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred154_ObjCpp3732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_synpred155_ObjCpp3741 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred155_ObjCpp3745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_synpred158_ObjCpp3757 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_synpred158_ObjCpp3759 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000800L});
    public static final BitSet FOLLOW_43_in_synpred158_ObjCpp3763 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_synpred158_ObjCpp3765 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000800L});
    public static final BitSet FOLLOW_90_in_synpred158_ObjCpp3769 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000800L});
    public static final BitSet FOLLOW_functionCall_in_synpred158_ObjCpp3774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_synpred159_ObjCpp3783 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred159_ObjCpp3787 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_synpred159_ObjCpp3789 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred159_ObjCpp3793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_synpred161_ObjCpp3832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_synpred162_ObjCpp3838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred164_ObjCpp3844 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_synpred164_ObjCpp3847 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred164_ObjCpp3849 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_synpred164_ObjCpp3854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_synpred166_ObjCpp3881 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_synpred166_ObjCpp3883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_synpred170_ObjCpp3927 = new BitSet(new long[]{0x0000000000000002L});

}