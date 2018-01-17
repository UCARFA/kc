<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>



	
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<div id="disablingDiv" style="z-index: 998;width: 100%;height: 100%;background: transparent;position:absolute;display: none"></div>
<c:set var="readOnly" value="${not KualiForm.editingMode['modifyBudgets']}" scope="request" />

<c:if test="${KualiForm.editingMode['modifyBudgets']}">
	<c:set var="extraButtons" value="${KualiForm.extraPersonnelButtons}" scope="request"/>
</c:if>

<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="${KualiForm.actionPrefix}Personnel"
	documentTypeName="${KualiForm.docTypeName}"
  	headerDispatch="${KualiForm.headerDispatch}"
  	showTabButtons="true" 
  	headerTabActive="personnel"
  	extraTopButtons="${KualiForm.extraTopButtons}">

   	<div align="right"><kul:help parameterNamespace="KC-AB" parameterDetailType="Document" parameterName="awardBudgetPersonnelHelpUrl" altText="help"/></div>
  	
	<kra-b:budgetExpensesSelectBudgetPeriod />
	<br><br>
    <kra-b:budgetProjectPersonnel/>
	
	<c:set var="action" value="budgetExpensesAction" />
	<c:set var="budgetCategoryTypeCodeKey" value="${KualiForm.document.budget.budgetCategoryTypeCodes[0].key}" />
	<c:set var="budgetCategoryTypeCodeLabel" value="${KualiForm.document.budget.budgetCategoryTypeCodes[0].value}" />
	<c:set var="catCodes" value="0" />
	
	<kra-b:budgetExpenseBudgetOverview transparentBackground="false" defaultOpen="false" /> 
	<kra-b:budgetPersonnelDetail budgetCategoryTypeCodeKey="${budgetCategoryTypeCodeKey}" budgetCategoryTypeCodeLabel="${budgetCategoryTypeCodeLabel}" catCodes="${catCodes}"/>
	
	<kul:panelFooter />
	
	<kul:documentControls 
		transactionalDocument="true" 
		suppressRoutingControls="true" 
		extraButtons="${extraButtons}"  
		viewOnly="${KualiForm.editingMode['viewOnly']}" 
		suppressCancelButton="true"
		/>	
<script language="javascript" src="scripts/kuali_application.js"></script>	
<script language="javascript" src="dwr/interface/JobCodeService.js"></script>
	<script type="text/javascript">
	var kualiForm = document.forms['KualiForm'];
	var kualiElements = kualiForm.elements;	
	</script>
	<script language="javascript">
	window.onload = showBudgetPersonSalaryDetails(${KualiForm.viewDivFlag}, ${KualiForm.personIndex}, ${KualiForm.document.budget.budgetId},0, 0, showBudgetPersonSalaryDetails_Callback);
	</script>

</kul:documentPage>
