/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home;

import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

/**
 * This interface defines a simple behavior for valuable items
 */
public interface ValuableItem {
    /**
     * @return This method returns the value (amount) of the valuable item
     */
    public ScaleTwoDecimal getAmount();
}
