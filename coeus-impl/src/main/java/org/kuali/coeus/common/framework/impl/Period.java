/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.common.framework.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A period which can contain LineItemGroups, represents a column of data in the LineItemTable component.
 *
 * @author Kuali Coeus
 */
public class Period implements Serializable{

    private static final long serialVersionUID = -8093204750065415832L;

    private String name;
    private List<LineItemGroup> lineItemGroups;
    private Date startDate;
    private Date endDate;

    public Period(String name) {
        this.name = name;
        lineItemGroups = new ArrayList<LineItemGroup>();
    }

    /**
     * The name of the period, this is what will be displayed in the ui.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @see #getName()
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The LineItemGroups of this period (ex: personnel, non-personnel, totals)
     *
     * @return the LineItemGroups
     */
    public List<LineItemGroup> getLineItemGroups() {
        return lineItemGroups;
    }

    /**
     * @see #getLineItemGroups()
     */
    public void setLineItemGroups(List<LineItemGroup> lineItemGroups) {
        this.lineItemGroups = lineItemGroups;
    }

    /**
     * The start date of the period.
     *
     * @return start date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @see #getStartDate()
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * The end date of the period.
     *
     * @return start date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @see #getEndDate()
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
