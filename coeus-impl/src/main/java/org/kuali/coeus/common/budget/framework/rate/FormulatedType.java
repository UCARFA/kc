/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.rate;

import org.kuali.coeus.common.budget.api.rate.FormulatedTypeContract;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FORMULATED_TYPE")
public class FormulatedType extends KcPersistableBusinessObjectBase implements FormulatedTypeContract {

    private static final long serialVersionUID = 8085064744469084409L;

    @Id
    @Column(name = "FORMULATED_TYPE_CODE")
    private String formulatedTypeCode;

    @Column(name = "DESCRIPTION")
    private String description;

    public String getFormulatedTypeCode() {
        return formulatedTypeCode;
    }

    public void setFormulatedTypeCode(String formulatedTypeCode) {
        this.formulatedTypeCode = formulatedTypeCode;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getCode() {
        return getFormulatedTypeCode();
    }
}
