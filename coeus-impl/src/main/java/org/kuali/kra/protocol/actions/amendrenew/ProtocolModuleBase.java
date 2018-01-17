/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.amendrenew;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

@SuppressWarnings("serial")
public abstract class ProtocolModuleBase extends KcPersistableBusinessObjectBase {
    
    protected String protocolModuleCode;
    protected String description;

    protected ProtocolModuleBase() {
    }

    public String getProtocolModuleCode() {
        return protocolModuleCode;
    }

    public void setProtocolModuleCode(String protocolModuleCode) {
        this.protocolModuleCode = protocolModuleCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
