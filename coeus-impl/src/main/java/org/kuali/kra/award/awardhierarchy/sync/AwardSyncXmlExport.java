/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.awardhierarchy.sync;

import java.util.Map;

/**
 * Class used to serialize changes to xml for persistence.
 */
public class AwardSyncXmlExport {
    private String className;
    private boolean addIfNotFound = true;
    private boolean partOfObjectKey;
    private Map<String, Object> keys;
    private Map<String, Object> values;
    
    @Override
    public String toString() {
        return "(className, addIfNotFound, keys, values)=(" + className + "," + addIfNotFound + "," + keys + "," + values + ")";
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public boolean isAddIfNotFound() {
        return addIfNotFound;
    }
    public void setAddIfNotFound(boolean addIfNotFound) {
        this.addIfNotFound = addIfNotFound;
    }
    public Map<String, Object> getKeys() {
        return keys;
    }
    public void setKeys(Map<String, Object> keys) {
        this.keys = keys;
    }
    public Map<String, Object> getValues() {
        return values;
    }
    public void setValues(Map<String, Object> values) {
        this.values = values;
    }
    public boolean isPartOfObjectKey() {
        return partOfObjectKey;
    }
    public void setPartOfObjectKey(boolean partOfObjectKey) {
        this.partOfObjectKey = partOfObjectKey;
    }
}
