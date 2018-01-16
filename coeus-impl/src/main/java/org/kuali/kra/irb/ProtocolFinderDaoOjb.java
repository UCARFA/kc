/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb;

import org.kuali.kra.irb.actions.submit.ProtocolSubmission;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.ProtocolFinderDaoOjbBase;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;

/**
 * The ProtocolFinderDao implementation for OJB.
 */
public class ProtocolFinderDaoOjb extends ProtocolFinderDaoOjbBase implements ProtocolFinderDao {

    @Override
    protected Class<? extends ProtocolBase> getProtocolBOClassHook() {
        return Protocol.class;
    }

    @Override
    protected Class<? extends ProtocolSubmissionBase> getProtocolSubmissionBOClassHook() {
        return ProtocolSubmission.class;
    }

  @Override
  public Protocol findCurrentProtocolByNumber(String protocolNumber) {
      return (Protocol)super.findCurrentProtocolByNumber(protocolNumber);
  }  
}
