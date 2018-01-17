/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.amendrenew;

import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.protocol.actions.amendrenew.ProtocolAmendRenewalBase;

public class IacucProtocolAmendRenewal extends ProtocolAmendRenewalBase {

    private static final long serialVersionUID = -7462565809814272506L;

    public IacucProtocolAmendRenewal() {
        super();
    }
    
    public IacucProtocol getIacucProtocol() {
        return (IacucProtocol)getProtocol();
    }
}
