/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General License for more details.
 * 
 * You should have received a copy of the GNU Affero General License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.coeus.propdev.impl.krms;

import org.kuali.coeus.common.framework.krms.KcKrmsJavaFunctionTermService;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;

/**
 * This interface is to declare all methods which are used as KRMS Terms in KC
 */
public interface PropDevJavaFunctionKrmsTermService extends KcKrmsJavaFunctionTermService {
    String multiplePI(DevelopmentProposal developmentProposal);

    String s2sBudgetRule(DevelopmentProposal developmentProposal, String formNames);

    String monitoredSponsorRule(DevelopmentProposal developmentProposal, String monitoredSponsorHirearchies);

    String s2sResplanRule(DevelopmentProposal developmentProposal, String narativeTypes, String maxNumber);

    String grantsFormRule(DevelopmentProposal developmentProposal, String formName);

    String biosketchFileNameRule(DevelopmentProposal developmentProposal);

    String ospAdminPropPersonRule(DevelopmentProposal developmentProposal);

    String costElementVersionLimit(DevelopmentProposal developmentProposal, String versionNumber, String costElementName, String limit);

    String divisionCodeRule(DevelopmentProposal developmentProposal);

    String divisionCodeIsFellowship(DevelopmentProposal developmentProposal, String fellowshipCodes);

    String budgetSubawardOrganizationnameRule(DevelopmentProposal developmentProposal);

    String checkProposalPerson(DevelopmentProposal developmentProposal, String personId);

    String agencyProgramCodeNullRule(DevelopmentProposal developmentProposal);

    String allProposalsRule(DevelopmentProposal developmentProposal);

    String proposalLeadUnitInHierarchy(DevelopmentProposal developmentProposal, String unitNumberToCheck);

    String s2sSubawardRule(DevelopmentProposal developmentProposal, String rrFormNames, String phsFromNames);

    String proposalGrantsRule(DevelopmentProposal developmentProposal);

    String narrativeTypeRule(DevelopmentProposal developmentProposal, String narrativeTypeCode);

    String s2s398CoverRule(DevelopmentProposal developmentProposal, String PHSCoverLetters, String narrativeTypeCode);

    String narrativeFileName(DevelopmentProposal developmentProposal);

    String costElementInVersion(DevelopmentProposal developmentProposal, String versionNumber, String costElement);

    String investigatorKeyPersonCertificationRule(DevelopmentProposal developmentProposal);

    Boolean specifiedGGForm(DevelopmentProposal developmentProposal, String formName);

    String leadUnitRule(DevelopmentProposal developmentProposal, String unitNumber);

    String sponsorGroupRule(DevelopmentProposal developmentProposal, String sponsorGroup);

    String proposalAwardTypeRule(DevelopmentProposal developmentProposal, Integer awardTypeCode);

    String s2sLeadershipRule(DevelopmentProposal developmentProposal);

    String checkProposalPiRule(DevelopmentProposal developmentProposal, String principalId);

    String checkProposalCoiRule(DevelopmentProposal developmentProposal, String principalId);

    String leadUnitBelowRule(DevelopmentProposal developmentProposal, String unitNumber);

    String specialReviewRule(DevelopmentProposal developmentProposal, String specialReviewTypeCode);

    String proposalUnitRule(DevelopmentProposal developmentProposal, String unitNumber);

    String sponsorTypeRule(DevelopmentProposal developmentProposal, String sponsorTypeCode);

    String s2sAttachmentNarrativeRule(DevelopmentProposal developmentProposal);

    String s2sModularBudgetRule(DevelopmentProposal developmentProposal);

    String s2sFederalIdRule(DevelopmentProposal developmentProposal);

    String mtdcDeviation(DevelopmentProposal developmentProposal);

    String s2sExemptionRule(DevelopmentProposal developmentProposal);

    String costElement(DevelopmentProposal developmentProposal, String costElement);

    String activityTypeRule(DevelopmentProposal developmentProposal, String activityTypeCode);

    String sponsor(DevelopmentProposal developmentProposal, String sponsorCode);

    String nonFacultyPi(DevelopmentProposal developmentProposal);

    String attachmentFileNameRule(DevelopmentProposal developmentProposal);

    String mtdcDeviationInVersion(DevelopmentProposal developmentProposal, String versionNumber);

    String proposalTypeRule(DevelopmentProposal developmentProposal, String proposalTypeCode);

    Boolean proposalTypeInRule(DevelopmentProposal developmentProposal, String proposalTypeCodes);

    Boolean costShareUnitRule(DevelopmentProposal developmentProposal, String costShareUnits);

    String completeNarrativeRule(DevelopmentProposal developmentProposal);

    Boolean costShareSourceAccountRule(DevelopmentProposal developmentProposal, String costShareSourceAccounts);

    String investigatorCitizenshipTypeRule(DevelopmentProposal developmentProposal, String citizenshipTypeToCheck);

    String piAppointmentTypeRule(DevelopmentProposal developmentProposal);

    String proposalCampusRule(DevelopmentProposal developmentProposal, String a2SCampusCode);

    String routedToOSPRule(DevelopmentProposal developmentProposal);

    String isUserProposalPI(DevelopmentProposal developmentProposal);

    String proposalUnitBelow(DevelopmentProposal developmentProposal, String unitNumberToCheck);

    String usesRolodex(DevelopmentProposal developmentProposal, Integer rolodexId);

    String competitionIdRule(DevelopmentProposal developmentProposal, String competitionId);

    String specialReviewDateRule(DevelopmentProposal developmentProposal);

    String deadlineDateRule(DevelopmentProposal developmentProposal, String deadlineDate);

    String routingSequenceRule(DevelopmentProposal developmentProposal);

    String humanSubjectsSpecialReviewContainsPropertyValue(DevelopmentProposal developmentProposal, String propertyName, String propertyValue);

    String s2sHumanSubjectExists(DevelopmentProposal developmentProposal);
}
