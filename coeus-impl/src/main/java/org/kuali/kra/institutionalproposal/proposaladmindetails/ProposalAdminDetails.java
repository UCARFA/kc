/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.proposaladmindetails;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.instprop.api.admin.ProposalAdminDetailsContract;

import java.sql.Timestamp;

public class ProposalAdminDetails extends KcPersistableBusinessObjectBase implements ProposalAdminDetailsContract {


    private static final long serialVersionUID = -277575593517810685L;

    private Long proposalAdminDetailId;

    private String devProposalNumber;

    private Long instProposalId;

    private Timestamp dateSubmittedByDept;

    private Timestamp dateReturnedToDept;

    private Timestamp dateApprovedByOsp;

    private Timestamp dateSubmittedToAgency;

    private Timestamp instPropCreateDate;

    private String instPropCreateUser;

    private String signedBy;

    private boolean submissionType;

    private DevelopmentProposal developmentProposal;

    private InstitutionalProposal institutionalProposal;


    @Override
    public Timestamp getDateSubmittedByDept() {
        return dateSubmittedByDept;
    }

    public void setDateSubmittedByDept(Timestamp dateSubmittedByDept) {
        this.dateSubmittedByDept = dateSubmittedByDept;
    }

    @Override
    public Timestamp getDateReturnedToDept() {
        return dateReturnedToDept;
    }

    public void setDateReturnedToDept(Timestamp dateReturnedToDept) {
        this.dateReturnedToDept = dateReturnedToDept;
    }

    @Override
    public Timestamp getDateApprovedByOsp() {
        return dateApprovedByOsp;
    }

    public void setDateApprovedByOsp(Timestamp dateApprovedByOsp) {
        this.dateApprovedByOsp = dateApprovedByOsp;
    }

    @Override
    public Timestamp getDateSubmittedToAgency() {
        return dateSubmittedToAgency;
    }

    public void setDateSubmittedToAgency(Timestamp dateSubmittedToAgency) {
        this.dateSubmittedToAgency = dateSubmittedToAgency;
    }

    @Override
    public Timestamp getInstPropCreateDate() {
        return instPropCreateDate;
    }

    public void setInstPropCreateDate(Timestamp instPropCreateDate) {
        this.instPropCreateDate = instPropCreateDate;
    }

    @Override
    public String getInstPropCreateUser() {
        return instPropCreateUser;
    }

    public void setInstPropCreateUser(String instPropCreateUser) {
        this.instPropCreateUser = instPropCreateUser;
    }

    @Override
    public String getSignedBy() {
        return signedBy;
    }

    public void setSignedBy(String signedBy) {
        this.signedBy = signedBy;
    }

    @Override
    public boolean getSubmissionType() {
        return submissionType;
    }

    public void setSubmissionType(boolean submissionType) {
        this.submissionType = submissionType;
    }

    @Override
    public Long getProposalAdminDetailId() {
        return proposalAdminDetailId;
    }


    public void setProposalAdminDetailId(Long proposalAdminDetailId) {
        this.proposalAdminDetailId = proposalAdminDetailId;
    }

    @Override
    public String getDevProposalNumber() {
        return devProposalNumber;
    }


    public void setDevProposalNumber(String devProposalNumber) {
        this.devProposalNumber = devProposalNumber;
    }


    @Override
    public Long getInstProposalId() {
        return instProposalId;
    }

    public void setInstProposalId(Long instProposalId) {
        this.instProposalId = instProposalId;
    }

    public DevelopmentProposal getDevelopmentProposal() {
        return developmentProposal;
    }

    public void setDevelopmentProposal(DevelopmentProposal developmentProposal) {
        this.developmentProposal = developmentProposal;
    }

    public InstitutionalProposal getInstitutionalProposal() {
        return institutionalProposal;
    }

    public void setInstitutionalProposal(InstitutionalProposal institutionalProposal) {
        this.institutionalProposal = institutionalProposal;
    }
}
