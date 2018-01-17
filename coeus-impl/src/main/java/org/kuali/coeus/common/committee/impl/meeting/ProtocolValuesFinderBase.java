/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.meeting;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionLiteBase;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.*;

/**
 * 
 * This class is to find protocols submitted to this committee schedule.
 */
public abstract class ProtocolValuesFinderBase extends UifKeyValuesFinderBase {

    private static final long serialVersionUID = 5144171874415568112L;
    
    private String scheduleId;

    @Override
    public List<KeyValue> getKeyValues() {

        // note: the following will overwrite existing elements in the tree; that's the whole point.  We
        // want discrete values in the list.
        TreeMap<String, KeyValue> valuesMap = new TreeMap<String, KeyValue>();
        for (ProtocolSubmissionLiteBase protocolSubmission : getProtocols()) {
            KeyValue keyValue = new ConcreteKeyValue(protocolSubmission.getProtocolId().toString(), protocolSubmission.getProtocolNumber());
            valuesMap.put(protocolSubmission.getProtocolNumber(), keyValue);
        }
        List<KeyValue> keyValues = new ArrayList<KeyValue>(valuesMap.values());
        keyValues.add(0, ValuesFinderUtils.getSelectOption());
        return keyValues;
    }

    private List<? extends ProtocolSubmissionLiteBase> getProtocols() {
        Map<String, String> fieldValues = new HashMap<String, String>();
        fieldValues.put("scheduleIdFk", scheduleId);

        return (List<? extends ProtocolSubmissionLiteBase>) getBusinessObjectService().findMatching(getProtocolSubmissionBOClassHook(), fieldValues);
    }

    protected abstract Class<? extends ProtocolSubmissionLiteBase> getProtocolSubmissionBOClassHook();

    protected BusinessObjectService getBusinessObjectService() {
        return KcServiceLocator.getService(BusinessObjectService.class);
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

}
