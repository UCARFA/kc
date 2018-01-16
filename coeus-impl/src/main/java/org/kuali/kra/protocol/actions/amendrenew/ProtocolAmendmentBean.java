/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.amendrenew;

import org.kuali.kra.protocol.actions.ProtocolEditableBean;


public interface ProtocolAmendmentBean extends ProtocolEditableBean {


    public String getSummary(); 

    public void setSummary(String summary); 

    public boolean getGeneralInfo();

    public void setGeneralInfo(boolean generalInfo);

    public boolean getFundingSource();

    public void setFundingSource(boolean fundingSource);

    public boolean getProtocolReferencesAndOtherIdentifiers();

    public void setProtocolReferencesAndOtherIdentifiers(boolean protocolReferencesAndOtherIdentifiers);

    public boolean getProtocolOrganizations();

    public void setProtocolOrganizations(boolean protocolOrganizations);

    public boolean getSubjects();

    public void setSubjects(boolean subjects);

    public boolean getAddModifyAttachments();

    public void setAddModifyAttachments(boolean addModifyAttachments);

    public boolean getAreasOfResearch();

    public void setAreasOfResearch(boolean areasOfResearch);

    public boolean getSpecialReview();

    public void setSpecialReview(boolean specialReview);

    public boolean getProtocolPersonnel();

    public void setProtocolPersonnel(boolean protocolPersonnel);

    public boolean getOthers();

    public void setOthers(boolean others);
    
    public boolean getProtocolPermissions();

    public void setProtocolPermissions(boolean protocolPermissions);

    public boolean isSomeSelected();
    
    public boolean getQuestionnaire();

    public void setQuestionnaire(boolean questionnaire);
    
}
