/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.custom.attr;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.framework.custom.attr.CustomAttribute;
import org.kuali.coeus.common.framework.person.attr.DegreeType;
import org.kuali.coeus.common.impl.custom.attr.CustomAttributeMaintenanceDocumentRule;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.maintenance.MaintenanceRuleTestBase;
import org.kuali.rice.core.api.util.RiceKeyConstants;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.util.ErrorMessage;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.List;
import static org.junit.Assert.*;
public class CustomAttributeMaintenanceDocumentRuleTest extends MaintenanceRuleTestBase {
    private CustomAttributeMaintenanceDocumentRule rule = null;

    @Before
    public void setUp() throws Exception {
        rule = new CustomAttributeMaintenanceDocumentRule();
        GlobalVariables.setUserSession(new UserSession("quickstart"));
    }

    @After
    public void tearDown() throws Exception {
        rule = null;
    }

    /**
     * 
     * This method test both lookupclass and lookupreturn are specified
     * @throws Exception
     */
    @Test
    public void testOK() throws Exception {

        CustomAttribute customAttribute = new CustomAttribute();
        customAttribute.setLookupClass(DegreeType.class.getName());
        customAttribute.setLookupReturn("code");
        MaintenanceDocument customAttributeDocument = newMaintDoc(customAttribute);
        assertTrue(rule.processCustomRouteDocumentBusinessRules(customAttributeDocument));
        assertTrue(rule.processCustomApproveDocumentBusinessRules(customAttributeDocument));
    }

    /**
     * 
     * This method to test lookupreturn is not specified and lookupclass is selected.
     * @throws Exception
     */
    @Test
    public void testUnspecifiedLookupReturn() throws Exception {

        CustomAttribute customAttribute = new CustomAttribute();
        customAttribute.setLookupClass(DegreeType.class.getName());
        //customAttribute.setLookupReturn("roleId");
        MaintenanceDocument customAttributeDocument = newMaintDoc(customAttribute);
        assertFalse(rule.processCustomRouteDocumentBusinessRules(customAttributeDocument));
        List errors = GlobalVariables.getMessageMap().getMessages(Constants.DOCUMENT_NEWMAINTAINABLEOBJECT_LOOKUPRETURN);
        assertTrue(errors.size() == 1);
        ErrorMessage message = (ErrorMessage) errors.get(0);
        assertEquals(message.getErrorKey(), RiceKeyConstants.ERROR_REQUIRED);

        // approve will have the same error too.
        assertFalse(rule.processCustomApproveDocumentBusinessRules(customAttributeDocument));
        errors = GlobalVariables.getMessageMap().getMessages(Constants.DOCUMENT_NEWMAINTAINABLEOBJECT_LOOKUPRETURN);
        assertTrue(errors.size() == 1);
        message = (ErrorMessage) errors.get(0);
        assertEquals(message.getErrorKey(), RiceKeyConstants.ERROR_REQUIRED);

    }

}
