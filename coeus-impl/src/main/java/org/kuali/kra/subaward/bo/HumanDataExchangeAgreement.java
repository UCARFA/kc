/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.bo;

import org.kuali.coeus.sys.api.model.Coded;
import org.kuali.coeus.sys.api.model.Describable;

public enum HumanDataExchangeAgreement implements org.kuali.rice.core.api.mo.common.Coded, Coded, Describable {
    NOT_APPLICABLE("NA", "Not Applicable"),
    SUBRECIPIENT_TO_PTE("SP", "From Subrecipient to PTE"),
    PTE_TO_SUBRECIPIENT("PS", "From PTE to Subrecipient"),
    FROM_BOTH_PTE_AND_SUBRECIPIENT("BT", "From both PTE and Subrecipient");

    private final String code;
    private final String description;

    HumanDataExchangeAgreement(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }
}