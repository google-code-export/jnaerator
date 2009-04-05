// $ANTLR 3.1.2 /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g 2009-04-06 00:22:07
 
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


    	public enum Language {
    		C, CPlusPlus, ObjectiveC
    	}
    	public EnumSet<Language> possibleLanguages = EnumSet.allOf(Language.class);
    	
    	String lastComment;
    	String file;
    	int sourceLineDelta = 0; // line(token) = token.line - lastLineToken.line + lastLine; sourceLineDelta = lastLine - lastLineToken.line
    	//String pack;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:205:1: lineDirective : ln= '#line' line= DECIMAL_NUMBER (unescapedString= STRING )? (depth= DECIMAL_NUMBER )? ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:206:2: (ln= '#line' line= DECIMAL_NUMBER (unescapedString= STRING )? (depth= DECIMAL_NUMBER )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:206:4: ln= '#line' line= DECIMAL_NUMBER (unescapedString= STRING )? (depth= DECIMAL_NUMBER )?
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:214:3: (unescapedString= STRING )?
            int alt1=2;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:215:4: unescapedString= STRING
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:225:8: (depth= DECIMAL_NUMBER )?
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:228:1: sourceFile returns [SourceFile sourceFile] : ( declaration | lineDirective )* EOF ;
    public final ObjCppParser.sourceFile_return sourceFile() throws RecognitionException {
        ObjCppParser.sourceFile_return retval = new ObjCppParser.sourceFile_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF3=null;
        ObjCppParser.declaration_return declaration1 = null;

        ObjCppParser.lineDirective_return lineDirective2 = null;


        Object EOF3_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:229:2: ( ( declaration | lineDirective )* EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:230:3: ( declaration | lineDirective )* EOF
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.sourceFile = new SourceFile(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:231:3: ( declaration | lineDirective )*
            loop3:
            do {
                int alt3=3;
                alt3 = dfa3.predict(input);
                switch (alt3) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:232:4: declaration
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:236:4: lineDirective
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
        public ExternDeclarations declarations;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "externDeclarations"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:244:1: externDeclarations returns [ExternDeclarations declarations] : {...}? IDENTIFIER STRING '{' (ed= declaration )* '}' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:245:2: ({...}? IDENTIFIER STRING '{' (ed= declaration )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:245:4: {...}? IDENTIFIER STRING '{' (ed= declaration )* '}'
            {
            root_0 = (Object)adaptor.nil();

            if ( !(( next("extern") )) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "externDeclarations", " next(\"extern\") ");
            }
            IDENTIFIER4=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_externDeclarations165); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER4_tree = (Object)adaptor.create(IDENTIFIER4);
            adaptor.addChild(root_0, IDENTIFIER4_tree);
            }
            STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_externDeclarations169); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING5_tree = (Object)adaptor.create(STRING5);
            adaptor.addChild(root_0, STRING5_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.declarations = mark(new ExternDeclarations(), getLine(STRING5));
              			retval.declarations.setLanguage((STRING5!=null?STRING5.getText():null));
              		
            }
            char_literal6=(Token)match(input,23,FOLLOW_23_in_externDeclarations175); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal6_tree = (Object)adaptor.create(char_literal6);
            adaptor.addChild(root_0, char_literal6_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:251:4: (ed= declaration )*
            loop4:
            do {
                int alt4=2;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:252:5: ed= declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_externDeclarations189);
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

            char_literal7=(Token)match(input,24,FOLLOW_24_in_externDeclarations202); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:259:1: declaration returns [List<Declaration> declarations, List<Modifier> modifiers, String preComment, int startTokenIndex] : ( ( functionDeclaration | externDeclarations | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) ) ;
    public final ObjCppParser.declaration_return declaration() throws RecognitionException {
        ObjCppParser.declaration_return retval = new ObjCppParser.declaration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ns=null;
        Token string_literal14=null;
        Token char_literal15=null;
        Token char_literal16=null;
        ObjCppParser.declaration_return subD = null;

        ObjCppParser.functionDeclaration_return functionDeclaration8 = null;

        ObjCppParser.externDeclarations_return externDeclarations9 = null;

        ObjCppParser.varDecl_return varDecl10 = null;

        ObjCppParser.objCClassDef_return objCClassDef11 = null;

        ObjCppParser.typeDef_return typeDef12 = null;

        ObjCppParser.forwardClassDecl_return forwardClassDecl13 = null;


        Object ns_tree=null;
        Object string_literal14_tree=null;
        Object char_literal15_tree=null;
        Object char_literal16_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:260:2: ( ( ( functionDeclaration | externDeclarations | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:261:3: ( ( functionDeclaration | externDeclarations | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.declarations = new ArrayList<Declaration>(); 
              		  retval.modifiers = new ArrayList<Modifier>();
              		  retval.startTokenIndex = getTokenStream().index();
              		  retval.preComment = getCommentBefore(retval.startTokenIndex);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:266:3: ( ( functionDeclaration | externDeclarations | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:273:4: ( functionDeclaration | externDeclarations | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:273:4: ( functionDeclaration | externDeclarations | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )
            int alt6=7;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:275:5: functionDeclaration
                    {
                    pushFollow(FOLLOW_functionDeclaration_in_declaration245);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:278:5: externDeclarations
                    {
                    pushFollow(FOLLOW_externDeclarations_in_declaration255);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:281:5: varDecl
                    {
                    pushFollow(FOLLOW_varDecl_in_declaration265);
                    varDecl10=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl10.getTree());
                    if ( state.backtracking==0 ) {
                       
                      					retval.declarations.add((varDecl10!=null?varDecl10.decl:null)); 
                      				
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:284:5: objCClassDef
                    {
                    pushFollow(FOLLOW_objCClassDef_in_declaration275);
                    objCClassDef11=objCClassDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, objCClassDef11.getTree());
                    if ( state.backtracking==0 ) {
                       
                      					retval.declarations.add(decl((objCClassDef11!=null?objCClassDef11.struct:null))); 
                      				
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:287:5: typeDef
                    {
                    pushFollow(FOLLOW_typeDef_in_declaration285);
                    typeDef12=typeDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeDef12.getTree());
                    if ( state.backtracking==0 ) {

                      					retval.declarations.add((typeDef12!=null?typeDef12.typeDef:null)); 
                      				
                    }

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:290:5: forwardClassDecl
                    {
                    pushFollow(FOLLOW_forwardClassDecl_in_declaration295);
                    forwardClassDecl13=forwardClassDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, forwardClassDecl13.getTree());
                    if ( state.backtracking==0 ) {

                      					retval.declarations.addAll((forwardClassDecl13!=null?forwardClassDecl13.declarations:null)); 
                      				
                    }

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:293:5: 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}'
                    {
                    string_literal14=(Token)match(input,25,FOLLOW_25_in_declaration305); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal14_tree = (Object)adaptor.create(string_literal14);
                    adaptor.addChild(root_0, string_literal14_tree);
                    }
                    ns=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration309); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ns_tree = (Object)adaptor.create(ns);
                    adaptor.addChild(root_0, ns_tree);
                    }
                    char_literal15=(Token)match(input,23,FOLLOW_23_in_declaration311); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal15_tree = (Object)adaptor.create(char_literal15);
                    adaptor.addChild(root_0, char_literal15_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:294:6: (subD= declaration )*
                    loop5:
                    do {
                        int alt5=2;
                        alt5 = dfa5.predict(input);
                        switch (alt5) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:295:7: subD= declaration
                    	    {
                    	    pushFollow(FOLLOW_declaration_in_declaration329);
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

                    char_literal16=(Token)match(input,24,FOLLOW_24_in_declaration345); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal16_tree = (Object)adaptor.create(char_literal16);
                    adaptor.addChild(root_0, char_literal16_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:319:1: forwardClassDecl returns [List<Declaration> declarations] : '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';' ;
    public final ObjCppParser.forwardClassDecl_return forwardClassDecl() throws RecognitionException {
        ObjCppParser.forwardClassDecl_return retval = new ObjCppParser.forwardClassDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n1=null;
        Token nx=null;
        Token string_literal17=null;
        Token char_literal18=null;
        Token char_literal19=null;

        Object n1_tree=null;
        Object nx_tree=null;
        Object string_literal17_tree=null;
        Object char_literal18_tree=null;
        Object char_literal19_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:320:2: ( '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:320:5: '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.declarations = new ArrayList<Declaration>(); 
            }
            string_literal17=(Token)match(input,26,FOLLOW_26_in_forwardClassDecl385); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal17_tree = (Object)adaptor.create(string_literal17);
            adaptor.addChild(root_0, string_literal17_tree);
            }
            n1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_forwardClassDecl392); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n1_tree = (Object)adaptor.create(n1);
            adaptor.addChild(root_0, n1_tree);
            }
            if ( state.backtracking==0 ) {
               retval.declarations.add(decl(Struct.forwardDecl((n1!=null?n1.getText():null), Struct.Type.ObjCClass))); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:323:3: ( ',' nx= IDENTIFIER )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==27) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:323:4: ',' nx= IDENTIFIER
            	    {
            	    char_literal18=(Token)match(input,27,FOLLOW_27_in_forwardClassDecl399); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal18_tree = (Object)adaptor.create(char_literal18);
            	    adaptor.addChild(root_0, char_literal18_tree);
            	    }
            	    nx=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_forwardClassDecl406); if (state.failed) return retval;
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

            char_literal19=(Token)match(input,28,FOLLOW_28_in_forwardClassDecl417); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal19_tree = (Object)adaptor.create(char_literal19);
            adaptor.addChild(root_0, char_literal19_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:329:1: functionPointerVarDecl returns [List<? extends Declaration> declarations] : typeRef {...}? ';' ;
    public final ObjCppParser.functionPointerVarDecl_return functionPointerVarDecl() throws RecognitionException {
        ObjCppParser.functionPointerVarDecl_return retval = new ObjCppParser.functionPointerVarDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal21=null;
        ObjCppParser.typeRef_return typeRef20 = null;


        Object char_literal21_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:330:2: ( typeRef {...}? ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:330:4: typeRef {...}? ';'
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_typeRef_in_functionPointerVarDecl435);
            typeRef20=typeRef();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRef20.getTree());
            if ( !((
            			((typeRef20!=null?typeRef20.type:null) instanceof FunctionSignature) && 
            			((FunctionSignature)(typeRef20!=null?typeRef20.type:null)).getFunction().getName() != null
            		)) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "functionPointerVarDecl", "\n\t\t\t($typeRef.type instanceof FunctionSignature) && \n\t\t\t((FunctionSignature)$typeRef.type).getFunction().getName() != null\n\t\t");
            }
            if ( state.backtracking==0 ) {

              			retval.declarations = Arrays.asList(new FunctionPointerDeclaration(((FunctionSignature)(typeRef20!=null?typeRef20.type:null))));
              		
            }
            char_literal21=(Token)match(input,28,FOLLOW_28_in_functionPointerVarDecl443); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:339:1: enumItem returns [Enum.EnumItem item] : n= IDENTIFIER ( '=' v= expression )? ;
    public final ObjCppParser.enumItem_return enumItem() throws RecognitionException {
        ObjCppParser.enumItem_return retval = new ObjCppParser.enumItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token char_literal22=null;
        ObjCppParser.expression_return v = null;


        Object n_tree=null;
        Object char_literal22_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:340:2: (n= IDENTIFIER ( '=' v= expression )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:340:4: n= IDENTIFIER ( '=' v= expression )?
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumItem461); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:340:17: ( '=' v= expression )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==29) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:340:18: '=' v= expression
                    {
                    char_literal22=(Token)match(input,29,FOLLOW_29_in_enumItem464); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal22_tree = (Object)adaptor.create(char_literal22);
                    adaptor.addChild(root_0, char_literal22_tree);
                    }
                    pushFollow(FOLLOW_expression_in_enumItem468);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:347:1: enumCore returns [Enum e] : t= 'enum' (n1= IDENTIFIER )? ( '{' (i1= enumItem ( ',' (ix= enumItem )? )* )? '}' )? ;
    public final ObjCppParser.enumCore_return enumCore() throws RecognitionException {
        ObjCppParser.enumCore_return retval = new ObjCppParser.enumCore_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token t=null;
        Token n1=null;
        Token char_literal23=null;
        Token char_literal24=null;
        Token char_literal25=null;
        ObjCppParser.enumItem_return i1 = null;

        ObjCppParser.enumItem_return ix = null;


        Object t_tree=null;
        Object n1_tree=null;
        Object char_literal23_tree=null;
        Object char_literal24_tree=null;
        Object char_literal25_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:348:2: (t= 'enum' (n1= IDENTIFIER )? ( '{' (i1= enumItem ( ',' (ix= enumItem )? )* )? '}' )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:349:3: t= 'enum' (n1= IDENTIFIER )? ( '{' (i1= enumItem ( ',' (ix= enumItem )? )* )? '}' )?
            {
            root_0 = (Object)adaptor.nil();

            t=(Token)match(input,30,FOLLOW_30_in_enumCore492); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            t_tree = (Object)adaptor.create(t);
            adaptor.addChild(root_0, t_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.e = mark(new Enum(), getLine(t));
              			retval.e.setCommentBefore(getCommentBefore(t.getTokenIndex()));
              			retval.e.setForwardDeclaration(true);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:354:3: (n1= IDENTIFIER )?
            int alt9=2;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:355:4: n1= IDENTIFIER
                    {
                    n1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumCore506); if (state.failed) return retval;
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:359:3: ( '{' (i1= enumItem ( ',' (ix= enumItem )? )* )? '}' )?
            int alt13=2;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:360:4: '{' (i1= enumItem ( ',' (ix= enumItem )? )* )? '}'
                    {
                    char_literal23=(Token)match(input,23,FOLLOW_23_in_enumCore523); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal23_tree = (Object)adaptor.create(char_literal23);
                    adaptor.addChild(root_0, char_literal23_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.e.setForwardDeclaration(false); 
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:361:5: (i1= enumItem ( ',' (ix= enumItem )? )* )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==IDENTIFIER) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:362:6: i1= enumItem ( ',' (ix= enumItem )? )*
                            {
                            pushFollow(FOLLOW_enumItem_in_enumCore542);
                            i1=enumItem();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, i1.getTree());
                            if ( state.backtracking==0 ) {
                               
                              						if ((i1!=null?input.toString(i1.start,i1.stop):null) != null)
                              							retval.e.addItem((i1!=null?i1.item:null)); 
                              					
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:366:6: ( ',' (ix= enumItem )? )*
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( (LA11_0==27) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:367:7: ',' (ix= enumItem )?
                            	    {
                            	    char_literal24=(Token)match(input,27,FOLLOW_27_in_enumCore559); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    char_literal24_tree = (Object)adaptor.create(char_literal24);
                            	    adaptor.addChild(root_0, char_literal24_tree);
                            	    }
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:368:7: (ix= enumItem )?
                            	    int alt10=2;
                            	    int LA10_0 = input.LA(1);

                            	    if ( (LA10_0==IDENTIFIER) ) {
                            	        alt10=1;
                            	    }
                            	    switch (alt10) {
                            	        case 1 :
                            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:368:8: ix= enumItem
                            	            {
                            	            pushFollow(FOLLOW_enumItem_in_enumCore571);
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


                            }
                            break;

                    }

                    char_literal25=(Token)match(input,24,FOLLOW_24_in_enumCore595); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal25_tree = (Object)adaptor.create(char_literal25);
                    adaptor.addChild(root_0, char_literal25_tree);
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
    // $ANTLR end "enumCore"

    public static class objCClassDef_return extends ParserRuleReturnScope {
        public Struct struct;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "objCClassDef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:385:1: objCClassDef returns [Struct struct] : octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl {...}?)* '@end' ;
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
        Token char_literal37=null;
        Token string_literal40=null;
        ObjCppParser.varDecl_return fv = null;

        ObjCppParser.varDecl_return vd = null;

        ObjCppParser.functionPointerVarDecl_return functionPointerVarDecl36 = null;

        ObjCppParser.objCMethodDecl_return objCMethodDecl38 = null;

        ObjCppParser.typeDef_return typeDef39 = null;


        Object octype_tree=null;
        Object className_tree=null;
        Object parentClass_tree=null;
        Object categoryName_tree=null;
        Object p1_tree=null;
        Object px_tree=null;
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
        Object char_literal37_tree=null;
        Object string_literal40_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:386:2: (octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl {...}?)* '@end' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:387:3: octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl {...}?)* '@end'
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

            className=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef638); if (state.failed) return retval;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:397:3: ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' )
            int alt15=2;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:398:4: ( ':' parentClass= IDENTIFIER )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:398:4: ( ':' parentClass= IDENTIFIER )?
                    int alt14=2;
                    alt14 = dfa14.predict(input);
                    switch (alt14) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:399:5: ':' parentClass= IDENTIFIER
                            {
                            char_literal26=(Token)match(input,33,FOLLOW_33_in_objCClassDef656); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal26_tree = (Object)adaptor.create(char_literal26);
                            adaptor.addChild(root_0, char_literal26_tree);
                            }
                            parentClass=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef660); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:404:4: '(' categoryName= IDENTIFIER ')'
                    {
                    char_literal27=(Token)match(input,34,FOLLOW_34_in_objCClassDef675); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal27_tree = (Object)adaptor.create(char_literal27);
                    adaptor.addChild(root_0, char_literal27_tree);
                    }
                    categoryName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef679); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    categoryName_tree = (Object)adaptor.create(categoryName);
                    adaptor.addChild(root_0, categoryName_tree);
                    }
                    char_literal28=(Token)match(input,35,FOLLOW_35_in_objCClassDef681); if (state.failed) return retval;
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:408:3: ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )?
            int alt18=2;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:409:4: '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>'
                    {
                    char_literal29=(Token)match(input,36,FOLLOW_36_in_objCClassDef697); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal29_tree = (Object)adaptor.create(char_literal29);
                    adaptor.addChild(root_0, char_literal29_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:409:8: (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==IDENTIFIER) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:410:5: p1= IDENTIFIER ( ',' px= IDENTIFIER )*
                            {
                            p1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef707); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            p1_tree = (Object)adaptor.create(p1);
                            adaptor.addChild(root_0, p1_tree);
                            }
                            if ( state.backtracking==0 ) {
                               retval.struct.addProtocol((p1!=null?p1.getText():null)); 
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:411:5: ( ',' px= IDENTIFIER )*
                            loop16:
                            do {
                                int alt16=2;
                                int LA16_0 = input.LA(1);

                                if ( (LA16_0==27) ) {
                                    alt16=1;
                                }


                                switch (alt16) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:412:6: ',' px= IDENTIFIER
                            	    {
                            	    char_literal30=(Token)match(input,27,FOLLOW_27_in_objCClassDef722); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    char_literal30_tree = (Object)adaptor.create(char_literal30);
                            	    adaptor.addChild(root_0, char_literal30_tree);
                            	    }
                            	    px=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef732); if (state.failed) return retval;
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

                    char_literal31=(Token)match(input,37,FOLLOW_37_in_objCClassDef749); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal31_tree = (Object)adaptor.create(char_literal31);
                    adaptor.addChild(root_0, char_literal31_tree);
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:417:3: ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )?
            int alt21=2;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:418:4: '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}'
                    {
                    char_literal32=(Token)match(input,23,FOLLOW_23_in_objCClassDef763); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal32_tree = (Object)adaptor.create(char_literal32);
                    adaptor.addChild(root_0, char_literal32_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:419:4: ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )*
                    loop20:
                    do {
                        int alt20=5;
                        alt20 = dfa20.predict(input);
                        switch (alt20) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:420:5: '@public'
                    	    {
                    	    string_literal33=(Token)match(input,38,FOLLOW_38_in_objCClassDef775); if (state.failed) return retval;
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
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:421:5: '@private'
                    	    {
                    	    string_literal34=(Token)match(input,39,FOLLOW_39_in_objCClassDef786); if (state.failed) return retval;
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
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:422:5: '@protected'
                    	    {
                    	    string_literal35=(Token)match(input,40,FOLLOW_40_in_objCClassDef797); if (state.failed) return retval;
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
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:423:5: ( (fv= varDecl | functionPointerVarDecl ) )
                    	    {
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:423:5: ( (fv= varDecl | functionPointerVarDecl ) )
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:424:6: (fv= varDecl | functionPointerVarDecl )
                    	    {
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:424:6: (fv= varDecl | functionPointerVarDecl )
                    	    int alt19=2;
                    	    alt19 = dfa19.predict(input);
                    	    switch (alt19) {
                    	        case 1 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:425:7: fv= varDecl
                    	            {
                    	            pushFollow(FOLLOW_varDecl_in_objCClassDef824);
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
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:428:7: functionPointerVarDecl
                    	            {
                    	            pushFollow(FOLLOW_functionPointerVarDecl_in_objCClassDef836);
                    	            functionPointerVarDecl36=functionPointerVarDecl();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) adaptor.addChild(root_0, functionPointerVarDecl36.getTree());
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              							retval.struct.addDeclarations((functionPointerVarDecl36!=null?functionPointerVarDecl36.declarations:null)); 
                    	              						
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    char_literal37=(Token)match(input,24,FOLLOW_24_in_objCClassDef863); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal37_tree = (Object)adaptor.create(char_literal37);
                    adaptor.addChild(root_0, char_literal37_tree);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Public); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:437:3: ( objCMethodDecl | typeDef | vd= varDecl {...}?)*
            loop22:
            do {
                int alt22=4;
                alt22 = dfa22.predict(input);
                switch (alt22) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:438:4: objCMethodDecl
            	    {
            	    pushFollow(FOLLOW_objCMethodDecl_in_objCClassDef881);
            	    objCMethodDecl38=objCMethodDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, objCMethodDecl38.getTree());
            	    if ( state.backtracking==0 ) {
            	       
            	      				retval.struct.addDeclaration((objCMethodDecl38!=null?objCMethodDecl38.function:null)); 
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:441:4: typeDef
            	    {
            	    pushFollow(FOLLOW_typeDef_in_objCClassDef890);
            	    typeDef39=typeDef();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeDef39.getTree());
            	    if ( state.backtracking==0 ) {

            	      				retval.struct.addDeclaration((typeDef39!=null?typeDef39.typeDef:null)); 
            	      			
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:444:4: vd= varDecl {...}?
            	    {
            	    pushFollow(FOLLOW_varDecl_in_objCClassDef901);
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
            	    break loop22;
                }
            } while (true);

            string_literal40=(Token)match(input,41,FOLLOW_41_in_objCClassDef914); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal40_tree = (Object)adaptor.create(string_literal40);
            adaptor.addChild(root_0, string_literal40_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:451:1: objCMethodDecl returns [Function function] : tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= typeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';' ;
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
        Token char_literal41=null;
        Token char_literal42=null;
        Token char_literal43=null;
        Token char_literal44=null;
        Token char_literal45=null;
        Token char_literal46=null;
        Token char_literal47=null;
        Token char_literal48=null;
        Token char_literal49=null;
        Token string_literal50=null;
        Token char_literal51=null;
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
        Object char_literal41_tree=null;
        Object char_literal42_tree=null;
        Object char_literal43_tree=null;
        Object char_literal44_tree=null;
        Object char_literal45_tree=null;
        Object char_literal46_tree=null;
        Object char_literal47_tree=null;
        Object char_literal48_tree=null;
        Object char_literal49_tree=null;
        Object string_literal50_tree=null;
        Object char_literal51_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:452:2: (tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= typeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:452:4: tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= typeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               	
              			retval.function = new Function(); 
              			retval.function.setType(Function.Type.ObjCMethod);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:456:6: (tp= '+' | tm= '-' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==42) ) {
                alt23=1;
            }
            else if ( (LA23_0==43) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:457:4: tp= '+'
                    {
                    tp=(Token)match(input,42,FOLLOW_42_in_objCMethodDecl948); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:462:4: tm= '-'
                    {
                    tm=(Token)match(input,43,FOLLOW_43_in_objCMethodDecl960); if (state.failed) return retval;
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:467:3: ( '(' (returnTypeRef= typeRef )? ')' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==34) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:469:4: '(' (returnTypeRef= typeRef )? ')'
                    {
                    char_literal41=(Token)match(input,34,FOLLOW_34_in_objCMethodDecl979); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal41_tree = (Object)adaptor.create(char_literal41);
                    adaptor.addChild(root_0, char_literal41_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:470:18: (returnTypeRef= typeRef )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==IDENTIFIER||LA24_0==30||(LA24_0>=45 && LA24_0<=47)||(LA24_0>=60 && LA24_0<=74)) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: returnTypeRef= typeRef
                            {
                            pushFollow(FOLLOW_typeRef_in_objCMethodDecl987);
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
                    char_literal42=(Token)match(input,35,FOLLOW_35_in_objCMethodDecl995); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal42_tree = (Object)adaptor.create(char_literal42);
                    adaptor.addChild(root_0, char_literal42_tree);
                    }

                    }
                    break;

            }

            methodName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1006); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            methodName_tree = (Object)adaptor.create(methodName);
            adaptor.addChild(root_0, methodName_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.function.setName((methodName!=null?methodName.getText():null)); 
              			retval.function.setCommentAfter(getCommentAfterOnSameLine(methodName.getTokenIndex()));
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:479:3: ( ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==33) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:480:4: ':' '(' argType1= typeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )* ( ',' '...' )?
                    {
                    char_literal43=(Token)match(input,33,FOLLOW_33_in_objCMethodDecl1018); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal43_tree = (Object)adaptor.create(char_literal43);
                    adaptor.addChild(root_0, char_literal43_tree);
                    }
                    char_literal44=(Token)match(input,34,FOLLOW_34_in_objCMethodDecl1020); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal44_tree = (Object)adaptor.create(char_literal44);
                    adaptor.addChild(root_0, char_literal44_tree);
                    }
                    pushFollow(FOLLOW_typeRef_in_objCMethodDecl1024);
                    argType1=typeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, argType1.getTree());
                    char_literal45=(Token)match(input,35,FOLLOW_35_in_objCMethodDecl1026); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal45_tree = (Object)adaptor.create(char_literal45);
                    adaptor.addChild(root_0, char_literal45_tree);
                    }
                    argName1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1030); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    argName1_tree = (Object)adaptor.create(argName1);
                    adaptor.addChild(root_0, argName1_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				Arg arg = new Arg((argName1!=null?argName1.getText():null), (argType1!=null?argType1.type:null));
                      				arg.setSelector((methodName!=null?methodName.getText():null));
                      				retval.function.addArg(arg);
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:485:4: (sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==IDENTIFIER) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:486:5: sel= IDENTIFIER ':' '(' argType= typeRef ')' argName= IDENTIFIER
                    	    {
                    	    sel=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1045); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    sel_tree = (Object)adaptor.create(sel);
                    	    adaptor.addChild(root_0, sel_tree);
                    	    }
                    	    char_literal46=(Token)match(input,33,FOLLOW_33_in_objCMethodDecl1047); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal46_tree = (Object)adaptor.create(char_literal46);
                    	    adaptor.addChild(root_0, char_literal46_tree);
                    	    }
                    	    char_literal47=(Token)match(input,34,FOLLOW_34_in_objCMethodDecl1054); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal47_tree = (Object)adaptor.create(char_literal47);
                    	    adaptor.addChild(root_0, char_literal47_tree);
                    	    }
                    	    pushFollow(FOLLOW_typeRef_in_objCMethodDecl1058);
                    	    argType=typeRef();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, argType.getTree());
                    	    char_literal48=(Token)match(input,35,FOLLOW_35_in_objCMethodDecl1060); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal48_tree = (Object)adaptor.create(char_literal48);
                    	    adaptor.addChild(root_0, char_literal48_tree);
                    	    }
                    	    argName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1069); if (state.failed) return retval;
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
                    	    break loop26;
                        }
                    } while (true);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:494:4: ( ',' '...' )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==27) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:495:5: ',' '...'
                            {
                            char_literal49=(Token)match(input,27,FOLLOW_27_in_objCMethodDecl1088); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal49_tree = (Object)adaptor.create(char_literal49);
                            adaptor.addChild(root_0, char_literal49_tree);
                            }
                            string_literal50=(Token)match(input,44,FOLLOW_44_in_objCMethodDecl1090); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal50_tree = (Object)adaptor.create(string_literal50);
                            adaptor.addChild(root_0, string_literal50_tree);
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

            char_literal51=(Token)match(input,28,FOLLOW_28_in_objCMethodDecl1107); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal51_tree = (Object)adaptor.create(char_literal51);
            adaptor.addChild(root_0, char_literal51_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:516:1: structCore returns [Struct struct, List<Modifier> modifiers] : t= ( 'struct' | 'class' | 'union' ) ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' ) ;
    public final ObjCppParser.structCore_return structCore() throws RecognitionException {
        ObjCppParser.structCore_return retval = new ObjCppParser.structCore_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token t=null;
        Token n0=null;
        Token n1=null;
        Token char_literal53=null;
        Token string_literal54=null;
        Token string_literal55=null;
        Token string_literal56=null;
        Token char_literal57=null;
        Token char_literal59=null;
        ObjCppParser.exportationModifiers_return exportationModifiers52 = null;

        ObjCppParser.declaration_return declaration58 = null;


        Object t_tree=null;
        Object n0_tree=null;
        Object n1_tree=null;
        Object char_literal53_tree=null;
        Object string_literal54_tree=null;
        Object string_literal55_tree=null;
        Object string_literal56_tree=null;
        Object char_literal57_tree=null;
        Object char_literal59_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:517:2: (t= ( 'struct' | 'class' | 'union' ) ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:519:3: t= ( 'struct' | 'class' | 'union' ) ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' )
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:528:3: ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' )
            int alt33=2;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:529:4: (n0= IDENTIFIER )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:529:4: (n0= IDENTIFIER )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:530:5: n0= IDENTIFIER
                    {
                    n0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_structCore1162); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:535:4: ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}'
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:535:4: ( ( exportationModifiers )? n1= IDENTIFIER )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==IDENTIFIER) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:536:5: ( exportationModifiers )? n1= IDENTIFIER
                            {
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:536:5: ( exportationModifiers )?
                            int alt29=2;
                            int LA29_0 = input.LA(1);

                            if ( (LA29_0==IDENTIFIER) ) {
                                int LA29_1 = input.LA(2);

                                if ( (synpred44_ObjCpp()) ) {
                                    alt29=1;
                                }
                            }
                            switch (alt29) {
                                case 1 :
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:536:7: exportationModifiers
                                    {
                                    pushFollow(FOLLOW_exportationModifiers_in_structCore1185);
                                    exportationModifiers52=exportationModifiers();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) adaptor.addChild(root_0, exportationModifiers52.getTree());
                                    if ( state.backtracking==0 ) {

                                      					retval.struct.addModifiers((exportationModifiers52!=null?exportationModifiers52.modifiers:null));
                                      				
                                    }

                                    }
                                    break;

                            }

                            n1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_structCore1198); if (state.failed) return retval;
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

                    char_literal53=(Token)match(input,23,FOLLOW_23_in_structCore1212); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal53_tree = (Object)adaptor.create(char_literal53);
                    adaptor.addChild(root_0, char_literal53_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.struct.setForwardDeclaration(false); 
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:542:5: ( ( 'public' | 'private' | 'protected' ) ':' | declaration )*
                    loop32:
                    do {
                        int alt32=3;
                        alt32 = dfa32.predict(input);
                        switch (alt32) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:543:6: ( 'public' | 'private' | 'protected' ) ':'
                    	    {
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:543:6: ( 'public' | 'private' | 'protected' )
                    	    int alt31=3;
                    	    switch ( input.LA(1) ) {
                    	    case 48:
                    	        {
                    	        alt31=1;
                    	        }
                    	        break;
                    	    case 49:
                    	        {
                    	        alt31=2;
                    	        }
                    	        break;
                    	    case 50:
                    	        {
                    	        alt31=3;
                    	        }
                    	        break;
                    	    default:
                    	        if (state.backtracking>0) {state.failed=true; return retval;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 31, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt31) {
                    	        case 1 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:544:7: 'public'
                    	            {
                    	            string_literal54=(Token)match(input,48,FOLLOW_48_in_structCore1235); if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) {
                    	            string_literal54_tree = (Object)adaptor.create(string_literal54);
                    	            adaptor.addChild(root_0, string_literal54_tree);
                    	            }
                    	            if ( state.backtracking==0 ) {
                    	               retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Public); 
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:545:7: 'private'
                    	            {
                    	            string_literal55=(Token)match(input,49,FOLLOW_49_in_structCore1248); if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) {
                    	            string_literal55_tree = (Object)adaptor.create(string_literal55);
                    	            adaptor.addChild(root_0, string_literal55_tree);
                    	            }
                    	            if ( state.backtracking==0 ) {
                    	               retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Private); 
                    	            }

                    	            }
                    	            break;
                    	        case 3 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:546:7: 'protected'
                    	            {
                    	            string_literal56=(Token)match(input,50,FOLLOW_50_in_structCore1261); if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) {
                    	            string_literal56_tree = (Object)adaptor.create(string_literal56);
                    	            adaptor.addChild(root_0, string_literal56_tree);
                    	            }
                    	            if ( state.backtracking==0 ) {
                    	               retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Protected); 
                    	            }

                    	            }
                    	            break;

                    	    }

                    	    char_literal57=(Token)match(input,33,FOLLOW_33_in_structCore1273); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal57_tree = (Object)adaptor.create(char_literal57);
                    	    adaptor.addChild(root_0, char_literal57_tree);
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:548:6: declaration
                    	    {
                    	    pushFollow(FOLLOW_declaration_in_structCore1282);
                    	    declaration58=declaration();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration58.getTree());
                    	    if ( state.backtracking==0 ) {

                    	      						retval.struct.addDeclarations((declaration58!=null?declaration58.declarations:null));
                    	      					
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);

                    char_literal59=(Token)match(input,24,FOLLOW_24_in_structCore1296); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal59_tree = (Object)adaptor.create(char_literal59);
                    adaptor.addChild(root_0, char_literal59_tree);
                    }
                    if ( state.backtracking==0 ) {

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:567:1: functionDeclaration returns [Function function] : preMods1= exportationModifiers (returnTypeRef= typeRef )? preMods2= exportationModifiers n= IDENTIFIER argList ({...}?ct= IDENTIFIER | ) postMods= exportationModifiers ( ';' | statementsBlock ) ;
    public final ObjCppParser.functionDeclaration_return functionDeclaration() throws RecognitionException {
        ObjCppParser.functionDeclaration_return retval = new ObjCppParser.functionDeclaration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token ct=null;
        Token char_literal61=null;
        ObjCppParser.exportationModifiers_return preMods1 = null;

        ObjCppParser.typeRef_return returnTypeRef = null;

        ObjCppParser.exportationModifiers_return preMods2 = null;

        ObjCppParser.exportationModifiers_return postMods = null;

        ObjCppParser.argList_return argList60 = null;

        ObjCppParser.statementsBlock_return statementsBlock62 = null;


        Object n_tree=null;
        Object ct_tree=null;
        Object char_literal61_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:568:2: (preMods1= exportationModifiers (returnTypeRef= typeRef )? preMods2= exportationModifiers n= IDENTIFIER argList ({...}?ct= IDENTIFIER | ) postMods= exportationModifiers ( ';' | statementsBlock ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:568:4: preMods1= exportationModifiers (returnTypeRef= typeRef )? preMods2= exportationModifiers n= IDENTIFIER argList ({...}?ct= IDENTIFIER | ) postMods= exportationModifiers ( ';' | statementsBlock )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               	
              			retval.function = mark(new Function(), -1);
              			retval.function.setType(Function.Type.CFunction);
              		
            }
            pushFollow(FOLLOW_exportationModifiers_in_functionDeclaration1329);
            preMods1=exportationModifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, preMods1.getTree());
            if ( state.backtracking==0 ) {

              			retval.function.addModifiers((preMods1!=null?preMods1.modifiers:null));
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:578:16: (returnTypeRef= typeRef )?
            int alt34=2;
            alt34 = dfa34.predict(input);
            switch (alt34) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: returnTypeRef= typeRef
                    {
                    pushFollow(FOLLOW_typeRef_in_functionDeclaration1337);
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
            pushFollow(FOLLOW_exportationModifiers_in_functionDeclaration1346);
            preMods2=exportationModifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, preMods2.getTree());
            if ( state.backtracking==0 ) {

              			retval.function.addModifiers((preMods2!=null?preMods2.modifiers:null));
              		
            }
            n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionDeclaration1354); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.function.setName((n!=null?n.getText():null)); 
              			retval.function = mark(retval.function, getLine(n));
              		
            }
            pushFollow(FOLLOW_argList_in_functionDeclaration1361);
            argList60=argList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, argList60.getTree());
            if ( state.backtracking==0 ) {

              			retval.function.setArgs((argList60!=null?argList60.args:null));
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:591:3: ({...}?ct= IDENTIFIER | )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==IDENTIFIER) ) {
                int LA35_1 = input.LA(2);

                if ( ((synpred51_ObjCpp()&&( next("const", "__const") ))) ) {
                    alt35=1;
                }
                else if ( (true) ) {
                    alt35=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA35_0==23||LA35_0==28) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:591:4: {...}?ct= IDENTIFIER
                    {
                    if ( !(( next("const", "__const") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "functionDeclaration", " next(\"const\", \"__const\") ");
                    }
                    ct=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionDeclaration1372); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ct_tree = (Object)adaptor.create(ct);
                    adaptor.addChild(root_0, ct_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			if ((ct!=null?ct.getText():null) != null)
                      				retval.function.addModifiers(Modifier.Const);
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:594:6: 
                    {
                    }
                    break;

            }

            pushFollow(FOLLOW_exportationModifiers_in_functionDeclaration1383);
            postMods=exportationModifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, postMods.getTree());
            if ( state.backtracking==0 ) {

              			for (Modifier m : (postMods!=null?postMods.modifiers:null))
              				retval.function.addModifiers(m);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:599:3: ( ';' | statementsBlock )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==28) ) {
                alt36=1;
            }
            else if ( (LA36_0==23) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:600:4: ';'
                    {
                    char_literal61=(Token)match(input,28,FOLLOW_28_in_functionDeclaration1395); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal61_tree = (Object)adaptor.create(char_literal61);
                    adaptor.addChild(root_0, char_literal61_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:601:4: statementsBlock
                    {
                    pushFollow(FOLLOW_statementsBlock_in_functionDeclaration1402);
                    statementsBlock62=statementsBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementsBlock62.getTree());
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

    public static class exportationModifiers_return extends ParserRuleReturnScope {
        public List<Modifier> modifiers;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exportationModifiers"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:607:1: exportationModifiers returns [List<Modifier> modifiers] : ( exportationModifier )* ;
    public final ObjCppParser.exportationModifiers_return exportationModifiers() throws RecognitionException {
        ObjCppParser.exportationModifiers_return retval = new ObjCppParser.exportationModifiers_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.exportationModifier_return exportationModifier63 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:608:2: ( ( exportationModifier )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:608:5: ( exportationModifier )*
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:609:3: ( exportationModifier )*
            loop37:
            do {
                int alt37=2;
                alt37 = dfa37.predict(input);
                switch (alt37) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:610:4: exportationModifier
            	    {
            	    pushFollow(FOLLOW_exportationModifier_in_exportationModifiers1435);
            	    exportationModifier63=exportationModifier();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, exportationModifier63.getTree());
            	    if ( state.backtracking==0 ) {
            	       
            	      				retval.modifiers.addAll((exportationModifier63!=null?exportationModifier63.modifiers:null)); 
            	      			
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
    // $ANTLR end "exportationModifiers"

    public static class modifier_return extends ParserRuleReturnScope {
        public Modifier modifier;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "modifier"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:616:1: modifier returns [Modifier modifier] : {...}? IDENTIFIER ;
    public final ObjCppParser.modifier_return modifier() throws RecognitionException {
        ObjCppParser.modifier_return retval = new ObjCppParser.modifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER64=null;

        Object IDENTIFIER64_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:617:2: ({...}? IDENTIFIER )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:617:4: {...}? IDENTIFIER
            {
            root_0 = (Object)adaptor.nil();

            if ( !(( Modifier.parseModifier(next()) != null )) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "modifier", " Modifier.parseModifier(next()) != null ");
            }
            IDENTIFIER64=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier1462); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER64_tree = (Object)adaptor.create(IDENTIFIER64);
            adaptor.addChild(root_0, IDENTIFIER64_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.modifier = Modifier.parseModifier((IDENTIFIER64!=null?IDENTIFIER64.getText():null));
              		
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:630:1: exportationModifier returns [List<Modifier> modifiers] : ({...}? modifier | IDENTIFIER {...}? '(' extendedModifiers ')' ) ;
    public final ObjCppParser.exportationModifier_return exportationModifier() throws RecognitionException {
        ObjCppParser.exportationModifier_return retval = new ObjCppParser.exportationModifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER66=null;
        Token char_literal67=null;
        Token char_literal69=null;
        ObjCppParser.modifier_return modifier65 = null;

        ObjCppParser.extendedModifiers_return extendedModifiers68 = null;


        Object IDENTIFIER66_tree=null;
        Object char_literal67_tree=null;
        Object char_literal69_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:631:2: ( ({...}? modifier | IDENTIFIER {...}? '(' extendedModifiers ')' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:631:5: ({...}? modifier | IDENTIFIER {...}? '(' extendedModifiers ')' )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:632:3: ({...}? modifier | IDENTIFIER {...}? '(' extendedModifiers ')' )
            int alt38=2;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:633:4: {...}? modifier
                    {
                    if ( !(( next(Modifier.Kind.Plain) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "exportationModifier", " next(Modifier.Kind.Plain) ");
                    }
                    pushFollow(FOLLOW_modifier_in_exportationModifier1494);
                    modifier65=modifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modifier65.getTree());
                    if ( state.backtracking==0 ) {

                      				retval.modifiers.add((modifier65!=null?modifier65.modifier:null));
                      			
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:636:4: IDENTIFIER {...}? '(' extendedModifiers ')'
                    {
                    IDENTIFIER66=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_exportationModifier1503); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER66_tree = (Object)adaptor.create(IDENTIFIER66);
                    adaptor.addChild(root_0, IDENTIFIER66_tree);
                    }
                    if ( !(( (IDENTIFIER66!=null?IDENTIFIER66.getText():null).equals("__declspec") || (IDENTIFIER66!=null?IDENTIFIER66.getText():null).equals("__attribute__") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "exportationModifier", " $IDENTIFIER.text.equals(\"__declspec\") || $IDENTIFIER.text.equals(\"__attribute__\") ");
                    }
                    char_literal67=(Token)match(input,34,FOLLOW_34_in_exportationModifier1511); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal67_tree = (Object)adaptor.create(char_literal67);
                    adaptor.addChild(root_0, char_literal67_tree);
                    }
                    pushFollow(FOLLOW_extendedModifiers_in_exportationModifier1513);
                    extendedModifiers68=extendedModifiers();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, extendedModifiers68.getTree());
                    char_literal69=(Token)match(input,35,FOLLOW_35_in_exportationModifier1515); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal69_tree = (Object)adaptor.create(char_literal69);
                    adaptor.addChild(root_0, char_literal69_tree);
                    }
                    if ( state.backtracking==0 ) {

                      					retval.modifiers.addAll((extendedModifiers68!=null?extendedModifiers68.modifiers:null));
                      			
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:644:1: extendedModifiers returns [List<Modifier> modifiers] : ({...}?m= modifier () )* ;
    public final ObjCppParser.extendedModifiers_return extendedModifiers() throws RecognitionException {
        ObjCppParser.extendedModifiers_return retval = new ObjCppParser.extendedModifiers_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.modifier_return m = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:645:2: ( ({...}?m= modifier () )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:645:4: ({...}?m= modifier () )*
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:646:3: ({...}?m= modifier () )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==IDENTIFIER) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:647:4: {...}?m= modifier ()
            	    {
            	    if ( !(( next(Modifier.Kind.Extended) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "extendedModifiers", " next(Modifier.Kind.Extended) ");
            	    }
            	    pushFollow(FOLLOW_modifier_in_extendedModifiers1550);
            	    m=modifier();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, m.getTree());
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:648:4: ()
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:649:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					retval.modifiers.add((m!=null?m.modifier:null));
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:659:1: argDef returns [Arg arg] : ( ({...}?sm= modifier | {...}?tm= modifier )* ( typeRef ) ( ( declarator )? ) ( '=' expression )? | '...' );
    public final ObjCppParser.argDef_return argDef() throws RecognitionException {
        ObjCppParser.argDef_return retval = new ObjCppParser.argDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal72=null;
        Token string_literal74=null;
        ObjCppParser.modifier_return sm = null;

        ObjCppParser.modifier_return tm = null;

        ObjCppParser.typeRef_return typeRef70 = null;

        ObjCppParser.declarator_return declarator71 = null;

        ObjCppParser.expression_return expression73 = null;


        Object char_literal72_tree=null;
        Object string_literal74_tree=null;


        	List<Modifier> stoMods = new ArrayList<Modifier>(), typMods = new ArrayList<Modifier>();

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:663:2: ( ({...}?sm= modifier | {...}?tm= modifier )* ( typeRef ) ( ( declarator )? ) ( '=' expression )? | '...' )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==IDENTIFIER||LA43_0==30||(LA43_0>=45 && LA43_0<=47)||(LA43_0>=60 && LA43_0<=74)) ) {
                alt43=1;
            }
            else if ( (LA43_0==44) ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:663:4: ({...}?sm= modifier | {...}?tm= modifier )* ( typeRef ) ( ( declarator )? ) ( '=' expression )?
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( state.backtracking==0 ) {
                       
                      			retval.arg = new Arg(); 
                      			int i = getTokenStream().index() + 1;
                      			retval.arg.setCommentBefore(getCommentBefore(i));
                      			retval.arg.setCommentAfter(getCommentAfterOnSameLine(i));
                      		
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:669:3: ({...}?sm= modifier | {...}?tm= modifier )*
                    loop40:
                    do {
                        int alt40=3;
                        alt40 = dfa40.predict(input);
                        switch (alt40) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:670:4: {...}?sm= modifier
                    	    {
                    	    if ( !(( next(Modifier.Kind.StorageClassSpecifier) )) ) {
                    	        if (state.backtracking>0) {state.failed=true; return retval;}
                    	        throw new FailedPredicateException(input, "argDef", " next(Modifier.Kind.StorageClassSpecifier) ");
                    	    }
                    	    pushFollow(FOLLOW_modifier_in_argDef1609);
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
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:672:4: {...}?tm= modifier
                    	    {
                    	    if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
                    	        if (state.backtracking>0) {state.failed=true; return retval;}
                    	        throw new FailedPredicateException(input, "argDef", " next(Modifier.Kind.TypeQualifier) ");
                    	    }
                    	    pushFollow(FOLLOW_modifier_in_argDef1626);
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
                    	    break loop40;
                        }
                    } while (true);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:675:3: ( typeRef )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:678:4: typeRef
                    {
                    pushFollow(FOLLOW_typeRef_in_argDef1650);
                    typeRef70=typeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRef70.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				if ((typeRef70!=null?typeRef70.type:null) != null) {
                      					(typeRef70!=null?typeRef70.type:null).addModifiers(typMods);
                      					(typeRef70!=null?typeRef70.type:null).addModifiers(stoMods);
                      					retval.arg.setValueType((typeRef70!=null?typeRef70.type:null)); 
                      				}
                      			
                    }

                    }

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:686:3: ( ( declarator )? )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:687:4: ( declarator )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:687:4: ( declarator )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==IDENTIFIER||LA41_0==34||(LA41_0>=51 && LA41_0<=52)||LA41_0==58) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: declarator
                            {
                            pushFollow(FOLLOW_declarator_in_argDef1665);
                            declarator71=declarator();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, declarator71.getTree());

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       
                      				if ((declarator71!=null?declarator71.declarator:null) != null)
                      					retval.arg.setDeclarator((declarator71!=null?declarator71.declarator:null)); 
                      				else if (retval.arg.getValueType() instanceof FunctionSignature) {
                      					FunctionSignature fs = (FunctionSignature)retval.arg.getValueType();
                      					if (fs != null && fs.getFunction() != null) {
                      						retval.arg.setName(fs.getFunction().getName());
                      						fs.getFunction().setName(null);
                      					}
                      				}
                      			
                    }

                    }

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:718:3: ( '=' expression )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==29) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:718:4: '=' expression
                            {
                            char_literal72=(Token)match(input,29,FOLLOW_29_in_argDef1685); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal72_tree = (Object)adaptor.create(char_literal72);
                            adaptor.addChild(root_0, char_literal72_tree);
                            }
                            pushFollow(FOLLOW_expression_in_argDef1687);
                            expression73=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression73.getTree());
                            if ( state.backtracking==0 ) {

                              			retval.arg.setDefaultValue((expression73!=null?expression73.expr:null));
                              		
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:722:3: '...'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal74=(Token)match(input,44,FOLLOW_44_in_argDef1701); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal74_tree = (Object)adaptor.create(string_literal74);
                    adaptor.addChild(root_0, string_literal74_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:740:1: typeMutator returns [TypeMutator mutator] : ({...}? IDENTIFIER '*' | '*' | '&' | '[' ']' );
    public final ObjCppParser.typeMutator_return typeMutator() throws RecognitionException {
        ObjCppParser.typeMutator_return retval = new ObjCppParser.typeMutator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER75=null;
        Token char_literal76=null;
        Token char_literal77=null;
        Token char_literal78=null;
        Token char_literal79=null;
        Token char_literal80=null;

        Object IDENTIFIER75_tree=null;
        Object char_literal76_tree=null;
        Object char_literal77_tree=null;
        Object char_literal78_tree=null;
        Object char_literal79_tree=null;
        Object char_literal80_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:741:2: ({...}? IDENTIFIER '*' | '*' | '&' | '[' ']' )
            int alt44=4;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt44=1;
                }
                break;
            case 51:
                {
                alt44=2;
                }
                break;
            case 52:
                {
                alt44=3;
                }
                break;
            case 53:
                {
                alt44=4;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:741:4: {...}? IDENTIFIER '*'
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !(( next("const", "__const") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeMutator", " next(\"const\", \"__const\") ");
                    }
                    IDENTIFIER75=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_typeMutator1721); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER75_tree = (Object)adaptor.create(IDENTIFIER75);
                    adaptor.addChild(root_0, IDENTIFIER75_tree);
                    }
                    char_literal76=(Token)match(input,51,FOLLOW_51_in_typeMutator1723); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal76_tree = (Object)adaptor.create(char_literal76);
                    adaptor.addChild(root_0, char_literal76_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.mutator = TypeMutator.CONST_STAR; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:742:3: '*'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal77=(Token)match(input,51,FOLLOW_51_in_typeMutator1731); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal77_tree = (Object)adaptor.create(char_literal77);
                    adaptor.addChild(root_0, char_literal77_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.mutator = TypeMutator.STAR; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:743:3: '&'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal78=(Token)match(input,52,FOLLOW_52_in_typeMutator1739); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal78_tree = (Object)adaptor.create(char_literal78);
                    adaptor.addChild(root_0, char_literal78_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.mutator = TypeMutator.AMPERSTAND; 
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:744:3: '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal79=(Token)match(input,53,FOLLOW_53_in_typeMutator1748); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal79_tree = (Object)adaptor.create(char_literal79);
                    adaptor.addChild(root_0, char_literal79_tree);
                    }
                    char_literal80=(Token)match(input,54,FOLLOW_54_in_typeMutator1750); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal80_tree = (Object)adaptor.create(char_literal80);
                    adaptor.addChild(root_0, char_literal80_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:747:1: arrayTypeMutator returns [TypeMutator mutator] : '[' expression ']' ;
    public final ObjCppParser.arrayTypeMutator_return arrayTypeMutator() throws RecognitionException {
        ObjCppParser.arrayTypeMutator_return retval = new ObjCppParser.arrayTypeMutator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal81=null;
        Token char_literal83=null;
        ObjCppParser.expression_return expression82 = null;


        Object char_literal81_tree=null;
        Object char_literal83_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:748:2: ( '[' expression ']' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:748:4: '[' expression ']'
            {
            root_0 = (Object)adaptor.nil();

            char_literal81=(Token)match(input,53,FOLLOW_53_in_arrayTypeMutator1768); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal81_tree = (Object)adaptor.create(char_literal81);
            adaptor.addChild(root_0, char_literal81_tree);
            }
            pushFollow(FOLLOW_expression_in_arrayTypeMutator1774);
            expression82=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression82.getTree());
            if ( state.backtracking==0 ) {

              				retval.mutator = TypeMutator.array((expression82!=null?expression82.expr:null)); 
              			
            }
            char_literal83=(Token)match(input,54,FOLLOW_54_in_arrayTypeMutator1783); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal83_tree = (Object)adaptor.create(char_literal83);
            adaptor.addChild(root_0, char_literal83_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:755:1: typeRefCore returns [TypeRef type] : ({...}? IDENTIFIER '(' 'return' binaryOp expression ')' | {...}?m1a= modifier '(' expression ')' | {...}?m2a= modifier '(' expression ',' expression ')' )? ({...}?m= modifier )? ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) ) ;
    public final ObjCppParser.typeRefCore_return typeRefCore() throws RecognitionException {
        ObjCppParser.typeRefCore_return retval = new ObjCppParser.typeRefCore_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ref=null;
        Token IDENTIFIER84=null;
        Token char_literal85=null;
        Token string_literal86=null;
        Token char_literal89=null;
        Token char_literal90=null;
        Token char_literal92=null;
        Token char_literal93=null;
        Token char_literal95=null;
        Token char_literal97=null;
        Token char_literal99=null;
        Token char_literal100=null;
        Token char_literal101=null;
        ObjCppParser.modifier_return m1a = null;

        ObjCppParser.modifier_return m2a = null;

        ObjCppParser.modifier_return m = null;

        ObjCppParser.modifier_return m1 = null;

        ObjCppParser.typeRef_return tr = null;

        ObjCppParser.typeRef_return t1 = null;

        ObjCppParser.typeRef_return tx = null;

        ObjCppParser.binaryOp_return binaryOp87 = null;

        ObjCppParser.expression_return expression88 = null;

        ObjCppParser.expression_return expression91 = null;

        ObjCppParser.expression_return expression94 = null;

        ObjCppParser.expression_return expression96 = null;

        ObjCppParser.primitiveTypeRef_return primitiveTypeRef98 = null;


        Object ref_tree=null;
        Object IDENTIFIER84_tree=null;
        Object char_literal85_tree=null;
        Object string_literal86_tree=null;
        Object char_literal89_tree=null;
        Object char_literal90_tree=null;
        Object char_literal92_tree=null;
        Object char_literal93_tree=null;
        Object char_literal95_tree=null;
        Object char_literal97_tree=null;
        Object char_literal99_tree=null;
        Object char_literal100_tree=null;
        Object char_literal101_tree=null;

         List<Modifier> mods = new ArrayList<Modifier>(); 
        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:757:2: ( ({...}? IDENTIFIER '(' 'return' binaryOp expression ')' | {...}?m1a= modifier '(' expression ')' | {...}?m2a= modifier '(' expression ',' expression ')' )? ({...}?m= modifier )? ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:758:3: ({...}? IDENTIFIER '(' 'return' binaryOp expression ')' | {...}?m1a= modifier '(' expression ')' | {...}?m2a= modifier '(' expression ',' expression ')' )? ({...}?m= modifier )? ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) )
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:758:3: ({...}? IDENTIFIER '(' 'return' binaryOp expression ')' | {...}?m1a= modifier '(' expression ')' | {...}?m2a= modifier '(' expression ',' expression ')' )?
            int alt45=4;
            alt45 = dfa45.predict(input);
            switch (alt45) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:761:4: {...}? IDENTIFIER '(' 'return' binaryOp expression ')'
                    {
                    if ( !(( "__success".equals(next()) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeRefCore", " \"__success\".equals(next()) ");
                    }
                    IDENTIFIER84=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_typeRefCore1823); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER84_tree = (Object)adaptor.create(IDENTIFIER84);
                    adaptor.addChild(root_0, IDENTIFIER84_tree);
                    }
                    char_literal85=(Token)match(input,34,FOLLOW_34_in_typeRefCore1826); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal85_tree = (Object)adaptor.create(char_literal85);
                    adaptor.addChild(root_0, char_literal85_tree);
                    }
                    string_literal86=(Token)match(input,55,FOLLOW_55_in_typeRefCore1828); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal86_tree = (Object)adaptor.create(string_literal86);
                    adaptor.addChild(root_0, string_literal86_tree);
                    }
                    pushFollow(FOLLOW_binaryOp_in_typeRefCore1830);
                    binaryOp87=binaryOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, binaryOp87.getTree());
                    pushFollow(FOLLOW_expression_in_typeRefCore1832);
                    expression88=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression88.getTree());
                    char_literal89=(Token)match(input,35,FOLLOW_35_in_typeRefCore1834); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal89_tree = (Object)adaptor.create(char_literal89);
                    adaptor.addChild(root_0, char_literal89_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:762:4: {...}?m1a= modifier '(' expression ')'
                    {
                    if ( !(( next(Modifier.Kind.VCAnnotation1Arg) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeRefCore", " next(Modifier.Kind.VCAnnotation1Arg) ");
                    }
                    pushFollow(FOLLOW_modifier_in_typeRefCore1845);
                    m1a=modifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, m1a.getTree());
                    char_literal90=(Token)match(input,34,FOLLOW_34_in_typeRefCore1848); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal90_tree = (Object)adaptor.create(char_literal90);
                    adaptor.addChild(root_0, char_literal90_tree);
                    }
                    pushFollow(FOLLOW_expression_in_typeRefCore1850);
                    expression91=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression91.getTree());
                    char_literal92=(Token)match(input,35,FOLLOW_35_in_typeRefCore1852); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal92_tree = (Object)adaptor.create(char_literal92);
                    adaptor.addChild(root_0, char_literal92_tree);
                    }
                    if ( state.backtracking==0 ) {
                       mods.add((m1a!=null?m1a.modifier:null)); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:763:4: {...}?m2a= modifier '(' expression ',' expression ')'
                    {
                    if ( !(( next(Modifier.Kind.VCAnnotation2Args) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeRefCore", " next(Modifier.Kind.VCAnnotation2Args) ");
                    }
                    pushFollow(FOLLOW_modifier_in_typeRefCore1865);
                    m2a=modifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, m2a.getTree());
                    char_literal93=(Token)match(input,34,FOLLOW_34_in_typeRefCore1868); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal93_tree = (Object)adaptor.create(char_literal93);
                    adaptor.addChild(root_0, char_literal93_tree);
                    }
                    pushFollow(FOLLOW_expression_in_typeRefCore1870);
                    expression94=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression94.getTree());
                    char_literal95=(Token)match(input,27,FOLLOW_27_in_typeRefCore1872); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal95_tree = (Object)adaptor.create(char_literal95);
                    adaptor.addChild(root_0, char_literal95_tree);
                    }
                    pushFollow(FOLLOW_expression_in_typeRefCore1874);
                    expression96=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression96.getTree());
                    char_literal97=(Token)match(input,35,FOLLOW_35_in_typeRefCore1876); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal97_tree = (Object)adaptor.create(char_literal97);
                    adaptor.addChild(root_0, char_literal97_tree);
                    }
                    if ( state.backtracking==0 ) {
                       mods.add((m2a!=null?m2a.modifier:null)); 
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:765:3: ({...}?m= modifier )?
            int alt46=2;
            alt46 = dfa46.predict(input);
            switch (alt46) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:765:4: {...}?m= modifier
                    {
                    if ( !(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeRefCore", " next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ");
                    }
                    pushFollow(FOLLOW_modifier_in_typeRefCore1893);
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:766:3: ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) )
            int alt51=2;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:4: {...}?m1= modifier tr= typeRef
                    {
                    if ( !(( next(Modifier.Kind.ReferenceQualifier) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "typeRefCore", " next(Modifier.Kind.ReferenceQualifier) ");
                    }
                    pushFollow(FOLLOW_modifier_in_typeRefCore1910);
                    m1=modifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, m1.getTree());
                    if ( state.backtracking==0 ) {
                       mods.add((m1!=null?m1.modifier:null)); 
                    }
                    pushFollow(FOLLOW_typeRef_in_typeRefCore1919);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:770:4: ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:770:4: ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) )
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( ((LA50_0>=60 && LA50_0<=74)) ) {
                        alt50=1;
                    }
                    else if ( (LA50_0==IDENTIFIER) ) {
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
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:771:5: primitiveTypeRef
                            {
                            pushFollow(FOLLOW_primitiveTypeRef_in_typeRefCore1939);
                            primitiveTypeRef98=primitiveTypeRef();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveTypeRef98.getTree());
                            if ( state.backtracking==0 ) {
                               retval.type = (primitiveTypeRef98!=null?primitiveTypeRef98.type:null); 
                            }

                            }
                            break;
                        case 2 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:772:5: {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' )
                            {
                            if ( !(( Modifier.parseModifier(next()) == null )) ) {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                throw new FailedPredicateException(input, "typeRefCore", " Modifier.parseModifier(next()) == null ");
                            }
                            ref=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_typeRefCore1954); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ref_tree = (Object)adaptor.create(ref);
                            adaptor.addChild(root_0, ref_tree);
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:772:64: ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' )
                            int alt49=2;
                            alt49 = dfa49.predict(input);
                            switch (alt49) {
                                case 1 :
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:773:6: 
                                    {
                                    if ( state.backtracking==0 ) {
                                       retval.type = new SimpleTypeRef((ref!=null?ref.getText():null)); 
                                    }

                                    }
                                    break;
                                case 2 :
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:774:6: '<' (t1= typeRef ( ',' tx= typeRef )* )? '>'
                                    {
                                    char_literal99=(Token)match(input,36,FOLLOW_36_in_typeRefCore1972); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    char_literal99_tree = (Object)adaptor.create(char_literal99);
                                    adaptor.addChild(root_0, char_literal99_tree);
                                    }
                                    if ( state.backtracking==0 ) {
                                       retval.type = new TemplateRef((ref!=null?ref.getText():null)); 
                                    }
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:775:7: (t1= typeRef ( ',' tx= typeRef )* )?
                                    int alt48=2;
                                    int LA48_0 = input.LA(1);

                                    if ( (LA48_0==IDENTIFIER||LA48_0==30||(LA48_0>=45 && LA48_0<=47)||(LA48_0>=60 && LA48_0<=74)) ) {
                                        alt48=1;
                                    }
                                    switch (alt48) {
                                        case 1 :
                                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:776:8: t1= typeRef ( ',' tx= typeRef )*
                                            {
                                            pushFollow(FOLLOW_typeRef_in_typeRefCore1993);
                                            t1=typeRef();

                                            state._fsp--;
                                            if (state.failed) return retval;
                                            if ( state.backtracking==0 ) adaptor.addChild(root_0, t1.getTree());
                                            if ( state.backtracking==0 ) {
                                               ((TemplateRef)retval.type).addParameter((t1!=null?t1.type:null)); 
                                            }
                                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:777:8: ( ',' tx= typeRef )*
                                            loop47:
                                            do {
                                                int alt47=2;
                                                int LA47_0 = input.LA(1);

                                                if ( (LA47_0==27) ) {
                                                    alt47=1;
                                                }


                                                switch (alt47) {
                                            	case 1 :
                                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:778:9: ',' tx= typeRef
                                            	    {
                                            	    char_literal100=(Token)match(input,27,FOLLOW_27_in_typeRefCore2014); if (state.failed) return retval;
                                            	    if ( state.backtracking==0 ) {
                                            	    char_literal100_tree = (Object)adaptor.create(char_literal100);
                                            	    adaptor.addChild(root_0, char_literal100_tree);
                                            	    }
                                            	    pushFollow(FOLLOW_typeRef_in_typeRefCore2027);
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
                                            	    break loop47;
                                                }
                                            } while (true);


                                            }
                                            break;

                                    }

                                    char_literal101=(Token)match(input,37,FOLLOW_37_in_typeRefCore2055); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    char_literal101_tree = (Object)adaptor.create(char_literal101);
                                    adaptor.addChild(root_0, char_literal101_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:793:1: templateDef : ( 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' structCore | functionDeclaration );
    public final ObjCppParser.templateDef_return templateDef() throws RecognitionException {
        ObjCppParser.templateDef_return retval = new ObjCppParser.templateDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal102=null;
        Token char_literal103=null;
        Token char_literal105=null;
        Token char_literal107=null;
        ObjCppParser.templateArgDecl_return templateArgDecl104 = null;

        ObjCppParser.templateArgDecl_return templateArgDecl106 = null;

        ObjCppParser.structCore_return structCore108 = null;

        ObjCppParser.functionDeclaration_return functionDeclaration109 = null;


        Object string_literal102_tree=null;
        Object char_literal103_tree=null;
        Object char_literal105_tree=null;
        Object char_literal107_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:794:2: ( 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' structCore | functionDeclaration )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==56) ) {
                alt54=1;
            }
            else if ( (LA54_0==IDENTIFIER||LA54_0==30||(LA54_0>=45 && LA54_0<=47)||(LA54_0>=60 && LA54_0<=74)) ) {
                alt54=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:794:4: 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' structCore
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal102=(Token)match(input,56,FOLLOW_56_in_templateDef2087); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal102_tree = (Object)adaptor.create(string_literal102);
                    adaptor.addChild(root_0, string_literal102_tree);
                    }
                    char_literal103=(Token)match(input,36,FOLLOW_36_in_templateDef2089); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal103_tree = (Object)adaptor.create(char_literal103);
                    adaptor.addChild(root_0, char_literal103_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:794:19: ( templateArgDecl ( ',' templateArgDecl )* )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==46||LA53_0==57||(LA53_0>=60 && LA53_0<=74)) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:794:20: templateArgDecl ( ',' templateArgDecl )*
                            {
                            pushFollow(FOLLOW_templateArgDecl_in_templateDef2092);
                            templateArgDecl104=templateArgDecl();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, templateArgDecl104.getTree());
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:794:36: ( ',' templateArgDecl )*
                            loop52:
                            do {
                                int alt52=2;
                                int LA52_0 = input.LA(1);

                                if ( (LA52_0==27) ) {
                                    alt52=1;
                                }


                                switch (alt52) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:794:37: ',' templateArgDecl
                            	    {
                            	    char_literal105=(Token)match(input,27,FOLLOW_27_in_templateDef2095); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    char_literal105_tree = (Object)adaptor.create(char_literal105);
                            	    adaptor.addChild(root_0, char_literal105_tree);
                            	    }
                            	    pushFollow(FOLLOW_templateArgDecl_in_templateDef2097);
                            	    templateArgDecl106=templateArgDecl();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, templateArgDecl106.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop52;
                                }
                            } while (true);


                            }
                            break;

                    }

                    char_literal107=(Token)match(input,37,FOLLOW_37_in_templateDef2104); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal107_tree = (Object)adaptor.create(char_literal107);
                    adaptor.addChild(root_0, char_literal107_tree);
                    }
                    pushFollow(FOLLOW_structCore_in_templateDef2108);
                    structCore108=structCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structCore108.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:795:16: functionDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_functionDeclaration_in_templateDef2112);
                    functionDeclaration109=functionDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionDeclaration109.getTree());

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:798:1: templateArgDecl : ( primitiveTypeRef ( '=' constant ) | ( 'typename' | 'class' ) IDENTIFIER ( '=' typeRef ) );
    public final ObjCppParser.templateArgDecl_return templateArgDecl() throws RecognitionException {
        ObjCppParser.templateArgDecl_return retval = new ObjCppParser.templateArgDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal111=null;
        Token set113=null;
        Token IDENTIFIER114=null;
        Token char_literal115=null;
        ObjCppParser.primitiveTypeRef_return primitiveTypeRef110 = null;

        ObjCppParser.constant_return constant112 = null;

        ObjCppParser.typeRef_return typeRef116 = null;


        Object char_literal111_tree=null;
        Object set113_tree=null;
        Object IDENTIFIER114_tree=null;
        Object char_literal115_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:799:2: ( primitiveTypeRef ( '=' constant ) | ( 'typename' | 'class' ) IDENTIFIER ( '=' typeRef ) )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( ((LA55_0>=60 && LA55_0<=74)) ) {
                alt55=1;
            }
            else if ( (LA55_0==46||LA55_0==57) ) {
                alt55=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:799:4: primitiveTypeRef ( '=' constant )
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primitiveTypeRef_in_templateArgDecl2124);
                    primitiveTypeRef110=primitiveTypeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, primitiveTypeRef110.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:799:21: ( '=' constant )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:799:22: '=' constant
                    {
                    char_literal111=(Token)match(input,29,FOLLOW_29_in_templateArgDecl2127); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal111_tree = (Object)adaptor.create(char_literal111);
                    adaptor.addChild(root_0, char_literal111_tree);
                    }
                    pushFollow(FOLLOW_constant_in_templateArgDecl2129);
                    constant112=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant112.getTree());

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:800:3: ( 'typename' | 'class' ) IDENTIFIER ( '=' typeRef )
                    {
                    root_0 = (Object)adaptor.nil();

                    set113=(Token)input.LT(1);
                    if ( input.LA(1)==46||input.LA(1)==57 ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set113));
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    IDENTIFIER114=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_templateArgDecl2144); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER114_tree = (Object)adaptor.create(IDENTIFIER114);
                    adaptor.addChild(root_0, IDENTIFIER114_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:800:37: ( '=' typeRef )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:800:38: '=' typeRef
                    {
                    char_literal115=(Token)match(input,29,FOLLOW_29_in_templateArgDecl2147); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal115_tree = (Object)adaptor.create(char_literal115);
                    adaptor.addChild(root_0, char_literal115_tree);
                    }
                    pushFollow(FOLLOW_typeRef_in_templateArgDecl2149);
                    typeRef116=typeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRef116.getTree());

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:803:1: functionSignatureSuffix returns [FunctionSignature signature] : tk= '(' exportationModifiers '*' ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' ;
    public final ObjCppParser.functionSignatureSuffix_return functionSignatureSuffix() throws RecognitionException {
        ObjCppParser.functionSignatureSuffix_return retval = new ObjCppParser.functionSignatureSuffix_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token tk=null;
        Token char_literal118=null;
        Token IDENTIFIER119=null;
        Token char_literal120=null;
        Token char_literal121=null;
        Token char_literal122=null;
        Token char_literal123=null;
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;

        ObjCppParser.exportationModifiers_return exportationModifiers117 = null;


        Object tk_tree=null;
        Object char_literal118_tree=null;
        Object IDENTIFIER119_tree=null;
        Object char_literal120_tree=null;
        Object char_literal121_tree=null;
        Object char_literal122_tree=null;
        Object char_literal123_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:804:2: (tk= '(' exportationModifiers '*' ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:804:4: tk= '(' exportationModifiers '*' ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')'
            {
            root_0 = (Object)adaptor.nil();

            tk=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffix2168); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tk_tree = (Object)adaptor.create(tk);
            adaptor.addChild(root_0, tk_tree);
            }
            pushFollow(FOLLOW_exportationModifiers_in_functionSignatureSuffix2170);
            exportationModifiers117=exportationModifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exportationModifiers117.getTree());
            char_literal118=(Token)match(input,51,FOLLOW_51_in_functionSignatureSuffix2172); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal118_tree = (Object)adaptor.create(char_literal118);
            adaptor.addChild(root_0, char_literal118_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:804:36: ( IDENTIFIER )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==IDENTIFIER) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: IDENTIFIER
                    {
                    IDENTIFIER119=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionSignatureSuffix2174); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER119_tree = (Object)adaptor.create(IDENTIFIER119);
                    adaptor.addChild(root_0, IDENTIFIER119_tree);
                    }

                    }
                    break;

            }

            char_literal120=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffix2177); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal120_tree = (Object)adaptor.create(char_literal120);
            adaptor.addChild(root_0, char_literal120_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, (IDENTIFIER119!=null?IDENTIFIER119.getText():null), null)), getLine(tk));
              			retval.signature.getFunction().setType(Function.Type.CFunction);
              			retval.signature.getFunction().addModifiers((exportationModifiers117!=null?exportationModifiers117.modifiers:null));
              		
            }
            char_literal121=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffix2183); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal121_tree = (Object)adaptor.create(char_literal121);
            adaptor.addChild(root_0, char_literal121_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:809:7: (a1= argDef ( ',' ax= argDef )* )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==IDENTIFIER||LA58_0==30||(LA58_0>=44 && LA58_0<=47)||(LA58_0>=60 && LA58_0<=74)) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:810:4: a1= argDef ( ',' ax= argDef )*
                    {
                    pushFollow(FOLLOW_argDef_in_functionSignatureSuffix2192);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					((FunctionSignature)retval.signature).getFunction().addArg((a1!=null?a1.arg:null)); 
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:814:4: ( ',' ax= argDef )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==27) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:815:5: ',' ax= argDef
                    	    {
                    	    char_literal122=(Token)match(input,27,FOLLOW_27_in_functionSignatureSuffix2205); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal122_tree = (Object)adaptor.create(char_literal122);
                    	    adaptor.addChild(root_0, char_literal122_tree);
                    	    }
                    	    pushFollow(FOLLOW_argDef_in_functionSignatureSuffix2214);
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

            char_literal123=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffix2229); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal123_tree = (Object)adaptor.create(char_literal123);
            adaptor.addChild(root_0, char_literal123_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:823:1: functionSignatureSuffixNoName returns [FunctionSignature signature] : tk= '(' exportationModifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' ;
    public final ObjCppParser.functionSignatureSuffixNoName_return functionSignatureSuffixNoName() throws RecognitionException {
        ObjCppParser.functionSignatureSuffixNoName_return retval = new ObjCppParser.functionSignatureSuffixNoName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token tk=null;
        Token char_literal125=null;
        Token char_literal126=null;
        Token char_literal127=null;
        Token char_literal128=null;
        Token char_literal129=null;
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;

        ObjCppParser.exportationModifiers_return exportationModifiers124 = null;


        Object tk_tree=null;
        Object char_literal125_tree=null;
        Object char_literal126_tree=null;
        Object char_literal127_tree=null;
        Object char_literal128_tree=null;
        Object char_literal129_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:824:2: (tk= '(' exportationModifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:824:4: tk= '(' exportationModifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')'
            {
            root_0 = (Object)adaptor.nil();

            tk=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffixNoName2246); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tk_tree = (Object)adaptor.create(tk);
            adaptor.addChild(root_0, tk_tree);
            }
            pushFollow(FOLLOW_exportationModifiers_in_functionSignatureSuffixNoName2248);
            exportationModifiers124=exportationModifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exportationModifiers124.getTree());
            char_literal125=(Token)match(input,51,FOLLOW_51_in_functionSignatureSuffixNoName2250); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal125_tree = (Object)adaptor.create(char_literal125);
            adaptor.addChild(root_0, char_literal125_tree);
            }
            char_literal126=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffixNoName2252); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal126_tree = (Object)adaptor.create(char_literal126);
            adaptor.addChild(root_0, char_literal126_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, null, null)), getLine(tk));
              			retval.signature.getFunction().setType(Function.Type.CFunction);
              			retval.signature.getFunction().addModifiers((exportationModifiers124!=null?exportationModifiers124.modifiers:null));
              		
            }
            char_literal127=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffixNoName2258); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal127_tree = (Object)adaptor.create(char_literal127);
            adaptor.addChild(root_0, char_literal127_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:829:7: (a1= argDef ( ',' ax= argDef )* )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==IDENTIFIER||LA60_0==30||(LA60_0>=44 && LA60_0<=47)||(LA60_0>=60 && LA60_0<=74)) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:830:4: a1= argDef ( ',' ax= argDef )*
                    {
                    pushFollow(FOLLOW_argDef_in_functionSignatureSuffixNoName2267);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					((FunctionSignature)retval.signature).getFunction().addArg((a1!=null?a1.arg:null)); 
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:834:4: ( ',' ax= argDef )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==27) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:835:5: ',' ax= argDef
                    	    {
                    	    char_literal128=(Token)match(input,27,FOLLOW_27_in_functionSignatureSuffixNoName2280); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal128_tree = (Object)adaptor.create(char_literal128);
                    	    adaptor.addChild(root_0, char_literal128_tree);
                    	    }
                    	    pushFollow(FOLLOW_argDef_in_functionSignatureSuffixNoName2289);
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
                    	    break loop59;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal129=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffixNoName2304); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal129_tree = (Object)adaptor.create(char_literal129);
            adaptor.addChild(root_0, char_literal129_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:843:1: structOrEnum returns [TypeRef type] : ( structCore | enumCore );
    public final ObjCppParser.structOrEnum_return structOrEnum() throws RecognitionException {
        ObjCppParser.structOrEnum_return retval = new ObjCppParser.structOrEnum_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.structCore_return structCore130 = null;

        ObjCppParser.enumCore_return enumCore131 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:844:2: ( structCore | enumCore )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( ((LA61_0>=45 && LA61_0<=47)) ) {
                alt61=1;
            }
            else if ( (LA61_0==30) ) {
                alt61=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:845:3: structCore
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_structCore_in_structOrEnum2322);
                    structCore130=structCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structCore130.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (structCore130!=null?structCore130.struct:null); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:846:3: enumCore
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_enumCore_in_structOrEnum2330);
                    enumCore131=enumCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, enumCore131.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (enumCore131!=null?enumCore131.e:null); 
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:849:1: typeRefCoreOrFuncSig returns [TypeRef type] : typeRefCore ( ( typeMutator )* functionSignatureSuffix )? ;
    public final ObjCppParser.typeRefCoreOrFuncSig_return typeRefCoreOrFuncSig() throws RecognitionException {
        ObjCppParser.typeRefCoreOrFuncSig_return retval = new ObjCppParser.typeRefCoreOrFuncSig_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.typeRefCore_return typeRefCore132 = null;

        ObjCppParser.typeMutator_return typeMutator133 = null;

        ObjCppParser.functionSignatureSuffix_return functionSignatureSuffix134 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:850:2: ( typeRefCore ( ( typeMutator )* functionSignatureSuffix )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:850:4: typeRefCore ( ( typeMutator )* functionSignatureSuffix )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_typeRefCore_in_typeRefCoreOrFuncSig2348);
            typeRefCore132=typeRefCore();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRefCore132.getTree());
            if ( state.backtracking==0 ) {
               retval.type = (typeRefCore132!=null?typeRefCore132.type:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:851:3: ( ( typeMutator )* functionSignatureSuffix )?
            int alt63=2;
            alt63 = dfa63.predict(input);
            switch (alt63) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:852:4: ( typeMutator )* functionSignatureSuffix
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:852:4: ( typeMutator )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==IDENTIFIER||(LA62_0>=51 && LA62_0<=53)) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:853:5: typeMutator
                    	    {
                    	    pushFollow(FOLLOW_typeMutator_in_typeRefCoreOrFuncSig2365);
                    	    typeMutator133=typeMutator();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeMutator133.getTree());
                    	    if ( state.backtracking==0 ) {

                    	      					retval.type = (typeMutator133!=null?typeMutator133.mutator:null).mutateType(retval.type);
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop62;
                        }
                    } while (true);

                    pushFollow(FOLLOW_functionSignatureSuffix_in_typeRefCoreOrFuncSig2378);
                    functionSignatureSuffix134=functionSignatureSuffix();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionSignatureSuffix134.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				(functionSignatureSuffix134!=null?functionSignatureSuffix134.signature:null).getFunction().setValueType(retval.type); 
                      				retval.type = (functionSignatureSuffix134!=null?functionSignatureSuffix134.signature:null);
                      			
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:864:1: typeRefCoreOrAnonymousFuncSig returns [TypeRef type] : typeRefCore ( ( typeMutator )* functionSignatureSuffixNoName )? ;
    public final ObjCppParser.typeRefCoreOrAnonymousFuncSig_return typeRefCoreOrAnonymousFuncSig() throws RecognitionException {
        ObjCppParser.typeRefCoreOrAnonymousFuncSig_return retval = new ObjCppParser.typeRefCoreOrAnonymousFuncSig_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.typeRefCore_return typeRefCore135 = null;

        ObjCppParser.typeMutator_return typeMutator136 = null;

        ObjCppParser.functionSignatureSuffixNoName_return functionSignatureSuffixNoName137 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:865:2: ( typeRefCore ( ( typeMutator )* functionSignatureSuffixNoName )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:865:4: typeRefCore ( ( typeMutator )* functionSignatureSuffixNoName )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_typeRefCore_in_typeRefCoreOrAnonymousFuncSig2402);
            typeRefCore135=typeRefCore();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRefCore135.getTree());
            if ( state.backtracking==0 ) {
               retval.type = (typeRefCore135!=null?typeRefCore135.type:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:866:3: ( ( typeMutator )* functionSignatureSuffixNoName )?
            int alt65=2;
            alt65 = dfa65.predict(input);
            switch (alt65) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:867:4: ( typeMutator )* functionSignatureSuffixNoName
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:867:4: ( typeMutator )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==IDENTIFIER||(LA64_0>=51 && LA64_0<=53)) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:868:5: typeMutator
                    	    {
                    	    pushFollow(FOLLOW_typeMutator_in_typeRefCoreOrAnonymousFuncSig2419);
                    	    typeMutator136=typeMutator();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeMutator136.getTree());
                    	    if ( state.backtracking==0 ) {

                    	      					retval.type = (typeMutator136!=null?typeMutator136.mutator:null).mutateType(retval.type);
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop64;
                        }
                    } while (true);

                    pushFollow(FOLLOW_functionSignatureSuffixNoName_in_typeRefCoreOrAnonymousFuncSig2432);
                    functionSignatureSuffixNoName137=functionSignatureSuffixNoName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionSignatureSuffixNoName137.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				(functionSignatureSuffixNoName137!=null?functionSignatureSuffixNoName137.signature:null).getFunction().setValueType(retval.type); 
                      				retval.type = (functionSignatureSuffixNoName137!=null?functionSignatureSuffixNoName137.signature:null);
                      			
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:879:1: plainTypeRef returns [TypeRef type] : ( structOrEnum | typeRefCoreOrFuncSig );
    public final ObjCppParser.plainTypeRef_return plainTypeRef() throws RecognitionException {
        ObjCppParser.plainTypeRef_return retval = new ObjCppParser.plainTypeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.structOrEnum_return structOrEnum138 = null;

        ObjCppParser.typeRefCoreOrFuncSig_return typeRefCoreOrFuncSig139 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:880:2: ( structOrEnum | typeRefCoreOrFuncSig )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==30||(LA66_0>=45 && LA66_0<=47)) ) {
                alt66=1;
            }
            else if ( (LA66_0==IDENTIFIER||(LA66_0>=60 && LA66_0<=74)) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:881:3: structOrEnum
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_structOrEnum_in_plainTypeRef2459);
                    structOrEnum138=structOrEnum();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structOrEnum138.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (structOrEnum138!=null?structOrEnum138.type:null); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:882:3: typeRefCoreOrFuncSig
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_typeRefCoreOrFuncSig_in_plainTypeRef2467);
                    typeRefCoreOrFuncSig139=typeRefCoreOrFuncSig();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRefCoreOrFuncSig139.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (typeRefCoreOrFuncSig139!=null?typeRefCoreOrFuncSig139.type:null); 
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:885:1: declarator returns [Declarator declarator, List<Modifier> modifiers] : ({...}? modifier )* ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? ) ;
    public final ObjCppParser.declarator_return declarator() throws RecognitionException {
        ObjCppParser.declarator_return retval = new ObjCppParser.declarator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token pt=null;
        Token char_literal142=null;
        ObjCppParser.declarator_return inner = null;

        ObjCppParser.modifier_return modifier140 = null;

        ObjCppParser.directDeclarator_return directDeclarator141 = null;

        ObjCppParser.expression_return expression143 = null;


        Object pt_tree=null;
        Object char_literal142_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:886:2: ( ({...}? modifier )* ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:886:4: ({...}? modifier )* ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:887:3: ({...}? modifier )*
            loop67:
            do {
                int alt67=2;
                alt67 = dfa67.predict(input);
                switch (alt67) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:888:4: {...}? modifier
            	    {
            	    if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "declarator", " next(Modifier.Kind.TypeQualifier) ");
            	    }
            	    pushFollow(FOLLOW_modifier_in_declarator2496);
            	    modifier140=modifier();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, modifier140.getTree());
            	    if ( state.backtracking==0 ) {

            	      				retval.modifiers.add((modifier140!=null?modifier140.modifier:null));
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:895:3: ( ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:896:4: ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator ) ( '=' expression )?
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:896:4: ( (pt= ( '*' | '&' | '^' ) inner= declarator ) | directDeclarator )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( ((LA68_0>=51 && LA68_0<=52)||LA68_0==58) ) {
                alt68=1;
            }
            else if ( (LA68_0==IDENTIFIER||LA68_0==34) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:897:5: (pt= ( '*' | '&' | '^' ) inner= declarator )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:897:5: (pt= ( '*' | '&' | '^' ) inner= declarator )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:898:6: pt= ( '*' | '&' | '^' ) inner= declarator
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

                    pushFollow(FOLLOW_declarator_in_declarator2552);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:903:5: directDeclarator
                    {
                    pushFollow(FOLLOW_directDeclarator_in_declarator2568);
                    directDeclarator141=directDeclarator();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, directDeclarator141.getTree());
                    if ( state.backtracking==0 ) {
                       
                      					retval.declarator = (directDeclarator141!=null?directDeclarator141.declarator:null); 
                      				
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:907:4: ( '=' expression )?
            int alt69=2;
            alt69 = dfa69.predict(input);
            switch (alt69) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:908:5: '=' expression
                    {
                    char_literal142=(Token)match(input,29,FOLLOW_29_in_declarator2587); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal142_tree = (Object)adaptor.create(char_literal142);
                    adaptor.addChild(root_0, char_literal142_tree);
                    }
                    pushFollow(FOLLOW_expression_in_declarator2594);
                    expression143=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression143.getTree());
                    if ( state.backtracking==0 ) {

                      					retval.declarator.setDefaultValue((expression143!=null?expression143.expr:null));
                      				
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:921:1: namedTypeRef returns [TaggedTypeRef type] : ( structCore {...}? | enumCore {...}?);
    public final ObjCppParser.namedTypeRef_return namedTypeRef() throws RecognitionException {
        ObjCppParser.namedTypeRef_return retval = new ObjCppParser.namedTypeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.structCore_return structCore144 = null;

        ObjCppParser.enumCore_return enumCore145 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:922:2: ( structCore {...}? | enumCore {...}?)
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( ((LA70_0>=45 && LA70_0<=47)) ) {
                alt70=1;
            }
            else if ( (LA70_0==30) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:923:3: structCore {...}?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_structCore_in_namedTypeRef2628);
                    structCore144=structCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structCore144.getTree());
                    if ( !(( (structCore144!=null?structCore144.struct:null).getTag() != null )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "namedTypeRef", " $structCore.struct.getTag() != null ");
                    }
                    if ( state.backtracking==0 ) {

                      			retval.type = (structCore144!=null?structCore144.struct:null);
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:926:3: enumCore {...}?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_enumCore_in_namedTypeRef2638);
                    enumCore145=enumCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, enumCore145.getTree());
                    if ( !(( (enumCore145!=null?enumCore145.e:null).getTag() != null )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "namedTypeRef", " $enumCore.e.getTag() != null ");
                    }
                    if ( state.backtracking==0 ) {

                      			retval.type = (enumCore145!=null?enumCore145.e:null);
                      		
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:931:1: typeDef returns [TypeDef typeDef] : 'typedef' varDecl {...}?;
    public final ObjCppParser.typeDef_return typeDef() throws RecognitionException {
        ObjCppParser.typeDef_return retval = new ObjCppParser.typeDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal146=null;
        ObjCppParser.varDecl_return varDecl147 = null;


        Object string_literal146_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:932:2: ( 'typedef' varDecl {...}?)
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:932:4: 'typedef' varDecl {...}?
            {
            root_0 = (Object)adaptor.nil();

            string_literal146=(Token)match(input,59,FOLLOW_59_in_typeDef2657); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal146_tree = (Object)adaptor.create(string_literal146);
            adaptor.addChild(root_0, string_literal146_tree);
            }
            pushFollow(FOLLOW_varDecl_in_typeDef2663);
            varDecl147=varDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl147.getTree());
            if ( !(( 
            			((varDecl147!=null?varDecl147.decl:null) instanceof VariablesDeclaration) 
            		)) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "typeDef", " \n\t\t\t($varDecl.decl instanceof VariablesDeclaration) \n\t\t");
            }
            if ( state.backtracking==0 ) {

              			VariablesDeclaration vd = (VariablesDeclaration)(varDecl147!=null?varDecl147.decl:null);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:941:1: varDeclEOF returns [Declaration decl] : varDecl EOF ;
    public final ObjCppParser.varDeclEOF_return varDeclEOF() throws RecognitionException {
        ObjCppParser.varDeclEOF_return retval = new ObjCppParser.varDeclEOF_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF149=null;
        ObjCppParser.varDecl_return varDecl148 = null;


        Object EOF149_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:942:2: ( varDecl EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:942:4: varDecl EOF
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_varDecl_in_varDeclEOF2683);
            varDecl148=varDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl148.getTree());
            EOF149=(Token)match(input,EOF,FOLLOW_EOF_in_varDeclEOF2685); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EOF149_tree = (Object)adaptor.create(EOF149);
            adaptor.addChild(root_0, EOF149_tree);
            }
            if ( state.backtracking==0 ) {
               retval.decl = (varDecl148!=null?varDecl148.decl:null); 
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:945:1: varDecl returns [Declaration decl, TypeRef type] : ({...}?sm= modifier | {...}?tm= modifier )* ( ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList ) ) ';' ;
    public final ObjCppParser.varDecl_return varDecl() throws RecognitionException {
        ObjCppParser.varDecl_return retval = new ObjCppParser.varDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal151=null;
        ObjCppParser.modifier_return sm = null;

        ObjCppParser.modifier_return tm = null;

        ObjCppParser.declaratorsList_return d1 = null;

        ObjCppParser.typeRefCoreOrAnonymousFuncSig_return tcfs = null;

        ObjCppParser.declaratorsList_return d2 = null;

        ObjCppParser.structOrEnum_return structOrEnum150 = null;


        Object char_literal151_tree=null;


        	List<Modifier> stoMods = new ArrayList<Modifier>(), typMods = new ArrayList<Modifier>();

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:949:2: ( ({...}?sm= modifier | {...}?tm= modifier )* ( ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList ) ) ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:949:4: ({...}?sm= modifier | {...}?tm= modifier )* ( ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList ) ) ';'
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:949:4: ({...}?sm= modifier | {...}?tm= modifier )*
            loop71:
            do {
                int alt71=3;
                alt71 = dfa71.predict(input);
                switch (alt71) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:950:4: {...}?sm= modifier
            	    {
            	    if ( !(( next(Modifier.Kind.StorageClassSpecifier) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "varDecl", " next(Modifier.Kind.StorageClassSpecifier) ");
            	    }
            	    pushFollow(FOLLOW_modifier_in_varDecl2721);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:952:4: {...}?tm= modifier
            	    {
            	    if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "varDecl", " next(Modifier.Kind.TypeQualifier) ");
            	    }
            	    pushFollow(FOLLOW_modifier_in_varDecl2738);
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
            	    break loop71;
                }
            } while (true);

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:955:3: ( ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:959:4: ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList )
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:959:4: ( structOrEnum ( (d1= declaratorsList )? ) | tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==30||(LA73_0>=45 && LA73_0<=47)) ) {
                alt73=1;
            }
            else if ( (LA73_0==IDENTIFIER||(LA73_0>=60 && LA73_0<=74)) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:960:5: structOrEnum ( (d1= declaratorsList )? )
                    {
                    pushFollow(FOLLOW_structOrEnum_in_varDecl2765);
                    structOrEnum150=structOrEnum();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structOrEnum150.getTree());
                    if ( state.backtracking==0 ) {
                       
                      					retval.type = (structOrEnum150!=null?structOrEnum150.type:null);
                      					//retval.decl = new VariablesDeclaration(retval.type);
                      				
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:964:5: ( (d1= declaratorsList )? )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:965:6: (d1= declaratorsList )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:965:8: (d1= declaratorsList )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==IDENTIFIER||LA72_0==34||(LA72_0>=51 && LA72_0<=52)||LA72_0==58) ) {
                        alt72=1;
                    }
                    switch (alt72) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: d1= declaratorsList
                            {
                            pushFollow(FOLLOW_declaratorsList_in_varDecl2782);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:972:5: tcfs= typeRefCoreOrAnonymousFuncSig d2= declaratorsList
                    {
                    pushFollow(FOLLOW_typeRefCoreOrAnonymousFuncSig_in_varDecl2802);
                    tcfs=typeRefCoreOrAnonymousFuncSig();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tcfs.getTree());
                    if ( state.backtracking==0 ) {
                       retval.type = (tcfs!=null?tcfs.type:null); 
                    }
                    pushFollow(FOLLOW_declaratorsList_in_varDecl2812);
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

            char_literal151=(Token)match(input,28,FOLLOW_28_in_varDecl2849); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal151_tree = (Object)adaptor.create(char_literal151);
            adaptor.addChild(root_0, char_literal151_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1001:1: objCProtocolRefList : '<' IDENTIFIER ( ',' IDENTIFIER )* '>' ;
    public final ObjCppParser.objCProtocolRefList_return objCProtocolRefList() throws RecognitionException {
        ObjCppParser.objCProtocolRefList_return retval = new ObjCppParser.objCProtocolRefList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal152=null;
        Token IDENTIFIER153=null;
        Token char_literal154=null;
        Token IDENTIFIER155=null;
        Token char_literal156=null;

        Object char_literal152_tree=null;
        Object IDENTIFIER153_tree=null;
        Object char_literal154_tree=null;
        Object IDENTIFIER155_tree=null;
        Object char_literal156_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1002:2: ( '<' IDENTIFIER ( ',' IDENTIFIER )* '>' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1002:4: '<' IDENTIFIER ( ',' IDENTIFIER )* '>'
            {
            root_0 = (Object)adaptor.nil();

            char_literal152=(Token)match(input,36,FOLLOW_36_in_objCProtocolRefList2863); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal152_tree = (Object)adaptor.create(char_literal152);
            adaptor.addChild(root_0, char_literal152_tree);
            }
            IDENTIFIER153=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCProtocolRefList2868); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER153_tree = (Object)adaptor.create(IDENTIFIER153);
            adaptor.addChild(root_0, IDENTIFIER153_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1004:3: ( ',' IDENTIFIER )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==27) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1005:4: ',' IDENTIFIER
            	    {
            	    char_literal154=(Token)match(input,27,FOLLOW_27_in_objCProtocolRefList2878); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal154_tree = (Object)adaptor.create(char_literal154);
            	    adaptor.addChild(root_0, char_literal154_tree);
            	    }
            	    IDENTIFIER155=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCProtocolRefList2884); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDENTIFIER155_tree = (Object)adaptor.create(IDENTIFIER155);
            	    adaptor.addChild(root_0, IDENTIFIER155_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);

            char_literal156=(Token)match(input,37,FOLLOW_37_in_objCProtocolRefList2894); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal156_tree = (Object)adaptor.create(char_literal156);
            adaptor.addChild(root_0, char_literal156_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1018:1: declaratorsList returns [List<Declarator> declarators] : (d= declarator ( ',' x= declarator )* ) ;
    public final ObjCppParser.declaratorsList_return declaratorsList() throws RecognitionException {
        ObjCppParser.declaratorsList_return retval = new ObjCppParser.declaratorsList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal157=null;
        ObjCppParser.declarator_return d = null;

        ObjCppParser.declarator_return x = null;


        Object char_literal157_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1019:2: ( (d= declarator ( ',' x= declarator )* ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1019:4: (d= declarator ( ',' x= declarator )* )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.declarators = new ArrayList<Declarator>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1020:3: (d= declarator ( ',' x= declarator )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1021:4: d= declarator ( ',' x= declarator )*
            {
            pushFollow(FOLLOW_declarator_in_declaratorsList2921);
            d=declarator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());
            if ( state.backtracking==0 ) {
               retval.declarators.add((d!=null?d.declarator:null)); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1022:4: ( ',' x= declarator )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==27) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1023:5: ',' x= declarator
            	    {
            	    char_literal157=(Token)match(input,27,FOLLOW_27_in_declaratorsList2934); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal157_tree = (Object)adaptor.create(char_literal157);
            	    adaptor.addChild(root_0, char_literal157_tree);
            	    }
            	    pushFollow(FOLLOW_declarator_in_declaratorsList2943);
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
            	    break loop75;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1029:1: directDeclarator returns [Declarator declarator] : ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' ) ( '[' ( expression | ) ']' | argList )* ;
    public final ObjCppParser.directDeclarator_return directDeclarator() throws RecognitionException {
        ObjCppParser.directDeclarator_return retval = new ObjCppParser.directDeclarator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER158=null;
        Token char_literal159=null;
        Token char_literal160=null;
        Token char_literal161=null;
        Token char_literal163=null;
        ObjCppParser.modifier_return im = null;

        ObjCppParser.declarator_return inner = null;

        ObjCppParser.expression_return expression162 = null;

        ObjCppParser.argList_return argList164 = null;


        Object IDENTIFIER158_tree=null;
        Object char_literal159_tree=null;
        Object char_literal160_tree=null;
        Object char_literal161_tree=null;
        Object char_literal163_tree=null;


        	List<Modifier> modifiers = new ArrayList<Modifier>();

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1033:2: ( ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' ) ( '[' ( expression | ) ']' | argList )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1033:4: ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' ) ( '[' ( expression | ) ']' | argList )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1033:4: ( IDENTIFIER | '(' (im= modifier )* inner= declarator ')' )
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==IDENTIFIER) ) {
                alt77=1;
            }
            else if ( (LA77_0==34) ) {
                alt77=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }
            switch (alt77) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1035:4: IDENTIFIER
                    {
                    IDENTIFIER158=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_directDeclarator2986); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER158_tree = (Object)adaptor.create(IDENTIFIER158);
                    adaptor.addChild(root_0, IDENTIFIER158_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				retval.declarator = new DirectDeclarator((IDENTIFIER158!=null?IDENTIFIER158.getText():null));
                      			
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1038:4: '(' (im= modifier )* inner= declarator ')'
                    {
                    char_literal159=(Token)match(input,34,FOLLOW_34_in_directDeclarator2996); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal159_tree = (Object)adaptor.create(char_literal159);
                    adaptor.addChild(root_0, char_literal159_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1039:4: (im= modifier )*
                    loop76:
                    do {
                        int alt76=2;
                        alt76 = dfa76.predict(input);
                        switch (alt76) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1039:5: im= modifier
                    	    {
                    	    pushFollow(FOLLOW_modifier_in_directDeclarator3005);
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
                    	    break loop76;
                        }
                    } while (true);

                    pushFollow(FOLLOW_declarator_in_directDeclarator3016);
                    inner=declarator();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inner.getTree());
                    char_literal160=(Token)match(input,35,FOLLOW_35_in_directDeclarator3022); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal160_tree = (Object)adaptor.create(char_literal160);
                    adaptor.addChild(root_0, char_literal160_tree);
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1049:3: ( '[' ( expression | ) ']' | argList )*
            loop79:
            do {
                int alt79=3;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==53) ) {
                    alt79=1;
                }
                else if ( (LA79_0==34) ) {
                    alt79=2;
                }


                switch (alt79) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1050:4: '[' ( expression | ) ']'
            	    {
            	    char_literal161=(Token)match(input,53,FOLLOW_53_in_directDeclarator3037); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal161_tree = (Object)adaptor.create(char_literal161);
            	    adaptor.addChild(root_0, char_literal161_tree);
            	    }
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1051:4: ( expression | )
            	    int alt78=2;
            	    alt78 = dfa78.predict(input);
            	    switch (alt78) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1052:5: expression
            	            {
            	            pushFollow(FOLLOW_expression_in_directDeclarator3049);
            	            expression162=expression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression162.getTree());
            	            if ( state.backtracking==0 ) {

            	              					if (retval.declarator instanceof ArrayDeclarator)
            	              						((ArrayDeclarator)retval.declarator).addDimension((expression162!=null?expression162.expr:null));
            	              					else
            	              						retval.declarator = new ArrayDeclarator(retval.declarator, (expression162!=null?expression162.expr:null));
            	              				
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1057:9: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              					retval.declarator = new ArrayDeclarator(retval.declarator, new Expression.EmptyArraySize());
            	              				
            	            }

            	            }
            	            break;

            	    }

            	    char_literal163=(Token)match(input,54,FOLLOW_54_in_directDeclarator3065); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal163_tree = (Object)adaptor.create(char_literal163);
            	    adaptor.addChild(root_0, char_literal163_tree);
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1062:4: argList
            	    {
            	    pushFollow(FOLLOW_argList_in_directDeclarator3073);
            	    argList164=argList();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, argList164.getTree());
            	    if ( state.backtracking==0 ) {

            	      				retval.declarator = new FunctionDeclarator(retval.declarator, (argList164!=null?argList164.args:null));
            	      			
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
    // $ANTLR end "directDeclarator"

    public static class argList_return extends ParserRuleReturnScope {
        public List<Arg> args;
        public boolean isObjC;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argList"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1068:1: argList returns [List<Arg> args, boolean isObjC] : op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')' ;
    public final ObjCppParser.argList_return argList() throws RecognitionException {
        ObjCppParser.argList_return retval = new ObjCppParser.argList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        Token cp=null;
        Token char_literal165=null;
        Token char_literal166=null;
        Token string_literal167=null;
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        Object op_tree=null;
        Object cp_tree=null;
        Object char_literal165_tree=null;
        Object char_literal166_tree=null;
        Object string_literal167_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1069:2: (op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1069:4: op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               
              			retval.isObjC = false; 
              			retval.args = new ArrayList<Arg>();
              		
            }
            op=(Token)match(input,34,FOLLOW_34_in_argList3101); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            op_tree = (Object)adaptor.create(op);
            adaptor.addChild(root_0, op_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1074:3: (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==IDENTIFIER||LA82_0==30||(LA82_0>=44 && LA82_0<=47)||(LA82_0>=60 && LA82_0<=74)) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1075:4: a1= argDef ( ',' ax= argDef )* ( ',' '...' )?
                    {
                    pushFollow(FOLLOW_argDef_in_argList3113);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {

                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					retval.args.add((a1!=null?a1.arg:null));
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1079:4: ( ',' ax= argDef )*
                    loop80:
                    do {
                        int alt80=2;
                        alt80 = dfa80.predict(input);
                        switch (alt80) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1080:5: ',' ax= argDef
                    	    {
                    	    char_literal165=(Token)match(input,27,FOLLOW_27_in_argList3126); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal165_tree = (Object)adaptor.create(char_literal165);
                    	    adaptor.addChild(root_0, char_literal165_tree);
                    	    }
                    	    pushFollow(FOLLOW_argDef_in_argList3135);
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
                    	    break loop80;
                        }
                    } while (true);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1085:4: ( ',' '...' )?
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==27) ) {
                        alt81=1;
                    }
                    switch (alt81) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1086:5: ',' '...'
                            {
                            char_literal166=(Token)match(input,27,FOLLOW_27_in_argList3155); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal166_tree = (Object)adaptor.create(char_literal166);
                            adaptor.addChild(root_0, char_literal166_tree);
                            }
                            string_literal167=(Token)match(input,44,FOLLOW_44_in_argList3157); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal167_tree = (Object)adaptor.create(string_literal167);
                            adaptor.addChild(root_0, string_literal167_tree);
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

            cp=(Token)match(input,35,FOLLOW_35_in_argList3176); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1095:1: typeRef returns [TypeRef type] : plainTypeRef ( typeMutator )* ;
    public final ObjCppParser.typeRef_return typeRef() throws RecognitionException {
        ObjCppParser.typeRef_return retval = new ObjCppParser.typeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.plainTypeRef_return plainTypeRef168 = null;

        ObjCppParser.typeMutator_return typeMutator169 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1096:2: ( plainTypeRef ( typeMutator )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1097:3: plainTypeRef ( typeMutator )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_plainTypeRef_in_typeRef3194);
            plainTypeRef168=plainTypeRef();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, plainTypeRef168.getTree());
            if ( state.backtracking==0 ) {

              			retval.type = (plainTypeRef168!=null?plainTypeRef168.type:null);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1100:3: ( typeMutator )*
            loop83:
            do {
                int alt83=2;
                alt83 = dfa83.predict(input);
                switch (alt83) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1101:4: typeMutator
            	    {
            	    pushFollow(FOLLOW_typeMutator_in_typeRef3205);
            	    typeMutator169=typeMutator();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeMutator169.getTree());
            	    if ( state.backtracking==0 ) {

            	      				retval.type = (typeMutator169!=null?typeMutator169.mutator:null).mutateType(retval.type);
            	      			
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
    // $ANTLR end "typeRef"

    public static class primSignModifier_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primSignModifier"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1107:1: primSignModifier : ( 'signed' | 'unsigned' | '__signed' | '__unsigned' );
    public final ObjCppParser.primSignModifier_return primSignModifier() throws RecognitionException {
        ObjCppParser.primSignModifier_return retval = new ObjCppParser.primSignModifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set170=null;

        Object set170_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1108:2: ( 'signed' | 'unsigned' | '__signed' | '__unsigned' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:
            {
            root_0 = (Object)adaptor.nil();

            set170=(Token)input.LT(1);
            if ( (input.LA(1)>=60 && input.LA(1)<=63) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set170));
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1110:1: primSizeModifier : ( 'long' | 'short' );
    public final ObjCppParser.primSizeModifier_return primSizeModifier() throws RecognitionException {
        ObjCppParser.primSizeModifier_return retval = new ObjCppParser.primSizeModifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set171=null;

        Object set171_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1111:2: ( 'long' | 'short' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:
            {
            root_0 = (Object)adaptor.nil();

            set171=(Token)input.LT(1);
            if ( (input.LA(1)>=64 && input.LA(1)<=65) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set171));
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1113:1: primitiveTypeName : ( 'long' | 'int' | 'short' | 'double' | 'float' | 'char' | 'void' | '__int8' | '__int16' | '__int32' | '__int64' );
    public final ObjCppParser.primitiveTypeName_return primitiveTypeName() throws RecognitionException {
        ObjCppParser.primitiveTypeName_return retval = new ObjCppParser.primitiveTypeName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set172=null;

        Object set172_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1114:2: ( 'long' | 'int' | 'short' | 'double' | 'float' | 'char' | 'void' | '__int8' | '__int16' | '__int32' | '__int64' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:
            {
            root_0 = (Object)adaptor.nil();

            set172=(Token)input.LT(1);
            if ( (input.LA(1)>=64 && input.LA(1)<=74) ) {
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
    // $ANTLR end "primitiveTypeName"

    public static class primitiveTypeRef_return extends ParserRuleReturnScope {
        public TypeRef type;
        public int line;
        public List<Modifier> modifiers;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primitiveTypeRef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1126:1: primitiveTypeRef returns [TypeRef type, int line, List<Modifier> modifiers] : ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) ) ;
    public final ObjCppParser.primitiveTypeRef_return primitiveTypeRef() throws RecognitionException {
        ObjCppParser.primitiveTypeRef_return retval = new ObjCppParser.primitiveTypeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.primSignModifier_return mod1 = null;

        ObjCppParser.primSizeModifier_return mod2 = null;

        ObjCppParser.primSizeModifier_return mod3 = null;

        ObjCppParser.primitiveTypeName_return name = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1127:2: ( ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1127:4: ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               
              			retval.line = getLine(); 
              			retval.modifiers = new ArrayList<Modifier>();
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1131:3: ( (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1132:4: (mod1= primSignModifier )? (mod2= primSizeModifier (mod3= primSizeModifier )? )? (name= primitiveTypeName )
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1132:8: (mod1= primSignModifier )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( ((LA84_0>=60 && LA84_0<=63)) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: mod1= primSignModifier
                    {
                    pushFollow(FOLLOW_primSignModifier_in_primitiveTypeRef3344);
                    mod1=primSignModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mod1.getTree());

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1133:4: (mod2= primSizeModifier (mod3= primSizeModifier )? )?
            int alt86=2;
            alt86 = dfa86.predict(input);
            switch (alt86) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1133:5: mod2= primSizeModifier (mod3= primSizeModifier )?
                    {
                    pushFollow(FOLLOW_primSizeModifier_in_primitiveTypeRef3355);
                    mod2=primSizeModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, mod2.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1134:8: (mod3= primSizeModifier )?
                    int alt85=2;
                    alt85 = dfa85.predict(input);
                    switch (alt85) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: mod3= primSizeModifier
                            {
                            pushFollow(FOLLOW_primSizeModifier_in_primitiveTypeRef3362);
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1142:4: (name= primitiveTypeName )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1145:5: name= primitiveTypeName
            {
            pushFollow(FOLLOW_primitiveTypeName_in_primitiveTypeRef3405);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1174:1: objCMethodCall returns [FunctionCall expr] : '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']' ;
    public final ObjCppParser.objCMethodCall_return objCMethodCall() throws RecognitionException {
        ObjCppParser.objCMethodCall_return retval = new ObjCppParser.objCMethodCall_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token methodName=null;
        Token selx=null;
        Token char_literal173=null;
        Token char_literal174=null;
        Token char_literal175=null;
        Token char_literal176=null;
        ObjCppParser.expression_return target = null;

        ObjCppParser.expression_return arg1 = null;

        ObjCppParser.expression_return argx = null;


        Object methodName_tree=null;
        Object selx_tree=null;
        Object char_literal173_tree=null;
        Object char_literal174_tree=null;
        Object char_literal175_tree=null;
        Object char_literal176_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1175:2: ( '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1176:3: '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']'
            {
            root_0 = (Object)adaptor.nil();

            char_literal173=(Token)match(input,53,FOLLOW_53_in_objCMethodCall3444); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal173_tree = (Object)adaptor.create(char_literal173);
            adaptor.addChild(root_0, char_literal173_tree);
            }
            pushFollow(FOLLOW_expression_in_objCMethodCall3448);
            target=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, target.getTree());
            methodName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodCall3452); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            methodName_tree = (Object)adaptor.create(methodName);
            adaptor.addChild(root_0, methodName_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.expr = new FunctionCall((methodName!=null?methodName.getText():null));
              			retval.expr.setTarget((target!=null?target.expr:null));
              			retval.expr.setMemberRefStyle(MemberRefStyle.SquareBrackets);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1181:3: ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==33) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1182:4: ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )*
                    {
                    char_literal174=(Token)match(input,33,FOLLOW_33_in_objCMethodCall3463); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal174_tree = (Object)adaptor.create(char_literal174);
                    adaptor.addChild(root_0, char_literal174_tree);
                    }
                    pushFollow(FOLLOW_expression_in_objCMethodCall3467);
                    arg1=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arg1.getTree());
                    if ( state.backtracking==0 ) {

                      				retval.expr.addArgument(null, (arg1!=null?arg1.expr:null));
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1185:4: (selx= IDENTIFIER ':' argx= expression )*
                    loop87:
                    do {
                        int alt87=2;
                        int LA87_0 = input.LA(1);

                        if ( (LA87_0==IDENTIFIER) ) {
                            alt87=1;
                        }


                        switch (alt87) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1186:5: selx= IDENTIFIER ':' argx= expression
                    	    {
                    	    selx=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodCall3482); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    selx_tree = (Object)adaptor.create(selx);
                    	    adaptor.addChild(root_0, selx_tree);
                    	    }
                    	    char_literal175=(Token)match(input,33,FOLLOW_33_in_objCMethodCall3484); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal175_tree = (Object)adaptor.create(char_literal175);
                    	    adaptor.addChild(root_0, char_literal175_tree);
                    	    }
                    	    pushFollow(FOLLOW_expression_in_objCMethodCall3488);
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
                    	    break loop87;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal176=(Token)match(input,54,FOLLOW_54_in_objCMethodCall3505); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal176_tree = (Object)adaptor.create(char_literal176);
            adaptor.addChild(root_0, char_literal176_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1194:1: functionCall returns [FunctionCall expr] : ( 'sizeof' '(' typeRef ')' | IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')' );
    public final ObjCppParser.functionCall_return functionCall() throws RecognitionException {
        ObjCppParser.functionCall_return retval = new ObjCppParser.functionCall_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal177=null;
        Token char_literal178=null;
        Token char_literal180=null;
        Token IDENTIFIER181=null;
        Token char_literal182=null;
        Token char_literal183=null;
        Token char_literal184=null;
        ObjCppParser.expression_return a1 = null;

        ObjCppParser.expression_return ax = null;

        ObjCppParser.typeRef_return typeRef179 = null;


        Object string_literal177_tree=null;
        Object char_literal178_tree=null;
        Object char_literal180_tree=null;
        Object IDENTIFIER181_tree=null;
        Object char_literal182_tree=null;
        Object char_literal183_tree=null;
        Object char_literal184_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1195:2: ( 'sizeof' '(' typeRef ')' | IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')' )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==75) ) {
                alt91=1;
            }
            else if ( (LA91_0==IDENTIFIER) ) {
                alt91=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1196:3: 'sizeof' '(' typeRef ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal177=(Token)match(input,75,FOLLOW_75_in_functionCall3525); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal177_tree = (Object)adaptor.create(string_literal177);
                    adaptor.addChild(root_0, string_literal177_tree);
                    }
                    char_literal178=(Token)match(input,34,FOLLOW_34_in_functionCall3527); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal178_tree = (Object)adaptor.create(char_literal178);
                    adaptor.addChild(root_0, char_literal178_tree);
                    }
                    pushFollow(FOLLOW_typeRef_in_functionCall3529);
                    typeRef179=typeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRef179.getTree());
                    char_literal180=(Token)match(input,35,FOLLOW_35_in_functionCall3531); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal180_tree = (Object)adaptor.create(char_literal180);
                    adaptor.addChild(root_0, char_literal180_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			retval.expr = new FunctionCall("sizeof");
                      			retval.expr.addArgument(new TypeRefExpression((typeRef179!=null?typeRef179.type:null)));
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1200:3: IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    IDENTIFIER181=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionCall3539); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER181_tree = (Object)adaptor.create(IDENTIFIER181);
                    adaptor.addChild(root_0, IDENTIFIER181_tree);
                    }
                    char_literal182=(Token)match(input,34,FOLLOW_34_in_functionCall3541); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal182_tree = (Object)adaptor.create(char_literal182);
                    adaptor.addChild(root_0, char_literal182_tree);
                    }
                    if ( state.backtracking==0 ) {

                      			retval.expr = new FunctionCall((IDENTIFIER181!=null?IDENTIFIER181.getText():null));
                      		
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1203:3: (a1= expression ( ',' ax= expression )* )?
                    int alt90=2;
                    alt90 = dfa90.predict(input);
                    switch (alt90) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1204:4: a1= expression ( ',' ax= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_functionCall3554);
                            a1=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                            if ( state.backtracking==0 ) {

                              				retval.expr.addArgument((a1!=null?a1.expr:null));
                              			
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1207:4: ( ',' ax= expression )*
                            loop89:
                            do {
                                int alt89=2;
                                int LA89_0 = input.LA(1);

                                if ( (LA89_0==27) ) {
                                    alt89=1;
                                }


                                switch (alt89) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1207:6: ',' ax= expression
                            	    {
                            	    char_literal183=(Token)match(input,27,FOLLOW_27_in_functionCall3563); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    char_literal183_tree = (Object)adaptor.create(char_literal183);
                            	    adaptor.addChild(root_0, char_literal183_tree);
                            	    }
                            	    pushFollow(FOLLOW_expression_in_functionCall3572);
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
                            	    break loop89;
                                }
                            } while (true);


                            }
                            break;

                    }

                    char_literal184=(Token)match(input,35,FOLLOW_35_in_functionCall3590); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal184_tree = (Object)adaptor.create(char_literal184);
                    adaptor.addChild(root_0, char_literal184_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1216:1: binaryOp : ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' );
    public final ObjCppParser.binaryOp_return binaryOp() throws RecognitionException {
        ObjCppParser.binaryOp_return retval = new ObjCppParser.binaryOp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set185=null;

        Object set185_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1216:10: ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:
            {
            root_0 = (Object)adaptor.nil();

            set185=(Token)input.LT(1);
            if ( (input.LA(1)>=36 && input.LA(1)<=37)||(input.LA(1)>=42 && input.LA(1)<=43)||(input.LA(1)>=51 && input.LA(1)<=52)||input.LA(1)==58||(input.LA(1)>=76 && input.LA(1)<=87) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set185));
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1220:1: expression returns [Expression expr] : (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' ) (bop= binaryOp opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )* ;
    public final ObjCppParser.expression_return expression() throws RecognitionException {
        ObjCppParser.expression_return retval = new ObjCppParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token id=null;
        Token prefixOp=null;
        Token fieldName=null;
        Token refStyle=null;
        Token char_literal187=null;
        Token char_literal188=null;
        Token char_literal190=null;
        Token char_literal192=null;
        Token char_literal194=null;
        Token char_literal195=null;
        Token char_literal196=null;
        Token char_literal197=null;
        Token char_literal198=null;
        Token char_literal199=null;
        Token char_literal200=null;
        Token char_literal201=null;
        Token char_literal202=null;
        Token char_literal203=null;
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

        ObjCppParser.objCMethodCall_return objCMethodCall186 = null;

        ObjCppParser.typeRef_return typeRef189 = null;

        ObjCppParser.constant_return constant191 = null;

        ObjCppParser.expression_return expression193 = null;


        Object id_tree=null;
        Object prefixOp_tree=null;
        Object fieldName_tree=null;
        Object refStyle_tree=null;
        Object char_literal187_tree=null;
        Object char_literal188_tree=null;
        Object char_literal190_tree=null;
        Object char_literal192_tree=null;
        Object char_literal194_tree=null;
        Object char_literal195_tree=null;
        Object char_literal196_tree=null;
        Object char_literal197_tree=null;
        Object char_literal198_tree=null;
        Object char_literal199_tree=null;
        Object char_literal200_tree=null;
        Object char_literal201_tree=null;
        Object char_literal202_tree=null;
        Object char_literal203_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1221:2: ( (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' ) (bop= binaryOp opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1221:4: (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' ) (bop= binaryOp opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1221:4: (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' )
            int alt93=7;
            alt93 = dfa93.predict(input);
            switch (alt93) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1222:4: id= IDENTIFIER
                    {
                    id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression3696); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1225:4: fc1= functionCall
                    {
                    pushFollow(FOLLOW_functionCall_in_expression3707);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1228:4: objCMethodCall
                    {
                    pushFollow(FOLLOW_objCMethodCall_in_expression3716);
                    objCMethodCall186=objCMethodCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, objCMethodCall186.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				retval.expr = (objCMethodCall186!=null?objCMethodCall186.expr:null); 
                      							
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1231:4: prefixOp= ( '!' | '~' ) opd= expression
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

                    pushFollow(FOLLOW_expression_in_expression3737);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1234:4: '(' (par= expression ')' | typeRef ')' casted= expression )
                    {
                    char_literal187=(Token)match(input,34,FOLLOW_34_in_expression3746); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal187_tree = (Object)adaptor.create(char_literal187);
                    adaptor.addChild(root_0, char_literal187_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1234:8: (par= expression ')' | typeRef ')' casted= expression )
                    int alt92=2;
                    alt92 = dfa92.predict(input);
                    switch (alt92) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1235:5: par= expression ')'
                            {
                            pushFollow(FOLLOW_expression_in_expression3756);
                            par=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, par.getTree());
                            char_literal188=(Token)match(input,35,FOLLOW_35_in_expression3758); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal188_tree = (Object)adaptor.create(char_literal188);
                            adaptor.addChild(root_0, char_literal188_tree);
                            }
                            if ( state.backtracking==0 ) {

                              					retval.expr = (par!=null?par.expr:null);
                              					if (retval.expr != null)
                              						retval.expr.setParenthesis(true);
                              				
                            }

                            }
                            break;
                        case 2 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1240:5: typeRef ')' casted= expression
                            {
                            pushFollow(FOLLOW_typeRef_in_expression3768);
                            typeRef189=typeRef();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRef189.getTree());
                            char_literal190=(Token)match(input,35,FOLLOW_35_in_expression3770); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal190_tree = (Object)adaptor.create(char_literal190);
                            adaptor.addChild(root_0, char_literal190_tree);
                            }
                            pushFollow(FOLLOW_expression_in_expression3774);
                            casted=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, casted.getTree());
                            if ( state.backtracking==0 ) {

                              					retval.expr = new Cast((typeRef189!=null?typeRef189.type:null), (casted!=null?casted.expr:null));
                              				
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1244:4: constant
                    {
                    pushFollow(FOLLOW_constant_in_expression3789);
                    constant191=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant191.getTree());
                    if ( state.backtracking==0 ) {
                       retval.expr = (constant191!=null?constant191.constant:null); 
                    }

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1245:4: '{' expression '}'
                    {
                    char_literal192=(Token)match(input,23,FOLLOW_23_in_expression3798); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal192_tree = (Object)adaptor.create(char_literal192);
                    adaptor.addChild(root_0, char_literal192_tree);
                    }
                    pushFollow(FOLLOW_expression_in_expression3800);
                    expression193=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression193.getTree());
                    char_literal194=(Token)match(input,24,FOLLOW_24_in_expression3802); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal194_tree = (Object)adaptor.create(char_literal194);
                    adaptor.addChild(root_0, char_literal194_tree);
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1247:3: (bop= binaryOp opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )*
            loop95:
            do {
                int alt95=6;
                alt95 = dfa95.predict(input);
                switch (alt95) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1248:4: bop= binaryOp opd2= expression
            	    {
            	    pushFollow(FOLLOW_binaryOp_in_expression3818);
            	    bop=binaryOp();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, bop.getTree());
            	    pushFollow(FOLLOW_expression_in_expression3825);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1252:4: '=' val= expression
            	    {
            	    char_literal195=(Token)match(input,29,FOLLOW_29_in_expression3834); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal195_tree = (Object)adaptor.create(char_literal195);
            	    adaptor.addChild(root_0, char_literal195_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression3838);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1255:4: '.' fieldName= IDENTIFIER
            	    {
            	    char_literal196=(Token)match(input,90,FOLLOW_90_in_expression3847); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal196_tree = (Object)adaptor.create(char_literal196);
            	    adaptor.addChild(root_0, char_literal196_tree);
            	    }
            	    fieldName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_expression3851); if (state.failed) return retval;
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1258:4: refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1258:13: ( ':' ':' | '-' '>' | '.' )
            	    int alt94=3;
            	    switch ( input.LA(1) ) {
            	    case 33:
            	        {
            	        alt94=1;
            	        }
            	        break;
            	    case 43:
            	        {
            	        alt94=2;
            	        }
            	        break;
            	    case 90:
            	        {
            	        alt94=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 94, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt94) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1258:14: ':' ':'
            	            {
            	            char_literal197=(Token)match(input,33,FOLLOW_33_in_expression3863); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal197_tree = (Object)adaptor.create(char_literal197);
            	            adaptor.addChild(root_0, char_literal197_tree);
            	            }
            	            char_literal198=(Token)match(input,33,FOLLOW_33_in_expression3865); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal198_tree = (Object)adaptor.create(char_literal198);
            	            adaptor.addChild(root_0, char_literal198_tree);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1258:24: '-' '>'
            	            {
            	            char_literal199=(Token)match(input,43,FOLLOW_43_in_expression3869); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal199_tree = (Object)adaptor.create(char_literal199);
            	            adaptor.addChild(root_0, char_literal199_tree);
            	            }
            	            char_literal200=(Token)match(input,37,FOLLOW_37_in_expression3871); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal200_tree = (Object)adaptor.create(char_literal200);
            	            adaptor.addChild(root_0, char_literal200_tree);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1258:34: '.'
            	            {
            	            char_literal201=(Token)match(input,90,FOLLOW_90_in_expression3875); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal201_tree = (Object)adaptor.create(char_literal201);
            	            adaptor.addChild(root_0, char_literal201_tree);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_functionCall_in_expression3880);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1265:7: '?' xif= expression ':' xelse= expression
            	    {
            	    char_literal202=(Token)match(input,91,FOLLOW_91_in_expression3892); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal202_tree = (Object)adaptor.create(char_literal202);
            	    adaptor.addChild(root_0, char_literal202_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression3896);
            	    xif=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, xif.getTree());
            	    char_literal203=(Token)match(input,33,FOLLOW_33_in_expression3898); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal203_tree = (Object)adaptor.create(char_literal203);
            	    adaptor.addChild(root_0, char_literal203_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_expression3902);
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
    // $ANTLR end "expression"

    public static class statementsBlock_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statementsBlock"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1272:1: statementsBlock : '{' ( statement )* '}' ;
    public final ObjCppParser.statementsBlock_return statementsBlock() throws RecognitionException {
        ObjCppParser.statementsBlock_return retval = new ObjCppParser.statementsBlock_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal204=null;
        Token char_literal206=null;
        ObjCppParser.statement_return statement205 = null;


        Object char_literal204_tree=null;
        Object char_literal206_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1273:2: ( '{' ( statement )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1273:4: '{' ( statement )* '}'
            {
            root_0 = (Object)adaptor.nil();

            char_literal204=(Token)match(input,23,FOLLOW_23_in_statementsBlock3925); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal204_tree = (Object)adaptor.create(char_literal204);
            adaptor.addChild(root_0, char_literal204_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1273:8: ( statement )*
            loop96:
            do {
                int alt96=2;
                alt96 = dfa96.predict(input);
                switch (alt96) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_statementsBlock3927);
            	    statement205=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement205.getTree());

            	    }
            	    break;

            	default :
            	    break loop96;
                }
            } while (true);

            char_literal206=(Token)match(input,24,FOLLOW_24_in_statementsBlock3930); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal206_tree = (Object)adaptor.create(char_literal206);
            adaptor.addChild(root_0, char_literal206_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1275:1: statement : ( statementsBlock | declaration | expression ( '=' expression )? ';' | 'return' expression ';' | 'if' '(' expression ')' statement ( 'else' statement )? | 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement );
    public final ObjCppParser.statement_return statement() throws RecognitionException {
        ObjCppParser.statement_return retval = new ObjCppParser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal210=null;
        Token char_literal212=null;
        Token string_literal213=null;
        Token char_literal215=null;
        Token string_literal216=null;
        Token char_literal217=null;
        Token char_literal219=null;
        Token string_literal221=null;
        Token string_literal223=null;
        Token char_literal224=null;
        Token char_literal226=null;
        Token string_literal228=null;
        Token string_literal230=null;
        Token char_literal231=null;
        Token char_literal233=null;
        Token char_literal234=null;
        Token string_literal235=null;
        Token char_literal236=null;
        Token char_literal238=null;
        Token char_literal240=null;
        Token char_literal242=null;
        Token string_literal244=null;
        Token char_literal245=null;
        Token char_literal247=null;
        Token char_literal248=null;
        Token string_literal249=null;
        Token char_literal251=null;
        Token char_literal253=null;
        Token char_literal254=null;
        Token IDENTIFIER255=null;
        Token char_literal256=null;
        Token char_literal258=null;
        Token char_literal260=null;
        ObjCppParser.statementsBlock_return statementsBlock207 = null;

        ObjCppParser.declaration_return declaration208 = null;

        ObjCppParser.expression_return expression209 = null;

        ObjCppParser.expression_return expression211 = null;

        ObjCppParser.expression_return expression214 = null;

        ObjCppParser.expression_return expression218 = null;

        ObjCppParser.statement_return statement220 = null;

        ObjCppParser.statement_return statement222 = null;

        ObjCppParser.expression_return expression225 = null;

        ObjCppParser.statement_return statement227 = null;

        ObjCppParser.statement_return statement229 = null;

        ObjCppParser.expression_return expression232 = null;

        ObjCppParser.statement_return statement237 = null;

        ObjCppParser.expression_return expression239 = null;

        ObjCppParser.statement_return statement241 = null;

        ObjCppParser.statement_return statement243 = null;

        ObjCppParser.expression_return expression246 = null;

        ObjCppParser.expression_return expression250 = null;

        ObjCppParser.statement_return statement252 = null;

        ObjCppParser.varDecl_return varDecl257 = null;

        ObjCppParser.expression_return expression259 = null;

        ObjCppParser.statement_return statement261 = null;


        Object char_literal210_tree=null;
        Object char_literal212_tree=null;
        Object string_literal213_tree=null;
        Object char_literal215_tree=null;
        Object string_literal216_tree=null;
        Object char_literal217_tree=null;
        Object char_literal219_tree=null;
        Object string_literal221_tree=null;
        Object string_literal223_tree=null;
        Object char_literal224_tree=null;
        Object char_literal226_tree=null;
        Object string_literal228_tree=null;
        Object string_literal230_tree=null;
        Object char_literal231_tree=null;
        Object char_literal233_tree=null;
        Object char_literal234_tree=null;
        Object string_literal235_tree=null;
        Object char_literal236_tree=null;
        Object char_literal238_tree=null;
        Object char_literal240_tree=null;
        Object char_literal242_tree=null;
        Object string_literal244_tree=null;
        Object char_literal245_tree=null;
        Object char_literal247_tree=null;
        Object char_literal248_tree=null;
        Object string_literal249_tree=null;
        Object char_literal251_tree=null;
        Object char_literal253_tree=null;
        Object char_literal254_tree=null;
        Object IDENTIFIER255_tree=null;
        Object char_literal256_tree=null;
        Object char_literal258_tree=null;
        Object char_literal260_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1276:2: ( statementsBlock | declaration | expression ( '=' expression )? ';' | 'return' expression ';' | 'if' '(' expression ')' statement ( 'else' statement )? | 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement )
            int alt103=11;
            alt103 = dfa103.predict(input);
            switch (alt103) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1277:3: statementsBlock
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_statementsBlock_in_statement3943);
                    statementsBlock207=statementsBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statementsBlock207.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1278:3: declaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_declaration_in_statement3949);
                    declaration208=declaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration208.getTree());

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1279:3: expression ( '=' expression )? ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_expression_in_statement3955);
                    expression209=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression209.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1279:14: ( '=' expression )?
                    int alt97=2;
                    int LA97_0 = input.LA(1);

                    if ( (LA97_0==29) ) {
                        alt97=1;
                    }
                    switch (alt97) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1279:15: '=' expression
                            {
                            char_literal210=(Token)match(input,29,FOLLOW_29_in_statement3958); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal210_tree = (Object)adaptor.create(char_literal210);
                            adaptor.addChild(root_0, char_literal210_tree);
                            }
                            pushFollow(FOLLOW_expression_in_statement3960);
                            expression211=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression211.getTree());

                            }
                            break;

                    }

                    char_literal212=(Token)match(input,28,FOLLOW_28_in_statement3965); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal212_tree = (Object)adaptor.create(char_literal212);
                    adaptor.addChild(root_0, char_literal212_tree);
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1280:3: 'return' expression ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal213=(Token)match(input,55,FOLLOW_55_in_statement3971); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal213_tree = (Object)adaptor.create(string_literal213);
                    adaptor.addChild(root_0, string_literal213_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3973);
                    expression214=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression214.getTree());
                    char_literal215=(Token)match(input,28,FOLLOW_28_in_statement3975); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal215_tree = (Object)adaptor.create(char_literal215);
                    adaptor.addChild(root_0, char_literal215_tree);
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1281:3: 'if' '(' expression ')' statement ( 'else' statement )?
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal216=(Token)match(input,92,FOLLOW_92_in_statement3981); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal216_tree = (Object)adaptor.create(string_literal216);
                    adaptor.addChild(root_0, string_literal216_tree);
                    }
                    char_literal217=(Token)match(input,34,FOLLOW_34_in_statement3983); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal217_tree = (Object)adaptor.create(char_literal217);
                    adaptor.addChild(root_0, char_literal217_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement3985);
                    expression218=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression218.getTree());
                    char_literal219=(Token)match(input,35,FOLLOW_35_in_statement3987); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal219_tree = (Object)adaptor.create(char_literal219);
                    adaptor.addChild(root_0, char_literal219_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement3989);
                    statement220=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement220.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1281:37: ( 'else' statement )?
                    int alt98=2;
                    alt98 = dfa98.predict(input);
                    switch (alt98) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1281:38: 'else' statement
                            {
                            string_literal221=(Token)match(input,93,FOLLOW_93_in_statement3992); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal221_tree = (Object)adaptor.create(string_literal221);
                            adaptor.addChild(root_0, string_literal221_tree);
                            }
                            pushFollow(FOLLOW_statement_in_statement3994);
                            statement222=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement222.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1282:3: 'while' '(' expression ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal223=(Token)match(input,94,FOLLOW_94_in_statement4002); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal223_tree = (Object)adaptor.create(string_literal223);
                    adaptor.addChild(root_0, string_literal223_tree);
                    }
                    char_literal224=(Token)match(input,34,FOLLOW_34_in_statement4004); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal224_tree = (Object)adaptor.create(char_literal224);
                    adaptor.addChild(root_0, char_literal224_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement4006);
                    expression225=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression225.getTree());
                    char_literal226=(Token)match(input,35,FOLLOW_35_in_statement4008); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal226_tree = (Object)adaptor.create(char_literal226);
                    adaptor.addChild(root_0, char_literal226_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement4010);
                    statement227=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement227.getTree());

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1283:3: 'do' statement 'while' '(' expression ')' ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal228=(Token)match(input,95,FOLLOW_95_in_statement4016); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal228_tree = (Object)adaptor.create(string_literal228);
                    adaptor.addChild(root_0, string_literal228_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement4018);
                    statement229=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement229.getTree());
                    string_literal230=(Token)match(input,94,FOLLOW_94_in_statement4020); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal230_tree = (Object)adaptor.create(string_literal230);
                    adaptor.addChild(root_0, string_literal230_tree);
                    }
                    char_literal231=(Token)match(input,34,FOLLOW_34_in_statement4022); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal231_tree = (Object)adaptor.create(char_literal231);
                    adaptor.addChild(root_0, char_literal231_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement4024);
                    expression232=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression232.getTree());
                    char_literal233=(Token)match(input,35,FOLLOW_35_in_statement4026); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal233_tree = (Object)adaptor.create(char_literal233);
                    adaptor.addChild(root_0, char_literal233_tree);
                    }
                    char_literal234=(Token)match(input,28,FOLLOW_28_in_statement4028); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal234_tree = (Object)adaptor.create(char_literal234);
                    adaptor.addChild(root_0, char_literal234_tree);
                    }

                    }
                    break;
                case 8 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1284:3: 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal235=(Token)match(input,96,FOLLOW_96_in_statement4034); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal235_tree = (Object)adaptor.create(string_literal235);
                    adaptor.addChild(root_0, string_literal235_tree);
                    }
                    char_literal236=(Token)match(input,34,FOLLOW_34_in_statement4036); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal236_tree = (Object)adaptor.create(char_literal236);
                    adaptor.addChild(root_0, char_literal236_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1284:13: ( statement )?
                    int alt99=2;
                    alt99 = dfa99.predict(input);
                    switch (alt99) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: statement
                            {
                            pushFollow(FOLLOW_statement_in_statement4038);
                            statement237=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement237.getTree());

                            }
                            break;

                    }

                    char_literal238=(Token)match(input,28,FOLLOW_28_in_statement4041); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal238_tree = (Object)adaptor.create(char_literal238);
                    adaptor.addChild(root_0, char_literal238_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1284:28: ( expression )?
                    int alt100=2;
                    alt100 = dfa100.predict(input);
                    switch (alt100) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement4043);
                            expression239=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression239.getTree());

                            }
                            break;

                    }

                    char_literal240=(Token)match(input,28,FOLLOW_28_in_statement4046); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal240_tree = (Object)adaptor.create(char_literal240);
                    adaptor.addChild(root_0, char_literal240_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1284:44: ( statement )?
                    int alt101=2;
                    alt101 = dfa101.predict(input);
                    switch (alt101) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: statement
                            {
                            pushFollow(FOLLOW_statement_in_statement4048);
                            statement241=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement241.getTree());

                            }
                            break;

                    }

                    char_literal242=(Token)match(input,35,FOLLOW_35_in_statement4051); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal242_tree = (Object)adaptor.create(char_literal242);
                    adaptor.addChild(root_0, char_literal242_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement4053);
                    statement243=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement243.getTree());

                    }
                    break;
                case 9 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1285:3: 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal244=(Token)match(input,97,FOLLOW_97_in_statement4059); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal244_tree = (Object)adaptor.create(string_literal244);
                    adaptor.addChild(root_0, string_literal244_tree);
                    }
                    char_literal245=(Token)match(input,34,FOLLOW_34_in_statement4061); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal245_tree = (Object)adaptor.create(char_literal245);
                    adaptor.addChild(root_0, char_literal245_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement4063);
                    expression246=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression246.getTree());
                    char_literal247=(Token)match(input,35,FOLLOW_35_in_statement4065); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal247_tree = (Object)adaptor.create(char_literal247);
                    adaptor.addChild(root_0, char_literal247_tree);
                    }
                    char_literal248=(Token)match(input,23,FOLLOW_23_in_statement4067); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal248_tree = (Object)adaptor.create(char_literal248);
                    adaptor.addChild(root_0, char_literal248_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1286:3: ( 'case' expression ':' | statement )*
                    loop102:
                    do {
                        int alt102=3;
                        alt102 = dfa102.predict(input);
                        switch (alt102) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1286:5: 'case' expression ':'
                    	    {
                    	    string_literal249=(Token)match(input,98,FOLLOW_98_in_statement4073); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    string_literal249_tree = (Object)adaptor.create(string_literal249);
                    	    adaptor.addChild(root_0, string_literal249_tree);
                    	    }
                    	    pushFollow(FOLLOW_expression_in_statement4075);
                    	    expression250=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression250.getTree());
                    	    char_literal251=(Token)match(input,33,FOLLOW_33_in_statement4077); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal251_tree = (Object)adaptor.create(char_literal251);
                    	    adaptor.addChild(root_0, char_literal251_tree);
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1287:4: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement4084);
                    	    statement252=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement252.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop102;
                        }
                    } while (true);

                    char_literal253=(Token)match(input,24,FOLLOW_24_in_statement4093); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal253_tree = (Object)adaptor.create(char_literal253);
                    adaptor.addChild(root_0, char_literal253_tree);
                    }

                    }
                    break;
                case 10 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1290:3: ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal254=(Token)match(input,28,FOLLOW_28_in_statement4099); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal254_tree = (Object)adaptor.create(char_literal254);
                    adaptor.addChild(root_0, char_literal254_tree);
                    }

                    }
                    break;
                case 11 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1291:3: {...}? IDENTIFIER '(' varDecl ':' expression ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !(( next("foreach") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "statement", " next(\"foreach\") ");
                    }
                    IDENTIFIER255=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement4107); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER255_tree = (Object)adaptor.create(IDENTIFIER255);
                    adaptor.addChild(root_0, IDENTIFIER255_tree);
                    }
                    char_literal256=(Token)match(input,34,FOLLOW_34_in_statement4109); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal256_tree = (Object)adaptor.create(char_literal256);
                    adaptor.addChild(root_0, char_literal256_tree);
                    }
                    pushFollow(FOLLOW_varDecl_in_statement4111);
                    varDecl257=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl257.getTree());
                    char_literal258=(Token)match(input,33,FOLLOW_33_in_statement4113); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal258_tree = (Object)adaptor.create(char_literal258);
                    adaptor.addChild(root_0, char_literal258_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement4115);
                    expression259=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression259.getTree());
                    char_literal260=(Token)match(input,35,FOLLOW_35_in_statement4117); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal260_tree = (Object)adaptor.create(char_literal260);
                    adaptor.addChild(root_0, char_literal260_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement4119);
                    statement261=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement261.getTree());

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1294:1: constant returns [Constant constant] : ( DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER | CHARACTER | FLOAT_NUMBER | STRING );
    public final ObjCppParser.constant_return constant() throws RecognitionException {
        ObjCppParser.constant_return retval = new ObjCppParser.constant_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DECIMAL_NUMBER262=null;
        Token HEXADECIMAL_NUMBER263=null;
        Token OCTAL_NUMBER264=null;
        Token CHARACTER265=null;
        Token FLOAT_NUMBER266=null;
        Token STRING267=null;

        Object DECIMAL_NUMBER262_tree=null;
        Object HEXADECIMAL_NUMBER263_tree=null;
        Object OCTAL_NUMBER264_tree=null;
        Object CHARACTER265_tree=null;
        Object FLOAT_NUMBER266_tree=null;
        Object STRING267_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1295:2: ( DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER | CHARACTER | FLOAT_NUMBER | STRING )
            int alt104=6;
            switch ( input.LA(1) ) {
            case DECIMAL_NUMBER:
                {
                alt104=1;
                }
                break;
            case HEXADECIMAL_NUMBER:
                {
                alt104=2;
                }
                break;
            case OCTAL_NUMBER:
                {
                alt104=3;
                }
                break;
            case CHARACTER:
                {
                alt104=4;
                }
                break;
            case FLOAT_NUMBER:
                {
                alt104=5;
                }
                break;
            case STRING:
                {
                alt104=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }

            switch (alt104) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1295:4: DECIMAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    DECIMAL_NUMBER262=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_constant4135); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DECIMAL_NUMBER262_tree = (Object)adaptor.create(DECIMAL_NUMBER262);
                    adaptor.addChild(root_0, DECIMAL_NUMBER262_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant =  Constant.parseDecimal((DECIMAL_NUMBER262!=null?DECIMAL_NUMBER262.getText():null)); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1296:3: HEXADECIMAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    HEXADECIMAL_NUMBER263=(Token)match(input,HEXADECIMAL_NUMBER,FOLLOW_HEXADECIMAL_NUMBER_in_constant4143); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    HEXADECIMAL_NUMBER263_tree = (Object)adaptor.create(HEXADECIMAL_NUMBER263);
                    adaptor.addChild(root_0, HEXADECIMAL_NUMBER263_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant = Constant.parseHex((HEXADECIMAL_NUMBER263!=null?HEXADECIMAL_NUMBER263.getText():null)); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1297:3: OCTAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    OCTAL_NUMBER264=(Token)match(input,OCTAL_NUMBER,FOLLOW_OCTAL_NUMBER_in_constant4151); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OCTAL_NUMBER264_tree = (Object)adaptor.create(OCTAL_NUMBER264);
                    adaptor.addChild(root_0, OCTAL_NUMBER264_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant = Constant.parseOctal((OCTAL_NUMBER264!=null?OCTAL_NUMBER264.getText():null)); 
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1298:3: CHARACTER
                    {
                    root_0 = (Object)adaptor.nil();

                    CHARACTER265=(Token)match(input,CHARACTER,FOLLOW_CHARACTER_in_constant4159); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARACTER265_tree = (Object)adaptor.create(CHARACTER265);
                    adaptor.addChild(root_0, CHARACTER265_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant =  Constant.parseCharOrStringInteger((CHARACTER265!=null?CHARACTER265.getText():null)); 
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1299:3: FLOAT_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    FLOAT_NUMBER266=(Token)match(input,FLOAT_NUMBER,FOLLOW_FLOAT_NUMBER_in_constant4167); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT_NUMBER266_tree = (Object)adaptor.create(FLOAT_NUMBER266);
                    adaptor.addChild(root_0, FLOAT_NUMBER266_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant = Constant.parseFloat((FLOAT_NUMBER266!=null?FLOAT_NUMBER266.getText():null)); 
                    }

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1301:3: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING267=(Token)match(input,STRING,FOLLOW_STRING_in_constant4178); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING267_tree = (Object)adaptor.create(STRING267);
                    adaptor.addChild(root_0, STRING267_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant =  Constant.parseString((STRING267!=null?STRING267.getText():null)); 
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
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:275:5: ( functionDeclaration )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:275:5: functionDeclaration
        {
        pushFollow(FOLLOW_functionDeclaration_in_synpred6_ObjCpp245);
        functionDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_ObjCpp

    // $ANTLR start synpred8_ObjCpp
    public final void synpred8_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:281:5: ( varDecl )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:281:5: varDecl
        {
        pushFollow(FOLLOW_varDecl_in_synpred8_ObjCpp265);
        varDecl();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_ObjCpp

    // $ANTLR start synpred15_ObjCpp
    public final void synpred15_ObjCpp_fragment() throws RecognitionException {   
        Token n1=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:355:4: (n1= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:355:4: n1= IDENTIFIER
        {
        n1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred15_ObjCpp506); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_ObjCpp

    // $ANTLR start synpred29_ObjCpp
    public final void synpred29_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.varDecl_return fv = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:425:7: (fv= varDecl )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:425:7: fv= varDecl
        {
        pushFollow(FOLLOW_varDecl_in_synpred29_ObjCpp824);
        fv=varDecl();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_ObjCpp

    // $ANTLR start synpred43_ObjCpp
    public final void synpred43_ObjCpp_fragment() throws RecognitionException {   
        Token n0=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:529:4: ( (n0= IDENTIFIER ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:529:4: (n0= IDENTIFIER )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:529:4: (n0= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:530:5: n0= IDENTIFIER
        {
        n0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred43_ObjCpp1162); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred43_ObjCpp

    // $ANTLR start synpred44_ObjCpp
    public final void synpred44_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:536:7: ( exportationModifiers )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:536:7: exportationModifiers
        {
        pushFollow(FOLLOW_exportationModifiers_in_synpred44_ObjCpp1185);
        exportationModifiers();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_ObjCpp

    // $ANTLR start synpred50_ObjCpp
    public final void synpred50_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.typeRef_return returnTypeRef = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:578:16: (returnTypeRef= typeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:578:16: returnTypeRef= typeRef
        {
        pushFollow(FOLLOW_typeRef_in_synpred50_ObjCpp1337);
        returnTypeRef=typeRef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_ObjCpp

    // $ANTLR start synpred51_ObjCpp
    public final void synpred51_ObjCpp_fragment() throws RecognitionException {   
        Token ct=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:591:4: ({...}?ct= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:591:4: {...}?ct= IDENTIFIER
        {
        if ( !(( next("const", "__const") )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred51_ObjCpp", " next(\"const\", \"__const\") ");
        }
        ct=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred51_ObjCpp1372); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred51_ObjCpp

    // $ANTLR start synpred53_ObjCpp
    public final void synpred53_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:610:4: ( exportationModifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:610:4: exportationModifier
        {
        pushFollow(FOLLOW_exportationModifier_in_synpred53_ObjCpp1435);
        exportationModifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_ObjCpp

    // $ANTLR start synpred56_ObjCpp
    public final void synpred56_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return sm = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:670:4: ({...}?sm= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:670:4: {...}?sm= modifier
        {
        if ( !(( next(Modifier.Kind.StorageClassSpecifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred56_ObjCpp", " next(Modifier.Kind.StorageClassSpecifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred56_ObjCpp1609);
        sm=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_ObjCpp

    // $ANTLR start synpred57_ObjCpp
    public final void synpred57_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return tm = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:672:4: ({...}?tm= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:672:4: {...}?tm= modifier
        {
        if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred57_ObjCpp", " next(Modifier.Kind.TypeQualifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred57_ObjCpp1626);
        tm=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred57_ObjCpp

    // $ANTLR start synpred65_ObjCpp
    public final void synpred65_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return m1a = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:762:4: ({...}?m1a= modifier '(' expression ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:762:4: {...}?m1a= modifier '(' expression ')'
        {
        if ( !(( next(Modifier.Kind.VCAnnotation1Arg) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred65_ObjCpp", " next(Modifier.Kind.VCAnnotation1Arg) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred65_ObjCpp1845);
        m1a=modifier();

        state._fsp--;
        if (state.failed) return ;
        match(input,34,FOLLOW_34_in_synpred65_ObjCpp1848); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred65_ObjCpp1850);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred65_ObjCpp1852); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred65_ObjCpp

    // $ANTLR start synpred66_ObjCpp
    public final void synpred66_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return m2a = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:763:4: ({...}?m2a= modifier '(' expression ',' expression ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:763:4: {...}?m2a= modifier '(' expression ',' expression ')'
        {
        if ( !(( next(Modifier.Kind.VCAnnotation2Args) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred66_ObjCpp", " next(Modifier.Kind.VCAnnotation2Args) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred66_ObjCpp1865);
        m2a=modifier();

        state._fsp--;
        if (state.failed) return ;
        match(input,34,FOLLOW_34_in_synpred66_ObjCpp1868); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred66_ObjCpp1870);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,27,FOLLOW_27_in_synpred66_ObjCpp1872); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred66_ObjCpp1874);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred66_ObjCpp1876); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred66_ObjCpp

    // $ANTLR start synpred67_ObjCpp
    public final void synpred67_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return m = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:765:4: ({...}?m= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:765:4: {...}?m= modifier
        {
        if ( !(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred67_ObjCpp", " next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred67_ObjCpp1893);
        m=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred67_ObjCpp

    // $ANTLR start synpred68_ObjCpp
    public final void synpred68_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return m1 = null;

        ObjCppParser.typeRef_return tr = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:4: ({...}?m1= modifier tr= typeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:4: {...}?m1= modifier tr= typeRef
        {
        if ( !(( next(Modifier.Kind.ReferenceQualifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred68_ObjCpp", " next(Modifier.Kind.ReferenceQualifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred68_ObjCpp1910);
        m1=modifier();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_typeRef_in_synpred68_ObjCpp1919);
        tr=typeRef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred68_ObjCpp

    // $ANTLR start synpred85_ObjCpp
    public final void synpred85_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:852:4: ( ( typeMutator )* functionSignatureSuffix )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:852:4: ( typeMutator )* functionSignatureSuffix
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:852:4: ( typeMutator )*
        loop131:
        do {
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==IDENTIFIER||(LA131_0>=51 && LA131_0<=53)) ) {
                alt131=1;
            }


            switch (alt131) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:853:5: typeMutator
        	    {
        	    pushFollow(FOLLOW_typeMutator_in_synpred85_ObjCpp2365);
        	    typeMutator();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop131;
            }
        } while (true);

        pushFollow(FOLLOW_functionSignatureSuffix_in_synpred85_ObjCpp2378);
        functionSignatureSuffix();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred85_ObjCpp

    // $ANTLR start synpred87_ObjCpp
    public final void synpred87_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:867:4: ( ( typeMutator )* functionSignatureSuffixNoName )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:867:4: ( typeMutator )* functionSignatureSuffixNoName
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:867:4: ( typeMutator )*
        loop132:
        do {
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( (LA132_0==IDENTIFIER||(LA132_0>=51 && LA132_0<=53)) ) {
                alt132=1;
            }


            switch (alt132) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:868:5: typeMutator
        	    {
        	    pushFollow(FOLLOW_typeMutator_in_synpred87_ObjCpp2419);
        	    typeMutator();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop132;
            }
        } while (true);

        pushFollow(FOLLOW_functionSignatureSuffixNoName_in_synpred87_ObjCpp2432);
        functionSignatureSuffixNoName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred87_ObjCpp

    // $ANTLR start synpred89_ObjCpp
    public final void synpred89_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:888:4: ({...}? modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:888:4: {...}? modifier
        {
        if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred89_ObjCpp", " next(Modifier.Kind.TypeQualifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred89_ObjCpp2496);
        modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred89_ObjCpp

    // $ANTLR start synpred93_ObjCpp
    public final void synpred93_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:908:5: ( '=' expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:908:5: '=' expression
        {
        match(input,29,FOLLOW_29_in_synpred93_ObjCpp2587); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred93_ObjCpp2594);
        expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred93_ObjCpp

    // $ANTLR start synpred95_ObjCpp
    public final void synpred95_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return sm = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:950:4: ({...}?sm= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:950:4: {...}?sm= modifier
        {
        if ( !(( next(Modifier.Kind.StorageClassSpecifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred95_ObjCpp", " next(Modifier.Kind.StorageClassSpecifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred95_ObjCpp2721);
        sm=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred95_ObjCpp

    // $ANTLR start synpred96_ObjCpp
    public final void synpred96_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return tm = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:952:4: ({...}?tm= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:952:4: {...}?tm= modifier
        {
        if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred96_ObjCpp", " next(Modifier.Kind.TypeQualifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred96_ObjCpp2738);
        tm=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred96_ObjCpp

    // $ANTLR start synpred102_ObjCpp
    public final void synpred102_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return im = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1039:5: (im= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1039:5: im= modifier
        {
        pushFollow(FOLLOW_modifier_in_synpred102_ObjCpp3005);
        im=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred102_ObjCpp

    // $ANTLR start synpred106_ObjCpp
    public final void synpred106_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.argDef_return ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1080:5: ( ',' ax= argDef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1080:5: ',' ax= argDef
        {
        match(input,27,FOLLOW_27_in_synpred106_ObjCpp3126); if (state.failed) return ;
        pushFollow(FOLLOW_argDef_in_synpred106_ObjCpp3135);
        ax=argDef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred106_ObjCpp

    // $ANTLR start synpred109_ObjCpp
    public final void synpred109_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1101:4: ( typeMutator )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1101:4: typeMutator
        {
        pushFollow(FOLLOW_typeMutator_in_synpred109_ObjCpp3205);
        typeMutator();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred109_ObjCpp

    // $ANTLR start synpred155_ObjCpp
    public final void synpred155_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.expression_return par = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1235:5: (par= expression ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1235:5: par= expression ')'
        {
        pushFollow(FOLLOW_expression_in_synpred155_ObjCpp3756);
        par=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred155_ObjCpp3758); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred155_ObjCpp

    // $ANTLR start synpred158_ObjCpp
    public final void synpred158_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.binaryOp_return bop = null;

        ObjCppParser.expression_return opd2 = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1248:4: (bop= binaryOp opd2= expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1248:4: bop= binaryOp opd2= expression
        {
        pushFollow(FOLLOW_binaryOp_in_synpred158_ObjCpp3818);
        bop=binaryOp();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred158_ObjCpp3825);
        opd2=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred158_ObjCpp

    // $ANTLR start synpred159_ObjCpp
    public final void synpred159_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.expression_return val = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1252:4: ( '=' val= expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1252:4: '=' val= expression
        {
        match(input,29,FOLLOW_29_in_synpred159_ObjCpp3834); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred159_ObjCpp3838);
        val=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred159_ObjCpp

    // $ANTLR start synpred160_ObjCpp
    public final void synpred160_ObjCpp_fragment() throws RecognitionException {   
        Token fieldName=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1255:4: ( '.' fieldName= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1255:4: '.' fieldName= IDENTIFIER
        {
        match(input,90,FOLLOW_90_in_synpred160_ObjCpp3847); if (state.failed) return ;
        fieldName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred160_ObjCpp3851); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred160_ObjCpp

    // $ANTLR start synpred163_ObjCpp
    public final void synpred163_ObjCpp_fragment() throws RecognitionException {   
        Token refStyle=null;
        ObjCppParser.functionCall_return fc2 = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1258:4: (refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1258:4: refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1258:13: ( ':' ':' | '-' '>' | '.' )
        int alt141=3;
        switch ( input.LA(1) ) {
        case 33:
            {
            alt141=1;
            }
            break;
        case 43:
            {
            alt141=2;
            }
            break;
        case 90:
            {
            alt141=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 141, 0, input);

            throw nvae;
        }

        switch (alt141) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1258:14: ':' ':'
                {
                match(input,33,FOLLOW_33_in_synpred163_ObjCpp3863); if (state.failed) return ;
                match(input,33,FOLLOW_33_in_synpred163_ObjCpp3865); if (state.failed) return ;

                }
                break;
            case 2 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1258:24: '-' '>'
                {
                match(input,43,FOLLOW_43_in_synpred163_ObjCpp3869); if (state.failed) return ;
                match(input,37,FOLLOW_37_in_synpred163_ObjCpp3871); if (state.failed) return ;

                }
                break;
            case 3 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1258:34: '.'
                {
                match(input,90,FOLLOW_90_in_synpred163_ObjCpp3875); if (state.failed) return ;

                }
                break;

        }

        pushFollow(FOLLOW_functionCall_in_synpred163_ObjCpp3880);
        fc2=functionCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred163_ObjCpp

    // $ANTLR start synpred164_ObjCpp
    public final void synpred164_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.expression_return xif = null;

        ObjCppParser.expression_return xelse = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1265:7: ( '?' xif= expression ':' xelse= expression )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1265:7: '?' xif= expression ':' xelse= expression
        {
        match(input,91,FOLLOW_91_in_synpred164_ObjCpp3892); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred164_ObjCpp3896);
        xif=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,33,FOLLOW_33_in_synpred164_ObjCpp3898); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred164_ObjCpp3902);
        xelse=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred164_ObjCpp

    // $ANTLR start synpred166_ObjCpp
    public final void synpred166_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1277:3: ( statementsBlock )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1277:3: statementsBlock
        {
        pushFollow(FOLLOW_statementsBlock_in_synpred166_ObjCpp3943);
        statementsBlock();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred166_ObjCpp

    // $ANTLR start synpred167_ObjCpp
    public final void synpred167_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1278:3: ( declaration )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1278:3: declaration
        {
        pushFollow(FOLLOW_declaration_in_synpred167_ObjCpp3949);
        declaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred167_ObjCpp

    // $ANTLR start synpred169_ObjCpp
    public final void synpred169_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1279:3: ( expression ( '=' expression )? ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1279:3: expression ( '=' expression )? ';'
        {
        pushFollow(FOLLOW_expression_in_synpred169_ObjCpp3955);
        expression();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1279:14: ( '=' expression )?
        int alt142=2;
        int LA142_0 = input.LA(1);

        if ( (LA142_0==29) ) {
            alt142=1;
        }
        switch (alt142) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1279:15: '=' expression
                {
                match(input,29,FOLLOW_29_in_synpred169_ObjCpp3958); if (state.failed) return ;
                pushFollow(FOLLOW_expression_in_synpred169_ObjCpp3960);
                expression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }

        match(input,28,FOLLOW_28_in_synpred169_ObjCpp3965); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred169_ObjCpp

    // $ANTLR start synpred171_ObjCpp
    public final void synpred171_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1281:38: ( 'else' statement )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1281:38: 'else' statement
        {
        match(input,93,FOLLOW_93_in_synpred171_ObjCpp3992); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred171_ObjCpp3994);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred171_ObjCpp

    // $ANTLR start synpred175_ObjCpp
    public final void synpred175_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1284:13: ( statement )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1284:13: statement
        {
        pushFollow(FOLLOW_statement_in_synpred175_ObjCpp4038);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred175_ObjCpp

    // Delegated rules

    public final boolean synpred66_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred66_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred175_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred175_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred43_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred15_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred44_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred169_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred169_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred171_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred171_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred109_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred68_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred68_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_ObjCpp_fragment(); // can never throw exception
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
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA45 dfa45 = new DFA45(this);
    protected DFA46 dfa46 = new DFA46(this);
    protected DFA51 dfa51 = new DFA51(this);
    protected DFA49 dfa49 = new DFA49(this);
    protected DFA63 dfa63 = new DFA63(this);
    protected DFA65 dfa65 = new DFA65(this);
    protected DFA67 dfa67 = new DFA67(this);
    protected DFA69 dfa69 = new DFA69(this);
    protected DFA71 dfa71 = new DFA71(this);
    protected DFA76 dfa76 = new DFA76(this);
    protected DFA78 dfa78 = new DFA78(this);
    protected DFA80 dfa80 = new DFA80(this);
    protected DFA83 dfa83 = new DFA83(this);
    protected DFA86 dfa86 = new DFA86(this);
    protected DFA85 dfa85 = new DFA85(this);
    protected DFA90 dfa90 = new DFA90(this);
    protected DFA93 dfa93 = new DFA93(this);
    protected DFA92 dfa92 = new DFA92(this);
    protected DFA95 dfa95 = new DFA95(this);
    protected DFA96 dfa96 = new DFA96(this);
    protected DFA103 dfa103 = new DFA103(this);
    protected DFA98 dfa98 = new DFA98(this);
    protected DFA99 dfa99 = new DFA99(this);
    protected DFA100 dfa100 = new DFA100(this);
    protected DFA101 dfa101 = new DFA101(this);
    protected DFA102 dfa102 = new DFA102(this);
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
            return "214:3: (unescapedString= STRING )?";
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
            return "225:8: (depth= DECIMAL_NUMBER )?";
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
            return "()* loopback of 231:3: ( declaration | lineDirective )*";
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
            return "()* loopback of 251:4: (ed= declaration )*";
        }
    }
    static final String DFA6_eotS =
        "\u0100\uffff";
    static final String DFA6_eofS =
        "\u0100\uffff";
    static final String DFA6_minS =
        "\1\6\1\5\2\6\1\100\2\6\4\uffff\1\4\1\uffff\3\6\1\100\4\6\1\66\1"+
        "\uffff\6\6\2\uffff\1\6\2\uffff\7\6\1\66\1\6\1\uffff\3\6\1\66\1\6"+
        "\1\uffff\2\0\7\uffff\14\0\1\uffff\5\0\1\uffff\6\0\3\uffff\10\0\2"+
        "\uffff\11\0\1\uffff\5\0\1\uffff\4\0\1\uffff\6\0\1\uffff\14\0\1\uffff"+
        "\1\0\2\uffff\24\0\4\uffff\5\0\3\uffff\3\0\3\uffff\7\0\1\uffff\5"+
        "\0\1\uffff\6\0\1\uffff\5\0\1\uffff\2\0\1\uffff\1\0\4\uffff\4\0\1"+
        "\uffff\6\0\1\uffff\3\0\2\uffff\2\0\1\uffff\1\0\4\uffff\4\0\1\uffff"+
        "\6\0\1\uffff\3\0\2\uffff";
    static final String DFA6_maxS =
        "\2\112\1\27\1\72\2\112\1\72\4\uffff\1\131\1\uffff\1\112\1\27\1\72"+
        "\2\112\3\72\1\66\1\uffff\1\112\1\72\1\112\1\72\1\30\1\72\2\uffff"+
        "\1\72\2\uffff\1\112\1\72\1\112\4\72\1\66\1\72\1\uffff\3\72\1\66"+
        "\1\72\1\uffff\2\0\7\uffff\14\0\1\uffff\5\0\1\uffff\6\0\3\uffff\10"+
        "\0\2\uffff\11\0\1\uffff\5\0\1\uffff\4\0\1\uffff\6\0\1\uffff\14\0"+
        "\1\uffff\1\0\2\uffff\24\0\4\uffff\5\0\3\uffff\3\0\3\uffff\7\0\1"+
        "\uffff\5\0\1\uffff\6\0\1\uffff\5\0\1\uffff\2\0\1\uffff\1\0\4\uffff"+
        "\4\0\1\uffff\6\0\1\uffff\3\0\2\uffff\2\0\1\uffff\1\0\4\uffff\4\0"+
        "\1\uffff\6\0\1\uffff\3\0\2\uffff";
    static final String DFA6_acceptS =
        "\7\uffff\1\4\1\5\1\6\1\7\1\uffff\1\2\11\uffff\1\3\12\uffff\1\1\u00de"+
        "\uffff";
    static final String DFA6_specialS =
        "\62\uffff\1\0\1\1\7\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
        "\1\13\1\14\1\15\1\uffff\1\16\1\17\1\20\1\21\1\22\1\uffff\1\23\1"+
        "\24\1\25\1\26\1\27\1\30\3\uffff\1\31\1\32\1\33\1\34\1\35\1\36\1"+
        "\37\1\40\2\uffff\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1"+
        "\uffff\1\52\1\53\1\54\1\55\1\56\1\uffff\1\57\1\60\1\61\1\62\1\uffff"+
        "\1\63\1\64\1\65\1\66\1\67\1\70\1\uffff\1\71\1\72\1\73\1\74\1\75"+
        "\1\76\1\77\1\100\1\101\1\102\1\103\1\104\1\uffff\1\105\2\uffff\1"+
        "\106\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1\116\1\117\1\120"+
        "\1\121\1\122\1\123\1\124\1\125\1\126\1\127\1\130\1\131\4\uffff\1"+
        "\132\1\133\1\134\1\135\1\136\3\uffff\1\137\1\140\1\141\3\uffff\1"+
        "\142\1\143\1\144\1\145\1\146\1\147\1\150\1\uffff\1\151\1\152\1\153"+
        "\1\154\1\155\1\uffff\1\156\1\157\1\160\1\161\1\162\1\163\1\uffff"+
        "\1\164\1\165\1\166\1\167\1\170\1\uffff\1\171\1\172\1\uffff\1\173"+
        "\4\uffff\1\174\1\175\1\176\1\177\1\uffff\1\u0080\1\u0081\1\u0082"+
        "\1\u0083\1\u0084\1\u0085\1\uffff\1\u0086\1\u0087\1\u0088\2\uffff"+
        "\1\u0089\1\u008a\1\uffff\1\u008b\4\uffff\1\u008c\1\u008d\1\u008e"+
        "\1\u008f\1\uffff\1\u0090\1\u0091\1\u0092\1\u0093\1\u0094\1\u0095"+
        "\1\uffff\1\u0096\1\u0097\1\u0098\2\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1\22\uffff\1\12\1\11\3\uffff\1\3\2\7\14\uffff\3\2\13\uffff"+
            "\1\10\4\4\2\5\11\6",
            "\1\14\1\15\27\uffff\1\17\3\uffff\1\13\1\uffff\1\27\10\uffff"+
            "\3\16\3\uffff\1\23\1\24\1\25\4\uffff\1\26\1\uffff\4\20\2\21"+
            "\11\22",
            "\1\30\20\uffff\1\31",
            "\1\32\20\uffff\1\33\4\uffff\1\26\5\uffff\1\26\20\uffff\1\34"+
            "\1\37\1\41\4\uffff\1\26",
            "\2\42\11\43",
            "\1\46\33\uffff\1\52\20\uffff\1\47\1\50\1\51\4\uffff\1\26\5"+
            "\uffff\2\44\11\45",
            "\1\54\33\uffff\1\60\20\uffff\1\55\1\56\1\57\4\uffff\1\26",
            "",
            "",
            "",
            "",
            "\1\100\1\105\1\63\1\101\1\102\1\103\1\104\14\uffff\1\106\6"+
            "\uffff\1\41\3\uffff\1\77\1\41\10\uffff\4\41\3\uffff\1\73\1\26"+
            "\1\75\1\uffff\1\62\2\uffff\1\26\1\uffff\17\41\1\74\14\uffff"+
            "\2\76",
            "",
            "\1\112\24\uffff\3\26\1\120\3\uffff\1\110\1\uffff\1\116\10\uffff"+
            "\3\117\3\uffff\1\111\1\113\1\114\4\uffff\1\26\1\uffff\4\121"+
            "\2\122\11\123",
            "\1\127\20\uffff\1\130",
            "\1\131\20\uffff\1\132\4\uffff\1\26\5\uffff\1\136\20\uffff\1"+
            "\133\1\134\1\135\4\uffff\1\26",
            "\2\141\11\142",
            "\1\143\33\uffff\1\147\20\uffff\1\144\1\145\1\146\4\uffff\1"+
            "\26\5\uffff\2\150\11\151",
            "\1\153\33\uffff\1\157\20\uffff\1\154\1\155\1\156\4\uffff\1"+
            "\26",
            "\1\161\33\uffff\1\166\20\uffff\1\162\1\163\1\164\4\uffff\1"+
            "\26",
            "\1\170\33\uffff\1\167\20\uffff\1\171\1\172\1\173\4\uffff\1"+
            "\26",
            "\1\175",
            "",
            "\1\u0080\27\uffff\1\177\6\uffff\1\u0084\7\uffff\3\176\14\uffff"+
            "\4\u0081\2\u0082\11\u0083",
            "\1\u0086\20\uffff\1\u0085\4\uffff\1\26\5\uffff\1\u0088\20\uffff"+
            "\1\u0087\1\u008a\1\41\4\uffff\1\26",
            "\1\u0090\21\uffff\1\u009a\1\u0099\1\u0098\3\uffff\1\u0092\2"+
            "\u0096\14\uffff\3\u0091\1\u008d\1\u008e\1\u008f\10\uffff\1\u0097"+
            "\4\u0093\2\u0094\11\u0095",
            "\1\u009c\20\uffff\1\u009e\3\uffff\3\26\4\uffff\1\u009d\20\uffff"+
            "\1\u009b\1\u009f\1\u00a0\4\uffff\1\26",
            "\1\u00a5\21\uffff\1\u00a6",
            "\1\u00a7\33\uffff\1\26\20\uffff\1\u00a8\1\u00a9\1\41\4\uffff"+
            "\1\26",
            "",
            "",
            "\1\u00ad\33\uffff\1\26\20\uffff\1\u00ae\1\u00af\1\41\4\uffff"+
            "\1\26",
            "",
            "",
            "\1\u00b5\33\uffff\1\u00b9\20\uffff\1\u00b6\1\u00b7\1\u00b8"+
            "\4\uffff\1\26\5\uffff\2\u00b3\11\u00b4",
            "\1\u00bb\33\uffff\1\u00bf\20\uffff\1\u00bc\1\u00bd\1\u00be"+
            "\4\uffff\1\26",
            "\1\u00c2\33\uffff\1\u00c6\20\uffff\1\u00c3\1\u00c4\1\u00c5"+
            "\4\uffff\1\26\5\uffff\13\u00c1",
            "\1\u00c8\33\uffff\1\u00cc\20\uffff\1\u00c9\1\u00ca\1\u00cb"+
            "\4\uffff\1\26",
            "\1\u00cf\24\uffff\3\26\4\uffff\1\u00d1\20\uffff\1\u00ce\2\26"+
            "\4\uffff\1\26",
            "\1\u00d6\33\uffff\1\u00db\20\uffff\1\u00d7\1\u00d8\1\u00d9"+
            "\4\uffff\1\26",
            "\1\u00dd\33\uffff\1\u00dc\20\uffff\1\u00de\1\u00df\1\u00e0"+
            "\4\uffff\1\26",
            "\1\u00e2",
            "\1\u00e3\33\uffff\1\26\20\uffff\1\u00e4\1\26\5\uffff\1\26",
            "",
            "\1\u00e8\24\uffff\3\26\4\uffff\1\u00ea\20\uffff\1\u00e7\2\26"+
            "\4\uffff\1\26",
            "\1\u00ef\33\uffff\1\u00f4\20\uffff\1\u00f0\1\u00f1\1\u00f2"+
            "\4\uffff\1\26",
            "\1\u00f6\33\uffff\1\u00f5\20\uffff\1\u00f7\1\u00f8\1\u00f9"+
            "\4\uffff\1\26",
            "\1\u00fb",
            "\1\u00fc\33\uffff\1\26\20\uffff\1\u00fd\1\26\5\uffff\1\26",
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
            "\1\uffff",
            "\1\uffff",
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
            return "273:4: ( functionDeclaration | externDeclarations | varDecl | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA6_50 = input.LA(1);

                         
                        int index6_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((synpred8_ObjCpp()&&( "__success".equals(next()) ))) ) {s = 22;}

                         
                        input.seek(index6_50);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_51 = input.LA(1);

                         
                        int index6_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||(synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_51);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA6_59 = input.LA(1);

                         
                        int index6_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 22;}

                         
                        input.seek(index6_59);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA6_60 = input.LA(1);

                         
                        int index6_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_60);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA6_61 = input.LA(1);

                         
                        int index6_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_61);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA6_62 = input.LA(1);

                         
                        int index6_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_62);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA6_63 = input.LA(1);

                         
                        int index6_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||(synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null )))) ) {s = 22;}

                         
                        input.seek(index6_63);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA6_64 = input.LA(1);

                         
                        int index6_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_64);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA6_65 = input.LA(1);

                         
                        int index6_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_65);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA6_66 = input.LA(1);

                         
                        int index6_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_66);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA6_67 = input.LA(1);

                         
                        int index6_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_67);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA6_68 = input.LA(1);

                         
                        int index6_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_68);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA6_69 = input.LA(1);

                         
                        int index6_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_69);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA6_70 = input.LA(1);

                         
                        int index6_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_70);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA6_72 = input.LA(1);

                         
                        int index6_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_72);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA6_73 = input.LA(1);

                         
                        int index6_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_73);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA6_74 = input.LA(1);

                         
                        int index6_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_74);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA6_75 = input.LA(1);

                         
                        int index6_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_75);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA6_76 = input.LA(1);

                         
                        int index6_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_76);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA6_78 = input.LA(1);

                         
                        int index6_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_78);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA6_79 = input.LA(1);

                         
                        int index6_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_79);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA6_80 = input.LA(1);

                         
                        int index6_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_80);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA6_81 = input.LA(1);

                         
                        int index6_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_81);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA6_82 = input.LA(1);

                         
                        int index6_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_82);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA6_83 = input.LA(1);

                         
                        int index6_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_83);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA6_87 = input.LA(1);

                         
                        int index6_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_87);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA6_88 = input.LA(1);

                         
                        int index6_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_88);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA6_89 = input.LA(1);

                         
                        int index6_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_89);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA6_90 = input.LA(1);

                         
                        int index6_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_90);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA6_91 = input.LA(1);

                         
                        int index6_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_91);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA6_92 = input.LA(1);

                         
                        int index6_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_92);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA6_93 = input.LA(1);

                         
                        int index6_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 22;}

                         
                        input.seek(index6_93);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA6_94 = input.LA(1);

                         
                        int index6_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_94);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA6_97 = input.LA(1);

                         
                        int index6_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_97);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA6_98 = input.LA(1);

                         
                        int index6_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_98);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA6_99 = input.LA(1);

                         
                        int index6_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_99);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA6_100 = input.LA(1);

                         
                        int index6_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_100);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA6_101 = input.LA(1);

                         
                        int index6_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_101);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA6_102 = input.LA(1);

                         
                        int index6_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_102);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA6_103 = input.LA(1);

                         
                        int index6_103 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_103);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA6_104 = input.LA(1);

                         
                        int index6_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_104);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA6_105 = input.LA(1);

                         
                        int index6_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_105);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA6_107 = input.LA(1);

                         
                        int index6_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_107);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA6_108 = input.LA(1);

                         
                        int index6_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_108);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA6_109 = input.LA(1);

                         
                        int index6_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_109);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA6_110 = input.LA(1);

                         
                        int index6_110 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_110);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA6_111 = input.LA(1);

                         
                        int index6_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred8_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 22;}

                         
                        input.seek(index6_111);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA6_113 = input.LA(1);

                         
                        int index6_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 22;}

                         
                        input.seek(index6_113);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA6_114 = input.LA(1);

                         
                        int index6_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 22;}

                         
                        input.seek(index6_114);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA6_115 = input.LA(1);

                         
                        int index6_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 22;}

                         
                        input.seek(index6_115);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA6_116 = input.LA(1);

                         
                        int index6_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 22;}

                         
                        input.seek(index6_116);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA6_118 = input.LA(1);

                         
                        int index6_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 22;}

                         
                        input.seek(index6_118);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA6_119 = input.LA(1);

                         
                        int index6_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 22;}

                         
                        input.seek(index6_119);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA6_120 = input.LA(1);

                         
                        int index6_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 22;}

                         
                        input.seek(index6_120);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA6_121 = input.LA(1);

                         
                        int index6_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 22;}

                         
                        input.seek(index6_121);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA6_122 = input.LA(1);

                         
                        int index6_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 22;}

                         
                        input.seek(index6_122);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA6_123 = input.LA(1);

                         
                        int index6_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 22;}

                         
                        input.seek(index6_123);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA6_125 = input.LA(1);

                         
                        int index6_125 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 22;}

                         
                        input.seek(index6_125);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA6_126 = input.LA(1);

                         
                        int index6_126 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 22;}

                         
                        input.seek(index6_126);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA6_127 = input.LA(1);

                         
                        int index6_127 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 22;}

                         
                        input.seek(index6_127);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA6_128 = input.LA(1);

                         
                        int index6_128 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 22;}

                         
                        input.seek(index6_128);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA6_129 = input.LA(1);

                         
                        int index6_129 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 22;}

                         
                        input.seek(index6_129);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA6_130 = input.LA(1);

                         
                        int index6_130 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 22;}

                         
                        input.seek(index6_130);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA6_131 = input.LA(1);

                         
                        int index6_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 22;}

                         
                        input.seek(index6_131);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA6_132 = input.LA(1);

                         
                        int index6_132 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( ((synpred8_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 22;}

                         
                        input.seek(index6_132);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA6_133 = input.LA(1);

                         
                        int index6_133 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_133);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA6_134 = input.LA(1);

                         
                        int index6_134 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_134);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA6_135 = input.LA(1);

                         
                        int index6_135 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_135);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA6_136 = input.LA(1);

                         
                        int index6_136 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_136);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA6_138 = input.LA(1);

                         
                        int index6_138 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_138);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA6_141 = input.LA(1);

                         
                        int index6_141 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_141);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA6_142 = input.LA(1);

                         
                        int index6_142 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_142);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA6_143 = input.LA(1);

                         
                        int index6_143 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_143);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA6_144 = input.LA(1);

                         
                        int index6_144 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_144);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA6_145 = input.LA(1);

                         
                        int index6_145 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_145);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA6_146 = input.LA(1);

                         
                        int index6_146 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_146);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA6_147 = input.LA(1);

                         
                        int index6_147 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_147);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA6_148 = input.LA(1);

                         
                        int index6_148 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_148);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA6_149 = input.LA(1);

                         
                        int index6_149 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_149);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA6_150 = input.LA(1);

                         
                        int index6_150 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_150);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA6_151 = input.LA(1);

                         
                        int index6_151 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_151);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA6_152 = input.LA(1);

                         
                        int index6_152 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_152);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA6_153 = input.LA(1);

                         
                        int index6_153 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_153);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA6_154 = input.LA(1);

                         
                        int index6_154 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_154);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA6_155 = input.LA(1);

                         
                        int index6_155 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_155);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA6_156 = input.LA(1);

                         
                        int index6_156 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_156);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA6_157 = input.LA(1);

                         
                        int index6_157 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_157);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA6_158 = input.LA(1);

                         
                        int index6_158 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_158);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA6_159 = input.LA(1);

                         
                        int index6_159 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_159);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA6_160 = input.LA(1);

                         
                        int index6_160 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_160);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA6_165 = input.LA(1);

                         
                        int index6_165 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_165);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA6_166 = input.LA(1);

                         
                        int index6_166 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_166);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA6_167 = input.LA(1);

                         
                        int index6_167 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_167);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA6_168 = input.LA(1);

                         
                        int index6_168 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_168);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA6_169 = input.LA(1);

                         
                        int index6_169 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_169);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA6_173 = input.LA(1);

                         
                        int index6_173 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_173);
                        if ( s>=0 ) return s;
                        break;
                    case 96 : 
                        int LA6_174 = input.LA(1);

                         
                        int index6_174 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_174);
                        if ( s>=0 ) return s;
                        break;
                    case 97 : 
                        int LA6_175 = input.LA(1);

                         
                        int index6_175 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_175);
                        if ( s>=0 ) return s;
                        break;
                    case 98 : 
                        int LA6_179 = input.LA(1);

                         
                        int index6_179 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_179);
                        if ( s>=0 ) return s;
                        break;
                    case 99 : 
                        int LA6_180 = input.LA(1);

                         
                        int index6_180 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_180);
                        if ( s>=0 ) return s;
                        break;
                    case 100 : 
                        int LA6_181 = input.LA(1);

                         
                        int index6_181 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_181);
                        if ( s>=0 ) return s;
                        break;
                    case 101 : 
                        int LA6_182 = input.LA(1);

                         
                        int index6_182 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_182);
                        if ( s>=0 ) return s;
                        break;
                    case 102 : 
                        int LA6_183 = input.LA(1);

                         
                        int index6_183 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_183);
                        if ( s>=0 ) return s;
                        break;
                    case 103 : 
                        int LA6_184 = input.LA(1);

                         
                        int index6_184 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_184);
                        if ( s>=0 ) return s;
                        break;
                    case 104 : 
                        int LA6_185 = input.LA(1);

                         
                        int index6_185 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_185);
                        if ( s>=0 ) return s;
                        break;
                    case 105 : 
                        int LA6_187 = input.LA(1);

                         
                        int index6_187 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_187);
                        if ( s>=0 ) return s;
                        break;
                    case 106 : 
                        int LA6_188 = input.LA(1);

                         
                        int index6_188 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_188);
                        if ( s>=0 ) return s;
                        break;
                    case 107 : 
                        int LA6_189 = input.LA(1);

                         
                        int index6_189 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_189);
                        if ( s>=0 ) return s;
                        break;
                    case 108 : 
                        int LA6_190 = input.LA(1);

                         
                        int index6_190 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_190);
                        if ( s>=0 ) return s;
                        break;
                    case 109 : 
                        int LA6_191 = input.LA(1);

                         
                        int index6_191 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_191);
                        if ( s>=0 ) return s;
                        break;
                    case 110 : 
                        int LA6_193 = input.LA(1);

                         
                        int index6_193 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_193);
                        if ( s>=0 ) return s;
                        break;
                    case 111 : 
                        int LA6_194 = input.LA(1);

                         
                        int index6_194 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_194);
                        if ( s>=0 ) return s;
                        break;
                    case 112 : 
                        int LA6_195 = input.LA(1);

                         
                        int index6_195 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_195);
                        if ( s>=0 ) return s;
                        break;
                    case 113 : 
                        int LA6_196 = input.LA(1);

                         
                        int index6_196 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_196);
                        if ( s>=0 ) return s;
                        break;
                    case 114 : 
                        int LA6_197 = input.LA(1);

                         
                        int index6_197 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_197);
                        if ( s>=0 ) return s;
                        break;
                    case 115 : 
                        int LA6_198 = input.LA(1);

                         
                        int index6_198 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_198);
                        if ( s>=0 ) return s;
                        break;
                    case 116 : 
                        int LA6_200 = input.LA(1);

                         
                        int index6_200 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_200);
                        if ( s>=0 ) return s;
                        break;
                    case 117 : 
                        int LA6_201 = input.LA(1);

                         
                        int index6_201 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_201);
                        if ( s>=0 ) return s;
                        break;
                    case 118 : 
                        int LA6_202 = input.LA(1);

                         
                        int index6_202 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_202);
                        if ( s>=0 ) return s;
                        break;
                    case 119 : 
                        int LA6_203 = input.LA(1);

                         
                        int index6_203 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_203);
                        if ( s>=0 ) return s;
                        break;
                    case 120 : 
                        int LA6_204 = input.LA(1);

                         
                        int index6_204 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_204);
                        if ( s>=0 ) return s;
                        break;
                    case 121 : 
                        int LA6_206 = input.LA(1);

                         
                        int index6_206 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_206);
                        if ( s>=0 ) return s;
                        break;
                    case 122 : 
                        int LA6_207 = input.LA(1);

                         
                        int index6_207 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_207);
                        if ( s>=0 ) return s;
                        break;
                    case 123 : 
                        int LA6_209 = input.LA(1);

                         
                        int index6_209 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_209);
                        if ( s>=0 ) return s;
                        break;
                    case 124 : 
                        int LA6_214 = input.LA(1);

                         
                        int index6_214 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_214);
                        if ( s>=0 ) return s;
                        break;
                    case 125 : 
                        int LA6_215 = input.LA(1);

                         
                        int index6_215 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_215);
                        if ( s>=0 ) return s;
                        break;
                    case 126 : 
                        int LA6_216 = input.LA(1);

                         
                        int index6_216 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_216);
                        if ( s>=0 ) return s;
                        break;
                    case 127 : 
                        int LA6_217 = input.LA(1);

                         
                        int index6_217 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_217);
                        if ( s>=0 ) return s;
                        break;
                    case 128 : 
                        int LA6_219 = input.LA(1);

                         
                        int index6_219 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_219);
                        if ( s>=0 ) return s;
                        break;
                    case 129 : 
                        int LA6_220 = input.LA(1);

                         
                        int index6_220 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_220);
                        if ( s>=0 ) return s;
                        break;
                    case 130 : 
                        int LA6_221 = input.LA(1);

                         
                        int index6_221 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_221);
                        if ( s>=0 ) return s;
                        break;
                    case 131 : 
                        int LA6_222 = input.LA(1);

                         
                        int index6_222 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_222);
                        if ( s>=0 ) return s;
                        break;
                    case 132 : 
                        int LA6_223 = input.LA(1);

                         
                        int index6_223 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_223);
                        if ( s>=0 ) return s;
                        break;
                    case 133 : 
                        int LA6_224 = input.LA(1);

                         
                        int index6_224 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_224);
                        if ( s>=0 ) return s;
                        break;
                    case 134 : 
                        int LA6_226 = input.LA(1);

                         
                        int index6_226 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_226);
                        if ( s>=0 ) return s;
                        break;
                    case 135 : 
                        int LA6_227 = input.LA(1);

                         
                        int index6_227 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_227);
                        if ( s>=0 ) return s;
                        break;
                    case 136 : 
                        int LA6_228 = input.LA(1);

                         
                        int index6_228 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_228);
                        if ( s>=0 ) return s;
                        break;
                    case 137 : 
                        int LA6_231 = input.LA(1);

                         
                        int index6_231 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_231);
                        if ( s>=0 ) return s;
                        break;
                    case 138 : 
                        int LA6_232 = input.LA(1);

                         
                        int index6_232 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_232);
                        if ( s>=0 ) return s;
                        break;
                    case 139 : 
                        int LA6_234 = input.LA(1);

                         
                        int index6_234 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_234);
                        if ( s>=0 ) return s;
                        break;
                    case 140 : 
                        int LA6_239 = input.LA(1);

                         
                        int index6_239 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_239);
                        if ( s>=0 ) return s;
                        break;
                    case 141 : 
                        int LA6_240 = input.LA(1);

                         
                        int index6_240 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_240);
                        if ( s>=0 ) return s;
                        break;
                    case 142 : 
                        int LA6_241 = input.LA(1);

                         
                        int index6_241 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_241);
                        if ( s>=0 ) return s;
                        break;
                    case 143 : 
                        int LA6_242 = input.LA(1);

                         
                        int index6_242 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_242);
                        if ( s>=0 ) return s;
                        break;
                    case 144 : 
                        int LA6_244 = input.LA(1);

                         
                        int index6_244 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_244);
                        if ( s>=0 ) return s;
                        break;
                    case 145 : 
                        int LA6_245 = input.LA(1);

                         
                        int index6_245 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_245);
                        if ( s>=0 ) return s;
                        break;
                    case 146 : 
                        int LA6_246 = input.LA(1);

                         
                        int index6_246 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_246);
                        if ( s>=0 ) return s;
                        break;
                    case 147 : 
                        int LA6_247 = input.LA(1);

                         
                        int index6_247 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_247);
                        if ( s>=0 ) return s;
                        break;
                    case 148 : 
                        int LA6_248 = input.LA(1);

                         
                        int index6_248 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_248);
                        if ( s>=0 ) return s;
                        break;
                    case 149 : 
                        int LA6_249 = input.LA(1);

                         
                        int index6_249 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_249);
                        if ( s>=0 ) return s;
                        break;
                    case 150 : 
                        int LA6_251 = input.LA(1);

                         
                        int index6_251 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_251);
                        if ( s>=0 ) return s;
                        break;
                    case 151 : 
                        int LA6_252 = input.LA(1);

                         
                        int index6_252 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_252);
                        if ( s>=0 ) return s;
                        break;
                    case 152 : 
                        int LA6_253 = input.LA(1);

                         
                        int index6_253 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 33;}

                        else if ( (synpred8_ObjCpp()) ) {s = 22;}

                         
                        input.seek(index6_253);
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
            return "()* loopback of 294:6: (subD= declaration )*";
        }
    }
    static final String DFA9_eotS =
        "\34\uffff";
    static final String DFA9_eofS =
        "\1\2\33\uffff";
    static final String DFA9_minS =
        "\1\6\1\0\32\uffff";
    static final String DFA9_maxS =
        "\1\72\1\0\32\uffff";
    static final String DFA9_acceptS =
        "\2\uffff\1\2\30\uffff\1\1";
    static final String DFA9_specialS =
        "\1\uffff\1\0\32\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\1\20\uffff\1\2\3\uffff\3\2\4\uffff\2\2\1\uffff\1\2\15\uffff"+
            "\3\2\4\uffff\1\2",
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

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "354:3: (n1= IDENTIFIER )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_1 = input.LA(1);

                         
                        int index9_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_ObjCpp()) ) {s = 27;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index9_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 9, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA13_eotS =
        "\16\uffff";
    static final String DFA13_eofS =
        "\1\2\15\uffff";
    static final String DFA13_minS =
        "\1\6\15\uffff";
    static final String DFA13_maxS =
        "\1\72\15\uffff";
    static final String DFA13_acceptS =
        "\1\uffff\1\1\1\2\13\uffff";
    static final String DFA13_specialS =
        "\16\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\2\20\uffff\1\1\3\uffff\3\2\4\uffff\2\2\1\uffff\1\2\15\uffff"+
            "\3\2\4\uffff\1\2",
            "",
            "",
            "",
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
            return "359:3: ( '{' (i1= enumItem ( ',' (ix= enumItem )? )* )? '}' )?";
        }
    }
    static final String DFA15_eotS =
        "\17\uffff";
    static final String DFA15_eofS =
        "\17\uffff";
    static final String DFA15_minS =
        "\1\6\16\uffff";
    static final String DFA15_maxS =
        "\1\112\16\uffff";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\14\uffff\1\2";
    static final String DFA15_specialS =
        "\17\uffff}>";
    static final String[] DFA15_transitionS = {
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

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "397:3: ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' )";
        }
    }
    static final String DFA14_eotS =
        "\16\uffff";
    static final String DFA14_eofS =
        "\16\uffff";
    static final String DFA14_minS =
        "\1\6\15\uffff";
    static final String DFA14_maxS =
        "\1\112\15\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\1\2\13\uffff";
    static final String DFA14_specialS =
        "\16\uffff}>";
    static final String[] DFA14_transitionS = {
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

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "398:4: ( ':' parentClass= IDENTIFIER )?";
        }
    }
    static final String DFA18_eotS =
        "\15\uffff";
    static final String DFA18_eofS =
        "\15\uffff";
    static final String DFA18_minS =
        "\1\6\14\uffff";
    static final String DFA18_maxS =
        "\1\112\14\uffff";
    static final String DFA18_acceptS =
        "\1\uffff\1\1\1\2\12\uffff";
    static final String DFA18_specialS =
        "\15\uffff}>";
    static final String[] DFA18_transitionS = {
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
            return "408:3: ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )?";
        }
    }
    static final String DFA21_eotS =
        "\14\uffff";
    static final String DFA21_eofS =
        "\14\uffff";
    static final String DFA21_minS =
        "\1\6\13\uffff";
    static final String DFA21_maxS =
        "\1\112\13\uffff";
    static final String DFA21_acceptS =
        "\1\uffff\1\1\1\2\11\uffff";
    static final String DFA21_specialS =
        "\14\uffff}>";
    static final String[] DFA21_transitionS = {
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

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "417:3: ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )* '}' )?";
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
        "\1\uffff\1\5\1\1\1\2\1\3\1\4\5\uffff";
    static final String DFA20_specialS =
        "\13\uffff}>";
    static final String[] DFA20_transitionS = {
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
            return "()* loopback of 419:4: ( '@public' | '@private' | '@protected' | ( (fv= varDecl | functionPointerVarDecl ) ) )*";
        }
    }
    static final String DFA19_eotS =
        "\u010f\uffff";
    static final String DFA19_eofS =
        "\u010f\uffff";
    static final String DFA19_minS =
        "\4\6\1\100\2\6\1\4\1\6\1\100\6\6\1\66\1\uffff\1\6\1\uffff\5\6\1"+
        "\uffff\1\0\1\6\2\uffff\7\6\1\66\1\6\2\uffff\3\6\1\66\1\6\2\uffff"+
        "\16\0\1\uffff\14\0\3\uffff\7\0\1\uffff\2\0\1\uffff\5\0\2\uffff\10"+
        "\0\1\uffff\5\0\1\uffff\1\0\1\uffff\4\0\1\uffff\1\0\1\uffff\16\0"+
        "\2\uffff\21\0\1\uffff\1\0\2\uffff\2\0\1\uffff\2\0\1\uffff\3\0\16"+
        "\uffff\3\0\3\uffff\7\0\2\uffff\5\0\2\uffff\6\0\2\uffff\5\0\2\uffff"+
        "\1\0\7\uffff\4\0\1\uffff\1\0\1\uffff\4\0\1\uffff\1\0\1\uffff\3\0"+
        "\2\uffff\1\0\7\uffff\4\0\1\uffff\1\0\1\uffff\4\0\1\uffff\1\0\1\uffff"+
        "\3\0\2\uffff";
    static final String DFA19_maxS =
        "\2\112\1\27\1\72\2\112\1\72\1\131\3\112\1\72\1\27\3\72\1\66\1\uffff"+
        "\1\112\1\uffff\1\72\1\112\1\72\1\30\1\72\1\uffff\1\0\1\72\2\uffff"+
        "\1\112\1\72\1\112\4\72\1\66\1\72\2\uffff\3\72\1\66\1\72\2\uffff"+
        "\16\0\1\uffff\14\0\3\uffff\7\0\1\uffff\2\0\1\uffff\5\0\2\uffff\10"+
        "\0\1\uffff\5\0\1\uffff\1\0\1\uffff\4\0\1\uffff\1\0\1\uffff\16\0"+
        "\2\uffff\21\0\1\uffff\1\0\2\uffff\2\0\1\uffff\2\0\1\uffff\3\0\16"+
        "\uffff\3\0\3\uffff\7\0\2\uffff\5\0\2\uffff\6\0\2\uffff\5\0\2\uffff"+
        "\1\0\7\uffff\4\0\1\uffff\1\0\1\uffff\4\0\1\uffff\1\0\1\uffff\3\0"+
        "\2\uffff\1\0\7\uffff\4\0\1\uffff\1\0\1\uffff\4\0\1\uffff\1\0\1\uffff"+
        "\3\0\2\uffff";
    static final String DFA19_acceptS =
        "\21\uffff\1\1\1\uffff\1\2\u00fb\uffff";
    static final String DFA19_specialS =
        "\32\uffff\1\0\25\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
        "\1\13\1\14\1\15\1\16\1\uffff\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
        "\1\26\1\27\1\30\1\31\1\32\3\uffff\1\33\1\34\1\35\1\36\1\37\1\40"+
        "\1\41\1\uffff\1\42\1\43\1\uffff\1\44\1\45\1\46\1\47\1\50\2\uffff"+
        "\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\uffff\1\61\1\62\1\63"+
        "\1\64\1\65\1\uffff\1\66\1\uffff\1\67\1\70\1\71\1\72\1\uffff\1\73"+
        "\1\uffff\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1\104\1\105"+
        "\1\106\1\107\1\110\1\111\2\uffff\1\112\1\113\1\114\1\115\1\116\1"+
        "\117\1\120\1\121\1\122\1\123\1\124\1\125\1\126\1\127\1\130\1\131"+
        "\1\132\1\uffff\1\133\2\uffff\1\134\1\135\1\uffff\1\136\1\137\1\uffff"+
        "\1\140\1\141\1\142\16\uffff\1\143\1\144\1\145\3\uffff\1\146\1\147"+
        "\1\150\1\151\1\152\1\153\1\154\2\uffff\1\155\1\156\1\157\1\160\1"+
        "\161\2\uffff\1\162\1\163\1\164\1\165\1\166\1\167\2\uffff\1\170\1"+
        "\171\1\172\1\173\1\174\2\uffff\1\175\7\uffff\1\176\1\177\1\u0080"+
        "\1\u0081\1\uffff\1\u0082\1\uffff\1\u0083\1\u0084\1\u0085\1\u0086"+
        "\1\uffff\1\u0087\1\uffff\1\u0088\1\u0089\1\u008a\2\uffff\1\u008b"+
        "\7\uffff\1\u008c\1\u008d\1\u008e\1\u008f\1\uffff\1\u0090\1\uffff"+
        "\1\u0091\1\u0092\1\u0093\1\u0094\1\uffff\1\u0095\1\uffff\1\u0096"+
        "\1\u0097\1\u0098\2\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\1\27\uffff\1\3\16\uffff\3\2\14\uffff\4\4\2\5\11\6",
            "\1\10\25\uffff\1\23\1\uffff\1\15\3\uffff\1\7\1\uffff\1\22\10"+
            "\uffff\3\14\3\uffff\1\16\1\17\1\20\4\uffff\1\21\1\uffff\4\11"+
            "\2\12\11\13",
            "\1\24\20\uffff\1\25",
            "\1\26\20\uffff\1\27\4\uffff\1\32\5\uffff\1\21\20\uffff\1\30"+
            "\1\33\1\23\4\uffff\1\21",
            "\2\36\11\37",
            "\1\42\25\uffff\1\23\5\uffff\1\46\20\uffff\1\43\1\44\1\45\4"+
            "\uffff\1\21\5\uffff\2\40\11\41",
            "\1\51\25\uffff\1\23\5\uffff\1\55\20\uffff\1\52\1\53\1\54\4"+
            "\uffff\1\21",
            "\1\66\1\73\1\61\1\67\1\70\1\71\1\72\14\uffff\1\74\12\uffff"+
            "\1\65\20\uffff\1\75\1\21\1\63\1\uffff\1\60\2\uffff\1\21\20\uffff"+
            "\1\62\14\uffff\2\64",
            "\1\103\24\uffff\1\21\1\111\1\21\1\102\3\uffff\1\77\1\uffff"+
            "\1\112\10\uffff\3\101\3\uffff\1\100\1\107\1\110\4\uffff\1\21"+
            "\1\uffff\4\104\2\105\11\106",
            "\2\116\11\117",
            "\1\120\25\uffff\1\23\5\uffff\1\124\20\uffff\1\121\1\122\1\123"+
            "\4\uffff\1\21\5\uffff\2\126\11\127",
            "\1\131\25\uffff\1\23\5\uffff\1\135\20\uffff\1\132\1\133\1\134"+
            "\4\uffff\1\21",
            "\1\140\20\uffff\1\141",
            "\1\142\20\uffff\1\143\4\uffff\1\146\5\uffff\1\145\20\uffff"+
            "\1\144\1\147\1\151\4\uffff\1\21",
            "\1\152\25\uffff\1\23\5\uffff\1\154\20\uffff\1\153\1\155\1\157"+
            "\4\uffff\1\21",
            "\1\161\25\uffff\1\23\5\uffff\1\163\20\uffff\1\162\1\164\1\166"+
            "\4\uffff\1\21",
            "\1\170",
            "",
            "\1\173\27\uffff\1\172\6\uffff\1\177\7\uffff\3\171\14\uffff"+
            "\4\174\2\175\11\176",
            "",
            "\1\u0082\20\uffff\1\u0080\4\uffff\1\u0084\5\uffff\1\u0081\20"+
            "\uffff\1\u0083\1\u0085\1\23\4\uffff\1\21",
            "\1\u008b\21\uffff\1\u0095\1\u0094\1\u0093\3\uffff\1\u008d\2"+
            "\u0091\14\uffff\3\u008c\1\u0088\1\u0089\1\u008a\10\uffff\1\u0092"+
            "\4\u008e\2\u008f\11\u0090",
            "\1\u0098\20\uffff\1\u009e\3\uffff\1\21\1\u009d\1\21\4\uffff"+
            "\1\21\20\uffff\1\u0096\1\u0097\1\u009a\4\uffff\1\21",
            "\1\u00a0\21\uffff\1\u00a1",
            "\1\u00a3\25\uffff\1\23\5\uffff\1\21\20\uffff\1\u00a4\1\u00a5"+
            "\1\23\4\uffff\1\21",
            "",
            "\1\uffff",
            "\1\u00b4\25\uffff\1\23\5\uffff\1\21\20\uffff\1\u00b5\1\u00b6"+
            "\1\23\4\uffff\1\21",
            "",
            "",
            "\1\u00bc\25\uffff\1\23\5\uffff\1\u00c0\20\uffff\1\u00bd\1\u00be"+
            "\1\u00bf\4\uffff\1\21\5\uffff\2\u00ba\11\u00bb",
            "\1\u00c3\25\uffff\1\23\5\uffff\1\u00c7\20\uffff\1\u00c4\1\u00c5"+
            "\1\u00c6\4\uffff\1\21",
            "\1\u00cb\25\uffff\1\23\5\uffff\1\u00cf\20\uffff\1\u00cc\1\u00cd"+
            "\1\u00ce\4\uffff\1\21\5\uffff\13\u00ca",
            "\1\u00d2\25\uffff\1\23\5\uffff\1\u00d6\20\uffff\1\u00d3\1\u00d4"+
            "\1\u00d5\4\uffff\1\21",
            "\1\21\24\uffff\3\21\4\uffff\1\21\20\uffff\1\u00d9\2\21\4\uffff"+
            "\1\21",
            "\1\u00e1\25\uffff\1\23\5\uffff\1\u00e3\20\uffff\1\u00e2\1\u00e4"+
            "\1\u00e6\4\uffff\1\21",
            "\1\u00e8\25\uffff\1\23\5\uffff\1\u00ea\20\uffff\1\u00e9\1\u00eb"+
            "\1\u00ed\4\uffff\1\21",
            "\1\u00ef",
            "\1\u00f0\33\uffff\1\21\20\uffff\1\u00f1\1\21\5\uffff\1\21",
            "",
            "",
            "\1\21\24\uffff\3\21\4\uffff\1\21\20\uffff\1\u00f4\2\21\4\uffff"+
            "\1\21",
            "\1\u00fc\25\uffff\1\23\5\uffff\1\u00fe\20\uffff\1\u00fd\1\u00ff"+
            "\1\u0101\4\uffff\1\21",
            "\1\u0103\25\uffff\1\23\5\uffff\1\u0105\20\uffff\1\u0104\1\u0106"+
            "\1\u0108\4\uffff\1\21",
            "\1\u010a",
            "\1\u010b\33\uffff\1\21\20\uffff\1\u010c\1\21\5\uffff\1\21",
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
            "",
            "",
            "",
            "",
            "",
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
            "",
            "\1\uffff",
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
            "\1\uffff",
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
            return "424:6: (fv= varDecl | functionPointerVarDecl )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA19_26 = input.LA(1);

                         
                        int index19_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_26);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA19_48 = input.LA(1);

                         
                        int index19_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred29_ObjCpp()&&( "__success".equals(next()) ))) ) {s = 17;}

                        else if ( (( "__success".equals(next()) )) ) {s = 19;}

                         
                        input.seek(index19_48);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA19_49 = input.LA(1);

                         
                        int index19_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||(synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                         
                        input.seek(index19_49);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA19_50 = input.LA(1);

                         
                        int index19_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_50);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA19_51 = input.LA(1);

                         
                        int index19_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_51);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA19_52 = input.LA(1);

                         
                        int index19_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_52);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA19_53 = input.LA(1);

                         
                        int index19_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))||(synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_53);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA19_54 = input.LA(1);

                         
                        int index19_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_54);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA19_55 = input.LA(1);

                         
                        int index19_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_55);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA19_56 = input.LA(1);

                         
                        int index19_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_56);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA19_57 = input.LA(1);

                         
                        int index19_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_57);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA19_58 = input.LA(1);

                         
                        int index19_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_58);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA19_59 = input.LA(1);

                         
                        int index19_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_59);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA19_60 = input.LA(1);

                         
                        int index19_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_60);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA19_61 = input.LA(1);

                         
                        int index19_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 17;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index19_61);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA19_63 = input.LA(1);

                         
                        int index19_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_63);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA19_64 = input.LA(1);

                         
                        int index19_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 19;}

                         
                        input.seek(index19_64);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA19_65 = input.LA(1);

                         
                        int index19_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_65);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA19_66 = input.LA(1);

                         
                        int index19_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_66);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA19_67 = input.LA(1);

                         
                        int index19_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_67);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA19_68 = input.LA(1);

                         
                        int index19_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_68);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA19_69 = input.LA(1);

                         
                        int index19_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_69);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA19_70 = input.LA(1);

                         
                        int index19_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_70);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA19_71 = input.LA(1);

                         
                        int index19_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_71);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA19_72 = input.LA(1);

                         
                        int index19_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))||(synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_72);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA19_73 = input.LA(1);

                         
                        int index19_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_73);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA19_74 = input.LA(1);

                         
                        int index19_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_74);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA19_78 = input.LA(1);

                         
                        int index19_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_78);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA19_79 = input.LA(1);

                         
                        int index19_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_79);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA19_80 = input.LA(1);

                         
                        int index19_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_80);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA19_81 = input.LA(1);

                         
                        int index19_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_81);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA19_82 = input.LA(1);

                         
                        int index19_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_82);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA19_83 = input.LA(1);

                         
                        int index19_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_83);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA19_84 = input.LA(1);

                         
                        int index19_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_84);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA19_86 = input.LA(1);

                         
                        int index19_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_86);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA19_87 = input.LA(1);

                         
                        int index19_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_87);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA19_89 = input.LA(1);

                         
                        int index19_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_89);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA19_90 = input.LA(1);

                         
                        int index19_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_90);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA19_91 = input.LA(1);

                         
                        int index19_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_91);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA19_92 = input.LA(1);

                         
                        int index19_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_92);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA19_93 = input.LA(1);

                         
                        int index19_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( (((( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 19;}

                         
                        input.seek(index19_93);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA19_96 = input.LA(1);

                         
                        int index19_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 19;}

                         
                        input.seek(index19_96);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA19_97 = input.LA(1);

                         
                        int index19_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 19;}

                         
                        input.seek(index19_97);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA19_98 = input.LA(1);

                         
                        int index19_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 19;}

                         
                        input.seek(index19_98);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA19_99 = input.LA(1);

                         
                        int index19_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 19;}

                         
                        input.seek(index19_99);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA19_100 = input.LA(1);

                         
                        int index19_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 19;}

                         
                        input.seek(index19_100);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA19_101 = input.LA(1);

                         
                        int index19_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 19;}

                         
                        input.seek(index19_101);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA19_102 = input.LA(1);

                         
                        int index19_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 19;}

                         
                        input.seek(index19_102);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA19_103 = input.LA(1);

                         
                        int index19_103 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred29_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 17;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 19;}

                         
                        input.seek(index19_103);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA19_105 = input.LA(1);

                         
                        int index19_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred29_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 17;}

                        else if ( ((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))) ) {s = 19;}

                         
                        input.seek(index19_105);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA19_106 = input.LA(1);

                         
                        int index19_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 17;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index19_106);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA19_107 = input.LA(1);

                         
                        int index19_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 17;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index19_107);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA19_108 = input.LA(1);

                         
                        int index19_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 17;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index19_108);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA19_109 = input.LA(1);

                         
                        int index19_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 17;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index19_109);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA19_111 = input.LA(1);

                         
                        int index19_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 17;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index19_111);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA19_113 = input.LA(1);

                         
                        int index19_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 17;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index19_113);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA19_114 = input.LA(1);

                         
                        int index19_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 17;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index19_114);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA19_115 = input.LA(1);

                         
                        int index19_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 17;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index19_115);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA19_116 = input.LA(1);

                         
                        int index19_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 17;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index19_116);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA19_118 = input.LA(1);

                         
                        int index19_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 17;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index19_118);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA19_120 = input.LA(1);

                         
                        int index19_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 17;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index19_120);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA19_121 = input.LA(1);

                         
                        int index19_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 17;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index19_121);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA19_122 = input.LA(1);

                         
                        int index19_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 17;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index19_122);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA19_123 = input.LA(1);

                         
                        int index19_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 17;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index19_123);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA19_124 = input.LA(1);

                         
                        int index19_124 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 17;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index19_124);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA19_125 = input.LA(1);

                         
                        int index19_125 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 17;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index19_125);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA19_126 = input.LA(1);

                         
                        int index19_126 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 17;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index19_126);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA19_127 = input.LA(1);

                         
                        int index19_127 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred29_ObjCpp()&&( Modifier.parseModifier(next()) == null ))) ) {s = 17;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 19;}

                         
                        input.seek(index19_127);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA19_128 = input.LA(1);

                         
                        int index19_128 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_128);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA19_129 = input.LA(1);

                         
                        int index19_129 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_129);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA19_130 = input.LA(1);

                         
                        int index19_130 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_130);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA19_131 = input.LA(1);

                         
                        int index19_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_131);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA19_132 = input.LA(1);

                         
                        int index19_132 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_132);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA19_133 = input.LA(1);

                         
                        int index19_133 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_133);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA19_136 = input.LA(1);

                         
                        int index19_136 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_136);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA19_137 = input.LA(1);

                         
                        int index19_137 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_137);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA19_138 = input.LA(1);

                         
                        int index19_138 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_138);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA19_139 = input.LA(1);

                         
                        int index19_139 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_139);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA19_140 = input.LA(1);

                         
                        int index19_140 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_140);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA19_141 = input.LA(1);

                         
                        int index19_141 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_141);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA19_142 = input.LA(1);

                         
                        int index19_142 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_142);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA19_143 = input.LA(1);

                         
                        int index19_143 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_143);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA19_144 = input.LA(1);

                         
                        int index19_144 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_144);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA19_145 = input.LA(1);

                         
                        int index19_145 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_145);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA19_146 = input.LA(1);

                         
                        int index19_146 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_146);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA19_147 = input.LA(1);

                         
                        int index19_147 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_147);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA19_148 = input.LA(1);

                         
                        int index19_148 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_148);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA19_149 = input.LA(1);

                         
                        int index19_149 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_149);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA19_150 = input.LA(1);

                         
                        int index19_150 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_150);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA19_151 = input.LA(1);

                         
                        int index19_151 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_151);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA19_152 = input.LA(1);

                         
                        int index19_152 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_152);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA19_154 = input.LA(1);

                         
                        int index19_154 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_154);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA19_157 = input.LA(1);

                         
                        int index19_157 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_157);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA19_158 = input.LA(1);

                         
                        int index19_158 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_158);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA19_160 = input.LA(1);

                         
                        int index19_160 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_160);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA19_161 = input.LA(1);

                         
                        int index19_161 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_161);
                        if ( s>=0 ) return s;
                        break;
                    case 96 : 
                        int LA19_163 = input.LA(1);

                         
                        int index19_163 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_163);
                        if ( s>=0 ) return s;
                        break;
                    case 97 : 
                        int LA19_164 = input.LA(1);

                         
                        int index19_164 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_164);
                        if ( s>=0 ) return s;
                        break;
                    case 98 : 
                        int LA19_165 = input.LA(1);

                         
                        int index19_165 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_165);
                        if ( s>=0 ) return s;
                        break;
                    case 99 : 
                        int LA19_180 = input.LA(1);

                         
                        int index19_180 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_180);
                        if ( s>=0 ) return s;
                        break;
                    case 100 : 
                        int LA19_181 = input.LA(1);

                         
                        int index19_181 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_181);
                        if ( s>=0 ) return s;
                        break;
                    case 101 : 
                        int LA19_182 = input.LA(1);

                         
                        int index19_182 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_182);
                        if ( s>=0 ) return s;
                        break;
                    case 102 : 
                        int LA19_186 = input.LA(1);

                         
                        int index19_186 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_186);
                        if ( s>=0 ) return s;
                        break;
                    case 103 : 
                        int LA19_187 = input.LA(1);

                         
                        int index19_187 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_187);
                        if ( s>=0 ) return s;
                        break;
                    case 104 : 
                        int LA19_188 = input.LA(1);

                         
                        int index19_188 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_188);
                        if ( s>=0 ) return s;
                        break;
                    case 105 : 
                        int LA19_189 = input.LA(1);

                         
                        int index19_189 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_189);
                        if ( s>=0 ) return s;
                        break;
                    case 106 : 
                        int LA19_190 = input.LA(1);

                         
                        int index19_190 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_190);
                        if ( s>=0 ) return s;
                        break;
                    case 107 : 
                        int LA19_191 = input.LA(1);

                         
                        int index19_191 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_191);
                        if ( s>=0 ) return s;
                        break;
                    case 108 : 
                        int LA19_192 = input.LA(1);

                         
                        int index19_192 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_192);
                        if ( s>=0 ) return s;
                        break;
                    case 109 : 
                        int LA19_195 = input.LA(1);

                         
                        int index19_195 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_195);
                        if ( s>=0 ) return s;
                        break;
                    case 110 : 
                        int LA19_196 = input.LA(1);

                         
                        int index19_196 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_196);
                        if ( s>=0 ) return s;
                        break;
                    case 111 : 
                        int LA19_197 = input.LA(1);

                         
                        int index19_197 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_197);
                        if ( s>=0 ) return s;
                        break;
                    case 112 : 
                        int LA19_198 = input.LA(1);

                         
                        int index19_198 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_198);
                        if ( s>=0 ) return s;
                        break;
                    case 113 : 
                        int LA19_199 = input.LA(1);

                         
                        int index19_199 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_199);
                        if ( s>=0 ) return s;
                        break;
                    case 114 : 
                        int LA19_202 = input.LA(1);

                         
                        int index19_202 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_202);
                        if ( s>=0 ) return s;
                        break;
                    case 115 : 
                        int LA19_203 = input.LA(1);

                         
                        int index19_203 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_203);
                        if ( s>=0 ) return s;
                        break;
                    case 116 : 
                        int LA19_204 = input.LA(1);

                         
                        int index19_204 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_204);
                        if ( s>=0 ) return s;
                        break;
                    case 117 : 
                        int LA19_205 = input.LA(1);

                         
                        int index19_205 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_205);
                        if ( s>=0 ) return s;
                        break;
                    case 118 : 
                        int LA19_206 = input.LA(1);

                         
                        int index19_206 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_206);
                        if ( s>=0 ) return s;
                        break;
                    case 119 : 
                        int LA19_207 = input.LA(1);

                         
                        int index19_207 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_207);
                        if ( s>=0 ) return s;
                        break;
                    case 120 : 
                        int LA19_210 = input.LA(1);

                         
                        int index19_210 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_210);
                        if ( s>=0 ) return s;
                        break;
                    case 121 : 
                        int LA19_211 = input.LA(1);

                         
                        int index19_211 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_211);
                        if ( s>=0 ) return s;
                        break;
                    case 122 : 
                        int LA19_212 = input.LA(1);

                         
                        int index19_212 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_212);
                        if ( s>=0 ) return s;
                        break;
                    case 123 : 
                        int LA19_213 = input.LA(1);

                         
                        int index19_213 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_213);
                        if ( s>=0 ) return s;
                        break;
                    case 124 : 
                        int LA19_214 = input.LA(1);

                         
                        int index19_214 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_214);
                        if ( s>=0 ) return s;
                        break;
                    case 125 : 
                        int LA19_217 = input.LA(1);

                         
                        int index19_217 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_217);
                        if ( s>=0 ) return s;
                        break;
                    case 126 : 
                        int LA19_225 = input.LA(1);

                         
                        int index19_225 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_225);
                        if ( s>=0 ) return s;
                        break;
                    case 127 : 
                        int LA19_226 = input.LA(1);

                         
                        int index19_226 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_226);
                        if ( s>=0 ) return s;
                        break;
                    case 128 : 
                        int LA19_227 = input.LA(1);

                         
                        int index19_227 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_227);
                        if ( s>=0 ) return s;
                        break;
                    case 129 : 
                        int LA19_228 = input.LA(1);

                         
                        int index19_228 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_228);
                        if ( s>=0 ) return s;
                        break;
                    case 130 : 
                        int LA19_230 = input.LA(1);

                         
                        int index19_230 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_230);
                        if ( s>=0 ) return s;
                        break;
                    case 131 : 
                        int LA19_232 = input.LA(1);

                         
                        int index19_232 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_232);
                        if ( s>=0 ) return s;
                        break;
                    case 132 : 
                        int LA19_233 = input.LA(1);

                         
                        int index19_233 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_233);
                        if ( s>=0 ) return s;
                        break;
                    case 133 : 
                        int LA19_234 = input.LA(1);

                         
                        int index19_234 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_234);
                        if ( s>=0 ) return s;
                        break;
                    case 134 : 
                        int LA19_235 = input.LA(1);

                         
                        int index19_235 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_235);
                        if ( s>=0 ) return s;
                        break;
                    case 135 : 
                        int LA19_237 = input.LA(1);

                         
                        int index19_237 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_237);
                        if ( s>=0 ) return s;
                        break;
                    case 136 : 
                        int LA19_239 = input.LA(1);

                         
                        int index19_239 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_239);
                        if ( s>=0 ) return s;
                        break;
                    case 137 : 
                        int LA19_240 = input.LA(1);

                         
                        int index19_240 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_240);
                        if ( s>=0 ) return s;
                        break;
                    case 138 : 
                        int LA19_241 = input.LA(1);

                         
                        int index19_241 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_241);
                        if ( s>=0 ) return s;
                        break;
                    case 139 : 
                        int LA19_244 = input.LA(1);

                         
                        int index19_244 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_244);
                        if ( s>=0 ) return s;
                        break;
                    case 140 : 
                        int LA19_252 = input.LA(1);

                         
                        int index19_252 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_252);
                        if ( s>=0 ) return s;
                        break;
                    case 141 : 
                        int LA19_253 = input.LA(1);

                         
                        int index19_253 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_253);
                        if ( s>=0 ) return s;
                        break;
                    case 142 : 
                        int LA19_254 = input.LA(1);

                         
                        int index19_254 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_254);
                        if ( s>=0 ) return s;
                        break;
                    case 143 : 
                        int LA19_255 = input.LA(1);

                         
                        int index19_255 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_255);
                        if ( s>=0 ) return s;
                        break;
                    case 144 : 
                        int LA19_257 = input.LA(1);

                         
                        int index19_257 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_257);
                        if ( s>=0 ) return s;
                        break;
                    case 145 : 
                        int LA19_259 = input.LA(1);

                         
                        int index19_259 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_259);
                        if ( s>=0 ) return s;
                        break;
                    case 146 : 
                        int LA19_260 = input.LA(1);

                         
                        int index19_260 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_260);
                        if ( s>=0 ) return s;
                        break;
                    case 147 : 
                        int LA19_261 = input.LA(1);

                         
                        int index19_261 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_261);
                        if ( s>=0 ) return s;
                        break;
                    case 148 : 
                        int LA19_262 = input.LA(1);

                         
                        int index19_262 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_262);
                        if ( s>=0 ) return s;
                        break;
                    case 149 : 
                        int LA19_264 = input.LA(1);

                         
                        int index19_264 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_264);
                        if ( s>=0 ) return s;
                        break;
                    case 150 : 
                        int LA19_266 = input.LA(1);

                         
                        int index19_266 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_266);
                        if ( s>=0 ) return s;
                        break;
                    case 151 : 
                        int LA19_267 = input.LA(1);

                         
                        int index19_267 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_267);
                        if ( s>=0 ) return s;
                        break;
                    case 152 : 
                        int LA19_268 = input.LA(1);

                         
                        int index19_268 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index19_268);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 19, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA22_eotS =
        "\13\uffff";
    static final String DFA22_eofS =
        "\13\uffff";
    static final String DFA22_minS =
        "\1\6\12\uffff";
    static final String DFA22_maxS =
        "\1\112\12\uffff";
    static final String DFA22_acceptS =
        "\1\uffff\1\4\1\1\1\uffff\1\2\1\3\5\uffff";
    static final String DFA22_specialS =
        "\13\uffff}>";
    static final String[] DFA22_transitionS = {
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

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "()* loopback of 437:3: ( objCMethodDecl | typeDef | vd= varDecl {...}?)*";
        }
    }
    static final String DFA33_eotS =
        "\40\uffff";
    static final String DFA33_eofS =
        "\1\uffff\1\5\4\uffff\1\5\31\uffff";
    static final String DFA33_minS =
        "\2\6\1\uffff\1\6\2\uffff\1\6\11\uffff\1\0\6\uffff\1\0\4\uffff\1"+
        "\0\3\uffff";
    static final String DFA33_maxS =
        "\1\27\1\72\1\uffff\1\72\2\uffff\1\72\11\uffff\1\0\6\uffff\1\0\4"+
        "\uffff\1\0\3\uffff";
    static final String DFA33_acceptS =
        "\2\uffff\1\2\2\uffff\1\1\32\uffff";
    static final String DFA33_specialS =
        "\20\uffff\1\0\6\uffff\1\1\4\uffff\1\2\3\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\1\20\uffff\1\2",
            "\1\6\20\uffff\1\2\3\uffff\3\5\4\uffff\1\3\1\5\1\uffff\1\5\15"+
            "\uffff\3\5\4\uffff\1\5",
            "",
            "\1\20\33\uffff\1\5\1\2\17\uffff\2\5\5\uffff\1\5",
            "",
            "",
            "\1\34\20\uffff\1\2\3\uffff\3\5\4\uffff\1\27\1\5\17\uffff\3"+
            "\5\4\uffff\1\5",
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
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "528:3: ( (n0= IDENTIFIER ) | ( ( exportationModifiers )? n1= IDENTIFIER )? '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA33_16 = input.LA(1);

                         
                        int index33_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_ObjCpp()) ) {s = 5;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index33_16);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA33_23 = input.LA(1);

                         
                        int index33_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_ObjCpp()) ) {s = 5;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index33_23);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA33_28 = input.LA(1);

                         
                        int index33_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred43_ObjCpp()) ) {s = 5;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index33_28);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 33, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA32_eotS =
        "\17\uffff";
    static final String DFA32_eofS =
        "\17\uffff";
    static final String DFA32_minS =
        "\1\6\16\uffff";
    static final String DFA32_maxS =
        "\1\112\16\uffff";
    static final String DFA32_acceptS =
        "\1\uffff\1\3\1\1\2\uffff\1\2\11\uffff";
    static final String DFA32_specialS =
        "\17\uffff}>";
    static final String[] DFA32_transitionS = {
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
            return "()* loopback of 542:5: ( ( 'public' | 'private' | 'protected' ) ':' | declaration )*";
        }
    }
    static final String DFA34_eotS =
        "\23\uffff";
    static final String DFA34_eofS =
        "\23\uffff";
    static final String DFA34_minS =
        "\1\6\2\uffff\1\0\17\uffff";
    static final String DFA34_maxS =
        "\1\112\2\uffff\1\0\17\uffff";
    static final String DFA34_acceptS =
        "\1\uffff\1\1\20\uffff\1\2";
    static final String DFA34_specialS =
        "\3\uffff\1\0\17\uffff}>";
    static final String[] DFA34_transitionS = {
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
            return "578:16: (returnTypeRef= typeRef )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA34_3 = input.LA(1);

                         
                        int index34_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred50_ObjCpp()&&( Modifier.parseModifier(next()) == null ))||((synpred50_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))||(synpred50_ObjCpp()&&( "__success".equals(next()) ))||((synpred50_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))||((synpred50_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))||((synpred50_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null )))) ) {s = 1;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index34_3);
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
    static final String DFA37_eotS =
        "\32\uffff";
    static final String DFA37_eofS =
        "\1\2\31\uffff";
    static final String DFA37_minS =
        "\1\6\1\0\30\uffff";
    static final String DFA37_maxS =
        "\1\112\1\0\30\uffff";
    static final String DFA37_acceptS =
        "\2\uffff\1\2\26\uffff\1\1";
    static final String DFA37_specialS =
        "\1\uffff\1\0\30\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\1\20\uffff\1\2\4\uffff\1\2\1\uffff\1\2\16\uffff\3\2\3\uffff"+
            "\1\2\10\uffff\17\2",
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
            ""
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "()* loopback of 609:3: ( exportationModifier )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA37_1 = input.LA(1);

                         
                        int index37_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_ObjCpp()) ) {s = 25;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index37_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 37, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA38_eotS =
        "\15\uffff";
    static final String DFA38_eofS =
        "\1\uffff\1\3\13\uffff";
    static final String DFA38_minS =
        "\2\6\13\uffff";
    static final String DFA38_maxS =
        "\1\6\1\112\13\uffff";
    static final String DFA38_acceptS =
        "\2\uffff\1\2\1\1\11\uffff";
    static final String DFA38_specialS =
        "\15\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\1",
            "\1\3\20\uffff\1\3\4\uffff\1\3\1\uffff\1\3\3\uffff\1\2\12\uffff"+
            "\3\3\3\uffff\1\3\10\uffff\17\3",
            "",
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
            return "632:3: ({...}? modifier | IDENTIFIER {...}? '(' extendedModifiers ')' )";
        }
    }
    static final String DFA40_eotS =
        "\31\uffff";
    static final String DFA40_eofS =
        "\31\uffff";
    static final String DFA40_minS =
        "\1\6\2\uffff\1\0\25\uffff";
    static final String DFA40_maxS =
        "\1\112\2\uffff\1\0\25\uffff";
    static final String DFA40_acceptS =
        "\1\uffff\1\3\25\uffff\1\1\1\2";
    static final String DFA40_specialS =
        "\3\uffff\1\0\25\uffff}>";
    static final String[] DFA40_transitionS = {
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

    static final short[] DFA40_eot = DFA.unpackEncodedString(DFA40_eotS);
    static final short[] DFA40_eof = DFA.unpackEncodedString(DFA40_eofS);
    static final char[] DFA40_min = DFA.unpackEncodedStringToUnsignedChars(DFA40_minS);
    static final char[] DFA40_max = DFA.unpackEncodedStringToUnsignedChars(DFA40_maxS);
    static final short[] DFA40_accept = DFA.unpackEncodedString(DFA40_acceptS);
    static final short[] DFA40_special = DFA.unpackEncodedString(DFA40_specialS);
    static final short[][] DFA40_transition;

    static {
        int numStates = DFA40_transitionS.length;
        DFA40_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA40_transition[i] = DFA.unpackEncodedString(DFA40_transitionS[i]);
        }
    }

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = DFA40_eot;
            this.eof = DFA40_eof;
            this.min = DFA40_min;
            this.max = DFA40_max;
            this.accept = DFA40_accept;
            this.special = DFA40_special;
            this.transition = DFA40_transition;
        }
        public String getDescription() {
            return "()* loopback of 669:3: ({...}?sm= modifier | {...}?tm= modifier )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA40_3 = input.LA(1);

                         
                        int index40_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred56_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 23;}

                        else if ( (((synpred57_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 24;}

                        else if ( ((( "__success".equals(next()) )||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 1;}

                         
                        input.seek(index40_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 40, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA45_eotS =
        "\50\uffff";
    static final String DFA45_eofS =
        "\1\uffff\1\2\46\uffff";
    static final String DFA45_minS =
        "\2\6\3\uffff\1\4\22\uffff\1\0\1\uffff\13\0\3\uffff";
    static final String DFA45_maxS =
        "\2\112\3\uffff\1\131\22\uffff\1\0\1\uffff\13\0\3\uffff";
    static final String DFA45_acceptS =
        "\2\uffff\1\4\24\uffff\1\1\16\uffff\1\2\1\3";
    static final String DFA45_specialS =
        "\30\uffff\1\0\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
        "\1\13\3\uffff}>";
    static final String[] DFA45_transitionS = {
            "\1\1\65\uffff\17\2",
            "\1\2\24\uffff\4\2\3\uffff\1\5\3\2\7\uffff\3\2\3\uffff\3\2\4"+
            "\uffff\1\2\1\uffff\17\2",
            "",
            "",
            "",
            "\1\36\1\43\1\30\1\37\1\40\1\41\1\42\14\uffff\1\44\12\uffff"+
            "\1\32\20\uffff\2\2\1\34\1\uffff\1\27\2\uffff\1\2\20\uffff\1"+
            "\33\14\uffff\2\35",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "758:3: ({...}? IDENTIFIER '(' 'return' binaryOp expression ')' | {...}?m1a= modifier '(' expression ')' | {...}?m2a= modifier '(' expression ',' expression ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA45_24 = input.LA(1);

                         
                        int index45_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred65_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred66_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 2;}

                         
                        input.seek(index45_24);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA45_26 = input.LA(1);

                         
                        int index45_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred65_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred66_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 2;}

                         
                        input.seek(index45_26);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA45_27 = input.LA(1);

                         
                        int index45_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred65_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred66_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index45_27);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA45_28 = input.LA(1);

                         
                        int index45_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred65_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred66_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index45_28);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA45_29 = input.LA(1);

                         
                        int index45_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred65_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred66_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index45_29);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA45_30 = input.LA(1);

                         
                        int index45_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred65_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred66_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index45_30);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA45_31 = input.LA(1);

                         
                        int index45_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred65_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred66_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index45_31);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA45_32 = input.LA(1);

                         
                        int index45_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred65_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred66_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index45_32);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA45_33 = input.LA(1);

                         
                        int index45_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred65_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred66_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index45_33);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA45_34 = input.LA(1);

                         
                        int index45_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred65_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred66_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index45_34);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA45_35 = input.LA(1);

                         
                        int index45_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred65_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred66_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index45_35);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA45_36 = input.LA(1);

                         
                        int index45_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred65_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 38;}

                        else if ( (((synpred66_ObjCpp()&&( next(Modifier.Kind.VCAnnotation2Args) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 39;}

                         
                        input.seek(index45_36);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 45, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA46_eotS =
        "\30\uffff";
    static final String DFA46_eofS =
        "\30\uffff";
    static final String DFA46_minS =
        "\1\6\1\0\26\uffff";
    static final String DFA46_maxS =
        "\1\112\1\0\26\uffff";
    static final String DFA46_acceptS =
        "\2\uffff\1\2\24\uffff\1\1";
    static final String DFA46_specialS =
        "\1\uffff\1\0\26\uffff}>";
    static final String[] DFA46_transitionS = {
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
            return "765:3: ({...}?m= modifier )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA46_1 = input.LA(1);

                         
                        int index46_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred67_ObjCpp()&&( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 23;}

                        else if ( (((( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 2;}

                         
                        input.seek(index46_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 46, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA51_eotS =
        "\51\uffff";
    static final String DFA51_eofS =
        "\1\uffff\1\2\47\uffff";
    static final String DFA51_minS =
        "\2\6\3\uffff\1\0\43\uffff";
    static final String DFA51_maxS =
        "\2\112\3\uffff\1\0\43\uffff";
    static final String DFA51_acceptS =
        "\2\uffff\1\2\17\uffff\1\1\26\uffff";
    static final String DFA51_specialS =
        "\5\uffff\1\0\43\uffff}>";
    static final String[] DFA51_transitionS = {
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

    static final short[] DFA51_eot = DFA.unpackEncodedString(DFA51_eotS);
    static final short[] DFA51_eof = DFA.unpackEncodedString(DFA51_eofS);
    static final char[] DFA51_min = DFA.unpackEncodedStringToUnsignedChars(DFA51_minS);
    static final char[] DFA51_max = DFA.unpackEncodedStringToUnsignedChars(DFA51_maxS);
    static final short[] DFA51_accept = DFA.unpackEncodedString(DFA51_acceptS);
    static final short[] DFA51_special = DFA.unpackEncodedString(DFA51_specialS);
    static final short[][] DFA51_transition;

    static {
        int numStates = DFA51_transitionS.length;
        DFA51_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA51_transition[i] = DFA.unpackEncodedString(DFA51_transitionS[i]);
        }
    }

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = DFA51_eot;
            this.eof = DFA51_eof;
            this.min = DFA51_min;
            this.max = DFA51_max;
            this.accept = DFA51_accept;
            this.special = DFA51_special;
            this.transition = DFA51_transition;
        }
        public String getDescription() {
            return "766:3: ({...}?m1= modifier tr= typeRef | ( primitiveTypeRef | {...}?ref= IDENTIFIER ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA51_5 = input.LA(1);

                         
                        int index51_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred68_ObjCpp()&&( next(Modifier.Kind.ReferenceQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 18;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 2;}

                         
                        input.seek(index51_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 51, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA49_eotS =
        "\16\uffff";
    static final String DFA49_eofS =
        "\1\1\15\uffff";
    static final String DFA49_minS =
        "\1\6\15\uffff";
    static final String DFA49_maxS =
        "\1\72\15\uffff";
    static final String DFA49_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA49_specialS =
        "\16\uffff}>";
    static final String[] DFA49_transitionS = {
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
            return "772:64: ( | '<' (t1= typeRef ( ',' tx= typeRef )* )? '>' )";
        }
    }
    static final String DFA63_eotS =
        "\65\uffff";
    static final String DFA63_eofS =
        "\1\6\64\uffff";
    static final String DFA63_minS =
        "\1\6\5\0\57\uffff";
    static final String DFA63_maxS =
        "\1\72\5\0\57\uffff";
    static final String DFA63_acceptS =
        "\6\uffff\1\2\20\uffff\1\1\35\uffff";
    static final String DFA63_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\57\uffff}>";
    static final String[] DFA63_transitionS = {
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
            return "851:3: ( ( typeMutator )* functionSignatureSuffix )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA63_1 = input.LA(1);

                         
                        int index63_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred85_ObjCpp()&&( next("const", "__const") ))) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA63_2 = input.LA(1);

                         
                        int index63_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA63_3 = input.LA(1);

                         
                        int index63_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA63_4 = input.LA(1);

                         
                        int index63_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA63_5 = input.LA(1);

                         
                        int index63_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index63_5);
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
        "\140\uffff";
    static final String DFA65_eofS =
        "\140\uffff";
    static final String DFA65_minS =
        "\4\6\1\uffff\1\6\1\uffff\1\6\7\uffff\4\6\2\uffff\4\6\2\uffff\2\6"+
        "\2\uffff\4\0\2\uffff\2\0\2\uffff\1\0\7\uffff\4\0\2\uffff\4\0\2\uffff"+
        "\2\0\2\uffff\1\0\7\uffff\4\0\2\uffff\4\0\2\uffff\3\0\10\uffff";
    static final String DFA65_maxS =
        "\4\72\1\uffff\1\72\1\uffff\1\72\7\uffff\4\72\2\uffff\4\72\2\uffff"+
        "\2\72\2\uffff\4\0\2\uffff\2\0\2\uffff\1\0\7\uffff\4\0\2\uffff\4"+
        "\0\2\uffff\2\0\2\uffff\1\0\7\uffff\4\0\2\uffff\4\0\2\uffff\3\0\10"+
        "\uffff";
    static final String DFA65_acceptS =
        "\4\uffff\1\1\1\uffff\1\2\131\uffff";
    static final String DFA65_specialS =
        "\37\uffff\1\0\1\1\1\2\1\3\2\uffff\1\4\1\5\2\uffff\1\6\7\uffff\1"+
        "\7\1\10\1\11\1\12\2\uffff\1\13\1\14\1\15\1\16\2\uffff\1\17\1\20"+
        "\2\uffff\1\21\7\uffff\1\22\1\23\1\24\1\25\2\uffff\1\26\1\27\1\30"+
        "\1\31\2\uffff\1\32\1\33\1\34\10\uffff}>";
    static final String[] DFA65_transitionS = {
            "\1\1\33\uffff\1\5\20\uffff\1\2\1\3\1\4\4\uffff\1\6",
            "\1\6\24\uffff\3\6\4\uffff\1\6\20\uffff\1\7\2\6\4\uffff\1\6",
            "\1\20\33\uffff\1\17\20\uffff\1\21\1\22\1\4\4\uffff\1\6",
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
            "\1\45\33\uffff\1\6\20\uffff\1\46\1\6\5\uffff\1\6",
            "\1\6\24\uffff\3\6\4\uffff\1\6\20\uffff\1\51\2\6\4\uffff\1\6",
            "\1\62\33\uffff\1\61\20\uffff\1\63\1\64\1\4\4\uffff\1\6",
            "\1\70\33\uffff\1\67\20\uffff\1\71\1\72\1\4\4\uffff\1\6",
            "",
            "",
            "\1\75\33\uffff\1\6\20\uffff\1\76\1\6\5\uffff\1\6",
            "\1\6\24\uffff\3\6\4\uffff\1\6\20\uffff\1\101\2\6\4\uffff\1"+
            "\6",
            "\1\112\33\uffff\1\111\20\uffff\1\113\1\114\1\4\4\uffff\1\6",
            "\1\120\33\uffff\1\117\20\uffff\1\121\1\122\1\4\4\uffff\1\6",
            "",
            "",
            "\1\125\26\uffff\1\6\4\uffff\1\127\1\6\17\uffff\1\126\2\6\4"+
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
            return "866:3: ( ( typeMutator )* functionSignatureSuffixNoName )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA65_31 = input.LA(1);

                         
                        int index65_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred87_ObjCpp()&&( next("const", "__const") ))) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_31);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA65_32 = input.LA(1);

                         
                        int index65_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred87_ObjCpp()&&( next("const", "__const") ))) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_32);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA65_33 = input.LA(1);

                         
                        int index65_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred87_ObjCpp()&&( next("const", "__const") ))) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_33);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA65_34 = input.LA(1);

                         
                        int index65_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred87_ObjCpp()&&( next("const", "__const") ))) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_34);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA65_37 = input.LA(1);

                         
                        int index65_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_37);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA65_38 = input.LA(1);

                         
                        int index65_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_38);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA65_41 = input.LA(1);

                         
                        int index65_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_41);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA65_49 = input.LA(1);

                         
                        int index65_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_49);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA65_50 = input.LA(1);

                         
                        int index65_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_50);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA65_51 = input.LA(1);

                         
                        int index65_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_51);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA65_52 = input.LA(1);

                         
                        int index65_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_52);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA65_55 = input.LA(1);

                         
                        int index65_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_55);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA65_56 = input.LA(1);

                         
                        int index65_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_56);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA65_57 = input.LA(1);

                         
                        int index65_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_57);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA65_58 = input.LA(1);

                         
                        int index65_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_58);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA65_61 = input.LA(1);

                         
                        int index65_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_61);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA65_62 = input.LA(1);

                         
                        int index65_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_62);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA65_65 = input.LA(1);

                         
                        int index65_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_65);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA65_73 = input.LA(1);

                         
                        int index65_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_73);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA65_74 = input.LA(1);

                         
                        int index65_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_74);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA65_75 = input.LA(1);

                         
                        int index65_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_75);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA65_76 = input.LA(1);

                         
                        int index65_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_76);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA65_79 = input.LA(1);

                         
                        int index65_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_79);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA65_80 = input.LA(1);

                         
                        int index65_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_80);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA65_81 = input.LA(1);

                         
                        int index65_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_81);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA65_82 = input.LA(1);

                         
                        int index65_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_82);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA65_85 = input.LA(1);

                         
                        int index65_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_85);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA65_86 = input.LA(1);

                         
                        int index65_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_86);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA65_87 = input.LA(1);

                         
                        int index65_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index65_87);
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
        "\27\uffff";
    static final String DFA67_eofS =
        "\2\uffff\1\1\24\uffff";
    static final String DFA67_minS =
        "\1\6\1\uffff\1\6\2\uffff\1\6\7\uffff\1\0\11\uffff";
    static final String DFA67_maxS =
        "\1\72\1\uffff\1\72\2\uffff\1\112\7\uffff\1\0\11\uffff";
    static final String DFA67_acceptS =
        "\1\uffff\1\2\11\uffff\1\1\13\uffff";
    static final String DFA67_specialS =
        "\15\uffff\1\0\11\uffff}>";
    static final String[] DFA67_transitionS = {
            "\1\2\33\uffff\1\1\20\uffff\2\1\5\uffff\1\1",
            "",
            "\1\13\24\uffff\3\1\4\uffff\1\5\1\1\17\uffff\2\13\1\1\4\uffff"+
            "\1\13",
            "",
            "",
            "\1\15\27\uffff\1\1\3\uffff\1\13\1\1\10\uffff\4\1\3\uffff\2"+
            "\13\5\uffff\1\13\1\uffff\17\1",
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
            return "()* loopback of 887:3: ({...}? modifier )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA67_13 = input.LA(1);

                         
                        int index67_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred89_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index67_13);
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
        "\23\uffff";
    static final String DFA69_eofS =
        "\1\2\22\uffff";
    static final String DFA69_minS =
        "\1\33\1\0\21\uffff";
    static final String DFA69_maxS =
        "\1\43\1\0\21\uffff";
    static final String DFA69_acceptS =
        "\2\uffff\1\2\17\uffff\1\1";
    static final String DFA69_specialS =
        "\1\uffff\1\0\21\uffff}>";
    static final String[] DFA69_transitionS = {
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
            return "907:4: ( '=' expression )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA69_1 = input.LA(1);

                         
                        int index69_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_ObjCpp()) ) {s = 18;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index69_1);
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
    static final String DFA71_eotS =
        "\25\uffff";
    static final String DFA71_eofS =
        "\25\uffff";
    static final String DFA71_minS =
        "\1\6\2\uffff\1\0\21\uffff";
    static final String DFA71_maxS =
        "\1\112\2\uffff\1\0\21\uffff";
    static final String DFA71_acceptS =
        "\1\uffff\1\3\21\uffff\1\1\1\2";
    static final String DFA71_specialS =
        "\3\uffff\1\0\21\uffff}>";
    static final String[] DFA71_transitionS = {
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
            return "()* loopback of 949:4: ({...}?sm= modifier | {...}?tm= modifier )*";
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
                        if ( (((synpred95_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 19;}

                        else if ( (((synpred96_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 20;}

                        else if ( ((( "__success".equals(next()) )||(( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.ReferenceQualifier) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.TypeQualifier, Modifier.Kind.VCAnnotationNoArg) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 1;}

                         
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
    static final String DFA76_eotS =
        "\13\uffff";
    static final String DFA76_eofS =
        "\13\uffff";
    static final String DFA76_minS =
        "\1\6\1\0\11\uffff";
    static final String DFA76_maxS =
        "\1\72\1\0\11\uffff";
    static final String DFA76_acceptS =
        "\2\uffff\1\2\7\uffff\1\1";
    static final String DFA76_specialS =
        "\1\uffff\1\0\11\uffff}>";
    static final String[] DFA76_transitionS = {
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
            return "()* loopback of 1039:4: (im= modifier )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA76_1 = input.LA(1);

                         
                        int index76_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred102_ObjCpp()&&( Modifier.parseModifier(next()) != null ))) ) {s = 10;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index76_1);
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
    static final String DFA78_eotS =
        "\16\uffff";
    static final String DFA78_eofS =
        "\16\uffff";
    static final String DFA78_minS =
        "\1\4\15\uffff";
    static final String DFA78_maxS =
        "\1\131\15\uffff";
    static final String DFA78_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA78_specialS =
        "\16\uffff}>";
    static final String[] DFA78_transitionS = {
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
            return "1051:4: ( expression | )";
        }
    }
    static final String DFA80_eotS =
        "\14\uffff";
    static final String DFA80_eofS =
        "\14\uffff";
    static final String DFA80_minS =
        "\1\33\1\6\1\uffff\1\0\10\uffff";
    static final String DFA80_maxS =
        "\1\43\1\112\1\uffff\1\0\10\uffff";
    static final String DFA80_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\7\uffff";
    static final String DFA80_specialS =
        "\3\uffff\1\0\10\uffff}>";
    static final String[] DFA80_transitionS = {
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
            return "()* loopback of 1079:4: ( ',' ax= argDef )*";
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
                        if ( (synpred106_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index80_3);
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
        "\61\uffff";
    static final String DFA83_eofS =
        "\1\1\60\uffff";
    static final String DFA83_minS =
        "\1\6\2\uffff\2\0\4\uffff\1\0\1\uffff\1\0\45\uffff";
    static final String DFA83_maxS =
        "\1\72\2\uffff\2\0\4\uffff\1\0\1\uffff\1\0\45\uffff";
    static final String DFA83_acceptS =
        "\1\uffff\1\2\25\uffff\1\1\31\uffff";
    static final String DFA83_specialS =
        "\3\uffff\1\0\1\1\4\uffff\1\2\1\uffff\1\3\45\uffff}>";
    static final String[] DFA83_transitionS = {
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
            return "()* loopback of 1100:3: ( typeMutator )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA83_3 = input.LA(1);

                         
                        int index83_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred109_ObjCpp()&&( next("const", "__const") ))) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index83_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA83_4 = input.LA(1);

                         
                        int index83_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred109_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index83_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA83_9 = input.LA(1);

                         
                        int index83_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred109_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index83_9);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA83_11 = input.LA(1);

                         
                        int index83_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred109_ObjCpp()) ) {s = 23;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index83_11);
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
        "\21\uffff";
    static final String DFA86_eofS =
        "\1\uffff\1\2\17\uffff";
    static final String DFA86_minS =
        "\1\100\1\6\17\uffff";
    static final String DFA86_maxS =
        "\2\112\17\uffff";
    static final String DFA86_acceptS =
        "\2\uffff\1\2\14\uffff\1\1\1\uffff";
    static final String DFA86_specialS =
        "\21\uffff}>";
    static final String[] DFA86_transitionS = {
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
            return "1133:4: (mod2= primSizeModifier (mod3= primSizeModifier )? )?";
        }
    }
    static final String DFA85_eotS =
        "\20\uffff";
    static final String DFA85_eofS =
        "\1\uffff\1\2\16\uffff";
    static final String DFA85_minS =
        "\1\100\1\6\16\uffff";
    static final String DFA85_maxS =
        "\2\112\16\uffff";
    static final String DFA85_acceptS =
        "\2\uffff\1\2\14\uffff\1\1";
    static final String DFA85_specialS =
        "\20\uffff}>";
    static final String[] DFA85_transitionS = {
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
            ""
    };

    static final short[] DFA85_eot = DFA.unpackEncodedString(DFA85_eotS);
    static final short[] DFA85_eof = DFA.unpackEncodedString(DFA85_eofS);
    static final char[] DFA85_min = DFA.unpackEncodedStringToUnsignedChars(DFA85_minS);
    static final char[] DFA85_max = DFA.unpackEncodedStringToUnsignedChars(DFA85_maxS);
    static final short[] DFA85_accept = DFA.unpackEncodedString(DFA85_acceptS);
    static final short[] DFA85_special = DFA.unpackEncodedString(DFA85_specialS);
    static final short[][] DFA85_transition;

    static {
        int numStates = DFA85_transitionS.length;
        DFA85_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA85_transition[i] = DFA.unpackEncodedString(DFA85_transitionS[i]);
        }
    }

    class DFA85 extends DFA {

        public DFA85(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 85;
            this.eot = DFA85_eot;
            this.eof = DFA85_eof;
            this.min = DFA85_min;
            this.max = DFA85_max;
            this.accept = DFA85_accept;
            this.special = DFA85_special;
            this.transition = DFA85_transition;
        }
        public String getDescription() {
            return "1134:8: (mod3= primSizeModifier )?";
        }
    }
    static final String DFA90_eotS =
        "\16\uffff";
    static final String DFA90_eofS =
        "\16\uffff";
    static final String DFA90_minS =
        "\1\4\15\uffff";
    static final String DFA90_maxS =
        "\1\131\15\uffff";
    static final String DFA90_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA90_specialS =
        "\16\uffff}>";
    static final String[] DFA90_transitionS = {
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
            return "1203:3: (a1= expression ( ',' ax= expression )* )?";
        }
    }
    static final String DFA93_eotS =
        "\33\uffff";
    static final String DFA93_eofS =
        "\1\uffff\1\16\31\uffff";
    static final String DFA93_minS =
        "\1\4\1\6\31\uffff";
    static final String DFA93_maxS =
        "\1\131\1\133\31\uffff";
    static final String DFA93_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\5\uffff\1\7\1\uffff\1\1\14\uffff";
    static final String DFA93_specialS =
        "\33\uffff}>";
    static final String[] DFA93_transitionS = {
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
            return "1221:4: (id= IDENTIFIER | fc1= functionCall | objCMethodCall | prefixOp= ( '!' | '~' ) opd= expression | '(' (par= expression ')' | typeRef ')' casted= expression ) | constant | '{' expression '}' )";
        }
    }
    static final String DFA92_eotS =
        "\173\uffff";
    static final String DFA92_eofS =
        "\32\uffff\1\2\140\uffff";
    static final String DFA92_minS =
        "\1\4\1\6\20\uffff\1\4\4\uffff\2\4\1\uffff\2\4\11\uffff\14\0\3\uffff"+
        "\1\0\2\uffff\1\0\2\uffff\1\0\7\uffff\2\0\2\uffff\1\0\26\uffff\1"+
        "\0\15\uffff\1\0\17\uffff";
    static final String DFA92_maxS =
        "\1\131\1\133\20\uffff\1\131\4\uffff\2\131\1\uffff\1\133\1\131\11"+
        "\uffff\14\0\3\uffff\1\0\2\uffff\1\0\2\uffff\1\0\7\uffff\2\0\2\uffff"+
        "\1\0\26\uffff\1\0\15\uffff\1\0\17\uffff";
    static final String DFA92_acceptS =
        "\2\uffff\1\1\12\uffff\1\2\155\uffff";
    static final String DFA92_specialS =
        "\45\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\3"+
        "\uffff\1\14\2\uffff\1\15\2\uffff\1\16\7\uffff\1\17\1\20\2\uffff"+
        "\1\21\26\uffff\1\22\15\uffff\1\23\17\uffff}>";
    static final String[] DFA92_transitionS = {
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
            "\1\52\1\57\1\45\1\53\1\54\1\55\1\56\14\uffff\1\60\12\uffff"+
            "\1\51\1\2\17\uffff\1\15\1\uffff\1\47\1\uffff\1\15\23\uffff\1"+
            "\46\14\uffff\2\50",
            "",
            "",
            "",
            "",
            "\2\2\1\64\4\2\14\uffff\1\2\12\uffff\1\72\1\15\17\uffff\2\15"+
            "\1\67\25\uffff\1\2\14\uffff\2\2",
            "\2\2\1\103\4\2\14\uffff\1\2\12\uffff\1\102\1\15\17\uffff\2"+
            "\15\1\106\25\uffff\1\2\14\uffff\2\2",
            "",
            "\2\15\1\135\4\15\14\uffff\1\15\1\2\2\uffff\3\2\3\uffff\1\2"+
            "\1\15\3\2\4\uffff\2\2\7\uffff\2\2\1\15\1\2\3\uffff\1\2\20\uffff"+
            "\1\15\14\2\2\15\2\2",
            "\2\2\1\153\4\2\14\uffff\1\2\6\uffff\1\15\3\uffff\1\2\2\uffff"+
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
            "\1\uffff",
            "\1\uffff",
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
            "",
            "",
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
            return "1234:8: (par= expression ')' | typeRef ')' casted= expression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA92_37 = input.LA(1);

                         
                        int index92_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null ))||( Modifier.parseModifier(next()) == null ))) ) {s = 13;}

                         
                        input.seek(index92_37);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA92_38 = input.LA(1);

                         
                        int index92_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index92_38);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA92_39 = input.LA(1);

                         
                        int index92_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index92_39);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA92_40 = input.LA(1);

                         
                        int index92_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index92_40);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA92_41 = input.LA(1);

                         
                        int index92_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index92_41);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA92_42 = input.LA(1);

                         
                        int index92_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index92_42);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA92_43 = input.LA(1);

                         
                        int index92_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index92_43);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA92_44 = input.LA(1);

                         
                        int index92_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index92_44);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA92_45 = input.LA(1);

                         
                        int index92_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index92_45);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA92_46 = input.LA(1);

                         
                        int index92_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index92_46);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA92_47 = input.LA(1);

                         
                        int index92_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index92_47);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA92_48 = input.LA(1);

                         
                        int index92_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (((( next(Modifier.Kind.VCAnnotation1Arg) )&&( Modifier.parseModifier(next()) != null ))||(( next(Modifier.Kind.VCAnnotation2Args) )&&( Modifier.parseModifier(next()) != null )))) ) {s = 13;}

                         
                        input.seek(index92_48);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA92_52 = input.LA(1);

                         
                        int index92_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index92_52);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA92_55 = input.LA(1);

                         
                        int index92_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index92_55);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA92_58 = input.LA(1);

                         
                        int index92_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index92_58);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA92_66 = input.LA(1);

                         
                        int index92_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index92_66);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA92_67 = input.LA(1);

                         
                        int index92_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index92_67);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA92_70 = input.LA(1);

                         
                        int index92_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index92_70);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA92_93 = input.LA(1);

                         
                        int index92_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index92_93);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA92_107 = input.LA(1);

                         
                        int index92_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_ObjCpp()) ) {s = 2;}

                        else if ( (( Modifier.parseModifier(next()) == null )) ) {s = 13;}

                         
                        input.seek(index92_107);
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
    static final String DFA95_eotS =
        "\146\uffff";
    static final String DFA95_eofS =
        "\1\1\145\uffff";
    static final String DFA95_minS =
        "\1\6\5\uffff\1\0\2\uffff\5\0\130\uffff";
    static final String DFA95_maxS =
        "\1\133\5\uffff\1\0\2\uffff\5\0\130\uffff";
    static final String DFA95_acceptS =
        "\1\uffff\1\6\30\uffff\1\2\15\uffff\1\1\1\4\2\uffff\1\3\70\uffff"+
        "\1\5";
    static final String DFA95_specialS =
        "\6\uffff\1\0\2\uffff\1\1\1\2\1\3\1\4\1\5\130\uffff}>";
    static final String[] DFA95_transitionS = {
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
            return "()* loopback of 1247:3: (bop= binaryOp opd2= expression | '=' val= expression | '.' fieldName= IDENTIFIER | refStyle= ( ':' ':' | '-' '>' | '.' ) fc2= functionCall | '?' xif= expression ':' xelse= expression )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA95_6 = input.LA(1);

                         
                        int index95_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred159_ObjCpp()) ) {s = 26;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index95_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA95_9 = input.LA(1);

                         
                        int index95_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 40;}

                        else if ( (synpred163_ObjCpp()) ) {s = 41;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index95_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA95_10 = input.LA(1);

                         
                        int index95_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_ObjCpp()) ) {s = 44;}

                        else if ( (synpred163_ObjCpp()) ) {s = 41;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index95_10);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA95_11 = input.LA(1);

                         
                        int index95_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_ObjCpp()) ) {s = 41;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index95_11);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA95_12 = input.LA(1);

                         
                        int index95_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred158_ObjCpp()) ) {s = 40;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index95_12);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA95_13 = input.LA(1);

                         
                        int index95_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_ObjCpp()) ) {s = 101;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index95_13);
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
        "\36\uffff";
    static final String DFA96_eofS =
        "\36\uffff";
    static final String DFA96_minS =
        "\1\4\35\uffff";
    static final String DFA96_maxS =
        "\1\141\35\uffff";
    static final String DFA96_acceptS =
        "\1\uffff\1\2\1\1\33\uffff";
    static final String DFA96_specialS =
        "\36\uffff}>";
    static final String[] DFA96_transitionS = {
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
            return "()* loopback of 1273:8: ( statement )*";
        }
    }
    static final String DFA103_eotS =
        "\u012e\uffff";
    static final String DFA103_eofS =
        "\u012e\uffff";
    static final String DFA103_minS =
        "\2\4\1\5\32\uffff\1\4\1\5\11\uffff\1\42\3\4\6\30\10\uffff\1\4\13"+
        "\uffff\1\4\2\uffff\2\4\1\uffff\1\4\1\uffff\14\0\21\uffff\1\0\5\uffff"+
        "\6\0\3\uffff\2\0\1\uffff\2\0\1\uffff\60\0\2\uffff\6\0\2\uffff\6"+
        "\0\2\uffff\6\0\2\uffff\6\0\2\uffff\6\0\3\uffff\15\0\2\uffff\5\0"+
        "\1\uffff\1\0\1\uffff\1\0\2\uffff\1\0\11\uffff\2\0\2\uffff\1\0\12"+
        "\uffff\1\0\1\uffff\1\0\14\uffff\1\0\20\uffff";
    static final String DFA103_maxS =
        "\2\141\1\133\32\uffff\1\141\1\133\11\uffff\1\42\3\131\6\133\10\uffff"+
        "\1\131\13\uffff\1\131\2\uffff\2\131\1\uffff\1\131\1\uffff\14\0\21"+
        "\uffff\1\0\5\uffff\6\0\3\uffff\2\0\1\uffff\2\0\1\uffff\60\0\2\uffff"+
        "\6\0\2\uffff\6\0\2\uffff\6\0\2\uffff\6\0\2\uffff\6\0\3\uffff\15"+
        "\0\2\uffff\5\0\1\uffff\1\0\1\uffff\1\0\2\uffff\1\0\11\uffff\2\0"+
        "\2\uffff\1\0\12\uffff\1\0\1\uffff\1\0\14\uffff\1\0\20\uffff";
    static final String DFA103_acceptS =
        "\3\uffff\1\2\10\uffff\1\3\11\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
        "\2\uffff\1\1\u010d\uffff\1\13";
    static final String DFA103_specialS =
        "\116\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\21"+
        "\uffff\1\14\5\uffff\1\15\1\16\1\17\1\20\1\21\1\22\3\uffff\1\23\1"+
        "\24\1\uffff\1\25\1\26\1\uffff\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
        "\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52"+
        "\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67"+
        "\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103"+
        "\1\104\1\105\1\106\2\uffff\1\107\1\110\1\111\1\112\1\113\1\114\2"+
        "\uffff\1\115\1\116\1\117\1\120\1\121\1\122\2\uffff\1\123\1\124\1"+
        "\125\1\126\1\127\1\130\2\uffff\1\131\1\132\1\133\1\134\1\135\1\136"+
        "\2\uffff\1\137\1\140\1\141\1\142\1\143\1\144\3\uffff\1\145\1\146"+
        "\1\147\1\150\1\151\1\152\1\153\1\154\1\155\1\156\1\157\1\160\1\161"+
        "\2\uffff\1\162\1\163\1\164\1\165\1\166\1\uffff\1\167\1\uffff\1\170"+
        "\2\uffff\1\171\11\uffff\1\172\1\173\2\uffff\1\174\12\uffff\1\175"+
        "\1\uffff\1\176\14\uffff\1\177\20\uffff}>";
    static final String[] DFA103_transitionS = {
            "\2\14\1\2\4\14\14\uffff\1\1\1\uffff\2\3\1\uffff\1\34\1\uffff"+
            "\3\3\1\uffff\1\14\12\uffff\3\3\5\uffff\1\14\1\uffff\1\26\3\uffff"+
            "\20\3\1\14\14\uffff\2\14\2\uffff\1\27\1\uffff\1\30\1\31\1\32"+
            "\1\33",
            "\1\54\1\61\1\36\1\55\1\56\1\57\1\60\14\uffff\1\35\3\37\1\uffff"+
            "\1\37\1\uffff\3\37\1\uffff\1\53\12\uffff\3\37\5\uffff\1\51\1"+
            "\uffff\1\37\3\uffff\20\37\1\50\14\uffff\2\52\2\uffff\1\37\1"+
            "\uffff\4\37",
            "\2\3\25\uffff\2\14\1\3\2\uffff\1\14\1\72\1\uffff\1\114\1\14"+
            "\4\uffff\2\14\1\uffff\3\3\3\uffff\1\106\1\111\1\3\4\uffff\1"+
            "\112\1\uffff\17\3\1\uffff\14\14\2\uffff\2\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\123\1\130\1\116\1\124\1\125\1\126\1\127\14\uffff\1\131\3"+
            "\37\1\uffff\1\37\1\uffff\3\37\1\uffff\1\122\12\uffff\3\37\5"+
            "\uffff\1\120\1\uffff\1\37\3\uffff\20\37\1\117\14\uffff\2\121"+
            "\2\uffff\1\37\1\uffff\4\37",
            "\2\37\21\uffff\1\14\3\uffff\1\37\1\162\1\37\2\uffff\1\164\1"+
            "\153\1\uffff\1\173\1\176\4\uffff\1\176\1\161\1\uffff\3\37\3"+
            "\uffff\1\165\1\172\1\37\4\uffff\1\175\1\uffff\17\37\1\uffff"+
            "\14\176\2\uffff\1\163\1\166",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0080",
            "\1\u0086\1\u008b\1\u0081\1\u0087\1\u0088\1\u0089\1\u008a\14"+
            "\uffff\1\u008c\12\uffff\1\u0085\22\uffff\1\u0083\25\uffff\1"+
            "\u0082\14\uffff\2\u0084",
            "\1\u0092\1\u0097\1\u008d\1\u0093\1\u0094\1\u0095\1\u0096\14"+
            "\uffff\1\u0098\12\uffff\1\u0091\22\uffff\1\u008f\25\uffff\1"+
            "\u008e\14\uffff\2\u0090",
            "\1\u009e\1\u00a3\1\u0099\1\u009f\1\u00a0\1\u00a1\1\u00a2\14"+
            "\uffff\1\u00a4\6\uffff\1\u00a6\3\uffff\1\u009d\12\uffff\3\u00a5"+
            "\5\uffff\1\u009b\6\uffff\4\u00a7\2\u00a8\11\u00a9\1\u009a\14"+
            "\uffff\2\u009c",
            "\1\14\3\uffff\1\37\1\u00ab\3\uffff\1\u00ad\2\uffff\2\u00ae"+
            "\4\uffff\1\u00ae\1\u00aa\7\uffff\2\u00ae\5\uffff\1\u00ae\21"+
            "\uffff\14\u00ae\2\uffff\1\u00ac\1\u00af",
            "\1\14\3\uffff\1\37\1\u00b3\3\uffff\1\u00b5\2\uffff\2\u00b6"+
            "\4\uffff\1\u00b6\1\u00b2\7\uffff\2\u00b6\5\uffff\1\u00b6\21"+
            "\uffff\14\u00b6\2\uffff\1\u00b4\1\u00b7",
            "\1\14\3\uffff\1\37\1\u00bb\3\uffff\1\u00bd\2\uffff\2\u00be"+
            "\4\uffff\1\u00be\1\u00ba\7\uffff\2\u00be\5\uffff\1\u00be\21"+
            "\uffff\14\u00be\2\uffff\1\u00bc\1\u00bf",
            "\1\14\3\uffff\1\37\1\u00c3\3\uffff\1\u00c5\2\uffff\2\u00c6"+
            "\4\uffff\1\u00c6\1\u00c2\7\uffff\2\u00c6\5\uffff\1\u00c6\21"+
            "\uffff\14\u00c6\2\uffff\1\u00c4\1\u00c7",
            "\1\14\3\uffff\1\37\1\u00cb\3\uffff\1\u00cd\2\uffff\2\u00ce"+
            "\4\uffff\1\u00ce\1\u00ca\7\uffff\2\u00ce\5\uffff\1\u00ce\21"+
            "\uffff\14\u00ce\2\uffff\1\u00cc\1\u00cf",
            "\1\14\3\uffff\1\37\1\u00d3\3\uffff\1\u00d5\2\uffff\2\u00d6"+
            "\4\uffff\1\u00d6\1\u00d2\7\uffff\2\u00d6\5\uffff\1\u00d6\21"+
            "\uffff\14\u00d6\2\uffff\1\u00d4\1\u00d7",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00e0\1\u00e5\1\u00db\1\u00e1\1\u00e2\1\u00e3\1\u00e4\14"+
            "\uffff\1\u00e6\6\uffff\1\u00eb\3\uffff\1\u00df\1\u00e7\10\uffff"+
            "\1\3\3\u00ea\3\uffff\2\3\1\u00dd\1\uffff\1\3\2\uffff\1\3\1\uffff"+
            "\4\u00ec\2\u00ed\11\u00ee\1\u00dc\14\uffff\2\u00de",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\2\14\1\u00f0\4\14\14\uffff\1\14\12\uffff\1\u00f2\20\uffff"+
            "\2\3\1\u00f5\4\uffff\1\3\20\uffff\1\14\14\uffff\2\14",
            "",
            "",
            "\2\14\1\u0100\4\14\14\uffff\1\14\12\uffff\1\u00ff\20\uffff"+
            "\2\3\1\u0103\4\uffff\1\3\20\uffff\1\14\14\uffff\2\14",
            "\2\14\1\u010e\4\14\14\uffff\1\14\12\uffff\1\u0110\20\uffff"+
            "\2\3\1\14\4\uffff\1\3\20\uffff\1\14\14\uffff\2\14",
            "",
            "\2\14\1\u011d\4\14\14\uffff\1\14\6\uffff\1\3\3\uffff\1\14\2"+
            "\uffff\1\3\7\uffff\3\3\5\uffff\1\14\6\uffff\17\3\1\14\14\uffff"+
            "\2\14",
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
            "",
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
            ""
    };

    static final short[] DFA103_eot = DFA.unpackEncodedString(DFA103_eotS);
    static final short[] DFA103_eof = DFA.unpackEncodedString(DFA103_eofS);
    static final char[] DFA103_min = DFA.unpackEncodedStringToUnsignedChars(DFA103_minS);
    static final char[] DFA103_max = DFA.unpackEncodedStringToUnsignedChars(DFA103_maxS);
    static final short[] DFA103_accept = DFA.unpackEncodedString(DFA103_acceptS);
    static final short[] DFA103_special = DFA.unpackEncodedString(DFA103_specialS);
    static final short[][] DFA103_transition;

    static {
        int numStates = DFA103_transitionS.length;
        DFA103_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA103_transition[i] = DFA.unpackEncodedString(DFA103_transitionS[i]);
        }
    }

    class DFA103 extends DFA {

        public DFA103(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 103;
            this.eot = DFA103_eot;
            this.eof = DFA103_eof;
            this.min = DFA103_min;
            this.max = DFA103_max;
            this.accept = DFA103_accept;
            this.special = DFA103_special;
            this.transition = DFA103_transition;
        }
        public String getDescription() {
            return "1275:1: statement : ( statementsBlock | declaration | expression ( '=' expression )? ';' | 'return' expression ';' | 'if' '(' expression ')' statement ( 'else' statement )? | 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA103_78 = input.LA(1);

                         
                        int index103_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_78);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA103_79 = input.LA(1);

                         
                        int index103_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_79);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA103_80 = input.LA(1);

                         
                        int index103_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_80);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA103_81 = input.LA(1);

                         
                        int index103_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_81);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA103_82 = input.LA(1);

                         
                        int index103_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_82);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA103_83 = input.LA(1);

                         
                        int index103_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_83);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA103_84 = input.LA(1);

                         
                        int index103_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_84);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA103_85 = input.LA(1);

                         
                        int index103_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_85);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA103_86 = input.LA(1);

                         
                        int index103_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_86);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA103_87 = input.LA(1);

                         
                        int index103_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_87);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA103_88 = input.LA(1);

                         
                        int index103_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_88);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA103_89 = input.LA(1);

                         
                        int index103_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_89);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA103_107 = input.LA(1);

                         
                        int index103_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_107);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA103_113 = input.LA(1);

                         
                        int index103_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_113);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA103_114 = input.LA(1);

                         
                        int index103_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_114);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA103_115 = input.LA(1);

                         
                        int index103_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_115);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA103_116 = input.LA(1);

                         
                        int index103_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_116);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA103_117 = input.LA(1);

                         
                        int index103_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_117);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA103_118 = input.LA(1);

                         
                        int index103_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_118);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA103_122 = input.LA(1);

                         
                        int index103_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_122);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA103_123 = input.LA(1);

                         
                        int index103_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_123);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA103_125 = input.LA(1);

                         
                        int index103_125 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_125);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA103_126 = input.LA(1);

                         
                        int index103_126 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_126);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA103_128 = input.LA(1);

                         
                        int index103_128 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_128);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA103_129 = input.LA(1);

                         
                        int index103_129 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_129);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA103_130 = input.LA(1);

                         
                        int index103_130 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_130);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA103_131 = input.LA(1);

                         
                        int index103_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_131);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA103_132 = input.LA(1);

                         
                        int index103_132 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_132);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA103_133 = input.LA(1);

                         
                        int index103_133 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_133);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA103_134 = input.LA(1);

                         
                        int index103_134 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_134);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA103_135 = input.LA(1);

                         
                        int index103_135 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_135);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA103_136 = input.LA(1);

                         
                        int index103_136 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_136);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA103_137 = input.LA(1);

                         
                        int index103_137 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_137);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA103_138 = input.LA(1);

                         
                        int index103_138 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_138);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA103_139 = input.LA(1);

                         
                        int index103_139 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_139);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA103_140 = input.LA(1);

                         
                        int index103_140 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_140);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA103_141 = input.LA(1);

                         
                        int index103_141 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_141);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA103_142 = input.LA(1);

                         
                        int index103_142 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_142);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA103_143 = input.LA(1);

                         
                        int index103_143 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_143);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA103_144 = input.LA(1);

                         
                        int index103_144 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_144);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA103_145 = input.LA(1);

                         
                        int index103_145 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_145);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA103_146 = input.LA(1);

                         
                        int index103_146 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_146);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA103_147 = input.LA(1);

                         
                        int index103_147 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_147);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA103_148 = input.LA(1);

                         
                        int index103_148 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_148);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA103_149 = input.LA(1);

                         
                        int index103_149 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_149);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA103_150 = input.LA(1);

                         
                        int index103_150 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_150);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA103_151 = input.LA(1);

                         
                        int index103_151 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_151);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA103_152 = input.LA(1);

                         
                        int index103_152 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_152);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA103_153 = input.LA(1);

                         
                        int index103_153 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_153);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA103_154 = input.LA(1);

                         
                        int index103_154 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_154);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA103_155 = input.LA(1);

                         
                        int index103_155 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_155);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA103_156 = input.LA(1);

                         
                        int index103_156 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_156);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA103_157 = input.LA(1);

                         
                        int index103_157 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_157);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA103_158 = input.LA(1);

                         
                        int index103_158 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_158);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA103_159 = input.LA(1);

                         
                        int index103_159 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_159);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA103_160 = input.LA(1);

                         
                        int index103_160 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_160);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA103_161 = input.LA(1);

                         
                        int index103_161 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_161);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA103_162 = input.LA(1);

                         
                        int index103_162 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_162);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA103_163 = input.LA(1);

                         
                        int index103_163 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_163);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA103_164 = input.LA(1);

                         
                        int index103_164 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_164);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA103_165 = input.LA(1);

                         
                        int index103_165 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_165);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA103_166 = input.LA(1);

                         
                        int index103_166 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_166);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA103_167 = input.LA(1);

                         
                        int index103_167 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_167);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA103_168 = input.LA(1);

                         
                        int index103_168 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_168);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA103_169 = input.LA(1);

                         
                        int index103_169 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_169);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA103_170 = input.LA(1);

                         
                        int index103_170 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_170);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA103_171 = input.LA(1);

                         
                        int index103_171 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_171);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA103_172 = input.LA(1);

                         
                        int index103_172 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_172);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA103_173 = input.LA(1);

                         
                        int index103_173 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_173);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA103_174 = input.LA(1);

                         
                        int index103_174 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_174);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA103_175 = input.LA(1);

                         
                        int index103_175 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_175);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA103_178 = input.LA(1);

                         
                        int index103_178 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_178);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA103_179 = input.LA(1);

                         
                        int index103_179 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_179);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA103_180 = input.LA(1);

                         
                        int index103_180 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_180);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA103_181 = input.LA(1);

                         
                        int index103_181 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_181);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA103_182 = input.LA(1);

                         
                        int index103_182 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_182);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA103_183 = input.LA(1);

                         
                        int index103_183 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_183);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA103_186 = input.LA(1);

                         
                        int index103_186 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_186);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA103_187 = input.LA(1);

                         
                        int index103_187 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_187);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA103_188 = input.LA(1);

                         
                        int index103_188 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_188);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA103_189 = input.LA(1);

                         
                        int index103_189 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_189);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA103_190 = input.LA(1);

                         
                        int index103_190 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_190);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA103_191 = input.LA(1);

                         
                        int index103_191 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_191);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA103_194 = input.LA(1);

                         
                        int index103_194 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_194);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA103_195 = input.LA(1);

                         
                        int index103_195 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_195);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA103_196 = input.LA(1);

                         
                        int index103_196 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_196);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA103_197 = input.LA(1);

                         
                        int index103_197 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_197);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA103_198 = input.LA(1);

                         
                        int index103_198 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_198);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA103_199 = input.LA(1);

                         
                        int index103_199 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_199);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA103_202 = input.LA(1);

                         
                        int index103_202 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_202);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA103_203 = input.LA(1);

                         
                        int index103_203 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_203);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA103_204 = input.LA(1);

                         
                        int index103_204 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_204);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA103_205 = input.LA(1);

                         
                        int index103_205 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_205);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA103_206 = input.LA(1);

                         
                        int index103_206 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_206);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA103_207 = input.LA(1);

                         
                        int index103_207 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_207);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA103_210 = input.LA(1);

                         
                        int index103_210 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_210);
                        if ( s>=0 ) return s;
                        break;
                    case 96 : 
                        int LA103_211 = input.LA(1);

                         
                        int index103_211 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_211);
                        if ( s>=0 ) return s;
                        break;
                    case 97 : 
                        int LA103_212 = input.LA(1);

                         
                        int index103_212 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_212);
                        if ( s>=0 ) return s;
                        break;
                    case 98 : 
                        int LA103_213 = input.LA(1);

                         
                        int index103_213 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_213);
                        if ( s>=0 ) return s;
                        break;
                    case 99 : 
                        int LA103_214 = input.LA(1);

                         
                        int index103_214 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_214);
                        if ( s>=0 ) return s;
                        break;
                    case 100 : 
                        int LA103_215 = input.LA(1);

                         
                        int index103_215 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred166_ObjCpp()) ) {s = 31;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_215);
                        if ( s>=0 ) return s;
                        break;
                    case 101 : 
                        int LA103_219 = input.LA(1);

                         
                        int index103_219 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                        else if ( (( next("foreach") )) ) {s = 301;}

                         
                        input.seek(index103_219);
                        if ( s>=0 ) return s;
                        break;
                    case 102 : 
                        int LA103_220 = input.LA(1);

                         
                        int index103_220 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_220);
                        if ( s>=0 ) return s;
                        break;
                    case 103 : 
                        int LA103_221 = input.LA(1);

                         
                        int index103_221 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_221);
                        if ( s>=0 ) return s;
                        break;
                    case 104 : 
                        int LA103_222 = input.LA(1);

                         
                        int index103_222 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_222);
                        if ( s>=0 ) return s;
                        break;
                    case 105 : 
                        int LA103_223 = input.LA(1);

                         
                        int index103_223 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_223);
                        if ( s>=0 ) return s;
                        break;
                    case 106 : 
                        int LA103_224 = input.LA(1);

                         
                        int index103_224 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_224);
                        if ( s>=0 ) return s;
                        break;
                    case 107 : 
                        int LA103_225 = input.LA(1);

                         
                        int index103_225 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_225);
                        if ( s>=0 ) return s;
                        break;
                    case 108 : 
                        int LA103_226 = input.LA(1);

                         
                        int index103_226 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_226);
                        if ( s>=0 ) return s;
                        break;
                    case 109 : 
                        int LA103_227 = input.LA(1);

                         
                        int index103_227 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_227);
                        if ( s>=0 ) return s;
                        break;
                    case 110 : 
                        int LA103_228 = input.LA(1);

                         
                        int index103_228 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_228);
                        if ( s>=0 ) return s;
                        break;
                    case 111 : 
                        int LA103_229 = input.LA(1);

                         
                        int index103_229 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_229);
                        if ( s>=0 ) return s;
                        break;
                    case 112 : 
                        int LA103_230 = input.LA(1);

                         
                        int index103_230 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_230);
                        if ( s>=0 ) return s;
                        break;
                    case 113 : 
                        int LA103_231 = input.LA(1);

                         
                        int index103_231 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_231);
                        if ( s>=0 ) return s;
                        break;
                    case 114 : 
                        int LA103_234 = input.LA(1);

                         
                        int index103_234 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (( next("foreach") )) ) {s = 301;}

                         
                        input.seek(index103_234);
                        if ( s>=0 ) return s;
                        break;
                    case 115 : 
                        int LA103_235 = input.LA(1);

                         
                        int index103_235 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (( next("foreach") )) ) {s = 301;}

                         
                        input.seek(index103_235);
                        if ( s>=0 ) return s;
                        break;
                    case 116 : 
                        int LA103_236 = input.LA(1);

                         
                        int index103_236 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (( next("foreach") )) ) {s = 301;}

                         
                        input.seek(index103_236);
                        if ( s>=0 ) return s;
                        break;
                    case 117 : 
                        int LA103_237 = input.LA(1);

                         
                        int index103_237 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (( next("foreach") )) ) {s = 301;}

                         
                        input.seek(index103_237);
                        if ( s>=0 ) return s;
                        break;
                    case 118 : 
                        int LA103_238 = input.LA(1);

                         
                        int index103_238 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (( next("foreach") )) ) {s = 301;}

                         
                        input.seek(index103_238);
                        if ( s>=0 ) return s;
                        break;
                    case 119 : 
                        int LA103_240 = input.LA(1);

                         
                        int index103_240 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_240);
                        if ( s>=0 ) return s;
                        break;
                    case 120 : 
                        int LA103_242 = input.LA(1);

                         
                        int index103_242 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_242);
                        if ( s>=0 ) return s;
                        break;
                    case 121 : 
                        int LA103_245 = input.LA(1);

                         
                        int index103_245 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_245);
                        if ( s>=0 ) return s;
                        break;
                    case 122 : 
                        int LA103_255 = input.LA(1);

                         
                        int index103_255 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_255);
                        if ( s>=0 ) return s;
                        break;
                    case 123 : 
                        int LA103_256 = input.LA(1);

                         
                        int index103_256 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_256);
                        if ( s>=0 ) return s;
                        break;
                    case 124 : 
                        int LA103_259 = input.LA(1);

                         
                        int index103_259 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_259);
                        if ( s>=0 ) return s;
                        break;
                    case 125 : 
                        int LA103_270 = input.LA(1);

                         
                        int index103_270 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_270);
                        if ( s>=0 ) return s;
                        break;
                    case 126 : 
                        int LA103_272 = input.LA(1);

                         
                        int index103_272 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_272);
                        if ( s>=0 ) return s;
                        break;
                    case 127 : 
                        int LA103_285 = input.LA(1);

                         
                        int index103_285 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred167_ObjCpp()) ) {s = 3;}

                        else if ( (synpred169_ObjCpp()) ) {s = 12;}

                         
                        input.seek(index103_285);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 103, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA98_eotS =
        "\77\uffff";
    static final String DFA98_eofS =
        "\1\2\76\uffff";
    static final String DFA98_minS =
        "\1\4\1\0\75\uffff";
    static final String DFA98_maxS =
        "\1\142\1\0\75\uffff";
    static final String DFA98_acceptS =
        "\2\uffff\1\2\73\uffff\1\1";
    static final String DFA98_specialS =
        "\1\uffff\1\0\75\uffff}>";
    static final String[] DFA98_transitionS = {
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
            return "1281:37: ( 'else' statement )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA98_1 = input.LA(1);

                         
                        int index98_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred171_ObjCpp()) ) {s = 62;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index98_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 98, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA99_eotS =
        "\107\uffff";
    static final String DFA99_eofS =
        "\107\uffff";
    static final String DFA99_minS =
        "\1\4\33\uffff\2\4\14\uffff\2\0\11\uffff\12\0\6\uffff\1\0\1\uffff";
    static final String DFA99_maxS =
        "\1\141\33\uffff\1\131\1\141\14\uffff\2\0\11\uffff\12\0\6\uffff\1"+
        "\0\1\uffff";
    static final String DFA99_acceptS =
        "\1\uffff\1\1\34\uffff\1\2\50\uffff";
    static final String DFA99_specialS =
        "\52\uffff\1\0\1\1\11\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
        "\1\13\6\uffff\1\14\1\uffff}>";
    static final String[] DFA99_transitionS = {
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
            "\7\36\14\uffff\1\36\4\uffff\1\35\5\uffff\1\36\22\uffff\1\36"+
            "\25\uffff\1\36\14\uffff\2\36",
            "\1\71\1\76\1\53\1\72\1\73\1\74\1\75\14\uffff\1\52\1\uffff\2"+
            "\36\1\uffff\1\105\1\uffff\3\36\1\uffff\1\70\1\36\11\uffff\3"+
            "\36\5\uffff\1\66\1\uffff\1\36\3\uffff\20\36\1\65\14\uffff\2"+
            "\67\2\uffff\1\36\1\uffff\4\36",
            "",
            "",
            "",
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
            return "1284:13: ( statement )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA99_42 = input.LA(1);

                         
                        int index99_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred175_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index99_42);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA99_43 = input.LA(1);

                         
                        int index99_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred175_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index99_43);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA99_53 = input.LA(1);

                         
                        int index99_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred175_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index99_53);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA99_54 = input.LA(1);

                         
                        int index99_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred175_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index99_54);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA99_55 = input.LA(1);

                         
                        int index99_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred175_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index99_55);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA99_56 = input.LA(1);

                         
                        int index99_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred175_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index99_56);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA99_57 = input.LA(1);

                         
                        int index99_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred175_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index99_57);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA99_58 = input.LA(1);

                         
                        int index99_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred175_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index99_58);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA99_59 = input.LA(1);

                         
                        int index99_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred175_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index99_59);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA99_60 = input.LA(1);

                         
                        int index99_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred175_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index99_60);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA99_61 = input.LA(1);

                         
                        int index99_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred175_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index99_61);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA99_62 = input.LA(1);

                         
                        int index99_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred175_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index99_62);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA99_69 = input.LA(1);

                         
                        int index99_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred175_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 30;}

                         
                        input.seek(index99_69);
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
    static final String DFA100_eotS =
        "\16\uffff";
    static final String DFA100_eofS =
        "\16\uffff";
    static final String DFA100_minS =
        "\1\4\15\uffff";
    static final String DFA100_maxS =
        "\1\131\15\uffff";
    static final String DFA100_acceptS =
        "\1\uffff\1\1\13\uffff\1\2";
    static final String DFA100_specialS =
        "\16\uffff}>";
    static final String[] DFA100_transitionS = {
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
            return "1284:28: ( expression )?";
        }
    }
    static final String DFA101_eotS =
        "\36\uffff";
    static final String DFA101_eofS =
        "\36\uffff";
    static final String DFA101_minS =
        "\1\4\35\uffff";
    static final String DFA101_maxS =
        "\1\141\35\uffff";
    static final String DFA101_acceptS =
        "\1\uffff\1\1\33\uffff\1\2";
    static final String DFA101_specialS =
        "\36\uffff}>";
    static final String[] DFA101_transitionS = {
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
            return "1284:44: ( statement )?";
        }
    }
    static final String DFA102_eotS =
        "\37\uffff";
    static final String DFA102_eofS =
        "\37\uffff";
    static final String DFA102_minS =
        "\1\4\36\uffff";
    static final String DFA102_maxS =
        "\1\142\36\uffff";
    static final String DFA102_acceptS =
        "\1\uffff\1\3\1\1\1\2\33\uffff";
    static final String DFA102_specialS =
        "\37\uffff}>";
    static final String[] DFA102_transitionS = {
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

    static final short[] DFA102_eot = DFA.unpackEncodedString(DFA102_eotS);
    static final short[] DFA102_eof = DFA.unpackEncodedString(DFA102_eofS);
    static final char[] DFA102_min = DFA.unpackEncodedStringToUnsignedChars(DFA102_minS);
    static final char[] DFA102_max = DFA.unpackEncodedStringToUnsignedChars(DFA102_maxS);
    static final short[] DFA102_accept = DFA.unpackEncodedString(DFA102_acceptS);
    static final short[] DFA102_special = DFA.unpackEncodedString(DFA102_specialS);
    static final short[][] DFA102_transition;

    static {
        int numStates = DFA102_transitionS.length;
        DFA102_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA102_transition[i] = DFA.unpackEncodedString(DFA102_transitionS[i]);
        }
    }

    class DFA102 extends DFA {

        public DFA102(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 102;
            this.eot = DFA102_eot;
            this.eof = DFA102_eof;
            this.min = DFA102_min;
            this.max = DFA102_max;
            this.accept = DFA102_accept;
            this.special = DFA102_special;
            this.transition = DFA102_transition;
        }
        public String getDescription() {
            return "()* loopback of 1286:3: ( 'case' expression ':' | statement )*";
        }
    }
 

    public static final BitSet FOLLOW_22_in_lineDirective65 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_lineDirective69 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_STRING_in_lineDirective82 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_lineDirective97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_sourceFile126 = new BitSet(new long[]{0xF800E001C6400040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_lineDirective_in_sourceFile135 = new BitSet(new long[]{0xF800E001C6400040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_EOF_in_sourceFile148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_externDeclarations165 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_externDeclarations169 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_externDeclarations175 = new BitSet(new long[]{0xF800E001C7000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_declaration_in_externDeclarations189 = new BitSet(new long[]{0xF800E001C7000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_24_in_externDeclarations202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_declaration245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_externDeclarations_in_declaration255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_declaration265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objCClassDef_in_declaration275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeDef_in_declaration285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forwardClassDecl_in_declaration295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_declaration305 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration309 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_declaration311 = new BitSet(new long[]{0xF800E001C7000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_declaration_in_declaration329 = new BitSet(new long[]{0xF800E001C7000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_24_in_declaration345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_forwardClassDecl385 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_forwardClassDecl392 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_forwardClassDecl399 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_forwardClassDecl406 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_28_in_forwardClassDecl417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRef_in_functionPointerVarDecl435 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_functionPointerVarDecl443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enumItem461 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_enumItem464 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_enumItem468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_enumCore492 = new BitSet(new long[]{0x0000000000800042L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enumCore506 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_enumCore523 = new BitSet(new long[]{0x0000000001000040L});
    public static final BitSet FOLLOW_enumItem_in_enumCore542 = new BitSet(new long[]{0x0000000009000000L});
    public static final BitSet FOLLOW_27_in_enumCore559 = new BitSet(new long[]{0x0000000009000040L});
    public static final BitSet FOLLOW_enumItem_in_enumCore571 = new BitSet(new long[]{0x0000000009000000L});
    public static final BitSet FOLLOW_24_in_enumCore595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_objCClassDef627 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef638 = new BitSet(new long[]{0xF800EE1640800040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_33_in_objCClassDef656 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef660 = new BitSet(new long[]{0xF800EE1040800040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_34_in_objCClassDef675 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef679 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCClassDef681 = new BitSet(new long[]{0xF800EE1040800040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_36_in_objCClassDef697 = new BitSet(new long[]{0x0000002000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef707 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_27_in_objCClassDef722 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef732 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_37_in_objCClassDef749 = new BitSet(new long[]{0xF800EE0040800040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_23_in_objCClassDef763 = new BitSet(new long[]{0xF000E1C041000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_38_in_objCClassDef775 = new BitSet(new long[]{0xF000E1C041000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_39_in_objCClassDef786 = new BitSet(new long[]{0xF000E1C041000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_40_in_objCClassDef797 = new BitSet(new long[]{0xF000E1C041000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_varDecl_in_objCClassDef824 = new BitSet(new long[]{0xF000E1C041000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_functionPointerVarDecl_in_objCClassDef836 = new BitSet(new long[]{0xF000E1C041000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_24_in_objCClassDef863 = new BitSet(new long[]{0xF800EE0040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_objCMethodDecl_in_objCClassDef881 = new BitSet(new long[]{0xF800EE0040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeDef_in_objCClassDef890 = new BitSet(new long[]{0xF800EE0040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_varDecl_in_objCClassDef901 = new BitSet(new long[]{0xF800EE0040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_41_in_objCClassDef914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_objCMethodDecl948 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_43_in_objCMethodDecl960 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl979 = new BitSet(new long[]{0xF000E00840000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_objCMethodDecl987 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl995 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1006 = new BitSet(new long[]{0x0000000210000000L});
    public static final BitSet FOLLOW_33_in_objCMethodDecl1018 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl1020 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_objCMethodDecl1024 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl1026 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1030 = new BitSet(new long[]{0x0000000018000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1045 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodDecl1047 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl1054 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_objCMethodDecl1058 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl1060 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1069 = new BitSet(new long[]{0x0000000018000040L});
    public static final BitSet FOLLOW_27_in_objCMethodDecl1088 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_objCMethodDecl1090 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_objCMethodDecl1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_structCore1133 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_structCore1162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exportationModifiers_in_structCore1185 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_structCore1198 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_structCore1212 = new BitSet(new long[]{0xF807E001C7000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_48_in_structCore1235 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_49_in_structCore1248 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_50_in_structCore1261 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_structCore1273 = new BitSet(new long[]{0xF807E001C7000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_declaration_in_structCore1282 = new BitSet(new long[]{0xF807E001C7000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_24_in_structCore1296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exportationModifiers_in_functionDeclaration1329 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_functionDeclaration1337 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_exportationModifiers_in_functionDeclaration1346 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionDeclaration1354 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_argList_in_functionDeclaration1361 = new BitSet(new long[]{0x0000000010800040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionDeclaration1372 = new BitSet(new long[]{0x0000000010800040L});
    public static final BitSet FOLLOW_exportationModifiers_in_functionDeclaration1383 = new BitSet(new long[]{0x0000000010800040L});
    public static final BitSet FOLLOW_28_in_functionDeclaration1395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_functionDeclaration1402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exportationModifier_in_exportationModifiers1435 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier1462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_exportationModifier1494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_exportationModifier1503 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_exportationModifier1511 = new BitSet(new long[]{0x0000000800000040L});
    public static final BitSet FOLLOW_extendedModifiers_in_exportationModifier1513 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_exportationModifier1515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_extendedModifiers1550 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_modifier_in_argDef1609 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_modifier_in_argDef1626 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_argDef1650 = new BitSet(new long[]{0x0418000420000042L});
    public static final BitSet FOLLOW_declarator_in_argDef1665 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_argDef1685 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_argDef1687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_argDef1701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_typeMutator1721 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_typeMutator1723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_typeMutator1731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_typeMutator1739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_typeMutator1748 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_typeMutator1750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_arrayTypeMutator1768 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_arrayTypeMutator1774 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_arrayTypeMutator1783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_typeRefCore1823 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_typeRefCore1826 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_typeRefCore1828 = new BitSet(new long[]{0x04180C3000000000L,0x0000000000FFF000L});
    public static final BitSet FOLLOW_binaryOp_in_typeRefCore1830 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_typeRefCore1832 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_typeRefCore1834 = new BitSet(new long[]{0xF000000000000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_modifier_in_typeRefCore1845 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_typeRefCore1848 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_typeRefCore1850 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_typeRefCore1852 = new BitSet(new long[]{0xF000000000000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_modifier_in_typeRefCore1865 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_typeRefCore1868 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_typeRefCore1870 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_typeRefCore1872 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_typeRefCore1874 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_typeRefCore1876 = new BitSet(new long[]{0xF000000000000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_modifier_in_typeRefCore1893 = new BitSet(new long[]{0xF000000000000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_modifier_in_typeRefCore1910 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_typeRefCore1919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveTypeRef_in_typeRefCore1939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_typeRefCore1954 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_typeRefCore1972 = new BitSet(new long[]{0xF000E02040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_typeRefCore1993 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_27_in_typeRefCore2014 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_typeRefCore2027 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_37_in_typeRefCore2055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_templateDef2087 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_templateDef2089 = new BitSet(new long[]{0xF200402000000000L,0x00000000000007FFL});
    public static final BitSet FOLLOW_templateArgDecl_in_templateDef2092 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_27_in_templateDef2095 = new BitSet(new long[]{0xF200400000000000L,0x00000000000007FFL});
    public static final BitSet FOLLOW_templateArgDecl_in_templateDef2097 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_37_in_templateDef2104 = new BitSet(new long[]{0x0000E00000000000L});
    public static final BitSet FOLLOW_structCore_in_templateDef2108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_templateDef2112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveTypeRef_in_templateArgDecl2124 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_templateArgDecl2127 = new BitSet(new long[]{0x00000000000007B0L});
    public static final BitSet FOLLOW_constant_in_templateArgDecl2129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_templateArgDecl2136 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_templateArgDecl2144 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_templateArgDecl2147 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_templateArgDecl2149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffix2168 = new BitSet(new long[]{0x0008000000000040L});
    public static final BitSet FOLLOW_exportationModifiers_in_functionSignatureSuffix2170 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_functionSignatureSuffix2172 = new BitSet(new long[]{0x0000000800000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionSignatureSuffix2174 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffix2177 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffix2183 = new BitSet(new long[]{0xF000F00840000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffix2192 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_27_in_functionSignatureSuffix2205 = new BitSet(new long[]{0xF000F00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffix2214 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffix2229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffixNoName2246 = new BitSet(new long[]{0x0008000000000040L});
    public static final BitSet FOLLOW_exportationModifiers_in_functionSignatureSuffixNoName2248 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_functionSignatureSuffixNoName2250 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffixNoName2252 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffixNoName2258 = new BitSet(new long[]{0xF000F00840000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffixNoName2267 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_27_in_functionSignatureSuffixNoName2280 = new BitSet(new long[]{0xF000F00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffixNoName2289 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffixNoName2304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structCore_in_structOrEnum2322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumCore_in_structOrEnum2330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefCore_in_typeRefCoreOrFuncSig2348 = new BitSet(new long[]{0x0038000400000042L});
    public static final BitSet FOLLOW_typeMutator_in_typeRefCoreOrFuncSig2365 = new BitSet(new long[]{0x0038000400000040L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_typeRefCoreOrFuncSig2378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefCore_in_typeRefCoreOrAnonymousFuncSig2402 = new BitSet(new long[]{0x0038000400000042L});
    public static final BitSet FOLLOW_typeMutator_in_typeRefCoreOrAnonymousFuncSig2419 = new BitSet(new long[]{0x0038000400000040L});
    public static final BitSet FOLLOW_functionSignatureSuffixNoName_in_typeRefCoreOrAnonymousFuncSig2432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structOrEnum_in_plainTypeRef2459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefCoreOrFuncSig_in_plainTypeRef2467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_declarator2496 = new BitSet(new long[]{0x0418000400000040L});
    public static final BitSet FOLLOW_set_in_declarator2533 = new BitSet(new long[]{0x0418000400000040L});
    public static final BitSet FOLLOW_declarator_in_declarator2552 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_directDeclarator_in_declarator2568 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_declarator2587 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_declarator2594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structCore_in_namedTypeRef2628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumCore_in_namedTypeRef2638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_typeDef2657 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_varDecl_in_typeDef2663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_varDeclEOF2683 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_varDeclEOF2685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_varDecl2721 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_modifier_in_varDecl2738 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_structOrEnum_in_varDecl2765 = new BitSet(new long[]{0x0418000410000040L});
    public static final BitSet FOLLOW_declaratorsList_in_varDecl2782 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_typeRefCoreOrAnonymousFuncSig_in_varDecl2802 = new BitSet(new long[]{0x0418000400000040L});
    public static final BitSet FOLLOW_declaratorsList_in_varDecl2812 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_varDecl2849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_objCProtocolRefList2863 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCProtocolRefList2868 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_27_in_objCProtocolRefList2878 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCProtocolRefList2884 = new BitSet(new long[]{0x0000002008000000L});
    public static final BitSet FOLLOW_37_in_objCProtocolRefList2894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarator_in_declaratorsList2921 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_declaratorsList2934 = new BitSet(new long[]{0x0418000400000040L});
    public static final BitSet FOLLOW_declarator_in_declaratorsList2943 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_directDeclarator2986 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_34_in_directDeclarator2996 = new BitSet(new long[]{0x0418000400000040L});
    public static final BitSet FOLLOW_modifier_in_directDeclarator3005 = new BitSet(new long[]{0x0418000400000040L});
    public static final BitSet FOLLOW_declarator_in_directDeclarator3016 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_directDeclarator3022 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_53_in_directDeclarator3037 = new BitSet(new long[]{0x00600004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_directDeclarator3049 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_directDeclarator3065 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_argList_in_directDeclarator3073 = new BitSet(new long[]{0x0020000400000002L});
    public static final BitSet FOLLOW_34_in_argList3101 = new BitSet(new long[]{0xF000F00840000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_argDef_in_argList3113 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_27_in_argList3126 = new BitSet(new long[]{0xF000F00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_argDef_in_argList3135 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_27_in_argList3155 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_argList3157 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_argList3176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plainTypeRef_in_typeRef3194 = new BitSet(new long[]{0x0038000000000042L});
    public static final BitSet FOLLOW_typeMutator_in_typeRef3205 = new BitSet(new long[]{0x0038000000000042L});
    public static final BitSet FOLLOW_set_in_primSignModifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_primSizeModifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_primitiveTypeName0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primSignModifier_in_primitiveTypeRef3344 = new BitSet(new long[]{0xF000000000000000L,0x00000000000007FFL});
    public static final BitSet FOLLOW_primSizeModifier_in_primitiveTypeRef3355 = new BitSet(new long[]{0xF000000000000000L,0x00000000000007FFL});
    public static final BitSet FOLLOW_primSizeModifier_in_primitiveTypeRef3362 = new BitSet(new long[]{0xF000000000000000L,0x00000000000007FFL});
    public static final BitSet FOLLOW_primitiveTypeName_in_primitiveTypeRef3405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_objCMethodCall3444 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3448 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodCall3452 = new BitSet(new long[]{0x0040000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodCall3463 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3467 = new BitSet(new long[]{0x0040000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodCall3482 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodCall3484 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3488 = new BitSet(new long[]{0x0040000000000040L});
    public static final BitSet FOLLOW_54_in_objCMethodCall3505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_functionCall3525 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionCall3527 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_functionCall3529 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionCall3531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionCall3539 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionCall3541 = new BitSet(new long[]{0x0020000C008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_functionCall3554 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_27_in_functionCall3563 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_functionCall3572 = new BitSet(new long[]{0x0000000808000000L});
    public static final BitSet FOLLOW_35_in_functionCall3590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_binaryOp0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_expression3696 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_functionCall_in_expression3707 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_objCMethodCall_in_expression3716 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_set_in_expression3727 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_expression3737 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_34_in_expression3746 = new BitSet(new long[]{0xF020E004408007F0L,0x0000000003000FFFL});
    public static final BitSet FOLLOW_expression_in_expression3756 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_expression3758 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_typeRef_in_expression3768 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_expression3770 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_expression3774 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_constant_in_expression3789 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_23_in_expression3798 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_expression3800 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_expression3802 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_binaryOp_in_expression3818 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_expression3825 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_29_in_expression3834 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_expression3838 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_90_in_expression3847 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_expression3851 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_33_in_expression3863 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_expression3865 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000800L});
    public static final BitSet FOLLOW_43_in_expression3869 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_expression3871 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000800L});
    public static final BitSet FOLLOW_90_in_expression3875 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000800L});
    public static final BitSet FOLLOW_functionCall_in_expression3880 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_91_in_expression3892 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_expression3896 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_expression3898 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_expression3902 = new BitSet(new long[]{0x04180C3220000002L,0x000000000CFFF000L});
    public static final BitSet FOLLOW_23_in_statementsBlock3925 = new BitSet(new long[]{0xF8A0E005D78007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statementsBlock3927 = new BitSet(new long[]{0xF8A0E005D78007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_24_in_statementsBlock3930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_statement3943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_statement3949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement3955 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_statement3958 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement3960 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_statement3971 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement3973 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement3975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_statement3981 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement3983 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement3985 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement3987 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement3989 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_statement3992 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement3994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_statement4002 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4004 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement4006 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4008 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement4010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_statement4016 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement4018 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_statement4020 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4022 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement4024 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4026 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement4028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_statement4034 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4036 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement4038 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement4041 = new BitSet(new long[]{0x00200004108007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement4043 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_statement4046 = new BitSet(new long[]{0xF8A0E00DD68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement4048 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4051 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement4053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_statement4059 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4061 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement4063 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4065 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_statement4067 = new BitSet(new long[]{0xF8A0E005D78007F0L,0x00000007D3000FFFL});
    public static final BitSet FOLLOW_98_in_statement4073 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement4075 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement4077 = new BitSet(new long[]{0xF8A0E005D78007F0L,0x00000007D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement4084 = new BitSet(new long[]{0xF8A0E005D78007F0L,0x00000007D3000FFFL});
    public static final BitSet FOLLOW_24_in_statement4093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_statement4099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement4107 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4109 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_varDecl_in_statement4111 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement4113 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_statement4115 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4117 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_statement4119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_constant4135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEXADECIMAL_NUMBER_in_constant4143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OCTAL_NUMBER_in_constant4151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARACTER_in_constant4159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_NUMBER_in_constant4167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_constant4178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_synpred6_ObjCpp245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred8_ObjCpp265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred15_ObjCpp506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred29_ObjCpp824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred43_ObjCpp1162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exportationModifiers_in_synpred44_ObjCpp1185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRef_in_synpred50_ObjCpp1337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred51_ObjCpp1372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exportationModifier_in_synpred53_ObjCpp1435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred56_ObjCpp1609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred57_ObjCpp1626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred65_ObjCpp1845 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_synpred65_ObjCpp1848 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred65_ObjCpp1850 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred65_ObjCpp1852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred66_ObjCpp1865 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_synpred66_ObjCpp1868 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred66_ObjCpp1870 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_synpred66_ObjCpp1872 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred66_ObjCpp1874 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred66_ObjCpp1876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred67_ObjCpp1893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred68_ObjCpp1910 = new BitSet(new long[]{0xF000E00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_typeRef_in_synpred68_ObjCpp1919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred85_ObjCpp2365 = new BitSet(new long[]{0x0038000400000040L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_synpred85_ObjCpp2378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred87_ObjCpp2419 = new BitSet(new long[]{0x0038000400000040L});
    public static final BitSet FOLLOW_functionSignatureSuffixNoName_in_synpred87_ObjCpp2432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred89_ObjCpp2496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred93_ObjCpp2587 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred93_ObjCpp2594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred95_ObjCpp2721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred96_ObjCpp2738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred102_ObjCpp3005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_synpred106_ObjCpp3126 = new BitSet(new long[]{0xF000F00040000040L,0x00000000000007FFL});
    public static final BitSet FOLLOW_argDef_in_synpred106_ObjCpp3135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred109_ObjCpp3205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred155_ObjCpp3756 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred155_ObjCpp3758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binaryOp_in_synpred158_ObjCpp3818 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred158_ObjCpp3825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred159_ObjCpp3834 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred159_ObjCpp3838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_synpred160_ObjCpp3847 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred160_ObjCpp3851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_synpred163_ObjCpp3863 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_synpred163_ObjCpp3865 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000800L});
    public static final BitSet FOLLOW_43_in_synpred163_ObjCpp3869 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_synpred163_ObjCpp3871 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000800L});
    public static final BitSet FOLLOW_90_in_synpred163_ObjCpp3875 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000800L});
    public static final BitSet FOLLOW_functionCall_in_synpred163_ObjCpp3880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_synpred164_ObjCpp3892 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred164_ObjCpp3896 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_synpred164_ObjCpp3898 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred164_ObjCpp3902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_synpred166_ObjCpp3943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_synpred167_ObjCpp3949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred169_ObjCpp3955 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_synpred169_ObjCpp3958 = new BitSet(new long[]{0x00200004008007F0L,0x0000000003000800L});
    public static final BitSet FOLLOW_expression_in_synpred169_ObjCpp3960 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_synpred169_ObjCpp3965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_synpred171_ObjCpp3992 = new BitSet(new long[]{0xF8A0E005D68007F0L,0x00000003D3000FFFL});
    public static final BitSet FOLLOW_statement_in_synpred171_ObjCpp3994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_synpred175_ObjCpp4038 = new BitSet(new long[]{0x0000000000000002L});

}