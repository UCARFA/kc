/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.api.medusa.dto;

import com.codiform.moo.annotation.CollectionProperty;
import com.codiform.moo.annotation.Property;

import java.util.List;

public class MedusaInvestigatorDto {

    public MedusaInvestigatorDto() {

    }

    private String fullName;
    @Property(source = "mvel:principalInvestigator || multiplePi")
    private boolean pi;

    @CollectionProperty(itemClass = MedusaUnitDto.class)
    private List<MedusaUnitDto> units;

    public String getFullName() {
        return fullName;
    }

    public boolean isPi() {
        return pi;
    }

    public List<MedusaUnitDto> getUnits() {
        return units;
    }
}
