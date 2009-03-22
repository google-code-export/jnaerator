// $ANTLR 3.1.1 /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g 2009-02-16 22:27:59
 
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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class XCodeProjectLexer extends Lexer {
    public static final int FloatingPointExponentSuffix=8;
    public static final int LINE_COMMENT=17;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int HexDigit=12;
    public static final int CHARACTER=5;
    public static final int T__19=19;
    public static final int WS=15;
    public static final int T__18=18;
    public static final int FloatingPointConstantSuffix=9;
    public static final int UnicodeEscape=13;
    public static final int IDENTIFIER=4;
    public static final int CharEscape=11;
    public static final int IntegerConstantSuffix=14;
    public static final int COMMENT=16;
    public static final int OctalEscape=10;
    public static final int Letter=7;
    public static final int STRING=6;

    // delegates
    // delegators

    public XCodeProjectLexer() {;} 
    public XCodeProjectLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public XCodeProjectLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g"; }

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:26:7: ( '{' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:26:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:27:7: ( '=' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:27:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:28:7: ( ';' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:28:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:29:7: ( '}' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:29:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:30:7: ( '(' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:30:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:31:7: ( ',' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:31:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:32:7: ( ')' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:32:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:142:2: ( '$' | '_' | 'A' .. 'Z' | 'a' .. 'z' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:
            {
            if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Letter"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:149:2: ( ( Letter | '0' .. '9' )* )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:149:4: ( Letter | '0' .. '9' )*
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:149:4: ( Letter | '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='$'||(LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "FloatingPointExponentSuffix"
    public final void mFloatingPointExponentSuffix() throws RecognitionException {
        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:157:2: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:157:4: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:158:3: ( '+' | '-' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='+'||LA2_0=='-') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:159:3: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:159:4: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "FloatingPointExponentSuffix"

    // $ANTLR start "FloatingPointConstantSuffix"
    public final void mFloatingPointConstantSuffix() throws RecognitionException {
        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:164:2: ( 'f' | 'F' | 'd' | 'D' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:
            {
            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "FloatingPointConstantSuffix"

    // $ANTLR start "CharEscape"
    public final void mCharEscape() throws RecognitionException {
        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:172:2: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | OctalEscape )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\\') ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1=='\"'||LA4_1=='\''||LA4_1=='\\'||LA4_1=='b'||LA4_1=='f'||LA4_1=='n'||LA4_1=='r'||LA4_1=='t') ) {
                    alt4=1;
                }
                else if ( ((LA4_1>='0' && LA4_1<='7')) ) {
                    alt4=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:172:4: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 
                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:183:3: OctalEscape
                    {
                    mOctalEscape(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "CharEscape"

    // $ANTLR start "OctalEscape"
    public final void mOctalEscape() throws RecognitionException {
        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:188:2: ( '\\\\' ( ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:188:4: '\\\\' ( ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) )
            {
            match('\\'); 
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:188:9: ( ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) )
            int alt5=3;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>='0' && LA5_0<='3')) ) {
                int LA5_1 = input.LA(2);

                if ( ((LA5_1>='0' && LA5_1<='7')) ) {
                    int LA5_3 = input.LA(3);

                    if ( ((LA5_3>='0' && LA5_3<='7')) ) {
                        alt5=1;
                    }
                    else {
                        alt5=2;}
                }
                else {
                    alt5=3;}
            }
            else if ( ((LA5_0>='4' && LA5_0<='7')) ) {
                int LA5_2 = input.LA(2);

                if ( ((LA5_2>='0' && LA5_2<='7')) ) {
                    alt5=2;
                }
                else {
                    alt5=3;}
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:189:4: ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:189:4: ( '0' .. '3' )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:189:5: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:189:15: ( '0' .. '7' )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:189:16: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:189:26: ( '0' .. '7' )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:189:27: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:190:4: ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:190:4: ( '0' .. '7' )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:190:5: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:190:15: ( '0' .. '7' )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:190:16: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:191:4: ( '0' .. '7' )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:191:4: ( '0' .. '7' )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:191:5: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "OctalEscape"

    // $ANTLR start "UnicodeEscape"
    public final void mUnicodeEscape() throws RecognitionException {
        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:197:2: ( '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:197:4: '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit
            {
            match('\\'); 
            match('u'); 
            mHexDigit(); 
            mHexDigit(); 
            mHexDigit(); 
            mHexDigit(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UnicodeEscape"

    // $ANTLR start "CHARACTER"
    public final void mCHARACTER() throws RecognitionException {
        try {
            int _type = CHARACTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:204:2: ( '\\'' ( CharEscape | ~ ( '\\\\' | '\\'' ) )+ '\\'' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:204:4: '\\'' ( CharEscape | ~ ( '\\\\' | '\\'' ) )+ '\\''
            {
            match('\''); 
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:205:3: ( CharEscape | ~ ( '\\\\' | '\\'' ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=3;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\\') ) {
                    alt6=1;
                }
                else if ( ((LA6_0>='\u0000' && LA6_0<='&')||(LA6_0>='(' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                    alt6=2;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:206:4: CharEscape
            	    {
            	    mCharEscape(); 

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:207:4: ~ ( '\\\\' | '\\'' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHARACTER"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:216:2: ( '\"' ( CharEscape | ~ ( '\\\\' | '\"' ) )* '\"' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:216:4: '\"' ( CharEscape | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:217:3: ( CharEscape | ~ ( '\\\\' | '\"' ) )*
            loop7:
            do {
                int alt7=3;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\\') ) {
                    alt7=1;
                }
                else if ( ((LA7_0>='\u0000' && LA7_0<='!')||(LA7_0>='#' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                    alt7=2;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:218:4: CharEscape
            	    {
            	    mCharEscape(); 

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:219:4: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "HexDigit"
    public final void mHexDigit() throws RecognitionException {
        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:230:2: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "HexDigit"

    // $ANTLR start "IntegerConstantSuffix"
    public final void mIntegerConstantSuffix() throws RecognitionException {
        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:237:2: ( ( 'u' | 'U' ) | ( ( 'l' | 'L' ) ( 'l' | 'L' )? ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='U'||LA9_0=='u') ) {
                alt9=1;
            }
            else if ( (LA9_0=='L'||LA9_0=='l') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:237:4: ( 'u' | 'U' )
                    {
                    if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:238:3: ( ( 'l' | 'L' ) ( 'l' | 'L' )? )
                    {
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:238:3: ( ( 'l' | 'L' ) ( 'l' | 'L' )? )
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:239:4: ( 'l' | 'L' ) ( 'l' | 'L' )?
                    {
                    if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:240:4: ( 'l' | 'L' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='L'||LA8_0=='l') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:
                            {
                            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }


                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "IntegerConstantSuffix"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:245:2: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:245:4: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            			_channel=HIDDEN;
            		

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:257:2: ( ( '/*' ( options {greedy=false; } : . )* '*/' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:257:4: ( '/*' ( options {greedy=false; } : . )* '*/' )
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:257:4: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:258:4: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:259:4: ( options {greedy=false; } : . )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='*') ) {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1=='/') ) {
                        alt10=2;
                    }
                    else if ( ((LA10_1>='\u0000' && LA10_1<='.')||(LA10_1>='0' && LA10_1<='\uFFFF')) ) {
                        alt10=1;
                    }


                }
                else if ( ((LA10_0>='\u0000' && LA10_0<=')')||(LA10_0>='+' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:259:32: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            match("*/"); 


            }

             
            			_channel=HIDDEN; 
            		

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:267:2: ( ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' ) )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:267:4: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:267:4: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:268:4: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:269:4: (~ ( '\\n' | '\\r' ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\u0000' && LA11_0<='\t')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:269:4: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:270:4: ( '\\r' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:270:4: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

             
            			_channel=HIDDEN;
            		

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LINE_COMMENT"

    public void mTokens() throws RecognitionException {
        // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:1:8: ( T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | IDENTIFIER | CHARACTER | STRING | WS | COMMENT | LINE_COMMENT )
        int alt13=13;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:1:10: T__18
                {
                mT__18(); 

                }
                break;
            case 2 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:1:16: T__19
                {
                mT__19(); 

                }
                break;
            case 3 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:1:22: T__20
                {
                mT__20(); 

                }
                break;
            case 4 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:1:28: T__21
                {
                mT__21(); 

                }
                break;
            case 5 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:1:34: T__22
                {
                mT__22(); 

                }
                break;
            case 6 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:1:40: T__23
                {
                mT__23(); 

                }
                break;
            case 7 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:1:46: T__24
                {
                mT__24(); 

                }
                break;
            case 8 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:1:52: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;
            case 9 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:1:63: CHARACTER
                {
                mCHARACTER(); 

                }
                break;
            case 10 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:1:73: STRING
                {
                mSTRING(); 

                }
                break;
            case 11 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:1:80: WS
                {
                mWS(); 

                }
                break;
            case 12 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:1:83: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 13 :
                // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:1:91: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\1\10\16\uffff";
    static final String DFA13_eofS =
        "\17\uffff";
    static final String DFA13_minS =
        "\1\11\13\uffff\1\52\2\uffff";
    static final String DFA13_maxS =
        "\1\175\13\uffff\1\57\2\uffff";
    static final String DFA13_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\uffff"+
        "\1\14\1\15";
    static final String DFA13_specialS =
        "\17\uffff}>";
    static final String[] DFA13_transitionS = {
            "\2\13\1\uffff\2\13\22\uffff\1\13\1\uffff\1\12\4\uffff\1\11\1"+
            "\5\1\7\2\uffff\1\6\2\uffff\1\14\13\uffff\1\3\1\uffff\1\2\75"+
            "\uffff\1\1\1\uffff\1\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\15\4\uffff\1\16",
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
            return "1:1: Tokens : ( T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | IDENTIFIER | CHARACTER | STRING | WS | COMMENT | LINE_COMMENT );";
        }
    }
 

}