/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.notesandattachments.notes;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.rice.core.api.util.RiceKeyConstants;

/**
 * 
 * This class implements the business rule for adding award note.
 */
public class AwardNoteAddRule extends KcTransactionalDocumentRuleBase implements KcBusinessRule<AwardNoteAddEvent> {



    /**
     * 
     * This method is to validate that new award note exist
     * @param event
     * @return
     */
    @Override
    public boolean processRules(AwardNoteAddEvent event) {
        boolean rulePassed = true;
        if (StringUtils.isBlank(event.getAwardNotepad().getNoteTopic())) {
            this.getErrorReporter().reportError("awardNotepadBean.newAwardNotepad.noteTopic", RiceKeyConstants.ERROR_REQUIRED, new String[] {"Note Topic"});
            rulePassed = false;
        } 
        return rulePassed;
    }


}
