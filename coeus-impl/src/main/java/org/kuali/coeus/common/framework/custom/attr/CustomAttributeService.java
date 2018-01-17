/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.custom.attr;

import org.kuali.coeus.common.framework.custom.DocumentCustomData;

import java.util.List;
import java.util.Map;

public interface CustomAttributeService {

    /**
     * This method returns a Map of Custom Attribute Documents where the key is the
     * customAttributeId.
     *
     * @param documentTypeCode document type to get custom attributes for
     * @param documentNumber document number for this document
     * @return a List of custom attribute documents for this document
     */
    public Map<String, CustomAttributeDocument> getDefaultCustomAttributeDocuments(String documentTypeCode, List<? extends DocumentCustomData> customDataList);
    
    /**
     * 
     * This method is to set up the the custom attribute in attribute content
     * @param document
     * @param attributeName
     * @param networkId
     * @throws Exception
     */
    public void setCustomAttributeKeyValue(String documentNumber, Map<String, CustomAttributeDocument> customAttributeDocuments, String attributeName, String networkId);

    /**
     * 
     * This method is to get the custom attribute data type based on data type code
     * @param dataTypeCode
     * @return
     */
    public CustomAttributeDataType getCustomAttributeDataType(String dataTypeCode);

    /**
     * 
     * This method is to get the lookupfields of the lookupclass.
     * @param lookupClass
     * @return
     * @throws Exception
     */
    public List getLookupReturns(String lookupClass) throws Exception ;
    
    /**
     * 
     * This method is to get the lookupfields of the lookupclass, and converted to string ans separated by ",".
     * @param lookupClass
     * @return
     * @throws Exception
     */
    public String getLookupReturnsForAjaxCall(String lookupClass) throws Exception ;
    
    /**
     * 
     * This method is to verify if a custom attribute is required.
     * @param dataTypeCode 
     * @param attr
     * @param customDataList
     * @return true if required false otherwise 
     
     */
	public boolean isRequired(String dataTypeCode, CustomAttribute attr, List<? extends DocumentCustomData> customDataList);
	
	/**
	 * Return a map translating document type code to a full name.  Such as AWRD : Award.
	 * @return
	 */
	public Map<String, String> getDocumentTypeMap();
	
	/**
	 * Return a map translating the full document type name to a code.  Such as Award : AWRD.
	 * @return
	 */
	public Map<String, String> getReverseDocumentTypeMap();

}
