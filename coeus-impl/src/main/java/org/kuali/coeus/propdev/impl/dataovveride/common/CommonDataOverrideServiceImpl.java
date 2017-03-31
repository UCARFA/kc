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

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.core.api.data.DataType;
import org.kuali.rice.core.api.datetime.DateTimeService;
import org.kuali.rice.core.api.exception.RiceRuntimeException;
import org.kuali.rice.krad.data.DataObjectService;
import org.kuali.rice.krad.data.metadata.DataObjectRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Date;

@Component("commonDataOverrideService")
public class CommonDataOverrideServiceImpl implements CommonDataOverrideService {

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(CommonDataOverrideServiceImpl.class);

    @Autowired
    @Qualifier("dataObjectService")
    private DataObjectService dataObjectService;

    @Autowired
    @Qualifier("dateTimeService")
    private DateTimeService dateTimeService;

    @Override
    public void setChangedValue(KcPersistableBusinessObjectBase bo, String propertyName, String propertyValue) {
        DataType dataType = DataType.getDataTypeFromClass(dataObjectService.wrap(bo).getPropertyType(propertyName));

        try {
            if (dataType.isTemporal()) {
                PropertyUtils.setNestedProperty(bo, propertyName, getDateTimeService().convertToSqlDate(propertyValue));
            } else if (dataType.equals(DataType.INTEGER)) {
                PropertyUtils.setNestedProperty(bo, propertyName, Integer.valueOf(propertyValue));
            } else if (dataType.equals(DataType.LONG)) {
                PropertyUtils.setNestedProperty(bo, propertyName, Long.valueOf(propertyValue));
            } else if (dataType.equals(DataType.FLOAT)) {
                PropertyUtils.setNestedProperty(bo, propertyName, Float.valueOf(propertyValue));
            } else if (dataType.equals(DataType.DOUBLE)) {
                PropertyUtils.setNestedProperty(bo, propertyName, Double.valueOf(propertyValue));
            } else if (dataType.equals(DataType.LARGE_INTEGER)) {
                PropertyUtils.setNestedProperty(bo, propertyName, BigInteger.valueOf(Long.valueOf(propertyValue)));
            } else if (dataType.equals(DataType.PRECISE_DECIMAL)) {
                PropertyUtils.setNestedProperty(bo, propertyName, BigDecimal.valueOf(Long.valueOf(propertyValue)));
            } else if (dataType.equals(DataType.STRING)) {
                PropertyUtils.setNestedProperty(bo, propertyName, propertyValue);
            } else if (dataType.equals(DataType.BOOLEAN)) {
                PropertyUtils.setNestedProperty(bo, propertyName, "on".equals(propertyValue));
            } else {
                throw new RuntimeException("Data override does not work for this class");
            }
        } catch (ParseException|IllegalAccessException|InvocationTargetException|NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getChangedValue(KcPersistableBusinessObjectBase bo, String propertyName) {
        Object propertyObject = getPropertyValue(bo, propertyName);

        DataType dataType = DataType.getDataTypeFromClass(dataObjectService.wrap(bo).getPropertyType(propertyName));
        String propertyValue = null;
        if (propertyObject != null) {
            if (dataType.isTemporal()) {
                propertyValue = getDateTimeService().toDateString((Date)propertyObject);
            } else if (dataType.equals(DataType.STRING)){
                propertyValue = (String) propertyObject;
            } else if (dataType.equals(DataType.BOOLEAN)) {
                propertyValue = "true".equals(propertyObject.toString()) ? "on" : "off";
            } else {
                propertyValue = propertyObject.toString();
            }
        }
        return propertyValue;
    }

    @Override
    public <T extends KcPersistableBusinessObjectBase> String getDisplayReferenceValue(T bo, String propertyName, Class<T> clazz) {
        String refName = "";

        DataObjectRelationship relationship = getDataObjectService().getMetadataRepository().getMetadata(clazz).getRelationshipByLastAttributeInRelationship(propertyName);
        if (relationship != null) {
            refName = relationship.getName();
        }

        if (StringUtils.isNotEmpty(refName)){
            getDataObjectService().wrap(bo).fetchRelationship(refName);
            try {
                Object refObject = PropertyUtils.getNestedProperty(bo,refName);
                return (String) PropertyUtils.getNestedProperty(refObject,"description");
            } catch (Exception e) {
                LOG.warn("no description field found on ref object",e);
            }
        }
        return null;
    }

    protected Object getPropertyValue(KcPersistableBusinessObjectBase bo, String propertyName) {
        try{
            return PropertyUtils.getNestedProperty(bo,propertyName);
        } catch (Exception e) {
            throw new RiceRuntimeException("propertyName [" + propertyName + "] can not be found on bo");
        }
    }

    public DataObjectService getDataObjectService() {
        return dataObjectService;
    }

    public void setDataObjectService(DataObjectService dataObjectService) {
        this.dataObjectService = dataObjectService;
    }

    public DateTimeService getDateTimeService() {
        return dateTimeService;
    }

    public void setDateTimeService(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }
}
