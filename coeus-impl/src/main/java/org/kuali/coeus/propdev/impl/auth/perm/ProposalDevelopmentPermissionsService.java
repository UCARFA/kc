/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.auth.perm;

import java.util.List;

import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.docperm.ProposalUserRoles;
import org.kuali.coeus.propdev.impl.person.ProposalPerson;
import org.kuali.rice.kim.api.identity.Person;

public interface ProposalDevelopmentPermissionsService {

    public List<ProposalUserRoles> getPermissions(ProposalDevelopmentDocument document);

    public void savePermissions(ProposalDevelopmentDocument document, List<ProposalUserRoles> persistedUsers, List<ProposalUserRoles> newUsers);

    public boolean validateAddPermissions(ProposalDevelopmentDocument document, List<ProposalUserRoles> proposalUserRolesList, ProposalUserRoles proposalUser);

    public boolean validateDeletePermissions(ProposalDevelopmentDocument document, List<ProposalUserRoles> proposalUserRolesList, int index);

    public boolean validateUpdatePermissions(ProposalDevelopmentDocument document, List<ProposalUserRoles> proposalUserRolesList, ProposalUserRoles proposalUser);

    public void processAddPermission(ProposalDevelopmentDocument document, ProposalUserRoles proposalUser);

    public void processDeletePermission(ProposalDevelopmentDocument document, ProposalUserRoles proposalUser);

    public void processUpdatePermission(ProposalDevelopmentDocument document, ProposalUserRoles proposalUser);

    public boolean hasCertificationPermissions(ProposalDevelopmentDocument document, Person user,ProposalPerson proposalPerson);

    public boolean isPiCoiKeyPersonsForcedToDiscloseWithCustomData(DevelopmentProposal developmentProposal);

    public boolean isKeyPersonRoleExempt(ProposalPerson proposalPerson);

    public boolean doesSponsorRequireKeyPersonCertification(ProposalPerson proposalPerson);

    public boolean isRolodexCertificationEnabled();

    public boolean doesPersonRequireCertification(ProposalPerson person);

    }
