/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.ipreview;

import org.kuali.kra.bo.AbstractBoTest;

public class IntellectualPropertyReviewResultTypeTest extends AbstractBoTest<IntellectualPropertyReviewResultType> {
    private static final int INTELLECTUAL_PROPERTY_REVIEW_RESULT_TYPE_ATTRIBUTES_COUNT = 3;

    @Override
    protected Class<IntellectualPropertyReviewResultType> getBoClass() {
        return IntellectualPropertyReviewResultType.class;
    }

    @Override
    protected int getAttributeCount() {
        return INTELLECTUAL_PROPERTY_REVIEW_RESULT_TYPE_ATTRIBUTES_COUNT;
    }
}
