/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.scheduling.expr;

import org.kuali.coeus.sys.framework.scheduling.util.Time24HrFmt;

import java.text.ParseException;
import java.util.Date;

/**
 * This is abstract class, expects to implement expression generation logic.
 */
public abstract class CronExpression {
    
    private Date startDate;
    
    private Time24HrFmt time;
    
    public final String SECONDS = "0";
    
    /**
     * Constructs a CronExpression.java.
     * @param startDate is begin date for schedule generation.
     * @param time which schedule date refers to.
     * @throws ParseException might be thrown if CronExpression is incorrect.
     */
    public CronExpression(Date startDate, Time24HrFmt time) throws ParseException {
        super();
        this.startDate = startDate;
        this.time = time;
    }
    
    /**
     * This method implementation must provide valid Cron Expression.
     * @return Cron Expression.
     */
    public abstract String getExpression();

    protected Date getStartDate() {
        return startDate;
    }

    protected Time24HrFmt getTime() {
        return time;
    }

}
