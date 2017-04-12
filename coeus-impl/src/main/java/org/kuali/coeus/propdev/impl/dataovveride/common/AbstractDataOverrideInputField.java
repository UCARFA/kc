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
package org.kuali.coeus.propdev.impl.dataovveride.common;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.core.api.data.DataType;
import org.kuali.rice.krad.datadictionary.AttributeDefinition;
import org.kuali.rice.krad.service.DataDictionaryService;
import org.kuali.rice.krad.uif.field.InputFieldBase;

import org.kuali.rice.krad.uif.util.LifecycleElement;
import org.kuali.rice.krad.uif.util.ObjectPropertyUtils;


public abstract class AbstractDataOverrideInputField extends InputFieldBase {
    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final String ON = "on";

    private boolean inCollection;
    private DataDictionaryService dataDictionaryService;

    public abstract String getEntryName();

    @Override
    public void performApplyModel(Object model, LifecycleElement parent) {
        if (inCollection) {
            final AttributeDefinition attributeDefinition = getDataDictionaryService().getAttributeDefinition(getEntryName(), this.getDictionaryAttributeName());
            if (attributeDefinition.getDataType() == DataType.BOOLEAN) {
                final Object value = ObjectPropertyUtils.getPropertyValue(model, getBindingInfo().getBindingPath());
                setReadOnlyDisplayReplacement(ON.equals(value) || YES.equals(value) ? YES : NO);
            }
            this.copyFromAttributeDefinition(attributeDefinition);
        }

        super.performApplyModel(model, parent);
    }

    @Override
    public String getReadOnlyDisplayReplacement() {
        return super.getReadOnlyDisplayReplacement();
    }

    public boolean isInCollection() {
        return inCollection;
    }

    public void setInCollection(boolean inCollection) {
        this.inCollection = inCollection;
    }

    public DataDictionaryService getDataDictionaryService() {
        if (dataDictionaryService == null) {
            dataDictionaryService = KcServiceLocator.getService(DataDictionaryService.class);
        }
        return dataDictionaryService;
    }

    public void setDataDictionaryService(DataDictionaryService dataDictionaryService) {
        this.dataDictionaryService = dataDictionaryService;
    }
}
