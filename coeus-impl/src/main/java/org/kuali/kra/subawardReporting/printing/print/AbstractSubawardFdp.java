package org.kuali.kra.subawardReporting.printing.print;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.xmlbeans.XmlObject;
import org.kuali.coeus.common.framework.print.AbstractPrint;
import org.kuali.coeus.common.framework.print.PrintingException;
import org.kuali.coeus.sys.framework.util.CollectionUtils;
import org.kuali.coeus.sys.framework.util.PdfBoxUtils;
import org.kuali.kra.award.printing.schema.AwardType;
import org.kuali.kra.subaward.bo.*;
import org.kuali.kra.subaward.printing.schema.PersonDetailsType;
import org.kuali.kra.subaward.printing.schema.SubContractDataDocument;
import org.kuali.kra.subaward.reporting.printing.SubAwardPrintType;
import org.kuali.kra.subaward.reporting.printing.service.SubAwardPrintingService;
import org.springframework.core.io.Resource;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.kuali.coeus.sys.framework.util.CollectionUtils.entriesToMap;
import static org.kuali.coeus.sys.framework.util.CollectionUtils.entry;
import static org.kuali.coeus.sys.framework.util.PdfBoxUtils.*;

public abstract class AbstractSubawardFdp extends AbstractPrint {

    private static final String COPYRIGHTS_GRANT_CODE = "1";
    private static final String COPYRIGHTS_SHALL_GRANT_CODE = "2";

    private static final String ADMIN_CONTACT_TYPE_CODE_1 = "13";
    private static final String ADMIN_CONTACT_TYPE_CODE_2 = "22";
    private static final String FIN_CONTACT_TYPE_CODE = "38";
    private static final String PI_TYPE_CODE = "?";
    private static final String AUTH_OFFICIAL_TYPE_CODE = "37";

    private static final String MM_DD_YYYY = "MM/dd/yyyy";

    private static final List<String> FORM_ORDER = Stream.of(AgreementForm.FDP_AGREEMENT.getId(), "FDP Modification", "FDP Modification Unilateral",
            Attachment2Form.FDP_AFOSR.getId(), Attachment2Form.FDP_AMRAA.getId(), Attachment2Form.FDP_AMRMC.getId(), Attachment2Form.FDP_ARO.getId(),
            Attachment2Form.FDP_DOE.getId(), Attachment2Form.FDP_EPA.getId(), Attachment2Form.FDP_NASA.getId(), Attachment2Form.FDP_NIH.getId(),
            Attachment2Form.FDP_NSF.getId(), Attachment2Form.FDP_ONR.getId(), Attachment2Form.FDP_USDA.getId(),
            "FDP_ATT_3A", "FDP_ATT_3B", "FDP_ATT_3B_2", "FDP_ATT_4")
            .collect(Collectors.toList());

    private Map<String, Resource> pdfForms;

    @Override
    public Map<String,Source> getXSLTemplateWithBookmarks() {
        return getSelectedTemplates().stream()
                .map(s -> CollectionUtils.<String, Source>entry(s.getFormId(), new StreamSource(s.getAttachmentContent() != null ? new ByteArrayInputStream(s.getAttachmentContent()) :
                        new ByteArrayInputStream(new byte[] {}))))
                .collect(entriesToMap());
    }

    private Collection<SubAwardForms> getSelectedTemplates() {
        return (Collection<SubAwardForms> ) getReportParameters().get(SubAwardPrintingService.SELECTED_TEMPLATES);
    }

    @Override
    public Map<String, Resource> getPdfForms() {
        return pdfForms;
    }

    public void setPdfForms(Map<String, Resource> pdfForms) {
        this.pdfForms = pdfForms;
    }

    @Override
    public Map<String, byte[]> fillPdfForms(Map<String, Resource> pdfForms, Map<String, XmlObject> xml) {
        final Collection<String> selected = getSelectedTemplates().stream()
                .map(SubAwardForms::getFormId)
                .collect(Collectors.toList());

        return pdfForms.entrySet().stream()
                .filter(e -> selected.contains(e.getKey()))
                .map(e -> {
            try (ByteArrayOutputStream out = new ByteArrayOutputStream();
            PDDocument document = PDDocument.load(e.getValue().getInputStream())) {

                final SubContractDataDocument xmlObject = (SubContractDataDocument) xml.get(SubAwardPrintType.SUB_AWARD_FDP_TEMPLATE.getSubAwardPrintType());
                if (xmlObject != null) {

                    Optional<AgreementForm> agreement = Stream.of(AgreementForm.values())
                            .filter(agreementForm -> agreementForm.getId().equals(e.getKey()))
                            .findFirst();

                    if (agreement.isPresent()) {
                        fillAgreementForm(document, xmlObject);
                    } else {
                        Stream.of(Attachment2Form.values())
                                .filter(attachment2Form -> attachment2Form.getId().equals(e.getKey()))
                                .findFirst()
                                .ifPresent(attachment2Form -> fillAttachment2Form(document, xmlObject, attachment2Form));
                    }
                }

                PdfBoxUtils.flatten(document);
                document.save(out);
                return entry(e.getKey(), out.toByteArray());
            } catch (IOException e1) {
                throw new PrintingException(e1);
            }
                }).collect(entriesToMap());
    }

    private void fillAgreementForm(PDDocument document, SubContractDataDocument xmlObject) {
        final SubContractDataDocument.SubContractData.SubcontractDetail subcontractDetail = xmlObject.getSubContractData().getSubcontractDetail() != null ? xmlObject.getSubContractData().getSubcontractDetail() : SubContractDataDocument.SubContractData.SubcontractDetail.Factory.newInstance();
        final SubContractDataDocument.SubContractData.SubcontractAmountInfo amountInfo = ArrayUtils.isNotEmpty(xmlObject.getSubContractData().getSubcontractAmountInfoArray()) ? xmlObject.getSubContractData().getSubcontractAmountInfoArray()[0] : SubContractDataDocument.SubContractData.SubcontractAmountInfo.Factory.newInstance();
        final SubContractDataDocument.SubContractData.PrimeRecipientContacts primeRecipientContacts = xmlObject.getSubContractData().getPrimeRecipientContacts() != null ? xmlObject.getSubContractData().getPrimeRecipientContacts() : SubContractDataDocument.SubContractData.PrimeRecipientContacts.Factory.newInstance();
        final PersonDetailsType primePrincipalInvestigator = ArrayUtils.isNotEmpty(xmlObject.getSubContractData().getPrimePrincipalInvestigatorArray()) ? xmlObject.getSubContractData().getPrimePrincipalInvestigatorArray()[0] : PersonDetailsType.Factory.newInstance();
        final AwardType award = ArrayUtils.isNotEmpty(xmlObject.getSubContractData().getAwardArray()) ? xmlObject.getSubContractData().getAwardArray()[0] : AwardType.Factory.newInstance();
        final SubContractDataDocument.SubContractData.OtherConfigInfo configInfo = ArrayUtils.isNotEmpty(xmlObject.getSubContractData().getOtherConfigInfoArray()) ? xmlObject.getSubContractData().getOtherConfigInfoArray(0) : SubContractDataDocument.SubContractData.OtherConfigInfo.Factory.newInstance();
        final SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo = ArrayUtils.isNotEmpty(xmlObject.getSubContractData().getSubcontractTemplateInfoArray()) ? xmlObject.getSubContractData().getSubcontractTemplateInfoArray(0) : SubContractDataDocument.SubContractData.SubcontractTemplateInfo.Factory.newInstance();

        setFederalAwardingAgency(document);
        setPteInfo(document, primeRecipientContacts, primePrincipalInvestigator);
        setSubrecipientInfo(document, subcontractDetail);
        setAwardSubawardNumbers(document, subcontractDetail, award);
        setTitle(document, award);
        setDates(document, subcontractDetail, amountInfo);
        setAmounts(document, amountInfo);
        setTermsAndConditions(document, configInfo, templateInfo);
    }

