/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.specialapproval.approvedequipment;


import org.kuali.kra.award.AwardForm;

import java.io.Serializable;

/**
 * This class supports the AwardForm class
 */
public class ApprovedEquipmentBean extends SpecialApprovalBean implements Serializable {
    private EquipmentCapitalizationMinimumLoader capitalizationMinimumLoader;
    private AwardApprovedEquipment newAwardApprovedEquipment;
    /**
     * Constructs a ApprovedEquipmentBean
     * @param parent
     */
    public ApprovedEquipmentBean(AwardForm form) {
        this(form, new EquipmentCapitalizationMinimumLoader());
    }
    
    /**
     * Constructs a ApprovedEquipmentBean
     * @param parent
     */
    ApprovedEquipmentBean(AwardForm form, EquipmentCapitalizationMinimumLoader capitalizationMinimumLoader) {
        super(form);
        this.capitalizationMinimumLoader = capitalizationMinimumLoader;
        init();
    }
    
    /**
     * This method is called when adding a new apprved equipment item
     * @param formHelper
     * @return
     */
    public boolean addApprovedEquipmentItem() {
        AddAwardApprovedEquipmentRuleEvent event = generateAddEvent();
        boolean success = new AwardApprovedEquipmentRuleImpl().processAddAwardApprovedEquipmentBusinessRules(event);
        if(success){
            getAward().add(getNewAwardApprovedEquipment());
            init();
        }
        return success;
    }

    /**
     * This method delets a selected equipment item
     * @param formHelper
     * @param deletedItemIndex
     */
    public void deleteApprovedEquipmentItem(int deletedItemIndex) {
        removeCollectionItem(getAward().getApprovedEquipmentItems(), deletedItemIndex);
    }
    

    public Object getData() {
        return getNewAwardApprovedEquipment();
    }
    
    /**
     * Gets the newAwardApprovedEquipment attribute. 
     * @return Returns the newAwardApprovedEquipment.
     */
    public AwardApprovedEquipment getNewAwardApprovedEquipment() {
        return newAwardApprovedEquipment;
    }

    /**
     * Sets the newAwardApprovedEquipment attribute value.
     * @param newAwardApprovedEquipment The newAwardApprovedEquipment to set.
     */
    void setNewAwardApprovedEquipment(AwardApprovedEquipment newAwardApprovedEquipment) {
        this.newAwardApprovedEquipment = newAwardApprovedEquipment;
    }
    
    /**
     * This method generates an Add Event
     * @return
     */
    AddAwardApprovedEquipmentRuleEvent generateAddEvent() {        
        AddAwardApprovedEquipmentRuleEvent event = new AddAwardApprovedEquipmentRuleEvent(
                                                            "newAwardApprovedEquipment",
                                                            getAwardDocument(),
                                                            getAward(),
                                                            getNewAwardApprovedEquipment(),
                                                            capitalizationMinimumLoader.getMinimumCapitalization());
        return event;
    }

    /**
     * Initialize subform
     */
    private void init() {
        newAwardApprovedEquipment = new AwardApprovedEquipment(); 
    }
}
