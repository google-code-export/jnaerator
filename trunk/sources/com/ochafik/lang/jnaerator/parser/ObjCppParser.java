// $ANTLR 3.1.2 /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g 2009-04-26 20:06:54
 
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DECIMAL_NUMBER", "STRING", "IDENTIFIER", "HEXADECIMAL_NUMBER", "OCTAL_NUMBER", "CHARACTER", "FLOAT_NUMBER", "Letter", "FloatingPointExponentSuffix", "FloatingPointConstantSuffix", "OctalEscape", "CharEscape", "HexDigit", "UnicodeEscape", "IntegerConstantSuffix", "WS", "COMMENT", "LINE_COMMENT", "'#line'", "'{'", "'}'", "';'", "'namespace'", "'@class'", "','", "'='", "'enum'", "'@protocol'", "'@interface'", "':'", "'('", "')'", "'<'", "'>'", "'@public'", "'@private'", "'@protected'", "'@end'", "'+'", "'-'", "'...'", "'public'", "'private'", "'protected'", "'struct'", "'class'", "'union'", "'return'", "'*'", "'&'", "'['", "']'", "'template'", "'^'", "'typedef'", "'typename'", "'/'", "'%'", "'<<'", "'>>>'", "'>>'", "'||'", "'|'", "'&&'", "'<='", "'>='", "'=='", "'!='", "'::'", "'~'", "'@selector'", "'@encode'", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'~='", "'?'", "'sizeof'", "'++'", "'--'", "'!'", "'.'", "'->'", "'break'", "'if'", "'else'", "'while'", "'do'", "'for'", "'switch'", "'case'"
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
            this.state.ruleMemo = new HashMap[302+1];
             
             
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:290:1: lineDirective : ln= '#line' line= DECIMAL_NUMBER (unescapedString= STRING )? (depth= DECIMAL_NUMBER )? ;
    public final void lineDirective() throws RecognitionException {
        int lineDirective_StartIndex = input.index();
        Token ln=null;
        Token line=null;
        Token unescapedString=null;
        Token depth=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return ; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:291:2: (ln= '#line' line= DECIMAL_NUMBER (unescapedString= STRING )? (depth= DECIMAL_NUMBER )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:291:4: ln= '#line' line= DECIMAL_NUMBER (unescapedString= STRING )? (depth= DECIMAL_NUMBER )?
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:299:3: (unescapedString= STRING )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==STRING) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:300:4: unescapedString= STRING
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:310:8: (depth= DECIMAL_NUMBER )?
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:313:1: sourceFile returns [SourceFile sourceFile] : ( declaration | lineDirective )* EOF ;
    public final SourceFile sourceFile() throws RecognitionException {
        Symbols_stack.push(new Symbols_scope());

        SourceFile sourceFile = null;
        int sourceFile_StartIndex = input.index();
        ObjCppParser.declaration_return declaration1 = null;



        	((Symbols_scope)Symbols_stack.peek()).typeIdentifiers = new HashSet<String>();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return sourceFile; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:318:2: ( ( declaration | lineDirective )* EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:319:3: ( declaration | lineDirective )* EOF
            {
            if ( state.backtracking==0 ) {
               sourceFile = new SourceFile(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:320:3: ( declaration | lineDirective )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==IDENTIFIER||(LA3_0>=25 && LA3_0<=27)||(LA3_0>=30 && LA3_0<=32)||LA3_0==34||(LA3_0>=48 && LA3_0<=50)||(LA3_0>=52 && LA3_0<=54)||(LA3_0>=56 && LA3_0<=59)||LA3_0==73) ) {
                    alt3=1;
                }
                else if ( (LA3_0==22) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:321:4: declaration
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:325:4: lineDirective
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:333:1: externDeclarations returns [ExternDeclarations declarations] : {...}? => IDENTIFIER STRING '{' (ed= declaration )* '}' ;
    public final ExternDeclarations externDeclarations() throws RecognitionException {
        ExternDeclarations declarations = null;
        int externDeclarations_StartIndex = input.index();
        Token STRING2=null;
        ObjCppParser.declaration_return ed = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return declarations; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:334:2: ({...}? => IDENTIFIER STRING '{' (ed= declaration )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:334:4: {...}? => IDENTIFIER STRING '{' (ed= declaration )* '}'
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:340:4: (ed= declaration )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==IDENTIFIER||(LA4_0>=25 && LA4_0<=27)||(LA4_0>=30 && LA4_0<=32)||LA4_0==34||(LA4_0>=48 && LA4_0<=50)||(LA4_0>=52 && LA4_0<=54)||(LA4_0>=56 && LA4_0<=59)||LA4_0==73) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:341:5: ed= declaration
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:348:1: declaration returns [List<Declaration> declarations, List<Modifier> modifiers, String preComment, int startTokenIndex] : ( ({...}? => pragmaContent | templateDef | functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) ) ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:350:2: ( ( ({...}? => pragmaContent | templateDef | functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:351:3: ( ({...}? => pragmaContent | templateDef | functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) )
            {
            if ( state.backtracking==0 ) {
               retval.declarations = new ArrayList<Declaration>(); 
              		  retval.modifiers = new ArrayList<Modifier>();
              		  retval.startTokenIndex = getTokenStream().index();
              		  retval.preComment = getCommentBefore(retval.startTokenIndex);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:356:3: ( ({...}? => pragmaContent | templateDef | functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:357:4: ({...}? => pragmaContent | templateDef | functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:357:4: ({...}? => pragmaContent | templateDef | functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )
            int alt6=9;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:358:5: {...}? => pragmaContent
                    {
                    if ( !(( next("__pragma") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "declaration", " next(\"__pragma\") ");
                    }
                    pushFollow(FOLLOW_pragmaContent_in_declaration269);
                    pragmaContent();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:359:5: templateDef
                    {
                    pushFollow(FOLLOW_templateDef_in_declaration277);
                    templateDef();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:360:5: functionDeclaration
                    {
                    pushFollow(FOLLOW_functionDeclaration_in_declaration286);
                    functionDeclaration3=functionDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      					retval.declarations.add((functionDeclaration3!=null?functionDeclaration3.function:null));
                      				
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:363:5: externDeclarations
                    {
                    pushFollow(FOLLOW_externDeclarations_in_declaration296);
                    externDeclarations4=externDeclarations();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      					retval.declarations.add(externDeclarations4); 
                      				
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:366:5: varDecl ';'
                    {
                    pushFollow(FOLLOW_varDecl_in_declaration306);
                    varDecl5=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    match(input,25,FOLLOW_25_in_declaration308); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       
                      					retval.declarations.add(varDecl5); 
                      				
                    }

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:369:5: objCClassDef
                    {
                    pushFollow(FOLLOW_objCClassDef_in_declaration318);
                    objCClassDef6=objCClassDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       
                      					retval.declarations.add(decl(objCClassDef6)); 
                      				
                    }

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:372:5: typeDef
                    {
                    pushFollow(FOLLOW_typeDef_in_declaration328);
                    typeDef7=typeDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      					retval.declarations.add(typeDef7); 
                      				
                    }

                    }
                    break;
                case 8 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:375:5: forwardClassDecl
                    {
                    pushFollow(FOLLOW_forwardClassDecl_in_declaration338);
                    forwardClassDecl8=forwardClassDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      					retval.declarations.addAll(forwardClassDecl8); 
                      				
                    }

                    }
                    break;
                case 9 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:378:5: 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}'
                    {
                    match(input,26,FOLLOW_26_in_declaration348); if (state.failed) return retval;
                    ns=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_declaration352); if (state.failed) return retval;
                    match(input,23,FOLLOW_23_in_declaration354); if (state.failed) return retval;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:379:6: (subD= declaration )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==IDENTIFIER||(LA5_0>=25 && LA5_0<=27)||(LA5_0>=30 && LA5_0<=32)||LA5_0==34||(LA5_0>=48 && LA5_0<=50)||(LA5_0>=52 && LA5_0<=54)||(LA5_0>=56 && LA5_0<=59)||LA5_0==73) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:380:7: subD= declaration
                    	    {
                    	    pushFollow(FOLLOW_declaration_in_declaration372);
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

                    match(input,24,FOLLOW_24_in_declaration388); if (state.failed) return retval;

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:406:1: forwardClassDecl returns [List<Declaration> declarations] : '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';' ;
    public final List<Declaration> forwardClassDecl() throws RecognitionException {
        List<Declaration> declarations = null;
        int forwardClassDecl_StartIndex = input.index();
        Token n1=null;
        Token nx=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return declarations; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:407:2: ( '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:407:5: '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';'
            {
            if ( state.backtracking==0 ) {
               declarations = new ArrayList<Declaration>(); 
            }
            match(input,27,FOLLOW_27_in_forwardClassDecl428); if (state.failed) return declarations;
            n1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_forwardClassDecl435); if (state.failed) return declarations;
            if ( state.backtracking==0 ) {
               
              			declarations.add(decl(Struct.forwardDecl(new SimpleIdentifier((n1!=null?n1.getText():null)), Struct.Type.ObjCClass))); 
              			defineTypeIdentifierInParentScope((n1!=null?n1.getText():null));
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:413:3: ( ',' nx= IDENTIFIER )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==28) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:413:4: ',' nx= IDENTIFIER
            	    {
            	    match(input,28,FOLLOW_28_in_forwardClassDecl442); if (state.failed) return declarations;
            	    nx=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_forwardClassDecl449); if (state.failed) return declarations;
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

            match(input,25,FOLLOW_25_in_forwardClassDecl460); if (state.failed) return declarations;

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:422:1: functionPointerVarDecl returns [List<? extends Declaration> declarations] : tr= mutableTypeRef {...}? ';' ;
    public final List<? extends Declaration> functionPointerVarDecl() throws RecognitionException {
        List<? extends Declaration> declarations = null;
        int functionPointerVarDecl_StartIndex = input.index();
        TypeRef tr = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return declarations; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:423:2: (tr= mutableTypeRef {...}? ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:423:4: tr= mutableTypeRef {...}? ';'
            {
            pushFollow(FOLLOW_mutableTypeRef_in_functionPointerVarDecl480);
            tr=mutableTypeRef();

            state._fsp--;
            if (state.failed) return declarations;
            if ( !((
            			(tr instanceof FunctionSignature) && 
            			((FunctionSignature)tr).getFunction().getName() != null
            		)) ) {
                if (state.backtracking>0) {state.failed=true; return declarations;}
                throw new FailedPredicateException(input, "functionPointerVarDecl", "\n\t\t\t($tr.type instanceof FunctionSignature) && \n\t\t\t((FunctionSignature)$tr.type).getFunction().getName() != null\n\t\t");
            }
            if ( state.backtracking==0 ) {

              			declarations = Arrays.asList(new FunctionPointerDeclaration(((FunctionSignature)tr)));
              		
            }
            match(input,25,FOLLOW_25_in_functionPointerVarDecl488); if (state.failed) return declarations;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, functionPointerVarDecl_StartIndex); }
        }
        return declarations;
    }
    // $ANTLR end "functionPointerVarDecl"

    public static class enumItem_return extends ParserRuleReturnScope {
        public Enum.EnumItem item;
    };

    // $ANTLR start "enumItem"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:432:1: enumItem returns [Enum.EnumItem item] : n= IDENTIFIER ( '=' v= topLevelExpr )? ;
    public final ObjCppParser.enumItem_return enumItem() throws RecognitionException {
        ObjCppParser.enumItem_return retval = new ObjCppParser.enumItem_return();
        retval.start = input.LT(1);
        int enumItem_StartIndex = input.index();
        Token n=null;
        ObjCppParser.topLevelExpr_return v = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:433:2: (n= IDENTIFIER ( '=' v= topLevelExpr )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:433:4: n= IDENTIFIER ( '=' v= topLevelExpr )?
            {
            n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumItem506); if (state.failed) return retval;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:433:17: ( '=' v= topLevelExpr )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==29) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:433:18: '=' v= topLevelExpr
                    {
                    match(input,29,FOLLOW_29_in_enumItem509); if (state.failed) return retval;
                    pushFollow(FOLLOW_topLevelExpr_in_enumItem513);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:440:1: enumBody returns [Enum e] : '{' (i1= enumItem ( ',' (ix= enumItem )? )* )? '}' ;
    public final Enum enumBody() throws RecognitionException {
        Enum e = null;
        int enumBody_StartIndex = input.index();
        ObjCppParser.enumItem_return i1 = null;

        ObjCppParser.enumItem_return ix = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return e; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:441:2: ( '{' (i1= enumItem ( ',' (ix= enumItem )? )* )? '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:442:3: '{' (i1= enumItem ( ',' (ix= enumItem )? )* )? '}'
            {
            if ( state.backtracking==0 ) {
               
              			e = new Enum();
              			e.setForwardDeclaration(false); 
              		
            }
            match(input,23,FOLLOW_23_in_enumBody539); if (state.failed) return e;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:447:4: (i1= enumItem ( ',' (ix= enumItem )? )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==IDENTIFIER) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:448:5: i1= enumItem ( ',' (ix= enumItem )? )*
                    {
                    pushFollow(FOLLOW_enumItem_in_enumBody555);
                    i1=enumItem();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                       
                      					if ((i1!=null?input.toString(i1.start,i1.stop):null) != null)
                      						e.addItem((i1!=null?i1.item:null)); 
                      				
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:452:5: ( ',' (ix= enumItem )? )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==28) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:453:6: ',' (ix= enumItem )?
                    	    {
                    	    match(input,28,FOLLOW_28_in_enumBody570); if (state.failed) return e;
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:454:6: (ix= enumItem )?
                    	    int alt9=2;
                    	    int LA9_0 = input.LA(1);

                    	    if ( (LA9_0==IDENTIFIER) ) {
                    	        alt9=1;
                    	    }
                    	    switch (alt9) {
                    	        case 1 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:454:7: ix= enumItem
                    	            {
                    	            pushFollow(FOLLOW_enumItem_in_enumBody581);
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

            match(input,24,FOLLOW_24_in_enumBody602); if (state.failed) return e;

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:462:1: enumCore returns [Enum e] : t= 'enum' (m1= modifiers (ab= enumBody | tag= qualifiedIdentifier (m2= modifiers nb= enumBody | ) ) ) ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:466:2: (t= 'enum' (m1= modifiers (ab= enumBody | tag= qualifiedIdentifier (m2= modifiers nb= enumBody | ) ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:467:3: t= 'enum' (m1= modifiers (ab= enumBody | tag= qualifiedIdentifier (m2= modifiers nb= enumBody | ) ) )
            {
            t=(Token)match(input,30,FOLLOW_30_in_enumCore625); if (state.failed) return e;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:468:3: (m1= modifiers (ab= enumBody | tag= qualifiedIdentifier (m2= modifiers nb= enumBody | ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:469:4: m1= modifiers (ab= enumBody | tag= qualifiedIdentifier (m2= modifiers nb= enumBody | ) )
            {
            pushFollow(FOLLOW_modifiers_in_enumCore636);
            m1=modifiers();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
               modifiers.addAll(m1); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:470:4: (ab= enumBody | tag= qualifiedIdentifier (m2= modifiers nb= enumBody | ) )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:471:5: ab= enumBody
                    {
                    pushFollow(FOLLOW_enumBody_in_enumCore651);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:475:5: tag= qualifiedIdentifier (m2= modifiers nb= enumBody | )
                    {
                    pushFollow(FOLLOW_qualifiedIdentifier_in_enumCore663);
                    tag=qualifiedIdentifier();

                    state._fsp--;
                    if (state.failed) return e;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:476:5: (m2= modifiers nb= enumBody | )
                    int alt12=2;
                    alt12 = dfa12.predict(input);
                    switch (alt12) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:477:6: m2= modifiers nb= enumBody
                            {
                            pushFollow(FOLLOW_modifiers_in_enumCore678);
                            m2=modifiers();

                            state._fsp--;
                            if (state.failed) return e;
                            if ( state.backtracking==0 ) {
                               modifiers.addAll(m2); 
                            }
                            pushFollow(FOLLOW_enumBody_in_enumCore689);
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
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:481:10: 
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:498:1: objCClassDef returns [Struct struct] : octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl ';' | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl ';' {...}?)* '@end' ;
    public final Struct objCClassDef() throws RecognitionException {
        Struct struct = null;
        int objCClassDef_StartIndex = input.index();
        Token octype=null;
        Token className=null;
        Token parentClass=null;
        Token categoryName=null;
        Token p1=null;
        Token px=null;
        VariablesDeclaration fv = null;

        VariablesDeclaration vd = null;

        List<? extends Declaration> functionPointerVarDecl9 = null;

        Function objCMethodDecl10 = null;

        TypeDef typeDef11 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return struct; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:499:2: (octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl ';' | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl ';' {...}?)* '@end' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:500:3: octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl ';' | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl ';' {...}?)* '@end'
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

            className=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef749); if (state.failed) return struct;
            if ( state.backtracking==0 ) {

              			defineTypeIdentifierInParentScope((className!=null?className.getText():null));
              			struct = mark(new Struct(), getLine(octype));
              			//struct.setCommentBefore(getCommentBefore(octype.getTokenIndex()));
              			struct.setType((octype!=null?octype.getText():null).equals("@interface") ?
              				Struct.Type.ObjCClass :
              				Struct.Type.ObjCProtocol
              			);
              			struct.setTag(new SimpleIdentifier((className!=null?className.getText():null)));
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:511:3: ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==IDENTIFIER||LA15_0==23||LA15_0==25||LA15_0==30||LA15_0==33||LA15_0==36||(LA15_0>=41 && LA15_0<=43)||(LA15_0>=48 && LA15_0<=50)||(LA15_0>=52 && LA15_0<=54)||(LA15_0>=57 && LA15_0<=59)) ) {
                alt15=1;
            }
            else if ( (LA15_0==34) ) {
                int LA15_2 = input.LA(2);

                if ( (LA15_2==IDENTIFIER) ) {
                    int LA15_3 = input.LA(3);

                    if ( (LA15_3==35) ) {
                        int LA15_4 = input.LA(4);

                        if ( (synpred24_ObjCpp()) ) {
                            alt15=1;
                        }
                        else if ( (true) ) {
                            alt15=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return struct;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 15, 4, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA15_3>=STRING && LA15_3<=IDENTIFIER)||LA15_3==29||LA15_3==34||(LA15_3>=52 && LA15_3<=54)||LA15_3==57) ) {
                        alt15=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return struct;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA15_2==34||(LA15_2>=52 && LA15_2<=53)||LA15_2==57) ) {
                    alt15=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return struct;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return struct;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:512:4: ( ':' parentClass= IDENTIFIER )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:512:4: ( ':' parentClass= IDENTIFIER )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==33) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:513:5: ':' parentClass= IDENTIFIER
                            {
                            match(input,33,FOLLOW_33_in_objCClassDef767); if (state.failed) return struct;
                            parentClass=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef771); if (state.failed) return struct;
                            if ( state.backtracking==0 ) {

                              				if ((parentClass!=null?parentClass.getText():null) != null)
                              					struct.addParent(new SimpleIdentifier((parentClass!=null?parentClass.getText():null)));
                              				
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:518:4: '(' categoryName= IDENTIFIER ')'
                    {
                    match(input,34,FOLLOW_34_in_objCClassDef786); if (state.failed) return struct;
                    categoryName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef790); if (state.failed) return struct;
                    match(input,35,FOLLOW_35_in_objCClassDef792); if (state.failed) return struct;
                    if ( state.backtracking==0 ) {

                      				struct.setCategoryName((categoryName!=null?categoryName.getText():null));
                      			
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:522:3: ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==36) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:523:4: '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>'
                    {
                    match(input,36,FOLLOW_36_in_objCClassDef808); if (state.failed) return struct;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:523:8: (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==IDENTIFIER) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:524:5: p1= IDENTIFIER ( ',' px= IDENTIFIER )*
                            {
                            p1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef818); if (state.failed) return struct;
                            if ( state.backtracking==0 ) {
                               struct.addProtocol(new SimpleIdentifier((p1!=null?p1.getText():null))); 
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:525:5: ( ',' px= IDENTIFIER )*
                            loop16:
                            do {
                                int alt16=2;
                                int LA16_0 = input.LA(1);

                                if ( (LA16_0==28) ) {
                                    alt16=1;
                                }


                                switch (alt16) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:526:6: ',' px= IDENTIFIER
                            	    {
                            	    match(input,28,FOLLOW_28_in_objCClassDef833); if (state.failed) return struct;
                            	    px=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef843); if (state.failed) return struct;
                            	    if ( state.backtracking==0 ) {
                            	       struct.addProtocol(new SimpleIdentifier((px!=null?px.getText():null))); 
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

                    match(input,37,FOLLOW_37_in_objCClassDef860); if (state.failed) return struct;

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:531:3: ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl ';' | functionPointerVarDecl ) ) )* '}' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==23) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:532:4: '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl ';' | functionPointerVarDecl ) ) )* '}'
                    {
                    match(input,23,FOLLOW_23_in_objCClassDef874); if (state.failed) return struct;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:533:4: ( '@public' | '@private' | '@protected' | ( (fv= varDecl ';' | functionPointerVarDecl ) ) )*
                    loop20:
                    do {
                        int alt20=5;
                        switch ( input.LA(1) ) {
                        case 38:
                            {
                            alt20=1;
                            }
                            break;
                        case 39:
                            {
                            alt20=2;
                            }
                            break;
                        case 40:
                            {
                            alt20=3;
                            }
                            break;
                        case IDENTIFIER:
                        case 25:
                        case 30:
                        case 34:
                        case 48:
                        case 49:
                        case 50:
                        case 52:
                        case 53:
                        case 54:
                        case 57:
                        case 59:
                            {
                            alt20=4;
                            }
                            break;

                        }

                        switch (alt20) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:534:5: '@public'
                    	    {
                    	    match(input,38,FOLLOW_38_in_objCClassDef886); if (state.failed) return struct;
                    	    if ( state.backtracking==0 ) {
                    	       struct.setNextMemberVisibility(Struct.MemberVisibility.Public); 
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:535:5: '@private'
                    	    {
                    	    match(input,39,FOLLOW_39_in_objCClassDef897); if (state.failed) return struct;
                    	    if ( state.backtracking==0 ) {
                    	       struct.setNextMemberVisibility(Struct.MemberVisibility.Private); 
                    	    }

                    	    }
                    	    break;
                    	case 3 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:536:5: '@protected'
                    	    {
                    	    match(input,40,FOLLOW_40_in_objCClassDef908); if (state.failed) return struct;
                    	    if ( state.backtracking==0 ) {
                    	       struct.setNextMemberVisibility(Struct.MemberVisibility.Protected); 
                    	    }

                    	    }
                    	    break;
                    	case 4 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:537:5: ( (fv= varDecl ';' | functionPointerVarDecl ) )
                    	    {
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:537:5: ( (fv= varDecl ';' | functionPointerVarDecl ) )
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:538:6: (fv= varDecl ';' | functionPointerVarDecl )
                    	    {
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:538:6: (fv= varDecl ';' | functionPointerVarDecl )
                    	    int alt19=2;
                    	    alt19 = dfa19.predict(input);
                    	    switch (alt19) {
                    	        case 1 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:539:7: fv= varDecl ';'
                    	            {
                    	            pushFollow(FOLLOW_varDecl_in_objCClassDef935);
                    	            fv=varDecl();

                    	            state._fsp--;
                    	            if (state.failed) return struct;
                    	            match(input,25,FOLLOW_25_in_objCClassDef937); if (state.failed) return struct;
                    	            if ( state.backtracking==0 ) {

                    	              							struct.addDeclaration(fv);
                    	              						
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:542:7: functionPointerVarDecl
                    	            {
                    	            pushFollow(FOLLOW_functionPointerVarDecl_in_objCClassDef949);
                    	            functionPointerVarDecl9=functionPointerVarDecl();

                    	            state._fsp--;
                    	            if (state.failed) return struct;
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              							struct.addDeclarations(functionPointerVarDecl9); 
                    	              						
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

                    match(input,24,FOLLOW_24_in_objCClassDef976); if (state.failed) return struct;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               struct.setNextMemberVisibility(Struct.MemberVisibility.Public); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:551:3: ( objCMethodDecl | typeDef | vd= varDecl ';' {...}?)*
            loop22:
            do {
                int alt22=4;
                switch ( input.LA(1) ) {
                case 42:
                case 43:
                    {
                    alt22=1;
                    }
                    break;
                case 58:
                    {
                    alt22=2;
                    }
                    break;
                case IDENTIFIER:
                case 25:
                case 30:
                case 34:
                case 48:
                case 49:
                case 50:
                case 52:
                case 53:
                case 54:
                case 57:
                case 59:
                    {
                    alt22=3;
                    }
                    break;

                }

                switch (alt22) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:552:4: objCMethodDecl
            	    {
            	    pushFollow(FOLLOW_objCMethodDecl_in_objCClassDef994);
            	    objCMethodDecl10=objCMethodDecl();

            	    state._fsp--;
            	    if (state.failed) return struct;
            	    if ( state.backtracking==0 ) {
            	       
            	      				struct.addDeclaration(objCMethodDecl10); 
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:555:4: typeDef
            	    {
            	    pushFollow(FOLLOW_typeDef_in_objCClassDef1003);
            	    typeDef11=typeDef();

            	    state._fsp--;
            	    if (state.failed) return struct;
            	    if ( state.backtracking==0 ) {

            	      				struct.addDeclaration(typeDef11); 
            	      			
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:558:4: vd= varDecl ';' {...}?
            	    {
            	    pushFollow(FOLLOW_varDecl_in_objCClassDef1014);
            	    vd=varDecl();

            	    state._fsp--;
            	    if (state.failed) return struct;
            	    match(input,25,FOLLOW_25_in_objCClassDef1016); if (state.failed) return struct;
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
            	    break loop22;
                }
            } while (true);

            match(input,41,FOLLOW_41_in_objCClassDef1029); if (state.failed) return struct;

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


    // $ANTLR start "objCMethodDecl"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:565:1: objCMethodDecl returns [Function function] : tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= mutableTypeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= mutableTypeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';' ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return function; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:566:2: (tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= mutableTypeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= mutableTypeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:566:4: tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= mutableTypeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= mutableTypeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';'
            {
            if ( state.backtracking==0 ) {
               	
              			function = new Function(); 
              			function.setType(Function.Type.ObjCMethod);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:570:6: (tp= '+' | tm= '-' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==42) ) {
                alt23=1;
            }
            else if ( (LA23_0==43) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return function;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:571:4: tp= '+'
                    {
                    tp=(Token)match(input,42,FOLLOW_42_in_objCMethodDecl1063); if (state.failed) return function;
                    if ( state.backtracking==0 ) {
                       
                      				function.addModifiers(Modifier.Static); 
                      				function = mark(function, getLine(tp)); 
                      				function.setCommentBefore(getCommentBefore(tp.getTokenIndex()));
                      			
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:576:4: tm= '-'
                    {
                    tm=(Token)match(input,43,FOLLOW_43_in_objCMethodDecl1075); if (state.failed) return function;
                    if ( state.backtracking==0 ) {

                      				function = mark(function, getLine(tm)); 
                      				function.setCommentBefore(getCommentBefore(tm.getTokenIndex()));
                      			
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:581:3: ( '(' (returnTypeRef= mutableTypeRef )? ')' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==34) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:583:4: '(' (returnTypeRef= mutableTypeRef )? ')'
                    {
                    match(input,34,FOLLOW_34_in_objCMethodDecl1094); if (state.failed) return function;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:584:18: (returnTypeRef= mutableTypeRef )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==IDENTIFIER||LA24_0==30||LA24_0==34||(LA24_0>=48 && LA24_0<=50)||(LA24_0>=52 && LA24_0<=54)||LA24_0==59) ) {
                        alt24=1;
                    }
                    else if ( (LA24_0==35) ) {
                        int LA24_2 = input.LA(2);

                        if ( (synpred38_ObjCpp()) ) {
                            alt24=1;
                        }
                    }
                    switch (alt24) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: returnTypeRef= mutableTypeRef
                            {
                            pushFollow(FOLLOW_mutableTypeRef_in_objCMethodDecl1102);
                            returnTypeRef=mutableTypeRef();

                            state._fsp--;
                            if (state.failed) return function;

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       
                      					function.setValueType(returnTypeRef); 
                      				
                    }
                    match(input,35,FOLLOW_35_in_objCMethodDecl1110); if (state.failed) return function;

                    }
                    break;

            }

            methodName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1121); if (state.failed) return function;
            if ( state.backtracking==0 ) {
               
              			function.setName(new SimpleIdentifier((methodName!=null?methodName.getText():null))); 
              			function.setCommentAfter(getCommentAfterOnSameLine(methodName.getTokenIndex()));
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:593:3: ( ':' '(' argType1= mutableTypeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==33) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:594:4: ':' '(' argType1= mutableTypeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )* ( ',' '...' )?
                    {
                    match(input,33,FOLLOW_33_in_objCMethodDecl1133); if (state.failed) return function;
                    match(input,34,FOLLOW_34_in_objCMethodDecl1135); if (state.failed) return function;
                    pushFollow(FOLLOW_mutableTypeRef_in_objCMethodDecl1139);
                    argType1=mutableTypeRef();

                    state._fsp--;
                    if (state.failed) return function;
                    match(input,35,FOLLOW_35_in_objCMethodDecl1141); if (state.failed) return function;
                    argName1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1145); if (state.failed) return function;
                    if ( state.backtracking==0 ) {

                      				Arg arg = new Arg((argName1!=null?argName1.getText():null), argType1);
                      				arg.setSelector((methodName!=null?methodName.getText():null));
                      				function.addArg(arg);
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:599:4: (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==IDENTIFIER) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:600:5: sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER
                    	    {
                    	    sel=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1160); if (state.failed) return function;
                    	    match(input,33,FOLLOW_33_in_objCMethodDecl1162); if (state.failed) return function;
                    	    match(input,34,FOLLOW_34_in_objCMethodDecl1169); if (state.failed) return function;
                    	    pushFollow(FOLLOW_mutableTypeRef_in_objCMethodDecl1173);
                    	    argType=mutableTypeRef();

                    	    state._fsp--;
                    	    if (state.failed) return function;
                    	    match(input,35,FOLLOW_35_in_objCMethodDecl1175); if (state.failed) return function;
                    	    argName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1184); if (state.failed) return function;
                    	    if ( state.backtracking==0 ) {

                    	      					Arg arg = new Arg((argName!=null?argName.getText():null), argType);
                    	      					arg.setSelector((sel!=null?sel.getText():null));
                    	      					function.addArg(arg);
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:608:4: ( ',' '...' )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==28) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:609:5: ',' '...'
                            {
                            match(input,28,FOLLOW_28_in_objCMethodDecl1203); if (state.failed) return function;
                            match(input,44,FOLLOW_44_in_objCMethodDecl1205); if (state.failed) return function;
                            if ( state.backtracking==0 ) {

                              					function.addArg(Arg.createVarArgs());
                              				
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            match(input,25,FOLLOW_25_in_objCMethodDecl1222); if (state.failed) return function;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, objCMethodDecl_StartIndex); }
        }
        return function;
    }
    // $ANTLR end "objCMethodDecl"


    // $ANTLR start "structBody"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:617:1: structBody returns [Struct struct] : '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration | fv= varDecl ':' bits= DECIMAL_NUMBER ';' )* '}' ;
    public final Struct structBody() throws RecognitionException {
        Struct struct = null;
        int structBody_StartIndex = input.index();
        Token bits=null;
        VariablesDeclaration fv = null;

        ObjCppParser.declaration_return declaration12 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return struct; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:618:2: ( '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration | fv= varDecl ':' bits= DECIMAL_NUMBER ';' )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:619:3: '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration | fv= varDecl ':' bits= DECIMAL_NUMBER ';' )* '}'
            {
            if ( state.backtracking==0 ) {
               
              			struct = new Struct();
              			struct.setForwardDeclaration(false); 
              		
            }
            match(input,23,FOLLOW_23_in_structBody1243); if (state.failed) return struct;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:624:4: ( ( 'public' | 'private' | 'protected' ) ':' | declaration | fv= varDecl ':' bits= DECIMAL_NUMBER ';' )*
            loop30:
            do {
                int alt30=4;
                alt30 = dfa30.predict(input);
                switch (alt30) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:625:5: ( 'public' | 'private' | 'protected' ) ':'
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:625:5: ( 'public' | 'private' | 'protected' )
            	    int alt29=3;
            	    switch ( input.LA(1) ) {
            	    case 45:
            	        {
            	        alt29=1;
            	        }
            	        break;
            	    case 46:
            	        {
            	        alt29=2;
            	        }
            	        break;
            	    case 47:
            	        {
            	        alt29=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return struct;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 29, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt29) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:626:6: 'public'
            	            {
            	            match(input,45,FOLLOW_45_in_structBody1261); if (state.failed) return struct;
            	            if ( state.backtracking==0 ) {
            	               struct.setNextMemberVisibility(Struct.MemberVisibility.Public); 
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:627:6: 'private'
            	            {
            	            match(input,46,FOLLOW_46_in_structBody1273); if (state.failed) return struct;
            	            if ( state.backtracking==0 ) {
            	               struct.setNextMemberVisibility(Struct.MemberVisibility.Private); 
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:628:6: 'protected'
            	            {
            	            match(input,47,FOLLOW_47_in_structBody1285); if (state.failed) return struct;
            	            if ( state.backtracking==0 ) {
            	               struct.setNextMemberVisibility(Struct.MemberVisibility.Protected); 
            	            }

            	            }
            	            break;

            	    }

            	    match(input,33,FOLLOW_33_in_structBody1296); if (state.failed) return struct;

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:630:5: declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_structBody1304);
            	    declaration12=declaration();

            	    state._fsp--;
            	    if (state.failed) return struct;
            	    if ( state.backtracking==0 ) {

            	      					struct.addDeclarations((declaration12!=null?declaration12.declarations:null));
            	      				
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:633:5: fv= varDecl ':' bits= DECIMAL_NUMBER ';'
            	    {
            	    pushFollow(FOLLOW_varDecl_in_structBody1316);
            	    fv=varDecl();

            	    state._fsp--;
            	    if (state.failed) return struct;
            	    match(input,33,FOLLOW_33_in_structBody1318); if (state.failed) return struct;
            	    bits=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_structBody1322); if (state.failed) return struct;
            	    match(input,25,FOLLOW_25_in_structBody1324); if (state.failed) return struct;
            	    if ( state.backtracking==0 ) {
            	       
            	      					if ((bits!=null?bits.getText():null) != null) 
            	      						fv.setBits(Integer.parseInt((bits!=null?bits.getText():null)));
            	      					struct.addDeclaration(fv);
            	      				
            	    }

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            match(input,24,FOLLOW_24_in_structBody1336); if (state.failed) return struct;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, structBody_StartIndex); }
        }
        return struct;
    }
    // $ANTLR end "structBody"


    // $ANTLR start "structCore"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:642:1: structCore returns [Struct struct] : typeToken= ( 'struct' | 'class' | 'union' ) (m1= modifiers (ab= structBody | tag= qualifiedIdentifier ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | ) ) ) ;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return struct; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:666:2: (typeToken= ( 'struct' | 'class' | 'union' ) (m1= modifiers (ab= structBody | tag= qualifiedIdentifier ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | ) ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:667:3: typeToken= ( 'struct' | 'class' | 'union' ) (m1= modifiers (ab= structBody | tag= qualifiedIdentifier ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | ) ) )
            {
            typeToken=(Token)input.LT(1);
            if ( (input.LA(1)>=48 && input.LA(1)<=50) ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return struct;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:668:3: (m1= modifiers (ab= structBody | tag= qualifiedIdentifier ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:669:4: m1= modifiers (ab= structBody | tag= qualifiedIdentifier ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | ) )
            {
            pushFollow(FOLLOW_modifiers_in_structCore1398);
            m1=modifiers();

            state._fsp--;
            if (state.failed) return struct;
            if ( state.backtracking==0 ) {
               modifiers.addAll(m1); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:670:4: (ab= structBody | tag= qualifiedIdentifier ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==23) ) {
                alt34=1;
            }
            else if ( (LA34_0==IDENTIFIER) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return struct;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:671:5: ab= structBody
                    {
                    pushFollow(FOLLOW_structBody_in_structCore1413);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:675:5: tag= qualifiedIdentifier ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | )
                    {
                    pushFollow(FOLLOW_qualifiedIdentifier_in_structCore1425);
                    tag=qualifiedIdentifier();

                    state._fsp--;
                    if (state.failed) return struct;
                    if ( state.backtracking==0 ) {

                      					defineTypeIdentifierInParentScope((tag!=null?tag.identifier:null));
                      				
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:678:5: ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | )
                    int alt33=2;
                    alt33 = dfa33.predict(input);
                    switch (alt33) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:679:6: (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody )
                            {
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:679:6: (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody )
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:680:7: m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody
                            {
                            pushFollow(FOLLOW_modifiers_in_structCore1450);
                            m2=modifiers();

                            state._fsp--;
                            if (state.failed) return struct;
                            if ( state.backtracking==0 ) {
                               modifiers.addAll(m2); 
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:681:7: ( ':' ( 'public' )? parent= qualifiedIdentifier )?
                            int alt32=2;
                            int LA32_0 = input.LA(1);

                            if ( (LA32_0==33) ) {
                                alt32=1;
                            }
                            switch (alt32) {
                                case 1 :
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:682:8: ':' ( 'public' )? parent= qualifiedIdentifier
                                    {
                                    match(input,33,FOLLOW_33_in_structCore1469); if (state.failed) return struct;
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:683:8: ( 'public' )?
                                    int alt31=2;
                                    int LA31_0 = input.LA(1);

                                    if ( (LA31_0==45) ) {
                                        alt31=1;
                                    }
                                    switch (alt31) {
                                        case 1 :
                                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: 'public'
                                            {
                                            match(input,45,FOLLOW_45_in_structCore1478); if (state.failed) return struct;

                                            }
                                            break;

                                    }

                                    pushFollow(FOLLOW_qualifiedIdentifier_in_structCore1490);
                                    parent=qualifiedIdentifier();

                                    state._fsp--;
                                    if (state.failed) return struct;

                                    }
                                    break;

                            }

                            pushFollow(FOLLOW_structBody_in_structCore1510);
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
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:692:10: 
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
            if ( state.backtracking>0 ) { memoize(input, 13, structCore_StartIndex); }
            Symbols_stack.pop();

        }
        return struct;
    }
    // $ANTLR end "structCore"


    // $ANTLR start "anyOp"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:703:1: anyOp returns [java.lang.Enum<?> op] : ( binaryOp | unaryOp | assignmentOp );
    public final java.lang.Enum<?> anyOp() throws RecognitionException {
        java.lang.Enum<?> op = null;
        int anyOp_StartIndex = input.index();
        Expression.BinaryOperator binaryOp13 = null;

        Expression.UnaryOperator unaryOp14 = null;

        ObjCppParser.assignmentOp_return assignmentOp15 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return op; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:704:2: ( binaryOp | unaryOp | assignmentOp )
            int alt35=3;
            switch ( input.LA(1) ) {
            case 43:
            case 52:
            case 53:
                {
                int LA35_1 = input.LA(2);

                if ( (synpred54_ObjCpp()) ) {
                    alt35=1;
                }
                else if ( (synpred55_ObjCpp()) ) {
                    alt35=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return op;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 1, input);

                    throw nvae;
                }
                }
                break;
            case 36:
            case 37:
            case 42:
            case 57:
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
                {
                alt35=1;
                }
                break;
            case 73:
            case 89:
            case 90:
            case 91:
                {
                alt35=2;
                }
                break;
            case 29:
            case 76:
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
                {
                alt35=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return op;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:704:4: binaryOp
                    {
                    pushFollow(FOLLOW_binaryOp_in_anyOp1558);
                    binaryOp13=binaryOp();

                    state._fsp--;
                    if (state.failed) return op;
                    if ( state.backtracking==0 ) {
                       op = binaryOp13; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:705:3: unaryOp
                    {
                    pushFollow(FOLLOW_unaryOp_in_anyOp1567);
                    unaryOp14=unaryOp();

                    state._fsp--;
                    if (state.failed) return op;
                    if ( state.backtracking==0 ) {
                       op = unaryOp14; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:706:3: assignmentOp
                    {
                    pushFollow(FOLLOW_assignmentOp_in_anyOp1576);
                    assignmentOp15=assignmentOp();

                    state._fsp--;
                    if (state.failed) return op;
                    if ( state.backtracking==0 ) {
                       op = (assignmentOp15!=null?assignmentOp15.op:null); 
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
            if ( state.backtracking>0 ) { memoize(input, 14, anyOp_StartIndex); }
        }
        return op;
    }
    // $ANTLR end "anyOp"

    public static class functionDeclaration_return extends ParserRuleReturnScope {
        public Function function;
    };

    // $ANTLR start "functionDeclaration"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:710:1: functionDeclaration returns [Function function] : preMods1= modifiers (returnTypeRef= mutableTypeRef )? preMods2= modifiers name= qualifiedCppFunctionName argList postMods= modifiers ( ':' i1= constructorInitializer ( ',' ix= constructorInitializer )* )? ( ';' | statementsBlock ) ;
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

        ObjCppParser.argList_return argList16 = null;

        Block statementsBlock17 = null;



        	((Symbols_scope)Symbols_stack.peek()).typeIdentifiers = new HashSet<String>();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:715:2: (preMods1= modifiers (returnTypeRef= mutableTypeRef )? preMods2= modifiers name= qualifiedCppFunctionName argList postMods= modifiers ( ':' i1= constructorInitializer ( ',' ix= constructorInitializer )* )? ( ';' | statementsBlock ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:715:4: preMods1= modifiers (returnTypeRef= mutableTypeRef )? preMods2= modifiers name= qualifiedCppFunctionName argList postMods= modifiers ( ':' i1= constructorInitializer ( ',' ix= constructorInitializer )* )? ( ';' | statementsBlock )
            {
            if ( state.backtracking==0 ) {
               	
              			retval.function = mark(new Function(), -1);
              			retval.function.setType(Function.Type.CFunction);
              		
            }
            pushFollow(FOLLOW_modifiers_in_functionDeclaration1611);
            preMods1=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               retval.function.addModifiers(preMods1); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:720:16: (returnTypeRef= mutableTypeRef )?
            int alt36=2;
            switch ( input.LA(1) ) {
                case IDENTIFIER:
                    {
                    int LA36_1 = input.LA(2);

                    if ( (((synpred56_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred56_ObjCpp()&&( next("__pragma") ))||synpred56_ObjCpp()||(synpred56_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred56_ObjCpp()&&( next("extern") ))||(synpred56_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||(synpred56_ObjCpp()&&( next("__success") )))) ) {
                        alt36=1;
                    }
                    }
                    break;
                case 30:
                case 34:
                case 48:
                case 49:
                case 50:
                case 52:
                case 53:
                case 54:
                case 59:
                    {
                    alt36=1;
                    }
                    break;
                case 73:
                    {
                    int LA36_3 = input.LA(2);

                    if ( (synpred56_ObjCpp()) ) {
                        alt36=1;
                    }
                    }
                    break;
            }

            switch (alt36) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: returnTypeRef= mutableTypeRef
                    {
                    pushFollow(FOLLOW_mutableTypeRef_in_functionDeclaration1619);
                    returnTypeRef=mutableTypeRef();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               
              			retval.function.setValueType(returnTypeRef); 
              		
            }
            pushFollow(FOLLOW_modifiers_in_functionDeclaration1628);
            preMods2=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               retval.function.addModifiers(preMods2); 
            }
            pushFollow(FOLLOW_qualifiedCppFunctionName_in_functionDeclaration1636);
            name=qualifiedCppFunctionName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {

              			retval.function.setName(name); 
              			mark(retval.function, getLine(((Token)retval.start)));
              			//retval.function.setElementFile($functionName.file);
              			//retval.function.setElementLine($functionName.line);
              		
            }
            pushFollow(FOLLOW_argList_in_functionDeclaration1642);
            argList16=argList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {

              			retval.function.setArgs((argList16!=null?argList16.args:null));
              		
            }
            pushFollow(FOLLOW_modifiers_in_functionDeclaration1650);
            postMods=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               retval.function.addModifiers(postMods); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:734:3: ( ':' i1= constructorInitializer ( ',' ix= constructorInitializer )* )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==33) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:735:4: ':' i1= constructorInitializer ( ',' ix= constructorInitializer )*
                    {
                    match(input,33,FOLLOW_33_in_functionDeclaration1661); if (state.failed) return retval;
                    pushFollow(FOLLOW_constructorInitializer_in_functionDeclaration1668);
                    i1=constructorInitializer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.function.addInitializer(i1); 
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:737:4: ( ',' ix= constructorInitializer )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==28) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:738:5: ',' ix= constructorInitializer
                    	    {
                    	    match(input,28,FOLLOW_28_in_functionDeclaration1681); if (state.failed) return retval;
                    	    pushFollow(FOLLOW_constructorInitializer_in_functionDeclaration1685);
                    	    ix=constructorInitializer();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	       retval.function.addInitializer(ix); 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);


                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:741:3: ( ';' | statementsBlock )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==25) ) {
                alt39=1;
            }
            else if ( (LA39_0==23) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:742:4: ';'
                    {
                    match(input,25,FOLLOW_25_in_functionDeclaration1708); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:743:4: statementsBlock
                    {
                    pushFollow(FOLLOW_statementsBlock_in_functionDeclaration1715);
                    statementsBlock17=statementsBlock();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      				retval.function.setBody(statementsBlock17);
                      			
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
            if ( state.backtracking>0 ) { memoize(input, 15, functionDeclaration_StartIndex); }
            Symbols_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "functionDeclaration"


    // $ANTLR start "constructorInitializer"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:749:1: constructorInitializer returns [FunctionCall init] : qn= qualifiedCppFunctionName '(' (el= topLevelExprList )? ')' ;
    public final FunctionCall constructorInitializer() throws RecognitionException {
        FunctionCall init = null;
        int constructorInitializer_StartIndex = input.index();
        Identifier qn = null;

        List<Expression> el = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return init; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:750:2: (qn= qualifiedCppFunctionName '(' (el= topLevelExprList )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:750:4: qn= qualifiedCppFunctionName '(' (el= topLevelExprList )? ')'
            {
            pushFollow(FOLLOW_qualifiedCppFunctionName_in_constructorInitializer1738);
            qn=qualifiedCppFunctionName();

            state._fsp--;
            if (state.failed) return init;
            if ( state.backtracking==0 ) {

              			init = new FunctionCall(new TypeRefExpression(new SimpleTypeRef(qn)));
              		
            }
            match(input,34,FOLLOW_34_in_constructorInitializer1746); if (state.failed) return init;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:753:7: (el= topLevelExprList )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=DECIMAL_NUMBER && LA40_0<=FLOAT_NUMBER)||LA40_0==31||LA40_0==34||(LA40_0>=42 && LA40_0<=43)||(LA40_0>=52 && LA40_0<=54)||(LA40_0>=73 && LA40_0<=75)||(LA40_0>=88 && LA40_0<=91)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:754:4: el= topLevelExprList
                    {
                    pushFollow(FOLLOW_topLevelExprList_in_constructorInitializer1755);
                    el=topLevelExprList();

                    state._fsp--;
                    if (state.failed) return init;
                    if ( state.backtracking==0 ) {
                       init.addArguments(el); 
                    }

                    }
                    break;

            }

            match(input,35,FOLLOW_35_in_constructorInitializer1764); if (state.failed) return init;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, constructorInitializer_StartIndex); }
        }
        return init;
    }
    // $ANTLR end "constructorInitializer"


    // $ANTLR start "modifiers"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:758:1: modifiers returns [List<Modifier> modifiers] : ( modifier )* ;
    public final List<Modifier> modifiers() throws RecognitionException {
        List<Modifier> modifiers = null;
        int modifiers_StartIndex = input.index();
        ObjCppParser.modifier_return modifier18 = null;


         modifiers = new ArrayList<Modifier>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return modifiers; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:760:2: ( ( modifier )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:760:5: ( modifier )*
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:760:5: ( modifier )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==IDENTIFIER) ) {
                    int LA41_2 = input.LA(2);

                    if ( (((synpred61_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred61_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||(synpred61_ObjCpp()&&( next("__success") ))||(synpred61_ObjCpp()&&( next("__pragma") ))||(synpred61_ObjCpp()&&( next("extern") ))||(synpred61_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) )))) ) {
                        alt41=1;
                    }


                }


                switch (alt41) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:760:7: modifier
            	    {
            	    pushFollow(FOLLOW_modifier_in_modifiers1788);
            	    modifier18=modifier();

            	    state._fsp--;
            	    if (state.failed) return modifiers;
            	    if ( state.backtracking==0 ) {
            	       modifiers.addAll((modifier18!=null?modifier18.modifiers:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, modifiers_StartIndex); }
        }
        return modifiers;
    }
    // $ANTLR end "modifiers"


    // $ANTLR start "pragmaContent"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:763:1: pragmaContent : IDENTIFIER '(' ( IDENTIFIER | constant | ',' | ':' | '(' ( IDENTIFIER | constant | ',' | ':' )* ')' )* ')' ( ';' )? ;
    public final void pragmaContent() throws RecognitionException {
        int pragmaContent_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return ; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:763:15: ( IDENTIFIER '(' ( IDENTIFIER | constant | ',' | ':' | '(' ( IDENTIFIER | constant | ',' | ':' )* ')' )* ')' ( ';' )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:766:4: IDENTIFIER '(' ( IDENTIFIER | constant | ',' | ':' | '(' ( IDENTIFIER | constant | ',' | ':' )* ')' )* ')' ( ';' )?
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_pragmaContent1814); if (state.failed) return ;
            match(input,34,FOLLOW_34_in_pragmaContent1816); if (state.failed) return ;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:5: ( IDENTIFIER | constant | ',' | ':' | '(' ( IDENTIFIER | constant | ',' | ':' )* ')' )*
            loop43:
            do {
                int alt43=6;
                switch ( input.LA(1) ) {
                case IDENTIFIER:
                    {
                    alt43=1;
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
                    alt43=2;
                    }
                    break;
                case 28:
                    {
                    alt43=3;
                    }
                    break;
                case 33:
                    {
                    alt43=4;
                    }
                    break;
                case 34:
                    {
                    alt43=5;
                    }
                    break;

                }

                switch (alt43) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:6: IDENTIFIER
            	    {
            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_pragmaContent1823); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:19: constant
            	    {
            	    pushFollow(FOLLOW_constant_in_pragmaContent1827);
            	    constant();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;
            	case 3 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:30: ','
            	    {
            	    match(input,28,FOLLOW_28_in_pragmaContent1831); if (state.failed) return ;

            	    }
            	    break;
            	case 4 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:36: ':'
            	    {
            	    match(input,33,FOLLOW_33_in_pragmaContent1835); if (state.failed) return ;

            	    }
            	    break;
            	case 5 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:42: '(' ( IDENTIFIER | constant | ',' | ':' )* ')'
            	    {
            	    match(input,34,FOLLOW_34_in_pragmaContent1839); if (state.failed) return ;
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:46: ( IDENTIFIER | constant | ',' | ':' )*
            	    loop42:
            	    do {
            	        int alt42=5;
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
            	        case 42:
            	        case 43:
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

            	        }

            	        switch (alt42) {
            	    	case 1 :
            	    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:47: IDENTIFIER
            	    	    {
            	    	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_pragmaContent1842); if (state.failed) return ;

            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:60: constant
            	    	    {
            	    	    pushFollow(FOLLOW_constant_in_pragmaContent1846);
            	    	    constant();

            	    	    state._fsp--;
            	    	    if (state.failed) return ;

            	    	    }
            	    	    break;
            	    	case 3 :
            	    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:71: ','
            	    	    {
            	    	    match(input,28,FOLLOW_28_in_pragmaContent1850); if (state.failed) return ;

            	    	    }
            	    	    break;
            	    	case 4 :
            	    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:77: ':'
            	    	    {
            	    	    match(input,33,FOLLOW_33_in_pragmaContent1854); if (state.failed) return ;

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop42;
            	        }
            	    } while (true);

            	    match(input,35,FOLLOW_35_in_pragmaContent1858); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            match(input,35,FOLLOW_35_in_pragmaContent1865); if (state.failed) return ;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:769:4: ( ';' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==25) ) {
                int LA44_1 = input.LA(2);

                if ( (synpred71_ObjCpp()) ) {
                    alt44=1;
                }
            }
            switch (alt44) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: ';'
                    {
                    match(input,25,FOLLOW_25_in_pragmaContent1870); if (state.failed) return ;

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
            if ( state.backtracking>0 ) { memoize(input, 18, pragmaContent_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "pragmaContent"

    public static class modifier_return extends ParserRuleReturnScope {
        public List<Modifier> modifiers;
        public String asmName;
    };

    // $ANTLR start "modifier"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:773:1: modifier returns [List<Modifier> modifiers, String asmName] : ({...}? => pragmaContent | {...}? => IDENTIFIER ex= STRING | {...}?m= IDENTIFIER | {...}? => IDENTIFIER '(' 'return' binaryOp expression ')' | {...}? => IDENTIFIER '(' expression ')' | {...}? => IDENTIFIER '(' ( (an= STRING )* | extendedModifiers ) ')' );
    public final ObjCppParser.modifier_return modifier() throws RecognitionException {
        ObjCppParser.modifier_return retval = new ObjCppParser.modifier_return();
        retval.start = input.LT(1);
        int modifier_StartIndex = input.index();
        Token ex=null;
        Token m=null;
        Token an=null;
        List<Modifier> extendedModifiers19 = null;


         retval.modifiers = new ArrayList<Modifier>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:775:2: ({...}? => pragmaContent | {...}? => IDENTIFIER ex= STRING | {...}?m= IDENTIFIER | {...}? => IDENTIFIER '(' 'return' binaryOp expression ')' | {...}? => IDENTIFIER '(' expression ')' | {...}? => IDENTIFIER '(' ( (an= STRING )* | extendedModifiers ) ')' )
            int alt47=6;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==IDENTIFIER) ) {
                int LA47_1 = input.LA(2);

                if ( ((synpred72_ObjCpp()&&( next("__pragma") ))) ) {
                    alt47=1;
                }
                else if ( ((synpred73_ObjCpp()&&( next("extern") ))) ) {
                    alt47=2;
                }
                else if ( ((synpred74_ObjCpp()&&( Modifier.parseModifier(next()) != null ))) ) {
                    alt47=3;
                }
                else if ( ((synpred75_ObjCpp()&&( next("__success") ))) ) {
                    alt47=4;
                }
                else if ( ((synpred76_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))) ) {
                    alt47=5;
                }
                else if ( (( next("__declspec", "__attribute__", "__asm") )) ) {
                    alt47=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:777:3: {...}? => pragmaContent
                    {
                    if ( !(( next("__pragma") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "modifier", " next(\"__pragma\") ");
                    }
                    pushFollow(FOLLOW_pragmaContent_in_modifier1902);
                    pragmaContent();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:778:3: {...}? => IDENTIFIER ex= STRING
                    {
                    if ( !(( next("extern") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "modifier", " next(\"extern\") ");
                    }
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier1912); if (state.failed) return retval;
                    ex=(Token)match(input,STRING,FOLLOW_STRING_in_modifier1916); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      			retval.modifiers.add(Modifier.Extern); // TODO
                      		
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:781:3: {...}?m= IDENTIFIER
                    {
                    if ( !(( Modifier.parseModifier(next()) != null )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "modifier", " Modifier.parseModifier(next()) != null ");
                    }
                    m=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier1928); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      			retval.modifiers.add(Modifier.parseModifier((m!=null?m.getText():null)));
                      		
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:784:3: {...}? => IDENTIFIER '(' 'return' binaryOp expression ')'
                    {
                    if ( !(( next("__success") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "modifier", " next(\"__success\") ");
                    }
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier1941); if (state.failed) return retval;
                    match(input,34,FOLLOW_34_in_modifier1943); if (state.failed) return retval;
                    match(input,51,FOLLOW_51_in_modifier1945); if (state.failed) return retval;
                    pushFollow(FOLLOW_binaryOp_in_modifier1947);
                    binaryOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_modifier1949);
                    expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    match(input,35,FOLLOW_35_in_modifier1952); if (state.failed) return retval;

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:788:3: {...}? => IDENTIFIER '(' expression ')'
                    {
                    if ( !(( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "modifier", " next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ");
                    }
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier1969); if (state.failed) return retval;
                    match(input,34,FOLLOW_34_in_modifier1971); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_modifier1973);
                    expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    match(input,35,FOLLOW_35_in_modifier1975); if (state.failed) return retval;

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:791:3: {...}? => IDENTIFIER '(' ( (an= STRING )* | extendedModifiers ) ')'
                    {
                    if ( !(( next("__declspec", "__attribute__", "__asm") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "modifier", " next(\"__declspec\", \"__attribute__\", \"__asm\") ");
                    }
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier1989); if (state.failed) return retval;
                    match(input,34,FOLLOW_34_in_modifier1993); if (state.failed) return retval;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:793:7: ( (an= STRING )* | extendedModifiers )
                    int alt46=2;
                    switch ( input.LA(1) ) {
                    case STRING:
                        {
                        alt46=1;
                        }
                        break;
                    case 35:
                        {
                        int LA46_2 = input.LA(2);

                        if ( (synpred78_ObjCpp()) ) {
                            alt46=1;
                        }
                        else if ( (true) ) {
                            alt46=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 46, 2, input);

                            throw nvae;
                        }
                        }
                        break;
                    case IDENTIFIER:
                        {
                        alt46=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 0, input);

                        throw nvae;
                    }

                    switch (alt46) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:794:4: (an= STRING )*
                            {
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:794:4: (an= STRING )*
                            loop45:
                            do {
                                int alt45=2;
                                int LA45_0 = input.LA(1);

                                if ( (LA45_0==STRING) ) {
                                    alt45=1;
                                }


                                switch (alt45) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:794:6: an= STRING
                            	    {
                            	    an=(Token)match(input,STRING,FOLLOW_STRING_in_modifier2004); if (state.failed) return retval;
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
                            	    break loop45;
                                }
                            } while (true);


                            }
                            break;
                        case 2 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:801:4: extendedModifiers
                            {
                            pushFollow(FOLLOW_extendedModifiers_in_modifier2016);
                            extendedModifiers19=extendedModifiers();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) {

                              				retval.modifiers.addAll(extendedModifiers19);
                              			
                            }

                            }
                            break;

                    }

                    match(input,35,FOLLOW_35_in_modifier2024); if (state.failed) return retval;

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
            if ( state.backtracking>0 ) { memoize(input, 19, modifier_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "modifier"


    // $ANTLR start "extendedModifiers"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:808:1: extendedModifiers returns [List<Modifier> modifiers] : ({...}?m= IDENTIFIER () )* ;
    public final List<Modifier> extendedModifiers() throws RecognitionException {
        List<Modifier> modifiers = null;
        int extendedModifiers_StartIndex = input.index();
        Token m=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return modifiers; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:809:2: ( ({...}?m= IDENTIFIER () )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:809:4: ({...}?m= IDENTIFIER () )*
            {
            if ( state.backtracking==0 ) {
               modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:810:3: ({...}?m= IDENTIFIER () )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==IDENTIFIER) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:811:4: {...}?m= IDENTIFIER ()
            	    {
            	    if ( !(( next(Modifier.Kind.Extended) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return modifiers;}
            	        throw new FailedPredicateException(input, "extendedModifiers", " next(Modifier.Kind.Extended) ");
            	    }
            	    m=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_extendedModifiers2053); if (state.failed) return modifiers;
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:812:4: ()
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:813:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					modifiers.add(Modifier.parseModifier((m!=null?m.getText():null)));
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, extendedModifiers_StartIndex); }
        }
        return modifiers;
    }
    // $ANTLR end "extendedModifiers"

    public static class argDef_return extends ParserRuleReturnScope {
        public Arg arg;
    };

    // $ANTLR start "argDef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:823:1: argDef returns [Arg arg] : ( (tr= mutableTypeRef ) ( ( declarator )? ) ( '=' dv= topLevelExpr )? | '...' );
    public final ObjCppParser.argDef_return argDef() throws RecognitionException {
        ObjCppParser.argDef_return retval = new ObjCppParser.argDef_return();
        retval.start = input.LT(1);
        int argDef_StartIndex = input.index();
        TypeRef tr = null;

        ObjCppParser.topLevelExpr_return dv = null;

        Declarator declarator20 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:824:2: ( (tr= mutableTypeRef ) ( ( declarator )? ) ( '=' dv= topLevelExpr )? | '...' )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==EOF||LA51_0==IDENTIFIER||(LA51_0>=28 && LA51_0<=30)||(LA51_0>=34 && LA51_0<=35)||LA51_0==37||(LA51_0>=48 && LA51_0<=50)||(LA51_0>=52 && LA51_0<=54)||LA51_0==57||LA51_0==59) ) {
                alt51=1;
            }
            else if ( (LA51_0==44) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:824:4: (tr= mutableTypeRef ) ( ( declarator )? ) ( '=' dv= topLevelExpr )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:824:4: (tr= mutableTypeRef )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:825:4: tr= mutableTypeRef
                    {
                    pushFollow(FOLLOW_mutableTypeRef_in_argDef2096);
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

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:835:3: ( ( declarator )? )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:836:4: ( declarator )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:836:4: ( declarator )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==IDENTIFIER||LA49_0==34||(LA49_0>=52 && LA49_0<=53)||LA49_0==57) ) {
                        alt49=1;
                    }
                    switch (alt49) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: declarator
                            {
                            pushFollow(FOLLOW_declarator_in_argDef2111);
                            declarator20=declarator();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       
                      				if (retval.arg != null) {
                      					if (declarator20 != null)
                      						retval.arg.setDeclarator(declarator20); 
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

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:850:3: ( '=' dv= topLevelExpr )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==29) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:850:4: '=' dv= topLevelExpr
                            {
                            match(input,29,FOLLOW_29_in_argDef2123); if (state.failed) return retval;
                            pushFollow(FOLLOW_topLevelExpr_in_argDef2127);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:855:3: '...'
                    {
                    match(input,44,FOLLOW_44_in_argDef2141); if (state.failed) return retval;
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
            if ( state.backtracking>0 ) { memoize(input, 21, argDef_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "argDef"


    // $ANTLR start "typeMutator"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:860:1: typeMutator returns [TypeMutator mutator] : (t= ( '*' | '&' ) | '[' ']' );
    public final TypeMutator typeMutator() throws RecognitionException {
        TypeMutator mutator = null;
        int typeMutator_StartIndex = input.index();
        Token t=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return mutator; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:861:2: (t= ( '*' | '&' ) | '[' ']' )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0>=52 && LA52_0<=53)) ) {
                alt52=1;
            }
            else if ( (LA52_0==54) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return mutator;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:862:3: t= ( '*' | '&' )
                    {
                    t=(Token)input.LT(1);
                    if ( (input.LA(1)>=52 && input.LA(1)<=53) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:865:3: '[' ']'
                    {
                    match(input,54,FOLLOW_54_in_typeMutator2177); if (state.failed) return mutator;
                    match(input,55,FOLLOW_55_in_typeMutator2179); if (state.failed) return mutator;
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
            if ( state.backtracking>0 ) { memoize(input, 22, typeMutator_StartIndex); }
        }
        return mutator;
    }
    // $ANTLR end "typeMutator"


    // $ANTLR start "arrayTypeMutator"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:868:1: arrayTypeMutator returns [TypeMutator mutator] : '[' expression ']' ;
    public final TypeMutator arrayTypeMutator() throws RecognitionException {
        TypeMutator mutator = null;
        int arrayTypeMutator_StartIndex = input.index();
        Expression expression21 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return mutator; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:869:2: ( '[' expression ']' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:869:4: '[' expression ']'
            {
            match(input,54,FOLLOW_54_in_arrayTypeMutator2197); if (state.failed) return mutator;
            pushFollow(FOLLOW_expression_in_arrayTypeMutator2203);
            expression21=expression();

            state._fsp--;
            if (state.failed) return mutator;
            if ( state.backtracking==0 ) {

              				mutator = TypeMutator.array(expression21); 
              			
            }
            match(input,55,FOLLOW_55_in_arrayTypeMutator2212); if (state.failed) return mutator;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, arrayTypeMutator_StartIndex); }
        }
        return mutator;
    }
    // $ANTLR end "arrayTypeMutator"


    // $ANTLR start "templateDef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:876:1: templateDef : 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' declaration ;
    public final void templateDef() throws RecognitionException {
        IsTypeDef_stack.push(new IsTypeDef_scope());

        int templateDef_StartIndex = input.index();

        	((IsTypeDef_scope)IsTypeDef_stack.peek()).isTypeDef = true;
        	((Symbols_scope)Symbols_stack.peek()).typeIdentifiers = new HashSet<String>();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return ; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:883:2: ( 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' declaration )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:883:4: 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' declaration
            {
            match(input,56,FOLLOW_56_in_templateDef2240); if (state.failed) return ;
            match(input,36,FOLLOW_36_in_templateDef2242); if (state.failed) return ;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:883:19: ( templateArgDecl ( ',' templateArgDecl )* )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==IDENTIFIER||(LA54_0>=28 && LA54_0<=30)||LA54_0==34||LA54_0==44||(LA54_0>=48 && LA54_0<=50)||(LA54_0>=52 && LA54_0<=54)||LA54_0==57||LA54_0==59) ) {
                alt54=1;
            }
            else if ( (LA54_0==37) ) {
                int LA54_2 = input.LA(2);

                if ( (synpred86_ObjCpp()) ) {
                    alt54=1;
                }
            }
            switch (alt54) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:883:20: templateArgDecl ( ',' templateArgDecl )*
                    {
                    pushFollow(FOLLOW_templateArgDecl_in_templateDef2245);
                    templateArgDecl();

                    state._fsp--;
                    if (state.failed) return ;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:883:36: ( ',' templateArgDecl )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==28) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:883:37: ',' templateArgDecl
                    	    {
                    	    match(input,28,FOLLOW_28_in_templateDef2248); if (state.failed) return ;
                    	    pushFollow(FOLLOW_templateArgDecl_in_templateDef2250);
                    	    templateArgDecl();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,37,FOLLOW_37_in_templateDef2257); if (state.failed) return ;
            pushFollow(FOLLOW_declaration_in_templateDef2261);
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
            if ( state.backtracking>0 ) { memoize(input, 24, templateDef_StartIndex); }
            IsTypeDef_stack.pop();

        }
        return ;
    }
    // $ANTLR end "templateDef"


    // $ANTLR start "templateArgDecl"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:888:1: templateArgDecl : argDef ;
    public final void templateArgDecl() throws RecognitionException {
        int templateArgDecl_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return ; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:889:2: ( argDef )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:889:4: argDef
            {
            pushFollow(FOLLOW_argDef_in_templateArgDecl2276);
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
            if ( state.backtracking>0 ) { memoize(input, 25, templateArgDecl_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "templateArgDecl"


    // $ANTLR start "functionSignatureSuffix"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:892:1: functionSignatureSuffix returns [FunctionSignature signature] : tk= '(' m1= modifiers '*' m2= modifiers ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' ;
    public final FunctionSignature functionSignatureSuffix() throws RecognitionException {
        FunctionSignature signature = null;
        int functionSignatureSuffix_StartIndex = input.index();
        Token tk=null;
        Token IDENTIFIER22=null;
        List<Modifier> m1 = null;

        List<Modifier> m2 = null;

        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return signature; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:893:2: (tk= '(' m1= modifiers '*' m2= modifiers ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:893:4: tk= '(' m1= modifiers '*' m2= modifiers ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')'
            {
            tk=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffix2296); if (state.failed) return signature;
            pushFollow(FOLLOW_modifiers_in_functionSignatureSuffix2300);
            m1=modifiers();

            state._fsp--;
            if (state.failed) return signature;
            match(input,52,FOLLOW_52_in_functionSignatureSuffix2302); if (state.failed) return signature;
            pushFollow(FOLLOW_modifiers_in_functionSignatureSuffix2306);
            m2=modifiers();

            state._fsp--;
            if (state.failed) return signature;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:893:41: ( IDENTIFIER )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==IDENTIFIER) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: IDENTIFIER
                    {
                    IDENTIFIER22=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionSignatureSuffix2308); if (state.failed) return signature;

                    }
                    break;

            }

            match(input,35,FOLLOW_35_in_functionSignatureSuffix2311); if (state.failed) return signature;
            if ( state.backtracking==0 ) {
               
              			signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, new SimpleIdentifier((IDENTIFIER22!=null?IDENTIFIER22.getText():null)), null)), getLine(tk));
              			signature.getFunction().setType(Function.Type.CFunction);
              			signature.getFunction().addModifiers(m1);
              			signature.getFunction().addModifiers(m2);
              		
            }
            match(input,34,FOLLOW_34_in_functionSignatureSuffix2317); if (state.failed) return signature;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:899:7: (a1= argDef ( ',' ax= argDef )* )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==IDENTIFIER||(LA57_0>=28 && LA57_0<=30)||LA57_0==34||LA57_0==44||(LA57_0>=48 && LA57_0<=50)||(LA57_0>=52 && LA57_0<=54)||LA57_0==57||LA57_0==59) ) {
                alt57=1;
            }
            else if ( (LA57_0==35) ) {
                int LA57_2 = input.LA(2);

                if ( (synpred89_ObjCpp()) ) {
                    alt57=1;
                }
            }
            switch (alt57) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:900:4: a1= argDef ( ',' ax= argDef )*
                    {
                    pushFollow(FOLLOW_argDef_in_functionSignatureSuffix2326);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return signature;
                    if ( state.backtracking==0 ) {
                       
                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					((FunctionSignature)signature).getFunction().addArg((a1!=null?a1.arg:null)); 
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:904:4: ( ',' ax= argDef )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==28) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:905:5: ',' ax= argDef
                    	    {
                    	    match(input,28,FOLLOW_28_in_functionSignatureSuffix2339); if (state.failed) return signature;
                    	    pushFollow(FOLLOW_argDef_in_functionSignatureSuffix2348);
                    	    ax=argDef();

                    	    state._fsp--;
                    	    if (state.failed) return signature;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      					((FunctionSignature)signature).getFunction().addArg((ax!=null?ax.arg:null)); 
                    	      				
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

            match(input,35,FOLLOW_35_in_functionSignatureSuffix2363); if (state.failed) return signature;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 26, functionSignatureSuffix_StartIndex); }
        }
        return signature;
    }
    // $ANTLR end "functionSignatureSuffix"


    // $ANTLR start "functionSignatureSuffixNoName"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:913:1: functionSignatureSuffixNoName returns [FunctionSignature signature] : tk= '(' modifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' ;
    public final FunctionSignature functionSignatureSuffixNoName() throws RecognitionException {
        FunctionSignature signature = null;
        int functionSignatureSuffixNoName_StartIndex = input.index();
        Token tk=null;
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;

        List<Modifier> modifiers23 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return signature; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:914:2: (tk= '(' modifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:914:4: tk= '(' modifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')'
            {
            tk=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffixNoName2380); if (state.failed) return signature;
            pushFollow(FOLLOW_modifiers_in_functionSignatureSuffixNoName2382);
            modifiers23=modifiers();

            state._fsp--;
            if (state.failed) return signature;
            match(input,52,FOLLOW_52_in_functionSignatureSuffixNoName2384); if (state.failed) return signature;
            match(input,35,FOLLOW_35_in_functionSignatureSuffixNoName2386); if (state.failed) return signature;
            if ( state.backtracking==0 ) {
               
              			signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, null, null)), getLine(tk));
              			signature.getFunction().setType(Function.Type.CFunction);
              			signature.getFunction().addModifiers(modifiers23);
              		
            }
            match(input,34,FOLLOW_34_in_functionSignatureSuffixNoName2392); if (state.failed) return signature;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:919:7: (a1= argDef ( ',' ax= argDef )* )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==IDENTIFIER||(LA59_0>=28 && LA59_0<=30)||LA59_0==34||LA59_0==44||(LA59_0>=48 && LA59_0<=50)||(LA59_0>=52 && LA59_0<=54)||LA59_0==57||LA59_0==59) ) {
                alt59=1;
            }
            else if ( (LA59_0==35) ) {
                int LA59_2 = input.LA(2);

                if ( (synpred91_ObjCpp()) ) {
                    alt59=1;
                }
            }
            switch (alt59) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:920:4: a1= argDef ( ',' ax= argDef )*
                    {
                    pushFollow(FOLLOW_argDef_in_functionSignatureSuffixNoName2401);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return signature;
                    if ( state.backtracking==0 ) {
                       
                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					((FunctionSignature)signature).getFunction().addArg((a1!=null?a1.arg:null)); 
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:924:4: ( ',' ax= argDef )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==28) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:925:5: ',' ax= argDef
                    	    {
                    	    match(input,28,FOLLOW_28_in_functionSignatureSuffixNoName2414); if (state.failed) return signature;
                    	    pushFollow(FOLLOW_argDef_in_functionSignatureSuffixNoName2423);
                    	    ax=argDef();

                    	    state._fsp--;
                    	    if (state.failed) return signature;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      					((FunctionSignature)signature).getFunction().addArg((ax!=null?ax.arg:null)); 
                    	      				
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

            match(input,35,FOLLOW_35_in_functionSignatureSuffixNoName2438); if (state.failed) return signature;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, functionSignatureSuffixNoName_StartIndex); }
        }
        return signature;
    }
    // $ANTLR end "functionSignatureSuffixNoName"


    // $ANTLR start "mutableTypeRef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:933:1: mutableTypeRef returns [TypeRef type] : ( typeRefCore ) ( (m1= typeMutator ) | (f1= functionSignatureSuffix ) )* ;
    public final TypeRef mutableTypeRef() throws RecognitionException {
        TypeRef type = null;
        int mutableTypeRef_StartIndex = input.index();
        TypeMutator m1 = null;

        FunctionSignature f1 = null;

        TypeRef typeRefCore24 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return type; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:934:2: ( ( typeRefCore ) ( (m1= typeMutator ) | (f1= functionSignatureSuffix ) )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:935:3: ( typeRefCore ) ( (m1= typeMutator ) | (f1= functionSignatureSuffix ) )*
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:935:3: ( typeRefCore )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:935:5: typeRefCore
            {
            pushFollow(FOLLOW_typeRefCore_in_mutableTypeRef2458);
            typeRefCore24=typeRefCore();

            state._fsp--;
            if (state.failed) return type;
            if ( state.backtracking==0 ) {
               
              			type = typeRefCore24; 
              		
            }

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:938:3: ( (m1= typeMutator ) | (f1= functionSignatureSuffix ) )*
            loop60:
            do {
                int alt60=3;
                alt60 = dfa60.predict(input);
                switch (alt60) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:939:4: (m1= typeMutator )
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:939:4: (m1= typeMutator )
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:940:5: m1= typeMutator
            	    {
            	    pushFollow(FOLLOW_typeMutator_in_mutableTypeRef2479);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:944:4: (f1= functionSignatureSuffix )
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:944:4: (f1= functionSignatureSuffix )
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:945:5: f1= functionSignatureSuffix
            	    {
            	    pushFollow(FOLLOW_functionSignatureSuffix_in_mutableTypeRef2501);
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
            	    break loop60;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 28, mutableTypeRef_StartIndex); }
        }
        return type;
    }
    // $ANTLR end "mutableTypeRef"


    // $ANTLR start "nonMutableTypeRef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:956:1: nonMutableTypeRef returns [TypeRef type] : typeRefCore ( ( typeMutator )* (fs= functionSignatureSuffix ) )* ;
    public final TypeRef nonMutableTypeRef() throws RecognitionException {
        TypeRef type = null;
        int nonMutableTypeRef_StartIndex = input.index();
        FunctionSignature fs = null;

        TypeRef typeRefCore25 = null;

        TypeMutator typeMutator26 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return type; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:957:2: ( typeRefCore ( ( typeMutator )* (fs= functionSignatureSuffix ) )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:958:3: typeRefCore ( ( typeMutator )* (fs= functionSignatureSuffix ) )*
            {
            pushFollow(FOLLOW_typeRefCore_in_nonMutableTypeRef2530);
            typeRefCore25=typeRefCore();

            state._fsp--;
            if (state.failed) return type;
            if ( state.backtracking==0 ) {
               
              			type = typeRefCore25; 
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:961:3: ( ( typeMutator )* (fs= functionSignatureSuffix ) )*
            loop62:
            do {
                int alt62=2;
                switch ( input.LA(1) ) {
                case 34:
                    {
                    int LA62_2 = input.LA(2);

                    if ( (synpred95_ObjCpp()) ) {
                        alt62=1;
                    }


                    }
                    break;
                case 52:
                case 53:
                    {
                    int LA62_3 = input.LA(2);

                    if ( (synpred95_ObjCpp()) ) {
                        alt62=1;
                    }


                    }
                    break;
                case 54:
                    {
                    alt62=1;
                    }
                    break;

                }

                switch (alt62) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:962:4: ( typeMutator )* (fs= functionSignatureSuffix )
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:962:4: ( typeMutator )*
            	    loop61:
            	    do {
            	        int alt61=2;
            	        int LA61_0 = input.LA(1);

            	        if ( ((LA61_0>=52 && LA61_0<=54)) ) {
            	            alt61=1;
            	        }


            	        switch (alt61) {
            	    	case 1 :
            	    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:963:5: typeMutator
            	    	    {
            	    	    pushFollow(FOLLOW_typeMutator_in_nonMutableTypeRef2547);
            	    	    typeMutator26=typeMutator();

            	    	    state._fsp--;
            	    	    if (state.failed) return type;
            	    	    if ( state.backtracking==0 ) {

            	    	      					type = typeMutator26.mutateType(type);
            	    	      				
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop61;
            	        }
            	    } while (true);

            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:967:4: (fs= functionSignatureSuffix )
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:968:5: fs= functionSignatureSuffix
            	    {
            	    pushFollow(FOLLOW_functionSignatureSuffix_in_nonMutableTypeRef2568);
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
            	    break loop62;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, nonMutableTypeRef_StartIndex); }
        }
        return type;
    }
    // $ANTLR end "nonMutableTypeRef"


    // $ANTLR start "declarator"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:979:1: declarator returns [Declarator declarator] : modifiers ( ( directDeclarator ) | (pt= ( '*' | '&' | '^' ) inner= declarator ) ) ( '=' dv= topLevelExpr )? ;
    public final Declarator declarator() throws RecognitionException {
        Declarator declarator = null;
        int declarator_StartIndex = input.index();
        Token pt=null;
        Declarator inner = null;

        ObjCppParser.topLevelExpr_return dv = null;

        Declarator directDeclarator27 = null;

        List<Modifier> modifiers28 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return declarator; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:980:2: ( modifiers ( ( directDeclarator ) | (pt= ( '*' | '&' | '^' ) inner= declarator ) ) ( '=' dv= topLevelExpr )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:981:3: modifiers ( ( directDeclarator ) | (pt= ( '*' | '&' | '^' ) inner= declarator ) ) ( '=' dv= topLevelExpr )?
            {
            pushFollow(FOLLOW_modifiers_in_declarator2599);
            modifiers28=modifiers();

            state._fsp--;
            if (state.failed) return declarator;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:982:3: ( ( directDeclarator ) | (pt= ( '*' | '&' | '^' ) inner= declarator ) )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==IDENTIFIER) && (( Modifier.parseModifier(next()) == null ))) {
                alt63=1;
            }
            else if ( (LA63_0==34) ) {
                alt63=1;
            }
            else if ( ((LA63_0>=52 && LA63_0<=53)||LA63_0==57) ) {
                alt63=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return declarator;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:983:4: ( directDeclarator )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:983:4: ( directDeclarator )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:984:5: directDeclarator
                    {
                    pushFollow(FOLLOW_directDeclarator_in_declarator2615);
                    directDeclarator27=directDeclarator();

                    state._fsp--;
                    if (state.failed) return declarator;
                    if ( state.backtracking==0 ) {
                       
                      					declarator = directDeclarator27; 
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:988:4: (pt= ( '*' | '&' | '^' ) inner= declarator )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:988:4: (pt= ( '*' | '&' | '^' ) inner= declarator )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:989:5: pt= ( '*' | '&' | '^' ) inner= declarator
                    {
                    pt=(Token)input.LT(1);
                    if ( (input.LA(1)>=52 && input.LA(1)<=53)||input.LA(1)==57 ) {
                        input.consume();
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return declarator;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_declarator_in_declarator2657);
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:995:3: ( '=' dv= topLevelExpr )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==29) ) {
                int LA64_1 = input.LA(2);

                if ( (synpred99_ObjCpp()) ) {
                    alt64=1;
                }
            }
            switch (alt64) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:996:4: '=' dv= topLevelExpr
                    {
                    match(input,29,FOLLOW_29_in_declarator2678); if (state.failed) return declarator;
                    pushFollow(FOLLOW_topLevelExpr_in_declarator2686);
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
              				declarator.setModifiers(modifiers28);
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 30, declarator_StartIndex); }
        }
        return declarator;
    }
    // $ANTLR end "declarator"


    // $ANTLR start "typeDef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1008:1: typeDef returns [TypeDef typeDef] : 'typedef' varDecl ';' ;
    public final TypeDef typeDef() throws RecognitionException {
        IsTypeDef_stack.push(new IsTypeDef_scope());

        TypeDef typeDef = null;
        int typeDef_StartIndex = input.index();
        VariablesDeclaration varDecl29 = null;



        	((IsTypeDef_scope)IsTypeDef_stack.peek()).isTypeDef = true;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return typeDef; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1013:2: ( 'typedef' varDecl ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1013:4: 'typedef' varDecl ';'
            {
            match(input,58,FOLLOW_58_in_typeDef2722); if (state.failed) return typeDef;
            pushFollow(FOLLOW_varDecl_in_typeDef2727);
            varDecl29=varDecl();

            state._fsp--;
            if (state.failed) return typeDef;
            match(input,25,FOLLOW_25_in_typeDef2729); if (state.failed) return typeDef;
            if ( state.backtracking==0 ) {

              		 	VariablesDeclaration vd = varDecl29;
              			typeDef = new TypeDef(vd.getValueType(), vd.getDeclarators());
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 31, typeDef_StartIndex); }
            IsTypeDef_stack.pop();

        }
        return typeDef;
    }
    // $ANTLR end "typeDef"


    // $ANTLR start "varDeclEOF"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1020:1: varDeclEOF returns [Declaration decl] : varDecl ';' EOF ;
    public final Declaration varDeclEOF() throws RecognitionException {
        Declaration decl = null;
        int varDeclEOF_StartIndex = input.index();
        VariablesDeclaration varDecl30 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return decl; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1021:2: ( varDecl ';' EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1021:4: varDecl ';' EOF
            {
            pushFollow(FOLLOW_varDecl_in_varDeclEOF2747);
            varDecl30=varDecl();

            state._fsp--;
            if (state.failed) return decl;
            match(input,25,FOLLOW_25_in_varDeclEOF2749); if (state.failed) return decl;
            match(input,EOF,FOLLOW_EOF_in_varDeclEOF2751); if (state.failed) return decl;
            if ( state.backtracking==0 ) {
               decl = varDecl30; 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 32, varDeclEOF_StartIndex); }
        }
        return decl;
    }
    // $ANTLR end "varDeclEOF"


    // $ANTLR start "declarationEOF"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1024:1: declarationEOF returns [List<Declaration> declarations] : d= declaration EOF ;
    public final List<Declaration> declarationEOF() throws RecognitionException {
        List<Declaration> declarations = null;
        int declarationEOF_StartIndex = input.index();
        ObjCppParser.declaration_return d = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return declarations; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1025:2: (d= declaration EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1025:5: d= declaration EOF
            {
            pushFollow(FOLLOW_declaration_in_declarationEOF2771);
            d=declaration();

            state._fsp--;
            if (state.failed) return declarations;
            match(input,EOF,FOLLOW_EOF_in_declarationEOF2773); if (state.failed) return declarations;
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
            if ( state.backtracking>0 ) { memoize(input, 33, declarationEOF_StartIndex); }
        }
        return declarations;
    }
    // $ANTLR end "declarationEOF"


    // $ANTLR start "varDecl"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1028:1: varDecl returns [VariablesDeclaration decl] : tr= nonMutableTypeRef (d1= declaratorsList )? ;
    public final VariablesDeclaration varDecl() throws RecognitionException {
        VariablesDeclaration decl = null;
        int varDecl_StartIndex = input.index();
        TypeRef tr = null;

        List<Declarator> d1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return decl; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1029:2: (tr= nonMutableTypeRef (d1= declaratorsList )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1030:3: tr= nonMutableTypeRef (d1= declaratorsList )?
            {
            pushFollow(FOLLOW_nonMutableTypeRef_in_varDecl2795);
            tr=nonMutableTypeRef();

            state._fsp--;
            if (state.failed) return decl;
            if ( state.backtracking==0 ) {
               
              			decl = new VariablesDeclaration(tr); 
              			//decl.addModifiers($modifiers.modifiers);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1034:3: (d1= declaratorsList )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==IDENTIFIER||LA65_0==34||(LA65_0>=52 && LA65_0<=53)||LA65_0==57) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1035:4: d1= declaratorsList
                    {
                    pushFollow(FOLLOW_declaratorsList_in_varDecl2808);
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
            if ( state.backtracking>0 ) { memoize(input, 34, varDecl_StartIndex); }
        }
        return decl;
    }
    // $ANTLR end "varDecl"


    // $ANTLR start "objCProtocolRefList"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1041:1: objCProtocolRefList : '<' IDENTIFIER ( ',' IDENTIFIER )* '>' ;
    public final void objCProtocolRefList() throws RecognitionException {
        int objCProtocolRefList_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return ; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1042:2: ( '<' IDENTIFIER ( ',' IDENTIFIER )* '>' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1042:4: '<' IDENTIFIER ( ',' IDENTIFIER )* '>'
            {
            match(input,36,FOLLOW_36_in_objCProtocolRefList2827); if (state.failed) return ;
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCProtocolRefList2832); if (state.failed) return ;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1044:3: ( ',' IDENTIFIER )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==28) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1045:4: ',' IDENTIFIER
            	    {
            	    match(input,28,FOLLOW_28_in_objCProtocolRefList2842); if (state.failed) return ;
            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCProtocolRefList2848); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);

            match(input,37,FOLLOW_37_in_objCProtocolRefList2858); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 35, objCProtocolRefList_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "objCProtocolRefList"


    // $ANTLR start "declaratorsList"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1051:1: declaratorsList returns [List<Declarator> declarators] : d= declarator ( ',' x= declarator )* ;
    public final List<Declarator> declaratorsList() throws RecognitionException {
        List<Declarator> declarators = null;
        int declaratorsList_StartIndex = input.index();
        Declarator d = null;

        Declarator x = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return declarators; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1052:2: (d= declarator ( ',' x= declarator )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1052:4: d= declarator ( ',' x= declarator )*
            {
            if ( state.backtracking==0 ) {
               declarators = new ArrayList<Declarator>(); 
            }
            pushFollow(FOLLOW_declarator_in_declaratorsList2879);
            d=declarator();

            state._fsp--;
            if (state.failed) return declarators;
            if ( state.backtracking==0 ) {
               declarators.add(d); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1054:3: ( ',' x= declarator )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==28) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1055:4: ',' x= declarator
            	    {
            	    match(input,28,FOLLOW_28_in_declaratorsList2890); if (state.failed) return declarators;
            	    pushFollow(FOLLOW_declarator_in_declaratorsList2898);
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
            if ( state.backtracking>0 ) { memoize(input, 36, declaratorsList_StartIndex); }
        }
        return declarators;
    }
    // $ANTLR end "declaratorsList"


    // $ANTLR start "directDeclarator"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1060:1: directDeclarator returns [Declarator declarator] : ({...}? => IDENTIFIER | '(' inner= declarator ')' ) ( '[' ( expression | ) ']' | argList )* ;
    public final Declarator directDeclarator() throws RecognitionException {
        Declarator declarator = null;
        int directDeclarator_StartIndex = input.index();
        Token IDENTIFIER31=null;
        Declarator inner = null;

        Expression expression32 = null;

        ObjCppParser.argList_return argList33 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return declarator; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1067:2: ( ({...}? => IDENTIFIER | '(' inner= declarator ')' ) ( '[' ( expression | ) ']' | argList )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1068:3: ({...}? => IDENTIFIER | '(' inner= declarator ')' ) ( '[' ( expression | ) ']' | argList )*
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1068:3: ({...}? => IDENTIFIER | '(' inner= declarator ')' )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1069:4: {...}? => IDENTIFIER
                    {
                    if ( !(( Modifier.parseModifier(next()) == null )) ) {
                        if (state.backtracking>0) {state.failed=true; return declarator;}
                        throw new FailedPredicateException(input, "directDeclarator", " Modifier.parseModifier(next()) == null ");
                    }
                    IDENTIFIER31=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_directDeclarator2933); if (state.failed) return declarator;
                    if ( state.backtracking==0 ) {

                      				declarator = mark(new DirectDeclarator((IDENTIFIER31!=null?IDENTIFIER31.getText():null)), getLine(IDENTIFIER31));
                      				if (isTypeDef()) {
                      					((Symbols_scope)Symbols_stack.peek()).typeIdentifiers.add((IDENTIFIER31!=null?IDENTIFIER31.getText():null));
                      				}
                      			
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1075:4: '(' inner= declarator ')'
                    {
                    match(input,34,FOLLOW_34_in_directDeclarator2943); if (state.failed) return declarator;
                    pushFollow(FOLLOW_declarator_in_directDeclarator2947);
                    inner=declarator();

                    state._fsp--;
                    if (state.failed) return declarator;
                    match(input,35,FOLLOW_35_in_directDeclarator2949); if (state.failed) return declarator;
                    if ( state.backtracking==0 ) {

                      				declarator = inner;
                      				if (declarator != null)
                      					declarator.setParenthesized(true);
                      			
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1081:3: ( '[' ( expression | ) ']' | argList )*
            loop70:
            do {
                int alt70=3;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==54) ) {
                    alt70=1;
                }
                else if ( (LA70_0==34) ) {
                    alt70=2;
                }


                switch (alt70) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1082:4: '[' ( expression | ) ']'
            	    {
            	    match(input,54,FOLLOW_54_in_directDeclarator2965); if (state.failed) return declarator;
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1083:4: ( expression | )
            	    int alt69=2;
            	    int LA69_0 = input.LA(1);

            	    if ( ((LA69_0>=DECIMAL_NUMBER && LA69_0<=FLOAT_NUMBER)||LA69_0==31||LA69_0==34||(LA69_0>=42 && LA69_0<=43)||(LA69_0>=52 && LA69_0<=54)||(LA69_0>=73 && LA69_0<=75)||(LA69_0>=88 && LA69_0<=91)) ) {
            	        alt69=1;
            	    }
            	    else if ( (LA69_0==55) ) {
            	        alt69=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return declarator;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 69, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt69) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1084:5: expression
            	            {
            	            pushFollow(FOLLOW_expression_in_directDeclarator2977);
            	            expression32=expression();

            	            state._fsp--;
            	            if (state.failed) return declarator;
            	            if ( state.backtracking==0 ) {

            	              					if (declarator instanceof ArrayDeclarator)
            	              						((ArrayDeclarator)declarator).addDimension(expression32);
            	              					else
            	              						declarator = new ArrayDeclarator(declarator, expression32);
            	              				
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1089:9: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              					declarator = new ArrayDeclarator(declarator, new Expression.EmptyArraySize());
            	              				
            	            }

            	            }
            	            break;

            	    }

            	    match(input,55,FOLLOW_55_in_directDeclarator2993); if (state.failed) return declarator;

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1094:4: argList
            	    {
            	    pushFollow(FOLLOW_argList_in_directDeclarator3001);
            	    argList33=argList();

            	    state._fsp--;
            	    if (state.failed) return declarator;
            	    if ( state.backtracking==0 ) {

            	      				declarator = new FunctionDeclarator(declarator, (argList33!=null?argList33.args:null));
            	      			
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
            if ( state.backtracking>0 ) { memoize(input, 37, directDeclarator_StartIndex); }
        }
        return declarator;
    }
    // $ANTLR end "directDeclarator"

    public static class argList_return extends ParserRuleReturnScope {
        public List<Arg> args;
        public boolean isObjC;
    };

    // $ANTLR start "argList"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1100:1: argList returns [List<Arg> args, boolean isObjC] : op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')' ;
    public final ObjCppParser.argList_return argList() throws RecognitionException {
        ObjCppParser.argList_return retval = new ObjCppParser.argList_return();
        retval.start = input.LT(1);
        int argList_StartIndex = input.index();
        Token op=null;
        Token cp=null;
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return retval; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1101:2: (op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1101:4: op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')'
            {
            if ( state.backtracking==0 ) {
               
              			retval.isObjC = false; 
              			retval.args = new ArrayList<Arg>();
              		
            }
            op=(Token)match(input,34,FOLLOW_34_in_argList3029); if (state.failed) return retval;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1106:3: (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==IDENTIFIER||(LA73_0>=28 && LA73_0<=30)||LA73_0==34||LA73_0==44||(LA73_0>=48 && LA73_0<=50)||(LA73_0>=52 && LA73_0<=54)||LA73_0==57||LA73_0==59) ) {
                alt73=1;
            }
            else if ( (LA73_0==35) ) {
                int LA73_2 = input.LA(2);

                if ( (synpred109_ObjCpp()) ) {
                    alt73=1;
                }
            }
            switch (alt73) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1107:4: a1= argDef ( ',' ax= argDef )* ( ',' '...' )?
                    {
                    pushFollow(FOLLOW_argDef_in_argList3041);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					retval.args.add((a1!=null?a1.arg:null));
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1111:4: ( ',' ax= argDef )*
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==28) ) {
                            int LA71_1 = input.LA(2);

                            if ( (LA71_1==44) ) {
                                int LA71_3 = input.LA(3);

                                if ( (synpred107_ObjCpp()) ) {
                                    alt71=1;
                                }


                            }
                            else if ( (LA71_1==IDENTIFIER||(LA71_1>=28 && LA71_1<=30)||(LA71_1>=34 && LA71_1<=35)||(LA71_1>=48 && LA71_1<=50)||(LA71_1>=52 && LA71_1<=54)||LA71_1==57||LA71_1==59) ) {
                                alt71=1;
                            }


                        }


                        switch (alt71) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1112:5: ',' ax= argDef
                    	    {
                    	    match(input,28,FOLLOW_28_in_argList3054); if (state.failed) return retval;
                    	    pushFollow(FOLLOW_argDef_in_argList3063);
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

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1117:4: ( ',' '...' )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==28) ) {
                        alt72=1;
                    }
                    switch (alt72) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1118:5: ',' '...'
                            {
                            match(input,28,FOLLOW_28_in_argList3083); if (state.failed) return retval;
                            match(input,44,FOLLOW_44_in_argList3085); if (state.failed) return retval;
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

            cp=(Token)match(input,35,FOLLOW_35_in_argList3104); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 38, argList_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "argList"


    // $ANTLR start "typeRefCore"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1147:1: typeRefCore returns [TypeRef type] : preMods= modifiers ( 'typename' pn= typeName | {...}? =>an= typeName | structCore | enumCore )? postMods= modifiers ;
    public final TypeRef typeRefCore() throws RecognitionException {
        TypeRef type = null;
        int typeRefCore_StartIndex = input.index();
        List<Modifier> preMods = null;

        TypeRef pn = null;

        TypeRef an = null;

        List<Modifier> postMods = null;

        Struct structCore34 = null;

        Enum enumCore35 = null;



        	List<Modifier> modifiers = new ArrayList<Modifier>();
        	//TypeRef ref = null;
        	int line = -1;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return type; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1162:2: (preMods= modifiers ( 'typename' pn= typeName | {...}? =>an= typeName | structCore | enumCore )? postMods= modifiers )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1163:3: preMods= modifiers ( 'typename' pn= typeName | {...}? =>an= typeName | structCore | enumCore )? postMods= modifiers
            {
            pushFollow(FOLLOW_modifiers_in_typeRefCore3137);
            preMods=modifiers();

            state._fsp--;
            if (state.failed) return type;
            if ( state.backtracking==0 ) {
               modifiers.addAll(preMods); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1164:3: ( 'typename' pn= typeName | {...}? =>an= typeName | structCore | enumCore )?
            int alt74=5;
            switch ( input.LA(1) ) {
                case 59:
                    {
                    alt74=1;
                    }
                    break;
                case IDENTIFIER:
                    {
                    int LA74_2 = input.LA(2);

                    if ( ((synpred111_ObjCpp()&&( 
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1165:4: 'typename' pn= typeName
                    {
                    match(input,59,FOLLOW_59_in_typeRefCore3148); if (state.failed) return type;
                    pushFollow(FOLLOW_typeName_in_typeRefCore3152);
                    pn=typeName();

                    state._fsp--;
                    if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                       type = pn; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1166:4: {...}? =>an= typeName
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
                    pushFollow(FOLLOW_typeName_in_typeRefCore3166);
                    an=typeName();

                    state._fsp--;
                    if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                       type = an; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1173:4: structCore
                    {
                    pushFollow(FOLLOW_structCore_in_typeRefCore3175);
                    structCore34=structCore();

                    state._fsp--;
                    if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                       type = structCore34; 
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1174:4: enumCore
                    {
                    pushFollow(FOLLOW_enumCore_in_typeRefCore3184);
                    enumCore35=enumCore();

                    state._fsp--;
                    if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                       type = enumCore35; 
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_modifiers_in_typeRefCore3197);
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
            if ( state.backtracking>0 ) { memoize(input, 39, typeRefCore_StartIndex); }
        }
        return type;
    }
    // $ANTLR end "typeRefCore"


    // $ANTLR start "typeName"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1179:1: typeName returns [TypeRef type] : i= qualifiedIdentifier ;
    public final TypeRef typeName() throws RecognitionException {
        TypeRef type = null;
        int typeName_StartIndex = input.index();
        ObjCppParser.qualifiedIdentifier_return i = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return type; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1180:2: (i= qualifiedIdentifier )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1181:3: i= qualifiedIdentifier
            {
            pushFollow(FOLLOW_qualifiedIdentifier_in_typeName3219);
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
            if ( state.backtracking>0 ) { memoize(input, 40, typeName_StartIndex); }
        }
        return type;
    }
    // $ANTLR end "typeName"


    // $ANTLR start "objCMethodCall"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1191:1: objCMethodCall returns [FunctionCall expr] : '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']' ;
    public final FunctionCall objCMethodCall() throws RecognitionException {
        FunctionCall expr = null;
        int objCMethodCall_StartIndex = input.index();
        Token methodName=null;
        Token selx=null;
        Expression target = null;

        Expression arg1 = null;

        Expression argx = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1192:2: ( '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1193:3: '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']'
            {
            match(input,54,FOLLOW_54_in_objCMethodCall3239); if (state.failed) return expr;
            pushFollow(FOLLOW_expression_in_objCMethodCall3243);
            target=expression();

            state._fsp--;
            if (state.failed) return expr;
            methodName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodCall3247); if (state.failed) return expr;
            if ( state.backtracking==0 ) {

              			expr = new FunctionCall();
              			expr.setFunction(new VariableRef(new SimpleIdentifier((methodName!=null?methodName.getText():null))));
              			expr.setTarget(target);
              			expr.setMemberRefStyle(MemberRefStyle.SquareBrackets);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1199:3: ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==33) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1200:4: ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )*
                    {
                    match(input,33,FOLLOW_33_in_objCMethodCall3258); if (state.failed) return expr;
                    pushFollow(FOLLOW_expression_in_objCMethodCall3262);
                    arg1=expression();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {

                      				expr.addArgument(null, arg1);
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1203:4: (selx= IDENTIFIER ':' argx= expression )*
                    loop75:
                    do {
                        int alt75=2;
                        int LA75_0 = input.LA(1);

                        if ( (LA75_0==IDENTIFIER) ) {
                            alt75=1;
                        }


                        switch (alt75) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1204:5: selx= IDENTIFIER ':' argx= expression
                    	    {
                    	    selx=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodCall3277); if (state.failed) return expr;
                    	    match(input,33,FOLLOW_33_in_objCMethodCall3279); if (state.failed) return expr;
                    	    pushFollow(FOLLOW_expression_in_objCMethodCall3283);
                    	    argx=expression();

                    	    state._fsp--;
                    	    if (state.failed) return expr;
                    	    if ( state.backtracking==0 ) {

                    	      					expr.addArgument((selx!=null?selx.getText():null), argx);
                    	      				
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

            match(input,55,FOLLOW_55_in_objCMethodCall3300); if (state.failed) return expr;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 41, objCMethodCall_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "objCMethodCall"


    // $ANTLR start "binaryOp"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1212:1: binaryOp returns [Expression.BinaryOperator op] : t= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) ;
    public final Expression.BinaryOperator binaryOp() throws RecognitionException {
        Expression.BinaryOperator op = null;
        int binaryOp_StartIndex = input.index();
        Token t=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return op; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1213:2: (t= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1213:5: t= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' )
            {
            t=(Token)input.LT(1);
            if ( (input.LA(1)>=36 && input.LA(1)<=37)||(input.LA(1)>=42 && input.LA(1)<=43)||(input.LA(1)>=52 && input.LA(1)<=53)||input.LA(1)==57||(input.LA(1)>=60 && input.LA(1)<=71) ) {
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
            if ( state.backtracking>0 ) { memoize(input, 42, binaryOp_StartIndex); }
        }
        return op;
    }
    // $ANTLR end "binaryOp"


    // $ANTLR start "typeRefOrExpression"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1223:1: typeRefOrExpression returns [Expression expr] : (tr= mutableTypeRef | e= topLevelExpr );
    public final Expression typeRefOrExpression() throws RecognitionException {
        Expression expr = null;
        int typeRefOrExpression_StartIndex = input.index();
        TypeRef tr = null;

        ObjCppParser.topLevelExpr_return e = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1224:2: (tr= mutableTypeRef | e= topLevelExpr )
            int alt77=2;
            alt77 = dfa77.predict(input);
            switch (alt77) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1224:4: tr= mutableTypeRef
                    {
                    pushFollow(FOLLOW_mutableTypeRef_in_typeRefOrExpression3425);
                    tr=mutableTypeRef();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {

                      			expr = new Expression.TypeRefExpression(tr);
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1227:3: e= topLevelExpr
                    {
                    pushFollow(FOLLOW_topLevelExpr_in_typeRefOrExpression3436);
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
            if ( state.backtracking>0 ) { memoize(input, 43, typeRefOrExpression_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "typeRefOrExpression"


    // $ANTLR start "simpleIdentifier"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1232:1: simpleIdentifier returns [SimpleIdentifier identifier] : i= IDENTIFIER ( '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>' )? ;
    public final SimpleIdentifier simpleIdentifier() throws RecognitionException {
        SimpleIdentifier identifier = null;
        int simpleIdentifier_StartIndex = input.index();
        Token i=null;
        Expression a1 = null;

        Expression ax = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return identifier; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1233:2: (i= IDENTIFIER ( '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>' )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1233:4: i= IDENTIFIER ( '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>' )?
            {
            i=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_simpleIdentifier3455); if (state.failed) return identifier;
            if ( state.backtracking==0 ) {
               identifier = new SimpleIdentifier((i!=null?i.getText():null)); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1234:3: ( '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>' )?
            int alt80=2;
            alt80 = dfa80.predict(input);
            switch (alt80) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1235:4: '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>'
                    {
                    match(input,36,FOLLOW_36_in_simpleIdentifier3466); if (state.failed) return identifier;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1235:8: (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )?
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( ((LA79_0>=DECIMAL_NUMBER && LA79_0<=FLOAT_NUMBER)||LA79_0==28||(LA79_0>=30 && LA79_0<=31)||LA79_0==34||(LA79_0>=42 && LA79_0<=43)||(LA79_0>=48 && LA79_0<=50)||(LA79_0>=52 && LA79_0<=54)||LA79_0==59||(LA79_0>=73 && LA79_0<=75)||(LA79_0>=88 && LA79_0<=91)) ) {
                        alt79=1;
                    }
                    else if ( (LA79_0==37) ) {
                        int LA79_2 = input.LA(2);

                        if ( (synpred136_ObjCpp()) ) {
                            alt79=1;
                        }
                    }
                    switch (alt79) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1236:5: a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )*
                            {
                            pushFollow(FOLLOW_typeRefOrExpression_in_simpleIdentifier3476);
                            a1=typeRefOrExpression();

                            state._fsp--;
                            if (state.failed) return identifier;
                            if ( state.backtracking==0 ) {
                               identifier.addTemplateArgument(a1); 
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1237:5: ( ',' ax= typeRefOrExpression )*
                            loop78:
                            do {
                                int alt78=2;
                                int LA78_0 = input.LA(1);

                                if ( (LA78_0==28) ) {
                                    alt78=1;
                                }


                                switch (alt78) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1238:6: ',' ax= typeRefOrExpression
                            	    {
                            	    match(input,28,FOLLOW_28_in_simpleIdentifier3491); if (state.failed) return identifier;
                            	    pushFollow(FOLLOW_typeRefOrExpression_in_simpleIdentifier3501);
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

                    match(input,37,FOLLOW_37_in_simpleIdentifier3520); if (state.failed) return identifier;

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
            if ( state.backtracking>0 ) { memoize(input, 44, simpleIdentifier_StartIndex); }
        }
        return identifier;
    }
    // $ANTLR end "simpleIdentifier"

    public static class qualifiedIdentifier_return extends ParserRuleReturnScope {
        public Identifier identifier;
    };

    // $ANTLR start "qualifiedIdentifier"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1245:1: qualifiedIdentifier returns [Identifier identifier] : i1= simpleIdentifier ( '::' ix= simpleIdentifier )* ;
    public final ObjCppParser.qualifiedIdentifier_return qualifiedIdentifier() throws RecognitionException {
        ObjCppParser.qualifiedIdentifier_return retval = new ObjCppParser.qualifiedIdentifier_return();
        retval.start = input.LT(1);
        int qualifiedIdentifier_StartIndex = input.index();
        SimpleIdentifier i1 = null;

        SimpleIdentifier ix = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return retval; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1246:2: (i1= simpleIdentifier ( '::' ix= simpleIdentifier )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1246:4: i1= simpleIdentifier ( '::' ix= simpleIdentifier )*
            {
            pushFollow(FOLLOW_simpleIdentifier_in_qualifiedIdentifier3542);
            i1=simpleIdentifier();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               retval.identifier = i1; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1247:3: ( '::' ix= simpleIdentifier )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==72) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1248:4: '::' ix= simpleIdentifier
            	    {
            	    match(input,72,FOLLOW_72_in_qualifiedIdentifier3553); if (state.failed) return retval;
            	    pushFollow(FOLLOW_simpleIdentifier_in_qualifiedIdentifier3557);
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
            if ( state.backtracking>0 ) { memoize(input, 45, qualifiedIdentifier_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "qualifiedIdentifier"


    // $ANTLR start "qualifiedCppFunctionName"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1252:1: qualifiedCppFunctionName returns [Identifier identifier] : i1= simpleCppFunctionName ( '::' ix= simpleCppFunctionName )* ;
    public final Identifier qualifiedCppFunctionName() throws RecognitionException {
        Identifier identifier = null;
        int qualifiedCppFunctionName_StartIndex = input.index();
        SimpleIdentifier i1 = null;

        SimpleIdentifier ix = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return identifier; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1253:2: (i1= simpleCppFunctionName ( '::' ix= simpleCppFunctionName )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1253:4: i1= simpleCppFunctionName ( '::' ix= simpleCppFunctionName )*
            {
            pushFollow(FOLLOW_simpleCppFunctionName_in_qualifiedCppFunctionName3582);
            i1=simpleCppFunctionName();

            state._fsp--;
            if (state.failed) return identifier;
            if ( state.backtracking==0 ) {
               identifier = i1; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1254:3: ( '::' ix= simpleCppFunctionName )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==72) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1255:4: '::' ix= simpleCppFunctionName
            	    {
            	    match(input,72,FOLLOW_72_in_qualifiedCppFunctionName3593); if (state.failed) return identifier;
            	    pushFollow(FOLLOW_simpleCppFunctionName_in_qualifiedCppFunctionName3597);
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
            if ( state.backtracking>0 ) { memoize(input, 46, qualifiedCppFunctionName_StartIndex); }
        }
        return identifier;
    }
    // $ANTLR end "qualifiedCppFunctionName"


    // $ANTLR start "simpleCppFunctionName"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1259:1: simpleCppFunctionName returns [SimpleIdentifier identifier] : (pre= '~' )? i= simpleIdentifier ;
    public final SimpleIdentifier simpleCppFunctionName() throws RecognitionException {
        SimpleIdentifier identifier = null;
        int simpleCppFunctionName_StartIndex = input.index();
        Token pre=null;
        SimpleIdentifier i = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return identifier; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1260:2: ( (pre= '~' )? i= simpleIdentifier )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1261:3: (pre= '~' )? i= simpleIdentifier
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1261:6: (pre= '~' )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==73) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: pre= '~'
                    {
                    pre=(Token)match(input,73,FOLLOW_73_in_simpleCppFunctionName3624); if (state.failed) return identifier;

                    }
                    break;

            }

            pushFollow(FOLLOW_simpleIdentifier_in_simpleCppFunctionName3632);
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
            if ( state.backtracking>0 ) { memoize(input, 47, simpleCppFunctionName_StartIndex); }
        }
        return identifier;
    }
    // $ANTLR end "simpleCppFunctionName"


    // $ANTLR start "baseExpression"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1269:1: baseExpression returns [Expression expr] : (i= simpleIdentifier | constant | '(' expression ')' | objCMethodCall | selectorExpr | protocolExpr | encodingExpr );
    public final Expression baseExpression() throws RecognitionException {
        Expression expr = null;
        int baseExpression_StartIndex = input.index();
        SimpleIdentifier i = null;

        Constant constant36 = null;

        Expression expression37 = null;

        FunctionCall objCMethodCall38 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1270:2: (i= simpleIdentifier | constant | '(' expression ')' | objCMethodCall | selectorExpr | protocolExpr | encodingExpr )
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
            case 42:
            case 43:
                {
                alt84=2;
                }
                break;
            case 34:
                {
                alt84=3;
                }
                break;
            case 54:
                {
                alt84=4;
                }
                break;
            case 74:
                {
                alt84=5;
                }
                break;
            case 31:
                {
                alt84=6;
                }
                break;
            case 75:
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1271:3: i= simpleIdentifier
                    {
                    pushFollow(FOLLOW_simpleIdentifier_in_baseExpression3654);
                    i=simpleIdentifier();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {
                       expr = new VariableRef(i); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1272:3: constant
                    {
                    pushFollow(FOLLOW_constant_in_baseExpression3663);
                    constant36=constant();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {
                       expr = constant36; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1273:3: '(' expression ')'
                    {
                    match(input,34,FOLLOW_34_in_baseExpression3671); if (state.failed) return expr;
                    pushFollow(FOLLOW_expression_in_baseExpression3673);
                    expression37=expression();

                    state._fsp--;
                    if (state.failed) return expr;
                    match(input,35,FOLLOW_35_in_baseExpression3675); if (state.failed) return expr;
                    if ( state.backtracking==0 ) {
                       
                      			expr = expression37; 
                      			if (expr != null)
                      				expr.setParenthesis(true);
                      		
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1278:3: objCMethodCall
                    {
                    pushFollow(FOLLOW_objCMethodCall_in_baseExpression3683);
                    objCMethodCall38=objCMethodCall();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {
                       expr = objCMethodCall38; 
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1279:3: selectorExpr
                    {
                    pushFollow(FOLLOW_selectorExpr_in_baseExpression3691);
                    selectorExpr();

                    state._fsp--;
                    if (state.failed) return expr;

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1280:3: protocolExpr
                    {
                    pushFollow(FOLLOW_protocolExpr_in_baseExpression3697);
                    protocolExpr();

                    state._fsp--;
                    if (state.failed) return expr;

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1281:3: encodingExpr
                    {
                    pushFollow(FOLLOW_encodingExpr_in_baseExpression3703);
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
            if ( state.backtracking>0 ) { memoize(input, 48, baseExpression_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "baseExpression"


    // $ANTLR start "selectorExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1284:1: selectorExpr returns [Expression expr] : '@selector' '(' selectorName ')' ;
    public final Expression selectorExpr() throws RecognitionException {
        Expression expr = null;
        int selectorExpr_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1285:2: ( '@selector' '(' selectorName ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1285:4: '@selector' '(' selectorName ')'
            {
            match(input,74,FOLLOW_74_in_selectorExpr3719); if (state.failed) return expr;
            match(input,34,FOLLOW_34_in_selectorExpr3724); if (state.failed) return expr;
            pushFollow(FOLLOW_selectorName_in_selectorExpr3729);
            selectorName();

            state._fsp--;
            if (state.failed) return expr;
            match(input,35,FOLLOW_35_in_selectorExpr3734); if (state.failed) return expr;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 49, selectorExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "selectorExpr"


    // $ANTLR start "selectorName"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1291:1: selectorName : IDENTIFIER ( IDENTIFIER ':' )* ;
    public final void selectorName() throws RecognitionException {
        int selectorName_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return ; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1292:2: ( IDENTIFIER ( IDENTIFIER ':' )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1292:4: IDENTIFIER ( IDENTIFIER ':' )*
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_selectorName3745); if (state.failed) return ;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1292:15: ( IDENTIFIER ':' )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==IDENTIFIER) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1292:16: IDENTIFIER ':'
            	    {
            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_selectorName3748); if (state.failed) return ;
            	    match(input,33,FOLLOW_33_in_selectorName3750); if (state.failed) return ;

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
            if ( state.backtracking>0 ) { memoize(input, 50, selectorName_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "selectorName"


    // $ANTLR start "protocolExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1295:1: protocolExpr : '@protocol' '(' IDENTIFIER ')' ;
    public final void protocolExpr() throws RecognitionException {
        int protocolExpr_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return ; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1296:2: ( '@protocol' '(' IDENTIFIER ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1296:4: '@protocol' '(' IDENTIFIER ')'
            {
            match(input,31,FOLLOW_31_in_protocolExpr3763); if (state.failed) return ;
            match(input,34,FOLLOW_34_in_protocolExpr3767); if (state.failed) return ;
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_protocolExpr3771); if (state.failed) return ;
            match(input,35,FOLLOW_35_in_protocolExpr3775); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 51, protocolExpr_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "protocolExpr"


    // $ANTLR start "encodingExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1302:1: encodingExpr : '@encode' '(' IDENTIFIER ')' ;
    public final void encodingExpr() throws RecognitionException {
        int encodingExpr_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return ; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1303:2: ( '@encode' '(' IDENTIFIER ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1303:4: '@encode' '(' IDENTIFIER ')'
            {
            match(input,75,FOLLOW_75_in_encodingExpr3786); if (state.failed) return ;
            match(input,34,FOLLOW_34_in_encodingExpr3791); if (state.failed) return ;
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_encodingExpr3795); if (state.failed) return ;
            match(input,35,FOLLOW_35_in_encodingExpr3800); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 52, encodingExpr_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "encodingExpr"


    // $ANTLR start "assignmentExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1309:1: assignmentExpr returns [Expression expr] : e= inlineCondExpr (op= assignmentOp f= assignmentExpr )? ;
    public final Expression assignmentExpr() throws RecognitionException {
        Expression expr = null;
        int assignmentExpr_StartIndex = input.index();
        Expression e = null;

        ObjCppParser.assignmentOp_return op = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1310:2: (e= inlineCondExpr (op= assignmentOp f= assignmentExpr )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1310:4: e= inlineCondExpr (op= assignmentOp f= assignmentExpr )?
            {
            pushFollow(FOLLOW_inlineCondExpr_in_assignmentExpr3817);
            e=inlineCondExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1311:3: (op= assignmentOp f= assignmentExpr )?
            int alt86=2;
            alt86 = dfa86.predict(input);
            switch (alt86) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1312:4: op= assignmentOp f= assignmentExpr
                    {
                    pushFollow(FOLLOW_assignmentOp_in_assignmentExpr3833);
                    op=assignmentOp();

                    state._fsp--;
                    if (state.failed) return expr;
                    pushFollow(FOLLOW_assignmentExpr_in_assignmentExpr3837);
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
            if ( state.backtracking>0 ) { memoize(input, 53, assignmentExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "assignmentExpr"

    public static class assignmentOp_return extends ParserRuleReturnScope {
        public Expression.AssignmentOperator op;
    };

    // $ANTLR start "assignmentOp"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1316:1: assignmentOp returns [Expression.AssignmentOperator op] : t= ( '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=' | '~=' ) ;
    public final ObjCppParser.assignmentOp_return assignmentOp() throws RecognitionException {
        ObjCppParser.assignmentOp_return retval = new ObjCppParser.assignmentOp_return();
        retval.start = input.LT(1);
        int assignmentOp_StartIndex = input.index();
        Token t=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return retval; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1317:2: (t= ( '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=' | '~=' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1317:5: t= ( '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=' | '~=' )
            {
            t=(Token)input.LT(1);
            if ( input.LA(1)==29||(input.LA(1)>=76 && input.LA(1)<=86) ) {
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
            if ( state.backtracking>0 ) { memoize(input, 54, assignmentOp_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "assignmentOp"


    // $ANTLR start "inlineCondExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1322:1: inlineCondExpr returns [Expression expr] : e= logOrExpr ( '?' logOrExpr ':' logOrExpr )* ;
    public final Expression inlineCondExpr() throws RecognitionException {
        Expression expr = null;
        int inlineCondExpr_StartIndex = input.index();
        Expression e = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1323:2: (e= logOrExpr ( '?' logOrExpr ':' logOrExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1323:4: e= logOrExpr ( '?' logOrExpr ':' logOrExpr )*
            {
            pushFollow(FOLLOW_logOrExpr_in_inlineCondExpr3928);
            e=logOrExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1324:3: ( '?' logOrExpr ':' logOrExpr )*
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==87) ) {
                    alt87=1;
                }


                switch (alt87) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1325:4: '?' logOrExpr ':' logOrExpr
            	    {
            	    match(input,87,FOLLOW_87_in_inlineCondExpr3940); if (state.failed) return expr;
            	    pushFollow(FOLLOW_logOrExpr_in_inlineCondExpr3945);
            	    logOrExpr();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    match(input,33,FOLLOW_33_in_inlineCondExpr3951); if (state.failed) return expr;
            	    pushFollow(FOLLOW_logOrExpr_in_inlineCondExpr3956);
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
            if ( state.backtracking>0 ) { memoize(input, 55, inlineCondExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "inlineCondExpr"


    // $ANTLR start "addExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1332:1: addExpr returns [Expression expr] : e= multExpr (op= ( '+' | '-' ) f= multExpr )* ;
    public final Expression addExpr() throws RecognitionException {
        Expression expr = null;
        int addExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1333:2: (e= multExpr (op= ( '+' | '-' ) f= multExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1333:4: e= multExpr (op= ( '+' | '-' ) f= multExpr )*
            {
            pushFollow(FOLLOW_multExpr_in_addExpr3978);
            e=multExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1334:3: (op= ( '+' | '-' ) f= multExpr )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( ((LA88_0>=42 && LA88_0<=43)) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1335:4: op= ( '+' | '-' ) f= multExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=42 && input.LA(1)<=43) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return expr;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_multExpr_in_addExpr4004);
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
            if ( state.backtracking>0 ) { memoize(input, 56, addExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "addExpr"


    // $ANTLR start "multExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1340:1: multExpr returns [Expression expr] : e= castExpr (op= ( '%' | '*' | '/' ) f= castExpr )* ;
    public final Expression multExpr() throws RecognitionException {
        Expression expr = null;
        int multExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1341:2: (e= castExpr (op= ( '%' | '*' | '/' ) f= castExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1341:4: e= castExpr (op= ( '%' | '*' | '/' ) f= castExpr )*
            {
            pushFollow(FOLLOW_castExpr_in_multExpr4028);
            e=castExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1342:3: (op= ( '%' | '*' | '/' ) f= castExpr )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==52||(LA89_0>=60 && LA89_0<=61)) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1343:4: op= ( '%' | '*' | '/' ) f= castExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( input.LA(1)==52||(input.LA(1)>=60 && input.LA(1)<=61) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return expr;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_castExpr_in_multExpr4060);
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
            if ( state.backtracking>0 ) { memoize(input, 57, multExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "multExpr"


    // $ANTLR start "bitOrExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1348:1: bitOrExpr returns [Expression expr] : e= xorExpr (op= '|' f= xorExpr )* ;
    public final Expression bitOrExpr() throws RecognitionException {
        Expression expr = null;
        int bitOrExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1349:2: (e= xorExpr (op= '|' f= xorExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1349:4: e= xorExpr (op= '|' f= xorExpr )*
            {
            pushFollow(FOLLOW_xorExpr_in_bitOrExpr4084);
            e=xorExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1350:3: (op= '|' f= xorExpr )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==66) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1351:4: op= '|' f= xorExpr
            	    {
            	    op=(Token)match(input,66,FOLLOW_66_in_bitOrExpr4098); if (state.failed) return expr;
            	    pushFollow(FOLLOW_xorExpr_in_bitOrExpr4105);
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
            if ( state.backtracking>0 ) { memoize(input, 58, bitOrExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "bitOrExpr"


    // $ANTLR start "bitAndExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1356:1: bitAndExpr returns [Expression expr] : e= equalExpr (op= '&' f= equalExpr )* ;
    public final Expression bitAndExpr() throws RecognitionException {
        Expression expr = null;
        int bitAndExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1357:2: (e= equalExpr (op= '&' f= equalExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1357:4: e= equalExpr (op= '&' f= equalExpr )*
            {
            pushFollow(FOLLOW_equalExpr_in_bitAndExpr4129);
            e=equalExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1358:3: (op= '&' f= equalExpr )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==53) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1359:4: op= '&' f= equalExpr
            	    {
            	    op=(Token)match(input,53,FOLLOW_53_in_bitAndExpr4142); if (state.failed) return expr;
            	    pushFollow(FOLLOW_equalExpr_in_bitAndExpr4149);
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
            if ( state.backtracking>0 ) { memoize(input, 59, bitAndExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "bitAndExpr"


    // $ANTLR start "shiftExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1365:1: shiftExpr returns [Expression expr] : e= addExpr (op= ( '>>' | '<<' ) f= addExpr )* ;
    public final Expression shiftExpr() throws RecognitionException {
        Expression expr = null;
        int shiftExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1366:2: (e= addExpr (op= ( '>>' | '<<' ) f= addExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1366:4: e= addExpr (op= ( '>>' | '<<' ) f= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_shiftExpr4174);
            e=addExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1367:3: (op= ( '>>' | '<<' ) f= addExpr )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==62||LA92_0==64) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1368:4: op= ( '>>' | '<<' ) f= addExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( input.LA(1)==62||input.LA(1)==64 ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return expr;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_addExpr_in_shiftExpr4200);
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
            if ( state.backtracking>0 ) { memoize(input, 60, shiftExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "shiftExpr"


    // $ANTLR start "xorExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1373:1: xorExpr returns [Expression expr] : e= bitAndExpr (op= '^' f= bitAndExpr )* ;
    public final Expression xorExpr() throws RecognitionException {
        Expression expr = null;
        int xorExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1374:2: (e= bitAndExpr (op= '^' f= bitAndExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1374:4: e= bitAndExpr (op= '^' f= bitAndExpr )*
            {
            pushFollow(FOLLOW_bitAndExpr_in_xorExpr4224);
            e=bitAndExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1375:3: (op= '^' f= bitAndExpr )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==57) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1376:4: op= '^' f= bitAndExpr
            	    {
            	    op=(Token)match(input,57,FOLLOW_57_in_xorExpr4237); if (state.failed) return expr;
            	    pushFollow(FOLLOW_bitAndExpr_in_xorExpr4244);
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
            if ( state.backtracking>0 ) { memoize(input, 61, xorExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "xorExpr"


    // $ANTLR start "logOrExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1381:1: logOrExpr returns [Expression expr] : e= logAndExpr (op= '||' f= logAndExpr )* ;
    public final Expression logOrExpr() throws RecognitionException {
        Expression expr = null;
        int logOrExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1382:2: (e= logAndExpr (op= '||' f= logAndExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1382:4: e= logAndExpr (op= '||' f= logAndExpr )*
            {
            pushFollow(FOLLOW_logAndExpr_in_logOrExpr4268);
            e=logAndExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1383:3: (op= '||' f= logAndExpr )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==65) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1384:4: op= '||' f= logAndExpr
            	    {
            	    op=(Token)match(input,65,FOLLOW_65_in_logOrExpr4281); if (state.failed) return expr;
            	    pushFollow(FOLLOW_logAndExpr_in_logOrExpr4288);
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
            if ( state.backtracking>0 ) { memoize(input, 62, logOrExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "logOrExpr"


    // $ANTLR start "logAndExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1389:1: logAndExpr returns [Expression expr] : e= bitOrExpr (op= '&&' f= bitOrExpr )* ;
    public final Expression logAndExpr() throws RecognitionException {
        Expression expr = null;
        int logAndExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1390:2: (e= bitOrExpr (op= '&&' f= bitOrExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1390:4: e= bitOrExpr (op= '&&' f= bitOrExpr )*
            {
            pushFollow(FOLLOW_bitOrExpr_in_logAndExpr4312);
            e=bitOrExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1391:3: (op= '&&' f= bitOrExpr )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==67) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1392:4: op= '&&' f= bitOrExpr
            	    {
            	    op=(Token)match(input,67,FOLLOW_67_in_logAndExpr4325); if (state.failed) return expr;
            	    pushFollow(FOLLOW_bitOrExpr_in_logAndExpr4332);
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
            if ( state.backtracking>0 ) { memoize(input, 63, logAndExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "logAndExpr"


    // $ANTLR start "equalExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1397:1: equalExpr returns [Expression expr] : e= compareExpr (op= ( '!=' | '==' ) f= compareExpr )* ;
    public final Expression equalExpr() throws RecognitionException {
        Expression expr = null;
        int equalExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1398:2: (e= compareExpr (op= ( '!=' | '==' ) f= compareExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1398:4: e= compareExpr (op= ( '!=' | '==' ) f= compareExpr )*
            {
            pushFollow(FOLLOW_compareExpr_in_equalExpr4356);
            e=compareExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1399:3: (op= ( '!=' | '==' ) f= compareExpr )*
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( ((LA96_0>=70 && LA96_0<=71)) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1400:4: op= ( '!=' | '==' ) f= compareExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=70 && input.LA(1)<=71) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return expr;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_compareExpr_in_equalExpr4382);
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
            if ( state.backtracking>0 ) { memoize(input, 64, equalExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "equalExpr"


    // $ANTLR start "compareExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1405:1: compareExpr returns [Expression expr] : e= shiftExpr (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )* ;
    public final Expression compareExpr() throws RecognitionException {
        Expression expr = null;
        int compareExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1406:2: (e= shiftExpr (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1406:4: e= shiftExpr (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )*
            {
            pushFollow(FOLLOW_shiftExpr_in_compareExpr4406);
            e=shiftExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1407:3: (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )*
            loop97:
            do {
                int alt97=2;
                alt97 = dfa97.predict(input);
                switch (alt97) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1408:4: op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=36 && input.LA(1)<=37)||(input.LA(1)>=68 && input.LA(1)<=69) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return expr;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_shiftExpr_in_compareExpr4441);
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
            if ( state.backtracking>0 ) { memoize(input, 65, compareExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "compareExpr"


    // $ANTLR start "castExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1413:1: castExpr returns [Expression expr] : ( '(' tr= mutableTypeRef ')' inner= castExpr | e= unaryExpr );
    public final Expression castExpr() throws RecognitionException {
        Expression expr = null;
        int castExpr_StartIndex = input.index();
        TypeRef tr = null;

        Expression inner = null;

        Expression e = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1414:2: ( '(' tr= mutableTypeRef ')' inner= castExpr | e= unaryExpr )
            int alt98=2;
            alt98 = dfa98.predict(input);
            switch (alt98) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1414:4: '(' tr= mutableTypeRef ')' inner= castExpr
                    {
                    match(input,34,FOLLOW_34_in_castExpr4463); if (state.failed) return expr;
                    pushFollow(FOLLOW_mutableTypeRef_in_castExpr4467);
                    tr=mutableTypeRef();

                    state._fsp--;
                    if (state.failed) return expr;
                    match(input,35,FOLLOW_35_in_castExpr4469); if (state.failed) return expr;
                    pushFollow(FOLLOW_castExpr_in_castExpr4473);
                    inner=castExpr();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {
                       expr = new Cast(tr, inner); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1415:3: e= unaryExpr
                    {
                    pushFollow(FOLLOW_unaryExpr_in_castExpr4484);
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
            if ( state.backtracking>0 ) { memoize(input, 66, castExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "castExpr"


    // $ANTLR start "unaryExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1418:1: unaryExpr returns [Expression expr] : (p= postfixExpr | uo= unaryOp castExpr | 'sizeof' ( '(' tr= mutableTypeRef ')' | unaryExpr ) );
    public final Expression unaryExpr() throws RecognitionException {
        Expression expr = null;
        int unaryExpr_StartIndex = input.index();
        Expression p = null;

        Expression.UnaryOperator uo = null;

        TypeRef tr = null;

        Expression castExpr39 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1419:2: (p= postfixExpr | uo= unaryOp castExpr | 'sizeof' ( '(' tr= mutableTypeRef ')' | unaryExpr ) )
            int alt100=3;
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
            case 54:
            case 74:
            case 75:
                {
                alt100=1;
                }
                break;
            case 43:
                {
                int LA100_2 = input.LA(2);

                if ( (synpred180_ObjCpp()) ) {
                    alt100=1;
                }
                else if ( (synpred181_ObjCpp()) ) {
                    alt100=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expr;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 100, 2, input);

                    throw nvae;
                }
                }
                break;
            case 52:
            case 53:
            case 73:
            case 89:
            case 90:
            case 91:
                {
                alt100=2;
                }
                break;
            case 88:
                {
                alt100=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return expr;}
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;
            }

            switch (alt100) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1420:3: p= postfixExpr
                    {
                    pushFollow(FOLLOW_postfixExpr_in_unaryExpr4506);
                    p=postfixExpr();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {
                       expr = p; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1421:3: uo= unaryOp castExpr
                    {
                    pushFollow(FOLLOW_unaryOp_in_unaryExpr4516);
                    uo=unaryOp();

                    state._fsp--;
                    if (state.failed) return expr;
                    pushFollow(FOLLOW_castExpr_in_unaryExpr4518);
                    castExpr39=castExpr();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {
                       expr = new UnaryOp(castExpr39, uo); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1422:3: 'sizeof' ( '(' tr= mutableTypeRef ')' | unaryExpr )
                    {
                    match(input,88,FOLLOW_88_in_unaryExpr4526); if (state.failed) return expr;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1422:12: ( '(' tr= mutableTypeRef ')' | unaryExpr )
                    int alt99=2;
                    alt99 = dfa99.predict(input);
                    switch (alt99) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1423:4: '(' tr= mutableTypeRef ')'
                            {
                            match(input,34,FOLLOW_34_in_unaryExpr4533); if (state.failed) return expr;
                            pushFollow(FOLLOW_mutableTypeRef_in_unaryExpr4537);
                            tr=mutableTypeRef();

                            state._fsp--;
                            if (state.failed) return expr;
                            match(input,35,FOLLOW_35_in_unaryExpr4539); if (state.failed) return expr;

                            }
                            break;
                        case 2 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1424:4: unaryExpr
                            {
                            pushFollow(FOLLOW_unaryExpr_in_unaryExpr4547);
                            unaryExpr();

                            state._fsp--;
                            if (state.failed) return expr;

                            }
                            break;

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
            if ( state.backtracking>0 ) { memoize(input, 67, unaryExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "unaryExpr"


    // $ANTLR start "unaryOp"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1428:1: unaryOp returns [Expression.UnaryOperator op] : t= ( '++' | '--' | '&' | '*' | '-' | '~' | '!' ) ;
    public final Expression.UnaryOperator unaryOp() throws RecognitionException {
        Expression.UnaryOperator op = null;
        int unaryOp_StartIndex = input.index();
        Token t=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return op; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1429:2: (t= ( '++' | '--' | '&' | '*' | '-' | '~' | '!' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1429:5: t= ( '++' | '--' | '&' | '*' | '-' | '~' | '!' )
            {
            t=(Token)input.LT(1);
            if ( input.LA(1)==43||(input.LA(1)>=52 && input.LA(1)<=53)||input.LA(1)==73||(input.LA(1)>=89 && input.LA(1)<=91) ) {
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
            if ( state.backtracking>0 ) { memoize(input, 68, unaryOp_StartIndex); }
        }
        return op;
    }
    // $ANTLR end "unaryOp"


    // $ANTLR start "postfixExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1434:1: postfixExpr returns [Expression expr] : baseExpression ( '[' expression ']' | '(' ( topLevelExprList )? ')' | '::' ao= simpleIdentifier | '.' di= simpleIdentifier | '->' ai= simpleIdentifier | '++' | '--' )* ;
    public final Expression postfixExpr() throws RecognitionException {
        Expression expr = null;
        int postfixExpr_StartIndex = input.index();
        SimpleIdentifier ao = null;

        SimpleIdentifier di = null;

        SimpleIdentifier ai = null;

        Expression baseExpression40 = null;

        Expression expression41 = null;

        List<Expression> topLevelExprList42 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1435:2: ( baseExpression ( '[' expression ']' | '(' ( topLevelExprList )? ')' | '::' ao= simpleIdentifier | '.' di= simpleIdentifier | '->' ai= simpleIdentifier | '++' | '--' )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1436:3: baseExpression ( '[' expression ']' | '(' ( topLevelExprList )? ')' | '::' ao= simpleIdentifier | '.' di= simpleIdentifier | '->' ai= simpleIdentifier | '++' | '--' )*
            {
            pushFollow(FOLLOW_baseExpression_in_postfixExpr4617);
            baseExpression40=baseExpression();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = baseExpression40; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1437:3: ( '[' expression ']' | '(' ( topLevelExprList )? ')' | '::' ao= simpleIdentifier | '.' di= simpleIdentifier | '->' ai= simpleIdentifier | '++' | '--' )*
            loop102:
            do {
                int alt102=8;
                switch ( input.LA(1) ) {
                case 54:
                    {
                    alt102=1;
                    }
                    break;
                case 34:
                    {
                    alt102=2;
                    }
                    break;
                case 72:
                    {
                    alt102=3;
                    }
                    break;
                case 92:
                    {
                    alt102=4;
                    }
                    break;
                case 93:
                    {
                    alt102=5;
                    }
                    break;
                case 89:
                    {
                    alt102=6;
                    }
                    break;
                case 90:
                    {
                    alt102=7;
                    }
                    break;

                }

                switch (alt102) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1438:4: '[' expression ']'
            	    {
            	    match(input,54,FOLLOW_54_in_postfixExpr4628); if (state.failed) return expr;
            	    pushFollow(FOLLOW_expression_in_postfixExpr4630);
            	    expression41=expression();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    match(input,55,FOLLOW_55_in_postfixExpr4632); if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       
            	      				expr = new ArrayAccess(expr, expression41); 
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1441:4: '(' ( topLevelExprList )? ')'
            	    {
            	    match(input,34,FOLLOW_34_in_postfixExpr4641); if (state.failed) return expr;
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1441:8: ( topLevelExprList )?
            	    int alt101=2;
            	    int LA101_0 = input.LA(1);

            	    if ( ((LA101_0>=DECIMAL_NUMBER && LA101_0<=FLOAT_NUMBER)||LA101_0==31||LA101_0==34||(LA101_0>=42 && LA101_0<=43)||(LA101_0>=52 && LA101_0<=54)||(LA101_0>=73 && LA101_0<=75)||(LA101_0>=88 && LA101_0<=91)) ) {
            	        alt101=1;
            	    }
            	    switch (alt101) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: topLevelExprList
            	            {
            	            pushFollow(FOLLOW_topLevelExprList_in_postfixExpr4643);
            	            topLevelExprList42=topLevelExprList();

            	            state._fsp--;
            	            if (state.failed) return expr;

            	            }
            	            break;

            	    }

            	    match(input,35,FOLLOW_35_in_postfixExpr4646); if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {

            	      				FunctionCall fc = new FunctionCall(expr);
            	      				if (topLevelExprList42 != null)
            	      					for (Expression x : topLevelExprList42)
            	      						fc.addArgument(x);
            	      				expr = fc;
            	      			
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1448:4: '::' ao= simpleIdentifier
            	    {
            	    match(input,72,FOLLOW_72_in_postfixExpr4655); if (state.failed) return expr;
            	    pushFollow(FOLLOW_simpleIdentifier_in_postfixExpr4659);
            	    ao=simpleIdentifier();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {

            	      				expr = new MemberRef(expr, MemberRefStyle.Colons, ao); 
            	      			
            	    }

            	    }
            	    break;
            	case 4 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1451:4: '.' di= simpleIdentifier
            	    {
            	    match(input,92,FOLLOW_92_in_postfixExpr4668); if (state.failed) return expr;
            	    pushFollow(FOLLOW_simpleIdentifier_in_postfixExpr4672);
            	    di=simpleIdentifier();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       
            	      				expr = new MemberRef(expr, MemberRefStyle.Dot, di); 
            	      			
            	    }

            	    }
            	    break;
            	case 5 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1454:4: '->' ai= simpleIdentifier
            	    {
            	    match(input,93,FOLLOW_93_in_postfixExpr4681); if (state.failed) return expr;
            	    pushFollow(FOLLOW_simpleIdentifier_in_postfixExpr4685);
            	    ai=simpleIdentifier();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       
            	      				expr = new MemberRef(expr, MemberRefStyle.Arrow, ai); 
            	      			
            	    }

            	    }
            	    break;
            	case 6 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1457:4: '++'
            	    {
            	    match(input,89,FOLLOW_89_in_postfixExpr4694); if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       
            	      				expr = new UnaryOp(expr, UnaryOperator.PostIncr); 
            	      			
            	    }

            	    }
            	    break;
            	case 7 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1460:4: '--'
            	    {
            	    match(input,90,FOLLOW_90_in_postfixExpr4703); if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       
            	      				expr = new UnaryOp(expr, UnaryOperator.PostDecr); 
            	      			
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
            if ( state.backtracking>0 ) { memoize(input, 69, postfixExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "postfixExpr"

    public static class topLevelExpr_return extends ParserRuleReturnScope {
        public Expression expr;
    };

    // $ANTLR start "topLevelExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1466:1: topLevelExpr returns [Expression expr] : e= assignmentExpr ;
    public final ObjCppParser.topLevelExpr_return topLevelExpr() throws RecognitionException {
        ObjCppParser.topLevelExpr_return retval = new ObjCppParser.topLevelExpr_return();
        retval.start = input.LT(1);
        int topLevelExpr_StartIndex = input.index();
        Expression e = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return retval; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1467:2: (e= assignmentExpr )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1467:4: e= assignmentExpr
            {
            pushFollow(FOLLOW_assignmentExpr_in_topLevelExpr4727);
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
            if ( state.backtracking>0 ) { memoize(input, 70, topLevelExpr_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "topLevelExpr"


    // $ANTLR start "topLevelExprList"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1469:1: topLevelExprList returns [List<Expression> exprs] : e= topLevelExpr ( ',' f= topLevelExpr )* ;
    public final List<Expression> topLevelExprList() throws RecognitionException {
        List<Expression> exprs = null;
        int topLevelExprList_StartIndex = input.index();
        ObjCppParser.topLevelExpr_return e = null;

        ObjCppParser.topLevelExpr_return f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return exprs; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1470:2: (e= topLevelExpr ( ',' f= topLevelExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1471:3: e= topLevelExpr ( ',' f= topLevelExpr )*
            {
            if ( state.backtracking==0 ) {
               exprs = new ArrayList<Expression>(); 
            }
            pushFollow(FOLLOW_topLevelExpr_in_topLevelExprList4752);
            e=topLevelExpr();

            state._fsp--;
            if (state.failed) return exprs;
            if ( state.backtracking==0 ) {
               exprs.add((e!=null?e.expr:null)); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1473:3: ( ',' f= topLevelExpr )*
            loop103:
            do {
                int alt103=2;
                int LA103_0 = input.LA(1);

                if ( (LA103_0==28) ) {
                    alt103=1;
                }


                switch (alt103) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1474:4: ',' f= topLevelExpr
            	    {
            	    match(input,28,FOLLOW_28_in_topLevelExprList4763); if (state.failed) return exprs;
            	    pushFollow(FOLLOW_topLevelExpr_in_topLevelExprList4770);
            	    f=topLevelExpr();

            	    state._fsp--;
            	    if (state.failed) return exprs;
            	    if ( state.backtracking==0 ) {
            	       exprs.add((f!=null?f.expr:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop103;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 71, topLevelExprList_StartIndex); }
        }
        return exprs;
    }
    // $ANTLR end "topLevelExprList"


    // $ANTLR start "expression"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1479:1: expression returns [Expression expr] : l= topLevelExprList ;
    public final Expression expression() throws RecognitionException {
        Expression expr = null;
        int expression_StartIndex = input.index();
        List<Expression> l = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1480:2: (l= topLevelExprList )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1480:4: l= topLevelExprList
            {
            pushFollow(FOLLOW_topLevelExprList_in_expression4794);
            l=topLevelExprList();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {

              			if (l != null) {
              				if (l.size() == 1)
              					expr = l.get(0);
              				else
              					expr = new ExpressionSequence(l);
              			}
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 72, expression_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "expression"


    // $ANTLR start "statementsBlock"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1491:1: statementsBlock returns [Block stat] : '{' ( statement )* '}' ;
    public final Block statementsBlock() throws RecognitionException {
        Symbols_stack.push(new Symbols_scope());

        Block stat = null;
        int statementsBlock_StartIndex = input.index();
        Statement statement43 = null;



        	((Symbols_scope)Symbols_stack.peek()).typeIdentifiers = new HashSet<String>();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return stat; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1496:2: ( '{' ( statement )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1496:4: '{' ( statement )* '}'
            {
            if ( state.backtracking==0 ) {
               stat = new Block(); 
            }
            match(input,23,FOLLOW_23_in_statementsBlock4828); if (state.failed) return stat;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1498:3: ( statement )*
            loop104:
            do {
                int alt104=2;
                int LA104_0 = input.LA(1);

                if ( ((LA104_0>=DECIMAL_NUMBER && LA104_0<=FLOAT_NUMBER)||LA104_0==23||(LA104_0>=25 && LA104_0<=27)||(LA104_0>=30 && LA104_0<=32)||LA104_0==34||(LA104_0>=42 && LA104_0<=43)||(LA104_0>=48 && LA104_0<=54)||(LA104_0>=56 && LA104_0<=59)||(LA104_0>=73 && LA104_0<=75)||(LA104_0>=88 && LA104_0<=91)||(LA104_0>=94 && LA104_0<=95)||(LA104_0>=97 && LA104_0<=100)) ) {
                    alt104=1;
                }


                switch (alt104) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1499:4: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_statementsBlock4838);
            	    statement43=statement();

            	    state._fsp--;
            	    if (state.failed) return stat;
            	    if ( state.backtracking==0 ) {

            	      				stat.addStatement(statement43);
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop104;
                }
            } while (true);

            match(input,24,FOLLOW_24_in_statementsBlock4850); if (state.failed) return stat;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 73, statementsBlock_StartIndex); }
            Symbols_stack.pop();

        }
        return stat;
    }
    // $ANTLR end "statementsBlock"


    // $ANTLR start "statement"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1505:1: statement returns [Statement stat] : (b= statementsBlock | declaration | es= expression ';' | rt= 'return' rex= expression ';' | IDENTIFIER ':' | 'break' ';' | 'if' '(' topLevelExpr ')' statement ( 'else' statement )? | 'while' '(' topLevelExpr ')' statement | 'do' statement 'while' '(' topLevelExpr ')' ';' | 'for' '(' ( expression )? ';' ( expression )? ';' ( expression )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' topLevelExpr ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement );
    public final Statement statement() throws RecognitionException {
        Statement stat = null;
        int statement_StartIndex = input.index();
        Token rt=null;
        Block b = null;

        Expression es = null;

        Expression rex = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return stat; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1506:2: (b= statementsBlock | declaration | es= expression ';' | rt= 'return' rex= expression ';' | IDENTIFIER ':' | 'break' ';' | 'if' '(' topLevelExpr ')' statement ( 'else' statement )? | 'while' '(' topLevelExpr ')' statement | 'do' statement 'while' '(' topLevelExpr ')' ';' | 'for' '(' ( expression )? ';' ( expression )? ';' ( expression )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' topLevelExpr ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement )
            int alt110=13;
            alt110 = dfa110.predict(input);
            switch (alt110) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1507:3: b= statementsBlock
                    {
                    pushFollow(FOLLOW_statementsBlock_in_statement4869);
                    b=statementsBlock();

                    state._fsp--;
                    if (state.failed) return stat;
                    if ( state.backtracking==0 ) {
                       stat = b; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1508:3: declaration
                    {
                    pushFollow(FOLLOW_declaration_in_statement4877);
                    declaration();

                    state._fsp--;
                    if (state.failed) return stat;

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1509:3: es= expression ';'
                    {
                    pushFollow(FOLLOW_expression_in_statement4886);
                    es=expression();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,25,FOLLOW_25_in_statement4888); if (state.failed) return stat;
                    if ( state.backtracking==0 ) {
                       stat = new ExpressionStatement(es); 
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1510:3: rt= 'return' rex= expression ';'
                    {
                    rt=(Token)match(input,51,FOLLOW_51_in_statement4898); if (state.failed) return stat;
                    pushFollow(FOLLOW_expression_in_statement4902);
                    rex=expression();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,25,FOLLOW_25_in_statement4904); if (state.failed) return stat;
                    if ( state.backtracking==0 ) {
                       
                      			stat = mark(new Return(rex), getLine(rt));
                      		
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1513:3: IDENTIFIER ':'
                    {
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement4912); if (state.failed) return stat;
                    match(input,33,FOLLOW_33_in_statement4914); if (state.failed) return stat;

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1514:3: 'break' ';'
                    {
                    match(input,94,FOLLOW_94_in_statement4921); if (state.failed) return stat;
                    match(input,25,FOLLOW_25_in_statement4923); if (state.failed) return stat;

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1515:3: 'if' '(' topLevelExpr ')' statement ( 'else' statement )?
                    {
                    match(input,95,FOLLOW_95_in_statement4929); if (state.failed) return stat;
                    match(input,34,FOLLOW_34_in_statement4931); if (state.failed) return stat;
                    pushFollow(FOLLOW_topLevelExpr_in_statement4933);
                    topLevelExpr();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,35,FOLLOW_35_in_statement4935); if (state.failed) return stat;
                    pushFollow(FOLLOW_statement_in_statement4937);
                    statement();

                    state._fsp--;
                    if (state.failed) return stat;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1515:39: ( 'else' statement )?
                    int alt105=2;
                    int LA105_0 = input.LA(1);

                    if ( (LA105_0==96) ) {
                        int LA105_1 = input.LA(2);

                        if ( (synpred205_ObjCpp()) ) {
                            alt105=1;
                        }
                    }
                    switch (alt105) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1515:40: 'else' statement
                            {
                            match(input,96,FOLLOW_96_in_statement4940); if (state.failed) return stat;
                            pushFollow(FOLLOW_statement_in_statement4942);
                            statement();

                            state._fsp--;
                            if (state.failed) return stat;

                            }
                            break;

                    }


                    }
                    break;
                case 8 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1516:3: 'while' '(' topLevelExpr ')' statement
                    {
                    match(input,97,FOLLOW_97_in_statement4951); if (state.failed) return stat;
                    match(input,34,FOLLOW_34_in_statement4953); if (state.failed) return stat;
                    pushFollow(FOLLOW_topLevelExpr_in_statement4955);
                    topLevelExpr();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,35,FOLLOW_35_in_statement4957); if (state.failed) return stat;
                    pushFollow(FOLLOW_statement_in_statement4959);
                    statement();

                    state._fsp--;
                    if (state.failed) return stat;

                    }
                    break;
                case 9 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1517:3: 'do' statement 'while' '(' topLevelExpr ')' ';'
                    {
                    match(input,98,FOLLOW_98_in_statement4966); if (state.failed) return stat;
                    pushFollow(FOLLOW_statement_in_statement4968);
                    statement();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,97,FOLLOW_97_in_statement4970); if (state.failed) return stat;
                    match(input,34,FOLLOW_34_in_statement4972); if (state.failed) return stat;
                    pushFollow(FOLLOW_topLevelExpr_in_statement4974);
                    topLevelExpr();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,35,FOLLOW_35_in_statement4976); if (state.failed) return stat;
                    match(input,25,FOLLOW_25_in_statement4978); if (state.failed) return stat;

                    }
                    break;
                case 10 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1518:3: 'for' '(' ( expression )? ';' ( expression )? ';' ( expression )? ')' statement
                    {
                    match(input,99,FOLLOW_99_in_statement4985); if (state.failed) return stat;
                    match(input,34,FOLLOW_34_in_statement4987); if (state.failed) return stat;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1518:13: ( expression )?
                    int alt106=2;
                    int LA106_0 = input.LA(1);

                    if ( ((LA106_0>=DECIMAL_NUMBER && LA106_0<=FLOAT_NUMBER)||LA106_0==31||LA106_0==34||(LA106_0>=42 && LA106_0<=43)||(LA106_0>=52 && LA106_0<=54)||(LA106_0>=73 && LA106_0<=75)||(LA106_0>=88 && LA106_0<=91)) ) {
                        alt106=1;
                    }
                    switch (alt106) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement4989);
                            expression();

                            state._fsp--;
                            if (state.failed) return stat;

                            }
                            break;

                    }

                    match(input,25,FOLLOW_25_in_statement4992); if (state.failed) return stat;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1518:29: ( expression )?
                    int alt107=2;
                    int LA107_0 = input.LA(1);

                    if ( ((LA107_0>=DECIMAL_NUMBER && LA107_0<=FLOAT_NUMBER)||LA107_0==31||LA107_0==34||(LA107_0>=42 && LA107_0<=43)||(LA107_0>=52 && LA107_0<=54)||(LA107_0>=73 && LA107_0<=75)||(LA107_0>=88 && LA107_0<=91)) ) {
                        alt107=1;
                    }
                    switch (alt107) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement4994);
                            expression();

                            state._fsp--;
                            if (state.failed) return stat;

                            }
                            break;

                    }

                    match(input,25,FOLLOW_25_in_statement4997); if (state.failed) return stat;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1518:45: ( expression )?
                    int alt108=2;
                    int LA108_0 = input.LA(1);

                    if ( ((LA108_0>=DECIMAL_NUMBER && LA108_0<=FLOAT_NUMBER)||LA108_0==31||LA108_0==34||(LA108_0>=42 && LA108_0<=43)||(LA108_0>=52 && LA108_0<=54)||(LA108_0>=73 && LA108_0<=75)||(LA108_0>=88 && LA108_0<=91)) ) {
                        alt108=1;
                    }
                    switch (alt108) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement4999);
                            expression();

                            state._fsp--;
                            if (state.failed) return stat;

                            }
                            break;

                    }

                    match(input,35,FOLLOW_35_in_statement5002); if (state.failed) return stat;
                    pushFollow(FOLLOW_statement_in_statement5004);
                    statement();

                    state._fsp--;
                    if (state.failed) return stat;

                    }
                    break;
                case 11 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1519:3: 'switch' '(' expression ')' '{' ( 'case' topLevelExpr ':' | statement )* '}'
                    {
                    match(input,100,FOLLOW_100_in_statement5011); if (state.failed) return stat;
                    match(input,34,FOLLOW_34_in_statement5013); if (state.failed) return stat;
                    pushFollow(FOLLOW_expression_in_statement5015);
                    expression();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,35,FOLLOW_35_in_statement5017); if (state.failed) return stat;
                    match(input,23,FOLLOW_23_in_statement5019); if (state.failed) return stat;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1520:4: ( 'case' topLevelExpr ':' | statement )*
                    loop109:
                    do {
                        int alt109=3;
                        int LA109_0 = input.LA(1);

                        if ( (LA109_0==101) ) {
                            alt109=1;
                        }
                        else if ( ((LA109_0>=DECIMAL_NUMBER && LA109_0<=FLOAT_NUMBER)||LA109_0==23||(LA109_0>=25 && LA109_0<=27)||(LA109_0>=30 && LA109_0<=32)||LA109_0==34||(LA109_0>=42 && LA109_0<=43)||(LA109_0>=48 && LA109_0<=54)||(LA109_0>=56 && LA109_0<=59)||(LA109_0>=73 && LA109_0<=75)||(LA109_0>=88 && LA109_0<=91)||(LA109_0>=94 && LA109_0<=95)||(LA109_0>=97 && LA109_0<=100)) ) {
                            alt109=2;
                        }


                        switch (alt109) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1521:5: 'case' topLevelExpr ':'
                    	    {
                    	    match(input,101,FOLLOW_101_in_statement5032); if (state.failed) return stat;
                    	    pushFollow(FOLLOW_topLevelExpr_in_statement5034);
                    	    topLevelExpr();

                    	    state._fsp--;
                    	    if (state.failed) return stat;
                    	    match(input,33,FOLLOW_33_in_statement5036); if (state.failed) return stat;

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1522:5: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement5044);
                    	    statement();

                    	    state._fsp--;
                    	    if (state.failed) return stat;

                    	    }
                    	    break;

                    	default :
                    	    break loop109;
                        }
                    } while (true);

                    match(input,24,FOLLOW_24_in_statement5054); if (state.failed) return stat;

                    }
                    break;
                case 12 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1525:3: ';'
                    {
                    match(input,25,FOLLOW_25_in_statement5060); if (state.failed) return stat;

                    }
                    break;
                case 13 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1526:3: {...}? IDENTIFIER '(' varDecl ':' expression ')' statement
                    {
                    if ( !(( next("foreach") )) ) {
                        if (state.backtracking>0) {state.failed=true; return stat;}
                        throw new FailedPredicateException(input, "statement", " next(\"foreach\") ");
                    }
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement5068); if (state.failed) return stat;
                    match(input,34,FOLLOW_34_in_statement5070); if (state.failed) return stat;
                    pushFollow(FOLLOW_varDecl_in_statement5072);
                    varDecl();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,33,FOLLOW_33_in_statement5074); if (state.failed) return stat;
                    pushFollow(FOLLOW_expression_in_statement5076);
                    expression();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,35,FOLLOW_35_in_statement5078); if (state.failed) return stat;
                    pushFollow(FOLLOW_statement_in_statement5080);
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
            if ( state.backtracking>0 ) { memoize(input, 74, statement_StartIndex); }
        }
        return stat;
    }
    // $ANTLR end "statement"


    // $ANTLR start "constant"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1529:1: constant returns [Constant constant] : ( (s= ( '-' | '+' ) )? DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER | CHARACTER | (s2= ( '-' | '+' ) )? FLOAT_NUMBER | STRING );
    public final Constant constant() throws RecognitionException {
        Constant constant = null;
        int constant_StartIndex = input.index();
        Token s=null;
        Token s2=null;
        Token DECIMAL_NUMBER44=null;
        Token HEXADECIMAL_NUMBER45=null;
        Token OCTAL_NUMBER46=null;
        Token CHARACTER47=null;
        Token FLOAT_NUMBER48=null;
        Token STRING49=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return constant; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1530:2: ( (s= ( '-' | '+' ) )? DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER | CHARACTER | (s2= ( '-' | '+' ) )? FLOAT_NUMBER | STRING )
            int alt113=6;
            switch ( input.LA(1) ) {
            case 42:
            case 43:
                {
                int LA113_1 = input.LA(2);

                if ( (LA113_1==DECIMAL_NUMBER) ) {
                    alt113=1;
                }
                else if ( (LA113_1==FLOAT_NUMBER) ) {
                    alt113=5;
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
                {
                alt113=1;
                }
                break;
            case HEXADECIMAL_NUMBER:
                {
                alt113=2;
                }
                break;
            case OCTAL_NUMBER:
                {
                alt113=3;
                }
                break;
            case CHARACTER:
                {
                alt113=4;
                }
                break;
            case FLOAT_NUMBER:
                {
                alt113=5;
                }
                break;
            case STRING:
                {
                alt113=6;
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1530:4: (s= ( '-' | '+' ) )? DECIMAL_NUMBER
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1530:5: (s= ( '-' | '+' ) )?
                    int alt111=2;
                    int LA111_0 = input.LA(1);

                    if ( ((LA111_0>=42 && LA111_0<=43)) ) {
                        alt111=1;
                    }
                    switch (alt111) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: s= ( '-' | '+' )
                            {
                            s=(Token)input.LT(1);
                            if ( (input.LA(1)>=42 && input.LA(1)<=43) ) {
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

                    DECIMAL_NUMBER44=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_constant5108); if (state.failed) return constant;
                    if ( state.backtracking==0 ) {
                       constant =  Constant.parseDecimal(((s!=null?s.getText():null) == null ? "" : (s!=null?s.getText():null)) + (DECIMAL_NUMBER44!=null?DECIMAL_NUMBER44.getText():null)); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1531:3: HEXADECIMAL_NUMBER
                    {
                    HEXADECIMAL_NUMBER45=(Token)match(input,HEXADECIMAL_NUMBER,FOLLOW_HEXADECIMAL_NUMBER_in_constant5116); if (state.failed) return constant;
                    if ( state.backtracking==0 ) {
                       constant = Constant.parseHex((HEXADECIMAL_NUMBER45!=null?HEXADECIMAL_NUMBER45.getText():null)); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1532:3: OCTAL_NUMBER
                    {
                    OCTAL_NUMBER46=(Token)match(input,OCTAL_NUMBER,FOLLOW_OCTAL_NUMBER_in_constant5124); if (state.failed) return constant;
                    if ( state.backtracking==0 ) {
                       constant = Constant.parseOctal((OCTAL_NUMBER46!=null?OCTAL_NUMBER46.getText():null)); 
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1533:3: CHARACTER
                    {
                    CHARACTER47=(Token)match(input,CHARACTER,FOLLOW_CHARACTER_in_constant5132); if (state.failed) return constant;
                    if ( state.backtracking==0 ) {
                       constant =  Constant.parseCharOrStringInteger((CHARACTER47!=null?CHARACTER47.getText():null)); 
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1534:3: (s2= ( '-' | '+' ) )? FLOAT_NUMBER
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1534:5: (s2= ( '-' | '+' ) )?
                    int alt112=2;
                    int LA112_0 = input.LA(1);

                    if ( ((LA112_0>=42 && LA112_0<=43)) ) {
                        alt112=1;
                    }
                    switch (alt112) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: s2= ( '-' | '+' )
                            {
                            s2=(Token)input.LT(1);
                            if ( (input.LA(1)>=42 && input.LA(1)<=43) ) {
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

                    FLOAT_NUMBER48=(Token)match(input,FLOAT_NUMBER,FOLLOW_FLOAT_NUMBER_in_constant5151); if (state.failed) return constant;
                    if ( state.backtracking==0 ) {
                       constant = Constant.parseFloat(((s2!=null?s2.getText():null) == null ? "" : (s2!=null?s2.getText():null)) + (FLOAT_NUMBER48!=null?FLOAT_NUMBER48.getText():null)); 
                    }

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1536:3: STRING
                    {
                    STRING49=(Token)match(input,STRING,FOLLOW_STRING_in_constant5162); if (state.failed) return constant;
                    if ( state.backtracking==0 ) {
                       constant =  Constant.parseString((STRING49!=null?STRING49.getText():null)); 
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
            if ( state.backtracking>0 ) { memoize(input, 75, constant_StartIndex); }
        }
        return constant;
    }
    // $ANTLR end "constant"

    // $ANTLR start synpred6_ObjCpp
    public final void synpred6_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:358:5: ({...}? => pragmaContent )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:358:5: {...}? => pragmaContent
        {
        if ( !(( next("__pragma") )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred6_ObjCpp", " next(\"__pragma\") ");
        }
        pushFollow(FOLLOW_pragmaContent_in_synpred6_ObjCpp269);
        pragmaContent();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_ObjCpp

    // $ANTLR start synpred8_ObjCpp
    public final void synpred8_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:360:5: ( functionDeclaration )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:360:5: functionDeclaration
        {
        pushFollow(FOLLOW_functionDeclaration_in_synpred8_ObjCpp286);
        functionDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_ObjCpp

    // $ANTLR start synpred9_ObjCpp
    public final void synpred9_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:363:5: ( externDeclarations )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:363:5: externDeclarations
        {
        pushFollow(FOLLOW_externDeclarations_in_synpred9_ObjCpp296);
        externDeclarations();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_ObjCpp

    // $ANTLR start synpred10_ObjCpp
    public final void synpred10_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:366:5: ( varDecl ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:366:5: varDecl ';'
        {
        pushFollow(FOLLOW_varDecl_in_synpred10_ObjCpp306);
        varDecl();

        state._fsp--;
        if (state.failed) return ;
        match(input,25,FOLLOW_25_in_synpred10_ObjCpp308); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_ObjCpp

    // $ANTLR start synpred21_ObjCpp
    public final void synpred21_ObjCpp_fragment() throws RecognitionException {   
        List<Modifier> m2 = null;

        Enum nb = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:477:6: (m2= modifiers nb= enumBody )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:477:6: m2= modifiers nb= enumBody
        {
        pushFollow(FOLLOW_modifiers_in_synpred21_ObjCpp678);
        m2=modifiers();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_enumBody_in_synpred21_ObjCpp689);
        nb=enumBody();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_ObjCpp

    // $ANTLR start synpred24_ObjCpp
    public final void synpred24_ObjCpp_fragment() throws RecognitionException {   
        Token parentClass=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:512:4: ( ( ':' parentClass= IDENTIFIER )? )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:512:4: ( ':' parentClass= IDENTIFIER )?
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:512:4: ( ':' parentClass= IDENTIFIER )?
        int alt117=2;
        int LA117_0 = input.LA(1);

        if ( (LA117_0==33) ) {
            alt117=1;
        }
        switch (alt117) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:513:5: ':' parentClass= IDENTIFIER
                {
                match(input,33,FOLLOW_33_in_synpred24_ObjCpp767); if (state.failed) return ;
                parentClass=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred24_ObjCpp771); if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred24_ObjCpp

    // $ANTLR start synpred31_ObjCpp
    public final void synpred31_ObjCpp_fragment() throws RecognitionException {   
        VariablesDeclaration fv = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:539:7: (fv= varDecl ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:539:7: fv= varDecl ';'
        {
        pushFollow(FOLLOW_varDecl_in_synpred31_ObjCpp935);
        fv=varDecl();

        state._fsp--;
        if (state.failed) return ;
        match(input,25,FOLLOW_25_in_synpred31_ObjCpp937); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_ObjCpp

    // $ANTLR start synpred32_ObjCpp
    public final void synpred32_ObjCpp_fragment() throws RecognitionException {   
        VariablesDeclaration fv = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:537:5: ( ( (fv= varDecl ';' | functionPointerVarDecl ) ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:537:5: ( (fv= varDecl ';' | functionPointerVarDecl ) )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:537:5: ( (fv= varDecl ';' | functionPointerVarDecl ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:538:6: (fv= varDecl ';' | functionPointerVarDecl )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:538:6: (fv= varDecl ';' | functionPointerVarDecl )
        int alt121=2;
        alt121 = dfa121.predict(input);
        switch (alt121) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:539:7: fv= varDecl ';'
                {
                pushFollow(FOLLOW_varDecl_in_synpred32_ObjCpp935);
                fv=varDecl();

                state._fsp--;
                if (state.failed) return ;
                match(input,25,FOLLOW_25_in_synpred32_ObjCpp937); if (state.failed) return ;

                }
                break;
            case 2 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:542:7: functionPointerVarDecl
                {
                pushFollow(FOLLOW_functionPointerVarDecl_in_synpred32_ObjCpp949);
                functionPointerVarDecl();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred32_ObjCpp

    // $ANTLR start synpred36_ObjCpp
    public final void synpred36_ObjCpp_fragment() throws RecognitionException {   
        VariablesDeclaration vd = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:558:4: (vd= varDecl ';' {...}?)
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:558:4: vd= varDecl ';' {...}?
        {
        pushFollow(FOLLOW_varDecl_in_synpred36_ObjCpp1014);
        vd=varDecl();

        state._fsp--;
        if (state.failed) return ;
        match(input,25,FOLLOW_25_in_synpred36_ObjCpp1016); if (state.failed) return ;
        if ( !(( !(vd instanceof VariablesDeclaration) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred36_ObjCpp", " !($vd.decl instanceof VariablesDeclaration) ");
        }

        }
    }
    // $ANTLR end synpred36_ObjCpp

    // $ANTLR start synpred38_ObjCpp
    public final void synpred38_ObjCpp_fragment() throws RecognitionException {   
        TypeRef returnTypeRef = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:584:18: (returnTypeRef= mutableTypeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:584:18: returnTypeRef= mutableTypeRef
        {
        pushFollow(FOLLOW_mutableTypeRef_in_synpred38_ObjCpp1102);
        returnTypeRef=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_ObjCpp

    // $ANTLR start synpred46_ObjCpp
    public final void synpred46_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:630:5: ( declaration )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:630:5: declaration
        {
        pushFollow(FOLLOW_declaration_in_synpred46_ObjCpp1304);
        declaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_ObjCpp

    // $ANTLR start synpred47_ObjCpp
    public final void synpred47_ObjCpp_fragment() throws RecognitionException {   
        Token bits=null;
        VariablesDeclaration fv = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:633:5: (fv= varDecl ':' bits= DECIMAL_NUMBER ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:633:5: fv= varDecl ':' bits= DECIMAL_NUMBER ';'
        {
        pushFollow(FOLLOW_varDecl_in_synpred47_ObjCpp1316);
        fv=varDecl();

        state._fsp--;
        if (state.failed) return ;
        match(input,33,FOLLOW_33_in_synpred47_ObjCpp1318); if (state.failed) return ;
        bits=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_synpred47_ObjCpp1322); if (state.failed) return ;
        match(input,25,FOLLOW_25_in_synpred47_ObjCpp1324); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_ObjCpp

    // $ANTLR start synpred53_ObjCpp
    public final void synpred53_ObjCpp_fragment() throws RecognitionException {   
        List<Modifier> m2 = null;

        ObjCppParser.qualifiedIdentifier_return parent = null;

        Struct nb = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:679:6: ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:679:6: (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:679:6: (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:680:7: m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody
        {
        pushFollow(FOLLOW_modifiers_in_synpred53_ObjCpp1450);
        m2=modifiers();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:681:7: ( ':' ( 'public' )? parent= qualifiedIdentifier )?
        int alt129=2;
        int LA129_0 = input.LA(1);

        if ( (LA129_0==33) ) {
            alt129=1;
        }
        switch (alt129) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:682:8: ':' ( 'public' )? parent= qualifiedIdentifier
                {
                match(input,33,FOLLOW_33_in_synpred53_ObjCpp1469); if (state.failed) return ;
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:683:8: ( 'public' )?
                int alt128=2;
                int LA128_0 = input.LA(1);

                if ( (LA128_0==45) ) {
                    alt128=1;
                }
                switch (alt128) {
                    case 1 :
                        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: 'public'
                        {
                        match(input,45,FOLLOW_45_in_synpred53_ObjCpp1478); if (state.failed) return ;

                        }
                        break;

                }

                pushFollow(FOLLOW_qualifiedIdentifier_in_synpred53_ObjCpp1490);
                parent=qualifiedIdentifier();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }

        pushFollow(FOLLOW_structBody_in_synpred53_ObjCpp1510);
        nb=structBody();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred53_ObjCpp

    // $ANTLR start synpred54_ObjCpp
    public final void synpred54_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:704:4: ( binaryOp )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:704:4: binaryOp
        {
        pushFollow(FOLLOW_binaryOp_in_synpred54_ObjCpp1558);
        binaryOp();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_ObjCpp

    // $ANTLR start synpred55_ObjCpp
    public final void synpred55_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:705:3: ( unaryOp )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:705:3: unaryOp
        {
        pushFollow(FOLLOW_unaryOp_in_synpred55_ObjCpp1567);
        unaryOp();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred55_ObjCpp

    // $ANTLR start synpred56_ObjCpp
    public final void synpred56_ObjCpp_fragment() throws RecognitionException {   
        TypeRef returnTypeRef = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:720:16: (returnTypeRef= mutableTypeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:720:16: returnTypeRef= mutableTypeRef
        {
        pushFollow(FOLLOW_mutableTypeRef_in_synpred56_ObjCpp1619);
        returnTypeRef=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_ObjCpp

    // $ANTLR start synpred61_ObjCpp
    public final void synpred61_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:760:7: ( modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:760:7: modifier
        {
        pushFollow(FOLLOW_modifier_in_synpred61_ObjCpp1788);
        modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred61_ObjCpp

    // $ANTLR start synpred71_ObjCpp
    public final void synpred71_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:769:4: ( ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:769:4: ';'
        {
        match(input,25,FOLLOW_25_in_synpred71_ObjCpp1870); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred71_ObjCpp

    // $ANTLR start synpred72_ObjCpp
    public final void synpred72_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:777:3: ({...}? => pragmaContent )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:777:3: {...}? => pragmaContent
        {
        if ( !(( next("__pragma") )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred72_ObjCpp", " next(\"__pragma\") ");
        }
        pushFollow(FOLLOW_pragmaContent_in_synpred72_ObjCpp1902);
        pragmaContent();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred72_ObjCpp

    // $ANTLR start synpred73_ObjCpp
    public final void synpred73_ObjCpp_fragment() throws RecognitionException {   
        Token ex=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:778:3: ({...}? => IDENTIFIER ex= STRING )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:778:3: {...}? => IDENTIFIER ex= STRING
        {
        if ( !(( next("extern") )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred73_ObjCpp", " next(\"extern\") ");
        }
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred73_ObjCpp1912); if (state.failed) return ;
        ex=(Token)match(input,STRING,FOLLOW_STRING_in_synpred73_ObjCpp1916); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred73_ObjCpp

    // $ANTLR start synpred74_ObjCpp
    public final void synpred74_ObjCpp_fragment() throws RecognitionException {   
        Token m=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:781:3: ({...}?m= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:781:3: {...}?m= IDENTIFIER
        {
        if ( !(( Modifier.parseModifier(next()) != null )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred74_ObjCpp", " Modifier.parseModifier(next()) != null ");
        }
        m=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred74_ObjCpp1928); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred74_ObjCpp

    // $ANTLR start synpred75_ObjCpp
    public final void synpred75_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:784:3: ({...}? => IDENTIFIER '(' 'return' binaryOp expression ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:784:3: {...}? => IDENTIFIER '(' 'return' binaryOp expression ')'
        {
        if ( !(( next("__success") )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred75_ObjCpp", " next(\"__success\") ");
        }
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred75_ObjCpp1941); if (state.failed) return ;
        match(input,34,FOLLOW_34_in_synpred75_ObjCpp1943); if (state.failed) return ;
        match(input,51,FOLLOW_51_in_synpred75_ObjCpp1945); if (state.failed) return ;
        pushFollow(FOLLOW_binaryOp_in_synpred75_ObjCpp1947);
        binaryOp();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred75_ObjCpp1949);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred75_ObjCpp1952); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred75_ObjCpp

    // $ANTLR start synpred76_ObjCpp
    public final void synpred76_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:788:3: ({...}? => IDENTIFIER '(' expression ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:788:3: {...}? => IDENTIFIER '(' expression ')'
        {
        if ( !(( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred76_ObjCpp", " next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ");
        }
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred76_ObjCpp1969); if (state.failed) return ;
        match(input,34,FOLLOW_34_in_synpred76_ObjCpp1971); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred76_ObjCpp1973);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred76_ObjCpp1975); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred76_ObjCpp

    // $ANTLR start synpred78_ObjCpp
    public final void synpred78_ObjCpp_fragment() throws RecognitionException {   
        Token an=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:794:4: ( (an= STRING )* )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:794:4: (an= STRING )*
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:794:4: (an= STRING )*
        loop132:
        do {
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( (LA132_0==STRING) ) {
                alt132=1;
            }


            switch (alt132) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:794:6: an= STRING
        	    {
        	    an=(Token)match(input,STRING,FOLLOW_STRING_in_synpred78_ObjCpp2004); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop132;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred78_ObjCpp

    // $ANTLR start synpred80_ObjCpp
    public final void synpred80_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:836:4: ( declarator )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:836:4: declarator
        {
        pushFollow(FOLLOW_declarator_in_synpred80_ObjCpp2111);
        declarator();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred80_ObjCpp

    // $ANTLR start synpred82_ObjCpp
    public final void synpred82_ObjCpp_fragment() throws RecognitionException {   
        TypeRef tr = null;

        ObjCppParser.topLevelExpr_return dv = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:824:4: ( (tr= mutableTypeRef ) ( ( declarator )? ) ( '=' dv= topLevelExpr )? )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:824:4: (tr= mutableTypeRef ) ( ( declarator )? ) ( '=' dv= topLevelExpr )?
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:824:4: (tr= mutableTypeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:825:4: tr= mutableTypeRef
        {
        pushFollow(FOLLOW_mutableTypeRef_in_synpred82_ObjCpp2096);
        tr=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;

        }

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:835:3: ( ( declarator )? )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:836:4: ( declarator )?
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:836:4: ( declarator )?
        int alt133=2;
        int LA133_0 = input.LA(1);

        if ( (LA133_0==IDENTIFIER||LA133_0==34||(LA133_0>=52 && LA133_0<=53)||LA133_0==57) ) {
            alt133=1;
        }
        switch (alt133) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: declarator
                {
                pushFollow(FOLLOW_declarator_in_synpred82_ObjCpp2111);
                declarator();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:850:3: ( '=' dv= topLevelExpr )?
        int alt134=2;
        int LA134_0 = input.LA(1);

        if ( (LA134_0==29) ) {
            alt134=1;
        }
        switch (alt134) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:850:4: '=' dv= topLevelExpr
                {
                match(input,29,FOLLOW_29_in_synpred82_ObjCpp2123); if (state.failed) return ;
                pushFollow(FOLLOW_topLevelExpr_in_synpred82_ObjCpp2127);
                dv=topLevelExpr();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred82_ObjCpp

    // $ANTLR start synpred86_ObjCpp
    public final void synpred86_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:883:20: ( templateArgDecl ( ',' templateArgDecl )* )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:883:20: templateArgDecl ( ',' templateArgDecl )*
        {
        pushFollow(FOLLOW_templateArgDecl_in_synpred86_ObjCpp2245);
        templateArgDecl();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:883:36: ( ',' templateArgDecl )*
        loop135:
        do {
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==28) ) {
                alt135=1;
            }


            switch (alt135) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:883:37: ',' templateArgDecl
        	    {
        	    match(input,28,FOLLOW_28_in_synpred86_ObjCpp2248); if (state.failed) return ;
        	    pushFollow(FOLLOW_templateArgDecl_in_synpred86_ObjCpp2250);
        	    templateArgDecl();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop135;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred86_ObjCpp

    // $ANTLR start synpred89_ObjCpp
    public final void synpred89_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:900:4: (a1= argDef ( ',' ax= argDef )* )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:900:4: a1= argDef ( ',' ax= argDef )*
        {
        pushFollow(FOLLOW_argDef_in_synpred89_ObjCpp2326);
        a1=argDef();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:904:4: ( ',' ax= argDef )*
        loop136:
        do {
            int alt136=2;
            int LA136_0 = input.LA(1);

            if ( (LA136_0==28) ) {
                alt136=1;
            }


            switch (alt136) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:905:5: ',' ax= argDef
        	    {
        	    match(input,28,FOLLOW_28_in_synpred89_ObjCpp2339); if (state.failed) return ;
        	    pushFollow(FOLLOW_argDef_in_synpred89_ObjCpp2348);
        	    ax=argDef();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop136;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred89_ObjCpp

    // $ANTLR start synpred91_ObjCpp
    public final void synpred91_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:920:4: (a1= argDef ( ',' ax= argDef )* )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:920:4: a1= argDef ( ',' ax= argDef )*
        {
        pushFollow(FOLLOW_argDef_in_synpred91_ObjCpp2401);
        a1=argDef();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:924:4: ( ',' ax= argDef )*
        loop137:
        do {
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==28) ) {
                alt137=1;
            }


            switch (alt137) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:925:5: ',' ax= argDef
        	    {
        	    match(input,28,FOLLOW_28_in_synpred91_ObjCpp2414); if (state.failed) return ;
        	    pushFollow(FOLLOW_argDef_in_synpred91_ObjCpp2423);
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
    // $ANTLR end synpred91_ObjCpp

    // $ANTLR start synpred92_ObjCpp
    public final void synpred92_ObjCpp_fragment() throws RecognitionException {   
        TypeMutator m1 = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:939:4: ( (m1= typeMutator ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:939:4: (m1= typeMutator )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:939:4: (m1= typeMutator )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:940:5: m1= typeMutator
        {
        pushFollow(FOLLOW_typeMutator_in_synpred92_ObjCpp2479);
        m1=typeMutator();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred92_ObjCpp

    // $ANTLR start synpred93_ObjCpp
    public final void synpred93_ObjCpp_fragment() throws RecognitionException {   
        FunctionSignature f1 = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:944:4: ( (f1= functionSignatureSuffix ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:944:4: (f1= functionSignatureSuffix )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:944:4: (f1= functionSignatureSuffix )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:945:5: f1= functionSignatureSuffix
        {
        pushFollow(FOLLOW_functionSignatureSuffix_in_synpred93_ObjCpp2501);
        f1=functionSignatureSuffix();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred93_ObjCpp

    // $ANTLR start synpred95_ObjCpp
    public final void synpred95_ObjCpp_fragment() throws RecognitionException {   
        FunctionSignature fs = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:962:4: ( ( typeMutator )* (fs= functionSignatureSuffix ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:962:4: ( typeMutator )* (fs= functionSignatureSuffix )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:962:4: ( typeMutator )*
        loop138:
        do {
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( ((LA138_0>=52 && LA138_0<=54)) ) {
                alt138=1;
            }


            switch (alt138) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:963:5: typeMutator
        	    {
        	    pushFollow(FOLLOW_typeMutator_in_synpred95_ObjCpp2547);
        	    typeMutator();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop138;
            }
        } while (true);

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:967:4: (fs= functionSignatureSuffix )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:968:5: fs= functionSignatureSuffix
        {
        pushFollow(FOLLOW_functionSignatureSuffix_in_synpred95_ObjCpp2568);
        fs=functionSignatureSuffix();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred95_ObjCpp

    // $ANTLR start synpred99_ObjCpp
    public final void synpred99_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.topLevelExpr_return dv = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:996:4: ( '=' dv= topLevelExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:996:4: '=' dv= topLevelExpr
        {
        match(input,29,FOLLOW_29_in_synpred99_ObjCpp2678); if (state.failed) return ;
        pushFollow(FOLLOW_topLevelExpr_in_synpred99_ObjCpp2686);
        dv=topLevelExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred99_ObjCpp

    // $ANTLR start synpred103_ObjCpp
    public final void synpred103_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1069:4: ({...}? => IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1069:4: {...}? => IDENTIFIER
        {
        if ( !(( Modifier.parseModifier(next()) == null )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred103_ObjCpp", " Modifier.parseModifier(next()) == null ");
        }
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred103_ObjCpp2933); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred103_ObjCpp

    // $ANTLR start synpred107_ObjCpp
    public final void synpred107_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.argDef_return ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1112:5: ( ',' ax= argDef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1112:5: ',' ax= argDef
        {
        match(input,28,FOLLOW_28_in_synpred107_ObjCpp3054); if (state.failed) return ;
        pushFollow(FOLLOW_argDef_in_synpred107_ObjCpp3063);
        ax=argDef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred107_ObjCpp

    // $ANTLR start synpred109_ObjCpp
    public final void synpred109_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1107:4: (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1107:4: a1= argDef ( ',' ax= argDef )* ( ',' '...' )?
        {
        pushFollow(FOLLOW_argDef_in_synpred109_ObjCpp3041);
        a1=argDef();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1111:4: ( ',' ax= argDef )*
        loop140:
        do {
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==28) ) {
                int LA140_1 = input.LA(2);

                if ( (LA140_1==44) ) {
                    int LA140_3 = input.LA(3);

                    if ( (synpred107_ObjCpp()) ) {
                        alt140=1;
                    }


                }
                else if ( (LA140_1==EOF||LA140_1==IDENTIFIER||(LA140_1>=28 && LA140_1<=30)||LA140_1==34||(LA140_1>=48 && LA140_1<=50)||(LA140_1>=52 && LA140_1<=54)||LA140_1==57||LA140_1==59) ) {
                    alt140=1;
                }


            }


            switch (alt140) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1112:5: ',' ax= argDef
        	    {
        	    match(input,28,FOLLOW_28_in_synpred109_ObjCpp3054); if (state.failed) return ;
        	    pushFollow(FOLLOW_argDef_in_synpred109_ObjCpp3063);
        	    ax=argDef();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop140;
            }
        } while (true);

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1117:4: ( ',' '...' )?
        int alt141=2;
        int LA141_0 = input.LA(1);

        if ( (LA141_0==28) ) {
            alt141=1;
        }
        switch (alt141) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1118:5: ',' '...'
                {
                match(input,28,FOLLOW_28_in_synpred109_ObjCpp3083); if (state.failed) return ;
                match(input,44,FOLLOW_44_in_synpred109_ObjCpp3085); if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred109_ObjCpp

    // $ANTLR start synpred111_ObjCpp
    public final void synpred111_ObjCpp_fragment() throws RecognitionException {   
        TypeRef an = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1166:4: ({...}? =>an= typeName )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1166:4: {...}? =>an= typeName
        {
        if ( !(( 
        				isTypeIdentifier(next()) || 
        				(
        					Modifier.parseModifier(next(1)) == null && 
        					!next(2, "=", ",", ";", ":", "[", "(", ")")
        				) 
        			)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred111_ObjCpp", " \n\t\t\t\tisTypeIdentifier(next()) || \n\t\t\t\t(\n\t\t\t\t\tModifier.parseModifier(next(1)) == null && \n\t\t\t\t\t!next(2, \"=\", \",\", \";\", \":\", \"[\", \"(\", \")\")\n\t\t\t\t) \n\t\t\t");
        }
        pushFollow(FOLLOW_typeName_in_synpred111_ObjCpp3166);
        an=typeName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred111_ObjCpp

    // $ANTLR start synpred134_ObjCpp
    public final void synpred134_ObjCpp_fragment() throws RecognitionException {   
        TypeRef tr = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1224:4: (tr= mutableTypeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1224:4: tr= mutableTypeRef
        {
        pushFollow(FOLLOW_mutableTypeRef_in_synpred134_ObjCpp3425);
        tr=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred134_ObjCpp

    // $ANTLR start synpred136_ObjCpp
    public final void synpred136_ObjCpp_fragment() throws RecognitionException {   
        Expression a1 = null;

        Expression ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1236:5: (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1236:5: a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )*
        {
        pushFollow(FOLLOW_typeRefOrExpression_in_synpred136_ObjCpp3476);
        a1=typeRefOrExpression();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1237:5: ( ',' ax= typeRefOrExpression )*
        loop143:
        do {
            int alt143=2;
            int LA143_0 = input.LA(1);

            if ( (LA143_0==28) ) {
                alt143=1;
            }


            switch (alt143) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1238:6: ',' ax= typeRefOrExpression
        	    {
        	    match(input,28,FOLLOW_28_in_synpred136_ObjCpp3491); if (state.failed) return ;
        	    pushFollow(FOLLOW_typeRefOrExpression_in_synpred136_ObjCpp3501);
        	    ax=typeRefOrExpression();

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
    // $ANTLR end synpred136_ObjCpp

    // $ANTLR start synpred137_ObjCpp
    public final void synpred137_ObjCpp_fragment() throws RecognitionException {   
        Expression a1 = null;

        Expression ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1235:4: ( '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1235:4: '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>'
        {
        match(input,36,FOLLOW_36_in_synpred137_ObjCpp3466); if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1235:8: (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )?
        int alt145=2;
        int LA145_0 = input.LA(1);

        if ( ((LA145_0>=DECIMAL_NUMBER && LA145_0<=FLOAT_NUMBER)||LA145_0==28||(LA145_0>=30 && LA145_0<=31)||LA145_0==34||(LA145_0>=42 && LA145_0<=43)||(LA145_0>=48 && LA145_0<=50)||(LA145_0>=52 && LA145_0<=54)||LA145_0==59||(LA145_0>=73 && LA145_0<=75)||(LA145_0>=88 && LA145_0<=91)) ) {
            alt145=1;
        }
        else if ( (LA145_0==37) ) {
            int LA145_2 = input.LA(2);

            if ( (synpred136_ObjCpp()) ) {
                alt145=1;
            }
        }
        switch (alt145) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1236:5: a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )*
                {
                pushFollow(FOLLOW_typeRefOrExpression_in_synpred137_ObjCpp3476);
                a1=typeRefOrExpression();

                state._fsp--;
                if (state.failed) return ;
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1237:5: ( ',' ax= typeRefOrExpression )*
                loop144:
                do {
                    int alt144=2;
                    int LA144_0 = input.LA(1);

                    if ( (LA144_0==28) ) {
                        alt144=1;
                    }


                    switch (alt144) {
                	case 1 :
                	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1238:6: ',' ax= typeRefOrExpression
                	    {
                	    match(input,28,FOLLOW_28_in_synpred137_ObjCpp3491); if (state.failed) return ;
                	    pushFollow(FOLLOW_typeRefOrExpression_in_synpred137_ObjCpp3501);
                	    ax=typeRefOrExpression();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }
                	    break;

                	default :
                	    break loop144;
                    }
                } while (true);


                }
                break;

        }

        match(input,37,FOLLOW_37_in_synpred137_ObjCpp3520); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred137_ObjCpp

    // $ANTLR start synpred148_ObjCpp
    public final void synpred148_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.assignmentOp_return op = null;

        Expression f = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1312:4: (op= assignmentOp f= assignmentExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1312:4: op= assignmentOp f= assignmentExpr
        {
        pushFollow(FOLLOW_assignmentOp_in_synpred148_ObjCpp3833);
        op=assignmentOp();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_assignmentExpr_in_synpred148_ObjCpp3837);
        f=assignmentExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred148_ObjCpp

    // $ANTLR start synpred178_ObjCpp
    public final void synpred178_ObjCpp_fragment() throws RecognitionException {   
        Token op=null;
        Expression f = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1408:4: (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1408:4: op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr
        {
        op=(Token)input.LT(1);
        if ( (input.LA(1)>=36 && input.LA(1)<=37)||(input.LA(1)>=68 && input.LA(1)<=69) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }

        pushFollow(FOLLOW_shiftExpr_in_synpred178_ObjCpp4441);
        f=shiftExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred178_ObjCpp

    // $ANTLR start synpred179_ObjCpp
    public final void synpred179_ObjCpp_fragment() throws RecognitionException {   
        TypeRef tr = null;

        Expression inner = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1414:4: ( '(' tr= mutableTypeRef ')' inner= castExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1414:4: '(' tr= mutableTypeRef ')' inner= castExpr
        {
        match(input,34,FOLLOW_34_in_synpred179_ObjCpp4463); if (state.failed) return ;
        pushFollow(FOLLOW_mutableTypeRef_in_synpred179_ObjCpp4467);
        tr=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred179_ObjCpp4469); if (state.failed) return ;
        pushFollow(FOLLOW_castExpr_in_synpred179_ObjCpp4473);
        inner=castExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred179_ObjCpp

    // $ANTLR start synpred180_ObjCpp
    public final void synpred180_ObjCpp_fragment() throws RecognitionException {   
        Expression p = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1420:3: (p= postfixExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1420:3: p= postfixExpr
        {
        pushFollow(FOLLOW_postfixExpr_in_synpred180_ObjCpp4506);
        p=postfixExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred180_ObjCpp

    // $ANTLR start synpred181_ObjCpp
    public final void synpred181_ObjCpp_fragment() throws RecognitionException {   
        Expression.UnaryOperator uo = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1421:3: (uo= unaryOp castExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1421:3: uo= unaryOp castExpr
        {
        pushFollow(FOLLOW_unaryOp_in_synpred181_ObjCpp4516);
        uo=unaryOp();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_castExpr_in_synpred181_ObjCpp4518);
        castExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred181_ObjCpp

    // $ANTLR start synpred182_ObjCpp
    public final void synpred182_ObjCpp_fragment() throws RecognitionException {   
        TypeRef tr = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1423:4: ( '(' tr= mutableTypeRef ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1423:4: '(' tr= mutableTypeRef ')'
        {
        match(input,34,FOLLOW_34_in_synpred182_ObjCpp4533); if (state.failed) return ;
        pushFollow(FOLLOW_mutableTypeRef_in_synpred182_ObjCpp4537);
        tr=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred182_ObjCpp4539); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred182_ObjCpp

    // $ANTLR start synpred200_ObjCpp
    public final void synpred200_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1508:3: ( declaration )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1508:3: declaration
        {
        pushFollow(FOLLOW_declaration_in_synpred200_ObjCpp4877);
        declaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred200_ObjCpp

    // $ANTLR start synpred201_ObjCpp
    public final void synpred201_ObjCpp_fragment() throws RecognitionException {   
        Expression es = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1509:3: (es= expression ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1509:3: es= expression ';'
        {
        pushFollow(FOLLOW_expression_in_synpred201_ObjCpp4886);
        es=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,25,FOLLOW_25_in_synpred201_ObjCpp4888); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred201_ObjCpp

    // $ANTLR start synpred203_ObjCpp
    public final void synpred203_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1513:3: ( IDENTIFIER ':' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1513:3: IDENTIFIER ':'
        {
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred203_ObjCpp4912); if (state.failed) return ;
        match(input,33,FOLLOW_33_in_synpred203_ObjCpp4914); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred203_ObjCpp

    // $ANTLR start synpred205_ObjCpp
    public final void synpred205_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1515:40: ( 'else' statement )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1515:40: 'else' statement
        {
        match(input,96,FOLLOW_96_in_synpred205_ObjCpp4940); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred205_ObjCpp4942);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred205_ObjCpp

    // $ANTLR start synpred216_ObjCpp
    public final void synpred216_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1525:3: ( ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1525:3: ';'
        {
        match(input,25,FOLLOW_25_in_synpred216_ObjCpp5060); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred216_ObjCpp

    // Delegated rules

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
    public final boolean synpred55_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred216_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred216_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred180_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred180_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred200_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred200_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred179_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred179_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred137_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred137_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred71_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred71_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred181_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred181_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred136_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred136_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred205_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred205_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred72_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred72_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred32_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred134_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred134_ObjCpp_fragment(); // can never throw exception
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
    public final boolean synpred38_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_ObjCpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred178_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred178_ObjCpp_fragment(); // can never throw exception
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
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA60 dfa60 = new DFA60(this);
    protected DFA77 dfa77 = new DFA77(this);
    protected DFA80 dfa80 = new DFA80(this);
    protected DFA86 dfa86 = new DFA86(this);
    protected DFA97 dfa97 = new DFA97(this);
    protected DFA98 dfa98 = new DFA98(this);
    protected DFA99 dfa99 = new DFA99(this);
    protected DFA110 dfa110 = new DFA110(this);
    protected DFA121 dfa121 = new DFA121(this);
    static final String DFA6_eotS =
        "\22\uffff";
    static final String DFA6_eofS =
        "\22\uffff";
    static final String DFA6_minS =
        "\1\6\1\0\1\uffff\6\0\11\uffff";
    static final String DFA6_maxS =
        "\1\111\1\0\1\uffff\6\0\11\uffff";
    static final String DFA6_acceptS =
        "\2\uffff\1\2\6\uffff\1\3\1\5\1\uffff\1\6\1\7\1\10\1\11\1\1\1\4";
    static final String DFA6_specialS =
        "\1\uffff\1\0\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\11\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1\22\uffff\1\12\1\17\1\16\2\uffff\1\5\2\14\1\uffff\1\10\15"+
            "\uffff\3\4\1\uffff\2\6\1\7\1\uffff\1\2\1\12\1\15\1\3\15\uffff"+
            "\1\11",
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
            return "357:4: ({...}? => pragmaContent | templateDef | functionDeclaration | externDeclarations | varDecl ';' | objCClassDef | typeDef | forwardClassDecl | 'namespace' ns= IDENTIFIER '{' (subD= declaration )* '}' )";
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

                        else if ( (((synpred10_ObjCpp()&&( next("__success") ))||(synpred10_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred10_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||(synpred10_ObjCpp()&&( next("__pragma") ))||synpred10_ObjCpp()||(synpred10_ObjCpp()&&( next("extern") ))||(synpred10_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) )))) ) {s = 10;}

                         
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
        "\1\111\1\0\15\uffff";
    static final String DFA12_acceptS =
        "\2\uffff\1\1\1\2\13\uffff";
    static final String DFA12_specialS =
        "\1\uffff\1\0\15\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\1\20\uffff\1\2\1\uffff\1\3\2\uffff\2\3\3\uffff\3\3\1\uffff"+
            "\1\3\16\uffff\3\3\2\uffff\1\3\17\uffff\1\3",
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
            return "476:5: (m2= modifiers nb= enumBody | )";
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
                        if ( (((synpred21_ObjCpp()&&( next("__success") ))||(synpred21_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred21_ObjCpp()&&( next("extern") ))||(synpred21_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred21_ObjCpp()&&( next("__pragma") ))||(synpred21_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") )))) ) {s = 2;}

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
    static final String DFA19_eotS =
        "\13\uffff";
    static final String DFA19_eofS =
        "\13\uffff";
    static final String DFA19_minS =
        "\1\6\7\0\1\uffff\1\0\1\uffff";
    static final String DFA19_maxS =
        "\1\73\7\0\1\uffff\1\0\1\uffff";
    static final String DFA19_acceptS =
        "\10\uffff\1\1\1\uffff\1\2";
    static final String DFA19_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\7\1\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\1\22\uffff\1\11\4\uffff\1\4\3\uffff\1\7\15\uffff\3\3\1\uffff"+
            "\2\5\1\6\2\uffff\1\10\1\uffff\1\2",
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
            return "538:6: (fv= varDecl ';' | functionPointerVarDecl )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA19_1 = input.LA(1);

                         
                        int index19_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred31_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||(synpred31_ObjCpp()&&( next("__success") ))||(synpred31_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred31_ObjCpp()&&( next("__pragma") ))||(synpred31_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred31_ObjCpp()&&( next("extern") ))||synpred31_ObjCpp())) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index19_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA19_2 = input.LA(1);

                         
                        int index19_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index19_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA19_3 = input.LA(1);

                         
                        int index19_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index19_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA19_4 = input.LA(1);

                         
                        int index19_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index19_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA19_5 = input.LA(1);

                         
                        int index19_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index19_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA19_6 = input.LA(1);

                         
                        int index19_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index19_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA19_7 = input.LA(1);

                         
                        int index19_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index19_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA19_9 = input.LA(1);

                         
                        int index19_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index19_9);
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
    static final String DFA30_eotS =
        "\25\uffff";
    static final String DFA30_eofS =
        "\25\uffff";
    static final String DFA30_minS =
        "\1\6\4\uffff\1\0\1\uffff\6\0\1\uffff\1\0\6\uffff";
    static final String DFA30_maxS =
        "\1\111\4\uffff\1\0\1\uffff\6\0\1\uffff\1\0\6\uffff";
    static final String DFA30_acceptS =
        "\1\uffff\1\4\1\1\3\uffff\1\2\15\uffff\1\3";
    static final String DFA30_specialS =
        "\5\uffff\1\0\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\7\6\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\5\21\uffff\1\1\3\6\2\uffff\1\11\2\6\1\24\1\14\12\uffff\3"+
            "\2\3\10\1\uffff\2\12\1\13\1\uffff\1\6\1\16\1\6\1\7\15\uffff"+
            "\1\6",
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
            return "()* loopback of 624:4: ( ( 'public' | 'private' | 'protected' ) ':' | declaration | fv= varDecl ':' bits= DECIMAL_NUMBER ';' )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA30_5 = input.LA(1);

                         
                        int index30_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred46_ObjCpp()) ) {s = 6;}

                        else if ( (((synpred47_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||(synpred47_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred47_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred47_ObjCpp()&&( next("extern") ))||(synpred47_ObjCpp()&&( next("__success") ))||(synpred47_ObjCpp()&&( next("__pragma") ))||synpred47_ObjCpp())) ) {s = 20;}

                         
                        input.seek(index30_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA30_7 = input.LA(1);

                         
                        int index30_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred46_ObjCpp()) ) {s = 6;}

                        else if ( (synpred47_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index30_7);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA30_8 = input.LA(1);

                         
                        int index30_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred46_ObjCpp()) ) {s = 6;}

                        else if ( (synpred47_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index30_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA30_9 = input.LA(1);

                         
                        int index30_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred46_ObjCpp()) ) {s = 6;}

                        else if ( (synpred47_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index30_9);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA30_10 = input.LA(1);

                         
                        int index30_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred46_ObjCpp()) ) {s = 6;}

                        else if ( (synpred47_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index30_10);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA30_11 = input.LA(1);

                         
                        int index30_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred46_ObjCpp()) ) {s = 6;}

                        else if ( (synpred47_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index30_11);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA30_12 = input.LA(1);

                         
                        int index30_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred46_ObjCpp()) ) {s = 6;}

                        else if ( (synpred47_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index30_12);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA30_14 = input.LA(1);

                         
                        int index30_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred46_ObjCpp()) ) {s = 6;}

                        else if ( (synpred47_ObjCpp()) ) {s = 20;}

                         
                        input.seek(index30_14);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 30, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA33_eotS =
        "\17\uffff";
    static final String DFA33_eofS =
        "\1\4\16\uffff";
    static final String DFA33_minS =
        "\1\6\2\0\14\uffff";
    static final String DFA33_maxS =
        "\1\111\2\0\14\uffff";
    static final String DFA33_acceptS =
        "\3\uffff\1\1\1\2\12\uffff";
    static final String DFA33_specialS =
        "\1\uffff\1\0\1\1\14\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\1\20\uffff\1\3\1\uffff\1\4\2\uffff\2\4\3\uffff\1\2\2\4\1"+
            "\uffff\1\4\16\uffff\3\4\2\uffff\1\4\17\uffff\1\4",
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
            return "678:5: ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA33_1 = input.LA(1);

                         
                        int index33_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred53_ObjCpp()&&( next("__pragma") ))||(synpred53_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred53_ObjCpp()&&( next("extern") ))||(synpred53_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||(synpred53_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred53_ObjCpp()&&( next("__success") )))) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index33_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA33_2 = input.LA(1);

                         
                        int index33_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_ObjCpp()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index33_2);
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
    static final String DFA60_eotS =
        "\16\uffff";
    static final String DFA60_eofS =
        "\1\1\15\uffff";
    static final String DFA60_minS =
        "\1\6\4\uffff\2\0\7\uffff";
    static final String DFA60_maxS =
        "\1\111\4\uffff\2\0\7\uffff";
    static final String DFA60_acceptS =
        "\1\uffff\1\3\12\uffff\1\1\1\2";
    static final String DFA60_specialS =
        "\5\uffff\1\0\1\1\7\uffff}>";
    static final String[] DFA60_transitionS = {
            "\1\1\22\uffff\1\1\2\uffff\2\1\4\uffff\1\5\1\1\1\uffff\1\1\16"+
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
            return "()* loopback of 938:3: ( (m1= typeMutator ) | (f1= functionSignatureSuffix ) )*";
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
                        if ( (synpred93_ObjCpp()) ) {s = 13;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index60_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA60_6 = input.LA(1);

                         
                        int index60_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_ObjCpp()) ) {s = 12;}

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
    static final String DFA77_eotS =
        "\30\uffff";
    static final String DFA77_eofS =
        "\1\2\27\uffff";
    static final String DFA77_minS =
        "\1\4\1\0\3\uffff\3\0\20\uffff";
    static final String DFA77_maxS =
        "\1\133\1\0\3\uffff\3\0\20\uffff";
    static final String DFA77_acceptS =
        "\2\uffff\1\1\10\uffff\1\2\14\uffff";
    static final String DFA77_specialS =
        "\1\uffff\1\0\3\uffff\1\1\1\2\1\3\20\uffff}>";
    static final String[] DFA77_transitionS = {
            "\2\13\1\1\4\13\21\uffff\1\2\1\uffff\1\2\1\13\2\uffff\1\7\2\uffff"+
            "\1\2\4\uffff\2\13\4\uffff\3\2\1\uffff\2\5\1\6\4\uffff\1\2\15"+
            "\uffff\3\13\14\uffff\4\13",
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
            return "1223:1: typeRefOrExpression returns [Expression expr] : (tr= mutableTypeRef | e= topLevelExpr );";
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
                        if ( (((synpred134_ObjCpp()&&( next("__success") ))||(synpred134_ObjCpp()&&( next("__pragma") ))||(synpred134_ObjCpp()&&( next("extern") ))||(synpred134_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred134_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred134_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||synpred134_ObjCpp())) ) {s = 2;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index77_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA77_5 = input.LA(1);

                         
                        int index77_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred134_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index77_5);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA77_6 = input.LA(1);

                         
                        int index77_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred134_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index77_6);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA77_7 = input.LA(1);

                         
                        int index77_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred134_ObjCpp()) ) {s = 2;}

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
            "\1\2\20\uffff\3\2\2\uffff\2\2\3\uffff\3\2\1\1\1\2\4\uffff\2"+
            "\2\10\uffff\4\2\1\uffff\1\2\2\uffff\3\2\1\uffff\12\2\2\uffff"+
            "\14\2\1\uffff\2\2\1\uffff\2\2",
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
            return "1234:3: ( '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>' )?";
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
                        if ( (synpred137_ObjCpp()) ) {s = 34;}

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
        "\1\126\1\0\12\uffff";
    static final String DFA86_acceptS =
        "\2\uffff\1\2\4\uffff\1\1\4\uffff";
    static final String DFA86_specialS =
        "\1\uffff\1\0\12\uffff}>";
    static final String[] DFA86_transitionS = {
            "\1\2\21\uffff\2\2\2\uffff\1\2\1\1\3\uffff\1\2\1\uffff\1\2\1"+
            "\uffff\1\2\21\uffff\1\2\24\uffff\13\7",
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
            return "1311:3: (op= assignmentOp f= assignmentExpr )?";
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
                        if ( (synpred148_ObjCpp()) ) {s = 7;}

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
        "\1\127\13\uffff\1\0\7\uffff";
    static final String DFA97_acceptS =
        "\1\uffff\1\2\21\uffff\1\1";
    static final String DFA97_specialS =
        "\14\uffff\1\0\7\uffff}>";
    static final String[] DFA97_transitionS = {
            "\1\1\21\uffff\2\1\2\uffff\2\1\3\uffff\1\1\1\uffff\1\1\1\23\1"+
            "\14\17\uffff\1\1\1\uffff\1\1\1\uffff\1\1\7\uffff\3\1\2\23\2"+
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
            return "()* loopback of 1407:3: (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )*";
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
                        if ( (synpred178_ObjCpp()) ) {s = 19;}

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
        "\22\uffff";
    static final String DFA98_eofS =
        "\22\uffff";
    static final String DFA98_minS =
        "\1\4\1\0\20\uffff";
    static final String DFA98_maxS =
        "\1\133\1\0\20\uffff";
    static final String DFA98_acceptS =
        "\2\uffff\1\2\16\uffff\1\1";
    static final String DFA98_specialS =
        "\1\uffff\1\0\20\uffff}>";
    static final String[] DFA98_transitionS = {
            "\7\2\24\uffff\1\2\2\uffff\1\1\7\uffff\2\2\10\uffff\3\2\22\uffff"+
            "\3\2\14\uffff\4\2",
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
            return "1413:1: castExpr returns [Expression expr] : ( '(' tr= mutableTypeRef ')' inner= castExpr | e= unaryExpr );";
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
                        if ( (synpred179_ObjCpp()) ) {s = 17;}

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
        "\22\uffff";
    static final String DFA99_eofS =
        "\22\uffff";
    static final String DFA99_minS =
        "\1\4\1\0\20\uffff";
    static final String DFA99_maxS =
        "\1\133\1\0\20\uffff";
    static final String DFA99_acceptS =
        "\2\uffff\1\2\16\uffff\1\1";
    static final String DFA99_specialS =
        "\1\uffff\1\0\20\uffff}>";
    static final String[] DFA99_transitionS = {
            "\7\2\24\uffff\1\2\2\uffff\1\1\7\uffff\2\2\10\uffff\3\2\22\uffff"+
            "\3\2\14\uffff\4\2",
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
            return "1422:12: ( '(' tr= mutableTypeRef ')' | unaryExpr )";
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
                        if ( (synpred182_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index99_1);
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
    static final String DFA110_eotS =
        "\50\uffff";
    static final String DFA110_eofS =
        "\50\uffff";
    static final String DFA110_minS =
        "\1\4\1\uffff\1\0\4\uffff\4\0\1\uffff\2\0\32\uffff";
    static final String DFA110_maxS =
        "\1\144\1\uffff\1\0\4\uffff\4\0\1\uffff\2\0\32\uffff";
    static final String DFA110_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\15\uffff\1\3\14\uffff\1\4\1\6\1\7\1\10"+
        "\1\11\1\12\1\13\1\5\1\15\1\14";
    static final String DFA110_specialS =
        "\2\uffff\1\0\4\uffff\1\1\1\2\1\3\1\4\1\uffff\1\5\1\6\32\uffff}>";
    static final String[] DFA110_transitionS = {
            "\2\21\1\2\4\21\14\uffff\1\1\1\uffff\1\14\2\3\2\uffff\1\3\1\15"+
            "\1\3\1\uffff\1\11\7\uffff\2\21\4\uffff\3\3\1\36\2\7\1\10\1\uffff"+
            "\4\3\15\uffff\1\12\2\21\14\uffff\4\21\2\uffff\1\37\1\40\1\uffff"+
            "\1\41\1\42\1\43\1\44",
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
            return "1505:1: statement returns [Statement stat] : (b= statementsBlock | declaration | es= expression ';' | rt= 'return' rex= expression ';' | IDENTIFIER ':' | 'break' ';' | 'if' '(' topLevelExpr ')' statement ( 'else' statement )? | 'while' '(' topLevelExpr ')' statement | 'do' statement 'while' '(' topLevelExpr ')' ';' | 'for' '(' ( expression )? ';' ( expression )? ';' ( expression )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' topLevelExpr ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA110_2 = input.LA(1);

                         
                        int index110_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred200_ObjCpp()) ) {s = 3;}

                        else if ( (synpred201_ObjCpp()) ) {s = 17;}

                        else if ( (synpred203_ObjCpp()) ) {s = 37;}

                        else if ( (( next("foreach") )) ) {s = 38;}

                         
                        input.seek(index110_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA110_7 = input.LA(1);

                         
                        int index110_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred200_ObjCpp()) ) {s = 3;}

                        else if ( (synpred201_ObjCpp()) ) {s = 17;}

                         
                        input.seek(index110_7);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA110_8 = input.LA(1);

                         
                        int index110_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred200_ObjCpp()) ) {s = 3;}

                        else if ( (synpred201_ObjCpp()) ) {s = 17;}

                         
                        input.seek(index110_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA110_9 = input.LA(1);

                         
                        int index110_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred200_ObjCpp()) ) {s = 3;}

                        else if ( (synpred201_ObjCpp()) ) {s = 17;}

                         
                        input.seek(index110_9);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA110_10 = input.LA(1);

                         
                        int index110_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred200_ObjCpp()) ) {s = 3;}

                        else if ( (synpred201_ObjCpp()) ) {s = 17;}

                         
                        input.seek(index110_10);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA110_12 = input.LA(1);

                         
                        int index110_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred200_ObjCpp()) ) {s = 3;}

                        else if ( (synpred216_ObjCpp()) ) {s = 39;}

                         
                        input.seek(index110_12);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA110_13 = input.LA(1);

                         
                        int index110_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred200_ObjCpp()) ) {s = 3;}

                        else if ( (synpred201_ObjCpp()) ) {s = 17;}

                         
                        input.seek(index110_13);
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
    static final String DFA121_eotS =
        "\13\uffff";
    static final String DFA121_eofS =
        "\13\uffff";
    static final String DFA121_minS =
        "\1\6\7\0\1\uffff\1\0\1\uffff";
    static final String DFA121_maxS =
        "\1\73\7\0\1\uffff\1\0\1\uffff";
    static final String DFA121_acceptS =
        "\10\uffff\1\1\1\uffff\1\2";
    static final String DFA121_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\7\1\uffff}>";
    static final String[] DFA121_transitionS = {
            "\1\1\22\uffff\1\11\4\uffff\1\4\3\uffff\1\7\15\uffff\3\3\1\uffff"+
            "\2\5\1\6\2\uffff\1\10\1\uffff\1\2",
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
            return "538:6: (fv= varDecl ';' | functionPointerVarDecl )";
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
                        if ( (((synpred31_ObjCpp()&&( next("__success") ))||(synpred31_ObjCpp()&&( next("__pragma") ))||(synpred31_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred31_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred31_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||synpred31_ObjCpp()||(synpred31_ObjCpp()&&( next("extern") )))) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index121_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA121_2 = input.LA(1);

                         
                        int index121_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index121_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA121_3 = input.LA(1);

                         
                        int index121_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index121_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA121_4 = input.LA(1);

                         
                        int index121_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index121_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA121_5 = input.LA(1);

                         
                        int index121_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index121_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA121_6 = input.LA(1);

                         
                        int index121_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index121_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA121_7 = input.LA(1);

                         
                        int index121_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index121_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA121_9 = input.LA(1);

                         
                        int index121_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index121_9);
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
    public static final BitSet FOLLOW_declaration_in_sourceFile150 = new BitSet(new long[]{0x0D070001CC400040L,0x0000000000000200L});
    public static final BitSet FOLLOW_lineDirective_in_sourceFile159 = new BitSet(new long[]{0x0D070001CC400040L,0x0000000000000200L});
    public static final BitSet FOLLOW_EOF_in_sourceFile172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_externDeclarations191 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_externDeclarations195 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_externDeclarations201 = new BitSet(new long[]{0x0D070001CD000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_declaration_in_externDeclarations215 = new BitSet(new long[]{0x0D070001CD000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_24_in_externDeclarations228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pragmaContent_in_declaration269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_templateDef_in_declaration277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_declaration286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_externDeclarations_in_declaration296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_declaration306 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_declaration308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objCClassDef_in_declaration318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeDef_in_declaration328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forwardClassDecl_in_declaration338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_declaration348 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_declaration352 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_declaration354 = new BitSet(new long[]{0x0D070001CD000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_declaration_in_declaration372 = new BitSet(new long[]{0x0D070001CD000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_24_in_declaration388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_forwardClassDecl428 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_forwardClassDecl435 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_28_in_forwardClassDecl442 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_forwardClassDecl449 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_25_in_forwardClassDecl460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_functionPointerVarDecl480 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_functionPointerVarDecl488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enumItem506 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_enumItem509 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_topLevelExpr_in_enumItem513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_enumBody539 = new BitSet(new long[]{0x0000000001000040L});
    public static final BitSet FOLLOW_enumItem_in_enumBody555 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_28_in_enumBody570 = new BitSet(new long[]{0x0000000011000040L});
    public static final BitSet FOLLOW_enumItem_in_enumBody581 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_24_in_enumBody602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_enumCore625 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_modifiers_in_enumCore636 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_enumBody_in_enumCore651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedIdentifier_in_enumCore663 = new BitSet(new long[]{0x0000000000800042L});
    public static final BitSet FOLLOW_modifiers_in_enumCore678 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_enumBody_in_enumCore689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_objCClassDef738 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef749 = new BitSet(new long[]{0x0C070E1640800040L});
    public static final BitSet FOLLOW_33_in_objCClassDef767 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef771 = new BitSet(new long[]{0x0C070E1040800040L});
    public static final BitSet FOLLOW_34_in_objCClassDef786 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef790 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCClassDef792 = new BitSet(new long[]{0x0C070E1040800040L});
    public static final BitSet FOLLOW_36_in_objCClassDef808 = new BitSet(new long[]{0x0000002000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef818 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_objCClassDef833 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCClassDef843 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_objCClassDef860 = new BitSet(new long[]{0x0C070E0040800040L});
    public static final BitSet FOLLOW_23_in_objCClassDef874 = new BitSet(new long[]{0x080701C041000040L});
    public static final BitSet FOLLOW_38_in_objCClassDef886 = new BitSet(new long[]{0x080701C041000040L});
    public static final BitSet FOLLOW_39_in_objCClassDef897 = new BitSet(new long[]{0x080701C041000040L});
    public static final BitSet FOLLOW_40_in_objCClassDef908 = new BitSet(new long[]{0x080701C041000040L});
    public static final BitSet FOLLOW_varDecl_in_objCClassDef935 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_objCClassDef937 = new BitSet(new long[]{0x080701C041000040L});
    public static final BitSet FOLLOW_functionPointerVarDecl_in_objCClassDef949 = new BitSet(new long[]{0x080701C041000040L});
    public static final BitSet FOLLOW_24_in_objCClassDef976 = new BitSet(new long[]{0x0C070E0040000040L});
    public static final BitSet FOLLOW_objCMethodDecl_in_objCClassDef994 = new BitSet(new long[]{0x0C070E0040000040L});
    public static final BitSet FOLLOW_typeDef_in_objCClassDef1003 = new BitSet(new long[]{0x0C070E0040000040L});
    public static final BitSet FOLLOW_varDecl_in_objCClassDef1014 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_objCClassDef1016 = new BitSet(new long[]{0x0C070E0040000040L});
    public static final BitSet FOLLOW_41_in_objCClassDef1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_objCMethodDecl1063 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_43_in_objCMethodDecl1075 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl1094 = new BitSet(new long[]{0x0807000840000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_objCMethodDecl1102 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl1110 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1121 = new BitSet(new long[]{0x0000000202000000L});
    public static final BitSet FOLLOW_33_in_objCMethodDecl1133 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl1135 = new BitSet(new long[]{0x0807000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_objCMethodDecl1139 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl1141 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1145 = new BitSet(new long[]{0x0000000012000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1160 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodDecl1162 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl1169 = new BitSet(new long[]{0x0807000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_objCMethodDecl1173 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl1175 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1184 = new BitSet(new long[]{0x0000000012000040L});
    public static final BitSet FOLLOW_28_in_objCMethodDecl1203 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_objCMethodDecl1205 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_objCMethodDecl1222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_structBody1243 = new BitSet(new long[]{0x0D07E001CD000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_45_in_structBody1261 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_46_in_structBody1273 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_47_in_structBody1285 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_structBody1296 = new BitSet(new long[]{0x0D07E001CD000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_declaration_in_structBody1304 = new BitSet(new long[]{0x0D07E001CD000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_varDecl_in_structBody1316 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_structBody1318 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_structBody1322 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_structBody1324 = new BitSet(new long[]{0x0D07E001CD000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_24_in_structBody1336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_structCore1377 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_modifiers_in_structCore1398 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_structBody_in_structCore1413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedIdentifier_in_structCore1425 = new BitSet(new long[]{0x0000000200800042L});
    public static final BitSet FOLLOW_modifiers_in_structCore1450 = new BitSet(new long[]{0x0000000200800000L});
    public static final BitSet FOLLOW_33_in_structCore1469 = new BitSet(new long[]{0x0000200000000040L});
    public static final BitSet FOLLOW_45_in_structCore1478 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_qualifiedIdentifier_in_structCore1490 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_structBody_in_structCore1510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binaryOp_in_anyOp1558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryOp_in_anyOp1567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentOp_in_anyOp1576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_functionDeclaration1611 = new BitSet(new long[]{0x0807000040000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_mutableTypeRef_in_functionDeclaration1619 = new BitSet(new long[]{0x0807000040000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_modifiers_in_functionDeclaration1628 = new BitSet(new long[]{0x0807000040000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_qualifiedCppFunctionName_in_functionDeclaration1636 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_argList_in_functionDeclaration1642 = new BitSet(new long[]{0x0000000202800040L});
    public static final BitSet FOLLOW_modifiers_in_functionDeclaration1650 = new BitSet(new long[]{0x0000000202800040L});
    public static final BitSet FOLLOW_33_in_functionDeclaration1661 = new BitSet(new long[]{0x0807000040000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_constructorInitializer_in_functionDeclaration1668 = new BitSet(new long[]{0x0000000212800040L});
    public static final BitSet FOLLOW_28_in_functionDeclaration1681 = new BitSet(new long[]{0x0807000040000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_constructorInitializer_in_functionDeclaration1685 = new BitSet(new long[]{0x0000000212800040L});
    public static final BitSet FOLLOW_25_in_functionDeclaration1708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_functionDeclaration1715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedCppFunctionName_in_constructorInitializer1738 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_constructorInitializer1746 = new BitSet(new long[]{0x00700C0C800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_topLevelExprList_in_constructorInitializer1755 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_constructorInitializer1764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_modifiers1788 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_IDENTIFIER_in_pragmaContent1814 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pragmaContent1816 = new BitSet(new long[]{0x00000C0E100007F0L});
    public static final BitSet FOLLOW_IDENTIFIER_in_pragmaContent1823 = new BitSet(new long[]{0x00000C0E100007F0L});
    public static final BitSet FOLLOW_constant_in_pragmaContent1827 = new BitSet(new long[]{0x00000C0E100007F0L});
    public static final BitSet FOLLOW_28_in_pragmaContent1831 = new BitSet(new long[]{0x00000C0E100007F0L});
    public static final BitSet FOLLOW_33_in_pragmaContent1835 = new BitSet(new long[]{0x00000C0E100007F0L});
    public static final BitSet FOLLOW_34_in_pragmaContent1839 = new BitSet(new long[]{0x00000C0A100007F0L});
    public static final BitSet FOLLOW_IDENTIFIER_in_pragmaContent1842 = new BitSet(new long[]{0x00000C0A100007F0L});
    public static final BitSet FOLLOW_constant_in_pragmaContent1846 = new BitSet(new long[]{0x00000C0A100007F0L});
    public static final BitSet FOLLOW_28_in_pragmaContent1850 = new BitSet(new long[]{0x00000C0A100007F0L});
    public static final BitSet FOLLOW_33_in_pragmaContent1854 = new BitSet(new long[]{0x00000C0A100007F0L});
    public static final BitSet FOLLOW_35_in_pragmaContent1858 = new BitSet(new long[]{0x00000C0E100007F0L});
    public static final BitSet FOLLOW_35_in_pragmaContent1865 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_pragmaContent1870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pragmaContent_in_modifier1902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier1912 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_modifier1916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier1928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier1941 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_modifier1943 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_modifier1945 = new BitSet(new long[]{0xF2300C3000000000L,0x00000000000000FFL});
    public static final BitSet FOLLOW_binaryOp_in_modifier1947 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_modifier1949 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_modifier1952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier1969 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_modifier1971 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_modifier1973 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_modifier1975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier1989 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_modifier1993 = new BitSet(new long[]{0x0000000800000060L});
    public static final BitSet FOLLOW_STRING_in_modifier2004 = new BitSet(new long[]{0x0000000800000020L});
    public static final BitSet FOLLOW_extendedModifiers_in_modifier2016 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_modifier2024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_extendedModifiers2053 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_mutableTypeRef_in_argDef2096 = new BitSet(new long[]{0x0230000420000042L});
    public static final BitSet FOLLOW_declarator_in_argDef2111 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_argDef2123 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_topLevelExpr_in_argDef2127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_argDef2141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_typeMutator2163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_typeMutator2177 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_typeMutator2179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_arrayTypeMutator2197 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_arrayTypeMutator2203 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_arrayTypeMutator2212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_templateDef2240 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_templateDef2242 = new BitSet(new long[]{0x0807102040000040L});
    public static final BitSet FOLLOW_templateArgDecl_in_templateDef2245 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_templateDef2248 = new BitSet(new long[]{0x0807100040000040L});
    public static final BitSet FOLLOW_templateArgDecl_in_templateDef2250 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_templateDef2257 = new BitSet(new long[]{0x0D070001CC000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_declaration_in_templateDef2261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argDef_in_templateArgDecl2276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffix2296 = new BitSet(new long[]{0x0010000000000040L});
    public static final BitSet FOLLOW_modifiers_in_functionSignatureSuffix2300 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_functionSignatureSuffix2302 = new BitSet(new long[]{0x0000000800000040L});
    public static final BitSet FOLLOW_modifiers_in_functionSignatureSuffix2306 = new BitSet(new long[]{0x0000000800000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionSignatureSuffix2308 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffix2311 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffix2317 = new BitSet(new long[]{0x0807100840000040L});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffix2326 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_functionSignatureSuffix2339 = new BitSet(new long[]{0x0807100040000040L});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffix2348 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffix2363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffixNoName2380 = new BitSet(new long[]{0x0010000000000040L});
    public static final BitSet FOLLOW_modifiers_in_functionSignatureSuffixNoName2382 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_functionSignatureSuffixNoName2384 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffixNoName2386 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffixNoName2392 = new BitSet(new long[]{0x0807100840000040L});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffixNoName2401 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_functionSignatureSuffixNoName2414 = new BitSet(new long[]{0x0807100040000040L});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffixNoName2423 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffixNoName2438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefCore_in_mutableTypeRef2458 = new BitSet(new long[]{0x0070000400000002L});
    public static final BitSet FOLLOW_typeMutator_in_mutableTypeRef2479 = new BitSet(new long[]{0x0070000400000002L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_mutableTypeRef2501 = new BitSet(new long[]{0x0070000400000002L});
    public static final BitSet FOLLOW_typeRefCore_in_nonMutableTypeRef2530 = new BitSet(new long[]{0x0070000400000002L});
    public static final BitSet FOLLOW_typeMutator_in_nonMutableTypeRef2547 = new BitSet(new long[]{0x0070000400000000L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_nonMutableTypeRef2568 = new BitSet(new long[]{0x0070000400000002L});
    public static final BitSet FOLLOW_modifiers_in_declarator2599 = new BitSet(new long[]{0x0230000400000040L});
    public static final BitSet FOLLOW_directDeclarator_in_declarator2615 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_set_in_declarator2639 = new BitSet(new long[]{0x0230000400000040L});
    public static final BitSet FOLLOW_declarator_in_declarator2657 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_declarator2678 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_topLevelExpr_in_declarator2686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_typeDef2722 = new BitSet(new long[]{0x0807000040000040L});
    public static final BitSet FOLLOW_varDecl_in_typeDef2727 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_typeDef2729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_varDeclEOF2747 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_varDeclEOF2749 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_varDeclEOF2751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_declarationEOF2771 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_declarationEOF2773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nonMutableTypeRef_in_varDecl2795 = new BitSet(new long[]{0x0230000400000042L});
    public static final BitSet FOLLOW_declaratorsList_in_varDecl2808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_objCProtocolRefList2827 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCProtocolRefList2832 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_objCProtocolRefList2842 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCProtocolRefList2848 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_objCProtocolRefList2858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarator_in_declaratorsList2879 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_declaratorsList2890 = new BitSet(new long[]{0x0230000400000040L});
    public static final BitSet FOLLOW_declarator_in_declaratorsList2898 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_directDeclarator2933 = new BitSet(new long[]{0x0040000400000002L});
    public static final BitSet FOLLOW_34_in_directDeclarator2943 = new BitSet(new long[]{0x0230000400000040L});
    public static final BitSet FOLLOW_declarator_in_directDeclarator2947 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_directDeclarator2949 = new BitSet(new long[]{0x0040000400000002L});
    public static final BitSet FOLLOW_54_in_directDeclarator2965 = new BitSet(new long[]{0x00F00C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_directDeclarator2977 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_directDeclarator2993 = new BitSet(new long[]{0x0040000400000002L});
    public static final BitSet FOLLOW_argList_in_directDeclarator3001 = new BitSet(new long[]{0x0040000400000002L});
    public static final BitSet FOLLOW_34_in_argList3029 = new BitSet(new long[]{0x0807100840000040L});
    public static final BitSet FOLLOW_argDef_in_argList3041 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_argList3054 = new BitSet(new long[]{0x0807100040000040L});
    public static final BitSet FOLLOW_argDef_in_argList3063 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_argList3083 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_argList3085 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_argList3104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_typeRefCore3137 = new BitSet(new long[]{0x0807000040000040L});
    public static final BitSet FOLLOW_59_in_typeRefCore3148 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_typeName_in_typeRefCore3152 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_typeName_in_typeRefCore3166 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_structCore_in_typeRefCore3175 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_enumCore_in_typeRefCore3184 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_modifiers_in_typeRefCore3197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedIdentifier_in_typeName3219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_objCMethodCall3239 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3243 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodCall3247 = new BitSet(new long[]{0x0080000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodCall3258 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3262 = new BitSet(new long[]{0x0080000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodCall3277 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodCall3279 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3283 = new BitSet(new long[]{0x0080000000000040L});
    public static final BitSet FOLLOW_55_in_objCMethodCall3300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_binaryOp3318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_typeRefOrExpression3425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_topLevelExpr_in_typeRefOrExpression3436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_simpleIdentifier3455 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_simpleIdentifier3466 = new BitSet(new long[]{0x08770C24C00007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_typeRefOrExpression_in_simpleIdentifier3476 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_simpleIdentifier3491 = new BitSet(new long[]{0x08770C04C00007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_typeRefOrExpression_in_simpleIdentifier3501 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_simpleIdentifier3520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleIdentifier_in_qualifiedIdentifier3542 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_qualifiedIdentifier3553 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_simpleIdentifier_in_qualifiedIdentifier3557 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_simpleCppFunctionName_in_qualifiedCppFunctionName3582 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_qualifiedCppFunctionName3593 = new BitSet(new long[]{0x0807000040000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_simpleCppFunctionName_in_qualifiedCppFunctionName3597 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_73_in_simpleCppFunctionName3624 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_simpleIdentifier_in_simpleCppFunctionName3632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleIdentifier_in_baseExpression3654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_baseExpression3663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_baseExpression3671 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_baseExpression3673 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_baseExpression3675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objCMethodCall_in_baseExpression3683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selectorExpr_in_baseExpression3691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_protocolExpr_in_baseExpression3697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_encodingExpr_in_baseExpression3703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_selectorExpr3719 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_selectorExpr3724 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_selectorName_in_selectorExpr3729 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_selectorExpr3734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_selectorName3745 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_IDENTIFIER_in_selectorName3748 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_selectorName3750 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_31_in_protocolExpr3763 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_protocolExpr3767 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_protocolExpr3771 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_protocolExpr3775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_encodingExpr3786 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_encodingExpr3791 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_encodingExpr3795 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_encodingExpr3800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inlineCondExpr_in_assignmentExpr3817 = new BitSet(new long[]{0x0000000020000002L,0x00000000007FF000L});
    public static final BitSet FOLLOW_assignmentOp_in_assignmentExpr3833 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_assignmentExpr_in_assignmentExpr3837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_assignmentOp3863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logOrExpr_in_inlineCondExpr3928 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_inlineCondExpr3940 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_logOrExpr_in_inlineCondExpr3945 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_inlineCondExpr3951 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_logOrExpr_in_inlineCondExpr3956 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_multExpr_in_addExpr3978 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_set_in_addExpr3991 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_multExpr_in_addExpr4004 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_castExpr_in_multExpr4028 = new BitSet(new long[]{0x3010000000000002L});
    public static final BitSet FOLLOW_set_in_multExpr4042 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_castExpr_in_multExpr4060 = new BitSet(new long[]{0x3010000000000002L});
    public static final BitSet FOLLOW_xorExpr_in_bitOrExpr4084 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_bitOrExpr4098 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_xorExpr_in_bitOrExpr4105 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_equalExpr_in_bitAndExpr4129 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_53_in_bitAndExpr4142 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_equalExpr_in_bitAndExpr4149 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_addExpr_in_shiftExpr4174 = new BitSet(new long[]{0x4000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_set_in_shiftExpr4187 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_addExpr_in_shiftExpr4200 = new BitSet(new long[]{0x4000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_bitAndExpr_in_xorExpr4224 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_57_in_xorExpr4237 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_bitAndExpr_in_xorExpr4244 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_logAndExpr_in_logOrExpr4268 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_logOrExpr4281 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_logAndExpr_in_logOrExpr4288 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_bitOrExpr_in_logAndExpr4312 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_logAndExpr4325 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_bitOrExpr_in_logAndExpr4332 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_compareExpr_in_equalExpr4356 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_set_in_equalExpr4369 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_compareExpr_in_equalExpr4382 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_shiftExpr_in_compareExpr4406 = new BitSet(new long[]{0x0000003000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_set_in_compareExpr4419 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_shiftExpr_in_compareExpr4441 = new BitSet(new long[]{0x0000003000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_34_in_castExpr4463 = new BitSet(new long[]{0x0807000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_castExpr4467 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_castExpr4469 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_castExpr_in_castExpr4473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpr_in_castExpr4484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpr_in_unaryExpr4506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryOp_in_unaryExpr4516 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_castExpr_in_unaryExpr4518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_unaryExpr4526 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_34_in_unaryExpr4533 = new BitSet(new long[]{0x0807000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_unaryExpr4537 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_unaryExpr4539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpr_in_unaryExpr4547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_unaryOp4570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_baseExpression_in_postfixExpr4617 = new BitSet(new long[]{0x0040000400000002L,0x0000000036000100L});
    public static final BitSet FOLLOW_54_in_postfixExpr4628 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_postfixExpr4630 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_postfixExpr4632 = new BitSet(new long[]{0x0040000400000002L,0x0000000036000100L});
    public static final BitSet FOLLOW_34_in_postfixExpr4641 = new BitSet(new long[]{0x00700C0C800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_topLevelExprList_in_postfixExpr4643 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_postfixExpr4646 = new BitSet(new long[]{0x0040000400000002L,0x0000000036000100L});
    public static final BitSet FOLLOW_72_in_postfixExpr4655 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_simpleIdentifier_in_postfixExpr4659 = new BitSet(new long[]{0x0040000400000002L,0x0000000036000100L});
    public static final BitSet FOLLOW_92_in_postfixExpr4668 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_simpleIdentifier_in_postfixExpr4672 = new BitSet(new long[]{0x0040000400000002L,0x0000000036000100L});
    public static final BitSet FOLLOW_93_in_postfixExpr4681 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_simpleIdentifier_in_postfixExpr4685 = new BitSet(new long[]{0x0040000400000002L,0x0000000036000100L});
    public static final BitSet FOLLOW_89_in_postfixExpr4694 = new BitSet(new long[]{0x0040000400000002L,0x0000000036000100L});
    public static final BitSet FOLLOW_90_in_postfixExpr4703 = new BitSet(new long[]{0x0040000400000002L,0x0000000036000100L});
    public static final BitSet FOLLOW_assignmentExpr_in_topLevelExpr4727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_topLevelExpr_in_topLevelExprList4752 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_topLevelExprList4763 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_topLevelExpr_in_topLevelExprList4770 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_topLevelExprList_in_expression4794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_statementsBlock4828 = new BitSet(new long[]{0x0D7F0C07CF8007F0L,0x0000001ECF000E00L});
    public static final BitSet FOLLOW_statement_in_statementsBlock4838 = new BitSet(new long[]{0x0D7F0C07CF8007F0L,0x0000001ECF000E00L});
    public static final BitSet FOLLOW_24_in_statementsBlock4850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_statement4869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_statement4877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement4886 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_statement4898 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_statement4902 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement4912 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement4914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_statement4921 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_statement4929 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4931 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_topLevelExpr_in_statement4933 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4935 = new BitSet(new long[]{0x0D7F0C07CE8007F0L,0x0000001ECF000E00L});
    public static final BitSet FOLLOW_statement_in_statement4937 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_statement4940 = new BitSet(new long[]{0x0D7F0C07CE8007F0L,0x0000001ECF000E00L});
    public static final BitSet FOLLOW_statement_in_statement4942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_statement4951 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4953 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_topLevelExpr_in_statement4955 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4957 = new BitSet(new long[]{0x0D7F0C07CE8007F0L,0x0000001ECF000E00L});
    public static final BitSet FOLLOW_statement_in_statement4959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_statement4966 = new BitSet(new long[]{0x0D7F0C07CE8007F0L,0x0000001ECF000E00L});
    public static final BitSet FOLLOW_statement_in_statement4968 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_statement4970 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4972 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_topLevelExpr_in_statement4974 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4976 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_statement4985 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4987 = new BitSet(new long[]{0x00700C04820007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_statement4989 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4992 = new BitSet(new long[]{0x00700C04820007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_statement4994 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4997 = new BitSet(new long[]{0x00700C0C800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_statement4999 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement5002 = new BitSet(new long[]{0x0D7F0C07CE8007F0L,0x0000001ECF000E00L});
    public static final BitSet FOLLOW_statement_in_statement5004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_statement5011 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement5013 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_statement5015 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement5017 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_statement5019 = new BitSet(new long[]{0x0D7F0C07CF8007F0L,0x0000003ECF000E00L});
    public static final BitSet FOLLOW_101_in_statement5032 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_topLevelExpr_in_statement5034 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement5036 = new BitSet(new long[]{0x0D7F0C07CF8007F0L,0x0000003ECF000E00L});
    public static final BitSet FOLLOW_statement_in_statement5044 = new BitSet(new long[]{0x0D7F0C07CF8007F0L,0x0000003ECF000E00L});
    public static final BitSet FOLLOW_24_in_statement5054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_statement5060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement5068 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement5070 = new BitSet(new long[]{0x0807000040000040L});
    public static final BitSet FOLLOW_varDecl_in_statement5072 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement5074 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_statement5076 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement5078 = new BitSet(new long[]{0x0D7F0C07CE8007F0L,0x0000001ECF000E00L});
    public static final BitSet FOLLOW_statement_in_statement5080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_constant5099 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_constant5108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEXADECIMAL_NUMBER_in_constant5116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OCTAL_NUMBER_in_constant5124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARACTER_in_constant5132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_constant5142 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_FLOAT_NUMBER_in_constant5151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_constant5162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pragmaContent_in_synpred6_ObjCpp269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_synpred8_ObjCpp286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_externDeclarations_in_synpred9_ObjCpp296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred10_ObjCpp306 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred10_ObjCpp308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_synpred21_ObjCpp678 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_enumBody_in_synpred21_ObjCpp689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_synpred24_ObjCpp767 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred24_ObjCpp771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred31_ObjCpp935 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred31_ObjCpp937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred32_ObjCpp935 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred32_ObjCpp937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionPointerVarDecl_in_synpred32_ObjCpp949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred36_ObjCpp1014 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred36_ObjCpp1016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred38_ObjCpp1102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_synpred46_ObjCpp1304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred47_ObjCpp1316 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_synpred47_ObjCpp1318 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_synpred47_ObjCpp1322 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred47_ObjCpp1324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_synpred53_ObjCpp1450 = new BitSet(new long[]{0x0000000200800000L});
    public static final BitSet FOLLOW_33_in_synpred53_ObjCpp1469 = new BitSet(new long[]{0x0000200000000040L});
    public static final BitSet FOLLOW_45_in_synpred53_ObjCpp1478 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_qualifiedIdentifier_in_synpred53_ObjCpp1490 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_structBody_in_synpred53_ObjCpp1510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binaryOp_in_synpred54_ObjCpp1558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryOp_in_synpred55_ObjCpp1567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred56_ObjCpp1619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred61_ObjCpp1788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_synpred71_ObjCpp1870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pragmaContent_in_synpred72_ObjCpp1902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred73_ObjCpp1912 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_synpred73_ObjCpp1916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred74_ObjCpp1928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred75_ObjCpp1941 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_synpred75_ObjCpp1943 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_synpred75_ObjCpp1945 = new BitSet(new long[]{0xF2300C3000000000L,0x00000000000000FFL});
    public static final BitSet FOLLOW_binaryOp_in_synpred75_ObjCpp1947 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_synpred75_ObjCpp1949 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred75_ObjCpp1952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred76_ObjCpp1969 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_synpred76_ObjCpp1971 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_synpred76_ObjCpp1973 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred76_ObjCpp1975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_synpred78_ObjCpp2004 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_declarator_in_synpred80_ObjCpp2111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred82_ObjCpp2096 = new BitSet(new long[]{0x0230000420000042L});
    public static final BitSet FOLLOW_declarator_in_synpred82_ObjCpp2111 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_synpred82_ObjCpp2123 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_topLevelExpr_in_synpred82_ObjCpp2127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_templateArgDecl_in_synpred86_ObjCpp2245 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred86_ObjCpp2248 = new BitSet(new long[]{0x0807100040000040L});
    public static final BitSet FOLLOW_templateArgDecl_in_synpred86_ObjCpp2250 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_argDef_in_synpred89_ObjCpp2326 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred89_ObjCpp2339 = new BitSet(new long[]{0x0807100040000040L});
    public static final BitSet FOLLOW_argDef_in_synpred89_ObjCpp2348 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_argDef_in_synpred91_ObjCpp2401 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred91_ObjCpp2414 = new BitSet(new long[]{0x0807100040000040L});
    public static final BitSet FOLLOW_argDef_in_synpred91_ObjCpp2423 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred92_ObjCpp2479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_synpred93_ObjCpp2501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred95_ObjCpp2547 = new BitSet(new long[]{0x0070000400000000L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_synpred95_ObjCpp2568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred99_ObjCpp2678 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_topLevelExpr_in_synpred99_ObjCpp2686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred103_ObjCpp2933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_synpred107_ObjCpp3054 = new BitSet(new long[]{0x0807100040000040L});
    public static final BitSet FOLLOW_argDef_in_synpred107_ObjCpp3063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argDef_in_synpred109_ObjCpp3041 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred109_ObjCpp3054 = new BitSet(new long[]{0x0807100040000040L});
    public static final BitSet FOLLOW_argDef_in_synpred109_ObjCpp3063 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred109_ObjCpp3083 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_synpred109_ObjCpp3085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeName_in_synpred111_ObjCpp3166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred134_ObjCpp3425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefOrExpression_in_synpred136_ObjCpp3476 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred136_ObjCpp3491 = new BitSet(new long[]{0x08770C04C00007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_typeRefOrExpression_in_synpred136_ObjCpp3501 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_36_in_synpred137_ObjCpp3466 = new BitSet(new long[]{0x08770C24C00007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_typeRefOrExpression_in_synpred137_ObjCpp3476 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_synpred137_ObjCpp3491 = new BitSet(new long[]{0x08770C04C00007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_typeRefOrExpression_in_synpred137_ObjCpp3501 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_synpred137_ObjCpp3520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentOp_in_synpred148_ObjCpp3833 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_assignmentExpr_in_synpred148_ObjCpp3837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred178_ObjCpp4419 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_shiftExpr_in_synpred178_ObjCpp4441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred179_ObjCpp4463 = new BitSet(new long[]{0x0807000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred179_ObjCpp4467 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred179_ObjCpp4469 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_castExpr_in_synpred179_ObjCpp4473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpr_in_synpred180_ObjCpp4506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryOp_in_synpred181_ObjCpp4516 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_castExpr_in_synpred181_ObjCpp4518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred182_ObjCpp4533 = new BitSet(new long[]{0x0807000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred182_ObjCpp4537 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred182_ObjCpp4539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_synpred200_ObjCpp4877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred201_ObjCpp4886 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred201_ObjCpp4888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred203_ObjCpp4912 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_synpred203_ObjCpp4914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_synpred205_ObjCpp4940 = new BitSet(new long[]{0x0D7F0C07CE8007F0L,0x0000001ECF000E00L});
    public static final BitSet FOLLOW_statement_in_synpred205_ObjCpp4942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_synpred216_ObjCpp5060 = new BitSet(new long[]{0x0000000000000002L});

}