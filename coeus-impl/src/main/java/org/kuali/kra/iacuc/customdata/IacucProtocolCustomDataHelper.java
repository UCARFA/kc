/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.customdata;

import org.kuali.coeus.common.framework.custom.attr.CustomAttributeDocument;
import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.iacuc.IacucProtocolForm;
import org.kuali.kra.iacuc.auth.IacucProtocolTask;
import org.kuali.kra.infrastructure.TaskName;
import org.kuali.kra.protocol.auth.ProtocolTaskBase;
import org.kuali.kra.protocol.customdata.ProtocolCustomDataHelperBase;

import java.util.List;
import java.util.Map;

/**
 * The CustomDataHelper is used to manage the Custom Data tab web page.
 * It contains the data, forms, and methods needed to render the page.
 */
public class IacucProtocolCustomDataHelper extends ProtocolCustomDataHelperBase<IacucProtocolCustomData> { 


    private static final long serialVersionUID = -5964117436714994219L;

    /**
     * Constructs a CustomDataHelper.
     * @param form the form
     */
    public IacucProtocolCustomDataHelper(IacucProtocolForm form) {
        super(form);
    }

    @Override
    public boolean canModifyCustomData() {
        ProtocolTaskBase task = new IacucProtocolTask(TaskName.MODIFY_IACUC_PROTOCOL_OTHERS, (IacucProtocol) getProtocol());
        return getTaskAuthorizationService().isAuthorized(getUserIdentifier(), task);
    }

    @Override
    protected String getDocumentTypeCode() {
        return IacucProtocolDocument.DOCUMENT_TYPE_CODE;
    }
    
    @Override
    public void prepareCustomData() {
        this.initializePermissions();        
        super.prepareCustomData();
    }

    @Override
    protected IacucProtocolCustomData getNewCustomData() {
        return new IacucProtocolCustomData();
    }
    
    @Override
    public List<IacucProtocolCustomData> getCustomDataList() {
        return ((IacucProtocol)getProtocol()).getIacucProtocolCustomDataList();
    }

    @Override
    public Map<String, CustomAttributeDocument> getCustomAttributeDocuments() {
        return form.getProtocolDocument().getCustomAttributeDocuments();
    }
}
