/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.ipreview;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class IntellectualPropertyReviewRequirementType extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 1L;

    private String intellectualPropertyReviewRequirementTypeCode;

    private String description;

    public IntellectualPropertyReviewRequirementType() {
    }

    public String getIntellectualPropertyReviewRequirementTypeCode() {
        return intellectualPropertyReviewRequirementTypeCode;
    }

    public void setIntellectualPropertyReviewRequirementTypeCode(String intellectualPropertyReviewRequirementTypeCode) {
        this.intellectualPropertyReviewRequirementTypeCode = intellectualPropertyReviewRequirementTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((intellectualPropertyReviewRequirementTypeCode == null) ? 0 : intellectualPropertyReviewRequirementTypeCode.hashCode());
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        IntellectualPropertyReviewRequirementType other = (IntellectualPropertyReviewRequirementType) obj;
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (intellectualPropertyReviewRequirementTypeCode == null) {
            if (other.intellectualPropertyReviewRequirementTypeCode != null) {
                return false;
            }
        } else if (!intellectualPropertyReviewRequirementTypeCode.equals(other.intellectualPropertyReviewRequirementTypeCode)) {
            return false;
        }
        return true;
    }
}
