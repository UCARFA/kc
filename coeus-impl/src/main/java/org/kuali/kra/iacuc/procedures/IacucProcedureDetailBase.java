/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
