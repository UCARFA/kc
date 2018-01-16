/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.commitments;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * 
 * This class represents the FandaRateType Business Object.
 */
public class FandaRateType extends KcPersistableBusinessObjectBase {


    private static final long serialVersionUID = -6901016199815302736L;

    private Integer fandaRateTypeCode;

    private String description;


    public FandaRateType() {
    }


    public Integer getFandaRateTypeCode() {
        return fandaRateTypeCode;
    }

    /**
     *
     * @param fandaRateTypeCode
     */
    public void setFandaRateTypeCode(Integer fandaRateTypeCode) {
        this.fandaRateTypeCode = fandaRateTypeCode;
    }


    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
