/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.kra.iacuc.actions.amendrenew;

import org.kuali.kra.iacuc.actions.IacucActionHelper;
import org.kuali.kra.iacuc.actions.IacucProtocolEditableBean;
import org.kuali.kra.protocol.actions.amendrenew.ProtocolAmendmentBean;

public class IacucProtocolAmendmentBean extends IacucProtocolEditableBean implements ProtocolAmendmentBean {

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
    private boolean protocolPermissions = false;
    private boolean questionnaire = false;
    
    private boolean threers = false;
    private boolean speciesAndGroups = false;
    private boolean procedures = false;
    private boolean protocolExceptions = false;
    
    /**
     * Constructs a ProtocolAmendmentBean.
     * @param actionHelper Reference back to the action helper for this bean
     */
    public IacucProtocolAmendmentBean(IacucActionHelper actionHelper) {
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
               getThreers() ||
               getSpeciesAndGroups() ||
               getProcedures() ||
               getProtocolExceptions() ||
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

    public boolean getThreers() {
        return threers;
    }

    public void setThreers(boolean threers) {
        this.threers = threers;
    }

    public boolean getSpeciesAndGroups() {
        return speciesAndGroups;
    }

    public void setSpeciesAndGroups(boolean speciesAndGroups) {
        this.speciesAndGroups = speciesAndGroups;
    }

    public boolean getProcedures() {
        return procedures;
    }

    public void setProcedures(boolean procedures) {
        this.procedures = procedures;
    }

    public boolean getProtocolExceptions() {
        return protocolExceptions;
    }

    public void setProtocolExceptions(boolean protocolExceptions) {
        this.protocolExceptions = protocolExceptions;
    }
}
