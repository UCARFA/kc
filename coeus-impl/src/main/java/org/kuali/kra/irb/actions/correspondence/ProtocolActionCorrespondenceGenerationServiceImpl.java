/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.correspondence;

import org.kuali.coeus.common.framework.person.signature.PersonSignatureService;
import org.kuali.kra.irb.actions.print.IrbPersonSignatureService;
import org.kuali.kra.irb.correspondence.ProtocolCorrespondence;
import org.kuali.kra.protocol.actions.correspondence.ProtocolActionCorrespondenceGenerationServiceImplBase;

/**
 * 
 * This class deals with making a protocol attachment from a template based on an action.
 */
public class ProtocolActionCorrespondenceGenerationServiceImpl extends ProtocolActionCorrespondenceGenerationServiceImplBase implements ProtocolActionCorrespondenceGenerationService {

    private IrbPersonSignatureService personSignatureService;
    
    @Override
    protected ProtocolCorrespondence getNewProtocolCorrespondenceHook() {
        return new ProtocolCorrespondence();
    }

    @Override
    protected PersonSignatureService getPersonSignatureServiceHook() {
        return getPersonSignatureService();
    }

    public IrbPersonSignatureService getPersonSignatureService() {
        return personSignatureService;
    }

    public void setPersonSignatureService(IrbPersonSignatureService personSignatureService) {
        this.personSignatureService = personSignatureService;
    }
}
