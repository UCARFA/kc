/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.personfinancialentity;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.core.api.mo.common.active.MutableInactivatable;

import java.util.List;

/**
 * 
 * This class is for FE relationship types
 */
public class FinIntEntityRelType extends KcPersistableBusinessObjectBase implements MutableInactivatable {


    private static final long serialVersionUID = -7816013081822663506L;

    private String relationshipTypeCode;

    private String description;

    private Integer sortId;

    private boolean active;

    private List<PersonFinIntDisclosure> personFinIntDisclosures;

    public FinIntEntityRelType() {
    }

    public String getRelationshipTypeCode() {
        return relationshipTypeCode;
    }

    public void setRelationshipTypeCode(String relationshipTypeCode) {
        this.relationshipTypeCode = relationshipTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PersonFinIntDisclosure> getPersonFinIntDisclosures() {
        return personFinIntDisclosures;
    }

    public void setPersonFinIntDisclosures(List<PersonFinIntDisclosure> personFinIntDisclosures) {
        this.personFinIntDisclosures = personFinIntDisclosures;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }
}
