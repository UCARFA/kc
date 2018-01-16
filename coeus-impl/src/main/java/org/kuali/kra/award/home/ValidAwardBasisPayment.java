/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class ValidAwardBasisPayment extends KcPersistableBusinessObjectBase {

    private Integer validAwardBasisPaymentId;

    private String basisOfPaymentCode;

    private Integer awardTypeCode;

    private AwardBasisOfPayment basisOfPayment;

    private AwardType awardType;

    public ValidAwardBasisPayment() {
    }

    private static final long serialVersionUID = 1L;

    public Integer getValidAwardBasisPaymentId() {
        return validAwardBasisPaymentId;
    }

    public void setValidAwardBasisPaymentId(Integer validAwardBasisPaymentId) {
        this.validAwardBasisPaymentId = validAwardBasisPaymentId;
    }

    public String getBasisOfPaymentCode() {
        return basisOfPaymentCode;
    }

    public void setBasisOfPaymentCode(String basisOfPaymentCode) {
        this.basisOfPaymentCode = basisOfPaymentCode;
    }

    public Integer getAwardTypeCode() {
        return awardTypeCode;
    }

    public void setAwardTypeCode(Integer awardTypeCode) {
        this.awardTypeCode = awardTypeCode;
    }

    public AwardBasisOfPayment getBasisOfPayment() {
        return basisOfPayment;
    }

    public void setBasisOfPayment(AwardBasisOfPayment basisOfPayment) {
        this.basisOfPayment = basisOfPayment;
    }

    public AwardType getAwardType() {
        return awardType;
    }

    public void setAwardType(AwardType awardType) {
        this.awardType = awardType;
    }
}