    private void setFederalAwardingAgency(PDDocument document) {
        setField(document, AgreementPdf.Field.FEDERAL_AWARDING_AGENCY.getfName(), "");
    }

    private void setPteInfo(PDDocument document, SubContractDataDocument.SubContractData.PrimeRecipientContacts primeRecipientContacts, PersonDetailsType primePrincipalInvestigator) {
        if (primeRecipientContacts.getRequisitionerOrgDetails() != null) {
            setField(document, AgreementPdf.Field.PASS_THROUGH_ENTITY.getfName(), primeRecipientContacts.getRequisitionerOrgDetails().getOrganizationName());
        }

        if (StringUtils.isNotBlank(primePrincipalInvestigator.getFullName())) {
            setField(document, AgreementPdf.Field.PTE_PI.getfName(), primePrincipalInvestigator.getFullName());
        }
    }

    private void setSubrecipientInfo(PDDocument document, SubContractDataDocument.SubContractData.SubcontractDetail subcontractDetail) {
        if (StringUtils.isNotBlank(subcontractDetail.getSubcontractorName())) {
            setField(document, AgreementPdf.Field.SUBRECIPIENT.getfName(), subcontractDetail.getSubcontractorName());
        }

        if (StringUtils.isNotBlank(subcontractDetail.getSiteInvestigator())) {
            setField(document, AgreementPdf.Field.SUB_PI.getfName(), subcontractDetail.getSiteInvestigator());
        }
    }

    private void setAwardSubawardNumbers(PDDocument document, SubContractDataDocument.SubContractData.SubcontractDetail subcontractDetail, AwardType award) {
        if (award.getAwardDetails() != null && award.getAwardDetails().getAwardHeader() != null && StringUtils.isNotBlank(award.getAwardDetails().getAwardHeader().getSponsorAwardNumber())) {
            setField(document, AgreementPdf.Field.PTE_FEDERAL_AWARD_NO.getfName(), award.getAwardDetails().getAwardHeader().getSponsorAwardNumber());
        }

        if (StringUtils.isNotBlank(subcontractDetail.getFsrsSubawardNumber())) {
            setField(document, AgreementPdf.Field.SUBAWARD_NO.getfName(), subcontractDetail.getFsrsSubawardNumber());
        }
    }

    private void setTitle(PDDocument document, AwardType award) {
        if (award.getAwardDetails() != null && award.getAwardDetails().getAwardHeader() != null && StringUtils.isNotBlank(award.getAwardDetails().getAwardHeader().getTitle())) {
            setField(document, AgreementPdf.Field.PROJECT_TITLE.getfName(), award.getAwardDetails().getAwardHeader().getTitle());
        }
    }

    private void setDates(PDDocument document, SubContractDataDocument.SubContractData.SubcontractDetail subcontractDetail, SubContractDataDocument.SubContractData.SubcontractAmountInfo amountInfo) {
        if (amountInfo.getPerformanceStartDate() != null) {
            setField(document, AgreementPdf.Field.POP_START.getfName(), formatDate(amountInfo.getPerformanceStartDate().getTime()));
        }

        if (amountInfo.getPerformanceEndDate() != null) {
            setField(document, AgreementPdf.Field.POP_END.getfName(), formatDate(amountInfo.getPerformanceEndDate().getTime()));
        }

        if (subcontractDetail.getStartDate() != null) {
            setField(document, AgreementPdf.Field.PROJECT_START.getfName(), formatDate(subcontractDetail.getStartDate().getTime()));
        }

        if (subcontractDetail.getEndDate() != null) {
            setField(document, AgreementPdf.Field.PROJECT_END.getfName(), formatDate(subcontractDetail.getEndDate().getTime()));
        }
    }

    private void setAmounts(PDDocument document, SubContractDataDocument.SubContractData.SubcontractAmountInfo amountInfo) {
        if (amountInfo.getObligatedAmount() != null) {
            setField(document, AgreementPdf.Field.AMOUNT_FUNDED_THIS_ACTION.getfName(), amountInfo.getObligatedAmount().toPlainString());
        }

        if (amountInfo.getAnticipatedAmount() != null) {
            setField(document, AgreementPdf.Field.INCREMENTALLY_ESTIMATED_TOTAL.getfName(), amountInfo.getAnticipatedAmount().toPlainString());
        }
    }

    private void setTermsAndConditions(PDDocument document, SubContractDataDocument.SubContractData.OtherConfigInfo configInfo, SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo) {
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

        //is this right?
        setField(document, AgreementPdf.Field.TERM_7_CONTACT.getfName(), "");
        if (StringUtils.isNotBlank(templateInfo.getChangeRequestsContactDescription())) {
            setField(document, AgreementPdf.Field.TERM_7_CONTACT.getfName(), templateInfo.getChangeRequestsContactDescription());
        }

        setField(document, AgreementPdf.Field.TERM_9_CONTACT.getfName(), "");
        if (StringUtils.isNotBlank(templateInfo.getTerminationContactDescription())) {
            setField(document, AgreementPdf.Field.TERM_9_CONTACT.getfName(), templateInfo.getTerminationContactDescription());
        }
    }

    private void fillAttachment2Form(PDDocument document, SubContractDataDocument xmlObject, Attachment2Form formId) {
        final Attachment2SponsorFormType type = formId.getSponsorFormType();
        final SubContractDataDocument.SubContractData.SubcontractDetail subcontractDetail = xmlObject.getSubContractData().getSubcontractDetail() != null ? xmlObject.getSubContractData().getSubcontractDetail() : SubContractDataDocument.SubContractData.SubcontractDetail.Factory.newInstance();
        final SubContractDataDocument.SubContractData.OtherConfigInfo configInfo = ArrayUtils.isNotEmpty(xmlObject.getSubContractData().getOtherConfigInfoArray()) ? xmlObject.getSubContractData().getOtherConfigInfoArray(0) : SubContractDataDocument.SubContractData.OtherConfigInfo.Factory.newInstance();
        final SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo = ArrayUtils.isNotEmpty(xmlObject.getSubContractData().getSubcontractTemplateInfoArray()) ? xmlObject.getSubContractData().getSubcontractTemplateInfoArray(0) : SubContractDataDocument.SubContractData.SubcontractTemplateInfo.Factory.newInstance();

        setSponsorAgency(document, type);
        setHeaderInformation(document, subcontractDetail);
        setRequiredDataElements(document);
        setGenTermsAndConditions(document, configInfo, templateInfo, type);
        setMpiInfo(document, templateInfo, type);
        setStcCopyrights(document, templateInfo);
        setStcAutoCarryForward(document, templateInfo);
        setHumanAnimalSubjects(document, templateInfo);
        setHumanPteVerification(document, templateInfo);
        setAnimalPteVerification(document, templateInfo);
        setHumanSubjectsDataExchange(document, templateInfo);
        setHumanSubjectsDataExchangeTerms(document, templateInfo);
        setAdditionalTerms(document, templateInfo);
        setPromotingObjectivityFcio(document, templateInfo, configInfo, type);
        setDataSharingPubAccessPolicy(document, templateInfo);
    }

