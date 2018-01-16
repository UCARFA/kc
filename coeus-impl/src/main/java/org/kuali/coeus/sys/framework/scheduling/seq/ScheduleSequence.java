/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.scheduling.seq;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ScheduleSequence {
        
    public static final String NAME = "t";
    
    public static final String GROUP = "g";
    
    public static final String JOBNAME = "j";
    
    public static final String JOBGROUP = "g";
    
    /**
     * This method expects to generate list of dates between start and end date using cron expression.
     * 
     * @param expression can be any valid CronExpression.
     * @param startDate, is expression's begin date.
     * @param endDate, is expression's end date.
     * @return list of dates is returned.
     * @throws ParseException can thrown in case of invalid expression.
     */
    public List<Date> executeScheduleSequence(String expression, Date startDate, Date endDate) throws ParseException;

}
