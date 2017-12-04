/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2017 Kuali, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