    private void setSponsorAgency(PDDocument document, Attachment2SponsorFormType type) {
        if (type == Attachment2SponsorFormType.AFOSR) {
            setField(document, Attachment2Pdf.Field.SPONSOR_AGENCY_RADIO_BUTTON_GROUP.getfName(), Attachment2Pdf.AFOSR_RADIO_VALUE);
        } else if (type == Attachment2SponsorFormType.AMRMC) {
            setField(document, Attachment2Pdf.Field.SPONSOR_AGENCY_RADIO_BUTTON_GROUP.getfName(), Attachment2Pdf.AMRMC_RADIO_VALUE);
        } else if (type == Attachment2SponsorFormType.AMRAA) {
            setField(document, Attachment2Pdf.Field.SPONSOR_AGENCY_RADIO_BUTTON_GROUP.getfName(), Attachment2Pdf.AMRAA_RADIO_VALUE);
        } else if (type == Attachment2SponsorFormType.ARO) {
            setField(document, Attachment2Pdf.Field.SPONSOR_AGENCY_RADIO_BUTTON_GROUP.getfName(), Attachment2Pdf.ARO_RADIO_VALUE);
        } else if (type == Attachment2SponsorFormType.DOE) {
            setField(document, Attachment2Pdf.Field.SPONSOR_AGENCY_RADIO_BUTTON_GROUP.getfName(), Attachment2Pdf.OTHER_AGENCY_RADIO_VALUE);
        } else if (type == Attachment2SponsorFormType.EPA) {
            setField(document, Attachment2Pdf.Field.SPONSOR_AGENCY_RADIO_BUTTON_GROUP.getfName(), Attachment2Pdf.EPA_RADIO_VALUE);
        } else if (type == Attachment2SponsorFormType.NASA) {
            setField(document, Attachment2Pdf.Field.SPONSOR_AGENCY_RADIO_BUTTON_GROUP.getfName(), Attachment2Pdf.NASA_RADIO_VALUE);
        } else if (type == Attachment2SponsorFormType.NIH) {
            setField(document, Attachment2Pdf.Field.SPONSOR_AGENCY_RADIO_BUTTON_GROUP.getfName(), Attachment2Pdf.NIH_RADIO_VALUE);
        } else if (type == Attachment2SponsorFormType.NSF) {
            setField(document, Attachment2Pdf.Field.SPONSOR_AGENCY_RADIO_BUTTON_GROUP.getfName(), Attachment2Pdf.NSF_RADIO_VALUE);
        } else if (type == Attachment2SponsorFormType.ONR) {
            setField(document, Attachment2Pdf.Field.SPONSOR_AGENCY_RADIO_BUTTON_GROUP.getfName(), Attachment2Pdf.ONR_RADIO_VALUE);
        } else if (type == Attachment2SponsorFormType.USADA) {
            setField(document, Attachment2Pdf.Field.SPONSOR_AGENCY_RADIO_BUTTON_GROUP.getfName(), Attachment2Pdf.USDA_RADIO_VALUE);
        }
    }

    private void setDataSharingPubAccessPolicy(PDDocument document, SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo) {
        if (fromYN(templateInfo.getHumanFlag())) {
            if (HumanDataExchangeAgreement.SUBRECIPIENT_TO_PTE.getCode().equals(templateInfo.getHumanDataExchangeAgreeCd()) ||
                    HumanDataExchangeAgreement.PTE_TO_SUBRECIPIENT.getCode().equals(templateInfo.getHumanDataExchangeAgreeCd()) ||
                    HumanDataExchangeAgreement.FROM_BOTH_PTE_AND_SUBRECIPIENT.getCode().equals(templateInfo.getHumanDataExchangeAgreeCd())) {
                setField(document, Attachment2Pdf.Field.SUBRECIPIENT_AGREES_TO_COMPLY.getfName(), true);

                if (StringUtils.isNotBlank(templateInfo.getDataSharingAttachment())) {
                    setField(document, Attachment2Pdf.Field.DATA_SHARING_ATTACHMENT.getfName(), templateInfo.getDataSharingAttachment());
                }
            }
        }
    }

    private void setPromotingObjectivityFcio(PDDocument document, SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo, SubContractDataDocument.SubContractData.OtherConfigInfo configInfo, Attachment2SponsorFormType type) {
        setField(document, Attachment2Pdf.Field.FCOI_PTE.getfName(), FcioSubrecipientPolicy.PTE.getCode().equals(templateInfo.getFcioSubrecPolicyCd()));
        setField(document, Attachment2Pdf.Field.FCOI_SUBRECIPIENT.getfName(), FcioSubrecipientPolicy.SUBRECIPIENT.getCode().equals(templateInfo.getFcioSubrecPolicyCd()));

        if (type == Attachment2SponsorFormType.NIH) {
            setField(document, Attachment2Pdf.Field.SPONSOR_AGENCY.getfName(), configInfo.getFdpNihFCoiGuidance());
        } else if (type == Attachment2SponsorFormType.NSF) {
            setField(document, Attachment2Pdf.Field.SPONSOR_AGENCY.getfName(), configInfo.getFdpNsfFCoiGuidance());
        } else if (type == Attachment2SponsorFormType.NASA) {
            setField(document, Attachment2Pdf.Field.SPONSOR_AGENCY.getfName(), configInfo.getFdpNasaFCoiGuidance());
        } else if (type == Attachment2SponsorFormType.ONR) {
            setField(document, Attachment2Pdf.Field.SPONSOR_AGENCY.getfName(), configInfo.getFdpOnrFCoiGuidance());
        } else if (type == Attachment2SponsorFormType.ARO) {
            setField(document, Attachment2Pdf.Field.SPONSOR_AGENCY.getfName(), configInfo.getFdpAroFCoiGuidance());
        } else if (type == Attachment2SponsorFormType.AFOSR) {
            setField(document, Attachment2Pdf.Field.SPONSOR_AGENCY.getfName(), configInfo.getFdpAfosrFCoiGuidance());
        } else if (type == Attachment2SponsorFormType.EPA) {
            setField(document, Attachment2Pdf.Field.SPONSOR_AGENCY.getfName(), configInfo.getFdpEpaFCoiGuidance());
        } else if (type == Attachment2SponsorFormType.AMRMC) {
            setField(document, Attachment2Pdf.Field.SPONSOR_AGENCY.getfName(), configInfo.getFdpAmrmcFCoiGuidance());
        } else if (type == Attachment2SponsorFormType.AMRAA) {
            setField(document, Attachment2Pdf.Field.SPONSOR_AGENCY.getfName(), configInfo.getFdpAmraaFCoiGuidance());
        } else if (type == Attachment2SponsorFormType.USADA) {
            setField(document, Attachment2Pdf.Field.SPONSOR_AGENCY.getfName(), configInfo.getFdpUsdaFCoiGuidance());
        }

        setField(document, Attachment2Pdf.Field.FCOI_OTHER_SPONSOR_AGENCY.getfName(), "");
    }

