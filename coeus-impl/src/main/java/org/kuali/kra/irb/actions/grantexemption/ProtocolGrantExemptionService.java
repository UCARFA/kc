/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.grantexemption;

import org.kuali.kra.irb.Protocol;

/**
 * The Protocol Grant Exemption Service is used to grant an
 * exemption to a protocol.
 */
public interface ProtocolGrantExemptionService {

    /**
     * Grant an exemption to a protocol that is
     * submitted to the IRB office.
     * @param protocol
     * @param grantExemptionBean
     * @throws Exception
     */
    public void grantExemption(Protocol protocol, ProtocolGrantExemptionBean grantExemptionBean) throws Exception;
}
