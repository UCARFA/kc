/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.person;

import org.kuali.coeus.sys.api.model.Coded;
import org.kuali.coeus.sys.api.model.Describable;

import java.util.Arrays;

public enum UnitPopulationBehavior implements org.kuali.rice.core.api.mo.common.Coded, Coded, Describable {
    NONE("NONE", "None", 1),
    PRIMARY("PRIMARY", "Primary/Home Unit", 2),
    ALL("ALL", "All Affiliations & Appointments", 3),
    SELECTED("SELECTED", "Selected Affiliations & Appointments", 4);
    private final String code;
    private final String description;
    private final int order;

    UnitPopulationBehavior(String code, String description, int order) {
        this.code = code;
        this.description = description;
        this.order = order;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public int getOrder() { return order; }

    public static UnitPopulationBehavior fromCode(String code) {
        return Arrays.stream(values())
                .filter(v -> v.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("invalid code " + code));
    }

}
