/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.contacts;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.framework.unit.admin.UnitAdministratorType;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.List;

public class InstitutionalProposalUnitContactsProjectRoleValuesFinderTest extends KcIntegrationTestBase {
    InstitutionalProposalUnitContactsProjectRoleValuesFinder ipucProjectRoleValuesFinder;

    @Before
    public void setUp() throws Exception {
        ipucProjectRoleValuesFinder = this.getIpucProjectRoleValuesFinder();

    }
    
    private InstitutionalProposalUnitContactsProjectRoleValuesFinder getIpucProjectRoleValuesFinder() {
        return new InstitutionalProposalUnitContactsProjectRoleValuesFinder();
    }

    @After
    public void tearDown() throws Exception {
        ipucProjectRoleValuesFinder = null;
    }

    @Test
    public final void testGetKeyValues() {
        List<KeyValue> roleKeys = ipucProjectRoleValuesFinder.getKeyValues();
        BusinessObjectService boService = KcServiceLocator.getService(BusinessObjectService.class);
        
        for(KeyValue KeyValue:roleKeys){
            Assert.assertNotNull(KeyValue.getKey());
            Assert.assertNotNull(KeyValue.getValue());
            if(!StringUtils.equals(KeyValue.getValue(), "select")){ 
                UnitAdministratorType aType = (UnitAdministratorType) boService.findBySinglePrimaryKey(UnitAdministratorType.class, KeyValue.getKey());
                Assert.assertEquals(Constants.UNIT_CONTACTS_DEFAULT_GROUP_FLAG, aType.getDefaultGroupFlag());
            }
        }
        
    }
    
    
}
