/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.kra.common.web.struts.form;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.coeus.common.framework.person.KcPersonService;
import org.kuali.coeus.common.framework.print.PendingReportBean;
import org.kuali.coeus.common.proposal.framework.report.CurrentAndPendingReportService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.institutionalproposal.contacts.InstitutionalProposalPerson;
import org.kuali.kra.institutionalproposal.document.InstitutionalProposalDocument;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.kns.web.ui.ResultRow;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.kuali.kra.common.web.struts.form.ReportHelperBean.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@PrepareForTest(KcServiceLocator.class)
@RunWith(PowerMockRunner.class)
public class ReportHelperBeanTest {

    private static final String DUMMY_PERSON_ID = "dummy";
    private static final String PROPOSAL_NUMBER_1 = "1";
    private static final String PROPOSAL_NUMBER_2 = "2";
    private static final Integer FILTERED_PROPOSAL_TYPE = 100;
    private static final Integer UNFILTERED_PROPOSAL_TYPE = 200;

    @Mock
    private BusinessObjectService businessObjectService;

    @Mock
    private CurrentAndPendingReportService currentAndPendingReportService;

    @Mock
    private KcPersonService kcPersonService;

    @Mock
    private ParameterService parameterService;

    private ReportHelperBean reportHelperBean;

    private List<InstitutionalProposal> ips;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        PowerMockito.mockStatic(KcServiceLocator.class);
        when(KcServiceLocator.getService(eq(BusinessObjectService.class))).thenReturn(businessObjectService);
        when(KcServiceLocator.getService(eq(CurrentAndPendingReportService.class))).thenReturn(currentAndPendingReportService);
        when(KcServiceLocator.getService(eq(KcPersonService.class))).thenReturn(kcPersonService);
        when(KcServiceLocator.getService(eq(ParameterService.class))).thenReturn(parameterService);

        ips = new ArrayList<>();
        ips.add(getInstitutionalProposal(PROPOSAL_NUMBER_1, FILTERED_PROPOSAL_TYPE));
        ips.add(getInstitutionalProposal(PROPOSAL_NUMBER_2, UNFILTERED_PROPOSAL_TYPE));
        List<PendingReportBean> pendingReports = getPendingReportData();
        when(currentAndPendingReportService.loadPendingReportData(anyString())).thenReturn(pendingReports);

        KcPerson targetPerson = new KcPerson() {
            @Override
            public String getPersonId() {
                return DUMMY_PERSON_ID;
            }
        };
        when(kcPersonService.getKcPersonByPersonId(anyString())).thenReturn(targetPerson);
        reportHelperBean = new ReportHelperBean();
        reportHelperBean.setPersonId(targetPerson.getPersonId());

        when(businessObjectService.findMatching(eq(InstitutionalProposal.class), eq(Collections.singletonMap(PROP_NUMBER, PROPOSAL_NUMBER_1))))
                .thenReturn(Collections.singletonList(ips.get(0)));
        when(businessObjectService.findMatching(eq(InstitutionalProposal.class), eq(Collections.singletonMap(PROP_NUMBER, PROPOSAL_NUMBER_2))))
                .thenReturn(Collections.singletonList(ips.get(1)));
    }

    @Test
    public void pendingReportFiltersBasedOnProposalTypeParam() {
        when(parameterService.getParameterValuesAsString(eq(InstitutionalProposalDocument.class), eq(EXCLUDED_CP_PROPOSAL_TYPE_CODES_PARAM)))
                .thenReturn(Collections.singletonList(FILTERED_PROPOSAL_TYPE.toString()));

        List<ResultRow> reports = reportHelperBean.preparePendingReport();
        assertEquals(1, reports.size());
        assertEquals(PROPOSAL_NUMBER_2, reports.get(0).getColumns().get(0).getPropertyValue());
    }

    @Test
    public void pendingReportDoesNotFilterIfParamIsMissing() {
        when(parameterService.getParameterValuesAsString(eq(InstitutionalProposalDocument.class), eq(EXCLUDED_CP_PROPOSAL_TYPE_CODES_PARAM)))
                .thenReturn(Collections.emptyList());

        List<ResultRow> reports = reportHelperBean.preparePendingReport();
        assertEquals(2, reports.size());
    }

    private InstitutionalProposal getInstitutionalProposal(String proposalNumber, Integer proposalTypeCode) {
        InstitutionalProposal ip = new InstitutionalProposal() {
            @Override
            protected void calculateFiscalMonthAndYearFields() {}
        };
        ip.setProposalNumber(proposalNumber);
        ip.setProposalTypeCode(proposalTypeCode);
        ip.setStatusCode(PROP_PENDING_STATUS);
        ip.setProposalSequenceStatus(PROP_SEQ_STATUS);

        InstitutionalProposalPerson ipPerson = new InstitutionalProposalPerson() {
            @Override
            protected void refreshPerson() { }
        };
        ipPerson.setPersonId(DUMMY_PERSON_ID);
        ip.add(ipPerson);

        return ip;
    }

    private List<PendingReportBean> getPendingReportData() {
        return ips.stream()
                .flatMap(ip -> ip.getProjectPersons().stream())
                .map(PendingReportBean::new)
                .collect(Collectors.toList());
    }

}
