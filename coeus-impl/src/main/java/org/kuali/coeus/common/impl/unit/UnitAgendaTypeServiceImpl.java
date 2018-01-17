/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.unit;

import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.coeus.common.framework.unit.UnitService;
import org.kuali.kra.krms.KcKrmsConstants;
import org.kuali.rice.core.api.data.DataType;
import org.kuali.rice.core.api.exception.RiceIllegalArgumentException;
import org.kuali.rice.core.api.uif.RemotableAbstractWidget;
import org.kuali.rice.core.api.uif.RemotableAttributeField;
import org.kuali.rice.core.api.uif.RemotableAttributeLookupSettings;
import org.kuali.rice.core.api.uif.RemotableQuickFinder;
import org.kuali.rice.core.api.uif.RemotableTextInput;
import org.kuali.rice.krad.lookup.LookupUtils;
import org.kuali.rice.krms.api.repository.agenda.AgendaDefinition;
import org.kuali.rice.krms.api.repository.type.KrmsAttributeDefinition;
import org.kuali.rice.krms.api.repository.type.KrmsTypeAttribute;
import org.kuali.rice.krms.framework.engine.Agenda;
import org.kuali.rice.krms.impl.provider.repository.LazyAgendaTree;
import org.kuali.rice.krms.impl.provider.repository.RepositoryToEngineTranslator;
import org.kuali.rice.krms.impl.type.AgendaTypeServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component("unitAgendaTypeService")
public class UnitAgendaTypeServiceImpl extends AgendaTypeServiceBase  {

    public static final String UNIT_NUMBER_CAMEL = "unitNumber";
    public static final String UNIT_NUMBER_LOWER = "unit number";
    @Autowired
    @Qualifier("repositoryToEngineTranslator")
    private RepositoryToEngineTranslator repositoryToEngineTranslator;

    @Autowired
    @Qualifier("unitService")
    private UnitService unitService;

    @Override
    public RemotableAttributeField translateTypeAttribute(KrmsTypeAttribute inputAttribute,
            KrmsAttributeDefinition attributeDefinition) {

        if (KcKrmsConstants.UNIT_NUMBER.equals(attributeDefinition.getName())) {
            return createUnitField();
        } else {
            return super.translateTypeAttribute(inputAttribute,
                attributeDefinition);
        }
    }

    private RemotableAttributeField createUnitField() {
    	
    	String unitClassName = Unit.class.getName();
    	String baseLookupUrl = LookupUtils.getBaseLookupUrl();
    
        RemotableQuickFinder.Builder quickFinderBuilder = RemotableQuickFinder.Builder.create(baseLookupUrl, unitClassName);
        quickFinderBuilder.setLookupParameters(Collections.singletonMap(KcKrmsConstants.UNIT_NUMBER, UNIT_NUMBER_CAMEL));
        quickFinderBuilder.setFieldConversions(Collections.singletonMap(UNIT_NUMBER_CAMEL, KcKrmsConstants.UNIT_NUMBER));

        RemotableTextInput.Builder controlBuilder = RemotableTextInput.Builder.create();
        controlBuilder.setSize(30);
        controlBuilder = RemotableTextInput.Builder.create();
        controlBuilder.setSize(Integer.valueOf(40));
        controlBuilder.setWatermark(UNIT_NUMBER_LOWER);
        
        RemotableAttributeLookupSettings.Builder lookupSettingsBuilder = RemotableAttributeLookupSettings.Builder.create();
        lookupSettingsBuilder.setCaseSensitive(Boolean.TRUE);
        lookupSettingsBuilder.setInCriteria(true);
        lookupSettingsBuilder.setInResults(true);
        lookupSettingsBuilder.setRanged(false);

        RemotableAttributeField.Builder builder = RemotableAttributeField.Builder.create(KcKrmsConstants.UNIT_NUMBER);
        builder.setAttributeLookupSettings(lookupSettingsBuilder);
        builder.setName(KcKrmsConstants.UNIT_NUMBER);
        builder.setRequired(true);
        builder.setDataType(DataType.STRING);
        builder.setControl(controlBuilder);
        builder.setLongLabel(KcKrmsConstants.UNIT_NUMBER);
        builder.setShortLabel(KcKrmsConstants.UNIT_NUMBER);
        builder.setMinLength(Integer.valueOf(1));
        builder.setMaxLength(Integer.valueOf(40));
        builder.setWidgets(Collections.<RemotableAbstractWidget.Builder> singletonList(quickFinderBuilder));

        return builder.build();
    }
    
    @Override
    public Agenda loadAgenda(AgendaDefinition agendaDefinition) {

        if (agendaDefinition == null) { throw new RiceIllegalArgumentException("agendaDefinition must not be null"); }
        if (repositoryToEngineTranslator == null) {
            return null;
        }
        
        UnitAgenda unitAgenda = new UnitAgenda(agendaDefinition.getAttributes(), new LazyAgendaTree(agendaDefinition, repositoryToEngineTranslator),
                                            agendaDefinition.getTypeId(),agendaDefinition.isActive());
        unitAgenda.setUnitService(getUnitService());
        return unitAgenda;
    }

    public RepositoryToEngineTranslator getRepositoryToEngineTranslator() {
        return repositoryToEngineTranslator;
    }

    public void setRepositoryToEngineTranslator(RepositoryToEngineTranslator repositoryToEngineTranslator) {
        this.repositoryToEngineTranslator = repositoryToEngineTranslator;
    }

    public UnitService getUnitService() {
        return unitService;
    }

    public void setUnitService(UnitService unitService) {
        this.unitService = unitService;
    }
}
