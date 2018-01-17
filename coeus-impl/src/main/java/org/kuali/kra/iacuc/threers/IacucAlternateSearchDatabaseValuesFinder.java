/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.threers;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;

public class IacucAlternateSearchDatabaseValuesFinder extends UifKeyValuesFinderBase {

    @Override
    public List<KeyValue> getKeyValues() {
        List<IacucAlternateSearchDatabase> databases = (List<IacucAlternateSearchDatabase>) getBusinessObjectService().findAll(IacucAlternateSearchDatabase.class);
        List<KeyValue> activeLabels = new ArrayList<KeyValue>();
        for (IacucAlternateSearchDatabase db : databases) {
            activeLabels.add(new ConcreteKeyValue(db.getAlternateSearchDbName(), db.getAlternateSearchDbName()));
        }
        return activeLabels;
    }
    
    private BusinessObjectService getBusinessObjectService() {
        return KcServiceLocator.getService(BusinessObjectService.class);
    }

}
