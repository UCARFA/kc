/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.lookup.keyvalue;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.coi.CoiReviewStatus;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.KeyValuesService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CoiReviewStatusValuesFinder extends UifKeyValuesFinderBase {


    private static final long serialVersionUID = 6372894146228331241L;
    private static KeyValuesService keyValuesService;

    /*
     * get list of COI review status
     */
    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(ValuesFinderUtils.getSelectOption());
        Collection<CoiReviewStatus> allCoiReviewStatus = this.getKeyValuesService().findAll(CoiReviewStatus.class);
        for (CoiReviewStatus coiReviewStatus : allCoiReviewStatus) {
            if(!coiReviewStatus.isStatusUpdatedOnlyByAction()) {
                keyValues.add(new ConcreteKeyValue(coiReviewStatus.getReviewStatusCode(), coiReviewStatus.getDescription())); 
            }
        }
        return keyValues;
    }

    /**
     * 
     * This method returns an instance of CommitteeService.
     * @return KeyValuesService
     */
    public KeyValuesService getKeyValuesService() {
        if (keyValuesService == null) {
            keyValuesService = KcServiceLocator.getService(KeyValuesService.class);
        }
        return keyValuesService;
    }

}
