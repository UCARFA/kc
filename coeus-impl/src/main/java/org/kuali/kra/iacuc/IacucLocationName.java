/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class IacucLocationName extends KcPersistableBusinessObjectBase {
    
    private static final long serialVersionUID = 1L;

    private Integer locationId; 
    private String locationName; 
    private Integer locationTypeCode; 
    
    private IacucLocationType iacucLocationType;
    
    public IacucLocationName() { 

    } 
    
    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Integer getLocationTypeCode() {
        return locationTypeCode;
    }

    public void setLocationTypeCode(Integer locationTypeCode) {
        this.locationTypeCode = locationTypeCode;
    }

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.locationId == null) ? 0 : this.locationId.hashCode());
        result = prime * result + ((this.locationName == null) ? 0 : this.locationName.hashCode());
        result = prime * result + ((this.locationTypeCode == null) ? 0 : this.locationTypeCode.hashCode());
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
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        IacucLocationName other = (IacucLocationName) obj;
        if (this.locationId == null) {
            if (other.locationId != null) {
                return false;
            }
        } else if (!this.locationId.equals(other.locationId)) {
            return false;
        }
        if (this.locationName == null) {
            if (other.locationName != null) {
                return false;
            }
        } else if (!this.locationName.equals(other.locationName)) {
            return false;
        }
        if (this.locationTypeCode == null) {
            if (other.locationTypeCode != null) {
                return false;
            }
        } else if (!this.locationTypeCode.equals(other.locationTypeCode)) {
            return false;
        }
        return true;
    }

    public IacucLocationType getIacucLocationType() {
        return iacucLocationType;
    }

    public void setIacucLocationType(IacucLocationType iacucLocationType) {
        this.iacucLocationType = iacucLocationType;
    }

}
