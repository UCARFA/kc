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
package edu.ucar.fanda.kuali.kra.award;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.award.AwardDateRulesHelper;
import org.kuali.kra.award.AwardDocumentRule;
import edu.ucar.fanda.kuali.kra.award.detailsdates.UcarAwardDetailsAndDatesRuleImpl;
import org.kuali.kra.award.commitments.*;
import org.kuali.kra.award.contacts.AwardProjectPersonsSaveRuleImpl;
import org.kuali.kra.award.contacts.SaveAwardProjectPersonsRuleEvent;
import org.kuali.kra.award.detailsdates.AwardDetailsAndDatesSaveEvent;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.keywords.AwardScienceKeyword;
import org.kuali.kra.award.notesandattachments.attachments.AwardAttachment;
import org.kuali.kra.award.paymentreports.paymentschedule.AddAwardPaymentScheduleRuleEvent;
import org.kuali.kra.award.paymentreports.paymentschedule.AwardPaymentScheduleRuleImpl;
import org.kuali.kra.award.paymentreports.specialapproval.approvedequipment.AwardApprovedEquipmentRuleEvent;
import org.kuali.kra.award.paymentreports.specialapproval.approvedequipment.AwardApprovedEquipmentRuleImpl;
import org.kuali.kra.award.paymentreports.specialapproval.approvedequipment.EquipmentCapitalizationMinimumLoader;
import org.kuali.kra.award.paymentreports.specialapproval.foreigntravel.AwardApprovedForeignTravelRule;
import org.kuali.kra.award.paymentreports.specialapproval.foreigntravel.AwardApprovedForeignTravelRuleEvent;
import org.kuali.kra.award.paymentreports.specialapproval.foreigntravel.AwardApprovedForeignTravelRuleImpl;
import org.kuali.kra.award.rule.event.AwardCommentsRuleEvent;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.timeandmoney.TimeAndMoneyForm;
import org.kuali.kra.timeandmoney.rule.event.TimeAndMoneyAwardDateSaveEvent;
import org.kuali.kra.timeandmoney.rules.TimeAndMoneyAwardDateSaveRuleImpl;
import org.kuali.rice.coreservice.framework.parameter.ParameterConstants;
import org.kuali.rice.kns.util.KNSGlobalVariables;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.MessageMap;

import edu.ucar.fanda.kuali.kra.infrastructure.UcarKeyConstants;

import java.sql.Date;
import java.util.List;


/**
 * Main Business Rule class for <code>{@link AwardDocument}</code>. 
 * Responsible for delegating rules to independent rule classes.
 * ADD UCAR custom validation Rules
 *
 */
public class UcarAwardDocumentRule extends AwardDocumentRule implements UcarAwardRule{

	// NOTE: Properties to validate on awardAmountInfos 
    private static final String OBLIGATED_AMOUNT_PROPERTY_NAME = "awardAmountInfos[0].amountObligatedToDate";
    private static final String ANTICIPATED_AMOUNT_PROPERTY_NAME = "awardAmountInfos[0].anticipatedTotalAmount";
    private static final String AWARD_EFFECTIVE_DATE_PROPERTY_NAME = "awardAmountInfos[0].currentFundEffectiveDate";
    private static final String OBLIGATION_EXPIRATION_DATE_PROPERTY_NAME = "awardAmountInfos[0].obligationExpirationDate";
    // NOTE: Properties to validate on award
    private static final String AWARD_ACCOUNT_NUMBER_PROPERTY_NAME = "accountNumber";
    private static final String AWARD_FIN_CHART_OF_ACCOUNTS_CODE_PROPERTY_NAME = "financialChartOfAccountsCode";
	// ADD OTHER PROPERTIES TO VALIDATE AS NEEDED
    // Logger
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(UcarAwardDocumentRule.class);

	private static final String AWARD_ERROR_PATH_PREFIX = "document.awardList[0].";

