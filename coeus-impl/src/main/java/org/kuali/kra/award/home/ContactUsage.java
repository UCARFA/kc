/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home;

import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;


/**
 * This class represents the ContactUsage business object and is mapped
 * to the CONTACT_USAGE table.
 */
public class ContactUsage  extends KcPersistableBusinessObjectBase {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 2198994554339151877L;
    
    private Long contactUsageId;
    private String contactTypeCode;    
    private String moduleCode;
    
    private ContactType contactType;
    private CoeusModule coeusModule;
    
    
    public ContactUsage() {
    }

    public ContactUsage(String contactTypeCode, String moduleCode) {
        this.contactTypeCode = contactTypeCode;
        this.moduleCode = moduleCode;
    }

    public Long getContactUsageId() {
        return contactUsageId;
    }

    public void setContactUsageId(Long contactUsageId) {
        this.contactUsageId = contactUsageId;
    }

    public String getContactTypeCode() {
        return contactTypeCode;
    }

    public void setContactTypeCode(String contactTypeCode) {
        this.contactTypeCode = contactTypeCode;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public CoeusModule getCoeusModule() {
        return coeusModule;
    }

    public void setCoeusModule(CoeusModule coeusModule) {
        this.coeusModule = coeusModule;
    }
    
}
