/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.exception;

import org.kuali.rice.core.api.exception.KualiException;

public class InstitutionalProposalCreationException extends KualiException {

    private static final long serialVersionUID = 1033037690690398384L;

    public InstitutionalProposalCreationException(String message) {
        super(message);
    }
    
    public InstitutionalProposalCreationException(String message, Throwable t) {
        super(message, t);
    }

}
