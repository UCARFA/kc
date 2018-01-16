/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.service;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.kra.institutionalproposal.web.struts.form.InstitutionalProposalForm;


public interface InstitutionalProposalNoteAttachmentService {

    /**
     * This method is used to add a new Note/Attachment.
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return mapping forward
     * @throws Exception
     */
    public abstract ActionForward addNote(ActionMapping mapping, InstitutionalProposalForm form) throws Exception;

    /**
     * This method is used to delete an existing note/attachment
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return mapping forward
     * @throws Exception
     */
    public abstract ActionForward deleteNote(ActionMapping mapping, InstitutionalProposalForm form, int lineToDelete) throws Exception;

}
