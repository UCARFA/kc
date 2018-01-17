/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.awardhierarchy.sync;

import org.kuali.rice.krad.bo.PersistableBusinessObject;

import java.io.Serializable;

/**
 * DTO bean for saving pending sync changes to build and persist after
 * a document save.
 */
public class AwardSyncPendingChangeBean implements Serializable {

    private static final long serialVersionUID = -7950844997053979351L;
    private AwardSyncType syncType;
    private PersistableBusinessObject object;
    private String attrName;
    private String awardAttr;
    
    public AwardSyncPendingChangeBean() {
        
    }
    
    public AwardSyncPendingChangeBean(AwardSyncType syncType, PersistableBusinessObject object, String awardAttr, String attrName) {
        this.syncType = syncType;
        this.object = object;
        this.attrName = attrName;
        this.awardAttr = awardAttr;
    }
    
    public AwardSyncPendingChangeBean(AwardSyncType syncType, PersistableBusinessObject object, String awardAttr) {
        this.syncType = syncType;
        this.object = object;
        this.attrName = null;
        this.awardAttr = awardAttr;
    }

    public AwardSyncType getSyncType() {
        return syncType;
    }
    public void setSyncType(AwardSyncType syncType) {
        this.syncType = syncType;
    }
    public PersistableBusinessObject getObject() {
        return object;
    }
    public void setObject(PersistableBusinessObject object) {
        this.object = object;
    }
    public String getAttrName() {
        return attrName;
    }
    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }
    public String getAwardAttr() {
        return awardAttr;
    }
    public void setAwardAttr(String awardAttr) {
        this.awardAttr = awardAttr;
    }      
}
