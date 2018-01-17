/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.editable;

import org.kuali.coeus.propdev.api.editable.ProposalColumnsToAlterContract;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.krad.data.jpa.converters.BooleanYNConverter;

import javax.persistence.*;

@Entity
@Table(name = "EPS_PROP_COLUMNS_TO_ALTER")
public class ProposalColumnsToAlter extends KcPersistableBusinessObjectBase implements ProposalColumnsToAlterContract {

    @Id
    @Column(name = "COLUMN_NAME")
    private String columnName;

    @Column(name = "COLUMN_LABEL")
    private String columnLabel;

    @Column(name = "DATA_LENGTH")
    private Integer dataLength;

    @Column(name = "DATA_TYPE")
    private String dataType;

    @Column(name = "HAS_LOOKUP")
    @Convert(converter = BooleanYNConverter.class)
    private boolean hasLookup;

    @Column(name = "LOOKUP_ARGUMENT")
    private String lookupClass;

    @Column(name = "LOOKUP_RETURN")
    private String lookupReturn;

    @Transient
    private String lookupPkReturn;

    public ProposalColumnsToAlter() {
        super();
    }

    @Override
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public String getColumnLabel() {
        return columnLabel;
    }

    public void setColumnLabel(String columnLabel) {
        this.columnLabel = columnLabel;
    }

    @Override
    public Integer getDataLength() {
        return dataLength;
    }

    public void setDataLength(Integer dataLength) {
        this.dataLength = dataLength;
    }

    @Override
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public boolean getHasLookup() {
        return hasLookup;
    }

    public void setHasLookup(boolean hasLookup) {
        this.hasLookup = hasLookup;
    }

    @Override
    public String getLookupClass() {
        return lookupClass;
    }

    public void setLookupClass(String lookupClass) {
        this.lookupClass = lookupClass;
    }

    @Override
    public String getLookupReturn() {
        return lookupReturn;
    }

    public void setLookupReturn(String lookupReturn) {
        this.lookupReturn = lookupReturn;
    }

    public String getLookupPkReturn() {
        return lookupPkReturn;
    }

    public void setLookupPkReturn(String lookupPkReturn) {
        this.lookupPkReturn = lookupPkReturn;
    }
}
