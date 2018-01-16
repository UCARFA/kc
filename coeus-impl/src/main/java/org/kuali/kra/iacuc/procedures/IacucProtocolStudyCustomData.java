/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.procedures;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.iacuc.IacucProcedureCategoryCustomData;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.krad.util.ObjectUtils;

public class IacucProtocolStudyCustomData extends KcPersistableBusinessObjectBase {
    
    private static final long serialVersionUID = 1L;

    private Integer iacucProtocolStudyCustomDataId; 
    private Integer iacucProtocolStudyGroupId; 
    private Long procedureCustomAttributeId;
    private String value;
    
    private IacucProcedureCategoryCustomData iacucProcedureCategoryCustomData;
    private IacucProtocolStudyGroup iacucProtocolStudyGroup;
    
    public IacucProtocolStudyCustomData() { 

    } 
    
    public Integer getIacucProtocolStudyCustomDataId() {
        return iacucProtocolStudyCustomDataId;
    }

    public void setIacucProtocolStudyCustomDataId(Integer iacucProtocolStudyCustomDataId) {
        this.iacucProtocolStudyCustomDataId = iacucProtocolStudyCustomDataId;
    }

    public Integer getIacucProtocolStudyGroupId() {
        return iacucProtocolStudyGroupId;
    }

    public void setIacucProtocolStudyGroupId(Integer iacucProtocolStudyGroupId) {
        this.iacucProtocolStudyGroupId = iacucProtocolStudyGroupId;
    }

    public Long getProcedureCustomAttributeId() {
        return procedureCustomAttributeId;
    }

    public void setProcedureCustomAttributeId(Long procedureCustomAttributeId) {
        this.procedureCustomAttributeId = procedureCustomAttributeId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void resetPersistenceState() {
        setIacucProtocolStudyCustomDataId(null);
    }

    public IacucProcedureCategoryCustomData getIacucProcedureCategoryCustomData() {
        if(ObjectUtils.isNull(iacucProcedureCategoryCustomData)) {
            this.refreshReferenceObject("iacucProcedureCategoryCustomData");
        }
        return iacucProcedureCategoryCustomData;
    }

    public void setIacucProcedureCategoryCustomData(IacucProcedureCategoryCustomData iacucProcedureCategoryCustomData) {
        this.iacucProcedureCategoryCustomData = iacucProcedureCategoryCustomData;
    }

    public boolean isLargeText() {
        return getIacucProcedureCategoryCustomData().getDataLength() > Constants.IACUC_PROCEDURE_CUSTOM_DATA_SMALL_STRING_MAX_LENGTH;
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
        IacucProtocolStudyCustomData other = (IacucProtocolStudyCustomData) obj;
        if (this.iacucProtocolStudyCustomDataId == null) {
            if (other.iacucProtocolStudyCustomDataId != null) {
                return false;
            }
        } else if (!this.iacucProtocolStudyCustomDataId.equals(other.iacucProtocolStudyCustomDataId)) {
            return false;
        }
        if (this.iacucProtocolStudyGroupId == null) {
            if (other.iacucProtocolStudyGroupId != null) {
                return false;
            }
        } else if (!this.iacucProtocolStudyGroupId.equals(other.iacucProtocolStudyGroupId)) {
            return false;
        }
        if (this.procedureCustomAttributeId == null) {
            if (other.procedureCustomAttributeId != null) {
                return false;
            }
        } else if (!this.procedureCustomAttributeId.equals(other.procedureCustomAttributeId)) {
            return false;
        }
        return true;
    }

    public IacucProtocolStudyGroup getIacucProtocolStudyGroup() {
        return iacucProtocolStudyGroup;
    }

    public void setIacucProtocolStudyGroup(IacucProtocolStudyGroup iacucProtocolStudyGroup) {
        this.iacucProtocolStudyGroup = iacucProtocolStudyGroup;
    }
}
