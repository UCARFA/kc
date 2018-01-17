/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.copy;

import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.protocol.actions.copy.ProtocolCopyService;

public interface IacucProtocolCopyService extends ProtocolCopyService<IacucProtocolDocument>{

    /**
     * This method is to copy source threers data to destination protocol
     * @param srcProtocol
     * @param destProtocol
     */
    public void copyProtocolThreers(IacucProtocol srcProtocol, IacucProtocol destProtocol);

    /**
     * This method is to copy source exceptions to destination protocol
     * @param srcProtocol
     * @param destProtocol
     */
    public void copyProtocolExceptions(IacucProtocol srcProtocol, IacucProtocol destProtocol);
    
    
}