    private void setHumanSubjectsDataExchangeTerms(PDDocument document, SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo) {
        if (fromYN(templateInfo.getHumanFlag()) && (HumanDataExchangeAgreement.SUBRECIPIENT_TO_PTE.getCode().equals(templateInfo.getHumanDataExchangeAgreeCd()) ||
                HumanDataExchangeAgreement.PTE_TO_SUBRECIPIENT.getCode().equals(templateInfo.getHumanDataExchangeAgreeCd()) ||
                HumanDataExchangeAgreement.FROM_BOTH_PTE_AND_SUBRECIPIENT.getCode().equals(templateInfo.getHumanDataExchangeAgreeCd()))) {
            setField(document, Attachment2Pdf.Field.HUMAN_SUBJECTS_DATA_TERMS_IN_ADD_TERMS.getfName(), HumanDataExchangeTerms.ADDITIONAL_TERMS.getCode().equals(templateInfo.getHumanDataExchangeTermsCd()));
            setField(document, Attachment2Pdf.Field.HUMAN_SUBJECTS_DATA_TERMS_SEP_AGREEMENT.getfName(), HumanDataExchangeTerms.SEPARATE_AGREEMENT.getCode().equals(templateInfo.getHumanDataExchangeTermsCd()));
        }
    }

    private void setAdditionalTerms(PDDocument document, SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo) {
        if (StringUtils.isNotBlank(templateInfo.getAdditionalTerms())) {
            setField(document, Attachment2Pdf.Field.HUMAN_SUBJECTS_DATA_ADD_TERMS_TEXT.getfName(), templateInfo.getAdditionalTerms());
        }
    }

    private void setHumanSubjectsDataExchange(PDDocument document, SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo) {
        if (fromYN(templateInfo.getHumanFlag())) {
            setField(document, Attachment2Pdf.Field.HUMAN_SUBJECTS_DATA_NOT_APPLICABLE.getfName(), HumanDataExchangeAgreement.NOT_APPLICABLE.getCode().equals(templateInfo.getHumanDataExchangeAgreeCd()));
            setField(document, Attachment2Pdf.Field.HUMAN_SUBJECTS_DATA_APPLICABLE.getfName(), HumanDataExchangeAgreement.SUBRECIPIENT_TO_PTE.getCode().equals(templateInfo.getHumanDataExchangeAgreeCd()) ||
                    HumanDataExchangeAgreement.PTE_TO_SUBRECIPIENT.getCode().equals(templateInfo.getHumanDataExchangeAgreeCd()) ||
                    HumanDataExchangeAgreement.FROM_BOTH_PTE_AND_SUBRECIPIENT.getCode().equals(templateInfo.getHumanDataExchangeAgreeCd()));

            setField(document, Attachment2Pdf.Field.HUMAN_SUBJECTS_DATA_SUB_TO_PTE.getfName(), HumanDataExchangeAgreement.SUBRECIPIENT_TO_PTE.getCode().equals(templateInfo.getHumanDataExchangeAgreeCd()) || HumanDataExchangeAgreement.FROM_BOTH_PTE_AND_SUBRECIPIENT.getCode().equals(templateInfo.getHumanDataExchangeAgreeCd()));
            setField(document, Attachment2Pdf.Field.HUMAN_SUBJECTS_DATA_PTE_TO_SUB.getfName(), HumanDataExchangeAgreement.PTE_TO_SUBRECIPIENT.getCode().equals(templateInfo.getHumanDataExchangeAgreeCd()) || HumanDataExchangeAgreement.FROM_BOTH_PTE_AND_SUBRECIPIENT.getCode().equals(templateInfo.getHumanDataExchangeAgreeCd()));
        }
    }

    private void setAnimalPteVerification(PDDocument document, SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo) {
        if (fromYN(templateInfo.getAnimalFlag())) {
            showField(document, Attachment2Pdf.Field.PTE_REQUIRES_VERIFICATON_LABEL.getfName());
            showField(document, Attachment2Pdf.Field.PTE_IACUC_LABEL.getfName());

            showField(document, Attachment2Pdf.Field.PTE_IACUC_UPON_REQUEST_LABEL.getfName());
            showField(document, Attachment2Pdf.Field.PTE_IACUC_UPON_REQUEST.getfName());
            setField(document, Attachment2Pdf.Field.PTE_IACUC_UPON_REQUEST.getfName(), PteSend.UPON_REQUEST.getCode().equals(templateInfo.getAnimalPteSendCd()));

            showField(document, Attachment2Pdf.Field.PTE_IACUC_PRIOR_LABEL.getfName());
            showField(document, Attachment2Pdf.Field.PTE_IACUC_PRIOR.getfName());
            setField(document, Attachment2Pdf.Field.PTE_IACUC_PRIOR.getfName(), PteSend.PRIOR_TO_EXECUTION.getCode().equals(templateInfo.getAnimalPteSendCd()));

            showField(document, Attachment2Pdf.Field.PTE_IACUC_PRIOR_ANNUAL_LABEL.getfName());
            showField(document, Attachment2Pdf.Field.PTE_IACUC_PRIOR_ANNUAL.getfName());
            setField(document, Attachment2Pdf.Field.PTE_IACUC_PRIOR_ANNUAL.getfName(), PteSend.PRIOR_TO_EXECUTION_AND_ANNUALLY.getCode().equals(templateInfo.getAnimalPteSendCd()));

            showField(document, Attachment2Pdf.Field.PTE_IACUC_NOT_REQUIRED_LABEL.getfName());
            showField(document, Attachment2Pdf.Field.PTE_IACUC_NOT_REQUIRED.getfName());
            setField(document, Attachment2Pdf.Field.PTE_IACUC_NOT_REQUIRED.getfName(), PteSend.NOT_REQUIRED.getCode().equals(templateInfo.getAnimalPteSendCd()));

            //Work Involving Humans or Animal Subjects (PTE requires verification - Animal section) - Not Required Reason
            if (PteSend.NOT_REQUIRED.getCode().equals(templateInfo.getAnimalPteSendCd())) {
                showField(document, Attachment2Pdf.Field.PTE_IACUC_NOT_REQUIRED_REASON.getfName());
                AnimalPteSendNotRequiredReason aReason = AnimalPteSendNotRequiredReason.fromCode(templateInfo.getAnimalPteNrCd());
                if (aReason != null) {
                    setField(document, Attachment2Pdf.Field.PTE_IACUC_NOT_REQUIRED_REASON.getfName(), aReason.getDescription());
                }
            }
        }
    }

