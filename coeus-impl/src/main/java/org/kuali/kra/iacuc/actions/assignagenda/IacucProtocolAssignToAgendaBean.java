/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.assignagenda;

import org.kuali.coeus.common.framework.print.Printable;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.iacuc.actions.IacucActionHelper;
import org.kuali.kra.iacuc.actions.IacucProtocolActionType;
import org.kuali.kra.iacuc.actions.genericactions.IacucProtocolGenericActionBean;
import org.kuali.kra.iacuc.correspondence.IacucProtocolActionsCorrespondence;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.TaskName;
import org.kuali.kra.protocol.actions.assignagenda.ProtocolAssignToAgendaBean;

/**
 * This class is really just a "form" for assigning a protocol to an agenda.
 */
public class IacucProtocolAssignToAgendaBean extends IacucProtocolGenericActionBean implements ProtocolAssignToAgendaBean {

    private static final long serialVersionUID = -1671485882883282877L;
    
    private String committeeId = "";
    private String committeName = "";
    private String scheduleDate = "";
    private boolean protocolAssigned;

    private transient IacucProtocolAssignToAgendaService agendaService;

    /**
     * Constructs a ProtocolAssignToAgendaBean.
     * @param actionHelper a reference back to the parent helper
     */
    public IacucProtocolAssignToAgendaBean(IacucActionHelper actionHelper) {
        super(actionHelper, Constants.PROTOCOL_ASSIGN_TO_AGENDA_ACTION_PROPERTY_KEY);
    }

    @Override
    public void setCommitteeId(String committeeId) {
        this.committeeId = committeeId;
    }


    @Override
    public void setCommitteName(String committeName) {
        this.committeName = committeName;
    }


    @Override
    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }


    @Override
    public void setProtocolAssigned(boolean protocolAssigned) {
        this.protocolAssigned = protocolAssigned;
    }

    private IacucProtocolAssignToAgendaService getProtocolAssignToAgendaService() {
        if (this.agendaService == null){
            this.agendaService = KcServiceLocator.getService(IacucProtocolAssignToAgendaService.class);
        }
        return this.agendaService;
    }


    @Override
    public String getCommitteeId() {
        return committeeId;
    }


    @Override
    public String getCommitteName() {
        return committeName;
    }


    @Override
    public String getScheduleDate() {
        return scheduleDate;
    }


    @Override
    public boolean isProtocolAssigned() {
        return protocolAssigned;
    }

    /**
     * Prepare the Assign to Committee and Schedule for rendering with JSP.
     */
    @Override
    public void prepareView() {
        if (getProtocol() != null && getProtocol().getProtocolNumber() != null) {
            // we refresh assign-to-agenda data (committee name, comments etc) from db only if the user is not 
            // currently working on this task since we do not want to lose user changes
            if( !(TaskName.ASSIGN_TO_AGENDA.equalsIgnoreCase(getActionHelper().getCurrentTask())) ) {
                String assignedCommitteeId = getProtocolAssignToAgendaService().getAssignedCommitteeId(getProtocol());
                if (assignedCommitteeId != null) {
                    this.committeeId = assignedCommitteeId;
                    this.committeName = getProtocolAssignToAgendaService().getAssignedCommitteeName(getProtocol());
                    this.setComments(getProtocolAssignToAgendaService().getAssignToAgendaComments(getProtocol()));
                    this.protocolAssigned = getProtocolAssignToAgendaService().isAssignedToAgenda(getProtocol());
                    this.scheduleDate = getProtocolAssignToAgendaService().getAssignedScheduleDate(getProtocol());
                }
                if(this.getComments() == null) {
                    this.setComments("");
                }
            }
        }
    }
    
    /**
     * 
     * This method returns the appropriate printable for this class
     * @return a Printable
     */
    @Override
    public Printable getCorrespondence() {
        IacucProtocolActionsCorrespondence correspondence = new IacucProtocolActionsCorrespondence(IacucProtocolActionType.ASSIGNED_TO_AGENDA);
        return correspondence;
    }
}
