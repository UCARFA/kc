/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.common.framework.impl;

import java.io.Serializable;

/**
 * A group which contains lineItemObjects, representing a grouping (or heading) within the table.
 * It does not have its own amount.
 *
 * @author Kuali Coeus
 */
public class LineItemGroup extends LineItem implements Serializable {

    private static final long serialVersionUID = -2168538625791958767L;

    private String groupName;
    private boolean calculateGroupSubTotal;

    public LineItemGroup(String groupName, boolean calculateGroupSubTotal) {
        this.groupName = groupName;
        this.calculateGroupSubTotal = calculateGroupSubTotal;
    }

    /**
     * The name of the group which will as shown in the table
     *
     * @return
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @see LineItemGroup#getGroupName()
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * True if a subtotal will be automatically calculated for this group, false otherwise
     *
     * @return true if a subtotal will be calcuated, false otherwise
     */
    public boolean isCalculateGroupSubTotal() {
        return calculateGroupSubTotal;
    }

    /**
     * @see LineItemGroup#isCalculateGroupSubTotal()
     */
    public void setCalculateGroupSubTotal(boolean calculateGroupSubTotal) {
        this.calculateGroupSubTotal = calculateGroupSubTotal;
    }
}
