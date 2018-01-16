/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.notification;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.notification.IRBNotificationRenderer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Renders additional fields for the Notify IRB notification.
 */
public class NotifyCommitteeNotificationRenderer extends IRBNotificationRenderer {

    private static final long serialVersionUID = -5315801471642797815L;
    
    private String committeeName;
    private String actionComments;
    private Date actionDate;

    /**
     * Constructs a Notify IRB notification renderer.
     * @param protocol
     * @param actionComments
     */
    public NotifyCommitteeNotificationRenderer(Protocol protocol, String committeeName, String actionComments, Date actionDate) {
        super(protocol);
        this.actionDate = actionDate;
        this.actionComments = actionComments;
        this.committeeName = committeeName;
    }
    
    public String getActionComments() {
        return actionComments;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public String getCommitteeName() {
        return committeeName;
    }

    @Override
    public Map<String, String> getDefaultReplacementParameters() {
        Map<String, String> params = super.getDefaultReplacementParameters();
        params.put("{COMMITTEE_NAME}", getSafeMessage("{COMMITTEE_NAME}", getCommitteeName()));
        params.put("{ACTION_COMMENTS}", (StringUtils.isBlank(getActionComments()) ? "None" : getActionComments()));
        params.put("{ACTION_DATE}", (new SimpleDateFormat("d'-'MMM'-'yyyy")).format(getActionDate()));
        return params;
    }

}
