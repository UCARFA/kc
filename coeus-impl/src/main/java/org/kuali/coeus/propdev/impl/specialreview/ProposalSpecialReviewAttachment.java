/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.specialreview;

import org.kuali.coeus.common.framework.print.KcAttachmentDataSource;
import org.kuali.coeus.propdev.api.specialreview.ProposalSpecialReviewAttachmentContract;
import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.krad.data.jpa.PortableSequenceGenerator;
import org.kuali.rice.krad.data.jpa.converters.BooleanYNConverter;
import org.kuali.rice.krad.web.bind.RequestAccessible;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@Entity
@Table(name = "EPS_PROP_SPL_REVIEW_ATTACHMENT")
public class ProposalSpecialReviewAttachment extends KcAttachmentDataSource implements ProposalSpecialReviewAttachmentContract{

    @PortableSequenceGenerator(name = "SEQ_EPS_PROP_SPL_RVW_ATT_ID")
    @GeneratedValue(generator = "SEQ_EPS_PROP_SPL_RVW_ATT_ID")
    @Id
    @Column(name = "PROPOSAL_SPECIAL_REVIEW_ATT_ID")
    private Long id;

    @Column(name = "CLINICAL_TRIAL")
    @Convert(converter = BooleanYNConverter.class)
    private Boolean clinicalTrial;

    @Column(name = "STUDY_TITLE")
    private String studyTitle;

    @Column(name = "IS_ATTACHMENT_DELAYED_ONSET")
    @Convert(converter = BooleanYNConverter.class)
    private Boolean isAttachmentDelayedOnset;

    @RequestAccessible
    @Transient
    private transient MultipartFile multipartFile;

    @Transient
    private transient SoftReference<String> attachmentXmlFileData;
    @Transient
    private transient ProposalSpecialReviewHumanSubjectsAttachmentService proposalSpecialReviewHumanSubjectsAttachmentService;
    @Transient
    private transient GlobalVariableService globalVariableService;
    @Transient
    private final AtomicBoolean initialized = new AtomicBoolean(false);

    public void init(MultipartFile multipartFile) throws Exception {
        if (initialized.compareAndSet(false, true)) {
            this.setType(multipartFile.getContentType());
            this.setData(multipartFile.getBytes());
            this.setName(multipartFile.getOriginalFilename());
        }
    }


    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        if (multipartFile != null && !multipartFile.isEmpty()) {
            this.multipartFile = multipartFile;
            initialized.set(false);
        }
    }

    @Override
    public Boolean isAttachmentDelayedOnset() {
        return isAttachmentDelayedOnset;
    }

    public Boolean getIsAttachmentDelayedOnset() {
        return isAttachmentDelayedOnset;
    }

    public void setIsAttachmentDelayedOnset(Boolean isAttachmentDelayedOnset) {
        this.isAttachmentDelayedOnset = isAttachmentDelayedOnset;
    }

    public void setClinicalTrial(Boolean clinicalTrial) {
        this.clinicalTrial = clinicalTrial;
    }

    @Override
    public String getStudyTitle() {
        return studyTitle;
    }

    @Override
    public Boolean getClinicalTrial() {
        return clinicalTrial;
    }

    public void setStudyTitle(String studyTitle) {
        this.studyTitle = studyTitle;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SoftReference<String> getAttachmentXmlFileData() {
        return attachmentXmlFileData;
    }

    public void setAttachmentXmlFileData(SoftReference<String> attachmentXmlFileData) {
        this.attachmentXmlFileData = attachmentXmlFileData;
    }

    @Override
    public Map<String, Object> getSpecialReviewAttachmentXmlFileData() {
        return getAttachmentService().getSpecialReviewAttachmentXmlFileData(getData());
    }

    public GlobalVariableService getGlobalVariableService() {
            if (globalVariableService == null) {
                globalVariableService = KcServiceLocator.getService(GlobalVariableService.class);
            }
            return globalVariableService;
    }

    public ProposalSpecialReviewHumanSubjectsAttachmentService getAttachmentService() {
        if (proposalSpecialReviewHumanSubjectsAttachmentService == null) {
            proposalSpecialReviewHumanSubjectsAttachmentService = KcServiceLocator.getService(ProposalSpecialReviewHumanSubjectsAttachmentService.class);
        }
        return proposalSpecialReviewHumanSubjectsAttachmentService;
    }

}
