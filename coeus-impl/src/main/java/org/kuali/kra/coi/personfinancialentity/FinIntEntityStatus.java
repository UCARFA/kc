/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.personfinancialentity;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

import java.util.List;

/**
 * 
 * This class is for FE status
 */
public class FinIntEntityStatus extends KcPersistableBusinessObjectBase {


    private static final long serialVersionUID = -2103009505440817096L;

    public static final String ACTIVE = "1";

    public static final String INACTIVE = "2";

    private Integer statusCode;

    private String description;

    private List<PersonFinIntDisclosure> personFinIntDisclosures;

    public FinIntEntityStatus() {
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
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
}
