package org.kuali.coeus.propdev.impl.auth;
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

import junit.framework.Assert;
import org.junit.Test;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.person.ProposalPerson;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.kew.api.KewApiConstants;
import org.kuali.rice.kew.api.action.ActionTaken;
import org.kuali.rice.kew.api.action.ActionType;

import java.util.ArrayList;
import java.util.List;

public class ProposalDevelopmentDocumentAuthorizerTest {


    public static final String PI = "10000000045";
    public static final String PERSON1 = "10000000018";
    public static final Integer PI_ROLODEX_ID = 12;
    public static final Integer PERSON1_ROLODEX_ID = 11;

    @Test
    public void test_oneProposalPersonApprovedBothInRouteLog() {
        class ProposalDevelopmentDocumentAuthorizerMock extends ProposalDevelopmentDocumentAuthorizer {
            @Override
            protected List<ActionTaken> getActionsTaken(ProposalDevelopmentDocument document) {
                List<ActionTaken> actionsTaken = new ArrayList<>();
                ActionType actionType = ActionType.fromCodeOrLabel(KewApiConstants.ACTION_REQUEST_APPROVE_REQ);
                ActionTaken actionTaken1 = ActionTaken.Builder.create("1", "1", PERSON1, actionType).build();
                actionsTaken.add(actionTaken1);
                return actionsTaken;

            }

            @Override
            protected List<String> getPrincipalIdsInRouteLog(ProposalDevelopmentDocument document) {
                final ArrayList<String> personsInRouteLog = new ArrayList<>();
                personsInRouteLog.add(PI);
                personsInRouteLog.add(PERSON1);
                return personsInRouteLog;
            }
        }


        ProposalDevelopmentDocumentAuthorizerMock proposalDevelopmentDocumentAuthorizer = new ProposalDevelopmentDocumentAuthorizerMock();
        ProposalDevelopmentDocument proposalDevelopmentDocument = new ProposalDevelopmentDocument();
        DevelopmentProposal developmentProposal = new DevelopmentProposal();
        ProposalPerson person1 = new ProposalPerson();
        person1.setPersonId(PERSON1);
        ProposalPerson pi = new ProposalPerson();
        pi.setPersonId(PI);
        pi.setProposalPersonRoleId(Constants.PRINCIPAL_INVESTIGATOR_ROLE);
        developmentProposal.getProposalPersons().add(person1);
        developmentProposal.getProposalPersons().add(pi);
        proposalDevelopmentDocument.setDevelopmentProposal(developmentProposal);
        Assert.assertTrue(proposalDevelopmentDocumentAuthorizer.hasProposalPersonApproved(proposalDevelopmentDocument, person1));
        Assert.assertFalse(proposalDevelopmentDocumentAuthorizer.hasProposalPersonApproved(proposalDevelopmentDocument, pi));

    }

    @Test
    public void test_oneProposalPersonNotInRouteLogPiApproved() {
        class ProposalDevelopmentDocumentAuthorizerMock extends ProposalDevelopmentDocumentAuthorizer {
            @Override
            protected List<ActionTaken> getActionsTaken(ProposalDevelopmentDocument document) {
                List<ActionTaken> actionsTaken = new ArrayList<>();
                ActionType actionType = ActionType.fromCodeOrLabel(KewApiConstants.ACTION_REQUEST_APPROVE_REQ);
                ActionTaken actionTaken1 = ActionTaken.Builder.create("1", "1", PI, actionType).build();
                actionsTaken.add(actionTaken1);
                return actionsTaken;

            }
            @Override
            protected List<String> getPrincipalIdsInRouteLog(ProposalDevelopmentDocument document) {
                final ArrayList<String> personsInRouteLog = new ArrayList<>();
                personsInRouteLog.add(PI);
                return personsInRouteLog;
            }
        }


        ProposalDevelopmentDocumentAuthorizerMock proposalDevelopmentDocumentAuthorizer = new ProposalDevelopmentDocumentAuthorizerMock();
        ProposalDevelopmentDocument proposalDevelopmentDocument = new ProposalDevelopmentDocument();
        DevelopmentProposal developmentProposal = new DevelopmentProposal();
        ProposalPerson person1 = new ProposalPerson();
        person1.setPersonId(PERSON1);
        ProposalPerson pi = new ProposalPerson();
        pi.setPersonId(PI);
        pi.setProposalPersonRoleId(Constants.PRINCIPAL_INVESTIGATOR_ROLE);
        developmentProposal.getProposalPersons().add(person1);
        developmentProposal.getProposalPersons().add(pi);
        proposalDevelopmentDocument.setDevelopmentProposal(developmentProposal);
        Assert.assertTrue(proposalDevelopmentDocumentAuthorizer.hasProposalPersonApproved(proposalDevelopmentDocument, person1));

    }

