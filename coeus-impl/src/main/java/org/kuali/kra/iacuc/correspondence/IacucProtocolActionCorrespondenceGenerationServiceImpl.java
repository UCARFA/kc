/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.correspondence;

import org.kuali.coeus.common.framework.person.signature.PersonSignatureService;
import org.kuali.kra.iacuc.actions.print.IacucPersonSignatureService;
import org.kuali.kra.protocol.actions.correspondence.ProtocolActionCorrespondenceGenerationServiceImplBase;
import org.kuali.kra.protocol.correspondence.ProtocolCorrespondence;


/**
 * 
 * This class deals with making a protocol attachment from a template based on an action.
 */
public class IacucProtocolActionCorrespondenceGenerationServiceImpl 
    extends ProtocolActionCorrespondenceGenerationServiceImplBase implements IacucProtocolActionCorrespondenceGenerationService {

    private IacucPersonSignatureService personSignatureService;
    
    @Override
    protected ProtocolCorrespondence getNewProtocolCorrespondenceHook() {
        return new IacucProtocolCorrespondence();
    }

    @Override
    protected PersonSignatureService getPersonSignatureServiceHook() {
        return getPersonSignatureService();
    }

    public IacucPersonSignatureService getPersonSignatureService() {
        return personSignatureService;
    }

    public void setPersonSignatureService(IacucPersonSignatureService personSignatureService) {
        this.personSignatureService = personSignatureService;
    }
    
}
