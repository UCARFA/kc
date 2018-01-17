/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.awardhierarchy.sync;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.award.home.Award;

import java.util.ArrayList;
import java.util.List;

public class AwardSyncStatus extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = -8047529476039817371L;

    private Long awardSyncStatusId;

    private Long parentAwardId;

    private Long awardId;

    private String awardNumber;

    private String status;

    private boolean success;

    private boolean syncComplete;

    private Award award;

    private List<AwardSyncLog> changeLogs = new ArrayList<AwardSyncLog>();

    private List<AwardSyncLog> validationLogs = new ArrayList<AwardSyncLog>();

    public void clearLogs() {
        changeLogs.clear();
        validationLogs.clear();
    }

    public void addChangeLog(AwardSyncChange change, String statusMessage, boolean logSuccess) {
        AwardSyncLog log = new AwardSyncLog();
        log.setSyncStatus(this);
        log.setChange(change);
        log.setLogType(AwardSyncLogType.CHANGE_LOG);
        log.setStatus(statusMessage);
        log.setSuccess(logSuccess);
        changeLogs.add(log);
    }

    public void addValidationLog(String statusMessage, boolean logSuccess, String messageKey) {
        AwardSyncLog log = new AwardSyncLog();
        log.setSyncStatus(this);
        log.setLogType(AwardSyncLogType.VALIDATION_MESSAGE);
        log.setStatus(statusMessage);
        log.setSuccess(logSuccess);
        log.setMessageKey(messageKey);
        validationLogs.add(log);
    }

    public Long getAwardSyncStatusId() {
        return awardSyncStatusId;
    }

    public void setAwardSyncStatusId(Long awardSyncStatusId) {
        this.awardSyncStatusId = awardSyncStatusId;
    }

    public Long getParentAwardId() {
        return parentAwardId;
    }

    public void setParentAwardId(Long parentAwardId) {
        this.parentAwardId = parentAwardId;
    }

    public Long getAwardId() {
        return awardId;
    }

    public void setAwardId(Long awardId) {
        this.awardId = awardId;
    }

    public String getAwardNumber() {
        return awardNumber;
    }

    public void setAwardNumber(String awardNumber) {
        this.awardNumber = awardNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSyncComplete() {
        return syncComplete;
    }

    public void setSyncComplete(boolean syncComplete) {
        this.syncComplete = syncComplete;
    }

    public List<AwardSyncLog> getChangeLogs() {
        return changeLogs;
    }

    public void setChangeLogs(List<AwardSyncLog> changeLogs) {
        this.changeLogs = changeLogs;
    }

    public List<AwardSyncLog> getValidationLogs() {
        return validationLogs;
    }

    public void setValidationLogs(List<AwardSyncLog> validationLogs) {
        this.validationLogs = validationLogs;
    }

    public Award getAward() {
        return award;
    }

    public void setAward(Award award) {
        this.award = award;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
