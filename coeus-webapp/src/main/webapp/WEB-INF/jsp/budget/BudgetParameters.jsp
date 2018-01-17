<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<c:set var="extraButtons" value="${KualiForm.extraButtons}" scope="request"/>


<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="${KualiForm.actionPrefix}Parameters"
	documentTypeName="${KualiForm.docTypeName}"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="parameters"
  	extraTopButtons="${KualiForm.extraTopButtons}">
  	
	<div align="right"><kul:help parameterNamespace="KC-AB" parameterDetailType="Document" parameterName="awardBudgetParametersHelpUrl" altText="help"/></div>
	<kra-b:awardBudgetParameters />

	<kra-b:budgetPeriodAndTotals /> 
<script language="javascript" src="scripts/kuali_application.js"></script>

<c:if test="${readOnly}">
	<c:set var="extraButtons" value="" scope="request"/>
</c:if>
<kul:documentControls 
		transactionalDocument="true" 
		suppressRoutingControls="true" 
		extraButtons="${extraButtons}"
		viewOnly="${KualiForm.editingMode['viewOnly']}"
		suppressCancelButton="true"
/>
</kul:documentPage>
        	
