/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person.creditsplit;

import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.rice.krad.bo.BusinessObject;

/**
 * Used to describe a <code>{@link BusinessObject}</code> that represents a credit split. 
 *
 * @author $Author: gmcgrego $
 * @version $Revision: 1.4 $
 */
public interface CreditSplit {
    
    /**
     * Get the value of the split
     *
     * @return ScaleTwoDecimal
     */ 
    public ScaleTwoDecimal getCredit();

    /**
     * Gets the value of invCreditTypeCode
     *
     * @return the value of invCreditTypeCode
     */
    public String getInvCreditTypeCode();

    /**
     * Sets the value of invCreditTypeCode
     *
     * @param argInvCreditTypeCode Value to assign to this.invCreditTypeCode
     */
    public void setInvCreditTypeCode(String argInvCreditTypeCode);

    public void setCredit(ScaleTwoDecimal credit);
}
