/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.awardhierarchy.sync;

/**
 * Enum for the possible values for descendant sync selection.
 */
public enum AwardSyncDescendantValues {

    SYNC_ALL("ALL"), SYNC_ACTIVE("ACTIVE");
    private String syncValue;
    private AwardSyncDescendantValues(String syncValue) {
        this.syncValue = syncValue;
    }
    public String getSyncValue() {
        return syncValue;
    }   
}
