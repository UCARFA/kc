/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.copy;

import org.kuali.rice.kns.question.QuestionBase;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("copyPeriodsQuestion")
public class CopyPeriodsQuestion extends QuestionBase {
    
    public static final String ONE = "1";
    public static final String ALL = "0";
    
    private static final ArrayList<String> BUTTONS;
    static {
        BUTTONS = new ArrayList<String>();
        BUTTONS.add("copyoneper");
        BUTTONS.add("copyallperiods");
    }

    public CopyPeriodsQuestion() {
        super("Confirm", BUTTONS);
    }

}
