<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<c:set var="extraTopButtons" value="${KualiForm.extraTotalsTopButtons}" scope="request"/>
<c:set var="documentTypeName" value="reloadWithoutWarning" scope="request"/>
<c:set target="${KualiForm.documentActions}" property="canReload" value="true"/>
<c:set var="documentTypeName" value="${KualiForm.headerDispatch}"/>
<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="${KualiForm.actionPrefix}SummaryTotals"
	documentTypeName="${KualiForm.docTypeName}"
  	headerDispatch="${documentTypeName}" 
  	headerTabActive="summaryTotals"
  	extraTopButtons="${extraTopButtons}">

  	<div align="right"><kul:help documentTypeName="AwardBudgetDocument" pageName="Summary" /></div>
	<kra-b:awardBudgetSummaryTotals/> 
<kul:documentControls 
		transactionalDocument="false" 
		suppressRoutingControls="true" 
		extraButtons="${extraButtons}"
		suppressCancelButton="true"
/>

</kul:documentPage>
