/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.rule.event;

import org.kuali.coeus.common.committee.impl.rule.event.CommitteeActionsEventBase;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.kra.committee.rules.CommitteeActionPrintCommitteeDocumentRule;
import org.kuali.rice.krad.document.Document;

public class CommitteeActionPrintCommitteeDocumentEvent extends CommitteeActionsEventBase<CommitteeActionPrintCommitteeDocumentRule> {
    private static final String MSG = "print committee document";
    
    private Boolean printRooster;
    private Boolean printFutureScheduledMeeting;
    private boolean onMeetingAction;
    
    public CommitteeActionPrintCommitteeDocumentEvent(String errorPathPrefix, Document document, Boolean printRooster, Boolean printFutureScheduledMeeting) {
        super(MSG + getDocumentId(document), errorPathPrefix, document);
        setPrintRooster(printRooster);
        setPrintFutureScheduledMeeting(printFutureScheduledMeeting);
        setOnMeetingAction(false);
    }

    public CommitteeActionPrintCommitteeDocumentEvent(String errorPathPrefix, Document document, Boolean printRooster, Boolean printFutureScheduledMeeting, boolean onMeetingAction) {
        super(MSG + getDocumentId(document), errorPathPrefix, document);
        setPrintRooster(printRooster);
        setPrintFutureScheduledMeeting(printFutureScheduledMeeting);
        setOnMeetingAction(onMeetingAction);
    }

    @SuppressWarnings("unchecked")
    @Override
    public KcBusinessRule getRule() {
        return new CommitteeActionPrintCommitteeDocumentRule();
    }

    public Boolean getPrintRooster() {
        return printRooster;
    }

    public void setPrintRooster(Boolean printRooster) {
        this.printRooster = printRooster;
    }

    public Boolean getPrintFutureScheduledMeeting() {
        return printFutureScheduledMeeting;
    }

    public void setPrintFutureScheduledMeeting(Boolean printFutureScheduledMeeting) {
        this.printFutureScheduledMeeting = printFutureScheduledMeeting;
    }

    public boolean isOnMeetingAction() {
        return onMeetingAction;
    }

    public void setOnMeetingAction(boolean onMeetingAction) {
        this.onMeetingAction = onMeetingAction;
    }

}
