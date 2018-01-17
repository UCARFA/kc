/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.org;

import org.kuali.coeus.common.framework.org.crrspndnt.OrganizationCorrespondent;
import org.kuali.kra.iacuc.bo.IacucOrganizationCorrespondent;

import java.util.List;

public interface OrganizationService {

    /**
     * This method returns the organization name for a given organization id.
     * @param organizationId identifier for the organization
     * @return The name of the organization identified by this id.
     * null value is returned if organization not found
     */
    String getOrganizationName(String organizationId);

    /**
     * This method returns the organization duns for a given organization id.
     * @param organizationId identifier for the organization
     * @return The duns number identified by this id.
     * null value is returned if organization not found
     */
    String getOrganizationDuns(String organizationId);
    
    /**
     * This method returns the organization
     * Organization data is retrieved based on above organization id.
     * @param organizationId identifier for the organization
     * @return organization
     * null value is returned if organization not found
     */
    Organization getOrganization(String organizationId);
    
    /**
     * This method returns a list of OrganizationCorrespondent
     * objects based on a passed organization id.
     * @param organizationId identifier for the organization
     * @return list of OrganizationCorrespondent objects
     * null value is returned if organization not found
     */
    List<OrganizationCorrespondent> retrieveOrganizationCorrespondentsByOrganizationId(String organizationId);
    
    /**
     * This method returns a list of IacucOrganizationCorrespondent
     * objects based on a passed organization id.
     * @param organizationId identifier for the organization
     * @return list of IacucOrganizationCorrespondent objects
     * null value is returned if organization not found
     */
    List<IacucOrganizationCorrespondent> retrieveIacucOrganizationCorrespondentsByOrganizationId(String organizationId);

}
