/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.assignagenda;

import org.kuali.coeus.common.framework.print.Printable;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.TaskName;
import org.kuali.kra.irb.actions.ActionHelper;
import org.kuali.kra.irb.actions.genericactions.ProtocolGenericActionBean;

/**
 * This class is really just a "form" for assigning a protocol to an agenda.
 */
public class ProtocolAssignToAgendaBean extends ProtocolGenericActionBean implements org.kuali.kra.protocol.actions.assignagenda.ProtocolAssignToAgendaBean {

    private static final long serialVersionUID = -1671485882883282877L;
    
    private String committeeId = "";
    private String committeName = "";
    private String scheduleDate = "";
    private boolean protocolAssigned;

    private transient ProtocolAssignToAgendaService agendaService;

    /**
     * Constructs a ProtocolAssignToAgendaBean.
     * @param actionHelper a reference back to the parent helper
     */
    public ProtocolAssignToAgendaBean(ActionHelper actionHelper) {
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

    private ProtocolAssignToAgendaService getProtocolAssigntoAgendaService() {
        if (this.agendaService == null){
            this.agendaService = KcServiceLocator.getService(ProtocolAssignToAgendaService.class);
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
                String assignedCommitteeId = getProtocolAssigntoAgendaService().getAssignedCommitteeId(getProtocol());
                if (assignedCommitteeId != null) {
                    this.committeeId = assignedCommitteeId;
                    this.committeName = getProtocolAssigntoAgendaService().getAssignedCommitteeName(getProtocol());
                    this.setComments(getProtocolAssigntoAgendaService().getAssignToAgendaComments(getProtocol()));
                    this.protocolAssigned = getProtocolAssigntoAgendaService().isAssignedToAgenda(getProtocol());
                    this.scheduleDate = getProtocolAssigntoAgendaService().getAssignedScheduleDate(getProtocol());
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
        AssignToAgendaCorrespondence correspondence = new AssignToAgendaCorrespondence();
        return correspondence;
    }
}
