/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.attachments;

import org.kuali.coeus.common.framework.attachment.AttachmentDocumentStatus;
import org.kuali.coeus.common.framework.attachment.KcAttachmentService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;

import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.kra.institutionalproposal.web.struts.form.InstitutionalProposalForm;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InstitutionalProposalAttachmentFormBean implements Serializable{


    private static final long serialVersionUID = 4184903707661244083L;

    private static final int MAX_FILE_NAME_LENGTH = 150;

    private static final int MAX_FILE_TYPE_LENGTH = 250;

    private final InstitutionalProposalForm form;
    
    private InstitutionalProposalAttachment newAttachment;
    
    private boolean disableAttachmentRemovalIndicator=false;

    public InstitutionalProposalAttachmentFormBean(final InstitutionalProposalForm form) {
        this.form = form;
    }

    public InstitutionalProposalAttachment getNewAttachment() {
    	if (this.newAttachment == null) {
            this.initAttachment();
        }
        return this.newAttachment;
    }

    private void initAttachment() {
        this.setNewAttachment(new InstitutionalProposalAttachment(this.getInstitutionalProposal()));
    }

    public void setNewAttachment(InstitutionalProposalAttachment newAttachment) {
        this.newAttachment = newAttachment;
    }

    public InstitutionalProposalForm getForm() {
        return form;
    }

    public InstitutionalProposal getInstitutionalProposal() {

        if (this.form.getInstitutionalProposalDocument() == null) {
            throw new IllegalArgumentException("the document is null");
        }
        
        if (this.form.getInstitutionalProposalDocument().getInstitutionalProposal() == null) {
            throw new IllegalArgumentException("the award is null");
        }

        return this.form.getInstitutionalProposalDocument().getInstitutionalProposal();
    }
    
    /**
     * Adds the "new" IPAttachment to the InstitutionalProposal.  Before
     * adding this method executes validation.  If the validation fails the attachment is not added.
     */
    public void addNewInstitutionalProposalAttachment() {
         this.newAttachment.setDocumentStatusCode(AttachmentDocumentStatus.ACTIVE.getCode());
         Map<String, String> criteria = new HashMap<String, String>();
         criteria.put(Constants.PROPOSAL_NUMBER, this.getInstitutionalProposal().getProposalNumber());
         Collection<InstitutionalProposalAttachment> allAttachments = getBusinessObjectService().findMatching(InstitutionalProposalAttachment.class, criteria);
         setAttachmentNumber(allAttachments);
         this.syncNewFiles(Collections.singletonList(this.getNewAttachment()));
         this.getInstitutionalProposal().addAttachment(this.newAttachment);
         getBusinessObjectService().save(this.newAttachment);
         this.initNewAttachment();
    }

    public InstitutionalProposalAttachment retrieveExistingAttachment(int attachmentNumber) {
        if (!validIndexForList(attachmentNumber, this.getInstitutionalProposal().getInstProposalAttachments())) {
            return null;
        }
        return this.getInstitutionalProposal().getInstProposalAttachments().get(attachmentNumber);
    }

    private static boolean validIndexForList(int index, final List<?> forList) {      
        return forList != null && index >= 0 && index <= forList.size() - 1;
    }

    private void initNewAttachment() {
        this.setNewAttachment(new InstitutionalProposalAttachment(this.getInstitutionalProposal()));
    }

    private void syncNewFiles(List<InstitutionalProposalAttachment> attachments) {
        assert attachments != null : "the attachments was null";
        for (InstitutionalProposalAttachment attachment : attachments) {
            if (getKcAttachmentService().doesNewFileExist(attachment.getNewFile())) {
                try{
                    attachment.setFileName(removeFrontForLength(attachment.getNewFile().getFileName(), MAX_FILE_NAME_LENGTH));
                    attachment.setContentType(removeFrontForLength(attachment.getNewFile().getContentType(), MAX_FILE_TYPE_LENGTH));
                    attachment.setData(attachment.getNewFile().getFileData());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
           }
        }
    }

    private String removeFrontForLength(String aString, int aLength) {
        assert aString != null : "aString is null";
        assert aLength > 0 : "aLength is negative: " + aLength;
        if (aString.length() > aLength) {
            StringBuilder tempString = new StringBuilder(aString);
            tempString.delete(0, tempString.length() - aLength);
            return tempString.toString();
        }
        return aString;
    }

    private void setAttachmentNumber(Collection<InstitutionalProposalAttachment> allAttachments) {
    	if(allAttachments.isEmpty() || allAttachments == null) {
        	this.newAttachment.setAttachmentNumber(1);	
        } else {
        	int maxAttachmentNumber = 0;
    		for(InstitutionalProposalAttachment attachment: allAttachments) {
        		if(attachment.getAttachmentNumber() != null &&
                        attachment.getAttachmentNumber() > maxAttachmentNumber) {
        			maxAttachmentNumber = attachment.getAttachmentNumber();
        		}
        	}

            this.newAttachment.setAttachmentNumber(maxAttachmentNumber + 1);
        }
    }

    public boolean isDisableAttachmentRemovalIndicator() {
		return disableAttachmentRemovalIndicator;
	}

	public void setDisableAttachmentRemovalIndicator(
			boolean disableAttachmentRemovalIndicator) {
		this.disableAttachmentRemovalIndicator = disableAttachmentRemovalIndicator;
	}

	private BusinessObjectService getBusinessObjectService() {
        return KcServiceLocator.getService(BusinessObjectService.class);
    }

    private KcAttachmentService getKcAttachmentService() {
        return KcServiceLocator.getService(KcAttachmentService.class);
    }
}
