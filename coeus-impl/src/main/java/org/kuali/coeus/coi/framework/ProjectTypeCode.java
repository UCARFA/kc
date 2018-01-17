/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.coi.framework;

public enum ProjectTypeCode {
    PROPOSAL(1L), INSTITUTIONAL_PROPOSAL(2L), IRB_PROTOCOL(3L), IACUC_PROTOCOL(4L), AWARD(5L);

    private final Long id;

    ProjectTypeCode(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
