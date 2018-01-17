<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="readOnly" value="${(not KualiForm.editingMode['modifyBudgets']) && ( not parentReadOnlyFlag )}" scope="request" />
<c:set var="viewOnly" value="${readOnly}" scope="request" />

<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="${KualiForm.actionPrefix}DistributionAndIncome"
	documentTypeName="${KualiForm.docTypeName}"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="distributionAndIncome"
  	extraTopButtons="${KualiForm.extraTopButtons}"
  	showTabButtons="true">
  	
   	<div align="right"><kul:help parameterNamespace="KC-AB" parameterDetailType="Document" parameterName="awardBudgetDistributionAndIncomeHelpUrl" altText="help"/></div>
	
	<div align="center">
		<kra-b:budgetCostSharing />
		<kra-b:budgetUnrecoveredFandA />
		<kra-b:budgetProjectIncome />
		<kul:panelFooter />
	</div>

	<kul:documentControls 
		transactionalDocument="false"
		suppressRoutingControls="true"
		extraButtonSource="${extraButtonSource}"
		extraButtonProperty="${extraButtonProperty}"
		extraButtonAlt="${extraButtonAlt}"
		viewOnly="${readOnly}"
		suppressCancelButton="true"
		/>

</kul:documentPage>
