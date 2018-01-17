/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.customdata;

import org.kuali.coeus.common.framework.custom.DocumentCustomData;
import org.kuali.coeus.common.framework.custom.attr.CustomAttribute;
import org.kuali.coeus.sys.api.model.IdentifiableNumeric;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class IacucProtocolCustomData extends KcPersistableBusinessObjectBase implements DocumentCustomData, IdentifiableNumeric {

    private static final long serialVersionUID = 8074330420210212533L;

    private Long iacucProtocolCustomDataId;
    private Long protocolId;
    private Long customAttributeId;
    private String value;

    private CustomAttribute customAttribute;

    public Long getIacucProtocolCustomDataId() {
        return iacucProtocolCustomDataId;
    }

    public void setIacucProtocolCustomDataId(Long iacucProtocolCustomDataId) {
        this.iacucProtocolCustomDataId = iacucProtocolCustomDataId;
    }

    public Long getprotocolId() {
        return protocolId;
    }

    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

    @Override
    public Long getCustomAttributeId() {
        return customAttributeId;
    }

    @Override
    public void setCustomAttributeId(Long customAttributeId) {
        this.customAttributeId = customAttributeId;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public CustomAttribute getCustomAttribute() {
        return customAttribute;
    }

    @Override
    public void setCustomAttribute(CustomAttribute customAttribute) {
        this.customAttribute = customAttribute;
    }

	@Override
	public Long getId() {
		return customAttributeId;
	}

}
