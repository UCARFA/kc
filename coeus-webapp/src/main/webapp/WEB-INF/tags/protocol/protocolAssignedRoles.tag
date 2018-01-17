<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<%@ attribute name="name" required="true" %>

<c:set var="action" value="${name}Permissions" />

<kul:tabTop tabTitle="Assigned Roles" defaultOpen="true">
	<div class="tab-container" align="center">
    	<h3>
    		<span class="subhead-left">Assigned Roles</span>
    		<span class="subhead-right">
    			<kul:help parameterNamespace="KC-IACUC" parameterDetailType="Document" parameterName="protocolAssignedRolesHelp" altText="help"/>
				<html:image property="methodToCall.getPermissionsRoleRights.line${status.index}.anchor${currentTabIndex}"
                	src='${ConfigProperties.kra.externalizable.images.url}tinybutton-viewpermissions.gif' styleClass="tinybutton" alt="View Rights"
                	onclick="permissionsRoleRightsPop('${name}','${KualiForm.formKey}',' ${KualiForm.document.sessionDocument}'); return false;"/>
    		</span>
        </h3>
        
        <table cellpadding="0" cellspacing="0" summary="">
            <c:forEach var="assignedRole" items="${KualiForm.permissionsHelper.assignedRoles}" varStatus="status">
			    <kra-permissions:roleUsers id="${assignedRole.role.name}" roleName="${assignedRole.role.displayName}" userList="${assignedRole.userNames}" />
        	</c:forEach>
        </table>
    </div> 
</kul:tabTop>
