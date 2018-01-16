/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.common.framework.compliance.core;

public final class ComplianceConstants {
    
    public static final String NEW_SPECIAL_REVIEW_COMMENT = "A Special Review has been inserted.";
    public static final String PROTO_CORRESP_TYPE_CODE = "protoCorrespTypeCode";
    public static final String IRB_RENEWAL_REMINDER_CORRESP_TYPES = "irb.protocol.renewal.reminder.corresp.types";
    public static final String IACUC_RENEWAL_REMINDER_CORRESP_TYPES = "iacuc.protocol.renewal.reminder.corresp.types";

    private ComplianceConstants() {
        throw new UnsupportedOperationException("do not call");
    }
}
