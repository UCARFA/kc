/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.customdata;

import org.kuali.coeus.common.framework.custom.DocumentCustomData;
import org.kuali.coeus.common.framework.custom.attr.CustomAttribute;
import org.kuali.kra.subaward.bo.SubAwardAssociate;


public class SubAwardCustomData extends SubAwardAssociate implements DocumentCustomData {

    private static final long serialVersionUID = 4125090813618033094L;

    private Long subAwardCustomDataId;

    private String value;

    private Long customAttributeId;
    private CustomAttribute customAttribute;
    private String subAwardCode; 


    /**
     * Gets the customAttributeId attribute.
     * @return Returns the customAttributeId.
     */
    @Override
    public Long getCustomAttributeId() {
        return customAttributeId;
    }

    /**
     * Sets the customAttributeId attribute value.
     * @param customAttributeId The customAttributeId to set.
     */
    @Override
    public void setCustomAttributeId(Long customAttributeId) {
        this.customAttributeId = customAttributeId;
    }
    
    /**
     * Need this function to get along with with the custom data framework, this can be removed after this class has been refactored
     * @return customAttributeId
     */
    public Long getId() {
        return customAttributeId;
    }
    
    /**
     * Need this function to get along with with the custom data framework, this can be removed after this class has been refactored
     * @param customAttributeId
     */
    public void setId(Long customAttributeId) {
        this.customAttributeId = customAttributeId;
    }

    /**
     * Gets the subAwardCustomDataId attribute. 
     * @return Returns the subAwardCustomDataId.
     */
    public Long getSubAwardCustomDataId() {
        return subAwardCustomDataId;
    }

    /**
     * Sets the SubAwardCustomDataId attribute value.
     * @param subAwardCustomDataId The subAwardCustomDataId to set.
     */
    public void setSubAwardCustomDataId(Long subAwardCustomDataId) {
        this.subAwardCustomDataId = subAwardCustomDataId;
    }

    /**
     * Gets the value attribute.
     * @return Returns the value.
     */
    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void resetPersistenceState() {
        this.subAwardCustomDataId = null;
    }

    /**
     * Sets the value attribute value.
     * @param value The value to set.
     */
    @Override
    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((subAwardCustomDataId == null)
        ? 0 : subAwardCustomDataId.hashCode());
        result = prime * result + ((customAttribute == null)
        ? 0 : customAttribute.hashCode());
        result = prime * result + ((customAttributeId == null)
        ? 0 : customAttributeId.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
            }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SubAwardCustomData other = (SubAwardCustomData) obj;
        if (subAwardCustomDataId == null) {
            if (other.subAwardCustomDataId != null) {
                return false;
        }
        } else if (!subAwardCustomDataId.equals(other.subAwardCustomDataId)) {
            return false;
        }
        if (customAttribute == null) {
            if (other.customAttribute != null) {
                return false;
        }
        } else if (!customAttribute.equals(other.customAttribute)) {
            return false;
        }
        if (customAttributeId == null) {
            if (other.customAttributeId != null) {
                return false;
        }
        } else if (!customAttributeId.equals(other.customAttributeId)) {
            return false;
        }
        if (value == null) {
            if (other.value != null) {
                return false;
            }
        } else if (!value.equals(other.value)) {
            return false;
        }
           return true;
    }

    /**
     * Gets the customAttribute attribute.
     * @return Returns the customAttribute.
     */
    @Override
    public CustomAttribute getCustomAttribute() {
        return customAttribute;
    }

    /**
     * Sets the customAttribute attribute value.
     * @param customAttribute The customAttribute to set.
     */
    @Override
    public void setCustomAttribute(CustomAttribute customAttribute) {
        this.customAttribute = customAttribute;
    }

  /**.
	 * This is the Getter Method for subAwardCode
	 * @return Returns the subAwardCode.
	 */
	@Override
    public String getSubAwardCode() {
		return subAwardCode;
	}

	/**.
	 * This is the Setter Method for subAwardCode
	 * @param subAwardCode The subAwardCode to set.
	 */
	@Override
    public void setSubAwardCode(String subAwardCode) {
		this.subAwardCode = subAwardCode;
	}




}
