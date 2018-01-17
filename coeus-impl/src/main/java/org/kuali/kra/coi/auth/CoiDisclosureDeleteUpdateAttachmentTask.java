/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.auth;

import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.kra.coi.notesandattachments.attachments.CoiDisclosureAttachment;

public class CoiDisclosureDeleteUpdateAttachmentTask extends CoiDisclosureTask {

    private CoiDisclosureAttachment attachment;

    public CoiDisclosureDeleteUpdateAttachmentTask(String taskName, CoiDisclosure coiDisclosure, CoiDisclosureAttachment attachment) {
        super(taskName, coiDisclosure);
        this.attachment = attachment;
    }

    public CoiDisclosureAttachment getAttachment() {
        return attachment;
    }
    
    

}
