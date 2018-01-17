/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.core;

public interface ProposalTypeService {
	
	public String getResubmissionProposalTypeCode();
	
	public String getContinuationProposalTypeCode();
	
	public String getRevisionProposalTypeCode();
	
	public String getS2SSubmissionChangeCorrectedCode();
	
	public String getNewProposalTypeCode();
	
	public String getRenewProposalTypeCode();
	
	public boolean isProposalTypeRenewalRevisionContinuation(String proposalTypeCode);

	public String getNewChangedOrCorrectedProposalTypeCode();

	public String getResubmissionChangedOrCorrectedProposalTypeCode();

	public String getBudgetSowUpdateProposalTypeCode();

	public String getRenewalChangedOrCorrectedProposalTypeCode();

	public String getSupplementChangedOrCorrectedProposalTypeCode();

	public String getDefaultSubmissionTypeCode(String proposalTypeCode);

	public String getPreProposalProposalTypeCode();
}
