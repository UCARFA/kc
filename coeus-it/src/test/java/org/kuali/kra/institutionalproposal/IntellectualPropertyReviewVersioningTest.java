/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal;

import org.junit.Assert;
import org.junit.Test;
import org.kuali.coeus.common.framework.version.VersionException;
import org.kuali.coeus.common.framework.version.VersioningService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.institutionalproposal.ipreview.IntellectualPropertyReview;
import org.kuali.kra.institutionalproposal.ipreview.IntellectualPropertyReviewActivity;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.kew.api.exception.WorkflowException;

public class IntellectualPropertyReviewVersioningTest extends KcIntegrationTestBase {
    
    private VersioningService versioningService;
    
    @Test
    public void testVersionInstitutionalProposal() throws VersionException, WorkflowException {
        
        IntellectualPropertyReview ipReview = new IntellectualPropertyReview();
        ipReview.setIpReviewId(new Long(1));
        ipReview.setProposalNumber("1");
        ipReview.setSequenceNumber(1);
        
        IntellectualPropertyReviewActivity ipReviewActivity = new IntellectualPropertyReviewActivity();
        ipReviewActivity.setProposalIpReviewActivityId(new Long(1));
        ipReviewActivity.setProposalNumber("1");
        ipReviewActivity.setSequenceNumber(1);
        
        ipReview.getIpReviewActivities().add(ipReviewActivity);
        
        IntellectualPropertyReview newIpReviewVersion = getVersioningService().createNewVersion(ipReview);
        
        Assert.assertNull(newIpReviewVersion.getIpReviewId());
        Assert.assertTrue(newIpReviewVersion.getSequenceNumber().equals(2));
        
        Assert.assertNull(newIpReviewVersion.getIpReviewActivities().get(0).getProposalIpReviewActivityId());
        Assert.assertTrue(newIpReviewVersion.getIpReviewActivities().get(0).getSequenceNumber().equals(2));
    }
    
    private VersioningService getVersioningService() {
        if (versioningService == null) {
            versioningService = KcServiceLocator.getService(VersioningService.class);
        }
        return versioningService;
    }

}
