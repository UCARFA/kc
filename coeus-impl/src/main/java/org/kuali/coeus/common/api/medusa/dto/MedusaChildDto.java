/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
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
