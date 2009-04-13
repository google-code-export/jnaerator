// $ANTLR 3.1.2 /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g 2009-04-13 11:14:08
 
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DECIMAL_NUMBER", "STRING", "IDENTIFIER", "HEXADECIMAL_NUMBER", "OCTAL_NUMBER", "CHARACTER", "FLOAT_NUMBER", "Letter", "FloatingPointExponentSuffix", "FloatingPointConstantSuffix", "OctalEscape", "CharEscape", "HexDigit", "UnicodeEscape", "IntegerConstantSuffix", "WS", "COMMENT", "LINE_COMMENT", "'#line'", "'{'", "'}'", "';'", "'namespace'", "'@class'", "','", "'='", "'enum'", "'@protocol'", "'@interface'", "':'", "'('", "')'", "'<'", "'>'", "'@public'", "'@private'", "'@protected'", "'@end'", "'+'", "'-'", "'...'", "'public'", "'private'", "'protected'", "'struct'", "'class'", "'union'", "'~'", "'return'", "'*'", "'&'", "'['", "']'", "'template'", "'^'", "'typedef'", "'typename'", "'/'", "'%'", "'<<'", "'>>>'", "'>>'", "'||'", "'|'", "'&&'", "'<='", "'>='", "'=='", "'!='", "'@selector'", "'@encode'", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'?'", "'sizeof'", "'++'", "'--'", "'!'", "'.'", "'->'", "'if'", "'else'", "'while'", "'do'", "'for'", "'switch'", "'case'"
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


    public static class lineDirective_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "lineDirective"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:251:1: lineDirective : ln= '#line' line= DECIMAL_NUMBER (unescapedString= STRING )? (depth= DECIMAL_NUMBER )? ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:252:2: (ln= '#line' line= DECIMAL_NUMBER (unescapedString= STRING )? (depth= DECIMAL_NUMBER )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:252:4: ln= '#line' line= DECIMAL_NUMBER (unescapedString= STRING )? (depth= DECIMAL_NUMBER )?
            {
            root_0 = (Object)adaptor.nil();

            ln=(Token)match(input,22,FOLLOW_22_in_lineDirective84); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ln_tree = (Object)adaptor.create(ln);
            adaptor.addChild(root_0, ln_tree);
            }
            line=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_lineDirective88); if (state.failed) return retval;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:260:3: (unescapedString= STRING )?
            int alt1=2;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:261:4: unescapedString= STRING
                    {
                    unescapedString=(Token)match(input,STRING,FOLLOW_STRING_in_lineDirective101); if (state.failed) return retval;
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:271:8: (depth= DECIMAL_NUMBER )?
            int alt2=2;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: depth= DECIMAL_NUMBER
                    {
                    depth=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_lineDirective116); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:274:1: sourceFile returns [SourceFile sourceFile] : ( declaration | lineDirective )* EOF ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:279:2: ( ( declaration | lineDirective )* EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:280:3: ( declaration | lineDirective )* EOF
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.sourceFile = new SourceFile(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:281:3: ( declaration | lineDirective )*
            loop3:
            do {
                int alt3=3;
                alt3 = dfa3.predict(input);
                switch (alt3) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:282:4: declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_sourceFile156);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:286:4: lineDirective
            	    {
            	    pushFollow(FOLLOW_lineDirective_in_sourceFile165);
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

            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_sourceFile178); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:294:1: externDeclarations returns [ExternDeclarations declarations] : {...}? IDENTIFIER STRING '{' (ed= declaration )* '}' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:295:2: ({...}? IDENTIFIER STRING '{' (ed= declaration )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:295:4: {...}? IDENTIFIER STRING '{' (ed= declaration )* '}'
            {
            root_0 = (Object)adaptor.nil();

            if ( !(( next("extern") )) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "externDeclarations", " next(\"extern\") ");
            }
            IDENTIFIER4=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_externDeclarations196); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER4_tree = (Object)adaptor.create(IDENTIFIER4);
            adaptor.addChild(root_0, IDENTIFIER4_tree);
            }
            STRING5=(Token)match(input,STRING,FOLLOW_STRING_in_externDeclarations200); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STRING5_tree = (Object)adaptor.create(STRING5);
            adaptor.addChild(root_0, STRING5_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.declarations = mark(new ExternDeclarations(), getLine(STRING5));
              			retval.declarations.setLanguage((STRING5!=null?STRING5.getText():null));
              		
            }
            char_literal6=(Token)match(input,23,FOLLOW_23_in_externDeclarations206); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal6_tree = (Object)adaptor.create(char_literal6);
            adaptor.addChild(root_0, char_literal6_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:301:4: (ed= declaration )*
            loop4:
            do {
                int alt4=2;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:302:5: ed= declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_externDeclarations220);
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

            char_literal7=(Token)match(input,24,FOLLOW_24_in_externDeclarations233); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:309:1: declaration returns [List<Declaration> declarations, List<Modifier> modifiers, String preComment, int startTokenIndex] : ( ( functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) ) ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:311:2: ( ( ( functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:312:3: ( ( functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.declarations = new ArrayList<Declaration>(); 
              		  retval.modifiers = new ArrayList<Modifier>();
              		  retval.startTokenIndex = getTokenStream().index();
              		  retval.preComment = getCommentBefore(retval.startTokenIndex);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:317:3: ( ( functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:318:4: ( functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:318:4: ( functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )
            int alt6=7;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:320:5: functionDeclaration
                    {
                    pushFollow(FOLLOW_functionDeclaration_in_declaration276);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:323:5: externDeclarations
                    {
                    pushFollow(FOLLOW_externDeclarations_in_declaration286);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:326:5: varDecl ';'
                    {
                    pushFollow(FOLLOW_varDecl_in_declaration296);
                    varDecl10=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl10.getTree());
                    char_literal11=(Token)match(input,25,FOLLOW_25_in_declaration298); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:329:5: objCClassDef
                    {
                    pushFollow(FOLLOW_objCClassDef_in_declaration308);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:332:5: typeDef
                    {
                    pushFollow(FOLLOW_typeDef_in_declaration318);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:335:5: forwardClassDecl
                    {
                    pushFollow(FOLLOW_forwardClassDecl_in_declaration328);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:338:5: 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}'
                    {
                    string_literal15=(Token)match(input,26,FOLLOW_26_in_declaration338); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal15_tree = (Object)adaptor.create(string_literal15);
                    adaptor.addChild(root_0, string_literal15_tree);
                    }
                    ns=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration342); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ns_tree = (Object)adaptor.create(ns);
                    adaptor.addChild(root_0, ns_tree);
                    }
                    char_literal16=(Token)match(input,23,FOLLOW_23_in_declaration344); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal16_tree = (Object)adaptor.create(char_literal16);
                    adaptor.addChild(root_0, char_literal16_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:339:6: (subD= declaration )*
                    loop5:
                    do {
                        int alt5=2;
                        alt5 = dfa5.predict(input);
                        switch (alt5) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:340:7: subD= declaration
                    	    {
                    	    pushFollow(FOLLOW_declaration_in_declaration362);
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

                    char_literal17=(Token)match(input,24,FOLLOW_24_in_declaration378); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:364:1: forwardClassDecl returns [List<Declaration> declarations] : '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:365:2: ( '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:365:5: '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.declarations = new ArrayList<Declaration>(); 
            }
            string_literal18=(Token)match(input,27,FOLLOW_27_in_forwardClassDecl418); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal18_tree = (Object)adaptor.create(string_literal18);
            adaptor.addChild(root_0, string_literal18_tree);
            }
            n1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_forwardClassDecl425); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n1_tree = (Object)adaptor.create(n1);
            adaptor.addChild(root_0, n1_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.declarations.add(decl(Struct.forwardDecl((n1!=null?n1.getText():null), Struct.Type.ObjCClass))); 
              			defineTypeIdentifierInParentScope((n1!=null?n1.getText():null));
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:371:3: ( ',' nx= IDENTIFIER )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==28) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:371:4: ',' nx= IDENTIFIER
            	    {
            	    char_literal19=(Token)match(input,28,FOLLOW_28_in_forwardClassDecl432); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal19_tree = (Object)adaptor.create(char_literal19);
            	    adaptor.addChild(root_0, char_literal19_tree);
            	    }
            	    nx=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_forwardClassDecl439); if (state.failed) return retval;
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

            char_literal20=(Token)match(input,25,FOLLOW_25_in_forwardClassDecl450); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:380:1: functionPointerVarDecl returns [List<? extends Declaration> declarations] : mutableTypeRef {...}? ';' ;
    public final ObjCppParser.functionPointerVarDecl_return functionPointerVarDecl() throws RecognitionException {
        ObjCppParser.functionPointerVarDecl_return retval = new ObjCppParser.functionPointerVarDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal22=null;
        ObjCppParser.mutableTypeRef_return mutableTypeRef21 = null;


        Object char_literal22_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:381:2: ( mutableTypeRef {...}? ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:381:4: mutableTypeRef {...}? ';'
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_mutableTypeRef_in_functionPointerVarDecl468);
            mutableTypeRef21=mutableTypeRef();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mutableTypeRef21.getTree());
            if ( !((
            			((mutableTypeRef21!=null?mutableTypeRef21.type:null) instanceof FunctionSignature) && 
            			((FunctionSignature)(mutableTypeRef21!=null?mutableTypeRef21.type:null)).getFunction().getName() != null
            		)) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "functionPointerVarDecl", "\n\t\t\t($mutableTypeRef.type instanceof FunctionSignature) && \n\t\t\t((FunctionSignature)$mutableTypeRef.type).getFunction().getName() != null\n\t\t");
            }
            if ( state.backtracking==0 ) {

              			retval.declarations = Arrays.asList(new FunctionPointerDeclaration(((FunctionSignature)(mutableTypeRef21!=null?mutableTypeRef21.type:null))));
              		
            }
            char_literal22=(Token)match(input,25,FOLLOW_25_in_functionPointerVarDecl476); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal22_tree = (Object)adaptor.create(char_literal22);
            adaptor.addChild(root_0, char_literal22_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:390:1: enumItem returns [Enum.EnumItem item] : n= IDENTIFIER ( '=' v= expression )? ;
    public final ObjCppParser.enumItem_return enumItem() throws RecognitionException {
        ObjCppParser.enumItem_return retval = new ObjCppParser.enumItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token char_literal23=null;
        ObjCppParser.expression_return v = null;


        Object n_tree=null;
        Object char_literal23_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:391:2: (n= IDENTIFIER ( '=' v= expression )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:391:4: n= IDENTIFIER ( '=' v= expression )?
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumItem494); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:391:17: ( '=' v= expression )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==29) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:391:18: '=' v= expression
                    {
                    char_literal23=(Token)match(input,29,FOLLOW_29_in_enumItem497); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal23_tree = (Object)adaptor.create(char_literal23);
                    adaptor.addChild(root_0, char_literal23_tree);
                    }
                    pushFollow(FOLLOW_expression_in_enumItem501);
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

    public static class enumBody_return extends ParserRuleReturnScope {
        public Enum e;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "enumBody"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:398:1: enumBody returns [Enum e] : '{' (i1= enumItem ( ',' (ix= enumItem )? )* )? '}' ;
    public final ObjCppParser.enumBody_return enumBody() throws RecognitionException {
        ObjCppParser.enumBody_return retval = new ObjCppParser.enumBody_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal24=null;
        Token char_literal25=null;
        Token char_literal26=null;
        ObjCppParser.enumItem_return i1 = null;

        ObjCppParser.enumItem_return ix = null;


        Object char_literal24_tree=null;
        Object char_literal25_tree=null;
        Object char_literal26_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:399:2: ( '{' (i1= enumItem ( ',' (ix= enumItem )? )* )? '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:400:3: '{' (i1= enumItem ( ',' (ix= enumItem )? )* )? '}'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               
              			retval.e = new Enum();
              			retval.e.setForwardDeclaration(false); 
              		
            }
            char_literal24=(Token)match(input,23,FOLLOW_23_in_enumBody527); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal24_tree = (Object)adaptor.create(char_literal24);
            adaptor.addChild(root_0, char_literal24_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:405:4: (i1= enumItem ( ',' (ix= enumItem )? )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==IDENTIFIER) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:406:5: i1= enumItem ( ',' (ix= enumItem )? )*
                    {
                    pushFollow(FOLLOW_enumItem_in_enumBody543);
                    i1=enumItem();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, i1.getTree());
                    if ( state.backtracking==0 ) {
                       
                      					if ((i1!=null?input.toString(i1.start,i1.stop):null) != null)
                      						retval.e.addItem((i1!=null?i1.item:null)); 
                      				
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:410:5: ( ',' (ix= enumItem )? )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==28) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:411:6: ',' (ix= enumItem )?
                    	    {
                    	    char_literal25=(Token)match(input,28,FOLLOW_28_in_enumBody558); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal25_tree = (Object)adaptor.create(char_literal25);
                    	    adaptor.addChild(root_0, char_literal25_tree);
                    	    }
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:412:6: (ix= enumItem )?
                    	    int alt9=2;
                    	    int LA9_0 = input.LA(1);

                    	    if ( (LA9_0==IDENTIFIER) ) {
                    	        alt9=1;
                    	    }
                    	    switch (alt9) {
                    	        case 1 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:412:7: ix= enumItem
                    	            {
                    	            pushFollow(FOLLOW_enumItem_in_enumBody569);
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

            char_literal26=(Token)match(input,24,FOLLOW_24_in_enumBody590); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal26_tree = (Object)adaptor.create(char_literal26);
            adaptor.addChild(root_0, char_literal26_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:420:1: enumCore returns [Enum e] : t= 'enum' (m1= modifiers (ab= enumBody | tag= IDENTIFIER (m2= modifiers nb= enumBody | ) ) ) ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:424:2: (t= 'enum' (m1= modifiers (ab= enumBody | tag= IDENTIFIER (m2= modifiers nb= enumBody | ) ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:425:3: t= 'enum' (m1= modifiers (ab= enumBody | tag= IDENTIFIER (m2= modifiers nb= enumBody | ) ) )
            {
            root_0 = (Object)adaptor.nil();

            t=(Token)match(input,30,FOLLOW_30_in_enumCore613); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            t_tree = (Object)adaptor.create(t);
            adaptor.addChild(root_0, t_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:426:3: (m1= modifiers (ab= enumBody | tag= IDENTIFIER (m2= modifiers nb= enumBody | ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:427:4: m1= modifiers (ab= enumBody | tag= IDENTIFIER (m2= modifiers nb= enumBody | ) )
            {
            pushFollow(FOLLOW_modifiers_in_enumCore624);
            m1=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, m1.getTree());
            if ( state.backtracking==0 ) {
               modifiers.addAll((m1!=null?m1.modifiers:null)); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:428:4: (ab= enumBody | tag= IDENTIFIER (m2= modifiers nb= enumBody | ) )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:429:5: ab= enumBody
                    {
                    pushFollow(FOLLOW_enumBody_in_enumCore639);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:433:5: tag= IDENTIFIER (m2= modifiers nb= enumBody | )
                    {
                    tag=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumCore651); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    tag_tree = (Object)adaptor.create(tag);
                    adaptor.addChild(root_0, tag_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:434:5: (m2= modifiers nb= enumBody | )
                    int alt12=2;
                    alt12 = dfa12.predict(input);
                    switch (alt12) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:435:6: m2= modifiers nb= enumBody
                            {
                            pushFollow(FOLLOW_modifiers_in_enumCore667);
                            m2=modifiers();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, m2.getTree());
                            if ( state.backtracking==0 ) {
                               modifiers.addAll((m2!=null?m2.modifiers:null)); 
                            }
                            pushFollow(FOLLOW_enumBody_in_enumCore678);
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
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:439:10: 
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:462:1: objCClassDef returns [Struct struct] : octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl ';' {...}?)* '@end' ;
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
        Token char_literal27=null;
        Token char_literal28=null;
        Token char_literal29=null;
        Token char_literal30=null;
        Token char_literal31=null;
        Token char_literal32=null;
        Token char_literal33=null;
        Token string_literal34=null;
        Token string_literal35=null;
        Token string_literal36=null;
        Token char_literal37=null;
        Token char_literal38=null;
        Token char_literal40=null;
        Token char_literal43=null;
        Token string_literal44=null;
        ObjCppParser.varDecl_return fv = null;

        ObjCppParser.varDecl_return vd = null;

        ObjCppParser.functionPointerVarDecl_return functionPointerVarDecl39 = null;

        ObjCppParser.objCMethodDecl_return objCMethodDecl41 = null;

        ObjCppParser.typeDef_return typeDef42 = null;


        Object octype_tree=null;
        Object className_tree=null;
        Object parentClass_tree=null;
        Object categoryName_tree=null;
        Object p1_tree=null;
        Object px_tree=null;
        Object bits_tree=null;
        Object char_literal27_tree=null;
        Object char_literal28_tree=null;
        Object char_literal29_tree=null;
        Object char_literal30_tree=null;
        Object char_literal31_tree=null;
        Object char_literal32_tree=null;
        Object char_literal33_tree=null;
        Object string_literal34_tree=null;
        Object string_literal35_tree=null;
        Object string_literal36_tree=null;
        Object char_literal37_tree=null;
        Object char_literal38_tree=null;
        Object char_literal40_tree=null;
        Object char_literal43_tree=null;
        Object string_literal44_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:463:2: (octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl ';' {...}?)* '@end' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:464:3: octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl ';' {...}?)* '@end'
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

            className=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef741); if (state.failed) return retval;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:475:3: ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' )
            int alt15=2;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:476:4: ( ':' parentClass= IDENTIFIER )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:476:4: ( ':' parentClass= IDENTIFIER )?
                    int alt14=2;
                    alt14 = dfa14.predict(input);
                    switch (alt14) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:477:5: ':' parentClass= IDENTIFIER
                            {
                            char_literal27=(Token)match(input,33,FOLLOW_33_in_objCClassDef759); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal27_tree = (Object)adaptor.create(char_literal27);
                            adaptor.addChild(root_0, char_literal27_tree);
                            }
                            parentClass=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef763); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:482:4: '(' categoryName= IDENTIFIER ')'
                    {
                    char_literal28=(Token)match(input,34,FOLLOW_34_in_objCClassDef778); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal28_tree = (Object)adaptor.create(char_literal28);
                    adaptor.addChild(root_0, char_literal28_tree);
                    }
                    categoryName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef782); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    categoryName_tree = (Object)adaptor.create(categoryName);
                    adaptor.addChild(root_0, categoryName_tree);
                    }
                    char_literal29=(Token)match(input,35,FOLLOW_35_in_objCClassDef784); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal29_tree = (Object)adaptor.create(char_literal29);
                    adaptor.addChild(root_0, char_literal29_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				retval.struct.setCategoryName((categoryName!=null?categoryName.getText():null));
                      			
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:486:3: ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )?
            int alt18=2;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:487:4: '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>'
                    {
                    char_literal30=(Token)match(input,36,FOLLOW_36_in_objCClassDef800); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal30_tree = (Object)adaptor.create(char_literal30);
                    adaptor.addChild(root_0, char_literal30_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:487:8: (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==IDENTIFIER) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:488:5: p1= IDENTIFIER ( ',' px= IDENTIFIER )*
                            {
                            p1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef810); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            p1_tree = (Object)adaptor.create(p1);
                            adaptor.addChild(root_0, p1_tree);
                            }
                            if ( state.backtracking==0 ) {
                               retval.struct.addProtocol((p1!=null?p1.getText():null)); 
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:489:5: ( ',' px= IDENTIFIER )*
                            loop16:
                            do {
                                int alt16=2;
                                int LA16_0 = input.LA(1);

                                if ( (LA16_0==28) ) {
                                    alt16=1;
                                }


                                switch (alt16) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:490:6: ',' px= IDENTIFIER
                            	    {
                            	    char_literal31=(Token)match(input,28,FOLLOW_28_in_objCClassDef825); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    char_literal31_tree = (Object)adaptor.create(char_literal31);
                            	    adaptor.addChild(root_0, char_literal31_tree);
                            	    }
                            	    px=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef835); if (state.failed) return retval;
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

                    char_literal32=(Token)match(input,37,FOLLOW_37_in_objCClassDef852); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal32_tree = (Object)adaptor.create(char_literal32);
                    adaptor.addChild(root_0, char_literal32_tree);
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:495:3: ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) ) )* '}' )?
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:496:4: '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) ) )* '}'
                    {
                    char_literal33=(Token)match(input,23,FOLLOW_23_in_objCClassDef866); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal33_tree = (Object)adaptor.create(char_literal33);
                    adaptor.addChild(root_0, char_literal33_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:497:4: ( '@public' | '@private' | '@protected' | ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) ) )*
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
                        case 30:
                        case 48:
                        case 49:
                        case 50:
                        case 60:
                            {
                            alt21=4;
                            }
                            break;

                        }

                        switch (alt21) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:498:5: '@public'
                    	    {
                    	    string_literal34=(Token)match(input,38,FOLLOW_38_in_objCClassDef878); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    string_literal34_tree = (Object)adaptor.create(string_literal34);
                    	    adaptor.addChild(root_0, string_literal34_tree);
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Public); 
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:499:5: '@private'
                    	    {
                    	    string_literal35=(Token)match(input,39,FOLLOW_39_in_objCClassDef889); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    string_literal35_tree = (Object)adaptor.create(string_literal35);
                    	    adaptor.addChild(root_0, string_literal35_tree);
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Private); 
                    	    }

                    	    }
                    	    break;
                    	case 3 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:500:5: '@protected'
                    	    {
                    	    string_literal36=(Token)match(input,40,FOLLOW_40_in_objCClassDef900); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    string_literal36_tree = (Object)adaptor.create(string_literal36);
                    	    adaptor.addChild(root_0, string_literal36_tree);
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Protected); 
                    	    }

                    	    }
                    	    break;
                    	case 4 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:501:5: ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) )
                    	    {
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:501:5: ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) )
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:502:6: (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl )
                    	    {
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:502:6: (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl )
                    	    int alt20=2;
                    	    alt20 = dfa20.predict(input);
                    	    switch (alt20) {
                    	        case 1 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:503:7: fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';'
                    	            {
                    	            pushFollow(FOLLOW_varDecl_in_objCClassDef927);
                    	            fv=varDecl();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) adaptor.addChild(root_0, fv.getTree());
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:503:18: ( ':' bits= DECIMAL_NUMBER )?
                    	            int alt19=2;
                    	            int LA19_0 = input.LA(1);

                    	            if ( (LA19_0==33) ) {
                    	                alt19=1;
                    	            }
                    	            switch (alt19) {
                    	                case 1 :
                    	                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:503:20: ':' bits= DECIMAL_NUMBER
                    	                    {
                    	                    char_literal37=(Token)match(input,33,FOLLOW_33_in_objCClassDef931); if (state.failed) return retval;
                    	                    if ( state.backtracking==0 ) {
                    	                    char_literal37_tree = (Object)adaptor.create(char_literal37);
                    	                    adaptor.addChild(root_0, char_literal37_tree);
                    	                    }
                    	                    bits=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_objCClassDef935); if (state.failed) return retval;
                    	                    if ( state.backtracking==0 ) {
                    	                    bits_tree = (Object)adaptor.create(bits);
                    	                    adaptor.addChild(root_0, bits_tree);
                    	                    }

                    	                    }
                    	                    break;

                    	            }

                    	            char_literal38=(Token)match(input,25,FOLLOW_25_in_objCClassDef940); if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) {
                    	            char_literal38_tree = (Object)adaptor.create(char_literal38);
                    	            adaptor.addChild(root_0, char_literal38_tree);
                    	            }
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              							//if ($bit.text != null) (fv!=null?fv.decl:null).setBits(Integer.parseInt((bits!=null?bits.getText():null)));
                    	              							retval.struct.addDeclaration((fv!=null?fv.decl:null));
                    	              						
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:507:7: functionPointerVarDecl
                    	            {
                    	            pushFollow(FOLLOW_functionPointerVarDecl_in_objCClassDef952);
                    	            functionPointerVarDecl39=functionPointerVarDecl();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) adaptor.addChild(root_0, functionPointerVarDecl39.getTree());
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              							retval.struct.addDeclarations((functionPointerVarDecl39!=null?functionPointerVarDecl39.declarations:null)); 
                    	              						
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

                    char_literal40=(Token)match(input,24,FOLLOW_24_in_objCClassDef979); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal40_tree = (Object)adaptor.create(char_literal40);
                    adaptor.addChild(root_0, char_literal40_tree);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Public); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:516:3: ( objCMethodDecl | typeDef | vd= varDecl ';' {...}?)*
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
                case 30:
                case 48:
                case 49:
                case 50:
                case 60:
                    {
                    alt23=3;
                    }
                    break;

                }

                switch (alt23) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:517:4: objCMethodDecl
            	    {
            	    pushFollow(FOLLOW_objCMethodDecl_in_objCClassDef997);
            	    objCMethodDecl41=objCMethodDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, objCMethodDecl41.getTree());
            	    if ( state.backtracking==0 ) {
            	       
            	      				retval.struct.addDeclaration((objCMethodDecl41!=null?objCMethodDecl41.function:null)); 
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:520:4: typeDef
            	    {
            	    pushFollow(FOLLOW_typeDef_in_objCClassDef1006);
            	    typeDef42=typeDef();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeDef42.getTree());
            	    if ( state.backtracking==0 ) {

            	      				retval.struct.addDeclaration((typeDef42!=null?typeDef42.typeDef:null)); 
            	      			
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:523:4: vd= varDecl ';' {...}?
            	    {
            	    pushFollow(FOLLOW_varDecl_in_objCClassDef1017);
            	    vd=varDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, vd.getTree());
            	    char_literal43=(Token)match(input,25,FOLLOW_25_in_objCClassDef1019); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal43_tree = (Object)adaptor.create(char_literal43);
            	    adaptor.addChild(root_0, char_literal43_tree);
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

            string_literal44=(Token)match(input,41,FOLLOW_41_in_objCClassDef1032); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal44_tree = (Object)adaptor.create(string_literal44);
            adaptor.addChild(root_0, string_literal44_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:530:1: objCMethodDecl returns [Function function] : tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= mutableTypeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= mutableTypeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';' ;
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
        Token char_literal45=null;
        Token char_literal46=null;
        Token char_literal47=null;
        Token char_literal48=null;
        Token char_literal49=null;
        Token char_literal50=null;
        Token char_literal51=null;
        Token char_literal52=null;
        Token char_literal53=null;
        Token string_literal54=null;
        Token char_literal55=null;
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
        Object char_literal45_tree=null;
        Object char_literal46_tree=null;
        Object char_literal47_tree=null;
        Object char_literal48_tree=null;
        Object char_literal49_tree=null;
        Object char_literal50_tree=null;
        Object char_literal51_tree=null;
        Object char_literal52_tree=null;
        Object char_literal53_tree=null;
        Object string_literal54_tree=null;
        Object char_literal55_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:531:2: (tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= mutableTypeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= mutableTypeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:531:4: tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= mutableTypeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= mutableTypeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               	
              			retval.function = new Function(); 
              			retval.function.setType(Function.Type.ObjCMethod);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:535:6: (tp= '+' | tm= '-' )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:536:4: tp= '+'
                    {
                    tp=(Token)match(input,42,FOLLOW_42_in_objCMethodDecl1066); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:541:4: tm= '-'
                    {
                    tm=(Token)match(input,43,FOLLOW_43_in_objCMethodDecl1078); if (state.failed) return retval;
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:546:3: ( '(' (returnTypeRef= mutableTypeRef )? ')' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==34) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:548:4: '(' (returnTypeRef= mutableTypeRef )? ')'
                    {
                    char_literal45=(Token)match(input,34,FOLLOW_34_in_objCMethodDecl1097); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal45_tree = (Object)adaptor.create(char_literal45);
                    adaptor.addChild(root_0, char_literal45_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:549:18: (returnTypeRef= mutableTypeRef )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==IDENTIFIER||LA25_0==30||(LA25_0>=48 && LA25_0<=50)||LA25_0==60) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: returnTypeRef= mutableTypeRef
                            {
                            pushFollow(FOLLOW_mutableTypeRef_in_objCMethodDecl1105);
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
                    char_literal46=(Token)match(input,35,FOLLOW_35_in_objCMethodDecl1113); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal46_tree = (Object)adaptor.create(char_literal46);
                    adaptor.addChild(root_0, char_literal46_tree);
                    }

                    }
                    break;

            }

            methodName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1124); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            methodName_tree = (Object)adaptor.create(methodName);
            adaptor.addChild(root_0, methodName_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.function.setName((methodName!=null?methodName.getText():null)); 
              			retval.function.setCommentAfter(getCommentAfterOnSameLine(methodName.getTokenIndex()));
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:558:3: ( ':' '(' argType1= mutableTypeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==33) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:559:4: ':' '(' argType1= mutableTypeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )* ( ',' '...' )?
                    {
                    char_literal47=(Token)match(input,33,FOLLOW_33_in_objCMethodDecl1136); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal47_tree = (Object)adaptor.create(char_literal47);
                    adaptor.addChild(root_0, char_literal47_tree);
                    }
                    char_literal48=(Token)match(input,34,FOLLOW_34_in_objCMethodDecl1138); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal48_tree = (Object)adaptor.create(char_literal48);
                    adaptor.addChild(root_0, char_literal48_tree);
                    }
                    pushFollow(FOLLOW_mutableTypeRef_in_objCMethodDecl1142);
                    argType1=mutableTypeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, argType1.getTree());
                    char_literal49=(Token)match(input,35,FOLLOW_35_in_objCMethodDecl1144); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal49_tree = (Object)adaptor.create(char_literal49);
                    adaptor.addChild(root_0, char_literal49_tree);
                    }
                    argName1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1148); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    argName1_tree = (Object)adaptor.create(argName1);
                    adaptor.addChild(root_0, argName1_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				Arg arg = new Arg((argName1!=null?argName1.getText():null), (argType1!=null?argType1.type:null));
                      				arg.setSelector((methodName!=null?methodName.getText():null));
                      				retval.function.addArg(arg);
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:564:4: (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==IDENTIFIER) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:565:5: sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER
                    	    {
                    	    sel=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1163); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    sel_tree = (Object)adaptor.create(sel);
                    	    adaptor.addChild(root_0, sel_tree);
                    	    }
                    	    char_literal50=(Token)match(input,33,FOLLOW_33_in_objCMethodDecl1165); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal50_tree = (Object)adaptor.create(char_literal50);
                    	    adaptor.addChild(root_0, char_literal50_tree);
                    	    }
                    	    char_literal51=(Token)match(input,34,FOLLOW_34_in_objCMethodDecl1172); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal51_tree = (Object)adaptor.create(char_literal51);
                    	    adaptor.addChild(root_0, char_literal51_tree);
                    	    }
                    	    pushFollow(FOLLOW_mutableTypeRef_in_objCMethodDecl1176);
                    	    argType=mutableTypeRef();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, argType.getTree());
                    	    char_literal52=(Token)match(input,35,FOLLOW_35_in_objCMethodDecl1178); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal52_tree = (Object)adaptor.create(char_literal52);
                    	    adaptor.addChild(root_0, char_literal52_tree);
                    	    }
                    	    argName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1187); if (state.failed) return retval;
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

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:573:4: ( ',' '...' )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==28) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:574:5: ',' '...'
                            {
                            char_literal53=(Token)match(input,28,FOLLOW_28_in_objCMethodDecl1206); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal53_tree = (Object)adaptor.create(char_literal53);
                            adaptor.addChild(root_0, char_literal53_tree);
                            }
                            string_literal54=(Token)match(input,44,FOLLOW_44_in_objCMethodDecl1208); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal54_tree = (Object)adaptor.create(string_literal54);
                            adaptor.addChild(root_0, string_literal54_tree);
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

            char_literal55=(Token)match(input,25,FOLLOW_25_in_objCMethodDecl1225); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal55_tree = (Object)adaptor.create(char_literal55);
            adaptor.addChild(root_0, char_literal55_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:582:1: structBody returns [Struct struct] : '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' ;
    public final ObjCppParser.structBody_return structBody() throws RecognitionException {
        ObjCppParser.structBody_return retval = new ObjCppParser.structBody_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal56=null;
        Token string_literal57=null;
        Token string_literal58=null;
        Token string_literal59=null;
        Token char_literal60=null;
        Token char_literal62=null;
        ObjCppParser.declaration_return declaration61 = null;


        Object char_literal56_tree=null;
        Object string_literal57_tree=null;
        Object string_literal58_tree=null;
        Object string_literal59_tree=null;
        Object char_literal60_tree=null;
        Object char_literal62_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:583:2: ( '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:584:3: '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               
              			retval.struct = new Struct();
              			retval.struct.setForwardDeclaration(false); 
              		
            }
            char_literal56=(Token)match(input,23,FOLLOW_23_in_structBody1246); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal56_tree = (Object)adaptor.create(char_literal56);
            adaptor.addChild(root_0, char_literal56_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:589:4: ( ( 'public' | 'private' | 'protected' ) ':' | declaration )*
            loop31:
            do {
                int alt31=3;
                alt31 = dfa31.predict(input);
                switch (alt31) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:590:5: ( 'public' | 'private' | 'protected' ) ':'
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:590:5: ( 'public' | 'private' | 'protected' )
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
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:591:6: 'public'
            	            {
            	            string_literal57=(Token)match(input,45,FOLLOW_45_in_structBody1264); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal57_tree = (Object)adaptor.create(string_literal57);
            	            adaptor.addChild(root_0, string_literal57_tree);
            	            }
            	            if ( state.backtracking==0 ) {
            	               retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Public); 
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:592:6: 'private'
            	            {
            	            string_literal58=(Token)match(input,46,FOLLOW_46_in_structBody1276); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal58_tree = (Object)adaptor.create(string_literal58);
            	            adaptor.addChild(root_0, string_literal58_tree);
            	            }
            	            if ( state.backtracking==0 ) {
            	               retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Private); 
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:593:6: 'protected'
            	            {
            	            string_literal59=(Token)match(input,47,FOLLOW_47_in_structBody1288); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal59_tree = (Object)adaptor.create(string_literal59);
            	            adaptor.addChild(root_0, string_literal59_tree);
            	            }
            	            if ( state.backtracking==0 ) {
            	               retval.struct.setNextMemberVisibility(Struct.MemberVisibility.Protected); 
            	            }

            	            }
            	            break;

            	    }

            	    char_literal60=(Token)match(input,33,FOLLOW_33_in_structBody1299); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal60_tree = (Object)adaptor.create(char_literal60);
            	    adaptor.addChild(root_0, char_literal60_tree);
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:595:5: declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_structBody1307);
            	    declaration61=declaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration61.getTree());
            	    if ( state.backtracking==0 ) {

            	      					retval.struct.addDeclarations((declaration61!=null?declaration61.declarations:null));
            	      				
            	    }

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            char_literal62=(Token)match(input,24,FOLLOW_24_in_structBody1319); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal62_tree = (Object)adaptor.create(char_literal62);
            adaptor.addChild(root_0, char_literal62_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:602:1: structCore returns [Struct struct] : typeToken= ( 'struct' | 'class' | 'union' ) (m1= modifiers (ab= structBody | tag= IDENTIFIER ( (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody ) | ) ) ) ;
    public final ObjCppParser.structCore_return structCore() throws RecognitionException {
        Symbols_stack.push(new Symbols_scope());

        ObjCppParser.structCore_return retval = new ObjCppParser.structCore_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token typeToken=null;
        Token tag=null;
        Token parent=null;
        Token char_literal63=null;
        Token string_literal64=null;
        ObjCppParser.modifiers_return m1 = null;

        ObjCppParser.structBody_return ab = null;

        ObjCppParser.modifiers_return m2 = null;

        ObjCppParser.structBody_return nb = null;


        Object typeToken_tree=null;
        Object tag_tree=null;
        Object parent_tree=null;
        Object char_literal63_tree=null;
        Object string_literal64_tree=null;


        	((Symbols_scope)Symbols_stack.peek()).typeIdentifiers = new HashSet<String>();
        	List<Modifier> modifiers = new ArrayList<Modifier>();

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:608:2: (typeToken= ( 'struct' | 'class' | 'union' ) (m1= modifiers (ab= structBody | tag= IDENTIFIER ( (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody ) | ) ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:609:3: typeToken= ( 'struct' | 'class' | 'union' ) (m1= modifiers (ab= structBody | tag= IDENTIFIER ( (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody ) | ) ) )
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:610:3: (m1= modifiers (ab= structBody | tag= IDENTIFIER ( (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody ) | ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:611:4: m1= modifiers (ab= structBody | tag= IDENTIFIER ( (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody ) | ) )
            {
            pushFollow(FOLLOW_modifiers_in_structCore1376);
            m1=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, m1.getTree());
            if ( state.backtracking==0 ) {
               modifiers.addAll((m1!=null?m1.modifiers:null)); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:612:4: (ab= structBody | tag= IDENTIFIER ( (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody ) | ) )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:613:5: ab= structBody
                    {
                    pushFollow(FOLLOW_structBody_in_structCore1391);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:617:5: tag= IDENTIFIER ( (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody ) | )
                    {
                    tag=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_structCore1403); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    tag_tree = (Object)adaptor.create(tag);
                    adaptor.addChild(root_0, tag_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:618:5: ( (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody ) | )
                    int alt34=2;
                    alt34 = dfa34.predict(input);
                    switch (alt34) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:619:6: (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody )
                            {
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:619:6: (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody )
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:620:7: m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody
                            {
                            pushFollow(FOLLOW_modifiers_in_structCore1427);
                            m2=modifiers();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, m2.getTree());
                            if ( state.backtracking==0 ) {
                               modifiers.addAll((m2!=null?m2.modifiers:null)); 
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:621:7: ( ':' ( 'public' )? parent= IDENTIFIER )?
                            int alt33=2;
                            int LA33_0 = input.LA(1);

                            if ( (LA33_0==33) ) {
                                alt33=1;
                            }
                            switch (alt33) {
                                case 1 :
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:622:8: ':' ( 'public' )? parent= IDENTIFIER
                                    {
                                    char_literal63=(Token)match(input,33,FOLLOW_33_in_structCore1446); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    char_literal63_tree = (Object)adaptor.create(char_literal63);
                                    adaptor.addChild(root_0, char_literal63_tree);
                                    }
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:623:8: ( 'public' )?
                                    int alt32=2;
                                    int LA32_0 = input.LA(1);

                                    if ( (LA32_0==45) ) {
                                        alt32=1;
                                    }
                                    switch (alt32) {
                                        case 1 :
                                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: 'public'
                                            {
                                            string_literal64=(Token)match(input,45,FOLLOW_45_in_structCore1455); if (state.failed) return retval;
                                            if ( state.backtracking==0 ) {
                                            string_literal64_tree = (Object)adaptor.create(string_literal64);
                                            adaptor.addChild(root_0, string_literal64_tree);
                                            }

                                            }
                                            break;

                                    }

                                    parent=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_structCore1467); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    parent_tree = (Object)adaptor.create(parent);
                                    adaptor.addChild(root_0, parent_tree);
                                    }

                                    }
                                    break;

                            }

                            pushFollow(FOLLOW_structBody_in_structCore1487);
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
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:632:10: 
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
              			defineTypeIdentifierInParentScope(retval.struct.getTag());
              		
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

    public static class functionName_return extends ParserRuleReturnScope {
        public String name;
        public String file;
        public int line;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionName"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:663:1: functionName returns [String name, String file, int line] : (pre= '~' )? n= IDENTIFIER (post= ( binaryOp | unaryOp | assignmentOp ) )? ;
    public final ObjCppParser.functionName_return functionName() throws RecognitionException {
        ObjCppParser.functionName_return retval = new ObjCppParser.functionName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token pre=null;
        Token n=null;
        Token post=null;
        ObjCppParser.binaryOp_return binaryOp65 = null;

        ObjCppParser.unaryOp_return unaryOp66 = null;

        ObjCppParser.assignmentOp_return assignmentOp67 = null;


        Object pre_tree=null;
        Object n_tree=null;
        Object post_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:664:2: ( (pre= '~' )? n= IDENTIFIER (post= ( binaryOp | unaryOp | assignmentOp ) )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:665:3: (pre= '~' )? n= IDENTIFIER (post= ( binaryOp | unaryOp | assignmentOp ) )?
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:665:6: (pre= '~' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==51) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: pre= '~'
                    {
                    pre=(Token)match(input,51,FOLLOW_51_in_functionName1540); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    pre_tree = (Object)adaptor.create(pre);
                    adaptor.addChild(root_0, pre_tree);
                    }

                    }
                    break;

            }

            n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionName1545); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:665:29: (post= ( binaryOp | unaryOp | assignmentOp ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==29||(LA38_0>=36 && LA38_0<=37)||(LA38_0>=42 && LA38_0<=43)||LA38_0==51||(LA38_0>=53 && LA38_0<=54)||LA38_0==58||(LA38_0>=61 && LA38_0<=72)||(LA38_0>=75 && LA38_0<=84)||(LA38_0>=87 && LA38_0<=89)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: post= ( binaryOp | unaryOp | assignmentOp )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:665:30: ( binaryOp | unaryOp | assignmentOp )
                    int alt37=3;
                    switch ( input.LA(1) ) {
                    case 43:
                    case 53:
                    case 54:
                        {
                        int LA37_1 = input.LA(2);

                        if ( (synpred53_ObjCpp()) ) {
                            alt37=1;
                        }
                        else if ( (synpred54_ObjCpp()) ) {
                            alt37=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 37, 1, input);

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
                        alt37=1;
                        }
                        break;
                    case 51:
                    case 87:
                    case 88:
                    case 89:
                        {
                        alt37=2;
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
                        alt37=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 37, 0, input);

                        throw nvae;
                    }

                    switch (alt37) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:665:31: binaryOp
                            {
                            pushFollow(FOLLOW_binaryOp_in_functionName1550);
                            binaryOp65=binaryOp();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, binaryOp65.getTree());

                            }
                            break;
                        case 2 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:665:42: unaryOp
                            {
                            pushFollow(FOLLOW_unaryOp_in_functionName1554);
                            unaryOp66=unaryOp();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryOp66.getTree());

                            }
                            break;
                        case 3 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:665:52: assignmentOp
                            {
                            pushFollow(FOLLOW_assignmentOp_in_functionName1558);
                            assignmentOp67=assignmentOp();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentOp67.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               
              			retval.name = (n!=null?n.getText():null);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:683:1: functionDeclaration returns [Function function] : preMods1= modifiers (returnTypeRef= mutableTypeRef )? preMods2= modifiers functionName argList ({...}?ct= IDENTIFIER | ) postMods= modifiers ( ';' | statementsBlock ) ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:688:2: (preMods1= modifiers (returnTypeRef= mutableTypeRef )? preMods2= modifiers functionName argList ({...}?ct= IDENTIFIER | ) postMods= modifiers ( ';' | statementsBlock ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:688:4: preMods1= modifiers (returnTypeRef= mutableTypeRef )? preMods2= modifiers functionName argList ({...}?ct= IDENTIFIER | ) postMods= modifiers ( ';' | statementsBlock )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               	
              			retval.function = mark(new Function(), -1);
              			retval.function.setType(Function.Type.CFunction);
              		
            }
            pushFollow(FOLLOW_modifiers_in_functionDeclaration1604);
            preMods1=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, preMods1.getTree());
            if ( state.backtracking==0 ) {
               retval.function.addModifiers((preMods1!=null?preMods1.modifiers:null)); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:698:16: (returnTypeRef= mutableTypeRef )?
            int alt39=2;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: returnTypeRef= mutableTypeRef
                    {
                    pushFollow(FOLLOW_mutableTypeRef_in_functionDeclaration1612);
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
            pushFollow(FOLLOW_modifiers_in_functionDeclaration1621);
            preMods2=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, preMods2.getTree());
            if ( state.backtracking==0 ) {
               retval.function.addModifiers((preMods2!=null?preMods2.modifiers:null)); 
            }
            pushFollow(FOLLOW_functionName_in_functionDeclaration1627);
            functionName68=functionName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, functionName68.getTree());
            if ( state.backtracking==0 ) {

              			retval.function.setName((functionName68!=null?functionName68.name:null)); 
              			retval.function.setElementFile((functionName68!=null?functionName68.file:null));
              			retval.function.setElementLine((functionName68!=null?functionName68.line:0));
              		
            }
            pushFollow(FOLLOW_argList_in_functionDeclaration1633);
            argList69=argList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, argList69.getTree());
            if ( state.backtracking==0 ) {

              			retval.function.setArgs((argList69!=null?argList69.args:null));
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:710:3: ({...}?ct= IDENTIFIER | )
            int alt40=2;
            alt40 = dfa40.predict(input);
            switch (alt40) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:710:4: {...}?ct= IDENTIFIER
                    {
                    if ( !(( next("const", "__const") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "functionDeclaration", " next(\"const\", \"__const\") ");
                    }
                    ct=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionDeclaration1644); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:713:6: 
                    {
                    }
                    break;

            }

            pushFollow(FOLLOW_modifiers_in_functionDeclaration1655);
            postMods=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, postMods.getTree());
            if ( state.backtracking==0 ) {

              			for (Modifier m : (postMods!=null?postMods.modifiers:null))
              				retval.function.addModifiers(m);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:718:3: ( ';' | statementsBlock )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:719:4: ';'
                    {
                    char_literal70=(Token)match(input,25,FOLLOW_25_in_functionDeclaration1667); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal70_tree = (Object)adaptor.create(char_literal70);
                    adaptor.addChild(root_0, char_literal70_tree);
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:720:4: statementsBlock
                    {
                    pushFollow(FOLLOW_statementsBlock_in_functionDeclaration1674);
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

    public static class modifier_return extends ParserRuleReturnScope {
        public Modifier modifier;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "modifier"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:726:1: modifier returns [Modifier modifier] : {...}?m= IDENTIFIER ;
    public final ObjCppParser.modifier_return modifier() throws RecognitionException {
        ObjCppParser.modifier_return retval = new ObjCppParser.modifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token m=null;

        Object m_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:727:2: ({...}?m= IDENTIFIER )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:727:4: {...}?m= IDENTIFIER
            {
            root_0 = (Object)adaptor.nil();

            if ( !(( Modifier.parseModifier(next()) != null )) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "modifier", " Modifier.parseModifier(next()) != null ");
            }
            m=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier1699); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            m_tree = (Object)adaptor.create(m);
            adaptor.addChild(root_0, m_tree);
            }
            if ( state.backtracking==0 ) {

              			retval.modifier = Modifier.parseModifier((m!=null?m.getText():null));
              		
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

    public static class modifiers_return extends ParserRuleReturnScope {
        public List<Modifier> modifiers;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "modifiers"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:738:1: modifiers returns [List<Modifier> modifiers] : ( anyModifier | );
    public final ObjCppParser.modifiers_return modifiers() throws RecognitionException {
        ObjCppParser.modifiers_return retval = new ObjCppParser.modifiers_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.anyModifier_return anyModifier72 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:739:2: ( anyModifier | )
            int alt42=2;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:739:5: anyModifier
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_anyModifier_in_modifiers1719);
                    anyModifier72=anyModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, anyModifier72.getTree());
                    if ( state.backtracking==0 ) {

                      			retval.modifiers = (anyModifier72!=null?anyModifier72.modifiers:null);
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:742:3: 
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( state.backtracking==0 ) {

                      			retval.modifiers = new ArrayList<Modifier>();
                      		
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
    // $ANTLR end "modifiers"

    public static class anyModifier_return extends ParserRuleReturnScope {
        public List<Modifier> modifiers;
        public String asmName;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "anyModifier"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:747:1: anyModifier returns [List<Modifier> modifiers, String asmName] : ({...}? IDENTIFIER ex= STRING | modifier | {...}? IDENTIFIER '(' 'return' binaryOp expression ')' | {...}? IDENTIFIER '(' expression ')' | {...}? IDENTIFIER '(' ( (an= STRING )* | extendedModifiers ) ')' ) ;
    public final ObjCppParser.anyModifier_return anyModifier() throws RecognitionException {
        ObjCppParser.anyModifier_return retval = new ObjCppParser.anyModifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ex=null;
        Token an=null;
        Token IDENTIFIER73=null;
        Token IDENTIFIER75=null;
        Token char_literal76=null;
        Token string_literal77=null;
        Token char_literal80=null;
        Token IDENTIFIER81=null;
        Token char_literal82=null;
        Token char_literal84=null;
        Token IDENTIFIER85=null;
        Token char_literal86=null;
        Token char_literal88=null;
        ObjCppParser.modifier_return modifier74 = null;

        ObjCppParser.binaryOp_return binaryOp78 = null;

        ObjCppParser.expression_return expression79 = null;

        ObjCppParser.expression_return expression83 = null;

        ObjCppParser.extendedModifiers_return extendedModifiers87 = null;


        Object ex_tree=null;
        Object an_tree=null;
        Object IDENTIFIER73_tree=null;
        Object IDENTIFIER75_tree=null;
        Object char_literal76_tree=null;
        Object string_literal77_tree=null;
        Object char_literal80_tree=null;
        Object IDENTIFIER81_tree=null;
        Object char_literal82_tree=null;
        Object char_literal84_tree=null;
        Object IDENTIFIER85_tree=null;
        Object char_literal86_tree=null;
        Object char_literal88_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:748:2: ( ({...}? IDENTIFIER ex= STRING | modifier | {...}? IDENTIFIER '(' 'return' binaryOp expression ')' | {...}? IDENTIFIER '(' expression ')' | {...}? IDENTIFIER '(' ( (an= STRING )* | extendedModifiers ) ')' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:749:3: ({...}? IDENTIFIER ex= STRING | modifier | {...}? IDENTIFIER '(' 'return' binaryOp expression ')' | {...}? IDENTIFIER '(' expression ')' | {...}? IDENTIFIER '(' ( (an= STRING )* | extendedModifiers ) ')' )
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:750:3: ({...}? IDENTIFIER ex= STRING | modifier | {...}? IDENTIFIER '(' 'return' binaryOp expression ')' | {...}? IDENTIFIER '(' expression ')' | {...}? IDENTIFIER '(' ( (an= STRING )* | extendedModifiers ) ')' )
            int alt45=5;
            alt45 = dfa45.predict(input);
            switch (alt45) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:751:4: {...}? IDENTIFIER ex= STRING
                    {
                    if ( !(( next("extern") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "anyModifier", " next(\"extern\") ");
                    }
                    IDENTIFIER73=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_anyModifier1755); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER73_tree = (Object)adaptor.create(IDENTIFIER73);
                    adaptor.addChild(root_0, IDENTIFIER73_tree);
                    }
                    ex=(Token)match(input,STRING,FOLLOW_STRING_in_anyModifier1759); if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:754:4: modifier
                    {
                    pushFollow(FOLLOW_modifier_in_anyModifier1768);
                    modifier74=modifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, modifier74.getTree());
                    if ( state.backtracking==0 ) {

                      				retval.modifiers.add((modifier74!=null?modifier74.modifier:null));
                      			
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:757:4: {...}? IDENTIFIER '(' 'return' binaryOp expression ')'
                    {
                    if ( !(( next("__success") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "anyModifier", " next(\"__success\") ");
                    }
                    IDENTIFIER75=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_anyModifier1783); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER75_tree = (Object)adaptor.create(IDENTIFIER75);
                    adaptor.addChild(root_0, IDENTIFIER75_tree);
                    }
                    char_literal76=(Token)match(input,34,FOLLOW_34_in_anyModifier1785); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal76_tree = (Object)adaptor.create(char_literal76);
                    adaptor.addChild(root_0, char_literal76_tree);
                    }
                    string_literal77=(Token)match(input,52,FOLLOW_52_in_anyModifier1787); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal77_tree = (Object)adaptor.create(string_literal77);
                    adaptor.addChild(root_0, string_literal77_tree);
                    }
                    pushFollow(FOLLOW_binaryOp_in_anyModifier1789);
                    binaryOp78=binaryOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, binaryOp78.getTree());
                    pushFollow(FOLLOW_expression_in_anyModifier1791);
                    expression79=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression79.getTree());
                    char_literal80=(Token)match(input,35,FOLLOW_35_in_anyModifier1794); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal80_tree = (Object)adaptor.create(char_literal80);
                    adaptor.addChild(root_0, char_literal80_tree);
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:761:4: {...}? IDENTIFIER '(' expression ')'
                    {
                    if ( !(( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "anyModifier", " next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ");
                    }
                    IDENTIFIER81=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_anyModifier1816); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER81_tree = (Object)adaptor.create(IDENTIFIER81);
                    adaptor.addChild(root_0, IDENTIFIER81_tree);
                    }
                    char_literal82=(Token)match(input,34,FOLLOW_34_in_anyModifier1818); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal82_tree = (Object)adaptor.create(char_literal82);
                    adaptor.addChild(root_0, char_literal82_tree);
                    }
                    pushFollow(FOLLOW_expression_in_anyModifier1820);
                    expression83=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression83.getTree());
                    char_literal84=(Token)match(input,35,FOLLOW_35_in_anyModifier1822); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal84_tree = (Object)adaptor.create(char_literal84);
                    adaptor.addChild(root_0, char_literal84_tree);
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:764:4: {...}? IDENTIFIER '(' ( (an= STRING )* | extendedModifiers ) ')'
                    {
                    if ( !(( next("__declspec", "__attribute__", "__asm") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "anyModifier", " next(\"__declspec\", \"__attribute__\", \"__asm\") ");
                    }
                    IDENTIFIER85=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_anyModifier1838); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER85_tree = (Object)adaptor.create(IDENTIFIER85);
                    adaptor.addChild(root_0, IDENTIFIER85_tree);
                    }
                    char_literal86=(Token)match(input,34,FOLLOW_34_in_anyModifier1843); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal86_tree = (Object)adaptor.create(char_literal86);
                    adaptor.addChild(root_0, char_literal86_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:766:8: ( (an= STRING )* | extendedModifiers )
                    int alt44=2;
                    alt44 = dfa44.predict(input);
                    switch (alt44) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:5: (an= STRING )*
                            {
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:5: (an= STRING )*
                            loop43:
                            do {
                                int alt43=2;
                                int LA43_0 = input.LA(1);

                                if ( (LA43_0==STRING) ) {
                                    alt43=1;
                                }


                                switch (alt43) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:7: an= STRING
                            	    {
                            	    an=(Token)match(input,STRING,FOLLOW_STRING_in_anyModifier1855); if (state.failed) return retval;
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
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:774:5: extendedModifiers
                            {
                            pushFollow(FOLLOW_extendedModifiers_in_anyModifier1868);
                            extendedModifiers87=extendedModifiers();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, extendedModifiers87.getTree());
                            if ( state.backtracking==0 ) {

                              					retval.modifiers.addAll((extendedModifiers87!=null?extendedModifiers87.modifiers:null));
                              				
                            }

                            }
                            break;

                    }

                    char_literal88=(Token)match(input,35,FOLLOW_35_in_anyModifier1877); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal88_tree = (Object)adaptor.create(char_literal88);
                    adaptor.addChild(root_0, char_literal88_tree);
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
    // $ANTLR end "anyModifier"

    public static class extendedModifiers_return extends ParserRuleReturnScope {
        public List<Modifier> modifiers;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "extendedModifiers"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:782:1: extendedModifiers returns [List<Modifier> modifiers] : ({...}?m= modifier () )* ;
    public final ObjCppParser.extendedModifiers_return extendedModifiers() throws RecognitionException {
        ObjCppParser.extendedModifiers_return retval = new ObjCppParser.extendedModifiers_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.modifier_return m = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:783:2: ( ({...}?m= modifier () )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:783:4: ({...}?m= modifier () )*
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:784:3: ({...}?m= modifier () )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==IDENTIFIER) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:785:4: {...}?m= modifier ()
            	    {
            	    if ( !(( next(Modifier.Kind.Extended) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        throw new FailedPredicateException(input, "extendedModifiers", " next(Modifier.Kind.Extended) ");
            	    }
            	    pushFollow(FOLLOW_modifier_in_extendedModifiers1910);
            	    m=modifier();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, m.getTree());
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:786:4: ()
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:787:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					retval.modifiers.add((m!=null?m.modifier:null));
            	      				
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:797:1: argDef returns [Arg arg] : ( ({...}?sm= modifier | {...}?tm= modifier )* (tr= mutableTypeRef ) ( ( declarator )? ) ( '=' expression )? | '...' );
    public final ObjCppParser.argDef_return argDef() throws RecognitionException {
        ObjCppParser.argDef_return retval = new ObjCppParser.argDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal90=null;
        Token string_literal92=null;
        ObjCppParser.modifier_return sm = null;

        ObjCppParser.modifier_return tm = null;

        ObjCppParser.mutableTypeRef_return tr = null;

        ObjCppParser.declarator_return declarator89 = null;

        ObjCppParser.expression_return expression91 = null;


        Object char_literal90_tree=null;
        Object string_literal92_tree=null;


        	List<Modifier> stoMods = new ArrayList<Modifier>(), typMods = new ArrayList<Modifier>();

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:801:2: ( ({...}?sm= modifier | {...}?tm= modifier )* (tr= mutableTypeRef ) ( ( declarator )? ) ( '=' expression )? | '...' )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==IDENTIFIER||LA50_0==30||(LA50_0>=48 && LA50_0<=50)||LA50_0==60) ) {
                alt50=1;
            }
            else if ( (LA50_0==44) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:801:4: ({...}?sm= modifier | {...}?tm= modifier )* (tr= mutableTypeRef ) ( ( declarator )? ) ( '=' expression )?
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( state.backtracking==0 ) {
                       
                      			retval.arg = new Arg(); 
                      			int i = getTokenStream().index() + 1;
                      			retval.arg.setCommentBefore(getCommentBefore(i));
                      			retval.arg.setCommentAfter(getCommentAfterOnSameLine(i));
                      		
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:807:3: ({...}?sm= modifier | {...}?tm= modifier )*
                    loop47:
                    do {
                        int alt47=3;
                        alt47 = dfa47.predict(input);
                        switch (alt47) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:808:4: {...}?sm= modifier
                    	    {
                    	    if ( !(( next(Modifier.Kind.StorageClassSpecifier) )) ) {
                    	        if (state.backtracking>0) {state.failed=true; return retval;}
                    	        throw new FailedPredicateException(input, "argDef", " next(Modifier.Kind.StorageClassSpecifier) ");
                    	    }
                    	    pushFollow(FOLLOW_modifier_in_argDef1969);
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
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:810:4: {...}?tm= modifier
                    	    {
                    	    if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
                    	        if (state.backtracking>0) {state.failed=true; return retval;}
                    	        throw new FailedPredicateException(input, "argDef", " next(Modifier.Kind.TypeQualifier) ");
                    	    }
                    	    pushFollow(FOLLOW_modifier_in_argDef1986);
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
                    	    break loop47;
                        }
                    } while (true);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:813:3: (tr= mutableTypeRef )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:814:4: tr= mutableTypeRef
                    {
                    pushFollow(FOLLOW_mutableTypeRef_in_argDef2004);
                    tr=mutableTypeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tr.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				if ((tr!=null?tr.type:null) != null) {
                      					(tr!=null?tr.type:null).addModifiers(typMods);
                      					(tr!=null?tr.type:null).addModifiers(stoMods);
                      					retval.arg.setValueType((tr!=null?tr.type:null)); 
                      				}
                      			
                    }

                    }

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:822:3: ( ( declarator )? )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:823:4: ( declarator )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:823:4: ( declarator )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==IDENTIFIER||LA48_0==34||(LA48_0>=53 && LA48_0<=54)||LA48_0==58) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: declarator
                            {
                            pushFollow(FOLLOW_declarator_in_argDef2019);
                            declarator89=declarator();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, declarator89.getTree());

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       
                      				if ((declarator89!=null?declarator89.declarator:null) != null)
                      					retval.arg.setDeclarator((declarator89!=null?declarator89.declarator:null)); 
                      				else if (retval.arg.getValueType() instanceof FunctionSignature) {
                      					FunctionSignature fs = (FunctionSignature)retval.arg.getValueType();
                      					if (fs != null && fs.getFunction() != null) {
                      						retval.arg.setName(fs.getFunction().getName());
                      						fs.getFunction().setName(null);
                      					}
                      				}
                      			
                    }

                    }

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:835:3: ( '=' expression )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==29) ) {
                        alt49=1;
                    }
                    switch (alt49) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:835:4: '=' expression
                            {
                            char_literal90=(Token)match(input,29,FOLLOW_29_in_argDef2031); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal90_tree = (Object)adaptor.create(char_literal90);
                            adaptor.addChild(root_0, char_literal90_tree);
                            }
                            pushFollow(FOLLOW_expression_in_argDef2033);
                            expression91=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression91.getTree());
                            if ( state.backtracking==0 ) {

                              			retval.arg.setDefaultValue((expression91!=null?expression91.expr:null));
                              		
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:839:3: '...'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal92=(Token)match(input,44,FOLLOW_44_in_argDef2047); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal92_tree = (Object)adaptor.create(string_literal92);
                    adaptor.addChild(root_0, string_literal92_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:844:1: typeMutator returns [TypeMutator mutator] : (t= ( '*' | '&' ) | '[' ']' );
    public final ObjCppParser.typeMutator_return typeMutator() throws RecognitionException {
        ObjCppParser.typeMutator_return retval = new ObjCppParser.typeMutator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token t=null;
        Token char_literal93=null;
        Token char_literal94=null;

        Object t_tree=null;
        Object char_literal93_tree=null;
        Object char_literal94_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:845:2: (t= ( '*' | '&' ) | '[' ']' )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=53 && LA51_0<=54)) ) {
                alt51=1;
            }
            else if ( (LA51_0==55) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:846:3: t= ( '*' | '&' )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:849:3: '[' ']'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal93=(Token)match(input,55,FOLLOW_55_in_typeMutator2083); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal93_tree = (Object)adaptor.create(char_literal93);
                    adaptor.addChild(root_0, char_literal93_tree);
                    }
                    char_literal94=(Token)match(input,56,FOLLOW_56_in_typeMutator2085); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal94_tree = (Object)adaptor.create(char_literal94);
                    adaptor.addChild(root_0, char_literal94_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:852:1: arrayTypeMutator returns [TypeMutator mutator] : '[' expression ']' ;
    public final ObjCppParser.arrayTypeMutator_return arrayTypeMutator() throws RecognitionException {
        ObjCppParser.arrayTypeMutator_return retval = new ObjCppParser.arrayTypeMutator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal95=null;
        Token char_literal97=null;
        ObjCppParser.expression_return expression96 = null;


        Object char_literal95_tree=null;
        Object char_literal97_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:853:2: ( '[' expression ']' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:853:4: '[' expression ']'
            {
            root_0 = (Object)adaptor.nil();

            char_literal95=(Token)match(input,55,FOLLOW_55_in_arrayTypeMutator2103); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal95_tree = (Object)adaptor.create(char_literal95);
            adaptor.addChild(root_0, char_literal95_tree);
            }
            pushFollow(FOLLOW_expression_in_arrayTypeMutator2109);
            expression96=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression96.getTree());
            if ( state.backtracking==0 ) {

              				retval.mutator = TypeMutator.array((expression96!=null?expression96.expr:null)); 
              			
            }
            char_literal97=(Token)match(input,56,FOLLOW_56_in_arrayTypeMutator2118); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal97_tree = (Object)adaptor.create(char_literal97);
            adaptor.addChild(root_0, char_literal97_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:860:1: templateDef : ( 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' structCore | functionDeclaration );
    public final ObjCppParser.templateDef_return templateDef() throws RecognitionException {
        ObjCppParser.templateDef_return retval = new ObjCppParser.templateDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal98=null;
        Token char_literal99=null;
        Token char_literal101=null;
        Token char_literal103=null;
        ObjCppParser.templateArgDecl_return templateArgDecl100 = null;

        ObjCppParser.templateArgDecl_return templateArgDecl102 = null;

        ObjCppParser.structCore_return structCore104 = null;

        ObjCppParser.functionDeclaration_return functionDeclaration105 = null;


        Object string_literal98_tree=null;
        Object char_literal99_tree=null;
        Object char_literal101_tree=null;
        Object char_literal103_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:861:2: ( 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' structCore | functionDeclaration )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==57) ) {
                alt54=1;
            }
            else if ( (LA54_0==IDENTIFIER||LA54_0==30||(LA54_0>=48 && LA54_0<=51)||LA54_0==60) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:861:4: 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' structCore
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal98=(Token)match(input,57,FOLLOW_57_in_templateDef2130); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal98_tree = (Object)adaptor.create(string_literal98);
                    adaptor.addChild(root_0, string_literal98_tree);
                    }
                    char_literal99=(Token)match(input,36,FOLLOW_36_in_templateDef2132); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal99_tree = (Object)adaptor.create(char_literal99);
                    adaptor.addChild(root_0, char_literal99_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:861:19: ( templateArgDecl ( ',' templateArgDecl )* )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==IDENTIFIER||LA53_0==30||(LA53_0>=48 && LA53_0<=50)||LA53_0==60) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:861:20: templateArgDecl ( ',' templateArgDecl )*
                            {
                            pushFollow(FOLLOW_templateArgDecl_in_templateDef2135);
                            templateArgDecl100=templateArgDecl();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, templateArgDecl100.getTree());
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:861:36: ( ',' templateArgDecl )*
                            loop52:
                            do {
                                int alt52=2;
                                int LA52_0 = input.LA(1);

                                if ( (LA52_0==28) ) {
                                    alt52=1;
                                }


                                switch (alt52) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:861:37: ',' templateArgDecl
                            	    {
                            	    char_literal101=(Token)match(input,28,FOLLOW_28_in_templateDef2138); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    char_literal101_tree = (Object)adaptor.create(char_literal101);
                            	    adaptor.addChild(root_0, char_literal101_tree);
                            	    }
                            	    pushFollow(FOLLOW_templateArgDecl_in_templateDef2140);
                            	    templateArgDecl102=templateArgDecl();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, templateArgDecl102.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop52;
                                }
                            } while (true);


                            }
                            break;

                    }

                    char_literal103=(Token)match(input,37,FOLLOW_37_in_templateDef2147); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal103_tree = (Object)adaptor.create(char_literal103);
                    adaptor.addChild(root_0, char_literal103_tree);
                    }
                    pushFollow(FOLLOW_structCore_in_templateDef2151);
                    structCore104=structCore();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, structCore104.getTree());

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:862:16: functionDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_functionDeclaration_in_templateDef2155);
                    functionDeclaration105=functionDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionDeclaration105.getTree());

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:865:1: templateArgDecl : mutableTypeRef ( '=' constant )? ;
    public final ObjCppParser.templateArgDecl_return templateArgDecl() throws RecognitionException {
        ObjCppParser.templateArgDecl_return retval = new ObjCppParser.templateArgDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal107=null;
        ObjCppParser.mutableTypeRef_return mutableTypeRef106 = null;

        ObjCppParser.constant_return constant108 = null;


        Object char_literal107_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:866:2: ( mutableTypeRef ( '=' constant )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:866:4: mutableTypeRef ( '=' constant )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_mutableTypeRef_in_templateArgDecl2167);
            mutableTypeRef106=mutableTypeRef();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mutableTypeRef106.getTree());
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:866:19: ( '=' constant )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==29) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:866:20: '=' constant
                    {
                    char_literal107=(Token)match(input,29,FOLLOW_29_in_templateArgDecl2170); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal107_tree = (Object)adaptor.create(char_literal107);
                    adaptor.addChild(root_0, char_literal107_tree);
                    }
                    pushFollow(FOLLOW_constant_in_templateArgDecl2172);
                    constant108=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant108.getTree());

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:869:1: functionSignatureSuffix returns [FunctionSignature signature] : tk= '(' m1= modifiers '*' m2= modifiers ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' ;
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
        ObjCppParser.modifiers_return m1 = null;

        ObjCppParser.modifiers_return m2 = null;

        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        Object tk_tree=null;
        Object char_literal109_tree=null;
        Object IDENTIFIER110_tree=null;
        Object char_literal111_tree=null;
        Object char_literal112_tree=null;
        Object char_literal113_tree=null;
        Object char_literal114_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:870:2: (tk= '(' m1= modifiers '*' m2= modifiers ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:870:4: tk= '(' m1= modifiers '*' m2= modifiers ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')'
            {
            root_0 = (Object)adaptor.nil();

            tk=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffix2192); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tk_tree = (Object)adaptor.create(tk);
            adaptor.addChild(root_0, tk_tree);
            }
            pushFollow(FOLLOW_modifiers_in_functionSignatureSuffix2196);
            m1=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, m1.getTree());
            char_literal109=(Token)match(input,53,FOLLOW_53_in_functionSignatureSuffix2198); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal109_tree = (Object)adaptor.create(char_literal109);
            adaptor.addChild(root_0, char_literal109_tree);
            }
            pushFollow(FOLLOW_modifiers_in_functionSignatureSuffix2202);
            m2=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, m2.getTree());
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:870:41: ( IDENTIFIER )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==IDENTIFIER) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: IDENTIFIER
                    {
                    IDENTIFIER110=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionSignatureSuffix2204); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER110_tree = (Object)adaptor.create(IDENTIFIER110);
                    adaptor.addChild(root_0, IDENTIFIER110_tree);
                    }

                    }
                    break;

            }

            char_literal111=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffix2207); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal111_tree = (Object)adaptor.create(char_literal111);
            adaptor.addChild(root_0, char_literal111_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, (IDENTIFIER110!=null?IDENTIFIER110.getText():null), null)), getLine(tk));
              			retval.signature.getFunction().setType(Function.Type.CFunction);
              			retval.signature.getFunction().addModifiers((m1!=null?m1.modifiers:null));
              			retval.signature.getFunction().addModifiers((m2!=null?m2.modifiers:null));
              		
            }
            char_literal112=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffix2213); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal112_tree = (Object)adaptor.create(char_literal112);
            adaptor.addChild(root_0, char_literal112_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:876:7: (a1= argDef ( ',' ax= argDef )* )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==IDENTIFIER||LA58_0==30||LA58_0==44||(LA58_0>=48 && LA58_0<=50)||LA58_0==60) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:877:4: a1= argDef ( ',' ax= argDef )*
                    {
                    pushFollow(FOLLOW_argDef_in_functionSignatureSuffix2222);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					((FunctionSignature)retval.signature).getFunction().addArg((a1!=null?a1.arg:null)); 
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:881:4: ( ',' ax= argDef )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==28) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:882:5: ',' ax= argDef
                    	    {
                    	    char_literal113=(Token)match(input,28,FOLLOW_28_in_functionSignatureSuffix2235); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal113_tree = (Object)adaptor.create(char_literal113);
                    	    adaptor.addChild(root_0, char_literal113_tree);
                    	    }
                    	    pushFollow(FOLLOW_argDef_in_functionSignatureSuffix2244);
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

            char_literal114=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffix2259); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:890:1: functionSignatureSuffixNoName returns [FunctionSignature signature] : tk= '(' modifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' ;
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

        ObjCppParser.modifiers_return modifiers115 = null;


        Object tk_tree=null;
        Object char_literal116_tree=null;
        Object char_literal117_tree=null;
        Object char_literal118_tree=null;
        Object char_literal119_tree=null;
        Object char_literal120_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:891:2: (tk= '(' modifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:891:4: tk= '(' modifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')'
            {
            root_0 = (Object)adaptor.nil();

            tk=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffixNoName2276); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            tk_tree = (Object)adaptor.create(tk);
            adaptor.addChild(root_0, tk_tree);
            }
            pushFollow(FOLLOW_modifiers_in_functionSignatureSuffixNoName2278);
            modifiers115=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, modifiers115.getTree());
            char_literal116=(Token)match(input,53,FOLLOW_53_in_functionSignatureSuffixNoName2280); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal116_tree = (Object)adaptor.create(char_literal116);
            adaptor.addChild(root_0, char_literal116_tree);
            }
            char_literal117=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffixNoName2282); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal117_tree = (Object)adaptor.create(char_literal117);
            adaptor.addChild(root_0, char_literal117_tree);
            }
            if ( state.backtracking==0 ) {
               
              			retval.signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, null, null)), getLine(tk));
              			retval.signature.getFunction().setType(Function.Type.CFunction);
              			retval.signature.getFunction().addModifiers((modifiers115!=null?modifiers115.modifiers:null));
              		
            }
            char_literal118=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffixNoName2288); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal118_tree = (Object)adaptor.create(char_literal118);
            adaptor.addChild(root_0, char_literal118_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:896:7: (a1= argDef ( ',' ax= argDef )* )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==IDENTIFIER||LA60_0==30||LA60_0==44||(LA60_0>=48 && LA60_0<=50)||LA60_0==60) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:897:4: a1= argDef ( ',' ax= argDef )*
                    {
                    pushFollow(FOLLOW_argDef_in_functionSignatureSuffixNoName2297);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {
                       
                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					((FunctionSignature)retval.signature).getFunction().addArg((a1!=null?a1.arg:null)); 
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:901:4: ( ',' ax= argDef )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==28) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:902:5: ',' ax= argDef
                    	    {
                    	    char_literal119=(Token)match(input,28,FOLLOW_28_in_functionSignatureSuffixNoName2310); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal119_tree = (Object)adaptor.create(char_literal119);
                    	    adaptor.addChild(root_0, char_literal119_tree);
                    	    }
                    	    pushFollow(FOLLOW_argDef_in_functionSignatureSuffixNoName2319);
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

            char_literal120=(Token)match(input,35,FOLLOW_35_in_functionSignatureSuffixNoName2334); if (state.failed) return retval;
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

    public static class mutableTypeRef_return extends ParserRuleReturnScope {
        public TypeRef type;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mutableTypeRef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:910:1: mutableTypeRef returns [TypeRef type] options {k=4; } : ( typeRefCore ) ( ( typeMutator ) | ( functionSignatureSuffix ) )* ;
    public final ObjCppParser.mutableTypeRef_return mutableTypeRef() throws RecognitionException {
        ObjCppParser.mutableTypeRef_return retval = new ObjCppParser.mutableTypeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.typeRefCore_return typeRefCore121 = null;

        ObjCppParser.typeMutator_return typeMutator122 = null;

        ObjCppParser.functionSignatureSuffix_return functionSignatureSuffix123 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:912:2: ( ( typeRefCore ) ( ( typeMutator ) | ( functionSignatureSuffix ) )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:913:3: ( typeRefCore ) ( ( typeMutator ) | ( functionSignatureSuffix ) )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:913:3: ( typeRefCore )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:913:5: typeRefCore
            {
            pushFollow(FOLLOW_typeRefCore_in_mutableTypeRef2365);
            typeRefCore121=typeRefCore();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRefCore121.getTree());
            if ( state.backtracking==0 ) {
               
              			retval.type = (typeRefCore121!=null?typeRefCore121.type:null); 
              		
            }

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:916:3: ( ( typeMutator ) | ( functionSignatureSuffix ) )*
            loop61:
            do {
                int alt61=3;
                alt61 = dfa61.predict(input);
                switch (alt61) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:917:4: ( typeMutator )
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:917:4: ( typeMutator )
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:918:5: typeMutator
            	    {
            	    pushFollow(FOLLOW_typeMutator_in_mutableTypeRef2384);
            	    typeMutator122=typeMutator();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeMutator122.getTree());
            	    if ( state.backtracking==0 ) {

            	      					retval.type = (typeMutator122!=null?typeMutator122.mutator:null).mutateType(retval.type);
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:922:4: ( functionSignatureSuffix )
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:922:4: ( functionSignatureSuffix )
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:923:5: functionSignatureSuffix
            	    {
            	    pushFollow(FOLLOW_functionSignatureSuffix_in_mutableTypeRef2404);
            	    functionSignatureSuffix123=functionSignatureSuffix();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionSignatureSuffix123.getTree());
            	    if ( state.backtracking==0 ) {
            	       
            	      					(functionSignatureSuffix123!=null?functionSignatureSuffix123.signature:null).getFunction().setValueType(retval.type); 
            	      					retval.type = (functionSignatureSuffix123!=null?functionSignatureSuffix123.signature:null);
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop61;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:931:1: nonMutableTypeRef returns [TypeRef type] : typeRefCore ( ( typeMutator )* ( functionSignatureSuffix ) )* ;
    public final ObjCppParser.nonMutableTypeRef_return nonMutableTypeRef() throws RecognitionException {
        ObjCppParser.nonMutableTypeRef_return retval = new ObjCppParser.nonMutableTypeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.typeRefCore_return typeRefCore124 = null;

        ObjCppParser.typeMutator_return typeMutator125 = null;

        ObjCppParser.functionSignatureSuffix_return functionSignatureSuffix126 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:933:2: ( typeRefCore ( ( typeMutator )* ( functionSignatureSuffix ) )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:934:3: typeRefCore ( ( typeMutator )* ( functionSignatureSuffix ) )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_typeRefCore_in_nonMutableTypeRef2436);
            typeRefCore124=typeRefCore();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, typeRefCore124.getTree());
            if ( state.backtracking==0 ) {
               
              			retval.type = (typeRefCore124!=null?typeRefCore124.type:null); 
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:937:3: ( ( typeMutator )* ( functionSignatureSuffix ) )*
            loop63:
            do {
                int alt63=2;
                alt63 = dfa63.predict(input);
                switch (alt63) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:938:4: ( typeMutator )* ( functionSignatureSuffix )
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:938:4: ( typeMutator )*
            	    loop62:
            	    do {
            	        int alt62=2;
            	        int LA62_0 = input.LA(1);

            	        if ( ((LA62_0>=53 && LA62_0<=55)) ) {
            	            alt62=1;
            	        }


            	        switch (alt62) {
            	    	case 1 :
            	    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:939:5: typeMutator
            	    	    {
            	    	    pushFollow(FOLLOW_typeMutator_in_nonMutableTypeRef2453);
            	    	    typeMutator125=typeMutator();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeMutator125.getTree());
            	    	    if ( state.backtracking==0 ) {

            	    	      					retval.type = (typeMutator125!=null?typeMutator125.mutator:null).mutateType(retval.type);
            	    	      				
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop62;
            	        }
            	    } while (true);

            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:943:4: ( functionSignatureSuffix )
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:944:5: functionSignatureSuffix
            	    {
            	    pushFollow(FOLLOW_functionSignatureSuffix_in_nonMutableTypeRef2472);
            	    functionSignatureSuffix126=functionSignatureSuffix();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionSignatureSuffix126.getTree());
            	    if ( state.backtracking==0 ) {
            	       
            	      					(functionSignatureSuffix126!=null?functionSignatureSuffix126.signature:null).getFunction().setValueType(retval.type); 
            	      					retval.type = (functionSignatureSuffix126!=null?functionSignatureSuffix126.signature:null);
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop63;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:952:1: declarator returns [Declarator declarator] : modifiers ( ( directDeclarator ) | (pt= ( '*' | '&' | '^' ) inner= declarator ) ) ( '=' dv= topLevelExpr )? ;
    public final ObjCppParser.declarator_return declarator() throws RecognitionException {
        ObjCppParser.declarator_return retval = new ObjCppParser.declarator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token pt=null;
        Token char_literal129=null;
        ObjCppParser.declarator_return inner = null;

        ObjCppParser.topLevelExpr_return dv = null;

        ObjCppParser.modifiers_return modifiers127 = null;

        ObjCppParser.directDeclarator_return directDeclarator128 = null;


        Object pt_tree=null;
        Object char_literal129_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:953:2: ( modifiers ( ( directDeclarator ) | (pt= ( '*' | '&' | '^' ) inner= declarator ) ) ( '=' dv= topLevelExpr )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:954:3: modifiers ( ( directDeclarator ) | (pt= ( '*' | '&' | '^' ) inner= declarator ) ) ( '=' dv= topLevelExpr )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_modifiers_in_declarator2504);
            modifiers127=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, modifiers127.getTree());
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:955:3: ( ( directDeclarator ) | (pt= ( '*' | '&' | '^' ) inner= declarator ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==IDENTIFIER||LA64_0==34) ) {
                alt64=1;
            }
            else if ( ((LA64_0>=53 && LA64_0<=54)||LA64_0==58) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:956:4: ( directDeclarator )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:956:4: ( directDeclarator )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:957:5: directDeclarator
                    {
                    pushFollow(FOLLOW_directDeclarator_in_declarator2520);
                    directDeclarator128=directDeclarator();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, directDeclarator128.getTree());
                    if ( state.backtracking==0 ) {
                       
                      					retval.declarator = (directDeclarator128!=null?directDeclarator128.declarator:null); 
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:961:4: (pt= ( '*' | '&' | '^' ) inner= declarator )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:961:4: (pt= ( '*' | '&' | '^' ) inner= declarator )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:962:5: pt= ( '*' | '&' | '^' ) inner= declarator
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

                    pushFollow(FOLLOW_declarator_in_declarator2562);
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:968:3: ( '=' dv= topLevelExpr )?
            int alt65=2;
            alt65 = dfa65.predict(input);
            switch (alt65) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:969:4: '=' dv= topLevelExpr
                    {
                    char_literal129=(Token)match(input,29,FOLLOW_29_in_declarator2583); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal129_tree = (Object)adaptor.create(char_literal129);
                    adaptor.addChild(root_0, char_literal129_tree);
                    }
                    pushFollow(FOLLOW_topLevelExpr_in_declarator2591);
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

              			retval.declarator.setModifiers((modifiers127!=null?modifiers127.modifiers:null));
              		
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:979:1: typeDef returns [TypeDef typeDef] : 'typedef' varDecl ';' ;
    public final ObjCppParser.typeDef_return typeDef() throws RecognitionException {
        ObjCppParser.typeDef_return retval = new ObjCppParser.typeDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal130=null;
        Token char_literal132=null;
        ObjCppParser.varDecl_return varDecl131 = null;


        Object string_literal130_tree=null;
        Object char_literal132_tree=null;


        	((IsTypeDef_scope)IsTypeDef_stack.peek()).isTypeDef = true;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:983:2: ( 'typedef' varDecl ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:983:4: 'typedef' varDecl ';'
            {
            root_0 = (Object)adaptor.nil();

            string_literal130=(Token)match(input,59,FOLLOW_59_in_typeDef2622); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal130_tree = (Object)adaptor.create(string_literal130);
            adaptor.addChild(root_0, string_literal130_tree);
            }
            pushFollow(FOLLOW_varDecl_in_typeDef2627);
            varDecl131=varDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl131.getTree());
            char_literal132=(Token)match(input,25,FOLLOW_25_in_typeDef2629); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal132_tree = (Object)adaptor.create(char_literal132);
            adaptor.addChild(root_0, char_literal132_tree);
            }
            if ( state.backtracking==0 ) {

              		 	VariablesDeclaration vd = (varDecl131!=null?varDecl131.decl:null);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:990:1: varDeclEOF returns [Declaration decl] : varDecl ';' EOF ;
    public final ObjCppParser.varDeclEOF_return varDeclEOF() throws RecognitionException {
        ObjCppParser.varDeclEOF_return retval = new ObjCppParser.varDeclEOF_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal134=null;
        Token EOF135=null;
        ObjCppParser.varDecl_return varDecl133 = null;


        Object char_literal134_tree=null;
        Object EOF135_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:991:2: ( varDecl ';' EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:991:4: varDecl ';' EOF
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_varDecl_in_varDeclEOF2647);
            varDecl133=varDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl133.getTree());
            char_literal134=(Token)match(input,25,FOLLOW_25_in_varDeclEOF2649); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal134_tree = (Object)adaptor.create(char_literal134);
            adaptor.addChild(root_0, char_literal134_tree);
            }
            EOF135=(Token)match(input,EOF,FOLLOW_EOF_in_varDeclEOF2651); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EOF135_tree = (Object)adaptor.create(EOF135);
            adaptor.addChild(root_0, EOF135_tree);
            }
            if ( state.backtracking==0 ) {
               retval.decl = (varDecl133!=null?varDecl133.decl:null); 
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:994:1: declarationEOF returns [List<Declaration> declarations] : d= declaration EOF ;
    public final ObjCppParser.declarationEOF_return declarationEOF() throws RecognitionException {
        ObjCppParser.declarationEOF_return retval = new ObjCppParser.declarationEOF_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF136=null;
        ObjCppParser.declaration_return d = null;


        Object EOF136_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:995:2: (d= declaration EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:995:5: d= declaration EOF
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_declaration_in_declarationEOF2671);
            d=declaration();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());
            EOF136=(Token)match(input,EOF,FOLLOW_EOF_in_declarationEOF2673); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EOF136_tree = (Object)adaptor.create(EOF136);
            adaptor.addChild(root_0, EOF136_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:998:1: varDecl returns [VariablesDeclaration decl] : tr= nonMutableTypeRef (d1= declaratorsList )? ;
    public final ObjCppParser.varDecl_return varDecl() throws RecognitionException {
        ObjCppParser.varDecl_return retval = new ObjCppParser.varDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.nonMutableTypeRef_return tr = null;

        ObjCppParser.declaratorsList_return d1 = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:999:2: (tr= nonMutableTypeRef (d1= declaratorsList )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1000:3: tr= nonMutableTypeRef (d1= declaratorsList )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_nonMutableTypeRef_in_varDecl2695);
            tr=nonMutableTypeRef();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, tr.getTree());
            if ( state.backtracking==0 ) {
               
              			retval.decl = new VariablesDeclaration((tr!=null?tr.type:null)); 
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1003:3: (d1= declaratorsList )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==IDENTIFIER||LA66_0==34||(LA66_0>=53 && LA66_0<=54)||LA66_0==58) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1004:4: d1= declaratorsList
                    {
                    pushFollow(FOLLOW_declaratorsList_in_varDecl2708);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1010:1: objCProtocolRefList : '<' IDENTIFIER ( ',' IDENTIFIER )* '>' ;
    public final ObjCppParser.objCProtocolRefList_return objCProtocolRefList() throws RecognitionException {
        ObjCppParser.objCProtocolRefList_return retval = new ObjCppParser.objCProtocolRefList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal137=null;
        Token IDENTIFIER138=null;
        Token char_literal139=null;
        Token IDENTIFIER140=null;
        Token char_literal141=null;

        Object char_literal137_tree=null;
        Object IDENTIFIER138_tree=null;
        Object char_literal139_tree=null;
        Object IDENTIFIER140_tree=null;
        Object char_literal141_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1011:2: ( '<' IDENTIFIER ( ',' IDENTIFIER )* '>' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1011:4: '<' IDENTIFIER ( ',' IDENTIFIER )* '>'
            {
            root_0 = (Object)adaptor.nil();

            char_literal137=(Token)match(input,36,FOLLOW_36_in_objCProtocolRefList2727); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal137_tree = (Object)adaptor.create(char_literal137);
            adaptor.addChild(root_0, char_literal137_tree);
            }
            IDENTIFIER138=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCProtocolRefList2732); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER138_tree = (Object)adaptor.create(IDENTIFIER138);
            adaptor.addChild(root_0, IDENTIFIER138_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1013:3: ( ',' IDENTIFIER )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==28) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1014:4: ',' IDENTIFIER
            	    {
            	    char_literal139=(Token)match(input,28,FOLLOW_28_in_objCProtocolRefList2742); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal139_tree = (Object)adaptor.create(char_literal139);
            	    adaptor.addChild(root_0, char_literal139_tree);
            	    }
            	    IDENTIFIER140=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCProtocolRefList2748); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDENTIFIER140_tree = (Object)adaptor.create(IDENTIFIER140);
            	    adaptor.addChild(root_0, IDENTIFIER140_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);

            char_literal141=(Token)match(input,37,FOLLOW_37_in_objCProtocolRefList2758); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal141_tree = (Object)adaptor.create(char_literal141);
            adaptor.addChild(root_0, char_literal141_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1020:1: declaratorsList returns [List<Declarator> declarators] : d= declarator ( ',' x= declarator )* ;
    public final ObjCppParser.declaratorsList_return declaratorsList() throws RecognitionException {
        ObjCppParser.declaratorsList_return retval = new ObjCppParser.declaratorsList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal142=null;
        ObjCppParser.declarator_return d = null;

        ObjCppParser.declarator_return x = null;


        Object char_literal142_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1021:2: (d= declarator ( ',' x= declarator )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1021:4: d= declarator ( ',' x= declarator )*
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.declarators = new ArrayList<Declarator>(); 
            }
            pushFollow(FOLLOW_declarator_in_declaratorsList2779);
            d=declarator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());
            if ( state.backtracking==0 ) {
               retval.declarators.add((d!=null?d.declarator:null)); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1023:3: ( ',' x= declarator )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==28) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1024:4: ',' x= declarator
            	    {
            	    char_literal142=(Token)match(input,28,FOLLOW_28_in_declaratorsList2790); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal142_tree = (Object)adaptor.create(char_literal142);
            	    adaptor.addChild(root_0, char_literal142_tree);
            	    }
            	    pushFollow(FOLLOW_declarator_in_declaratorsList2798);
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
            	    break loop68;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1029:1: directDeclarator returns [Declarator declarator] : ( IDENTIFIER | '(' inner= declarator ')' ) ( '[' ( expression | ) ']' | argList )* ;
    public final ObjCppParser.directDeclarator_return directDeclarator() throws RecognitionException {
        ObjCppParser.directDeclarator_return retval = new ObjCppParser.directDeclarator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER143=null;
        Token char_literal144=null;
        Token char_literal145=null;
        Token char_literal146=null;
        Token char_literal148=null;
        ObjCppParser.declarator_return inner = null;

        ObjCppParser.expression_return expression147 = null;

        ObjCppParser.argList_return argList149 = null;


        Object IDENTIFIER143_tree=null;
        Object char_literal144_tree=null;
        Object char_literal145_tree=null;
        Object char_literal146_tree=null;
        Object char_literal148_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1030:2: ( ( IDENTIFIER | '(' inner= declarator ')' ) ( '[' ( expression | ) ']' | argList )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1031:3: ( IDENTIFIER | '(' inner= declarator ')' ) ( '[' ( expression | ) ']' | argList )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1031:3: ( IDENTIFIER | '(' inner= declarator ')' )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==IDENTIFIER) ) {
                alt69=1;
            }
            else if ( (LA69_0==34) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1032:4: IDENTIFIER
                    {
                    IDENTIFIER143=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_directDeclarator2829); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER143_tree = (Object)adaptor.create(IDENTIFIER143);
                    adaptor.addChild(root_0, IDENTIFIER143_tree);
                    }
                    if ( state.backtracking==0 ) {

                      				retval.declarator = mark(new DirectDeclarator((IDENTIFIER143!=null?IDENTIFIER143.getText():null)), getLine(IDENTIFIER143));
                      				if (isTypeDef()) {
                      					((Symbols_scope)Symbols_stack.peek()).typeIdentifiers.add((IDENTIFIER143!=null?IDENTIFIER143.getText():null));
                      				}
                      			
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1038:4: '(' inner= declarator ')'
                    {
                    char_literal144=(Token)match(input,34,FOLLOW_34_in_directDeclarator2839); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal144_tree = (Object)adaptor.create(char_literal144);
                    adaptor.addChild(root_0, char_literal144_tree);
                    }
                    pushFollow(FOLLOW_declarator_in_directDeclarator2843);
                    inner=declarator();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inner.getTree());
                    char_literal145=(Token)match(input,35,FOLLOW_35_in_directDeclarator2845); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal145_tree = (Object)adaptor.create(char_literal145);
                    adaptor.addChild(root_0, char_literal145_tree);
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1045:3: ( '[' ( expression | ) ']' | argList )*
            loop71:
            do {
                int alt71=3;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==55) ) {
                    alt71=1;
                }
                else if ( (LA71_0==34) ) {
                    alt71=2;
                }


                switch (alt71) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1046:4: '[' ( expression | ) ']'
            	    {
            	    char_literal146=(Token)match(input,55,FOLLOW_55_in_directDeclarator2861); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal146_tree = (Object)adaptor.create(char_literal146);
            	    adaptor.addChild(root_0, char_literal146_tree);
            	    }
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1047:4: ( expression | )
            	    int alt70=2;
            	    alt70 = dfa70.predict(input);
            	    switch (alt70) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1048:5: expression
            	            {
            	            pushFollow(FOLLOW_expression_in_directDeclarator2873);
            	            expression147=expression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression147.getTree());
            	            if ( state.backtracking==0 ) {

            	              					if (retval.declarator instanceof ArrayDeclarator)
            	              						((ArrayDeclarator)retval.declarator).addDimension((expression147!=null?expression147.expr:null));
            	              					else
            	              						retval.declarator = new ArrayDeclarator(retval.declarator, (expression147!=null?expression147.expr:null));
            	              				
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1053:9: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              					retval.declarator = new ArrayDeclarator(retval.declarator, new Expression.EmptyArraySize());
            	              				
            	            }

            	            }
            	            break;

            	    }

            	    char_literal148=(Token)match(input,56,FOLLOW_56_in_directDeclarator2889); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal148_tree = (Object)adaptor.create(char_literal148);
            	    adaptor.addChild(root_0, char_literal148_tree);
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1058:4: argList
            	    {
            	    pushFollow(FOLLOW_argList_in_directDeclarator2897);
            	    argList149=argList();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, argList149.getTree());
            	    if ( state.backtracking==0 ) {

            	      				retval.declarator = new FunctionDeclarator(retval.declarator, (argList149!=null?argList149.args:null));
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop71;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1064:1: argList returns [List<Arg> args, boolean isObjC] : op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')' ;
    public final ObjCppParser.argList_return argList() throws RecognitionException {
        ObjCppParser.argList_return retval = new ObjCppParser.argList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        Token cp=null;
        Token char_literal150=null;
        Token char_literal151=null;
        Token string_literal152=null;
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        Object op_tree=null;
        Object cp_tree=null;
        Object char_literal150_tree=null;
        Object char_literal151_tree=null;
        Object string_literal152_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1065:2: (op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1065:4: op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               
              			retval.isObjC = false; 
              			retval.args = new ArrayList<Arg>();
              		
            }
            op=(Token)match(input,34,FOLLOW_34_in_argList2925); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            op_tree = (Object)adaptor.create(op);
            adaptor.addChild(root_0, op_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1070:3: (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==IDENTIFIER||LA74_0==30||LA74_0==44||(LA74_0>=48 && LA74_0<=50)||LA74_0==60) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1071:4: a1= argDef ( ',' ax= argDef )* ( ',' '...' )?
                    {
                    pushFollow(FOLLOW_argDef_in_argList2937);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {

                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					retval.args.add((a1!=null?a1.arg:null));
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1075:4: ( ',' ax= argDef )*
                    loop72:
                    do {
                        int alt72=2;
                        alt72 = dfa72.predict(input);
                        switch (alt72) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1076:5: ',' ax= argDef
                    	    {
                    	    char_literal150=(Token)match(input,28,FOLLOW_28_in_argList2950); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal150_tree = (Object)adaptor.create(char_literal150);
                    	    adaptor.addChild(root_0, char_literal150_tree);
                    	    }
                    	    pushFollow(FOLLOW_argDef_in_argList2959);
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
                    	    break loop72;
                        }
                    } while (true);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1081:4: ( ',' '...' )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==28) ) {
                        alt73=1;
                    }
                    switch (alt73) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1082:5: ',' '...'
                            {
                            char_literal151=(Token)match(input,28,FOLLOW_28_in_argList2979); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal151_tree = (Object)adaptor.create(char_literal151);
                            adaptor.addChild(root_0, char_literal151_tree);
                            }
                            string_literal152=(Token)match(input,44,FOLLOW_44_in_argList2981); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal152_tree = (Object)adaptor.create(string_literal152);
                            adaptor.addChild(root_0, string_literal152_tree);
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

            cp=(Token)match(input,35,FOLLOW_35_in_argList3000); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1110:1: typeRefCore returns [TypeRef type] : (mods= anyModifier | ( ( ( 'typename' | {...}?) i= IDENTIFIER ) ( '<' (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )? '>' )? ) | structCore | enumCore )+ ;
    public final ObjCppParser.typeRefCore_return typeRefCore() throws RecognitionException {
        ObjCppParser.typeRefCore_return retval = new ObjCppParser.typeRefCore_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token i=null;
        Token string_literal153=null;
        Token char_literal154=null;
        Token char_literal155=null;
        Token char_literal156=null;
        ObjCppParser.anyModifier_return mods = null;

        ObjCppParser.mutableTypeRef_return t1 = null;

        ObjCppParser.mutableTypeRef_return tx = null;

        ObjCppParser.structCore_return structCore157 = null;

        ObjCppParser.enumCore_return enumCore158 = null;


        Object i_tree=null;
        Object string_literal153_tree=null;
        Object char_literal154_tree=null;
        Object char_literal155_tree=null;
        Object char_literal156_tree=null;


        	List<Modifier> modifiers = new ArrayList<Modifier>();
        	//TypeRef ref = null;
        	int line = -1;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1116:2: ( (mods= anyModifier | ( ( ( 'typename' | {...}?) i= IDENTIFIER ) ( '<' (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )? '>' )? ) | structCore | enumCore )+ )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1117:3: (mods= anyModifier | ( ( ( 'typename' | {...}?) i= IDENTIFIER ) ( '<' (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )? '>' )? ) | structCore | enumCore )+
            {
            root_0 = (Object)adaptor.nil();

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1117:3: (mods= anyModifier | ( ( ( 'typename' | {...}?) i= IDENTIFIER ) ( '<' (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )? '>' )? ) | structCore | enumCore )+
            int cnt79=0;
            loop79:
            do {
                int alt79=5;
                alt79 = dfa79.predict(input);
                switch (alt79) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1118:4: mods= anyModifier
            	    {
            	    pushFollow(FOLLOW_anyModifier_in_typeRefCore3032);
            	    mods=anyModifier();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, mods.getTree());
            	    if ( state.backtracking==0 ) {
            	       modifiers.addAll((mods!=null?mods.modifiers:null)); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1119:4: ( ( ( 'typename' | {...}?) i= IDENTIFIER ) ( '<' (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )? '>' )? )
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1119:4: ( ( ( 'typename' | {...}?) i= IDENTIFIER ) ( '<' (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )? '>' )? )
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1120:5: ( ( 'typename' | {...}?) i= IDENTIFIER ) ( '<' (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )? '>' )?
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1120:5: ( ( 'typename' | {...}?) i= IDENTIFIER )
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1121:6: ( 'typename' | {...}?) i= IDENTIFIER
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1121:6: ( 'typename' | {...}?)
            	    int alt75=2;
            	    int LA75_0 = input.LA(1);

            	    if ( (LA75_0==60) ) {
            	        alt75=1;
            	    }
            	    else if ( (LA75_0==IDENTIFIER) ) {
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
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1121:7: 'typename'
            	            {
            	            string_literal153=(Token)match(input,60,FOLLOW_60_in_typeRefCore3055); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal153_tree = (Object)adaptor.create(string_literal153);
            	            adaptor.addChild(root_0, string_literal153_tree);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1121:20: {...}?
            	            {
            	            if ( !(( isTypeIdentifier(next()) )) ) {
            	                if (state.backtracking>0) {state.failed=true; return retval;}
            	                throw new FailedPredicateException(input, "typeRefCore", " isTypeIdentifier(next()) ");
            	            }

            	            }
            	            break;

            	    }

            	    i=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_typeRefCore3065); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    i_tree = (Object)adaptor.create(i);
            	    adaptor.addChild(root_0, i_tree);
            	    }
            	    if ( state.backtracking==0 ) {

            	      						retval.type = mark(isPrimitiveType((i!=null?i.getText():null)) ? new Primitive((i!=null?i.getText():null)) : new SimpleTypeRef((i!=null?i.getText():null)), getLine(i));
            	      						((Symbols_scope)Symbols_stack.peek()).typeIdentifiers.add((i!=null?i.getText():null));
            	      					
            	    }

            	    }

            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1129:5: ( '<' (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )? '>' )?
            	    int alt78=2;
            	    alt78 = dfa78.predict(input);
            	    switch (alt78) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1130:6: '<' (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )? '>'
            	            {
            	            char_literal154=(Token)match(input,36,FOLLOW_36_in_typeRefCore3089); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal154_tree = (Object)adaptor.create(char_literal154);
            	            adaptor.addChild(root_0, char_literal154_tree);
            	            }
            	            if ( state.backtracking==0 ) {
            	               retval.type = new TemplateRef((i!=null?i.getText():null)); 
            	            }
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1131:7: (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )?
            	            int alt77=2;
            	            int LA77_0 = input.LA(1);

            	            if ( (LA77_0==IDENTIFIER||LA77_0==30||(LA77_0>=48 && LA77_0<=50)||LA77_0==60) ) {
            	                alt77=1;
            	            }
            	            switch (alt77) {
            	                case 1 :
            	                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1132:8: t1= mutableTypeRef ( ',' tx= mutableTypeRef )*
            	                    {
            	                    pushFollow(FOLLOW_mutableTypeRef_in_typeRefCore3110);
            	                    t1=mutableTypeRef();

            	                    state._fsp--;
            	                    if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t1.getTree());
            	                    if ( state.backtracking==0 ) {
            	                       ((TemplateRef)retval.type).addParameter((t1!=null?t1.type:null)); 
            	                    }
            	                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1133:8: ( ',' tx= mutableTypeRef )*
            	                    loop76:
            	                    do {
            	                        int alt76=2;
            	                        int LA76_0 = input.LA(1);

            	                        if ( (LA76_0==28) ) {
            	                            alt76=1;
            	                        }


            	                        switch (alt76) {
            	                    	case 1 :
            	                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1134:9: ',' tx= mutableTypeRef
            	                    	    {
            	                    	    char_literal155=(Token)match(input,28,FOLLOW_28_in_typeRefCore3131); if (state.failed) return retval;
            	                    	    if ( state.backtracking==0 ) {
            	                    	    char_literal155_tree = (Object)adaptor.create(char_literal155);
            	                    	    adaptor.addChild(root_0, char_literal155_tree);
            	                    	    }
            	                    	    pushFollow(FOLLOW_mutableTypeRef_in_typeRefCore3144);
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
            	                    	    break loop76;
            	                        }
            	                    } while (true);


            	                    }
            	                    break;

            	            }

            	            char_literal156=(Token)match(input,37,FOLLOW_37_in_typeRefCore3172); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal156_tree = (Object)adaptor.create(char_literal156);
            	            adaptor.addChild(root_0, char_literal156_tree);
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1141:4: structCore
            	    {
            	    pushFollow(FOLLOW_structCore_in_typeRefCore3192);
            	    structCore157=structCore();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, structCore157.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.type = (structCore157!=null?structCore157.struct:null); 
            	    }

            	    }
            	    break;
            	case 4 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1142:4: enumCore
            	    {
            	    pushFollow(FOLLOW_enumCore_in_typeRefCore3201);
            	    enumCore158=enumCore();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, enumCore158.getTree());
            	    if ( state.backtracking==0 ) {
            	       retval.type = (enumCore158!=null?enumCore158.e:null); 
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt79 >= 1 ) break loop79;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(79, input);
                        throw eee;
                }
                cnt79++;
            } while (true);

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

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
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

    public static class objCMethodCall_return extends ParserRuleReturnScope {
        public FunctionCall expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "objCMethodCall"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1155:1: objCMethodCall returns [FunctionCall expr] : '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']' ;
    public final ObjCppParser.objCMethodCall_return objCMethodCall() throws RecognitionException {
        ObjCppParser.objCMethodCall_return retval = new ObjCppParser.objCMethodCall_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token methodName=null;
        Token selx=null;
        Token char_literal159=null;
        Token char_literal160=null;
        Token char_literal161=null;
        Token char_literal162=null;
        ObjCppParser.expression_return target = null;

        ObjCppParser.expression_return arg1 = null;

        ObjCppParser.expression_return argx = null;


        Object methodName_tree=null;
        Object selx_tree=null;
        Object char_literal159_tree=null;
        Object char_literal160_tree=null;
        Object char_literal161_tree=null;
        Object char_literal162_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1156:2: ( '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1157:3: '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']'
            {
            root_0 = (Object)adaptor.nil();

            char_literal159=(Token)match(input,55,FOLLOW_55_in_objCMethodCall3231); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal159_tree = (Object)adaptor.create(char_literal159);
            adaptor.addChild(root_0, char_literal159_tree);
            }
            pushFollow(FOLLOW_expression_in_objCMethodCall3235);
            target=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, target.getTree());
            methodName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodCall3239); if (state.failed) return retval;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1163:3: ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==33) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1164:4: ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )*
                    {
                    char_literal160=(Token)match(input,33,FOLLOW_33_in_objCMethodCall3250); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal160_tree = (Object)adaptor.create(char_literal160);
                    adaptor.addChild(root_0, char_literal160_tree);
                    }
                    pushFollow(FOLLOW_expression_in_objCMethodCall3254);
                    arg1=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arg1.getTree());
                    if ( state.backtracking==0 ) {

                      				retval.expr.addArgument(null, (arg1!=null?arg1.expr:null));
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1167:4: (selx= IDENTIFIER ':' argx= expression )*
                    loop80:
                    do {
                        int alt80=2;
                        int LA80_0 = input.LA(1);

                        if ( (LA80_0==IDENTIFIER) ) {
                            alt80=1;
                        }


                        switch (alt80) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1168:5: selx= IDENTIFIER ':' argx= expression
                    	    {
                    	    selx=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodCall3269); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    selx_tree = (Object)adaptor.create(selx);
                    	    adaptor.addChild(root_0, selx_tree);
                    	    }
                    	    char_literal161=(Token)match(input,33,FOLLOW_33_in_objCMethodCall3271); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal161_tree = (Object)adaptor.create(char_literal161);
                    	    adaptor.addChild(root_0, char_literal161_tree);
                    	    }
                    	    pushFollow(FOLLOW_expression_in_objCMethodCall3275);
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
                    	    break loop80;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal162=(Token)match(input,56,FOLLOW_56_in_objCMethodCall3292); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal162_tree = (Object)adaptor.create(char_literal162);
            adaptor.addChild(root_0, char_literal162_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1176:1: functionCall returns [FunctionCall expr] : IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')' ;
    public final ObjCppParser.functionCall_return functionCall() throws RecognitionException {
        ObjCppParser.functionCall_return retval = new ObjCppParser.functionCall_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER163=null;
        Token char_literal164=null;
        Token char_literal165=null;
        Token char_literal166=null;
        ObjCppParser.expression_return a1 = null;

        ObjCppParser.expression_return ax = null;


        Object IDENTIFIER163_tree=null;
        Object char_literal164_tree=null;
        Object char_literal165_tree=null;
        Object char_literal166_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1177:2: ( IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1178:3: IDENTIFIER '(' (a1= expression ( ',' ax= expression )* )? ')'
            {
            root_0 = (Object)adaptor.nil();

            IDENTIFIER163=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionCall3312); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER163_tree = (Object)adaptor.create(IDENTIFIER163);
            adaptor.addChild(root_0, IDENTIFIER163_tree);
            }
            char_literal164=(Token)match(input,34,FOLLOW_34_in_functionCall3314); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal164_tree = (Object)adaptor.create(char_literal164);
            adaptor.addChild(root_0, char_literal164_tree);
            }
            if ( state.backtracking==0 ) {

              			FunctionCall fc = new FunctionCall();
              			fc.setFunction(new VariableRef((IDENTIFIER163!=null?IDENTIFIER163.getText():null)));
              			retval.expr = fc;
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1183:3: (a1= expression ( ',' ax= expression )* )?
            int alt83=2;
            alt83 = dfa83.predict(input);
            switch (alt83) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1184:4: a1= expression ( ',' ax= expression )*
                    {
                    pushFollow(FOLLOW_expression_in_functionCall3327);
                    a1=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, a1.getTree());
                    if ( state.backtracking==0 ) {

                      				retval.expr.addArgument((a1!=null?a1.expr:null));
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1187:4: ( ',' ax= expression )*
                    loop82:
                    do {
                        int alt82=2;
                        int LA82_0 = input.LA(1);

                        if ( (LA82_0==28) ) {
                            alt82=1;
                        }


                        switch (alt82) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1187:6: ',' ax= expression
                    	    {
                    	    char_literal165=(Token)match(input,28,FOLLOW_28_in_functionCall3336); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal165_tree = (Object)adaptor.create(char_literal165);
                    	    adaptor.addChild(root_0, char_literal165_tree);
                    	    }
                    	    pushFollow(FOLLOW_expression_in_functionCall3345);
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
                    	    break loop82;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal166=(Token)match(input,35,FOLLOW_35_in_functionCall3363); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal166_tree = (Object)adaptor.create(char_literal166);
            adaptor.addChild(root_0, char_literal166_tree);
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
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "binaryOp"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1196:1: binaryOp : ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' );
    public final ObjCppParser.binaryOp_return binaryOp() throws RecognitionException {
        ObjCppParser.binaryOp_return retval = new ObjCppParser.binaryOp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set167=null;

        Object set167_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1196:10: ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:
            {
            root_0 = (Object)adaptor.nil();

            set167=(Token)input.LT(1);
            if ( (input.LA(1)>=36 && input.LA(1)<=37)||(input.LA(1)>=42 && input.LA(1)<=43)||(input.LA(1)>=53 && input.LA(1)<=54)||input.LA(1)==58||(input.LA(1)>=61 && input.LA(1)<=72) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set167));
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

    public static class baseExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "baseExpression"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1200:1: baseExpression returns [Expression expr] : ( IDENTIFIER | constant | '(' expression ')' | objCMethodCall | selectorExpr | protocolExpr | encodingExpr );
    public final ObjCppParser.baseExpression_return baseExpression() throws RecognitionException {
        ObjCppParser.baseExpression_return retval = new ObjCppParser.baseExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER168=null;
        Token char_literal170=null;
        Token char_literal172=null;
        ObjCppParser.constant_return constant169 = null;

        ObjCppParser.expression_return expression171 = null;

        ObjCppParser.objCMethodCall_return objCMethodCall173 = null;

        ObjCppParser.selectorExpr_return selectorExpr174 = null;

        ObjCppParser.protocolExpr_return protocolExpr175 = null;

        ObjCppParser.encodingExpr_return encodingExpr176 = null;


        Object IDENTIFIER168_tree=null;
        Object char_literal170_tree=null;
        Object char_literal172_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1201:2: ( IDENTIFIER | constant | '(' expression ')' | objCMethodCall | selectorExpr | protocolExpr | encodingExpr )
            int alt84=7;
            alt84 = dfa84.predict(input);
            switch (alt84) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1202:3: IDENTIFIER
                    {
                    root_0 = (Object)adaptor.nil();

                    IDENTIFIER168=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_baseExpression3464); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER168_tree = (Object)adaptor.create(IDENTIFIER168);
                    adaptor.addChild(root_0, IDENTIFIER168_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.expr = new VariableRef((IDENTIFIER168!=null?IDENTIFIER168.getText():null)); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1203:3: constant
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_constant_in_baseExpression3472);
                    constant169=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant169.getTree());
                    if ( state.backtracking==0 ) {
                       retval.expr = (constant169!=null?constant169.constant:null); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1204:3: '(' expression ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal170=(Token)match(input,34,FOLLOW_34_in_baseExpression3480); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal170_tree = (Object)adaptor.create(char_literal170);
                    adaptor.addChild(root_0, char_literal170_tree);
                    }
                    pushFollow(FOLLOW_expression_in_baseExpression3482);
                    expression171=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression171.getTree());
                    char_literal172=(Token)match(input,35,FOLLOW_35_in_baseExpression3484); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal172_tree = (Object)adaptor.create(char_literal172);
                    adaptor.addChild(root_0, char_literal172_tree);
                    }
                    if ( state.backtracking==0 ) {
                       
                      			retval.expr = (expression171!=null?expression171.expr:null); 
                      			if (retval.expr != null)
                      				retval.expr.setParenthesis(true);
                      		
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1209:3: objCMethodCall
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_objCMethodCall_in_baseExpression3492);
                    objCMethodCall173=objCMethodCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, objCMethodCall173.getTree());
                    if ( state.backtracking==0 ) {
                       retval.expr = (objCMethodCall173!=null?objCMethodCall173.expr:null); 
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1210:3: selectorExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_selectorExpr_in_baseExpression3500);
                    selectorExpr174=selectorExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, selectorExpr174.getTree());

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1211:3: protocolExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_protocolExpr_in_baseExpression3506);
                    protocolExpr175=protocolExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, protocolExpr175.getTree());

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1212:3: encodingExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_encodingExpr_in_baseExpression3512);
                    encodingExpr176=encodingExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, encodingExpr176.getTree());

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1215:1: selectorExpr returns [Expression expr] : '@selector' '(' selectorName ')' ;
    public final ObjCppParser.selectorExpr_return selectorExpr() throws RecognitionException {
        ObjCppParser.selectorExpr_return retval = new ObjCppParser.selectorExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal177=null;
        Token char_literal178=null;
        Token char_literal180=null;
        ObjCppParser.selectorName_return selectorName179 = null;


        Object string_literal177_tree=null;
        Object char_literal178_tree=null;
        Object char_literal180_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1216:2: ( '@selector' '(' selectorName ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1216:4: '@selector' '(' selectorName ')'
            {
            root_0 = (Object)adaptor.nil();

            string_literal177=(Token)match(input,73,FOLLOW_73_in_selectorExpr3528); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal177_tree = (Object)adaptor.create(string_literal177);
            adaptor.addChild(root_0, string_literal177_tree);
            }
            char_literal178=(Token)match(input,34,FOLLOW_34_in_selectorExpr3533); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal178_tree = (Object)adaptor.create(char_literal178);
            adaptor.addChild(root_0, char_literal178_tree);
            }
            pushFollow(FOLLOW_selectorName_in_selectorExpr3538);
            selectorName179=selectorName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, selectorName179.getTree());
            char_literal180=(Token)match(input,35,FOLLOW_35_in_selectorExpr3543); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal180_tree = (Object)adaptor.create(char_literal180);
            adaptor.addChild(root_0, char_literal180_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1222:1: selectorName : IDENTIFIER ( IDENTIFIER ':' )* ;
    public final ObjCppParser.selectorName_return selectorName() throws RecognitionException {
        ObjCppParser.selectorName_return retval = new ObjCppParser.selectorName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER181=null;
        Token IDENTIFIER182=null;
        Token char_literal183=null;

        Object IDENTIFIER181_tree=null;
        Object IDENTIFIER182_tree=null;
        Object char_literal183_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1223:2: ( IDENTIFIER ( IDENTIFIER ':' )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1223:4: IDENTIFIER ( IDENTIFIER ':' )*
            {
            root_0 = (Object)adaptor.nil();

            IDENTIFIER181=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_selectorName3554); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER181_tree = (Object)adaptor.create(IDENTIFIER181);
            adaptor.addChild(root_0, IDENTIFIER181_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1223:15: ( IDENTIFIER ':' )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==IDENTIFIER) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1223:16: IDENTIFIER ':'
            	    {
            	    IDENTIFIER182=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_selectorName3557); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDENTIFIER182_tree = (Object)adaptor.create(IDENTIFIER182);
            	    adaptor.addChild(root_0, IDENTIFIER182_tree);
            	    }
            	    char_literal183=(Token)match(input,33,FOLLOW_33_in_selectorName3559); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal183_tree = (Object)adaptor.create(char_literal183);
            	    adaptor.addChild(root_0, char_literal183_tree);
            	    }

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
    // $ANTLR end "selectorName"

    public static class protocolExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "protocolExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1226:1: protocolExpr : '@protocol' '(' IDENTIFIER ')' ;
    public final ObjCppParser.protocolExpr_return protocolExpr() throws RecognitionException {
        ObjCppParser.protocolExpr_return retval = new ObjCppParser.protocolExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal184=null;
        Token char_literal185=null;
        Token IDENTIFIER186=null;
        Token char_literal187=null;

        Object string_literal184_tree=null;
        Object char_literal185_tree=null;
        Object IDENTIFIER186_tree=null;
        Object char_literal187_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1227:2: ( '@protocol' '(' IDENTIFIER ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1227:4: '@protocol' '(' IDENTIFIER ')'
            {
            root_0 = (Object)adaptor.nil();

            string_literal184=(Token)match(input,31,FOLLOW_31_in_protocolExpr3572); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal184_tree = (Object)adaptor.create(string_literal184);
            adaptor.addChild(root_0, string_literal184_tree);
            }
            char_literal185=(Token)match(input,34,FOLLOW_34_in_protocolExpr3576); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal185_tree = (Object)adaptor.create(char_literal185);
            adaptor.addChild(root_0, char_literal185_tree);
            }
            IDENTIFIER186=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_protocolExpr3580); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER186_tree = (Object)adaptor.create(IDENTIFIER186);
            adaptor.addChild(root_0, IDENTIFIER186_tree);
            }
            char_literal187=(Token)match(input,35,FOLLOW_35_in_protocolExpr3584); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal187_tree = (Object)adaptor.create(char_literal187);
            adaptor.addChild(root_0, char_literal187_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1233:1: encodingExpr : '@encode' '(' IDENTIFIER ')' ;
    public final ObjCppParser.encodingExpr_return encodingExpr() throws RecognitionException {
        ObjCppParser.encodingExpr_return retval = new ObjCppParser.encodingExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal188=null;
        Token char_literal189=null;
        Token IDENTIFIER190=null;
        Token char_literal191=null;

        Object string_literal188_tree=null;
        Object char_literal189_tree=null;
        Object IDENTIFIER190_tree=null;
        Object char_literal191_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1234:2: ( '@encode' '(' IDENTIFIER ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1234:4: '@encode' '(' IDENTIFIER ')'
            {
            root_0 = (Object)adaptor.nil();

            string_literal188=(Token)match(input,74,FOLLOW_74_in_encodingExpr3595); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal188_tree = (Object)adaptor.create(string_literal188);
            adaptor.addChild(root_0, string_literal188_tree);
            }
            char_literal189=(Token)match(input,34,FOLLOW_34_in_encodingExpr3600); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal189_tree = (Object)adaptor.create(char_literal189);
            adaptor.addChild(root_0, char_literal189_tree);
            }
            IDENTIFIER190=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_encodingExpr3604); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER190_tree = (Object)adaptor.create(IDENTIFIER190);
            adaptor.addChild(root_0, IDENTIFIER190_tree);
            }
            char_literal191=(Token)match(input,35,FOLLOW_35_in_encodingExpr3609); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal191_tree = (Object)adaptor.create(char_literal191);
            adaptor.addChild(root_0, char_literal191_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1240:1: assignmentExpr returns [Expression expr] : e= inlineCondExpr (op= assignmentOp f= assignmentExpr )? ;
    public final ObjCppParser.assignmentExpr_return assignmentExpr() throws RecognitionException {
        ObjCppParser.assignmentExpr_return retval = new ObjCppParser.assignmentExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.inlineCondExpr_return e = null;

        ObjCppParser.assignmentOp_return op = null;

        ObjCppParser.assignmentExpr_return f = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1241:2: (e= inlineCondExpr (op= assignmentOp f= assignmentExpr )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1241:4: e= inlineCondExpr (op= assignmentOp f= assignmentExpr )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_inlineCondExpr_in_assignmentExpr3626);
            e=inlineCondExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1242:3: (op= assignmentOp f= assignmentExpr )?
            int alt86=2;
            alt86 = dfa86.predict(input);
            switch (alt86) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1243:4: op= assignmentOp f= assignmentExpr
                    {
                    pushFollow(FOLLOW_assignmentOp_in_assignmentExpr3642);
                    op=assignmentOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, op.getTree());
                    pushFollow(FOLLOW_assignmentExpr_in_assignmentExpr3646);
                    f=assignmentExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, f.getTree());
                    if ( state.backtracking==0 ) {
                       retval.expr = new AssignmentOp(retval.expr, (op!=null?op.op:null), (f!=null?f.expr:null)); 
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1247:1: assignmentOp returns [Expression.AssignmentOperator op] : o= ( '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=' ) ;
    public final ObjCppParser.assignmentOp_return assignmentOp() throws RecognitionException {
        ObjCppParser.assignmentOp_return retval = new ObjCppParser.assignmentOp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token o=null;

        Object o_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1248:2: (o= ( '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1248:5: o= ( '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=' )
            {
            root_0 = (Object)adaptor.nil();

            o=(Token)input.LT(1);
            if ( input.LA(1)==29||(input.LA(1)>=75 && input.LA(1)<=84) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(o));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {

              			retval.op = getAssignmentOperator((o!=null?o.getText():null));
              		
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1253:1: inlineCondExpr returns [Expression expr] : e= logOrExpr ( '?' logOrExpr ':' logOrExpr )* ;
    public final ObjCppParser.inlineCondExpr_return inlineCondExpr() throws RecognitionException {
        ObjCppParser.inlineCondExpr_return retval = new ObjCppParser.inlineCondExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal192=null;
        Token char_literal194=null;
        ObjCppParser.logOrExpr_return e = null;

        ObjCppParser.logOrExpr_return logOrExpr193 = null;

        ObjCppParser.logOrExpr_return logOrExpr195 = null;


        Object char_literal192_tree=null;
        Object char_literal194_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1254:2: (e= logOrExpr ( '?' logOrExpr ':' logOrExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1254:4: e= logOrExpr ( '?' logOrExpr ':' logOrExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_logOrExpr_in_inlineCondExpr3733);
            e=logOrExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1255:3: ( '?' logOrExpr ':' logOrExpr )*
            loop87:
            do {
                int alt87=2;
                alt87 = dfa87.predict(input);
                switch (alt87) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1256:4: '?' logOrExpr ':' logOrExpr
            	    {
            	    char_literal192=(Token)match(input,85,FOLLOW_85_in_inlineCondExpr3745); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal192_tree = (Object)adaptor.create(char_literal192);
            	    adaptor.addChild(root_0, char_literal192_tree);
            	    }
            	    pushFollow(FOLLOW_logOrExpr_in_inlineCondExpr3750);
            	    logOrExpr193=logOrExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logOrExpr193.getTree());
            	    char_literal194=(Token)match(input,33,FOLLOW_33_in_inlineCondExpr3756); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal194_tree = (Object)adaptor.create(char_literal194);
            	    adaptor.addChild(root_0, char_literal194_tree);
            	    }
            	    pushFollow(FOLLOW_logOrExpr_in_inlineCondExpr3761);
            	    logOrExpr195=logOrExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logOrExpr195.getTree());

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
    // $ANTLR end "inlineCondExpr"

    public static class addExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "addExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1263:1: addExpr returns [Expression expr] : e= multExpr (op= ( '+' | '-' ) f= multExpr )* ;
    public final ObjCppParser.addExpr_return addExpr() throws RecognitionException {
        ObjCppParser.addExpr_return retval = new ObjCppParser.addExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ObjCppParser.multExpr_return e = null;

        ObjCppParser.multExpr_return f = null;


        Object op_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1264:2: (e= multExpr (op= ( '+' | '-' ) f= multExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1264:4: e= multExpr (op= ( '+' | '-' ) f= multExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_multExpr_in_addExpr3783);
            e=multExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1265:3: (op= ( '+' | '-' ) f= multExpr )*
            loop88:
            do {
                int alt88=2;
                alt88 = dfa88.predict(input);
                switch (alt88) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1266:4: op= ( '+' | '-' ) f= multExpr
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

            	    pushFollow(FOLLOW_multExpr_in_addExpr3809);
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
    // $ANTLR end "addExpr"

    public static class multExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1271:1: multExpr returns [Expression expr] : e= castExpr (op= ( '%' | '*' | '/' ) f= castExpr )* ;
    public final ObjCppParser.multExpr_return multExpr() throws RecognitionException {
        ObjCppParser.multExpr_return retval = new ObjCppParser.multExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ObjCppParser.castExpr_return e = null;

        ObjCppParser.castExpr_return f = null;


        Object op_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1272:2: (e= castExpr (op= ( '%' | '*' | '/' ) f= castExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1272:4: e= castExpr (op= ( '%' | '*' | '/' ) f= castExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_castExpr_in_multExpr3833);
            e=castExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1273:3: (op= ( '%' | '*' | '/' ) f= castExpr )*
            loop89:
            do {
                int alt89=2;
                alt89 = dfa89.predict(input);
                switch (alt89) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1274:4: op= ( '%' | '*' | '/' ) f= castExpr
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

            	    pushFollow(FOLLOW_castExpr_in_multExpr3865);
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
    // $ANTLR end "multExpr"

    public static class bitOrExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bitOrExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1279:1: bitOrExpr returns [Expression expr] : e= xorExpr (op= '|' f= xorExpr )* ;
    public final ObjCppParser.bitOrExpr_return bitOrExpr() throws RecognitionException {
        ObjCppParser.bitOrExpr_return retval = new ObjCppParser.bitOrExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ObjCppParser.xorExpr_return e = null;

        ObjCppParser.xorExpr_return f = null;


        Object op_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1280:2: (e= xorExpr (op= '|' f= xorExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1280:4: e= xorExpr (op= '|' f= xorExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_xorExpr_in_bitOrExpr3889);
            e=xorExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1281:3: (op= '|' f= xorExpr )*
            loop90:
            do {
                int alt90=2;
                alt90 = dfa90.predict(input);
                switch (alt90) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1282:4: op= '|' f= xorExpr
            	    {
            	    op=(Token)match(input,67,FOLLOW_67_in_bitOrExpr3903); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    adaptor.addChild(root_0, op_tree);
            	    }
            	    pushFollow(FOLLOW_xorExpr_in_bitOrExpr3910);
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
    // $ANTLR end "bitOrExpr"

    public static class bitAndExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bitAndExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1287:1: bitAndExpr returns [Expression expr] : e= equalExpr (op= '&' f= equalExpr )* ;
    public final ObjCppParser.bitAndExpr_return bitAndExpr() throws RecognitionException {
        ObjCppParser.bitAndExpr_return retval = new ObjCppParser.bitAndExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ObjCppParser.equalExpr_return e = null;

        ObjCppParser.equalExpr_return f = null;


        Object op_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1288:2: (e= equalExpr (op= '&' f= equalExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1288:4: e= equalExpr (op= '&' f= equalExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_equalExpr_in_bitAndExpr3934);
            e=equalExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1289:3: (op= '&' f= equalExpr )*
            loop91:
            do {
                int alt91=2;
                alt91 = dfa91.predict(input);
                switch (alt91) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1290:4: op= '&' f= equalExpr
            	    {
            	    op=(Token)match(input,54,FOLLOW_54_in_bitAndExpr3947); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    adaptor.addChild(root_0, op_tree);
            	    }
            	    pushFollow(FOLLOW_equalExpr_in_bitAndExpr3954);
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
    // $ANTLR end "bitAndExpr"

    public static class shiftExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "shiftExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1296:1: shiftExpr returns [Expression expr] : e= addExpr (op= ( '>>' | '<<' ) f= addExpr )* ;
    public final ObjCppParser.shiftExpr_return shiftExpr() throws RecognitionException {
        ObjCppParser.shiftExpr_return retval = new ObjCppParser.shiftExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ObjCppParser.addExpr_return e = null;

        ObjCppParser.addExpr_return f = null;


        Object op_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1297:2: (e= addExpr (op= ( '>>' | '<<' ) f= addExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1297:4: e= addExpr (op= ( '>>' | '<<' ) f= addExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_addExpr_in_shiftExpr3979);
            e=addExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1298:3: (op= ( '>>' | '<<' ) f= addExpr )*
            loop92:
            do {
                int alt92=2;
                alt92 = dfa92.predict(input);
                switch (alt92) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1299:4: op= ( '>>' | '<<' ) f= addExpr
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

            	    pushFollow(FOLLOW_addExpr_in_shiftExpr4005);
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
    // $ANTLR end "shiftExpr"

    public static class xorExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "xorExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1304:1: xorExpr returns [Expression expr] : e= bitAndExpr (op= '^' f= bitAndExpr )* ;
    public final ObjCppParser.xorExpr_return xorExpr() throws RecognitionException {
        ObjCppParser.xorExpr_return retval = new ObjCppParser.xorExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ObjCppParser.bitAndExpr_return e = null;

        ObjCppParser.bitAndExpr_return f = null;


        Object op_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1305:2: (e= bitAndExpr (op= '^' f= bitAndExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1305:4: e= bitAndExpr (op= '^' f= bitAndExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_bitAndExpr_in_xorExpr4029);
            e=bitAndExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1306:3: (op= '^' f= bitAndExpr )*
            loop93:
            do {
                int alt93=2;
                alt93 = dfa93.predict(input);
                switch (alt93) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1307:4: op= '^' f= bitAndExpr
            	    {
            	    op=(Token)match(input,58,FOLLOW_58_in_xorExpr4042); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    adaptor.addChild(root_0, op_tree);
            	    }
            	    pushFollow(FOLLOW_bitAndExpr_in_xorExpr4049);
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
    // $ANTLR end "xorExpr"

    public static class logOrExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logOrExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1312:1: logOrExpr returns [Expression expr] : e= logAndExpr (op= '||' f= logAndExpr )* ;
    public final ObjCppParser.logOrExpr_return logOrExpr() throws RecognitionException {
        ObjCppParser.logOrExpr_return retval = new ObjCppParser.logOrExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ObjCppParser.logAndExpr_return e = null;

        ObjCppParser.logAndExpr_return f = null;


        Object op_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1313:2: (e= logAndExpr (op= '||' f= logAndExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1313:4: e= logAndExpr (op= '||' f= logAndExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_logAndExpr_in_logOrExpr4073);
            e=logAndExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1314:3: (op= '||' f= logAndExpr )*
            loop94:
            do {
                int alt94=2;
                alt94 = dfa94.predict(input);
                switch (alt94) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1315:4: op= '||' f= logAndExpr
            	    {
            	    op=(Token)match(input,66,FOLLOW_66_in_logOrExpr4086); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    adaptor.addChild(root_0, op_tree);
            	    }
            	    pushFollow(FOLLOW_logAndExpr_in_logOrExpr4093);
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
    // $ANTLR end "logOrExpr"

    public static class logAndExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logAndExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1320:1: logAndExpr returns [Expression expr] : e= bitOrExpr (op= '&&' f= bitOrExpr )* ;
    public final ObjCppParser.logAndExpr_return logAndExpr() throws RecognitionException {
        ObjCppParser.logAndExpr_return retval = new ObjCppParser.logAndExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ObjCppParser.bitOrExpr_return e = null;

        ObjCppParser.bitOrExpr_return f = null;


        Object op_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1321:2: (e= bitOrExpr (op= '&&' f= bitOrExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1321:4: e= bitOrExpr (op= '&&' f= bitOrExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_bitOrExpr_in_logAndExpr4117);
            e=bitOrExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1322:3: (op= '&&' f= bitOrExpr )*
            loop95:
            do {
                int alt95=2;
                alt95 = dfa95.predict(input);
                switch (alt95) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1323:4: op= '&&' f= bitOrExpr
            	    {
            	    op=(Token)match(input,68,FOLLOW_68_in_logAndExpr4130); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    adaptor.addChild(root_0, op_tree);
            	    }
            	    pushFollow(FOLLOW_bitOrExpr_in_logAndExpr4137);
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
    // $ANTLR end "logAndExpr"

    public static class equalExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "equalExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1328:1: equalExpr returns [Expression expr] : e= compareExpr (op= ( '!=' | '==' ) f= compareExpr )* ;
    public final ObjCppParser.equalExpr_return equalExpr() throws RecognitionException {
        ObjCppParser.equalExpr_return retval = new ObjCppParser.equalExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ObjCppParser.compareExpr_return e = null;

        ObjCppParser.compareExpr_return f = null;


        Object op_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1329:2: (e= compareExpr (op= ( '!=' | '==' ) f= compareExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1329:4: e= compareExpr (op= ( '!=' | '==' ) f= compareExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_compareExpr_in_equalExpr4161);
            e=compareExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1330:3: (op= ( '!=' | '==' ) f= compareExpr )*
            loop96:
            do {
                int alt96=2;
                alt96 = dfa96.predict(input);
                switch (alt96) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1331:4: op= ( '!=' | '==' ) f= compareExpr
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

            	    pushFollow(FOLLOW_compareExpr_in_equalExpr4187);
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
            	    break loop96;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1336:1: compareExpr returns [Expression expr] : e= shiftExpr (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )* ;
    public final ObjCppParser.compareExpr_return compareExpr() throws RecognitionException {
        ObjCppParser.compareExpr_return retval = new ObjCppParser.compareExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        ObjCppParser.shiftExpr_return e = null;

        ObjCppParser.shiftExpr_return f = null;


        Object op_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1337:2: (e= shiftExpr (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1337:4: e= shiftExpr (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_shiftExpr_in_compareExpr4211);
            e=shiftExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (e!=null?e.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1338:3: (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )*
            loop97:
            do {
                int alt97=2;
                alt97 = dfa97.predict(input);
                switch (alt97) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1339:4: op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr
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

            	    pushFollow(FOLLOW_shiftExpr_in_compareExpr4246);
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
            	    break loop97;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1344:1: castExpr returns [Expression expr] : ( '(' tr= mutableTypeRef ')' inner= castExpr | e= unaryExpr );
    public final ObjCppParser.castExpr_return castExpr() throws RecognitionException {
        ObjCppParser.castExpr_return retval = new ObjCppParser.castExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal196=null;
        Token char_literal197=null;
        ObjCppParser.mutableTypeRef_return tr = null;

        ObjCppParser.castExpr_return inner = null;

        ObjCppParser.unaryExpr_return e = null;


        Object char_literal196_tree=null;
        Object char_literal197_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1345:2: ( '(' tr= mutableTypeRef ')' inner= castExpr | e= unaryExpr )
            int alt98=2;
            alt98 = dfa98.predict(input);
            switch (alt98) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1345:4: '(' tr= mutableTypeRef ')' inner= castExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal196=(Token)match(input,34,FOLLOW_34_in_castExpr4268); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal196_tree = (Object)adaptor.create(char_literal196);
                    adaptor.addChild(root_0, char_literal196_tree);
                    }
                    pushFollow(FOLLOW_mutableTypeRef_in_castExpr4272);
                    tr=mutableTypeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tr.getTree());
                    char_literal197=(Token)match(input,35,FOLLOW_35_in_castExpr4274); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal197_tree = (Object)adaptor.create(char_literal197);
                    adaptor.addChild(root_0, char_literal197_tree);
                    }
                    pushFollow(FOLLOW_castExpr_in_castExpr4278);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1346:3: e= unaryExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_unaryExpr_in_castExpr4289);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1349:1: unaryExpr returns [Expression expr] : (p= postfixExpr | unaryOp castExpr | 'sizeof' ( '(' tr= mutableTypeRef ')' | unaryExpr ) );
    public final ObjCppParser.unaryExpr_return unaryExpr() throws RecognitionException {
        ObjCppParser.unaryExpr_return retval = new ObjCppParser.unaryExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal200=null;
        Token char_literal201=null;
        Token char_literal202=null;
        ObjCppParser.postfixExpr_return p = null;

        ObjCppParser.mutableTypeRef_return tr = null;

        ObjCppParser.unaryOp_return unaryOp198 = null;

        ObjCppParser.castExpr_return castExpr199 = null;

        ObjCppParser.unaryExpr_return unaryExpr203 = null;


        Object string_literal200_tree=null;
        Object char_literal201_tree=null;
        Object char_literal202_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1350:2: (p= postfixExpr | unaryOp castExpr | 'sizeof' ( '(' tr= mutableTypeRef ')' | unaryExpr ) )
            int alt100=3;
            alt100 = dfa100.predict(input);
            switch (alt100) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1351:3: p= postfixExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_postfixExpr_in_unaryExpr4311);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1352:3: unaryOp castExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_unaryOp_in_unaryExpr4319);
                    unaryOp198=unaryOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryOp198.getTree());
                    pushFollow(FOLLOW_castExpr_in_unaryExpr4321);
                    castExpr199=castExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, castExpr199.getTree());
                    if ( state.backtracking==0 ) {
                       retval.expr = new UnaryOp((castExpr199!=null?castExpr199.expr:null), Expression.getUnaryOperator((unaryOp198!=null?input.toString(unaryOp198.start,unaryOp198.stop):null))); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1353:3: 'sizeof' ( '(' tr= mutableTypeRef ')' | unaryExpr )
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal200=(Token)match(input,86,FOLLOW_86_in_unaryExpr4329); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal200_tree = (Object)adaptor.create(string_literal200);
                    adaptor.addChild(root_0, string_literal200_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1353:12: ( '(' tr= mutableTypeRef ')' | unaryExpr )
                    int alt99=2;
                    alt99 = dfa99.predict(input);
                    switch (alt99) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1354:4: '(' tr= mutableTypeRef ')'
                            {
                            char_literal201=(Token)match(input,34,FOLLOW_34_in_unaryExpr4336); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal201_tree = (Object)adaptor.create(char_literal201);
                            adaptor.addChild(root_0, char_literal201_tree);
                            }
                            pushFollow(FOLLOW_mutableTypeRef_in_unaryExpr4340);
                            tr=mutableTypeRef();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, tr.getTree());
                            char_literal202=(Token)match(input,35,FOLLOW_35_in_unaryExpr4342); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal202_tree = (Object)adaptor.create(char_literal202);
                            adaptor.addChild(root_0, char_literal202_tree);
                            }

                            }
                            break;
                        case 2 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1355:4: unaryExpr
                            {
                            pushFollow(FOLLOW_unaryExpr_in_unaryExpr4350);
                            unaryExpr203=unaryExpr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpr203.getTree());

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
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unaryOp"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1359:1: unaryOp : ( '++' | '--' | '&' | '*' | '-' | '~' | '!' );
    public final ObjCppParser.unaryOp_return unaryOp() throws RecognitionException {
        ObjCppParser.unaryOp_return retval = new ObjCppParser.unaryOp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set204=null;

        Object set204_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1359:9: ( '++' | '--' | '&' | '*' | '-' | '~' | '!' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:
            {
            root_0 = (Object)adaptor.nil();

            set204=(Token)input.LT(1);
            if ( input.LA(1)==43||input.LA(1)==51||(input.LA(1)>=53 && input.LA(1)<=54)||(input.LA(1)>=87 && input.LA(1)<=89) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set204));
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
    // $ANTLR end "unaryOp"

    public static class postfixExpr_return extends ParserRuleReturnScope {
        public Expression expr;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "postfixExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1361:1: postfixExpr returns [Expression expr] : baseExpression ( '[' expression ']' | '(' ( topLevelExprList )? ')' | '.' di= IDENTIFIER | '->' ai= IDENTIFIER | '++' | '--' )* ;
    public final ObjCppParser.postfixExpr_return postfixExpr() throws RecognitionException {
        ObjCppParser.postfixExpr_return retval = new ObjCppParser.postfixExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token di=null;
        Token ai=null;
        Token char_literal206=null;
        Token char_literal208=null;
        Token char_literal209=null;
        Token char_literal211=null;
        Token char_literal212=null;
        Token string_literal213=null;
        Token string_literal214=null;
        Token string_literal215=null;
        ObjCppParser.baseExpression_return baseExpression205 = null;

        ObjCppParser.expression_return expression207 = null;

        ObjCppParser.topLevelExprList_return topLevelExprList210 = null;


        Object di_tree=null;
        Object ai_tree=null;
        Object char_literal206_tree=null;
        Object char_literal208_tree=null;
        Object char_literal209_tree=null;
        Object char_literal211_tree=null;
        Object char_literal212_tree=null;
        Object string_literal213_tree=null;
        Object string_literal214_tree=null;
        Object string_literal215_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1362:2: ( baseExpression ( '[' expression ']' | '(' ( topLevelExprList )? ')' | '.' di= IDENTIFIER | '->' ai= IDENTIFIER | '++' | '--' )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1363:3: baseExpression ( '[' expression ']' | '(' ( topLevelExprList )? ')' | '.' di= IDENTIFIER | '->' ai= IDENTIFIER | '++' | '--' )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_baseExpression_in_postfixExpr4407);
            baseExpression205=baseExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, baseExpression205.getTree());
            if ( state.backtracking==0 ) {
               retval.expr = (baseExpression205!=null?baseExpression205.expr:null); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1364:3: ( '[' expression ']' | '(' ( topLevelExprList )? ')' | '.' di= IDENTIFIER | '->' ai= IDENTIFIER | '++' | '--' )*
            loop102:
            do {
                int alt102=7;
                alt102 = dfa102.predict(input);
                switch (alt102) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1365:4: '[' expression ']'
            	    {
            	    char_literal206=(Token)match(input,55,FOLLOW_55_in_postfixExpr4418); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal206_tree = (Object)adaptor.create(char_literal206);
            	    adaptor.addChild(root_0, char_literal206_tree);
            	    }
            	    pushFollow(FOLLOW_expression_in_postfixExpr4420);
            	    expression207=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression207.getTree());
            	    char_literal208=(Token)match(input,56,FOLLOW_56_in_postfixExpr4422); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal208_tree = (Object)adaptor.create(char_literal208);
            	    adaptor.addChild(root_0, char_literal208_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      				retval.expr = new ArrayAccess(retval.expr, (expression207!=null?expression207.expr:null)); 
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1368:4: '(' ( topLevelExprList )? ')'
            	    {
            	    char_literal209=(Token)match(input,34,FOLLOW_34_in_postfixExpr4431); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal209_tree = (Object)adaptor.create(char_literal209);
            	    adaptor.addChild(root_0, char_literal209_tree);
            	    }
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1368:8: ( topLevelExprList )?
            	    int alt101=2;
            	    alt101 = dfa101.predict(input);
            	    switch (alt101) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: topLevelExprList
            	            {
            	            pushFollow(FOLLOW_topLevelExprList_in_postfixExpr4433);
            	            topLevelExprList210=topLevelExprList();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, topLevelExprList210.getTree());

            	            }
            	            break;

            	    }

            	    char_literal211=(Token)match(input,35,FOLLOW_35_in_postfixExpr4436); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal211_tree = (Object)adaptor.create(char_literal211);
            	    adaptor.addChild(root_0, char_literal211_tree);
            	    }
            	    if ( state.backtracking==0 ) {

            	      				FunctionCall fc = new FunctionCall(retval.expr);
            	      				if ((topLevelExprList210!=null?topLevelExprList210.exprs:null) != null)
            	      					for (Expression x : (topLevelExprList210!=null?topLevelExprList210.exprs:null))
            	      						fc.addArgument(x);
            	      				retval.expr = fc;
            	      			
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1375:4: '.' di= IDENTIFIER
            	    {
            	    char_literal212=(Token)match(input,90,FOLLOW_90_in_postfixExpr4445); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal212_tree = (Object)adaptor.create(char_literal212);
            	    adaptor.addChild(root_0, char_literal212_tree);
            	    }
            	    di=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_postfixExpr4449); if (state.failed) return retval;
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1378:4: '->' ai= IDENTIFIER
            	    {
            	    string_literal213=(Token)match(input,91,FOLLOW_91_in_postfixExpr4458); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal213_tree = (Object)adaptor.create(string_literal213);
            	    adaptor.addChild(root_0, string_literal213_tree);
            	    }
            	    ai=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_postfixExpr4462); if (state.failed) return retval;
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1381:4: '++'
            	    {
            	    string_literal214=(Token)match(input,87,FOLLOW_87_in_postfixExpr4471); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal214_tree = (Object)adaptor.create(string_literal214);
            	    adaptor.addChild(root_0, string_literal214_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      				retval.expr = new UnaryOp(retval.expr, UnaryOperator.PostIncr); 
            	      			
            	    }

            	    }
            	    break;
            	case 6 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1384:4: '--'
            	    {
            	    string_literal215=(Token)match(input,88,FOLLOW_88_in_postfixExpr4480); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal215_tree = (Object)adaptor.create(string_literal215);
            	    adaptor.addChild(root_0, string_literal215_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      				retval.expr = new UnaryOp(retval.expr, UnaryOperator.PostDecr); 
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop102;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1390:1: topLevelExpr returns [Expression expr] : e= assignmentExpr ;
    public final ObjCppParser.topLevelExpr_return topLevelExpr() throws RecognitionException {
        ObjCppParser.topLevelExpr_return retval = new ObjCppParser.topLevelExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.assignmentExpr_return e = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1391:2: (e= assignmentExpr )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1391:4: e= assignmentExpr
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_assignmentExpr_in_topLevelExpr4504);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1393:1: topLevelExprList returns [List<Expression> exprs] : e= topLevelExpr ( ',' f= topLevelExpr )* ;
    public final ObjCppParser.topLevelExprList_return topLevelExprList() throws RecognitionException {
        ObjCppParser.topLevelExprList_return retval = new ObjCppParser.topLevelExprList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal216=null;
        ObjCppParser.topLevelExpr_return e = null;

        ObjCppParser.topLevelExpr_return f = null;


        Object char_literal216_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1394:2: (e= topLevelExpr ( ',' f= topLevelExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1395:3: e= topLevelExpr ( ',' f= topLevelExpr )*
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.exprs = new ArrayList<Expression>(); 
            }
            pushFollow(FOLLOW_topLevelExpr_in_topLevelExprList4529);
            e=topLevelExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( state.backtracking==0 ) {
               retval.exprs.add((e!=null?e.expr:null)); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1397:3: ( ',' f= topLevelExpr )*
            loop103:
            do {
                int alt103=2;
                alt103 = dfa103.predict(input);
                switch (alt103) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1398:4: ',' f= topLevelExpr
            	    {
            	    char_literal216=(Token)match(input,28,FOLLOW_28_in_topLevelExprList4540); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal216_tree = (Object)adaptor.create(char_literal216);
            	    adaptor.addChild(root_0, char_literal216_tree);
            	    }
            	    pushFollow(FOLLOW_topLevelExpr_in_topLevelExprList4547);
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
            	    break loop103;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1403:1: expression returns [Expression expr] : l= topLevelExprList ;
    public final ObjCppParser.expression_return expression() throws RecognitionException {
        ObjCppParser.expression_return retval = new ObjCppParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ObjCppParser.topLevelExprList_return l = null;



        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1404:2: (l= topLevelExprList )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1404:4: l= topLevelExprList
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_topLevelExprList_in_expression4571);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1415:1: statementsBlock returns [Block stat] : '{' ( statement )* '}' ;
    public final ObjCppParser.statementsBlock_return statementsBlock() throws RecognitionException {
        Symbols_stack.push(new Symbols_scope());

        ObjCppParser.statementsBlock_return retval = new ObjCppParser.statementsBlock_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal217=null;
        Token char_literal219=null;
        ObjCppParser.statement_return statement218 = null;


        Object char_literal217_tree=null;
        Object char_literal219_tree=null;


        	((Symbols_scope)Symbols_stack.peek()).typeIdentifiers = new HashSet<String>();

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1420:2: ( '{' ( statement )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1420:4: '{' ( statement )* '}'
            {
            root_0 = (Object)adaptor.nil();

            if ( state.backtracking==0 ) {
               retval.stat = new Block(); 
            }
            char_literal217=(Token)match(input,23,FOLLOW_23_in_statementsBlock4605); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal217_tree = (Object)adaptor.create(char_literal217);
            adaptor.addChild(root_0, char_literal217_tree);
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1422:3: ( statement )*
            loop104:
            do {
                int alt104=2;
                alt104 = dfa104.predict(input);
                switch (alt104) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1423:6: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_statementsBlock4617);
            	    statement218=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement218.getTree());
            	    if ( state.backtracking==0 ) {

            	      				retval.stat.addStatement((statement218!=null?statement218.stat:null));
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop104;
                }
            } while (true);

            char_literal219=(Token)match(input,24,FOLLOW_24_in_statementsBlock4629); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal219_tree = (Object)adaptor.create(char_literal219);
            adaptor.addChild(root_0, char_literal219_tree);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1429:1: statement returns [Statement stat] : (b= statementsBlock | declaration | es= expression ';' | rt= 'return' rex= expression ';' | 'if' '(' expression ')' statement ( 'else' statement )? | 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement );
    public final ObjCppParser.statement_return statement() throws RecognitionException {
        ObjCppParser.statement_return retval = new ObjCppParser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token rt=null;
        Token char_literal221=null;
        Token char_literal222=null;
        Token string_literal223=null;
        Token char_literal224=null;
        Token char_literal226=null;
        Token string_literal228=null;
        Token string_literal230=null;
        Token char_literal231=null;
        Token char_literal233=null;
        Token string_literal235=null;
        Token string_literal237=null;
        Token char_literal238=null;
        Token char_literal240=null;
        Token char_literal241=null;
        Token string_literal242=null;
        Token char_literal243=null;
        Token char_literal245=null;
        Token char_literal247=null;
        Token char_literal249=null;
        Token string_literal251=null;
        Token char_literal252=null;
        Token char_literal254=null;
        Token char_literal255=null;
        Token string_literal256=null;
        Token char_literal258=null;
        Token char_literal260=null;
        Token char_literal261=null;
        Token IDENTIFIER262=null;
        Token char_literal263=null;
        Token char_literal265=null;
        Token char_literal267=null;
        ObjCppParser.statementsBlock_return b = null;

        ObjCppParser.expression_return es = null;

        ObjCppParser.expression_return rex = null;

        ObjCppParser.declaration_return declaration220 = null;

        ObjCppParser.expression_return expression225 = null;

        ObjCppParser.statement_return statement227 = null;

        ObjCppParser.statement_return statement229 = null;

        ObjCppParser.expression_return expression232 = null;

        ObjCppParser.statement_return statement234 = null;

        ObjCppParser.statement_return statement236 = null;

        ObjCppParser.expression_return expression239 = null;

        ObjCppParser.statement_return statement244 = null;

        ObjCppParser.expression_return expression246 = null;

        ObjCppParser.statement_return statement248 = null;

        ObjCppParser.statement_return statement250 = null;

        ObjCppParser.expression_return expression253 = null;

        ObjCppParser.expression_return expression257 = null;

        ObjCppParser.statement_return statement259 = null;

        ObjCppParser.varDecl_return varDecl264 = null;

        ObjCppParser.expression_return expression266 = null;

        ObjCppParser.statement_return statement268 = null;


        Object rt_tree=null;
        Object char_literal221_tree=null;
        Object char_literal222_tree=null;
        Object string_literal223_tree=null;
        Object char_literal224_tree=null;
        Object char_literal226_tree=null;
        Object string_literal228_tree=null;
        Object string_literal230_tree=null;
        Object char_literal231_tree=null;
        Object char_literal233_tree=null;
        Object string_literal235_tree=null;
        Object string_literal237_tree=null;
        Object char_literal238_tree=null;
        Object char_literal240_tree=null;
        Object char_literal241_tree=null;
        Object string_literal242_tree=null;
        Object char_literal243_tree=null;
        Object char_literal245_tree=null;
        Object char_literal247_tree=null;
        Object char_literal249_tree=null;
        Object string_literal251_tree=null;
        Object char_literal252_tree=null;
        Object char_literal254_tree=null;
        Object char_literal255_tree=null;
        Object string_literal256_tree=null;
        Object char_literal258_tree=null;
        Object char_literal260_tree=null;
        Object char_literal261_tree=null;
        Object IDENTIFIER262_tree=null;
        Object char_literal263_tree=null;
        Object char_literal265_tree=null;
        Object char_literal267_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1430:2: (b= statementsBlock | declaration | es= expression ';' | rt= 'return' rex= expression ';' | 'if' '(' expression ')' statement ( 'else' statement )? | 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement )
            int alt110=11;
            alt110 = dfa110.predict(input);
            switch (alt110) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1431:3: b= statementsBlock
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_statementsBlock_in_statement4648);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1432:3: declaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_declaration_in_statement4656);
                    declaration220=declaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration220.getTree());

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1433:3: es= expression ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_expression_in_statement4665);
                    es=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, es.getTree());
                    char_literal221=(Token)match(input,25,FOLLOW_25_in_statement4667); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal221_tree = (Object)adaptor.create(char_literal221);
                    adaptor.addChild(root_0, char_literal221_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.stat = new ExpressionStatement((es!=null?es.expr:null)); 
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1434:3: rt= 'return' rex= expression ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    rt=(Token)match(input,52,FOLLOW_52_in_statement4677); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    rt_tree = (Object)adaptor.create(rt);
                    adaptor.addChild(root_0, rt_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement4681);
                    rex=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rex.getTree());
                    char_literal222=(Token)match(input,25,FOLLOW_25_in_statement4683); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal222_tree = (Object)adaptor.create(char_literal222);
                    adaptor.addChild(root_0, char_literal222_tree);
                    }
                    if ( state.backtracking==0 ) {
                       
                      			retval.stat = mark(new Return((rex!=null?rex.expr:null)), getLine(rt));
                      		
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1437:3: 'if' '(' expression ')' statement ( 'else' statement )?
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal223=(Token)match(input,92,FOLLOW_92_in_statement4691); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal223_tree = (Object)adaptor.create(string_literal223);
                    adaptor.addChild(root_0, string_literal223_tree);
                    }
                    char_literal224=(Token)match(input,34,FOLLOW_34_in_statement4693); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal224_tree = (Object)adaptor.create(char_literal224);
                    adaptor.addChild(root_0, char_literal224_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement4695);
                    expression225=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression225.getTree());
                    char_literal226=(Token)match(input,35,FOLLOW_35_in_statement4697); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal226_tree = (Object)adaptor.create(char_literal226);
                    adaptor.addChild(root_0, char_literal226_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement4699);
                    statement227=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement227.getTree());
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1437:37: ( 'else' statement )?
                    int alt105=2;
                    alt105 = dfa105.predict(input);
                    switch (alt105) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1437:38: 'else' statement
                            {
                            string_literal228=(Token)match(input,93,FOLLOW_93_in_statement4702); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            string_literal228_tree = (Object)adaptor.create(string_literal228);
                            adaptor.addChild(root_0, string_literal228_tree);
                            }
                            pushFollow(FOLLOW_statement_in_statement4704);
                            statement229=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement229.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1438:3: 'while' '(' expression ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal230=(Token)match(input,94,FOLLOW_94_in_statement4713); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal230_tree = (Object)adaptor.create(string_literal230);
                    adaptor.addChild(root_0, string_literal230_tree);
                    }
                    char_literal231=(Token)match(input,34,FOLLOW_34_in_statement4715); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal231_tree = (Object)adaptor.create(char_literal231);
                    adaptor.addChild(root_0, char_literal231_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement4717);
                    expression232=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression232.getTree());
                    char_literal233=(Token)match(input,35,FOLLOW_35_in_statement4719); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal233_tree = (Object)adaptor.create(char_literal233);
                    adaptor.addChild(root_0, char_literal233_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement4721);
                    statement234=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement234.getTree());

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1439:3: 'do' statement 'while' '(' expression ')' ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal235=(Token)match(input,95,FOLLOW_95_in_statement4728); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal235_tree = (Object)adaptor.create(string_literal235);
                    adaptor.addChild(root_0, string_literal235_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement4730);
                    statement236=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement236.getTree());
                    string_literal237=(Token)match(input,94,FOLLOW_94_in_statement4732); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal237_tree = (Object)adaptor.create(string_literal237);
                    adaptor.addChild(root_0, string_literal237_tree);
                    }
                    char_literal238=(Token)match(input,34,FOLLOW_34_in_statement4734); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal238_tree = (Object)adaptor.create(char_literal238);
                    adaptor.addChild(root_0, char_literal238_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement4736);
                    expression239=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression239.getTree());
                    char_literal240=(Token)match(input,35,FOLLOW_35_in_statement4738); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal240_tree = (Object)adaptor.create(char_literal240);
                    adaptor.addChild(root_0, char_literal240_tree);
                    }
                    char_literal241=(Token)match(input,25,FOLLOW_25_in_statement4740); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal241_tree = (Object)adaptor.create(char_literal241);
                    adaptor.addChild(root_0, char_literal241_tree);
                    }

                    }
                    break;
                case 8 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1440:3: 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal242=(Token)match(input,96,FOLLOW_96_in_statement4747); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal242_tree = (Object)adaptor.create(string_literal242);
                    adaptor.addChild(root_0, string_literal242_tree);
                    }
                    char_literal243=(Token)match(input,34,FOLLOW_34_in_statement4749); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal243_tree = (Object)adaptor.create(char_literal243);
                    adaptor.addChild(root_0, char_literal243_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1440:13: ( statement )?
                    int alt106=2;
                    alt106 = dfa106.predict(input);
                    switch (alt106) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: statement
                            {
                            pushFollow(FOLLOW_statement_in_statement4751);
                            statement244=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement244.getTree());

                            }
                            break;

                    }

                    char_literal245=(Token)match(input,25,FOLLOW_25_in_statement4754); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal245_tree = (Object)adaptor.create(char_literal245);
                    adaptor.addChild(root_0, char_literal245_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1440:28: ( expression )?
                    int alt107=2;
                    alt107 = dfa107.predict(input);
                    switch (alt107) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement4756);
                            expression246=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression246.getTree());

                            }
                            break;

                    }

                    char_literal247=(Token)match(input,25,FOLLOW_25_in_statement4759); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal247_tree = (Object)adaptor.create(char_literal247);
                    adaptor.addChild(root_0, char_literal247_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1440:44: ( statement )?
                    int alt108=2;
                    alt108 = dfa108.predict(input);
                    switch (alt108) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: statement
                            {
                            pushFollow(FOLLOW_statement_in_statement4761);
                            statement248=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement248.getTree());

                            }
                            break;

                    }

                    char_literal249=(Token)match(input,35,FOLLOW_35_in_statement4764); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal249_tree = (Object)adaptor.create(char_literal249);
                    adaptor.addChild(root_0, char_literal249_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement4766);
                    statement250=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement250.getTree());

                    }
                    break;
                case 9 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1441:3: 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal251=(Token)match(input,97,FOLLOW_97_in_statement4773); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal251_tree = (Object)adaptor.create(string_literal251);
                    adaptor.addChild(root_0, string_literal251_tree);
                    }
                    char_literal252=(Token)match(input,34,FOLLOW_34_in_statement4775); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal252_tree = (Object)adaptor.create(char_literal252);
                    adaptor.addChild(root_0, char_literal252_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement4777);
                    expression253=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression253.getTree());
                    char_literal254=(Token)match(input,35,FOLLOW_35_in_statement4779); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal254_tree = (Object)adaptor.create(char_literal254);
                    adaptor.addChild(root_0, char_literal254_tree);
                    }
                    char_literal255=(Token)match(input,23,FOLLOW_23_in_statement4781); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal255_tree = (Object)adaptor.create(char_literal255);
                    adaptor.addChild(root_0, char_literal255_tree);
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1442:3: ( 'case' expression ':' | statement )*
                    loop109:
                    do {
                        int alt109=3;
                        alt109 = dfa109.predict(input);
                        switch (alt109) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1442:5: 'case' expression ':'
                    	    {
                    	    string_literal256=(Token)match(input,98,FOLLOW_98_in_statement4788); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    string_literal256_tree = (Object)adaptor.create(string_literal256);
                    	    adaptor.addChild(root_0, string_literal256_tree);
                    	    }
                    	    pushFollow(FOLLOW_expression_in_statement4790);
                    	    expression257=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression257.getTree());
                    	    char_literal258=(Token)match(input,33,FOLLOW_33_in_statement4792); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal258_tree = (Object)adaptor.create(char_literal258);
                    	    adaptor.addChild(root_0, char_literal258_tree);
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1443:4: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement4799);
                    	    statement259=statement();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement259.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop109;
                        }
                    } while (true);

                    char_literal260=(Token)match(input,24,FOLLOW_24_in_statement4808); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal260_tree = (Object)adaptor.create(char_literal260);
                    adaptor.addChild(root_0, char_literal260_tree);
                    }

                    }
                    break;
                case 10 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1446:3: ';'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal261=(Token)match(input,25,FOLLOW_25_in_statement4814); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal261_tree = (Object)adaptor.create(char_literal261);
                    adaptor.addChild(root_0, char_literal261_tree);
                    }

                    }
                    break;
                case 11 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1447:3: {...}? IDENTIFIER '(' varDecl ':' expression ')' statement
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !(( next("foreach") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "statement", " next(\"foreach\") ");
                    }
                    IDENTIFIER262=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement4822); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER262_tree = (Object)adaptor.create(IDENTIFIER262);
                    adaptor.addChild(root_0, IDENTIFIER262_tree);
                    }
                    char_literal263=(Token)match(input,34,FOLLOW_34_in_statement4824); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal263_tree = (Object)adaptor.create(char_literal263);
                    adaptor.addChild(root_0, char_literal263_tree);
                    }
                    pushFollow(FOLLOW_varDecl_in_statement4826);
                    varDecl264=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varDecl264.getTree());
                    char_literal265=(Token)match(input,33,FOLLOW_33_in_statement4828); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal265_tree = (Object)adaptor.create(char_literal265);
                    adaptor.addChild(root_0, char_literal265_tree);
                    }
                    pushFollow(FOLLOW_expression_in_statement4830);
                    expression266=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression266.getTree());
                    char_literal267=(Token)match(input,35,FOLLOW_35_in_statement4832); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal267_tree = (Object)adaptor.create(char_literal267);
                    adaptor.addChild(root_0, char_literal267_tree);
                    }
                    pushFollow(FOLLOW_statement_in_statement4834);
                    statement268=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement268.getTree());

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1450:1: constant returns [Constant constant] : ( DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER | CHARACTER | FLOAT_NUMBER | STRING );
    public final ObjCppParser.constant_return constant() throws RecognitionException {
        ObjCppParser.constant_return retval = new ObjCppParser.constant_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DECIMAL_NUMBER269=null;
        Token HEXADECIMAL_NUMBER270=null;
        Token OCTAL_NUMBER271=null;
        Token CHARACTER272=null;
        Token FLOAT_NUMBER273=null;
        Token STRING274=null;

        Object DECIMAL_NUMBER269_tree=null;
        Object HEXADECIMAL_NUMBER270_tree=null;
        Object OCTAL_NUMBER271_tree=null;
        Object CHARACTER272_tree=null;
        Object FLOAT_NUMBER273_tree=null;
        Object STRING274_tree=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1451:2: ( DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER | CHARACTER | FLOAT_NUMBER | STRING )
            int alt111=6;
            switch ( input.LA(1) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1451:4: DECIMAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    DECIMAL_NUMBER269=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_constant4851); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DECIMAL_NUMBER269_tree = (Object)adaptor.create(DECIMAL_NUMBER269);
                    adaptor.addChild(root_0, DECIMAL_NUMBER269_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant =  Constant.parseDecimal((DECIMAL_NUMBER269!=null?DECIMAL_NUMBER269.getText():null)); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1452:3: HEXADECIMAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    HEXADECIMAL_NUMBER270=(Token)match(input,HEXADECIMAL_NUMBER,FOLLOW_HEXADECIMAL_NUMBER_in_constant4859); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    HEXADECIMAL_NUMBER270_tree = (Object)adaptor.create(HEXADECIMAL_NUMBER270);
                    adaptor.addChild(root_0, HEXADECIMAL_NUMBER270_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant = Constant.parseHex((HEXADECIMAL_NUMBER270!=null?HEXADECIMAL_NUMBER270.getText():null)); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1453:3: OCTAL_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    OCTAL_NUMBER271=(Token)match(input,OCTAL_NUMBER,FOLLOW_OCTAL_NUMBER_in_constant4867); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OCTAL_NUMBER271_tree = (Object)adaptor.create(OCTAL_NUMBER271);
                    adaptor.addChild(root_0, OCTAL_NUMBER271_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant = Constant.parseOctal((OCTAL_NUMBER271!=null?OCTAL_NUMBER271.getText():null)); 
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1454:3: CHARACTER
                    {
                    root_0 = (Object)adaptor.nil();

                    CHARACTER272=(Token)match(input,CHARACTER,FOLLOW_CHARACTER_in_constant4875); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARACTER272_tree = (Object)adaptor.create(CHARACTER272);
                    adaptor.addChild(root_0, CHARACTER272_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant =  Constant.parseCharOrStringInteger((CHARACTER272!=null?CHARACTER272.getText():null)); 
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1455:3: FLOAT_NUMBER
                    {
                    root_0 = (Object)adaptor.nil();

                    FLOAT_NUMBER273=(Token)match(input,FLOAT_NUMBER,FOLLOW_FLOAT_NUMBER_in_constant4883); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT_NUMBER273_tree = (Object)adaptor.create(FLOAT_NUMBER273);
                    adaptor.addChild(root_0, FLOAT_NUMBER273_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant = Constant.parseFloat((FLOAT_NUMBER273!=null?FLOAT_NUMBER273.getText():null)); 
                    }

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1457:3: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING274=(Token)match(input,STRING,FOLLOW_STRING_in_constant4894); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING274_tree = (Object)adaptor.create(STRING274);
                    adaptor.addChild(root_0, STRING274_tree);
                    }
                    if ( state.backtracking==0 ) {
                       retval.constant =  Constant.parseString((STRING274!=null?STRING274.getText():null)); 
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
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:320:5: ( functionDeclaration )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:320:5: functionDeclaration
        {
        pushFollow(FOLLOW_functionDeclaration_in_synpred6_ObjCpp276);
        functionDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_ObjCpp

    // $ANTLR start synpred8_ObjCpp
    public final void synpred8_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:326:5: ( varDecl ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:326:5: varDecl ';'
        {
        pushFollow(FOLLOW_varDecl_in_synpred8_ObjCpp296);
        varDecl();

        state._fsp--;
        if (state.failed) return ;
        match(input,25,FOLLOW_25_in_synpred8_ObjCpp298); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_ObjCpp

    // $ANTLR start synpred19_ObjCpp
    public final void synpred19_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifiers_return m2 = null;

        ObjCppParser.enumBody_return nb = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:435:6: (m2= modifiers nb= enumBody )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:435:6: m2= modifiers nb= enumBody
        {
        pushFollow(FOLLOW_modifiers_in_synpred19_ObjCpp667);
        m2=modifiers();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_enumBody_in_synpred19_ObjCpp678);
        nb=enumBody();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_ObjCpp

    // $ANTLR start synpred30_ObjCpp
    public final void synpred30_ObjCpp_fragment() throws RecognitionException {   
        Token bits=null;
        ObjCppParser.varDecl_return fv = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:503:7: (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:503:7: fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';'
        {
        pushFollow(FOLLOW_varDecl_in_synpred30_ObjCpp927);
        fv=varDecl();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:503:18: ( ':' bits= DECIMAL_NUMBER )?
        int alt119=2;
        int LA119_0 = input.LA(1);

        if ( (LA119_0==33) ) {
            alt119=1;
        }
        switch (alt119) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:503:20: ':' bits= DECIMAL_NUMBER
                {
                match(input,33,FOLLOW_33_in_synpred30_ObjCpp931); if (state.failed) return ;
                bits=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_synpred30_ObjCpp935); if (state.failed) return ;

                }
                break;

        }

        match(input,25,FOLLOW_25_in_synpred30_ObjCpp940); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_ObjCpp

    // $ANTLR start synpred51_ObjCpp
    public final void synpred51_ObjCpp_fragment() throws RecognitionException {   
        Token parent=null;
        ObjCppParser.modifiers_return m2 = null;

        ObjCppParser.structBody_return nb = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:619:6: ( (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:619:6: (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:619:6: (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:620:7: m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody
        {
        pushFollow(FOLLOW_modifiers_in_synpred51_ObjCpp1427);
        m2=modifiers();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:621:7: ( ':' ( 'public' )? parent= IDENTIFIER )?
        int alt130=2;
        int LA130_0 = input.LA(1);

        if ( (LA130_0==33) ) {
            alt130=1;
        }
        switch (alt130) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:622:8: ':' ( 'public' )? parent= IDENTIFIER
                {
                match(input,33,FOLLOW_33_in_synpred51_ObjCpp1446); if (state.failed) return ;
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:623:8: ( 'public' )?
                int alt129=2;
                int LA129_0 = input.LA(1);

                if ( (LA129_0==45) ) {
                    alt129=1;
                }
                switch (alt129) {
                    case 1 :
                        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: 'public'
                        {
                        match(input,45,FOLLOW_45_in_synpred51_ObjCpp1455); if (state.failed) return ;

                        }
                        break;

                }

                parent=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred51_ObjCpp1467); if (state.failed) return ;

                }
                break;

        }

        pushFollow(FOLLOW_structBody_in_synpred51_ObjCpp1487);
        nb=structBody();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred51_ObjCpp

    // $ANTLR start synpred53_ObjCpp
    public final void synpred53_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:665:31: ( binaryOp )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:665:31: binaryOp
        {
        pushFollow(FOLLOW_binaryOp_in_synpred53_ObjCpp1550);
        binaryOp();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_ObjCpp

    // $ANTLR start synpred54_ObjCpp
    public final void synpred54_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:665:42: ( unaryOp )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:665:42: unaryOp
        {
        pushFollow(FOLLOW_unaryOp_in_synpred54_ObjCpp1554);
        unaryOp();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_ObjCpp

    // $ANTLR start synpred57_ObjCpp
    public final void synpred57_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.mutableTypeRef_return returnTypeRef = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:698:16: (returnTypeRef= mutableTypeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:698:16: returnTypeRef= mutableTypeRef
        {
        pushFollow(FOLLOW_mutableTypeRef_in_synpred57_ObjCpp1612);
        returnTypeRef=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred57_ObjCpp

    // $ANTLR start synpred58_ObjCpp
    public final void synpred58_ObjCpp_fragment() throws RecognitionException {   
        Token ct=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:710:4: ({...}?ct= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:710:4: {...}?ct= IDENTIFIER
        {
        if ( !(( next("const", "__const") )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred58_ObjCpp", " next(\"const\", \"__const\") ");
        }
        ct=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred58_ObjCpp1644); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_ObjCpp

    // $ANTLR start synpred60_ObjCpp
    public final void synpred60_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:739:5: ( anyModifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:739:5: anyModifier
        {
        pushFollow(FOLLOW_anyModifier_in_synpred60_ObjCpp1719);
        anyModifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred60_ObjCpp

    // $ANTLR start synpred62_ObjCpp
    public final void synpred62_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:754:4: ( modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:754:4: modifier
        {
        pushFollow(FOLLOW_modifier_in_synpred62_ObjCpp1768);
        modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred62_ObjCpp

    // $ANTLR start synpred64_ObjCpp
    public final void synpred64_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:761:4: ({...}? IDENTIFIER '(' expression ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:761:4: {...}? IDENTIFIER '(' expression ')'
        {
        if ( !(( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred64_ObjCpp", " next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ");
        }
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred64_ObjCpp1816); if (state.failed) return ;
        match(input,34,FOLLOW_34_in_synpred64_ObjCpp1818); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred64_ObjCpp1820);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred64_ObjCpp1822); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred64_ObjCpp

    // $ANTLR start synpred66_ObjCpp
    public final void synpred66_ObjCpp_fragment() throws RecognitionException {   
        Token an=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:5: ( (an= STRING )* )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:5: (an= STRING )*
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:5: (an= STRING )*
        loop132:
        do {
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( (LA132_0==STRING) ) {
                alt132=1;
            }


            switch (alt132) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:7: an= STRING
        	    {
        	    an=(Token)match(input,STRING,FOLLOW_STRING_in_synpred66_ObjCpp1855); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop132;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred66_ObjCpp

    // $ANTLR start synpred68_ObjCpp
    public final void synpred68_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return sm = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:808:4: ({...}?sm= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:808:4: {...}?sm= modifier
        {
        if ( !(( next(Modifier.Kind.StorageClassSpecifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred68_ObjCpp", " next(Modifier.Kind.StorageClassSpecifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred68_ObjCpp1969);
        sm=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred68_ObjCpp

    // $ANTLR start synpred69_ObjCpp
    public final void synpred69_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.modifier_return tm = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:810:4: ({...}?tm= modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:810:4: {...}?tm= modifier
        {
        if ( !(( next(Modifier.Kind.TypeQualifier) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred69_ObjCpp", " next(Modifier.Kind.TypeQualifier) ");
        }
        pushFollow(FOLLOW_modifier_in_synpred69_ObjCpp1986);
        tm=modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred69_ObjCpp

    // $ANTLR start synpred84_ObjCpp
    public final void synpred84_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:917:4: ( ( typeMutator ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:917:4: ( typeMutator )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:917:4: ( typeMutator )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:918:5: typeMutator
        {
        pushFollow(FOLLOW_typeMutator_in_synpred84_ObjCpp2384);
        typeMutator();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred84_ObjCpp

    // $ANTLR start synpred85_ObjCpp
    public final void synpred85_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:922:4: ( ( functionSignatureSuffix ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:922:4: ( functionSignatureSuffix )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:922:4: ( functionSignatureSuffix )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:923:5: functionSignatureSuffix
        {
        pushFollow(FOLLOW_functionSignatureSuffix_in_synpred85_ObjCpp2404);
        functionSignatureSuffix();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred85_ObjCpp

    // $ANTLR start synpred87_ObjCpp
    public final void synpred87_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:938:4: ( ( typeMutator )* ( functionSignatureSuffix ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:938:4: ( typeMutator )* ( functionSignatureSuffix )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:938:4: ( typeMutator )*
        loop141:
        do {
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( ((LA141_0>=53 && LA141_0<=55)) ) {
                alt141=1;
            }


            switch (alt141) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:939:5: typeMutator
        	    {
        	    pushFollow(FOLLOW_typeMutator_in_synpred87_ObjCpp2453);
        	    typeMutator();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop141;
            }
        } while (true);

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:943:4: ( functionSignatureSuffix )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:944:5: functionSignatureSuffix
        {
        pushFollow(FOLLOW_functionSignatureSuffix_in_synpred87_ObjCpp2472);
        functionSignatureSuffix();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred87_ObjCpp

    // $ANTLR start synpred91_ObjCpp
    public final void synpred91_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.topLevelExpr_return dv = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:969:4: ( '=' dv= topLevelExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:969:4: '=' dv= topLevelExpr
        {
        match(input,29,FOLLOW_29_in_synpred91_ObjCpp2583); if (state.failed) return ;
        pushFollow(FOLLOW_topLevelExpr_in_synpred91_ObjCpp2591);
        dv=topLevelExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred91_ObjCpp

    // $ANTLR start synpred99_ObjCpp
    public final void synpred99_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.argDef_return ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1076:5: ( ',' ax= argDef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1076:5: ',' ax= argDef
        {
        match(input,28,FOLLOW_28_in_synpred99_ObjCpp2950); if (state.failed) return ;
        pushFollow(FOLLOW_argDef_in_synpred99_ObjCpp2959);
        ax=argDef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred99_ObjCpp

    // $ANTLR start synpred102_ObjCpp
    public final void synpred102_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.anyModifier_return mods = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1118:4: (mods= anyModifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1118:4: mods= anyModifier
        {
        pushFollow(FOLLOW_anyModifier_in_synpred102_ObjCpp3032);
        mods=anyModifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred102_ObjCpp

    // $ANTLR start synpred107_ObjCpp
    public final void synpred107_ObjCpp_fragment() throws RecognitionException {   
        Token i=null;
        ObjCppParser.mutableTypeRef_return t1 = null;

        ObjCppParser.mutableTypeRef_return tx = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1119:4: ( ( ( ( 'typename' | {...}?) i= IDENTIFIER ) ( '<' (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )? '>' )? ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1119:4: ( ( ( 'typename' | {...}?) i= IDENTIFIER ) ( '<' (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )? '>' )? )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1119:4: ( ( ( 'typename' | {...}?) i= IDENTIFIER ) ( '<' (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )? '>' )? )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1120:5: ( ( 'typename' | {...}?) i= IDENTIFIER ) ( '<' (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )? '>' )?
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1120:5: ( ( 'typename' | {...}?) i= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1121:6: ( 'typename' | {...}?) i= IDENTIFIER
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1121:6: ( 'typename' | {...}?)
        int alt148=2;
        int LA148_0 = input.LA(1);

        if ( (LA148_0==60) ) {
            alt148=1;
        }
        else if ( (LA148_0==IDENTIFIER) ) {
            alt148=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 148, 0, input);

            throw nvae;
        }
        switch (alt148) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1121:7: 'typename'
                {
                match(input,60,FOLLOW_60_in_synpred107_ObjCpp3055); if (state.failed) return ;

                }
                break;
            case 2 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1121:20: {...}?
                {
                if ( !(( isTypeIdentifier(next()) )) ) {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    throw new FailedPredicateException(input, "synpred107_ObjCpp", " isTypeIdentifier(next()) ");
                }

                }
                break;

        }

        i=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred107_ObjCpp3065); if (state.failed) return ;

        }

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1129:5: ( '<' (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )? '>' )?
        int alt151=2;
        int LA151_0 = input.LA(1);

        if ( (LA151_0==36) ) {
            alt151=1;
        }
        switch (alt151) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1130:6: '<' (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )? '>'
                {
                match(input,36,FOLLOW_36_in_synpred107_ObjCpp3089); if (state.failed) return ;
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1131:7: (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )?
                int alt150=2;
                int LA150_0 = input.LA(1);

                if ( (LA150_0==IDENTIFIER||LA150_0==30||(LA150_0>=48 && LA150_0<=50)||LA150_0==60) ) {
                    alt150=1;
                }
                switch (alt150) {
                    case 1 :
                        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1132:8: t1= mutableTypeRef ( ',' tx= mutableTypeRef )*
                        {
                        pushFollow(FOLLOW_mutableTypeRef_in_synpred107_ObjCpp3110);
                        t1=mutableTypeRef();

                        state._fsp--;
                        if (state.failed) return ;
                        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1133:8: ( ',' tx= mutableTypeRef )*
                        loop149:
                        do {
                            int alt149=2;
                            int LA149_0 = input.LA(1);

                            if ( (LA149_0==28) ) {
                                alt149=1;
                            }


                            switch (alt149) {
                        	case 1 :
                        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1134:9: ',' tx= mutableTypeRef
                        	    {
                        	    match(input,28,FOLLOW_28_in_synpred107_ObjCpp3131); if (state.failed) return ;
                        	    pushFollow(FOLLOW_mutableTypeRef_in_synpred107_ObjCpp3144);
                        	    tx=mutableTypeRef();

                        	    state._fsp--;
                        	    if (state.failed) return ;

                        	    }
                        	    break;

                        	default :
                        	    break loop149;
                            }
                        } while (true);


                        }
                        break;

                }

                match(input,37,FOLLOW_37_in_synpred107_ObjCpp3172); if (state.failed) return ;

                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred107_ObjCpp

    // $ANTLR start synpred139_ObjCpp
    public final void synpred139_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.assignmentOp_return op = null;

        ObjCppParser.assignmentExpr_return f = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1243:4: (op= assignmentOp f= assignmentExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1243:4: op= assignmentOp f= assignmentExpr
        {
        pushFollow(FOLLOW_assignmentOp_in_synpred139_ObjCpp3642);
        op=assignmentOp();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_assignmentExpr_in_synpred139_ObjCpp3646);
        f=assignmentExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred139_ObjCpp

    // $ANTLR start synpred169_ObjCpp
    public final void synpred169_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.mutableTypeRef_return tr = null;

        ObjCppParser.castExpr_return inner = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1345:4: ( '(' tr= mutableTypeRef ')' inner= castExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1345:4: '(' tr= mutableTypeRef ')' inner= castExpr
        {
        match(input,34,FOLLOW_34_in_synpred169_ObjCpp4268); if (state.failed) return ;
        pushFollow(FOLLOW_mutableTypeRef_in_synpred169_ObjCpp4272);
        tr=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred169_ObjCpp4274); if (state.failed) return ;
        pushFollow(FOLLOW_castExpr_in_synpred169_ObjCpp4278);
        inner=castExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred169_ObjCpp

    // $ANTLR start synpred172_ObjCpp
    public final void synpred172_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.mutableTypeRef_return tr = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1354:4: ( '(' tr= mutableTypeRef ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1354:4: '(' tr= mutableTypeRef ')'
        {
        match(input,34,FOLLOW_34_in_synpred172_ObjCpp4336); if (state.failed) return ;
        pushFollow(FOLLOW_mutableTypeRef_in_synpred172_ObjCpp4340);
        tr=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred172_ObjCpp4342); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred172_ObjCpp

    // $ANTLR start synpred186_ObjCpp
    public final void synpred186_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.topLevelExpr_return f = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1398:4: ( ',' f= topLevelExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1398:4: ',' f= topLevelExpr
        {
        match(input,28,FOLLOW_28_in_synpred186_ObjCpp4540); if (state.failed) return ;
        pushFollow(FOLLOW_topLevelExpr_in_synpred186_ObjCpp4547);
        f=topLevelExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred186_ObjCpp

    // $ANTLR start synpred189_ObjCpp
    public final void synpred189_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1432:3: ( declaration )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1432:3: declaration
        {
        pushFollow(FOLLOW_declaration_in_synpred189_ObjCpp4656);
        declaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred189_ObjCpp

    // $ANTLR start synpred190_ObjCpp
    public final void synpred190_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.expression_return es = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1433:3: (es= expression ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1433:3: es= expression ';'
        {
        pushFollow(FOLLOW_expression_in_synpred190_ObjCpp4665);
        es=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,25,FOLLOW_25_in_synpred190_ObjCpp4667); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred190_ObjCpp

    // $ANTLR start synpred192_ObjCpp
    public final void synpred192_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1437:38: ( 'else' statement )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1437:38: 'else' statement
        {
        match(input,93,FOLLOW_93_in_synpred192_ObjCpp4702); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred192_ObjCpp4704);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred192_ObjCpp

    // $ANTLR start synpred196_ObjCpp
    public final void synpred196_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1440:13: ( statement )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1440:13: statement
        {
        pushFollow(FOLLOW_statement_in_synpred196_ObjCpp4751);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred196_ObjCpp

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
    public final boolean synpred58_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred107_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred107_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred139_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred139_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred189_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred189_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred196_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred196_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred192_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred192_ObjCpp_fragment(); // can never throw exception
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


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA2 dfa2 = new DFA2(this);
    protected DFA3 dfa3 = new DFA3(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA45 dfa45 = new DFA45(this);
    protected DFA44 dfa44 = new DFA44(this);
    protected DFA47 dfa47 = new DFA47(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA63 dfa63 = new DFA63(this);
    protected DFA65 dfa65 = new DFA65(this);
    protected DFA70 dfa70 = new DFA70(this);
    protected DFA72 dfa72 = new DFA72(this);
    protected DFA79 dfa79 = new DFA79(this);
    protected DFA78 dfa78 = new DFA78(this);
    protected DFA83 dfa83 = new DFA83(this);
    protected DFA84 dfa84 = new DFA84(this);
    protected DFA86 dfa86 = new DFA86(this);
    protected DFA87 dfa87 = new DFA87(this);
    protected DFA88 dfa88 = new DFA88(this);
    protected DFA89 dfa89 = new DFA89(this);
    protected DFA90 dfa90 = new DFA90(this);
    protected DFA91 dfa91 = new DFA91(this);
    protected DFA92 dfa92 = new DFA92(this);
    protected DFA93 dfa93 = new DFA93(this);
    protected DFA94 dfa94 = new DFA94(this);
    protected DFA95 dfa95 = new DFA95(this);
    protected DFA96 dfa96 = new DFA96(this);
    protected DFA97 dfa97 = new DFA97(this);
    protected DFA98 dfa98 = new DFA98(this);
    protected DFA100 dfa100 = new DFA100(this);
    protected DFA99 dfa99 = new DFA99(this);
    protected DFA102 dfa102 = new DFA102(this);
    protected DFA101 dfa101 = new DFA101(this);
    protected DFA103 dfa103 = new DFA103(this);
    protected DFA104 dfa104 = new DFA104(this);
    protected DFA110 dfa110 = new DFA110(this);
    protected DFA105 dfa105 = new DFA105(this);
    protected DFA106 dfa106 = new DFA106(this);
    protected DFA107 dfa107 = new DFA107(this);
    protected DFA108 dfa108 = new DFA108(this);
    protected DFA109 dfa109 = new DFA109(this);
    static final String DFA1_eotS =
        "\16\uffff";
    static final String DFA1_eofS =
        "\1\2\15\uffff";
    static final String DFA1_minS =
        "\1\4\15\uffff";
    static final String DFA1_maxS =
        "\1\74\15\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\1\1\2\13\uffff";
    static final String DFA1_specialS =
        "\16\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\2\1\1\1\2\17\uffff\1\2\3\uffff\2\2\2\uffff\3\2\17\uffff\4"+
            "\2\7\uffff\2\2",
            "",
            "",
            "",
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
            return "260:3: (unescapedString= STRING )?";
        }
    }
    static final String DFA2_eotS =
        "\15\uffff";
    static final String DFA2_eofS =
        "\1\2\14\uffff";
    static final String DFA2_minS =
        "\1\4\14\uffff";
    static final String DFA2_maxS =
        "\1\74\14\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\1\2\12\uffff";
    static final String DFA2_specialS =
        "\15\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\1\1\uffff\1\2\17\uffff\1\2\3\uffff\2\2\2\uffff\3\2\17\uffff"+
            "\4\2\7\uffff\2\2",
            "",
            "",
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
            return "271:8: (depth= DECIMAL_NUMBER )?";
        }
    }
    static final String DFA3_eotS =
        "\14\uffff";
    static final String DFA3_eofS =
        "\1\1\13\uffff";
    static final String DFA3_minS =
        "\1\6\13\uffff";
    static final String DFA3_maxS =
        "\1\74\13\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\3\1\1\10\uffff\1\2";
    static final String DFA3_specialS =
        "\14\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\2\17\uffff\1\13\3\uffff\2\2\2\uffff\3\2\17\uffff\4\2\7\uffff"+
            "\2\2",
            "",
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
            return "()* loopback of 281:3: ( declaration | lineDirective )*";
        }
    }
    static final String DFA4_eotS =
        "\13\uffff";
    static final String DFA4_eofS =
        "\13\uffff";
    static final String DFA4_minS =
        "\1\6\12\uffff";
    static final String DFA4_maxS =
        "\1\74\12\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\2\1\1\10\uffff";
    static final String DFA4_specialS =
        "\13\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\2\21\uffff\1\1\1\uffff\2\2\2\uffff\3\2\17\uffff\4\2\7\uffff"+
            "\2\2",
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
            return "()* loopback of 301:4: (ed= declaration )*";
        }
    }
    static final String DFA6_eotS =
        "\u009b\uffff";
    static final String DFA6_eofS =
        "\u009b\uffff";
    static final String DFA6_minS =
        "\1\6\1\5\3\6\5\uffff\1\6\1\4\1\6\1\70\1\5\1\uffff\5\6\5\uffff\1"+
        "\6\1\5\1\6\1\5\1\6\1\uffff\7\0\3\uffff\22\0\5\uffff\2\0\1\uffff"+
        "\2\0\1\uffff\7\0\1\uffff\4\0\2\uffff\1\0\4\uffff\12\0\1\uffff\1"+
        "\0\2\uffff\5\0\2\uffff\3\0\1\uffff\7\0\1\uffff\3\0\2\uffff\23\0"+
        "\2\uffff\3\0\1\uffff\2\0";
    static final String DFA6_maxS =
        "\1\74\1\131\1\6\2\27\5\uffff\1\74\1\131\1\72\1\70\1\131\1\uffff"+
        "\1\6\2\27\1\74\1\72\5\uffff\4\74\1\30\1\uffff\7\0\3\uffff\22\0\5"+
        "\uffff\2\0\1\uffff\2\0\1\uffff\7\0\1\uffff\4\0\2\uffff\1\0\4\uffff"+
        "\12\0\1\uffff\1\0\2\uffff\5\0\2\uffff\3\0\1\uffff\7\0\1\uffff\3"+
        "\0\2\uffff\23\0\2\uffff\3\0\1\uffff\2\0";
    static final String DFA6_acceptS =
        "\5\uffff\1\1\1\4\1\5\1\6\1\7\13\uffff\1\3\23\uffff\1\2\161\uffff";
    static final String DFA6_specialS =
        "\40\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\3\uffff\1\7\1\10\1\11\1\12"+
        "\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
        "\1\30\5\uffff\1\31\1\32\1\uffff\1\33\1\34\1\uffff\1\35\1\36\1\37"+
        "\1\40\1\41\1\42\1\43\1\uffff\1\44\1\45\1\46\1\47\2\uffff\1\50\4"+
        "\uffff\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\uffff"+
        "\1\63\2\uffff\1\64\1\65\1\66\1\67\1\70\2\uffff\1\71\1\72\1\73\1"+
        "\uffff\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\uffff\1\103\1\104"+
        "\1\105\2\uffff\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1"+
        "\116\1\117\1\120\1\121\1\122\1\123\1\124\1\125\1\126\1\127\1\130"+
        "\2\uffff\1\131\1\132\1\133\1\uffff\1\134\1\135}>";
    static final String[] DFA6_transitionS = {
            "\1\1\23\uffff\1\11\1\10\2\uffff\1\4\2\6\17\uffff\3\3\1\5\7\uffff"+
            "\1\7\1\2",
            "\1\12\1\16\22\uffff\1\25\3\uffff\1\5\1\22\3\uffff\1\13\1\uffff"+
            "\1\23\1\5\4\uffff\2\5\4\uffff\3\21\1\5\1\uffff\2\14\1\15\2\uffff"+
            "\1\24\1\uffff\1\20\14\5\2\uffff\12\5\2\uffff\3\5",
            "\1\32",
            "\1\33\20\uffff\1\34",
            "\1\35\20\uffff\1\36",
            "",
            "",
            "",
            "",
            "",
            "\1\40\20\uffff\1\51\1\uffff\1\25\4\uffff\1\43\3\uffff\1\46"+
            "\15\uffff\3\42\1\5\1\uffff\2\44\1\45\2\uffff\1\25\1\uffff\1"+
            "\41",
            "\1\60\1\55\1\53\1\61\1\62\1\63\1\64\23\uffff\1\5\1\67\2\uffff"+
            "\1\57\1\56\7\uffff\1\73\1\5\3\uffff\3\5\1\73\1\52\1\54\1\71"+
            "\1\65\2\uffff\1\25\1\uffff\1\5\14\uffff\1\66\1\70\13\uffff\1"+
            "\72\3\73",
            "\1\102\33\uffff\1\101\20\uffff\1\5\1\uffff\2\104\1\105\2\uffff"+
            "\1\25",
            "\1\107",
            "\1\110\1\114\22\uffff\1\25\2\uffff\1\25\1\122\1\121\3\uffff"+
            "\1\111\1\uffff\1\125\1\5\4\uffff\2\5\4\uffff\3\120\1\5\1\uffff"+
            "\2\112\1\113\2\uffff\1\115\1\uffff\1\117\14\5\2\uffff\12\5\2"+
            "\uffff\3\5",
            "",
            "\1\132",
            "\1\133\20\uffff\1\134",
            "\1\135\20\uffff\1\136",
            "\1\137\27\uffff\1\142\3\uffff\1\5\2\uffff\1\143\12\uffff\3"+
            "\141\11\uffff\1\140",
            "\1\25\33\uffff\1\145\22\uffff\2\25\3\uffff\1\25",
            "",
            "",
            "",
            "",
            "",
            "\1\154\22\uffff\1\25\4\uffff\1\161\3\uffff\1\153\1\uffff\1"+
            "\150\13\uffff\3\160\1\5\1\uffff\2\151\1\152\2\uffff\1\25\1\uffff"+
            "\1\157",
            "\1\163\1\165\20\uffff\1\167\1\uffff\1\25\4\uffff\1\175\2\uffff"+
            "\1\166\1\164\15\uffff\3\174\1\5\1\uffff\2\170\1\171\2\uffff"+
            "\1\25\1\uffff\1\173",
            "\1\u0083\21\uffff\1\u008c\1\uffff\1\u008b\1\u008a\2\uffff\1"+
            "\u0086\2\u0088\14\uffff\1\u0080\1\u0081\1\u0082\3\u0085\1\u0087"+
            "\7\uffff\1\u0089\1\u0084",
            "\1\u008d\1\u0090\20\uffff\1\u008f\1\uffff\1\25\4\uffff\1\u0097"+
            "\3\uffff\1\u008e\15\uffff\3\u0096\1\5\1\uffff\2\u0091\1\u0092"+
            "\2\uffff\1\25\1\uffff\1\u0095",
            "\1\u0099\21\uffff\1\u009a",
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
            "\1\uffff",
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
            "\1\uffff",
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
            "\1\uffff"
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
            return "318:4: ( functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA6_32 = input.LA(1);

                         
                        int index6_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_32);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_33 = input.LA(1);

                         
                        int index6_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_33);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA6_34 = input.LA(1);

                         
                        int index6_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_34);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA6_35 = input.LA(1);

                         
                        int index6_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_35);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA6_36 = input.LA(1);

                         
                        int index6_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_36);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA6_37 = input.LA(1);

                         
                        int index6_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_37);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA6_38 = input.LA(1);

                         
                        int index6_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_38);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA6_42 = input.LA(1);

                         
                        int index6_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_42);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA6_43 = input.LA(1);

                         
                        int index6_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_43);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA6_44 = input.LA(1);

                         
                        int index6_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_44);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA6_45 = input.LA(1);

                         
                        int index6_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_45);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA6_46 = input.LA(1);

                         
                        int index6_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_46);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA6_47 = input.LA(1);

                         
                        int index6_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_47);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA6_48 = input.LA(1);

                         
                        int index6_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_48);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA6_49 = input.LA(1);

                         
                        int index6_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_49);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA6_50 = input.LA(1);

                         
                        int index6_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_50);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA6_51 = input.LA(1);

                         
                        int index6_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_51);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA6_52 = input.LA(1);

                         
                        int index6_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_52);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA6_53 = input.LA(1);

                         
                        int index6_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_53);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA6_54 = input.LA(1);

                         
                        int index6_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_54);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA6_55 = input.LA(1);

                         
                        int index6_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_55);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA6_56 = input.LA(1);

                         
                        int index6_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_56);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA6_57 = input.LA(1);

                         
                        int index6_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_57);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA6_58 = input.LA(1);

                         
                        int index6_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_58);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA6_59 = input.LA(1);

                         
                        int index6_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_59);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA6_65 = input.LA(1);

                         
                        int index6_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_65);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA6_66 = input.LA(1);

                         
                        int index6_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_66);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA6_68 = input.LA(1);

                         
                        int index6_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_68);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA6_69 = input.LA(1);

                         
                        int index6_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_69);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA6_71 = input.LA(1);

                         
                        int index6_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_71);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA6_72 = input.LA(1);

                         
                        int index6_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_72);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA6_73 = input.LA(1);

                         
                        int index6_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_73);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA6_74 = input.LA(1);

                         
                        int index6_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_74);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA6_75 = input.LA(1);

                         
                        int index6_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_75);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA6_76 = input.LA(1);

                         
                        int index6_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_76);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA6_77 = input.LA(1);

                         
                        int index6_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_77);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA6_79 = input.LA(1);

                         
                        int index6_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_79);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA6_80 = input.LA(1);

                         
                        int index6_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_80);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA6_81 = input.LA(1);

                         
                        int index6_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_81);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA6_82 = input.LA(1);

                         
                        int index6_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_82);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA6_85 = input.LA(1);

                         
                        int index6_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_85);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA6_90 = input.LA(1);

                         
                        int index6_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_90);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA6_91 = input.LA(1);

                         
                        int index6_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_91);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA6_92 = input.LA(1);

                         
                        int index6_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_92);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA6_93 = input.LA(1);

                         
                        int index6_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_93);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA6_94 = input.LA(1);

                         
                        int index6_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_94);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA6_95 = input.LA(1);

                         
                        int index6_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( ((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))) ) {s = 21;}

                         
                        input.seek(index6_95);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA6_96 = input.LA(1);

                         
                        int index6_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( ((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))) ) {s = 21;}

                         
                        input.seek(index6_96);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA6_97 = input.LA(1);

                         
                        int index6_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( ((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))) ) {s = 21;}

                         
                        input.seek(index6_97);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA6_98 = input.LA(1);

                         
                        int index6_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( ((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))) ) {s = 21;}

                         
                        input.seek(index6_98);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA6_99 = input.LA(1);

                         
                        int index6_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( ((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))) ) {s = 21;}

                         
                        input.seek(index6_99);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA6_101 = input.LA(1);

                         
                        int index6_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (((synpred8_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred8_ObjCpp())) ) {s = 21;}

                         
                        input.seek(index6_101);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA6_104 = input.LA(1);

                         
                        int index6_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_104);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA6_105 = input.LA(1);

                         
                        int index6_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_105);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA6_106 = input.LA(1);

                         
                        int index6_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_106);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA6_107 = input.LA(1);

                         
                        int index6_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_107);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA6_108 = input.LA(1);

                         
                        int index6_108 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_108);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA6_111 = input.LA(1);

                         
                        int index6_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_111);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA6_112 = input.LA(1);

                         
                        int index6_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_112);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA6_113 = input.LA(1);

                         
                        int index6_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_113);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA6_115 = input.LA(1);

                         
                        int index6_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_115);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA6_116 = input.LA(1);

                         
                        int index6_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_116);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA6_117 = input.LA(1);

                         
                        int index6_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_117);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA6_118 = input.LA(1);

                         
                        int index6_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_118);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA6_119 = input.LA(1);

                         
                        int index6_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_119);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA6_120 = input.LA(1);

                         
                        int index6_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_120);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA6_121 = input.LA(1);

                         
                        int index6_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_121);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA6_123 = input.LA(1);

                         
                        int index6_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_123);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA6_124 = input.LA(1);

                         
                        int index6_124 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_124);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA6_125 = input.LA(1);

                         
                        int index6_125 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_125);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA6_128 = input.LA(1);

                         
                        int index6_128 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_128);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA6_129 = input.LA(1);

                         
                        int index6_129 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_129);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA6_130 = input.LA(1);

                         
                        int index6_130 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_130);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA6_131 = input.LA(1);

                         
                        int index6_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_131);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA6_132 = input.LA(1);

                         
                        int index6_132 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_132);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA6_133 = input.LA(1);

                         
                        int index6_133 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_133);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA6_134 = input.LA(1);

                         
                        int index6_134 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_134);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA6_135 = input.LA(1);

                         
                        int index6_135 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_135);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA6_136 = input.LA(1);

                         
                        int index6_136 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_136);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA6_137 = input.LA(1);

                         
                        int index6_137 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_137);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA6_138 = input.LA(1);

                         
                        int index6_138 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_138);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA6_139 = input.LA(1);

                         
                        int index6_139 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_139);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA6_140 = input.LA(1);

                         
                        int index6_140 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_140);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA6_141 = input.LA(1);

                         
                        int index6_141 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_141);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA6_142 = input.LA(1);

                         
                        int index6_142 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_142);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA6_143 = input.LA(1);

                         
                        int index6_143 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_143);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA6_144 = input.LA(1);

                         
                        int index6_144 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_144);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA6_145 = input.LA(1);

                         
                        int index6_145 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_145);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA6_146 = input.LA(1);

                         
                        int index6_146 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_146);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA6_149 = input.LA(1);

                         
                        int index6_149 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_149);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA6_150 = input.LA(1);

                         
                        int index6_150 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_150);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA6_151 = input.LA(1);

                         
                        int index6_151 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_151);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA6_153 = input.LA(1);

                         
                        int index6_153 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_153);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA6_154 = input.LA(1);

                         
                        int index6_154 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_ObjCpp()) ) {s = 5;}

                        else if ( (synpred8_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index6_154);
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
        "\13\uffff";
    static final String DFA5_eofS =
        "\13\uffff";
    static final String DFA5_minS =
        "\1\6\12\uffff";
    static final String DFA5_maxS =
        "\1\74\12\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\2\1\1\10\uffff";
    static final String DFA5_specialS =
        "\13\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\2\21\uffff\1\1\1\uffff\2\2\2\uffff\3\2\17\uffff\4\2\7\uffff"+
            "\2\2",
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
            return "()* loopback of 339:6: (subD= declaration )*";
        }
    }
    static final String DFA12_eotS =
        "\121\uffff";
    static final String DFA12_eofS =
        "\2\3\20\uffff\1\3\76\uffff";
    static final String DFA12_minS =
        "\1\6\1\5\20\uffff\1\6\1\4\46\uffff\4\0\4\uffff\14\0\1\uffff\2\0";
    static final String DFA12_maxS =
        "\1\74\1\131\20\uffff\1\74\1\131\46\uffff\4\0\4\uffff\14\0\1\uffff"+
        "\2\0";
    static final String DFA12_acceptS =
        "\2\uffff\1\1\1\2\115\uffff";
    static final String DFA12_specialS =
        "\72\uffff\1\0\1\1\1\2\1\3\4\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
        "\1\13\1\14\1\15\1\16\1\17\1\uffff\1\20\1\21}>";
    static final String[] DFA12_transitionS = {
            "\1\1\20\uffff\1\2\1\uffff\1\3\2\uffff\3\3\2\uffff\3\3\1\uffff"+
            "\1\3\12\uffff\4\3\1\uffff\3\3\2\uffff\1\3\1\uffff\1\3",
            "\1\22\1\3\20\uffff\1\2\1\uffff\1\3\2\uffff\3\3\2\uffff\1\3"+
            "\1\23\3\3\4\uffff\2\3\4\uffff\4\3\1\uffff\3\3\2\uffff\1\3\1"+
            "\uffff\15\3\2\uffff\12\3\2\uffff\3\3",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\3\20\uffff\1\2\1\uffff\1\3\2\uffff\3\3\2\uffff\3\3\1\uffff"+
            "\1\3\12\uffff\4\3\1\uffff\3\3\2\uffff\1\3\1\uffff\1\3",
            "\1\105\1\104\1\73\1\106\1\107\1\110\1\111\23\uffff\1\3\1\114"+
            "\2\uffff\1\74\1\102\7\uffff\1\117\1\3\3\uffff\3\3\1\117\1\72"+
            "\1\75\1\103\1\112\2\uffff\1\3\1\uffff\1\3\14\uffff\1\113\1\115"+
            "\13\uffff\1\120\3\117",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            "\1\uffff"
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
            return "434:5: (m2= modifiers nb= enumBody | )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_58 = input.LA(1);

                         
                        int index12_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index12_58);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_59 = input.LA(1);

                         
                        int index12_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index12_59);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_60 = input.LA(1);

                         
                        int index12_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index12_60);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA12_61 = input.LA(1);

                         
                        int index12_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index12_61);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA12_66 = input.LA(1);

                         
                        int index12_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index12_66);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA12_67 = input.LA(1);

                         
                        int index12_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index12_67);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA12_68 = input.LA(1);

                         
                        int index12_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index12_68);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA12_69 = input.LA(1);

                         
                        int index12_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index12_69);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA12_70 = input.LA(1);

                         
                        int index12_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index12_70);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA12_71 = input.LA(1);

                         
                        int index12_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index12_71);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA12_72 = input.LA(1);

                         
                        int index12_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index12_72);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA12_73 = input.LA(1);

                         
                        int index12_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index12_73);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA12_74 = input.LA(1);

                         
                        int index12_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index12_74);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA12_75 = input.LA(1);

                         
                        int index12_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index12_75);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA12_76 = input.LA(1);

                         
                        int index12_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index12_76);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA12_77 = input.LA(1);

                         
                        int index12_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index12_77);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA12_79 = input.LA(1);

                         
                        int index12_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index12_79);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA12_80 = input.LA(1);

                         
                        int index12_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index12_80);
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
    static final String DFA15_eotS =
        "\15\uffff";
    static final String DFA15_eofS =
        "\15\uffff";
    static final String DFA15_minS =
        "\1\6\14\uffff";
    static final String DFA15_maxS =
        "\1\74\14\uffff";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\12\uffff\1\2";
    static final String DFA15_specialS =
        "\15\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\1\20\uffff\1\1\6\uffff\1\1\2\uffff\1\1\1\14\1\uffff\1\1\4"+
            "\uffff\3\1\4\uffff\3\1\10\uffff\2\1",
            "",
            "",
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
            return "475:3: ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' )";
        }
    }
    static final String DFA14_eotS =
        "\14\uffff";
    static final String DFA14_eofS =
        "\14\uffff";
    static final String DFA14_minS =
        "\1\6\13\uffff";
    static final String DFA14_maxS =
        "\1\74\13\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\1\2\11\uffff";
    static final String DFA14_specialS =
        "\14\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\2\20\uffff\1\2\6\uffff\1\2\2\uffff\1\1\2\uffff\1\2\4\uffff"+
            "\3\2\4\uffff\3\2\10\uffff\2\2",
            "",
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
            return "476:4: ( ':' parentClass= IDENTIFIER )?";
        }
    }
    static final String DFA18_eotS =
        "\13\uffff";
    static final String DFA18_eofS =
        "\13\uffff";
    static final String DFA18_minS =
        "\1\6\12\uffff";
    static final String DFA18_maxS =
        "\1\74\12\uffff";
    static final String DFA18_acceptS =
        "\1\uffff\1\1\1\2\10\uffff";
    static final String DFA18_specialS =
        "\13\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\2\20\uffff\1\2\6\uffff\1\2\5\uffff\1\1\4\uffff\3\2\4\uffff"+
            "\3\2\10\uffff\2\2",
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
            return "486:3: ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )?";
        }
    }
    static final String DFA22_eotS =
        "\12\uffff";
    static final String DFA22_eofS =
        "\12\uffff";
    static final String DFA22_minS =
        "\1\6\11\uffff";
    static final String DFA22_maxS =
        "\1\74\11\uffff";
    static final String DFA22_acceptS =
        "\1\uffff\1\1\1\2\7\uffff";
    static final String DFA22_specialS =
        "\12\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\2\20\uffff\1\1\6\uffff\1\2\12\uffff\3\2\4\uffff\3\2\10\uffff"+
            "\2\2",
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
            return "495:3: ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) ) )* '}' )?";
        }
    }
    static final String DFA20_eotS =
        "\u008c\uffff";
    static final String DFA20_eofS =
        "\u008c\uffff";
    static final String DFA20_minS =
        "\1\6\1\5\4\6\1\4\2\6\1\70\1\5\2\uffff\1\0\4\6\1\5\1\6\1\5\1\6\4"+
        "\0\2\uffff\26\0\1\uffff\5\0\1\uffff\3\0\2\uffff\6\0\2\uffff\4\0"+
        "\2\uffff\1\0\10\uffff\12\0\2\uffff\13\0\1\uffff\27\0\2\uffff\6\0";
    static final String DFA20_maxS =
        "\2\74\1\6\2\27\1\74\1\131\1\74\1\72\1\70\1\74\2\uffff\1\0\1\6\2"+
        "\27\4\74\1\30\4\0\2\uffff\26\0\1\uffff\5\0\1\uffff\3\0\2\uffff\6"+
        "\0\2\uffff\4\0\2\uffff\1\0\10\uffff\12\0\2\uffff\13\0\1\uffff\27"+
        "\0\2\uffff\6\0";
    static final String DFA20_acceptS =
        "\13\uffff\1\1\54\uffff\1\2\123\uffff";
    static final String DFA20_specialS =
        "\15\uffff\1\0\10\uffff\1\1\1\2\1\3\1\4\2\uffff\1\5\1\6\1\7\1\10"+
        "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
        "\1\26\1\27\1\30\1\31\1\32\1\uffff\1\33\1\34\1\35\1\36\1\37\1\uffff"+
        "\1\40\1\41\1\42\2\uffff\1\43\1\44\1\45\1\46\1\47\1\50\2\uffff\1"+
        "\51\1\52\1\53\1\54\2\uffff\1\55\10\uffff\1\56\1\57\1\60\1\61\1\62"+
        "\1\63\1\64\1\65\1\66\1\67\2\uffff\1\70\1\71\1\72\1\73\1\74\1\75"+
        "\1\76\1\77\1\100\1\101\1\102\1\uffff\1\103\1\104\1\105\1\106\1\107"+
        "\1\110\1\111\1\112\1\113\1\114\1\115\1\116\1\117\1\120\1\121\1\122"+
        "\1\123\1\124\1\125\1\126\1\127\1\130\1\131\2\uffff\1\132\1\133\1"+
        "\134\1\135\1\136\1\137}>";
    static final String[] DFA20_transitionS = {
            "\1\1\27\uffff\1\4\21\uffff\3\3\11\uffff\1\2",
            "\1\5\1\12\22\uffff\1\15\4\uffff\1\20\2\uffff\1\13\1\6\1\uffff"+
            "\1\7\13\uffff\3\17\2\uffff\2\10\1\11\2\uffff\1\13\1\uffff\1"+
            "\16",
            "\1\21",
            "\1\22\20\uffff\1\23",
            "\1\24\20\uffff\1\25",
            "\1\31\22\uffff\1\34\4\uffff\1\37\2\uffff\1\13\1\30\15\uffff"+
            "\3\36\2\uffff\2\26\1\27\2\uffff\1\13\1\uffff\1\35",
            "\1\44\1\51\1\41\1\45\1\46\1\47\1\50\24\uffff\1\54\2\uffff\1"+
            "\43\1\60\7\uffff\1\61\7\uffff\1\61\1\40\1\42\1\56\1\52\2\uffff"+
            "\1\13\16\uffff\1\53\1\55\13\uffff\1\57\3\61",
            "\1\63\27\uffff\1\66\6\uffff\1\67\12\uffff\3\65\11\uffff\1\64",
            "\1\13\22\uffff\1\70\10\uffff\1\73\22\uffff\2\71\1\72\2\uffff"+
            "\1\13",
            "\1\76",
            "\1\77\1\103\22\uffff\1\106\2\uffff\2\13\1\111\2\uffff\1\13"+
            "\1\100\1\uffff\1\114\13\uffff\3\110\2\uffff\2\101\1\102\2\uffff"+
            "\1\13\1\uffff\1\107",
            "",
            "",
            "\1\uffff",
            "\1\125",
            "\1\126\20\uffff\1\127",
            "\1\130\20\uffff\1\131",
            "\1\136\22\uffff\1\141\4\uffff\1\144\2\uffff\1\13\1\135\1\uffff"+
            "\1\132\13\uffff\3\143\2\uffff\2\133\1\134\2\uffff\1\13\1\uffff"+
            "\1\142",
            "\1\145\1\150\20\uffff\1\147\1\uffff\1\155\4\uffff\1\160\2\uffff"+
            "\1\151\1\146\15\uffff\3\157\2\uffff\2\152\1\153\2\uffff\1\13"+
            "\1\uffff\1\156",
            "\1\164\21\uffff\1\175\1\uffff\1\174\1\173\2\uffff\1\167\2\171"+
            "\14\uffff\1\161\1\162\1\163\3\166\1\170\7\uffff\1\172\1\165",
            "\1\176\1\u0080\20\uffff\1\u0081\1\uffff\1\u0086\4\uffff\1\u0089"+
            "\2\uffff\1\13\1\177\15\uffff\3\u0088\2\uffff\2\u0082\1\u0083"+
            "\2\uffff\1\13\1\uffff\1\u0087",
            "\1\u008a\21\uffff\1\u008b",
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
            "\1\uffff"
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
            return "502:6: (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA20_13 = input.LA(1);

                         
                        int index20_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred30_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred30_ObjCpp())) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_13);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA20_22 = input.LA(1);

                         
                        int index20_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_22);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA20_23 = input.LA(1);

                         
                        int index20_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_23);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA20_24 = input.LA(1);

                         
                        int index20_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_24);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA20_25 = input.LA(1);

                         
                        int index20_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_25);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA20_28 = input.LA(1);

                         
                        int index20_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_28);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA20_29 = input.LA(1);

                         
                        int index20_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_29);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA20_30 = input.LA(1);

                         
                        int index20_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_30);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA20_31 = input.LA(1);

                         
                        int index20_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_31);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA20_32 = input.LA(1);

                         
                        int index20_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_32);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA20_33 = input.LA(1);

                         
                        int index20_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred30_ObjCpp()||(synpred30_ObjCpp()&&( isTypeIdentifier(next()) )))) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_33);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA20_34 = input.LA(1);

                         
                        int index20_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred30_ObjCpp()||(synpred30_ObjCpp()&&( isTypeIdentifier(next()) )))) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_34);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA20_35 = input.LA(1);

                         
                        int index20_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred30_ObjCpp()||(synpred30_ObjCpp()&&( isTypeIdentifier(next()) )))) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_35);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA20_36 = input.LA(1);

                         
                        int index20_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_36);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA20_37 = input.LA(1);

                         
                        int index20_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_37);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA20_38 = input.LA(1);

                         
                        int index20_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_38);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA20_39 = input.LA(1);

                         
                        int index20_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_39);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA20_40 = input.LA(1);

                         
                        int index20_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_40);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA20_41 = input.LA(1);

                         
                        int index20_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_41);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA20_42 = input.LA(1);

                         
                        int index20_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_42);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA20_43 = input.LA(1);

                         
                        int index20_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_43);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA20_44 = input.LA(1);

                         
                        int index20_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_44);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA20_45 = input.LA(1);

                         
                        int index20_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_45);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA20_46 = input.LA(1);

                         
                        int index20_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred30_ObjCpp()||(synpred30_ObjCpp()&&( isTypeIdentifier(next()) )))) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_46);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA20_47 = input.LA(1);

                         
                        int index20_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_47);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA20_48 = input.LA(1);

                         
                        int index20_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_48);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA20_49 = input.LA(1);

                         
                        int index20_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_49);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA20_51 = input.LA(1);

                         
                        int index20_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred30_ObjCpp()&&( isTypeIdentifier(next()) ))) ) {s = 11;}

                        else if ( (( isTypeIdentifier(next()) )) ) {s = 56;}

                         
                        input.seek(index20_51);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA20_52 = input.LA(1);

                         
                        int index20_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred30_ObjCpp()&&( isTypeIdentifier(next()) ))) ) {s = 11;}

                        else if ( (( isTypeIdentifier(next()) )) ) {s = 56;}

                         
                        input.seek(index20_52);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA20_53 = input.LA(1);

                         
                        int index20_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred30_ObjCpp()&&( isTypeIdentifier(next()) ))) ) {s = 11;}

                        else if ( (( isTypeIdentifier(next()) )) ) {s = 56;}

                         
                        input.seek(index20_53);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA20_54 = input.LA(1);

                         
                        int index20_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred30_ObjCpp()&&( isTypeIdentifier(next()) ))) ) {s = 11;}

                        else if ( (( isTypeIdentifier(next()) )) ) {s = 56;}

                         
                        input.seek(index20_54);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA20_55 = input.LA(1);

                         
                        int index20_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred30_ObjCpp()&&( isTypeIdentifier(next()) ))) ) {s = 11;}

                        else if ( (( isTypeIdentifier(next()) )) ) {s = 56;}

                         
                        input.seek(index20_55);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA20_57 = input.LA(1);

                         
                        int index20_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred30_ObjCpp()||(synpred30_ObjCpp()&&( isTypeIdentifier(next()) )))) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_57);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA20_58 = input.LA(1);

                         
                        int index20_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred30_ObjCpp()||(synpred30_ObjCpp()&&( isTypeIdentifier(next()) )))) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_58);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA20_59 = input.LA(1);

                         
                        int index20_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred30_ObjCpp()||(synpred30_ObjCpp()&&( isTypeIdentifier(next()) )))) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_59);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA20_62 = input.LA(1);

                         
                        int index20_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred30_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred30_ObjCpp())) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_62);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA20_63 = input.LA(1);

                         
                        int index20_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred30_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred30_ObjCpp())) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_63);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA20_64 = input.LA(1);

                         
                        int index20_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred30_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred30_ObjCpp())) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_64);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA20_65 = input.LA(1);

                         
                        int index20_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred30_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred30_ObjCpp())) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_65);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA20_66 = input.LA(1);

                         
                        int index20_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred30_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred30_ObjCpp())) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_66);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA20_67 = input.LA(1);

                         
                        int index20_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred30_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred30_ObjCpp())) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_67);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA20_70 = input.LA(1);

                         
                        int index20_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred30_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred30_ObjCpp())) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_70);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA20_71 = input.LA(1);

                         
                        int index20_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred30_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred30_ObjCpp())) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_71);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA20_72 = input.LA(1);

                         
                        int index20_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred30_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred30_ObjCpp())) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_72);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA20_73 = input.LA(1);

                         
                        int index20_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred30_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred30_ObjCpp())) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_73);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA20_76 = input.LA(1);

                         
                        int index20_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred30_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred30_ObjCpp())) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_76);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA20_85 = input.LA(1);

                         
                        int index20_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred30_ObjCpp()||(synpred30_ObjCpp()&&( isTypeIdentifier(next()) )))) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_85);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA20_86 = input.LA(1);

                         
                        int index20_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred30_ObjCpp()||(synpred30_ObjCpp()&&( isTypeIdentifier(next()) )))) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_86);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA20_87 = input.LA(1);

                         
                        int index20_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred30_ObjCpp()||(synpred30_ObjCpp()&&( isTypeIdentifier(next()) )))) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_87);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA20_88 = input.LA(1);

                         
                        int index20_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred30_ObjCpp()||(synpred30_ObjCpp()&&( isTypeIdentifier(next()) )))) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_88);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA20_89 = input.LA(1);

                         
                        int index20_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred30_ObjCpp()||(synpred30_ObjCpp()&&( isTypeIdentifier(next()) )))) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_89);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA20_90 = input.LA(1);

                         
                        int index20_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_90);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA20_91 = input.LA(1);

                         
                        int index20_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_91);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA20_92 = input.LA(1);

                         
                        int index20_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_92);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA20_93 = input.LA(1);

                         
                        int index20_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_93);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA20_94 = input.LA(1);

                         
                        int index20_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_94);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA20_97 = input.LA(1);

                         
                        int index20_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_97);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA20_98 = input.LA(1);

                         
                        int index20_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_98);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA20_99 = input.LA(1);

                         
                        int index20_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_99);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA20_100 = input.LA(1);

                         
                        int index20_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_100);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA20_101 = input.LA(1);

                         
                        int index20_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_101);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA20_102 = input.LA(1);

                         
                        int index20_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_102);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA20_103 = input.LA(1);

                         
                        int index20_103 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_103);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA20_104 = input.LA(1);

                         
                        int index20_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_104);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA20_105 = input.LA(1);

                         
                        int index20_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_105);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA20_106 = input.LA(1);

                         
                        int index20_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_106);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA20_107 = input.LA(1);

                         
                        int index20_107 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_107);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA20_109 = input.LA(1);

                         
                        int index20_109 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_109);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA20_110 = input.LA(1);

                         
                        int index20_110 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_110);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA20_111 = input.LA(1);

                         
                        int index20_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_111);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA20_112 = input.LA(1);

                         
                        int index20_112 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_112);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA20_113 = input.LA(1);

                         
                        int index20_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_113);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA20_114 = input.LA(1);

                         
                        int index20_114 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_114);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA20_115 = input.LA(1);

                         
                        int index20_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_115);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA20_116 = input.LA(1);

                         
                        int index20_116 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_116);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA20_117 = input.LA(1);

                         
                        int index20_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_117);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA20_118 = input.LA(1);

                         
                        int index20_118 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_118);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA20_119 = input.LA(1);

                         
                        int index20_119 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_119);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA20_120 = input.LA(1);

                         
                        int index20_120 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_120);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA20_121 = input.LA(1);

                         
                        int index20_121 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_121);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA20_122 = input.LA(1);

                         
                        int index20_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_122);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA20_123 = input.LA(1);

                         
                        int index20_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_123);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA20_124 = input.LA(1);

                         
                        int index20_124 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_124);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA20_125 = input.LA(1);

                         
                        int index20_125 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_125);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA20_126 = input.LA(1);

                         
                        int index20_126 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_126);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA20_127 = input.LA(1);

                         
                        int index20_127 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_127);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA20_128 = input.LA(1);

                         
                        int index20_128 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_128);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA20_129 = input.LA(1);

                         
                        int index20_129 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_129);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA20_130 = input.LA(1);

                         
                        int index20_130 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_130);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA20_131 = input.LA(1);

                         
                        int index20_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_131);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA20_134 = input.LA(1);

                         
                        int index20_134 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_134);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA20_135 = input.LA(1);

                         
                        int index20_135 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_135);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA20_136 = input.LA(1);

                         
                        int index20_136 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_136);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA20_137 = input.LA(1);

                         
                        int index20_137 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_137);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA20_138 = input.LA(1);

                         
                        int index20_138 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_138);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA20_139 = input.LA(1);

                         
                        int index20_139 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_ObjCpp()) ) {s = 11;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index20_139);
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
    static final String DFA31_eotS =
        "\16\uffff";
    static final String DFA31_eofS =
        "\16\uffff";
    static final String DFA31_minS =
        "\1\6\15\uffff";
    static final String DFA31_maxS =
        "\1\74\15\uffff";
    static final String DFA31_acceptS =
        "\1\uffff\1\3\1\1\2\uffff\1\2\10\uffff";
    static final String DFA31_specialS =
        "\16\uffff}>";
    static final String[] DFA31_transitionS = {
            "\1\5\21\uffff\1\1\1\uffff\2\5\2\uffff\3\5\14\uffff\3\2\4\5\7"+
            "\uffff\2\5",
            "",
            "",
            "",
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
            return "()* loopback of 589:4: ( ( 'public' | 'private' | 'protected' ) ':' | declaration )*";
        }
    }
    static final String DFA34_eotS =
        "\u0084\uffff";
    static final String DFA34_eofS =
        "\2\4\20\uffff\1\4\161\uffff";
    static final String DFA34_minS =
        "\1\6\1\5\1\4\17\uffff\1\6\1\4\4\uffff\1\4\22\uffff\1\27\30\uffff"+
        "\1\0\4\uffff\4\0\4\uffff\14\0\1\uffff\2\0\2\uffff\1\0\41\uffff";
    static final String DFA34_maxS =
        "\1\74\2\131\17\uffff\1\74\1\131\4\uffff\1\131\22\uffff\1\133\30"+
        "\uffff\1\0\4\uffff\4\0\4\uffff\14\0\1\uffff\2\0\2\uffff\1\0\41\uffff";
    static final String DFA34_acceptS =
        "\3\uffff\1\1\1\2\177\uffff";
    static final String DFA34_specialS =
        "\104\uffff\1\0\4\uffff\1\1\1\2\1\3\1\4\4\uffff\1\5\1\6\1\7\1\10"+
        "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\uffff\1\21\1\22\2\uffff"+
        "\1\23\41\uffff}>";
    static final String[] DFA34_transitionS = {
            "\1\1\20\uffff\1\3\1\uffff\1\4\2\uffff\3\4\2\uffff\1\2\2\4\1"+
            "\uffff\1\4\12\uffff\4\4\1\uffff\3\4\2\uffff\1\4\1\uffff\1\4",
            "\1\22\1\4\20\uffff\1\3\1\uffff\1\4\2\uffff\3\4\2\uffff\1\30"+
            "\1\23\3\4\4\uffff\2\4\4\uffff\4\4\1\uffff\3\4\2\uffff\1\4\1"+
            "\uffff\15\4\2\uffff\12\4\2\uffff\3\4",
            "\2\4\1\53\4\4\24\uffff\1\4\2\uffff\1\4\10\uffff\1\4\1\uffff"+
            "\1\3\5\uffff\1\4\1\uffff\3\4\21\uffff\2\4\13\uffff\4\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\4\20\uffff\1\3\1\uffff\1\4\2\uffff\3\4\2\uffff\1\104\2\4"+
            "\1\uffff\1\4\12\uffff\4\4\1\uffff\3\4\2\uffff\1\4\1\uffff\1"+
            "\4",
            "\1\124\1\123\1\112\1\125\1\126\1\127\1\130\23\uffff\1\4\1\133"+
            "\2\uffff\1\113\1\121\7\uffff\1\136\1\4\3\uffff\3\4\1\136\1\111"+
            "\1\114\1\122\1\131\2\uffff\1\4\1\uffff\1\4\14\uffff\1\132\1"+
            "\134\13\uffff\1\137\3\136",
            "",
            "",
            "",
            "",
            "\2\4\1\142\4\4\24\uffff\1\4\2\uffff\1\4\10\uffff\1\4\1\uffff"+
            "\1\3\5\uffff\1\4\1\uffff\3\4\21\uffff\2\4\13\uffff\4\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\3\4\uffff\2\4\4\uffff\4\4\4\uffff\2\4\11\uffff\3\4\2\uffff"+
            "\1\4\2\uffff\3\4\1\uffff\10\4\2\uffff\13\4\1\uffff\2\4\1\uffff"+
            "\2\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "618:5: ( (m2= modifiers ( ':' ( 'public' )? parent= IDENTIFIER )? nb= structBody ) | )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA34_68 = input.LA(1);

                         
                        int index34_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index34_68);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA34_73 = input.LA(1);

                         
                        int index34_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index34_73);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA34_74 = input.LA(1);

                         
                        int index34_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index34_74);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA34_75 = input.LA(1);

                         
                        int index34_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index34_75);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA34_76 = input.LA(1);

                         
                        int index34_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index34_76);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA34_81 = input.LA(1);

                         
                        int index34_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index34_81);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA34_82 = input.LA(1);

                         
                        int index34_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index34_82);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA34_83 = input.LA(1);

                         
                        int index34_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index34_83);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA34_84 = input.LA(1);

                         
                        int index34_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index34_84);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA34_85 = input.LA(1);

                         
                        int index34_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index34_85);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA34_86 = input.LA(1);

                         
                        int index34_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index34_86);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA34_87 = input.LA(1);

                         
                        int index34_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index34_87);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA34_88 = input.LA(1);

                         
                        int index34_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index34_88);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA34_89 = input.LA(1);

                         
                        int index34_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index34_89);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA34_90 = input.LA(1);

                         
                        int index34_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index34_90);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA34_91 = input.LA(1);

                         
                        int index34_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index34_91);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA34_92 = input.LA(1);

                         
                        int index34_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index34_92);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA34_94 = input.LA(1);

                         
                        int index34_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index34_94);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA34_95 = input.LA(1);

                         
                        int index34_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index34_95);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA34_98 = input.LA(1);

                         
                        int index34_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index34_98);
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
    static final String DFA39_eotS =
        "\24\uffff";
    static final String DFA39_eofS =
        "\24\uffff";
    static final String DFA39_minS =
        "\1\6\1\0\22\uffff";
    static final String DFA39_maxS =
        "\1\74\1\0\22\uffff";
    static final String DFA39_acceptS =
        "\2\uffff\1\1\2\uffff\1\2\16\uffff";
    static final String DFA39_specialS =
        "\1\uffff\1\0\22\uffff}>";
    static final String[] DFA39_transitionS = {
            "\1\1\27\uffff\1\2\21\uffff\3\2\1\5\10\uffff\1\2",
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

    static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
    static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
    static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
    static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
    static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
    static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
    static final short[][] DFA39_transition;

    static {
        int numStates = DFA39_transitionS.length;
        DFA39_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = DFA39_eot;
            this.eof = DFA39_eof;
            this.min = DFA39_min;
            this.max = DFA39_max;
            this.accept = DFA39_accept;
            this.special = DFA39_special;
            this.transition = DFA39_transition;
        }
        public String getDescription() {
            return "698:16: (returnTypeRef= mutableTypeRef )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA39_1 = input.LA(1);

                         
                        int index39_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred57_ObjCpp()&&( isTypeIdentifier(next()) ))||synpred57_ObjCpp())) ) {s = 2;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index39_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 39, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA40_eotS =
        "\12\uffff";
    static final String DFA40_eofS =
        "\12\uffff";
    static final String DFA40_minS =
        "\1\6\1\0\10\uffff";
    static final String DFA40_maxS =
        "\1\31\1\0\10\uffff";
    static final String DFA40_acceptS =
        "\2\uffff\1\2\6\uffff\1\1";
    static final String DFA40_specialS =
        "\1\uffff\1\0\10\uffff}>";
    static final String[] DFA40_transitionS = {
            "\1\1\20\uffff\1\2\1\uffff\1\2",
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
            return "710:3: ({...}?ct= IDENTIFIER | )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA40_1 = input.LA(1);

                         
                        int index40_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred58_ObjCpp()&&( next("const", "__const") ))) ) {s = 9;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index40_1);
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
    static final String DFA42_eotS =
        "\46\uffff";
    static final String DFA42_eofS =
        "\46\uffff";
    static final String DFA42_minS =
        "\1\6\1\0\44\uffff";
    static final String DFA42_maxS =
        "\1\74\1\0\44\uffff";
    static final String DFA42_acceptS =
        "\2\uffff\1\2\42\uffff\1\1";
    static final String DFA42_specialS =
        "\1\uffff\1\0\44\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\1\20\uffff\1\2\1\uffff\1\2\4\uffff\1\2\2\uffff\3\2\14\uffff"+
            "\4\2\1\uffff\2\2\3\uffff\1\2\1\uffff\1\2",
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
            return "738:1: modifiers returns [List<Modifier> modifiers] : ( anyModifier | );";
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
                        if ( (synpred60_ObjCpp()) ) {s = 37;}

                        else if ( (true) ) {s = 2;}

                         
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
    static final String DFA45_eotS =
        "\50\uffff";
    static final String DFA45_eofS =
        "\1\uffff\1\4\46\uffff";
    static final String DFA45_minS =
        "\1\6\1\5\1\uffff\1\4\22\uffff\4\0\15\uffff\1\0";
    static final String DFA45_maxS =
        "\1\6\1\74\1\uffff\1\131\22\uffff\4\0\15\uffff\1\0";
    static final String DFA45_acceptS =
        "\2\uffff\1\1\1\uffff\1\2\20\uffff\1\3\4\uffff\1\5\1\4\14\uffff";
    static final String DFA45_specialS =
        "\26\uffff\1\0\1\1\1\2\1\3\15\uffff\1\4}>";
    static final String[] DFA45_transitionS = {
            "\1\1",
            "\1\2\1\4\20\uffff\1\4\1\uffff\1\4\2\uffff\3\4\2\uffff\1\4\1"+
            "\3\1\4\1\uffff\1\4\12\uffff\4\4\1\uffff\3\4\2\uffff\1\4\1\uffff"+
            "\1\4",
            "",
            "\1\33\1\31\1\26\4\33\24\uffff\1\33\2\uffff\1\27\1\32\7\uffff"+
            "\1\33\7\uffff\1\33\1\25\1\30\1\47\1\33\2\uffff\1\4\16\uffff"+
            "\2\33\13\uffff\4\33",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff"
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
            return "750:3: ({...}? IDENTIFIER ex= STRING | modifier | {...}? IDENTIFIER '(' 'return' binaryOp expression ')' | {...}? IDENTIFIER '(' expression ')' | {...}? IDENTIFIER '(' ( (an= STRING )* | extendedModifiers ) ')' )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA45_22 = input.LA(1);

                         
                        int index45_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred62_ObjCpp()&&( Modifier.parseModifier(next()) != null ))) ) {s = 4;}

                        else if ( ((synpred64_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))) ) {s = 27;}

                        else if ( (( next("__declspec", "__attribute__", "__asm") )) ) {s = 26;}

                         
                        input.seek(index45_22);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA45_23 = input.LA(1);

                         
                        int index45_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred62_ObjCpp()&&( Modifier.parseModifier(next()) != null ))) ) {s = 4;}

                        else if ( ((synpred64_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))) ) {s = 27;}

                         
                        input.seek(index45_23);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA45_24 = input.LA(1);

                         
                        int index45_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred62_ObjCpp()&&( Modifier.parseModifier(next()) != null ))) ) {s = 4;}

                        else if ( ((synpred64_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))) ) {s = 27;}

                         
                        input.seek(index45_24);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA45_25 = input.LA(1);

                         
                        int index45_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred64_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))) ) {s = 27;}

                        else if ( (( next("__declspec", "__attribute__", "__asm") )) ) {s = 26;}

                         
                        input.seek(index45_25);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA45_39 = input.LA(1);

                         
                        int index45_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred62_ObjCpp()&&( Modifier.parseModifier(next()) != null ))) ) {s = 4;}

                        else if ( ((synpred64_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))) ) {s = 27;}

                         
                        input.seek(index45_39);
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
    static final String DFA44_eotS =
        "\26\uffff";
    static final String DFA44_eofS =
        "\26\uffff";
    static final String DFA44_minS =
        "\1\5\1\uffff\1\0\23\uffff";
    static final String DFA44_maxS =
        "\1\43\1\uffff\1\0\23\uffff";
    static final String DFA44_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\22\uffff";
    static final String DFA44_specialS =
        "\2\uffff\1\0\23\uffff}>";
    static final String[] DFA44_transitionS = {
            "\1\1\1\3\34\uffff\1\2",
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
            return "766:8: ( (an= STRING )* | extendedModifiers )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA44_2 = input.LA(1);

                         
                        int index44_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index44_2);
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
    static final String DFA47_eotS =
        "\25\uffff";
    static final String DFA47_eofS =
        "\25\uffff";
    static final String DFA47_minS =
        "\1\6\1\0\23\uffff";
    static final String DFA47_maxS =
        "\1\74\1\0\23\uffff";
    static final String DFA47_acceptS =
        "\2\uffff\1\3\20\uffff\1\1\1\2";
    static final String DFA47_specialS =
        "\1\uffff\1\0\23\uffff}>";
    static final String[] DFA47_transitionS = {
            "\1\1\27\uffff\1\2\21\uffff\3\2\11\uffff\1\2",
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
            return "()* loopback of 807:3: ({...}?sm= modifier | {...}?tm= modifier )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA47_1 = input.LA(1);

                         
                        int index47_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred68_ObjCpp()&&( next(Modifier.Kind.StorageClassSpecifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 19;}

                        else if ( (((synpred69_ObjCpp()&&( next(Modifier.Kind.TypeQualifier) ))&&( Modifier.parseModifier(next()) != null ))) ) {s = 20;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index47_1);
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
    static final String DFA61_eotS =
        "\113\uffff";
    static final String DFA61_eofS =
        "\1\1\5\uffff\1\14\14\uffff\1\14\67\uffff";
    static final String DFA61_minS =
        "\1\6\4\uffff\2\6\6\uffff\1\5\1\uffff\1\6\1\uffff\1\0\2\6\7\uffff"+
        "\1\6\1\uffff\2\0\1\uffff\1\0\4\uffff\1\0\22\uffff\7\0\7\uffff\1"+
        "\0\1\uffff\3\0";
    static final String DFA61_maxS =
        "\1\72\4\uffff\2\72\6\uffff\1\72\1\uffff\1\72\1\uffff\1\0\2\72\7"+
        "\uffff\1\72\1\uffff\2\0\1\uffff\1\0\4\uffff\1\0\22\uffff\7\0\7\uffff"+
        "\1\0\1\uffff\3\0";
    static final String DFA61_acceptS =
        "\1\uffff\1\3\12\uffff\1\1\33\uffff\1\2\42\uffff";
    static final String DFA61_specialS =
        "\21\uffff\1\0\13\uffff\1\1\1\2\1\uffff\1\3\4\uffff\1\4\22\uffff"+
        "\1\5\1\6\1\7\1\10\1\11\1\12\1\13\7\uffff\1\14\1\uffff\1\15\1\16"+
        "\1\17}>";
    static final String[] DFA61_transitionS = {
            "\1\1\22\uffff\1\1\2\uffff\2\1\4\uffff\1\5\1\1\1\uffff\1\1\15"+
            "\uffff\1\1\1\uffff\2\6\1\14\2\uffff\1\1",
            "",
            "",
            "",
            "",
            "\1\15\33\uffff\1\1\22\uffff\1\17\1\1\3\uffff\1\1",
            "\1\21\22\uffff\1\14\2\uffff\2\14\4\uffff\1\22\1\14\1\uffff"+
            "\1\14\15\uffff\1\14\1\uffff\2\23\1\14\2\uffff\1\33",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\35\1\1\26\uffff\1\1\4\uffff\1\36\1\1\21\uffff\1\40\2\1\2"+
            "\uffff\1\1",
            "",
            "\1\45\33\uffff\1\1\1\50\21\uffff\2\1\3\uffff\1\1",
            "",
            "\1\uffff",
            "\1\70\33\uffff\1\72\22\uffff\1\71\1\73\3\uffff\1\73",
            "\1\74\22\uffff\1\14\2\uffff\2\14\4\uffff\1\75\1\14\1\uffff"+
            "\1\14\15\uffff\1\14\1\uffff\2\76\1\14\2\uffff\1\106",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\110\33\uffff\1\111\22\uffff\2\112\3\uffff\1\112",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            "\1\uffff"
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
            return "()* loopback of 916:3: ( ( typeMutator ) | ( functionSignatureSuffix ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA61_17 = input.LA(1);

                         
                        int index61_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_17);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA61_29 = input.LA(1);

                         
                        int index61_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_ObjCpp()) ) {s = 40;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_29);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA61_30 = input.LA(1);

                         
                        int index61_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_ObjCpp()) ) {s = 40;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_30);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA61_32 = input.LA(1);

                         
                        int index61_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_ObjCpp()) ) {s = 40;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_32);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA61_37 = input.LA(1);

                         
                        int index61_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred85_ObjCpp()) ) {s = 40;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_37);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA61_56 = input.LA(1);

                         
                        int index61_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_56);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA61_57 = input.LA(1);

                         
                        int index61_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_57);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA61_58 = input.LA(1);

                         
                        int index61_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_58);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA61_59 = input.LA(1);

                         
                        int index61_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_59);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA61_60 = input.LA(1);

                         
                        int index61_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_60);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA61_61 = input.LA(1);

                         
                        int index61_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_61);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA61_62 = input.LA(1);

                         
                        int index61_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_62);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA61_70 = input.LA(1);

                         
                        int index61_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_70);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA61_72 = input.LA(1);

                         
                        int index61_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_72);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA61_73 = input.LA(1);

                         
                        int index61_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_73);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA61_74 = input.LA(1);

                         
                        int index61_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_74);
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
        "\46\uffff";
    static final String DFA63_eofS =
        "\46\uffff";
    static final String DFA63_minS =
        "\1\6\1\uffff\2\6\4\uffff\1\5\1\uffff\1\6\2\uffff\2\6\2\uffff\2\0"+
        "\1\uffff\1\0\4\uffff\1\0\3\uffff\2\0\2\uffff\2\0\3\uffff";
    static final String DFA63_maxS =
        "\1\72\1\uffff\2\72\4\uffff\1\72\1\uffff\1\72\2\uffff\2\72\2\uffff"+
        "\2\0\1\uffff\1\0\4\uffff\1\0\3\uffff\2\0\2\uffff\2\0\3\uffff";
    static final String DFA63_acceptS =
        "\1\uffff\1\2\5\uffff\1\1\36\uffff";
    static final String DFA63_specialS =
        "\21\uffff\1\0\1\1\1\uffff\1\2\4\uffff\1\3\3\uffff\1\4\1\5\2\uffff"+
        "\1\6\1\7\3\uffff}>";
    static final String[] DFA63_transitionS = {
            "\1\1\22\uffff\1\1\7\uffff\1\1\1\2\22\uffff\2\3\1\7\2\uffff\1"+
            "\1",
            "",
            "\1\10\33\uffff\1\1\22\uffff\1\12\1\1\3\uffff\1\1",
            "\1\1\33\uffff\1\15\22\uffff\2\16\1\7\2\uffff\1\1",
            "",
            "",
            "",
            "",
            "\1\21\1\1\26\uffff\1\1\4\uffff\1\22\1\1\21\uffff\1\24\2\1\2"+
            "\uffff\1\1",
            "",
            "\1\31\33\uffff\1\1\1\7\21\uffff\2\1\3\uffff\1\1",
            "",
            "",
            "\1\35\33\uffff\1\1\22\uffff\1\36\1\1\3\uffff\1\1",
            "\1\1\33\uffff\1\41\22\uffff\2\42\1\7\2\uffff\1\1",
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
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
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
            return "()* loopback of 937:3: ( ( typeMutator )* ( functionSignatureSuffix ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA63_17 = input.LA(1);

                         
                        int index63_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 7;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index63_17);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA63_18 = input.LA(1);

                         
                        int index63_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 7;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index63_18);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA63_20 = input.LA(1);

                         
                        int index63_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 7;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index63_20);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA63_25 = input.LA(1);

                         
                        int index63_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 7;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index63_25);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA63_29 = input.LA(1);

                         
                        int index63_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 7;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index63_29);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA63_30 = input.LA(1);

                         
                        int index63_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 7;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index63_30);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA63_33 = input.LA(1);

                         
                        int index63_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 7;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index63_33);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA63_34 = input.LA(1);

                         
                        int index63_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_ObjCpp()) ) {s = 7;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index63_34);
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
        "\26\uffff";
    static final String DFA65_eofS =
        "\1\2\25\uffff";
    static final String DFA65_minS =
        "\1\31\1\0\24\uffff";
    static final String DFA65_maxS =
        "\1\43\1\0\24\uffff";
    static final String DFA65_acceptS =
        "\2\uffff\1\2\22\uffff\1\1";
    static final String DFA65_specialS =
        "\1\uffff\1\0\24\uffff}>";
    static final String[] DFA65_transitionS = {
            "\1\2\2\uffff\1\2\1\1\3\uffff\1\2\1\uffff\1\2",
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
            return "968:3: ( '=' dv= topLevelExpr )?";
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
                        if ( (synpred91_ObjCpp()) ) {s = 21;}

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
    static final String DFA70_eotS =
        "\20\uffff";
    static final String DFA70_eofS =
        "\20\uffff";
    static final String DFA70_minS =
        "\1\4\17\uffff";
    static final String DFA70_maxS =
        "\1\131\17\uffff";
    static final String DFA70_acceptS =
        "\1\uffff\1\1\15\uffff\1\2";
    static final String DFA70_specialS =
        "\20\uffff}>";
    static final String[] DFA70_transitionS = {
            "\7\1\24\uffff\1\1\2\uffff\1\1\10\uffff\1\1\7\uffff\1\1\1\uffff"+
            "\3\1\1\17\20\uffff\2\1\13\uffff\4\1",
            "",
            "",
            "",
            "",
            "",
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

    static final short[] DFA70_eot = DFA.unpackEncodedString(DFA70_eotS);
    static final short[] DFA70_eof = DFA.unpackEncodedString(DFA70_eofS);
    static final char[] DFA70_min = DFA.unpackEncodedStringToUnsignedChars(DFA70_minS);
    static final char[] DFA70_max = DFA.unpackEncodedStringToUnsignedChars(DFA70_maxS);
    static final short[] DFA70_accept = DFA.unpackEncodedString(DFA70_acceptS);
    static final short[] DFA70_special = DFA.unpackEncodedString(DFA70_specialS);
    static final short[][] DFA70_transition;

    static {
        int numStates = DFA70_transitionS.length;
        DFA70_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA70_transition[i] = DFA.unpackEncodedString(DFA70_transitionS[i]);
        }
    }

    class DFA70 extends DFA {

        public DFA70(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 70;
            this.eot = DFA70_eot;
            this.eof = DFA70_eof;
            this.min = DFA70_min;
            this.max = DFA70_max;
            this.accept = DFA70_accept;
            this.special = DFA70_special;
            this.transition = DFA70_transition;
        }
        public String getDescription() {
            return "1047:4: ( expression | )";
        }
    }
    static final String DFA72_eotS =
        "\12\uffff";
    static final String DFA72_eofS =
        "\12\uffff";
    static final String DFA72_minS =
        "\1\34\1\6\1\uffff\1\0\6\uffff";
    static final String DFA72_maxS =
        "\1\43\1\74\1\uffff\1\0\6\uffff";
    static final String DFA72_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\5\uffff";
    static final String DFA72_specialS =
        "\3\uffff\1\0\6\uffff}>";
    static final String[] DFA72_transitionS = {
            "\1\1\6\uffff\1\2",
            "\1\4\27\uffff\1\4\15\uffff\1\3\3\uffff\3\4\11\uffff\1\4",
            "",
            "\1\uffff",
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
            return "()* loopback of 1075:4: ( ',' ax= argDef )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA72_3 = input.LA(1);

                         
                        int index72_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred99_ObjCpp()) ) {s = 4;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index72_3);
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
    static final String DFA79_eotS =
        "\50\uffff";
    static final String DFA79_eofS =
        "\1\1\47\uffff";
    static final String DFA79_minS =
        "\1\6\5\uffff\1\0\41\uffff";
    static final String DFA79_maxS =
        "\1\74\5\uffff\1\0\41\uffff";
    static final String DFA79_acceptS =
        "\1\uffff\1\5\14\uffff\1\2\1\3\1\4\26\uffff\1\1";
    static final String DFA79_specialS =
        "\6\uffff\1\0\41\uffff}>";
    static final String[] DFA79_transitionS = {
            "\1\6\22\uffff\1\1\2\uffff\2\1\1\20\2\uffff\3\1\1\uffff\1\1\12"+
            "\uffff\3\17\1\1\1\uffff\3\1\2\uffff\1\1\1\uffff\1\16",
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
            return "()+ loopback of 1117:3: (mods= anyModifier | ( ( ( 'typename' | {...}?) i= IDENTIFIER ) ( '<' (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )? '>' )? ) | structCore | enumCore )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA79_6 = input.LA(1);

                         
                        int index79_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred102_ObjCpp()) ) {s = 39;}

                        else if ( ((synpred107_ObjCpp()&&( isTypeIdentifier(next()) ))) ) {s = 14;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index79_6);
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
    static final String DFA78_eotS =
        "\22\uffff";
    static final String DFA78_eofS =
        "\1\2\21\uffff";
    static final String DFA78_minS =
        "\1\6\21\uffff";
    static final String DFA78_maxS =
        "\1\74\21\uffff";
    static final String DFA78_acceptS =
        "\1\uffff\1\1\1\2\17\uffff";
    static final String DFA78_specialS =
        "\22\uffff}>";
    static final String[] DFA78_transitionS = {
            "\1\2\22\uffff\1\2\2\uffff\3\2\2\uffff\3\2\1\1\1\2\12\uffff\4"+
            "\2\1\uffff\3\2\2\uffff\1\2\1\uffff\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "1129:5: ( '<' (t1= mutableTypeRef ( ',' tx= mutableTypeRef )* )? '>' )?";
        }
    }
    static final String DFA83_eotS =
        "\20\uffff";
    static final String DFA83_eofS =
        "\20\uffff";
    static final String DFA83_minS =
        "\1\4\17\uffff";
    static final String DFA83_maxS =
        "\1\131\17\uffff";
    static final String DFA83_acceptS =
        "\1\uffff\1\1\15\uffff\1\2";
    static final String DFA83_specialS =
        "\20\uffff}>";
    static final String[] DFA83_transitionS = {
            "\7\1\24\uffff\1\1\2\uffff\1\1\1\17\7\uffff\1\1\7\uffff\1\1\1"+
            "\uffff\3\1\21\uffff\2\1\13\uffff\4\1",
            "",
            "",
            "",
            "",
            "",
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
            return "1183:3: (a1= expression ( ',' ax= expression )* )?";
        }
    }
    static final String DFA84_eotS =
        "\15\uffff";
    static final String DFA84_eofS =
        "\15\uffff";
    static final String DFA84_minS =
        "\1\4\14\uffff";
    static final String DFA84_maxS =
        "\1\112\14\uffff";
    static final String DFA84_acceptS =
        "\1\uffff\1\1\1\2\5\uffff\1\3\1\4\1\5\1\6\1\7";
    static final String DFA84_specialS =
        "\15\uffff}>";
    static final String[] DFA84_transitionS = {
            "\2\2\1\1\4\2\24\uffff\1\13\2\uffff\1\10\24\uffff\1\11\21\uffff"+
            "\1\12\1\14",
            "",
            "",
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
            return "1200:1: baseExpression returns [Expression expr] : ( IDENTIFIER | constant | '(' expression ')' | objCMethodCall | selectorExpr | protocolExpr | encodingExpr );";
        }
    }
    static final String DFA86_eotS =
        "\u0114\uffff";
    static final String DFA86_eofS =
        "\1\3\u0113\uffff";
    static final String DFA86_minS =
        "\1\6\1\4\11\uffff\1\4\7\0\1\4\3\42\2\4\21\0\u00bd\uffff\55\0";
    static final String DFA86_maxS =
        "\1\124\1\131\11\uffff\1\131\7\0\1\131\3\42\2\131\21\0\u00bd\uffff"+
        "\55\0";
    static final String DFA86_acceptS =
        "\2\uffff\1\1\1\2\u0110\uffff";
    static final String DFA86_specialS =
        "\14\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\6\uffff\1\7\1\10\1\11\1\12"+
        "\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
        "\u00bd\uffff\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1"+
        "\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56"+
        "\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73"+
        "\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1\104}>";
    static final String[] DFA86_transitionS = {
            "\1\3\21\uffff\2\3\2\uffff\1\3\1\1\3\uffff\1\3\1\uffff\1\3\24"+
            "\uffff\1\3\22\uffff\12\2",
            "\1\15\1\22\1\14\1\16\1\17\1\20\1\21\24\uffff\1\25\2\uffff\1"+
            "\13\10\uffff\1\27\7\uffff\1\27\1\uffff\2\27\1\23\21\uffff\1"+
            "\24\1\26\13\uffff\1\30\3\27",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\36\1\43\1\31\1\37\1\40\1\41\1\42\23\uffff\1\34\1\46\2\uffff"+
            "\1\35\10\uffff\1\50\4\uffff\3\33\1\50\1\uffff\2\50\1\44\4\uffff"+
            "\1\32\14\uffff\1\45\1\47\13\uffff\1\51\3\50",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\u00e9\1\u00ee\1\u00e8\1\u00ea\1\u00eb\1\u00ec\1\u00ed\24"+
            "\uffff\1\u00f1\2\uffff\1\u00e7\10\uffff\1\u00f3\7\uffff\1\u00f3"+
            "\1\uffff\2\u00f3\1\u00ef\21\uffff\1\u00f0\1\u00f2\13\uffff\1"+
            "\u00f4\3\u00f3",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00fa\1\u00ff\1\u00f9\1\u00fb\1\u00fc\1\u00fd\1\u00fe\24"+
            "\uffff\1\u0102\2\uffff\1\u00f8\10\uffff\1\u0104\7\uffff\1\u0104"+
            "\1\uffff\2\u0104\1\u0100\21\uffff\1\u0101\1\u0103\13\uffff\1"+
            "\u0105\3\u0104",
            "\1\u0108\1\u010d\1\u0107\1\u0109\1\u010a\1\u010b\1\u010c\24"+
            "\uffff\1\u0110\2\uffff\1\u0106\10\uffff\1\u0112\7\uffff\1\u0112"+
            "\1\uffff\2\u0112\1\u010e\21\uffff\1\u010f\1\u0111\13\uffff\1"+
            "\u0113\3\u0112",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff"
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
            return "1242:3: (op= assignmentOp f= assignmentExpr )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA86_12 = input.LA(1);

                         
                        int index86_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_12);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA86_13 = input.LA(1);

                         
                        int index86_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_13);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA86_14 = input.LA(1);

                         
                        int index86_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_14);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA86_15 = input.LA(1);

                         
                        int index86_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_15);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA86_16 = input.LA(1);

                         
                        int index86_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_16);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA86_17 = input.LA(1);

                         
                        int index86_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_17);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA86_18 = input.LA(1);

                         
                        int index86_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_18);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA86_25 = input.LA(1);

                         
                        int index86_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_25);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA86_26 = input.LA(1);

                         
                        int index86_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_26);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA86_27 = input.LA(1);

                         
                        int index86_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_27);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA86_28 = input.LA(1);

                         
                        int index86_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_28);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA86_29 = input.LA(1);

                         
                        int index86_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_29);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA86_30 = input.LA(1);

                         
                        int index86_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_30);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA86_31 = input.LA(1);

                         
                        int index86_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_31);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA86_32 = input.LA(1);

                         
                        int index86_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_32);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA86_33 = input.LA(1);

                         
                        int index86_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_33);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA86_34 = input.LA(1);

                         
                        int index86_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_34);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA86_35 = input.LA(1);

                         
                        int index86_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_35);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA86_36 = input.LA(1);

                         
                        int index86_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_36);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA86_37 = input.LA(1);

                         
                        int index86_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_37);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA86_38 = input.LA(1);

                         
                        int index86_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_38);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA86_39 = input.LA(1);

                         
                        int index86_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_39);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA86_40 = input.LA(1);

                         
                        int index86_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_40);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA86_41 = input.LA(1);

                         
                        int index86_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_41);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA86_231 = input.LA(1);

                         
                        int index86_231 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_231);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA86_232 = input.LA(1);

                         
                        int index86_232 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_232);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA86_233 = input.LA(1);

                         
                        int index86_233 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_233);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA86_234 = input.LA(1);

                         
                        int index86_234 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_234);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA86_235 = input.LA(1);

                         
                        int index86_235 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_235);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA86_236 = input.LA(1);

                         
                        int index86_236 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_236);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA86_237 = input.LA(1);

                         
                        int index86_237 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_237);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA86_238 = input.LA(1);

                         
                        int index86_238 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_238);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA86_239 = input.LA(1);

                         
                        int index86_239 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_239);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA86_240 = input.LA(1);

                         
                        int index86_240 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_240);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA86_241 = input.LA(1);

                         
                        int index86_241 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_241);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA86_242 = input.LA(1);

                         
                        int index86_242 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_242);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA86_243 = input.LA(1);

                         
                        int index86_243 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_243);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA86_244 = input.LA(1);

                         
                        int index86_244 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_244);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA86_245 = input.LA(1);

                         
                        int index86_245 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_245);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA86_246 = input.LA(1);

                         
                        int index86_246 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_246);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA86_247 = input.LA(1);

                         
                        int index86_247 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_247);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA86_248 = input.LA(1);

                         
                        int index86_248 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_248);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA86_249 = input.LA(1);

                         
                        int index86_249 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_249);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA86_250 = input.LA(1);

                         
                        int index86_250 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_250);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA86_251 = input.LA(1);

                         
                        int index86_251 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_251);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA86_252 = input.LA(1);

                         
                        int index86_252 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_252);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA86_253 = input.LA(1);

                         
                        int index86_253 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_253);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA86_254 = input.LA(1);

                         
                        int index86_254 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_254);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA86_255 = input.LA(1);

                         
                        int index86_255 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_255);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA86_256 = input.LA(1);

                         
                        int index86_256 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_256);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA86_257 = input.LA(1);

                         
                        int index86_257 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_257);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA86_258 = input.LA(1);

                         
                        int index86_258 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_258);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA86_259 = input.LA(1);

                         
                        int index86_259 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_259);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA86_260 = input.LA(1);

                         
                        int index86_260 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_260);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA86_261 = input.LA(1);

                         
                        int index86_261 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_261);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA86_262 = input.LA(1);

                         
                        int index86_262 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_262);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA86_263 = input.LA(1);

                         
                        int index86_263 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_263);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA86_264 = input.LA(1);

                         
                        int index86_264 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_264);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA86_265 = input.LA(1);

                         
                        int index86_265 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_265);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA86_266 = input.LA(1);

                         
                        int index86_266 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_266);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA86_267 = input.LA(1);

                         
                        int index86_267 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_267);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA86_268 = input.LA(1);

                         
                        int index86_268 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_268);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA86_269 = input.LA(1);

                         
                        int index86_269 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_269);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA86_270 = input.LA(1);

                         
                        int index86_270 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_270);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA86_271 = input.LA(1);

                         
                        int index86_271 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_271);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA86_272 = input.LA(1);

                         
                        int index86_272 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_272);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA86_273 = input.LA(1);

                         
                        int index86_273 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_273);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA86_274 = input.LA(1);

                         
                        int index86_274 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_274);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA86_275 = input.LA(1);

                         
                        int index86_275 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred139_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index86_275);
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
        "\14\uffff";
    static final String DFA87_eofS =
        "\1\1\13\uffff";
    static final String DFA87_minS =
        "\1\6\13\uffff";
    static final String DFA87_maxS =
        "\1\125\13\uffff";
    static final String DFA87_acceptS =
        "\1\uffff\1\2\11\uffff\1\1";
    static final String DFA87_specialS =
        "\14\uffff}>";
    static final String[] DFA87_transitionS = {
            "\1\1\21\uffff\2\1\2\uffff\2\1\3\uffff\1\1\1\uffff\1\1\24\uffff"+
            "\1\1\22\uffff\12\1\1\13",
            "",
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
            return "()* loopback of 1255:3: ( '?' logOrExpr ':' logOrExpr )*";
        }
    }
    static final String DFA88_eotS =
        "\25\uffff";
    static final String DFA88_eofS =
        "\1\1\24\uffff";
    static final String DFA88_minS =
        "\1\6\24\uffff";
    static final String DFA88_maxS =
        "\1\125\24\uffff";
    static final String DFA88_acceptS =
        "\1\uffff\1\2\22\uffff\1\1";
    static final String DFA88_specialS =
        "\25\uffff}>";
    static final String[] DFA88_transitionS = {
            "\1\1\21\uffff\2\1\2\uffff\2\1\3\uffff\1\1\1\uffff\3\1\4\uffff"+
            "\2\24\12\uffff\1\1\1\uffff\1\1\1\uffff\1\1\4\uffff\1\1\1\uffff"+
            "\10\1\2\uffff\13\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "()* loopback of 1265:3: (op= ( '+' | '-' ) f= multExpr )*";
        }
    }
    static final String DFA89_eotS =
        "\26\uffff";
    static final String DFA89_eofS =
        "\1\1\25\uffff";
    static final String DFA89_minS =
        "\1\6\25\uffff";
    static final String DFA89_maxS =
        "\1\125\25\uffff";
    static final String DFA89_acceptS =
        "\1\uffff\1\2\23\uffff\1\1";
    static final String DFA89_specialS =
        "\26\uffff}>";
    static final String[] DFA89_transitionS = {
            "\1\1\21\uffff\2\1\2\uffff\2\1\3\uffff\1\1\1\uffff\3\1\4\uffff"+
            "\2\1\11\uffff\1\25\1\1\1\uffff\1\1\1\uffff\1\1\2\uffff\2\25"+
            "\1\1\1\uffff\10\1\2\uffff\13\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "()* loopback of 1273:3: (op= ( '%' | '*' | '/' ) f= castExpr )*";
        }
    }
    static final String DFA90_eotS =
        "\17\uffff";
    static final String DFA90_eofS =
        "\1\1\16\uffff";
    static final String DFA90_minS =
        "\1\6\16\uffff";
    static final String DFA90_maxS =
        "\1\125\16\uffff";
    static final String DFA90_acceptS =
        "\1\uffff\1\2\14\uffff\1\1";
    static final String DFA90_specialS =
        "\17\uffff}>";
    static final String[] DFA90_transitionS = {
            "\1\1\21\uffff\2\1\2\uffff\2\1\3\uffff\1\1\1\uffff\1\1\24\uffff"+
            "\1\1\11\uffff\1\1\1\16\1\1\6\uffff\13\1",
            "",
            "",
            "",
            "",
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
            return "()* loopback of 1281:3: (op= '|' f= xorExpr )*";
        }
    }
    static final String DFA91_eotS =
        "\21\uffff";
    static final String DFA91_eofS =
        "\1\1\20\uffff";
    static final String DFA91_minS =
        "\1\6\20\uffff";
    static final String DFA91_maxS =
        "\1\125\20\uffff";
    static final String DFA91_acceptS =
        "\1\uffff\1\2\16\uffff\1\1";
    static final String DFA91_specialS =
        "\21\uffff}>";
    static final String[] DFA91_transitionS = {
            "\1\1\21\uffff\2\1\2\uffff\2\1\3\uffff\1\1\1\uffff\1\1\22\uffff"+
            "\1\20\1\uffff\1\1\1\uffff\1\1\7\uffff\3\1\6\uffff\13\1",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "()* loopback of 1289:3: (op= '&' f= equalExpr )*";
        }
    }
    static final String DFA92_eotS =
        "\24\uffff";
    static final String DFA92_eofS =
        "\1\1\23\uffff";
    static final String DFA92_minS =
        "\1\6\23\uffff";
    static final String DFA92_maxS =
        "\1\125\23\uffff";
    static final String DFA92_acceptS =
        "\1\uffff\1\2\21\uffff\1\1";
    static final String DFA92_specialS =
        "\24\uffff}>";
    static final String[] DFA92_transitionS = {
            "\1\1\21\uffff\2\1\2\uffff\2\1\3\uffff\1\1\1\uffff\3\1\20\uffff"+
            "\1\1\1\uffff\1\1\1\uffff\1\1\4\uffff\1\23\1\uffff\1\23\7\1\2"+
            "\uffff\13\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "()* loopback of 1298:3: (op= ( '>>' | '<<' ) f= addExpr )*";
        }
    }
    static final String DFA93_eotS =
        "\20\uffff";
    static final String DFA93_eofS =
        "\1\1\17\uffff";
    static final String DFA93_minS =
        "\1\6\17\uffff";
    static final String DFA93_maxS =
        "\1\125\17\uffff";
    static final String DFA93_acceptS =
        "\1\uffff\1\2\15\uffff\1\1";
    static final String DFA93_specialS =
        "\20\uffff}>";
    static final String[] DFA93_transitionS = {
            "\1\1\21\uffff\2\1\2\uffff\2\1\3\uffff\1\1\1\uffff\1\1\24\uffff"+
            "\1\1\1\uffff\1\17\7\uffff\3\1\6\uffff\13\1",
            "",
            "",
            "",
            "",
            "",
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
            return "()* loopback of 1306:3: (op= '^' f= bitAndExpr )*";
        }
    }
    static final String DFA94_eotS =
        "\15\uffff";
    static final String DFA94_eofS =
        "\1\1\14\uffff";
    static final String DFA94_minS =
        "\1\6\14\uffff";
    static final String DFA94_maxS =
        "\1\125\14\uffff";
    static final String DFA94_acceptS =
        "\1\uffff\1\2\12\uffff\1\1";
    static final String DFA94_specialS =
        "\15\uffff}>";
    static final String[] DFA94_transitionS = {
            "\1\1\21\uffff\2\1\2\uffff\2\1\3\uffff\1\1\1\uffff\1\1\24\uffff"+
            "\1\1\11\uffff\1\14\10\uffff\13\1",
            "",
            "",
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
            return "()* loopback of 1314:3: (op= '||' f= logAndExpr )*";
        }
    }
    static final String DFA95_eotS =
        "\16\uffff";
    static final String DFA95_eofS =
        "\1\1\15\uffff";
    static final String DFA95_minS =
        "\1\6\15\uffff";
    static final String DFA95_maxS =
        "\1\125\15\uffff";
    static final String DFA95_acceptS =
        "\1\uffff\1\2\13\uffff\1\1";
    static final String DFA95_specialS =
        "\16\uffff}>";
    static final String[] DFA95_transitionS = {
            "\1\1\21\uffff\2\1\2\uffff\2\1\3\uffff\1\1\1\uffff\1\1\24\uffff"+
            "\1\1\11\uffff\1\1\1\uffff\1\15\6\uffff\13\1",
            "",
            "",
            "",
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
            return "()* loopback of 1322:3: (op= '&&' f= bitOrExpr )*";
        }
    }
    static final String DFA96_eotS =
        "\22\uffff";
    static final String DFA96_eofS =
        "\1\1\21\uffff";
    static final String DFA96_minS =
        "\1\6\21\uffff";
    static final String DFA96_maxS =
        "\1\125\21\uffff";
    static final String DFA96_acceptS =
        "\1\uffff\1\2\17\uffff\1\1";
    static final String DFA96_specialS =
        "\22\uffff}>";
    static final String[] DFA96_transitionS = {
            "\1\1\21\uffff\2\1\2\uffff\2\1\3\uffff\1\1\1\uffff\1\1\22\uffff"+
            "\1\1\1\uffff\1\1\1\uffff\1\1\7\uffff\3\1\2\uffff\2\21\2\uffff"+
            "\13\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "()* loopback of 1330:3: (op= ( '!=' | '==' ) f= compareExpr )*";
        }
    }
    static final String DFA97_eotS =
        "\23\uffff";
    static final String DFA97_eofS =
        "\1\1\22\uffff";
    static final String DFA97_minS =
        "\1\6\22\uffff";
    static final String DFA97_maxS =
        "\1\125\22\uffff";
    static final String DFA97_acceptS =
        "\1\uffff\1\2\20\uffff\1\1";
    static final String DFA97_specialS =
        "\23\uffff}>";
    static final String[] DFA97_transitionS = {
            "\1\1\21\uffff\2\1\2\uffff\2\1\3\uffff\1\1\1\uffff\1\1\2\22\20"+
            "\uffff\1\1\1\uffff\1\1\1\uffff\1\1\7\uffff\3\1\2\22\2\1\2\uffff"+
            "\13\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "()* loopback of 1338:3: (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )*";
        }
    }
    static final String DFA98_eotS =
        "\73\uffff";
    static final String DFA98_eofS =
        "\73\uffff";
    static final String DFA98_minS =
        "\2\4\16\uffff\1\5\20\uffff\2\0\4\uffff\1\0\2\uffff\1\0\1\uffff\1"+
        "\0\7\uffff\1\0\6\uffff";
    static final String DFA98_maxS =
        "\2\131\16\uffff\1\133\20\uffff\2\0\4\uffff\1\0\2\uffff\1\0\1\uffff"+
        "\1\0\7\uffff\1\0\6\uffff";
    static final String DFA98_acceptS =
        "\2\uffff\1\2\32\uffff\1\1\35\uffff";
    static final String DFA98_specialS =
        "\41\uffff\1\0\1\1\4\uffff\1\2\2\uffff\1\3\1\uffff\1\4\7\uffff\1"+
        "\5\6\uffff}>";
    static final String[] DFA98_transitionS = {
            "\7\2\24\uffff\1\2\2\uffff\1\1\10\uffff\1\2\7\uffff\1\2\1\uffff"+
            "\3\2\21\uffff\2\2\13\uffff\4\2",
            "\2\2\1\20\4\2\23\uffff\1\35\1\2\2\uffff\1\2\10\uffff\1\2\4"+
            "\uffff\3\35\1\2\1\uffff\3\2\4\uffff\1\35\14\uffff\2\2\13\uffff"+
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
            "\2\35\25\uffff\2\2\1\35\3\uffff\1\41\1\64\1\52\1\2\4\uffff"+
            "\2\2\4\uffff\3\35\2\uffff\1\47\1\54\1\42\2\uffff\1\2\1\uffff"+
            "\1\35\3\2\1\uffff\10\2\2\uffff\13\2\1\uffff\2\2\1\uffff\2\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            "\1\uffff",
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
            return "1344:1: castExpr returns [Expression expr] : ( '(' tr= mutableTypeRef ')' inner= castExpr | e= unaryExpr );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA98_33 = input.LA(1);

                         
                        int index98_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred169_ObjCpp()) ) {s = 29;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index98_33);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA98_34 = input.LA(1);

                         
                        int index98_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred169_ObjCpp()) ) {s = 29;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index98_34);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA98_39 = input.LA(1);

                         
                        int index98_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred169_ObjCpp()) ) {s = 29;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index98_39);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA98_42 = input.LA(1);

                         
                        int index98_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred169_ObjCpp()) ) {s = 29;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index98_42);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA98_44 = input.LA(1);

                         
                        int index98_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred169_ObjCpp()) ) {s = 29;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index98_44);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA98_52 = input.LA(1);

                         
                        int index98_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred169_ObjCpp()) ) {s = 29;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index98_52);
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
    static final String DFA100_eotS =
        "\17\uffff";
    static final String DFA100_eofS =
        "\17\uffff";
    static final String DFA100_minS =
        "\1\4\16\uffff";
    static final String DFA100_maxS =
        "\1\131\16\uffff";
    static final String DFA100_acceptS =
        "\1\uffff\1\1\13\uffff\1\2\1\3";
    static final String DFA100_specialS =
        "\17\uffff}>";
    static final String[] DFA100_transitionS = {
            "\7\1\24\uffff\1\1\2\uffff\1\1\10\uffff\1\15\7\uffff\1\15\1\uffff"+
            "\2\15\1\1\21\uffff\2\1\13\uffff\1\16\3\15",
            "",
            "",
            "",
            "",
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
            return "1349:1: unaryExpr returns [Expression expr] : (p= postfixExpr | unaryOp castExpr | 'sizeof' ( '(' tr= mutableTypeRef ')' | unaryExpr ) );";
        }
    }
    static final String DFA99_eotS =
        "\73\uffff";
    static final String DFA99_eofS =
        "\73\uffff";
    static final String DFA99_minS =
        "\2\4\16\uffff\1\5\20\uffff\5\0\10\uffff\1\0\14\uffff";
    static final String DFA99_maxS =
        "\2\131\16\uffff\1\133\20\uffff\5\0\10\uffff\1\0\14\uffff";
    static final String DFA99_acceptS =
        "\2\uffff\1\2\32\uffff\1\1\35\uffff";
    static final String DFA99_specialS =
        "\41\uffff\1\0\1\1\1\2\1\3\1\4\10\uffff\1\5\14\uffff}>";
    static final String[] DFA99_transitionS = {
            "\7\2\24\uffff\1\2\2\uffff\1\1\10\uffff\1\2\7\uffff\1\2\1\uffff"+
            "\3\2\21\uffff\2\2\13\uffff\4\2",
            "\2\2\1\20\4\2\23\uffff\1\35\1\2\2\uffff\1\2\10\uffff\1\2\4"+
            "\uffff\3\35\1\2\1\uffff\3\2\4\uffff\1\35\14\uffff\2\2\13\uffff"+
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
            "\2\35\25\uffff\2\2\1\35\3\uffff\1\41\1\45\1\42\1\2\4\uffff"+
            "\2\2\4\uffff\3\35\2\uffff\1\43\1\56\1\44\2\uffff\1\2\1\uffff"+
            "\1\35\3\2\1\uffff\10\2\2\uffff\13\2\1\uffff\2\2\1\uffff\2\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "1353:12: ( '(' tr= mutableTypeRef ')' | unaryExpr )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA99_33 = input.LA(1);

                         
                        int index99_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred172_ObjCpp()) ) {s = 29;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index99_33);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA99_34 = input.LA(1);

                         
                        int index99_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred172_ObjCpp()) ) {s = 29;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index99_34);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA99_35 = input.LA(1);

                         
                        int index99_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred172_ObjCpp()) ) {s = 29;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index99_35);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA99_36 = input.LA(1);

                         
                        int index99_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred172_ObjCpp()) ) {s = 29;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index99_36);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA99_37 = input.LA(1);

                         
                        int index99_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred172_ObjCpp()) ) {s = 29;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index99_37);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA99_46 = input.LA(1);

                         
                        int index99_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred172_ObjCpp()) ) {s = 29;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index99_46);
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
    static final String DFA102_eotS =
        "\34\uffff";
    static final String DFA102_eofS =
        "\1\1\33\uffff";
    static final String DFA102_minS =
        "\1\6\33\uffff";
    static final String DFA102_maxS =
        "\1\133\33\uffff";
    static final String DFA102_acceptS =
        "\1\uffff\1\7\24\uffff\1\1\1\2\1\3\1\4\1\5\1\6";
    static final String DFA102_specialS =
        "\34\uffff}>";
    static final String[] DFA102_transitionS = {
            "\1\1\21\uffff\2\1\2\uffff\2\1\3\uffff\1\1\1\27\3\1\4\uffff\2"+
            "\1\11\uffff\2\1\1\26\1\1\1\uffff\1\1\2\uffff\3\1\1\uffff\10"+
            "\1\2\uffff\13\1\1\uffff\1\32\1\33\1\uffff\1\30\1\31",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "()* loopback of 1364:3: ( '[' expression ']' | '(' ( topLevelExprList )? ')' | '.' di= IDENTIFIER | '->' ai= IDENTIFIER | '++' | '--' )*";
        }
    }
    static final String DFA101_eotS =
        "\20\uffff";
    static final String DFA101_eofS =
        "\20\uffff";
    static final String DFA101_minS =
        "\1\4\17\uffff";
    static final String DFA101_maxS =
        "\1\131\17\uffff";
    static final String DFA101_acceptS =
        "\1\uffff\1\1\15\uffff\1\2";
    static final String DFA101_specialS =
        "\20\uffff}>";
    static final String[] DFA101_transitionS = {
            "\7\1\24\uffff\1\1\2\uffff\1\1\1\17\7\uffff\1\1\7\uffff\1\1\1"+
            "\uffff\3\1\21\uffff\2\1\13\uffff\4\1",
            "",
            "",
            "",
            "",
            "",
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
            return "1368:8: ( topLevelExprList )?";
        }
    }
    static final String DFA103_eotS =
        "\u011a\uffff";
    static final String DFA103_eofS =
        "\1\1\1\uffff\1\1\u0117\uffff";
    static final String DFA103_minS =
        "\1\6\1\uffff\1\4\7\uffff\1\0\3\uffff\1\4\6\0\1\4\3\42\2\4\45\uffff"+
        "\21\0\u009c\uffff\55\0";
    static final String DFA103_maxS =
        "\1\70\1\uffff\1\131\7\uffff\1\0\3\uffff\1\131\6\0\1\131\3\42\2\131"+
        "\45\uffff\21\0\u009c\uffff\55\0";
    static final String DFA103_acceptS =
        "\1\uffff\1\2\75\uffff\1\1\u00da\uffff";
    static final String DFA103_specialS =
        "\12\uffff\1\0\4\uffff\1\1\1\2\1\3\1\4\1\5\1\6\53\uffff\1\7\1\10"+
        "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
        "\1\26\1\27\u009c\uffff\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1"+
        "\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54"+
        "\1\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1\71"+
        "\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1\104}>";
    static final String[] DFA103_transitionS = {
            "\1\1\21\uffff\2\1\2\uffff\1\2\4\uffff\1\1\1\uffff\1\1\24\uffff"+
            "\1\1",
            "",
            "\1\17\1\24\1\12\1\20\1\21\1\22\1\23\15\uffff\1\1\3\uffff\1"+
            "\1\1\uffff\1\1\1\27\2\uffff\1\16\10\uffff\1\31\1\1\3\uffff\3"+
            "\1\1\31\1\uffff\2\31\1\25\4\uffff\1\1\14\uffff\1\26\1\30\13"+
            "\uffff\1\32\3\31",
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
            "\1\105\1\112\1\100\1\106\1\107\1\110\1\111\23\uffff\1\103\1"+
            "\115\2\uffff\1\104\10\uffff\1\117\4\uffff\3\102\1\117\1\uffff"+
            "\2\117\1\113\4\uffff\1\101\14\uffff\1\114\1\116\13\uffff\1\120"+
            "\3\117",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\u00ef\1\u00f4\1\u00ee\1\u00f0\1\u00f1\1\u00f2\1\u00f3\24"+
            "\uffff\1\u00f7\2\uffff\1\u00ed\10\uffff\1\u00f9\7\uffff\1\u00f9"+
            "\1\uffff\2\u00f9\1\u00f5\21\uffff\1\u00f6\1\u00f8\13\uffff\1"+
            "\u00fa\3\u00f9",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u0100\1\u0105\1\u00ff\1\u0101\1\u0102\1\u0103\1\u0104\24"+
            "\uffff\1\u0108\2\uffff\1\u00fe\10\uffff\1\u010a\7\uffff\1\u010a"+
            "\1\uffff\2\u010a\1\u0106\21\uffff\1\u0107\1\u0109\13\uffff\1"+
            "\u010b\3\u010a",
            "\1\u010e\1\u0113\1\u010d\1\u010f\1\u0110\1\u0111\1\u0112\24"+
            "\uffff\1\u0116\2\uffff\1\u010c\10\uffff\1\u0118\7\uffff\1\u0118"+
            "\1\uffff\2\u0118\1\u0114\21\uffff\1\u0115\1\u0117\13\uffff\1"+
            "\u0119\3\u0118",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff"
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
            return "()* loopback of 1397:3: ( ',' f= topLevelExpr )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA103_10 = input.LA(1);

                         
                        int index103_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_10);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA103_15 = input.LA(1);

                         
                        int index103_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_15);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA103_16 = input.LA(1);

                         
                        int index103_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_16);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA103_17 = input.LA(1);

                         
                        int index103_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_17);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA103_18 = input.LA(1);

                         
                        int index103_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_18);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA103_19 = input.LA(1);

                         
                        int index103_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_19);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA103_20 = input.LA(1);

                         
                        int index103_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_20);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA103_64 = input.LA(1);

                         
                        int index103_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_64);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA103_65 = input.LA(1);

                         
                        int index103_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_65);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA103_66 = input.LA(1);

                         
                        int index103_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_66);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA103_67 = input.LA(1);

                         
                        int index103_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_67);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA103_68 = input.LA(1);

                         
                        int index103_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_68);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA103_69 = input.LA(1);

                         
                        int index103_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_69);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA103_70 = input.LA(1);

                         
                        int index103_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_70);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA103_71 = input.LA(1);

                         
                        int index103_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_71);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA103_72 = input.LA(1);

                         
                        int index103_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_72);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA103_73 = input.LA(1);

                         
                        int index103_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_73);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA103_74 = input.LA(1);

                         
                        int index103_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_74);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA103_75 = input.LA(1);

                         
                        int index103_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_75);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA103_76 = input.LA(1);

                         
                        int index103_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_76);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA103_77 = input.LA(1);

                         
                        int index103_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_77);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA103_78 = input.LA(1);

                         
                        int index103_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_78);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA103_79 = input.LA(1);

                         
                        int index103_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_79);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA103_80 = input.LA(1);

                         
                        int index103_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_80);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA103_237 = input.LA(1);

                         
                        int index103_237 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_237);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA103_238 = input.LA(1);

                         
                        int index103_238 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_238);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA103_239 = input.LA(1);

                         
                        int index103_239 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_239);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA103_240 = input.LA(1);

                         
                        int index103_240 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_240);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA103_241 = input.LA(1);

                         
                        int index103_241 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_241);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA103_242 = input.LA(1);

                         
                        int index103_242 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_242);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA103_243 = input.LA(1);

                         
                        int index103_243 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_243);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA103_244 = input.LA(1);

                         
                        int index103_244 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_244);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA103_245 = input.LA(1);

                         
                        int index103_245 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_245);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA103_246 = input.LA(1);

                         
                        int index103_246 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_246);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA103_247 = input.LA(1);

                         
                        int index103_247 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_247);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA103_248 = input.LA(1);

                         
                        int index103_248 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_248);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA103_249 = input.LA(1);

                         
                        int index103_249 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_249);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA103_250 = input.LA(1);

                         
                        int index103_250 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_250);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA103_251 = input.LA(1);

                         
                        int index103_251 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_251);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA103_252 = input.LA(1);

                         
                        int index103_252 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_252);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA103_253 = input.LA(1);

                         
                        int index103_253 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_253);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA103_254 = input.LA(1);

                         
                        int index103_254 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_254);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA103_255 = input.LA(1);

                         
                        int index103_255 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_255);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA103_256 = input.LA(1);

                         
                        int index103_256 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_256);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA103_257 = input.LA(1);

                         
                        int index103_257 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_257);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA103_258 = input.LA(1);

                         
                        int index103_258 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_258);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA103_259 = input.LA(1);

                         
                        int index103_259 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_259);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA103_260 = input.LA(1);

                         
                        int index103_260 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_260);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA103_261 = input.LA(1);

                         
                        int index103_261 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_261);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA103_262 = input.LA(1);

                         
                        int index103_262 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_262);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA103_263 = input.LA(1);

                         
                        int index103_263 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_263);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA103_264 = input.LA(1);

                         
                        int index103_264 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_264);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA103_265 = input.LA(1);

                         
                        int index103_265 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_265);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA103_266 = input.LA(1);

                         
                        int index103_266 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_266);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA103_267 = input.LA(1);

                         
                        int index103_267 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_267);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA103_268 = input.LA(1);

                         
                        int index103_268 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_268);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA103_269 = input.LA(1);

                         
                        int index103_269 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_269);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA103_270 = input.LA(1);

                         
                        int index103_270 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_270);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA103_271 = input.LA(1);

                         
                        int index103_271 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_271);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA103_272 = input.LA(1);

                         
                        int index103_272 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_272);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA103_273 = input.LA(1);

                         
                        int index103_273 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_273);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA103_274 = input.LA(1);

                         
                        int index103_274 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_274);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA103_275 = input.LA(1);

                         
                        int index103_275 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_275);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA103_276 = input.LA(1);

                         
                        int index103_276 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_276);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA103_277 = input.LA(1);

                         
                        int index103_277 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_277);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA103_278 = input.LA(1);

                         
                        int index103_278 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_278);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA103_279 = input.LA(1);

                         
                        int index103_279 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_279);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA103_280 = input.LA(1);

                         
                        int index103_280 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_280);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA103_281 = input.LA(1);

                         
                        int index103_281 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred186_ObjCpp()) ) {s = 63;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index103_281);
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
    static final String DFA104_eotS =
        "\40\uffff";
    static final String DFA104_eofS =
        "\40\uffff";
    static final String DFA104_minS =
        "\1\4\37\uffff";
    static final String DFA104_maxS =
        "\1\141\37\uffff";
    static final String DFA104_acceptS =
        "\1\uffff\1\2\1\1\35\uffff";
    static final String DFA104_specialS =
        "\40\uffff}>";
    static final String[] DFA104_transitionS = {
            "\7\2\14\uffff\1\2\1\1\3\2\2\uffff\3\2\1\uffff\1\2\10\uffff\1"+
            "\2\4\uffff\10\2\3\uffff\2\2\14\uffff\2\2\13\uffff\4\2\2\uffff"+
            "\1\2\1\uffff\4\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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

    static final short[] DFA104_eot = DFA.unpackEncodedString(DFA104_eotS);
    static final short[] DFA104_eof = DFA.unpackEncodedString(DFA104_eofS);
    static final char[] DFA104_min = DFA.unpackEncodedStringToUnsignedChars(DFA104_minS);
    static final char[] DFA104_max = DFA.unpackEncodedStringToUnsignedChars(DFA104_maxS);
    static final short[] DFA104_accept = DFA.unpackEncodedString(DFA104_acceptS);
    static final short[] DFA104_special = DFA.unpackEncodedString(DFA104_specialS);
    static final short[][] DFA104_transition;

    static {
        int numStates = DFA104_transitionS.length;
        DFA104_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA104_transition[i] = DFA.unpackEncodedString(DFA104_transitionS[i]);
        }
    }

    class DFA104 extends DFA {

        public DFA104(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 104;
            this.eot = DFA104_eot;
            this.eof = DFA104_eof;
            this.min = DFA104_min;
            this.max = DFA104_max;
            this.accept = DFA104_accept;
            this.special = DFA104_special;
            this.transition = DFA104_transition;
        }
        public String getDescription() {
            return "()* loopback of 1422:3: ( statement )*";
        }
    }
    static final String DFA110_eotS =
        "\u01a8\uffff";
    static final String DFA110_eofS =
        "\u01a8\uffff";
    static final String DFA110_minS =
        "\1\4\1\uffff\1\5\3\uffff\1\4\1\6\30\uffff\2\4\2\uffff\2\31\12\4"+
        "\1\uffff\1\4\1\uffff\1\0\2\4\6\uffff\1\4\1\uffff\1\31\20\uffff\6"+
        "\0\1\uffff\16\0\37\uffff\1\0\23\uffff\1\0\4\uffff\5\0\14\uffff\1"+
        "\0\15\uffff\1\0\15\uffff\1\0\4\uffff\1\0\14\uffff\1\0\15\uffff\2"+
        "\0\6\uffff\1\0\3\uffff\1\0\1\uffff\1\0\2\uffff\2\0\12\uffff\1\0"+
        "\3\uffff\1\0\15\uffff\1\0\15\uffff\1\0\15\uffff\1\0\60\uffff\1\0"+
        "\15\uffff\1\0\15\uffff\1\0\15\uffff\5\0\3\uffff\1\0\1\uffff\12\0"+
        "\5\uffff";
    static final String DFA110_maxS =
        "\1\141\1\uffff\1\133\3\uffff\1\131\1\42\30\uffff\2\131\2\uffff\2"+
        "\133\12\131\1\uffff\1\131\1\uffff\1\0\2\131\6\uffff\1\131\1\uffff"+
        "\1\133\20\uffff\6\0\1\uffff\16\0\37\uffff\1\0\23\uffff\1\0\4\uffff"+
        "\5\0\14\uffff\1\0\15\uffff\1\0\15\uffff\1\0\4\uffff\1\0\14\uffff"+
        "\1\0\15\uffff\2\0\6\uffff\1\0\3\uffff\1\0\1\uffff\1\0\2\uffff\2"+
        "\0\12\uffff\1\0\3\uffff\1\0\15\uffff\1\0\15\uffff\1\0\15\uffff\1"+
        "\0\60\uffff\1\0\15\uffff\1\0\15\uffff\1\0\15\uffff\5\0\3\uffff\1"+
        "\0\1\uffff\12\0\5\uffff";
    static final String DFA110_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\7\uffff\1\3\14\uffff\1\4\1\5\1\6\1\7\1"+
        "\10\1\11\1\12\u0188\uffff\1\13";
    static final String DFA110_specialS =
        "\63\uffff\1\0\33\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\7\1\10"+
        "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\37"+
        "\uffff\1\25\23\uffff\1\26\4\uffff\1\27\1\30\1\31\1\32\1\33\14\uffff"+
        "\1\34\15\uffff\1\35\15\uffff\1\36\4\uffff\1\37\14\uffff\1\40\15"+
        "\uffff\1\41\1\42\6\uffff\1\43\3\uffff\1\44\1\uffff\1\45\2\uffff"+
        "\1\46\1\47\12\uffff\1\50\3\uffff\1\51\15\uffff\1\52\15\uffff\1\53"+
        "\15\uffff\1\54\60\uffff\1\55\15\uffff\1\56\15\uffff\1\57\15\uffff"+
        "\1\60\1\61\1\62\1\63\1\64\3\uffff\1\65\1\uffff\1\66\1\67\1\70\1"+
        "\71\1\72\1\73\1\74\1\75\1\76\1\77\5\uffff}>";
    static final String[] DFA110_transitionS = {
            "\2\13\1\2\4\13\14\uffff\1\1\1\uffff\1\36\2\3\2\uffff\1\3\1\7"+
            "\1\3\1\uffff\1\13\10\uffff\1\13\4\uffff\3\3\1\6\1\30\3\13\3"+
            "\uffff\2\3\14\uffff\2\13\13\uffff\4\13\2\uffff\1\31\1\uffff"+
            "\1\32\1\33\1\34\1\35",
            "",
            "\2\3\22\uffff\1\63\2\uffff\1\13\1\61\1\3\3\uffff\1\40\1\uffff"+
            "\1\51\1\64\4\uffff\1\74\1\47\4\uffff\4\3\1\uffff\1\46\1\53\1"+
            "\41\2\uffff\1\54\1\uffff\1\3\2\65\1\50\1\3\1\50\1\57\1\55\1"+
            "\56\2\64\2\52\2\uffff\12\61\1\13\1\uffff\1\44\1\45\1\3\2\13",
            "",
            "",
            "",
            "\2\13\1\76\4\13\24\uffff\1\13\2\uffff\1\13\10\uffff\1\13\7"+
            "\uffff\1\13\1\uffff\3\13\21\uffff\2\13\13\uffff\4\13",
            "\1\3\33\uffff\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\127\1\117\1\121\1\130\1\131\1\132\1\133\23\uffff\1\124\1"+
            "\136\2\uffff\1\126\1\120\7\uffff\1\143\1\3\3\uffff\3\123\1\143"+
            "\1\3\1\140\1\142\1\134\2\uffff\1\3\1\uffff\1\122\14\uffff\1"+
            "\135\1\137\13\uffff\1\141\3\143",
            "\7\13\24\uffff\1\13\2\uffff\1\13\10\uffff\1\13\7\uffff\1\13"+
            "\1\uffff\3\13\1\3\20\uffff\2\13\13\uffff\4\13",
            "",
            "",
            "\1\13\2\uffff\2\13\4\uffff\1\u0083\1\uffff\2\13\4\uffff\2\13"+
            "\11\uffff\3\13\2\uffff\1\13\2\uffff\3\13\1\uffff\10\13\2\uffff"+
            "\13\13\1\uffff\2\13\1\uffff\2\13",
            "\1\13\2\uffff\2\13\4\uffff\1\u0097\1\uffff\2\13\4\uffff\2\13"+
            "\11\uffff\3\13\2\uffff\1\13\2\uffff\3\13\1\uffff\10\13\2\uffff"+
            "\13\13\1\uffff\2\13\1\uffff\2\13",
            "\2\13\1\u009d\4\13\24\uffff\1\13\2\uffff\1\u009c\10\uffff\1"+
            "\13\7\uffff\1\u009e\1\uffff\2\u009f\1\u00a0\2\uffff\1\3\16\uffff"+
            "\2\13\13\uffff\4\13",
            "\7\13\24\uffff\1\13\2\uffff\1\u00ad\10\uffff\1\13\7\uffff\1"+
            "\13\1\uffff\3\13\21\uffff\2\13\13\uffff\4\13",
            "\7\13\24\uffff\1\13\2\uffff\1\u00bb\10\uffff\1\13\7\uffff\1"+
            "\13\1\uffff\3\13\21\uffff\2\13\13\uffff\4\13",
            "\2\13\1\u00c9\4\13\23\uffff\1\3\1\13\2\uffff\1\u00ce\2\uffff"+
            "\1\3\5\uffff\1\13\4\uffff\3\3\1\13\1\uffff\3\13\4\uffff\1\3"+
            "\14\uffff\2\13\13\uffff\4\13",
            "\7\13\24\uffff\1\13\2\uffff\1\u00db\10\uffff\1\13\7\uffff\1"+
            "\13\1\uffff\3\13\21\uffff\2\13\13\uffff\4\13",
            "\2\13\1\u00ea\4\13\24\uffff\1\13\2\uffff\1\u00e9\10\uffff\1"+
            "\13\7\uffff\1\u00f5\1\uffff\2\u00f7\1\u00f1\2\uffff\1\3\16\uffff"+
            "\2\13\13\uffff\4\13",
            "\2\13\1\u00fb\4\13\24\uffff\1\13\2\uffff\1\u00fa\10\uffff\1"+
            "\13\7\uffff\1\13\1\uffff\2\u0106\1\13\2\uffff\1\3\16\uffff\2"+
            "\13\13\uffff\4\13",
            "\7\13\24\uffff\1\13\2\uffff\1\u010a\10\uffff\1\13\7\uffff\1"+
            "\13\1\uffff\3\13\21\uffff\2\13\13\uffff\4\13",
            "\7\13\24\uffff\1\13\2\uffff\1\u0118\10\uffff\1\13\7\uffff\1"+
            "\13\1\uffff\3\13\21\uffff\2\13\13\uffff\4\13",
            "\7\13\24\uffff\1\13\2\uffff\1\u0126\10\uffff\1\13\7\uffff\1"+
            "\13\1\uffff\3\13\21\uffff\2\13\13\uffff\4\13",
            "",
            "\7\13\24\uffff\1\13\2\uffff\1\u0134\10\uffff\1\13\7\uffff\1"+
            "\13\1\uffff\3\13\21\uffff\2\13\13\uffff\4\13",
            "",
            "\1\uffff",
            "\7\13\24\uffff\1\13\2\uffff\1\u0165\10\uffff\1\13\7\uffff\1"+
            "\13\1\uffff\3\13\21\uffff\2\13\13\uffff\4\13",
            "\7\13\24\uffff\1\13\2\uffff\1\u0173\10\uffff\1\13\7\uffff\1"+
            "\13\1\uffff\3\13\21\uffff\2\13\13\uffff\4\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "\7\13\24\uffff\1\13\2\uffff\1\u0181\10\uffff\1\13\7\uffff\1"+
            "\13\1\uffff\3\13\21\uffff\2\13\13\uffff\4\13",
            "",
            "\1\13\2\uffff\1\13\1\u0192\4\uffff\1\u0193\1\uffff\2\u019d"+
            "\4\uffff\1\u019a\1\u0199\7\uffff\1\3\1\uffff\1\u018f\1\u019b"+
            "\1\13\2\uffff\1\u019f\2\uffff\2\u0190\1\u019c\1\3\1\u019c\1"+
            "\u01a2\1\u01a0\1\u01a1\2\u019d\2\u019e\2\uffff\12\u0192\1\13"+
            "\1\uffff\1\u0191\1\u0197\1\3\2\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            "\1\uffff",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA110_eot = DFA.unpackEncodedString(DFA110_eotS);
    static final short[] DFA110_eof = DFA.unpackEncodedString(DFA110_eofS);
    static final char[] DFA110_min = DFA.unpackEncodedStringToUnsignedChars(DFA110_minS);
    static final char[] DFA110_max = DFA.unpackEncodedStringToUnsignedChars(DFA110_maxS);
    static final short[] DFA110_accept = DFA.unpackEncodedString(DFA110_acceptS);
    static final short[] DFA110_special = DFA.unpackEncodedString(DFA110_specialS);
    static final short[][] DFA110_transition;

    static {
        int numStates = DFA110_transitionS.length;
        DFA110_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA110_transition[i] = DFA.unpackEncodedString(DFA110_transitionS[i]);
        }
    }

    class DFA110 extends DFA {

        public DFA110(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 110;
            this.eot = DFA110_eot;
            this.eof = DFA110_eof;
            this.min = DFA110_min;
            this.max = DFA110_max;
            this.accept = DFA110_accept;
            this.special = DFA110_special;
            this.transition = DFA110_transition;
        }
        public String getDescription() {
            return "1429:1: statement returns [Statement stat] : (b= statementsBlock | declaration | es= expression ';' | rt= 'return' rex= expression ';' | 'if' '(' expression ')' statement ( 'else' statement )? | 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' ( statement )? ';' ( expression )? ';' ( statement )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' expression ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA110_51 = input.LA(1);

                         
                        int index110_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_51);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA110_79 = input.LA(1);

                         
                        int index110_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_79);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA110_80 = input.LA(1);

                         
                        int index110_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_80);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA110_81 = input.LA(1);

                         
                        int index110_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                        else if ( (( next("foreach") )) ) {s = 423;}

                         
                        input.seek(index110_81);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA110_82 = input.LA(1);

                         
                        int index110_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (( next("foreach") )) ) {s = 423;}

                         
                        input.seek(index110_82);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA110_83 = input.LA(1);

                         
                        int index110_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (( next("foreach") )) ) {s = 423;}

                         
                        input.seek(index110_83);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA110_84 = input.LA(1);

                         
                        int index110_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (( next("foreach") )) ) {s = 423;}

                         
                        input.seek(index110_84);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA110_86 = input.LA(1);

                         
                        int index110_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_86);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA110_87 = input.LA(1);

                         
                        int index110_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_87);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA110_88 = input.LA(1);

                         
                        int index110_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_88);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA110_89 = input.LA(1);

                         
                        int index110_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_89);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA110_90 = input.LA(1);

                         
                        int index110_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_90);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA110_91 = input.LA(1);

                         
                        int index110_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_91);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA110_92 = input.LA(1);

                         
                        int index110_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_92);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA110_93 = input.LA(1);

                         
                        int index110_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_93);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA110_94 = input.LA(1);

                         
                        int index110_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_94);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA110_95 = input.LA(1);

                         
                        int index110_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_95);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA110_96 = input.LA(1);

                         
                        int index110_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_96);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA110_97 = input.LA(1);

                         
                        int index110_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_97);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA110_98 = input.LA(1);

                         
                        int index110_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_98);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA110_99 = input.LA(1);

                         
                        int index110_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_99);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA110_131 = input.LA(1);

                         
                        int index110_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_131);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA110_151 = input.LA(1);

                         
                        int index110_151 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_151);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA110_156 = input.LA(1);

                         
                        int index110_156 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_156);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA110_157 = input.LA(1);

                         
                        int index110_157 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_157);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA110_158 = input.LA(1);

                         
                        int index110_158 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_158);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA110_159 = input.LA(1);

                         
                        int index110_159 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_159);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA110_160 = input.LA(1);

                         
                        int index110_160 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_160);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA110_173 = input.LA(1);

                         
                        int index110_173 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_173);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA110_187 = input.LA(1);

                         
                        int index110_187 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_187);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA110_201 = input.LA(1);

                         
                        int index110_201 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_201);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA110_206 = input.LA(1);

                         
                        int index110_206 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_206);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA110_219 = input.LA(1);

                         
                        int index110_219 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_219);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA110_233 = input.LA(1);

                         
                        int index110_233 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_233);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA110_234 = input.LA(1);

                         
                        int index110_234 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_234);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA110_241 = input.LA(1);

                         
                        int index110_241 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_241);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA110_245 = input.LA(1);

                         
                        int index110_245 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_245);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA110_247 = input.LA(1);

                         
                        int index110_247 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_247);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA110_250 = input.LA(1);

                         
                        int index110_250 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_250);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA110_251 = input.LA(1);

                         
                        int index110_251 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_251);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA110_262 = input.LA(1);

                         
                        int index110_262 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_262);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA110_266 = input.LA(1);

                         
                        int index110_266 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_266);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA110_280 = input.LA(1);

                         
                        int index110_280 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_280);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA110_294 = input.LA(1);

                         
                        int index110_294 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_294);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA110_308 = input.LA(1);

                         
                        int index110_308 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_308);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA110_357 = input.LA(1);

                         
                        int index110_357 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_357);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA110_371 = input.LA(1);

                         
                        int index110_371 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_371);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA110_385 = input.LA(1);

                         
                        int index110_385 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_385);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA110_399 = input.LA(1);

                         
                        int index110_399 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_399);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA110_400 = input.LA(1);

                         
                        int index110_400 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_400);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA110_401 = input.LA(1);

                         
                        int index110_401 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_401);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA110_402 = input.LA(1);

                         
                        int index110_402 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_402);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA110_403 = input.LA(1);

                         
                        int index110_403 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_403);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA110_407 = input.LA(1);

                         
                        int index110_407 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_407);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA110_409 = input.LA(1);

                         
                        int index110_409 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_409);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA110_410 = input.LA(1);

                         
                        int index110_410 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_410);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA110_411 = input.LA(1);

                         
                        int index110_411 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_411);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA110_412 = input.LA(1);

                         
                        int index110_412 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_412);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA110_413 = input.LA(1);

                         
                        int index110_413 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_413);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA110_414 = input.LA(1);

                         
                        int index110_414 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_414);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA110_415 = input.LA(1);

                         
                        int index110_415 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_415);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA110_416 = input.LA(1);

                         
                        int index110_416 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_416);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA110_417 = input.LA(1);

                         
                        int index110_417 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_417);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA110_418 = input.LA(1);

                         
                        int index110_418 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred189_ObjCpp()) ) {s = 3;}

                        else if ( (synpred190_ObjCpp()) ) {s = 11;}

                         
                        input.seek(index110_418);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 110, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA105_eotS =
        "\103\uffff";
    static final String DFA105_eofS =
        "\1\2\102\uffff";
    static final String DFA105_minS =
        "\1\4\1\0\101\uffff";
    static final String DFA105_maxS =
        "\1\142\1\0\101\uffff";
    static final String DFA105_acceptS =
        "\2\uffff\1\2\77\uffff\1\1";
    static final String DFA105_specialS =
        "\1\uffff\1\0\101\uffff}>";
    static final String[] DFA105_transitionS = {
            "\7\2\14\uffff\5\2\2\uffff\3\2\1\uffff\2\2\7\uffff\1\2\4\uffff"+
            "\10\2\3\uffff\2\2\14\uffff\2\2\13\uffff\4\2\2\uffff\1\2\1\1"+
            "\5\2",
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
            ""
    };

    static final short[] DFA105_eot = DFA.unpackEncodedString(DFA105_eotS);
    static final short[] DFA105_eof = DFA.unpackEncodedString(DFA105_eofS);
    static final char[] DFA105_min = DFA.unpackEncodedStringToUnsignedChars(DFA105_minS);
    static final char[] DFA105_max = DFA.unpackEncodedStringToUnsignedChars(DFA105_maxS);
    static final short[] DFA105_accept = DFA.unpackEncodedString(DFA105_acceptS);
    static final short[] DFA105_special = DFA.unpackEncodedString(DFA105_specialS);
    static final short[][] DFA105_transition;

    static {
        int numStates = DFA105_transitionS.length;
        DFA105_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA105_transition[i] = DFA.unpackEncodedString(DFA105_transitionS[i]);
        }
    }

    class DFA105 extends DFA {

        public DFA105(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 105;
            this.eot = DFA105_eot;
            this.eof = DFA105_eof;
            this.min = DFA105_min;
            this.max = DFA105_max;
            this.accept = DFA105_accept;
            this.special = DFA105_special;
            this.transition = DFA105_transition;
        }
        public String getDescription() {
            return "1437:37: ( 'else' statement )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA105_1 = input.LA(1);

                         
                        int index105_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred192_ObjCpp()) ) {s = 66;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index105_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 105, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA106_eotS =
        "\115\uffff";
    static final String DFA106_eofS =
        "\115\uffff";
    static final String DFA106_minS =
        "\1\4\35\uffff\1\4\16\uffff\1\4\17\0\4\uffff\1\0\13\uffff";
    static final String DFA106_maxS =
        "\1\141\35\uffff\1\131\16\uffff\1\141\17\0\4\uffff\1\0\13\uffff";
    static final String DFA106_acceptS =
        "\1\uffff\1\1\35\uffff\1\2\55\uffff";
    static final String DFA106_specialS =
        "\56\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\4\uffff\1\17\13\uffff}>";
    static final String[] DFA106_transitionS = {
            "\7\1\14\uffff\1\1\1\uffff\1\36\2\1\2\uffff\3\1\1\uffff\1\1\10"+
            "\uffff\1\1\4\uffff\10\1\3\uffff\2\1\14\uffff\2\1\13\uffff\4"+
            "\1\2\uffff\1\1\1\uffff\4\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\7\37\16\uffff\1\55\5\uffff\1\37\2\uffff\1\37\10\uffff\1\37"+
            "\7\uffff\1\37\1\uffff\3\37\21\uffff\2\37\13\uffff\4\37",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\60\1\65\1\57\1\61\1\62\1\63\1\64\14\uffff\1\37\1\uffff\1"+
            "\74\2\37\2\uffff\1\37\1\70\1\37\1\uffff\1\56\1\37\7\uffff\1"+
            "\101\4\uffff\3\37\1\72\1\37\2\101\1\66\3\uffff\2\37\14\uffff"+
            "\1\67\1\71\13\uffff\1\73\3\101\2\uffff\1\37\1\uffff\4\37",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            "",
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

    static final short[] DFA106_eot = DFA.unpackEncodedString(DFA106_eotS);
    static final short[] DFA106_eof = DFA.unpackEncodedString(DFA106_eofS);
    static final char[] DFA106_min = DFA.unpackEncodedStringToUnsignedChars(DFA106_minS);
    static final char[] DFA106_max = DFA.unpackEncodedStringToUnsignedChars(DFA106_maxS);
    static final short[] DFA106_accept = DFA.unpackEncodedString(DFA106_acceptS);
    static final short[] DFA106_special = DFA.unpackEncodedString(DFA106_specialS);
    static final short[][] DFA106_transition;

    static {
        int numStates = DFA106_transitionS.length;
        DFA106_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA106_transition[i] = DFA.unpackEncodedString(DFA106_transitionS[i]);
        }
    }

    class DFA106 extends DFA {

        public DFA106(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 106;
            this.eot = DFA106_eot;
            this.eof = DFA106_eof;
            this.min = DFA106_min;
            this.max = DFA106_max;
            this.accept = DFA106_accept;
            this.special = DFA106_special;
            this.transition = DFA106_transition;
        }
        public String getDescription() {
            return "1440:13: ( statement )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA106_46 = input.LA(1);

                         
                        int index106_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred196_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index106_46);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA106_47 = input.LA(1);

                         
                        int index106_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred196_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index106_47);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA106_48 = input.LA(1);

                         
                        int index106_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred196_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index106_48);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA106_49 = input.LA(1);

                         
                        int index106_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred196_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index106_49);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA106_50 = input.LA(1);

                         
                        int index106_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred196_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index106_50);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA106_51 = input.LA(1);

                         
                        int index106_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred196_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index106_51);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA106_52 = input.LA(1);

                         
                        int index106_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred196_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index106_52);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA106_53 = input.LA(1);

                         
                        int index106_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred196_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index106_53);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA106_54 = input.LA(1);

                         
                        int index106_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred196_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index106_54);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA106_55 = input.LA(1);

                         
                        int index106_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred196_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index106_55);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA106_56 = input.LA(1);

                         
                        int index106_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred196_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index106_56);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA106_57 = input.LA(1);

                         
                        int index106_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred196_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index106_57);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA106_58 = input.LA(1);

                         
                        int index106_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred196_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index106_58);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA106_59 = input.LA(1);

                         
                        int index106_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred196_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index106_59);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA106_60 = input.LA(1);

                         
                        int index106_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred196_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index106_60);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA106_65 = input.LA(1);

                         
                        int index106_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred196_ObjCpp()) ) {s = 1;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index106_65);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 106, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA107_eotS =
        "\20\uffff";
    static final String DFA107_eofS =
        "\20\uffff";
    static final String DFA107_minS =
        "\1\4\17\uffff";
    static final String DFA107_maxS =
        "\1\131\17\uffff";
    static final String DFA107_acceptS =
        "\1\uffff\1\1\15\uffff\1\2";
    static final String DFA107_specialS =
        "\20\uffff}>";
    static final String[] DFA107_transitionS = {
            "\7\1\16\uffff\1\17\5\uffff\1\1\2\uffff\1\1\10\uffff\1\1\7\uffff"+
            "\1\1\1\uffff\3\1\21\uffff\2\1\13\uffff\4\1",
            "",
            "",
            "",
            "",
            "",
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

    static final short[] DFA107_eot = DFA.unpackEncodedString(DFA107_eotS);
    static final short[] DFA107_eof = DFA.unpackEncodedString(DFA107_eofS);
    static final char[] DFA107_min = DFA.unpackEncodedStringToUnsignedChars(DFA107_minS);
    static final char[] DFA107_max = DFA.unpackEncodedStringToUnsignedChars(DFA107_maxS);
    static final short[] DFA107_accept = DFA.unpackEncodedString(DFA107_acceptS);
    static final short[] DFA107_special = DFA.unpackEncodedString(DFA107_specialS);
    static final short[][] DFA107_transition;

    static {
        int numStates = DFA107_transitionS.length;
        DFA107_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA107_transition[i] = DFA.unpackEncodedString(DFA107_transitionS[i]);
        }
    }

    class DFA107 extends DFA {

        public DFA107(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 107;
            this.eot = DFA107_eot;
            this.eof = DFA107_eof;
            this.min = DFA107_min;
            this.max = DFA107_max;
            this.accept = DFA107_accept;
            this.special = DFA107_special;
            this.transition = DFA107_transition;
        }
        public String getDescription() {
            return "1440:28: ( expression )?";
        }
    }
    static final String DFA108_eotS =
        "\40\uffff";
    static final String DFA108_eofS =
        "\40\uffff";
    static final String DFA108_minS =
        "\1\4\37\uffff";
    static final String DFA108_maxS =
        "\1\141\37\uffff";
    static final String DFA108_acceptS =
        "\1\uffff\1\1\35\uffff\1\2";
    static final String DFA108_specialS =
        "\40\uffff}>";
    static final String[] DFA108_transitionS = {
            "\7\1\14\uffff\1\1\1\uffff\3\1\2\uffff\3\1\1\uffff\1\1\1\37\7"+
            "\uffff\1\1\4\uffff\10\1\3\uffff\2\1\14\uffff\2\1\13\uffff\4"+
            "\1\2\uffff\1\1\1\uffff\4\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "1440:44: ( statement )?";
        }
    }
    static final String DFA109_eotS =
        "\41\uffff";
    static final String DFA109_eofS =
        "\41\uffff";
    static final String DFA109_minS =
        "\1\4\40\uffff";
    static final String DFA109_maxS =
        "\1\142\40\uffff";
    static final String DFA109_acceptS =
        "\1\uffff\1\3\1\1\1\2\35\uffff";
    static final String DFA109_specialS =
        "\41\uffff}>";
    static final String[] DFA109_transitionS = {
            "\7\3\14\uffff\1\3\1\1\3\3\2\uffff\3\3\1\uffff\1\3\10\uffff\1"+
            "\3\4\uffff\10\3\3\uffff\2\3\14\uffff\2\3\13\uffff\4\3\2\uffff"+
            "\1\3\1\uffff\4\3\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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

    static final short[] DFA109_eot = DFA.unpackEncodedString(DFA109_eotS);
    static final short[] DFA109_eof = DFA.unpackEncodedString(DFA109_eofS);
    static final char[] DFA109_min = DFA.unpackEncodedStringToUnsignedChars(DFA109_minS);
    static final char[] DFA109_max = DFA.unpackEncodedStringToUnsignedChars(DFA109_maxS);
    static final short[] DFA109_accept = DFA.unpackEncodedString(DFA109_acceptS);
    static final short[] DFA109_special = DFA.unpackEncodedString(DFA109_specialS);
    static final short[][] DFA109_transition;

    static {
        int numStates = DFA109_transitionS.length;
        DFA109_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA109_transition[i] = DFA.unpackEncodedString(DFA109_transitionS[i]);
        }
    }

    class DFA109 extends DFA {

        public DFA109(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 109;
            this.eot = DFA109_eot;
            this.eof = DFA109_eof;
            this.min = DFA109_min;
            this.max = DFA109_max;
            this.accept = DFA109_accept;
            this.special = DFA109_special;
            this.transition = DFA109_transition;
        }
        public String getDescription() {
            return "()* loopback of 1442:3: ( 'case' expression ':' | statement )*";
        }
    }
 

    public static final BitSet FOLLOW_22_in_lineDirective84 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_lineDirective88 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_STRING_in_lineDirective101 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_lineDirective116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_sourceFile156 = new BitSet(new long[]{0x180F0001CC400040L});
    public static final BitSet FOLLOW_lineDirective_in_sourceFile165 = new BitSet(new long[]{0x180F0001CC400040L});
    public static final BitSet FOLLOW_EOF_in_sourceFile178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_externDeclarations196 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_externDeclarations200 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_externDeclarations206 = new BitSet(new long[]{0x180F0001CD000040L});
    public static final BitSet FOLLOW_declaration_in_externDeclarations220 = new BitSet(new long[]{0x180F0001CD000040L});
    public static final BitSet FOLLOW_24_in_externDeclarations233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_declaration276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_externDeclarations_in_declaration286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_declaration296 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_declaration298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objCClassDef_in_declaration308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeDef_in_declaration318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forwardClassDecl_in_declaration328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_declaration338 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration342 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_declaration344 = new BitSet(new long[]{0x180F0001CD000040L});
    public static final BitSet FOLLOW_declaration_in_declaration362 = new BitSet(new long[]{0x180F0001CD000040L});
    public static final BitSet FOLLOW_24_in_declaration378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_forwardClassDecl418 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_forwardClassDecl425 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_28_in_forwardClassDecl432 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_forwardClassDecl439 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_25_in_forwardClassDecl450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_functionPointerVarDecl468 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_functionPointerVarDecl476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enumItem494 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_enumItem497 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_enumItem501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_enumBody527 = new BitSet(new long[]{0x0000000001000040L});
    public static final BitSet FOLLOW_enumItem_in_enumBody543 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_28_in_enumBody558 = new BitSet(new long[]{0x0000000011000040L});
    public static final BitSet FOLLOW_enumItem_in_enumBody569 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_24_in_enumBody590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_enumCore613 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_modifiers_in_enumCore624 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_enumBody_in_enumCore639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enumCore651 = new BitSet(new long[]{0x0000000000800042L});
    public static final BitSet FOLLOW_modifiers_in_enumCore667 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_enumBody_in_enumCore678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_objCClassDef730 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef741 = new BitSet(new long[]{0x18070E1640800040L});
    public static final BitSet FOLLOW_33_in_objCClassDef759 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef763 = new BitSet(new long[]{0x18070E1040800040L});
    public static final BitSet FOLLOW_34_in_objCClassDef778 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef782 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCClassDef784 = new BitSet(new long[]{0x18070E1040800040L});
    public static final BitSet FOLLOW_36_in_objCClassDef800 = new BitSet(new long[]{0x0000002000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef810 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_objCClassDef825 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef835 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_objCClassDef852 = new BitSet(new long[]{0x18070E0040800040L});
    public static final BitSet FOLLOW_23_in_objCClassDef866 = new BitSet(new long[]{0x100701C041000040L});
    public static final BitSet FOLLOW_38_in_objCClassDef878 = new BitSet(new long[]{0x100701C041000040L});
    public static final BitSet FOLLOW_39_in_objCClassDef889 = new BitSet(new long[]{0x100701C041000040L});
    public static final BitSet FOLLOW_40_in_objCClassDef900 = new BitSet(new long[]{0x100701C041000040L});
    public static final BitSet FOLLOW_varDecl_in_objCClassDef927 = new BitSet(new long[]{0x0000000202000000L});
    public static final BitSet FOLLOW_33_in_objCClassDef931 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_objCClassDef935 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_objCClassDef940 = new BitSet(new long[]{0x100701C041000040L});
    public static final BitSet FOLLOW_functionPointerVarDecl_in_objCClassDef952 = new BitSet(new long[]{0x100701C041000040L});
    public static final BitSet FOLLOW_24_in_objCClassDef979 = new BitSet(new long[]{0x18070E0040000040L});
    public static final BitSet FOLLOW_objCMethodDecl_in_objCClassDef997 = new BitSet(new long[]{0x18070E0040000040L});
    public static final BitSet FOLLOW_typeDef_in_objCClassDef1006 = new BitSet(new long[]{0x18070E0040000040L});
    public static final BitSet FOLLOW_varDecl_in_objCClassDef1017 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_objCClassDef1019 = new BitSet(new long[]{0x18070E0040000040L});
    public static final BitSet FOLLOW_41_in_objCClassDef1032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_objCMethodDecl1066 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_43_in_objCMethodDecl1078 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl1097 = new BitSet(new long[]{0x1007000840000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_objCMethodDecl1105 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl1113 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1124 = new BitSet(new long[]{0x0000000202000000L});
    public static final BitSet FOLLOW_33_in_objCMethodDecl1136 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl1138 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_objCMethodDecl1142 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl1144 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1148 = new BitSet(new long[]{0x0000000012000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1163 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodDecl1165 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl1172 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_objCMethodDecl1176 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl1178 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1187 = new BitSet(new long[]{0x0000000012000040L});
    public static final BitSet FOLLOW_28_in_objCMethodDecl1206 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_objCMethodDecl1208 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_objCMethodDecl1225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_structBody1246 = new BitSet(new long[]{0x180FE001CD000040L});
    public static final BitSet FOLLOW_45_in_structBody1264 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_46_in_structBody1276 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_47_in_structBody1288 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_structBody1299 = new BitSet(new long[]{0x180FE001CD000040L});
    public static final BitSet FOLLOW_declaration_in_structBody1307 = new BitSet(new long[]{0x180FE001CD000040L});
    public static final BitSet FOLLOW_24_in_structBody1319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_structCore1355 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_modifiers_in_structCore1376 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_structBody_in_structCore1391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_structCore1403 = new BitSet(new long[]{0x0000000200800042L});
    public static final BitSet FOLLOW_modifiers_in_structCore1427 = new BitSet(new long[]{0x0000000200800000L});
    public static final BitSet FOLLOW_33_in_structCore1446 = new BitSet(new long[]{0x0000200000000040L});
    public static final BitSet FOLLOW_45_in_structCore1455 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_structCore1467 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_structBody_in_structCore1487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_functionName1540 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionName1545 = new BitSet(new long[]{0xE4680C3020000002L,0x00000000039FF9FFL});
    public static final BitSet FOLLOW_binaryOp_in_functionName1550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryOp_in_functionName1554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentOp_in_functionName1558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_functionDeclaration1604 = new BitSet(new long[]{0x100F000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_functionDeclaration1612 = new BitSet(new long[]{0x100F000040000040L});
    public static final BitSet FOLLOW_modifiers_in_functionDeclaration1621 = new BitSet(new long[]{0x100F000040000040L});
    public static final BitSet FOLLOW_functionName_in_functionDeclaration1627 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_argList_in_functionDeclaration1633 = new BitSet(new long[]{0x0000000002800040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionDeclaration1644 = new BitSet(new long[]{0x0000000002800040L});
    public static final BitSet FOLLOW_modifiers_in_functionDeclaration1655 = new BitSet(new long[]{0x0000000002800040L});
    public static final BitSet FOLLOW_25_in_functionDeclaration1667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_functionDeclaration1674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier1699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_anyModifier_in_modifiers1719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_anyModifier1755 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_anyModifier1759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_anyModifier1768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_anyModifier1783 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_anyModifier1785 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_anyModifier1787 = new BitSet(new long[]{0xE4600C3000000000L,0x00000000000001FFL});
    public static final BitSet FOLLOW_binaryOp_in_anyModifier1789 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_anyModifier1791 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_anyModifier1794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_anyModifier1816 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_anyModifier1818 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_anyModifier1820 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_anyModifier1822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_anyModifier1838 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_anyModifier1843 = new BitSet(new long[]{0x0000000800000060L});
    public static final BitSet FOLLOW_STRING_in_anyModifier1855 = new BitSet(new long[]{0x0000000800000020L});
    public static final BitSet FOLLOW_extendedModifiers_in_anyModifier1868 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_anyModifier1877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_extendedModifiers1910 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_modifier_in_argDef1969 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_modifier_in_argDef1986 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_argDef2004 = new BitSet(new long[]{0x0460000420000042L});
    public static final BitSet FOLLOW_declarator_in_argDef2019 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_argDef2031 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_argDef2033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_argDef2047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_typeMutator2069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_typeMutator2083 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_typeMutator2085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_arrayTypeMutator2103 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_arrayTypeMutator2109 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_arrayTypeMutator2118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_templateDef2130 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_templateDef2132 = new BitSet(new long[]{0x1007002040000040L});
    public static final BitSet FOLLOW_templateArgDecl_in_templateDef2135 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_templateDef2138 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_templateArgDecl_in_templateDef2140 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_templateDef2147 = new BitSet(new long[]{0x0007000000000000L});
    public static final BitSet FOLLOW_structCore_in_templateDef2151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_templateDef2155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_templateArgDecl2167 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_templateArgDecl2170 = new BitSet(new long[]{0x00000000000007B0L});
    public static final BitSet FOLLOW_constant_in_templateArgDecl2172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffix2192 = new BitSet(new long[]{0x0020000000000040L});
    public static final BitSet FOLLOW_modifiers_in_functionSignatureSuffix2196 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_functionSignatureSuffix2198 = new BitSet(new long[]{0x0000000800000040L});
    public static final BitSet FOLLOW_modifiers_in_functionSignatureSuffix2202 = new BitSet(new long[]{0x0000000800000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionSignatureSuffix2204 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffix2207 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffix2213 = new BitSet(new long[]{0x1007100840000040L});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffix2222 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_functionSignatureSuffix2235 = new BitSet(new long[]{0x1007100040000040L});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffix2244 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffix2259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffixNoName2276 = new BitSet(new long[]{0x0020000000000040L});
    public static final BitSet FOLLOW_modifiers_in_functionSignatureSuffixNoName2278 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_functionSignatureSuffixNoName2280 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffixNoName2282 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffixNoName2288 = new BitSet(new long[]{0x1007100840000040L});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffixNoName2297 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_functionSignatureSuffixNoName2310 = new BitSet(new long[]{0x1007100040000040L});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffixNoName2319 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffixNoName2334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefCore_in_mutableTypeRef2365 = new BitSet(new long[]{0x00E0000400000002L});
    public static final BitSet FOLLOW_typeMutator_in_mutableTypeRef2384 = new BitSet(new long[]{0x00E0000400000002L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_mutableTypeRef2404 = new BitSet(new long[]{0x00E0000400000002L});
    public static final BitSet FOLLOW_typeRefCore_in_nonMutableTypeRef2436 = new BitSet(new long[]{0x00E0000400000002L});
    public static final BitSet FOLLOW_typeMutator_in_nonMutableTypeRef2453 = new BitSet(new long[]{0x00E0000400000000L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_nonMutableTypeRef2472 = new BitSet(new long[]{0x00E0000400000002L});
    public static final BitSet FOLLOW_modifiers_in_declarator2504 = new BitSet(new long[]{0x0460000400000040L});
    public static final BitSet FOLLOW_directDeclarator_in_declarator2520 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_set_in_declarator2544 = new BitSet(new long[]{0x0460000400000040L});
    public static final BitSet FOLLOW_declarator_in_declarator2562 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_declarator2583 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_topLevelExpr_in_declarator2591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_typeDef2622 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_varDecl_in_typeDef2627 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_typeDef2629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_varDeclEOF2647 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_varDeclEOF2649 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_varDeclEOF2651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_declarationEOF2671 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_declarationEOF2673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nonMutableTypeRef_in_varDecl2695 = new BitSet(new long[]{0x0460000400000042L});
    public static final BitSet FOLLOW_declaratorsList_in_varDecl2708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_objCProtocolRefList2727 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCProtocolRefList2732 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_objCProtocolRefList2742 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCProtocolRefList2748 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_objCProtocolRefList2758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarator_in_declaratorsList2779 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_declaratorsList2790 = new BitSet(new long[]{0x0460000400000040L});
    public static final BitSet FOLLOW_declarator_in_declaratorsList2798 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_directDeclarator2829 = new BitSet(new long[]{0x0080000400000002L});
    public static final BitSet FOLLOW_34_in_directDeclarator2839 = new BitSet(new long[]{0x0460000400000040L});
    public static final BitSet FOLLOW_declarator_in_directDeclarator2843 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_directDeclarator2845 = new BitSet(new long[]{0x0080000400000002L});
    public static final BitSet FOLLOW_55_in_directDeclarator2861 = new BitSet(new long[]{0x01E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_directDeclarator2873 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_directDeclarator2889 = new BitSet(new long[]{0x0080000400000002L});
    public static final BitSet FOLLOW_argList_in_directDeclarator2897 = new BitSet(new long[]{0x0080000400000002L});
    public static final BitSet FOLLOW_34_in_argList2925 = new BitSet(new long[]{0x1007100840000040L});
    public static final BitSet FOLLOW_argDef_in_argList2937 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_argList2950 = new BitSet(new long[]{0x1007100040000040L});
    public static final BitSet FOLLOW_argDef_in_argList2959 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_argList2979 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_argList2981 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_argList3000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_anyModifier_in_typeRefCore3032 = new BitSet(new long[]{0x1007000040000042L});
    public static final BitSet FOLLOW_60_in_typeRefCore3055 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_typeRefCore3065 = new BitSet(new long[]{0x1007001040000042L});
    public static final BitSet FOLLOW_36_in_typeRefCore3089 = new BitSet(new long[]{0x1007002040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_typeRefCore3110 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_typeRefCore3131 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_typeRefCore3144 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_typeRefCore3172 = new BitSet(new long[]{0x1007000040000042L});
    public static final BitSet FOLLOW_structCore_in_typeRefCore3192 = new BitSet(new long[]{0x1007000040000042L});
    public static final BitSet FOLLOW_enumCore_in_typeRefCore3201 = new BitSet(new long[]{0x1007000040000042L});
    public static final BitSet FOLLOW_55_in_objCMethodCall3231 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3235 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodCall3239 = new BitSet(new long[]{0x0100000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodCall3250 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3254 = new BitSet(new long[]{0x0100000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodCall3269 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodCall3271 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3275 = new BitSet(new long[]{0x0100000000000040L});
    public static final BitSet FOLLOW_56_in_objCMethodCall3292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionCall3312 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionCall3314 = new BitSet(new long[]{0x00E8080C800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_functionCall3327 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_functionCall3336 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_functionCall3345 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_35_in_functionCall3363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_binaryOp0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_baseExpression3464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_baseExpression3472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_baseExpression3480 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_baseExpression3482 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_baseExpression3484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objCMethodCall_in_baseExpression3492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selectorExpr_in_baseExpression3500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_protocolExpr_in_baseExpression3506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_encodingExpr_in_baseExpression3512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_selectorExpr3528 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_selectorExpr3533 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_selectorName_in_selectorExpr3538 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_selectorExpr3543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_selectorName3554 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_IDENTIFIER_in_selectorName3557 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_selectorName3559 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_31_in_protocolExpr3572 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_protocolExpr3576 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_protocolExpr3580 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_protocolExpr3584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_encodingExpr3595 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_encodingExpr3600 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_encodingExpr3604 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_encodingExpr3609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inlineCondExpr_in_assignmentExpr3626 = new BitSet(new long[]{0xE4680C3020000002L,0x00000000039FF9FFL});
    public static final BitSet FOLLOW_assignmentOp_in_assignmentExpr3642 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_assignmentExpr_in_assignmentExpr3646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_assignmentOp3672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logOrExpr_in_inlineCondExpr3733 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_inlineCondExpr3745 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_logOrExpr_in_inlineCondExpr3750 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_inlineCondExpr3756 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_logOrExpr_in_inlineCondExpr3761 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_multExpr_in_addExpr3783 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_set_in_addExpr3796 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_multExpr_in_addExpr3809 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_castExpr_in_multExpr3833 = new BitSet(new long[]{0x6020000000000002L});
    public static final BitSet FOLLOW_set_in_multExpr3847 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_castExpr_in_multExpr3865 = new BitSet(new long[]{0x6020000000000002L});
    public static final BitSet FOLLOW_xorExpr_in_bitOrExpr3889 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_bitOrExpr3903 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_xorExpr_in_bitOrExpr3910 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_equalExpr_in_bitAndExpr3934 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_54_in_bitAndExpr3947 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_equalExpr_in_bitAndExpr3954 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_addExpr_in_shiftExpr3979 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_shiftExpr3992 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_addExpr_in_shiftExpr4005 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_bitAndExpr_in_xorExpr4029 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_58_in_xorExpr4042 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_bitAndExpr_in_xorExpr4049 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_logAndExpr_in_logOrExpr4073 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_logOrExpr4086 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_logAndExpr_in_logOrExpr4093 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_bitOrExpr_in_logAndExpr4117 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_logAndExpr4130 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_bitOrExpr_in_logAndExpr4137 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_compareExpr_in_equalExpr4161 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_set_in_equalExpr4174 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_compareExpr_in_equalExpr4187 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_shiftExpr_in_compareExpr4211 = new BitSet(new long[]{0x0000003000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_set_in_compareExpr4224 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_shiftExpr_in_compareExpr4246 = new BitSet(new long[]{0x0000003000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_34_in_castExpr4268 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_castExpr4272 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_castExpr4274 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_castExpr_in_castExpr4278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpr_in_castExpr4289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpr_in_unaryExpr4311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryOp_in_unaryExpr4319 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_castExpr_in_unaryExpr4321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_unaryExpr4329 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_34_in_unaryExpr4336 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_unaryExpr4340 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_unaryExpr4342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpr_in_unaryExpr4350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_unaryOp0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_baseExpression_in_postfixExpr4407 = new BitSet(new long[]{0x0080000400000002L,0x000000000D800000L});
    public static final BitSet FOLLOW_55_in_postfixExpr4418 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_postfixExpr4420 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_postfixExpr4422 = new BitSet(new long[]{0x0080000400000002L,0x000000000D800000L});
    public static final BitSet FOLLOW_34_in_postfixExpr4431 = new BitSet(new long[]{0x00E8080C800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_topLevelExprList_in_postfixExpr4433 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_postfixExpr4436 = new BitSet(new long[]{0x0080000400000002L,0x000000000D800000L});
    public static final BitSet FOLLOW_90_in_postfixExpr4445 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_postfixExpr4449 = new BitSet(new long[]{0x0080000400000002L,0x000000000D800000L});
    public static final BitSet FOLLOW_91_in_postfixExpr4458 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_postfixExpr4462 = new BitSet(new long[]{0x0080000400000002L,0x000000000D800000L});
    public static final BitSet FOLLOW_87_in_postfixExpr4471 = new BitSet(new long[]{0x0080000400000002L,0x000000000D800000L});
    public static final BitSet FOLLOW_88_in_postfixExpr4480 = new BitSet(new long[]{0x0080000400000002L,0x000000000D800000L});
    public static final BitSet FOLLOW_assignmentExpr_in_topLevelExpr4504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_topLevelExpr_in_topLevelExprList4529 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_topLevelExprList4540 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_topLevelExpr_in_topLevelExprList4547 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_topLevelExprList_in_expression4571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_statementsBlock4605 = new BitSet(new long[]{0x18FF0805CF8007F0L,0x00000003D3C00600L});
    public static final BitSet FOLLOW_statement_in_statementsBlock4617 = new BitSet(new long[]{0x18FF0805CF8007F0L,0x00000003D3C00600L});
    public static final BitSet FOLLOW_24_in_statementsBlock4629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_statement4648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_statement4656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement4665 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_statement4677 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_statement4681 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_statement4691 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4693 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_statement4695 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4697 = new BitSet(new long[]{0x18FF0805CE8007F0L,0x00000003D3C00600L});
    public static final BitSet FOLLOW_statement_in_statement4699 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_statement4702 = new BitSet(new long[]{0x18FF0805CE8007F0L,0x00000003D3C00600L});
    public static final BitSet FOLLOW_statement_in_statement4704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_statement4713 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4715 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_statement4717 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4719 = new BitSet(new long[]{0x18FF0805CE8007F0L,0x00000003D3C00600L});
    public static final BitSet FOLLOW_statement_in_statement4721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_statement4728 = new BitSet(new long[]{0x18FF0805CE8007F0L,0x00000003D3C00600L});
    public static final BitSet FOLLOW_statement_in_statement4730 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_statement4732 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4734 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_statement4736 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4738 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_statement4747 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4749 = new BitSet(new long[]{0x18FF0805CE8007F0L,0x00000003D3C00600L});
    public static final BitSet FOLLOW_statement_in_statement4751 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4754 = new BitSet(new long[]{0x00E80804820007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_statement4756 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4759 = new BitSet(new long[]{0x18FF080DCE8007F0L,0x00000003D3C00600L});
    public static final BitSet FOLLOW_statement_in_statement4761 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4764 = new BitSet(new long[]{0x18FF0805CE8007F0L,0x00000003D3C00600L});
    public static final BitSet FOLLOW_statement_in_statement4766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_statement4773 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4775 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_statement4777 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4779 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_statement4781 = new BitSet(new long[]{0x18FF0805CF8007F0L,0x00000007D3C00600L});
    public static final BitSet FOLLOW_98_in_statement4788 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_statement4790 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement4792 = new BitSet(new long[]{0x18FF0805CF8007F0L,0x00000007D3C00600L});
    public static final BitSet FOLLOW_statement_in_statement4799 = new BitSet(new long[]{0x18FF0805CF8007F0L,0x00000007D3C00600L});
    public static final BitSet FOLLOW_24_in_statement4808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_statement4814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement4822 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4824 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_varDecl_in_statement4826 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement4828 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_statement4830 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4832 = new BitSet(new long[]{0x18FF0805CE8007F0L,0x00000003D3C00600L});
    public static final BitSet FOLLOW_statement_in_statement4834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_constant4851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEXADECIMAL_NUMBER_in_constant4859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OCTAL_NUMBER_in_constant4867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARACTER_in_constant4875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_NUMBER_in_constant4883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_constant4894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_synpred6_ObjCpp276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred8_ObjCpp296 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred8_ObjCpp298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_synpred19_ObjCpp667 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_enumBody_in_synpred19_ObjCpp678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred30_ObjCpp927 = new BitSet(new long[]{0x0000000202000000L});
    public static final BitSet FOLLOW_33_in_synpred30_ObjCpp931 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_synpred30_ObjCpp935 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred30_ObjCpp940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_synpred51_ObjCpp1427 = new BitSet(new long[]{0x0000000200800000L});
    public static final BitSet FOLLOW_33_in_synpred51_ObjCpp1446 = new BitSet(new long[]{0x0000200000000040L});
    public static final BitSet FOLLOW_45_in_synpred51_ObjCpp1455 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred51_ObjCpp1467 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_structBody_in_synpred51_ObjCpp1487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binaryOp_in_synpred53_ObjCpp1550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryOp_in_synpred54_ObjCpp1554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred57_ObjCpp1612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred58_ObjCpp1644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_anyModifier_in_synpred60_ObjCpp1719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred62_ObjCpp1768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred64_ObjCpp1816 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_synpred64_ObjCpp1818 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_expression_in_synpred64_ObjCpp1820 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred64_ObjCpp1822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_synpred66_ObjCpp1855 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_modifier_in_synpred68_ObjCpp1969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred69_ObjCpp1986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred84_ObjCpp2384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_synpred85_ObjCpp2404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred87_ObjCpp2453 = new BitSet(new long[]{0x00E0000400000000L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_synpred87_ObjCpp2472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred91_ObjCpp2583 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_topLevelExpr_in_synpred91_ObjCpp2591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_synpred99_ObjCpp2950 = new BitSet(new long[]{0x1007100040000040L});
    public static final BitSet FOLLOW_argDef_in_synpred99_ObjCpp2959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_anyModifier_in_synpred102_ObjCpp3032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_synpred107_ObjCpp3055 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred107_ObjCpp3065 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_synpred107_ObjCpp3089 = new BitSet(new long[]{0x1007002040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred107_ObjCpp3110 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_synpred107_ObjCpp3131 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred107_ObjCpp3144 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_synpred107_ObjCpp3172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentOp_in_synpred139_ObjCpp3642 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_assignmentExpr_in_synpred139_ObjCpp3646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred169_ObjCpp4268 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred169_ObjCpp4272 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred169_ObjCpp4274 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_castExpr_in_synpred169_ObjCpp4278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred172_ObjCpp4336 = new BitSet(new long[]{0x1007000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred172_ObjCpp4340 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred172_ObjCpp4342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_synpred186_ObjCpp4540 = new BitSet(new long[]{0x00E80804800007F0L,0x0000000003C00600L});
    public static final BitSet FOLLOW_topLevelExpr_in_synpred186_ObjCpp4547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_synpred189_ObjCpp4656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred190_ObjCpp4665 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred190_ObjCpp4667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_synpred192_ObjCpp4702 = new BitSet(new long[]{0x18FF0805CE8007F0L,0x00000003D3C00600L});
    public static final BitSet FOLLOW_statement_in_synpred192_ObjCpp4704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_synpred196_ObjCpp4751 = new BitSet(new long[]{0x0000000000000002L});

}