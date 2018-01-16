<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<script language="javascript" src="scripts/kuali_application.js"></script>
<script>
	var roleStates = new Array();
	var rs;
	var hasRole = false;
	<c:forEach var="roleState" items="${KualiForm.permissionsHelper.editRoles.roleStates}" varStatus="status">
        rs = new PermissionsRoleState('${roleState.role.name}', '${roleState.role.displayName}', '${roleState.state}');
        roleStates[roleStates.length] = rs;
        if (rs.getState().toLowerCase() == 'true') {
            hasRole = true;
        }
    </c:forEach>
    if (!hasRole && ${KualiForm.permissionsHelper.unassignedRoleName != null}) {
        roleStates[roleStates.length] = new PermissionsRoleState('${KualiForm.permissionsHelper.unassignedRoleName}', '${KualiForm.permissionsHelper.unassignedRoleDisplayName}', 'true');
    }
        
	updateEditRoles(${KualiForm.permissionsHelper.editRoles.lineNum}, roleStates, '${KualiForm.permissionsHelper.unassignedRoleDisplayName}');
</script>
