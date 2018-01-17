<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<c:set var="viewOnly" value="${KualiForm.editingMode['viewOnly']}" scope="request" />
<c:if test="${KualiForm.editingMode['modifyCompletedBudgets']}">
	<c:set target="${KualiForm.documentActions}" property="canSave" value="true"/>
</c:if> 
<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="${KualiForm.actionPrefix}Versions"
	documentTypeName="${KualiForm.docTypeName}"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="versions"
  	extraTopButtons="${KualiForm.extraTopButtons}"
  	>
 
        	<div align="right"><kul:help parameterNamespace="KC-AB" parameterDetailType="Document" parameterName="awardBudgetVersionsHelpUrl" altText="help"/></div>

	<kra-b:budgetVersions 
		budgetDocumentVersions="${KualiForm.document.budget.budgetParent.budgets}"
		pathToVersions="document.budget.budgetParent.budgets"
		errorKey="document.parentDocument.budgetDocumentVersion*,document.parentDocument.budgetParent.finalVersionFlag,document.parentDocument.documentDescription"
		requestedStartDateInitial="${KualiForm.document.budget.budgetParent.requestedStartDateInitial}"
		requestedEndDateInitial="${KualiForm.document.budget.budgetParent.requestedEndDateInitial}"
		/>

	<kul:documentControls 
		transactionalDocument="false"
		suppressRoutingControls="true"
		extraButtonSource="${extraButtonSource}"
		extraButtonProperty="${extraButtonProperty}"
		extraButtonAlt="${extraButtonAlt}"
		viewOnly="${viewOnly}"
		suppressCancelButton="true"
		/>

</kul:documentPage>
