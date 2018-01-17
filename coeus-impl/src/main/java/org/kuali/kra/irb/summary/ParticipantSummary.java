/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.summary;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class ParticipantSummary implements Serializable {

    private static final long serialVersionUID = 6459822062556001624L;
    
    private String description;
    private String count;
    
    private boolean descriptionChanged;
    private boolean countChanged;
    
    public ParticipantSummary() {
       
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getCount() {
        return count;
    }
    
    public void setCount(Integer count) {
        if (count == null) {
            this.count = "";
        }
        else {
            this.count = count.toString();
        }
    }

    public boolean isDescriptionChanged() {
        return descriptionChanged;
    }
    
    public boolean isCountChanged() {
        return countChanged;
    }
    
    public void compare(ProtocolSummary other) {
        ParticipantSummary otherParticipant = other.findParticipant(description);
        if (otherParticipant == null) {
            descriptionChanged = true;
            countChanged = true;
        }
        else {
            descriptionChanged = !StringUtils.equals(description, otherParticipant.description);
            countChanged = !StringUtils.equals(count, otherParticipant.count);
        }
    }
}
