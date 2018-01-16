/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.editable;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.kuali.coeus.propdev.api.editable.ProposalChangedDataContract;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;

@Entity
@Table(name = "EPS_PROP_CHANGED_DATA")
@IdClass(ProposalChangedData.ProposalChangedDataId.class)
public class ProposalChangedData extends KcPersistableBusinessObjectBase implements ProposalChangedDataContract {

    @Id
    @Column(name = "CHANGE_NUMBER")
    private Integer changeNumber;

    @Id
    @Column(name = "COLUMN_NAME")
    private String columnName;

    @Id
    @Column(name = "PROPOSAL_NUMBER")
    private String proposalNumber;

    @Column(name = "CHANGED_VALUE")
    private String changedValue;

    @Column(name = "COMMENTS")
    private String comments;

    @Column(name = "DISPLAY_VALUE")
    private String displayValue;

    @Column(name = "OLD_DISPLAY_VALUE")
    private String oldDisplayValue;

    @ManyToOne(cascade = { CascadeType.REFRESH })
    @JoinColumn(name = "COLUMN_NAME", referencedColumnName = "COLUMN_NAME", insertable = false, updatable = false)
    private ProposalColumnsToAlter editableColumn;

    public ProposalChangedData() {
        super();
    }

    @Override
    public Integer getChangeNumber() {
        return changeNumber;
    }

    public void setChangeNumber(Integer changeNumber) {
        this.changeNumber = changeNumber;
    }

    @Override
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public String getProposalNumber() {
        return proposalNumber;
    }

    public void setProposalNumber(String proposalNumber) {
        this.proposalNumber = proposalNumber;
    }

    @Override
    public String getChangedValue() {
        return changedValue;
    }

    public void setChangedValue(String changedValue) {
        this.changedValue = changedValue;
    }

    @Override
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    @Override
    public String getOldDisplayValue() {
        return oldDisplayValue;
    }

    public void setOldDisplayValue(String oldDisplayValue) {
        this.oldDisplayValue = oldDisplayValue;
    }

    @Override
    public ProposalColumnsToAlter getEditableColumn() {
        return editableColumn;
    }

    public void setEditableColumn(ProposalColumnsToAlter editableColumn) {
        this.editableColumn = editableColumn;
    }

    public String getAttributeName() {
        String attributeName = "";
       for (Field field : DevelopmentProposal.class.getDeclaredFields()) {
           Column column = field.getAnnotation(Column.class);
           if (column != null && column.name().equals(getColumnName())){
               attributeName = field.getName();
               break;
           }
       }

        return attributeName;
    }

    public static final class ProposalChangedDataId implements Serializable, Comparable<ProposalChangedDataId> {

        private String proposalNumber;

        private String columnName;

        private Integer changeNumber;

        public String getProposalNumber() {
            return this.proposalNumber;
        }

        public void setProposalNumber(String proposalNumber) {
            this.proposalNumber = proposalNumber;
        }

        public String getColumnName() {
            return this.columnName;
        }

        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }

        public Integer getChangeNumber() {
            return this.changeNumber;
        }

        public void setChangeNumber(Integer changeNumber) {
            this.changeNumber = changeNumber;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this).append("proposalNumber", this.proposalNumber).append("columnName", this.columnName).append("changeNumber", this.changeNumber).toString();
        }

        @Override
        public boolean equals(Object other) {
            if (other == null)
                return false;
            if (other == this)
                return true;
            if (other.getClass() != this.getClass())
                return false;
            final ProposalChangedDataId rhs = (ProposalChangedDataId) other;
            return new EqualsBuilder().append(this.proposalNumber, rhs.proposalNumber).append(this.columnName, rhs.columnName).append(this.changeNumber, rhs.changeNumber).isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37).append(this.proposalNumber).append(this.columnName).append(this.changeNumber).toHashCode();
        }

        @Override
        public int compareTo(ProposalChangedDataId other) {
            return new CompareToBuilder().append(this.proposalNumber, other.proposalNumber).append(this.columnName, other.columnName).append(this.changeNumber, other.changeNumber).toComparison();
        }
    }
}
