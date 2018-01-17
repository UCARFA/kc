/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.personmasschange.bo;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * Defines the fields for a Negotiation Person Mass Change.
 */
public class NegotiationPersonMassChange extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 1050126059124935240L;
    
    private long negotiationPersonMassChangeId;
    private long personMassChangeId;
    private boolean negotiator;
    
    private PersonMassChange personMassChange;

    public long getNegotiationPersonMassChangeId() {
        return negotiationPersonMassChangeId;
    }

    public void setNegotiationPersonMassChangeId(long negotiationPersonMassChangeId) {
        this.negotiationPersonMassChangeId = negotiationPersonMassChangeId;
    }

    public long getPersonMassChangeId() {
        return personMassChangeId;
    }

    public void setPersonMassChangeId(long personMassChangeId) {
        this.personMassChangeId = personMassChangeId;
    }

    public boolean isNegotiator() {
        return negotiator;
    }

    public void setNegotiator(boolean negotiator) {
        this.negotiator = negotiator;
    }
    
    public PersonMassChange getPersonMassChange() {
        return personMassChange;
    }

    public void setPersonMassChange(PersonMassChange personMassChange) {
        this.personMassChange = personMassChange;
    }

    /**
     * Determines whether this Person Mass Change is required.
     * 
     * @return true if any of the fields are true, false otherwise
     */
    public boolean requiresChange() {
        return negotiator;
    }
    
}
