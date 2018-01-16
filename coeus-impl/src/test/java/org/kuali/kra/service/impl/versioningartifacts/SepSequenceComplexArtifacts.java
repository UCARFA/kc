/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.service.impl.versioningartifacts;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.kuali.coeus.common.framework.version.sequence.associate.SeparatelySequenceableAssociate;
import org.kuali.coeus.common.framework.version.sequence.associate.SequenceAssociate;
import org.kuali.coeus.common.framework.version.sequence.owner.SequenceOwner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

/**
 * This class holds related testing artifacts for complex sep seq associate BO structures.
 * 
 * This object structure looks like the following:
 * 
 * AttachmentOwner --1:M--> AttachmentMetaData --M:1--> AttachmentMetaDataAssoc
 *                                                 \--M:1--> AttachmentLargeData
 *
 */
public class SepSequenceComplexArtifacts {

    /** an owner BO that contains some attachments. */
    public static class AttachmentOwner implements SequenceOwner<AttachmentOwner> {
        private Collection<AttachmentMetaData> attachments = new ArrayList<AttachmentMetaData>();
        private Integer sequenceNumber = Integer.valueOf(0);
        private String id = "AttachmentOwner " + UUID.randomUUID().toString(); //randomly give it a id so it is a persisted BO upon construction
    
        public AttachmentOwner() { /* for beanness */ }
        public AttachmentOwner(AttachmentMetaData... attachments) { addAttachments(attachments); }
        @Override
        public Integer getOwnerSequenceNumber() { return null; }
        @Override
        public void incrementSequenceNumber() { sequenceNumber++; }
        @Override
        public AttachmentOwner getSequenceOwner() { return this; }
        @Override
        public void setSequenceOwner(AttachmentOwner newlyVersionedOwner) { /*does nothing*/ }
        @Override
        public Integer getSequenceNumber() { return sequenceNumber; }
        @Override
        public void resetPersistenceState() { id = null; }
        
        public Collection<AttachmentMetaData> getAttachments() { return attachments; }
        public void addAttachments(AttachmentMetaData... attachments) { for (AttachmentMetaData a : attachments) this.attachments.add(a); }
        public void setAttachments(Collection<AttachmentMetaData> attachments) { this.attachments = attachments; }
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        
        @Override
        public String toString() {
            return new ToStringBuilder(this).append("id", id).append("sequenceNumber", sequenceNumber).append("attachments", attachments).toString();
        }
        @Override
        public String getVersionNameField() { return "foobar"; }

        @Override
        public String getVersionNameFieldValue() {
            return null;
        }
    }
    
    /** an attachment BO that just contains meta-data and references to the rest of the attachment data. */
    public static class AttachmentMetaData implements SequenceAssociate<AttachmentOwner> {
        private AttachmentMetaDataAssoc assoc;
        private AttachmentLargeData data;
        private String id = "AttachmentMetaData " + UUID.randomUUID().toString(); //randomly give it a id so it is a persisted BO upon construction
        private AttachmentOwner sequenceOwner;
        
        public AttachmentMetaData() { /* for beanness */ }
        public AttachmentMetaData(AttachmentOwner owner, AttachmentMetaDataAssoc assoc, AttachmentLargeData data) { 
            this.sequenceOwner = owner; 
            this.assoc = assoc;
            this.data = data;
        }
        
        @Override
        public AttachmentOwner getSequenceOwner() { return sequenceOwner; }
        @Override
        public void setSequenceOwner(AttachmentOwner newlyVersionedOwner) { this.sequenceOwner = newlyVersionedOwner; }
        @Override
        public Integer getSequenceNumber() { return this.sequenceOwner.getSequenceNumber(); }
        @Override
        public void resetPersistenceState() { id = null; }
        
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public AttachmentMetaDataAssoc getAssoc() { return assoc; }
        public void setAssoc(AttachmentMetaDataAssoc assoc) { this.assoc = assoc; }
        public AttachmentLargeData getData() { return data; }
        public void setData(AttachmentLargeData data) { this.data = data; }
        
        @Override
        public String toString() {
            return new ToStringBuilder(this).append("id", id).append("assoc", assoc).append("data", data).toString();
        }
    }
    
    /** some attachment meta-data in the form of a BO that is referenced from the main attachment BO. */
    public static class AttachmentMetaDataAssoc implements SequenceAssociate<AttachmentOwner> {
        private String id = "AttachmentMetaDataAssoc " + UUID.randomUUID().toString(); //randomly give it a id so it is a persisted BO upon construction
        private AttachmentOwner sequenceOwner;
        
        public AttachmentMetaDataAssoc() { /* for beanness */ }
        public AttachmentMetaDataAssoc(AttachmentOwner owner) { this.sequenceOwner = owner; }
        
        @Override
        public AttachmentOwner getSequenceOwner() { return sequenceOwner; }
        @Override
        public void setSequenceOwner(AttachmentOwner newlyVersionedOwner) { this.sequenceOwner = newlyVersionedOwner; }
        @Override
        public Integer getSequenceNumber() { return sequenceOwner.getSequenceNumber(); }
        @Override
        public void resetPersistenceState() { id = null; }
        
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        
        @Override
        public String toString() {
            return new ToStringBuilder(this).append("id", id).toString();
        }
    }
    
    /** the large data portion of an attachment. */
    public static class AttachmentLargeData implements SeparatelySequenceableAssociate {
        private String id = "AttachmentLargeData " + UUID.randomUUID().toString(); //randomly give it a id so it is a persisted BO upon construction
        private Integer sequenceNumber = Integer.valueOf(0);
        
        public AttachmentLargeData() { /* for beanness */ }
        
        @Override
        public Integer getSequenceNumber() { return sequenceNumber; }
        @Override
        public void resetPersistenceState() { id = null; }

        @Override
        public void incrementSequenceNumber() { sequenceNumber++; }
        
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        
        @Override
        public String toString() {
            return new ToStringBuilder(this).append("id", id).toString();
        }
    }
}
