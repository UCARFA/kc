/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.print;

public enum CoiDisclosureType {
    /** Report type for the Approved Disclosure reports that utilize templates. */
    APPROVED_DISCLOSURE_TYPE ("approved_disclosure");
    private final String CoiDisclosureType;

    CoiDisclosureType(String CoiDisclosureType) {
        this.CoiDisclosureType = CoiDisclosureType;
    }

    public String getCoiDisclosureType() {
        return CoiDisclosureType;
    }
}
