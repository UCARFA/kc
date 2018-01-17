/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.service.impl.adapters;

import org.kuali.rice.krad.bo.BusinessObject;
import org.kuali.rice.krad.bo.PersistableBusinessObject;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class BusinessObjectServiceAdapter implements BusinessObjectService {

    @Override
    public int countMatching(Class clazz, Map<String, ?> positiveFieldValues, Map<String, ?> negativeFieldValues) {
        return 0;
    }

    @Override
    public int countMatching(Class clazz, Map<String, ?> fieldValues) {
        return 0;
    }

    @Override
    public void delete(List<? extends PersistableBusinessObject> boList) {
    }

    @Override
    public void delete(Object bo) {
    }

    @Override
    public void deleteMatching(Class clazz, Map<String, ?> fieldValues) {
    }

    @Override
    public <T extends BusinessObject> Collection<T> findAll(Class<T> clazz) {
        return null;
    }

    @Override
    public <T extends BusinessObject> Collection<T> findAllOrderBy(Class<T> clazz, String sortField, boolean sortAscending) {
        return null;
    }

    @Override
    public <T extends BusinessObject> T findByPrimaryKey(Class<T> clazz, Map<String, ?> primaryKeys) {
        return null;
    }

    @Override
    public <T extends BusinessObject> T findBySinglePrimaryKey(Class<T> clazz, Object primaryKey) {
        return null;
    }

    @Override
    public <T extends BusinessObject> Collection<T> findMatching(Class<T> clazz, Map<String, ?> fieldValues) {
        return null;
    }

    @Override
    public <T extends BusinessObject> Collection<T> findMatchingOrderBy(Class<T> clazz, Map<String, ?> fieldValues,
                                                                        String sortField, boolean sortAscending) {
        return null;
    }

    @Override
    public BusinessObject getReferenceIfExists(BusinessObject bo, String referenceName) {
        return null;
    }

    @Override
    public List<? extends PersistableBusinessObject> linkAndSave(List<? extends PersistableBusinessObject> businessObjects) {
        return null;
    }

    @Override
    public PersistableBusinessObject linkAndSave(PersistableBusinessObject bo) {
        return null;
    }

    @Override
    public void linkUserFields(Object bo) {
    }

    @Override
    public PersistableBusinessObject manageReadOnly(PersistableBusinessObject bo) {
        return null;
    }

    @Override
    public PersistableBusinessObject retrieve(Object object) {
        return null;
    }

    @Override
    public List<? extends PersistableBusinessObject> save(List<? extends PersistableBusinessObject> businessObjects) {
        return null;
    }

    @Override
    public PersistableBusinessObject save(PersistableBusinessObject bo) {
        return null;
    }
    
}
