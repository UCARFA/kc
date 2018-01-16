/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.org;

import org.kuali.coeus.sys.framework.keyvalue.EnumValuesFinder;

public class RestrictedRatePolicyFinder extends EnumValuesFinder<RestrictedRatePolicy> {

    @Override
    protected Class<? extends RestrictedRatePolicy> getEnumClass() {
        return RestrictedRatePolicy.class;
    }
}
