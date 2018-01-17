/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.procedures;

import org.kuali.coeus.sys.framework.keyvalue.FormViewAwareUifKeyValuesFinderBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.iacuc.personnel.IacucProtocolPerson;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.KeyValuesService;
import org.kuali.rice.krad.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IacucProtocolPersonsResponsibleValuesFinder extends FormViewAwareUifKeyValuesFinderBase {


    private static final long serialVersionUID = -9014200066652039553L;

    @Override
    public List<KeyValue> getKeyValues() {
        Long protocolId = ((IacucProtocolDocument) getDocument()).getProtocol().getProtocolId();
        Map<String, Object> keyMap = new HashMap<String, Object> ();
        keyMap.put("protocolId", protocolId);
        List<IacucProtocolPerson> protocolPersons = (List<IacucProtocolPerson>)getKeyValuesService().findMatching(IacucProtocolPerson.class, keyMap);
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        for (IacucProtocolPerson protocolPerson : protocolPersons) {
            String protocolPersonId = ObjectUtils.isNull(protocolPerson.getPersonId()) ? protocolPerson.getRolodexId().toString() : protocolPerson.getPersonId();
            String keyPersonIdAndName = protocolPersonId.concat("|").concat(protocolPerson.getPersonName());
            keyValues.add(new ConcreteKeyValue(keyPersonIdAndName, protocolPerson.getPersonName()));
        }
        return keyValues;
    }

    protected KeyValuesService getKeyValuesService() {
        return (KeyValuesService) KcServiceLocator.getService("keyValuesService");
    }
}
