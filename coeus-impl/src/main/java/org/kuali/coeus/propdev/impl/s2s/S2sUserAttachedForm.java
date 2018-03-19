/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.s2s;

import org.kuali.coeus.common.framework.attachment.FileMetaKcFileDto;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.propdev.api.s2s.S2sUserAttachedFormContract;
import org.kuali.rice.krad.data.jpa.PortableSequenceGenerator;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;

@Entity
@Table(name = "S2S_USER_ATTACHED_FORM")
public class S2sUserAttachedForm extends KcPersistableBusinessObjectBase implements S2sUserAttachedFormContract {
    

    @PortableSequenceGenerator(name = "SEQ_S2S_USER_ATTD_FORM_ID")
    @GeneratedValue(generator = "SEQ_S2S_USER_ATTD_FORM_ID")
    @Id
    @Column(name = "S2S_USER_ATTACHED_FORM_ID")
    private Long id;
    
    @Column(name = "PROPOSAL_NUMBER")
    private String proposalNumber;
    
    @ManyToOne(cascade = { CascadeType.REFRESH })
    @JoinColumn(name = "PROPOSAL_NUMBER", insertable = false, updatable = false)
    private DevelopmentProposal developmentProposal;
    
    @Column(name = "NAMESPACE")
    private String namespace; 
    
    @Column(name = "FORM_NAME")
    private String formName; 
    
    @Column(name = "FORM_FILE_NAME")
    private String formFileName;
    
    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy="s2sUserAttachedForm", orphanRemoval = true, cascade = { CascadeType.ALL })
    private List<S2sUserAttachedFormAtt> s2sUserAttachedFormAtts;

    @OneToMany(mappedBy="s2sUserAttachedForm", orphanRemoval = true, cascade = { CascadeType.ALL })
    private List<S2sUserAttachedFormFile> s2sUserAttachedFormFileList;

    @Transient
    private transient boolean edit = false;
    
    @Transient
    private transient MultipartFile newFormFile;

    @Transient
    private transient byte[] newFormFileBytes;

    public S2sUserAttachedForm() {
        s2sUserAttachedFormAtts = new ArrayList<>();
        s2sUserAttachedFormFileList = new ArrayList<>();
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getProposalNumber() {
        return proposalNumber;
    }

    public void setProposalNumber(String proposalNumber) {
        this.proposalNumber = proposalNumber;
    }

    @Override
    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    @Override
    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    @Override
    public String getFormFileName() {
        return formFileName;
    }

    public void setFormFileName(String formFileName) {
        this.formFileName = formFileName;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public MultipartFile getNewFormFile() {
        return newFormFile;
    }

    public void setNewFormFile(MultipartFile newFormFile) {
        this.newFormFile = newFormFile;
    }

    @Override
    public List<S2sUserAttachedFormAtt> getS2sUserAttachedFormAtts() {
        return s2sUserAttachedFormAtts;
    }

    /*
     * This getter exists because the BO contract is incompatible with FileMeta.  This is an adapter method.
     * Be careful renaming this method as it is referenced by KRAD xml
     */
    public List<FileMetaKcFileDto> getS2sUserAttachedFormAttsFileMetas() {
        return getS2sUserAttachedFormAtts().stream().map(att -> {
            final FileMetaKcFileDto file = new FileMetaKcFileDto();
            file.setId(String.valueOf(att.getId()));
            file.setData(att.getData());
            file.setName(att.getName());
            file.setType(att.getType());
            file.setDateUploaded(att.getUpdateTimestamp());
            file.setUrl("");
            return file;
        }).collect(Collectors.toList());
    }

    public void setS2sUserAttachedFormAtts(List<S2sUserAttachedFormAtt> s2sUserAttachedFormAtts) {
        this.s2sUserAttachedFormAtts = s2sUserAttachedFormAtts;
    }

    @Override
    public List<S2sUserAttachedFormFile> getS2sUserAttachedFormFileList() {
        return s2sUserAttachedFormFileList;
    }

    public void setS2sUserAttachedFormFileList(List<S2sUserAttachedFormFile> s2sUserAttachedFormFileList) {
        this.s2sUserAttachedFormFileList = s2sUserAttachedFormFileList;
    }

    public byte[] getNewFormFileBytes() {
        return newFormFileBytes;
    }

    public void setNewFormFileBytes(byte[] newFormFileBytes) {
        this.newFormFileBytes = newFormFileBytes;
    }

	public DevelopmentProposal getDevelopmentProposal() {
		return developmentProposal;
	}

	public void setDevelopmentProposal(DevelopmentProposal developmentProposal) {
		this.developmentProposal = developmentProposal;
	}
}
