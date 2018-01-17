/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc;

import org.kuali.coeus.common.framework.custom.attr.CustomAttribute;
import org.kuali.rice.core.api.mo.common.active.MutableInactivatable;

public class IacucProcedureCategoryCustomData extends CustomAttribute implements MutableInactivatable {
    
    private static final long serialVersionUID = 1L;

    private Integer procedureCategoryCode; 
    private boolean active; 
    private Integer sortId;
    
    @Override
    protected void prePersist() {
        super.prePersist();
        if (sortId == null) {
            sortId = this.getId().intValue();
        }
    }

    public Integer getProcedureCategoryCode() {
        return procedureCategoryCode;
    }

    public void setProcedureCategoryCode(Integer procedureCategoryCode) {
        this.procedureCategoryCode = procedureCategoryCode;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.procedureCategoryCode == null) ? 0 : this.procedureCategoryCode.hashCode());
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
        IacucProcedureCategoryCustomData other = (IacucProcedureCategoryCustomData) obj;
        if (this.procedureCategoryCode == null) {
            if (other.procedureCategoryCode != null) {
                return false;
            }
        } else if (!this.procedureCategoryCode.equals(other.procedureCategoryCode)) {
            return false;
        }
        return true;
    }
    
}
