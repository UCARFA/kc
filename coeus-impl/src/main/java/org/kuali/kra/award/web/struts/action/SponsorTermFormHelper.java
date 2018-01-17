/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.web.struts.action;

import org.kuali.coeus.common.framework.sponsor.term.SponsorTerm;
import org.kuali.kra.award.AwardForm;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.rice.core.api.util.KeyValue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a helper class for sponsor term form helper
 */
public class SponsorTermFormHelper implements Serializable {

    private AwardForm parent;
    
    private List<SponsorTerm> newSponsorTerms;
    private List<KeyValue> sponsorTermTypes;
    
    /**
     * Constructs a CostShareFormHelper
     * @param parent
     */
    public SponsorTermFormHelper(AwardForm parent) {
        this.parent = parent;
        setNewSponsorTerms(new ArrayList<SponsorTerm>());
        sponsorTermTypes = new ArrayList<KeyValue>();
    }
    
    /**
     * Initialize subform
     */
    public void init() {
        newSponsorTerms = new ArrayList<SponsorTerm>();
    }

    /**
     * Gets the newSponsorTerms attribute. 
     * @return Returns the newSponsorTerms.
     */
    public List<SponsorTerm> getNewSponsorTerms() {
        return newSponsorTerms;
    }



    /**
     * Sets the newAwardSponsorTerms attribute value.
     * @param newAwardSponsorTerms The newAwardSponsorTerms to set.
     */
    public void setNewSponsorTerms(List<SponsorTerm> newSponsorTerms) {
        this.newSponsorTerms = newSponsorTerms;
    }
    
    /**
     * Gets the awardSponsorTermsTypes attribute. 
     * @return Returns the awardSponsorTermsTypes.
     */
    public List<KeyValue> getSponsorTermTypes() {
        return sponsorTermTypes;
    }
    
    /**
     * Sets the awardSponsorTermsTypes attribute value.
     * @param awardSponsorTermsTypes The awardSponsorTermsTypes to set.
     */
    public void setSponsorTermTypes(List<KeyValue> sponsorTermTypes) {
        this.sponsorTermTypes = sponsorTermTypes;
    }



    /**
     * This method returns the AwardDocument.
     * @return
     */
    public AwardDocument getAwardDocument() {
        return parent.getAwardDocument();
    }
    
    
}
