/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc;

import org.kuali.kra.bo.ResearchAreaBase;

public class IacucResearchArea extends ResearchAreaBase {


    private static final long serialVersionUID = -570251855552419477L;

    public IacucResearchArea() {
        super();
    }

    public IacucResearchArea(String researchAreaCode, String parentResearchAreaCode, String description, boolean active) {
        super(researchAreaCode, parentResearchAreaCode, description, active);
    }

}
