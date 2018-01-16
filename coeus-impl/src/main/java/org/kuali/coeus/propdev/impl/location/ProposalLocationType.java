/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.location;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class ProposalLocationType extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 4387258582030826617L;

    private int locationTypeCode;

    private String locationTypeDesc;

    public void setLocationTypeCode(int locationTypeCode) {
        this.locationTypeCode = locationTypeCode;
    }

    public int getLocationTypeCode() {
        return locationTypeCode;
    }

    public void setLocationTypeDesc(String locationTypeDesc) {
        this.locationTypeDesc = locationTypeDesc;
    }

    public String getLocationTypeDesc() {
        return locationTypeDesc;
    }
}
