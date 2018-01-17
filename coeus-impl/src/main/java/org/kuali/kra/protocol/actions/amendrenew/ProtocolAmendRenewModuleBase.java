/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.amendrenew;

import org.kuali.coeus.common.framework.version.sequence.associate.SequenceAssociate;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.protocol.ProtocolBase;

@SuppressWarnings("serial")
public abstract class ProtocolAmendRenewModuleBase extends KcPersistableBusinessObjectBase implements SequenceAssociate<ProtocolBase> {

    private Long protocolAmendRenewModuleId;

    private String protocolAmendRenewalNumber;

    private Long protocolAmendRenewalId;

    private String protocolNumber;

    private String protocolModuleTypeCode;

    private ProtocolAmendRenewalBase protocolAmendRenewal;

    private ProtocolModuleBase protocolModule;

    public ProtocolAmendRenewModuleBase() {
    }

    public Long getProtocolAmendRenewModuleId() {
        return protocolAmendRenewModuleId;
    }

    public void setProtocolAmendRenewModuleId(Long protocolAmendRenewModuleId) {
        this.protocolAmendRenewModuleId = protocolAmendRenewModuleId;
    }

    public String getProtocolAmendRenewalNumber() {
        return protocolAmendRenewalNumber;
    }

    public void setProtocolAmendRenewalNumber(String protocolAmendRenewalNumber) {
        this.protocolAmendRenewalNumber = protocolAmendRenewalNumber;
    }

    public Long getProtocolAmendRenewalId() {
        return protocolAmendRenewalId;
    }

    public void setProtocolAmendRenewalId(Long protocolAmendRenewalId) {
        this.protocolAmendRenewalId = protocolAmendRenewalId;
    }

    public String getProtocolNumber() {
        return protocolNumber;
    }

    public void setProtocolNumber(String protocolNumber) {
        this.protocolNumber = protocolNumber;
    }

    public String getProtocolModuleTypeCode() {
        return protocolModuleTypeCode;
    }

    public void setProtocolModuleTypeCode(String protocolModuleTypeCode) {
        this.protocolModuleTypeCode = protocolModuleTypeCode;
    }

    public ProtocolAmendRenewalBase getProtocolAmendRenewal() {
        return protocolAmendRenewal;
    }

    public void setProtocolAmendRenewal(ProtocolAmendRenewalBase protocolAmendRenewal) {
        this.protocolAmendRenewal = protocolAmendRenewal;
    }

    public ProtocolModuleBase getProtocolModule() {
        return protocolModule;
    }

    public void setProtocolModule(ProtocolModuleBase protocolModule) {
        this.protocolModule = protocolModule;
    }

    @Override
    public ProtocolBase getSequenceOwner() {
        return protocolAmendRenewal != null ? protocolAmendRenewal.getProtocol() : null;
    }

    @Override
    public void setSequenceOwner(ProtocolBase newlyVersionedOwner) {
        if (protocolAmendRenewal != null) {
            protocolAmendRenewal.setProtocol(newlyVersionedOwner);
        }
    }

    @Override
    public void resetPersistenceState() {
        protocolAmendRenewModuleId = null;
    }

    @Override
    public Integer getSequenceNumber() {
        return protocolAmendRenewal != null ? protocolAmendRenewal.getSequenceNumber() : 0;
    }
}
