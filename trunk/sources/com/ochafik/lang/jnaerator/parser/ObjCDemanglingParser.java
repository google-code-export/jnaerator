// $ANTLR 3.1.2 /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g 2009-08-11 02:05:22
 
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

/**
	This grammar is by no mean complete.
	It is able to parse preprocessed C & Objective-C files and can tolerate some amount of C++. 
	It lacks serious expression support, which is being worked on.
	Complex variable declarations may not be supported, such as complex signatures of functions that return function pointers...
*/
public class ObjCDemanglingParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENTIFIER", "DECIMAL_NUMBER", "STRING", "Letter", "OCTAL_NUMBER", "OctalEscape", "CharEscape", "'^'", "'*'", "'@'", "'#'", "':'", "'?'", "'{'", "'='", "'}'", "'['", "']'", "'('", "')'", "'b'"
    };
    public static final int T__12=12;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int STRING=6;
    public static final int OCTAL_NUMBER=8;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__22=22;
    public static final int DECIMAL_NUMBER=5;
    public static final int Letter=7;
    public static final int T__17=17;
    public static final int EOF=-1;
    public static final int T__16=16;
    public static final int T__24=24;
    public static final int OctalEscape=9;
    public static final int CharEscape=10;
    public static final int IDENTIFIER=4;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public ObjCDemanglingParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ObjCDemanglingParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
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
    		predefRefs.put("B", typeRef("bool"));
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


        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:129:39: ( mangledType EOF )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:129:41: mangledType EOF
            {
            pushFollow(FOLLOW_mangledType_in_mangledTypeEOF60);
            mangledType1=mangledType();

            state._fsp--;

             type = mangledType1; 
            match(input,EOF,FOLLOW_EOF_in_mangledTypeEOF64); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
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


        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:131:2: ( structType | unionType | arrayType | primitiveType | '^' (pointed= mangledType ) )
            int alt1=5;
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

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:131:4: structType
                    {
                    pushFollow(FOLLOW_structType_in_mangledType76);
                    structType2=structType();

                    state._fsp--;

                     type = structType2; 

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:132:3: unionType
                    {
                    pushFollow(FOLLOW_unionType_in_mangledType84);
                    unionType3=unionType();

                    state._fsp--;

                     type = unionType3; 

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:133:3: arrayType
                    {
                    pushFollow(FOLLOW_arrayType_in_mangledType92);
                    arrayType4=arrayType();

                    state._fsp--;

                     type = arrayType4; 

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:134:3: primitiveType
                    {
                    pushFollow(FOLLOW_primitiveType_in_mangledType100);
                    primitiveType5=primitiveType();

                    state._fsp--;

                     type = primitiveType5; 

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:135:3: '^' (pointed= mangledType )
                    {
                    match(input,11,FOLLOW_11_in_mangledType108); 
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:135:7: (pointed= mangledType )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:137:4: pointed= mangledType
                    {
                    pushFollow(FOLLOW_mangledType_in_mangledType121);
                    pointed=mangledType();

                    state._fsp--;

                     
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
        return type;
    }
    // $ANTLR end "mangledType"


    // $ANTLR start "primitiveType"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:143:1: primitiveType returns [TypeRef type] : ({...}? IDENTIFIER | '*' | '@' | '#' | ':' | '?' );
    public final TypeRef primitiveType() throws RecognitionException {
        TypeRef type = null;

        Token IDENTIFIER6=null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:144:2: ({...}? IDENTIFIER | '*' | '@' | '#' | ':' | '?' )
            int alt2=6;
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

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:145:3: {...}? IDENTIFIER
                    {
                    if ( !(( isPredefRef(next()) )) ) {
                        throw new FailedPredicateException(input, "primitiveType", " isPredefRef(next()) ");
                    }
                    IDENTIFIER6=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primitiveType147); 

                    			type = getPredefRef((IDENTIFIER6!=null?IDENTIFIER6.getText():null));
                    		

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:148:3: '*'
                    {
                    match(input,12,FOLLOW_12_in_primitiveType155); 
                     type = new TypeRef.Pointer(typeRef("char"), PointerStyle.Pointer); 

                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:149:3: '@'
                    {
                    match(input,13,FOLLOW_13_in_primitiveType163); 
                     type = typeRef("id"); 

                    }
                    break;
                case 4 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:150:3: '#'
                    {
                    match(input,14,FOLLOW_14_in_primitiveType171); 
                     type = typeRef("Class"); 

                    }
                    break;
                case 5 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:151:3: ':'
                    {
                    match(input,15,FOLLOW_15_in_primitiveType179); 
                     type = typeRef("SEL"); 

                    }
                    break;
                case 6 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:152:3: '?'
                    {
                    match(input,16,FOLLOW_16_in_primitiveType187); 
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
        return type;
    }
    // $ANTLR end "primitiveType"


    // $ANTLR start "structType"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:155:1: structType returns [Struct type] : '{' (tagName= IDENTIFIER '=' ) (f= structField )* '}' ;
    public final Struct structType() throws RecognitionException {
        Struct type = null;

        Token tagName=null;
        VariablesDeclaration f = null;


        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:156:2: ( '{' (tagName= IDENTIFIER '=' ) (f= structField )* '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:156:4: '{' (tagName= IDENTIFIER '=' ) (f= structField )* '}'
            {
             
            			type = new Struct();
            			type.setType(Struct.Type.CStruct);
            			type.setForwardDeclaration(true);
            		
            match(input,17,FOLLOW_17_in_structType207); 
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:161:3: (tagName= IDENTIFIER '=' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:162:4: tagName= IDENTIFIER '='
            {
            tagName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_structType219); 
            match(input,18,FOLLOW_18_in_structType221); 

            				type.setTag(ident((tagName!=null?tagName.getText():null)));
            			

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:166:3: (f= structField )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==IDENTIFIER||LA3_0==STRING||(LA3_0>=11 && LA3_0<=17)||LA3_0==20||LA3_0==22||LA3_0==24) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:167:4: f= structField
            	    {
            	    pushFollow(FOLLOW_structField_in_structType239);
            	    f=structField();

            	    state._fsp--;


            	    				type.addDeclaration(f);
            	    				type.setForwardDeclaration(false);
            	    			

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,19,FOLLOW_19_in_structType250); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
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


        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:177:2: ( '[' (size= DECIMAL_NUMBER )? ct= mangledType ']' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:178:3: '[' (size= DECIMAL_NUMBER )? ct= mangledType ']'
            {
            match(input,20,FOLLOW_20_in_arrayType270); 
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:179:8: (size= DECIMAL_NUMBER )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==DECIMAL_NUMBER) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:179:8: size= DECIMAL_NUMBER
                    {
                    size=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_arrayType278); 

                    }
                    break;

            }

            pushFollow(FOLLOW_mangledType_in_arrayType286);
            ct=mangledType();

            state._fsp--;

             
            				type = new TypeRef.ArrayRef(ct, (size!=null?size.getText():null) == null ? null : expr(Constant.Type.Int, Integer.parseInt((size!=null?size.getText():null)))); 
            				
            			
            match(input,21,FOLLOW_21_in_arrayType292); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return type;
    }
    // $ANTLR end "arrayType"


    // $ANTLR start "unionType"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:187:1: unionType returns [Struct type] : '(' (tagName= IDENTIFIER '=' )? (f= structField )+ ')' ;
    public final Struct unionType() throws RecognitionException {
        Struct type = null;

        Token tagName=null;
        VariablesDeclaration f = null;


        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:188:2: ( '(' (tagName= IDENTIFIER '=' )? (f= structField )+ ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:188:4: '(' (tagName= IDENTIFIER '=' )? (f= structField )+ ')'
            {
             
            			type = new Struct();
            			type.setType(Struct.Type.CUnion);
            		
            match(input,22,FOLLOW_22_in_unionType312); 
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:192:3: (tagName= IDENTIFIER '=' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==IDENTIFIER) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==18) ) {
                    alt5=1;
                }
            }
            switch (alt5) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:193:4: tagName= IDENTIFIER '='
                    {
                    tagName=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_unionType324); 
                    match(input,18,FOLLOW_18_in_unionType326); 

                    				type.setTag(ident((tagName!=null?tagName.getText():null)));
                    			

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:197:3: (f= structField )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==IDENTIFIER||LA6_0==STRING||(LA6_0>=11 && LA6_0<=17)||LA6_0==20||LA6_0==22||LA6_0==24) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:198:4: f= structField
            	    {
            	    pushFollow(FOLLOW_structField_in_unionType346);
            	    f=structField();

            	    state._fsp--;

            	     type.addDeclaration(f); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            match(input,23,FOLLOW_23_in_unionType358); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return type;
    }
    // $ANTLR end "unionType"


    // $ANTLR start "structField"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:204:1: structField returns [VariablesDeclaration field] : (fieldName= STRING )? (fieldType= mangledType | 'b' bits= DECIMAL_NUMBER ) ;
    public final VariablesDeclaration structField() throws RecognitionException {
        VariablesDeclaration field = null;

        Token fieldName=null;
        Token bits=null;
        TypeRef fieldType = null;



        	DirectDeclarator declarator = null;

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:208:2: ( (fieldName= STRING )? (fieldType= mangledType | 'b' bits= DECIMAL_NUMBER ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:209:3: (fieldName= STRING )? (fieldType= mangledType | 'b' bits= DECIMAL_NUMBER )
            {
             
            			field = new VariablesDeclaration(); 
            			field.addDeclarator(declarator = new DirectDeclarator());
            		
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:213:3: (fieldName= STRING )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==STRING) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:214:4: fieldName= STRING
                    {
                    fieldName=(Token)match(input,STRING,FOLLOW_STRING_in_structField393); 

                    				declarator.setName(String.valueOf(Constant.parseString((fieldName!=null?fieldName.getText():null)).getValue()));
                    			

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:218:3: (fieldType= mangledType | 'b' bits= DECIMAL_NUMBER )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==IDENTIFIER||(LA8_0>=11 && LA8_0<=17)||LA8_0==20||LA8_0==22) ) {
                alt8=1;
            }
            else if ( (LA8_0==24) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:219:4: fieldType= mangledType
                    {
                    pushFollow(FOLLOW_mangledType_in_structField411);
                    fieldType=mangledType();

                    state._fsp--;


                    				field.setValueType(fieldType);
                    			

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/ObjCDemangling.g:222:4: 'b' bits= DECIMAL_NUMBER
                    {
                    match(input,24,FOLLOW_24_in_structField420); 
                    bits=(Token)match(input,DECIMAL_NUMBER,FOLLOW_DECIMAL_NUMBER_in_structField424); 

                    				declarator.setBits(Integer.parseInt((bits!=null?bits.getText():null)));
                    				field.setValueType(typeRef("int"));
                    			

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
    public static final BitSet FOLLOW_22_in_unionType312 = new BitSet(new long[]{0x000000000153F850L});
    public static final BitSet FOLLOW_IDENTIFIER_in_unionType324 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_unionType326 = new BitSet(new long[]{0x000000000153F850L});
    public static final BitSet FOLLOW_structField_in_unionType346 = new BitSet(new long[]{0x0000000001D3F850L});
    public static final BitSet FOLLOW_23_in_unionType358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_structField393 = new BitSet(new long[]{0x000000000153F810L});
    public static final BitSet FOLLOW_mangledType_in_structField411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_structField420 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_DECIMAL_NUMBER_in_structField424 = new BitSet(new long[]{0x0000000000000002L});

}