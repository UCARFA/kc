/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.meeting;

import org.kuali.coeus.common.committee.impl.bo.CommitteeScheduleBase;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

import java.sql.Timestamp;

/**
 * 
 * This class is super class for meeting generated doc classes.
 */
public abstract class GeneratedMeetingDocBase extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = -5187758950400693662L;

    private Long scheduleIdFk;

    private byte[] pdfStore;

    private Timestamp createTimestamp;

    private String createUser;
    private CommitteeScheduleBase committeeSchedule;


    public byte[] getPdfStore() {
        return pdfStore;
    }

    public void setPdfStore(byte[] pdfStore) {
        this.pdfStore = pdfStore;
    }

    public Long getScheduleIdFk() {
        return scheduleIdFk;
    }

    public void setScheduleIdFk(Long scheduleIdFk) {
        this.scheduleIdFk = scheduleIdFk;
    }

    public CommitteeScheduleBase getCommitteeSchedule() {
        if (committeeSchedule == null) {
            refreshReferenceObject("committeeSchedule");
        }
        return committeeSchedule;
    }

    public void setCommitteeSchedule(CommitteeScheduleBase committeeSchedule) {
        this.committeeSchedule = committeeSchedule;
    }

    public Timestamp getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Timestamp createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
}
