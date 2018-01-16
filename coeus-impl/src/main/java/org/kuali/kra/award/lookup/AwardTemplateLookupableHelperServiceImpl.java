/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.lookup;

import org.kuali.kra.award.home.AwardTemplate;
import org.kuali.rice.kns.lookup.HtmlData;
import org.kuali.rice.kns.lookup.HtmlData.AnchorHtmlData;
import org.kuali.rice.kns.lookup.KualiLookupableHelperServiceImpl;
import org.kuali.rice.krad.bo.BusinessObject;
import org.kuali.rice.krad.util.KRADConstants;
import org.kuali.rice.krad.util.UrlFactory;

import java.util.List;
import java.util.Properties;

public class AwardTemplateLookupableHelperServiceImpl extends KualiLookupableHelperServiceImpl {


    private static final long serialVersionUID = 7169266970079382877L;

  protected String getDocumentTypeName() {
      return AwardTemplate.class.getName();
  }
  protected String getHtmlAction() {
      return "maintenanceSponsorTemplate.do";
  }
  protected String getKeyFieldName() {
      return "templateCode";
  }

  protected AnchorHtmlData getPrintLink(AwardTemplate document) {
      AnchorHtmlData htmlData = new AnchorHtmlData();
      htmlData.setDisplayText("print");
      Properties parameters = new Properties();
      parameters.put(KRADConstants.DISPATCH_REQUEST_PARAMETER, "print");
      parameters.put(KRADConstants.BUSINESS_OBJECT_CLASS_ATTRIBUTE, getDocumentTypeName());
      parameters.put(KRADConstants.RETURN_LOCATION_PARAMETER, getReturnLocation());
      parameters.put(getKeyFieldName(), document.getTemplateCode().toString());
      String href  = UrlFactory.parameterizeUrl("../"+getHtmlAction(), parameters);
      
      htmlData.setHref(href);
      return htmlData;

  }
  

  @Override
  public List<HtmlData> getCustomActionUrls(BusinessObject businessObject, List pkNames) {
      List<HtmlData> htmlDataList = super.getCustomActionUrls(businessObject, pkNames);
      AnchorHtmlData htmlData = getPrintLink((AwardTemplate) businessObject);
      htmlDataList.add(htmlData);
      return htmlDataList;
  }

}
