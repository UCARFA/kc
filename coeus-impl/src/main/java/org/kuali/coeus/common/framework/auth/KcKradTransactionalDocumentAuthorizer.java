/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.auth;

import org.kuali.rice.kim.api.identity.Person;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.document.TransactionalDocumentAuthorizer;

import java.util.Set;

public interface KcKradTransactionalDocumentAuthorizer extends TransactionalDocumentAuthorizer {
	
	boolean canDeleteDocument(Document document, Person user);

    Set<String> getEditModes(Document document, Person user, Set<String> currentEditModes);
}
