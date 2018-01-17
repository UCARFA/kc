/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.lookup;

import org.apache.commons.lang3.StringUtils;
import org.kuali.rice.kew.api.KewApiConstants;
import org.kuali.rice.kns.lookup.HtmlData;
import org.kuali.rice.kns.lookup.HtmlData.AnchorHtmlData;
import org.kuali.rice.kns.lookup.KualiLookupableHelperServiceImpl;
import org.kuali.rice.kns.web.struts.form.LookupForm;
import org.kuali.rice.kns.web.ui.Field;
import org.kuali.rice.krad.bo.BusinessObject;
import org.kuali.rice.krad.util.KRADConstants;
import org.kuali.rice.krad.util.ObjectUtils;
import org.kuali.rice.krad.util.UrlFactory;

import java.util.*;
import java.util.Map.Entry;

public abstract class KraLookupableHelperServiceImpl extends KualiLookupableHelperServiceImpl {

    private static final String COLUMN = ":";
    private static final String VIEW = "view";
    protected static final String MEDUSA = "medusa";
    /**
     * create 'edit' link
     */
    @Override
    public List<HtmlData> getCustomActionUrls(BusinessObject businessObject, List pkNames) {
        List<HtmlData> htmlDataList = new ArrayList<>();
        addEditHtmlData(htmlDataList, businessObject);
        return htmlDataList;

}
    protected void addEditHtmlData(List<HtmlData> htmlDataList, BusinessObject businessObject) {
        htmlDataList.add(getEditLink(businessObject));
    }

    protected AnchorHtmlData getEditLink(BusinessObject businessObject) {
        Properties parameters = new Properties();
        parameters.put(KRADConstants.DISPATCH_REQUEST_PARAMETER, KRADConstants.DOC_HANDLER_METHOD);
        parameters.put(KRADConstants.PARAMETER_COMMAND, KewApiConstants.INITIATE_COMMAND);
        parameters.put(KRADConstants.DOCUMENT_TYPE_NAME, getDocumentTypeName());
        parameters.put(getKeyFieldName(), ObjectUtils.getPropertyValue(businessObject, getKeyFieldName()).toString());
        String href = UrlFactory.parameterizeUrl("../"+getHtmlAction(), parameters);

        return new AnchorHtmlData(href,
                KRADConstants.DOC_HANDLER_METHOD, KRADConstants.MAINTENANCE_EDIT_METHOD_TO_CALL);
    }

    protected AnchorHtmlData getViewLink(String documentNumber) {
        AnchorHtmlData htmlData = new AnchorHtmlData();
        htmlData.setDisplayText(VIEW);
        final Properties parameters = new Properties();
        parameters.put(KRADConstants.DISPATCH_REQUEST_PARAMETER, KRADConstants.DOC_HANDLER_METHOD);
        parameters.put(KRADConstants.PARAMETER_COMMAND, KewApiConstants.DOCSEARCH_COMMAND);
        parameters.put(KRADConstants.DOCUMENT_TYPE_NAME, getDocumentTypeName());
        parameters.put("viewDocument", "true");
        parameters.put("docId", documentNumber);
        String href  = UrlFactory.parameterizeUrl("../"+getHtmlAction(), parameters);
        
        htmlData.setHref(href);
        return htmlData;

    }

    protected AnchorHtmlData getMedusaLink(String documentNumber, Boolean readOnly) {
        AnchorHtmlData htmlData = new AnchorHtmlData();
        htmlData.setDisplayText(MEDUSA);
        Properties parameters = new Properties();
        parameters.put(KRADConstants.DISPATCH_REQUEST_PARAMETER, "medusa");
        parameters.put(KRADConstants.PARAMETER_COMMAND, KewApiConstants.DOCSEARCH_COMMAND);
        parameters.put(KRADConstants.DOCUMENT_TYPE_NAME, getDocumentTypeName());
        parameters.put("viewDocument", readOnly.toString());
        parameters.put("docId", documentNumber);
        String href  = UrlFactory.parameterizeUrl("../"+getHtmlAction(), parameters);

        htmlData.setHref(href);
        return htmlData;
    }

    /**
     * To force to it to show action links, such as 'edit' if it is not 'lookup' to search of return value.
     */
    @Override
    public Collection performLookup(LookupForm lookupForm, Collection resultTable, boolean bounded) {
        if (!lookupForm.isHideReturnLink()) {
            lookupForm.setSuppressActions(true);
        } else {
            lookupForm.setShowMaintenanceLinks(true);
        }
        return super.performLookup(lookupForm, resultTable, bounded);
    }
    
    /**
     * 
     * This method to set both fields if child class override getSearchResults
     */
    protected void setBackLocationDocFormKey(Map<String, String> fieldValues) {

        //need to set backlocation & docformkey here.  Otherwise, they are empty
        for (Entry<String,String> entry : fieldValues.entrySet()) {
            if (entry.getKey().equals(KRADConstants.BACK_LOCATION)) {
                setBackLocation(entry.getValue());
            } else if (entry.getKey().equals(KRADConstants.DOC_FORM_KEY)) {
                setDocFormKey(entry.getValue());
            }
        }
    }
 
    /**
     * 
     * This method is to set up field definitions for lookup fields.  
     * These fields does not have a reference object defined for it in repository &amp; bo.
     */
    protected void updateLookupField(Field field, String keyName, String className) {
        if (StringUtils.isNotBlank(keyName) && StringUtils.isNotBlank(className)) {
            field.setFieldConversions(keyName+COLUMN+field.getPropertyName());
            field.setLookupParameters(field.getPropertyName()+COLUMN+keyName);
            field.setInquiryParameters(field.getPropertyName()+COLUMN+keyName);
            field.setQuickFinderClassNameImpl(className);
        } 
        
    }

    /**
     * htmlaction for 'edit' link
     */
    protected abstract String getHtmlAction();
    
    /**
     * 
     * This method to set document type of the lookup bo's document
     */
    protected abstract String getDocumentTypeName();
    
    /**
     * 
     * This method is set the key field to retrieve bo for editing.  May change to  a map if there are multiple fields.
     */
    protected abstract String getKeyFieldName();

}
