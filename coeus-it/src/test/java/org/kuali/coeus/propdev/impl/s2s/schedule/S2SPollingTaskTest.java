/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.s2s.schedule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.propdev.impl.s2s.S2sSubmissionService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * This class tests execution of {@link org.kuali.coeus.propdev.impl.s2s.schedule.S2SPollingTask}
 * 
 */
public class S2SPollingTaskTest extends KcIntegrationTestBase {
	private BusinessObjectService businessObjectService = null;
	private S2sSubmissionService s2sSubmissionService = null;

	@Before
	public void setUp() throws Exception {
		businessObjectService = KcServiceLocator
				.getService(BusinessObjectService.class);
        s2sSubmissionService = KcServiceLocator.getService(S2sSubmissionService.class);
	}

	@After
	public void tearDown() throws Exception {
		businessObjectService = null;
        s2sSubmissionService = null;
	}

	@Test
	public void tests2sPolling() {
		S2SPollingTask s2sPollingTask = new S2SPollingTask();
		s2sPollingTask.setBusinessObjectService(businessObjectService);
		s2sPollingTask.setS2sSubmissionService(s2sSubmissionService);
		s2sPollingTask.setStopPollInterval("4320");
		s2sPollingTask.setMailInterval("20");

		Map<String, String> statusMap = new HashMap<String, String>();
		statusMap.put("1", "Submitted to Grants.Gov");
		statusMap.put("2", "Receiving");
		statusMap.put("3", "Received");
		statusMap.put("4", "Processing");
		s2sPollingTask.setStatusMap(statusMap);

		MailInfo mailInfo = new MailInfo();
		mailInfo.setTo("geot@mit.edu");
		mailInfo.setBcc("");
		mailInfo.setCc("");
		mailInfo.setDunsNumber("");
		mailInfo.setFooter("");
		mailInfo.setSubject("Grants.Gov Submissions");

		List<MailInfo> mailInfoList = new ArrayList<MailInfo>();
		mailInfoList.add(mailInfo);
		s2sPollingTask.setMailInfoList(mailInfoList);
		s2sPollingTask.execute();
        Assert.assertTrue(true);
    }
}
