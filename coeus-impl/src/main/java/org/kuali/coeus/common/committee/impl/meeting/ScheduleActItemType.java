/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.meeting;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * 
 * This class is for schedule other action type code.
 */
public class ScheduleActItemType extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = -2501084035126192701L;

    private String scheduleActItemTypeCode;

    private String description;

    private CommScheduleActItemBase commScheduleActItems;

    public ScheduleActItemType() {
    }

    public String getScheduleActItemTypeCode() {
        return scheduleActItemTypeCode;
    }

    public void setScheduleActItemTypeCode(String scheduleActItemTypeCode) {
        this.scheduleActItemTypeCode = scheduleActItemTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CommScheduleActItemBase getCommScheduleActItems() {
        return commScheduleActItems;
    }

    public void setCommScheduleActItems(CommScheduleActItemBase commScheduleActItems) {
        this.commScheduleActItems = commScheduleActItems;
    }
}
