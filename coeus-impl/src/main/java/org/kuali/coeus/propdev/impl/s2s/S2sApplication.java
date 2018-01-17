/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.s2s;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.propdev.api.s2s.S2sApplicationContract;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "S2S_APPLICATION")
public class S2sApplication extends KcPersistableBusinessObjectBase implements S2sApplicationContract {

    @Id
    @Column(name = "PROPOSAL_NUMBER")
    private String proposalNumber;

    @Column(name = "APPLICATION")
    @Lob
    private String application;

    @OneToMany(orphanRemoval = true, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PROPOSAL_NUMBER", referencedColumnName = "PROPOSAL_NUMBER")
    private List<S2sAppAttachments> s2sAppAttachmentList;

    @Override
    public String getProposalNumber() {
        return proposalNumber;
    }

    public void setProposalNumber(String proposalNumber) {
        this.proposalNumber = proposalNumber;
    }

    @Override
    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    @Override
    public List<S2sAppAttachments> getS2sAppAttachmentList() {
        return s2sAppAttachmentList;
    }

    public void setS2sAppAttachmentList(List<S2sAppAttachments> s2sAppAttachmentList) {
        this.s2sAppAttachmentList = s2sAppAttachmentList;
    }
}
