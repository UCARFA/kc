<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<link rel="stylesheet" href="css/kuali.css" type="text/css" />

<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="subAwardTemplateInformation"
	documentTypeName="SubAwardDocument"
	renderMultipart="true"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="templateInformation">
  	<c:set var="readOnly" value="${not KualiForm.editingMode['fullEntry']}" scope="request" />

<div align="right">
   <kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
   <kul:help documentTypeName="SubAwardDocument" pageName="Template Information" />
</div>

<div id="workarea"> 
<kra-sub:subAwardTemplate/>
<kra-sub:subAwardTemplateContacts/>
<kra-sub:subAwardTemplateTermsAndConditions/>
<kra-sub:subAwardTemplateCompliance/>
<kra-sub:subAwardReport/>
<kra-sub:subAwardAttachment/>
<kul:panelFooter/>
</div>

<kul:documentControls transactionalDocument="true" suppressRoutingControls="true" suppressCancelButton="true" />


</kul:documentPage>