    /**
	 * Function to execute UCAR Custom rules  - Award Details and Dates Save Rules
	 * @param document
	 * @return
	 */
	 private boolean processUcarAwardDetailsAndDatesSaveRules(Document document) {
	        boolean valid = true;
	        MessageMap errorMap = GlobalVariables.getMessageMap();
	        AwardDocument awardDocument = (AwardDocument) document;
	        errorMap.addToErrorPath(DOCUMENT_ERROR_PATH);
	        errorMap.addToErrorPath(AWARD_ERROR_PATH);
	        AwardDetailsAndDatesSaveEvent event = new AwardDetailsAndDatesSaveEvent(awardDocument, awardDocument.getAward());
	        // run the rule
//	        valid &= processUcarSaveActicipatedTotalValid(event);
	        // add additional rules to run here
	        // valid &= processUcarNewRule(event)
		 valid &= new UcarAwardDetailsAndDatesRuleImpl().processSaveAwardDetailsAndDates(event);

		 errorMap.removeFromErrorPath(AWARD_ERROR_PATH);
	        errorMap.removeFromErrorPath(DOCUMENT_ERROR_PATH);




	        return valid;
	    }
	 
	 @Override
	 /**
	  * UCAR Save Award Details and Dates Business Rule
	  * RULE # 1
	  * NOTE: To add additional rules, add them to UcarAwardRule and add an override to
	  * this class.  You also need to add a function to call the new rule, example is
	  * processUcarAwardDetailsAndDatesSaveRules above.
	  */
		public boolean processUcarSaveActicipatedTotalValid(AwardDetailsAndDatesSaveEvent awardDetailsAndDatesSaveEvent) {
		 // start with validation result set to true
		 boolean valid = true;
	        Award award = awardDetailsAndDatesSaveEvent.getAward();
	        // INVALID ACCOUNT NUMBER
	        if(award.getAccountNumber() != null && 
	        		award.getAccountNumber().equalsIgnoreCase("TEST")) {
	            valid = false;
	            reportError(AWARD_ACCOUNT_NUMBER_PROPERTY_NAME, UcarKeyConstants.ERROR_INVALID_ACCOUNT_NUMBER);
	        }
	        // return result
	        return valid;
		}

	@Override
	/**
	 * Method called by the framework to validate Award Document on Save
	 * NOTE:  Add custom validation rules here!
	 */
	protected boolean processCustomSaveDocumentBusinessRules(Document document) {
		// call all Kuali Research rules for Award, commented out by Susan for now 8-22-2017
//		LOG.info("Starting UCAR custom save business rules");
		if(skipRuleProcessing(document)) {
			return true;
		}

		boolean retval = true;
		MessageMap errorMap = GlobalVariables.getMessageMap();
		if (!(document instanceof AwardDocument)) {
			return false;
		}

		AwardDocument awardDocument = (AwardDocument) document;

		retval &= processUnitNumberBusinessRule(errorMap, awardDocument);
		retval &= processCostShareBusinessRules(document);
		retval &= processBenefitsRatesBusinessRules(document);
		retval &= processApprovedSubawardBusinessRules(document);
		retval &= processApprovedEquipmentBusinessRules(errorMap, awardDocument);
		retval &= processApprovedForeignTravelBusinessRules(errorMap, awardDocument);
		retval &= processSaveAwardProjectPersonsBusinessRules(errorMap, awardDocument);
		retval &= processAwardCommentsBusinessRules(awardDocument);
//		retval &= processAwardDetailsAndDatesSaveRules(document);
		retval &= processDateBusinessRule(errorMap, awardDocument);
		retval &=processKeywordBusinessRule(awardDocument);
		retval &=processAwardAttachmentBusinessRule(awardDocument);
		retval &= processUcarAwardDetailsAndDatesSaveRules(document);
	       
	        
//	        LOG.info("UCAR custom save business rules return value: " + retVal );
		
		return retval;
	}
	

	@Override
	public boolean processSaveAwardDetailsAndDates(AwardDetailsAndDatesSaveEvent awardDetailsAndDatesSaveEvent) {
		return new UcarAwardDetailsAndDatesRuleImpl().processSaveAwardDetailsAndDates(awardDetailsAndDatesSaveEvent);
	}
	private boolean skipRuleProcessing(Document document) {
		return AwardDocument.PLACEHOLDER_DOC_DESCRIPTION.equals(document.getDocumentHeader().getDocumentDescription());
	}

