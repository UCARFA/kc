/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.common.framework.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * The LineItem abstract class for LineItemTable.  LineItem objects can contain line items themselves.
 */
public abstract class LineItem {
    private List<LineItemObject> lineItems = new ArrayList<LineItemObject>();

    /**
     * The line item objects which are children of this line item, their total summed amounts should equal
     * this line item's amount, as this is not calculated by the table.
     *
     * @return the LineItemObjects of this LineItem
     */
    public List<LineItemObject> getLineItems() {
        return lineItems;
    }

    /**
     * @see #getLineItems()
     */
    public void setLineItems(List<LineItemObject> lineItems) {
        this.lineItems = lineItems;
    }
}
