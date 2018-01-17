<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>


<div class="tab-container" align="center" id="goalsExpensesDetailsPanel">

	<c:set var="budgetedGoalsAttributes" value="${DataDictionary.AwardSubcontractingBudgetedGoals.attributes}" />
	<c:set var="expenditureDataNotFound" value="${KualiForm.subcontractingExpenditureCategoryAmounts.fresh}" />
	
	<html:hidden property="awardSubcontractingBudgetedGoals.awardNumber" />
	<html:hidden property="awardSubcontractingBudgetedGoals.fresh" />
	
	<h3>
		<span class="subhead-left">
			Budgeted Amounts for Award <c:out value="${KualiForm.awardSubcontractingBudgetedGoals.awardNumber}" />
		</span> 
	</h3>
	
	<table id="goalsExpenses-table" cellpadding="0" cellspacing="0" summary="Goals Expenses Details" style="border-top: 1px solid rgb(153, 153, 153);">
	
		<tr>
			<th><div align="right">Category</div></th>
			<th>Goals</th>
			<th>Expenditures</th>
		</tr>
		
		<tr>
			<td> <div align="right"><label>Large Business</label></div></td>
			<td> <div align="center"> <kul:htmlControlAttribute property="awardSubcontractingBudgetedGoals.largeBusinessGoalAmount" attributeEntry="${budgetedGoalsAttributes.largeBusinessGoalAmount}" styleClass="amount" /></div></td>
			<td> <div align="center">
					<c:if test="${!expenditureDataNotFound}">  
						<fmt:formatNumber value="${KualiForm.subcontractingExpenditureCategoryAmounts.largeBusinessExpenditureAmount}" type="currency" currencySymbol="$" maxFractionDigits="2" />
					</c:if>
				</div>
			</td>
		</tr>
		
		<tr>
			<td> <div align="right"><label>Small Business</label></div></td>
			<td> <div align="center"> <kul:htmlControlAttribute property="awardSubcontractingBudgetedGoals.smallBusinessGoalAmount" attributeEntry="${budgetedGoalsAttributes.smallBusinessGoalAmount}" styleClass="amount" /></div></td>
			<td> <div align="center"> 
					<c:if test="${!expenditureDataNotFound}">
						<fmt:formatNumber value="${KualiForm.subcontractingExpenditureCategoryAmounts.smallBusinessExpenditureAmount}" type="currency" currencySymbol="$" maxFractionDigits="2" />
				    </c:if>
				</div>
			</td>
		</tr>		
		
		<tr>
			<td> <div align="right"><label>Total</label>
				<c:if test="${!readOnly}"> 
					<br/> <html:image property="methodToCall.recalculateBusinessTotals" src='${ConfigProperties.kra.externalizable.images.url}tinybutton-recalculate.gif' styleClass="tinybutton" styleId="recalculateBusinessTotals"/></div></td>
				</c:if>
			<td> <div align="center"> <fmt:formatNumber value="${KualiForm.awardSubcontractingBudgetedGoals.totalBusinessGoalAmount}" type="currency" currencySymbol="$" maxFractionDigits="2" /> </div></td>
			<td> <div align="center">
					<c:if test="${!expenditureDataNotFound}"> 
						<fmt:formatNumber value="${KualiForm.subcontractingExpenditureCategoryAmounts.totalBusinessExpenditureAmount}" type="currency" currencySymbol="$" maxFractionDigits="2" />
				    </c:if>
			     </div>
			</td>
		</tr>
		
		<tr>
			<td> <div align="right"><label>Woman Owned</label></div></td>
			<td> <div align="center"> <kul:htmlControlAttribute property="awardSubcontractingBudgetedGoals.womanOwnedGoalAmount" attributeEntry="${budgetedGoalsAttributes.womanOwnedGoalAmount}" styleClass="amount" /></div></td>
			<td> 
				<div align="center">
					<c:if test="${!expenditureDataNotFound}">
						<fmt:formatNumber value="${KualiForm.subcontractingExpenditureCategoryAmounts.womanOwnedExpenditureAmount}" type="currency" currencySymbol="$" maxFractionDigits="2" />
					</c:if>
				</div>
			</td>
		</tr>
		
		<tr>
			<td> <div align="right"><label>8A Disadvantage</label></div></td>
			<td> <div align="center"> <kul:htmlControlAttribute property="awardSubcontractingBudgetedGoals.eightADisadvantageGoalAmount" attributeEntry="${budgetedGoalsAttributes.eightADisadvantageGoalAmount}" styleClass="amount" /></div></td>
			<td> 
				<div align="center">
					<c:if test="${!expenditureDataNotFound}">
						<fmt:formatNumber value="${KualiForm.subcontractingExpenditureCategoryAmounts.eightADisadvantageExpenditureAmount}" type="currency" currencySymbol="$" maxFractionDigits="2" />
					</c:if>
				</div>
			</td>		
		</tr>
		
		<tr>
			<td> <div align="right"><label>Hub Zone</label></div></td>
			<td> <div align="center"> <kul:htmlControlAttribute property="awardSubcontractingBudgetedGoals.hubZoneGoalAmount" attributeEntry="${budgetedGoalsAttributes.hubZoneGoalAmount}" styleClass="amount" /></div></td>
			<td> 
				<div align="center">
					<c:if test="${!expenditureDataNotFound}">
						<fmt:formatNumber value="${KualiForm.subcontractingExpenditureCategoryAmounts.hubZoneExpenditureAmount}" type="currency" currencySymbol="$" maxFractionDigits="2" />
					</c:if>
				</div>
			</td>		
		</tr>
		
		<tr>
			<td> <div align="right"><label>Veteran Owned</label></div></td>
			<td> <div align="center"> <kul:htmlControlAttribute property="awardSubcontractingBudgetedGoals.veteranOwnedGoalAmount" attributeEntry="${budgetedGoalsAttributes.veteranOwnedGoalAmount}" styleClass="amount" /></div></td>
			<td> 
				<div align="center">
					<c:if test="${!expenditureDataNotFound}">
						<fmt:formatNumber value="${KualiForm.subcontractingExpenditureCategoryAmounts.veteranOwnedExpenditureAmount}" type="currency" currencySymbol="$" maxFractionDigits="2" />
					</c:if>
				</div>
			</td>		
		</tr>
		
		<tr>
			<td> <div align="right"><label>Service Disabled Veteran Owned</label></div></td>
			<td> <div align="center"> <kul:htmlControlAttribute property="awardSubcontractingBudgetedGoals.serviceDisabledVeteranOwnedGoalAmount" attributeEntry="${budgetedGoalsAttributes.serviceDisabledVeteranOwnedGoalAmount}" styleClass="amount" /></div></td>
			<td> 
				<div align="center">
					<c:if test="${!expenditureDataNotFound}">
						<fmt:formatNumber value="${KualiForm.subcontractingExpenditureCategoryAmounts.serviceDisabledVeteranOwnedExpenditureAmount}" type="currency" currencySymbol="$" maxFractionDigits="2" />
					</c:if>
				</div>
			</td>		
		</tr>
		
		<tr>
			<td> <div align="right"><label>Historical Black College</label></div></td>
			<td> <div align="center"> <kul:htmlControlAttribute property="awardSubcontractingBudgetedGoals.historicalBlackCollegeGoalAmount" attributeEntry="${budgetedGoalsAttributes.historicalBlackCollegeGoalAmount}" styleClass="amount" /></div></td>
			<td> 
				<div align="center">
					<c:if test="${!expenditureDataNotFound}">
						<fmt:formatNumber value="${KualiForm.subcontractingExpenditureCategoryAmounts.historicalBlackCollegeExpenditureAmount}" type="currency" currencySymbol="$" maxFractionDigits="2" />
					</c:if>
				</div>
			</td>		
		</tr>	
		
		<tr>
			<td>
				<div align="right">
                	<kul:htmlAttributeLabel attributeEntry="${budgetedGoalsAttributes.comments}" noColon="true"/>
                </div>
            </td>
            <td colspan="2"> 
            	<div align="center">
                	<kul:htmlControlAttribute property="awardSubcontractingBudgetedGoals.comments" attributeEntry="${budgetedGoalsAttributes.comments}" />
                </div> 
            </td>
       </tr>
	
	</table>
</div>

