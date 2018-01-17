/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.service;

import org.kuali.coeus.common.framework.krms.KcKrmsJavaFunctionTermService;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;

public interface InstitutionalProposalJavaFunctionKrmsTermService extends KcKrmsJavaFunctionTermService {

    Boolean isCurrentFiscalMonth(InstitutionalProposal ip);

    Boolean hasSpecialReviewOfType(InstitutionalProposal ip, String specialReviewTypeCode);

}
