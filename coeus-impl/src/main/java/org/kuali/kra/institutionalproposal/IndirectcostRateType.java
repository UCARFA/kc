/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class IndirectcostRateType extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 1L;

    private Integer indirectcostRateTypeCode;

    private String description;

    public IndirectcostRateType() {
    }

    public Integer getIndirectcostRateTypeCode() {
        return indirectcostRateTypeCode;
    }

    public void setIndirectcostRateTypeCode(Integer indirectcostRateTypeCode) {
        this.indirectcostRateTypeCode = indirectcostRateTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
