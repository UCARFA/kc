/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.onlinereview;

import org.kuali.kra.protocol.ProtocolOnlineReviewDocumentBase;
import org.kuali.kra.protocol.actions.submit.ProtocolReviewer;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;
import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReviewService;
import org.kuali.rice.kew.api.exception.WorkflowException;

import java.sql.Date;

public interface IacucProtocolOnlineReviewService extends ProtocolOnlineReviewService{
    String IACUC_PROTOCOL_ONLINE_REVIEW_DOCUMENT_TYPE = "IacucProtocolOnlineReviewDocument";

    public ProtocolOnlineReviewDocumentBase createProtocolOnlineReviewDocument(ProtocolSubmissionBase protocolSubmission,
            ProtocolReviewer protocolReviewer, String documentDescription, String documentExplanation,
            String documentOrganizationDocumentNumber, Date dateRequested, Date dateDue, String principalId)
            throws WorkflowException;
}
