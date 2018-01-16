/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.unit.sync;

import org.kuali.coeus.common.framework.unit.sync.UnitRoleSyncService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class UnitRoleSyncJobImpl extends QuartzJobBean implements Job {

    private UnitRoleSyncService unitRoleSyncService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        unitRoleSyncService.syncPersonUnitInfoToRoles();
    }

    public UnitRoleSyncService getUnitRoleSyncService() {
        return unitRoleSyncService;
    }

    public void setUnitRoleSyncService(UnitRoleSyncService unitRoleSyncService) {
        this.unitRoleSyncService = unitRoleSyncService;
    }
}
