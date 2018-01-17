/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.keyword;


import java.util.List;

/**
 * This interface has all the methods to process ScienceKeywords within a BO or Document.
 * Any BO or Document which handles Keywords should implement this interface.
 * @param <T>
 */
public interface KeywordsManager<T> {//KeywordsManager
    /**
     * 
     * This method is to get the list of Keywords from a Document or BO
     * @return
     */
    public List<T> getKeywords();
    /**
     * 
     * This method is add a keyword to the list in a Document or BO
     * @param scienceKeyword
     */
    public void addKeyword(ScienceKeyword scienceKeyword);
    /**
     * 
     * This method is to get the Keyword from the keywords list of a Document or BO
     * @param index
     * @return
     */
    public T getKeyword(int index);
}
