/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.rate;

import org.kuali.coeus.common.budget.framework.rate.AbstractInstituteRate;

/**
* This rule checks that an institute rate type &amp; rate class are valid for the specific maintenance document.
* <p>
* For example: if dealing with a LA rate maintenance document then that document can only contain an
* <strong>LA</strong> rate type &amp; <strong>LA</strong> rate class.
* </p>
*/
public interface InstituteRateRateTypeRateClassRule extends org.kuali.rice.krad.rules.rule.BusinessRule {

    /**
     * Validates if the rate type code and rate type class are valid for the AbstractInstituteRate rate type.
     * @param rate the AbstractInstituteRate to check
     * @return true is valid
     * @throws NullPointerException if rate is null
     */
    public abstract boolean validateRateTypeAndRateClass(final AbstractInstituteRate rate);

}
