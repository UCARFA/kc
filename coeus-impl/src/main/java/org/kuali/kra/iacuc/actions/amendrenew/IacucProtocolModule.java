/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.amendrenew;

import org.kuali.kra.protocol.actions.amendrenew.ProtocolModuleBase;

@SuppressWarnings("serial")
public class IacucProtocolModule extends ProtocolModuleBase {

    public static final String THREE_RS = "036";
    public static final String SPECIES_GROUPS = "032";
    public static final String EXCEPTIONS = "033";
    public static final String PROCEDURES = "031";
    

    public static final String GENERAL_INFO = "001";

    public static final String PROTOCOL_PERSONNEL = "002";

    public static final String AREAS_OF_RESEARCH = "004";

    public static final String SUBJECTS = "006";

    public static final String SPECIAL_REVIEW = "007";

    public static final String ADD_MODIFY_ATTACHMENTS = "008";

    public static final String PROTOCOL_REFERENCES = "016";

    public static final String PROTOCOL_ORGANIZATIONS = "017";

    public static final String OTHERS = "023";

    public static final String FUNDING_SOURCE = "024";

    public static final String PROTOCOL_PERMISSIONS = "025";

    public static final String QUESTIONNAIRE = "026";
    
    public IacucProtocolModule() {
        super();
    }


}
