/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home.approvedsubawards;

import org.kuali.kra.award.AwardForm;
import org.kuali.kra.award.document.AwardDocument;

import java.io.Serializable;


public class ApprovedSubawardFormHelper implements Serializable {
    
    private AwardForm parent;
    
    private AwardApprovedSubaward newAwardApprovedSubaward;
    
    /**
     * Constructs a ApprovedSubawardFormHelper
     * @param parent
     */
    public ApprovedSubawardFormHelper(AwardForm parent) {
        this.parent = parent;
        this.newAwardApprovedSubaward = new AwardApprovedSubaward();
    }
    
    /**
     * Initialize subform
     */
    public void init() {
        newAwardApprovedSubaward = new AwardApprovedSubaward(); 
    }

    /**
     * Gets the newAwardApprovedSubaward attribute. 
     * @return Returns the newAwardApprovedSubaward.
     */
    public AwardApprovedSubaward getNewAwardApprovedSubaward() {
        return newAwardApprovedSubaward;
    }

    /**
     * Sets the newAwardApprovedSubaward attribute value.
     * @param newAwardApprovedSubaward The newAwardApprovedSubaward to set.
     */
    public void setNewAwardApprovedSubaward(AwardApprovedSubaward newAwardApprovedSubaward) {
        this.newAwardApprovedSubaward = newAwardApprovedSubaward;
    }

    public AwardDocument getAwardDocument() {
        return parent.getAwardDocument();
    }

    public Object getData() {
        return getNewAwardApprovedSubaward();
    }
}

