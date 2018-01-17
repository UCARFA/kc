/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.disclosure;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.keyvalue.FormViewAwareUifKeyValuesFinderBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.coi.CoiDisclosureDocument;
import org.kuali.kra.coi.CoiDispositionStatus;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * This class is to serve as a values finder for coi disclosure actions - 'Approve'/'Disapprove'/'Set Disclosure Status'
 */
public class CoiDispositionStatusValuesFinder extends FormViewAwareUifKeyValuesFinderBase {
    
    private static final long serialVersionUID = -6465897852646872789L;
    private transient BusinessObjectService businessObjectService;

    @Override
    public List<KeyValue> getKeyValues() {
        CoiDisclosureDocument coiDisclosureDocument = (CoiDisclosureDocument) getDocument();
        String personId = coiDisclosureDocument.getCoiDisclosure().getDisclosureReporter().getPersonId();
        List<CoiDispositionStatus> statuses;
        if (StringUtils.equals(personId, GlobalVariables.getUserSession().getPrincipalId()) 
                && !coiDisclosureDocument.isViewOnly()
                && !coiDisclosureDocument.getDocumentHeader().getWorkflowDocument().isEnroute()
                && !coiDisclosureDocument.getDocumentHeader().getWorkflowDocument().isFinal()) {
            Map<String, Object> values = new HashMap<String, Object>();
            values.put("displayToReporter", true);
            statuses = (List<CoiDispositionStatus>) getBusinessObjectService().findMatchingOrderBy(CoiDispositionStatus.class, values, "coiDispositionCode", true);
        } else {
            statuses = (List<CoiDispositionStatus>) getBusinessObjectService().findAllOrderBy(CoiDispositionStatus.class, "coiDispositionCode", true);
        }
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(ValuesFinderUtils.getSelectOption());
        for (CoiDispositionStatus status : statuses) {
            keyValues.add(new ConcreteKeyValue(status.getCoiDispositionCode(), status.getDescription()));
        }
        return keyValues;
    }
    
    protected BusinessObjectService getBusinessObjectService() {
        if (businessObjectService == null) {
            businessObjectService = KcServiceLocator.getService(BusinessObjectService.class);
        }
        return businessObjectService;
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }
}
