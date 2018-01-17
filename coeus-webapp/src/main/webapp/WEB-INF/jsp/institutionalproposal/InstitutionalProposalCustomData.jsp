<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="readOnly" value="${KualiForm.editingMode['viewOnly']}" scope="request" />

<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="institutionalProposalCustomData"
	documentTypeName="InstitutionalProposalDocument"
	renderMultipart="false"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="customData">
  	
<div align="right">
   <kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
   <kul:help documentTypeName="${KualiForm.documentTypeName}" pageName="Custom Data" />
</div>

<kra-customdata:customDataTab  />
 
<kul:documentControls transactionalDocument="true" suppressRoutingControls="true" suppressCancelButton="true"/>
<script language="javascript" src="scripts/kuali_application.js"></script>

</kul:documentPage>
