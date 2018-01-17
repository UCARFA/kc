/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb;

import org.kuali.kra.bo.ResearchAreaBase;


public class ResearchArea extends ResearchAreaBase {


    private static final long serialVersionUID = -6641512586489764343L;
    
    public ResearchArea() {
        super();
    }
    
    public ResearchArea(String researchAreaCode, String parentResearchAreaCode, String description, boolean active) {
        super(researchAreaCode, parentResearchAreaCode, description, active);
    }
}
