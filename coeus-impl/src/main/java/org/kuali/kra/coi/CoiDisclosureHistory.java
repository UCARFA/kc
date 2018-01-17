/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * 
 * This class is the bo class of coi disclosure history
 */
public class CoiDisclosureHistory extends KcPersistableBusinessObjectBase {
    


    private static final long serialVersionUID = 6373301098038646558L;
    private Long coiDisclosureHistoryId; 
    private Long coiDisclosureId; 
    private String coiDisclosureNumber; 
    private Integer sequenceNumber; 
    private String disclosureStatus; 
    private String disclosureDispositionStatus; 
    private CoiDisclosure coiDisclosure;
    
    
    public CoiDisclosureHistory() { 

    } 
    
    public String getCoiDisclosureNumber() {
        return coiDisclosureNumber;
    }

    public void setCoiDisclosureNumber(String coiDisclosureNumber) {
        this.coiDisclosureNumber = coiDisclosureNumber;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getDisclosureStatus() {
        return disclosureStatus;
    }

    public void setDisclosureStatus(String disclosureStatus) {
        this.disclosureStatus = disclosureStatus;
    }

    public String getDisclosureDispositionStatus() {
        return disclosureDispositionStatus;
    }

    public void setDisclosureDispositionStatus(String disclosureDispositionStatus) {
        this.disclosureDispositionStatus = disclosureDispositionStatus;
    }

    public Long getCoiDisclosureHistoryId() {
        return coiDisclosureHistoryId;
    }

    public void setCoiDisclosureHistoryId(Long coiDisclosureHistoryId) {
        this.coiDisclosureHistoryId = coiDisclosureHistoryId;
    }

    public Long getCoiDisclosureId() {
        return coiDisclosureId;
    }

    public void setCoiDisclosureId(Long coiDisclosureId) {
        this.coiDisclosureId = coiDisclosureId;
    }
    
    public CoiDisclosure getCoiDisclosure() {
        return coiDisclosure;
    }

    public void setCoiDisclosure(CoiDisclosure coiDisclosure) {
        this.coiDisclosure = coiDisclosure;
    }
    
}
