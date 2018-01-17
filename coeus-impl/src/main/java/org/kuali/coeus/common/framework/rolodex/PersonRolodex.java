/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.rolodex;

import org.kuali.coeus.common.framework.sponsor.Sponsorable;
import org.kuali.kra.award.home.ContactRole;


public interface PersonRolodex {
    public String getPersonId();
    public Integer getRolodexId();
    public String getFullName();
    public boolean isOtherSignificantContributorFlag();
    public String getProjectRole();
    public ContactRole getContactRole();
    public Sponsorable getParent();
    public String getInvestigatorRoleDescription();
	public boolean isInvestigator();
	public boolean isPrincipalInvestigator();
	public boolean isMultiplePi();
	public String getLastName();
	public Integer getOrdinalPosition();

}
