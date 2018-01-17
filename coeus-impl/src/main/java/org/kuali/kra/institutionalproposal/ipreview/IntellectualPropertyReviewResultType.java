/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.ipreview;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class IntellectualPropertyReviewResultType extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 1L;

    private String intellectualPropertyReviewResultTypeCode;

    private String description;

    public IntellectualPropertyReviewResultType() {
    }

    public String getIntellectualPropertyReviewResultTypeCode() {
        return intellectualPropertyReviewResultTypeCode;
    }

    public void setIntellectualPropertyReviewResultTypeCode(String intellectualPropertyReviewResultTypeCode) {
        this.intellectualPropertyReviewResultTypeCode = intellectualPropertyReviewResultTypeCode;
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
        result = prime * result + ((intellectualPropertyReviewResultTypeCode == null) ? 0 : intellectualPropertyReviewResultTypeCode.hashCode());
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
        IntellectualPropertyReviewResultType other = (IntellectualPropertyReviewResultType) obj;
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (intellectualPropertyReviewResultTypeCode == null) {
            if (other.intellectualPropertyReviewResultTypeCode != null) {
                return false;
            }
        } else if (!intellectualPropertyReviewResultTypeCode.equals(other.intellectualPropertyReviewResultTypeCode)) {
            return false;
        }
        return true;
    }
}
