/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.commitments;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.AwardForm;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.coeus.common.framework.costshare.CostShareFunctions;
import org.kuali.coeus.common.framework.costshare.CostShareService;

import java.io.Serializable;

/**
 * This class supports the AwardForm class
 */
public class CostShareFormHelper implements Serializable, CostShareFunctions { 
    private AwardForm parent;
    
    private AwardCostShare newAwardCostShare;
    
    /**
     * Constructs a CostShareFormHelper
     * @param parent
     */
    public CostShareFormHelper(AwardForm parent) {
        this.parent = parent;
        init();
    }
    
    /**
     * Initialize subform
     */
    public void init() {
        newAwardCostShare = new AwardCostShare(); 
    }

    /**
     * Gets the newAwardCostShare attribute. 
     * @return Returns the newAwardCostShare.
     */
    public AwardCostShare getNewAwardCostShare() {
        return newAwardCostShare;
    }

    /**
     * Sets the newAwardAwardCostShare attribute value.
     * @param newAwardAwardCostShare The newAwardAwardCostShare to set.
     */
    public void setNewAwardCostShare(AwardCostShare newAwardCostShare) {
        this.newAwardCostShare = newAwardCostShare;
    }

    public AwardDocument getAwardDocument() {
        return parent.getAwardDocument();
    }

    public Object getData() {
        return getNewAwardCostShare();
    }
    
    @Override
    public String getProjectPeriodLabel() {
        String label = KcServiceLocator.getService(CostShareService.class).getCostShareLabel();
        return label;
    }
}
