/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb;

import org.kuali.kra.committee.bo.CommitteeSchedule;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.irb.actions.submit.ProtocolSubmission;
import org.kuali.kra.irb.actions.submit.ProtocolSubmitActionService;
import org.kuali.kra.protocol.ProtocolSubmissionLookupableHelperServiceImplBase;
import org.kuali.rice.kns.lookup.HtmlData;
import org.kuali.rice.kns.lookup.HtmlData.AnchorHtmlData;
import org.kuali.rice.krad.bo.BusinessObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * This class is to create action links and inquiry url for protocolsubmission lookup. 
 */
@SuppressWarnings("serial")
public class ProtocolSubmissionLookupableHelperServiceImpl extends ProtocolSubmissionLookupableHelperServiceImplBase {

  private ProtocolSubmitActionService protocolSubmitActionService;


    @Override
    public List<HtmlData> getCustomActionUrls(BusinessObject businessObject, List pkNames) {
        List<HtmlData> htmlDataList = new ArrayList<HtmlData>();
        if (kraAuthorizationService.hasPermission(getUserIdentifier(), ((ProtocolSubmission) businessObject).getProtocol(),
                PermissionConstants.MODIFY_PROTOCOL)) {
            AnchorHtmlData editHtmlData = getViewLink((ProtocolSubmission) businessObject);
            String href = editHtmlData.getHref();
            href = href.replace("viewDocument=true", "viewDocument=false");
            editHtmlData.setHref(href);
            editHtmlData.setDisplayText("edit");
            htmlDataList.add(editHtmlData);
        }
        if (kraAuthorizationService.hasPermission(getUserIdentifier(), ((ProtocolSubmission) businessObject).getProtocol(),
                PermissionConstants.VIEW_PROTOCOL)) {
            htmlDataList.add(getViewLink((ProtocolSubmission) businessObject));
        }
        return htmlDataList;
    }

    @Override
    public List<? extends BusinessObject> getSearchResults(Map<String, String> fieldValues) {
        super.setBackLocationDocFormKey(fieldValues);
        List<ProtocolSubmission> submissionLookupData = (List<ProtocolSubmission>) super.getSearchResults(fieldValues);

        if ((submissionLookupData != null) && (submissionLookupData.size() > 0)) {
            submissionLookupData = protocolSubmitActionService.getProtocolSubmissionsLookupData(submissionLookupData);
        }

        for (ProtocolSubmission submission : submissionLookupData) {
            if (submission.getCommitteeSchedule() == null) {
                submission.setCommitteeSchedule(new CommitteeSchedule());
            }
        }
        return submissionLookupData;
    }
    
    
    @Override
    protected String getHtmlAction() {
        return "protocolProtocol.do";
    }

    @Override
    protected String getDocumentTypeName() {
        return "ProtocolDocument";
    }

    public ProtocolSubmitActionService getProtocolSubmitActionService() {
        return protocolSubmitActionService;
    }

    public void setProtocolSubmitActionService(ProtocolSubmitActionService protocolSubmitActionService) {
        this.protocolSubmitActionService = protocolSubmitActionService;
    }
}
