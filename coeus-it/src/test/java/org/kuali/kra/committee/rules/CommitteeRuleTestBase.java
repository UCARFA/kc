/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.rules;

import org.junit.After;
import org.junit.Before;
import org.kuali.kra.committee.bo.Committee;
import org.kuali.kra.committee.document.CommitteeDocument;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.service.DocumentService;
import org.kuali.rice.krad.service.KRADServiceLocatorWeb;
import org.kuali.rice.krad.util.ErrorMessage;
import org.kuali.rice.krad.util.MessageMap;

import java.util.HashMap;
import java.util.List;
import static org.junit.Assert.*;
/**
 * Base class for Committee business rule tests.
 */
public abstract class CommitteeRuleTestBase extends KcIntegrationTestBase {

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
     * Set the required fields for a committee.
     * @param document
     */
    protected void setCommitteeProperties(CommitteeDocument document) {
        Committee committee = document.getCommittee();
        document.getDocumentHeader().setDocumentDescription("test");
        committee.setCommitteeId((new Long(new java.util.Date().getTime())).toString());
        committee.setCommitteeName("test");
        committee.setCommitteeTypeCode("1");
        committee.setHomeUnitNumber("000001");
        committee.setCommitteeDescription("description");
        committee.setMaxProtocols(5);
        committee.setMinimumMembersRequired(4);
        committee.setAdvancedSubmissionDaysRequired(3);
        committee.setReviewTypeCode("1");
        committee.setScheduleDescription("schedule description");
    }
    
    /**
     * Get a new Committee Document.
     * 
     * @return a new Committee Document.
     * @throws WorkflowException
     */
    protected CommitteeDocument getNewCommitteeDocument() throws WorkflowException {
        return (CommitteeDocument) documentService.getNewDocument("CommitteeDocument");
    }
    
    /**
     * Assert an error.  The Error Map should have one error with the given
     * property key and error key.
     * @param propertyKey
     * @param errorKey
     */
    protected void assertError(String propertyKey, String errorKey) {
        List errors = GlobalVariables.getMessageMap().getMessages(propertyKey);
        assertNotNull(errors);
        assertTrue(errors.size() == 1);
        
        ErrorMessage message = (ErrorMessage) errors.get(0);
        assertNotNull(message);
        assertEquals(message.getErrorKey(), errorKey);
    }
    
}
