/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.web.struts.form;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipBase;
import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipExpertiseBase;
import org.kuali.coeus.common.committee.impl.bo.CommitteeScheduleBase;
import org.kuali.coeus.common.committee.impl.document.authorization.CommitteeScheduleTaskBase;
import org.kuali.coeus.common.committee.impl.document.authorization.CommitteeTaskBase;
import org.kuali.coeus.common.committee.impl.service.CommitteeScheduleServiceBase;
import org.kuali.coeus.common.committee.impl.service.CommitteeServiceBase;
import org.kuali.coeus.common.committee.impl.web.struts.form.CommitteeHelperBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.committee.bo.Committee;
import org.kuali.kra.committee.bo.CommitteeMembership;
import org.kuali.kra.committee.bo.CommitteeMembershipExpertise;
import org.kuali.kra.committee.bo.CommitteeSchedule;
import org.kuali.kra.committee.document.authorization.CommitteeScheduleTask;
import org.kuali.kra.committee.service.CommitteeScheduleService;
import org.kuali.kra.committee.service.CommitteeService;
import org.kuali.kra.infrastructure.TaskGroupName;
import org.kuali.kra.irb.correspondence.ProtocolCorrespondenceType;
import org.kuali.kra.protocol.actions.print.CorrespondencePrintOption;
import org.kuali.kra.protocol.correspondence.CorrespondenceTypeModuleIdConstants;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The CommitteeHelper corresponds to the Committee tab web page.
 */
public class CommitteeHelper extends CommitteeHelperBase {
    

    private static final long serialVersionUID = -1690627670210310054L;

    public CommitteeHelper(CommitteeForm committeeForm) {
        super(committeeForm);
    }

    @Override
    protected CommitteeMembershipBase getNewCommitteeMembershipInstanceHook() {
        return new CommitteeMembership();
    }

    @Override
    protected Class<? extends CommitteeScheduleServiceBase> getCommitteeScheduleServiceClassHook() {
        return CommitteeScheduleService.class;
    }

    @Override
    protected Class<? extends CommitteeServiceBase> getCommitteeServiceClassHook() {
        return CommitteeService.class;
    }

    @Override
    protected CommitteeMembershipExpertiseBase getNewCommitteeMembershipExpertiseInstanceHook() {
        return new CommitteeMembershipExpertise();
    }

    @Override
    protected CommitteeScheduleTaskBase getNewCommitteeScheduleTaskInstanceHook(String taskName, CommitteeBase committee, CommitteeScheduleBase committeeSchedule) {
        return new CommitteeScheduleTask(taskName, (Committee) committee, (CommitteeSchedule) committeeSchedule);
    }

    @Override
    protected CommitteeTaskBase getNewCommitteeTaskInstanceHook(String taskName, CommitteeBase committee) {
        // creating an anonymous class to avoid task hierarchy issues
        return new CommitteeTaskBase<Committee>(TaskGroupName.COMMITTEE, taskName, (Committee) committee) {};
    }

    @Override
    protected void initPrintCorrespondences() {
        List<CorrespondencePrintOption> printOptions = new ArrayList<CorrespondencePrintOption>();
        Map<String, Object> values = new HashMap<String, Object>();
        List<ProtocolCorrespondenceType> correspondenceTypes = (List<ProtocolCorrespondenceType>)
                KcServiceLocator.getService(BusinessObjectService.class).findMatching(ProtocolCorrespondenceType.class,values);
        for(ProtocolCorrespondenceType correspondenceType : correspondenceTypes) {
            if(StringUtils.equals(correspondenceType.getModuleId(),CorrespondenceTypeModuleIdConstants.COMMITTEE.getCode())) {
                CorrespondencePrintOption printOption = new CorrespondencePrintOption();
                printOption.setDescription(correspondenceType.getDescription());
                printOption.setLabel(correspondenceType.getDescription());
                printOption.setCorrespondenceId(1L);
                printOption.setProtocolCorrespondenceTemplate(correspondenceType.getDefaultProtocolCorrespondenceTemplate());
                printOptions.add(printOption);
            }
        }
        setCorrespondencesToPrint(printOptions);
    }
}
