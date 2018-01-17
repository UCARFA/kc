/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions;

import org.kuali.coeus.common.committee.impl.service.CommitteeServiceBase;
import org.kuali.kra.iacuc.committee.service.IacucCommitteeService;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.*;

public class IacucProtocolFinalActionTypeValuesFinder extends IacucActionsKeyValuesBase {


    private static final long serialVersionUID = -4549709102598366272L;

    private static final String FINAL_ACTION_FOR_BATCH_CORRESP_FIELD = "finalActionForBatchCorrespondence";
    private static final String DESCRIPTION_FIELD = "description";

    /**
     * Build the list of KeyValues using the key (keyAttributeName) and
     * label (labelAttributeName) of the list of all business objects found
     * for the BO class specified along with a "no action" entry.
     * 
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyValues = new ArrayList<KeyValue>();

        Map<String, Object> fieldValues = new HashMap<String, Object>();
        fieldValues.put(FINAL_ACTION_FOR_BATCH_CORRESP_FIELD, "Y");
        Collection<IacucProtocolActionType> protocolActionTypes = 
            this.getBusinessObjectService().findMatchingOrderBy(IacucProtocolActionType.class, fieldValues, DESCRIPTION_FIELD, true);
        
        keyValues.add(new ConcreteKeyValue("  ", "no action"));
        for (IacucProtocolActionType protocolActionType : protocolActionTypes) {
            keyValues.add(new ConcreteKeyValue(protocolActionType.getProtocolActionTypeCode(), protocolActionType.getDescription()));
        }
        
        return keyValues;
    }
    
    @Override
    protected Class<? extends CommitteeServiceBase> getCommitteeServiceClassHook() {
        return IacucCommitteeService.class;
    }

}
