/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.award.web;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.commitments.AwardFandaRate;
import org.kuali.kra.award.commitments.AwardFandaRateService;
import org.kuali.kra.award.home.ValidRates;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Encapsulates presentation tier data/logic related to Create Account functionality.
 */
public class AccountCreationPresentationHelper implements Serializable {
    

    private static final long serialVersionUID = -7566225295106786401L;
    
    private List<ValidRates> validRateCandidates;
    private String selectedIcrRateCode;
    
    public AccountCreationPresentationHelper() {
        super();
        initialize();
    }
    
    protected void initialize() {
        this.validRateCandidates = new ArrayList<ValidRates>();
    }

    public List<ValidRates> getValidRateCandidates() {
        return validRateCandidates;
    }

    public void setValidRateCandidates(List<ValidRates> validRateCandidates) {
        this.validRateCandidates = validRateCandidates;
    }

    public String getSelectedIcrRateCode() {
        return selectedIcrRateCode;
    }

    public void setSelectedIcrRateCode(String selectedIcrRateCode) {
        this.selectedIcrRateCode = selectedIcrRateCode;
    }
    
    /**
     * Return matching Valid Rates entries for the given AwardFandaRate.
     * @param rate
     * @return
     */
    public List<ValidRates> getMatchingValidRates(AwardFandaRate rate) {
        AwardFandaRateService fandaRateService = KcServiceLocator.getService(AwardFandaRateService.class);
        List<ValidRates> validRates = fandaRateService.getValidRates(rate);
        for (Iterator<ValidRates> iter = validRates.iterator(); iter.hasNext();) {
            if (StringUtils.isBlank(iter.next().getIcrRateCode())) {
                iter.remove();
            }
        }
        return validRates;
    }

}
