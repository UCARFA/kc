/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.rules;

import org.kuali.coeus.common.committee.impl.rules.CommitteeActionGenerateBatchCorrespondenceRuleBase;
import org.kuali.kra.irb.correspondence.BatchCorrespondence;
import org.kuali.kra.irb.correspondence.ProtocolCorrespondenceTemplateService;
import org.kuali.kra.irb.correspondence.ProtocolCorrespondenceType;
import org.kuali.kra.protocol.correspondence.BatchCorrespondenceBase;
import org.kuali.kra.protocol.correspondence.ProtocolCorrespondenceTypeBase;

/**
 * 
 * This class implements the business rules for submitting a generate batch correspondence request.
 */
public class CommitteeActionGenerateBatchCorrespondenceRule extends CommitteeActionGenerateBatchCorrespondenceRuleBase {

    @Override
    protected Class<? extends BatchCorrespondenceBase> getBatchCorrespondenceBOClassHook() {
        return BatchCorrespondence.class;
    }

    @Override
    protected Class<? extends org.kuali.kra.protocol.correspondence.ProtocolCorrespondenceTemplateService> getProtocolCorrespondenceTemplateServiceClassHook() {
        return ProtocolCorrespondenceTemplateService.class;
    }

    @Override
    protected Class<? extends ProtocolCorrespondenceTypeBase> getProtocolCorrespondenceTypeBOClassHook() {
        return ProtocolCorrespondenceType.class;
    }

}
