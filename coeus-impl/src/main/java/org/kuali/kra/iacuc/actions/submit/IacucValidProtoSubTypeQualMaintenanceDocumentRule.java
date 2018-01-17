/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.submit;

import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionQualifierTypeBase;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionTypeBase;
import org.kuali.kra.protocol.actions.submit.ValidProtoSubTypeQual;
import org.kuali.kra.protocol.actions.submit.ValidProtoSubTypeQualMaintenanceDocumentRuleBase;

public class IacucValidProtoSubTypeQualMaintenanceDocumentRule extends ValidProtoSubTypeQualMaintenanceDocumentRuleBase {

    @Override
    protected Class<? extends ProtocolSubmissionTypeBase> getProtocolSubmissionTypeBOClassHook() {
        return IacucProtocolSubmissionType.class;
    }

    @Override
    protected Class<? extends ProtocolSubmissionQualifierTypeBase> getProtocolSubmissionQualifierTypeBOClassHook() {
        return IacucProtocolSubmissionQualifierType.class;
    }
    
    @Override
    protected  Class<? extends ValidProtoSubTypeQual> getValidProtoSubTypeQualBOClassHook() {
        return org.kuali.kra.iacuc.actions.submit.IacucValidProtoSubTypeQual.class;
    }   

}
