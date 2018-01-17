/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.commitments;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.fiscalyear.FiscalYearMonthService;
import org.kuali.kra.award.home.ValidRates;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.util.ObjectUtils;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * This is the implementation of <code>AwardFandaRateService</code> interface.
 */
public class AwardFandaRateServiceImpl implements AwardFandaRateService {
    
    public static final int FOUR_DIGIT_YEAR_LENGTH = 4;
    
    protected static final String F_AND_A_RATE_CLASS_TYPE_CODE = "O";
    
    protected BusinessObjectService businessObjectService;
    private FiscalYearMonthService fiscalYearMonthService;
    
    @Override
    public List<String> getStartAndEndDatesBasedOnFiscalYear(String fiscalYear){
        List<String> listDates = new ArrayList<String>();
        if (StringUtils.isNotEmpty(fiscalYear) && fiscalYear.length()==FOUR_DIGIT_YEAR_LENGTH) {
            DateFormat dateFormat = new SimpleDateFormat(Constants.DEFAULT_DATE_FORMAT_PATTERN);
            Integer fy = Integer.parseInt(fiscalYear);
            listDates.add(dateFormat.format(new Date(this.getFiscalYearMonthService().getFiscalYearStartDate(fy).getTimeInMillis())));
            listDates.add(dateFormat.format(new Date(this.getFiscalYearMonthService().getFiscalYearEndDate(fy).getTimeInMillis())));
        }
        return listDates;
    }
    
    @Override
    public List<ValidRates> getValidRates(AwardFandaRate awardFandaRate) {
        if (ObjectUtils.isNull(awardFandaRate)) {
            return new ArrayList<ValidRates>();
        }
        Map<String, Object> criteria = new HashMap<String, Object>();
        if (awardFandaRate.getOnCampusFlag().equalsIgnoreCase("N")) {
            criteria.put("onCampusRate", awardFandaRate.getApplicableFandaRate());
        } else {
            criteria.put("offCampusRate", awardFandaRate.getApplicableFandaRate());
        }
        criteria.put("rateClassType", F_AND_A_RATE_CLASS_TYPE_CODE);
        List<ValidRates> rates = new ArrayList<ValidRates>(businessObjectService.findMatching(ValidRates.class, criteria));
        return rates;
    }
   
    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }
    
    public FiscalYearMonthService getFiscalYearMonthService() {
        return this.fiscalYearMonthService;
    }
    
    public void setFiscalYearMonthService(FiscalYearMonthService fiscalYearMonthService) {
        this.fiscalYearMonthService = fiscalYearMonthService;
    }
   
}
