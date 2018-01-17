/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.impl.sponsor.SponsorHierarchyMaintenanceService;
import org.kuali.coeus.common.impl.sponsor.SponsorHierarchyMaintenanceServiceImpl;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
/**
 * This class tests KraPersistableBusinessObjectBase.
 */
public class SponsorHierarchyMaintenanceServiceImplTest extends KcIntegrationTestBase {

    private static final String TEST_SPONSOR_CODE = "005891";
    private static final String TEST_SPONSOR_NAME = "Baystate Medical Center";
    private static final String INVALID_SPONSOR_CODE = "XXXX";
    private static final String TOP_SPONSOR_HIERARCHY = "Administering Activity;1;COI Disclosures;1;NIH Multiple PI;1;NIH Other Significant Contributor;1;Printing;1;Routing;1;Sponsor Groups";
    private SponsorHierarchyMaintenanceService sponsorService;
    
    @Before
    public void setUp() throws Exception {
        sponsorService = this.getRegularSponsorService();
    }
    @After
    public void tearDown() throws Exception {
        sponsorService = null;
    }

    @Test
    public void testNotEmptyGetTopSponsorHierarch() {
        sponsorService = this.getRegularSponsorService();
        assertEquals(TOP_SPONSOR_HIERARCHY, sponsorService.getTopSponsorHierarchy()); 
    }
    @Test
    public void testEmptyGetTopSponsorHierarch() {
        sponsorService = this.getEmptySponsorService();
        assertEquals("", sponsorService.getTopSponsorHierarchy()); 
    }
    private SponsorHierarchyMaintenanceService getEmptySponsorService() {
        return new SponsorHierarchyMaintenanceServiceImpl() {
            @Override
            public Collection getTopSponsorHierarchyList(){
                return new ArrayList();
            }
        };
    }
    private SponsorHierarchyMaintenanceService getRegularSponsorService() {
        return KcServiceLocator.getService(SponsorHierarchyMaintenanceService.class);
    }


}
