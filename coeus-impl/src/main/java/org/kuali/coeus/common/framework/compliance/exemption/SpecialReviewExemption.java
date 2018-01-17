/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.compliance.exemption;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * Defines the base class for the Special Review Exemption business object for all modules.
 */
@MappedSuperclass
public abstract class SpecialReviewExemption extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = -3039637933149436453L;

    @Column(name = "EXEMPTION_TYPE_CODE")
    private String exemptionTypeCode;

    @ManyToOne
    @JoinColumn(name = "EXEMPTION_TYPE_CODE", referencedColumnName = "EXEMPTION_TYPE_CODE", insertable = false, updatable = false)
    private ExemptionType exemptionType;

    public String getExemptionTypeCode() {
        return exemptionTypeCode;
    }

    public void setExemptionTypeCode(String exemptionTypeCode) {
        this.exemptionTypeCode = exemptionTypeCode;
    }

    public ExemptionType getExemptionType() {
        return exemptionType;
    }

    public void setExemptionType(ExemptionType exemptionType) {
        this.exemptionType = exemptionType;
    }
}
