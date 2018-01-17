/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.summary;

import java.io.Serializable;

public class ResearchAreaSummary implements Serializable {

    private static final long serialVersionUID = 4781269721650065533L;
    
    private String researchAreaCode;
    private String description;
    
    private boolean changed;

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public void setResearchAreaCode(String researchAreaCode) {
        this.researchAreaCode = researchAreaCode;
    }
    
    public String getResearchAreaCode() {
        return researchAreaCode;
    }

    public void compare(ProtocolSummary other) {
        ResearchAreaSummary otherResearchArea = other.findResearchArea(researchAreaCode);
        changed = (otherResearchArea == null);
    }
    
    public boolean isChanged() {
        return changed;
    }
}
