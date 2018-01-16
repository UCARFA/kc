/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.propdev.impl.core;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.coi.framework.Project;
import org.kuali.coeus.coi.framework.ProjectPublisher;
import org.kuali.coeus.coi.framework.ProjectRetrievalService;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.data.provider.impl.ProviderBasedDataObjectService;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.service.impl.DocumentServiceImpl;

import java.util.Collection;

public class ProposalDevelopmentServiceImplTest {
    class MockProjectPublisher implements ProjectPublisher {

        @Override
        public void publishProject(Project project) {
            sourceIdentifier = project.getSourceIdentifier();
        }

    }

    class MockProjectRetrievalServiceImpl implements ProjectRetrievalService {

        @Override
        public Collection<Project> retrieveProjects() {
            return null;
        }

        @Override
        public Project retrieveProject(String sourceIdentifier) {
            Project project = new Project();
            project.setSourceIdentifier("1");
            return project;
        }
    }

    class MockDataObjectService extends ProviderBasedDataObjectService {
        @Override
        public void delete(Object dataObject) {
            deleteCalled = true;
        }

        @Override
        public <T> void deleteMatching(Class<T> type, QueryByCriteria queryByCriteria) {
            deleteCalled = true;
        }
    }

    class MockDocumentService extends DocumentServiceImpl {
        @Override
        public Document saveDocument(Document document) throws WorkflowException {
            saveDocumentCalled = true;
            return document;
        }

        @Override
        public Document cancelDocument(Document document, String annotation) throws WorkflowException {
            cancelDocumentCalled = true;
            return null;
        }
    }

    private String sourceIdentifier;
    private boolean deleteCalled;
    private boolean saveDocumentCalled;
    private boolean cancelDocumentCalled;
    private ProposalDevelopmentServiceImpl proposalDevelopmentService;

    @Before
    public void setup() {
        proposalDevelopmentService = new ProposalDevelopmentServiceImpl();
        proposalDevelopmentService.setProjectRetrievalService(new MockProjectRetrievalServiceImpl());
        proposalDevelopmentService.setProjectPublisher(new MockProjectPublisher());
        proposalDevelopmentService.setDataObjectService(new MockDataObjectService());
        proposalDevelopmentService.setDocumentService(new MockDocumentService());
    }

    @Test
    public void deleteProposal() throws WorkflowException {
        ProposalDevelopmentDocument proposalDevelopmentDocument = new ProposalDevelopmentDocument();
        proposalDevelopmentDocument.setDevelopmentProposal(new DevelopmentProposal());
        proposalDevelopmentDocument.getDevelopmentProposal().setProposalNumber("1");
        proposalDevelopmentService.deleteProposal(proposalDevelopmentDocument);


        Assert.assertEquals("1", sourceIdentifier);
        Assert.assertTrue(deleteCalled);
        Assert.assertTrue(saveDocumentCalled);
        Assert.assertTrue(cancelDocumentCalled);
    }

}

