/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb;

import org.kuali.kra.protocol.ProtocolJavaFunctionKrmsTermService;


public interface IrbJavaFunctionKrmsTermService extends ProtocolJavaFunctionKrmsTermService{

    /**
     * 
     * This method check if the protocol subject types contains a specified subject type.
     * @param irbProtocol
     * @param subjectTypeCode
     * @return
     */
    Boolean hasProtocolContainsSubjectType(Protocol irbProtocol,String subjectTypeCode);

    Integer getProtocolParticipantTypeCount(Protocol protocol, String participantType);

}
