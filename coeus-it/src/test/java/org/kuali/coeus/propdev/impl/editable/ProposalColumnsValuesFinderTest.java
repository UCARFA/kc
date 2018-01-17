/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.editable;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.propdev.impl.editable.ProposalColumnsValuesFinder;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ProposalColumnsValuesFinderTest extends KcIntegrationTestBase {
    
    private ProposalColumnsValuesFinder finder = null;

    @Before
    public void setUp() throws Exception {
        finder = new ProposalColumnsValuesFinder();
    }
    
    @Test
    public void testProposalColumnsValuesFinderRuns() {
        List<KeyValue> values = finder.getKeyValues();
        assertTrue(values.size() > 0);
    }

    @After
    public void tearDown() throws Exception {
    }

}
