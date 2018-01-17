/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.submit;

import org.kuali.kra.iacuc.IacucProtocol;

/**
 * Handles the processing of submitting a protocol to the IRB office.
 */
public interface IacucProtocolSubmitActionService {
    
    /**
     * Finds all submissions for the given protocolNumber and calculates how many total submissions it has overall.
     * @param protocol protocol
     * @return the total number of submissions for the given protocolNumber
     */
    int getTotalSubmissions(IacucProtocol protocol);

    /**
     * Submit a protocol to the IACUC office for review.
     * @param protocol the protocol
     * @param submitAction the submission data
     */
    void submitToIacucForReview(IacucProtocol protocol, IacucProtocolSubmitAction submitAction);
}
