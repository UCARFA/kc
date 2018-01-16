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
	htmlFormAction="subAwardActions"
	documentTypeName="SubAwardDocument"
	renderMultipart="false"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="subAwardActions"> 	
  	
  	<div align="right">
       <kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
       <kul:help parameterNamespace="KC-SUBAWARD" parameterDetailType="Document" parameterName="subAwardActionsHelpUrl" altText="help"/></div>
  	
<div id="workarea">
<kra-sub:subAwardDataValidation />

<c:if test="${krafn:getParameterValueAsBoolean('KC-SUBAWARD', 'All', 'Enable_Subaward_FDP')}">
	<kra-sub:subAwardPrint />
</c:if>

<kul:adHocRecipients />
<kul:routeLog /> 
<kul:panelFooter />
</div>
<kul:documentControls transactionalDocument="true" viewOnly="${KualiForm.editingMode['viewOnly']}" suppressCancelButton="true" />
<script language="javascript" src="scripts/kuali_application.js"></script>

</kul:documentPage>
