/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subawardReporting.printing.print;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.kuali.kra.award.printing.schema.AwardType;
import org.kuali.kra.subaward.bo.FinalStatementDue;
import org.kuali.kra.subaward.printing.schema.PersonDetailsType;
import org.kuali.kra.subaward.printing.schema.SubContractDataDocument;

import static org.kuali.coeus.sys.framework.util.PdfBoxUtils.hideField;
import static org.kuali.coeus.sys.framework.util.PdfBoxUtils.setField;

public class SubAwardFDPAgreement extends SubawardFdp {


    protected void setSubrecipientInfo(PDDocument document, SubContractDataDocument.SubContractData.SubcontractDetail subcontractDetail) {
        if (StringUtils.isNotBlank(subcontractDetail.getSubcontractorName())) {
            setField(document, AgreementPdf.Field.SUBRECIPIENT.getfName(), subcontractDetail.getSubcontractorName());
        }

        if (StringUtils.isNotBlank(subcontractDetail.getSiteInvestigator())) {
            setField(document, AgreementPdf.Field.SUB_PI.getfName(), subcontractDetail.getSiteInvestigator());
        }
    }

    @Override
    protected void setMiscellaneousItems(PDDocument pdfDocument, SubContractDataDocument xmlObject) {

    }

    protected void setPteInfo(PDDocument document, SubContractDataDocument xmlObject) {

        final SubContractDataDocument.SubContractData.PrimeRecipientContacts primeRecipientContacts = xmlObject.getSubContractData().getPrimeRecipientContacts() != null ? xmlObject.getSubContractData().getPrimeRecipientContacts() : SubContractDataDocument.SubContractData.PrimeRecipientContacts.Factory.newInstance();
        final PersonDetailsType primePrincipalInvestigator = ArrayUtils.isNotEmpty(xmlObject.getSubContractData().getPrimePrincipalInvestigatorArray()) ? xmlObject.getSubContractData().getPrimePrincipalInvestigatorArray()[0] : PersonDetailsType.Factory.newInstance();

        if (primeRecipientContacts.getRequisitionerOrgDetails() != null) {
            setField(document, AgreementPdf.Field.PASS_THROUGH_ENTITY.getfName(), primeRecipientContacts.getRequisitionerOrgDetails().getOrganizationName());
        }

        if (StringUtils.isNotBlank(primePrincipalInvestigator.getFullName())) {
            setField(document, AgreementPdf.Field.PTE_PI.getfName(), primePrincipalInvestigator.getFullName());
        }
    }

    protected void setAwardSubawardNumbers(PDDocument document, SubContractDataDocument.SubContractData.SubcontractDetail subcontractDetail, AwardType award) {

        if (award.getAwardDetails() != null && award.getAwardDetails().getAwardHeader() != null && StringUtils.isNotBlank(award.getAwardDetails().getAwardHeader().getSponsorAwardNumber())) {
            setField(document, AgreementPdf.Field.PTE_FEDERAL_AWARD_NO.getfName(), award.getAwardDetails().getAwardHeader().getSponsorAwardNumber());
        }

        if (StringUtils.isNotBlank(subcontractDetail.getFsrsSubawardNumber())) {
            setField(document, AgreementPdf.Field.SUBAWARD_NO.getfName(), subcontractDetail.getFsrsSubawardNumber());
        }
    }

    protected void setTitle(PDDocument document, AwardType award) {
        if (award.getAwardDetails() != null && award.getAwardDetails().getAwardHeader() != null && StringUtils.isNotBlank(award.getAwardDetails().getAwardHeader().getTitle())) {
            setField(document, AgreementPdf.Field.PROJECT_TITLE.getfName(), award.getAwardDetails().getAwardHeader().getTitle());
        }
    }

    protected void setDates(PDDocument document, SubContractDataDocument xmlObject) {
        final SubContractDataDocument.SubContractData.SubcontractDetail subcontractDetail = xmlObject.getSubContractData().getSubcontractDetail() != null ? xmlObject.getSubContractData().getSubcontractDetail() : SubContractDataDocument.SubContractData.SubcontractDetail.Factory.newInstance();
        final SubContractDataDocument.SubContractData.SubcontractAmountInfo amountInfo = ArrayUtils.isNotEmpty(xmlObject.getSubContractData().getSubcontractAmountInfoArray()) ? xmlObject.getSubContractData().getSubcontractAmountInfoArray()[0] : SubContractDataDocument.SubContractData.SubcontractAmountInfo.Factory.newInstance();

        if (amountInfo.getPerformanceStartDate() != null) {
            setField(document, AgreementPdf.Field.POP_START.getfName(), formatDate(amountInfo.getPerformanceStartDate().getTime()));
        }

        if (amountInfo.getPerformanceEndDate() != null) {
            setField(document, AgreementPdf.Field.POP_END.getfName(), formatDate(amountInfo.getPerformanceEndDate().getTime()));
        }

        hideField(document, AgreementPdf.Field.PROJECT_START_TIP.getfName());
        if (subcontractDetail.getStartDate() != null) {
            setField(document, AgreementPdf.Field.PROJECT_START.getfName(), formatDate(subcontractDetail.getStartDate().getTime()));
        }

        hideField(document, AgreementPdf.Field.PROJECT_END_TIP.getfName());
        if (subcontractDetail.getEndDate() != null) {
            setField(document, AgreementPdf.Field.PROJECT_END.getfName(), formatDate(subcontractDetail.getEndDate().getTime()));
        }
    }

