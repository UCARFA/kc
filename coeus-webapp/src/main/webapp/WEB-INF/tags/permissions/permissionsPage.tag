<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<%@ attribute name="documentTypeName" required="true" %>
<%@ attribute name="name" required="true" %>

<div align="right"><kul:help documentTypeName="${documentTypeName}" pageName="Permissions" /></div>

<kra-permissions:assignedRoles name="${name}" /> 
<kra-permissions:users name="${name}" />
<kul:panelFooter />	
	
<kul:documentControls transactionalDocument="true" suppressRoutingControls="true" />
<script language="javascript" src="dwr/interface/KraPersonService.js"></script>
<script>loadPersonName('permissionsHelper.newUser.userName', 'fullname');</script>
