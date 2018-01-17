/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.submit;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

@SuppressWarnings("serial")
public class ExpeditedReviewCheckListItem extends KcPersistableBusinessObjectBase {

    private String expeditedReviewCheckListCode;

    private String description;

    private transient boolean checked = false;

    public ExpeditedReviewCheckListItem() {
    }

    public String getExpeditedReviewCheckListCode() {
        return expeditedReviewCheckListCode;
    }

    public void setExpeditedReviewCheckListCode(String expeditedReviewCheckListCode) {
        this.expeditedReviewCheckListCode = expeditedReviewCheckListCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean getChecked() {
        return checked;
    }
}
