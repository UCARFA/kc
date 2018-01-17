/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.correspondence;

import org.apache.struts.upload.FormFile;
import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.coeus.common.committee.impl.service.CommitteeServiceBase;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;

public abstract class ProtocolCorrespondenceTemplateBase extends KcPersistableBusinessObjectBase implements Comparable<ProtocolCorrespondenceTemplateBase> {

    private static final long serialVersionUID = 1L;

    private Integer protoCorrespTemplId;

    private String protoCorrespTypeCode;

    private String committeeId;

    private String fileName;

    private byte[] correspondenceTemplate;

    private transient FormFile templateFile;

    public ProtocolCorrespondenceTemplateBase() {
        super();
    }

    public Integer getProtoCorrespTemplId() {
        return protoCorrespTemplId;
    }

    public void setProtoCorrespTemplId(Integer protoCorrespTemplId) {
        this.protoCorrespTemplId = protoCorrespTemplId;
    }

    public String getProtoCorrespTypeCode() {
        return protoCorrespTypeCode;
    }

    public void setProtoCorrespTypeCode(String protoCorrespTypeCode) {
        this.protoCorrespTypeCode = protoCorrespTypeCode;
    }

    public void setCommitteeId(String committeeId) {
        this.committeeId = committeeId;
    }

    public String getCommitteeId() {
        return committeeId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getCorrespondenceTemplate() {
        return correspondenceTemplate;
    }

    public void setCorrespondenceTemplate(byte[] correspondenceTemplate) {
        this.correspondenceTemplate = correspondenceTemplate;
    }

    public CommitteeBase getCommittee() {
        return getCommitteeService().getCommitteeById(committeeId);
    }

    public void setTemplateFile(FormFile templateFile) {
        this.templateFile = templateFile;
    }

    public FormFile getTemplateFile() {
        return templateFile;
    }

    @Override
    public int compareTo(ProtocolCorrespondenceTemplateBase arg) {
        return this.getCommittee().getCommitteeName().compareTo(arg.getCommittee().getCommitteeName());
    }

    private CommitteeServiceBase getCommitteeService() {
        return KcServiceLocator.getService(getCommitteeServiceClassHook());
    }
    
    protected abstract Class<? extends CommitteeServiceBase> getCommitteeServiceClassHook();
}
