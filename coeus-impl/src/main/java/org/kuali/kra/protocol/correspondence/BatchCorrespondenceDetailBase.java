/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.correspondence;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public abstract class BatchCorrespondenceDetailBase extends KcPersistableBusinessObjectBase implements Comparable<BatchCorrespondenceDetailBase> {

    private static final long serialVersionUID = 1L;

    private Integer batchCorrespondenceDetailId;

    private String batchCorrespondenceTypeCode;

    private String protoCorrespTypeCode;

    private Integer daysToEvent;

    private ProtocolCorrespondenceTypeBase protocolCorrespondenceType;

    public BatchCorrespondenceDetailBase() {
    }

    public Integer getBatchCorrespondenceDetailId() {
        return batchCorrespondenceDetailId;
    }

    public void setBatchCorrespondenceDetailId(Integer batchCorrespondenceDetailId) {
        this.batchCorrespondenceDetailId = batchCorrespondenceDetailId;
    }

    public String getBatchCorrespondenceTypeCode() {
        return batchCorrespondenceTypeCode;
    }

    public void setBatchCorrespondenceTypeCode(String batchCorrespondenceTypeCode) {
        this.batchCorrespondenceTypeCode = batchCorrespondenceTypeCode;
    }

    public String getProtoCorrespTypeCode() {
        return protoCorrespTypeCode;
    }

    public void setProtoCorrespTypeCode(String protoCorrespTypeCode) {
        this.protoCorrespTypeCode = protoCorrespTypeCode;
    }

    public Integer getDaysToEvent() {
        return daysToEvent;
    }

    public void setDaysToEvent(Integer daysToEvent) {
        this.daysToEvent = daysToEvent;
    }

    public ProtocolCorrespondenceTypeBase getProtocolCorrespondenceType() {
        return protocolCorrespondenceType;
    }

    public void setProtocolCorrespondenceType(ProtocolCorrespondenceTypeBase protocolCorrespondenceType) {
        this.protocolCorrespondenceType = protocolCorrespondenceType;
    }

    @Override
    public int compareTo(BatchCorrespondenceDetailBase arg) {
        if(!this.getClass().isAssignableFrom(arg.getClass())) {
           throw new ClassCastException("Type mismatch while comparing two objects of type BatchCprrespondenceDetail"); 
        }
        int result = this.batchCorrespondenceTypeCode.compareTo(arg.batchCorrespondenceTypeCode);
        if (result == 0) {
            result = this.daysToEvent.compareTo(arg.daysToEvent);
        }
        if (result == 0) {
            result = this.protocolCorrespondenceType.getDescription().compareTo(arg.protocolCorrespondenceType.getDescription());
        }
        return result;
    }
    
}
