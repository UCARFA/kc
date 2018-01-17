/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.rules;


import org.kuali.coeus.common.framework.attachment.KcAttachmentService;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.institutionalproposal.attachments.InstitutionalProposalAttachment;

public class InstitutionalProposalAddAttachmentRuleImpl extends KcTransactionalDocumentRuleBase implements InstitutionalProposalAddAttachmentRule {

    private static final String ATTACHMENT_TYPE_CODE = "institutionalProposalAttachmentBean.newAttachment.attachmentTypeCode";
    private static final String NEW_FILE = "institutionalProposalAttachmentBean.newAttachment.newFile";
    public static final String INDEXED_ATTACHMENT_TYPE_CODE = "document.institutionalProposalList[0].instProposalAttachments[%d].attachmentTypeCode";

    @Override
    public boolean processAddInstitutionalProposalAttachmentBusinessRules(InstitutionalProposalAddAttachmentRuleEvent institutionalProposalRuleEvent) {
        InstitutionalProposalAttachment proposalAttachment = institutionalProposalRuleEvent.getInstitutionalProposalAttachmentForValidation();
        boolean valid=true;
        if( proposalAttachment.getAttachmentTypeCode()  == null ) {
            valid = false;
                reportError(ATTACHMENT_TYPE_CODE, KeyConstants.INSTITUTIONAL_PROPOSAL_ATTACHMENT_TYPE_CODE_REQUIRED);
        }
        
        if(!getKcAttachmentService().doesNewFileExist(proposalAttachment.getNewFile())) {
            valid = false;
            reportError(NEW_FILE, KeyConstants.INSTITUTIONAL_PROPOSAL_ATTACHMENT_FILE_REQUIRED);
        }
        return valid;
    }
    
    @Override
    public boolean processSaveInstitutionalProposalAttachment(InstitutionalProposalAddAttachmentRuleEvent institutionalProposalRuleEvent, int i) {
        InstitutionalProposalAttachment proposalAttachment = institutionalProposalRuleEvent.getInstitutionalProposalDocument().getInstitutionalProposal().getInstProposalAttachment(i);
        boolean valid=true;
        if( proposalAttachment.getAttachmentTypeCode()  == null ) {
            valid = false;
            reportError(String.format(INDEXED_ATTACHMENT_TYPE_CODE,i), KeyConstants.INSTITUTIONAL_PROPOSAL_ATTACHMENT_TYPE_CODE_REQUIRED);
        }
         return valid;
    }

    private KcAttachmentService getKcAttachmentService() {
        return KcServiceLocator.getService(KcAttachmentService.class);
    }
    
    
}