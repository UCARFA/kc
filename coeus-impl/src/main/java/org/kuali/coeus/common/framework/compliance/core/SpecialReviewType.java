/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.compliance.core;

import org.kuali.coeus.common.api.compliance.core.SpecialReviewTypeContract;
import org.kuali.kra.bo.KraSortablePersistableBusinessObjectBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Defines the type of the Special Review.
 */
@Entity
@Table(name = "SPECIAL_REVIEW")
public class SpecialReviewType extends KraSortablePersistableBusinessObjectBase implements SpecialReviewTypeContract {

    /**
     * The Human Subjects Special Review type.
     */
    public static final String HUMAN_SUBJECTS = "1";

    public static final String ANIMAL_USAGE = "2";

    private static final long serialVersionUID = -7939863013575475658L;

    @Id
    @Column(name = "SPECIAL_REVIEW_CODE")
    private String specialReviewTypeCode;

    @Column(name = "DESCRIPTION")
    private String description;

    public String getSpecialReviewTypeCode() {
        return specialReviewTypeCode;
    }

    public void setSpecialReviewTypeCode(String specialReviewTypeCode) {
        this.specialReviewTypeCode = specialReviewTypeCode;
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
        return getSpecialReviewTypeCode();
    }
}
