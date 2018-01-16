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
 * This class is minute entry type code.
 */
public class MinuteEntryType extends KcPersistableBusinessObjectBase implements Comparable<MinuteEntryType> {

    public static final String ATTENDANCE = "2";

    public static final String PROTOCOL = "3";

    public static final String ACTION_ITEM = "4";

    public static final String PROTOCOL_REVIEWER_COMMENT = "6";

    private static final long serialVersionUID = 3106451618464691958L;

    private String minuteEntryTypeCode;

    private Integer sortId;

    private String description;

    public MinuteEntryType() {
    }

    public String getMinuteEntryTypeCode() {
        return minuteEntryTypeCode;
    }

    public void setMinuteEntryTypeCode(String minuteEntryTypeCode) {
        this.minuteEntryTypeCode = minuteEntryTypeCode;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(MinuteEntryType arg) {
        return this.getSortId().compareTo(arg.getSortId());
    }
}
