/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.awardreports;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.lookup.keyvalue.FrequencyBaseCodeValuesFinder;
import org.kuali.kra.award.paymentreports.Report;
import org.kuali.kra.award.paymentreports.awardreports.reporting.ReportTrackingConstants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The AwardPaymentScheduleRuleImpl.
 */
public class AwardReportTermRuleImpl extends KcTransactionalDocumentRuleBase implements AwardReportTermRule {
    
    private static final String REPORT_CODE_ERROR_PARM = "Type (Type)";
    private static final String FREQUENCY_BASE_CODE_ERROR_PARM = "Frequency Base (Frequency Base)";

    /**
     * This function is called on Save.
     * @see org.kuali.kra.award.paymentreports.awardreports.AwardReportTermRule#processAwardReportTermBusinessRules(
     *          org.kuali.kra.award.paymentreports.awardreports.AwardReportTermRuleEvent)
     */
    @Override
    public boolean processAwardReportTermBusinessRules(AwardReportTermRuleEvent event) {
        boolean validFields = true;
        String fieldStarter = "document.awardList[0].awardReportTermItems[";
        String fieldEnder = "].";
        int counter = 0;
        List<AwardReportTerm> awardReportTerms = new ArrayList<>(event.getAward().getAwardReportTermItems());
        for (AwardReportTerm awardReportTermItem : awardReportTerms) {
            validFields = validateRequiredFields(awardReportTermItem, fieldStarter + counter + fieldEnder) 
                && isUnique(event.getAward().getAwardReportTermItems(), awardReportTermItem) && validFields;
            counter++;
        }
        return validFields;        
    }
    /**
     * 
     * This method processes new AwardPaymentSchedule rules
     * 
     * @param event
     * @return
     */
    @Override
    public boolean processAddAwardReportTermBusinessRules(AddAwardReportTermRuleEvent event) {
        GenericAwardReportTerm awardReportTermItem = event.getAwardReportTermItemForValidation();        
        List<? extends GenericAwardReportTerm> items = 
            (List<? extends GenericAwardReportTerm>) event.getAward().getAwardReportTermItems();
        return validatePI(event.getAward()) && validateRequiredFields(event.getAwardReportTermItemForValidation(), "") 
            && isUnique(items, awardReportTermItem);        
    }
    
    private boolean validatePI(Award award) {
        boolean retVal = true;
        if (award.getPrincipalInvestigator() == null) {
            //retVal = false;
            reportWarning(ReportTrackingConstants.REPORT_CODE, KeyConstants.ERROR_AWARD_REPORT_TERM_ITEM_NO_PI, "");
        }
        return retVal;
    }
    
    /**
     * 
     * An award report term item is unique if no other matching items are in the collection
     * To know if this is a new add or an edit of an existing equipment item, we check 
     * the identifier for nullity. If null, this is an add; otherwise, it's an update
     * If an update, then we expect to find one match in the collection (itself). If an add, 
     * we expect to find no matches in the collection.
     * @param awardReportTermItems
     * @param awardReportTermItem
     * @return
     */
    protected boolean isUnique(List<? extends GenericAwardReportTerm> awardReportTermItems, GenericAwardReportTerm awardReportTermItem) {
        boolean duplicateFound = false;
        for (GenericAwardReportTerm listItem : awardReportTermItems) {
            duplicateFound = awardReportTermItem != listItem && listItem.equalsInitialFields(awardReportTermItem);
            if (duplicateFound) {
                break;
            }
        }
        
        if (duplicateFound) {
            if (!GlobalVariables.getMessageMap().containsMessageKey(KeyConstants.ERROR_AWARD_REPORT_TERM_ITEM_NOT_UNIQUE)) {
                reportError("awardReportTerm", KeyConstants.ERROR_AWARD_REPORT_TERM_ITEM_NOT_UNIQUE);
            }
        }
        return !duplicateFound;
    }
    
    /**
     * 
     * This method validates that all the required fields have values.  It is protected so that it can be unit tested easily.
     * @param awardReportTermItem
     * @param fieldPrePend
     * @return
     */
    protected boolean validateRequiredFields(GenericAwardReportTerm awardReportTermItem, String fieldPrePend) {
        boolean retVal = true;
        if (StringUtils.isBlank(awardReportTermItem.getReportCode())) {
            retVal = false;
            reportError(fieldPrePend + ReportTrackingConstants.REPORT_CODE, KeyConstants.ERROR_REQUIRED, REPORT_CODE_ERROR_PARM);
        }
        if (StringUtils.isBlank(awardReportTermItem.getFrequencyCode()) && 
                !StringUtils.isBlank(awardReportTermItem.getOspDistributionCode())) {
            retVal = false;
            reportError(fieldPrePend + ReportTrackingConstants.FREQUENCY_CODE, KeyConstants.ERROR_AWARD_REPORT_TERM_ITEM_FREQUENCY_REQUIRED);
        }
        if (StringUtils.isBlank(awardReportTermItem.getFrequencyBaseCode())) {
            FrequencyBaseCodeValuesFinder finder = new FrequencyBaseCodeValuesFinder(awardReportTermItem.getFrequencyCode());
            /**
             * If there are no frequency bases active, then we don't validate the frequency base field.
             * Note, there is always a 'select' value pair in the keyValues.
             */
            if (finder.getKeyValues().size() > 1) {
                retVal = false;
                reportError(fieldPrePend + ReportTrackingConstants.FREQUENCY_BASE_CODE, KeyConstants.ERROR_REQUIRED, FREQUENCY_BASE_CODE_ERROR_PARM);
            }
        }
        if (StringUtils.isBlank(awardReportTermItem.getOspDistributionCode()) 
                && isFinalReport(awardReportTermItem.getReportCode())
                && StringUtils.isNotBlank(awardReportTermItem.getFrequencyCode())) {
            reportError(fieldPrePend + ReportTrackingConstants.OSP_DISTRIBUTION_CODE, KeyConstants.ERROR_AWARD_REPORT_TERM_ITEM_OSP_REQUIRED);
            retVal = false;
        }
        return retVal;
    }
    
    private boolean isFinalReport(String reportCode) {
        boolean retVal = false;
        if (StringUtils.isNotBlank(reportCode)) {
            Map fieldValues = new HashMap();
            fieldValues.put("REPORT_CODE", reportCode);
            Report report = (Report) this.getBusinessObjectService().findMatching(Report.class, fieldValues).iterator().next();
            retVal = report.getFinalReportFlag();
        }
        return retVal;
    }
    
    /**
     * 
     * This method is used to validate new AwardTemplateReportTerms on the Sponsor Template maint doc
     * using the same rules Award uses.
     * @param awardReportTerm
     * @param existingItems
     * @return
     */
    public boolean processAwardReportTermBusinessRules(GenericAwardReportTerm awardReportTerm,
            List<? extends GenericAwardReportTerm> existingItems) {
        return validateRequiredFields(awardReportTerm, "") && isUnique(existingItems, awardReportTerm);
    }

}