    protected void setAmounts(PDDocument document, SubContractDataDocument xmlObject) {
        final SubContractDataDocument.SubContractData.SubcontractAmountInfo amountInfo = ArrayUtils.isNotEmpty(xmlObject.getSubContractData().getSubcontractAmountInfoArray()) ? xmlObject.getSubContractData().getSubcontractAmountInfoArray()[0] : SubContractDataDocument.SubContractData.SubcontractAmountInfo.Factory.newInstance();

        if (amountInfo.getObligatedAmount() != null) {
            setField(document, AgreementPdf.Field.AMOUNT_FUNDED_THIS_ACTION.getfName(), amountInfo.getObligatedAmount().toPlainString());
        }

        if (amountInfo.getAnticipatedAmount() != null) {
            setField(document, AgreementPdf.Field.INCREMENTALLY_ESTIMATED_TOTAL.getfName(), amountInfo.getAnticipatedAmount().toPlainString());
        }
    }

    protected void setTermsAndConditions(PDDocument document, SubContractDataDocument xmlObject) {
        final SubContractDataDocument.SubContractData.OtherConfigInfo configInfo = ArrayUtils.isNotEmpty(xmlObject.getSubContractData().getOtherConfigInfoArray()) ? xmlObject.getSubContractData().getOtherConfigInfoArray(0) : SubContractDataDocument.SubContractData.OtherConfigInfo.Factory.newInstance();
        final SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo = ArrayUtils.isNotEmpty(xmlObject.getSubContractData().getSubcontractTemplateInfoArray()) ? xmlObject.getSubContractData().getSubcontractTemplateInfoArray(0) : SubContractDataDocument.SubContractData.SubcontractTemplateInfo.Factory.newInstance();

        setField(document, AgreementPdf.Field.TERM_2_CONTACT.getfName(), "");
        if (StringUtils.isNotBlank(templateInfo.getInvoiceOrPaymentContactDescription())) {
            setField(document, AgreementPdf.Field.TERM_2_CONTACT.getfName(), templateInfo.getInvoiceOrPaymentContactDescription());
        }

        setField(document, AgreementPdf.Field.TERM_3_CONTACT.getfName(), "");
        if (StringUtils.isNotBlank(templateInfo.getFinalStmtOfCostsContactDescription())) {
            setField(document, AgreementPdf.Field.TERM_3_CONTACT.getfName(), templateInfo.getFinalStmtOfCostsContactDescription());
        }

        if (StringUtils.isNotBlank(templateInfo.getFinalStatementDueCd())) {
            setField(document, AgreementPdf.Field.PROJECT_BUDGET_INVOICE_DROPDOWN.getfName(), FinalStatementDue.PTE.getCode().equals(templateInfo.getFinalStatementDueCd()) ? AgreementPdf.PROJECT_PERIOD_END_DATE_VALUE : AgreementPdf.BUDGET_PERIOD_END_DATE_VALUE);
        }

        setField(document, AgreementPdf.Field.TERM_6_CONTACT.getfName(), "");
        if (StringUtils.isNotBlank(templateInfo.getChangeRequestsContactDescription())) {
            setField(document, AgreementPdf.Field.TERM_6_CONTACT.getfName(), templateInfo.getChangeRequestsContactDescription());
        }

        setField(document, AgreementPdf.Field.UNI_BI_MOD_DROPOWN.getfName(), configInfo.getFdpSubawardBilateralAgreements() ? AgreementPdf.BILATERALLY_VALUE : AgreementPdf.UNILATERALLY_VALUE);

        setField(document, AgreementPdf.Field.TERM_7_CONTACT.getfName(), "");
        if (StringUtils.isNotBlank(templateInfo.getChangeRequestsContactDescription())) {
            setField(document, AgreementPdf.Field.TERM_7_CONTACT.getfName(), templateInfo.getChangeRequestsContactDescription());
        }

        setField(document, AgreementPdf.Field.TERM_9_CONTACT.getfName(), "");
        if (StringUtils.isNotBlank(templateInfo.getTerminationContactDescription())) {
            setField(document, AgreementPdf.Field.TERM_9_CONTACT.getfName(), templateInfo.getTerminationContactDescription());
        }
    }


}
