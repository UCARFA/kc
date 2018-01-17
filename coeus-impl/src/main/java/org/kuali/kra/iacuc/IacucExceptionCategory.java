/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.core.api.mo.common.active.MutableInactivatable;

public class IacucExceptionCategory extends KcPersistableBusinessObjectBase implements MutableInactivatable {
    
    private static final long serialVersionUID = 1L;

    private Integer exceptionCategoryCode; 
    private String exceptionCategoryDesc; 
    private boolean active;
    
    public Integer getExceptionCategoryCode() {
        return exceptionCategoryCode;
    }

    public void setExceptionCategoryCode(Integer exceptionCategoryCode) {
        this.exceptionCategoryCode = exceptionCategoryCode;
    }

    public String getExceptionCategoryDesc() {
        return exceptionCategoryDesc;
    }

    public void setExceptionCategoryDesc(String exceptionCategoryDesc) {
        this.exceptionCategoryDesc = exceptionCategoryDesc;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.exceptionCategoryCode == null) ? 0 : this.exceptionCategoryCode.hashCode());
        result = prime * result + ((this.exceptionCategoryDesc == null) ? 0 : this.exceptionCategoryDesc.hashCode());
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
        IacucExceptionCategory other = (IacucExceptionCategory) obj;
        if (this.exceptionCategoryCode == null) {
            if (other.exceptionCategoryCode != null) {
                return false;
            }
        } else if (!this.exceptionCategoryCode.equals(other.exceptionCategoryCode)) {
            return false;
        }
        if (this.exceptionCategoryDesc == null) {
            if (other.exceptionCategoryDesc != null) {
                return false;
            }
        } else if (!this.exceptionCategoryDesc.equals(other.exceptionCategoryDesc)) {
            return false;
        }
        return true;
    }
    
}
