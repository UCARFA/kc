/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.history;

import org.kuali.rice.krad.bo.BusinessObjectBase;

import java.sql.Date;

@SuppressWarnings("serial")
public class DateRangeFilter extends BusinessObjectBase {

    private Date beginningOn;

    private Date endingOn;

    public Date getBeginningOn() {
        return beginningOn;
    }

    public void setBeginningOn(Date beginningOn) {
        this.beginningOn = beginningOn;
    }

    public Date getEndingOn() {
        return endingOn;
    }

    public void setEndingOn(Date endingOn) {
        this.endingOn = endingOn;
    }

    @Override
    public void refresh() {
    }
}