    private void setHumanPteVerification(PDDocument document, SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo) {
        if (fromYN(templateInfo.getHumanFlag())) {
            showField(document, Attachment2Pdf.Field.PTE_REQUIRES_VERIFICATON_LABEL.getfName());
            showField(document, Attachment2Pdf.Field.PTE_IRB_LABEL.getfName());

            showField(document, Attachment2Pdf.Field.PTE_IRB_UPON_REQUEST_LABEL.getfName());
            showField(document, Attachment2Pdf.Field.PTE_IRB_UPON_REQUEST.getfName());
            setField(document, Attachment2Pdf.Field.PTE_IRB_UPON_REQUEST.getfName(), PteSend.UPON_REQUEST.getCode().equals(templateInfo.getHumanPteSendCd()));

            showField(document, Attachment2Pdf.Field.PTE_IRB_PRIOR_LABEL.getfName());
            showField(document, Attachment2Pdf.Field.PTE_IRB_PRIOR.getfName());
            setField(document, Attachment2Pdf.Field.PTE_IRB_PRIOR.getfName(), PteSend.PRIOR_TO_EXECUTION.getCode().equals(templateInfo.getHumanPteSendCd()));

            showField(document, Attachment2Pdf.Field.PTE_IRB_PRIOR_ANNUAL_LABEL.getfName());
            showField(document, Attachment2Pdf.Field.PTE_IRB_PRIOR_ANNUAL.getfName());
            setField(document, Attachment2Pdf.Field.PTE_IRB_PRIOR_ANNUAL.getfName(), PteSend.PRIOR_TO_EXECUTION_AND_ANNUALLY.getCode().equals(templateInfo.getHumanPteSendCd()));

            showField(document, Attachment2Pdf.Field.PTE_IRB_NOT_REQUIRED_LABEL.getfName());
            showField(document, Attachment2Pdf.Field.PTE_IRB_NOT_REQUIRED.getfName());
            setField(document, Attachment2Pdf.Field.PTE_IRB_NOT_REQUIRED.getfName(), PteSend.NOT_REQUIRED.getCode().equals(templateInfo.getHumanPteSendCd()));

            //Work Involving Humans or Animal Subjects (PTE requires verification - Human section) - Not Required Reason
            if (PteSend.NOT_REQUIRED.getCode().equals(templateInfo.getHumanPteSendCd())) {
                showField(document, Attachment2Pdf.Field.PTE_IRB_NOT_REQUIRED_REASON.getfName());
                final HumanPteSendNotRequiredReason hReason = HumanPteSendNotRequiredReason.fromCode(templateInfo.getHumanPteNrCd());
                if (hReason != null) {
                    setField(document, Attachment2Pdf.Field.PTE_IRB_NOT_REQUIRED_REASON.getfName(), hReason.getDescription());
                }
            }
        }
    }

    private void setHumanAnimalSubjects(PDDocument document, SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo) {
        setField(document, Attachment2Pdf.Field.HUMAN_SUBJECTS_CHECKBOX.getfName(), fromYN(templateInfo.getHumanFlag()));
        setField(document, Attachment2Pdf.Field.ANIMAL_SUBJECTS_CHECKBOX.getfName(), fromYN(templateInfo.getAnimalFlag()));
        setField(document, Attachment2Pdf.Field.NO_HUMAN_ANIMAL_SUBJECTS_CHECKBOX.getfName(), !fromYN(templateInfo.getAnimalFlag()) && !fromYN(templateInfo.getHumanFlag()));
    }

    private void setStcAutoCarryForward(PDDocument document, SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo) {
        setField(document, Attachment2Pdf.Field.AUTOMATIC_CARRYFORWARD_YES_CHECKBOX.getfName(), fromYN(templateInfo.getAutomaticCarryForward()));
        setField(document, Attachment2Pdf.Field.AUTOMATIC_CARRYFORWARD_NO_CHECKBOX.getfName(), !fromYN(templateInfo.getAutomaticCarryForward()));
        if (!fromYN(templateInfo.getAutomaticCarryForward())) {
            if (ADMIN_CONTACT_TYPE_CODE_1.equals(templateInfo.getCarryForwardRequestsSentTo()) || ADMIN_CONTACT_TYPE_CODE_2.equals(templateInfo.getCarryForwardRequestsSentTo())) {
                setField(document, Attachment2Pdf.Field.CONTACT_FOR_CARRYFORWARD.getfName(), Attachment2Pdf.CF_CONTACT_ADMINISTRATIVE_CONTACT_VALUE);
            } else if (FIN_CONTACT_TYPE_CODE.equals(templateInfo.getCarryForwardRequestsSentTo())) {
                setField(document, Attachment2Pdf.Field.CONTACT_FOR_CARRYFORWARD.getfName(), Attachment2Pdf.CF_CONTACT_FINANCIAL_CONTACT_VALUE);
            } else if (PI_TYPE_CODE.equals(templateInfo.getCarryForwardRequestsSentTo())) {
                setField(document, Attachment2Pdf.Field.CONTACT_FOR_CARRYFORWARD.getfName(), Attachment2Pdf.CF_CONTACT_PI_VALUE);
            } else if (AUTH_OFFICIAL_TYPE_CODE.equals(templateInfo.getCarryForwardRequestsSentTo())) {
                setField(document, Attachment2Pdf.Field.CONTACT_FOR_CARRYFORWARD.getfName(), Attachment2Pdf.CF_CONTACT_AUTHORIZED_OFFICIAL_VALUE);
            }
        }
    }

    private void setStcCopyrights(PDDocument document, SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo) {
        setField(document, Attachment2Pdf.Field.COPYRIGHTS_SUBRECIPIENT_GRANTS_CHECKBOX.getfName(), COPYRIGHTS_GRANT_CODE.equals(templateInfo.getCopyRights()));
        setField(document, Attachment2Pdf.Field.COPYRIGHTS_SUBRECIPIENT_SHALL_GRANT_CHECKBOX.getfName(), COPYRIGHTS_SHALL_GRANT_CODE.equals(templateInfo.getCopyRights()));
    }

    private void setMpiInfo(PDDocument document, SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo, Attachment2SponsorFormType type) {
        toggleFieldVisibility(document, Attachment2Pdf.Field.MPI_SECTION_LABEL.getfName(), type != Attachment2SponsorFormType.NIH);
        toggleFieldVisibility(document, Attachment2Pdf.Field.MPI_AWARD_CHECKBOX.getfName(), type != Attachment2SponsorFormType.NIH);
        toggleFieldVisibility(document, Attachment2Pdf.Field.MPI_AWARD_LABEL.getfName(), type != Attachment2SponsorFormType.NIH);
        toggleFieldVisibility(document, Attachment2Pdf.Field.NOT_MPI_AWARD_LABEL.getfName(), type != Attachment2SponsorFormType.NIH);
        toggleFieldVisibility(document, Attachment2Pdf.Field.NOT_MPI_AWARD_CHECKBOX.getfName(), type != Attachment2SponsorFormType.NIH);
        if (type == Attachment2SponsorFormType.NIH) {
            setField(document, Attachment2Pdf.Field.NOT_MPI_AWARD_CHECKBOX.getfName(), !fromYN(templateInfo.getMpiAward()));
            setField(document, Attachment2Pdf.Field.MPI_AWARD_CHECKBOX.getfName(), fromYN(templateInfo.getMpiAward()));

            if (fromYN(templateInfo.getMpiAward())) {
                showField(document, Attachment2Pdf.Field.MPI_AWARD_LEADERSHIP_PLAN.getfName());

                final MpiLeadershipPlan mpiLeadershipPlan = MpiLeadershipPlan.fromCode(templateInfo.getMpiLeadershipPlan());
                if (mpiLeadershipPlan != null) {
                    setField(document, Attachment2Pdf.Field.MPI_AWARD_LEADERSHIP_PLAN.getfName(), mpiLeadershipPlan.getDescription());
                }
            }
        }
    }

