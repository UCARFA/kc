/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.core;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.api.sponsor.SponsorService;
import org.kuali.coeus.common.framework.compliance.core.SaveSpecialReviewEvent;
import org.kuali.coeus.common.framework.compliance.core.SaveSpecialReviewRule;
import org.kuali.coeus.common.framework.custom.SaveCustomDataEvent;
import org.kuali.coeus.common.framework.ruleengine.KcBusinessRulesEngine;
import org.kuali.coeus.common.framework.ynq.YnqGroupName;
import org.kuali.coeus.common.impl.custom.CustomDataRule;
import org.kuali.coeus.propdev.api.core.SubmissionInfoService;
import org.kuali.coeus.propdev.impl.abstrct.ProposalDevelopmentAbstractsRule;
import org.kuali.coeus.propdev.impl.attachment.*;
import org.kuali.coeus.propdev.impl.attachment.institute.*;
import org.kuali.coeus.propdev.impl.abstrct.AbstractsRule;
import org.kuali.coeus.propdev.impl.abstrct.ProposalAbstract;
import org.kuali.coeus.propdev.impl.basic.ProposalDevelopmentProposalRequiredFieldsAuditRule;
import org.kuali.coeus.propdev.impl.budget.ProposalBudgetService;
import org.kuali.coeus.propdev.impl.datavalidation.ProposalDevelopmentDataValidationConstants;
import org.kuali.coeus.propdev.impl.krms.ProposalDevelopmentKRMSAuditRule;
import org.kuali.coeus.propdev.impl.specialreview.ProposalSpecialReview;
import org.kuali.coeus.propdev.impl.sponsor.AddProposalSponsorAndProgramInformationRule;
import org.kuali.coeus.propdev.impl.sponsor.AddProposalSponsorAndProgramInformationRuleImpl;
import org.kuali.coeus.propdev.impl.sponsor.ProposalDevelopmentSponsorProgramInformationAuditRule;
import org.kuali.coeus.propdev.impl.budget.editable.BudgetDataOverrideEvent;
import org.kuali.coeus.propdev.impl.budget.editable.BudgetDataOverrideRule;
import org.kuali.coeus.propdev.impl.budget.editable.ProposalBudgetDataOverrideRule;
import org.kuali.coeus.propdev.impl.copy.CopyProposalRule;
import org.kuali.coeus.propdev.impl.copy.ProposalCopyCriteria;
import org.kuali.coeus.propdev.impl.copy.ProposalDevelopmentCopyRule;
import org.kuali.coeus.propdev.impl.custom.AuditProposalCustomDataEvent;
import org.kuali.coeus.propdev.impl.docperm.*;
import org.kuali.coeus.propdev.impl.editable.ProposalDataOverrideEvent;
import org.kuali.coeus.propdev.impl.editable.ProposalDataOverrideRule;
import org.kuali.coeus.propdev.impl.editable.ProposalDevelopmentDataOverrideRule;
import org.kuali.coeus.propdev.impl.keyword.PropScienceKeyword;
import org.kuali.coeus.propdev.impl.location.*;
import org.kuali.coeus.propdev.impl.person.KeyPersonnelAuditRule;
import org.kuali.coeus.propdev.impl.person.KeyPersonnelCertificationRule;
import org.kuali.coeus.propdev.impl.person.ProposalPerson;
import org.kuali.coeus.propdev.impl.person.attachment.*;
import org.kuali.coeus.propdev.impl.person.creditsplit.CalculateCreditSplitRule;
import org.kuali.coeus.propdev.impl.person.AddKeyPersonRule;
import org.kuali.coeus.propdev.impl.person.ChangeKeyPersonRule;
import org.kuali.coeus.propdev.impl.person.ProposalDevelopmentKeyPersonsRule;
import org.kuali.coeus.propdev.impl.person.SaveKeyPersonRule;
import org.kuali.coeus.propdev.impl.questionnaire.ProposalDevelopmentQuestionnaireAuditRule;
import org.kuali.coeus.propdev.impl.resubmit.ProposalDevelopmentResubmissionPromptRule;
import org.kuali.coeus.propdev.impl.resubmit.ResubmissionPromptRule;
import org.kuali.coeus.propdev.impl.resubmit.ResubmissionRuleEvent;
import org.kuali.coeus.propdev.impl.s2s.ProposalDevelopmentGrantsGovAuditRule;
import org.kuali.coeus.propdev.impl.s2s.question.ProposalDevelopmentS2sQuestionnaireAuditRule;
import org.kuali.coeus.propdev.impl.ynq.ProposalDevelopmentYnqAuditRule;
import org.kuali.coeus.propdev.impl.ynq.ProposalYnq;
import org.kuali.coeus.sys.framework.model.KcTransactionalDocumentBase;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.DateUtils;
import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.coeus.propdev.impl.hierarchy.ProposalHierarchyException;
import org.kuali.rice.core.api.util.RiceKeyConstants;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.kns.service.DataDictionaryService;
import org.kuali.rice.kns.service.KNSServiceLocator;
import org.kuali.rice.krad.util.AuditCluster;
import org.kuali.rice.krad.util.AuditError;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.bo.BusinessObject;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.DocumentAuditRule;
import org.kuali.rice.krad.rules.rule.event.ApproveDocumentEvent;
import org.kuali.rice.krad.util.MessageMap;

