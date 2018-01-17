/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.submit;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test the CheckListService implementation.
 */
@RunWith(JMock.class)
public class CheckListServiceTest {

    private CheckListServiceImpl checkListService;
    private Mockery context = new JUnit4Mockery() {{ setThreadingPolicy(new Synchroniser()); }};
    
    @Before
    public void setUp() {
        checkListService = new CheckListServiceImpl();
    }
    
    /**
     * Test getting the list of Expedited Reviews.
     */
    @Test
    public void testExpeditedReviews() {
        final Collection<ExpeditedReviewCheckListItem> list = new ArrayList<ExpeditedReviewCheckListItem>();
        list.add(new ExpeditedReviewCheckListItem());
        list.add(new ExpeditedReviewCheckListItem());
        
        final BusinessObjectService businessObjectService = context.mock(BusinessObjectService.class);
        context.checking(new Expectations() {{
            one(businessObjectService).findAll(ExpeditedReviewCheckListItem.class); will(returnValue(list));
        }});
        checkListService.setBusinessObjectService(businessObjectService);
        
        List<ExpeditedReviewCheckListItem> items = checkListService.getExpeditedReviewCheckList();
        assertEquals(list.size(), items.size());
        for (ExpeditedReviewCheckListItem item : items) {
            assertTrue(list.contains(item));
        }
    }
    
    /**
     * Test getting the list of Exempt Studies.
     */
    @Test
    public void testExemptStudies() {
        final Collection<ExemptStudiesCheckListItem> list = new ArrayList<ExemptStudiesCheckListItem>();
        list.add(new ExemptStudiesCheckListItem());
        list.add(new ExemptStudiesCheckListItem());
        
        final BusinessObjectService businessObjectService = context.mock(BusinessObjectService.class);
        context.checking(new Expectations() {{
            one(businessObjectService).findAll(ExemptStudiesCheckListItem.class); will(returnValue(list));
        }});
        checkListService.setBusinessObjectService(businessObjectService);
        
        List<ExemptStudiesCheckListItem> items = checkListService.getExemptStudiesCheckList();
        assertEquals(list.size(), items.size());
        for (ExemptStudiesCheckListItem item : items) {
            assertTrue(list.contains(item));
        }
    }
}
