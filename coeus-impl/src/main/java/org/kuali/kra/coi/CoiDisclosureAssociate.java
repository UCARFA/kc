/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.version.sequence.associate.SequenceAssociate;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.award.AwardAssociate;

public class CoiDisclosureAssociate extends KcPersistableBusinessObjectBase implements SequenceAssociate<CoiDisclosure> {


    private static final long serialVersionUID = 4604078758009003461L;

    private String coiDisclosureNumber;
    private Integer sequenceNumber;
    private CoiDisclosure coiDisclosure;
    private Long coiDisclosureId;

    
    public Long getCoiDisclosureId() {
        return coiDisclosureId;
    }

    public void setCoiDisclosureId(Long coiDisclosureId) {
        this.coiDisclosureId = coiDisclosureId;
    }

    public CoiDisclosureAssociate(CoiDisclosure coiDisclosure) {
        this.coiDisclosure = coiDisclosure;
    }

    public CoiDisclosureAssociate() {
        super();
    }
    
    public void setCoiDisclosure(CoiDisclosure coiDisclosure) {
        this.coiDisclosure = coiDisclosure;
        if (coiDisclosure != null) {
            setSequenceNumber(coiDisclosure.getSequenceNumber());
            setCoiDisclosureNumber(coiDisclosure.getCoiDisclosureNumber());
        } else {
            setSequenceNumber(0);
            setCoiDisclosureNumber("");
        }
    }
    
    public String getCoiDisclosureNumber() {
        if ((StringUtils.isBlank(coiDisclosureNumber) ||  coiDisclosure != null && StringUtils.isNotBlank(coiDisclosure.getCoiDisclosureNumber()))) {
            setCoiDisclosureNumber(coiDisclosure.getCoiDisclosureNumber());
        }
        return coiDisclosureNumber;    
     }


    public void setCoiDisclosureNumber(String coiDisclosureNumber) {
        this.coiDisclosureNumber = coiDisclosureNumber;
    }


    public CoiDisclosure getCoiDisclosure() {
        return coiDisclosure;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((coiDisclosureNumber == null) ? 0 : coiDisclosureNumber.hashCode());
        result = PRIME * result + ((sequenceNumber == null) ? 0 : sequenceNumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AwardAssociate)) {
            return false;
        }
        CoiDisclosureAssociate other = (CoiDisclosureAssociate) obj;
        if (coiDisclosureNumber == null) {
            if (other.coiDisclosureNumber != null) {
                return false;
            }
        } else if (!coiDisclosureNumber.equals(other.coiDisclosureNumber)) {
            return false;
        }
        if (sequenceNumber == null) {
            if (other.sequenceNumber != null) {
                return false;
            }
        } else if (!sequenceNumber.equals(other.sequenceNumber)) {
            return false;
        }
        return true;
    }

    @Override
    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    @Override
    public void resetPersistenceState() {

        
    }


    @Override
    public CoiDisclosure getSequenceOwner() {
        return getCoiDisclosure();
    }

    /*
     * thisi s called before setting coiDisclosure
     */
    @Override
    public void setSequenceOwner(CoiDisclosure newlyVersionedOwner) {
        setCoiDisclosure(newlyVersionedOwner);      
    }

}
