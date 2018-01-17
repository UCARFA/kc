/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.amendrenew;

import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.iacuc.actions.notifyiacuc.IacucProtocolNotifyIacucBean;
import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.kra.protocol.actions.amendrenew.ProtocolAmendRenewService;
import org.kuali.kra.protocol.actions.amendrenew.ProtocolAmendmentBean;

import java.util.Collection;

public interface IacucProtocolAmendRenewService extends ProtocolAmendRenewService {

    public static final String AMEND_RENEW_CONTINUATION_ALLOW_NEW_PROTOCOL_DOCUMENT = "onAmendAndRenewAllowNewProtocolDocument";
    
    public Collection<IacucProtocol> getContinuations(String protocolNumber) throws Exception;
    
    public String createContinuation (IacucProtocolDocument protocolDocument, String continuationSummary) throws Exception;
    
    public String createContinuationWithAmendment(IacucProtocolDocument protocolDocument, ProtocolAmendmentBean amendmentBean) throws Exception;

    public String createFYI(ProtocolDocumentBase protocolDocument, IacucProtocolNotifyIacucBean fyiBean) throws Exception;

}
