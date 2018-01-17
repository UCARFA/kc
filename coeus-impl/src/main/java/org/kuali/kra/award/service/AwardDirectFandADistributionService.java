/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.service;

import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.timeandmoney.AwardDirectFandADistribution;

import java.util.List;

/**
 * This is the Award Direct F and A Distribution Service Interface.
 */
public interface AwardDirectFandADistributionService {

    /**
     * This method generates all of the periods for initial display in tab.
     */
    List<AwardDirectFandADistribution> generateDefaultAwardDirectFandADistributionPeriods(Award award);
}
