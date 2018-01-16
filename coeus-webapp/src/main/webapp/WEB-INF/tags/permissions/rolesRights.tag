<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<kul:tabTop defaultOpen="true" tabTitle="Roles">
    <c:forEach var="role" items="${KualiForm.permissionsHelper.normalRoles}" varStatus="status">    
	   <kra-permissions:roleRights roleName="${role.displayName}" permissions="${role.permissions}" />
    </c:forEach>
</kul:tabTop>
