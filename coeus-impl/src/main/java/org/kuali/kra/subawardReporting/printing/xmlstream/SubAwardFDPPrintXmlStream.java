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
package org.kuali.kra.subawardReporting.printing.xmlstream;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.XmlObject;
import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.common.framework.org.Organization;
import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.coeus.common.framework.person.KcPersonService;
import org.kuali.coeus.common.framework.print.stream.xml.XmlStream;
import org.kuali.coeus.common.framework.rolodex.Rolodex;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.contacts.AwardPerson;
import org.kuali.kra.award.home.ContactType;
import org.kuali.kra.award.home.ContactUsage;
import org.kuali.kra.award.printing.schema.AwardHeaderType;
import org.kuali.kra.award.printing.schema.AwardType;
import org.kuali.kra.award.printing.schema.AwardType.AwardDetails;
import org.kuali.kra.award.printing.schema.AwardType.AwardDetails.OtherHeaderDetails;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.subaward.bo.*;
import org.kuali.kra.subaward.printing.schema.OrganizationType;
import org.kuali.kra.subaward.printing.schema.PersonDetailsType;
import org.kuali.kra.subaward.printing.schema.RolodexDetailsType;
import org.kuali.kra.subaward.printing.schema.SubContractDataDocument;
import org.kuali.kra.subaward.printing.schema.SubContractDataDocument.SubContractData;
import org.kuali.kra.subaward.printing.schema.SubContractDataDocument.SubContractData.*;
import org.kuali.kra.subaward.reporting.printing.SubAwardPrintType;
import org.kuali.kra.subaward.reporting.printing.service.SubAwardPrintingService;
import org.kuali.rice.core.api.config.property.ConfigurationService;
import org.kuali.rice.core.api.datetime.DateTimeService;
import org.kuali.rice.coreservice.framework.parameter.ParameterConstants;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.location.api.country.Country;
import org.kuali.rice.location.api.country.CountryService;
import org.kuali.rice.location.api.state.State;
import org.kuali.rice.location.api.state.StateService;

import java.math.BigDecimal;
import java.util.*;



public class SubAwardFDPPrintXmlStream implements XmlStream  {
    private static final String ORGANIZATION_ID = "organizationId";
    private static final String FDP_ORG_FROM_REQUISITIONER_UNIT = "FDP_ORG_FROM_REQUISITIONER_UNIT";
    public static final String CONTACT_TYPE_CODE = "contactTypeCode";
    public static final String AWARD_NUMBER = "awardNumber";
    public static final String ROLE_CODE = "roleCode";
    public static final String PRINCIPAL_INVESTIGATOR = "PI";
    public static final String SEQUENCE_NUMBER = "sequenceNumber";
    public static final String ROLODEX_ID = "rolodexId";
    public static final String AWARD_TITLE = "awardTitle";
    public static final String SPONSOR_AWARD_NUMBER = "sponsorAwardNumber";
    public static final String SPONSOR_NAME = "sponsorName";
    public static final String CFDA_NUMBER = "cfdaNumber";
    public static final String MODIFICATION_TYPE = "modificationType";
    public static final String FCOI = "fcoi";
    public static final String FAIN = "fain";
    public static final String FFATA = "ffata";
    public static final String RANDD = "randd";
    public static final String COSTSHARE = "costshare";
    public static final String PRIME_SPONSOR_NAME = "primeSponsorName";
    public static final String NOTICE_DATE = "noticeDate";
    public static final String OBLIGATED_TOTAL = "obligatedTotal";
    public static final String ANTICIPATED_TOTAL = "anticipatedTotal";
    public static final String SUB_AWARD_REPORT_TYPE_CODE = "subAwardReportTypeCode";
    public static final String INVOICES_EMAILED = "invoicesEmailed";
    public static final String INVOICE_ADDRESS_DIFFERENT = "invoiceAddressDifferent";
    public static final String INVOICE_EMAIL_DIFFERENT = "invoiceEmailDifferent";
    public static final String FDP_PTE_INVOICE_EMAIL = "FDP_PTE_Invoice_email";
    public static final String FDP_PTE_INVOICE_ADDRESS = "FDP_PTE_Invoice_address";
    private static final String FDP_NIH_POLICY = "FDP_NIH_Policy";
    private static final String FDP_NIH_GRANTS_POLICY_STATEMENT = "FDP_NIH_Grants_Policy_Statement";
    private static final String FDP_NIH_INTERIM_RESEARCH_TERMS = "FDP_NIH_Interim_Research_Terms";
    private static final String FDP_NIH_AGENCY_REQUIREMENTS = "FDP_NIH_Agency_Requirements";
    private static final String FDP_NIH_FCOI_GUIDANCE = "FDP_NIH_FCOI_Guidance";
    private static final String FDP_NSF_POLICY = "FDP_NSF_Policy";
    private static final String FDP_NSF_GRANTS_POLICY_STATEMENT = "FDP_NSF_Grants_Policy_Statement";
    private static final String FDP_NSF_INTERIM_RESEARCH_TERMS = "FDP_NSF_Interim_Research_Terms";
    private static final String FDP_NSF_AGENCY_REQUIREMENTS = "FDP_NSF_Agency_Requirements";
    private static final String FDP_NSF_FCOI_GUIDANCE = "FDP_NSF_FCOI_Guidance";

    private BusinessObjectService businessObjectService;
    private CountryService countryService;
    private StateService stateService;
    private ConfigurationService configurationService;

    private String awardNumber;
    private String awardTitle;
    private String sponsorAwardNumber;
    private String sponsorName;
    private String cfdaNumber;
    private String fain;
    private String modificationType;
    private Boolean fcoi;
    private Boolean ffata;
    private Boolean randd;
    private Boolean costshare;
    private Boolean invoicesEmailed;
    private Boolean invoiceAddressDifferent;
    private Boolean invoiceEmailDifferent;
    private String primeSponsorName;
    private Calendar noticeDate;
    private BigDecimal obligatedTotal;
    private BigDecimal anticipatedTotal;
    private List<SubAwardForms> sponsorTemplates;
    private ParameterService parameterService;

