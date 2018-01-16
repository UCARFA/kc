/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.person.attr;

import org.kuali.coeus.common.api.person.attr.DegreeTypeContract;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

import javax.persistence.*;

/**
 * Class representation of the Degree Type Business Object
 *
 * $Id: DegreeType.java,v 1.2 2008-07-23 19:16:44 gmcgrego Exp $
 */
@Entity
@Table(name = "DEGREE_TYPE")
public class DegreeType extends KcPersistableBusinessObjectBase implements DegreeTypeContract {

    @Id
    @Column(name = "DEGREE_CODE")
    private String code;

    @Transient
    private Integer degreeLevel;

    @Column(name = "DESCRIPTION")
    private String description;

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getDegreeLevel() {
        return this.degreeLevel;
    }

    public void setDegreeLevel(Integer argDegreeLevel) {
        this.degreeLevel = argDegreeLevel;
    }
}
