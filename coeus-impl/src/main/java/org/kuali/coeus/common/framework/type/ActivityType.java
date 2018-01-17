/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.type;

import org.kuali.coeus.common.api.type.ActivityTypeContract;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACTIVITY_TYPE")
public class ActivityType extends KcPersistableBusinessObjectBase implements ActivityTypeContract {

    @Id
    @Column(name = "ACTIVITY_TYPE_CODE")
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "HIGHER_EDUCATION_FUNCTION_CODE")
    private String higherEducationFunctionCode;

    @Override
    public String getHigherEducationFunctionCode() {
        return higherEducationFunctionCode;
    }

    public void setHigherEducationFunctionCode(String higherEducationFunctionCode) {
        this.higherEducationFunctionCode = higherEducationFunctionCode;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
