/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.service.impl;


import org.junit.Assert;
import org.junit.Test;
import org.kuali.coeus.common.framework.compliance.core.SpecialReviewType;
import org.kuali.coeus.common.impl.fiscalyear.FiscalYearMonthServiceImpl;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.kra.institutionalproposal.specialreview.InstitutionalProposalSpecialReview;

import java.util.ArrayList;

public class InstitutionalProposalJavaFunctionKrmsTermServiceImplTest {

    class MockIP extends InstitutionalProposal {

        @Override
        protected void calculateFiscalMonthAndYearFields() {

        }
    }

    class MockIpTermService extends InstitutionalProposalJavaFunctionKrmsTermServiceImpl {


    }

    class MockFiscalYearMonthServiceImpl extends FiscalYearMonthServiceImpl {
        Integer month;
        Integer year;

        public void setCurrentFiscalMonth(Integer month) {
            this.month = month;
        }

        public void setCurrentFiscalYear(Integer year) {
            this.year = year;
        }

        @Override
        public Integer getCurrentFiscalMonth() {
            return month;
        }

        @Override
        public Integer getCurrentFiscalYear() {
            return year;
        }

    }

    @Test
    public void testIsCurrentFiscalMonth() {
        InstitutionalProposalJavaFunctionKrmsTermServiceImpl ipTermService = new InstitutionalProposalJavaFunctionKrmsTermServiceImpl();
        MockFiscalYearMonthServiceImpl fiscalYearMonthService = new MockFiscalYearMonthServiceImpl();
        fiscalYearMonthService.setCurrentFiscalYear(2016);
        fiscalYearMonthService.setCurrentFiscalMonth(8);
        ipTermService.setFiscalYearMonthService(fiscalYearMonthService);
        MockIP ip = new MockIP();
        ip.setFiscalYear("2016");
        ip.setFiscalMonth("08");
        Assert.assertTrue(ipTermService.isCurrentFiscalMonth(ip));

        ip.setFiscalYear("2018");
        ip.setFiscalMonth("8");
        Assert.assertFalse(ipTermService.isCurrentFiscalMonth(ip));

        ip.setFiscalYear(null);
        ip.setFiscalMonth(null);
        Assert.assertFalse(ipTermService.isCurrentFiscalMonth(ip));

        ip.setFiscalYear("2018");
        ip.setFiscalMonth(null);
        Assert.assertFalse(ipTermService.isCurrentFiscalMonth(ip));
    }


    @Test
    public void testHasSpecialReviewOfType() {

        MockIP ip = new MockIP();
        InstitutionalProposalSpecialReview specialReview = new InstitutionalProposalSpecialReview();
        specialReview.setSpecialReviewTypeCode("1");
        SpecialReviewType specialReviewType = new SpecialReviewType();
        specialReviewType.setSpecialReviewTypeCode("1");
        specialReview.setSpecialReviewType(specialReviewType);
        ip.getSpecialReviews().add(specialReview);

        InstitutionalProposalJavaFunctionKrmsTermServiceImpl ipTermService = new InstitutionalProposalJavaFunctionKrmsTermServiceImpl();
        Assert.assertTrue(ipTermService.hasSpecialReviewOfType(ip, "1"));

        specialReview = new InstitutionalProposalSpecialReview();
        specialReviewType = new SpecialReviewType();
        specialReviewType.setDescription("1");
        specialReview.setSpecialReviewType(specialReviewType);
        ip.getSpecialReviews().add(specialReview);

        Assert.assertTrue(ipTermService.hasSpecialReviewOfType(ip, "1"));

        specialReview = new InstitutionalProposalSpecialReview();
        specialReviewType = new SpecialReviewType();
        specialReview.setSpecialReviewTypeCode("1");
        specialReviewType.setSpecialReviewTypeCode("1");
        specialReviewType.setDescription("1");
        specialReview.setSpecialReviewType(specialReviewType);
        ip.getSpecialReviews().add(specialReview);

        Assert.assertFalse(ipTermService.hasSpecialReviewOfType(ip, "2"));

        ip.setSpecialReviews(new ArrayList<>());
        Assert.assertFalse(ipTermService.hasSpecialReviewOfType(ip, "2"));

    }
}
