/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.protocol.research;

import org.kuali.kra.bo.ResearchAreaBase;
import org.kuali.kra.protocol.ProtocolAssociateBase;

public abstract class ProtocolResearchAreaBase extends ProtocolAssociateBase {

    private static final long serialVersionUID = -1522011425745031200L;

    private Long id;

    private String researchAreaCode;

    private ResearchAreaBase researchAreas;

    public ProtocolResearchAreaBase() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResearchAreaCode() {
        return researchAreaCode;
    }

    public void setResearchAreaCode(String researchAreaCode) {
        this.researchAreaCode = researchAreaCode;
    }

    public ResearchAreaBase getResearchAreas() {
        return researchAreas;
    }

    public void setResearchAreas(ResearchAreaBase researchAreas) {
        this.researchAreas = researchAreas;
    }

    @Override
    public void resetPersistenceState() {
        this.setId(null);
    }
}
