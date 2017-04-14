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
package org.kuali.kra.subaward.subawardrule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.kuali.coeus.sys.impl.validation.ErrorReporterImpl;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.AwardService;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.subaward.bo.SubAward;
import org.kuali.kra.subaward.bo.SubAwardFundingSource;
import org.kuali.rice.krad.util.GlobalVariables;

public class SubAwardDocumentRuleTest {

	@Test
	public void testProcessAddSubAwardFundingSourceBusinessRules_noFundingAwards() {
		GlobalVariables.clear();
		
		AwardService awardService = mock(AwardService.class);
		when(awardService.getAward(1L)).thenReturn(buildAward(1L, "0001-0001"));
		
		SubAwardDocumentRule rule = new SubAwardDocumentRule();
		rule.setAwardService(awardService);
		
		SubAward subAward = new SubAward();
		boolean result = rule.processAddSubAwardFundingSourceBusinessRules(buildFundingSource(1L), subAward);
		assertTrue(result);
		assertEquals(0, GlobalVariables.getMessageMap().getErrorCount());
	}
	
	@Test
	public void testProcessAddSubAwardFundingSourceBusinessRules_noMatchingFundingAwards() {
		GlobalVariables.clear();
		
		AwardService awardService = mock(AwardService.class);
		when(awardService.getAward(1L)).thenReturn(buildAward(1L, "0001-0001"));
		when(awardService.getAward(2L)).thenReturn(buildAward(2L, "0002-0001"));
		when(awardService.getAward(3L)).thenReturn(buildAward(3L, "0003-0001"));
		
		SubAwardDocumentRule rule = new SubAwardDocumentRule();
		rule.setAwardService(awardService);
		
		SubAward subAward = new SubAward();
		subAward.getSubAwardFundingSourceList().add(buildFundingSource(2L));
		subAward.getSubAwardFundingSourceList().add(buildFundingSource(3L));
		boolean result = rule.processAddSubAwardFundingSourceBusinessRules(buildFundingSource(1L), subAward);
		assertTrue(result);
		assertEquals(0, GlobalVariables.getMessageMap().getErrorCount());
	}
	
	@Test
	public void testProcessAddSubAwardFundingSourceBusinessRules_duplicateAwardIds() {
		GlobalVariables.clear();
		
		AwardService awardService = mock(AwardService.class);
		when(awardService.getAward(1L)).thenReturn(buildAward(1L, "0001-0001"));
		when(awardService.getAward(3L)).thenReturn(buildAward(3L, "0003-0001"));
		
		SubAwardDocumentRule rule = new SubAwardDocumentRule();
		rule.setAwardService(awardService);
		rule.setErrorReporter(new ErrorReporterImpl());
		
		SubAward subAward = new SubAward();
		subAward.getSubAwardFundingSourceList().add(buildFundingSource(1L));
		subAward.getSubAwardFundingSourceList().add(buildFundingSource(3L));
		boolean result = rule.processAddSubAwardFundingSourceBusinessRules(buildFundingSource(1L), subAward);
		assertFalse(result);
		assertEquals(1, GlobalVariables.getMessageMap().getErrorCount());
		assertEquals("0001-0001", GlobalVariables.getMessageMap().getErrorMessages().get(SubAwardDocumentRule.AWARD_NUMBER).get(0).getMessageParameters()[0]);
	}
	