    @Override
    @SuppressWarnings("unchecked")
    public Map<String, XmlObject> generateXmlStream(KcPersistableBusinessObjectBase printableBusinessObject,
                                                    Map<String, Object> reportParameters) {

        this.awardNumber=(String) reportParameters.get(AWARD_NUMBER);
        this.awardTitle=(String) reportParameters.get(AWARD_TITLE);
        this.sponsorAwardNumber=(String) reportParameters.get(SPONSOR_AWARD_NUMBER);
        this.sponsorName=(String) reportParameters.get(SPONSOR_NAME);
        this.cfdaNumber=(String) reportParameters.get(CFDA_NUMBER);
        this.sponsorTemplates = (List<SubAwardForms>) reportParameters.get(SubAwardPrintingService.SELECTED_TEMPLATES);
        this.modificationType = (String) reportParameters.get(MODIFICATION_TYPE);
        this.fcoi = (Boolean) reportParameters.get(FCOI);
        this.fain = (String) reportParameters.get(FAIN);
        this.ffata = (Boolean) reportParameters.get(FFATA);
        this.randd = (Boolean) reportParameters.get(RANDD);
        this.costshare = (Boolean) reportParameters.get(COSTSHARE);
        this.invoicesEmailed = (Boolean) reportParameters.get(INVOICES_EMAILED);
        this.invoiceAddressDifferent = (Boolean) reportParameters.get(INVOICE_ADDRESS_DIFFERENT);
        this.invoiceEmailDifferent = (Boolean) reportParameters.get(INVOICE_EMAIL_DIFFERENT);
        this.primeSponsorName = (String) reportParameters.get(PRIME_SPONSOR_NAME);
        this.noticeDate = (Calendar) reportParameters.get(NOTICE_DATE);
        this.obligatedTotal = (BigDecimal) reportParameters.get(OBLIGATED_TOTAL);
        this.anticipatedTotal = (BigDecimal) reportParameters.get(ANTICIPATED_TOTAL);

        final SubAward subaward=(SubAward) printableBusinessObject;
        final SubContractData subContractData = SubContractData.Factory.newInstance();

        setOtherConfigInfo(subContractData);

        setSubcontractTemplateInfo(subContractData,subaward);
        setFundingSource(subContractData);
        setSubcontractDetail(subContractData,subaward);
        setSubcontractAmountInfo(subContractData,subaward);
        setAwardHeader(subContractData);
        setPrimeRecipientContacts(subContractData,subaward);
        setPrintRequirement(subContractData);
        setPrimeAdministrativeContact(subContractData,subaward);
        setPrimePrincipalInvestigator(subContractData);
        setPrimeFinancialContact(subContractData,subaward);
        setPrimeAuthorizedOfficial(subContractData,subaward);
        setAdministrativeContact(subContractData,subaward);
        setFinancialContact(subContractData,subaward);
        setAuthorizedOfficial(subContractData,subaward);
        setSubcontractReports(subContractData,subaward);

        final SubContractDataDocument subContractDataDoc = SubContractDataDocument.Factory.newInstance();
        subContractDataDoc.setSubContractData(subContractData);


        final Map<String, XmlObject> xmlObjectList = new LinkedHashMap<>();
        xmlObjectList.put(SubAwardPrintType.SUB_AWARD_FDP_TEMPLATE.getSubAwardPrintType(), subContractDataDoc);
        return xmlObjectList;
    }

