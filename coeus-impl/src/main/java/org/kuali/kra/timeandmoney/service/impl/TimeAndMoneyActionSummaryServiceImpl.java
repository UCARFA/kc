/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.timeandmoney.service.impl;

import org.kuali.kra.timeandmoney.dao.TimeAndMoneyDao;
import org.kuali.kra.timeandmoney.history.TimeAndMoneyActionSummary;
import org.kuali.kra.timeandmoney.service.TimeAndMoneyActionSummaryService;
import org.kuali.rice.core.framework.persistence.ojb.dao.PlatformAwareDaoBaseOjb;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.List;

public class TimeAndMoneyActionSummaryServiceImpl extends PlatformAwareDaoBaseOjb implements TimeAndMoneyActionSummaryService {
    
    private BusinessObjectService businessObjectService;
    private TimeAndMoneyDao timeAndMoneyDao;

    @Override
    public List<TimeAndMoneyActionSummary> populateActionSummary(String awardNumber) {
        return timeAndMoneyDao.buildTimeAndMoneyActionSummaryForAward(awardNumber);
        
    }

    /**
     * Gets the businessObjectService attribute. 
     * @return Returns the businessObjectService.
     */
    public BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }

    /**
     * Sets the businessObjectService attribute value.
     * @param businessObjectService The businessObjectService to set.
     */
    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }

    /**
     * Gets the timeAndMoneyDao attribute. 
     * @return Returns the timeAndMoneyDao.
     */
    public TimeAndMoneyDao getTimeAndMoneyDao() {
        return timeAndMoneyDao;
    }

    /**
     * Sets the timeAndMoneyDao attribute value.
     * @param timeAndMoneyDao The timeAndMoneyDao to set.
     */
    public void setTimeAndMoneyDao(TimeAndMoneyDao timeAndMoneyDao) {
        this.timeAndMoneyDao = timeAndMoneyDao;
    }

}
