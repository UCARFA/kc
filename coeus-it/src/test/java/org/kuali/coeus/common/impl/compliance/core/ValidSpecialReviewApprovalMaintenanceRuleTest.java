/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.compliance.core;

import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.framework.compliance.core.ValidSpecialReviewApproval;
import org.kuali.coeus.common.impl.compliance.core.ValidSpecialReviewApprovalMaintenanceRule;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.maintenance.MaintenanceRuleTestBase;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.util.GlobalVariables;
import static org.junit.Assert.*;
public class ValidSpecialReviewApprovalMaintenanceRuleTest extends MaintenanceRuleTestBase {

    private ValidSpecialReviewApprovalMaintenanceRule rule;
    private MaintenanceDocument maintDoc;

    @Before
    public void setUp() throws Exception {
        rule = new ValidSpecialReviewApprovalMaintenanceRule();
        ValidSpecialReviewApproval specialReviewApproval = new ValidSpecialReviewApproval();
        maintDoc = newMaintDoc(specialReviewApproval);
    }
    
    /** Tests with an invalid Approval Type code and a valid Special Review Code */
    @Test
    public void testInvalidApprovalCode() throws Exception {
        ValidSpecialReviewApproval specialReviewApproval = (ValidSpecialReviewApproval)maintDoc.getDocumentBusinessObject();
        specialReviewApproval.setApprovalTypeCode("-9999");
        specialReviewApproval.setSpecialReviewTypeCode("1");
        boolean valid = rule.processCustomRouteDocumentBusinessRules(maintDoc);
        assertFalse(valid);
        assertEquals(1, GlobalVariables.getMessageMap().getErrorCount());
        assertEquals(1, GlobalVariables.getMessageMap().getErrorMessagesForProperty(Constants.VALID_SPECIAL_REVIEW_APPROVAL_TYPE_CODE_KEY).size());
    }
    
    /** Tests with a valid Approval Type code and a valid Special Review Code */
    @Test
    public void testBothValid() throws Exception {
        ValidSpecialReviewApproval specialReviewApproval = (ValidSpecialReviewApproval)maintDoc.getDocumentBusinessObject();
        specialReviewApproval.setApprovalTypeCode("4");
        specialReviewApproval.setSpecialReviewTypeCode("1");
        boolean valid = rule.processCustomRouteDocumentBusinessRules(maintDoc);
        assertTrue(valid);
        assertEquals(0, GlobalVariables.getMessageMap().getErrorCount());
    }
}
