/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.print;

import java.util.Objects;

import java.util.Comparator;

/**
 * 
 * This class is to implement the comparator questionnaire print items.
 */
public class QuestionnairePrintOptionComparator implements Comparator<QuestionnairePrintOption> {


    @Override
    public int compare(QuestionnairePrintOption q1, QuestionnairePrintOption q2) {
        int retval = 0;
        retval = q1.getQuestionnaireSeqId().compareTo(q2.getQuestionnaireSeqId());
        if (retval == 0) {
            if (Objects.equals(q1.getItemKey(), q2.getItemKey())) {
                if (Objects.equals(q1.getSubItemCode(), q2.getSubItemCode())) {
                    retval = q1.getSubItemKey().compareTo(q2.getSubItemKey());
                }
                else {
                    retval = q1.getSubItemCode().compareTo(q2.getSubItemCode());
                }
            }
            else {
                retval = q1.getItemKey().compareTo(q2.getItemKey());
            }
        }
        return retval;
    }


}
