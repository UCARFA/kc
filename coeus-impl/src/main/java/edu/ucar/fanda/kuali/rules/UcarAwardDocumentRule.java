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
package edu.ucar.fanda.kuali.rules;

import org.kuali.kra.award.AwardDocumentRule;
import org.kuali.kra.award.detailsdates.AwardDetailsAndDatesRuleImpl;
import org.kuali.kra.award.detailsdates.AwardDetailsAndDatesSaveEvent;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.MessageMap;

import edu.ucar.fanda.kuali.infrastructure.UcarKeyConstants;



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
	        valid &= processUcarSaveActicipatedTotalValid(event);
	        // add additional rules to run here
	        // valid &= processUcarNewRule(event)
	        
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
	      
	        if(award.getAnticipatedTotal().isLessThan(award.getObligatedTotal())) {
	            valid = false;
	            reportError(ANTICIPATED_AMOUNT_PROPERTY_NAME, UcarKeyConstants.ERROR_INVALID_UNIT_NUMBER);
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
		// call all Kuali Research rules for Award
		LOG.info("Starting UCAR custom save business rules");
		boolean retVal = super.processCustomSaveDocumentBusinessRules(document);
		// call UCAR custom rules
		 if(skipRuleProcessing(document)) {
	            return true;
	        }
	 
	        MessageMap errorMap = GlobalVariables.getMessageMap();
	        if (!(document instanceof AwardDocument)) {
	            return false;
	        }
	        
	        AwardDocument awardDocument = (AwardDocument) document;

	        // execute save rules
	        retVal &= processUcarAwardDetailsAndDatesSaveRules(document);
	       
	        
	        LOG.info("UCAR custom save business rules return value: " + retVal );
		
		return retVal;
	}
	
	 private boolean skipRuleProcessing(Document document) {
	        return AwardDocument.PLACEHOLDER_DOC_DESCRIPTION.equals(document.getDocumentHeader().getDocumentDescription());
	 }
	
	
}
