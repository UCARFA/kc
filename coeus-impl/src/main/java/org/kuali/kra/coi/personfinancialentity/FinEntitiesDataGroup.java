/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.personfinancialentity;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

import java.util.List;

/**
 * 
 * This class is for FE entity data groups.
 */
public class FinEntitiesDataGroup extends KcPersistableBusinessObjectBase implements Comparable<FinEntitiesDataGroup> {


    private static final long serialVersionUID = -7800055388419460633L;

    private Integer dataGroupId;

    private String dataGroupName;

    private Integer dataGroupSortId;

    private List<FinEntitiesDataMatrix> finEntitiesDataMatrixs;

    public FinEntitiesDataGroup() {
    }

    public Integer getDataGroupId() {
        return dataGroupId;
    }

    public void setDataGroupId(Integer dataGroupId) {
        this.dataGroupId = dataGroupId;
    }

    public String getDataGroupName() {
        return dataGroupName;
    }

    public void setDataGroupName(String dataGroupName) {
        this.dataGroupName = dataGroupName;
    }

    public Integer getDataGroupSortId() {
        return dataGroupSortId;
    }

    public void setDataGroupSortId(Integer dataGroupSortId) {
        this.dataGroupSortId = dataGroupSortId;
    }

    public List<FinEntitiesDataMatrix> getFinEntitiesDataMatrixs() {
        return finEntitiesDataMatrixs;
    }

    public void setFinEntitiesDataMatrixs(List<FinEntitiesDataMatrix> finEntitiesDataMatrixs) {
        this.finEntitiesDataMatrixs = finEntitiesDataMatrixs;
    }

    @Override
    public int compareTo(FinEntitiesDataGroup arg1) {
        return getDataGroupSortId().compareTo(arg1.getDataGroupSortId());
    }
}
