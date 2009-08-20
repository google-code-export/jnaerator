// $ANTLR 3.1.2 /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g 2009-08-20 22:47:41
 
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
import java.util.HashMap;
import java.util.HashSet;


import static com.ochafik.lang.jnaerator.parser.ElementsHelper.*;
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

import org.antlr.runtime.debug.*;
import java.io.IOException;
/**
	This grammar is by no mean complete.
	It is able to parse preprocessed C & Objective-C files and can tolerate some amount of C++. 
	It lacks serious expression support, which is being worked on.
	Complex variable declarations may not be supported, such as complex signatures of functions that return function pointers...
*/
public class ObjCDemanglingParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENTIFIER", "DECIMAL_NUMBER", "STRING", "Letter", "OCTAL_NUMBER", "OctalEscape", "CharEscape", "'^'", "'*'", "'@'", "'#'", "':'", "'?'", "'{'", "'='", "'}'", "'['", "']'", "'('", "')'", "'b'"
    };
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int IDENTIFIER=4;
    public static final int CharEscape=10;
    public static final int OctalEscape=9;
    public static final int Letter=7;
    public static final int OCTAL_NUMBER=8;
    public static final int STRING=6;
    public static final int DECIMAL_NUMBER=5;

    // delegates
    // delegators

    public static final String[] ruleNames = new String[] {
        "invalidRule", "unionType", "primitiveType", "mangledTypeEOF", "arrayType", 
        "structType", "methodType", "mangledType", "structField"
    };
     
        public int ruleLevel = 0;
        public int getRuleLevel() { return ruleLevel; }
        public void incRuleLevel() { ruleLevel++; }
        public void decRuleLevel() { ruleLevel--; }
        public ObjCDemanglingParser(TokenStream input) {
            this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
        }
        public ObjCDemanglingParser(TokenStream input, int port, RecognizerSharedState state) {
            super(input, state);
            DebugEventSocketProxy proxy =
                new DebugEventSocketProxy(this, port, null);
            setDebugListener(proxy);
            try {
                proxy.handshake();
            }
            catch (IOException ioe) {
                reportError(ioe);
            }
        }
    public ObjCDemanglingParser(TokenStream input, DebugEventListener dbg) {
        super(input, dbg, new RecognizerSharedState());

    }
    protected boolean evalPredicate(boolean result, String predicate) {
        dbg.semanticPredicate(result, predicate);
        return result;
    }


    public String[] getTokenNames() { return ObjCDemanglingParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g"; }


    	protected String next() {
    		return input.LT(1).getText();
    	}
    	
    	static HashMap<String, TypeRef> predefRefs = new HashMap<String, TypeRef>();
    	static {
    		predefRefs.put("c", typeRef("char"));
    		
    		predefRefs.put("i", typeRef("int"));
    		predefRefs.put("s", typeRef("short"));
    		predefRefs.put("l", typeRef("long"));
    		predefRefs.put("q", typeRef("long").addModifiers(Modifier.Long));
    		predefRefs.put("C", typeRef("char").addModifiers(Modifier.Unsigned));
    		predefRefs.put("I", typeRef("int").addModifiers(Modifier.Unsigned));
    		predefRefs.put("S", typeRef("short").addModifiers(Modifier.Unsigned));
    		predefRefs.put("L", typeRef("long").addModifiers(Modifier.Unsigned));
    		predefRefs.put("Q", typeRef("long").addModifiers(Modifier.Unsigned, Modifier.Long));
    		predefRefs.put("f", typeRef("float"));
    		predefRefs.put("d", typeRef("double"));
    		predefRefs.put("B", typeRef("BOOL"));
    		predefRefs.put("v", typeRef("void"));
    	}
    	boolean isPredefRef(String s) {
    		return predefRefs.containsKey(s);
    	}
    	public TypeRef getPredefRef(String s) {
    		return predefRefs.get(s).clone();
    	}



    // $ANTLR start "mangledTypeEOF"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:129:1: mangledTypeEOF returns [TypeRef type] : mangledType EOF ;
    public final TypeRef mangledTypeEOF() throws RecognitionException {
        TypeRef type = null;

        TypeRef mangledType1 = null;


        try { dbg.enterRule(getGrammarFileName(), "mangledTypeEOF");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(129, 1);

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:129:39: ( mangledType EOF )
            dbg.enterAlt(1);

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:129:41: mangledType EOF
            {
            dbg.location(129,41);
            pushFollow(FOLLOW_mangledType_in_mangledTypeEOF60);
            mangledType1=mangledType();

            state._fsp--;

            dbg.location(129,53);
             type = mangledType1; 
            dbg.location(129,84);
            match(input,EOF,FOLLOW_EOF_in_mangledTypeEOF64); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(129, 87);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "mangledTypeEOF");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return type;
    }
    // $ANTLR end "mangledTypeEOF"


    // $ANTLR start "mangledType"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:130:1: mangledType returns [TypeRef type] : ( structType | unionType | arrayType | primitiveType | '^' (pointed= mangledType ) );
    public final TypeRef mangledType() throws RecognitionException {
        TypeRef type = null;

        TypeRef pointed = null;

        Struct structType2 = null;

        Struct unionType3 = null;

        TypeRef arrayType4 = null;

        TypeRef primitiveType5 = null;


        try { dbg.enterRule(getGrammarFileName(), "mangledType");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(130, 1);

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:131:2: ( structType | unionType | arrayType | primitiveType | '^' (pointed= mangledType ) )
            int alt1=5;
            try { dbg.enterDecision(1);

            switch ( input.LA(1) ) {
            case 17:
                {
                alt1=1;
                }
                break;
            case 22:
                {
                alt1=2;
                }
                break;
            case 20:
                {
                alt1=3;
                }
                break;
            case IDENTIFIER:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                {
                alt1=4;
                }
                break;
            case 11:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(1);}

            switch (alt1) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:131:4: structType
                    {
                    dbg.location(131,4);
                    pushFollow(FOLLOW_structType_in_mangledType76);
                    structType2=structType();

                    state._fsp--;

                    dbg.location(131,15);
                     type = structType2; 

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:132:3: unionType
                    {
                    dbg.location(132,3);
                    pushFollow(FOLLOW_unionType_in_mangledType84);
                    unionType3=unionType();

                    state._fsp--;

                    dbg.location(132,13);
                     type = unionType3; 

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:133:3: arrayType
                    {
                    dbg.location(133,3);
                    pushFollow(FOLLOW_arrayType_in_mangledType92);
                    arrayType4=arrayType();

                    state._fsp--;

                    dbg.location(133,13);
                     type = arrayType4; 

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:134:3: primitiveType
                    {
                    dbg.location(134,3);
                    pushFollow(FOLLOW_primitiveType_in_mangledType100);
                    primitiveType5=primitiveType();

                    state._fsp--;

                    dbg.location(134,17);
                     type = primitiveType5; 

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:135:3: '^' (pointed= mangledType )
                    {
                    dbg.location(135,3);
                    match(input,11,FOLLOW_11_in_mangledType108); 
                    dbg.location(135,7);
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:135:7: (pointed= mangledType )
                    dbg.enterAlt(1);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:137:4: pointed= mangledType
                    {
                    dbg.location(137,11);
                    pushFollow(FOLLOW_mangledType_in_mangledType121);
                    pointed=mangledType();

                    state._fsp--;

                    dbg.location(137,24);
                     
                    				type = new TypeRef.Pointer(pointed, Declarator.PointerStyle.Pointer); 
                    			

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
        }
        dbg.location(141, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "mangledType");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return type;
    }
    // $ANTLR end "mangledType"


    // $ANTLR start "primitiveType"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:143:1: primitiveType returns [TypeRef type] : ({...}? IDENTIFIER | '*' | '@' | '#' | ':' | '?' );
    public final TypeRef primitiveType() throws RecognitionException {
        TypeRef type = null;

        Token IDENTIFIER6=null;

        try { dbg.enterRule(getGrammarFileName(), "primitiveType");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(143, 1);

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:144:2: ({...}? IDENTIFIER | '*' | '@' | '#' | ':' | '?' )
            int alt2=6;
            try { dbg.enterDecision(2);

            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            case 14:
                {
                alt2=4;
                }
                break;
            case 15:
                {
                alt2=5;
                }
                break;
            case 16:
                {
                alt2=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(2);}

            switch (alt2) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:145:3: {...}? IDENTIFIER
                    {
                    dbg.location(145,3);
                    if ( !(evalPredicate( isPredefRef(next()) ," isPredefRef(next()) ")) ) {
                        throw new FailedPredicateException(input, "primitiveType", " isPredefRef(next()) ");
                    }
                    dbg.location(145,28);
                    IDENTIFIER6=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primitiveType147); 
                    dbg.location(145,39);

                    			type = getPredefRef((IDENTIFIER6!=null?IDENTIFIER6.getText():null));
                    		

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:148:3: '*'
                    {
                    dbg.location(148,3);
                    match(input,12,FOLLOW_12_in_primitiveType155); 
                    dbg.location(148,7);
                     type = new TypeRef.Pointer(typeRef("char"), PointerStyle.Pointer); 

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:149:3: '@'
                    {
                    dbg.location(149,3);
                    match(input,13,FOLLOW_13_in_primitiveType163); 
                    dbg.location(149,7);
                     type = typeRef("id"); 

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:150:3: '#'
                    {
                    dbg.location(150,3);
                    match(input,14,FOLLOW_14_in_primitiveType171); 
                    dbg.location(150,7);
                     type = typeRef("Class"); 

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:151:3: ':'
                    {
                    dbg.location(151,3);
                    match(input,15,FOLLOW_15_in_primitiveType179); 
                    dbg.location(151,7);
                     type = typeRef("SEL"); 

                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:152:3: '?'
                    {
                    dbg.location(152,3);
                    match(input,16,FOLLOW_16_in_primitiveType187); 
                    dbg.location(152,7);
                     type = typeRef("__opaque_unknown_type"); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(153, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "primitiveType");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return type;
    }
    // $ANTLR end "primitiveType"


    // $ANTLR start "structType"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:155:1: structType returns [Struct type] : '{' (tagName= IDENTIFIER '=' ) (f= structField )* '}' ;
    public final Struct structType() throws RecognitionException {
        Struct type = null;

        Token tagName=null;
        VariablesDeclaration f = null;


        try { dbg.enterRule(getGrammarFileName(), "structType");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(155, 1);

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:156:2: ( '{' (tagName= IDENTIFIER '=' ) (f= structField )* '}' )
            dbg.enterAlt(1);

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:156:4: '{' (tagName= IDENTIFIER '=' ) (f= structField )* '}'
            {
            dbg.location(156,4);
             
            			type = new Struct();
            			type.setType(Struct.Type.CStruct);
            			type.setForwardDeclaration(true);
            		
            dbg.location(160,5);
            match(input,17,FOLLOW_17_in_structType207); 
            dbg.location(161,3);
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:161:3: (tagName= IDENTIFIER '=' )
            dbg.enterAlt(1);

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:162:4: tagName= IDENTIFIER '='
            {
            dbg.location(162,11);
            tagName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_structType219); 
            dbg.location(162,23);
            match(input,18,FOLLOW_18_in_structType221); 
            dbg.location(162,27);

            				type.setTag(ident((tagName!=null?tagName.getText():null)));
            			

            }

            dbg.location(166,3);
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:166:3: (f= structField )*
            try { dbg.enterSubRule(3);

            loop3:
            do {
                int alt3=2;
                try { dbg.enterDecision(3);

                int LA3_0 = input.LA(1);

                if ( (LA3_0==IDENTIFIER||LA3_0==STRING||(LA3_0>=11 && LA3_0<=17)||LA3_0==20||LA3_0==22||LA3_0==24) ) {
                    alt3=1;
                }


                } finally {dbg.exitDecision(3);}

                switch (alt3) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:167:4: f= structField
            	    {
            	    dbg.location(167,5);
            	    pushFollow(FOLLOW_structField_in_structType239);
            	    f=structField();

            	    state._fsp--;

            	    dbg.location(167,18);

            	    				type.addDeclaration(f);
            	    				type.setForwardDeclaration(false);
            	    			

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);
            } finally {dbg.exitSubRule(3);}

            dbg.location(172,3);
            match(input,19,FOLLOW_19_in_structType250); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(174, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "structType");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return type;
    }
    // $ANTLR end "structType"


    // $ANTLR start "arrayType"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:176:1: arrayType returns [TypeRef type] : '[' (size= DECIMAL_NUMBER )? ct= mangledType ']' ;
    public final TypeRef arrayType() throws RecognitionException {
        TypeRef type = null;

        Token size=null;
        TypeRef ct = null;


        try { dbg.enterRule(getGrammarFileName(), "arrayType");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(176, 1);

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:177:2: ( '[' (size= DECIMAL_NUMBER )? ct= mangledType ']' )
            dbg.enterAlt(1);

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:178:3: '[' (size= DECIMAL_NUMBER )? ct= mangledType ']'
            {
            dbg.location(178,3);
            match(input,20,FOLLOW_20_in_arrayType270); 
            dbg.location(179,8);
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:179:8: (size= DECIMAL_NUMBER )?
            int alt4=2;
            try { dbg.enterSubRule(4);
            try { dbg.enterDecision(4);

            int LA4_0 = input.LA(1);

            if ( (LA4_0==DECIMAL_NUMBER) ) {
                alt4=1;
            }
            } finally {dbg.exitDecision(4);}

            switch (alt4) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:179:8: size= DECIMAL_NUMBER
                    {
                    dbg.location(179,8);
                    size=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_arrayType278); 

                    }
                    break;

            }
            } finally {dbg.exitSubRule(4);}

            dbg.location(180,6);
            pushFollow(FOLLOW_mangledType_in_arrayType286);
            ct=mangledType();

            state._fsp--;

            dbg.location(180,19);
             
            				type = new TypeRef.ArrayRef(ct, (size!=null?size.getText():null) == null ? null : expr(Constant.Type.Int, Integer.parseInt((size!=null?size.getText():null)))); 
            				
            			
            dbg.location(184,3);
            match(input,21,FOLLOW_21_in_arrayType292); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(185, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "arrayType");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return type;
    }
    // $ANTLR end "arrayType"


    // $ANTLR start "methodType"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:187:1: methodType returns [Function method] : rt= mangledType DECIMAL_NUMBER '@' DECIMAL_NUMBER ':' DECIMAL_NUMBER (at= mangledType DECIMAL_NUMBER )* EOF ;
    public final Function methodType() throws RecognitionException {
        Function method = null;

        TypeRef rt = null;

        TypeRef at = null;


        try { dbg.enterRule(getGrammarFileName(), "methodType");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(187, 1);

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:188:2: (rt= mangledType DECIMAL_NUMBER '@' DECIMAL_NUMBER ':' DECIMAL_NUMBER (at= mangledType DECIMAL_NUMBER )* EOF )
            dbg.enterAlt(1);

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:189:3: rt= mangledType DECIMAL_NUMBER '@' DECIMAL_NUMBER ':' DECIMAL_NUMBER (at= mangledType DECIMAL_NUMBER )* EOF
            {
            dbg.location(189,5);
            pushFollow(FOLLOW_mangledType_in_methodType314);
            rt=mangledType();

            state._fsp--;

            dbg.location(189,18);

            			method = new Function(Function.Type.ObjCMethod, null, rt);
            		
            dbg.location(192,3);
            match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_methodType320); 
            dbg.location(193,3);
            match(input,13,FOLLOW_13_in_methodType325); 
            dbg.location(193,7);
            match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_methodType327); 
            dbg.location(193,22);
            match(input,15,FOLLOW_15_in_methodType329); 
            dbg.location(193,26);
            match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_methodType331); 
            dbg.location(194,3);
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:194:3: (at= mangledType DECIMAL_NUMBER )*
            try { dbg.enterSubRule(5);

            loop5:
            do {
                int alt5=2;
                try { dbg.enterDecision(5);

                int LA5_0 = input.LA(1);

                if ( (LA5_0==IDENTIFIER||(LA5_0>=11 && LA5_0<=17)||LA5_0==20||LA5_0==22) ) {
                    alt5=1;
                }


                } finally {dbg.exitDecision(5);}

                switch (alt5) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:195:4: at= mangledType DECIMAL_NUMBER
            	    {
            	    dbg.location(195,6);
            	    pushFollow(FOLLOW_mangledType_in_methodType343);
            	    at=mangledType();

            	    state._fsp--;

            	    dbg.location(195,19);
            	    match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_methodType345); 
            	    dbg.location(195,34);

            	    				method.addArg(new Arg(null, at));
            	    			

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);
            } finally {dbg.exitSubRule(5);}

            dbg.location(199,3);
            match(input,EOF,FOLLOW_EOF_in_methodType356); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(200, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "methodType");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return method;
    }
    // $ANTLR end "methodType"


    // $ANTLR start "unionType"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:201:1: unionType returns [Struct type] : '(' (tagName= IDENTIFIER '=' )? (f= structField )+ ')' ;
    public final Struct unionType() throws RecognitionException {
        Struct type = null;

        Token tagName=null;
        VariablesDeclaration f = null;


        try { dbg.enterRule(getGrammarFileName(), "unionType");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(201, 1);

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:202:2: ( '(' (tagName= IDENTIFIER '=' )? (f= structField )+ ')' )
            dbg.enterAlt(1);

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:202:4: '(' (tagName= IDENTIFIER '=' )? (f= structField )+ ')'
            {
            dbg.location(202,4);
             
            			type = new Struct();
            			type.setType(Struct.Type.CUnion);
            		
            dbg.location(205,5);
            match(input,22,FOLLOW_22_in_unionType372); 
            dbg.location(206,3);
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:206:3: (tagName= IDENTIFIER '=' )?
            int alt6=2;
            try { dbg.enterSubRule(6);
            try { dbg.enterDecision(6);

            int LA6_0 = input.LA(1);

            if ( (LA6_0==IDENTIFIER) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==18) ) {
                    alt6=1;
                }
            }
            } finally {dbg.exitDecision(6);}

            switch (alt6) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:207:4: tagName= IDENTIFIER '='
                    {
                    dbg.location(207,11);
                    tagName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_unionType384); 
                    dbg.location(207,23);
                    match(input,18,FOLLOW_18_in_unionType386); 
                    dbg.location(207,27);

                    				type.setTag(ident((tagName!=null?tagName.getText():null)));
                    			

                    }
                    break;

            }
            } finally {dbg.exitSubRule(6);}

            dbg.location(211,3);
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:211:3: (f= structField )+
            int cnt7=0;
            try { dbg.enterSubRule(7);

            loop7:
            do {
                int alt7=2;
                try { dbg.enterDecision(7);

                int LA7_0 = input.LA(1);

                if ( (LA7_0==IDENTIFIER||LA7_0==STRING||(LA7_0>=11 && LA7_0<=17)||LA7_0==20||LA7_0==22||LA7_0==24) ) {
                    alt7=1;
                }


                } finally {dbg.exitDecision(7);}

                switch (alt7) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:212:4: f= structField
            	    {
            	    dbg.location(212,5);
            	    pushFollow(FOLLOW_structField_in_unionType406);
            	    f=structField();

            	    state._fsp--;

            	    dbg.location(212,18);
            	     type.addDeclaration(f); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt7++;
            } while (true);
            } finally {dbg.exitSubRule(7);}

            dbg.location(214,3);
            match(input,23,FOLLOW_23_in_unionType418); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(216, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "unionType");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return type;
    }
    // $ANTLR end "unionType"


    // $ANTLR start "structField"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:218:1: structField returns [VariablesDeclaration field] : (fieldName= STRING )? (fieldType= mangledType | 'b' bits= DECIMAL_NUMBER ) ;
    public final VariablesDeclaration structField() throws RecognitionException {
        VariablesDeclaration field = null;

        Token fieldName=null;
        Token bits=null;
        TypeRef fieldType = null;



        	DirectDeclarator declarator = null;

        try { dbg.enterRule(getGrammarFileName(), "structField");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(218, 1);

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:222:2: ( (fieldName= STRING )? (fieldType= mangledType | 'b' bits= DECIMAL_NUMBER ) )
            dbg.enterAlt(1);

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:223:3: (fieldName= STRING )? (fieldType= mangledType | 'b' bits= DECIMAL_NUMBER )
            {
            dbg.location(223,3);
             
            			field = new VariablesDeclaration(); 
            			field.addDeclarator(declarator = new DirectDeclarator());
            		
            dbg.location(227,3);
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:227:3: (fieldName= STRING )?
            int alt8=2;
            try { dbg.enterSubRule(8);
            try { dbg.enterDecision(8);

            int LA8_0 = input.LA(1);

            if ( (LA8_0==STRING) ) {
                alt8=1;
            }
            } finally {dbg.exitDecision(8);}

            switch (alt8) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:228:4: fieldName= STRING
                    {
                    dbg.location(228,13);
                    fieldName=(Token)match(input,STRING,FOLLOW_STRING_in_structField453); 
                    dbg.location(228,21);

                    				declarator.setName(String.valueOf(Constant.parseString((fieldName!=null?fieldName.getText():null)).getValue()));
                    			

                    }
                    break;

            }
            } finally {dbg.exitSubRule(8);}

            dbg.location(232,3);
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:232:3: (fieldType= mangledType | 'b' bits= DECIMAL_NUMBER )
            int alt9=2;
            try { dbg.enterSubRule(9);
            try { dbg.enterDecision(9);

            int LA9_0 = input.LA(1);

            if ( (LA9_0==IDENTIFIER||(LA9_0>=11 && LA9_0<=17)||LA9_0==20||LA9_0==22) ) {
                alt9=1;
            }
            else if ( (LA9_0==24) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(9);}

            switch (alt9) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:233:4: fieldType= mangledType
                    {
                    dbg.location(233,13);
                    pushFollow(FOLLOW_mangledType_in_structField471);
                    fieldType=mangledType();

                    state._fsp--;

                    dbg.location(233,26);

                    				field.setValueType(fieldType);
                    			

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:236:4: 'b' bits= DECIMAL_NUMBER
                    {
                    dbg.location(236,4);
                    match(input,24,FOLLOW_24_in_structField480); 
                    dbg.location(236,12);
                    bits=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_structField484); 
                    dbg.location(236,28);

                    				declarator.setBits(Integer.parseInt((bits!=null?bits.getText():null)));
                    				field.setValueType(typeRef("int"));
                    			

                    }
                    break;

            }
            } finally {dbg.exitSubRule(9);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(241, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "structField");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return field;
    }
    // $ANTLR end "structField"

    // Delegated rules


 

    public static final BitSet FOLLOW_mangledType_in_mangledTypeEOF60 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_mangledTypeEOF64 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structType_in_mangledType76 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unionType_in_mangledType84 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayType_in_mangledType92 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_mangledType100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_mangledType108 = new BitSet(new long[]{0x000000000053F810L});
    public static final BitSet FOLLOW_mangledType_in_mangledType121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primitiveType147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_primitiveType155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_primitiveType163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_primitiveType171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_primitiveType179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_primitiveType187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_structType207 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_structType219 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_structType221 = new BitSet(new long[]{0x00000000015BF850L});
    public static final BitSet FOLLOW_structField_in_structType239 = new BitSet(new long[]{0x00000000015BF850L});
    public static final BitSet FOLLOW_19_in_structType250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_arrayType270 = new BitSet(new long[]{0x000000000053F830L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_arrayType278 = new BitSet(new long[]{0x000000000053F810L});
    public static final BitSet FOLLOW_mangledType_in_arrayType286 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_arrayType292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mangledType_in_methodType314 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_methodType320 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_methodType325 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_methodType327 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_methodType329 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_methodType331 = new BitSet(new long[]{0x000000000053F810L});
    public static final BitSet FOLLOW_mangledType_in_methodType343 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_methodType345 = new BitSet(new long[]{0x000000000053F810L});
    public static final BitSet FOLLOW_EOF_in_methodType356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_unionType372 = new BitSet(new long[]{0x000000000153F850L});
    public static final BitSet FOLLOW_IDENTIFIER_in_unionType384 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_unionType386 = new BitSet(new long[]{0x000000000153F850L});
    public static final BitSet FOLLOW_structField_in_unionType406 = new BitSet(new long[]{0x0000000001D3F850L});
    public static final BitSet FOLLOW_23_in_unionType418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_structField453 = new BitSet(new long[]{0x000000000153F810L});
    public static final BitSet FOLLOW_mangledType_in_structField471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_structField480 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_structField484 = new BitSet(new long[]{0x0000000000000002L});

}