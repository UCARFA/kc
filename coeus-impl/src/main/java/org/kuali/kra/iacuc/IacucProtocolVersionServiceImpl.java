/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc;

import org.kuali.kra.iacuc.procedures.IacucProtocolProcedureService;
import org.kuali.kra.iacuc.questionnaire.IacucProtocolModuleQuestionnaireBean;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.kra.protocol.ProtocolVersionServiceImplBase;
import org.kuali.kra.protocol.personnel.ProtocolPersonBase;
import org.kuali.kra.protocol.questionnaire.ProtocolModuleQuestionnaireBeanBase;


/**
 * ProtocolBase Version Service Implementation.
 */
public class IacucProtocolVersionServiceImpl extends ProtocolVersionServiceImplBase implements IacucProtocolVersionService{
    private IacucProtocolProcedureService iacucProtocolProcedureService;
    
    @Override
    protected String getProtocolDocumentTypeHook() {
        return "IacucProtocolDocument";
    }
    
    @Override
    protected ProtocolBase createProtocolNewVersionHook(ProtocolBase protocol) throws Exception {
        IacucProtocol iacucProtocol = (IacucProtocol)protocol;
        iacucProtocol = versioningService.createNewVersion(iacucProtocol);
        setNewProtocolId(iacucProtocol);
        initPersonId(iacucProtocol);
        getIacucProtocolProcedureService().resetAllProtocolStudyProcedures(iacucProtocol);
        return iacucProtocol;
    }

    @Override
    protected ProtocolModuleQuestionnaireBeanBase getNewInstanceProtocolModuleQuestionnaireBeanHook(ProtocolBase protocol) {
        return new IacucProtocolModuleQuestionnaireBean((IacucProtocol) protocol);
    }

    @Override
    protected Class<? extends ProtocolBase> getProtocolBOClassHook() {
        return IacucProtocol.class;
    }

    @Override
    protected ProtocolDocumentBase createNewProtocolDocumentInstanceHook() {
        return new IacucProtocolDocument();
    }

    @Override
    protected String getProtocolSequenceIdHook() {
        return "SEQ_IACUC_PROTOCOL_ID";
    }

    protected String getProtocolPersonSequenceId() {
        return "SEQ_IACUC_PROTOCOL_ID";
    }
    
    public IacucProtocolProcedureService getIacucProtocolProcedureService() {
        return iacucProtocolProcedureService;
    }

    public void setIacucProtocolProcedureService(IacucProtocolProcedureService iacucProtocolProcedureService) {
        this.iacucProtocolProcedureService = iacucProtocolProcedureService;
    }

    /**
     * This method initializes the personId of the person
     * @param protocol
     */
    private void initPersonId(ProtocolBase protocol) {
        for (ProtocolPersonBase person : protocol.getProtocolPersons()) {
            Integer nextPersonId = getSequenceAccessorService().getNextAvailableSequenceNumber(getProtocolPersonSequenceId()).intValue();
            person.setProtocolPersonId(nextPersonId);
        }
    }
}
