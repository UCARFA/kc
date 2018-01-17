/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

import java.util.List;

public class AwardBasisOfPayment extends KcPersistableBusinessObjectBase {


    private static final long serialVersionUID = 5594710065439322293L;

    private String basisOfPaymentCode;

    private String description;

    private List<ValidBasisMethodPayment> validBasisMethodPayments;

    public AwardBasisOfPayment() {
    }

    public String getBasisOfPaymentCode() {
        return basisOfPaymentCode;
    }

    public void setBasisOfPaymentCode(String basisOfPaymentCode) {
        this.basisOfPaymentCode = basisOfPaymentCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the validBasisMethodPayments attribute. 
     * @return Returns the validBasisMethodPayments.
     */
    public List<ValidBasisMethodPayment> getValidBasisMethodPayments() {
        return validBasisMethodPayments;
    }

    /**
     * Sets the validBasisMethodPayments attribute value.
     * @param validBasisMethodPayments The validBasisMethodPayments to set.
     */
    public void setValidBasisMethodPayments(List<ValidBasisMethodPayment> validBasisMethodPayments) {
        this.validBasisMethodPayments = validBasisMethodPayments;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((basisOfPaymentCode == null) ? 0 : basisOfPaymentCode.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((validBasisMethodPayments == null) ? 0 : validBasisMethodPayments.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        AwardBasisOfPayment other = (AwardBasisOfPayment) obj;
        if (basisOfPaymentCode == null) {
            if (other.basisOfPaymentCode != null) return false;
        } else if (!basisOfPaymentCode.equals(other.basisOfPaymentCode)) return false;
        if (description == null) {
            if (other.description != null) return false;
        } else if (!description.equals(other.description)) return false;
        if (validBasisMethodPayments == null) {
            if (other.validBasisMethodPayments != null) return false;
        } else if (!validBasisMethodPayments.equals(other.validBasisMethodPayments)) return false;
        return true;
    }
}
