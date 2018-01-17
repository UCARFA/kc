/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.state;

public final class ProposalStateConstants {

    public static final String IN_PROGRESS = "In Progress";
    public static final String APPROVAL_PENDING = "Approval Pending";
    public static final String REVISION_REQUESTED = "Revisions Requested";

    private ProposalStateConstants() {
        throw new UnsupportedOperationException("do not call");
    }
}
