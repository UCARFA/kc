<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<%@ page language="java" %> 

<c:set var="readOnly" value="true" scope="request" />
<c:set var="hierarchySummaries" value="${KualiForm.hierarchyProposalSummaries}" />

<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="${KualiForm.actionPrefix}ProposalHierarchy"
	documentTypeName="${KualiForm.docTypeName}"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="hierarchy"
  	extraTopButtons="${KualiForm.extraTopButtons}"
  	showTabButtons="false">

<div align="right"><kul:help documentTypeName="BudgetDocument" pageName="Proposal Hierarchy" /></div>
	
<c:forEach var="summary" items="${hierarchySummaries}" varStatus="status">
	<c:set var="proposalNumber" value="${KualiForm.hierarchyProposalSummaries[status.index].proposalNumber}"/>
	<c:choose>
		<c:when test="${status.index eq 0}">
			<kul:tabTop tabTitle="Parent (Proposal # ${proposalNumber})" defaultOpen="false" >
				<kra-ph:proposalSummaryBody proposalNumber="${proposalNumber}" />
			</kul:tabTop>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${summary.synced && summary.budgetSynced}">
					<c:set var="syncLabel" value="Synced" />
				</c:when>
				<c:otherwise>
					<c:set var="syncLabel" value="Not synced" />
				</c:otherwise>
			</c:choose>	
			<kul:tab tabTitle="Child (Proposal # ${proposalNumber})" tabDescription="${syncLabel}" defaultOpen="false" >
				<kra-ph:proposalSummaryBody proposalNumber="${proposalNumber}" />
			</kul:tab>		
		</c:otherwise>
	</c:choose>
</c:forEach>

<kul:panelFooter />
<kul:documentControls transactionalDocument="true" suppressRoutingControls="true" suppressCancelButton="true" />

<script language="javascript" src="scripts/kuali_application.js"></script>
<script language="javascript" src="scripts/proposalHierarchy.js"></script>

</kul:documentPage>
