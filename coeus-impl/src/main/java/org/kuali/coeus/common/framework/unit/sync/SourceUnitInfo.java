/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
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
