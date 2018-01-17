/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.notesandattachments.notes;

import org.kuali.kra.bo.AbstractBoTest;

public class AwardNotepadTest extends AbstractBoTest<AwardNotepad> {
    private static final int AWARD_NOTEPAD_ATTRIBUTES_COUNT = 12;

    @Override
    protected Class<AwardNotepad> getBoClass() {
        return AwardNotepad.class;
    }

    @Override
    protected int getAttributeCount() {
        return AWARD_NOTEPAD_ATTRIBUTES_COUNT;
    }
}
