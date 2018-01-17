/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home;

import org.kuali.kra.bo.AbstractBoTest;

public class ValidRatesTest extends AbstractBoTest<ValidRates> {
    private static final int VALID_RATES_ATTRIUTES_COUNT = 7;

    @Override
    protected Class<ValidRates> getBoClass() {
        return ValidRates.class;
    }

    @Override
    protected int getAttributeCount() {
        return VALID_RATES_ATTRIUTES_COUNT;
    }
}
