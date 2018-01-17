/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions;

import org.kuali.coeus.common.committee.impl.service.CommitteeServiceBase;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.actions.submit.ProtocolReviewerType;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.Collection;

public abstract class ProtocolActionAjaxServiceImplBase implements ProtocolActionAjaxService {

    private BusinessObjectService businessObjectService;
    private CommitteeServiceBase committeeService;
    

    @Override
    public abstract String getReviewers(String protocolId, String committeeId, String scheduleId);

    @Override
    public String getReviewerTypes() {
        StringBuffer ajaxList = new StringBuffer();
        Collection<ProtocolReviewerType> reviewerTypes = getReviewerTypesFromDatabase();
        for (ProtocolReviewerType reviewerType : reviewerTypes) {
            ajaxList.append(reviewerType.getReviewerTypeCode() + ";" + reviewerType.getDescription() + ";");
        }
        return clipLastChar(ajaxList);
    }
    @SuppressWarnings("unchecked")
    protected Collection<ProtocolReviewerType> getReviewerTypesFromDatabase() {
        return businessObjectService.findAll(getProtocolReviewerTypeClassHook());
    }
    
    public abstract Class getProtocolReviewerTypeClassHook();
    
    public abstract Class<? extends ProtocolBase> getProtocolClassHook();
    
    public BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }
    
    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }
    
    public CommitteeServiceBase getCommitteeService() {
        return committeeService;
    }
    
    public void setCommitteeService(CommitteeServiceBase committeeService) {
        this.committeeService = committeeService;
    }

    /**
     * Clip the last character from the string buffer. The last character, if there is one, is always a separator that must be
     * removed.
     * 
     * @param ajaxList
     * @return
     */
    protected String clipLastChar(StringBuffer ajaxList) {
        if (ajaxList.length() == 0) {
            return ajaxList.toString();
        }
        return ajaxList.substring(0, ajaxList.length() - 1);
    }
}
