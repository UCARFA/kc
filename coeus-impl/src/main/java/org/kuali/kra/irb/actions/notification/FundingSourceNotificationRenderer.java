/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.notification;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.notification.IRBNotificationRenderer;

import java.util.Map;

/**
 * Renders additional fields for the Funding Source notification.
 */
public class FundingSourceNotificationRenderer extends IRBNotificationRenderer {

    private static final long serialVersionUID = 7708247234043655433L;
    
    private String fundingType;
    private String action;

    /**
     * Constructs a Funding Source notification renderer.
     * 
     * @param protocol
     * @param fundingType
     * @param action
     */
    public FundingSourceNotificationRenderer(Protocol protocol, String fundingType, String action) {
        super(protocol);
        
        this.fundingType = fundingType;
        this.action = action;
    }
    
    public String getFundingType() {
        return fundingType;
    }

    public void setFundingType(String fundingType) {
        this.fundingType = fundingType;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    
    @Override
    public Map<String, String> getDefaultReplacementParameters() {
        Map<String, String> params = super.getDefaultReplacementParameters();
        params.put("{FUNDING_TYPE}", fundingType);
        params.put("{ACTION}", action);
        return params;
    }

}
