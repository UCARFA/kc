/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.lookup.keyvalue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.framework.unit.admin.UnitAdministratorType;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.kns.service.KNSServiceLocator;

import java.util.List;
import static org.junit.Assert.*;
public class AwardUnitContactTypeValuesFinderTest extends KcIntegrationTestBase {

    protected AwardUnitContactTypeValuesFinder valuesFinder;
    
    @Before
    public void setUp() throws Exception {
        valuesFinder = new AwardUnitContactTypeValuesFinder();
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testValuesFinder() throws Exception {
        List<KeyValue> keyLabels = valuesFinder.getKeyValues();
        assertFalse(keyLabels.isEmpty());
        for (KeyValue pair : keyLabels) {
            UnitAdministratorType contactType = KNSServiceLocator.getBusinessObjectService().findBySinglePrimaryKey(UnitAdministratorType.class, pair.getKey());
            assertEquals("U", contactType.getDefaultGroupFlag());
        }
    }
}
