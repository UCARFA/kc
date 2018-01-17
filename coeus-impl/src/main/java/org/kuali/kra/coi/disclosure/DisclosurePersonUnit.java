/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.disclosure;

import org.kuali.coeus.common.framework.version.sequence.associate.SequenceAssociate;
import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.kra.coi.DisclosureReporterUnit;

public class DisclosurePersonUnit  extends DisclosureReporterUnit implements SequenceAssociate<CoiDisclosure> {

    private Long disclosurePersonUnitsId; 
    private Long disclosurePersonId;
    private String unitNumber; 
    private boolean leadUnitFlag; 
    private String personId; 
    
//    @SkipVersioning
    private DisclosurePerson disclosurePerson;

    public Long getDisclosurePersonUnitsId() {
        return disclosurePersonUnitsId;
    }
    
    public void setDisclosurePersonUnitsId(Long disclosurePersonUnitsId) {
        this.disclosurePersonUnitsId = disclosurePersonUnitsId;
    }
    
    public Long getDisclosurePersonId() {
        return disclosurePersonId;
    }
    
    public void setDisclosurePersonId(Long disclosurePersonId) {
        this.disclosurePersonId = disclosurePersonId;
    }
    
    @Override
    public String getUnitNumber() {
        return unitNumber;
    }
    
    @Override
    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }
    
    @Override
    public boolean isLeadUnitFlag() {
        return leadUnitFlag;
    }
    
    @Override
    public void setLeadUnitFlag(boolean leadUnitFlag) {
        this.leadUnitFlag = leadUnitFlag;
    }
    
    public String getPersonId() {
        return personId;
    }
    
    public void setPersonId(String personId) {
        this.personId = personId;
    }
    
    public DisclosurePerson getDisclosurePerson() {
        return disclosurePerson;
    }
    
    public void setDisclosurePerson(DisclosurePerson disclosurePerson) {
        this.disclosurePerson = disclosurePerson;
    }
    
    @Override
    public Long getReporterUnitId() {

        return getDisclosurePersonUnitsId();
    }
    
    @Override
    public Integer getSequenceNumber() {

        return null;
    }
    
    @Override
    public void resetPersistenceState() {
        this.setDisclosurePersonUnitsId(null);
                
    }
    
    @Override
    public void setSequenceOwner(CoiDisclosure newlyVersionedOwner) {
        this.getDisclosurePerson().setCoiDisclosure(newlyVersionedOwner);   
                
    }
    
    @Override
    public CoiDisclosure getSequenceOwner() {

        return this.getDisclosurePerson().getCoiDisclosure();
    }



}
