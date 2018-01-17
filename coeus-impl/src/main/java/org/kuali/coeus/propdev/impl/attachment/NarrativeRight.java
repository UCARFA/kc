/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.attachment;

public enum NarrativeRight {
    MODIFY_NARRATIVE_RIGHT("M"),
    VIEW_NARRATIVE_RIGHT("R"),
    NO_NARRATIVE_RIGHT("N");
    private final String accessType;
    NarrativeRight(String accessType){
        this.accessType = accessType;
    }
    public String getAccessType() {
        return accessType;
    }
}
