/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2016 Kuali, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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

