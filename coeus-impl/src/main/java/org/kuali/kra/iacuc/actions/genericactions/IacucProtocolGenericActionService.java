/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.genericactions;

import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.actions.genericactions.ProtocolGenericActionBean;
import org.kuali.kra.protocol.actions.genericactions.ProtocolGenericActionService;

public interface IacucProtocolGenericActionService extends ProtocolGenericActionService {
    
    void iacucAcknowledgement(ProtocolBase protocol, ProtocolGenericActionBean actionBean) throws Exception;    

    void iacucDeactivate(ProtocolBase protocol, ProtocolGenericActionBean actionBean) throws Exception;    
    
    void iacucHold(ProtocolBase protocol, ProtocolGenericActionBean actionBean) throws Exception;
    
    void iacucLiftHold(ProtocolBase protocol, ProtocolGenericActionBean actionBean) throws Exception;

}
