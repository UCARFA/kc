/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.compliance.core;

import org.kuali.coeus.common.api.compliance.core.SpecialReviewApprovalTypeContract;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Defines the Special Review Approval Type business object for all modules.
 */
@Entity
@Table(name = "SP_REV_APPROVAL_TYPE")
public class SpecialReviewApprovalType extends KcPersistableBusinessObjectBase implements SpecialReviewApprovalTypeContract {

    /**
     * The type code for Approval Type 'Approved'.
     */
    public static final String PENDING = "1";

    public static final String APPROVED = "2";

    public static final String NOT_YET_APPLIED = "3";

    public static final String EXEMPT = "4";

    /**
     * The type code for Approval Type 'Link to IRB'.
     */
    public static final String LINK_TO_IRB = "5";

    /**
     * The type code for Approval Type 'Link to IACUC'.
     */
    public static final String LINK_TO_IACUC = "6";

    private static final long serialVersionUID = -3695729124365459765L;

    @Id
    @Column(name = "APPROVAL_TYPE_CODE")
    private String approvalTypeCode;

    @Column(name = "DESCRIPTION")
    private String description;

    public String getApprovalTypeCode() {
        return approvalTypeCode;
    }

    public void setApprovalTypeCode(String approvalTypeCode) {
        this.approvalTypeCode = approvalTypeCode;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getCode() {
        return getApprovalTypeCode();
    }
}
