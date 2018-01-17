/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.org.kuali.rice.krad.uif.control;

import org.kuali.rice.krad.datadictionary.parse.BeanTag;
import org.kuali.rice.krad.datadictionary.parse.BeanTagAttribute;
import org.kuali.rice.krad.datadictionary.parse.BeanTags;
import org.kuali.rice.krad.uif.control.RadioGroupControl;

import java.util.List;

@BeanTags({@BeanTag(name = "questionRadioControl", parent = "Uif-QuestionRadioControl")})
public class QuestionRadioGroupControl extends RadioGroupControl {

    private List<String> optionDescriptions;

    @BeanTagAttribute
    public List<String> getOptionDescriptions() {
        return this.optionDescriptions;
    }

    public void setOptionDescriptions(List<String> optionDescriptions) {
        this.optionDescriptions = optionDescriptions;
    }
}
