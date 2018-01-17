/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person.creditsplit;

import org.kuali.coeus.common.framework.type.InvestigatorCreditType;
import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.ObjectUtils;

import java.util.Collection;

import static org.kuali.coeus.sys.framework.service.KcServiceLocator.getService;
import static org.kuali.kra.infrastructure.Constants.INVESTIGATOR_CREDIT_TYPE_CODE_PROPERTY_KEY;
import static org.kuali.kra.infrastructure.KeyConstants.ERROR_INVESTIGATOR_CREDIT_TYPE_EXISTS;

/**
 * Business Rules implementation for modifying <code>{@link InvestigatorCreditType}</code> Business Object instances.
 * 
 * @see org.kuali.coeus.common.framework.type.InvestigatorCreditType
 */
public class InvestigatorCreditTypeRule extends KcMaintenanceDocumentRuleBase {

    public InvestigatorCreditTypeRule() {
        super();
    }
    
    /**
     * Cannot add duplicates of this document. Verify that the document does not already exist. To do this.
     * <ol>
     *   <li>Check if the document is new or not.</li>
     *   <li>Check for existing business objects with the same primary key values.</li>
     * </ol>
     * 
     * @see org.kuali.rice.krad.rules.DocumentRuleBase#processCustomRouteDocumentBusinessRules(org.kuali.rice.krad.document.Document)
     */
    @Override
    public boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document)   {
        boolean retval = true;
        if (document.isNew()) {
            InvestigatorCreditType newField = (InvestigatorCreditType) getNewBo();
            
            for (InvestigatorCreditType existingField : (Collection<InvestigatorCreditType>) getBusinessObjectService().findAll(InvestigatorCreditType.class)) {
                retval &= !ObjectUtils.equalByKeys(existingField, newField);
                
                if(!retval) {
                    GlobalVariables.getMessageMap().putError(INVESTIGATOR_CREDIT_TYPE_CODE_PROPERTY_KEY, ERROR_INVESTIGATOR_CREDIT_TYPE_EXISTS, existingField.getCode());
                } 
            }
        }
        
        return retval;
    }
    
    /**
     * Read Only Access to <code>{@link BusinessObjectService}</code>
     * 
     * @return BusinessObjectService instance
     */
    public BusinessObjectService getBusinessObjectService() {
        return getService(BusinessObjectService.class);
    }    
}
