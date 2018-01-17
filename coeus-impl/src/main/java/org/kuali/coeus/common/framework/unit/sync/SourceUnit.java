/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.unit.sync;

import org.kuali.coeus.sys.api.model.Coded;
import org.kuali.coeus.sys.api.model.Describable;

import java.util.Arrays;

public enum SourceUnit implements org.kuali.rice.core.api.mo.common.Coded, Coded, Describable {
    PERSON_APPOINTMENTS("RESBOOT1", "Person Appointments"),
    PERSON_PRIMARY_DEPARTMENTS("RESBOOT2", "Person Primary Departments"),
    PERSON_SECONDARY_DEPARTMENTS("RESBOOT3", "Person Secondary Departments");
    private final String code;
    private final String description;

    SourceUnit(String code, String description) {
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

    public static SourceUnit fromCode(String code) {
        return Arrays.stream(values())
                .filter(v -> v.getCode().equals(code))
                .findFirst()
                .<IllegalArgumentException>orElseThrow(() -> {
                    throw new IllegalArgumentException("invalid code" + code);
                });
    }
}
