/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.controller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class ParameterAwareCommonsMultipartResolver extends CommonsMultipartResolver implements InitializingBean {

    private KcFileService kcFileService;

    public KcFileService getKcFileService() {
        return kcFileService;
    }

    public void setKcFileService(KcFileService kcFileService) {
        this.kcFileService = kcFileService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
       this.setMaxUploadSize(getKcFileService().getMaxUploadSizeParameter());
   }
}


