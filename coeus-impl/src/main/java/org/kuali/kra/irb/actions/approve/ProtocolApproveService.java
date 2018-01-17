/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.approve;

import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.ProtocolDocumentBase;

import java.sql.Date;

/**
 * 
 * This class handles the persistence of an approval action to a protocol.
 */
public interface ProtocolApproveService extends org.kuali.kra.protocol.actions.approve.ProtocolApproveService {

    /**
     * Approves an expedited submission to a Protocol.
     * @param protocolDocument the current Protocol
     * @param actionBean the bean that contains the comments and dates
     * @throws Exception
     */
    void grantExpeditedApproval(ProtocolDocumentBase protocolDocument, ProtocolApproveBean actionBean) throws Exception;

    Date buildExpirationDate(ProtocolBase protocol, Date approvalDate);

    int getDefaultExpirationDateDifference();

    }
