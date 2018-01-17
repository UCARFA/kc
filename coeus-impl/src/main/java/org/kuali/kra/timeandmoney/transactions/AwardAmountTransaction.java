/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.timeandmoney.transactions;

import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.coeus.common.framework.person.KcPersonService;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.krad.util.ObjectUtils;

import java.io.Serializable;
import java.sql.Date;

public class AwardAmountTransaction extends KcPersistableBusinessObjectBase implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long awardAmountTransactionId;

    private String awardNumber;

    private String documentNumber;

    private Integer transactionTypeCode;

    private Date noticeDate;

    private String comments;

    private AwardTransactionType awardTransactionType;

    private transient KcPersonService kcPersonService;

    public AwardAmountTransaction() {
    }

    public Long getAwardAmountTransactionId() {
        return awardAmountTransactionId;
    }

    public void setAwardAmountTransactionId(Long awardAmountTransactionId) {
        this.awardAmountTransactionId = awardAmountTransactionId;
    }

    public String getAwardNumber() {
        return awardNumber;
    }

    public void setAwardNumber(String awardNumber) {
        this.awardNumber = awardNumber;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Integer getTransactionTypeCode() {
        return transactionTypeCode;
    }

    public void setTransactionTypeCode(Integer transactionTypeCode) {
        this.transactionTypeCode = transactionTypeCode;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Gets the awardTransactionType attribute. 
     * @return Returns the awardTransactionType.
     */
    public AwardTransactionType getAwardTransactionType() {
        return awardTransactionType;
    }

    /**
     * Sets the awardTransactionType attribute value.
     * @param awardTransactionType The awardTransactionType to set.
     */
    public void setAwardTransactionType(AwardTransactionType awardTransactionType) {
        this.awardTransactionType = awardTransactionType;
    }

    /**
     *
     * This is ahelper method to get author person name
     * @return
     */
    public String getAuthorPersonName() {
        KcPerson person = this.getKcPersonService().getKcPersonByUserName(getUpdateUser());
        return ObjectUtils.isNull(person) ? "Person not found" : person.getFullName();
    }

    /**
     * Looks up and returns the KcPersonService.
     * @return the person service.
     */
    protected KcPersonService getKcPersonService() {
        if (this.kcPersonService == null) {
            this.kcPersonService = KcServiceLocator.getService(KcPersonService.class);
        }
        return this.kcPersonService;
    }
}
