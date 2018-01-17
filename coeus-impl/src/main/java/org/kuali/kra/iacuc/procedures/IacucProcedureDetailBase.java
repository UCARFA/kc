/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.procedures;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public abstract class IacucProcedureDetailBase extends KcPersistableBusinessObjectBase {
    
    private static final long serialVersionUID = 1L;

    private Integer iacucProtocolStudyGroupHeaderId;
    private boolean studyProcedureActive;
    
    private IacucProtocolStudyGroupBean iacucProtocolStudyGroupBean;
    
    public IacucProcedureDetailBase() { 
    } 
    
    public Integer getIacucProtocolStudyGroupHeaderId() {
        return iacucProtocolStudyGroupHeaderId;
    }


    public void setIacucProtocolStudyGroupHeaderId(Integer iacucProtocolStudyGroupHeaderId) {
        this.iacucProtocolStudyGroupHeaderId = iacucProtocolStudyGroupHeaderId;
    }


    public boolean isStudyProcedureActive() {
        return studyProcedureActive;
    }


    public void setStudyProcedureActive(boolean studyProcedureActive) {
        this.studyProcedureActive = studyProcedureActive;
    }

    public IacucProtocolStudyGroupBean getIacucProtocolStudyGroupBean() {
        return iacucProtocolStudyGroupBean;
    }


    public void setIacucProtocolStudyGroupBean(IacucProtocolStudyGroupBean iacucProtocolStudyGroupBean) {
        this.iacucProtocolStudyGroupBean = iacucProtocolStudyGroupBean;
    }

}
