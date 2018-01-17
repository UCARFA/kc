/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.budget.editable;

import org.kuali.coeus.sys.framework.keyvalue.KeyValueFinderService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.List;

public class BudgetEditableColumnsValuesFinder extends UifKeyValuesFinderBase {
    private KeyValueFinderService keyValueFinderService ;
    protected  KeyValueFinderService getKeyValueFinderService (){
        if (keyValueFinderService==null)
            keyValueFinderService = KcServiceLocator.getService(KeyValueFinderService.class);
        return keyValueFinderService;
    }
    @Override
    public List<KeyValue> getKeyValues() {
        return getKeyValueFinderService().getKeyValues(BudgetColumnsToAlter.class, "columnName", "columnLabel");
    }
}
