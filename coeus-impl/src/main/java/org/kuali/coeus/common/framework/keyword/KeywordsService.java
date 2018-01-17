/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.keyword;

import org.kuali.coeus.sys.framework.model.MultiLookupForm;

/**
 * This service is to handle the requests from Keywords panel
 */
public interface KeywordsService<T> {

    /**
     * 
     * This method is to add keyword to the document or BO.
     * @param document or BO
     * @param scienceKeyWord
     */
    public void addKeyword( KeywordsManager<T> document,ScienceKeyword scienceKeyWord);
    
    /**
     * 
     * This method is to delete all selected keywords from the keywords list.
     * @param document or BO
     */
    public void deleteKeyword(KeywordsManager<T> document);
    
    public void addKeywords(KeywordsManager<T> document,MultiLookupForm multiLookUpForm);
    
}
