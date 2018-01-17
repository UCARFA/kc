/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.controller;

import org.kuali.rice.kns.question.QuestionBase;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * This class support the ConfirmationQuestion. For example: a Yes/No/Cancel dialog window.
 */

@Component("kcConfirmationQuestion")
public class KcConfirmationQuestion extends QuestionBase {

    public static final String YES = "0";
    public static final String NO = "1";
    public static final String CANCEL = "2";

    @SuppressWarnings("unchecked")
    public KcConfirmationQuestion() {
        super("Are you sure you want to cancel?", new ArrayList(3));
        this.getButtons().add("Yes");
        this.getButtons().add("No");
        this.getButtons().add("returntodocument");
    }
}
