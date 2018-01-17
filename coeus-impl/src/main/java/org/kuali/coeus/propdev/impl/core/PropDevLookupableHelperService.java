/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.core;

import org.kuali.rice.krad.lookup.Lookupable;
import org.kuali.rice.krad.uif.element.Link;
import org.kuali.rice.krad.uif.field.FieldGroup;

public interface PropDevLookupableHelperService extends Lookupable {

	void buildPropDevViewActionLink(Link actionLink, Object model, String title);
	
	void buildPropDevEditActionLink(Link actionLink, Object model, String title);

	void canModifyProposal(FieldGroup fieldGroup, Object model, ProposalDevelopmentDocument document);
	
}
