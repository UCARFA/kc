/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.awardhierarchy.sync;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * Log entry for award sync.
 */
public class AwardSyncLog extends KcPersistableBusinessObjectBase implements Comparable<AwardSyncLog> {

    private static final long serialVersionUID = 6519251953519350489L;

    private Long awardSyncLogId;

    private Long awardSyncStatusId;

    private Long awardSyncChangeId;

    private boolean success;

    private String logTypeCode;

    private String status;

    private AwardSyncStatus syncStatus;

    private AwardSyncChange change;

    private transient String messageKey;

    public Long getAwardSyncLogId() {
        return awardSyncLogId;
    }

    public void setAwardSyncLogId(Long awardSyncLogId) {
        this.awardSyncLogId = awardSyncLogId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public Long getAwardSyncChangeId() {
        return awardSyncChangeId;
    }

    public void setAwardSyncChangeId(Long awardSyncChangeId) {
        this.awardSyncChangeId = awardSyncChangeId;
    }

    public AwardSyncChange getChange() {
        return change;
    }

    public void setChange(AwardSyncChange change) {
        this.change = change;
    }

    @Override
    public int compareTo(AwardSyncLog log) {
        if (getAwardSyncLogId() == null) {
            return 1;
        } else if (log.getAwardSyncLogId() == null) {
            return -1;
        } else {
            return getAwardSyncLogId().compareTo(log.getAwardSyncLogId());
        }
    }

    public String getLogTypeCode() {
        return logTypeCode;
    }

    public void setLogTypeCode(String logTypeCode) {
        this.logTypeCode = logTypeCode;
    }

    public AwardSyncLogType getLogType() {
        if (logTypeCode == null) {
            return null;
        } else {
            return AwardSyncLogType.getLogTypeFromCode(logTypeCode);
        }
    }

    public void setLogType(AwardSyncLogType logType) {
        if (logType != null) {
            this.logTypeCode = logType.getCode();
        } else {
            this.logTypeCode = null;
        }
    }

    public boolean isChangeLog() {
        return StringUtils.equals(logTypeCode, AwardSyncLogType.CHANGE_LOG.getCode());
    }

    public boolean isValidationLog() {
        return StringUtils.equals(logTypeCode, AwardSyncLogType.VALIDATION_MESSAGE.getCode());
    }

    public Long getAwardSyncStatusId() {
        return awardSyncStatusId;
    }

    public void setAwardSyncStatusId(Long awardSyncStatusId) {
        this.awardSyncStatusId = awardSyncStatusId;
    }

    public AwardSyncStatus getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(AwardSyncStatus syncStatus) {
        this.syncStatus = syncStatus;
    }
}
