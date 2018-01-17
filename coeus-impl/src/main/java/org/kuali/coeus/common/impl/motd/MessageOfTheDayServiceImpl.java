/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.motd;

import org.apache.commons.collections4.ListUtils;
import org.kuali.coeus.common.framework.motd.MessageOfTheDay;
import org.kuali.coeus.common.framework.motd.MessageOfTheDayService;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("messageOfTheDayService")
public class MessageOfTheDayServiceImpl implements MessageOfTheDayService {

    private static final String DISPLAY_ORDER = "displayOrder";
    private static final String ACTIVE = "active";

    @Autowired
    @Qualifier("businessObjectService")
    private BusinessObjectService businessObjectService;

    @Override
    public List<MessageOfTheDay> getMessagesOfTheDay() {
        final List<MessageOfTheDay> results = new ArrayList<MessageOfTheDay>( businessObjectService.findMatchingOrderBy(MessageOfTheDay.class,
                Collections.singletonMap(ACTIVE, "Y"),
                DISPLAY_ORDER, 
                true ));
        
        return ListUtils.emptyIfNull(results);
    }

    protected BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }
    
    public void setBusinessObjectService( BusinessObjectService businessObjectService ) {
        this.businessObjectService = businessObjectService;
    }
    
}
