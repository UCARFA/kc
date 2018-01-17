/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person.attachment;

import javax.persistence.*;

import org.kuali.coeus.common.framework.print.KcAttachmentDataSource;
import org.kuali.coeus.propdev.api.person.attachment.ProposalPersonBiographyAttachmentContract;

/**
 * 
 * This bo for eps_prop_person_bio_attachment
 */
@Entity
@Table(name = "EPS_PROP_PERSON_BIO_ATTACHMENT")
@IdClass(ProposalPersonBiography.ProposalPersonBiographyId.class)
public class ProposalPersonBiographyAttachment extends KcAttachmentDataSource implements ProposalPersonBiographyAttachmentContract {


    @Id
    @OneToOne(cascade = { CascadeType.REFRESH })
    @JoinColumns({ @JoinColumn(name = "PROP_PERSON_NUMBER", referencedColumnName = "PROP_PERSON_NUMBER"), @JoinColumn(name = "BIO_NUMBER", referencedColumnName = "BIO_NUMBER"), @JoinColumn(name = "PROPOSAL_NUMBER", referencedColumnName = "PROPOSAL_NUMBER") })
    private ProposalPersonBiography proposalPersonBiography;

    public ProposalPersonBiographyAttachment() {
        super();
    }

    @Override
    public Integer getProposalPersonNumber() {
        return proposalPersonBiography.getProposalPersonNumber();
    }

    public void setProposalPersonNumber(Integer proposalPersonNumber) {
        proposalPersonBiography.setProposalPersonNumber(proposalPersonNumber);
    }

    @Override
    public String getProposalNumber() {
        return proposalPersonBiography.getProposalNumber();
    }

    public void setProposalNumber(String proposalNumber) {
        proposalPersonBiography.setProposalNumber(proposalNumber);
    }

    @Override
    public Integer getBiographyNumber() {
        return proposalPersonBiography.getBiographyNumber();
    }

    public void setBiographyNumber(Integer biographyNumber) {
        proposalPersonBiography.setBiographyNumber(biographyNumber);
    }

    public ProposalPersonBiography getProposalPersonBiography() {
        return proposalPersonBiography;
    }

    public void setProposalPersonBiography(ProposalPersonBiography proposalPersonBiography) {
        this.proposalPersonBiography = proposalPersonBiography;
    }

}