    private void setGenTermsAndConditions(PDDocument document, SubContractDataDocument.SubContractData.OtherConfigInfo configInfo, SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo, Attachment2SponsorFormType type) {
        //General Terms and Conditions
        if (type == Attachment2SponsorFormType.NIH) {
            setGenTermsAndConditions1To4(document, configInfo.getFdpNihPolicy(), configInfo.getFdpNihGrantsPolicyStatement(), configInfo.getFdpNihInterimResearchTerms(), configInfo.getFdpNihAgencyRequirements());
        } else if (type == Attachment2SponsorFormType.NSF) {
            setGenTermsAndConditions1To4(document, configInfo.getFdpNsfPolicy(), configInfo.getFdpNsfGrantsPolicyStatement(), configInfo.getFdpNsfInterimResearchTerms(), configInfo.getFdpNsfAgencyRequirements());
        } else if (type == Attachment2SponsorFormType.NASA) {
            setGenTermsAndConditions1To4(document, configInfo.getFdpNasaPolicy(), configInfo.getFdpNasaGrantsPolicyStatement(), configInfo.getFdpNasaInterimResearchTerms(), configInfo.getFdpNasaAgencyRequirements());
        } else if (type == Attachment2SponsorFormType.ONR) {
            setGenTermsAndConditions1To4(document, configInfo.getFdpOnrPolicy(), configInfo.getFdpOnrGrantsPolicyStatement(), configInfo.getFdpOnrInterimResearchTerms(), configInfo.getFdpOnrAgencyRequirements());
        } else if (type == Attachment2SponsorFormType.ARO) {
            setGenTermsAndConditions1To4(document, configInfo.getFdpAroPolicy(), configInfo.getFdpAroGrantsPolicyStatement(), configInfo.getFdpAroInterimResearchTerms(), configInfo.getFdpAroAgencyRequirements());
        } else if (type == Attachment2SponsorFormType.AFOSR) {
            setGenTermsAndConditions1To4(document, configInfo.getFdpAfosrPolicy(), configInfo.getFdpAfosrGrantsPolicyStatement(), configInfo.getFdpAfosrInterimResearchTerms(), configInfo.getFdpAfosrAgencyRequirements());
        } else if (type == Attachment2SponsorFormType.EPA) {
            setGenTermsAndConditions1To4(document, configInfo.getFdpEpaPolicy(), configInfo.getFdpEpaGrantsPolicyStatement(), configInfo.getFdpEpaInterimResearchTerms(), configInfo.getFdpEpaAgencyRequirements());
        } else if (type == Attachment2SponsorFormType.AMRMC) {
            setGenTermsAndConditions1To4(document, configInfo.getFdpAmrmcPolicy(), configInfo.getFdpAmrmcGrantsPolicyStatement(), configInfo.getFdpAmrmcInterimResearchTerms(), configInfo.getFdpAmrmcAgencyRequirements());
        } else if (type == Attachment2SponsorFormType.AMRAA) {
            setGenTermsAndConditions1To4(document, configInfo.getFdpAmraaPolicy(), configInfo.getFdpAmraaGrantsPolicyStatement(), configInfo.getFdpAmraaInterimResearchTerms(), configInfo.getFdpAmraaAgencyRequirements());
        } else if (type == Attachment2SponsorFormType.USADA) {
            setGenTermsAndConditions1To4(document, configInfo.getFdpUsdaPolicy(), configInfo.getFdpUsdaGrantsPolicyStatement(), configInfo.getFdpUsdaInterimResearchTerms(), configInfo.getFdpUsdaAgencyRequirements());
        }

        if (fromYN(templateInfo.getTreatmentPrgmIncomeAdditive())) {
            setField(document, Attachment2Pdf.Field.TREATMENT_OF_PROGRAM_INCOME.getfName(), Attachment2Pdf.TPI_ADDITIVE_VALUE);
        } else {
            setField(document, Attachment2Pdf.Field.TREATMENT_OF_PROGRAM_INCOME.getfName(), Attachment2Pdf.TPI_OTHER_VALUE);

            if (StringUtils.isNotBlank(templateInfo.getTreatmentOfIncome())) {
                setField(document, Attachment2Pdf.Field.TREATMENT_OF_PROGRAM_INCOME_OTHER_SPECIFY.getfName(), templateInfo.getTreatmentOfIncome());
            }
        }
    }

    private void setGenTermsAndConditions1To4(PDDocument document, String policy, String policyStatement, String terms, String requirements) {
        setField(document, Attachment2Pdf.Field.FEDERAL_AWARD_CONDITIONS.getfName(), policy);
        setField(document, Attachment2Pdf.Field.GRANTS_POLICY_STATEMENT.getfName(), policyStatement);
        setField(document, Attachment2Pdf.Field.INTERIM_RES_TERMS_COND.getfName(), terms);
        setField(document, Attachment2Pdf.Field.REQUIREMENTS.getfName(), requirements);
    }

    private void setRequiredDataElements(PDDocument document) {
        //Required Data Elements
        hideField(document, Attachment2Pdf.Field.FEDERAL_AWARD_ISSUE_DATE.getfName());
        hideField(document, Attachment2Pdf.Field.FEDERAL_AWARD_ISSUE_DATE_LABEL.getfName());
        hideField(document, Attachment2Pdf.Field.FAIN.getfName());
        hideField(document, Attachment2Pdf.Field.FAIN_LABEL.getfName());
        hideField(document, Attachment2Pdf.Field.CFDA_NO.getfName());
        hideField(document, Attachment2Pdf.Field.CFDA_NO_LABEL.getfName());
        hideField(document, Attachment2Pdf.Field.CFDA_TITLE.getfName());
        hideField(document, Attachment2Pdf.Field.CFDA_TITLE_LABEL.getfName());
        setField(document, Attachment2Pdf.Field.COPY_OF_AWARD_NOTICE.getfName(), true);
    }

    private void setHeaderInformation(PDDocument document, SubContractDataDocument.SubContractData.SubcontractDetail subcontractDetail) {
        setField(document, Attachment2Pdf.Field.SUBAWARD_NUMBER.getfName(), subcontractDetail.getFsrsSubawardNumber());
    }

    @Override
    public Map<String, byte[]> sortPdfForms(Map<String, byte[]> forms) {
        final TreeMap<String, byte[]> sorted = new TreeMap<>(Comparator.comparing(FORM_ORDER::indexOf));
       sorted.putAll(forms);
       return sorted;
    }

    private boolean fromYN(String s) {
        return "Y".equals(s);
    }

    private String formatDate(Date date) {
        return new SimpleDateFormat(MM_DD_YYYY).format(date);
    }

    private enum AgreementForm {
        FDP_AGREEMENT("FDP Template");

