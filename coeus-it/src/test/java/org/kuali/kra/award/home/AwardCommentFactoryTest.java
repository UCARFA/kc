/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;

/**
 * 
 * This class tests methods in Award.java class
 */
public class AwardCommentFactoryTest extends KcIntegrationTestBase {
    
    private AwardCommentFactory awardCommentFactory;
    
    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        awardCommentFactory = new AwardCommentFactory();
    }

    /**
     *
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        awardCommentFactory = null;
    }

    /**
     * 
     * This method tests that createCostShareAwardComment creates an AwardComment object and that the
     * commentTypeCode is set to the correct constant value
     * @throws Exception
     */
    @Test
    public void testCreateCostShareComment() throws Exception { 
        AwardComment awardComment = awardCommentFactory.createCostShareComment();
        Assert.assertTrue(awardComment instanceof AwardComment);
        Assert.assertEquals(Constants.COST_SHARE_COMMENT_TYPE_CODE, awardComment.getCommentTypeCode());
    }
    
    /**
     * 
     * This method tests that createFandaRateComment creates an AwardComment object and that the
     * commentTypeCode is set to the correct constant value
     * @throws Exception
     */
    @Test
    public void testCreateFandaRateComment() throws Exception { 
        AwardComment awardComment = awardCommentFactory.createFandaRateComment();
        Assert.assertTrue(awardComment instanceof AwardComment);
        Assert.assertEquals(Constants.FANDA_RATE_COMMENT_TYPE_CODE, awardComment.getCommentTypeCode());
    }
    
    /**
     * 
     * This method tests that createFandaRateComment creates an AwardComment object and that the
     * commentTypeCode is set to the correct constant value
     * @throws Exception
     */
    @Test
    public void testCreatePreAwardSponsorAuthorizationComment() throws Exception { 
        AwardComment awardComment = awardCommentFactory.createPreAwardSponsorAuthorizationComment();
        Assert.assertTrue(awardComment instanceof AwardComment);
        Assert.assertEquals(Constants.PREAWARD_SPONSOR_AUTHORIZATION_COMMENT_TYPE_CODE, awardComment.getCommentTypeCode());
    }
    
    /**
     * 
     * This method tests that createFandaRateComment creates an AwardComment object and that the
     * commentTypeCode is set to the correct constant value
     * @throws Exception
     */
    @Test
    public void testCreatePreAwardInstitutionalAuthorizationComment() throws Exception { 
        AwardComment awardComment = awardCommentFactory.createPreAwardInstitutionalAuthorizationComment();
        Assert.assertTrue(awardComment instanceof AwardComment);
        Assert.assertEquals(Constants.PREAWARD_INSTITUTIONAL_AUTHORIZATION_COMMENT_TYPE_CODE, awardComment.getCommentTypeCode());
    }
    
}
