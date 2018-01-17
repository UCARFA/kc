/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.unit;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.unit.UnitService;
import org.kuali.kra.krms.KcKrmsConstants;
import org.kuali.rice.krms.api.engine.ExecutionEnvironment;
import org.kuali.rice.krms.framework.engine.AgendaTree;
import org.kuali.rice.krms.framework.engine.BasicAgenda;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UnitAgenda extends BasicAgenda {

    public static final String TYPE_ID = "typeId";
    private UnitService unitService;
    private Map<String, String> qualifiers;
    private boolean isActive;

    public UnitAgenda(Map<String, String> qualifiers, AgendaTree agendaTree, String agendaTypeId, boolean isActive) {
        super(qualifiers, agendaTree);
        this.isActive = isActive;
        this.qualifiers = new HashMap<>(qualifiers);
        this.qualifiers.put(TYPE_ID, agendaTypeId);
    }


    @Override
    public boolean appliesTo(ExecutionEnvironment environment) {
        if (!isActive) {
            return false;
        }
        
        String environmentId = environment.getSelectionCriteria().getAgendaQualifiers().get(TYPE_ID);
        String agendaId = this.qualifiers.get(TYPE_ID);
        if (environmentId != null && !StringUtils.equals(environmentId,agendaId)) {
        	return false;
        }
        
        Set<Map.Entry<String, String>> agendaQualifiers = environment.getSelectionCriteria().getAgendaQualifiers().entrySet();
        for (Map.Entry<String, String> agendaQualifier : agendaQualifiers) {
            String agendaQualifierValue = qualifiers.get(agendaQualifier.getKey());
            String environmentQualifierValue = agendaQualifier.getValue();
            if (KcKrmsConstants.UNIT_NUMBER.equals(agendaQualifier.getKey())) {
                return unitService.appliesToUnit(agendaQualifierValue,environmentQualifierValue);
            }
        }
        
        return false;
    }

    public UnitService getUnitService() {
        return unitService;
    }

    public void setUnitService(UnitService unitService) {
        this.unitService = unitService;
    }
}
