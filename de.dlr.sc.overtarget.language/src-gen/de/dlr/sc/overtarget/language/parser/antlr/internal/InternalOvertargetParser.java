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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'TargetLibrary'", "'{'", "'}'", "'Target'", "'extends'", "'Import'", "'OperatingSystem'", "'WindowingSystem'", "'WorkingSystem'", "'Architecture'", "'Locale'", "'TargetJRE'", "'.'", "'Unit'", "'version'", "'newest'", "';'", "':'", "'+'", "'RepositoryLocation'", "'url'", "'ExcludeLocation'", "'all;'", "'Override'", "'='", "'Variable'", "'-'", "'aix'", "'hpux'", "'linux'", "'macosx'", "'qnx'", "'solaris'", "'win32'", "'carbon'", "'cocoa'", "'gtk'", "'motif'", "'photon'", "'wpf'", "'PA_RISC'", "'ia64'", "'ia64_32'", "'ppc'", "'sparc'", "'x86'", "'x86_64'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
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

                if ( (LA2_0==34||LA2_0==36) ) {
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

                if ( (LA3_0==30) ) {
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
    // InternalOvertarget.g:200:1: ruleTargetModel returns [EObject current=null] : (otherlv_0= 'Target' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'Import' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'OperatingSystem' ( (lv_os_8_0= ruleOperatingSys ) ) )? ( (otherlv_9= 'WindowingSystem' ( (lv_ws_10_0= ruleWindowingSys ) ) ) | (otherlv_11= 'WorkingSystem' ( (lv_wks_12_0= ruleWorkingSys ) ) ) )? (otherlv_13= 'Architecture' ( (lv_arch_14_0= ruleArchitecture ) ) )? (otherlv_15= 'Locale' ( (lv_loc_16_0= ruleLocale ) ) )? (otherlv_17= 'TargetJRE' ( (lv_targetJre_18_0= rulejre ) ) )? ( (lv_variables_19_0= ruleVariableDefinition ) )* ( (lv_excludedLocations_20_0= ruleExcludeLocation ) )* ( (lv_repositoryLocations_21_0= ruleRepositoryLocation ) )* otherlv_22= '}' ) ;
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
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_22=null;
        AntlrDatatypeRuleToken lv_os_8_0 = null;

        AntlrDatatypeRuleToken lv_ws_10_0 = null;

        AntlrDatatypeRuleToken lv_wks_12_0 = null;

        AntlrDatatypeRuleToken lv_arch_14_0 = null;

        AntlrDatatypeRuleToken lv_loc_16_0 = null;

        AntlrDatatypeRuleToken lv_targetJre_18_0 = null;

        EObject lv_variables_19_0 = null;

        EObject lv_excludedLocations_20_0 = null;

        EObject lv_repositoryLocations_21_0 = null;



        	enterRule();

        try {
            // InternalOvertarget.g:206:2: ( (otherlv_0= 'Target' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'Import' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'OperatingSystem' ( (lv_os_8_0= ruleOperatingSys ) ) )? ( (otherlv_9= 'WindowingSystem' ( (lv_ws_10_0= ruleWindowingSys ) ) ) | (otherlv_11= 'WorkingSystem' ( (lv_wks_12_0= ruleWorkingSys ) ) ) )? (otherlv_13= 'Architecture' ( (lv_arch_14_0= ruleArchitecture ) ) )? (otherlv_15= 'Locale' ( (lv_loc_16_0= ruleLocale ) ) )? (otherlv_17= 'TargetJRE' ( (lv_targetJre_18_0= rulejre ) ) )? ( (lv_variables_19_0= ruleVariableDefinition ) )* ( (lv_excludedLocations_20_0= ruleExcludeLocation ) )* ( (lv_repositoryLocations_21_0= ruleRepositoryLocation ) )* otherlv_22= '}' ) )
            // InternalOvertarget.g:207:2: (otherlv_0= 'Target' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'Import' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'OperatingSystem' ( (lv_os_8_0= ruleOperatingSys ) ) )? ( (otherlv_9= 'WindowingSystem' ( (lv_ws_10_0= ruleWindowingSys ) ) ) | (otherlv_11= 'WorkingSystem' ( (lv_wks_12_0= ruleWorkingSys ) ) ) )? (otherlv_13= 'Architecture' ( (lv_arch_14_0= ruleArchitecture ) ) )? (otherlv_15= 'Locale' ( (lv_loc_16_0= ruleLocale ) ) )? (otherlv_17= 'TargetJRE' ( (lv_targetJre_18_0= rulejre ) ) )? ( (lv_variables_19_0= ruleVariableDefinition ) )* ( (lv_excludedLocations_20_0= ruleExcludeLocation ) )* ( (lv_repositoryLocations_21_0= ruleRepositoryLocation ) )* otherlv_22= '}' )
            {
            // InternalOvertarget.g:207:2: (otherlv_0= 'Target' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'Import' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'OperatingSystem' ( (lv_os_8_0= ruleOperatingSys ) ) )? ( (otherlv_9= 'WindowingSystem' ( (lv_ws_10_0= ruleWindowingSys ) ) ) | (otherlv_11= 'WorkingSystem' ( (lv_wks_12_0= ruleWorkingSys ) ) ) )? (otherlv_13= 'Architecture' ( (lv_arch_14_0= ruleArchitecture ) ) )? (otherlv_15= 'Locale' ( (lv_loc_16_0= ruleLocale ) ) )? (otherlv_17= 'TargetJRE' ( (lv_targetJre_18_0= rulejre ) ) )? ( (lv_variables_19_0= ruleVariableDefinition ) )* ( (lv_excludedLocations_20_0= ruleExcludeLocation ) )* ( (lv_repositoryLocations_21_0= ruleRepositoryLocation ) )* otherlv_22= '}' )
            // InternalOvertarget.g:208:3: otherlv_0= 'Target' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' (otherlv_5= 'Import' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'OperatingSystem' ( (lv_os_8_0= ruleOperatingSys ) ) )? ( (otherlv_9= 'WindowingSystem' ( (lv_ws_10_0= ruleWindowingSys ) ) ) | (otherlv_11= 'WorkingSystem' ( (lv_wks_12_0= ruleWorkingSys ) ) ) )? (otherlv_13= 'Architecture' ( (lv_arch_14_0= ruleArchitecture ) ) )? (otherlv_15= 'Locale' ( (lv_loc_16_0= ruleLocale ) ) )? (otherlv_17= 'TargetJRE' ( (lv_targetJre_18_0= rulejre ) ) )? ( (lv_variables_19_0= ruleVariableDefinition ) )* ( (lv_excludedLocations_20_0= ruleExcludeLocation ) )* ( (lv_repositoryLocations_21_0= ruleRepositoryLocation ) )* otherlv_22= '}'
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

            // InternalOvertarget.g:297:3: ( (otherlv_9= 'WindowingSystem' ( (lv_ws_10_0= ruleWindowingSys ) ) ) | (otherlv_11= 'WorkingSystem' ( (lv_wks_12_0= ruleWorkingSys ) ) ) )?
            int alt7=3;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            else if ( (LA7_0==19) ) {
                alt7=2;
            }
            switch (alt7) {
                case 1 :
                    // InternalOvertarget.g:298:4: (otherlv_9= 'WindowingSystem' ( (lv_ws_10_0= ruleWindowingSys ) ) )
                    {
                    // InternalOvertarget.g:298:4: (otherlv_9= 'WindowingSystem' ( (lv_ws_10_0= ruleWindowingSys ) ) )
                    // InternalOvertarget.g:299:5: otherlv_9= 'WindowingSystem' ( (lv_ws_10_0= ruleWindowingSys ) )
                    {
                    otherlv_9=(Token)match(input,18,FOLLOW_11); 

                    					newLeafNode(otherlv_9, grammarAccess.getTargetModelAccess().getWindowingSystemKeyword_6_0_0());
                    				
                    // InternalOvertarget.g:303:5: ( (lv_ws_10_0= ruleWindowingSys ) )
                    // InternalOvertarget.g:304:6: (lv_ws_10_0= ruleWindowingSys )
                    {
                    // InternalOvertarget.g:304:6: (lv_ws_10_0= ruleWindowingSys )
                    // InternalOvertarget.g:305:7: lv_ws_10_0= ruleWindowingSys
                    {

                    							newCompositeNode(grammarAccess.getTargetModelAccess().getWsWindowingSysParserRuleCall_6_0_1_0());
                    						
                    pushFollow(FOLLOW_12);
                    lv_ws_10_0=ruleWindowingSys();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getTargetModelRule());
                    							}
                    							set(
                    								current,
                    								"ws",
                    								lv_ws_10_0,
                    								"de.dlr.sc.overtarget.language.Overtarget.WindowingSys");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalOvertarget.g:324:4: (otherlv_11= 'WorkingSystem' ( (lv_wks_12_0= ruleWorkingSys ) ) )
                    {
                    // InternalOvertarget.g:324:4: (otherlv_11= 'WorkingSystem' ( (lv_wks_12_0= ruleWorkingSys ) ) )
                    // InternalOvertarget.g:325:5: otherlv_11= 'WorkingSystem' ( (lv_wks_12_0= ruleWorkingSys ) )
                    {
                    otherlv_11=(Token)match(input,19,FOLLOW_11); 

                    					newLeafNode(otherlv_11, grammarAccess.getTargetModelAccess().getWorkingSystemKeyword_6_1_0());
                    				
                    // InternalOvertarget.g:329:5: ( (lv_wks_12_0= ruleWorkingSys ) )
                    // InternalOvertarget.g:330:6: (lv_wks_12_0= ruleWorkingSys )
                    {
                    // InternalOvertarget.g:330:6: (lv_wks_12_0= ruleWorkingSys )
                    // InternalOvertarget.g:331:7: lv_wks_12_0= ruleWorkingSys
                    {

                    							newCompositeNode(grammarAccess.getTargetModelAccess().getWksWorkingSysParserRuleCall_6_1_1_0());
                    						
                    pushFollow(FOLLOW_12);
                    lv_wks_12_0=ruleWorkingSys();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getTargetModelRule());
                    							}
                    							set(
                    								current,
                    								"wks",
                    								lv_wks_12_0,
                    								"de.dlr.sc.overtarget.language.Overtarget.WorkingSys");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            // InternalOvertarget.g:350:3: (otherlv_13= 'Architecture' ( (lv_arch_14_0= ruleArchitecture ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalOvertarget.g:351:4: otherlv_13= 'Architecture' ( (lv_arch_14_0= ruleArchitecture ) )
                    {
                    otherlv_13=(Token)match(input,20,FOLLOW_13); 

                    				newLeafNode(otherlv_13, grammarAccess.getTargetModelAccess().getArchitectureKeyword_7_0());
                    			
                    // InternalOvertarget.g:355:4: ( (lv_arch_14_0= ruleArchitecture ) )
                    // InternalOvertarget.g:356:5: (lv_arch_14_0= ruleArchitecture )
                    {
                    // InternalOvertarget.g:356:5: (lv_arch_14_0= ruleArchitecture )
                    // InternalOvertarget.g:357:6: lv_arch_14_0= ruleArchitecture
                    {

                    						newCompositeNode(grammarAccess.getTargetModelAccess().getArchArchitectureParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_arch_14_0=ruleArchitecture();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTargetModelRule());
                    						}
                    						set(
                    							current,
                    							"arch",
                    							lv_arch_14_0,
                    							"de.dlr.sc.overtarget.language.Overtarget.Architecture");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOvertarget.g:375:3: (otherlv_15= 'Locale' ( (lv_loc_16_0= ruleLocale ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalOvertarget.g:376:4: otherlv_15= 'Locale' ( (lv_loc_16_0= ruleLocale ) )
                    {
                    otherlv_15=(Token)match(input,21,FOLLOW_3); 

                    				newLeafNode(otherlv_15, grammarAccess.getTargetModelAccess().getLocaleKeyword_8_0());
                    			
                    // InternalOvertarget.g:380:4: ( (lv_loc_16_0= ruleLocale ) )
                    // InternalOvertarget.g:381:5: (lv_loc_16_0= ruleLocale )
                    {
                    // InternalOvertarget.g:381:5: (lv_loc_16_0= ruleLocale )
                    // InternalOvertarget.g:382:6: lv_loc_16_0= ruleLocale
                    {

                    						newCompositeNode(grammarAccess.getTargetModelAccess().getLocLocaleParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_15);
                    lv_loc_16_0=ruleLocale();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTargetModelRule());
                    						}
                    						set(
                    							current,
                    							"loc",
                    							lv_loc_16_0,
                    							"de.dlr.sc.overtarget.language.Overtarget.Locale");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOvertarget.g:400:3: (otherlv_17= 'TargetJRE' ( (lv_targetJre_18_0= rulejre ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==22) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalOvertarget.g:401:4: otherlv_17= 'TargetJRE' ( (lv_targetJre_18_0= rulejre ) )
                    {
                    otherlv_17=(Token)match(input,22,FOLLOW_16); 

                    				newLeafNode(otherlv_17, grammarAccess.getTargetModelAccess().getTargetJREKeyword_9_0());
                    			
                    // InternalOvertarget.g:405:4: ( (lv_targetJre_18_0= rulejre ) )
                    // InternalOvertarget.g:406:5: (lv_targetJre_18_0= rulejre )
                    {
                    // InternalOvertarget.g:406:5: (lv_targetJre_18_0= rulejre )
                    // InternalOvertarget.g:407:6: lv_targetJre_18_0= rulejre
                    {

                    						newCompositeNode(grammarAccess.getTargetModelAccess().getTargetJreJreParserRuleCall_9_1_0());
                    					
                    pushFollow(FOLLOW_17);
                    lv_targetJre_18_0=rulejre();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTargetModelRule());
                    						}
                    						set(
                    							current,
                    							"targetJre",
                    							lv_targetJre_18_0,
                    							"de.dlr.sc.overtarget.language.Overtarget.jre");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOvertarget.g:425:3: ( (lv_variables_19_0= ruleVariableDefinition ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==34||LA11_0==36) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalOvertarget.g:426:4: (lv_variables_19_0= ruleVariableDefinition )
            	    {
            	    // InternalOvertarget.g:426:4: (lv_variables_19_0= ruleVariableDefinition )
            	    // InternalOvertarget.g:427:5: lv_variables_19_0= ruleVariableDefinition
            	    {

            	    					newCompositeNode(grammarAccess.getTargetModelAccess().getVariablesVariableDefinitionParserRuleCall_10_0());
            	    				
            	    pushFollow(FOLLOW_17);
            	    lv_variables_19_0=ruleVariableDefinition();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTargetModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"variables",
            	    						lv_variables_19_0,
            	    						"de.dlr.sc.overtarget.language.Overtarget.VariableDefinition");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // InternalOvertarget.g:444:3: ( (lv_excludedLocations_20_0= ruleExcludeLocation ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==32) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalOvertarget.g:445:4: (lv_excludedLocations_20_0= ruleExcludeLocation )
            	    {
            	    // InternalOvertarget.g:445:4: (lv_excludedLocations_20_0= ruleExcludeLocation )
            	    // InternalOvertarget.g:446:5: lv_excludedLocations_20_0= ruleExcludeLocation
            	    {

            	    					newCompositeNode(grammarAccess.getTargetModelAccess().getExcludedLocationsExcludeLocationParserRuleCall_11_0());
            	    				
            	    pushFollow(FOLLOW_18);
            	    lv_excludedLocations_20_0=ruleExcludeLocation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTargetModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"excludedLocations",
            	    						lv_excludedLocations_20_0,
            	    						"de.dlr.sc.overtarget.language.Overtarget.ExcludeLocation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // InternalOvertarget.g:463:3: ( (lv_repositoryLocations_21_0= ruleRepositoryLocation ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==30) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalOvertarget.g:464:4: (lv_repositoryLocations_21_0= ruleRepositoryLocation )
            	    {
            	    // InternalOvertarget.g:464:4: (lv_repositoryLocations_21_0= ruleRepositoryLocation )
            	    // InternalOvertarget.g:465:5: lv_repositoryLocations_21_0= ruleRepositoryLocation
            	    {

            	    					newCompositeNode(grammarAccess.getTargetModelAccess().getRepositoryLocationsRepositoryLocationParserRuleCall_12_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_repositoryLocations_21_0=ruleRepositoryLocation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTargetModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"repositoryLocations",
            	    						lv_repositoryLocations_21_0,
            	    						"de.dlr.sc.overtarget.language.Overtarget.RepositoryLocation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_22=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_22, grammarAccess.getTargetModelAccess().getRightCurlyBracketKeyword_13());
            		

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
    // InternalOvertarget.g:490:1: entryRuleVersion returns [String current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final String entryRuleVersion() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersion = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalOvertarget.g:492:2: (iv_ruleVersion= ruleVersion EOF )
            // InternalOvertarget.g:493:2: iv_ruleVersion= ruleVersion EOF
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
    // InternalOvertarget.g:502:1: ruleVersion returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= '.' this_qualifier_6= rulequalifier )? ) ;
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
            // InternalOvertarget.g:509:2: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= '.' this_qualifier_6= rulequalifier )? ) )
            // InternalOvertarget.g:510:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= '.' this_qualifier_6= rulequalifier )? )
            {
            // InternalOvertarget.g:510:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= '.' this_qualifier_6= rulequalifier )? )
            // InternalOvertarget.g:511:3: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT kw= '.' this_INT_4= RULE_INT (kw= '.' this_qualifier_6= rulequalifier )?
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
            		
            // InternalOvertarget.g:542:3: (kw= '.' this_qualifier_6= rulequalifier )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==23) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalOvertarget.g:543:4: kw= '.' this_qualifier_6= rulequalifier
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
    // InternalOvertarget.g:566:1: entryRuleSimpleVersion returns [String current=null] : iv_ruleSimpleVersion= ruleSimpleVersion EOF ;
    public final String entryRuleSimpleVersion() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSimpleVersion = null;


        try {
            // InternalOvertarget.g:566:53: (iv_ruleSimpleVersion= ruleSimpleVersion EOF )
            // InternalOvertarget.g:567:2: iv_ruleSimpleVersion= ruleSimpleVersion EOF
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
    // InternalOvertarget.g:573:1: ruleSimpleVersion returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ) ;
    public final AntlrDatatypeRuleToken ruleSimpleVersion() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalOvertarget.g:579:2: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ) )
            // InternalOvertarget.g:580:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* )
            {
            // InternalOvertarget.g:580:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* )
            // InternalOvertarget.g:581:3: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )*
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_21); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getSimpleVersionAccess().getINTTerminalRuleCall_0());
            		
            // InternalOvertarget.g:588:3: (kw= '.' this_INT_2= RULE_INT )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==23) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalOvertarget.g:589:4: kw= '.' this_INT_2= RULE_INT
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
            	    break loop15;
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
    // InternalOvertarget.g:606:1: entryRuleUnit returns [EObject current=null] : iv_ruleUnit= ruleUnit EOF ;
    public final EObject entryRuleUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnit = null;


        try {
            // InternalOvertarget.g:606:45: (iv_ruleUnit= ruleUnit EOF )
            // InternalOvertarget.g:607:2: iv_ruleUnit= ruleUnit EOF
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
    // InternalOvertarget.g:613:1: ruleUnit returns [EObject current=null] : (otherlv_0= 'Unit' ( (lv_source_1_0= ruleSource ) ) otherlv_2= 'version' ( ( (lv_vers_3_1= ruleVersion | lv_vers_3_2= 'newest' ) ) ) otherlv_4= ';' ) ;
    public final EObject ruleUnit() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_vers_3_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_source_1_0 = null;

        AntlrDatatypeRuleToken lv_vers_3_1 = null;



        	enterRule();

        try {
            // InternalOvertarget.g:619:2: ( (otherlv_0= 'Unit' ( (lv_source_1_0= ruleSource ) ) otherlv_2= 'version' ( ( (lv_vers_3_1= ruleVersion | lv_vers_3_2= 'newest' ) ) ) otherlv_4= ';' ) )
            // InternalOvertarget.g:620:2: (otherlv_0= 'Unit' ( (lv_source_1_0= ruleSource ) ) otherlv_2= 'version' ( ( (lv_vers_3_1= ruleVersion | lv_vers_3_2= 'newest' ) ) ) otherlv_4= ';' )
            {
            // InternalOvertarget.g:620:2: (otherlv_0= 'Unit' ( (lv_source_1_0= ruleSource ) ) otherlv_2= 'version' ( ( (lv_vers_3_1= ruleVersion | lv_vers_3_2= 'newest' ) ) ) otherlv_4= ';' )
            // InternalOvertarget.g:621:3: otherlv_0= 'Unit' ( (lv_source_1_0= ruleSource ) ) otherlv_2= 'version' ( ( (lv_vers_3_1= ruleVersion | lv_vers_3_2= 'newest' ) ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getUnitAccess().getUnitKeyword_0());
            		
            // InternalOvertarget.g:625:3: ( (lv_source_1_0= ruleSource ) )
            // InternalOvertarget.g:626:4: (lv_source_1_0= ruleSource )
            {
            // InternalOvertarget.g:626:4: (lv_source_1_0= ruleSource )
            // InternalOvertarget.g:627:5: lv_source_1_0= ruleSource
            {

            					newCompositeNode(grammarAccess.getUnitAccess().getSourceSourceParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_24);
            lv_source_1_0=ruleSource();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnitRule());
            					}
            					set(
            						current,
            						"source",
            						lv_source_1_0,
            						"de.dlr.sc.overtarget.language.Overtarget.Source");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_25); 

            			newLeafNode(otherlv_2, grammarAccess.getUnitAccess().getVersionKeyword_2());
            		
            // InternalOvertarget.g:648:3: ( ( (lv_vers_3_1= ruleVersion | lv_vers_3_2= 'newest' ) ) )
            // InternalOvertarget.g:649:4: ( (lv_vers_3_1= ruleVersion | lv_vers_3_2= 'newest' ) )
            {
            // InternalOvertarget.g:649:4: ( (lv_vers_3_1= ruleVersion | lv_vers_3_2= 'newest' ) )
            // InternalOvertarget.g:650:5: (lv_vers_3_1= ruleVersion | lv_vers_3_2= 'newest' )
            {
            // InternalOvertarget.g:650:5: (lv_vers_3_1= ruleVersion | lv_vers_3_2= 'newest' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_INT) ) {
                alt16=1;
            }
            else if ( (LA16_0==26) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalOvertarget.g:651:6: lv_vers_3_1= ruleVersion
                    {

                    						newCompositeNode(grammarAccess.getUnitAccess().getVersVersionParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_26);
                    lv_vers_3_1=ruleVersion();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getUnitRule());
                    						}
                    						set(
                    							current,
                    							"vers",
                    							lv_vers_3_1,
                    							"de.dlr.sc.overtarget.language.Overtarget.Version");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 2 :
                    // InternalOvertarget.g:667:6: lv_vers_3_2= 'newest'
                    {
                    lv_vers_3_2=(Token)match(input,26,FOLLOW_26); 

                    						newLeafNode(lv_vers_3_2, grammarAccess.getUnitAccess().getVersNewestKeyword_3_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getUnitRule());
                    						}
                    						setWithLastConsumed(current, "vers", lv_vers_3_2, null);
                    					

                    }
                    break;

            }


            }


            }

            otherlv_4=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getUnitAccess().getSemicolonKeyword_4());
            		

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
    // InternalOvertarget.g:688:1: entryRuleSource returns [String current=null] : iv_ruleSource= ruleSource EOF ;
    public final String entryRuleSource() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSource = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalOvertarget.g:690:2: (iv_ruleSource= ruleSource EOF )
            // InternalOvertarget.g:691:2: iv_ruleSource= ruleSource EOF
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
    // InternalOvertarget.g:700:1: ruleSource returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID ( (this_dot_1= ruledot this_ValidID_2= ruleValidID ) | (this_hypen_3= rulehypen this_ValidID_4= ruleValidID ) )* (kw= ':' )? ) ;
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
            // InternalOvertarget.g:707:2: ( (this_ValidID_0= ruleValidID ( (this_dot_1= ruledot this_ValidID_2= ruleValidID ) | (this_hypen_3= rulehypen this_ValidID_4= ruleValidID ) )* (kw= ':' )? ) )
            // InternalOvertarget.g:708:2: (this_ValidID_0= ruleValidID ( (this_dot_1= ruledot this_ValidID_2= ruleValidID ) | (this_hypen_3= rulehypen this_ValidID_4= ruleValidID ) )* (kw= ':' )? )
            {
            // InternalOvertarget.g:708:2: (this_ValidID_0= ruleValidID ( (this_dot_1= ruledot this_ValidID_2= ruleValidID ) | (this_hypen_3= rulehypen this_ValidID_4= ruleValidID ) )* (kw= ':' )? )
            // InternalOvertarget.g:709:3: this_ValidID_0= ruleValidID ( (this_dot_1= ruledot this_ValidID_2= ruleValidID ) | (this_hypen_3= rulehypen this_ValidID_4= ruleValidID ) )* (kw= ':' )?
            {

            			newCompositeNode(grammarAccess.getSourceAccess().getValidIDParserRuleCall_0());
            		
            pushFollow(FOLLOW_27);
            this_ValidID_0=ruleValidID();

            state._fsp--;


            			current.merge(this_ValidID_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalOvertarget.g:719:3: ( (this_dot_1= ruledot this_ValidID_2= ruleValidID ) | (this_hypen_3= rulehypen this_ValidID_4= ruleValidID ) )*
            loop17:
            do {
                int alt17=3;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==23) ) {
                    alt17=1;
                }
                else if ( (LA17_0==37) ) {
                    alt17=2;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalOvertarget.g:720:4: (this_dot_1= ruledot this_ValidID_2= ruleValidID )
            	    {
            	    // InternalOvertarget.g:720:4: (this_dot_1= ruledot this_ValidID_2= ruleValidID )
            	    // InternalOvertarget.g:721:5: this_dot_1= ruledot this_ValidID_2= ruleValidID
            	    {

            	    					newCompositeNode(grammarAccess.getSourceAccess().getDotParserRuleCall_1_0_0());
            	    				
            	    pushFollow(FOLLOW_23);
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
            	    // InternalOvertarget.g:743:4: (this_hypen_3= rulehypen this_ValidID_4= ruleValidID )
            	    {
            	    // InternalOvertarget.g:743:4: (this_hypen_3= rulehypen this_ValidID_4= ruleValidID )
            	    // InternalOvertarget.g:744:5: this_hypen_3= rulehypen this_ValidID_4= ruleValidID
            	    {

            	    					newCompositeNode(grammarAccess.getSourceAccess().getHypenParserRuleCall_1_1_0());
            	    				
            	    pushFollow(FOLLOW_23);
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
            	    break loop17;
                }
            } while (true);

            // InternalOvertarget.g:766:3: (kw= ':' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==28) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalOvertarget.g:767:4: kw= ':'
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
    // InternalOvertarget.g:780:1: entryRuleUrlExpression returns [EObject current=null] : iv_ruleUrlExpression= ruleUrlExpression EOF ;
    public final EObject entryRuleUrlExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUrlExpression = null;


        try {
            // InternalOvertarget.g:780:54: (iv_ruleUrlExpression= ruleUrlExpression EOF )
            // InternalOvertarget.g:781:2: iv_ruleUrlExpression= ruleUrlExpression EOF
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
    // InternalOvertarget.g:787:1: ruleUrlExpression returns [EObject current=null] : (this_UrlElement_0= ruleUrlElement ( () otherlv_2= '+' ( (lv_right_3_0= ruleUrlElement ) ) )* ) ;
    public final EObject ruleUrlExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_UrlElement_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalOvertarget.g:793:2: ( (this_UrlElement_0= ruleUrlElement ( () otherlv_2= '+' ( (lv_right_3_0= ruleUrlElement ) ) )* ) )
            // InternalOvertarget.g:794:2: (this_UrlElement_0= ruleUrlElement ( () otherlv_2= '+' ( (lv_right_3_0= ruleUrlElement ) ) )* )
            {
            // InternalOvertarget.g:794:2: (this_UrlElement_0= ruleUrlElement ( () otherlv_2= '+' ( (lv_right_3_0= ruleUrlElement ) ) )* )
            // InternalOvertarget.g:795:3: this_UrlElement_0= ruleUrlElement ( () otherlv_2= '+' ( (lv_right_3_0= ruleUrlElement ) ) )*
            {

            			newCompositeNode(grammarAccess.getUrlExpressionAccess().getUrlElementParserRuleCall_0());
            		
            pushFollow(FOLLOW_28);
            this_UrlElement_0=ruleUrlElement();

            state._fsp--;


            			current = this_UrlElement_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalOvertarget.g:803:3: ( () otherlv_2= '+' ( (lv_right_3_0= ruleUrlElement ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==29) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalOvertarget.g:804:4: () otherlv_2= '+' ( (lv_right_3_0= ruleUrlElement ) )
            	    {
            	    // InternalOvertarget.g:804:4: ()
            	    // InternalOvertarget.g:805:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getUrlExpressionAccess().getUrlExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,29,FOLLOW_29); 

            	    				newLeafNode(otherlv_2, grammarAccess.getUrlExpressionAccess().getPlusSignKeyword_1_1());
            	    			
            	    // InternalOvertarget.g:815:4: ( (lv_right_3_0= ruleUrlElement ) )
            	    // InternalOvertarget.g:816:5: (lv_right_3_0= ruleUrlElement )
            	    {
            	    // InternalOvertarget.g:816:5: (lv_right_3_0= ruleUrlElement )
            	    // InternalOvertarget.g:817:6: lv_right_3_0= ruleUrlElement
            	    {

            	    						newCompositeNode(grammarAccess.getUrlExpressionAccess().getRightUrlElementParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_28);
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
            	    break loop19;
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
    // InternalOvertarget.g:839:1: entryRuleUrlElement returns [EObject current=null] : iv_ruleUrlElement= ruleUrlElement EOF ;
    public final EObject entryRuleUrlElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUrlElement = null;


        try {
            // InternalOvertarget.g:839:51: (iv_ruleUrlElement= ruleUrlElement EOF )
            // InternalOvertarget.g:840:2: iv_ruleUrlElement= ruleUrlElement EOF
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
    // InternalOvertarget.g:846:1: ruleUrlElement returns [EObject current=null] : (this_UrlElementVariable_0= ruleUrlElementVariable | this_UrlElementString_1= ruleUrlElementString ) ;
    public final EObject ruleUrlElement() throws RecognitionException {
        EObject current = null;

        EObject this_UrlElementVariable_0 = null;

        EObject this_UrlElementString_1 = null;



        	enterRule();

        try {
            // InternalOvertarget.g:852:2: ( (this_UrlElementVariable_0= ruleUrlElementVariable | this_UrlElementString_1= ruleUrlElementString ) )
            // InternalOvertarget.g:853:2: (this_UrlElementVariable_0= ruleUrlElementVariable | this_UrlElementString_1= ruleUrlElementString )
            {
            // InternalOvertarget.g:853:2: (this_UrlElementVariable_0= ruleUrlElementVariable | this_UrlElementString_1= ruleUrlElementString )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                alt20=1;
            }
            else if ( (LA20_0==RULE_STRING) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalOvertarget.g:854:3: this_UrlElementVariable_0= ruleUrlElementVariable
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
                    // InternalOvertarget.g:863:3: this_UrlElementString_1= ruleUrlElementString
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
    // InternalOvertarget.g:875:1: entryRuleUrlElementString returns [EObject current=null] : iv_ruleUrlElementString= ruleUrlElementString EOF ;
    public final EObject entryRuleUrlElementString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUrlElementString = null;


        try {
            // InternalOvertarget.g:875:57: (iv_ruleUrlElementString= ruleUrlElementString EOF )
            // InternalOvertarget.g:876:2: iv_ruleUrlElementString= ruleUrlElementString EOF
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
    // InternalOvertarget.g:882:1: ruleUrlElementString returns [EObject current=null] : ( (lv_content_0_0= RULE_STRING ) ) ;
    public final EObject ruleUrlElementString() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;


        	enterRule();

        try {
            // InternalOvertarget.g:888:2: ( ( (lv_content_0_0= RULE_STRING ) ) )
            // InternalOvertarget.g:889:2: ( (lv_content_0_0= RULE_STRING ) )
            {
            // InternalOvertarget.g:889:2: ( (lv_content_0_0= RULE_STRING ) )
            // InternalOvertarget.g:890:3: (lv_content_0_0= RULE_STRING )
            {
            // InternalOvertarget.g:890:3: (lv_content_0_0= RULE_STRING )
            // InternalOvertarget.g:891:4: lv_content_0_0= RULE_STRING
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
    // InternalOvertarget.g:910:1: entryRuleUrlElementVariable returns [EObject current=null] : iv_ruleUrlElementVariable= ruleUrlElementVariable EOF ;
    public final EObject entryRuleUrlElementVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUrlElementVariable = null;


        try {
            // InternalOvertarget.g:910:59: (iv_ruleUrlElementVariable= ruleUrlElementVariable EOF )
            // InternalOvertarget.g:911:2: iv_ruleUrlElementVariable= ruleUrlElementVariable EOF
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
    // InternalOvertarget.g:917:1: ruleUrlElementVariable returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleUrlElementVariable() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalOvertarget.g:923:2: ( ( ( ruleQualifiedName ) ) )
            // InternalOvertarget.g:924:2: ( ( ruleQualifiedName ) )
            {
            // InternalOvertarget.g:924:2: ( ( ruleQualifiedName ) )
            // InternalOvertarget.g:925:3: ( ruleQualifiedName )
            {
            // InternalOvertarget.g:925:3: ( ruleQualifiedName )
            // InternalOvertarget.g:926:4: ruleQualifiedName
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
    // InternalOvertarget.g:943:1: entryRuleRepositoryLocation returns [EObject current=null] : iv_ruleRepositoryLocation= ruleRepositoryLocation EOF ;
    public final EObject entryRuleRepositoryLocation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRepositoryLocation = null;


        try {
            // InternalOvertarget.g:943:59: (iv_ruleRepositoryLocation= ruleRepositoryLocation EOF )
            // InternalOvertarget.g:944:2: iv_ruleRepositoryLocation= ruleRepositoryLocation EOF
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
    // InternalOvertarget.g:950:1: ruleRepositoryLocation returns [EObject current=null] : (otherlv_0= 'RepositoryLocation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'url' ( (lv_url_3_0= ruleUrlExpression ) ) otherlv_4= '{' ( (lv_units_5_0= ruleUnit ) )* otherlv_6= '}' ) ;
    public final EObject ruleRepositoryLocation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_url_3_0 = null;

        EObject lv_units_5_0 = null;



        	enterRule();

        try {
            // InternalOvertarget.g:956:2: ( (otherlv_0= 'RepositoryLocation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'url' ( (lv_url_3_0= ruleUrlExpression ) ) otherlv_4= '{' ( (lv_units_5_0= ruleUnit ) )* otherlv_6= '}' ) )
            // InternalOvertarget.g:957:2: (otherlv_0= 'RepositoryLocation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'url' ( (lv_url_3_0= ruleUrlExpression ) ) otherlv_4= '{' ( (lv_units_5_0= ruleUnit ) )* otherlv_6= '}' )
            {
            // InternalOvertarget.g:957:2: (otherlv_0= 'RepositoryLocation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'url' ( (lv_url_3_0= ruleUrlExpression ) ) otherlv_4= '{' ( (lv_units_5_0= ruleUnit ) )* otherlv_6= '}' )
            // InternalOvertarget.g:958:3: otherlv_0= 'RepositoryLocation' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'url' ( (lv_url_3_0= ruleUrlExpression ) ) otherlv_4= '{' ( (lv_units_5_0= ruleUnit ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getRepositoryLocationAccess().getRepositoryLocationKeyword_0());
            		
            // InternalOvertarget.g:962:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOvertarget.g:963:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOvertarget.g:963:4: (lv_name_1_0= RULE_ID )
            // InternalOvertarget.g:964:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(lv_name_1_0, grammarAccess.getRepositoryLocationAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRepositoryLocationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,31,FOLLOW_29); 

            			newLeafNode(otherlv_2, grammarAccess.getRepositoryLocationAccess().getUrlKeyword_2());
            		
            // InternalOvertarget.g:984:3: ( (lv_url_3_0= ruleUrlExpression ) )
            // InternalOvertarget.g:985:4: (lv_url_3_0= ruleUrlExpression )
            {
            // InternalOvertarget.g:985:4: (lv_url_3_0= ruleUrlExpression )
            // InternalOvertarget.g:986:5: lv_url_3_0= ruleUrlExpression
            {

            					newCompositeNode(grammarAccess.getRepositoryLocationAccess().getUrlUrlExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_4);
            lv_url_3_0=ruleUrlExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRepositoryLocationRule());
            					}
            					set(
            						current,
            						"url",
            						lv_url_3_0,
            						"de.dlr.sc.overtarget.language.Overtarget.UrlExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_31); 

            			newLeafNode(otherlv_4, grammarAccess.getRepositoryLocationAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalOvertarget.g:1007:3: ( (lv_units_5_0= ruleUnit ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==24) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalOvertarget.g:1008:4: (lv_units_5_0= ruleUnit )
            	    {
            	    // InternalOvertarget.g:1008:4: (lv_units_5_0= ruleUnit )
            	    // InternalOvertarget.g:1009:5: lv_units_5_0= ruleUnit
            	    {

            	    					newCompositeNode(grammarAccess.getRepositoryLocationAccess().getUnitsUnitParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_31);
            	    lv_units_5_0=ruleUnit();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRepositoryLocationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"units",
            	    						lv_units_5_0,
            	    						"de.dlr.sc.overtarget.language.Overtarget.Unit");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            otherlv_6=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getRepositoryLocationAccess().getRightCurlyBracketKeyword_6());
            		

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
    // InternalOvertarget.g:1034:1: entryRuleExcludeLocation returns [EObject current=null] : iv_ruleExcludeLocation= ruleExcludeLocation EOF ;
    public final EObject entryRuleExcludeLocation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExcludeLocation = null;


        try {
            // InternalOvertarget.g:1034:56: (iv_ruleExcludeLocation= ruleExcludeLocation EOF )
            // InternalOvertarget.g:1035:2: iv_ruleExcludeLocation= ruleExcludeLocation EOF
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
    // InternalOvertarget.g:1041:1: ruleExcludeLocation returns [EObject current=null] : ( () otherlv_1= 'ExcludeLocation' ( ( ruleQualifiedName ) ) otherlv_3= '{' ( ( (lv_units_4_0= ruleUnit ) )* | otherlv_5= 'all;' ) otherlv_6= '}' ) ;
    public final EObject ruleExcludeLocation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_units_4_0 = null;



        	enterRule();

        try {
            // InternalOvertarget.g:1047:2: ( ( () otherlv_1= 'ExcludeLocation' ( ( ruleQualifiedName ) ) otherlv_3= '{' ( ( (lv_units_4_0= ruleUnit ) )* | otherlv_5= 'all;' ) otherlv_6= '}' ) )
            // InternalOvertarget.g:1048:2: ( () otherlv_1= 'ExcludeLocation' ( ( ruleQualifiedName ) ) otherlv_3= '{' ( ( (lv_units_4_0= ruleUnit ) )* | otherlv_5= 'all;' ) otherlv_6= '}' )
            {
            // InternalOvertarget.g:1048:2: ( () otherlv_1= 'ExcludeLocation' ( ( ruleQualifiedName ) ) otherlv_3= '{' ( ( (lv_units_4_0= ruleUnit ) )* | otherlv_5= 'all;' ) otherlv_6= '}' )
            // InternalOvertarget.g:1049:3: () otherlv_1= 'ExcludeLocation' ( ( ruleQualifiedName ) ) otherlv_3= '{' ( ( (lv_units_4_0= ruleUnit ) )* | otherlv_5= 'all;' ) otherlv_6= '}'
            {
            // InternalOvertarget.g:1049:3: ()
            // InternalOvertarget.g:1050:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExcludeLocationAccess().getExcludeLocationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getExcludeLocationAccess().getExcludeLocationKeyword_1());
            		
            // InternalOvertarget.g:1060:3: ( ( ruleQualifiedName ) )
            // InternalOvertarget.g:1061:4: ( ruleQualifiedName )
            {
            // InternalOvertarget.g:1061:4: ( ruleQualifiedName )
            // InternalOvertarget.g:1062:5: ruleQualifiedName
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

            otherlv_3=(Token)match(input,12,FOLLOW_32); 

            			newLeafNode(otherlv_3, grammarAccess.getExcludeLocationAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOvertarget.g:1080:3: ( ( (lv_units_4_0= ruleUnit ) )* | otherlv_5= 'all;' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==13||LA23_0==24) ) {
                alt23=1;
            }
            else if ( (LA23_0==33) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalOvertarget.g:1081:4: ( (lv_units_4_0= ruleUnit ) )*
                    {
                    // InternalOvertarget.g:1081:4: ( (lv_units_4_0= ruleUnit ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==24) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalOvertarget.g:1082:5: (lv_units_4_0= ruleUnit )
                    	    {
                    	    // InternalOvertarget.g:1082:5: (lv_units_4_0= ruleUnit )
                    	    // InternalOvertarget.g:1083:6: lv_units_4_0= ruleUnit
                    	    {

                    	    						newCompositeNode(grammarAccess.getExcludeLocationAccess().getUnitsUnitParserRuleCall_4_0_0());
                    	    					
                    	    pushFollow(FOLLOW_31);
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
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalOvertarget.g:1101:4: otherlv_5= 'all;'
                    {
                    otherlv_5=(Token)match(input,33,FOLLOW_33); 

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
    // InternalOvertarget.g:1114:1: entryRuleVariableDefinition returns [EObject current=null] : iv_ruleVariableDefinition= ruleVariableDefinition EOF ;
    public final EObject entryRuleVariableDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDefinition = null;


        try {
            // InternalOvertarget.g:1114:59: (iv_ruleVariableDefinition= ruleVariableDefinition EOF )
            // InternalOvertarget.g:1115:2: iv_ruleVariableDefinition= ruleVariableDefinition EOF
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
    // InternalOvertarget.g:1121:1: ruleVariableDefinition returns [EObject current=null] : (this_AlreadyDeclaredVariable_0= ruleAlreadyDeclaredVariable | this_NewVariableDefinition_1= ruleNewVariableDefinition ) ;
    public final EObject ruleVariableDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_AlreadyDeclaredVariable_0 = null;

        EObject this_NewVariableDefinition_1 = null;



        	enterRule();

        try {
            // InternalOvertarget.g:1127:2: ( (this_AlreadyDeclaredVariable_0= ruleAlreadyDeclaredVariable | this_NewVariableDefinition_1= ruleNewVariableDefinition ) )
            // InternalOvertarget.g:1128:2: (this_AlreadyDeclaredVariable_0= ruleAlreadyDeclaredVariable | this_NewVariableDefinition_1= ruleNewVariableDefinition )
            {
            // InternalOvertarget.g:1128:2: (this_AlreadyDeclaredVariable_0= ruleAlreadyDeclaredVariable | this_NewVariableDefinition_1= ruleNewVariableDefinition )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==34) ) {
                alt24=1;
            }
            else if ( (LA24_0==36) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalOvertarget.g:1129:3: this_AlreadyDeclaredVariable_0= ruleAlreadyDeclaredVariable
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
                    // InternalOvertarget.g:1138:3: this_NewVariableDefinition_1= ruleNewVariableDefinition
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
    // InternalOvertarget.g:1150:1: entryRuleAlreadyDeclaredVariable returns [EObject current=null] : iv_ruleAlreadyDeclaredVariable= ruleAlreadyDeclaredVariable EOF ;
    public final EObject entryRuleAlreadyDeclaredVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlreadyDeclaredVariable = null;


        try {
            // InternalOvertarget.g:1150:64: (iv_ruleAlreadyDeclaredVariable= ruleAlreadyDeclaredVariable EOF )
            // InternalOvertarget.g:1151:2: iv_ruleAlreadyDeclaredVariable= ruleAlreadyDeclaredVariable EOF
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
    // InternalOvertarget.g:1157:1: ruleAlreadyDeclaredVariable returns [EObject current=null] : (otherlv_0= 'Override' ( ( ruleQualifiedName ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleAlreadyDeclaredVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;


        	enterRule();

        try {
            // InternalOvertarget.g:1163:2: ( (otherlv_0= 'Override' ( ( ruleQualifiedName ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) ) )
            // InternalOvertarget.g:1164:2: (otherlv_0= 'Override' ( ( ruleQualifiedName ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )
            {
            // InternalOvertarget.g:1164:2: (otherlv_0= 'Override' ( ( ruleQualifiedName ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )
            // InternalOvertarget.g:1165:3: otherlv_0= 'Override' ( ( ruleQualifiedName ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAlreadyDeclaredVariableAccess().getOverrideKeyword_0());
            		
            // InternalOvertarget.g:1169:3: ( ( ruleQualifiedName ) )
            // InternalOvertarget.g:1170:4: ( ruleQualifiedName )
            {
            // InternalOvertarget.g:1170:4: ( ruleQualifiedName )
            // InternalOvertarget.g:1171:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAlreadyDeclaredVariableRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAlreadyDeclaredVariableAccess().getRefNewVariableDefinitionCrossReference_1_0());
            				
            pushFollow(FOLLOW_34);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,35,FOLLOW_35); 

            			newLeafNode(otherlv_2, grammarAccess.getAlreadyDeclaredVariableAccess().getEqualsSignKeyword_2());
            		
            // InternalOvertarget.g:1189:3: ( (lv_value_3_0= RULE_STRING ) )
            // InternalOvertarget.g:1190:4: (lv_value_3_0= RULE_STRING )
            {
            // InternalOvertarget.g:1190:4: (lv_value_3_0= RULE_STRING )
            // InternalOvertarget.g:1191:5: lv_value_3_0= RULE_STRING
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
    // InternalOvertarget.g:1211:1: entryRuleNewVariableDefinition returns [EObject current=null] : iv_ruleNewVariableDefinition= ruleNewVariableDefinition EOF ;
    public final EObject entryRuleNewVariableDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNewVariableDefinition = null;


        try {
            // InternalOvertarget.g:1211:62: (iv_ruleNewVariableDefinition= ruleNewVariableDefinition EOF )
            // InternalOvertarget.g:1212:2: iv_ruleNewVariableDefinition= ruleNewVariableDefinition EOF
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
    // InternalOvertarget.g:1218:1: ruleNewVariableDefinition returns [EObject current=null] : (otherlv_0= 'Variable' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleNewVariableDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;


        	enterRule();

        try {
            // InternalOvertarget.g:1224:2: ( (otherlv_0= 'Variable' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) ) )
            // InternalOvertarget.g:1225:2: (otherlv_0= 'Variable' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )
            {
            // InternalOvertarget.g:1225:2: (otherlv_0= 'Variable' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )
            // InternalOvertarget.g:1226:3: otherlv_0= 'Variable' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getNewVariableDefinitionAccess().getVariableKeyword_0());
            		
            // InternalOvertarget.g:1230:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOvertarget.g:1231:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOvertarget.g:1231:4: (lv_name_1_0= RULE_ID )
            // InternalOvertarget.g:1232:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_34); 

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

            otherlv_2=(Token)match(input,35,FOLLOW_35); 

            			newLeafNode(otherlv_2, grammarAccess.getNewVariableDefinitionAccess().getEqualsSignKeyword_2());
            		
            // InternalOvertarget.g:1252:3: ( (lv_value_3_0= RULE_STRING ) )
            // InternalOvertarget.g:1253:4: (lv_value_3_0= RULE_STRING )
            {
            // InternalOvertarget.g:1253:4: (lv_value_3_0= RULE_STRING )
            // InternalOvertarget.g:1254:5: lv_value_3_0= RULE_STRING
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
    // InternalOvertarget.g:1274:1: entryRulequalifier returns [String current=null] : iv_rulequalifier= rulequalifier EOF ;
    public final String entryRulequalifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulequalifier = null;


        try {
            // InternalOvertarget.g:1274:49: (iv_rulequalifier= rulequalifier EOF )
            // InternalOvertarget.g:1275:2: iv_rulequalifier= rulequalifier EOF
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
    // InternalOvertarget.g:1281:1: rulequalifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_INT_0= RULE_INT | this_ID_1= RULE_ID )+ (kw= '-' (this_INT_3= RULE_INT | this_ID_4= RULE_ID ) )? ) ;
    public final AntlrDatatypeRuleToken rulequalifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_ID_1=null;
        Token kw=null;
        Token this_INT_3=null;
        Token this_ID_4=null;


        	enterRule();

        try {
            // InternalOvertarget.g:1287:2: ( ( (this_INT_0= RULE_INT | this_ID_1= RULE_ID )+ (kw= '-' (this_INT_3= RULE_INT | this_ID_4= RULE_ID ) )? ) )
            // InternalOvertarget.g:1288:2: ( (this_INT_0= RULE_INT | this_ID_1= RULE_ID )+ (kw= '-' (this_INT_3= RULE_INT | this_ID_4= RULE_ID ) )? )
            {
            // InternalOvertarget.g:1288:2: ( (this_INT_0= RULE_INT | this_ID_1= RULE_ID )+ (kw= '-' (this_INT_3= RULE_INT | this_ID_4= RULE_ID ) )? )
            // InternalOvertarget.g:1289:3: (this_INT_0= RULE_INT | this_ID_1= RULE_ID )+ (kw= '-' (this_INT_3= RULE_INT | this_ID_4= RULE_ID ) )?
            {
            // InternalOvertarget.g:1289:3: (this_INT_0= RULE_INT | this_ID_1= RULE_ID )+
            int cnt25=0;
            loop25:
            do {
                int alt25=3;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_INT) ) {
                    alt25=1;
                }
                else if ( (LA25_0==RULE_ID) ) {
                    alt25=2;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalOvertarget.g:1290:4: this_INT_0= RULE_INT
            	    {
            	    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_36); 

            	    				current.merge(this_INT_0);
            	    			

            	    				newLeafNode(this_INT_0, grammarAccess.getQualifierAccess().getINTTerminalRuleCall_0_0());
            	    			

            	    }
            	    break;
            	case 2 :
            	    // InternalOvertarget.g:1298:4: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_36); 

            	    				current.merge(this_ID_1);
            	    			

            	    				newLeafNode(this_ID_1, grammarAccess.getQualifierAccess().getIDTerminalRuleCall_0_1());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);

            // InternalOvertarget.g:1306:3: (kw= '-' (this_INT_3= RULE_INT | this_ID_4= RULE_ID ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==37) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalOvertarget.g:1307:4: kw= '-' (this_INT_3= RULE_INT | this_ID_4= RULE_ID )
                    {
                    kw=(Token)match(input,37,FOLLOW_22); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getQualifierAccess().getHyphenMinusKeyword_1_0());
                    			
                    // InternalOvertarget.g:1312:4: (this_INT_3= RULE_INT | this_ID_4= RULE_ID )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==RULE_INT) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==RULE_ID) ) {
                        alt26=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // InternalOvertarget.g:1313:5: this_INT_3= RULE_INT
                            {
                            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_2); 

                            					current.merge(this_INT_3);
                            				

                            					newLeafNode(this_INT_3, grammarAccess.getQualifierAccess().getINTTerminalRuleCall_1_1_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalOvertarget.g:1321:5: this_ID_4= RULE_ID
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
    // InternalOvertarget.g:1334:1: entryRuleOperatingSys returns [String current=null] : iv_ruleOperatingSys= ruleOperatingSys EOF ;
    public final String entryRuleOperatingSys() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOperatingSys = null;


        try {
            // InternalOvertarget.g:1334:52: (iv_ruleOperatingSys= ruleOperatingSys EOF )
            // InternalOvertarget.g:1335:2: iv_ruleOperatingSys= ruleOperatingSys EOF
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
    // InternalOvertarget.g:1341:1: ruleOperatingSys returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'aix' | kw= 'hpux' | kw= 'linux' | kw= 'macosx' | kw= 'qnx' | kw= 'solaris' | kw= 'win32' ) ;
    public final AntlrDatatypeRuleToken ruleOperatingSys() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalOvertarget.g:1347:2: ( (kw= 'aix' | kw= 'hpux' | kw= 'linux' | kw= 'macosx' | kw= 'qnx' | kw= 'solaris' | kw= 'win32' ) )
            // InternalOvertarget.g:1348:2: (kw= 'aix' | kw= 'hpux' | kw= 'linux' | kw= 'macosx' | kw= 'qnx' | kw= 'solaris' | kw= 'win32' )
            {
            // InternalOvertarget.g:1348:2: (kw= 'aix' | kw= 'hpux' | kw= 'linux' | kw= 'macosx' | kw= 'qnx' | kw= 'solaris' | kw= 'win32' )
            int alt28=7;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt28=1;
                }
                break;
            case 39:
                {
                alt28=2;
                }
                break;
            case 40:
                {
                alt28=3;
                }
                break;
            case 41:
                {
                alt28=4;
                }
                break;
            case 42:
                {
                alt28=5;
                }
                break;
            case 43:
                {
                alt28=6;
                }
                break;
            case 44:
                {
                alt28=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalOvertarget.g:1349:3: kw= 'aix'
                    {
                    kw=(Token)match(input,38,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatingSysAccess().getAixKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOvertarget.g:1355:3: kw= 'hpux'
                    {
                    kw=(Token)match(input,39,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatingSysAccess().getHpuxKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalOvertarget.g:1361:3: kw= 'linux'
                    {
                    kw=(Token)match(input,40,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatingSysAccess().getLinuxKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalOvertarget.g:1367:3: kw= 'macosx'
                    {
                    kw=(Token)match(input,41,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatingSysAccess().getMacosxKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalOvertarget.g:1373:3: kw= 'qnx'
                    {
                    kw=(Token)match(input,42,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatingSysAccess().getQnxKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalOvertarget.g:1379:3: kw= 'solaris'
                    {
                    kw=(Token)match(input,43,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOperatingSysAccess().getSolarisKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalOvertarget.g:1385:3: kw= 'win32'
                    {
                    kw=(Token)match(input,44,FOLLOW_2); 

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
    // InternalOvertarget.g:1394:1: entryRuleWindowingSys returns [String current=null] : iv_ruleWindowingSys= ruleWindowingSys EOF ;
    public final String entryRuleWindowingSys() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleWindowingSys = null;


        try {
            // InternalOvertarget.g:1394:52: (iv_ruleWindowingSys= ruleWindowingSys EOF )
            // InternalOvertarget.g:1395:2: iv_ruleWindowingSys= ruleWindowingSys EOF
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
    // InternalOvertarget.g:1401:1: ruleWindowingSys returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'carbon' | kw= 'cocoa' | kw= 'gtk' | kw= 'motif' | kw= 'photon' | kw= 'wpf' | kw= 'win32' ) ;
    public final AntlrDatatypeRuleToken ruleWindowingSys() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalOvertarget.g:1407:2: ( (kw= 'carbon' | kw= 'cocoa' | kw= 'gtk' | kw= 'motif' | kw= 'photon' | kw= 'wpf' | kw= 'win32' ) )
            // InternalOvertarget.g:1408:2: (kw= 'carbon' | kw= 'cocoa' | kw= 'gtk' | kw= 'motif' | kw= 'photon' | kw= 'wpf' | kw= 'win32' )
            {
            // InternalOvertarget.g:1408:2: (kw= 'carbon' | kw= 'cocoa' | kw= 'gtk' | kw= 'motif' | kw= 'photon' | kw= 'wpf' | kw= 'win32' )
            int alt29=7;
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
            case 48:
                {
                alt29=4;
                }
                break;
            case 49:
                {
                alt29=5;
                }
                break;
            case 50:
                {
                alt29=6;
                }
                break;
            case 44:
                {
                alt29=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // InternalOvertarget.g:1409:3: kw= 'carbon'
                    {
                    kw=(Token)match(input,45,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWindowingSysAccess().getCarbonKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOvertarget.g:1415:3: kw= 'cocoa'
                    {
                    kw=(Token)match(input,46,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWindowingSysAccess().getCocoaKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalOvertarget.g:1421:3: kw= 'gtk'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWindowingSysAccess().getGtkKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalOvertarget.g:1427:3: kw= 'motif'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWindowingSysAccess().getMotifKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalOvertarget.g:1433:3: kw= 'photon'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWindowingSysAccess().getPhotonKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalOvertarget.g:1439:3: kw= 'wpf'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWindowingSysAccess().getWpfKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalOvertarget.g:1445:3: kw= 'win32'
                    {
                    kw=(Token)match(input,44,FOLLOW_2); 

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


    // $ANTLR start "entryRuleWorkingSys"
    // InternalOvertarget.g:1454:1: entryRuleWorkingSys returns [String current=null] : iv_ruleWorkingSys= ruleWorkingSys EOF ;
    public final String entryRuleWorkingSys() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleWorkingSys = null;


        try {
            // InternalOvertarget.g:1454:50: (iv_ruleWorkingSys= ruleWorkingSys EOF )
            // InternalOvertarget.g:1455:2: iv_ruleWorkingSys= ruleWorkingSys EOF
            {
             newCompositeNode(grammarAccess.getWorkingSysRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWorkingSys=ruleWorkingSys();

            state._fsp--;

             current =iv_ruleWorkingSys.getText(); 
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
    // $ANTLR end "entryRuleWorkingSys"


    // $ANTLR start "ruleWorkingSys"
    // InternalOvertarget.g:1461:1: ruleWorkingSys returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'carbon' | kw= 'cocoa' | kw= 'gtk' | kw= 'motif' | kw= 'photon' | kw= 'wpf' | kw= 'win32' ) ;
    public final AntlrDatatypeRuleToken ruleWorkingSys() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalOvertarget.g:1467:2: ( (kw= 'carbon' | kw= 'cocoa' | kw= 'gtk' | kw= 'motif' | kw= 'photon' | kw= 'wpf' | kw= 'win32' ) )
            // InternalOvertarget.g:1468:2: (kw= 'carbon' | kw= 'cocoa' | kw= 'gtk' | kw= 'motif' | kw= 'photon' | kw= 'wpf' | kw= 'win32' )
            {
            // InternalOvertarget.g:1468:2: (kw= 'carbon' | kw= 'cocoa' | kw= 'gtk' | kw= 'motif' | kw= 'photon' | kw= 'wpf' | kw= 'win32' )
            int alt30=7;
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
            case 48:
                {
                alt30=4;
                }
                break;
            case 49:
                {
                alt30=5;
                }
                break;
            case 50:
                {
                alt30=6;
                }
                break;
            case 44:
                {
                alt30=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalOvertarget.g:1469:3: kw= 'carbon'
                    {
                    kw=(Token)match(input,45,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWorkingSysAccess().getCarbonKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOvertarget.g:1475:3: kw= 'cocoa'
                    {
                    kw=(Token)match(input,46,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWorkingSysAccess().getCocoaKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalOvertarget.g:1481:3: kw= 'gtk'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWorkingSysAccess().getGtkKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalOvertarget.g:1487:3: kw= 'motif'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWorkingSysAccess().getMotifKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalOvertarget.g:1493:3: kw= 'photon'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWorkingSysAccess().getPhotonKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalOvertarget.g:1499:3: kw= 'wpf'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWorkingSysAccess().getWpfKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalOvertarget.g:1505:3: kw= 'win32'
                    {
                    kw=(Token)match(input,44,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWorkingSysAccess().getWin32Keyword_6());
                    		

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
    // $ANTLR end "ruleWorkingSys"


    // $ANTLR start "entryRuleArchitecture"
    // InternalOvertarget.g:1514:1: entryRuleArchitecture returns [String current=null] : iv_ruleArchitecture= ruleArchitecture EOF ;
    public final String entryRuleArchitecture() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleArchitecture = null;


        try {
            // InternalOvertarget.g:1514:52: (iv_ruleArchitecture= ruleArchitecture EOF )
            // InternalOvertarget.g:1515:2: iv_ruleArchitecture= ruleArchitecture EOF
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
    // InternalOvertarget.g:1521:1: ruleArchitecture returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'PA_RISC' | kw= 'ia64' | kw= 'ia64_32' | kw= 'ppc' | kw= 'sparc' | kw= 'x86' | kw= 'x86_64' ) ;
    public final AntlrDatatypeRuleToken ruleArchitecture() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalOvertarget.g:1527:2: ( (kw= 'PA_RISC' | kw= 'ia64' | kw= 'ia64_32' | kw= 'ppc' | kw= 'sparc' | kw= 'x86' | kw= 'x86_64' ) )
            // InternalOvertarget.g:1528:2: (kw= 'PA_RISC' | kw= 'ia64' | kw= 'ia64_32' | kw= 'ppc' | kw= 'sparc' | kw= 'x86' | kw= 'x86_64' )
            {
            // InternalOvertarget.g:1528:2: (kw= 'PA_RISC' | kw= 'ia64' | kw= 'ia64_32' | kw= 'ppc' | kw= 'sparc' | kw= 'x86' | kw= 'x86_64' )
            int alt31=7;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt31=1;
                }
                break;
            case 52:
                {
                alt31=2;
                }
                break;
            case 53:
                {
                alt31=3;
                }
                break;
            case 54:
                {
                alt31=4;
                }
                break;
            case 55:
                {
                alt31=5;
                }
                break;
            case 56:
                {
                alt31=6;
                }
                break;
            case 57:
                {
                alt31=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalOvertarget.g:1529:3: kw= 'PA_RISC'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getArchitectureAccess().getPA_RISCKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOvertarget.g:1535:3: kw= 'ia64'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getArchitectureAccess().getIa64Keyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalOvertarget.g:1541:3: kw= 'ia64_32'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getArchitectureAccess().getIa64_32Keyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalOvertarget.g:1547:3: kw= 'ppc'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getArchitectureAccess().getPpcKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalOvertarget.g:1553:3: kw= 'sparc'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getArchitectureAccess().getSparcKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalOvertarget.g:1559:3: kw= 'x86'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getArchitectureAccess().getX86Keyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalOvertarget.g:1565:3: kw= 'x86_64'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); 

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
    // InternalOvertarget.g:1574:1: entryRuleLocale returns [String current=null] : iv_ruleLocale= ruleLocale EOF ;
    public final String entryRuleLocale() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLocale = null;


        try {
            // InternalOvertarget.g:1574:46: (iv_ruleLocale= ruleLocale EOF )
            // InternalOvertarget.g:1575:2: iv_ruleLocale= ruleLocale EOF
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
    // InternalOvertarget.g:1581:1: ruleLocale returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleLocale() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalOvertarget.g:1587:2: (this_ID_0= RULE_ID )
            // InternalOvertarget.g:1588:2: this_ID_0= RULE_ID
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
    // InternalOvertarget.g:1598:1: entryRuledot returns [String current=null] : iv_ruledot= ruledot EOF ;
    public final String entryRuledot() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruledot = null;


        try {
            // InternalOvertarget.g:1598:43: (iv_ruledot= ruledot EOF )
            // InternalOvertarget.g:1599:2: iv_ruledot= ruledot EOF
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
    // InternalOvertarget.g:1605:1: ruledot returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '.' ;
    public final AntlrDatatypeRuleToken ruledot() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalOvertarget.g:1611:2: (kw= '.' )
            // InternalOvertarget.g:1612:2: kw= '.'
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
    // InternalOvertarget.g:1620:1: entryRulehypen returns [String current=null] : iv_rulehypen= rulehypen EOF ;
    public final String entryRulehypen() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulehypen = null;


        try {
            // InternalOvertarget.g:1620:45: (iv_rulehypen= rulehypen EOF )
            // InternalOvertarget.g:1621:2: iv_rulehypen= rulehypen EOF
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
    // InternalOvertarget.g:1627:1: rulehypen returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '-' ;
    public final AntlrDatatypeRuleToken rulehypen() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalOvertarget.g:1633:2: (kw= '-' )
            // InternalOvertarget.g:1634:2: kw= '-'
            {
            kw=(Token)match(input,37,FOLLOW_2); 

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
    // InternalOvertarget.g:1642:1: entryRulejre returns [String current=null] : iv_rulejre= rulejre EOF ;
    public final String entryRulejre() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulejre = null;


        try {
            // InternalOvertarget.g:1642:43: (iv_rulejre= rulejre EOF )
            // InternalOvertarget.g:1643:2: iv_rulejre= rulejre EOF
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
    // InternalOvertarget.g:1649:1: rulejre returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= '-' | this_SimpleVersion_2= ruleSimpleVersion )+ ;
    public final AntlrDatatypeRuleToken rulejre() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_SimpleVersion_2 = null;



        	enterRule();

        try {
            // InternalOvertarget.g:1655:2: ( (this_ID_0= RULE_ID | kw= '-' | this_SimpleVersion_2= ruleSimpleVersion )+ )
            // InternalOvertarget.g:1656:2: (this_ID_0= RULE_ID | kw= '-' | this_SimpleVersion_2= ruleSimpleVersion )+
            {
            // InternalOvertarget.g:1656:2: (this_ID_0= RULE_ID | kw= '-' | this_SimpleVersion_2= ruleSimpleVersion )+
            int cnt32=0;
            loop32:
            do {
                int alt32=4;
                switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    alt32=1;
                    }
                    break;
                case 37:
                    {
                    alt32=2;
                    }
                    break;
                case RULE_INT:
                    {
                    alt32=3;
                    }
                    break;

                }

                switch (alt32) {
            	case 1 :
            	    // InternalOvertarget.g:1657:3: this_ID_0= RULE_ID
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_36); 

            	    			current.merge(this_ID_0);
            	    		

            	    			newLeafNode(this_ID_0, grammarAccess.getJreAccess().getIDTerminalRuleCall_0());
            	    		

            	    }
            	    break;
            	case 2 :
            	    // InternalOvertarget.g:1665:3: kw= '-'
            	    {
            	    kw=(Token)match(input,37,FOLLOW_36); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getJreAccess().getHyphenMinusKeyword_1());
            	    		

            	    }
            	    break;
            	case 3 :
            	    // InternalOvertarget.g:1671:3: this_SimpleVersion_2= ruleSimpleVersion
            	    {

            	    			newCompositeNode(grammarAccess.getJreAccess().getSimpleVersionParserRuleCall_2());
            	    		
            	    pushFollow(FOLLOW_36);
            	    this_SimpleVersion_2=ruleSimpleVersion();

            	    state._fsp--;


            	    			current.merge(this_SimpleVersion_2);
            	    		

            	    			afterParserOrEnumRuleCall();
            	    		

            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
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
    // InternalOvertarget.g:1685:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // InternalOvertarget.g:1685:47: (iv_ruleValidID= ruleValidID EOF )
            // InternalOvertarget.g:1686:2: iv_ruleValidID= ruleValidID EOF
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
    // InternalOvertarget.g:1692:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_KEYWORD_1= ruleKEYWORD ) ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        AntlrDatatypeRuleToken this_KEYWORD_1 = null;



        	enterRule();

        try {
            // InternalOvertarget.g:1698:2: ( (this_ID_0= RULE_ID | this_KEYWORD_1= ruleKEYWORD ) )
            // InternalOvertarget.g:1699:2: (this_ID_0= RULE_ID | this_KEYWORD_1= ruleKEYWORD )
            {
            // InternalOvertarget.g:1699:2: (this_ID_0= RULE_ID | this_KEYWORD_1= ruleKEYWORD )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                alt33=1;
            }
            else if ( (LA33_0==14||LA33_0==24) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // InternalOvertarget.g:1700:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOvertarget.g:1708:3: this_KEYWORD_1= ruleKEYWORD
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
    // InternalOvertarget.g:1722:1: entryRuleKEYWORD returns [String current=null] : iv_ruleKEYWORD= ruleKEYWORD EOF ;
    public final String entryRuleKEYWORD() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKEYWORD = null;


        try {
            // InternalOvertarget.g:1722:47: (iv_ruleKEYWORD= ruleKEYWORD EOF )
            // InternalOvertarget.g:1723:2: iv_ruleKEYWORD= ruleKEYWORD EOF
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
    // InternalOvertarget.g:1729:1: ruleKEYWORD returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Unit' | kw= 'Target' ) ;
    public final AntlrDatatypeRuleToken ruleKEYWORD() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalOvertarget.g:1735:2: ( (kw= 'Unit' | kw= 'Target' ) )
            // InternalOvertarget.g:1736:2: (kw= 'Unit' | kw= 'Target' )
            {
            // InternalOvertarget.g:1736:2: (kw= 'Unit' | kw= 'Target' )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==24) ) {
                alt34=1;
            }
            else if ( (LA34_0==14) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalOvertarget.g:1737:3: kw= 'Unit'
                    {
                    kw=(Token)match(input,24,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getUnitKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOvertarget.g:1743:3: kw= 'Target'
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
    // InternalOvertarget.g:1752:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalOvertarget.g:1752:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalOvertarget.g:1753:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalOvertarget.g:1759:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalOvertarget.g:1765:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalOvertarget.g:1766:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalOvertarget.g:1766:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalOvertarget.g:1767:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalOvertarget.g:1774:3: (kw= '.' this_ID_2= RULE_ID )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==23) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalOvertarget.g:1775:4: kw= '.' this_ID_2= RULE_ID
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
            	    break loop35;
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
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000001440002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000040002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000015407F2000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00001FC000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000015407C2000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0007F00000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000001540702000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x03F8000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000001540602000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000001540402000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000002000000030L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000001540002000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000140002000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000001004010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000004000020L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000002010800002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000001002000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000201002000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000002000000032L});

}