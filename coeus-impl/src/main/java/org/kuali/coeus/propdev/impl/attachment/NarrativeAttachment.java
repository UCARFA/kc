/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.attachment;

import javax.persistence.*;

import org.kuali.coeus.common.framework.print.KcAttachmentDataSource;
import org.kuali.coeus.propdev.api.attachment.NarrativeAttachmentContract;

@Entity
@Table(name = "NARRATIVE_ATTACHMENT")
@AttributeOverride(name = "data",  column = @Column(name = "NARRATIVE_DATA"))
@IdClass(Narrative.NarrativeId.class)
public class NarrativeAttachment extends KcAttachmentDataSource implements NarrativeAttachmentContract {

    @Id
    @OneToOne(cascade = { CascadeType.REFRESH })
    @JoinColumns({ @JoinColumn(name = "PROPOSAL_NUMBER", referencedColumnName = "PROPOSAL_NUMBER"), @JoinColumn(name = "MODULE_NUMBER", referencedColumnName = "MODULE_NUMBER") })
    private Narrative narrative;

    @Override
    public Integer getModuleNumber() {
        return this.getNarrative().getModuleNumber();
    }

    public void setModuleNumber(Integer moduleNumber) {
        this.getNarrative().setModuleNumber(moduleNumber);
    }

    @Override
    public String getProposalNumber() {
        return this.getNarrative().getProposalNumber();
    }

    public Narrative getNarrative() {
        return narrative;
    }

    public void setNarrative(Narrative narrative) {
        this.narrative = narrative;
    }
}
