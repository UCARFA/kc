/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.s2s;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.propdev.api.s2s.S2sOppFormsContract;
import org.kuali.rice.krad.data.jpa.converters.BooleanYNConverter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "S2S_OPP_FORMS")
public class S2sOppForms extends KcPersistableBusinessObjectBase implements S2sOppFormsContract {

    @EmbeddedId
    private S2sOppFormsId s2sOppFormsId;

    @Column(name = "AVAILABLE")
    @Convert(converter = BooleanYNConverter.class)
    private Boolean available;

    @Column(name = "FORM_NAME")
    private String formName;

    @Column(name = "INCLUDE")
    @Convert(converter = BooleanYNConverter.class)
    private Boolean include;

    @Column(name = "MANDATORY")
    @Convert(converter = BooleanYNConverter.class)
    private Boolean mandatory;

    @Transient
    private String schemaUrl;

    @Transient
    private Boolean selectToPrint;
    
    @Column(name = "USER_ATTACHED_FORM")
    @Convert(converter = BooleanYNConverter.class)
    private Boolean userAttachedForm;

    public S2sOppFormsId getS2sOppFormsId() {
        return s2sOppFormsId;
    }

    public void setS2sOppFormsId(S2sOppFormsId s2sOppFormsId) {
        this.s2sOppFormsId = s2sOppFormsId;
    }

    @Override
    public String getOppNameSpace() {
        return this.s2sOppFormsId.oppNameSpace;
    }

    @Override
    public String getProposalNumber() {
        return this.s2sOppFormsId.proposalNumber;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public Boolean getAvailable() {
        return available;
    }

    @Override
    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public void setInclude(Boolean include) {
        this.include = include;
    }

    @Override
    public Boolean getInclude() {
        return include;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }

    @Override
    public Boolean getMandatory() {
        return mandatory;
    }

    @Override
    public String getSchemaUrl() {
        return schemaUrl;
    }

    public void setSchemaUrl(String schemaUrl) {
        this.schemaUrl = schemaUrl;
    }

    @Override
    public Boolean getSelectToPrint() {
        return selectToPrint;
    }

    public void setSelectToPrint(Boolean selectToPrint) {
        this.selectToPrint = selectToPrint;
    }

    @Override
    public Boolean getUserAttachedForm() {
        return userAttachedForm;
    }

    public void setUserAttachedForm(Boolean userAttachedForm) {
        this.userAttachedForm = userAttachedForm;
    }

    @Embeddable
    public static final class S2sOppFormsId implements Serializable, Comparable<S2sOppFormsId> {

        @Column(name = "OPP_NAME_SPACE")
        private String oppNameSpace;

        @Column(name = "PROPOSAL_NUMBER")
        private String proposalNumber;

        public String getOppNameSpace() {
            return this.oppNameSpace;
        }

        public void setOppNameSpace(String oppNameSpace) {
            this.oppNameSpace = oppNameSpace;
        }

        public String getProposalNumber() {
            return this.proposalNumber;
        }

        public void setProposalNumber(String proposalNumber) {
            this.proposalNumber = proposalNumber;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this).append("oppNameSpace", this.oppNameSpace).append("proposalNumber", this.proposalNumber).toString();
        }

        @Override
        public boolean equals(Object other) {
            if (other == null)
                return false;
            if (other == this)
                return true;
            if (other.getClass() != this.getClass())
                return false;
            final S2sOppFormsId rhs = (S2sOppFormsId) other;
            return new EqualsBuilder().append(this.oppNameSpace, rhs.oppNameSpace).append(this.proposalNumber, rhs.proposalNumber).isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37).append(this.oppNameSpace).append(this.proposalNumber).toHashCode();
        }

        @Override
        public int compareTo(S2sOppFormsId other) {
            return new CompareToBuilder().append(this.oppNameSpace, other.oppNameSpace).append(this.proposalNumber, other.proposalNumber).toComparison();
        }
    }
}
