/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.home;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;


public class InstitutionalProposalAttachmentType extends KcPersistableBusinessObjectBase  {
	
	private static final long serialVersionUID = 391856374612054089L;

    private Integer attachmentTypeCode;

    private String description;
    
    private boolean allowMultiple;

    /**
     * empty ctor to satisfy JavaBean convention.
     */
    public InstitutionalProposalAttachmentType() {
        super();
    }

    public Integer getAttachmentTypeCode() {
        return this.attachmentTypeCode;
    }

    public void setAttachmentTypeCode(Integer attachmentTypeCode) {
        this.attachmentTypeCode = attachmentTypeCode;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public boolean getAllowMultiple() {
		return allowMultiple;
	}

	public void setAllowMultiple(boolean allowMultiple) {
		this.allowMultiple = allowMultiple;
	}
}
