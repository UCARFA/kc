/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.dunningcampaign;

import java.util.List;
import java.util.Map;

import org.kuali.rice.coreservice.framework.parameter.ParameterService;

public interface DunningCampaignClient {

    public DunningCampaign getDunningCampaign(String campaignID);

	public List<DunningCampaign> getMatching(Map<String, String> searchCriteria);	
	
	public void setParameterService(ParameterService parameterService);
}
