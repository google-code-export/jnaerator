// $ANTLR 3.1.2 /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g 2009-03-24 23:37:41
 
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:287:1: forwardClassDecl returns [List<Declaration> declarations] : '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:288:2: ( '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:288:5: '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';'
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:291:3: ( ',' nx= IDENTIFIER )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==27) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:291:4: ',' nx= IDENTIFIER
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:297:1: functionPointerVarDecl returns [List<? extends Declaration> declarations] : typeRef {...}? ';' ;
    public final ObjCppParser.functionPointerVarDecl_return functionPointerVarDecl() throws RecognitionException {
        ObjCppParser.functionPointerVarDecl_return retval = new ObjCppParser.functionPointerVarDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal20=null;
        ObjCppParser.typeRef_return typeRef19 = null;


        Object char_literal20_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:298:2: ( typeRef {...}? ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:298:4: typeRef {...}? ';'
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:307:1: enumItem returns [Enum.EnumItem item] : n= IDENTIFIER ( '=' v= expression )? ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:308:2: (n= IDENTIFIER ( '=' v= expression )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:308:4: n= IDENTIFIER ( '=' v= expression )?
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumItem455); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:308:17: ( '=' v= expression )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==29) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:308:18: '=' v= expression
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:315:1: enumCore returns [Enum e] : t= 'enum' (n1= IDENTIFIER )? '{' i1= enumItem ( ',' (ix= enumItem )? )* '}' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:316:2: (t= 'enum' (n1= IDENTIFIER )? '{' i1= enumItem ( ',' (ix= enumItem )? )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:317:3: t= 'enum' (n1= IDENTIFIER )? '{' i1= enumItem ( ',' (ix= enumItem )? )* '}'
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:320:5: (n1= IDENTIFIER )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==IDENTIFIER) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:321:4: n1= IDENTIFIER
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:329:4: ( ',' (ix= enumItem )? )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==27) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:330:5: ',' (ix= enumItem )?
            	    {
            	    char_literal23=(Token)match(input,27,FOLLOW_27_in_enumCore529); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal23_tree = (Object)adaptor.create(char_literal23);
            	    adaptor.addChild(root_0, char_literal23_tree);
            	    }
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:331:5: (ix= enumItem )?
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( (LA10_0==IDENTIFIER) ) {
            	        alt10=1;
            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:331:6: ix= enumItem
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:346:1: objCClassDef returns [Struct struct] : octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl {...}?)* '@end' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:347:2: (octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl {...}?)* '@end' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:348:3: octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl {...}?)* '@end'
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:358:3: ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' )
            int alt13=2;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:359:4: ( ':' parentClass= IDENTIFIER )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:359:4: ( ':' parentClass= IDENTIFIER )?
                    int alt12=2;
                    alt12 = dfa12.predict(input);
                    switch (alt12) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:360:5: ':' parentClass= IDENTIFIER
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:365:4: '(' categoryName= IDENTIFIER ')'
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:369:3: ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )?
            int alt16=2;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:370:4: '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>'
                    {
                    char_literal28=(Token)match(input,36,FOLLOW_36_in_objCClassDef650); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal28_tree = (Object)adaptor.create(char_literal28);
                    adaptor.addChild(root_0, char_literal28_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:370:8: (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==IDENTIFIER) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:371:5: p1= IDENTIFIER ( ',' px= IDENTIFIER )*
                            {
                            p1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef660); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            p1_tree = (Object)adaptor.create(p1);
                            adaptor.addChild(root_0, p1_tree);
                            }
                            if ( state.backtracking==0 ) {
                               retval.struct.addProtocol((p1!=null?p1.getText():null)); 
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:372:5: ( ',' px= IDENTIFIER )*
                            loop14:
                            do {
                                int alt14=2;
                                int LA14_0 = input.LA(1);

                                if ( (LA14_0==27) ) {
                                    alt14=1;
                                }


                                switch (alt14) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:373:6: ',' px= IDENTIFIER
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:378:3: ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )?
            int alt19=2;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:379:4: '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}'
                    {
                    char_literal31=(Token)match(input,23,FOLLOW_23_in_objCClassDef716); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal31_tree = (Object)adaptor.create(char_literal31);
                    adaptor.addChild(root_0, char_literal31_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:380:4: ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )*
                    loop18:
                    do {
                        int alt18=5;
                        alt18 = dfa18.predict(input);
                        switch (alt18) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:381:5: '@public'
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
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:382:5: '@private'
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
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:383:5: '@protected'
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
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:384:5: ( (fv= varDecl | functionPointerVarDecl ) )
                    	    {
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:384:5: ( (fv= varDecl | functionPointerVarDecl ) )
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:385:6: (fv= varDecl | functionPointerVarDecl )
                    	    {
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:385:6: (fv= varDecl | functionPointerVarDecl )
                    	    int alt17=2;
                    	    alt17 = dfa17.predict(input);
                    	    switch (alt17) {
                    	        case 1 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:386:7: fv= varDecl
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
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:389:7: functionPointerVarDecl
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:398:3: ( objCMethodDecl | typeDef | vd= varDecl {...}?)*
            loop20:
            do {
                int alt20=4;
                alt20 = dfa20.predict(input);
                switch (alt20) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:399:4: objCMethodDecl
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:402:4: typeDef
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:405:4: vd= varDecl {...}?
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:412:1: objCMethodDecl returns [Function function] : tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= typeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:413:2: (tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= typeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:413:4: tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= typeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               	
              			retval.function = new Function(); 
              			retval.function.setType(Function.Type.ObjCMethod);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:417:6: (tp= '+' | tm= '-' )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:418:4: tp= '+'
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:423:4: tm= '-'
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:428:3: ( '(' (returnTypeRef= typeRef )? ')' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==34) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:430:4: '(' (returnTypeRef= typeRef )? ')'
                    {
                    char_literal40=(Token)match(input,34,FOLLOW_34_in_objCMethodDecl932); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal40_tree = (Object)adaptor.create(char_literal40);
                    adaptor.addChild(root_0, char_literal40_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:431:18: (returnTypeRef= typeRef )?
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:440:3: ( ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==33) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:441:4: ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )?
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:446:4: (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==IDENTIFIER) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:447:5: sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER
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

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:455:4: ( ',' '...' )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==27) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:456:5: ',' '...'
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:477:1: structCore returns [Struct struct, List<Modifier> modifiers] : t= ( 'struct' | 'class' | 'union' ) ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' ) ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:478:2: (t= ( 'struct' | 'class' | 'union' ) ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:480:3: t= ( 'struct' | 'class' | 'union' ) ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' )
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:489:3: ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' )
            int alt31=2;
            alt31 = dfa31.predict(input);
            switch (alt31) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:490:4: (n0= IDENTIFIER )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:490:4: (n0= IDENTIFIER )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:491:5: n0= IDENTIFIER
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:496:4: ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}'
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:496:4: ( ( exportationModifiers )? n1= IDENTIFIER )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==IDENTIFIER) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:497:5: ( exportationModifiers )? n1= IDENTIFIER
                            {
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:497:5: ( exportationModifiers )?
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
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:497:7: exportationModifiers
                                    {
                                    pushFollow(FOLLOW_exportationModifiers_in_structCore1138);
                                    exportationModifiers51=exportationModifiers();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) adaptor.addChild(root_0, exportationModifiers51.getTree());
                                    if ( state.backtracking==0 ) {

                                      					retval.struct.addModifiers((exportationModifiers51!=null?exportationModifiers51.modifiers:null));
                                      				
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:503:5: ( ( 'public' | 'private' | 'protected' ) ':' | declaration )*
                    loop30:
                    do {
                        int alt30=3;
                        alt30 = dfa30.predict(input);
                        switch (alt30) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:504:6: ( 'public' | 'private' | 'protected' ) ':'
                    	    {
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:504:6: ( 'public' | 'private' | 'protected' )
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
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:505:7: 'public'
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
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:506:7: 'private'
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
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:507:7: 'protected'
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
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:509:6: declaration
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:518:1: functionDeclaration returns [Function function] : (returnTypeRef= typeRef )? preMods= exportationModifiers n= IDENTIFIER argList {...}? (ct= IDENTIFIER )? postMods= exportationModifiers ( ';' | statementsBlock ) ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:519:2: ( (returnTypeRef= typeRef )? preMods= exportationModifiers n= IDENTIFIER argList {...}? (ct= IDENTIFIER )? postMods= exportationModifiers ( ';' | statementsBlock ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:519:4: (returnTypeRef= typeRef )? preMods= exportationModifiers n= IDENTIFIER argList {...}? (ct= IDENTIFIER )? postMods= exportationModifiers ( ';' | statementsBlock )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               	
              			retval.function = new Function();
              			retval.function.setType(Function.Type.CFunction);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:526:16: (returnTypeRef= typeRef )?
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

              			retval.function.addModifiers((preMods!=null?preMods.modifiers:null));
              		
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:539:35: (ct= IDENTIFIER )?
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:547:3: ( ';' | statementsBlock )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:548:4: ';'
                    {
                    char_literal60=(Token)match(input,28,FOLLOW_28_in_functionDeclaration1334); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal60_tree = (Object)adaptor.create(char_literal60);
                    adaptor.addChild(root_0, char_literal60_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:549:4: statementsBlock
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:555:1: functionDefinition : functionDeclaration '{' '}' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:556:2: ( functionDeclaration '{' '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:556:4: functionDeclaration '{' '}'
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:559:1: exportationModifiers returns [List<Modifier> modifiers] : ( exportationModifier )* ;
    public final ObjCppParser.exportationModifiers_return exportationModifiers() throws RecognitionException {
        ObjCppParser.exportationModifiers_return retval = new ObjCppParser.exportationModifiers_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.exportationModifier_return exportationModifier65 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:560:2: ( ( exportationModifier )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:560:5: ( exportationModifier )*
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:561:3: ( exportationModifier )*
            loop35:
            do {
                int alt35=2;
                alt35 = dfa35.predict(input);
                switch (alt35) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:562:4: exportationModifier
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:568:1: modifier returns [Modifier modifier] : {...}? IDENTIFIER ;
    public final ObjCppParser.modifier_return modifier() throws RecognitionException {
        ObjCppParser.modifier_return retval = new ObjCppParser.modifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER66=null;

        Object IDENTIFIER66_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:569:2: ({...}? IDENTIFIER )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:569:4: {...}? IDENTIFIER
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:582:1: exportationModifier returns [List<Modifier> modifiers] : ({...}? modifier | IDENTIFIER {...}? '(' extendedModifiers ')' ) ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:583:2: ( ({...}? modifier | IDENTIFIER {...}? '(' extendedModifiers ')' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:583:5: ({...}? modifier | IDENTIFIER {...}? '(' extendedModifiers ')' )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:584:3: ({...}? modifier | IDENTIFIER {...}? '(' extendedModifiers ')' )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:585:4: {...}? modifier
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:588:4: IDENTIFIER {...}? '(' extendedModifiers ')'
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:596:1: extendedModifiers returns [List<Modifier> modifiers] : ({...}?m= modifier () )* ;
    public final ObjCppParser.extendedModifiers_return extendedModifiers() throws RecognitionException {
        ObjCppParser.extendedModifiers_return retval = new ObjCppParser.extendedModifiers_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.modifier_return m = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:597:2: ( ({...}?m= modifier () )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:597:4: ({...}?m= modifier () )*
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:598:3: ({...}?m= modifier () )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==IDENTIFIER) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:599:4: {...}?m= modifier ()
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:600:4: ()
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:601:5: 
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:611:1: argDef returns [Arg arg] : ( ({...}?sm= modifier | {...}?tm= modifier )* ( typeRef ) ( ( declarator )? ) ( '=' expression )? | '...' );
    public final ObjCppParser.argDef_return argDef() throws RecognitionException {
        ObjCppParser.argDef_return retval = new ObjCppParser.argDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal74=null;
        Token string_literal76=null;
        ObjCppParser.modifier_return sm = null;

        ObjCppParser.modifier_return tm = null;

        ObjCppParser.typeRef_return typeRef72 = null;

        ObjCppParser.declarator_return declarator73 = null;

        ObjCppParser.expression_return expression75 = null;


        Object char_literal74_tree=null;
        Object string_literal76_tree=null;


        	List<Modifier> stoMods = new ArrayList<Modifier>(), typMods = new ArrayList<Modifier>();

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:615:2: ( ({...}?sm= modifier | {...}?tm= modifier )* ( typeRef ) ( ( declarator )? ) ( '=' expression )? | '...' )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==IDENTIFIER||LA41_0==30||(LA41_0>=45 && LA41_0<=47)||(LA41_0>=60 && LA41_0<=74)) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:615:4: ({...}?sm= modifier | {...}?tm= modifier )* ( typeRef ) ( ( declarator )? ) ( '=' expression )?
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( state.backtracking==0 ) {
                       
                      			retval.arg = new Arg(); 
                      			int i = getTokenStream().index() + 1;
                      			retval.arg.setCommentBefore(getCommentBefore(i));
                      			retval.arg.setCommentAfter(getCommentAfterOnSameLine(i));
                      		
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:621:3: ({...}?sm= modifier | {...}?tm= modifier )*
                    loop38:
                    do {
                        int alt38=3;
                        alt38 = dfa38.predict(input);
                        switch (alt38) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:622:4: {...}?sm= modifier
                    	    {
                    	    if ( !(( next(Modifier.Kind.StorageClassSpecifier) )) ) {
                    	        if (state.backtracking>0) {state.failed=true; return retval;}
                    	        throw new FailedPredicateException(input, "argDef", " next(Modifier.Kind.StorageClassSpecifier) ");
                    	    }
                    	    pushFollow(FOLLOW_modifier_in_argDef1563);
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
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:624:4: {...}?tm= modifier
                    	    {
                    	    if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
                    	        if (state.backtracking>0) {state.failed=true; return retval;}
                    	        throw new FailedPredicateException(input, "argDef", " next(Modifier.Kind.TypeQualifier) ");
                    	    }
                    	    pushFollow(FOLLOW_modifier_in_argDef1580);
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
                    	    break loop38;
                        }
                    } while (true);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:627:3: ( typeRef )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:630:4: typeRef
                    {
                    pushFollow(FOLLOW_typeRef_in_argDef1604);
                    typeRef72=typeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRef72.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				if ((typeRef72!=null?typeRef72.type:null) != null) {
                      					(typeRef72!=null?typeRef72.type:null).addModifiers(typMods);
                      					(typeRef72!=null?typeRef72.type:null).addModifiers(stoMods);
                      					retval.arg.setValueType((typeRef72!=null?typeRef72.type:null)); 
                      				}
                      			
                    }

                    }

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:638:3: ( ( declarator )? )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:639:4: ( declarator )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:639:4: ( declarator )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==IDENTIFIER||LA39_0==34||(LA39_0>=51 && LA39_0<=52)||LA39_0==58) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: declarator
                            {
                            pushFollow(FOLLOW_declarator_in_argDef1619);
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

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:670:3: ( '=' expression )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==29) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:670:4: '=' expression
                            {
                            char_literal74=(Token)match(input,29,FOLLOW_29_in_argDef1639); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal74_tree = (Object)adaptor.create(char_literal74);
                            adaptor.addChild(root_0, char_literal74_tree);
                            }
                            pushFollow(FOLLOW_expression_in_argDef1641);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:674:3: '...'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal76=(Token)match(input,44,FOLLOW_44_in_argDef1655); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:692:1: typeMutator returns [TypeMutator mutator] : ({...}? IDENTIFIER '*' | '*' | '&' | '[' ']' );
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:693:2: ({...}? IDENTIFIER '*' | '*' | '&' | '[' ']' )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:693:4: {...}? IDENTIFIER '*'
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !(( next("const", "__const") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeMutator", " next(\"const\", \"__const\") ");
                    }
                    IDENTIFIER77=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_typeMutator1675); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER77_tree = (Object)adaptor.create(IDENTIFIER77);
                    adaptor.addChild(root_0, IDENTIFIER77_tree);
                    }
                    char_literal78=(Token)match(input,51,FOLLOW_51_in_typeMutator1677); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:694:3: '*'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal79=(Token)match(input,51,FOLLOW_51_in_typeMutator1685); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:695:3: '&'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal80=(Token)match(input,52,FOLLOW_52_in_typeMutator1693); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:696:3: '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal81=(Token)match(input,53,FOLLOW_53_in_typeMutator1702); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal81_tree = (Object)adaptor.create(char_literal81);
                    adaptor.addChild(root_0, char_literal81_tree);
                    }
                    char_literal82=(Token)match(input,54,FOLLOW_54_in_typeMutator1704); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:699:1: arrayTypeMutator returns [TypeMutator mutator] : '[' expression ']' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:700:2: ( '[' expression ']' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:700:4: '[' expression ']'
            {
            root_0 = (Object)adaptor.nil();

            char_literal83=(Token)match(input,53,FOLLOW_53_in_arrayTypeMutator1722); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal83_tree = (Object)adaptor.create(char_literal83);
            adaptor.addChild(root_0, char_literal83_tree);
            }
            pushFollow(FOLLOW_expression_in_arrayTypeMutator1728);
            expression84=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression84.getTree());
            if ( state.backtracking==0 ) {

              				retval.mutator = TypeMutator.array((expression84!=null?expression84.expr:null)); 
              			
            }
            char_literal85=(Token)match(input,54,FOLLOW_54_in_arrayTypeMutator1737); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:707:1: typeRefCore returns [TypeRef type] : ({...}? IDENTIFIER '(' 'return' binaryOp expression ')' | {...}?m1a= modifier '(' expression ')' | {...}?m2a= modifier '(' expression ',' expression ')' )? ({...}?m= modifier )? ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) ) ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:709:2: ( ({...}? IDENTIFIER '(' 'return' binaryOp expression ')' | {...}?m1a= modifier '(' expression ')' | {...}?m2a= modifier '(' expression ',' expression ')' )? ({...}?m= modifier )? ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:710:3: ({...}? IDENTIFIER '(' 'return' binaryOp expression ')' | {...}?m1a= modifier '(' expression ')' | {...}?m2a= modifier '(' expression ',' expression ')' )? ({...}?m= modifier )? ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) )
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:710:3: ({...}? IDENTIFIER '(' 'return' binaryOp expression ')' | {...}?m1a= modifier '(' expression ')' | {...}?m2a= modifier '(' expression ',' expression ')' )?
            int alt43=4;
            alt43 = dfa43.predict(input);
            switch (alt43) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:713:4: {...}? IDENTIFIER '(' 'return' binaryOp expression ')'
                    {
                    if ( !(( "__success".equals(next()) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeRefCore", " \"__success\".equals(next()) ");
                    }
                    IDENTIFIER86=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_typeRefCore1777); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER86_tree = (Object)adaptor.create(IDENTIFIER86);
                    adaptor.addChild(root_0, IDENTIFIER86_tree);
                    }
                    char_literal87=(Token)match(input,34,FOLLOW_34_in_typeRefCore1780); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal87_tree = (Object)adaptor.create(char_literal87);
                    adaptor.addChild(root_0, char_literal87_tree);
                    }
                    string_literal88=(Token)match(input,55,FOLLOW_55_in_typeRefCore1782); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal88_tree = (Object)adaptor.create(string_literal88);
                    adaptor.addChild(root_0, string_literal88_tree);
                    }
                    pushFollow(FOLLOW_binaryOp_in_typeRefCore1784);
                    binaryOp89=binaryOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, binaryOp89.getTree());
                    pushFollow(FOLLOW_expression_in_typeRefCore1786);
                    expression90=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression90.getTree());
                    char_literal91=(Token)match(input,35,FOLLOW_35_in_typeRefCore1788); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal91_tree = (Object)adaptor.create(char_literal91);
                    adaptor.addChild(root_0, char_literal91_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:714:4: {...}?m1a= modifier '(' expression ')'
                    {
                    if ( !(( next(Modifier.Kind.VCAnnotation1Arg) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeRefCore", " next(Modifier.Kind.VCAnnotation1Arg) ");
                    }
                    pushFollow(FOLLOW_modifier_in_typeRefCore1799);
                    m1a=modifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, m1a.getTree());
                    char_literal92=(Token)match(input,34,FOLLOW_34_in_typeRefCore1802); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal92_tree = (Object)adaptor.create(char_literal92);
                    adaptor.addChild(root_0, char_literal92_tree);
                    }
                    pushFollow(FOLLOW_expression_in_typeRefCore1804);
                    expression93=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression93.getTree());
                    char_literal94=(Token)match(input,35,FOLLOW_35_in_typeRefCore1806); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:715:4: {...}?m2a= modifier '(' expression ',' expression ')'
                    {
                    if ( !(( next(Modifier.Kind.VCAnnotation2Args) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeRefCore", " next(Modifier.Kind.VCAnnotation2Args) ");
                    }
                    pushFollow(FOLLOW_modifier_in_typeRefCore1819);
                    m2a=modifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, m2a.getTree());
                    char_literal95=(Token)match(input,34,FOLLOW_34_in_typeRefCore1822); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal95_tree = (Object)adaptor.create(char_literal95);
                    adaptor.addChild(root_0, char_literal95_tree);
                    }
                    pushFollow(FOLLOW_expression_in_typeRefCore1824);
                    expression96=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression96.getTree());
                    char_literal97=(Token)match(input,27,FOLLOW_27_in_typeRefCore1826); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal97_tree = (Object)adaptor.create(char_literal97);
                    adaptor.addChild(root_0, char_literal97_tree);
                    }
                    pushFollow(FOLLOW_expression_in_typeRefCore1828);
                    expression98=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression98.getTree());
                    char_literal99=(Token)match(input,35,FOLLOW_35_in_typeRefCore1830); if (state.failed) return retval;
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:717:3: ({...}?m= modifier )?
            int alt44=2;
            alt44 = dfa44.predict(input);
            switch (alt44) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:717:4: {...}?m= modifier
                    {
                    if ( !(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeRefCore", " next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ");
                    }
                    pushFollow(FOLLOW_modifier_in_typeRefCore1847);
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:718:3: ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) )
            int alt49=2;
            alt49 = dfa49.predict(input);
            switch (alt49) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:719:4: {...}?m1= modifier tr= typeRef
                    {
                    if ( !(( next(Modifier.Kind.ReferenceQualifier) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeRefCore", " next(Modifier.Kind.ReferenceQualifier) ");
                    }
                    pushFollow(FOLLOW_modifier_in_typeRefCore1864);
                    m1=modifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, m1.getTree());
                    if ( state.backtracking==0 ) {
                       mods.add((m1!=null?m1.modifier:null)); 
                    }
                    pushFollow(FOLLOW_typeRef_in_typeRefCore1873);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:722:4: ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:722:4: ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) )
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( ((LA48_0>=60 && LA48_0<=74)) ) {
                        alt48=1;
                    }
                    else if ( (LA48_0==IDENTIFIER) ) {
                        alt48=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 48, 0, input);

                        throw nvae;
                    }
                    switch (alt48) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:723:5: primitiveTypeRef
                            {
                            pushFollow(FOLLOW_primitiveTypeRef_in_typeRefCore1893);
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
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:724:5: {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' )
                            {
                            if ( !(( Modifier.parseModifier(next()) == null )) ) {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                throw new FailedPredicateException(input, "typeRefCore", " Modifier.parseModifier(next()) == null ");
                            }
                            ref=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_typeRefCore1908); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ref_tree = (Object)adaptor.create(ref);
                            adaptor.addChild(root_0, ref_tree);
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:724:64: ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' )
                            int alt47=2;
                            alt47 = dfa47.predict(input);
                            switch (alt47) {
                                case 1 :
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:725:6: 
                                    {
                                    if ( state.backtracking==0 ) {
                                       retval.type = new SimpleTypeRef((ref!=null?ref.getText():null)); 
                                    }

                                    }
                                    break;
                                case 2 :
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:726:6: '<' (t1= typeRef ( ',' tx= typeRef )* )? '>'
                                    {
                                    char_literal101=(Token)match(input,36,FOLLOW_36_in_typeRefCore1926); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    char_literal101_tree = (Object)adaptor.create(char_literal101);
                                    adaptor.addChild(root_0, char_literal101_tree);
                                    }
                                    if ( state.backtracking==0 ) {
                                       retval.type = new TemplateRef((ref!=null?ref.getText():null)); 
                                    }
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:727:7: (t1= typeRef ( ',' tx= typeRef )* )?
                                    int alt46=2;
                                    int LA46_0 = input.LA(1);

                                    if ( (LA46_0==IDENTIFIER||LA46_0==30||(LA46_0>=45 && LA46_0<=47)||(LA46_0>=60 && LA46_0<=74)) ) {
                                        alt46=1;
                                    }
                                    switch (alt46) {
                                        case 1 :
                                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:728:8: t1= typeRef ( ',' tx= typeRef )*
                                            {
                                            pushFollow(FOLLOW_typeRef_in_typeRefCore1947);
                                            t1=typeRef();

                                            state._fsp--;
                                            if (state.failed) return retval;
                                            if ( state.backtracking==0 ) adaptor.addChild(root_0, t1.getTree());
                                            if ( state.backtracking==0 ) {
                                               ((TemplateRef)retval.type).addParameter((t1!=null?t1.type:null)); 
                                            }
                                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:729:8: ( ',' tx= typeRef )*
                                            loop45:
                                            do {
                                                int alt45=2;
                                                int LA45_0 = input.LA(1);

                                                if ( (LA45_0==27) ) {
                                                    alt45=1;
                                                }


                                                switch (alt45) {
                                            	case 1 :
                                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:730:9: ',' tx= typeRef
                                            	    {
                                            	    char_literal102=(Token)match(input,27,FOLLOW_27_in_typeRefCore1968); if (state.failed) return retval;
                                            	    if ( state.backtracking==0 ) {
                                            	    char_literal102_tree = (Object)adaptor.create(char_literal102);
                                            	    adaptor.addChild(root_0, char_literal102_tree);
                                            	    }
                                            	    pushFollow(FOLLOW_typeRef_in_typeRefCore1981);
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
                                            	    break loop45;
                                                }
                                            } while (true);


                                            }
                                            break;

                                    }

                                    char_literal103=(Token)match(input,37,FOLLOW_37_in_typeRefCore2009); if (state.failed) return retval;
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
               
              			if (retval.type != null)
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:745:1: templateDef : ( 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' structCore | functionDefinition );
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:746:2: ( 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' structCore | functionDefinition )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==56) ) {
                alt52=1;
            }
            else if ( (LA52_0==IDENTIFIER||LA52_0==30||(LA52_0>=45 && LA52_0<=47)||(LA52_0>=60 && LA52_0<=74)) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:746:4: 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' structCore
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal104=(Token)match(input,56,FOLLOW_56_in_templateDef2041); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal104_tree = (Object)adaptor.create(string_literal104);
                    adaptor.addChild(root_0, string_literal104_tree);
                    }
                    char_literal105=(Token)match(input,36,FOLLOW_36_in_templateDef2043); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal105_tree = (Object)adaptor.create(char_literal105);
                    adaptor.addChild(root_0, char_literal105_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:746:19: ( templateArgDecl ( ',' templateArgDecl )* )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==46||LA51_0==57||(LA51_0>=60 && LA51_0<=74)) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:746:20: templateArgDecl ( ',' templateArgDecl )*
                            {
                            pushFollow(FOLLOW_templateArgDecl_in_templateDef2046);
                            templateArgDecl106=templateArgDecl();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, templateArgDecl106.getTree());
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:746:36: ( ',' templateArgDecl )*
                            loop50:
                            do {
                                int alt50=2;
                                int LA50_0 = input.LA(1);

                                if ( (LA50_0==27) ) {
                                    alt50=1;
                                }


                                switch (alt50) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:746:37: ',' templateArgDecl
                            	    {
                            	    char_literal107=(Token)match(input,27,FOLLOW_27_in_templateDef2049); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    char_literal107_tree = (Object)adaptor.create(char_literal107);
                            	    adaptor.addChild(root_0, char_literal107_tree);
                            	    }
                            	    pushFollow(FOLLOW_templateArgDecl_in_templateDef2051);
                            	    templateArgDecl108=templateArgDecl();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, templateArgDecl108.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop50;
                                }
                            } while (true);


                            }
                            break;

                    }

                    char_literal109=(Token)match(input,37,FOLLOW_37_in_templateDef2058); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal109_tree = (Object)adaptor.create(char_literal109);
                    adaptor.addChild(root_0, char_literal109_tree);
                    }
                    pushFollow(FOLLOW_structCore_in_templateDef2062);
                    structCore110=structCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structCore110.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:747:16: functionDefinition
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_functionDefinition_in_templateDef2066);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:750:1: templateArgDecl : ( primitiveTypeRef ( '=' constant ) | ( 'typename' | 'class' ) IDENTIFIER ( '=' typeRef ) );
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:751:2: ( primitiveTypeRef ( '=' constant ) | ( 'typename' | 'class' ) IDENTIFIER ( '=' typeRef ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=60 && LA53_0<=74)) ) {
                alt53=1;
            }
            else if ( (LA53_0==46||LA53_0==57) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:751:4: primitiveTypeRef ( '=' constant )
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primitiveTypeRef_in_templateArgDecl2078);
                    primitiveTypeRef112=primitiveTypeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveTypeRef112.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:751:21: ( '=' constant )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:751:22: '=' constant
                    {
                    char_literal113=(Token)match(input,29,FOLLOW_29_in_templateArgDecl2081); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal113_tree = (Object)adaptor.create(char_literal113);
                    adaptor.addChild(root_0, char_literal113_tree);
                    }
                    pushFollow(FOLLOW_constant_in_templateArgDecl2083);
                    constant114=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant114.getTree());

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:752:3: ( 'typename' | 'class' ) IDENTIFIER ( '=' typeRef )
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

                    IDENTIFIER116=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_templateArgDecl2098); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER116_tree = (Object)adaptor.create(IDENTIFIER116);
                    adaptor.addChild(root_0, IDENTIFIER116_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:752:37: ( '=' typeRef )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:752:38: '=' typeRef
                    {
                    char_literal117=(Token)match(input,29,FOLLOW_29_in_templateArgDecl2101); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal117_tree = (Object)adaptor.create(char_literal117);
                    adaptor.addChild(root_0, char_literal117_tree);
                    }
                    pushFollow(FOLLOW_typeRef_in_templateArgDecl2103);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:755:1: functionSignatureSuffix returns [FunctionSignature signature] : tk= '(' exportationModifiers '*' ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:756:2: (tk= '(' exportationModifiers '*' ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:756:4: tk= '(' exportationModifiers '*' ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')'
            {
            root_0 = (Object)adaptor.nil();

            tk=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffix2122); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tk_tree = (Object)adaptor.create(tk);
            adaptor.addChild(root_0, tk_tree);
            }
            pushFollow(FOLLOW_exportationModifiers_in_functionSignatureSuffix2124);
            exportationModifiers119=exportationModifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exportationModifiers119.getTree());
            char_literal120=(Token)match(input,51,FOLLOW_51_in_functionSignatureSuffix2126); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal120_tree = (Object)adaptor.create(char_literal120);
            adaptor.addChild(root_0, char_literal120_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:756:36: ( IDENTIFIER )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==IDENTIFIER) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: IDENTIFIER
                    {
                    IDENTIFIER121=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionSignatureSuffix2128); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER121_tree = (Object)adaptor.create(IDENTIFIER121);
                    adaptor.addChild(root_0, IDENTIFIER121_tree);
                    }

                    }
                    break;

            }

            char_literal122=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffix2131); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal122_tree = (Object)adaptor.create(char_literal122);
            adaptor.addChild(root_0, char_literal122_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, (IDENTIFIER121!=null?IDENTIFIER121.getText():null), null)), getLine(tk));
              			retval.signature.getFunction().setType(Function.Type.CFunction);
              			retval.signature.getFunction().addModifiers((exportationModifiers119!=null?exportationModifiers119.modifiers:null));
              		
            }
            char_literal123=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffix2137); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal123_tree = (Object)adaptor.create(char_literal123);
            adaptor.addChild(root_0, char_literal123_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:761:7: (a1= argDef ( ',' ax= argDef )* )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==IDENTIFIER||LA56_0==30||(LA56_0>=44 && LA56_0<=47)||(LA56_0>=60 && LA56_0<=74)) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:762:4: a1= argDef ( ',' ax= argDef )*
                    {
                    pushFollow(FOLLOW_argDef_in_functionSignatureSuffix2146);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					((FunctionSignature)retval.signature).getFunction().addArg((a1!=null?a1.arg:null)); 
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:766:4: ( ',' ax= argDef )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==27) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:5: ',' ax= argDef
                    	    {
                    	    char_literal124=(Token)match(input,27,FOLLOW_27_in_functionSignatureSuffix2159); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal124_tree = (Object)adaptor.create(char_literal124);
                    	    adaptor.addChild(root_0, char_literal124_tree);
                    	    }
                    	    pushFollow(FOLLOW_argDef_in_functionSignatureSuffix2168);
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

            char_literal125=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffix2183); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:775:1: functionSignatureSuffixNoName returns [FunctionSignature signature] : tk= '(' exportationModifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:776:2: (tk= '(' exportationModifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:776:4: tk= '(' exportationModifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')'
            {
            root_0 = (Object)adaptor.nil();

            tk=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffixNoName2200); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tk_tree = (Object)adaptor.create(tk);
            adaptor.addChild(root_0, tk_tree);
            }
            pushFollow(FOLLOW_exportationModifiers_in_functionSignatureSuffixNoName2202);
            exportationModifiers126=exportationModifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exportationModifiers126.getTree());
            char_literal127=(Token)match(input,51,FOLLOW_51_in_functionSignatureSuffixNoName2204); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal127_tree = (Object)adaptor.create(char_literal127);
            adaptor.addChild(root_0, char_literal127_tree);
            }
            char_literal128=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffixNoName2206); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal128_tree = (Object)adaptor.create(char_literal128);
            adaptor.addChild(root_0, char_literal128_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, null, null)), getLine(tk));
              			retval.signature.getFunction().setType(Function.Type.CFunction);
              			retval.signature.getFunction().addModifiers((exportationModifiers126!=null?exportationModifiers126.modifiers:null));
              		
            }
            char_literal129=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffixNoName2212); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal129_tree = (Object)adaptor.create(char_literal129);
            adaptor.addChild(root_0, char_literal129_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:781:7: (a1= argDef ( ',' ax= argDef )* )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==IDENTIFIER||LA58_0==30||(LA58_0>=44 && LA58_0<=47)||(LA58_0>=60 && LA58_0<=74)) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:782:4: a1= argDef ( ',' ax= argDef )*
                    {
                    pushFollow(FOLLOW_argDef_in_functionSignatureSuffixNoName2221);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					((FunctionSignature)retval.signature).getFunction().addArg((a1!=null?a1.arg:null)); 
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:786:4: ( ',' ax= argDef )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==27) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:787:5: ',' ax= argDef
                    	    {
                    	    char_literal130=(Token)match(input,27,FOLLOW_27_in_functionSignatureSuffixNoName2234); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal130_tree = (Object)adaptor.create(char_literal130);
                    	    adaptor.addChild(root_0, char_literal130_tree);
                    	    }
                    	    pushFollow(FOLLOW_argDef_in_functionSignatureSuffixNoName2243);
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
                    	    break loop57;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal131=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffixNoName2258); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:795:1: structOrEnum returns [TypeRef type] : ( structCore | enumCore );
    public final ObjCppParser.structOrEnum_return structOrEnum() throws RecognitionException {
        ObjCppParser.structOrEnum_return retval = new ObjCppParser.structOrEnum_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.structCore_return structCore132 = null;

        ObjCppParser.enumCore_return enumCore133 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:796:2: ( structCore | enumCore )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( ((LA59_0>=45 && LA59_0<=47)) ) {
                alt59=1;
            }
            else if ( (LA59_0==30) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:797:3: structCore
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_structCore_in_structOrEnum2276);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:798:3: enumCore
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_enumCore_in_structOrEnum2284);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:801:1: typeRefCoreOrFuncSig returns [TypeRef type] : typeRefCore ( ( typeMutator )* functionSignatureSuffix )? ;
    public final ObjCppParser.typeRefCoreOrFuncSig_return typeRefCoreOrFuncSig() throws RecognitionException {
        ObjCppParser.typeRefCoreOrFuncSig_return retval = new ObjCppParser.typeRefCoreOrFuncSig_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.typeRefCore_return typeRefCore134 = null;

        ObjCppParser.typeMutator_return typeMutator135 = null;

        ObjCppParser.functionSignatureSuffix_return functionSignatureSuffix136 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:802:2: ( typeRefCore ( ( typeMutator )* functionSignatureSuffix )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:802:4: typeRefCore ( ( typeMutator )* functionSignatureSuffix )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_typeRefCore_in_typeRefCoreOrFuncSig2302);
            typeRefCore134=typeRefCore();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRefCore134.getTree());
            if ( state.backtracking==0 ) {
               retval.type = (typeRefCore134!=null?typeRefCore134.type:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:803:3: ( ( typeMutator )* functionSignatureSuffix )?
            int alt61=2;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:804:4: ( typeMutator )* functionSignatureSuffix
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:804:4: ( typeMutator )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==IDENTIFIER||(LA60_0>=51 && LA60_0<=53)) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:805:5: typeMutator
                    	    {
                    	    pushFollow(FOLLOW_typeMutator_in_typeRefCoreOrFuncSig2319);
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
                    	    break loop60;
                        }
                    } while (true);

                    pushFollow(FOLLOW_functionSignatureSuffix_in_typeRefCoreOrFuncSig2332);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:816:1: typeRefCoreOrAnonymousFuncSig returns [TypeRef type] : typeRefCore ( ( typeMutator )* functionSignatureSuffixNoName )? ;
    public final ObjCppParser.typeRefCoreOrAnonymousFuncSig_return typeRefCoreOrAnonymousFuncSig() throws RecognitionException {
        ObjCppParser.typeRefCoreOrAnonymousFuncSig_return retval = new ObjCppParser.typeRefCoreOrAnonymousFuncSig_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.typeRefCore_return typeRefCore137 = null;

        ObjCppParser.typeMutator_return typeMutator138 = null;

        ObjCppParser.functionSignatureSuffixNoName_return functionSignatureSuffixNoName139 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:817:2: ( typeRefCore ( ( typeMutator )* functionSignatureSuffixNoName )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:817:4: typeRefCore ( ( typeMutator )* functionSignatureSuffixNoName )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_typeRefCore_in_typeRefCoreOrAnonymousFuncSig2356);
            typeRefCore137=typeRefCore();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRefCore137.getTree());
            if ( state.backtracking==0 ) {
               retval.type = (typeRefCore137!=null?typeRefCore137.type:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:818:3: ( ( typeMutator )* functionSignatureSuffixNoName )?
            int alt63=2;
            alt63 = dfa63.predict(input);
            switch (alt63) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:819:4: ( typeMutator )* functionSignatureSuffixNoName
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:819:4: ( typeMutator )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==IDENTIFIER||(LA62_0>=51 && LA62_0<=53)) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:820:5: typeMutator
                    	    {
                    	    pushFollow(FOLLOW_typeMutator_in_typeRefCoreOrAnonymousFuncSig2373);
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
                    	    break loop62;
                        }
                    } while (true);

                    pushFollow(FOLLOW_functionSignatureSuffixNoName_in_typeRefCoreOrAnonymousFuncSig2386);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:831:1: plainTypeRef returns [TypeRef type] : ( structOrEnum | typeRefCoreOrFuncSig );
    public final ObjCppParser.plainTypeRef_return plainTypeRef() throws RecognitionException {
        ObjCppParser.plainTypeRef_return retval = new ObjCppParser.plainTypeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.structOrEnum_return structOrEnum140 = null;

        ObjCppParser.typeRefCoreOrFuncSig_return typeRefCoreOrFuncSig141 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:832:2: ( structOrEnum | typeRefCoreOrFuncSig )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==30||(LA64_0>=45 && LA64_0<=47)) ) {
                alt64=1;
            }
            else if ( (LA64_0==IDENTIFIER||(LA64_0>=60 && LA64_0<=74)) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:833:3: structOrEnum
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_structOrEnum_in_plainTypeRef2413);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:834:3: typeRefCoreOrFuncSig
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_typeRefCoreOrFuncSig_in_plainTypeRef2421);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:837:1: declarator returns [Declarator declarator, List<Modifier> modifiers] : ({...}? modifier )* ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? ) ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:838:2: ( ({...}? modifier )* ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:838:4: ({...}? modifier )* ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:839:3: ({...}? modifier )*
            loop65:
            do {
                int alt65=2;
                alt65 = dfa65.predict(input);
                switch (alt65) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:840:4: {...}? modifier
            	    {
            	    if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "declarator", " next(Modifier.Kind.TypeQualifier) ");
            	    }
            	    pushFollow(FOLLOW_modifier_in_declarator2450);
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
            	    break loop65;
                }
            } while (true);

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:847:3: ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:848:4: ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )?
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:848:4: ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( ((LA66_0>=51 && LA66_0<=52)||LA66_0==58) ) {
                alt66=1;
            }
            else if ( (LA66_0==IDENTIFIER||LA66_0==34) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:849:5: (pt= ( '*' | '&' | '^' ) inner= declarator )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:849:5: (pt= ( '*' | '&' | '^' ) inner= declarator )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:850:6: pt= ( '*' | '&' | '^' ) inner= declarator
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

                    pushFollow(FOLLOW_declarator_in_declarator2506);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:855:5: directDeclarator
                    {
                    pushFollow(FOLLOW_directDeclarator_in_declarator2522);
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:859:4: ( '=' expression )?
            int alt67=2;
            alt67 = dfa67.predict(input);
            switch (alt67) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:860:5: '=' expression
                    {
                    char_literal144=(Token)match(input,29,FOLLOW_29_in_declarator2541); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal144_tree = (Object)adaptor.create(char_literal144);
                    adaptor.addChild(root_0, char_literal144_tree);
                    }
                    pushFollow(FOLLOW_expression_in_declarator2548);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:873:1: namedTypeRef returns [TaggedTypeRef type] : ( structCore {...}? | enumCore {...}?);
    public final ObjCppParser.namedTypeRef_return namedTypeRef() throws RecognitionException {
        ObjCppParser.namedTypeRef_return retval = new ObjCppParser.namedTypeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.structCore_return structCore146 = null;

        ObjCppParser.enumCore_return enumCore147 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:874:2: ( structCore {...}? | enumCore {...}?)
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( ((LA68_0>=45 && LA68_0<=47)) ) {
                alt68=1;
            }
            else if ( (LA68_0==30) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:875:3: structCore {...}?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_structCore_in_namedTypeRef2582);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:878:3: enumCore {...}?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_enumCore_in_namedTypeRef2592);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:883:1: typeDef returns [TypeDef typeDef] : 'typedef' varDecl {...}?;
    public final ObjCppParser.typeDef_return typeDef() throws RecognitionException {
        ObjCppParser.typeDef_return retval = new ObjCppParser.typeDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal148=null;
        ObjCppParser.varDecl_return varDecl149 = null;


        Object string_literal148_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:884:2: ( 'typedef' varDecl {...}?)
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:884:4: 'typedef' varDecl {...}?
            {
            root_0 = (Object)adaptor.nil();

            string_literal148=(Token)match(input,59,FOLLOW_59_in_typeDef2611); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal148_tree = (Object)adaptor.create(string_literal148);
            adaptor.addChild(root_0, string_literal148_tree);
            }
            pushFollow(FOLLOW_varDecl_in_typeDef2617);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:893:1: varDeclEOF returns [Declaration decl] : varDecl EOF ;
    public final ObjCppParser.varDeclEOF_return varDeclEOF() throws RecognitionException {
        ObjCppParser.varDeclEOF_return retval = new ObjCppParser.varDeclEOF_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF151=null;
        ObjCppParser.varDecl_return varDecl150 = null;


        Object EOF151_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:894:2: ( varDecl EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:894:4: varDecl EOF
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_varDecl_in_varDeclEOF2637);
            varDecl150=varDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl150.getTree());
            EOF151=(Token)match(input,EOF,FOLLOW_EOF_in_varDeclEOF2639); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:897:1: varDecl returns [Declaration decl, TypeRef type] : ({...}?sm= modifier | {...}?tm= modifier )* ( ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList ) ) ';' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:901:2: ( ({...}?sm= modifier | {...}?tm= modifier )* ( ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList ) ) ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:901:4: ({...}?sm= modifier | {...}?tm= modifier )* ( ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList ) ) ';'
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:901:4: ({...}?sm= modifier | {...}?tm= modifier )*
            loop69:
            do {
                int alt69=3;
                alt69 = dfa69.predict(input);
                switch (alt69) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:902:4: {...}?sm= modifier
            	    {
            	    if ( !(( next(Modifier.Kind.StorageClassSpecifier) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "varDecl", " next(Modifier.Kind.StorageClassSpecifier) ");
            	    }
            	    pushFollow(FOLLOW_modifier_in_varDecl2675);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:904:4: {...}?tm= modifier
            	    {
            	    if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "varDecl", " next(Modifier.Kind.TypeQualifier) ");
            	    }
            	    pushFollow(FOLLOW_modifier_in_varDecl2692);
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
            	    break loop69;
                }
            } while (true);

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:907:3: ( ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:911:4: ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList )
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:911:4: ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==30||(LA71_0>=45 && LA71_0<=47)) ) {
                alt71=1;
            }
            else if ( (LA71_0==IDENTIFIER||(LA71_0>=60 && LA71_0<=74)) ) {
                alt71=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:912:5: structOrEnum ( (d1= declaratorsList )? )
                    {
                    pushFollow(FOLLOW_structOrEnum_in_varDecl2719);
                    structOrEnum152=structOrEnum();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structOrEnum152.getTree());
                    if ( state.backtracking==0 ) {
                       
                      					retval.type = (structOrEnum152!=null?structOrEnum152.type:null);
                      					//retval.decl = new VariablesDeclaration(retval.type);
                      				
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:916:5: ( (d1= declaratorsList )? )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:917:6: (d1= declaratorsList )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:917:8: (d1= declaratorsList )?
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==IDENTIFIER||LA70_0==34||(LA70_0>=51 && LA70_0<=52)||LA70_0==58) ) {
                        alt70=1;
                    }
                    switch (alt70) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: d1= declaratorsList
                            {
                            pushFollow(FOLLOW_declaratorsList_in_varDecl2736);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:924:5: tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList
                    {
                    pushFollow(FOLLOW_typeRefCoreOrAnonymousFuncSig_in_varDecl2756);
                    tcfs=typeRefCoreOrAnonymousFuncSig();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tcfs.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (tcfs!=null?tcfs.type:null); 
                    }
                    pushFollow(FOLLOW_declaratorsList_in_varDecl2766);
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

            char_literal153=(Token)match(input,28,FOLLOW_28_in_varDecl2803); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:953:1: objCProtocolRefList : '<' IDENTIFIER ( ',' IDENTIFIER )* '>' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:954:2: ( '<' IDENTIFIER ( ',' IDENTIFIER )* '>' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:954:4: '<' IDENTIFIER ( ',' IDENTIFIER )* '>'
            {
            root_0 = (Object)adaptor.nil();

            char_literal154=(Token)match(input,36,FOLLOW_36_in_objCProtocolRefList2817); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal154_tree = (Object)adaptor.create(char_literal154);
            adaptor.addChild(root_0, char_literal154_tree);
            }
            IDENTIFIER155=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCProtocolRefList2822); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER155_tree = (Object)adaptor.create(IDENTIFIER155);
            adaptor.addChild(root_0, IDENTIFIER155_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:956:3: ( ',' IDENTIFIER )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==27) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:957:4: ',' IDENTIFIER
            	    {
            	    char_literal156=(Token)match(input,27,FOLLOW_27_in_objCProtocolRefList2832); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal156_tree = (Object)adaptor.create(char_literal156);
            	    adaptor.addChild(root_0, char_literal156_tree);
            	    }
            	    IDENTIFIER157=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCProtocolRefList2838); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDENTIFIER157_tree = (Object)adaptor.create(IDENTIFIER157);
            	    adaptor.addChild(root_0, IDENTIFIER157_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);

            char_literal158=(Token)match(input,37,FOLLOW_37_in_objCProtocolRefList2848); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:970:1: declaratorsList returns [List<Declarator> declarators] : (d= declarator ( ',' x= declarator )* ) ;
    public final ObjCppParser.declaratorsList_return declaratorsList() throws RecognitionException {
        ObjCppParser.declaratorsList_return retval = new ObjCppParser.declaratorsList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal159=null;
        ObjCppParser.declarator_return d = null;

        ObjCppParser.declarator_return x = null;


        Object char_literal159_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:971:2: ( (d= declarator ( ',' x= declarator )* ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:971:4: (d= declarator ( ',' x= declarator )* )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.declarators = new ArrayList<Declarator>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:972:3: (d= declarator ( ',' x= declarator )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:973:4: d= declarator ( ',' x= declarator )*
            {
            pushFollow(FOLLOW_declarator_in_declaratorsList2875);
            d=declarator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());
            if ( state.backtracking==0 ) {
               retval.declarators.add((d!=null?d.declarator:null)); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:974:4: ( ',' x= declarator )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==27) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:975:5: ',' x= declarator
            	    {
            	    char_literal159=(Token)match(input,27,FOLLOW_27_in_declaratorsList2888); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal159_tree = (Object)adaptor.create(char_literal159);
            	    adaptor.addChild(root_0, char_literal159_tree);
            	    }
            	    pushFollow(FOLLOW_declarator_in_declaratorsList2897);
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
            	    break loop73;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:981:1: directDeclarator returns [Declarator declarator] : ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' ) ( '[' ( expression | ) ']' | argList )* ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:985:2: ( ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' ) ( '[' ( expression | ) ']' | argList )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:985:4: ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' ) ( '[' ( expression | ) ']' | argList )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:985:4: ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==IDENTIFIER) ) {
                alt75=1;
            }
            else if ( (LA75_0==34) ) {
                alt75=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:987:4: IDENTIFIER
                    {
                    IDENTIFIER160=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_directDeclarator2940); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:990:4: '(' (im= modifier )* inner= declarator ')'
                    {
                    char_literal161=(Token)match(input,34,FOLLOW_34_in_directDeclarator2950); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal161_tree = (Object)adaptor.create(char_literal161);
                    adaptor.addChild(root_0, char_literal161_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:991:4: (im= modifier )*
                    loop74:
                    do {
                        int alt74=2;
                        alt74 = dfa74.predict(input);
                        switch (alt74) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:991:5: im= modifier
                    	    {
                    	    pushFollow(FOLLOW_modifier_in_directDeclarator2959);
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
                    	    break loop74;
                        }
                    } while (true);

                    pushFollow(FOLLOW_declarator_in_directDeclarator2970);
                    inner=declarator();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inner.getTree());
                    char_literal162=(Token)match(input,35,FOLLOW_35_in_directDeclarator2976); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal162_tree = (Object)adaptor.create(char_literal162);
                    adaptor.addChild(root_0, char_literal162_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				retval.declarator = (inner!=null?inner.declarator:null);
                      				if (retval.declarator != null) {
                      					retval.declarator.setParenthesized(true);
                      					retval.declarator.addModifiers(modifiers);
                      				}
                      			
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1001:3: ( '[' ( expression | ) ']' | argList )*
            loop77:
            do {
                int alt77=3;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==53) ) {
                    alt77=1;
                }
                else if ( (LA77_0==34) ) {
                    alt77=2;
                }


                switch (alt77) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1002:4: '[' ( expression | ) ']'
            	    {
            	    char_literal163=(Token)match(input,53,FOLLOW_53_in_directDeclarator2991); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal163_tree = (Object)adaptor.create(char_literal163);
            	    adaptor.addChild(root_0, char_literal163_tree);
            	    }
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1003:4: ( expression | )
            	    int alt76=2;
            	    alt76 = dfa76.predict(input);
            	    switch (alt76) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1004:5: expression
            	            {
            	            pushFollow(FOLLOW_expression_in_directDeclarator3003);
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
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1009:9: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              					retval.declarator = new ArrayDeclarator(retval.declarator, new Expression.EmptyArraySize());
            	              				
            	            }

            	            }
            	            break;

            	    }

            	    char_literal165=(Token)match(input,54,FOLLOW_54_in_directDeclarator3019); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal165_tree = (Object)adaptor.create(char_literal165);
            	    adaptor.addChild(root_0, char_literal165_tree);
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1014:4: argList
            	    {
            	    pushFollow(FOLLOW_argList_in_directDeclarator3027);
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
            	    break loop77;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1020:1: argList returns [List<Arg> args, boolean isObjC] : op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1021:2: (op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1021:4: op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               
              			retval.isObjC = false; 
              			retval.args = new ArrayList<Arg>();
              		
            }
            op=(Token)match(input,34,FOLLOW_34_in_argList3055); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            op_tree = (Object)adaptor.create(op);
            adaptor.addChild(root_0, op_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1026:3: (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==IDENTIFIER||LA80_0==30||(LA80_0>=44 && LA80_0<=47)||(LA80_0>=60 && LA80_0<=74)) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1027:4: a1= argDef ( ',' ax= argDef )* ( ',' '...' )?
                    {
                    pushFollow(FOLLOW_argDef_in_argList3067);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {

                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					retval.args.add((a1!=null?a1.arg:null));
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1031:4: ( ',' ax= argDef )*
                    loop78:
                    do {
                        int alt78=2;
                        alt78 = dfa78.predict(input);
                        switch (alt78) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1032:5: ',' ax= argDef
                    	    {
                    	    char_literal167=(Token)match(input,27,FOLLOW_27_in_argList3080); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal167_tree = (Object)adaptor.create(char_literal167);
                    	    adaptor.addChild(root_0, char_literal167_tree);
                    	    }
                    	    pushFollow(FOLLOW_argDef_in_argList3089);
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
                    	    break loop78;
                        }
                    } while (true);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1037:4: ( ',' '...' )?
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( (LA79_0==27) ) {
                        alt79=1;
                    }
                    switch (alt79) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1038:5: ',' '...'
                            {
                            char_literal168=(Token)match(input,27,FOLLOW_27_in_argList3109); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal168_tree = (Object)adaptor.create(char_literal168);
                            adaptor.addChild(root_0, char_literal168_tree);
                            }
                            string_literal169=(Token)match(input,44,FOLLOW_44_in_argList3111); if (state.failed) return retval;
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

            cp=(Token)match(input,35,FOLLOW_35_in_argList3130); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1047:1: typeRef returns [TypeRef type] : plainTypeRef ( typeMutator )* ;
    public final ObjCppParser.typeRef_return typeRef() throws RecognitionException {
        ObjCppParser.typeRef_return retval = new ObjCppParser.typeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.plainTypeRef_return plainTypeRef170 = null;

        ObjCppParser.typeMutator_return typeMutator171 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1048:2: ( plainTypeRef ( typeMutator )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1049:3: plainTypeRef ( typeMutator )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_plainTypeRef_in_typeRef3148);
            plainTypeRef170=plainTypeRef();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, plainTypeRef170.getTree());
            if ( state.backtracking==0 ) {

              			retval.type = (plainTypeRef170!=null?plainTypeRef170.type:null);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1052:3: ( typeMutator )*
            loop81:
            do {
                int alt81=2;
                alt81 = dfa81.predict(input);
                switch (alt81) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1053:4: typeMutator
            	    {
            	    pushFollow(FOLLOW_typeMutator_in_typeRef3159);
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
            	    break loop81;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1059:1: primSignModifier : ( 'signed' | 'unsigned' | '__signed' | '__unsigned' );
    public final ObjCppParser.primSignModifier_return primSignModifier() throws RecognitionException {
        ObjCppParser.primSignModifier_return retval = new ObjCppParser.primSignModifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set172=null;

        Object set172_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1060:2: ( 'signed' | 'unsigned' | '__signed' | '__unsigned' )
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1062:1: primSizeModifier : ( 'long' | 'short' );
    public final ObjCppParser.primSizeModifier_return primSizeModifier() throws RecognitionException {
        ObjCppParser.primSizeModifier_return retval = new ObjCppParser.primSizeModifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set173=null;

        Object set173_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1063:2: ( 'long' | 'short' )
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1065:1: primitiveTypeName : ( 'long' | 'int' | 'short' | 'double' | 'float' | 'char' | 'void' | '__int8' | '__int16' | '__int32' | '__int64' );
    public final ObjCppParser.primitiveTypeName_return primitiveTypeName() throws RecognitionException {
        ObjCppParser.primitiveTypeName_return retval = new ObjCppParser.primitiveTypeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set174=null;

        Object set174_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1066:2: ( 'long' | 'int' | 'short' | 'double' | 'float' | 'char' | 'void' | '__int8' | '__int16' | '__int32' | '__int64' )
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1078:1: primitiveTypeRef returns [TypeRef type, int line, List<Modifier> modifiers] : ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) ) ;
    public final ObjCppParser.primitiveTypeRef_return primitiveTypeRef() throws RecognitionException {
        ObjCppParser.primitiveTypeRef_return retval = new ObjCppParser.primitiveTypeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.primSignModifier_return mod1 = null;

        ObjCppParser.primSizeModifier_return mod2 = null;

        ObjCppParser.primSizeModifier_return mod3 = null;

        ObjCppParser.primitiveTypeName_return name = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1079:2: ( ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1079:4: ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               
              			retval.line = getLine(); 
              			retval.modifiers = new ArrayList<Modifier>();
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1083:3: ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1084:4: (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName )
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1084:8: (mod1= primSignModifier )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( ((LA82_0>=60 && LA82_0<=63)) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: mod1= primSignModifier
                    {
                    pushFollow(FOLLOW_primSignModifier_in_primitiveTypeRef3298);
                    mod1=primSignModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mod1.getTree());

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1085:4: (mod2= primSizeModifier (mod3= primSizeModifier )? )?
            int alt84=2;
            alt84 = dfa84.predict(input);
            switch (alt84) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1085:5: mod2= primSizeModifier (mod3= primSizeModifier )?
                    {
                    pushFollow(FOLLOW_primSizeModifier_in_primitiveTypeRef3309);
                    mod2=primSizeModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mod2.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1086:8: (mod3= primSizeModifier )?
                    int alt83=2;
                    alt83 = dfa83.predict(input);
                    switch (alt83) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: mod3= primSizeModifier
                            {
                            pushFollow(FOLLOW_primSizeModifier_in_primitiveTypeRef3316);
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1094:4: (name= primitiveTypeName )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1097:5: name= primitiveTypeName
            {
            pushFollow(FOLLOW_primitiveTypeName_in_primitiveTypeRef3359);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1126:1: objCMethodCall returns [FunctionCall expr] : '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1127:2: ( '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1128:3: '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']'
            {
            root_0 = (Object)adaptor.nil();

            char_literal175=(Token)match(input,53,FOLLOW_53_in_objCMethodCall3398); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal175_tree = (Object)adaptor.create(char_literal175);
            adaptor.addChild(root_0, char_literal175_tree);
            }
            pushFollow(FOLLOW_expression_in_objCMethodCall3402);
            target=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, target.getTree());
            methodName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodCall3406); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            methodName_tree = (Object)adaptor.create(methodName);
            adaptor.addChild(root_0, methodName_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.expr = new FunctionCall((methodName!=null?methodName.getText():null));
              			retval.expr.setTarget((target!=null?target.expr:null));
              			retval.expr.setMemberRefStyle(MemberRefStyle.SquareBrackets);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1133:3: ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==33) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1134:4: ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )*
                    {
                    char_literal176=(Token)match(input,33,FOLLOW_33_in_objCMethodCall3417); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal176_tree = (Object)adaptor.create(char_literal176);
                    adaptor.addChild(root_0, char_literal176_tree);
                    }
                    pushFollow(FOLLOW_expression_in_objCMethodCall3421);
                    arg1=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arg1.getTree());
                    if ( state.backtracking==0 ) {

                      				retval.expr.addArgument(null, (arg1!=null?arg1.expr:null));
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1137:4: (selx= IDENTIFIER ':' argx= expression )*
                    loop85:
                    do {
                        int alt85=2;
                        int LA85_0 = input.LA(1);

                        if ( (LA85_0==IDENTIFIER) ) {
                            alt85=1;
                        }


                        switch (alt85) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1138:5: selx= IDENTIFIER ':' argx= expression
                    	    {
                    	    selx=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodCall3436); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    selx_tree = (Object)adaptor.create(selx);
                    	    adaptor.addChild(root_0, selx_tree);
                    	    }
                    	    char_literal177=(Token)match(input,33,FOLLOW_33_in_objCMethodCall3438); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal177_tree = (Object)adaptor.create(char_literal177);
                    	    adaptor.addChild(root_0, char_literal177_tree);
                    	    }
                    	    pushFollow(FOLLOW_expression_in_objCMethodCall3442);
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
                    	    break loop85;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal178=(Token)match(input,54,FOLLOW_54_in_objCMethodCall3459); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1146:1: functionCall returns [FunctionCall expr] : ( 'sizeof' '(' typeRef ')' | IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')' );
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1147:2: ( 'sizeof' '(' typeRef ')' | IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')' )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==75) ) {
                alt89=1;
            }
            else if ( (LA89_0==IDENTIFIER) ) {
                alt89=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }
            switch (alt89) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1148:3: 'sizeof' '(' typeRef ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal179=(Token)match(input,75,FOLLOW_75_in_functionCall3479); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal179_tree = (Object)adaptor.create(string_literal179);
                    adaptor.addChild(root_0, string_literal179_tree);
                    }
                    char_literal180=(Token)match(input,34,FOLLOW_34_in_functionCall3481); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal180_tree = (Object)adaptor.create(char_literal180);
                    adaptor.addChild(root_0, char_literal180_tree);
                    }
                    pushFollow(FOLLOW_typeRef_in_functionCall3483);
                    typeRef181=typeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRef181.getTree());
                    char_literal182=(Token)match(input,35,FOLLOW_35_in_functionCall3485); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1152:3: IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    IDENTIFIER183=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionCall3493); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER183_tree = (Object)adaptor.create(IDENTIFIER183);
                    adaptor.addChild(root_0, IDENTIFIER183_tree);
                    }
                    char_literal184=(Token)match(input,34,FOLLOW_34_in_functionCall3495); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal184_tree = (Object)adaptor.create(char_literal184);
                    adaptor.addChild(root_0, char_literal184_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			retval.expr = new FunctionCall((IDENTIFIER183!=null?IDENTIFIER183.getText():null));
                      		
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1155:3: (a1= expression ( ',' ax= expression )* )?
                    int alt88=2;
                    alt88 = dfa88.predict(input);
                    switch (alt88) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1156:4: a1= expression ( ',' ax= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_functionCall3508);
                            a1=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                            if ( state.backtracking==0 ) {

                              				retval.expr.addArgument((a1!=null?a1.expr:null));
                              			
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1159:4: ( ',' ax= expression )*
                            loop87:
                            do {
                                int alt87=2;
                                int LA87_0 = input.LA(1);

                                if ( (LA87_0==27) ) {
                                    alt87=1;
                                }


                                switch (alt87) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1159:6: ',' ax= expression
                            	    {
                            	    char_literal185=(Token)match(input,27,FOLLOW_27_in_functionCall3517); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    char_literal185_tree = (Object)adaptor.create(char_literal185);
                            	    adaptor.addChild(root_0, char_literal185_tree);
                            	    }
                            	    pushFollow(FOLLOW_expression_in_functionCall3526);
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
                            	    break loop87;
                                }
                            } while (true);


                            }
                            break;

                    }

                    char_literal186=(Token)match(input,35,FOLLOW_35_in_functionCall3544); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1168:1: binaryOp : ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' );
    public final ObjCppParser.binaryOp_return binaryOp() throws RecognitionException {
        ObjCppParser.binaryOp_return retval = new ObjCppParser.binaryOp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set187=null;

        Object set187_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1168:10: ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' )
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1172:1: expression returns [Expression expr] : (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' ) (bop= binaryOp opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )* ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1173:2: ( (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' ) (bop= binaryOp opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1173:4: (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' ) (bop= binaryOp opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1173:4: (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' )
            int alt91=7;
            alt91 = dfa91.predict(input);
            switch (alt91) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1174:4: id= IDENTIFIER
                    {
                    id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression3650); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1177:4: fc1= functionCall
                    {
                    pushFollow(FOLLOW_functionCall_in_expression3661);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1180:4: objCMethodCall
                    {
                    pushFollow(FOLLOW_objCMethodCall_in_expression3670);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1183:4: prefixOp= ( '!' | '~' ) opd= expression
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

                    pushFollow(FOLLOW_expression_in_expression3691);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1186:4: '(' (par= expression ')' | typeRef ')' casted= expression )
                    {
                    char_literal189=(Token)match(input,34,FOLLOW_34_in_expression3700); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal189_tree = (Object)adaptor.create(char_literal189);
                    adaptor.addChild(root_0, char_literal189_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1186:8: (par= expression ')' | typeRef ')' casted= expression )
                    int alt90=2;
                    alt90 = dfa90.predict(input);
                    switch (alt90) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1187:5: par= expression ')'
                            {
                            pushFollow(FOLLOW_expression_in_expression3710);
                            par=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, par.getTree());
                            char_literal190=(Token)match(input,35,FOLLOW_35_in_expression3712); if (state.failed) return retval;
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
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1192:5: typeRef ')' casted= expression
                            {
                            pushFollow(FOLLOW_typeRef_in_expression3722);
                            typeRef191=typeRef();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRef191.getTree());
                            char_literal192=(Token)match(input,35,FOLLOW_35_in_expression3724); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal192_tree = (Object)adaptor.create(char_literal192);
                            adaptor.addChild(root_0, char_literal192_tree);
                            }
                            pushFollow(FOLLOW_expression_in_expression3728);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1196:4: constant
                    {
                    pushFollow(FOLLOW_constant_in_expression3743);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1197:4: '{' expression '}'
                    {
                    char_literal194=(Token)match(input,23,FOLLOW_23_in_expression3752); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal194_tree = (Object)adaptor.create(char_literal194);
                    adaptor.addChild(root_0, char_literal194_tree);
                    }
                    pushFollow(FOLLOW_expression_in_expression3754);
                    expression195=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression195.getTree());
                    char_literal196=(Token)match(input,24,FOLLOW_24_in_expression3756); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal196_tree = (Object)adaptor.create(char_literal196);
                    adaptor.addChild(root_0, char_literal196_tree);
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1199:3: (bop= binaryOp opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )*
            loop93:
            do {
                int alt93=6;
                alt93 = dfa93.predict(input);
                switch (alt93) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1200:4: bop= binaryOp opd2= expression
            	    {
            	    pushFollow(FOLLOW_binaryOp_in_expression3772);
            	    bop=binaryOp();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, bop.getTree());
            	    pushFollow(FOLLOW_expression_in_expression3779);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1204:4: '=' val= expression
            	    {
            	    char_literal197=(Token)match(input,29,FOLLOW_29_in_expression3788); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal197_tree = (Object)adaptor.create(char_literal197);
            	    adaptor.addChild(root_0, char_literal197_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression3792);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1207:4: '.' fieldName= IDENTIFIER
            	    {
            	    char_literal198=(Token)match(input,90,FOLLOW_90_in_expression3801); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal198_tree = (Object)adaptor.create(char_literal198);
            	    adaptor.addChild(root_0, char_literal198_tree);
            	    }
            	    fieldName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression3805); if (state.failed) return retval;
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1210:4: refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1210:13: ( ':' ':' | '-' '>' | '.' )
            	    int alt92=3;
            	    switch ( input.LA(1) ) {
            	    case 33:
            	        {
            	        alt92=1;
            	        }
            	        break;
            	    case 43:
            	        {
            	        alt92=2;
            	        }
            	        break;
            	    case 90:
            	        {
            	        alt92=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 92, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt92) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1210:14: ':' ':'
            	            {
            	            char_literal199=(Token)match(input,33,FOLLOW_33_in_expression3817); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal199_tree = (Object)adaptor.create(char_literal199);
            	            adaptor.addChild(root_0, char_literal199_tree);
            	            }
            	            char_literal200=(Token)match(input,33,FOLLOW_33_in_expression3819); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal200_tree = (Object)adaptor.create(char_literal200);
            	            adaptor.addChild(root_0, char_literal200_tree);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1210:24: '-' '>'
            	            {
            	            char_literal201=(Token)match(input,43,FOLLOW_43_in_expression3823); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal201_tree = (Object)adaptor.create(char_literal201);
            	            adaptor.addChild(root_0, char_literal201_tree);
            	            }
            	            char_literal202=(Token)match(input,37,FOLLOW_37_in_expression3825); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal202_tree = (Object)adaptor.create(char_literal202);
            	            adaptor.addChild(root_0, char_literal202_tree);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1210:34: '.'
            	            {
            	            char_literal203=(Token)match(input,90,FOLLOW_90_in_expression3829); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal203_tree = (Object)adaptor.create(char_literal203);
            	            adaptor.addChild(root_0, char_literal203_tree);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_functionCall_in_expression3834);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1217:7: '?' xif= expression ':' xelse= expression
            	    {
            	    char_literal204=(Token)match(input,91,FOLLOW_91_in_expression3846); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal204_tree = (Object)adaptor.create(char_literal204);
            	    adaptor.addChild(root_0, char_literal204_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression3850);
            	    xif=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, xif.getTree());
            	    char_literal205=(Token)match(input,33,FOLLOW_33_in_expression3852); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal205_tree = (Object)adaptor.create(char_literal205);
            	    adaptor.addChild(root_0, char_literal205_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression3856);
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
    // $ANTLR end "expression"

    public static class statementsBlock_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statementsBlock"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1224:1: statementsBlock : '{' ( statement )* '}' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1225:2: ( '{' ( statement )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1225:4: '{' ( statement )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal206=(Token)match(input,23,FOLLOW_23_in_statementsBlock3879); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal206_tree = (Object)adaptor.create(char_literal206);
            adaptor.addChild(root_0, char_literal206_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1225:8: ( statement )*
            loop94:
            do {
                int alt94=2;
                alt94 = dfa94.predict(input);
                switch (alt94) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_statementsBlock3881);
            	    statement207=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement207.getTree());

            	    }
            	    break;

            	default :
            	    break loop94;
                }
            } while (true);

            char_literal208=(Token)match(input,24,FOLLOW_24_in_statementsBlock3884); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1227:1: statement : ( statementsBlock | declaration | expression ( '=' expression )? ';' | 'return' expression ';' | 'if' '(' expression ')' statement ( 'else' statement )? | 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement );
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1228:2: ( statementsBlock | declaration | expression ( '=' expression )? ';' | 'return' expression ';' | 'if' '(' expression ')' statement ( 'else' statement )? | 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement )
            int alt101=11;
            alt101 = dfa101.predict(input);
            switch (alt101) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1229:3: statementsBlock
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_statementsBlock_in_statement3897);
                    statementsBlock209=statementsBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementsBlock209.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1230:3: declaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_declaration_in_statement3903);
                    declaration210=declaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration210.getTree());

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1231:3: expression ( '=' expression )? ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_expression_in_statement3909);
                    expression211=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression211.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1231:14: ( '=' expression )?
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( (LA95_0==29) ) {
                        alt95=1;
                    }
                    switch (alt95) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1231:15: '=' expression
                            {
                            char_literal212=(Token)match(input,29,FOLLOW_29_in_statement3912); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal212_tree = (Object)adaptor.create(char_literal212);
                            adaptor.addChild(root_0, char_literal212_tree);
                            }
                            pushFollow(FOLLOW_expression_in_statement3914);
                            expression213=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression213.getTree());

                            }
                            break;

                    }

                    char_literal214=(Token)match(input,28,FOLLOW_28_in_statement3919); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal214_tree = (Object)adaptor.create(char_literal214);
                    adaptor.addChild(root_0, char_literal214_tree);
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1232:3: 'return' expression ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal215=(Token)match(input,55,FOLLOW_55_in_statement3925); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal215_tree = (Object)adaptor.create(string_literal215);
                    adaptor.addChild(root_0, string_literal215_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3927);
                    expression216=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression216.getTree());
                    char_literal217=(Token)match(input,28,FOLLOW_28_in_statement3929); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal217_tree = (Object)adaptor.create(char_literal217);
                    adaptor.addChild(root_0, char_literal217_tree);
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1233:3: 'if' '(' expression ')' statement ( 'else' statement )?
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal218=(Token)match(input,92,FOLLOW_92_in_statement3935); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal218_tree = (Object)adaptor.create(string_literal218);
                    adaptor.addChild(root_0, string_literal218_tree);
                    }
                    char_literal219=(Token)match(input,34,FOLLOW_34_in_statement3937); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal219_tree = (Object)adaptor.create(char_literal219);
                    adaptor.addChild(root_0, char_literal219_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3939);
                    expression220=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression220.getTree());
                    char_literal221=(Token)match(input,35,FOLLOW_35_in_statement3941); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal221_tree = (Object)adaptor.create(char_literal221);
                    adaptor.addChild(root_0, char_literal221_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement3943);
                    statement222=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement222.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1233:37: ( 'else' statement )?
                    int alt96=2;
                    alt96 = dfa96.predict(input);
                    switch (alt96) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1233:38: 'else' statement
                            {
                            string_literal223=(Token)match(input,93,FOLLOW_93_in_statement3946); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal223_tree = (Object)adaptor.create(string_literal223);
                            adaptor.addChild(root_0, string_literal223_tree);
                            }
                            pushFollow(FOLLOW_statement_in_statement3948);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1234:3: 'while' '(' expression ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal225=(Token)match(input,94,FOLLOW_94_in_statement3956); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal225_tree = (Object)adaptor.create(string_literal225);
                    adaptor.addChild(root_0, string_literal225_tree);
                    }
                    char_literal226=(Token)match(input,34,FOLLOW_34_in_statement3958); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal226_tree = (Object)adaptor.create(char_literal226);
                    adaptor.addChild(root_0, char_literal226_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3960);
                    expression227=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression227.getTree());
                    char_literal228=(Token)match(input,35,FOLLOW_35_in_statement3962); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal228_tree = (Object)adaptor.create(char_literal228);
                    adaptor.addChild(root_0, char_literal228_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement3964);
                    statement229=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement229.getTree());

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1235:3: 'do' statement 'while' '(' expression ')' ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal230=(Token)match(input,95,FOLLOW_95_in_statement3970); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal230_tree = (Object)adaptor.create(string_literal230);
                    adaptor.addChild(root_0, string_literal230_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement3972);
                    statement231=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement231.getTree());
                    string_literal232=(Token)match(input,94,FOLLOW_94_in_statement3974); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal232_tree = (Object)adaptor.create(string_literal232);
                    adaptor.addChild(root_0, string_literal232_tree);
                    }
                    char_literal233=(Token)match(input,34,FOLLOW_34_in_statement3976); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal233_tree = (Object)adaptor.create(char_literal233);
                    adaptor.addChild(root_0, char_literal233_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3978);
                    expression234=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression234.getTree());
                    char_literal235=(Token)match(input,35,FOLLOW_35_in_statement3980); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal235_tree = (Object)adaptor.create(char_literal235);
                    adaptor.addChild(root_0, char_literal235_tree);
                    }
                    char_literal236=(Token)match(input,28,FOLLOW_28_in_statement3982); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal236_tree = (Object)adaptor.create(char_literal236);
                    adaptor.addChild(root_0, char_literal236_tree);
                    }

                    }
                    break;
                case 8 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1236:3: 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal237=(Token)match(input,96,FOLLOW_96_in_statement3988); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal237_tree = (Object)adaptor.create(string_literal237);
                    adaptor.addChild(root_0, string_literal237_tree);
                    }
                    char_literal238=(Token)match(input,34,FOLLOW_34_in_statement3990); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal238_tree = (Object)adaptor.create(char_literal238);
                    adaptor.addChild(root_0, char_literal238_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1236:13: ( statement )?
                    int alt97=2;
                    alt97 = dfa97.predict(input);
                    switch (alt97) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: statement
                            {
                            pushFollow(FOLLOW_statement_in_statement3992);
                            statement239=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement239.getTree());

                            }
                            break;

                    }

                    char_literal240=(Token)match(input,28,FOLLOW_28_in_statement3995); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal240_tree = (Object)adaptor.create(char_literal240);
                    adaptor.addChild(root_0, char_literal240_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1236:28: ( expression )?
                    int alt98=2;
                    alt98 = dfa98.predict(input);
                    switch (alt98) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement3997);
                            expression241=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression241.getTree());

                            }
                            break;

                    }

                    char_literal242=(Token)match(input,28,FOLLOW_28_in_statement4000); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal242_tree = (Object)adaptor.create(char_literal242);
                    adaptor.addChild(root_0, char_literal242_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1236:44: ( statement )?
                    int alt99=2;
                    alt99 = dfa99.predict(input);
                    switch (alt99) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: statement
                            {
                            pushFollow(FOLLOW_statement_in_statement4002);
                            statement243=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement243.getTree());

                            }
                            break;

                    }

                    char_literal244=(Token)match(input,35,FOLLOW_35_in_statement4005); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal244_tree = (Object)adaptor.create(char_literal244);
                    adaptor.addChild(root_0, char_literal244_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement4007);
                    statement245=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement245.getTree());

                    }
                    break;
                case 9 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1237:3: 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal246=(Token)match(input,97,FOLLOW_97_in_statement4013); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal246_tree = (Object)adaptor.create(string_literal246);
                    adaptor.addChild(root_0, string_literal246_tree);
                    }
                    char_literal247=(Token)match(input,34,FOLLOW_34_in_statement4015); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal247_tree = (Object)adaptor.create(char_literal247);
                    adaptor.addChild(root_0, char_literal247_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement4017);
                    expression248=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression248.getTree());
                    char_literal249=(Token)match(input,35,FOLLOW_35_in_statement4019); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal249_tree = (Object)adaptor.create(char_literal249);
                    adaptor.addChild(root_0, char_literal249_tree);
                    }
                    char_literal250=(Token)match(input,23,FOLLOW_23_in_statement4021); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal250_tree = (Object)adaptor.create(char_literal250);
                    adaptor.addChild(root_0, char_literal250_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1238:3: ( 'case' expression ':' | statement )*
                    loop100:
                    do {
                        int alt100=3;
                        alt100 = dfa100.predict(input);
                        switch (alt100) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1238:5: 'case' expression ':'
                    	    {
                    	    string_literal251=(Token)match(input,98,FOLLOW_98_in_statement4027); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    string_literal251_tree = (Object)adaptor.create(string_literal251);
                    	    adaptor.addChild(root_0, string_literal251_tree);
                    	    }
                    	    pushFollow(FOLLOW_expression_in_statement4029);
                    	    expression252=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression252.getTree());
                    	    char_literal253=(Token)match(input,33,FOLLOW_33_in_statement4031); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal253_tree = (Object)adaptor.create(char_literal253);
                    	    adaptor.addChild(root_0, char_literal253_tree);
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1239:4: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement4038);
                    	    statement254=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement254.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop100;
                        }
                    } while (true);

                    char_literal255=(Token)match(input,24,FOLLOW_24_in_statement4047); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal255_tree = (Object)adaptor.create(char_literal255);
                    adaptor.addChild(root_0, char_literal255_tree);
                    }

                    }
                    break;
                case 10 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1242:3: ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal256=(Token)match(input,28,FOLLOW_28_in_statement4053); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal256_tree = (Object)adaptor.create(char_literal256);
                    adaptor.addChild(root_0, char_literal256_tree);
                    }

                    }
                    break;
                case 11 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1243:3: {...}? IDENTIFIER '(' varDecl ':' expression ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !(( next("foreach") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "statement", " next(\"foreach\") ");
                    }
                    IDENTIFIER257=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement4061); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER257_tree = (Object)adaptor.create(IDENTIFIER257);
                    adaptor.addChild(root_0, IDENTIFIER257_tree);
                    }
                    char_literal258=(Token)match(input,34,FOLLOW_34_in_statement4063); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal258_tree = (Object)adaptor.create(char_literal258);
                    adaptor.addChild(root_0, char_literal258_tree);
                    }
                    pushFollow(FOLLOW_varDecl_in_statement4065);
                    varDecl259=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl259.getTree());
                    char_literal260=(Token)match(input,33,FOLLOW_33_in_statement4067); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal260_tree = (Object)adaptor.create(char_literal260);
                    adaptor.addChild(root_0, char_literal260_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement4069);
                    expression261=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression261.getTree());
                    char_literal262=(Token)match(input,35,FOLLOW_35_in_statement4071); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal262_tree = (Object)adaptor.create(char_literal262);
                    adaptor.addChild(root_0, char_literal262_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement4073);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1246:1: constant returns [Constant constant] : ( DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER | CHARACTER | FLOAT_NUMBER | STRING );
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1247:2: ( DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER | CHARACTER | FLOAT_NUMBER | STRING )
            int alt102=6;
            switch ( input.LA(1) ) {
            case DECIMAL_NUMBER:
                {
                alt102=1;
                }
                break;
            case HEXADECIMAL_NUMBER:
                {
                alt102=2;
                }
                break;
            case OCTAL_NUMBER:
                {
                alt102=3;
                }
                break;
            case CHARACTER:
                {
                alt102=4;
                }
                break;
            case FLOAT_NUMBER:
                {
                alt102=5;
                }
                break;
            case STRING:
                {
                alt102=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }

            switch (alt102) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1247:4: DECIMAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    DECIMAL_NUMBER264=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_constant4089); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1248:3: HEXADECIMAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    HEXADECIMAL_NUMBER265=(Token)match(input,HEXADECIMAL_NUMBER,FOLLOW_HEXADECIMAL_NUMBER_in_constant4097); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1249:3: OCTAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    OCTAL_NUMBER266=(Token)match(input,OCTAL_NUMBER,FOLLOW_OCTAL_NUMBER_in_constant4105); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1250:3: CHARACTER
                    {
                    root_0 = (Object)adaptor.nil();

                    CHARACTER267=(Token)match(input,CHARACTER,FOLLOW_CHARACTER_in_constant4113); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1251:3: FLOAT_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    FLOAT_NUMBER268=(Token)match(input,FLOAT_NUMBER,FOLLOW_FLOAT_NUMBER_in_constant4121); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1253:3: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING269=(Token)match(input,STRING,FOLLOW_STRING_in_constant4132); if (state.failed) return retval;
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


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:386:7: (fv= varDecl )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:386:7: fv= varDecl
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

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:490:4: ( (n0= IDENTIFIER ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:490:4: (n0= IDENTIFIER )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:490:4: (n0= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:491:5: n0= IDENTIFIER
        {
        n0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred40_ObjCpp1115); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred40_ObjCpp

    // $ANTLR start synpred41_ObjCpp
    public final void synpred41_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:497:7: ( exportationModifiers )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:497:7: exportationModifiers
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


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:526:16: (returnTypeRef= typeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:526:16: returnTypeRef= typeRef
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

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:539:35: (ct= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:539:35: ct= IDENTIFIER
        {
        ct=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred48_ObjCpp1313); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_ObjCpp

    // $ANTLR start synpred50_ObjCpp
    public final void synpred50_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:562:4: ( exportationModifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:562:4: exportationModifier
        {
        pushFollow(FOLLOW_exportationModifier_in_synpred50_ObjCpp1389);
        exportationModifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_ObjCpp

    // $ANTLR start synpred53_ObjCpp
    public final void synpred53_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return sm = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:622:4: ({...}?sm= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:622:4: {...}?sm= modifier
        {
        if ( !(( next(Modifier.Kind.StorageClassSpecifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred53_ObjCpp", " next(Modifier.Kind.StorageClassSpecifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred53_ObjCpp1563);
        sm=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_ObjCpp

    // $ANTLR start synpred54_ObjCpp
    public final void synpred54_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return tm = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:624:4: ({...}?tm= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:624:4: {...}?tm= modifier
        {
        if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred54_ObjCpp", " next(Modifier.Kind.TypeQualifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred54_ObjCpp1580);
        tm=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_ObjCpp

    // $ANTLR start synpred62_ObjCpp
    public final void synpred62_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return m1a = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:714:4: ({...}?m1a= modifier '(' expression ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:714:4: {...}?m1a= modifier '(' expression ')'
        {
        if ( !(( next(Modifier.Kind.VCAnnotation1Arg) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred62_ObjCpp", " next(Modifier.Kind.VCAnnotation1Arg) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred62_ObjCpp1799);
        m1a=modifier();

        state._fsp--;
        if (state.failed) return ;
        match(input,34,FOLLOW_34_in_synpred62_ObjCpp1802); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred62_ObjCpp1804);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred62_ObjCpp1806); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred62_ObjCpp

    // $ANTLR start synpred63_ObjCpp
    public final void synpred63_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return m2a = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:715:4: ({...}?m2a= modifier '(' expression ',' expression ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:715:4: {...}?m2a= modifier '(' expression ',' expression ')'
        {
        if ( !(( next(Modifier.Kind.VCAnnotation2Args) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred63_ObjCpp", " next(Modifier.Kind.VCAnnotation2Args) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred63_ObjCpp1819);
        m2a=modifier();

        state._fsp--;
        if (state.failed) return ;
        match(input,34,FOLLOW_34_in_synpred63_ObjCpp1822); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred63_ObjCpp1824);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,27,FOLLOW_27_in_synpred63_ObjCpp1826); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred63_ObjCpp1828);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred63_ObjCpp1830); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred63_ObjCpp

    // $ANTLR start synpred64_ObjCpp
    public final void synpred64_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return m = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:717:4: ({...}?m= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:717:4: {...}?m= modifier
        {
        if ( !(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred64_ObjCpp", " next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred64_ObjCpp1847);
        m=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred64_ObjCpp

    // $ANTLR start synpred65_ObjCpp
    public final void synpred65_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return m1 = null;

        ObjCppParser.typeRef_return tr = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:719:4: ({...}?m1= modifier tr= typeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:719:4: {...}?m1= modifier tr= typeRef
        {
        if ( !(( next(Modifier.Kind.ReferenceQualifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred65_ObjCpp", " next(Modifier.Kind.ReferenceQualifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred65_ObjCpp1864);
        m1=modifier();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_typeRef_in_synpred65_ObjCpp1873);
        tr=typeRef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred65_ObjCpp

    // $ANTLR start synpred82_ObjCpp
    public final void synpred82_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:804:4: ( ( typeMutator )* functionSignatureSuffix )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:804:4: ( typeMutator )* functionSignatureSuffix
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:804:4: ( typeMutator )*
        loop124:
        do {
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==IDENTIFIER||(LA124_0>=51 && LA124_0<=53)) ) {
                alt124=1;
            }


            switch (alt124) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:805:5: typeMutator
        	    {
        	    pushFollow(FOLLOW_typeMutator_in_synpred82_ObjCpp2319);
        	    typeMutator();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop124;
            }
        } while (true);

        pushFollow(FOLLOW_functionSignatureSuffix_in_synpred82_ObjCpp2332);
        functionSignatureSuffix();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred82_ObjCpp

    // $ANTLR start synpred84_ObjCpp
    public final void synpred84_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:819:4: ( ( typeMutator )* functionSignatureSuffixNoName )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:819:4: ( typeMutator )* functionSignatureSuffixNoName
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:819:4: ( typeMutator )*
        loop125:
        do {
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==IDENTIFIER||(LA125_0>=51 && LA125_0<=53)) ) {
                alt125=1;
            }


            switch (alt125) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:820:5: typeMutator
        	    {
        	    pushFollow(FOLLOW_typeMutator_in_synpred84_ObjCpp2373);
        	    typeMutator();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop125;
            }
        } while (true);

        pushFollow(FOLLOW_functionSignatureSuffixNoName_in_synpred84_ObjCpp2386);
        functionSignatureSuffixNoName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred84_ObjCpp

    // $ANTLR start synpred86_ObjCpp
    public final void synpred86_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:840:4: ({...}? modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:840:4: {...}? modifier
        {
        if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred86_ObjCpp", " next(Modifier.Kind.TypeQualifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred86_ObjCpp2450);
        modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred86_ObjCpp

    // $ANTLR start synpred90_ObjCpp
    public final void synpred90_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:860:5: ( '=' expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:860:5: '=' expression
        {
        match(input,29,FOLLOW_29_in_synpred90_ObjCpp2541); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred90_ObjCpp2548);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred90_ObjCpp

    // $ANTLR start synpred92_ObjCpp
    public final void synpred92_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return sm = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:902:4: ({...}?sm= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:902:4: {...}?sm= modifier
        {
        if ( !(( next(Modifier.Kind.StorageClassSpecifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred92_ObjCpp", " next(Modifier.Kind.StorageClassSpecifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred92_ObjCpp2675);
        sm=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred92_ObjCpp

    // $ANTLR start synpred93_ObjCpp
    public final void synpred93_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return tm = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:904:4: ({...}?tm= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:904:4: {...}?tm= modifier
        {
        if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred93_ObjCpp", " next(Modifier.Kind.TypeQualifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred93_ObjCpp2692);
        tm=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred93_ObjCpp

    // $ANTLR start synpred99_ObjCpp
    public final void synpred99_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return im = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:991:5: (im= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:991:5: im= modifier
        {
        pushFollow(FOLLOW_modifier_in_synpred99_ObjCpp2959);
        im=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred99_ObjCpp

    // $ANTLR start synpred103_ObjCpp
    public final void synpred103_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.argDef_return ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1032:5: ( ',' ax= argDef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1032:5: ',' ax= argDef
        {
        match(input,27,FOLLOW_27_in_synpred103_ObjCpp3080); if (state.failed) return ;
        pushFollow(FOLLOW_argDef_in_synpred103_ObjCpp3089);
        ax=argDef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred103_ObjCpp

    // $ANTLR start synpred106_ObjCpp
    public final void synpred106_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1053:4: ( typeMutator )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1053:4: typeMutator
        {
        pushFollow(FOLLOW_typeMutator_in_synpred106_ObjCpp3159);
        typeMutator();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred106_ObjCpp

    // $ANTLR start synpred152_ObjCpp
    public final void synpred152_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.expression_return par = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1187:5: (par= expression ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1187:5: par= expression ')'
        {
        pushFollow(FOLLOW_expression_in_synpred152_ObjCpp3710);
        par=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred152_ObjCpp3712); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred152_ObjCpp

    // $ANTLR start synpred155_ObjCpp
    public final void synpred155_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.binaryOp_return bop = null;

        ObjCppParser.expression_return opd2 = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1200:4: (bop= binaryOp opd2= expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1200:4: bop= binaryOp opd2= expression
        {
        pushFollow(FOLLOW_binaryOp_in_synpred155_ObjCpp3772);
        bop=binaryOp();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred155_ObjCpp3779);
        opd2=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred155_ObjCpp

    // $ANTLR start synpred156_ObjCpp
    public final void synpred156_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.expression_return val = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1204:4: ( '=' val= expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1204:4: '=' val= expression
        {
        match(input,29,FOLLOW_29_in_synpred156_ObjCpp3788); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred156_ObjCpp3792);
        val=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred156_ObjCpp

    // $ANTLR start synpred157_ObjCpp
    public final void synpred157_ObjCpp_fragment() throws RecognitionException {   
        Token fieldName=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1207:4: ( '.' fieldName= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1207:4: '.' fieldName= IDENTIFIER
        {
        match(input,90,FOLLOW_90_in_synpred157_ObjCpp3801); if (state.failed) return ;
        fieldName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred157_ObjCpp3805); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred157_ObjCpp

    // $ANTLR start synpred160_ObjCpp
    public final void synpred160_ObjCpp_fragment() throws RecognitionException {   
        Token refStyle=null;
        ObjCppParser.functionCall_return fc2 = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1210:4: (refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1210:4: refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1210:13: ( ':' ':' | '-' '>' | '.' )
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
        case 90:
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
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1210:14: ':' ':'
                {
                match(input,33,FOLLOW_33_in_synpred160_ObjCpp3817); if (state.failed) return ;
                match(input,33,FOLLOW_33_in_synpred160_ObjCpp3819); if (state.failed) return ;

                }
                break;
            case 2 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1210:24: '-' '>'
                {
                match(input,43,FOLLOW_43_in_synpred160_ObjCpp3823); if (state.failed) return ;
                match(input,37,FOLLOW_37_in_synpred160_ObjCpp3825); if (state.failed) return ;

                }
                break;
            case 3 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1210:34: '.'
                {
                match(input,90,FOLLOW_90_in_synpred160_ObjCpp3829); if (state.failed) return ;

                }
                break;

        }

        pushFollow(FOLLOW_functionCall_in_synpred160_ObjCpp3834);
        fc2=functionCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred160_ObjCpp

    // $ANTLR start synpred161_ObjCpp
    public final void synpred161_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.expression_return xif = null;

        ObjCppParser.expression_return xelse = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1217:7: ( '?' xif= expression ':' xelse= expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1217:7: '?' xif= expression ':' xelse= expression
        {
        match(input,91,FOLLOW_91_in_synpred161_ObjCpp3846); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred161_ObjCpp3850);
        xif=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,33,FOLLOW_33_in_synpred161_ObjCpp3852); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred161_ObjCpp3856);
        xelse=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred161_ObjCpp

    // $ANTLR start synpred163_ObjCpp
    public final void synpred163_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1229:3: ( statementsBlock )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1229:3: statementsBlock
        {
        pushFollow(FOLLOW_statementsBlock_in_synpred163_ObjCpp3897);
        statementsBlock();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred163_ObjCpp

    // $ANTLR start synpred164_ObjCpp
    public final void synpred164_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1230:3: ( declaration )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1230:3: declaration
        {
        pushFollow(FOLLOW_declaration_in_synpred164_ObjCpp3903);
        declaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred164_ObjCpp

    // $ANTLR start synpred166_ObjCpp
    public final void synpred166_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1231:3: ( expression ( '=' expression )? ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1231:3: expression ( '=' expression )? ';'
        {
        pushFollow(FOLLOW_expression_in_synpred166_ObjCpp3909);
        expression();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1231:14: ( '=' expression )?
        int alt135=2;
        int LA135_0 = input.LA(1);

        if ( (LA135_0==29) ) {
            alt135=1;
        }
        switch (alt135) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1231:15: '=' expression
                {
                match(input,29,FOLLOW_29_in_synpred166_ObjCpp3912); if (state.failed) return ;
                pushFollow(FOLLOW_expression_in_synpred166_ObjCpp3914);
                expression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }

        match(input,28,FOLLOW_28_in_synpred166_ObjCpp3919); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred166_ObjCpp

    // $ANTLR start synpred168_ObjCpp
    public final void synpred168_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1233:38: ( 'else' statement )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1233:38: 'else' statement
        {
        match(input,93,FOLLOW_93_in_synpred168_ObjCpp3946); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred168_ObjCpp3948);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred168_ObjCpp

    // $ANTLR start synpred172_ObjCpp
    public final void synpred172_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1236:13: ( statement )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1236:13: statement
        {
        pushFollow(FOLLOW_statement_in_synpred172_ObjCpp3992);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred172_ObjCpp

    // Delegated rules

    public final boolean synpred103_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred103_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred93_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred93_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred172_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred172_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred54_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred64_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred64_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred106_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_ObjCpp_fragment(); // can never throw exception
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
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA43 dfa43 = new DFA43(this);
    protected DFA44 dfa44 = new DFA44(this);
    protected DFA49 dfa49 = new DFA49(this);
    protected DFA47 dfa47 = new DFA47(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA63 dfa63 = new DFA63(this);
    protected DFA65 dfa65 = new DFA65(this);
    protected DFA67 dfa67 = new DFA67(this);
    protected DFA69 dfa69 = new DFA69(this);
    protected DFA74 dfa74 = new DFA74(this);
    protected DFA76 dfa76 = new DFA76(this);
    protected DFA78 dfa78 = new DFA78(this);
    protected DFA81 dfa81 = new DFA81(this);
    protected DFA84 dfa84 = new DFA84(this);
    protected DFA83 dfa83 = new DFA83(this);
    protected DFA88 dfa88 = new DFA88(this);
    protected DFA91 dfa91 = new DFA91(this);
    protected DFA90 dfa90 = new DFA90(this);
    protected DFA93 dfa93 = new DFA93(this);
    protected DFA94 dfa94 = new DFA94(this);
    protected DFA101 dfa101 = new DFA101(this);
    protected DFA96 dfa96 = new DFA96(this);
    protected DFA97 dfa97 = new DFA97(this);
    protected DFA98 dfa98 = new DFA98(this);
    protected DFA99 dfa99 = new DFA99(this);
    protected DFA100 dfa100 = new DFA100(this);
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
        "\4\6\1\100\2\6\4\uffff\2\6\1\27\1\6\1\4\3\6\1\100\4\6\1\66\1\uffff"+
        "\10\6\1\66\1\6\1\uffff\3\6\1\66\1\6\1\uffff\3\0\1\uffff\2\0\2\uffff"+
        "\24\0\1\uffff\12\0\7\uffff\15\0\3\uffff\2\0\1\uffff\11\0\1\uffff"+
        "\5\0\1\uffff\5\0\1\uffff\5\0\1\uffff\17\0\1\uffff\5\0\1\uffff\6"+
        "\0\1\uffff\5\0\1\uffff\3\0\5\uffff\5\0\1\uffff\5\0\1\uffff\3\0\2"+
        "\uffff\3\0\5\uffff\5\0\1\uffff\5\0\1\uffff\3\0\2\uffff";
    static final String DFA6_maxS =
        "\1\112\2\27\3\112\1\72\4\uffff\1\72\1\112\1\27\1\6\1\131\2\27\3"+
        "\112\3\72\1\66\1\uffff\2\112\1\72\1\112\4\72\1\66\1\72\1\uffff\3"+
        "\72\1\66\1\72\1\uffff\3\0\1\uffff\2\0\2\uffff\24\0\1\uffff\12\0"+
        "\7\uffff\15\0\3\uffff\2\0\1\uffff\11\0\1\uffff\5\0\1\uffff\5\0\1"+
        "\uffff\5\0\1\uffff\17\0\1\uffff\5\0\1\uffff\6\0\1\uffff\5\0\1\uffff"+
        "\3\0\5\uffff\5\0\1\uffff\5\0\1\uffff\3\0\2\uffff\3\0\5\uffff\5\0"+
        "\1\uffff\5\0\1\uffff\3\0\2\uffff";
    static final String DFA6_acceptS =
        "\7\uffff\1\3\1\4\1\5\1\6\16\uffff\1\2\30\uffff\1\1\u00aa\uffff";
    static final String DFA6_specialS =
        "\53\uffff\1\0\1\1\1\2\1\uffff\1\3\1\4\2\uffff\1\5\1\6\1\7\1\10\1"+
        "\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
        "\1\26\1\27\1\30\1\uffff\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40"+
        "\1\41\1\42\7\uffff\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53"+
        "\1\54\1\55\1\56\1\57\3\uffff\1\60\1\61\1\uffff\1\62\1\63\1\64\1"+
        "\65\1\66\1\67\1\70\1\71\1\72\1\uffff\1\73\1\74\1\75\1\76\1\77\1"+
        "\uffff\1\100\1\101\1\102\1\103\1\104\1\uffff\1\105\1\106\1\107\1"+
        "\110\1\111\1\uffff\1\112\1\113\1\114\1\115\1\116\1\117\1\120\1\121"+
        "\1\122\1\123\1\124\1\125\1\126\1\127\1\130\1\uffff\1\131\1\132\1"+
        "\133\1\134\1\135\1\uffff\1\136\1\137\1\140\1\141\1\142\1\143\1\uffff"+
        "\1\144\1\145\1\146\1\147\1\150\1\uffff\1\151\1\152\1\153\5\uffff"+
        "\1\154\1\155\1\156\1\157\1\160\1\uffff\1\161\1\162\1\163\1\164\1"+
        "\165\1\uffff\1\166\1\167\1\170\2\uffff\1\171\1\172\1\173\5\uffff"+
        "\1\174\1\175\1\176\1\177\1\u0080\1\uffff\1\u0081\1\u0082\1\u0083"+
        "\1\u0084\1\u0085\1\uffff\1\u0086\1\u0087\1\u0088\2\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\3\22\uffff\1\12\1\11\3\uffff\1\2\2\7\14\uffff\3\1\13\uffff"+
            "\1\10\4\4\2\5\11\6",
            "\1\13\20\uffff\1\14",
            "\1\15\20\uffff\1\16",
            "\1\22\27\uffff\1\21\3\uffff\1\17\1\uffff\1\32\10\uffff\3\20"+
            "\3\uffff\1\26\1\27\1\30\4\uffff\1\31\1\uffff\4\23\2\24\11\25",
            "\2\33\11\34",
            "\1\37\33\uffff\1\43\20\uffff\1\40\1\41\1\42\4\uffff\1\31\5"+
            "\uffff\2\35\11\36",
            "\1\45\33\uffff\1\51\20\uffff\1\46\1\47\1\50\4\uffff\1\31",
            "",
            "",
            "",
            "",
            "\1\54\20\uffff\1\57\4\uffff\1\31\5\uffff\1\53\20\uffff\1\55"+
            "\1\60\1\62\4\uffff\1\31",
            "\1\70\21\uffff\1\100\1\77\1\76\3\uffff\1\67\2\74\14\uffff\3"+
            "\66\1\63\1\64\1\65\10\uffff\1\75\4\71\2\72\11\73",
            "\1\101",
            "\1\102",
            "\1\113\1\120\1\104\1\114\1\115\1\116\1\117\14\uffff\1\121\6"+
            "\uffff\1\62\3\uffff\1\106\1\62\10\uffff\4\62\3\uffff\1\105\1"+
            "\31\1\111\1\uffff\1\103\2\uffff\1\31\1\uffff\17\62\1\110\14"+
            "\uffff\2\112",
            "\1\131\20\uffff\1\132",
            "\1\133\20\uffff\1\134",
            "\1\141\24\uffff\3\31\1\140\3\uffff\1\135\1\uffff\1\152\10\uffff"+
            "\3\137\3\uffff\1\136\1\151\1\145\4\uffff\1\31\1\uffff\4\142"+
            "\2\143\11\144",
            "\2\154\11\155",
            "\1\160\33\uffff\1\164\20\uffff\1\161\1\162\1\163\4\uffff\1"+
            "\31\5\uffff\2\156\11\157",
            "\1\166\33\uffff\1\172\20\uffff\1\167\1\170\1\171\4\uffff\1"+
            "\31",
            "\1\175\33\uffff\1\174\20\uffff\1\176\1\177\1\u0080\4\uffff"+
            "\1\31",
            "\1\u0082\33\uffff\1\u0086\20\uffff\1\u0083\1\u0084\1\u0085"+
            "\4\uffff\1\31",
            "\1\u0088",
            "",
            "\1\u008b\27\uffff\1\u008a\6\uffff\1\u008f\7\uffff\3\u0089\14"+
            "\uffff\4\u008c\2\u008d\11\u008e",
            "\1\u0092\33\uffff\1\u0096\20\uffff\1\u0093\1\u0094\1\u0095"+
            "\4\uffff\1\31\5\uffff\2\u0090\11\u0091",
            "\1\u0098\33\uffff\1\u009c\20\uffff\1\u0099\1\u009a\1\u009b"+
            "\4\uffff\1\31",
            "\1\u009f\33\uffff\1\u00a3\20\uffff\1\u00a0\1\u00a1\1\u00a2"+
            "\4\uffff\1\31\5\uffff\13\u009e",
            "\1\u00a5\33\uffff\1\u00a9\20\uffff\1\u00a6\1\u00a7\1\u00a8"+
            "\4\uffff\1\31",
            "\1\u00ac\24\uffff\3\31\4\uffff\1\u00ad\20\uffff\1\u00ab\2\31"+
            "\4\uffff\1\31",
            "\1\u00b4\33\uffff\1\u00b3\20\uffff\1\u00b5\1\u00b6\1\u00b7"+
            "\4\uffff\1\31",
            "\1\u00b9\33\uffff\1\u00bd\20\uffff\1\u00ba\1\u00bb\1\u00bc"+
            "\4\uffff\1\31",
            "\1\u00bf",
            "\1\u00c0\33\uffff\1\31\20\uffff\1\u00c1\1\31\5\uffff\1\31",
            "",
            "\1\u00c5\24\uffff\3\31\4\uffff\1\u00c6\20\uffff\1\u00c4\2\31"+
            "\4\uffff\1\31",
            "\1\u00cd\33\uffff\1\u00cc\20\uffff\1\u00ce\1\u00cf\1\u00d0"+
            "\4\uffff\1\31",
            "\1\u00d2\33\uffff\1\u00d6\20\uffff\1\u00d3\1\u00d4\1\u00d5"+
            "\4\uffff\1\31",
            "\1\u00d8",
            "\1\u00d9\33\uffff\1\31\20\uffff\1\u00da\1\31\5\uffff\1\31",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
                        int LA6_47 = input.LA(1);

                         
                        int index6_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_47);
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

                        else if ( (((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
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
                        int LA6_70 = input.LA(1);

                         
                        int index6_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_70);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA6_72 = input.LA(1);

                         
                        int index6_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_72);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA6_73 = input.LA(1);

                         
                        int index6_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_73);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA6_74 = input.LA(1);

                         
                        int index6_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_74);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA6_75 = input.LA(1);

                         
                        int index6_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_75);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA6_76 = input.LA(1);

                         
                        int index6_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_76);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA6_77 = input.LA(1);

                         
                        int index6_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_77);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA6_78 = input.LA(1);

                         
                        int index6_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_78);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA6_79 = input.LA(1);

                         
                        int index6_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_79);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA6_80 = input.LA(1);

                         
                        int index6_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_80);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA6_81 = input.LA(1);

                         
                        int index6_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_81);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA6_89 = input.LA(1);

                         
                        int index6_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_89);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA6_90 = input.LA(1);

                         
                        int index6_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_90);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA6_91 = input.LA(1);

                         
                        int index6_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_91);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA6_92 = input.LA(1);

                         
                        int index6_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_92);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA6_93 = input.LA(1);

                         
                        int index6_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_93);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA6_94 = input.LA(1);

                         
                        int index6_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_94);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA6_95 = input.LA(1);

                         
                        int index6_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_95);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA6_96 = input.LA(1);

                         
                        int index6_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_96);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA6_97 = input.LA(1);

                         
                        int index6_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (((synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_97);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA6_98 = input.LA(1);

                         
                        int index6_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_98);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA6_99 = input.LA(1);

                         
                        int index6_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_99);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA6_100 = input.LA(1);

                         
                        int index6_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_100);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA6_101 = input.LA(1);

                         
                        int index6_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_101);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA6_105 = input.LA(1);

                         
                        int index6_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred7_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_105);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA6_106 = input.LA(1);

                         
                        int index6_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_106);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA6_108 = input.LA(1);

                         
                        int index6_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_108);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA6_109 = input.LA(1);

                         
                        int index6_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_109);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA6_110 = input.LA(1);

                         
                        int index6_110 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_110);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA6_111 = input.LA(1);

                         
                        int index6_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_111);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA6_112 = input.LA(1);

                         
                        int index6_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_112);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA6_113 = input.LA(1);

                         
                        int index6_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_113);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA6_114 = input.LA(1);

                         
                        int index6_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_114);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA6_115 = input.LA(1);

                         
                        int index6_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_115);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA6_116 = input.LA(1);

                         
                        int index6_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_116);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA6_118 = input.LA(1);

                         
                        int index6_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_118);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA6_119 = input.LA(1);

                         
                        int index6_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_119);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA6_120 = input.LA(1);

                         
                        int index6_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_120);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA6_121 = input.LA(1);

                         
                        int index6_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_121);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA6_122 = input.LA(1);

                         
                        int index6_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( ((((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred7_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 25;}

                         
                        input.seek(index6_122);
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
                        int LA6_149 = input.LA(1);

                         
                        int index6_149 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_149);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA6_150 = input.LA(1);

                         
                        int index6_150 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_150);
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
                        int LA6_160 = input.LA(1);

                         
                        int index6_160 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_160);
                        if ( s>=0 ) return s;
                        break;
                    case 97 : 
                        int LA6_161 = input.LA(1);

                         
                        int index6_161 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_161);
                        if ( s>=0 ) return s;
                        break;
                    case 98 : 
                        int LA6_162 = input.LA(1);

                         
                        int index6_162 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_162);
                        if ( s>=0 ) return s;
                        break;
                    case 99 : 
                        int LA6_163 = input.LA(1);

                         
                        int index6_163 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_163);
                        if ( s>=0 ) return s;
                        break;
                    case 100 : 
                        int LA6_165 = input.LA(1);

                         
                        int index6_165 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_165);
                        if ( s>=0 ) return s;
                        break;
                    case 101 : 
                        int LA6_166 = input.LA(1);

                         
                        int index6_166 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_166);
                        if ( s>=0 ) return s;
                        break;
                    case 102 : 
                        int LA6_167 = input.LA(1);

                         
                        int index6_167 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_167);
                        if ( s>=0 ) return s;
                        break;
                    case 103 : 
                        int LA6_168 = input.LA(1);

                         
                        int index6_168 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_168);
                        if ( s>=0 ) return s;
                        break;
                    case 104 : 
                        int LA6_169 = input.LA(1);

                         
                        int index6_169 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_169);
                        if ( s>=0 ) return s;
                        break;
                    case 105 : 
                        int LA6_171 = input.LA(1);

                         
                        int index6_171 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_171);
                        if ( s>=0 ) return s;
                        break;
                    case 106 : 
                        int LA6_172 = input.LA(1);

                         
                        int index6_172 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_172);
                        if ( s>=0 ) return s;
                        break;
                    case 107 : 
                        int LA6_173 = input.LA(1);

                         
                        int index6_173 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_173);
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
                        int LA6_181 = input.LA(1);

                         
                        int index6_181 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_181);
                        if ( s>=0 ) return s;
                        break;
                    case 111 : 
                        int LA6_182 = input.LA(1);

                         
                        int index6_182 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_182);
                        if ( s>=0 ) return s;
                        break;
                    case 112 : 
                        int LA6_183 = input.LA(1);

                         
                        int index6_183 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_183);
                        if ( s>=0 ) return s;
                        break;
                    case 113 : 
                        int LA6_185 = input.LA(1);

                         
                        int index6_185 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_185);
                        if ( s>=0 ) return s;
                        break;
                    case 114 : 
                        int LA6_186 = input.LA(1);

                         
                        int index6_186 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_186);
                        if ( s>=0 ) return s;
                        break;
                    case 115 : 
                        int LA6_187 = input.LA(1);

                         
                        int index6_187 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_187);
                        if ( s>=0 ) return s;
                        break;
                    case 116 : 
                        int LA6_188 = input.LA(1);

                         
                        int index6_188 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_188);
                        if ( s>=0 ) return s;
                        break;
                    case 117 : 
                        int LA6_189 = input.LA(1);

                         
                        int index6_189 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_189);
                        if ( s>=0 ) return s;
                        break;
                    case 118 : 
                        int LA6_191 = input.LA(1);

                         
                        int index6_191 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_191);
                        if ( s>=0 ) return s;
                        break;
                    case 119 : 
                        int LA6_192 = input.LA(1);

                         
                        int index6_192 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_192);
                        if ( s>=0 ) return s;
                        break;
                    case 120 : 
                        int LA6_193 = input.LA(1);

                         
                        int index6_193 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_193);
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
                        int LA6_198 = input.LA(1);

                         
                        int index6_198 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 50;}

                        else if ( (synpred7_ObjCpp()) ) {s = 25;}

                         
                        input.seek(index6_198);
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
            return "358:3: ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' )";
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
            return "359:4: ( ':' parentClass= IDENTIFIER )?";
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
            return "369:3: ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )?";
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
            return "378:3: ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )?";
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
            return "()* loopback of 380:4: ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )*";
        }
    }
    static final String DFA17_eotS =
        "\u00e1\uffff";
    static final String DFA17_eofS =
        "\u00e1\uffff";
    static final String DFA17_minS =
        "\4\6\1\100\2\6\1\4\3\6\1\100\4\6\1\66\1\uffff\1\6\1\uffff\2\6\1"+
        "\27\10\6\1\66\1\6\2\uffff\3\6\1\66\1\6\2\uffff\3\0\1\uffff\33\0"+
        "\3\uffff\11\0\2\uffff\5\0\2\uffff\5\0\3\uffff\5\0\1\uffff\15\0\2"+
        "\uffff\30\0\2\uffff\5\0\2\uffff\6\0\2\uffff\5\0\2\uffff\1\0\7\uffff"+
        "\5\0\3\uffff\5\0\1\uffff\3\0\2\uffff\1\0\7\uffff\5\0\3\uffff\5\0"+
        "\1\uffff\3\0\2\uffff";
    static final String DFA17_maxS =
        "\2\112\2\27\2\112\1\72\1\131\2\27\3\112\3\72\1\66\1\uffff\1\112"+
        "\1\uffff\1\72\1\112\1\27\1\6\1\112\1\72\1\112\4\72\1\66\1\72\2\uffff"+
        "\3\72\1\66\1\72\2\uffff\3\0\1\uffff\33\0\3\uffff\11\0\2\uffff\5"+
        "\0\2\uffff\5\0\3\uffff\5\0\1\uffff\15\0\2\uffff\30\0\2\uffff\5\0"+
        "\2\uffff\6\0\2\uffff\5\0\2\uffff\1\0\7\uffff\5\0\3\uffff\5\0\1\uffff"+
        "\3\0\2\uffff\1\0\7\uffff\5\0\3\uffff\5\0\1\uffff\3\0\2\uffff";
    static final String DFA17_acceptS =
        "\21\uffff\1\2\1\uffff\1\1\u00cd\uffff";
    static final String DFA17_specialS =
        "\52\uffff\1\0\1\1\1\2\1\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
        "\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
        "\1\30\1\31\1\32\1\33\1\34\1\35\3\uffff\1\36\1\37\1\40\1\41\1\42"+
        "\1\43\1\44\1\45\1\46\2\uffff\1\47\1\50\1\51\1\52\1\53\2\uffff\1"+
        "\54\1\55\1\56\1\57\1\60\3\uffff\1\61\1\62\1\63\1\64\1\65\1\uffff"+
        "\1\66\1\67\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1"+
        "\102\2\uffff\1\103\1\104\1\105\1\106\1\107\1\110\1\111\1\112\1\113"+
        "\1\114\1\115\1\116\1\117\1\120\1\121\1\122\1\123\1\124\1\125\1\126"+
        "\1\127\1\130\1\131\1\132\2\uffff\1\133\1\134\1\135\1\136\1\137\2"+
        "\uffff\1\140\1\141\1\142\1\143\1\144\1\145\2\uffff\1\146\1\147\1"+
        "\150\1\151\1\152\2\uffff\1\153\7\uffff\1\154\1\155\1\156\1\157\1"+
        "\160\3\uffff\1\161\1\162\1\163\1\164\1\165\1\uffff\1\166\1\167\1"+
        "\170\2\uffff\1\171\7\uffff\1\172\1\173\1\174\1\175\1\176\3\uffff"+
        "\1\177\1\u0080\1\u0081\1\u0082\1\u0083\1\uffff\1\u0084\1\u0085\1"+
        "\u0086\2\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\1\27\uffff\1\3\16\uffff\3\2\14\uffff\4\4\2\5\11\6",
            "\1\12\25\uffff\1\21\1\uffff\1\11\3\uffff\1\7\1\uffff\1\22\10"+
            "\uffff\3\10\3\uffff\1\16\1\17\1\20\4\uffff\1\23\1\uffff\4\13"+
            "\2\14\11\15",
            "\1\24\20\uffff\1\25",
            "\1\26\20\uffff\1\27",
            "\2\30\11\31",
            "\1\34\25\uffff\1\21\5\uffff\1\40\20\uffff\1\35\1\36\1\37\4"+
            "\uffff\1\23\5\uffff\2\32\11\33",
            "\1\43\25\uffff\1\21\5\uffff\1\47\20\uffff\1\44\1\45\1\46\4"+
            "\uffff\1\23",
            "\1\62\1\67\1\53\1\63\1\64\1\65\1\66\14\uffff\1\70\12\uffff"+
            "\1\56\20\uffff\1\54\1\23\1\60\1\uffff\1\52\2\uffff\1\23\20\uffff"+
            "\1\57\14\uffff\2\61",
            "\1\71\20\uffff\1\72",
            "\1\73\20\uffff\1\74",
            "\1\101\24\uffff\1\23\1\107\1\23\1\100\3\uffff\1\75\1\uffff"+
            "\1\110\10\uffff\3\77\3\uffff\1\76\1\105\1\106\4\uffff\1\23\1"+
            "\uffff\4\102\2\103\11\104",
            "\2\114\11\115",
            "\1\120\25\uffff\1\21\5\uffff\1\124\20\uffff\1\121\1\122\1\123"+
            "\4\uffff\1\23\5\uffff\2\116\11\117",
            "\1\127\25\uffff\1\21\5\uffff\1\133\20\uffff\1\130\1\131\1\132"+
            "\4\uffff\1\23",
            "\1\137\25\uffff\1\21\5\uffff\1\136\20\uffff\1\140\1\141\1\142"+
            "\4\uffff\1\23",
            "\1\146\25\uffff\1\21\5\uffff\1\152\20\uffff\1\147\1\150\1\151"+
            "\4\uffff\1\23",
            "\1\154",
            "",
            "\1\157\27\uffff\1\156\6\uffff\1\163\7\uffff\3\155\14\uffff"+
            "\4\160\2\161\11\162",
            "",
            "\1\164\20\uffff\1\173\4\uffff\1\167\5\uffff\1\166\20\uffff"+
            "\1\165\1\170\1\21\4\uffff\1\23",
            "\1\u0081\21\uffff\1\u0089\1\u0088\1\u0087\3\uffff\1\u0080\2"+
            "\u0085\14\uffff\3\177\1\174\1\175\1\176\10\uffff\1\u0086\4\u0082"+
            "\2\u0083\11\u0084",
            "\1\u008a",
            "\1\u008b",
            "\1\u008e\25\uffff\1\21\5\uffff\1\u0092\20\uffff\1\u008f\1\u0090"+
            "\1\u0091\4\uffff\1\23\5\uffff\2\u008c\11\u008d",
            "\1\u0095\25\uffff\1\21\5\uffff\1\u0099\20\uffff\1\u0096\1\u0097"+
            "\1\u0098\4\uffff\1\23",
            "\1\u009d\25\uffff\1\21\5\uffff\1\u00a1\20\uffff\1\u009e\1\u009f"+
            "\1\u00a0\4\uffff\1\23\5\uffff\13\u009c",
            "\1\u00a4\25\uffff\1\21\5\uffff\1\u00a8\20\uffff\1\u00a5\1\u00a6"+
            "\1\u00a7\4\uffff\1\23",
            "\1\23\24\uffff\3\23\4\uffff\1\23\20\uffff\1\u00ab\2\23\4\uffff"+
            "\1\23",
            "\1\u00b4\25\uffff\1\21\5\uffff\1\u00b3\20\uffff\1\u00b5\1\u00b6"+
            "\1\u00b7\4\uffff\1\23",
            "\1\u00bb\25\uffff\1\21\5\uffff\1\u00bf\20\uffff\1\u00bc\1\u00bd"+
            "\1\u00be\4\uffff\1\23",
            "\1\u00c1",
            "\1\u00c2\33\uffff\1\23\20\uffff\1\u00c3\1\23\5\uffff\1\23",
            "",
            "",
            "\1\23\24\uffff\3\23\4\uffff\1\23\20\uffff\1\u00c6\2\23\4\uffff"+
            "\1\23",
            "\1\u00cf\25\uffff\1\21\5\uffff\1\u00ce\20\uffff\1\u00d0\1\u00d1"+
            "\1\u00d2\4\uffff\1\23",
            "\1\u00d6\25\uffff\1\21\5\uffff\1\u00da\20\uffff\1\u00d7\1\u00d8"+
            "\1\u00d9\4\uffff\1\23",
            "\1\u00dc",
            "\1\u00dd\33\uffff\1\23\20\uffff\1\u00de\1\23\5\uffff\1\23",
            "",
            "",
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
            return "385:6: (fv= varDecl | functionPointerVarDecl )";
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

                        else if ( (( "__success".equals(next()) )) ) {s = 17;}

                         
                        input.seek(index17_42);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_43 = input.LA(1);

                         
                        int index17_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 17;}

                         
                        input.seek(index17_43);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA17_44 = input.LA(1);

                         
                        int index17_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_44);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA17_46 = input.LA(1);

                         
                        int index17_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_46);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA17_47 = input.LA(1);

                         
                        int index17_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_47);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA17_48 = input.LA(1);

                         
                        int index17_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_48);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA17_49 = input.LA(1);

                         
                        int index17_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_49);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA17_50 = input.LA(1);

                         
                        int index17_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_50);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA17_51 = input.LA(1);

                         
                        int index17_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_51);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA17_52 = input.LA(1);

                         
                        int index17_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_52);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA17_53 = input.LA(1);

                         
                        int index17_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_53);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA17_54 = input.LA(1);

                         
                        int index17_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_54);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA17_55 = input.LA(1);

                         
                        int index17_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_55);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA17_56 = input.LA(1);

                         
                        int index17_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_56);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA17_57 = input.LA(1);

                         
                        int index17_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 17;}

                         
                        input.seek(index17_57);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA17_58 = input.LA(1);

                         
                        int index17_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 17;}

                         
                        input.seek(index17_58);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA17_59 = input.LA(1);

                         
                        int index17_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 17;}

                         
                        input.seek(index17_59);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA17_60 = input.LA(1);

                         
                        int index17_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 17;}

                         
                        input.seek(index17_60);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA17_61 = input.LA(1);

                         
                        int index17_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_61);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA17_62 = input.LA(1);

                         
                        int index17_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 17;}

                         
                        input.seek(index17_62);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA17_63 = input.LA(1);

                         
                        int index17_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_63);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA17_64 = input.LA(1);

                         
                        int index17_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_64);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA17_65 = input.LA(1);

                         
                        int index17_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_65);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA17_66 = input.LA(1);

                         
                        int index17_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_66);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA17_67 = input.LA(1);

                         
                        int index17_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_67);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA17_68 = input.LA(1);

                         
                        int index17_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_68);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA17_69 = input.LA(1);

                         
                        int index17_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_69);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA17_70 = input.LA(1);

                         
                        int index17_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_70);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA17_71 = input.LA(1);

                         
                        int index17_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_71);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA17_72 = input.LA(1);

                         
                        int index17_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_72);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA17_76 = input.LA(1);

                         
                        int index17_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_76);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA17_77 = input.LA(1);

                         
                        int index17_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_77);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA17_78 = input.LA(1);

                         
                        int index17_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_78);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA17_79 = input.LA(1);

                         
                        int index17_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_79);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA17_80 = input.LA(1);

                         
                        int index17_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_80);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA17_81 = input.LA(1);

                         
                        int index17_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_81);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA17_82 = input.LA(1);

                         
                        int index17_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_82);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA17_83 = input.LA(1);

                         
                        int index17_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_83);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA17_84 = input.LA(1);

                         
                        int index17_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_84);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA17_87 = input.LA(1);

                         
                        int index17_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_87);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA17_88 = input.LA(1);

                         
                        int index17_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_88);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA17_89 = input.LA(1);

                         
                        int index17_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_89);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA17_90 = input.LA(1);

                         
                        int index17_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_90);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA17_91 = input.LA(1);

                         
                        int index17_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred26_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                         
                        input.seek(index17_91);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA17_94 = input.LA(1);

                         
                        int index17_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_94);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA17_95 = input.LA(1);

                         
                        int index17_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_95);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA17_96 = input.LA(1);

                         
                        int index17_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_96);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA17_97 = input.LA(1);

                         
                        int index17_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_97);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA17_98 = input.LA(1);

                         
                        int index17_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_98);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA17_102 = input.LA(1);

                         
                        int index17_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_102);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA17_103 = input.LA(1);

                         
                        int index17_103 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_103);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA17_104 = input.LA(1);

                         
                        int index17_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_104);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA17_105 = input.LA(1);

                         
                        int index17_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_105);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA17_106 = input.LA(1);

                         
                        int index17_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_106);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA17_108 = input.LA(1);

                         
                        int index17_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_108);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA17_109 = input.LA(1);

                         
                        int index17_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_109);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA17_110 = input.LA(1);

                         
                        int index17_110 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_110);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA17_111 = input.LA(1);

                         
                        int index17_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_111);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA17_112 = input.LA(1);

                         
                        int index17_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_112);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA17_113 = input.LA(1);

                         
                        int index17_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_113);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA17_114 = input.LA(1);

                         
                        int index17_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_114);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA17_115 = input.LA(1);

                         
                        int index17_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred26_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 17;}

                         
                        input.seek(index17_115);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA17_116 = input.LA(1);

                         
                        int index17_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_116);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA17_117 = input.LA(1);

                         
                        int index17_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_117);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA17_118 = input.LA(1);

                         
                        int index17_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_118);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA17_119 = input.LA(1);

                         
                        int index17_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_119);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA17_120 = input.LA(1);

                         
                        int index17_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_120);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA17_123 = input.LA(1);

                         
                        int index17_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_123);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA17_124 = input.LA(1);

                         
                        int index17_124 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_124);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA17_125 = input.LA(1);

                         
                        int index17_125 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_125);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA17_126 = input.LA(1);

                         
                        int index17_126 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_126);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA17_127 = input.LA(1);

                         
                        int index17_127 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_127);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA17_128 = input.LA(1);

                         
                        int index17_128 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_128);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA17_129 = input.LA(1);

                         
                        int index17_129 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_129);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA17_130 = input.LA(1);

                         
                        int index17_130 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_130);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA17_131 = input.LA(1);

                         
                        int index17_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_131);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA17_132 = input.LA(1);

                         
                        int index17_132 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_132);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA17_133 = input.LA(1);

                         
                        int index17_133 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_133);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA17_134 = input.LA(1);

                         
                        int index17_134 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_134);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA17_135 = input.LA(1);

                         
                        int index17_135 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_135);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA17_136 = input.LA(1);

                         
                        int index17_136 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_136);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA17_137 = input.LA(1);

                         
                        int index17_137 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_137);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA17_138 = input.LA(1);

                         
                        int index17_138 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_138);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA17_139 = input.LA(1);

                         
                        int index17_139 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_139);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA17_140 = input.LA(1);

                         
                        int index17_140 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_140);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA17_141 = input.LA(1);

                         
                        int index17_141 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_141);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA17_142 = input.LA(1);

                         
                        int index17_142 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_142);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA17_143 = input.LA(1);

                         
                        int index17_143 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_143);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA17_144 = input.LA(1);

                         
                        int index17_144 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_144);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA17_145 = input.LA(1);

                         
                        int index17_145 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_145);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA17_146 = input.LA(1);

                         
                        int index17_146 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_146);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA17_149 = input.LA(1);

                         
                        int index17_149 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_149);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA17_150 = input.LA(1);

                         
                        int index17_150 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_150);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA17_151 = input.LA(1);

                         
                        int index17_151 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_151);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA17_152 = input.LA(1);

                         
                        int index17_152 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_152);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA17_153 = input.LA(1);

                         
                        int index17_153 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_153);
                        if ( s>=0 ) return s;
                        break;
                    case 96 : 
                        int LA17_156 = input.LA(1);

                         
                        int index17_156 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_156);
                        if ( s>=0 ) return s;
                        break;
                    case 97 : 
                        int LA17_157 = input.LA(1);

                         
                        int index17_157 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_157);
                        if ( s>=0 ) return s;
                        break;
                    case 98 : 
                        int LA17_158 = input.LA(1);

                         
                        int index17_158 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_158);
                        if ( s>=0 ) return s;
                        break;
                    case 99 : 
                        int LA17_159 = input.LA(1);

                         
                        int index17_159 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_159);
                        if ( s>=0 ) return s;
                        break;
                    case 100 : 
                        int LA17_160 = input.LA(1);

                         
                        int index17_160 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_160);
                        if ( s>=0 ) return s;
                        break;
                    case 101 : 
                        int LA17_161 = input.LA(1);

                         
                        int index17_161 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_161);
                        if ( s>=0 ) return s;
                        break;
                    case 102 : 
                        int LA17_164 = input.LA(1);

                         
                        int index17_164 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_164);
                        if ( s>=0 ) return s;
                        break;
                    case 103 : 
                        int LA17_165 = input.LA(1);

                         
                        int index17_165 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_165);
                        if ( s>=0 ) return s;
                        break;
                    case 104 : 
                        int LA17_166 = input.LA(1);

                         
                        int index17_166 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_166);
                        if ( s>=0 ) return s;
                        break;
                    case 105 : 
                        int LA17_167 = input.LA(1);

                         
                        int index17_167 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_167);
                        if ( s>=0 ) return s;
                        break;
                    case 106 : 
                        int LA17_168 = input.LA(1);

                         
                        int index17_168 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_168);
                        if ( s>=0 ) return s;
                        break;
                    case 107 : 
                        int LA17_171 = input.LA(1);

                         
                        int index17_171 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_171);
                        if ( s>=0 ) return s;
                        break;
                    case 108 : 
                        int LA17_179 = input.LA(1);

                         
                        int index17_179 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_179);
                        if ( s>=0 ) return s;
                        break;
                    case 109 : 
                        int LA17_180 = input.LA(1);

                         
                        int index17_180 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_180);
                        if ( s>=0 ) return s;
                        break;
                    case 110 : 
                        int LA17_181 = input.LA(1);

                         
                        int index17_181 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_181);
                        if ( s>=0 ) return s;
                        break;
                    case 111 : 
                        int LA17_182 = input.LA(1);

                         
                        int index17_182 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_182);
                        if ( s>=0 ) return s;
                        break;
                    case 112 : 
                        int LA17_183 = input.LA(1);

                         
                        int index17_183 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_183);
                        if ( s>=0 ) return s;
                        break;
                    case 113 : 
                        int LA17_187 = input.LA(1);

                         
                        int index17_187 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_187);
                        if ( s>=0 ) return s;
                        break;
                    case 114 : 
                        int LA17_188 = input.LA(1);

                         
                        int index17_188 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_188);
                        if ( s>=0 ) return s;
                        break;
                    case 115 : 
                        int LA17_189 = input.LA(1);

                         
                        int index17_189 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_189);
                        if ( s>=0 ) return s;
                        break;
                    case 116 : 
                        int LA17_190 = input.LA(1);

                         
                        int index17_190 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_190);
                        if ( s>=0 ) return s;
                        break;
                    case 117 : 
                        int LA17_191 = input.LA(1);

                         
                        int index17_191 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_191);
                        if ( s>=0 ) return s;
                        break;
                    case 118 : 
                        int LA17_193 = input.LA(1);

                         
                        int index17_193 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_193);
                        if ( s>=0 ) return s;
                        break;
                    case 119 : 
                        int LA17_194 = input.LA(1);

                         
                        int index17_194 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_194);
                        if ( s>=0 ) return s;
                        break;
                    case 120 : 
                        int LA17_195 = input.LA(1);

                         
                        int index17_195 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_195);
                        if ( s>=0 ) return s;
                        break;
                    case 121 : 
                        int LA17_198 = input.LA(1);

                         
                        int index17_198 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_198);
                        if ( s>=0 ) return s;
                        break;
                    case 122 : 
                        int LA17_206 = input.LA(1);

                         
                        int index17_206 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_206);
                        if ( s>=0 ) return s;
                        break;
                    case 123 : 
                        int LA17_207 = input.LA(1);

                         
                        int index17_207 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_207);
                        if ( s>=0 ) return s;
                        break;
                    case 124 : 
                        int LA17_208 = input.LA(1);

                         
                        int index17_208 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_208);
                        if ( s>=0 ) return s;
                        break;
                    case 125 : 
                        int LA17_209 = input.LA(1);

                         
                        int index17_209 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_209);
                        if ( s>=0 ) return s;
                        break;
                    case 126 : 
                        int LA17_210 = input.LA(1);

                         
                        int index17_210 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_210);
                        if ( s>=0 ) return s;
                        break;
                    case 127 : 
                        int LA17_214 = input.LA(1);

                         
                        int index17_214 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_214);
                        if ( s>=0 ) return s;
                        break;
                    case 128 : 
                        int LA17_215 = input.LA(1);

                         
                        int index17_215 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_215);
                        if ( s>=0 ) return s;
                        break;
                    case 129 : 
                        int LA17_216 = input.LA(1);

                         
                        int index17_216 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_216);
                        if ( s>=0 ) return s;
                        break;
                    case 130 : 
                        int LA17_217 = input.LA(1);

                         
                        int index17_217 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_217);
                        if ( s>=0 ) return s;
                        break;
                    case 131 : 
                        int LA17_218 = input.LA(1);

                         
                        int index17_218 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_218);
                        if ( s>=0 ) return s;
                        break;
                    case 132 : 
                        int LA17_220 = input.LA(1);

                         
                        int index17_220 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_220);
                        if ( s>=0 ) return s;
                        break;
                    case 133 : 
                        int LA17_221 = input.LA(1);

                         
                        int index17_221 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index17_221);
                        if ( s>=0 ) return s;
                        break;
                    case 134 : 
                        int LA17_222 = input.LA(1);

                         
                        int index17_222 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 17;}

                         
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
            return "()* loopback of 398:3: ( objCMethodDecl | typeDef | vd= varDecl {...}?)*";
        }
    }
    static final String DFA31_eotS =
        "\40\uffff";
    static final String DFA31_eofS =
        "\1\uffff\1\6\2\uffff\1\6\33\uffff";
    static final String DFA31_minS =
        "\2\6\1\uffff\2\6\13\uffff\1\0\5\uffff\1\0\1\uffff\1\0\7\uffff";
    static final String DFA31_maxS =
        "\1\27\1\72\1\uffff\2\72\13\uffff\1\0\5\uffff\1\0\1\uffff\1\0\7\uffff";
    static final String DFA31_acceptS =
        "\2\uffff\1\2\3\uffff\1\1\31\uffff";
    static final String DFA31_specialS =
        "\20\uffff\1\0\5\uffff\1\1\1\uffff\1\2\7\uffff}>";
    static final String[] DFA31_transitionS = {
            "\1\1\20\uffff\1\2",
            "\1\4\20\uffff\1\2\3\uffff\3\6\4\uffff\1\3\1\6\1\uffff\1\6\15"+
            "\uffff\3\6\4\uffff\1\6",
            "",
            "\1\20\33\uffff\1\6\1\2\17\uffff\2\6\5\uffff\1\6",
            "\1\30\20\uffff\1\2\3\uffff\3\6\4\uffff\1\26\1\6\17\uffff\3"+
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
            "\1\uffff",
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
            return "489:3: ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' )";
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
                        int LA31_22 = input.LA(1);

                         
                        int index31_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred40_ObjCpp()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index31_22);
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
            return "()* loopback of 503:5: ( ( 'public' | 'private' | 'protected' ) ':' | declaration )*";
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
            return "526:16: (returnTypeRef= typeRef )?";
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
                        if ( (((synpred47_ObjCpp()&&( "__success".equals(next()) ))||((synpred47_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred47_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||(synpred47_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred47_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred47_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 1;}

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
        "\1\2\1\13\62\uffff";
    static final String DFA35_minS =
        "\2\6\4\uffff\1\6\1\4\4\uffff\2\0\11\uffff\13\0\22\uffff";
    static final String DFA35_maxS =
        "\2\63\4\uffff\1\112\1\141\4\uffff\2\0\11\uffff\13\0\22\uffff";
    static final String DFA35_acceptS =
        "\2\uffff\1\2\5\uffff\1\1\2\uffff\1\1\50\uffff";
    static final String DFA35_specialS =
        "\14\uffff\1\0\1\1\11\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
        "\1\13\1\14\22\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\1\20\uffff\1\2\4\uffff\1\2\26\uffff\1\2",
            "\1\10\20\uffff\1\7\4\uffff\1\10\5\uffff\1\6\20\uffff\1\10",
            "",
            "",
            "",
            "",
            "\1\14\27\uffff\1\2\4\uffff\1\15\10\uffff\4\2\14\uffff\17\2",
            "\2\10\1\31\4\10\14\uffff\1\10\1\41\1\40\1\37\1\uffff\1\10\1"+
            "\uffff\1\30\2\35\1\uffff\1\10\12\uffff\3\27\3\2\2\uffff\1\10"+
            "\1\uffff\1\10\3\uffff\1\36\4\32\2\33\11\34\1\10\14\uffff\2\10"+
            "\2\uffff\1\10\1\uffff\4\10",
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
            return "()* loopback of 561:3: ( exportationModifier )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA35_12 = input.LA(1);

                         
                        int index35_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_12);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA35_13 = input.LA(1);

                         
                        int index35_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_13);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA35_23 = input.LA(1);

                         
                        int index35_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_23);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA35_24 = input.LA(1);

                         
                        int index35_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_24);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA35_25 = input.LA(1);

                         
                        int index35_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_25);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA35_26 = input.LA(1);

                         
                        int index35_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_26);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA35_27 = input.LA(1);

                         
                        int index35_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_27);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA35_28 = input.LA(1);

                         
                        int index35_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_28);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA35_29 = input.LA(1);

                         
                        int index35_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_29);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA35_30 = input.LA(1);

                         
                        int index35_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_30);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA35_31 = input.LA(1);

                         
                        int index35_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_31);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA35_32 = input.LA(1);

                         
                        int index35_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_32);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA35_33 = input.LA(1);

                         
                        int index35_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index35_33);
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
    static final String DFA38_eotS =
        "\31\uffff";
    static final String DFA38_eofS =
        "\31\uffff";
    static final String DFA38_minS =
        "\1\6\2\uffff\1\0\25\uffff";
    static final String DFA38_maxS =
        "\1\112\2\uffff\1\0\25\uffff";
    static final String DFA38_acceptS =
        "\1\uffff\1\3\25\uffff\1\1\1\2";
    static final String DFA38_specialS =
        "\3\uffff\1\0\25\uffff}>";
    static final String[] DFA38_transitionS = {
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
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "()* loopback of 621:3: ({...}?sm= modifier | {...}?tm= modifier )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA38_3 = input.LA(1);

                         
                        int index38_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred53_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 23;}

                        else if ( (((synpred54_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 24;}

                        else if ( ((( "__success".equals(next()) )||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 1;}

                         
                        input.seek(index38_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 38, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA43_eotS =
        "\50\uffff";
    static final String DFA43_eofS =
        "\1\uffff\1\2\46\uffff";
    static final String DFA43_minS =
        "\2\6\3\uffff\1\4\22\uffff\1\0\2\uffff\13\0\2\uffff";
    static final String DFA43_maxS =
        "\2\112\3\uffff\1\131\22\uffff\1\0\2\uffff\13\0\2\uffff";
    static final String DFA43_acceptS =
        "\2\uffff\1\4\24\uffff\1\1\16\uffff\1\2\1\3";
    static final String DFA43_specialS =
        "\30\uffff\1\0\2\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
        "\1\13\2\uffff}>";
    static final String[] DFA43_transitionS = {
            "\1\1\65\uffff\17\2",
            "\1\2\24\uffff\4\2\3\uffff\1\5\3\2\7\uffff\3\2\3\uffff\3\2\4"+
            "\uffff\1\2\1\uffff\17\2",
            "",
            "",
            "",
            "\1\37\1\44\1\30\1\40\1\41\1\42\1\43\14\uffff\1\45\12\uffff"+
            "\1\33\20\uffff\2\2\1\35\1\uffff\1\27\2\uffff\1\2\20\uffff\1"+
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
            return "710:3: ({...}? IDENTIFIER '(' 'return' binaryOp expression ')' | {...}?m1a= modifier '(' expression ')' | {...}?m2a= modifier '(' expression ',' expression ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA43_24 = input.LA(1);

                         
                        int index43_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred62_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred63_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 2;}

                         
                        input.seek(index43_24);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA43_27 = input.LA(1);

                         
                        int index43_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred62_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred63_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 2;}

                         
                        input.seek(index43_27);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA43_28 = input.LA(1);

                         
                        int index43_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred62_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred63_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index43_28);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA43_29 = input.LA(1);

                         
                        int index43_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred62_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred63_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index43_29);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA43_30 = input.LA(1);

                         
                        int index43_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred62_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred63_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index43_30);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA43_31 = input.LA(1);

                         
                        int index43_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred62_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred63_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index43_31);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA43_32 = input.LA(1);

                         
                        int index43_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred62_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred63_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index43_32);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA43_33 = input.LA(1);

                         
                        int index43_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred62_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred63_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index43_33);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA43_34 = input.LA(1);

                         
                        int index43_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred62_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred63_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index43_34);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA43_35 = input.LA(1);

                         
                        int index43_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred62_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred63_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index43_35);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA43_36 = input.LA(1);

                         
                        int index43_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred62_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred63_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index43_36);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA43_37 = input.LA(1);

                         
                        int index43_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred62_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred63_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index43_37);
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
    static final String DFA44_eotS =
        "\30\uffff";
    static final String DFA44_eofS =
        "\30\uffff";
    static final String DFA44_minS =
        "\1\6\1\0\26\uffff";
    static final String DFA44_maxS =
        "\1\112\1\0\26\uffff";
    static final String DFA44_acceptS =
        "\2\uffff\1\2\24\uffff\1\1";
    static final String DFA44_specialS =
        "\1\uffff\1\0\26\uffff}>";
    static final String[] DFA44_transitionS = {
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

    static final short[] DFA44_eot = DFA.unpackEncodedString(DFA44_eotS);
    static final short[] DFA44_eof = DFA.unpackEncodedString(DFA44_eofS);
    static final char[] DFA44_min = DFA.unpackEncodedStringToUnsignedChars(DFA44_minS);
    static final char[] DFA44_max = DFA.unpackEncodedStringToUnsignedChars(DFA44_maxS);
    static final short[] DFA44_accept = DFA.unpackEncodedString(DFA44_acceptS);
    static final short[] DFA44_special = DFA.unpackEncodedString(DFA44_specialS);
    static final short[][] DFA44_transition;

    static {
        int numStates = DFA44_transitionS.length;
        DFA44_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA44_transition[i] = DFA.unpackEncodedString(DFA44_transitionS[i]);
        }
    }

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = DFA44_eot;
            this.eof = DFA44_eof;
            this.min = DFA44_min;
            this.max = DFA44_max;
            this.accept = DFA44_accept;
            this.special = DFA44_special;
            this.transition = DFA44_transition;
        }
        public String getDescription() {
            return "717:3: ({...}?m= modifier )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA44_1 = input.LA(1);

                         
                        int index44_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred64_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 23;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 2;}

                         
                        input.seek(index44_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 44, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA49_eotS =
        "\51\uffff";
    static final String DFA49_eofS =
        "\1\uffff\1\2\47\uffff";
    static final String DFA49_minS =
        "\2\6\3\uffff\1\0\43\uffff";
    static final String DFA49_maxS =
        "\2\112\3\uffff\1\0\43\uffff";
    static final String DFA49_acceptS =
        "\2\uffff\1\2\17\uffff\1\1\26\uffff";
    static final String DFA49_specialS =
        "\5\uffff\1\0\43\uffff}>";
    static final String[] DFA49_transitionS = {
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

    static final short[] DFA49_eot = DFA.unpackEncodedString(DFA49_eotS);
    static final short[] DFA49_eof = DFA.unpackEncodedString(DFA49_eofS);
    static final char[] DFA49_min = DFA.unpackEncodedStringToUnsignedChars(DFA49_minS);
    static final char[] DFA49_max = DFA.unpackEncodedStringToUnsignedChars(DFA49_maxS);
    static final short[] DFA49_accept = DFA.unpackEncodedString(DFA49_acceptS);
    static final short[] DFA49_special = DFA.unpackEncodedString(DFA49_specialS);
    static final short[][] DFA49_transition;

    static {
        int numStates = DFA49_transitionS.length;
        DFA49_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA49_transition[i] = DFA.unpackEncodedString(DFA49_transitionS[i]);
        }
    }

    class DFA49 extends DFA {

        public DFA49(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 49;
            this.eot = DFA49_eot;
            this.eof = DFA49_eof;
            this.min = DFA49_min;
            this.max = DFA49_max;
            this.accept = DFA49_accept;
            this.special = DFA49_special;
            this.transition = DFA49_transition;
        }
        public String getDescription() {
            return "718:3: ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA49_5 = input.LA(1);

                         
                        int index49_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred65_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 18;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 2;}

                         
                        input.seek(index49_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 49, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA47_eotS =
        "\16\uffff";
    static final String DFA47_eofS =
        "\1\1\15\uffff";
    static final String DFA47_minS =
        "\1\6\15\uffff";
    static final String DFA47_maxS =
        "\1\72\15\uffff";
    static final String DFA47_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA47_specialS =
        "\16\uffff}>";
    static final String[] DFA47_transitionS = {
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
            return "724:64: ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' )";
        }
    }
    static final String DFA61_eotS =
        "\65\uffff";
    static final String DFA61_eofS =
        "\1\6\64\uffff";
    static final String DFA61_minS =
        "\1\6\5\0\57\uffff";
    static final String DFA61_maxS =
        "\1\72\5\0\57\uffff";
    static final String DFA61_acceptS =
        "\6\uffff\1\2\20\uffff\1\1\35\uffff";
    static final String DFA61_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\57\uffff}>";
    static final String[] DFA61_transitionS = {
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
            return "803:3: ( ( typeMutator )* functionSignatureSuffix )?";
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
                        if ( ((synpred82_ObjCpp()&&( next("const", "__const") ))) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA61_2 = input.LA(1);

                         
                        int index61_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA61_3 = input.LA(1);

                         
                        int index61_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA61_4 = input.LA(1);

                         
                        int index61_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA61_5 = input.LA(1);

                         
                        int index61_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred82_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index61_5);
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
        "\140\uffff";
    static final String DFA63_eofS =
        "\140\uffff";
    static final String DFA63_minS =
        "\4\6\1\uffff\1\6\1\uffff\1\6\7\uffff\4\6\2\uffff\4\6\2\uffff\2\6"+
        "\2\uffff\4\0\2\uffff\1\0\7\uffff\4\0\2\uffff\2\0\2\uffff\4\0\2\uffff"+
        "\2\0\2\uffff\1\0\7\uffff\4\0\2\uffff\4\0\2\uffff\3\0\10\uffff";
    static final String DFA63_maxS =
        "\4\72\1\uffff\1\72\1\uffff\1\72\7\uffff\4\72\2\uffff\4\72\2\uffff"+
        "\2\72\2\uffff\4\0\2\uffff\1\0\7\uffff\4\0\2\uffff\2\0\2\uffff\4"+
        "\0\2\uffff\2\0\2\uffff\1\0\7\uffff\4\0\2\uffff\4\0\2\uffff\3\0\10"+
        "\uffff";
    static final String DFA63_acceptS =
        "\4\uffff\1\1\1\uffff\1\2\131\uffff";
    static final String DFA63_specialS =
        "\37\uffff\1\0\1\1\1\2\1\3\2\uffff\1\4\7\uffff\1\5\1\6\1\7\1\10\2"+
        "\uffff\1\11\1\12\2\uffff\1\13\1\14\1\15\1\16\2\uffff\1\17\1\20\2"+
        "\uffff\1\21\7\uffff\1\22\1\23\1\24\1\25\2\uffff\1\26\1\27\1\30\1"+
        "\31\2\uffff\1\32\1\33\1\34\10\uffff}>";
    static final String[] DFA63_transitionS = {
            "\1\1\33\uffff\1\5\20\uffff\1\2\1\3\1\4\4\uffff\1\6",
            "\1\6\24\uffff\3\6\4\uffff\1\6\20\uffff\1\7\2\6\4\uffff\1\6",
            "\1\17\33\uffff\1\21\20\uffff\1\20\1\22\1\4\4\uffff\1\6",
            "\1\26\33\uffff\1\25\20\uffff\1\27\1\30\1\4\4\uffff\1\6",
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
            "\1\6\24\uffff\3\6\4\uffff\1\6\20\uffff\1\45\2\6\4\uffff\1\6",
            "\1\55\33\uffff\1\57\20\uffff\1\56\1\60\1\4\4\uffff\1\6",
            "\1\63\33\uffff\1\6\20\uffff\1\64\1\6\5\uffff\1\6",
            "\1\70\33\uffff\1\67\20\uffff\1\71\1\72\1\4\4\uffff\1\6",
            "",
            "",
            "\1\75\33\uffff\1\6\20\uffff\1\76\1\6\5\uffff\1\6",
            "\1\6\24\uffff\3\6\4\uffff\1\6\20\uffff\1\101\2\6\4\uffff\1"+
            "\6",
            "\1\111\33\uffff\1\113\20\uffff\1\112\1\114\1\4\4\uffff\1\6",
            "\1\120\33\uffff\1\117\20\uffff\1\121\1\122\1\4\4\uffff\1\6",
            "",
            "",
            "\1\127\26\uffff\1\6\4\uffff\1\125\1\6\17\uffff\1\126\2\6\4"+
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
            return "818:3: ( ( typeMutator )* functionSignatureSuffixNoName )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA63_31 = input.LA(1);

                         
                        int index63_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred84_ObjCpp()&&( next("const", "__const") ))) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_31);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA63_32 = input.LA(1);

                         
                        int index63_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred84_ObjCpp()&&( next("const", "__const") ))) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_32);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA63_33 = input.LA(1);

                         
                        int index63_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred84_ObjCpp()&&( next("const", "__const") ))) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_33);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA63_34 = input.LA(1);

                         
                        int index63_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred84_ObjCpp()&&( next("const", "__const") ))) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_34);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA63_37 = input.LA(1);

                         
                        int index63_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_37);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA63_45 = input.LA(1);

                         
                        int index63_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_45);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA63_46 = input.LA(1);

                         
                        int index63_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_46);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA63_47 = input.LA(1);

                         
                        int index63_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_47);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA63_48 = input.LA(1);

                         
                        int index63_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_48);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA63_51 = input.LA(1);

                         
                        int index63_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_51);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA63_52 = input.LA(1);

                         
                        int index63_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_52);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA63_55 = input.LA(1);

                         
                        int index63_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_55);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA63_56 = input.LA(1);

                         
                        int index63_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_56);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA63_57 = input.LA(1);

                         
                        int index63_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_57);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA63_58 = input.LA(1);

                         
                        int index63_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_58);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA63_61 = input.LA(1);

                         
                        int index63_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_61);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA63_62 = input.LA(1);

                         
                        int index63_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_62);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA63_65 = input.LA(1);

                         
                        int index63_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_65);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA63_73 = input.LA(1);

                         
                        int index63_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_73);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA63_74 = input.LA(1);

                         
                        int index63_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_74);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA63_75 = input.LA(1);

                         
                        int index63_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_75);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA63_76 = input.LA(1);

                         
                        int index63_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_76);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA63_79 = input.LA(1);

                         
                        int index63_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_79);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA63_80 = input.LA(1);

                         
                        int index63_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_80);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA63_81 = input.LA(1);

                         
                        int index63_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_81);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA63_82 = input.LA(1);

                         
                        int index63_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_82);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA63_85 = input.LA(1);

                         
                        int index63_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_85);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA63_86 = input.LA(1);

                         
                        int index63_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_86);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA63_87 = input.LA(1);

                         
                        int index63_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_87);
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
        "\27\uffff";
    static final String DFA65_eofS =
        "\2\uffff\1\1\24\uffff";
    static final String DFA65_minS =
        "\1\6\1\uffff\1\6\3\uffff\1\6\6\uffff\1\0\11\uffff";
    static final String DFA65_maxS =
        "\1\72\1\uffff\1\72\3\uffff\1\112\6\uffff\1\0\11\uffff";
    static final String DFA65_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\22\uffff";
    static final String DFA65_specialS =
        "\15\uffff\1\0\11\uffff}>";
    static final String[] DFA65_transitionS = {
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
            return "()* loopback of 839:3: ({...}? modifier )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA65_13 = input.LA(1);

                         
                        int index65_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred86_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 4;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_13);
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
        "\23\uffff";
    static final String DFA67_eofS =
        "\1\2\22\uffff";
    static final String DFA67_minS =
        "\1\33\1\0\21\uffff";
    static final String DFA67_maxS =
        "\1\43\1\0\21\uffff";
    static final String DFA67_acceptS =
        "\2\uffff\1\2\17\uffff\1\1";
    static final String DFA67_specialS =
        "\1\uffff\1\0\21\uffff}>";
    static final String[] DFA67_transitionS = {
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
            return "859:4: ( '=' expression )?";
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
                        if ( (synpred90_ObjCpp()) ) {s = 18;}

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
        "\25\uffff";
    static final String DFA69_eofS =
        "\25\uffff";
    static final String DFA69_minS =
        "\1\6\2\uffff\1\0\21\uffff";
    static final String DFA69_maxS =
        "\1\112\2\uffff\1\0\21\uffff";
    static final String DFA69_acceptS =
        "\1\uffff\1\3\21\uffff\1\1\1\2";
    static final String DFA69_specialS =
        "\3\uffff\1\0\21\uffff}>";
    static final String[] DFA69_transitionS = {
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
            return "()* loopback of 901:4: ({...}?sm= modifier | {...}?tm= modifier )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA69_3 = input.LA(1);

                         
                        int index69_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred92_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 19;}

                        else if ( (((synpred93_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 20;}

                        else if ( ((( "__success".equals(next()) )||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 1;}

                         
                        input.seek(index69_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 69, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA74_eotS =
        "\13\uffff";
    static final String DFA74_eofS =
        "\13\uffff";
    static final String DFA74_minS =
        "\1\6\1\0\11\uffff";
    static final String DFA74_maxS =
        "\1\72\1\0\11\uffff";
    static final String DFA74_acceptS =
        "\2\uffff\1\2\7\uffff\1\1";
    static final String DFA74_specialS =
        "\1\uffff\1\0\11\uffff}>";
    static final String[] DFA74_transitionS = {
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
            return "()* loopback of 991:4: (im= modifier )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA74_1 = input.LA(1);

                         
                        int index74_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred99_ObjCpp()&&( Modifier.parseModifier(next()) != null ))) ) {s = 10;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index74_1);
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
    static final String DFA76_eotS =
        "\16\uffff";
    static final String DFA76_eofS =
        "\16\uffff";
    static final String DFA76_minS =
        "\1\4\15\uffff";
    static final String DFA76_maxS =
        "\1\131\15\uffff";
    static final String DFA76_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA76_specialS =
        "\16\uffff}>";
    static final String[] DFA76_transitionS = {
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
            return "1003:4: ( expression | )";
        }
    }
    static final String DFA78_eotS =
        "\14\uffff";
    static final String DFA78_eofS =
        "\14\uffff";
    static final String DFA78_minS =
        "\1\33\1\6\1\uffff\1\0\10\uffff";
    static final String DFA78_maxS =
        "\1\43\1\112\1\uffff\1\0\10\uffff";
    static final String DFA78_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\7\uffff";
    static final String DFA78_specialS =
        "\3\uffff\1\0\10\uffff}>";
    static final String[] DFA78_transitionS = {
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

    static final short[] DFA78_eot = DFA.unpackEncodedString(DFA78_eotS);
    static final short[] DFA78_eof = DFA.unpackEncodedString(DFA78_eofS);
    static final char[] DFA78_min = DFA.unpackEncodedStringToUnsignedChars(DFA78_minS);
    static final char[] DFA78_max = DFA.unpackEncodedStringToUnsignedChars(DFA78_maxS);
    static final short[] DFA78_accept = DFA.unpackEncodedString(DFA78_acceptS);
    static final short[] DFA78_special = DFA.unpackEncodedString(DFA78_specialS);
    static final short[][] DFA78_transition;

    static {
        int numStates = DFA78_transitionS.length;
        DFA78_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA78_transition[i] = DFA.unpackEncodedString(DFA78_transitionS[i]);
        }
    }

    class DFA78 extends DFA {

        public DFA78(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 78;
            this.eot = DFA78_eot;
            this.eof = DFA78_eof;
            this.min = DFA78_min;
            this.max = DFA78_max;
            this.accept = DFA78_accept;
            this.special = DFA78_special;
            this.transition = DFA78_transition;
        }
        public String getDescription() {
            return "()* loopback of 1031:4: ( ',' ax= argDef )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA78_3 = input.LA(1);

                         
                        int index78_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred103_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index78_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 78, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA81_eotS =
        "\61\uffff";
    static final String DFA81_eofS =
        "\1\1\60\uffff";
    static final String DFA81_minS =
        "\1\6\2\uffff\2\0\4\uffff\1\0\1\uffff\1\0\45\uffff";
    static final String DFA81_maxS =
        "\1\72\2\uffff\2\0\4\uffff\1\0\1\uffff\1\0\45\uffff";
    static final String DFA81_acceptS =
        "\1\uffff\1\2\25\uffff\1\1\31\uffff";
    static final String DFA81_specialS =
        "\3\uffff\1\0\1\1\4\uffff\1\2\1\uffff\1\3\45\uffff}>";
    static final String[] DFA81_transitionS = {
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
            return "()* loopback of 1052:3: ( typeMutator )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA81_3 = input.LA(1);

                         
                        int index81_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred106_ObjCpp()&&( next("const", "__const") ))) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index81_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA81_4 = input.LA(1);

                         
                        int index81_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index81_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA81_9 = input.LA(1);

                         
                        int index81_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index81_9);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA81_11 = input.LA(1);

                         
                        int index81_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index81_11);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 81, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA84_eotS =
        "\21\uffff";
    static final String DFA84_eofS =
        "\1\uffff\1\2\17\uffff";
    static final String DFA84_minS =
        "\1\100\1\6\17\uffff";
    static final String DFA84_maxS =
        "\2\112\17\uffff";
    static final String DFA84_acceptS =
        "\2\uffff\1\2\1\1\15\uffff";
    static final String DFA84_specialS =
        "\21\uffff}>";
    static final String[] DFA84_transitionS = {
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
            return "1085:4: (mod2= primSizeModifier (mod3= primSizeModifier )? )?";
        }
    }
    static final String DFA83_eotS =
        "\20\uffff";
    static final String DFA83_eofS =
        "\1\uffff\1\2\16\uffff";
    static final String DFA83_minS =
        "\1\100\1\6\16\uffff";
    static final String DFA83_maxS =
        "\2\112\16\uffff";
    static final String DFA83_acceptS =
        "\2\uffff\1\2\1\1\14\uffff";
    static final String DFA83_specialS =
        "\20\uffff}>";
    static final String[] DFA83_transitionS = {
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
            return "1086:8: (mod3= primSizeModifier )?";
        }
    }
    static final String DFA88_eotS =
        "\16\uffff";
    static final String DFA88_eofS =
        "\16\uffff";
    static final String DFA88_minS =
        "\1\4\15\uffff";
    static final String DFA88_maxS =
        "\1\131\15\uffff";
    static final String DFA88_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA88_specialS =
        "\16\uffff}>";
    static final String[] DFA88_transitionS = {
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
            return "1155:3: (a1= expression ( ',' ax= expression )* )?";
        }
    }
    static final String DFA91_eotS =
        "\33\uffff";
    static final String DFA91_eofS =
        "\1\uffff\1\16\31\uffff";
    static final String DFA91_minS =
        "\1\4\1\6\31\uffff";
    static final String DFA91_maxS =
        "\1\131\1\133\31\uffff";
    static final String DFA91_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\5\uffff\1\7\1\uffff\1\1\14\uffff";
    static final String DFA91_specialS =
        "\33\uffff}>";
    static final String[] DFA91_transitionS = {
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
            return "1173:4: (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' )";
        }
    }
    static final String DFA90_eotS =
        "\173\uffff";
    static final String DFA90_eofS =
        "\32\uffff\1\2\140\uffff";
    static final String DFA90_minS =
        "\1\4\1\6\20\uffff\1\4\4\uffff\2\4\1\uffff\2\4\11\uffff\1\0\1\uffff"+
        "\13\0\1\uffff\1\0\1\uffff\1\0\1\uffff\1\0\13\uffff\1\0\2\uffff\1"+
        "\0\2\uffff\1\0\7\uffff\1\0\27\uffff\1\0\21\uffff";
    static final String DFA90_maxS =
        "\1\131\1\133\20\uffff\1\131\4\uffff\2\131\1\uffff\1\133\1\131\11"+
        "\uffff\1\0\1\uffff\13\0\1\uffff\1\0\1\uffff\1\0\1\uffff\1\0\13\uffff"+
        "\1\0\2\uffff\1\0\2\uffff\1\0\7\uffff\1\0\27\uffff\1\0\21\uffff";
    static final String DFA90_acceptS =
        "\2\uffff\1\1\12\uffff\1\2\155\uffff";
    static final String DFA90_specialS =
        "\45\uffff\1\0\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
        "\1\13\1\uffff\1\14\1\uffff\1\15\1\uffff\1\16\13\uffff\1\17\2\uffff"+
        "\1\20\2\uffff\1\21\7\uffff\1\22\27\uffff\1\23\21\uffff}>";
    static final String[] DFA90_transitionS = {
            "\2\2\1\1\4\2\14\uffff\1\2\6\uffff\1\15\3\uffff\1\2\12\uffff"+
            "\3\15\5\uffff\1\2\6\uffff\17\15\1\2\14\uffff\2\2",
            "\1\15\26\uffff\1\2\1\15\2\uffff\1\2\1\22\1\32\1\33\1\2\4\uffff"+
            "\2\2\1\uffff\3\15\3\uffff\1\27\1\30\1\15\4\uffff\1\2\1\uffff"+
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
            "\1\53\1\60\1\45\1\54\1\55\1\56\1\57\14\uffff\1\61\12\uffff"+
            "\1\52\1\2\17\uffff\1\15\1\uffff\1\50\1\uffff\1\15\23\uffff\1"+
            "\47\14\uffff\2\51",
            "",
            "",
            "",
            "",
            "\2\2\1\63\4\2\14\uffff\1\2\12\uffff\1\67\1\15\17\uffff\2\15"+
            "\1\65\25\uffff\1\2\14\uffff\2\2",
            "\2\2\1\103\4\2\14\uffff\1\2\12\uffff\1\111\1\15\17\uffff\2"+
            "\15\1\106\25\uffff\1\2\14\uffff\2\2",
            "",
            "\2\15\1\121\4\15\14\uffff\1\15\1\2\2\uffff\3\2\3\uffff\1\2"+
            "\1\15\3\2\4\uffff\2\2\7\uffff\2\2\1\15\1\2\3\uffff\1\2\20\uffff"+
            "\1\15\14\2\2\15\2\2",
            "\2\2\1\151\4\2\14\uffff\1\2\6\uffff\1\15\3\uffff\1\2\2\uffff"+
            "\1\15\7\uffff\3\15\5\uffff\1\2\6\uffff\17\15\1\2\14\uffff\2"+
            "\2",
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
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "1186:8: (par= expression ')' | typeRef ')' casted= expression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA90_37 = input.LA(1);

                         
                        int index90_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 13;}

                         
                        input.seek(index90_37);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA90_39 = input.LA(1);

                         
                        int index90_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index90_39);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA90_40 = input.LA(1);

                         
                        int index90_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index90_40);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA90_41 = input.LA(1);

                         
                        int index90_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index90_41);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA90_42 = input.LA(1);

                         
                        int index90_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index90_42);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA90_43 = input.LA(1);

                         
                        int index90_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index90_43);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA90_44 = input.LA(1);

                         
                        int index90_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index90_44);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA90_45 = input.LA(1);

                         
                        int index90_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index90_45);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA90_46 = input.LA(1);

                         
                        int index90_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index90_46);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA90_47 = input.LA(1);

                         
                        int index90_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index90_47);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA90_48 = input.LA(1);

                         
                        int index90_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index90_48);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA90_49 = input.LA(1);

                         
                        int index90_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index90_49);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA90_51 = input.LA(1);

                         
                        int index90_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index90_51);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA90_53 = input.LA(1);

                         
                        int index90_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index90_53);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA90_55 = input.LA(1);

                         
                        int index90_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index90_55);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA90_67 = input.LA(1);

                         
                        int index90_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index90_67);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA90_70 = input.LA(1);

                         
                        int index90_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index90_70);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA90_73 = input.LA(1);

                         
                        int index90_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index90_73);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA90_81 = input.LA(1);

                         
                        int index90_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index90_81);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA90_105 = input.LA(1);

                         
                        int index90_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index90_105);
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
    static final String DFA93_eotS =
        "\146\uffff";
    static final String DFA93_eofS =
        "\1\1\145\uffff";
    static final String DFA93_minS =
        "\1\6\5\uffff\1\0\2\uffff\5\0\130\uffff";
    static final String DFA93_maxS =
        "\1\133\5\uffff\1\0\2\uffff\5\0\130\uffff";
    static final String DFA93_acceptS =
        "\1\uffff\1\6\30\uffff\1\2\15\uffff\1\1\1\4\2\uffff\1\3\70\uffff"+
        "\1\5";
    static final String DFA93_specialS =
        "\6\uffff\1\0\2\uffff\1\1\1\2\1\3\1\4\1\5\130\uffff}>";
    static final String[] DFA93_transitionS = {
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
            return "()* loopback of 1199:3: (bop= binaryOp opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA93_6 = input.LA(1);

                         
                        int index93_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred156_ObjCpp()) ) {s = 26;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index93_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA93_9 = input.LA(1);

                         
                        int index93_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 40;}

                        else if ( (synpred160_ObjCpp()) ) {s = 41;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index93_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA93_10 = input.LA(1);

                         
                        int index93_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred157_ObjCpp()) ) {s = 44;}

                        else if ( (synpred160_ObjCpp()) ) {s = 41;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index93_10);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA93_11 = input.LA(1);

                         
                        int index93_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_ObjCpp()) ) {s = 41;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index93_11);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA93_12 = input.LA(1);

                         
                        int index93_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 40;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index93_12);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA93_13 = input.LA(1);

                         
                        int index93_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_ObjCpp()) ) {s = 101;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index93_13);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 93, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA94_eotS =
        "\36\uffff";
    static final String DFA94_eofS =
        "\36\uffff";
    static final String DFA94_minS =
        "\1\4\35\uffff";
    static final String DFA94_maxS =
        "\1\141\35\uffff";
    static final String DFA94_acceptS =
        "\1\uffff\1\2\1\1\33\uffff";
    static final String DFA94_specialS =
        "\36\uffff}>";
    static final String[] DFA94_transitionS = {
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
            return "()* loopback of 1225:8: ( statement )*";
        }
    }
    static final String DFA101_eotS =
        "\u012c\uffff";
    static final String DFA101_eofS =
        "\u012c\uffff";
    static final String DFA101_minS =
        "\2\4\2\uffff\1\6\30\uffff\1\4\2\uffff\1\6\7\uffff\1\42\3\4\6\30"+
        "\10\uffff\1\4\6\uffff\2\4\1\uffff\2\4\7\uffff\14\0\21\uffff\1\0"+
        "\1\uffff\2\0\1\uffff\2\0\5\uffff\6\0\2\uffff\60\0\2\uffff\6\0\2"+
        "\uffff\6\0\2\uffff\6\0\2\uffff\6\0\2\uffff\6\0\3\uffff\6\0\1\uffff"+
        "\14\0\2\uffff\2\0\2\uffff\1\0\12\uffff\1\0\1\uffff\1\0\2\uffff\1"+
        "\0\13\uffff\1\0\17\uffff\1\0\1\uffff\1\0\13\uffff";
    static final String DFA101_maxS =
        "\2\141\2\uffff\1\133\30\uffff\1\141\2\uffff\1\133\7\uffff\1\42\3"+
        "\131\6\133\10\uffff\1\131\6\uffff\2\131\1\uffff\2\131\7\uffff\14"+
        "\0\21\uffff\1\0\1\uffff\2\0\1\uffff\2\0\5\uffff\6\0\2\uffff\60\0"+
        "\2\uffff\6\0\2\uffff\6\0\2\uffff\6\0\2\uffff\6\0\2\uffff\6\0\3\uffff"+
        "\6\0\1\uffff\14\0\2\uffff\2\0\2\uffff\1\0\12\uffff\1\0\1\uffff\1"+
        "\0\2\uffff\1\0\13\uffff\1\0\17\uffff\1\0\1\uffff\1\0\13\uffff";
    static final String DFA101_acceptS =
        "\2\uffff\1\2\11\uffff\1\3\11\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
        "\1\uffff\1\1\u010c\uffff\1\13";
    static final String DFA101_specialS =
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
        "\1\147\1\150\1\151\1\152\1\uffff\1\153\1\154\1\155\1\156\1\157\1"+
        "\160\1\161\1\162\1\163\1\164\1\165\1\166\2\uffff\1\167\1\170\2\uffff"+
        "\1\171\12\uffff\1\172\1\uffff\1\173\2\uffff\1\174\13\uffff\1\175"+
        "\17\uffff\1\176\1\uffff\1\177\13\uffff}>";
    static final String[] DFA101_transitionS = {
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
            "\1\2\25\uffff\2\14\1\2\2\uffff\1\14\1\72\1\uffff\1\104\1\14"+
            "\4\uffff\2\14\1\uffff\3\2\3\uffff\1\101\1\102\1\2\4\uffff\1"+
            "\105\1\uffff\17\2\1\uffff\14\14\2\uffff\2\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            "\uffff\1\u00eb\6\uffff\1\u00db\3\uffff\1\u00e4\1\u00e0\10\uffff"+
            "\1\2\3\u00da\3\uffff\2\2\1\u00e2\1\uffff\1\2\2\uffff\1\2\1\uffff"+
            "\4\u00dc\2\u00dd\11\u00de\1\u00e1\14\uffff\2\u00e3",
            "",
            "",
            "",
            "",
            "",
            "",
            "\2\14\1\u00ef\4\14\14\uffff\1\14\12\uffff\1\u00ee\20\uffff"+
            "\2\2\1\u00f2\4\uffff\1\2\20\uffff\1\14\14\uffff\2\14",
            "\2\14\1\u00fd\4\14\14\uffff\1\14\12\uffff\1\u00ff\20\uffff"+
            "\2\2\1\u0102\4\uffff\1\2\20\uffff\1\14\14\uffff\2\14",
            "",
            "\2\14\1\u010e\4\14\14\uffff\1\14\6\uffff\1\2\3\uffff\1\14\2"+
            "\uffff\1\2\7\uffff\3\2\5\uffff\1\14\6\uffff\17\2\1\14\14\uffff"+
            "\2\14",
            "\2\14\1\u011e\4\14\14\uffff\1\14\12\uffff\1\u0120\20\uffff"+
            "\2\2\1\14\4\uffff\1\2\20\uffff\1\14\14\uffff\2\14",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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

    static final short[] DFA101_eot = DFA.unpackEncodedString(DFA101_eotS);
    static final short[] DFA101_eof = DFA.unpackEncodedString(DFA101_eofS);
    static final char[] DFA101_min = DFA.unpackEncodedStringToUnsignedChars(DFA101_minS);
    static final char[] DFA101_max = DFA.unpackEncodedStringToUnsignedChars(DFA101_maxS);
    static final short[] DFA101_accept = DFA.unpackEncodedString(DFA101_acceptS);
    static final short[] DFA101_special = DFA.unpackEncodedString(DFA101_specialS);
    static final short[][] DFA101_transition;

    static {
        int numStates = DFA101_transitionS.length;
        DFA101_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA101_transition[i] = DFA.unpackEncodedString(DFA101_transitionS[i]);
        }
    }

    class DFA101 extends DFA {

        public DFA101(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 101;
            this.eot = DFA101_eot;
            this.eof = DFA101_eof;
            this.min = DFA101_min;
            this.max = DFA101_max;
            this.accept = DFA101_accept;
            this.special = DFA101_special;
            this.transition = DFA101_transition;
        }
        public String getDescription() {
            return "1227:1: statement : ( statementsBlock | declaration | expression ( '=' expression )? ';' | 'return' expression ';' | 'if' '(' expression ')' statement ( 'else' statement )? | 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA101_77 = input.LA(1);

                         
                        int index101_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_77);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA101_78 = input.LA(1);

                         
                        int index101_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_78);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA101_79 = input.LA(1);

                         
                        int index101_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_79);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA101_80 = input.LA(1);

                         
                        int index101_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_80);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA101_81 = input.LA(1);

                         
                        int index101_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_81);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA101_82 = input.LA(1);

                         
                        int index101_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_82);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA101_83 = input.LA(1);

                         
                        int index101_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_83);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA101_84 = input.LA(1);

                         
                        int index101_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_84);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA101_85 = input.LA(1);

                         
                        int index101_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_85);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA101_86 = input.LA(1);

                         
                        int index101_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_86);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA101_87 = input.LA(1);

                         
                        int index101_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_87);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA101_88 = input.LA(1);

                         
                        int index101_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_88);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA101_106 = input.LA(1);

                         
                        int index101_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_106);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA101_108 = input.LA(1);

                         
                        int index101_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_108);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA101_109 = input.LA(1);

                         
                        int index101_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_109);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA101_111 = input.LA(1);

                         
                        int index101_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_111);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA101_112 = input.LA(1);

                         
                        int index101_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_112);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA101_118 = input.LA(1);

                         
                        int index101_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_118);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA101_119 = input.LA(1);

                         
                        int index101_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_119);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA101_120 = input.LA(1);

                         
                        int index101_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_120);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA101_121 = input.LA(1);

                         
                        int index101_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_121);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA101_122 = input.LA(1);

                         
                        int index101_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_122);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA101_123 = input.LA(1);

                         
                        int index101_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_123);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA101_126 = input.LA(1);

                         
                        int index101_126 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_126);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA101_127 = input.LA(1);

                         
                        int index101_127 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_127);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA101_128 = input.LA(1);

                         
                        int index101_128 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_128);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA101_129 = input.LA(1);

                         
                        int index101_129 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_129);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA101_130 = input.LA(1);

                         
                        int index101_130 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_130);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA101_131 = input.LA(1);

                         
                        int index101_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_131);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA101_132 = input.LA(1);

                         
                        int index101_132 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_132);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA101_133 = input.LA(1);

                         
                        int index101_133 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_133);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA101_134 = input.LA(1);

                         
                        int index101_134 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_134);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA101_135 = input.LA(1);

                         
                        int index101_135 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_135);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA101_136 = input.LA(1);

                         
                        int index101_136 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_136);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA101_137 = input.LA(1);

                         
                        int index101_137 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_137);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA101_138 = input.LA(1);

                         
                        int index101_138 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_138);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA101_139 = input.LA(1);

                         
                        int index101_139 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_139);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA101_140 = input.LA(1);

                         
                        int index101_140 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_140);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA101_141 = input.LA(1);

                         
                        int index101_141 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_141);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA101_142 = input.LA(1);

                         
                        int index101_142 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_142);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA101_143 = input.LA(1);

                         
                        int index101_143 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_143);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA101_144 = input.LA(1);

                         
                        int index101_144 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_144);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA101_145 = input.LA(1);

                         
                        int index101_145 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_145);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA101_146 = input.LA(1);

                         
                        int index101_146 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_146);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA101_147 = input.LA(1);

                         
                        int index101_147 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_147);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA101_148 = input.LA(1);

                         
                        int index101_148 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_148);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA101_149 = input.LA(1);

                         
                        int index101_149 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_149);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA101_150 = input.LA(1);

                         
                        int index101_150 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_150);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA101_151 = input.LA(1);

                         
                        int index101_151 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_151);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA101_152 = input.LA(1);

                         
                        int index101_152 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_152);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA101_153 = input.LA(1);

                         
                        int index101_153 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_153);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA101_154 = input.LA(1);

                         
                        int index101_154 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_154);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA101_155 = input.LA(1);

                         
                        int index101_155 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_155);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA101_156 = input.LA(1);

                         
                        int index101_156 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_156);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA101_157 = input.LA(1);

                         
                        int index101_157 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_157);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA101_158 = input.LA(1);

                         
                        int index101_158 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_158);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA101_159 = input.LA(1);

                         
                        int index101_159 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_159);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA101_160 = input.LA(1);

                         
                        int index101_160 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_160);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA101_161 = input.LA(1);

                         
                        int index101_161 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_161);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA101_162 = input.LA(1);

                         
                        int index101_162 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_162);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA101_163 = input.LA(1);

                         
                        int index101_163 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_163);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA101_164 = input.LA(1);

                         
                        int index101_164 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_164);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA101_165 = input.LA(1);

                         
                        int index101_165 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_165);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA101_166 = input.LA(1);

                         
                        int index101_166 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_166);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA101_167 = input.LA(1);

                         
                        int index101_167 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_167);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA101_168 = input.LA(1);

                         
                        int index101_168 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_168);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA101_169 = input.LA(1);

                         
                        int index101_169 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_169);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA101_170 = input.LA(1);

                         
                        int index101_170 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_170);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA101_171 = input.LA(1);

                         
                        int index101_171 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_171);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA101_172 = input.LA(1);

                         
                        int index101_172 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_172);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA101_173 = input.LA(1);

                         
                        int index101_173 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_173);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA101_176 = input.LA(1);

                         
                        int index101_176 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_176);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA101_177 = input.LA(1);

                         
                        int index101_177 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_177);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA101_178 = input.LA(1);

                         
                        int index101_178 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_178);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA101_179 = input.LA(1);

                         
                        int index101_179 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_179);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA101_180 = input.LA(1);

                         
                        int index101_180 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_180);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA101_181 = input.LA(1);

                         
                        int index101_181 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_181);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA101_184 = input.LA(1);

                         
                        int index101_184 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_184);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA101_185 = input.LA(1);

                         
                        int index101_185 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_185);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA101_186 = input.LA(1);

                         
                        int index101_186 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_186);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA101_187 = input.LA(1);

                         
                        int index101_187 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_187);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA101_188 = input.LA(1);

                         
                        int index101_188 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_188);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA101_189 = input.LA(1);

                         
                        int index101_189 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_189);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA101_192 = input.LA(1);

                         
                        int index101_192 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_192);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA101_193 = input.LA(1);

                         
                        int index101_193 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_193);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA101_194 = input.LA(1);

                         
                        int index101_194 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_194);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA101_195 = input.LA(1);

                         
                        int index101_195 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_195);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA101_196 = input.LA(1);

                         
                        int index101_196 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_196);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA101_197 = input.LA(1);

                         
                        int index101_197 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_197);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA101_200 = input.LA(1);

                         
                        int index101_200 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_200);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA101_201 = input.LA(1);

                         
                        int index101_201 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_201);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA101_202 = input.LA(1);

                         
                        int index101_202 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_202);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA101_203 = input.LA(1);

                         
                        int index101_203 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_203);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA101_204 = input.LA(1);

                         
                        int index101_204 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_204);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA101_205 = input.LA(1);

                         
                        int index101_205 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_205);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA101_208 = input.LA(1);

                         
                        int index101_208 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_208);
                        if ( s>=0 ) return s;
                        break;
                    case 96 : 
                        int LA101_209 = input.LA(1);

                         
                        int index101_209 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_209);
                        if ( s>=0 ) return s;
                        break;
                    case 97 : 
                        int LA101_210 = input.LA(1);

                         
                        int index101_210 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_210);
                        if ( s>=0 ) return s;
                        break;
                    case 98 : 
                        int LA101_211 = input.LA(1);

                         
                        int index101_211 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_211);
                        if ( s>=0 ) return s;
                        break;
                    case 99 : 
                        int LA101_212 = input.LA(1);

                         
                        int index101_212 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_212);
                        if ( s>=0 ) return s;
                        break;
                    case 100 : 
                        int LA101_213 = input.LA(1);

                         
                        int index101_213 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 30;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_213);
                        if ( s>=0 ) return s;
                        break;
                    case 101 : 
                        int LA101_217 = input.LA(1);

                         
                        int index101_217 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                        else if ( (( next("foreach") )) ) {s = 299;}

                         
                        input.seek(index101_217);
                        if ( s>=0 ) return s;
                        break;
                    case 102 : 
                        int LA101_218 = input.LA(1);

                         
                        int index101_218 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 299;}

                         
                        input.seek(index101_218);
                        if ( s>=0 ) return s;
                        break;
                    case 103 : 
                        int LA101_219 = input.LA(1);

                         
                        int index101_219 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 299;}

                         
                        input.seek(index101_219);
                        if ( s>=0 ) return s;
                        break;
                    case 104 : 
                        int LA101_220 = input.LA(1);

                         
                        int index101_220 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 299;}

                         
                        input.seek(index101_220);
                        if ( s>=0 ) return s;
                        break;
                    case 105 : 
                        int LA101_221 = input.LA(1);

                         
                        int index101_221 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 299;}

                         
                        input.seek(index101_221);
                        if ( s>=0 ) return s;
                        break;
                    case 106 : 
                        int LA101_222 = input.LA(1);

                         
                        int index101_222 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (( next("foreach") )) ) {s = 299;}

                         
                        input.seek(index101_222);
                        if ( s>=0 ) return s;
                        break;
                    case 107 : 
                        int LA101_224 = input.LA(1);

                         
                        int index101_224 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_224);
                        if ( s>=0 ) return s;
                        break;
                    case 108 : 
                        int LA101_225 = input.LA(1);

                         
                        int index101_225 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_225);
                        if ( s>=0 ) return s;
                        break;
                    case 109 : 
                        int LA101_226 = input.LA(1);

                         
                        int index101_226 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_226);
                        if ( s>=0 ) return s;
                        break;
                    case 110 : 
                        int LA101_227 = input.LA(1);

                         
                        int index101_227 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_227);
                        if ( s>=0 ) return s;
                        break;
                    case 111 : 
                        int LA101_228 = input.LA(1);

                         
                        int index101_228 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_228);
                        if ( s>=0 ) return s;
                        break;
                    case 112 : 
                        int LA101_229 = input.LA(1);

                         
                        int index101_229 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_229);
                        if ( s>=0 ) return s;
                        break;
                    case 113 : 
                        int LA101_230 = input.LA(1);

                         
                        int index101_230 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_230);
                        if ( s>=0 ) return s;
                        break;
                    case 114 : 
                        int LA101_231 = input.LA(1);

                         
                        int index101_231 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_231);
                        if ( s>=0 ) return s;
                        break;
                    case 115 : 
                        int LA101_232 = input.LA(1);

                         
                        int index101_232 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_232);
                        if ( s>=0 ) return s;
                        break;
                    case 116 : 
                        int LA101_233 = input.LA(1);

                         
                        int index101_233 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_233);
                        if ( s>=0 ) return s;
                        break;
                    case 117 : 
                        int LA101_234 = input.LA(1);

                         
                        int index101_234 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_234);
                        if ( s>=0 ) return s;
                        break;
                    case 118 : 
                        int LA101_235 = input.LA(1);

                         
                        int index101_235 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_235);
                        if ( s>=0 ) return s;
                        break;
                    case 119 : 
                        int LA101_238 = input.LA(1);

                         
                        int index101_238 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_238);
                        if ( s>=0 ) return s;
                        break;
                    case 120 : 
                        int LA101_239 = input.LA(1);

                         
                        int index101_239 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_239);
                        if ( s>=0 ) return s;
                        break;
                    case 121 : 
                        int LA101_242 = input.LA(1);

                         
                        int index101_242 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_242);
                        if ( s>=0 ) return s;
                        break;
                    case 122 : 
                        int LA101_253 = input.LA(1);

                         
                        int index101_253 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_253);
                        if ( s>=0 ) return s;
                        break;
                    case 123 : 
                        int LA101_255 = input.LA(1);

                         
                        int index101_255 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_255);
                        if ( s>=0 ) return s;
                        break;
                    case 124 : 
                        int LA101_258 = input.LA(1);

                         
                        int index101_258 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_258);
                        if ( s>=0 ) return s;
                        break;
                    case 125 : 
                        int LA101_270 = input.LA(1);

                         
                        int index101_270 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_270);
                        if ( s>=0 ) return s;
                        break;
                    case 126 : 
                        int LA101_286 = input.LA(1);

                         
                        int index101_286 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_286);
                        if ( s>=0 ) return s;
                        break;
                    case 127 : 
                        int LA101_288 = input.LA(1);

                         
                        int index101_288 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 2;}

                        else if ( (synpred166_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index101_288);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 101, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA96_eotS =
        "\77\uffff";
    static final String DFA96_eofS =
        "\1\2\76\uffff";
    static final String DFA96_minS =
        "\1\4\1\0\75\uffff";
    static final String DFA96_maxS =
        "\1\142\1\0\75\uffff";
    static final String DFA96_acceptS =
        "\2\uffff\1\2\73\uffff\1\1";
    static final String DFA96_specialS =
        "\1\uffff\1\0\75\uffff}>";
    static final String[] DFA96_transitionS = {
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
            return "1233:37: ( 'else' statement )?";
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
                        if ( (synpred168_ObjCpp()) ) {s = 62;}

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
        "\107\uffff";
    static final String DFA97_eofS =
        "\107\uffff";
    static final String DFA97_minS =
        "\1\4\33\uffff\1\4\14\uffff\1\4\1\0\2\uffff\1\0\7\uffff\12\0\6\uffff"+
        "\1\0\1\uffff";
    static final String DFA97_maxS =
        "\1\141\33\uffff\1\131\14\uffff\1\141\1\0\2\uffff\1\0\7\uffff\12"+
        "\0\6\uffff\1\0\1\uffff";
    static final String DFA97_acceptS =
        "\1\uffff\1\1\33\uffff\1\2\51\uffff";
    static final String DFA97_specialS =
        "\52\uffff\1\0\2\uffff\1\1\7\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1"+
        "\11\1\12\1\13\6\uffff\1\14\1\uffff}>";
    static final String[] DFA97_transitionS = {
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
            "\1\71\1\76\1\55\1\72\1\73\1\74\1\75\14\uffff\1\52\1\uffff\2"+
            "\35\1\uffff\1\105\1\uffff\3\35\1\uffff\1\70\1\35\11\uffff\3"+
            "\35\5\uffff\1\66\1\uffff\1\35\3\uffff\20\35\1\65\14\uffff\2"+
            "\67\2\uffff\1\35\1\uffff\4\35",
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
            return "1236:13: ( statement )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA97_42 = input.LA(1);

                         
                        int index97_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred172_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index97_42);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA97_45 = input.LA(1);

                         
                        int index97_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred172_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index97_45);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA97_53 = input.LA(1);

                         
                        int index97_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred172_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index97_53);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA97_54 = input.LA(1);

                         
                        int index97_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred172_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index97_54);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA97_55 = input.LA(1);

                         
                        int index97_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred172_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index97_55);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA97_56 = input.LA(1);

                         
                        int index97_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred172_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index97_56);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA97_57 = input.LA(1);

                         
                        int index97_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred172_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index97_57);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA97_58 = input.LA(1);

                         
                        int index97_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred172_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index97_58);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA97_59 = input.LA(1);

                         
                        int index97_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred172_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index97_59);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA97_60 = input.LA(1);

                         
                        int index97_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred172_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index97_60);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA97_61 = input.LA(1);

                         
                        int index97_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred172_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index97_61);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA97_62 = input.LA(1);

                         
                        int index97_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred172_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index97_62);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA97_69 = input.LA(1);

                         
                        int index97_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred172_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 29;}

                         
                        input.seek(index97_69);
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
    static final String DFA98_eotS =
        "\16\uffff";
    static final String DFA98_eofS =
        "\16\uffff";
    static final String DFA98_minS =
        "\1\4\15\uffff";
    static final String DFA98_maxS =
        "\1\131\15\uffff";
    static final String DFA98_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA98_specialS =
        "\16\uffff}>";
    static final String[] DFA98_transitionS = {
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
            return "1236:28: ( expression )?";
        }
    }
    static final String DFA99_eotS =
        "\36\uffff";
    static final String DFA99_eofS =
        "\36\uffff";
    static final String DFA99_minS =
        "\1\4\35\uffff";
    static final String DFA99_maxS =
        "\1\141\35\uffff";
    static final String DFA99_acceptS =
        "\1\uffff\1\1\33\uffff\1\2";
    static final String DFA99_specialS =
        "\36\uffff}>";
    static final String[] DFA99_transitionS = {
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
            return "1236:44: ( statement )?";
        }
    }
    static final String DFA100_eotS =
        "\37\uffff";
    static final String DFA100_eofS =
        "\37\uffff";
    static final String DFA100_minS =
        "\1\4\36\uffff";
    static final String DFA100_maxS =
        "\1\142\36\uffff";
    static final String DFA100_acceptS =
        "\1\uffff\1\3\1\1\1\2\33\uffff";
    static final String DFA100_specialS =
        "\37\uffff}>";
    static final String[] DFA100_transitionS = {
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
            return "()* loopback of 1238:3: ( 'case' expression ':' | statement )*";
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
    public static final BitSet FOLLOW_modifier_in_argDef1563 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_modifier_in_argDef1580 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_argDef1604 = new BitSet(new long[]{0x0418000420000042L});
    public static final BitSet FOLLOW_declarator_in_argDef1619 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_argDef1639 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_argDef1641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_argDef1655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_typeMutator1675 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_typeMutator1677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_typeMutator1685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_typeMutator1693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_typeMutator1702 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_typeMutator1704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_arrayTypeMutator1722 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_arrayTypeMutator1728 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_arrayTypeMutator1737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_typeRefCore1777 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_typeRefCore1780 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_typeRefCore1782 = new BitSet(new long[]{0x04180C3000000000L,0x0000000000FFF000L});
    public static final BitSet FOLLOW_binaryOp_in_typeRefCore1784 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_typeRefCore1786 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_typeRefCore1788 = new BitSet(new long[]{0xF000000000000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_modifier_in_typeRefCore1799 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_typeRefCore1802 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_typeRefCore1804 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_typeRefCore1806 = new BitSet(new long[]{0xF000000000000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_modifier_in_typeRefCore1819 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_typeRefCore1822 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_typeRefCore1824 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_typeRefCore1826 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_typeRefCore1828 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_typeRefCore1830 = new BitSet(new long[]{0xF000000000000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_modifier_in_typeRefCore1847 = new BitSet(new long[]{0xF000000000000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_modifier_in_typeRefCore1864 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_typeRefCore1873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveTypeRef_in_typeRefCore1893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_typeRefCore1908 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_typeRefCore1926 = new BitSet(new long[]{0xF000E02040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_typeRefCore1947 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_27_in_typeRefCore1968 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_typeRefCore1981 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_37_in_typeRefCore2009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_templateDef2041 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_templateDef2043 = new BitSet(new long[]{0xF200402000000000L,0x00000000000007FFL});
    public static final BitSet FOLLOW_templateArgDecl_in_templateDef2046 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_27_in_templateDef2049 = new BitSet(new long[]{0xF200400000000000L,0x00000000000007FFL});
    public static final BitSet FOLLOW_templateArgDecl_in_templateDef2051 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_37_in_templateDef2058 = new BitSet(new long[]{0x0000E00000000000L});
    public static final BitSet FOLLOW_structCore_in_templateDef2062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDefinition_in_templateDef2066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveTypeRef_in_templateArgDecl2078 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_templateArgDecl2081 = new BitSet(new long[]{0x00000000000007B0L});
    public static final BitSet FOLLOW_constant_in_templateArgDecl2083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_templateArgDecl2090 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_templateArgDecl2098 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_templateArgDecl2101 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_templateArgDecl2103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffix2122 = new BitSet(new long[]{0x0008000000000040L});
    public static final BitSet FOLLOW_exportationModifiers_in_functionSignatureSuffix2124 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_functionSignatureSuffix2126 = new BitSet(new long[]{0x0000000800000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionSignatureSuffix2128 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffix2131 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffix2137 = new BitSet(new long[]{0xF000F00840000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffix2146 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_27_in_functionSignatureSuffix2159 = new BitSet(new long[]{0xF000F00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffix2168 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffix2183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffixNoName2200 = new BitSet(new long[]{0x0008000000000040L});
    public static final BitSet FOLLOW_exportationModifiers_in_functionSignatureSuffixNoName2202 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_functionSignatureSuffixNoName2204 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffixNoName2206 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffixNoName2212 = new BitSet(new long[]{0xF000F00840000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffixNoName2221 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_27_in_functionSignatureSuffixNoName2234 = new BitSet(new long[]{0xF000F00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffixNoName2243 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffixNoName2258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structCore_in_structOrEnum2276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumCore_in_structOrEnum2284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefCore_in_typeRefCoreOrFuncSig2302 = new BitSet(new long[]{0x0038000400000042L});
    public static final BitSet FOLLOW_typeMutator_in_typeRefCoreOrFuncSig2319 = new BitSet(new long[]{0x0038000400000040L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_typeRefCoreOrFuncSig2332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefCore_in_typeRefCoreOrAnonymousFuncSig2356 = new BitSet(new long[]{0x0038000400000042L});
    public static final BitSet FOLLOW_typeMutator_in_typeRefCoreOrAnonymousFuncSig2373 = new BitSet(new long[]{0x0038000400000040L});
    public static final BitSet FOLLOW_functionSignatureSuffixNoName_in_typeRefCoreOrAnonymousFuncSig2386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structOrEnum_in_plainTypeRef2413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefCoreOrFuncSig_in_plainTypeRef2421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_declarator2450 = new BitSet(new long[]{0x0418000400000040L});
    public static final BitSet FOLLOW_set_in_declarator2487 = new BitSet(new long[]{0x0418000400000040L});
    public static final BitSet FOLLOW_declarator_in_declarator2506 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_directDeclarator_in_declarator2522 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_declarator2541 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_declarator2548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structCore_in_namedTypeRef2582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumCore_in_namedTypeRef2592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_typeDef2611 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_varDecl_in_typeDef2617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_varDeclEOF2637 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_varDeclEOF2639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_varDecl2675 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_modifier_in_varDecl2692 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_structOrEnum_in_varDecl2719 = new BitSet(new long[]{0x0418000410000040L});
    public static final BitSet FOLLOW_declaratorsList_in_varDecl2736 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_typeRefCoreOrAnonymousFuncSig_in_varDecl2756 = new BitSet(new long[]{0x0418000400000040L});
    public static final BitSet FOLLOW_declaratorsList_in_varDecl2766 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_varDecl2803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_objCProtocolRefList2817 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCProtocolRefList2822 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_27_in_objCProtocolRefList2832 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCProtocolRefList2838 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_37_in_objCProtocolRefList2848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarator_in_declaratorsList2875 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_declaratorsList2888 = new BitSet(new long[]{0x0418000400000040L});
    public static final BitSet FOLLOW_declarator_in_declaratorsList2897 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_directDeclarator2940 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_34_in_directDeclarator2950 = new BitSet(new long[]{0x0418000400000040L});
    public static final BitSet FOLLOW_modifier_in_directDeclarator2959 = new BitSet(new long[]{0x0418000400000040L});
    public static final BitSet FOLLOW_declarator_in_directDeclarator2970 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_directDeclarator2976 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_53_in_directDeclarator2991 = new BitSet(new long[]{0x00600004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_directDeclarator3003 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_directDeclarator3019 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_argList_in_directDeclarator3027 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_34_in_argList3055 = new BitSet(new long[]{0xF000F00840000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_argDef_in_argList3067 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_27_in_argList3080 = new BitSet(new long[]{0xF000F00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_argDef_in_argList3089 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_27_in_argList3109 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_argList3111 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_argList3130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plainTypeRef_in_typeRef3148 = new BitSet(new long[]{0x0038000000000042L});
    public static final BitSet FOLLOW_typeMutator_in_typeRef3159 = new BitSet(new long[]{0x0038000000000042L});
    public static final BitSet FOLLOW_set_in_primSignModifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_primSizeModifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_primitiveTypeName0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primSignModifier_in_primitiveTypeRef3298 = new BitSet(new long[]{0xF000000000000000L,0x00000000000007FFL});
    public static final BitSet FOLLOW_primSizeModifier_in_primitiveTypeRef3309 = new BitSet(new long[]{0xF000000000000000L,0x00000000000007FFL});
    public static final BitSet FOLLOW_primSizeModifier_in_primitiveTypeRef3316 = new BitSet(new long[]{0xF000000000000000L,0x00000000000007FFL});
    public static final BitSet FOLLOW_primitiveTypeName_in_primitiveTypeRef3359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_objCMethodCall3398 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3402 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodCall3406 = new BitSet(new long[]{0x0040000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodCall3417 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3421 = new BitSet(new long[]{0x0040000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodCall3436 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodCall3438 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3442 = new BitSet(new long[]{0x0040000000000040L});
    public static final BitSet FOLLOW_54_in_objCMethodCall3459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_functionCall3479 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionCall3481 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_functionCall3483 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionCall3485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionCall3493 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionCall3495 = new BitSet(new long[]{0x0020000C008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_functionCall3508 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_27_in_functionCall3517 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_functionCall3526 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_35_in_functionCall3544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_binaryOp0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_expression3650 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_functionCall_in_expression3661 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_objCMethodCall_in_expression3670 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_set_in_expression3681 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_expression3691 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_34_in_expression3700 = new BitSet(new long[]{0xF020E004408007F0L,0x0000000003000FFFL});
    public static final BitSet FOLLOW_expression_in_expression3710 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_expression3712 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_typeRef_in_expression3722 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_expression3724 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_expression3728 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_constant_in_expression3743 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_23_in_expression3752 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_expression3754 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_expression3756 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_binaryOp_in_expression3772 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_expression3779 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_29_in_expression3788 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_expression3792 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_90_in_expression3801 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_expression3805 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_33_in_expression3817 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_expression3819 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000800L});
    public static final BitSet FOLLOW_43_in_expression3823 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_expression3825 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000800L});
    public static final BitSet FOLLOW_90_in_expression3829 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000800L});
    public static final BitSet FOLLOW_functionCall_in_expression3834 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_91_in_expression3846 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_expression3850 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_expression3852 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_expression3856 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_23_in_statementsBlock3879 = new BitSet(new long[]{0xF8A0E005D78007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statementsBlock3881 = new BitSet(new long[]{0xF8A0E005D78007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_24_in_statementsBlock3884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_statement3897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_statement3903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement3909 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_statement3912 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement3914 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_statement3925 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement3927 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_statement3935 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3937 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement3939 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3941 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement3943 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_statement3946 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement3948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_statement3956 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3958 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement3960 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3962 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement3964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_statement3970 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement3972 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_statement3974 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3976 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement3978 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3980 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_statement3988 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3990 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement3992 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3995 = new BitSet(new long[]{0x00200004108007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement3997 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement4000 = new BitSet(new long[]{0xF8A0E00DD68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement4002 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4005 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement4007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_statement4013 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4015 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement4017 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4019 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_statement4021 = new BitSet(new long[]{0xF8A0E005D78007F0L,0x00000007D3000FFFL});
    public static final BitSet FOLLOW_98_in_statement4027 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement4029 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement4031 = new BitSet(new long[]{0xF8A0E005D78007F0L,0x00000007D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement4038 = new BitSet(new long[]{0xF8A0E005D78007F0L,0x00000007D3000FFFL});
    public static final BitSet FOLLOW_24_in_statement4047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_statement4053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement4061 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4063 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_varDecl_in_statement4065 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement4067 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement4069 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4071 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement4073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_constant4089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEXADECIMAL_NUMBER_in_constant4097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OCTAL_NUMBER_in_constant4105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARACTER_in_constant4113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_NUMBER_in_constant4121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_constant4132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_synpred6_ObjCpp249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred7_ObjCpp259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred26_ObjCpp777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred40_ObjCpp1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exportationModifiers_in_synpred41_ObjCpp1138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRef_in_synpred47_ObjCpp1279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred48_ObjCpp1313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exportationModifier_in_synpred50_ObjCpp1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred53_ObjCpp1563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred54_ObjCpp1580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred62_ObjCpp1799 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_synpred62_ObjCpp1802 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred62_ObjCpp1804 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred62_ObjCpp1806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred63_ObjCpp1819 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_synpred63_ObjCpp1822 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred63_ObjCpp1824 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_synpred63_ObjCpp1826 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred63_ObjCpp1828 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred63_ObjCpp1830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred64_ObjCpp1847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred65_ObjCpp1864 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_synpred65_ObjCpp1873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred82_ObjCpp2319 = new BitSet(new long[]{0x0038000400000040L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_synpred82_ObjCpp2332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred84_ObjCpp2373 = new BitSet(new long[]{0x0038000400000040L});
    public static final BitSet FOLLOW_functionSignatureSuffixNoName_in_synpred84_ObjCpp2386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred86_ObjCpp2450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred90_ObjCpp2541 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred90_ObjCpp2548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred92_ObjCpp2675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred93_ObjCpp2692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred99_ObjCpp2959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_synpred103_ObjCpp3080 = new BitSet(new long[]{0xF000F00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_argDef_in_synpred103_ObjCpp3089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred106_ObjCpp3159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred152_ObjCpp3710 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred152_ObjCpp3712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binaryOp_in_synpred155_ObjCpp3772 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred155_ObjCpp3779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred156_ObjCpp3788 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred156_ObjCpp3792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_synpred157_ObjCpp3801 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred157_ObjCpp3805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_synpred160_ObjCpp3817 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_synpred160_ObjCpp3819 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000800L});
    public static final BitSet FOLLOW_43_in_synpred160_ObjCpp3823 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_synpred160_ObjCpp3825 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000800L});
    public static final BitSet FOLLOW_90_in_synpred160_ObjCpp3829 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000800L});
    public static final BitSet FOLLOW_functionCall_in_synpred160_ObjCpp3834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_synpred161_ObjCpp3846 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred161_ObjCpp3850 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_synpred161_ObjCpp3852 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred161_ObjCpp3856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_synpred163_ObjCpp3897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_synpred164_ObjCpp3903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred166_ObjCpp3909 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_synpred166_ObjCpp3912 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred166_ObjCpp3914 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_synpred166_ObjCpp3919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_synpred168_ObjCpp3946 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_synpred168_ObjCpp3948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_synpred172_ObjCpp3992 = new BitSet(new long[]{0x0000000000000002L});

}