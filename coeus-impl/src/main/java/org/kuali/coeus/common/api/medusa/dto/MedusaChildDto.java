/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2017 Kuali, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.coeus.common.api.medusa.dto;

import java.util.ArrayList;
import java.util.List;

public class MedusaChildDto {

    public MedusaChildDto() {
        this.children = new ArrayList<>();
    }

    private String moduleCode;
    private Long moduleId;
    private String description;
    private String detailedDescription;
    private List<MedusaChildDto> children;

    public void addChild(MedusaChildDto child) {
        children.add(child);
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetailedDescription() { return detailedDescription; }

    public void setDetailedDescription(String detailedDescription) { this.detailedDescription = detailedDescription; }

    public List<MedusaChildDto> getChildren() {
        return children;
    }
}
