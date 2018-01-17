/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public abstract class ProtocolStatusBase extends KcPersistableBusinessObjectBase {


    private static final long serialVersionUID = 2522785877665004006L;

    private String protocolStatusCode;

    private String description;

    public ProtocolStatusBase() {
    }

    public String getProtocolStatusCode() {
        return protocolStatusCode;
    }

    public void setProtocolStatusCode(String protocolStatusCode) {
        this.protocolStatusCode = protocolStatusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
