/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2016 Kuali, Inc.
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
package org.kuali.coeus.propdev.impl.s2s.nih;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class NihValidationMapping extends KcPersistableBusinessObjectBase {
    private Long id;
    private String ruleNumber;
    private String customMessage;
    private boolean forceError = Boolean.FALSE;
    private boolean appendToOriginal = Boolean.TRUE;
    private String pageId;
    private String sectionId;
    private boolean active = Boolean.TRUE;

    public String getRuleNumber() {
        return ruleNumber;
    }

    public void setRuleNumber(String ruleNumber) {
        this.ruleNumber = ruleNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }

    public boolean getForceError() {
        return forceError;
    }

    public void setForceError(boolean forceError) {
        this.forceError = forceError;
    }

    public boolean getAppendToOriginal() {
        return appendToOriginal;
    }

    public void setAppendToOriginal(boolean appendToOriginal) {
        this.appendToOriginal = appendToOriginal;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
