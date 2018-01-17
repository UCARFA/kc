/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.disclosure;

import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.coeus.common.framework.version.sequence.associate.SequenceAssociate;
import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.kra.coi.DisclosureReporter;
import org.kuali.kra.coi.DisclosureReporterUnit;
import org.kuali.rice.krad.util.ObjectUtils;

import java.util.List;

public class DisclosurePerson extends DisclosureReporter implements SequenceAssociate<CoiDisclosure> {
    /**
     * TODO : not sure about this table. 1. should we combine this with coi reporter/correspondent, 2. personRoleId do we need it
     **/

    private Long disclosurePersonId;
    private Long coiDisclosureId;
    private String personId;
    // private String personName;
    private String personRoleId;
    private List<DisclosurePersonUnit> disclosurePersonUnits;
    private CoiDisclosure coiDisclosure;

    public Long getDisclosurePersonId() {
        return disclosurePersonId;
    }

    public void setDisclosurePersonId(Long disclosurePersonId) {
        this.disclosurePersonId = disclosurePersonId;
    }

    public Long getCoiDisclosureId() {
        return coiDisclosureId;
    }

    public void setCoiDisclosureId(Long coiDisclosureId) {
        this.coiDisclosureId = coiDisclosureId;
    }

    @Override
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonRoleId() {
        return personRoleId;
    }

    public void setPersonRoleId(String personRoleId) {
        this.personRoleId = personRoleId;
    }

    public List<DisclosurePersonUnit> getDisclosurePersonUnits() {
        return disclosurePersonUnits;
    }

    public void setDisclosurePersonUnits(List<DisclosurePersonUnit> disclosurePersonUnits) {
        this.disclosurePersonUnits = disclosurePersonUnits;
    }

    public CoiDisclosure getCoiDisclosure() {
        return coiDisclosure;
    }

    public void setCoiDisclosure(CoiDisclosure coiDisclosure) {
        this.coiDisclosure = coiDisclosure;
    }


    @Override
    public List<? extends DisclosureReporterUnit> getDisclosureReporterUnits() {

        return getDisclosurePersonUnits();
    }

    @Override
    public Integer getSequenceNumber() {

        return null;
    }

    @Override
    public void resetPersistenceState() {
        this.setDisclosurePersonId(null);
                
    }

    @Override
    public void setSequenceOwner(CoiDisclosure newlyVersionedOwner) {
        this.setCoiDisclosure(newlyVersionedOwner);   
                
    }

    @Override
    public CoiDisclosure getSequenceOwner() {

        return this.getCoiDisclosure();
    }

    /**
     *
     * This is ahelper method to get author person name
     * @return
     */
    public String getAuthorPersonName() {
        KcPerson person = this.getKcPersonService().getKcPersonByUserName(getUpdateUser());
        return ObjectUtils.isNull(person) ? "Person not found" : person.getFullName();
    }
}
