<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="institutionalProposalAttachments"
	documentTypeName="InstitutionalProposalDocument"
	renderMultipart="true"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="attachments">
  	<div align="right"></div>

<c:set var="readOnly" value="${not KualiForm.editingMode['fullEntry']}" scope="request" />

<kra-ip:institutionalProposalAttachments />
<kul:panelFooter />
<kul:documentControls transactionalDocument="true" suppressRoutingControls="true" suppressCancelButton="true" />

<script language="javascript" src="scripts/kuali_application.js"></script>
</kul:documentPage>