    @Test
    public void test_twoProposalPersonInRouteLogApproved() {
        class ProposalDevelopmentDocumentAuthorizerMock extends ProposalDevelopmentDocumentAuthorizer {
            @Override
            protected List<ActionTaken> getActionsTaken(ProposalDevelopmentDocument document) {
                List<ActionTaken> actionsTaken = new ArrayList<>();
                ActionType actionType = ActionType.fromCodeOrLabel(KewApiConstants.ACTION_REQUEST_APPROVE_REQ);
                ActionTaken actionTaken1 = ActionTaken.Builder.create("1", "1", PI, actionType).build();
                actionsTaken.add(actionTaken1);
                ActionType actionType2 = ActionType.fromCodeOrLabel(KewApiConstants.ACTION_REQUEST_APPROVE_REQ);
                ActionTaken actionTaken2 = ActionTaken.Builder.create("1", "1", PERSON1, actionType2).build();
                actionsTaken.add(actionTaken2);
                return actionsTaken;

            }
            @Override
            protected List<String> getPrincipalIdsInRouteLog(ProposalDevelopmentDocument document) {
                final ArrayList<String> personsInRouteLog = new ArrayList<>();
                personsInRouteLog.add(PI);
                personsInRouteLog.add(PERSON1);
                return personsInRouteLog;
            }
        }


        ProposalDevelopmentDocumentAuthorizerMock proposalDevelopmentDocumentAuthorizer = new ProposalDevelopmentDocumentAuthorizerMock();
        ProposalDevelopmentDocument proposalDevelopmentDocument = new ProposalDevelopmentDocument();
        DevelopmentProposal developmentProposal = new DevelopmentProposal();
        ProposalPerson person1 = new ProposalPerson();
        person1.setPersonId(PERSON1);
        ProposalPerson pi = new ProposalPerson();
        pi.setPersonId(PI);
        pi.setProposalPersonRoleId(Constants.PRINCIPAL_INVESTIGATOR_ROLE);
        developmentProposal.getProposalPersons().add(person1);
        developmentProposal.getProposalPersons().add(pi);
        proposalDevelopmentDocument.setDevelopmentProposal(developmentProposal);
        Assert.assertTrue(proposalDevelopmentDocumentAuthorizer.hasProposalPersonApproved(proposalDevelopmentDocument, person1));
        Assert.assertTrue(proposalDevelopmentDocumentAuthorizer.hasProposalPersonApproved(proposalDevelopmentDocument, pi));

    }

    @Test
    public void test_twoProposalRolodexPersonInRouteLogPiApproved() {
        class ProposalDevelopmentDocumentAuthorizerMock extends ProposalDevelopmentDocumentAuthorizer {
            @Override
            protected List<ActionTaken> getActionsTaken(ProposalDevelopmentDocument document) {
                List<ActionTaken> actionsTaken = new ArrayList<>();
                ActionType actionType = ActionType.fromCodeOrLabel(KewApiConstants.ACTION_REQUEST_APPROVE_REQ);
                ActionTaken actionTaken1 = ActionTaken.Builder.create("1", "1", PI, actionType).build();
                actionsTaken.add(actionTaken1);
                return actionsTaken;

            }
            @Override
            protected List<String> getPrincipalIdsInRouteLog(ProposalDevelopmentDocument document) {
                final ArrayList<String> personsInRouteLog = new ArrayList<>();
                personsInRouteLog.add(PI);
                personsInRouteLog.add(PERSON1_ROLODEX_ID.toString());
                return personsInRouteLog;
            }
        }


        ProposalDevelopmentDocumentAuthorizerMock proposalDevelopmentDocumentAuthorizer = new ProposalDevelopmentDocumentAuthorizerMock();
        ProposalDevelopmentDocument proposalDevelopmentDocument = new ProposalDevelopmentDocument();
        DevelopmentProposal developmentProposal = new DevelopmentProposal();
        ProposalPerson person1 = new ProposalPerson();
        person1.setRolodexId(PERSON1_ROLODEX_ID);
        ProposalPerson pi = new ProposalPerson();
        pi.setPersonId(PI);
        pi.setProposalPersonRoleId(Constants.PRINCIPAL_INVESTIGATOR_ROLE);
        developmentProposal.getProposalPersons().add(person1);
        developmentProposal.getProposalPersons().add(pi);
        proposalDevelopmentDocument.setDevelopmentProposal(developmentProposal);
        Assert.assertTrue(proposalDevelopmentDocumentAuthorizer.hasProposalPersonApproved(proposalDevelopmentDocument, person1));
        Assert.assertTrue(proposalDevelopmentDocumentAuthorizer.hasProposalPersonApproved(proposalDevelopmentDocument, pi));

    }

