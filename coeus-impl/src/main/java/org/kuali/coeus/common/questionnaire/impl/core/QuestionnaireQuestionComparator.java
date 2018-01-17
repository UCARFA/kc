/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.questionnaire.impl.core;

import org.kuali.coeus.common.questionnaire.framework.core.QuestionnaireQuestion;

import java.util.Comparator;

public class QuestionnaireQuestionComparator implements Comparator<QuestionnaireQuestion>  {

    @Override
    public int compare(QuestionnaireQuestion q1, QuestionnaireQuestion q2) {
        int retval = 0;
        retval = q1.getParentQuestionNumber().compareTo(q2.getParentQuestionNumber());
        if (retval == 0) {
            retval = q1.getQuestionSeqNumber().compareTo(q2.getQuestionSeqNumber());
        }
        return retval;
    }

}
