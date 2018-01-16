/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.protocol.reference;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.protocol.ProtocolAssociateBase;
import org.kuali.kra.protocol.ProtocolBase;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;


public abstract class ProtocolReferenceBase extends ProtocolAssociateBase {


    private static final long serialVersionUID = 7610203950849323256L;

    private Long protocolReferenceId;

    private Integer protocolReferenceNumber;

    private Integer protocolReferenceTypeCode;

    private String referenceKey;

    private Date applicationDate;

    private Date approvalDate;

    private String comments;

    private ProtocolReferenceTypeBase protocolReferenceType;

    /**
	 * 
	 * Constructs a ProtocolReferenceBase.java.
	 */
    public ProtocolReferenceBase() {
    }

    /**
	 * 
	 * Constructs a ProtocolReferenceBase.java.
	 * @param bean
	 * @param protocol
	 * @param protocolReferenceType
	 * @throws ParseException
	 */
    public ProtocolReferenceBase(ProtocolReferenceBeanBase bean, ProtocolBase protocol, ProtocolReferenceTypeBase protocolReferenceType) throws ParseException {
        this.protocolReferenceType = protocolReferenceType;
        this.protocolReferenceTypeCode = protocolReferenceType.getProtocolReferenceTypeCode();
        this.setProtocol(protocol);
        this.setProtocolId(protocol.getProtocolId());
        this.setProtocolNumber(protocol.getProtocolNumber());
        this.referenceKey = bean.getReferenceKey();
        this.comments = bean.getComments();
        this.setApplicationDate(convertStringToDate(bean.getApplicationDate()));
        this.setApprovalDate(convertStringToDate(bean.getApprovalDate()));
    }

    private Date convertStringToDate(String stringDate) throws ParseException {
        if (!StringUtils.isBlank(stringDate)) {
            Date date = new Date(DateFormat.getDateInstance(DateFormat.SHORT).parse(stringDate).getTime());
            return date;
        } else {
            return null;
        }
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

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public ProtocolReferenceTypeBase getProtocolReferenceType() {
        return protocolReferenceType;
    }

    public void setProtocolReferenceType(ProtocolReferenceTypeBase protocolReferenceType) {
        this.protocolReferenceType = protocolReferenceType;
    }

    /**
	 * {@inheritDoc}
	 * sets the protocol reference number to null.
	 */
    @Override
    public void postInitHook(ProtocolBase aProtocol) {
        this.setProtocolReferenceNumber(null);
    }

    @Override
    public void resetPersistenceState() {
        this.setProtocolReferenceId(null);
    }
}
