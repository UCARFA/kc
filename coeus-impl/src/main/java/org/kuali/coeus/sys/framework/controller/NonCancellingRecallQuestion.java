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

@Component("nonCancellingRecallQuestion")
public class NonCancellingRecallQuestion extends QuestionBase {

    public static final String YES = "0";
    public static final String NO = "1";

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public NonCancellingRecallQuestion() {
        super("Are you sure you want to recall this document to the action list?", new ArrayList(2));
        this.getButtons().add("Yes");
        this.getButtons().add("returntodocument");
    }
}
