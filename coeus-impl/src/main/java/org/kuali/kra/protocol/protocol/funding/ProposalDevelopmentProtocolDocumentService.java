/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.protocol.funding;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.kra.protocol.ProtocolDocumentBase;

public interface ProposalDevelopmentProtocolDocumentService<GenericProtocolDocument extends ProtocolDocumentBase> {

    public GenericProtocolDocument createProtocolDocument(ProposalDevelopmentDocument document) throws Exception;
    
    public boolean isAuthorizedCreateProtocol(ProposalDevelopmentDocument document);
}
