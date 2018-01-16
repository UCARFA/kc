/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.copy;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.coeus.propdev.impl.copy.CopyProposalRule;
import org.kuali.coeus.propdev.impl.copy.ProposalCopyCriteria;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.rice.krad.util.GlobalVariables;

/**
 * Business Rule to determine if it valid for the user to copy the
 * given Proposal Development Document.
 * 
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public class ProposalDevelopmentCopyRule extends KcTransactionalDocumentRuleBase implements CopyProposalRule {

    /**
     * TODO: fill this in
     * 
     * @see org.kuali.coeus.propdev.impl.abstrct.AbstractsRule#processAddAbstractBusinessRules(org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument, org.kuali.coeus.propdev.impl.abstrct.ProposalAbstract)
     */
    @Override
    public boolean processCopyProposalBusinessRules(ProposalDevelopmentDocument document, ProposalCopyCriteria criteria) {
        boolean isValid = true;
        
        if (StringUtils.isBlank(criteria.getLeadUnitNumber())) {
            // If the user didn't select a lead unit, i.e. he/she choose the "select:" option,
            // then the Lead Unit Number will be "blank".
            isValid = false;
            GlobalVariables.getMessageMap().putError("copyCriteria.leadUnitNumber", 
                                                   KeyConstants.ERROR_LEAD_UNIT_REQUIRED);
        }

        return isValid;
    }
}
