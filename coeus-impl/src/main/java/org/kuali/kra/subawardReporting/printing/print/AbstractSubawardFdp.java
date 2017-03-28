package org.kuali.kra.subawardReporting.printing.print;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.xmlbeans.XmlObject;
import org.kuali.coeus.common.framework.print.AbstractPrint;
import org.kuali.coeus.common.framework.print.PrintingException;
import org.kuali.coeus.sys.framework.util.CollectionUtils;
import org.kuali.coeus.sys.framework.util.PdfBoxUtils;
import org.kuali.kra.subaward.bo.*;
import org.kuali.kra.subaward.printing.schema.SubContractDataDocument;
import org.kuali.kra.subaward.reporting.printing.SubAwardPrintType;
import org.kuali.kra.subaward.reporting.printing.service.SubAwardPrintingService;
import org.springframework.core.io.Resource;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.kuali.coeus.sys.framework.util.CollectionUtils.entriesToMap;
import static org.kuali.coeus.sys.framework.util.CollectionUtils.entry;
import static org.kuali.coeus.sys.framework.util.PdfBoxUtils.*;

public abstract class AbstractSubawardFdp extends AbstractPrint {

    private static final String FDP_AFOSR_FORM = "FDP_AFOSR";
    private static final String FDP_AMRMC_FORM = "FDP_AMRMC";
    private static final String FDP_ARO_FORM = "FDP_ARO";
    private static final String FDP_DOE_FORM = "FDP_DOE";
    private static final String FDP_EPA_FORM = "FDP_EPA";
    private static final String FDP_NASA_FORM = "FDP_NASA";
    private static final String FDP_NIH_FORM = "FDP_NIH";
    private static final String FDP_NSF_FORM = "FDP_NSF";
    private static final String FDP_ONR_FORM = "FDP_ONR";
    private static final String FDP_USDA_FORM = "FDP_USDA";

    private static final String COPYRIGHTS_GRANT_CODE = "1";
    private static final String COPYRIGHTS_SHALL_GRANT_CODE = "2";

    private static final String ADMIN_CONTACT_TYPE_CODE_1 = "13";
    private static final String ADMIN_CONTACT_TYPE_CODE_2 = "22";
    private static final String FIN_CONTACT_TYPE_CODE = "38";
    private static final String PI_TYPE_CODE = "?";
    private static final String AUTH_OFFICIAL_TYPE_CODE = "37";

    private static final String FDP_AGREEMENT = "FDP Template";
    private static final String FDP_MODIFICATION = "FDP Modification";

    private Map<String, Resource> pdfForms;

    @Override
    public Map<String,Source> getXSLTemplateWithBookmarks() {
        return getSelectedTemplates().stream()
                .map(s -> CollectionUtils.<String, Source>entry(s.getFormId(), new StreamSource(new ByteArrayInputStream(s.getAttachmentContent()))))
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

                    final boolean afosrForm = FDP_AFOSR_FORM.equals(e.getKey());
                    final boolean amrmcForm = FDP_AMRMC_FORM.equals(e.getKey());
                    final boolean aroForm = FDP_ARO_FORM.equals(e.getKey());
                    final boolean doeForm = FDP_DOE_FORM.equals(e.getKey());
                    final boolean epaForm = FDP_EPA_FORM.equals(e.getKey());
                    final boolean nasaForm = FDP_NASA_FORM.equals(e.getKey());
                    final boolean nihForm = FDP_NIH_FORM.equals(e.getKey());
                    final boolean nsfForm = FDP_NSF_FORM.equals(e.getKey());
                    final boolean onrForm = FDP_ONR_FORM.equals(e.getKey());
                    final boolean usdaForm = FDP_USDA_FORM.equals(e.getKey());

                    final SubContractDataDocument.SubContractData.SubcontractDetail subcontractDetail = xmlObject.getSubContractData().getSubcontractDetail();
                    final SubContractDataDocument.SubContractData.OtherConfigInfo configInfo = xmlObject.getSubContractData().getOtherConfigInfoArray(0);
                    final SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo = xmlObject.getSubContractData().getSubcontractTemplateInfoArray(0);

                    //Sponsor Agency
                    setSponsorAgency(document, afosrForm, amrmcForm, aroForm, doeForm, epaForm, nasaForm, nihForm, nsfForm, onrForm, usdaForm);
                    setHeaderInformation(document, subcontractDetail);
                    setRequiredDataElements(document);
                    setGenTermsAndConditions(document, configInfo, nihForm, nsfForm);
                    setMpiInfo(document, templateInfo, nihForm);
                    setStcCopyrights(document, templateInfo);
                    setStcAutoCarryForward(document, templateInfo);
                    setHumanAnimalSubjects(document, templateInfo);
                    setHumanPteVerification(document, templateInfo);
                    setAnimalPteVerification(document, templateInfo);
                    setHumanSubjectsDataExchange(document, templateInfo);
                    setHumanSubjectsDataExchangeTerms(document, templateInfo);
                    setPromotingObjectivityFcio(document, templateInfo, configInfo, nihForm, nsfForm);
                    setDataSharingPubAccessPolicy(document, templateInfo);
                }

