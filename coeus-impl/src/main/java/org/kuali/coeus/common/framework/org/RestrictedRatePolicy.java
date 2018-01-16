/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.org;

import org.kuali.coeus.sys.api.model.Coded;
import org.kuali.coeus.sys.api.model.Describable;

public enum RestrictedRatePolicy implements org.kuali.rice.core.api.mo.common.Coded, Coded, Describable {
    INCLUDED_IN_AGREEMENT("I", "Is included in the approved indirect cost rate agreement"),
    COMPLIES_34_CFR_76_564("C", "Complies with 34 CFR 76.564(c)");

    private final String code;
    private final String description;

    RestrictedRatePolicy(String code, String description) {
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
