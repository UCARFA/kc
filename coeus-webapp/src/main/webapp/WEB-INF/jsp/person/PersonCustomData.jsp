<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<link rel="stylesheet" href="css/jquery/new_kuali.css" type="text/css" />
<link rel="stylesheet" href="css/jquery/kuali-stylesheet.css" type="text/css" />
<link rel="stylesheet" href="css/jquery/jquery.treeview.css" type="text/css" />
<script type="text/javascript" src="scripts/jquery/jquery.treeview.js"></script>
<script type="text/javascript" src="scripts/jquery/CalendarPopup.js"></script>
<script>var jsContextPath = "${pageContext.request.contextPath}";</script>

<c:set var="readOnly" value="${KualiForm.document.documentHeader.workflowDocument.status.code eq 'F'}" scope="request" />

<kra-customdata:customDataTabSpecific
	customAttributeGroups="${KualiForm.document.newMaintainableObject.customDataHelper.customAttributeGroups}" 
	customDataList="${KualiForm.document.newMaintainableObject.businessObject.personCustomDataList}" 
	customDataListPrefix="document.newMaintainableObject.businessObject.personCustomDataList"
	headerAndFooter="false"/>
<kul:csrf />
