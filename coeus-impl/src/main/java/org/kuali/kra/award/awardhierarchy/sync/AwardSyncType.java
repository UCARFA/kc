/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.awardhierarchy.sync;

/**
 * Enum that describes the types of sync actions that can be taken.
 */
public enum AwardSyncType {

    ADD_SYNC("A", "Add"), DELETE_SYNC("D", "Delete");
    private String syncValue;
    private String syncDesc;
    private AwardSyncType(String syncValue, String syncDesc) {
        this.syncValue = syncValue;
        this.syncDesc = syncDesc;
    }
    public String getSyncValue() {
        return syncValue;
    }
    public String getSyncDesc() {
        return syncDesc;
    }   
    
}
