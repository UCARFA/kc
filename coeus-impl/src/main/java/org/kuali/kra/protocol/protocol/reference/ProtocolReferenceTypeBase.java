/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.protocol.reference;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.core.api.mo.common.active.MutableInactivatable;

public abstract class ProtocolReferenceTypeBase extends KcPersistableBusinessObjectBase implements MutableInactivatable {


    private static final long serialVersionUID = -3772996557911089417L;

    private Integer protocolReferenceTypeCode;

    private String description;

    private boolean active;

    public ProtocolReferenceTypeBase() {
    }

    public Integer getProtocolReferenceTypeCode() {
        return protocolReferenceTypeCode;
    }

    public void setProtocolReferenceTypeCode(Integer protocolReferenceTypeCode) {
        this.protocolReferenceTypeCode = protocolReferenceTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }
}
