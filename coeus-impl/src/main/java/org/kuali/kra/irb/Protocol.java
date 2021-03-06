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
package org.kuali.kra.irb;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.custom.CustomDataContainer;
import org.kuali.coeus.common.framework.custom.DocumentCustomData;
import org.kuali.coeus.common.notification.impl.bo.KcNotification;
import org.kuali.coeus.common.permissions.impl.PermissionableKeys;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.RoleConstants;
import org.kuali.kra.irb.actions.ProtocolAction;
import org.kuali.kra.irb.actions.ProtocolStatus;
import org.kuali.kra.irb.actions.amendrenew.ProtocolModule;
import org.kuali.kra.irb.actions.risklevel.ProtocolRiskLevel;
import org.kuali.kra.irb.actions.submit.ProtocolSubmission;
import org.kuali.kra.irb.actions.submit.ProtocolSubmissionStatus;
import org.kuali.kra.irb.actions.submit.ProtocolSubmissionType;
import org.kuali.kra.irb.noteattachment.ProtocolAttachmentFilter;
import org.kuali.kra.irb.noteattachment.ProtocolAttachmentProtocol;
import org.kuali.kra.irb.personnel.ProtocolPersonnelService;
import org.kuali.kra.irb.protocol.participant.ProtocolParticipant;
import org.kuali.kra.irb.protocol.research.ProtocolResearchArea;
import org.kuali.kra.irb.questionnaire.ProtocolModuleQuestionnaireBean;
import org.kuali.kra.irb.summary.ParticipantSummary;
import org.kuali.kra.irb.summary.ProtocolSummary;
import org.kuali.coeus.common.framework.krms.KrmsRulesContext;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.ProtocolSpecialVersion;
import org.kuali.kra.protocol.actions.ProtocolActionBase;
import org.kuali.kra.protocol.actions.ProtocolStatusBase;
import org.kuali.kra.protocol.actions.amendrenew.ProtocolAmendRenewModuleBase;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionStatusBase;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionTypeBase;
import org.kuali.kra.protocol.noteattachment.ProtocolAttachmentFilterBase;
import org.kuali.kra.protocol.noteattachment.ProtocolAttachmentProtocolBase;
import org.kuali.kra.protocol.protocol.research.ProtocolResearchAreaBase;
import org.kuali.coeus.common.questionnaire.framework.answer.AnswerHeader;
import org.kuali.coeus.common.questionnaire.framework.answer.ModuleQuestionnaireBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Protocol extends ProtocolBase implements CustomDataContainer {

    private static final long serialVersionUID = 4396393806439396971L;
    
    private static final String DEFAULT_PROTOCOL_TYPE_CODE = "1";

    private String vulnerableSubjectIndicator;
    private List<ProtocolRiskLevel> protocolRiskLevels;
    private List<ProtocolParticipant> protocolParticipants;    
    private transient boolean lookupActionNotifyIRBProtocol;
    private transient ProtocolVersionService protocolVersionService;

    public Protocol() {
        super();
        protocolRiskLevels = new ArrayList<>();
        protocolParticipants = new ArrayList<>();
    }
    
    public String getVulnerableSubjectIndicator() {
        return vulnerableSubjectIndicator;
    }

    public void setVulnerableSubjectIndicator(String vulnerableSubjectIndicator) {
        this.vulnerableSubjectIndicator = vulnerableSubjectIndicator;
    }

    public List<ProtocolRiskLevel> getProtocolRiskLevels() {
        return protocolRiskLevels;
    }

    public void setProtocolRiskLevels(List<ProtocolRiskLevel> protocolRiskLevels) {
        this.protocolRiskLevels = protocolRiskLevels;
        for (ProtocolRiskLevel riskLevel : protocolRiskLevels) {
            riskLevel.init(this);
        }
    }
    
    public List<ProtocolParticipant> getProtocolParticipants() {
        return protocolParticipants;
    }

    public void setProtocolParticipants(List<ProtocolParticipant> protocolParticipants) {
        this.protocolParticipants = protocolParticipants;
        for (ProtocolParticipant participant : protocolParticipants) {
            participant.init(this);
        }
    }

    public ProtocolParticipant getProtocolParticipant(int index) {
        return getProtocolParticipants().get(index);
    }    
    
    @SuppressWarnings("unchecked")
    @Override
    public List buildListOfDeletionAwareLists() {
        List managedLists = super.buildListOfDeletionAwareLists();
        managedLists.add(getProtocolRiskLevels());
        managedLists.add(getProtocolParticipants());
        return managedLists;
    }

    @Override
    protected ProtocolPersonnelService getProtocolPersonnelService() {
        return KcServiceLocator.getService(ProtocolPersonnelService.class);
    }

    @Override
    public ProtocolSubmission getProtocolSubmission() {
        return (ProtocolSubmission) super.getProtocolSubmission(); 
    }

    @Override
    public ProtocolAction getLastProtocolAction() {
        return (ProtocolAction) super.getLastProtocolAction();
    }    
    
    /**
     * 
     * This method merges the data of a specific module of the amended protocol into this protocol.
     */
    @Override
    public void merge(ProtocolBase amendment, String protocolModuleTypeCode) {
        if (StringUtils.equals(protocolModuleTypeCode, ProtocolModule.GENERAL_INFO)) {
            mergeGeneralInfo(amendment);
        }
        else if (StringUtils.equals(protocolModuleTypeCode, ProtocolModule.AREAS_OF_RESEARCH)) {
            mergeResearchAreas(amendment);
        }
        else if (StringUtils.equals(protocolModuleTypeCode, ProtocolModule.FUNDING_SOURCE)) {
            mergeFundingSources(amendment);
        }
        else if (StringUtils.equals(protocolModuleTypeCode, ProtocolModule.PROTOCOL_ORGANIZATIONS)) {
            mergeOrganizations(amendment);
        }
        else if (StringUtils.equals(protocolModuleTypeCode, ProtocolModule.PROTOCOL_PERSONNEL)) {
            mergePersonnel(amendment);
        }
        else if (StringUtils.equals(protocolModuleTypeCode, ProtocolModule.ADD_MODIFY_ATTACHMENTS)) {
            if (amendment.isAmendment() || amendment.isRenewal()
                    || (!amendment.getAttachmentProtocols().isEmpty() && this.getAttachmentProtocols().isEmpty())) {
                mergeAttachments(amendment);
            }
            else {
                restoreAttachments(this);
            }
        }
        else if (StringUtils.equals(protocolModuleTypeCode, ProtocolModule.PROTOCOL_REFERENCES)) {
            mergeReferences(amendment);
        }
        else if (StringUtils.equals(protocolModuleTypeCode, ProtocolModule.SPECIAL_REVIEW)) {
            mergeSpecialReview(amendment);
        }
        else if (StringUtils.equals(protocolModuleTypeCode, ProtocolModule.SUBJECTS)) {
            mergeSubjects((Protocol) amendment);
        }
        else if (StringUtils.equals(protocolModuleTypeCode, ProtocolModule.OTHERS)) {
            mergeOthers(amendment);
        }
        else if (StringUtils.equals(protocolModuleTypeCode, ProtocolModule.PROTOCOL_PERMISSIONS)) {
            mergeProtocolPermissions(amendment);
        }
        else if (StringUtils.equals(protocolModuleTypeCode, ProtocolModule.QUESTIONNAIRE)) {
            mergeProtocolQuestionnaire(amendment);
        }
    }

    @Override
    protected void removeMergeableLists(List<ProtocolAmendRenewModuleBase> modules) {
        for (ProtocolAmendRenewModuleBase module: modules) {
            String protocolModuleTypeCode = module.getProtocolModuleTypeCode();
            if (StringUtils.equals(protocolModuleTypeCode, ProtocolModule.AREAS_OF_RESEARCH)) {
                this.getProtocolResearchAreas().clear();
            }
            else if (StringUtils.equals(protocolModuleTypeCode, ProtocolModule.FUNDING_SOURCE)) {
                this.getProtocolFundingSources().clear();
            }
            else if (StringUtils.equals(protocolModuleTypeCode, ProtocolModule.PROTOCOL_ORGANIZATIONS)) {
                this.getProtocolLocations().clear();
            }
            else if (StringUtils.equals(protocolModuleTypeCode, ProtocolModule.PROTOCOL_PERSONNEL)) {
                this.getProtocolPersons().clear();
            }
            else if (StringUtils.equals(protocolModuleTypeCode, ProtocolModule.PROTOCOL_REFERENCES)) {
                this.getProtocolReferences().clear();
            }
            else if (StringUtils.equals(protocolModuleTypeCode, ProtocolModule.SUBJECTS)) {
                this.getProtocolParticipants().clear();
            }
        }
    }


    /**
     * get submit for review questionnaire answerheaders.
     */
    @Override
    public List <AnswerHeader> getAnswerHeaderForProtocol(ProtocolBase protocol) {
        ModuleQuestionnaireBean moduleQuestionnaireBean = new ProtocolModuleQuestionnaireBean((Protocol) protocol);
        moduleQuestionnaireBean.setModuleSubItemCode("0");
        return getQuestionnaireAnswerService().getQuestionnaireAnswer(moduleQuestionnaireBean);
    }
    
    /**
     * merge amendment/renewal protocol action to original protocol when A/R is approved.
     */
    @Override
    protected void mergeProtocolAction(ProtocolBase amendment) {
        List<ProtocolActionBase> protocolActions = deepCopy(amendment.getProtocolActions());
        Collections.sort(protocolActions, (action1, action2) -> action1.getActionId().compareTo(action2.getActionId()));
        // the first 1 'protocol created is already added to original protocol
        // the last one is 'approve'
        protocolActions.remove(0);
        protocolActions.remove(protocolActions.size() - 1);
        for (ProtocolActionBase protocolAction : protocolActions) {
            protocolAction.setProtocolNumber(this.getProtocolNumber());
            protocolAction.setProtocolActionId(null);
            protocolAction.setSequenceNumber(getSequenceNumber());
            protocolAction.setProtocolId(this.getProtocolId());
            String index = amendment.getProtocolNumber().substring(11);
            protocolAction.setActionId(getNextValue(NEXT_ACTION_ID_KEY));
            String type = ProtocolSpecialVersion.AMENDMENT.getDescription();
            if (amendment.isRenewal()) {
                type = ProtocolSpecialVersion.RENEWAL.getDescription();
            }
            else if (amendment.isFYI()) {
                type = ProtocolSpecialVersion.FYI.getDescription();
            }
            if (StringUtils.isNotBlank(protocolAction.getComments())) {
                protocolAction.setComments(type + "-" + index + ": " + protocolAction.getComments());
            } else {
                protocolAction.setComments(type + "-" + index + ": ");
            }
            // reset persistence state for copied notifications so they break ties with old document
            for (KcNotification notification: protocolAction.getProtocolNotifications()) {
                notification.setDocumentNumber(getProtocolDocument().getDocumentNumber());
                notification.resetPersistenceState();
                notification.setOwningDocumentIdFk(null);
            }
            this.getProtocolActions().add(protocolAction);
        }
    }

    private void mergeSubjects(Protocol amendment) {
        setProtocolParticipants(deepCopy(amendment.getProtocolParticipants()));
    }

    @Override
    public ProtocolSummary getProtocolSummary() {
        ProtocolSummary protocolSummary = createProtocolSummary();
        addPersonnelSummaries(protocolSummary);
        addResearchAreaSummaries(protocolSummary);
        addAttachmentSummaries(protocolSummary);
        addFundingSourceSummaries(protocolSummary);
        addParticipantSummaries(protocolSummary);
        addOrganizationSummaries(protocolSummary);
        addSpecialReviewSummaries(protocolSummary);
        addAdditionalInfoSummary(protocolSummary);
        return protocolSummary;
    }
    
    private void addParticipantSummaries(ProtocolSummary protocolSummary) {
        for (ProtocolParticipant participant : this.getProtocolParticipants()) {
            ParticipantSummary participantSummary = new ParticipantSummary();
            participantSummary.setDescription(participant.getParticipantType().getDescription());
            participantSummary.setCount(participant.getParticipantCount());
            protocolSummary.add(participantSummary);
        }
    }

    @Override
    protected ProtocolSummary createProtocolSummary() {
        ProtocolSummary summary = new ProtocolSummary();
        summary.setLastProtocolAction(getLastProtocolAction());
        summary.setProtocolNumber(getProtocolNumber());
        summary.setPiName(getPrincipalInvestigator().getPersonName());
        summary.setPiProtocolPersonId(getPrincipalInvestigator().getProtocolPersonId());
        summary.setInitialSubmissionDate(getInitialSubmissionDate());
        summary.setApprovalDate(getApprovalDate());
        summary.setLastApprovalDate(getLastApprovalDate());
        summary.setExpirationDate(getExpirationDate());
        if (getProtocolType() == null) {
            refreshReferenceObject(PROTOCOL_TYPE);
        }
        summary.setType(getProtocolType().getDescription());
        if (getProtocolStatus() == null) {
            refreshReferenceObject(PROTOCOL_STATUS);
        }
        summary.setStatus(getProtocolStatus().getDescription());
        summary.setTitle(getTitle());
        return summary;
    }

    
    @Override
    public String getDocumentKey() {
        return PermissionableKeys.PROTOCOL_KEY;
    }

    @Override
    public List<String> getRoleNames() {
        List<String> roleNames = new ArrayList<>();

        roleNames.add(RoleConstants.PROTOCOL_AGGREGATOR);
        roleNames.add(RoleConstants.PROTOCOL_VIEWER);

        return roleNames;
    }

    @Override
    public String getNamespace() {
        return Constants.MODULE_NAMESPACE_IRB;
    }

    @Override
    public String getDocumentRoleTypeCode() {
        return RoleConstants.PROTOCOL_DOC_ROLE_TYPE;
    }

    @Override
    public void initializeProtocolAttachmentFilter() {
        ProtocolAttachmentFilterBase protocolAttachmentFilter = new ProtocolAttachmentFilter();
        
        //Lets see if there is a default set for the attachment sort
        try {
            String defaultSortBy = getParameterService().getParameterValueAsString(ProtocolDocument.class, Constants.PARAMETER_PROTOCOL_ATTACHMENT_DEFAULT_SORT);
            if (StringUtils.isNotBlank(defaultSortBy)) {
                protocolAttachmentFilter.setSortBy(defaultSortBy);
            }
        } catch (Exception e) {
            //No default found, do nothing.
        }        
        
        setProtocolAttachmentFilter(protocolAttachmentFilter);
    }

    @Override
    public KrmsRulesContext getKrmsRulesContext() {
        return getProtocolDocument();
    }

    @Override
    protected ProtocolStatusBase getProtocolStatusNewInstanceHook() {
        return new ProtocolStatus();
    }

    @Override
    protected String getDefaultProtocolStatusCodeHook() {
        return Constants.DEFAULT_PROTOCOL_STATUS_CODE;
    }

    @Override
    protected String getDefaultProtocolTypeCodeHook() {
        return DEFAULT_PROTOCOL_TYPE_CODE;
    }

    @Override
    protected ProtocolResearchAreaBase getNewProtocolResearchAreaInstance() {
        return new ProtocolResearchArea();
    }

    @Override
    protected ProtocolSubmissionStatusBase getProtocolSubmissionStatusNewInstanceHook() {
        return new ProtocolSubmissionStatus();
    }

    @Override
    protected ProtocolSubmissionTypeBase getProtocolSubmissionTypeNewInstanceHook() {
        return new ProtocolSubmissionType();
    }

    @Override
    protected ProtocolSubmissionBase getProtocolSubmissionNewInstanceHook() {
        return new ProtocolSubmission();
    }

    @Override
    protected String getProtocolModuleAddModifyAttachmentCodeHook() {
        return ProtocolModule.ADD_MODIFY_ATTACHMENTS;
    }

    @Override
    protected Class<? extends ProtocolAttachmentProtocolBase> getProtocolAttachmentProtocolClassHook() {
        return ProtocolAttachmentProtocol.class;
    }

    public boolean isLookupActionNotifyIRBProtocol() {
        return lookupActionNotifyIRBProtocol;
    }

    public void setLookupActionNotifyIRBProtocol(boolean lookupActionNotifyIRBProtocol) {
        this.lookupActionNotifyIRBProtocol = lookupActionNotifyIRBProtocol;
    }


	@Override
    protected void mergeProtocolSubmission(ProtocolBase amendment) {
        List<ProtocolSubmissionBase> submissions = deepCopy(amendment.getProtocolSubmissions());
        setNewSubmissionReferences(submissions);
        getProtocolVersionService().setExpeditedAndExemptCheckListReferences(submissions, this);
    }

    protected ProtocolVersionService getProtocolVersionService() {
        if(protocolVersionService == null) {
        	protocolVersionService = KcServiceLocator.getService(ProtocolVersionService.class);
        }
        return protocolVersionService;
    }
    
    public void setProtocolVersionService(ProtocolVersionService protocolVersionService) {
		this.protocolVersionService = protocolVersionService;
	}

    @Override
    public List<? extends DocumentCustomData> getCustomDataList() {
        return getProtocolDocument().getDocumentCustomData();
    }
}
