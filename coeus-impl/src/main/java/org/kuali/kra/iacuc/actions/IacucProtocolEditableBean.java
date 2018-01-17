/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions;

import org.kuali.kra.protocol.actions.ProtocolEditableBean;

public class IacucProtocolEditableBean extends IacucProtocolActionBean implements ProtocolEditableBean {


    private static final long serialVersionUID = 5518447794781881082L;

    private boolean generalInfoEnabled = false;
    private boolean fundingSourceEnabled = false;
    private boolean protocolReferencesEnabled = false;
    private boolean protocolOrganizationsEnabled = false;
    private boolean subjectsEnabled = false;
    private boolean addModifyAttachmentsEnabled = false;
    private boolean areasOfResearchEnabled = false;
    private boolean specialReviewEnabled = false;
    private boolean protocolPersonnelEnabled = false;
    private boolean othersEnabled = false;
    private boolean protocolPermissionsEnabled = false;
    private boolean questionnaireEnabled = false;
    
    private boolean threersEnabled = false;
    private boolean speciesAndGroupsEnabled = false;
    private boolean proceduresEnabled = false;
    private boolean protocolExceptionsEnabled = false;

    /**
     * Constructs a ProtocolEditableBean.
     * @param actionHelper Reference back to the action helper for this bean
     */
    public IacucProtocolEditableBean(IacucActionHelper actionHelper) {
        super(actionHelper);
    }

    @Override
    public boolean getGeneralInfoEnabled() {
        return generalInfoEnabled;
    }

    @Override
    public void setGeneralInfoEnabled(boolean generalInfoEnabled) {
        this.generalInfoEnabled = generalInfoEnabled;
    }

    @Override
    public boolean getFundingSourceEnabled() {
        return fundingSourceEnabled;
    }

    @Override
    public void setFundingSourceEnabled(boolean fundingSourceEnabled) {
        this.fundingSourceEnabled = fundingSourceEnabled;
    }

    @Override
    public boolean getProtocolReferencesEnabled() {
        return protocolReferencesEnabled;
    }

    @Override
    public void setProtocolReferencesEnabled(boolean protocolReferencesEnabled) {
        this.protocolReferencesEnabled = protocolReferencesEnabled;
    }

    @Override
    public boolean getProtocolOrganizationsEnabled() {
        return protocolOrganizationsEnabled;
    }

    @Override
    public void setProtocolOrganizationsEnabled(boolean protocolOrganizationsEnabled) {
        this.protocolOrganizationsEnabled = protocolOrganizationsEnabled;
    }

    @Override
    public boolean getSubjectsEnabled() {
        return subjectsEnabled;
    }

    @Override
    public void setSubjectsEnabled(boolean subjectsEnabled) {
        this.subjectsEnabled = subjectsEnabled;
    }

    @Override
    public boolean getAddModifyAttachmentsEnabled() {
        return addModifyAttachmentsEnabled;
    }

    @Override
    public void setAddModifyAttachmentsEnabled(boolean addModifyAttachmentsEnabled) {
        this.addModifyAttachmentsEnabled = addModifyAttachmentsEnabled;
    }

    @Override
    public boolean getAreasOfResearchEnabled() {
        return areasOfResearchEnabled;
    }

    @Override
    public void setAreasOfResearchEnabled(boolean areasOfResearchEnabled) {
        this.areasOfResearchEnabled = areasOfResearchEnabled;
    }

    @Override
    public boolean getSpecialReviewEnabled() {
        return specialReviewEnabled;
    }

    @Override
    public void setSpecialReviewEnabled(boolean specialReviewEnabled) {
        this.specialReviewEnabled = specialReviewEnabled;
    }

    @Override
    public boolean getProtocolPersonnelEnabled() {
        return protocolPersonnelEnabled;
    }

    @Override
    public void setProtocolPersonnelEnabled(boolean protocolPersonnelEnabled) {
        this.protocolPersonnelEnabled = protocolPersonnelEnabled;
    }

    @Override
    public boolean getOthersEnabled() {
        return othersEnabled;
    }

    @Override
    public void setOthersEnabled(boolean othersEnabled) {
        this.othersEnabled = othersEnabled;
    }

    @Override
    public boolean getProtocolPermissionsEnabled() {
        return protocolPermissionsEnabled;
    }

    @Override
    public void setProtocolPermissionsEnabled(boolean protocolPermissionsEnabled) {
        this.protocolPermissionsEnabled = protocolPermissionsEnabled;
    }

    @Override
    public boolean getQuestionnaireEnabled() {
        return questionnaireEnabled;
    }

    @Override
    public void setQuestionnaireEnabled(boolean questionnaireEnabled) {
        this.questionnaireEnabled = questionnaireEnabled;
    }

    public boolean isThreersEnabled() {
        return threersEnabled;
    }

    public void setThreersEnabled(boolean threersEnabled) {
        this.threersEnabled = threersEnabled;
    }

    public boolean isSpeciesAndGroupsEnabled() {
        return speciesAndGroupsEnabled;
    }

    public void setSpeciesAndGroupsEnabled(boolean speciesAndGroupsEnabled) {
        this.speciesAndGroupsEnabled = speciesAndGroupsEnabled;
    }

    public boolean isProceduresEnabled() {
        return proceduresEnabled;
    }

    public void setProceduresEnabled(boolean proceduresEnabled) {
        this.proceduresEnabled = proceduresEnabled;
    }

    public boolean isProtocolExceptionsEnabled() {
        return protocolExceptionsEnabled;
    }

    public void setProtocolExceptionsEnabled(boolean protocolExceptionsEnabled) {
        this.protocolExceptionsEnabled = protocolExceptionsEnabled;
    }

}