	private boolean processApprovedEquipmentBusinessRules(MessageMap errorMap, AwardDocument awardDocument) {
		boolean success = true;
		errorMap.addToErrorPath(DOCUMENT_ERROR_PATH);
		errorMap.addToErrorPath(AWARD_ERROR_PATH);
		Award award = awardDocument.getAward();
		EquipmentCapitalizationMinimumLoader helper = new EquipmentCapitalizationMinimumLoader();
		AwardApprovedEquipmentRuleImpl rule = new AwardApprovedEquipmentRuleImpl();
		if (award.getApprovedEquipmentItems() != null) {
			int count = award.getApprovedEquipmentItems().size();
			for (int i = 0; i < count; i++) {
				String errorPath = String.format("approvedEquipmentItems[%d]", i);
				errorMap.addToErrorPath(errorPath);
				String errorKey = AWARD_ERROR_PATH_PREFIX + errorPath;
				AwardApprovedEquipmentRuleEvent event = new AwardApprovedEquipmentRuleEvent(errorKey, awardDocument, awardDocument.getAward(),
						award.getApprovedEquipmentItems().get(i),
						helper.getMinimumCapitalization());
				success &= rule.processAwardApprovedEquipmentBusinessRules(event);
				errorMap.removeFromErrorPath(errorPath);
			}
		}
		errorMap.removeFromErrorPath(AWARD_ERROR_PATH);
		errorMap.removeFromErrorPath(DOCUMENT_ERROR_PATH);

		return success;
	}

	private boolean processPaymentScheduleBusinessRules(MessageMap errorMap, AwardDocument awardDocument) {
		errorMap.addToErrorPath(DOCUMENT_ERROR_PATH);
		errorMap.addToErrorPath(AWARD_ERROR_PATH);

		boolean success = true;
		errorMap.removeFromErrorPath(AWARD_ERROR_PATH);
		errorMap.removeFromErrorPath(DOCUMENT_ERROR_PATH);
		return success;
	}

	private boolean processAwardAttachmentBusinessRule(AwardDocument awardDocument) {
		boolean valid=true;
		List<AwardAttachment> awardAttachments= awardDocument.getAwardList().get(0).getAwardAttachments();
		for ( AwardAttachment awardAttachment : awardAttachments ) {
			if (awardAttachment.getTypeCode() == null) {
				valid = false;
			}
		}
		if(valid) {
			for (AwardAttachment awardattachment : awardAttachments) {
				awardattachment.setModifyAttachment(false);
			}
		}
		return valid;
	}

	private boolean processKeywordBusinessRule(AwardDocument awardDocument) {

		List<AwardScienceKeyword> keywords= awardDocument.getAward().getKeywords();

		for ( AwardScienceKeyword keyword : keywords ) {
			for ( AwardScienceKeyword keyword2 : keywords ) {
				if ( keyword == keyword2 ) {
					continue;
				} else if ( StringUtils.equalsIgnoreCase(keyword.getScienceKeywordCode(), keyword2.getScienceKeywordCode()) ) {
					GlobalVariables.getMessageMap().putError("document.awardList[0].keywords", "error.proposalKeywords.duplicate");

					return false;
				}
			}
		}
		return true;
	}

	private boolean processAddPaymentScheduleBusinessRules(MessageMap errorMap, AddAwardPaymentScheduleRuleEvent event) {
		boolean success = new AwardPaymentScheduleRuleImpl().processAddAwardPaymentScheduleBusinessRules(event);
		return success;
	}

