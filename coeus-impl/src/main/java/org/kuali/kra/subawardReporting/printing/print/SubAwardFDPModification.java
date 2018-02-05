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
import org.kuali.kra.subaward.printing.schema.PersonDetailsType;
import org.kuali.kra.subaward.printing.schema.SubContractDataDocument;

import static org.kuali.coeus.sys.framework.util.PdfBoxUtils.setField;

public class SubAwardFDPModification extends SubawardFdp {

    private static final String NO = "N";

    @Override
    protected void setSubrecipientInfo(PDDocument document, SubContractDataDocument.SubContractData.SubcontractDetail subcontractDetail) {
        if (StringUtils.isNotBlank(subcontractDetail.getSubcontractorName())) {
            setField(document, ModificationPdf.Field.SUBRECIPIENT.getfName(), subcontractDetail.getSubcontractorName());
        }

        if (StringUtils.isNotBlank(subcontractDetail.getSubcontractorOrgRolodexDetails().getEmail())) {
            setField(document, ModificationPdf.Field.SUBEMAIL.getfName(), subcontractDetail.getSubcontractorOrgRolodexDetails().getEmail());
        }

        if (StringUtils.isNotBlank(subcontractDetail.getSiteInvestigator())) {
            setField(document, ModificationPdf.Field.SUBPI.getfName(), subcontractDetail.getSiteInvestigator());
        }
    }

    @Override
    protected void setPteInfo(PDDocument document, SubContractDataDocument xmlObject) {
        final SubContractDataDocument.SubContractData.PrimeRecipientContacts primeRecipientContacts = xmlObject.getSubContractData().getPrimeRecipientContacts() != null ? xmlObject.getSubContractData().getPrimeRecipientContacts() : SubContractDataDocument.SubContractData.PrimeRecipientContacts.Factory.newInstance();
        final PersonDetailsType primePrincipalInvestigator = ArrayUtils.isNotEmpty(xmlObject.getSubContractData().getPrimePrincipalInvestigatorArray()) ? xmlObject.getSubContractData().getPrimePrincipalInvestigatorArray()[0] : PersonDetailsType.Factory.newInstance();

        if (primeRecipientContacts.getRequisitionerOrgDetails() != null) {
            setField(document, ModificationPdf.Field.PTE_ENTITY_NAME.getfName(), primeRecipientContacts.getRequisitionerOrgDetails().getOrganizationName());
        }

        if (StringUtils.isNotBlank(primePrincipalInvestigator.getFullName())) {
            setField(document, ModificationPdf.Field.PTEPI.getfName(), primePrincipalInvestigator.getFullName());
        }

        if (StringUtils.isNotBlank(primePrincipalInvestigator.getFullName())) {
            setField(document, ModificationPdf.Field.PTE_EMAIL.getfName(), primePrincipalInvestigator.getFullName());
        }
    }

    @Override
    protected void setAwardSubawardNumbers(PDDocument pdfDocument, SubContractDataDocument.SubContractData.SubcontractDetail subcontractDetail, AwardType award) {
        setField(pdfDocument, ModificationPdf.Field.PTE_FEDERAL_AWARD_NO.getfName(), award.getAwardDetails().getAwardHeader().getSponsorAwardNumber());
        setField(pdfDocument, ModificationPdf.Field.FEDERAL_AWARDING_AGENCY.getfName(), award.getAwardDetails().getAwardHeader().getSponsorDescription());
    }

    @Override
    protected void setTitle(PDDocument pdfDocument, AwardType award) {
        setField(pdfDocument, ModificationPdf.Field.PROJECT_TITLE.getfName(), award.getAwardDetails().getAwardHeader().getTitle());
    }

