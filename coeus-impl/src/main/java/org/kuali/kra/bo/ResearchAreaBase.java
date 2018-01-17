/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.bo;


import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.core.api.mo.common.active.MutableInactivatable;

public abstract class ResearchAreaBase extends KcPersistableBusinessObjectBase implements MutableInactivatable {


    private static final long serialVersionUID = -1950434459698084680L;

    private String researchAreaCode;

    private String parentResearchAreaCode;

    private boolean hasChildrenFlag;

    private String description;

    private boolean active;

    public ResearchAreaBase() {
        super();
    }

    public ResearchAreaBase(String researchAreaCode, String parentResearchAreaCode, String description, boolean active) {
        super();
        this.researchAreaCode = researchAreaCode;
        this.parentResearchAreaCode = parentResearchAreaCode;
        this.description = description;
        this.active = active;
        this.hasChildrenFlag = false;
    }

    public String getResearchAreaCode() {
        return researchAreaCode;
    }

    public void setResearchAreaCode(String researchAreaCode) {
        this.researchAreaCode = researchAreaCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getHasChildrenFlag() {
        return hasChildrenFlag;
    }

    public void setHasChildrenFlag(boolean hasChildrenFlag) {
        this.hasChildrenFlag = hasChildrenFlag;
    }

    public String getParentResearchAreaCode() {
        return parentResearchAreaCode;
    }

    public void setParentResearchAreaCode(String parentResearchAreaCode) {
        this.parentResearchAreaCode = parentResearchAreaCode;
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
        result = prime * result + ((researchAreaCode == null) ? 0 : researchAreaCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ResearchAreaBase other = (ResearchAreaBase) obj;
        if (researchAreaCode == null) {
            if (other.researchAreaCode != null) return false;
        } else if (!researchAreaCode.equalsIgnoreCase(other.researchAreaCode)) return false;
        return true;
    }
}
