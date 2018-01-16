/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.mq;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.lookup.KcKualiLookupableHelperServiceImpl;
import org.kuali.rice.kns.lookup.HtmlData;
import org.kuali.rice.kns.lookup.HtmlData.AnchorHtmlData;
import org.kuali.rice.krad.bo.BusinessObject;
import org.kuali.rice.krad.util.KRADConstants;
import org.kuali.rice.krad.util.UrlFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Properties;

@Component("activeMqMessageLookupableHelperService")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ActiveMqMessageLookupableHelperServiceImpl extends KcKualiLookupableHelperServiceImpl {

    @Override
    public List<HtmlData> getCustomActionUrls(BusinessObject businessObject, List pkNames) {
        final List<HtmlData> htmlDataList = super.getCustomActionUrls(businessObject, pkNames);
        final AnchorHtmlData resendLink = new AnchorHtmlData();
        resendLink.setDisplayText("Resend Message");
        resendLink.setHref(getCustomActionUrlHref(businessObject, "resend", pkNames));
        htmlDataList.add(resendLink);
        return htmlDataList;
    }

    protected String getCustomActionUrlHref(BusinessObject businessObject, String methodToCall, List pkNames) {
        Properties parameters = new Properties();
        parameters.put(KRADConstants.DISPATCH_REQUEST_PARAMETER, methodToCall);
        parameters.put(KRADConstants.BUSINESS_OBJECT_CLASS_ATTRIBUTE, businessObject.getClass().getName());
        parameters.putAll(getParametersFromPrimaryKey(businessObject, pkNames));
        if (StringUtils.isNotBlank(getReturnLocation())) {
            parameters.put(KRADConstants.RETURN_LOCATION_PARAMETER, getReturnLocation());
        }
        return UrlFactory.parameterizeUrl("../activeMqMessageMaintenance.do", parameters);
    }
}
