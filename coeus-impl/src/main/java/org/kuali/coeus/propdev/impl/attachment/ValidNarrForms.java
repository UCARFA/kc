/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.attachment;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

import javax.persistence.*;

@Entity
@Table(name = "VALID_NARR_FORMS")
public class ValidNarrForms extends KcPersistableBusinessObjectBase{


    private static final long serialVersionUID = -5530788098530332763L;

    @Id
    @Column(name = "VALID_NARR_FORMS_ID")
    private Integer validNarrFormsId;

    @Column(name = "FORM_NAME")
    private String formName;

    @Column(name = "NARRATIVE_TYPE_CODE")
    private String narrativeTypeCode;

    @Column(name = "MANDATORY")
    private String mandatory;

    @ManyToOne(cascade = { CascadeType.REFRESH })
    @JoinColumn(name = "NARRATIVE_TYPE_CODE", referencedColumnName = "NARRATIVE_TYPE_CODE", insertable = false, updatable = false)
    private NarrativeType narrativeType;

    public ValidNarrForms() {
    }

    public Integer getValidNarrFormsId() {
        return validNarrFormsId;
    }

    public void setValidNarrFormsId(Integer validNarrFormsId) {
        this.validNarrFormsId = validNarrFormsId;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getNarrativeTypeCode() {
        return narrativeTypeCode;
    }

    public void setNarrativeTypeCode(String narrativeTypeCode) {
        this.narrativeTypeCode = narrativeTypeCode;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }

    /**
     * Sets the narrativeType attribute value.
     * @param narrativeType The narrativeType to set.
     */
    public void setNarrativeType(NarrativeType narrativeType) {
        this.narrativeType = narrativeType;
    }

    /**
     * Gets the narrativeType attribute. 
     * @return Returns the narrativeType.
     */
    public NarrativeType getNarrativeType() {
        return narrativeType;
    }
}
