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

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.sys.api.model.Identifiable;

public class SourceUnitInfo extends KcPersistableBusinessObjectBase implements Identifiable, org.kuali.rice.core.api.mo.common.Identifiable {

    private String id;
    private String unitRoleSyncId;
    private String sourceUnitCode;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnitRoleSyncId() {
        return unitRoleSyncId;
    }

    public void setUnitRoleSyncId(String unitRoleSyncId) {
        this.unitRoleSyncId = unitRoleSyncId;
    }

    public String getSourceUnitCode() {
        return sourceUnitCode;
    }

    public void setSourceUnitCode(String sourceUnitCode) {
        this.sourceUnitCode = sourceUnitCode;
    }
}
