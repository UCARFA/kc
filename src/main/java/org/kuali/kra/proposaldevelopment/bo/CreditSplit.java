/*
 * Copyright 2006-2009 The Kuali Foundation
 * 
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.osedu.org/licenses/ECL-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.kra.proposaldevelopment.bo;

import org.kuali.rice.kns.bo.BusinessObject;
import org.kuali.rice.kns.util.KualiDecimal;

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
     * @return KualiDecimal
     */ 
    public KualiDecimal getCredit();

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
}
