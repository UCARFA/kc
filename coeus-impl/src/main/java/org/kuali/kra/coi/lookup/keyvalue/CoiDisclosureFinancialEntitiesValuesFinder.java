/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.lookup.keyvalue;

import org.kuali.coeus.sys.framework.keyvalue.FormViewAwareUifKeyValuesFinderBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.coi.CoiDisclosureDocument;
import org.kuali.kra.coi.personfinancialentity.FinancialEntityService;
import org.kuali.kra.coi.personfinancialentity.PersonFinIntDisclosure;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.ArrayList;
import java.util.List;

public class CoiDisclosureFinancialEntitiesValuesFinder extends FormViewAwareUifKeyValuesFinderBase {


    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyLabels = new ArrayList<KeyValue>();
        CoiDisclosureDocument coiDisclosureDocument = (CoiDisclosureDocument) getDocument();
        String personId = coiDisclosureDocument.getCoiDisclosure().getDisclosureReporter().getPersonId();
        keyLabels.add(ValuesFinderUtils.getSelectOption());
        List<PersonFinIntDisclosure> financialEntities = getAllFinancialEntities(personId);
        for (PersonFinIntDisclosure fe : financialEntities) {
            keyLabels.add(new ConcreteKeyValue(fe.getPersonFinIntDisclosureId().toString(), fe.getEntityName()));
        }
        return keyLabels;
    }

    public List<PersonFinIntDisclosure> getAllFinancialEntities(String userId) {
        List<PersonFinIntDisclosure> finEntities = getFinancialEntityService().getFinancialEntities(userId, true);
        return finEntities;
    }
    
    public FinancialEntityService getFinancialEntityService() {
        return KcServiceLocator.getService(FinancialEntityService.class);
    }

}
