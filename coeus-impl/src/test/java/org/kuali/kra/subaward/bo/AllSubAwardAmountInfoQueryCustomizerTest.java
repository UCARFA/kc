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
package org.kuali.kra.subaward.bo;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.stream.Stream;

import org.apache.ojb.broker.query.Criteria;
import org.apache.ojb.broker.query.SelectionCriteria;
import org.junit.Test;

public class AllSubAwardAmountInfoQueryCustomizerTest {

	private static final String LESS_THAN_OR_EQUAL = " <= ";

	@Test
	public void test_buildCriteria() {
		SubAward subAward = new SubAward();
		subAward.setSubAwardCode("1");
		subAward.setSequenceNumber(1);
		
	    AllSubAwardAmountInfoQueryCustomizer customizer = new AllSubAwardAmountInfoQueryCustomizer();
	    Criteria customizedQuery = customizer.buildCriteria(subAward);
	    assertEquals(subAward.getSubAwardCode(), findCriteriaForProperty(AllSubAwardAmountInfoQueryCustomizer.SUB_AWARD_SUB_AWARD_CODE_PATH, customizedQuery).getValue());
	    assertEquals(AllSubAwardAmountInfoQueryCustomizer.ALLOWED_STATUSES, 
	    	findCriteriaForProperty(AllSubAwardAmountInfoQueryCustomizer.SUB_AWARD_SUB_AWARD_SEQUENCE_STATUS_PATH, customizedQuery).getValue());
	    assertEquals(subAward.getSequenceNumber(), findCriteriaForProperty(AllSubAwardAmountInfoQueryCustomizer.SUB_AWARD_SEQUENCE_NUMBER_PATH, customizedQuery).getValue());
	    assertEquals(LESS_THAN_OR_EQUAL, findCriteriaForProperty(AllSubAwardAmountInfoQueryCustomizer.SUB_AWARD_SEQUENCE_NUMBER_PATH, customizedQuery).getClause());
	}
	
	SelectionCriteria findCriteriaForProperty(String propertyName, Criteria crit) {
		return findSelectionCriteria(crit)
			.filter(subCrit -> subCrit.getAttribute().equals(propertyName))
			.findFirst().orElse(null);
	}
	
	Stream<SelectionCriteria> findSelectionCriteria(Object crit) {
		if (crit instanceof SelectionCriteria) {
			return Stream.of((SelectionCriteria)crit);
		} else if (crit instanceof Criteria) {
			return Collections.list(((Criteria)crit).getElements()).stream().flatMap(obj -> findSelectionCriteria(obj));
		} else {
			return Stream.empty();
		}
	}
}
