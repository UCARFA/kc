<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<%@ attribute name="budgetRate" description="Budget proposal and la rates" required="true"%>
<%@ attribute name="rateClassType" description="rate class type code" required="true"%>
<%@ attribute name="styleClass" description="style class to validate applicable rate " required="true"%>

<c:set var="budgetRatesAttributes" value="${DataDictionary.BudgetRate.attributes}" />
<c:set var="action" value="budgetRates" />
<bean:define id="irateClassType" name="KualiForm" property="${budgetRate}.rateClass.rateClassTypeCode" />
<bean:define id="irateClassCode" name="KualiForm" property="${budgetRate}.rateClass.code" />
<bean:define id="displayRow" name="KualiForm" property="${budgetRate}.displayLocation" />
<bean:define id="fandaRateType" name="KualiForm" property="${budgetRate}.rateType.description" />

<c:set var="finalBudgetProposalRateClassCode" value="${KualiForm.document.finalrateClassCode }"/>


<c:if test="${irateClassType == 'O' && displayRow == 'Yes' && finalBudgetProposalRateClassCode == irateClassCode }">

	<tr>
		<td width="10%" class="${tdClass}">
			<div align=center>
				<span class="copy"> 
					<bean:write name="KualiForm" property="${budgetRate}.rateType.description" />
				</span>
			</div></td>
		<td width="10%" class="${tdClass}">
			<div align=center>
				<span class="copy"><bean:write name="KualiForm" property="${budgetRate}.onOffCampusFlag" /> </span>
			</div></td>
		<td width="10%" class="${tdClass}">
			<div align=center>
				<span class="copy"> <bean:write name="KualiForm" property="${budgetRate}.fiscalYear" /> </span>
			</div></td>

		<td width="10%" class="${tdClass}">
			<div align=center>
				<span class="copy"> <bean:write name="KualiForm" property="${budgetRate}.startDate" /> </span>
			</div></td>
		<td width="10%" class="${tdClass}">
			<div align=center>
				<span class="copy"> <bean:write name="KualiForm" property="${budgetRate}.instituteRate" /> </span>
			</div></td>
		<td width="10%" class="${tdClass}">
			<div align=center>
				<span class="copy"> 
					<kul:htmlControlAttribute property="${budgetRate}.applicableRate" attributeEntry="${budgetRatesAttributes.applicableRate}" readOnly="true" styleClass="${styleClass}" /> 
				</span>
			</div></td>
	</tr>
	<c:set var="rowIndex" value="${rowIndex+1}" />
</c:if>
