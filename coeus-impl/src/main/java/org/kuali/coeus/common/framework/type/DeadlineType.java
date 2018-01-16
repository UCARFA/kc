/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.type;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class representation of the Deadline Type Business Object
 *
 */
@Entity
@Table(name = "DEADLINE_TYPE")
public class DeadlineType extends KcPersistableBusinessObjectBase {

    @Id
    @Column(name = "DEADLINE_TYPE_CODE")
    private String deadlineTypeCode;

    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * Gets the deadlineTypeCode attribute. 
     * @return Returns the deadlineTypeCode.
     */
    public String getDeadlineTypeCode() {
        return deadlineTypeCode;
    }

    /**
     * Sets the deadlineTypeCode attribute value.
     * @param deadlineTypeCode The deadlineTypeCode to set.
     */
    public void setDeadlineTypeCode(String deadlineTypeCode) {
        this.deadlineTypeCode = deadlineTypeCode;
    }

    /**
     * Retrieves the description attribute
     * 
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Assigns the description attribute
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