                PdfBoxUtils.flatten(document);
                document.save(out);
                return entry(e.getKey(), out.toByteArray());
            } catch (IOException e1) {
                throw new PrintingException(e1);
            }
        }).collect(entriesToMap());
    }

    private void setSponsorAgency(PDDocument document, boolean afosrForm, boolean amrmcForm, boolean aroForm, boolean doeForm, boolean epaForm, boolean nasaForm, boolean nihForm, boolean nsfForm, boolean onrForm, boolean usdaForm) {
        if (afosrForm) {
            setField(document, Pdf.Field.SPONSOR_AGENCY_RADIO_BUTTON_GROUP.getfName(), Pdf.AFOSR_RADIO_VALUE);
        } else if (amrmcForm) {
            setField(document, Pdf.Field.SPONSOR_AGENCY_RADIO_BUTTON_GROUP.getfName(), Pdf.AMRMC_RADIO_VALUE);
        } else if (aroForm) {
            setField(document, Pdf.Field.SPONSOR_AGENCY_RADIO_BUTTON_GROUP.getfName(), Pdf.ARO_RADIO_VALUE);
        } else if (doeForm) {
            setField(document, Pdf.Field.SPONSOR_AGENCY_RADIO_BUTTON_GROUP.getfName(), Pdf.OTHER_AGENCY_RADIO_VALUE);
        } else if (epaForm) {
            setField(document, Pdf.Field.SPONSOR_AGENCY_RADIO_BUTTON_GROUP.getfName(), Pdf.EPA_RADIO_VALUE);
        } else if (nasaForm) {
            setField(document, Pdf.Field.SPONSOR_AGENCY_RADIO_BUTTON_GROUP.getfName(), Pdf.NASA_RADIO_VALUE);
        } else if (nihForm) {
            setField(document, Pdf.Field.SPONSOR_AGENCY_RADIO_BUTTON_GROUP.getfName(), Pdf.NIH_RADIO_VALUE);
        } else if (nsfForm) {
            setField(document, Pdf.Field.SPONSOR_AGENCY_RADIO_BUTTON_GROUP.getfName(), Pdf.NSF_RADIO_VALUE);
        } else if (onrForm) {
            setField(document, Pdf.Field.SPONSOR_AGENCY_RADIO_BUTTON_GROUP.getfName(), Pdf.ONR_RADIO_VALUE);
        } else if (usdaForm) {
            setField(document, Pdf.Field.SPONSOR_AGENCY_RADIO_BUTTON_GROUP.getfName(), Pdf.USDA_RADIO_VALUE);
        }
    }

    private void setDataSharingPubAccessPolicy(PDDocument document, SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo) {
        if (fromYN(templateInfo.getHumanFlag())) {
            if (HumanDataExchangeAgreement.APPLICABLE.getCode().equals(templateInfo.getHumanDataExchangeAgreeCd())) {
                setField(document, Pdf.Field.SUBRECIPIENT_AGREES_TO_COMPLY.getfName(), true);
            }
        }
    }

    private void setPromotingObjectivityFcio(PDDocument document, SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo, SubContractDataDocument.SubContractData.OtherConfigInfo configInfo, boolean nihForm, boolean nsfForm) {
        setField(document, Pdf.Field.FCOI_PTE.getfName(), FcioSubrecipientPolicy.PTE.getCode().equals(templateInfo.getFcioSubrecPolicyCd()));
        setField(document, Pdf.Field.FCOI_SUBRECIPIENT.getfName(), FcioSubrecipientPolicy.SUBRECIPIENT.getCode().equals(templateInfo.getFcioSubrecPolicyCd()));

        if (nihForm) {
            setField(document, Pdf.Field.SPONSOR_AGENCY.getfName(), configInfo.getFdpNihFCoiGuidance());
        } else if (nsfForm) {
            setField(document, Pdf.Field.SPONSOR_AGENCY.getfName(), configInfo.getFdpNsfFCoiGuidance());
        }

        setField(document, Pdf.Field.FCOI_OTHER_SPONSOR_AGENCY.getfName(), "");
    }

    private void setHumanSubjectsDataExchangeTerms(PDDocument document, SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo) {
        setField(document, Pdf.Field.HUMAN_SUBJECTS_DATA_TERMS_IN_ADD_TERMS.getfName(), HumanDataExchangeTerms.ADDITIONAL_TERMS.getCode().equals(templateInfo.getHumanDataExchangeTermsCd()));
        setField(document, Pdf.Field.HUMAN_SUBJECTS_DATA_TERMS_SEP_AGREEMENT.getfName(), HumanDataExchangeTerms.SEPARATE_AGREEMENT.getCode().equals(templateInfo.getHumanDataExchangeTermsCd()));
    }

    private void setHumanSubjectsDataExchange(PDDocument document, SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo) {
        setField(document, Pdf.Field.HUMAN_SUBJECTS_DATA_NOT_APPLICABLE.getfName(), HumanDataExchangeAgreement.NOT_APPLICABLE.getCode().equals(templateInfo.getHumanDataExchangeAgreeCd()));
        setField(document, Pdf.Field.HUMAN_SUBJECTS_DATA_APPLICABLE.getfName(), HumanDataExchangeAgreement.APPLICABLE.getCode().equals(templateInfo.getHumanDataExchangeAgreeCd()));
        setField(document, Pdf.Field.HUMAN_SUBJECTS_DATA_SUB_TO_PTE.getfName(), HumanDataExchangeAgreement.SUBRECIPIENT_TO_PTE.getCode().equals(templateInfo.getHumanDataExchangeAgreeCd()));
        setField(document, Pdf.Field.HUMAN_SUBJECTS_DATA_PTE_TO_SUB.getfName(), HumanDataExchangeAgreement.PTE_TO_SUBRECIPIENT.getCode().equals(templateInfo.getHumanDataExchangeAgreeCd()));
    }

    private void setAnimalPteVerification(PDDocument document, SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo) {
        if (fromYN(templateInfo.getAnimalFlag())) {
            showField(document, Pdf.Field.PTE_REQUIRES_VERIFICATON_LABEL.getfName());
            showField(document, Pdf.Field.PTE_IACUC_LABEL.getfName());

            showField(document, Pdf.Field.PTE_IACUC_UPON_REQUEST_LABEL.getfName());
            showField(document, Pdf.Field.PTE_IACUC_UPON_REQUEST.getfName());
            setField(document, Pdf.Field.PTE_IACUC_UPON_REQUEST.getfName(), PteSend.UPON_REQUEST.getCode().equals(templateInfo.getAnimalPteSendCd()));

            showField(document, Pdf.Field.PTE_IACUC_PRIOR_LABEL.getfName());
            showField(document, Pdf.Field.PTE_IACUC_PRIOR.getfName());
            setField(document, Pdf.Field.PTE_IACUC_PRIOR.getfName(), PteSend.PRIOR_TO_EXECUTION.getCode().equals(templateInfo.getAnimalPteSendCd()));

            showField(document, Pdf.Field.PTE_IACUC_PRIOR_ANNUAL_LABEL.getfName());
            showField(document, Pdf.Field.PTE_IACUC_PRIOR_ANNUAL.getfName());
            setField(document, Pdf.Field.PTE_IACUC_PRIOR_ANNUAL.getfName(), PteSend.PRIOR_TO_EXECUTION_AND_ANNUALLY.getCode().equals(templateInfo.getAnimalPteSendCd()));

            showField(document, Pdf.Field.PTE_IACUC_NOT_REQUIRED_LABEL.getfName());
            showField(document, Pdf.Field.PTE_IACUC_NOT_REQUIRED.getfName());
            setField(document, Pdf.Field.PTE_IACUC_NOT_REQUIRED.getfName(), PteSend.NOT_REQUIRED.getCode().equals(templateInfo.getAnimalPteSendCd()));

            //Work Involving Humans or Animal Subjects (PTE requires verification - Animal section) - Not Required Reason
            if (PteSend.NOT_REQUIRED.getCode().equals(templateInfo.getAnimalPteSendCd())) {
                showField(document, Pdf.Field.PTE_IACUC_NOT_REQUIRED_REASON.getfName());
                AnimalPteSendNotRequiredReason aReason = AnimalPteSendNotRequiredReason.fromCode(templateInfo.getAnimalPteNrCd());
                if (aReason != null) {
                    setField(document, Pdf.Field.PTE_IACUC_NOT_REQUIRED_REASON.getfName(), aReason.getDescription());
                }
            }
        }
    }

    private void setHumanPteVerification(PDDocument document, SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo) {
        if (fromYN(templateInfo.getHumanFlag())) {
            showField(document, Pdf.Field.PTE_REQUIRES_VERIFICATON_LABEL.getfName());
            showField(document, Pdf.Field.PTE_IRB_LABEL.getfName());

            showField(document, Pdf.Field.PTE_IRB_UPON_REQUEST_LABEL.getfName());
            showField(document, Pdf.Field.PTE_IRB_UPON_REQUEST.getfName());
            setField(document, Pdf.Field.PTE_IRB_UPON_REQUEST.getfName(), PteSend.UPON_REQUEST.getCode().equals(templateInfo.getHumanPteSendCd()));

            showField(document, Pdf.Field.PTE_IRB_PRIOR_LABEL.getfName());
            showField(document, Pdf.Field.PTE_IRB_PRIOR.getfName());
            setField(document, Pdf.Field.PTE_IRB_PRIOR.getfName(), PteSend.PRIOR_TO_EXECUTION.getCode().equals(templateInfo.getHumanPteSendCd()));

            showField(document, Pdf.Field.PTE_IRB_PRIOR_ANNUAL_LABEL.getfName());
            showField(document, Pdf.Field.PTE_IRB_PRIOR_ANNUAL.getfName());
            setField(document, Pdf.Field.PTE_IRB_PRIOR_ANNUAL.getfName(), PteSend.PRIOR_TO_EXECUTION_AND_ANNUALLY.getCode().equals(templateInfo.getHumanPteSendCd()));

            showField(document, Pdf.Field.PTE_IRB_NOT_REQUIRED_LABEL.getfName());
            showField(document, Pdf.Field.PTE_IRB_NOT_REQUIRED.getfName());
            setField(document, Pdf.Field.PTE_IRB_NOT_REQUIRED.getfName(), PteSend.NOT_REQUIRED.getCode().equals(templateInfo.getHumanPteSendCd()));

            //Work Involving Humans or Animal Subjects (PTE requires verification - Human section) - Not Required Reason
            if (PteSend.NOT_REQUIRED.getCode().equals(templateInfo.getHumanPteSendCd())) {
                showField(document, Pdf.Field.PTE_IRB_NOT_REQUIRED_REASON.getfName());
                final HumanPteSendNotRequiredReason hReason = HumanPteSendNotRequiredReason.fromCode(templateInfo.getHumanPteNrCd());
                if (hReason != null) {
                    setField(document, Pdf.Field.PTE_IRB_NOT_REQUIRED_REASON.getfName(), hReason.getDescription());
                }
            }
        }
    }

    private void setHumanAnimalSubjects(PDDocument document, SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo) {
        setField(document, Pdf.Field.HUMAN_SUBJECTS_CHECKBOX.getfName(), fromYN(templateInfo.getHumanFlag()));
        setField(document, Pdf.Field.ANIMAL_SUBJECTS_CHECKBOX.getfName(), fromYN(templateInfo.getAnimalFlag()));
        setField(document, Pdf.Field.NO_HUMAN_ANIMAL_SUBJECTS_CHECKBOX.getfName(), !fromYN(templateInfo.getAnimalFlag()) && !fromYN(templateInfo.getHumanFlag()));
    }

    private void setStcAutoCarryForward(PDDocument document, SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo) {
        setField(document, Pdf.Field.AUTOMATIC_CARRYFORWARD_YES_CHECKBOX.getfName(), fromYN(templateInfo.getAutomaticCarryForward()));
        setField(document, Pdf.Field.AUTOMATIC_CARRYFORWARD_NO_CHECKBOX.getfName(), !fromYN(templateInfo.getAutomaticCarryForward()));
        if (!fromYN(templateInfo.getAutomaticCarryForward())) {
            if (ADMIN_CONTACT_TYPE_CODE_1.equals(templateInfo.getCarryForwardRequestsSentTo()) || ADMIN_CONTACT_TYPE_CODE_2.equals(templateInfo.getCarryForwardRequestsSentTo())) {
                setField(document, Pdf.Field.CONTACT_FOR_CARRYFORWARD.getfName(), Pdf.CF_CONTACT_ADMINISTRATIVE_CONTACT_VALUE);
            } else if (FIN_CONTACT_TYPE_CODE.equals(templateInfo.getCarryForwardRequestsSentTo())) {
                setField(document, Pdf.Field.CONTACT_FOR_CARRYFORWARD.getfName(), Pdf.CF_CONTACT_FINANCIAL_CONTACT_VALUE);
            } else if (PI_TYPE_CODE.equals(templateInfo.getCarryForwardRequestsSentTo())) {
                setField(document, Pdf.Field.CONTACT_FOR_CARRYFORWARD.getfName(), Pdf.CF_CONTACT_PI_VALUE);
            } else if (AUTH_OFFICIAL_TYPE_CODE.equals(templateInfo.getCarryForwardRequestsSentTo())) {
                setField(document, Pdf.Field.CONTACT_FOR_CARRYFORWARD.getfName(), Pdf.CF_CONTACT_AUTHORIZED_OFFICIAL_VALUE);
            }
        }
    }

    private void setStcCopyrights(PDDocument document, SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo) {
        setField(document, Pdf.Field.COPYRIGHTS_SUBRECIPIENT_GRANTS_CHECKBOX.getfName(), COPYRIGHTS_GRANT_CODE.equals(templateInfo.getCopyRights()));
        setField(document, Pdf.Field.COPYRIGHTS_SUBRECIPIENT_SHALL_GRANT_CHECKBOX.getfName(), COPYRIGHTS_SHALL_GRANT_CODE.equals(templateInfo.getCopyRights()));
    }

    private void setMpiInfo(PDDocument document, SubContractDataDocument.SubContractData.SubcontractTemplateInfo templateInfo, boolean nihForm) {
        toggleFieldVisibility(document, Pdf.Field.MPI_SECTION_LABEL.getfName(), !nihForm);
        toggleFieldVisibility(document, Pdf.Field.MPI_AWARD_CHECKBOX.getfName(), !nihForm);
        toggleFieldVisibility(document, Pdf.Field.MPI_AWARD_LABEL.getfName(), !nihForm);
        toggleFieldVisibility(document, Pdf.Field.NOT_MPI_AWARD_LABEL.getfName(), !nihForm);
        toggleFieldVisibility(document, Pdf.Field.NOT_MPI_AWARD_CHECKBOX.getfName(), !nihForm);
        if (nihForm) {
            setField(document, Pdf.Field.NOT_MPI_AWARD_CHECKBOX.getfName(), !fromYN(templateInfo.getMpiAward()));
            setField(document, Pdf.Field.MPI_AWARD_CHECKBOX.getfName(), fromYN(templateInfo.getMpiAward()));

            if (fromYN(templateInfo.getMpiAward())) {
                showField(document, Pdf.Field.MPI_AWARD_LEADERSHIP_PLAN.getfName());

                final MpiLeadershipPlan mpiLeadershipPlan = MpiLeadershipPlan.fromCode(templateInfo.getMpiLeadershipPlan());
                if (mpiLeadershipPlan != null) {
                    setField(document, Pdf.Field.MPI_AWARD_LEADERSHIP_PLAN.getfName(), mpiLeadershipPlan.getDescription());
                }
            }
        }
    }

    private void setGenTermsAndConditions(PDDocument document, SubContractDataDocument.SubContractData.OtherConfigInfo configInfo, boolean nihForm, boolean nsfForm) {
        //General Terms and Conditions
        if (nihForm) {
            setField(document, Pdf.Field.FEDERAL_AWARD_CONDITIONS.getfName(), configInfo.getFdpNihPolicy());
            setField(document, Pdf.Field.GRANTS_POLICY_STATEMENT.getfName(), configInfo.getFdpNihGrantsPolicyStatement());
            setField(document, Pdf.Field.INTERIM_RES_TERMS_COND.getfName(), configInfo.getFdpNihInterimResearchTerms());
            setField(document, Pdf.Field.REQUIREMENTS.getfName(), configInfo.getFdpNihAgencyRequirements());
        } else if (nsfForm) {
            setField(document, Pdf.Field.FEDERAL_AWARD_CONDITIONS.getfName(), configInfo.getFdpNsfPolicy());
            setField(document, Pdf.Field.GRANTS_POLICY_STATEMENT.getfName(), configInfo.getFdpNsfGrantsPolicyStatement());
            setField(document, Pdf.Field.INTERIM_RES_TERMS_COND.getfName(), configInfo.getFdpNsfInterimResearchTerms());
            setField(document, Pdf.Field.REQUIREMENTS.getfName(), configInfo.getFdpNsfAgencyRequirements());
        }
    }

    private void setRequiredDataElements(PDDocument document) {
        //Required Data Elements
        hideField(document, Pdf.Field.FEDERAL_AWARD_ISSUE_DATE.getfName());
        hideField(document, Pdf.Field.FEDERAL_AWARD_ISSUE_DATE_LABEL.getfName());
        hideField(document, Pdf.Field.FAIN.getfName());
        hideField(document, Pdf.Field.FAIN_LABEL.getfName());
        hideField(document, Pdf.Field.CFDA_NO.getfName());
        hideField(document, Pdf.Field.CFDA_NO_LABEL.getfName());
        hideField(document, Pdf.Field.CFDA_TITLE.getfName());
        hideField(document, Pdf.Field.CFDA_TITLE_LABEL.getfName());
        setField(document, Pdf.Field.COPY_OF_AWARD_NOTICE.getfName(), true);
    }

    private void setHeaderInformation(PDDocument document, SubContractDataDocument.SubContractData.SubcontractDetail subcontractDetail) {
        setField(document, Pdf.Field.SUBAWARD_NUMBER.getfName(), subcontractDetail.getPONumber());
    }

    @Override
    public Map<String, byte[]> sortPdfForms(Map<String, byte[]> forms) {
       final TreeMap<String, byte[]> sorted = new TreeMap<>((o1, o2) -> {
           if (Objects.equals(o1, o2)) {
               return 0;
           }

           if (FDP_AGREEMENT.equals(o1) || FDP_MODIFICATION.equals(o1)) {
               return -1;
           }

           if (FDP_AGREEMENT.equals(o2) || FDP_MODIFICATION.equals(o2)) {
               return 1;
           }

           return Objects.compare(o1, o2, String::compareTo);
       });

       sorted.putAll(forms);
       return sorted;
    }

    private boolean fromYN(String s) {
        return "Y".equals(s);
    }

    static final class Pdf {

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
            HUMAN_SUBJECTS_DATA_NOT_APPLICABLE("HSNotApplicable", Collections.emptySet()),
            HUMAN_SUBJECTS_DATA_APPLICABLE("HSApplicable", Collections.emptySet()),
            HUMAN_SUBJECTS_DATA_SUB_TO_PTE("HSSubtoPTE", Collections.emptySet()),
            HUMAN_SUBJECTS_DATA_PTE_TO_SUB("HSPTEtoSub", Collections.emptySet()),
            HUMAN_SUBJECTS_DATA_TERMS_IN_ADD_TERMS("HSAddTerms", Collections.emptySet()),
            HUMAN_SUBJECTS_DATA_TERMS_SEP_AGREEMENT("HSSeparateAgmt", Collections.emptySet()),
            FCOI_PTE("FCOI_PTE", Collections.emptySet()),
            FCOI_SUBRECIPIENT("FCOI_Sub", Collections.emptySet()),
            FCOI_OTHER_SPONSOR_AGENCY("FCOIOtherSponsor", Collections.emptySet()),
            SPONSOR_AGENCY("SponsorAgency", Collections.emptySet()),
            FEDERAL_AWARD_CONDITIONS("FederalAwardConditions", Collections.emptySet()),
            GRANTS_POLICY_STATEMENT("GrantsPolicyStatement", Collections.emptySet()),
            INTERIM_RES_TERMS_COND("IntRTCs", Collections.emptySet()),
            REQUIREMENTS("RTCs", Collections.emptySet());
            
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
        
        private Pdf() {
            throw new UnsupportedOperationException("do not call");
        }
    }
}
