/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.submit;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.ProtocolDocument;

import java.sql.Timestamp;
import java.util.List;

/**
 * Handles the processing of submitting a protocol to the IRB office.
 */
public interface ProtocolSubmitActionService {
    
    /**
     * Finds all submissions for the given protocolNumber and calculates how many total submissions it has overall.
     * @param protocol protocol
     * @return the total number of submissions for the given protocolNumber
     */
    int getTotalSubmissions(Protocol protocol);

    /**
     * Submit a protocol to the IRB office for review.
     * @param document the protocol
     * @param submitAction the submission data
     * @param actionDate
     */
    void submitToIrbForReview(ProtocolDocument document, ProtocolSubmitAction submitAction, Timestamp actionDate);
    
    /**
     * 
     * This method for getting ProtocolSubmissionsLookup from given protocolNumber...
     */
    List<ProtocolSubmission> getProtocolSubmissionsLookupData(List<ProtocolSubmission> protocolSbmissionList);
}
