/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.timeandmoney.service.impl;

import org.kuali.coeus.common.framework.version.VersionStatus;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.workflow.KcWorkflowService;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.timeandmoney.document.TimeAndMoneyDocument;
import org.kuali.kra.timeandmoney.service.TimeAndMoneyExistenceService;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.DocumentService;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeAndMoneyExistenceServiceImpl implements TimeAndMoneyExistenceService {

    private KcWorkflowService kraWorkflowService;
    private DocumentService documentService;
    private BusinessObjectService businessObjectService;

    public static final String ENABLE_AWD_ANT_OBL_DIRECT_INDIRECT_COST = "ENABLE_AWD_ANT_OBL_DIRECT_INDIRECT_COST";

    @Override
    public boolean validateTimeAndMoneyRule(Award award, String rootAwardNumber) throws WorkflowException {
        Map<String, Object> fieldValues = new HashMap<String, Object>();
        fieldValues.put("rootAwardNumber", rootAwardNumber);
        fieldValues.put("documentStatus", VersionStatus.PENDING.toString());

        BusinessObjectService businessObjectService =  KcServiceLocator.getService(BusinessObjectService.class);

        List<TimeAndMoneyDocument> timeAndMoneyDocuments = (List<TimeAndMoneyDocument>)businessObjectService.findMatching(TimeAndMoneyDocument.class, fieldValues);

        return timeAndMoneyDocuments == null || timeAndMoneyDocuments.isEmpty();
    }
    
    @Override
    public void addAwardVersionErrorMessage() {
        GlobalVariables.getMessageMap().addToErrorPath("document");
        GlobalVariables.getMessageMap().addToErrorPath("award");
        GlobalVariables.getMessageMap().putError("version", KeyConstants.ERROR_AWARD_CANNOT_BE_VERSIONED);
        GlobalVariables.getMessageMap().removeFromErrorPath("document");
        GlobalVariables.getMessageMap().removeFromErrorPath("award");
    }

    /**
     * Gets the kraWorkflowService attribute. 
     * @return Returns the kraWorkflowService.
     */
    public KcWorkflowService getKraWorkflowService() {
        return kraWorkflowService;
    }

    /**
     * Sets the kraWorkflowService attribute value.
     * @param kraWorkflowService The kraWorkflowService to set.
     */
    public void setKraWorkflowService(KcWorkflowService kraWorkflowService) {
        this.kraWorkflowService = kraWorkflowService;
    }

    /**
     * Gets the documentService attribute. 
     * @return Returns the documentService.
     */
    public DocumentService getDocumentService() {
        return documentService;
    }

    /**
     * Sets the documentService attribute value.
     * @param documentService The documentService to set.
     */
    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }

    /**
     * Gets the businessObjectService attribute. 
     * @return Returns the businessObjectService.
     */
    public BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }

    /**
     * Sets the businessObjectService attribute value.
     * @param businessObjectService The businessObjectService to set.
     */
    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }

}