    @Override
    protected void setDates(PDDocument document, SubContractDataDocument xmlObject) {
        final SubContractDataDocument.SubContractData.SubcontractDetail subcontractDetail = xmlObject.getSubContractData().getSubcontractDetail() != null ?
                xmlObject.getSubContractData().getSubcontractDetail() : SubContractDataDocument.SubContractData.SubcontractDetail.Factory.newInstance();
        final SubContractDataDocument.SubContractData.SubcontractAmountInfo amountInfo = ArrayUtils.isNotEmpty(xmlObject.getSubContractData().getSubcontractAmountInfoArray()) ?
                xmlObject.getSubContractData().getSubcontractAmountInfoArray()[0] : SubContractDataDocument.SubContractData.SubcontractAmountInfo.Factory.newInstance();


        if (subcontractDetail.getStartDate() != null) {
            setField(document, ModificationPdf.Field.START_DATE.getfName(), formatDate(subcontractDetail.getStartDate().getTime()));
        }

        if (amountInfo.getPerformanceEndDate() != null) {
            setField(document, ModificationPdf.Field.END_DATE.getfName(), formatDate(amountInfo.getPerformanceEndDate().getTime()));
        }

        if (amountInfo.getModificationEffectiveDate() != null) {
            setField(document, ModificationPdf.Field.EFFECTIVE_DATE.getfName(), formatDate(amountInfo.getModificationEffectiveDate().getTime()));
        }

        if (amountInfo.getModificationNumber() != null) {
            setField(document, ModificationPdf.Field.AMENDMENT_NUMBER.getfName(), amountInfo.getModificationNumber());
        }
    }

    @Override
    protected void setAmounts(PDDocument document, SubContractDataDocument xmlObject) {
        final SubContractDataDocument.SubContractData.SubcontractAmountInfo amountInfo = ArrayUtils.isNotEmpty(xmlObject.getSubContractData().getSubcontractAmountInfoArray()) ? xmlObject.getSubContractData().getSubcontractAmountInfoArray()[0] : SubContractDataDocument.SubContractData.SubcontractAmountInfo.Factory.newInstance();

        if (amountInfo.getObligatedChange() != null) {
            setField(document, ModificationPdf.Field.AMOUNT_FUNDED_THIS_ACTION.getfName(), amountInfo.getObligatedChange().toPlainString());
        }

        if (amountInfo.getObligatedAmount() != null) {
            setField(document, ModificationPdf.Field.TOTAL_FEDERAL_FUNDS_OBLIGATED.getfName(), amountInfo.getObligatedAmount().toPlainString());
        }
    }

    @Override
    protected void setTermsAndConditions(PDDocument document, SubContractDataDocument xmlObject) {
        final SubContractDataDocument.SubContractData.SubcontractDetail subcontractDetail = xmlObject.getSubContractData().getSubcontractDetail() != null ?
                xmlObject.getSubContractData().getSubcontractDetail() : SubContractDataDocument.SubContractData.SubcontractDetail.Factory.newInstance();
        if (subcontractDetail.getComments() != null) {
            setField(document, ModificationPdf.Field.ACTION.getfName(), subcontractDetail.getComments());
        }
    }

    @Override
    protected void setMiscellaneousItems(PDDocument pdfDocument, SubContractDataDocument xmlObject) {
        final SubContractDataDocument.SubContractData.SubcontractDetail subcontractDetail = xmlObject.getSubContractData().getSubcontractDetail() != null ?
                xmlObject.getSubContractData().getSubcontractDetail() : SubContractDataDocument.SubContractData.SubcontractDetail.Factory.newInstance();
        final SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo = ArrayUtils.isNotEmpty(xmlObject.getSubContractData().getSubcontractTemplateInfoArray()) ? xmlObject.getSubContractData().getSubcontractTemplateInfoArray(0) : SubContractDataDocument.SubContractData.SubcontractTemplateInfo.Factory.newInstance();

        if (subcontractDetail.getFsrsSubawardNumber() != null) {
            setField(pdfDocument, ModificationPdf.Field.SUBAWARD_NUMBER.getfName(), subcontractDetail.getFsrsSubawardNumber());
        }

        setField(pdfDocument, ModificationPdf.Field.SUBJECTO_FFATA.getfName(), subcontractDetail.getFFATA() == null ||
                subcontractDetail.getFFATA().equalsIgnoreCase(NO) ? ModificationPdf.Field.NO : ModificationPdf.Field.YES);
        setField(pdfDocument, ModificationPdf.Field.CARRYOVER_RADIO_BUTTON.getfName(), templateInfo.getAutomaticCarryForward() == null ||
                templateInfo.getAutomaticCarryForward().equalsIgnoreCase(NO) ? ModificationPdf.Field.CARRYOVER_NO : ModificationPdf.Field.CARRYOVER_YES);

    }
}
