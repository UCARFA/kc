/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.sponsor.term;


import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * This class is business object representation of a Sponsor Term Type.
 */
public class SponsorTermType extends KcPersistableBusinessObjectBase {


    private static final long serialVersionUID = -6111334757622425480L;

    private String sponsorTermTypeCode;

    private String description;


    public SponsorTermType() {
    }

    /**
     * Gets the sponsorTermTypeCode attribute. 
     * @return Returns the sponsorTermTypeCode.
     */
    public String getSponsorTermTypeCode() {
        return sponsorTermTypeCode;
    }

    /**
     * Sets the sponsorTermTypeCode attribute value.
     * @param sponsorTermTypeCode The sponsorTermTypeCode to set.
     */
    public void setSponsorTermTypeCode(String sponsorTermTypeCode) {
        this.sponsorTermTypeCode = sponsorTermTypeCode;
    }

    /**
     * Gets the description attribute. 
     * @return Returns the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description attribute value.
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((sponsorTermTypeCode == null) ? 0 : sponsorTermTypeCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        SponsorTermType other = (SponsorTermType) obj;
        if (description == null) {
            if (other.description != null) return false;
        } else if (!description.equals(other.description)) return false;
        if (sponsorTermTypeCode == null) {
            if (other.sponsorTermTypeCode != null) return false;
        } else if (!sponsorTermTypeCode.equals(other.sponsorTermTypeCode)) return false;
        return true;
    }
}
