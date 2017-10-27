/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.coeus.propdev.impl.specialreview;

import org.kuali.coeus.common.framework.print.KcAttachmentDataSource;
import org.kuali.coeus.propdev.api.specialreview.ProposalSpecialReviewAttachmentContract;
import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.krad.data.jpa.PortableSequenceGenerator;
import org.kuali.rice.krad.data.jpa.converters.BooleanYNConverter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

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

    @Transient
    private Long size;

    @Transient
    private transient MultipartFile multipartFile;

    @Transient
    private transient SoftReference<String> attachmentXmlFileData;
    @Transient
    private transient ProposalSpecialReviewHumanSubjectsAttachmentService proposalSpecialReviewHumanSubjectsAttachmentService;
    @Transient
    private transient GlobalVariableService globalVariableService;

    public void init(MultipartFile multipartFile) throws Exception {
        this.size = multipartFile.getSize();
        this.setType(multipartFile.getContentType());
        this.setData(multipartFile.getBytes());
        this.setName(multipartFile.getOriginalFilename());
    }


    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

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

    public String getStudyTitle() {
        return studyTitle;
    }

    public Boolean getClinicalTrial() {
        return clinicalTrial;
    }

    public void setStudyTitle(String studyTitle) {
        this.studyTitle = studyTitle;
    }

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

    public Map<String, Object> getSpecialReviewAttachmentXmlFileData() {
        Map<String, Object> data = getAttachmentService().getSpecialReviewAttachmentXmlFileData(getData());
        if (data == null) {
            getGlobalVariableService().getMessageMap().putError(Constants.NO_FIELD, KeyConstants.CANNOT_PARSE_PDF, getName());
        }
        return data;
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
