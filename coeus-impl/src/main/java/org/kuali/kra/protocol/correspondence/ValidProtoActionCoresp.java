/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.correspondence;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.protocol.actions.ProtocolActionTypeBase;

public class ValidProtoActionCoresp extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 1L;

    private Long validProtoActionCorespId;

    private String protocolActionTypeCode;

    private String protoCorrespTypeCode;

    private boolean finalFlag;

    private ProtocolActionTypeBase protocolActionType;
    
    private ProtocolCorrespondenceTypeBase protocolCorrespondenceType;
    
    public ValidProtoActionCoresp() {
    }

    public Long getValidProtoActionCorespId() {
        return validProtoActionCorespId;
    }

    public void setValidProtoActionCorespId(Long validProtoActionCorespId) {
        this.validProtoActionCorespId = validProtoActionCorespId;
    }

    public String getProtocolActionTypeCode() {
        return protocolActionTypeCode;
    }

    public void setProtocolActionTypeCode(String protocolActionTypeCode) {
        this.protocolActionTypeCode = protocolActionTypeCode;
    }

    public String getProtoCorrespTypeCode() {
        return protoCorrespTypeCode;
    }

    public void setProtoCorrespTypeCode(String protoCorrespTypeCode) {
        this.protoCorrespTypeCode = protoCorrespTypeCode;
    }

    public boolean getFinalFlag() {
        return finalFlag;
    }

    public void setFinalFlag(boolean finalFlag) {
        this.finalFlag = finalFlag;
    }

    public ProtocolActionTypeBase getProtocolActionType() {
        return protocolActionType;
    }

    public void setProtocolActionType(ProtocolActionTypeBase protocolActionType) {
        this.protocolActionType = protocolActionType;
    }

    public ProtocolCorrespondenceTypeBase getProtocolCorrespondenceType() {
        return protocolCorrespondenceType;
    }

    public void setProtocolCorrespondenceType(ProtocolCorrespondenceTypeBase protocolCorrespondenceType) {
        this.protocolCorrespondenceType = protocolCorrespondenceType;
    }
}
