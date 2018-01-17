/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.common.framework.impl;

import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

import java.io.Serializable;

/**
 * A line item object to be used by LineItemTable which represents an amount.  The line item objects are matched
 * by the table for row by lineItemId, so the lineItemId MUST match across Periods to create a row.
 *
 * @author Kuali Coeus
 */
public class LineItemObject extends LineItem implements Serializable {

    private static final long serialVersionUID = 2763265895600649723L;

    private String lineItemId;
    private String name;

    private ScaleTwoDecimal amount;

    public LineItemObject(String lineItemId, String name, ScaleTwoDecimal amount) {
        this.lineItemId = lineItemId;
        this.name = name;
        this.amount = amount;
    }

    /**
     * The id of the lineItem, should be unique per a period but match for line items across multiple periods
     *
     * @return the line item id
     */
    public String getLineItemId() {
        return lineItemId;
    }

    /**
     * @see #getLineItemId()
     */
    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }

    /**
     * The name of the line item that will be displayed
     *
     * @return the name that will be displayed for this line item
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
     * The amount in ScaleTwoDecimal format
     *
     * @return the amount
     */
    public ScaleTwoDecimal getAmount() {
        return amount;
    }

    /**
     * @see #getAmount()
     */
    public void setAmount(ScaleTwoDecimal amount) {
        this.amount = amount;
    }
}