        private final String id;

        AgreementForm(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }

    static final class AgreementPdf {

        enum Field {
            FEDERAL_AWARDING_AGENCY("FederalAwardingAgency", Collections.emptySet()),
            PASS_THROUGH_ENTITY("PassThroughEntityPTE", Collections.emptySet()),
            PTE_PI("PTEPI", Collections.emptySet()),
            PTE_FEDERAL_AWARD_NO("PTEFederalAwardNo", Collections.emptySet()),
            SUBRECIPIENT("SubrecipientEntityName", Collections.emptySet()),
            SUB_PI("SubPI", Collections.emptySet()),
            SUBAWARD_NO("SubawardNumber", Collections.emptySet()),
            PROJECT_TITLE("ProjectTitle", Collections.emptySet()),
            POP_START("POPStart", Collections.emptySet()),
            POP_END("POPEnd", Collections.emptySet()),
            PROJECT_START("ProjectStart", Collections.emptySet()),
            PROJECT_END("ProjectEnd", Collections.emptySet()),
            AMOUNT_FUNDED_THIS_ACTION("AmountFundedThisAction", Collections.emptySet()),
            INCREMENTALLY_ESTIMATED_TOTAL("IncrementallyEstimatedTotal", Collections.emptySet()),
            TERM_2_CONTACT("Term2Contact", Collections.emptySet()),
            TERM_3_CONTACT("Term3Contact", Collections.emptySet()),
            PROJECT_BUDGET_INVOICE_DROPDOWN("ProjectBudgetInvoiceDrop", Stream.of(PROJECT_PERIOD_END_DATE_VALUE, BUDGET_PERIOD_END_DATE_VALUE).collect(Collectors.toSet())),
            TERM_6_CONTACT("Term6Contact", Collections.emptySet()),
            UNI_BI_MOD_DROPOWN("UniBiModDrop", Stream.of(UNILATERALLY_VALUE, BILATERALLY_VALUE).collect(Collectors.toSet())),
            TERM_7_CONTACT("Term7Contact", Collections.emptySet()),
            TERM_9_CONTACT("Term9Contact", Collections.emptySet());

            private String fName;
            private Set<String> values;

            Field(String fName, Set<String> values) {
                this.fName = fName;
                this.values = values;
            }

            public String getfName() {
                return fName;
            }

            public Set<String> getValues() {
                return values;
            }
        }

        private static final String BUDGET_PERIOD_END_DATE_VALUE = "Budget Period end date.";
        private static final String PROJECT_PERIOD_END_DATE_VALUE = "Project Period end date.";

        private static final String UNILATERALLY_VALUE = "Unilaterally";
        private static final String BILATERALLY_VALUE = "Bilaterally";

        private AgreementPdf() {
            throw new UnsupportedOperationException("do not call");
        }
    }

    private enum Attachment2Form {
        FDP_AFOSR("FDP_AFOSR", Attachment2SponsorFormType.AFOSR), FDP_AMRMC("FDP_AMRMC", Attachment2SponsorFormType.AMRMC), FDP_AMRAA("FDP_AMRAA", Attachment2SponsorFormType.AMRAA), FDP_ARO("FDP_ARO", Attachment2SponsorFormType.ARO), FDP_DOE("FDP_DOE", Attachment2SponsorFormType.DOE), FDP_EPA("FDP_EPA", Attachment2SponsorFormType.EPA), FDP_NASA("FDP_NASA", Attachment2SponsorFormType.NASA), FDP_NIH("FDP_NIH", Attachment2SponsorFormType.NIH), FDP_NSF("FDP_NSF", Attachment2SponsorFormType.NSF), FDP_ONR("FDP_ONR", Attachment2SponsorFormType.ONR), FDP_USDA("FDP_USDA", Attachment2SponsorFormType.USADA);

        private final String id;
        private final Attachment2SponsorFormType sponsorFormType;

        Attachment2Form(String id, Attachment2SponsorFormType sponsorFormType) {
            this.id = id;
            this.sponsorFormType = sponsorFormType;
        }

        public String getId() {
            return id;
        }

        public Attachment2SponsorFormType getSponsorFormType() {
            return sponsorFormType;
        }
    }

    private enum Attachment2SponsorFormType {
        AFOSR, AMRMC, AMRAA, ARO, DOE, EPA, NASA, NIH, NSF, ONR, USADA
    }

    static final class Attachment2Pdf {

        enum Field {

