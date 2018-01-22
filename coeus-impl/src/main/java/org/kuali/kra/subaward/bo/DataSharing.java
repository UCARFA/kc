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


public enum DataSharing implements org.kuali.rice.core.api.mo.common.Coded, Coded, Describable {
    ATTACHED("ATT", "Attached"),
    PROVIDED_UPON_REQUEST("PUR", "Provided Upon Request"),
    NOT_APPLICABLE("NA", "Not Applicable");

    private final String code;
    private final String description;

    DataSharing(String code, String description) {
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

    public static DataSharing fromCode(String code) {
        return Arrays.stream(DataSharing.values()).filter(v -> v.getCode().equals(code)).findFirst().orElse(null);
    }
}
