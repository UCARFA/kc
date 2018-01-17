/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.bo;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class ScheduleStatus extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = -7318684957814299092L;

    private Integer scheduleStatusCode;

    private String description;

    public ScheduleStatus() {
    }

    public Integer getScheduleStatusCode() {
        return scheduleStatusCode;
    }

    public void setScheduleStatusCode(Integer scheduleStatusCode) {
        this.scheduleStatusCode = scheduleStatusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