            COPYRIGHTS_SUBRECIPIENT_SHALL_GRANT_CHECKBOX("Copyrights (Select One)_1_12QhOgj8LqbT2o3C3AEg*g", Collections.emptySet()),
            PTE_IRB_UPON_REQUEST_LABEL("IRBUR", Collections.emptySet()),
            FEDERAL_AWARD_ISSUE_DATE_LABEL("FAID1", Collections.emptySet()),
            FEDERAL_AWARD_ISSUE_DATE("FAID", Collections.emptySet()),
            FAIN("FAIN", Collections.emptySet()),
            FAIN_LABEL("FAIN1", Collections.emptySet()),
            CFDA_NO("CFDA No", Collections.emptySet()),
            CFDA_NO_LABEL("CFDA No1", Collections.emptySet()),
            CFDA_TITLE("CFDA Title", Collections.emptySet()),
            CFDA_TITLE_LABEL("CFDA Title1", Collections.emptySet()),
            COPY_OF_AWARD_NOTICE("SelectOneData", Collections.emptySet()),
            SUBAWARD_NUMBER("Subaward Number", Collections.emptySet()),
            SPONSOR_AGENCY_RADIO_BUTTON_GROUP("Group1", Stream.of(AFOSR_RADIO_VALUE, 
                    AMRMC_RADIO_VALUE, 
                    AMRAA_RADIO_VALUE,
                    ARO_RADIO_VALUE,
                    OTHER_AGENCY_RADIO_VALUE,
                    EPA_RADIO_VALUE,
                    NASA_RADIO_VALUE,
                    NIH_RADIO_VALUE,
                    NSF_RADIO_VALUE,
                    ONR_RADIO_VALUE,
                    USDA_RADIO_VALUE).collect(Collectors.toSet())),
            COPYRIGHTS_SUBRECIPIENT_GRANTS_CHECKBOX("Copyrights (Select One)_0_12QhOgj8LqbT2o3C3AEg*g", Collections.emptySet()),
            MPI_SECTION_LABEL("MPI", Collections.emptySet()),
            MPI_AWARD_LABEL("MPI5", Collections.emptySet()),
            NOT_MPI_AWARD_LABEL("MPI6", Collections.emptySet()),
            MPI_AWARD_CHECKBOX("MPI4", Collections.emptySet()),
            NOT_MPI_AWARD_CHECKBOX("MPI7", Collections.emptySet()),
            MPI_AWARD_LEADERSHIP_PLAN("MPISelect1", Stream.of(MpiLeadershipPlan.values())
                    .map(MpiLeadershipPlan::getDescription)
                    .collect(Collectors.toSet())),
            AUTOMATIC_CARRYFORWARD_NO_CHECKBOX("CF", Collections.emptySet()),
            AUTOMATIC_CARRYFORWARD_YES_CHECKBOX("CF0", Collections.emptySet()),
            CONTACT_FOR_CARRYFORWARD("Contact for carryforward",
                    Stream.of(CF_CONTACT_ADMINISTRATIVE_CONTACT_VALUE,
                            CF_CONTACT_FINANCIAL_CONTACT_VALUE,
                            CF_CONTACT_PI_VALUE,
                            CF_CONTACT_AUTHORIZED_OFFICIAL_VALUE)
                            .collect(Collectors.toSet())),
            ANIMAL_SUBJECTS_CHECKBOX("AS", Collections.emptySet()),
            HUMAN_SUBJECTS_CHECKBOX("HS", Collections.emptySet()),
            NO_HUMAN_ANIMAL_SUBJECTS_CHECKBOX("HSASNotApplicable", Collections.emptySet()),
            PTE_REQUIRES_VERIFICATON_LABEL("HSASLang2", Collections.emptySet()),
            PTE_IRB_LABEL("IRB3", Collections.emptySet()),
            PTE_IACUC_LABEL("IACUC3", Collections.emptySet()),
            PTE_IACUC_UPON_REQUEST_LABEL("IACUCUR", Collections.emptySet()),
            PTE_IRB_PRIOR_LABEL("IRBPrior", Collections.emptySet()),
            PTE_IACUC_PRIOR_LABEL("IACUCPrior", Collections.emptySet()),
            PTE_IRB_PRIOR_ANNUAL_LABEL("IRBPriorAnnual", Collections.emptySet()),
            PTE_IACUC_PRIOR_ANNUAL_LABEL("IACUCPriorAnnual", Collections.emptySet()),
            PTE_IRB_NOT_REQUIRED_LABEL("IRBNR", Collections.emptySet()),
            PTE_IACUC_NOT_REQUIRED_LABEL("IACUCNR", Collections.emptySet()),
            PTE_IRB_UPON_REQUEST("IRBUR1", Collections.emptySet()),
            PTE_IRB_PRIOR("IRBPrior1", Collections.emptySet()),
            PTE_IRB_PRIOR_ANNUAL("IRBPriorAnnual1", Collections.emptySet()),
            PTE_IRB_NOT_REQUIRED("IRBNR1", Collections.emptySet()),
            PTE_IRB_NOT_REQUIRED_REASON("IRBNotRequired", Stream.of(HumanPteSendNotRequiredReason.values())
                    .map(HumanPteSendNotRequiredReason::getDescription)
                    .collect(Collectors.toSet())),
            PTE_IACUC_UPON_REQUEST("IACUCUR1", Collections.emptySet()),
            PTE_IACUC_PRIOR("IACUCPrior1", Collections.emptySet()),
            PTE_IACUC_PRIOR_ANNUAL("IACUCPriorAnnual1", Collections.emptySet()),
            PTE_IACUC_NOT_REQUIRED("IACUCNR1", Collections.emptySet()),
            PTE_IACUC_NOT_REQUIRED_REASON("IACUCNotRequired", Stream.of(AnimalPteSendNotRequiredReason.values())
                    .map(AnimalPteSendNotRequiredReason::getDescription)
                    .collect(Collectors.toSet())),
            SUBRECIPIENT_AGREES_TO_COMPLY("Check if Applicable_cYoRavTcXUVY66PpYVNBLw", Collections.emptySet()),
            DATA_SHARING_ATTACHMENT("Att", Collections.emptySet()),
            HUMAN_SUBJECTS_DATA_NOT_APPLICABLE("HSNotApplicable", Collections.emptySet()),
            HUMAN_SUBJECTS_DATA_APPLICABLE("HSApplicable", Collections.emptySet()),
            HUMAN_SUBJECTS_DATA_SUB_TO_PTE("HSSubtoPTE", Collections.emptySet()),
            HUMAN_SUBJECTS_DATA_PTE_TO_SUB("HSPTEtoSub", Collections.emptySet()),
            HUMAN_SUBJECTS_DATA_TERMS_IN_ADD_TERMS("HSAddTerms", Collections.emptySet()),
            HUMAN_SUBJECTS_DATA_TERMS_SEP_AGREEMENT("HSSeparateAgmt", Collections.emptySet()),
            HUMAN_SUBJECTS_DATA_ADD_TERMS_TEXT("Additional terms", Collections.emptySet()),
            FCOI_PTE("FCOI_PTE", Collections.emptySet()),
            FCOI_SUBRECIPIENT("FCOI_Sub", Collections.emptySet()),
            FCOI_OTHER_SPONSOR_AGENCY("FCOIOtherSponsor", Collections.emptySet()),
            SPONSOR_AGENCY("SponsorAgency", Collections.emptySet()),
            FEDERAL_AWARD_CONDITIONS("FederalAwardConditions", Collections.emptySet()),
            GRANTS_POLICY_STATEMENT("GrantsPolicyStatement", Collections.emptySet()),
            INTERIM_RES_TERMS_COND("IntRTCs", Collections.emptySet()),
            REQUIREMENTS("RTCs", Collections.emptySet()),
            TREATMENT_OF_PROGRAM_INCOME("_6_  Treatment of Program Inco_nwAbuWIn0JWsW9e68RWN8A", Stream.of(TPI_ADDITIVE_VALUE, TPI_OTHER_VALUE, TPI_OFF_VALUE).collect(Collectors.toSet())),
            TREATMENT_OF_PROGRAM_INCOME_OTHER_SPECIFY("Program Income", Collections.emptySet());

            private String fName;
            private Set<String> values;
            
            Field(String fName, Set<String> values) {
                this.fName = fName;
                this.values = values;
            }

            public String getfName() {
                return fName;
            }

            public Set<String> getValues() {
                return values;
            }
        }
        
        private static final String AFOSR_RADIO_VALUE = "AFOSR";
        private static final String AMRMC_RADIO_VALUE = "AMRMC";
        private static final String AMRAA_RADIO_VALUE = "AMRAA";
        private static final String ARO_RADIO_VALUE = "ARO";
        private static final String OTHER_AGENCY_RADIO_VALUE = "Other Agency";
        private static final String EPA_RADIO_VALUE = "EPA";
        private static final String NASA_RADIO_VALUE = "NASA";
        private static final String NIH_RADIO_VALUE = "NIH";
        private static final String NSF_RADIO_VALUE = "NSF";
        private static final String ONR_RADIO_VALUE = "ONR";
        private static final String USDA_RADIO_VALUE = "USDA";
        
        private static final String CF_CONTACT_ADMINISTRATIVE_CONTACT_VALUE = "Administrative Contact";
        private static final String CF_CONTACT_FINANCIAL_CONTACT_VALUE = "Financial Contact";
        private static final String CF_CONTACT_PI_VALUE = "Principal Investigator (PI)";
        private static final String CF_CONTACT_AUTHORIZED_OFFICIAL_VALUE = "Authorized Official";

        private static final String TPI_ADDITIVE_VALUE = "Additive";
        private static final String TPI_OTHER_VALUE = "Other, Pass-through Entity specify alternative from NIH Agreement";
        private static final String TPI_OFF_VALUE = "Off";

        private Attachment2Pdf() {
            throw new UnsupportedOperationException("do not call");
        }
    }
}
