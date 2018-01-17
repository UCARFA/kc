/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol;

import org.kuali.kra.protocol.protocol.ProtocolTypeBase;

public class ProtocolType extends ProtocolTypeBase {


    private static final long serialVersionUID = 5222672499618671313L;

    private String protocolTypeCode;

    private String description;
    
    private boolean globalFlag;

    public ProtocolType() {
    }

    @Override
    public String getProtocolTypeCode() {
        return protocolTypeCode;
    }

    @Override
    public void setProtocolTypeCode(String protocolTypeCode) {
        this.protocolTypeCode = protocolTypeCode;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

	public boolean isGlobalFlag() {
		return globalFlag;
	}

	public void setGlobalFlag(boolean globalFlag) {
		this.globalFlag = globalFlag;
	}
}