	private boolean processCostShareBusinessRules(Document document) {
		boolean valid = true;
		MessageMap errorMap = GlobalVariables.getMessageMap();
		AwardDocument awardDocument = (AwardDocument) document;
		int i = 0;
		List<AwardCostShare> awardCostShares = awardDocument.getAward().getAwardCostShares();
		errorMap.addToErrorPath(DOCUMENT_ERROR_PATH);
		errorMap.addToErrorPath(AWARD_ERROR_PATH);
		for (AwardCostShare awardCostShare : awardCostShares) {
			String errorPath = "awardCostShares[" + i + Constants.RIGHT_SQUARE_BRACKET;
			errorMap.addToErrorPath(errorPath);
			AwardCostShareRuleEvent event = new AwardCostShareRuleEvent(errorPath,
					awardDocument,
					awardCostShare);
			valid &= new AwardCostShareRuleImpl().processCostShareBusinessRules(event, i);
			errorMap.removeFromErrorPath(errorPath);
			i++;
		}
		errorMap.removeFromErrorPath(AWARD_ERROR_PATH);
		errorMap.removeFromErrorPath(DOCUMENT_ERROR_PATH);
		return valid;
	}
	private boolean processAwardCommentsBusinessRules(AwardDocument awardDocument) {
		AwardCommentsRuleEvent ruleEvent = new AwardCommentsRuleEvent(DOCUMENT_ERROR_PATH + "." + AWARD_ERROR_PATH, awardDocument);
		return processAwardCommentsBusinessRules(ruleEvent);
	}


