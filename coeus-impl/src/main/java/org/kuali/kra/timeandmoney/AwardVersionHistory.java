/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.timeandmoney;

import org.kuali.kra.award.home.Award;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A collection of this class is maintained on Time And Money Document.  There will be one entry for each version
 * of the current Award on Time And Money Document.
 */
public class AwardVersionHistory implements Serializable{


    private static final long serialVersionUID = -1282330144911723521L;
    
    private String documentUrl;
    private String awardDescriptionLine;
    private List<TimeAndMoneyDocumentHistory> timeAndMoneyDocumentHistoryList;
    private Award awardParent;
    
    public AwardVersionHistory(Award parent) {
        timeAndMoneyDocumentHistoryList = new ArrayList<>();
        awardParent = parent;
    }
    
    /**
     * Gets the documentUrl attribute. 
     * @return Returns the documentUrl.
     */
    public String getDocumentUrl() {
        return documentUrl;
    }
    /**
     * Sets the documentUrl attribute value.
     * @param documentUrl The documentUrl to set.
     */
    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
    }
    /**
     * Gets the awardDescriptionLine attribute. 
     * @return Returns the awardDescriptionLine.
     */
    public String getAwardDescriptionLine() {
        return awardDescriptionLine;
    }
    /**
     * Sets the awardDescriptionLine attribute value.
     * @param awardDescriptionLine The awardDescriptionLine to set.
     */
    public void setAwardDescriptionLine(String awardDescriptionLine) {
        this.awardDescriptionLine = awardDescriptionLine;
    }
    /**
     * Gets the timeAndMoneyDocumentHistoryList attribute. 
     * @return Returns the timeAndMoneyDocumentHistoryList.
     */
    public List<TimeAndMoneyDocumentHistory> getTimeAndMoneyDocumentHistoryList() {
        return timeAndMoneyDocumentHistoryList;
    }
    /**
     * Sets the timeAndMoneyDocumentHistoryList attribute value.
     * @param timeAndMoneyDocumentHistoryList The timeAndMoneyDocumentHistoryList to set.
     */
    public void setTimeAndMoneyDocumentHistoryList(List<TimeAndMoneyDocumentHistory> timeAndMoneyDocumentHistoryList) {
        this.timeAndMoneyDocumentHistoryList = timeAndMoneyDocumentHistoryList;
    }
    
    public Award getAwardParent() {
        return awardParent;
    }
    
}
