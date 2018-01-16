/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.personfinancialentity;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * This class is for UI data matrix display. It will be populated from data/group/datamatrix/relationshiptype tables
 */
public class FinEntityDataMatrixBean implements Serializable {

    private static final long serialVersionUID = -2560941824792191059L;
    private static final String GUI_DROPDOWN = "DROPDOWN";
    private String columnName; 
    private String dataGroupName; 
    private String columnLabel; 
    private String guiType; 
    private String comments; 
    private String lookupArgument; 
    private Integer dataGroupId; 
    private List<RelationshipTypeBean> relationshipTypeBeans;
    
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnLabel() {
        return columnLabel;
    }

    public void setColumnLabel(String columnLabel) {
        this.columnLabel = columnLabel;
    }

    public String getGuiType() {
        return guiType;
    }

    public void setGuiType(String guiType) {
        this.guiType = guiType;
    }

    public String getLookupArgument() {
        return lookupArgument;
    }

    public void setLookupArgument(String lookupArgument) {
        this.lookupArgument = lookupArgument;
    }

    public Integer getDataGroupId() {
        return dataGroupId;
    }

    public void setDataGroupId(Integer dataGroupId) {
        this.dataGroupId = dataGroupId;
    }

    public List<RelationshipTypeBean> getRelationshipTypeBeans() {
        return relationshipTypeBeans;
    }

    public void setRelationshipTypeBeans(List<RelationshipTypeBean> relationshipTypeBeans) {
        this.relationshipTypeBeans = relationshipTypeBeans;
    }

    public String getDataGroupName() {
        return dataGroupName;
    }

    public void setDataGroupName(String dataGroupName) {
        this.dataGroupName = dataGroupName;
    }

    public boolean isArgValueLookup() {
        return StringUtils.equals(GUI_DROPDOWN, this.guiType) && StringUtils.isNotBlank(this.lookupArgument);
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
