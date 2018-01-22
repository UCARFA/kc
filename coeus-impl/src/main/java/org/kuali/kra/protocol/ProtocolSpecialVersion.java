/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.kra.protocol;

public enum ProtocolSpecialVersion {
    AMENDMENT("A", "Amendment"),
    RENEWAL("R", "Renewal"),
    CONTINUATION ("C", "Continuation"),
    FYI ("F", "FYI");

    private final String code;
    private final String description;

    ProtocolSpecialVersion(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
