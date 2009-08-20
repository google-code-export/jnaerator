// $ANTLR 3.1.2 /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g 2009-08-20 23:02:18
 
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
import static com.ochafik.lang.jnaerator.parser.Identifier.*;
import static com.ochafik.lang.jnaerator.parser.Statement.*;
import static com.ochafik.lang.jnaerator.parser.Declarator.*;
import static com.ochafik.lang.jnaerator.parser.ElementsHelper.*;
import static com.ochafik.lang.jnaerator.parser.StoredDeclarations.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/**
	This grammar is by no mean complete.
	It is able to parse preprocessed C & Objective-C files and can tolerate some amount of C++. 
	It lacks serious expression support, which is being worked on.
	Complex variable declarations may not be supported, such as complex signatures of functions that return function pointers...
*/
public class ObjCppParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DECIMAL_NUMBER", "STRING", "IDENTIFIER", "HEXADECIMAL_NUMBER", "OCTAL_NUMBER", "CHARACTER", "FLOAT_NUMBER", "Letter", "FloatingPointExponentSuffix", "FloatingPointConstantSuffix", "OctalEscape", "CharEscape", "HexDigit", "UnicodeEscape", "IntegerConstantSuffix", "WS", "COMMENT", "LINE_COMMENT", "'#line'", "'{'", "'}'", "';'", "'namespace'", "'@class'", "','", "'='", "'enum'", "'@protocol'", "'@interface'", "':'", "'('", "')'", "'<'", "'>'", "'@public'", "'@private'", "'@protected'", "'@end'", "'@property'", "'+'", "'-'", "'class'", "'...'", "'public'", "'private'", "'protected'", "'struct'", "'union'", "'return'", "'*'", "'&'", "'['", "']'", "'template'", "'^'", "'typedef'", "'typename'", "'/'", "'%'", "'<<'", "'>>>'", "'>>'", "'||'", "'|'", "'&&'", "'<='", "'>='", "'=='", "'!='", "'::'", "'~'", "'@selector'", "'@encode'", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'~='", "'?'", "'++'", "'--'", "'!'", "'.'", "'->'", "'break'", "'if'", "'else'", "'while'", "'do'", "'for'", "'switch'", "'case'"
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
    public static final int FloatingPointConstantSuffix=13;
    public static final int T__70=70;
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
    public static final int FloatingPointExponentSuffix=12;
    public static final int T__46=46;
    public static final int FLOAT_NUMBER=10;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__101=101;
    public static final int T__100=100;
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
            this.state.ruleMemo = new HashMap[307+1];
             
             
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
    	public com.ochafik.lang.jnaerator.TypeConversion typeConverter;
    	boolean isPrimitiveType(String identifier) {
    		return typeConverter.isObjCppPrimitive(identifier);
    	}
    	public void setupSymbolsStack() {
        		Symbols_scope ss = new Symbols_scope();
        		ss.typeIdentifiers = new HashSet();
        		Symbols_stack.push(ss);
    	}
    	boolean isTypeDef() {
    		if (IsTypeDef_stack.isEmpty())
    			return false;
    		IsTypeDef_scope scope = (IsTypeDef_scope)IsTypeDef_stack.get(IsTypeDef_stack.size() - 1);
    		return scope.isTypeDef;
    	}
    	void defineTypeIdentifierInParentScope(Identifier i) {
    		if (i != null && i.isPlain())
    			defineTypeIdentifierInParentScope(i.toString());
    	}
    	void defineTypeIdentifierInParentScope(String name) {
    		if (name == null || Symbols_stack.isEmpty())
    			return;
    		int s = Symbols_stack.size();
    		Symbols_scope sp = (Symbols_scope)Symbols_stack.get(s - 2 >= 0 ? s - 2 : s - 1);
    		sp.typeIdentifiers.add(name);
    	}
    	boolean isTypeIdentifier(String identifier) {
    		if (possibleLanguages.contains(Language.ObjectiveC)) {
    			if ("SEL".equals(identifier) ||
    				"id".equals(identifier) ||
    				"IMP".equals(identifier) ||
    				"Class".equals(identifier) ||
    				"Protocol".equals(identifier) ||
    				"BOOL".equals(identifier) ||
    				"NSObject".equals(identifier) ||
    				"NSClass".equals(identifier))
    				return true;
    		}
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



    // $ANTLR start "lineDirective"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:308:1: lineDirective : ln= '#line' line= DECIMAL_NUMBER (unescapedString= STRING )? (depth= DECIMAL_NUMBER )? ;
    public final void lineDirective() throws RecognitionException {
        int lineDirective_StartIndex = input.index();
        Token ln=null;
        Token line=null;
        Token unescapedString=null;
        Token depth=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return ; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:309:2: (ln= '#line' line= DECIMAL_NUMBER (unescapedString= STRING )? (depth= DECIMAL_NUMBER )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:309:4: ln= '#line' line= DECIMAL_NUMBER (unescapedString= STRING )? (depth= DECIMAL_NUMBER )?
            {
            ln=(Token)match(input,22,FOLLOW_22_in_lineDirective78); if (state.failed) return ;
            line=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_lineDirective82); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			try {
              				sourceLineDelta = Integer.parseInt((line!=null?line.getText():null)) - ln.getLine() - 1;
              			} catch (Exception ex) {
              				System.err.println("ERROR: unparsable line in #line directive : " + (line!=null?line.getText():null));
              				sourceLineDelta = 0;
              			}
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:317:3: (unescapedString= STRING )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==STRING) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:318:4: unescapedString= STRING
                    {
                    unescapedString=(Token)match(input,STRING,FOLLOW_STRING_in_lineDirective95); if (state.failed) return ;
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:328:8: (depth= DECIMAL_NUMBER )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==DECIMAL_NUMBER) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: depth= DECIMAL_NUMBER
                    {
                    depth=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_lineDirective110); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, lineDirective_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "lineDirective"


    // $ANTLR start "sourceFile"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:331:1: sourceFile returns [SourceFile sourceFile] : ( declaration | lineDirective )* EOF ;
    public final SourceFile sourceFile() throws RecognitionException {
        Symbols_stack.push(new Symbols_scope());

        SourceFile sourceFile = null;
        int sourceFile_StartIndex = input.index();
        ObjCppParser.declaration_return declaration1 = null;



        	((Symbols_scope)Symbols_stack.peek()).typeIdentifiers = new HashSet<String>();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return sourceFile; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:336:2: ( ( declaration | lineDirective )* EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:337:3: ( declaration | lineDirective )* EOF
            {
            if ( state.backtracking==0 ) {
               sourceFile = new SourceFile(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:338:3: ( declaration | lineDirective )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==IDENTIFIER||(LA3_0>=25 && LA3_0<=27)||(LA3_0>=30 && LA3_0<=32)||LA3_0==34||LA3_0==45||(LA3_0>=50 && LA3_0<=51)||(LA3_0>=53 && LA3_0<=55)||(LA3_0>=57 && LA3_0<=60)||LA3_0==74) ) {
                    alt3=1;
                }
                else if ( (LA3_0==22) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:339:4: declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_sourceFile150);
            	    declaration1=declaration();

            	    state._fsp--;
            	    if (state.failed) return sourceFile;
            	    if ( state.backtracking==0 ) {
            	       
            	      				for (Declaration d : (declaration1!=null?declaration1.declarations:null))
            	      					sourceFile.addDeclaration(d); 
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:343:4: lineDirective
            	    {
            	    pushFollow(FOLLOW_lineDirective_in_sourceFile159);
            	    lineDirective();

            	    state._fsp--;
            	    if (state.failed) return sourceFile;
            	    if ( state.backtracking==0 ) {

            	      				if (sourceFile.getElementFile() == null)
            	      					sourceFile.setElementFile(getFile());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,EOF,FOLLOW_EOF_in_sourceFile172); if (state.failed) return sourceFile;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, sourceFile_StartIndex); }
            Symbols_stack.pop();

        }
        return sourceFile;
    }
    // $ANTLR end "sourceFile"


    // $ANTLR start "externDeclarations"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:351:1: externDeclarations returns [ExternDeclarations declarations] : {...}? => IDENTIFIER STRING '{' (ed= declaration )* '}' ;
    public final ExternDeclarations externDeclarations() throws RecognitionException {
        ExternDeclarations declarations = null;
        int externDeclarations_StartIndex = input.index();
        Token STRING2=null;
        ObjCppParser.declaration_return ed = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return declarations; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:352:2: ({...}? => IDENTIFIER STRING '{' (ed= declaration )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:352:4: {...}? => IDENTIFIER STRING '{' (ed= declaration )* '}'
            {
            if ( !(( next("extern") )) ) {
                if (state.backtracking>0) {state.failed=true; return declarations;}
                throw new FailedPredicateException(input, "externDeclarations", " next(\"extern\") ");
            }
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_externDeclarations191); if (state.failed) return declarations;
            STRING2=(Token)match(input,STRING,FOLLOW_STRING_in_externDeclarations195); if (state.failed) return declarations;
            if ( state.backtracking==0 ) {

              			declarations = mark(new ExternDeclarations(), getLine(STRING2));
              			declarations.setLanguage((STRING2!=null?STRING2.getText():null));
              		
            }
            match(input,23,FOLLOW_23_in_externDeclarations201); if (state.failed) return declarations;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:358:4: (ed= declaration )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==IDENTIFIER||(LA4_0>=25 && LA4_0<=27)||(LA4_0>=30 && LA4_0<=32)||LA4_0==34||LA4_0==45||(LA4_0>=50 && LA4_0<=51)||(LA4_0>=53 && LA4_0<=55)||(LA4_0>=57 && LA4_0<=60)||LA4_0==74) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:359:5: ed= declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_externDeclarations215);
            	    ed=declaration();

            	    state._fsp--;
            	    if (state.failed) return declarations;
            	    if ( state.backtracking==0 ) {
            	       
            	      					declarations.addDeclarations((ed!=null?ed.declarations:null)); 
            	      				
            	    }

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match(input,24,FOLLOW_24_in_externDeclarations228); if (state.failed) return declarations;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, externDeclarations_StartIndex); }
        }
        return declarations;
    }
    // $ANTLR end "externDeclarations"

    public static class declaration_return extends ParserRuleReturnScope {
        public List<Declaration> declarations;
        public List<Modifier> modifiers;
        public String preComment;
        public int startTokenIndex;
    };

    // $ANTLR start "declaration"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:366:1: declaration returns [List<Declaration> declarations, List<Modifier> modifiers, String preComment, int startTokenIndex] : ( ({...}? => pragmaContent | templateDef | functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) ) ;
    public final ObjCppParser.declaration_return declaration() throws RecognitionException {
        IsTypeDef_stack.push(new IsTypeDef_scope());

        ObjCppParser.declaration_return retval = new ObjCppParser.declaration_return();
        retval.start = input.LT(1);
        int declaration_StartIndex = input.index();
        Token ns=null;
        ObjCppParser.declaration_return subD = null;

        ObjCppParser.functionDeclaration_return functionDeclaration3 = null;

        ExternDeclarations externDeclarations4 = null;

        VariablesDeclaration varDecl5 = null;

        Struct objCClassDef6 = null;

        TypeDef typeDef7 = null;

        List<Declaration> forwardClassDecl8 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:381:2: ( ( ({...}? => pragmaContent | templateDef | functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:382:3: ( ({...}? => pragmaContent | templateDef | functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) )
            {
            if ( state.backtracking==0 ) {
               retval.declarations = new ArrayList<Declaration>(); 
              		  retval.modifiers = new ArrayList<Modifier>();
              		  retval.startTokenIndex = getTokenStream().index();
              		  retval.preComment = getCommentBefore(retval.startTokenIndex);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:387:3: ( ({...}? => pragmaContent | templateDef | functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:388:4: ({...}? => pragmaContent | templateDef | functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:388:4: ({...}? => pragmaContent | templateDef | functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )
            int alt6=9;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:389:5: {...}? => pragmaContent
                    {
                    if ( !(( next("__pragma") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "declaration", " next(\"__pragma\") ");
                    }
                    pushFollow(FOLLOW_pragmaContent_in_declaration274);
                    pragmaContent();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:390:5: templateDef
                    {
                    pushFollow(FOLLOW_templateDef_in_declaration282);
                    templateDef();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:391:5: functionDeclaration
                    {
                    pushFollow(FOLLOW_functionDeclaration_in_declaration291);
                    functionDeclaration3=functionDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      					retval.declarations.add((functionDeclaration3!=null?functionDeclaration3.function:null));
                      				
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:394:5: externDeclarations
                    {
                    pushFollow(FOLLOW_externDeclarations_in_declaration301);
                    externDeclarations4=externDeclarations();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      					retval.declarations.add(externDeclarations4); 
                      				
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:397:5: varDecl ';'
                    {
                    pushFollow(FOLLOW_varDecl_in_declaration311);
                    varDecl5=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    match(input,25,FOLLOW_25_in_declaration313); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       
                      					retval.declarations.add(varDecl5); 
                      				
                    }

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:400:5: objCClassDef
                    {
                    pushFollow(FOLLOW_objCClassDef_in_declaration323);
                    objCClassDef6=objCClassDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       
                      					retval.declarations.add(decl(objCClassDef6)); 
                      				
                    }

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:403:5: typeDef
                    {
                    pushFollow(FOLLOW_typeDef_in_declaration333);
                    typeDef7=typeDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      					retval.declarations.add(typeDef7); 
                      				
                    }

                    }
                    break;
                case 8 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:406:5: forwardClassDecl
                    {
                    pushFollow(FOLLOW_forwardClassDecl_in_declaration343);
                    forwardClassDecl8=forwardClassDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      					retval.declarations.addAll(forwardClassDecl8); 
                      				
                    }

                    }
                    break;
                case 9 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:409:5: 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}'
                    {
                    match(input,26,FOLLOW_26_in_declaration353); if (state.failed) return retval;
                    ns=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration357); if (state.failed) return retval;
                    match(input,23,FOLLOW_23_in_declaration359); if (state.failed) return retval;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:410:6: (subD= declaration )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==IDENTIFIER||(LA5_0>=25 && LA5_0<=27)||(LA5_0>=30 && LA5_0<=32)||LA5_0==34||LA5_0==45||(LA5_0>=50 && LA5_0<=51)||(LA5_0>=53 && LA5_0<=55)||(LA5_0>=57 && LA5_0<=60)||LA5_0==74) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:411:7: subD= declaration
                    	    {
                    	    pushFollow(FOLLOW_declaration_in_declaration377);
                    	    subD=declaration();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      							for (Declaration d : (subD!=null?subD.declarations:null)) {
                    	      								if (d == null)
                    	      									continue;
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

                    match(input,24,FOLLOW_24_in_declaration393); if (state.failed) return retval;

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

              	try {
              		int i = ((Token)retval.start).getTokenIndex();
              		if (i > 0) {
              			String s1 = getTokenStream().get(i - 1).getText(), s2 = i > 1 ? getTokenStream().get(i - 2).getText() : null;
                         		String s = (s2 == null ? "" : s2) + s1;
                         		if (s.matches(".*\n\\s*\n"))
              				retval.declarations.add(0, new EmptyDeclaration());
              		}
              	} catch (Exception ex) {
              		ex.printStackTrace();
              	}

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, declaration_StartIndex); }
            IsTypeDef_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "declaration"


    // $ANTLR start "forwardClassDecl"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:437:1: forwardClassDecl returns [List<Declaration> declarations] : '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';' ;
    public final List<Declaration> forwardClassDecl() throws RecognitionException {
        List<Declaration> declarations = null;
        int forwardClassDecl_StartIndex = input.index();
        Token n1=null;
        Token nx=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return declarations; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:438:2: ( '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:438:5: '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';'
            {
            if ( state.backtracking==0 ) {
               declarations = new ArrayList<Declaration>(); 
            }
            match(input,27,FOLLOW_27_in_forwardClassDecl433); if (state.failed) return declarations;
            n1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_forwardClassDecl440); if (state.failed) return declarations;
            if ( state.backtracking==0 ) {
               
              			declarations.add(decl(Struct.forwardDecl(new SimpleIdentifier((n1!=null?n1.getText():null)), Struct.Type.ObjCClass))); 
              			defineTypeIdentifierInParentScope((n1!=null?n1.getText():null));
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:444:3: ( ',' nx= IDENTIFIER )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==28) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:444:4: ',' nx= IDENTIFIER
            	    {
            	    match(input,28,FOLLOW_28_in_forwardClassDecl447); if (state.failed) return declarations;
            	    nx=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_forwardClassDecl454); if (state.failed) return declarations;
            	    if ( state.backtracking==0 ) {
            	       
            	      			declarations.add(decl(Struct.forwardDecl(new SimpleIdentifier((nx!=null?nx.getText():null)), Struct.Type.ObjCClass))); 
            	      			defineTypeIdentifierInParentScope((nx!=null?nx.getText():null));
            	      		
            	    }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match(input,25,FOLLOW_25_in_forwardClassDecl465); if (state.failed) return declarations;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, forwardClassDecl_StartIndex); }
        }
        return declarations;
    }
    // $ANTLR end "forwardClassDecl"


    // $ANTLR start "functionPointerVarDecl"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:453:1: functionPointerVarDecl returns [Declaration decl] : tr= mutableTypeRef {...}? ';' ;
    public final Declaration functionPointerVarDecl() throws RecognitionException {
        Declaration decl = null;
        int functionPointerVarDecl_StartIndex = input.index();
        TypeRef tr = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return decl; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:454:2: (tr= mutableTypeRef {...}? ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:454:4: tr= mutableTypeRef {...}? ';'
            {
            pushFollow(FOLLOW_mutableTypeRef_in_functionPointerVarDecl485);
            tr=mutableTypeRef();

            state._fsp--;
            if (state.failed) return decl;
            if ( !((
            			(tr instanceof FunctionSignature) && 
            			((FunctionSignature)tr).getFunction().getName() != null
            		)) ) {
                if (state.backtracking>0) {state.failed=true; return decl;}
                throw new FailedPredicateException(input, "functionPointerVarDecl", "\n\t\t\t($tr.type instanceof FunctionSignature) && \n\t\t\t((FunctionSignature)$tr.type).getFunction().getName() != null\n\t\t");
            }
            if ( state.backtracking==0 ) {

              			decl = new FunctionPointerDeclaration(((FunctionSignature)tr));
              		
            }
            match(input,25,FOLLOW_25_in_functionPointerVarDecl493); if (state.failed) return decl;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, functionPointerVarDecl_StartIndex); }
        }
        return decl;
    }
    // $ANTLR end "functionPointerVarDecl"

    public static class enumItem_return extends ParserRuleReturnScope {
        public Enum.EnumItem item;
    };

    // $ANTLR start "enumItem"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:463:1: enumItem returns [Enum.EnumItem item] : n= IDENTIFIER ( '=' v= topLevelExpr )? ;
    public final ObjCppParser.enumItem_return enumItem() throws RecognitionException {
        ObjCppParser.enumItem_return retval = new ObjCppParser.enumItem_return();
        retval.start = input.LT(1);
        int enumItem_StartIndex = input.index();
        Token n=null;
        ObjCppParser.topLevelExpr_return v = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:464:2: (n= IDENTIFIER ( '=' v= topLevelExpr )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:464:4: n= IDENTIFIER ( '=' v= topLevelExpr )?
            {
            n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumItem511); if (state.failed) return retval;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:464:17: ( '=' v= topLevelExpr )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==29) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:464:18: '=' v= topLevelExpr
                    {
                    match(input,29,FOLLOW_29_in_enumItem514); if (state.failed) return retval;
                    pushFollow(FOLLOW_topLevelExpr_in_enumItem518);
                    v=topLevelExpr();

                    state._fsp--;
                    if (state.failed) return retval;

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, enumItem_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "enumItem"


    // $ANTLR start "enumBody"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:471:1: enumBody returns [Enum e] : '{' (i1= enumItem ( ',' (ix= enumItem )? )* )? '}' ;
    public final Enum enumBody() throws RecognitionException {
        Enum e = null;
        int enumBody_StartIndex = input.index();
        ObjCppParser.enumItem_return i1 = null;

        ObjCppParser.enumItem_return ix = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return e; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:472:2: ( '{' (i1= enumItem ( ',' (ix= enumItem )? )* )? '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:473:3: '{' (i1= enumItem ( ',' (ix= enumItem )? )* )? '}'
            {
            if ( state.backtracking==0 ) {
               
              			e = new Enum();
              			e.setForwardDeclaration(false); 
              		
            }
            match(input,23,FOLLOW_23_in_enumBody544); if (state.failed) return e;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:478:4: (i1= enumItem ( ',' (ix= enumItem )? )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==IDENTIFIER) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:479:5: i1= enumItem ( ',' (ix= enumItem )? )*
                    {
                    pushFollow(FOLLOW_enumItem_in_enumBody560);
                    i1=enumItem();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                       
                      					if ((i1!=null?input.toString(i1.start,i1.stop):null) != null)
                      						e.addItem((i1!=null?i1.item:null)); 
                      				
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:483:5: ( ',' (ix= enumItem )? )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==28) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:484:6: ',' (ix= enumItem )?
                    	    {
                    	    match(input,28,FOLLOW_28_in_enumBody575); if (state.failed) return e;
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:485:6: (ix= enumItem )?
                    	    int alt9=2;
                    	    int LA9_0 = input.LA(1);

                    	    if ( (LA9_0==IDENTIFIER) ) {
                    	        alt9=1;
                    	    }
                    	    switch (alt9) {
                    	        case 1 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:485:7: ix= enumItem
                    	            {
                    	            pushFollow(FOLLOW_enumItem_in_enumBody586);
                    	            ix=enumItem();

                    	            state._fsp--;
                    	            if (state.failed) return e;
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              						if ((ix!=null?input.toString(ix.start,ix.stop):null) != null)
                    	              							e.addItem((ix!=null?ix.item:null)); 
                    	              					
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

            match(input,24,FOLLOW_24_in_enumBody607); if (state.failed) return e;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, enumBody_StartIndex); }
        }
        return e;
    }
    // $ANTLR end "enumBody"


    // $ANTLR start "enumCore"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:493:1: enumCore returns [Enum e] : t= 'enum' (m1= modifiers (ab= enumBody | tag= qualifiedIdentifier (m2= modifiers nb= enumBody | ) ) ) ;
    public final Enum enumCore() throws RecognitionException {
        Enum e = null;
        int enumCore_StartIndex = input.index();
        Token t=null;
        List<Modifier> m1 = null;

        Enum ab = null;

        ObjCppParser.qualifiedIdentifier_return tag = null;

        List<Modifier> m2 = null;

        Enum nb = null;



        	List<Modifier> modifiers = new ArrayList<Modifier>();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return e; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:497:2: (t= 'enum' (m1= modifiers (ab= enumBody | tag= qualifiedIdentifier (m2= modifiers nb= enumBody | ) ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:498:3: t= 'enum' (m1= modifiers (ab= enumBody | tag= qualifiedIdentifier (m2= modifiers nb= enumBody | ) ) )
            {
            t=(Token)match(input,30,FOLLOW_30_in_enumCore630); if (state.failed) return e;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:499:3: (m1= modifiers (ab= enumBody | tag= qualifiedIdentifier (m2= modifiers nb= enumBody | ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:500:4: m1= modifiers (ab= enumBody | tag= qualifiedIdentifier (m2= modifiers nb= enumBody | ) )
            {
            pushFollow(FOLLOW_modifiers_in_enumCore641);
            m1=modifiers();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
               modifiers.addAll(m1); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:501:4: (ab= enumBody | tag= qualifiedIdentifier (m2= modifiers nb= enumBody | ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==23) ) {
                alt13=1;
            }
            else if ( (LA13_0==IDENTIFIER) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return e;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:502:5: ab= enumBody
                    {
                    pushFollow(FOLLOW_enumBody_in_enumCore656);
                    ab=enumBody();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {

                      					e = ab;
                      					e.setForwardDeclaration(false);
                      				
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:506:5: tag= qualifiedIdentifier (m2= modifiers nb= enumBody | )
                    {
                    pushFollow(FOLLOW_qualifiedIdentifier_in_enumCore668);
                    tag=qualifiedIdentifier();

                    state._fsp--;
                    if (state.failed) return e;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:507:5: (m2= modifiers nb= enumBody | )
                    int alt12=2;
                    alt12 = dfa12.predict(input);
                    switch (alt12) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:508:6: m2= modifiers nb= enumBody
                            {
                            pushFollow(FOLLOW_modifiers_in_enumCore683);
                            m2=modifiers();

                            state._fsp--;
                            if (state.failed) return e;
                            if ( state.backtracking==0 ) {
                               modifiers.addAll(m2); 
                            }
                            pushFollow(FOLLOW_enumBody_in_enumCore694);
                            nb=enumBody();

                            state._fsp--;
                            if (state.failed) return e;
                            if ( state.backtracking==0 ) {

                              						e = nb;
                              						e.setForwardDeclaration(false);
                              					
                            }

                            }
                            break;
                        case 2 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:512:10: 
                            {
                            if ( state.backtracking==0 ) {

                              						e = new Enum();
                              						e.setForwardDeclaration(true);
                              					
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      					e.setTag((tag!=null?tag.identifier:null));
                      				
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              			//e.setCommentBefore(getCommentBefore(t.getTokenIndex()));
              			e = mark(e, getLine(t));
              			e.addModifiers(modifiers);
              			defineTypeIdentifierInParentScope(e.getTag());
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, enumCore_StartIndex); }
        }
        return e;
    }
    // $ANTLR end "enumCore"


    // $ANTLR start "objCClassDef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:529:1: objCClassDef returns [Struct struct] : octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER ) | ( '(' categoryName= IDENTIFIER ')' ) | ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( functionPointerOrSimpleVarDecl ';' ) )* '}' )? ( objCMethodDecl | objCPropertyDecl | typeDef | vd= varDecl ';' {...}?)* '@end' ;
    public final Struct objCClassDef() throws RecognitionException {
        Struct struct = null;
        int objCClassDef_StartIndex = input.index();
        Token octype=null;
        Token className=null;
        Token parentClass=null;
        Token categoryName=null;
        Token p1=null;
        Token px=null;
        VariablesDeclaration vd = null;

        Declaration functionPointerOrSimpleVarDecl9 = null;

        Function objCMethodDecl10 = null;

        Property objCPropertyDecl11 = null;

        TypeDef typeDef12 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return struct; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:530:2: (octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER ) | ( '(' categoryName= IDENTIFIER ')' ) | ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( functionPointerOrSimpleVarDecl ';' ) )* '}' )? ( objCMethodDecl | objCPropertyDecl | typeDef | vd= varDecl ';' {...}?)* '@end' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:531:3: octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER ) | ( '(' categoryName= IDENTIFIER ')' ) | ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( functionPointerOrSimpleVarDecl ';' ) )* '}' )? ( objCMethodDecl | objCPropertyDecl | typeDef | vd= varDecl ';' {...}?)* '@end'
            {
            octype=(Token)input.LT(1);
            if ( (input.LA(1)>=31 && input.LA(1)<=32) ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return struct;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            className=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef754); if (state.failed) return struct;
            if ( state.backtracking==0 ) {

              			defineTypeIdentifierInParentScope((className!=null?className.getText():null));
              			struct = mark(new Struct(), getLine(octype));
              			//struct.setForwardDeclaration(true);
              			//struct.setCommentBefore(getCommentBefore(octype.getTokenIndex()));
              			struct.setType((octype!=null?octype.getText():null).equals("@interface") ?
              				Struct.Type.ObjCClass :
              				Struct.Type.ObjCProtocol
              			);
              			struct.setTag(new SimpleIdentifier((className!=null?className.getText():null)));
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:543:3: ( ( ':' parentClass= IDENTIFIER ) | ( '(' categoryName= IDENTIFIER ')' ) | )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt14=1;
                }
                break;
            case 34:
                {
                int LA14_2 = input.LA(2);

                if ( (LA14_2==IDENTIFIER) ) {
                    int LA14_4 = input.LA(3);

                    if ( (LA14_4==35) ) {
                        int LA14_5 = input.LA(4);

                        if ( (synpred24_ObjCpp()) ) {
                            alt14=2;
                        }
                        else if ( (true) ) {
                            alt14=3;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return struct;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 5, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA14_4>=STRING && LA14_4<=IDENTIFIER)||LA14_4==29||(LA14_4>=33 && LA14_4<=34)||(LA14_4>=53 && LA14_4<=55)||LA14_4==58) ) {
                        alt14=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return struct;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 4, input);

                        throw nvae;
                    }
                }
                else if ( (LA14_2==34||(LA14_2>=53 && LA14_2<=54)||LA14_2==58) ) {
                    alt14=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return struct;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 2, input);

                    throw nvae;
                }
                }
                break;
            case IDENTIFIER:
            case 23:
            case 25:
            case 30:
            case 36:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 58:
            case 59:
            case 60:
                {
                alt14=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return struct;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:544:4: ( ':' parentClass= IDENTIFIER )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:544:4: ( ':' parentClass= IDENTIFIER )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:545:5: ':' parentClass= IDENTIFIER
                    {
                    match(input,33,FOLLOW_33_in_objCClassDef772); if (state.failed) return struct;
                    parentClass=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef776); if (state.failed) return struct;
                    if ( state.backtracking==0 ) {

                      				if ((parentClass!=null?parentClass.getText():null) != null)
                      					struct.addParent(new SimpleIdentifier((parentClass!=null?parentClass.getText():null)));
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:550:4: ( '(' categoryName= IDENTIFIER ')' )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:550:4: ( '(' categoryName= IDENTIFIER ')' )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:551:5: '(' categoryName= IDENTIFIER ')'
                    {
                    match(input,34,FOLLOW_34_in_objCClassDef796); if (state.failed) return struct;
                    categoryName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef800); if (state.failed) return struct;
                    match(input,35,FOLLOW_35_in_objCClassDef802); if (state.failed) return struct;
                    if ( state.backtracking==0 ) {

                      					struct.setCategoryName((categoryName!=null?categoryName.getText():null));
                      				
                    }

                    }


                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:555:3: 
                    {
                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:556:3: ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==36) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:557:4: '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>'
                    {
                    match(input,36,FOLLOW_36_in_objCClassDef825); if (state.failed) return struct;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:557:8: (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==IDENTIFIER) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:558:5: p1= IDENTIFIER ( ',' px= IDENTIFIER )*
                            {
                            p1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef835); if (state.failed) return struct;
                            if ( state.backtracking==0 ) {
                               struct.addProtocol(new SimpleIdentifier((p1!=null?p1.getText():null))); 
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:559:5: ( ',' px= IDENTIFIER )*
                            loop15:
                            do {
                                int alt15=2;
                                int LA15_0 = input.LA(1);

                                if ( (LA15_0==28) ) {
                                    alt15=1;
                                }


                                switch (alt15) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:560:6: ',' px= IDENTIFIER
                            	    {
                            	    match(input,28,FOLLOW_28_in_objCClassDef850); if (state.failed) return struct;
                            	    px=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef860); if (state.failed) return struct;
                            	    if ( state.backtracking==0 ) {
                            	       struct.addProtocol(new SimpleIdentifier((px!=null?px.getText():null))); 
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop15;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,37,FOLLOW_37_in_objCClassDef877); if (state.failed) return struct;

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:565:3: ( '{' ( '@public' | '@private' | '@protected' | ( functionPointerOrSimpleVarDecl ';' ) )* '}' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==23) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:566:4: '{' ( '@public' | '@private' | '@protected' | ( functionPointerOrSimpleVarDecl ';' ) )* '}'
                    {
                    match(input,23,FOLLOW_23_in_objCClassDef891); if (state.failed) return struct;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:567:4: ( '@public' | '@private' | '@protected' | ( functionPointerOrSimpleVarDecl ';' ) )*
                    loop18:
                    do {
                        int alt18=5;
                        switch ( input.LA(1) ) {
                        case 38:
                            {
                            alt18=1;
                            }
                            break;
                        case 39:
                            {
                            alt18=2;
                            }
                            break;
                        case 40:
                            {
                            alt18=3;
                            }
                            break;
                        case IDENTIFIER:
                        case 25:
                        case 30:
                        case 34:
                        case 45:
                        case 50:
                        case 51:
                        case 53:
                        case 54:
                        case 55:
                        case 58:
                        case 60:
                            {
                            alt18=4;
                            }
                            break;

                        }

                        switch (alt18) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:568:5: '@public'
                    	    {
                    	    match(input,38,FOLLOW_38_in_objCClassDef902); if (state.failed) return struct;
                    	    if ( state.backtracking==0 ) {
                    	       struct.setNextMemberVisibility(Struct.MemberVisibility.Public); 
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:569:5: '@private'
                    	    {
                    	    match(input,39,FOLLOW_39_in_objCClassDef913); if (state.failed) return struct;
                    	    if ( state.backtracking==0 ) {
                    	       struct.setNextMemberVisibility(Struct.MemberVisibility.Private); 
                    	    }

                    	    }
                    	    break;
                    	case 3 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:570:5: '@protected'
                    	    {
                    	    match(input,40,FOLLOW_40_in_objCClassDef924); if (state.failed) return struct;
                    	    if ( state.backtracking==0 ) {
                    	       struct.setNextMemberVisibility(Struct.MemberVisibility.Protected); 
                    	    }

                    	    }
                    	    break;
                    	case 4 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:571:5: ( functionPointerOrSimpleVarDecl ';' )
                    	    {
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:571:5: ( functionPointerOrSimpleVarDecl ';' )
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:572:6: functionPointerOrSimpleVarDecl ';'
                    	    {
                    	    pushFollow(FOLLOW_functionPointerOrSimpleVarDecl_in_objCClassDef941);
                    	    functionPointerOrSimpleVarDecl9=functionPointerOrSimpleVarDecl();

                    	    state._fsp--;
                    	    if (state.failed) return struct;
                    	    match(input,25,FOLLOW_25_in_objCClassDef943); if (state.failed) return struct;
                    	    if ( state.backtracking==0 ) {

                    	      						struct.addDeclaration(functionPointerOrSimpleVarDecl9);
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    match(input,24,FOLLOW_24_in_objCClassDef963); if (state.failed) return struct;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               struct.setNextMemberVisibility(Struct.MemberVisibility.Public); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:580:3: ( objCMethodDecl | objCPropertyDecl | typeDef | vd= varDecl ';' {...}?)*
            loop20:
            do {
                int alt20=5;
                switch ( input.LA(1) ) {
                case 43:
                case 44:
                    {
                    alt20=1;
                    }
                    break;
                case 42:
                    {
                    alt20=2;
                    }
                    break;
                case 59:
                    {
                    alt20=3;
                    }
                    break;
                case IDENTIFIER:
                case 25:
                case 30:
                case 34:
                case 45:
                case 50:
                case 51:
                case 53:
                case 54:
                case 55:
                case 58:
                case 60:
                    {
                    alt20=4;
                    }
                    break;

                }

                switch (alt20) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:581:4: objCMethodDecl
            	    {
            	    pushFollow(FOLLOW_objCMethodDecl_in_objCClassDef981);
            	    objCMethodDecl10=objCMethodDecl();

            	    state._fsp--;
            	    if (state.failed) return struct;
            	    if ( state.backtracking==0 ) {
            	       
            	      				struct.addDeclaration(objCMethodDecl10); 
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:584:4: objCPropertyDecl
            	    {
            	    pushFollow(FOLLOW_objCPropertyDecl_in_objCClassDef990);
            	    objCPropertyDecl11=objCPropertyDecl();

            	    state._fsp--;
            	    if (state.failed) return struct;
            	    if ( state.backtracking==0 ) {

            	      				struct.addDeclaration(objCPropertyDecl11); 
            	      			
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:587:4: typeDef
            	    {
            	    pushFollow(FOLLOW_typeDef_in_objCClassDef999);
            	    typeDef12=typeDef();

            	    state._fsp--;
            	    if (state.failed) return struct;
            	    if ( state.backtracking==0 ) {

            	      				struct.addDeclaration(typeDef12); 
            	      			
            	    }

            	    }
            	    break;
            	case 4 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:590:4: vd= varDecl ';' {...}?
            	    {
            	    pushFollow(FOLLOW_varDecl_in_objCClassDef1010);
            	    vd=varDecl();

            	    state._fsp--;
            	    if (state.failed) return struct;
            	    match(input,25,FOLLOW_25_in_objCClassDef1012); if (state.failed) return struct;
            	    if ( !(( !(vd instanceof VariablesDeclaration) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return struct;}
            	        throw new FailedPredicateException(input, "objCClassDef", " !($vd.decl instanceof VariablesDeclaration) ");
            	    }
            	    if ( state.backtracking==0 ) {

            	      				struct.addDeclaration(vd);
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            match(input,41,FOLLOW_41_in_objCClassDef1025); if (state.failed) return struct;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, objCClassDef_StartIndex); }
        }
        return struct;
    }
    // $ANTLR end "objCClassDef"


    // $ANTLR start "functionPointerOrSimpleVarDecl"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:597:1: functionPointerOrSimpleVarDecl returns [Declaration decl] : (fv= varDecl | functionPointerVarDecl );
    public final Declaration functionPointerOrSimpleVarDecl() throws RecognitionException {
        Declaration decl = null;
        int functionPointerOrSimpleVarDecl_StartIndex = input.index();
        VariablesDeclaration fv = null;

        Declaration functionPointerVarDecl13 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return decl; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:598:2: (fv= varDecl | functionPointerVarDecl )
            int alt21=2;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:599:3: fv= varDecl
                    {
                    pushFollow(FOLLOW_varDecl_in_functionPointerOrSimpleVarDecl1050);
                    fv=varDecl();

                    state._fsp--;
                    if (state.failed) return decl;
                    if ( state.backtracking==0 ) {

                      			decl = fv;
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:602:3: functionPointerVarDecl
                    {
                    pushFollow(FOLLOW_functionPointerVarDecl_in_functionPointerOrSimpleVarDecl1058);
                    functionPointerVarDecl13=functionPointerVarDecl();

                    state._fsp--;
                    if (state.failed) return decl;
                    if ( state.backtracking==0 ) {
                       
                      			decl = functionPointerVarDecl13; 
                      		
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, functionPointerOrSimpleVarDecl_StartIndex); }
        }
        return decl;
    }
    // $ANTLR end "functionPointerOrSimpleVarDecl"


    // $ANTLR start "objCPropertyDecl"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:607:1: objCPropertyDecl returns [Property property] : '@property' functionPointerOrSimpleVarDecl ';' ;
    public final Property objCPropertyDecl() throws RecognitionException {
        Property property = null;
        int objCPropertyDecl_StartIndex = input.index();
        Declaration functionPointerOrSimpleVarDecl14 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return property; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:608:2: ( '@property' functionPointerOrSimpleVarDecl ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:609:3: '@property' functionPointerOrSimpleVarDecl ';'
            {
            match(input,42,FOLLOW_42_in_objCPropertyDecl1082); if (state.failed) return property;
            pushFollow(FOLLOW_functionPointerOrSimpleVarDecl_in_objCPropertyDecl1084);
            functionPointerOrSimpleVarDecl14=functionPointerOrSimpleVarDecl();

            state._fsp--;
            if (state.failed) return property;
            match(input,25,FOLLOW_25_in_objCPropertyDecl1086); if (state.failed) return property;
            if ( state.backtracking==0 ) {

              			property = new Property(functionPointerOrSimpleVarDecl14);
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, objCPropertyDecl_StartIndex); }
        }
        return property;
    }
    // $ANTLR end "objCPropertyDecl"


    // $ANTLR start "objCMethodDecl"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:614:1: objCMethodDecl returns [Function function] : tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= mutableTypeRef )? ')' )? methodName= ( IDENTIFIER | 'class' ) ( ':' '(' argType1= mutableTypeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';' ;
    public final Function objCMethodDecl() throws RecognitionException {
        Function function = null;
        int objCMethodDecl_StartIndex = input.index();
        Token tp=null;
        Token tm=null;
        Token tk=null;
        Token methodName=null;
        Token argName1=null;
        Token sel=null;
        Token argName=null;
        TypeRef returnTypeRef = null;

        TypeRef argType1 = null;

        TypeRef argType = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return function; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:615:2: (tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= mutableTypeRef )? ')' )? methodName= ( IDENTIFIER | 'class' ) ( ':' '(' argType1= mutableTypeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:615:4: tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= mutableTypeRef )? ')' )? methodName= ( IDENTIFIER | 'class' ) ( ':' '(' argType1= mutableTypeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';'
            {
            if ( state.backtracking==0 ) {
               	
              			function = new Function(); 
              			function.setType(Function.Type.ObjCMethod);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:619:6: (tp= '+' | tm= '-' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==43) ) {
                alt22=1;
            }
            else if ( (LA22_0==44) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return function;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:620:4: tp= '+'
                    {
                    tp=(Token)match(input,43,FOLLOW_43_in_objCMethodDecl1117); if (state.failed) return function;
                    if ( state.backtracking==0 ) {
                       
                      				function.addModifiers(Modifier.Static); 
                      				function = mark(function, getLine(tp)); 
                      				function.setCommentBefore(getCommentBefore(tp.getTokenIndex()));
                      			
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:625:4: tm= '-'
                    {
                    tm=(Token)match(input,44,FOLLOW_44_in_objCMethodDecl1129); if (state.failed) return function;
                    if ( state.backtracking==0 ) {

                      				function = mark(function, getLine(tm)); 
                      				function.setCommentBefore(getCommentBefore(tm.getTokenIndex()));
                      			
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:630:3: ( '(' (returnTypeRef= mutableTypeRef )? ')' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==34) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:632:4: '(' (returnTypeRef= mutableTypeRef )? ')'
                    {
                    match(input,34,FOLLOW_34_in_objCMethodDecl1148); if (state.failed) return function;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:633:18: (returnTypeRef= mutableTypeRef )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==IDENTIFIER||LA23_0==30||LA23_0==34||LA23_0==45||(LA23_0>=50 && LA23_0<=51)||(LA23_0>=53 && LA23_0<=55)||LA23_0==60) ) {
                        alt23=1;
                    }
                    else if ( (LA23_0==35) ) {
                        int LA23_2 = input.LA(2);

                        if ( (synpred39_ObjCpp()) ) {
                            alt23=1;
                        }
                    }
                    switch (alt23) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: returnTypeRef= mutableTypeRef
                            {
                            pushFollow(FOLLOW_mutableTypeRef_in_objCMethodDecl1156);
                            returnTypeRef=mutableTypeRef();

                            state._fsp--;
                            if (state.failed) return function;

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       
                      					function.setValueType(returnTypeRef); 
                      				
                    }
                    match(input,35,FOLLOW_35_in_objCMethodDecl1164); if (state.failed) return function;

                    }
                    break;

            }

            methodName=(Token)input.LT(1);
            if ( input.LA(1)==IDENTIFIER||input.LA(1)==45 ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return function;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
               
              			function.setName(new SimpleIdentifier((methodName!=null?methodName.getText():null))); 
              			function.setCommentAfter(getCommentAfterOnSameLine(methodName.getTokenIndex()));
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:642:3: ( ':' '(' argType1= mutableTypeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==33) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:643:4: ':' '(' argType1= mutableTypeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )* ( ',' '...' )?
                    {
                    match(input,33,FOLLOW_33_in_objCMethodDecl1193); if (state.failed) return function;
                    match(input,34,FOLLOW_34_in_objCMethodDecl1195); if (state.failed) return function;
                    pushFollow(FOLLOW_mutableTypeRef_in_objCMethodDecl1199);
                    argType1=mutableTypeRef();

                    state._fsp--;
                    if (state.failed) return function;
                    match(input,35,FOLLOW_35_in_objCMethodDecl1201); if (state.failed) return function;
                    argName1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1205); if (state.failed) return function;
                    if ( state.backtracking==0 ) {

                      				Arg arg = new Arg((argName1!=null?argName1.getText():null), argType1);
                      				arg.setSelector((methodName!=null?methodName.getText():null));
                      				function.addArg(arg);
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:648:4: (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==IDENTIFIER) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:649:5: sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER
                    	    {
                    	    sel=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1220); if (state.failed) return function;
                    	    match(input,33,FOLLOW_33_in_objCMethodDecl1222); if (state.failed) return function;
                    	    match(input,34,FOLLOW_34_in_objCMethodDecl1229); if (state.failed) return function;
                    	    pushFollow(FOLLOW_mutableTypeRef_in_objCMethodDecl1233);
                    	    argType=mutableTypeRef();

                    	    state._fsp--;
                    	    if (state.failed) return function;
                    	    match(input,35,FOLLOW_35_in_objCMethodDecl1235); if (state.failed) return function;
                    	    argName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1244); if (state.failed) return function;
                    	    if ( state.backtracking==0 ) {

                    	      					Arg arg = new Arg((argName!=null?argName.getText():null), argType);
                    	      					arg.setSelector((sel!=null?sel.getText():null));
                    	      					function.addArg(arg);
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:657:4: ( ',' '...' )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==28) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:658:5: ',' '...'
                            {
                            match(input,28,FOLLOW_28_in_objCMethodDecl1263); if (state.failed) return function;
                            match(input,46,FOLLOW_46_in_objCMethodDecl1265); if (state.failed) return function;
                            if ( state.backtracking==0 ) {

                              					function.addArg(Arg.createVarArgs());
                              				
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            match(input,25,FOLLOW_25_in_objCMethodDecl1282); if (state.failed) return function;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, objCMethodDecl_StartIndex); }
        }
        return function;
    }
    // $ANTLR end "objCMethodDecl"


    // $ANTLR start "structBody"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:666:1: structBody returns [Struct struct] : '{' ( ( 'public' | 'private' | 'protected' ) ':' | {...}? IDENTIFIER friend= declaration ';' | decl= declaration | fv= varDecl ';' )* '}' ;
    public final Struct structBody() throws RecognitionException {
        Struct struct = null;
        int structBody_StartIndex = input.index();
        ObjCppParser.declaration_return friend = null;

        ObjCppParser.declaration_return decl = null;

        VariablesDeclaration fv = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return struct; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:667:2: ( '{' ( ( 'public' | 'private' | 'protected' ) ':' | {...}? IDENTIFIER friend= declaration ';' | decl= declaration | fv= varDecl ';' )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:668:3: '{' ( ( 'public' | 'private' | 'protected' ) ':' | {...}? IDENTIFIER friend= declaration ';' | decl= declaration | fv= varDecl ';' )* '}'
            {
            if ( state.backtracking==0 ) {
               
              			struct = new Struct();
              			struct.setForwardDeclaration(false); 
              		
            }
            match(input,23,FOLLOW_23_in_structBody1303); if (state.failed) return struct;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:673:4: ( ( 'public' | 'private' | 'protected' ) ':' | {...}? IDENTIFIER friend= declaration ';' | decl= declaration | fv= varDecl ';' )*
            loop29:
            do {
                int alt29=5;
                alt29 = dfa29.predict(input);
                switch (alt29) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:674:5: ( 'public' | 'private' | 'protected' ) ':'
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:674:5: ( 'public' | 'private' | 'protected' )
            	    int alt28=3;
            	    switch ( input.LA(1) ) {
            	    case 47:
            	        {
            	        alt28=1;
            	        }
            	        break;
            	    case 48:
            	        {
            	        alt28=2;
            	        }
            	        break;
            	    case 49:
            	        {
            	        alt28=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return struct;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 28, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt28) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:675:6: 'public'
            	            {
            	            match(input,47,FOLLOW_47_in_structBody1321); if (state.failed) return struct;
            	            if ( state.backtracking==0 ) {
            	               struct.setNextMemberVisibility(Struct.MemberVisibility.Public); 
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:676:6: 'private'
            	            {
            	            match(input,48,FOLLOW_48_in_structBody1333); if (state.failed) return struct;
            	            if ( state.backtracking==0 ) {
            	               struct.setNextMemberVisibility(Struct.MemberVisibility.Private); 
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:677:6: 'protected'
            	            {
            	            match(input,49,FOLLOW_49_in_structBody1345); if (state.failed) return struct;
            	            if ( state.backtracking==0 ) {
            	               struct.setNextMemberVisibility(Struct.MemberVisibility.Protected); 
            	            }

            	            }
            	            break;

            	    }

            	    match(input,33,FOLLOW_33_in_structBody1356); if (state.failed) return struct;

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:679:5: {...}? IDENTIFIER friend= declaration ';'
            	    {
            	    if ( !(( next("friend") )) ) {
            	        if (state.backtracking>0) {state.failed=true; return struct;}
            	        throw new FailedPredicateException(input, "structBody", " next(\"friend\") ");
            	    }
            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_structBody1366); if (state.failed) return struct;
            	    pushFollow(FOLLOW_declaration_in_structBody1370);
            	    friend=declaration();

            	    state._fsp--;
            	    if (state.failed) return struct;
            	    match(input,25,FOLLOW_25_in_structBody1372); if (state.failed) return struct;
            	    if ( state.backtracking==0 ) {

            	      					for (Declaration d : (friend!=null?friend.declarations:null))
            	      						struct.addDeclaration(new FriendDeclaration(d));
            	      				
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:683:5: decl= declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_structBody1384);
            	    decl=declaration();

            	    state._fsp--;
            	    if (state.failed) return struct;
            	    if ( state.backtracking==0 ) {

            	      					struct.addDeclarations((decl!=null?decl.declarations:null));
            	      				
            	    }

            	    }
            	    break;
            	case 4 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:686:5: fv= varDecl ';'
            	    {
            	    pushFollow(FOLLOW_varDecl_in_structBody1396);
            	    fv=varDecl();

            	    state._fsp--;
            	    if (state.failed) return struct;
            	    match(input,25,FOLLOW_25_in_structBody1398); if (state.failed) return struct;
            	    if ( state.backtracking==0 ) {

            	      					struct.addDeclaration(fv);
            	      				
            	    }

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            match(input,24,FOLLOW_24_in_structBody1410); if (state.failed) return struct;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, structBody_StartIndex); }
        }
        return struct;
    }
    // $ANTLR end "structBody"


    // $ANTLR start "structCore"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:693:1: structCore returns [Struct struct] : typeToken= ( 'struct' | 'union' | 'class' ) (m1= modifiers (ab= structBody | tag= qualifiedIdentifier ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | ) ) ) ;
    public final Struct structCore() throws RecognitionException {
        Symbols_stack.push(new Symbols_scope());

        Struct struct = null;
        int structCore_StartIndex = input.index();
        Token typeToken=null;
        List<Modifier> m1 = null;

        Struct ab = null;

        ObjCppParser.qualifiedIdentifier_return tag = null;

        List<Modifier> m2 = null;

        ObjCppParser.qualifiedIdentifier_return parent = null;

        Struct nb = null;



        	((Symbols_scope)Symbols_stack.peek()).typeIdentifiers = new HashSet<String>();
        	List<Modifier> modifiers = new ArrayList<Modifier>();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return struct; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:717:2: (typeToken= ( 'struct' | 'union' | 'class' ) (m1= modifiers (ab= structBody | tag= qualifiedIdentifier ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | ) ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:720:3: typeToken= ( 'struct' | 'union' | 'class' ) (m1= modifiers (ab= structBody | tag= qualifiedIdentifier ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | ) ) )
            {
            typeToken=(Token)input.LT(1);
            if ( input.LA(1)==45||(input.LA(1)>=50 && input.LA(1)<=51) ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return struct;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:721:3: (m1= modifiers (ab= structBody | tag= qualifiedIdentifier ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:722:4: m1= modifiers (ab= structBody | tag= qualifiedIdentifier ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | ) )
            {
            pushFollow(FOLLOW_modifiers_in_structCore1478);
            m1=modifiers();

            state._fsp--;
            if (state.failed) return struct;
            if ( state.backtracking==0 ) {
               modifiers.addAll(m1); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:723:4: (ab= structBody | tag= qualifiedIdentifier ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==23) ) {
                alt33=1;
            }
            else if ( (LA33_0==IDENTIFIER) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return struct;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:724:5: ab= structBody
                    {
                    pushFollow(FOLLOW_structBody_in_structCore1493);
                    ab=structBody();

                    state._fsp--;
                    if (state.failed) return struct;
                    if ( state.backtracking==0 ) {

                      					struct = ab;
                      					struct.setForwardDeclaration(false);
                      				
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:728:5: tag= qualifiedIdentifier ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | )
                    {
                    pushFollow(FOLLOW_qualifiedIdentifier_in_structCore1505);
                    tag=qualifiedIdentifier();

                    state._fsp--;
                    if (state.failed) return struct;
                    if ( state.backtracking==0 ) {

                      					defineTypeIdentifierInParentScope((tag!=null?tag.identifier:null));
                      				
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:731:5: ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | )
                    int alt32=2;
                    alt32 = dfa32.predict(input);
                    switch (alt32) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:732:6: (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody )
                            {
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:732:6: (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody )
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:733:7: m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody
                            {
                            pushFollow(FOLLOW_modifiers_in_structCore1530);
                            m2=modifiers();

                            state._fsp--;
                            if (state.failed) return struct;
                            if ( state.backtracking==0 ) {
                               modifiers.addAll(m2); 
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:734:7: ( ':' ( 'public' )? parent= qualifiedIdentifier )?
                            int alt31=2;
                            int LA31_0 = input.LA(1);

                            if ( (LA31_0==33) ) {
                                alt31=1;
                            }
                            switch (alt31) {
                                case 1 :
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:735:8: ':' ( 'public' )? parent= qualifiedIdentifier
                                    {
                                    match(input,33,FOLLOW_33_in_structCore1549); if (state.failed) return struct;
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:736:8: ( 'public' )?
                                    int alt30=2;
                                    int LA30_0 = input.LA(1);

                                    if ( (LA30_0==47) ) {
                                        alt30=1;
                                    }
                                    switch (alt30) {
                                        case 1 :
                                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: 'public'
                                            {
                                            match(input,47,FOLLOW_47_in_structCore1558); if (state.failed) return struct;

                                            }
                                            break;

                                    }

                                    pushFollow(FOLLOW_qualifiedIdentifier_in_structCore1570);
                                    parent=qualifiedIdentifier();

                                    state._fsp--;
                                    if (state.failed) return struct;

                                    }
                                    break;

                            }

                            pushFollow(FOLLOW_structBody_in_structCore1590);
                            nb=structBody();

                            state._fsp--;
                            if (state.failed) return struct;
                            if ( state.backtracking==0 ) {

                              							struct = nb;
                              							struct.setForwardDeclaration(false);
                              							if ((parent!=null?input.toString(parent.start,parent.stop):null) != null)
                              								struct.addParent((parent!=null?parent.identifier:null));
                              						
                            }

                            }


                            }
                            break;
                        case 2 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:745:10: 
                            {
                            if ( state.backtracking==0 ) {

                              						struct = new Struct();
                              						struct.setForwardDeclaration(true);
                              					
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      					struct.setTag((tag!=null?tag.identifier:null));
                      				
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	struct = mark(struct, getLine(typeToken)); 
              	struct.setType(
              		(typeToken!=null?typeToken.getText():null).equals("struct") ?	Struct.Type.CStruct :
              		(typeToken!=null?typeToken.getText():null).equals("union") ?	Struct.Type.CUnion :
              						Struct.Type.CPPClass
              	);
              	
              	Function.Type forcedType = null;
              	if (struct.getType() == Struct.Type.CPPClass)
              		forcedType = Function.Type.CppMethod;
              	
              	if (forcedType != null)
              	for (Declaration d : struct.getDeclarations()) {
              		if (d instanceof Function)
              			((Function)d).setType(forcedType);
              	}

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, structCore_StartIndex); }
            Symbols_stack.pop();

        }
        return struct;
    }
    // $ANTLR end "structCore"


    // $ANTLR start "anyOp"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:756:1: anyOp returns [java.lang.Enum<?> op] : ( binaryOp | unaryOp | assignmentOp );
    public final java.lang.Enum<?> anyOp() throws RecognitionException {
        java.lang.Enum<?> op = null;
        int anyOp_StartIndex = input.index();
        Expression.BinaryOperator binaryOp15 = null;

        Expression.UnaryOperator unaryOp16 = null;

        ObjCppParser.assignmentOp_return assignmentOp17 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return op; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:757:2: ( binaryOp | unaryOp | assignmentOp )
            int alt34=3;
            switch ( input.LA(1) ) {
            case 44:
            case 53:
            case 54:
                {
                int LA34_1 = input.LA(2);

                if ( (synpred57_ObjCpp()) ) {
                    alt34=1;
                }
                else if ( (synpred58_ObjCpp()) ) {
                    alt34=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return op;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 1, input);

                    throw nvae;
                }
                }
                break;
            case 36:
            case 37:
            case 43:
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
                alt34=1;
                }
                break;
            case 74:
            case 89:
            case 90:
            case 91:
                {
                alt34=2;
                }
                break;
            case 29:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
                {
                alt34=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return op;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:757:4: binaryOp
                    {
                    pushFollow(FOLLOW_binaryOp_in_anyOp1638);
                    binaryOp15=binaryOp();

                    state._fsp--;
                    if (state.failed) return op;
                    if ( state.backtracking==0 ) {
                       op = binaryOp15; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:758:3: unaryOp
                    {
                    pushFollow(FOLLOW_unaryOp_in_anyOp1647);
                    unaryOp16=unaryOp();

                    state._fsp--;
                    if (state.failed) return op;
                    if ( state.backtracking==0 ) {
                       op = unaryOp16; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:759:3: assignmentOp
                    {
                    pushFollow(FOLLOW_assignmentOp_in_anyOp1656);
                    assignmentOp17=assignmentOp();

                    state._fsp--;
                    if (state.failed) return op;
                    if ( state.backtracking==0 ) {
                       op = (assignmentOp17!=null?assignmentOp17.op:null); 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, anyOp_StartIndex); }
        }
        return op;
    }
    // $ANTLR end "anyOp"

    public static class functionDeclaration_return extends ParserRuleReturnScope {
        public Function function;
    };

    // $ANTLR start "functionDeclaration"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:763:1: functionDeclaration returns [Function function] : preMods1= modifiers (returnTypeRef= mutableTypeRef )? preMods2= modifiers name= qualifiedCppFunctionName argList postMods= modifiers ( ':' i1= constructorInitializer ( ',' ix= constructorInitializer )* )? ( ';' | statementsBlock ) ;
    public final ObjCppParser.functionDeclaration_return functionDeclaration() throws RecognitionException {
        Symbols_stack.push(new Symbols_scope());

        ObjCppParser.functionDeclaration_return retval = new ObjCppParser.functionDeclaration_return();
        retval.start = input.LT(1);
        int functionDeclaration_StartIndex = input.index();
        List<Modifier> preMods1 = null;

        TypeRef returnTypeRef = null;

        List<Modifier> preMods2 = null;

        Identifier name = null;

        List<Modifier> postMods = null;

        FunctionCall i1 = null;

        FunctionCall ix = null;

        ObjCppParser.argList_return argList18 = null;

        Block statementsBlock19 = null;



        	((Symbols_scope)Symbols_stack.peek()).typeIdentifiers = new HashSet<String>();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:768:2: (preMods1= modifiers (returnTypeRef= mutableTypeRef )? preMods2= modifiers name= qualifiedCppFunctionName argList postMods= modifiers ( ':' i1= constructorInitializer ( ',' ix= constructorInitializer )* )? ( ';' | statementsBlock ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:768:4: preMods1= modifiers (returnTypeRef= mutableTypeRef )? preMods2= modifiers name= qualifiedCppFunctionName argList postMods= modifiers ( ':' i1= constructorInitializer ( ',' ix= constructorInitializer )* )? ( ';' | statementsBlock )
            {
            if ( state.backtracking==0 ) {
               	
              			retval.function = mark(new Function(), -1);
              			retval.function.setType(Function.Type.CFunction);
              		
            }
            pushFollow(FOLLOW_modifiers_in_functionDeclaration1691);
            preMods1=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               retval.function.addModifiers(preMods1); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:773:16: (returnTypeRef= mutableTypeRef )?
            int alt35=2;
            switch ( input.LA(1) ) {
                case IDENTIFIER:
                    {
                    int LA35_1 = input.LA(2);

                    if ( ((synpred59_ObjCpp()||(synpred59_ObjCpp()&&( next("extern") ))||(synpred59_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred59_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||(synpred59_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred59_ObjCpp()&&( next("__pragma") ))||(synpred59_ObjCpp()&&( next("__success") )))) ) {
                        alt35=1;
                    }
                    }
                    break;
                case 30:
                case 34:
                case 45:
                case 50:
                case 51:
                case 53:
                case 54:
                case 55:
                case 60:
                    {
                    alt35=1;
                    }
                    break;
                case 74:
                    {
                    int LA35_3 = input.LA(2);

                    if ( (synpred59_ObjCpp()) ) {
                        alt35=1;
                    }
                    }
                    break;
            }

            switch (alt35) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: returnTypeRef= mutableTypeRef
                    {
                    pushFollow(FOLLOW_mutableTypeRef_in_functionDeclaration1699);
                    returnTypeRef=mutableTypeRef();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               
              			retval.function.setValueType(returnTypeRef); 
              		
            }
            pushFollow(FOLLOW_modifiers_in_functionDeclaration1708);
            preMods2=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               retval.function.addModifiers(preMods2); 
            }
            pushFollow(FOLLOW_qualifiedCppFunctionName_in_functionDeclaration1716);
            name=qualifiedCppFunctionName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {

              			retval.function.setName(name); 
              			mark(retval.function, getLine(((Token)retval.start)));
              			//retval.function.setElementFile($functionName.file);
              			//retval.function.setElementLine($functionName.line);
              		
            }
            pushFollow(FOLLOW_argList_in_functionDeclaration1722);
            argList18=argList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {

              			retval.function.setArgs((argList18!=null?argList18.args:null));
              		
            }
            pushFollow(FOLLOW_modifiers_in_functionDeclaration1730);
            postMods=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               retval.function.addModifiers(postMods); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:787:3: ( ':' i1= constructorInitializer ( ',' ix= constructorInitializer )* )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==33) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:788:4: ':' i1= constructorInitializer ( ',' ix= constructorInitializer )*
                    {
                    match(input,33,FOLLOW_33_in_functionDeclaration1741); if (state.failed) return retval;
                    pushFollow(FOLLOW_constructorInitializer_in_functionDeclaration1748);
                    i1=constructorInitializer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.function.addInitializer(i1); 
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:790:4: ( ',' ix= constructorInitializer )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==28) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:791:5: ',' ix= constructorInitializer
                    	    {
                    	    match(input,28,FOLLOW_28_in_functionDeclaration1761); if (state.failed) return retval;
                    	    pushFollow(FOLLOW_constructorInitializer_in_functionDeclaration1765);
                    	    ix=constructorInitializer();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	       retval.function.addInitializer(ix); 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);


                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:794:3: ( ';' | statementsBlock )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==25) ) {
                alt38=1;
            }
            else if ( (LA38_0==23) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:795:4: ';'
                    {
                    match(input,25,FOLLOW_25_in_functionDeclaration1788); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:796:4: statementsBlock
                    {
                    pushFollow(FOLLOW_statementsBlock_in_functionDeclaration1795);
                    statementsBlock19=statementsBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      				retval.function.setBody(statementsBlock19);
                      			
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, functionDeclaration_StartIndex); }
            Symbols_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "functionDeclaration"


    // $ANTLR start "constructorInitializer"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:802:1: constructorInitializer returns [FunctionCall init] : qn= qualifiedCppFunctionName '(' (el= topLevelExprList )? ')' ;
    public final FunctionCall constructorInitializer() throws RecognitionException {
        FunctionCall init = null;
        int constructorInitializer_StartIndex = input.index();
        Identifier qn = null;

        List<Expression> el = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return init; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:803:2: (qn= qualifiedCppFunctionName '(' (el= topLevelExprList )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:803:4: qn= qualifiedCppFunctionName '(' (el= topLevelExprList )? ')'
            {
            pushFollow(FOLLOW_qualifiedCppFunctionName_in_constructorInitializer1818);
            qn=qualifiedCppFunctionName();

            state._fsp--;
            if (state.failed) return init;
            if ( state.backtracking==0 ) {

              			init = new FunctionCall(new TypeRefExpression(new SimpleTypeRef(qn)));
              		
            }
            match(input,34,FOLLOW_34_in_constructorInitializer1826); if (state.failed) return init;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:806:7: (el= topLevelExprList )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=DECIMAL_NUMBER && LA39_0<=FLOAT_NUMBER)||LA39_0==31||LA39_0==34||(LA39_0>=43 && LA39_0<=44)||(LA39_0>=53 && LA39_0<=55)||(LA39_0>=74 && LA39_0<=76)||(LA39_0>=89 && LA39_0<=91)) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:807:4: el= topLevelExprList
                    {
                    pushFollow(FOLLOW_topLevelExprList_in_constructorInitializer1835);
                    el=topLevelExprList();

                    state._fsp--;
                    if (state.failed) return init;
                    if ( state.backtracking==0 ) {
                       init.addArguments(el); 
                    }

                    }
                    break;

            }

            match(input,35,FOLLOW_35_in_constructorInitializer1844); if (state.failed) return init;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, constructorInitializer_StartIndex); }
        }
        return init;
    }
    // $ANTLR end "constructorInitializer"


    // $ANTLR start "modifiers"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:811:1: modifiers returns [List<Modifier> modifiers] : ( modifier )* ;
    public final List<Modifier> modifiers() throws RecognitionException {
        List<Modifier> modifiers = null;
        int modifiers_StartIndex = input.index();
        ObjCppParser.modifier_return modifier20 = null;


         modifiers = new ArrayList<Modifier>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return modifiers; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:813:2: ( ( modifier )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:813:5: ( modifier )*
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:813:5: ( modifier )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==IDENTIFIER) ) {
                    int LA40_2 = input.LA(2);

                    if ( (((synpred64_ObjCpp()&&( next("__success") ))||(synpred64_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred64_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred64_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||(synpred64_ObjCpp()&&( next("__pragma") ))||(synpred64_ObjCpp()&&( next("extern") )))) ) {
                        alt40=1;
                    }


                }


                switch (alt40) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:813:7: modifier
            	    {
            	    pushFollow(FOLLOW_modifier_in_modifiers1868);
            	    modifier20=modifier();

            	    state._fsp--;
            	    if (state.failed) return modifiers;
            	    if ( state.backtracking==0 ) {
            	       modifiers.addAll((modifier20!=null?modifier20.modifiers:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, modifiers_StartIndex); }
        }
        return modifiers;
    }
    // $ANTLR end "modifiers"


    // $ANTLR start "pragmaContent"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:816:1: pragmaContent : IDENTIFIER '(' ( IDENTIFIER | constant | ',' | ':' | '(' ( IDENTIFIER | constant | ',' | ':' )* ')' )* ')' ( ';' )? ;
    public final void pragmaContent() throws RecognitionException {
        int pragmaContent_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return ; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:816:15: ( IDENTIFIER '(' ( IDENTIFIER | constant | ',' | ':' | '(' ( IDENTIFIER | constant | ',' | ':' )* ')' )* ')' ( ';' )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:819:4: IDENTIFIER '(' ( IDENTIFIER | constant | ',' | ':' | '(' ( IDENTIFIER | constant | ',' | ':' )* ')' )* ')' ( ';' )?
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_pragmaContent1894); if (state.failed) return ;
            match(input,34,FOLLOW_34_in_pragmaContent1896); if (state.failed) return ;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:820:5: ( IDENTIFIER | constant | ',' | ':' | '(' ( IDENTIFIER | constant | ',' | ':' )* ')' )*
            loop42:
            do {
                int alt42=6;
                switch ( input.LA(1) ) {
                case IDENTIFIER:
                    {
                    alt42=1;
                    }
                    break;
                case DECIMAL_NUMBER:
                case STRING:
                case HEXADECIMAL_NUMBER:
                case OCTAL_NUMBER:
                case CHARACTER:
                case FLOAT_NUMBER:
                case 43:
                case 44:
                    {
                    alt42=2;
                    }
                    break;
                case 28:
                    {
                    alt42=3;
                    }
                    break;
                case 33:
                    {
                    alt42=4;
                    }
                    break;
                case 34:
                    {
                    alt42=5;
                    }
                    break;

                }

                switch (alt42) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:820:6: IDENTIFIER
            	    {
            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_pragmaContent1903); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:820:19: constant
            	    {
            	    pushFollow(FOLLOW_constant_in_pragmaContent1907);
            	    constant();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;
            	case 3 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:820:30: ','
            	    {
            	    match(input,28,FOLLOW_28_in_pragmaContent1911); if (state.failed) return ;

            	    }
            	    break;
            	case 4 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:820:36: ':'
            	    {
            	    match(input,33,FOLLOW_33_in_pragmaContent1915); if (state.failed) return ;

            	    }
            	    break;
            	case 5 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:820:42: '(' ( IDENTIFIER | constant | ',' | ':' )* ')'
            	    {
            	    match(input,34,FOLLOW_34_in_pragmaContent1919); if (state.failed) return ;
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:820:46: ( IDENTIFIER | constant | ',' | ':' )*
            	    loop41:
            	    do {
            	        int alt41=5;
            	        switch ( input.LA(1) ) {
            	        case IDENTIFIER:
            	            {
            	            alt41=1;
            	            }
            	            break;
            	        case DECIMAL_NUMBER:
            	        case STRING:
            	        case HEXADECIMAL_NUMBER:
            	        case OCTAL_NUMBER:
            	        case CHARACTER:
            	        case FLOAT_NUMBER:
            	        case 43:
            	        case 44:
            	            {
            	            alt41=2;
            	            }
            	            break;
            	        case 28:
            	            {
            	            alt41=3;
            	            }
            	            break;
            	        case 33:
            	            {
            	            alt41=4;
            	            }
            	            break;

            	        }

            	        switch (alt41) {
            	    	case 1 :
            	    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:820:47: IDENTIFIER
            	    	    {
            	    	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_pragmaContent1922); if (state.failed) return ;

            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:820:60: constant
            	    	    {
            	    	    pushFollow(FOLLOW_constant_in_pragmaContent1926);
            	    	    constant();

            	    	    state._fsp--;
            	    	    if (state.failed) return ;

            	    	    }
            	    	    break;
            	    	case 3 :
            	    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:820:71: ','
            	    	    {
            	    	    match(input,28,FOLLOW_28_in_pragmaContent1930); if (state.failed) return ;

            	    	    }
            	    	    break;
            	    	case 4 :
            	    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:820:77: ':'
            	    	    {
            	    	    match(input,33,FOLLOW_33_in_pragmaContent1934); if (state.failed) return ;

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop41;
            	        }
            	    } while (true);

            	    match(input,35,FOLLOW_35_in_pragmaContent1938); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            match(input,35,FOLLOW_35_in_pragmaContent1945); if (state.failed) return ;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:822:4: ( ';' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==25) ) {
                int LA43_1 = input.LA(2);

                if ( (synpred74_ObjCpp()) ) {
                    alt43=1;
                }
            }
            switch (alt43) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: ';'
                    {
                    match(input,25,FOLLOW_25_in_pragmaContent1950); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, pragmaContent_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "pragmaContent"

    public static class modifier_return extends ParserRuleReturnScope {
        public List<Modifier> modifiers;
        public String asmName;
    };

    // $ANTLR start "modifier"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:826:1: modifier returns [List<Modifier> modifiers, String asmName] : ({...}? => pragmaContent | {...}? => IDENTIFIER ex= STRING | {...}?m= IDENTIFIER | {...}? => IDENTIFIER '(' 'return' binaryOp expression ')' | {...}? => IDENTIFIER '(' expression ')' | {...}? => IDENTIFIER '(' ( (an= STRING )* | extendedModifiers ) ')' );
    public final ObjCppParser.modifier_return modifier() throws RecognitionException {
        ObjCppParser.modifier_return retval = new ObjCppParser.modifier_return();
        retval.start = input.LT(1);
        int modifier_StartIndex = input.index();
        Token ex=null;
        Token m=null;
        Token an=null;
        List<Modifier> extendedModifiers21 = null;


         retval.modifiers = new ArrayList<Modifier>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:828:2: ({...}? => pragmaContent | {...}? => IDENTIFIER ex= STRING | {...}?m= IDENTIFIER | {...}? => IDENTIFIER '(' 'return' binaryOp expression ')' | {...}? => IDENTIFIER '(' expression ')' | {...}? => IDENTIFIER '(' ( (an= STRING )* | extendedModifiers ) ')' )
            int alt46=6;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==IDENTIFIER) ) {
                int LA46_1 = input.LA(2);

                if ( ((synpred75_ObjCpp()&&( next("__pragma") ))) ) {
                    alt46=1;
                }
                else if ( ((synpred76_ObjCpp()&&( next("extern") ))) ) {
                    alt46=2;
                }
                else if ( ((synpred77_ObjCpp()&&( Modifier.parseModifier(next()) != null ))) ) {
                    alt46=3;
                }
                else if ( ((synpred78_ObjCpp()&&( next("__success") ))) ) {
                    alt46=4;
                }
                else if ( ((synpred79_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))) ) {
                    alt46=5;
                }
                else if ( (( next("__declspec", "__attribute__", "__asm") )) ) {
                    alt46=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:830:3: {...}? => pragmaContent
                    {
                    if ( !(( next("__pragma") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "modifier", " next(\"__pragma\") ");
                    }
                    pushFollow(FOLLOW_pragmaContent_in_modifier1982);
                    pragmaContent();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:831:3: {...}? => IDENTIFIER ex= STRING
                    {
                    if ( !(( next("extern") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "modifier", " next(\"extern\") ");
                    }
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier1992); if (state.failed) return retval;
                    ex=(Token)match(input,STRING,FOLLOW_STRING_in_modifier1996); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      			retval.modifiers.add(Modifier.Extern); // TODO
                      		
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:834:3: {...}?m= IDENTIFIER
                    {
                    if ( !(( Modifier.parseModifier(next()) != null )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "modifier", " Modifier.parseModifier(next()) != null ");
                    }
                    m=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier2008); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      			retval.modifiers.add(Modifier.parseModifier((m!=null?m.getText():null)));
                      		
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:837:3: {...}? => IDENTIFIER '(' 'return' binaryOp expression ')'
                    {
                    if ( !(( next("__success") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "modifier", " next(\"__success\") ");
                    }
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier2021); if (state.failed) return retval;
                    match(input,34,FOLLOW_34_in_modifier2023); if (state.failed) return retval;
                    match(input,52,FOLLOW_52_in_modifier2025); if (state.failed) return retval;
                    pushFollow(FOLLOW_binaryOp_in_modifier2027);
                    binaryOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_modifier2029);
                    expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    match(input,35,FOLLOW_35_in_modifier2032); if (state.failed) return retval;

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:841:3: {...}? => IDENTIFIER '(' expression ')'
                    {
                    if ( !(( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "modifier", " next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ");
                    }
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier2049); if (state.failed) return retval;
                    match(input,34,FOLLOW_34_in_modifier2051); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_modifier2053);
                    expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    match(input,35,FOLLOW_35_in_modifier2055); if (state.failed) return retval;

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:844:3: {...}? => IDENTIFIER '(' ( (an= STRING )* | extendedModifiers ) ')'
                    {
                    if ( !(( next("__declspec", "__attribute__", "__asm") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "modifier", " next(\"__declspec\", \"__attribute__\", \"__asm\") ");
                    }
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier2069); if (state.failed) return retval;
                    match(input,34,FOLLOW_34_in_modifier2073); if (state.failed) return retval;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:846:7: ( (an= STRING )* | extendedModifiers )
                    int alt45=2;
                    switch ( input.LA(1) ) {
                    case STRING:
                        {
                        alt45=1;
                        }
                        break;
                    case 35:
                        {
                        int LA45_2 = input.LA(2);

                        if ( (synpred81_ObjCpp()) ) {
                            alt45=1;
                        }
                        else if ( (true) ) {
                            alt45=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 45, 2, input);

                            throw nvae;
                        }
                        }
                        break;
                    case IDENTIFIER:
                        {
                        alt45=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 45, 0, input);

                        throw nvae;
                    }

                    switch (alt45) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:847:4: (an= STRING )*
                            {
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:847:4: (an= STRING )*
                            loop44:
                            do {
                                int alt44=2;
                                int LA44_0 = input.LA(1);

                                if ( (LA44_0==STRING) ) {
                                    alt44=1;
                                }


                                switch (alt44) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:847:6: an= STRING
                            	    {
                            	    an=(Token)match(input,STRING,FOLLOW_STRING_in_modifier2084); if (state.failed) return retval;
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
                            	    break loop44;
                                }
                            } while (true);


                            }
                            break;
                        case 2 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:854:4: extendedModifiers
                            {
                            pushFollow(FOLLOW_extendedModifiers_in_modifier2096);
                            extendedModifiers21=extendedModifiers();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) {

                              				retval.modifiers.addAll(extendedModifiers21);
                              			
                            }

                            }
                            break;

                    }

                    match(input,35,FOLLOW_35_in_modifier2104); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, modifier_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "modifier"


    // $ANTLR start "extendedModifiers"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:861:1: extendedModifiers returns [List<Modifier> modifiers] : ({...}?m= IDENTIFIER () )* ;
    public final List<Modifier> extendedModifiers() throws RecognitionException {
        List<Modifier> modifiers = null;
        int extendedModifiers_StartIndex = input.index();
        Token m=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return modifiers; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:862:2: ( ({...}?m= IDENTIFIER () )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:862:4: ({...}?m= IDENTIFIER () )*
            {
            if ( state.backtracking==0 ) {
               modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:863:3: ({...}?m= IDENTIFIER () )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==IDENTIFIER) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:864:4: {...}?m= IDENTIFIER ()
            	    {
            	    if ( !(( next(Modifier.Kind.Extended) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return modifiers;}
            	        throw new FailedPredicateException(input, "extendedModifiers", " next(Modifier.Kind.Extended) ");
            	    }
            	    m=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_extendedModifiers2133); if (state.failed) return modifiers;
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:865:4: ()
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:866:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					modifiers.add(Modifier.parseModifier((m!=null?m.getText():null)));
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 22, extendedModifiers_StartIndex); }
        }
        return modifiers;
    }
    // $ANTLR end "extendedModifiers"

    public static class argDef_return extends ParserRuleReturnScope {
        public Arg arg;
    };

    // $ANTLR start "argDef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:876:1: argDef returns [Arg arg] : ( (tr= mutableTypeRef ) ( ( declarator )? ) ( '=' dv= topLevelExpr )? | '...' );
    public final ObjCppParser.argDef_return argDef() throws RecognitionException {
        ObjCppParser.argDef_return retval = new ObjCppParser.argDef_return();
        retval.start = input.LT(1);
        int argDef_StartIndex = input.index();
        TypeRef tr = null;

        ObjCppParser.topLevelExpr_return dv = null;

        Declarator declarator22 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return retval; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:877:2: ( (tr= mutableTypeRef ) ( ( declarator )? ) ( '=' dv= topLevelExpr )? | '...' )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==EOF||LA50_0==IDENTIFIER||(LA50_0>=28 && LA50_0<=30)||(LA50_0>=34 && LA50_0<=35)||LA50_0==37||LA50_0==45||(LA50_0>=50 && LA50_0<=51)||(LA50_0>=53 && LA50_0<=55)||LA50_0==58||LA50_0==60) ) {
                alt50=1;
            }
            else if ( (LA50_0==46) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:877:4: (tr= mutableTypeRef ) ( ( declarator )? ) ( '=' dv= topLevelExpr )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:877:4: (tr= mutableTypeRef )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:878:4: tr= mutableTypeRef
                    {
                    pushFollow(FOLLOW_mutableTypeRef_in_argDef2176);
                    tr=mutableTypeRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       
                      				if (tr != null) {
                      					retval.arg = new Arg(); 
                      					retval.arg.setValueType(tr); 
                      					int i = getTokenStream().index() + 1;
                      					retval.arg.setCommentBefore(getCommentBefore(i));
                      					retval.arg.setCommentAfter(getCommentAfterOnSameLine(i));
                      				}
                      			
                    }

                    }

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:888:3: ( ( declarator )? )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:889:4: ( declarator )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:889:4: ( declarator )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==IDENTIFIER||LA48_0==34||(LA48_0>=53 && LA48_0<=54)||LA48_0==58) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: declarator
                            {
                            pushFollow(FOLLOW_declarator_in_argDef2191);
                            declarator22=declarator();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       
                      				if (retval.arg != null) {
                      					if (declarator22 != null)
                      						retval.arg.setDeclarator(declarator22); 
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

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:903:3: ( '=' dv= topLevelExpr )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==29) ) {
                        alt49=1;
                    }
                    switch (alt49) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:903:4: '=' dv= topLevelExpr
                            {
                            match(input,29,FOLLOW_29_in_argDef2203); if (state.failed) return retval;
                            pushFollow(FOLLOW_topLevelExpr_in_argDef2207);
                            dv=topLevelExpr();

                            state._fsp--;
                            if (state.failed) return retval;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:908:3: '...'
                    {
                    match(input,46,FOLLOW_46_in_argDef2221); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       
                      			retval.arg = Arg.createVarArgs(); 
                      		
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, argDef_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "argDef"


    // $ANTLR start "typeMutator"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:913:1: typeMutator returns [TypeMutator mutator] : (t= ( '*' | '&' ) | '[' ']' );
    public final TypeMutator typeMutator() throws RecognitionException {
        TypeMutator mutator = null;
        int typeMutator_StartIndex = input.index();
        Token t=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return mutator; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:914:2: (t= ( '*' | '&' ) | '[' ']' )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=53 && LA51_0<=54)) ) {
                alt51=1;
            }
            else if ( (LA51_0==55) ) {
                alt51=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return mutator;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:915:3: t= ( '*' | '&' )
                    {
                    t=(Token)input.LT(1);
                    if ( (input.LA(1)>=53 && input.LA(1)<=54) ) {
                        input.consume();
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return mutator;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    if ( state.backtracking==0 ) {
                       
                      			mutator = (t!=null?t.getText():null).equals("*") ? TypeMutator.STAR : TypeMutator.AMPERSTAND; 
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:918:3: '[' ']'
                    {
                    match(input,55,FOLLOW_55_in_typeMutator2257); if (state.failed) return mutator;
                    match(input,56,FOLLOW_56_in_typeMutator2259); if (state.failed) return mutator;
                    if ( state.backtracking==0 ) {
                       mutator = TypeMutator.BRACKETS; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 24, typeMutator_StartIndex); }
        }
        return mutator;
    }
    // $ANTLR end "typeMutator"


    // $ANTLR start "arrayTypeMutator"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:921:1: arrayTypeMutator returns [TypeMutator mutator] : '[' expression ']' ;
    public final TypeMutator arrayTypeMutator() throws RecognitionException {
        TypeMutator mutator = null;
        int arrayTypeMutator_StartIndex = input.index();
        ObjCppParser.expression_return expression23 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return mutator; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:922:2: ( '[' expression ']' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:922:4: '[' expression ']'
            {
            match(input,55,FOLLOW_55_in_arrayTypeMutator2277); if (state.failed) return mutator;
            pushFollow(FOLLOW_expression_in_arrayTypeMutator2283);
            expression23=expression();

            state._fsp--;
            if (state.failed) return mutator;
            if ( state.backtracking==0 ) {

              				mutator = TypeMutator.array((expression23!=null?expression23.expr:null)); 
              			
            }
            match(input,56,FOLLOW_56_in_arrayTypeMutator2292); if (state.failed) return mutator;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, arrayTypeMutator_StartIndex); }
        }
        return mutator;
    }
    // $ANTLR end "arrayTypeMutator"


    // $ANTLR start "templateDef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:929:1: templateDef : 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' declaration ;
    public final void templateDef() throws RecognitionException {
        IsTypeDef_stack.push(new IsTypeDef_scope());

        int templateDef_StartIndex = input.index();

        	((IsTypeDef_scope)IsTypeDef_stack.peek()).isTypeDef = true;
        	((Symbols_scope)Symbols_stack.peek()).typeIdentifiers = new HashSet<String>();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return ; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:936:2: ( 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' declaration )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:936:4: 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' declaration
            {
            match(input,57,FOLLOW_57_in_templateDef2320); if (state.failed) return ;
            match(input,36,FOLLOW_36_in_templateDef2322); if (state.failed) return ;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:936:19: ( templateArgDecl ( ',' templateArgDecl )* )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==IDENTIFIER||(LA53_0>=28 && LA53_0<=30)||LA53_0==34||(LA53_0>=45 && LA53_0<=46)||(LA53_0>=50 && LA53_0<=51)||(LA53_0>=53 && LA53_0<=55)||LA53_0==58||LA53_0==60) ) {
                alt53=1;
            }
            else if ( (LA53_0==37) ) {
                int LA53_2 = input.LA(2);

                if ( (synpred89_ObjCpp()) ) {
                    alt53=1;
                }
            }
            switch (alt53) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:936:20: templateArgDecl ( ',' templateArgDecl )*
                    {
                    pushFollow(FOLLOW_templateArgDecl_in_templateDef2325);
                    templateArgDecl();

                    state._fsp--;
                    if (state.failed) return ;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:936:36: ( ',' templateArgDecl )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==28) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:936:37: ',' templateArgDecl
                    	    {
                    	    match(input,28,FOLLOW_28_in_templateDef2328); if (state.failed) return ;
                    	    pushFollow(FOLLOW_templateArgDecl_in_templateDef2330);
                    	    templateArgDecl();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,37,FOLLOW_37_in_templateDef2337); if (state.failed) return ;
            pushFollow(FOLLOW_declaration_in_templateDef2341);
            declaration();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 26, templateDef_StartIndex); }
            IsTypeDef_stack.pop();

        }
        return ;
    }
    // $ANTLR end "templateDef"


    // $ANTLR start "templateArgDecl"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:941:1: templateArgDecl : argDef ;
    public final void templateArgDecl() throws RecognitionException {
        int templateArgDecl_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return ; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:942:2: ( argDef )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:942:4: argDef
            {
            pushFollow(FOLLOW_argDef_in_templateArgDecl2356);
            argDef();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, templateArgDecl_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "templateArgDecl"


    // $ANTLR start "functionSignatureSuffix"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:945:1: functionSignatureSuffix returns [FunctionSignature signature] : tk= '(' m1= modifiers '*' m2= modifiers ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' ;
    public final FunctionSignature functionSignatureSuffix() throws RecognitionException {
        FunctionSignature signature = null;
        int functionSignatureSuffix_StartIndex = input.index();
        Token tk=null;
        Token IDENTIFIER24=null;
        List<Modifier> m1 = null;

        List<Modifier> m2 = null;

        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return signature; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:946:2: (tk= '(' m1= modifiers '*' m2= modifiers ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:946:4: tk= '(' m1= modifiers '*' m2= modifiers ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')'
            {
            tk=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffix2376); if (state.failed) return signature;
            pushFollow(FOLLOW_modifiers_in_functionSignatureSuffix2380);
            m1=modifiers();

            state._fsp--;
            if (state.failed) return signature;
            match(input,53,FOLLOW_53_in_functionSignatureSuffix2382); if (state.failed) return signature;
            pushFollow(FOLLOW_modifiers_in_functionSignatureSuffix2386);
            m2=modifiers();

            state._fsp--;
            if (state.failed) return signature;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:946:41: ( IDENTIFIER )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==IDENTIFIER) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: IDENTIFIER
                    {
                    IDENTIFIER24=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionSignatureSuffix2388); if (state.failed) return signature;

                    }
                    break;

            }

            match(input,35,FOLLOW_35_in_functionSignatureSuffix2391); if (state.failed) return signature;
            if ( state.backtracking==0 ) {
               
              			signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, (IDENTIFIER24!=null?IDENTIFIER24.getText():null) == null ? null : new SimpleIdentifier((IDENTIFIER24!=null?IDENTIFIER24.getText():null)), null)), getLine(tk));
              			signature.getFunction().setType(Function.Type.CFunction);
              			signature.getFunction().addModifiers(m1);
              			signature.getFunction().addModifiers(m2);
              			if ((IDENTIFIER24!=null?IDENTIFIER24.getText():null) != null && isTypeDef()) {
              				((Symbols_scope)Symbols_stack.peek()).typeIdentifiers.add((IDENTIFIER24!=null?IDENTIFIER24.getText():null));
              			}
              		
            }
            match(input,34,FOLLOW_34_in_functionSignatureSuffix2397); if (state.failed) return signature;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:955:7: (a1= argDef ( ',' ax= argDef )* )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==IDENTIFIER||(LA56_0>=28 && LA56_0<=30)||LA56_0==34||(LA56_0>=45 && LA56_0<=46)||(LA56_0>=50 && LA56_0<=51)||(LA56_0>=53 && LA56_0<=55)||LA56_0==58||LA56_0==60) ) {
                alt56=1;
            }
            else if ( (LA56_0==35) ) {
                int LA56_2 = input.LA(2);

                if ( (synpred92_ObjCpp()) ) {
                    alt56=1;
                }
            }
            switch (alt56) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:956:4: a1= argDef ( ',' ax= argDef )*
                    {
                    pushFollow(FOLLOW_argDef_in_functionSignatureSuffix2406);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return signature;
                    if ( state.backtracking==0 ) {
                       
                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					((FunctionSignature)signature).getFunction().addArg((a1!=null?a1.arg:null)); 
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:960:4: ( ',' ax= argDef )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==28) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:961:5: ',' ax= argDef
                    	    {
                    	    match(input,28,FOLLOW_28_in_functionSignatureSuffix2419); if (state.failed) return signature;
                    	    pushFollow(FOLLOW_argDef_in_functionSignatureSuffix2428);
                    	    ax=argDef();

                    	    state._fsp--;
                    	    if (state.failed) return signature;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      					((FunctionSignature)signature).getFunction().addArg((ax!=null?ax.arg:null)); 
                    	      				
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

            match(input,35,FOLLOW_35_in_functionSignatureSuffix2443); if (state.failed) return signature;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 28, functionSignatureSuffix_StartIndex); }
        }
        return signature;
    }
    // $ANTLR end "functionSignatureSuffix"


    // $ANTLR start "functionSignatureSuffixNoName"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:969:1: functionSignatureSuffixNoName returns [FunctionSignature signature] : tk= '(' modifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' ;
    public final FunctionSignature functionSignatureSuffixNoName() throws RecognitionException {
        FunctionSignature signature = null;
        int functionSignatureSuffixNoName_StartIndex = input.index();
        Token tk=null;
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;

        List<Modifier> modifiers25 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return signature; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:970:2: (tk= '(' modifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:970:4: tk= '(' modifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')'
            {
            tk=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffixNoName2460); if (state.failed) return signature;
            pushFollow(FOLLOW_modifiers_in_functionSignatureSuffixNoName2462);
            modifiers25=modifiers();

            state._fsp--;
            if (state.failed) return signature;
            match(input,53,FOLLOW_53_in_functionSignatureSuffixNoName2464); if (state.failed) return signature;
            match(input,35,FOLLOW_35_in_functionSignatureSuffixNoName2466); if (state.failed) return signature;
            if ( state.backtracking==0 ) {
               
              			signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, null, null)), getLine(tk));
              			signature.getFunction().setType(Function.Type.CFunction);
              			signature.getFunction().addModifiers(modifiers25);
              		
            }
            match(input,34,FOLLOW_34_in_functionSignatureSuffixNoName2472); if (state.failed) return signature;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:975:7: (a1= argDef ( ',' ax= argDef )* )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==IDENTIFIER||(LA58_0>=28 && LA58_0<=30)||LA58_0==34||(LA58_0>=45 && LA58_0<=46)||(LA58_0>=50 && LA58_0<=51)||(LA58_0>=53 && LA58_0<=55)||LA58_0==58||LA58_0==60) ) {
                alt58=1;
            }
            else if ( (LA58_0==35) ) {
                int LA58_2 = input.LA(2);

                if ( (synpred94_ObjCpp()) ) {
                    alt58=1;
                }
            }
            switch (alt58) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:976:4: a1= argDef ( ',' ax= argDef )*
                    {
                    pushFollow(FOLLOW_argDef_in_functionSignatureSuffixNoName2481);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return signature;
                    if ( state.backtracking==0 ) {
                       
                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					((FunctionSignature)signature).getFunction().addArg((a1!=null?a1.arg:null)); 
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:980:4: ( ',' ax= argDef )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==28) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:981:5: ',' ax= argDef
                    	    {
                    	    match(input,28,FOLLOW_28_in_functionSignatureSuffixNoName2494); if (state.failed) return signature;
                    	    pushFollow(FOLLOW_argDef_in_functionSignatureSuffixNoName2503);
                    	    ax=argDef();

                    	    state._fsp--;
                    	    if (state.failed) return signature;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      					((FunctionSignature)signature).getFunction().addArg((ax!=null?ax.arg:null)); 
                    	      				
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

            match(input,35,FOLLOW_35_in_functionSignatureSuffixNoName2518); if (state.failed) return signature;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, functionSignatureSuffixNoName_StartIndex); }
        }
        return signature;
    }
    // $ANTLR end "functionSignatureSuffixNoName"


    // $ANTLR start "mutableTypeRef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:989:1: mutableTypeRef returns [TypeRef type] : ( typeRefCore ) ( (m1= typeMutator ) | (f1= functionSignatureSuffix ) )* ;
    public final TypeRef mutableTypeRef() throws RecognitionException {
        TypeRef type = null;
        int mutableTypeRef_StartIndex = input.index();
        TypeMutator m1 = null;

        FunctionSignature f1 = null;

        TypeRef typeRefCore26 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return type; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:990:2: ( ( typeRefCore ) ( (m1= typeMutator ) | (f1= functionSignatureSuffix ) )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:991:3: ( typeRefCore ) ( (m1= typeMutator ) | (f1= functionSignatureSuffix ) )*
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:991:3: ( typeRefCore )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:991:5: typeRefCore
            {
            pushFollow(FOLLOW_typeRefCore_in_mutableTypeRef2538);
            typeRefCore26=typeRefCore();

            state._fsp--;
            if (state.failed) return type;
            if ( state.backtracking==0 ) {
               
              			type = typeRefCore26; 
              		
            }

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:994:3: ( (m1= typeMutator ) | (f1= functionSignatureSuffix ) )*
            loop59:
            do {
                int alt59=3;
                alt59 = dfa59.predict(input);
                switch (alt59) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:995:4: (m1= typeMutator )
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:995:4: (m1= typeMutator )
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:996:5: m1= typeMutator
            	    {
            	    pushFollow(FOLLOW_typeMutator_in_mutableTypeRef2559);
            	    m1=typeMutator();

            	    state._fsp--;
            	    if (state.failed) return type;
            	    if ( state.backtracking==0 ) {

            	      					type = m1.mutateType(type);
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1000:4: (f1= functionSignatureSuffix )
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1000:4: (f1= functionSignatureSuffix )
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1001:5: f1= functionSignatureSuffix
            	    {
            	    pushFollow(FOLLOW_functionSignatureSuffix_in_mutableTypeRef2581);
            	    f1=functionSignatureSuffix();

            	    state._fsp--;
            	    if (state.failed) return type;
            	    if ( state.backtracking==0 ) {
            	       
            	      					assert f1 != null && f1.getFunction() != null;
            	      					if (f1 != null && f1.getFunction() != null) {
            	      						f1.getFunction().setValueType(type); 
            	      						type = f1;
            	      					}
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 30, mutableTypeRef_StartIndex); }
        }
        return type;
    }
    // $ANTLR end "mutableTypeRef"


    // $ANTLR start "nonMutableTypeRef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1012:1: nonMutableTypeRef returns [TypeRef type] : typeRefCore ( ( typeMutator )* (fs= functionSignatureSuffix ) )* ;
    public final TypeRef nonMutableTypeRef() throws RecognitionException {
        TypeRef type = null;
        int nonMutableTypeRef_StartIndex = input.index();
        FunctionSignature fs = null;

        TypeRef typeRefCore27 = null;

        TypeMutator typeMutator28 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return type; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1013:2: ( typeRefCore ( ( typeMutator )* (fs= functionSignatureSuffix ) )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1014:3: typeRefCore ( ( typeMutator )* (fs= functionSignatureSuffix ) )*
            {
            pushFollow(FOLLOW_typeRefCore_in_nonMutableTypeRef2610);
            typeRefCore27=typeRefCore();

            state._fsp--;
            if (state.failed) return type;
            if ( state.backtracking==0 ) {
               
              			type = typeRefCore27; 
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1017:3: ( ( typeMutator )* (fs= functionSignatureSuffix ) )*
            loop61:
            do {
                int alt61=2;
                switch ( input.LA(1) ) {
                case 34:
                    {
                    int LA61_2 = input.LA(2);

                    if ( (synpred98_ObjCpp()) ) {
                        alt61=1;
                    }


                    }
                    break;
                case 53:
                case 54:
                    {
                    int LA61_3 = input.LA(2);

                    if ( (synpred98_ObjCpp()) ) {
                        alt61=1;
                    }


                    }
                    break;
                case 55:
                    {
                    alt61=1;
                    }
                    break;

                }

                switch (alt61) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1018:4: ( typeMutator )* (fs= functionSignatureSuffix )
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1018:4: ( typeMutator )*
            	    loop60:
            	    do {
            	        int alt60=2;
            	        int LA60_0 = input.LA(1);

            	        if ( ((LA60_0>=53 && LA60_0<=55)) ) {
            	            alt60=1;
            	        }


            	        switch (alt60) {
            	    	case 1 :
            	    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1019:5: typeMutator
            	    	    {
            	    	    pushFollow(FOLLOW_typeMutator_in_nonMutableTypeRef2627);
            	    	    typeMutator28=typeMutator();

            	    	    state._fsp--;
            	    	    if (state.failed) return type;
            	    	    if ( state.backtracking==0 ) {

            	    	      					type = typeMutator28.mutateType(type);
            	    	      				
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop60;
            	        }
            	    } while (true);

            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1023:4: (fs= functionSignatureSuffix )
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1024:5: fs= functionSignatureSuffix
            	    {
            	    pushFollow(FOLLOW_functionSignatureSuffix_in_nonMutableTypeRef2648);
            	    fs=functionSignatureSuffix();

            	    state._fsp--;
            	    if (state.failed) return type;
            	    if ( state.backtracking==0 ) {
            	       
            	      					assert fs != null && fs.getFunction() != null;
            	      					if (fs != null && fs.getFunction() != null) {
            	      						fs.getFunction().setValueType(type); 
            	      						type = fs;
            	      					}
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 31, nonMutableTypeRef_StartIndex); }
        }
        return type;
    }
    // $ANTLR end "nonMutableTypeRef"


    // $ANTLR start "declarator"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1035:1: declarator returns [Declarator declarator] : modifiers ( ( directDeclarator ) | (pt= ( '*' | '&' | '^' ) inner= declarator ) ) ( ':' bits= DECIMAL_NUMBER )? ( '=' dv= topLevelExpr )? ;
    public final Declarator declarator() throws RecognitionException {
        Declarator declarator = null;
        int declarator_StartIndex = input.index();
        Token pt=null;
        Token bits=null;
        Declarator inner = null;

        ObjCppParser.topLevelExpr_return dv = null;

        Declarator directDeclarator29 = null;

        List<Modifier> modifiers30 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return declarator; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1036:2: ( modifiers ( ( directDeclarator ) | (pt= ( '*' | '&' | '^' ) inner= declarator ) ) ( ':' bits= DECIMAL_NUMBER )? ( '=' dv= topLevelExpr )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1037:3: modifiers ( ( directDeclarator ) | (pt= ( '*' | '&' | '^' ) inner= declarator ) ) ( ':' bits= DECIMAL_NUMBER )? ( '=' dv= topLevelExpr )?
            {
            pushFollow(FOLLOW_modifiers_in_declarator2678);
            modifiers30=modifiers();

            state._fsp--;
            if (state.failed) return declarator;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1038:3: ( ( directDeclarator ) | (pt= ( '*' | '&' | '^' ) inner= declarator ) )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==IDENTIFIER) && (( Modifier.parseModifier(next()) == null ))) {
                alt62=1;
            }
            else if ( (LA62_0==34) ) {
                alt62=1;
            }
            else if ( ((LA62_0>=53 && LA62_0<=54)||LA62_0==58) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return declarator;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1039:4: ( directDeclarator )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1039:4: ( directDeclarator )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1040:5: directDeclarator
                    {
                    pushFollow(FOLLOW_directDeclarator_in_declarator2694);
                    directDeclarator29=directDeclarator();

                    state._fsp--;
                    if (state.failed) return declarator;
                    if ( state.backtracking==0 ) {
                       
                      					declarator = directDeclarator29; 
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1044:4: (pt= ( '*' | '&' | '^' ) inner= declarator )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1044:4: (pt= ( '*' | '&' | '^' ) inner= declarator )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1045:5: pt= ( '*' | '&' | '^' ) inner= declarator
                    {
                    pt=(Token)input.LT(1);
                    if ( (input.LA(1)>=53 && input.LA(1)<=54)||input.LA(1)==58 ) {
                        input.consume();
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return declarator;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_declarator_in_declarator2736);
                    inner=declarator();

                    state._fsp--;
                    if (state.failed) return declarator;
                    if ( state.backtracking==0 ) {

                      					declarator = new PointerDeclarator(inner, PointerStyle.parsePointerStyle((pt!=null?pt.getText():null)));
                      				
                    }

                    }


                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1051:3: ( ':' bits= DECIMAL_NUMBER )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==33) ) {
                int LA63_1 = input.LA(2);

                if ( (synpred102_ObjCpp()) ) {
                    alt63=1;
                }
            }
            switch (alt63) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1052:4: ':' bits= DECIMAL_NUMBER
                    {
                    match(input,33,FOLLOW_33_in_declarator2757); if (state.failed) return declarator;
                    bits=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_declarator2761); if (state.failed) return declarator;
                    if ( state.backtracking==0 ) {

                      				if (declarator != null)
                      					declarator.setBits(Integer.parseInt((bits!=null?bits.getText():null)));
                      			
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1057:3: ( '=' dv= topLevelExpr )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==29) ) {
                int LA64_1 = input.LA(2);

                if ( (synpred103_ObjCpp()) ) {
                    alt64=1;
                }
            }
            switch (alt64) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1058:4: '=' dv= topLevelExpr
                    {
                    match(input,29,FOLLOW_29_in_declarator2777); if (state.failed) return declarator;
                    pushFollow(FOLLOW_topLevelExpr_in_declarator2785);
                    dv=topLevelExpr();

                    state._fsp--;
                    if (state.failed) return declarator;
                    if ( state.backtracking==0 ) {

                      				if (declarator != null)
                      					declarator.setDefaultValue((dv!=null?dv.expr:null));
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			if (declarator != null)
              				declarator.setModifiers(modifiers30);
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 32, declarator_StartIndex); }
        }
        return declarator;
    }
    // $ANTLR end "declarator"


    // $ANTLR start "typeDef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1070:1: typeDef returns [TypeDef typeDef] : 'typedef' varDecl ';' ;
    public final TypeDef typeDef() throws RecognitionException {
        IsTypeDef_stack.push(new IsTypeDef_scope());

        TypeDef typeDef = null;
        int typeDef_StartIndex = input.index();
        VariablesDeclaration varDecl31 = null;



        	((IsTypeDef_scope)IsTypeDef_stack.peek()).isTypeDef = true;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return typeDef; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1075:2: ( 'typedef' varDecl ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1075:4: 'typedef' varDecl ';'
            {
            match(input,59,FOLLOW_59_in_typeDef2821); if (state.failed) return typeDef;
            pushFollow(FOLLOW_varDecl_in_typeDef2826);
            varDecl31=varDecl();

            state._fsp--;
            if (state.failed) return typeDef;
            match(input,25,FOLLOW_25_in_typeDef2828); if (state.failed) return typeDef;
            if ( state.backtracking==0 ) {

              		 	VariablesDeclaration vd = varDecl31;
              			typeDef = new TypeDef(vd.getValueType(), vd.getDeclarators());
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 33, typeDef_StartIndex); }
            IsTypeDef_stack.pop();

        }
        return typeDef;
    }
    // $ANTLR end "typeDef"


    // $ANTLR start "varDeclEOF"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1082:1: varDeclEOF returns [Declaration decl] : varDecl ';' EOF ;
    public final Declaration varDeclEOF() throws RecognitionException {
        Declaration decl = null;
        int varDeclEOF_StartIndex = input.index();
        VariablesDeclaration varDecl32 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return decl; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1083:2: ( varDecl ';' EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1083:4: varDecl ';' EOF
            {
            pushFollow(FOLLOW_varDecl_in_varDeclEOF2846);
            varDecl32=varDecl();

            state._fsp--;
            if (state.failed) return decl;
            match(input,25,FOLLOW_25_in_varDeclEOF2848); if (state.failed) return decl;
            match(input,EOF,FOLLOW_EOF_in_varDeclEOF2850); if (state.failed) return decl;
            if ( state.backtracking==0 ) {
               decl = varDecl32; 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 34, varDeclEOF_StartIndex); }
        }
        return decl;
    }
    // $ANTLR end "varDeclEOF"


    // $ANTLR start "declarationEOF"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1086:1: declarationEOF returns [List<Declaration> declarations] : d= declaration EOF ;
    public final List<Declaration> declarationEOF() throws RecognitionException {
        List<Declaration> declarations = null;
        int declarationEOF_StartIndex = input.index();
        ObjCppParser.declaration_return d = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return declarations; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1087:2: (d= declaration EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1087:5: d= declaration EOF
            {
            pushFollow(FOLLOW_declaration_in_declarationEOF2870);
            d=declaration();

            state._fsp--;
            if (state.failed) return declarations;
            match(input,EOF,FOLLOW_EOF_in_declarationEOF2872); if (state.failed) return declarations;
            if ( state.backtracking==0 ) {
               declarations = (d!=null?d.declarations:null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 35, declarationEOF_StartIndex); }
        }
        return declarations;
    }
    // $ANTLR end "declarationEOF"


    // $ANTLR start "varDecl"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1090:1: varDecl returns [VariablesDeclaration decl] : tr= nonMutableTypeRef (d1= declaratorsList )? ;
    public final VariablesDeclaration varDecl() throws RecognitionException {
        VariablesDeclaration decl = null;
        int varDecl_StartIndex = input.index();
        TypeRef tr = null;

        List<Declarator> d1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return decl; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1091:2: (tr= nonMutableTypeRef (d1= declaratorsList )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1092:3: tr= nonMutableTypeRef (d1= declaratorsList )?
            {
            pushFollow(FOLLOW_nonMutableTypeRef_in_varDecl2894);
            tr=nonMutableTypeRef();

            state._fsp--;
            if (state.failed) return decl;
            if ( state.backtracking==0 ) {
               
              			decl = new VariablesDeclaration(tr); 
              			//decl.addModifiers($modifiers.modifiers);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1096:3: (d1= declaratorsList )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==IDENTIFIER||LA65_0==34||(LA65_0>=53 && LA65_0<=54)||LA65_0==58) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1097:4: d1= declaratorsList
                    {
                    pushFollow(FOLLOW_declaratorsList_in_varDecl2907);
                    d1=declaratorsList();

                    state._fsp--;
                    if (state.failed) return decl;
                    if ( state.backtracking==0 ) {

                      				decl.setDeclarators(d1);
                      			
                    }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 36, varDecl_StartIndex); }
        }
        return decl;
    }
    // $ANTLR end "varDecl"


    // $ANTLR start "objCProtocolRefList"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1103:1: objCProtocolRefList : '<' IDENTIFIER ( ',' IDENTIFIER )* '>' ;
    public final void objCProtocolRefList() throws RecognitionException {
        int objCProtocolRefList_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return ; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1104:2: ( '<' IDENTIFIER ( ',' IDENTIFIER )* '>' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1104:4: '<' IDENTIFIER ( ',' IDENTIFIER )* '>'
            {
            match(input,36,FOLLOW_36_in_objCProtocolRefList2926); if (state.failed) return ;
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCProtocolRefList2931); if (state.failed) return ;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1106:3: ( ',' IDENTIFIER )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==28) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1107:4: ',' IDENTIFIER
            	    {
            	    match(input,28,FOLLOW_28_in_objCProtocolRefList2941); if (state.failed) return ;
            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCProtocolRefList2947); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);

            match(input,37,FOLLOW_37_in_objCProtocolRefList2957); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 37, objCProtocolRefList_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "objCProtocolRefList"


    // $ANTLR start "declaratorsList"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1113:1: declaratorsList returns [List<Declarator> declarators] : d= declarator ( ',' x= declarator )* ;
    public final List<Declarator> declaratorsList() throws RecognitionException {
        List<Declarator> declarators = null;
        int declaratorsList_StartIndex = input.index();
        Declarator d = null;

        Declarator x = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return declarators; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1114:2: (d= declarator ( ',' x= declarator )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1114:4: d= declarator ( ',' x= declarator )*
            {
            if ( state.backtracking==0 ) {
               declarators = new ArrayList<Declarator>(); 
            }
            pushFollow(FOLLOW_declarator_in_declaratorsList2978);
            d=declarator();

            state._fsp--;
            if (state.failed) return declarators;
            if ( state.backtracking==0 ) {
               declarators.add(d); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1116:3: ( ',' x= declarator )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==28) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1117:4: ',' x= declarator
            	    {
            	    match(input,28,FOLLOW_28_in_declaratorsList2989); if (state.failed) return declarators;
            	    pushFollow(FOLLOW_declarator_in_declaratorsList2997);
            	    x=declarator();

            	    state._fsp--;
            	    if (state.failed) return declarators;
            	    if ( state.backtracking==0 ) {
            	       declarators.add(x); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 38, declaratorsList_StartIndex); }
        }
        return declarators;
    }
    // $ANTLR end "declaratorsList"


    // $ANTLR start "directDeclarator"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1122:1: directDeclarator returns [Declarator declarator] : ({...}? => IDENTIFIER | '(' inner= declarator ')' ) ( '[' ( ( expression )? ) ']' | argList )* ;
    public final Declarator directDeclarator() throws RecognitionException {
        Declarator declarator = null;
        int directDeclarator_StartIndex = input.index();
        Token IDENTIFIER33=null;
        Declarator inner = null;

        ObjCppParser.expression_return expression34 = null;

        ObjCppParser.argList_return argList35 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return declarator; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1123:2: ( ({...}? => IDENTIFIER | '(' inner= declarator ')' ) ( '[' ( ( expression )? ) ']' | argList )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1124:3: ({...}? => IDENTIFIER | '(' inner= declarator ')' ) ( '[' ( ( expression )? ) ']' | argList )*
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1124:3: ({...}? => IDENTIFIER | '(' inner= declarator ')' )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==IDENTIFIER) && (( Modifier.parseModifier(next()) == null ))) {
                alt68=1;
            }
            else if ( (LA68_0==34) ) {
                alt68=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return declarator;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1125:4: {...}? => IDENTIFIER
                    {
                    if ( !(( Modifier.parseModifier(next()) == null )) ) {
                        if (state.backtracking>0) {state.failed=true; return declarator;}
                        throw new FailedPredicateException(input, "directDeclarator", " Modifier.parseModifier(next()) == null ");
                    }
                    IDENTIFIER33=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_directDeclarator3030); if (state.failed) return declarator;
                    if ( state.backtracking==0 ) {

                      				declarator = mark(new DirectDeclarator((IDENTIFIER33!=null?IDENTIFIER33.getText():null)), getLine(IDENTIFIER33));
                      				if (isTypeDef()) {
                      					((Symbols_scope)Symbols_stack.peek()).typeIdentifiers.add((IDENTIFIER33!=null?IDENTIFIER33.getText():null));
                      				}
                      			
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1131:4: '(' inner= declarator ')'
                    {
                    match(input,34,FOLLOW_34_in_directDeclarator3040); if (state.failed) return declarator;
                    pushFollow(FOLLOW_declarator_in_directDeclarator3044);
                    inner=declarator();

                    state._fsp--;
                    if (state.failed) return declarator;
                    match(input,35,FOLLOW_35_in_directDeclarator3046); if (state.failed) return declarator;
                    if ( state.backtracking==0 ) {

                      				declarator = inner;
                      				if (declarator != null)
                      					declarator.setParenthesized(true);
                      			
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1137:3: ( '[' ( ( expression )? ) ']' | argList )*
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1138:4: '[' ( ( expression )? ) ']'
            	    {
            	    match(input,55,FOLLOW_55_in_directDeclarator3062); if (state.failed) return declarator;
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1139:4: ( ( expression )? )
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1140:5: ( expression )?
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1140:5: ( expression )?
            	    int alt69=2;
            	    int LA69_0 = input.LA(1);

            	    if ( ((LA69_0>=DECIMAL_NUMBER && LA69_0<=FLOAT_NUMBER)||LA69_0==31||LA69_0==34||(LA69_0>=43 && LA69_0<=44)||(LA69_0>=53 && LA69_0<=55)||(LA69_0>=74 && LA69_0<=76)||(LA69_0>=89 && LA69_0<=91)) ) {
            	        alt69=1;
            	    }
            	    switch (alt69) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: expression
            	            {
            	            pushFollow(FOLLOW_expression_in_directDeclarator3074);
            	            expression34=expression();

            	            state._fsp--;
            	            if (state.failed) return declarator;

            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {

            	      					if ((expression34!=null?input.toString(expression34.start,expression34.stop):null) != null) {
            	      						if (declarator instanceof ArrayDeclarator)
            	      							((ArrayDeclarator)declarator).addDimension((expression34!=null?expression34.expr:null));
            	      						else
            	      							declarator = new ArrayDeclarator(declarator, (expression34!=null?expression34.expr:null));
            	      					} else
            	      						declarator = new ArrayDeclarator(declarator, new Expression.EmptyArraySize());
            	      				
            	    }

            	    }

            	    match(input,56,FOLLOW_56_in_directDeclarator3087); if (state.failed) return declarator;

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1151:4: argList
            	    {
            	    pushFollow(FOLLOW_argList_in_directDeclarator3095);
            	    argList35=argList();

            	    state._fsp--;
            	    if (state.failed) return declarator;
            	    if ( state.backtracking==0 ) {

            	      				declarator = new FunctionDeclarator(declarator, (argList35!=null?argList35.args:null));
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop70;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 39, directDeclarator_StartIndex); }
        }
        return declarator;
    }
    // $ANTLR end "directDeclarator"

    public static class argList_return extends ParserRuleReturnScope {
        public List<Arg> args;
        public boolean isObjC;
    };

    // $ANTLR start "argList"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1157:1: argList returns [List<Arg> args, boolean isObjC] : op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')' ;
    public final ObjCppParser.argList_return argList() throws RecognitionException {
        ObjCppParser.argList_return retval = new ObjCppParser.argList_return();
        retval.start = input.LT(1);
        int argList_StartIndex = input.index();
        Token op=null;
        Token cp=null;
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return retval; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1158:2: (op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1158:4: op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')'
            {
            if ( state.backtracking==0 ) {
               
              			retval.isObjC = false; 
              			retval.args = new ArrayList<Arg>();
              		
            }
            op=(Token)match(input,34,FOLLOW_34_in_argList3123); if (state.failed) return retval;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1163:3: (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==IDENTIFIER||(LA73_0>=28 && LA73_0<=30)||LA73_0==34||(LA73_0>=45 && LA73_0<=46)||(LA73_0>=50 && LA73_0<=51)||(LA73_0>=53 && LA73_0<=55)||LA73_0==58||LA73_0==60) ) {
                alt73=1;
            }
            else if ( (LA73_0==35) ) {
                int LA73_2 = input.LA(2);

                if ( (synpred113_ObjCpp()) ) {
                    alt73=1;
                }
            }
            switch (alt73) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1164:4: a1= argDef ( ',' ax= argDef )* ( ',' '...' )?
                    {
                    pushFollow(FOLLOW_argDef_in_argList3135);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					retval.args.add((a1!=null?a1.arg:null));
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1168:4: ( ',' ax= argDef )*
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==28) ) {
                            int LA71_1 = input.LA(2);

                            if ( (LA71_1==46) ) {
                                int LA71_3 = input.LA(3);

                                if ( (synpred111_ObjCpp()) ) {
                                    alt71=1;
                                }


                            }
                            else if ( (LA71_1==IDENTIFIER||(LA71_1>=28 && LA71_1<=30)||(LA71_1>=34 && LA71_1<=35)||LA71_1==45||(LA71_1>=50 && LA71_1<=51)||(LA71_1>=53 && LA71_1<=55)||LA71_1==58||LA71_1==60) ) {
                                alt71=1;
                            }


                        }


                        switch (alt71) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1169:5: ',' ax= argDef
                    	    {
                    	    match(input,28,FOLLOW_28_in_argList3148); if (state.failed) return retval;
                    	    pushFollow(FOLLOW_argDef_in_argList3157);
                    	    ax=argDef();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {

                    	      					retval.args.add((ax!=null?ax.arg:null));
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop71;
                        }
                    } while (true);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1174:4: ( ',' '...' )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==28) ) {
                        alt72=1;
                    }
                    switch (alt72) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1175:5: ',' '...'
                            {
                            match(input,28,FOLLOW_28_in_argList3177); if (state.failed) return retval;
                            match(input,46,FOLLOW_46_in_argList3179); if (state.failed) return retval;
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

            cp=(Token)match(input,35,FOLLOW_35_in_argList3198); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 40, argList_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "argList"


    // $ANTLR start "typeRefCore"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1184:1: typeRefCore returns [TypeRef type] : preMods= modifiers ( 'typename' pn= typeName | {...}? =>an= typeName | structCore | enumCore )? postMods= modifiers ;
    public final TypeRef typeRefCore() throws RecognitionException {
        TypeRef type = null;
        int typeRefCore_StartIndex = input.index();
        List<Modifier> preMods = null;

        TypeRef pn = null;

        TypeRef an = null;

        List<Modifier> postMods = null;

        Struct structCore36 = null;

        Enum enumCore37 = null;



        	List<Modifier> modifiers = new ArrayList<Modifier>();
        	//TypeRef ref = null;
        	int line = -1;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return type; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1199:2: (preMods= modifiers ( 'typename' pn= typeName | {...}? =>an= typeName | structCore | enumCore )? postMods= modifiers )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1200:3: preMods= modifiers ( 'typename' pn= typeName | {...}? =>an= typeName | structCore | enumCore )? postMods= modifiers
            {
            pushFollow(FOLLOW_modifiers_in_typeRefCore3228);
            preMods=modifiers();

            state._fsp--;
            if (state.failed) return type;
            if ( state.backtracking==0 ) {
               modifiers.addAll(preMods); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1201:3: ( 'typename' pn= typeName | {...}? =>an= typeName | structCore | enumCore )?
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

                    if ( ((synpred115_ObjCpp()&&( 
                    				isTypeIdentifier(next()) || 
                    				(
                    					Modifier.parseModifier(next(1)) == null && 
                    					!next(2, "=", ",", ";", ":", "[", "(", ")")
                    				) 
                    			))) ) {
                        alt74=2;
                    }
                    }
                    break;
                case 45:
                case 50:
                case 51:
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1202:4: 'typename' pn= typeName
                    {
                    match(input,60,FOLLOW_60_in_typeRefCore3239); if (state.failed) return type;
                    pushFollow(FOLLOW_typeName_in_typeRefCore3243);
                    pn=typeName();

                    state._fsp--;
                    if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                       type = pn; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1203:4: {...}? =>an= typeName
                    {
                    if ( !(( 
                    				isTypeIdentifier(next()) || 
                    				(
                    					Modifier.parseModifier(next(1)) == null && 
                    					!next(2, "=", ",", ";", ":", "[", "(", ")")
                    				) 
                    			)) ) {
                        if (state.backtracking>0) {state.failed=true; return type;}
                        throw new FailedPredicateException(input, "typeRefCore", " \n\t\t\t\tisTypeIdentifier(next()) || \n\t\t\t\t(\n\t\t\t\t\tModifier.parseModifier(next(1)) == null && \n\t\t\t\t\t!next(2, \"=\", \",\", \";\", \":\", \"[\", \"(\", \")\")\n\t\t\t\t) \n\t\t\t");
                    }
                    pushFollow(FOLLOW_typeName_in_typeRefCore3257);
                    an=typeName();

                    state._fsp--;
                    if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                       type = an; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1210:4: structCore
                    {
                    pushFollow(FOLLOW_structCore_in_typeRefCore3266);
                    structCore36=structCore();

                    state._fsp--;
                    if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                       type = structCore36; 
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1211:4: enumCore
                    {
                    pushFollow(FOLLOW_enumCore_in_typeRefCore3275);
                    enumCore37=enumCore();

                    state._fsp--;
                    if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                       type = enumCore37; 
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_modifiers_in_typeRefCore3288);
            postMods=modifiers();

            state._fsp--;
            if (state.failed) return type;
            if ( state.backtracking==0 ) {
               modifiers.addAll(postMods); 
            }

            }

            if ( state.backtracking==0 ) {

              	if (type == null && !modifiers.isEmpty()) {
              		type = new Primitive(null);
              	}
              	if (type != null) {
              		type.addModifiers(modifiers);
              		mark(type, line);
              	}

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 41, typeRefCore_StartIndex); }
        }
        return type;
    }
    // $ANTLR end "typeRefCore"


    // $ANTLR start "typeName"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1216:1: typeName returns [TypeRef type] : i= qualifiedIdentifier ;
    public final TypeRef typeName() throws RecognitionException {
        TypeRef type = null;
        int typeName_StartIndex = input.index();
        ObjCppParser.qualifiedIdentifier_return i = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return type; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1217:2: (i= qualifiedIdentifier )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1218:3: i= qualifiedIdentifier
            {
            pushFollow(FOLLOW_qualifiedIdentifier_in_typeName3310);
            i=qualifiedIdentifier();

            state._fsp--;
            if (state.failed) return type;
            if ( state.backtracking==0 ) {

              			if ((i!=null?i.identifier:null).isPlain() && isPrimitiveType((i!=null?i.identifier:null).toString()))
              				type = new Primitive((i!=null?i.identifier:null).toString());
              			else
              				type = new SimpleTypeRef((i!=null?i.identifier:null));
              			if ((i!=null?i.identifier:null).isPlain())
              				((Symbols_scope)Symbols_stack.peek()).typeIdentifiers.add((i!=null?i.identifier:null).toString());
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 42, typeName_StartIndex); }
        }
        return type;
    }
    // $ANTLR end "typeName"


    // $ANTLR start "objCMethodCall"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1228:1: objCMethodCall returns [FunctionCall expr] : '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']' ;
    public final FunctionCall objCMethodCall() throws RecognitionException {
        FunctionCall expr = null;
        int objCMethodCall_StartIndex = input.index();
        Token methodName=null;
        Token selx=null;
        ObjCppParser.expression_return target = null;

        ObjCppParser.expression_return arg1 = null;

        ObjCppParser.expression_return argx = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1229:2: ( '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1230:3: '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']'
            {
            match(input,55,FOLLOW_55_in_objCMethodCall3330); if (state.failed) return expr;
            pushFollow(FOLLOW_expression_in_objCMethodCall3334);
            target=expression();

            state._fsp--;
            if (state.failed) return expr;
            methodName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodCall3338); if (state.failed) return expr;
            if ( state.backtracking==0 ) {

              			expr = new FunctionCall();
              			expr.setFunction(new VariableRef(new SimpleIdentifier((methodName!=null?methodName.getText():null))));
              			expr.setTarget((target!=null?target.expr:null));
              			expr.setMemberRefStyle(MemberRefStyle.SquareBrackets);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1236:3: ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==33) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1237:4: ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )*
                    {
                    match(input,33,FOLLOW_33_in_objCMethodCall3349); if (state.failed) return expr;
                    pushFollow(FOLLOW_expression_in_objCMethodCall3353);
                    arg1=expression();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {

                      				expr.addArgument(null, (arg1!=null?arg1.expr:null));
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1240:4: (selx= IDENTIFIER ':' argx= expression )*
                    loop75:
                    do {
                        int alt75=2;
                        int LA75_0 = input.LA(1);

                        if ( (LA75_0==IDENTIFIER) ) {
                            alt75=1;
                        }


                        switch (alt75) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1241:5: selx= IDENTIFIER ':' argx= expression
                    	    {
                    	    selx=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodCall3368); if (state.failed) return expr;
                    	    match(input,33,FOLLOW_33_in_objCMethodCall3370); if (state.failed) return expr;
                    	    pushFollow(FOLLOW_expression_in_objCMethodCall3374);
                    	    argx=expression();

                    	    state._fsp--;
                    	    if (state.failed) return expr;
                    	    if ( state.backtracking==0 ) {

                    	      					expr.addArgument((selx!=null?selx.getText():null), (argx!=null?argx.expr:null));
                    	      				
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

            match(input,56,FOLLOW_56_in_objCMethodCall3391); if (state.failed) return expr;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 43, objCMethodCall_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "objCMethodCall"


    // $ANTLR start "binaryOp"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1249:1: binaryOp returns [Expression.BinaryOperator op] : t= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) ;
    public final Expression.BinaryOperator binaryOp() throws RecognitionException {
        Expression.BinaryOperator op = null;
        int binaryOp_StartIndex = input.index();
        Token t=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return op; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1250:2: (t= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1250:5: t= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' )
            {
            t=(Token)input.LT(1);
            if ( (input.LA(1)>=36 && input.LA(1)<=37)||(input.LA(1)>=43 && input.LA(1)<=44)||(input.LA(1)>=53 && input.LA(1)<=54)||input.LA(1)==58||(input.LA(1)>=61 && input.LA(1)<=72) ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return op;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {

              			op = Expression.getBinaryOperator((t!=null?t.getText():null));
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 44, binaryOp_StartIndex); }
        }
        return op;
    }
    // $ANTLR end "binaryOp"


    // $ANTLR start "typeRefOrExpression"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1260:1: typeRefOrExpression returns [Expression expr] : (tr= mutableTypeRef | e= topLevelExpr );
    public final Expression typeRefOrExpression() throws RecognitionException {
        Expression expr = null;
        int typeRefOrExpression_StartIndex = input.index();
        TypeRef tr = null;

        ObjCppParser.topLevelExpr_return e = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1261:2: (tr= mutableTypeRef | e= topLevelExpr )
            int alt77=2;
            alt77 = dfa77.predict(input);
            switch (alt77) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1261:4: tr= mutableTypeRef
                    {
                    pushFollow(FOLLOW_mutableTypeRef_in_typeRefOrExpression3516);
                    tr=mutableTypeRef();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {

                      			expr = new Expression.TypeRefExpression(tr);
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1264:3: e= topLevelExpr
                    {
                    pushFollow(FOLLOW_topLevelExpr_in_typeRefOrExpression3527);
                    e=topLevelExpr();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {

                      			expr = (e!=null?e.expr:null);
                      		
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 45, typeRefOrExpression_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "typeRefOrExpression"


    // $ANTLR start "simpleIdentifier"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1269:1: simpleIdentifier returns [SimpleIdentifier identifier] : i= IDENTIFIER ( '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>' )? ;
    public final SimpleIdentifier simpleIdentifier() throws RecognitionException {
        SimpleIdentifier identifier = null;
        int simpleIdentifier_StartIndex = input.index();
        Token i=null;
        Expression a1 = null;

        Expression ax = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return identifier; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1270:2: (i= IDENTIFIER ( '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>' )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1270:4: i= IDENTIFIER ( '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>' )?
            {
            i=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_simpleIdentifier3546); if (state.failed) return identifier;
            if ( state.backtracking==0 ) {
               identifier = new SimpleIdentifier((i!=null?i.getText():null)); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1271:3: ( '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>' )?
            int alt80=2;
            alt80 = dfa80.predict(input);
            switch (alt80) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1272:4: '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>'
                    {
                    match(input,36,FOLLOW_36_in_simpleIdentifier3557); if (state.failed) return identifier;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1272:8: (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )?
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( ((LA79_0>=DECIMAL_NUMBER && LA79_0<=FLOAT_NUMBER)||LA79_0==28||(LA79_0>=30 && LA79_0<=31)||LA79_0==34||(LA79_0>=43 && LA79_0<=45)||(LA79_0>=50 && LA79_0<=51)||(LA79_0>=53 && LA79_0<=55)||LA79_0==60||(LA79_0>=74 && LA79_0<=76)||(LA79_0>=89 && LA79_0<=91)) ) {
                        alt79=1;
                    }
                    else if ( (LA79_0==37) ) {
                        int LA79_2 = input.LA(2);

                        if ( (synpred140_ObjCpp()) ) {
                            alt79=1;
                        }
                    }
                    switch (alt79) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1273:5: a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )*
                            {
                            pushFollow(FOLLOW_typeRefOrExpression_in_simpleIdentifier3567);
                            a1=typeRefOrExpression();

                            state._fsp--;
                            if (state.failed) return identifier;
                            if ( state.backtracking==0 ) {
                               identifier.addTemplateArgument(a1); 
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1274:5: ( ',' ax= typeRefOrExpression )*
                            loop78:
                            do {
                                int alt78=2;
                                int LA78_0 = input.LA(1);

                                if ( (LA78_0==28) ) {
                                    alt78=1;
                                }


                                switch (alt78) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1275:6: ',' ax= typeRefOrExpression
                            	    {
                            	    match(input,28,FOLLOW_28_in_simpleIdentifier3582); if (state.failed) return identifier;
                            	    pushFollow(FOLLOW_typeRefOrExpression_in_simpleIdentifier3592);
                            	    ax=typeRefOrExpression();

                            	    state._fsp--;
                            	    if (state.failed) return identifier;
                            	    if ( state.backtracking==0 ) {
                            	       identifier.addTemplateArgument(ax); 
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

                    match(input,37,FOLLOW_37_in_simpleIdentifier3611); if (state.failed) return identifier;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 46, simpleIdentifier_StartIndex); }
        }
        return identifier;
    }
    // $ANTLR end "simpleIdentifier"

    public static class qualifiedIdentifier_return extends ParserRuleReturnScope {
        public Identifier identifier;
    };

    // $ANTLR start "qualifiedIdentifier"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1282:1: qualifiedIdentifier returns [Identifier identifier] : i1= simpleIdentifier ( '::' ix= simpleIdentifier )* ;
    public final ObjCppParser.qualifiedIdentifier_return qualifiedIdentifier() throws RecognitionException {
        ObjCppParser.qualifiedIdentifier_return retval = new ObjCppParser.qualifiedIdentifier_return();
        retval.start = input.LT(1);
        int qualifiedIdentifier_StartIndex = input.index();
        SimpleIdentifier i1 = null;

        SimpleIdentifier ix = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return retval; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1283:2: (i1= simpleIdentifier ( '::' ix= simpleIdentifier )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1283:4: i1= simpleIdentifier ( '::' ix= simpleIdentifier )*
            {
            pushFollow(FOLLOW_simpleIdentifier_in_qualifiedIdentifier3633);
            i1=simpleIdentifier();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               retval.identifier = i1; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1284:3: ( '::' ix= simpleIdentifier )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==73) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1285:4: '::' ix= simpleIdentifier
            	    {
            	    match(input,73,FOLLOW_73_in_qualifiedIdentifier3644); if (state.failed) return retval;
            	    pushFollow(FOLLOW_simpleIdentifier_in_qualifiedIdentifier3648);
            	    ix=simpleIdentifier();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	       retval.identifier = retval.identifier.derive(QualificationSeparator.Colons, ix); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop81;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 47, qualifiedIdentifier_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "qualifiedIdentifier"


    // $ANTLR start "qualifiedCppFunctionName"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1289:1: qualifiedCppFunctionName returns [Identifier identifier] : i1= simpleCppFunctionName ( '::' ix= simpleCppFunctionName )* ;
    public final Identifier qualifiedCppFunctionName() throws RecognitionException {
        Identifier identifier = null;
        int qualifiedCppFunctionName_StartIndex = input.index();
        SimpleIdentifier i1 = null;

        SimpleIdentifier ix = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return identifier; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1290:2: (i1= simpleCppFunctionName ( '::' ix= simpleCppFunctionName )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1290:4: i1= simpleCppFunctionName ( '::' ix= simpleCppFunctionName )*
            {
            pushFollow(FOLLOW_simpleCppFunctionName_in_qualifiedCppFunctionName3673);
            i1=simpleCppFunctionName();

            state._fsp--;
            if (state.failed) return identifier;
            if ( state.backtracking==0 ) {
               identifier = i1; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1291:3: ( '::' ix= simpleCppFunctionName )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==73) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1292:4: '::' ix= simpleCppFunctionName
            	    {
            	    match(input,73,FOLLOW_73_in_qualifiedCppFunctionName3684); if (state.failed) return identifier;
            	    pushFollow(FOLLOW_simpleCppFunctionName_in_qualifiedCppFunctionName3688);
            	    ix=simpleCppFunctionName();

            	    state._fsp--;
            	    if (state.failed) return identifier;
            	    if ( state.backtracking==0 ) {
            	       identifier = identifier.derive(QualificationSeparator.Colons, ix); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop82;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 48, qualifiedCppFunctionName_StartIndex); }
        }
        return identifier;
    }
    // $ANTLR end "qualifiedCppFunctionName"


    // $ANTLR start "simpleCppFunctionName"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1296:1: simpleCppFunctionName returns [SimpleIdentifier identifier] : (pre= '~' )? i= simpleIdentifier ;
    public final SimpleIdentifier simpleCppFunctionName() throws RecognitionException {
        SimpleIdentifier identifier = null;
        int simpleCppFunctionName_StartIndex = input.index();
        Token pre=null;
        SimpleIdentifier i = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return identifier; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1297:2: ( (pre= '~' )? i= simpleIdentifier )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1298:3: (pre= '~' )? i= simpleIdentifier
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1298:6: (pre= '~' )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==74) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: pre= '~'
                    {
                    pre=(Token)match(input,74,FOLLOW_74_in_simpleCppFunctionName3715); if (state.failed) return identifier;

                    }
                    break;

            }

            pushFollow(FOLLOW_simpleIdentifier_in_simpleCppFunctionName3723);
            i=simpleIdentifier();

            state._fsp--;
            if (state.failed) return identifier;
            if ( state.backtracking==0 ) {

              			if ((pre!=null?pre.getText():null) != null)
              				i.setName((pre!=null?pre.getText():null) + i.getName());
              			identifier = i;
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 49, simpleCppFunctionName_StartIndex); }
        }
        return identifier;
    }
    // $ANTLR end "simpleCppFunctionName"


    // $ANTLR start "baseExpression"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1306:1: baseExpression returns [Expression expr] : (i= simpleIdentifier | constant | '(' expression ')' | objCMethodCall | selectorExpr | protocolExpr | encodingExpr );
    public final Expression baseExpression() throws RecognitionException {
        Expression expr = null;
        int baseExpression_StartIndex = input.index();
        SimpleIdentifier i = null;

        Constant constant38 = null;

        ObjCppParser.expression_return expression39 = null;

        FunctionCall objCMethodCall40 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1307:2: (i= simpleIdentifier | constant | '(' expression ')' | objCMethodCall | selectorExpr | protocolExpr | encodingExpr )
            int alt84=7;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt84=1;
                }
                break;
            case DECIMAL_NUMBER:
            case STRING:
            case HEXADECIMAL_NUMBER:
            case OCTAL_NUMBER:
            case CHARACTER:
            case FLOAT_NUMBER:
            case 43:
            case 44:
                {
                alt84=2;
                }
                break;
            case 34:
                {
                alt84=3;
                }
                break;
            case 55:
                {
                alt84=4;
                }
                break;
            case 75:
                {
                alt84=5;
                }
                break;
            case 31:
                {
                alt84=6;
                }
                break;
            case 76:
                {
                alt84=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return expr;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }

            switch (alt84) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1308:3: i= simpleIdentifier
                    {
                    pushFollow(FOLLOW_simpleIdentifier_in_baseExpression3745);
                    i=simpleIdentifier();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {
                       expr = new VariableRef(i); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1309:3: constant
                    {
                    pushFollow(FOLLOW_constant_in_baseExpression3754);
                    constant38=constant();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {
                       expr = constant38; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1310:3: '(' expression ')'
                    {
                    match(input,34,FOLLOW_34_in_baseExpression3762); if (state.failed) return expr;
                    pushFollow(FOLLOW_expression_in_baseExpression3764);
                    expression39=expression();

                    state._fsp--;
                    if (state.failed) return expr;
                    match(input,35,FOLLOW_35_in_baseExpression3766); if (state.failed) return expr;
                    if ( state.backtracking==0 ) {
                       
                      			expr = (expression39!=null?expression39.expr:null); 
                      			if (expr != null)
                      				expr.setParenthesis(true);
                      		
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1315:3: objCMethodCall
                    {
                    pushFollow(FOLLOW_objCMethodCall_in_baseExpression3774);
                    objCMethodCall40=objCMethodCall();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {
                       expr = objCMethodCall40; 
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1316:3: selectorExpr
                    {
                    pushFollow(FOLLOW_selectorExpr_in_baseExpression3782);
                    selectorExpr();

                    state._fsp--;
                    if (state.failed) return expr;

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1317:3: protocolExpr
                    {
                    pushFollow(FOLLOW_protocolExpr_in_baseExpression3788);
                    protocolExpr();

                    state._fsp--;
                    if (state.failed) return expr;

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1318:3: encodingExpr
                    {
                    pushFollow(FOLLOW_encodingExpr_in_baseExpression3794);
                    encodingExpr();

                    state._fsp--;
                    if (state.failed) return expr;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 50, baseExpression_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "baseExpression"


    // $ANTLR start "selectorExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1321:1: selectorExpr returns [Expression expr] : '@selector' '(' selectorName ')' ;
    public final Expression selectorExpr() throws RecognitionException {
        Expression expr = null;
        int selectorExpr_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1322:2: ( '@selector' '(' selectorName ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1322:4: '@selector' '(' selectorName ')'
            {
            match(input,75,FOLLOW_75_in_selectorExpr3810); if (state.failed) return expr;
            match(input,34,FOLLOW_34_in_selectorExpr3815); if (state.failed) return expr;
            pushFollow(FOLLOW_selectorName_in_selectorExpr3820);
            selectorName();

            state._fsp--;
            if (state.failed) return expr;
            match(input,35,FOLLOW_35_in_selectorExpr3825); if (state.failed) return expr;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 51, selectorExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "selectorExpr"


    // $ANTLR start "selectorName"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1328:1: selectorName : IDENTIFIER ( IDENTIFIER ':' )* ;
    public final void selectorName() throws RecognitionException {
        int selectorName_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return ; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1329:2: ( IDENTIFIER ( IDENTIFIER ':' )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1329:4: IDENTIFIER ( IDENTIFIER ':' )*
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_selectorName3836); if (state.failed) return ;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1329:15: ( IDENTIFIER ':' )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==IDENTIFIER) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1329:16: IDENTIFIER ':'
            	    {
            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_selectorName3839); if (state.failed) return ;
            	    match(input,33,FOLLOW_33_in_selectorName3841); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop85;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 52, selectorName_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "selectorName"


    // $ANTLR start "protocolExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1332:1: protocolExpr : '@protocol' '(' IDENTIFIER ')' ;
    public final void protocolExpr() throws RecognitionException {
        int protocolExpr_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return ; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1333:2: ( '@protocol' '(' IDENTIFIER ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1333:4: '@protocol' '(' IDENTIFIER ')'
            {
            match(input,31,FOLLOW_31_in_protocolExpr3854); if (state.failed) return ;
            match(input,34,FOLLOW_34_in_protocolExpr3858); if (state.failed) return ;
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_protocolExpr3862); if (state.failed) return ;
            match(input,35,FOLLOW_35_in_protocolExpr3866); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 53, protocolExpr_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "protocolExpr"


    // $ANTLR start "encodingExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1339:1: encodingExpr : '@encode' '(' IDENTIFIER ')' ;
    public final void encodingExpr() throws RecognitionException {
        int encodingExpr_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return ; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1340:2: ( '@encode' '(' IDENTIFIER ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1340:4: '@encode' '(' IDENTIFIER ')'
            {
            match(input,76,FOLLOW_76_in_encodingExpr3877); if (state.failed) return ;
            match(input,34,FOLLOW_34_in_encodingExpr3882); if (state.failed) return ;
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_encodingExpr3886); if (state.failed) return ;
            match(input,35,FOLLOW_35_in_encodingExpr3891); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 54, encodingExpr_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "encodingExpr"


    // $ANTLR start "assignmentExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1346:1: assignmentExpr returns [Expression expr] : e= inlineCondExpr (op= assignmentOp f= assignmentExpr )? ;
    public final Expression assignmentExpr() throws RecognitionException {
        Expression expr = null;
        int assignmentExpr_StartIndex = input.index();
        Expression e = null;

        ObjCppParser.assignmentOp_return op = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1347:2: (e= inlineCondExpr (op= assignmentOp f= assignmentExpr )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1347:4: e= inlineCondExpr (op= assignmentOp f= assignmentExpr )?
            {
            pushFollow(FOLLOW_inlineCondExpr_in_assignmentExpr3908);
            e=inlineCondExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1348:3: (op= assignmentOp f= assignmentExpr )?
            int alt86=2;
            alt86 = dfa86.predict(input);
            switch (alt86) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1349:4: op= assignmentOp f= assignmentExpr
                    {
                    pushFollow(FOLLOW_assignmentOp_in_assignmentExpr3924);
                    op=assignmentOp();

                    state._fsp--;
                    if (state.failed) return expr;
                    pushFollow(FOLLOW_assignmentExpr_in_assignmentExpr3928);
                    f=assignmentExpr();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {
                       expr = new AssignmentOp(expr, getAssignmentOperator((op!=null?input.toString(op.start,op.stop):null)), f); 
                    }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 55, assignmentExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "assignmentExpr"

    public static class assignmentOp_return extends ParserRuleReturnScope {
        public Expression.AssignmentOperator op;
    };

    // $ANTLR start "assignmentOp"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1353:1: assignmentOp returns [Expression.AssignmentOperator op] : t= ( '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=' | '~=' ) ;
    public final ObjCppParser.assignmentOp_return assignmentOp() throws RecognitionException {
        ObjCppParser.assignmentOp_return retval = new ObjCppParser.assignmentOp_return();
        retval.start = input.LT(1);
        int assignmentOp_StartIndex = input.index();
        Token t=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return retval; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1354:2: (t= ( '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=' | '~=' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1354:5: t= ( '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=' | '~=' )
            {
            t=(Token)input.LT(1);
            if ( input.LA(1)==29||(input.LA(1)>=77 && input.LA(1)<=87) ) {
                input.consume();
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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 56, assignmentOp_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "assignmentOp"


    // $ANTLR start "inlineCondExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1359:1: inlineCondExpr returns [Expression expr] : e= logOrExpr ( '?' logOrExpr ':' logOrExpr )* ;
    public final Expression inlineCondExpr() throws RecognitionException {
        Expression expr = null;
        int inlineCondExpr_StartIndex = input.index();
        Expression e = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1360:2: (e= logOrExpr ( '?' logOrExpr ':' logOrExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1360:4: e= logOrExpr ( '?' logOrExpr ':' logOrExpr )*
            {
            pushFollow(FOLLOW_logOrExpr_in_inlineCondExpr4019);
            e=logOrExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1361:3: ( '?' logOrExpr ':' logOrExpr )*
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==88) ) {
                    alt87=1;
                }


                switch (alt87) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1362:4: '?' logOrExpr ':' logOrExpr
            	    {
            	    match(input,88,FOLLOW_88_in_inlineCondExpr4031); if (state.failed) return expr;
            	    pushFollow(FOLLOW_logOrExpr_in_inlineCondExpr4036);
            	    logOrExpr();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    match(input,33,FOLLOW_33_in_inlineCondExpr4042); if (state.failed) return expr;
            	    pushFollow(FOLLOW_logOrExpr_in_inlineCondExpr4047);
            	    logOrExpr();

            	    state._fsp--;
            	    if (state.failed) return expr;

            	    }
            	    break;

            	default :
            	    break loop87;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 57, inlineCondExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "inlineCondExpr"


    // $ANTLR start "addExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1369:1: addExpr returns [Expression expr] : e= multExpr (op= ( '+' | '-' ) f= multExpr )* ;
    public final Expression addExpr() throws RecognitionException {
        Expression expr = null;
        int addExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1370:2: (e= multExpr (op= ( '+' | '-' ) f= multExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1370:4: e= multExpr (op= ( '+' | '-' ) f= multExpr )*
            {
            pushFollow(FOLLOW_multExpr_in_addExpr4069);
            e=multExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1371:3: (op= ( '+' | '-' ) f= multExpr )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( ((LA88_0>=43 && LA88_0<=44)) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1372:4: op= ( '+' | '-' ) f= multExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=43 && input.LA(1)<=44) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return expr;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_multExpr_in_addExpr4095);
            	    f=multExpr();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       expr = new BinaryOp(expr, getBinaryOperator((op!=null?op.getText():null)), f); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop88;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 58, addExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "addExpr"


    // $ANTLR start "multExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1377:1: multExpr returns [Expression expr] : e= castExpr (op= ( '%' | '*' | '/' ) f= castExpr )* ;
    public final Expression multExpr() throws RecognitionException {
        Expression expr = null;
        int multExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1378:2: (e= castExpr (op= ( '%' | '*' | '/' ) f= castExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1378:4: e= castExpr (op= ( '%' | '*' | '/' ) f= castExpr )*
            {
            pushFollow(FOLLOW_castExpr_in_multExpr4119);
            e=castExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1379:3: (op= ( '%' | '*' | '/' ) f= castExpr )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==53||(LA89_0>=61 && LA89_0<=62)) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1380:4: op= ( '%' | '*' | '/' ) f= castExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( input.LA(1)==53||(input.LA(1)>=61 && input.LA(1)<=62) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return expr;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_castExpr_in_multExpr4151);
            	    f=castExpr();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       expr = new BinaryOp(expr, getBinaryOperator((op!=null?op.getText():null)), f); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop89;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 59, multExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "multExpr"


    // $ANTLR start "bitOrExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1385:1: bitOrExpr returns [Expression expr] : e= xorExpr (op= '|' f= xorExpr )* ;
    public final Expression bitOrExpr() throws RecognitionException {
        Expression expr = null;
        int bitOrExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1386:2: (e= xorExpr (op= '|' f= xorExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1386:4: e= xorExpr (op= '|' f= xorExpr )*
            {
            pushFollow(FOLLOW_xorExpr_in_bitOrExpr4175);
            e=xorExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1387:3: (op= '|' f= xorExpr )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==67) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1388:4: op= '|' f= xorExpr
            	    {
            	    op=(Token)match(input,67,FOLLOW_67_in_bitOrExpr4189); if (state.failed) return expr;
            	    pushFollow(FOLLOW_xorExpr_in_bitOrExpr4196);
            	    f=xorExpr();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       expr = new BinaryOp(expr, getBinaryOperator((op!=null?op.getText():null)), f); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop90;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 60, bitOrExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "bitOrExpr"


    // $ANTLR start "bitAndExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1393:1: bitAndExpr returns [Expression expr] : e= equalExpr (op= '&' f= equalExpr )* ;
    public final Expression bitAndExpr() throws RecognitionException {
        Expression expr = null;
        int bitAndExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1394:2: (e= equalExpr (op= '&' f= equalExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1394:4: e= equalExpr (op= '&' f= equalExpr )*
            {
            pushFollow(FOLLOW_equalExpr_in_bitAndExpr4220);
            e=equalExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1395:3: (op= '&' f= equalExpr )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==54) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1396:4: op= '&' f= equalExpr
            	    {
            	    op=(Token)match(input,54,FOLLOW_54_in_bitAndExpr4233); if (state.failed) return expr;
            	    pushFollow(FOLLOW_equalExpr_in_bitAndExpr4240);
            	    f=equalExpr();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       expr = new BinaryOp(expr, getBinaryOperator((op!=null?op.getText():null)), f); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop91;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 61, bitAndExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "bitAndExpr"


    // $ANTLR start "shiftExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1402:1: shiftExpr returns [Expression expr] : e= addExpr (op= ( '>>' | '<<' ) f= addExpr )* ;
    public final Expression shiftExpr() throws RecognitionException {
        Expression expr = null;
        int shiftExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1403:2: (e= addExpr (op= ( '>>' | '<<' ) f= addExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1403:4: e= addExpr (op= ( '>>' | '<<' ) f= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_shiftExpr4265);
            e=addExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1404:3: (op= ( '>>' | '<<' ) f= addExpr )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==63||LA92_0==65) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1405:4: op= ( '>>' | '<<' ) f= addExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( input.LA(1)==63||input.LA(1)==65 ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return expr;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_addExpr_in_shiftExpr4291);
            	    f=addExpr();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       expr = new BinaryOp(expr, getBinaryOperator((op!=null?op.getText():null)), f); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop92;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 62, shiftExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "shiftExpr"


    // $ANTLR start "xorExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1410:1: xorExpr returns [Expression expr] : e= bitAndExpr (op= '^' f= bitAndExpr )* ;
    public final Expression xorExpr() throws RecognitionException {
        Expression expr = null;
        int xorExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1411:2: (e= bitAndExpr (op= '^' f= bitAndExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1411:4: e= bitAndExpr (op= '^' f= bitAndExpr )*
            {
            pushFollow(FOLLOW_bitAndExpr_in_xorExpr4315);
            e=bitAndExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1412:3: (op= '^' f= bitAndExpr )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==58) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1413:4: op= '^' f= bitAndExpr
            	    {
            	    op=(Token)match(input,58,FOLLOW_58_in_xorExpr4328); if (state.failed) return expr;
            	    pushFollow(FOLLOW_bitAndExpr_in_xorExpr4335);
            	    f=bitAndExpr();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       expr = new BinaryOp(expr, getBinaryOperator((op!=null?op.getText():null)), f); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop93;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 63, xorExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "xorExpr"


    // $ANTLR start "logOrExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1418:1: logOrExpr returns [Expression expr] : e= logAndExpr (op= '||' f= logAndExpr )* ;
    public final Expression logOrExpr() throws RecognitionException {
        Expression expr = null;
        int logOrExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1419:2: (e= logAndExpr (op= '||' f= logAndExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1419:4: e= logAndExpr (op= '||' f= logAndExpr )*
            {
            pushFollow(FOLLOW_logAndExpr_in_logOrExpr4359);
            e=logAndExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1420:3: (op= '||' f= logAndExpr )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==66) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1421:4: op= '||' f= logAndExpr
            	    {
            	    op=(Token)match(input,66,FOLLOW_66_in_logOrExpr4372); if (state.failed) return expr;
            	    pushFollow(FOLLOW_logAndExpr_in_logOrExpr4379);
            	    f=logAndExpr();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       expr = new BinaryOp(expr, getBinaryOperator((op!=null?op.getText():null)), f); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop94;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 64, logOrExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "logOrExpr"


    // $ANTLR start "logAndExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1426:1: logAndExpr returns [Expression expr] : e= bitOrExpr (op= '&&' f= bitOrExpr )* ;
    public final Expression logAndExpr() throws RecognitionException {
        Expression expr = null;
        int logAndExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1427:2: (e= bitOrExpr (op= '&&' f= bitOrExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1427:4: e= bitOrExpr (op= '&&' f= bitOrExpr )*
            {
            pushFollow(FOLLOW_bitOrExpr_in_logAndExpr4403);
            e=bitOrExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1428:3: (op= '&&' f= bitOrExpr )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==68) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1429:4: op= '&&' f= bitOrExpr
            	    {
            	    op=(Token)match(input,68,FOLLOW_68_in_logAndExpr4416); if (state.failed) return expr;
            	    pushFollow(FOLLOW_bitOrExpr_in_logAndExpr4423);
            	    f=bitOrExpr();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       expr = new BinaryOp(expr, getBinaryOperator((op!=null?op.getText():null)), f); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop95;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 65, logAndExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "logAndExpr"


    // $ANTLR start "equalExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1434:1: equalExpr returns [Expression expr] : e= compareExpr (op= ( '!=' | '==' ) f= compareExpr )* ;
    public final Expression equalExpr() throws RecognitionException {
        Expression expr = null;
        int equalExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1435:2: (e= compareExpr (op= ( '!=' | '==' ) f= compareExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1435:4: e= compareExpr (op= ( '!=' | '==' ) f= compareExpr )*
            {
            pushFollow(FOLLOW_compareExpr_in_equalExpr4447);
            e=compareExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1436:3: (op= ( '!=' | '==' ) f= compareExpr )*
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( ((LA96_0>=71 && LA96_0<=72)) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1437:4: op= ( '!=' | '==' ) f= compareExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=71 && input.LA(1)<=72) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return expr;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_compareExpr_in_equalExpr4473);
            	    f=compareExpr();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       expr = new BinaryOp(expr, getBinaryOperator((op!=null?op.getText():null)), f); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop96;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 66, equalExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "equalExpr"


    // $ANTLR start "compareExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1442:1: compareExpr returns [Expression expr] : e= shiftExpr (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )* ;
    public final Expression compareExpr() throws RecognitionException {
        Expression expr = null;
        int compareExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1443:2: (e= shiftExpr (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1443:4: e= shiftExpr (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )*
            {
            pushFollow(FOLLOW_shiftExpr_in_compareExpr4497);
            e=shiftExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1444:3: (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )*
            loop97:
            do {
                int alt97=2;
                alt97 = dfa97.predict(input);
                switch (alt97) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1445:4: op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=36 && input.LA(1)<=37)||(input.LA(1)>=69 && input.LA(1)<=70) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return expr;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_shiftExpr_in_compareExpr4532);
            	    f=shiftExpr();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       expr = new BinaryOp(expr, getBinaryOperator((op!=null?op.getText():null)), f); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop97;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 67, compareExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "compareExpr"


    // $ANTLR start "castExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1450:1: castExpr returns [Expression expr] : ( '(' tr= mutableTypeRef ')' inner= castExpr | e= unaryExpr );
    public final Expression castExpr() throws RecognitionException {
        Expression expr = null;
        int castExpr_StartIndex = input.index();
        TypeRef tr = null;

        Expression inner = null;

        Expression e = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1451:2: ( '(' tr= mutableTypeRef ')' inner= castExpr | e= unaryExpr )
            int alt98=2;
            alt98 = dfa98.predict(input);
            switch (alt98) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1451:4: '(' tr= mutableTypeRef ')' inner= castExpr
                    {
                    match(input,34,FOLLOW_34_in_castExpr4554); if (state.failed) return expr;
                    pushFollow(FOLLOW_mutableTypeRef_in_castExpr4558);
                    tr=mutableTypeRef();

                    state._fsp--;
                    if (state.failed) return expr;
                    match(input,35,FOLLOW_35_in_castExpr4560); if (state.failed) return expr;
                    pushFollow(FOLLOW_castExpr_in_castExpr4564);
                    inner=castExpr();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {
                       expr = new Cast(tr, inner); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1452:3: e= unaryExpr
                    {
                    pushFollow(FOLLOW_unaryExpr_in_castExpr4575);
                    e=unaryExpr();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {
                       expr = e; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 68, castExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "castExpr"


    // $ANTLR start "unaryExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1455:1: unaryExpr returns [Expression expr] : ({...}? IDENTIFIER ( '(' tr= mutableTypeRef ')' ) | p= postfixExpr | uo= unaryOp castExpr );
    public final Expression unaryExpr() throws RecognitionException {
        Expression expr = null;
        int unaryExpr_StartIndex = input.index();
        TypeRef tr = null;

        Expression p = null;

        Expression.UnaryOperator uo = null;

        Expression castExpr41 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1456:2: ({...}? IDENTIFIER ( '(' tr= mutableTypeRef ')' ) | p= postfixExpr | uo= unaryOp castExpr )
            int alt99=3;
            alt99 = dfa99.predict(input);
            switch (alt99) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1457:3: {...}? IDENTIFIER ( '(' tr= mutableTypeRef ')' )
                    {
                    if ( !(( next("sizeof") )) ) {
                        if (state.backtracking>0) {state.failed=true; return expr;}
                        throw new FailedPredicateException(input, "unaryExpr", " next(\"sizeof\") ");
                    }
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_unaryExpr4597); if (state.failed) return expr;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1457:34: ( '(' tr= mutableTypeRef ')' )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1458:4: '(' tr= mutableTypeRef ')'
                    {
                    match(input,34,FOLLOW_34_in_unaryExpr4604); if (state.failed) return expr;
                    pushFollow(FOLLOW_mutableTypeRef_in_unaryExpr4608);
                    tr=mutableTypeRef();

                    state._fsp--;
                    if (state.failed) return expr;
                    match(input,35,FOLLOW_35_in_unaryExpr4610); if (state.failed) return expr;
                    if ( state.backtracking==0 ) {

                      				expr = new FunctionCall(varRef("sizeof"), new TypeRefExpression(tr));
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1463:3: p= postfixExpr
                    {
                    pushFollow(FOLLOW_postfixExpr_in_unaryExpr4628);
                    p=postfixExpr();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {
                       expr = p; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1464:3: uo= unaryOp castExpr
                    {
                    pushFollow(FOLLOW_unaryOp_in_unaryExpr4638);
                    uo=unaryOp();

                    state._fsp--;
                    if (state.failed) return expr;
                    pushFollow(FOLLOW_castExpr_in_unaryExpr4640);
                    castExpr41=castExpr();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {
                       expr = new UnaryOp(castExpr41, uo); 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 69, unaryExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "unaryExpr"


    // $ANTLR start "unaryOp"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1467:1: unaryOp returns [Expression.UnaryOperator op] : t= ( '++' | '--' | '&' | '*' | '-' | '~' | '!' ) ;
    public final Expression.UnaryOperator unaryOp() throws RecognitionException {
        Expression.UnaryOperator op = null;
        int unaryOp_StartIndex = input.index();
        Token t=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return op; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1468:2: (t= ( '++' | '--' | '&' | '*' | '-' | '~' | '!' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1468:5: t= ( '++' | '--' | '&' | '*' | '-' | '~' | '!' )
            {
            t=(Token)input.LT(1);
            if ( input.LA(1)==44||(input.LA(1)>=53 && input.LA(1)<=54)||input.LA(1)==74||(input.LA(1)>=89 && input.LA(1)<=91) ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return op;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {

              			op = Expression.getUnaryOperator((t!=null?t.getText():null));
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 70, unaryOp_StartIndex); }
        }
        return op;
    }
    // $ANTLR end "unaryOp"


    // $ANTLR start "postfixExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1473:1: postfixExpr returns [Expression expr] : baseExpression ( '[' expression ']' | '(' ( topLevelExprList )? ')' | '::' ao= simpleIdentifier | '.' di= simpleIdentifier | '->' ai= simpleIdentifier | '++' | '--' )* ;
    public final Expression postfixExpr() throws RecognitionException {
        Expression expr = null;
        int postfixExpr_StartIndex = input.index();
        SimpleIdentifier ao = null;

        SimpleIdentifier di = null;

        SimpleIdentifier ai = null;

        Expression baseExpression42 = null;

        ObjCppParser.expression_return expression43 = null;

        List<Expression> topLevelExprList44 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1474:2: ( baseExpression ( '[' expression ']' | '(' ( topLevelExprList )? ')' | '::' ao= simpleIdentifier | '.' di= simpleIdentifier | '->' ai= simpleIdentifier | '++' | '--' )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1475:3: baseExpression ( '[' expression ']' | '(' ( topLevelExprList )? ')' | '::' ao= simpleIdentifier | '.' di= simpleIdentifier | '->' ai= simpleIdentifier | '++' | '--' )*
            {
            pushFollow(FOLLOW_baseExpression_in_postfixExpr4707);
            baseExpression42=baseExpression();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = baseExpression42; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1476:3: ( '[' expression ']' | '(' ( topLevelExprList )? ')' | '::' ao= simpleIdentifier | '.' di= simpleIdentifier | '->' ai= simpleIdentifier | '++' | '--' )*
            loop101:
            do {
                int alt101=8;
                switch ( input.LA(1) ) {
                case 55:
                    {
                    alt101=1;
                    }
                    break;
                case 34:
                    {
                    alt101=2;
                    }
                    break;
                case 73:
                    {
                    alt101=3;
                    }
                    break;
                case 92:
                    {
                    alt101=4;
                    }
                    break;
                case 93:
                    {
                    alt101=5;
                    }
                    break;
                case 89:
                    {
                    alt101=6;
                    }
                    break;
                case 90:
                    {
                    alt101=7;
                    }
                    break;

                }

                switch (alt101) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1477:4: '[' expression ']'
            	    {
            	    match(input,55,FOLLOW_55_in_postfixExpr4718); if (state.failed) return expr;
            	    pushFollow(FOLLOW_expression_in_postfixExpr4720);
            	    expression43=expression();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    match(input,56,FOLLOW_56_in_postfixExpr4722); if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       
            	      				expr = new ArrayAccess(expr, (expression43!=null?expression43.expr:null)); 
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1480:4: '(' ( topLevelExprList )? ')'
            	    {
            	    match(input,34,FOLLOW_34_in_postfixExpr4731); if (state.failed) return expr;
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1480:8: ( topLevelExprList )?
            	    int alt100=2;
            	    int LA100_0 = input.LA(1);

            	    if ( ((LA100_0>=DECIMAL_NUMBER && LA100_0<=FLOAT_NUMBER)||LA100_0==31||LA100_0==34||(LA100_0>=43 && LA100_0<=44)||(LA100_0>=53 && LA100_0<=55)||(LA100_0>=74 && LA100_0<=76)||(LA100_0>=89 && LA100_0<=91)) ) {
            	        alt100=1;
            	    }
            	    switch (alt100) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: topLevelExprList
            	            {
            	            pushFollow(FOLLOW_topLevelExprList_in_postfixExpr4733);
            	            topLevelExprList44=topLevelExprList();

            	            state._fsp--;
            	            if (state.failed) return expr;

            	            }
            	            break;

            	    }

            	    match(input,35,FOLLOW_35_in_postfixExpr4736); if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {

            	      				FunctionCall fc = new FunctionCall(expr);
            	      				if (topLevelExprList44 != null)
            	      					for (Expression x : topLevelExprList44)
            	      						fc.addArgument(x);
            	      				expr = fc;
            	      			
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1487:4: '::' ao= simpleIdentifier
            	    {
            	    match(input,73,FOLLOW_73_in_postfixExpr4745); if (state.failed) return expr;
            	    pushFollow(FOLLOW_simpleIdentifier_in_postfixExpr4749);
            	    ao=simpleIdentifier();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {

            	      				expr = new MemberRef(expr, MemberRefStyle.Colons, ao); 
            	      			
            	    }

            	    }
            	    break;
            	case 4 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1490:4: '.' di= simpleIdentifier
            	    {
            	    match(input,92,FOLLOW_92_in_postfixExpr4758); if (state.failed) return expr;
            	    pushFollow(FOLLOW_simpleIdentifier_in_postfixExpr4762);
            	    di=simpleIdentifier();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       
            	      				expr = new MemberRef(expr, MemberRefStyle.Dot, di); 
            	      			
            	    }

            	    }
            	    break;
            	case 5 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1493:4: '->' ai= simpleIdentifier
            	    {
            	    match(input,93,FOLLOW_93_in_postfixExpr4771); if (state.failed) return expr;
            	    pushFollow(FOLLOW_simpleIdentifier_in_postfixExpr4775);
            	    ai=simpleIdentifier();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       
            	      				expr = new MemberRef(expr, MemberRefStyle.Arrow, ai); 
            	      			
            	    }

            	    }
            	    break;
            	case 6 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1496:4: '++'
            	    {
            	    match(input,89,FOLLOW_89_in_postfixExpr4784); if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       
            	      				expr = new UnaryOp(expr, UnaryOperator.PostIncr); 
            	      			
            	    }

            	    }
            	    break;
            	case 7 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1499:4: '--'
            	    {
            	    match(input,90,FOLLOW_90_in_postfixExpr4793); if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       
            	      				expr = new UnaryOp(expr, UnaryOperator.PostDecr); 
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop101;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 71, postfixExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "postfixExpr"

    public static class topLevelExpr_return extends ParserRuleReturnScope {
        public Expression expr;
    };

    // $ANTLR start "topLevelExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1505:1: topLevelExpr returns [Expression expr] : e= assignmentExpr ;
    public final ObjCppParser.topLevelExpr_return topLevelExpr() throws RecognitionException {
        ObjCppParser.topLevelExpr_return retval = new ObjCppParser.topLevelExpr_return();
        retval.start = input.LT(1);
        int topLevelExpr_StartIndex = input.index();
        Expression e = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return retval; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1506:2: (e= assignmentExpr )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1506:4: e= assignmentExpr
            {
            pushFollow(FOLLOW_assignmentExpr_in_topLevelExpr4817);
            e=assignmentExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               retval.expr = e; 
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 72, topLevelExpr_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "topLevelExpr"


    // $ANTLR start "topLevelExprList"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1508:1: topLevelExprList returns [List<Expression> exprs] : e= topLevelExpr ( ',' f= topLevelExpr )* ;
    public final List<Expression> topLevelExprList() throws RecognitionException {
        List<Expression> exprs = null;
        int topLevelExprList_StartIndex = input.index();
        ObjCppParser.topLevelExpr_return e = null;

        ObjCppParser.topLevelExpr_return f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return exprs; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1509:2: (e= topLevelExpr ( ',' f= topLevelExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1510:3: e= topLevelExpr ( ',' f= topLevelExpr )*
            {
            if ( state.backtracking==0 ) {
               exprs = new ArrayList<Expression>(); 
            }
            pushFollow(FOLLOW_topLevelExpr_in_topLevelExprList4842);
            e=topLevelExpr();

            state._fsp--;
            if (state.failed) return exprs;
            if ( state.backtracking==0 ) {
               exprs.add((e!=null?e.expr:null)); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1512:3: ( ',' f= topLevelExpr )*
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( (LA102_0==28) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1513:4: ',' f= topLevelExpr
            	    {
            	    match(input,28,FOLLOW_28_in_topLevelExprList4853); if (state.failed) return exprs;
            	    pushFollow(FOLLOW_topLevelExpr_in_topLevelExprList4860);
            	    f=topLevelExpr();

            	    state._fsp--;
            	    if (state.failed) return exprs;
            	    if ( state.backtracking==0 ) {
            	       exprs.add((f!=null?f.expr:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop102;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 73, topLevelExprList_StartIndex); }
        }
        return exprs;
    }
    // $ANTLR end "topLevelExprList"

    public static class expression_return extends ParserRuleReturnScope {
        public Expression expr;
    };

    // $ANTLR start "expression"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1518:1: expression returns [Expression expr] : l= topLevelExprList ;
    public final ObjCppParser.expression_return expression() throws RecognitionException {
        ObjCppParser.expression_return retval = new ObjCppParser.expression_return();
        retval.start = input.LT(1);
        int expression_StartIndex = input.index();
        List<Expression> l = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return retval; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1519:2: (l= topLevelExprList )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1519:4: l= topLevelExprList
            {
            pushFollow(FOLLOW_topLevelExprList_in_expression4884);
            l=topLevelExprList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {

              			if (l != null) {
              				if (l.size() == 1)
              					retval.expr = l.get(0);
              				else
              					retval.expr = new ExpressionSequence(l);
              			}
              		
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 74, expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "expression"


    // $ANTLR start "statementsBlock"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1530:1: statementsBlock returns [Block stat] : '{' ( statement )* '}' ;
    public final Block statementsBlock() throws RecognitionException {
        Symbols_stack.push(new Symbols_scope());

        Block stat = null;
        int statementsBlock_StartIndex = input.index();
        Statement statement45 = null;



        	((Symbols_scope)Symbols_stack.peek()).typeIdentifiers = new HashSet<String>();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return stat; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1535:2: ( '{' ( statement )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1535:4: '{' ( statement )* '}'
            {
            if ( state.backtracking==0 ) {
               stat = new Block(); 
            }
            match(input,23,FOLLOW_23_in_statementsBlock4918); if (state.failed) return stat;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1537:3: ( statement )*
            loop103:
            do {
                int alt103=2;
                int LA103_0 = input.LA(1);

                if ( ((LA103_0>=DECIMAL_NUMBER && LA103_0<=FLOAT_NUMBER)||LA103_0==23||(LA103_0>=25 && LA103_0<=27)||(LA103_0>=30 && LA103_0<=32)||LA103_0==34||(LA103_0>=43 && LA103_0<=45)||(LA103_0>=50 && LA103_0<=55)||(LA103_0>=57 && LA103_0<=60)||(LA103_0>=74 && LA103_0<=76)||(LA103_0>=89 && LA103_0<=91)||(LA103_0>=94 && LA103_0<=95)||(LA103_0>=97 && LA103_0<=100)) ) {
                    alt103=1;
                }


                switch (alt103) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1538:4: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_statementsBlock4928);
            	    statement45=statement();

            	    state._fsp--;
            	    if (state.failed) return stat;
            	    if ( state.backtracking==0 ) {

            	      				stat.addStatement(statement45);
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop103;
                }
            } while (true);

            match(input,24,FOLLOW_24_in_statementsBlock4940); if (state.failed) return stat;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 75, statementsBlock_StartIndex); }
            Symbols_stack.pop();

        }
        return stat;
    }
    // $ANTLR end "statementsBlock"


    // $ANTLR start "statement"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1544:1: statement returns [Statement stat] : (b= statementsBlock | declaration | es= expression ';' | rt= 'return' rex= expression ';' | IDENTIFIER ':' | 'break' ';' | 'if' '(' topLevelExpr ')' statement ( 'else' statement )? | 'while' '(' topLevelExpr ')' statement | 'do' statement 'while' '(' topLevelExpr ')' ';' | 'for' '(' ( expression )? ';' ( expression )? ';' ( expression )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' topLevelExpr ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement );
    public final Statement statement() throws RecognitionException {
        Statement stat = null;
        int statement_StartIndex = input.index();
        Token rt=null;
        Block b = null;

        ObjCppParser.expression_return es = null;

        ObjCppParser.expression_return rex = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return stat; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1545:2: (b= statementsBlock | declaration | es= expression ';' | rt= 'return' rex= expression ';' | IDENTIFIER ':' | 'break' ';' | 'if' '(' topLevelExpr ')' statement ( 'else' statement )? | 'while' '(' topLevelExpr ')' statement | 'do' statement 'while' '(' topLevelExpr ')' ';' | 'for' '(' ( expression )? ';' ( expression )? ';' ( expression )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' topLevelExpr ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement )
            int alt109=13;
            alt109 = dfa109.predict(input);
            switch (alt109) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1546:3: b= statementsBlock
                    {
                    pushFollow(FOLLOW_statementsBlock_in_statement4959);
                    b=statementsBlock();

                    state._fsp--;
                    if (state.failed) return stat;
                    if ( state.backtracking==0 ) {
                       stat = b; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1547:3: declaration
                    {
                    pushFollow(FOLLOW_declaration_in_statement4967);
                    declaration();

                    state._fsp--;
                    if (state.failed) return stat;

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1548:3: es= expression ';'
                    {
                    pushFollow(FOLLOW_expression_in_statement4976);
                    es=expression();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,25,FOLLOW_25_in_statement4978); if (state.failed) return stat;
                    if ( state.backtracking==0 ) {
                       stat = new ExpressionStatement((es!=null?es.expr:null)); 
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1549:3: rt= 'return' rex= expression ';'
                    {
                    rt=(Token)match(input,52,FOLLOW_52_in_statement4988); if (state.failed) return stat;
                    pushFollow(FOLLOW_expression_in_statement4992);
                    rex=expression();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,25,FOLLOW_25_in_statement4994); if (state.failed) return stat;
                    if ( state.backtracking==0 ) {
                       
                      			stat = mark(new Return((rex!=null?rex.expr:null)), getLine(rt));
                      		
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1552:3: IDENTIFIER ':'
                    {
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement5002); if (state.failed) return stat;
                    match(input,33,FOLLOW_33_in_statement5004); if (state.failed) return stat;

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1553:3: 'break' ';'
                    {
                    match(input,94,FOLLOW_94_in_statement5011); if (state.failed) return stat;
                    match(input,25,FOLLOW_25_in_statement5013); if (state.failed) return stat;

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1554:3: 'if' '(' topLevelExpr ')' statement ( 'else' statement )?
                    {
                    match(input,95,FOLLOW_95_in_statement5019); if (state.failed) return stat;
                    match(input,34,FOLLOW_34_in_statement5021); if (state.failed) return stat;
                    pushFollow(FOLLOW_topLevelExpr_in_statement5023);
                    topLevelExpr();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,35,FOLLOW_35_in_statement5025); if (state.failed) return stat;
                    pushFollow(FOLLOW_statement_in_statement5027);
                    statement();

                    state._fsp--;
                    if (state.failed) return stat;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1554:39: ( 'else' statement )?
                    int alt104=2;
                    int LA104_0 = input.LA(1);

                    if ( (LA104_0==96) ) {
                        int LA104_1 = input.LA(2);

                        if ( (synpred208_ObjCpp()) ) {
                            alt104=1;
                        }
                    }
                    switch (alt104) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1554:40: 'else' statement
                            {
                            match(input,96,FOLLOW_96_in_statement5030); if (state.failed) return stat;
                            pushFollow(FOLLOW_statement_in_statement5032);
                            statement();

                            state._fsp--;
                            if (state.failed) return stat;

                            }
                            break;

                    }


                    }
                    break;
                case 8 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1555:3: 'while' '(' topLevelExpr ')' statement
                    {
                    match(input,97,FOLLOW_97_in_statement5041); if (state.failed) return stat;
                    match(input,34,FOLLOW_34_in_statement5043); if (state.failed) return stat;
                    pushFollow(FOLLOW_topLevelExpr_in_statement5045);
                    topLevelExpr();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,35,FOLLOW_35_in_statement5047); if (state.failed) return stat;
                    pushFollow(FOLLOW_statement_in_statement5049);
                    statement();

                    state._fsp--;
                    if (state.failed) return stat;

                    }
                    break;
                case 9 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1556:3: 'do' statement 'while' '(' topLevelExpr ')' ';'
                    {
                    match(input,98,FOLLOW_98_in_statement5056); if (state.failed) return stat;
                    pushFollow(FOLLOW_statement_in_statement5058);
                    statement();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,97,FOLLOW_97_in_statement5060); if (state.failed) return stat;
                    match(input,34,FOLLOW_34_in_statement5062); if (state.failed) return stat;
                    pushFollow(FOLLOW_topLevelExpr_in_statement5064);
                    topLevelExpr();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,35,FOLLOW_35_in_statement5066); if (state.failed) return stat;
                    match(input,25,FOLLOW_25_in_statement5068); if (state.failed) return stat;

                    }
                    break;
                case 10 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1557:3: 'for' '(' ( expression )? ';' ( expression )? ';' ( expression )? ')' statement
                    {
                    match(input,99,FOLLOW_99_in_statement5075); if (state.failed) return stat;
                    match(input,34,FOLLOW_34_in_statement5077); if (state.failed) return stat;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1557:13: ( expression )?
                    int alt105=2;
                    int LA105_0 = input.LA(1);

                    if ( ((LA105_0>=DECIMAL_NUMBER && LA105_0<=FLOAT_NUMBER)||LA105_0==31||LA105_0==34||(LA105_0>=43 && LA105_0<=44)||(LA105_0>=53 && LA105_0<=55)||(LA105_0>=74 && LA105_0<=76)||(LA105_0>=89 && LA105_0<=91)) ) {
                        alt105=1;
                    }
                    switch (alt105) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement5079);
                            expression();

                            state._fsp--;
                            if (state.failed) return stat;

                            }
                            break;

                    }

                    match(input,25,FOLLOW_25_in_statement5082); if (state.failed) return stat;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1557:29: ( expression )?
                    int alt106=2;
                    int LA106_0 = input.LA(1);

                    if ( ((LA106_0>=DECIMAL_NUMBER && LA106_0<=FLOAT_NUMBER)||LA106_0==31||LA106_0==34||(LA106_0>=43 && LA106_0<=44)||(LA106_0>=53 && LA106_0<=55)||(LA106_0>=74 && LA106_0<=76)||(LA106_0>=89 && LA106_0<=91)) ) {
                        alt106=1;
                    }
                    switch (alt106) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement5084);
                            expression();

                            state._fsp--;
                            if (state.failed) return stat;

                            }
                            break;

                    }

                    match(input,25,FOLLOW_25_in_statement5087); if (state.failed) return stat;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1557:45: ( expression )?
                    int alt107=2;
                    int LA107_0 = input.LA(1);

                    if ( ((LA107_0>=DECIMAL_NUMBER && LA107_0<=FLOAT_NUMBER)||LA107_0==31||LA107_0==34||(LA107_0>=43 && LA107_0<=44)||(LA107_0>=53 && LA107_0<=55)||(LA107_0>=74 && LA107_0<=76)||(LA107_0>=89 && LA107_0<=91)) ) {
                        alt107=1;
                    }
                    switch (alt107) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement5089);
                            expression();

                            state._fsp--;
                            if (state.failed) return stat;

                            }
                            break;

                    }

                    match(input,35,FOLLOW_35_in_statement5092); if (state.failed) return stat;
                    pushFollow(FOLLOW_statement_in_statement5094);
                    statement();

                    state._fsp--;
                    if (state.failed) return stat;

                    }
                    break;
                case 11 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1558:3: 'switch' '(' expression ')' '{' ( 'case' topLevelExpr ':' | statement )* '}'
                    {
                    match(input,100,FOLLOW_100_in_statement5101); if (state.failed) return stat;
                    match(input,34,FOLLOW_34_in_statement5103); if (state.failed) return stat;
                    pushFollow(FOLLOW_expression_in_statement5105);
                    expression();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,35,FOLLOW_35_in_statement5107); if (state.failed) return stat;
                    match(input,23,FOLLOW_23_in_statement5109); if (state.failed) return stat;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1559:4: ( 'case' topLevelExpr ':' | statement )*
                    loop108:
                    do {
                        int alt108=3;
                        int LA108_0 = input.LA(1);

                        if ( (LA108_0==101) ) {
                            alt108=1;
                        }
                        else if ( ((LA108_0>=DECIMAL_NUMBER && LA108_0<=FLOAT_NUMBER)||LA108_0==23||(LA108_0>=25 && LA108_0<=27)||(LA108_0>=30 && LA108_0<=32)||LA108_0==34||(LA108_0>=43 && LA108_0<=45)||(LA108_0>=50 && LA108_0<=55)||(LA108_0>=57 && LA108_0<=60)||(LA108_0>=74 && LA108_0<=76)||(LA108_0>=89 && LA108_0<=91)||(LA108_0>=94 && LA108_0<=95)||(LA108_0>=97 && LA108_0<=100)) ) {
                            alt108=2;
                        }


                        switch (alt108) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1560:5: 'case' topLevelExpr ':'
                    	    {
                    	    match(input,101,FOLLOW_101_in_statement5122); if (state.failed) return stat;
                    	    pushFollow(FOLLOW_topLevelExpr_in_statement5124);
                    	    topLevelExpr();

                    	    state._fsp--;
                    	    if (state.failed) return stat;
                    	    match(input,33,FOLLOW_33_in_statement5126); if (state.failed) return stat;

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1561:5: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement5134);
                    	    statement();

                    	    state._fsp--;
                    	    if (state.failed) return stat;

                    	    }
                    	    break;

                    	default :
                    	    break loop108;
                        }
                    } while (true);

                    match(input,24,FOLLOW_24_in_statement5144); if (state.failed) return stat;

                    }
                    break;
                case 12 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1564:3: ';'
                    {
                    match(input,25,FOLLOW_25_in_statement5150); if (state.failed) return stat;

                    }
                    break;
                case 13 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1565:3: {...}? IDENTIFIER '(' varDecl ':' expression ')' statement
                    {
                    if ( !(( next("foreach") )) ) {
                        if (state.backtracking>0) {state.failed=true; return stat;}
                        throw new FailedPredicateException(input, "statement", " next(\"foreach\") ");
                    }
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement5158); if (state.failed) return stat;
                    match(input,34,FOLLOW_34_in_statement5160); if (state.failed) return stat;
                    pushFollow(FOLLOW_varDecl_in_statement5162);
                    varDecl();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,33,FOLLOW_33_in_statement5164); if (state.failed) return stat;
                    pushFollow(FOLLOW_expression_in_statement5166);
                    expression();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,35,FOLLOW_35_in_statement5168); if (state.failed) return stat;
                    pushFollow(FOLLOW_statement_in_statement5170);
                    statement();

                    state._fsp--;
                    if (state.failed) return stat;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 76, statement_StartIndex); }
        }
        return stat;
    }
    // $ANTLR end "statement"


    // $ANTLR start "constant"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1568:1: constant returns [Constant constant] : ( (s= ( '-' | '+' ) )? ( DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER ) | CHARACTER | (s2= ( '-' | '+' ) )? FLOAT_NUMBER | STRING );
    public final Constant constant() throws RecognitionException {
        Constant constant = null;
        int constant_StartIndex = input.index();
        Token s=null;
        Token s2=null;
        Token DECIMAL_NUMBER46=null;
        Token HEXADECIMAL_NUMBER47=null;
        Token OCTAL_NUMBER48=null;
        Token CHARACTER49=null;
        Token FLOAT_NUMBER50=null;
        Token STRING51=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return constant; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1569:2: ( (s= ( '-' | '+' ) )? ( DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER ) | CHARACTER | (s2= ( '-' | '+' ) )? FLOAT_NUMBER | STRING )
            int alt113=4;
            switch ( input.LA(1) ) {
            case 43:
            case 44:
                {
                int LA113_1 = input.LA(2);

                if ( (LA113_1==FLOAT_NUMBER) ) {
                    alt113=3;
                }
                else if ( (LA113_1==DECIMAL_NUMBER||(LA113_1>=HEXADECIMAL_NUMBER && LA113_1<=OCTAL_NUMBER)) ) {
                    alt113=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return constant;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 113, 1, input);

                    throw nvae;
                }
                }
                break;
            case DECIMAL_NUMBER:
            case HEXADECIMAL_NUMBER:
            case OCTAL_NUMBER:
                {
                alt113=1;
                }
                break;
            case CHARACTER:
                {
                alt113=2;
                }
                break;
            case FLOAT_NUMBER:
                {
                alt113=3;
                }
                break;
            case STRING:
                {
                alt113=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return constant;}
                NoViableAltException nvae =
                    new NoViableAltException("", 113, 0, input);

                throw nvae;
            }

            switch (alt113) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1569:4: (s= ( '-' | '+' ) )? ( DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1569:5: (s= ( '-' | '+' ) )?
                    int alt110=2;
                    int LA110_0 = input.LA(1);

                    if ( ((LA110_0>=43 && LA110_0<=44)) ) {
                        alt110=1;
                    }
                    switch (alt110) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: s= ( '-' | '+' )
                            {
                            s=(Token)input.LT(1);
                            if ( (input.LA(1)>=43 && input.LA(1)<=44) ) {
                                input.consume();
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return constant;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1569:19: ( DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER )
                    int alt111=3;
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
                    default:
                        if (state.backtracking>0) {state.failed=true; return constant;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 111, 0, input);

                        throw nvae;
                    }

                    switch (alt111) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1570:4: DECIMAL_NUMBER
                            {
                            DECIMAL_NUMBER46=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_constant5203); if (state.failed) return constant;
                            if ( state.backtracking==0 ) {
                               constant =  Constant.parseDecimal(((s!=null?s.getText():null) == null ? "" : (s!=null?s.getText():null)) + (DECIMAL_NUMBER46!=null?DECIMAL_NUMBER46.getText():null)); 
                            }

                            }
                            break;
                        case 2 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1571:4: HEXADECIMAL_NUMBER
                            {
                            HEXADECIMAL_NUMBER47=(Token)match(input,HEXADECIMAL_NUMBER,FOLLOW_HEXADECIMAL_NUMBER_in_constant5212); if (state.failed) return constant;
                            if ( state.backtracking==0 ) {
                               constant = Constant.parseHex((HEXADECIMAL_NUMBER47!=null?HEXADECIMAL_NUMBER47.getText():null), "-".equals((s!=null?s.getText():null))); 
                            }

                            }
                            break;
                        case 3 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1572:4: OCTAL_NUMBER
                            {
                            OCTAL_NUMBER48=(Token)match(input,OCTAL_NUMBER,FOLLOW_OCTAL_NUMBER_in_constant5221); if (state.failed) return constant;
                            if ( state.backtracking==0 ) {
                               constant = Constant.parseOctal((OCTAL_NUMBER48!=null?OCTAL_NUMBER48.getText():null), "-".equals((s!=null?s.getText():null))); 
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1574:3: CHARACTER
                    {
                    CHARACTER49=(Token)match(input,CHARACTER,FOLLOW_CHARACTER_in_constant5233); if (state.failed) return constant;
                    if ( state.backtracking==0 ) {
                       constant =  Constant.parseCharOrStringInteger((CHARACTER49!=null?CHARACTER49.getText():null)); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1575:3: (s2= ( '-' | '+' ) )? FLOAT_NUMBER
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1575:5: (s2= ( '-' | '+' ) )?
                    int alt112=2;
                    int LA112_0 = input.LA(1);

                    if ( ((LA112_0>=43 && LA112_0<=44)) ) {
                        alt112=1;
                    }
                    switch (alt112) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: s2= ( '-' | '+' )
                            {
                            s2=(Token)input.LT(1);
                            if ( (input.LA(1)>=43 && input.LA(1)<=44) ) {
                                input.consume();
                                state.errorRecovery=false;state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return constant;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }

                    FLOAT_NUMBER50=(Token)match(input,FLOAT_NUMBER,FOLLOW_FLOAT_NUMBER_in_constant5252); if (state.failed) return constant;
                    if ( state.backtracking==0 ) {
                       constant = Constant.parseFloat(((s2!=null?s2.getText():null) == null ? "" : (s2!=null?s2.getText():null)) + (FLOAT_NUMBER50!=null?FLOAT_NUMBER50.getText():null)); 
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1577:3: STRING
                    {
                    STRING51=(Token)match(input,STRING,FOLLOW_STRING_in_constant5263); if (state.failed) return constant;
                    if ( state.backtracking==0 ) {
                       constant =  Constant.parseString((STRING51!=null?STRING51.getText():null)); 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 77, constant_StartIndex); }
        }
        return constant;
    }
    // $ANTLR end "constant"

    // $ANTLR start synpred6_ObjCpp
    public final void synpred6_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:389:5: ({...}? => pragmaContent )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:389:5: {...}? => pragmaContent
        {
        if ( !(( next("__pragma") )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred6_ObjCpp", " next(\"__pragma\") ");
        }
        pushFollow(FOLLOW_pragmaContent_in_synpred6_ObjCpp274);
        pragmaContent();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_ObjCpp

    // $ANTLR start synpred8_ObjCpp
    public final void synpred8_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:391:5: ( functionDeclaration )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:391:5: functionDeclaration
        {
        pushFollow(FOLLOW_functionDeclaration_in_synpred8_ObjCpp291);
        functionDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_ObjCpp

    // $ANTLR start synpred9_ObjCpp
    public final void synpred9_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:394:5: ( externDeclarations )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:394:5: externDeclarations
        {
        pushFollow(FOLLOW_externDeclarations_in_synpred9_ObjCpp301);
        externDeclarations();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_ObjCpp

    // $ANTLR start synpred10_ObjCpp
    public final void synpred10_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:397:5: ( varDecl ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:397:5: varDecl ';'
        {
        pushFollow(FOLLOW_varDecl_in_synpred10_ObjCpp311);
        varDecl();

        state._fsp--;
        if (state.failed) return ;
        match(input,25,FOLLOW_25_in_synpred10_ObjCpp313); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_ObjCpp

    // $ANTLR start synpred21_ObjCpp
    public final void synpred21_ObjCpp_fragment() throws RecognitionException {   
        List<Modifier> m2 = null;

        Enum nb = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:508:6: (m2= modifiers nb= enumBody )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:508:6: m2= modifiers nb= enumBody
        {
        pushFollow(FOLLOW_modifiers_in_synpred21_ObjCpp683);
        m2=modifiers();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_enumBody_in_synpred21_ObjCpp694);
        nb=enumBody();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_ObjCpp

    // $ANTLR start synpred24_ObjCpp
    public final void synpred24_ObjCpp_fragment() throws RecognitionException {   
        Token categoryName=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:550:4: ( ( '(' categoryName= IDENTIFIER ')' ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:550:4: ( '(' categoryName= IDENTIFIER ')' )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:550:4: ( '(' categoryName= IDENTIFIER ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:551:5: '(' categoryName= IDENTIFIER ')'
        {
        match(input,34,FOLLOW_34_in_synpred24_ObjCpp796); if (state.failed) return ;
        categoryName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred24_ObjCpp800); if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred24_ObjCpp802); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred24_ObjCpp

    // $ANTLR start synpred31_ObjCpp
    public final void synpred31_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:571:5: ( ( functionPointerOrSimpleVarDecl ';' ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:571:5: ( functionPointerOrSimpleVarDecl ';' )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:571:5: ( functionPointerOrSimpleVarDecl ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:572:6: functionPointerOrSimpleVarDecl ';'
        {
        pushFollow(FOLLOW_functionPointerOrSimpleVarDecl_in_synpred31_ObjCpp941);
        functionPointerOrSimpleVarDecl();

        state._fsp--;
        if (state.failed) return ;
        match(input,25,FOLLOW_25_in_synpred31_ObjCpp943); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred31_ObjCpp

    // $ANTLR start synpred36_ObjCpp
    public final void synpred36_ObjCpp_fragment() throws RecognitionException {   
        VariablesDeclaration vd = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:590:4: (vd= varDecl ';' {...}?)
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:590:4: vd= varDecl ';' {...}?
        {
        pushFollow(FOLLOW_varDecl_in_synpred36_ObjCpp1010);
        vd=varDecl();

        state._fsp--;
        if (state.failed) return ;
        match(input,25,FOLLOW_25_in_synpred36_ObjCpp1012); if (state.failed) return ;
        if ( !(( !(vd instanceof VariablesDeclaration) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred36_ObjCpp", " !($vd.decl instanceof VariablesDeclaration) ");
        }

        }
    }
    // $ANTLR end synpred36_ObjCpp

    // $ANTLR start synpred37_ObjCpp
    public final void synpred37_ObjCpp_fragment() throws RecognitionException {   
        VariablesDeclaration fv = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:599:3: (fv= varDecl )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:599:3: fv= varDecl
        {
        pushFollow(FOLLOW_varDecl_in_synpred37_ObjCpp1050);
        fv=varDecl();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_ObjCpp

    // $ANTLR start synpred39_ObjCpp
    public final void synpred39_ObjCpp_fragment() throws RecognitionException {   
        TypeRef returnTypeRef = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:633:18: (returnTypeRef= mutableTypeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:633:18: returnTypeRef= mutableTypeRef
        {
        pushFollow(FOLLOW_mutableTypeRef_in_synpred39_ObjCpp1156);
        returnTypeRef=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_ObjCpp

    // $ANTLR start synpred48_ObjCpp
    public final void synpred48_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.declaration_return friend = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:679:5: ({...}? IDENTIFIER friend= declaration ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:679:5: {...}? IDENTIFIER friend= declaration ';'
        {
        if ( !(( next("friend") )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred48_ObjCpp", " next(\"friend\") ");
        }
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred48_ObjCpp1366); if (state.failed) return ;
        pushFollow(FOLLOW_declaration_in_synpred48_ObjCpp1370);
        friend=declaration();

        state._fsp--;
        if (state.failed) return ;
        match(input,25,FOLLOW_25_in_synpred48_ObjCpp1372); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_ObjCpp

    // $ANTLR start synpred49_ObjCpp
    public final void synpred49_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.declaration_return decl = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:683:5: (decl= declaration )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:683:5: decl= declaration
        {
        pushFollow(FOLLOW_declaration_in_synpred49_ObjCpp1384);
        decl=declaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_ObjCpp

    // $ANTLR start synpred50_ObjCpp
    public final void synpred50_ObjCpp_fragment() throws RecognitionException {   
        VariablesDeclaration fv = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:686:5: (fv= varDecl ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:686:5: fv= varDecl ';'
        {
        pushFollow(FOLLOW_varDecl_in_synpred50_ObjCpp1396);
        fv=varDecl();

        state._fsp--;
        if (state.failed) return ;
        match(input,25,FOLLOW_25_in_synpred50_ObjCpp1398); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_ObjCpp

    // $ANTLR start synpred56_ObjCpp
    public final void synpred56_ObjCpp_fragment() throws RecognitionException {   
        List<Modifier> m2 = null;

        ObjCppParser.qualifiedIdentifier_return parent = null;

        Struct nb = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:732:6: ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:732:6: (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:732:6: (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:733:7: m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody
        {
        pushFollow(FOLLOW_modifiers_in_synpred56_ObjCpp1530);
        m2=modifiers();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:734:7: ( ':' ( 'public' )? parent= qualifiedIdentifier )?
        int alt126=2;
        int LA126_0 = input.LA(1);

        if ( (LA126_0==33) ) {
            alt126=1;
        }
        switch (alt126) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:735:8: ':' ( 'public' )? parent= qualifiedIdentifier
                {
                match(input,33,FOLLOW_33_in_synpred56_ObjCpp1549); if (state.failed) return ;
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:736:8: ( 'public' )?
                int alt125=2;
                int LA125_0 = input.LA(1);

                if ( (LA125_0==47) ) {
                    alt125=1;
                }
                switch (alt125) {
                    case 1 :
                        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: 'public'
                        {
                        match(input,47,FOLLOW_47_in_synpred56_ObjCpp1558); if (state.failed) return ;

                        }
                        break;

                }

                pushFollow(FOLLOW_qualifiedIdentifier_in_synpred56_ObjCpp1570);
                parent=qualifiedIdentifier();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }

        pushFollow(FOLLOW_structBody_in_synpred56_ObjCpp1590);
        nb=structBody();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred56_ObjCpp

    // $ANTLR start synpred57_ObjCpp
    public final void synpred57_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:757:4: ( binaryOp )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:757:4: binaryOp
        {
        pushFollow(FOLLOW_binaryOp_in_synpred57_ObjCpp1638);
        binaryOp();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred57_ObjCpp

    // $ANTLR start synpred58_ObjCpp
    public final void synpred58_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:758:3: ( unaryOp )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:758:3: unaryOp
        {
        pushFollow(FOLLOW_unaryOp_in_synpred58_ObjCpp1647);
        unaryOp();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_ObjCpp

    // $ANTLR start synpred59_ObjCpp
    public final void synpred59_ObjCpp_fragment() throws RecognitionException {   
        TypeRef returnTypeRef = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:773:16: (returnTypeRef= mutableTypeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:773:16: returnTypeRef= mutableTypeRef
        {
        pushFollow(FOLLOW_mutableTypeRef_in_synpred59_ObjCpp1699);
        returnTypeRef=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_ObjCpp

    // $ANTLR start synpred64_ObjCpp
    public final void synpred64_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:813:7: ( modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:813:7: modifier
        {
        pushFollow(FOLLOW_modifier_in_synpred64_ObjCpp1868);
        modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred64_ObjCpp

    // $ANTLR start synpred74_ObjCpp
    public final void synpred74_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:822:4: ( ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:822:4: ';'
        {
        match(input,25,FOLLOW_25_in_synpred74_ObjCpp1950); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred74_ObjCpp

    // $ANTLR start synpred75_ObjCpp
    public final void synpred75_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:830:3: ({...}? => pragmaContent )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:830:3: {...}? => pragmaContent
        {
        if ( !(( next("__pragma") )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred75_ObjCpp", " next(\"__pragma\") ");
        }
        pushFollow(FOLLOW_pragmaContent_in_synpred75_ObjCpp1982);
        pragmaContent();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred75_ObjCpp

    // $ANTLR start synpred76_ObjCpp
    public final void synpred76_ObjCpp_fragment() throws RecognitionException {   
        Token ex=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:831:3: ({...}? => IDENTIFIER ex= STRING )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:831:3: {...}? => IDENTIFIER ex= STRING
        {
        if ( !(( next("extern") )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred76_ObjCpp", " next(\"extern\") ");
        }
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred76_ObjCpp1992); if (state.failed) return ;
        ex=(Token)match(input,STRING,FOLLOW_STRING_in_synpred76_ObjCpp1996); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred76_ObjCpp

    // $ANTLR start synpred77_ObjCpp
    public final void synpred77_ObjCpp_fragment() throws RecognitionException {   
        Token m=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:834:3: ({...}?m= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:834:3: {...}?m= IDENTIFIER
        {
        if ( !(( Modifier.parseModifier(next()) != null )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred77_ObjCpp", " Modifier.parseModifier(next()) != null ");
        }
        m=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred77_ObjCpp2008); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred77_ObjCpp

    // $ANTLR start synpred78_ObjCpp
    public final void synpred78_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:837:3: ({...}? => IDENTIFIER '(' 'return' binaryOp expression ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:837:3: {...}? => IDENTIFIER '(' 'return' binaryOp expression ')'
        {
        if ( !(( next("__success") )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred78_ObjCpp", " next(\"__success\") ");
        }
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred78_ObjCpp2021); if (state.failed) return ;
        match(input,34,FOLLOW_34_in_synpred78_ObjCpp2023); if (state.failed) return ;
        match(input,52,FOLLOW_52_in_synpred78_ObjCpp2025); if (state.failed) return ;
        pushFollow(FOLLOW_binaryOp_in_synpred78_ObjCpp2027);
        binaryOp();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred78_ObjCpp2029);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred78_ObjCpp2032); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred78_ObjCpp

    // $ANTLR start synpred79_ObjCpp
    public final void synpred79_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:841:3: ({...}? => IDENTIFIER '(' expression ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:841:3: {...}? => IDENTIFIER '(' expression ')'
        {
        if ( !(( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred79_ObjCpp", " next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ");
        }
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred79_ObjCpp2049); if (state.failed) return ;
        match(input,34,FOLLOW_34_in_synpred79_ObjCpp2051); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred79_ObjCpp2053);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred79_ObjCpp2055); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred79_ObjCpp

    // $ANTLR start synpred81_ObjCpp
    public final void synpred81_ObjCpp_fragment() throws RecognitionException {   
        Token an=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:847:4: ( (an= STRING )* )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:847:4: (an= STRING )*
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:847:4: (an= STRING )*
        loop129:
        do {
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==STRING) ) {
                alt129=1;
            }


            switch (alt129) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:847:6: an= STRING
        	    {
        	    an=(Token)match(input,STRING,FOLLOW_STRING_in_synpred81_ObjCpp2084); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop129;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred81_ObjCpp

    // $ANTLR start synpred83_ObjCpp
    public final void synpred83_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:889:4: ( declarator )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:889:4: declarator
        {
        pushFollow(FOLLOW_declarator_in_synpred83_ObjCpp2191);
        declarator();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred83_ObjCpp

    // $ANTLR start synpred85_ObjCpp
    public final void synpred85_ObjCpp_fragment() throws RecognitionException {   
        TypeRef tr = null;

        ObjCppParser.topLevelExpr_return dv = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:877:4: ( (tr= mutableTypeRef ) ( ( declarator )? ) ( '=' dv= topLevelExpr )? )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:877:4: (tr= mutableTypeRef ) ( ( declarator )? ) ( '=' dv= topLevelExpr )?
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:877:4: (tr= mutableTypeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:878:4: tr= mutableTypeRef
        {
        pushFollow(FOLLOW_mutableTypeRef_in_synpred85_ObjCpp2176);
        tr=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;

        }

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:888:3: ( ( declarator )? )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:889:4: ( declarator )?
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:889:4: ( declarator )?
        int alt130=2;
        int LA130_0 = input.LA(1);

        if ( (LA130_0==IDENTIFIER||LA130_0==34||(LA130_0>=53 && LA130_0<=54)||LA130_0==58) ) {
            alt130=1;
        }
        switch (alt130) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: declarator
                {
                pushFollow(FOLLOW_declarator_in_synpred85_ObjCpp2191);
                declarator();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:903:3: ( '=' dv= topLevelExpr )?
        int alt131=2;
        int LA131_0 = input.LA(1);

        if ( (LA131_0==29) ) {
            alt131=1;
        }
        switch (alt131) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:903:4: '=' dv= topLevelExpr
                {
                match(input,29,FOLLOW_29_in_synpred85_ObjCpp2203); if (state.failed) return ;
                pushFollow(FOLLOW_topLevelExpr_in_synpred85_ObjCpp2207);
                dv=topLevelExpr();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred85_ObjCpp

    // $ANTLR start synpred89_ObjCpp
    public final void synpred89_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:936:20: ( templateArgDecl ( ',' templateArgDecl )* )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:936:20: templateArgDecl ( ',' templateArgDecl )*
        {
        pushFollow(FOLLOW_templateArgDecl_in_synpred89_ObjCpp2325);
        templateArgDecl();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:936:36: ( ',' templateArgDecl )*
        loop132:
        do {
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( (LA132_0==28) ) {
                alt132=1;
            }


            switch (alt132) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:936:37: ',' templateArgDecl
        	    {
        	    match(input,28,FOLLOW_28_in_synpred89_ObjCpp2328); if (state.failed) return ;
        	    pushFollow(FOLLOW_templateArgDecl_in_synpred89_ObjCpp2330);
        	    templateArgDecl();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop132;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred89_ObjCpp

    // $ANTLR start synpred92_ObjCpp
    public final void synpred92_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:956:4: (a1= argDef ( ',' ax= argDef )* )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:956:4: a1= argDef ( ',' ax= argDef )*
        {
        pushFollow(FOLLOW_argDef_in_synpred92_ObjCpp2406);
        a1=argDef();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:960:4: ( ',' ax= argDef )*
        loop133:
        do {
            int alt133=2;
            int LA133_0 = input.LA(1);

            if ( (LA133_0==28) ) {
                alt133=1;
            }


            switch (alt133) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:961:5: ',' ax= argDef
        	    {
        	    match(input,28,FOLLOW_28_in_synpred92_ObjCpp2419); if (state.failed) return ;
        	    pushFollow(FOLLOW_argDef_in_synpred92_ObjCpp2428);
        	    ax=argDef();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop133;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred92_ObjCpp

    // $ANTLR start synpred94_ObjCpp
    public final void synpred94_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:976:4: (a1= argDef ( ',' ax= argDef )* )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:976:4: a1= argDef ( ',' ax= argDef )*
        {
        pushFollow(FOLLOW_argDef_in_synpred94_ObjCpp2481);
        a1=argDef();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:980:4: ( ',' ax= argDef )*
        loop134:
        do {
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==28) ) {
                alt134=1;
            }


            switch (alt134) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:981:5: ',' ax= argDef
        	    {
        	    match(input,28,FOLLOW_28_in_synpred94_ObjCpp2494); if (state.failed) return ;
        	    pushFollow(FOLLOW_argDef_in_synpred94_ObjCpp2503);
        	    ax=argDef();

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
    // $ANTLR end synpred94_ObjCpp

    // $ANTLR start synpred95_ObjCpp
    public final void synpred95_ObjCpp_fragment() throws RecognitionException {   
        TypeMutator m1 = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:995:4: ( (m1= typeMutator ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:995:4: (m1= typeMutator )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:995:4: (m1= typeMutator )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:996:5: m1= typeMutator
        {
        pushFollow(FOLLOW_typeMutator_in_synpred95_ObjCpp2559);
        m1=typeMutator();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred95_ObjCpp

    // $ANTLR start synpred96_ObjCpp
    public final void synpred96_ObjCpp_fragment() throws RecognitionException {   
        FunctionSignature f1 = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1000:4: ( (f1= functionSignatureSuffix ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1000:4: (f1= functionSignatureSuffix )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1000:4: (f1= functionSignatureSuffix )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1001:5: f1= functionSignatureSuffix
        {
        pushFollow(FOLLOW_functionSignatureSuffix_in_synpred96_ObjCpp2581);
        f1=functionSignatureSuffix();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred96_ObjCpp

    // $ANTLR start synpred98_ObjCpp
    public final void synpred98_ObjCpp_fragment() throws RecognitionException {   
        FunctionSignature fs = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1018:4: ( ( typeMutator )* (fs= functionSignatureSuffix ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1018:4: ( typeMutator )* (fs= functionSignatureSuffix )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1018:4: ( typeMutator )*
        loop135:
        do {
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( ((LA135_0>=53 && LA135_0<=55)) ) {
                alt135=1;
            }


            switch (alt135) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1019:5: typeMutator
        	    {
        	    pushFollow(FOLLOW_typeMutator_in_synpred98_ObjCpp2627);
        	    typeMutator();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop135;
            }
        } while (true);

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1023:4: (fs= functionSignatureSuffix )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1024:5: fs= functionSignatureSuffix
        {
        pushFollow(FOLLOW_functionSignatureSuffix_in_synpred98_ObjCpp2648);
        fs=functionSignatureSuffix();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred98_ObjCpp

    // $ANTLR start synpred102_ObjCpp
    public final void synpred102_ObjCpp_fragment() throws RecognitionException {   
        Token bits=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1052:4: ( ':' bits= DECIMAL_NUMBER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1052:4: ':' bits= DECIMAL_NUMBER
        {
        match(input,33,FOLLOW_33_in_synpred102_ObjCpp2757); if (state.failed) return ;
        bits=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_synpred102_ObjCpp2761); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred102_ObjCpp

    // $ANTLR start synpred103_ObjCpp
    public final void synpred103_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.topLevelExpr_return dv = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1058:4: ( '=' dv= topLevelExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1058:4: '=' dv= topLevelExpr
        {
        match(input,29,FOLLOW_29_in_synpred103_ObjCpp2777); if (state.failed) return ;
        pushFollow(FOLLOW_topLevelExpr_in_synpred103_ObjCpp2785);
        dv=topLevelExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred103_ObjCpp

    // $ANTLR start synpred107_ObjCpp
    public final void synpred107_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1125:4: ({...}? => IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1125:4: {...}? => IDENTIFIER
        {
        if ( !(( Modifier.parseModifier(next()) == null )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred107_ObjCpp", " Modifier.parseModifier(next()) == null ");
        }
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred107_ObjCpp3030); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred107_ObjCpp

    // $ANTLR start synpred111_ObjCpp
    public final void synpred111_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.argDef_return ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1169:5: ( ',' ax= argDef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1169:5: ',' ax= argDef
        {
        match(input,28,FOLLOW_28_in_synpred111_ObjCpp3148); if (state.failed) return ;
        pushFollow(FOLLOW_argDef_in_synpred111_ObjCpp3157);
        ax=argDef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred111_ObjCpp

    // $ANTLR start synpred113_ObjCpp
    public final void synpred113_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1164:4: (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1164:4: a1= argDef ( ',' ax= argDef )* ( ',' '...' )?
        {
        pushFollow(FOLLOW_argDef_in_synpred113_ObjCpp3135);
        a1=argDef();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1168:4: ( ',' ax= argDef )*
        loop137:
        do {
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==28) ) {
                int LA137_1 = input.LA(2);

                if ( (LA137_1==46) ) {
                    int LA137_3 = input.LA(3);

                    if ( (synpred111_ObjCpp()) ) {
                        alt137=1;
                    }


                }
                else if ( (LA137_1==EOF||LA137_1==IDENTIFIER||(LA137_1>=28 && LA137_1<=30)||LA137_1==34||LA137_1==45||(LA137_1>=50 && LA137_1<=51)||(LA137_1>=53 && LA137_1<=55)||LA137_1==58||LA137_1==60) ) {
                    alt137=1;
                }


            }


            switch (alt137) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1169:5: ',' ax= argDef
        	    {
        	    match(input,28,FOLLOW_28_in_synpred113_ObjCpp3148); if (state.failed) return ;
        	    pushFollow(FOLLOW_argDef_in_synpred113_ObjCpp3157);
        	    ax=argDef();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop137;
            }
        } while (true);

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1174:4: ( ',' '...' )?
        int alt138=2;
        int LA138_0 = input.LA(1);

        if ( (LA138_0==28) ) {
            alt138=1;
        }
        switch (alt138) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1175:5: ',' '...'
                {
                match(input,28,FOLLOW_28_in_synpred113_ObjCpp3177); if (state.failed) return ;
                match(input,46,FOLLOW_46_in_synpred113_ObjCpp3179); if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred113_ObjCpp

    // $ANTLR start synpred115_ObjCpp
    public final void synpred115_ObjCpp_fragment() throws RecognitionException {   
        TypeRef an = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1203:4: ({...}? =>an= typeName )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1203:4: {...}? =>an= typeName
        {
        if ( !(( 
        				isTypeIdentifier(next()) || 
        				(
        					Modifier.parseModifier(next(1)) == null && 
        					!next(2, "=", ",", ";", ":", "[", "(", ")")
        				) 
        			)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred115_ObjCpp", " \n\t\t\t\tisTypeIdentifier(next()) || \n\t\t\t\t(\n\t\t\t\t\tModifier.parseModifier(next(1)) == null && \n\t\t\t\t\t!next(2, \"=\", \",\", \";\", \":\", \"[\", \"(\", \")\")\n\t\t\t\t) \n\t\t\t");
        }
        pushFollow(FOLLOW_typeName_in_synpred115_ObjCpp3257);
        an=typeName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred115_ObjCpp

    // $ANTLR start synpred138_ObjCpp
    public final void synpred138_ObjCpp_fragment() throws RecognitionException {   
        TypeRef tr = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1261:4: (tr= mutableTypeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1261:4: tr= mutableTypeRef
        {
        pushFollow(FOLLOW_mutableTypeRef_in_synpred138_ObjCpp3516);
        tr=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred138_ObjCpp

    // $ANTLR start synpred140_ObjCpp
    public final void synpred140_ObjCpp_fragment() throws RecognitionException {   
        Expression a1 = null;

        Expression ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1273:5: (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1273:5: a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )*
        {
        pushFollow(FOLLOW_typeRefOrExpression_in_synpred140_ObjCpp3567);
        a1=typeRefOrExpression();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1274:5: ( ',' ax= typeRefOrExpression )*
        loop140:
        do {
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==28) ) {
                alt140=1;
            }


            switch (alt140) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1275:6: ',' ax= typeRefOrExpression
        	    {
        	    match(input,28,FOLLOW_28_in_synpred140_ObjCpp3582); if (state.failed) return ;
        	    pushFollow(FOLLOW_typeRefOrExpression_in_synpred140_ObjCpp3592);
        	    ax=typeRefOrExpression();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop140;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred140_ObjCpp

    // $ANTLR start synpred141_ObjCpp
    public final void synpred141_ObjCpp_fragment() throws RecognitionException {   
        Expression a1 = null;

        Expression ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1272:4: ( '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1272:4: '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>'
        {
        match(input,36,FOLLOW_36_in_synpred141_ObjCpp3557); if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1272:8: (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )?
        int alt142=2;
        int LA142_0 = input.LA(1);

        if ( ((LA142_0>=DECIMAL_NUMBER && LA142_0<=FLOAT_NUMBER)||LA142_0==28||(LA142_0>=30 && LA142_0<=31)||LA142_0==34||(LA142_0>=43 && LA142_0<=45)||(LA142_0>=50 && LA142_0<=51)||(LA142_0>=53 && LA142_0<=55)||LA142_0==60||(LA142_0>=74 && LA142_0<=76)||(LA142_0>=89 && LA142_0<=91)) ) {
            alt142=1;
        }
        else if ( (LA142_0==37) ) {
            int LA142_2 = input.LA(2);

            if ( (synpred140_ObjCpp()) ) {
                alt142=1;
            }
        }
        switch (alt142) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1273:5: a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )*
                {
                pushFollow(FOLLOW_typeRefOrExpression_in_synpred141_ObjCpp3567);
                a1=typeRefOrExpression();

                state._fsp--;
                if (state.failed) return ;
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1274:5: ( ',' ax= typeRefOrExpression )*
                loop141:
                do {
                    int alt141=2;
                    int LA141_0 = input.LA(1);

                    if ( (LA141_0==28) ) {
                        alt141=1;
                    }


                    switch (alt141) {
                	case 1 :
                	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1275:6: ',' ax= typeRefOrExpression
                	    {
                	    match(input,28,FOLLOW_28_in_synpred141_ObjCpp3582); if (state.failed) return ;
                	    pushFollow(FOLLOW_typeRefOrExpression_in_synpred141_ObjCpp3592);
                	    ax=typeRefOrExpression();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }
                	    break;

                	default :
                	    break loop141;
                    }
                } while (true);


                }
                break;

        }

        match(input,37,FOLLOW_37_in_synpred141_ObjCpp3611); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred141_ObjCpp

    // $ANTLR start synpred152_ObjCpp
    public final void synpred152_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.assignmentOp_return op = null;

        Expression f = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1349:4: (op= assignmentOp f= assignmentExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1349:4: op= assignmentOp f= assignmentExpr
        {
        pushFollow(FOLLOW_assignmentOp_in_synpred152_ObjCpp3924);
        op=assignmentOp();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_assignmentExpr_in_synpred152_ObjCpp3928);
        f=assignmentExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred152_ObjCpp

    // $ANTLR start synpred182_ObjCpp
    public final void synpred182_ObjCpp_fragment() throws RecognitionException {   
        Token op=null;
        Expression f = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1445:4: (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1445:4: op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr
        {
        op=(Token)input.LT(1);
        if ( (input.LA(1)>=36 && input.LA(1)<=37)||(input.LA(1)>=69 && input.LA(1)<=70) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }

        pushFollow(FOLLOW_shiftExpr_in_synpred182_ObjCpp4532);
        f=shiftExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred182_ObjCpp

    // $ANTLR start synpred183_ObjCpp
    public final void synpred183_ObjCpp_fragment() throws RecognitionException {   
        TypeRef tr = null;

        Expression inner = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1451:4: ( '(' tr= mutableTypeRef ')' inner= castExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1451:4: '(' tr= mutableTypeRef ')' inner= castExpr
        {
        match(input,34,FOLLOW_34_in_synpred183_ObjCpp4554); if (state.failed) return ;
        pushFollow(FOLLOW_mutableTypeRef_in_synpred183_ObjCpp4558);
        tr=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred183_ObjCpp4560); if (state.failed) return ;
        pushFollow(FOLLOW_castExpr_in_synpred183_ObjCpp4564);
        inner=castExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred183_ObjCpp

    // $ANTLR start synpred184_ObjCpp
    public final void synpred184_ObjCpp_fragment() throws RecognitionException {   
        TypeRef tr = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1457:3: ({...}? IDENTIFIER ( '(' tr= mutableTypeRef ')' ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1457:3: {...}? IDENTIFIER ( '(' tr= mutableTypeRef ')' )
        {
        if ( !(( next("sizeof") )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred184_ObjCpp", " next(\"sizeof\") ");
        }
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred184_ObjCpp4597); if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1457:34: ( '(' tr= mutableTypeRef ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1458:4: '(' tr= mutableTypeRef ')'
        {
        match(input,34,FOLLOW_34_in_synpred184_ObjCpp4604); if (state.failed) return ;
        pushFollow(FOLLOW_mutableTypeRef_in_synpred184_ObjCpp4608);
        tr=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred184_ObjCpp4610); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred184_ObjCpp

    // $ANTLR start synpred185_ObjCpp
    public final void synpred185_ObjCpp_fragment() throws RecognitionException {   
        Expression p = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1463:3: (p= postfixExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1463:3: p= postfixExpr
        {
        pushFollow(FOLLOW_postfixExpr_in_synpred185_ObjCpp4628);
        p=postfixExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred185_ObjCpp

    // $ANTLR start synpred203_ObjCpp
    public final void synpred203_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1547:3: ( declaration )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1547:3: declaration
        {
        pushFollow(FOLLOW_declaration_in_synpred203_ObjCpp4967);
        declaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred203_ObjCpp

    // $ANTLR start synpred204_ObjCpp
    public final void synpred204_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.expression_return es = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1548:3: (es= expression ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1548:3: es= expression ';'
        {
        pushFollow(FOLLOW_expression_in_synpred204_ObjCpp4976);
        es=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,25,FOLLOW_25_in_synpred204_ObjCpp4978); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred204_ObjCpp

    // $ANTLR start synpred206_ObjCpp
    public final void synpred206_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1552:3: ( IDENTIFIER ':' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1552:3: IDENTIFIER ':'
        {
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred206_ObjCpp5002); if (state.failed) return ;
        match(input,33,FOLLOW_33_in_synpred206_ObjCpp5004); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred206_ObjCpp

    // $ANTLR start synpred208_ObjCpp
    public final void synpred208_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1554:40: ( 'else' statement )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1554:40: 'else' statement
        {
        match(input,96,FOLLOW_96_in_synpred208_ObjCpp5030); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred208_ObjCpp5032);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred208_ObjCpp

    // $ANTLR start synpred219_ObjCpp
    public final void synpred219_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1564:3: ( ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1564:3: ';'
        {
        match(input,25,FOLLOW_25_in_synpred219_ObjCpp5150); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred219_ObjCpp

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
    public final boolean synpred183_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred183_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred113_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred83_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred83_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred75_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred75_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred203_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred203_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred49_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred184_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred184_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred141_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred141_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred219_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred219_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred76_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred76_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred138_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred138_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred74_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred74_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred36_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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
    public final boolean synpred9_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred208_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred208_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred140_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred140_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred206_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred206_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred115_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred115_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred21_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred111_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred111_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred10_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred204_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred204_ObjCpp_fragment(); // can never throw exception
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
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA59 dfa59 = new DFA59(this);
    protected DFA77 dfa77 = new DFA77(this);
    protected DFA80 dfa80 = new DFA80(this);
    protected DFA86 dfa86 = new DFA86(this);
    protected DFA97 dfa97 = new DFA97(this);
    protected DFA98 dfa98 = new DFA98(this);
    protected DFA99 dfa99 = new DFA99(this);
    protected DFA109 dfa109 = new DFA109(this);
    static final String DFA6_eotS =
        "\22\uffff";
    static final String DFA6_eofS =
        "\22\uffff";
    static final String DFA6_minS =
        "\1\6\1\0\1\uffff\6\0\11\uffff";
    static final String DFA6_maxS =
        "\1\112\1\0\1\uffff\6\0\11\uffff";
    static final String DFA6_acceptS =
        "\2\uffff\1\2\6\uffff\1\3\1\5\1\uffff\1\6\1\7\1\10\1\11\1\1\1\4";
    static final String DFA6_specialS =
        "\1\uffff\1\0\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\11\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1\22\uffff\1\12\1\17\1\16\2\uffff\1\5\2\14\1\uffff\1\10\12"+
            "\uffff\1\4\4\uffff\2\4\1\uffff\2\6\1\7\1\uffff\1\2\1\12\1\15"+
            "\1\3\15\uffff\1\11",
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
            return "388:4: ({...}? => pragmaContent | templateDef | functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )";
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
                        if ( ((synpred6_ObjCpp()&&( next("__pragma") ))) ) {s = 16;}

                        else if ( (synpred8_ObjCpp()) ) {s = 9;}

                        else if ( ((synpred9_ObjCpp()&&( next("extern") ))) ) {s = 17;}

                        else if ( (((synpred10_ObjCpp()&&( next("__pragma") ))||(synpred10_ObjCpp()&&( next("extern") ))||(synpred10_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||synpred10_ObjCpp()||(synpred10_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred10_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||(synpred10_ObjCpp()&&( next("__success") )))) ) {s = 10;}

                         
                        input.seek(index6_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_3 = input.LA(1);

                         
                        int index6_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_ObjCpp()) ) {s = 9;}

                        else if ( (synpred10_ObjCpp()) ) {s = 10;}

                         
                        input.seek(index6_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA6_4 = input.LA(1);

                         
                        int index6_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_ObjCpp()) ) {s = 9;}

                        else if ( (synpred10_ObjCpp()) ) {s = 10;}

                         
                        input.seek(index6_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA6_5 = input.LA(1);

                         
                        int index6_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_ObjCpp()) ) {s = 9;}

                        else if ( (synpred10_ObjCpp()) ) {s = 10;}

                         
                        input.seek(index6_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA6_6 = input.LA(1);

                         
                        int index6_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_ObjCpp()) ) {s = 9;}

                        else if ( (synpred10_ObjCpp()) ) {s = 10;}

                         
                        input.seek(index6_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA6_7 = input.LA(1);

                         
                        int index6_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_ObjCpp()) ) {s = 9;}

                        else if ( (synpred10_ObjCpp()) ) {s = 10;}

                         
                        input.seek(index6_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA6_8 = input.LA(1);

                         
                        int index6_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_ObjCpp()) ) {s = 9;}

                        else if ( (synpred10_ObjCpp()) ) {s = 10;}

                         
                        input.seek(index6_8);
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
        "\1\112\1\0\15\uffff";
    static final String DFA12_acceptS =
        "\2\uffff\1\1\1\2\13\uffff";
    static final String DFA12_specialS =
        "\1\uffff\1\0\15\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\1\20\uffff\1\2\1\uffff\1\3\2\uffff\2\3\3\uffff\3\3\1\uffff"+
            "\1\3\17\uffff\3\3\2\uffff\1\3\17\uffff\1\3",
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
            return "507:5: (m2= modifiers nb= enumBody | )";
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
                        if ( (((synpred21_ObjCpp()&&( next("__success") ))||(synpred21_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||(synpred21_ObjCpp()&&( next("__pragma") ))||(synpred21_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred21_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred21_ObjCpp()&&( next("extern") )))) ) {s = 2;}

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
    static final String DFA21_eotS =
        "\13\uffff";
    static final String DFA21_eofS =
        "\13\uffff";
    static final String DFA21_minS =
        "\1\6\7\0\1\uffff\1\0\1\uffff";
    static final String DFA21_maxS =
        "\1\74\7\0\1\uffff\1\0\1\uffff";
    static final String DFA21_acceptS =
        "\10\uffff\1\1\1\uffff\1\2";
    static final String DFA21_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\7\1\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\1\22\uffff\1\11\4\uffff\1\4\3\uffff\1\7\12\uffff\1\3\4\uffff"+
            "\2\3\1\uffff\2\5\1\6\2\uffff\1\10\1\uffff\1\2",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
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
            return "597:1: functionPointerOrSimpleVarDecl returns [Declaration decl] : (fv= varDecl | functionPointerVarDecl );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_1 = input.LA(1);

                         
                        int index21_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred37_ObjCpp()&&( next("__pragma") ))||(synpred37_ObjCpp()&&( next("__success") ))||(synpred37_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred37_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||synpred37_ObjCpp()||(synpred37_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||(synpred37_ObjCpp()&&( next("extern") )))) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index21_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA21_2 = input.LA(1);

                         
                        int index21_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index21_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA21_3 = input.LA(1);

                         
                        int index21_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index21_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA21_4 = input.LA(1);

                         
                        int index21_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index21_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA21_5 = input.LA(1);

                         
                        int index21_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index21_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA21_6 = input.LA(1);

                         
                        int index21_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index21_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA21_7 = input.LA(1);

                         
                        int index21_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index21_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA21_9 = input.LA(1);

                         
                        int index21_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index21_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 21, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA29_eotS =
        "\26\uffff";
    static final String DFA29_eofS =
        "\26\uffff";
    static final String DFA29_minS =
        "\1\6\4\uffff\1\0\1\uffff\6\0\1\uffff\2\0\6\uffff";
    static final String DFA29_maxS =
        "\1\112\4\uffff\1\0\1\uffff\6\0\1\uffff\2\0\6\uffff";
    static final String DFA29_acceptS =
        "\1\uffff\1\5\1\1\3\uffff\1\3\15\uffff\1\2\1\4";
    static final String DFA29_specialS =
        "\5\uffff\1\0\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\7\1\10\6"+
        "\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\5\21\uffff\1\1\1\17\2\6\2\uffff\1\11\2\6\1\uffff\1\14\12"+
            "\uffff\1\10\1\uffff\3\2\2\10\1\uffff\2\12\1\13\1\uffff\1\6\1"+
            "\16\1\6\1\7\15\uffff\1\6",
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

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "()* loopback of 673:4: ( ( 'public' | 'private' | 'protected' ) ':' | {...}? IDENTIFIER friend= declaration ';' | decl= declaration | fv= varDecl ';' )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA29_5 = input.LA(1);

                         
                        int index29_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred48_ObjCpp()&&( next("friend") ))) ) {s = 20;}

                        else if ( (synpred49_ObjCpp()) ) {s = 6;}

                        else if ( (((synpred50_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred50_ObjCpp()&&( next("__pragma") ))||(synpred50_ObjCpp()&&( next("__success") ))||(synpred50_ObjCpp()&&( next("extern") ))||(synpred50_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||synpred50_ObjCpp()||(synpred50_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) )))) ) {s = 21;}

                         
                        input.seek(index29_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA29_7 = input.LA(1);

                         
                        int index29_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_ObjCpp()) ) {s = 6;}

                        else if ( (synpred50_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index29_7);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA29_8 = input.LA(1);

                         
                        int index29_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_ObjCpp()) ) {s = 6;}

                        else if ( (synpred50_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index29_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA29_9 = input.LA(1);

                         
                        int index29_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_ObjCpp()) ) {s = 6;}

                        else if ( (synpred50_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index29_9);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA29_10 = input.LA(1);

                         
                        int index29_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_ObjCpp()) ) {s = 6;}

                        else if ( (synpred50_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index29_10);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA29_11 = input.LA(1);

                         
                        int index29_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_ObjCpp()) ) {s = 6;}

                        else if ( (synpred50_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index29_11);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA29_12 = input.LA(1);

                         
                        int index29_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_ObjCpp()) ) {s = 6;}

                        else if ( (synpred50_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index29_12);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA29_14 = input.LA(1);

                         
                        int index29_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_ObjCpp()) ) {s = 6;}

                        else if ( (synpred50_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index29_14);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA29_15 = input.LA(1);

                         
                        int index29_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_ObjCpp()) ) {s = 6;}

                        else if ( (synpred50_ObjCpp()) ) {s = 21;}

                         
                        input.seek(index29_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 29, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA32_eotS =
        "\17\uffff";
    static final String DFA32_eofS =
        "\1\4\16\uffff";
    static final String DFA32_minS =
        "\1\6\2\0\14\uffff";
    static final String DFA32_maxS =
        "\1\112\2\0\14\uffff";
    static final String DFA32_acceptS =
        "\3\uffff\1\1\1\2\12\uffff";
    static final String DFA32_specialS =
        "\1\uffff\1\0\1\1\14\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\1\20\uffff\1\3\1\uffff\1\4\2\uffff\2\4\3\uffff\1\2\2\4\1"+
            "\uffff\1\4\17\uffff\3\4\2\uffff\1\4\17\uffff\1\4",
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
            return "731:5: ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_1 = input.LA(1);

                         
                        int index32_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred56_ObjCpp()&&( next("__pragma") ))||(synpred56_ObjCpp()&&( next("extern") ))||(synpred56_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred56_ObjCpp()&&( next("__success") ))||(synpred56_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||(synpred56_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) )))) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index32_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA32_2 = input.LA(1);

                         
                        int index32_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index32_2);
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
    static final String DFA59_eotS =
        "\16\uffff";
    static final String DFA59_eofS =
        "\1\1\15\uffff";
    static final String DFA59_minS =
        "\1\6\4\uffff\2\0\7\uffff";
    static final String DFA59_maxS =
        "\1\112\4\uffff\2\0\7\uffff";
    static final String DFA59_acceptS =
        "\1\uffff\1\3\12\uffff\1\1\1\2";
    static final String DFA59_specialS =
        "\5\uffff\1\0\1\1\7\uffff}>";
    static final String[] DFA59_transitionS = {
            "\1\1\22\uffff\1\1\2\uffff\2\1\4\uffff\1\5\1\1\1\uffff\1\1\17"+
            "\uffff\2\6\1\14\2\uffff\1\1\17\uffff\1\1",
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
            return "()* loopback of 994:3: ( (m1= typeMutator ) | (f1= functionSignatureSuffix ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA59_5 = input.LA(1);

                         
                        int index59_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred96_ObjCpp()) ) {s = 13;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA59_6 = input.LA(1);

                         
                        int index59_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred95_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index59_6);
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
    static final String DFA77_eotS =
        "\27\uffff";
    static final String DFA77_eofS =
        "\1\2\26\uffff";
    static final String DFA77_minS =
        "\1\4\1\0\3\uffff\3\0\17\uffff";
    static final String DFA77_maxS =
        "\1\133\1\0\3\uffff\3\0\17\uffff";
    static final String DFA77_acceptS =
        "\2\uffff\1\1\10\uffff\1\2\13\uffff";
    static final String DFA77_specialS =
        "\1\uffff\1\0\3\uffff\1\1\1\2\1\3\17\uffff}>";
    static final String[] DFA77_transitionS = {
            "\2\13\1\1\4\13\21\uffff\1\2\1\uffff\1\2\1\13\2\uffff\1\7\2\uffff"+
            "\1\2\5\uffff\2\13\1\2\4\uffff\2\2\1\uffff\2\5\1\6\4\uffff\1"+
            "\2\15\uffff\3\13\14\uffff\3\13",
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
            return "1260:1: typeRefOrExpression returns [Expression expr] : (tr= mutableTypeRef | e= topLevelExpr );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA77_1 = input.LA(1);

                         
                        int index77_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred138_ObjCpp()||(synpred138_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||(synpred138_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred138_ObjCpp()&&( next("extern") ))||(synpred138_ObjCpp()&&( next("__pragma") ))||(synpred138_ObjCpp()&&( next("__success") ))||(synpred138_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) )))) ) {s = 2;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index77_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA77_5 = input.LA(1);

                         
                        int index77_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index77_5);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA77_6 = input.LA(1);

                         
                        int index77_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index77_6);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA77_7 = input.LA(1);

                         
                        int index77_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index77_7);
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
        "\43\uffff";
    static final String DFA80_eofS =
        "\1\2\42\uffff";
    static final String DFA80_minS =
        "\1\6\1\0\41\uffff";
    static final String DFA80_maxS =
        "\1\135\1\0\41\uffff";
    static final String DFA80_acceptS =
        "\2\uffff\1\2\37\uffff\1\1";
    static final String DFA80_specialS =
        "\1\uffff\1\0\41\uffff}>";
    static final String[] DFA80_transitionS = {
            "\1\2\20\uffff\3\2\2\uffff\2\2\3\uffff\3\2\1\1\1\2\5\uffff\2"+
            "\2\10\uffff\4\2\1\uffff\1\2\2\uffff\3\2\1\uffff\12\2\2\uffff"+
            "\16\2\1\uffff\2\2",
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
            return "1271:3: ( '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA80_1 = input.LA(1);

                         
                        int index80_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred141_ObjCpp()) ) {s = 34;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index80_1);
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
    static final String DFA86_eotS =
        "\14\uffff";
    static final String DFA86_eofS =
        "\1\2\13\uffff";
    static final String DFA86_minS =
        "\1\6\1\0\12\uffff";
    static final String DFA86_maxS =
        "\1\127\1\0\12\uffff";
    static final String DFA86_acceptS =
        "\2\uffff\1\2\4\uffff\1\1\4\uffff";
    static final String DFA86_specialS =
        "\1\uffff\1\0\12\uffff}>";
    static final String[] DFA86_transitionS = {
            "\1\2\21\uffff\2\2\2\uffff\1\2\1\1\3\uffff\1\2\1\uffff\1\2\1"+
            "\uffff\1\2\22\uffff\1\2\24\uffff\13\7",
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
            return "1348:3: (op= assignmentOp f= assignmentExpr )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA86_1 = input.LA(1);

                         
                        int index86_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_ObjCpp()) ) {s = 7;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index86_1);
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
    static final String DFA97_eotS =
        "\24\uffff";
    static final String DFA97_eofS =
        "\1\1\23\uffff";
    static final String DFA97_minS =
        "\1\6\13\uffff\1\0\7\uffff";
    static final String DFA97_maxS =
        "\1\130\13\uffff\1\0\7\uffff";
    static final String DFA97_acceptS =
        "\1\uffff\1\2\21\uffff\1\1";
    static final String DFA97_specialS =
        "\14\uffff\1\0\7\uffff}>";
    static final String[] DFA97_transitionS = {
            "\1\1\21\uffff\2\1\2\uffff\2\1\3\uffff\1\1\1\uffff\1\1\1\23\1"+
            "\14\20\uffff\1\1\1\uffff\1\1\1\uffff\1\1\7\uffff\3\1\2\23\2"+
            "\1\4\uffff\14\1",
            "",
            "",
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
            return "()* loopback of 1444:3: (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA97_12 = input.LA(1);

                         
                        int index97_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred182_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index97_12);
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
        "\21\uffff";
    static final String DFA98_eofS =
        "\21\uffff";
    static final String DFA98_minS =
        "\1\4\1\0\17\uffff";
    static final String DFA98_maxS =
        "\1\133\1\0\17\uffff";
    static final String DFA98_acceptS =
        "\2\uffff\1\2\15\uffff\1\1";
    static final String DFA98_specialS =
        "\1\uffff\1\0\17\uffff}>";
    static final String[] DFA98_transitionS = {
            "\7\2\24\uffff\1\2\2\uffff\1\1\10\uffff\2\2\10\uffff\3\2\22\uffff"+
            "\3\2\14\uffff\3\2",
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
            return "1450:1: castExpr returns [Expression expr] : ( '(' tr= mutableTypeRef ')' inner= castExpr | e= unaryExpr );";
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
                        if ( (synpred183_ObjCpp()) ) {s = 16;}

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
        "\21\uffff";
    static final String DFA99_eofS =
        "\21\uffff";
    static final String DFA99_minS =
        "\1\4\2\0\16\uffff";
    static final String DFA99_maxS =
        "\1\133\2\0\16\uffff";
    static final String DFA99_acceptS =
        "\3\uffff\1\2\13\uffff\1\3\1\1";
    static final String DFA99_specialS =
        "\1\uffff\1\0\1\1\16\uffff}>";
    static final String[] DFA99_transitionS = {
            "\2\3\1\1\4\3\24\uffff\1\3\2\uffff\1\3\10\uffff\1\3\1\2\10\uffff"+
            "\2\17\1\3\22\uffff\1\17\2\3\14\uffff\3\17",
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
            return "1455:1: unaryExpr returns [Expression expr] : ({...}? IDENTIFIER ( '(' tr= mutableTypeRef ')' ) | p= postfixExpr | uo= unaryOp castExpr );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA99_1 = input.LA(1);

                         
                        int index99_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((synpred184_ObjCpp()&&( next("sizeof") ))) ) {s = 16;}

                        else if ( (synpred185_ObjCpp()) ) {s = 3;}

                         
                        input.seek(index99_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA99_2 = input.LA(1);

                         
                        int index99_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred185_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index99_2);
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
    static final String DFA109_eotS =
        "\47\uffff";
    static final String DFA109_eofS =
        "\47\uffff";
    static final String DFA109_minS =
        "\1\4\1\uffff\1\0\4\uffff\4\0\1\uffff\2\0\31\uffff";
    static final String DFA109_maxS =
        "\1\144\1\uffff\1\0\4\uffff\4\0\1\uffff\2\0\31\uffff";
    static final String DFA109_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\15\uffff\1\3\13\uffff\1\4\1\6\1\7\1\10"+
        "\1\11\1\12\1\13\1\5\1\15\1\14";
    static final String DFA109_specialS =
        "\2\uffff\1\0\4\uffff\1\1\1\2\1\3\1\4\1\uffff\1\5\1\6\31\uffff}>";
    static final String[] DFA109_transitionS = {
            "\2\21\1\2\4\21\14\uffff\1\1\1\uffff\1\14\2\3\2\uffff\1\3\1\15"+
            "\1\3\1\uffff\1\11\10\uffff\2\21\1\3\4\uffff\2\3\1\35\2\7\1\10"+
            "\1\uffff\4\3\15\uffff\1\12\2\21\14\uffff\3\21\2\uffff\1\36\1"+
            "\37\1\uffff\1\40\1\41\1\42\1\43",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "1544:1: statement returns [Statement stat] : (b= statementsBlock | declaration | es= expression ';' | rt= 'return' rex= expression ';' | IDENTIFIER ':' | 'break' ';' | 'if' '(' topLevelExpr ')' statement ( 'else' statement )? | 'while' '(' topLevelExpr ')' statement | 'do' statement 'while' '(' topLevelExpr ')' ';' | 'for' '(' ( expression )? ';' ( expression )? ';' ( expression )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' topLevelExpr ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA109_2 = input.LA(1);

                         
                        int index109_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred203_ObjCpp()) ) {s = 3;}

                        else if ( (synpred204_ObjCpp()) ) {s = 17;}

                        else if ( (synpred206_ObjCpp()) ) {s = 36;}

                        else if ( (( next("foreach") )) ) {s = 37;}

                         
                        input.seek(index109_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA109_7 = input.LA(1);

                         
                        int index109_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred203_ObjCpp()) ) {s = 3;}

                        else if ( (synpred204_ObjCpp()) ) {s = 17;}

                         
                        input.seek(index109_7);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA109_8 = input.LA(1);

                         
                        int index109_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred203_ObjCpp()) ) {s = 3;}

                        else if ( (synpred204_ObjCpp()) ) {s = 17;}

                         
                        input.seek(index109_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA109_9 = input.LA(1);

                         
                        int index109_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred203_ObjCpp()) ) {s = 3;}

                        else if ( (synpred204_ObjCpp()) ) {s = 17;}

                         
                        input.seek(index109_9);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA109_10 = input.LA(1);

                         
                        int index109_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred203_ObjCpp()) ) {s = 3;}

                        else if ( (synpred204_ObjCpp()) ) {s = 17;}

                         
                        input.seek(index109_10);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA109_12 = input.LA(1);

                         
                        int index109_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred203_ObjCpp()) ) {s = 3;}

                        else if ( (synpred219_ObjCpp()) ) {s = 38;}

                         
                        input.seek(index109_12);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA109_13 = input.LA(1);

                         
                        int index109_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred203_ObjCpp()) ) {s = 3;}

                        else if ( (synpred204_ObjCpp()) ) {s = 17;}

                         
                        input.seek(index109_13);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 109, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_22_in_lineDirective78 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_lineDirective82 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_STRING_in_lineDirective95 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_lineDirective110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_sourceFile150 = new BitSet(new long[]{0x1A0C2001CC400040L,0x0000000000000400L});
    public static final BitSet FOLLOW_lineDirective_in_sourceFile159 = new BitSet(new long[]{0x1A0C2001CC400040L,0x0000000000000400L});
    public static final BitSet FOLLOW_EOF_in_sourceFile172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_externDeclarations191 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_externDeclarations195 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_externDeclarations201 = new BitSet(new long[]{0x1A0C2001CD000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_declaration_in_externDeclarations215 = new BitSet(new long[]{0x1A0C2001CD000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_24_in_externDeclarations228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pragmaContent_in_declaration274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_templateDef_in_declaration282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_declaration291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_externDeclarations_in_declaration301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_declaration311 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_declaration313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objCClassDef_in_declaration323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeDef_in_declaration333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forwardClassDecl_in_declaration343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_declaration353 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration357 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_declaration359 = new BitSet(new long[]{0x1A0C2001CD000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_declaration_in_declaration377 = new BitSet(new long[]{0x1A0C2001CD000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_24_in_declaration393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_forwardClassDecl433 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_forwardClassDecl440 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_28_in_forwardClassDecl447 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_forwardClassDecl454 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_25_in_forwardClassDecl465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_functionPointerVarDecl485 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_functionPointerVarDecl493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enumItem511 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_enumItem514 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_topLevelExpr_in_enumItem518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_enumBody544 = new BitSet(new long[]{0x0000000001000040L});
    public static final BitSet FOLLOW_enumItem_in_enumBody560 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_28_in_enumBody575 = new BitSet(new long[]{0x0000000011000040L});
    public static final BitSet FOLLOW_enumItem_in_enumBody586 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_24_in_enumBody607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_enumCore630 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_modifiers_in_enumCore641 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_enumBody_in_enumCore656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedIdentifier_in_enumCore668 = new BitSet(new long[]{0x0000000000800042L});
    public static final BitSet FOLLOW_modifiers_in_enumCore683 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_enumBody_in_enumCore694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_objCClassDef743 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef754 = new BitSet(new long[]{0x180C3E1640800040L});
    public static final BitSet FOLLOW_33_in_objCClassDef772 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef776 = new BitSet(new long[]{0x180C3E1040800040L});
    public static final BitSet FOLLOW_34_in_objCClassDef796 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef800 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCClassDef802 = new BitSet(new long[]{0x180C3E1040800040L});
    public static final BitSet FOLLOW_36_in_objCClassDef825 = new BitSet(new long[]{0x0000002000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef835 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_objCClassDef850 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef860 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_objCClassDef877 = new BitSet(new long[]{0x180C3E0040800040L});
    public static final BitSet FOLLOW_23_in_objCClassDef891 = new BitSet(new long[]{0x100C21C041000040L});
    public static final BitSet FOLLOW_38_in_objCClassDef902 = new BitSet(new long[]{0x100C21C041000040L});
    public static final BitSet FOLLOW_39_in_objCClassDef913 = new BitSet(new long[]{0x100C21C041000040L});
    public static final BitSet FOLLOW_40_in_objCClassDef924 = new BitSet(new long[]{0x100C21C041000040L});
    public static final BitSet FOLLOW_functionPointerOrSimpleVarDecl_in_objCClassDef941 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_objCClassDef943 = new BitSet(new long[]{0x100C21C041000040L});
    public static final BitSet FOLLOW_24_in_objCClassDef963 = new BitSet(new long[]{0x180C3E0040000040L});
    public static final BitSet FOLLOW_objCMethodDecl_in_objCClassDef981 = new BitSet(new long[]{0x180C3E0040000040L});
    public static final BitSet FOLLOW_objCPropertyDecl_in_objCClassDef990 = new BitSet(new long[]{0x180C3E0040000040L});
    public static final BitSet FOLLOW_typeDef_in_objCClassDef999 = new BitSet(new long[]{0x180C3E0040000040L});
    public static final BitSet FOLLOW_varDecl_in_objCClassDef1010 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_objCClassDef1012 = new BitSet(new long[]{0x180C3E0040000040L});
    public static final BitSet FOLLOW_41_in_objCClassDef1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_functionPointerOrSimpleVarDecl1050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionPointerVarDecl_in_functionPointerOrSimpleVarDecl1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_objCPropertyDecl1082 = new BitSet(new long[]{0x100C21C040000040L});
    public static final BitSet FOLLOW_functionPointerOrSimpleVarDecl_in_objCPropertyDecl1084 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_objCPropertyDecl1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_objCMethodDecl1117 = new BitSet(new long[]{0x0000200400000040L});
    public static final BitSet FOLLOW_44_in_objCMethodDecl1129 = new BitSet(new long[]{0x0000200400000040L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl1148 = new BitSet(new long[]{0x100C200840000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_objCMethodDecl1156 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl1164 = new BitSet(new long[]{0x0000200000000040L});
    public static final BitSet FOLLOW_set_in_objCMethodDecl1175 = new BitSet(new long[]{0x0000000202000000L});
    public static final BitSet FOLLOW_33_in_objCMethodDecl1193 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl1195 = new BitSet(new long[]{0x100C200040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_objCMethodDecl1199 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl1201 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1205 = new BitSet(new long[]{0x0000000012000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1220 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodDecl1222 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl1229 = new BitSet(new long[]{0x100C200040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_objCMethodDecl1233 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl1235 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1244 = new BitSet(new long[]{0x0000000012000040L});
    public static final BitSet FOLLOW_28_in_objCMethodDecl1263 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_objCMethodDecl1265 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_objCMethodDecl1282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_structBody1303 = new BitSet(new long[]{0x1A0FA001CD000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_47_in_structBody1321 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_48_in_structBody1333 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_49_in_structBody1345 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_structBody1356 = new BitSet(new long[]{0x1A0FA001CD000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_IDENTIFIER_in_structBody1366 = new BitSet(new long[]{0x1A0C2001CC000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_declaration_in_structBody1370 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_structBody1372 = new BitSet(new long[]{0x1A0FA001CD000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_declaration_in_structBody1384 = new BitSet(new long[]{0x1A0FA001CD000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_varDecl_in_structBody1396 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_structBody1398 = new BitSet(new long[]{0x1A0FA001CD000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_24_in_structBody1410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_structCore1457 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_modifiers_in_structCore1478 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_structBody_in_structCore1493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedIdentifier_in_structCore1505 = new BitSet(new long[]{0x0000000200800042L});
    public static final BitSet FOLLOW_modifiers_in_structCore1530 = new BitSet(new long[]{0x0000000200800000L});
    public static final BitSet FOLLOW_33_in_structCore1549 = new BitSet(new long[]{0x0000800000000040L});
    public static final BitSet FOLLOW_47_in_structCore1558 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_qualifiedIdentifier_in_structCore1570 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_structBody_in_structCore1590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binaryOp_in_anyOp1638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryOp_in_anyOp1647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentOp_in_anyOp1656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_functionDeclaration1691 = new BitSet(new long[]{0x100C200040000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_mutableTypeRef_in_functionDeclaration1699 = new BitSet(new long[]{0x100C200040000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_modifiers_in_functionDeclaration1708 = new BitSet(new long[]{0x100C200040000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_qualifiedCppFunctionName_in_functionDeclaration1716 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_argList_in_functionDeclaration1722 = new BitSet(new long[]{0x0000000202800040L});
    public static final BitSet FOLLOW_modifiers_in_functionDeclaration1730 = new BitSet(new long[]{0x0000000202800040L});
    public static final BitSet FOLLOW_33_in_functionDeclaration1741 = new BitSet(new long[]{0x100C200040000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_constructorInitializer_in_functionDeclaration1748 = new BitSet(new long[]{0x0000000212800040L});
    public static final BitSet FOLLOW_28_in_functionDeclaration1761 = new BitSet(new long[]{0x100C200040000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_constructorInitializer_in_functionDeclaration1765 = new BitSet(new long[]{0x0000000212800040L});
    public static final BitSet FOLLOW_25_in_functionDeclaration1788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_functionDeclaration1795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedCppFunctionName_in_constructorInitializer1818 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_constructorInitializer1826 = new BitSet(new long[]{0x00E0180C800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_topLevelExprList_in_constructorInitializer1835 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_constructorInitializer1844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_modifiers1868 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_IDENTIFIER_in_pragmaContent1894 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pragmaContent1896 = new BitSet(new long[]{0x0000180E100007F0L});
    public static final BitSet FOLLOW_IDENTIFIER_in_pragmaContent1903 = new BitSet(new long[]{0x0000180E100007F0L});
    public static final BitSet FOLLOW_constant_in_pragmaContent1907 = new BitSet(new long[]{0x0000180E100007F0L});
    public static final BitSet FOLLOW_28_in_pragmaContent1911 = new BitSet(new long[]{0x0000180E100007F0L});
    public static final BitSet FOLLOW_33_in_pragmaContent1915 = new BitSet(new long[]{0x0000180E100007F0L});
    public static final BitSet FOLLOW_34_in_pragmaContent1919 = new BitSet(new long[]{0x0000180A100007F0L});
    public static final BitSet FOLLOW_IDENTIFIER_in_pragmaContent1922 = new BitSet(new long[]{0x0000180A100007F0L});
    public static final BitSet FOLLOW_constant_in_pragmaContent1926 = new BitSet(new long[]{0x0000180A100007F0L});
    public static final BitSet FOLLOW_28_in_pragmaContent1930 = new BitSet(new long[]{0x0000180A100007F0L});
    public static final BitSet FOLLOW_33_in_pragmaContent1934 = new BitSet(new long[]{0x0000180A100007F0L});
    public static final BitSet FOLLOW_35_in_pragmaContent1938 = new BitSet(new long[]{0x0000180E100007F0L});
    public static final BitSet FOLLOW_35_in_pragmaContent1945 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_pragmaContent1950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pragmaContent_in_modifier1982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier1992 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_modifier1996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier2008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier2021 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_modifier2023 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_modifier2025 = new BitSet(new long[]{0xE460183000000000L,0x00000000000001FFL});
    public static final BitSet FOLLOW_binaryOp_in_modifier2027 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_expression_in_modifier2029 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_modifier2032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier2049 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_modifier2051 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_expression_in_modifier2053 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_modifier2055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier2069 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_modifier2073 = new BitSet(new long[]{0x0000000800000060L});
    public static final BitSet FOLLOW_STRING_in_modifier2084 = new BitSet(new long[]{0x0000000800000020L});
    public static final BitSet FOLLOW_extendedModifiers_in_modifier2096 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_modifier2104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_extendedModifiers2133 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_mutableTypeRef_in_argDef2176 = new BitSet(new long[]{0x0460000420000042L});
    public static final BitSet FOLLOW_declarator_in_argDef2191 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_argDef2203 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_topLevelExpr_in_argDef2207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_argDef2221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_typeMutator2243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_typeMutator2257 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_typeMutator2259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_arrayTypeMutator2277 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_expression_in_arrayTypeMutator2283 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_arrayTypeMutator2292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_templateDef2320 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_templateDef2322 = new BitSet(new long[]{0x100C602040000040L});
    public static final BitSet FOLLOW_templateArgDecl_in_templateDef2325 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_templateDef2328 = new BitSet(new long[]{0x100C600040000040L});
    public static final BitSet FOLLOW_templateArgDecl_in_templateDef2330 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_templateDef2337 = new BitSet(new long[]{0x1A0C2001CC000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_declaration_in_templateDef2341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argDef_in_templateArgDecl2356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffix2376 = new BitSet(new long[]{0x0020000000000040L});
    public static final BitSet FOLLOW_modifiers_in_functionSignatureSuffix2380 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_functionSignatureSuffix2382 = new BitSet(new long[]{0x0000000800000040L});
    public static final BitSet FOLLOW_modifiers_in_functionSignatureSuffix2386 = new BitSet(new long[]{0x0000000800000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionSignatureSuffix2388 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffix2391 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffix2397 = new BitSet(new long[]{0x100C600840000040L});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffix2406 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_functionSignatureSuffix2419 = new BitSet(new long[]{0x100C600040000040L});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffix2428 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffix2443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffixNoName2460 = new BitSet(new long[]{0x0020000000000040L});
    public static final BitSet FOLLOW_modifiers_in_functionSignatureSuffixNoName2462 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_functionSignatureSuffixNoName2464 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffixNoName2466 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffixNoName2472 = new BitSet(new long[]{0x100C600840000040L});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffixNoName2481 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_functionSignatureSuffixNoName2494 = new BitSet(new long[]{0x100C600040000040L});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffixNoName2503 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffixNoName2518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefCore_in_mutableTypeRef2538 = new BitSet(new long[]{0x00E0000400000002L});
    public static final BitSet FOLLOW_typeMutator_in_mutableTypeRef2559 = new BitSet(new long[]{0x00E0000400000002L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_mutableTypeRef2581 = new BitSet(new long[]{0x00E0000400000002L});
    public static final BitSet FOLLOW_typeRefCore_in_nonMutableTypeRef2610 = new BitSet(new long[]{0x00E0000400000002L});
    public static final BitSet FOLLOW_typeMutator_in_nonMutableTypeRef2627 = new BitSet(new long[]{0x00E0000400000000L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_nonMutableTypeRef2648 = new BitSet(new long[]{0x00E0000400000002L});
    public static final BitSet FOLLOW_modifiers_in_declarator2678 = new BitSet(new long[]{0x0460000400000040L});
    public static final BitSet FOLLOW_directDeclarator_in_declarator2694 = new BitSet(new long[]{0x0000000220000002L});
    public static final BitSet FOLLOW_set_in_declarator2718 = new BitSet(new long[]{0x0460000400000040L});
    public static final BitSet FOLLOW_declarator_in_declarator2736 = new BitSet(new long[]{0x0000000220000002L});
    public static final BitSet FOLLOW_33_in_declarator2757 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_declarator2761 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_declarator2777 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_topLevelExpr_in_declarator2785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_typeDef2821 = new BitSet(new long[]{0x100C200040000040L});
    public static final BitSet FOLLOW_varDecl_in_typeDef2826 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_typeDef2828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_varDeclEOF2846 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_varDeclEOF2848 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_varDeclEOF2850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_declarationEOF2870 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_declarationEOF2872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nonMutableTypeRef_in_varDecl2894 = new BitSet(new long[]{0x0460000400000042L});
    public static final BitSet FOLLOW_declaratorsList_in_varDecl2907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_objCProtocolRefList2926 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCProtocolRefList2931 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_objCProtocolRefList2941 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCProtocolRefList2947 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_objCProtocolRefList2957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarator_in_declaratorsList2978 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_declaratorsList2989 = new BitSet(new long[]{0x0460000400000040L});
    public static final BitSet FOLLOW_declarator_in_declaratorsList2997 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_directDeclarator3030 = new BitSet(new long[]{0x0080000400000002L});
    public static final BitSet FOLLOW_34_in_directDeclarator3040 = new BitSet(new long[]{0x0460000400000040L});
    public static final BitSet FOLLOW_declarator_in_directDeclarator3044 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_directDeclarator3046 = new BitSet(new long[]{0x0080000400000002L});
    public static final BitSet FOLLOW_55_in_directDeclarator3062 = new BitSet(new long[]{0x01E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_expression_in_directDeclarator3074 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_directDeclarator3087 = new BitSet(new long[]{0x0080000400000002L});
    public static final BitSet FOLLOW_argList_in_directDeclarator3095 = new BitSet(new long[]{0x0080000400000002L});
    public static final BitSet FOLLOW_34_in_argList3123 = new BitSet(new long[]{0x100C600840000040L});
    public static final BitSet FOLLOW_argDef_in_argList3135 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_argList3148 = new BitSet(new long[]{0x100C600040000040L});
    public static final BitSet FOLLOW_argDef_in_argList3157 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_argList3177 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_argList3179 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_argList3198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_typeRefCore3228 = new BitSet(new long[]{0x100C200040000040L});
    public static final BitSet FOLLOW_60_in_typeRefCore3239 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_typeName_in_typeRefCore3243 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_typeName_in_typeRefCore3257 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_structCore_in_typeRefCore3266 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_enumCore_in_typeRefCore3275 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_modifiers_in_typeRefCore3288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedIdentifier_in_typeName3310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_objCMethodCall3330 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3334 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodCall3338 = new BitSet(new long[]{0x0100000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodCall3349 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3353 = new BitSet(new long[]{0x0100000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodCall3368 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodCall3370 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3374 = new BitSet(new long[]{0x0100000000000040L});
    public static final BitSet FOLLOW_56_in_objCMethodCall3391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_binaryOp3409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_typeRefOrExpression3516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_topLevelExpr_in_typeRefOrExpression3527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_simpleIdentifier3546 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_simpleIdentifier3557 = new BitSet(new long[]{0x10EC3824C00007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_typeRefOrExpression_in_simpleIdentifier3567 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_simpleIdentifier3582 = new BitSet(new long[]{0x10EC3804C00007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_typeRefOrExpression_in_simpleIdentifier3592 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_simpleIdentifier3611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleIdentifier_in_qualifiedIdentifier3633 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_qualifiedIdentifier3644 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_simpleIdentifier_in_qualifiedIdentifier3648 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_simpleCppFunctionName_in_qualifiedCppFunctionName3673 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_qualifiedCppFunctionName3684 = new BitSet(new long[]{0x100C200040000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_simpleCppFunctionName_in_qualifiedCppFunctionName3688 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_74_in_simpleCppFunctionName3715 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_simpleIdentifier_in_simpleCppFunctionName3723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleIdentifier_in_baseExpression3745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_baseExpression3754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_baseExpression3762 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_expression_in_baseExpression3764 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_baseExpression3766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objCMethodCall_in_baseExpression3774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selectorExpr_in_baseExpression3782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_protocolExpr_in_baseExpression3788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_encodingExpr_in_baseExpression3794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_selectorExpr3810 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_selectorExpr3815 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_selectorName_in_selectorExpr3820 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_selectorExpr3825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_selectorName3836 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_IDENTIFIER_in_selectorName3839 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_selectorName3841 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_31_in_protocolExpr3854 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_protocolExpr3858 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_protocolExpr3862 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_protocolExpr3866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_encodingExpr3877 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_encodingExpr3882 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_encodingExpr3886 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_encodingExpr3891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inlineCondExpr_in_assignmentExpr3908 = new BitSet(new long[]{0x0000000020000002L,0x0000000000FFE000L});
    public static final BitSet FOLLOW_assignmentOp_in_assignmentExpr3924 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_assignmentExpr_in_assignmentExpr3928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_assignmentOp3954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logOrExpr_in_inlineCondExpr4019 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_inlineCondExpr4031 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_logOrExpr_in_inlineCondExpr4036 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_inlineCondExpr4042 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_logOrExpr_in_inlineCondExpr4047 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_multExpr_in_addExpr4069 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_set_in_addExpr4082 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_multExpr_in_addExpr4095 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_castExpr_in_multExpr4119 = new BitSet(new long[]{0x6020000000000002L});
    public static final BitSet FOLLOW_set_in_multExpr4133 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_castExpr_in_multExpr4151 = new BitSet(new long[]{0x6020000000000002L});
    public static final BitSet FOLLOW_xorExpr_in_bitOrExpr4175 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_bitOrExpr4189 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_xorExpr_in_bitOrExpr4196 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_equalExpr_in_bitAndExpr4220 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_54_in_bitAndExpr4233 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_equalExpr_in_bitAndExpr4240 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_addExpr_in_shiftExpr4265 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_shiftExpr4278 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_addExpr_in_shiftExpr4291 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_bitAndExpr_in_xorExpr4315 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_58_in_xorExpr4328 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_bitAndExpr_in_xorExpr4335 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_logAndExpr_in_logOrExpr4359 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_logOrExpr4372 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_logAndExpr_in_logOrExpr4379 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_bitOrExpr_in_logAndExpr4403 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_logAndExpr4416 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_bitOrExpr_in_logAndExpr4423 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_compareExpr_in_equalExpr4447 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_set_in_equalExpr4460 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_compareExpr_in_equalExpr4473 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_shiftExpr_in_compareExpr4497 = new BitSet(new long[]{0x0000003000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_set_in_compareExpr4510 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_shiftExpr_in_compareExpr4532 = new BitSet(new long[]{0x0000003000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_34_in_castExpr4554 = new BitSet(new long[]{0x100C200040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_castExpr4558 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_castExpr4560 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_castExpr_in_castExpr4564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpr_in_castExpr4575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_unaryExpr4597 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_unaryExpr4604 = new BitSet(new long[]{0x100C200040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_unaryExpr4608 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_unaryExpr4610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpr_in_unaryExpr4628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryOp_in_unaryExpr4638 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_castExpr_in_unaryExpr4640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_unaryOp4660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_baseExpression_in_postfixExpr4707 = new BitSet(new long[]{0x0080000400000002L,0x0000000036000200L});
    public static final BitSet FOLLOW_55_in_postfixExpr4718 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_expression_in_postfixExpr4720 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_postfixExpr4722 = new BitSet(new long[]{0x0080000400000002L,0x0000000036000200L});
    public static final BitSet FOLLOW_34_in_postfixExpr4731 = new BitSet(new long[]{0x00E0180C800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_topLevelExprList_in_postfixExpr4733 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_postfixExpr4736 = new BitSet(new long[]{0x0080000400000002L,0x0000000036000200L});
    public static final BitSet FOLLOW_73_in_postfixExpr4745 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_simpleIdentifier_in_postfixExpr4749 = new BitSet(new long[]{0x0080000400000002L,0x0000000036000200L});
    public static final BitSet FOLLOW_92_in_postfixExpr4758 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_simpleIdentifier_in_postfixExpr4762 = new BitSet(new long[]{0x0080000400000002L,0x0000000036000200L});
    public static final BitSet FOLLOW_93_in_postfixExpr4771 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_simpleIdentifier_in_postfixExpr4775 = new BitSet(new long[]{0x0080000400000002L,0x0000000036000200L});
    public static final BitSet FOLLOW_89_in_postfixExpr4784 = new BitSet(new long[]{0x0080000400000002L,0x0000000036000200L});
    public static final BitSet FOLLOW_90_in_postfixExpr4793 = new BitSet(new long[]{0x0080000400000002L,0x0000000036000200L});
    public static final BitSet FOLLOW_assignmentExpr_in_topLevelExpr4817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_topLevelExpr_in_topLevelExprList4842 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_topLevelExprList4853 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_topLevelExpr_in_topLevelExprList4860 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_topLevelExprList_in_expression4884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_statementsBlock4918 = new BitSet(new long[]{0x1AFC3807CF8007F0L,0x0000001ECE001C00L});
    public static final BitSet FOLLOW_statement_in_statementsBlock4928 = new BitSet(new long[]{0x1AFC3807CF8007F0L,0x0000001ECE001C00L});
    public static final BitSet FOLLOW_24_in_statementsBlock4940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_statement4959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_statement4967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement4976 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_statement4988 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_expression_in_statement4992 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement5002 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement5004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_statement5011 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement5013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_statement5019 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement5021 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_topLevelExpr_in_statement5023 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement5025 = new BitSet(new long[]{0x1AFC3807CE8007F0L,0x0000001ECE001C00L});
    public static final BitSet FOLLOW_statement_in_statement5027 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_statement5030 = new BitSet(new long[]{0x1AFC3807CE8007F0L,0x0000001ECE001C00L});
    public static final BitSet FOLLOW_statement_in_statement5032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_statement5041 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement5043 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_topLevelExpr_in_statement5045 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement5047 = new BitSet(new long[]{0x1AFC3807CE8007F0L,0x0000001ECE001C00L});
    public static final BitSet FOLLOW_statement_in_statement5049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_statement5056 = new BitSet(new long[]{0x1AFC3807CE8007F0L,0x0000001ECE001C00L});
    public static final BitSet FOLLOW_statement_in_statement5058 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_statement5060 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement5062 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_topLevelExpr_in_statement5064 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement5066 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement5068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_statement5075 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement5077 = new BitSet(new long[]{0x00E01804820007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_expression_in_statement5079 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement5082 = new BitSet(new long[]{0x00E01804820007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_expression_in_statement5084 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement5087 = new BitSet(new long[]{0x00E0180C800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_expression_in_statement5089 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement5092 = new BitSet(new long[]{0x1AFC3807CE8007F0L,0x0000001ECE001C00L});
    public static final BitSet FOLLOW_statement_in_statement5094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_statement5101 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement5103 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_expression_in_statement5105 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement5107 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_statement5109 = new BitSet(new long[]{0x1AFC3807CF8007F0L,0x0000003ECE001C00L});
    public static final BitSet FOLLOW_101_in_statement5122 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_topLevelExpr_in_statement5124 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement5126 = new BitSet(new long[]{0x1AFC3807CF8007F0L,0x0000003ECE001C00L});
    public static final BitSet FOLLOW_statement_in_statement5134 = new BitSet(new long[]{0x1AFC3807CF8007F0L,0x0000003ECE001C00L});
    public static final BitSet FOLLOW_24_in_statement5144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_statement5150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement5158 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement5160 = new BitSet(new long[]{0x100C200040000040L});
    public static final BitSet FOLLOW_varDecl_in_statement5162 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement5164 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_expression_in_statement5166 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement5168 = new BitSet(new long[]{0x1AFC3807CE8007F0L,0x0000001ECE001C00L});
    public static final BitSet FOLLOW_statement_in_statement5170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_constant5189 = new BitSet(new long[]{0x0000000000000190L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_constant5203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEXADECIMAL_NUMBER_in_constant5212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OCTAL_NUMBER_in_constant5221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARACTER_in_constant5233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_constant5243 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_FLOAT_NUMBER_in_constant5252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_constant5263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pragmaContent_in_synpred6_ObjCpp274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_synpred8_ObjCpp291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_externDeclarations_in_synpred9_ObjCpp301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred10_ObjCpp311 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred10_ObjCpp313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_synpred21_ObjCpp683 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_enumBody_in_synpred21_ObjCpp694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred24_ObjCpp796 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred24_ObjCpp800 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred24_ObjCpp802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionPointerOrSimpleVarDecl_in_synpred31_ObjCpp941 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred31_ObjCpp943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred36_ObjCpp1010 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred36_ObjCpp1012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred37_ObjCpp1050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred39_ObjCpp1156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred48_ObjCpp1366 = new BitSet(new long[]{0x1A0C2001CC000040L,0x0000000000000400L});
    public static final BitSet FOLLOW_declaration_in_synpred48_ObjCpp1370 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred48_ObjCpp1372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_synpred49_ObjCpp1384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred50_ObjCpp1396 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred50_ObjCpp1398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_synpred56_ObjCpp1530 = new BitSet(new long[]{0x0000000200800000L});
    public static final BitSet FOLLOW_33_in_synpred56_ObjCpp1549 = new BitSet(new long[]{0x0000800000000040L});
    public static final BitSet FOLLOW_47_in_synpred56_ObjCpp1558 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_qualifiedIdentifier_in_synpred56_ObjCpp1570 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_structBody_in_synpred56_ObjCpp1590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binaryOp_in_synpred57_ObjCpp1638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryOp_in_synpred58_ObjCpp1647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred59_ObjCpp1699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred64_ObjCpp1868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_synpred74_ObjCpp1950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pragmaContent_in_synpred75_ObjCpp1982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred76_ObjCpp1992 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_synpred76_ObjCpp1996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred77_ObjCpp2008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred78_ObjCpp2021 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_synpred78_ObjCpp2023 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_synpred78_ObjCpp2025 = new BitSet(new long[]{0xE460183000000000L,0x00000000000001FFL});
    public static final BitSet FOLLOW_binaryOp_in_synpred78_ObjCpp2027 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_expression_in_synpred78_ObjCpp2029 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred78_ObjCpp2032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred79_ObjCpp2049 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_synpred79_ObjCpp2051 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_expression_in_synpred79_ObjCpp2053 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred79_ObjCpp2055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_synpred81_ObjCpp2084 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_declarator_in_synpred83_ObjCpp2191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred85_ObjCpp2176 = new BitSet(new long[]{0x0460000420000042L});
    public static final BitSet FOLLOW_declarator_in_synpred85_ObjCpp2191 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_synpred85_ObjCpp2203 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_topLevelExpr_in_synpred85_ObjCpp2207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_templateArgDecl_in_synpred89_ObjCpp2325 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred89_ObjCpp2328 = new BitSet(new long[]{0x100C600040000040L});
    public static final BitSet FOLLOW_templateArgDecl_in_synpred89_ObjCpp2330 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_argDef_in_synpred92_ObjCpp2406 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred92_ObjCpp2419 = new BitSet(new long[]{0x100C600040000040L});
    public static final BitSet FOLLOW_argDef_in_synpred92_ObjCpp2428 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_argDef_in_synpred94_ObjCpp2481 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred94_ObjCpp2494 = new BitSet(new long[]{0x100C600040000040L});
    public static final BitSet FOLLOW_argDef_in_synpred94_ObjCpp2503 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred95_ObjCpp2559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_synpred96_ObjCpp2581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred98_ObjCpp2627 = new BitSet(new long[]{0x00E0000400000000L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_synpred98_ObjCpp2648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_synpred102_ObjCpp2757 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_synpred102_ObjCpp2761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred103_ObjCpp2777 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_topLevelExpr_in_synpred103_ObjCpp2785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred107_ObjCpp3030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_synpred111_ObjCpp3148 = new BitSet(new long[]{0x100C600040000040L});
    public static final BitSet FOLLOW_argDef_in_synpred111_ObjCpp3157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argDef_in_synpred113_ObjCpp3135 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred113_ObjCpp3148 = new BitSet(new long[]{0x100C600040000040L});
    public static final BitSet FOLLOW_argDef_in_synpred113_ObjCpp3157 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred113_ObjCpp3177 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_synpred113_ObjCpp3179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeName_in_synpred115_ObjCpp3257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred138_ObjCpp3516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefOrExpression_in_synpred140_ObjCpp3567 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred140_ObjCpp3582 = new BitSet(new long[]{0x10EC3804C00007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_typeRefOrExpression_in_synpred140_ObjCpp3592 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_36_in_synpred141_ObjCpp3557 = new BitSet(new long[]{0x10EC3824C00007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_typeRefOrExpression_in_synpred141_ObjCpp3567 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_synpred141_ObjCpp3582 = new BitSet(new long[]{0x10EC3804C00007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_typeRefOrExpression_in_synpred141_ObjCpp3592 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_synpred141_ObjCpp3611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentOp_in_synpred152_ObjCpp3924 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_assignmentExpr_in_synpred152_ObjCpp3928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred182_ObjCpp4510 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_shiftExpr_in_synpred182_ObjCpp4532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred183_ObjCpp4554 = new BitSet(new long[]{0x100C200040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred183_ObjCpp4558 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred183_ObjCpp4560 = new BitSet(new long[]{0x00E01804800007F0L,0x000000000E001C00L});
    public static final BitSet FOLLOW_castExpr_in_synpred183_ObjCpp4564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred184_ObjCpp4597 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_synpred184_ObjCpp4604 = new BitSet(new long[]{0x100C200040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred184_ObjCpp4608 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred184_ObjCpp4610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpr_in_synpred185_ObjCpp4628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_synpred203_ObjCpp4967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred204_ObjCpp4976 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred204_ObjCpp4978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred206_ObjCpp5002 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_synpred206_ObjCpp5004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_synpred208_ObjCpp5030 = new BitSet(new long[]{0x1AFC3807CE8007F0L,0x0000001ECE001C00L});
    public static final BitSet FOLLOW_statement_in_synpred208_ObjCpp5032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_synpred219_ObjCpp5150 = new BitSet(new long[]{0x0000000000000002L});

}