/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.web.struts.form.schedule;

import org.junit.Test;
import org.kuali.coeus.common.committee.impl.web.struts.form.schedule.ScheduleData;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ScheduleDataTest {
    
    public static final String RECURRENCE_TYPE = "WEEKLY";
    
    /**
     * This method test's the style class Map. 
     */
    @Test
    public void testPopulateStyleClass() {
        
        ScheduleData data = new ScheduleData();
        
        Map<String, String> mapbefore = data.getStyleClasses();
        assertEquals(ScheduleData.BLOCK, mapbefore.get("NEVER"));
        assertEquals(ScheduleData.NONE, mapbefore.get("DAILY"));
        assertEquals(ScheduleData.NONE, mapbefore.get("WEEKLY"));
        assertEquals(ScheduleData.NONE, mapbefore.get("MONTHLY"));
        assertEquals(ScheduleData.NONE, mapbefore.get("YEARLY"));
        
        data.setRecurrenceType(RECURRENCE_TYPE);
        data.populateStyleClass();        
        
        Map<String, String> mapAfter = data.getStyleClasses();
        assertEquals(ScheduleData.NONE, mapAfter.get("NEVER"));
        assertEquals(ScheduleData.NONE, mapAfter.get("DAILY"));
        assertEquals(ScheduleData.BLOCK, mapAfter.get("WEEKLY"));
        assertEquals(ScheduleData.NONE, mapAfter.get("MONTHLY"));
        assertEquals(ScheduleData.NONE, mapAfter.get("YEARLY"));
        
    }
}
