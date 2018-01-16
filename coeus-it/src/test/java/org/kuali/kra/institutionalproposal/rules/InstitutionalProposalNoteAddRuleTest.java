/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.rules;

import org.junit.Before;
import org.junit.Test;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposalNotepad;
import org.kuali.kra.institutionalproposal.rules.InstitutionalProposalNoteEventBase.ErrorType;
import org.kuali.kra.rules.TemplateRuleTest;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.util.GlobalVariables;

public class InstitutionalProposalNoteAddRuleTest extends KcIntegrationTestBase {

    @Before
    public void setUp() {
        GlobalVariables.setUserSession(new UserSession("quickstart"));
    }
    
    @Test
    public void testOK() {
        new TemplateRuleTest<InstitutionalProposalNoteAddEvent, InstitutionalProposalNoteAddRule>() {
            @Override
            protected void prerequisite() {

                InstitutionalProposalNotepad institutionalProposalNotepad = new InstitutionalProposalNotepad();
                institutionalProposalNotepad.setNoteTopic("test");
                institutionalProposalNotepad.setComments("test");
                event = new InstitutionalProposalNoteAddEvent(Constants.EMPTY_STRING, null, institutionalProposalNotepad, ErrorType.HARDERROR);
                rule = new InstitutionalProposalNoteAddRule();
                expectedReturnValue = true;
            }
        };


    }

    @Test
    public void testNoNoteTopic() {
        new TemplateRuleTest<InstitutionalProposalNoteAddEvent, InstitutionalProposalNoteAddRule>() {
            @Override
            protected void prerequisite() {

                InstitutionalProposalNotepad institutionalProposalNotepad = new InstitutionalProposalNotepad();
                institutionalProposalNotepad.setNoteTopic("");
                institutionalProposalNotepad.setComments("test");
                event = new InstitutionalProposalNoteAddEvent(Constants.EMPTY_STRING, null, institutionalProposalNotepad, ErrorType.HARDERROR);
                rule = new InstitutionalProposalNoteAddRule();
                expectedReturnValue = false;
            }
        };


    }

    @Test
    public void testNoNoteText() {
        new TemplateRuleTest<InstitutionalProposalNoteAddEvent, InstitutionalProposalNoteAddRule>() {
            @Override
            protected void prerequisite() {

                InstitutionalProposalNotepad institutionalProposalNotepad = new InstitutionalProposalNotepad();
                institutionalProposalNotepad.setNoteTopic("Test");
                institutionalProposalNotepad.setComments("");
                event = new InstitutionalProposalNoteAddEvent(Constants.EMPTY_STRING, null, institutionalProposalNotepad, ErrorType.HARDERROR);
                rule = new InstitutionalProposalNoteAddRule();
                expectedReturnValue = false;
            }
        };


    }

}
