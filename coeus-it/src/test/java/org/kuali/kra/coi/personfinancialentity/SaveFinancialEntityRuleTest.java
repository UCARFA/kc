/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.personfinancialentity;

import org.junit.Test;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.rules.TemplateRuleTest;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;

public class SaveFinancialEntityRuleTest extends KcIntegrationTestBase {
// "extends KcIntegrationTestBase" to force it to load the configuration
// can't override getBusinessObjectService, which is final, of rule class
    @Test
    public void testSaveFinancialSponsorCodeOK() {
        new TemplateRuleTest<SaveFinancialEntityEvent, SaveFinancialEntityRule>() {
            @Override
            protected void prerequisite() {
                PersonFinIntDisclosure personFinIntDisclosure = new PersonFinIntDisclosure();
                personFinIntDisclosure.setSponsorCode("005770");
                event = new SaveFinancialEntityEvent(Constants.EMPTY_STRING, personFinIntDisclosure);
                 rule = new SaveFinancialEntityRule();
                expectedReturnValue = true;
            }
        };
    }

    @Test
    public void testInvalidSponsorCode() {
        new TemplateRuleTest<SaveFinancialEntityEvent, SaveFinancialEntityRule>() {
            @Override
            protected void prerequisite() {
                PersonFinIntDisclosure personFinIntDisclosure = new PersonFinIntDisclosure();
                personFinIntDisclosure.setSponsorCode("abc");
                event = new SaveFinancialEntityEvent(Constants.EMPTY_STRING, personFinIntDisclosure);
                rule = new SaveFinancialEntityRule();
                expectedReturnValue = false;
            }
        };
    }

}
