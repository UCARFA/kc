/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.noreview;

import org.kuali.kra.irb.ProtocolDocument;

/**
 * 
 * This class manages the action of marking a protocol as review not required.
 */
public interface ProtocolReviewNotRequiredService {
    
   /**
    * 
    * This method manages the action of marking a protocol as review not required.
    * @param protocolDocument
    * @param actionBean
    */
    void reviewNotRequired(ProtocolDocument protocolDocument, ProtocolReviewNotRequiredBean actionBean);
}
