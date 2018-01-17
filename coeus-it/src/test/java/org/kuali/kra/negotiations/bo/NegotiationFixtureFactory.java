/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.negotiations.bo;

public class NegotiationFixtureFactory {
    
    public static Negotiation createNegotiationFixture() {
        NegotiationStatus status = new NegotiationStatus();
        status.setId(1L);
        status.setActive(true);
        status.setCode("IP");
        status.setDescription("In Progress");
        
        NegotiationAgreementType agreementType = new NegotiationAgreementType();
        agreementType.setId(1L);
        agreementType.setCode("SRA");
        agreementType.setDescription("Standard Research Agreement");
        agreementType.setActive(true);

        NegotiationAssociationType associationType = new NegotiationAssociationType();
        associationType.setId(1L);
        associationType.setCode("NO");
        associationType.setDescription("None");
        associationType.setActive(true);
        
        Negotiation negotiation = new Negotiation();
        negotiation.setNegotiationStatus(status);
        negotiation.setNegotiationAgreementType(agreementType);
        negotiation.setNegotiationAssociationType(associationType);
        
        java.sql.Date testEndDate = new java.sql.Date(2011, 12, 31);
        java.sql.Date testStartDate = new java.sql.Date(2009, 12, 31);
        
        negotiation.setAnticipatedAwardDate(testEndDate);
        negotiation.setNegotiationEndDate(testEndDate);
        negotiation.setNegotiationStartDate(testStartDate);
        negotiation.setDocumentFolder("document folder");
        negotiation.setDocumentNumber("123321");
        negotiation.setNegotiatorUserName("quickstart");
        negotiation.setNegotiatorName("quickstart");

        return negotiation;
    }

}
