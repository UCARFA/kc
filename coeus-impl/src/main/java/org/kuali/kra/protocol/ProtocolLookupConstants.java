/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol;
/**
 * 
 * There are so many constants needed in lookup.  Created this class for now.
 * TODO : reloacate these constants to where they belong later when we have a definite direction for constants.
 */
public interface ProtocolLookupConstants {
    
    /**
     * 
     * This class contains the property constants
     */
    public static class Property {

        public static final String ROLODEX_ID = "rolodexId";
        public static final String UNIT_NUMBER = "unitNumber";
        public static final String PERSON_ID = "personId";
        public static final String KEY_PERSON = "keyPerson";
        public static final String INVESTIGATOR = "investigator";
        public static final String FUNDING_SOURCE = "fundingSource";
        public static final String FUNDING_SOURCE_NUMBER = "fundingSourceNumber";
        public static final String FUNDING_SOURCE_TYPE_CODE = "fundingSourceTypeCode";
        public static final String RESEARCH_AREA_CODE = "researchAreaCode";
        public static final String PROTOCOL_ID = "protocolId";
        public static final String PROTOCOL_TYPE_CODE = "protocolTypeCode";
        public static final String PROTOCOL_STATUS_CODE = "protocolStatusCode";
        public static final String PERFORMING_ORGANIZATION_ID = "performingOrganizationId";
        public static final String PROTOCOL_PERSON_ROLE_ID = "protocolPersonRoleId";
        public static final String PROTOCOL_ORGANIZATION_TYPE_CODE = "protocolOrganizationTypeCode";
        public static final String PERFORMING_ORGANIZATION_CODE = "1";
        public static final String PERSON_NAME = "personName";
        public static final String ORGANIZATION_ID = "organizationId";
        public static final String LEAD_UNIT_NUMBER = "leadUnitNumber";
        public static final String PROTOCOL_PERSON_ID = "protocolPersonId";

        // iacuc properties
        public static final String SPECIES_CODE = "speciesCode";
        public static final String EXCEPTION_CATEGORY_CODE = "exceptionCategoryCode";
        
    
    }

}