    // Edge case, not handled. PI with a rolodex cannot approve document.
    @Test
    public void test_twoProposalRolodexPi() {
        class ProposalDevelopmentDocumentAuthorizerMock extends ProposalDevelopmentDocumentAuthorizer {
            @Override
            protected List<ActionTaken> getActionsTaken(ProposalDevelopmentDocument document) {
                List<ActionTaken> actionsTaken = new ArrayList<>();
                return actionsTaken;

            }
            @Override
            protected List<String> getPrincipalIdsInRouteLog(ProposalDevelopmentDocument document) {
                final ArrayList<String> personsInRouteLog = new ArrayList<>();
                return personsInRouteLog;
            }
        }


        ProposalDevelopmentDocumentAuthorizerMock proposalDevelopmentDocumentAuthorizer = new ProposalDevelopmentDocumentAuthorizerMock();
        ProposalDevelopmentDocument proposalDevelopmentDocument = new ProposalDevelopmentDocument();
        DevelopmentProposal developmentProposal = new DevelopmentProposal();
        ProposalPerson person1 = new ProposalPerson();
        person1.setRolodexId(PERSON1_ROLODEX_ID);
        ProposalPerson pi = new ProposalPerson();
        pi.setRolodexId(PI_ROLODEX_ID);
        pi.setProposalPersonRoleId(Constants.PRINCIPAL_INVESTIGATOR_ROLE);
        developmentProposal.getProposalPersons().add(person1);
        developmentProposal.getProposalPersons().add(pi);
        proposalDevelopmentDocument.setDevelopmentProposal(developmentProposal);
        Assert.assertFalse(proposalDevelopmentDocumentAuthorizer.hasProposalPersonApproved(proposalDevelopmentDocument, person1));
        Assert.assertFalse(proposalDevelopmentDocumentAuthorizer.hasProposalPersonApproved(proposalDevelopmentDocument, pi));

    }

    @Test
    public void test_twoProposalPersonInRouteLogPiApproved() {
        class ProposalDevelopmentDocumentAuthorizerMock extends ProposalDevelopmentDocumentAuthorizer {
            @Override
            protected List<ActionTaken> getActionsTaken(ProposalDevelopmentDocument document) {
                List<ActionTaken> actionsTaken = new ArrayList<>();
                ActionType actionType = ActionType.fromCodeOrLabel(KewApiConstants.ACTION_REQUEST_APPROVE_REQ);
                ActionTaken actionTaken1 = ActionTaken.Builder.create("1", "1", PI, actionType).build();
                actionsTaken.add(actionTaken1);
                return actionsTaken;

            }
            @Override
            protected List<String> getPrincipalIdsInRouteLog(ProposalDevelopmentDocument document) {
                final ArrayList<String> personsInRouteLog = new ArrayList<>();
                personsInRouteLog.add(PI);
                personsInRouteLog.add(PERSON1);
                return personsInRouteLog;
            }
        }

        ProposalDevelopmentDocumentAuthorizerMock proposalDevelopmentDocumentAuthorizer = new ProposalDevelopmentDocumentAuthorizerMock();
        ProposalDevelopmentDocument proposalDevelopmentDocument = new ProposalDevelopmentDocument();
        DevelopmentProposal developmentProposal = new DevelopmentProposal();
        ProposalPerson person1 = new ProposalPerson();
        person1.setPersonId(PERSON1);
        ProposalPerson pi = new ProposalPerson();
        pi.setPersonId(PI);
        pi.setProposalPersonRoleId(Constants.PRINCIPAL_INVESTIGATOR_ROLE);
        developmentProposal.getProposalPersons().add(person1);
        developmentProposal.getProposalPersons().add(pi);
        proposalDevelopmentDocument.setDevelopmentProposal(developmentProposal);
        Assert.assertFalse(proposalDevelopmentDocumentAuthorizer.hasProposalPersonApproved(proposalDevelopmentDocument, person1));
    }
}