	private boolean processBenefitsRatesBusinessRules(Document document) {
		boolean valid = true;
		MessageMap errorMap = GlobalVariables.getMessageMap();
		AwardDocument awardDocument = (AwardDocument) document;
		Award award = awardDocument.getAward();
		errorMap.addToErrorPath(DOCUMENT_ERROR_PATH);
		errorMap.addToErrorPath(AWARD_ERROR_PATH);
		if(StringUtils.equalsIgnoreCase(
				getParameterService().getParameterValueAsString(Constants.PARAMETER_MODULE_AWARD,
						ParameterConstants.DOCUMENT_COMPONENT,
						KeyConstants.ENABLE_AWARD_FNA_VALIDATION),
				KeyConstants.ENABLED_PARAMETER_VALUE_ONE) ||
				StringUtils.equalsIgnoreCase(
						getParameterService().getParameterValueAsString(Constants.PARAMETER_MODULE_AWARD,
								ParameterConstants.DOCUMENT_COMPONENT,
								KeyConstants.ENABLE_AWARD_FNA_VALIDATION),
						KeyConstants.ENABLED_PARAMETER_VALUE_TWO)){
			String errorPath = "benefitsRates.rates";
			errorMap.addToErrorPath(errorPath);
			AwardBenefitsRatesRuleEvent event = new AwardBenefitsRatesRuleEvent(errorPath,
					award,
					awardDocument);
			valid &= new AwardBenefitsRatesRuleImpl().processBenefitsRatesBusinessRules(event);
			errorMap.removeFromErrorPath(errorPath);
		}

		errorMap.removeFromErrorPath(AWARD_ERROR_PATH);
		errorMap.removeFromErrorPath(DOCUMENT_ERROR_PATH);
		return valid;
	}
	private boolean processUnitNumberBusinessRule(MessageMap errorMap, AwardDocument awardDocument) {
		Award award = awardDocument.getAward();
		errorMap.addToErrorPath(DOCUMENT_ERROR_PATH);
		errorMap.addToErrorPath(AWARD_ERROR_PATH);

		boolean success = award.getUnitNumber() != null && award.getUnit() != null;
		if(!success) {
			errorMap.putError("unitNumber", "error.award.unitNumber", award.getUnitNumber());
		}

		errorMap.removeFromErrorPath(AWARD_ERROR_PATH);
		errorMap.removeFromErrorPath(DOCUMENT_ERROR_PATH);
		return success;
	}
	private boolean processApprovedForeignTravelBusinessRules(MessageMap errorMap, AwardDocument awardDocument) {
		boolean success = true;
		errorMap.addToErrorPath(DOCUMENT_ERROR_PATH);
		errorMap.addToErrorPath(AWARD_ERROR_PATH);
		Award award = awardDocument.getAward();
		AwardApprovedForeignTravelRule rule = new AwardApprovedForeignTravelRuleImpl();
		int count = award.getApprovedForeignTravelTrips().size();
		for (int i = 0; i < count; i++) {
			String errorPath = String.format("approvedForeignTravelTrips[%d]", i);
			errorMap.addToErrorPath(errorPath);
			String errorKey = AWARD_ERROR_PATH_PREFIX + errorPath;
			AwardApprovedForeignTravelRuleEvent event = new AwardApprovedForeignTravelRuleEvent(errorKey, awardDocument, awardDocument.getAward(),
					award.getApprovedForeignTravelTrips().get(i));
			success &= rule.processAwardApprovedForeignTravelBusinessRules(event);
			errorMap.removeFromErrorPath(errorPath);
		}
		errorMap.removeFromErrorPath(AWARD_ERROR_PATH);
		errorMap.removeFromErrorPath(DOCUMENT_ERROR_PATH);

		return success;
	}
	private boolean processSaveAwardProjectPersonsBusinessRules(MessageMap errorMap, AwardDocument document) {
		errorMap.addToErrorPath(DOCUMENT_ERROR_PATH);
		errorMap.addToErrorPath(AWARD_ERROR_PATH);
		SaveAwardProjectPersonsRuleEvent event = new SaveAwardProjectPersonsRuleEvent("Project Persons", "projectPersons", document);
		boolean success = new AwardProjectPersonsSaveRuleImpl().processSaveAwardProjectPersonsBusinessRules(event);
		errorMap.removeFromErrorPath(AWARD_ERROR_PATH);
		errorMap.removeFromErrorPath(DOCUMENT_ERROR_PATH);

		return success;
	}
	private boolean processDateBusinessRule(MessageMap errorMap, AwardDocument awardDocument) {

		boolean isTimeAndMoneyDocument = KNSGlobalVariables.getKualiForm() instanceof TimeAndMoneyForm;

		if (isTimeAndMoneyDocument) {
			TimeAndMoneyForm timeAndMoneyForm = (TimeAndMoneyForm) KNSGlobalVariables.getKualiForm();
			TimeAndMoneyAwardDateSaveEvent event = new TimeAndMoneyAwardDateSaveEvent("", timeAndMoneyForm.getTimeAndMoneyDocument());
			TimeAndMoneyAwardDateSaveRuleImpl rule = new TimeAndMoneyAwardDateSaveRuleImpl();
			boolean result = rule.processSaveAwardDatesBusinessRules(event);
			return result;

		} else {
			Award award = awardDocument.getAward();
			errorMap.addToErrorPath(DOCUMENT_ERROR_PATH);
			errorMap.addToErrorPath(AWARD_ERROR_PATH);

			boolean success = true;
			int lastIndex = award.getIndexOfLastAwardAmountInfo();
			// make sure start dates are before end dates
			Date effStartDate = award.getAwardEffectiveDate();
			Date effEndDate = award.getAwardAmountInfos().get(lastIndex).getFinalExpirationDate();
			String awardId = award.getAwardNumber();


			Date oblStartDate = award.getAwardAmountInfos().get(lastIndex).getCurrentFundEffectiveDate();
			Date oblEndDate = award.getAwardAmountInfos().get(lastIndex).getObligationExpirationDate();

			String fieldStarter = "awardAmountInfos["+lastIndex;
			//String fieldStarter = "awardHierarchyNodeItems["+(lastIndex-1);
			success = AwardDateRulesHelper.validateProjectStartBeforeProjectEnd(errorMap, effStartDate, effEndDate, fieldStarter+"].finalExpirationDate", awardId) && success;
			success = AwardDateRulesHelper.validateObligationStartBeforeObligationEnd(errorMap, oblStartDate, oblEndDate, fieldStarter+"].currentFundEffectiveDate", awardId) && success;
			success = AwardDateRulesHelper.validateProjectStartBeforeObligationStart(errorMap, effStartDate, oblStartDate, fieldStarter+"].currentFundEffectiveDate", awardId) && success;
			success = AwardDateRulesHelper.validateProjectStartBeforeObligationEnd(errorMap, effStartDate, oblEndDate, fieldStarter+"].obligationExpirationDate", awardId) && success;
			success = AwardDateRulesHelper.validateObligationStartBeforeProjectEnd(errorMap, oblStartDate, effEndDate, fieldStarter+"].currentFundEffectiveDate", awardId) && success;
			success = AwardDateRulesHelper.validateObligationEndBeforeProjectEnd(errorMap, oblEndDate, effEndDate, fieldStarter+"].obligationExpirationDate", awardId) && success;

			errorMap.removeFromErrorPath(AWARD_ERROR_PATH);
			errorMap.removeFromErrorPath(DOCUMENT_ERROR_PATH);
			return success;
		}
	}

}
