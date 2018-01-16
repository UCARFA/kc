/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb;


import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.protocol.ProtocolDocumentBase.ProtocolWorkflowType;
import org.kuali.rice.core.api.exception.RiceRuntimeException;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.kew.engine.RouteContext;
import org.kuali.rice.kew.role.XPathQualifierResolver;
import org.kuali.rice.krad.service.DocumentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * This class is to filter out the 'merged' protocol, and get the attribute if it is not merged protocol
 */
public class ProtocolQualifierResolver extends XPathQualifierResolver {
    @Override
    public List<Map<String,String>> resolve(RouteContext context) {
        List<Map<String,String>> attributeSets = new ArrayList<Map<String,String>>();
        try {
            ProtocolDocument protocolDocument = (ProtocolDocument) KcServiceLocator.getService(DocumentService.class)
                    .getByDocumentHeaderIdSessionless(context.getDocument().getDocumentId() + "");
            if (ProtocolWorkflowType.NORMAL.getName().equals(protocolDocument.getProtocolWorkflowType())) {
                attributeSets = super.resolve(context);
            }
        } catch (WorkflowException e) {
            throw new RiceRuntimeException("Encountered an issue workflow.", e);
        }
        return attributeSets;
    }

}
