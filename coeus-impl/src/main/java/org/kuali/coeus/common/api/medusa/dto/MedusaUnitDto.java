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