    public void setOtherConfigInfo(SubContractData subContractData) {
        final OtherConfigInfo otherConfigInfo = OtherConfigInfo.Factory.newInstance();
        final List<OtherConfigInfo> otherConfigInfoList = new ArrayList<>();

        otherConfigInfo.setFdpNihPolicy(getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD,
                ParameterConstants.DOCUMENT_COMPONENT,
                FDP_NIH_POLICY));
        otherConfigInfo.setFdpNihGrantsPolicyStatement(getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD,
                ParameterConstants.DOCUMENT_COMPONENT,
                FDP_NIH_GRANTS_POLICY_STATEMENT));
        otherConfigInfo.setFdpNihInterimResearchTerms(getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD,
                ParameterConstants.DOCUMENT_COMPONENT,
                FDP_NIH_INTERIM_RESEARCH_TERMS));
        otherConfigInfo.setFdpNihAgencyRequirements(getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD,
                ParameterConstants.DOCUMENT_COMPONENT,
                FDP_NIH_AGENCY_REQUIREMENTS));
        otherConfigInfo.setFdpNihFCoiGuidance(getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD,
                ParameterConstants.DOCUMENT_COMPONENT,
                FDP_NIH_FCOI_GUIDANCE));

        otherConfigInfo.setFdpNsfPolicy(getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD,
                ParameterConstants.DOCUMENT_COMPONENT,
                FDP_NSF_POLICY));
        otherConfigInfo.setFdpNsfGrantsPolicyStatement(getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD,
                ParameterConstants.DOCUMENT_COMPONENT,
                FDP_NSF_GRANTS_POLICY_STATEMENT));
        otherConfigInfo.setFdpNsfInterimResearchTerms(getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD,
                ParameterConstants.DOCUMENT_COMPONENT,
                FDP_NSF_INTERIM_RESEARCH_TERMS));
        otherConfigInfo.setFdpNsfAgencyRequirements(getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD,
                ParameterConstants.DOCUMENT_COMPONENT,
                FDP_NSF_AGENCY_REQUIREMENTS));
        otherConfigInfo.setFdpNsfFCoiGuidance(getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD,
                ParameterConstants.DOCUMENT_COMPONENT,
                FDP_NSF_FCOI_GUIDANCE));

        otherConfigInfoList.add(otherConfigInfo);
        subContractData.setOtherConfigInfoArray(otherConfigInfoList.toArray(new OtherConfigInfo[0]));
    }

    public void setSubcontractTemplateInfo(SubContractData subContractData, SubAward subaward) {
        SubcontractTemplateInfo subContractTemplateInfo = SubcontractTemplateInfo.Factory.newInstance();
        List<SubcontractTemplateInfo> templateDataList = new ArrayList<>();

        SubAwardTemplateInfo subawardTemplate;
        if(subaward.getSubAwardTemplateInfo() != null && !subaward.getSubAwardTemplateInfo().isEmpty()) {
            subawardTemplate = subaward.getSubAwardTemplateInfo().get(0);

            Collection<ContactType> contact = getBusinessObjectService().findAll(ContactType.class);
            for(ContactType contactType : contact){
                if(subawardTemplate.getInvoiceOrPaymentContact()!= null && contactType.getContactTypeCode().equals(subawardTemplate.getInvoiceOrPaymentContact().toString())) {
                    subContractTemplateInfo.setInvoiceOrPaymentContactDescription(contactType.getDescription());
                }
                if(subawardTemplate.getFinalStmtOfCostscontact()!=null && contactType.getContactTypeCode().equals(subawardTemplate.getFinalStmtOfCostscontact().toString())) {
                    subContractTemplateInfo.setFinalStmtOfCostsContactDescription(contactType.getDescription());
                }
                if(subawardTemplate.getChangeRequestsContact()!= null && contactType.getContactTypeCode().equals(subawardTemplate.getChangeRequestsContact().toString())) {
                    subContractTemplateInfo.setChangeRequestsContactDescription(contactType.getDescription());
                }
                if(subawardTemplate.getTerminationContact()!= null && contactType.getContactTypeCode().equals(subawardTemplate.getTerminationContact().toString())) {
                    subContractTemplateInfo.setTerminationContactDescription(contactType.getDescription());
                }
                if(subawardTemplate.getNoCostExtensionContact() != null && contactType.getContactTypeCode().equals(subawardTemplate.getNoCostExtensionContact().toString())) {
                    subContractTemplateInfo.setNoCostExtensionContactDescription(contactType.getDescription());
                }
            }
            subContractTemplateInfo.setSowOrSubProposalBudget(subawardTemplate.getSowOrSubProposalBudget());
            subContractTemplateInfo.setExemptFromRprtgExecComp(subawardTemplate.getExemptFromRprtgExecComp());
            subContractTemplateInfo.setSubRegisteredInCcr(subawardTemplate.getSubRegisteredInCcr());

            if(subawardTemplate.getPerfSiteDiffFromOrgAddr() != null){
                subContractTemplateInfo.setPerfSiteDiffFromOrgAddr(subawardTemplate.getPerfSiteDiffFromOrgAddr());
            }
            if(subawardTemplate.getPerfSiteSameAsSubPiAddr() != null){
                subContractTemplateInfo.setPerfSiteSameAsSubPiAddr(subawardTemplate.getPerfSiteSameAsSubPiAddr());
            }
            if(subawardTemplate.getSubProposalDate() != null) {
                subContractTemplateInfo.setSubProposalDate(getDateTimeService().getCalendar(subawardTemplate.getSubProposalDate()));
            }

            if(subawardTemplate.getParentDunsNumber() != null) {
                subContractTemplateInfo.setParentDunsNumber(subawardTemplate.getParentDunsNumber());
            }
            if(subawardTemplate.getParentCongressionalDistrict() != null) {
                subContractTemplateInfo.setParentCongressionalDistrict(subawardTemplate.getParentCongressionalDistrict());
            }
            if(subawardTemplate.getCopyRightType() != null) {
                subContractTemplateInfo.setCopyRights(subawardTemplate.getCopyRightType().toString());
            }
            if(subawardTemplate.getAutomaticCarryForward() != null) {
                subContractTemplateInfo.setAutomaticCarryForward(subawardTemplate.getAutomaticCarryForward());
            }
            if(subawardTemplate.getTreatmentPrgmIncomeAdditive() != null) {
                subContractTemplateInfo.setTreatmentPrgmIncomeAdditive(subawardTemplate.getTreatmentPrgmIncomeAdditive());
            }
            if(subawardTemplate.getApplicableProgramRegulations() != null) {
                subContractTemplateInfo.setApplicableProgramRegulations(subawardTemplate.getApplicableProgramRegulations());
            }
            if(subawardTemplate.getApplicableProgramRegsDate() != null) {
                subContractTemplateInfo.setApplicableProgramRegsDate(getDateTimeService().getCalendar(subawardTemplate.getApplicableProgramRegsDate()));
            }
            if(subawardTemplate.getCarryForwardRequestsSentTo() != null) {
                ContactType contactTypeCode = getBusinessObjectService().findBySinglePrimaryKey(ContactType.class, subawardTemplate.getCarryForwardRequestsSentTo());
                if(contactTypeCode.getDescription() != null) {
                    subContractTemplateInfo.setCarryForwardRequestsSentToDescription(contactTypeCode.getDescription());
                    subContractTemplateInfo.setCarryForwardRequestsSentTo(contactTypeCode.getContactTypeCode());
                }

            }

            subContractTemplateInfo.setRAndD(toFlag(subawardTemplate.getrAndD()));
            subContractTemplateInfo.setIncludesCostSharing(toFlag(subawardTemplate.getIncludesCostSharing()));
            subContractTemplateInfo.setFcio(toFlag(subawardTemplate.getFcio()));
            subContractTemplateInfo.setInvoicesEmailed(toFlag(subawardTemplate.getInvoicesEmailed()));
            subContractTemplateInfo.setInvoiceAddressDifferent(toFlag(subawardTemplate.getInvoiceAddressDifferent()));

            if (subawardTemplate.getFcioSubrecPolicyCd() != null) {
                subContractTemplateInfo.setFcioSubrecPolicyCd(subawardTemplate.getFcioSubrecPolicyCd());
            }

            subContractTemplateInfo.setAnimalFlag(toFlag(subawardTemplate.getAnimalFlag()));

            if (subawardTemplate.getAnimalPteSendCd() != null) {
                subContractTemplateInfo.setAnimalPteSendCd(subawardTemplate.getAnimalPteSendCd());
            }

            if (subawardTemplate.getAnimalPteNrCd() != null) {
                subContractTemplateInfo.setAnimalPteNrCd(subawardTemplate.getAnimalPteNrCd());
            }

            subContractTemplateInfo.setHumanFlag(toFlag(subawardTemplate.getHumanFlag()));

            if (subawardTemplate.getHumanPteSendCd() != null) {
                subContractTemplateInfo.setHumanPteSendCd(subawardTemplate.getHumanPteSendCd());
            }

            if (subawardTemplate.getHumanPteNrCd() != null) {
                subContractTemplateInfo.setHumanPteNrCd(subawardTemplate.getHumanPteNrCd());
            }

            if (subawardTemplate.getHumanDataExchangeAgreeCd() != null) {
                subContractTemplateInfo.setHumanDataExchangeAgreeCd(subawardTemplate.getHumanDataExchangeAgreeCd());
            }

            if (subawardTemplate.getHumanDataExchangeTermsCd() != null) {
                subContractTemplateInfo.setHumanDataExchangeTermsCd(subawardTemplate.getHumanDataExchangeTermsCd());
            }

            subContractTemplateInfo.setMpiAward(toFlag(subawardTemplate.getMpiAward()));

            if (subawardTemplate.getMpiLeadershipPlan() != null) {
                subContractTemplateInfo.setMpiLeadershipPlan(subawardTemplate.getMpiLeadershipPlan());
            }

            templateDataList.add(subContractTemplateInfo);
        }
        subContractData.setSubcontractTemplateInfoArray(templateDataList.toArray(new SubcontractTemplateInfo[0]));
    }

    public void setFundingSource(SubContractData subContractData) {
        FundingSource fundingSource = FundingSource.Factory.newInstance();
        List<FundingSource> fundingSourceList = new ArrayList<>();
        fundingSource.setAwardNumber(awardNumber);
        fundingSource.setSponsor(sponsorName);
        fundingSourceList.add(fundingSource);
        subContractData.setFundingSourceArray(fundingSourceList.toArray(new FundingSource[0]));
    }

    public void setSubcontractDetail(SubContractData subContractData, SubAward subaward) {
        SubcontractDetail subcontractDetail = SubcontractDetail.Factory.newInstance();
        RolodexDetailsType rolodexDetails = RolodexDetailsType.Factory.newInstance();
        RolodexDetailsType rolodexDetailsType = RolodexDetailsType.Factory.newInstance();
        OrganizationType organisation =OrganizationType.Factory.newInstance();
        if(subaward.getRolodex() != null ){
            subcontractDetail.setSiteInvestigator(subaward.getRolodex().getFullName());
            if(subaward.getRolodex().getFullName() != null && subaward.getRolodex().getFullName().length() > 0){
                rolodexDetails.setRolodexName(subaward.getRolodex().getFullName());
            } else{
                rolodexDetails.setRolodexName(subaward.getRolodex().getOrganization());
            }
            rolodexDetails.setAddress1(subaward.getRolodex().getAddressLine1());
            rolodexDetails.setAddress2(subaward.getRolodex().getAddressLine2());
            rolodexDetails.setAddress3(subaward.getRolodex().getAddressLine3());
            rolodexDetails.setCity(subaward.getRolodex().getCity());
            String countryCode = subaward.getRolodex().getCountryCode();
            String stateName = subaward.getRolodex().getState();
            if(countryCode != null && countryCode.length() > 0 && stateName != null && stateName.length() > 0){
                final Country country = getCountryService().getCountryByAlternateCode(countryCode);
                final State state = getStateService().getState(country.getCode(), stateName);
                if(state != null){
                    rolodexDetails.setStateDescription(state.getName());
                }
            }
            rolodexDetails.setPincode(subaward.getRolodex().getPostalCode());
            rolodexDetails.setPhoneNumber(subaward.getRolodex().getPhoneNumber());
            rolodexDetails.setFax(subaward.getRolodex().getFaxNumber());
            rolodexDetails.setEmail(subaward.getRolodex().getEmailAddress());
        }
        subcontractDetail.setPONumber(subaward.getPurchaseOrderNum());
        subcontractDetail.setSubContractCode(subaward.getSubAwardCode());
        if (subaward.getOrganization() != null){
            subcontractDetail.setSubcontractorName(subaward.getOrganization().getOrganizationName());
            rolodexDetailsType.setAddress1(subaward.getOrganization().getRolodex().getAddressLine1());
            rolodexDetailsType.setAddress2(subaward.getOrganization().getRolodex().getAddressLine2());
            rolodexDetailsType.setAddress3(subaward.getOrganization().getRolodex().getAddressLine3());
            rolodexDetailsType.setCity(subaward.getOrganization().getRolodex().getCity());
            String countryCode = subaward.getOrganization().getRolodex().getCountryCode();
            String stateName = subaward.getOrganization().getRolodex().getState();
            if(countryCode != null && countryCode.length() > 0 && stateName != null && stateName.length() > 0){
                final Country country = getCountryService().getCountryByAlternateCode(countryCode);
                final State state = getStateService().getState(country.getCode(), stateName);
                if(state != null){
                    rolodexDetailsType.setStateDescription(state.getName());
                }
            }
            rolodexDetailsType.setPincode(subaward.getOrganization().getRolodex().getPostalCode());
            organisation.setFedralEmployerId(subaward.getOrganization().getFederalEmployerId());
            organisation.setDunsNumber(subaward.getOrganization().getDunsNumber());
            organisation.setCongressionalDistrict(subaward.getOrganization().getCongressionalDistrict());
        }
        if (subaward.getStartDate() != null){
            subcontractDetail.setStartDate(getDateTimeService().getCalendar(subaward.getStartDate()));
        }

        final List<SubAwardAmountInfo> allSubAwardAmountInfos = subaward.getAllSubAwardAmountInfos();
        if (allSubAwardAmountInfos != null && !allSubAwardAmountInfos.isEmpty()){
            Optional<Date>periodOfPerformanceEndDate = getPeriodOfPerformanceEndDate(subaward);
            if (periodOfPerformanceEndDate.isPresent()) {
                subcontractDetail.setEndDate(getDateTimeService().getCalendar(periodOfPerformanceEndDate.get()));
            }
            final SubAwardAmountInfo lastSubAwardAmountInfo = allSubAwardAmountInfos.get(allSubAwardAmountInfos.size() - 1);
            subcontractDetail.setComments(lastSubAwardAmountInfo.getComments());
            subcontractDetail.setModificationType(lastSubAwardAmountInfo.getModificationTypeCode());
        }

        subcontractDetail.setSubcontractorOrgRolodexDetails(rolodexDetailsType);
        subcontractDetail.setSiteInvestigatorDetails(rolodexDetails);
        subcontractDetail.setSubcontractorDetails(organisation);


        if (fcoi != null) {
            subcontractDetail.setPHSFCOI(toFlag(fcoi));
        }

        if (ffata != null) {
            subcontractDetail.setFFATA(toFlag(ffata));
        }

        if (randd != null) {
            subcontractDetail.setRANDD(toFlag(randd));
        }

        if (costshare != null) {
            subcontractDetail.setCOSTSHARE(toFlag(costshare));
        }

        subContractData.setSubcontractDetail(subcontractDetail);
    }

    private Optional<Date> getPeriodOfPerformanceEndDate(SubAward subaward) {
        final List<SubAwardAmountInfo> allSubAwardAmountInfos = subaward.getAllSubAwardAmountInfos();
        Optional<Date> periodOfPerformanceEndDate =
                Optional.ofNullable(allSubAwardAmountInfos.get(allSubAwardAmountInfos.size() - 1).getPeriodofPerformanceEndDate());
        return periodOfPerformanceEndDate;
    }

    private String toFlag(Boolean b) {
        return Boolean.TRUE.equals(b) ? "Y" : "N";
    }

    public void setSubcontractAmountInfo(SubContractData subContractData, SubAward subaward) {

        SubcontractAmountInfo subContractAmountInfo = SubcontractAmountInfo.Factory.newInstance();
        List<SubcontractAmountInfo> amountinfoList = new ArrayList<>();
        final List<SubAwardAmountInfo> allSubAwardAmountInfos = subaward.getAllSubAwardAmountInfos();

        if (allSubAwardAmountInfos != null && !allSubAwardAmountInfos.isEmpty()) {
            subContractAmountInfo.setObligatedAmount(subaward.getTotalObligatedAmount().bigDecimalValue());
            subContractAmountInfo.setAnticipatedAmount(subaward.getTotalAnticipatedAmount().bigDecimalValue());

            final SubAwardAmountInfo lastSubAwardAmountInfo = allSubAwardAmountInfos.get(allSubAwardAmountInfos.size() - 1);
            subContractAmountInfo.setObligatedChange(lastSubAwardAmountInfo.getObligatedChange().bigDecimalValue());
            subContractAmountInfo.setAnticipatedChange(lastSubAwardAmountInfo.getAnticipatedChange().bigDecimalValue());

            if (lastSubAwardAmountInfo.getPeriodofPerformanceStartDate() != null){
                subContractAmountInfo.setPerformanceStartDate(getDateTimeService().getCalendar(lastSubAwardAmountInfo.getPeriodofPerformanceStartDate()));
            }

            Optional<Date> periodOfPerformanceEndDate = getPeriodOfPerformanceEndDate(subaward);
            if(periodOfPerformanceEndDate.isPresent()) {
                subContractAmountInfo.setPerformanceEndDate(getDateTimeService().getCalendar(periodOfPerformanceEndDate.get()));
            }

            if (lastSubAwardAmountInfo.getModificationEffectiveDate() != null){
                subContractAmountInfo.setModificationEffectiveDate(getDateTimeService().getCalendar(lastSubAwardAmountInfo.getModificationEffectiveDate()));
            }
            if (lastSubAwardAmountInfo.getModificationID() != null) {
                subContractAmountInfo.setModificationNumber(lastSubAwardAmountInfo.getModificationID());
            }
        }

        amountinfoList.add(subContractAmountInfo);
        subContractData.setSubcontractAmountInfoArray(amountinfoList.toArray(new SubcontractAmountInfo[0]));
    }

    public void setAwardHeader(SubContractData subContractData) {
        AwardType awardType= AwardType.Factory.newInstance();
        AwardHeaderType awardHeaderType =AwardHeaderType.Factory.newInstance();
        AwardDetails awardDetails= AwardDetails.Factory.newInstance();
        OtherHeaderDetails otherDetails = OtherHeaderDetails.Factory.newInstance();
        List<AwardType> awardTypeList = new ArrayList<>();

        if (StringUtils.isNotBlank(sponsorAwardNumber)) {
            awardHeaderType.setSponsorAwardNumber(sponsorAwardNumber);
        }

        if (StringUtils.isNotBlank(sponsorName)) {
            awardHeaderType.setSponsorDescription(sponsorName);
        }
        if(StringUtils.isNotBlank(awardTitle)) {
            awardHeaderType.setTitle(awardTitle);
        }

        if(StringUtils.isNotBlank(cfdaNumber)) {
            otherDetails.setCFDANumber(cfdaNumber);
        }

        if(StringUtils.isNotBlank(primeSponsorName)) {
            otherDetails.setPrimeSponsorDescription(primeSponsorName);
        }

        if(noticeDate != null) {
            otherDetails.setLastUpdate(noticeDate);
        }

        if(obligatedTotal != null) {
            otherDetails.setObligatedAmt(obligatedTotal);
        }

        if(anticipatedTotal != null) {
            otherDetails.setAnticipatedAmt(anticipatedTotal);
        }

        if (StringUtils.isNotEmpty(fain)) {
            otherDetails.setFAIN(fain);
        }

        awardDetails.setAwardHeader(awardHeaderType);
        awardDetails.setOtherHeaderDetails(otherDetails);
        awardType.setAwardDetails(awardDetails);
        awardTypeList.add(awardType);
        subContractData.setAwardArray(awardTypeList.toArray(new AwardType[0]));
    }

    public void setPrimeRecipientContacts(SubContractData subContractData, SubAward subaward) {
        PrimeRecipientContacts primeReceipient = PrimeRecipientContacts.Factory.newInstance();
        OrganizationType organisation = OrganizationType.Factory.newInstance();
        RolodexDetailsType rolodexDetails = RolodexDetailsType.Factory.newInstance();

        final Organization univOrganisation = getBusinessObjectService().findByPrimaryKey(Organization.class, Collections.singletonMap(ORGANIZATION_ID, "000001"));
        if (univOrganisation != null) {
            organisation.setOrganizationName(univOrganisation.getOrganizationName());
        }

        boolean requisitionerOrg = getParameterService().getParameterValueAsBoolean(Constants.MODULE_NAMESPACE_SUBAWARD,
                                                                                    Constants.KC_ALL_PARAMETER_DETAIL_TYPE_CODE,
                                                                                    FDP_ORG_FROM_REQUISITIONER_UNIT);
        final Organization reqOrganisation = requisitionerOrg && subaward.getUnit() != null ? subaward.getUnit().getOrganization() : null;
        final Rolodex rolodex = requisitionerOrg && reqOrganisation != null && reqOrganisation.getRolodex() != null ? reqOrganisation.getRolodex() : univOrganisation != null ? univOrganisation.getRolodex() : null;

        if (rolodex != null) {
            rolodexDetails.setAddress1(rolodex.getAddressLine1());
            rolodexDetails.setAddress2(rolodex.getAddressLine2());
            rolodexDetails.setAddress3(rolodex.getAddressLine3());
            rolodexDetails.setCity(rolodex.getCity());
            String countryCode = rolodex.getCountryCode();
            String stateName = rolodex.getState();
            if (countryCode != null && countryCode.length() > 0 && stateName != null && stateName.length() > 0) {
                final Country country = getCountryService().getCountryByAlternateCode(countryCode);
                final State state = getStateService().getState(country.getCode(), stateName);
                if (state != null) {
                    rolodexDetails.setStateDescription(state.getName());
                }
            }
            rolodexDetails.setPincode(rolodex.getPostalCode());
        }

        primeReceipient.setOrgRolodexDetails(rolodexDetails);
        primeReceipient.setRequisitionerOrgDetails(organisation);
        subContractData.setPrimeRecipientContacts(primeReceipient);
    }

    public void setPrintRequirement(SubContractData subContractData) {
        PrintRequirement printrequirement =PrintRequirement.Factory.newInstance();

        String externalImageURL = Constants.KRA_EXTERNALIZABLE_IMAGES_URI_KEY;

        String imagePath=configurationService.getPropertyValueAsString(externalImageURL);
        printrequirement.setAttachment5Required("N");
        printrequirement.setAttachment3BRequired("N");
        printrequirement.setAttachment4Required("N");
        String subawardAttachment4 = getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD,
                                                                                        ParameterConstants.DOCUMENT_COMPONENT,
                                                                                        Constants.PARAMETER_FDP_SUBAWARD_ATTACHMENT_4);
        String subawardAttachment3B = getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD,
                                                                                        ParameterConstants.DOCUMENT_COMPONENT,
                                                                                        Constants.PARAMETER_FDP_SUBAWARD_ATTACHMENT_3B);

        for(SubAwardForms subAwardForms : sponsorTemplates){
            if(subAwardForms.getFormId().equals(subawardAttachment4)){
                printrequirement.setAttachment4Required("Y");
            }
            if(subAwardForms.getFormId().equals(subawardAttachment3B)){
                printrequirement.setAttachment3BRequired("Y");
            }
        }
        printrequirement.setImageCheckedPath(imagePath);
        printrequirement.setImageUncheckedPath(imagePath);
        subContractData.setPrintRequirement(printrequirement);
    }

    public void setPrimeAdministrativeContact(SubContractData subContractData, SubAward subaward) {
        PrimeAdministrativeContact primeAdministrativeContact= PrimeAdministrativeContact.Factory.newInstance();
        RolodexDetailsType rolodexdetails = RolodexDetailsType.Factory.newInstance();
        List<PrimeAdministrativeContact> rolodexDetailsList = new ArrayList<>();
        Map<String, String> administrativeMap = new HashMap<>();
        Map<String, Integer> rolodexId = new HashMap<>();
        String administrativeContactCode = getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD,
                                                                                            ParameterConstants.DOCUMENT_COMPONENT,
                                                                                            Constants.PARAMETER_FDP_PRIME_ADMINISTRATIVE_CONTACT_CODE);
        administrativeMap.put(CONTACT_TYPE_CODE, administrativeContactCode);
        ContactUsage contactUsage =   getBusinessObjectService().findByPrimaryKey(ContactUsage.class, administrativeMap);
        if(contactUsage.getModuleCode().equals(CoeusModule.SUBCONTRACTS_MODULE_CODE)){
            if(subaward.getSubAwardContactsList() != null && !subaward.getSubAwardContactsList().isEmpty()){
                for(SubAwardContact subAwardContact : subaward.getSubAwardContactsList()){
                    if(subAwardContact.getContactTypeCode().equals(administrativeContactCode)) {
                        rolodexId.put(ROLODEX_ID, subAwardContact.getRolodex().getRolodexId());
                        Rolodex rolodex = getBusinessObjectService().findByPrimaryKey(Rolodex.class, rolodexId);
                        if( rolodex.getFullName() == null ) {
                            rolodexdetails.setRolodexName(rolodex.getOrganization());
                        }
                        else {
                            rolodexdetails.setRolodexName(rolodex.getFullName());
                        }
                        rolodexdetails.setAddress1(rolodex.getAddressLine1());
                        rolodexdetails.setAddress2(rolodex.getAddressLine2());
                        rolodexdetails.setAddress3(rolodex.getAddressLine3());
                        rolodexdetails.setCity(rolodex.getCity());
                        String countryCode = rolodex.getCountryCode();
                        String stateName = rolodex.getState();
                        if(countryCode != null && countryCode.length() > 0 && stateName != null && stateName.length() > 0){
                            final Country country = getCountryService().getCountryByAlternateCode(countryCode);
                            final State state = getStateService().getState(country.getCode(), stateName);
                            if(state != null){
                                rolodexdetails.setStateDescription(state.getName());
                            }
                        }
                        rolodexdetails.setPincode(rolodex.getPostalCode());
                        rolodexdetails.setPhoneNumber(rolodex.getPhoneNumber());
                        rolodexdetails.setFax(rolodex.getFaxNumber());
                        rolodexdetails.setEmail(rolodex.getEmailAddress());

                        primeAdministrativeContact.setCoiContactEmail(getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD, ParameterConstants.DOCUMENT_COMPONENT, "FDP_COI_Contact_email"));
                    }
                }
            }
        }
        primeAdministrativeContact.setRolodexDetails(rolodexdetails);
        rolodexDetailsList.add(primeAdministrativeContact);
        subContractData.setPrimeAdministrativeContactArray(rolodexDetailsList.toArray(new PrimeAdministrativeContact[0]));
    }
    public void setPrimePrincipalInvestigator(SubContractData subContractData) {
        PersonDetailsType personDetails = PersonDetailsType.Factory.newInstance();
        List<PersonDetailsType> personDetailsList = new ArrayList<>();
        Map<String, String> awardNum = new HashMap<>();
        if(awardNumber != null){
            awardNum.put(AWARD_NUMBER, awardNumber);
            awardNum.put(ROLE_CODE, PRINCIPAL_INVESTIGATOR);
            List<AwardPerson> awardNumList = (List<AwardPerson>) getBusinessObjectService().findMatchingOrderBy(AwardPerson.class, awardNum, SEQUENCE_NUMBER, true);
            if (CollectionUtils.isNotEmpty(awardNumList)) {
                AwardPerson awardPerson = awardNumList.get(awardNumList.size() - 1);
                KcPerson awardPersons = KcServiceLocator.getService(KcPersonService.class).getKcPersonByPersonId(awardPerson.getPersonId());

                personDetails.setFullName(awardPersons.getFullName());
                personDetails.setAddressLine1(awardPersons.getAddressLine1());
                personDetails.setAddressLine2(awardPersons.getAddressLine2());
                personDetails.setAddressLine3(awardPersons.getAddressLine3());
                personDetails.setCity(awardPersons.getCity());
                String countryCode = awardPersons.getCountryCode();
                String stateName = awardPersons.getState();
                if (countryCode != null && countryCode.length() > 0 && stateName != null && stateName.length() > 0) {
                    final Country country = getCountryService().getCountryByAlternateCode(countryCode);
                    final State state = getStateService().getState(country.getCode(), stateName);
                    if (state != null) {
                        personDetails.setState(state.getName());
                    }
                }
                personDetails.setPostalCode(awardPersons.getPostalCode());
                personDetails.setMobilePhoneNumber(awardPersons.getOfficePhone());
                personDetails.setFaxNumber(awardPersons.getFaxNumber());
                personDetails.setEmailAddress(awardPersons.getEmailAddress());
            }
        }
        personDetailsList.add(personDetails);
        subContractData.setPrimePrincipalInvestigatorArray(personDetailsList.toArray(new PersonDetailsType [0]));
    }

    public void setPrimeFinancialContact(SubContractData subContractData, SubAward subaward) {
        PrimeFinancialContact primeFinancialContact = PrimeFinancialContact.Factory.newInstance();
        RolodexDetailsType rolodexDetails = RolodexDetailsType.Factory.newInstance();
        List<PrimeFinancialContact> personDetailsList = new ArrayList<>();
        Map<String, String> administrativeMap = new HashMap<>();
        Map<String, Integer> rolodexId = new HashMap<>();
        String administrativeFinancialCode = getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD,
                                                                                                ParameterConstants.DOCUMENT_COMPONENT,
                Constants.PARAMETER_FDP_PRIME_FINANCIAL_CONTACT_CODE);
        administrativeMap.put(CONTACT_TYPE_CODE, administrativeFinancialCode);
        ContactUsage contactUsage =   getBusinessObjectService().findByPrimaryKey(ContactUsage.class, administrativeMap);
        if(contactUsage.getModuleCode().equals(CoeusModule.SUBCONTRACTS_MODULE_CODE)){
            if(subaward.getSubAwardContactsList() != null && !subaward.getSubAwardContactsList().isEmpty()){
                for(SubAwardContact subAwardContact : subaward.getSubAwardContactsList()){
                    if(subAwardContact.getContactTypeCode().equals(administrativeFinancialCode)) {
                        rolodexId.put(ROLODEX_ID, subAwardContact.getRolodex().getRolodexId());
                        Rolodex rolodex = getBusinessObjectService().findByPrimaryKey(Rolodex.class, rolodexId);
                        if( rolodex.getFullName() == null) {
                            rolodexDetails.setRolodexName(rolodex.getOrganization());
                        }
                        else {
                            rolodexDetails.setRolodexName(rolodex.getFullName());
                        }
                        rolodexDetails.setAddress1(rolodex.getAddressLine1());
                        rolodexDetails.setAddress2(rolodex.getAddressLine2());
                        rolodexDetails.setAddress3(rolodex.getAddressLine3());
                        rolodexDetails.setCity(rolodex.getCity());
                        String countryCode = rolodex.getCountryCode();
                        String stateName = rolodex.getState();
                        if(countryCode != null && countryCode.length() > 0 && stateName != null && stateName.length() > 0){
                            final Country country = getCountryService().getCountryByAlternateCode(countryCode);
                            final State state = getStateService().getState(country.getCode(), stateName);
                            if(state != null){
                                rolodexDetails.setStateDescription(state.getName());
                            }
                        }
                        rolodexDetails.setPincode(rolodex.getPostalCode());
                        rolodexDetails.setPhoneNumber(rolodex.getPhoneNumber());
                        rolodexDetails.setFax(rolodex.getFaxNumber());
                        rolodexDetails.setEmail(rolodex.getEmailAddress());

                        primeFinancialContact.setInvoicesEmailed(toFlag(invoicesEmailed));

                        if (invoiceEmailDifferent != null && invoiceEmailDifferent) {
                            primeFinancialContact.setInvoiceEmailDifferent(getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD, ParameterConstants.DOCUMENT_COMPONENT, FDP_PTE_INVOICE_EMAIL));
                        }

                        if (invoiceAddressDifferent != null && invoiceAddressDifferent) {
                            primeFinancialContact.setInvoiceAddressDifferent(getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD, ParameterConstants.DOCUMENT_COMPONENT, FDP_PTE_INVOICE_ADDRESS));
                        }
                    }
                }
            }
        }
        primeFinancialContact.setRolodexDetails(rolodexDetails);
        personDetailsList.add(primeFinancialContact);
        subContractData.setPrimeFinancialContactArray(personDetailsList.toArray(new PrimeFinancialContact [0]));
    }

    public void setPrimeAuthorizedOfficial(SubContractData subContractData, SubAward subaward) {
        PrimeAuthorizedOfficial primeAuthorisedOfficial = PrimeAuthorizedOfficial.Factory.newInstance();
        RolodexDetailsType rolodexDetails = RolodexDetailsType.Factory.newInstance();
        List<PrimeAuthorizedOfficial> primeAuthorisedList = new ArrayList<>();
        Map<String, String> administrativeMap = new HashMap<>();
        Map<String, Integer> rolodexId = new HashMap<>();
        String auhtorisedOfficialCode = getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD,
                                                                                        ParameterConstants.DOCUMENT_COMPONENT,
                                                                                        Constants.PARAMETER_FDP_PRIME_AUTHORIZED_OFFICIAL_CODE);
        administrativeMap.put(CONTACT_TYPE_CODE, auhtorisedOfficialCode);
        ContactUsage contactUsage =   getBusinessObjectService().findByPrimaryKey(ContactUsage.class, administrativeMap);
        if(contactUsage.getModuleCode().equals(CoeusModule.SUBCONTRACTS_MODULE_CODE)) {
            if(subaward.getSubAwardContactsList() != null && !subaward.getSubAwardContactsList().isEmpty()){
                for(SubAwardContact subAwardContact : subaward.getSubAwardContactsList()){
                    if(subAwardContact.getContactTypeCode().equals(auhtorisedOfficialCode)) {
                        rolodexId.put(ROLODEX_ID, subAwardContact.getRolodex().getRolodexId());
                        Rolodex rolodex = getBusinessObjectService().findByPrimaryKey(Rolodex.class, rolodexId);
                        if( rolodex.getFullName()==null) {
                            rolodexDetails.setRolodexName(rolodex.getOrganization());
                        }
                        else {
                            rolodexDetails.setRolodexName(rolodex.getFullName());
                        }
                        rolodexDetails.setAddress1(rolodex.getAddressLine1());
                        rolodexDetails.setAddress2(rolodex.getAddressLine2());
                        rolodexDetails.setAddress3(rolodex.getAddressLine3());
                        rolodexDetails.setCity(rolodex.getCity());
                        String countryCode = rolodex.getCountryCode();
                        String stateName = rolodex.getState();
                        if(countryCode != null && countryCode.length() > 0 && stateName != null && stateName.length() > 0){
                            final Country country = getCountryService().getCountryByAlternateCode(countryCode);
                            final State state = getStateService().getState(country.getCode(), stateName);
                            if(state != null){
                                rolodexDetails.setStateDescription(state.getName());
                            }
                        }
                        rolodexDetails.setPincode(rolodex.getPostalCode());
                        rolodexDetails.setPhoneNumber(rolodex.getPhoneNumber());
                        rolodexDetails.setFax(rolodex.getFaxNumber());
                        rolodexDetails.setEmail(rolodex.getEmailAddress());

                        primeAuthorisedOfficial.setCentralEmail(getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD, ParameterConstants.DOCUMENT_COMPONENT, "FDP_PTE_AOR_Central_email"));

                    }
                }
            }
        }
        primeAuthorisedOfficial.setRolodexDetails(rolodexDetails);
        primeAuthorisedList.add(primeAuthorisedOfficial);
        subContractData.setPrimeAuthorizedOfficialArray(primeAuthorisedList.toArray(new PrimeAuthorizedOfficial [0]));
    }
    public void setAdministrativeContact(SubContractData subContractData, SubAward subaward) {
        AdministrativeContact administrativeContact = AdministrativeContact.Factory.newInstance();
        RolodexDetailsType rolodexDetails = RolodexDetailsType.Factory.newInstance();
        List<AdministrativeContact> administrativeContactList = new ArrayList<>();
        Map<String, String> administrativeMap = new HashMap<>();
        Map<String, Integer> rolodexId = new HashMap<>();
        String administrativeCode = getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD,
                                                                                    ParameterConstants.DOCUMENT_COMPONENT,
                                                                                    Constants.PARAMETER_FDP_SUB_ADMINISTRATIVE_CONTACT_CODE);
        administrativeMap.put(CONTACT_TYPE_CODE, administrativeCode);
        ContactUsage contactUsage =   getBusinessObjectService().findByPrimaryKey(ContactUsage.class, administrativeMap);
        if(contactUsage.getModuleCode().equals(CoeusModule.SUBCONTRACTS_MODULE_CODE)){
            if(subaward.getSubAwardContactsList() != null && !subaward.getSubAwardContactsList().isEmpty()){
                for(SubAwardContact subAwardContact : subaward.getSubAwardContactsList()){
                    if(subAwardContact.getContactTypeCode().equals(administrativeCode))
                    {
                        rolodexId.put(ROLODEX_ID, subAwardContact.getRolodex().getRolodexId());
                        Rolodex rolodex = getBusinessObjectService().findByPrimaryKey(Rolodex.class, rolodexId);
                        String organization = rolodex.getOrganization();
                        String fullName = rolodex.getFullName();
                        if (fullName != null && fullName.length() > 0){
                            rolodexDetails.setRolodexName(fullName);
                        } else {
                            rolodexDetails.setRolodexName(organization);
                        }
                        rolodexDetails.setAddress1(rolodex.getAddressLine1());
                        rolodexDetails.setAddress2(rolodex.getAddressLine2());
                        rolodexDetails.setAddress3(rolodex.getAddressLine3());
                        rolodexDetails.setCity(rolodex.getCity());
                        String countryCode = rolodex.getCountryCode();
                        String stateName = rolodex.getState();
                        if(countryCode != null && countryCode.length() > 0 && stateName != null && stateName.length() > 0){
                            final Country country = getCountryService().getCountryByAlternateCode(countryCode);
                            final State state = getStateService().getState(country.getCode(), stateName);
                            if(state != null){
                                rolodexDetails.setStateDescription(state.getName());
                            }
                        }
                        rolodexDetails.setPincode(rolodex.getPostalCode());
                        rolodexDetails.setPhoneNumber(rolodex.getPhoneNumber());
                        rolodexDetails.setFax(rolodex.getFaxNumber());
                        rolodexDetails.setEmail(rolodex.getEmailAddress());
                    }
                }}
        }
        administrativeContact.setRolodexDetails(rolodexDetails);
        administrativeContactList.add(administrativeContact);
        subContractData.setAdministrativeContactArray(administrativeContactList.toArray(new AdministrativeContact [0]));
    }
    public void setFinancialContact(SubContractData subContractData, SubAward subaward) {
        FinancialContact financialContact =FinancialContact.Factory.newInstance();
        RolodexDetailsType rolodexDetails = RolodexDetailsType.Factory.newInstance();
        List<FinancialContact> financialContactList = new ArrayList<>();
        Map<String, String> administrativeMap = new HashMap<>();
        Map<String, Integer> rolodexId = new HashMap<>();
        String financialContactCode = getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD,
                                                                                        ParameterConstants.DOCUMENT_COMPONENT,
                Constants.PARAMETER_FDP_SUB_FINANCIAL_CONTACT_CODE);
        administrativeMap.put(CONTACT_TYPE_CODE, financialContactCode);
        ContactUsage contactUsage =   getBusinessObjectService().findByPrimaryKey(ContactUsage.class, administrativeMap);
        if(contactUsage.getModuleCode().equals(CoeusModule.SUBCONTRACTS_MODULE_CODE)){
            if(subaward.getSubAwardContactsList() != null && !subaward.getSubAwardContactsList().isEmpty()) {
                for(SubAwardContact subAwardContact : subaward.getSubAwardContactsList()){
                    if(subAwardContact.getContactTypeCode().equals(financialContactCode)) {
                        rolodexId.put(ROLODEX_ID, subAwardContact.getRolodex().getRolodexId());
                        Rolodex rolodex = getBusinessObjectService().findByPrimaryKey(Rolodex.class, rolodexId);
                        String organization = rolodex.getOrganization();
                        String fullName = rolodex.getFullName();
                        if (fullName != null && fullName.length() > 0){
                            rolodexDetails.setRolodexName(fullName);
                        } else {
                            rolodexDetails.setRolodexName(organization);
                        }
                        rolodexDetails.setAddress1(rolodex.getAddressLine1());
                        rolodexDetails.setAddress2(rolodex.getAddressLine2());
                        rolodexDetails.setAddress3(rolodex.getAddressLine3());
                        rolodexDetails.setCity(rolodex.getCity());
                        String countryCode = rolodex.getCountryCode();
                        String stateName = rolodex.getState();
                        if(countryCode != null && countryCode.length() > 0 && stateName != null && stateName.length() > 0){
                            final Country country = getCountryService().getCountryByAlternateCode(countryCode);
                            final State state = getStateService().getState(country.getCode(), stateName);
                            if(state != null){
                                rolodexDetails.setStateDescription(state.getName());
                            }
                        }
                        rolodexDetails.setPincode(rolodex.getPostalCode());
                        rolodexDetails.setPhoneNumber(rolodex.getPhoneNumber());
                        rolodexDetails.setFax(rolodex.getFaxNumber());
                        rolodexDetails.setEmail(rolodex.getEmailAddress());
                    }
                }
            }
        }
        financialContact.setRolodexDetails(rolodexDetails);
        financialContactList.add(financialContact);
        subContractData.setFinancialContactArray(financialContactList.toArray(new FinancialContact [0]));
    }

    public void setAuthorizedOfficial(SubContractData subContractData, SubAward subaward) {
        AuthorizedOfficial authorizedOfficial =AuthorizedOfficial.Factory.newInstance();
        RolodexDetailsType rolodexDetails = RolodexDetailsType.Factory.newInstance();
        List<AuthorizedOfficial> authorizedOfficialList = new ArrayList<>();
        Map<String, String> administrativeMap = new HashMap<>();
        Map<String, Integer> rolodexId = new HashMap<>();
        String financialContactCode = getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD,
                                                                                        ParameterConstants.DOCUMENT_COMPONENT,
                                                                                        Constants.PARAMETER_FDP_SUB_AUTHORIZED_CONTACT_CODE);
        administrativeMap.put(CONTACT_TYPE_CODE, financialContactCode);
        ContactUsage contactUsage = getBusinessObjectService().findByPrimaryKey(ContactUsage.class, administrativeMap);
        if(contactUsage.getModuleCode().equals(CoeusModule.SUBCONTRACTS_MODULE_CODE)){
            if(subaward.getSubAwardContactsList() != null && !subaward.getSubAwardContactsList().isEmpty()){
                for(SubAwardContact subAwardContact : subaward.getSubAwardContactsList()){
                    if(subAwardContact.getContactTypeCode().equals(financialContactCode)) {
                        rolodexId.put(ROLODEX_ID, subAwardContact.getRolodex().getRolodexId());
                        Rolodex rolodex = getBusinessObjectService().findByPrimaryKey(Rolodex.class, rolodexId);
                        String organization = rolodex.getOrganization();
                        String fullName = rolodex.getFullName();
                        if (fullName != null && fullName.length() > 0){
                            rolodexDetails.setRolodexName(fullName);
                        } else {
                            rolodexDetails.setRolodexName(organization);
                        }
                        rolodexDetails.setAddress1(rolodex.getAddressLine1());
                        rolodexDetails.setAddress2(rolodex.getAddressLine2());
                        rolodexDetails.setAddress3(rolodex.getAddressLine3());
                        rolodexDetails.setCity(rolodex.getCity());
                        String countryCode = rolodex.getCountryCode();
                        String stateName = rolodex.getState();
                        if(countryCode != null && countryCode.length() > 0 && stateName != null && stateName.length() > 0){
                            final Country country = getCountryService().getCountryByAlternateCode(countryCode);
                            final State state = getStateService().getState(country.getCode(), stateName);
                            if(state != null){
                                rolodexDetails.setStateDescription(state.getName());
                            }
                        }
                        rolodexDetails.setPincode(rolodex.getPostalCode());
                        rolodexDetails.setPhoneNumber(rolodex.getPhoneNumber());
                        rolodexDetails.setFax(rolodex.getFaxNumber());
                        rolodexDetails.setEmail(rolodex.getEmailAddress());
                    }
                }
            }
        }
        authorizedOfficial.setRolodexDetails(rolodexDetails);
        authorizedOfficialList.add(authorizedOfficial);
        subContractData.setAuthorizedOfficialArray(authorizedOfficialList.toArray(new AuthorizedOfficial[0]));
    }

    public void setSubcontractReports(SubContractData subContractData, SubAward subaward) {
        List<SubcontractReports> subContractReportsList = new ArrayList<>();
        Map<String, String> reportTypeCode = new HashMap<>();
        SubAwardReportType subAwardReportsType;
        if(subaward.getSubAwardReportList() != null && !subaward.getSubAwardReportList().isEmpty()){
            for(SubAwardReports subAwardReports : subaward.getSubAwardReportList()) {
                SubcontractReports subContractReports = SubcontractReports.Factory.newInstance();
                reportTypeCode.put(SUB_AWARD_REPORT_TYPE_CODE, subAwardReports.getSubAwardReportTypeCode());
                subAwardReportsType = getBusinessObjectService().findByPrimaryKey(SubAwardReportType.class, reportTypeCode);
                subContractReports.setReportTypeDescription(subAwardReportsType.getDescription());
                subContractReportsList.add(subContractReports);
            }
        }
        subContractData.setSubcontractReportsArray(subContractReportsList.toArray(new SubcontractReports[0]));
    }

    public void setParameterService(ParameterService parameterService) {
        this.parameterService = parameterService;
    }

    public ParameterService getParameterService() {
        return parameterService;
    }

    private DateTimeService dateTimeService;

    public DateTimeService getDateTimeService() {
        return dateTimeService;
    }


    public void setDateTimeService(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }


    public BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }


    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }

    public CountryService getCountryService() {
        return countryService;
    }

    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    public StateService getStateService() {
        return stateService;
    }

    public void setStateService(StateService stateService) {
        this.stateService = stateService;
    }

    public ConfigurationService getConfigurationService() {
        return configurationService;
    }

    public void setConfigurationService(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }
}