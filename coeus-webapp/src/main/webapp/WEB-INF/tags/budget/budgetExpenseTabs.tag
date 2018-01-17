<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="action" value="budgetExpensesAction" />
			
<kra-b:budgetExpenseBudgetOverview isTop="true" /> 
    	   			   	
<c:forEach var="budgetCategoryTypeCode" items="${KualiForm.document.budget.budgetCategoryTypeCodes}" varStatus="catCodes">
	<kra-b:budgetDetailed budgetCategoryTypeCodeKey="${budgetCategoryTypeCode.key}" budgetCategoryTypeCodeLabel="${budgetCategoryTypeCode.value}" catCodes="${catCodes.index}"/>
</c:forEach>
