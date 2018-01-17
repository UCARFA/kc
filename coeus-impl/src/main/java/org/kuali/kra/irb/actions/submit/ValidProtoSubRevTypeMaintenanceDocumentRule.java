/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.submit;

import org.kuali.kra.protocol.actions.submit.ProtocolReviewTypeBase;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionTypeBase;

public class ValidProtoSubRevTypeMaintenanceDocumentRule extends org.kuali.kra.protocol.actions.submit.ValidProtoSubRevTypeMaintenanceDocumentRuleBase {

    @Override
    protected Class<? extends ProtocolSubmissionTypeBase> getProtocolSubmissionTypeBOClassHook() {
        return ProtocolSubmissionType.class;
    }

    @Override
    protected Class<? extends ProtocolReviewTypeBase> getProtocolReviewTypeBOClassHook() {
        return ProtocolReviewType.class;
    }

    @Override
    protected Class<? extends ValidProtoSubRevType> getValidProtoSubRevTypeBOClassHook() {
        return org.kuali.kra.irb.actions.submit.ValidProtoSubRevType.class;
    }

}
