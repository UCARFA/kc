<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<c:set var="extraButtons" value="${KualiForm.extraExpensesButtons}" scope="request"/>

<c:if test="${readOnly}">
	<c:set var="extraButtons" value="" scope="request"/>
</c:if>
<c:set var="readOnly" value="${(not KualiForm.editingMode['modifyBudgets'])}" scope="request" />
<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="${KualiForm.actionPrefix}Expenses"
	documentTypeName="${KualiForm.docTypeName}"
  	headerDispatch="${KualiForm.headerDispatch}"
  	showTabButtons="true"
  	headerTabActive="expenses"
  	extraTopButtons="${KualiForm.extraTopButtons}">
  	
	<div align="right"><kul:help parameterNamespace="KC-AB" parameterDetailType="Document" parameterName="awardBudgetNonpersonnelHelpUrl" altText="help"/></div>

		
	<kra-b:budgetExpenses /> 
	<kul:panelFooter />
		
<kul:documentControls 
		transactionalDocument="true" 
		suppressRoutingControls="true" 
		extraButtons="${extraButtons}"
		viewOnly="${KualiForm.editingMode['viewOnly']}"
		suppressCancelButton="true"
/>	

<SCRIPT type="text/javascript">
var kualiForm = document.forms['KualiForm'];
var kualiElements = kualiForm.elements;
</SCRIPT>
<script language="javascript" src="scripts/kuali_application.js"></script>
<script language="javascript" src="dwr/interface/ObjectCodeToBudgetCategoryCodeService.js"></script>
<script language="javascript" src="dwr/interface/BudgetRatesService.js"></script>

</kul:documentPage>
