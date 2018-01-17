/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.proposaldevelopment.rules;

import org.junit.After;
import org.junit.Before;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.service.DocumentService;
import org.kuali.rice.krad.service.KRADServiceLocatorWeb;
import org.kuali.rice.krad.util.MessageMap;

import java.util.HashMap;

/**
 * Base class for Proposal Development business rule tests.
 * 
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public abstract class ProposalDevelopmentRuleTestBase extends KcIntegrationTestBase {

    protected DocumentService documentService = null;

    @Before
    public void setUp() throws Exception {
        GlobalVariables.setUserSession(new UserSession("quickstart"));
        GlobalVariables.setMessageMap(new MessageMap());
        GlobalVariables.setAuditErrorMap(new HashMap());
        documentService = KRADServiceLocatorWeb.getDocumentService();
    }

    @After
    public void tearDown() throws Exception {
        GlobalVariables.setUserSession(null);
        GlobalVariables.setMessageMap(null);
        GlobalVariables.setAuditErrorMap(null);
        documentService = null;
    }
    
    /**
     * Get a new Proposal Development Document.
     * 
     * @return a new Proposal Development Document.
     * @throws WorkflowException
     */
    protected ProposalDevelopmentDocument getNewProposalDevelopmentDocument() throws WorkflowException {
        return (ProposalDevelopmentDocument) documentService.getNewDocument("ProposalDevelopmentDocument");
    }
}
