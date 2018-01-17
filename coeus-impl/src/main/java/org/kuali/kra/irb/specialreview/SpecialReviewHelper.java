/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.specialreview;

import org.kuali.kra.infrastructure.TaskName;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.ProtocolForm;
import org.kuali.kra.irb.auth.ProtocolTask;
import org.kuali.kra.protocol.auth.ProtocolTaskBase;
import org.kuali.kra.protocol.specialreview.ProtocolSpecialReviewBase;
import org.kuali.kra.protocol.specialreview.ProtocolSpecialReviewHelperBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines the Special Review Helper for Protocol.
 */
public class SpecialReviewHelper extends ProtocolSpecialReviewHelperBase {

    private static final long serialVersionUID = -6004130465079070854L;
    private ProtocolForm form;

    public SpecialReviewHelper(ProtocolForm form) {
        this.form = form;
        setNewSpecialReview(new ProtocolSpecialReview());
        setLinkedProtocolNumbers(new ArrayList<String>());
    }

    @Override
    protected List<ProtocolSpecialReviewBase> getSpecialReviews() {
        return form.getProtocolDocument().getProtocol().getSpecialReviews();
    }

    @Override
    protected boolean hasModifySpecialReviewPermission(String principalId) {
        ProtocolTaskBase task = new ProtocolTask(TaskName.MODIFY_PROTOCOL_SPECIAL_REVIEW, (Protocol)form.getProtocolDocument().getProtocol());
        return getTaskAuthorizationService().isAuthorized(principalId, task);
    }

    @Override
    public boolean isIrbProtocolLinkingEnabledForModule() {
        return false;
    }

    @Override
    public boolean isIacucProtocolLinkingEnabledForModule() {
        return false;
    }

    @Override
    public boolean isCanCreateIrbProtocol() {
        return true;
    }

    @Override
    public boolean isCanCreateIacucProtocol() {
        return false;
    }    
}
