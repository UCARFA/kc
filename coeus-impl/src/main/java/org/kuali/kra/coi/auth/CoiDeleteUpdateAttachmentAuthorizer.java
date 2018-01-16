/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.auth;


import java.util.Objects;
import org.kuali.kra.coi.notesandattachments.attachments.CoiDisclosureAttachment;
import org.kuali.rice.kim.api.identity.IdentityService;
import org.kuali.rice.kim.api.role.RoleService;

public class CoiDeleteUpdateAttachmentAuthorizer extends CoiDeleteUpdateNotesAttachmentsAuthorizerBase {

    private RoleService roleService;
    private IdentityService identityService;

    @Override
    public boolean isAuthorized(String userId, CoiDisclosureTask task) {
        CoiDisclosureDeleteUpdateAttachmentTask deleteUpdateTask = (CoiDisclosureDeleteUpdateAttachmentTask) task;
        CoiDisclosureAttachment attachment = deleteUpdateTask.getAttachment();      
        String attachmentCreator = attachment.getUpdateUser();
        if (attachment.getOriginalCoiDisclosureId() != null
                && !Objects.equals(attachment.getOriginalCoiDisclosureId(), task.getCoiDisclosure().getCoiDisclosureId())) {
            return false;
        } else {
            return isAuthorized(userId, task, attachmentCreator);
        }
    }
    
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
    
    public void setIdentityService(IdentityService identityService) {
        this.identityService = identityService;
    }
    
    @Override
    public IdentityService getIdentityService() {
        return identityService;
    }

    @Override
    public RoleService getRoleService() {
        return roleService;
    }

}
