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
import org.kuali.rice.krad.service.DataDictionaryService;
import org.kuali.rice.krad.uif.field.InputFieldBase;

import org.kuali.rice.krad.uif.util.LifecycleElement;


public abstract class AbstractDataOverrideInputField extends InputFieldBase {
    private boolean inCollection;
    private DataDictionaryService dataDictionaryService;

    public abstract String getEntryName();

    @Override
    public void performApplyModel(Object model, LifecycleElement parent) {
        if (inCollection) {
            this.copyFromAttributeDefinition(getDataDictionaryService().getAttributeDefinition(getEntryName(),this.getDictionaryAttributeName()));
        }

        super.performApplyModel(model, parent);
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
