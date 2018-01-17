/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class CriteriaFieldHelper {

    private String critFieldName;
    private String searchKey;
    private String fieldValue;
    private Class<? extends KcPersistableBusinessObjectBase> clazz;

    public CriteriaFieldHelper() {
        
    }
    
    public CriteriaFieldHelper(String searchKey, String critFieldName, Class<? extends KcPersistableBusinessObjectBase> clazz) {
        this.searchKey = searchKey;
        this.critFieldName = critFieldName;
        this.clazz = clazz;
    }

    public String getCritFieldName() {
        return critFieldName;
    }

    public void setCritFieldName(String critFieldName) {
        this.critFieldName = critFieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public Class<? extends KcPersistableBusinessObjectBase> getClazz() {
        return clazz;
    }

    public void setClazz(Class<? extends KcPersistableBusinessObjectBase> clazz) {
        this.clazz = clazz;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

}
