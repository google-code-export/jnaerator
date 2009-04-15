// $ANTLR 3.1.2 /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g 2009-04-15 10:23:14
 
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:404:1: forwardClassDecl returns [List<Declaration> declarations] : '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';' ;
    public final List<Declaration> forwardClassDecl() throws RecognitionException {
        List<Declaration> declarations = null;
        int forwardClassDecl_StartIndex = input.index();
        Token n1=null;
        Token nx=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return declarations; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:405:2: ( '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:405:5: '@class' n1= IDENTIFIER ( ',' nx= IDENTIFIER )* ';'
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:411:3: ( ',' nx= IDENTIFIER )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==28) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:411:4: ',' nx= IDENTIFIER
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:420:1: functionPointerVarDecl returns [List<? extends Declaration> declarations] : tr= mutableTypeRef {...}? ';' ;
    public final List<? extends Declaration> functionPointerVarDecl() throws RecognitionException {
        List<? extends Declaration> declarations = null;
        int functionPointerVarDecl_StartIndex = input.index();
        TypeRef tr = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return declarations; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:421:2: (tr= mutableTypeRef {...}? ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:421:4: tr= mutableTypeRef {...}? ';'
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:430:1: enumItem returns [Enum.EnumItem item] : n= IDENTIFIER ( '=' v= topLevelExpr )? ;
    public final ObjCppParser.enumItem_return enumItem() throws RecognitionException {
        ObjCppParser.enumItem_return retval = new ObjCppParser.enumItem_return();
        retval.start = input.LT(1);
        int enumItem_StartIndex = input.index();
        Token n=null;
        ObjCppParser.topLevelExpr_return v = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:431:2: (n= IDENTIFIER ( '=' v= topLevelExpr )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:431:4: n= IDENTIFIER ( '=' v= topLevelExpr )?
            {
            n=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumItem506); if (state.failed) return retval;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:431:17: ( '=' v= topLevelExpr )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==29) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:431:18: '=' v= topLevelExpr
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:438:1: enumBody returns [Enum e] : '{' (i1= enumItem ( ',' (ix= enumItem )? )* )? '}' ;
    public final Enum enumBody() throws RecognitionException {
        Enum e = null;
        int enumBody_StartIndex = input.index();
        ObjCppParser.enumItem_return i1 = null;

        ObjCppParser.enumItem_return ix = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return e; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:439:2: ( '{' (i1= enumItem ( ',' (ix= enumItem )? )* )? '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:440:3: '{' (i1= enumItem ( ',' (ix= enumItem )? )* )? '}'
            {
            if ( state.backtracking==0 ) {
               
              			e = new Enum();
              			e.setForwardDeclaration(false); 
              		
            }
            match(input,23,FOLLOW_23_in_enumBody539); if (state.failed) return e;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:445:4: (i1= enumItem ( ',' (ix= enumItem )? )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==IDENTIFIER) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:446:5: i1= enumItem ( ',' (ix= enumItem )? )*
                    {
                    pushFollow(FOLLOW_enumItem_in_enumBody555);
                    i1=enumItem();

                    state._fsp--;
                    if (state.failed) return e;
                    if ( state.backtracking==0 ) {
                       
                      					if ((i1!=null?input.toString(i1.start,i1.stop):null) != null)
                      						e.addItem((i1!=null?i1.item:null)); 
                      				
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:450:5: ( ',' (ix= enumItem )? )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==28) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:451:6: ',' (ix= enumItem )?
                    	    {
                    	    match(input,28,FOLLOW_28_in_enumBody570); if (state.failed) return e;
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:452:6: (ix= enumItem )?
                    	    int alt9=2;
                    	    int LA9_0 = input.LA(1);

                    	    if ( (LA9_0==IDENTIFIER) ) {
                    	        alt9=1;
                    	    }
                    	    switch (alt9) {
                    	        case 1 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:452:7: ix= enumItem
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:460:1: enumCore returns [Enum e] : t= 'enum' (m1= modifiers (ab= enumBody | tag= qualifiedIdentifier (m2= modifiers nb= enumBody | ) ) ) ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:464:2: (t= 'enum' (m1= modifiers (ab= enumBody | tag= qualifiedIdentifier (m2= modifiers nb= enumBody | ) ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:465:3: t= 'enum' (m1= modifiers (ab= enumBody | tag= qualifiedIdentifier (m2= modifiers nb= enumBody | ) ) )
            {
            t=(Token)match(input,30,FOLLOW_30_in_enumCore625); if (state.failed) return e;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:466:3: (m1= modifiers (ab= enumBody | tag= qualifiedIdentifier (m2= modifiers nb= enumBody | ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:467:4: m1= modifiers (ab= enumBody | tag= qualifiedIdentifier (m2= modifiers nb= enumBody | ) )
            {
            pushFollow(FOLLOW_modifiers_in_enumCore636);
            m1=modifiers();

            state._fsp--;
            if (state.failed) return e;
            if ( state.backtracking==0 ) {
               modifiers.addAll(m1); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:468:4: (ab= enumBody | tag= qualifiedIdentifier (m2= modifiers nb= enumBody | ) )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:469:5: ab= enumBody
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:473:5: tag= qualifiedIdentifier (m2= modifiers nb= enumBody | )
                    {
                    pushFollow(FOLLOW_qualifiedIdentifier_in_enumCore663);
                    tag=qualifiedIdentifier();

                    state._fsp--;
                    if (state.failed) return e;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:474:5: (m2= modifiers nb= enumBody | )
                    int alt12=2;
                    alt12 = dfa12.predict(input);
                    switch (alt12) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:475:6: m2= modifiers nb= enumBody
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
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:479:10: 
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:496:1: objCClassDef returns [Struct struct] : octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl ';' {...}?)* '@end' ;
    public final Struct objCClassDef() throws RecognitionException {
        Struct struct = null;
        int objCClassDef_StartIndex = input.index();
        Token octype=null;
        Token className=null;
        Token parentClass=null;
        Token categoryName=null;
        Token p1=null;
        Token px=null;
        Token bits=null;
        VariablesDeclaration fv = null;

        VariablesDeclaration vd = null;

        List<? extends Declaration> functionPointerVarDecl9 = null;

        Function objCMethodDecl10 = null;

        TypeDef typeDef11 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return struct; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:497:2: (octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl ';' {...}?)* '@end' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:498:3: octype= ( '@protocol' | '@interface' ) className= IDENTIFIER ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' ) ( '<' (p1= IDENTIFIER ( ',' px= IDENTIFIER )* )? '>' )? ( '{' ( '@public' | '@private' | '@protected' | ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) ) )* '}' )? ( objCMethodDecl | typeDef | vd= varDecl ';' {...}?)* '@end'
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:509:3: ( ( ':' parentClass= IDENTIFIER )? | '(' categoryName= IDENTIFIER ')' )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:516:4: '(' categoryName= IDENTIFIER ')'
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
                    match(input,36,FOLLOW_36_in_objCClassDef808); if (state.failed) return struct;
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
                            p1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCClassDef818); if (state.failed) return struct;
                            if ( state.backtracking==0 ) {
                               struct.addProtocol(new SimpleIdentifier((p1!=null?p1.getText():null))); 
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
                    match(input,23,FOLLOW_23_in_objCClassDef874); if (state.failed) return struct;
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
                        case 52:
                        case 53:
                        case 54:
                        case 57:
                        case 59:
                            {
                            alt21=4;
                            }
                            break;

                        }

                        switch (alt21) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:532:5: '@public'
                    	    {
                    	    match(input,38,FOLLOW_38_in_objCClassDef886); if (state.failed) return struct;
                    	    if ( state.backtracking==0 ) {
                    	       struct.setNextMemberVisibility(Struct.MemberVisibility.Public); 
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:533:5: '@private'
                    	    {
                    	    match(input,39,FOLLOW_39_in_objCClassDef897); if (state.failed) return struct;
                    	    if ( state.backtracking==0 ) {
                    	       struct.setNextMemberVisibility(Struct.MemberVisibility.Private); 
                    	    }

                    	    }
                    	    break;
                    	case 3 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:534:5: '@protected'
                    	    {
                    	    match(input,40,FOLLOW_40_in_objCClassDef908); if (state.failed) return struct;
                    	    if ( state.backtracking==0 ) {
                    	       struct.setNextMemberVisibility(Struct.MemberVisibility.Protected); 
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
                    	            pushFollow(FOLLOW_varDecl_in_objCClassDef935);
                    	            fv=varDecl();

                    	            state._fsp--;
                    	            if (state.failed) return struct;
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
                    	                    match(input,33,FOLLOW_33_in_objCClassDef939); if (state.failed) return struct;
                    	                    bits=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_objCClassDef943); if (state.failed) return struct;

                    	                    }
                    	                    break;

                    	            }

                    	            match(input,25,FOLLOW_25_in_objCClassDef948); if (state.failed) return struct;
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              							//if ($bit.text != null) fv.setBits(Integer.parseInt((bits!=null?bits.getText():null)));
                    	              							struct.addDeclaration(fv);
                    	              						
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:541:7: functionPointerVarDecl
                    	            {
                    	            pushFollow(FOLLOW_functionPointerVarDecl_in_objCClassDef960);
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
                    	    break loop21;
                        }
                    } while (true);

                    match(input,24,FOLLOW_24_in_objCClassDef987); if (state.failed) return struct;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               struct.setNextMemberVisibility(Struct.MemberVisibility.Public); 
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
                case 58:
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
                case 52:
                case 53:
                case 54:
                case 57:
                case 59:
                    {
                    alt23=3;
                    }
                    break;

                }

                switch (alt23) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:551:4: objCMethodDecl
            	    {
            	    pushFollow(FOLLOW_objCMethodDecl_in_objCClassDef1005);
            	    objCMethodDecl10=objCMethodDecl();

            	    state._fsp--;
            	    if (state.failed) return struct;
            	    if ( state.backtracking==0 ) {
            	       
            	      				struct.addDeclaration(objCMethodDecl10); 
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:554:4: typeDef
            	    {
            	    pushFollow(FOLLOW_typeDef_in_objCClassDef1014);
            	    typeDef11=typeDef();

            	    state._fsp--;
            	    if (state.failed) return struct;
            	    if ( state.backtracking==0 ) {

            	      				struct.addDeclaration(typeDef11); 
            	      			
            	    }

            	    }
            	    break;
            	case 3 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:557:4: vd= varDecl ';' {...}?
            	    {
            	    pushFollow(FOLLOW_varDecl_in_objCClassDef1025);
            	    vd=varDecl();

            	    state._fsp--;
            	    if (state.failed) return struct;
            	    match(input,25,FOLLOW_25_in_objCClassDef1027); if (state.failed) return struct;
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
            	    break loop23;
                }
            } while (true);

            match(input,41,FOLLOW_41_in_objCClassDef1040); if (state.failed) return struct;

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:564:1: objCMethodDecl returns [Function function] : tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= mutableTypeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= mutableTypeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:565:2: (tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= mutableTypeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= mutableTypeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:565:4: tk= (tp= '+' | tm= '-' ) ( '(' (returnTypeRef= mutableTypeRef )? ')' )? methodName= IDENTIFIER ( ':' '(' argType1= mutableTypeRef ')' argName1= IDENTIFIER (sel= IDENTIFIER ':' '(' argType= mutableTypeRef ')' argName= IDENTIFIER )* ( ',' '...' )? )? ';'
            {
            if ( state.backtracking==0 ) {
               	
              			function = new Function(); 
              			function.setType(Function.Type.ObjCMethod);
              		
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
                if (state.backtracking>0) {state.failed=true; return function;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:570:4: tp= '+'
                    {
                    tp=(Token)match(input,42,FOLLOW_42_in_objCMethodDecl1074); if (state.failed) return function;
                    if ( state.backtracking==0 ) {
                       
                      				function.addModifiers(Modifier.Static); 
                      				function = mark(function, getLine(tp)); 
                      				function.setCommentBefore(getCommentBefore(tp.getTokenIndex()));
                      			
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:575:4: tm= '-'
                    {
                    tm=(Token)match(input,43,FOLLOW_43_in_objCMethodDecl1086); if (state.failed) return function;
                    if ( state.backtracking==0 ) {

                      				function = mark(function, getLine(tm)); 
                      				function.setCommentBefore(getCommentBefore(tm.getTokenIndex()));
                      			
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
                    match(input,34,FOLLOW_34_in_objCMethodDecl1105); if (state.failed) return function;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:583:18: (returnTypeRef= mutableTypeRef )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==IDENTIFIER||LA25_0==30||LA25_0==34||(LA25_0>=48 && LA25_0<=50)||(LA25_0>=52 && LA25_0<=54)||LA25_0==59) ) {
                        alt25=1;
                    }
                    else if ( (LA25_0==35) ) {
                        int LA25_2 = input.LA(2);

                        if ( (synpred39_ObjCpp()) ) {
                            alt25=1;
                        }
                    }
                    switch (alt25) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: returnTypeRef= mutableTypeRef
                            {
                            pushFollow(FOLLOW_mutableTypeRef_in_objCMethodDecl1113);
                            returnTypeRef=mutableTypeRef();

                            state._fsp--;
                            if (state.failed) return function;

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       
                      					function.setValueType(returnTypeRef); 
                      				
                    }
                    match(input,35,FOLLOW_35_in_objCMethodDecl1121); if (state.failed) return function;

                    }
                    break;

            }

            methodName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1132); if (state.failed) return function;
            if ( state.backtracking==0 ) {
               
              			function.setName(new SimpleIdentifier((methodName!=null?methodName.getText():null))); 
              			function.setCommentAfter(getCommentAfterOnSameLine(methodName.getTokenIndex()));
              		
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
                    match(input,33,FOLLOW_33_in_objCMethodDecl1144); if (state.failed) return function;
                    match(input,34,FOLLOW_34_in_objCMethodDecl1146); if (state.failed) return function;
                    pushFollow(FOLLOW_mutableTypeRef_in_objCMethodDecl1150);
                    argType1=mutableTypeRef();

                    state._fsp--;
                    if (state.failed) return function;
                    match(input,35,FOLLOW_35_in_objCMethodDecl1152); if (state.failed) return function;
                    argName1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1156); if (state.failed) return function;
                    if ( state.backtracking==0 ) {

                      				Arg arg = new Arg((argName1!=null?argName1.getText():null), argType1);
                      				arg.setSelector((methodName!=null?methodName.getText():null));
                      				function.addArg(arg);
                      			
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
                    	    sel=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1171); if (state.failed) return function;
                    	    match(input,33,FOLLOW_33_in_objCMethodDecl1173); if (state.failed) return function;
                    	    match(input,34,FOLLOW_34_in_objCMethodDecl1180); if (state.failed) return function;
                    	    pushFollow(FOLLOW_mutableTypeRef_in_objCMethodDecl1184);
                    	    argType=mutableTypeRef();

                    	    state._fsp--;
                    	    if (state.failed) return function;
                    	    match(input,35,FOLLOW_35_in_objCMethodDecl1186); if (state.failed) return function;
                    	    argName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodDecl1195); if (state.failed) return function;
                    	    if ( state.backtracking==0 ) {

                    	      					Arg arg = new Arg((argName!=null?argName.getText():null), argType);
                    	      					arg.setSelector((sel!=null?sel.getText():null));
                    	      					function.addArg(arg);
                    	      				
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
                            match(input,28,FOLLOW_28_in_objCMethodDecl1214); if (state.failed) return function;
                            match(input,44,FOLLOW_44_in_objCMethodDecl1216); if (state.failed) return function;
                            if ( state.backtracking==0 ) {

                              					function.addArg(Arg.createVarArgs());
                              				
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            match(input,25,FOLLOW_25_in_objCMethodDecl1233); if (state.failed) return function;

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:616:1: structBody returns [Struct struct] : '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' ;
    public final Struct structBody() throws RecognitionException {
        Struct struct = null;
        int structBody_StartIndex = input.index();
        ObjCppParser.declaration_return declaration12 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return struct; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:617:2: ( '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:618:3: '{' ( ( 'public' | 'private' | 'protected' ) ':' | declaration )* '}'
            {
            if ( state.backtracking==0 ) {
               
              			struct = new Struct();
              			struct.setForwardDeclaration(false); 
              		
            }
            match(input,23,FOLLOW_23_in_structBody1254); if (state.failed) return struct;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:623:4: ( ( 'public' | 'private' | 'protected' ) ':' | declaration )*
            loop31:
            do {
                int alt31=3;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=45 && LA31_0<=47)) ) {
                    alt31=1;
                }
                else if ( (LA31_0==IDENTIFIER||(LA31_0>=25 && LA31_0<=27)||(LA31_0>=30 && LA31_0<=32)||LA31_0==34||(LA31_0>=48 && LA31_0<=50)||(LA31_0>=52 && LA31_0<=54)||(LA31_0>=56 && LA31_0<=59)||LA31_0==73) ) {
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
            	        if (state.backtracking>0) {state.failed=true; return struct;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 30, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt30) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:625:6: 'public'
            	            {
            	            match(input,45,FOLLOW_45_in_structBody1272); if (state.failed) return struct;
            	            if ( state.backtracking==0 ) {
            	               struct.setNextMemberVisibility(Struct.MemberVisibility.Public); 
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:626:6: 'private'
            	            {
            	            match(input,46,FOLLOW_46_in_structBody1284); if (state.failed) return struct;
            	            if ( state.backtracking==0 ) {
            	               struct.setNextMemberVisibility(Struct.MemberVisibility.Private); 
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:627:6: 'protected'
            	            {
            	            match(input,47,FOLLOW_47_in_structBody1296); if (state.failed) return struct;
            	            if ( state.backtracking==0 ) {
            	               struct.setNextMemberVisibility(Struct.MemberVisibility.Protected); 
            	            }

            	            }
            	            break;

            	    }

            	    match(input,33,FOLLOW_33_in_structBody1307); if (state.failed) return struct;

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:629:5: declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_structBody1315);
            	    declaration12=declaration();

            	    state._fsp--;
            	    if (state.failed) return struct;
            	    if ( state.backtracking==0 ) {

            	      					struct.addDeclarations((declaration12!=null?declaration12.declarations:null));
            	      				
            	    }

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            match(input,24,FOLLOW_24_in_structBody1327); if (state.failed) return struct;

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:636:1: structCore returns [Struct struct] : typeToken= ( 'struct' | 'class' | 'union' ) (m1= modifiers (ab= structBody | tag= qualifiedIdentifier ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | ) ) ) ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:660:2: (typeToken= ( 'struct' | 'class' | 'union' ) (m1= modifiers (ab= structBody | tag= qualifiedIdentifier ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | ) ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:661:3: typeToken= ( 'struct' | 'class' | 'union' ) (m1= modifiers (ab= structBody | tag= qualifiedIdentifier ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | ) ) )
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:662:3: (m1= modifiers (ab= structBody | tag= qualifiedIdentifier ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:663:4: m1= modifiers (ab= structBody | tag= qualifiedIdentifier ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | ) )
            {
            pushFollow(FOLLOW_modifiers_in_structCore1389);
            m1=modifiers();

            state._fsp--;
            if (state.failed) return struct;
            if ( state.backtracking==0 ) {
               modifiers.addAll(m1); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:664:4: (ab= structBody | tag= qualifiedIdentifier ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==23) ) {
                alt35=1;
            }
            else if ( (LA35_0==IDENTIFIER) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return struct;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:665:5: ab= structBody
                    {
                    pushFollow(FOLLOW_structBody_in_structCore1404);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:669:5: tag= qualifiedIdentifier ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | )
                    {
                    pushFollow(FOLLOW_qualifiedIdentifier_in_structCore1416);
                    tag=qualifiedIdentifier();

                    state._fsp--;
                    if (state.failed) return struct;
                    if ( state.backtracking==0 ) {

                      					defineTypeIdentifierInParentScope((tag!=null?tag.identifier:null));
                      				
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:672:5: ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | )
                    int alt34=2;
                    alt34 = dfa34.predict(input);
                    switch (alt34) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:673:6: (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody )
                            {
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:673:6: (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody )
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:674:7: m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody
                            {
                            pushFollow(FOLLOW_modifiers_in_structCore1441);
                            m2=modifiers();

                            state._fsp--;
                            if (state.failed) return struct;
                            if ( state.backtracking==0 ) {
                               modifiers.addAll(m2); 
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:675:7: ( ':' ( 'public' )? parent= qualifiedIdentifier )?
                            int alt33=2;
                            int LA33_0 = input.LA(1);

                            if ( (LA33_0==33) ) {
                                alt33=1;
                            }
                            switch (alt33) {
                                case 1 :
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:676:8: ':' ( 'public' )? parent= qualifiedIdentifier
                                    {
                                    match(input,33,FOLLOW_33_in_structCore1460); if (state.failed) return struct;
                                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:677:8: ( 'public' )?
                                    int alt32=2;
                                    int LA32_0 = input.LA(1);

                                    if ( (LA32_0==45) ) {
                                        alt32=1;
                                    }
                                    switch (alt32) {
                                        case 1 :
                                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: 'public'
                                            {
                                            match(input,45,FOLLOW_45_in_structCore1469); if (state.failed) return struct;

                                            }
                                            break;

                                    }

                                    pushFollow(FOLLOW_qualifiedIdentifier_in_structCore1481);
                                    parent=qualifiedIdentifier();

                                    state._fsp--;
                                    if (state.failed) return struct;

                                    }
                                    break;

                            }

                            pushFollow(FOLLOW_structBody_in_structCore1501);
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
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:686:10: 
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:697:1: anyOp returns [java.lang.Enum<?> op] : ( binaryOp | unaryOp | assignmentOp );
    public final java.lang.Enum<?> anyOp() throws RecognitionException {
        java.lang.Enum<?> op = null;
        int anyOp_StartIndex = input.index();
        Expression.BinaryOperator binaryOp13 = null;

        Expression.UnaryOperator unaryOp14 = null;

        ObjCppParser.assignmentOp_return assignmentOp15 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return op; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:698:2: ( binaryOp | unaryOp | assignmentOp )
            int alt36=3;
            switch ( input.LA(1) ) {
            case 43:
            case 52:
            case 53:
                {
                int LA36_1 = input.LA(2);

                if ( (synpred54_ObjCpp()) ) {
                    alt36=1;
                }
                else if ( (synpred55_ObjCpp()) ) {
                    alt36=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return op;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 1, input);

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
                alt36=1;
                }
                break;
            case 73:
            case 89:
            case 90:
            case 91:
                {
                alt36=2;
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
                alt36=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return op;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:698:4: binaryOp
                    {
                    pushFollow(FOLLOW_binaryOp_in_anyOp1549);
                    binaryOp13=binaryOp();

                    state._fsp--;
                    if (state.failed) return op;
                    if ( state.backtracking==0 ) {
                       op = binaryOp13; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:699:3: unaryOp
                    {
                    pushFollow(FOLLOW_unaryOp_in_anyOp1558);
                    unaryOp14=unaryOp();

                    state._fsp--;
                    if (state.failed) return op;
                    if ( state.backtracking==0 ) {
                       op = unaryOp14; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:700:3: assignmentOp
                    {
                    pushFollow(FOLLOW_assignmentOp_in_anyOp1567);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:704:1: functionDeclaration returns [Function function] : preMods1= modifiers (returnTypeRef= mutableTypeRef )? preMods2= modifiers name= qualifiedCppFunctionName argList postMods= modifiers ( ':' i1= constructorInitializer ( ',' ix= constructorInitializer )* )? ( ';' | statementsBlock ) ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:709:2: (preMods1= modifiers (returnTypeRef= mutableTypeRef )? preMods2= modifiers name= qualifiedCppFunctionName argList postMods= modifiers ( ':' i1= constructorInitializer ( ',' ix= constructorInitializer )* )? ( ';' | statementsBlock ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:709:4: preMods1= modifiers (returnTypeRef= mutableTypeRef )? preMods2= modifiers name= qualifiedCppFunctionName argList postMods= modifiers ( ':' i1= constructorInitializer ( ',' ix= constructorInitializer )* )? ( ';' | statementsBlock )
            {
            if ( state.backtracking==0 ) {
               	
              			retval.function = mark(new Function(), -1);
              			retval.function.setType(Function.Type.CFunction);
              		
            }
            pushFollow(FOLLOW_modifiers_in_functionDeclaration1602);
            preMods1=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               retval.function.addModifiers(preMods1); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:714:16: (returnTypeRef= mutableTypeRef )?
            int alt37=2;
            switch ( input.LA(1) ) {
                case IDENTIFIER:
                    {
                    int LA37_1 = input.LA(2);

                    if ( ((synpred56_ObjCpp()||(synpred56_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred56_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred56_ObjCpp()&&( next("__success") ))||(synpred56_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||(synpred56_ObjCpp()&&( next("__pragma") ))||(synpred56_ObjCpp()&&( next("extern") )))) ) {
                        alt37=1;
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
                    alt37=1;
                    }
                    break;
                case 73:
                    {
                    int LA37_3 = input.LA(2);

                    if ( (synpred56_ObjCpp()) ) {
                        alt37=1;
                    }
                    }
                    break;
            }

            switch (alt37) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: returnTypeRef= mutableTypeRef
                    {
                    pushFollow(FOLLOW_mutableTypeRef_in_functionDeclaration1610);
                    returnTypeRef=mutableTypeRef();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               
              			retval.function.setValueType(returnTypeRef); 
              		
            }
            pushFollow(FOLLOW_modifiers_in_functionDeclaration1619);
            preMods2=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               retval.function.addModifiers(preMods2); 
            }
            pushFollow(FOLLOW_qualifiedCppFunctionName_in_functionDeclaration1627);
            name=qualifiedCppFunctionName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {

              			retval.function.setName(name); 
              			mark(retval.function, getLine(((Token)retval.start)));
              			//retval.function.setElementFile($functionName.file);
              			//retval.function.setElementLine($functionName.line);
              		
            }
            pushFollow(FOLLOW_argList_in_functionDeclaration1633);
            argList16=argList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {

              			retval.function.setArgs((argList16!=null?argList16.args:null));
              		
            }
            pushFollow(FOLLOW_modifiers_in_functionDeclaration1641);
            postMods=modifiers();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               retval.function.addModifiers(postMods); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:728:3: ( ':' i1= constructorInitializer ( ',' ix= constructorInitializer )* )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==33) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:729:4: ':' i1= constructorInitializer ( ',' ix= constructorInitializer )*
                    {
                    match(input,33,FOLLOW_33_in_functionDeclaration1652); if (state.failed) return retval;
                    pushFollow(FOLLOW_constructorInitializer_in_functionDeclaration1659);
                    i1=constructorInitializer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.function.addInitializer(i1); 
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:731:4: ( ',' ix= constructorInitializer )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==28) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:732:5: ',' ix= constructorInitializer
                    	    {
                    	    match(input,28,FOLLOW_28_in_functionDeclaration1672); if (state.failed) return retval;
                    	    pushFollow(FOLLOW_constructorInitializer_in_functionDeclaration1676);
                    	    ix=constructorInitializer();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	       retval.function.addInitializer(ix); 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);


                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:735:3: ( ';' | statementsBlock )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==25) ) {
                alt40=1;
            }
            else if ( (LA40_0==23) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:736:4: ';'
                    {
                    match(input,25,FOLLOW_25_in_functionDeclaration1699); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:737:4: statementsBlock
                    {
                    pushFollow(FOLLOW_statementsBlock_in_functionDeclaration1706);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:743:1: constructorInitializer returns [FunctionCall init] : qn= qualifiedCppFunctionName '(' (el= topLevelExprList )? ')' ;
    public final FunctionCall constructorInitializer() throws RecognitionException {
        FunctionCall init = null;
        int constructorInitializer_StartIndex = input.index();
        Identifier qn = null;

        List<Expression> el = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return init; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:744:2: (qn= qualifiedCppFunctionName '(' (el= topLevelExprList )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:744:4: qn= qualifiedCppFunctionName '(' (el= topLevelExprList )? ')'
            {
            pushFollow(FOLLOW_qualifiedCppFunctionName_in_constructorInitializer1729);
            qn=qualifiedCppFunctionName();

            state._fsp--;
            if (state.failed) return init;
            if ( state.backtracking==0 ) {

              			init = new FunctionCall(new TypeRefExpression(new SimpleTypeRef(qn)));
              		
            }
            match(input,34,FOLLOW_34_in_constructorInitializer1737); if (state.failed) return init;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:747:7: (el= topLevelExprList )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=DECIMAL_NUMBER && LA41_0<=FLOAT_NUMBER)||LA41_0==31||LA41_0==34||(LA41_0>=42 && LA41_0<=43)||(LA41_0>=52 && LA41_0<=54)||(LA41_0>=73 && LA41_0<=75)||(LA41_0>=88 && LA41_0<=91)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:748:4: el= topLevelExprList
                    {
                    pushFollow(FOLLOW_topLevelExprList_in_constructorInitializer1746);
                    el=topLevelExprList();

                    state._fsp--;
                    if (state.failed) return init;
                    if ( state.backtracking==0 ) {
                       init.addArguments(el); 
                    }

                    }
                    break;

            }

            match(input,35,FOLLOW_35_in_constructorInitializer1755); if (state.failed) return init;

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:752:1: modifiers returns [List<Modifier> modifiers] : ( modifier )* ;
    public final List<Modifier> modifiers() throws RecognitionException {
        List<Modifier> modifiers = null;
        int modifiers_StartIndex = input.index();
        ObjCppParser.modifier_return modifier18 = null;


         modifiers = new ArrayList<Modifier>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return modifiers; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:754:2: ( ( modifier )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:754:5: ( modifier )*
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:754:5: ( modifier )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==IDENTIFIER) ) {
                    int LA42_2 = input.LA(2);

                    if ( (((synpred61_ObjCpp()&&( next("__success") ))||(synpred61_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||(synpred61_ObjCpp()&&( next("extern") ))||(synpred61_ObjCpp()&&( next("__pragma") ))||(synpred61_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred61_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) )))) ) {
                        alt42=1;
                    }


                }


                switch (alt42) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:754:7: modifier
            	    {
            	    pushFollow(FOLLOW_modifier_in_modifiers1779);
            	    modifier18=modifier();

            	    state._fsp--;
            	    if (state.failed) return modifiers;
            	    if ( state.backtracking==0 ) {
            	       modifiers.addAll((modifier18!=null?modifier18.modifiers:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop42;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:757:1: pragmaContent : IDENTIFIER '(' ( IDENTIFIER | constant | ',' | ':' | '(' ( IDENTIFIER | constant | ',' | ':' )* ')' )* ')' ( ';' )? ;
    public final void pragmaContent() throws RecognitionException {
        int pragmaContent_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return ; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:757:15: ( IDENTIFIER '(' ( IDENTIFIER | constant | ',' | ':' | '(' ( IDENTIFIER | constant | ',' | ':' )* ')' )* ')' ( ';' )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:760:4: IDENTIFIER '(' ( IDENTIFIER | constant | ',' | ':' | '(' ( IDENTIFIER | constant | ',' | ':' )* ')' )* ')' ( ';' )?
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_pragmaContent1805); if (state.failed) return ;
            match(input,34,FOLLOW_34_in_pragmaContent1807); if (state.failed) return ;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:761:5: ( IDENTIFIER | constant | ',' | ':' | '(' ( IDENTIFIER | constant | ',' | ':' )* ')' )*
            loop44:
            do {
                int alt44=6;
                switch ( input.LA(1) ) {
                case IDENTIFIER:
                    {
                    alt44=1;
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
                    alt44=2;
                    }
                    break;
                case 28:
                    {
                    alt44=3;
                    }
                    break;
                case 33:
                    {
                    alt44=4;
                    }
                    break;
                case 34:
                    {
                    alt44=5;
                    }
                    break;

                }

                switch (alt44) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:761:6: IDENTIFIER
            	    {
            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_pragmaContent1814); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:761:19: constant
            	    {
            	    pushFollow(FOLLOW_constant_in_pragmaContent1818);
            	    constant();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;
            	case 3 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:761:30: ','
            	    {
            	    match(input,28,FOLLOW_28_in_pragmaContent1822); if (state.failed) return ;

            	    }
            	    break;
            	case 4 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:761:36: ':'
            	    {
            	    match(input,33,FOLLOW_33_in_pragmaContent1826); if (state.failed) return ;

            	    }
            	    break;
            	case 5 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:761:42: '(' ( IDENTIFIER | constant | ',' | ':' )* ')'
            	    {
            	    match(input,34,FOLLOW_34_in_pragmaContent1830); if (state.failed) return ;
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:761:46: ( IDENTIFIER | constant | ',' | ':' )*
            	    loop43:
            	    do {
            	        int alt43=5;
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

            	        }

            	        switch (alt43) {
            	    	case 1 :
            	    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:761:47: IDENTIFIER
            	    	    {
            	    	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_pragmaContent1833); if (state.failed) return ;

            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:761:60: constant
            	    	    {
            	    	    pushFollow(FOLLOW_constant_in_pragmaContent1837);
            	    	    constant();

            	    	    state._fsp--;
            	    	    if (state.failed) return ;

            	    	    }
            	    	    break;
            	    	case 3 :
            	    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:761:71: ','
            	    	    {
            	    	    match(input,28,FOLLOW_28_in_pragmaContent1841); if (state.failed) return ;

            	    	    }
            	    	    break;
            	    	case 4 :
            	    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:761:77: ':'
            	    	    {
            	    	    match(input,33,FOLLOW_33_in_pragmaContent1845); if (state.failed) return ;

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop43;
            	        }
            	    } while (true);

            	    match(input,35,FOLLOW_35_in_pragmaContent1849); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

            match(input,35,FOLLOW_35_in_pragmaContent1856); if (state.failed) return ;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:763:4: ( ';' )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==25) ) {
                int LA45_1 = input.LA(2);

                if ( (synpred71_ObjCpp()) ) {
                    alt45=1;
                }
            }
            switch (alt45) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: ';'
                    {
                    match(input,25,FOLLOW_25_in_pragmaContent1861); if (state.failed) return ;

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:767:1: modifier returns [List<Modifier> modifiers, String asmName] : ({...}? => pragmaContent | {...}? => IDENTIFIER ex= STRING | {...}?m= IDENTIFIER | {...}? => IDENTIFIER '(' 'return' binaryOp expression ')' | {...}? => IDENTIFIER '(' expression ')' | {...}? => IDENTIFIER '(' ( (an= STRING )* | extendedModifiers ) ')' );
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:769:2: ({...}? => pragmaContent | {...}? => IDENTIFIER ex= STRING | {...}?m= IDENTIFIER | {...}? => IDENTIFIER '(' 'return' binaryOp expression ')' | {...}? => IDENTIFIER '(' expression ')' | {...}? => IDENTIFIER '(' ( (an= STRING )* | extendedModifiers ) ')' )
            int alt48=6;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==IDENTIFIER) ) {
                int LA48_1 = input.LA(2);

                if ( ((synpred72_ObjCpp()&&( next("__pragma") ))) ) {
                    alt48=1;
                }
                else if ( ((synpred73_ObjCpp()&&( next("extern") ))) ) {
                    alt48=2;
                }
                else if ( ((synpred74_ObjCpp()&&( Modifier.parseModifier(next()) != null ))) ) {
                    alt48=3;
                }
                else if ( ((synpred75_ObjCpp()&&( next("__success") ))) ) {
                    alt48=4;
                }
                else if ( ((synpred76_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))) ) {
                    alt48=5;
                }
                else if ( (( next("__declspec", "__attribute__", "__asm") )) ) {
                    alt48=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:771:3: {...}? => pragmaContent
                    {
                    if ( !(( next("__pragma") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "modifier", " next(\"__pragma\") ");
                    }
                    pushFollow(FOLLOW_pragmaContent_in_modifier1893);
                    pragmaContent();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:772:3: {...}? => IDENTIFIER ex= STRING
                    {
                    if ( !(( next("extern") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "modifier", " next(\"extern\") ");
                    }
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier1903); if (state.failed) return retval;
                    ex=(Token)match(input,STRING,FOLLOW_STRING_in_modifier1907); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      			retval.modifiers.add(Modifier.Extern); // TODO
                      		
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:775:3: {...}?m= IDENTIFIER
                    {
                    if ( !(( Modifier.parseModifier(next()) != null )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "modifier", " Modifier.parseModifier(next()) != null ");
                    }
                    m=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier1919); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      			retval.modifiers.add(Modifier.parseModifier((m!=null?m.getText():null)));
                      		
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:778:3: {...}? => IDENTIFIER '(' 'return' binaryOp expression ')'
                    {
                    if ( !(( next("__success") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "modifier", " next(\"__success\") ");
                    }
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier1932); if (state.failed) return retval;
                    match(input,34,FOLLOW_34_in_modifier1934); if (state.failed) return retval;
                    match(input,51,FOLLOW_51_in_modifier1936); if (state.failed) return retval;
                    pushFollow(FOLLOW_binaryOp_in_modifier1938);
                    binaryOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_modifier1940);
                    expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    match(input,35,FOLLOW_35_in_modifier1943); if (state.failed) return retval;

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:782:3: {...}? => IDENTIFIER '(' expression ')'
                    {
                    if ( !(( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "modifier", " next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ");
                    }
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier1960); if (state.failed) return retval;
                    match(input,34,FOLLOW_34_in_modifier1962); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_modifier1964);
                    expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    match(input,35,FOLLOW_35_in_modifier1966); if (state.failed) return retval;

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:785:3: {...}? => IDENTIFIER '(' ( (an= STRING )* | extendedModifiers ) ')'
                    {
                    if ( !(( next("__declspec", "__attribute__", "__asm") )) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "modifier", " next(\"__declspec\", \"__attribute__\", \"__asm\") ");
                    }
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_modifier1980); if (state.failed) return retval;
                    match(input,34,FOLLOW_34_in_modifier1984); if (state.failed) return retval;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:787:7: ( (an= STRING )* | extendedModifiers )
                    int alt47=2;
                    switch ( input.LA(1) ) {
                    case STRING:
                        {
                        alt47=1;
                        }
                        break;
                    case 35:
                        {
                        int LA47_2 = input.LA(2);

                        if ( (synpred78_ObjCpp()) ) {
                            alt47=1;
                        }
                        else if ( (true) ) {
                            alt47=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 47, 2, input);

                            throw nvae;
                        }
                        }
                        break;
                    case IDENTIFIER:
                        {
                        alt47=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 47, 0, input);

                        throw nvae;
                    }

                    switch (alt47) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:788:4: (an= STRING )*
                            {
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:788:4: (an= STRING )*
                            loop46:
                            do {
                                int alt46=2;
                                int LA46_0 = input.LA(1);

                                if ( (LA46_0==STRING) ) {
                                    alt46=1;
                                }


                                switch (alt46) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:788:6: an= STRING
                            	    {
                            	    an=(Token)match(input,STRING,FOLLOW_STRING_in_modifier1995); if (state.failed) return retval;
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
                            	    break loop46;
                                }
                            } while (true);


                            }
                            break;
                        case 2 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:795:4: extendedModifiers
                            {
                            pushFollow(FOLLOW_extendedModifiers_in_modifier2007);
                            extendedModifiers19=extendedModifiers();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) {

                              				retval.modifiers.addAll(extendedModifiers19);
                              			
                            }

                            }
                            break;

                    }

                    match(input,35,FOLLOW_35_in_modifier2015); if (state.failed) return retval;

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:802:1: extendedModifiers returns [List<Modifier> modifiers] : ({...}?m= IDENTIFIER () )* ;
    public final List<Modifier> extendedModifiers() throws RecognitionException {
        List<Modifier> modifiers = null;
        int extendedModifiers_StartIndex = input.index();
        Token m=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return modifiers; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:803:2: ( ({...}?m= IDENTIFIER () )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:803:4: ({...}?m= IDENTIFIER () )*
            {
            if ( state.backtracking==0 ) {
               modifiers = new ArrayList<Modifier>(); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:804:3: ({...}?m= IDENTIFIER () )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==IDENTIFIER) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:805:4: {...}?m= IDENTIFIER ()
            	    {
            	    if ( !(( next(Modifier.Kind.Extended) )) ) {
            	        if (state.backtracking>0) {state.failed=true; return modifiers;}
            	        throw new FailedPredicateException(input, "extendedModifiers", " next(Modifier.Kind.Extended) ");
            	    }
            	    m=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_extendedModifiers2044); if (state.failed) return modifiers;
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:806:4: ()
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:807:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					modifiers.add(Modifier.parseModifier((m!=null?m.getText():null)));
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop49;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:817:1: argDef returns [Arg arg] : ( (tr= mutableTypeRef ) ( ( declarator )? ) ( '=' dv= topLevelExpr )? | '...' );
    public final ObjCppParser.argDef_return argDef() throws RecognitionException {
        ObjCppParser.argDef_return retval = new ObjCppParser.argDef_return();
        retval.start = input.LT(1);
        int argDef_StartIndex = input.index();
        TypeRef tr = null;

        ObjCppParser.topLevelExpr_return dv = null;

        Declarator declarator20 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:818:2: ( (tr= mutableTypeRef ) ( ( declarator )? ) ( '=' dv= topLevelExpr )? | '...' )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==EOF||LA52_0==IDENTIFIER||(LA52_0>=28 && LA52_0<=30)||(LA52_0>=34 && LA52_0<=35)||LA52_0==37||(LA52_0>=48 && LA52_0<=50)||(LA52_0>=52 && LA52_0<=54)||LA52_0==57||LA52_0==59) ) {
                alt52=1;
            }
            else if ( (LA52_0==44) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:818:4: (tr= mutableTypeRef ) ( ( declarator )? ) ( '=' dv= topLevelExpr )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:818:4: (tr= mutableTypeRef )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:819:4: tr= mutableTypeRef
                    {
                    pushFollow(FOLLOW_mutableTypeRef_in_argDef2087);
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

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:829:3: ( ( declarator )? )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:830:4: ( declarator )?
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:830:4: ( declarator )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==IDENTIFIER||LA50_0==34||(LA50_0>=52 && LA50_0<=53)||LA50_0==57) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: declarator
                            {
                            pushFollow(FOLLOW_declarator_in_argDef2102);
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

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:844:3: ( '=' dv= topLevelExpr )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==29) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:844:4: '=' dv= topLevelExpr
                            {
                            match(input,29,FOLLOW_29_in_argDef2114); if (state.failed) return retval;
                            pushFollow(FOLLOW_topLevelExpr_in_argDef2118);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:849:3: '...'
                    {
                    match(input,44,FOLLOW_44_in_argDef2132); if (state.failed) return retval;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:854:1: typeMutator returns [TypeMutator mutator] : (t= ( '*' | '&' ) | '[' ']' );
    public final TypeMutator typeMutator() throws RecognitionException {
        TypeMutator mutator = null;
        int typeMutator_StartIndex = input.index();
        Token t=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return mutator; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:855:2: (t= ( '*' | '&' ) | '[' ']' )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=52 && LA53_0<=53)) ) {
                alt53=1;
            }
            else if ( (LA53_0==54) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return mutator;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:856:3: t= ( '*' | '&' )
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:859:3: '[' ']'
                    {
                    match(input,54,FOLLOW_54_in_typeMutator2168); if (state.failed) return mutator;
                    match(input,55,FOLLOW_55_in_typeMutator2170); if (state.failed) return mutator;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:862:1: arrayTypeMutator returns [TypeMutator mutator] : '[' expression ']' ;
    public final TypeMutator arrayTypeMutator() throws RecognitionException {
        TypeMutator mutator = null;
        int arrayTypeMutator_StartIndex = input.index();
        Expression expression21 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return mutator; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:863:2: ( '[' expression ']' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:863:4: '[' expression ']'
            {
            match(input,54,FOLLOW_54_in_arrayTypeMutator2188); if (state.failed) return mutator;
            pushFollow(FOLLOW_expression_in_arrayTypeMutator2194);
            expression21=expression();

            state._fsp--;
            if (state.failed) return mutator;
            if ( state.backtracking==0 ) {

              				mutator = TypeMutator.array(expression21); 
              			
            }
            match(input,55,FOLLOW_55_in_arrayTypeMutator2203); if (state.failed) return mutator;

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:870:1: templateDef : 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' declaration ;
    public final void templateDef() throws RecognitionException {
        IsTypeDef_stack.push(new IsTypeDef_scope());

        int templateDef_StartIndex = input.index();

        	((IsTypeDef_scope)IsTypeDef_stack.peek()).isTypeDef = true;
        	((Symbols_scope)Symbols_stack.peek()).typeIdentifiers = new HashSet<String>();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return ; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:877:2: ( 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' declaration )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:877:4: 'template' '<' ( templateArgDecl ( ',' templateArgDecl )* )? '>' declaration
            {
            match(input,56,FOLLOW_56_in_templateDef2231); if (state.failed) return ;
            match(input,36,FOLLOW_36_in_templateDef2233); if (state.failed) return ;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:877:19: ( templateArgDecl ( ',' templateArgDecl )* )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==IDENTIFIER||(LA55_0>=28 && LA55_0<=30)||LA55_0==34||LA55_0==44||(LA55_0>=48 && LA55_0<=50)||(LA55_0>=52 && LA55_0<=54)||LA55_0==57||LA55_0==59) ) {
                alt55=1;
            }
            else if ( (LA55_0==37) ) {
                int LA55_2 = input.LA(2);

                if ( (synpred86_ObjCpp()) ) {
                    alt55=1;
                }
            }
            switch (alt55) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:877:20: templateArgDecl ( ',' templateArgDecl )*
                    {
                    pushFollow(FOLLOW_templateArgDecl_in_templateDef2236);
                    templateArgDecl();

                    state._fsp--;
                    if (state.failed) return ;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:877:36: ( ',' templateArgDecl )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==28) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:877:37: ',' templateArgDecl
                    	    {
                    	    match(input,28,FOLLOW_28_in_templateDef2239); if (state.failed) return ;
                    	    pushFollow(FOLLOW_templateArgDecl_in_templateDef2241);
                    	    templateArgDecl();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,37,FOLLOW_37_in_templateDef2248); if (state.failed) return ;
            pushFollow(FOLLOW_declaration_in_templateDef2252);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:882:1: templateArgDecl : argDef ;
    public final void templateArgDecl() throws RecognitionException {
        int templateArgDecl_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return ; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:883:2: ( argDef )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:883:4: argDef
            {
            pushFollow(FOLLOW_argDef_in_templateArgDecl2267);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:886:1: functionSignatureSuffix returns [FunctionSignature signature] : tk= '(' m1= modifiers '*' m2= modifiers ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:887:2: (tk= '(' m1= modifiers '*' m2= modifiers ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:887:4: tk= '(' m1= modifiers '*' m2= modifiers ( IDENTIFIER )? ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')'
            {
            tk=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffix2287); if (state.failed) return signature;
            pushFollow(FOLLOW_modifiers_in_functionSignatureSuffix2291);
            m1=modifiers();

            state._fsp--;
            if (state.failed) return signature;
            match(input,52,FOLLOW_52_in_functionSignatureSuffix2293); if (state.failed) return signature;
            pushFollow(FOLLOW_modifiers_in_functionSignatureSuffix2297);
            m2=modifiers();

            state._fsp--;
            if (state.failed) return signature;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:887:41: ( IDENTIFIER )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==IDENTIFIER) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: IDENTIFIER
                    {
                    IDENTIFIER22=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionSignatureSuffix2299); if (state.failed) return signature;

                    }
                    break;

            }

            match(input,35,FOLLOW_35_in_functionSignatureSuffix2302); if (state.failed) return signature;
            if ( state.backtracking==0 ) {
               
              			signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, new SimpleIdentifier((IDENTIFIER22!=null?IDENTIFIER22.getText():null)), null)), getLine(tk));
              			signature.getFunction().setType(Function.Type.CFunction);
              			signature.getFunction().addModifiers(m1);
              			signature.getFunction().addModifiers(m2);
              		
            }
            match(input,34,FOLLOW_34_in_functionSignatureSuffix2308); if (state.failed) return signature;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:893:7: (a1= argDef ( ',' ax= argDef )* )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==IDENTIFIER||(LA58_0>=28 && LA58_0<=30)||LA58_0==34||LA58_0==44||(LA58_0>=48 && LA58_0<=50)||(LA58_0>=52 && LA58_0<=54)||LA58_0==57||LA58_0==59) ) {
                alt58=1;
            }
            else if ( (LA58_0==35) ) {
                int LA58_2 = input.LA(2);

                if ( (synpred89_ObjCpp()) ) {
                    alt58=1;
                }
            }
            switch (alt58) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:894:4: a1= argDef ( ',' ax= argDef )*
                    {
                    pushFollow(FOLLOW_argDef_in_functionSignatureSuffix2317);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return signature;
                    if ( state.backtracking==0 ) {
                       
                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					((FunctionSignature)signature).getFunction().addArg((a1!=null?a1.arg:null)); 
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:898:4: ( ',' ax= argDef )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==28) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:899:5: ',' ax= argDef
                    	    {
                    	    match(input,28,FOLLOW_28_in_functionSignatureSuffix2330); if (state.failed) return signature;
                    	    pushFollow(FOLLOW_argDef_in_functionSignatureSuffix2339);
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

            match(input,35,FOLLOW_35_in_functionSignatureSuffix2354); if (state.failed) return signature;

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:907:1: functionSignatureSuffixNoName returns [FunctionSignature signature] : tk= '(' modifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' ;
    public final FunctionSignature functionSignatureSuffixNoName() throws RecognitionException {
        FunctionSignature signature = null;
        int functionSignatureSuffixNoName_StartIndex = input.index();
        Token tk=null;
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;

        List<Modifier> modifiers23 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return signature; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:908:2: (tk= '(' modifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:908:4: tk= '(' modifiers '*' ')' '(' (a1= argDef ( ',' ax= argDef )* )? ')'
            {
            tk=(Token)match(input,34,FOLLOW_34_in_functionSignatureSuffixNoName2371); if (state.failed) return signature;
            pushFollow(FOLLOW_modifiers_in_functionSignatureSuffixNoName2373);
            modifiers23=modifiers();

            state._fsp--;
            if (state.failed) return signature;
            match(input,52,FOLLOW_52_in_functionSignatureSuffixNoName2375); if (state.failed) return signature;
            match(input,35,FOLLOW_35_in_functionSignatureSuffixNoName2377); if (state.failed) return signature;
            if ( state.backtracking==0 ) {
               
              			signature = mark(new FunctionSignature(new Function(Function.Type.CFunction, null, null)), getLine(tk));
              			signature.getFunction().setType(Function.Type.CFunction);
              			signature.getFunction().addModifiers(modifiers23);
              		
            }
            match(input,34,FOLLOW_34_in_functionSignatureSuffixNoName2383); if (state.failed) return signature;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:913:7: (a1= argDef ( ',' ax= argDef )* )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==IDENTIFIER||(LA60_0>=28 && LA60_0<=30)||LA60_0==34||LA60_0==44||(LA60_0>=48 && LA60_0<=50)||(LA60_0>=52 && LA60_0<=54)||LA60_0==57||LA60_0==59) ) {
                alt60=1;
            }
            else if ( (LA60_0==35) ) {
                int LA60_2 = input.LA(2);

                if ( (synpred91_ObjCpp()) ) {
                    alt60=1;
                }
            }
            switch (alt60) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:914:4: a1= argDef ( ',' ax= argDef )*
                    {
                    pushFollow(FOLLOW_argDef_in_functionSignatureSuffixNoName2392);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return signature;
                    if ( state.backtracking==0 ) {
                       
                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					((FunctionSignature)signature).getFunction().addArg((a1!=null?a1.arg:null)); 
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:918:4: ( ',' ax= argDef )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==28) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:919:5: ',' ax= argDef
                    	    {
                    	    match(input,28,FOLLOW_28_in_functionSignatureSuffixNoName2405); if (state.failed) return signature;
                    	    pushFollow(FOLLOW_argDef_in_functionSignatureSuffixNoName2414);
                    	    ax=argDef();

                    	    state._fsp--;
                    	    if (state.failed) return signature;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      					((FunctionSignature)signature).getFunction().addArg((ax!=null?ax.arg:null)); 
                    	      				
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

            match(input,35,FOLLOW_35_in_functionSignatureSuffixNoName2429); if (state.failed) return signature;

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:927:1: mutableTypeRef returns [TypeRef type] : ( typeRefCore ) ( (m1= typeMutator ) | (f1= functionSignatureSuffix ) )* ;
    public final TypeRef mutableTypeRef() throws RecognitionException {
        TypeRef type = null;
        int mutableTypeRef_StartIndex = input.index();
        TypeMutator m1 = null;

        FunctionSignature f1 = null;

        TypeRef typeRefCore24 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return type; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:928:2: ( ( typeRefCore ) ( (m1= typeMutator ) | (f1= functionSignatureSuffix ) )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:929:3: ( typeRefCore ) ( (m1= typeMutator ) | (f1= functionSignatureSuffix ) )*
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:929:3: ( typeRefCore )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:929:5: typeRefCore
            {
            pushFollow(FOLLOW_typeRefCore_in_mutableTypeRef2449);
            typeRefCore24=typeRefCore();

            state._fsp--;
            if (state.failed) return type;
            if ( state.backtracking==0 ) {
               
              			type = typeRefCore24; 
              		
            }

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:932:3: ( (m1= typeMutator ) | (f1= functionSignatureSuffix ) )*
            loop61:
            do {
                int alt61=3;
                alt61 = dfa61.predict(input);
                switch (alt61) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:933:4: (m1= typeMutator )
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:933:4: (m1= typeMutator )
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:934:5: m1= typeMutator
            	    {
            	    pushFollow(FOLLOW_typeMutator_in_mutableTypeRef2470);
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:938:4: (f1= functionSignatureSuffix )
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:938:4: (f1= functionSignatureSuffix )
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:939:5: f1= functionSignatureSuffix
            	    {
            	    pushFollow(FOLLOW_functionSignatureSuffix_in_mutableTypeRef2492);
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
            if ( state.backtracking>0 ) { memoize(input, 28, mutableTypeRef_StartIndex); }
        }
        return type;
    }
    // $ANTLR end "mutableTypeRef"


    // $ANTLR start "nonMutableTypeRef"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:950:1: nonMutableTypeRef returns [TypeRef type] : typeRefCore ( ( typeMutator )* (fs= functionSignatureSuffix ) )* ;
    public final TypeRef nonMutableTypeRef() throws RecognitionException {
        TypeRef type = null;
        int nonMutableTypeRef_StartIndex = input.index();
        FunctionSignature fs = null;

        TypeRef typeRefCore25 = null;

        TypeMutator typeMutator26 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return type; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:951:2: ( typeRefCore ( ( typeMutator )* (fs= functionSignatureSuffix ) )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:952:3: typeRefCore ( ( typeMutator )* (fs= functionSignatureSuffix ) )*
            {
            pushFollow(FOLLOW_typeRefCore_in_nonMutableTypeRef2521);
            typeRefCore25=typeRefCore();

            state._fsp--;
            if (state.failed) return type;
            if ( state.backtracking==0 ) {
               
              			type = typeRefCore25; 
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:955:3: ( ( typeMutator )* (fs= functionSignatureSuffix ) )*
            loop63:
            do {
                int alt63=2;
                switch ( input.LA(1) ) {
                case 34:
                    {
                    int LA63_2 = input.LA(2);

                    if ( (synpred95_ObjCpp()) ) {
                        alt63=1;
                    }


                    }
                    break;
                case 52:
                case 53:
                    {
                    int LA63_3 = input.LA(2);

                    if ( (synpred95_ObjCpp()) ) {
                        alt63=1;
                    }


                    }
                    break;
                case 54:
                    {
                    alt63=1;
                    }
                    break;

                }

                switch (alt63) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:956:4: ( typeMutator )* (fs= functionSignatureSuffix )
            	    {
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:956:4: ( typeMutator )*
            	    loop62:
            	    do {
            	        int alt62=2;
            	        int LA62_0 = input.LA(1);

            	        if ( ((LA62_0>=52 && LA62_0<=54)) ) {
            	            alt62=1;
            	        }


            	        switch (alt62) {
            	    	case 1 :
            	    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:957:5: typeMutator
            	    	    {
            	    	    pushFollow(FOLLOW_typeMutator_in_nonMutableTypeRef2538);
            	    	    typeMutator26=typeMutator();

            	    	    state._fsp--;
            	    	    if (state.failed) return type;
            	    	    if ( state.backtracking==0 ) {

            	    	      					type = typeMutator26.mutateType(type);
            	    	      				
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop62;
            	        }
            	    } while (true);

            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:961:4: (fs= functionSignatureSuffix )
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:962:5: fs= functionSignatureSuffix
            	    {
            	    pushFollow(FOLLOW_functionSignatureSuffix_in_nonMutableTypeRef2559);
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
            	    break loop63;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:973:1: declarator returns [Declarator declarator] : modifiers ( ( directDeclarator ) | (pt= ( '*' | '&' | '^' ) inner= declarator ) ) ( '=' dv= topLevelExpr )? ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:974:2: ( modifiers ( ( directDeclarator ) | (pt= ( '*' | '&' | '^' ) inner= declarator ) ) ( '=' dv= topLevelExpr )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:975:3: modifiers ( ( directDeclarator ) | (pt= ( '*' | '&' | '^' ) inner= declarator ) ) ( '=' dv= topLevelExpr )?
            {
            pushFollow(FOLLOW_modifiers_in_declarator2590);
            modifiers28=modifiers();

            state._fsp--;
            if (state.failed) return declarator;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:976:3: ( ( directDeclarator ) | (pt= ( '*' | '&' | '^' ) inner= declarator ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==IDENTIFIER) && (( Modifier.parseModifier(next()) == null ))) {
                alt64=1;
            }
            else if ( (LA64_0==34) ) {
                alt64=1;
            }
            else if ( ((LA64_0>=52 && LA64_0<=53)||LA64_0==57) ) {
                alt64=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return declarator;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:977:4: ( directDeclarator )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:977:4: ( directDeclarator )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:978:5: directDeclarator
                    {
                    pushFollow(FOLLOW_directDeclarator_in_declarator2606);
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:982:4: (pt= ( '*' | '&' | '^' ) inner= declarator )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:982:4: (pt= ( '*' | '&' | '^' ) inner= declarator )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:983:5: pt= ( '*' | '&' | '^' ) inner= declarator
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

                    pushFollow(FOLLOW_declarator_in_declarator2648);
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

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:989:3: ( '=' dv= topLevelExpr )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==29) ) {
                int LA65_1 = input.LA(2);

                if ( (synpred99_ObjCpp()) ) {
                    alt65=1;
                }
            }
            switch (alt65) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:990:4: '=' dv= topLevelExpr
                    {
                    match(input,29,FOLLOW_29_in_declarator2669); if (state.failed) return declarator;
                    pushFollow(FOLLOW_topLevelExpr_in_declarator2677);
                    dv=topLevelExpr();

                    state._fsp--;
                    if (state.failed) return declarator;
                    if ( state.backtracking==0 ) {

                      				declarator.setDefaultValue((dv!=null?dv.expr:null));
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1000:1: typeDef returns [TypeDef typeDef] : 'typedef' varDecl ';' ;
    public final TypeDef typeDef() throws RecognitionException {
        IsTypeDef_stack.push(new IsTypeDef_scope());

        TypeDef typeDef = null;
        int typeDef_StartIndex = input.index();
        VariablesDeclaration varDecl29 = null;



        	((IsTypeDef_scope)IsTypeDef_stack.peek()).isTypeDef = true;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return typeDef; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1005:2: ( 'typedef' varDecl ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1005:4: 'typedef' varDecl ';'
            {
            match(input,58,FOLLOW_58_in_typeDef2713); if (state.failed) return typeDef;
            pushFollow(FOLLOW_varDecl_in_typeDef2718);
            varDecl29=varDecl();

            state._fsp--;
            if (state.failed) return typeDef;
            match(input,25,FOLLOW_25_in_typeDef2720); if (state.failed) return typeDef;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1012:1: varDeclEOF returns [Declaration decl] : varDecl ';' EOF ;
    public final Declaration varDeclEOF() throws RecognitionException {
        Declaration decl = null;
        int varDeclEOF_StartIndex = input.index();
        VariablesDeclaration varDecl30 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return decl; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1013:2: ( varDecl ';' EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1013:4: varDecl ';' EOF
            {
            pushFollow(FOLLOW_varDecl_in_varDeclEOF2738);
            varDecl30=varDecl();

            state._fsp--;
            if (state.failed) return decl;
            match(input,25,FOLLOW_25_in_varDeclEOF2740); if (state.failed) return decl;
            match(input,EOF,FOLLOW_EOF_in_varDeclEOF2742); if (state.failed) return decl;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1016:1: declarationEOF returns [List<Declaration> declarations] : d= declaration EOF ;
    public final List<Declaration> declarationEOF() throws RecognitionException {
        List<Declaration> declarations = null;
        int declarationEOF_StartIndex = input.index();
        ObjCppParser.declaration_return d = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return declarations; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1017:2: (d= declaration EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1017:5: d= declaration EOF
            {
            pushFollow(FOLLOW_declaration_in_declarationEOF2762);
            d=declaration();

            state._fsp--;
            if (state.failed) return declarations;
            match(input,EOF,FOLLOW_EOF_in_declarationEOF2764); if (state.failed) return declarations;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1020:1: varDecl returns [VariablesDeclaration decl] : tr= nonMutableTypeRef (d1= declaratorsList )? ;
    public final VariablesDeclaration varDecl() throws RecognitionException {
        VariablesDeclaration decl = null;
        int varDecl_StartIndex = input.index();
        TypeRef tr = null;

        List<Declarator> d1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return decl; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1021:2: (tr= nonMutableTypeRef (d1= declaratorsList )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1022:3: tr= nonMutableTypeRef (d1= declaratorsList )?
            {
            pushFollow(FOLLOW_nonMutableTypeRef_in_varDecl2786);
            tr=nonMutableTypeRef();

            state._fsp--;
            if (state.failed) return decl;
            if ( state.backtracking==0 ) {
               
              			decl = new VariablesDeclaration(tr); 
              			//decl.addModifiers($modifiers.modifiers);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1026:3: (d1= declaratorsList )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==IDENTIFIER||LA66_0==34||(LA66_0>=52 && LA66_0<=53)||LA66_0==57) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1027:4: d1= declaratorsList
                    {
                    pushFollow(FOLLOW_declaratorsList_in_varDecl2799);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1033:1: objCProtocolRefList : '<' IDENTIFIER ( ',' IDENTIFIER )* '>' ;
    public final void objCProtocolRefList() throws RecognitionException {
        int objCProtocolRefList_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return ; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1034:2: ( '<' IDENTIFIER ( ',' IDENTIFIER )* '>' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1034:4: '<' IDENTIFIER ( ',' IDENTIFIER )* '>'
            {
            match(input,36,FOLLOW_36_in_objCProtocolRefList2818); if (state.failed) return ;
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCProtocolRefList2823); if (state.failed) return ;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1036:3: ( ',' IDENTIFIER )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==28) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1037:4: ',' IDENTIFIER
            	    {
            	    match(input,28,FOLLOW_28_in_objCProtocolRefList2833); if (state.failed) return ;
            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCProtocolRefList2839); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);

            match(input,37,FOLLOW_37_in_objCProtocolRefList2849); if (state.failed) return ;

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1043:1: declaratorsList returns [List<Declarator> declarators] : d= declarator ( ',' x= declarator )* ;
    public final List<Declarator> declaratorsList() throws RecognitionException {
        List<Declarator> declarators = null;
        int declaratorsList_StartIndex = input.index();
        Declarator d = null;

        Declarator x = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return declarators; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1044:2: (d= declarator ( ',' x= declarator )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1044:4: d= declarator ( ',' x= declarator )*
            {
            if ( state.backtracking==0 ) {
               declarators = new ArrayList<Declarator>(); 
            }
            pushFollow(FOLLOW_declarator_in_declaratorsList2870);
            d=declarator();

            state._fsp--;
            if (state.failed) return declarators;
            if ( state.backtracking==0 ) {
               declarators.add(d); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1046:3: ( ',' x= declarator )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==28) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1047:4: ',' x= declarator
            	    {
            	    match(input,28,FOLLOW_28_in_declaratorsList2881); if (state.failed) return declarators;
            	    pushFollow(FOLLOW_declarator_in_declaratorsList2889);
            	    x=declarator();

            	    state._fsp--;
            	    if (state.failed) return declarators;
            	    if ( state.backtracking==0 ) {
            	       declarators.add(x); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop68;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1052:1: directDeclarator returns [Declarator declarator] : ({...}? => IDENTIFIER | '(' inner= declarator ')' ) ( '[' ( expression | ) ']' | argList )* ;
    public final Declarator directDeclarator() throws RecognitionException {
        Declarator declarator = null;
        int directDeclarator_StartIndex = input.index();
        Token IDENTIFIER31=null;
        Declarator inner = null;

        Expression expression32 = null;

        ObjCppParser.argList_return argList33 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return declarator; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1053:2: ( ({...}? => IDENTIFIER | '(' inner= declarator ')' ) ( '[' ( expression | ) ']' | argList )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1054:3: ({...}? => IDENTIFIER | '(' inner= declarator ')' ) ( '[' ( expression | ) ']' | argList )*
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1054:3: ({...}? => IDENTIFIER | '(' inner= declarator ')' )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==IDENTIFIER) && (( Modifier.parseModifier(next()) == null ))) {
                alt69=1;
            }
            else if ( (LA69_0==34) ) {
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
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1055:4: {...}? => IDENTIFIER
                    {
                    if ( !(( Modifier.parseModifier(next()) == null )) ) {
                        if (state.backtracking>0) {state.failed=true; return declarator;}
                        throw new FailedPredicateException(input, "directDeclarator", " Modifier.parseModifier(next()) == null ");
                    }
                    IDENTIFIER31=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_directDeclarator2923); if (state.failed) return declarator;
                    if ( state.backtracking==0 ) {

                      				declarator = mark(new DirectDeclarator((IDENTIFIER31!=null?IDENTIFIER31.getText():null)), getLine(IDENTIFIER31));
                      				if (isTypeDef()) {
                      					((Symbols_scope)Symbols_stack.peek()).typeIdentifiers.add((IDENTIFIER31!=null?IDENTIFIER31.getText():null));
                      				}
                      			
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1061:4: '(' inner= declarator ')'
                    {
                    match(input,34,FOLLOW_34_in_directDeclarator2933); if (state.failed) return declarator;
                    pushFollow(FOLLOW_declarator_in_directDeclarator2937);
                    inner=declarator();

                    state._fsp--;
                    if (state.failed) return declarator;
                    match(input,35,FOLLOW_35_in_directDeclarator2939); if (state.failed) return declarator;
                    if ( state.backtracking==0 ) {

                      				declarator = inner;
                      				if (declarator != null) {
                      					declarator.setParenthesized(true);
                      				}
                      			
                    }

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1068:3: ( '[' ( expression | ) ']' | argList )*
            loop71:
            do {
                int alt71=3;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==54) ) {
                    alt71=1;
                }
                else if ( (LA71_0==34) ) {
                    alt71=2;
                }


                switch (alt71) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1069:4: '[' ( expression | ) ']'
            	    {
            	    match(input,54,FOLLOW_54_in_directDeclarator2955); if (state.failed) return declarator;
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1070:4: ( expression | )
            	    int alt70=2;
            	    int LA70_0 = input.LA(1);

            	    if ( ((LA70_0>=DECIMAL_NUMBER && LA70_0<=FLOAT_NUMBER)||LA70_0==31||LA70_0==34||(LA70_0>=42 && LA70_0<=43)||(LA70_0>=52 && LA70_0<=54)||(LA70_0>=73 && LA70_0<=75)||(LA70_0>=88 && LA70_0<=91)) ) {
            	        alt70=1;
            	    }
            	    else if ( (LA70_0==55) ) {
            	        alt70=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return declarator;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 70, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt70) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1071:5: expression
            	            {
            	            pushFollow(FOLLOW_expression_in_directDeclarator2967);
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
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1076:9: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              					declarator = new ArrayDeclarator(declarator, new Expression.EmptyArraySize());
            	              				
            	            }

            	            }
            	            break;

            	    }

            	    match(input,55,FOLLOW_55_in_directDeclarator2983); if (state.failed) return declarator;

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1081:4: argList
            	    {
            	    pushFollow(FOLLOW_argList_in_directDeclarator2991);
            	    argList33=argList();

            	    state._fsp--;
            	    if (state.failed) return declarator;
            	    if ( state.backtracking==0 ) {

            	      				declarator = new FunctionDeclarator(declarator, (argList33!=null?argList33.args:null));
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop71;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1087:1: argList returns [List<Arg> args, boolean isObjC] : op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1088:2: (op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1088:4: op= '(' (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )? cp= ')'
            {
            if ( state.backtracking==0 ) {
               
              			retval.isObjC = false; 
              			retval.args = new ArrayList<Arg>();
              		
            }
            op=(Token)match(input,34,FOLLOW_34_in_argList3019); if (state.failed) return retval;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1093:3: (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==IDENTIFIER||(LA74_0>=28 && LA74_0<=30)||LA74_0==34||LA74_0==44||(LA74_0>=48 && LA74_0<=50)||(LA74_0>=52 && LA74_0<=54)||LA74_0==57||LA74_0==59) ) {
                alt74=1;
            }
            else if ( (LA74_0==35) ) {
                int LA74_2 = input.LA(2);

                if ( (synpred109_ObjCpp()) ) {
                    alt74=1;
                }
            }
            switch (alt74) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1094:4: a1= argDef ( ',' ax= argDef )* ( ',' '...' )?
                    {
                    pushFollow(FOLLOW_argDef_in_argList3031);
                    a1=argDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      				if (!(a1!=null?input.toString(a1.start,a1.stop):null).equals("void"))
                      					retval.args.add((a1!=null?a1.arg:null));
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1098:4: ( ',' ax= argDef )*
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==28) ) {
                            int LA72_1 = input.LA(2);

                            if ( (LA72_1==44) ) {
                                int LA72_3 = input.LA(3);

                                if ( (synpred107_ObjCpp()) ) {
                                    alt72=1;
                                }


                            }
                            else if ( (LA72_1==IDENTIFIER||(LA72_1>=28 && LA72_1<=30)||(LA72_1>=34 && LA72_1<=35)||(LA72_1>=48 && LA72_1<=50)||(LA72_1>=52 && LA72_1<=54)||LA72_1==57||LA72_1==59) ) {
                                alt72=1;
                            }


                        }


                        switch (alt72) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1099:5: ',' ax= argDef
                    	    {
                    	    match(input,28,FOLLOW_28_in_argList3044); if (state.failed) return retval;
                    	    pushFollow(FOLLOW_argDef_in_argList3053);
                    	    ax=argDef();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {

                    	      					retval.args.add((ax!=null?ax.arg:null));
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop72;
                        }
                    } while (true);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1104:4: ( ',' '...' )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==28) ) {
                        alt73=1;
                    }
                    switch (alt73) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1105:5: ',' '...'
                            {
                            match(input,28,FOLLOW_28_in_argList3073); if (state.failed) return retval;
                            match(input,44,FOLLOW_44_in_argList3075); if (state.failed) return retval;
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

            cp=(Token)match(input,35,FOLLOW_35_in_argList3094); if (state.failed) return retval;

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1134:1: typeRefCore returns [TypeRef type] : preMods= modifiers ( 'typename' pn= typeName | {...}? =>an= typeName | structCore | enumCore )? postMods= modifiers ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1149:2: (preMods= modifiers ( 'typename' pn= typeName | {...}? =>an= typeName | structCore | enumCore )? postMods= modifiers )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1150:3: preMods= modifiers ( 'typename' pn= typeName | {...}? =>an= typeName | structCore | enumCore )? postMods= modifiers
            {
            pushFollow(FOLLOW_modifiers_in_typeRefCore3127);
            preMods=modifiers();

            state._fsp--;
            if (state.failed) return type;
            if ( state.backtracking==0 ) {
               modifiers.addAll(preMods); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1151:3: ( 'typename' pn= typeName | {...}? =>an= typeName | structCore | enumCore )?
            int alt75=5;
            switch ( input.LA(1) ) {
                case 59:
                    {
                    alt75=1;
                    }
                    break;
                case IDENTIFIER:
                    {
                    int LA75_2 = input.LA(2);

                    if ( ((synpred111_ObjCpp()&&( 
                    				isTypeIdentifier(next()) || 
                    				(
                    					Modifier.parseModifier(next(1)) == null && 
                    					!next(2, "=", ",", ";", ":", "[", "(", ")")
                    				) 
                    			))) ) {
                        alt75=2;
                    }
                    }
                    break;
                case 48:
                case 49:
                case 50:
                    {
                    alt75=3;
                    }
                    break;
                case 30:
                    {
                    alt75=4;
                    }
                    break;
            }

            switch (alt75) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1152:4: 'typename' pn= typeName
                    {
                    match(input,59,FOLLOW_59_in_typeRefCore3138); if (state.failed) return type;
                    pushFollow(FOLLOW_typeName_in_typeRefCore3142);
                    pn=typeName();

                    state._fsp--;
                    if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                       type = pn; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1153:4: {...}? =>an= typeName
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
                    pushFollow(FOLLOW_typeName_in_typeRefCore3156);
                    an=typeName();

                    state._fsp--;
                    if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                       type = an; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1160:4: structCore
                    {
                    pushFollow(FOLLOW_structCore_in_typeRefCore3165);
                    structCore34=structCore();

                    state._fsp--;
                    if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                       type = structCore34; 
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1161:4: enumCore
                    {
                    pushFollow(FOLLOW_enumCore_in_typeRefCore3174);
                    enumCore35=enumCore();

                    state._fsp--;
                    if (state.failed) return type;
                    if ( state.backtracking==0 ) {
                       type = enumCore35; 
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_modifiers_in_typeRefCore3187);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1166:1: typeName returns [TypeRef type] : i= qualifiedIdentifier ;
    public final TypeRef typeName() throws RecognitionException {
        TypeRef type = null;
        int typeName_StartIndex = input.index();
        ObjCppParser.qualifiedIdentifier_return i = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return type; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1167:2: (i= qualifiedIdentifier )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1168:3: i= qualifiedIdentifier
            {
            pushFollow(FOLLOW_qualifiedIdentifier_in_typeName3209);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1178:1: objCMethodCall returns [FunctionCall expr] : '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']' ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1179:2: ( '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1180:3: '[' target= expression methodName= IDENTIFIER ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )? ']'
            {
            match(input,54,FOLLOW_54_in_objCMethodCall3229); if (state.failed) return expr;
            pushFollow(FOLLOW_expression_in_objCMethodCall3233);
            target=expression();

            state._fsp--;
            if (state.failed) return expr;
            methodName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodCall3237); if (state.failed) return expr;
            if ( state.backtracking==0 ) {

              			expr = new FunctionCall();
              			expr.setFunction(new VariableRef(new SimpleIdentifier((methodName!=null?methodName.getText():null))));
              			expr.setTarget(target);
              			expr.setMemberRefStyle(MemberRefStyle.SquareBrackets);
              		
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1186:3: ( ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )* )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==33) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1187:4: ':' arg1= expression (selx= IDENTIFIER ':' argx= expression )*
                    {
                    match(input,33,FOLLOW_33_in_objCMethodCall3248); if (state.failed) return expr;
                    pushFollow(FOLLOW_expression_in_objCMethodCall3252);
                    arg1=expression();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {

                      				expr.addArgument(null, arg1);
                      			
                    }
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1190:4: (selx= IDENTIFIER ':' argx= expression )*
                    loop76:
                    do {
                        int alt76=2;
                        int LA76_0 = input.LA(1);

                        if ( (LA76_0==IDENTIFIER) ) {
                            alt76=1;
                        }


                        switch (alt76) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1191:5: selx= IDENTIFIER ':' argx= expression
                    	    {
                    	    selx=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_objCMethodCall3267); if (state.failed) return expr;
                    	    match(input,33,FOLLOW_33_in_objCMethodCall3269); if (state.failed) return expr;
                    	    pushFollow(FOLLOW_expression_in_objCMethodCall3273);
                    	    argx=expression();

                    	    state._fsp--;
                    	    if (state.failed) return expr;
                    	    if ( state.backtracking==0 ) {

                    	      					expr.addArgument((selx!=null?selx.getText():null), argx);
                    	      				
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

            match(input,55,FOLLOW_55_in_objCMethodCall3290); if (state.failed) return expr;

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1199:1: binaryOp returns [Expression.BinaryOperator op] : t= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) ;
    public final Expression.BinaryOperator binaryOp() throws RecognitionException {
        Expression.BinaryOperator op = null;
        int binaryOp_StartIndex = input.index();
        Token t=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return op; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1200:2: (t= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1200:5: t= ( '+' | '-' | '*' | '/' | '%' | '<<' | '>>>' | '>>' | '^' | '||' | '|' | '&&' | '&' | '<=' | '>=' | '<' | '>' | '==' | '!=' )
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1210:1: typeRefOrExpression returns [Expression expr] : (tr= mutableTypeRef | e= topLevelExpr );
    public final Expression typeRefOrExpression() throws RecognitionException {
        Expression expr = null;
        int typeRefOrExpression_StartIndex = input.index();
        TypeRef tr = null;

        ObjCppParser.topLevelExpr_return e = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1211:2: (tr= mutableTypeRef | e= topLevelExpr )
            int alt78=2;
            alt78 = dfa78.predict(input);
            switch (alt78) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1211:4: tr= mutableTypeRef
                    {
                    pushFollow(FOLLOW_mutableTypeRef_in_typeRefOrExpression3415);
                    tr=mutableTypeRef();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {

                      			expr = new Expression.TypeRefExpression(tr);
                      		
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1214:3: e= topLevelExpr
                    {
                    pushFollow(FOLLOW_topLevelExpr_in_typeRefOrExpression3426);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1219:1: simpleIdentifier returns [SimpleIdentifier identifier] : i= IDENTIFIER ( '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>' )? ;
    public final SimpleIdentifier simpleIdentifier() throws RecognitionException {
        SimpleIdentifier identifier = null;
        int simpleIdentifier_StartIndex = input.index();
        Token i=null;
        Expression a1 = null;

        Expression ax = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return identifier; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1220:2: (i= IDENTIFIER ( '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>' )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1220:4: i= IDENTIFIER ( '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>' )?
            {
            i=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_simpleIdentifier3445); if (state.failed) return identifier;
            if ( state.backtracking==0 ) {
               identifier = new SimpleIdentifier((i!=null?i.getText():null)); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1221:3: ( '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>' )?
            int alt81=2;
            alt81 = dfa81.predict(input);
            switch (alt81) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1222:4: '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>'
                    {
                    match(input,36,FOLLOW_36_in_simpleIdentifier3456); if (state.failed) return identifier;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1222:8: (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )?
                    int alt80=2;
                    int LA80_0 = input.LA(1);

                    if ( ((LA80_0>=DECIMAL_NUMBER && LA80_0<=FLOAT_NUMBER)||LA80_0==28||(LA80_0>=30 && LA80_0<=31)||LA80_0==34||(LA80_0>=42 && LA80_0<=43)||(LA80_0>=48 && LA80_0<=50)||(LA80_0>=52 && LA80_0<=54)||LA80_0==59||(LA80_0>=73 && LA80_0<=75)||(LA80_0>=88 && LA80_0<=91)) ) {
                        alt80=1;
                    }
                    else if ( (LA80_0==37) ) {
                        int LA80_2 = input.LA(2);

                        if ( (synpred136_ObjCpp()) ) {
                            alt80=1;
                        }
                    }
                    switch (alt80) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1223:5: a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )*
                            {
                            pushFollow(FOLLOW_typeRefOrExpression_in_simpleIdentifier3466);
                            a1=typeRefOrExpression();

                            state._fsp--;
                            if (state.failed) return identifier;
                            if ( state.backtracking==0 ) {
                               identifier.addTemplateArgument(a1); 
                            }
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1224:5: ( ',' ax= typeRefOrExpression )*
                            loop79:
                            do {
                                int alt79=2;
                                int LA79_0 = input.LA(1);

                                if ( (LA79_0==28) ) {
                                    alt79=1;
                                }


                                switch (alt79) {
                            	case 1 :
                            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1225:6: ',' ax= typeRefOrExpression
                            	    {
                            	    match(input,28,FOLLOW_28_in_simpleIdentifier3481); if (state.failed) return identifier;
                            	    pushFollow(FOLLOW_typeRefOrExpression_in_simpleIdentifier3491);
                            	    ax=typeRefOrExpression();

                            	    state._fsp--;
                            	    if (state.failed) return identifier;
                            	    if ( state.backtracking==0 ) {
                            	       identifier.addTemplateArgument(ax); 
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop79;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,37,FOLLOW_37_in_simpleIdentifier3510); if (state.failed) return identifier;

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1232:1: qualifiedIdentifier returns [Identifier identifier] : i1= simpleIdentifier ( '::' ix= simpleIdentifier )* ;
    public final ObjCppParser.qualifiedIdentifier_return qualifiedIdentifier() throws RecognitionException {
        ObjCppParser.qualifiedIdentifier_return retval = new ObjCppParser.qualifiedIdentifier_return();
        retval.start = input.LT(1);
        int qualifiedIdentifier_StartIndex = input.index();
        SimpleIdentifier i1 = null;

        SimpleIdentifier ix = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return retval; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1233:2: (i1= simpleIdentifier ( '::' ix= simpleIdentifier )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1233:4: i1= simpleIdentifier ( '::' ix= simpleIdentifier )*
            {
            pushFollow(FOLLOW_simpleIdentifier_in_qualifiedIdentifier3532);
            i1=simpleIdentifier();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               retval.identifier = i1; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1234:3: ( '::' ix= simpleIdentifier )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==72) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1235:4: '::' ix= simpleIdentifier
            	    {
            	    match(input,72,FOLLOW_72_in_qualifiedIdentifier3543); if (state.failed) return retval;
            	    pushFollow(FOLLOW_simpleIdentifier_in_qualifiedIdentifier3547);
            	    ix=simpleIdentifier();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	       retval.identifier = retval.identifier.derive(QualificationSeparator.Colons, ix); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop82;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1239:1: qualifiedCppFunctionName returns [Identifier identifier] : i1= simpleCppFunctionName ( '::' ix= simpleCppFunctionName )* ;
    public final Identifier qualifiedCppFunctionName() throws RecognitionException {
        Identifier identifier = null;
        int qualifiedCppFunctionName_StartIndex = input.index();
        SimpleIdentifier i1 = null;

        SimpleIdentifier ix = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return identifier; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1240:2: (i1= simpleCppFunctionName ( '::' ix= simpleCppFunctionName )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1240:4: i1= simpleCppFunctionName ( '::' ix= simpleCppFunctionName )*
            {
            pushFollow(FOLLOW_simpleCppFunctionName_in_qualifiedCppFunctionName3572);
            i1=simpleCppFunctionName();

            state._fsp--;
            if (state.failed) return identifier;
            if ( state.backtracking==0 ) {
               identifier = i1; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1241:3: ( '::' ix= simpleCppFunctionName )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==72) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1242:4: '::' ix= simpleCppFunctionName
            	    {
            	    match(input,72,FOLLOW_72_in_qualifiedCppFunctionName3583); if (state.failed) return identifier;
            	    pushFollow(FOLLOW_simpleCppFunctionName_in_qualifiedCppFunctionName3587);
            	    ix=simpleCppFunctionName();

            	    state._fsp--;
            	    if (state.failed) return identifier;
            	    if ( state.backtracking==0 ) {
            	       identifier = identifier.derive(QualificationSeparator.Colons, ix); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop83;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1246:1: simpleCppFunctionName returns [SimpleIdentifier identifier] : (pre= '~' )? i= simpleIdentifier ;
    public final SimpleIdentifier simpleCppFunctionName() throws RecognitionException {
        SimpleIdentifier identifier = null;
        int simpleCppFunctionName_StartIndex = input.index();
        Token pre=null;
        SimpleIdentifier i = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return identifier; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1247:2: ( (pre= '~' )? i= simpleIdentifier )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1248:3: (pre= '~' )? i= simpleIdentifier
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1248:6: (pre= '~' )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==73) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: pre= '~'
                    {
                    pre=(Token)match(input,73,FOLLOW_73_in_simpleCppFunctionName3614); if (state.failed) return identifier;

                    }
                    break;

            }

            pushFollow(FOLLOW_simpleIdentifier_in_simpleCppFunctionName3622);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1256:1: baseExpression returns [Expression expr] : (i= simpleIdentifier | constant | '(' expression ')' | objCMethodCall | selectorExpr | protocolExpr | encodingExpr );
    public final Expression baseExpression() throws RecognitionException {
        Expression expr = null;
        int baseExpression_StartIndex = input.index();
        SimpleIdentifier i = null;

        Constant constant36 = null;

        Expression expression37 = null;

        FunctionCall objCMethodCall38 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1257:2: (i= simpleIdentifier | constant | '(' expression ')' | objCMethodCall | selectorExpr | protocolExpr | encodingExpr )
            int alt85=7;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt85=1;
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
                alt85=2;
                }
                break;
            case 34:
                {
                alt85=3;
                }
                break;
            case 54:
                {
                alt85=4;
                }
                break;
            case 74:
                {
                alt85=5;
                }
                break;
            case 31:
                {
                alt85=6;
                }
                break;
            case 75:
                {
                alt85=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return expr;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1258:3: i= simpleIdentifier
                    {
                    pushFollow(FOLLOW_simpleIdentifier_in_baseExpression3644);
                    i=simpleIdentifier();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {
                       expr = new VariableRef(i); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1259:3: constant
                    {
                    pushFollow(FOLLOW_constant_in_baseExpression3653);
                    constant36=constant();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {
                       expr = constant36; 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1260:3: '(' expression ')'
                    {
                    match(input,34,FOLLOW_34_in_baseExpression3661); if (state.failed) return expr;
                    pushFollow(FOLLOW_expression_in_baseExpression3663);
                    expression37=expression();

                    state._fsp--;
                    if (state.failed) return expr;
                    match(input,35,FOLLOW_35_in_baseExpression3665); if (state.failed) return expr;
                    if ( state.backtracking==0 ) {
                       
                      			expr = expression37; 
                      			if (expr != null)
                      				expr.setParenthesis(true);
                      		
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1265:3: objCMethodCall
                    {
                    pushFollow(FOLLOW_objCMethodCall_in_baseExpression3673);
                    objCMethodCall38=objCMethodCall();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {
                       expr = objCMethodCall38; 
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1266:3: selectorExpr
                    {
                    pushFollow(FOLLOW_selectorExpr_in_baseExpression3681);
                    selectorExpr();

                    state._fsp--;
                    if (state.failed) return expr;

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1267:3: protocolExpr
                    {
                    pushFollow(FOLLOW_protocolExpr_in_baseExpression3687);
                    protocolExpr();

                    state._fsp--;
                    if (state.failed) return expr;

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1268:3: encodingExpr
                    {
                    pushFollow(FOLLOW_encodingExpr_in_baseExpression3693);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1271:1: selectorExpr returns [Expression expr] : '@selector' '(' selectorName ')' ;
    public final Expression selectorExpr() throws RecognitionException {
        Expression expr = null;
        int selectorExpr_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1272:2: ( '@selector' '(' selectorName ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1272:4: '@selector' '(' selectorName ')'
            {
            match(input,74,FOLLOW_74_in_selectorExpr3709); if (state.failed) return expr;
            match(input,34,FOLLOW_34_in_selectorExpr3714); if (state.failed) return expr;
            pushFollow(FOLLOW_selectorName_in_selectorExpr3719);
            selectorName();

            state._fsp--;
            if (state.failed) return expr;
            match(input,35,FOLLOW_35_in_selectorExpr3724); if (state.failed) return expr;

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1278:1: selectorName : IDENTIFIER ( IDENTIFIER ':' )* ;
    public final void selectorName() throws RecognitionException {
        int selectorName_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return ; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1279:2: ( IDENTIFIER ( IDENTIFIER ':' )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1279:4: IDENTIFIER ( IDENTIFIER ':' )*
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_selectorName3735); if (state.failed) return ;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1279:15: ( IDENTIFIER ':' )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==IDENTIFIER) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1279:16: IDENTIFIER ':'
            	    {
            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_selectorName3738); if (state.failed) return ;
            	    match(input,33,FOLLOW_33_in_selectorName3740); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop86;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1282:1: protocolExpr : '@protocol' '(' IDENTIFIER ')' ;
    public final void protocolExpr() throws RecognitionException {
        int protocolExpr_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return ; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1283:2: ( '@protocol' '(' IDENTIFIER ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1283:4: '@protocol' '(' IDENTIFIER ')'
            {
            match(input,31,FOLLOW_31_in_protocolExpr3753); if (state.failed) return ;
            match(input,34,FOLLOW_34_in_protocolExpr3757); if (state.failed) return ;
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_protocolExpr3761); if (state.failed) return ;
            match(input,35,FOLLOW_35_in_protocolExpr3765); if (state.failed) return ;

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1289:1: encodingExpr : '@encode' '(' IDENTIFIER ')' ;
    public final void encodingExpr() throws RecognitionException {
        int encodingExpr_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return ; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1290:2: ( '@encode' '(' IDENTIFIER ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1290:4: '@encode' '(' IDENTIFIER ')'
            {
            match(input,75,FOLLOW_75_in_encodingExpr3776); if (state.failed) return ;
            match(input,34,FOLLOW_34_in_encodingExpr3781); if (state.failed) return ;
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_encodingExpr3785); if (state.failed) return ;
            match(input,35,FOLLOW_35_in_encodingExpr3790); if (state.failed) return ;

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1296:1: assignmentExpr returns [Expression expr] : e= inlineCondExpr (op= assignmentOp f= assignmentExpr )? ;
    public final Expression assignmentExpr() throws RecognitionException {
        Expression expr = null;
        int assignmentExpr_StartIndex = input.index();
        Expression e = null;

        ObjCppParser.assignmentOp_return op = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1297:2: (e= inlineCondExpr (op= assignmentOp f= assignmentExpr )? )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1297:4: e= inlineCondExpr (op= assignmentOp f= assignmentExpr )?
            {
            pushFollow(FOLLOW_inlineCondExpr_in_assignmentExpr3807);
            e=inlineCondExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1298:3: (op= assignmentOp f= assignmentExpr )?
            int alt87=2;
            alt87 = dfa87.predict(input);
            switch (alt87) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1299:4: op= assignmentOp f= assignmentExpr
                    {
                    pushFollow(FOLLOW_assignmentOp_in_assignmentExpr3823);
                    op=assignmentOp();

                    state._fsp--;
                    if (state.failed) return expr;
                    pushFollow(FOLLOW_assignmentExpr_in_assignmentExpr3827);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1303:1: assignmentOp returns [Expression.AssignmentOperator op] : t= ( '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=' | '~=' ) ;
    public final ObjCppParser.assignmentOp_return assignmentOp() throws RecognitionException {
        ObjCppParser.assignmentOp_return retval = new ObjCppParser.assignmentOp_return();
        retval.start = input.LT(1);
        int assignmentOp_StartIndex = input.index();
        Token t=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return retval; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1304:2: (t= ( '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=' | '~=' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1304:5: t= ( '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=' | '~=' )
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1309:1: inlineCondExpr returns [Expression expr] : e= logOrExpr ( '?' logOrExpr ':' logOrExpr )* ;
    public final Expression inlineCondExpr() throws RecognitionException {
        Expression expr = null;
        int inlineCondExpr_StartIndex = input.index();
        Expression e = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1310:2: (e= logOrExpr ( '?' logOrExpr ':' logOrExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1310:4: e= logOrExpr ( '?' logOrExpr ':' logOrExpr )*
            {
            pushFollow(FOLLOW_logOrExpr_in_inlineCondExpr3918);
            e=logOrExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1311:3: ( '?' logOrExpr ':' logOrExpr )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==87) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1312:4: '?' logOrExpr ':' logOrExpr
            	    {
            	    match(input,87,FOLLOW_87_in_inlineCondExpr3930); if (state.failed) return expr;
            	    pushFollow(FOLLOW_logOrExpr_in_inlineCondExpr3935);
            	    logOrExpr();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    match(input,33,FOLLOW_33_in_inlineCondExpr3941); if (state.failed) return expr;
            	    pushFollow(FOLLOW_logOrExpr_in_inlineCondExpr3946);
            	    logOrExpr();

            	    state._fsp--;
            	    if (state.failed) return expr;

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
            if ( state.backtracking>0 ) { memoize(input, 55, inlineCondExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "inlineCondExpr"


    // $ANTLR start "addExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1319:1: addExpr returns [Expression expr] : e= multExpr (op= ( '+' | '-' ) f= multExpr )* ;
    public final Expression addExpr() throws RecognitionException {
        Expression expr = null;
        int addExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1320:2: (e= multExpr (op= ( '+' | '-' ) f= multExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1320:4: e= multExpr (op= ( '+' | '-' ) f= multExpr )*
            {
            pushFollow(FOLLOW_multExpr_in_addExpr3968);
            e=multExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1321:3: (op= ( '+' | '-' ) f= multExpr )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( ((LA89_0>=42 && LA89_0<=43)) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1322:4: op= ( '+' | '-' ) f= multExpr
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

            	    pushFollow(FOLLOW_multExpr_in_addExpr3994);
            	    f=multExpr();

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
            if ( state.backtracking>0 ) { memoize(input, 56, addExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "addExpr"


    // $ANTLR start "multExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1327:1: multExpr returns [Expression expr] : e= castExpr (op= ( '%' | '*' | '/' ) f= castExpr )* ;
    public final Expression multExpr() throws RecognitionException {
        Expression expr = null;
        int multExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1328:2: (e= castExpr (op= ( '%' | '*' | '/' ) f= castExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1328:4: e= castExpr (op= ( '%' | '*' | '/' ) f= castExpr )*
            {
            pushFollow(FOLLOW_castExpr_in_multExpr4018);
            e=castExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1329:3: (op= ( '%' | '*' | '/' ) f= castExpr )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==52||(LA90_0>=60 && LA90_0<=61)) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1330:4: op= ( '%' | '*' | '/' ) f= castExpr
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

            	    pushFollow(FOLLOW_castExpr_in_multExpr4050);
            	    f=castExpr();

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
            if ( state.backtracking>0 ) { memoize(input, 57, multExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "multExpr"


    // $ANTLR start "bitOrExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1335:1: bitOrExpr returns [Expression expr] : e= xorExpr (op= '|' f= xorExpr )* ;
    public final Expression bitOrExpr() throws RecognitionException {
        Expression expr = null;
        int bitOrExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1336:2: (e= xorExpr (op= '|' f= xorExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1336:4: e= xorExpr (op= '|' f= xorExpr )*
            {
            pushFollow(FOLLOW_xorExpr_in_bitOrExpr4074);
            e=xorExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1337:3: (op= '|' f= xorExpr )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==66) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1338:4: op= '|' f= xorExpr
            	    {
            	    op=(Token)match(input,66,FOLLOW_66_in_bitOrExpr4088); if (state.failed) return expr;
            	    pushFollow(FOLLOW_xorExpr_in_bitOrExpr4095);
            	    f=xorExpr();

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
            if ( state.backtracking>0 ) { memoize(input, 58, bitOrExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "bitOrExpr"


    // $ANTLR start "bitAndExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1343:1: bitAndExpr returns [Expression expr] : e= equalExpr (op= '&' f= equalExpr )* ;
    public final Expression bitAndExpr() throws RecognitionException {
        Expression expr = null;
        int bitAndExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1344:2: (e= equalExpr (op= '&' f= equalExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1344:4: e= equalExpr (op= '&' f= equalExpr )*
            {
            pushFollow(FOLLOW_equalExpr_in_bitAndExpr4119);
            e=equalExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1345:3: (op= '&' f= equalExpr )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==53) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1346:4: op= '&' f= equalExpr
            	    {
            	    op=(Token)match(input,53,FOLLOW_53_in_bitAndExpr4132); if (state.failed) return expr;
            	    pushFollow(FOLLOW_equalExpr_in_bitAndExpr4139);
            	    f=equalExpr();

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
            if ( state.backtracking>0 ) { memoize(input, 59, bitAndExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "bitAndExpr"


    // $ANTLR start "shiftExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1352:1: shiftExpr returns [Expression expr] : e= addExpr (op= ( '>>' | '<<' ) f= addExpr )* ;
    public final Expression shiftExpr() throws RecognitionException {
        Expression expr = null;
        int shiftExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1353:2: (e= addExpr (op= ( '>>' | '<<' ) f= addExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1353:4: e= addExpr (op= ( '>>' | '<<' ) f= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_shiftExpr4164);
            e=addExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1354:3: (op= ( '>>' | '<<' ) f= addExpr )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==62||LA93_0==64) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1355:4: op= ( '>>' | '<<' ) f= addExpr
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

            	    pushFollow(FOLLOW_addExpr_in_shiftExpr4190);
            	    f=addExpr();

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
            if ( state.backtracking>0 ) { memoize(input, 60, shiftExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "shiftExpr"


    // $ANTLR start "xorExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1360:1: xorExpr returns [Expression expr] : e= bitAndExpr (op= '^' f= bitAndExpr )* ;
    public final Expression xorExpr() throws RecognitionException {
        Expression expr = null;
        int xorExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1361:2: (e= bitAndExpr (op= '^' f= bitAndExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1361:4: e= bitAndExpr (op= '^' f= bitAndExpr )*
            {
            pushFollow(FOLLOW_bitAndExpr_in_xorExpr4214);
            e=bitAndExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1362:3: (op= '^' f= bitAndExpr )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==57) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1363:4: op= '^' f= bitAndExpr
            	    {
            	    op=(Token)match(input,57,FOLLOW_57_in_xorExpr4227); if (state.failed) return expr;
            	    pushFollow(FOLLOW_bitAndExpr_in_xorExpr4234);
            	    f=bitAndExpr();

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
            if ( state.backtracking>0 ) { memoize(input, 61, xorExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "xorExpr"


    // $ANTLR start "logOrExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1368:1: logOrExpr returns [Expression expr] : e= logAndExpr (op= '||' f= logAndExpr )* ;
    public final Expression logOrExpr() throws RecognitionException {
        Expression expr = null;
        int logOrExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1369:2: (e= logAndExpr (op= '||' f= logAndExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1369:4: e= logAndExpr (op= '||' f= logAndExpr )*
            {
            pushFollow(FOLLOW_logAndExpr_in_logOrExpr4258);
            e=logAndExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1370:3: (op= '||' f= logAndExpr )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==65) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1371:4: op= '||' f= logAndExpr
            	    {
            	    op=(Token)match(input,65,FOLLOW_65_in_logOrExpr4271); if (state.failed) return expr;
            	    pushFollow(FOLLOW_logAndExpr_in_logOrExpr4278);
            	    f=logAndExpr();

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
            if ( state.backtracking>0 ) { memoize(input, 62, logOrExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "logOrExpr"


    // $ANTLR start "logAndExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1376:1: logAndExpr returns [Expression expr] : e= bitOrExpr (op= '&&' f= bitOrExpr )* ;
    public final Expression logAndExpr() throws RecognitionException {
        Expression expr = null;
        int logAndExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1377:2: (e= bitOrExpr (op= '&&' f= bitOrExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1377:4: e= bitOrExpr (op= '&&' f= bitOrExpr )*
            {
            pushFollow(FOLLOW_bitOrExpr_in_logAndExpr4302);
            e=bitOrExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1378:3: (op= '&&' f= bitOrExpr )*
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==67) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1379:4: op= '&&' f= bitOrExpr
            	    {
            	    op=(Token)match(input,67,FOLLOW_67_in_logAndExpr4315); if (state.failed) return expr;
            	    pushFollow(FOLLOW_bitOrExpr_in_logAndExpr4322);
            	    f=bitOrExpr();

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
            if ( state.backtracking>0 ) { memoize(input, 63, logAndExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "logAndExpr"


    // $ANTLR start "equalExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1384:1: equalExpr returns [Expression expr] : e= compareExpr (op= ( '!=' | '==' ) f= compareExpr )* ;
    public final Expression equalExpr() throws RecognitionException {
        Expression expr = null;
        int equalExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1385:2: (e= compareExpr (op= ( '!=' | '==' ) f= compareExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1385:4: e= compareExpr (op= ( '!=' | '==' ) f= compareExpr )*
            {
            pushFollow(FOLLOW_compareExpr_in_equalExpr4346);
            e=compareExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1386:3: (op= ( '!=' | '==' ) f= compareExpr )*
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( ((LA97_0>=70 && LA97_0<=71)) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1387:4: op= ( '!=' | '==' ) f= compareExpr
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

            	    pushFollow(FOLLOW_compareExpr_in_equalExpr4372);
            	    f=compareExpr();

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
            if ( state.backtracking>0 ) { memoize(input, 64, equalExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "equalExpr"


    // $ANTLR start "compareExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1392:1: compareExpr returns [Expression expr] : e= shiftExpr (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )* ;
    public final Expression compareExpr() throws RecognitionException {
        Expression expr = null;
        int compareExpr_StartIndex = input.index();
        Token op=null;
        Expression e = null;

        Expression f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1393:2: (e= shiftExpr (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1393:4: e= shiftExpr (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )*
            {
            pushFollow(FOLLOW_shiftExpr_in_compareExpr4396);
            e=shiftExpr();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = e; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1394:3: (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )*
            loop98:
            do {
                int alt98=2;
                alt98 = dfa98.predict(input);
                switch (alt98) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1395:4: op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr
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

            	    pushFollow(FOLLOW_shiftExpr_in_compareExpr4431);
            	    f=shiftExpr();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       expr = new BinaryOp(expr, getBinaryOperator((op!=null?op.getText():null)), f); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop98;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1400:1: castExpr returns [Expression expr] : ( '(' tr= mutableTypeRef ')' inner= castExpr | e= unaryExpr );
    public final Expression castExpr() throws RecognitionException {
        Expression expr = null;
        int castExpr_StartIndex = input.index();
        TypeRef tr = null;

        Expression inner = null;

        Expression e = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1401:2: ( '(' tr= mutableTypeRef ')' inner= castExpr | e= unaryExpr )
            int alt99=2;
            alt99 = dfa99.predict(input);
            switch (alt99) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1401:4: '(' tr= mutableTypeRef ')' inner= castExpr
                    {
                    match(input,34,FOLLOW_34_in_castExpr4453); if (state.failed) return expr;
                    pushFollow(FOLLOW_mutableTypeRef_in_castExpr4457);
                    tr=mutableTypeRef();

                    state._fsp--;
                    if (state.failed) return expr;
                    match(input,35,FOLLOW_35_in_castExpr4459); if (state.failed) return expr;
                    pushFollow(FOLLOW_castExpr_in_castExpr4463);
                    inner=castExpr();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {
                       expr = new Cast(tr, inner); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1402:3: e= unaryExpr
                    {
                    pushFollow(FOLLOW_unaryExpr_in_castExpr4474);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1405:1: unaryExpr returns [Expression expr] : (p= postfixExpr | uo= unaryOp castExpr | 'sizeof' ( '(' tr= mutableTypeRef ')' | unaryExpr ) );
    public final Expression unaryExpr() throws RecognitionException {
        Expression expr = null;
        int unaryExpr_StartIndex = input.index();
        Expression p = null;

        Expression.UnaryOperator uo = null;

        TypeRef tr = null;

        Expression castExpr39 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1406:2: (p= postfixExpr | uo= unaryOp castExpr | 'sizeof' ( '(' tr= mutableTypeRef ')' | unaryExpr ) )
            int alt101=3;
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
                alt101=1;
                }
                break;
            case 43:
                {
                int LA101_2 = input.LA(2);

                if ( (synpred180_ObjCpp()) ) {
                    alt101=1;
                }
                else if ( (synpred181_ObjCpp()) ) {
                    alt101=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return expr;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 101, 2, input);

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
                alt101=2;
                }
                break;
            case 88:
                {
                alt101=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return expr;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }

            switch (alt101) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1407:3: p= postfixExpr
                    {
                    pushFollow(FOLLOW_postfixExpr_in_unaryExpr4496);
                    p=postfixExpr();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {
                       expr = p; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1408:3: uo= unaryOp castExpr
                    {
                    pushFollow(FOLLOW_unaryOp_in_unaryExpr4506);
                    uo=unaryOp();

                    state._fsp--;
                    if (state.failed) return expr;
                    pushFollow(FOLLOW_castExpr_in_unaryExpr4508);
                    castExpr39=castExpr();

                    state._fsp--;
                    if (state.failed) return expr;
                    if ( state.backtracking==0 ) {
                       expr = new UnaryOp(castExpr39, uo); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1409:3: 'sizeof' ( '(' tr= mutableTypeRef ')' | unaryExpr )
                    {
                    match(input,88,FOLLOW_88_in_unaryExpr4516); if (state.failed) return expr;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1409:12: ( '(' tr= mutableTypeRef ')' | unaryExpr )
                    int alt100=2;
                    alt100 = dfa100.predict(input);
                    switch (alt100) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1410:4: '(' tr= mutableTypeRef ')'
                            {
                            match(input,34,FOLLOW_34_in_unaryExpr4523); if (state.failed) return expr;
                            pushFollow(FOLLOW_mutableTypeRef_in_unaryExpr4527);
                            tr=mutableTypeRef();

                            state._fsp--;
                            if (state.failed) return expr;
                            match(input,35,FOLLOW_35_in_unaryExpr4529); if (state.failed) return expr;

                            }
                            break;
                        case 2 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1411:4: unaryExpr
                            {
                            pushFollow(FOLLOW_unaryExpr_in_unaryExpr4537);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1415:1: unaryOp returns [Expression.UnaryOperator op] : t= ( '++' | '--' | '&' | '*' | '-' | '~' | '!' ) ;
    public final Expression.UnaryOperator unaryOp() throws RecognitionException {
        Expression.UnaryOperator op = null;
        int unaryOp_StartIndex = input.index();
        Token t=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return op; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1416:2: (t= ( '++' | '--' | '&' | '*' | '-' | '~' | '!' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1416:5: t= ( '++' | '--' | '&' | '*' | '-' | '~' | '!' )
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1421:1: postfixExpr returns [Expression expr] : baseExpression ( '[' expression ']' | '(' ( topLevelExprList )? ')' | '::' ao= simpleIdentifier | '.' di= simpleIdentifier | '->' ai= simpleIdentifier | '++' | '--' )* ;
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1422:2: ( baseExpression ( '[' expression ']' | '(' ( topLevelExprList )? ')' | '::' ao= simpleIdentifier | '.' di= simpleIdentifier | '->' ai= simpleIdentifier | '++' | '--' )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1423:3: baseExpression ( '[' expression ']' | '(' ( topLevelExprList )? ')' | '::' ao= simpleIdentifier | '.' di= simpleIdentifier | '->' ai= simpleIdentifier | '++' | '--' )*
            {
            pushFollow(FOLLOW_baseExpression_in_postfixExpr4607);
            baseExpression40=baseExpression();

            state._fsp--;
            if (state.failed) return expr;
            if ( state.backtracking==0 ) {
               expr = baseExpression40; 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1424:3: ( '[' expression ']' | '(' ( topLevelExprList )? ')' | '::' ao= simpleIdentifier | '.' di= simpleIdentifier | '->' ai= simpleIdentifier | '++' | '--' )*
            loop103:
            do {
                int alt103=8;
                switch ( input.LA(1) ) {
                case 54:
                    {
                    alt103=1;
                    }
                    break;
                case 34:
                    {
                    alt103=2;
                    }
                    break;
                case 72:
                    {
                    alt103=3;
                    }
                    break;
                case 92:
                    {
                    alt103=4;
                    }
                    break;
                case 93:
                    {
                    alt103=5;
                    }
                    break;
                case 89:
                    {
                    alt103=6;
                    }
                    break;
                case 90:
                    {
                    alt103=7;
                    }
                    break;

                }

                switch (alt103) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1425:4: '[' expression ']'
            	    {
            	    match(input,54,FOLLOW_54_in_postfixExpr4618); if (state.failed) return expr;
            	    pushFollow(FOLLOW_expression_in_postfixExpr4620);
            	    expression41=expression();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    match(input,55,FOLLOW_55_in_postfixExpr4622); if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       
            	      				expr = new ArrayAccess(expr, expression41); 
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1428:4: '(' ( topLevelExprList )? ')'
            	    {
            	    match(input,34,FOLLOW_34_in_postfixExpr4631); if (state.failed) return expr;
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1428:8: ( topLevelExprList )?
            	    int alt102=2;
            	    int LA102_0 = input.LA(1);

            	    if ( ((LA102_0>=DECIMAL_NUMBER && LA102_0<=FLOAT_NUMBER)||LA102_0==31||LA102_0==34||(LA102_0>=42 && LA102_0<=43)||(LA102_0>=52 && LA102_0<=54)||(LA102_0>=73 && LA102_0<=75)||(LA102_0>=88 && LA102_0<=91)) ) {
            	        alt102=1;
            	    }
            	    switch (alt102) {
            	        case 1 :
            	            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: topLevelExprList
            	            {
            	            pushFollow(FOLLOW_topLevelExprList_in_postfixExpr4633);
            	            topLevelExprList42=topLevelExprList();

            	            state._fsp--;
            	            if (state.failed) return expr;

            	            }
            	            break;

            	    }

            	    match(input,35,FOLLOW_35_in_postfixExpr4636); if (state.failed) return expr;
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
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1435:4: '::' ao= simpleIdentifier
            	    {
            	    match(input,72,FOLLOW_72_in_postfixExpr4645); if (state.failed) return expr;
            	    pushFollow(FOLLOW_simpleIdentifier_in_postfixExpr4649);
            	    ao=simpleIdentifier();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {

            	      				expr = new MemberRef(expr, MemberRefStyle.Colons, ao); 
            	      			
            	    }

            	    }
            	    break;
            	case 4 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1438:4: '.' di= simpleIdentifier
            	    {
            	    match(input,92,FOLLOW_92_in_postfixExpr4658); if (state.failed) return expr;
            	    pushFollow(FOLLOW_simpleIdentifier_in_postfixExpr4662);
            	    di=simpleIdentifier();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       
            	      				expr = new MemberRef(expr, MemberRefStyle.Dot, di); 
            	      			
            	    }

            	    }
            	    break;
            	case 5 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1441:4: '->' ai= simpleIdentifier
            	    {
            	    match(input,93,FOLLOW_93_in_postfixExpr4671); if (state.failed) return expr;
            	    pushFollow(FOLLOW_simpleIdentifier_in_postfixExpr4675);
            	    ai=simpleIdentifier();

            	    state._fsp--;
            	    if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       
            	      				expr = new MemberRef(expr, MemberRefStyle.Arrow, ai); 
            	      			
            	    }

            	    }
            	    break;
            	case 6 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1444:4: '++'
            	    {
            	    match(input,89,FOLLOW_89_in_postfixExpr4684); if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       
            	      				expr = new UnaryOp(expr, UnaryOperator.PostIncr); 
            	      			
            	    }

            	    }
            	    break;
            	case 7 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1447:4: '--'
            	    {
            	    match(input,90,FOLLOW_90_in_postfixExpr4693); if (state.failed) return expr;
            	    if ( state.backtracking==0 ) {
            	       
            	      				expr = new UnaryOp(expr, UnaryOperator.PostDecr); 
            	      			
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
            if ( state.backtracking>0 ) { memoize(input, 69, postfixExpr_StartIndex); }
        }
        return expr;
    }
    // $ANTLR end "postfixExpr"

    public static class topLevelExpr_return extends ParserRuleReturnScope {
        public Expression expr;
    };

    // $ANTLR start "topLevelExpr"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1453:1: topLevelExpr returns [Expression expr] : e= assignmentExpr ;
    public final ObjCppParser.topLevelExpr_return topLevelExpr() throws RecognitionException {
        ObjCppParser.topLevelExpr_return retval = new ObjCppParser.topLevelExpr_return();
        retval.start = input.LT(1);
        int topLevelExpr_StartIndex = input.index();
        Expression e = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return retval; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1454:2: (e= assignmentExpr )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1454:4: e= assignmentExpr
            {
            pushFollow(FOLLOW_assignmentExpr_in_topLevelExpr4717);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1456:1: topLevelExprList returns [List<Expression> exprs] : e= topLevelExpr ( ',' f= topLevelExpr )* ;
    public final List<Expression> topLevelExprList() throws RecognitionException {
        List<Expression> exprs = null;
        int topLevelExprList_StartIndex = input.index();
        ObjCppParser.topLevelExpr_return e = null;

        ObjCppParser.topLevelExpr_return f = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return exprs; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1457:2: (e= topLevelExpr ( ',' f= topLevelExpr )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1458:3: e= topLevelExpr ( ',' f= topLevelExpr )*
            {
            if ( state.backtracking==0 ) {
               exprs = new ArrayList<Expression>(); 
            }
            pushFollow(FOLLOW_topLevelExpr_in_topLevelExprList4742);
            e=topLevelExpr();

            state._fsp--;
            if (state.failed) return exprs;
            if ( state.backtracking==0 ) {
               exprs.add((e!=null?e.expr:null)); 
            }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1460:3: ( ',' f= topLevelExpr )*
            loop104:
            do {
                int alt104=2;
                int LA104_0 = input.LA(1);

                if ( (LA104_0==28) ) {
                    alt104=1;
                }


                switch (alt104) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1461:4: ',' f= topLevelExpr
            	    {
            	    match(input,28,FOLLOW_28_in_topLevelExprList4753); if (state.failed) return exprs;
            	    pushFollow(FOLLOW_topLevelExpr_in_topLevelExprList4760);
            	    f=topLevelExpr();

            	    state._fsp--;
            	    if (state.failed) return exprs;
            	    if ( state.backtracking==0 ) {
            	       exprs.add((f!=null?f.expr:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop104;
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1466:1: expression returns [Expression expr] : l= topLevelExprList ;
    public final Expression expression() throws RecognitionException {
        Expression expr = null;
        int expression_StartIndex = input.index();
        List<Expression> l = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return expr; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1467:2: (l= topLevelExprList )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1467:4: l= topLevelExprList
            {
            pushFollow(FOLLOW_topLevelExprList_in_expression4784);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1478:1: statementsBlock returns [Block stat] : '{' ( statement )* '}' ;
    public final Block statementsBlock() throws RecognitionException {
        Symbols_stack.push(new Symbols_scope());

        Block stat = null;
        int statementsBlock_StartIndex = input.index();
        Statement statement43 = null;



        	((Symbols_scope)Symbols_stack.peek()).typeIdentifiers = new HashSet<String>();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return stat; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1483:2: ( '{' ( statement )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1483:4: '{' ( statement )* '}'
            {
            if ( state.backtracking==0 ) {
               stat = new Block(); 
            }
            match(input,23,FOLLOW_23_in_statementsBlock4818); if (state.failed) return stat;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1485:3: ( statement )*
            loop105:
            do {
                int alt105=2;
                int LA105_0 = input.LA(1);

                if ( ((LA105_0>=DECIMAL_NUMBER && LA105_0<=FLOAT_NUMBER)||LA105_0==23||(LA105_0>=25 && LA105_0<=27)||(LA105_0>=30 && LA105_0<=32)||LA105_0==34||(LA105_0>=42 && LA105_0<=43)||(LA105_0>=48 && LA105_0<=54)||(LA105_0>=56 && LA105_0<=59)||(LA105_0>=73 && LA105_0<=75)||(LA105_0>=88 && LA105_0<=91)||(LA105_0>=94 && LA105_0<=95)||(LA105_0>=97 && LA105_0<=100)) ) {
                    alt105=1;
                }


                switch (alt105) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1486:4: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_statementsBlock4828);
            	    statement43=statement();

            	    state._fsp--;
            	    if (state.failed) return stat;
            	    if ( state.backtracking==0 ) {

            	      				stat.addStatement(statement43);
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop105;
                }
            } while (true);

            match(input,24,FOLLOW_24_in_statementsBlock4840); if (state.failed) return stat;

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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1492:1: statement returns [Statement stat] : (b= statementsBlock | declaration | es= expression ';' | rt= 'return' rex= expression ';' | IDENTIFIER ':' | 'break' ';' | 'if' '(' topLevelExpr ')' statement ( 'else' statement )? | 'while' '(' topLevelExpr ')' statement | 'do' statement 'while' '(' topLevelExpr ')' ';' | 'for' '(' ( expression )? ';' ( expression )? ';' ( expression )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' topLevelExpr ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement );
    public final Statement statement() throws RecognitionException {
        Statement stat = null;
        int statement_StartIndex = input.index();
        Token rt=null;
        Block b = null;

        Expression es = null;

        Expression rex = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return stat; }
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1493:2: (b= statementsBlock | declaration | es= expression ';' | rt= 'return' rex= expression ';' | IDENTIFIER ':' | 'break' ';' | 'if' '(' topLevelExpr ')' statement ( 'else' statement )? | 'while' '(' topLevelExpr ')' statement | 'do' statement 'while' '(' topLevelExpr ')' ';' | 'for' '(' ( expression )? ';' ( expression )? ';' ( expression )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' topLevelExpr ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement )
            int alt111=13;
            alt111 = dfa111.predict(input);
            switch (alt111) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1494:3: b= statementsBlock
                    {
                    pushFollow(FOLLOW_statementsBlock_in_statement4859);
                    b=statementsBlock();

                    state._fsp--;
                    if (state.failed) return stat;
                    if ( state.backtracking==0 ) {
                       stat = b; 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1495:3: declaration
                    {
                    pushFollow(FOLLOW_declaration_in_statement4867);
                    declaration();

                    state._fsp--;
                    if (state.failed) return stat;

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1496:3: es= expression ';'
                    {
                    pushFollow(FOLLOW_expression_in_statement4876);
                    es=expression();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,25,FOLLOW_25_in_statement4878); if (state.failed) return stat;
                    if ( state.backtracking==0 ) {
                       stat = new ExpressionStatement(es); 
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1497:3: rt= 'return' rex= expression ';'
                    {
                    rt=(Token)match(input,51,FOLLOW_51_in_statement4888); if (state.failed) return stat;
                    pushFollow(FOLLOW_expression_in_statement4892);
                    rex=expression();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,25,FOLLOW_25_in_statement4894); if (state.failed) return stat;
                    if ( state.backtracking==0 ) {
                       
                      			stat = mark(new Return(rex), getLine(rt));
                      		
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1500:3: IDENTIFIER ':'
                    {
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement4902); if (state.failed) return stat;
                    match(input,33,FOLLOW_33_in_statement4904); if (state.failed) return stat;

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1501:3: 'break' ';'
                    {
                    match(input,94,FOLLOW_94_in_statement4911); if (state.failed) return stat;
                    match(input,25,FOLLOW_25_in_statement4913); if (state.failed) return stat;

                    }
                    break;
                case 7 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1502:3: 'if' '(' topLevelExpr ')' statement ( 'else' statement )?
                    {
                    match(input,95,FOLLOW_95_in_statement4919); if (state.failed) return stat;
                    match(input,34,FOLLOW_34_in_statement4921); if (state.failed) return stat;
                    pushFollow(FOLLOW_topLevelExpr_in_statement4923);
                    topLevelExpr();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,35,FOLLOW_35_in_statement4925); if (state.failed) return stat;
                    pushFollow(FOLLOW_statement_in_statement4927);
                    statement();

                    state._fsp--;
                    if (state.failed) return stat;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1502:39: ( 'else' statement )?
                    int alt106=2;
                    int LA106_0 = input.LA(1);

                    if ( (LA106_0==96) ) {
                        int LA106_1 = input.LA(2);

                        if ( (synpred205_ObjCpp()) ) {
                            alt106=1;
                        }
                    }
                    switch (alt106) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1502:40: 'else' statement
                            {
                            match(input,96,FOLLOW_96_in_statement4930); if (state.failed) return stat;
                            pushFollow(FOLLOW_statement_in_statement4932);
                            statement();

                            state._fsp--;
                            if (state.failed) return stat;

                            }
                            break;

                    }


                    }
                    break;
                case 8 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1503:3: 'while' '(' topLevelExpr ')' statement
                    {
                    match(input,97,FOLLOW_97_in_statement4941); if (state.failed) return stat;
                    match(input,34,FOLLOW_34_in_statement4943); if (state.failed) return stat;
                    pushFollow(FOLLOW_topLevelExpr_in_statement4945);
                    topLevelExpr();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,35,FOLLOW_35_in_statement4947); if (state.failed) return stat;
                    pushFollow(FOLLOW_statement_in_statement4949);
                    statement();

                    state._fsp--;
                    if (state.failed) return stat;

                    }
                    break;
                case 9 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1504:3: 'do' statement 'while' '(' topLevelExpr ')' ';'
                    {
                    match(input,98,FOLLOW_98_in_statement4956); if (state.failed) return stat;
                    pushFollow(FOLLOW_statement_in_statement4958);
                    statement();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,97,FOLLOW_97_in_statement4960); if (state.failed) return stat;
                    match(input,34,FOLLOW_34_in_statement4962); if (state.failed) return stat;
                    pushFollow(FOLLOW_topLevelExpr_in_statement4964);
                    topLevelExpr();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,35,FOLLOW_35_in_statement4966); if (state.failed) return stat;
                    match(input,25,FOLLOW_25_in_statement4968); if (state.failed) return stat;

                    }
                    break;
                case 10 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1505:3: 'for' '(' ( expression )? ';' ( expression )? ';' ( expression )? ')' statement
                    {
                    match(input,99,FOLLOW_99_in_statement4975); if (state.failed) return stat;
                    match(input,34,FOLLOW_34_in_statement4977); if (state.failed) return stat;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1505:13: ( expression )?
                    int alt107=2;
                    int LA107_0 = input.LA(1);

                    if ( ((LA107_0>=DECIMAL_NUMBER && LA107_0<=FLOAT_NUMBER)||LA107_0==31||LA107_0==34||(LA107_0>=42 && LA107_0<=43)||(LA107_0>=52 && LA107_0<=54)||(LA107_0>=73 && LA107_0<=75)||(LA107_0>=88 && LA107_0<=91)) ) {
                        alt107=1;
                    }
                    switch (alt107) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement4979);
                            expression();

                            state._fsp--;
                            if (state.failed) return stat;

                            }
                            break;

                    }

                    match(input,25,FOLLOW_25_in_statement4982); if (state.failed) return stat;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1505:29: ( expression )?
                    int alt108=2;
                    int LA108_0 = input.LA(1);

                    if ( ((LA108_0>=DECIMAL_NUMBER && LA108_0<=FLOAT_NUMBER)||LA108_0==31||LA108_0==34||(LA108_0>=42 && LA108_0<=43)||(LA108_0>=52 && LA108_0<=54)||(LA108_0>=73 && LA108_0<=75)||(LA108_0>=88 && LA108_0<=91)) ) {
                        alt108=1;
                    }
                    switch (alt108) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement4984);
                            expression();

                            state._fsp--;
                            if (state.failed) return stat;

                            }
                            break;

                    }

                    match(input,25,FOLLOW_25_in_statement4987); if (state.failed) return stat;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1505:45: ( expression )?
                    int alt109=2;
                    int LA109_0 = input.LA(1);

                    if ( ((LA109_0>=DECIMAL_NUMBER && LA109_0<=FLOAT_NUMBER)||LA109_0==31||LA109_0==34||(LA109_0>=42 && LA109_0<=43)||(LA109_0>=52 && LA109_0<=54)||(LA109_0>=73 && LA109_0<=75)||(LA109_0>=88 && LA109_0<=91)) ) {
                        alt109=1;
                    }
                    switch (alt109) {
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

                    match(input,35,FOLLOW_35_in_statement4992); if (state.failed) return stat;
                    pushFollow(FOLLOW_statement_in_statement4994);
                    statement();

                    state._fsp--;
                    if (state.failed) return stat;

                    }
                    break;
                case 11 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1506:3: 'switch' '(' expression ')' '{' ( 'case' topLevelExpr ':' | statement )* '}'
                    {
                    match(input,100,FOLLOW_100_in_statement5001); if (state.failed) return stat;
                    match(input,34,FOLLOW_34_in_statement5003); if (state.failed) return stat;
                    pushFollow(FOLLOW_expression_in_statement5005);
                    expression();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,35,FOLLOW_35_in_statement5007); if (state.failed) return stat;
                    match(input,23,FOLLOW_23_in_statement5009); if (state.failed) return stat;
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1507:4: ( 'case' topLevelExpr ':' | statement )*
                    loop110:
                    do {
                        int alt110=3;
                        int LA110_0 = input.LA(1);

                        if ( (LA110_0==101) ) {
                            alt110=1;
                        }
                        else if ( ((LA110_0>=DECIMAL_NUMBER && LA110_0<=FLOAT_NUMBER)||LA110_0==23||(LA110_0>=25 && LA110_0<=27)||(LA110_0>=30 && LA110_0<=32)||LA110_0==34||(LA110_0>=42 && LA110_0<=43)||(LA110_0>=48 && LA110_0<=54)||(LA110_0>=56 && LA110_0<=59)||(LA110_0>=73 && LA110_0<=75)||(LA110_0>=88 && LA110_0<=91)||(LA110_0>=94 && LA110_0<=95)||(LA110_0>=97 && LA110_0<=100)) ) {
                            alt110=2;
                        }


                        switch (alt110) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1508:5: 'case' topLevelExpr ':'
                    	    {
                    	    match(input,101,FOLLOW_101_in_statement5022); if (state.failed) return stat;
                    	    pushFollow(FOLLOW_topLevelExpr_in_statement5024);
                    	    topLevelExpr();

                    	    state._fsp--;
                    	    if (state.failed) return stat;
                    	    match(input,33,FOLLOW_33_in_statement5026); if (state.failed) return stat;

                    	    }
                    	    break;
                    	case 2 :
                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1509:5: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_statement5034);
                    	    statement();

                    	    state._fsp--;
                    	    if (state.failed) return stat;

                    	    }
                    	    break;

                    	default :
                    	    break loop110;
                        }
                    } while (true);

                    match(input,24,FOLLOW_24_in_statement5044); if (state.failed) return stat;

                    }
                    break;
                case 12 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1512:3: ';'
                    {
                    match(input,25,FOLLOW_25_in_statement5050); if (state.failed) return stat;

                    }
                    break;
                case 13 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1513:3: {...}? IDENTIFIER '(' varDecl ':' expression ')' statement
                    {
                    if ( !(( next("foreach") )) ) {
                        if (state.backtracking>0) {state.failed=true; return stat;}
                        throw new FailedPredicateException(input, "statement", " next(\"foreach\") ");
                    }
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement5058); if (state.failed) return stat;
                    match(input,34,FOLLOW_34_in_statement5060); if (state.failed) return stat;
                    pushFollow(FOLLOW_varDecl_in_statement5062);
                    varDecl();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,33,FOLLOW_33_in_statement5064); if (state.failed) return stat;
                    pushFollow(FOLLOW_expression_in_statement5066);
                    expression();

                    state._fsp--;
                    if (state.failed) return stat;
                    match(input,35,FOLLOW_35_in_statement5068); if (state.failed) return stat;
                    pushFollow(FOLLOW_statement_in_statement5070);
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
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1516:1: constant returns [Constant constant] : ( (s= ( '-' | '+' ) )? DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER | CHARACTER | (s2= ( '-' | '+' ) )? FLOAT_NUMBER | STRING );
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
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1517:2: ( (s= ( '-' | '+' ) )? DECIMAL_NUMBER | HEXADECIMAL_NUMBER | OCTAL_NUMBER | CHARACTER | (s2= ( '-' | '+' ) )? FLOAT_NUMBER | STRING )
            int alt114=6;
            switch ( input.LA(1) ) {
            case 42:
            case 43:
                {
                int LA114_1 = input.LA(2);

                if ( (LA114_1==FLOAT_NUMBER) ) {
                    alt114=5;
                }
                else if ( (LA114_1==DECIMAL_NUMBER) ) {
                    alt114=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return constant;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 114, 1, input);

                    throw nvae;
                }
                }
                break;
            case DECIMAL_NUMBER:
                {
                alt114=1;
                }
                break;
            case HEXADECIMAL_NUMBER:
                {
                alt114=2;
                }
                break;
            case OCTAL_NUMBER:
                {
                alt114=3;
                }
                break;
            case CHARACTER:
                {
                alt114=4;
                }
                break;
            case FLOAT_NUMBER:
                {
                alt114=5;
                }
                break;
            case STRING:
                {
                alt114=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return constant;}
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;
            }

            switch (alt114) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1517:4: (s= ( '-' | '+' ) )? DECIMAL_NUMBER
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1517:5: (s= ( '-' | '+' ) )?
                    int alt112=2;
                    int LA112_0 = input.LA(1);

                    if ( ((LA112_0>=42 && LA112_0<=43)) ) {
                        alt112=1;
                    }
                    switch (alt112) {
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

                    DECIMAL_NUMBER44=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_constant5098); if (state.failed) return constant;
                    if ( state.backtracking==0 ) {
                       constant =  Constant.parseDecimal(((s!=null?s.getText():null) == null ? "" : (s!=null?s.getText():null)) + (DECIMAL_NUMBER44!=null?DECIMAL_NUMBER44.getText():null)); 
                    }

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1518:3: HEXADECIMAL_NUMBER
                    {
                    HEXADECIMAL_NUMBER45=(Token)match(input,HEXADECIMAL_NUMBER,FOLLOW_HEXADECIMAL_NUMBER_in_constant5106); if (state.failed) return constant;
                    if ( state.backtracking==0 ) {
                       constant = Constant.parseHex((HEXADECIMAL_NUMBER45!=null?HEXADECIMAL_NUMBER45.getText():null)); 
                    }

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1519:3: OCTAL_NUMBER
                    {
                    OCTAL_NUMBER46=(Token)match(input,OCTAL_NUMBER,FOLLOW_OCTAL_NUMBER_in_constant5114); if (state.failed) return constant;
                    if ( state.backtracking==0 ) {
                       constant = Constant.parseOctal((OCTAL_NUMBER46!=null?OCTAL_NUMBER46.getText():null)); 
                    }

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1520:3: CHARACTER
                    {
                    CHARACTER47=(Token)match(input,CHARACTER,FOLLOW_CHARACTER_in_constant5122); if (state.failed) return constant;
                    if ( state.backtracking==0 ) {
                       constant =  Constant.parseCharOrStringInteger((CHARACTER47!=null?CHARACTER47.getText():null)); 
                    }

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1521:3: (s2= ( '-' | '+' ) )? FLOAT_NUMBER
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1521:5: (s2= ( '-' | '+' ) )?
                    int alt113=2;
                    int LA113_0 = input.LA(1);

                    if ( ((LA113_0>=42 && LA113_0<=43)) ) {
                        alt113=1;
                    }
                    switch (alt113) {
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

                    FLOAT_NUMBER48=(Token)match(input,FLOAT_NUMBER,FOLLOW_FLOAT_NUMBER_in_constant5141); if (state.failed) return constant;
                    if ( state.backtracking==0 ) {
                       constant = Constant.parseFloat(((s2!=null?s2.getText():null) == null ? "" : (s2!=null?s2.getText():null)) + (FLOAT_NUMBER48!=null?FLOAT_NUMBER48.getText():null)); 
                    }

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1523:3: STRING
                    {
                    STRING49=(Token)match(input,STRING,FOLLOW_STRING_in_constant5152); if (state.failed) return constant;
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


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:475:6: (m2= modifiers nb= enumBody )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:475:6: m2= modifiers nb= enumBody
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

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:510:4: ( ( ':' parentClass= IDENTIFIER )? )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:510:4: ( ':' parentClass= IDENTIFIER )?
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:510:4: ( ':' parentClass= IDENTIFIER )?
        int alt118=2;
        int LA118_0 = input.LA(1);

        if ( (LA118_0==33) ) {
            alt118=1;
        }
        switch (alt118) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:511:5: ':' parentClass= IDENTIFIER
                {
                match(input,33,FOLLOW_33_in_synpred24_ObjCpp767); if (state.failed) return ;
                parentClass=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred24_ObjCpp771); if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred24_ObjCpp

    // $ANTLR start synpred32_ObjCpp
    public final void synpred32_ObjCpp_fragment() throws RecognitionException {   
        Token bits=null;
        VariablesDeclaration fv = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:537:7: (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:537:7: fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';'
        {
        pushFollow(FOLLOW_varDecl_in_synpred32_ObjCpp935);
        fv=varDecl();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:537:18: ( ':' bits= DECIMAL_NUMBER )?
        int alt122=2;
        int LA122_0 = input.LA(1);

        if ( (LA122_0==33) ) {
            alt122=1;
        }
        switch (alt122) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:537:20: ':' bits= DECIMAL_NUMBER
                {
                match(input,33,FOLLOW_33_in_synpred32_ObjCpp939); if (state.failed) return ;
                bits=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_synpred32_ObjCpp943); if (state.failed) return ;

                }
                break;

        }

        match(input,25,FOLLOW_25_in_synpred32_ObjCpp948); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_ObjCpp

    // $ANTLR start synpred33_ObjCpp
    public final void synpred33_ObjCpp_fragment() throws RecognitionException {   
        Token bits=null;
        VariablesDeclaration fv = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:535:5: ( ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:535:5: ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:535:5: ( (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:536:6: (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:536:6: (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl )
        int alt124=2;
        alt124 = dfa124.predict(input);
        switch (alt124) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:537:7: fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';'
                {
                pushFollow(FOLLOW_varDecl_in_synpred33_ObjCpp935);
                fv=varDecl();

                state._fsp--;
                if (state.failed) return ;
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:537:18: ( ':' bits= DECIMAL_NUMBER )?
                int alt123=2;
                int LA123_0 = input.LA(1);

                if ( (LA123_0==33) ) {
                    alt123=1;
                }
                switch (alt123) {
                    case 1 :
                        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:537:20: ':' bits= DECIMAL_NUMBER
                        {
                        match(input,33,FOLLOW_33_in_synpred33_ObjCpp939); if (state.failed) return ;
                        bits=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_synpred33_ObjCpp943); if (state.failed) return ;

                        }
                        break;

                }

                match(input,25,FOLLOW_25_in_synpred33_ObjCpp948); if (state.failed) return ;

                }
                break;
            case 2 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:541:7: functionPointerVarDecl
                {
                pushFollow(FOLLOW_functionPointerVarDecl_in_synpred33_ObjCpp960);
                functionPointerVarDecl();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred33_ObjCpp

    // $ANTLR start synpred37_ObjCpp
    public final void synpred37_ObjCpp_fragment() throws RecognitionException {   
        VariablesDeclaration vd = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:557:4: (vd= varDecl ';' {...}?)
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:557:4: vd= varDecl ';' {...}?
        {
        pushFollow(FOLLOW_varDecl_in_synpred37_ObjCpp1025);
        vd=varDecl();

        state._fsp--;
        if (state.failed) return ;
        match(input,25,FOLLOW_25_in_synpred37_ObjCpp1027); if (state.failed) return ;
        if ( !(( !(vd instanceof VariablesDeclaration) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred37_ObjCpp", " !($vd.decl instanceof VariablesDeclaration) ");
        }

        }
    }
    // $ANTLR end synpred37_ObjCpp

    // $ANTLR start synpred39_ObjCpp
    public final void synpred39_ObjCpp_fragment() throws RecognitionException {   
        TypeRef returnTypeRef = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:583:18: (returnTypeRef= mutableTypeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:583:18: returnTypeRef= mutableTypeRef
        {
        pushFollow(FOLLOW_mutableTypeRef_in_synpred39_ObjCpp1113);
        returnTypeRef=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_ObjCpp

    // $ANTLR start synpred53_ObjCpp
    public final void synpred53_ObjCpp_fragment() throws RecognitionException {   
        List<Modifier> m2 = null;

        ObjCppParser.qualifiedIdentifier_return parent = null;

        Struct nb = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:673:6: ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:673:6: (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:673:6: (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:674:7: m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody
        {
        pushFollow(FOLLOW_modifiers_in_synpred53_ObjCpp1441);
        m2=modifiers();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:675:7: ( ':' ( 'public' )? parent= qualifiedIdentifier )?
        int alt133=2;
        int LA133_0 = input.LA(1);

        if ( (LA133_0==33) ) {
            alt133=1;
        }
        switch (alt133) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:676:8: ':' ( 'public' )? parent= qualifiedIdentifier
                {
                match(input,33,FOLLOW_33_in_synpred53_ObjCpp1460); if (state.failed) return ;
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:677:8: ( 'public' )?
                int alt132=2;
                int LA132_0 = input.LA(1);

                if ( (LA132_0==45) ) {
                    alt132=1;
                }
                switch (alt132) {
                    case 1 :
                        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: 'public'
                        {
                        match(input,45,FOLLOW_45_in_synpred53_ObjCpp1469); if (state.failed) return ;

                        }
                        break;

                }

                pushFollow(FOLLOW_qualifiedIdentifier_in_synpred53_ObjCpp1481);
                parent=qualifiedIdentifier();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }

        pushFollow(FOLLOW_structBody_in_synpred53_ObjCpp1501);
        nb=structBody();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred53_ObjCpp

    // $ANTLR start synpred54_ObjCpp
    public final void synpred54_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:698:4: ( binaryOp )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:698:4: binaryOp
        {
        pushFollow(FOLLOW_binaryOp_in_synpred54_ObjCpp1549);
        binaryOp();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_ObjCpp

    // $ANTLR start synpred55_ObjCpp
    public final void synpred55_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:699:3: ( unaryOp )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:699:3: unaryOp
        {
        pushFollow(FOLLOW_unaryOp_in_synpred55_ObjCpp1558);
        unaryOp();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred55_ObjCpp

    // $ANTLR start synpred56_ObjCpp
    public final void synpred56_ObjCpp_fragment() throws RecognitionException {   
        TypeRef returnTypeRef = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:714:16: (returnTypeRef= mutableTypeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:714:16: returnTypeRef= mutableTypeRef
        {
        pushFollow(FOLLOW_mutableTypeRef_in_synpred56_ObjCpp1610);
        returnTypeRef=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_ObjCpp

    // $ANTLR start synpred61_ObjCpp
    public final void synpred61_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:754:7: ( modifier )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:754:7: modifier
        {
        pushFollow(FOLLOW_modifier_in_synpred61_ObjCpp1779);
        modifier();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred61_ObjCpp

    // $ANTLR start synpred71_ObjCpp
    public final void synpred71_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:763:4: ( ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:763:4: ';'
        {
        match(input,25,FOLLOW_25_in_synpred71_ObjCpp1861); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred71_ObjCpp

    // $ANTLR start synpred72_ObjCpp
    public final void synpred72_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:771:3: ({...}? => pragmaContent )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:771:3: {...}? => pragmaContent
        {
        if ( !(( next("__pragma") )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred72_ObjCpp", " next(\"__pragma\") ");
        }
        pushFollow(FOLLOW_pragmaContent_in_synpred72_ObjCpp1893);
        pragmaContent();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred72_ObjCpp

    // $ANTLR start synpred73_ObjCpp
    public final void synpred73_ObjCpp_fragment() throws RecognitionException {   
        Token ex=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:772:3: ({...}? => IDENTIFIER ex= STRING )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:772:3: {...}? => IDENTIFIER ex= STRING
        {
        if ( !(( next("extern") )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred73_ObjCpp", " next(\"extern\") ");
        }
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred73_ObjCpp1903); if (state.failed) return ;
        ex=(Token)match(input,STRING,FOLLOW_STRING_in_synpred73_ObjCpp1907); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred73_ObjCpp

    // $ANTLR start synpred74_ObjCpp
    public final void synpred74_ObjCpp_fragment() throws RecognitionException {   
        Token m=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:775:3: ({...}?m= IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:775:3: {...}?m= IDENTIFIER
        {
        if ( !(( Modifier.parseModifier(next()) != null )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred74_ObjCpp", " Modifier.parseModifier(next()) != null ");
        }
        m=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred74_ObjCpp1919); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred74_ObjCpp

    // $ANTLR start synpred75_ObjCpp
    public final void synpred75_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:778:3: ({...}? => IDENTIFIER '(' 'return' binaryOp expression ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:778:3: {...}? => IDENTIFIER '(' 'return' binaryOp expression ')'
        {
        if ( !(( next("__success") )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred75_ObjCpp", " next(\"__success\") ");
        }
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred75_ObjCpp1932); if (state.failed) return ;
        match(input,34,FOLLOW_34_in_synpred75_ObjCpp1934); if (state.failed) return ;
        match(input,51,FOLLOW_51_in_synpred75_ObjCpp1936); if (state.failed) return ;
        pushFollow(FOLLOW_binaryOp_in_synpred75_ObjCpp1938);
        binaryOp();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred75_ObjCpp1940);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred75_ObjCpp1943); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred75_ObjCpp

    // $ANTLR start synpred76_ObjCpp
    public final void synpred76_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:782:3: ({...}? => IDENTIFIER '(' expression ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:782:3: {...}? => IDENTIFIER '(' expression ')'
        {
        if ( !(( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred76_ObjCpp", " next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ");
        }
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred76_ObjCpp1960); if (state.failed) return ;
        match(input,34,FOLLOW_34_in_synpred76_ObjCpp1962); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred76_ObjCpp1964);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred76_ObjCpp1966); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred76_ObjCpp

    // $ANTLR start synpred78_ObjCpp
    public final void synpred78_ObjCpp_fragment() throws RecognitionException {   
        Token an=null;

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:788:4: ( (an= STRING )* )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:788:4: (an= STRING )*
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:788:4: (an= STRING )*
        loop136:
        do {
            int alt136=2;
            int LA136_0 = input.LA(1);

            if ( (LA136_0==STRING) ) {
                alt136=1;
            }


            switch (alt136) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:788:6: an= STRING
        	    {
        	    an=(Token)match(input,STRING,FOLLOW_STRING_in_synpred78_ObjCpp1995); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop136;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred78_ObjCpp

    // $ANTLR start synpred80_ObjCpp
    public final void synpred80_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:830:4: ( declarator )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:830:4: declarator
        {
        pushFollow(FOLLOW_declarator_in_synpred80_ObjCpp2102);
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


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:818:4: ( (tr= mutableTypeRef ) ( ( declarator )? ) ( '=' dv= topLevelExpr )? )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:818:4: (tr= mutableTypeRef ) ( ( declarator )? ) ( '=' dv= topLevelExpr )?
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:818:4: (tr= mutableTypeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:819:4: tr= mutableTypeRef
        {
        pushFollow(FOLLOW_mutableTypeRef_in_synpred82_ObjCpp2087);
        tr=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;

        }

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:829:3: ( ( declarator )? )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:830:4: ( declarator )?
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:830:4: ( declarator )?
        int alt137=2;
        int LA137_0 = input.LA(1);

        if ( (LA137_0==IDENTIFIER||LA137_0==34||(LA137_0>=52 && LA137_0<=53)||LA137_0==57) ) {
            alt137=1;
        }
        switch (alt137) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:0:0: declarator
                {
                pushFollow(FOLLOW_declarator_in_synpred82_ObjCpp2102);
                declarator();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:844:3: ( '=' dv= topLevelExpr )?
        int alt138=2;
        int LA138_0 = input.LA(1);

        if ( (LA138_0==29) ) {
            alt138=1;
        }
        switch (alt138) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:844:4: '=' dv= topLevelExpr
                {
                match(input,29,FOLLOW_29_in_synpred82_ObjCpp2114); if (state.failed) return ;
                pushFollow(FOLLOW_topLevelExpr_in_synpred82_ObjCpp2118);
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
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:877:20: ( templateArgDecl ( ',' templateArgDecl )* )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:877:20: templateArgDecl ( ',' templateArgDecl )*
        {
        pushFollow(FOLLOW_templateArgDecl_in_synpred86_ObjCpp2236);
        templateArgDecl();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:877:36: ( ',' templateArgDecl )*
        loop139:
        do {
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( (LA139_0==28) ) {
                alt139=1;
            }


            switch (alt139) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:877:37: ',' templateArgDecl
        	    {
        	    match(input,28,FOLLOW_28_in_synpred86_ObjCpp2239); if (state.failed) return ;
        	    pushFollow(FOLLOW_templateArgDecl_in_synpred86_ObjCpp2241);
        	    templateArgDecl();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop139;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred86_ObjCpp

    // $ANTLR start synpred89_ObjCpp
    public final void synpred89_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:894:4: (a1= argDef ( ',' ax= argDef )* )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:894:4: a1= argDef ( ',' ax= argDef )*
        {
        pushFollow(FOLLOW_argDef_in_synpred89_ObjCpp2317);
        a1=argDef();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:898:4: ( ',' ax= argDef )*
        loop140:
        do {
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==28) ) {
                alt140=1;
            }


            switch (alt140) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:899:5: ',' ax= argDef
        	    {
        	    match(input,28,FOLLOW_28_in_synpred89_ObjCpp2330); if (state.failed) return ;
        	    pushFollow(FOLLOW_argDef_in_synpred89_ObjCpp2339);
        	    ax=argDef();

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
    // $ANTLR end synpred89_ObjCpp

    // $ANTLR start synpred91_ObjCpp
    public final void synpred91_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.argDef_return a1 = null;

        ObjCppParser.argDef_return ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:914:4: (a1= argDef ( ',' ax= argDef )* )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:914:4: a1= argDef ( ',' ax= argDef )*
        {
        pushFollow(FOLLOW_argDef_in_synpred91_ObjCpp2392);
        a1=argDef();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:918:4: ( ',' ax= argDef )*
        loop141:
        do {
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==28) ) {
                alt141=1;
            }


            switch (alt141) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:919:5: ',' ax= argDef
        	    {
        	    match(input,28,FOLLOW_28_in_synpred91_ObjCpp2405); if (state.failed) return ;
        	    pushFollow(FOLLOW_argDef_in_synpred91_ObjCpp2414);
        	    ax=argDef();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop141;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred91_ObjCpp

    // $ANTLR start synpred92_ObjCpp
    public final void synpred92_ObjCpp_fragment() throws RecognitionException {   
        TypeMutator m1 = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:933:4: ( (m1= typeMutator ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:933:4: (m1= typeMutator )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:933:4: (m1= typeMutator )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:934:5: m1= typeMutator
        {
        pushFollow(FOLLOW_typeMutator_in_synpred92_ObjCpp2470);
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


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:938:4: ( (f1= functionSignatureSuffix ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:938:4: (f1= functionSignatureSuffix )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:938:4: (f1= functionSignatureSuffix )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:939:5: f1= functionSignatureSuffix
        {
        pushFollow(FOLLOW_functionSignatureSuffix_in_synpred93_ObjCpp2492);
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


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:956:4: ( ( typeMutator )* (fs= functionSignatureSuffix ) )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:956:4: ( typeMutator )* (fs= functionSignatureSuffix )
        {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:956:4: ( typeMutator )*
        loop142:
        do {
            int alt142=2;
            int LA142_0 = input.LA(1);

            if ( ((LA142_0>=52 && LA142_0<=54)) ) {
                alt142=1;
            }


            switch (alt142) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:957:5: typeMutator
        	    {
        	    pushFollow(FOLLOW_typeMutator_in_synpred95_ObjCpp2538);
        	    typeMutator();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop142;
            }
        } while (true);

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:961:4: (fs= functionSignatureSuffix )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:962:5: fs= functionSignatureSuffix
        {
        pushFollow(FOLLOW_functionSignatureSuffix_in_synpred95_ObjCpp2559);
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


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:990:4: ( '=' dv= topLevelExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:990:4: '=' dv= topLevelExpr
        {
        match(input,29,FOLLOW_29_in_synpred99_ObjCpp2669); if (state.failed) return ;
        pushFollow(FOLLOW_topLevelExpr_in_synpred99_ObjCpp2677);
        dv=topLevelExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred99_ObjCpp

    // $ANTLR start synpred103_ObjCpp
    public final void synpred103_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1055:4: ({...}? => IDENTIFIER )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1055:4: {...}? => IDENTIFIER
        {
        if ( !(( Modifier.parseModifier(next()) == null )) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred103_ObjCpp", " Modifier.parseModifier(next()) == null ");
        }
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred103_ObjCpp2923); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred103_ObjCpp

    // $ANTLR start synpred107_ObjCpp
    public final void synpred107_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.argDef_return ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1099:5: ( ',' ax= argDef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1099:5: ',' ax= argDef
        {
        match(input,28,FOLLOW_28_in_synpred107_ObjCpp3044); if (state.failed) return ;
        pushFollow(FOLLOW_argDef_in_synpred107_ObjCpp3053);
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


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1094:4: (a1= argDef ( ',' ax= argDef )* ( ',' '...' )? )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1094:4: a1= argDef ( ',' ax= argDef )* ( ',' '...' )?
        {
        pushFollow(FOLLOW_argDef_in_synpred109_ObjCpp3031);
        a1=argDef();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1098:4: ( ',' ax= argDef )*
        loop144:
        do {
            int alt144=2;
            int LA144_0 = input.LA(1);

            if ( (LA144_0==28) ) {
                int LA144_1 = input.LA(2);

                if ( (LA144_1==44) ) {
                    int LA144_3 = input.LA(3);

                    if ( (synpred107_ObjCpp()) ) {
                        alt144=1;
                    }


                }
                else if ( (LA144_1==EOF||LA144_1==IDENTIFIER||(LA144_1>=28 && LA144_1<=30)||LA144_1==34||(LA144_1>=48 && LA144_1<=50)||(LA144_1>=52 && LA144_1<=54)||LA144_1==57||LA144_1==59) ) {
                    alt144=1;
                }


            }


            switch (alt144) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1099:5: ',' ax= argDef
        	    {
        	    match(input,28,FOLLOW_28_in_synpred109_ObjCpp3044); if (state.failed) return ;
        	    pushFollow(FOLLOW_argDef_in_synpred109_ObjCpp3053);
        	    ax=argDef();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop144;
            }
        } while (true);

        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1104:4: ( ',' '...' )?
        int alt145=2;
        int LA145_0 = input.LA(1);

        if ( (LA145_0==28) ) {
            alt145=1;
        }
        switch (alt145) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1105:5: ',' '...'
                {
                match(input,28,FOLLOW_28_in_synpred109_ObjCpp3073); if (state.failed) return ;
                match(input,44,FOLLOW_44_in_synpred109_ObjCpp3075); if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred109_ObjCpp

    // $ANTLR start synpred111_ObjCpp
    public final void synpred111_ObjCpp_fragment() throws RecognitionException {   
        TypeRef an = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1153:4: ({...}? =>an= typeName )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1153:4: {...}? =>an= typeName
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
        pushFollow(FOLLOW_typeName_in_synpred111_ObjCpp3156);
        an=typeName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred111_ObjCpp

    // $ANTLR start synpred134_ObjCpp
    public final void synpred134_ObjCpp_fragment() throws RecognitionException {   
        TypeRef tr = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1211:4: (tr= mutableTypeRef )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1211:4: tr= mutableTypeRef
        {
        pushFollow(FOLLOW_mutableTypeRef_in_synpred134_ObjCpp3415);
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


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1223:5: (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1223:5: a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )*
        {
        pushFollow(FOLLOW_typeRefOrExpression_in_synpred136_ObjCpp3466);
        a1=typeRefOrExpression();

        state._fsp--;
        if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1224:5: ( ',' ax= typeRefOrExpression )*
        loop147:
        do {
            int alt147=2;
            int LA147_0 = input.LA(1);

            if ( (LA147_0==28) ) {
                alt147=1;
            }


            switch (alt147) {
        	case 1 :
        	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1225:6: ',' ax= typeRefOrExpression
        	    {
        	    match(input,28,FOLLOW_28_in_synpred136_ObjCpp3481); if (state.failed) return ;
        	    pushFollow(FOLLOW_typeRefOrExpression_in_synpred136_ObjCpp3491);
        	    ax=typeRefOrExpression();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop147;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred136_ObjCpp

    // $ANTLR start synpred137_ObjCpp
    public final void synpred137_ObjCpp_fragment() throws RecognitionException {   
        Expression a1 = null;

        Expression ax = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1222:4: ( '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1222:4: '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>'
        {
        match(input,36,FOLLOW_36_in_synpred137_ObjCpp3456); if (state.failed) return ;
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1222:8: (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )?
        int alt149=2;
        int LA149_0 = input.LA(1);

        if ( ((LA149_0>=DECIMAL_NUMBER && LA149_0<=FLOAT_NUMBER)||LA149_0==28||(LA149_0>=30 && LA149_0<=31)||LA149_0==34||(LA149_0>=42 && LA149_0<=43)||(LA149_0>=48 && LA149_0<=50)||(LA149_0>=52 && LA149_0<=54)||LA149_0==59||(LA149_0>=73 && LA149_0<=75)||(LA149_0>=88 && LA149_0<=91)) ) {
            alt149=1;
        }
        else if ( (LA149_0==37) ) {
            int LA149_2 = input.LA(2);

            if ( (synpred136_ObjCpp()) ) {
                alt149=1;
            }
        }
        switch (alt149) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1223:5: a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )*
                {
                pushFollow(FOLLOW_typeRefOrExpression_in_synpred137_ObjCpp3466);
                a1=typeRefOrExpression();

                state._fsp--;
                if (state.failed) return ;
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1224:5: ( ',' ax= typeRefOrExpression )*
                loop148:
                do {
                    int alt148=2;
                    int LA148_0 = input.LA(1);

                    if ( (LA148_0==28) ) {
                        alt148=1;
                    }


                    switch (alt148) {
                	case 1 :
                	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1225:6: ',' ax= typeRefOrExpression
                	    {
                	    match(input,28,FOLLOW_28_in_synpred137_ObjCpp3481); if (state.failed) return ;
                	    pushFollow(FOLLOW_typeRefOrExpression_in_synpred137_ObjCpp3491);
                	    ax=typeRefOrExpression();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }
                	    break;

                	default :
                	    break loop148;
                    }
                } while (true);


                }
                break;

        }

        match(input,37,FOLLOW_37_in_synpred137_ObjCpp3510); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred137_ObjCpp

    // $ANTLR start synpred148_ObjCpp
    public final void synpred148_ObjCpp_fragment() throws RecognitionException {   
        ObjCppParser.assignmentOp_return op = null;

        Expression f = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1299:4: (op= assignmentOp f= assignmentExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1299:4: op= assignmentOp f= assignmentExpr
        {
        pushFollow(FOLLOW_assignmentOp_in_synpred148_ObjCpp3823);
        op=assignmentOp();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_assignmentExpr_in_synpred148_ObjCpp3827);
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


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1395:4: (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1395:4: op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr
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

        pushFollow(FOLLOW_shiftExpr_in_synpred178_ObjCpp4431);
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


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1401:4: ( '(' tr= mutableTypeRef ')' inner= castExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1401:4: '(' tr= mutableTypeRef ')' inner= castExpr
        {
        match(input,34,FOLLOW_34_in_synpred179_ObjCpp4453); if (state.failed) return ;
        pushFollow(FOLLOW_mutableTypeRef_in_synpred179_ObjCpp4457);
        tr=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred179_ObjCpp4459); if (state.failed) return ;
        pushFollow(FOLLOW_castExpr_in_synpred179_ObjCpp4463);
        inner=castExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred179_ObjCpp

    // $ANTLR start synpred180_ObjCpp
    public final void synpred180_ObjCpp_fragment() throws RecognitionException {   
        Expression p = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1407:3: (p= postfixExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1407:3: p= postfixExpr
        {
        pushFollow(FOLLOW_postfixExpr_in_synpred180_ObjCpp4496);
        p=postfixExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred180_ObjCpp

    // $ANTLR start synpred181_ObjCpp
    public final void synpred181_ObjCpp_fragment() throws RecognitionException {   
        Expression.UnaryOperator uo = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1408:3: (uo= unaryOp castExpr )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1408:3: uo= unaryOp castExpr
        {
        pushFollow(FOLLOW_unaryOp_in_synpred181_ObjCpp4506);
        uo=unaryOp();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_castExpr_in_synpred181_ObjCpp4508);
        castExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred181_ObjCpp

    // $ANTLR start synpred182_ObjCpp
    public final void synpred182_ObjCpp_fragment() throws RecognitionException {   
        TypeRef tr = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1410:4: ( '(' tr= mutableTypeRef ')' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1410:4: '(' tr= mutableTypeRef ')'
        {
        match(input,34,FOLLOW_34_in_synpred182_ObjCpp4523); if (state.failed) return ;
        pushFollow(FOLLOW_mutableTypeRef_in_synpred182_ObjCpp4527);
        tr=mutableTypeRef();

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred182_ObjCpp4529); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred182_ObjCpp

    // $ANTLR start synpred200_ObjCpp
    public final void synpred200_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1495:3: ( declaration )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1495:3: declaration
        {
        pushFollow(FOLLOW_declaration_in_synpred200_ObjCpp4867);
        declaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred200_ObjCpp

    // $ANTLR start synpred201_ObjCpp
    public final void synpred201_ObjCpp_fragment() throws RecognitionException {   
        Expression es = null;


        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1496:3: (es= expression ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1496:3: es= expression ';'
        {
        pushFollow(FOLLOW_expression_in_synpred201_ObjCpp4876);
        es=expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,25,FOLLOW_25_in_synpred201_ObjCpp4878); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred201_ObjCpp

    // $ANTLR start synpred203_ObjCpp
    public final void synpred203_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1500:3: ( IDENTIFIER ':' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1500:3: IDENTIFIER ':'
        {
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred203_ObjCpp4902); if (state.failed) return ;
        match(input,33,FOLLOW_33_in_synpred203_ObjCpp4904); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred203_ObjCpp

    // $ANTLR start synpred205_ObjCpp
    public final void synpred205_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1502:40: ( 'else' statement )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1502:40: 'else' statement
        {
        match(input,96,FOLLOW_96_in_synpred205_ObjCpp4930); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred205_ObjCpp4932);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred205_ObjCpp

    // $ANTLR start synpred216_ObjCpp
    public final void synpred216_ObjCpp_fragment() throws RecognitionException {   
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1512:3: ( ';' )
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCpp.g:1512:3: ';'
        {
        match(input,25,FOLLOW_25_in_synpred216_ObjCpp5050); if (state.failed) return ;

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
    public final boolean synpred33_ObjCpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_ObjCpp_fragment(); // can never throw exception
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
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA78 dfa78 = new DFA78(this);
    protected DFA81 dfa81 = new DFA81(this);
    protected DFA87 dfa87 = new DFA87(this);
    protected DFA98 dfa98 = new DFA98(this);
    protected DFA99 dfa99 = new DFA99(this);
    protected DFA100 dfa100 = new DFA100(this);
    protected DFA111 dfa111 = new DFA111(this);
    protected DFA124 dfa124 = new DFA124(this);
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

                        else if ( (((synpred10_ObjCpp()&&( next("extern") ))||(synpred10_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||synpred10_ObjCpp()||(synpred10_ObjCpp()&&( next("__pragma") ))||(synpred10_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred10_ObjCpp()&&( next("__success") ))||(synpred10_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") )))) ) {s = 10;}

                         
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
            return "474:5: (m2= modifiers nb= enumBody | )";
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
                        if ( (((synpred21_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||(synpred21_ObjCpp()&&( next("__pragma") ))||(synpred21_ObjCpp()&&( next("__success") ))||(synpred21_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred21_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred21_ObjCpp()&&( next("extern") )))) ) {s = 2;}

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
        "\1\73\7\0\2\uffff\1\0\1\uffff";
    static final String DFA20_acceptS =
        "\10\uffff\1\1\2\uffff\1\2";
    static final String DFA20_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\2\uffff\1\7\1\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\1\22\uffff\1\12\4\uffff\1\4\2\uffff\1\10\1\7\15\uffff\3\3"+
            "\1\uffff\2\5\1\6\2\uffff\1\10\1\uffff\1\2",
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
                        if ( (((synpred32_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||(synpred32_ObjCpp()&&( next("__success") ))||synpred32_ObjCpp()||(synpred32_ObjCpp()&&( next("extern") ))||(synpred32_ObjCpp()&&( next("__pragma") ))||(synpred32_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred32_ObjCpp()&&( Modifier.parseModifier(next()) != null )))) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index20_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA20_2 = input.LA(1);

                         
                        int index20_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index20_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA20_3 = input.LA(1);

                         
                        int index20_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index20_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA20_4 = input.LA(1);

                         
                        int index20_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index20_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA20_5 = input.LA(1);

                         
                        int index20_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index20_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA20_6 = input.LA(1);

                         
                        int index20_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index20_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA20_7 = input.LA(1);

                         
                        int index20_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index20_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA20_10 = input.LA(1);

                         
                        int index20_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_ObjCpp()) ) {s = 8;}

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
        "\1\111\2\0\14\uffff";
    static final String DFA34_acceptS =
        "\3\uffff\1\1\1\2\12\uffff";
    static final String DFA34_specialS =
        "\1\uffff\1\0\1\1\14\uffff}>";
    static final String[] DFA34_transitionS = {
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
            return "672:5: ( (m2= modifiers ( ':' ( 'public' )? parent= qualifiedIdentifier )? nb= structBody ) | )";
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
                        if ( (((synpred53_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||(synpred53_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred53_ObjCpp()&&( next("extern") ))||(synpred53_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||(synpred53_ObjCpp()&&( next("__pragma") ))||(synpred53_ObjCpp()&&( next("__success") )))) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index34_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA34_2 = input.LA(1);

                         
                        int index34_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_ObjCpp()) ) {s = 3;}

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
    static final String DFA61_eotS =
        "\16\uffff";
    static final String DFA61_eofS =
        "\1\1\15\uffff";
    static final String DFA61_minS =
        "\1\6\4\uffff\2\0\7\uffff";
    static final String DFA61_maxS =
        "\1\111\4\uffff\2\0\7\uffff";
    static final String DFA61_acceptS =
        "\1\uffff\1\3\12\uffff\1\1\1\2";
    static final String DFA61_specialS =
        "\5\uffff\1\0\1\1\7\uffff}>";
    static final String[] DFA61_transitionS = {
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
            return "()* loopback of 932:3: ( (m1= typeMutator ) | (f1= functionSignatureSuffix ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA61_5 = input.LA(1);

                         
                        int index61_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_ObjCpp()) ) {s = 13;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA61_6 = input.LA(1);

                         
                        int index61_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred92_ObjCpp()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index61_6);
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
    static final String DFA78_eotS =
        "\30\uffff";
    static final String DFA78_eofS =
        "\1\2\27\uffff";
    static final String DFA78_minS =
        "\1\4\1\0\3\uffff\3\0\20\uffff";
    static final String DFA78_maxS =
        "\1\133\1\0\3\uffff\3\0\20\uffff";
    static final String DFA78_acceptS =
        "\2\uffff\1\1\10\uffff\1\2\14\uffff";
    static final String DFA78_specialS =
        "\1\uffff\1\0\3\uffff\1\1\1\2\1\3\20\uffff}>";
    static final String[] DFA78_transitionS = {
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
            return "1210:1: typeRefOrExpression returns [Expression expr] : (tr= mutableTypeRef | e= topLevelExpr );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA78_1 = input.LA(1);

                         
                        int index78_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred134_ObjCpp()&&( next("__success") ))||(synpred134_ObjCpp()&&( next("extern") ))||(synpred134_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred134_ObjCpp()&&( next("__pragma") ))||(synpred134_ObjCpp()&&( Modifier.parseModifier(next()) != null ))||synpred134_ObjCpp()||(synpred134_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") )))) ) {s = 2;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index78_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA78_5 = input.LA(1);

                         
                        int index78_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred134_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index78_5);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA78_6 = input.LA(1);

                         
                        int index78_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred134_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index78_6);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA78_7 = input.LA(1);

                         
                        int index78_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred134_ObjCpp()) ) {s = 2;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index78_7);
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
        "\43\uffff";
    static final String DFA81_eofS =
        "\1\2\42\uffff";
    static final String DFA81_minS =
        "\1\6\1\0\41\uffff";
    static final String DFA81_maxS =
        "\1\135\1\0\41\uffff";
    static final String DFA81_acceptS =
        "\2\uffff\1\2\37\uffff\1\1";
    static final String DFA81_specialS =
        "\1\uffff\1\0\41\uffff}>";
    static final String[] DFA81_transitionS = {
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
            return "1221:3: ( '<' (a1= typeRefOrExpression ( ',' ax= typeRefOrExpression )* )? '>' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA81_1 = input.LA(1);

                         
                        int index81_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_ObjCpp()) ) {s = 34;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index81_1);
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
    static final String DFA87_eotS =
        "\14\uffff";
    static final String DFA87_eofS =
        "\1\2\13\uffff";
    static final String DFA87_minS =
        "\1\6\1\0\12\uffff";
    static final String DFA87_maxS =
        "\1\126\1\0\12\uffff";
    static final String DFA87_acceptS =
        "\2\uffff\1\2\4\uffff\1\1\4\uffff";
    static final String DFA87_specialS =
        "\1\uffff\1\0\12\uffff}>";
    static final String[] DFA87_transitionS = {
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
            return "1298:3: (op= assignmentOp f= assignmentExpr )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA87_1 = input.LA(1);

                         
                        int index87_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred148_ObjCpp()) ) {s = 7;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index87_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 87, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA98_eotS =
        "\24\uffff";
    static final String DFA98_eofS =
        "\1\1\23\uffff";
    static final String DFA98_minS =
        "\1\6\13\uffff\1\0\7\uffff";
    static final String DFA98_maxS =
        "\1\127\13\uffff\1\0\7\uffff";
    static final String DFA98_acceptS =
        "\1\uffff\1\2\21\uffff\1\1";
    static final String DFA98_specialS =
        "\14\uffff\1\0\7\uffff}>";
    static final String[] DFA98_transitionS = {
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
            return "()* loopback of 1394:3: (op= ( '<' | '<=' | '>' | '>=' ) f= shiftExpr )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA98_12 = input.LA(1);

                         
                        int index98_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred178_ObjCpp()) ) {s = 19;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index98_12);
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
            return "1400:1: castExpr returns [Expression expr] : ( '(' tr= mutableTypeRef ')' inner= castExpr | e= unaryExpr );";
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
                        if ( (synpred179_ObjCpp()) ) {s = 17;}

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
    static final String DFA100_eotS =
        "\22\uffff";
    static final String DFA100_eofS =
        "\22\uffff";
    static final String DFA100_minS =
        "\1\4\1\0\20\uffff";
    static final String DFA100_maxS =
        "\1\133\1\0\20\uffff";
    static final String DFA100_acceptS =
        "\2\uffff\1\2\16\uffff\1\1";
    static final String DFA100_specialS =
        "\1\uffff\1\0\20\uffff}>";
    static final String[] DFA100_transitionS = {
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
            return "1409:12: ( '(' tr= mutableTypeRef ')' | unaryExpr )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA100_1 = input.LA(1);

                         
                        int index100_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred182_ObjCpp()) ) {s = 17;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index100_1);
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
    static final String DFA111_eotS =
        "\50\uffff";
    static final String DFA111_eofS =
        "\50\uffff";
    static final String DFA111_minS =
        "\1\4\1\uffff\1\0\4\uffff\4\0\1\uffff\2\0\32\uffff";
    static final String DFA111_maxS =
        "\1\144\1\uffff\1\0\4\uffff\4\0\1\uffff\2\0\32\uffff";
    static final String DFA111_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\15\uffff\1\3\14\uffff\1\4\1\6\1\7\1\10"+
        "\1\11\1\12\1\13\1\5\1\15\1\14";
    static final String DFA111_specialS =
        "\2\uffff\1\0\4\uffff\1\1\1\2\1\3\1\4\1\uffff\1\5\1\6\32\uffff}>";
    static final String[] DFA111_transitionS = {
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

    static final short[] DFA111_eot = DFA.unpackEncodedString(DFA111_eotS);
    static final short[] DFA111_eof = DFA.unpackEncodedString(DFA111_eofS);
    static final char[] DFA111_min = DFA.unpackEncodedStringToUnsignedChars(DFA111_minS);
    static final char[] DFA111_max = DFA.unpackEncodedStringToUnsignedChars(DFA111_maxS);
    static final short[] DFA111_accept = DFA.unpackEncodedString(DFA111_acceptS);
    static final short[] DFA111_special = DFA.unpackEncodedString(DFA111_specialS);
    static final short[][] DFA111_transition;

    static {
        int numStates = DFA111_transitionS.length;
        DFA111_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA111_transition[i] = DFA.unpackEncodedString(DFA111_transitionS[i]);
        }
    }

    class DFA111 extends DFA {

        public DFA111(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 111;
            this.eot = DFA111_eot;
            this.eof = DFA111_eof;
            this.min = DFA111_min;
            this.max = DFA111_max;
            this.accept = DFA111_accept;
            this.special = DFA111_special;
            this.transition = DFA111_transition;
        }
        public String getDescription() {
            return "1492:1: statement returns [Statement stat] : (b= statementsBlock | declaration | es= expression ';' | rt= 'return' rex= expression ';' | IDENTIFIER ':' | 'break' ';' | 'if' '(' topLevelExpr ')' statement ( 'else' statement )? | 'while' '(' topLevelExpr ')' statement | 'do' statement 'while' '(' topLevelExpr ')' ';' | 'for' '(' ( expression )? ';' ( expression )? ';' ( expression )? ')' statement | 'switch' '(' expression ')' '{' ( 'case' topLevelExpr ':' | statement )* '}' | ';' | {...}? IDENTIFIER '(' varDecl ':' expression ')' statement );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA111_2 = input.LA(1);

                         
                        int index111_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred200_ObjCpp()) ) {s = 3;}

                        else if ( (synpred201_ObjCpp()) ) {s = 17;}

                        else if ( (synpred203_ObjCpp()) ) {s = 37;}

                        else if ( (( next("foreach") )) ) {s = 38;}

                         
                        input.seek(index111_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA111_7 = input.LA(1);

                         
                        int index111_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred200_ObjCpp()) ) {s = 3;}

                        else if ( (synpred201_ObjCpp()) ) {s = 17;}

                         
                        input.seek(index111_7);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA111_8 = input.LA(1);

                         
                        int index111_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred200_ObjCpp()) ) {s = 3;}

                        else if ( (synpred201_ObjCpp()) ) {s = 17;}

                         
                        input.seek(index111_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA111_9 = input.LA(1);

                         
                        int index111_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred200_ObjCpp()) ) {s = 3;}

                        else if ( (synpred201_ObjCpp()) ) {s = 17;}

                         
                        input.seek(index111_9);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA111_10 = input.LA(1);

                         
                        int index111_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred200_ObjCpp()) ) {s = 3;}

                        else if ( (synpred201_ObjCpp()) ) {s = 17;}

                         
                        input.seek(index111_10);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA111_12 = input.LA(1);

                         
                        int index111_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred200_ObjCpp()) ) {s = 3;}

                        else if ( (synpred216_ObjCpp()) ) {s = 39;}

                         
                        input.seek(index111_12);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA111_13 = input.LA(1);

                         
                        int index111_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred200_ObjCpp()) ) {s = 3;}

                        else if ( (synpred201_ObjCpp()) ) {s = 17;}

                         
                        input.seek(index111_13);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 111, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA124_eotS =
        "\14\uffff";
    static final String DFA124_eofS =
        "\14\uffff";
    static final String DFA124_minS =
        "\1\6\7\0\2\uffff\1\0\1\uffff";
    static final String DFA124_maxS =
        "\1\73\7\0\2\uffff\1\0\1\uffff";
    static final String DFA124_acceptS =
        "\10\uffff\1\1\2\uffff\1\2";
    static final String DFA124_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\2\uffff\1\7\1\uffff}>";
    static final String[] DFA124_transitionS = {
            "\1\1\22\uffff\1\12\4\uffff\1\4\2\uffff\1\10\1\7\15\uffff\3\3"+
            "\1\uffff\2\5\1\6\2\uffff\1\10\1\uffff\1\2",
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

    static final short[] DFA124_eot = DFA.unpackEncodedString(DFA124_eotS);
    static final short[] DFA124_eof = DFA.unpackEncodedString(DFA124_eofS);
    static final char[] DFA124_min = DFA.unpackEncodedStringToUnsignedChars(DFA124_minS);
    static final char[] DFA124_max = DFA.unpackEncodedStringToUnsignedChars(DFA124_maxS);
    static final short[] DFA124_accept = DFA.unpackEncodedString(DFA124_acceptS);
    static final short[] DFA124_special = DFA.unpackEncodedString(DFA124_specialS);
    static final short[][] DFA124_transition;

    static {
        int numStates = DFA124_transitionS.length;
        DFA124_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA124_transition[i] = DFA.unpackEncodedString(DFA124_transitionS[i]);
        }
    }

    class DFA124 extends DFA {

        public DFA124(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 124;
            this.eot = DFA124_eot;
            this.eof = DFA124_eof;
            this.min = DFA124_min;
            this.max = DFA124_max;
            this.accept = DFA124_accept;
            this.special = DFA124_special;
            this.transition = DFA124_transition;
        }
        public String getDescription() {
            return "536:6: (fv= varDecl ( ':' bits= DECIMAL_NUMBER )? ';' | functionPointerVarDecl )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA124_1 = input.LA(1);

                         
                        int index124_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred32_ObjCpp()&&( next("__declspec", "__attribute__", "__asm") ))||synpred32_ObjCpp()||(synpred32_ObjCpp()&&( next("__success") ))||(synpred32_ObjCpp()&&( next("__pragma") ))||(synpred32_ObjCpp()&&( next(Modifier.Kind.VCAnnotation1Arg, Modifier.Kind.VCAnnotation2Args) ))||(synpred32_ObjCpp()&&( next("extern") ))||(synpred32_ObjCpp()&&( Modifier.parseModifier(next()) != null )))) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index124_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA124_2 = input.LA(1);

                         
                        int index124_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index124_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA124_3 = input.LA(1);

                         
                        int index124_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index124_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA124_4 = input.LA(1);

                         
                        int index124_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index124_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA124_5 = input.LA(1);

                         
                        int index124_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index124_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA124_6 = input.LA(1);

                         
                        int index124_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index124_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA124_7 = input.LA(1);

                         
                        int index124_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index124_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA124_10 = input.LA(1);

                         
                        int index124_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_ObjCpp()) ) {s = 8;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index124_10);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 124, _s, input);
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
    public static final BitSet FOLLOW_varDecl_in_objCClassDef935 = new BitSet(new long[]{0x0000000202000000L});
    public static final BitSet FOLLOW_33_in_objCClassDef939 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_objCClassDef943 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_objCClassDef948 = new BitSet(new long[]{0x080701C041000040L});
    public static final BitSet FOLLOW_functionPointerVarDecl_in_objCClassDef960 = new BitSet(new long[]{0x080701C041000040L});
    public static final BitSet FOLLOW_24_in_objCClassDef987 = new BitSet(new long[]{0x0C070E0040000040L});
    public static final BitSet FOLLOW_objCMethodDecl_in_objCClassDef1005 = new BitSet(new long[]{0x0C070E0040000040L});
    public static final BitSet FOLLOW_typeDef_in_objCClassDef1014 = new BitSet(new long[]{0x0C070E0040000040L});
    public static final BitSet FOLLOW_varDecl_in_objCClassDef1025 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_objCClassDef1027 = new BitSet(new long[]{0x0C070E0040000040L});
    public static final BitSet FOLLOW_41_in_objCClassDef1040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_objCMethodDecl1074 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_43_in_objCMethodDecl1086 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl1105 = new BitSet(new long[]{0x0807000840000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_objCMethodDecl1113 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl1121 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1132 = new BitSet(new long[]{0x0000000202000000L});
    public static final BitSet FOLLOW_33_in_objCMethodDecl1144 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl1146 = new BitSet(new long[]{0x0807000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_objCMethodDecl1150 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl1152 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1156 = new BitSet(new long[]{0x0000000012000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1171 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodDecl1173 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_objCMethodDecl1180 = new BitSet(new long[]{0x0807000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_objCMethodDecl1184 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_objCMethodDecl1186 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodDecl1195 = new BitSet(new long[]{0x0000000012000040L});
    public static final BitSet FOLLOW_28_in_objCMethodDecl1214 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_objCMethodDecl1216 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_objCMethodDecl1233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_structBody1254 = new BitSet(new long[]{0x0D07E001CD000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_45_in_structBody1272 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_46_in_structBody1284 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_47_in_structBody1296 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_structBody1307 = new BitSet(new long[]{0x0D07E001CD000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_declaration_in_structBody1315 = new BitSet(new long[]{0x0D07E001CD000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_24_in_structBody1327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_structCore1368 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_modifiers_in_structCore1389 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_structBody_in_structCore1404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedIdentifier_in_structCore1416 = new BitSet(new long[]{0x0000000200800042L});
    public static final BitSet FOLLOW_modifiers_in_structCore1441 = new BitSet(new long[]{0x0000000200800000L});
    public static final BitSet FOLLOW_33_in_structCore1460 = new BitSet(new long[]{0x0000200000000040L});
    public static final BitSet FOLLOW_45_in_structCore1469 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_qualifiedIdentifier_in_structCore1481 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_structBody_in_structCore1501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binaryOp_in_anyOp1549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryOp_in_anyOp1558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentOp_in_anyOp1567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_functionDeclaration1602 = new BitSet(new long[]{0x0807000040000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_mutableTypeRef_in_functionDeclaration1610 = new BitSet(new long[]{0x0807000040000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_modifiers_in_functionDeclaration1619 = new BitSet(new long[]{0x0807000040000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_qualifiedCppFunctionName_in_functionDeclaration1627 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_argList_in_functionDeclaration1633 = new BitSet(new long[]{0x0000000202800040L});
    public static final BitSet FOLLOW_modifiers_in_functionDeclaration1641 = new BitSet(new long[]{0x0000000202800040L});
    public static final BitSet FOLLOW_33_in_functionDeclaration1652 = new BitSet(new long[]{0x0807000040000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_constructorInitializer_in_functionDeclaration1659 = new BitSet(new long[]{0x0000000212800040L});
    public static final BitSet FOLLOW_28_in_functionDeclaration1672 = new BitSet(new long[]{0x0807000040000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_constructorInitializer_in_functionDeclaration1676 = new BitSet(new long[]{0x0000000212800040L});
    public static final BitSet FOLLOW_25_in_functionDeclaration1699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_functionDeclaration1706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedCppFunctionName_in_constructorInitializer1729 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_constructorInitializer1737 = new BitSet(new long[]{0x00700C0C800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_topLevelExprList_in_constructorInitializer1746 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_constructorInitializer1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_modifiers1779 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_IDENTIFIER_in_pragmaContent1805 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_pragmaContent1807 = new BitSet(new long[]{0x00000C0E100007F0L});
    public static final BitSet FOLLOW_IDENTIFIER_in_pragmaContent1814 = new BitSet(new long[]{0x00000C0E100007F0L});
    public static final BitSet FOLLOW_constant_in_pragmaContent1818 = new BitSet(new long[]{0x00000C0E100007F0L});
    public static final BitSet FOLLOW_28_in_pragmaContent1822 = new BitSet(new long[]{0x00000C0E100007F0L});
    public static final BitSet FOLLOW_33_in_pragmaContent1826 = new BitSet(new long[]{0x00000C0E100007F0L});
    public static final BitSet FOLLOW_34_in_pragmaContent1830 = new BitSet(new long[]{0x00000C0A100007F0L});
    public static final BitSet FOLLOW_IDENTIFIER_in_pragmaContent1833 = new BitSet(new long[]{0x00000C0A100007F0L});
    public static final BitSet FOLLOW_constant_in_pragmaContent1837 = new BitSet(new long[]{0x00000C0A100007F0L});
    public static final BitSet FOLLOW_28_in_pragmaContent1841 = new BitSet(new long[]{0x00000C0A100007F0L});
    public static final BitSet FOLLOW_33_in_pragmaContent1845 = new BitSet(new long[]{0x00000C0A100007F0L});
    public static final BitSet FOLLOW_35_in_pragmaContent1849 = new BitSet(new long[]{0x00000C0E100007F0L});
    public static final BitSet FOLLOW_35_in_pragmaContent1856 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_pragmaContent1861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pragmaContent_in_modifier1893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier1903 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_modifier1907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier1919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier1932 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_modifier1934 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_modifier1936 = new BitSet(new long[]{0xF2300C3000000000L,0x00000000000000FFL});
    public static final BitSet FOLLOW_binaryOp_in_modifier1938 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_modifier1940 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_modifier1943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier1960 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_modifier1962 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_modifier1964 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_modifier1966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_modifier1980 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_modifier1984 = new BitSet(new long[]{0x0000000800000060L});
    public static final BitSet FOLLOW_STRING_in_modifier1995 = new BitSet(new long[]{0x0000000800000020L});
    public static final BitSet FOLLOW_extendedModifiers_in_modifier2007 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_modifier2015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_extendedModifiers2044 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_mutableTypeRef_in_argDef2087 = new BitSet(new long[]{0x0230000420000042L});
    public static final BitSet FOLLOW_declarator_in_argDef2102 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_argDef2114 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_topLevelExpr_in_argDef2118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_argDef2132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_typeMutator2154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_typeMutator2168 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_typeMutator2170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_arrayTypeMutator2188 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_arrayTypeMutator2194 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_arrayTypeMutator2203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_templateDef2231 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_templateDef2233 = new BitSet(new long[]{0x0807102040000040L});
    public static final BitSet FOLLOW_templateArgDecl_in_templateDef2236 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_templateDef2239 = new BitSet(new long[]{0x0807100040000040L});
    public static final BitSet FOLLOW_templateArgDecl_in_templateDef2241 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_templateDef2248 = new BitSet(new long[]{0x0D070001CC000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_declaration_in_templateDef2252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argDef_in_templateArgDecl2267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffix2287 = new BitSet(new long[]{0x0010000000000040L});
    public static final BitSet FOLLOW_modifiers_in_functionSignatureSuffix2291 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_functionSignatureSuffix2293 = new BitSet(new long[]{0x0000000800000040L});
    public static final BitSet FOLLOW_modifiers_in_functionSignatureSuffix2297 = new BitSet(new long[]{0x0000000800000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionSignatureSuffix2299 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffix2302 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffix2308 = new BitSet(new long[]{0x0807100840000040L});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffix2317 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_functionSignatureSuffix2330 = new BitSet(new long[]{0x0807100040000040L});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffix2339 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffix2354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffixNoName2371 = new BitSet(new long[]{0x0010000000000040L});
    public static final BitSet FOLLOW_modifiers_in_functionSignatureSuffixNoName2373 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_functionSignatureSuffixNoName2375 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffixNoName2377 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_functionSignatureSuffixNoName2383 = new BitSet(new long[]{0x0807100840000040L});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffixNoName2392 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_functionSignatureSuffixNoName2405 = new BitSet(new long[]{0x0807100040000040L});
    public static final BitSet FOLLOW_argDef_in_functionSignatureSuffixNoName2414 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_35_in_functionSignatureSuffixNoName2429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefCore_in_mutableTypeRef2449 = new BitSet(new long[]{0x0070000400000002L});
    public static final BitSet FOLLOW_typeMutator_in_mutableTypeRef2470 = new BitSet(new long[]{0x0070000400000002L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_mutableTypeRef2492 = new BitSet(new long[]{0x0070000400000002L});
    public static final BitSet FOLLOW_typeRefCore_in_nonMutableTypeRef2521 = new BitSet(new long[]{0x0070000400000002L});
    public static final BitSet FOLLOW_typeMutator_in_nonMutableTypeRef2538 = new BitSet(new long[]{0x0070000400000000L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_nonMutableTypeRef2559 = new BitSet(new long[]{0x0070000400000002L});
    public static final BitSet FOLLOW_modifiers_in_declarator2590 = new BitSet(new long[]{0x0230000400000040L});
    public static final BitSet FOLLOW_directDeclarator_in_declarator2606 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_set_in_declarator2630 = new BitSet(new long[]{0x0230000400000040L});
    public static final BitSet FOLLOW_declarator_in_declarator2648 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_declarator2669 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_topLevelExpr_in_declarator2677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_typeDef2713 = new BitSet(new long[]{0x0807000040000040L});
    public static final BitSet FOLLOW_varDecl_in_typeDef2718 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_typeDef2720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_varDeclEOF2738 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_varDeclEOF2740 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_varDeclEOF2742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_declarationEOF2762 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_declarationEOF2764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nonMutableTypeRef_in_varDecl2786 = new BitSet(new long[]{0x0230000400000042L});
    public static final BitSet FOLLOW_declaratorsList_in_varDecl2799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_objCProtocolRefList2818 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCProtocolRefList2823 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_objCProtocolRefList2833 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCProtocolRefList2839 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_objCProtocolRefList2849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarator_in_declaratorsList2870 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_declaratorsList2881 = new BitSet(new long[]{0x0230000400000040L});
    public static final BitSet FOLLOW_declarator_in_declaratorsList2889 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_directDeclarator2923 = new BitSet(new long[]{0x0040000400000002L});
    public static final BitSet FOLLOW_34_in_directDeclarator2933 = new BitSet(new long[]{0x0230000400000040L});
    public static final BitSet FOLLOW_declarator_in_directDeclarator2937 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_directDeclarator2939 = new BitSet(new long[]{0x0040000400000002L});
    public static final BitSet FOLLOW_54_in_directDeclarator2955 = new BitSet(new long[]{0x00F00C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_directDeclarator2967 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_directDeclarator2983 = new BitSet(new long[]{0x0040000400000002L});
    public static final BitSet FOLLOW_argList_in_directDeclarator2991 = new BitSet(new long[]{0x0040000400000002L});
    public static final BitSet FOLLOW_34_in_argList3019 = new BitSet(new long[]{0x0807100840000040L});
    public static final BitSet FOLLOW_argDef_in_argList3031 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_argList3044 = new BitSet(new long[]{0x0807100040000040L});
    public static final BitSet FOLLOW_argDef_in_argList3053 = new BitSet(new long[]{0x0000000810000000L});
    public static final BitSet FOLLOW_28_in_argList3073 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_argList3075 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_argList3094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_typeRefCore3127 = new BitSet(new long[]{0x0807000040000040L});
    public static final BitSet FOLLOW_59_in_typeRefCore3138 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_typeName_in_typeRefCore3142 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_typeName_in_typeRefCore3156 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_structCore_in_typeRefCore3165 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_enumCore_in_typeRefCore3174 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_modifiers_in_typeRefCore3187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedIdentifier_in_typeName3209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_objCMethodCall3229 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3233 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodCall3237 = new BitSet(new long[]{0x0080000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodCall3248 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3252 = new BitSet(new long[]{0x0080000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_objCMethodCall3267 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_objCMethodCall3269 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_objCMethodCall3273 = new BitSet(new long[]{0x0080000000000040L});
    public static final BitSet FOLLOW_55_in_objCMethodCall3290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_binaryOp3308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_typeRefOrExpression3415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_topLevelExpr_in_typeRefOrExpression3426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_simpleIdentifier3445 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_simpleIdentifier3456 = new BitSet(new long[]{0x08770C24C00007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_typeRefOrExpression_in_simpleIdentifier3466 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_simpleIdentifier3481 = new BitSet(new long[]{0x08770C04C00007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_typeRefOrExpression_in_simpleIdentifier3491 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_simpleIdentifier3510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleIdentifier_in_qualifiedIdentifier3532 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_qualifiedIdentifier3543 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_simpleIdentifier_in_qualifiedIdentifier3547 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_simpleCppFunctionName_in_qualifiedCppFunctionName3572 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_qualifiedCppFunctionName3583 = new BitSet(new long[]{0x0807000040000040L,0x0000000000000200L});
    public static final BitSet FOLLOW_simpleCppFunctionName_in_qualifiedCppFunctionName3587 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_73_in_simpleCppFunctionName3614 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_simpleIdentifier_in_simpleCppFunctionName3622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleIdentifier_in_baseExpression3644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_baseExpression3653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_baseExpression3661 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_baseExpression3663 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_baseExpression3665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objCMethodCall_in_baseExpression3673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selectorExpr_in_baseExpression3681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_protocolExpr_in_baseExpression3687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_encodingExpr_in_baseExpression3693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_selectorExpr3709 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_selectorExpr3714 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_selectorName_in_selectorExpr3719 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_selectorExpr3724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_selectorName3735 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_IDENTIFIER_in_selectorName3738 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_selectorName3740 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_31_in_protocolExpr3753 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_protocolExpr3757 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_protocolExpr3761 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_protocolExpr3765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_encodingExpr3776 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_encodingExpr3781 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_encodingExpr3785 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_encodingExpr3790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inlineCondExpr_in_assignmentExpr3807 = new BitSet(new long[]{0x0000000020000002L,0x00000000007FF000L});
    public static final BitSet FOLLOW_assignmentOp_in_assignmentExpr3823 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_assignmentExpr_in_assignmentExpr3827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_assignmentOp3853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logOrExpr_in_inlineCondExpr3918 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_inlineCondExpr3930 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_logOrExpr_in_inlineCondExpr3935 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_inlineCondExpr3941 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_logOrExpr_in_inlineCondExpr3946 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_multExpr_in_addExpr3968 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_set_in_addExpr3981 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_multExpr_in_addExpr3994 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_castExpr_in_multExpr4018 = new BitSet(new long[]{0x3010000000000002L});
    public static final BitSet FOLLOW_set_in_multExpr4032 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_castExpr_in_multExpr4050 = new BitSet(new long[]{0x3010000000000002L});
    public static final BitSet FOLLOW_xorExpr_in_bitOrExpr4074 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_bitOrExpr4088 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_xorExpr_in_bitOrExpr4095 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_equalExpr_in_bitAndExpr4119 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_53_in_bitAndExpr4132 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_equalExpr_in_bitAndExpr4139 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_addExpr_in_shiftExpr4164 = new BitSet(new long[]{0x4000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_set_in_shiftExpr4177 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_addExpr_in_shiftExpr4190 = new BitSet(new long[]{0x4000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_bitAndExpr_in_xorExpr4214 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_57_in_xorExpr4227 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_bitAndExpr_in_xorExpr4234 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_logAndExpr_in_logOrExpr4258 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_logOrExpr4271 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_logAndExpr_in_logOrExpr4278 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_bitOrExpr_in_logAndExpr4302 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_logAndExpr4315 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_bitOrExpr_in_logAndExpr4322 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_compareExpr_in_equalExpr4346 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_set_in_equalExpr4359 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_compareExpr_in_equalExpr4372 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_shiftExpr_in_compareExpr4396 = new BitSet(new long[]{0x0000003000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_set_in_compareExpr4409 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_shiftExpr_in_compareExpr4431 = new BitSet(new long[]{0x0000003000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_34_in_castExpr4453 = new BitSet(new long[]{0x0807000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_castExpr4457 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_castExpr4459 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_castExpr_in_castExpr4463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpr_in_castExpr4474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpr_in_unaryExpr4496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryOp_in_unaryExpr4506 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_castExpr_in_unaryExpr4508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_unaryExpr4516 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_34_in_unaryExpr4523 = new BitSet(new long[]{0x0807000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_unaryExpr4527 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_unaryExpr4529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpr_in_unaryExpr4537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_unaryOp4560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_baseExpression_in_postfixExpr4607 = new BitSet(new long[]{0x0040000400000002L,0x0000000036000100L});
    public static final BitSet FOLLOW_54_in_postfixExpr4618 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_postfixExpr4620 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_postfixExpr4622 = new BitSet(new long[]{0x0040000400000002L,0x0000000036000100L});
    public static final BitSet FOLLOW_34_in_postfixExpr4631 = new BitSet(new long[]{0x00700C0C800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_topLevelExprList_in_postfixExpr4633 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_postfixExpr4636 = new BitSet(new long[]{0x0040000400000002L,0x0000000036000100L});
    public static final BitSet FOLLOW_72_in_postfixExpr4645 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_simpleIdentifier_in_postfixExpr4649 = new BitSet(new long[]{0x0040000400000002L,0x0000000036000100L});
    public static final BitSet FOLLOW_92_in_postfixExpr4658 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_simpleIdentifier_in_postfixExpr4662 = new BitSet(new long[]{0x0040000400000002L,0x0000000036000100L});
    public static final BitSet FOLLOW_93_in_postfixExpr4671 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_simpleIdentifier_in_postfixExpr4675 = new BitSet(new long[]{0x0040000400000002L,0x0000000036000100L});
    public static final BitSet FOLLOW_89_in_postfixExpr4684 = new BitSet(new long[]{0x0040000400000002L,0x0000000036000100L});
    public static final BitSet FOLLOW_90_in_postfixExpr4693 = new BitSet(new long[]{0x0040000400000002L,0x0000000036000100L});
    public static final BitSet FOLLOW_assignmentExpr_in_topLevelExpr4717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_topLevelExpr_in_topLevelExprList4742 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_topLevelExprList4753 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_topLevelExpr_in_topLevelExprList4760 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_topLevelExprList_in_expression4784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_statementsBlock4818 = new BitSet(new long[]{0x0D7F0C07CF8007F0L,0x0000001ECF000E00L});
    public static final BitSet FOLLOW_statement_in_statementsBlock4828 = new BitSet(new long[]{0x0D7F0C07CF8007F0L,0x0000001ECF000E00L});
    public static final BitSet FOLLOW_24_in_statementsBlock4840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementsBlock_in_statement4859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_statement4867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement4876 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_statement4888 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_statement4892 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement4902 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement4904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_statement4911 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_statement4919 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4921 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_topLevelExpr_in_statement4923 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4925 = new BitSet(new long[]{0x0D7F0C07CE8007F0L,0x0000001ECF000E00L});
    public static final BitSet FOLLOW_statement_in_statement4927 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_statement4930 = new BitSet(new long[]{0x0D7F0C07CE8007F0L,0x0000001ECF000E00L});
    public static final BitSet FOLLOW_statement_in_statement4932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_statement4941 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4943 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_topLevelExpr_in_statement4945 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4947 = new BitSet(new long[]{0x0D7F0C07CE8007F0L,0x0000001ECF000E00L});
    public static final BitSet FOLLOW_statement_in_statement4949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_statement4956 = new BitSet(new long[]{0x0D7F0C07CE8007F0L,0x0000001ECF000E00L});
    public static final BitSet FOLLOW_statement_in_statement4958 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_statement4960 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4962 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_topLevelExpr_in_statement4964 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4966 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_statement4975 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement4977 = new BitSet(new long[]{0x00700C04820007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_statement4979 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4982 = new BitSet(new long[]{0x00700C04820007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_statement4984 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_statement4987 = new BitSet(new long[]{0x00700C0C800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_statement4989 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement4992 = new BitSet(new long[]{0x0D7F0C07CE8007F0L,0x0000001ECF000E00L});
    public static final BitSet FOLLOW_statement_in_statement4994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_statement5001 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement5003 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_statement5005 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement5007 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_statement5009 = new BitSet(new long[]{0x0D7F0C07CF8007F0L,0x0000003ECF000E00L});
    public static final BitSet FOLLOW_101_in_statement5022 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_topLevelExpr_in_statement5024 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement5026 = new BitSet(new long[]{0x0D7F0C07CF8007F0L,0x0000003ECF000E00L});
    public static final BitSet FOLLOW_statement_in_statement5034 = new BitSet(new long[]{0x0D7F0C07CF8007F0L,0x0000003ECF000E00L});
    public static final BitSet FOLLOW_24_in_statement5044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_statement5050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement5058 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_statement5060 = new BitSet(new long[]{0x0807000040000040L});
    public static final BitSet FOLLOW_varDecl_in_statement5062 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_statement5064 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_statement5066 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_statement5068 = new BitSet(new long[]{0x0D7F0C07CE8007F0L,0x0000001ECF000E00L});
    public static final BitSet FOLLOW_statement_in_statement5070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_constant5089 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_constant5098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEXADECIMAL_NUMBER_in_constant5106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OCTAL_NUMBER_in_constant5114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARACTER_in_constant5122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_constant5132 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_FLOAT_NUMBER_in_constant5141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_constant5152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pragmaContent_in_synpred6_ObjCpp269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_synpred8_ObjCpp286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_externDeclarations_in_synpred9_ObjCpp296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred10_ObjCpp306 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred10_ObjCpp308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_synpred21_ObjCpp678 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_enumBody_in_synpred21_ObjCpp689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_synpred24_ObjCpp767 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred24_ObjCpp771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred32_ObjCpp935 = new BitSet(new long[]{0x0000000202000000L});
    public static final BitSet FOLLOW_33_in_synpred32_ObjCpp939 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_synpred32_ObjCpp943 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred32_ObjCpp948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred33_ObjCpp935 = new BitSet(new long[]{0x0000000202000000L});
    public static final BitSet FOLLOW_33_in_synpred33_ObjCpp939 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_synpred33_ObjCpp943 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred33_ObjCpp948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionPointerVarDecl_in_synpred33_ObjCpp960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_synpred37_ObjCpp1025 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred37_ObjCpp1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred39_ObjCpp1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_synpred53_ObjCpp1441 = new BitSet(new long[]{0x0000000200800000L});
    public static final BitSet FOLLOW_33_in_synpred53_ObjCpp1460 = new BitSet(new long[]{0x0000200000000040L});
    public static final BitSet FOLLOW_45_in_synpred53_ObjCpp1469 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_qualifiedIdentifier_in_synpred53_ObjCpp1481 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_structBody_in_synpred53_ObjCpp1501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binaryOp_in_synpred54_ObjCpp1549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryOp_in_synpred55_ObjCpp1558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred56_ObjCpp1610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_synpred61_ObjCpp1779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_synpred71_ObjCpp1861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pragmaContent_in_synpred72_ObjCpp1893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred73_ObjCpp1903 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_synpred73_ObjCpp1907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred74_ObjCpp1919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred75_ObjCpp1932 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_synpred75_ObjCpp1934 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_synpred75_ObjCpp1936 = new BitSet(new long[]{0xF2300C3000000000L,0x00000000000000FFL});
    public static final BitSet FOLLOW_binaryOp_in_synpred75_ObjCpp1938 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_synpred75_ObjCpp1940 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred75_ObjCpp1943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred76_ObjCpp1960 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_synpred76_ObjCpp1962 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_expression_in_synpred76_ObjCpp1964 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred76_ObjCpp1966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_synpred78_ObjCpp1995 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_declarator_in_synpred80_ObjCpp2102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred82_ObjCpp2087 = new BitSet(new long[]{0x0230000420000042L});
    public static final BitSet FOLLOW_declarator_in_synpred82_ObjCpp2102 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_synpred82_ObjCpp2114 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_topLevelExpr_in_synpred82_ObjCpp2118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_templateArgDecl_in_synpred86_ObjCpp2236 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred86_ObjCpp2239 = new BitSet(new long[]{0x0807100040000040L});
    public static final BitSet FOLLOW_templateArgDecl_in_synpred86_ObjCpp2241 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_argDef_in_synpred89_ObjCpp2317 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred89_ObjCpp2330 = new BitSet(new long[]{0x0807100040000040L});
    public static final BitSet FOLLOW_argDef_in_synpred89_ObjCpp2339 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_argDef_in_synpred91_ObjCpp2392 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred91_ObjCpp2405 = new BitSet(new long[]{0x0807100040000040L});
    public static final BitSet FOLLOW_argDef_in_synpred91_ObjCpp2414 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred92_ObjCpp2470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_synpred93_ObjCpp2492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeMutator_in_synpred95_ObjCpp2538 = new BitSet(new long[]{0x0070000400000000L});
    public static final BitSet FOLLOW_functionSignatureSuffix_in_synpred95_ObjCpp2559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_synpred99_ObjCpp2669 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_topLevelExpr_in_synpred99_ObjCpp2677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred103_ObjCpp2923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_synpred107_ObjCpp3044 = new BitSet(new long[]{0x0807100040000040L});
    public static final BitSet FOLLOW_argDef_in_synpred107_ObjCpp3053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argDef_in_synpred109_ObjCpp3031 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred109_ObjCpp3044 = new BitSet(new long[]{0x0807100040000040L});
    public static final BitSet FOLLOW_argDef_in_synpred109_ObjCpp3053 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred109_ObjCpp3073 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_synpred109_ObjCpp3075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeName_in_synpred111_ObjCpp3156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred134_ObjCpp3415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefOrExpression_in_synpred136_ObjCpp3466 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_synpred136_ObjCpp3481 = new BitSet(new long[]{0x08770C04C00007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_typeRefOrExpression_in_synpred136_ObjCpp3491 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_36_in_synpred137_ObjCpp3456 = new BitSet(new long[]{0x08770C24C00007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_typeRefOrExpression_in_synpred137_ObjCpp3466 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_28_in_synpred137_ObjCpp3481 = new BitSet(new long[]{0x08770C04C00007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_typeRefOrExpression_in_synpred137_ObjCpp3491 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_37_in_synpred137_ObjCpp3510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentOp_in_synpred148_ObjCpp3823 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_assignmentExpr_in_synpred148_ObjCpp3827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred178_ObjCpp4409 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_shiftExpr_in_synpred178_ObjCpp4431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred179_ObjCpp4453 = new BitSet(new long[]{0x0807000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred179_ObjCpp4457 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred179_ObjCpp4459 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_castExpr_in_synpred179_ObjCpp4463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpr_in_synpred180_ObjCpp4496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryOp_in_synpred181_ObjCpp4506 = new BitSet(new long[]{0x00700C04800007F0L,0x000000000F000E00L});
    public static final BitSet FOLLOW_castExpr_in_synpred181_ObjCpp4508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_synpred182_ObjCpp4523 = new BitSet(new long[]{0x0807000040000040L});
    public static final BitSet FOLLOW_mutableTypeRef_in_synpred182_ObjCpp4527 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred182_ObjCpp4529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_synpred200_ObjCpp4867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred201_ObjCpp4876 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred201_ObjCpp4878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred203_ObjCpp4902 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_synpred203_ObjCpp4904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_synpred205_ObjCpp4930 = new BitSet(new long[]{0x0D7F0C07CE8007F0L,0x0000001ECF000E00L});
    public static final BitSet FOLLOW_statement_in_synpred205_ObjCpp4932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_synpred216_ObjCpp5050 = new BitSet(new long[]{0x0000000000000002L});

}