/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.coeus.sys.framework.validation.ErrorReporter;

/**
 * This class is to validate all rules pertaining to Award Template sync functionality
 */
public class AwardTemplateSyncRuleImpl implements AwardTemplateSyncRule {

    private ErrorReporter errorReporter;
    @Override
    public boolean processAwardTemplateSyncRules(AwardTemplateSyncEvent awardTemplateSyncEvent) {
        Award award = awardTemplateSyncEvent.getAward();
        errorReporter = KcServiceLocator.getService(ErrorReporter.class);
        if(award.getTemplateCode()==null){
            errorReporter.reportError(awardTemplateSyncEvent.getErrorPathPrefix(), KeyConstants.ERROR_NO_TEMPLATE_CODE);
            return false;
        }
                
        return true;
    }

}
