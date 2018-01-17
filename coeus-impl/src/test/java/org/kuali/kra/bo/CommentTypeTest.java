/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.bo;

public class CommentTypeTest extends AbstractBoTest<CommentType> {
    private static final int COMMENT_TYPE_ATTRIBUTES_COUNT = 7;

    @Override
    protected Class<CommentType> getBoClass() {
        return CommentType.class;
    }

    @Override
    protected int getAttributeCount() {
        return COMMENT_TYPE_ATTRIBUTES_COUNT;
    }
}

