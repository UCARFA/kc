/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.modifysubmission;

import org.kuali.kra.irb.ProtocolDocument;

/**
 * 
 * This class defines the functions required to modify a protocol submission.
 */
public interface ProtocolModifySubmissionService {
    
    /**
     * 
     * This method updates the protocol submission and persists the changes.
     * @param protocolDocument
     * @param bean
     * @throws Exception
     */
    void modifySubmission(ProtocolDocument protocolDocument, ProtocolModifySubmissionBean bean) throws Exception;

}
