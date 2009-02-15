// $ANTLR 3.1.1 /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g 2009-02-15 18:20:48
 
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

package com.ochafik.lang.grammar.objcpp;
import static com.ochafik.lang.grammar.objcpp.Expression.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ObjCppLexer extends Lexer {
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int EOF=-1;
    public static final int CHARACTER=10;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__90=90;
    public static final int COMMENT=21;
    public static final int T__99=99;
    public static final int OCTAL_NUMBER=9;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int DECIMAL_NUMBER=4;
    public static final int T__95=95;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int LINE_COMMENT=22;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int T__71=71;
    public static final int WS=20;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int FloatingPointConstantSuffix=14;
    public static final int IntegerConstantSuffix=19;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int Letter=12;
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
    public static final int HEXADECIMAL_NUMBER=8;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int HexDigit=17;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int IDENTIFIER=6;
    public static final int CharEscape=16;
    public static final int T__59=59;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int FLOAT_NUMBER=11;
    public static final int FloatingPointExponentSuffix=13;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
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
    public static final int UnicodeEscape=18;
    public static final int LONG=7;
    public static final int OctalEscape=15;
    public static final int STRING=5;

    // delegates
    // delegators

    public ObjCppLexer() {;} 
    public ObjCppLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ObjCppLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g"; }

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:27:7: ( '#line' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:27:9: '#line'
            {
            match("#line"); 


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
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:28:7: ( '{' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:28:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:29:7: ( '}' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:29:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:30:7: ( 'namespace' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:30:9: 'namespace'
            {
            match("namespace"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:31:7: ( '@class' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:31:9: '@class'
            {
            match("@class"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:32:7: ( ',' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:32:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:33:7: ( ';' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:33:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:34:7: ( '=' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:34:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:35:7: ( 'enum' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:35:9: 'enum'
            {
            match("enum"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:36:7: ( '@protocol' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:36:9: '@protocol'
            {
            match("@protocol"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:37:7: ( '@interface' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:37:9: '@interface'
            {
            match("@interface"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:38:7: ( ':' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:38:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:39:7: ( '(' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:39:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:40:7: ( ')' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:40:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:41:7: ( '<' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:41:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:42:7: ( '>' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:42:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:43:7: ( '@public' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:43:9: '@public'
            {
            match("@public"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:44:7: ( '@private' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:44:9: '@private'
            {
            match("@private"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:45:7: ( '@protected' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:45:9: '@protected'
            {
            match("@protected"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:46:7: ( '@end' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:46:9: '@end'
            {
            match("@end"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:47:7: ( '+' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:47:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:48:7: ( '-' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:48:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:49:7: ( '...' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:49:9: '...'
            {
            match("..."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:50:7: ( 'struct' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:50:9: 'struct'
            {
            match("struct"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:51:7: ( 'class' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:51:9: 'class'
            {
            match("class"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:52:7: ( 'union' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:52:9: 'union'
            {
            match("union"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:53:7: ( 'public' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:53:9: 'public'
            {
            match("public"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:54:7: ( 'private' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:54:9: 'private'
            {
            match("private"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:55:7: ( 'protected' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:55:9: 'protected'
            {
            match("protected"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:56:7: ( 'const' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:56:9: 'const'
            {
            match("const"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:57:7: ( '__const' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:57:9: '__const'
            {
            match("__const"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:58:7: ( '*' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:58:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:59:7: ( '&' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:59:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:60:7: ( '^' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:60:9: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:61:7: ( '[' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:61:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:62:7: ( ']' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:62:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:63:7: ( 'typedef' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:63:9: 'typedef'
            {
            match("typedef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:64:7: ( 'typename' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:64:9: 'typename'
            {
            match("typename"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:65:7: ( 'template' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:65:9: 'template'
            {
            match("template"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:66:7: ( 'signed' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:66:9: 'signed'
            {
            match("signed"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:67:7: ( 'unsigned' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:67:9: 'unsigned'
            {
            match("unsigned"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:68:7: ( '__signed' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:68:9: '__signed'
            {
            match("__signed"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:69:7: ( '__unsigned' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:69:9: '__unsigned'
            {
            match("__unsigned"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:70:7: ( 'short' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:70:9: 'short'
            {
            match("short"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:71:7: ( 'int' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:71:9: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:72:7: ( 'double' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:72:9: 'double'
            {
            match("double"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:73:7: ( 'float' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:73:9: 'float'
            {
            match("float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:74:7: ( 'char' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:74:9: 'char'
            {
            match("char"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:75:7: ( 'void' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:75:9: 'void'
            {
            match("void"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:76:7: ( '__int8' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:76:9: '__int8'
            {
            match("__int8"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:77:7: ( '__int16' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:77:9: '__int16'
            {
            match("__int16"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:78:7: ( '__int32' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:78:9: '__int32'
            {
            match("__int32"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:79:7: ( '__int64' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:79:9: '__int64'
            {
            match("__int64"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:80:7: ( 'sizeof' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:80:9: 'sizeof'
            {
            match("sizeof"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:81:7: ( '!' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:81:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:82:7: ( '~' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:82:9: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:83:7: ( '/' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:83:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:84:7: ( '%' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:84:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:85:7: ( '<<' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:85:9: '<<'
            {
            match("<<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:86:7: ( '>>>' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:86:9: '>>>'
            {
            match(">>>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:87:7: ( '>>' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:87:9: '>>'
            {
            match(">>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:88:7: ( '||' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:88:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:89:7: ( '|' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:89:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:90:7: ( '&&' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:90:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:91:7: ( '<=' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:91:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:92:7: ( '>=' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:92:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:93:7: ( '==' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:93:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:94:7: ( '!=' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:94:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:95:7: ( '.' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:95:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:96:7: ( '?' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:96:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:97:7: ( 'return' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:97:9: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:98:7: ( 'if' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:98:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:99:7: ( 'else' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:99:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:100:7: ( 'while' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:100:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:101:7: ( 'do' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:101:9: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:102:7: ( 'for' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:102:9: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:103:7: ( 'switch' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:103:9: 'switch'
            {
            match("switch"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:104:8: ( 'case' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:104:10: 'case'
            {
            match("case"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "LONG"
    public final void mLONG() throws RecognitionException {
        try {
            int _type = LONG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:809:6: ( 'long' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:809:8: 'long'
            {
            match("long"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LONG"

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:963:2: ( '$' | '_' | 'A' .. 'Z' | 'a' .. 'z' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:
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
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:970:2: ( Letter ( Letter | '0' .. '9' )* )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:970:4: Letter ( Letter | '0' .. '9' )*
            {
            mLetter(); 
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:971:3: ( Letter | '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='$'||(LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:
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
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:979:2: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:979:4: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:980:3: ( '+' | '-' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='+'||LA2_0=='-') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:
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

            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:981:3: ( '0' .. '9' )+
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
            	    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:981:4: '0' .. '9'
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
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:986:2: ( 'f' | 'F' | 'd' | 'D' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:
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
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:994:2: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | OctalEscape )
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
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:994:4: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1005:3: OctalEscape
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
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1010:2: ( '\\\\' ( ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ) )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1010:4: '\\\\' ( ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) )
            {
            match('\\'); 
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1010:9: ( ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) )
            int alt5=3;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>='0' && LA5_0<='3')) ) {
                int LA5_1 = input.LA(2);

                if ( ((LA5_1>='0' && LA5_1<='7')) ) {
                    int LA5_4 = input.LA(3);

                    if ( ((LA5_4>='0' && LA5_4<='7')) ) {
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
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1011:4: ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1011:4: ( '0' .. '3' )
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1011:5: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1011:15: ( '0' .. '7' )
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1011:16: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1011:26: ( '0' .. '7' )
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1011:27: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1012:4: ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1012:4: ( '0' .. '7' )
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1012:5: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1012:15: ( '0' .. '7' )
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1012:16: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1013:4: ( '0' .. '7' )
                    {
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1013:4: ( '0' .. '7' )
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1013:5: '0' .. '7'
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
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1019:2: ( '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1019:4: '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit
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
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1026:2: ( '\\'' ( CharEscape | ~ ( '\\\\' | '\\'' ) )+ '\\'' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1026:4: '\\'' ( CharEscape | ~ ( '\\\\' | '\\'' ) )+ '\\''
            {
            match('\''); 
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1027:3: ( CharEscape | ~ ( '\\\\' | '\\'' ) )+
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
            	    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1028:4: CharEscape
            	    {
            	    mCharEscape(); 

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1029:4: ~ ( '\\\\' | '\\'' )
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
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1038:2: ( '\"' ( CharEscape | ~ ( '\\\\' | '\"' ) )* '\"' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1038:4: '\"' ( CharEscape | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1039:3: ( CharEscape | ~ ( '\\\\' | '\"' ) )*
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
            	    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1040:4: CharEscape
            	    {
            	    mCharEscape(); 

            	    }
            	    break;
            	case 2 :
            	    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1041:4: ~ ( '\\\\' | '\"' )
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
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1052:2: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:
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
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1059:2: ( ( 'u' | 'U' ) | ( ( 'l' | 'L' ) ( 'l' | 'L' )? ) )
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
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1059:4: ( 'u' | 'U' )
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
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1060:3: ( ( 'l' | 'L' ) ( 'l' | 'L' )? )
                    {
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1060:3: ( ( 'l' | 'L' ) ( 'l' | 'L' )? )
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1061:4: ( 'l' | 'L' ) ( 'l' | 'L' )?
                    {
                    if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1062:4: ( 'l' | 'L' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='L'||LA8_0=='l') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:
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

    // $ANTLR start "HEXADECIMAL_NUMBER"
    public final void mHEXADECIMAL_NUMBER() throws RecognitionException {
        try {
            int _type = HEXADECIMAL_NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1067:2: ( '0' ( 'x' | 'X' ) ( HexDigit )+ ( IntegerConstantSuffix )? )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1067:4: '0' ( 'x' | 'X' ) ( HexDigit )+ ( IntegerConstantSuffix )?
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1068:3: ( HexDigit )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')||(LA10_0>='A' && LA10_0<='F')||(LA10_0>='a' && LA10_0<='f')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1068:3: HexDigit
            	    {
            	    mHexDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1069:3: ( IntegerConstantSuffix )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='L'||LA11_0=='U'||LA11_0=='l'||LA11_0=='u') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1069:3: IntegerConstantSuffix
                    {
                    mIntegerConstantSuffix(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HEXADECIMAL_NUMBER"

    // $ANTLR start "DECIMAL_NUMBER"
    public final void mDECIMAL_NUMBER() throws RecognitionException {
        try {
            int _type = DECIMAL_NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1073:2: ( ( '-' | '+' )? ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( IntegerConstantSuffix )? )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1073:4: ( '-' | '+' )? ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( IntegerConstantSuffix )?
            {
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1073:4: ( '-' | '+' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='+'||LA12_0=='-') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:
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

            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1074:3: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='0') ) {
                alt14=1;
            }
            else if ( ((LA14_0>='1' && LA14_0<='9')) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1074:4: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1074:10: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); 
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1074:19: ( '0' .. '9' )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1074:19: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1075:3: ( IntegerConstantSuffix )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='L'||LA15_0=='U'||LA15_0=='l'||LA15_0=='u') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1075:3: IntegerConstantSuffix
                    {
                    mIntegerConstantSuffix(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DECIMAL_NUMBER"

    // $ANTLR start "OCTAL_NUMBER"
    public final void mOCTAL_NUMBER() throws RecognitionException {
        try {
            int _type = OCTAL_NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1079:2: ( '0' ( '0' .. '7' )+ ( IntegerConstantSuffix )? )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1079:5: '0' ( '0' .. '7' )+ ( IntegerConstantSuffix )?
            {
            match('0'); 
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1080:3: ( '0' .. '7' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='0' && LA16_0<='7')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1080:4: '0' .. '7'
            	    {
            	    matchRange('0','7'); 

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);

            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1081:3: ( IntegerConstantSuffix )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='L'||LA17_0=='U'||LA17_0=='l'||LA17_0=='u') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1081:3: IntegerConstantSuffix
                    {
                    mIntegerConstantSuffix(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OCTAL_NUMBER"

    // $ANTLR start "FLOAT_NUMBER"
    public final void mFLOAT_NUMBER() throws RecognitionException {
        try {
            int _type = FLOAT_NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1085:2: ( ( '-' | '+' )? ( '0' .. '9' )+ ( '.' ( '0' .. '9' )* )? ( FloatingPointExponentSuffix )? ( FloatingPointConstantSuffix )? )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1085:4: ( '-' | '+' )? ( '0' .. '9' )+ ( '.' ( '0' .. '9' )* )? ( FloatingPointExponentSuffix )? ( FloatingPointConstantSuffix )?
            {
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1085:4: ( '-' | '+' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='+'||LA18_0=='-') ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:
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

            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1086:3: ( '0' .. '9' )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='0' && LA19_0<='9')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1086:4: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);

            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1087:3: ( '.' ( '0' .. '9' )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='.') ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1088:4: '.' ( '0' .. '9' )*
                    {
                    match('.'); 
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1089:4: ( '0' .. '9' )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0>='0' && LA20_0<='9')) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1089:5: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1091:3: ( FloatingPointExponentSuffix )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0=='E'||LA22_0=='e') ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1091:3: FloatingPointExponentSuffix
                    {
                    mFloatingPointExponentSuffix(); 

                    }
                    break;

            }

            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1092:3: ( FloatingPointConstantSuffix )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0=='D'||LA23_0=='F'||LA23_0=='d'||LA23_0=='f') ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1092:3: FloatingPointConstantSuffix
                    {
                    mFloatingPointConstantSuffix(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT_NUMBER"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1096:2: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1096:4: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
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
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1108:2: ( ( '/*' ( options {greedy=false; } : . )* '*/' ) )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1108:4: ( '/*' ( options {greedy=false; } : . )* '*/' )
            {
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1108:4: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1109:4: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1110:4: ( options {greedy=false; } : . )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0=='*') ) {
                    int LA24_1 = input.LA(2);

                    if ( (LA24_1=='/') ) {
                        alt24=2;
                    }
                    else if ( ((LA24_1>='\u0000' && LA24_1<='.')||(LA24_1>='0' && LA24_1<='\uFFFF')) ) {
                        alt24=1;
                    }


                }
                else if ( ((LA24_0>='\u0000' && LA24_0<=')')||(LA24_0>='+' && LA24_0<='\uFFFF')) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1110:32: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop24;
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
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1118:2: ( ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' ) )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1118:4: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            {
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1118:4: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1119:4: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1120:4: (~ ( '\\n' | '\\r' ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>='\u0000' && LA25_0<='\t')||(LA25_0>='\u000B' && LA25_0<='\f')||(LA25_0>='\u000E' && LA25_0<='\uFFFF')) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1120:4: ~ ( '\\n' | '\\r' )
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
            	    break loop25;
                }
            } while (true);

            // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1121:4: ( '\\r' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0=='\r') ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1121:4: '\\r'
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
        // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:8: ( T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | LONG | IDENTIFIER | CHARACTER | STRING | HEXADECIMAL_NUMBER | DECIMAL_NUMBER | OCTAL_NUMBER | FLOAT_NUMBER | WS | COMMENT | LINE_COMMENT )
        int alt27=89;
        alt27 = dfa27.predict(input);
        switch (alt27) {
            case 1 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:10: T__23
                {
                mT__23(); 

                }
                break;
            case 2 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:16: T__24
                {
                mT__24(); 

                }
                break;
            case 3 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:22: T__25
                {
                mT__25(); 

                }
                break;
            case 4 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:28: T__26
                {
                mT__26(); 

                }
                break;
            case 5 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:34: T__27
                {
                mT__27(); 

                }
                break;
            case 6 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:40: T__28
                {
                mT__28(); 

                }
                break;
            case 7 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:46: T__29
                {
                mT__29(); 

                }
                break;
            case 8 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:52: T__30
                {
                mT__30(); 

                }
                break;
            case 9 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:58: T__31
                {
                mT__31(); 

                }
                break;
            case 10 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:64: T__32
                {
                mT__32(); 

                }
                break;
            case 11 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:70: T__33
                {
                mT__33(); 

                }
                break;
            case 12 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:76: T__34
                {
                mT__34(); 

                }
                break;
            case 13 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:82: T__35
                {
                mT__35(); 

                }
                break;
            case 14 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:88: T__36
                {
                mT__36(); 

                }
                break;
            case 15 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:94: T__37
                {
                mT__37(); 

                }
                break;
            case 16 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:100: T__38
                {
                mT__38(); 

                }
                break;
            case 17 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:106: T__39
                {
                mT__39(); 

                }
                break;
            case 18 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:112: T__40
                {
                mT__40(); 

                }
                break;
            case 19 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:118: T__41
                {
                mT__41(); 

                }
                break;
            case 20 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:124: T__42
                {
                mT__42(); 

                }
                break;
            case 21 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:130: T__43
                {
                mT__43(); 

                }
                break;
            case 22 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:136: T__44
                {
                mT__44(); 

                }
                break;
            case 23 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:142: T__45
                {
                mT__45(); 

                }
                break;
            case 24 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:148: T__46
                {
                mT__46(); 

                }
                break;
            case 25 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:154: T__47
                {
                mT__47(); 

                }
                break;
            case 26 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:160: T__48
                {
                mT__48(); 

                }
                break;
            case 27 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:166: T__49
                {
                mT__49(); 

                }
                break;
            case 28 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:172: T__50
                {
                mT__50(); 

                }
                break;
            case 29 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:178: T__51
                {
                mT__51(); 

                }
                break;
            case 30 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:184: T__52
                {
                mT__52(); 

                }
                break;
            case 31 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:190: T__53
                {
                mT__53(); 

                }
                break;
            case 32 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:196: T__54
                {
                mT__54(); 

                }
                break;
            case 33 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:202: T__55
                {
                mT__55(); 

                }
                break;
            case 34 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:208: T__56
                {
                mT__56(); 

                }
                break;
            case 35 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:214: T__57
                {
                mT__57(); 

                }
                break;
            case 36 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:220: T__58
                {
                mT__58(); 

                }
                break;
            case 37 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:226: T__59
                {
                mT__59(); 

                }
                break;
            case 38 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:232: T__60
                {
                mT__60(); 

                }
                break;
            case 39 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:238: T__61
                {
                mT__61(); 

                }
                break;
            case 40 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:244: T__62
                {
                mT__62(); 

                }
                break;
            case 41 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:250: T__63
                {
                mT__63(); 

                }
                break;
            case 42 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:256: T__64
                {
                mT__64(); 

                }
                break;
            case 43 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:262: T__65
                {
                mT__65(); 

                }
                break;
            case 44 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:268: T__66
                {
                mT__66(); 

                }
                break;
            case 45 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:274: T__67
                {
                mT__67(); 

                }
                break;
            case 46 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:280: T__68
                {
                mT__68(); 

                }
                break;
            case 47 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:286: T__69
                {
                mT__69(); 

                }
                break;
            case 48 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:292: T__70
                {
                mT__70(); 

                }
                break;
            case 49 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:298: T__71
                {
                mT__71(); 

                }
                break;
            case 50 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:304: T__72
                {
                mT__72(); 

                }
                break;
            case 51 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:310: T__73
                {
                mT__73(); 

                }
                break;
            case 52 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:316: T__74
                {
                mT__74(); 

                }
                break;
            case 53 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:322: T__75
                {
                mT__75(); 

                }
                break;
            case 54 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:328: T__76
                {
                mT__76(); 

                }
                break;
            case 55 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:334: T__77
                {
                mT__77(); 

                }
                break;
            case 56 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:340: T__78
                {
                mT__78(); 

                }
                break;
            case 57 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:346: T__79
                {
                mT__79(); 

                }
                break;
            case 58 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:352: T__80
                {
                mT__80(); 

                }
                break;
            case 59 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:358: T__81
                {
                mT__81(); 

                }
                break;
            case 60 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:364: T__82
                {
                mT__82(); 

                }
                break;
            case 61 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:370: T__83
                {
                mT__83(); 

                }
                break;
            case 62 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:376: T__84
                {
                mT__84(); 

                }
                break;
            case 63 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:382: T__85
                {
                mT__85(); 

                }
                break;
            case 64 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:388: T__86
                {
                mT__86(); 

                }
                break;
            case 65 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:394: T__87
                {
                mT__87(); 

                }
                break;
            case 66 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:400: T__88
                {
                mT__88(); 

                }
                break;
            case 67 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:406: T__89
                {
                mT__89(); 

                }
                break;
            case 68 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:412: T__90
                {
                mT__90(); 

                }
                break;
            case 69 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:418: T__91
                {
                mT__91(); 

                }
                break;
            case 70 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:424: T__92
                {
                mT__92(); 

                }
                break;
            case 71 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:430: T__93
                {
                mT__93(); 

                }
                break;
            case 72 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:436: T__94
                {
                mT__94(); 

                }
                break;
            case 73 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:442: T__95
                {
                mT__95(); 

                }
                break;
            case 74 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:448: T__96
                {
                mT__96(); 

                }
                break;
            case 75 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:454: T__97
                {
                mT__97(); 

                }
                break;
            case 76 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:460: T__98
                {
                mT__98(); 

                }
                break;
            case 77 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:466: T__99
                {
                mT__99(); 

                }
                break;
            case 78 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:472: T__100
                {
                mT__100(); 

                }
                break;
            case 79 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:479: LONG
                {
                mLONG(); 

                }
                break;
            case 80 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:484: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;
            case 81 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:495: CHARACTER
                {
                mCHARACTER(); 

                }
                break;
            case 82 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:505: STRING
                {
                mSTRING(); 

                }
                break;
            case 83 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:512: HEXADECIMAL_NUMBER
                {
                mHEXADECIMAL_NUMBER(); 

                }
                break;
            case 84 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:531: DECIMAL_NUMBER
                {
                mDECIMAL_NUMBER(); 

                }
                break;
            case 85 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:546: OCTAL_NUMBER
                {
                mOCTAL_NUMBER(); 

                }
                break;
            case 86 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:559: FLOAT_NUMBER
                {
                mFLOAT_NUMBER(); 

                }
                break;
            case 87 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:572: WS
                {
                mWS(); 

                }
                break;
            case 88 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:575: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 89 :
                // /Users/ochafik/Prog/Java/resources/com/ochafik/lang/grammar/objcpp/ObjCpp.g:1:583: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;

        }

    }


    protected DFA27 dfa27 = new DFA27(this);
    static final String DFA27_eotS =
        "\4\uffff\1\52\3\uffff\1\66\1\52\3\uffff\1\73\1\76\1\100\1\101\1"+
        "\103\5\52\1\uffff\1\121\3\uffff\5\52\1\133\1\uffff\1\136\1\uffff"+
        "\1\140\1\uffff\3\52\3\uffff\2\146\1\uffff\1\52\6\uffff\2\52\3\uffff"+
        "\1\157\2\uffff\1\146\4\uffff\14\52\2\uffff\3\52\1\u0085\1\u0087"+
        "\3\52\7\uffff\3\52\3\uffff\1\u008e\1\146\1\52\2\uffff\2\52\2\uffff"+
        "\24\52\1\u00a8\1\uffff\1\52\1\uffff\1\52\1\u00ab\4\52\1\uffff\1"+
        "\52\2\uffff\1\u00b2\1\u00b3\7\52\1\u00bb\1\u00bc\13\52\1\uffff\2"+
        "\52\1\uffff\1\u00cb\2\52\1\u00ce\1\52\3\uffff\3\52\1\u00d5\1\52"+
        "\1\u00d7\1\u00d8\2\uffff\1\u00d9\14\52\1\u00e9\1\uffff\1\52\1\u00eb"+
        "\1\uffff\1\52\2\uffff\1\u00ed\1\u00ee\1\u00ef\1\uffff\1\u00f0\3"+
        "\uffff\1\52\1\u00f2\5\52\1\u00f8\6\52\1\u00ff\1\uffff\1\u0100\1"+
        "\uffff\1\52\4\uffff\1\52\1\uffff\1\u0103\1\52\1\u0105\2\52\1\uffff"+
        "\1\u0108\1\u0109\1\u010a\1\u010b\2\52\2\uffff\1\52\1\u010f\1\uffff"+
        "\1\52\1\uffff\1\u0111\1\52\4\uffff\1\u0113\1\u0114\1\u0115\1\uffff"+
        "\1\u0116\1\uffff\1\52\4\uffff\1\u0118\1\uffff";
    static final String DFA27_eofS =
        "\u0119\uffff";
    static final String DFA27_minS =
        "\1\11\3\uffff\1\141\1\143\2\uffff\1\75\1\154\3\uffff\1\74\1\75\2"+
        "\60\1\56\1\150\1\141\1\156\1\162\1\137\1\uffff\1\46\3\uffff\1\145"+
        "\1\146\1\157\1\154\1\157\1\75\1\uffff\1\52\1\uffff\1\174\1\uffff"+
        "\1\145\1\150\1\157\3\uffff\2\56\1\uffff\1\155\1\uffff\1\162\4\uffff"+
        "\1\165\1\163\3\uffff\1\76\2\uffff\1\56\4\uffff\1\162\1\147\1\157"+
        "\1\151\1\141\1\156\1\141\1\163\1\151\1\142\1\151\1\143\2\uffff\1"+
        "\160\1\155\1\164\2\44\1\157\1\162\1\151\7\uffff\1\164\1\151\1\156"+
        "\3\uffff\2\56\1\145\1\151\1\uffff\1\155\1\145\2\uffff\1\165\1\156"+
        "\1\145\1\162\1\164\2\163\1\162\1\145\1\157\1\151\1\154\1\166\1\164"+
        "\1\157\1\151\2\156\1\145\1\160\1\44\1\uffff\1\142\1\uffff\1\141"+
        "\1\44\1\144\1\165\1\154\1\147\1\uffff\1\163\1\164\1\uffff\2\44\1"+
        "\143\1\145\1\157\1\164\1\143\1\163\1\164\2\44\1\156\1\147\1\151"+
        "\1\141\1\145\1\156\1\147\1\163\1\164\1\144\1\154\1\uffff\1\154\1"+
        "\164\1\uffff\1\44\1\162\1\145\1\44\1\160\1\145\2\uffff\1\164\1\144"+
        "\1\146\1\44\1\150\2\44\2\uffff\1\44\1\156\1\143\1\164\1\143\1\163"+
        "\1\156\1\151\1\61\1\145\2\141\1\145\1\44\1\uffff\1\156\1\44\1\uffff"+
        "\1\141\2\uffff\3\44\1\uffff\1\44\3\uffff\1\145\1\44\1\145\2\164"+
        "\1\145\1\147\1\44\1\66\1\62\1\64\1\146\1\155\1\164\1\44\1\uffff"+
        "\1\44\1\uffff\1\143\4\uffff\1\144\1\uffff\1\44\1\145\1\44\1\144"+
        "\1\156\1\uffff\4\44\2\145\2\uffff\1\145\1\44\1\uffff\1\144\1\uffff"+
        "\1\44\1\145\4\uffff\3\44\1\uffff\1\44\1\uffff\1\144\4\uffff\1\44"+
        "\1\uffff";
    static final String DFA27_maxS =
        "\1\176\3\uffff\1\141\1\160\2\uffff\1\75\1\156\3\uffff\1\75\1\76"+
        "\2\71\1\56\1\167\1\157\1\156\1\165\1\137\1\uffff\1\46\3\uffff\1"+
        "\171\1\156\3\157\1\75\1\uffff\1\57\1\uffff\1\174\1\uffff\1\145\1"+
        "\150\1\157\3\uffff\1\170\1\146\1\uffff\1\155\1\uffff\1\165\4\uffff"+
        "\1\165\1\163\3\uffff\1\76\2\uffff\1\146\4\uffff\1\162\1\172\1\157"+
        "\1\151\1\141\1\156\1\141\2\163\1\142\1\157\1\165\2\uffff\1\160\1"+
        "\155\1\164\2\172\1\157\1\162\1\151\7\uffff\1\164\1\151\1\156\3\uffff"+
        "\2\146\1\145\1\157\1\uffff\1\155\1\145\2\uffff\1\165\1\156\1\145"+
        "\1\162\1\164\2\163\1\162\1\145\1\157\1\151\1\154\1\166\1\164\1\157"+
        "\1\151\2\156\1\145\1\160\1\172\1\uffff\1\142\1\uffff\1\141\1\172"+
        "\1\144\1\165\1\154\1\147\1\uffff\1\163\1\164\1\uffff\2\172\1\143"+
        "\1\145\1\157\1\164\1\143\1\163\1\164\2\172\1\156\1\147\1\151\1\141"+
        "\1\145\1\156\1\147\1\163\1\164\1\156\1\154\1\uffff\1\154\1\164\1"+
        "\uffff\1\172\1\162\1\145\1\172\1\160\1\157\2\uffff\1\164\1\144\1"+
        "\146\1\172\1\150\2\172\2\uffff\1\172\1\156\1\143\1\164\1\143\1\163"+
        "\1\156\1\151\1\70\1\145\2\141\1\145\1\172\1\uffff\1\156\1\172\1"+
        "\uffff\1\141\2\uffff\3\172\1\uffff\1\172\3\uffff\1\145\1\172\1\145"+
        "\2\164\1\145\1\147\1\172\1\66\1\62\1\64\1\146\1\155\1\164\1\172"+
        "\1\uffff\1\172\1\uffff\1\143\4\uffff\1\144\1\uffff\1\172\1\145\1"+
        "\172\1\144\1\156\1\uffff\4\172\2\145\2\uffff\1\145\1\172\1\uffff"+
        "\1\144\1\uffff\1\172\1\145\4\uffff\3\172\1\uffff\1\172\1\uffff\1"+
        "\144\4\uffff\1\172\1\uffff";
    static final String DFA27_acceptS =
        "\1\uffff\1\1\1\2\1\3\2\uffff\1\6\1\7\2\uffff\1\14\1\15\1\16\12\uffff"+
        "\1\40\1\uffff\1\42\1\43\1\44\6\uffff\1\70\1\uffff\1\72\1\uffff\1"+
        "\106\3\uffff\1\120\1\121\1\122\2\uffff\1\127\1\uffff\1\5\1\uffff"+
        "\1\13\1\24\1\103\1\10\2\uffff\1\73\1\101\1\17\1\uffff\1\102\1\20"+
        "\1\uffff\1\25\1\26\1\27\1\105\14\uffff\1\100\1\41\10\uffff\1\104"+
        "\1\67\1\130\1\131\1\71\1\76\1\77\3\uffff\1\123\1\126\1\124\4\uffff"+
        "\1\21\2\uffff\1\74\1\75\25\uffff\1\110\1\uffff\1\113\6\uffff\1\125"+
        "\2\uffff\1\22\26\uffff\1\55\2\uffff\1\114\6\uffff\1\11\1\111\7\uffff"+
        "\1\60\1\116\16\uffff\1\61\2\uffff\1\117\1\uffff\1\12\1\23\3\uffff"+
        "\1\54\1\uffff\1\31\1\36\1\32\17\uffff\1\57\1\uffff\1\112\1\uffff"+
        "\1\30\1\50\1\66\1\115\1\uffff\1\33\5\uffff\1\62\6\uffff\1\56\1\107"+
        "\2\uffff\1\34\1\uffff\1\37\2\uffff\1\63\1\64\1\65\1\45\3\uffff\1"+
        "\51\1\uffff\1\52\1\uffff\1\46\1\47\1\4\1\35\1\uffff\1\53";
    static final String DFA27_specialS =
        "\u0119\uffff}>";
    static final String[] DFA27_transitionS = {
            "\2\57\1\uffff\2\57\22\uffff\1\57\1\41\1\54\1\1\1\52\1\44\1\30"+
            "\1\53\1\13\1\14\1\27\1\17\1\6\1\20\1\21\1\43\1\55\11\56\1\12"+
            "\1\7\1\15\1\10\1\16\1\46\1\5\32\52\1\32\1\uffff\1\33\1\31\1"+
            "\26\1\uffff\2\52\1\23\1\36\1\11\1\37\2\52\1\35\2\52\1\51\1\52"+
            "\1\4\1\52\1\25\1\52\1\47\1\22\1\34\1\24\1\40\1\50\3\52\1\2\1"+
            "\45\1\3\1\42",
            "",
            "",
            "",
            "\1\60",
            "\1\61\1\uffff\1\64\3\uffff\1\63\6\uffff\1\62",
            "",
            "",
            "\1\65",
            "\1\70\1\uffff\1\67",
            "",
            "",
            "",
            "\1\71\1\72",
            "\1\75\1\74",
            "\1\77\11\56",
            "\1\77\11\56",
            "\1\102",
            "\1\106\1\105\12\uffff\1\104\2\uffff\1\107",
            "\1\113\6\uffff\1\112\3\uffff\1\110\2\uffff\1\111",
            "\1\114",
            "\1\116\2\uffff\1\115",
            "\1\117",
            "",
            "\1\120",
            "",
            "",
            "",
            "\1\123\23\uffff\1\122",
            "\1\125\7\uffff\1\124",
            "\1\126",
            "\1\127\2\uffff\1\130",
            "\1\131",
            "\1\132",
            "",
            "\1\134\4\uffff\1\135",
            "",
            "\1\137",
            "",
            "\1\141",
            "\1\142",
            "\1\143",
            "",
            "",
            "",
            "\1\145\1\uffff\10\147\2\145\12\uffff\3\145\21\uffff\1\144\13"+
            "\uffff\3\145\21\uffff\1\144",
            "\1\145\1\uffff\12\150\12\uffff\3\145\35\uffff\3\145",
            "",
            "\1\151",
            "",
            "\1\152\2\uffff\1\153",
            "",
            "",
            "",
            "",
            "\1\154",
            "\1\155",
            "",
            "",
            "",
            "\1\156",
            "",
            "",
            "\1\145\1\uffff\12\145\12\uffff\3\145\35\uffff\3\145",
            "",
            "",
            "",
            "",
            "\1\160",
            "\1\161\22\uffff\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171\11\uffff\1\172",
            "\1\173",
            "\1\174\5\uffff\1\175",
            "\1\176\5\uffff\1\u0081\11\uffff\1\177\1\uffff\1\u0080",
            "",
            "",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\24"+
            "\52\1\u0086\5\52",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "",
            "",
            "",
            "\1\145\1\uffff\10\147\2\145\12\uffff\3\145\35\uffff\3\145",
            "\1\145\1\uffff\12\150\12\uffff\3\145\35\uffff\3\145",
            "\1\u008f",
            "\1\u0091\5\uffff\1\u0090",
            "",
            "\1\u0092",
            "\1\u0093",
            "",
            "",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "",
            "\1\u00a9",
            "",
            "\1\u00aa",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "",
            "\1\u00b0",
            "\1\u00b1",
            "",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6\11\uffff\1\u00c7",
            "\1\u00c8",
            "",
            "\1\u00c9",
            "\1\u00ca",
            "",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\u00cc",
            "\1\u00cd",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\u00cf",
            "\1\u00d1\11\uffff\1\u00d0",
            "",
            "",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\u00d6",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "",
            "",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e2\1\uffff\1\u00e3\2\uffff\1\u00e4\1\uffff\1\u00e1",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "",
            "\1\u00ea",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "",
            "\1\u00ec",
            "",
            "",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "",
            "",
            "",
            "\1\u00f1",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "",
            "\1\u0101",
            "",
            "",
            "",
            "",
            "\1\u0102",
            "",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\u0104",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\u0106",
            "\1\u0107",
            "",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\u010c",
            "\1\u010d",
            "",
            "",
            "\1\u010e",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "",
            "\1\u0110",
            "",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\u0112",
            "",
            "",
            "",
            "",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            "",
            "\1\u0117",
            "",
            "",
            "",
            "",
            "\1\52\13\uffff\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32"+
            "\52",
            ""
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | LONG | IDENTIFIER | CHARACTER | STRING | HEXADECIMAL_NUMBER | DECIMAL_NUMBER | OCTAL_NUMBER | FLOAT_NUMBER | WS | COMMENT | LINE_COMMENT );";
        }
    }
 

}