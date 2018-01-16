/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.dunningcampaign;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.kfs.module.external.kc.service.DunningCampaignService;
import org.kuali.kfs.module.external.kc.service.DunningCampaignServiceSOAP;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.core.api.config.property.ConfigContext;

import javax.xml.ws.WebServiceClient;
import java.net.MalformedURLException;
import java.net.URL;



/**
 * This class is the implementation of the client that
 * connects to the financial web service that creates 
 * an account.
 */

public final class DunningCampaignClientImpl extends DunningCampaignClientBase {
    
    public final static URL WSDL_LOCATION;
    
    private static DunningCampaignClientImpl client;
    
    private static final Log LOG = LogFactory.getLog(DunningCampaignClientImpl.class);
    
    private DunningCampaignClientImpl() {
    }

    public static DunningCampaignClientImpl getInstance() {
        if (client == null) {
            client = new DunningCampaignClientImpl();
        }
        return client;
    }
      
    static
    {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        if (null == cl) {
            cl = DunningCampaignClientImpl.class.getClassLoader();
        }
        String wsdlPath =  ((WebServiceClient) (DunningCampaignServiceSOAP.class.getAnnotation(WebServiceClient.class))).wsdlLocation();
        WSDL_LOCATION = cl.getResource(wsdlPath); 
    }
    
    @Override
    protected DunningCampaignService getServiceHandle() {
        URL wsdlURL = null;
        
        boolean getFinSystemURLFromWSDL = getParameterService().getParameterValueAsBoolean("KC-AWARD", "Document", Constants.GET_FIN_SYSTEM_URL_FROM_WSDL);
        
        if (getFinSystemURLFromWSDL) {
            wsdlURL = WSDL_LOCATION;
        } else {
            String serviceEndPointUrl = ConfigContext.getCurrentContextConfig().getProperty(Constants.FIN_SYSTEM_INTEGRATION_SERVICE_URL);
            try {
                wsdlURL = new URL(serviceEndPointUrl + SOAP_SERVICE_NAME + "?wsdl");
            } catch (MalformedURLException mue) {
                LOG.error("Could not construct financial system URL from config file: " + mue.getMessage());
            }
        }
        
        DunningCampaignServiceSOAP ss = new DunningCampaignServiceSOAP(wsdlURL, SERVICE_NAME);
        return ss.getDunningCampaignServicePort();
    }

}
