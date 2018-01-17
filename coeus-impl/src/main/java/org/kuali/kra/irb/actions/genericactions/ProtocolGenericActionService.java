/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.genericactions;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.ProtocolDocument;

/**
 * Defines the functions needed for the generic action service functions.
 */
public interface ProtocolGenericActionService extends org.kuali.kra.protocol.actions.genericactions.ProtocolGenericActionService {
    
    /**
     * Close a protocol.
     * @param protocol Protocol object
     * @param actionBean ProtocolGenericActionBean object
     * @throws Exception if there was a general problem performing the action
     */
    void close(Protocol protocol, ProtocolGenericActionBean actionBean) throws Exception;
    
    /**
     * Close enrollment for a protocol.
     * @param protocol Protocol object
     * @param actionBean ProtocolGenericActionBean object
     * @throws Exception if there was a general problem performing the action
     */
    void closeEnrollment(Protocol protocol, ProtocolGenericActionBean actionBean) throws Exception;

    /**
     * Defer a protocol.
     * @param protocol Protocol object
     * @param actionBean ProtocolGenericActionBean object
     * @throws Exception if there was a general problem performing the action
     */
    void defer(Protocol protocol, ProtocolGenericActionBean actionBean) throws Exception;
    
    /**
     * Record IRB Acknowledgement for a protocol.
     * @param protocol Protocol object
     * @param actionBean ProtocolGenericActionBean object
     * @throws Exception if there was a general problem performing the action
     */
    void irbAcknowledgement(Protocol protocol, ProtocolGenericActionBean actionBean) throws Exception;
    
    /**
     * Permit Data Analysis.
     * @param protocol Protocol object
     * @param actionBean ProtocolGenericActionBean object
     * @throws Exception if there was a general problem performing the action
     */
    void permitDataAnalysis(Protocol protocol, ProtocolGenericActionBean actionBean) throws Exception;
    
    /**
     * Reopen a protocol for enrollment.
     * @param protocol Protocol object
     * @param actionBean ProtocolGenericActionBean object
     * @throws Exception if there was a general problem performing the action
     */
    void reopenEnrollment(Protocol protocol, ProtocolGenericActionBean actionBean) throws Exception;

    /**
     * Suspend the protocol by DSMB.
     * @param protocol Protocol object
     * @param actionBean ProtocolGenericActionBean object
     * @throws Exception if there was a general problem performing the action
     */
    void suspendByDsmb(Protocol protocol, ProtocolGenericActionBean actionBean) throws Exception;
    
    ProtocolDocument getDeferredVersionedDocument(Protocol protocol) throws Exception;
    
}
