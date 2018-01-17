/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.customdata;

import org.kuali.coeus.common.framework.custom.attr.CustomAttributeDocValue;
import org.kuali.coeus.common.framework.custom.attr.CustomAttributeDocument;
import org.kuali.kra.infrastructure.TaskName;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.irb.ProtocolForm;
import org.kuali.kra.irb.auth.ProtocolTask;
import org.kuali.kra.protocol.customdata.ProtocolCustomDataHelperBase;

import java.util.List;
import java.util.Map;

/**
 * The CustomDataHelper is used to manage the Custom Data tab web page.
 * It contains the data, forms, and methods needed to render the page.
 */
public class CustomDataHelper extends ProtocolCustomDataHelperBase<CustomAttributeDocValue> { 
    

    private static final long serialVersionUID = 3956588282238741445L;

    /**
     * Constructs a CustomDataHelper.
     * @param form the form
     */
    public CustomDataHelper(ProtocolForm form) {
        super(form);
    }
  
    @Override
    public boolean canModifyCustomData() {
        ProtocolTask task = new ProtocolTask(TaskName.MODIFY_PROTOCOL_OTHERS, (Protocol) getProtocol());
        return getTaskAuthorizationService().isAuthorized(getUserIdentifier(), task);    
    }

    @Override
    protected String getDocumentTypeCode() {
        return ProtocolDocument.DOCUMENT_TYPE_CODE;
    }

    @Override
    protected CustomAttributeDocValue getNewCustomData() {
        return new CustomAttributeDocValue();
    }

    @Override
    public List<CustomAttributeDocValue> getCustomDataList() {
        return ((ProtocolDocument) form.getProtocolDocument()).getCustomDataList();
    }

    @Override
    public Map<String, CustomAttributeDocument> getCustomAttributeDocuments() {
        return form.getProtocolDocument().getCustomAttributeDocuments();
    }
}
