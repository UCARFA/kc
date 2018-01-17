/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.controller;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.controller.KcFileService;
import org.kuali.rice.coreservice.framework.parameter.ParameterConstants;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.krad.util.KRADConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("kcFileService")
public class KcFileServiceImpl implements KcFileService {

    @Autowired
    @Qualifier("parameterService")
    private ParameterService parameterService;

    @Override
    public Long getMaxUploadSizeParameter() {
        long maxUploadSize = 0;
        String maxString = getParameterService().getParameterValueAsString(KRADConstants.KNS_NAMESPACE, ParameterConstants.ALL_COMPONENT, KRADConstants.MAX_UPLOAD_SIZE_PARM_NM);

        String suffix = StringUtils.substring(maxString, maxString.length() - 1);
        Long multiplier = Long.parseLong(StringUtils.stripEnd(maxString, suffix));
        if (StringUtils.equals(suffix,"K")) {
            maxUploadSize = multiplier * 1000L;
        } else if (StringUtils.equals(suffix,"M")) {
            maxUploadSize = multiplier * 1000000L;
        } else if (StringUtils.equals(suffix,"G")) {
            maxUploadSize = multiplier * 1000000000L;
        } else {
            maxUploadSize = Long.parseLong(maxString);
        }

        return maxUploadSize;
    }

    public ParameterService getParameterService() {
        return parameterService;
    }

    public void setParameterService(ParameterService parameterService) {
        this.parameterService = parameterService;
    }
}
