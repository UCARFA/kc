/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.s2sgen.impl.generate.support;

import org.kuali.coeus.propdev.impl.abstrct.AbstractType;
import org.kuali.coeus.propdev.impl.abstrct.ProposalAbstract;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.person.ProposalPerson;
import org.kuali.coeus.propdev.impl.s2s.S2sOpportunity;
import org.kuali.coeus.propdev.impl.s2s.S2sRevisionType;
import org.kuali.coeus.propdev.impl.s2s.S2sSubmissionType;

public abstract class SF424ShortBaseGeneratorTest extends S2STestBase {
    @Override
    protected void prepareData(ProposalDevelopmentDocument document) throws Exception {

        AbstractType type = new AbstractType();
        type.setCode("1");

        ProposalAbstract proposalAbstract = new ProposalAbstract();
        proposalAbstract.setAbstractTypeCode("1");
        proposalAbstract.setAbstractType(type);
        proposalAbstract.setProposalNumber(document.getDevelopmentProposal().getProposalNumber());
        proposalAbstract.setAbstractDetails("foo");

        document.getDevelopmentProposal().getProposalAbstracts().add(proposalAbstract);


        ProposalPerson person = new ProposalPerson();
        person.setProposalPersonRoleId("PI");
        person.setProposalPersonNumber(1);
        person.setFirstName("firstname");
        person.setLastName("argLastName");
        person.setMiddleName("argMiddleName");
        person.setOfficePhone("321-321-1228");
        person.setEmailAddress("kcnotification@gmail.com");
        person.setFaxNumber("321-321-1289");
        person.setAddressLine1("argAddressLine1");
        person.setAddressLine2("argAddressLine2");
        person.setCity("Coeus");
        person.setPostalCode("53421");
        person.setCounty("UNITED STATES");
        person.setCountryCode("USA");
        person.setState("MA");
        person.setDirectoryTitle("argDirectoryTitle");
        person.setDivision("division");
        person.setDevelopmentProposal(document.getDevelopmentProposal());
        document.getDevelopmentProposal().getProposalPersons().add(person);
    }

    @Override
    protected void prepareS2sData(ProposalDevelopmentDocument document) {
        super.prepareS2sData(document);

        document.getDevelopmentProposal().setSponsorProposalNumber("1234");

        S2sOpportunity s2sOpportunity = document.getDevelopmentProposal().getS2sOpportunity();
        s2sOpportunity.setOpportunityId("1234");
        S2sSubmissionType s2sSubmissionType = new S2sSubmissionType();
        s2sSubmissionType.setCode("1");
        s2sSubmissionType.setDescription("Preapplication");
        s2sOpportunity.setS2sSubmissionType(s2sSubmissionType);
        S2sRevisionType s2sRevisionType = new S2sRevisionType();
        s2sRevisionType.setCode("A");
        s2sOpportunity.setS2sRevisionType(s2sRevisionType);
        document.getDevelopmentProposal().setS2sOpportunity(s2sOpportunity);
    }
}
