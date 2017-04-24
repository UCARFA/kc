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
package org.kuali.coeus.common.impl.custom.arg;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.coeus.common.framework.custom.arg.ArgValueLookup;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArgValueLookupValuesFinder extends UifKeyValuesFinderBase {

	private enum ArgValueConfig { VALUE, DESCRIPTION, BOTH}
	private static final ConcreteKeyValue SELECT = new ConcreteKeyValue("", "select");
	private static final String ARGUMENT_NAME = "argumentName";
	private static final String ARG_VALUE_VALUES_FINDER_DEFAULT_CONFIG = "ARG_VALUE_VALUES_FINDER_DEFAULT_CONFIG";
	private static final String ARG_VALUE_VALUES_FINDER_ARG_CONFIG ="ARG_VALUE_VALUES_FINDER_ARG_CONFIG";

	private transient ParameterService parameterService;
	private transient BusinessObjectService businessObjectService;
    private String argName;

    @Override
    public List<KeyValue> getKeyValues() {
        final Collection<ArgValueLookup> argValueLookups = getBusinessObjectService().findMatching(ArgValueLookup.class, Collections.singletonMap(ARGUMENT_NAME, argName));

		final String defaultConfig = getParameterService().getParameterValueAsString(Constants.KC_GENERIC_PARAMETER_NAMESPACE,
				Constants.KC_ALL_PARAMETER_DETAIL_TYPE_CODE, ARG_VALUE_VALUES_FINDER_DEFAULT_CONFIG);
		final String argConfig = getParameterService().getSubParameterValueAsString(Constants.KC_GENERIC_PARAMETER_NAMESPACE,
				Constants.KC_ALL_PARAMETER_DETAIL_TYPE_CODE, ARG_VALUE_VALUES_FINDER_ARG_CONFIG, argName);
		final String cfg = StringUtils.isNotBlank(argConfig) ? argConfig : defaultConfig;

		return Stream.concat(Stream.of(SELECT), argValueLookups.stream()
				.map(argValueLookup -> new ConcreteKeyValue(argValueLookup.getValue(), getKeyValueValue(argValueLookup, cfg)))
				.sorted(Comparator.comparing(ConcreteKeyValue::getValue)))
				.collect(Collectors.toList());
    }

	protected String getKeyValueValue(ArgValueLookup argValueLookup, String cfg) {
		if (ArgValueConfig.VALUE.toString().equals(cfg)) {
			return argValueLookup.getValue();
		} else if (ArgValueConfig.DESCRIPTION.toString().equals(cfg))  {
			return argValueLookup.getDescription();
		} else if (ArgValueConfig.BOTH.toString().equals(cfg)) {
			return argValueLookup.getValue() + (StringUtils.isNotBlank(argValueLookup.getDescription()) ? ( " - " + argValueLookup.getDescription()) : "");
		} else {
			return  argValueLookup.getValue();
		}
	}

    public String getArgName() {
        return argName;
    }

    public void setArgName(String argName) {
        this.argName = argName;
    }

	public ParameterService getParameterService() {
		if (parameterService == null) {
			parameterService = KcServiceLocator.getService(ParameterService.class);
		}
		return parameterService;
	}

	public void setParameterService(ParameterService parameterService) {
		this.parameterService = parameterService;
	}

	public BusinessObjectService getBusinessObjectService() {
		if (businessObjectService == null) {
			businessObjectService = KcServiceLocator.getService(BusinessObjectService.class);
		}
    	return businessObjectService;
	}

	public void setBusinessObjectService(BusinessObjectService businessObjectService) {
		this.businessObjectService = businessObjectService;
	}
}
