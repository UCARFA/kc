/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.budget.rules;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.budget.framework.nonpersonnel.ValidCeRateTypeMaintenanceDocumentRule;
import org.kuali.coeus.common.budget.framework.rate.ValidCeRateType;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.maintenance.MaintenanceRuleTestBase;
import org.kuali.rice.core.api.util.RiceKeyConstants;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.util.ErrorMessage;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.List;
import static org.junit.Assert.*;
public class ValidCeRateTypeMaintenanceDocumentRuleTest extends MaintenanceRuleTestBase {
    private ValidCeRateTypeMaintenanceDocumentRule rule = null;

    @Before
    public void setUp() throws Exception {
        rule = new ValidCeRateTypeMaintenanceDocumentRule();
        GlobalVariables.setUserSession(new UserSession("quickstart"));
    }

    @After
    public void tearDown() throws Exception {
        rule = null;
    }

    @Test
    public void testOK() throws Exception {

        ValidCeRateType validCeRateType = new ValidCeRateType();
        
        validCeRateType.setRateClassCode("10");
        validCeRateType.setRateTypeCode("1");
        validCeRateType.setCostElement("422311");
        MaintenanceDocument validCeRateTypeDocument = newMaintDoc(validCeRateType);
        assertTrue(rule.processCustomRouteDocumentBusinessRules(validCeRateTypeDocument));
        assertTrue(rule.processCustomApproveDocumentBusinessRules(validCeRateTypeDocument));
    }

    /**
     * 
     * This method to test rate type does not exist.
     * @throws Exception
     */
    @Test
    public void testRateTypeNotExist() throws Exception {

        ValidCeRateType validCeRateType = new ValidCeRateType();
        
        validCeRateType.setRateClassCode("10");
        validCeRateType.setRateTypeCode("2");
        validCeRateType.setCostElement("420111");
        MaintenanceDocument validCeRateTypeDocument = newMaintDoc(validCeRateType);
        assertFalse(rule.processCustomRouteDocumentBusinessRules(validCeRateTypeDocument));
        List errors = GlobalVariables.getMessageMap().getMessages("document.newMaintainableObject.rateTypeCode");
        assertTrue(errors.size() == 1);
        ErrorMessage message = (ErrorMessage) errors.get(0);
        assertEquals(message.getErrorKey(), KeyConstants.ERROR_RATE_TYPE_NOT_EXIST);

        // approve will have the same error too.
        assertFalse(rule.processCustomApproveDocumentBusinessRules(validCeRateTypeDocument));
        errors = GlobalVariables.getMessageMap().getMessages("document.newMaintainableObject.rateTypeCode");
        assertTrue(errors.size() == 1);
        message = (ErrorMessage) errors.get(0);
        assertEquals(message.getErrorKey(), KeyConstants.ERROR_RATE_TYPE_NOT_EXIST);

    }

    @Test
    public void testCostElementNotExist() throws Exception {

        ValidCeRateType validCeRateType = new ValidCeRateType();
        
        validCeRateType.setRateClassCode("10");
        validCeRateType.setRateTypeCode("1");
        validCeRateType.setCostElement("1x");
        MaintenanceDocument validCeRateTypeDocument = newMaintDoc(validCeRateType);
        assertFalse(rule.processCustomRouteDocumentBusinessRules(validCeRateTypeDocument));
        List errors = GlobalVariables.getMessageMap().getMessages("document.newMaintainableObject.costElement");
        assertTrue(errors.size() == 1);
        ErrorMessage message = (ErrorMessage) errors.get(0);
        assertEquals(message.getErrorKey(), RiceKeyConstants.ERROR_EXISTENCE);

        // approve will have the same error too.
        assertFalse(rule.processCustomApproveDocumentBusinessRules(validCeRateTypeDocument));
        errors = GlobalVariables.getMessageMap().getMessages("document.newMaintainableObject.costElement");
        assertTrue(errors.size() == 1);
        message = (ErrorMessage) errors.get(0);
        assertEquals(message.getErrorKey(), RiceKeyConstants.ERROR_EXISTENCE);

    }


}
