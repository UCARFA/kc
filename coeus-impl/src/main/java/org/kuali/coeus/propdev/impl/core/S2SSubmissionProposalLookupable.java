/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.core;

import org.kuali.rice.core.api.criteria.PredicateFactory;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("s2sSubmissionProposalLookupable")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class S2SSubmissionProposalLookupable extends PropDevLookupableHelperServiceImpl {

	@Override
	protected void modifyCriteria(QueryByCriteria.Builder query) {
		addPredicate(PredicateFactory.isNotNull("s2sAppSubmission.submissionNumber"), query);
	}
	
}
