/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.permissions.impl.web.struts.form;

import org.kuali.rice.krad.document.Document;

/**
 * Every Document Form that requires a Permissions tab web page must
 * implement the PermissionsForm interface.
 */
public interface PermissionsForm {

    /**
     * Get the document associated with the form.
     * @return the form's document
     */
    public Document getDocument();
    
    /**
     * Get the form's PermissionsHelper.
     * @return the form's PermissionsHelper
     */
    public PermissionsHelperBase getPermissionsHelper();
}
