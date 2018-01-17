/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.onlinereview;

import java.util.List;
import java.util.stream.Collectors;

import org.kuali.coeus.sys.framework.util.CollectionUtils;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolSubmissionStatus;
import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReviewBase;
import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReviewLookupableHelperServiceImplBase;

public class IacucProtocolOnlineReviewLookupableHelperServiceImpl extends ProtocolOnlineReviewLookupableHelperServiceImplBase {

    private static final long serialVersionUID = 6830796311898825327L;
    
    @Override
    protected String getDocumentTypeName() {
        return "IacucProtocolOnlineReviewDocument";
    }

    @Override
    protected String getHtmlAction() {
        return "iacucProtocolOnlineReviewRedirect.do";
    }

    @Override
    protected String getProtocolOLRSavedStatusCodeHook() {
        return IacucProtocolOnlineReviewStatus.SAVED_STATUS_CD;
    }
    
    @Override
    protected String getProtocolSubmissionApprovedStatusCodeHook() {
        return IacucProtocolSubmissionStatus.APPROVED;
    }
    
    private String getProtocolSubmissionAdminApprovedStatusCodeHook() {
        return IacucProtocolSubmissionStatus.ADMINISTRATIVELY_APPROVED;
    }
    
    @Override
    protected List<ProtocolOnlineReviewBase> filterResults(List<ProtocolOnlineReviewBase> results) {
        List<ProtocolOnlineReviewBase> onlineReviews = CollectionUtils.createCorrectImplementationForCollection(results);
        //ensure that only pending submission statuses are shown for online reviews, i.e. do not show reviews assigned but not completed for approved protocols.
        onlineReviews.addAll(results.stream().filter(review -> review.getProtocolOnlineReviewDocument() != null)
                .filter(review -> !(review.getProtocolSubmission().getSubmissionStatusCode().equalsIgnoreCase(getProtocolSubmissionApprovedStatusCodeHook()) ||
                review.getProtocolSubmission().getSubmissionStatusCode().equalsIgnoreCase(getProtocolSubmissionAdminApprovedStatusCodeHook()))).collect(Collectors.toList()));
        return onlineReviews;
    }
}
