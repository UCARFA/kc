/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.unit.sync;

import org.kuali.coeus.sys.api.model.Identifiable;
import org.kuali.coeus.sys.api.model.Inactivatable;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.core.api.mo.common.active.MutableInactivatable;

import java.util.ArrayList;
import java.util.List;

public class UnitRoleSync extends KcPersistableBusinessObjectBase implements Identifiable, org.kuali.rice.core.api.mo.common.Identifiable, Inactivatable, MutableInactivatable {

    private String id;
    private String syncBehaviorCode;
    private boolean active;

    private List<SourceUnitInfo> sourceUnitInfos = new ArrayList<>();
    private List<TargetRoleInfo> targetRoleInfos = new ArrayList<>();

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    public String getSyncBehaviorCode() {
        return syncBehaviorCode;
    }

    public void setSyncBehaviorCode(String syncBehaviorCode) {
        this.syncBehaviorCode = syncBehaviorCode;
    }

    public List<SourceUnitInfo> getSourceUnitInfos() {
        return sourceUnitInfos;
    }

    public void setSourceUnitInfos(List<SourceUnitInfo> sourceUnitInfos) {
        this.sourceUnitInfos = sourceUnitInfos;
    }

    public List<TargetRoleInfo> getTargetRoleInfos() {
        return targetRoleInfos;
    }

    public void setTargetRoleInfos(List<TargetRoleInfo> targetRoleInfos) {
        this.targetRoleInfos = targetRoleInfos;
    }

    public SyncBehavior getSyncBehavior() {
        return SyncBehavior.fromCode(getSyncBehaviorCode());
    }
}
