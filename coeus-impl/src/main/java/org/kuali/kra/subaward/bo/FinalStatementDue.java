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

import java.util.Arrays;


public enum FinalStatementDue implements org.kuali.rice.core.api.mo.common.Coded, Coded, Describable {
    PTE("PPED", "Project Period End Date"),
    SUBRECIPIENT("BPED", "Budget Period End Date");

    private final String code;
    private final String description;

    FinalStatementDue(String code, String description) {
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

    public static FinalStatementDue fromCode(String code) {
        return Arrays.stream(FinalStatementDue.values()).filter(v -> v.getCode().equals(code)).findFirst().orElse(null);
    }
}
