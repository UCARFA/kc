/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.kra.institutionalproposal.ipreview;

import org.kuali.kra.bo.AbstractBoTest;

public class IntellectualPropertyReviewActivityTest extends AbstractBoTest<IntellectualPropertyReviewActivity> {
    private static final int INTELLECTUAL_PROPERTY_REVIEW_ACTIVITY_ATTRIBUTES_COUNT = 11;

    @Override
    protected Class<IntellectualPropertyReviewActivity> getBoClass() {
        return IntellectualPropertyReviewActivity.class;
    }

    @Override
    protected int getAttributeCount() {
        return INTELLECTUAL_PROPERTY_REVIEW_ACTIVITY_ATTRIBUTES_COUNT;
    }
}
