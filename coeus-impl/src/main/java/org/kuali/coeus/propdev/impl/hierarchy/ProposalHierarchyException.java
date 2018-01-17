/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.hierarchy;

public class ProposalHierarchyException extends RuntimeException {

    private static final long serialVersionUID = -8511067467413187019L;

    public ProposalHierarchyException() {
        super();
    }

    public ProposalHierarchyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProposalHierarchyException(String message) {
        super(message);
    }

    public ProposalHierarchyException(Throwable cause) {
        super(cause);
    }

}
