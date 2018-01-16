/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.document;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.maintenance.KraMaintainableImpl;
import org.kuali.kra.subaward.bo.SubAwardAmountReleased;
import org.kuali.rice.core.api.datetime.DateTimeService;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.kns.service.KNSServiceLocator;
import org.kuali.rice.krad.bo.DocumentHeader;
import org.kuali.rice.krad.service.DictionaryValidationService;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.Map;

public class SubAwardInvoiceMaintainableImpl extends KraMaintainableImpl {

    private static final long serialVersionUID = 7243072336736625204L;
    
    private transient DateTimeService dateTimeService;
    private transient DictionaryValidationService dictionaryValidationService;
    
    public SubAwardInvoiceMaintainableImpl() {
        dateTimeService = KcServiceLocator.getService(DateTimeService.class);
        dictionaryValidationService = KNSServiceLocator.getKNSDictionaryValidationService();
    }
    
    @Override
    public void processAfterNew(MaintenanceDocument document, Map<String, String[]> requestParameters) {
        SubAwardAmountReleased invoice = (SubAwardAmountReleased) document.getNoteTarget();
        invoice.setSubAwardId(Long.parseLong(requestParameters.get("subAwardId")[0]));
        invoice.setSubAwardCode(requestParameters.get("subAwardCode")[0]);
        invoice.setSequenceNumber(Integer.parseInt(requestParameters.get("sequenceNumber")[0]));
        invoice.setCreatedDate(getDateTimeService().getCurrentTimestamp());
        invoice.setCreatedBy(GlobalVariables.getUserSession().getPrincipalId());
    }
    
    @Override
    public void prepareForSave() {
        super.prepareForSave();
        SubAwardAmountReleased invoice = (SubAwardAmountReleased) this.getBusinessObject();
        invoice.setDocumentNumber(this.getDocumentNumber());
        GlobalVariables.getMessageMap().addToErrorPath("document.newMaintainableObject");
        getDictionaryValidationService().validateBusinessObject(invoice, true);
        GlobalVariables.getMessageMap().removeFromErrorPath("document.newMaintainableObject");
        if (GlobalVariables.getMessageMap().getErrorCount() == 0) {
            invoice.populateAttachment();
            KNSServiceLocator.getBusinessObjectService().save(invoice);
        }
    }
    
    @Override
    public void doRouteStatusChange(DocumentHeader documentHeader) {
        executeAsLastActionUser(() -> {
            SubAwardAmountReleased invoice = (SubAwardAmountReleased) this.getBusinessObject();
            invoice.setInvoiceStatus(documentHeader.getWorkflowDocument().getStatus().getCode());
            invoice.populateAttachment();
            KNSServiceLocator.getBusinessObjectService().save(invoice);
            return null;
        });
    }

    protected DateTimeService getDateTimeService() {
        if (dateTimeService == null) {
            dateTimeService = KcServiceLocator.getService(DateTimeService.class);
        }
        return dateTimeService;
    }

    public void setDateTimeService(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

    protected DictionaryValidationService getDictionaryValidationService() {
        if (dictionaryValidationService == null) {
            //need kns validation service because the KC documents are still using KNS validations,
            //and to use the KRAD validation requires changing the DD file associated with this BO.
            dictionaryValidationService = KNSServiceLocator.getKNSDictionaryValidationService();
        }
        return dictionaryValidationService;
    }

    public void setDictionaryValidationService(DictionaryValidationService dictionaryValidationService) {
        this.dictionaryValidationService = dictionaryValidationService;
    }
    

}
