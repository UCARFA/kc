/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.fiscalyear.FiscalYearMonthService;
import org.kuali.coeus.common.impl.krms.KcKrmsJavaFunctionTermServiceBase;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.kra.institutionalproposal.service.InstitutionalProposalJavaFunctionKrmsTermService;
import org.kuali.kra.institutionalproposal.specialreview.InstitutionalProposalSpecialReview;

import java.util.Objects;

public class InstitutionalProposalJavaFunctionKrmsTermServiceImpl extends KcKrmsJavaFunctionTermServiceBase implements InstitutionalProposalJavaFunctionKrmsTermService {

    private FiscalYearMonthService fiscalYearMonthService;

    @Override
    public Boolean isCurrentFiscalMonth(InstitutionalProposal ip) {
        String currentFiscalYear = getFiscalYearMonthService().getCurrentFiscalYear().toString();
        String currentFiscalMonth = StringUtils.leftPad(getFiscalYearMonthService().getCurrentFiscalMonth().toString(), 2, '0');
        return Objects.equals(currentFiscalMonth, ip.getFiscalMonth()) && Objects.equals(currentFiscalYear, ip.getFiscalYear());
    }

    public FiscalYearMonthService getFiscalYearMonthService() {
        return fiscalYearMonthService;
    }

    public void setFiscalYearMonthService(FiscalYearMonthService fiscalYearMonthService) {
        this.fiscalYearMonthService = fiscalYearMonthService;
    }

    @Override
    public Boolean hasSpecialReviewOfType(InstitutionalProposal ip, String specialReviewType) {
        return ip.getSpecialReviews().stream().anyMatch(ipReview -> doesSpecialReviewMatch(ipReview, specialReviewType));
    }

    public boolean doesSpecialReviewMatch(InstitutionalProposalSpecialReview specialReview, String specialReviewType) {
        return (StringUtils.equals(specialReview.getSpecialReviewTypeCode(), specialReviewType) ||
                specialReview.getSpecialReviewType() != null && StringUtils.equals(specialReview.getSpecialReviewType().getDescription(), specialReviewType));
    }

}
