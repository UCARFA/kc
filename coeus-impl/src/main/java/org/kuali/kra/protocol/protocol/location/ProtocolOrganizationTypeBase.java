/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.protocol.location;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * 
 * This class represents the ProtocolBase Organization Type Business Object.
 */
public abstract class ProtocolOrganizationTypeBase extends KcPersistableBusinessObjectBase {


    private static final long serialVersionUID = 148098563046181725L;

    private String protocolOrganizationTypeCode;

    private String description;

    /**
	 * Constructs a ProtocolOrganizationType.java.
	 */
    public ProtocolOrganizationTypeBase() {
    }


    public String getProtocolOrganizationTypeCode() {
        return protocolOrganizationTypeCode;
    }


    public void setProtocolOrganizationTypeCode(String protocolOrganizationTypeCode) {
        this.protocolOrganizationTypeCode = protocolOrganizationTypeCode;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }
}
