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

import org.kuali.rice.kns.lookup.AbstractLookupableHelperServiceImpl;
import org.kuali.rice.krad.bo.BusinessObject;

public class DunningCampaignLookupable extends AbstractLookupableHelperServiceImpl {

	private static final long serialVersionUID = 5276003184255639709L;
	
	private DunningCampaignClient dunningCampaignClient;

	@Override
	public List<? extends BusinessObject> getSearchResults(
			Map<String, String> fieldValues) {
		return getDunningCampaignClient().getMatching(fieldValues);
	}

	public DunningCampaignClient getDunningCampaignClient() {
		return dunningCampaignClient;
	}

	public void setDunningCampaignClient(DunningCampaignClient dunningCampaignClient) {
		this.dunningCampaignClient = dunningCampaignClient;
	}

}
