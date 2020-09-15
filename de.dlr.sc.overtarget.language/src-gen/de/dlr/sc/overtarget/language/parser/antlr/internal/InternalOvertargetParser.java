package de.dlr.sc.overtarget.language.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.dlr.sc.overtarget.language.services.OvertargetGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
 * Copyright (c) 2018-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalOvertargetParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'TargetLibrary'", "'{'", "'}'", "'Target'", "'extends'", "'Import'", "'OperatingSystem'", "'WindowingSystem'", "'WorkingSystem'", "'Architecture'", "'Locale'", "'TargetJRE'", "'.'", "'Unit'", "'version'", "'newest'", "';'", "':'", "'+'", "'ReferencedTarget'", "'RepositoryLocation'", "'url'", "'addAll;'", "'ExcludeLocation'", "'all;'", "'Override'", "'='", "'Variable'", "'-'", "'aix'", "'hpux'", "'linux'", "'macosx'", "'qnx'", "'solaris'", "'win32'", "'carbon'", "'cocoa'", "'gtk'", "'motif'", "'photon'", "'wpf'", "'PA_RISC'", "'ia64'", "'ia64_32'", "'ppc'", "'sparc'", "'x86'", "'x86_64'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalOvertargetParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalOvertargetParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalOvertargetParser.tokenNames; }
    public String getGrammarFileName() { return "InternalOvertarget.g"; }



     	private OvertargetGrammarAccess grammarAccess;

        public InternalOvertargetParser(TokenStream input, OvertargetGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "TargetFile";
       	}

       	@Override
       	protected OvertargetGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleTargetFile"
    // InternalOvertarget.g:70:1: entryRuleTargetFile returns [EObject current=null] : iv_ruleTargetFile= ruleTargetFile EOF ;
    public final EObject entryRuleTargetFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTargetFile = null;


        try {
            // InternalOvertarget.g:70:51: (iv_ruleTargetFile= ruleTargetFile EOF )
            // InternalOvertarget.g:71:2: iv_ruleTargetFile= ruleTargetFile EOF
            {
             newCompositeNode(grammarAccess.getTargetFileRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTargetFile=ruleTargetFile();

            state._fsp--;

             current =iv_ruleTargetFile; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTargetFile"


    // $ANTLR start "ruleTargetFile"
    // InternalOvertarget.g:77:1: ruleTargetFile returns [EObject current=null] : (this_TargetModel_0= ruleTargetModel | this_TargetLibrary_1= ruleTargetLibrary ) ;
    public final EObject ruleTargetFile() throws RecognitionException {
        EObject current = null;

        EObject this_TargetModel_0 = null;

        EObject this_TargetLibrary_1 = null;



        	enterRule();

        try {
            // InternalOvertarget.g:83:2: ( (this_TargetModel_0= ruleTargetModel | this_TargetLibrary_1= ruleTargetLibrary ) )
            // InternalOvertarget.g:84:2: (this_TargetModel_0= ruleTargetModel | this_TargetLibrary_1= ruleTargetLibrary )
            {
            // InternalOvertarget.g:84:2: (this_TargetModel_0= ruleTargetModel | this_TargetLibrary_1= ruleTargetLibrary )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==14) ) {
                alt1=1;
            }
            else if ( (LA1_0==11) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalOvertarget.g:85:3: this_TargetModel_0= ruleTargetModel
                    {

                    			newCompositeNode(grammarAccess.getTargetFileAccess().getTargetModelParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_TargetModel_0=ruleTargetModel();

                    state._fsp--;


                    			current = this_TargetModel_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOvertarget.g:94:3: this_TargetLibrary_1= ruleTargetLibrary
                    {

                    			newCompositeNode(grammarAccess.getTargetFileAccess().getTargetLibraryParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_TargetLibrary_1=ruleTargetLibrary();

                    state._fsp--;


                    			current = this_TargetLibrary_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTargetFile"


    // $ANTLR start "entryRuleTargetLibrary"
    // InternalOvertarget.g:106:1: entryRuleTargetLibrary returns [EObject current=null] : iv_ruleTargetLibrary= ruleTargetLibrary EOF ;
    public final EObject entryRuleTargetLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTargetLibrary = null;


        try {
            // InternalOvertarget.g:106:54: (iv_ruleTargetLibrary= ruleTargetLibrary EOF )
            // InternalOvertarget.g:107:2: iv_ruleTargetLibrary= ruleTargetLibrary EOF
            {
             newCompositeNode(grammarAccess.getTargetLibraryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTargetLibrary=ruleTargetLibrary();

            state._fsp--;

             current =iv_ruleTargetLibrary; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTargetLibrary"


    // $ANTLR start "ruleTargetLibrary"
    // InternalOvertarget.g:113:1: ruleTargetLibrary returns [EObject current=null] : (otherlv_0= 'TargetLibrary' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_variables_3_0= ruleVariableDefinition ) )* ( (lv_repositoryLocations_4_0= ruleRepositoryLocation ) )* otherlv_5= '}' ) ;
    public final EObject ruleTargetLibrary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_variables_3_0 = null;

        EObject lv_repositoryLocations_4_0 = null;



        	enterRule();

        try {
            // InternalOvertarget.g:119:2: ( (otherlv_0= 'TargetLibrary' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_variables_3_0= ruleVariableDefinition ) )* ( (lv_repositoryLocations_4_0= ruleRepositoryLocation ) )* otherlv_5= '}' ) )
            // InternalOvertarget.g:120:2: (otherlv_0= 'TargetLibrary' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_variables_3_0= ruleVariableDefinition ) )* ( (lv_repositoryLocations_4_0= ruleRepositoryLocation ) )* otherlv_5= '}' )
            {
            // InternalOvertarget.g:120:2: (otherlv_0= 'TargetLibrary' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_variables_3_0= ruleVariableDefinition ) )* ( (lv_repositoryLocations_4_0= ruleRepositoryLocation ) )* otherlv_5= '}' )
            // InternalOvertarget.g:121:3: otherlv_0= 'TargetLibrary' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_variables_3_0= ruleVariableDefinition ) )* ( (lv_repositoryLocations_4_0= ruleRepositoryLocation ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTargetLibraryAccess().getTargetLibraryKeyword_0());
            		
            // InternalOvertarget.g:125:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOvertarget.g:126:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOvertarget.g:126:4: (lv_name_1_0= RULE_ID )
            // InternalOvertarget.g:127:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTargetLibraryAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTargetLibraryRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getTargetLibraryAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOvertarget.g:147:3: ( (lv_variables_3_0= ruleVariableDefinition ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==36||LA2_0==38) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalOvertarget.g:148:4: (lv_variables_3_0= ruleVariableDefinition )
            	    {
            	    // InternalOvertarget.g:148:4: (lv_variables_3_0= ruleVariableDefinition )
            	    // InternalOvertarget.g:149:5: lv_variables_3_0= ruleVariableDefinition
            	    {

            	    					newCompositeNode(grammarAccess.getTargetLibraryAccess().getVariablesVariableDefinitionParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_variables_3_0=ruleVariableDefinition();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTargetLibraryRule());
            	    					}
            	    					add(
            	    						current,
            	    						"variables",
            	    						lv_variables_3_0,
            	    						"de.dlr.sc.overtarget.language.Overtarget.VariableDefinition");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalOvertarget.g:166:3: ( (lv_repositoryLocations_4_0= ruleRepositoryLocation ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=30 && LA3_0<=31)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalOvertarget.g:167:4: (lv_repositoryLocations_4_0= ruleRepositoryLocation )
            	    {
            	    // InternalOvertarget.g:167:4: (lv_repositoryLocations_4_0= ruleRepositoryLocation )
            	    // InternalOvertarget.g:168:5: lv_repositoryLocations_4_0= ruleRepositoryLocation
            	    {

            	    					newCompositeNode(grammarAccess.getTargetLibraryAccess().getRepositoryLocationsRepositoryLocationParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_repositoryLocations_4_0=ruleRepositoryLocation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTargetLibraryRule());
            	    					}
            	    					add(
            	    						current,
            	    						"repositoryLocations",
            	    						lv_repositoryLocations_4_0,
            	    						"de.dlr.sc.overtarget.language.Overtarget.RepositoryLocation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getTargetLibraryAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTargetLibrary"


    // $ANTLR start "entryRuleTargetModel"
    // InternalOvertarget.g:193:1: entryRuleTargetModel returns [EObject current=null] : iv_ruleTargetModel= ruleTargetModel EOF ;
    public final EObject entryRuleTargetModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTargetModel = null;


        try {
            // InternalOvertarget.g:193:52: (iv_ruleTargetModel= ruleTargetModel EOF )
            // InternalOvertarget.g:194:2: iv_ruleTargetModel= ruleTargetModel EOF
            {
             newCompositeNode(grammarAccess.getTargetModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTargetModel=ruleTargetModel();

            state._fsp--;

             current =iv_ruleTargetModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTargetModel"


    // $ANTLR start "ruleTargetModel"
    // InternalOvertarget.g:200:1: ruleTargetModel returns [EObject current=null] : (otherlv_0= 'Target' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'Import' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'OperatingSystem' ( (lv_os_8_0= ruleOperatingSys ) ) )? ( (otherlv_9= 'WindowingSystem' | otherlv_10= 'WorkingSystem' ) ( (lv_ws_11_0= ruleWindowingSys ) ) )? (otherlv_12= 'Architecture' ( (lv_arch_13_0= ruleArchitecture ) ) )? (otherlv_14= 'Locale' ( (lv_loc_15_0= ruleLocale ) ) )? (otherlv_16= 'TargetJRE' ( (lv_targetJre_17_0= rulejre ) ) )? ( (lv_variables_18_0= ruleVariableDefinition ) )* ( (lv_excludedLocations_19_0= ruleExcludeLocation ) )* ( (lv_repositoryLocations_20_0= ruleRepositoryLocation ) )* otherlv_21= '}' ) ;
    public final EObject ruleTargetModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_21=null;
        AntlrDatatypeRuleToken lv_os_8_0 = null;

        AntlrDatatypeRuleToken lv_ws_11_0 = null;

        AntlrDatatypeRuleToken lv_arch_13_0 = null;

        AntlrDatatypeRuleToken lv_loc_15_0 = null;

        AntlrDatatypeRuleToken lv_targetJre_17_0 = null;

        EObject lv_variables_18_0 = null;

        EObject lv_excludedLocations_19_0 = null;

        EObject lv_repositoryLocations_20_0 = null;



        	enterRule();

        try {
            // InternalOvertarget.g:206:2: ( (otherlv_0= 'Target' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'Import' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'OperatingSystem' ( (lv_os_8_0= ruleOperatingSys ) ) )? ( (otherlv_9= 'WindowingSystem' | otherlv_10= 'WorkingSystem' ) ( (lv_ws_11_0= ruleWindowingSys ) ) )? (otherlv_12= 'Architecture' ( (lv_arch_13_0= ruleArchitecture ) ) )? (otherlv_14= 'Locale' ( (lv_loc_15_0= ruleLocale ) ) )? (otherlv_16= 'TargetJRE' ( (lv_targetJre_17_0= rulejre ) ) )? ( (lv_variables_18_0= ruleVariableDefinition ) )* ( (lv_excludedLocations_19_0= ruleExcludeLocation ) )* ( (lv_repositoryLocations_20_0= ruleRepositoryLocation ) )* otherlv_21= '}' ) )
            // InternalOvertarget.g:207:2: (otherlv_0= 'Target' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'Import' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'OperatingSystem' ( (lv_os_8_0= ruleOperatingSys ) ) )? ( (otherlv_9= 'WindowingSystem' | otherlv_10= 'WorkingSystem' ) ( (lv_ws_11_0= ruleWindowingSys ) ) )? (otherlv_12= 'Architecture' ( (lv_arch_13_0= ruleArchitecture ) ) )? (otherlv_14= 'Locale' ( (lv_loc_15_0= ruleLocale ) ) )? (otherlv_16= 'TargetJRE' ( (lv_targetJre_17_0= rulejre ) ) )? ( (lv_variables_18_0= ruleVariableDefinition ) )* ( (lv_excludedLocations_19_0= ruleExcludeLocation ) )* ( (lv_repositoryLocations_20_0= ruleRepositoryLocation ) )* otherlv_21= '}' )
            {
            // InternalOvertarget.g:207:2: (otherlv_0= 'Target' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'Import' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'OperatingSystem' ( (lv_os_8_0= ruleOperatingSys ) ) )? ( (otherlv_9= 'WindowingSystem' | otherlv_10= 'WorkingSystem' ) ( (lv_ws_11_0= ruleWindowingSys ) ) )? (otherlv_12= 'Architecture' ( (lv_arch_13_0= ruleArchitecture ) ) )? (otherlv_14= 'Locale' ( (lv_loc_15_0= ruleLocale ) ) )? (otherlv_16= 'TargetJRE' ( (lv_targetJre_17_0= rulejre ) ) )? ( (lv_variables_18_0= ruleVariableDefinition ) )* ( (lv_excludedLocations_19_0= ruleExcludeLocation ) )* ( (lv_repositoryLocations_20_0= ruleRepositoryLocation ) )* otherlv_21= '}' )
            // InternalOvertarget.g:208:3: otherlv_0= 'Target' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'Import' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'OperatingSystem' ( (lv_os_8_0= ruleOperatingSys ) ) )? ( (otherlv_9= 'WindowingSystem' | otherlv_10= 'WorkingSystem' ) ( (lv_ws_11_0= ruleWindowingSys ) ) )? (otherlv_12= 'Architecture' ( (lv_arch_13_0= ruleArchitecture ) ) )? (otherlv_14= 'Locale' ( (lv_loc_15_0= ruleLocale ) ) )? (otherlv_16= 'TargetJRE' ( (lv_targetJre_17_0= rulejre ) ) )? ( (lv_variables_18_0= ruleVariableDefinition ) )* ( (lv_excludedLocations_19_0= ruleExcludeLocation ) )* ( (lv_repositoryLocations_20_0= ruleRepositoryLocation ) )* otherlv_21= '}'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTargetModelAccess().getTargetKeyword_0());
            		
            // InternalOvertarget.g:212:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOvertarget.g:213:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOvertarget.g:213:4: (lv_name_1_0= RULE_ID )
            // InternalOvertarget.g:214:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTargetModelAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTargetModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalOvertarget.g:230:3: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalOvertarget.g:231:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getTargetModelAccess().getExtendsKeyword_2_0());
                    			
                    // InternalOvertarget.g:235:4: ( (otherlv_3= RULE_ID ) )
                    // InternalOvertarget.g:236:5: (otherlv_3= RULE_ID )
                    {
                    // InternalOvertarget.g:236:5: (otherlv_3= RULE_ID )
                    // InternalOvertarget.g:237:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTargetModelRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_4); 

                    						newLeafNode(otherlv_3, grammarAccess.getTargetModelAccess().getSuperTargetModelCrossReference_2_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,12,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getTargetModelAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOvertarget.g:253:3: (otherlv_5= 'Import' ( (otherlv_6= RULE_ID ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==16) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalOvertarget.g:254:4: otherlv_5= 'Import' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,16,FOLLOW_3); 

            	    				newLeafNode(otherlv_5, grammarAccess.getTargetModelAccess().getImportKeyword_4_0());
            	    			
            	    // InternalOvertarget.g:258:4: ( (otherlv_6= RULE_ID ) )
            	    // InternalOvertarget.g:259:5: (otherlv_6= RULE_ID )
            	    {
            	    // InternalOvertarget.g:259:5: (otherlv_6= RULE_ID )
            	    // InternalOvertarget.g:260:6: otherlv_6= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getTargetModelRule());
            	    						}
            	    					
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_8); 

            	    						newLeafNode(otherlv_6, grammarAccess.getTargetModelAccess().getImportedModelsTargetFileCrossReference_4_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // InternalOvertarget.g:272:3: (otherlv_7= 'OperatingSystem' ( (lv_os_8_0= ruleOperatingSys ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalOvertarget.g:273:4: otherlv_7= 'OperatingSystem' ( (lv_os_8_0= ruleOperatingSys ) )
                    {
                    otherlv_7=(Token)match(input,17,FOLLOW_9); 

                    				newLeafNode(otherlv_7, grammarAccess.getTargetModelAccess().getOperatingSystemKeyword_5_0());
                    			
                    // InternalOvertarget.g:277:4: ( (lv_os_8_0= ruleOperatingSys ) )
                    // InternalOvertarget.g:278:5: (lv_os_8_0= ruleOperatingSys )
                    {
                    // InternalOvertarget.g:278:5: (lv_os_8_0= ruleOperatingSys )
                    // InternalOvertarget.g:279:6: lv_os_8_0= ruleOperatingSys
                    {

                    						newCompositeNode(grammarAccess.getTargetModelAccess().getOsOperatingSysParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_os_8_0=ruleOperatingSys();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTargetModelRule());
                    						}
                    						set(
                    							current,
                    							"os",
                    							lv_os_8_0,
                    							"de.dlr.sc.overtarget.language.Overtarget.OperatingSys");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOvertarget.g:297:3: ( (otherlv_9= 'WindowingSystem' | otherlv_10= 'WorkingSystem' ) ( (lv_ws_11_0= ruleWindowingSys ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=18 && LA8_0<=19)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalOvertarget.g:298:4: (otherlv_9= 'WindowingSystem' | otherlv_10= 'WorkingSystem' ) ( (lv_ws_11_0= ruleWindowingSys ) )
                    {
                    // InternalOvertarget.g:298:4: (otherlv_9= 'WindowingSystem' | otherlv_10= 'WorkingSystem' )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==18) ) {
                        alt7=1;
                    }
                    else if ( (LA7_0==19) ) {
                        alt7=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // InternalOvertarget.g:299:5: otherlv_9= 'WindowingSystem'
                            {
                            otherlv_9=(Token)match(input,18,FOLLOW_11); 

                            					newLeafNode(otherlv_9, grammarAccess.getTargetModelAccess().getWindowingSystemKeyword_6_0_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalOvertarget.g:304:5: otherlv_10= 'WorkingSystem'
                            {
                            otherlv_10=(Token)match(input,19,FOLLOW_11); 

                            					newLeafNode(otherlv_10, grammarAccess.getTargetModelAccess().getWorkingSystemKeyword_6_0_1());
                            				

                            }
                            break;

                    }

                    // InternalOvertarget.g:309:4: ( (lv_ws_11_0= ruleWindowingSys ) )
                    // InternalOvertarget.g:310:5: (lv_ws_11_0= ruleWindowingSys )
                    {
                    // InternalOvertarget.g:310:5: (lv_ws_11_0= ruleWindowingSys )
                    // InternalOvertarget.g:311:6: lv_ws_11_0= ruleWindowingSys
                    {

                    						newCompositeNode(grammarAccess.getTargetModelAccess().getWsWindowingSysParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_ws_11_0=ruleWindowingSys();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTargetModelRule());
                    						}
                    						set(
                    							current,
                    							"ws",
                    							lv_ws_11_0,
                    							"de.dlr.sc.overtarget.language.Overtarget.WindowingSys");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOvertarget.g:329:3: (otherlv_12= 'Architecture' ( (lv_arch_13_0= ruleArchitecture ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==20) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalOvertarget.g:330:4: otherlv_12= 'Architecture' ( (lv_arch_13_0= ruleArchitecture ) )
                    {
                    otherlv_12=(Token)match(input,20,FOLLOW_13); 

                    				newLeafNode(otherlv_12, grammarAccess.getTargetModelAccess().getArchitectureKeyword_7_0());
                    			
                    // InternalOvertarget.g:334:4: ( (lv_arch_13_0= ruleArchitecture ) )
                    // InternalOvertarget.g:335:5: (lv_arch_13_0= ruleArchitecture )
                    {
                    // InternalOvertarget.g:335:5: (lv_arch_13_0= ruleArchitecture )
                    // InternalOvertarget.g:336:6: lv_arch_13_0= ruleArchitecture
                    {

                    						newCompositeNode(grammarAccess.getTargetModelAccess().getArchArchitectureParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_arch_13_0=ruleArchitecture();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTargetModelRule());
                    						}
                    						set(
                    							current,
                    							"arch",
                    							lv_arch_13_0,
                    							"de.dlr.sc.overtarget.language.Overtarget.Architecture");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOvertarget.g:354:3: (otherlv_14= 'Locale' ( (lv_loc_15_0= ruleLocale ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalOvertarget.g:355:4: otherlv_14= 'Locale' ( (lv_loc_15_0= ruleLocale ) )
                    {
                    otherlv_14=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_14, grammarAccess.getTargetModelAccess().getLocaleKeyword_8_0());
                    			
                    // InternalOvertarget.g:359:4: ( (lv_loc_15_0= ruleLocale ) )
                    // InternalOvertarget.g:360:5: (lv_loc_15_0= ruleLocale )
                    {
                    // InternalOvertarget.g:360:5: (lv_loc_15_0= ruleLocale )
                    // InternalOvertarget.g:361:6: lv_loc_15_0= ruleLocale
                    {

                    						newCompositeNode(grammarAccess.getTargetModelAccess().getLocLocaleParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_15);
                    lv_loc_15_0=ruleLocale();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTargetModelRule());
                    						}
                    						set(
                    							current,
                    							"loc",
                    							lv_loc_15_0,
                    							"de.dlr.sc.overtarget.language.Overtarget.Locale");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOvertarget.g:379:3: (otherlv_16= 'TargetJRE' ( (lv_targetJre_17_0= rulejre ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalOvertarget.g:380:4: otherlv_16= 'TargetJRE' ( (lv_targetJre_17_0= rulejre ) )
                    {
                    otherlv_16=(Token)match(input,22,FOLLOW_16); 

                    				newLeafNode(otherlv_16, grammarAccess.getTargetModelAccess().getTargetJREKeyword_9_0());
                    			
                    // InternalOvertarget.g:384:4: ( (lv_targetJre_17_0= rulejre ) )
                    // InternalOvertarget.g:385:5: (lv_targetJre_17_0= rulejre )
                    {
                    // InternalOvertarget.g:385:5: (lv_targetJre_17_0= rulejre )
                    // InternalOvertarget.g:386:6: lv_targetJre_17_0= rulejre
                    {

                    						newCompositeNode(grammarAccess.getTargetModelAccess().getTargetJreJreParserRuleCall_9_1_0());
                    					
                    pushFollow(FOLLOW_17);
                    lv_targetJre_17_0=rulejre();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTargetModelRule());
                    						}
                    						set(
                    							current,
                    							"targetJre",
                    							lv_targetJre_17_0,
                    							"de.dlr.sc.overtarget.language.Overtarget.jre");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOvertarget.g:404:3: ( (lv_variables_18_0= ruleVariableDefinition ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==36||LA12_0==38) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalOvertarget.g:405:4: (lv_variables_18_0= ruleVariableDefinition )
            	    {
            	    // InternalOvertarget.g:405:4: (lv_variables_18_0= ruleVariableDefinition )
            	    // InternalOvertarget.g:406:5: lv_variables_18_0= ruleVariableDefinition
            	    {

            	    					newCompositeNode(grammarAccess.getTargetModelAccess().getVariablesVariableDefinitionParserRuleCall_10_0());
            	    				
            	    pushFollow(FOLLOW_17);
            	    lv_variables_18_0=ruleVariableDefinition();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTargetModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"variables",
            	    						lv_variables_18_0,
            	    						"de.dlr.sc.overtarget.language.Overtarget.VariableDefinition");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // InternalOvertarget.g:423:3: ( (lv_excludedLocations_19_0= ruleExcludeLocation ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==34) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalOvertarget.g:424:4: (lv_excludedLocations_19_0= ruleExcludeLocation )
            	    {
            	    // InternalOvertarget.g:424:4: (lv_excludedLocations_19_0= ruleExcludeLocation )
            	    // InternalOvertarget.g:425:5: lv_excludedLocations_19_0= ruleExcludeLocation
            	    {

            	    					newCompositeNode(grammarAccess.getTargetModelAccess().getExcludedLocationsExcludeLocationParserRuleCall_11_0());
            	    				
            	    pushFollow(FOLLOW_18);
            	    lv_excludedLocations_19_0=ruleExcludeLocation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTargetModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"excludedLocations",
            	    						lv_excludedLocations_19_0,
            	    						"de.dlr.sc.overtarget.language.Overtarget.ExcludeLocation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // InternalOvertarget.g:442:3: ( (lv_repositoryLocations_20_0= ruleRepositoryLocation ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=30 && LA14_0<=31)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalOvertarget.g:443:4: (lv_repositoryLocations_20_0= ruleRepositoryLocation )
            	    {
            	    // InternalOvertarget.g:443:4: (lv_repositoryLocations_20_0= ruleRepositoryLocation )
            	    // InternalOvertarget.g:444:5: lv_repositoryLocations_20_0= ruleRepositoryLocation
            	    {

            	    					newCompositeNode(grammarAccess.getTargetModelAccess().getRepositoryLocationsRepositoryLocationParserRuleCall_12_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_repositoryLocations_20_0=ruleRepositoryLocation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTargetModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"repositoryLocations",
            	    						lv_repositoryLocations_20_0,
            	    						"de.dlr.sc.overtarget.language.Overtarget.RepositoryLocation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_21=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_21, grammarAccess.getTargetModelAccess().getRightCurlyBracketKeyword_13());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTargetModel"


    // $ANTLR start "entryRuleVersion"
    // InternalOvertarget.g:469:1: entryRuleVersion returns [String current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final String entryRuleVersion() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersion = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalOvertarget.g:471:2: (iv_ruleVersion= ruleVersion EOF )
            // InternalOvertarget.g:472:2: iv_ruleVersion= ruleVersion EOF
            {
             newCompositeNode(grammarAccess.getVersionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVersion=ruleVersion();

            state._fsp--;

             current =iv_ruleVersion.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleVersion"


    // $ANTLR start "ruleVersion"
    // InternalOvertarget.g:481:1: ruleVersion returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= '.' this_qualifier_6= rulequalifier )? ) ;
    public final AntlrDatatypeRuleToken ruleVersion() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_INT_4=null;
        AntlrDatatypeRuleToken this_qualifier_6 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalOvertarget.g:488:2: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= '.' this_qualifier_6= rulequalifier )? ) )
            // InternalOvertarget.g:489:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= '.' this_qualifier_6= rulequalifier )? )
            {
            // InternalOvertarget.g:489:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= '.' this_qualifier_6= rulequalifier )? )
            // InternalOvertarget.g:490:3: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= '.' this_qualifier_6= rulequalifier )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_19); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getVersionAccess().getINTTerminalRuleCall_0());
            		
            kw=(Token)match(input,23,FOLLOW_20); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_1());
            		
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_19); 

            			current.merge(this_INT_2);
            		

            			newLeafNode(this_INT_2, grammarAccess.getVersionAccess().getINTTerminalRuleCall_2());
            		
            kw=(Token)match(input,23,FOLLOW_20); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_3());
            		
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_21); 

            			current.merge(this_INT_4);
            		

            			newLeafNode(this_INT_4, grammarAccess.getVersionAccess().getINTTerminalRuleCall_4());
            		
            // InternalOvertarget.g:521:3: (kw= '.' this_qualifier_6= rulequalifier )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==23) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalOvertarget.g:522:4: kw= '.' this_qualifier_6= rulequalifier
                    {
                    kw=(Token)match(input,23,FOLLOW_22); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getVersionAccess().getFullStopKeyword_5_0());
                    			

                    				newCompositeNode(grammarAccess.getVersionAccess().getQualifierParserRuleCall_5_1());
                    			
                    pushFollow(FOLLOW_2);
                    this_qualifier_6=rulequalifier();

                    state._fsp--;


                    				current.merge(this_qualifier_6);
                    			

                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleVersion"


    // $ANTLR start "entryRuleSimpleVersion"
    // InternalOvertarget.g:545:1: entryRuleSimpleVersion returns [String current=null] : iv_ruleSimpleVersion= ruleSimpleVersion EOF ;
    public final String entryRuleSimpleVersion() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSimpleVersion = null;


        try {
            // InternalOvertarget.g:545:53: (iv_ruleSimpleVersion= ruleSimpleVersion EOF )
            // InternalOvertarget.g:546:2: iv_ruleSimpleVersion= ruleSimpleVersion EOF
            {
             newCompositeNode(grammarAccess.getSimpleVersionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleVersion=ruleSimpleVersion();

            state._fsp--;

             current =iv_ruleSimpleVersion.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleVersion"


    // $ANTLR start "ruleSimpleVersion"
    // InternalOvertarget.g:552:1: ruleSimpleVersion returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ) ;
    public final AntlrDatatypeRuleToken ruleSimpleVersion() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalOvertarget.g:558:2: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ) )
            // InternalOvertarget.g:559:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* )
            {
            // InternalOvertarget.g:559:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* )
            // InternalOvertarget.g:560:3: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )*
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_21); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getSimpleVersionAccess().getINTTerminalRuleCall_0());
            		
            // InternalOvertarget.g:567:3: (kw= '.' this_INT_2= RULE_INT )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==23) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalOvertarget.g:568:4: kw= '.' this_INT_2= RULE_INT
            	    {
            	    kw=(Token)match(input,23,FOLLOW_20); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getSimpleVersionAccess().getFullStopKeyword_1_0());
            	    			
            	    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_21); 

            	    				current.merge(this_INT_2);
            	    			

            	    				newLeafNode(this_INT_2, grammarAccess.getSimpleVersionAccess().getINTTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleVersion"


    // $ANTLR start "entryRuleUnit"
    // InternalOvertarget.g:585:1: entryRuleUnit returns [EObject current=null] : iv_ruleUnit= ruleUnit EOF ;
    public final EObject entryRuleUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnit = null;


        try {
            // InternalOvertarget.g:585:45: (iv_ruleUnit= ruleUnit EOF )
            // InternalOvertarget.g:586:2: iv_ruleUnit= ruleUnit EOF
            {
             newCompositeNode(grammarAccess.getUnitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnit=ruleUnit();

            state._fsp--;

             current =iv_ruleUnit; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnit"


    // $ANTLR start "ruleUnit"
    // InternalOvertarget.g:592:1: ruleUnit returns [EObject current=null] : ( () otherlv_1= 'Unit' ( ( (lv_source_2_0= ruleSource ) ) otherlv_3= 'version' ( ( (lv_vers_4_1= ruleVersion | lv_vers_4_2= 'newest' ) ) ) )? otherlv_5= ';' ) ;
    public final EObject ruleUnit() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_vers_4_2=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_source_2_0 = null;

        AntlrDatatypeRuleToken lv_vers_4_1 = null;



        	enterRule();

        try {
            // InternalOvertarget.g:598:2: ( ( () otherlv_1= 'Unit' ( ( (lv_source_2_0= ruleSource ) ) otherlv_3= 'version' ( ( (lv_vers_4_1= ruleVersion | lv_vers_4_2= 'newest' ) ) ) )? otherlv_5= ';' ) )
            // InternalOvertarget.g:599:2: ( () otherlv_1= 'Unit' ( ( (lv_source_2_0= ruleSource ) ) otherlv_3= 'version' ( ( (lv_vers_4_1= ruleVersion | lv_vers_4_2= 'newest' ) ) ) )? otherlv_5= ';' )
            {
            // InternalOvertarget.g:599:2: ( () otherlv_1= 'Unit' ( ( (lv_source_2_0= ruleSource ) ) otherlv_3= 'version' ( ( (lv_vers_4_1= ruleVersion | lv_vers_4_2= 'newest' ) ) ) )? otherlv_5= ';' )
            // InternalOvertarget.g:600:3: () otherlv_1= 'Unit' ( ( (lv_source_2_0= ruleSource ) ) otherlv_3= 'version' ( ( (lv_vers_4_1= ruleVersion | lv_vers_4_2= 'newest' ) ) ) )? otherlv_5= ';'
            {
            // InternalOvertarget.g:600:3: ()
            // InternalOvertarget.g:601:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUnitAccess().getUnitAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,24,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getUnitAccess().getUnitKeyword_1());
            		
            // InternalOvertarget.g:611:3: ( ( (lv_source_2_0= ruleSource ) ) otherlv_3= 'version' ( ( (lv_vers_4_1= ruleVersion | lv_vers_4_2= 'newest' ) ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID||LA18_0==14||LA18_0==24) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalOvertarget.g:612:4: ( (lv_source_2_0= ruleSource ) ) otherlv_3= 'version' ( ( (lv_vers_4_1= ruleVersion | lv_vers_4_2= 'newest' ) ) )
                    {
                    // InternalOvertarget.g:612:4: ( (lv_source_2_0= ruleSource ) )
                    // InternalOvertarget.g:613:5: (lv_source_2_0= ruleSource )
                    {
                    // InternalOvertarget.g:613:5: (lv_source_2_0= ruleSource )
                    // InternalOvertarget.g:614:6: lv_source_2_0= ruleSource
                    {

                    						newCompositeNode(grammarAccess.getUnitAccess().getSourceSourceParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_24);
                    lv_source_2_0=ruleSource();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getUnitRule());
                    						}
                    						set(
                    							current,
                    							"source",
                    							lv_source_2_0,
                    							"de.dlr.sc.overtarget.language.Overtarget.Source");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,25,FOLLOW_25); 

                    				newLeafNode(otherlv_3, grammarAccess.getUnitAccess().getVersionKeyword_2_1());
                    			
                    // InternalOvertarget.g:635:4: ( ( (lv_vers_4_1= ruleVersion | lv_vers_4_2= 'newest' ) ) )
                    // InternalOvertarget.g:636:5: ( (lv_vers_4_1= ruleVersion | lv_vers_4_2= 'newest' ) )
                    {
                    // InternalOvertarget.g:636:5: ( (lv_vers_4_1= ruleVersion | lv_vers_4_2= 'newest' ) )
                    // InternalOvertarget.g:637:6: (lv_vers_4_1= ruleVersion | lv_vers_4_2= 'newest' )
                    {
                    // InternalOvertarget.g:637:6: (lv_vers_4_1= ruleVersion | lv_vers_4_2= 'newest' )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==RULE_INT) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==26) ) {
                        alt17=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // InternalOvertarget.g:638:7: lv_vers_4_1= ruleVersion
                            {

                            							newCompositeNode(grammarAccess.getUnitAccess().getVersVersionParserRuleCall_2_2_0_0());
                            						
                            pushFollow(FOLLOW_26);
                            lv_vers_4_1=ruleVersion();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getUnitRule());
                            							}
                            							set(
                            								current,
                            								"vers",
                            								lv_vers_4_1,
                            								"de.dlr.sc.overtarget.language.Overtarget.Version");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;
                        case 2 :
                            // InternalOvertarget.g:654:7: lv_vers_4_2= 'newest'
                            {
                            lv_vers_4_2=(Token)match(input,26,FOLLOW_26); 

                            							newLeafNode(lv_vers_4_2, grammarAccess.getUnitAccess().getVersNewestKeyword_2_2_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getUnitRule());
                            							}
                            							setWithLastConsumed(current, "vers", lv_vers_4_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getUnitAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnit"


    // $ANTLR start "entryRuleSource"
    // InternalOvertarget.g:676:1: entryRuleSource returns [String current=null] : iv_ruleSource= ruleSource EOF ;
    public final String entryRuleSource() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSource = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalOvertarget.g:678:2: (iv_ruleSource= ruleSource EOF )
            // InternalOvertarget.g:679:2: iv_ruleSource= ruleSource EOF
            {
             newCompositeNode(grammarAccess.getSourceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSource=ruleSource();

            state._fsp--;

             current =iv_ruleSource.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleSource"


    // $ANTLR start "ruleSource"
    // InternalOvertarget.g:688:1: ruleSource returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID ( (this_dot_1= ruledot this_ValidID_2= ruleValidID ) | (this_hypen_3= rulehypen this_ValidID_4= ruleValidID ) )* (kw= ':' )? ) ;
    public final AntlrDatatypeRuleToken ruleSource() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_dot_1 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;

        AntlrDatatypeRuleToken this_hypen_3 = null;

        AntlrDatatypeRuleToken this_ValidID_4 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalOvertarget.g:695:2: ( (this_ValidID_0= ruleValidID ( (this_dot_1= ruledot this_ValidID_2= ruleValidID ) | (this_hypen_3= rulehypen this_ValidID_4= ruleValidID ) )* (kw= ':' )? ) )
            // InternalOvertarget.g:696:2: (this_ValidID_0= ruleValidID ( (this_dot_1= ruledot this_ValidID_2= ruleValidID ) | (this_hypen_3= rulehypen this_ValidID_4= ruleValidID ) )* (kw= ':' )? )
            {
            // InternalOvertarget.g:696:2: (this_ValidID_0= ruleValidID ( (this_dot_1= ruledot this_ValidID_2= ruleValidID ) | (this_hypen_3= rulehypen this_ValidID_4= ruleValidID ) )* (kw= ':' )? )
            // InternalOvertarget.g:697:3: this_ValidID_0= ruleValidID ( (this_dot_1= ruledot this_ValidID_2= ruleValidID ) | (this_hypen_3= rulehypen this_ValidID_4= ruleValidID ) )* (kw= ':' )?
            {

            			newCompositeNode(grammarAccess.getSourceAccess().getValidIDParserRuleCall_0());
            		
            pushFollow(FOLLOW_27);
            this_ValidID_0=ruleValidID();

            state._fsp--;


            			current.merge(this_ValidID_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalOvertarget.g:707:3: ( (this_dot_1= ruledot this_ValidID_2= ruleValidID ) | (this_hypen_3= rulehypen this_ValidID_4= ruleValidID ) )*
            loop19:
            do {
                int alt19=3;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==23) ) {
                    alt19=1;
                }
                else if ( (LA19_0==39) ) {
                    alt19=2;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalOvertarget.g:708:4: (this_dot_1= ruledot this_ValidID_2= ruleValidID )
            	    {
            	    // InternalOvertarget.g:708:4: (this_dot_1= ruledot this_ValidID_2= ruleValidID )
            	    // InternalOvertarget.g:709:5: this_dot_1= ruledot this_ValidID_2= ruleValidID
            	    {

            	    					newCompositeNode(grammarAccess.getSourceAccess().getDotParserRuleCall_1_0_0());
            	    				
            	    pushFollow(FOLLOW_28);
            	    this_dot_1=ruledot();

            	    state._fsp--;


            	    					current.merge(this_dot_1);
            	    				

            	    					afterParserOrEnumRuleCall();
            	    				

            	    					newCompositeNode(grammarAccess.getSourceAccess().getValidIDParserRuleCall_1_0_1());
            	    				
            	    pushFollow(FOLLOW_27);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;


            	    					current.merge(this_ValidID_2);
            	    				

            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOvertarget.g:731:4: (this_hypen_3= rulehypen this_ValidID_4= ruleValidID )
            	    {
            	    // InternalOvertarget.g:731:4: (this_hypen_3= rulehypen this_ValidID_4= ruleValidID )
            	    // InternalOvertarget.g:732:5: this_hypen_3= rulehypen this_ValidID_4= ruleValidID
            	    {

            	    					newCompositeNode(grammarAccess.getSourceAccess().getHypenParserRuleCall_1_1_0());
            	    				
            	    pushFollow(FOLLOW_28);
            	    this_hypen_3=rulehypen();

            	    state._fsp--;


            	    					current.merge(this_hypen_3);
            	    				

            	    					afterParserOrEnumRuleCall();
            	    				

            	    					newCompositeNode(grammarAccess.getSourceAccess().getValidIDParserRuleCall_1_1_1());
            	    				
            	    pushFollow(FOLLOW_27);
            	    this_ValidID_4=ruleValidID();

            	    state._fsp--;


            	    					current.merge(this_ValidID_4);
            	    				

            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            // InternalOvertarget.g:754:3: (kw= ':' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==28) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalOvertarget.g:755:4: kw= ':'
                    {
                    kw=(Token)match(input,28,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getSourceAccess().getColonKeyword_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleSource"


    // $ANTLR start "entryRuleUrlExpression"
    // InternalOvertarget.g:768:1: entryRuleUrlExpression returns [EObject current=null] : iv_ruleUrlExpression= ruleUrlExpression EOF ;
    public final EObject entryRuleUrlExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUrlExpression = null;


        try {
            // InternalOvertarget.g:768:54: (iv_ruleUrlExpression= ruleUrlExpression EOF )
            // InternalOvertarget.g:769:2: iv_ruleUrlExpression= ruleUrlExpression EOF
            {
             newCompositeNode(grammarAccess.getUrlExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUrlExpression=ruleUrlExpression();

            state._fsp--;

             current =iv_ruleUrlExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUrlExpression"


    // $ANTLR start "ruleUrlExpression"
    // InternalOvertarget.g:775:1: ruleUrlExpression returns [EObject current=null] : (this_UrlElement_0= ruleUrlElement ( () otherlv_2= '+' ( (lv_right_3_0= ruleUrlElement ) ) )* ) ;
    public final EObject ruleUrlExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_UrlElement_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalOvertarget.g:781:2: ( (this_UrlElement_0= ruleUrlElement ( () otherlv_2= '+' ( (lv_right_3_0= ruleUrlElement ) ) )* ) )
            // InternalOvertarget.g:782:2: (this_UrlElement_0= ruleUrlElement ( () otherlv_2= '+' ( (lv_right_3_0= ruleUrlElement ) ) )* )
            {
            // InternalOvertarget.g:782:2: (this_UrlElement_0= ruleUrlElement ( () otherlv_2= '+' ( (lv_right_3_0= ruleUrlElement ) ) )* )
            // InternalOvertarget.g:783:3: this_UrlElement_0= ruleUrlElement ( () otherlv_2= '+' ( (lv_right_3_0= ruleUrlElement ) ) )*
            {

            			newCompositeNode(grammarAccess.getUrlExpressionAccess().getUrlElementParserRuleCall_0());
            		
            pushFollow(FOLLOW_29);
            this_UrlElement_0=ruleUrlElement();

            state._fsp--;


            			current = this_UrlElement_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalOvertarget.g:791:3: ( () otherlv_2= '+' ( (lv_right_3_0= ruleUrlElement ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==29) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalOvertarget.g:792:4: () otherlv_2= '+' ( (lv_right_3_0= ruleUrlElement ) )
            	    {
            	    // InternalOvertarget.g:792:4: ()
            	    // InternalOvertarget.g:793:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getUrlExpressionAccess().getUrlExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,29,FOLLOW_30); 

            	    				newLeafNode(otherlv_2, grammarAccess.getUrlExpressionAccess().getPlusSignKeyword_1_1());
            	    			
            	    // InternalOvertarget.g:803:4: ( (lv_right_3_0= ruleUrlElement ) )
            	    // InternalOvertarget.g:804:5: (lv_right_3_0= ruleUrlElement )
            	    {
            	    // InternalOvertarget.g:804:5: (lv_right_3_0= ruleUrlElement )
            	    // InternalOvertarget.g:805:6: lv_right_3_0= ruleUrlElement
            	    {

            	    						newCompositeNode(grammarAccess.getUrlExpressionAccess().getRightUrlElementParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_29);
            	    lv_right_3_0=ruleUrlElement();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getUrlExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"de.dlr.sc.overtarget.language.Overtarget.UrlElement");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUrlExpression"


    // $ANTLR start "entryRuleUrlElement"
    // InternalOvertarget.g:827:1: entryRuleUrlElement returns [EObject current=null] : iv_ruleUrlElement= ruleUrlElement EOF ;
    public final EObject entryRuleUrlElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUrlElement = null;


        try {
            // InternalOvertarget.g:827:51: (iv_ruleUrlElement= ruleUrlElement EOF )
            // InternalOvertarget.g:828:2: iv_ruleUrlElement= ruleUrlElement EOF
            {
             newCompositeNode(grammarAccess.getUrlElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUrlElement=ruleUrlElement();

            state._fsp--;

             current =iv_ruleUrlElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUrlElement"


    // $ANTLR start "ruleUrlElement"
    // InternalOvertarget.g:834:1: ruleUrlElement returns [EObject current=null] : (this_UrlElementVariable_0= ruleUrlElementVariable | this_UrlElementString_1= ruleUrlElementString ) ;
    public final EObject ruleUrlElement() throws RecognitionException {
        EObject current = null;

        EObject this_UrlElementVariable_0 = null;

        EObject this_UrlElementString_1 = null;



        	enterRule();

        try {
            // InternalOvertarget.g:840:2: ( (this_UrlElementVariable_0= ruleUrlElementVariable | this_UrlElementString_1= ruleUrlElementString ) )
            // InternalOvertarget.g:841:2: (this_UrlElementVariable_0= ruleUrlElementVariable | this_UrlElementString_1= ruleUrlElementString )
            {
            // InternalOvertarget.g:841:2: (this_UrlElementVariable_0= ruleUrlElementVariable | this_UrlElementString_1= ruleUrlElementString )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ID) ) {
                alt22=1;
            }
            else if ( (LA22_0==RULE_STRING) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalOvertarget.g:842:3: this_UrlElementVariable_0= ruleUrlElementVariable
                    {

                    			newCompositeNode(grammarAccess.getUrlElementAccess().getUrlElementVariableParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_UrlElementVariable_0=ruleUrlElementVariable();

                    state._fsp--;


                    			current = this_UrlElementVariable_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOvertarget.g:851:3: this_UrlElementString_1= ruleUrlElementString
                    {

                    			newCompositeNode(grammarAccess.getUrlElementAccess().getUrlElementStringParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_UrlElementString_1=ruleUrlElementString();

                    state._fsp--;


                    			current = this_UrlElementString_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUrlElement"


    // $ANTLR start "entryRuleUrlElementString"
    // InternalOvertarget.g:863:1: entryRuleUrlElementString returns [EObject current=null] : iv_ruleUrlElementString= ruleUrlElementString EOF ;
    public final EObject entryRuleUrlElementString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUrlElementString = null;


        try {
            // InternalOvertarget.g:863:57: (iv_ruleUrlElementString= ruleUrlElementString EOF )
            // InternalOvertarget.g:864:2: iv_ruleUrlElementString= ruleUrlElementString EOF
            {
             newCompositeNode(grammarAccess.getUrlElementStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUrlElementString=ruleUrlElementString();

            state._fsp--;

             current =iv_ruleUrlElementString; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUrlElementString"


    // $ANTLR start "ruleUrlElementString"
    // InternalOvertarget.g:870:1: ruleUrlElementString returns [EObject current=null] : ( (lv_content_0_0= RULE_STRING ) ) ;
    public final EObject ruleUrlElementString() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;


        	enterRule();

        try {
            // InternalOvertarget.g:876:2: ( ( (lv_content_0_0= RULE_STRING ) ) )
            // InternalOvertarget.g:877:2: ( (lv_content_0_0= RULE_STRING ) )
            {
            // InternalOvertarget.g:877:2: ( (lv_content_0_0= RULE_STRING ) )
            // InternalOvertarget.g:878:3: (lv_content_0_0= RULE_STRING )
            {
            // InternalOvertarget.g:878:3: (lv_content_0_0= RULE_STRING )
            // InternalOvertarget.g:879:4: lv_content_0_0= RULE_STRING
            {
            lv_content_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_content_0_0, grammarAccess.getUrlElementStringAccess().getContentSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getUrlElementStringRule());
            				}
            				setWithLastConsumed(
            					current,
            					"content",
            					lv_content_0_0,
            					"org.eclipse.xtext.common.Terminals.STRING");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUrlElementString"


    // $ANTLR start "entryRuleUrlElementVariable"
    // InternalOvertarget.g:898:1: entryRuleUrlElementVariable returns [EObject current=null] : iv_ruleUrlElementVariable= ruleUrlElementVariable EOF ;
    public final EObject entryRuleUrlElementVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUrlElementVariable = null;


        try {
            // InternalOvertarget.g:898:59: (iv_ruleUrlElementVariable= ruleUrlElementVariable EOF )
            // InternalOvertarget.g:899:2: iv_ruleUrlElementVariable= ruleUrlElementVariable EOF
            {
             newCompositeNode(grammarAccess.getUrlElementVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUrlElementVariable=ruleUrlElementVariable();

            state._fsp--;

             current =iv_ruleUrlElementVariable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUrlElementVariable"


    // $ANTLR start "ruleUrlElementVariable"
    // InternalOvertarget.g:905:1: ruleUrlElementVariable returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleUrlElementVariable() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalOvertarget.g:911:2: ( ( ( ruleQualifiedName ) ) )
            // InternalOvertarget.g:912:2: ( ( ruleQualifiedName ) )
            {
            // InternalOvertarget.g:912:2: ( ( ruleQualifiedName ) )
            // InternalOvertarget.g:913:3: ( ruleQualifiedName )
            {
            // InternalOvertarget.g:913:3: ( ruleQualifiedName )
            // InternalOvertarget.g:914:4: ruleQualifiedName
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getUrlElementVariableRule());
            				}
            			

            				newCompositeNode(grammarAccess.getUrlElementVariableAccess().getContentVariableDefinitionCrossReference_0());
            			
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUrlElementVariable"


    // $ANTLR start "entryRuleRepositoryLocation"
    // InternalOvertarget.g:931:1: entryRuleRepositoryLocation returns [EObject current=null] : iv_ruleRepositoryLocation= ruleRepositoryLocation EOF ;
    public final EObject entryRuleRepositoryLocation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRepositoryLocation = null;


        try {
            // InternalOvertarget.g:931:59: (iv_ruleRepositoryLocation= ruleRepositoryLocation EOF )
            // InternalOvertarget.g:932:2: iv_ruleRepositoryLocation= ruleRepositoryLocation EOF
            {
             newCompositeNode(grammarAccess.getRepositoryLocationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRepositoryLocation=ruleRepositoryLocation();

            state._fsp--;

             current =iv_ruleRepositoryLocation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRepositoryLocation"


    // $ANTLR start "ruleRepositoryLocation"
    // InternalOvertarget.g:938:1: ruleRepositoryLocation returns [EObject current=null] : ( ( (lv_referencedTarget_0_0= 'ReferencedTarget' ) )? otherlv_1= 'RepositoryLocation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'url' ( (lv_url_4_0= ruleUrlExpression ) ) otherlv_5= '{' ( (otherlv_6= 'Unit' ( (lv_addAll_7_0= 'addAll;' ) ) ) | ( (lv_units_8_0= ruleUnit ) )* ) otherlv_9= '}' ) ;
    public final EObject ruleRepositoryLocation() throws RecognitionException {
        EObject current = null;

        Token lv_referencedTarget_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_addAll_7_0=null;
        Token otherlv_9=null;
        EObject lv_url_4_0 = null;

        EObject lv_units_8_0 = null;



        	enterRule();

        try {
            // InternalOvertarget.g:944:2: ( ( ( (lv_referencedTarget_0_0= 'ReferencedTarget' ) )? otherlv_1= 'RepositoryLocation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'url' ( (lv_url_4_0= ruleUrlExpression ) ) otherlv_5= '{' ( (otherlv_6= 'Unit' ( (lv_addAll_7_0= 'addAll;' ) ) ) | ( (lv_units_8_0= ruleUnit ) )* ) otherlv_9= '}' ) )
            // InternalOvertarget.g:945:2: ( ( (lv_referencedTarget_0_0= 'ReferencedTarget' ) )? otherlv_1= 'RepositoryLocation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'url' ( (lv_url_4_0= ruleUrlExpression ) ) otherlv_5= '{' ( (otherlv_6= 'Unit' ( (lv_addAll_7_0= 'addAll;' ) ) ) | ( (lv_units_8_0= ruleUnit ) )* ) otherlv_9= '}' )
            {
            // InternalOvertarget.g:945:2: ( ( (lv_referencedTarget_0_0= 'ReferencedTarget' ) )? otherlv_1= 'RepositoryLocation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'url' ( (lv_url_4_0= ruleUrlExpression ) ) otherlv_5= '{' ( (otherlv_6= 'Unit' ( (lv_addAll_7_0= 'addAll;' ) ) ) | ( (lv_units_8_0= ruleUnit ) )* ) otherlv_9= '}' )
            // InternalOvertarget.g:946:3: ( (lv_referencedTarget_0_0= 'ReferencedTarget' ) )? otherlv_1= 'RepositoryLocation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'url' ( (lv_url_4_0= ruleUrlExpression ) ) otherlv_5= '{' ( (otherlv_6= 'Unit' ( (lv_addAll_7_0= 'addAll;' ) ) ) | ( (lv_units_8_0= ruleUnit ) )* ) otherlv_9= '}'
            {
            // InternalOvertarget.g:946:3: ( (lv_referencedTarget_0_0= 'ReferencedTarget' ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==30) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalOvertarget.g:947:4: (lv_referencedTarget_0_0= 'ReferencedTarget' )
                    {
                    // InternalOvertarget.g:947:4: (lv_referencedTarget_0_0= 'ReferencedTarget' )
                    // InternalOvertarget.g:948:5: lv_referencedTarget_0_0= 'ReferencedTarget'
                    {
                    lv_referencedTarget_0_0=(Token)match(input,30,FOLLOW_31); 

                    					newLeafNode(lv_referencedTarget_0_0, grammarAccess.getRepositoryLocationAccess().getReferencedTargetReferencedTargetKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getRepositoryLocationRule());
                    					}
                    					setWithLastConsumed(current, "referencedTarget", lv_referencedTarget_0_0 != null, "ReferencedTarget");
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getRepositoryLocationAccess().getRepositoryLocationKeyword_1());
            		
            // InternalOvertarget.g:964:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOvertarget.g:965:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOvertarget.g:965:4: (lv_name_2_0= RULE_ID )
            // InternalOvertarget.g:966:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(lv_name_2_0, grammarAccess.getRepositoryLocationAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRepositoryLocationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,32,FOLLOW_30); 

            			newLeafNode(otherlv_3, grammarAccess.getRepositoryLocationAccess().getUrlKeyword_3());
            		
            // InternalOvertarget.g:986:3: ( (lv_url_4_0= ruleUrlExpression ) )
            // InternalOvertarget.g:987:4: (lv_url_4_0= ruleUrlExpression )
            {
            // InternalOvertarget.g:987:4: (lv_url_4_0= ruleUrlExpression )
            // InternalOvertarget.g:988:5: lv_url_4_0= ruleUrlExpression
            {

            					newCompositeNode(grammarAccess.getRepositoryLocationAccess().getUrlUrlExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_4);
            lv_url_4_0=ruleUrlExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRepositoryLocationRule());
            					}
            					set(
            						current,
            						"url",
            						lv_url_4_0,
            						"de.dlr.sc.overtarget.language.Overtarget.UrlExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,12,FOLLOW_33); 

            			newLeafNode(otherlv_5, grammarAccess.getRepositoryLocationAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalOvertarget.g:1009:3: ( (otherlv_6= 'Unit' ( (lv_addAll_7_0= 'addAll;' ) ) ) | ( (lv_units_8_0= ruleUnit ) )* )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==24) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==RULE_ID||LA25_1==14||LA25_1==24||LA25_1==27) ) {
                    alt25=2;
                }
                else if ( (LA25_1==33) ) {
                    alt25=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA25_0==13) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalOvertarget.g:1010:4: (otherlv_6= 'Unit' ( (lv_addAll_7_0= 'addAll;' ) ) )
                    {
                    // InternalOvertarget.g:1010:4: (otherlv_6= 'Unit' ( (lv_addAll_7_0= 'addAll;' ) ) )
                    // InternalOvertarget.g:1011:5: otherlv_6= 'Unit' ( (lv_addAll_7_0= 'addAll;' ) )
                    {
                    otherlv_6=(Token)match(input,24,FOLLOW_34); 

                    					newLeafNode(otherlv_6, grammarAccess.getRepositoryLocationAccess().getUnitKeyword_6_0_0());
                    				
                    // InternalOvertarget.g:1015:5: ( (lv_addAll_7_0= 'addAll;' ) )
                    // InternalOvertarget.g:1016:6: (lv_addAll_7_0= 'addAll;' )
                    {
                    // InternalOvertarget.g:1016:6: (lv_addAll_7_0= 'addAll;' )
                    // InternalOvertarget.g:1017:7: lv_addAll_7_0= 'addAll;'
                    {
                    lv_addAll_7_0=(Token)match(input,33,FOLLOW_35); 

                    							newLeafNode(lv_addAll_7_0, grammarAccess.getRepositoryLocationAccess().getAddAllAddAllKeyword_6_0_1_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRepositoryLocationRule());
                    							}
                    							setWithLastConsumed(current, "addAll", lv_addAll_7_0 != null, "addAll;");
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalOvertarget.g:1031:4: ( (lv_units_8_0= ruleUnit ) )*
                    {
                    // InternalOvertarget.g:1031:4: ( (lv_units_8_0= ruleUnit ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==24) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalOvertarget.g:1032:5: (lv_units_8_0= ruleUnit )
                    	    {
                    	    // InternalOvertarget.g:1032:5: (lv_units_8_0= ruleUnit )
                    	    // InternalOvertarget.g:1033:6: lv_units_8_0= ruleUnit
                    	    {

                    	    						newCompositeNode(grammarAccess.getRepositoryLocationAccess().getUnitsUnitParserRuleCall_6_1_0());
                    	    					
                    	    pushFollow(FOLLOW_33);
                    	    lv_units_8_0=ruleUnit();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getRepositoryLocationRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"units",
                    	    							lv_units_8_0,
                    	    							"de.dlr.sc.overtarget.language.Overtarget.Unit");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_9=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getRepositoryLocationAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRepositoryLocation"


    // $ANTLR start "entryRuleExcludeLocation"
    // InternalOvertarget.g:1059:1: entryRuleExcludeLocation returns [EObject current=null] : iv_ruleExcludeLocation= ruleExcludeLocation EOF ;
    public final EObject entryRuleExcludeLocation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExcludeLocation = null;


        try {
            // InternalOvertarget.g:1059:56: (iv_ruleExcludeLocation= ruleExcludeLocation EOF )
            // InternalOvertarget.g:1060:2: iv_ruleExcludeLocation= ruleExcludeLocation EOF
            {
             newCompositeNode(grammarAccess.getExcludeLocationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExcludeLocation=ruleExcludeLocation();

            state._fsp--;

             current =iv_ruleExcludeLocation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExcludeLocation"


    // $ANTLR start "ruleExcludeLocation"
    // InternalOvertarget.g:1066:1: ruleExcludeLocation returns [EObject current=null] : ( () otherlv_1= 'ExcludeLocation' ( ( ruleQualifiedName ) ) otherlv_3= '{' ( ( (lv_units_4_0= ruleUnit ) )* | otherlv_5= 'all;' ) otherlv_6= '}' ) ;
    public final EObject ruleExcludeLocation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_units_4_0 = null;



        	enterRule();

        try {
            // InternalOvertarget.g:1072:2: ( ( () otherlv_1= 'ExcludeLocation' ( ( ruleQualifiedName ) ) otherlv_3= '{' ( ( (lv_units_4_0= ruleUnit ) )* | otherlv_5= 'all;' ) otherlv_6= '}' ) )
            // InternalOvertarget.g:1073:2: ( () otherlv_1= 'ExcludeLocation' ( ( ruleQualifiedName ) ) otherlv_3= '{' ( ( (lv_units_4_0= ruleUnit ) )* | otherlv_5= 'all;' ) otherlv_6= '}' )
            {
            // InternalOvertarget.g:1073:2: ( () otherlv_1= 'ExcludeLocation' ( ( ruleQualifiedName ) ) otherlv_3= '{' ( ( (lv_units_4_0= ruleUnit ) )* | otherlv_5= 'all;' ) otherlv_6= '}' )
            // InternalOvertarget.g:1074:3: () otherlv_1= 'ExcludeLocation' ( ( ruleQualifiedName ) ) otherlv_3= '{' ( ( (lv_units_4_0= ruleUnit ) )* | otherlv_5= 'all;' ) otherlv_6= '}'
            {
            // InternalOvertarget.g:1074:3: ()
            // InternalOvertarget.g:1075:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExcludeLocationAccess().getExcludeLocationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getExcludeLocationAccess().getExcludeLocationKeyword_1());
            		
            // InternalOvertarget.g:1085:3: ( ( ruleQualifiedName ) )
            // InternalOvertarget.g:1086:4: ( ruleQualifiedName )
            {
            // InternalOvertarget.g:1086:4: ( ruleQualifiedName )
            // InternalOvertarget.g:1087:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExcludeLocationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getExcludeLocationAccess().getRepositoryLocationRepositoryLocationCrossReference_2_0());
            				
            pushFollow(FOLLOW_4);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_36); 

            			newLeafNode(otherlv_3, grammarAccess.getExcludeLocationAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOvertarget.g:1105:3: ( ( (lv_units_4_0= ruleUnit ) )* | otherlv_5= 'all;' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==13||LA27_0==24) ) {
                alt27=1;
            }
            else if ( (LA27_0==35) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalOvertarget.g:1106:4: ( (lv_units_4_0= ruleUnit ) )*
                    {
                    // InternalOvertarget.g:1106:4: ( (lv_units_4_0= ruleUnit ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==24) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalOvertarget.g:1107:5: (lv_units_4_0= ruleUnit )
                    	    {
                    	    // InternalOvertarget.g:1107:5: (lv_units_4_0= ruleUnit )
                    	    // InternalOvertarget.g:1108:6: lv_units_4_0= ruleUnit
                    	    {

                    	    						newCompositeNode(grammarAccess.getExcludeLocationAccess().getUnitsUnitParserRuleCall_4_0_0());
                    	    					
                    	    pushFollow(FOLLOW_33);
                    	    lv_units_4_0=ruleUnit();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getExcludeLocationRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"units",
                    	    							lv_units_4_0,
                    	    							"de.dlr.sc.overtarget.language.Overtarget.Unit");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalOvertarget.g:1126:4: otherlv_5= 'all;'
                    {
                    otherlv_5=(Token)match(input,35,FOLLOW_35); 

                    				newLeafNode(otherlv_5, grammarAccess.getExcludeLocationAccess().getAllKeyword_4_1());
                    			

                    }
                    break;

            }

            otherlv_6=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getExcludeLocationAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExcludeLocation"


    // $ANTLR start "entryRuleVariableDefinition"
    // InternalOvertarget.g:1139:1: entryRuleVariableDefinition returns [EObject current=null] : iv_ruleVariableDefinition= ruleVariableDefinition EOF ;
    public final EObject entryRuleVariableDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDefinition = null;


        try {
            // InternalOvertarget.g:1139:59: (iv_ruleVariableDefinition= ruleVariableDefinition EOF )
            // InternalOvertarget.g:1140:2: iv_ruleVariableDefinition= ruleVariableDefinition EOF
            {
             newCompositeNode(grammarAccess.getVariableDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableDefinition=ruleVariableDefinition();

            state._fsp--;

             current =iv_ruleVariableDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableDefinition"


    // $ANTLR start "ruleVariableDefinition"
    // InternalOvertarget.g:1146:1: ruleVariableDefinition returns [EObject current=null] : (this_AlreadyDeclaredVariable_0= ruleAlreadyDeclaredVariable | this_NewVariableDefinition_1= ruleNewVariableDefinition ) ;
    public final EObject ruleVariableDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_AlreadyDeclaredVariable_0 = null;

        EObject this_NewVariableDefinition_1 = null;



        	enterRule();

        try {
            // InternalOvertarget.g:1152:2: ( (this_AlreadyDeclaredVariable_0= ruleAlreadyDeclaredVariable | this_NewVariableDefinition_1= ruleNewVariableDefinition ) )
            // InternalOvertarget.g:1153:2: (this_AlreadyDeclaredVariable_0= ruleAlreadyDeclaredVariable | this_NewVariableDefinition_1= ruleNewVariableDefinition )
            {
            // InternalOvertarget.g:1153:2: (this_AlreadyDeclaredVariable_0= ruleAlreadyDeclaredVariable | this_NewVariableDefinition_1= ruleNewVariableDefinition )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==36) ) {
                alt28=1;
            }
            else if ( (LA28_0==38) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalOvertarget.g:1154:3: this_AlreadyDeclaredVariable_0= ruleAlreadyDeclaredVariable
                    {

                    			newCompositeNode(grammarAccess.getVariableDefinitionAccess().getAlreadyDeclaredVariableParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AlreadyDeclaredVariable_0=ruleAlreadyDeclaredVariable();

                    state._fsp--;


                    			current = this_AlreadyDeclaredVariable_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOvertarget.g:1163:3: this_NewVariableDefinition_1= ruleNewVariableDefinition
                    {

                    			newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNewVariableDefinitionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_NewVariableDefinition_1=ruleNewVariableDefinition();

                    state._fsp--;


                    			current = this_NewVariableDefinition_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableDefinition"


    // $ANTLR start "entryRuleAlreadyDeclaredVariable"
    // InternalOvertarget.g:1175:1: entryRuleAlreadyDeclaredVariable returns [EObject current=null] : iv_ruleAlreadyDeclaredVariable= ruleAlreadyDeclaredVariable EOF ;
    public final EObject entryRuleAlreadyDeclaredVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlreadyDeclaredVariable = null;


        try {
            // InternalOvertarget.g:1175:64: (iv_ruleAlreadyDeclaredVariable= ruleAlreadyDeclaredVariable EOF )
            // InternalOvertarget.g:1176:2: iv_ruleAlreadyDeclaredVariable= ruleAlreadyDeclaredVariable EOF
            {
             newCompositeNode(grammarAccess.getAlreadyDeclaredVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAlreadyDeclaredVariable=ruleAlreadyDeclaredVariable();

            state._fsp--;

             current =iv_ruleAlreadyDeclaredVariable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlreadyDeclaredVariable"


    // $ANTLR start "ruleAlreadyDeclaredVariable"
    // InternalOvertarget.g:1182:1: ruleAlreadyDeclaredVariable returns [EObject current=null] : (otherlv_0= 'Override' ( ( ruleQualifiedName ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleAlreadyDeclaredVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;


        	enterRule();

        try {
            // InternalOvertarget.g:1188:2: ( (otherlv_0= 'Override' ( ( ruleQualifiedName ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) ) )
            // InternalOvertarget.g:1189:2: (otherlv_0= 'Override' ( ( ruleQualifiedName ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )
            {
            // InternalOvertarget.g:1189:2: (otherlv_0= 'Override' ( ( ruleQualifiedName ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )
            // InternalOvertarget.g:1190:3: otherlv_0= 'Override' ( ( ruleQualifiedName ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAlreadyDeclaredVariableAccess().getOverrideKeyword_0());
            		
            // InternalOvertarget.g:1194:3: ( ( ruleQualifiedName ) )
            // InternalOvertarget.g:1195:4: ( ruleQualifiedName )
            {
            // InternalOvertarget.g:1195:4: ( ruleQualifiedName )
            // InternalOvertarget.g:1196:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAlreadyDeclaredVariableRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAlreadyDeclaredVariableAccess().getRefNewVariableDefinitionCrossReference_1_0());
            				
            pushFollow(FOLLOW_37);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,37,FOLLOW_38); 

            			newLeafNode(otherlv_2, grammarAccess.getAlreadyDeclaredVariableAccess().getEqualsSignKeyword_2());
            		
            // InternalOvertarget.g:1214:3: ( (lv_value_3_0= RULE_STRING ) )
            // InternalOvertarget.g:1215:4: (lv_value_3_0= RULE_STRING )
            {
            // InternalOvertarget.g:1215:4: (lv_value_3_0= RULE_STRING )
            // InternalOvertarget.g:1216:5: lv_value_3_0= RULE_STRING
            {
            lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_value_3_0, grammarAccess.getAlreadyDeclaredVariableAccess().getValueSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAlreadyDeclaredVariableRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlreadyDeclaredVariable"


    // $ANTLR start "entryRuleNewVariableDefinition"
    // InternalOvertarget.g:1236:1: entryRuleNewVariableDefinition returns [EObject current=null] : iv_ruleNewVariableDefinition= ruleNewVariableDefinition EOF ;
    public final EObject entryRuleNewVariableDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNewVariableDefinition = null;


        try {
            // InternalOvertarget.g:1236:62: (iv_ruleNewVariableDefinition= ruleNewVariableDefinition EOF )
            // InternalOvertarget.g:1237:2: iv_ruleNewVariableDefinition= ruleNewVariableDefinition EOF
            {
             newCompositeNode(grammarAccess.getNewVariableDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNewVariableDefinition=ruleNewVariableDefinition();

            state._fsp--;

             current =iv_ruleNewVariableDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNewVariableDefinition"


    // $ANTLR start "ruleNewVariableDefinition"
    // InternalOvertarget.g:1243:1: ruleNewVariableDefinition returns [EObject current=null] : (otherlv_0= 'Variable' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleNewVariableDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;


        	enterRule();

        try {
            // InternalOvertarget.g:1249:2: ( (otherlv_0= 'Variable' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) ) )
            // InternalOvertarget.g:1250:2: (otherlv_0= 'Variable' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )
            {
            // InternalOvertarget.g:1250:2: (otherlv_0= 'Variable' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )
            // InternalOvertarget.g:1251:3: otherlv_0= 'Variable' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getNewVariableDefinitionAccess().getVariableKeyword_0());
            		
            // InternalOvertarget.g:1255:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOvertarget.g:1256:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOvertarget.g:1256:4: (lv_name_1_0= RULE_ID )
            // InternalOvertarget.g:1257:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_37); 

            					newLeafNode(lv_name_1_0, grammarAccess.getNewVariableDefinitionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNewVariableDefinitionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,37,FOLLOW_38); 

            			newLeafNode(otherlv_2, grammarAccess.getNewVariableDefinitionAccess().getEqualsSignKeyword_2());
            		
            // InternalOvertarget.g:1277:3: ( (lv_value_3_0= RULE_STRING ) )
            // InternalOvertarget.g:1278:4: (lv_value_3_0= RULE_STRING )
            {
            // InternalOvertarget.g:1278:4: (lv_value_3_0= RULE_STRING )
            // InternalOvertarget.g:1279:5: lv_value_3_0= RULE_STRING
            {
            lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_value_3_0, grammarAccess.getNewVariableDefinitionAccess().getValueSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNewVariableDefinitionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNewVariableDefinition"


    // $ANTLR start "entryRulequalifier"
    // InternalOvertarget.g:1299:1: entryRulequalifier returns [String current=null] : iv_rulequalifier= rulequalifier EOF ;
    public final String entryRulequalifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulequalifier = null;


        try {
            // InternalOvertarget.g:1299:49: (iv_rulequalifier= rulequalifier EOF )
            // InternalOvertarget.g:1300:2: iv_rulequalifier= rulequalifier EOF
            {
             newCompositeNode(grammarAccess.getQualifierRule()); 
            pushFollow(FOLLOW_1);
            iv_rulequalifier=rulequalifier();

            state._fsp--;

             current =iv_rulequalifier.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulequalifier"


    // $ANTLR start "rulequalifier"
    // InternalOvertarget.g:1306:1: rulequalifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_INT_0= RULE_INT | this_ID_1= RULE_ID )+ (kw= '-' (this_INT_3= RULE_INT | this_ID_4= RULE_ID ) )? ) ;
    public final AntlrDatatypeRuleToken rulequalifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_ID_1=null;
        Token kw=null;
        Token this_INT_3=null;
        Token this_ID_4=null;


        	enterRule();

        try {
            // InternalOvertarget.g:1312:2: ( ( (this_INT_0= RULE_INT | this_ID_1= RULE_ID )+ (kw= '-' (this_INT_3= RULE_INT | this_ID_4= RULE_ID ) )? ) )
            // InternalOvertarget.g:1313:2: ( (this_INT_0= RULE_INT | this_ID_1= RULE_ID )+ (kw= '-' (this_INT_3= RULE_INT | this_ID_4= RULE_ID ) )? )
            {
            // InternalOvertarget.g:1313:2: ( (this_INT_0= RULE_INT | this_ID_1= RULE_ID )+ (kw= '-' (this_INT_3= RULE_INT | this_ID_4= RULE_ID ) )? )
            // InternalOvertarget.g:1314:3: (this_INT_0= RULE_INT | this_ID_1= RULE_ID )+ (kw= '-' (this_INT_3= RULE_INT | this_ID_4= RULE_ID ) )?
            {
            // InternalOvertarget.g:1314:3: (this_INT_0= RULE_INT | this_ID_1= RULE_ID )+
            int cnt29=0;
            loop29:
            do {
                int alt29=3;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_INT) ) {
                    alt29=1;
                }
                else if ( (LA29_0==RULE_ID) ) {
                    alt29=2;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalOvertarget.g:1315:4: this_INT_0= RULE_INT
            	    {
            	    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_39); 

            	    				current.merge(this_INT_0);
            	    			

            	    				newLeafNode(this_INT_0, grammarAccess.getQualifierAccess().getINTTerminalRuleCall_0_0());
            	    			

            	    }
            	    break;
            	case 2 :
            	    // InternalOvertarget.g:1323:4: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_39); 

            	    				current.merge(this_ID_1);
            	    			

            	    				newLeafNode(this_ID_1, grammarAccess.getQualifierAccess().getIDTerminalRuleCall_0_1());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);

            // InternalOvertarget.g:1331:3: (kw= '-' (this_INT_3= RULE_INT | this_ID_4= RULE_ID ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==39) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalOvertarget.g:1332:4: kw= '-' (this_INT_3= RULE_INT | this_ID_4= RULE_ID )
                    {
                    kw=(Token)match(input,39,FOLLOW_22); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getQualifierAccess().getHyphenMinusKeyword_1_0());
                    			
                    // InternalOvertarget.g:1337:4: (this_INT_3= RULE_INT | this_ID_4= RULE_ID )
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==RULE_INT) ) {
                        alt30=1;
                    }
                    else if ( (LA30_0==RULE_ID) ) {
                        alt30=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 0, input);

                        throw nvae;
                    }
                    switch (alt30) {
                        case 1 :
                            // InternalOvertarget.g:1338:5: this_INT_3= RULE_INT
                            {
                            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_2); 

                            					current.merge(this_INT_3);
                            				

                            					newLeafNode(this_INT_3, grammarAccess.getQualifierAccess().getINTTerminalRuleCall_1_1_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalOvertarget.g:1346:5: this_ID_4= RULE_ID
                            {
                            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_2); 

                            					current.merge(this_ID_4);
                            				

                            					newLeafNode(this_ID_4, grammarAccess.getQualifierAccess().getIDTerminalRuleCall_1_1_1());
                            				

                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulequalifier"


    // $ANTLR start "entryRuleOperatingSys"
    // InternalOvertarget.g:1359:1: entryRuleOperatingSys returns [String current=null] : iv_ruleOperatingSys= ruleOperatingSys EOF ;
    public final String entryRuleOperatingSys() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOperatingSys = null;


        try {
            // InternalOvertarget.g:1359:52: (iv_ruleOperatingSys= ruleOperatingSys EOF )
            // InternalOvertarget.g:1360:2: iv_ruleOperatingSys= ruleOperatingSys EOF
            {
             newCompositeNode(grammarAccess.getOperatingSysRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperatingSys=ruleOperatingSys();

            state._fsp--;

             current =iv_ruleOperatingSys.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperatingSys"


    // $ANTLR start "ruleOperatingSys"
    // InternalOvertarget.g:1366:1: ruleOperatingSys returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'aix' | kw= 'hpux' | kw= 'linux' | kw= 'macosx' | kw= 'qnx' | kw= 'solaris' | kw= 'win32' ) ;
    public final AntlrDatatypeRuleToken ruleOperatingSys() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalOvertarget.g:1372:2: ( (kw= 'aix' | kw= 'hpux' | kw= 'linux' | kw= 'macosx' | kw= 'qnx' | kw= 'solaris' | kw= 'win32' ) )
            // InternalOvertarget.g:1373:2: (kw= 'aix' | kw= 'hpux' | kw= 'linux' | kw= 'macosx' | kw= 'qnx' | kw= 'solaris' | kw= 'win32' )
            {
            // InternalOvertarget.g:1373:2: (kw= 'aix' | kw= 'hpux' | kw= 'linux' | kw= 'macosx' | kw= 'qnx' | kw= 'solaris' | kw= 'win32' )
            int alt32=7;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt32=1;
                }
                break;
            case 41:
                {
                alt32=2;
                }
                break;
            case 42:
                {
                alt32=3;
                }
                break;
            case 43:
                {
                alt32=4;
                }
                break;
            case 44:
                {
                alt32=5;
                }
                break;
            case 45:
                {
                alt32=6;
                }
                break;
            case 46:
                {
                alt32=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // InternalOvertarget.g:1374:3: kw= 'aix'
                    {
                    kw=(Token)match(input,40,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatingSysAccess().getAixKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOvertarget.g:1380:3: kw= 'hpux'
                    {
                    kw=(Token)match(input,41,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatingSysAccess().getHpuxKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalOvertarget.g:1386:3: kw= 'linux'
                    {
                    kw=(Token)match(input,42,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatingSysAccess().getLinuxKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalOvertarget.g:1392:3: kw= 'macosx'
                    {
                    kw=(Token)match(input,43,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatingSysAccess().getMacosxKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalOvertarget.g:1398:3: kw= 'qnx'
                    {
                    kw=(Token)match(input,44,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatingSysAccess().getQnxKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalOvertarget.g:1404:3: kw= 'solaris'
                    {
                    kw=(Token)match(input,45,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatingSysAccess().getSolarisKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalOvertarget.g:1410:3: kw= 'win32'
                    {
                    kw=(Token)match(input,46,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatingSysAccess().getWin32Keyword_6());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperatingSys"


    // $ANTLR start "entryRuleWindowingSys"
    // InternalOvertarget.g:1419:1: entryRuleWindowingSys returns [String current=null] : iv_ruleWindowingSys= ruleWindowingSys EOF ;
    public final String entryRuleWindowingSys() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleWindowingSys = null;


        try {
            // InternalOvertarget.g:1419:52: (iv_ruleWindowingSys= ruleWindowingSys EOF )
            // InternalOvertarget.g:1420:2: iv_ruleWindowingSys= ruleWindowingSys EOF
            {
             newCompositeNode(grammarAccess.getWindowingSysRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWindowingSys=ruleWindowingSys();

            state._fsp--;

             current =iv_ruleWindowingSys.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWindowingSys"


    // $ANTLR start "ruleWindowingSys"
    // InternalOvertarget.g:1426:1: ruleWindowingSys returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'carbon' | kw= 'cocoa' | kw= 'gtk' | kw= 'motif' | kw= 'photon' | kw= 'wpf' | kw= 'win32' ) ;
    public final AntlrDatatypeRuleToken ruleWindowingSys() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalOvertarget.g:1432:2: ( (kw= 'carbon' | kw= 'cocoa' | kw= 'gtk' | kw= 'motif' | kw= 'photon' | kw= 'wpf' | kw= 'win32' ) )
            // InternalOvertarget.g:1433:2: (kw= 'carbon' | kw= 'cocoa' | kw= 'gtk' | kw= 'motif' | kw= 'photon' | kw= 'wpf' | kw= 'win32' )
            {
            // InternalOvertarget.g:1433:2: (kw= 'carbon' | kw= 'cocoa' | kw= 'gtk' | kw= 'motif' | kw= 'photon' | kw= 'wpf' | kw= 'win32' )
            int alt33=7;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt33=1;
                }
                break;
            case 48:
                {
                alt33=2;
                }
                break;
            case 49:
                {
                alt33=3;
                }
                break;
            case 50:
                {
                alt33=4;
                }
                break;
            case 51:
                {
                alt33=5;
                }
                break;
            case 52:
                {
                alt33=6;
                }
                break;
            case 46:
                {
                alt33=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalOvertarget.g:1434:3: kw= 'carbon'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWindowingSysAccess().getCarbonKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOvertarget.g:1440:3: kw= 'cocoa'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWindowingSysAccess().getCocoaKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalOvertarget.g:1446:3: kw= 'gtk'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWindowingSysAccess().getGtkKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalOvertarget.g:1452:3: kw= 'motif'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWindowingSysAccess().getMotifKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalOvertarget.g:1458:3: kw= 'photon'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWindowingSysAccess().getPhotonKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalOvertarget.g:1464:3: kw= 'wpf'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWindowingSysAccess().getWpfKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalOvertarget.g:1470:3: kw= 'win32'
                    {
                    kw=(Token)match(input,46,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWindowingSysAccess().getWin32Keyword_6());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWindowingSys"


    // $ANTLR start "entryRuleArchitecture"
    // InternalOvertarget.g:1479:1: entryRuleArchitecture returns [String current=null] : iv_ruleArchitecture= ruleArchitecture EOF ;
    public final String entryRuleArchitecture() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleArchitecture = null;


        try {
            // InternalOvertarget.g:1479:52: (iv_ruleArchitecture= ruleArchitecture EOF )
            // InternalOvertarget.g:1480:2: iv_ruleArchitecture= ruleArchitecture EOF
            {
             newCompositeNode(grammarAccess.getArchitectureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArchitecture=ruleArchitecture();

            state._fsp--;

             current =iv_ruleArchitecture.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArchitecture"


    // $ANTLR start "ruleArchitecture"
    // InternalOvertarget.g:1486:1: ruleArchitecture returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'PA_RISC' | kw= 'ia64' | kw= 'ia64_32' | kw= 'ppc' | kw= 'sparc' | kw= 'x86' | kw= 'x86_64' ) ;
    public final AntlrDatatypeRuleToken ruleArchitecture() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalOvertarget.g:1492:2: ( (kw= 'PA_RISC' | kw= 'ia64' | kw= 'ia64_32' | kw= 'ppc' | kw= 'sparc' | kw= 'x86' | kw= 'x86_64' ) )
            // InternalOvertarget.g:1493:2: (kw= 'PA_RISC' | kw= 'ia64' | kw= 'ia64_32' | kw= 'ppc' | kw= 'sparc' | kw= 'x86' | kw= 'x86_64' )
            {
            // InternalOvertarget.g:1493:2: (kw= 'PA_RISC' | kw= 'ia64' | kw= 'ia64_32' | kw= 'ppc' | kw= 'sparc' | kw= 'x86' | kw= 'x86_64' )
            int alt34=7;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt34=1;
                }
                break;
            case 54:
                {
                alt34=2;
                }
                break;
            case 55:
                {
                alt34=3;
                }
                break;
            case 56:
                {
                alt34=4;
                }
                break;
            case 57:
                {
                alt34=5;
                }
                break;
            case 58:
                {
                alt34=6;
                }
                break;
            case 59:
                {
                alt34=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalOvertarget.g:1494:3: kw= 'PA_RISC'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getArchitectureAccess().getPA_RISCKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOvertarget.g:1500:3: kw= 'ia64'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getArchitectureAccess().getIa64Keyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalOvertarget.g:1506:3: kw= 'ia64_32'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getArchitectureAccess().getIa64_32Keyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalOvertarget.g:1512:3: kw= 'ppc'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getArchitectureAccess().getPpcKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalOvertarget.g:1518:3: kw= 'sparc'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getArchitectureAccess().getSparcKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalOvertarget.g:1524:3: kw= 'x86'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getArchitectureAccess().getX86Keyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalOvertarget.g:1530:3: kw= 'x86_64'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getArchitectureAccess().getX86_64Keyword_6());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArchitecture"


    // $ANTLR start "entryRuleLocale"
    // InternalOvertarget.g:1539:1: entryRuleLocale returns [String current=null] : iv_ruleLocale= ruleLocale EOF ;
    public final String entryRuleLocale() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLocale = null;


        try {
            // InternalOvertarget.g:1539:46: (iv_ruleLocale= ruleLocale EOF )
            // InternalOvertarget.g:1540:2: iv_ruleLocale= ruleLocale EOF
            {
             newCompositeNode(grammarAccess.getLocaleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLocale=ruleLocale();

            state._fsp--;

             current =iv_ruleLocale.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLocale"


    // $ANTLR start "ruleLocale"
    // InternalOvertarget.g:1546:1: ruleLocale returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleLocale() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalOvertarget.g:1552:2: (this_ID_0= RULE_ID )
            // InternalOvertarget.g:1553:2: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            		current.merge(this_ID_0);
            	

            		newLeafNode(this_ID_0, grammarAccess.getLocaleAccess().getIDTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLocale"


    // $ANTLR start "entryRuledot"
    // InternalOvertarget.g:1563:1: entryRuledot returns [String current=null] : iv_ruledot= ruledot EOF ;
    public final String entryRuledot() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruledot = null;


        try {
            // InternalOvertarget.g:1563:43: (iv_ruledot= ruledot EOF )
            // InternalOvertarget.g:1564:2: iv_ruledot= ruledot EOF
            {
             newCompositeNode(grammarAccess.getDotRule()); 
            pushFollow(FOLLOW_1);
            iv_ruledot=ruledot();

            state._fsp--;

             current =iv_ruledot.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuledot"


    // $ANTLR start "ruledot"
    // InternalOvertarget.g:1570:1: ruledot returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '.' ;
    public final AntlrDatatypeRuleToken ruledot() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalOvertarget.g:1576:2: (kw= '.' )
            // InternalOvertarget.g:1577:2: kw= '.'
            {
            kw=(Token)match(input,23,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getDotAccess().getFullStopKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruledot"


    // $ANTLR start "entryRulehypen"
    // InternalOvertarget.g:1585:1: entryRulehypen returns [String current=null] : iv_rulehypen= rulehypen EOF ;
    public final String entryRulehypen() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulehypen = null;


        try {
            // InternalOvertarget.g:1585:45: (iv_rulehypen= rulehypen EOF )
            // InternalOvertarget.g:1586:2: iv_rulehypen= rulehypen EOF
            {
             newCompositeNode(grammarAccess.getHypenRule()); 
            pushFollow(FOLLOW_1);
            iv_rulehypen=rulehypen();

            state._fsp--;

             current =iv_rulehypen.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulehypen"


    // $ANTLR start "rulehypen"
    // InternalOvertarget.g:1592:1: rulehypen returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '-' ;
    public final AntlrDatatypeRuleToken rulehypen() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalOvertarget.g:1598:2: (kw= '-' )
            // InternalOvertarget.g:1599:2: kw= '-'
            {
            kw=(Token)match(input,39,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getHypenAccess().getHyphenMinusKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulehypen"


    // $ANTLR start "entryRulejre"
    // InternalOvertarget.g:1607:1: entryRulejre returns [String current=null] : iv_rulejre= rulejre EOF ;
    public final String entryRulejre() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulejre = null;


        try {
            // InternalOvertarget.g:1607:43: (iv_rulejre= rulejre EOF )
            // InternalOvertarget.g:1608:2: iv_rulejre= rulejre EOF
            {
             newCompositeNode(grammarAccess.getJreRule()); 
            pushFollow(FOLLOW_1);
            iv_rulejre=rulejre();

            state._fsp--;

             current =iv_rulejre.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulejre"


    // $ANTLR start "rulejre"
    // InternalOvertarget.g:1614:1: rulejre returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= '-' | this_SimpleVersion_2= ruleSimpleVersion )+ ;
    public final AntlrDatatypeRuleToken rulejre() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_SimpleVersion_2 = null;



        	enterRule();

        try {
            // InternalOvertarget.g:1620:2: ( (this_ID_0= RULE_ID | kw= '-' | this_SimpleVersion_2= ruleSimpleVersion )+ )
            // InternalOvertarget.g:1621:2: (this_ID_0= RULE_ID | kw= '-' | this_SimpleVersion_2= ruleSimpleVersion )+
            {
            // InternalOvertarget.g:1621:2: (this_ID_0= RULE_ID | kw= '-' | this_SimpleVersion_2= ruleSimpleVersion )+
            int cnt35=0;
            loop35:
            do {
                int alt35=4;
                switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    alt35=1;
                    }
                    break;
                case 39:
                    {
                    alt35=2;
                    }
                    break;
                case RULE_INT:
                    {
                    alt35=3;
                    }
                    break;

                }

                switch (alt35) {
            	case 1 :
            	    // InternalOvertarget.g:1622:3: this_ID_0= RULE_ID
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_39); 

            	    			current.merge(this_ID_0);
            	    		

            	    			newLeafNode(this_ID_0, grammarAccess.getJreAccess().getIDTerminalRuleCall_0());
            	    		

            	    }
            	    break;
            	case 2 :
            	    // InternalOvertarget.g:1630:3: kw= '-'
            	    {
            	    kw=(Token)match(input,39,FOLLOW_39); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getJreAccess().getHyphenMinusKeyword_1());
            	    		

            	    }
            	    break;
            	case 3 :
            	    // InternalOvertarget.g:1636:3: this_SimpleVersion_2= ruleSimpleVersion
            	    {

            	    			newCompositeNode(grammarAccess.getJreAccess().getSimpleVersionParserRuleCall_2());
            	    		
            	    pushFollow(FOLLOW_39);
            	    this_SimpleVersion_2=ruleSimpleVersion();

            	    state._fsp--;


            	    			current.merge(this_SimpleVersion_2);
            	    		

            	    			afterParserOrEnumRuleCall();
            	    		

            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulejre"


    // $ANTLR start "entryRuleValidID"
    // InternalOvertarget.g:1650:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // InternalOvertarget.g:1650:47: (iv_ruleValidID= ruleValidID EOF )
            // InternalOvertarget.g:1651:2: iv_ruleValidID= ruleValidID EOF
            {
             newCompositeNode(grammarAccess.getValidIDRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValidID=ruleValidID();

            state._fsp--;

             current =iv_ruleValidID.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // InternalOvertarget.g:1657:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_KEYWORD_1= ruleKEYWORD ) ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        AntlrDatatypeRuleToken this_KEYWORD_1 = null;



        	enterRule();

        try {
            // InternalOvertarget.g:1663:2: ( (this_ID_0= RULE_ID | this_KEYWORD_1= ruleKEYWORD ) )
            // InternalOvertarget.g:1664:2: (this_ID_0= RULE_ID | this_KEYWORD_1= ruleKEYWORD )
            {
            // InternalOvertarget.g:1664:2: (this_ID_0= RULE_ID | this_KEYWORD_1= ruleKEYWORD )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID) ) {
                alt36=1;
            }
            else if ( (LA36_0==14||LA36_0==24) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalOvertarget.g:1665:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOvertarget.g:1673:3: this_KEYWORD_1= ruleKEYWORD
                    {

                    			newCompositeNode(grammarAccess.getValidIDAccess().getKEYWORDParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_KEYWORD_1=ruleKEYWORD();

                    state._fsp--;


                    			current.merge(this_KEYWORD_1);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValidID"


    // $ANTLR start "entryRuleKEYWORD"
    // InternalOvertarget.g:1687:1: entryRuleKEYWORD returns [String current=null] : iv_ruleKEYWORD= ruleKEYWORD EOF ;
    public final String entryRuleKEYWORD() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKEYWORD = null;


        try {
            // InternalOvertarget.g:1687:47: (iv_ruleKEYWORD= ruleKEYWORD EOF )
            // InternalOvertarget.g:1688:2: iv_ruleKEYWORD= ruleKEYWORD EOF
            {
             newCompositeNode(grammarAccess.getKEYWORDRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKEYWORD=ruleKEYWORD();

            state._fsp--;

             current =iv_ruleKEYWORD.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKEYWORD"


    // $ANTLR start "ruleKEYWORD"
    // InternalOvertarget.g:1694:1: ruleKEYWORD returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Unit' | kw= 'Target' ) ;
    public final AntlrDatatypeRuleToken ruleKEYWORD() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalOvertarget.g:1700:2: ( (kw= 'Unit' | kw= 'Target' ) )
            // InternalOvertarget.g:1701:2: (kw= 'Unit' | kw= 'Target' )
            {
            // InternalOvertarget.g:1701:2: (kw= 'Unit' | kw= 'Target' )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==24) ) {
                alt37=1;
            }
            else if ( (LA37_0==14) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalOvertarget.g:1702:3: kw= 'Unit'
                    {
                    kw=(Token)match(input,24,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getUnitKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOvertarget.g:1708:3: kw= 'Target'
                    {
                    kw=(Token)match(input,14,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getTargetKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKEYWORD"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalOvertarget.g:1717:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalOvertarget.g:1717:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalOvertarget.g:1718:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalOvertarget.g:1724:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalOvertarget.g:1730:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalOvertarget.g:1731:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalOvertarget.g:1731:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalOvertarget.g:1732:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalOvertarget.g:1739:3: (kw= '.' this_ID_2= RULE_ID )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==23) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalOvertarget.g:1740:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,23,FOLLOW_3); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_21); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000050C0002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000C0002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000054C07F2000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00007F0000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000054C07C2000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x001FC00000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000054C0702000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0FE0000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00000054C0602000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x00000054C0402000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000008000000030L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000054C0002000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00000004C0002000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000009004010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000004000020L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000008010800002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000001004010L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000001002000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000801002000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000008000000032L});

}