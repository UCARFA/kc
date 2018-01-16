/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions;

import java.io.Serializable;

public interface ProtocolEditableBean extends ProtocolActionBean, Serializable {

    public boolean getGeneralInfoEnabled();
    
    public void setGeneralInfoEnabled(boolean generalInfoEnabled);

    public boolean getFundingSourceEnabled();

    public void setFundingSourceEnabled(boolean fundingSourceEnabled);

    public boolean getProtocolReferencesEnabled();

    public void setProtocolReferencesEnabled(boolean protocolReferencesEnabled);

    public boolean getProtocolOrganizationsEnabled();

    public void setProtocolOrganizationsEnabled(boolean protocolOrganizationsEnabled);

    public boolean getSubjectsEnabled();

    public void setSubjectsEnabled(boolean subjectsEnabled);

    public boolean getAddModifyAttachmentsEnabled();

    public void setAddModifyAttachmentsEnabled(boolean addModifyAttachmentsEnabled);

    public boolean getAreasOfResearchEnabled();

    public void setAreasOfResearchEnabled(boolean areasOfResearchEnabled);

    public boolean getSpecialReviewEnabled();

    public void setSpecialReviewEnabled(boolean specialReviewEnabled);

    public boolean getProtocolPersonnelEnabled();

    public void setProtocolPersonnelEnabled(boolean protocolPersonnelEnabled);

    public boolean getOthersEnabled();

    public void setOthersEnabled(boolean othersEnabled);
    
    public boolean getProtocolPermissionsEnabled();

    public void setProtocolPermissionsEnabled(boolean protocolPermissionsEnabled);

    public boolean getQuestionnaireEnabled();

    public void setQuestionnaireEnabled(boolean questionnaireEnabled);
    
}
