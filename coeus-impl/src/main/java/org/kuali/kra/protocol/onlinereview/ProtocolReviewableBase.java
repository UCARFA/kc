/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.onlinereview;

import org.kuali.coeus.common.committee.impl.bo.CommitteeScheduleBase;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.rice.krad.service.BusinessObjectService;

/**
 * 
 * This class is for review comments and attachments
 */
public abstract class ProtocolReviewableBase<CS extends CommitteeScheduleBase<CS, ?, ?, ?>> extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 2401653037114419518L;

    public abstract Long getProtocolId();
    public abstract String getProtocolNumber();
    public abstract Integer getSubmissionNumber();
    public abstract Long getProtocolOnlineReviewIdFk();
    public abstract String getCreateUser();
    public abstract ProtocolBase getProtocol();
    public abstract void setDisplayReviewerName(boolean displayReviewerName);
    
    public abstract CS getCommitteeSchedule();
    /**
     * 
     * This method is to show whether comment or attachment is private or not
     * @return
     */
    public abstract boolean isPrivate();
    /**
     * 
     * This method indicates if the OLR is finalized or not
     * review comment has a finalflag, but review attachment does not
     * @return
     */
    public abstract boolean isFinal();


    /**
     * 
     * This method to indicate this instance is ReviewComment - CommitteeScheduleMinute
     * @return
     */
    public boolean isReviewComment() {
        return false;
    }

    /**
     * 
     * This method to show whether the OLR is accepted by IRB admin.
     * @return
     */
    public boolean isAccepted() {
        boolean accepted = false;
        if (getProtocolOnlineReviewIdFk() != null) {
            ProtocolOnlineReviewBase protocolOnlineReview = getBusinessObjectService().findBySinglePrimaryKey(getProtocolOnlineReviewBOClassHook(), getProtocolOnlineReviewIdFk());
            if (protocolOnlineReview.isAdminAccepted()) {
                accepted = true;
            }
        } else {
            accepted = true;
        }
        
        return accepted;
    }

    protected abstract Class<? extends ProtocolOnlineReviewBase> getProtocolOnlineReviewBOClassHook();
    
    
    private BusinessObjectService getBusinessObjectService() {
        return KcServiceLocator.getService(BusinessObjectService.class);
    }
}
