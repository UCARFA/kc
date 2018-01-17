/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.keyword;


import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * 
 * This is an abstract class for holding common properties of ScienceKeyword
 * 
 */
public abstract class AbstractScienceKeyword extends KcPersistableBusinessObjectBase {

    private String scienceKeywordCode;

    private String scienceKeywordDescription;

    private ScienceKeyword scienceKeyword;

    private Boolean selectKeyword = false;

    /**
     * Gets the scienceKeywordCode attribute. 
     * @return Returns the scienceKeywordCode.
     */
    public String getScienceKeywordCode() {
        return scienceKeywordCode;
    }

    /**
     * Sets the scienceKeywordCode attribute value.
     * @param scienceKeywordCode
     */
    public void setScienceKeywordCode(String scienceKeywordCode) {
        this.scienceKeywordCode = scienceKeywordCode;
    }

    /**
     * Gets the scienceKeyword attribute. 
     * @return Returns the scienceKeyword.
     */
    public ScienceKeyword getScienceKeyword() {
        return scienceKeyword;
    }

    /**
     * Sets the scienceKeyword attribute value.
     * @param scienceKeyword The scienceKeyword to set.
     */
    public void setScienceKeyword(ScienceKeyword scienceKeyword) {
        this.scienceKeyword = scienceKeyword;
    }

    /**
     * Gets the selectKeyword attribute. 
     * @return Returns the selectKeyword.
     */
    public Boolean getSelectKeyword() {
        return selectKeyword;
    }

    /**
     * Sets the selectKeyword attribute value.
     * @param selectKeyword The selectKeyword to set.
     */
    public void setSelectKeyword(Boolean selectKeyword) {
        this.selectKeyword = selectKeyword;
    }

    /**
     * Gets the scienceKeywordDescription attribute. 
     * @return Returns the scienceKeywordDescription.
     */
    public String getScienceKeywordDescription() {
        return scienceKeywordDescription;
    }

    /**
     * Sets the scienceKeywordDescription attribute value.
     * @param scienceKeywordDescription The scienceKeywordDescription to set.
     */
    public void setScienceKeywordDescription(String scienceKeywordDescription) {
        this.scienceKeywordDescription = scienceKeywordDescription;
    }
}
