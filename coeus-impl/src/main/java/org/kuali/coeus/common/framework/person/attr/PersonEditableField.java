/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.person.attr;

import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.core.api.mo.common.active.MutableInactivatable;


/**
 * Class representation of the Person <code>{@link org.kuali.rice.krad.bo.BusinessObject}</code>
 *
 * @see org.kuali.rice.krad.bo.BusinessObject
 * @see org.kuali.core.bo.PersistableBusinessObject
 * @author $Author: gmcgrego $
 * @version $Revision: 1.3 $
 */
public class PersonEditableField extends KcPersistableBusinessObjectBase implements MutableInactivatable {

    private String fieldName;

    private boolean active;

    private String moduleCode;

    private Long personEditableFieldId;

    private CoeusModule coeusModule;

    /**
     * Gets the value of fieldName
     *
     * @return the value of fieldName
     */
    public String getFieldName() {
        return this.fieldName;
    }

    /**
     * Sets the value of fieldName
     *
     * @param argFieldName Value to assign to this.fieldName
     */
    public void setFieldName(String argFieldName) {
        this.fieldName = argFieldName;
    }

    /**
     * Read access to active flag
     * @return boolean active or not
     */
    @Override
    public boolean isActive() {
        return active;
    }

    /**
     * Write access to active flag
     * @param active
     */
    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public Long getPersonEditableFieldId() {
        return personEditableFieldId;
    }

    public void setPersonEditableFieldId(Long personEditableFieldId) {
        this.personEditableFieldId = personEditableFieldId;
    }

    public CoeusModule getCoeusModule() {
        return coeusModule;
    }

    public void setCoeusModule(CoeusModule coeusModule) {
        this.coeusModule = coeusModule;
    }
}
