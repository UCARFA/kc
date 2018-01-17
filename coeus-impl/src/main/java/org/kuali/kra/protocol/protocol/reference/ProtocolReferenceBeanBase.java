/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.protocol.reference;

import java.io.Serializable;

/**
 * 
 * This class is a form helper for ProtocolReferenceBase objects.
 */
public abstract class ProtocolReferenceBeanBase implements Serializable {


    private static final long serialVersionUID = 6775965004016986063L;

    private Long protocolReferenceId;
    private Integer protocolReferenceNumber;
    private Integer protocolReferenceTypeCode;
    private String referenceKey;
    private String applicationDate;
    private String approvalDate;
    private String comments;


    public ProtocolReferenceBeanBase() {
        init();
    }
    
    /**
     * 
     * This method initializes this class.
     */
    public void init() {
            setProtocolReferenceId(null);
            setProtocolReferenceNumber(null);
            setProtocolReferenceTypeCode(null);
            setReferenceKey("");
            setApplicationDate("");
            setApprovalDate("");
            setComments("");
    }

    public void setProtocolReferenceId(Long protocolReferenceId) {
        this.protocolReferenceId = protocolReferenceId;
    }

    public Long getProtocolReferenceId() {
        return protocolReferenceId;
    }

    public Integer getProtocolReferenceNumber() {
        return protocolReferenceNumber;
    }

    public void setProtocolReferenceNumber(Integer protocolReferenceNumber) {
        this.protocolReferenceNumber = protocolReferenceNumber;
    }

    public Integer getProtocolReferenceTypeCode() {
        return protocolReferenceTypeCode;
    }

    public void setProtocolReferenceTypeCode(Integer protocolReferenceTypeCode) {
        this.protocolReferenceTypeCode = protocolReferenceTypeCode;
    }

    public String getReferenceKey() {
        return referenceKey;
    }

    public void setReferenceKey(String referenceKey) {
        this.referenceKey = referenceKey;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        String newLine = "\n";
        sb.append("protocolReferenceId: ").append(this.protocolReferenceId).append(newLine);
        sb.append("protocolReferenceNumber: ").append(this.protocolReferenceNumber).append(newLine);
        sb.append("protocolReferenceTypeCode: ").append(this.protocolReferenceTypeCode).append(newLine);
        sb.append("referenceKey: ").append(this.referenceKey).append(newLine);
        sb.append("applicationDate: ").append(this.applicationDate).append(newLine);
        sb.append("approvalDate: ").append(this.approvalDate).append(newLine);
        sb.append("comments: ").append(this.comments).append(newLine);
        return sb.toString();
    }
}
