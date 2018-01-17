/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.api.medusa.dto;

import com.codiform.moo.annotation.Property;

public class MedusaUnitDto {

    public MedusaUnitDto () {

    }

    private String unitNumber;
    @Property(source = "mvel:unit.unitName")
    private String unitName;
    private boolean leadUnit;

    public String getUnitNumber() {
        return unitNumber;
    }

    public String getUnitName() {
        return unitName;
    }

    public boolean isLeadUnit() {
        return leadUnit;
    }
}