	@Test
	public void testProcessAddSubAwardFundingSourceBusinessRules_duplicateAward_newVersion() {
		GlobalVariables.clear();
		
		AwardService awardService = mock(AwardService.class);
		when(awardService.getAward(1L)).thenReturn(buildAward(1L, "0001-0001"));
		when(awardService.getAward(3L)).thenReturn(buildAward(3L, "0003-0001"));
		when(awardService.getAward(4L)).thenReturn(buildAward(4L, "0001-0001"));
		
		SubAwardDocumentRule rule = new SubAwardDocumentRule();
		rule.setAwardService(awardService);
		rule.setErrorReporter(new ErrorReporterImpl());
		
		SubAward subAward = new SubAward();
		subAward.getSubAwardFundingSourceList().add(buildFundingSource(1L));
		subAward.getSubAwardFundingSourceList().add(buildFundingSource(3L));
		boolean result = rule.processAddSubAwardFundingSourceBusinessRules(buildFundingSource(4L), subAward);
		assertFalse(result);
		assertEquals(1, GlobalVariables.getMessageMap().getErrorCount());
		assertEquals("0001-0001", GlobalVariables.getMessageMap().getErrorMessages().get(SubAwardDocumentRule.AWARD_NUMBER).get(0).getMessageParameters()[0]);
	}
	
	@Test
	public void testProcessAddSubAwardFundingSourceBusinessRules_nullFundingSource() {
		GlobalVariables.clear();
		
		AwardService awardService = mock(AwardService.class);
		
		SubAwardDocumentRule rule = new SubAwardDocumentRule();
		rule.setAwardService(awardService);
		rule.setErrorReporter(new ErrorReporterImpl());
		
		SubAward subAward = new SubAward();
		boolean result = rule.processAddSubAwardFundingSourceBusinessRules(null, subAward);
		assertFalse(result);
		assertEquals(1, GlobalVariables.getMessageMap().getErrorCount());
		assertEquals(KeyConstants.ERROR_REQUIRED_SUBAWARD_FUNDING_SOURCE_AWARD_NUMBER, GlobalVariables.getMessageMap().getErrorMessages().get(SubAwardDocumentRule.AWARD_NUMBER).get(0).getErrorKey());
	}
	
	@Test
	public void testProcessAddSubAwardFundingSourceBusinessRules_missingAward() {
		GlobalVariables.clear();
		
		AwardService awardService = mock(AwardService.class);
		
		SubAwardDocumentRule rule = new SubAwardDocumentRule();
		rule.setAwardService(awardService);
		rule.setErrorReporter(new ErrorReporterImpl());
		
		SubAward subAward = new SubAward();
		boolean result = rule.processAddSubAwardFundingSourceBusinessRules(buildFundingSource(4L), subAward);
		assertFalse(result);
		assertEquals(1, GlobalVariables.getMessageMap().getErrorCount());
		assertEquals(KeyConstants.ERROR_REQUIRED_SUBAWARD_FUNDING_SOURCE_AWARD_NUMBER, GlobalVariables.getMessageMap().getErrorMessages().get(SubAwardDocumentRule.AWARD_NUMBER).get(0).getErrorKey());
	}
	
	@Test
	public void testProcessAddSubAwardFundingSourceBusinessRules_noAwardId() {
		GlobalVariables.clear();
		
		AwardService awardService = mock(AwardService.class);
		
		SubAwardDocumentRule rule = new SubAwardDocumentRule();
		rule.setAwardService(awardService);
		rule.setErrorReporter(new ErrorReporterImpl());
		
		SubAward subAward = new SubAward();
		boolean result = rule.processAddSubAwardFundingSourceBusinessRules(buildFundingSource(null), subAward);
		assertFalse(result);
		assertEquals(1, GlobalVariables.getMessageMap().getErrorCount());
		assertEquals(KeyConstants.ERROR_REQUIRED_SUBAWARD_FUNDING_SOURCE_AWARD_NUMBER, GlobalVariables.getMessageMap().getErrorMessages().get(SubAwardDocumentRule.AWARD_NUMBER).get(0).getErrorKey());
	}
	
	
	private SubAwardFundingSource buildFundingSource(Long awardId) {
		SubAwardFundingSource newFundingSource = new SubAwardFundingSource();
		newFundingSource.setAwardId(awardId);
		return newFundingSource;
	}
	
	private Award buildAward(Long awardId, String awardNumber) {
		Award award = new Award();
		award.setAwardId(awardId);
		award.setAwardNumber(awardNumber);
		return award;
	}
}
