/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.location.api.state.State;
import org.kuali.rice.location.api.state.StateService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StateServiceTest extends KcIntegrationTestBase {
    private StateService stateService;
    private static final String POSTAL_CNTRY_CD_UNITED_STATES = "US";
    private static final String ALT_POSTAL_CNTRY_CD_UNITED_STATES = "USA";
    
    @Before
    public void setUp() throws Exception {
        stateService = KcServiceLocator.getService(StateService.class);
    }
    @After
    public void tearDown() throws Exception {
        stateService = null;
    }
    
    @Test 
    public void testFindAllStatesByAltCountryCode() throws Exception {
        List<State> states = stateService.findAllStatesInCountryByAltCode(ALT_POSTAL_CNTRY_CD_UNITED_STATES); 
        List<State> statesForComparison = stateService.findAllStatesInCountry(POSTAL_CNTRY_CD_UNITED_STATES);
        
        assertNotNull(states);
        assertNotNull(statesForComparison);
        assertEquals(states.size(), statesForComparison.size());
        int i = 0;
        for(State state : states) {
            assertEquals(state.getName(), statesForComparison.get(i).getName());
            i++;
        }
    }
}
