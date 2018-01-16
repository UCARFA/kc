/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.species.exception.rule;

import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * This class adds rule for adding new <code>ProtocolException</code> object
 */
public interface AddProtocolExceptionRule extends BusinessRule {
    
    /**
     * This method evaluates to true if ProtocolException objects satisfy required fields and business rules.
     * @param addProtocolExceptionEvent
     * @return boolean true for valid object and false for invalid entry
     */
    public boolean processAddProtocolExceptionBusinessRules(AddProtocolExceptionEvent addProtocolExceptionEvent);
    
}
