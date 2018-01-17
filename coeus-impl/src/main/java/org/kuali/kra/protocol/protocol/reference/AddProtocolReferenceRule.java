/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.protocol.reference;

import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * This class adds rule for adding new <code>ProtocolReferenceBase</code> object
 */
public interface AddProtocolReferenceRule extends BusinessRule {
    
    /**
     * This method evaluates to true if ProcotcolReference objects satisfy required fields and business rules.
     * @param addProtocolReferenceEvent
     * @return boolean true for valid object and false for invalid entry
     */
    public boolean processAddProtocolReferenceBusinessRules(AddProtocolReferenceEventBase addProtocolReferenceEvent);
    
}
