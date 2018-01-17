/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.questionnaire;

import org.kuali.coeus.common.framework.module.CoeusSubModule;
import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.coeus.common.questionnaire.framework.answer.ModuleQuestionnaireBean;

public class ScreeningQuestionnaireHelper extends DisclosureQuestionnaireHelper {

    private static final long serialVersionUID = -8685872555239368202L;
    
    public ScreeningQuestionnaireHelper(CoiDisclosure coiDisclosure) {
        super(coiDisclosure);
    }

    @Override
    public ModuleQuestionnaireBean getModuleQnBean() {
        return new DisclosureModuleQuestionnaireBean(getCoiDisclosure(), CoeusSubModule.COI_SCREENING_SUBMODULE);
    }
}
