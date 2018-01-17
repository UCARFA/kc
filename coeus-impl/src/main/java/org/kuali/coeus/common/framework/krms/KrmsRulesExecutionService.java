/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.krms;

import org.kuali.coeus.common.framework.krms.KrmsRulesContext;

import java.util.List;
import java.util.Map;

public interface KrmsRulesExecutionService {

    List<String> processUnitValidations(String unitNumber, KrmsRulesContext rulesContext);

    List<Map<String,String>> processUnitKcValidations(String unitNumber, KrmsRulesContext rulesContext);

    Map<String, Boolean> runApplicableRules(List<String> ruleIds, KrmsRulesContext rulesContext, String agendaTypeId);

}
