/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.award.impl;


import org.kuali.kfs.module.external.kc.service.AccountCreationService;
import org.kuali.kra.external.award.AccountCreationClient;
import org.kuali.rice.core.api.resourceloader.GlobalResourceLoader;



/**
 * This class is the implementation of the client that
 * connects to the financial web service that creates 
 * an account.
 */

public final class AccountCreationKSBClientImpl extends AccountCreationClientBase {
    
    private AccountCreationKSBClientImpl() {  }
    
    public static AccountCreationClient getInstance() {
      if (ksbClient == null)
          ksbClient = new AccountCreationKSBClientImpl();
      return ksbClient;
    }

    private static AccountCreationKSBClientImpl ksbClient;


    @Override
    protected AccountCreationService getServiceHandle() {
        AccountCreationService accountCreationService = (AccountCreationService) GlobalResourceLoader.getService(SERVICE_NAME);
        return accountCreationService;
    }
}
