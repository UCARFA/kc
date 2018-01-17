/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.dunningcampaign;

import org.kuali.kfs.module.external.kc.service.DunningCampaignService;
import org.kuali.rice.core.api.resourceloader.GlobalResourceLoader;

public final class DunningCampaignKSBClientImpl extends DunningCampaignClientBase {
    
    private DunningCampaignKSBClientImpl() {  }
    
    public static DunningCampaignClient getInstance() {
      if (ksbClient == null)
          ksbClient = new DunningCampaignKSBClientImpl();
      return ksbClient;
    }

    private static DunningCampaignKSBClientImpl ksbClient;

    @Override
    protected DunningCampaignService getServiceHandle() {
        DunningCampaignService dunningCampaignService = (DunningCampaignService) GlobalResourceLoader.getService(SERVICE_NAME);
        return dunningCampaignService;
    }
}
