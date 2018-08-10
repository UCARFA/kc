<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<%--<c:set var="readOnly" value="${!KualiForm.customDataHelper.modifyCustomData}" scope="request" />--%>
<c:set var="readOnly" value="false" scope="request" /><%--temp fix..Permissions have not been established for Award.  Shared tag files.--%>

<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="${KualiForm.actionName}CustomData"
	documentTypeName="${KualiForm.documentTypeName}"
	renderMultipart="false"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="customData"
  	extraTopButtons="${KualiForm.extraTopButtons}" >
  	
  	<c:set var="readOnly" value="${not KualiForm.editingMode['fullEntry']}" scope="request" />

	<c:set var="adminModifyAward" value="${KualiForm.editingMode['adminModifyAward']}" scope="request" />

	<c:if test="${adminModifyAward}">
		<c:set var="readOnly" value="true" scope="request" />
	</c:if>
  	
  	<div align="right">
       <kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
       <kul:help documentTypeName="${KualiForm.documentTypeName}" pageName="Custom Data" />
    </div>

	<kra-customdata:customDataTab />
	<kul:documentControls transactionalDocument="true" suppressRoutingControls="true" suppressCancelButton="true" />

</kul:documentPage>
