/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.noteattachment;

import org.kuali.coeus.common.framework.auth.SystemAuthorizationService;
import org.kuali.coeus.common.framework.auth.task.TaskAuthorizationService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.RoleConstants;
import org.kuali.kra.infrastructure.TaskName;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.irb.ProtocolForm;
import org.kuali.kra.irb.auth.ProtocolTask;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.noteattachment.NotesAttachmentsHelperBase;
import org.kuali.rice.core.api.datetime.DateTimeService;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.krad.util.GlobalVariables;

/**
 * This is the "Helper" class for Protocol Notes And Attachments.
 */
public class NotesAttachmentsHelper extends NotesAttachmentsHelperBase {
   
    /**
     * Constructs a helper setting the dependencies to default values.
     * @param form the form
     * @throws IllegalArgumentException if the form is null
     */
    public NotesAttachmentsHelper(final ProtocolForm form) {
        super(form, KcServiceLocator.getService(ProtocolAttachmentService.class),
                   KcServiceLocator.getService(TaskAuthorizationService.class),
                   KcServiceLocator.getService(SystemAuthorizationService.class),
                   KcServiceLocator.getService(DateTimeService.class),
                   KcServiceLocator.getService(ProtocolNotepadService.class),
                   KcServiceLocator.getService(ParameterService.class),
                   new ProtocolAttachmentVersioningUtility(form));
    }
        
    /**
     * Checks if Protocol Attachments can be modified.
     * @return true if can be modified false if cannot
     */
    @Override
    public boolean canEditProtocolAttachments() {
        final ProtocolTask task = new ProtocolTask(TaskName.MODIFY_PROTOCOL_ATTACHMENTS, (Protocol) this.getProtocol());
        return this.authService.isAuthorized(this.getUserIdentifier(), task);
    }
        
    /**
     * Checks if Protocol Notepads can be modified.
     * @return true if can be modified false if cannot
     */
    @Override
    public boolean canAddProtocolNotepads() {
        final ProtocolTask task = new ProtocolTask(TaskName.ADD_PROTOCOL_NOTES, (Protocol) this.getProtocol());
        return this.authService.isAuthorized(this.getUserIdentifier(), task);
    }
    
    /**
     * Checks if restricted Protocol Notepads can be viewed.
     * @return true if can be modified false if cannot
     */
    @Override
    public boolean canViewRestrictedProtocolNotepads() {
        final ProtocolTask task = new ProtocolTask(TaskName.VIEW_RESTRICTED_NOTES, (Protocol) this.getProtocol());
        return this.authService.isAuthorized(this.getUserIdentifier(), task);
    }

    @Override
    public boolean isProtocolAdmin() {
        return this.systemAuthorizationService.hasRole(GlobalVariables.getUserSession().getPrincipalId(), NAMESPACE, RoleConstants.IRB_ADMINISTRATOR);
    }
    
    @Override
    public AddProtocolAttachmentProtocolRuleImpl getAddProtocolAttachmentProtocolRuleInstanceHook() {
        return new AddProtocolAttachmentProtocolRuleImpl();
    }

    @Override
    protected ProtocolAttachmentProtocol createNewProtocolAttachmentProtocolInstanceHook(ProtocolBase protocol) {
        return new ProtocolAttachmentProtocol((Protocol) protocol);
    }

    @Override
    protected ProtocolAttachmentPersonnel createNewProtocolAttachmentPersonnelInstanceHook(ProtocolBase protocol) {
        return new ProtocolAttachmentPersonnel((Protocol) protocol);
    }

    @Override
    protected ProtocolAttachmentFilter createNewProtocolAttachmentFilterInstanceHook() {
        return new ProtocolAttachmentFilter();
    }

    @Override
    protected String getAttachmentDefaultSortKeyHook() {
        return Constants.PARAMETER_PROTOCOL_ATTACHMENT_DEFAULT_SORT;
    }

    @Override
    public Class<ProtocolAttachmentProtocol> getProtocolAttachmentProtocolClassHook() {
        return ProtocolAttachmentProtocol.class;
    }

    @Override
    public Class<ProtocolAttachmentPersonnel> getProtocolAttachmentPersonnelClassHook() {
        return ProtocolAttachmentPersonnel.class;
    }

    @Override
    public Class<ProtocolNotepad> getProtocolNotepadClassHook() {
        return ProtocolNotepad.class;
    }

    @Override
    public Class<ProtocolDocument> getProtocolDocumentClassHook() {
        return ProtocolDocument.class;
    }

    @Override
    protected ProtocolNotepad createNewProtocolNotepadInstanceHook(ProtocolBase protocol) {
        return new ProtocolNotepad((Protocol) protocol);
    }


}
