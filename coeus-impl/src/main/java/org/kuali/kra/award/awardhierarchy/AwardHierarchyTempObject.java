/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.awardhierarchy;

import java.io.Serializable;

public class AwardHierarchyTempObject implements Serializable{
    private String awardNumber;
    private String newChildPanelTargetAward;
    private String copyAwardPanelTargetAward;
    private Boolean copyDescendants;
    private String copyAwardRadio;
    private String createNewChildRadio;
    
    public AwardHierarchyTempObject(){
        newChildPanelTargetAward = "";
        copyAwardPanelTargetAward = "";
    }

    public String getNewChildPanelTargetAward() {
        return newChildPanelTargetAward;
    }

    public void setNewChildPanelTargetAward(String newChildPanelTargetAward) {
        this.newChildPanelTargetAward = newChildPanelTargetAward;
    }

    public String getCopyAwardPanelTargetAward() {
        return copyAwardPanelTargetAward;
    }

    public void setCopyAwardPanelTargetAward(String copyAwardPanelTargetAward) {
        this.copyAwardPanelTargetAward = copyAwardPanelTargetAward;
    }

    public Boolean getCopyDescendants() {
        return copyDescendants;
    }

    public void setCopyDescendants(Boolean copyDescendants) {
        this.copyDescendants = copyDescendants;
    }

    public String getCopyAwardRadio() {
        return copyAwardRadio;
    }

    public void setCopyAwardRadio(String copyAwardRadio) {
        this.copyAwardRadio = copyAwardRadio;
    }

    public String getCreateNewChildRadio() {
        return createNewChildRadio;
    }

    public void setCreateNewChildRadio(String createNewChildRadio) {
        this.createNewChildRadio = createNewChildRadio;
    }    

    public String getAwardNumber() {
        return awardNumber;
    }
    
    public void setAwardNumber(String awardNumber) {
        this.awardNumber = awardNumber;
    }
}

