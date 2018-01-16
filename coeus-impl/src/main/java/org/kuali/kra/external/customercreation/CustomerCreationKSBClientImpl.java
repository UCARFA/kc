/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.customercreation;

import org.kuali.kfs.module.external.kc.service.CustomerCreationService;
import org.kuali.rice.core.api.resourceloader.GlobalResourceLoader;

public final class CustomerCreationKSBClientImpl extends CustomerCreationClientBase {
    
    private CustomerCreationKSBClientImpl() {  }
    
    public static CustomerCreationClient getInstance() {
      if (ksbClient == null)
          ksbClient = new CustomerCreationKSBClientImpl();
      return ksbClient;
    }

    private static CustomerCreationKSBClientImpl ksbClient;

    @Override
    protected CustomerCreationService getServiceHandle() {
    	CustomerCreationService service = (CustomerCreationService) GlobalResourceLoader.getService(SERVICE_NAME);
        return service;
    }
}
