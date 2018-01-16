/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.kim.service.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.kra.protocol.personnel.ProtocolPersonBase;
import org.kuali.rice.core.api.membership.MemberType;
import org.kuali.rice.kim.api.role.RoleMembership;
import org.kuali.rice.kns.kim.role.DerivedRoleTypeServiceBase;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ProtocolPersonnelDerivedRoleTypeServiceImpl extends DerivedRoleTypeServiceBase {

    private static final String PROTOCOL_NUMBER = "protocolNumber";

    protected List<String> requiredAttributes = new ArrayList<>();
    {
        requiredAttributes.add(KcKimAttributes.PROTOCOL);
    }
    
    @Override
    public List<RoleMembership> getRoleMembersFromDerivedRole(String namespaceCode, String roleName,
            Map<String,String> qualification) {
        validateRequiredAttributesAgainstReceived(qualification);

        final String protocolNumber = qualification.get(KcKimAttributes.PROTOCOL);
        final Protocol protocol = getProtocol(protocolNumber);
        
        if (protocol != null && CollectionUtils.isNotEmpty(protocol.getProtocolPersons())) {
            return protocol.getProtocolPersons().stream()
                    .filter(employeeMatchesRole(roleName))
                    .map(person -> RoleMembership.Builder.create(null, null, person.getPersonId(), MemberType.PRINCIPAL, null).build())
                    .collect(Collectors.toList());
        }
        
        return Collections.emptyList();
    }
    
    @Override
    public boolean hasDerivedRole(String principalId, List<String> groupIds, String namespaceCode, String roleName,
            Map<String,String> qualification) {
        validateRequiredAttributesAgainstReceived(qualification);

        final String protocolNumber = qualification.get(KcKimAttributes.PROTOCOL);
        final Protocol protocol = getProtocol(protocolNumber);

        return protocol != null && CollectionUtils.isNotEmpty(protocol.getProtocolPersons()) &&
                protocol.getProtocolPersons().stream()
                .filter(protocolPersonBase -> principalId.equals(protocolPersonBase.getPersonId()))
                .anyMatch(employeeMatchesRole(roleName));
    }

    protected Predicate<? super ProtocolPersonBase> employeeMatchesRole(String roleName) {
        return person -> StringUtils.equals(person.getProtocolPersonRoleId(), roleName)
                && StringUtils.isNotBlank(person.getPersonId());
    }

    private Protocol getProtocol(String protocolNumber) {
        return getBusinessObjectService().findByPrimaryKey(Protocol.class, Collections.singletonMap(PROTOCOL_NUMBER, protocolNumber));
    }

    /*
     * Should override if derivedRoles should not to be cached.
     */
    @Override
    public boolean dynamicRoleMembership(String namespaceCode, String roleName) {
        super.dynamicRoleMembership(namespaceCode, roleName);
        return true;
    }
    
}
