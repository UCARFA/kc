/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2016 Kuali, Inc.
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
