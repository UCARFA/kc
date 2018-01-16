/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.negotiations;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.negotiations.bo.Negotiation;

/**
 * This class handles the legacy sequenceNumber/awardNumber data from Coeus
 */
public class NegotiationAssociate extends KcPersistableBusinessObjectBase {


    private static final long serialVersionUID = -3915267055124592134L;

    private String negotiationNumber;

    private Negotiation negotiation;

    /**
     * Gets the proposalNumber attribute. 
     * @return Returns the proposalNumber.
     */
    public String getNegotiationNumber() {
        return negotiationNumber;
    }

    /**
     * Sets the proposalNumber attribute value.
     * @param proposalNumber The proposalNumber to set.
     */
    public void setNegotiationNumber(String negotiationNumber) {
        this.negotiationNumber = negotiationNumber;
    }

    /**
     * Gets the negotiations attribute. 
     * @return Returns the negotiations.
     */
    public Negotiation getNegotiation() {
        return negotiation;
    }

    /**
     * Sets the negotiation attribute value.
     * @param negotiation The negotiation to set.
     */
    public void setNegotiation(Negotiation negotiation) {
        this.negotiation = negotiation;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof NegotiationAssociate)) {
            return false;
        }
        NegotiationAssociate other = (NegotiationAssociate) obj;
        if (negotiationNumber == null) {
            if (other.negotiationNumber != null) {
                return false;
            }
        } else if (!negotiationNumber.equals(other.negotiationNumber)) {
            return false;
        }
        return true;
    }
}
