/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.person.attr;

import java.io.Serializable;

import org.kuali.coeus.common.framework.custom.DocumentCustomData;
import org.kuali.coeus.common.framework.custom.attr.CustomAttribute;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class PersonCustomData extends KcPersistableBusinessObjectBase implements DocumentCustomData, Serializable {

    private static final long serialVersionUID = 7498061394015743173L;
    
    private Long personCustomDataId;
    private String personId;
    private Long customAttributeId;
    private String value;

    private CustomAttribute customAttribute;

    public Long getPersonCustomDataId() {
        return personCustomDataId;
    }

    // putting in getter for "id" since custom data jsp/tag files are expecting it
    public Long getId() {
        return customAttributeId;
    }

    public void setPersonCustomDataId(Long personCustomDataId) {
        this.personCustomDataId = personCustomDataId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Override
    public Long getCustomAttributeId() {
        return customAttributeId;
    }

    @Override
    public void setCustomAttributeId(Long customAttributeId) {
        this.customAttributeId = customAttributeId;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public CustomAttribute getCustomAttribute() {
        return customAttribute;
    }

    @Override
    public void setCustomAttribute(CustomAttribute customAttribute) {
        this.customAttribute = customAttribute;
    }
    
}
