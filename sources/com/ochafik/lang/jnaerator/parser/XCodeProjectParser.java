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
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.antlr.runtime.debug.*;
import java.io.IOException;

import org.antlr.runtime.tree.*;

/**
	This grammar is by no mean complete.
	It is able to parse preprocessed C & Objective-C files and can tolerate some amount of C++. 
	It lacks serious expression support, which is being worked on.
	Complex variable declarations may not be supported, such as complex signatures of functions that return function pointers...
*/
public class XCodeProjectParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENTIFIER", "CHARACTER", "STRING", "Letter", "FloatingPointExponentSuffix", "FloatingPointConstantSuffix", "OctalEscape", "CharEscape", "HexDigit", "UnicodeEscape", "IntegerConstantSuffix", "WS", "COMMENT", "LINE_COMMENT", "'{'", "'='", "';'", "'}'", "'('", "','", "')'"
    };
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
    public static final int Letter=7;
    public static final int OctalEscape=10;
    public static final int STRING=6;

    // delegates
    // delegators

    public static final String[] ruleNames = new String[] {
        "invalidRule", "list", "synpred5_XCodeProject", "synpred2_XCodeProject", 
        "synpred1_XCodeProject", "xCodeProject", "synpred7_XCodeProject", 
        "value", "map", "synpred6_XCodeProject", "synpred3_XCodeProject", 
        "synpred4_XCodeProject", "constant"
    };
     
        public int ruleLevel = 0;
        public int getRuleLevel() { return ruleLevel; }
        public void incRuleLevel() { ruleLevel++; }
        public void decRuleLevel() { ruleLevel--; }
        public XCodeProjectParser(TokenStream input) {
            this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
        }
        public XCodeProjectParser(TokenStream input, int port, RecognizerSharedState state) {
            super(input, state);
            DebugEventSocketProxy proxy =
                new DebugEventSocketProxy(this,port,adaptor);
            setDebugListener(proxy);
            setTokenStream(new DebugTokenStream(input,proxy));
            try {
                proxy.handshake();
            }
            catch (IOException ioe) {
                reportError(ioe);
            }
            TreeAdaptor adap = new CommonTreeAdaptor();
            setTreeAdaptor(adap);
            proxy.setTreeAdaptor(adap);
        }
    public XCodeProjectParser(TokenStream input, DebugEventListener dbg) {
        super(input, dbg);

         
        TreeAdaptor adap = new CommonTreeAdaptor();
        setTreeAdaptor(adap);

    }
    protected boolean evalPredicate(boolean result, String predicate) {
        dbg.semanticPredicate(result, predicate);
        return result;
    }

    protected DebugTreeAdaptor adaptor;
    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = new DebugTreeAdaptor(dbg,adaptor);

    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }


    public String[] getTokenNames() { return XCodeProjectParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g"; }





    public static class xCodeProject_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "xCodeProject"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:89:1: xCodeProject : map ;
    public final XCodeProjectParser.xCodeProject_return xCodeProject() throws RecognitionException {
        XCodeProjectParser.xCodeProject_return retval = new XCodeProjectParser.xCodeProject_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        XCodeProjectParser.map_return map1 = null;



        try { dbg.enterRule(getGrammarFileName(), "xCodeProject");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(89, 1);

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:90:2: ( map )
            dbg.enterAlt(1);

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:90:4: map
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(90,4);
            pushFollow(FOLLOW_map_in_xCodeProject63);
            map1=map();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, map1.getTree());

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
        dbg.location(91, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "xCodeProject");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "xCodeProject"

    public static class map_return extends ParserRuleReturnScope {
        public Map<String, Object> map;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "map"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:93:1: map returns [Map<String, Object> map] : '{' ( IDENTIFIER '=' value ';' )* '}' ;
    public final XCodeProjectParser.map_return map() throws RecognitionException {
        XCodeProjectParser.map_return retval = new XCodeProjectParser.map_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal2=null;
        Token IDENTIFIER3=null;
        Token char_literal4=null;
        Token char_literal6=null;
        Token char_literal7=null;
        XCodeProjectParser.value_return value5 = null;


        Object char_literal2_tree=null;
        Object IDENTIFIER3_tree=null;
        Object char_literal4_tree=null;
        Object char_literal6_tree=null;
        Object char_literal7_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "map");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(93, 1);

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:94:2: ( '{' ( IDENTIFIER '=' value ';' )* '}' )
            dbg.enterAlt(1);

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:94:4: '{' ( IDENTIFIER '=' value ';' )* '}'
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(94,4);
            if ( state.backtracking==0 ) {
               retval.map = new HashMap<String, Object>(); 
            }
            dbg.location(95,3);
            char_literal2=(Token)match(input,18,FOLLOW_18_in_map82); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal2_tree = (Object)adaptor.create(char_literal2);
            adaptor.addChild(root_0, char_literal2_tree);
            }
            dbg.location(96,3);
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:96:3: ( IDENTIFIER '=' value ';' )*
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
                try { dbg.enterDecision(1);

                int LA1_0 = input.LA(1);

                if ( (LA1_0==IDENTIFIER) ) {
                    alt1=1;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:97:4: IDENTIFIER '=' value ';'
            	    {
            	    dbg.location(97,4);
            	    IDENTIFIER3=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_map91); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDENTIFIER3_tree = (Object)adaptor.create(IDENTIFIER3);
            	    adaptor.addChild(root_0, IDENTIFIER3_tree);
            	    }
            	    dbg.location(97,15);
            	    char_literal4=(Token)match(input,19,FOLLOW_19_in_map93); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal4_tree = (Object)adaptor.create(char_literal4);
            	    adaptor.addChild(root_0, char_literal4_tree);
            	    }
            	    dbg.location(97,19);
            	    pushFollow(FOLLOW_value_in_map95);
            	    value5=value();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, value5.getTree());
            	    dbg.location(97,25);
            	    char_literal6=(Token)match(input,20,FOLLOW_20_in_map97); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal6_tree = (Object)adaptor.create(char_literal6);
            	    adaptor.addChild(root_0, char_literal6_tree);
            	    }
            	    dbg.location(97,29);
            	    if ( state.backtracking==0 ) {

            	      				retval.map.put((IDENTIFIER3!=null?IDENTIFIER3.getText():null), (value5!=null?value5.value:null)); 
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);
            } finally {dbg.exitSubRule(1);}

            dbg.location(101,3);
            char_literal7=(Token)match(input,21,FOLLOW_21_in_map108); if (state.failed) return retval;
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
        dbg.location(102, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "map");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "map"

    public static class value_return extends ParserRuleReturnScope {
        public Object value;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "value"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:104:1: value returns [Object value] : ( constant | map | IDENTIFIER | list );
    public final XCodeProjectParser.value_return value() throws RecognitionException {
        XCodeProjectParser.value_return retval = new XCodeProjectParser.value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENTIFIER10=null;
        XCodeProjectParser.constant_return constant8 = null;

        XCodeProjectParser.map_return map9 = null;

        XCodeProjectParser.list_return list11 = null;


        Object IDENTIFIER10_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "value");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(104, 1);

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:105:2: ( constant | map | IDENTIFIER | list )
            int alt2=4;
            try { dbg.enterDecision(2);

            switch ( input.LA(1) ) {
            case CHARACTER:
            case STRING:
                {
                alt2=1;
                }
                break;
            case 18:
                {
                alt2=2;
                }
                break;
            case IDENTIFIER:
                {
                alt2=3;
                }
                break;
            case 22:
                {
                alt2=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(2);}

            switch (alt2) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:105:4: constant
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(105,4);
                    pushFollow(FOLLOW_constant_in_value123);
                    constant8=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant8.getTree());
                    dbg.location(105,13);
                    if ( state.backtracking==0 ) {
                       retval.value = (constant8!=null?constant8.constant:null); 
                    }

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:106:3: map
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(106,3);
                    pushFollow(FOLLOW_map_in_value131);
                    map9=map();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, map9.getTree());
                    dbg.location(106,8);
                    if ( state.backtracking==0 ) {
                       retval.value = (map9!=null?map9.map:null); 
                    }

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:107:3: IDENTIFIER
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(107,3);
                    IDENTIFIER10=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_value140); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER10_tree = (Object)adaptor.create(IDENTIFIER10);
                    adaptor.addChild(root_0, IDENTIFIER10_tree);
                    }
                    dbg.location(107,14);
                    if ( state.backtracking==0 ) {

                      			try {
                      				retval.value = Integer.parseInt((IDENTIFIER10!=null?IDENTIFIER10.getText():null)); 
                      			} catch (Exception ex) {
                      				retval.value = (IDENTIFIER10!=null?IDENTIFIER10.getText():null); 
                      			}
                      		
                    }

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:114:3: list
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(114,3);
                    pushFollow(FOLLOW_list_in_value148);
                    list11=list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, list11.getTree());
                    dbg.location(114,8);
                    if ( state.backtracking==0 ) {
                       retval.value = (list11!=null?list11.list:null); 
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
        dbg.location(115, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "value");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "value"

    public static class list_return extends ParserRuleReturnScope {
        public List<Object> list;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "list"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:117:1: list returns [List<Object> list] : '(' (head= value ( ',' v= value )* )? ')' ;
    public final XCodeProjectParser.list_return list() throws RecognitionException {
        XCodeProjectParser.list_return retval = new XCodeProjectParser.list_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal12=null;
        Token char_literal13=null;
        Token char_literal14=null;
        XCodeProjectParser.value_return head = null;

        XCodeProjectParser.value_return v = null;


        Object char_literal12_tree=null;
        Object char_literal13_tree=null;
        Object char_literal14_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "list");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(117, 1);

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:118:2: ( '(' (head= value ( ',' v= value )* )? ')' )
            dbg.enterAlt(1);

            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:118:4: '(' (head= value ( ',' v= value )* )? ')'
            {
            root_0 = (Object)adaptor.nil();

            dbg.location(118,4);
            if ( state.backtracking==0 ) {
               retval.list = new ArrayList<Object>(); 
            }
            dbg.location(119,3);
            char_literal12=(Token)match(input,22,FOLLOW_22_in_list170); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal12_tree = (Object)adaptor.create(char_literal12);
            adaptor.addChild(root_0, char_literal12_tree);
            }
            dbg.location(120,3);
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:120:3: (head= value ( ',' v= value )* )?
            int alt4=2;
            try { dbg.enterSubRule(4);
            try { dbg.enterDecision(4);

            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=IDENTIFIER && LA4_0<=STRING)||LA4_0==18||LA4_0==22) ) {
                alt4=1;
            }
            } finally {dbg.exitDecision(4);}

            switch (alt4) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:121:4: head= value ( ',' v= value )*
                    {
                    dbg.location(121,8);
                    pushFollow(FOLLOW_value_in_list181);
                    head=value();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, head.getTree());
                    dbg.location(121,15);
                    if ( state.backtracking==0 ) {
                       retval.list.add((head!=null?head.value:null)); 
                    }
                    dbg.location(122,4);
                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:122:4: ( ',' v= value )*
                    try { dbg.enterSubRule(3);

                    loop3:
                    do {
                        int alt3=2;
                        try { dbg.enterDecision(3);

                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==23) ) {
                            alt3=1;
                        }


                        } finally {dbg.exitDecision(3);}

                        switch (alt3) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:123:5: ',' v= value
                    	    {
                    	    dbg.location(123,5);
                    	    char_literal13=(Token)match(input,23,FOLLOW_23_in_list194); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    char_literal13_tree = (Object)adaptor.create(char_literal13);
                    	    adaptor.addChild(root_0, char_literal13_tree);
                    	    }
                    	    dbg.location(124,6);
                    	    pushFollow(FOLLOW_value_in_list203);
                    	    v=value();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
                    	    dbg.location(124,13);
                    	    if ( state.backtracking==0 ) {
                    	       retval.list.add((v!=null?v.value:null)); 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(3);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(4);}

            dbg.location(127,3);
            char_literal14=(Token)match(input,24,FOLLOW_24_in_list220); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal14_tree = (Object)adaptor.create(char_literal14);
            adaptor.addChild(root_0, char_literal14_tree);
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
        dbg.location(128, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "list");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "list"

    public static class constant_return extends ParserRuleReturnScope {
        public Object constant;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constant"
    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:130:1: constant returns [Object constant] : ( CHARACTER | STRING );
    public final XCodeProjectParser.constant_return constant() throws RecognitionException {
        XCodeProjectParser.constant_return retval = new XCodeProjectParser.constant_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CHARACTER15=null;
        Token STRING16=null;

        Object CHARACTER15_tree=null;
        Object STRING16_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "constant");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(130, 1);

        try {
            // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:131:2: ( CHARACTER | STRING )
            int alt5=2;
            try { dbg.enterDecision(5);

            int LA5_0 = input.LA(1);

            if ( (LA5_0==CHARACTER) ) {
                alt5=1;
            }
            else if ( (LA5_0==STRING) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(5);}

            switch (alt5) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:135:3: CHARACTER
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(135,3);
                    CHARACTER15=(Token)match(input,CHARACTER,FOLLOW_CHARACTER_in_constant250); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARACTER15_tree = (Object)adaptor.create(CHARACTER15);
                    adaptor.addChild(root_0, CHARACTER15_tree);
                    }
                    dbg.location(135,13);
                    if ( state.backtracking==0 ) {
                       retval.constant = (CHARACTER15!=null?CHARACTER15.getText():null).substring(1, (CHARACTER15!=null?CHARACTER15.getText():null).length() - 2); 
                    }

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/ochafik/Prog/Java/sources/com/ochafik/lang/jnaerator/parser/XCodeProject.g:136:3: STRING
                    {
                    root_0 = (Object)adaptor.nil();

                    dbg.location(136,3);
                    STRING16=(Token)match(input,STRING,FOLLOW_STRING_in_constant258); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING16_tree = (Object)adaptor.create(STRING16);
                    adaptor.addChild(root_0, STRING16_tree);
                    }
                    dbg.location(136,10);
                    if ( state.backtracking==0 ) {
                       retval.constant = (STRING16!=null?STRING16.getText():null).substring(1, (STRING16!=null?STRING16.getText():null).length() - 2); 
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
        dbg.location(137, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "constant");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "constant"

    // Delegated rules


 

    public static final BitSet FOLLOW_map_in_xCodeProject63 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_map82 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_map91 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_map93 = new BitSet(new long[]{0x0000000000440070L});
    public static final BitSet FOLLOW_value_in_map95 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_map97 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_map108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_value123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_in_value131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_value140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_list_in_value148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_list170 = new BitSet(new long[]{0x0000000001440070L});
    public static final BitSet FOLLOW_value_in_list181 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_list194 = new BitSet(new long[]{0x0000000000440070L});
    public static final BitSet FOLLOW_value_in_list203 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_list220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARACTER_in_constant250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_constant258 = new BitSet(new long[]{0x0000000000000002L});

}