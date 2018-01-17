/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.dunningcampaign;

import org.kuali.rice.krad.bo.BusinessObject;

public class DunningCampaign implements BusinessObject {

	private String campaignID;
	private String campaignDescription;
	private boolean active;
	
	public String getCampaignID() {
		return campaignID;
	}
	public void setCampaignID(String campaignID) {
		this.campaignID = campaignID;
	}
	public String getCampaignDescription() {
		return campaignDescription;
	}
	public void setCampaignDescription(String campaignDescription) {
		this.campaignDescription = campaignDescription;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public void refresh() {	}
}
