/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.lookup.keyvalue;

import org.kuali.coeus.sys.framework.keyvalue.EnumValuesFinder;
import org.kuali.kra.subaward.bo.MpiLeadershipPlan;

public class MpiLeadershipPlanValuesFinder extends EnumValuesFinder<MpiLeadershipPlan> {

    @Override
    protected Class<MpiLeadershipPlan> getEnumClass() {
        return MpiLeadershipPlan.class;
    }
}
