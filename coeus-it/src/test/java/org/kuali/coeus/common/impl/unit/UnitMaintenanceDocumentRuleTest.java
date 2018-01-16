/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.unit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.coeus.common.impl.unit.UnitMaintenanceDocumentRule;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.maintenance.MaintenanceRuleTestBase;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.util.ErrorMessage;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.List;
import static org.junit.Assert.*;
public class UnitMaintenanceDocumentRuleTest extends MaintenanceRuleTestBase {
    private UnitMaintenanceDocumentRule rule = null;


    @Before
    public void setUp() throws Exception {
        rule = new UnitMaintenanceDocumentRule();
        GlobalVariables.setUserSession(new UserSession("quickstart"));
    }

    @After
    public void tearDown() throws Exception {
        rule = null;
    }

    @Test
    public void testOK() throws Exception {

        Unit unit=new Unit();
        String unitNumber="BL-RCEN";
        unit.setUnitName(unitNumber);
        unit.setUnitNumber("BL-RCEN");
        unit.setParentUnitNumber("IN-IN");
        unit.setOrganizationId("00001");
        MaintenanceDocument unitmaintenancedocument = newMaintDoc(unit);
        assertTrue(rule.processCustomApproveDocumentBusinessRules(unitmaintenancedocument));
    }

    @Test
    public void testMoveUnitOwnDescendant() throws Exception{
        Unit unit=new Unit();
        unit.setUnitName("IN-IN");
        unit.setUnitNumber("IN-IN");
        unit.setParentUnitNumber("IN-MED");
        unit.setOrganizationId("00001");
        MaintenanceDocument unitmaintenancedocument = newMaintDoc(unit);
        assertFalse(rule.processCustomRouteDocumentBusinessRules(unitmaintenancedocument));
        List errors = GlobalVariables.getMessageMap().getMessages("ddocument.newMaintainableObject.parentUnitNumber");
        errors = GlobalVariables.getMessageMap().getMessages("document.newMaintainableObject.parentUnitNumber");
        assertTrue(errors.size() == 1);
        ErrorMessage message = (ErrorMessage) errors.get(0);
        assertEquals(message.getErrorKey(), KeyConstants.MOVE_UNIT_OWN_DESCENDANTS);
    }

}


