/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.subawardrule;

import org.kuali.kra.subaward.bo.SubAward;
import org.kuali.kra.subaward.bo.SubAwardFfataReporting;
import org.kuali.rice.krad.rules.rule.BusinessRule;


public interface SubAwardFfataReportingRule extends BusinessRule {
    boolean processAddSubAwardFfataReportingBusinessRules(SubAwardFfataReporting subAwardFfataReporting, SubAward subAward);
}
