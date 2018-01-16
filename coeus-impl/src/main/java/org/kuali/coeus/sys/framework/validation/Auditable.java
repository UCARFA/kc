/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.validation;

import org.kuali.rice.krad.document.Document;

/**
 * Defines the methods required for an object that can be "audited".
 */
public interface Auditable {

    /**
     * Gets whether or not audit has been activated.
     * @return true if audit is activated false if not.
     */
    public boolean isAuditActivated();

    /**
     * 
     * Sets whether or not audit has been activated.
     * @param auditActivated true if audit is activated false if not.
     */
    public void setAuditActivated(boolean auditActivated);

    public Document getDocument();
}
