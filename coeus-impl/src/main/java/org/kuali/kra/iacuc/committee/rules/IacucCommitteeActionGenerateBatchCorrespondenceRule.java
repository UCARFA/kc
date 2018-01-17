/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.rules;

import org.kuali.coeus.common.committee.impl.rules.CommitteeActionGenerateBatchCorrespondenceRuleBase;
import org.kuali.kra.iacuc.correspondence.IacucBatchCorrespondence;
import org.kuali.kra.iacuc.correspondence.IacucProtocolCorrespondenceTemplateService;
import org.kuali.kra.iacuc.correspondence.IacucProtocolCorrespondenceType;
import org.kuali.kra.protocol.correspondence.BatchCorrespondenceBase;
import org.kuali.kra.protocol.correspondence.ProtocolCorrespondenceTemplateService;
import org.kuali.kra.protocol.correspondence.ProtocolCorrespondenceTypeBase;

public class IacucCommitteeActionGenerateBatchCorrespondenceRule extends CommitteeActionGenerateBatchCorrespondenceRuleBase {

    @Override
    protected Class<? extends BatchCorrespondenceBase> getBatchCorrespondenceBOClassHook() {
        return IacucBatchCorrespondence.class;
    }

    @Override
    protected Class<? extends ProtocolCorrespondenceTemplateService> getProtocolCorrespondenceTemplateServiceClassHook() {
        return IacucProtocolCorrespondenceTemplateService.class;
    }

    @Override
    protected Class<? extends ProtocolCorrespondenceTypeBase> getProtocolCorrespondenceTypeBOClassHook() {
        return IacucProtocolCorrespondenceType.class;
    }

}
