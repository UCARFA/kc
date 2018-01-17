/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.validation;

import static org.kuali.coeus.sys.framework.util.CollectionUtils.entriesToMap;
import static org.kuali.coeus.sys.framework.util.CollectionUtils.entry;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.kuali.coeus.sys.framework.validation.ErrorHandlingUtilService;
import org.kuali.rice.core.api.config.property.ConfigurationService;
import org.kuali.rice.krad.util.ErrorMessage;
import org.kuali.rice.krad.util.MessageMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("errorHandlingUtilService")
public class ErrorHandlingUtilServiceImpl implements ErrorHandlingUtilService {
	
	@Autowired
	@Qualifier("globalVariableService")
	private GlobalVariableService globalVariableService;

	@Autowired
	@Qualifier("kualiConfigurationService")
	private ConfigurationService configurationService;
	
	@Override
	public Map<String, List<String>> extractErrorMessages(MessageMap messageMap) {
		return resolveErrorMessages(messageMap.getErrorMessages());
	}

	@Override
	public Map<String, List<String>> resolveErrorMessages(Map<String, List<ErrorMessage>> errorMap) {
		return errorMap.entrySet().stream()
				.map(entry -> entry(entry.getKey().replaceFirst("^\\.", ""), entry.getValue().stream()
		                .map(this::resolveErrorMessage)
		                .collect(Collectors.toList()))).collect(entriesToMap());
	}

	@Override
	public String resolveErrorMessage(ErrorMessage errorMessage) {
		return resolveErrorKey(errorMessage.getErrorKey(), errorMessage.getMessageParameters());
	}
	
	@Override
    public String resolveErrorKey(String errorKey, String...params) {
        String messageText = configurationService.getPropertyValueAsString(errorKey);
        for (int i = 0; i < params.length; i++) {
            messageText = StringUtils.replace(messageText, "{" + i + "}", params[i]);
        }
        return messageText;  
	}

	public GlobalVariableService getGlobalVariableService() {
		return globalVariableService;
	}

	public void setGlobalVariableService(GlobalVariableService globalVariableService) {
		this.globalVariableService = globalVariableService;
	}

	public ConfigurationService getConfigurationService() {
		return configurationService;
	}

	public void setConfigurationService(ConfigurationService configurationService) {
		this.configurationService = configurationService;
	}

}
