/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.proposallog;

import org.kuali.rice.kns.web.struts.form.KualiForm;

import java.util.List;

public class ProposalLogMergeForm extends KualiForm {

    private static final long serialVersionUID = 1414700067134931878L;
    
    private String proposalLogNumber;
    private String institutionalProposalNumber;
    
    private String proposalLogTypeCode;
    private String proposalLogTypeCodeDescription;
    private String piId;
    private String rolodexId;
    private List<ProposalLog> matchedProposalLogs;
    
    public String getProposalLogNumber() {
        return proposalLogNumber;
    }
    
    public void setProposalLogNumber(String proposalLogNumber) {
        this.proposalLogNumber = proposalLogNumber;
    }
    
    public String getInstitutionalProposalNumber() {
        return institutionalProposalNumber;
    }
    
    public void setInstitutionalProposalNumber(String institutionalProposalNumber) {
        this.institutionalProposalNumber = institutionalProposalNumber;
    }
    
    public String getProposalLogTypeCode() {
        return proposalLogTypeCode;
    }

    public void setProposalLogTypeCode(String proposalLogTypeCode) {
        this.proposalLogTypeCode = proposalLogTypeCode;
    }

    public String getPiId() {
        return piId;
    }

    public void setPiId(String piId) {
        this.piId = piId;
    }

    public List<ProposalLog> getMatchedProposalLogs() {
        return matchedProposalLogs;
    }

    public void setMatchedProposalLogs(List<ProposalLog> matchedProposalLogs) {
        this.matchedProposalLogs = matchedProposalLogs;
    }

    public String getRolodexId() {
        return rolodexId;
    }

    public void setRolodexId(String rolodexId) {
        this.rolodexId = rolodexId;
    }

	public String getProposalLogTypeCodeDescription() {
		return proposalLogTypeCodeDescription;
	}

	public void setProposalLogTypeCodeDescription(String proposalLogTypeCodeDescription) {
		this.proposalLogTypeCodeDescription = proposalLogTypeCodeDescription;
	}
    
}
