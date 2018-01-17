/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.amendrenew;

import org.kuali.kra.irb.actions.ActionHelper;
import org.kuali.kra.irb.actions.ProtocolEditableBean;

public class ProtocolAmendmentBean extends ProtocolEditableBean implements org.kuali.kra.protocol.actions.amendrenew.ProtocolAmendmentBean {

    private static final long serialVersionUID = 6548643656057631296L;

    private String summary = "";
    
    private boolean generalInfo = false;
    private boolean fundingSource = false;
    private boolean protocolReferencesAndOtherIdentifiers = false;
    private boolean protocolOrganizations = false;
    private boolean subjects = false;
    private boolean addModifyAttachments = false;
    private boolean areasOfResearch = false;
    private boolean specialReview = false;
    private boolean protocolPersonnel = false;
    private boolean others = false;
    private boolean protocolPermissions = true;
    private boolean questionnaire = false;
    
    /**
     * Constructs a ProtocolAmendmentBean.
     * @param actionHelper Reference back to the action helper for this bean
     */
    public ProtocolAmendmentBean(ActionHelper actionHelper) {
        super(actionHelper);
    }

    @Override
    public String getSummary() {
        return summary;
    }

    @Override
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public boolean getGeneralInfo() {
        return generalInfo;
    }

    @Override
    public void setGeneralInfo(boolean generalInfo) {
        this.generalInfo = generalInfo;
    }

    @Override
    public boolean getFundingSource() {
        return fundingSource;
    }

    @Override
    public void setFundingSource(boolean fundingSource) {
        this.fundingSource = fundingSource;
    }

    @Override
    public boolean getProtocolReferencesAndOtherIdentifiers() {
        return protocolReferencesAndOtherIdentifiers;
    }

    @Override
    public void setProtocolReferencesAndOtherIdentifiers(boolean protocolReferencesAndOtherIdentifiers) {
        this.protocolReferencesAndOtherIdentifiers = protocolReferencesAndOtherIdentifiers;
    }

    @Override
    public boolean getProtocolOrganizations() {
        return protocolOrganizations;
    }

    @Override
    public void setProtocolOrganizations(boolean protocolOrganizations) {
        this.protocolOrganizations = protocolOrganizations;
    }

    @Override
    public boolean getSubjects() {
        return subjects;
    }

    @Override
    public void setSubjects(boolean subjects) {
        this.subjects = subjects;
    }

    @Override
    public boolean getAddModifyAttachments() {
        return addModifyAttachments;
    }

    @Override
    public void setAddModifyAttachments(boolean addModifyAttachments) {
        this.addModifyAttachments = addModifyAttachments;
    }

    @Override
    public boolean getAreasOfResearch() {
        return areasOfResearch;
    }

    @Override
    public void setAreasOfResearch(boolean areasOfResearch) {
        this.areasOfResearch = areasOfResearch;
    }

    @Override
    public boolean getSpecialReview() {
        return specialReview;
    }

    @Override
    public void setSpecialReview(boolean specialReview) {
        this.specialReview = specialReview;
    }

    @Override
    public boolean getProtocolPersonnel() {
        return protocolPersonnel;
    }

    @Override
    public void setProtocolPersonnel(boolean protocolPersonnel) {
        this.protocolPersonnel = protocolPersonnel;
    }

    @Override
    public boolean getOthers() {
        return others;
    }

    @Override
    public void setOthers(boolean others) {
        this.others = others;
    }
    
    @Override
    public boolean getProtocolPermissions() {
        return protocolPermissions;
    }

    @Override
    public void setProtocolPermissions(boolean protocolPermissions) {
        this.protocolPermissions = protocolPermissions;
    }

    @Override
    public boolean isSomeSelected() {
        return getAddModifyAttachments() ||
               getAreasOfResearch() ||
               getFundingSource() ||
               getGeneralInfo() ||
               getOthers() ||
               getProtocolOrganizations() ||
               getProtocolPersonnel() ||
               getProtocolReferencesAndOtherIdentifiers() ||
               getSpecialReview() ||
               getSubjects() ||
               getProtocolPermissions() ||
               getQuestionnaire();
    }

    @Override
    public boolean getQuestionnaire() {
        return questionnaire;
    }

    @Override
    public void setQuestionnaire(boolean questionnaire) {
        this.questionnaire = questionnaire;
    }
}
