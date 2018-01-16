/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.bo;

import org.kuali.coeus.common.framework.sponsor.term.SponsorTerm;

public class SponsorTermTest extends AbstractBoTest<SponsorTerm> {
    private static final int SPONSOR_TERM_ATTRIBUTES_COUNT = 6;

    @Override
    protected Class<SponsorTerm> getBoClass() {
        return SponsorTerm.class;
    }

    @Override
    protected int getAttributeCount() {
        return SPONSOR_TERM_ATTRIBUTES_COUNT;
    }
}
