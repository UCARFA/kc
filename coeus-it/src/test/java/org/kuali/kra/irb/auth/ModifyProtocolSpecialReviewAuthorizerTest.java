/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.auth;

import org.junit.Test;
import org.kuali.kra.infrastructure.TaskName;
import org.kuali.kra.irb.actions.amendrenew.ProtocolModule;

/**
 * Test the Modify Protocol Special Review Authorizer.
 */
public class ModifyProtocolSpecialReviewAuthorizerTest extends ModifyProtocolModuleAuthorizerTestBase {
    
    @Test
    public void testHasProtocolPermission() throws Exception {
        runModifyProtocolTest(PROTOCOL_NUMBER, true, true);
    }

    @Test
    public void testHasNoProtocolPermission() throws Exception {
        runModifyProtocolTest(PROTOCOL_NUMBER, false, false);
    }
    
    @Test
    public void testHasModulePermission() throws Exception {
        runModifyProtocolAmendmentTest(PROTOCOL_NUMBER + "A001", getModuleTypeCode(), true, true);
    }

    @Test
    public void testHasNoModulePermission() throws Exception {
        runModifyProtocolAmendmentTest(PROTOCOL_NUMBER + "A001", ProtocolModule.ADD_MODIFY_ATTACHMENTS, true, false);
    }
    
    @Override
    protected ModifyAmendmentAuthorizer createModifyAmendmentAuthorizer() {
        return new ModifyProtocolSpecialReviewAuthorizer();
    }
    
    @Override
    protected String getModuleTypeCode() {
        return ProtocolModule.SPECIAL_REVIEW;
    }

    @Override
    protected String getTaskName() {
        return TaskName.MODIFY_PROTOCOL_SPECIAL_REVIEW;
    }
    
}
