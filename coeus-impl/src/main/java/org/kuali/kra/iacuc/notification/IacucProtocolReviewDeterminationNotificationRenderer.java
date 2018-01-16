/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.notification;

import org.kuali.kra.iacuc.IacucProtocol;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Renders additional fields for the Protocol Disapproved notification.
 */
public class IacucProtocolReviewDeterminationNotificationRenderer extends IacucProtocolNotificationRenderer {

    private Date dueDate;
    
    /**
     * Constructs a Protocol Review Type Determination notification renderer.
     * @param protocol
     * @param dueDate
     */
    public IacucProtocolReviewDeterminationNotificationRenderer(IacucProtocol protocol, Date dueDate) {
        super(protocol);
        this.dueDate = dueDate;
    }
    
    @Override
    public Map<String, String> getDefaultReplacementParameters() {
        Map<String, String> params = super.getDefaultReplacementParameters();
        params.put("{DUE_DATE}", (dueDate == null ? "N/A" : new SimpleDateFormat("d'-'MMM'-'yyyy").format(dueDate)));
        return params;
    }

}
