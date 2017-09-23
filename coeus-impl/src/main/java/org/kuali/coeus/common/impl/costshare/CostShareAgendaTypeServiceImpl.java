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
package org.kuali.coeus.common.impl.costshare;


import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.unit.UnitService;
import org.kuali.coeus.common.impl.unit.UnitAgendaTypeServiceImpl;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.krms.KcKrmsConstants;
import org.kuali.rice.core.api.exception.RiceIllegalArgumentException;
import org.kuali.rice.krms.api.engine.ExecutionEnvironment;
import org.kuali.rice.krms.api.repository.agenda.AgendaDefinition;
import org.kuali.rice.krms.framework.engine.Agenda;
import org.kuali.rice.krms.framework.engine.AgendaTree;
import org.kuali.rice.krms.framework.engine.BasicAgenda;
import org.kuali.rice.krms.impl.provider.repository.LazyAgendaTree;
import org.kuali.rice.krms.impl.provider.repository.RepositoryToEngineTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component("costShareAgendaTypeService")
public class CostShareAgendaTypeServiceImpl extends UnitAgendaTypeServiceImpl {

	public static final String TYPE_ID = "typeId";
	
    @Autowired
    @Qualifier("repositoryToEngineTranslator")
    private RepositoryToEngineTranslator repositoryToEngineTranslator;

    @Autowired
    @Qualifier("unitService")
    private UnitService unitService;

    @Override
    public Agenda loadAgenda(AgendaDefinition agendaDefinition) {

        if (agendaDefinition == null) { throw new RiceIllegalArgumentException("agendaDefinition must not be null"); }
        if (repositoryToEngineTranslator == null) {
            return null;
        }

        return new CostShareAgenda(agendaDefinition.getAttributes(), new LazyAgendaTree(agendaDefinition, repositoryToEngineTranslator),
                agendaDefinition.getTypeId(),agendaDefinition.isActive());
    }

    private class CostShareAgenda extends BasicAgenda {

        private Map<String, String> qualifiers;
        private boolean isActive;

        public CostShareAgenda(Map<String, String> qualifiers, AgendaTree agendaTree, String agendaTypeId,boolean isActive) {
            super(qualifiers, agendaTree);
            this.isActive = isActive;
            String unitNumber = qualifiers.get(KcKrmsConstants.UNIT_NUMBER);
            this.qualifiers = new HashMap<>(qualifiers);
            this.qualifiers.put(Constants.COST_SHARE_AGENDA_UNITS, unitNumber);
        }

        @Override
        public boolean appliesTo(ExecutionEnvironment environment) {
            if (!isActive){
                return false;
            }
            
            String environmentId = environment.getSelectionCriteria().getAgendaQualifiers().get(TYPE_ID);
            String agendaId = this.qualifiers.get(TYPE_ID);
            if (environmentId != null && !StringUtils.equals(environmentId,agendaId)) {
            	return false;
            }
            
            return environment.getSelectionCriteria().getAgendaQualifiers().containsKey(Constants.COST_SHARE_AGENDA_UNITS) &&
                    appliesToUnit(environment.getSelectionCriteria().getAgendaQualifiers().entrySet());

        }

        protected boolean appliesToUnit(Set<Map.Entry<String, String>> agendaQualifiers) {
            for (Map.Entry<String, String> agendaQualifier : agendaQualifiers) {
                String agendaQualifierValue = qualifiers.get(agendaQualifier.getKey());
                String environmentQualifierValue = agendaQualifier.getValue();
                if (Constants.COST_SHARE_AGENDA_UNITS.equals(agendaQualifier.getKey())) {
                    return unitService.appliesToUnit(agendaQualifierValue,environmentQualifierValue);
                }
            }
            return false;
        }
    }

}
