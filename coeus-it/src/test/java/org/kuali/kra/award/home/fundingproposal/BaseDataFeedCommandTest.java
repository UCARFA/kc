/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home.fundingproposal;

import org.junit.After;
import org.junit.Before;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;

public abstract class BaseDataFeedCommandTest extends KcIntegrationTestBase {
    Award award;
    InstitutionalProposal proposal;
    
    @Before
    public void setUp() throws Exception {
        award = new Award();
        proposal = new InstitutionalProposal();
        proposal.setProposalNumber("1234");
    }
    
    @After
    public void tearDown() throws Exception {
        award = null;
        proposal = null;
    }
}
