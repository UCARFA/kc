/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.service.impl.versioningartifacts;

import org.kuali.coeus.common.framework.version.sequence.associate.SeparatelySequenceableAssociate;

import java.util.Random;

/**
 * This class represents an attachment type that needs to be managed in a 
 * many-to-many way to prevent unnecessary copying of attachments that can 
 * be very large
 */
public class SequenceAssociateAttachmentBO2 implements SeparatelySequenceableAssociate {
    private static final long serialVersionUID = -1764304273143080320L;
    
    private Long attachmentId;
    private String name;
    private Integer sequenceNumber = 0;

    public SequenceAssociateAttachmentBO2(String name) {
        this.name = name;
        setAttachmentId(new Random().nextLong());
    }
        
    public Long getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }
    
    @Override
    public void resetPersistenceState() {
        setAttachmentId(null);
    }
    
    @Override
    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public void incrementSequenceNumber() {
        sequenceNumber++;   
     }
}
