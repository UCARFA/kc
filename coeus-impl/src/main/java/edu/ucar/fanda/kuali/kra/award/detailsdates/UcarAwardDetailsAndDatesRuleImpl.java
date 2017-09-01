package edu.ucar.fanda.kuali.kra.award.detailsdates;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.detailsdates.AwardDetailsAndDatesRuleImpl;
import org.kuali.kra.award.detailsdates.AwardDetailsAndDatesSaveEvent;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.paymentreports.awardreports.reporting.service.ReportTrackingNotification;
import org.kuali.kra.award.paymentreports.awardreports.reporting.service.ReportTrackingNotificationDetails;
import org.kuali.kra.award.paymentreports.awardreports.reporting.service.ReportTrackingNotificationService;
import org.kuali.kra.award.paymentreports.awardreports.reporting.service.ReportTrackingNotificationServiceImpl;
import org.kuali.kra.external.award.AccountCreationClient;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.krad.util.ObjectUtils;

import java.util.List;

//Swang  Override superclass method

public class UcarAwardDetailsAndDatesRuleImpl extends AwardDetailsAndDatesRuleImpl{
    private static final String SPONSOR_CODE_PROPERTY_NAME = "detailsAndDatesFormHelper.newAwardTransferringSponsor.sponsorCode";
    private static final String ANTICIPATED_AMOUNT_PROPERTY_NAME = "awardAmountInfos[0].anticipatedTotalAmount";
    private static final String OBLIGATED_AMOUNT_PROPERTY_NAME = "awardAmountInfos[0].amountObligatedToDate";
    private static final String AWARD_EFFECTIVE_DATE_PROPERTY_NAME = "awardAmountInfos[0].currentFundEffectiveDate";
    private static final String OBLIGATION_EXPIRATION_DATE_PROPERTY_NAME = "awardAmountInfos[0].obligationExpirationDate";
    private static final String AWARD_ACCOUNT_NUMBER_PROPERTY_NAME = "accountNumber";
    private static final String AWARD_FIN_CHART_OF_ACCOUNTS_CODE_PROPERTY_NAME = "financialChartOfAccountsCode";
    private ParameterService parameterService;
    AccountCreationClient accountCreationClient;
    private static final String REGEX_TITLE_SPECIAL_CHARACTER_PATTERN = "([^\\x00-\\x7F])";
    @Override
    public boolean processSaveAwardDetailsAndDates(AwardDetailsAndDatesSaveEvent awardDetailsAndDatesSaveEvent) {
        boolean valid = true;
        Award award = awardDetailsAndDatesSaveEvent.getAward();
        if(award.getAnticipatedTotal().isLessThan(award.getObligatedTotal())) {
            valid = false;
            reportError(ANTICIPATED_AMOUNT_PROPERTY_NAME, KeyConstants.ERROR_ANTICIPATED_AMOUNT);
        }
        if (award.getObligatedTotal().isLessThan(ScaleTwoDecimal.ZERO)) {
            valid = false;
            reportError(OBLIGATED_AMOUNT_PROPERTY_NAME, KeyConstants.ERROR_OBLIGATED_AMOUNT_NEGATIVE);
        }
        if (award.getAnticipatedTotal().isLessThan(ScaleTwoDecimal.ZERO)) {
            valid = false;
            reportError(ANTICIPATED_AMOUNT_PROPERTY_NAME, KeyConstants.ERROR_ANTICIPATED_AMOUNT_NEGATIVE);
        }
        if(award.getObligatedTotal().isGreaterThan(new ScaleTwoDecimal(0)) &&
                //award.getAwardEffectiveDate() == null) {
                award.getAwardAmountInfos().get(award.getAwardAmountInfos().size() - 1).getCurrentFundEffectiveDate() == null) {
            valid = false;
            if ("1".equals(getParameterService().getParameterValueAsString(Constants.PARAMETER_MODULE_AWARD, Constants.PARAMETER_COMPONENT_DOCUMENT, "ENABLE_AWD_ANT_OBL_DIRECT_INDIRECT_COST"))) {
                reportError(AWARD_EFFECTIVE_DATE_PROPERTY_NAME, KeyConstants.ERROR_AWARD_EFFECTIVE_DATE_TOTAL);
            } else {
                reportError(AWARD_EFFECTIVE_DATE_PROPERTY_NAME, KeyConstants.ERROR_AWARD_EFFECTIVE_DATE);
            }
        }
        if(award.getObligatedTotal().isGreaterThan(new ScaleTwoDecimal(0)) &&
                //award.getObligationExpirationDate() == null) {
                award.getAwardAmountInfos().get(award.getAwardAmountInfos().size() - 1).getObligationExpirationDate() == null) {
            valid = false;
            if ("1".equals(getParameterService().getParameterValueAsString(Constants.PARAMETER_MODULE_AWARD, Constants.PARAMETER_COMPONENT_DOCUMENT, "ENABLE_AWD_ANT_OBL_DIRECT_INDIRECT_COST"))) {
                reportError(OBLIGATION_EXPIRATION_DATE_PROPERTY_NAME, KeyConstants.ERROR_OBLIGATION_EXPIRATION_DATE_TOTAL);
            } else {
                reportError(OBLIGATION_EXPIRATION_DATE_PROPERTY_NAME, KeyConstants.ERROR_OBLIGATION_EXPIRATION_DATE);
            }
        }
        //susan wang:  TODO uncemment the following code after award import completed and contract ID moved to the designated place.
        // The following code is making award API not working properly because account number is used as a temrary place for contract ID and has letters.
/*        if (!this.isValidAccountNumber((AwardDocument) awardDetailsAndDatesSaveEvent.getDocument())) {
            valid &= false;
        }*/
/*        ReportTrackingNotificationServiceImpl service;
        service = (ReportTrackingNotificationServiceImpl) KcServiceLocator.getService(ReportTrackingNotificationService.class);
        List<ReportTrackingNotificationDetails> details = service.runReportTrackingNotifications();
*/
        if (!isValidCfdaNumber(award)) {
            valid &= false;
            reportError(Constants.CFDA_NUMBER, KeyConstants.ERROR_INVALID_CFDA, award.getCfdaNumber());
        }
        return valid;
    }

    protected boolean isValidAccountNumber(AwardDocument awardDocument) {
        boolean isValid = true;
        Award award = awardDocument.getAward();

        String accountNumber = award.getAccountNumber();
        String financialDocNbr = award.getFinancialAccountDocumentNumber();
        String chartOfAccountsCode = award.getFinancialChartOfAccountsCode();

        //swang:  custom validation to make sure 6 digit chart of account and 8 digit contract ID
        if (isIntegrationParameterOn() && StringUtils.isEmpty(financialDocNbr) && validationRequired(award)) {

            if (!StringUtils.isBlank(accountNumber) && (!NumberUtils.isDigits(accountNumber) || accountNumber.length() > 10)) {
                reportError(AWARD_ACCOUNT_NUMBER_PROPERTY_NAME,
                        KeyConstants.AWARD_CHART_OF_ACCOUNTS_CODE_NOT_VALID,
                        award.getAccountNumber(), award.getFinancialChartOfAccountsCode());
                isValid = false;

            }

            if (!StringUtils.isBlank(chartOfAccountsCode) && chartOfAccountsCode.length() >8 ) {
                reportError(AWARD_ACCOUNT_NUMBER_PROPERTY_NAME,
                        KeyConstants.AWARD_CHART_OF_ACCOUNTS_CODE_NOT_VALID,
                        award.getAccountNumber(), award.getFinancialChartOfAccountsCode());
                isValid = false;

            }
        }
        return isValid;
    }

}
