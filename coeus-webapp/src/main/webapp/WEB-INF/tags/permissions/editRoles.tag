<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="roleStateAttributes" value="${DataDictionary.PermissionsRoleState.attributes}" />

<kul:tabTop defaultOpen="true" tabTitle="Roles" tabErrorKey="permissionsUserEditRole*">
	<div class="tab-container" align="center">
		<h3>
    		<span class="subhead-left">Roles</span>
        </h3>	
        <table id="edit-roles-table" cellpadding="0" cellspacing="0" summary="">
             
            <c:forEach var="roleState" items="${KualiForm.permissionsHelper.editRoles.roleStates}" varStatus="status">
                <c:choose>
                    <c:when test="${KualiForm.permissionsHelper.editRoles.principalInvestigator && (roleState.role.displayName == 'Aggregator')}">
                        <c:set var="updateDisabled" value="true" />
                    </c:when>
                    <c:otherwise>
                        <c:set var="updateDisabled" value="false" />
                    </c:otherwise>
                </c:choose>
	          	<tr>
	            	<th width="35%"><div align="right">${roleState.role.displayName}</div></th>
	                <td align="left" valign="middle">
	                	<kul:htmlControlAttribute property="permissionsHelper.editRoles.roleStates[${status.index}].state" 
	                	                          attributeEntry="${roleStateAttributes.state}" disabled="${updateDisabled}" />
					</td>
	        	</tr>
	        	
	        </c:forEach>
        	
        </table>
    </div>
</kul:tabTop>
