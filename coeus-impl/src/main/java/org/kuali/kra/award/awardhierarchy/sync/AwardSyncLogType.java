/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.awardhierarchy.sync;

import org.apache.commons.lang3.StringUtils;

/**
 * Enum with the types of logs that award sync can generate.
 */
public enum AwardSyncLogType {

    CHANGE_LOG("CL", "Change"), VALIDATION_MESSAGE("VM", "Validation Message");
    private String code;
    private String desc;
    private AwardSyncLogType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public String getCode() {
        return code;
    }
    public String getDesc() {
        return desc;
    }
    public static AwardSyncLogType getLogTypeFromCode(String code) {
        for (AwardSyncLogType type : AwardSyncLogType.values()) {
            if (StringUtils.equals(code, type.getCode())) {
                return type;
            }
        }
        return null;
    }
    
}
