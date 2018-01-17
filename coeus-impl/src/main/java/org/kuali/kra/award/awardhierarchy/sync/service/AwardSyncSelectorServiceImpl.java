/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.awardhierarchy.sync.service;

import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncChange;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncDescendantValues;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;

import java.util.List;

/**
 * Award Sync Selector Service.
 */
public class AwardSyncSelectorServiceImpl implements AwardSyncSelectorService {
    
    private ParameterService parameterService;
    
    /** 
     * @see org.kuali.kra.award.awardhierarchy.sync.service.AwardSyncSelectorService#isAwardInvolvedInSync(org.kuali.kra.award.home.Award, java.util.List)
     */
    @Override
    public boolean isAwardInvolvedInSync(Award award, List<AwardSyncChange> changes) {
        for (AwardSyncChange change : changes) {
            if (isChangeApplicableToAward(award, change)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean isChangeApplicableToAward(Award award, AwardSyncChange change) {
        boolean retval = false;
        if ((StringUtils.equals(change.getSyncDescendants(), 
                AwardSyncDescendantValues.SYNC_ACTIVE.getSyncValue())
             && isAwardActive(award)) 
            || StringUtils.equals(change.getSyncDescendants(), 
                    AwardSyncDescendantValues.SYNC_ALL.getSyncValue())) {
            if (isFabricatedAccount(award)) {
                if (change.isSyncFabricated()) {
                    retval = true;
                }
            }
            if (isCostShareAccount(award)) {
                if (change.isSyncCostSharing()) {
                    retval = true;
                }
            }
            if (!isFabricatedAccount(award) && !isCostShareAccount(award)) {
                retval = true;
            }
        }
        return retval;
    }       
    
    @Override
    public boolean isAwardActive(Award award) {
        String activeParm = getParameterService().getParameterValueAsString(AwardDocument.class, Constants.AWARD_ACTIVE_STATUS_CODES_PARM);
        for (String activeCode : activeParm.split(",")) {
            if (StringUtils.equals(award.getAwardStatus().getStatusCode(), activeCode)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isCostShareAccount(Award award) {
        String sponsorCode = getParameterService().getParameterValueAsString(AwardDocument.class, Constants.AWARD_COST_SHARING_PARM);
        return StringUtils.equals(award.getSponsorCode(), sponsorCode);
    }

    /** 
     * @see org.kuali.kra.award.awardhierarchy.sync.service.AwardSyncSelectorService#isFabricatedAccount(org.kuali.kra.award.home.Award)
     */
    @Override
    public boolean isFabricatedAccount(Award award) {
        String typeCode = getParameterService().getParameterValueAsString(AwardDocument.class, Constants.AWARD_FABRICATED_EQUPIMENT_PARM);
        return Objects.equals(award.getAccountTypeCode(), Integer.valueOf(typeCode));
    }    
    
    public void setParameterService(ParameterService parameterService) {
        this.parameterService = parameterService;
    }
    
    protected ParameterService getParameterService() {
        return parameterService;
    }

}
