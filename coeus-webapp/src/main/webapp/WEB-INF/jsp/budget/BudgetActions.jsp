<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<c:set var="readOnly" value="${not KualiForm.editingMode['modifyBudgets']}" scope="request" />
<c:set var="extraButtons" value="${KualiForm.extraActionsButtons}" scope="request"/>
<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="${KualiForm.actionPrefix}Actions"
	documentTypeName="${KualiForm.docTypeName}"
  	headerDispatch="${KualiForm.headerDispatch}"
  	renderMultipart="true"
  	headerTabActive="budgetActions"
  	extraTopButtons="${KualiForm.extraTopButtons}"
  	auditCount="0"
  	showTabButtons="true">
  	
	<div align="right"><kul:help parameterNamespace="KC-AB" parameterDetailType="Document" parameterName="awardBudgetActionsHelpUrl" altText="help"/></div>
	<div align="center">

		<kra-b:budgetPrintForms/>
		<kra-b:budgetJustification top="false"/>
		<kra:dataValidation auditActivated="${KualiForm.auditActivated}" topTab="false" helpParameterNamespace="KC-AB"
							helpParameterName="awardBudgetDataValidationHelpUrl" helpParameterDetailType="Document"/>
		<kul:adHocRecipients />
        <kul:routeLog /> 
		<kul:panelFooter />
	</div>
	
	<kul:documentControls 
		transactionalDocument="false"
		extraButtonSource="${extraButtonSource}"
		extraButtonProperty="${extraButtonProperty}"
		extraButtonAlt="${extraButtonAlt}"
		extraButtons="${extraButtons}"
		viewOnly="${KualiForm.editingMode['viewOnly']}"
		/>

</kul:documentPage>
