/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.auth;

import org.kuali.coeus.common.framework.auth.KcWorkflowDocumentAuthorizerBase;
import org.kuali.coeus.common.framework.auth.perm.Permissionable;
import org.kuali.kra.irb.Protocol;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProtocolWorkflowDocumentAuthorizer extends KcWorkflowDocumentAuthorizerBase {

    @Override
    protected Permissionable getPermissionable(String documentId) {
        Map<String, Object> values = new HashMap<String, Object>();
        values.put("documentNumber", documentId);
        Collection<Protocol> protocols = getBusinessObjectService().findMatching(Protocol.class, values);
        if (protocols != null && !protocols.isEmpty()) {
            return protocols.iterator().next();
        } else {
            return null;
        }
    }

}
