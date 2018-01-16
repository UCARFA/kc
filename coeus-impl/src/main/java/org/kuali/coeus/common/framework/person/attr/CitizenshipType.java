/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.person.attr;

import org.kuali.coeus.common.api.person.attr.CitizenshipTypeContract;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.core.api.mo.common.active.MutableInactivatable;
import org.kuali.rice.krad.data.jpa.converters.BooleanYNConverter;

import javax.persistence.*;


@Entity
@Table(name = "CITIZENSHIP_TYPE_T")
public class CitizenshipType extends KcPersistableBusinessObjectBase implements MutableInactivatable, CitizenshipTypeContract {

    @Id
    @Column(name = "CITIZENSHIP_TYPE_CODE")
    private Integer code;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ACTIVE_FLAG")
    @Convert(converter = BooleanYNConverter.class)
    private boolean active;

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer citizenTypeCode) {
        this.code = citizenTypeCode;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
