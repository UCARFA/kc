/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions;

import org.kuali.kra.protocol.ProtocolBase;

/**
 * Defines the superclass of all ProtocolBase action beans.
 */
public interface ProtocolActionBean {    
 
    public void setActionHelper(ActionHelperBase actionHelper);

    public ActionHelperBase getActionHelper();
    
    public ProtocolBase getProtocol();

}