import static org.kuali.coeus.propdev.impl.core.ProposalDevelopmentConstants.PropDevParameterConstants.ENABLE_KEY_PERSON_VALIDATION_FOR_NON_EMPLOYEE_PERSONNEL;
import static org.kuali.kra.infrastructure.KeyConstants.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Main Business Rule class for <code>{@link ProposalDevelopmentDocument}</code>. Responsible for delegating rules to independent rule classes.
 *
 * @author Kuali Nervous System Team (kualidev@oncourse.iu.edu)
 */

public class ProposalDevelopmentDocumentRule extends KcTransactionalDocumentRuleBase implements AddCongressionalDistrictRule, AddKeyPersonRule, AddNarrativeRule, ReplaceNarrativeRule,
                                                                                                SaveNarrativesRule, AddInstituteAttachmentRule, ReplaceInstituteAttachmentRule,
                                                                                                AddPersonnelAttachmentRule, ReplacePersonnelAttachmentRule, AddProposalSiteRule, KcBusinessRule,
                                                                                                SaveProposalSitesRule, AbstractsRule, CopyProposalRule, ChangeKeyPersonRule,
                                                                                                DeleteCongressionalDistrictRule, PermissionsRule, NewNarrativeUserRightsRule,
                                                                                                SaveKeyPersonRule,CalculateCreditSplitRule, ProposalDataOverrideRule,
                                                                                                ResubmissionPromptRule, BudgetDataOverrideRule, AddProposalSponsorAndProgramInformationRule,
                                                                                                DocumentAuditRule {

    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(ProposalDevelopmentDocumentRule.class);
    private static final String PROPOSAL_QUESTIONS_KEY="proposalYnq[%d].%s";
    private static final String PROPOSAL_QUESTIONS_KEY_PROPERTY_ANSWER="answer";
    private static final String PROPOSAL_QUESTIONS_KEY_PROPERTY_REVIEW_DATE="reviewDate";
    private static final String PROPOSAL_QUESTIONS_KEY_PROPERTY_EXPLANATION="explanation";
    private static final String AWARD_NUMBER = "awardNumber";
    private static final String PROPOSAL_CURRENT_AWARD_NUMBER = "currentAwardNumber";

    private SponsorService sponsorService;
    private DataDictionaryService dataDictionaryService;
    private ProposalBudgetService budgetService;
    private SubmissionInfoService submissionInfoService;
    private ParameterService parameterService;
    private KcBusinessRulesEngine kcBusinessRulesEngine;

    @Override
    protected DataDictionaryService getDataDictionaryService (){
        if (dataDictionaryService == null)
            dataDictionaryService = KNSServiceLocator.getDataDictionaryService();
        return dataDictionaryService;
    }
    protected ProposalBudgetService getBudgetService (){
        if (budgetService ==null)
            budgetService = KcServiceLocator.getService(ProposalBudgetService.class);
        return budgetService;
    }

    protected SponsorService getSponsorService() {
        if (sponsorService ==null)
            sponsorService = KcServiceLocator.getService(SponsorService.class);
        return sponsorService;
    }
    protected SubmissionInfoService getSubmissionInfoService (){
        if (submissionInfoService == null)
            submissionInfoService = KcServiceLocator.getService(SubmissionInfoService.class);
        return submissionInfoService;
    }
    protected KcBusinessRulesEngine getKcBusinessRulesEngine (){
        if (kcBusinessRulesEngine == null)
        	kcBusinessRulesEngine = KcServiceLocator.getService(KcBusinessRulesEngine.class);
        return kcBusinessRulesEngine;
    }
    @Override
    protected boolean processCustomRouteDocumentBusinessRules(Document document) {
        boolean retval = true;

        retval &= super.processCustomRouteDocumentBusinessRules(document);
        retval &= new KeyPersonnelAuditRule().processRunAuditBusinessRules(document);
        retval &= new KeyPersonnelCertificationRule().processRouteDocument(document);

        return retval;
    }

    @Override
    protected boolean processCustomSaveDocumentBusinessRules(Document document) {
        if (!(document instanceof ProposalDevelopmentDocument)) {
            return false;
        }

        boolean valid = true;

        ProposalDevelopmentDocument proposalDevelopmentDocument = (ProposalDevelopmentDocument) document;

        if (!proposalDevelopmentDocument.isProposalDeleted()){
            GlobalVariables.getMessageMap().addToErrorPath("document.developmentProposal");
            valid &= processProposalRequiredFieldsBusinessRule(proposalDevelopmentDocument);

            valid &= processProposalYNQBusinessRule(proposalDevelopmentDocument, false);
            valid &= processProposalGrantsGovBusinessRule(proposalDevelopmentDocument);
            valid &= processSponsorProgramBusinessRule(proposalDevelopmentDocument);
            valid &= processKeywordBusinessRule(proposalDevelopmentDocument);
            valid &= proccessValidateSponsor(proposalDevelopmentDocument);
            valid &= processCustomDataRule(proposalDevelopmentDocument);
            valid &= processAttachmentRules(proposalDevelopmentDocument);
            valid &= processSaveSpecialReviewRule(proposalDevelopmentDocument);
            valid &= processCertificationRules(proposalDevelopmentDocument);

            GlobalVariables.getMessageMap().removeFromErrorPath("document.developmentProposal");
        }

        return valid;
    }

    protected boolean processCertificationRules(ProposalDevelopmentDocument proposalDevelopmentDocument) {
        final Boolean validationEnabled = getParameterService().getParameterValueAsBoolean(Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT, Constants.PARAMETER_COMPONENT_DOCUMENT,
                ENABLE_KEY_PERSON_VALIDATION_FOR_NON_EMPLOYEE_PERSONNEL);
        if(validationEnabled) {
            int personIndex = 0;
            KeyPersonnelCertificationRule certificationRule = new KeyPersonnelCertificationRule();
            for (ProposalPerson person : proposalDevelopmentDocument.getDevelopmentProposal().getProposalPersons()) {
                final String errorStarter = "document.developmentProposal.proposalPersons[";
                final String errorFinish = "].questionnaireHelper.answerHeaders[0].questions";
                String errorKey = errorStarter + personIndex + errorFinish;
                if (certificationRule.doesNonEmployeeHaveCertification(person)) {
                    GlobalVariables.getMessageMap().putWarning(errorKey, ERROR_PROPOSAL_PERSON_NONEMPLOYEE_CERTIFICATION_INCOMPLETE,
                            person.getFullName());
                }
                personIndex++;
            }
        }
        return true;
    }

    @Override
    protected boolean processCustomApproveDocumentBusinessRules(ApproveDocumentEvent approveEvent) {
        boolean retval = super.processCustomApproveDocumentBusinessRules(approveEvent);

        retval &= new KeyPersonnelCertificationRule().processApproveDocument(approveEvent);
        
        return retval;
    }
    
    private boolean proccessValidateSponsor(ProposalDevelopmentDocument proposalDevelopmentDocument) {
        boolean valid = true;
        DataDictionaryService dataDictionaryService = getDataDictionaryService();
        if (!this.getSponsorService().isValidSponsor(proposalDevelopmentDocument.getDevelopmentProposal().getSponsor())) {
            valid = false;
            GlobalVariables.getMessageMap().putError("sponsorCode", KeyConstants.ERROR_MISSING, dataDictionaryService.getAttributeErrorLabel(DevelopmentProposal.class, "sponsorCode"));
        }
        if (!StringUtils.isEmpty(proposalDevelopmentDocument.getDevelopmentProposal().getPrimeSponsorCode()) && 
                !this.getSponsorService().isValidSponsor(proposalDevelopmentDocument.getDevelopmentProposal().getPrimeSponsor())) {
            valid = false;
            GlobalVariables.getMessageMap().putError("primeSponsorCode", KeyConstants.ERROR_MISSING, dataDictionaryService.getAttributeErrorLabel(DevelopmentProposal.class, "primeSponsorCode"));
            
        }
        return valid;
    }

    @Override
    public boolean processAddCongressionalDistrictRules(AddProposalCongressionalDistrictEvent addCongressionalDistrictEvent) {
        return new ProposalDevelopmentCongressionalDistrictRule().processAddCongressionalDistrictRules(addCongressionalDistrictEvent);
    }

    @Override
    public boolean processDeleteCongressionalDistrictRules(DeleteProposalCongressionalDistrictEvent deleteCongressionalDistrictEvent) {
        return new ProposalDevelopmentCongressionalDistrictRule().processDeleteCongressionalDistrictRules(deleteCongressionalDistrictEvent);
    }

    /**
    *
    * Validate proposal questions rule. validate explanation required and date required fields based on 
    * question configuration. Answers are mandatory for routing
    */
    public boolean processProposalYNQBusinessRule(ProposalDevelopmentDocument proposalDevelopmentDocument, boolean docRouting) {
        boolean valid = true;
        
        for( int j = 0; j < proposalDevelopmentDocument.getDevelopmentProposal().getProposalYnqs().size();j++) {
            ProposalYnq proposalYnq = proposalDevelopmentDocument.getDevelopmentProposal().getProposalYnqs().get(j);

            String groupName = proposalYnq.getYnq().getGroupName();
            HashMap<String,Integer> questionSerial = getQuestionSerialNumberBasedOnGroup( proposalDevelopmentDocument );

            String ynqAnswer = proposalYnq.getAnswer();
            /* look for answers - required for routing */
            if(docRouting && StringUtils.isBlank(proposalYnq.getAnswer())) {
                LOG.info("no answer");
                valid = false;
                
                reportError(String.format(PROPOSAL_QUESTIONS_KEY,j,PROPOSAL_QUESTIONS_KEY_PROPERTY_ANSWER), KeyConstants.ERROR_REQUIRED_ANSWER, questionSerial.get(proposalYnq.getQuestionId()).toString(),groupName);
            }
            /* look for date requried */
            String dateRequiredFor = proposalYnq.getYnq().getDateRequiredFor();
            if(dateRequiredFor != null) {
                if (StringUtils.isNotBlank(ynqAnswer) && 
                        dateRequiredFor.contains(ynqAnswer) && 
                        proposalYnq.getReviewDate() == null) {
                    LOG.info("No review date");
                    valid = false;
                    reportError(String.format(PROPOSAL_QUESTIONS_KEY,j,PROPOSAL_QUESTIONS_KEY_PROPERTY_REVIEW_DATE), KeyConstants.ERROR_REQUIRED_FOR_REVIEW_DATE,  questionSerial.get(proposalYnq.getQuestionId()).toString(),groupName);
     
                }
            }

            /* look for explanation requried */
            String explanationRequiredFor = proposalYnq.getYnq().getExplanationRequiredFor();
            if(explanationRequiredFor != null) {
                if (StringUtils.isNotBlank(ynqAnswer) && 
                    explanationRequiredFor.contains(ynqAnswer) && 
                    StringUtils.isBlank(proposalYnq.getExplanation())) {
                    LOG.info("No explanation date");
                    valid = false;
                    reportError(String.format(PROPOSAL_QUESTIONS_KEY,j,PROPOSAL_QUESTIONS_KEY_PROPERTY_EXPLANATION),  KeyConstants.ERROR_REQUIRED_FOR_EXPLANATION,  questionSerial.get(proposalYnq.getQuestionId()).toString(),groupName);
                }
            }
        }
        
        return valid;
    }
    
    
    public static HashMap<String,Integer> getQuestionSerialNumberBasedOnGroup(ProposalDevelopmentDocument proposalDevelopmentDocument) {
        HashMap<String,Integer> ynqGroupSerial = new HashMap<>();
        for (YnqGroupName ynqGroupName : proposalDevelopmentDocument.getDevelopmentProposal().getYnqGroupNames()) {
            Integer serialNumber = 1;
            for (ProposalYnq proposalYnq : proposalDevelopmentDocument.getDevelopmentProposal().getProposalYnqs()) {
                if(ynqGroupName.getGroupName().equalsIgnoreCase(proposalYnq.getYnq().getGroupName())) {
                    ynqGroupSerial.put(proposalYnq.getQuestionId(), serialNumber);
                    serialNumber ++;
                }
            }
        }
        return ynqGroupSerial;
    }
    
    
    
    /**
     * This method validates Required Fields related fields on
     * the Proposal Development Document.
     * @param proposalDevelopmentDocument document to validate
     * @return boolean whether the validation passed or not
     */
    private boolean processProposalRequiredFieldsBusinessRule(ProposalDevelopmentDocument proposalDevelopmentDocument) {
        boolean valid = true;

        MessageMap errorMap = GlobalVariables.getMessageMap();
        DataDictionaryService dataDictionaryService = getDataDictionaryService();

        //if either is missing, it should be caught on the DD validation.
        if (proposalDevelopmentDocument.getDevelopmentProposal().getRequestedStartDateInitial() != null
                && proposalDevelopmentDocument.getDevelopmentProposal().getRequestedEndDateInitial() != null) {
            if (proposalDevelopmentDocument.getDevelopmentProposal().getRequestedStartDateInitial().after(
                    proposalDevelopmentDocument.getDevelopmentProposal().getRequestedEndDateInitial())) {
                valid = false;
                errorMap.putError("requestedStartDateInitial", KeyConstants.ERROR_START_DATE_AFTER_END_DATE,
                                dataDictionaryService.getAttributeErrorLabel(DevelopmentProposal.class,
                                        "requestedStartDateInitial"),
                                dataDictionaryService.getAttributeErrorLabel(DevelopmentProposal.class,
                                        "requestedEndDateInitial"));
            }
        }
        
        if (StringUtils.isNotBlank(proposalDevelopmentDocument.getDevelopmentProposal().getCurrentAwardNumber())) {
            HashMap<String,String> criteria = new HashMap<>();
            criteria.put(AWARD_NUMBER,proposalDevelopmentDocument.getDevelopmentProposal().getCurrentAwardNumber());
            if (getBusinessObjectService().countMatching(Award.class, criteria) < 1) {
                valid = false;
                errorMap.putError(PROPOSAL_CURRENT_AWARD_NUMBER, KeyConstants.ERROR_MISSING,
                        dataDictionaryService.getAttributeErrorLabel(DevelopmentProposal.class, PROPOSAL_CURRENT_AWARD_NUMBER));
            }
        }
        
        if (StringUtils.isNotBlank(proposalDevelopmentDocument.getDevelopmentProposal().getContinuedFrom())) {
            if (getSubmissionInfoService().getProposalContinuedFromVersionProposalId(proposalDevelopmentDocument.getDevelopmentProposal().getContinuedFrom()) == null) {
                valid = false;
                errorMap.putError("continuedFrom", KeyConstants.ERROR_MISSING, 
                        dataDictionaryService.getAttributeErrorLabel(DevelopmentProposal.class, "continuedFrom"));                
            }
        }
        
        return valid;
    }

    /**
    * Validate Grants.gov business rules.
    */
    private boolean processProposalGrantsGovBusinessRule(ProposalDevelopmentDocument proposalDevelopmentDocument) {
        boolean valid = true;

        if (proposalDevelopmentDocument.getDevelopmentProposal().getS2sOpportunity() != null
                && proposalDevelopmentDocument.getDevelopmentProposal().getS2sOpportunity().getOpportunityId() != null
                && StringUtils.equalsIgnoreCase(proposalDevelopmentDocument.getDevelopmentProposal().getS2sOpportunity().getRevisionCode(),
                        this.getS2sRevisionTypeOther())
                && (proposalDevelopmentDocument.getDevelopmentProposal().getS2sOpportunity().getRevisionOtherDescription() == null || StringUtils
                        .equals(proposalDevelopmentDocument.getDevelopmentProposal().getS2sOpportunity().getRevisionOtherDescription().trim(),
                                ""))) {
            reportError("s2sOpportunity.revisionOtherDescription", KeyConstants.ERROR_IF_REVISIONTYPE_IS_OTHER);
            valid &= false;
        }
        
        if (proposalDevelopmentDocument.getDevelopmentProposal().getS2sOpportunity() != null
                && proposalDevelopmentDocument.getDevelopmentProposal().getS2sOpportunity().getOpportunityId() != null
                && !StringUtils.equalsIgnoreCase(proposalDevelopmentDocument.getDevelopmentProposal().getS2sOpportunity().getRevisionCode(),
                        this.getS2sRevisionTypeOther())
                && (proposalDevelopmentDocument.getDevelopmentProposal().getS2sOpportunity().getRevisionOtherDescription() != null && !StringUtils
                        .equals(proposalDevelopmentDocument.getDevelopmentProposal().getS2sOpportunity().getRevisionOtherDescription().trim(),
                                ""))) {
            reportError("s2sOpportunity.revisionOtherDescription",
                    KeyConstants.ERROR_IF_REVISIONTYPE_IS_NOT_OTHER_SPECIFY_NOT_BLANK);
            valid &= false;
        }        
        return valid;
    }
    
    /**
     * Gets the S2s Revision Type Other parameter
     * @return the parameter
     */
    private String getS2sRevisionTypeOther() {
        return this.getParameterService().getParameterValueAsString(ProposalDevelopmentDocument.class, KeyConstants.S2S_REVISIONTYPE_OTHER);
    }

    @Override
    public boolean processAddKeyPersonBusinessRules(ProposalDevelopmentDocument document, ProposalPerson person) {
        return new ProposalDevelopmentKeyPersonsRule().processAddKeyPersonBusinessRules(document, person);
    }

    /**
     * Regex validation for CFDA number(7 digits with a period in the 3rd character and an optional alpha character in the 7th field).
    */
    private boolean processSponsorProgramBusinessRule(ProposalDevelopmentDocument proposalDevelopmentDocument) {
        
        boolean valid = true;
        MessageMap errorMap = GlobalVariables.getMessageMap();DataDictionaryService dataDictionaryService = getDataDictionaryService();
 
        SponsorService sponsorService = getSponsorService();
         String sponsorCode = proposalDevelopmentDocument.getDevelopmentProposal().getPrimeSponsorCode();
   
         if (sponsorCode != null)
         {
             String sponsorName = sponsorService.getSponsorName(sponsorCode);
             if (sponsorName == null)
             {
                 errorMap.putError("developmentProposalList[0].primeSponsorCode", RiceKeyConstants.ERROR_EXISTENCE,
                         dataDictionaryService.getAttributeLabel(DevelopmentProposal.class, "primeSponsorCode") );
                 valid = false;
             }
         }
         if (proposalDevelopmentDocument.getDevelopmentProposal().getDeadlineTime() != null) {

            
             String deadLineTime = DateUtils.formatFrom12Or24Str(proposalDevelopmentDocument.getDevelopmentProposal().getDeadlineTime());
             if (!deadLineTime.equalsIgnoreCase(Constants.INVALID_TIME)) {
                 proposalDevelopmentDocument.getDevelopmentProposal().setDeadlineTime(deadLineTime);
             } else {
                 errorMap.putError("deadlineTime", KeyConstants.INVALID_DEADLINE_TIME, 
                         dataDictionaryService.getAttributeErrorLabel(DevelopmentProposal.class, "deadlineTime"));
                 valid = false;
             }
         }
        return valid;
    }
    
    private boolean processKeywordBusinessRule(ProposalDevelopmentDocument document) {
        List<PropScienceKeyword> keywords = document.getDevelopmentProposal().getPropScienceKeywords();
        
        for ( PropScienceKeyword keyword : keywords ) {
            for ( PropScienceKeyword keyword2 : keywords ) {
                if (keyword != keyword2 && StringUtils.equalsIgnoreCase(keyword.getScienceKeyword().getCode(), keyword2.getScienceKeyword().getCode())) {
                    GlobalVariables.getMessageMap().putError("propScienceKeyword", "error.proposalKeywords.duplicate");
                    return false;
                }
            }
        }
        return true;
    }
   
    public boolean processSaveSpecialReviewRule(ProposalDevelopmentDocument document){
        List<ProposalSpecialReview> specialReviews = document.getDevelopmentProposal().getPropSpecialReviews();
        boolean isIrbProtocolLinkingEnabled = getParameterService().getParameterValueAsBoolean(Constants.MODULE_NAMESPACE_IRB, Constants.PARAMETER_COMPONENT_DOCUMENT, Constants.PROTOCOL_DEVELOPMENT_PROPOSAL_LINKING_ENABLED_PARAMETER);
        boolean isIacucProtocolLinkingEnabled = getParameterService().getParameterValueAsBoolean(Constants.MODULE_NAMESPACE_IACUC, Constants.PARAMETER_COMPONENT_DOCUMENT, Constants.IACUC_PROTOCOL_PROPOSAL_DEVELOPMENT_LINKING_ENABLED_PARAMETER);
        return new SaveSpecialReviewRule<ProposalSpecialReview>().processRules(new SaveSpecialReviewEvent<>("propSpecialReviews",document,specialReviews,isIrbProtocolLinkingEnabled,isIacucProtocolLinkingEnabled));
    }

    @Override
    public boolean processAddNarrativeBusinessRules(AddNarrativeEvent addNarrativeEvent) {
        return new ProposalDevelopmentNarrativeRule().processAddNarrativeBusinessRules(addNarrativeEvent);
    }

    @Override
    public boolean processRunAuditBusinessRules(Document document){
        if (((ProposalDevelopmentDocument)document).getDevelopmentProposal().isChild()) {
            throw new RuntimeException(new ProposalHierarchyException("Cannot run validation on a Proposal Hierarchy Child."));
        }
        boolean retval = true;

        retval &= processAttachmentAuditRules((ProposalDevelopmentDocument)document);

        retval &= new CustomDataRule().processRules(new AuditProposalCustomDataEvent((KcTransactionalDocumentBase)document));
        
        retval &= new ProposalDevelopmentProposalRequiredFieldsAuditRule().processRunAuditBusinessRules(document);
        
        retval &= new ProposalDevelopmentSponsorProgramInformationAuditRule().processRunAuditBusinessRules(document);
        
        retval &= new KeyPersonnelAuditRule().processRunAuditBusinessRules(document);
        
        retval &= new KeyPersonnelCertificationRule().processRunAuditBusinessRules(document);
        //audit for Proposal Attachments to ensure status code is set to complete.
        retval &= new ProposalDevelopmentProposalAttachmentsAuditRule().processRunAuditBusinessRules(document);
        
        //Change for KRACOEUS-1403
        ProposalDevelopmentDocument proposalDevelopmentDocument = (ProposalDevelopmentDocument) document;
        proposalDevelopmentDocument.getDevelopmentProposal().getYnqService().populateProposalQuestions(
                proposalDevelopmentDocument.getDevelopmentProposal().getProposalYnqs(),
                proposalDevelopmentDocument.getDevelopmentProposal().getYnqGroupNames(), proposalDevelopmentDocument);
        
        retval &= new ProposalDevelopmentYnqAuditRule().processRunAuditBusinessRules(document);

        retval &= new ProposalDevelopmentGrantsGovAuditRule().processRunAuditBusinessRules(document);
        
        retval &= new ProposalDevelopmentS2sQuestionnaireAuditRule().processRunAuditBusinessRules(proposalDevelopmentDocument);
        retval &= new ProposalDevelopmentQuestionnaireAuditRule().processRunAuditBusinessRules(proposalDevelopmentDocument);
        
        // audit check for budgetversion with final status
        retval &= processRunAuditBudgetVersionRule(proposalDevelopmentDocument.getDevelopmentProposal());
        retval &= new ProposalDevelopmentKRMSAuditRule().processRunAuditBusinessRules(proposalDevelopmentDocument);
       
        return retval;
    }
    
    public boolean processRunAuditBudgetVersionRule(DevelopmentProposal proposal) {
        // audit check for budgetversion with final status
        boolean retval = true;
        
        List<AuditError> auditErrors = new ArrayList<>();
        List<AuditError> auditWarnings = new ArrayList<>();
        String budgetStatusCompleteCode = getParameterService().getParameterValueAsString(
                Budget.class, Constants.BUDGET_STATUS_COMPLETE_CODE);
        boolean budgetVersionsExists = !proposal.getBudgets().isEmpty();
        if(!budgetVersionsExists) {
        	AuditError noBudgetWarning = new AuditError(ProposalDevelopmentDataValidationConstants.BUDGET_PAGE_ID, KeyConstants.AUDIT_WARNING_PROPOSAL_WITHNO_BUDGET, ProposalDevelopmentDataValidationConstants.BUDGET_PAGE_ID, new String[] { proposal.getProposalNumber() });
        	auditWarnings.add(noBudgetWarning);
        	retval = false;
        } else if (proposal.getFinalBudget() == null && budgetVersionsExists) {
        	auditErrors.add(new AuditError("document.developmentProposal.budgets", KeyConstants.AUDIT_ERROR_NO_BUDGETVERSION_FINAL, ProposalDevelopmentDataValidationConstants.BUDGET_PAGE_ID));
        	retval = false;
        } else if (proposal.getFinalBudget() != null &&
        		!StringUtils.equals(budgetStatusCompleteCode, proposal.getFinalBudget().getBudgetStatus())) {
            auditErrors.add(new AuditError("document.developmentProposal.budgets", KeyConstants.AUDIT_ERROR_NO_BUDGETVERSION_COMPLETE_AND_FINAL, ProposalDevelopmentDataValidationConstants.BUDGET_PAGE_ID));
            retval = false;
        } else if (proposal.getFinalBudget() != null && (proposal.getFinalBudget().getStartDate().before(proposal.getRequestedStartDateInitial()) ||
        		proposal.getFinalBudget().getEndDate().after(proposal.getRequestedEndDateInitial()) ||
                proposal.getFinalBudget().getSummaryPeriodStartDate().before(proposal.getRequestedStartDateInitial()) ||
                proposal.getFinalBudget().getSummaryPeriodEndDate().after(proposal.getRequestedEndDateInitial()))) {
        	auditErrors.add(new AuditError("document.developmentProposal.budgets", KeyConstants.ERROR_BUDGET_DATES_NOT_MATCH_PROPOSAL_DATES, ProposalDevelopmentDataValidationConstants.BUDGET_PAGE_ID));
            retval = false;
        }
        if (auditErrors.size() > 0) {
            GlobalVariables.getAuditErrorMap().put("budgetVersionErrors", new AuditCluster(ProposalDevelopmentDataValidationConstants.BUDGET_PAGE_NAME, auditErrors, ProposalDevelopmentDataValidationConstants.AUDIT_ERRORS));
        }

        if (auditWarnings.size() > 0) {
            GlobalVariables.getAuditErrorMap().put("budgetVersionWarnings", new AuditCluster(ProposalDevelopmentDataValidationConstants.BUDGET_PAGE_NAME, auditWarnings, ProposalDevelopmentDataValidationConstants.AUDIT_WARNINGS));
        }
        return retval;
    }

    public boolean processAttachmentRules(ProposalDevelopmentDocument document) {
        boolean retVal = true;
        int index= 0;
        for (Narrative narrative : document.getDevelopmentProposal().getNarratives()) {
            retVal &= processSaveNarrativesBusinessRules(new SaveNarrativesEvent("document.developmentProposal.narratives["+index+"]",document,narrative,document.getDevelopmentProposal().getNarratives()));
            index++;
        }
        return retVal;
    }

    public boolean processAttachmentAuditRules(ProposalDevelopmentDocument document){
        boolean retVal = true;
        int index = 0;
        for (ProposalPersonBiography biography : document.getDevelopmentProposal().getPropPersonBios()){
           retVal &= processSavePersonnelAttachmentBusinessRules(new SavePersonnelAttachmentEvent(String.valueOf(index),document,biography));
            index++;
        }
        return retVal;
    }

    @Override
    public boolean processAddAbstractBusinessRules(ProposalDevelopmentDocument document, ProposalAbstract proposalAbstract) {
        return new ProposalDevelopmentAbstractsRule().processAddAbstractBusinessRules(document, proposalAbstract);
    }

    @Override
    public boolean processSaveNarrativesBusinessRules(SaveNarrativesEvent saveNarrativesEvent) {
        return new ProposalDevelopmentNarrativeRule().processSaveNarrativesBusinessRules(saveNarrativesEvent);
    }

    @Override
    public boolean processReplaceNarrativeBusinessRules(ReplaceNarrativeEvent replaceNarrativeEvent) {
        return new ProposalDevelopmentNarrativeRule().processReplaceNarrativeBusinessRules(replaceNarrativeEvent);
    }

    @Override
    public boolean processCopyProposalBusinessRules(ProposalDevelopmentDocument document, ProposalCopyCriteria criteria) {
        return new ProposalDevelopmentCopyRule().processCopyProposalBusinessRules(document, criteria);
    }

    @Override
    public boolean processAddInstituteAttachmentBusinessRules(AddInstituteAttachmentEvent addInstituteAttachmentEvent) {
        return new ProposalDevelopmentInstituteAttachmentRule().processAddInstituteAttachmentBusinessRules(addInstituteAttachmentEvent);
    }

    @Override
    public boolean processReplaceInstituteAttachmentBusinessRules(ReplaceInstituteAttachmentEvent event) {
        return new ProposalDevelopmentInstituteAttachmentRule().processReplaceInstituteAttachmentBusinessRules(event);
    }

    @Override
    public boolean processAddPersonnelAttachmentBusinessRules(AddPersonnelAttachmentEvent addPersonnelAttachmentEvent) {
        return new ProposalDevelopmentPersonnelAttachmentRule().processAddPersonnelAttachmentBusinessRules(addPersonnelAttachmentEvent);
    }

    public boolean processSavePersonnelAttachmentBusinessRules(SavePersonnelAttachmentEvent savePersonnelAttachmentEvent) {
        return new ProposalDevelopmentPersonnelAttachmentRule().processSavePersonnelAttachmentBusinessRules(savePersonnelAttachmentEvent);
    }

    @Override
    public boolean processReplacePersonnelAttachmentBusinessRules(ReplacePersonnelAttachmentEvent event) {
        return new ProposalDevelopmentPersonnelAttachmentRule().processReplacePersonnelAttachmentBusinessRules(event);
    }
    
    /**
     * Delegating method for the <code>{@link ChangeKeyPersonRule}</code> which is triggered by the <code>{@link org.kuali.coeus.propdev.impl.person.ChangeKeyPersonEvent}</code>
     * 
     */
    @Override
    public boolean processChangeKeyPersonBusinessRules(ProposalPerson proposalPerson, BusinessObject source,int index) {
        return new ProposalDevelopmentKeyPersonsRule().processChangeKeyPersonBusinessRules(proposalPerson, source, index);
    }

    @Override
    public boolean processAddProposalSiteBusinessRules(AddProposalSiteEvent addProposalLocationEvent) {
        return new ProposalDevelopmentProposalLocationRule().processAddProposalSiteBusinessRules(addProposalLocationEvent);    
    }

    @Override
    public boolean processSaveProposalSiteBusinessRules(SaveProposalSitesEvent saveProposalSitesEvent) {
        return new ProposalDevelopmentProposalLocationRule().processSaveProposalSiteBusinessRules(saveProposalSitesEvent);    
    }
    
    @Override
    public boolean processAddProposalUserBusinessRules(ProposalDevelopmentDocument document,List<ProposalUserRoles> list, ProposalUserRoles proposalUser) {
        return new ProposalDevelopmentPermissionsRule().processAddProposalUserBusinessRules(document, list, proposalUser);
    }
    
    @Override
    public boolean processDeleteProposalUserBusinessRules(ProposalDevelopmentDocument document,List<ProposalUserRoles> list, int index) {
        return new ProposalDevelopmentPermissionsRule().processDeleteProposalUserBusinessRules(document, list, index);
    }
    
    @Override
    public boolean processEditProposalUserRolesBusinessRules(ProposalDevelopmentDocument document, List<ProposalUserRoles> list, ProposalUserRoles editRoles) {
        return new ProposalDevelopmentPermissionsRule().processEditProposalUserRolesBusinessRules(document, list, editRoles);
    }

    
    /**
     * Delegate to {@link org.kuali.coeus.propdev.impl.person.ProposalDevelopmentKeyPersonsRule#processSaveKeyPersonBusinessRules(ProposalDevelopmentDocument)
     * 
     */
    @Override
    public boolean processSaveKeyPersonBusinessRules(ProposalDevelopmentDocument document) {
        LOG.info("In processSaveKeyPersonBusinessRules()");
        return new ProposalDevelopmentKeyPersonsRule().processCustomSaveDocumentBusinessRules(document);
    }

    @Override
    public boolean processNewNarrativeUserRightsBusinessRules(ProposalDevelopmentDocument document,
            List<NarrativeUserRights> newNarrativeUserRights, int narrativeIndex) {
        return new ProposalDevelopmentNarrativeRule().processNewNarrativeUserRightsBusinessRules(document, newNarrativeUserRights, narrativeIndex);
    }

    @Override
    public boolean processCalculateCreditSplitBusinessRules(ProposalDevelopmentDocument document) {
        return new ProposalDevelopmentKeyPersonsRule().processCalculateCreditSplitBusinessRules(document);
    }

    @Override
    public boolean processProposalDataOverrideRules(ProposalDataOverrideEvent proposalDataOverrideEvent) {
        return new ProposalDevelopmentDataOverrideRule().processProposalDataOverrideRules(proposalDataOverrideEvent);
    }

    @Override
    public boolean processBudgetDataOverrideRules(BudgetDataOverrideEvent budgetDataOverrideEvent) {
        return new ProposalBudgetDataOverrideRule().processBudgetDataOverrideRules(budgetDataOverrideEvent);
    }

    @Override
    public boolean processResubmissionPromptBusinessRules(ResubmissionRuleEvent resubmissionRuleEvent) {
        return new ProposalDevelopmentResubmissionPromptRule().processResubmissionPromptBusinessRules(resubmissionRuleEvent);
    }

    public boolean processCustomDataRule(ProposalDevelopmentDocument document) {
        return new CustomDataRule().processRules(new SaveCustomDataEvent(document));
    }

    @Override
    public boolean processRules(KcDocumentEventBaseExtension event) {
        return event.getRule().processRules(event);
    }


	public ParameterService getParameterService() {
		if (parameterService == null) {
			parameterService = KcServiceLocator.getService(ParameterService.class);
		}
		return parameterService;
	}
	public void setParameterService(ParameterService parameterService) {
		this.parameterService = parameterService;
	}

    @Override
    public boolean processAddProposalSponsorAndProgramInformationRules(ProposalDevelopmentDocument proposalDevelopmentDocument) {
        return new AddProposalSponsorAndProgramInformationRuleImpl().processAddProposalSponsorAndProgramInformationRules(proposalDevelopmentDocument);
    }
}
