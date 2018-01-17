/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.specialreview;

import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.IacucProtocolForm;
import org.kuali.kra.iacuc.auth.IacucProtocolTask;
import org.kuali.kra.infrastructure.TaskName;
import org.kuali.kra.protocol.auth.ProtocolTaskBase;
import org.kuali.kra.protocol.specialreview.ProtocolSpecialReviewBase;
import org.kuali.kra.protocol.specialreview.ProtocolSpecialReviewHelperBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines the Special Review Helper for Protocol.
 */
public class IacucProtocolSpecialReviewHelper extends ProtocolSpecialReviewHelperBase {
    
    private IacucProtocolForm form;

    private static final long serialVersionUID = 1485258866764215682L;

    /**
     * Constructs a SpecialRevidocument = ewHelper.
     * @param form the container form
     */
    public IacucProtocolSpecialReviewHelper(IacucProtocolForm form) {
        this.form = form;
        setNewSpecialReview(new IacucProtocolSpecialReview());
        setLinkedProtocolNumbers(new ArrayList<String>());
    }

    @Override
    protected boolean hasModifySpecialReviewPermission(String principalId) {
        ProtocolTaskBase task = new IacucProtocolTask(TaskName.MODIFY_IACUC_PROTOCOL_SPECIAL_REVIEW, (IacucProtocol)form.getProtocolDocument().getProtocol());
        return getTaskAuthorizationService().isAuthorized(principalId, task);
    }
    
    @Override
    protected List<ProtocolSpecialReviewBase> getSpecialReviews() {
        return form.getProtocolDocument().getProtocol().getSpecialReviews();
    }

    @Override
    protected boolean isIacucProtocolLinkingEnabledForModule() {
        return false;
    }

    @Override
    protected boolean isIrbProtocolLinkingEnabledForModule() {
        return false;
    }

    @Override
    public boolean isCanCreateIrbProtocol() {
        return false;
    }

    @Override
    public boolean isCanCreateIacucProtocol() {
        return true;
    }

}
