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

public enum HumanDataExchangeTerms implements org.kuali.rice.core.api.mo.common.Coded, Coded, Describable {
    ADDITIONAL_TERMS("AT", "In the Additional Terms section below"),
    SEPARATE_AGREEMENT("SP", "Via a separate Data Use Agreement");

    private final String code;
    private final String description;

    HumanDataExchangeTerms(String code, String description) {
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